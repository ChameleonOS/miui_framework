// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.speech.tts;

import android.os.ConditionVariable;

// Referenced classes of package android.speech.tts:
//            PlaybackQueueItem

class SilencePlaybackQueueItem extends PlaybackQueueItem {

    SilencePlaybackQueueItem(TextToSpeechService.UtteranceProgressDispatcher utteranceprogressdispatcher, Object obj, long l) {
        super(utteranceprogressdispatcher, obj);
        mSilenceDurationMs = l;
    }

    public void run() {
        getDispatcher().dispatchOnStart();
        if(mSilenceDurationMs > 0L)
            mCondVar.block(mSilenceDurationMs);
        getDispatcher().dispatchOnDone();
    }

    void stop(boolean flag) {
        mCondVar.open();
    }

    private final ConditionVariable mCondVar = new ConditionVariable();
    private final long mSilenceDurationMs;
}
