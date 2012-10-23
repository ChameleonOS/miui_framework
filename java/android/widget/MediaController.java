// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.*;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.android.internal.policy.PolicyManager;
import java.util.Formatter;
import java.util.Locale;

// Referenced classes of package android.widget:
//            FrameLayout, ImageButton, ProgressBar, SeekBar, 
//            TextView

public class MediaController extends FrameLayout {
    public static interface MediaPlayerControl {

        public abstract boolean canPause();

        public abstract boolean canSeekBackward();

        public abstract boolean canSeekForward();

        public abstract int getBufferPercentage();

        public abstract int getCurrentPosition();

        public abstract int getDuration();

        public abstract boolean isPlaying();

        public abstract void pause();

        public abstract void seekTo(int i);

        public abstract void start();
    }


    public MediaController(Context context) {
        this(context, true);
    }

    public MediaController(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        mRoot = this;
        mContext = context;
        mUseFastForward = true;
        mFromXml = true;
    }

    public MediaController(Context context, boolean flag) {
        super(context);
        mContext = context;
        mUseFastForward = flag;
        initFloatingWindowLayout();
        initFloatingWindow();
    }

    private void disableUnsupportedButtons() {
        if(mPauseButton != null && !mPlayer.canPause())
            mPauseButton.setEnabled(false);
        if(mRewButton != null && !mPlayer.canSeekBackward())
            mRewButton.setEnabled(false);
        if(mFfwdButton != null && !mPlayer.canSeekForward())
            mFfwdButton.setEnabled(false);
_L2:
        return;
        IncompatibleClassChangeError incompatibleclasschangeerror;
        incompatibleclasschangeerror;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private void doPauseResume() {
        if(mPlayer.isPlaying())
            mPlayer.pause();
        else
            mPlayer.start();
        updatePausePlay();
    }

    private void initControllerView(View view) {
        int i = 0;
        mPauseButton = (ImageButton)view.findViewById(0x10202d6);
        if(mPauseButton != null) {
            mPauseButton.requestFocus();
            mPauseButton.setOnClickListener(mPauseListener);
        }
        mFfwdButton = (ImageButton)view.findViewById(0x10202d7);
        if(mFfwdButton != null) {
            mFfwdButton.setOnClickListener(mFfwdListener);
            if(!mFromXml) {
                ImageButton imagebutton1 = mFfwdButton;
                ImageButton imagebutton;
                int j;
                if(mUseFastForward)
                    j = 0;
                else
                    j = 8;
                imagebutton1.setVisibility(j);
            }
        }
        mRewButton = (ImageButton)view.findViewById(0x10202d5);
        if(mRewButton != null) {
            mRewButton.setOnClickListener(mRewListener);
            if(!mFromXml) {
                imagebutton = mRewButton;
                if(!mUseFastForward)
                    i = 8;
                imagebutton.setVisibility(i);
            }
        }
        mNextButton = (ImageButton)view.findViewById(0x10202d8);
        if(mNextButton != null && !mFromXml && !mListenersSet)
            mNextButton.setVisibility(8);
        mPrevButton = (ImageButton)view.findViewById(0x10202d4);
        if(mPrevButton != null && !mFromXml && !mListenersSet)
            mPrevButton.setVisibility(8);
        mProgress = (ProgressBar)view.findViewById(0x10202da);
        if(mProgress != null) {
            if(mProgress instanceof SeekBar)
                ((SeekBar)mProgress).setOnSeekBarChangeListener(mSeekListener);
            mProgress.setMax(1000);
        }
        mEndTime = (TextView)view.findViewById(0x1020064);
        mCurrentTime = (TextView)view.findViewById(0x10202d9);
        mFormatBuilder = new StringBuilder();
        mFormatter = new Formatter(mFormatBuilder, Locale.getDefault());
        installPrevNextListeners();
    }

    private void initFloatingWindow() {
        mWindowManager = (WindowManager)mContext.getSystemService("window");
        mWindow = PolicyManager.makeNewWindow(mContext);
        mWindow.setWindowManager(mWindowManager, null, null);
        mWindow.requestFeature(1);
        mDecor = mWindow.getDecorView();
        mDecor.setOnTouchListener(mTouchListener);
        mWindow.setContentView(this);
        mWindow.setBackgroundDrawableResource(0x106000d);
        mWindow.setVolumeControlStream(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setDescendantFocusability(0x40000);
        requestFocus();
    }

    private void initFloatingWindowLayout() {
        mDecorLayoutParams = new android.view.WindowManager.LayoutParams();
        android.view.WindowManager.LayoutParams layoutparams = mDecorLayoutParams;
        layoutparams.gravity = 48;
        layoutparams.height = -2;
        layoutparams.x = 0;
        layoutparams.format = -3;
        layoutparams.type = 1000;
        layoutparams.flags = 0x820020 | layoutparams.flags;
        layoutparams.token = null;
        layoutparams.windowAnimations = 0;
    }

    private void installPrevNextListeners() {
        boolean flag = true;
        if(mNextButton != null) {
            mNextButton.setOnClickListener(mNextListener);
            ImageButton imagebutton1 = mNextButton;
            ImageButton imagebutton;
            boolean flag1;
            if(mNextListener != null)
                flag1 = flag;
            else
                flag1 = false;
            imagebutton1.setEnabled(flag1);
        }
        if(mPrevButton != null) {
            mPrevButton.setOnClickListener(mPrevListener);
            imagebutton = mPrevButton;
            if(mPrevListener == null)
                flag = false;
            imagebutton.setEnabled(flag);
        }
    }

    private int setProgress() {
        if(mPlayer != null && !mDragging) goto _L2; else goto _L1
_L1:
        int i = 0;
_L4:
        return i;
_L2:
        i = mPlayer.getCurrentPosition();
        int j = mPlayer.getDuration();
        if(mProgress != null) {
            if(j > 0) {
                long l = (1000L * (long)i) / (long)j;
                mProgress.setProgress((int)l);
            }
            int k = mPlayer.getBufferPercentage();
            mProgress.setSecondaryProgress(k * 10);
        }
        if(mEndTime != null)
            mEndTime.setText(stringForTime(j));
        if(mCurrentTime != null)
            mCurrentTime.setText(stringForTime(i));
        if(true) goto _L4; else goto _L3
_L3:
    }

    private String stringForTime(int i) {
        int j = i / 1000;
        int k = j % 60;
        int l = (j / 60) % 60;
        int i1 = j / 3600;
        mFormatBuilder.setLength(0);
        String s;
        if(i1 > 0) {
            Formatter formatter1 = mFormatter;
            Object aobj1[] = new Object[3];
            aobj1[0] = Integer.valueOf(i1);
            aobj1[1] = Integer.valueOf(l);
            aobj1[2] = Integer.valueOf(k);
            s = formatter1.format("%d:%02d:%02d", aobj1).toString();
        } else {
            Formatter formatter = mFormatter;
            Object aobj[] = new Object[2];
            aobj[0] = Integer.valueOf(l);
            aobj[1] = Integer.valueOf(k);
            s = formatter.format("%02d:%02d", aobj).toString();
        }
        return s;
    }

    private void updateFloatingWindowLayout() {
        int ai[] = new int[2];
        mAnchor.getLocationOnScreen(ai);
        android.view.WindowManager.LayoutParams layoutparams = mDecorLayoutParams;
        layoutparams.width = mAnchor.getWidth();
        layoutparams.y = ai[1] + mAnchor.getHeight();
    }

    private void updatePausePlay() {
        if(mRoot != null && mPauseButton != null)
            if(mPlayer.isPlaying())
                mPauseButton.setImageResource(0x1080023);
            else
                mPauseButton.setImageResource(0x1080024);
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent) {
        boolean flag;
        int i;
        boolean flag1;
        flag = true;
        i = keyevent.getKeyCode();
        if(keyevent.getRepeatCount() == 0 && keyevent.getAction() == 0)
            flag1 = flag;
        else
            flag1 = false;
        if(i != 79 && i != 85 && i != 62) goto _L2; else goto _L1
_L1:
        if(flag1) {
            doPauseResume();
            show(3000);
            if(mPauseButton != null)
                mPauseButton.requestFocus();
        }
_L4:
        return flag;
_L2:
        if(i == 126) {
            if(flag1 && !mPlayer.isPlaying()) {
                mPlayer.start();
                updatePausePlay();
                show(3000);
            }
        } else
        if(i == 86 || i == 127) {
            if(flag1 && mPlayer.isPlaying()) {
                mPlayer.pause();
                updatePausePlay();
                show(3000);
            }
        } else
        if(i == 25 || i == 24 || i == 164)
            flag = super.dispatchKeyEvent(keyevent);
        else
        if(i == 4 || i == 82) {
            if(flag1)
                hide();
        } else {
            show(3000);
            flag = super.dispatchKeyEvent(keyevent);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void hide() {
        if(mAnchor != null && mShowing) {
            try {
                mHandler.removeMessages(2);
                mWindowManager.removeView(mDecor);
            }
            catch(IllegalArgumentException illegalargumentexception) {
                Log.w("MediaController", "already removed");
            }
            mShowing = false;
        }
    }

    public boolean isShowing() {
        return mShowing;
    }

    protected View makeControllerView() {
        mRoot = ((LayoutInflater)mContext.getSystemService("layout_inflater")).inflate(0x1090065, null);
        initControllerView(mRoot);
        return mRoot;
    }

    public void onFinishInflate() {
        if(mRoot != null)
            initControllerView(mRoot);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/MediaController.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/MediaController.getName());
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
        show(3000);
        return true;
    }

    public boolean onTrackballEvent(MotionEvent motionevent) {
        show(3000);
        return false;
    }

    public void setAnchorView(View view) {
        if(mAnchor != null)
            mAnchor.removeOnLayoutChangeListener(mLayoutChangeListener);
        mAnchor = view;
        if(mAnchor != null)
            mAnchor.addOnLayoutChangeListener(mLayoutChangeListener);
        FrameLayout.LayoutParams layoutparams = new FrameLayout.LayoutParams(-1, -1);
        removeAllViews();
        addView(makeControllerView(), layoutparams);
    }

    public void setEnabled(boolean flag) {
        boolean flag1 = true;
        if(mPauseButton != null)
            mPauseButton.setEnabled(flag);
        if(mFfwdButton != null)
            mFfwdButton.setEnabled(flag);
        if(mRewButton != null)
            mRewButton.setEnabled(flag);
        if(mNextButton != null) {
            ImageButton imagebutton1 = mNextButton;
            ImageButton imagebutton;
            boolean flag2;
            if(flag && mNextListener != null)
                flag2 = flag1;
            else
                flag2 = false;
            imagebutton1.setEnabled(flag2);
        }
        if(mPrevButton != null) {
            imagebutton = mPrevButton;
            if(!flag || mPrevListener == null)
                flag1 = false;
            imagebutton.setEnabled(flag1);
        }
        if(mProgress != null)
            mProgress.setEnabled(flag);
        disableUnsupportedButtons();
        super.setEnabled(flag);
    }

    public void setMediaPlayer(MediaPlayerControl mediaplayercontrol) {
        mPlayer = mediaplayercontrol;
        updatePausePlay();
    }

    public void setPrevNextListeners(android.view.View.OnClickListener onclicklistener, android.view.View.OnClickListener onclicklistener1) {
        mNextListener = onclicklistener;
        mPrevListener = onclicklistener1;
        mListenersSet = true;
        if(mRoot != null) {
            installPrevNextListeners();
            if(mNextButton != null && !mFromXml)
                mNextButton.setVisibility(0);
            if(mPrevButton != null && !mFromXml)
                mPrevButton.setVisibility(0);
        }
    }

    public void show() {
        show(3000);
    }

    public void show(int i) {
        if(!mShowing && mAnchor != null) {
            setProgress();
            if(mPauseButton != null)
                mPauseButton.requestFocus();
            disableUnsupportedButtons();
            updateFloatingWindowLayout();
            mWindowManager.addView(mDecor, mDecorLayoutParams);
            mShowing = true;
        }
        updatePausePlay();
        mHandler.sendEmptyMessage(2);
        Message message = mHandler.obtainMessage(1);
        if(i != 0) {
            mHandler.removeMessages(1);
            mHandler.sendMessageDelayed(message, i);
        }
    }

    private static final int FADE_OUT = 1;
    private static final int SHOW_PROGRESS = 2;
    private static final int sDefaultTimeout = 3000;
    private View mAnchor;
    private Context mContext;
    private TextView mCurrentTime;
    private View mDecor;
    private android.view.WindowManager.LayoutParams mDecorLayoutParams;
    private boolean mDragging;
    private TextView mEndTime;
    private ImageButton mFfwdButton;
    private android.view.View.OnClickListener mFfwdListener = new android.view.View.OnClickListener() {

        public void onClick(View view) {
            int i = 15000 + mPlayer.getCurrentPosition();
            mPlayer.seekTo(i);
            setProgress();
            show(3000);
        }

        final MediaController this$0;

             {
                this$0 = MediaController.this;
                super();
            }
    };
    StringBuilder mFormatBuilder;
    Formatter mFormatter;
    private boolean mFromXml;
    private Handler mHandler = new Handler() {

        public void handleMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 1 2: default 28
        //                       1 29
        //                       2 39;
               goto _L1 _L2 _L3
_L1:
            return;
_L2:
            hide();
            continue; /* Loop/switch isn't completed */
_L3:
            int i = setProgress();
            if(!mDragging && mShowing && mPlayer.isPlaying())
                sendMessageDelayed(obtainMessage(2), 1000 - i % 1000);
            if(true) goto _L1; else goto _L4
_L4:
        }

        final MediaController this$0;

             {
                this$0 = MediaController.this;
                super();
            }
    };
    private android.view.View.OnLayoutChangeListener mLayoutChangeListener = new android.view.View.OnLayoutChangeListener() {

        public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
                int k1, int l1) {
            updateFloatingWindowLayout();
            if(mShowing)
                mWindowManager.updateViewLayout(mDecor, mDecorLayoutParams);
        }

        final MediaController this$0;

             {
                this$0 = MediaController.this;
                super();
            }
    };
    private boolean mListenersSet;
    private ImageButton mNextButton;
    private android.view.View.OnClickListener mNextListener;
    private ImageButton mPauseButton;
    private android.view.View.OnClickListener mPauseListener = new android.view.View.OnClickListener() {

        public void onClick(View view) {
            doPauseResume();
            show(3000);
        }

        final MediaController this$0;

             {
                this$0 = MediaController.this;
                super();
            }
    };
    private MediaPlayerControl mPlayer;
    private ImageButton mPrevButton;
    private android.view.View.OnClickListener mPrevListener;
    private ProgressBar mProgress;
    private ImageButton mRewButton;
    private android.view.View.OnClickListener mRewListener = new android.view.View.OnClickListener() {

        public void onClick(View view) {
            int i = -5000 + mPlayer.getCurrentPosition();
            mPlayer.seekTo(i);
            setProgress();
            show(3000);
        }

        final MediaController this$0;

             {
                this$0 = MediaController.this;
                super();
            }
    };
    private View mRoot;
    private SeekBar.OnSeekBarChangeListener mSeekListener = new SeekBar.OnSeekBarChangeListener() {

        public void onProgressChanged(SeekBar seekbar, int i, boolean flag) {
            if(flag) goto _L2; else goto _L1
_L1:
            return;
_L2:
            long l = ((long)mPlayer.getDuration() * (long)i) / 1000L;
            mPlayer.seekTo((int)l);
            if(mCurrentTime != null)
                mCurrentTime.setText(stringForTime((int)l));
            if(true) goto _L1; else goto _L3
_L3:
        }

        public void onStartTrackingTouch(SeekBar seekbar) {
            show(0x36ee80);
            mDragging = true;
            mHandler.removeMessages(2);
        }

        public void onStopTrackingTouch(SeekBar seekbar) {
            mDragging = false;
            setProgress();
            updatePausePlay();
            show(3000);
            mHandler.sendEmptyMessage(2);
        }

        final MediaController this$0;

             {
                this$0 = MediaController.this;
                super();
            }
    };
    private boolean mShowing;
    private android.view.View.OnTouchListener mTouchListener = new android.view.View.OnTouchListener() {

        public boolean onTouch(View view, MotionEvent motionevent) {
            if(motionevent.getAction() == 0 && mShowing)
                hide();
            return false;
        }

        final MediaController this$0;

             {
                this$0 = MediaController.this;
                super();
            }
    };
    private boolean mUseFastForward;
    private Window mWindow;
    private WindowManager mWindowManager;












/*
    static boolean access$602(MediaController mediacontroller, boolean flag) {
        mediacontroller.mDragging = flag;
        return flag;
    }

*/



}
