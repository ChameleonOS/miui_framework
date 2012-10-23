// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.*;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

// Referenced classes of package android.widget:
//            FrameLayout, MiuiMediaController, MiuiMediaTimeBar, LinearLayout, 
//            ProgressBar, ImageView, TextView

public class MiuiMovieController extends FrameLayout
    implements MiuiMediaController, android.view.View.OnClickListener, android.view.animation.Animation.AnimationListener, MiuiMediaTimeBar.ScrubbingListener {
    private static final class State extends Enum {

        public static State valueOf(String s) {
            return (State)Enum.valueOf(android/widget/MiuiMovieController$State, s);
        }

        public static State[] values() {
            return (State[])$VALUES.clone();
        }

        private static final State $VALUES[];
        public static final State ENDED;
        public static final State ERROR;
        public static final State LOADING;
        public static final State PAUSED;
        public static final State PLAYING;

        static  {
            PLAYING = new State("PLAYING", 0);
            PAUSED = new State("PAUSED", 1);
            ENDED = new State("ENDED", 2);
            ERROR = new State("ERROR", 3);
            LOADING = new State("LOADING", 4);
            State astate[] = new State[5];
            astate[0] = PLAYING;
            astate[1] = PAUSED;
            astate[2] = ENDED;
            astate[3] = ERROR;
            astate[4] = LOADING;
            $VALUES = astate;
        }

        private State(String s, int i) {
            super(s, i);
        }
    }


    public MiuiMovieController(Context context) {
        super(context);
        canReplay = true;
        state = State.LOADING;
        FrameLayout.LayoutParams layoutparams = new FrameLayout.LayoutParams(-2, -2);
        FrameLayout.LayoutParams layoutparams1 = new FrameLayout.LayoutParams(-1, -1);
        LayoutInflater.from(context);
        background = new View(context);
        background.setBackgroundColor(context.getResources().getColor(0x6070021));
        addView(background, layoutparams1);
        timeBar = new MiuiMediaTimeBar(context, this);
        addView(timeBar, layoutparams);
        loadingView = new LinearLayout(context);
        loadingView.setOrientation(1);
        loadingView.setGravity(1);
        ProgressBar progressbar = new ProgressBar(context);
        progressbar.setIndeterminate(true);
        loadingView.addView(progressbar, layoutparams);
        addView(loadingView, layoutparams);
        playPauseReplayView = new ImageView(context);
        playPauseReplayView.setImageResource(0x60201d6);
        playPauseReplayView.setBackgroundResource(0x60201d9);
        playPauseReplayView.setScaleType(ImageView.ScaleType.CENTER);
        playPauseReplayView.setFocusable(true);
        playPauseReplayView.setClickable(true);
        playPauseReplayView.setOnClickListener(this);
        addView(playPauseReplayView, layoutparams);
        errorView = new TextView(context);
        errorView.setGravity(17);
        errorView.setBackgroundColor(0xcc000000);
        errorView.setTextColor(-1);
        addView(errorView, layoutparams1);
        hideAnimation = AnimationUtils.loadAnimation(context, 0x604000f);
        hideAnimation.setAnimationListener(this);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        hide();
    }

    private void cancelHiding() {
        handler.removeCallbacks(startHidingRunnable);
        background.setAnimation(null);
        timeBar.setAnimation(null);
        playPauseReplayView.setAnimation(null);
    }

    private void layoutCenteredView(View view, int i, int j, int k, int l) {
        int i1 = view.getMeasuredWidth();
        int j1 = view.getMeasuredHeight();
        int k1 = (k - i - i1) / 2;
        int l1 = (l - j - j1) / 2;
        view.layout(k1, l1, k1 + i1, l1 + j1);
    }

    private void maybeStartHiding() {
        cancelHiding();
        if(state == State.PLAYING)
            handler.postDelayed(startHidingRunnable, 1500L);
    }

    private void showMainView(View view) {
        int i = 0;
        mainView = view;
        TextView textview = errorView;
        int j;
        LinearLayout linearlayout;
        int k;
        ImageView imageview;
        if(mainView == errorView)
            j = 0;
        else
            j = 4;
        textview.setVisibility(j);
        linearlayout = loadingView;
        if(mainView == loadingView)
            k = 0;
        else
            k = 4;
        linearlayout.setVisibility(k);
        imageview = playPauseReplayView;
        if(mainView != playPauseReplayView)
            i = 4;
        imageview.setVisibility(i);
        show();
    }

    private void startHideAnimation(View view) {
        if(view.getVisibility() == 0)
            view.startAnimation(hideAnimation);
    }

    private void startHiding() {
        startHideAnimation(timeBar);
        startHideAnimation(playPauseReplayView);
    }

    private void updateViews() {
        if(!hidden) goto _L2; else goto _L1
_L1:
        return;
_L2:
        ImageView imageview;
        background.setVisibility(0);
        timeBar.setVisibility(0);
        imageview = playPauseReplayView;
        if(state != State.PAUSED) goto _L4; else goto _L3
_L3:
        int i = 0x60201d6;
_L5:
        imageview.setImageResource(i);
        ImageView imageview1 = playPauseReplayView;
        int j;
        if(state != State.LOADING && state != State.ERROR && (state != State.ENDED || canReplay))
            j = 0;
        else
            j = 8;
        imageview1.setVisibility(j);
        requestLayout();
        if(true) goto _L1; else goto _L4
_L4:
        if(state == State.PLAYING)
            i = 0x60201d7;
        else
            i = 0x60201d8;
          goto _L5
    }

    public View getView() {
        return this;
    }

    public void hide() {
        boolean flag = hidden;
        hidden = true;
        playPauseReplayView.setVisibility(4);
        loadingView.setVisibility(4);
        background.setVisibility(4);
        timeBar.setVisibility(4);
        setVisibility(4);
        setFocusable(true);
        requestFocus();
        if(mControlListener != null && flag != hidden)
            mControlListener.onHidden();
    }

    public boolean isShowing() {
        boolean flag;
        if(!hidden)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void onAnimationEnd(Animation animation) {
        hide();
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onClick(View view) {
        if(mControlListener == null || view != playPauseReplayView) goto _L2; else goto _L1
_L1:
        if(state != State.ENDED) goto _L4; else goto _L3
_L3:
        if(canReplay)
            mControlListener.onReplay();
_L2:
        return;
_L4:
        if(state == State.PAUSED || state == State.PLAYING)
            mControlListener.onPlayPause();
        if(true) goto _L2; else goto _L5
_L5:
    }

    public boolean onKeyDown(int i, KeyEvent keyevent) {
        if(hidden)
            show();
        return super.onKeyDown(i, keyevent);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l) {
        int i1 = l - j;
        int j1 = k - i;
        if(errorView.getVisibility() != 0);
        int k1 = l - timeBar.getBarHeight();
        background.layout(i, k1, k, l);
        timeBar.layout(i, l - timeBar.getPreferredHeight(), k, l);
        timeBar.requestLayout();
        int l1 = i + j1 / 2;
        int i2 = j + i1 / 2;
        int j2 = playPauseReplayView.getMeasuredWidth();
        int k2 = playPauseReplayView.getMeasuredHeight();
        playPauseReplayView.layout(l1 - j2 / 2, i2 - k2 / 2, l1 + j2 / 2, i2 + k2 / 2);
        int _tmp = (int)(0.1666667F * (float)j1);
        if(mainView != null)
            layoutCenteredView(mainView, i, j, k, l);
    }

    protected void onMeasure(int i, int j) {
        super.onMeasure(i, j);
        measureChildren(i, j);
    }

    public void onScrubbingEnd(int i) {
        maybeStartHiding();
        if(mControlListener != null)
            mControlListener.onSeekEnd(i);
    }

    public void onScrubbingMove(int i) {
        cancelHiding();
        if(mControlListener != null)
            mControlListener.onSeekMove(i);
    }

    public void onScrubbingStart() {
        cancelHiding();
        if(mControlListener != null)
            mControlListener.onSeekStart();
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
        if(!super.onTouchEvent(motionevent)) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if(hidden)
            show();
        else
            switch(motionevent.getAction()) {
            default:
                break;

            case 0: // '\0'
                cancelHiding();
                if((state == State.PLAYING || state == State.PAUSED) && mControlListener != null)
                    mControlListener.onPlayPause();
                break;

            case 1: // '\001'
                maybeStartHiding();
                break;
            }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void resetTime() {
        timeBar.resetTime();
    }

    public void setCanReplay(boolean flag) {
        canReplay = flag;
    }

    public void setControlListener(MiuiMediaController.OnControllerChangedListener oncontrollerchangedlistener) {
        mControlListener = oncontrollerchangedlistener;
    }

    public void setTimes(int i, int j) {
        timeBar.setTime(i, j);
    }

    public void show() {
        boolean flag = hidden;
        hidden = false;
        updateViews();
        setVisibility(0);
        setFocusable(false);
        if(mControlListener != null && flag != hidden)
            mControlListener.onShown();
        maybeStartHiding();
    }

    public void showEnded() {
        state = State.ENDED;
        showMainView(playPauseReplayView);
    }

    public void showErrorMessage(String s) {
        state = State.ERROR;
        int i = (int)(0.1666667F * (float)getMeasuredWidth());
        errorView.setPadding(i, 10, i, 10);
        errorView.setText(s);
        showMainView(errorView);
    }

    public void showLoading() {
        state = State.LOADING;
        showMainView(loadingView);
    }

    public void showPaused() {
        state = State.PAUSED;
        showMainView(playPauseReplayView);
    }

    public void showPlaying() {
        state = State.PLAYING;
        showMainView(playPauseReplayView);
    }

    private static final float ERROR_MESSAGE_RELATIVE_PADDING = 0.1666667F;
    private final View background;
    private boolean canReplay;
    private final TextView errorView;
    private final Handler handler = new Handler();
    private boolean hidden;
    private final Animation hideAnimation;
    private final LinearLayout loadingView;
    private MiuiMediaController.OnControllerChangedListener mControlListener;
    private View mainView;
    private final ImageView playPauseReplayView;
    private final Runnable startHidingRunnable = new Runnable() {

        public void run() {
            startHiding();
        }

        final MiuiMovieController this$0;

             {
                this$0 = MiuiMovieController.this;
                super();
            }
    };
    private State state;
    private final MiuiMediaTimeBar timeBar;

}
