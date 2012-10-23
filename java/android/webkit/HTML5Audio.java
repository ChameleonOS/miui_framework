// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.*;
import android.util.Log;
import java.io.IOException;
import java.util.*;

// Referenced classes of package android.webkit:
//            WebViewCore, CookieManager, WebViewClassic

class HTML5Audio extends Handler
    implements android.media.MediaPlayer.OnBufferingUpdateListener, android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnPreparedListener, android.media.MediaPlayer.OnSeekCompleteListener, android.media.AudioManager.OnAudioFocusChangeListener {
    private class IsPrivateBrowsingEnabledGetter {

        /**
         * @deprecated Method get is deprecated
         */

        boolean get() {
            this;
            JVM INSTR monitorenter ;
_L3:
            boolean flag = mIsReady;
            if(flag) goto _L2; else goto _L1
_L1:
            Exception exception;
            boolean flag1;
            try {
                wait();
            }
            catch(InterruptedException interruptedexception) { }
            finally {
                this;
            }
            if(true) goto _L3; else goto _L2
_L2:
            flag1 = mIsPrivateBrowsingEnabled;
            this;
            JVM INSTR monitorexit ;
            return flag1;
            throw exception;
        }

        private boolean mIsPrivateBrowsingEnabled;
        private boolean mIsReady;
        final HTML5Audio this$0;


/*
        static boolean access$002(IsPrivateBrowsingEnabledGetter isprivatebrowsingenabledgetter, boolean flag) {
            isprivatebrowsingenabledgetter.mIsPrivateBrowsingEnabled = flag;
            return flag;
        }

*/


/*
        static boolean access$102(IsPrivateBrowsingEnabledGetter isprivatebrowsingenabledgetter, boolean flag) {
            isprivatebrowsingenabledgetter.mIsReady = flag;
            return flag;
        }

*/

        IsPrivateBrowsingEnabledGetter(Looper looper, final WebViewClassic webView) {
            this$0 = HTML5Audio.this;
            super();
            (new Handler(looper)).post(new Runnable() {

                public void run() {
                    IsPrivateBrowsingEnabledGetter isprivatebrowsingenabledgetter = IsPrivateBrowsingEnabledGetter.this;
                    isprivatebrowsingenabledgetter;
                    JVM INSTR monitorenter ;
                    mIsPrivateBrowsingEnabled = webView.isPrivateBrowsingEnabled();
                    mIsReady = true;
                    notify();
                    return;
                }

                final IsPrivateBrowsingEnabledGetter this$1;
                final HTML5Audio val$this$0;
                final WebViewClassic val$webView;


// JavaClassFileOutputException: Invalid index accessing method local variables table of <init>
            });
        }
    }

    private final class TimeupdateTask extends TimerTask {

        public void run() {
            obtainMessage(100).sendToTarget();
        }

        final HTML5Audio this$0;

        private TimeupdateTask() {
            this$0 = HTML5Audio.this;
            super();
        }

    }


    public HTML5Audio(WebViewCore webviewcore, int i) {
        mState = IDLE;
        mAskToPlay = false;
        mLoopEnabled = false;
        mProcessingOnEnd = false;
        mNativePointer = i;
        resetMediaPlayer();
        mContext = webviewcore.getContext();
        mIsPrivateBrowsingEnabledGetter = new IsPrivateBrowsingEnabledGetter(webviewcore.getContext().getMainLooper(), webviewcore.getWebViewClassic());
    }

    private float getMaxTimeSeekable() {
        float f;
        if(mState >= PREPARED)
            f = (float)mMediaPlayer.getDuration() / 1000F;
        else
            f = 0.0F;
        return f;
    }

    private native void nativeOnBuffering(int i, int j);

    private native void nativeOnEnded(int i);

    private native void nativeOnPrepared(int i, int j, int k, int l);

    private native void nativeOnRequestPlay(int i);

    private native void nativeOnTimeupdate(int i, int j);

    private void pause() {
        if(mState == STARTED) {
            if(mTimer != null)
                mTimer.purge();
            mMediaPlayer.pause();
            mState = PAUSED;
        }
    }

    private void play() {
        if(mState != COMPLETE || !mLoopEnabled) goto _L2; else goto _L1
_L1:
        mMediaPlayer.start();
        mState = STARTED;
_L4:
        return;
_L2:
        if(mState >= ERROR && mState < PREPARED && mUrl != null) {
            resetMediaPlayer();
            setDataSource(mUrl);
            mAskToPlay = true;
        }
        if(mState >= PREPARED && ((AudioManager)mContext.getSystemService("audio")).requestAudioFocus(this, 3, 1) == 1) {
            mMediaPlayer.start();
            mState = STARTED;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void resetMediaPlayer() {
        if(mMediaPlayer == null)
            mMediaPlayer = new MediaPlayer();
        else
            mMediaPlayer.reset();
        mMediaPlayer.setOnBufferingUpdateListener(this);
        mMediaPlayer.setOnCompletionListener(this);
        mMediaPlayer.setOnErrorListener(this);
        mMediaPlayer.setOnPreparedListener(this);
        mMediaPlayer.setOnSeekCompleteListener(this);
        if(mTimer != null)
            mTimer.cancel();
        mTimer = new Timer();
        mState = IDLE;
    }

    private void seek(int i) {
        if(mProcessingOnEnd && mState == COMPLETE && i == 0)
            mLoopEnabled = true;
        if(mState >= PREPARED)
            mMediaPlayer.seekTo(i);
    }

    private void setDataSource(String s) {
        mUrl = s;
        if(mState != IDLE)
            resetMediaPlayer();
        String s2 = CookieManager.getInstance().getCookie(s, mIsPrivateBrowsingEnabledGetter.get());
        HashMap hashmap = new HashMap();
        if(s2 != null)
            hashmap.put("Cookie", s2);
        if(mIsPrivateBrowsingEnabledGetter.get())
            hashmap.put("x-hide-urls-from-log", "true");
        mMediaPlayer.setDataSource(s, hashmap);
        mState = INITIALIZED;
        mMediaPlayer.prepareAsync();
_L1:
        return;
        IOException ioexception;
        ioexception;
        String s1;
        if(s.length() > 128)
            s1 = (new StringBuilder()).append(s.substring(0, 128)).append("...").toString();
        else
            s1 = s;
        Log.e("HTML5Audio", (new StringBuilder()).append("couldn't load the resource: ").append(s1).append(" exc: ").append(ioexception).toString());
        resetMediaPlayer();
          goto _L1
    }

    private void teardown() {
        mMediaPlayer.release();
        mMediaPlayer = null;
        mState = ERROR;
        mNativePointer = 0;
    }

    public void handleMessage(Message message) {
        message.what;
        JVM INSTR tableswitch 100 100: default 24
    //                   100 25;
           goto _L1 _L2
_L1:
        return;
_L2:
        try {
            if(mState != ERROR && mMediaPlayer.isPlaying())
                nativeOnTimeupdate(mMediaPlayer.getCurrentPosition(), mNativePointer);
        }
        catch(IllegalStateException illegalstateexception) {
            mState = ERROR;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void onAudioFocusChange(int i) {
        i;
        JVM INSTR tableswitch -3 1: default 36
    //                   -3 125
    //                   -2 125
    //                   -1 88
    //                   0 36
    //                   1 37;
           goto _L1 _L2 _L2 _L3 _L1 _L4
_L1:
        return;
_L4:
        if(mMediaPlayer == null)
            resetMediaPlayer();
        else
        if(mState != ERROR && !mMediaPlayer.isPlaying()) {
            mMediaPlayer.start();
            mState = STARTED;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if(mState != ERROR && mMediaPlayer.isPlaying()) {
            mMediaPlayer.stop();
            mState = STOPPED;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if(mState != ERROR && mMediaPlayer.isPlaying())
            pause();
        if(true) goto _L1; else goto _L5
_L5:
    }

    public void onBufferingUpdate(MediaPlayer mediaplayer, int i) {
        nativeOnBuffering(i, mNativePointer);
    }

    public void onCompletion(MediaPlayer mediaplayer) {
        mState = COMPLETE;
        mProcessingOnEnd = true;
        nativeOnEnded(mNativePointer);
        mProcessingOnEnd = false;
        if(mLoopEnabled) {
            nativeOnRequestPlay(mNativePointer);
            mLoopEnabled = false;
        }
    }

    public boolean onError(MediaPlayer mediaplayer, int i, int j) {
        mState = ERROR;
        resetMediaPlayer();
        mState = IDLE;
        return false;
    }

    public void onPrepared(MediaPlayer mediaplayer) {
        mState = PREPARED;
        if(mTimer != null)
            mTimer.schedule(new TimeupdateTask(), 250L, 250L);
        nativeOnPrepared(mediaplayer.getDuration(), 0, 0, mNativePointer);
        if(mAskToPlay) {
            mAskToPlay = false;
            play();
        }
    }

    public void onSeekComplete(MediaPlayer mediaplayer) {
        nativeOnTimeupdate(mediaplayer.getCurrentPosition(), mNativePointer);
    }

    private static int COMPLETE = 0;
    private static final String COOKIE = "Cookie";
    private static int ERROR = 0;
    private static final String HIDE_URL_LOGS = "x-hide-urls-from-log";
    private static int IDLE = 0;
    private static int INITIALIZED = 0;
    private static final String LOGTAG = "HTML5Audio";
    private static int PAUSED = 0;
    private static int PREPARED = 0;
    private static int STARTED = 0;
    private static int STOPPED = 0;
    private static final int TIMEUPDATE = 100;
    private static final int TIMEUPDATE_PERIOD = 250;
    private boolean mAskToPlay;
    private Context mContext;
    private IsPrivateBrowsingEnabledGetter mIsPrivateBrowsingEnabledGetter;
    private boolean mLoopEnabled;
    private MediaPlayer mMediaPlayer;
    private int mNativePointer;
    private boolean mProcessingOnEnd;
    private int mState;
    private Timer mTimer;
    private String mUrl;

    static  {
        IDLE = 0;
        INITIALIZED = 1;
        PREPARED = 2;
        STARTED = 4;
        COMPLETE = 5;
        PAUSED = 6;
        STOPPED = -2;
        ERROR = -1;
    }
}
