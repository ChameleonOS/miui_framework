// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget;

import android.animation.*;
import android.content.Context;
import android.content.res.*;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import com.android.internal.view.menu.ActionMenuPresenter;
import com.android.internal.view.menu.ActionMenuView;

// Referenced classes of package com.android.internal.widget:
//            ActionBarContainer

public abstract class AbsActionBarView extends ViewGroup {
    protected class VisibilityAnimListener
        implements android.animation.Animator.AnimatorListener {

        public void onAnimationCancel(Animator animator) {
            mCanceled = true;
        }

        public void onAnimationEnd(Animator animator) {
            if(!mCanceled) goto _L2; else goto _L1
_L1:
            return;
_L2:
            mVisibilityAnim = null;
            setVisibility(mFinalVisibility);
            if(mSplitView != null && mMenuView != null)
                mMenuView.setVisibility(mFinalVisibility);
            if(true) goto _L1; else goto _L3
_L3:
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
            setVisibility(0);
            mVisibilityAnim = animator;
            mCanceled = false;
        }

        public VisibilityAnimListener withFinalVisibility(int i) {
            mFinalVisibility = i;
            return this;
        }

        private boolean mCanceled;
        int mFinalVisibility;
        final AbsActionBarView this$0;

        protected VisibilityAnimListener() {
            this$0 = AbsActionBarView.this;
            super();
            mCanceled = false;
        }
    }


    public AbsActionBarView(Context context) {
        super(context);
        mVisAnimListener = new VisibilityAnimListener();
    }

    public AbsActionBarView(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        mVisAnimListener = new VisibilityAnimListener();
    }

    public AbsActionBarView(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        mVisAnimListener = new VisibilityAnimListener();
    }

    public void animateToVisibility(int i) {
        if(mVisibilityAnim != null)
            mVisibilityAnim.cancel();
        if(i == 0) {
            if(getVisibility() != 0) {
                setAlpha(0.0F);
                if(mSplitView != null && mMenuView != null)
                    mMenuView.setAlpha(0.0F);
            }
            float af2[] = new float[1];
            af2[0] = 1.0F;
            ObjectAnimator objectanimator2 = ObjectAnimator.ofFloat(this, "alpha", af2);
            objectanimator2.setDuration(200L);
            objectanimator2.setInterpolator(sAlphaInterpolator);
            if(mSplitView != null && mMenuView != null) {
                AnimatorSet animatorset1 = new AnimatorSet();
                ActionMenuView actionmenuview1 = mMenuView;
                float af3[] = new float[1];
                af3[0] = 1.0F;
                ObjectAnimator objectanimator3 = ObjectAnimator.ofFloat(actionmenuview1, "alpha", af3);
                objectanimator3.setDuration(200L);
                animatorset1.addListener(mVisAnimListener.withFinalVisibility(i));
                animatorset1.play(objectanimator2).with(objectanimator3);
                animatorset1.start();
            } else {
                objectanimator2.addListener(mVisAnimListener.withFinalVisibility(i));
                objectanimator2.start();
            }
        } else {
            float af[] = new float[1];
            af[0] = 0.0F;
            ObjectAnimator objectanimator = ObjectAnimator.ofFloat(this, "alpha", af);
            objectanimator.setDuration(200L);
            objectanimator.setInterpolator(sAlphaInterpolator);
            if(mSplitView != null && mMenuView != null) {
                AnimatorSet animatorset = new AnimatorSet();
                ActionMenuView actionmenuview = mMenuView;
                float af1[] = new float[1];
                af1[0] = 0.0F;
                ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(actionmenuview, "alpha", af1);
                objectanimator1.setDuration(200L);
                animatorset.addListener(mVisAnimListener.withFinalVisibility(i));
                animatorset.play(objectanimator).with(objectanimator1);
                animatorset.start();
            } else {
                objectanimator.addListener(mVisAnimListener.withFinalVisibility(i));
                objectanimator.start();
            }
        }
    }

