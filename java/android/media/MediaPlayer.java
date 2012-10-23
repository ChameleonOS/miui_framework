// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.*;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.*;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.*;

// Referenced classes of package android.media:
//            Metadata, TimedText

public class MediaPlayer {
    public static interface OnInfoListener {

        public abstract boolean onInfo(MediaPlayer mediaplayer, int i, int j);
    }

    public static interface OnErrorListener {

        public abstract boolean onError(MediaPlayer mediaplayer, int i, int j);
    }

    public static interface OnTimedTextListener {

        public abstract void onTimedText(MediaPlayer mediaplayer, TimedText timedtext);
    }

    public static interface OnVideoSizeChangedListener {

        public abstract void onVideoSizeChanged(MediaPlayer mediaplayer, int i, int j);
    }

    public static interface OnSeekCompleteListener {

        public abstract void onSeekComplete(MediaPlayer mediaplayer);
    }

    public static interface OnBufferingUpdateListener {

        public abstract void onBufferingUpdate(MediaPlayer mediaplayer, int i);
    }

    public static interface OnCompletionListener {

        public abstract void onCompletion(MediaPlayer mediaplayer);
    }

    public static interface OnPreparedListener {

        public abstract void onPrepared(MediaPlayer mediaplayer);
    }

    private class EventHandler extends Handler {

