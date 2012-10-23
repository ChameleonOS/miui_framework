// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.speech.tts;


abstract class PlaybackQueueItem
    implements Runnable {

    PlaybackQueueItem(TextToSpeechService.UtteranceProgressDispatcher utteranceprogressdispatcher, Object obj) {
        mDispatcher = utteranceprogressdispatcher;
        mCallerIdentity = obj;
    }

    Object getCallerIdentity() {
        return mCallerIdentity;
    }

    protected TextToSpeechService.UtteranceProgressDispatcher getDispatcher() {
        return mDispatcher;
    }

    public abstract void run();

    abstract void stop(boolean flag);

    private final Object mCallerIdentity;
    private final TextToSpeechService.UtteranceProgressDispatcher mDispatcher;
}
