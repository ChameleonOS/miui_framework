// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.speech.tts;

import android.util.Log;

// Referenced classes of package android.speech.tts:
//            AbstractSynthesisCallback, SynthesisPlaybackQueueItem, EventLogger, BlockingAudioTrack, 
//            AudioPlaybackHandler

class PlaybackSynthesisCallback extends AbstractSynthesisCallback {

    PlaybackSynthesisCallback(int i, float f, float f1, AudioPlaybackHandler audioplaybackhandler, TextToSpeechService.UtteranceProgressDispatcher utteranceprogressdispatcher, Object obj, EventLogger eventlogger) {
        mItem = null;
        mStopped = false;
        mDone = false;
        mStreamType = i;
        mVolume = f;
        mPan = f1;
        mAudioTrackHandler = audioplaybackhandler;
        mDispatcher = utteranceprogressdispatcher;
        mCallerIdentity = obj;
        mLogger = eventlogger;
    }

    public int audioAvailable(byte abyte0[], int i, int j) {
        byte byte0;
        SynthesisPlaybackQueueItem synthesisplaybackqueueitem;
        byte abyte1[];
        byte0 = 0;
        if(j > getMaxBufferSize() || j <= 0)
            throw new IllegalArgumentException((new StringBuilder()).append("buffer is too large or of zero length (").append(j).append(" bytes)").toString());
        synchronized(mStateLock) {
            if(mItem == null || mStopped) {
                byte0 = -1;
                break MISSING_BLOCK_LABEL_134;
            }
            synthesisplaybackqueueitem = mItem;
        }
        abyte1 = new byte[j];
        System.arraycopy(abyte0, i, abyte1, 0, j);
        synthesisplaybackqueueitem.put(abyte1);
        mLogger.onEngineDataReceived();
        break MISSING_BLOCK_LABEL_134;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        InterruptedException interruptedexception;
        interruptedexception;
        byte0 = -1;
        return byte0;
    }

    public int done() {
        byte byte0 = -1;
        Object obj = mStateLock;
        obj;
        JVM INSTR monitorenter ;
        if(mDone) {
            Log.w("PlaybackSynthesisRequest", "Duplicate call to done()");
            break MISSING_BLOCK_LABEL_74;
        }
        mDone = true;
        if(mItem == null)
            break MISSING_BLOCK_LABEL_74;
        break MISSING_BLOCK_LABEL_52;
        Exception exception;
        exception;
        throw exception;
        SynthesisPlaybackQueueItem synthesisplaybackqueueitem = mItem;
        obj;
        JVM INSTR monitorexit ;
        synthesisplaybackqueueitem.done();
        mLogger.onEngineComplete();
        byte0 = 0;
        return byte0;
    }

    public void error() {
        mLogger.onError();
        stopImpl(true);
    }

    public int getMaxBufferSize() {
        return 8192;
    }

    boolean isDone() {
        return mDone;
    }

    public int start(int i, int j, int k) {
        byte byte0 = -1;
        if(BlockingAudioTrack.getChannelConfig(k) != 0) goto _L2; else goto _L1
_L1:
        Log.e("PlaybackSynthesisRequest", (new StringBuilder()).append("Unsupported number of channels :").append(k).toString());
_L4:
        return byte0;
_L2:
        Object obj = mStateLock;
        obj;
        JVM INSTR monitorenter ;
        if(mStopped)
            continue; /* Loop/switch isn't completed */
        break MISSING_BLOCK_LABEL_69;
        Exception exception;
        exception;
        throw exception;
        SynthesisPlaybackQueueItem synthesisplaybackqueueitem = new SynthesisPlaybackQueueItem(mStreamType, i, j, k, mVolume, mPan, mDispatcher, mCallerIdentity, mLogger);
        mAudioTrackHandler.enqueue(synthesisplaybackqueueitem);
        mItem = synthesisplaybackqueueitem;
        obj;
        JVM INSTR monitorexit ;
        byte0 = 0;
        if(true) goto _L4; else goto _L3
_L3:
    }

    void stop() {
        stopImpl(false);
    }

    void stopImpl(boolean flag) {
        mLogger.onStopped();
        SynthesisPlaybackQueueItem synthesisplaybackqueueitem;
        synchronized(mStateLock) {
            if(mStopped) {
                Log.w("PlaybackSynthesisRequest", "stop() called twice");
                break MISSING_BLOCK_LABEL_86;
            }
            synthesisplaybackqueueitem = mItem;
            mStopped = true;
        }
        if(synthesisplaybackqueueitem != null) {
            synthesisplaybackqueueitem.stop(flag);
        } else {
            mLogger.onWriteData();
            if(flag)
                mDispatcher.dispatchOnError();
        }
          goto _L1
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
    }

    private static final boolean DBG = false;
    private static final int MIN_AUDIO_BUFFER_SIZE = 8192;
    private static final String TAG = "PlaybackSynthesisRequest";
    private final AudioPlaybackHandler mAudioTrackHandler;
    private final Object mCallerIdentity;
    private final TextToSpeechService.UtteranceProgressDispatcher mDispatcher;
    private volatile boolean mDone;
    private SynthesisPlaybackQueueItem mItem;
    private final EventLogger mLogger;
    private final float mPan;
    private final Object mStateLock = new Object();
    private boolean mStopped;
    private final int mStreamType;
    private final float mVolume;
}
