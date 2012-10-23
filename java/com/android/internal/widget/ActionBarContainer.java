// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.*;
import android.widget.FrameLayout;

// Referenced classes of package com.android.internal.widget:
//            ActionBarView, ScrollingTabContainerView

public class ActionBarContainer extends FrameLayout {

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeset) {
        boolean flag;
        flag = true;
        super(context, attributeset);
        setBackgroundDrawable(null);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.ActionBar);
        mBackground = typedarray.getDrawable(2);
        mStackedBackground = typedarray.getDrawable(17);
        if(getId() == 0x102031c) {
            mIsSplit = flag;
            mSplitBackground = typedarray.getDrawable(18);
        }
        typedarray.recycle();
        if(!mIsSplit) goto _L2; else goto _L1
_L1:
        if(mSplitBackground != null)
            flag = false;
_L4:
        setWillNotDraw(flag);
        return;
_L2:
        if(mBackground != null || mStackedBackground != null)
            flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public View getTabContainer() {
        return mTabContainer;
    }

    public void onDraw(Canvas canvas) {
        if(getWidth() != 0 && getHeight() != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(mIsSplit) {
            if(mSplitBackground != null)
                mSplitBackground.draw(canvas);
        } else {
            if(mBackground != null)
                mBackground.draw(canvas);
            if(mStackedBackground != null && mIsStacked)
                mStackedBackground.draw(canvas);
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        mActionBarView = (ActionBarView)findViewById(0x102031a);
    }

    public boolean onHoverEvent(MotionEvent motionevent) {
        super.onHoverEvent(motionevent);
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent) {
        boolean flag;
        if(mIsTransitioning || super.onInterceptTouchEvent(motionevent))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void onLayout(boolean flag, int i, int j, int k, int l) {
        boolean flag1;
        int i1;
        int j1;
        View view;
        super.onLayout(flag, i, j, k, l);
        int k1;
        int l1;
        if(mTabContainer != null && mTabContainer.getVisibility() != 8)
            flag1 = true;
        else
            flag1 = false;
        if(mTabContainer == null || mTabContainer.getVisibility() == 8)
            break MISSING_BLOCK_LABEL_157;
        i1 = getMeasuredHeight();
        j1 = mTabContainer.getMeasuredHeight();
        if((2 & mActionBarView.getDisplayOptions()) != 0)
            break MISSING_BLOCK_LABEL_204;
        k1 = getChildCount();
        l1 = 0;
        if(l1 >= k1)
            break; /* Loop/switch isn't completed */
        view = getChildAt(l1);
        if(view != mTabContainer && !mActionBarView.isCollapsed())
            view.offsetTopAndBottom(j1);
        l1++;
        if(true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_88;
_L1:
        mTabContainer.layout(i, 0, k, j1);
_L3:
        boolean flag2 = false;
        if(mIsSplit) {
            if(mSplitBackground != null) {
                mSplitBackground.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
                flag2 = true;
            }
        } else {
            if(mBackground != null) {
                mBackground.setBounds(mActionBarView.getLeft(), mActionBarView.getTop(), mActionBarView.getRight(), mActionBarView.getBottom());
                flag2 = true;
            }
            boolean flag3;
            if(flag1 && mStackedBackground != null)
                flag3 = true;
            else
                flag3 = false;
            mIsStacked = flag3;
            if(flag3) {
                if(mBackground != null && mActionBarView.getHeight() == 0) {
                    mBackground.setBounds(mTabContainer.getLeft(), mTabContainer.getTop(), mTabContainer.getRight(), mTabContainer.getBottom());
                    mIsStacked = false;
                } else {
                    mStackedBackground.setBounds(mTabContainer.getLeft(), mTabContainer.getTop(), mTabContainer.getRight(), mTabContainer.getBottom());
                }
                flag2 = true;
            }
        }
        if(flag2)
            invalidate();
        return;
        mTabContainer.layout(i, i1 - j1, k, i1);
          goto _L3
    }

    public void onMeasure(int i, int j) {
        super.onMeasure(i, j);
        if(mActionBarView != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)mActionBarView.getLayoutParams();
        int k;
        if(mActionBarView.isCollapsed())
            k = 0;
        else
            k = mActionBarView.getMeasuredHeight() + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).topMargin + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).bottomMargin;
        if(mTabContainer != null && mTabContainer.getVisibility() != 8 && android.view.View.MeasureSpec.getMode(j) == 0x80000000) {
            int l = android.view.View.MeasureSpec.getSize(j);
            setMeasuredDimension(getMeasuredWidth(), Math.min(k + mTabContainer.getMeasuredHeight(), l));
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
        super.onTouchEvent(motionevent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        mBackground = drawable;
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        mSplitBackground = drawable;
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        mStackedBackground = drawable;
        invalidate();
    }

    public void setTabContainer(ScrollingTabContainerView scrollingtabcontainerview) {
        if(mTabContainer != null)
            removeView(mTabContainer);
        mTabContainer = scrollingtabcontainerview;
        if(scrollingtabcontainerview != null) {
            addView(scrollingtabcontainerview);
            android.view.ViewGroup.LayoutParams layoutparams = scrollingtabcontainerview.getLayoutParams();
            layoutparams.width = -1;
            layoutparams.height = -2;
            scrollingtabcontainerview.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean flag) {
        mIsTransitioning = flag;
        int i;
        if(flag)
            i = 0x60000;
        else
            i = 0x40000;
        setDescendantFocusability(i);
    }

    public ActionMode startActionModeForChild(View view, android.view.ActionMode.Callback callback) {
        return null;
    }

    private ActionBarView mActionBarView;
    private Drawable mBackground;
    private boolean mIsSplit;
    private boolean mIsStacked;
    private boolean mIsTransitioning;
    private Drawable mSplitBackground;
    private Drawable mStackedBackground;
    private View mTabContainer;
}
