// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.os.*;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

// Referenced classes of package android.media:
//            MediaRecorder, MediaSyncEvent

public class AudioRecord {
    private class NativeEventHandler extends Handler {

        public void handleMessage(Message message) {
            OnRecordPositionUpdateListener onrecordpositionupdatelistener;
            synchronized(mPositionListenerLock) {
                onrecordpositionupdatelistener = mAudioRecord.mPositionListener;
            }
            message.what;
            JVM INSTR tableswitch 2 3: default 48
        //                       2 82
        //                       3 101;
               goto _L1 _L2 _L3
_L1:
            Log.e("AudioRecord-Java", (new StringBuilder()).append("[ android.media.AudioRecord.NativeEventHandler ] Unknown event type: ").append(message.what).toString());
_L5:
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
_L2:
            if(onrecordpositionupdatelistener != null)
                onrecordpositionupdatelistener.onMarkerReached(mAudioRecord);
            continue; /* Loop/switch isn't completed */
_L3:
            if(onrecordpositionupdatelistener != null)
                onrecordpositionupdatelistener.onPeriodicNotification(mAudioRecord);
            if(true) goto _L5; else goto _L4
_L4:
        }

        private final AudioRecord mAudioRecord;
        final AudioRecord this$0;

        NativeEventHandler(AudioRecord audiorecord1, Looper looper) {
            this$0 = AudioRecord.this;
            super(looper);
            mAudioRecord = audiorecord1;
        }
    }

    public static interface OnRecordPositionUpdateListener {

        public abstract void onMarkerReached(AudioRecord audiorecord);

        public abstract void onPeriodicNotification(AudioRecord audiorecord);
    }


    public AudioRecord(int i, int j, int k, int l, int i1) throws IllegalArgumentException {
        mSampleRate = 22050;
        mChannelCount = 1;
        mChannels = 16;
        mChannelConfiguration = 16;
        mAudioFormat = 2;
        mRecordSource = 0;
        mState = 0;
        mRecordingState = 1;
        mPositionListener = null;
        mEventHandler = null;
        mInitializationLooper = null;
        mNativeBufferSizeInBytes = 0;
        mSessionId = 0;
        mState = 0;
        mRecordingState = 1;
        Looper looper = Looper.myLooper();
        mInitializationLooper = looper;
        if(looper == null)
            mInitializationLooper = Looper.getMainLooper();
        audioParamCheck(i, j, k, l);
        audioBuffSizeCheck(i1);
        int ai[] = new int[1];
        ai[0] = 0;
        int j1 = native_setup(new WeakReference(this), mRecordSource, mSampleRate, mChannels, mAudioFormat, mNativeBufferSizeInBytes, ai);
        if(j1 != 0) {
            loge((new StringBuilder()).append("Error code ").append(j1).append(" when initializing native AudioRecord object.").toString());
        } else {
            mSessionId = ai[0];
            mState = 1;
        }
    }

    private void audioBuffSizeCheck(int i) {
        int j = mChannelCount;
        int k;
        if(mAudioFormat == 3)
            k = 1;
        else
            k = 2;
        if(i % (j * k) != 0 || i < 1) {
            throw new IllegalArgumentException("Invalid audio buffer size.");
        } else {
            mNativeBufferSizeInBytes = i;
            return;
        }
    }

    private void audioParamCheck(int i, int j, int k, int l) {
        if(i < 0 || i > MediaRecorder.getAudioSourceMax())
            throw new IllegalArgumentException("Invalid audio source.");
        mRecordSource = i;
        if(j < 4000 || j > 48000)
            throw new IllegalArgumentException((new StringBuilder()).append(j).append("Hz is not a supported sample rate.").toString());
        mSampleRate = j;
        mChannelConfiguration = k;
        k;
        JVM INSTR lookupswitch 5: default 128
    //                   1: 153
    //                   2: 153
    //                   3: 207
    //                   12: 207
    //                   16: 153;
           goto _L1 _L2 _L2 _L3 _L3 _L2
_L1:
        mChannelCount = 0;
        mChannels = 0;
        mChannelConfiguration = 0;
        throw new IllegalArgumentException("Unsupported channel configuration.");
_L2:
        mChannelCount = 1;
        mChannels = 16;
_L7:
        l;
        JVM INSTR tableswitch 1 3: default 192
    //                   1 221
    //                   2 227
    //                   3 227;
           goto _L4 _L5 _L6 _L6
_L4:
        mAudioFormat = 0;
        throw new IllegalArgumentException("Unsupported sample encoding. Should be ENCODING_PCM_8BIT or ENCODING_PCM_16BIT.");
_L3:
        mChannelCount = 2;
        mChannels = 12;
          goto _L7
_L5:
        mAudioFormat = 2;
_L9:
        return;
_L6:
        mAudioFormat = l;
        if(true) goto _L9; else goto _L8
_L8:
    }

