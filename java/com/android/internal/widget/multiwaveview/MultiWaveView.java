// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget.multiwaveview;

import android.animation.*;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.*;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.*;
import android.view.*;
import android.view.accessibility.AccessibilityManager;
import java.util.ArrayList;

// Referenced classes of package com.android.internal.widget.multiwaveview:
//            TargetDrawable, Tweener

public class MultiWaveView extends View {
    private class AnimationBundle extends ArrayList {

        public void cancel() {
            int i = size();
            for(int j = 0; j < i; j++)
                ((Tweener)get(j)).animator.cancel();

            clear();
        }

        public void setSuspended(boolean flag) {
            mSuspended = flag;
        }

        public void start() {
            if(!mSuspended) {
                int i = size();
                int j = 0;
                while(j < i)  {
                    ((Tweener)get(j)).animator.start();
                    j++;
                }
            }
        }

        public void stop() {
            int i = size();
            for(int j = 0; j < i; j++)
                ((Tweener)get(j)).animator.end();

            clear();
        }

        private static final long serialVersionUID = 0xa84d78726f127468L;
        private boolean mSuspended;
        final MultiWaveView this$0;

        private AnimationBundle() {
            this$0 = MultiWaveView.this;
            super();
        }

    }

    public static interface OnTriggerListener {

        public abstract void onFinishFinalAnimation();

        public abstract void onGrabbed(View view, int i);

        public abstract void onGrabbedStateChange(View view, int i);

        public abstract void onReleased(View view, int i);

        public abstract void onTrigger(View view, int i);

        public static final int CENTER_HANDLE = 1;
        public static final int NO_HANDLE;
    }


    public MultiWaveView(Context context) {
        this(context, null);
    }

