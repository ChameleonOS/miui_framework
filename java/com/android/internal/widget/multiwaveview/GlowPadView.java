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
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.*;
import android.view.*;
import android.view.accessibility.AccessibilityManager;
import java.util.ArrayList;

// Referenced classes of package com.android.internal.widget.multiwaveview:
//            TargetDrawable, PointCloud, Tweener

public class GlowPadView extends View {
    class AnimationBundle extends ArrayList {

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
        final GlowPadView this$0;

        AnimationBundle() {
            this$0 = GlowPadView.this;
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


    public GlowPadView(Context context) {
        this(context, null);
    }

    public GlowPadView(Context context, AttributeSet attributeset) {
        boolean flag = true;
        super(context, attributeset);
        mTargetDrawables = new ArrayList();
        mWaveAnimations = new AnimationBundle();
        mTargetAnimations = new AnimationBundle();
        mGlowAnimations = new AnimationBundle();
        mFeedbackCount = 3;
        mVibrationDuration = 0;
        mActiveTarget = -1;
        mOuterRadius = 0.0F;
        mSnapMargin = 0.0F;
        mGravity = 48;
        mInitialLayout = flag;
        Resources resources = context.getResources();
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.GlowPadView);
        mInnerRadius = typedarray.getDimension(0, mInnerRadius);
        mOuterRadius = typedarray.getDimension(8, mOuterRadius);
        mSnapMargin = typedarray.getDimension(10, mSnapMargin);
        mVibrationDuration = typedarray.getInt(9, mVibrationDuration);
        mFeedbackCount = typedarray.getInt(11, mFeedbackCount);
        mHandleDrawable = new TargetDrawable(resources, typedarray.peekValue(7).resourceId);
        mHandleDrawable.setState(TargetDrawable.STATE_INACTIVE);
        mOuterRing = new TargetDrawable(resources, getResourceId(typedarray, 3));
        mAlwaysTrackFinger = typedarray.getBoolean(12, false);
        int i = getResourceId(typedarray, 4);
        android.graphics.drawable.Drawable drawable;
        TypedValue typedvalue;
        if(i != 0)
            drawable = resources.getDrawable(i);
        else
            drawable = null;
        mGlowRadius = typedarray.getDimension(5, 0.0F);
        typedvalue = new TypedValue();
        if(typedarray.getValue(6, typedvalue))
            internalSetTargetResources(typedvalue.resourceId);
        if(mTargetDrawables == null || mTargetDrawables.size() == 0)
            throw new IllegalStateException("Must specify at least one target drawable");
        if(typedarray.getValue(flag, typedvalue)) {
            int k = typedvalue.resourceId;
            if(k == 0)
                throw new IllegalStateException("Must specify target descriptions");
            setTargetDescriptionsResourceId(k);
        }
        if(typedarray.getValue(2, typedvalue)) {
            int j = typedvalue.resourceId;
            if(j == 0)
                throw new IllegalStateException("Must specify direction descriptions");
            setDirectionDescriptionsResourceId(j);
        }
        typedarray.recycle();
        TypedArray typedarray1 = context.obtainStyledAttributes(attributeset, android.R.styleable.LinearLayout);
        mGravity = typedarray1.getInt(0, 48);
        typedarray1.recycle();
        if(mVibrationDuration <= 0)
            flag = false;
        setVibrateEnabled(flag);
        assignDefaultsIfNeeded();
        mPointCloud = new PointCloud(drawable);
        mPointCloud.makePointCloud(mInnerRadius, mOuterRadius);
        mPointCloud.glowManager.setRadius(mGlowRadius);
    }

