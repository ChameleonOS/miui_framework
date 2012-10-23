// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Vibrator;
import android.util.*;
import android.view.*;
import android.view.animation.*;
import android.widget.ImageView;
import android.widget.TextView;

public class SlidingTab extends ViewGroup {
    private static class Slider {

        public int getTabHeight() {
            return tab.getMeasuredHeight();
        }

        public int getTabWidth() {
            return tab.getMeasuredWidth();
        }

        void hide() {
            int i = 0;
            boolean flag;
            int j;
            TranslateAnimation translateanimation;
            if(alignment == 0 || alignment == 1)
                flag = true;
            else
                flag = false;
            if(flag) {
                if(alignment == 0)
                    j = alignment_value - tab.getRight();
                else
                    j = alignment_value - tab.getLeft();
            } else {
                j = 0;
            }
            if(!flag)
                if(alignment == 2)
                    i = alignment_value - tab.getBottom();
                else
                    i = alignment_value - tab.getTop();
            translateanimation = new TranslateAnimation(0.0F, j, 0.0F, i);
            translateanimation.setDuration(250L);
            translateanimation.setFillAfter(true);
            tab.startAnimation(translateanimation);
            text.startAnimation(translateanimation);
            target.setVisibility(4);
        }

        public void hideTarget() {
            target.clearAnimation();
            target.setVisibility(4);
        }

        void layout(int i, int j, int k, int l, int i1) {
            alignment = i1;
            Drawable drawable = tab.getBackground();
            int j1 = drawable.getIntrinsicWidth();
            int k1 = drawable.getIntrinsicHeight();
            Drawable drawable1 = target.getDrawable();
            int l1 = drawable1.getIntrinsicWidth();
            int i2 = drawable1.getIntrinsicHeight();
            int j2 = k - i;
            int k2 = l - j;
            int l2 = ((int)(0.6666667F * (float)j2) - l1) + j1 / 2;
            int i3 = (int)(0.3333333F * (float)j2) - j1 / 2;
            int j3 = (j2 - j1) / 2;
            int k3 = j3 + j1;
            if(i1 == 0 || i1 == 1) {
                int l3 = (k2 - i2) / 2;
                int i4 = l3 + i2;
                int j4 = (k2 - k1) / 2;
                int k4 = (k2 + k1) / 2;
                if(i1 == 0) {
                    tab.layout(0, j4, j1, k4);
                    text.layout(0 - j2, j4, 0, k4);
                    text.setGravity(5);
                    target.layout(l2, l3, l2 + l1, i4);
                    alignment_value = i;
                } else {
                    tab.layout(j2 - j1, j4, j2, k4);
                    text.layout(j2, j4, j2 + j2, k4);
                    target.layout(i3, l3, i3 + l1, i4);
                    text.setGravity(48);
                    alignment_value = k;
                }
            } else {
                int l4 = (j2 - l1) / 2;
                int i5 = (j2 + l1) / 2;
                int j5 = ((int)(0.6666667F * (float)k2) + k1 / 2) - i2;
                int k5 = (int)(0.3333333F * (float)k2) - k1 / 2;
                if(i1 == 2) {
                    tab.layout(j3, 0, k3, k1);
                    text.layout(j3, 0 - k2, k3, 0);
                    target.layout(l4, j5, i5, j5 + i2);
                    alignment_value = j;
                } else {
                    tab.layout(j3, k2 - k1, k3, k2);
                    text.layout(j3, k2, k3, k2 + k2);
                    target.layout(l4, k5, i5, k5 + i2);
                    alignment_value = l;
                }
            }
        }