    public MultiWaveView(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        mChevronAnimationInterpolator = Ease.Quad.easeOut;
        mTargetDrawables = new ArrayList();
        mChevronDrawables = new ArrayList();
        mChevronAnimations = new AnimationBundle();
        mTargetAnimations = new AnimationBundle();
        mHandleAnimations = new AnimationBundle();
        mFeedbackCount = 3;
        mVibrationDuration = 0;
        mActiveTarget = -1;
        mOuterRadius = 0.0F;
        mSnapMargin = 0.0F;
        mGravity = 48;
        mInitialLayout = true;
        Resources resources = context.getResources();
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.MultiWaveView);
        mOuterRadius = typedarray.getDimension(6, mOuterRadius);
        mSnapMargin = typedarray.getDimension(8, mSnapMargin);
        mVibrationDuration = typedarray.getInt(7, mVibrationDuration);
        mFeedbackCount = typedarray.getInt(9, mFeedbackCount);
        mHandleDrawable = new TargetDrawable(resources, typedarray.peekValue(3).resourceId);
        mTapRadius = mHandleDrawable.getWidth() / 2;
        mOuterRing = new TargetDrawable(resources, typedarray.peekValue(5).resourceId);
        mAlwaysTrackFinger = typedarray.getBoolean(10, false);
        TypedValue typedvalue = new TypedValue();
        if(typedarray.getValue(4, typedvalue)) {
            ArrayList arraylist = loadDrawableArray(typedvalue.resourceId);
            for(int k = 0; k < arraylist.size(); k++) {
                TargetDrawable targetdrawable = (TargetDrawable)arraylist.get(k);
                int l = 0;
                while(l < mFeedbackCount)  {
                    ArrayList arraylist1 = mChevronDrawables;
                    TargetDrawable targetdrawable1;
                    if(targetdrawable == null)
                        targetdrawable1 = null;
                    else
                        targetdrawable1 = new TargetDrawable(targetdrawable);
                    arraylist1.add(targetdrawable1);
                    l++;
                }
            }

        }
        if(typedarray.getValue(2, typedvalue))
            internalSetTargetResources(typedvalue.resourceId);
        if(mTargetDrawables == null || mTargetDrawables.size() == 0)
            throw new IllegalStateException("Must specify at least one target drawable");
        if(typedarray.getValue(0, typedvalue)) {
            int j = typedvalue.resourceId;
            if(j == 0)
                throw new IllegalStateException("Must specify target descriptions");
            setTargetDescriptionsResourceId(j);
        }
        if(typedarray.getValue(1, typedvalue)) {
            int i = typedvalue.resourceId;
            if(i == 0)
                throw new IllegalStateException("Must specify direction descriptions");
            setDirectionDescriptionsResourceId(i);
        }
        typedarray.recycle();
        TypedArray typedarray1 = context.obtainStyledAttributes(attributeset, android.R.styleable.LinearLayout);
        mGravity = typedarray1.getInt(0, 48);
        typedarray1.recycle();
        boolean flag;
        if(mVibrationDuration > 0)
            flag = true;
        else
            flag = false;
        setVibrateEnabled(flag);
        assignDefaultsIfNeeded();
    }

    private void activateHandle(int i, int j, float f, android.animation.Animator.AnimatorListener animatorlistener) {
        mHandleAnimations.cancel();
        AnimationBundle animationbundle = mHandleAnimations;
        TargetDrawable targetdrawable = mHandleDrawable;
        long l = i;
        Object aobj[] = new Object[10];
        aobj[0] = "ease";
        aobj[1] = Ease.Cubic.easeIn;
        aobj[2] = "delay";
        aobj[3] = Integer.valueOf(j);
        aobj[4] = "alpha";
        aobj[5] = Float.valueOf(f);
        aobj[6] = "onUpdate";
        aobj[7] = mUpdateListener;
        aobj[8] = "onComplete";
        aobj[9] = animatorlistener;
        animationbundle.add(Tweener.to(targetdrawable, l, aobj));
        mHandleAnimations.start();
    }

    private void announceTargets() {
        StringBuilder stringbuilder = new StringBuilder();
        int i = mTargetDrawables.size();
        for(int j = 0; j < i; j++) {
            String s = getTargetDescription(j);
            String s1 = getDirectionDescription(j);
            if(!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1)) {
                Object aobj[] = new Object[1];
                aobj[0] = s;
                stringbuilder.append(String.format(s1, aobj));
            }
            if(stringbuilder.length() > 0)
                announceText(stringbuilder.toString());
        }

    }

    private void announceText(String s) {
        setContentDescription(s);
        sendAccessibilityEvent(8);
        setContentDescription(null);
    }

    private void assignDefaultsIfNeeded() {
        if(mOuterRadius == 0.0F)
            mOuterRadius = (float)Math.max(mOuterRing.getWidth(), mOuterRing.getHeight()) / 2.0F;
        if(mSnapMargin == 0.0F)
            mSnapMargin = TypedValue.applyDimension(1, 20F, getContext().getResources().getDisplayMetrics());
    }

    private void computeInsets(int i, int j) {
        int l;
        int k = getResolvedLayoutDirection();
        l = Gravity.getAbsoluteGravity(mGravity, k);
        l & 7;
        JVM INSTR tableswitch 3 5: default 48
    //                   3 96
    //                   4 48
    //                   5 104;
           goto _L1 _L2 _L1 _L3
_L1:
        mHorizontalInset = i / 2;
_L7:
        l & 0x70;
        JVM INSTR lookupswitch 2: default 88
    //                   48: 112
    //                   80: 120;
           goto _L4 _L5 _L6
_L4:
        mVerticalInset = j / 2;
_L8:
        return;
_L2:
        mHorizontalInset = 0;
          goto _L7
_L3:
        mHorizontalInset = i;
          goto _L7
_L5:
        mVerticalInset = 0;
          goto _L8
_L6:
        mVerticalInset = j;
          goto _L8
    }

    private void deactivateHandle(int i, int j, float f, android.animation.Animator.AnimatorListener animatorlistener) {
        mHandleAnimations.cancel();
        AnimationBundle animationbundle = mHandleAnimations;
        TargetDrawable targetdrawable = mHandleDrawable;
        long l = i;
        Object aobj[] = new Object[14];
        aobj[0] = "ease";
        aobj[1] = Ease.Quart.easeOut;
        aobj[2] = "delay";
        aobj[3] = Integer.valueOf(j);
        aobj[4] = "alpha";
        aobj[5] = Float.valueOf(f);
        aobj[6] = "x";
        aobj[7] = Integer.valueOf(0);
        aobj[8] = "y";
        aobj[9] = Integer.valueOf(0);
        aobj[10] = "onUpdate";
        aobj[11] = mUpdateListener;
        aobj[12] = "onComplete";
        aobj[13] = animatorlistener;
        animationbundle.add(Tweener.to(targetdrawable, l, aobj));
        mHandleAnimations.start();
    }

    private void deactivateTargets() {
        int i = mTargetDrawables.size();
        for(int j = 0; j < i; j++)
            ((TargetDrawable)mTargetDrawables.get(j)).setState(TargetDrawable.STATE_INACTIVE);

        mActiveTarget = -1;
    }

    private void dispatchOnFinishFinalAnimation() {
        if(mOnTriggerListener != null)
            mOnTriggerListener.onFinishFinalAnimation();
    }

    private void dispatchTriggerEvent(int i) {
        vibrate();
        if(mOnTriggerListener != null)
            mOnTriggerListener.onTrigger(this, i);
    }

    private float dist2(float f, float f1) {
        return f * f + f1 * f1;
    }

    private void doFinish() {
        int i = mActiveTarget;
        boolean flag;
        if(i != -1)
            flag = true;
        else
            flag = false;
        if(flag) {
            highlightSelected(i);
            deactivateHandle(200, 1200, 0.0F, mResetListener);
            dispatchTriggerEvent(i);
            if(!mAlwaysTrackFinger)
                mTargetAnimations.stop();
        } else {
            deactivateHandle(200, 200, 1.0F, mResetListenerWithPing);
            hideTargets(true, false);
        }
        setGrabbedState(0);
    }

    private void dump() {
        Log.v("MultiWaveView", (new StringBuilder()).append("Outer Radius = ").append(mOuterRadius).toString());
        Log.v("MultiWaveView", (new StringBuilder()).append("SnapMargin = ").append(mSnapMargin).toString());
        Log.v("MultiWaveView", (new StringBuilder()).append("FeedbackCount = ").append(mFeedbackCount).toString());
        Log.v("MultiWaveView", (new StringBuilder()).append("VibrationDuration = ").append(mVibrationDuration).toString());
        Log.v("MultiWaveView", (new StringBuilder()).append("TapRadius = ").append(mTapRadius).toString());
        Log.v("MultiWaveView", (new StringBuilder()).append("WaveCenterX = ").append(mWaveCenterX).toString());
        Log.v("MultiWaveView", (new StringBuilder()).append("WaveCenterY = ").append(mWaveCenterY).toString());
    }

    private String getDirectionDescription(int i) {
        if(mDirectionDescriptions != null && !mDirectionDescriptions.isEmpty()) goto _L2; else goto _L1
_L1:
        mDirectionDescriptions = loadDescriptions(mDirectionDescriptionsResourceId);
        if(mTargetDrawables.size() == mDirectionDescriptions.size()) goto _L2; else goto _L3
_L3:
        String s;
        Log.w("MultiWaveView", "The number of target drawables must be euqal to the number of direction descriptions.");
        s = null;
_L5:
        return s;
_L2:
        s = (String)mDirectionDescriptions.get(i);
        if(true) goto _L5; else goto _L4
_L4:
    }

    private float getScaledTapRadiusSquared() {
        float f;
        if(AccessibilityManager.getInstance(super.mContext).isEnabled())
            f = 1.3F * mTapRadius;
        else
            f = mTapRadius;
        return square(f);
    }

    private String getTargetDescription(int i) {
        if(mTargetDescriptions != null && !mTargetDescriptions.isEmpty()) goto _L2; else goto _L1
_L1:
        mTargetDescriptions = loadDescriptions(mTargetDescriptionsResourceId);
        if(mTargetDrawables.size() == mTargetDescriptions.size()) goto _L2; else goto _L3
_L3:
        String s;
        Log.w("MultiWaveView", "The number of target drawables must be euqal to the number of target descriptions.");
        s = null;
_L5:
        return s;
_L2:
        s = (String)mTargetDescriptions.get(i);
        if(true) goto _L5; else goto _L4
_L4:
    }

    private void handleCancel(MotionEvent motionevent) {
        switchToState(5, motionevent.getX(), motionevent.getY());
    }

    private void handleDown(MotionEvent motionevent) {
        float f = motionevent.getX();
        float f1 = motionevent.getY();
        switchToState(1, f, f1);
        if(!trySwitchToFirstTouchState(f, f1)) {
            mDragging = false;
            ping();
        }
    }

    private void handleMove(MotionEvent motionevent) {
        int i = -1;
        int j = motionevent.getHistorySize();
        ArrayList arraylist = mTargetDrawables;
        int k = arraylist.size();
        float f = 0.0F;
        float f1 = 0.0F;
        for(int l = 0; l < j + 1; l++) {
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            double d;
            if(l < j)
                f2 = motionevent.getHistoricalX(l);
            else
                f2 = motionevent.getX();
            if(l < j)
                f3 = motionevent.getHistoricalY(l);
            else
                f3 = motionevent.getY();
            f4 = f2 - mWaveCenterX;
            f5 = f3 - mWaveCenterY;
            f6 = (float)Math.sqrt(dist2(f4, f5));
            if(f6 > mOuterRadius)
                f7 = mOuterRadius / f6;
            else
                f7 = 1.0F;
            f8 = f4 * f7;
            f9 = f5 * f7;
            d = Math.atan2(-f5, f4);
            if(!mDragging)
                trySwitchToFirstTouchState(f2, f3);
            if(mDragging) {
                float f10 = mOuterRadius - mSnapMargin;
                float f11 = f10 * f10;
                int i1 = 0;
                while(i1 < k)  {
                    TargetDrawable targetdrawable2 = (TargetDrawable)arraylist.get(i1);
                    double d1 = (3.1415926535897931D * (2D * ((double)i1 - 0.5D))) / (double)k;
                    double d2 = (3.1415926535897931D * (2D * (0.5D + (double)i1))) / (double)k;
                    if(!targetdrawable2.isEnabled())
                        continue;
                    boolean flag;
                    if(d > d1 && d <= d2 || 6.2831853071795862D + d > d1 && 6.2831853071795862D + d <= d2)
                        flag = true;
                    else
                        flag = false;
                    if(flag && dist2(f4, f5) > f11)
                        i = i1;
                    i1++;
                }
            }
            f = f8;
            f1 = f9;
        }

        if(mDragging) {
            if(i != -1) {
                switchToState(4, f, f1);
                moveHandleTo(f, f1, false);
            } else {
                switchToState(3, f, f1);
                moveHandleTo(f, f1, false);
            }
            invalidateGlobalRegion(mHandleDrawable);
            if(mActiveTarget != i) {
                if(mActiveTarget != -1) {
                    TargetDrawable targetdrawable1 = (TargetDrawable)arraylist.get(mActiveTarget);
                    if(targetdrawable1.hasState(TargetDrawable.STATE_FOCUSED))
                        targetdrawable1.setState(TargetDrawable.STATE_INACTIVE);
                }
                if(i != -1) {
                    TargetDrawable targetdrawable = (TargetDrawable)arraylist.get(i);
                    if(targetdrawable.hasState(TargetDrawable.STATE_FOCUSED))
                        targetdrawable.setState(TargetDrawable.STATE_FOCUSED);
                    if(AccessibilityManager.getInstance(super.mContext).isEnabled())
                        announceText(getTargetDescription(i));
                    activateHandle(0, 0, 0.0F, null);
                } else {
                    activateHandle(0, 0, 1.0F, null);
                }
            }
            mActiveTarget = i;
        }
    }

    private void handleUp(MotionEvent motionevent) {
        switchToState(5, motionevent.getX(), motionevent.getY());
    }

    private void hideChevrons() {
        ArrayList arraylist = mChevronDrawables;
        int i = arraylist.size();
        for(int j = 0; j < i; j++) {
            TargetDrawable targetdrawable = (TargetDrawable)arraylist.get(j);
            if(targetdrawable != null)
                targetdrawable.setAlpha(0.0F);
        }

    }

    private void hideTargets(boolean flag, boolean flag1) {
        mTargetAnimations.cancel();
        mAnimatingTargets = flag;
        int i;
        char c;
        float f;
        int j;
        if(flag)
            i = 200;
        else
            i = 0;
        if(flag)
            c = '\310';
        else
            c = '\0';
        if(flag1)
            f = 1.0F;
        else
            f = 0.8F;
        j = mTargetDrawables.size();
        for(int k = 0; k < j; k++) {
            TargetDrawable targetdrawable1 = (TargetDrawable)mTargetDrawables.get(k);
            targetdrawable1.setState(TargetDrawable.STATE_INACTIVE);
            AnimationBundle animationbundle1 = mTargetAnimations;
            long l1 = i;
            Object aobj1[] = new Object[12];
            aobj1[0] = "ease";
            aobj1[1] = Ease.Cubic.easeOut;
            aobj1[2] = "alpha";
            aobj1[3] = Float.valueOf(0.0F);
            aobj1[4] = "scaleX";
            aobj1[5] = Float.valueOf(f);
            aobj1[6] = "scaleY";
            aobj1[7] = Float.valueOf(f);
            aobj1[8] = "delay";
            aobj1[9] = Integer.valueOf(c);
            aobj1[10] = "onUpdate";
            aobj1[11] = mUpdateListener;
            animationbundle1.add(Tweener.to(targetdrawable1, l1, aobj1));
        }

        float f1;
        AnimationBundle animationbundle;
        TargetDrawable targetdrawable;
        long l;
        Object aobj[];
        if(flag1)
            f1 = 1.0F;
        else
            f1 = 0.5F;
        animationbundle = mTargetAnimations;
        targetdrawable = mOuterRing;
        l = i;
        aobj = new Object[14];
        aobj[0] = "ease";
        aobj[1] = Ease.Cubic.easeOut;
        aobj[2] = "alpha";
        aobj[3] = Float.valueOf(0.0F);
        aobj[4] = "scaleX";
        aobj[5] = Float.valueOf(f1);
        aobj[6] = "scaleY";
        aobj[7] = Float.valueOf(f1);
        aobj[8] = "delay";
        aobj[9] = Integer.valueOf(c);
        aobj[10] = "onUpdate";
        aobj[11] = mUpdateListener;
        aobj[12] = "onComplete";
        aobj[13] = mTargetUpdateListener;
        animationbundle.add(Tweener.to(targetdrawable, l, aobj));
        mTargetAnimations.start();
    }

    private void hideUnselected(int i) {
        for(int j = 0; j < mTargetDrawables.size(); j++)
            if(j != i)
                ((TargetDrawable)mTargetDrawables.get(j)).setAlpha(0.0F);

    }

    private void highlightSelected(int i) {
        ((TargetDrawable)mTargetDrawables.get(i)).setState(TargetDrawable.STATE_ACTIVE);
        hideUnselected(i);
    }

    private void internalSetTargetResources(int i) {
        mTargetDrawables = loadDrawableArray(i);
        mTargetResourceId = i;
        int j = mTargetDrawables.size();
        int k = mHandleDrawable.getWidth();
        int l = mHandleDrawable.getHeight();
        for(int i1 = 0; i1 < j; i1++) {
            TargetDrawable targetdrawable = (TargetDrawable)mTargetDrawables.get(i1);
            k = Math.max(k, targetdrawable.getWidth());
            l = Math.max(l, targetdrawable.getHeight());
        }

        if(mMaxTargetWidth != k || mMaxTargetHeight != l) {
            mMaxTargetWidth = k;
            mMaxTargetHeight = l;
            requestLayout();
        } else {
            updateTargetPositions(mWaveCenterX, mWaveCenterY);
            updateChevronPositions(mWaveCenterX, mWaveCenterY);
        }
    }

    private ArrayList loadDescriptions(int i) {
        TypedArray typedarray = getContext().getResources().obtainTypedArray(i);
        int j = typedarray.length();
        ArrayList arraylist = new ArrayList(j);
        for(int k = 0; k < j; k++)
            arraylist.add(typedarray.getString(k));

        typedarray.recycle();
        return arraylist;
    }

    private ArrayList loadDrawableArray(int i) {
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
        return arraylist;
    }

    private void moveHandleTo(float f, float f1, boolean flag) {
        mHandleDrawable.setX(f);
        mHandleDrawable.setY(f1);
    }

    private boolean replaceTargetDrawables(Resources resources, int i, int j) {
        if(i != 0 && j != 0) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = false;
        ArrayList arraylist = mTargetDrawables;
        int k = arraylist.size();
        for(int l = 0; l < k; l++) {
            TargetDrawable targetdrawable = (TargetDrawable)arraylist.get(l);
            if(targetdrawable != null && targetdrawable.getResourceId() == i) {
                targetdrawable.setDrawable(resources, j);
                flag = true;
            }
        }

        if(flag)
            requestLayout();
        if(true) goto _L4; else goto _L3
_L3:
    }

    private int resolveMeasured(int i, int j) {
        int k = android.view.View.MeasureSpec.getSize(i);
        android.view.View.MeasureSpec.getMode(i);
        JVM INSTR lookupswitch 2: default 36
    //                   -2147483648: 48
    //                   0: 42;
           goto _L1 _L2 _L3
_L1:
        int l = k;
_L5:
        return l;
_L3:
        l = j;
        continue; /* Loop/switch isn't completed */
_L2:
        l = Math.min(k, j);
        if(true) goto _L5; else goto _L4
_L4:
    }

    private void setGrabbedState(int i) {
        if(i != mGrabbedState) {
            if(i != 0)
                vibrate();
            mGrabbedState = i;
            if(mOnTriggerListener != null) {
                if(i == 0)
                    mOnTriggerListener.onReleased(this, 1);
                else
                    mOnTriggerListener.onGrabbed(this, 1);
                mOnTriggerListener.onGrabbedStateChange(this, i);
            }
        }
    }

    private void showTargets(boolean flag) {
        mTargetAnimations.stop();
        mAnimatingTargets = flag;
        byte byte0;
        int i;
        int j;
        if(flag)
            byte0 = 50;
        else
            byte0 = 0;
        if(flag)
            i = 200;
        else
            i = 0;
        j = mTargetDrawables.size();
        for(int k = 0; k < j; k++) {
            TargetDrawable targetdrawable1 = (TargetDrawable)mTargetDrawables.get(k);
            targetdrawable1.setState(TargetDrawable.STATE_INACTIVE);
            AnimationBundle animationbundle1 = mTargetAnimations;
            long l1 = i;
            Object aobj1[] = new Object[12];
            aobj1[0] = "ease";
            aobj1[1] = Ease.Cubic.easeOut;
            aobj1[2] = "alpha";
            aobj1[3] = Float.valueOf(1.0F);
            aobj1[4] = "scaleX";
            aobj1[5] = Float.valueOf(1.0F);
            aobj1[6] = "scaleY";
            aobj1[7] = Float.valueOf(1.0F);
            aobj1[8] = "delay";
            aobj1[9] = Integer.valueOf(byte0);
            aobj1[10] = "onUpdate";
            aobj1[11] = mUpdateListener;
            animationbundle1.add(Tweener.to(targetdrawable1, l1, aobj1));
        }

        AnimationBundle animationbundle = mTargetAnimations;
        TargetDrawable targetdrawable = mOuterRing;
        long l = i;
        Object aobj[] = new Object[14];
        aobj[0] = "ease";
        aobj[1] = Ease.Cubic.easeOut;
        aobj[2] = "alpha";
        aobj[3] = Float.valueOf(1.0F);
        aobj[4] = "scaleX";
        aobj[5] = Float.valueOf(1.0F);
        aobj[6] = "scaleY";
        aobj[7] = Float.valueOf(1.0F);
        aobj[8] = "delay";
        aobj[9] = Integer.valueOf(byte0);
        aobj[10] = "onUpdate";
        aobj[11] = mUpdateListener;
        aobj[12] = "onComplete";
        aobj[13] = mTargetUpdateListener;
        animationbundle.add(Tweener.to(targetdrawable, l, aobj));
        mTargetAnimations.start();
    }

    private float square(float f) {
        return f * f;
    }

    private void startBackgroundAnimation(int i, float f) {
        android.graphics.drawable.Drawable drawable = getBackground();
        if(mAlwaysTrackFinger && drawable != null) {
            if(mBackgroundAnimator != null)
                mBackgroundAnimator.animator.end();
            long l = i;
            Object aobj[] = new Object[6];
            aobj[0] = "ease";
            aobj[1] = Ease.Cubic.easeIn;
            aobj[2] = "alpha";
            int ai[] = new int[2];
            ai[0] = 0;
            ai[1] = (int)(255F * f);
            aobj[3] = ai;
            aobj[4] = "delay";
            aobj[5] = Integer.valueOf(50);
            mBackgroundAnimator = Tweener.to(drawable, l, aobj);
            mBackgroundAnimator.animator.start();
        }
    }

    private void startChevronAnimation() {
        float f = 0.8F * (float)mHandleDrawable.getWidth();
        float f1 = (0.9F * mOuterRadius) / 2.0F;
        int i;
        if(mFeedbackCount > 0)
            i = mChevronDrawables.size() / mFeedbackCount;
        else
            i = 0;
        mChevronAnimations.stop();
        for(int j = 0; j < i; j++) {
            double d = (6.2831853071795862D * (double)j) / (double)i;
            float f2 = (float)Math.cos(d);
            float f3 = 0.0F - (float)Math.sin(d);
            float af[] = new float[2];
            af[0] = f2 * f;
            af[1] = f2 * f1;
            float af1[] = new float[2];
            af1[0] = f3 * f;
            af1[1] = f3 * f1;
            int k = 0;
            while(k < mFeedbackCount)  {
                int l = k * 160;
                TargetDrawable targetdrawable = (TargetDrawable)mChevronDrawables.get(k + j * mFeedbackCount);
                if(targetdrawable != null) {
                    AnimationBundle animationbundle = mChevronAnimations;
                    Object aobj[] = new Object[16];
                    aobj[0] = "ease";
                    aobj[1] = mChevronAnimationInterpolator;
                    aobj[2] = "delay";
                    aobj[3] = Integer.valueOf(l);
                    aobj[4] = "x";
                    aobj[5] = af;
                    aobj[6] = "y";
                    aobj[7] = af1;
                    aobj[8] = "alpha";
                    float af2[] = new float[2];
                    af2[0] = 1.0F;
                    af2[1] = 0.0F;
                    aobj[9] = af2;
                    aobj[10] = "scaleX";
                    float af3[] = new float[2];
                    af3[0] = 0.5F;
                    af3[1] = 2.0F;
                    aobj[11] = af3;
                    aobj[12] = "scaleY";
                    float af4[] = new float[2];
                    af4[0] = 0.5F;
                    af4[1] = 2.0F;
                    aobj[13] = af4;
                    aobj[14] = "onUpdate";
                    aobj[15] = mUpdateListener;
                    animationbundle.add(Tweener.to(targetdrawable, 850L, aobj));
                }
                k++;
            }
        }

        mChevronAnimations.start();
    }

    private void switchToState(int i, float f, float f1) {
        i;
        JVM INSTR tableswitch 0 5: default 40
    //                   0 41
    //                   1 70
    //                   2 87
    //                   3 40
    //                   4 40
    //                   5 139;
           goto _L1 _L2 _L3 _L4 _L1 _L1 _L5
_L1:
        return;
_L2:
        deactivateTargets();
        hideTargets(true, false);
        startBackgroundAnimation(0, 0.0F);
        mHandleDrawable.setState(TargetDrawable.STATE_INACTIVE);
        continue; /* Loop/switch isn't completed */
_L3:
        deactivateHandle(0, 0, 1.0F, null);
        startBackgroundAnimation(0, 0.0F);
        continue; /* Loop/switch isn't completed */
_L4:
        deactivateTargets();
        showTargets(true);
        mHandleDrawable.setState(TargetDrawable.STATE_ACTIVE);
        startBackgroundAnimation(200, 1.0F);
        setGrabbedState(1);
        if(AccessibilityManager.getInstance(super.mContext).isEnabled())
            announceTargets();
        continue; /* Loop/switch isn't completed */
_L5:
        doFinish();
        if(true) goto _L1; else goto _L6
_L6:
    }

    private boolean trySwitchToFirstTouchState(float f, float f1) {
        boolean flag = false;
        float f2 = f - mWaveCenterX;
        float f3 = f1 - mWaveCenterY;
        if(mAlwaysTrackFinger || dist2(f2, f3) <= getScaledTapRadiusSquared()) {
            switchToState(2, f, f1);
            moveHandleTo(f2, f3, false);
            mDragging = true;
            flag = true;
        }
        return flag;
    }

    private void updateChevronPositions(float f, float f1) {
        ArrayList arraylist = mChevronDrawables;
        int i = arraylist.size();
        for(int j = 0; j < i; j++) {
            TargetDrawable targetdrawable = (TargetDrawable)arraylist.get(j);
            if(targetdrawable != null) {
                targetdrawable.setPositionX(f);
                targetdrawable.setPositionY(f1);
            }
        }

    }

    private void updateTargetPositions(float f, float f1) {
        ArrayList arraylist = mTargetDrawables;
        int i = arraylist.size();
        float f2 = (float)(-6.2831853071795862D / (double)i);
        for(int j = 0; j < i; j++) {
            TargetDrawable targetdrawable = (TargetDrawable)arraylist.get(j);
            float f3 = f2 * (float)j;
            targetdrawable.setPositionX(f);
            targetdrawable.setPositionY(f1);
            targetdrawable.setX(mOuterRadius * (float)Math.cos(f3));
            targetdrawable.setY(mOuterRadius * (float)Math.sin(f3));
        }

    }

    private void vibrate() {
        if(mVibrator != null)
            mVibrator.vibrate(mVibrationDuration);
    }

    public int getDirectionDescriptionsResourceId() {
        return mDirectionDescriptionsResourceId;
    }

    public int getResourceIdForTarget(int i) {
        TargetDrawable targetdrawable = (TargetDrawable)mTargetDrawables.get(i);
        int j;
        if(targetdrawable == null)
            j = 0;
        else
            j = targetdrawable.getResourceId();
        return j;
    }

    protected int getSuggestedMinimumHeight() {
        return (int)(Math.max(mOuterRing.getHeight(), 2.0F * mOuterRadius) + (float)mMaxTargetHeight);
    }

    protected int getSuggestedMinimumWidth() {
        return (int)(Math.max(mOuterRing.getWidth(), 2.0F * mOuterRadius) + (float)mMaxTargetWidth);
    }

    public int getTargetDescriptionsResourceId() {
        return mTargetDescriptionsResourceId;
    }

    public int getTargetPosition(int i) {
        int j = 0;
_L3:
        if(j >= mTargetDrawables.size())
            break MISSING_BLOCK_LABEL_39;
        if(((TargetDrawable)mTargetDrawables.get(j)).getResourceId() != i) goto _L2; else goto _L1
_L1:
        return j;
_L2:
        j++;
          goto _L3
        j = -1;
          goto _L1
    }

    public int getTargetResourceId() {
        return mTargetResourceId;
    }

    void invalidateGlobalRegion(TargetDrawable targetdrawable) {
        int i = targetdrawable.getWidth();
        int j = targetdrawable.getHeight();
        RectF rectf = new RectF(0.0F, 0.0F, i, j);
        rectf.offset(targetdrawable.getX() - (float)(i / 2), targetdrawable.getY() - (float)(j / 2));
        for(Object obj = this; ((View) (obj)).getParent() != null && (((View) (obj)).getParent() instanceof View); ((View) (obj)).invalidate((int)Math.floor(rectf.left), (int)Math.floor(rectf.top), (int)Math.ceil(rectf.right), (int)Math.ceil(rectf.bottom))) {
            obj = (View)((View) (obj)).getParent();
            ((View) (obj)).getMatrix().mapRect(rectf);
        }

    }

    protected void onDraw(Canvas canvas) {
        mOuterRing.draw(canvas);
        int i = mTargetDrawables.size();
        for(int j = 0; j < i; j++) {
            TargetDrawable targetdrawable1 = (TargetDrawable)mTargetDrawables.get(j);
            if(targetdrawable1 != null)
                targetdrawable1.draw(canvas);
        }

        int k = mChevronDrawables.size();
        for(int l = 0; l < k; l++) {
            TargetDrawable targetdrawable = (TargetDrawable)mChevronDrawables.get(l);
            if(targetdrawable != null)
                targetdrawable.draw(canvas);
        }

        mHandleDrawable.draw(canvas);
    }

    public boolean onHoverEvent(MotionEvent motionevent) {
        if(!AccessibilityManager.getInstance(super.mContext).isTouchExplorationEnabled()) goto _L2; else goto _L1
_L1:
        int i = motionevent.getAction();
        i;
        JVM INSTR tableswitch 7 10: default 48
    //                   7 73
    //                   8 48
    //                   9 65
    //                   10 81;
           goto _L3 _L4 _L3 _L5 _L6
_L3:
        onTouchEvent(motionevent);
        motionevent.setAction(i);
_L2:
        return super.onHoverEvent(motionevent);
_L5:
        motionevent.setAction(0);
        continue; /* Loop/switch isn't completed */
_L4:
        motionevent.setAction(2);
        continue; /* Loop/switch isn't completed */
_L6:
        motionevent.setAction(1);
        if(true) goto _L3; else goto _L7
_L7:
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l) {
        super.onLayout(flag, i, j, k, l);
        int i1 = k - i;
        int j1 = l - j;
        float f = Math.max(mOuterRing.getWidth(), 2.0F * mOuterRadius);
        float f1 = Math.max(mOuterRing.getHeight(), 2.0F * mOuterRadius);
        float f2 = (float)mHorizontalInset + Math.max(i1, f + (float)mMaxTargetWidth) / 2.0F;
        float f3 = (float)mVerticalInset + Math.max(j1, f1 + (float)mMaxTargetHeight) / 2.0F;
        if(mInitialLayout) {
            hideChevrons();
            hideTargets(false, false);
            moveHandleTo(0.0F, 0.0F, false);
            mInitialLayout = false;
        }
        mOuterRing.setPositionX(f2);
        mOuterRing.setPositionY(f3);
        mHandleDrawable.setPositionX(f2);
        mHandleDrawable.setPositionY(f3);
        updateTargetPositions(f2, f3);
        updateChevronPositions(f2, f3);
        mWaveCenterX = f2;
        mWaveCenterY = f3;
    }

    protected void onMeasure(int i, int j) {
        int k = getSuggestedMinimumWidth();
        int l = getSuggestedMinimumHeight();
        int i1 = resolveMeasured(i, k);
        int j1 = resolveMeasured(j, l);
        computeInsets(i1 - k, j1 - l);
        setMeasuredDimension(i1, j1);
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
        int i;
        boolean flag;
        i = motionevent.getAction();
        flag = false;
        i;
        JVM INSTR tableswitch 0 3: default 40
    //                   0 54
    //                   1 74
    //                   2 64
    //                   3 89;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_89;
_L6:
        invalidate();
        boolean flag1;
        if(flag)
            flag1 = true;
        else
            flag1 = super.onTouchEvent(motionevent);
        return flag1;
_L2:
        handleDown(motionevent);
        flag = true;
          goto _L6
_L4:
        handleMove(motionevent);
        flag = true;
          goto _L6
_L3:
        handleMove(motionevent);
        handleUp(motionevent);
        flag = true;
          goto _L6
        handleMove(motionevent);
        handleCancel(motionevent);
        flag = true;
          goto _L6
    }

    public void ping() {
        startChevronAnimation();
    }

    public boolean replaceTargetDrawablesIfPresent(ComponentName componentname, String s, int i) {
        boolean flag = false;
        if(i != 0) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        boolean flag1;
        PackageManager packagemanager = super.mContext.getPackageManager();
        Bundle bundle = ((PackageItemInfo) (packagemanager.getActivityInfo(componentname, 128))).metaData;
        if(bundle == null)
            continue; /* Loop/switch isn't completed */
        int j = bundle.getInt(s);
        if(j == 0)
            continue; /* Loop/switch isn't completed */
        flag1 = replaceTargetDrawables(packagemanager.getResourcesForActivity(componentname), i, j);
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        Log.w("MultiWaveView", (new StringBuilder()).append("Failed to swap drawable; ").append(componentname.flattenToShortString()).append(" not found").toString(), namenotfoundexception);
        continue; /* Loop/switch isn't completed */
        android.content.res.Resources.NotFoundException notfoundexception;
        notfoundexception;
        Log.w("MultiWaveView", (new StringBuilder()).append("Failed to swap drawable from ").append(componentname.flattenToShortString()).toString(), notfoundexception);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void reset(boolean flag) {
        mChevronAnimations.stop();
        mHandleAnimations.stop();
        mTargetAnimations.stop();
        startBackgroundAnimation(0, 0.0F);
        hideChevrons();
        hideTargets(flag, false);
        deactivateHandle(0, 0, 1.0F, null);
        Tweener.reset();
    }

    public void resumeAnimations() {
        mChevronAnimations.setSuspended(false);
        mTargetAnimations.setSuspended(false);
        mHandleAnimations.setSuspended(false);
        mChevronAnimations.start();
        mTargetAnimations.start();
        mHandleAnimations.start();
    }

    public void setDirectionDescriptionsResourceId(int i) {
        mDirectionDescriptionsResourceId = i;
        if(mDirectionDescriptions != null)
            mDirectionDescriptions.clear();
    }

    public void setEnableTarget(int i, boolean flag) {
        int j = 0;
        do {
label0:
            {
                if(j < mTargetDrawables.size()) {
                    TargetDrawable targetdrawable = (TargetDrawable)mTargetDrawables.get(j);
                    if(targetdrawable.getResourceId() != i)
                        break label0;
                    targetdrawable.setEnabled(flag);
                }
                return;
            }
            j++;
        } while(true);
    }

    public void setOnTriggerListener(OnTriggerListener ontriggerlistener) {
        mOnTriggerListener = ontriggerlistener;
    }

    public void setTargetDescriptionsResourceId(int i) {
        mTargetDescriptionsResourceId = i;
        if(mTargetDescriptions != null)
            mTargetDescriptions.clear();
    }

    public void setTargetResources(int i) {
        if(mAnimatingTargets)
            mNewTargetResources = i;
        else
            internalSetTargetResources(i);
    }

    public void setVibrateEnabled(boolean flag) {
        if(flag && mVibrator == null)
            mVibrator = (Vibrator)getContext().getSystemService("vibrator");
        else
            mVibrator = null;
    }

    public void suspendAnimations() {
        mChevronAnimations.setSuspended(true);
        mTargetAnimations.setSuspended(true);
        mHandleAnimations.setSuspended(true);
    }

    private static final int CHEVRON_ANIMATION_DURATION = 850;
    private static final int CHEVRON_INCREMENTAL_DELAY = 160;
    private static final boolean DEBUG = false;
    private static final int HIDE_ANIMATION_DELAY = 200;
    private static final int HIDE_ANIMATION_DURATION = 200;
    private static final int INITIAL_SHOW_HANDLE_DURATION = 200;
    private static final int RETURN_TO_HOME_DELAY = 1200;
    private static final int RETURN_TO_HOME_DURATION = 200;
    private static final float RING_SCALE_COLLAPSED = 0.5F;
    private static final float RING_SCALE_EXPANDED = 1F;
    private static final int SHOW_ANIMATION_DELAY = 50;
    private static final int SHOW_ANIMATION_DURATION = 200;
    private static final float SNAP_MARGIN_DEFAULT = 20F;
    private static final int STATE_FINISH = 5;
    private static final int STATE_FIRST_TOUCH = 2;
    private static final int STATE_IDLE = 0;
    private static final int STATE_SNAP = 4;
    private static final int STATE_START = 1;
    private static final int STATE_TRACKING = 3;
    private static final String TAG = "MultiWaveView";
    private static final float TAP_RADIUS_SCALE_ACCESSIBILITY_ENABLED = 1.3F;
    private static final float TARGET_SCALE_COLLAPSED = 0.8F;
    private static final float TARGET_SCALE_EXPANDED = 1F;
    private int mActiveTarget;
    private boolean mAlwaysTrackFinger;
    private boolean mAnimatingTargets;
    private Tweener mBackgroundAnimator;
    private TimeInterpolator mChevronAnimationInterpolator;
    private AnimationBundle mChevronAnimations;
    private ArrayList mChevronDrawables;
    private ArrayList mDirectionDescriptions;
    private int mDirectionDescriptionsResourceId;
    private boolean mDragging;
    private int mFeedbackCount;
    private int mGrabbedState;
    private int mGravity;
    private AnimationBundle mHandleAnimations;
    private TargetDrawable mHandleDrawable;
    private int mHorizontalInset;
    private boolean mInitialLayout;
    private int mMaxTargetHeight;
    private int mMaxTargetWidth;
    private int mNewTargetResources;
    private OnTriggerListener mOnTriggerListener;
    private float mOuterRadius;
    private TargetDrawable mOuterRing;
    private android.animation.Animator.AnimatorListener mResetListener = new AnimatorListenerAdapter() {

        public void onAnimationEnd(Animator animator) {
            switchToState(0, mWaveCenterX, mWaveCenterY);
            dispatchOnFinishFinalAnimation();
        }

        final MultiWaveView this$0;

             {
                this$0 = MultiWaveView.this;
                super();
            }
    };
    private android.animation.Animator.AnimatorListener mResetListenerWithPing = new AnimatorListenerAdapter() {

        public void onAnimationEnd(Animator animator) {
            ping();
            switchToState(0, mWaveCenterX, mWaveCenterY);
            dispatchOnFinishFinalAnimation();
        }

        final MultiWaveView this$0;

             {
                this$0 = MultiWaveView.this;
                super();
            }
    };
    private float mSnapMargin;
    private float mTapRadius;
    private AnimationBundle mTargetAnimations;
    private ArrayList mTargetDescriptions;
    private int mTargetDescriptionsResourceId;
    private ArrayList mTargetDrawables;
    private int mTargetResourceId;
    private android.animation.Animator.AnimatorListener mTargetUpdateListener = new AnimatorListenerAdapter() {

        public void onAnimationEnd(Animator animator) {
            if(mNewTargetResources != 0) {
                internalSetTargetResources(mNewTargetResources);
                mNewTargetResources = 0;
                hideTargets(false, false);
            }
            mAnimatingTargets = false;
        }

        final MultiWaveView this$0;

             {
                this$0 = MultiWaveView.this;
                super();
            }
    };
    private android.animation.ValueAnimator.AnimatorUpdateListener mUpdateListener = new android.animation.ValueAnimator.AnimatorUpdateListener() {

        public void onAnimationUpdate(ValueAnimator valueanimator) {
            invalidateGlobalRegion(mHandleDrawable);
            invalidate();
        }

        final MultiWaveView this$0;

             {
                this$0 = MultiWaveView.this;
                super();
            }
    };
    private int mVerticalInset;
    private int mVibrationDuration;
    private Vibrator mVibrator;
    private float mWaveCenterX;
    private float mWaveCenterY;








/*
    static int access$602(MultiWaveView multiwaveview, int i) {
        multiwaveview.mNewTargetResources = i;
        return i;
    }

*/




/*
    static boolean access$902(MultiWaveView multiwaveview, boolean flag) {
        multiwaveview.mAnimatingTargets = flag;
        return flag;
    }

*/
}
