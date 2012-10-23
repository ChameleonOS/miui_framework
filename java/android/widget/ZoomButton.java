// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.*;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

// Referenced classes of package android.widget:
//            ImageButton

public class ZoomButton extends ImageButton
    implements android.view.View.OnLongClickListener {

    public ZoomButton(Context context) {
        this(context, null);
    }

    public ZoomButton(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0);
    }

    public ZoomButton(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        mRunnable = new Runnable() {

            public void run() {
                if(hasOnClickListeners() && mIsInLongpress && isEnabled()) {
                    callOnClick();
                    mHandler.postDelayed(this, mZoomSpeed);
                }
            }

            final ZoomButton this$0;

             {
                this$0 = ZoomButton.this;
                super();
            }
        };
        mZoomSpeed = 1000L;
        mHandler = new Handler();
        setOnLongClickListener(this);
    }

    public boolean dispatchUnhandledMove(View view, int i) {
        clearFocus();
        return super.dispatchUnhandledMove(view, i);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/ZoomButton.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/ZoomButton.getName());
    }

    public boolean onKeyUp(int i, KeyEvent keyevent) {
        mIsInLongpress = false;
        return super.onKeyUp(i, keyevent);
    }

    public boolean onLongClick(View view) {
        mIsInLongpress = true;
        mHandler.post(mRunnable);
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
        if(motionevent.getAction() == 3 || motionevent.getAction() == 1)
            mIsInLongpress = false;
        return super.onTouchEvent(motionevent);
    }

    public void setEnabled(boolean flag) {
        if(!flag)
            setPressed(false);
        super.setEnabled(flag);
    }

    public void setZoomSpeed(long l) {
        mZoomSpeed = l;
    }

    private final Handler mHandler;
    private boolean mIsInLongpress;
    private final Runnable mRunnable;
    private long mZoomSpeed;



}
