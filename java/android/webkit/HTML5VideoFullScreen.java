// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.Metadata;
import android.view.*;
import android.widget.FrameLayout;
import android.widget.MediaController;

// Referenced classes of package android.webkit:
//            HTML5VideoView, HTML5VideoViewProxy, WebViewClassic, WebChromeClient, 
//            ViewManager

public class HTML5VideoFullScreen extends HTML5VideoView
    implements android.widget.MediaController.MediaPlayerControl, android.media.MediaPlayer.OnPreparedListener, android.view.View.OnTouchListener {
    static class FullScreenMediaController extends MediaController {

        public void hide() {
            if(mVideoView != null)
                mVideoView.setSystemUiVisibility(3);
            super.hide();
        }

        public void show() {
            super.show();
            if(mVideoView != null)
                mVideoView.setSystemUiVisibility(0);
        }

        View mVideoView;

        public FullScreenMediaController(Context context, View view) {
            super(context);
            mVideoView = view;
        }
    }

    private class VideoSurfaceView extends SurfaceView {

        protected void onMeasure(int i, int j) {
            int k;
            int l;
            k = getDefaultSize(mVideoWidth, i);
            l = getDefaultSize(mVideoHeight, j);
            if(mVideoWidth <= 0 || mVideoHeight <= 0) goto _L2; else goto _L1
_L1:
            if(l * mVideoWidth <= k * mVideoHeight) goto _L4; else goto _L3
_L3:
            l = (k * mVideoHeight) / mVideoWidth;
_L2:
            setMeasuredDimension(k, l);
            return;
_L4:
            if(l * mVideoWidth < k * mVideoHeight)
                k = (l * mVideoWidth) / mVideoHeight;
            if(true) goto _L2; else goto _L5
_L5:
        }

        final HTML5VideoFullScreen this$0;

        public VideoSurfaceView(Context context) {
            this$0 = HTML5VideoFullScreen.this;
            super(context);
        }
    }


    HTML5VideoFullScreen(Context context, int i, int j, boolean flag) {
        mSurfaceHolder = null;
        mSHCallback = new android.view.SurfaceHolder.Callback() {

            public void surfaceChanged(SurfaceHolder surfaceholder, int k, int l, int i1) {
                if(HTML5VideoView.mPlayer != null && mMediaController != null && HTML5VideoView.mCurrentState == 2) {
                    if(mMediaController.isShowing())
                        mMediaController.hide();
                    mMediaController.show();
                }
            }

            public void surfaceCreated(SurfaceHolder surfaceholder) {
                mSurfaceHolder = surfaceholder;
                mFullScreenMode = 2;
                prepareForFullScreen();
            }

            public void surfaceDestroyed(SurfaceHolder surfaceholder) {
                pauseAndDispatch(mProxy);
                HTML5VideoView.mPlayer.release();
                HTML5VideoView.mPlayer = null;
                mSurfaceHolder = null;
                if(mMediaController != null)
                    mMediaController.hide();
            }

            final HTML5VideoFullScreen this$0;

             {
                this$0 = HTML5VideoFullScreen.this;
                super();
            }
        };
        mSizeChangedListener = new android.media.MediaPlayer.OnVideoSizeChangedListener() {

            public void onVideoSizeChanged(MediaPlayer mediaplayer, int k, int l) {
                mVideoWidth = mediaplayer.getVideoWidth();
                mVideoHeight = mediaplayer.getVideoHeight();
                if(mVideoWidth != 0 && mVideoHeight != 0)
                    mVideoSurfaceView.getHolder().setFixedSize(mVideoWidth, mVideoHeight);
            }

            final HTML5VideoFullScreen this$0;

             {
                this$0 = HTML5VideoFullScreen.this;
                super();
            }
        };
        mBufferingUpdateListener = new android.media.MediaPlayer.OnBufferingUpdateListener() {

            public void onBufferingUpdate(MediaPlayer mediaplayer, int k) {
                mCurrentBufferPercentage = k;
            }

            final HTML5VideoFullScreen this$0;

             {
                this$0 = HTML5VideoFullScreen.this;
                super();
            }
        };
        mVideoSurfaceView = new VideoSurfaceView(context);
        mFullScreenMode = 0;
        mVideoWidth = 0;
        mVideoHeight = 0;
        init(i, j, flag);
    }

    private void attachMediaController() {
        if(mPlayer != null && mMediaController != null) {
            mMediaController.setMediaPlayer(this);
            mMediaController.setAnchorView(mVideoSurfaceView);
            mMediaController.setEnabled(false);
        }
    }

    private SurfaceView getSurfaceView() {
        return mVideoSurfaceView;
    }

    private void prepareForFullScreen() {
        FullScreenMediaController fullscreenmediacontroller = new FullScreenMediaController(super.mProxy.getContext(), mLayout);
        fullscreenmediacontroller.setSystemUiVisibility(mLayout.getSystemUiVisibility());
        setMediaController(fullscreenmediacontroller);
        mPlayer.setScreenOnWhilePlaying(true);
        mPlayer.setOnVideoSizeChangedListener(mSizeChangedListener);
        prepareDataAndDisplayMode(super.mProxy);
    }

    private void setMediaController(MediaController mediacontroller) {
        mMediaController = mediacontroller;
        attachMediaController();
    }

    private void toggleMediaControlsVisiblity() {
        if(mMediaController.isShowing())
            mMediaController.hide();
        else
            mMediaController.show();
    }

    public boolean canPause() {
        return mCanPause;
    }

    public boolean canSeekBackward() {
        return mCanSeekBack;
    }

    public boolean canSeekForward() {
        return mCanSeekForward;
    }

    public void decideDisplayMode() {
        mPlayer.setDisplay(mSurfaceHolder);
    }

    public void enterFullScreenVideoState(int i, HTML5VideoViewProxy html5videoviewproxy, WebViewClassic webviewclassic) {
        mFullScreenMode = 1;
        mCurrentBufferPercentage = 0;
        mPlayer.setOnBufferingUpdateListener(mBufferingUpdateListener);
        super.mProxy = html5videoviewproxy;
        mVideoSurfaceView.getHolder().addCallback(mSHCallback);
        mVideoSurfaceView.getHolder().setType(3);
        mVideoSurfaceView.setFocusable(true);
        mVideoSurfaceView.setFocusableInTouchMode(true);
        mVideoSurfaceView.requestFocus();
        mLayout = new FrameLayout(super.mProxy.getContext());
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-2, -2, 17);
        mLayout.addView(getSurfaceView(), layoutparams);
        mLayout.setVisibility(0);
        WebChromeClient webchromeclient = webviewclassic.getWebChromeClient();
        if(webchromeclient != null) {
            webchromeclient.onShowCustomView(mLayout, mCallback);
            if(webviewclassic.getViewManager() != null)
                webviewclassic.getViewManager().hideAll();
            mProgressView = webchromeclient.getVideoLoadingProgressView();
            if(mProgressView != null) {
                mLayout.addView(mProgressView, layoutparams);
                mProgressView.setVisibility(0);
            }
        }
    }

    public boolean fullScreenExited() {
        boolean flag;
        if(mLayout == null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public int getBufferPercentage() {
        int i;
        if(mPlayer != null)
            i = mCurrentBufferPercentage;
        else
            i = 0;
        return i;
    }

    public boolean isFullScreenMode() {
        return true;
    }

    public void onPrepared(MediaPlayer mediaplayer) {
        super.onPrepared(mediaplayer);
        mVideoSurfaceView.setOnTouchListener(this);
        Metadata metadata = mediaplayer.getMetadata(false, false);
        if(metadata != null) {
            boolean flag;
            boolean flag1;
            boolean flag2;
            if(!metadata.has(1) || metadata.getBoolean(1))
                flag = true;
            else
                flag = false;
            mCanPause = flag;
            if(!metadata.has(2) || metadata.getBoolean(2))
                flag1 = true;
            else
                flag1 = false;
            mCanSeekBack = flag1;
            if(!metadata.has(3) || metadata.getBoolean(3))
                flag2 = true;
            else
                flag2 = false;
            mCanSeekForward = flag2;
        } else {
            mCanSeekForward = true;
            mCanSeekBack = true;
            mCanPause = true;
        }
        if(mProgressView != null)
            mProgressView.setVisibility(8);
        mVideoWidth = mediaplayer.getVideoWidth();
        mVideoHeight = mediaplayer.getVideoHeight();
        mVideoSurfaceView.getHolder().setFixedSize(mVideoWidth, mVideoHeight);
        super.mProxy.dispatchOnRestoreState();
        if(getStartWhenPrepared()) {
            mPlayer.start();
            setStartWhenPrepared(false);
        }
        if(mMediaController != null) {
            mMediaController.setEnabled(true);
            mMediaController.show();
        }
    }

    public boolean onTouch(View view, MotionEvent motionevent) {
        if(mFullScreenMode >= 2 && mMediaController != null)
            toggleMediaControlsVisiblity();
        return false;
    }

    public void showControllerInFullScreen() {
        if(mMediaController != null)
            mMediaController.show(0);
    }

    protected void switchProgressView(boolean flag) {
        if(mProgressView != null)
            if(flag)
                mProgressView.setVisibility(0);
            else
                mProgressView.setVisibility(8);
    }

    static final int FULLSCREEN_OFF = 0;
    static final int FULLSCREEN_SURFACECREATED = 2;
    static final int FULLSCREEN_SURFACECREATING = 1;
    private static FrameLayout mLayout;
    private static View mProgressView;
    private android.media.MediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener;
    private final WebChromeClient.CustomViewCallback mCallback = new WebChromeClient.CustomViewCallback() {

        public void onCustomViewHidden() {
            mProxy.dispatchOnStopFullScreen();
            HTML5VideoFullScreen.mLayout.removeView(getSurfaceView());
            if(HTML5VideoFullScreen.mProgressView != null) {
                HTML5VideoFullScreen.mLayout.removeView(HTML5VideoFullScreen.mProgressView);
                HTML5VideoFullScreen.mProgressView = null;
            }
            HTML5VideoFullScreen.mLayout = null;
            mProxy.getWebView().getViewManager().showAll();
            mProxy = null;
            mMediaController = null;
            HTML5VideoView.mCurrentState = 4;
        }

        final HTML5VideoFullScreen this$0;

             {
                this$0 = HTML5VideoFullScreen.this;
                super();
            }
    };
    private boolean mCanPause;
    private boolean mCanSeekBack;
    private boolean mCanSeekForward;
    private int mCurrentBufferPercentage;
    private int mFullScreenMode;
    private MediaController mMediaController;
    android.view.SurfaceHolder.Callback mSHCallback;
    android.media.MediaPlayer.OnVideoSizeChangedListener mSizeChangedListener;
    private SurfaceHolder mSurfaceHolder;
    private int mVideoHeight;
    private VideoSurfaceView mVideoSurfaceView;
    private int mVideoWidth;



/*
    static int access$002(HTML5VideoFullScreen html5videofullscreen, int i) {
        html5videofullscreen.mVideoWidth = i;
        return i;
    }

*/



/*
    static int access$1002(HTML5VideoFullScreen html5videofullscreen, int i) {
        html5videofullscreen.mCurrentBufferPercentage = i;
        return i;
    }

*/


/*
    static int access$102(HTML5VideoFullScreen html5videofullscreen, int i) {
        html5videofullscreen.mVideoHeight = i;
        return i;
    }

*/



/*
    static MediaController access$202(HTML5VideoFullScreen html5videofullscreen, MediaController mediacontroller) {
        html5videofullscreen.mMediaController = mediacontroller;
        return mediacontroller;
    }

*/


/*
    static SurfaceHolder access$302(HTML5VideoFullScreen html5videofullscreen, SurfaceHolder surfaceholder) {
        html5videofullscreen.mSurfaceHolder = surfaceholder;
        return surfaceholder;
    }

*/


/*
    static int access$402(HTML5VideoFullScreen html5videofullscreen, int i) {
        html5videofullscreen.mFullScreenMode = i;
        return i;
    }

*/






/*
    static FrameLayout access$802(FrameLayout framelayout) {
        mLayout = framelayout;
        return framelayout;
    }

*/



/*
    static View access$902(View view) {
        mProgressView = view;
        return view;
    }

*/
}