        public void measure() {
            tab.measure(android.view.View.MeasureSpec.makeMeasureSpec(0, 0), android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
            text.measure(android.view.View.MeasureSpec.makeMeasureSpec(0, 0), android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
        }

        void reset(boolean flag) {
            int i = 1;
            setState(0);
            text.setVisibility(0);
            text.setTextAppearance(text.getContext(), 0x1030211);
            tab.setVisibility(0);
            target.setVisibility(4);
            int j;
            int k;
            if(alignment != 0 && alignment != i)
                i = 0;
            if(i != 0) {
                if(alignment == 0)
                    j = alignment_value - tab.getLeft();
                else
                    j = alignment_value - tab.getRight();
            } else {
                j = 0;
            }
            if(i != 0)
                k = 0;
            else
            if(alignment == 2)
                k = alignment_value - tab.getTop();
            else
                k = alignment_value - tab.getBottom();
            if(flag) {
                TranslateAnimation translateanimation = new TranslateAnimation(0.0F, j, 0.0F, k);
                translateanimation.setDuration(250L);
                translateanimation.setFillAfter(false);
                text.startAnimation(translateanimation);
                tab.startAnimation(translateanimation);
            } else {
                if(i != 0) {
                    text.offsetLeftAndRight(j);
                    tab.offsetLeftAndRight(j);
                } else {
                    text.offsetTopAndBottom(k);
                    tab.offsetTopAndBottom(k);
                }
                text.clearAnimation();
                tab.clearAnimation();
                target.clearAnimation();
            }
        }

        void setBarBackgroundResource(int i) {
            text.setBackgroundResource(i);
        }

        void setHintText(int i) {
            text.setText(i);
        }

        void setIcon(int i) {
            tab.setImageResource(i);
        }

        void setState(int i) {
            TextView textview = text;
            boolean flag;
            ImageView imageview;
            boolean flag1;
            if(i == 1)
                flag = true;
            else
                flag = false;
            textview.setPressed(flag);
            imageview = tab;
            if(i == 1)
                flag1 = true;
            else
                flag1 = false;
            imageview.setPressed(flag1);
            if(i == 2) {
                int ai[] = new int[1];
                ai[0] = 0x10100a2;
                if(text.getBackground().isStateful())
                    text.getBackground().setState(ai);
                if(tab.getBackground().isStateful())
                    tab.getBackground().setState(ai);
                text.setTextAppearance(text.getContext(), 0x1030212);
            } else {
                text.setTextAppearance(text.getContext(), 0x1030211);
            }
            currentState = i;
        }

        void setTabBackgroundResource(int i) {
            tab.setBackgroundResource(i);
        }

        void setTarget(int i) {
            target.setImageResource(i);
        }

        void show(boolean flag) {
            int i = 1;
            int j = 0;
            text.setVisibility(0);
            tab.setVisibility(0);
            if(flag) {
                int k;
                TranslateAnimation translateanimation;
                if(alignment != 0 && alignment != i)
                    i = 0;
                if(i != 0) {
                    if(alignment == 0)
                        k = tab.getWidth();
                    else
                        k = -tab.getWidth();
                } else {
                    k = 0;
                }
                if(i == 0)
                    if(alignment == 2)
                        j = tab.getHeight();
                    else
                        j = -tab.getHeight();
                translateanimation = new TranslateAnimation(-k, 0.0F, -j, 0.0F);
                translateanimation.setDuration(250L);
                tab.startAnimation(translateanimation);
                text.startAnimation(translateanimation);
            }
        }

        void showTarget() {
            AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
            alphaanimation.setDuration(500L);
            target.startAnimation(alphaanimation);
            target.setVisibility(0);
        }

        public void startAnimation(Animation animation, Animation animation1) {
            tab.startAnimation(animation);
            text.startAnimation(animation1);
        }

        public void updateDrawableStates() {
            setState(currentState);
        }

        public static final int ALIGN_BOTTOM = 3;
        public static final int ALIGN_LEFT = 0;
        public static final int ALIGN_RIGHT = 1;
        public static final int ALIGN_TOP = 2;
        public static final int ALIGN_UNKNOWN = 4;
        private static final int STATE_ACTIVE = 2;
        private static final int STATE_NORMAL = 0;
        private static final int STATE_PRESSED = 1;
        private int alignment;
        private int alignment_value;
        private int currentState;
        private final ImageView tab;
        private final ImageView target;
        private final TextView text;



        Slider(ViewGroup viewgroup, int i, int j, int k) {
            currentState = 0;
            alignment = 4;
            tab = new ImageView(viewgroup.getContext());
            tab.setBackgroundResource(i);
            tab.setScaleType(android.widget.ImageView.ScaleType.CENTER);
            tab.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
            text = new TextView(viewgroup.getContext());
            text.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -1));
            text.setBackgroundResource(j);
            text.setTextAppearance(viewgroup.getContext(), 0x1030211);
            target = new ImageView(viewgroup.getContext());
            target.setImageResource(k);
            target.setScaleType(android.widget.ImageView.ScaleType.CENTER);
            target.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
            target.setVisibility(4);
            viewgroup.addView(target);
            viewgroup.addView(tab);
            viewgroup.addView(text);
        }
    }

    public static interface OnTriggerListener {

        public abstract void onGrabbedStateChange(View view, int i);

        public abstract void onTrigger(View view, int i);

        public static final int LEFT_HANDLE = 1;
        public static final int NO_HANDLE = 0;
        public static final int RIGHT_HANDLE = 2;
    }


    public SlidingTab(Context context) {
        this(context, null);
    }

