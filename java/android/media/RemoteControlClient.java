// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.app.PendingIntent;
import android.graphics.*;
import android.os.*;
import android.util.Log;

// Referenced classes of package android.media:
//            IRemoteControlDisplay, IAudioService, AudioSystem, IRemoteControlClient

public class RemoteControlClient {
    private class EventHandler extends Handler {

        public void handleMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 1 8: default 52
        //                       1 86
        //                       2 119
        //                       3 152
        //                       4 185
        //                       5 212
        //                       6 237
        //                       7 251
        //                       8 268;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
            Log.e("RemoteControlClient", (new StringBuilder()).append("Unknown event ").append(message.what).append(" in RemoteControlClient handler").toString());
_L11:
            return;
_L2:
            Object obj3 = mCacheLock;
            obj3;
            JVM INSTR monitorenter ;
            sendPlaybackState_syncCacheLock();
            continue; /* Loop/switch isn't completed */
_L3:
            Object obj2 = mCacheLock;
            obj2;
            JVM INSTR monitorenter ;
            sendMetadata_syncCacheLock();
            continue; /* Loop/switch isn't completed */
_L4:
            Object obj1 = mCacheLock;
            obj1;
            JVM INSTR monitorenter ;
            sendTransportControlFlags_syncCacheLock();
            continue; /* Loop/switch isn't completed */
_L5:
            Object obj = mCacheLock;
            obj;
            JVM INSTR monitorenter ;
            sendArtwork_syncCacheLock();
            continue; /* Loop/switch isn't completed */
_L6:
            onNewInternalClientGen((Integer)message.obj, message.arg1, message.arg2);
            continue; /* Loop/switch isn't completed */
_L7:
            onNewCurrentClientGen(message.arg1);
            continue; /* Loop/switch isn't completed */
_L8:
            onPlugDisplay((IRemoteControlDisplay)message.obj);
            continue; /* Loop/switch isn't completed */
_L9:
            onUnplugDisplay((IRemoteControlDisplay)message.obj);
            if(true) goto _L11; else goto _L10
_L10:
        }

        final RemoteControlClient this$0;

