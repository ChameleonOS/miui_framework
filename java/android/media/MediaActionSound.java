// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.util.Log;

// Referenced classes of package android.media:
//            SoundPool

public class MediaActionSound {

    public MediaActionSound() {
        mLoadCompleteListener = new SoundPool.OnLoadCompleteListener() {

            public void onLoadComplete(SoundPool soundpool, int j, int k) {
                if(k == 0) {
                    if(mSoundIdToPlay == j) {
                        soundpool.play(j, 1.0F, 1.0F, 0, 0, 1.0F);
                        mSoundIdToPlay = -1;
                    }
                } else {
                    Log.e("MediaActionSound", (new StringBuilder()).append("Unable to load sound for playback (status: ").append(k).append(")").toString());
                }
            }

            final MediaActionSound this$0;

             {
                this$0 = MediaActionSound.this;
                super();
            }
        };
        mSoundPool = new SoundPool(1, 7, 0);
        mSoundPool.setOnLoadCompleteListener(mLoadCompleteListener);
        mSoundIds = new int[SOUND_FILES.length];
        for(int i = 0; i < mSoundIds.length; i++)
            mSoundIds[i] = -1;

        mSoundIdToPlay = -1;
    }

    /**
     * @deprecated Method load is deprecated
     */

    public void load(int i) {
        this;
        JVM INSTR monitorenter ;
        if(i < 0)
            break MISSING_BLOCK_LABEL_14;
        if(i < SOUND_FILES.length)
            break MISSING_BLOCK_LABEL_46;
        throw new RuntimeException((new StringBuilder()).append("Unknown sound requested: ").append(i).toString());
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        if(mSoundIds[i] == -1)
            mSoundIds[i] = mSoundPool.load(SOUND_FILES[i], 1);
        this;
        JVM INSTR monitorexit ;
    }

    /**
     * @deprecated Method play is deprecated
     */

    public void play(int i) {
        this;
        JVM INSTR monitorenter ;
        if(i < 0)
            break MISSING_BLOCK_LABEL_14;
        if(i < SOUND_FILES.length)
            break MISSING_BLOCK_LABEL_46;
        throw new RuntimeException((new StringBuilder()).append("Unknown sound requested: ").append(i).toString());
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        if(mSoundIds[i] != -1)
            break MISSING_BLOCK_LABEL_87;
        mSoundIdToPlay = mSoundPool.load(SOUND_FILES[i], 1);
        mSoundIds[i] = mSoundIdToPlay;
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        mSoundPool.play(mSoundIds[i], 1.0F, 1.0F, 0, 0, 1.0F);
          goto _L1
    }

    public void release() {
        if(mSoundPool != null) {
            mSoundPool.release();
            mSoundPool = null;
        }
    }

    public static final int FOCUS_COMPLETE = 1;
    private static final int NUM_MEDIA_SOUND_STREAMS = 1;
    public static final int SHUTTER_CLICK = 0;
    private static final String SOUND_FILES[];
    private static final int SOUND_NOT_LOADED = -1;
    public static final int START_VIDEO_RECORDING = 2;
    public static final int STOP_VIDEO_RECORDING = 3;
    private static final String TAG = "MediaActionSound";
    private SoundPool.OnLoadCompleteListener mLoadCompleteListener;
    private int mSoundIdToPlay;
    private int mSoundIds[];
    private SoundPool mSoundPool;

    static  {
        String as[] = new String[4];
        as[0] = "/system/media/audio/ui/camera_click.ogg";
        as[1] = "/system/media/audio/ui/camera_focus.ogg";
        as[2] = "/system/media/audio/ui/VideoRecord.ogg";
        as[3] = "/system/media/audio/ui/VideoRecord.ogg";
        SOUND_FILES = as;
    }



/*
    static int access$002(MediaActionSound mediaactionsound, int i) {
        mediaactionsound.mSoundIdToPlay = i;
        return i;
    }

*/
}
