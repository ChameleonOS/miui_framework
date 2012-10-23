// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view.menu;

import android.content.Context;
import android.content.res.*;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;

// Referenced classes of package com.android.internal.view.menu:
//            MenuView, ActionMenuItemView, MenuBuilder, ActionMenuPresenter, 
//            MenuItemImpl

public class ActionMenuView extends LinearLayout
    implements MenuBuilder.ItemInvoker, MenuView {
    public static class LayoutParams extends android.widget.LinearLayout.LayoutParams {

        public int cellsUsed;
        public boolean expandable;
        public boolean expanded;
        public int extraPixels;
        public boolean isOverflowButton;
        public boolean preventEdgeOffset;

        public LayoutParams(int i, int j) {
            super(i, j);
            isOverflowButton = false;
        }

        public LayoutParams(int i, int j, boolean flag) {
            super(i, j);
            isOverflowButton = flag;
        }

        public LayoutParams(Context context, AttributeSet attributeset) {
            super(context, attributeset);
        }

        public LayoutParams(LayoutParams layoutparams) {
            super(layoutparams);
            isOverflowButton = layoutparams.isOverflowButton;
        }
    }

    public static interface ActionMenuChildView {

        public abstract boolean needsDividerAfter();

        public abstract boolean needsDividerBefore();
    }


    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        mMinCellSize = (int)(56F * f);
        mGeneratedItemPadding = (int)(4F * f);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.ActionBar, 0x10102ce, 0);
        mMaxItemHeight = typedarray.getDimensionPixelSize(4, 0);
        typedarray.recycle();
    }

    static int measureChildForCells(View view, int i, int j, int k, int l) {
        LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
        int i1 = android.view.View.MeasureSpec.makeMeasureSpec(android.view.View.MeasureSpec.getSize(k) - l, android.view.View.MeasureSpec.getMode(k));
        ActionMenuItemView actionmenuitemview;
        boolean flag;
        int j1;
        boolean flag1;
        if(view instanceof ActionMenuItemView)
            actionmenuitemview = (ActionMenuItemView)view;
        else
            actionmenuitemview = null;
        if(actionmenuitemview != null && actionmenuitemview.hasText())
            flag = true;
        else
            flag = false;
        j1 = 0;
        if(j > 0 && (!flag || j >= 2)) {
            view.measure(android.view.View.MeasureSpec.makeMeasureSpec(i * j, 0x80000000), i1);
            int k1 = view.getMeasuredWidth();
            j1 = k1 / i;
            if(k1 % i != 0)
                j1++;
            if(flag && j1 < 2)
                j1 = 2;
        }
        if(!layoutparams.isOverflowButton && flag)
            flag1 = true;
        else
            flag1 = false;
        layoutparams.expandable = flag1;
        layoutparams.cellsUsed = j1;
        view.measure(android.view.View.MeasureSpec.makeMeasureSpec(j1 * i, 0x40000000), i1);
        return j1;
    }

    private void onMeasureExactFormat(int i, int j) {
        int k;
        int i1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        k = android.view.View.MeasureSpec.getMode(j);
        int l = android.view.View.MeasureSpec.getSize(i);
        i1 = android.view.View.MeasureSpec.getSize(j);
        int j1 = getPaddingLeft() + getPaddingRight();
        k1 = getPaddingTop() + getPaddingBottom();
        if(k == 0x40000000)
            l1 = android.view.View.MeasureSpec.makeMeasureSpec(i1 - k1, 0x40000000);
        else
            l1 = android.view.View.MeasureSpec.makeMeasureSpec(Math.min(mMaxItemHeight, i1 - k1), 0x80000000);
        i2 = l - j1;
        j2 = i2 / mMinCellSize;
        k2 = i2 % mMinCellSize;
        if(j2 != 0) goto _L2; else goto _L1
_L1:
        setMeasuredDimension(i2, 0);
_L4:
        return;
_L2:
        int l2;
        int i3;
        int j3;
        int j4;
        boolean flag2;
label0:
        {
            l2 = mMinCellSize + k2 / j2;
            i3 = j2;
            j3 = 0;
            int k3 = 0;
            int l3 = 0;
            int i4 = 0;
            boolean flag = false;
            long l4 = 0L;
            j4 = getChildCount();
            int k4 = 0;
            while(k4 < j4)  {
                View view3 = getChildAt(k4);
                if(view3.getVisibility() != 8) {
                    boolean flag4 = view3 instanceof ActionMenuItemView;
                    i4++;
                    if(flag4)
                        view3.setPadding(mGeneratedItemPadding, 0, mGeneratedItemPadding, 0);
                    LayoutParams layoutparams4 = (LayoutParams)view3.getLayoutParams();
                    layoutparams4.expanded = false;
                    layoutparams4.extraPixels = 0;
                    layoutparams4.cellsUsed = 0;
                    layoutparams4.expandable = false;
                    layoutparams4.leftMargin = 0;
                    layoutparams4.rightMargin = 0;
                    boolean flag5;
                    int k7;
                    int l7;
                    int i8;
                    if(flag4 && ((ActionMenuItemView)view3).hasText())
                        flag5 = true;
                    else
                        flag5 = false;
                    layoutparams4.preventEdgeOffset = flag5;
                    if(layoutparams4.isOverflowButton)
                        k7 = 1;
                    else
                        k7 = i3;
                    l7 = measureChildForCells(view3, l2, k7, l1, k1);
                    k3 = Math.max(k3, l7);
                    if(layoutparams4.expandable)
                        l3++;
                    if(layoutparams4.isOverflowButton)
                        flag = true;
                    i3 -= l7;
                    i8 = view3.getMeasuredHeight();
                    j3 = Math.max(j3, i8);
                    if(l7 == 1)
                        l4 |= 1 << k4;
                }
                k4++;
            }
            boolean flag1;
            if(flag && i4 == 2)
                flag1 = true;
            else
                flag1 = false;
            flag2 = false;
label1:
            do {
label2:
                {
                    int i6;
                    long l6;
                    if(l3 > 0 && i3 > 0) {
                        i6 = 0x7fffffff;
                        l6 = 0L;
                        int j6 = 0;
                        int k6 = 0;
                        while(k6 < j4)  {
                            LayoutParams layoutparams3 = (LayoutParams)getChildAt(k6).getLayoutParams();
                            if(layoutparams3.expandable)
                                if(layoutparams3.cellsUsed < i6) {
                                    i6 = layoutparams3.cellsUsed;
                                    l6 = 1 << k6;
                                    j6 = 1;
                                } else
                                if(layoutparams3.cellsUsed == i6) {
                                    l6 |= 1 << k6;
                                    j6++;
                                }
                            k6++;
                        }
                        l4 |= l6;
                        if(j6 <= i3)
                            break label2;
                    }
                    boolean flag3;
                    float f;
                    int j5;
                    int k5;
                    if(!flag && i4 == 1)
                        flag3 = true;
                    else
                        flag3 = false;
                    if(i3 <= 0 || l4 == 0L || i3 >= i4 - 1 && !flag3 && k3 <= 1)
                        break label0;
                    f = Long.bitCount(l4);
                    if(!flag3) {
                        if((1L & l4) != 0L && !((LayoutParams)getChildAt(0).getLayoutParams()).preventEdgeOffset)
                            f -= 0.5F;
                        if((l4 & (long)(1 << j4 - 1)) != 0L && !((LayoutParams)getChildAt(j4 - 1).getLayoutParams()).preventEdgeOffset)
                            f -= 0.5F;
                    }
                    if(f > 0.0F)
                        j5 = (int)((float)(i3 * l2) / f);
                    else
                        j5 = 0;
                    k5 = 0;
                    while(k5 < j4)  {
                        int i7;
                        int j7;
                        View view2;
                        LayoutParams layoutparams2;
                        if((l4 & (long)(1 << k5)) != 0L) {
                            View view1 = getChildAt(k5);
                            LayoutParams layoutparams1 = (LayoutParams)view1.getLayoutParams();
                            if(view1 instanceof ActionMenuItemView) {
                                layoutparams1.extraPixels = j5;
                                layoutparams1.expanded = true;
                                if(k5 == 0 && !layoutparams1.preventEdgeOffset)
                                    layoutparams1.leftMargin = -j5 / 2;
                                flag2 = true;
                            } else
                            if(layoutparams1.isOverflowButton) {
                                layoutparams1.extraPixels = j5;
                                layoutparams1.expanded = true;
                                layoutparams1.rightMargin = -j5 / 2;
                                flag2 = true;
                            } else {
                                if(k5 != 0)
                                    layoutparams1.leftMargin = j5 / 2;
                                int l5 = j4 - 1;
                                if(k5 != l5)
                                    layoutparams1.rightMargin = j5 / 2;
                            }
                        }
                        k5++;
                    }
                    break label1;
                }
                i7 = i6 + 1;
                j7 = 0;
                while(j7 < j4)  {
                    view2 = getChildAt(j7);
                    layoutparams2 = (LayoutParams)view2.getLayoutParams();
                    if((l6 & (long)(1 << j7)) == 0L) {
                        if(layoutparams2.cellsUsed == i7)
                            l4 |= 1 << j7;
                    } else {
                        if(flag1 && layoutparams2.preventEdgeOffset && i3 == 1)
                            view2.setPadding(l2 + mGeneratedItemPadding, 0, mGeneratedItemPadding, 0);
                        layoutparams2.cellsUsed = 1 + layoutparams2.cellsUsed;
                        layoutparams2.expanded = true;
                        i3--;
                    }
                    j7++;
                }
                flag2 = true;
            } while(true);
            i3 = 0;
        }
        if(flag2) {
            int i5 = 0;
            while(i5 < j4)  {
                View view = getChildAt(i5);
                LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
                if(layoutparams.expanded)
                    view.measure(android.view.View.MeasureSpec.makeMeasureSpec(l2 * layoutparams.cellsUsed + layoutparams.extraPixels, 0x40000000), l1);
                i5++;
            }
        }
        if(k != 0x40000000)
            i1 = j3;
        setMeasuredDimension(i2, i1);
        mMeasuredExtraWidth = i3 * l2;
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams) {
        boolean flag;
        if(layoutparams != null && (layoutparams instanceof LayoutParams))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        return false;
    }

    protected volatile android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    protected volatile android.widget.LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    protected LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutparams = new LayoutParams(-2, -2);
        layoutparams.gravity = 16;
        return layoutparams;
    }

    public volatile android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset) {
        return generateLayoutParams(attributeset);
    }

    protected volatile android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams) {
        return generateLayoutParams(layoutparams);
    }

    public volatile android.widget.LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeset) {
        return generateLayoutParams(attributeset);
    }

    protected volatile android.widget.LinearLayout.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams) {
        return generateLayoutParams(layoutparams);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeset) {
        return new LayoutParams(getContext(), attributeset);
    }

    protected LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams) {
        LayoutParams layoutparams1;
        if(layoutparams instanceof LayoutParams) {
            layoutparams1 = new LayoutParams((LayoutParams)layoutparams);
            if(((android.widget.LinearLayout.LayoutParams) (layoutparams1)).gravity <= 0)
                layoutparams1.gravity = 16;
        } else {
            layoutparams1 = generateDefaultLayoutParams();
        }
        return layoutparams1;
    }

    public LayoutParams generateOverflowButtonLayoutParams() {
        LayoutParams layoutparams = generateDefaultLayoutParams();
        layoutparams.isOverflowButton = true;
        return layoutparams;
    }

    public int getWindowAnimations() {
        return 0;
    }

    protected boolean hasDividerBeforeChildAt(int i) {
        View view = getChildAt(i - 1);
        View view1 = getChildAt(i);
        boolean flag = false;
        if(i < getChildCount() && (view instanceof ActionMenuChildView))
            flag = false | ((ActionMenuChildView)view).needsDividerAfter();
        if(i > 0 && (view1 instanceof ActionMenuChildView))
            flag |= ((ActionMenuChildView)view1).needsDividerBefore();
        return flag;
    }

    public void initialize(MenuBuilder menubuilder) {
        mMenu = menubuilder;
    }

    public boolean invokeItem(MenuItemImpl menuitemimpl) {
        return mMenu.performItemAction(menuitemimpl, 0);
    }

    public boolean isExpandedFormat() {
        return mFormatItems;
    }

    public boolean isOverflowReserved() {
        return mReserveOverflow;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        mPresenter.updateMenuView(false);
        if(mPresenter != null && mPresenter.isOverflowMenuShowing()) {
            mPresenter.hideOverflowMenu();
            mPresenter.showOverflowMenu();
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mPresenter.dismissPopupMenus();
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l) {
        if(mFormatItems) goto _L2; else goto _L1
_L1:
        super.onLayout(flag, i, j, k, l);
_L4:
        return;
_L2:
        int i1;
        int j1;
        int i2;
        int j2;
        boolean flag1;
        i1 = getChildCount();
        j1 = (j + l) / 2;
        int k1 = getDividerWidth();
        int l1 = 0;
        i2 = 0;
        j2 = k - i - getPaddingRight() - getPaddingLeft();
        flag1 = false;
        int k2 = 0;
        while(k2 < i1)  {
            View view2 = getChildAt(k2);
            if(view2.getVisibility() != 8) {
                LayoutParams layoutparams1 = (LayoutParams)view2.getLayoutParams();
                if(layoutparams1.isOverflowButton) {
                    int k6 = view2.getMeasuredWidth();
                    if(hasDividerBeforeChildAt(k2))
                        k6 += k1;
                    int l6 = view2.getMeasuredHeight();
                    int i7 = getWidth() - getPaddingRight() - ((android.view.ViewGroup.MarginLayoutParams) (layoutparams1)).rightMargin;
                    int j7 = i7 - k6;
                    int k7 = j1 - l6 / 2;
                    view2.layout(j7, k7, i7, k7 + l6);
                    j2 -= k6;
                    flag1 = true;
                } else {
                    int j6 = view2.getMeasuredWidth() + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams1)).leftMargin + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams1)).rightMargin;
                    l1 += j6;
                    j2 -= j6;
                    if(hasDividerBeforeChildAt(k2))
                        l1 += k1;
                    i2++;
                }
            }
            k2++;
        }
        if(i1 != 1 || flag1)
            break; /* Loop/switch isn't completed */
        View view1 = getChildAt(0);
        int j5 = view1.getMeasuredWidth();
        int k5 = view1.getMeasuredHeight();
        int l5 = j1 - k5 / 2;
        if((5 & ((android.widget.LinearLayout.LayoutParams) ((LayoutParams)view1.getLayoutParams())).gravity) != 0)
            view1.layout(k - j5, l5, k, l5 + k5);
        else
        if((3 & ((android.widget.LinearLayout.LayoutParams) ((LayoutParams)view1.getLayoutParams())).gravity) != 0) {
            view1.layout(i, l5, i + j5, l5 + k5);
        } else {
            int i6 = (k - i) / 2 - j5 / 2;
            view1.layout(i6, l5, i6 + j5, l5 + k5);
        }
        if(true) goto _L4; else goto _L3
