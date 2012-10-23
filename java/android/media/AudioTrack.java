// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.os.*;
import android.util.Log;
import java.lang.ref.WeakReference;

public class AudioTrack {
    private class NativeEventHandlerDelegate {

        Handler getHandler() {
            return mHandler;
        }

        private final AudioTrack mAudioTrack;
        private final Handler mHandler;
        final AudioTrack this$0;


        NativeEventHandlerDelegate(AudioTrack audiotrack1, Handler handler) {
            this$0 = AudioTrack.this;
            super();
            mAudioTrack = audiotrack1;
            final Looper final_looper;
            if(handler != null)
                final_looper = handler.getLooper();
            else
                final_looper = mInitializationLooper;
            if(final_looper != null)
                mHandler = new Handler(AudioTrack.this) {

                    public void handleMessage(Message message) {
                        if(mAudioTrack != null) goto _L2; else goto _L1
_L1:
                        return;
_L2:
                        OnPlaybackPositionUpdateListener onplaybackpositionupdatelistener;
                        synchronized(mPositionListenerLock) {
                            onplaybackpositionupdatelistener = mAudioTrack.mPositionListener;
                        }
                        switch(message.what) {
                        default:
                            Log.e("AudioTrack-Java", (new StringBuilder()).append("[ android.media.AudioTrack.NativeEventHandler ] Unknown event type: ").append(message.what).toString());
                            break;

                        case 3: // '\003'
                            if(onplaybackpositionupdatelistener != null)
                                onplaybackpositionupdatelistener.onMarkerReached(mAudioTrack);
                            break;

                        case 4: // '\004'
                            if(onplaybackpositionupdatelistener != null)
                                onplaybackpositionupdatelistener.onPeriodicNotification(mAudioTrack);
                            break;
                        }
                        continue; /* Loop/switch isn't completed */
                        exception;
                        obj;
                        JVM INSTR monitorexit ;
                        throw exception;
                        if(true) goto _L1; else goto _L3
_L3:
                    }

                    final NativeEventHandlerDelegate this$1;
                    final AudioTrack val$this$0;

                 {
                    this$1 = NativeEventHandlerDelegate.this;
                    this$0 = audiotrack;
                    super(final_looper);
                }
                };
            else
                mHandler = null;
        }
    }

    public static interface OnPlaybackPositionUpdateListener {

        public abstract void onMarkerReached(AudioTrack audiotrack);

        public abstract void onPeriodicNotification(AudioTrack audiotrack);
    }


    public AudioTrack(int i, int j, int k, int l, int i1, int j1) throws IllegalArgumentException {
        this(i, j, k, l, i1, j1, 0);
    }