    public static int getMinBufferSize(int i, int j, int k) {
        j;
        JVM INSTR lookupswitch 5: default 52
    //                   1: 64
    //                   2: 64
    //                   3: 83
    //                   12: 83
    //                   16: 64;
           goto _L1 _L2 _L2 _L3 _L3 _L2
_L1:
        int l;
        loge("getMinBufferSize(): Invalid channel configuration.");
        l = -2;
_L7:
        return l;
_L2:
        byte byte0 = 1;
_L5:
        if(k == 2)
            break; /* Loop/switch isn't completed */
        loge("getMinBufferSize(): Invalid audio format.");
        l = -2;
        continue; /* Loop/switch isn't completed */
_L3:
        byte0 = 2;
        if(true) goto _L5; else goto _L4
_L4:
        l = native_get_min_buff_size(i, byte0, k);
        if(l == 0)
            l = -2;
        else
        if(l == -1)
            l = -1;
        if(true) goto _L7; else goto _L6
_L6:
    }

    private static void logd(String s) {
        Log.d("AudioRecord-Java", (new StringBuilder()).append("[ android.media.AudioRecord ] ").append(s).toString());
    }

    private static void loge(String s) {
        Log.e("AudioRecord-Java", (new StringBuilder()).append("[ android.media.AudioRecord ] ").append(s).toString());
    }

    private final native void native_finalize();

    private final native int native_get_marker_pos();

    private static final native int native_get_min_buff_size(int i, int j, int k);

    private final native int native_get_pos_update_period();

    private final native int native_read_in_byte_array(byte abyte0[], int i, int j);

    private final native int native_read_in_direct_buffer(Object obj, int i);

    private final native int native_read_in_short_array(short aword0[], int i, int j);

    private final native void native_release();

    private final native int native_set_marker_pos(int i);

    private final native int native_set_pos_update_period(int i);

    private final native int native_setup(Object obj, int i, int j, int k, int l, int i1, int ai[]);

    private final native int native_start(int i, int j);

    private final native void native_stop();

    private static void postEventFromNative(Object obj, int i, int j, int k, Object obj1) {
        AudioRecord audiorecord;
        audiorecord = (AudioRecord)((WeakReference)obj).get();
        break MISSING_BLOCK_LABEL_12;
        if(audiorecord != null && audiorecord.mEventHandler != null) {
            Message message = audiorecord.mEventHandler.obtainMessage(i, j, k, obj1);
            audiorecord.mEventHandler.sendMessage(message);
        }
        return;
    }

    protected void finalize() {
        native_finalize();
    }

    public int getAudioFormat() {
        return mAudioFormat;
    }

    public int getAudioSessionId() {
        return mSessionId;
    }

    public int getAudioSource() {
        return mRecordSource;
    }

    public int getChannelConfiguration() {
        return mChannelConfiguration;
    }

    public int getChannelCount() {
        return mChannelCount;
    }

    public int getNotificationMarkerPosition() {
        return native_get_marker_pos();
    }

    public int getPositionNotificationPeriod() {
        return native_get_pos_update_period();
    }

    public int getRecordingState() {
        return mRecordingState;
    }

    public int getSampleRate() {
        return mSampleRate;
    }

    public int getState() {
        return mState;
    }

    public int read(ByteBuffer bytebuffer, int i) {
        int j;
        if(mState != 1)
            j = -3;
        else
        if(bytebuffer == null || i < 0)
            j = -2;
        else
            j = native_read_in_direct_buffer(bytebuffer, i);
        return j;
    }

    public int read(byte abyte0[], int i, int j) {
        int k;
        if(mState != 1)
            k = -3;
        else
        if(abyte0 == null || i < 0 || j < 0 || i + j > abyte0.length)
            k = -2;
        else
            k = native_read_in_byte_array(abyte0, i, j);
        return k;
    }

