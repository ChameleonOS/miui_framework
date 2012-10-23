// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.speech.tts;

import java.util.LinkedList;
import java.util.concurrent.locks.*;

// Referenced classes of package android.speech.tts:
//            PlaybackQueueItem, BlockingAudioTrack, EventLogger

final class SynthesisPlaybackQueueItem extends PlaybackQueueItem {
    static final class ListEntry {

        final byte mBytes[];

        ListEntry(byte abyte0[]) {
            mBytes = abyte0;
        }
    }


    SynthesisPlaybackQueueItem(int i, int j, int k, int l, float f, float f1, TextToSpeechService.UtteranceProgressDispatcher utteranceprogressdispatcher, 
            Object obj, EventLogger eventlogger) {
        super(utteranceprogressdispatcher, obj);
        mReadReady = mListLock.newCondition();
        mNotFull = mListLock.newCondition();
        mUnconsumedBytes = 0;
        mStopped = false;
        mDone = false;
        mIsError = false;
        mAudioTrack = new BlockingAudioTrack(i, j, k, l, f, f1);
        mLogger = eventlogger;
    }

    private byte[] take() throws InterruptedException {
        byte abyte0[] = null;
        mListLock.lock();
        for(; mDataBufferList.size() == 0 && !mStopped && !mDone; mReadReady.await());
        break MISSING_BLOCK_LABEL_59;
        Exception exception;
        exception;
        mListLock.unlock();
        throw exception;
        boolean flag = mStopped;
        if(!flag) goto _L2; else goto _L1
_L1:
        mListLock.unlock();
_L4:
        return abyte0;
_L2:
        ListEntry listentry = (ListEntry)mDataBufferList.poll();
        if(listentry == null) {
            mListLock.unlock();
            continue; /* Loop/switch isn't completed */
        }
        mUnconsumedBytes = mUnconsumedBytes - listentry.mBytes.length;
        mNotFull.signal();
        abyte0 = listentry.mBytes;
        mListLock.unlock();
        if(true) goto _L4; else goto _L3
_L3:
    }

    void done() {
        mListLock.lock();
        mDone = true;
        mReadReady.signal();
        mNotFull.signal();
        mListLock.unlock();
        return;
        Exception exception;
        exception;
        mListLock.unlock();
        throw exception;
    }

    void put(byte abyte0[]) throws InterruptedException {
        mListLock.lock();
        for(; mAudioTrack.getAudioLengthMs(mUnconsumedBytes) > 500L && !mStopped; mNotFull.await());
        break MISSING_BLOCK_LABEL_58;
        Exception exception;
        exception;
        mListLock.unlock();
        throw exception;
        boolean flag = mStopped;
        if(!flag) goto _L2; else goto _L1
_L1:
        mListLock.unlock();
_L4:
        return;
_L2:
        mDataBufferList.add(new ListEntry(abyte0));
        mUnconsumedBytes = mUnconsumedBytes + abyte0.length;
        mReadReady.signal();
        mListLock.unlock();
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void run() {
        TextToSpeechService.UtteranceProgressDispatcher utteranceprogressdispatcher = getDispatcher();
        utteranceprogressdispatcher.dispatchOnStart();
        mAudioTrack.init();
        do {
            try {
                byte abyte0[] = take();
                if(abyte0 == null)
                    break;
                mAudioTrack.write(abyte0);
                mLogger.onAudioDataWritten();
                continue;
            }
            catch(InterruptedException interruptedexception) { }
            break;
        } while(true);
        mAudioTrack.waitAndRelease();
        if(mIsError)
            utteranceprogressdispatcher.dispatchOnError();
        else
            utteranceprogressdispatcher.dispatchOnDone();
        mLogger.onWriteData();
    }

    void stop(boolean flag) {
        mListLock.lock();
        mStopped = true;
        mIsError = flag;
        mReadReady.signal();
        mNotFull.signal();
        mListLock.unlock();
        mAudioTrack.stop();
        return;
        Exception exception;
        exception;
        mListLock.unlock();
        throw exception;
    }

    private static final boolean DBG = false;
    private static final long MAX_UNCONSUMED_AUDIO_MS = 500L;
    private static final String TAG = "TTS.SynthQueueItem";
    private final BlockingAudioTrack mAudioTrack;
    private final LinkedList mDataBufferList = new LinkedList();
    private volatile boolean mDone;
    private volatile boolean mIsError;
    private final Lock mListLock = new ReentrantLock();
    private final EventLogger mLogger;
    private final Condition mNotFull;
    private final Condition mReadReady;
    private volatile boolean mStopped;
    private int mUnconsumedBytes;
}