    public AudioTrack(int i, int j, int k, int l, int i1, int j1, int k1) throws IllegalArgumentException {
        mState = 0;
        mPlayState = 1;
        mPlayStateLock = new Object();
        mPositionListener = null;
        mPositionListenerLock = new Object();
        mNativeBufferSizeInBytes = 0;
        mEventHandlerDelegate = null;
        mInitializationLooper = null;
        mChannelCount = 1;
        mChannels = 4;
        mStreamType = 3;
        mDataLoadMode = 1;
        mChannelConfiguration = 4;
        mAudioFormat = 2;
        mSessionId = 0;
        mState = 0;
        Looper looper = Looper.myLooper();
        mInitializationLooper = looper;
        if(looper == null)
            mInitializationLooper = Looper.getMainLooper();
        audioParamCheck(i, j, k, l, j1);
        audioBuffSizeCheck(i1);
        if(k1 < 0)
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid audio session ID: ").append(k1).toString());
        int ai[] = new int[1];
        ai[0] = k1;
        int l1 = native_setup(new WeakReference(this), mStreamType, mSampleRate, mChannels, mAudioFormat, mNativeBufferSizeInBytes, mDataLoadMode, ai);
        if(l1 != 0) {
            loge((new StringBuilder()).append("Error code ").append(l1).append(" when initializing AudioTrack.").toString());
        } else {
            mSessionId = ai[0];
            if(mDataLoadMode == 0)
                mState = 2;
            else
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

    private void audioParamCheck(int i, int j, int k, int l, int i1) {
        if(i != 4 && i != 3 && i != 2 && i != 1 && i != 0 && i != 5 && i != 6 && i != 8)
            throw new IllegalArgumentException("Invalid stream type.");
        mStreamType = i;
        if(j < 4000 || j > 48000)
            throw new IllegalArgumentException((new StringBuilder()).append(j).append("Hz is not a supported sample rate.").toString());
        mSampleRate = j;
        mChannelConfiguration = k;
        k;
        JVM INSTR lookupswitch 5: default 156
    //                   1: 188
    //                   2: 188
    //                   3: 243
    //                   4: 188
    //                   12: 243;
           goto _L1 _L2 _L2 _L3 _L2 _L3
_L2:
        mChannelCount = 1;
        mChannels = 4;
_L7:
        l;
        JVM INSTR tableswitch 1 3: default 228
    //                   1 273
    //                   2 299
    //                   3 299;
           goto _L4 _L5 _L6 _L6
_L4:
        mAudioFormat = 0;
        throw new IllegalArgumentException("Unsupported sample encoding. Should be ENCODING_PCM_8BIT or ENCODING_PCM_16BIT.");
_L3:
        mChannelCount = 2;
        mChannels = 12;
          goto _L7
_L1:
        if(!isMultichannelConfigSupported(k)) {
            mChannelCount = 0;
            mChannels = 0;
            mChannelConfiguration = 0;
            throw new IllegalArgumentException("Unsupported channel configuration.");
        }
        mChannels = k;
        mChannelCount = Integer.bitCount(k);
          goto _L7
_L5:
        mAudioFormat = 2;
_L8:
        if(i1 != 1 && i1 != 0) {
            throw new IllegalArgumentException("Invalid mode.");
        } else {
            mDataLoadMode = i1;
            return;
        }
_L6:
        mAudioFormat = l;
          goto _L8
    }

    public static float getMaxVolume() {
        return 1.0F;
    }

    public static int getMinBufferSize(int i, int j, int k) {
        int l = -2;
        j;
        JVM INSTR lookupswitch 4: default 48
    //                   2: 64
    //                   3: 85
    //                   4: 64
    //                   12: 85;
           goto _L1 _L2 _L3 _L2 _L3
_L1:
        if((j & 0x4fc) == j) goto _L5; else goto _L4
_L4:
        loge("getMinBufferSize(): Invalid channel configuration.");
_L9:
        return l;
_L2:
        int i1 = 1;
_L7:
        if(k == 2 || k == 3)
            break; /* Loop/switch isn't completed */
        loge("getMinBufferSize(): Invalid audio format.");
        continue; /* Loop/switch isn't completed */
_L3:
        i1 = 2;
        continue; /* Loop/switch isn't completed */
_L5:
        i1 = Integer.bitCount(j);
        if(true) goto _L7; else goto _L6
_L6:
        if(i < 4000 || i > 48000) {
            loge((new StringBuilder()).append("getMinBufferSize(): ").append(i).append("Hz is not a supported sample rate.").toString());
        } else {
            l = native_get_min_buff_size(i, i1, k);
            if(l == -1 || l == 0) {
                loge("getMinBufferSize(): error querying hardware");
                l = -1;
            }
        }
        if(true) goto _L9; else goto _L8
_L8:
    }

    public static float getMinVolume() {
        return 0.0F;
    }

    public static int getNativeOutputSampleRate(int i) {
        return native_get_output_sample_rate(i);
    }

    private static boolean isMultichannelConfigSupported(int i) {
        boolean flag = false;
        if((i & 0x4fc) != i)
            Log.e("AudioTrack-Java", "Channel configuration features unsupported channels");
        else
        if((i & 0xc) != 12)
            Log.e("AudioTrack-Java", "Front channels must be present in multichannel configurations");
        else
        if((i & 0xc0) != 0 && (i & 0xc0) != 192)
            Log.e("AudioTrack-Java", "Rear channels can't be used independently");
        else
            flag = true;
        return flag;
    }

    private static void logd(String s) {
        Log.d("AudioTrack-Java", (new StringBuilder()).append("[ android.media.AudioTrack ] ").append(s).toString());
    }

    private static void loge(String s) {
        Log.e("AudioTrack-Java", (new StringBuilder()).append("[ android.media.AudioTrack ] ").append(s).toString());
    }

    private final native int native_attachAuxEffect(int i);

    private final native void native_finalize();

    private final native void native_flush();

    private final native int native_get_marker_pos();

    private static final native int native_get_min_buff_size(int i, int j, int k);

    private final native int native_get_native_frame_count();

    private static final native int native_get_output_sample_rate(int i);

    private final native int native_get_playback_rate();

    private final native int native_get_pos_update_period();

    private final native int native_get_position();

    private final native int native_get_session_id();

    private final native void native_pause();

    private final native void native_release();

    private final native int native_reload_static();

    private final native void native_setAuxEffectSendLevel(float f);

    private final native void native_setVolume(float f, float f1);

    private final native int native_set_loop(int i, int j, int k);

    private final native int native_set_marker_pos(int i);

    private final native int native_set_playback_rate(int i);

    private final native int native_set_pos_update_period(int i);

    private final native int native_set_position(int i);

    private final native int native_setup(Object obj, int i, int j, int k, int l, int i1, int j1, 
            int ai[]);

    private final native void native_start();

    private final native void native_stop();

    private final native int native_write_byte(byte abyte0[], int i, int j, int k);

    private final native int native_write_short(short aword0[], int i, int j, int k);

    private static void postEventFromNative(Object obj, int i, int j, int k, Object obj1) {
        AudioTrack audiotrack;
        audiotrack = (AudioTrack)((WeakReference)obj).get();
        break MISSING_BLOCK_LABEL_12;
        if(audiotrack != null && audiotrack.mEventHandlerDelegate != null) {
            Message message = audiotrack.mEventHandlerDelegate.getHandler().obtainMessage(i, j, k, obj1);
            audiotrack.mEventHandlerDelegate.getHandler().sendMessage(message);
        }
        return;
    }

    public int attachAuxEffect(int i) {
        int j;
        if(mState != 1)
            j = -3;
        else
            j = native_attachAuxEffect(i);
        return j;
    }

    protected void finalize() {
        native_finalize();
    }

    public void flush() {
        if(mState == 1)
            native_flush();
    }

    public int getAudioFormat() {
        return mAudioFormat;
    }

    public int getAudioSessionId() {
        return mSessionId;
    }

    public int getChannelConfiguration() {
        return mChannelConfiguration;
    }

    public int getChannelCount() {
        return mChannelCount;
    }

    protected int getNativeFrameCount() {
        return native_get_native_frame_count();
    }

    public int getNotificationMarkerPosition() {
        return native_get_marker_pos();
    }

    public int getPlayState() {
        Object obj = mPlayStateLock;
        obj;
        JVM INSTR monitorenter ;
        int i = mPlayState;
        return i;
    }

    public int getPlaybackHeadPosition() {
        return native_get_position();
    }

    public int getPlaybackRate() {
        return native_get_playback_rate();
    }

    public int getPositionNotificationPeriod() {
        return native_get_pos_update_period();
    }

    public int getSampleRate() {
        return mSampleRate;
    }

    public int getState() {
        return mState;
    }

    public int getStreamType() {
        return mStreamType;
    }

    public void pause() throws IllegalStateException {
        if(mState != 1)
            throw new IllegalStateException("pause() called on uninitialized AudioTrack.");
        Object obj = mPlayStateLock;
        obj;
        JVM INSTR monitorenter ;
        native_pause();
        mPlayState = 2;
        return;
    }

    public void play() throws IllegalStateException {
        if(mState != 1)
            throw new IllegalStateException("play() called on uninitialized AudioTrack.");
        Object obj = mPlayStateLock;
        obj;
        JVM INSTR monitorenter ;
        native_start();
        mPlayState = 3;
        return;
    }

    public void release() {
        try {
            stop();
        }
        catch(IllegalStateException illegalstateexception) { }
        native_release();
        mState = 0;
    }

    public int reloadStaticData() {
        int i;
        if(mDataLoadMode == 1)
            i = -3;
        else
            i = native_reload_static();
        return i;
    }

    public int setAuxEffectSendLevel(float f) {
        byte byte0;
        if(mState != 1) {
            byte0 = -3;
        } else {
            if(f < getMinVolume())
                f = getMinVolume();
            if(f > getMaxVolume())
                f = getMaxVolume();
            native_setAuxEffectSendLevel(f);
            byte0 = 0;
        }
        return byte0;
    }

    public int setLoopPoints(int i, int j, int k) {
        int l;
        if(mDataLoadMode == 1)
            l = -3;
        else
            l = native_set_loop(i, j, k);
        return l;
    }

    public int setNotificationMarkerPosition(int i) {
        int j;
        if(mState != 1)
            j = -3;
        else
            j = native_set_marker_pos(i);
        return j;
    }

    public int setPlaybackHeadPosition(int i) {
        Object obj = mPlayStateLock;
        obj;
        JVM INSTR monitorenter ;
        int j;
        if(mPlayState == 1 || mPlayState == 2)
            j = native_set_position(i);
        else
            j = -3;
        return j;
    }

    public void setPlaybackPositionUpdateListener(OnPlaybackPositionUpdateListener onplaybackpositionupdatelistener) {
        setPlaybackPositionUpdateListener(onplaybackpositionupdatelistener, null);
    }

    public void setPlaybackPositionUpdateListener(OnPlaybackPositionUpdateListener onplaybackpositionupdatelistener, Handler handler) {
        synchronized(mPositionListenerLock) {
            mPositionListener = onplaybackpositionupdatelistener;
        }
        if(onplaybackpositionupdatelistener != null)
            mEventHandlerDelegate = new NativeEventHandlerDelegate(this, handler);
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int setPlaybackRate(int i) {
        int j;
        if(mState != 1)
            j = -3;
        else
        if(i <= 0)
            j = -2;
        else
            j = native_set_playback_rate(i);
        return j;
    }

    public int setPositionNotificationPeriod(int i) {
        int j;
        if(mState != 1)
            j = -3;
        else
            j = native_set_pos_update_period(i);
        return j;
    }

    protected void setState(int i) {
        mState = i;
    }

    public int setStereoVolume(float f, float f1) {
        byte byte0;
        if(mState != 1) {
            byte0 = -3;
        } else {
            if(f < getMinVolume())
                f = getMinVolume();
            if(f > getMaxVolume())
                f = getMaxVolume();
            if(f1 < getMinVolume())
                f1 = getMinVolume();
            if(f1 > getMaxVolume())
                f1 = getMaxVolume();
            native_setVolume(f, f1);
            byte0 = 0;
        }
        return byte0;
    }

    public void stop() throws IllegalStateException {
        if(mState != 1)
            throw new IllegalStateException("stop() called on uninitialized AudioTrack.");
        Object obj = mPlayStateLock;
        obj;
        JVM INSTR monitorenter ;
        native_stop();
        mPlayState = 1;
        return;
    }

    public int write(byte abyte0[], int i, int j) {
        if(mDataLoadMode == 0 && mState == 2 && j > 0)
            mState = 1;
        int k;
        if(mState != 1)
            k = -3;
        else
        if(abyte0 == null || i < 0 || j < 0 || i + j > abyte0.length)
            k = -2;
        else
            k = native_write_byte(abyte0, i, j, mAudioFormat);
        return k;
    }

    public int write(short aword0[], int i, int j) {
        if(mDataLoadMode == 0 && mState == 2 && j > 0)
            mState = 1;
        int k;
        if(mState != 1)
            k = -3;
        else
        if(aword0 == null || i < 0 || j < 0 || i + j > aword0.length)
            k = -2;
        else
            k = native_write_short(aword0, i, j, mAudioFormat);
        return k;
    }

    public static final int ERROR = -1;
    public static final int ERROR_BAD_VALUE = -2;
    public static final int ERROR_INVALID_OPERATION = -3;
    private static final int ERROR_NATIVESETUP_AUDIOSYSTEM = -16;
    private static final int ERROR_NATIVESETUP_INVALIDCHANNELMASK = -17;
    private static final int ERROR_NATIVESETUP_INVALIDFORMAT = -18;
    private static final int ERROR_NATIVESETUP_INVALIDSTREAMTYPE = -19;
    private static final int ERROR_NATIVESETUP_NATIVEINITFAILED = -20;
    public static final int MODE_STATIC = 0;
    public static final int MODE_STREAM = 1;
    private static final int NATIVE_EVENT_MARKER = 3;
    private static final int NATIVE_EVENT_NEW_POS = 4;
    public static final int PLAYSTATE_PAUSED = 2;
    public static final int PLAYSTATE_PLAYING = 3;
    public static final int PLAYSTATE_STOPPED = 1;
    public static final int STATE_INITIALIZED = 1;
    public static final int STATE_NO_STATIC_DATA = 2;
    public static final int STATE_UNINITIALIZED = 0;
    public static final int SUCCESS = 0;
    private static final int SUPPORTED_OUT_CHANNELS = 1276;
    private static final String TAG = "AudioTrack-Java";
    private static final float VOLUME_MAX = 1F;
    private static final float VOLUME_MIN;
    private int mAudioFormat;
    private int mChannelConfiguration;
    private int mChannelCount;
    private int mChannels;
    private int mDataLoadMode;
    private NativeEventHandlerDelegate mEventHandlerDelegate;
    private Looper mInitializationLooper;
    private int mJniData;
    private int mNativeBufferSizeInBytes;
    private int mNativeTrackInJavaObj;
    private int mPlayState;
    private final Object mPlayStateLock;
    private OnPlaybackPositionUpdateListener mPositionListener;
    private final Object mPositionListenerLock;
    private int mSampleRate;
    private int mSessionId;
    private int mState;
    private int mStreamType;



}
