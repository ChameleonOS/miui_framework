// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget.multiwaveview;

import android.animation.*;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.android.internal.widget.multiwaveview:
//            GlowPadView, TargetDrawable, Tweener

public class MiuiInCallAnswerWidgetHorizontal extends GlowPadView {

    public MiuiInCallAnswerWidgetHorizontal(Context context) {
        this(context, null);
    }

    public MiuiInCallAnswerWidgetHorizontal(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        mShowingOuterRing = false;
        mTargetLightDrawables = new ArrayList();
        mTargetLightAnimations = new ArrayList();
        mHandleAnimation = new GlowPadView.AnimationBundle(this);
        mOuterRingAnimation = new GlowPadView.AnimationBundle(this);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, miui.R.styleable.MiuiInCallAnswerWidgetHorizontal);
        TypedValue typedvalue = new TypedValue();
        if(typedarray.getValue(0, typedvalue))
            internalSetTargetLightResources(typedvalue.resourceId);
        mRightHintAnimTargetDrawable = new TargetDrawable(context.getResources(), typedarray.peekValue(1).resourceId);
        super.mGlowRadius = super.mHandleDrawable.getWidth() / 2;
    }

    private void hideRightHintAnim() {
        mRightHintAnimTargetDrawable.setAlpha(0.0F);
        if(mHintAnimation != null)
            mHintAnimation.end();
    }

    private void hideTargetLight() {
        for(Iterator iterator = mTargetLightDrawables.iterator(); iterator.hasNext(); ((TargetDrawable)iterator.next()).setAlpha(0.0F));
    }

    private void internalSetTargetLightResources(int i) {
        Resources resources = getContext().getResources();
        TypedArray typedarray = resources.obtainTypedArray(i);
        int j = typedarray.length();
        ArrayList arraylist = new ArrayList(j);
        int k = 0;
        while(k < j)  {
            TypedValue typedvalue = typedarray.peekValue(k);
            int l;
            if(typedvalue != null)
                l = typedvalue.resourceId;
            else
                l = 0;
            arraylist.add(new TargetDrawable(resources, l));
            k++;
        }
        typedarray.recycle();
        mTargetLightDrawables = arraylist;
        updateTargetLightPositions();
    }

    private void moveHandleTo(float f, float f1, boolean flag) {
        super.mHandleDrawable.setX(f);
        super.mHandleDrawable.setY(f1);
    }

    private void showOuterRing() {
        mShowingOuterRing = true;
        mOuterRingAnimation.cancel();
        super.mOuterRing.setScaleX(0.0F);
        super.mOuterRing.setScaleY(0.0F);
        GlowPadView.AnimationBundle animationbundle = mOuterRingAnimation;
        TargetDrawable targetdrawable = super.mOuterRing;
        Object aobj[] = new Object[12];
        aobj[0] = "alpha";
        aobj[1] = Float.valueOf(1.0F);
        aobj[2] = "scaleX";
        aobj[3] = Float.valueOf(1.0F);
        aobj[4] = "scaleY";
        aobj[5] = Float.valueOf(1.0F);
        aobj[6] = "delay";
        aobj[7] = Integer.valueOf(200);
        aobj[8] = "onUpdate";
        aobj[9] = new android.animation.ValueAnimator.AnimatorUpdateListener() {

            public void onAnimationUpdate(ValueAnimator valueanimator) {
                if(mOuterRing.getAlpha() < 0.1F)
                    mOuterRing.setAlpha(1.0F);
                invalidate();
            }

            final MiuiInCallAnswerWidgetHorizontal this$0;

             {
                this$0 = MiuiInCallAnswerWidgetHorizontal.this;
                super();
            }
        };
        aobj[10] = "onComplete";
        aobj[11] = mOuterRingListener;
        animationbundle.add(Tweener.to(targetdrawable, 300L, aobj));
        mOuterRingAnimation.start();
    }

    private void showRightHintAnim(int i) {
        if(i < STATE_HINT_ANIM.length) {
            mRightHintAnimTargetDrawable.setState(STATE_HINT_ANIM[i]);
            invalidate();
        }
    }

    private void startRightHintAnim() {
        TargetDrawable targetdrawable = mRightHintAnimTargetDrawable;
        float af[] = new float[2];
        af[0] = 0.0F;
        af[1] = 1.0F;
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(targetdrawable, "alpha", af);
        objectanimator.setDuration(300L);
        objectanimator.setStartDelay(400L);
        objectanimator.setInterpolator(null);
        objectanimator.start();
        float af1[] = new float[2];
        af1[0] = 0.0F;
        af1[1] = 1.0F;
        mHintAnimation = ValueAnimator.ofFloat(af1);
        mHintAnimation.setDuration(1500L);
        mHintAnimation.setInterpolator(null);
        mHintAnimation.setStartDelay(200L);
        mHintAnimation.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() {

            public void onAnimationUpdate(ValueAnimator valueanimator) {
                int i = (int)((100F * mHintAnimation.getAnimatedFraction()) / 14F);
                showRightHintAnim(i);
            }

            final MiuiInCallAnswerWidgetHorizontal this$0;

             {
                this$0 = MiuiInCallAnswerWidgetHorizontal.this;
                super();
            }
        });
        mHintAnimation.setRepeatCount(-1);
        mHintAnimation.setRepeatMode(1);
        mHintAnimation.start();
    }

    private void stopTargetLightAnimation() {
        for(Iterator iterator = mTargetLightAnimations.iterator(); iterator.hasNext(); ((Tweener)iterator.next()).animator.end());
        mTargetLightAnimations.clear();
    }

    private void updateRightHintAnimPositions() {
        mRightHintAnimTargetDrawable.setX(super.mWaveCenterX + 0.65F * super.mOuterRadius);
        mRightHintAnimTargetDrawable.setY(super.mWaveCenterY);
    }

    private void updateTargetLightPositions() {
        TargetDrawable targetdrawable;
        for(Iterator iterator = mTargetLightDrawables.iterator(); iterator.hasNext(); targetdrawable.setY(Math.max(super.mWaveCenterX, super.mWaveCenterY))) {
            targetdrawable = (TargetDrawable)iterator.next();
            targetdrawable.setX(super.mWaveCenterX);
        }

    }

    protected void doFinish() {
        int i = super.mActiveTarget;
        boolean flag;
        if(i != -1)
            flag = true;
        else
            flag = false;
        mHandleAnimation.cancel();
        if(flag) {
            ((TargetDrawable)super.mTargetDrawables.get(i)).setState(TargetDrawable.STATE_ACTIVE);
            hideTargets(false, false);
            hideRightHintAnim();
            dispatchTriggerEvent(super.mActiveTarget);
            GlowPadView.AnimationBundle animationbundle1 = mHandleAnimation;
            TargetDrawable targetdrawable1 = super.mHandleDrawable;
            Object aobj1[] = new Object[14];
            aobj1[0] = "ease";
            aobj1[1] = Ease.Quart.easeOut;
            aobj1[2] = "delay";
            aobj1[3] = Integer.valueOf(1200);
            aobj1[4] = "alpha";
            aobj1[5] = Float.valueOf(1.0F);
            aobj1[6] = "x";
            aobj1[7] = Integer.valueOf(0);
            aobj1[8] = "y";
            aobj1[9] = Integer.valueOf(0);
            aobj1[10] = "onUpdate";
            aobj1[11] = super.mUpdateListener;
            aobj1[12] = "onComplete";
            aobj1[13] = super.mResetListener;
            animationbundle1.add(Tweener.to(targetdrawable1, 0L, aobj1));
        } else {
            GlowPadView.AnimationBundle animationbundle = mHandleAnimation;
            TargetDrawable targetdrawable = super.mHandleDrawable;
            Object aobj[] = new Object[14];
            aobj[0] = "ease";
            aobj[1] = Ease.Quart.easeOut;
            aobj[2] = "delay";
            aobj[3] = Integer.valueOf(0);
            aobj[4] = "alpha";
            aobj[5] = Float.valueOf(1.0F);
            aobj[6] = "x";
            aobj[7] = Integer.valueOf(0);
            aobj[8] = "y";
            aobj[9] = Integer.valueOf(0);
            aobj[10] = "onUpdate";
            aobj[11] = super.mUpdateListener;
            aobj[12] = "onComplete";
            android.animation.Animator.AnimatorListener animatorlistener;
            if(super.mDragging)
                animatorlistener = super.mResetListenerWithPing;
            else
                animatorlistener = super.mResetListener;
            aobj[13] = animatorlistener;
            animationbundle.add(Tweener.to(targetdrawable, 300L, aobj));
        }
        mHandleAnimation.start();
        super.mDragging = false;
        setGrabbedState(0);
    }

    protected void handleMove(MotionEvent motionevent) {
        if(super.mDragging) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i = -1;
        int j = motionevent.getHistorySize();
        ArrayList arraylist = super.mTargetDrawables;
        int k = arraylist.size();
        float f = 0.0F;
        float f1 = 0.0F;
        int l = 0;
        while(l < j + 1)  {
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            double d;
            boolean flag;
            if(l < j)
                f2 = motionevent.getHistoricalX(l);
            else
                f2 = motionevent.getX();
            if(l < j)
                f3 = motionevent.getHistoricalY(l);
            else
                f3 = motionevent.getY();
            f4 = f2 - super.mWaveCenterX;
            f5 = f3 - super.mWaveCenterY;
            f6 = (float)Math.sqrt(dist2(f4, f5));
            if(f6 > super.mOuterRadius)
                f7 = super.mOuterRadius / f6;
            else
                f7 = 1.0F;
            f8 = f4 * f7;
            f9 = f5 * f7;
            d = Math.atan2(-f5, f4);
            if(super.mTargetDrawables.size() == 1)
                flag = true;
            else
                flag = false;
            if(flag) {
                if(f6 > super.mOuterRadius - super.mSnapMargin) {
                    i = 0;
                    f = f8;
                    f1 = f9;
                }
            } else {
                float f10 = super.mOuterRadius - super.mSnapMargin;
                float f11 = f10 * f10;
                int i1 = 0;
                while(i1 < k)  {
                    TargetDrawable targetdrawable4 = (TargetDrawable)arraylist.get(i1);
                    double d1 = (3.1415926535897931D * (2D * ((double)i1 - 0.5D))) / (double)k;
                    double d2 = (3.1415926535897931D * (2D * (0.5D + (double)i1))) / (double)k;
                    if(!targetdrawable4.isEnabled())
                        continue;
                    boolean flag1;
                    if(d > d1 && d <= d2 || 6.2831853071795862D + d > d1 && 6.2831853071795862D + d <= d2)
                        flag1 = true;
                    else
                        flag1 = false;
                    if(flag1 && dist2(f4, f5) > f11)
                        i = i1;
                    i1++;
                }
                f = f8;
                f1 = f9;
            }
            moveHandleTo(f, f1, false);
            if(i != -1) {
                TargetDrawable targetdrawable1;
                ArrayList arraylist3;
                TargetDrawable targetdrawable3;
                Object aobj2[];
                if(i == 2)
                    switchToState(6, f, f1);
                else
                if(i == 0)
                    switchToState(7, f, f1);
                else
                    switchToState(4, f, f1);
                targetdrawable1 = (TargetDrawable)mTargetLightDrawables.get(i);
                if(mCurrentTargetLight == null)
                    mCurrentTargetLight = targetdrawable1;
                else
                if(mCurrentTargetLight != targetdrawable1) {
                    ArrayList arraylist2 = mTargetLightAnimations;
                    TargetDrawable targetdrawable2 = mCurrentTargetLight;
                    Object aobj1[] = new Object[4];
                    aobj1[0] = "delay";
                    aobj1[1] = Integer.valueOf(0);
                    aobj1[2] = "alpha";
                    aobj1[3] = Float.valueOf(0.0F);
                    arraylist2.add(Tweener.to(targetdrawable2, 20L, aobj1));
                    mCurrentTargetLight = targetdrawable1;
                }
                if(mTargetLightAnimations.size() > 0)
                    stopTargetLightAnimation();
                arraylist3 = mTargetLightAnimations;
                targetdrawable3 = mCurrentTargetLight;
                aobj2 = new Object[4];
                aobj2[0] = "delay";
                aobj2[1] = Integer.valueOf(0);
                aobj2[2] = "alpha";
                aobj2[3] = Float.valueOf(1.0F);
                arraylist3.add(Tweener.to(targetdrawable3, 20L, aobj2));
            } else {
                if(mTargetLightAnimations.size() > 0)
                    stopTargetLightAnimation();
                if(mCurrentTargetLight != null) {
                    ArrayList arraylist1 = mTargetLightAnimations;
                    TargetDrawable targetdrawable = mCurrentTargetLight;
                    Object aobj[] = new Object[4];
                    aobj[0] = "delay";
                    aobj[1] = Integer.valueOf(0);
                    aobj[2] = "alpha";
                    aobj[3] = Float.valueOf(0.0F);
                    arraylist1.add(Tweener.to(targetdrawable, 20L, aobj));
                }
                switchToState(3, f, f1);
                super.mHandleDrawable.setAlpha(1.0F);
            }
            l++;
        }
        if(super.mActiveTarget != i && i != -1) {
            vibrate();
            if(AccessibilityManager.getInstance(super.mContext).isEnabled())
                announceForAccessibility(getTargetDescription(i));
        }
        super.mActiveTarget = i;
        if(true) goto _L1; else goto _L3
_L3:
    }

    protected void hideTargets(boolean flag, boolean flag1) {
        super.mTargetAnimations.cancel();
        super.mAnimatingTargets = flag;
        int i;
        char c;
        int j;
        android.animation.TimeInterpolator timeinterpolator;
        if(flag)
            i = 200;
        else
            i = 0;
        if(flag)
            c = '\310';
        else
            c = '\0';
        j = super.mTargetDrawables.size();
        timeinterpolator = Ease.Cubic.easeOut;
        for(int k = 0; k < j; k++) {
            TargetDrawable targetdrawable = (TargetDrawable)super.mTargetDrawables.get(k);
            targetdrawable.setState(TargetDrawable.STATE_INACTIVE);
            GlowPadView.AnimationBundle animationbundle = super.mTargetAnimations;
            long l = i;
            Object aobj[] = new Object[8];
            aobj[0] = "ease";
            aobj[1] = timeinterpolator;
            aobj[2] = "alpha";
            aobj[3] = Float.valueOf(0.0F);
            aobj[4] = "delay";
            aobj[5] = Integer.valueOf(c);
            aobj[6] = "onUpdate";
            aobj[7] = super.mUpdateListener;
            animationbundle.add(Tweener.to(targetdrawable, l, aobj));
        }

        super.mTargetAnimations.start();
        super.mOuterRing.setAlpha(0.0F);
        if(mTargetLightAnimations.size() > 0)
            stopTargetLightAnimation();
        hideTargetLight();
    }

    protected void onDraw(Canvas canvas) {
        super.mOuterRing.draw(canvas);
        Iterator iterator = mTargetLightDrawables.iterator();
        do {
            if(!iterator.hasNext())
                break;
            TargetDrawable targetdrawable1 = (TargetDrawable)iterator.next();
            if(targetdrawable1 != null)
                targetdrawable1.draw(canvas);
        } while(true);
        Iterator iterator1 = super.mTargetDrawables.iterator();
        do {
            if(!iterator1.hasNext())
                break;
            TargetDrawable targetdrawable = (TargetDrawable)iterator1.next();
            if(targetdrawable != null)
                targetdrawable.draw(canvas);
        } while(true);
        mRightHintAnimTargetDrawable.draw(canvas);
        super.mHandleDrawable.draw(canvas);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l) {
        super.onLayout(flag, i, j, k, l);
        updateTargetLightPositions();
        updateRightHintAnimPositions();
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
        boolean flag = true;
        if(!mShowingOuterRing) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(motionevent.getPointerCount() > flag) {
            if(super.mDragging) {
                super.mActiveTarget = -1;
                switchToState(5, motionevent.getX(), motionevent.getY());
            }
        } else {
            flag = super.onTouchEvent(motionevent);
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void reset(boolean flag) {
        super.reset(flag);
        hideRightHintAnim();
        mHandleAnimation.stop();
        super.mTargetAnimations.stop();
        showOuterRing();
        startRightHintAnim();
    }

    protected void showTargets(boolean flag) {
        int i = 200;
        super.mTargetAnimations.stop();
        if(mTargetLightAnimations.size() > 0)
            stopTargetLightAnimation();
        super.mAnimatingTargets = flag;
        int j;
        int k;
        if(flag)
            j = i;
        else
            j = 0;
        if(!flag)
            i = 0;
        k = super.mTargetDrawables.size();
        for(int l = 0; l < k; l++) {
            TargetDrawable targetdrawable = (TargetDrawable)super.mTargetDrawables.get(l);
            targetdrawable.setState(TargetDrawable.STATE_INACTIVE);
            GlowPadView.AnimationBundle animationbundle = super.mTargetAnimations;
            long l1 = i;
            Object aobj[] = new Object[12];
            aobj[0] = "ease";
            aobj[1] = Ease.Cubic.easeOut;
            aobj[2] = "alpha";
            aobj[3] = Float.valueOf(1.0F);
            aobj[4] = "scaleX";
            aobj[5] = Float.valueOf(1.0F);
            aobj[6] = "scaleY";
            aobj[7] = Float.valueOf(1.0F);
            aobj[8] = "delay";
            aobj[9] = Integer.valueOf(j);
            aobj[10] = "onUpdate";
            aobj[11] = super.mUpdateListener;
            animationbundle.add(Tweener.to(targetdrawable, l1, aobj));
        }

        super.mTargetAnimations.start();
        hideTargetLight();
    }

    protected void switchToState(int i, float f, float f1) {
        i;
        JVM INSTR tableswitch 0 7: default 48
    //                   0 49
    //                   1 48
    //                   2 74
    //                   3 120
    //                   4 159
    //                   5 172
    //                   6 133
    //                   7 146;
           goto _L1 _L2 _L1 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        return;
_L2:
        deactivateTargets();
        super.mHandleDrawable.setState(TargetDrawable.STATE_INACTIVE);
        super.mHandleDrawable.setAlpha(1.0F);
        continue; /* Loop/switch isn't completed */
_L3:
        mHandleAnimation.stop();
        deactivateTargets();
        super.mHandleDrawable.setState(TargetDrawable.STATE_ACTIVE);
        setGrabbedState(1);
        if(AccessibilityManager.getInstance(super.mContext).isEnabled())
            announceTargets();
        continue; /* Loop/switch isn't completed */
_L4:
        super.mHandleDrawable.setState(TargetDrawable.STATE_ACTIVE);
        continue; /* Loop/switch isn't completed */
_L7:
        super.mHandleDrawable.setState(STATE_DECLINE_HANDLE);
        continue; /* Loop/switch isn't completed */
_L8:
        super.mHandleDrawable.setState(STATE_ANSWER_HANDLE);
        continue; /* Loop/switch isn't completed */
_L5:
        super.mHandleDrawable.setState(TargetDrawable.STATE_ACTIVE);
        continue; /* Loop/switch isn't completed */
_L6:
        doFinish();
        if(true) goto _L1; else goto _L9
_L9:
    }

    private static final int HIDE_ANIMATION_DELAY = 200;
    private static final int HIDE_ANIMATION_DURATION = 200;
    private static final int HIDE_TARGET_LIGHT_DELAY = 20;
    private static final int RETURN_TO_HOME_DELAY = 1200;
    private static final int RETURN_TO_HOME_DURATION = 300;
    private static final int SHOW_ANIMATION_DELAY = 200;
    private static final int SHOW_ANIMATION_DURATION = 200;
    private static final int SHOW_HINT_ANIMATION_DELAY = 200;
    private static final int SHOW_HINT_ANIMATION_DURATION = 1500;
    private static final int SHOW_HINT_DELAY = 400;
    private static final int SHOW_HINT_DURATION = 300;
    private static final int SHOW_OUTERRING_DELAY = 200;
    private static final int SHOW_OUTERRING_DURATION = 300;
    private static final int SHOW_TARGET_LIGHT_DELAY = 20;
    private static final int STATE_ANSWER = 7;
    public static final int STATE_ANSWER_HANDLE[];
    private static final int STATE_DECLINE = 6;
    public static final int STATE_DECLINE_HANDLE[];
    private static final int STATE_FINISH = 5;
    private static final int STATE_FIRST_TOUCH = 2;
    public static final int STATE_HINT_ANIM[][];
    private static final int STATE_IDLE = 0;
    private static final int STATE_SNAP = 4;
    private static final int STATE_TRACKING = 3;
    private TargetDrawable mCurrentTargetLight;
    private GlowPadView.AnimationBundle mHandleAnimation;
    private ValueAnimator mHintAnimation;
    private GlowPadView.AnimationBundle mOuterRingAnimation;
    private android.animation.Animator.AnimatorListener mOuterRingListener = new AnimatorListenerAdapter() {

        public void onAnimationEnd(Animator animator) {
            mShowingOuterRing = false;
            showTargets(true);
        }

        final MiuiInCallAnswerWidgetHorizontal this$0;

             {
                this$0 = MiuiInCallAnswerWidgetHorizontal.this;
                super();
            }
    };
    private TargetDrawable mRightHintAnimTargetDrawable;
    private boolean mShowingOuterRing;
    private ArrayList mTargetLightAnimations;
    private ArrayList mTargetLightDrawables;

    static  {
        int ai[] = new int[3];
        ai[0] = 0x101009e;
        ai[1] = 0xfefeff5e;
        ai[2] = 0x101009c;
        STATE_DECLINE_HANDLE = ai;
        int ai1[] = new int[3];
        ai1[0] = 0x101009e;
        ai1[1] = 0x10100a2;
        ai1[2] = 0x101009c;
        STATE_ANSWER_HANDLE = ai1;
        int ai2[][] = new int[7][];
        int ai3[] = new int[3];
        ai3[0] = 0x101009e;
        ai3[1] = 0xfefeff5e;
        ai3[2] = 0xfefeff64;
        ai2[0] = ai3;
        int ai4[] = new int[3];
        ai4[0] = 0xfefeff62;
        ai4[1] = 0x10100a2;
        ai4[2] = 0xfefeff64;
        ai2[1] = ai4;
        int ai5[] = new int[3];
        ai5[0] = 0xfefeff62;
        ai5[1] = 0xfefeff5e;
        ai5[2] = 0x101009c;
        ai2[2] = ai5;
        int ai6[] = new int[3];
        ai6[0] = 0x101009e;
        ai6[1] = 0x10100a2;
        ai6[2] = 0xfefeff64;
        ai2[3] = ai6;
        int ai7[] = new int[3];
        ai7[0] = 0xfefeff62;
        ai7[1] = 0x10100a2;
        ai7[2] = 0x101009c;
        ai2[4] = ai7;
        int ai8[] = new int[3];
        ai8[0] = 0x101009e;
        ai8[1] = 0x10100a2;
        ai8[2] = 0x101009c;
        ai2[5] = ai8;
        int ai9[] = new int[3];
        ai9[0] = 0xfefeff62;
        ai9[1] = 0xfefeff5e;
        ai9[2] = 0xfefeff64;
        ai2[6] = ai9;
        STATE_HINT_ANIM = ai2;
    }


/*
    static boolean access$002(MiuiInCallAnswerWidgetHorizontal miuiincallanswerwidgethorizontal, boolean flag) {
        miuiincallanswerwidgethorizontal.mShowingOuterRing = flag;
        return flag;
    }

*/


}
