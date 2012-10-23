// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.*;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

// Referenced classes of package android.widget:
//            AdapterViewAnimator, Adapter

public class AdapterViewFlipper extends AdapterViewAnimator {

    public AdapterViewFlipper(Context context) {
        super(context);
        mFlipInterval = 10000;
        mAutoStart = false;
        mRunning = false;
        mStarted = false;
        mVisible = false;
        mUserPresent = true;
        mAdvancedByHost = false;
        mReceiver = new BroadcastReceiver() {

            public void onReceive(Context context1, Intent intent) {
                String s = intent.getAction();
                if(!"android.intent.action.SCREEN_OFF".equals(s)) goto _L2; else goto _L1
_L1:
                mUserPresent = false;
                updateRunning();
_L4:
                return;
_L2:
                if("android.intent.action.USER_PRESENT".equals(s)) {
                    mUserPresent = true;
                    updateRunning(false);
                }
                if(true) goto _L4; else goto _L3
_L3:
            }

            final AdapterViewFlipper this$0;

             {
                this$0 = AdapterViewFlipper.this;
                super();
            }
        };
        FLIP_MSG = 1;
        mHandler = new Handler() {

            public void handleMessage(Message message) {
                if(message.what == 1 && mRunning)
                    showNext();
            }

            final AdapterViewFlipper this$0;

             {
                this$0 = AdapterViewFlipper.this;
                super();
            }
        };
    }

    public AdapterViewFlipper(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        mFlipInterval = 10000;
        mAutoStart = false;
        mRunning = false;
        mStarted = false;
        mVisible = false;
        mUserPresent = true;
        mAdvancedByHost = false;
        mReceiver = new _cls1();
        FLIP_MSG = 1;
        mHandler = new _cls2();
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.AdapterViewFlipper);
        mFlipInterval = typedarray.getInt(0, 10000);
        mAutoStart = typedarray.getBoolean(1, false);
        super.mLoopViews = true;
        typedarray.recycle();
    }

    private void updateRunning() {
        updateRunning(true);
    }

    private void updateRunning(boolean flag) {
        boolean flag1;
        if(!mAdvancedByHost && mVisible && mStarted && mUserPresent && super.mAdapter != null)
            flag1 = true;
        else
            flag1 = false;
        if(flag1 != mRunning) {
            if(flag1) {
                showOnly(super.mWhichChild, flag);
                Message message = mHandler.obtainMessage(1);
                mHandler.sendMessageDelayed(message, mFlipInterval);
            } else {
                mHandler.removeMessages(1);
            }
            mRunning = flag1;
        }
    }

    public void fyiWillBeAdvancedByHostKThx() {
        mAdvancedByHost = true;
        updateRunning(false);
    }

    public int getFlipInterval() {
        return mFlipInterval;
    }

    public boolean isAutoStart() {
        return mAutoStart;
    }

    public boolean isFlipping() {
        return mStarted;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.intent.action.SCREEN_OFF");
        intentfilter.addAction("android.intent.action.USER_PRESENT");
        getContext().registerReceiver(mReceiver, intentfilter);
        if(mAutoStart)
            startFlipping();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mVisible = false;
        getContext().unregisterReceiver(mReceiver);
        updateRunning();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/AdapterViewFlipper.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/AdapterViewFlipper.getName());
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        boolean flag;
        if(i == 0)
            flag = true;
        else
            flag = false;
        mVisible = flag;
        updateRunning(false);
    }

    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);
        updateRunning();
    }

    public void setAutoStart(boolean flag) {
        mAutoStart = flag;
    }

    public void setFlipInterval(int i) {
        mFlipInterval = i;
    }

    public void showNext() {
        if(mRunning) {
            mHandler.removeMessages(1);
            Message message = mHandler.obtainMessage(1);
            mHandler.sendMessageDelayed(message, mFlipInterval);
        }
        super.showNext();
    }

    public void showPrevious() {
        if(mRunning) {
            mHandler.removeMessages(1);
            Message message = mHandler.obtainMessage(1);
            mHandler.sendMessageDelayed(message, mFlipInterval);
        }
        super.showPrevious();
    }

    public void startFlipping() {
        mStarted = true;
        updateRunning();
    }

    public void stopFlipping() {
        mStarted = false;
        updateRunning();
    }

    private static final int DEFAULT_INTERVAL = 10000;
    private static final boolean LOGD = false;
    private static final String TAG = "ViewFlipper";
    private final int FLIP_MSG;
    private boolean mAdvancedByHost;
    private boolean mAutoStart;
    private int mFlipInterval;
    private final Handler mHandler;
    private final BroadcastReceiver mReceiver;
    private boolean mRunning;
    private boolean mStarted;
    private boolean mUserPresent;
    private boolean mVisible;


/*
    static boolean access$002(AdapterViewFlipper adapterviewflipper, boolean flag) {
        adapterviewflipper.mUserPresent = flag;
        return flag;
    }

*/



}
