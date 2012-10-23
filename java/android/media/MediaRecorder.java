// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.hardware.Camera;
import android.os.*;
import android.util.Log;
import android.view.Surface;
import java.io.*;
import java.lang.ref.WeakReference;

// Referenced classes of package android.media:
//            CamcorderProfile

public class MediaRecorder {
    private class EventHandler extends Handler {

        public void handleMessage(Message message) {
            if(mMediaRecorder.mNativeContext != 0) goto _L2; else goto _L1
_L1:
            Log.w("MediaRecorder", "mediarecorder went away with unhandled events");
_L4:
            return;
_L2:
            switch(message.what) {
            default:
                Log.e("MediaRecorder", (new StringBuilder()).append("Unknown message type ").append(message.what).toString());
                break;

            case 1: // '\001'
            case 100: // 'd'
                if(mOnErrorListener != null)
                    mOnErrorListener.onError(mMediaRecorder, message.arg1, message.arg2);
                break;

            case 2: // '\002'
            case 101: // 'e'
                if(mOnInfoListener != null)
                    mOnInfoListener.onInfo(mMediaRecorder, message.arg1, message.arg2);
                break;
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        private static final int MEDIA_RECORDER_EVENT_ERROR = 1;
        private static final int MEDIA_RECORDER_EVENT_INFO = 2;
        private static final int MEDIA_RECORDER_EVENT_LIST_END = 99;
        private static final int MEDIA_RECORDER_EVENT_LIST_START = 1;
        private static final int MEDIA_RECORDER_TRACK_EVENT_ERROR = 100;
        private static final int MEDIA_RECORDER_TRACK_EVENT_INFO = 101;
        private static final int MEDIA_RECORDER_TRACK_EVENT_LIST_END = 1000;
        private static final int MEDIA_RECORDER_TRACK_EVENT_LIST_START = 100;
        private MediaRecorder mMediaRecorder;
        final MediaRecorder this$0;

        public EventHandler(MediaRecorder mediarecorder1, Looper looper) {
            this$0 = MediaRecorder.this;
            super(looper);
            mMediaRecorder = mediarecorder1;
        }
    }

    public static interface OnInfoListener {

        public abstract void onInfo(MediaRecorder mediarecorder, int i, int j);
    }

    public static interface OnErrorListener {

        public abstract void onError(MediaRecorder mediarecorder, int i, int j);
    }

    public final class VideoEncoder {

        public static final int DEFAULT = 0;
        public static final int H263 = 1;
        public static final int H264 = 2;
        public static final int MPEG_4_SP = 3;
        final MediaRecorder this$0;

        private VideoEncoder() {
            this$0 = MediaRecorder.this;
            super();
        }
    }

    public final class AudioEncoder {

        public static final int AAC = 3;
        public static final int AAC_ELD = 5;
        public static final int AMR_NB = 1;
        public static final int AMR_WB = 2;
        public static final int DEFAULT = 0;
        public static final int HE_AAC = 4;
        final MediaRecorder this$0;

        private AudioEncoder() {
            this$0 = MediaRecorder.this;
            super();
        }
    }

    public final class OutputFormat {

        public static final int AAC_ADIF = 5;
        public static final int AAC_ADTS = 6;
        public static final int AMR_NB = 3;
        public static final int AMR_WB = 4;
        public static final int DEFAULT = 0;
        public static final int MPEG_4 = 2;
        public static final int OUTPUT_FORMAT_MPEG2TS = 8;
        public static final int OUTPUT_FORMAT_RTP_AVP = 7;
        public static final int RAW_AMR = 3;
        public static final int THREE_GPP = 1;
        final MediaRecorder this$0;

        private OutputFormat() {
            this$0 = MediaRecorder.this;
            super();
        }
    }

    public final class VideoSource {

        public static final int CAMERA = 1;
        public static final int DEFAULT = 0;
        public static final int GRALLOC_BUFFER = 2;
        final MediaRecorder this$0;

        private VideoSource() {
            this$0 = MediaRecorder.this;
            super();
        }
    }

    public final class AudioSource {

        public static final int CAMCORDER = 5;
        public static final int DEFAULT = 0;
        public static final int MIC = 1;
        public static final int VOICE_CALL = 4;
        public static final int VOICE_COMMUNICATION = 7;
        public static final int VOICE_DOWNLINK = 3;
        public static final int VOICE_RECOGNITION = 6;
        public static final int VOICE_UPLINK = 2;
        final MediaRecorder this$0;

        private AudioSource() {
            this$0 = MediaRecorder.this;
            super();
        }
    }


    public MediaRecorder() {
        Looper looper = Looper.myLooper();
        if(looper != null) {
            mEventHandler = new EventHandler(this, looper);
        } else {
            Looper looper1 = Looper.getMainLooper();
            if(looper1 != null)
                mEventHandler = new EventHandler(this, looper1);
            else
                mEventHandler = null;
        }
        native_setup(new WeakReference(this));
    }

    private native void _prepare() throws IllegalStateException, IOException;

    private native void _setOutputFile(FileDescriptor filedescriptor, long l, long l1) throws IllegalStateException, IOException;

    public static final int getAudioSourceMax() {
        return 7;
    }

    private final native void native_finalize();

    private static final native void native_init();

    private native void native_reset();

    private final native void native_setup(Object obj) throws IllegalStateException;

    private static void postEventFromNative(Object obj, int i, int j, int k, Object obj1) {
        MediaRecorder mediarecorder;
        mediarecorder = (MediaRecorder)((WeakReference)obj).get();
        break MISSING_BLOCK_LABEL_12;
        if(mediarecorder != null && mediarecorder.mEventHandler != null) {
            Message message = mediarecorder.mEventHandler.obtainMessage(i, j, k, obj1);
            mediarecorder.mEventHandler.sendMessage(message);
        }
        return;
    }

    private native void setParameter(String s);

    protected void finalize() {
        native_finalize();
    }

    public native int getMaxAmplitude() throws IllegalStateException;

    public void prepare() throws IllegalStateException, IOException {
        if(mPath == null) goto _L2; else goto _L1
_L1:
        FileOutputStream fileoutputstream = new FileOutputStream(mPath);
        _setOutputFile(fileoutputstream.getFD(), 0L, 0L);
        fileoutputstream.close();
_L4:
        _prepare();
        return;
        Exception exception;
        exception;
        fileoutputstream.close();
        throw exception;
_L2:
        if(mFd != null)
            _setOutputFile(mFd, 0L, 0L);
        else
            throw new IOException("No valid output file");
        if(true) goto _L4; else goto _L3
_L3:
    }

    public native void release();

    public void reset() {
        native_reset();
        mEventHandler.removeCallbacksAndMessages(null);
    }

    public void setAudioChannels(int i) {
        if(i <= 0) {
            throw new IllegalArgumentException("Number of channels is not positive");
        } else {
            setParameter((new StringBuilder()).append("audio-param-number-of-channels=").append(i).toString());
            return;
        }
    }

    public native void setAudioEncoder(int i) throws IllegalStateException;

    public void setAudioEncodingBitRate(int i) {
        if(i <= 0) {
            throw new IllegalArgumentException("Audio encoding bit rate is not positive");
        } else {
            setParameter((new StringBuilder()).append("audio-param-encoding-bitrate=").append(i).toString());
            return;
        }
    }

    public void setAudioSamplingRate(int i) {
        if(i <= 0) {
            throw new IllegalArgumentException("Audio sampling rate is not positive");
        } else {
            setParameter((new StringBuilder()).append("audio-param-sampling-rate=").append(i).toString());
            return;
        }
    }

    public native void setAudioSource(int i) throws IllegalStateException;

    public void setAuxiliaryOutputFile(FileDescriptor filedescriptor) {
        Log.w("MediaRecorder", "setAuxiliaryOutputFile(FileDescriptor) is no longer supported.");
    }

    public void setAuxiliaryOutputFile(String s) {
        Log.w("MediaRecorder", "setAuxiliaryOutputFile(String) is no longer supported.");
    }

    public native void setCamera(Camera camera);

    public void setCaptureRate(double d) {
        setParameter(String.format("time-lapse-enable=1", new Object[0]));
        int i = (int)(1000D * (1.0D / d));
        Object aobj[] = new Object[1];
        aobj[0] = Integer.valueOf(i);
        setParameter(String.format("time-between-time-lapse-frame-capture=%d", aobj));
    }

    public void setLocation(float f, float f1) {
        int i = (int)(0.5D + (double)(f * 10000F));
        int j = (int)(0.5D + (double)(f1 * 10000F));
        if(i > 0xdbba0 || i < 0xfff24460)
            throw new IllegalArgumentException((new StringBuilder()).append("Latitude: ").append(f).append(" out of range.").toString());
        if(j > 0x1b7740 || j < 0xffe488c0) {
            throw new IllegalArgumentException((new StringBuilder()).append("Longitude: ").append(f1).append(" out of range").toString());
        } else {
            setParameter((new StringBuilder()).append("param-geotag-latitude=").append(i).toString());
            setParameter((new StringBuilder()).append("param-geotag-longitude=").append(j).toString());
            return;
        }
    }

    public native void setMaxDuration(int i) throws IllegalArgumentException;

    public native void setMaxFileSize(long l) throws IllegalArgumentException;

    public void setOnErrorListener(OnErrorListener onerrorlistener) {
        mOnErrorListener = onerrorlistener;
    }

    public void setOnInfoListener(OnInfoListener oninfolistener) {
        mOnInfoListener = oninfolistener;
    }

    public void setOrientationHint(int i) {
        if(i != 0 && i != 90 && i != 180 && i != 270) {
            throw new IllegalArgumentException((new StringBuilder()).append("Unsupported angle: ").append(i).toString());
        } else {
            setParameter((new StringBuilder()).append("video-param-rotation-angle-degrees=").append(i).toString());
            return;
        }
    }

    public void setOutputFile(FileDescriptor filedescriptor) throws IllegalStateException {
        mPath = null;
        mFd = filedescriptor;
    }

    public void setOutputFile(String s) throws IllegalStateException {
        mFd = null;
        mPath = s;
    }

    public native void setOutputFormat(int i) throws IllegalStateException;

    public void setPreviewDisplay(Surface surface) {
        mSurface = surface;
    }

    public void setProfile(CamcorderProfile camcorderprofile) {
        setOutputFormat(camcorderprofile.fileFormat);
        setVideoFrameRate(camcorderprofile.videoFrameRate);
        setVideoSize(camcorderprofile.videoFrameWidth, camcorderprofile.videoFrameHeight);
        setVideoEncodingBitRate(camcorderprofile.videoBitRate);
        setVideoEncoder(camcorderprofile.videoCodec);
        if(camcorderprofile.quality < 1000 || camcorderprofile.quality > 1007) {
            setAudioEncodingBitRate(camcorderprofile.audioBitRate);
            setAudioChannels(camcorderprofile.audioChannels);
            setAudioSamplingRate(camcorderprofile.audioSampleRate);
            setAudioEncoder(camcorderprofile.audioCodec);
        }
    }

    public native void setVideoEncoder(int i) throws IllegalStateException;

    public void setVideoEncodingBitRate(int i) {
        if(i <= 0) {
            throw new IllegalArgumentException("Video encoding bit rate is not positive");
        } else {
            setParameter((new StringBuilder()).append("video-param-encoding-bitrate=").append(i).toString());
            return;
        }
    }

    public native void setVideoFrameRate(int i) throws IllegalStateException;

    public native void setVideoSize(int i, int j) throws IllegalStateException;

    public native void setVideoSource(int i) throws IllegalStateException;

    public native void start() throws IllegalStateException;

    public native void stop() throws IllegalStateException;

    public static final int MEDIA_RECORDER_ERROR_UNKNOWN = 1;
    public static final int MEDIA_RECORDER_INFO_MAX_DURATION_REACHED = 800;
    public static final int MEDIA_RECORDER_INFO_MAX_FILESIZE_REACHED = 801;
    public static final int MEDIA_RECORDER_INFO_UNKNOWN = 1;
    public static final int MEDIA_RECORDER_TRACK_INFO_COMPLETION_STATUS = 1000;
    public static final int MEDIA_RECORDER_TRACK_INFO_DATA_KBYTES = 1009;
    public static final int MEDIA_RECORDER_TRACK_INFO_DURATION_MS = 1003;
    public static final int MEDIA_RECORDER_TRACK_INFO_ENCODED_FRAMES = 1005;
    public static final int MEDIA_RECORDER_TRACK_INFO_INITIAL_DELAY_MS = 1007;
    public static final int MEDIA_RECORDER_TRACK_INFO_LIST_END = 2000;
    public static final int MEDIA_RECORDER_TRACK_INFO_LIST_START = 1000;
    public static final int MEDIA_RECORDER_TRACK_INFO_MAX_CHUNK_DUR_MS = 1004;
    public static final int MEDIA_RECORDER_TRACK_INFO_PROGRESS_IN_TIME = 1001;
    public static final int MEDIA_RECORDER_TRACK_INFO_START_OFFSET_MS = 1008;
    public static final int MEDIA_RECORDER_TRACK_INFO_TYPE = 1002;
    public static final int MEDIA_RECORDER_TRACK_INTER_CHUNK_TIME_MS = 1006;
    private static final String TAG = "MediaRecorder";
    private EventHandler mEventHandler;
    private FileDescriptor mFd;
    private int mNativeContext;
    private OnErrorListener mOnErrorListener;
    private OnInfoListener mOnInfoListener;
    private String mPath;
    private Surface mSurface;

    static  {
        System.loadLibrary("media_jni");
        native_init();
    }



}
