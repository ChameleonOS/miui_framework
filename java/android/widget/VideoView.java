// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.*;
import android.media.MediaPlayer;
import android.media.Metadata;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.*;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.io.IOException;
import java.util.Map;

// Referenced classes of package android.widget:
//            MediaController

public class VideoView extends SurfaceView
    implements MediaController.MediaPlayerControl {

    public VideoView(Context context) {
        super(context);
        TAG = "VideoView";
        mCurrentState = 0;
        mTargetState = 0;
        mSurfaceHolder = null;
        mMediaPlayer = null;
        initVideoView();
    }

    public VideoView(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0);
        initVideoView();
    }

    public VideoView(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        TAG = "VideoView";
        mCurrentState = 0;
        mTargetState = 0;
        mSurfaceHolder = null;
        mMediaPlayer = null;
        initVideoView();
    }

    private void attachMediaController() {
        if(mMediaPlayer != null && mMediaController != null) {
            mMediaController.setMediaPlayer(this);
            Object obj;
            if(getParent() instanceof View)
                obj = (View)getParent();
            else
                obj = this;
            mMediaController.setAnchorView(((View) (obj)));
            mMediaController.setEnabled(isInPlaybackState());
        }
    }

    private void initVideoView() {
        mVideoWidth = 0;
        mVideoHeight = 0;
        getHolder().addCallback(mSHCallback);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        mCurrentState = 0;
        mTargetState = 0;
    }

    private boolean isInPlaybackState() {
        boolean flag = true;
        if(mMediaPlayer == null || mCurrentState == -1 || mCurrentState == 0 || mCurrentState == flag)
            flag = false;
        return flag;
    }

    private void openVideo() {
        if(mUri != null && mSurfaceHolder != null) {
            Intent intent = new Intent("com.android.music.musicservicecommand");
            intent.putExtra("command", "pause");
            super.mContext.sendBroadcast(intent);
            release(false);
            try {
                mMediaPlayer = new MediaPlayer();
                mMediaPlayer.setOnPreparedListener(mPreparedListener);
                mMediaPlayer.setOnVideoSizeChangedListener(mSizeChangedListener);
                mDuration = -1;
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
                mMediaPlayer.setOnErrorListener(mErrorListener);
                mMediaPlayer.setOnBufferingUpdateListener(mBufferingUpdateListener);
                mCurrentBufferPercentage = 0;
                mMediaPlayer.setDataSource(super.mContext, mUri, mHeaders);
                mMediaPlayer.setDisplay(mSurfaceHolder);
                mMediaPlayer.setAudioStreamType(3);
                mMediaPlayer.setScreenOnWhilePlaying(true);
                mMediaPlayer.prepareAsync();
                mCurrentState = 1;
                attachMediaController();
            }
            catch(IOException ioexception) {
                Log.w(TAG, (new StringBuilder()).append("Unable to open content: ").append(mUri).toString(), ioexception);
                mCurrentState = -1;
                mTargetState = -1;
                mErrorListener.onError(mMediaPlayer, 1, 0);
            }
            catch(IllegalArgumentException illegalargumentexception) {
                Log.w(TAG, (new StringBuilder()).append("Unable to open content: ").append(mUri).toString(), illegalargumentexception);
                mCurrentState = -1;
                mTargetState = -1;
                mErrorListener.onError(mMediaPlayer, 1, 0);
            }
        }
    }

    private void release(boolean flag) {
        if(mMediaPlayer != null) {
            mMediaPlayer.reset();
            mMediaPlayer.release();
            mMediaPlayer = null;
            mCurrentState = 0;
            if(flag)
                mTargetState = 0;
        }
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

    public int getBufferPercentage() {
        int i;
        if(mMediaPlayer != null)
            i = mCurrentBufferPercentage;
        else
            i = 0;
        return i;
    }

    public int getCurrentPosition() {
        int i;
        if(isInPlaybackState())
            i = mMediaPlayer.getCurrentPosition();
        else
            i = 0;
        return i;
    }

    public int getDuration() {
        int i;
        if(isInPlaybackState()) {
            if(mDuration > 0) {
                i = mDuration;
            } else {
                mDuration = mMediaPlayer.getDuration();
                i = mDuration;
            }
        } else {
            mDuration = -1;
            i = mDuration;
        }
        return i;
    }

    public boolean isPlaying() {
        boolean flag;
        if(isInPlaybackState() && mMediaPlayer.isPlaying())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/VideoView.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/VideoView.getName());
    }

    public boolean onKeyDown(int i, KeyEvent keyevent) {
        boolean flag;
        flag = true;
        boolean flag1;
        if(i != 4 && i != 24 && i != 25 && i != 164 && i != 82 && i != 5 && i != 6)
            flag1 = flag;
        else
            flag1 = false;
        if(!isInPlaybackState() || !flag1 || mMediaController == null) goto _L2; else goto _L1
_L1:
        if(i != 79 && i != 85) goto _L4; else goto _L3
_L3:
        if(mMediaPlayer.isPlaying()) {
            pause();
            mMediaController.show();
        } else {
            start();
            mMediaController.hide();
        }
_L6:
        return flag;
_L4:
        if(i == 126) {
            if(!mMediaPlayer.isPlaying()) {
                start();
                mMediaController.hide();
            }
            continue; /* Loop/switch isn't completed */
        }
        if(i == 86 || i == 127) {
            if(mMediaPlayer.isPlaying()) {
                pause();
                mMediaController.show();
            }
            continue; /* Loop/switch isn't completed */
        }
        toggleMediaControlsVisiblity();
_L2:
        flag = super.onKeyDown(i, keyevent);
        if(true) goto _L6; else goto _L5
_L5:
    }

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

    public boolean onTouchEvent(MotionEvent motionevent) {
        if(isInPlaybackState() && mMediaController != null)
            toggleMediaControlsVisiblity();
        return false;
    }

    public boolean onTrackballEvent(MotionEvent motionevent) {
        if(isInPlaybackState() && mMediaController != null)
            toggleMediaControlsVisiblity();
        return false;
    }

    public void pause() {
        if(isInPlaybackState() && mMediaPlayer.isPlaying()) {
            mMediaPlayer.pause();
            mCurrentState = 4;
        }
        mTargetState = 4;
    }

    public int resolveAdjustedSize(int i, int j) {
        int k;
        int l;
        int i1;
        k = i;
        l = android.view.View.MeasureSpec.getMode(j);
        i1 = android.view.View.MeasureSpec.getSize(j);
        l;
        JVM INSTR lookupswitch 3: default 52
    //                   -2147483648: 59
    //                   0: 54
    //                   1073741824: 69;
           goto _L1 _L2 _L3 _L4
_L1:
        return k;
_L3:
        k = i;
        continue; /* Loop/switch isn't completed */
_L2:
        k = Math.min(i, i1);
        continue; /* Loop/switch isn't completed */
_L4:
        k = i1;
        if(true) goto _L1; else goto _L5
_L5:
    }

    public void resume() {
        openVideo();
    }

    public void seekTo(int i) {
        if(isInPlaybackState()) {
            mMediaPlayer.seekTo(i);
            mSeekWhenPrepared = 0;
        } else {
            mSeekWhenPrepared = i;
        }
    }

    public void setMediaController(MediaController mediacontroller) {
        if(mMediaController != null)
            mMediaController.hide();
        mMediaController = mediacontroller;
        attachMediaController();
    }

    public void setOnCompletionListener(android.media.MediaPlayer.OnCompletionListener oncompletionlistener) {
        mOnCompletionListener = oncompletionlistener;
    }

    public void setOnErrorListener(android.media.MediaPlayer.OnErrorListener onerrorlistener) {
        mOnErrorListener = onerrorlistener;
    }

    public void setOnPreparedListener(android.media.MediaPlayer.OnPreparedListener onpreparedlistener) {
        mOnPreparedListener = onpreparedlistener;
    }

    public void setVideoPath(String s) {
        setVideoURI(Uri.parse(s));
    }

    public void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    public void setVideoURI(Uri uri, Map map) {
        mUri = uri;
        mHeaders = map;
        mSeekWhenPrepared = 0;
        openVideo();
        requestLayout();
        invalidate();
    }

    public void start() {
        if(isInPlaybackState()) {
            mMediaPlayer.start();
            mCurrentState = 3;
        }
        mTargetState = 3;
    }

    public void stopPlayback() {
        if(mMediaPlayer != null) {
            mMediaPlayer.stop();
            mMediaPlayer.release();
            mMediaPlayer = null;
            mCurrentState = 0;
            mTargetState = 0;
        }
    }

    public void suspend() {
        release(false);
    }

    private static final int STATE_ERROR = -1;
    private static final int STATE_IDLE = 0;
    private static final int STATE_PAUSED = 4;
    private static final int STATE_PLAYBACK_COMPLETED = 5;
    private static final int STATE_PLAYING = 3;
    private static final int STATE_PREPARED = 2;
    private static final int STATE_PREPARING = 1;
    private String TAG;
    private android.media.MediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener = new android.media.MediaPlayer.OnBufferingUpdateListener() {

        public void onBufferingUpdate(MediaPlayer mediaplayer, int i) {
            mCurrentBufferPercentage = i;
        }

        final VideoView this$0;

             {
                this$0 = VideoView.this;
                super();
            }
    };
    private boolean mCanPause;
    private boolean mCanSeekBack;
    private boolean mCanSeekForward;
    private android.media.MediaPlayer.OnCompletionListener mCompletionListener = new android.media.MediaPlayer.OnCompletionListener() {

        public void onCompletion(MediaPlayer mediaplayer) {
            mCurrentState = 5;
            mTargetState = 5;
            if(mMediaController != null)
                mMediaController.hide();
            if(mOnCompletionListener != null)
                mOnCompletionListener.onCompletion(mMediaPlayer);
        }

        final VideoView this$0;

             {
                this$0 = VideoView.this;
                super();
            }
    };
    private int mCurrentBufferPercentage;
    private int mCurrentState;
    private int mDuration;
    private android.media.MediaPlayer.OnErrorListener mErrorListener = new android.media.MediaPlayer.OnErrorListener() ;
    private Map mHeaders;
    private MediaController mMediaController;
    private MediaPlayer mMediaPlayer;
    private android.media.MediaPlayer.OnCompletionListener mOnCompletionListener;
    private android.media.MediaPlayer.OnErrorListener mOnErrorListener;
    private android.media.MediaPlayer.OnPreparedListener mOnPreparedListener;
    android.media.MediaPlayer.OnPreparedListener mPreparedListener = new android.media.MediaPlayer.OnPreparedListener() {

        public void onPrepared(MediaPlayer mediaplayer) {
            int i;
            mCurrentState = 2;
            Metadata metadata = mediaplayer.getMetadata(false, false);
            if(metadata != null) {
                VideoView videoview = VideoView.this;
                boolean flag;
                VideoView videoview1;
                boolean flag1;
                VideoView videoview2;
                boolean flag2;
                if(!metadata.has(1) || metadata.getBoolean(1))
                    flag = true;
                else
                    flag = false;
                videoview.mCanPause = flag;
                videoview1 = VideoView.this;
                if(!metadata.has(2) || metadata.getBoolean(2))
                    flag1 = true;
                else
                    flag1 = false;
                videoview1.mCanSeekBack = flag1;
                videoview2 = VideoView.this;
                if(!metadata.has(3) || metadata.getBoolean(3))
                    flag2 = true;
                else
                    flag2 = false;
                videoview2.mCanSeekForward = flag2;
            } else {
                mCanPause = mCanSeekBack = mCanSeekForward = true;
            }
            if(mOnPreparedListener != null)
                mOnPreparedListener.onPrepared(mMediaPlayer);
            if(mMediaController != null)
                mMediaController.setEnabled(true);
            mVideoWidth = mediaplayer.getVideoWidth();
            mVideoHeight = mediaplayer.getVideoHeight();
            i = mSeekWhenPrepared;
            if(i != 0)
                seekTo(i);
            if(mVideoWidth == 0 || mVideoHeight == 0) goto _L2; else goto _L1
_L1:
            getHolder().setFixedSize(mVideoWidth, mVideoHeight);
            if(mSurfaceWidth != mVideoWidth || mSurfaceHeight != mVideoHeight) goto _L4; else goto _L3
_L3:
            if(mTargetState != 3) goto _L6; else goto _L5
_L5:
            start();
            if(mMediaController != null)
                mMediaController.show();
_L4:
            return;
_L6:
            if(!isPlaying() && (i != 0 || getCurrentPosition() > 0) && mMediaController != null)
                mMediaController.show(0);
            continue; /* Loop/switch isn't completed */
_L2:
            if(mTargetState == 3)
                start();
            if(true) goto _L4; else goto _L7
_L7:
        }

        final VideoView this$0;

             {
                this$0 = VideoView.this;
                super();
            }
    };
    android.view.SurfaceHolder.Callback mSHCallback = new android.view.SurfaceHolder.Callback() {

        public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k) {
            mSurfaceWidth = j;
            mSurfaceHeight = k;
            boolean flag;
            boolean flag1;
            if(mTargetState == 3)
                flag = true;
            else
                flag = false;
            if(mVideoWidth == j && mVideoHeight == k)
                flag1 = true;
            else
                flag1 = false;
            if(mMediaPlayer != null && flag && flag1) {
                if(mSeekWhenPrepared != 0)
                    seekTo(mSeekWhenPrepared);
                start();
            }
        }

        public void surfaceCreated(SurfaceHolder surfaceholder) {
            mSurfaceHolder = surfaceholder;
            openVideo();
        }

        public void surfaceDestroyed(SurfaceHolder surfaceholder) {
            mSurfaceHolder = null;
            if(mMediaController != null)
                mMediaController.hide();
            release(true);
        }

        final VideoView this$0;

             {
                this$0 = VideoView.this;
                super();
            }
    };
    private int mSeekWhenPrepared;
    android.media.MediaPlayer.OnVideoSizeChangedListener mSizeChangedListener = new android.media.MediaPlayer.OnVideoSizeChangedListener() {

        public void onVideoSizeChanged(MediaPlayer mediaplayer, int i, int j) {
            mVideoWidth = mediaplayer.getVideoWidth();
            mVideoHeight = mediaplayer.getVideoHeight();
            if(mVideoWidth != 0 && mVideoHeight != 0)
                getHolder().setFixedSize(mVideoWidth, mVideoHeight);
        }

        final VideoView this$0;

             {
                this$0 = VideoView.this;
                super();
            }
    };
    private int mSurfaceHeight;
    private SurfaceHolder mSurfaceHolder;
    private int mSurfaceWidth;
    private int mTargetState;
    private Uri mUri;
    private int mVideoHeight;
    private int mVideoWidth;