        public EventHandler(RemoteControlClient remotecontrolclient1, Looper looper) {
            this$0 = RemoteControlClient.this;
            super(looper);
        }
    }

    public class MetadataEditor {

        /**
         * @deprecated Method apply is deprecated
         */

        public void apply() {
            this;
            JVM INSTR monitorenter ;
            if(!mApplied) goto _L2; else goto _L1
_L1:
            Log.e("RemoteControlClient", "Can't apply a previously applied MetadataEditor");
_L4:
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            Object obj = mCacheLock;
            obj;
            JVM INSTR monitorenter ;
            mMetadata = new Bundle(mEditorMetadata);
            if(mArtwork != null && !mArtwork.equals(mEditorArtwork))
                mArtwork.recycle();
            mArtwork = mEditorArtwork;
            mEditorArtwork = null;
            if(!(mMetadataChanged & mArtworkChanged))
                break; /* Loop/switch isn't completed */
            sendMetadataWithArtwork_syncCacheLock();
_L5:
            mApplied = true;
            if(true) goto _L4; else goto _L3
            Exception exception1;
            exception1;
            throw exception1;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
_L3:
            if(mMetadataChanged)
                sendMetadata_syncCacheLock();
            else
            if(mArtworkChanged)
                sendArtwork_syncCacheLock();
              goto _L5
        }

        /**
         * @deprecated Method clear is deprecated
         */

        public void clear() {
            this;
            JVM INSTR monitorenter ;
            if(!mApplied) goto _L2; else goto _L1
_L1:
            Log.e("RemoteControlClient", "Can't clear a previously applied MetadataEditor");
_L4:
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            mEditorMetadata.clear();
            mEditorArtwork = null;
            if(true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            throw exception;
        }

        public Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }

        /**
         * @deprecated Method putBitmap is deprecated
         */

        public MetadataEditor putBitmap(int i, Bitmap bitmap) throws IllegalArgumentException {
            this;
            JVM INSTR monitorenter ;
            if(!mApplied) goto _L2; else goto _L1
_L1:
            Log.e("RemoteControlClient", "Can't edit a previously applied MetadataEditor");
            MetadataEditor metadataeditor = this;
_L3:
            this;
            JVM INSTR monitorexit ;
            return metadataeditor;
_L2:
            if(i == 100)
                break MISSING_BLOCK_LABEL_63;
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid type 'Bitmap' for key ").append(i).toString());
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
            if(mArtworkExpectedWidth > 0 && mArtworkExpectedHeight > 0)
                mEditorArtwork = scaleBitmapIfTooBig(bitmap, mArtworkExpectedWidth, mArtworkExpectedHeight);
            else
                mEditorArtwork = bitmap;
            mArtworkChanged = true;
            metadataeditor = this;
              goto _L3
        }

        /**
         * @deprecated Method putLong is deprecated
         */

        public MetadataEditor putLong(int i, long l) throws IllegalArgumentException {
            this;
            JVM INSTR monitorenter ;
            if(!mApplied) goto _L2; else goto _L1
_L1:
            Log.e("RemoteControlClient", "Can't edit a previously applied MetadataEditor");
            MetadataEditor metadataeditor = this;
_L4:
            this;
            JVM INSTR monitorexit ;
            return metadataeditor;
_L2:
            if(!RemoteControlClient.validTypeForKey(i, RemoteControlClient.METADATA_KEYS_TYPE_LONG))
                throw new IllegalArgumentException((new StringBuilder()).append("Invalid type 'long' for key ").append(i).toString());
            break MISSING_BLOCK_LABEL_69;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
            mEditorMetadata.putLong(String.valueOf(i), l);
            mMetadataChanged = true;
            metadataeditor = this;
            if(true) goto _L4; else goto _L3
_L3:
        }

        /**
         * @deprecated Method putString is deprecated
         */

        public MetadataEditor putString(int i, String s) throws IllegalArgumentException {
            this;
            JVM INSTR monitorenter ;
            if(!mApplied) goto _L2; else goto _L1
_L1:
            Log.e("RemoteControlClient", "Can't edit a previously applied MetadataEditor");
            MetadataEditor metadataeditor = this;
_L4:
            this;
            JVM INSTR monitorexit ;
            return metadataeditor;
_L2:
            if(!RemoteControlClient.validTypeForKey(i, RemoteControlClient.METADATA_KEYS_TYPE_STRING))
                throw new IllegalArgumentException((new StringBuilder()).append("Invalid type 'String' for key ").append(i).toString());
            break MISSING_BLOCK_LABEL_67;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
            mEditorMetadata.putString(String.valueOf(i), s);
            mMetadataChanged = true;
            metadataeditor = this;
            if(true) goto _L4; else goto _L3
_L3:
        }

        public static final int BITMAP_KEY_ARTWORK = 100;
        public static final int METADATA_KEY_ARTWORK = 100;
        private boolean mApplied;
        protected boolean mArtworkChanged;
        protected Bitmap mEditorArtwork;
        protected Bundle mEditorMetadata;
        protected boolean mMetadataChanged;
        final RemoteControlClient this$0;

        private MetadataEditor() {
            this$0 = RemoteControlClient.this;
            super();
            mApplied = false;
        }

    }


    public RemoteControlClient(PendingIntent pendingintent) {
        mPlaybackType = 0;
        mPlaybackVolumeMax = 15;
        mPlaybackVolume = 15;
        mPlaybackVolumeHandling = 1;
        mPlaybackStream = 3;
        mCacheLock = new Object();
        mPlaybackState = 0;
        mPlaybackStateChangeTimeMs = 0L;
        ARTWORK_DEFAULT_SIZE = 256;
        ARTWORK_INVALID_SIZE = -1;
        mArtworkExpectedWidth = 256;
        mArtworkExpectedHeight = 256;
        mTransportControlFlags = 0;
        mMetadata = new Bundle();
        mCurrentClientGenId = -1;
        mInternalClientGenId = -2;
        mIRCC = new IRemoteControlClient.Stub() {

            public void onInformationRequested(int i, int j, int k, int l) {
                if(mEventHandler != null) {
                    mEventHandler.removeMessages(5);
                    mEventHandler.dispatchMessage(mEventHandler.obtainMessage(5, k, l, new Integer(i)));
                    mEventHandler.removeMessages(1);
                    mEventHandler.removeMessages(2);
                    mEventHandler.removeMessages(3);
                    mEventHandler.removeMessages(4);
                    mEventHandler.dispatchMessage(mEventHandler.obtainMessage(1));
                    mEventHandler.dispatchMessage(mEventHandler.obtainMessage(3));
                    mEventHandler.dispatchMessage(mEventHandler.obtainMessage(2));
                    mEventHandler.dispatchMessage(mEventHandler.obtainMessage(4));
                }
            }

            public void plugRemoteControlDisplay(IRemoteControlDisplay iremotecontroldisplay) {
                if(mEventHandler != null)
                    mEventHandler.dispatchMessage(mEventHandler.obtainMessage(7, iremotecontroldisplay));
            }

            public void setCurrentClientGenerationId(int i) {
                if(mEventHandler != null) {
                    mEventHandler.removeMessages(6);
                    mEventHandler.dispatchMessage(mEventHandler.obtainMessage(6, i, 0));
                }
            }

            public void unplugRemoteControlDisplay(IRemoteControlDisplay iremotecontroldisplay) {
                if(mEventHandler != null)
                    mEventHandler.dispatchMessage(mEventHandler.obtainMessage(8, iremotecontroldisplay));
            }

            final RemoteControlClient this$0;

             {
                this$0 = RemoteControlClient.this;
                super();
            }
        };
        mRcseId = -1;
        mRcMediaIntent = pendingintent;
        Looper looper = Looper.myLooper();
        if(looper != null) {
            mEventHandler = new EventHandler(this, looper);
        } else {
            Looper looper1 = Looper.getMainLooper();
            if(looper1 != null) {
                mEventHandler = new EventHandler(this, looper1);
            } else {
                mEventHandler = null;
                Log.e("RemoteControlClient", "RemoteControlClient() couldn't find main application thread");
            }
        }
    }

    public RemoteControlClient(PendingIntent pendingintent, Looper looper) {
        mPlaybackType = 0;
        mPlaybackVolumeMax = 15;
        mPlaybackVolume = 15;
        mPlaybackVolumeHandling = 1;
        mPlaybackStream = 3;
        mCacheLock = new Object();
        mPlaybackState = 0;
        mPlaybackStateChangeTimeMs = 0L;
        ARTWORK_DEFAULT_SIZE = 256;
        ARTWORK_INVALID_SIZE = -1;
        mArtworkExpectedWidth = 256;
        mArtworkExpectedHeight = 256;
        mTransportControlFlags = 0;
        mMetadata = new Bundle();
        mCurrentClientGenId = -1;
        mInternalClientGenId = -2;
        mIRCC = new _cls1();
        mRcseId = -1;
        mRcMediaIntent = pendingintent;
        mEventHandler = new EventHandler(this, looper);
    }

    private void detachFromDisplay_syncCacheLock() {
        mRcDisplay = null;
        mArtworkExpectedWidth = -1;
        mArtworkExpectedHeight = -1;
    }

    private static IAudioService getService() {
        IAudioService iaudioservice;
        if(sService != null) {
            iaudioservice = sService;
        } else {
            sService = IAudioService.Stub.asInterface(ServiceManager.getService("audio"));
            iaudioservice = sService;
        }
        return iaudioservice;
    }

    private void onNewCurrentClientGen(int i) {
        Object obj = mCacheLock;
        obj;
        JVM INSTR monitorenter ;
        mCurrentClientGenId = i;
        return;
    }

    private void onNewInternalClientGen(Integer integer, int i, int j) {
        Object obj = mCacheLock;
        obj;
        JVM INSTR monitorenter ;
        mInternalClientGenId = integer.intValue();
        if(i > 0) {
            mArtworkExpectedWidth = i;
            mArtworkExpectedHeight = j;
        }
        return;
    }

    private void onPlugDisplay(IRemoteControlDisplay iremotecontroldisplay) {
        Object obj = mCacheLock;
        obj;
        JVM INSTR monitorenter ;
        mRcDisplay = iremotecontroldisplay;
        return;
    }

    private void onUnplugDisplay(IRemoteControlDisplay iremotecontroldisplay) {
        Object obj = mCacheLock;
        obj;
        JVM INSTR monitorenter ;
        if(mRcDisplay != null && mRcDisplay.asBinder().equals(iremotecontroldisplay.asBinder())) {
            mRcDisplay = null;
            mArtworkExpectedWidth = 256;
            mArtworkExpectedHeight = 256;
        }
        return;
    }

    private Bitmap scaleBitmapIfTooBig(Bitmap bitmap, int i, int j) {
        if(bitmap != null) {
            int k = bitmap.getWidth();
            int l = bitmap.getHeight();
            if(k > i || l > j) {
                float f = Math.min((float)i / (float)k, (float)j / (float)l);
                int i1 = Math.round(f * (float)k);
                int j1 = Math.round(f * (float)l);
                android.graphics.Bitmap.Config config = bitmap.getConfig();
                if(config == null)
                    config = android.graphics.Bitmap.Config.ARGB_8888;
                Bitmap bitmap1 = Bitmap.createBitmap(i1, j1, config);
                Canvas canvas = new Canvas(bitmap1);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setFilterBitmap(true);
                RectF rectf = new RectF(0.0F, 0.0F, bitmap1.getWidth(), bitmap1.getHeight());
                canvas.drawBitmap(bitmap, null, rectf, paint);
                bitmap = bitmap1;
            }
        }
        return bitmap;
    }

    private void sendArtwork_syncCacheLock() {
        if(mCurrentClientGenId != mInternalClientGenId || mRcDisplay == null)
            break MISSING_BLOCK_LABEL_55;
        mArtwork = scaleBitmapIfTooBig(mArtwork, mArtworkExpectedWidth, mArtworkExpectedHeight);
        mRcDisplay.setArtwork(mInternalClientGenId, mArtwork);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("RemoteControlClient", (new StringBuilder()).append("Error in sendArtwork(), dead display ").append(remoteexception).toString());
        detachFromDisplay_syncCacheLock();
          goto _L1
    }

    private void sendAudioServiceNewPlaybackInfo_syncCacheLock(int i, int j) {
        if(mRcseId != -1) {
            IAudioService iaudioservice = getService();
            try {
                iaudioservice.setPlaybackInfoForRcc(mRcseId, i, j);
            }
            catch(RemoteException remoteexception) {
                Log.e("RemoteControlClient", "Dead object in sendAudioServiceNewPlaybackInfo_syncCacheLock", remoteexception);
            }
        }
    }

    private void sendMetadataWithArtwork_syncCacheLock() {
        if(mCurrentClientGenId != mInternalClientGenId || mRcDisplay == null)
            break MISSING_BLOCK_LABEL_59;
        mArtwork = scaleBitmapIfTooBig(mArtwork, mArtworkExpectedWidth, mArtworkExpectedHeight);
        mRcDisplay.setAllMetadata(mInternalClientGenId, mMetadata, mArtwork);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("RemoteControlClient", (new StringBuilder()).append("Error in setAllMetadata(), dead display ").append(remoteexception).toString());
        detachFromDisplay_syncCacheLock();
          goto _L1
    }

    private void sendMetadata_syncCacheLock() {
        if(mCurrentClientGenId != mInternalClientGenId || mRcDisplay == null)
            break MISSING_BLOCK_LABEL_35;
        mRcDisplay.setMetadata(mInternalClientGenId, mMetadata);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("RemoteControlClient", (new StringBuilder()).append("Error in sendPlaybackState(), dead display ").append(remoteexception).toString());
        detachFromDisplay_syncCacheLock();
          goto _L1
    }

    private void sendPlaybackState_syncCacheLock() {
        if(mCurrentClientGenId != mInternalClientGenId || mRcDisplay == null)
            break MISSING_BLOCK_LABEL_39;
        mRcDisplay.setPlaybackState(mInternalClientGenId, mPlaybackState, mPlaybackStateChangeTimeMs);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("RemoteControlClient", (new StringBuilder()).append("Error in setPlaybackState(), dead display ").append(remoteexception).toString());
        detachFromDisplay_syncCacheLock();
          goto _L1
    }

    private void sendTransportControlFlags_syncCacheLock() {
        if(mCurrentClientGenId != mInternalClientGenId || mRcDisplay == null)
            break MISSING_BLOCK_LABEL_35;
        mRcDisplay.setTransportControlFlags(mInternalClientGenId, mTransportControlFlags);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("RemoteControlClient", (new StringBuilder()).append("Error in sendTransportControlFlags(), dead display ").append(remoteexception).toString());
        detachFromDisplay_syncCacheLock();
          goto _L1
    }

    private static boolean validTypeForKey(int i, int ai[]) {
        int j = 0;
_L3:
        int k = ai[j];
        if(i != k) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        j++;
          goto _L3
        ArrayIndexOutOfBoundsException arrayindexoutofboundsexception;
        arrayindexoutofboundsexception;
        flag = false;
          goto _L4
    }

    public MetadataEditor editMetadata(boolean flag) {
        MetadataEditor metadataeditor = new MetadataEditor();
        if(flag) {
            metadataeditor.mEditorMetadata = new Bundle();
            metadataeditor.mEditorArtwork = null;
            metadataeditor.mMetadataChanged = true;
            metadataeditor.mArtworkChanged = true;
        } else {
            metadataeditor.mEditorMetadata = new Bundle(mMetadata);
            metadataeditor.mEditorArtwork = mArtwork;
            metadataeditor.mMetadataChanged = false;
            metadataeditor.mArtworkChanged = false;
        }
        return metadataeditor;
    }

    public IRemoteControlClient getIRemoteControlClient() {
        return mIRCC;
    }

    public int getIntPlaybackInformation(int i) {
        Object obj = mCacheLock;
        obj;
        JVM INSTR monitorenter ;
        i;
        JVM INSTR tableswitch 1 5: default 44
    //                   1 78
    //                   2 95
    //                   3 105
    //                   4 125
    //                   5 115;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        int j;
        Log.e("RemoteControlClient", (new StringBuilder()).append("getIntPlaybackInformation() unknown key ").append(i).toString());
        j = 0x80000000;
        break; /* Loop/switch isn't completed */
_L2:
        j = mPlaybackType;
        break; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        throw exception;
_L3:
        j = mPlaybackVolume;
        obj;
        JVM INSTR monitorexit ;
        break; /* Loop/switch isn't completed */
_L4:
        j = mPlaybackVolumeMax;
        obj;
        JVM INSTR monitorexit ;
        break; /* Loop/switch isn't completed */
_L6:
        j = mPlaybackStream;
        obj;
        JVM INSTR monitorexit ;
        break; /* Loop/switch isn't completed */
_L5:
        j = mPlaybackVolumeHandling;
        obj;
        JVM INSTR monitorexit ;
        return j;
    }

    public PendingIntent getRcMediaIntent() {
        return mRcMediaIntent;
    }

    public int getRcseId() {
        return mRcseId;
    }

    public void setPlaybackInformation(int i, int j) {
        Object obj = mCacheLock;
        obj;
        JVM INSTR monitorenter ;
        i;
        JVM INSTR tableswitch 1 5: default 44
    //                   1 73
    //                   2 123
    //                   3 171
    //                   4 240
    //                   5 209;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        Log.w("RemoteControlClient", (new StringBuilder()).append("setPlaybackInformation() ignoring unknown key ").append(i).toString());
_L9:
        obj;
        JVM INSTR monitorexit ;
        return;
_L2:
        if(j < 0 || j > 1) goto _L8; else goto _L7
_L7:
        if(mPlaybackType != j) {
            mPlaybackType = j;
            sendAudioServiceNewPlaybackInfo_syncCacheLock(i, j);
        }
          goto _L9
        Exception exception;
        exception;
        throw exception;
_L8:
        Log.w("RemoteControlClient", "using invalid value for PLAYBACKINFO_PLAYBACK_TYPE");
          goto _L9
_L3:
        if(j > -1 && j <= mPlaybackVolumeMax) {
            if(mPlaybackVolume != j) {
                mPlaybackVolume = j;
                sendAudioServiceNewPlaybackInfo_syncCacheLock(i, j);
            }
        } else {
            Log.w("RemoteControlClient", "using invalid value for PLAYBACKINFO_VOLUME");
        }
          goto _L9
_L4:
        if(j > 0) {
            if(mPlaybackVolumeMax != j) {
                mPlaybackVolumeMax = j;
                sendAudioServiceNewPlaybackInfo_syncCacheLock(i, j);
            }
        } else {
            Log.w("RemoteControlClient", "using invalid value for PLAYBACKINFO_VOLUME_MAX");
        }
          goto _L9
_L6:
        if(j >= 0 && j < AudioSystem.getNumStreamTypes())
            mPlaybackStream = j;
        else
            Log.w("RemoteControlClient", "using invalid value for PLAYBACKINFO_USES_STREAM");
          goto _L9
_L5:
        if(j >= 0 && j <= 1) {
            if(mPlaybackVolumeHandling != j) {
                mPlaybackVolumeHandling = j;
                sendAudioServiceNewPlaybackInfo_syncCacheLock(i, j);
            }
        } else {
            Log.w("RemoteControlClient", "using invalid value for PLAYBACKINFO_VOLUME_HANDLING");
        }
          goto _L9
    }

    public void setPlaybackState(int i) {
        Object obj = mCacheLock;
        obj;
        JVM INSTR monitorenter ;
        if(mPlaybackState != i) {
            mPlaybackState = i;
            mPlaybackStateChangeTimeMs = SystemClock.elapsedRealtime();
            sendPlaybackState_syncCacheLock();
            sendAudioServiceNewPlaybackInfo_syncCacheLock(255, i);
        }
        return;
    }

    public void setRcseId(int i) {
        mRcseId = i;
    }

    public void setTransportControlFlags(int i) {
        Object obj = mCacheLock;
        obj;
        JVM INSTR monitorenter ;
        mTransportControlFlags = i;
        sendTransportControlFlags_syncCacheLock();
        return;
    }

    public static final int DEFAULT_PLAYBACK_VOLUME = 15;
    public static final int DEFAULT_PLAYBACK_VOLUME_HANDLING = 1;
    public static final int FLAGS_KEY_MEDIA_NONE = 0;
    public static final int FLAG_INFORMATION_REQUEST_ALBUM_ART = 8;
    public static final int FLAG_INFORMATION_REQUEST_KEY_MEDIA = 2;
    public static final int FLAG_INFORMATION_REQUEST_METADATA = 1;
    public static final int FLAG_INFORMATION_REQUEST_PLAYSTATE = 4;
    public static final int FLAG_KEY_MEDIA_FAST_FORWARD = 64;
    public static final int FLAG_KEY_MEDIA_NEXT = 128;
    public static final int FLAG_KEY_MEDIA_PAUSE = 16;
    public static final int FLAG_KEY_MEDIA_PLAY = 4;
    public static final int FLAG_KEY_MEDIA_PLAY_PAUSE = 8;
    public static final int FLAG_KEY_MEDIA_PREVIOUS = 1;
    public static final int FLAG_KEY_MEDIA_REWIND = 2;
    public static final int FLAG_KEY_MEDIA_STOP = 32;
    private static final int METADATA_KEYS_TYPE_LONG[];
    private static final int METADATA_KEYS_TYPE_STRING[];
    private static final int MSG_NEW_CURRENT_CLIENT_GEN = 6;
    private static final int MSG_NEW_INTERNAL_CLIENT_GEN = 5;
    private static final int MSG_PLUG_DISPLAY = 7;
    private static final int MSG_REQUEST_ARTWORK = 4;
    private static final int MSG_REQUEST_METADATA = 2;
    private static final int MSG_REQUEST_PLAYBACK_STATE = 1;
    private static final int MSG_REQUEST_TRANSPORTCONTROL = 3;
    private static final int MSG_UNPLUG_DISPLAY = 8;
    public static final int PLAYBACKINFO_INVALID_VALUE = 0x80000000;
    public static final int PLAYBACKINFO_PLAYBACK_TYPE = 1;
    public static final int PLAYBACKINFO_PLAYSTATE = 255;
    public static final int PLAYBACKINFO_USES_STREAM = 5;
    public static final int PLAYBACKINFO_VOLUME = 2;
    public static final int PLAYBACKINFO_VOLUME_HANDLING = 4;
    public static final int PLAYBACKINFO_VOLUME_MAX = 3;
    public static final int PLAYBACK_TYPE_LOCAL = 0;
    private static final int PLAYBACK_TYPE_MAX = 1;
    private static final int PLAYBACK_TYPE_MIN = 0;
    public static final int PLAYBACK_TYPE_REMOTE = 1;
    public static final int PLAYBACK_VOLUME_FIXED = 0;
    public static final int PLAYBACK_VOLUME_VARIABLE = 1;
    public static final int PLAYSTATE_BUFFERING = 8;
    public static final int PLAYSTATE_ERROR = 9;
    public static final int PLAYSTATE_FAST_FORWARDING = 4;
    public static final int PLAYSTATE_NONE = 0;
    public static final int PLAYSTATE_PAUSED = 2;
    public static final int PLAYSTATE_PLAYING = 3;
    public static final int PLAYSTATE_REWINDING = 5;
    public static final int PLAYSTATE_SKIPPING_BACKWARDS = 7;
    public static final int PLAYSTATE_SKIPPING_FORWARDS = 6;
    public static final int PLAYSTATE_STOPPED = 1;
    public static final int RCSE_ID_UNREGISTERED = -1;
    private static final String TAG = "RemoteControlClient";
    private static IAudioService sService;
    private final int ARTWORK_DEFAULT_SIZE;
    private final int ARTWORK_INVALID_SIZE;
    private Bitmap mArtwork;
    private int mArtworkExpectedHeight;
    private int mArtworkExpectedWidth;
    private final Object mCacheLock;
    private int mCurrentClientGenId;
    private EventHandler mEventHandler;
    private final IRemoteControlClient mIRCC;
    private int mInternalClientGenId;
    private Bundle mMetadata;
    private int mPlaybackState;
    private long mPlaybackStateChangeTimeMs;
    private int mPlaybackStream;
    private int mPlaybackType;
    private int mPlaybackVolume;
    private int mPlaybackVolumeHandling;
    private int mPlaybackVolumeMax;
    private IRemoteControlDisplay mRcDisplay;
    private final PendingIntent mRcMediaIntent;
    private int mRcseId;
    private int mTransportControlFlags;

    static  {
        int ai[] = new int[11];
        ai[0] = 1;
        ai[1] = 13;
        ai[2] = 7;
        ai[3] = 2;
        ai[4] = 3;
        ai[5] = 15;
        ai[6] = 4;
        ai[7] = 5;
        ai[8] = 6;
        ai[9] = 7;
        ai[10] = 11;
        METADATA_KEYS_TYPE_STRING = ai;
        int ai1[] = new int[3];
        ai1[0] = 0;
        ai1[1] = 14;
        ai1[2] = 9;
        METADATA_KEYS_TYPE_LONG = ai1;
    }


















/*
    static Bundle access$702(RemoteControlClient remotecontrolclient, Bundle bundle) {
        remotecontrolclient.mMetadata = bundle;
        return bundle;
    }

*/



/*
    static Bitmap access$802(RemoteControlClient remotecontrolclient, Bitmap bitmap) {
        remotecontrolclient.mArtwork = bitmap;
        return bitmap;
    }

*/

}