    public SlidingTab(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        mHoldLeftOnTransition = true;
        mHoldRightOnTransition = true;
        mGrabbedState = 0;
        mTriggered = false;
        mAnimationDoneListener = new android.view.animation.Animation.AnimationListener() {

            public void onAnimationEnd(Animation animation) {
                onAnimationDone();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            final SlidingTab this$0;

             {
                this$0 = SlidingTab.this;
                super();
            }
        };
        mTmpRect = new Rect();
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.SlidingTab);
        mOrientation = typedarray.getInt(0, 0);
        typedarray.recycle();
        mDensity = getResources().getDisplayMetrics().density;
        mLeftSlider = new Slider(this, 0x108039c, 0x108038b, 0x10803aa);
        mRightSlider = new Slider(this, 0x10803a5, 0x1080394, 0x10803aa);
    }

    private void cancelGrab() {
        mTracking = false;
        mTriggered = false;
        mOtherSlider.show(true);
        mCurrentSlider.reset(false);
        mCurrentSlider.hideTarget();
        mCurrentSlider = null;
        mOtherSlider = null;
        setGrabbedState(0);
    }

    private void dispatchTriggerEvent(int i) {
        vibrate(40L);
        if(mOnTriggerListener != null)
            mOnTriggerListener.onTrigger(this, i);
    }

