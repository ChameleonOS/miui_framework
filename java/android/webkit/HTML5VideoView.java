// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.media.MediaPlayer;
import android.net.Uri;
import java.io.IOException;
import java.util.*;

// Referenced classes of package android.webkit:
//            HTML5VideoViewProxy, WebViewClassic, CookieManager

public class HTML5VideoView
    implements android.media.MediaPlayer.OnPreparedListener {
    private static final class TimeupdateTask extends TimerTask {

        public void run() {
            mProxy.onTimeupdate();
        }

        private HTML5VideoViewProxy mProxy;

        public TimeupdateTask(HTML5VideoViewProxy html5videoviewproxy) {
            mProxy = html5videoviewproxy;
        }
    }


    protected HTML5VideoView() {
        mSkipPrepare = false;
        mPlayerBuffering = false;
        mStartWhenPrepared = false;
    }

    protected static Map generateHeaders(String s, HTML5VideoViewProxy html5videoviewproxy) {
        boolean flag = html5videoviewproxy.getWebView().isPrivateBrowsingEnabled();
        String s1 = CookieManager.getInstance().getCookie(s, flag);
        HashMap hashmap = new HashMap();
        if(s1 != null)
            hashmap.put("Cookie", s1);
        if(flag)
            hashmap.put("x-hide-urls-from-log", "true");
        return hashmap;
    }

    public void decideDisplayMode() {
    }

    public void deleteSurfaceTexture() {
    }

    public void enterFullScreenVideoState(int i, HTML5VideoViewProxy html5videoviewproxy, WebViewClassic webviewclassic) {
    }

    public boolean fullScreenExited() {
        return false;
    }

    public int getCurrentPosition() {
        int i;
        if(mCurrentState == 2)
            i = mPlayer.getCurrentPosition();
        else
            i = 0;
        return i;
    }

    public int getCurrentState() {
        int i;
        if(isPlaying())
            i = 3;
        else
            i = mCurrentState;
        return i;
    }

    public int getDuration() {
        int i;
        if(mCurrentState == 2)
            i = mPlayer.getDuration();
        else
            i = -1;
        return i;
    }

    public boolean getPauseDuringPreparing() {
        return mPauseDuringPreparing;
    }

    public boolean getPlayerBuffering() {
        return mPlayerBuffering;
    }

    public boolean getReadyToUseSurfTex() {
        return false;
    }

    public boolean getStartWhenPrepared() {
        return mStartWhenPrepared;
    }

    public int getTextureName() {
        return 0;
    }

    public int getVideoLayerId() {
        return mVideoLayerId;
    }

    public void init(int i, int j, boolean flag) {
        if(mPlayer == null) {
            mPlayer = new MediaPlayer();
            mCurrentState = 0;
        }
        mSkipPrepare = flag;
        if(!mSkipPrepare)
            mCurrentState = 0;
        mProxy = null;
        mVideoLayerId = i;
        mSaveSeekTime = j;
        mTimer = null;
        mPauseDuringPreparing = false;
    }

    public boolean isFullScreenMode() {
        return false;
    }

    public boolean isPlaying() {
        boolean flag;
        if(mCurrentState == 2)
            flag = mPlayer.isPlaying();
        else
            flag = false;
        return flag;
    }

    public void onPrepared(MediaPlayer mediaplayer) {
        mCurrentState = 2;
        seekTo(mSaveSeekTime);
        if(mProxy != null)
            mProxy.onPrepared(mediaplayer);
        if(mPauseDuringPreparing) {
            pauseAndDispatch(mProxy);
            mPauseDuringPreparing = false;
        }
    }

    public void pause() {
        if(!isPlaying()) goto _L2; else goto _L1
_L1:
        mPlayer.pause();
_L4:
        if(mTimer != null) {
            mTimer.purge();
            mTimer.cancel();
            mTimer = null;
        }
        return;
_L2:
        if(mCurrentState == 1)
            mPauseDuringPreparing = true;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void pauseAndDispatch(HTML5VideoViewProxy html5videoviewproxy) {
        pause();
        if(html5videoviewproxy != null)
            html5videoviewproxy.dispatchOnPaused();
    }

    public void prepareDataAndDisplayMode(HTML5VideoViewProxy html5videoviewproxy) {
        decideDisplayMode();
        setOnCompletionListener(html5videoviewproxy);
        setOnPreparedListener(html5videoviewproxy);
        setOnErrorListener(html5videoviewproxy);
        setOnInfoListener(html5videoviewproxy);
        prepareDataCommon(html5videoviewproxy);
    }

    public void prepareDataCommon(HTML5VideoViewProxy html5videoviewproxy) {
        if(!mSkipPrepare) {
            try {
                mPlayer.reset();
                mPlayer.setDataSource(html5videoviewproxy.getContext(), mUri, mHeaders);
                mPlayer.prepareAsync();
            }
            catch(IllegalArgumentException illegalargumentexception) {
                illegalargumentexception.printStackTrace();
            }
            catch(IllegalStateException illegalstateexception) {
                illegalstateexception.printStackTrace();
            }
            catch(IOException ioexception) {
                ioexception.printStackTrace();
            }
            mCurrentState = 1;
        } else {
            if(mCurrentState >= 2)
                onPrepared(mPlayer);
            mSkipPrepare = false;
        }
    }

    public void reprepareData(HTML5VideoViewProxy html5videoviewproxy) {
        mPlayer.reset();
        prepareDataCommon(html5videoviewproxy);
    }

    public void reset() {
        if(mCurrentState != 4)
            mPlayer.reset();
        mCurrentState = 4;
    }

    public void seekTo(int i) {
        if(mCurrentState == 2)
            mPlayer.seekTo(i);
        else
            mSaveSeekTime = i;
    }

    public void setOnCompletionListener(HTML5VideoViewProxy html5videoviewproxy) {
        mPlayer.setOnCompletionListener(html5videoviewproxy);
    }

    public void setOnErrorListener(HTML5VideoViewProxy html5videoviewproxy) {
        mPlayer.setOnErrorListener(html5videoviewproxy);
    }

    public void setOnInfoListener(HTML5VideoViewProxy html5videoviewproxy) {
        mPlayer.setOnInfoListener(html5videoviewproxy);
    }

    public void setOnPreparedListener(HTML5VideoViewProxy html5videoviewproxy) {
        mProxy = html5videoviewproxy;
        mPlayer.setOnPreparedListener(this);
    }

    public void setPlayerBuffering(boolean flag) {
        mPlayerBuffering = flag;
        switchProgressView(flag);
    }

    public void setStartWhenPrepared(boolean flag) {
        mStartWhenPrepared = flag;
    }

    public void setVideoURI(String s, HTML5VideoViewProxy html5videoviewproxy) {
        mUri = Uri.parse(s);
        mHeaders = generateHeaders(s, html5videoviewproxy);
    }

    public void showControllerInFullScreen() {
    }

    public void start() {
        if(mCurrentState == 2) {
            if(mTimer == null) {
                mTimer = new Timer();
                mTimer.schedule(new TimeupdateTask(mProxy), 250L, 250L);
            }
            mPlayer.start();
            setPlayerBuffering(false);
        }
    }

    public void stopPlayback() {
        if(mCurrentState == 2)
            mPlayer.stop();
    }

    public boolean surfaceTextureDeleted() {
        return false;
    }

    protected void switchProgressView(boolean flag) {
    }

    protected static final String COOKIE = "Cookie";
    protected static final String HIDE_URL_LOGS = "x-hide-urls-from-log";
    protected static final String LOGTAG = "HTML5VideoView";
    static final int STATE_INITIALIZED = 0;
    static final int STATE_PLAYING = 3;
    static final int STATE_PREPARED = 2;
    static final int STATE_PREPARING = 1;
    static final int STATE_RESETTED = 4;
    private static final int TIMEUPDATE_PERIOD = 250;
    protected static int mCurrentState = -1;
    protected static MediaPlayer mPlayer = null;
    protected static Timer mTimer;
    protected Map mHeaders;
    protected boolean mPauseDuringPreparing;
    public boolean mPlayerBuffering;
    protected HTML5VideoViewProxy mProxy;
    protected int mSaveSeekTime;
    private boolean mSkipPrepare;
    private boolean mStartWhenPrepared;
    protected Uri mUri;
    protected int mVideoLayerId;

}
