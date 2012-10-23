// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget;

import android.animation.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.*;
import android.view.View;
import android.view.ViewGroup;

public class SizeAdaptiveLayout extends ViewGroup {
    class BringToFrontOnEnd
        implements android.animation.Animator.AnimatorListener {

        public void onAnimationCancel(Animator animator) {
            int i = 
// JavaClassFileOutputException: get_constant: invalid tag

        public void onAnimationEnd(Animator animator) {
            if(mCanceledAnimationCount == 0) {
                mLeavingView.setVisibility(8);
                mModestyPanel.setVisibility(8);
                mEnteringView.bringToFront();
                mEnteringView = null;
                mLeavingView = null;
            } else {
                int i = 
// JavaClassFileOutputException: get_constant: invalid tag

        public void onAnimationRepeat(Animator animator) {
            if(!$assertionsDisabled)
                throw new AssertionError();
            else
                return;
        }

        public void onAnimationStart(Animator animator) {
        }

        static final boolean $assertionsDisabled;
        final SizeAdaptiveLayout this$0;

        static  {
            boolean flag;
            if(!com/android/internal/widget/SizeAdaptiveLayout.desiredAssertionStatus())
                flag = true;
            else
                flag = false;
            $assertionsDisabled = flag;
        }

        BringToFrontOnEnd() {
            this$0 = SizeAdaptiveLayout.this;
            super();
        }
    }

    public static class LayoutParams extends android.view.ViewGroup.LayoutParams {

        public String debug(String s) {
            return (new StringBuilder()).append(s).append("SizeAdaptiveLayout.LayoutParams={").append(", max=").append(maxHeight).append(", max=").append(minHeight).append("}").toString();
        }

        public static final int UNBOUNDED = -1;
        public int maxHeight;
        public int minHeight;

        public LayoutParams() {
            this(0, 0);
        }

        public LayoutParams(int i, int j) {
            this(i, j, -1, -1);
        }

        public LayoutParams(int i, int j, int k, int l) {
            super(i, j);
            minHeight = k;
            maxHeight = l;
        }

        public LayoutParams(Context context, AttributeSet attributeset) {
            super(context, attributeset);
            TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.SizeAdaptiveLayout_Layout);
            minHeight = typedarray.getDimensionPixelSize(1, 0);
            try {
                maxHeight = typedarray.getLayoutDimension(0, -1);
            }
            catch(Exception exception) { }
            typedarray.recycle();
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutparams) {
            super(layoutparams);
            minHeight = -1;
            maxHeight = -1;
        }
    }


    public SizeAdaptiveLayout(Context context) {
        ViewGroup(context);
        initialize();
    }

    public SizeAdaptiveLayout(Context context, AttributeSet attributeset) {
        ViewGroup(context, attributeset);
        initialize();
    }

    public SizeAdaptiveLayout(Context context, AttributeSet attributeset, int i) {
        ViewGroup(context, attributeset, i);
        initialize();
    }

    private int clampSizeToBounds(int i, View view) {
        LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
        int j = 0xffffff & i;
        int k = Math.max(j, layoutparams.minHeight);
        if(layoutparams.maxHeight != -1)
            k = Math.min(k, layoutparams.maxHeight);
        if(j != k)
            Log.d("SizeAdaptiveLayout", (new StringBuilder()).append(this).append("child view ").append(view).append(" ").append("measured out of bounds at ").append(j).append("px ").append("clamped to ").append(k).append("px").toString());
        return k;
    }

    private void initialize() {
        mModestyPanel = new View(getContext());
        android.graphics.drawable.Drawable drawable = getBackground();
        if(drawable instanceof StateListDrawable) {
            StateListDrawable statelistdrawable = (StateListDrawable)drawable;
            statelistdrawable.setState(StateSet.WILD_CARD);
            drawable = statelistdrawable.getCurrent();
        }
        LayoutParams layoutparams;
        View view;
        float af[];
        float af1[];
        if(drawable instanceof ColorDrawable)
            mModestyPanel.setBackgroundDrawable(drawable);
        else
            mModestyPanel.setBackgroundColor(0xff000000);
        layoutparams = new LayoutParams(-1, -1);
        mModestyPanel.setLayoutParams(layoutparams);
        addView(mModestyPanel);
        view = mModestyPanel;
        af = new float[1];
        af[0] = 0.0F;
        mFadePanel = ObjectAnimator.ofFloat(view, "alpha", af);
        af1 = new float[1];
        af1[0] = 0.0F;
        mFadeView = ObjectAnimator.ofFloat(null, "alpha", af1);
        mAnimatorListener = new BringToFrontOnEnd();
        mTransitionAnimation = new AnimatorSet();
        mTransitionAnimation.play(mFadeView).with(mFadePanel);
        mTransitionAnimation.setDuration(250L);
        mTransitionAnimation.addListener(mAnimatorListener);
    }

    private View selectActiveChild(int i) {
        int j;
        int k;
        View view;
        View view1;
        int l;
        View view2;
        int i1;
        int j1;
        j = android.view.View.MeasureSpec.getMode(i);
        k = android.view.View.MeasureSpec.getSize(i);
        view = null;
        view1 = null;
        l = 0;
        view2 = null;
        i1 = 0x7fffffff;
        j1 = 0;
_L3:
        if(j1 >= getChildCount()) goto _L2; else goto _L1
_L1:
        View view3;
        view3 = getChildAt(j1);
        if(view3 == mModestyPanel)
            continue; /* Loop/switch isn't completed */
        LayoutParams layoutparams = (LayoutParams)view3.getLayoutParams();
        if(layoutparams.maxHeight == -1 && view == null)
            view = view3;
        if(layoutparams.maxHeight > l) {
            l = layoutparams.maxHeight;
            view1 = view3;
        }
        if(layoutparams.minHeight < i1) {
            i1 = layoutparams.minHeight;
            view2 = view3;
        }
        if(j == 0 || k < layoutparams.minHeight || k > layoutparams.maxHeight)
            continue; /* Loop/switch isn't completed */
_L4:
        return view3;
        j1++;
          goto _L3
_L2:
        if(view != null)
            view1 = view;
        if(j == 0)
            view3 = view1;
        else
        if(k > l)
            view3 = view1;
        else
            view3 = view2;
          goto _L4
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams) {
        return layoutparams instanceof LayoutParams;
    }

    protected volatile android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public volatile android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset) {
        return generateLayoutParams(attributeset);
    }

    protected volatile android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams) {
        return generateLayoutParams(layoutparams);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeset) {
        return new LayoutParams(getContext(), attributeset);
    }