_L3:
        int l2;
        int i3;
        int j3;
        int k3;
        int l3;
        int i4;
        if(flag1)
            l2 = 0;
        else
            l2 = 1;
        i3 = i2 - l2;
        if(i3 > 0)
            j3 = j2 / i3;
        else
            j3 = 0;
        k3 = Math.max(0, j3);
        l3 = getPaddingLeft();
        i4 = 0;
        while(i4 < i1)  {
            View view = getChildAt(i4);
            LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
            if(view.getVisibility() != 8 && !layoutparams.isOverflowButton) {
                int j4 = l3 + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).leftMargin;
                int k4 = view.getMeasuredWidth();
                int l4 = view.getMeasuredHeight();
                int i5 = j1 - l4 / 2;
                view.layout(j4, i5, j4 + k4, i5 + l4);
                l3 = j4 + (k3 + (k4 + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).rightMargin));
            }
            i4++;
        }
        if(true) goto _L4; else goto _L5
_L5:
    }

    protected void onMeasure(int i, int j) {
        boolean flag = mFormatItems;
        boolean flag1;
        int k;
        if(android.view.View.MeasureSpec.getMode(i) == 0x40000000)
            flag1 = true;
        else
            flag1 = false;
        mFormatItems = flag1;
        if(flag != mFormatItems)
            mFormatItemsWidth = 0;
        k = android.view.View.MeasureSpec.getMode(i);
        if(mFormatItems && mMenu != null && k != mFormatItemsWidth) {
            mFormatItemsWidth = k;
            mMenu.onItemsChanged(true);
        }
        if(mFormatItems) {
            onMeasureExactFormat(i, j);
        } else {
            int l = getChildCount();
            for(int i1 = 0; i1 < l; i1++) {
                LayoutParams layoutparams = (LayoutParams)getChildAt(i1).getLayoutParams();
                layoutparams.rightMargin = 0;
                layoutparams.leftMargin = 0;
            }

            super.onMeasure(i, j);
        }
    }

    public void setOverflowReserved(boolean flag) {
        mReserveOverflow = flag;
    }

    public void setPresenter(ActionMenuPresenter actionmenupresenter) {
        mPresenter = actionmenupresenter;
    }

    static final int GENERATED_ITEM_PADDING = 4;
    static final int MIN_CELL_SIZE = 56;
    private static final String TAG = "ActionMenuView";
    private boolean mFormatItems;
    private int mFormatItemsWidth;
    private int mGeneratedItemPadding;
    private int mMaxItemHeight;
    private int mMeasuredExtraWidth;
    private MenuBuilder mMenu;
    private int mMinCellSize;
    private ActionMenuPresenter mPresenter;
    private boolean mReserveOverflow;
}
