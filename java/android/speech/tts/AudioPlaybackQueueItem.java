// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.speech.tts;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.ConditionVariable;
import android.util.Log;

// Referenced classes of package android.speech.tts:
//            PlaybackQueueItem

class AudioPlaybackQueueItem extends PlaybackQueueItem {

    AudioPlaybackQueueItem(TextToSpeechService.UtteranceProgressDispatcher utteranceprogressdispatcher, Object obj, Context context, Uri uri, int i) {
        super(utteranceprogressdispatcher, obj);
        mContext = context;
        mUri = uri;
        mStreamType = i;
        mPlayer = null;
        mFinished = false;
    }

    private void finish() {
        try {
            mPlayer.stop();
        }
        catch(IllegalStateException illegalstateexception) { }
        mPlayer.release();
    }

    public void run() {
        TextToSpeechService.UtteranceProgressDispatcher utteranceprogressdispatcher;
        utteranceprogressdispatcher = getDispatcher();
        utteranceprogressdispatcher.dispatchOnStart();
        mPlayer = MediaPlayer.create(mContext, mUri);
        if(mPlayer != null) goto _L2; else goto _L1
_L1:
        utteranceprogressdispatcher.dispatchOnError();
_L4:
        return;
_L2:
        try {
            mPlayer.setOnErrorListener(new android.media.MediaPlayer.OnErrorListener() {

                public boolean onError(MediaPlayer mediaplayer, int i, int j) {
                    Log.w("TTS.AudioQueueItem", (new StringBuilder()).append("Audio playback error: ").append(i).append(", ").append(j).toString());
                    mDone.open();
                    return true;
                }

                final AudioPlaybackQueueItem this$0;

             {
                this$0 = AudioPlaybackQueueItem.this;
                super();
            }
            });
            mPlayer.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() {

                public void onCompletion(MediaPlayer mediaplayer) {
                    mFinished = true;
                    mDone.open();
                }

                final AudioPlaybackQueueItem this$0;

             {
                this$0 = AudioPlaybackQueueItem.this;
                super();
            }
            });
            mPlayer.setAudioStreamType(mStreamType);
            mPlayer.start();
            mDone.block();
            finish();
        }
        catch(IllegalArgumentException illegalargumentexception) {
            Log.w("TTS.AudioQueueItem", "MediaPlayer failed", illegalargumentexception);
            mDone.open();
        }
        if(mFinished)
            utteranceprogressdispatcher.dispatchOnDone();
        else
            utteranceprogressdispatcher.dispatchOnError();
        if(true) goto _L4; else goto _L3
_L3:
    }

    void stop(boolean flag) {
        mDone.open();
    }

    private static final String TAG = "TTS.AudioQueueItem";
    private final Context mContext;
    private final ConditionVariable mDone = new ConditionVariable();
    private volatile boolean mFinished;
    private MediaPlayer mPlayer;
    private final int mStreamType;
    private final Uri mUri;



/*
    static boolean access$102(AudioPlaybackQueueItem audioplaybackqueueitem, boolean flag) {
        audioplaybackqueueitem.mFinished = flag;
        return flag;
    }

*/
}