/*
    static int access$002(VideoView videoview, int i) {
        videoview.mVideoWidth = i;
        return i;
    }

*/




/*
    static int access$1002(VideoView videoview, int i) {
        videoview.mSurfaceWidth = i;
        return i;
    }

*/


/*
    static int access$102(VideoView videoview, int i) {
        videoview.mVideoHeight = i;
        return i;
    }

*/



/*
    static int access$1102(VideoView videoview, int i) {
        videoview.mSurfaceHeight = i;
        return i;
    }

*/



/*
    static int access$1202(VideoView videoview, int i) {
        videoview.mTargetState = i;
        return i;
    }

*/







/*
    static int access$1802(VideoView videoview, int i) {
        videoview.mCurrentBufferPercentage = i;
        return i;
    }

*/


/*
    static SurfaceHolder access$1902(VideoView videoview, SurfaceHolder surfaceholder) {
        videoview.mSurfaceHolder = surfaceholder;
        return surfaceholder;
    }

*/



/*
    static int access$202(VideoView videoview, int i) {
        videoview.mCurrentState = i;
        return i;
    }

*/



/*
    static boolean access$302(VideoView videoview, boolean flag) {
        videoview.mCanPause = flag;
        return flag;
    }

*/


/*
    static boolean access$402(VideoView videoview, boolean flag) {
        videoview.mCanSeekBack = flag;
        return flag;
    }

*/


/*
    static boolean access$502(VideoView videoview, boolean flag) {
        videoview.mCanSeekForward = flag;
        return flag;
    }

*/




}