    private boolean isHorizontal() {
        boolean flag;
        if(mOrientation == 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private void log(String s) {
        Log.d("SlidingTab", s);
    }

    private void moveHandle(float f, float f1) {
        ImageView imageview = mCurrentSlider.tab;
        TextView textview = mCurrentSlider.text;
        if(isHorizontal()) {
            int j = (int)f - imageview.getLeft() - imageview.getWidth() / 2;
            imageview.offsetLeftAndRight(j);
            textview.offsetLeftAndRight(j);
        } else {
            int i = (int)f1 - imageview.getTop() - imageview.getHeight() / 2;
            imageview.offsetTopAndBottom(i);
            textview.offsetTopAndBottom(i);
        }
        invalidate();
    }

    private void onAnimationDone() {
        resetView();
        mAnimating = false;
    }

    private void resetView() {
        mLeftSlider.reset(false);
        mRightSlider.reset(false);
    }

    private void setGrabbedState(int i) {
        if(i != mGrabbedState) {
            mGrabbedState = i;
            if(mOnTriggerListener != null)
                mOnTriggerListener.onGrabbedStateChange(this, mGrabbedState);
        }
    }

    /**
     * @deprecated Method vibrate is deprecated
     */

    private void vibrate(long l) {
        this;
        JVM INSTR monitorenter ;
        if(mVibrator == null)
            mVibrator = (Vibrator)getContext().getSystemService("vibrator");
        mVibrator.vibrate(l);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private boolean withinView(float f, float f1, View view) {
        boolean flag;
        if(isHorizontal() && f1 > -50F && f1 < (float)(50 + view.getHeight()) || !isHorizontal() && f > -50F && f < (float)(50 + view.getWidth()))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent) {
        float f;
        float f1;
        int i;
        float f2;
        float f3;
        f = 0.6666667F;
        f1 = 0.3333333F;
        i = motionevent.getAction();
        f2 = motionevent.getX();
        f3 = motionevent.getY();
        if(!mAnimating) goto _L2; else goto _L1
_L1:
        boolean flag2 = false;
_L4:
        return flag2;
_L2:
        boolean flag;
        mLeftSlider.tab.getHitRect(mTmpRect);
        flag = mTmpRect.contains((int)f2, (int)f3);
        mRightSlider.tab.getHitRect(mTmpRect);
        boolean flag1 = mTmpRect.contains((int)f2, (int)f3);
        if(mTracking || flag || flag1)
            break; /* Loop/switch isn't completed */
        flag2 = false;
        if(true) goto _L4; else goto _L3
_L3:
        i;
        JVM INSTR tableswitch 0 0: default 140
    //                   0 146;
           goto _L5 _L6
_L5:
        flag2 = true;
          goto _L7
_L6:
        mTracking = true;
        mTriggered = false;
        vibrate(30L);
        if(flag) {
            mCurrentSlider = mLeftSlider;
            mOtherSlider = mRightSlider;
            if(!isHorizontal())
                f = f1;
            mThreshold = f;
            setGrabbedState(1);
        } else {
            mCurrentSlider = mRightSlider;
            mOtherSlider = mLeftSlider;
            if(!isHorizontal())
                f1 = f;
            mThreshold = f1;
            setGrabbedState(2);
        }
        mCurrentSlider.setState(1);
        mCurrentSlider.showTarget();
        mOtherSlider.hide();
        if(true) goto _L5; else goto _L7
_L7:
        if(true) goto _L4; else goto _L8
_L8:
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l) {
        if(flag) {
            Slider slider = mLeftSlider;
            int i1;
            Slider slider1;
            int j1;
            if(isHorizontal())
                i1 = 0;
            else
                i1 = 3;
            slider.layout(i, j, k, l, i1);
            slider1 = mRightSlider;
            if(isHorizontal())
                j1 = 1;
            else
                j1 = 2;
            slider1.layout(i, j, k, l, j1);
        }
    }

    protected void onMeasure(int i, int j) {
        android.view.View.MeasureSpec.getMode(i);
        int k = android.view.View.MeasureSpec.getSize(i);
        android.view.View.MeasureSpec.getMode(j);
        int l = android.view.View.MeasureSpec.getSize(j);
        mLeftSlider.measure();
        mRightSlider.measure();
        int i1 = mLeftSlider.getTabWidth();
        int j1 = mRightSlider.getTabWidth();
        int k1 = mLeftSlider.getTabHeight();
        int l1 = mRightSlider.getTabHeight();
        int i2;
        int j2;
        if(isHorizontal()) {
            i2 = Math.max(k, i1 + j1);
            j2 = Math.max(k1, l1);
        } else {
            i2 = Math.max(i1, l1);
            j2 = Math.max(l, k1 + l1);
        }
        setMeasuredDimension(i2, j2);
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
        boolean flag = false;
        if(!mTracking) goto _L2; else goto _L1
_L1:
        int i;
        float f;
        float f1;
        i = motionevent.getAction();
        f = motionevent.getX();
        f1 = motionevent.getY();
        i;
        JVM INSTR tableswitch 1 3: default 52
    //                   1 355
    //                   2 71
    //                   3 355;
           goto _L2 _L3 _L4 _L3
_L2:
        if(mTracking || super.onTouchEvent(motionevent))
            flag = true;
        return flag;
_L4:
        if(withinView(f, f1, this)) {
            moveHandle(f, f1);
            float f2;
            float f3;
            int j;
            float f4;
            boolean flag1;
            if(isHorizontal())
                f2 = f;
            else
                f2 = f1;
            f3 = mThreshold;
            if(isHorizontal())
                j = getWidth();
            else
                j = getHeight();
            f4 = f3 * (float)j;
            if(isHorizontal()) {
                if(mCurrentSlider == mLeftSlider) {
                    if(f2 > f4)
                        flag1 = true;
                    else
                        flag1 = false;
                } else
                if(f2 < f4)
                    flag1 = true;
                else
                    flag1 = false;
            } else
            if(mCurrentSlider == mLeftSlider) {
                if(f2 < f4)
                    flag1 = true;
                else
                    flag1 = false;
            } else
            if(f2 > f4)
                flag1 = true;
            else
                flag1 = false;
            if(!mTriggered && flag1) {
                mTriggered = true;
                mTracking = false;
                mCurrentSlider.setState(2);
                boolean flag2;
                int k;
                boolean flag3;
                if(mCurrentSlider == mLeftSlider)
                    flag2 = true;
                else
                    flag2 = false;
                if(flag2)
                    k = 1;
                else
                    k = 2;
                dispatchTriggerEvent(k);
                if(flag2)
                    flag3 = mHoldLeftOnTransition;
                else
                    flag3 = mHoldRightOnTransition;
                startAnimating(flag3);
                setGrabbedState(0);
            }
            continue; /* Loop/switch isn't completed */
        }
_L3:
        cancelGrab();
        if(true) goto _L2; else goto _L5
_L5:
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if(view == this && i != 0 && mGrabbedState != 0)
            cancelGrab();
    }

    public void reset(boolean flag) {
        mLeftSlider.reset(flag);
        mRightSlider.reset(flag);
        if(!flag)
            mAnimating = false;
    }

    public void setHoldAfterTrigger(boolean flag, boolean flag1) {
        mHoldLeftOnTransition = flag;
        mHoldRightOnTransition = flag1;
    }

    public void setLeftHintText(int i) {
        if(isHorizontal())
            mLeftSlider.setHintText(i);
    }

    public void setLeftTabResources(int i, int j, int k, int l) {
        mLeftSlider.setIcon(i);
        mLeftSlider.setTarget(j);
        mLeftSlider.setBarBackgroundResource(k);
        mLeftSlider.setTabBackgroundResource(l);
        mLeftSlider.updateDrawableStates();
    }

    public void setOnTriggerListener(OnTriggerListener ontriggerlistener) {
        mOnTriggerListener = ontriggerlistener;
    }

    public void setRightHintText(int i) {
        if(isHorizontal())
            mRightSlider.setHintText(i);
    }

    public void setRightTabResources(int i, int j, int k, int l) {
        mRightSlider.setIcon(i);
        mRightSlider.setTarget(j);
        mRightSlider.setBarBackgroundResource(k);
        mRightSlider.setTabBackgroundResource(l);
        mRightSlider.updateDrawableStates();
    }

    public void setVisibility(int i) {
        if(i != getVisibility() && i == 4)
            reset(false);
        super.setVisibility(i);
    }

    void startAnimating(final boolean holdAfter) {
        mAnimating = true;
        Slider slider = mCurrentSlider;
        Slider _tmp = mOtherSlider;
        final int dx;
        final int dy;
        if(isHorizontal()) {
            int j1 = slider.tab.getRight();
            int k1 = slider.tab.getWidth();
            int l1 = slider.tab.getLeft();
            int i2 = getWidth();
            TranslateAnimation translateanimation;
            TranslateAnimation translateanimation1;
            android.view.animation.Animation.AnimationListener animationlistener;
            int j2;
            if(holdAfter)
                j2 = 0;
            else
                j2 = k1;
            if(slider == mRightSlider)
                dx = -((j1 + i2) - j2);
            else
                dx = (i2 + (i2 - l1)) - j2;
            dy = 0;
        } else {
            int i = slider.tab.getTop();
            int j = slider.tab.getBottom();
            int k = slider.tab.getHeight();
            int l = getHeight();
            int i1;
            if(holdAfter)
                i1 = 0;
            else
                i1 = k;
            dx = 0;
            if(slider == mRightSlider)
                dy = (i + l) - i1;
            else
                dy = -((l + (l - j)) - i1);
        }
        translateanimation = new TranslateAnimation(0.0F, dx, 0.0F, dy);
        translateanimation.setDuration(250L);
        translateanimation.setInterpolator(new LinearInterpolator());
        translateanimation.setFillAfter(true);
        translateanimation1 = new TranslateAnimation(0.0F, dx, 0.0F, dy);
        translateanimation1.setDuration(250L);
        translateanimation1.setInterpolator(new LinearInterpolator());
        translateanimation1.setFillAfter(true);
        animationlistener = new android.view.animation.Animation.AnimationListener() {

            public void onAnimationEnd(Animation animation) {
                Object obj;
                if(holdAfter) {
                    obj = new TranslateAnimation(dx, dx, dy, dy);
                    ((TranslateAnimation) (obj)).setDuration(1000L);
                    mAnimating = false;
                } else {
                    obj = new AlphaAnimation(0.5F, 1.0F);
                    ((AlphaAnimation) (obj)).setDuration(250L);
                    resetView();
                }
                ((Animation) (obj)).setAnimationListener(mAnimationDoneListener);
                mLeftSlider.startAnimation(((Animation) (obj)), ((Animation) (obj)));
                mRightSlider.startAnimation(((Animation) (obj)), ((Animation) (obj)));
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            final SlidingTab this$0;
            final int val$dx;
            final int val$dy;
            final boolean val$holdAfter;

             {
                this$0 = SlidingTab.this;
                holdAfter = flag;
                dx = i;
                dy = j;
                super();
            }
        };
        translateanimation.setAnimationListener(animationlistener);
        slider.hideTarget();
        slider.startAnimation(translateanimation, translateanimation1);
    }

    private static final int ANIM_DURATION = 250;
    private static final int ANIM_TARGET_TIME = 500;
    private static final boolean DBG = false;
    private static final int HORIZONTAL = 0;
    private static final String LOG_TAG = "SlidingTab";
    private static final float THRESHOLD = 0.6666667F;
    private static final int TRACKING_MARGIN = 50;
    private static final int VERTICAL = 1;
    private static final long VIBRATE_LONG = 40L;
    private static final long VIBRATE_SHORT = 30L;
    private boolean mAnimating;
    private final android.view.animation.Animation.AnimationListener mAnimationDoneListener;
    private Slider mCurrentSlider;
    private final float mDensity;
    private int mGrabbedState;
    private boolean mHoldLeftOnTransition;
    private boolean mHoldRightOnTransition;
    private final Slider mLeftSlider;
    private OnTriggerListener mOnTriggerListener;
    private final int mOrientation;
    private Slider mOtherSlider;
    private final Slider mRightSlider;
    private float mThreshold;
    private final Rect mTmpRect;
    private boolean mTracking;
    private boolean mTriggered;
    private Vibrator mVibrator;



/*
    static boolean access$202(SlidingTab slidingtab, boolean flag) {
        slidingtab.mAnimating = flag;
        return flag;
    }

*/




}