    public void dismissPopupMenus() {
        if(mActionMenuPresenter != null)
            mActionMenuPresenter.dismissPopupMenus();
    }

    public int getAnimatedVisibility() {
        int i;
        if(mVisibilityAnim != null)
            i = mVisAnimListener.mFinalVisibility;
        else
            i = getVisibility();
        return i;
    }

    public int getContentHeight() {
        return mContentHeight;
    }

    public boolean hideOverflowMenu() {
        boolean flag;
        if(mActionMenuPresenter != null)
            flag = mActionMenuPresenter.hideOverflowMenu();
        else
            flag = false;
        return flag;
    }

    public boolean isOverflowMenuShowing() {
        boolean flag;
        if(mActionMenuPresenter != null)
            flag = mActionMenuPresenter.isOverflowMenuShowing();
        else
            flag = false;
        return flag;
    }

    public boolean isOverflowReserved() {
        boolean flag;
        if(mActionMenuPresenter != null && mActionMenuPresenter.isOverflowReserved())
            flag = true;
        else
            flag = false;
        return flag;
    }

    protected int measureChildView(View view, int i, int j, int k) {
        view.measure(android.view.View.MeasureSpec.makeMeasureSpec(i, 0x80000000), j);
        return Math.max(0, i - view.getMeasuredWidth() - k);
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedarray = getContext().obtainStyledAttributes(null, com.android.internal.R.styleable.ActionBar, 0x10102ce, 0);
        setContentHeight(typedarray.getLayoutDimension(4, 0));
        typedarray.recycle();
        if(mSplitWhenNarrow)
            setSplitActionBar(getContext().getResources().getBoolean(0x1110002));
        if(mActionMenuPresenter != null)
            mActionMenuPresenter.onConfigurationChanged(configuration);
    }

    protected int positionChild(View view, int i, int j, int k) {
        int l = view.getMeasuredWidth();
        int i1 = view.getMeasuredHeight();
        int j1 = j + (k - i1) / 2;
        view.layout(i, j1, i + l, j1 + i1);
        return l;
    }

    protected int positionChildInverse(View view, int i, int j, int k) {
        int l = view.getMeasuredWidth();
        int i1 = view.getMeasuredHeight();
        int j1 = j + (k - i1) / 2;
        view.layout(i - l, j1, i, j1 + i1);
        return l;
    }

    public void postShowOverflowMenu() {
        post(new Runnable() {

            public void run() {
                showOverflowMenu();
            }

            final AbsActionBarView this$0;

             {
                this$0 = AbsActionBarView.this;
                super();
            }
        });
    }

    public void setContentHeight(int i) {
        mContentHeight = i;
        requestLayout();
    }

    public void setSplitActionBar(boolean flag) {
        mSplitActionBar = flag;
    }

    public void setSplitView(ActionBarContainer actionbarcontainer) {
        mSplitView = actionbarcontainer;
    }

    public void setSplitWhenNarrow(boolean flag) {
        mSplitWhenNarrow = flag;
    }

    public void setVisibility(int i) {
        if(i != getVisibility()) {
            if(mVisibilityAnim != null)
                mVisibilityAnim.end();
            super.setVisibility(i);
        }
    }

    public boolean showOverflowMenu() {
        boolean flag;
        if(mActionMenuPresenter != null)
            flag = mActionMenuPresenter.showOverflowMenu();
        else
            flag = false;
        return flag;
    }

    private static final int FADE_DURATION = 200;
    private static final TimeInterpolator sAlphaInterpolator = new DecelerateInterpolator();
    protected ActionMenuPresenter mActionMenuPresenter;
    protected int mContentHeight;
    protected ActionMenuView mMenuView;
    protected boolean mSplitActionBar;
    protected ActionBarContainer mSplitView;
    protected boolean mSplitWhenNarrow;
    protected final VisibilityAnimListener mVisAnimListener;
    protected Animator mVisibilityAnim;

}