        public void handleMessage(Message message) {
            if(mMediaPlayer.mNativeContext != 0) goto _L2; else goto _L1
_L1:
            Log.w("MediaPlayer", "mediaplayer went away with unhandled events");
_L4:
            return;
_L2:
            switch(message.what) {
            default:
                Log.e("MediaPlayer", (new StringBuilder()).append("Unknown message type ").append(message.what).toString());
                break;

            case 1: // '\001'
                if(mOnPreparedListener != null)
                    mOnPreparedListener.onPrepared(mMediaPlayer);
                break;

            case 2: // '\002'
                if(mOnCompletionListener != null)
                    mOnCompletionListener.onCompletion(mMediaPlayer);
                stayAwake(false);
                break;

            case 3: // '\003'
                if(mOnBufferingUpdateListener != null)
                    mOnBufferingUpdateListener.onBufferingUpdate(mMediaPlayer, message.arg1);
                break;

            case 4: // '\004'
                if(mOnSeekCompleteListener != null)
                    mOnSeekCompleteListener.onSeekComplete(mMediaPlayer);
                break;

            case 5: // '\005'
                if(mOnVideoSizeChangedListener != null)
                    mOnVideoSizeChangedListener.onVideoSizeChanged(mMediaPlayer, message.arg1, message.arg2);
                break;

            case 100: // 'd'
                Log.e("MediaPlayer", (new StringBuilder()).append("Error (").append(message.arg1).append(",").append(message.arg2).append(")").toString());
                boolean flag = false;
                if(mOnErrorListener != null)
                    flag = mOnErrorListener.onError(mMediaPlayer, message.arg1, message.arg2);
                if(mOnCompletionListener != null && !flag)
                    mOnCompletionListener.onCompletion(mMediaPlayer);
                stayAwake(false);
                break;

            case 200: 
                if(message.arg1 != 700)
                    Log.i("MediaPlayer", (new StringBuilder()).append("Info (").append(message.arg1).append(",").append(message.arg2).append(")").toString());
                if(mOnInfoListener != null)
                    mOnInfoListener.onInfo(mMediaPlayer, message.arg1, message.arg2);
                break;

            case 99: // 'c'
                if(mOnTimedTextListener != null)
                    if(message.obj == null)
                        mOnTimedTextListener.onTimedText(mMediaPlayer, null);
                    else
                    if(message.obj instanceof Parcel) {
                        TimedText timedtext = new TimedText((Parcel)message.obj);
                        mOnTimedTextListener.onTimedText(mMediaPlayer, timedtext);
                    }
                break;

            case 0: // '\0'
                break;
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        private MediaPlayer mMediaPlayer;
        final MediaPlayer this$0;

        public EventHandler(MediaPlayer mediaplayer1, Looper looper) {
            this$0 = MediaPlayer.this;
            super(looper);
            mMediaPlayer = mediaplayer1;
        }
    }

    public static class TrackInfo
        implements Parcelable {

        public int describeContents() {
            return 0;
        }

        public String getLanguage() {
            return mLanguage;
        }

        public int getTrackType() {
            return mTrackType;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(mTrackType);
            parcel.writeString(mLanguage);
        }

        static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public TrackInfo createFromParcel(Parcel parcel) {
                return new TrackInfo(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            public TrackInfo[] newArray(int i) {
                return new TrackInfo[i];
            }

            public volatile Object[] newArray(int i) {
                return newArray(i);
            }

        };
        public static final int MEDIA_TRACK_TYPE_AUDIO = 2;
        public static final int MEDIA_TRACK_TYPE_TIMEDTEXT = 3;
        public static final int MEDIA_TRACK_TYPE_UNKNOWN = 0;
        public static final int MEDIA_TRACK_TYPE_VIDEO = 1;
        final String mLanguage;
        final int mTrackType;


        TrackInfo(Parcel parcel) {
            mTrackType = parcel.readInt();
            mLanguage = parcel.readString();
        }
    }


    public MediaPlayer() {
        mWakeLock = null;
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

    private native void _pause() throws IllegalStateException;

    private native void _release();

    private native void _reset();

    private native void _setDataSource(String s, String as[], String as1[]) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _setVideoSurface(Surface surface);

    private native void _start() throws IllegalStateException;

    private native void _stop() throws IllegalStateException;

    private static boolean availableMimeTypeForExternalSource(String s) {
        boolean flag;
        if(s == "application/x-subrip")
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static MediaPlayer create(Context context, int i) {
        MediaPlayer mediaplayer;
        AssetFileDescriptor assetfiledescriptor = context.getResources().openRawResourceFd(i);
        if(assetfiledescriptor == null) {
            mediaplayer = null;
        } else {
            mediaplayer = new MediaPlayer();
            mediaplayer.setDataSource(assetfiledescriptor.getFileDescriptor(), assetfiledescriptor.getStartOffset(), assetfiledescriptor.getLength());
            assetfiledescriptor.close();
            mediaplayer.prepare();
        }
          goto _L1
        IOException ioexception;
        ioexception;
        Log.d("MediaPlayer", "create failed:", ioexception);
_L2:
        mediaplayer = null;
        break; /* Loop/switch isn't completed */
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        Log.d("MediaPlayer", "create failed:", illegalargumentexception);
        continue; /* Loop/switch isn't completed */
        SecurityException securityexception;
        securityexception;
        Log.d("MediaPlayer", "create failed:", securityexception);
        if(true) goto _L2; else goto _L1
_L1:
        return mediaplayer;
    }

    public static MediaPlayer create(Context context, Uri uri) {
        return create(context, uri, null);
    }

    public static MediaPlayer create(Context context, Uri uri, SurfaceHolder surfaceholder) {
        MediaPlayer mediaplayer;
        mediaplayer = new MediaPlayer();
        mediaplayer.setDataSource(context, uri);
        if(surfaceholder != null)
            mediaplayer.setDisplay(surfaceholder);
        mediaplayer.prepare();
_L2:
        return mediaplayer;
        IOException ioexception;
        ioexception;
        Log.d("MediaPlayer", "create failed:", ioexception);
_L3:
        mediaplayer = null;
        if(true) goto _L2; else goto _L1
_L1:
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        Log.d("MediaPlayer", "create failed:", illegalargumentexception);
          goto _L3
        SecurityException securityexception;
        securityexception;
        Log.d("MediaPlayer", "create failed:", securityexception);
          goto _L3
    }

    private native void getParameter(int i, Parcel parcel);

    private boolean isVideoScalingModeSupported(int i) {
        boolean flag = true;
        if(i != flag && i != 2)
            flag = false;
        return flag;
    }

    private final native void native_finalize();

    private final native boolean native_getMetadata(boolean flag, boolean flag1, Parcel parcel);

    private static final native void native_init();

    private final native int native_invoke(Parcel parcel, Parcel parcel1);

    public static native int native_pullBatteryData(Parcel parcel);

    private final native int native_setMetadataFilter(Parcel parcel);

    private final native int native_setRetransmitEndpoint(String s, int i);

    private final native void native_setup(Object obj);

    private static void postEventFromNative(Object obj, int i, int j, int k, Object obj1) {
        MediaPlayer mediaplayer = (MediaPlayer)((WeakReference)obj).get();
        if(mediaplayer != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(i == 200 && j == 2)
            mediaplayer.start();
        if(mediaplayer.mEventHandler != null) {
            Message message = mediaplayer.mEventHandler.obtainMessage(i, j, k, obj1);
            mediaplayer.mEventHandler.sendMessage(message);
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void selectOrDeselectTrack(int i, boolean flag) throws IllegalStateException {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        byte byte0;
        parcel.writeInterfaceToken("android.media.IMediaPlayer");
        if(!flag)
            break MISSING_BLOCK_LABEL_50;
        byte0 = 4;
_L1:
        parcel.writeInt(byte0);
        parcel.writeInt(i);
        invoke(parcel, parcel1);
        parcel.recycle();
        parcel1.recycle();
        return;
        byte0 = 5;
          goto _L1
        Exception exception;
        exception;
        parcel.recycle();
        parcel1.recycle();
        throw exception;
    }

    private void setDataSource(String s, String as[], String as1[]) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        File file = new File(s);
        if(file.exists()) {
            FileInputStream fileinputstream = new FileInputStream(file);
            setDataSource(fileinputstream.getFD());
            fileinputstream.close();
        } else {
            _setDataSource(s, as, as1);
        }
    }

    private void stayAwake(boolean flag) {
        if(mWakeLock == null) goto _L2; else goto _L1
_L1:
        if(!flag || mWakeLock.isHeld()) goto _L4; else goto _L3
_L3:
        mWakeLock.acquire();
_L2:
        mStayAwake = flag;
        updateSurfaceScreenOn();
        return;
_L4:
        if(!flag && mWakeLock.isHeld())
            mWakeLock.release();
        if(true) goto _L2; else goto _L5
_L5:
    }

    private void updateSurfaceScreenOn() {
        if(mSurfaceHolder != null) {
            SurfaceHolder surfaceholder = mSurfaceHolder;
            boolean flag;
            if(mScreenOnWhilePlaying && mStayAwake)
                flag = true;
            else
                flag = false;
            surfaceholder.setKeepScreenOn(flag);
        }
    }

    public void addTimedTextSource(Context context, Uri uri, String s) throws IOException, IllegalArgumentException, IllegalStateException {
        String s1 = uri.getScheme();
        if(s1 != null && !s1.equals("file")) goto _L2; else goto _L1
_L1:
        addTimedTextSource(uri.getPath(), s);
_L8:
        return;
_L2:
        AssetFileDescriptor assetfiledescriptor = null;
        AssetFileDescriptor assetfiledescriptor1 = context.getContentResolver().openAssetFileDescriptor(uri, "r");
        assetfiledescriptor = assetfiledescriptor1;
        if(assetfiledescriptor != null)
            break; /* Loop/switch isn't completed */
        if(assetfiledescriptor == null)
            continue; /* Loop/switch isn't completed */
_L5:
        assetfiledescriptor.close();
        if(true) goto _L4; else goto _L3
_L4:
        break; /* Loop/switch isn't completed */
_L3:
        addTimedTextSource(assetfiledescriptor.getFileDescriptor(), s);
        if(assetfiledescriptor == null) goto _L6; else goto _L5
_L6:
        break; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        if(assetfiledescriptor != null)
            assetfiledescriptor.close();
        throw exception;
        SecurityException securityexception;
        securityexception;
        if(assetfiledescriptor == null) goto _L7; else goto _L5
_L7:
        break; /* Loop/switch isn't completed */
        IOException ioexception;
        ioexception;
        if(assetfiledescriptor == null) goto _L8; else goto _L5
    }

    public void addTimedTextSource(FileDescriptor filedescriptor, long l, long l1, String s) throws IllegalArgumentException, IllegalStateException {
        Parcel parcel;
        Parcel parcel1;
        if(!availableMimeTypeForExternalSource(s))
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal mimeType for timed text source: ").append(s).toString());
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.media.IMediaPlayer");
        parcel.writeInt(3);
        parcel.writeFileDescriptor(filedescriptor);
        parcel.writeLong(l);
        parcel.writeLong(l1);
        parcel.writeString(s);
        invoke(parcel, parcel1);
        parcel.recycle();
        parcel1.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        parcel1.recycle();
        throw exception;
    }

    public void addTimedTextSource(FileDescriptor filedescriptor, String s) throws IllegalArgumentException, IllegalStateException {
        addTimedTextSource(filedescriptor, 0L, 0x7ffffffffffffffL, s);
    }

    public void addTimedTextSource(String s, String s1) throws IOException, IllegalArgumentException, IllegalStateException {
        if(!availableMimeTypeForExternalSource(s1))
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal mimeType for timed text source: ").append(s1).toString());
        File file = new File(s);
        if(file.exists()) {
            FileInputStream fileinputstream = new FileInputStream(file);
            addTimedTextSource(fileinputstream.getFD(), s1);
            fileinputstream.close();
            return;
        } else {
            throw new IOException(s);
        }
    }

    public native void attachAuxEffect(int i);

    public void deselectTrack(int i) throws IllegalStateException {
        selectOrDeselectTrack(i, false);
    }

    protected void finalize() {
        native_finalize();
    }

    public native int getAudioSessionId();

    public native int getCurrentPosition();

    public native int getDuration();

    public native Bitmap getFrameAt(int i) throws IllegalStateException;

    public int getIntParameter(int i) {
        Parcel parcel = Parcel.obtain();
        getParameter(i, parcel);
        int j = parcel.readInt();
        parcel.recycle();
        return j;
    }

    public Metadata getMetadata(boolean flag, boolean flag1) {
        Parcel parcel;
        Metadata metadata;
        parcel = Parcel.obtain();
        metadata = new Metadata();
        if(native_getMetadata(flag, flag1, parcel)) goto _L2; else goto _L1
_L1:
        parcel.recycle();
        metadata = null;
_L4:
        return metadata;
_L2:
        if(!metadata.parse(parcel)) {
            parcel.recycle();
            metadata = null;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public Parcel getParcelParameter(int i) {
        Parcel parcel = Parcel.obtain();
        getParameter(i, parcel);
        return parcel;
    }

    public String getStringParameter(int i) {
        Parcel parcel = Parcel.obtain();
        getParameter(i, parcel);
        String s = parcel.readString();
        parcel.recycle();
        return s;
    }

    public TrackInfo[] getTrackInfo() throws IllegalStateException {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        TrackInfo atrackinfo[];
        parcel.writeInterfaceToken("android.media.IMediaPlayer");
        parcel.writeInt(1);
        invoke(parcel, parcel1);
        atrackinfo = (TrackInfo[])parcel1.createTypedArray(TrackInfo.CREATOR);
        parcel.recycle();
        parcel1.recycle();
        return atrackinfo;
        Exception exception;
        exception;
        parcel.recycle();
        parcel1.recycle();
        throw exception;
    }

    public native int getVideoHeight();

    public native int getVideoWidth();

    public void invoke(Parcel parcel, Parcel parcel1) {
        int i = native_invoke(parcel, parcel1);
        parcel1.setDataPosition(0);
        if(i != 0)
            throw new RuntimeException((new StringBuilder()).append("failure code: ").append(i).toString());
        else
            return;
    }

    public native boolean isLooping();

    public native boolean isPlaying();

    public Parcel newRequest() {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.media.IMediaPlayer");
        return parcel;
    }

    public void pause() throws IllegalStateException {
        stayAwake(false);
        _pause();
    }

    public native void prepare() throws IOException, IllegalStateException;

    public native void prepareAsync() throws IllegalStateException;

    public void release() {
        stayAwake(false);
        updateSurfaceScreenOn();
        mOnPreparedListener = null;
        mOnBufferingUpdateListener = null;
        mOnCompletionListener = null;
        mOnSeekCompleteListener = null;
        mOnErrorListener = null;
        mOnInfoListener = null;
        mOnVideoSizeChangedListener = null;
        mOnTimedTextListener = null;
        _release();
    }

    public void reset() {
        stayAwake(false);
        _reset();
        mEventHandler.removeCallbacksAndMessages(null);
    }

    public native void seekTo(int i) throws IllegalStateException;

    public void selectTrack(int i) throws IllegalStateException {
        selectOrDeselectTrack(i, true);
    }

    public native void setAudioSessionId(int i) throws IllegalArgumentException, IllegalStateException;

    public native void setAudioStreamType(int i);

    public native void setAuxEffectSendLevel(float f);

    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        setDataSource(context, uri, ((Map) (null)));
    }

    public void setDataSource(Context context, Uri uri, Map map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        String s = uri.getScheme();
        if(s != null && !s.equals("file")) goto _L2; else goto _L1
_L1:
        setDataSource(uri.getPath());
_L6:
        return;
_L2:
        AssetFileDescriptor assetfiledescriptor = null;
        AssetFileDescriptor assetfiledescriptor1 = context.getContentResolver().openAssetFileDescriptor(uri, "r");
        assetfiledescriptor = assetfiledescriptor1;
        if(assetfiledescriptor != null) goto _L4; else goto _L3
_L3:
        if(assetfiledescriptor == null) goto _L6; else goto _L5
_L5:
        assetfiledescriptor.close();
        break; /* Loop/switch isn't completed */
_L4:
        if(assetfiledescriptor.getDeclaredLength() < 0L)
            setDataSource(assetfiledescriptor.getFileDescriptor());
        else
            setDataSource(assetfiledescriptor.getFileDescriptor(), assetfiledescriptor.getStartOffset(), assetfiledescriptor.getDeclaredLength());
        continue; /* Loop/switch isn't completed */
        SecurityException securityexception;
        securityexception;
        if(assetfiledescriptor == null) goto _L8; else goto _L7
_L7:
        assetfiledescriptor.close();
_L8:
        Log.d("MediaPlayer", "Couldn't open file on client side, trying server side");
        setDataSource(uri.toString(), map);
        break; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        if(assetfiledescriptor != null)
            assetfiledescriptor.close();
        throw exception;
        IOException ioexception;
        ioexception;
        if(assetfiledescriptor == null) goto _L8; else goto _L7
        if(assetfiledescriptor == null) goto _L6; else goto _L5
    }

    public void setDataSource(FileDescriptor filedescriptor) throws IOException, IllegalArgumentException, IllegalStateException {
        setDataSource(filedescriptor, 0L, 0x7ffffffffffffffL);
    }

    public native void setDataSource(FileDescriptor filedescriptor, long l, long l1) throws IOException, IllegalArgumentException, IllegalStateException;

    public void setDataSource(String s) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        setDataSource(s, ((String []) (null)), ((String []) (null)));
    }

    public void setDataSource(String s, Map map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        String as[] = null;
        String as1[] = null;
        if(map != null) {
            as = new String[map.size()];
            as1 = new String[map.size()];
            int i = 0;
            for(Iterator iterator = map.entrySet().iterator(); iterator.hasNext();) {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                as[i] = (String)entry.getKey();
                as1[i] = (String)entry.getValue();
                i++;
            }

        }
        setDataSource(s, as, as1);
    }

    public void setDisplay(SurfaceHolder surfaceholder) {
        mSurfaceHolder = surfaceholder;
        Surface surface;
        if(surfaceholder != null)
            surface = surfaceholder.getSurface();
        else
            surface = null;
        _setVideoSurface(surface);
        updateSurfaceScreenOn();
    }

    public native void setLooping(boolean flag);

    public int setMetadataFilter(Set set, Set set1) {
        Parcel parcel = newRequest();
        int i = parcel.dataSize() + 4 * (1 + (1 + set.size()) + set1.size());
        if(parcel.dataCapacity() < i)
            parcel.setDataCapacity(i);
        parcel.writeInt(set.size());
        for(Iterator iterator = set.iterator(); iterator.hasNext(); parcel.writeInt(((Integer)iterator.next()).intValue()));
        parcel.writeInt(set1.size());
        for(Iterator iterator1 = set1.iterator(); iterator1.hasNext(); parcel.writeInt(((Integer)iterator1.next()).intValue()));
        return native_setMetadataFilter(parcel);
    }

    public native void setNextMediaPlayer(MediaPlayer mediaplayer);

    public void setOnBufferingUpdateListener(OnBufferingUpdateListener onbufferingupdatelistener) {
        mOnBufferingUpdateListener = onbufferingupdatelistener;
    }

    public void setOnCompletionListener(OnCompletionListener oncompletionlistener) {
        mOnCompletionListener = oncompletionlistener;
    }

    public void setOnErrorListener(OnErrorListener onerrorlistener) {
        mOnErrorListener = onerrorlistener;
    }

    public void setOnInfoListener(OnInfoListener oninfolistener) {
        mOnInfoListener = oninfolistener;
    }

    public void setOnPreparedListener(OnPreparedListener onpreparedlistener) {
        mOnPreparedListener = onpreparedlistener;
    }

    public void setOnSeekCompleteListener(OnSeekCompleteListener onseekcompletelistener) {
        mOnSeekCompleteListener = onseekcompletelistener;
    }

    public void setOnTimedTextListener(OnTimedTextListener ontimedtextlistener) {
        mOnTimedTextListener = ontimedtextlistener;
    }

    public void setOnVideoSizeChangedListener(OnVideoSizeChangedListener onvideosizechangedlistener) {
        mOnVideoSizeChangedListener = onvideosizechangedlistener;
    }

    public boolean setParameter(int i, int j) {
        Parcel parcel = Parcel.obtain();
        parcel.writeInt(j);
        boolean flag = setParameter(i, parcel);
        parcel.recycle();
        return flag;
    }

    public native boolean setParameter(int i, Parcel parcel);

    public boolean setParameter(int i, String s) {
        Parcel parcel = Parcel.obtain();
        parcel.writeString(s);
        boolean flag = setParameter(i, parcel);
        parcel.recycle();
        return flag;
    }

    public void setRetransmitEndpoint(InetSocketAddress inetsocketaddress) throws IllegalStateException, IllegalArgumentException {
        String s = null;
        int i = 0;
        if(inetsocketaddress != null) {
            s = inetsocketaddress.getAddress().getHostAddress();
            i = inetsocketaddress.getPort();
        }
        int j = native_setRetransmitEndpoint(s, i);
        if(j != 0)
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal re-transmit endpoint; native ret ").append(j).toString());
        else
            return;
    }

    public void setScreenOnWhilePlaying(boolean flag) {
        if(mScreenOnWhilePlaying != flag) {
            if(flag && mSurfaceHolder == null)
                Log.w("MediaPlayer", "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
            mScreenOnWhilePlaying = flag;
            updateSurfaceScreenOn();
        }
    }

    public void setSurface(Surface surface) {
        if(mScreenOnWhilePlaying && surface != null)
            Log.w("MediaPlayer", "setScreenOnWhilePlaying(true) is ineffective for Surface");
        mSurfaceHolder = null;
        _setVideoSurface(surface);
        updateSurfaceScreenOn();
    }

    public void setVideoScalingMode(int i) {
        Parcel parcel;
        Parcel parcel1;
        if(!isVideoScalingModeSupported(i))
            throw new IllegalArgumentException((new StringBuilder()).append("Scaling mode ").append(i).append(" is not supported").toString());
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.media.IMediaPlayer");
        parcel.writeInt(6);
        parcel.writeInt(i);
        invoke(parcel, parcel1);
        parcel.recycle();
        parcel1.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        parcel1.recycle();
        throw exception;
    }

    public native void setVolume(float f, float f1);

    public void setWakeMode(Context context, int i) {
        boolean flag = false;
        if(mWakeLock != null) {
            if(mWakeLock.isHeld()) {
                flag = true;
                mWakeLock.release();
            }
            mWakeLock = null;
        }
        mWakeLock = ((PowerManager)context.getSystemService("power")).newWakeLock(0x20000000 | i, android/media/MediaPlayer.getName());
        mWakeLock.setReferenceCounted(false);
        if(flag)
            mWakeLock.acquire();
    }

    public void start() throws IllegalStateException {
        stayAwake(true);
        _start();
    }

    public void stop() throws IllegalStateException {
        stayAwake(false);
        _stop();
    }

    public static final boolean APPLY_METADATA_FILTER = true;
    public static final boolean BYPASS_METADATA_FILTER = false;
    private static final String IMEDIA_PLAYER = "android.media.IMediaPlayer";
    private static final int INVOKE_ID_ADD_EXTERNAL_SOURCE = 2;
    private static final int INVOKE_ID_ADD_EXTERNAL_SOURCE_FD = 3;
    private static final int INVOKE_ID_DESELECT_TRACK = 5;
    private static final int INVOKE_ID_GET_TRACK_INFO = 1;
    private static final int INVOKE_ID_SELECT_TRACK = 4;
    private static final int INVOKE_ID_SET_VIDEO_SCALE_MODE = 6;
    private static final int MEDIA_BUFFERING_UPDATE = 3;
    private static final int MEDIA_ERROR = 100;
    public static final int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200;
    public static final int MEDIA_ERROR_SERVER_DIED = 100;
    public static final int MEDIA_ERROR_UNKNOWN = 1;
    private static final int MEDIA_INFO = 200;
    public static final int MEDIA_INFO_BAD_INTERLEAVING = 800;
    public static final int MEDIA_INFO_BUFFERING_END = 702;
    public static final int MEDIA_INFO_BUFFERING_START = 701;
    public static final int MEDIA_INFO_METADATA_UPDATE = 802;
    public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
    public static final int MEDIA_INFO_STARTED_AS_NEXT = 2;
    public static final int MEDIA_INFO_TIMED_TEXT_ERROR = 900;
    public static final int MEDIA_INFO_UNKNOWN = 1;
    public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;
    public static final String MEDIA_MIMETYPE_TEXT_SUBRIP = "application/x-subrip";
    private static final int MEDIA_NOP = 0;
    private static final int MEDIA_PLAYBACK_COMPLETE = 2;
    private static final int MEDIA_PREPARED = 1;
    private static final int MEDIA_SEEK_COMPLETE = 4;
    private static final int MEDIA_SET_VIDEO_SIZE = 5;
    private static final int MEDIA_TIMED_TEXT = 99;
    public static final boolean METADATA_ALL = false;
    public static final boolean METADATA_UPDATE_ONLY = true;
    private static final String TAG = "MediaPlayer";
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT = 1;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING = 2;
    private EventHandler mEventHandler;
    private int mListenerContext;
    private int mNativeContext;
    private int mNativeSurfaceTexture;
    private OnBufferingUpdateListener mOnBufferingUpdateListener;
    private OnCompletionListener mOnCompletionListener;
    private OnErrorListener mOnErrorListener;
    private OnInfoListener mOnInfoListener;
    private OnPreparedListener mOnPreparedListener;
    private OnSeekCompleteListener mOnSeekCompleteListener;
    private OnTimedTextListener mOnTimedTextListener;
    private OnVideoSizeChangedListener mOnVideoSizeChangedListener;
    private boolean mScreenOnWhilePlaying;
    private boolean mStayAwake;
    private SurfaceHolder mSurfaceHolder;
    private android.os.PowerManager.WakeLock mWakeLock;

    static  {
        System.loadLibrary("media_jni");
        native_init();
    }










}
