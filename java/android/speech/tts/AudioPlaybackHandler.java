// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.speech.tts;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

// Referenced classes of package android.speech.tts:
//            PlaybackQueueItem

class AudioPlaybackHandler {
    private final class MessageLoop
        implements Runnable {

        public void run() {
            do {
                PlaybackQueueItem playbackqueueitem;
                try {
                    playbackqueueitem = (PlaybackQueueItem)mQueue.take();
                }
                catch(InterruptedException interruptedexception) {
                    return;
                }
                mCurrentWorkItem = playbackqueueitem;
                playbackqueueitem.run();
                mCurrentWorkItem = null;
            } while(true);
        }

        final AudioPlaybackHandler this$0;

        private MessageLoop() {
            this$0 = AudioPlaybackHandler.this;
            super();
        }

    }


    AudioPlaybackHandler() {
        mCurrentWorkItem = null;
    }

    private void removeAllMessages() {
        mQueue.clear();
    }

    private void removeWorkItemsFor(Object obj) {
        Iterator iterator = mQueue.iterator();
        do {
            if(!iterator.hasNext())
                break;
            if(((PlaybackQueueItem)iterator.next()).getCallerIdentity() == obj)
                iterator.remove();
        } while(true);
    }

    private void stop(PlaybackQueueItem playbackqueueitem) {
        if(playbackqueueitem != null)
            playbackqueueitem.stop(false);
    }

    public void enqueue(PlaybackQueueItem playbackqueueitem) {
        mQueue.put(playbackqueueitem);
_L2:
        return;
        InterruptedException interruptedexception;
        interruptedexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean isSpeaking() {
        boolean flag;
        if(mQueue.peek() != null || mCurrentWorkItem != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void quit() {
        removeAllMessages();
        stop(mCurrentWorkItem);
        mHandlerThread.interrupt();
    }

    public void start() {
        mHandlerThread.start();
    }

    public void stop() {
        removeAllMessages();
        stop(mCurrentWorkItem);
    }

    public void stopForApp(Object obj) {
        removeWorkItemsFor(obj);
        PlaybackQueueItem playbackqueueitem = mCurrentWorkItem;
        if(playbackqueueitem != null && playbackqueueitem.getCallerIdentity() == obj)
            stop(playbackqueueitem);
    }

    private static final boolean DBG = false;
    private static final String TAG = "TTS.AudioPlaybackHandler";
    private volatile PlaybackQueueItem mCurrentWorkItem;
    private final Thread mHandlerThread = new Thread(new MessageLoop(), "TTS.AudioPlaybackThread");
    private final LinkedBlockingQueue mQueue = new LinkedBlockingQueue();



/*
    static PlaybackQueueItem access$202(AudioPlaybackHandler audioplaybackhandler, PlaybackQueueItem playbackqueueitem) {
        audioplaybackhandler.mCurrentWorkItem = playbackqueueitem;
        return playbackqueueitem;
    }

*/
}