    private void assignDefaultsIfNeeded() {
        if(mOuterRadius == 0.0F)
            mOuterRadius = (float)Math.max(mOuterRing.getWidth(), mOuterRing.getHeight()) / 2.0F;
        if(mSnapMargin == 0.0F)
            mSnapMargin = TypedValue.applyDimension(1, 20F, getContext().getResources().getDisplayMetrics());
        if(mInnerRadius == 0.0F)
            mInnerRadius = (float)mHandleDrawable.getWidth() / 10F;
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

    private void dispatchOnFinishFinalAnimation() {
        if(mOnTriggerListener != null)
            mOnTriggerListener.onFinishFinalAnimation();
    }

    private void dump() {
        Log.v("GlowPadView", (new StringBuilder()).append("Outer Radius = ").append(mOuterRadius).toString());
        Log.v("GlowPadView", (new StringBuilder()).append("SnapMargin = ").append(mSnapMargin).toString());
        Log.v("GlowPadView", (new StringBuilder()).append("FeedbackCount = ").append(mFeedbackCount).toString());
        Log.v("GlowPadView", (new StringBuilder()).append("VibrationDuration = ").append(mVibrationDuration).toString());
        Log.v("GlowPadView", (new StringBuilder()).append("GlowRadius = ").append(mGlowRadius).toString());
        Log.v("GlowPadView", (new StringBuilder()).append("WaveCenterX = ").append(mWaveCenterX).toString());
        Log.v("GlowPadView", (new StringBuilder()).append("WaveCenterY = ").append(mWaveCenterY).toString());
    }

    private String getDirectionDescription(int i) {
        if(mDirectionDescriptions != null && !mDirectionDescriptions.isEmpty()) goto _L2; else goto _L1
_L1:
        mDirectionDescriptions = loadDescriptions(mDirectionDescriptionsResourceId);
        if(mTargetDrawables.size() == mDirectionDescriptions.size()) goto _L2; else goto _L3
_L3:
        String s;
        Log.w("GlowPadView", "The number of target drawables must be equal to the number of direction descriptions.");
        s = null;
_L5:
        return s;
_L2:
        s = (String)mDirectionDescriptions.get(i);
        if(true) goto _L5; else goto _L4
_L4:
    }

    private int getResourceId(TypedArray typedarray, int i) {
        TypedValue typedvalue = typedarray.peekValue(i);
        int j;
        if(typedvalue == null)
            j = 0;
        else
            j = typedvalue.resourceId;
        return j;
    }

    private float getScaledGlowRadiusSquared() {
        float f;
        if(AccessibilityManager.getInstance(super.mContext).isEnabled())
            f = 1.3F * mGlowRadius;
        else
            f = mGlowRadius;
        return square(f);
    }

    private void handleCancel(MotionEvent motionevent) {
        switchToState(5, motionevent.getX(), motionevent.getY());
    }

    private void handleDown(MotionEvent motionevent) {
        float f = motionevent.getX();
        float f1 = motionevent.getY();
        switchToState(1, f, f1);
        if(!trySwitchToFirstTouchState(f, f1))
            mDragging = false;
        else
            updateGlowPosition(f, f1);
    }

    private void handleUp(MotionEvent motionevent) {
        switchToState(5, motionevent.getX(), motionevent.getY());
    }

    private void hideGlow(int i, int j, float f, android.animation.Animator.AnimatorListener animatorlistener) {
        mGlowAnimations.cancel();
        AnimationBundle animationbundle = mGlowAnimations;
        PointCloud.GlowManager glowmanager = mPointCloud.glowManager;
        long l = i;
        Object aobj[] = new Object[14];
        aobj[0] = "ease";
        aobj[1] = Ease.Quart.easeOut;
        aobj[2] = "delay";
        aobj[3] = Integer.valueOf(j);
        aobj[4] = "alpha";
        aobj[5] = Float.valueOf(f);
        aobj[6] = "x";
        aobj[7] = Float.valueOf(0.0F);
        aobj[8] = "y";
        aobj[9] = Float.valueOf(0.0F);
        aobj[10] = "onUpdate";
        aobj[11] = mUpdateListener;
        aobj[12] = "onComplete";
        aobj[13] = animatorlistener;
        animationbundle.add(Tweener.to(glowmanager, l, aobj));
        mGlowAnimations.start();
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
        ArrayList arraylist = loadDrawableArray(i);
        mTargetDrawables = arraylist;
        mTargetResourceId = i;
        int j = mHandleDrawable.getWidth();
        int k = mHandleDrawable.getHeight();
        int l = arraylist.size();
        for(int i1 = 0; i1 < l; i1++) {
            TargetDrawable targetdrawable = (TargetDrawable)arraylist.get(i1);
            j = Math.max(j, targetdrawable.getWidth());
            k = Math.max(k, targetdrawable.getHeight());
        }

        if(mMaxTargetWidth != j || mMaxTargetHeight != k) {
            mMaxTargetWidth = j;
            mMaxTargetHeight = k;
            requestLayout();
        } else {
            updateTargetPositions(mWaveCenterX, mWaveCenterY);
            updatePointCloudPosition(mWaveCenterX, mWaveCenterY);
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

    private void showGlow(int i, int j, float f, android.animation.Animator.AnimatorListener animatorlistener) {
        mGlowAnimations.cancel();
        AnimationBundle animationbundle = mGlowAnimations;
        PointCloud.GlowManager glowmanager = mPointCloud.glowManager;
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
        animationbundle.add(Tweener.to(glowmanager, l, aobj));
        mGlowAnimations.start();
    }

    private float square(float f) {
        return f * f;
    }

    private void startBackgroundAnimation(int i, float f) {
        android.graphics.drawable.Drawable drawable = getBackground();
        if(mAlwaysTrackFinger && drawable != null) {
            if(mBackgroundAnimator != null)
                mBackgroundAnimator.animator.cancel();
            long l = i;
            Object aobj[] = new Object[6];
            aobj[0] = "ease";
            aobj[1] = Ease.Cubic.easeIn;
            aobj[2] = "alpha";
            aobj[3] = Integer.valueOf((int)(255F * f));
            aobj[4] = "delay";
            aobj[5] = Integer.valueOf(50);
            mBackgroundAnimator = Tweener.to(drawable, l, aobj);
            mBackgroundAnimator.animator.start();
        }
    }

    private void startWaveAnimation() {
        mWaveAnimations.cancel();
        mPointCloud.waveManager.setAlpha(1.0F);
        mPointCloud.waveManager.setRadius((float)mHandleDrawable.getWidth() / 2.0F);
        AnimationBundle animationbundle = mWaveAnimations;
        PointCloud.WaveManager wavemanager = mPointCloud.waveManager;
        Object aobj[] = new Object[10];
        aobj[0] = "ease";
        aobj[1] = Ease.Quad.easeOut;
        aobj[2] = "delay";
        aobj[3] = Integer.valueOf(0);
        aobj[4] = "radius";
        aobj[5] = Float.valueOf(2.0F * mOuterRadius);
        aobj[6] = "onUpdate";
        aobj[7] = mUpdateListener;
        aobj[8] = "onComplete";
        aobj[9] = new AnimatorListenerAdapter() {

            public void onAnimationEnd(Animator animator) {
                mPointCloud.waveManager.setRadius(0.0F);
                mPointCloud.waveManager.setAlpha(0.0F);
            }

            final GlowPadView this$0;

             {
                this$0 = GlowPadView.this;
                super();
            }
        };
        animationbundle.add(Tweener.to(wavemanager, 1350L, aobj));
        mWaveAnimations.start();
    }

    private void stopAndHideWaveAnimation() {
        mWaveAnimations.cancel();
        mPointCloud.waveManager.setAlpha(0.0F);
    }

    private void updateGlowPosition(float f, float f1) {
        mPointCloud.glowManager.setX(f);
        mPointCloud.glowManager.setY(f1);
    }

    private void updatePointCloudPosition(float f, float f1) {
        mPointCloud.setCenter(f, f1);
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

    void announceTargets() {
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
        }

        if(stringbuilder.length() > 0)
            announceForAccessibility(stringbuilder.toString());
    }

    void deactivateTargets() {
        int i = mTargetDrawables.size();
        for(int j = 0; j < i; j++)
            ((TargetDrawable)mTargetDrawables.get(j)).setState(TargetDrawable.STATE_INACTIVE);

        mActiveTarget = -1;
    }

    void dispatchTriggerEvent(int i) {
        vibrate();
        if(mOnTriggerListener != null)
            mOnTriggerListener.onTrigger(this, i);
    }

    float dist2(float f, float f1) {
        return f * f + f1 * f1;
    }

    void doFinish() {
        int i = mActiveTarget;
        boolean flag;
        if(i != -1)
            flag = true;
        else
            flag = false;
        if(flag) {
            highlightSelected(i);
            hideGlow(200, 1200, 0.0F, mResetListener);
            dispatchTriggerEvent(i);
            if(!mAlwaysTrackFinger)
                mTargetAnimations.stop();
        } else {
            hideGlow(200, 0, 0.0F, mResetListenerWithPing);
            hideTargets(true, false);
        }
        setGrabbedState(0);
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

    String getTargetDescription(int i) {
        if(mTargetDescriptions != null && !mTargetDescriptions.isEmpty()) goto _L2; else goto _L1
_L1:
        mTargetDescriptions = loadDescriptions(mTargetDescriptionsResourceId);
        if(mTargetDrawables.size() == mTargetDescriptions.size()) goto _L2; else goto _L3
_L3:
        String s;
        Log.w("GlowPadView", "The number of target drawables must be equal to the number of target descriptions.");
        s = null;
_L5:
        return s;
_L2:
        s = (String)mTargetDescriptions.get(i);
        if(true) goto _L5; else goto _L4
_L4:
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

    void handleMove(MotionEvent motionevent) {
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
                updateGlowPosition(f, f1);
            } else {
                switchToState(3, f, f1);
                updateGlowPosition(f, f1);
            }
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
                        announceForAccessibility(getTargetDescription(i));
                }
            }
            mActiveTarget = i;
        }
    }

    void hideTargets(boolean flag, boolean flag1) {
        mTargetAnimations.cancel();
        mAnimatingTargets = flag;
        int i;
        char c;
        float f;
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
        if(flag1)
            f = 1.0F;
        else
            f = 0.8F;
        j = mTargetDrawables.size();
        timeinterpolator = Ease.Cubic.easeOut;
        for(int k = 0; k < j; k++) {
            TargetDrawable targetdrawable1 = (TargetDrawable)mTargetDrawables.get(k);
            targetdrawable1.setState(TargetDrawable.STATE_INACTIVE);
            AnimationBundle animationbundle1 = mTargetAnimations;
            long l1 = i;
            Object aobj1[] = new Object[12];
            aobj1[0] = "ease";
            aobj1[1] = timeinterpolator;
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
        aobj[1] = timeinterpolator;
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

    protected void onDraw(Canvas canvas) {
        mPointCloud.draw(canvas);
        mOuterRing.draw(canvas);
        int i = mTargetDrawables.size();
        for(int j = 0; j < i; j++) {
            TargetDrawable targetdrawable = (TargetDrawable)mTargetDrawables.get(j);
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
            stopAndHideWaveAnimation();
            hideTargets(false, false);
            mInitialLayout = false;
        }
        mOuterRing.setPositionX(f2);
        mOuterRing.setPositionY(f3);
        mHandleDrawable.setPositionX(f2);
        mHandleDrawable.setPositionY(f3);
        updateTargetPositions(f2, f3);
        updatePointCloudPosition(f2, f3);
        updateGlowPosition(f2, f3);
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
    //                   1 79
    //                   2 69
    //                   3 94;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_94;
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
        handleMove(motionevent);
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
        if(mFeedbackCount > 0) {
            boolean flag = true;
            AnimationBundle animationbundle = mWaveAnimations;
            if(animationbundle.size() > 0 && ((Tweener)animationbundle.get(0)).animator.isRunning() && ((Tweener)animationbundle.get(0)).animator.getCurrentPlayTime() < 675L)
                flag = false;
            if(flag)
                startWaveAnimation();
        }
    }

    public boolean replaceTargetDrawablesIfPresent(ComponentName componentname, String s, int i) {
        if(i != 0) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = false;
        if(componentname == null)
            break MISSING_BLOCK_LABEL_77;
        boolean flag1;
        PackageManager packagemanager = super.mContext.getPackageManager();
        Bundle bundle = ((PackageItemInfo) (packagemanager.getActivityInfo(componentname, 128))).metaData;
        if(bundle == null)
            break MISSING_BLOCK_LABEL_77;
        int j = bundle.getInt(s);
        if(j == 0)
            break MISSING_BLOCK_LABEL_77;
        flag1 = replaceTargetDrawables(packagemanager.getResourcesForActivity(componentname), i, j);
        flag = flag1;
_L5:
        if(!flag)
            replaceTargetDrawables(super.mContext.getResources(), i, i);
        if(true) goto _L4; else goto _L3
_L3:
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        Log.w("GlowPadView", (new StringBuilder()).append("Failed to swap drawable; ").append(componentname.flattenToShortString()).append(" not found").toString(), namenotfoundexception);
          goto _L5
        android.content.res.Resources.NotFoundException notfoundexception;
        notfoundexception;
        Log.w("GlowPadView", (new StringBuilder()).append("Failed to swap drawable from ").append(componentname.flattenToShortString()).toString(), notfoundexception);
          goto _L5
    }

    public void reset(boolean flag) {
        mGlowAnimations.stop();
        mTargetAnimations.stop();
        startBackgroundAnimation(0, 0.0F);
        stopAndHideWaveAnimation();
        hideTargets(flag, false);
        hideGlow(0, 0, 1.0F, null);
        Tweener.reset();
    }

    public void resumeAnimations() {
        mWaveAnimations.setSuspended(false);
        mTargetAnimations.setSuspended(false);
        mGlowAnimations.setSuspended(false);
        mWaveAnimations.start();
        mTargetAnimations.start();
        mGlowAnimations.start();
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

    void setGrabbedState(int i) {
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

    void showTargets(boolean flag) {
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

    public void suspendAnimations() {
        mWaveAnimations.setSuspended(true);
        mTargetAnimations.setSuspended(true);
        mGlowAnimations.setSuspended(true);
    }

    void switchToState(int i, float f, float f1) {
        i;
        JVM INSTR tableswitch 0 5: default 40
    //                   0 41
    //                   1 80
    //                   2 89
    //                   3 139
    //                   4 158
    //                   5 177;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        return;
_L2:
        deactivateTargets();
        hideGlow(0, 0, 0.0F, null);
        startBackgroundAnimation(0, 0.0F);
        mHandleDrawable.setState(TargetDrawable.STATE_INACTIVE);
        mHandleDrawable.setAlpha(1.0F);
        continue; /* Loop/switch isn't completed */
_L3:
        startBackgroundAnimation(0, 0.0F);
        continue; /* Loop/switch isn't completed */
_L4:
        mHandleDrawable.setAlpha(0.0F);
        deactivateTargets();
        showTargets(true);
        startBackgroundAnimation(200, 1.0F);
        setGrabbedState(1);
        if(AccessibilityManager.getInstance(super.mContext).isEnabled())
            announceTargets();
        continue; /* Loop/switch isn't completed */
_L5:
        mHandleDrawable.setAlpha(0.0F);
        showGlow(0, 0, 1.0F, null);
        continue; /* Loop/switch isn't completed */
_L6:
        mHandleDrawable.setAlpha(0.0F);
        showGlow(0, 0, 0.0F, null);
        continue; /* Loop/switch isn't completed */
_L7:
        doFinish();
        if(true) goto _L1; else goto _L8
_L8:
    }

    boolean trySwitchToFirstTouchState(float f, float f1) {
        boolean flag = true;
        float f2 = f - mWaveCenterX;
        float f3 = f1 - mWaveCenterY;
        if(mAlwaysTrackFinger || dist2(f2, f3) <= getScaledGlowRadiusSquared()) {
            switchToState(2, f, f1);
            updateGlowPosition(f2, f3);
            mDragging = flag;
        } else {
            flag = false;
        }
        return flag;
    }

    void vibrate() {
        if(mVibrator != null)
            mVibrator.vibrate(mVibrationDuration);
    }

    private static final boolean DEBUG = false;
    private static final int HIDE_ANIMATION_DELAY = 200;
    private static final int HIDE_ANIMATION_DURATION = 200;
    private static final int INITIAL_SHOW_HANDLE_DURATION = 200;
    private static final int RETURN_TO_HOME_DELAY = 1200;
    private static final int RETURN_TO_HOME_DURATION = 200;
    private static final int REVEAL_GLOW_DELAY = 0;
    private static final int REVEAL_GLOW_DURATION = 0;
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
    private static final String TAG = "GlowPadView";
    private static final float TAP_RADIUS_SCALE_ACCESSIBILITY_ENABLED = 1.3F;
    private static final float TARGET_SCALE_COLLAPSED = 0.8F;
    private static final float TARGET_SCALE_EXPANDED = 1F;
    private static final int WAVE_ANIMATION_DURATION = 1350;
    int mActiveTarget;
    private boolean mAlwaysTrackFinger;
    boolean mAnimatingTargets;
    private Tweener mBackgroundAnimator;
    private ArrayList mDirectionDescriptions;
    private int mDirectionDescriptionsResourceId;
    boolean mDragging;
    private int mFeedbackCount;
    private AnimationBundle mGlowAnimations;
    float mGlowRadius;
    private int mGrabbedState;
    private int mGravity;
    TargetDrawable mHandleDrawable;
    private int mHorizontalInset;
    private boolean mInitialLayout;
    private float mInnerRadius;
    private int mMaxTargetHeight;
    private int mMaxTargetWidth;
    private int mNewTargetResources;
    private OnTriggerListener mOnTriggerListener;
    float mOuterRadius;
    TargetDrawable mOuterRing;
    private PointCloud mPointCloud;
    android.animation.Animator.AnimatorListener mResetListener = new AnimatorListenerAdapter() {

        public void onAnimationEnd(Animator animator) {
            switchToState(0, mWaveCenterX, mWaveCenterY);
            dispatchOnFinishFinalAnimation();
        }

        final GlowPadView this$0;

             {
                this$0 = GlowPadView.this;
                super();
            }
    };
    android.animation.Animator.AnimatorListener mResetListenerWithPing = new AnimatorListenerAdapter() {

        public void onAnimationEnd(Animator animator) {
            ping();
            switchToState(0, mWaveCenterX, mWaveCenterY);
            dispatchOnFinishFinalAnimation();
        }

        final GlowPadView this$0;

             {
                this$0 = GlowPadView.this;
                super();
            }
    };
    float mSnapMargin;
    AnimationBundle mTargetAnimations;
    private ArrayList mTargetDescriptions;
    private int mTargetDescriptionsResourceId;
    ArrayList mTargetDrawables;
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

        final GlowPadView this$0;

             {
                this$0 = GlowPadView.this;
                super();
            }
    };
    android.animation.ValueAnimator.AnimatorUpdateListener mUpdateListener = new android.animation.ValueAnimator.AnimatorUpdateListener() {

        public void onAnimationUpdate(ValueAnimator valueanimator) {
            invalidate();
        }

        final GlowPadView this$0;

             {
                this$0 = GlowPadView.this;
                super();
            }
    };
    private int mVerticalInset;
    private int mVibrationDuration;
    private Vibrator mVibrator;
    private AnimationBundle mWaveAnimations;
    float mWaveCenterX;
    float mWaveCenterY;




/*
    static int access$102(GlowPadView glowpadview, int i) {
        glowpadview.mNewTargetResources = i;
        return i;
    }

*/


}
