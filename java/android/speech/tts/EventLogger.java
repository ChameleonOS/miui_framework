// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.speech.tts;

import android.os.SystemClock;
import android.text.TextUtils;

// Referenced classes of package android.speech.tts:
//            SynthesisRequest, EventLogTags

class EventLogger {

    EventLogger(SynthesisRequest synthesisrequest, int i, int j, String s) {
        mPlaybackStartTime = -1L;
        mRequestProcessingStartTime = -1L;
        mEngineStartTime = -1L;
        mEngineCompleteTime = -1L;
        mError = false;
        mStopped = false;
        mLogWritten = false;
        mRequest = synthesisrequest;
        mCallerUid = i;
        mCallerPid = j;
        mServiceApp = s;
    }

    private String getLocaleString() {
        StringBuilder stringbuilder = new StringBuilder(mRequest.getLanguage());
        if(!TextUtils.isEmpty(mRequest.getCountry())) {
            stringbuilder.append('-');
            stringbuilder.append(mRequest.getCountry());
            if(!TextUtils.isEmpty(mRequest.getVariant())) {
                stringbuilder.append('-');
                stringbuilder.append(mRequest.getVariant());
            }
        }
        return stringbuilder.toString();
    }

    private int getUtteranceLength() {
        String s = mRequest.getText();
        int i;
        if(s == null)
            i = 0;
        else
            i = s.length();
        return i;
    }

    public void onAudioDataWritten() {
        if(mPlaybackStartTime == -1L)
            mPlaybackStartTime = SystemClock.elapsedRealtime();
    }

    public void onEngineComplete() {
        mEngineCompleteTime = SystemClock.elapsedRealtime();
    }

    public void onEngineDataReceived() {
        if(mEngineStartTime == -1L)
            mEngineStartTime = SystemClock.elapsedRealtime();
    }

    public void onError() {
        mError = true;
    }

    public void onRequestProcessingStart() {
        mRequestProcessingStartTime = SystemClock.elapsedRealtime();
    }

    public void onStopped() {
        mStopped = false;
    }

    public void onWriteData() {
        if(!mLogWritten) goto _L2; else goto _L1
_L1:
        return;
_L2:
        mLogWritten = true;
        SystemClock.elapsedRealtime();
        if(mError || mPlaybackStartTime == -1L || mEngineCompleteTime == -1L)
            EventLogTags.writeTtsSpeakFailure(mServiceApp, mCallerUid, mCallerPid, getUtteranceLength(), getLocaleString(), mRequest.getSpeechRate(), mRequest.getPitch());
        else
        if(!mStopped) {
            long l = mPlaybackStartTime - mReceivedTime;
            long l1 = mEngineStartTime - mRequestProcessingStartTime;
            long l2 = mEngineCompleteTime - mRequestProcessingStartTime;
            EventLogTags.writeTtsSpeakSuccess(mServiceApp, mCallerUid, mCallerPid, getUtteranceLength(), getLocaleString(), mRequest.getSpeechRate(), mRequest.getPitch(), l1, l2, l);
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private final int mCallerPid;
    private final int mCallerUid;
    private volatile long mEngineCompleteTime;
    private volatile long mEngineStartTime;
    private volatile boolean mError;
    private boolean mLogWritten;
    private long mPlaybackStartTime;
    private final long mReceivedTime = SystemClock.elapsedRealtime();
    private final SynthesisRequest mRequest;
    private volatile long mRequestProcessingStartTime;
    private final String mServiceApp;
    private volatile boolean mStopped;
}