    public int read(short aword0[], int i, int j) {
        int k;
        if(mState != 1)
            k = -3;
        else
        if(aword0 == null || i < 0 || j < 0 || i + j > aword0.length)
            k = -2;
        else
            k = native_read_in_short_array(aword0, i, j);
        return k;
    }

    public void release() {
        try {
            stop();
        }
        catch(IllegalStateException illegalstateexception) { }
        native_release();
        mState = 0;
    }

    public int setNotificationMarkerPosition(int i) {
        return native_set_marker_pos(i);
    }

    public int setPositionNotificationPeriod(int i) {
        return native_set_pos_update_period(i);
    }

    public void setRecordPositionUpdateListener(OnRecordPositionUpdateListener onrecordpositionupdatelistener) {
        setRecordPositionUpdateListener(onrecordpositionupdatelistener, null);
    }

    public void setRecordPositionUpdateListener(OnRecordPositionUpdateListener onrecordpositionupdatelistener, Handler handler) {
        Object obj = mPositionListenerLock;
        obj;
        JVM INSTR monitorenter ;
        mPositionListener = onrecordpositionupdatelistener;
        if(onrecordpositionupdatelistener == null)
            break MISSING_BLOCK_LABEL_67;
        if(handler != null)
            mEventHandler = new NativeEventHandler(this, handler.getLooper());
        else
            mEventHandler = new NativeEventHandler(this, mInitializationLooper);
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
        mEventHandler = null;
          goto _L1
    }

    public void startRecording() throws IllegalStateException {
        if(mState != 1)
            throw new IllegalStateException("startRecording() called on an uninitialized AudioRecord.");
        Object obj = mRecordingStateLock;
        obj;
        JVM INSTR monitorenter ;
        if(native_start(0, 0) == 0)
            mRecordingState = 3;
        return;
    }

    public void startRecording(MediaSyncEvent mediasyncevent) throws IllegalStateException {
        if(mState != 1)
            throw new IllegalStateException("startRecording() called on an uninitialized AudioRecord.");
        Object obj = mRecordingStateLock;
        obj;
        JVM INSTR monitorenter ;
        if(native_start(mediasyncevent.getType(), mediasyncevent.getAudioSessionId()) == 0)
            mRecordingState = 3;
        return;
    }

    public void stop() throws IllegalStateException {
        if(mState != 1)
            throw new IllegalStateException("stop() called on an uninitialized AudioRecord.");
        Object obj = mRecordingStateLock;
        obj;
        JVM INSTR monitorenter ;
        native_stop();
        mRecordingState = 1;
        return;
    }

    private static final int AUDIORECORD_ERROR_SETUP_INVALIDCHANNELMASK = -17;
    private static final int AUDIORECORD_ERROR_SETUP_INVALIDFORMAT = -18;
    private static final int AUDIORECORD_ERROR_SETUP_INVALIDSOURCE = -19;
    private static final int AUDIORECORD_ERROR_SETUP_NATIVEINITFAILED = -20;
    private static final int AUDIORECORD_ERROR_SETUP_ZEROFRAMECOUNT = -16;
    public static final int ERROR = -1;
    public static final int ERROR_BAD_VALUE = -2;
    public static final int ERROR_INVALID_OPERATION = -3;
    private static final int NATIVE_EVENT_MARKER = 2;
    private static final int NATIVE_EVENT_NEW_POS = 3;
    public static final int RECORDSTATE_RECORDING = 3;
    public static final int RECORDSTATE_STOPPED = 1;
    public static final int STATE_INITIALIZED = 1;
    public static final int STATE_UNINITIALIZED = 0;
    public static final int SUCCESS = 0;
    private static final String TAG = "AudioRecord-Java";
    private int mAudioFormat;
    private int mChannelConfiguration;
    private int mChannelCount;
    private int mChannels;
    private NativeEventHandler mEventHandler;
    private Looper mInitializationLooper;
    private int mNativeBufferSizeInBytes;
    private int mNativeCallbackCookie;
    private int mNativeRecorderInJavaObj;
    private OnRecordPositionUpdateListener mPositionListener;
    private final Object mPositionListenerLock = new Object();
    private int mRecordSource;
    private int mRecordingState;
    private final Object mRecordingStateLock = new Object();
    private int mSampleRate;
    private int mSessionId;
    private int mState;


}
