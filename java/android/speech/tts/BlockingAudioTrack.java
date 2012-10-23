// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.speech.tts;

import android.media.AudioTrack;
import android.util.Log;

class BlockingAudioTrack {

    BlockingAudioTrack(int i, int j, int k, int l, float f, float f1) {
        mBytesWritten = 0;
        mStreamType = i;
        mSampleRateInHz = j;
        mAudioFormat = k;
        mChannelCount = l;
        mVolume = f;
        mPan = f1;
        mBytesPerFrame = getBytesPerFrame(mAudioFormat) * mChannelCount;
        mIsShortUtterance = false;
        mAudioBufferSize = 0;
        mBytesWritten = 0;
        mAudioTrack = null;
        mStopped = false;
    }

    private void blockUntilCompletion(AudioTrack audiotrack) {
        int i;
        int j;
        long l;
        i = mBytesWritten / mBytesPerFrame;
        j = -1;
        l = 0L;
_L7:
        int k = audiotrack.getPlaybackHeadPosition();
        if(k >= i || audiotrack.getPlayState() != 3 || mStopped) goto _L2; else goto _L1
_L1:
        long l1 = clip((1000 * (i - k)) / audiotrack.getSampleRate(), 20L, 2500L);
        if(k != j) goto _L4; else goto _L3
_L3:
        l += l1;
        if(l <= 2500L) goto _L6; else goto _L5
_L5:
        Log.w("TTS.BlockingAudioTrack", "Waited unsuccessfully for 2500ms for AudioTrack to make progress, Aborting");
_L2:
        return;
_L4:
        l = 0L;
_L6:
        j = k;
        Thread.sleep(l1);
          goto _L7
        InterruptedException interruptedexception;
        interruptedexception;
          goto _L2
    }

    private void blockUntilDone(AudioTrack audiotrack) {
        if(mBytesWritten > 0)
            if(mIsShortUtterance)
                blockUntilEstimatedCompletion();
            else
                blockUntilCompletion(audiotrack);
    }

    private void blockUntilEstimatedCompletion() {
        long l = (1000 * (mBytesWritten / mBytesPerFrame)) / mSampleRateInHz;
        Thread.sleep(l);
_L2:
        return;
        InterruptedException interruptedexception;
        interruptedexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private static float clip(float f, float f1, float f2) {
        if(f <= f2)
            if(f < f1)
                f2 = f1;
            else
                f2 = f;
        return f2;
    }

    private static final long clip(long l, long l1, long l2) {
        if(l >= l1)
            if(l > l2)
                l1 = l2;
            else
                l1 = l;
        return l1;
    }

    private AudioTrack createStreamingAudioTrack() {
        int i = getChannelConfig(mChannelCount);
        int j = Math.max(8192, AudioTrack.getMinBufferSize(mSampleRateInHz, i, mAudioFormat));
        AudioTrack audiotrack = new AudioTrack(mStreamType, mSampleRateInHz, i, mAudioFormat, j, 1);
        if(audiotrack.getState() != 1) {
            Log.w("TTS.BlockingAudioTrack", "Unable to create audio track.");
            audiotrack.release();
            audiotrack = null;
        } else {
            mAudioBufferSize = j;
            setupVolume(audiotrack, mVolume, mPan);
        }
        return audiotrack;
    }

    private static int getBytesPerFrame(int i) {
        byte byte0 = 2;
        if(i != 3) goto _L2; else goto _L1
_L1:
        byte0 = 1;
_L4:
        return byte0;
_L2:
        if(i != byte0)
            byte0 = -1;
        if(true) goto _L4; else goto _L3
_L3:
    }

    static int getChannelConfig(int i) {
        byte byte0;
        if(i == 1)
            byte0 = 4;
        else
        if(i == 2)
            byte0 = 12;
        else
            byte0 = 0;
        return byte0;
    }

    private static void setupVolume(AudioTrack audiotrack, float f, float f1) {
        float f3;
        float f4;
        float f5;
        float f2 = clip(f, 0.0F, 1.0F);
        f3 = clip(f1, -1F, 1.0F);
        f4 = f2;
        f5 = f2;
        if(f3 <= 0.0F) goto _L2; else goto _L1
_L1:
        f4 *= 1.0F - f3;
_L4:
        if(audiotrack.setStereoVolume(f4, f5) != 0)
            Log.e("TTS.BlockingAudioTrack", "Failed to set volume");
        return;
_L2:
        if(f3 < 0.0F)
            f5 *= 1.0F + f3;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static int writeToAudioTrack(AudioTrack audiotrack, byte abyte0[]) {
        if(audiotrack.getPlayState() != 3)
            audiotrack.play();
        int i = 0;
        do {
            int j;
label0:
            {
                if(i < abyte0.length) {
                    j = audiotrack.write(abyte0, i, abyte0.length);
                    if(j > 0)
                        break label0;
                }
                return i;
            }
            i += j;
        } while(true);
    }

    long getAudioLengthMs(int i) {
        return (long)((1000 * (i / mBytesPerFrame)) / mSampleRateInHz);
    }

    public void init() {
        AudioTrack audiotrack = createStreamingAudioTrack();
        Object obj = mAudioTrackLock;
        obj;
        JVM INSTR monitorenter ;
        mAudioTrack = audiotrack;
        return;
    }

    public void stop() {
        synchronized(mAudioTrackLock) {
            if(mAudioTrack != null)
                mAudioTrack.stop();
        }
        mStopped = true;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void waitAndRelease() {
        if(mBytesWritten < mAudioBufferSize && !mStopped) {
            mIsShortUtterance = true;
            mAudioTrack.stop();
        }
        if(!mStopped)
            blockUntilDone(mAudioTrack);
        Object obj = mAudioTrackLock;
        obj;
        JVM INSTR monitorenter ;
        mAudioTrack.release();
        mAudioTrack = null;
        return;
    }

    public int write(byte abyte0[]) {
        int i;
        if(mAudioTrack == null || mStopped) {
            i = -1;
        } else {
            i = writeToAudioTrack(mAudioTrack, abyte0);
            mBytesWritten = i + mBytesWritten;
        }
        return i;
    }

    private static final boolean DBG = false;
    private static final long MAX_PROGRESS_WAIT_MS = 2500L;
    private static final long MAX_SLEEP_TIME_MS = 2500L;
    private static final int MIN_AUDIO_BUFFER_SIZE = 8192;
    private static final long MIN_SLEEP_TIME_MS = 20L;
    private static final String TAG = "TTS.BlockingAudioTrack";
    private int mAudioBufferSize;
    private final int mAudioFormat;
    private AudioTrack mAudioTrack;
    private final Object mAudioTrackLock = new Object();
    private final int mBytesPerFrame;
    private int mBytesWritten;
    private final int mChannelCount;
    private boolean mIsShortUtterance;
    private final float mPan;
    private final int mSampleRateInHz;
    private volatile boolean mStopped;
    private final int mStreamType;
    private final float mVolume;
}