    protected LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams) {
        return new LayoutParams(layoutparams);
    }

    public View getModestyPanel() {
        return mModestyPanel;
    }

    public Animator getTransitionAnimation() {
        return mTransitionAnimation;
    }

    public void onAttachedToWindow() {
        mLastActive = null;
        for(int i = 0; i < getChildCount(); i++)
            getChildAt(i).setVisibility(8);

    }

    protected void onLayout(boolean flag, int i, int j, int k, int l) {
        mLastActive = mActiveChild;
        mActiveChild = selectActiveChild(android.view.View.MeasureSpec.makeMeasureSpec(l - j, 0x40000000));
        mActiveChild.setVisibility(0);
        if(mLastActive != mActiveChild && mLastActive != null) {
            mEnteringView = mActiveChild;
            mLeavingView = mLastActive;
            mEnteringView.setAlpha(1.0F);
            mModestyPanel.setAlpha(1.0F);
            mModestyPanel.bringToFront();
            mModestyPanelTop = mLeavingView.getHeight();
            mModestyPanel.setVisibility(0);
            mLeavingView.bringToFront();
            if(mTransitionAnimation.isRunning())
                mTransitionAnimation.cancel();
            mFadeView.setTarget(mLeavingView);
            ObjectAnimator objectanimator = mFadeView;
            float af[] = new float[1];
            af[0] = 0.0F;
            objectanimator.setFloatValues(af);
            ObjectAnimator objectanimator1 = mFadePanel;
            float af1[] = new float[1];
            af1[0] = 0.0F;
            objectanimator1.setFloatValues(af1);
            mTransitionAnimation.setupStartValues();
            mTransitionAnimation.start();
        }
        int i1 = mActiveChild.getMeasuredWidth();
        int j1 = mActiveChild.getMeasuredHeight();
        mActiveChild.layout(0, 0, i1 + 0, j1 + 0);
        mModestyPanel.layout(0, mModestyPanelTop, i1 + 0, j1 + mModestyPanelTop);
    }

    protected void onMeasure(int i, int j) {
        View view = selectActiveChild(j);
        LayoutParams _tmp = (LayoutParams)view.getLayoutParams();
        measureChild(view, i, j);
        int k = view.getMeasuredHeight();
        int l = view.getMeasuredHeight();
        int i1 = combineMeasuredStates(0, view.getMeasuredState());
        setMeasuredDimension(resolveSizeAndState(l, i, i1), clampSizeToBounds(resolveSizeAndState(k, j, i1), view));
    }

    private static final long CROSSFADE_TIME = 250L;
    private static final boolean DEBUG = false;
    private static final int MAX_VALID_HEIGHT = 0;
    private static final int MIN_VALID_HEIGHT = 1;
    private static final boolean REPORT_BAD_BOUNDS = true;
    private static final String TAG = "SizeAdaptiveLayout";
    private View mActiveChild;
    private android.animation.Animator.AnimatorListener mAnimatorListener;
    private int mCanceledAnimationCount;
    private View mEnteringView;
    private ObjectAnimator mFadePanel;
    private ObjectAnimator mFadeView;
    private View mLastActive;
    private View mLeavingView;
    private View mModestyPanel;
    private int mModestyPanelTop;
    private AnimatorSet mTransitionAnimation;



/*
    static int access$008(SizeAdaptiveLayout sizeadaptivelayout) {
        int i = sizeadaptivelayout.mCanceledAnimationCount;
        sizeadaptivelayout.mCanceledAnimationCount = i + 1;
        return i;
    }

*/


/*
    static int access$010(SizeAdaptiveLayout sizeadaptivelayout) {
        int i = sizeadaptivelayout.mCanceledAnimationCount;
        sizeadaptivelayout.mCanceledAnimationCount = i - 1;
        return i;
    }

*/



/*
    static View access$102(SizeAdaptiveLayout sizeadaptivelayout, View view) {
        sizeadaptivelayout.mLeavingView = view;
        return view;
    }

*/




/*
    static View access$302(SizeAdaptiveLayout sizeadaptivelayout, View view) {
        sizeadaptivelayout.mEnteringView = view;
        return view;
    }

*/
}
