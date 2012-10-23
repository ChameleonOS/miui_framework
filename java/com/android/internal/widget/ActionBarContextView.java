// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget;

import android.animation.*;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.*;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.internal.view.menu.*;

// Referenced classes of package com.android.internal.widget:
//            AbsActionBarView, ActionBarContainer

public class ActionBarContextView extends AbsActionBarView
    implements android.animation.Animator.AnimatorListener {

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0x1010394);
    }

    public ActionBarContextView(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.ActionMode, i, 0);
        setBackgroundDrawable(typedarray.getDrawable(0));
        mTitleStyleRes = typedarray.getResourceId(2, 0);
        mSubtitleStyleRes = typedarray.getResourceId(3, 0);
        super.mContentHeight = typedarray.getLayoutDimension(1, 0);
        mSplitBackground = typedarray.getDrawable(4);
        typedarray.recycle();
    }

    private void finishAnimation() {
        Animator animator = mCurrentAnimation;
        if(animator != null) {
            mCurrentAnimation = null;
            animator.end();
        }
    }

    private void initTitle() {
        byte byte0 = 8;
        if(mTitleLayout == null) {
            LayoutInflater.from(getContext()).inflate(0x1090019, this);
            mTitleLayout = (LinearLayout)getChildAt(-1 + getChildCount());
            mTitleView = (TextView)mTitleLayout.findViewById(0x1020242);
            mSubtitleView = (TextView)mTitleLayout.findViewById(0x1020243);
            if(mTitleStyleRes != 0)
                mTitleView.setTextAppearance(super.mContext, mTitleStyleRes);
            if(mSubtitleStyleRes != 0)
                mSubtitleView.setTextAppearance(super.mContext, mSubtitleStyleRes);
        }
        mTitleView.setText(mTitle);
        mSubtitleView.setText(mSubtitle);
        boolean flag;
        boolean flag1;
        TextView textview;
        int i;
        LinearLayout linearlayout;
        if(!TextUtils.isEmpty(mTitle))
            flag = true;
        else
            flag = false;
        if(!TextUtils.isEmpty(mSubtitle))
            flag1 = true;
        else
            flag1 = false;
        textview = mSubtitleView;
        if(flag1)
            i = 0;
        else
            i = byte0;
        textview.setVisibility(i);
        linearlayout = mTitleLayout;
        if(flag || flag1)
            byte0 = 0;
        linearlayout.setVisibility(byte0);
        if(mTitleLayout.getParent() == null)
            addView(mTitleLayout);
    }

    private Animator makeInAnimation() {
        mClose.setTranslationX(-mClose.getWidth() - ((android.view.ViewGroup.MarginLayoutParams)mClose.getLayoutParams()).leftMargin);
        View view = mClose;
        float af[] = new float[1];
        af[0] = 0.0F;
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(view, "translationX", af);
        objectanimator.setDuration(200L);
        objectanimator.addListener(this);
        objectanimator.setInterpolator(new DecelerateInterpolator());
        AnimatorSet animatorset = new AnimatorSet();
        android.animation.AnimatorSet.Builder builder = animatorset.play(objectanimator);
        if(super.mMenuView != null) {
            int i = super.mMenuView.getChildCount();
            if(i > 0) {
                int j = i - 1;
                for(int k = 0; j >= 0; k++) {
                    View view1 = super.mMenuView.getChildAt(j);
                    view1.setScaleY(0.0F);
                    float af1[] = new float[2];
                    af1[0] = 0.0F;
                    af1[1] = 1.0F;
                    ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(view1, "scaleY", af1);
                    objectanimator1.setDuration(300L);
                    builder.with(objectanimator1);
                    j--;
                }

            }
        }
        return animatorset;
    }

    private Animator makeOutAnimation() {
        View view = mClose;
        float af[] = new float[1];
        af[0] = -mClose.getWidth() - ((android.view.ViewGroup.MarginLayoutParams)mClose.getLayoutParams()).leftMargin;
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(view, "translationX", af);
        objectanimator.setDuration(200L);
        objectanimator.addListener(this);
        objectanimator.setInterpolator(new DecelerateInterpolator());
        AnimatorSet animatorset = new AnimatorSet();
        android.animation.AnimatorSet.Builder builder = animatorset.play(objectanimator);
        if(super.mMenuView != null && super.mMenuView.getChildCount() > 0) {
            for(int i = 0; i < 0; i++) {
                View view1 = super.mMenuView.getChildAt(i);
                view1.setScaleY(0.0F);
                float af1[] = new float[1];
                af1[0] = 0.0F;
                ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(view1, "scaleY", af1);
                objectanimator1.setDuration(300L);
                builder.with(objectanimator1);
            }

        }
        return animatorset;
    }

    public void closeMode() {
        if(mAnimationMode != 2)
            if(mClose == null) {
                killMode();
            } else {
                finishAnimation();
                mAnimationMode = 2;
                mCurrentAnimation = makeOutAnimation();
                mCurrentAnimation.start();
            }
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new android.view.ViewGroup.MarginLayoutParams(-1, -2);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset) {
        return new android.view.ViewGroup.MarginLayoutParams(getContext(), attributeset);
    }

    public CharSequence getSubtitle() {
        return mSubtitle;
    }

    public CharSequence getTitle() {
        return mTitle;
    }

    public boolean hideOverflowMenu() {
        boolean flag;
        if(super.mActionMenuPresenter != null)
            flag = super.mActionMenuPresenter.hideOverflowMenu();
        else
            flag = false;
        return flag;
    }

    public void initForMode(final ActionMode mode) {
        MenuBuilder menubuilder;
        android.view.ViewGroup.LayoutParams layoutparams;
        if(mClose == null) {
            mClose = LayoutInflater.from(super.mContext).inflate(0x109001d, this, false);
            addView(mClose);
        } else
        if(mClose.getParent() == null)
            addView(mClose);
        mClose.findViewById(0x1020244).setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view) {
                mode.finish();
            }

            final ActionBarContextView this$0;
            final ActionMode val$mode;

             {
                this$0 = ActionBarContextView.this;
                mode = actionmode;
                super();
            }
        });
        menubuilder = (MenuBuilder)mode.getMenu();
        if(super.mActionMenuPresenter != null)
            super.mActionMenuPresenter.dismissPopupMenus();
        super.mActionMenuPresenter = new ActionMenuPresenter(super.mContext);
        super.mActionMenuPresenter.setReserveOverflow(true);
        layoutparams = new android.view.ViewGroup.LayoutParams(-2, -1);
        if(!super.mSplitActionBar) {
            menubuilder.addMenuPresenter(super.mActionMenuPresenter);
            super.mMenuView = (ActionMenuView)super.mActionMenuPresenter.getMenuView(this);
            super.mMenuView.setBackgroundDrawable(null);
            addView(super.mMenuView, layoutparams);
        } else {
            super.mActionMenuPresenter.setWidthLimit(getContext().getResources().getDisplayMetrics().widthPixels, true);
            super.mActionMenuPresenter.setItemLimit(0x7fffffff);
            layoutparams.width = -1;
            layoutparams.height = super.mContentHeight;
            menubuilder.addMenuPresenter(super.mActionMenuPresenter);
            super.mMenuView = (ActionMenuView)super.mActionMenuPresenter.getMenuView(this);
            super.mMenuView.setBackgroundDrawable(mSplitBackground);
            super.mSplitView.addView(super.mMenuView, layoutparams);
        }
        mAnimateInOnLayout = true;
    }

    public boolean isOverflowMenuShowing() {
        boolean flag;
        if(super.mActionMenuPresenter != null)
            flag = super.mActionMenuPresenter.isOverflowMenuShowing();
        else
            flag = false;
        return flag;
    }

    public boolean isTitleOptional() {
        return mTitleOptional;
    }

    public void killMode() {
        finishAnimation();
        removeAllViews();
        if(super.mSplitView != null)
            super.mSplitView.removeView(super.mMenuView);
        mCustomView = null;
        super.mMenuView = null;
        mAnimateInOnLayout = false;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        if(mAnimationMode == 2)
            killMode();
        mAnimationMode = 0;
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if(super.mActionMenuPresenter != null) {
            super.mActionMenuPresenter.hideOverflowMenu();
            super.mActionMenuPresenter.hideSubMenus();
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        if(accessibilityevent.getEventType() == 32) {
            accessibilityevent.setSource(this);
            accessibilityevent.setClassName(getClass().getName());
            accessibilityevent.setPackageName(getContext().getPackageName());
            accessibilityevent.setContentDescription(mTitle);
        } else {
            super.onInitializeAccessibilityEvent(accessibilityevent);
        }
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l) {
        int i1 = getPaddingLeft();
        int j1 = getPaddingTop();
        int k1 = l - j - getPaddingTop() - getPaddingBottom();
        if(mClose != null && mClose.getVisibility() != 8) {
            android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)mClose.getLayoutParams();
            int i2 = i1 + marginlayoutparams.leftMargin;
            i1 = i2 + positionChild(mClose, i2, j1, k1) + marginlayoutparams.rightMargin;
            if(mAnimateInOnLayout) {
                mAnimationMode = 1;
                mCurrentAnimation = makeInAnimation();
                mCurrentAnimation.start();
                mAnimateInOnLayout = false;
            }
        }
        if(mTitleLayout != null && mCustomView == null && mTitleLayout.getVisibility() != 8)
            i1 += positionChild(mTitleLayout, i1, j1, k1);
        if(mCustomView != null) {
            int _tmp = i1 + positionChild(mCustomView, i1, j1, k1);
        }
        int l1 = k - i - getPaddingRight();
        if(super.mMenuView != null) {
            int _tmp1 = l1 - positionChildInverse(super.mMenuView, l1, j1, k1);
        }
    }

    protected void onMeasure(int i, int j) {
        if(android.view.View.MeasureSpec.getMode(i) != 0x40000000)
            throw new IllegalStateException((new StringBuilder()).append(getClass().getSimpleName()).append(" can only be used ").append("with android:layout_width=\"match_parent\" (or fill_parent)").toString());
        if(android.view.View.MeasureSpec.getMode(j) == 0)
            throw new IllegalStateException((new StringBuilder()).append(getClass().getSimpleName()).append(" can only be used ").append("with android:layout_height=\"wrap_content\"").toString());
        int k = android.view.View.MeasureSpec.getSize(i);
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        if(super.mContentHeight > 0)
            l = super.mContentHeight;
        else
            l = android.view.View.MeasureSpec.getSize(j);
        i1 = getPaddingTop() + getPaddingBottom();
        j1 = k - getPaddingLeft() - getPaddingRight();
        k1 = l - i1;
        l1 = android.view.View.MeasureSpec.makeMeasureSpec(k1, 0x80000000);
        if(mClose != null) {
            int l4 = measureChildView(mClose, j1, l1, 0);
            android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)mClose.getLayoutParams();
            j1 = l4 - (marginlayoutparams.leftMargin + marginlayoutparams.rightMargin);
        }
        if(super.mMenuView != null && super.mMenuView.getParent() == this)
            j1 = measureChildView(super.mMenuView, j1, l1, 0);
        if(mTitleLayout != null && mCustomView == null)
            if(mTitleOptional) {
                int i4 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
                mTitleLayout.measure(i4, l1);
                int j4 = mTitleLayout.getMeasuredWidth();
                int j2;
                int k2;
                int l2;
                android.view.ViewGroup.LayoutParams layoutparams;
                boolean flag;
                LinearLayout linearlayout;
                int k4;
                if(j4 <= j1)
                    flag = true;
                else
                    flag = false;
                if(flag)
                    j1 -= j4;
                linearlayout = mTitleLayout;
                if(flag)
                    k4 = 0;
                else
                    k4 = 8;
                linearlayout.setVisibility(k4);
            } else {
                j1 = measureChildView(mTitleLayout, j1, l1, 0);
            }
        if(mCustomView != null) {
            layoutparams = mCustomView.getLayoutParams();
            int i3;
            int j3;
            int k3;
            int l3;
            if(layoutparams.width != -2)
                i3 = 0x40000000;
            else
                i3 = 0x80000000;
            if(layoutparams.width >= 0)
                j3 = Math.min(layoutparams.width, j1);
            else
                j3 = j1;
            if(layoutparams.height != -2)
                k3 = 0x40000000;
            else
                k3 = 0x80000000;
            if(layoutparams.height >= 0)
                l3 = Math.min(layoutparams.height, k1);
            else
                l3 = k1;
            mCustomView.measure(android.view.View.MeasureSpec.makeMeasureSpec(j3, i3), android.view.View.MeasureSpec.makeMeasureSpec(l3, k3));
        }
        if(super.mContentHeight <= 0) {
            int i2 = 0;
            j2 = getChildCount();
            for(k2 = 0; k2 < j2; k2++) {
                l2 = i1 + getChildAt(k2).getMeasuredHeight();
                if(l2 > i2)
                    i2 = l2;
            }

            setMeasuredDimension(k, i2);
        } else {
            setMeasuredDimension(k, l);
        }
    }

    public void setContentHeight(int i) {
        super.mContentHeight = i;
    }

    public void setCustomView(View view) {
        if(mCustomView != null)
            removeView(mCustomView);
        mCustomView = view;
        if(mTitleLayout != null) {
            removeView(mTitleLayout);
            mTitleLayout = null;
        }
        if(view != null)
            addView(view);
        requestLayout();
    }

    public void setSplitActionBar(boolean flag) {
        if(super.mSplitActionBar != flag) {
            if(super.mActionMenuPresenter != null) {
                android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams(-2, -1);
                if(!flag) {
                    super.mMenuView = (ActionMenuView)super.mActionMenuPresenter.getMenuView(this);
                    super.mMenuView.setBackgroundDrawable(null);
                    ViewGroup viewgroup1 = (ViewGroup)super.mMenuView.getParent();
                    if(viewgroup1 != null)
                        viewgroup1.removeView(super.mMenuView);
                    addView(super.mMenuView, layoutparams);
                } else {
                    super.mActionMenuPresenter.setWidthLimit(getContext().getResources().getDisplayMetrics().widthPixels, true);
                    super.mActionMenuPresenter.setItemLimit(0x7fffffff);
                    layoutparams.width = -1;
                    layoutparams.height = super.mContentHeight;
                    super.mMenuView = (ActionMenuView)super.mActionMenuPresenter.getMenuView(this);
                    super.mMenuView.setBackgroundDrawable(mSplitBackground);
                    ViewGroup viewgroup = (ViewGroup)super.mMenuView.getParent();
                    if(viewgroup != null)
                        viewgroup.removeView(super.mMenuView);
                    super.mSplitView.addView(super.mMenuView, layoutparams);
                }
            }
            super.setSplitActionBar(flag);
        }
    }

    public void setSubtitle(CharSequence charsequence) {
        mSubtitle = charsequence;
        initTitle();
    }

    public void setTitle(CharSequence charsequence) {
        mTitle = charsequence;
        initTitle();
    }

    public void setTitleOptional(boolean flag) {
        if(flag != mTitleOptional)
            requestLayout();
        mTitleOptional = flag;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean showOverflowMenu() {
        boolean flag;
        if(super.mActionMenuPresenter != null)
            flag = super.mActionMenuPresenter.showOverflowMenu();
        else
            flag = false;
        return flag;
    }

    private static final int ANIMATE_IDLE = 0;
    private static final int ANIMATE_IN = 1;
    private static final int ANIMATE_OUT = 2;
    private static final String TAG = "ActionBarContextView";
    private boolean mAnimateInOnLayout;
    private int mAnimationMode;
    private View mClose;
    private Animator mCurrentAnimation;
    private View mCustomView;
    private Drawable mSplitBackground;
    private CharSequence mSubtitle;
    private int mSubtitleStyleRes;
    private TextView mSubtitleView;
    private CharSequence mTitle;
    private LinearLayout mTitleLayout;
    private boolean mTitleOptional;
    private int mTitleStyleRes;
    private TextView mTitleView;
}
