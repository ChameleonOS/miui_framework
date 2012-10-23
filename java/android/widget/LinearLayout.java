// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.*;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class LinearLayout extends ViewGroup {
    public static class LayoutParams extends android.view.ViewGroup.MarginLayoutParams {

        public String debug(String s) {
            return (new StringBuilder()).append(s).append("LinearLayout.LayoutParams={width=").append(sizeToString(super.width)).append(", height=").append(sizeToString(super.height)).append(" weight=").append(weight).append("}").toString();
        }

        public int gravity;
        public float weight;

        public LayoutParams(int i, int j) {
            super(i, j);
            gravity = -1;
            weight = 0.0F;
        }

        public LayoutParams(int i, int j, float f) {
            super(i, j);
            gravity = -1;
            weight = f;
        }

        public LayoutParams(Context context, AttributeSet attributeset) {
            super(context, attributeset);
            gravity = -1;
            TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.LinearLayout_Layout);
            weight = typedarray.getFloat(3, 0.0F);
            gravity = typedarray.getInt(0, -1);
            typedarray.recycle();
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutparams) {
            super(layoutparams);
            gravity = -1;
        }

        public LayoutParams(android.view.ViewGroup.MarginLayoutParams marginlayoutparams) {
            super(marginlayoutparams);
            gravity = -1;
        }
    }


    public LinearLayout(Context context) {
        super(context);
        mBaselineAligned = true;
        mBaselineAlignedChildIndex = -1;
        mBaselineChildTop = 0;
        mGravity = 0x800033;
    }

    public LinearLayout(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0);
    }

    public LinearLayout(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        mBaselineAligned = true;
        mBaselineAlignedChildIndex = -1;
        mBaselineChildTop = 0;
        mGravity = 0x800033;
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.LinearLayout, i, 0);
        int j = typedarray.getInt(1, -1);
        if(j >= 0)
            setOrientation(j);
        int k = typedarray.getInt(0, -1);
        if(k >= 0)
            setGravity(k);
        boolean flag = typedarray.getBoolean(2, true);
        if(!flag)
            setBaselineAligned(flag);
        mWeightSum = typedarray.getFloat(4, -1F);
        mBaselineAlignedChildIndex = typedarray.getInt(3, -1);
        mUseLargestChild = typedarray.getBoolean(6, false);
        setDividerDrawable(typedarray.getDrawable(5));
        mShowDividers = typedarray.getInt(7, 0);
        mDividerPadding = typedarray.getDimensionPixelSize(8, 0);
        typedarray.recycle();
    }

    private void forceUniformHeight(int i, int j) {
        int k = android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0x40000000);
        for(int l = 0; l < i; l++) {
            View view = getVirtualChildAt(l);
            if(view.getVisibility() == 8)
                continue;
            LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
            if(((android.view.ViewGroup.LayoutParams) (layoutparams)).height == -1) {
                int i1 = ((android.view.ViewGroup.LayoutParams) (layoutparams)).width;
                layoutparams.width = view.getMeasuredWidth();
                measureChildWithMargins(view, j, 0, k, 0);
                layoutparams.width = i1;
            }
        }

    }

    private void forceUniformWidth(int i, int j) {
        int k = android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0x40000000);
        for(int l = 0; l < i; l++) {
            View view = getVirtualChildAt(l);
            if(view.getVisibility() == 8)
                continue;
            LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
            if(((android.view.ViewGroup.LayoutParams) (layoutparams)).width == -1) {
                int i1 = ((android.view.ViewGroup.LayoutParams) (layoutparams)).height;
                layoutparams.height = view.getMeasuredHeight();
                measureChildWithMargins(view, k, 0, j, 0);
                layoutparams.height = i1;
            }
        }

    }

    private void setChildFrame(View view, int i, int j, int k, int l) {
        view.layout(i, j, i + k, j + l);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams) {
        return layoutparams instanceof LayoutParams;
    }

    void drawDividersHorizontal(Canvas canvas) {
        int i = getVirtualChildCount();
        for(int j = 0; j < i; j++) {
            View view1 = getVirtualChildAt(j);
            if(view1 != null && view1.getVisibility() != 8 && hasDividerBeforeChildAt(j)) {
                LayoutParams layoutparams1 = (LayoutParams)view1.getLayoutParams();
                drawVerticalDivider(canvas, view1.getLeft() - ((android.view.ViewGroup.MarginLayoutParams) (layoutparams1)).leftMargin - mDividerWidth);
            }
        }

        if(hasDividerBeforeChildAt(i)) {
            View view = getVirtualChildAt(i - 1);
            int k;
            if(view == null) {
                k = getWidth() - getPaddingRight() - mDividerWidth;
            } else {
                LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
                k = view.getRight() + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).rightMargin;
            }
            drawVerticalDivider(canvas, k);
        }
    }

    void drawDividersVertical(Canvas canvas) {
        int i = getVirtualChildCount();
        for(int j = 0; j < i; j++) {
            View view1 = getVirtualChildAt(j);
            if(view1 != null && view1.getVisibility() != 8 && hasDividerBeforeChildAt(j)) {
                LayoutParams layoutparams1 = (LayoutParams)view1.getLayoutParams();
                drawHorizontalDivider(canvas, view1.getTop() - ((android.view.ViewGroup.MarginLayoutParams) (layoutparams1)).topMargin - mDividerHeight);
            }
        }

        if(hasDividerBeforeChildAt(i)) {
            View view = getVirtualChildAt(i - 1);
            int k;
            if(view == null) {
                k = getHeight() - getPaddingBottom() - mDividerHeight;
            } else {
                LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
                k = view.getBottom() + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).bottomMargin;
            }
            drawHorizontalDivider(canvas, k);
        }
    }

    void drawHorizontalDivider(Canvas canvas, int i) {
        mDivider.setBounds(getPaddingLeft() + mDividerPadding, i, getWidth() - getPaddingRight() - mDividerPadding, i + mDividerHeight);
        mDivider.draw(canvas);
    }

    void drawVerticalDivider(Canvas canvas, int i) {
        mDivider.setBounds(i, getPaddingTop() + mDividerPadding, i + mDividerWidth, getHeight() - getPaddingBottom() - mDividerPadding);
        mDivider.draw(canvas);
    }

    protected volatile android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    protected LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutparams;
        if(mOrientation == 0)
            layoutparams = new LayoutParams(-2, -2);
        else
        if(mOrientation == 1)
            layoutparams = new LayoutParams(-1, -2);
        else
            layoutparams = null;
        return layoutparams;
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

    public int getBaseline() {
        int i = -1;
        if(mBaselineAlignedChildIndex >= 0) goto _L2; else goto _L1
_L1:
        i = super.getBaseline();
_L4:
        return i;
_L2:
        View view;
        int k;
        if(getChildCount() <= mBaselineAlignedChildIndex)
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        view = getChildAt(mBaselineAlignedChildIndex);
        int j = view.getBaseline();
        if(j == i) {
            if(mBaselineAlignedChildIndex != 0)
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            continue; /* Loop/switch isn't completed */
        }
        k = mBaselineChildTop;
        if(mOrientation == 1) {
            int l = 0x70 & mGravity;
            if(l != 48) {
                switch(l) {
                default:
                    break;

                case 80: // 'P'
                    break; /* Loop/switch isn't completed */

                case 16: // '\020'
                    break;
                }
                break MISSING_BLOCK_LABEL_179;
            }
        }
_L5:
        i = j + (k + ((android.view.ViewGroup.MarginLayoutParams) ((LayoutParams)view.getLayoutParams())).topMargin);
        if(true) goto _L4; else goto _L3
_L3:
        k = super.mBottom - super.mTop - super.mPaddingBottom - mTotalLength;
          goto _L5
        k += (super.mBottom - super.mTop - super.mPaddingTop - super.mPaddingBottom - mTotalLength) / 2;
          goto _L5
    }

    public int getBaselineAlignedChildIndex() {
        return mBaselineAlignedChildIndex;
    }

    int getChildrenSkipCount(View view, int i) {
        return 0;
    }

    public Drawable getDividerDrawable() {
        return mDivider;
    }

    public int getDividerPadding() {
        return mDividerPadding;
    }

    public int getDividerWidth() {
        return mDividerWidth;
    }

    int getLocationOffset(View view) {
        return 0;
    }

    int getNextLocationOffset(View view) {
        return 0;
    }

    public int getOrientation() {
        return mOrientation;
    }

    public int getShowDividers() {
        return mShowDividers;
    }

    View getVirtualChildAt(int i) {
        return getChildAt(i);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return mWeightSum;
    }

    protected boolean hasDividerBeforeChildAt(int i) {
        boolean flag = true;
        if(i != 0) goto _L2; else goto _L1
_L1:
        if((1 & mShowDividers) == 0)
            flag = false;
_L4:
        return flag;
_L2:
        if(i == getChildCount()) {
            if((4 & mShowDividers) == 0)
                flag = false;
            continue; /* Loop/switch isn't completed */
        }
        if((2 & mShowDividers) != 0) {
            boolean flag1 = false;
            int j = i - 1;
            do {
label0:
                {
                    if(j >= 0) {
                        if(getChildAt(j).getVisibility() == 8)
                            break label0;
                        flag1 = true;
                    }
                    flag = flag1;
                    continue; /* Loop/switch isn't completed */
                }
                j--;
            } while(true);
        }
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean isBaselineAligned() {
        return mBaselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return mUseLargestChild;
    }

    void layoutHorizontal() {
        boolean flag;
        int i;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        boolean flag1;
        int ai[];
        int ai1[];
        flag = isLayoutRtl();
        i = super.mPaddingTop;
        int j = super.mBottom - super.mTop;
        k = j - super.mPaddingBottom;
        l = j - i - super.mPaddingBottom;
        i1 = getVirtualChildCount();
        j1 = 0x800007 & mGravity;
        k1 = 0x70 & mGravity;
        flag1 = mBaselineAligned;
        ai = mMaxAscent;
        ai1 = mMaxDescent;
        Gravity.getAbsoluteGravity(j1, getResolvedLayoutDirection());
        JVM INSTR lookupswitch 2: default 116
    //                   1: 216
    //                   5: 192;
           goto _L1 _L2 _L3
_L1:
        int l1 = super.mPaddingLeft;
_L16:
        int i2;
        byte byte0;
        int j2;
        i2 = 0;
        byte0 = 1;
        if(flag) {
            i2 = i1 - 1;
            byte0 = -1;
        }
        j2 = 0;
_L7:
        int k2;
        View view;
        if(j2 >= i1)
            break; /* Loop/switch isn't completed */
        k2 = i2 + byte0 * j2;
        view = getVirtualChildAt(k2);
        if(view != null) goto _L5; else goto _L4
_L4:
        l1 += measureNullChild(k2);
_L9:
        j2++;
        if(true) goto _L7; else goto _L6
_L3:
        l1 = (super.mPaddingLeft + super.mRight) - super.mLeft - mTotalLength;
        continue; /* Loop/switch isn't completed */
_L2:
        l1 = super.mPaddingLeft + (super.mRight - super.mLeft - mTotalLength) / 2;
        continue; /* Loop/switch isn't completed */
_L5:
        if(view.getVisibility() == 8) goto _L9; else goto _L8
_L8:
        int l2;
        int i3;
        int j3;
        LayoutParams layoutparams;
        int k3;
        l2 = view.getMeasuredWidth();
        i3 = view.getMeasuredHeight();
        j3 = -1;
        layoutparams = (LayoutParams)view.getLayoutParams();
        if(flag1 && ((android.view.ViewGroup.LayoutParams) (layoutparams)).height != -1)
            j3 = view.getBaseline();
        k3 = layoutparams.gravity;
        if(k3 < 0)
            k3 = k1;
        k3 & 0x70;
        JVM INSTR lookupswitch 3: default 356
    //                   16: 475
    //                   48: 444
    //                   80: 501;
           goto _L10 _L11 _L12 _L13
_L13:
        break MISSING_BLOCK_LABEL_501;
_L10:
        int l3 = i;
_L14:
        if(hasDividerBeforeChildAt(k2))
            l1 += mDividerWidth;
        int j4 = l1 + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).leftMargin;
        setChildFrame(view, j4 + getLocationOffset(view), l3, l2, i3);
        l1 = j4 + (l2 + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).rightMargin + getNextLocationOffset(view));
        j2 += getChildrenSkipCount(view, k2);
          goto _L9
_L12:
        l3 = i + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).topMargin;
        if(j3 != -1)
            l3 += ai[1] - j3;
          goto _L14
_L11:
        l3 = (i + (l - i3) / 2 + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).topMargin) - ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).bottomMargin;
          goto _L14
        l3 = k - i3 - ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).bottomMargin;
        if(j3 != -1) {
            int i4 = view.getMeasuredHeight() - j3;
            l3 -= ai1[2] - i4;
        }
          goto _L14
_L6:
        return;
        if(true) goto _L16; else goto _L15
_L15:
    }

    void layoutVertical() {
        int i;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        i = super.mPaddingLeft;
        int j = super.mRight - super.mLeft;
        k = j - super.mPaddingRight;
        l = j - i - super.mPaddingRight;
        i1 = getVirtualChildCount();
        j1 = 0x70 & mGravity;
        k1 = 0x800007 & mGravity;
        j1;
        JVM INSTR lookupswitch 2: default 84
    //                   16: 154
    //                   80: 130;
           goto _L1 _L2 _L3
_L1:
        int l1 = super.mPaddingTop;
_L15:
        int i2 = 0;
_L7:
        View view;
        if(i2 >= i1)
            break; /* Loop/switch isn't completed */
        view = getVirtualChildAt(i2);
        if(view != null) goto _L5; else goto _L4
_L4:
        l1 += measureNullChild(i2);
_L9:
        i2++;
        if(true) goto _L7; else goto _L6
_L3:
        l1 = (super.mPaddingTop + super.mBottom) - super.mTop - mTotalLength;
        continue; /* Loop/switch isn't completed */
_L2:
        l1 = super.mPaddingTop + (super.mBottom - super.mTop - mTotalLength) / 2;
        continue; /* Loop/switch isn't completed */
_L5:
        if(view.getVisibility() == 8) goto _L9; else goto _L8
_L8:
        int j2;
        int k2;
        LayoutParams layoutparams;
        int l2;
        j2 = view.getMeasuredWidth();
        k2 = view.getMeasuredHeight();
        layoutparams = (LayoutParams)view.getLayoutParams();
        l2 = layoutparams.gravity;
        if(l2 < 0)
            l2 = k1;
        7 & Gravity.getAbsoluteGravity(l2, getResolvedLayoutDirection());
        JVM INSTR lookupswitch 2: default 268
    //                   1: 362
    //                   5: 388;
           goto _L10 _L11 _L12
_L12:
        break MISSING_BLOCK_LABEL_388;
_L10:
        int i3 = i + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).leftMargin;
_L13:
        if(hasDividerBeforeChildAt(i2))
            l1 += mDividerHeight;
        int j3 = l1 + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).topMargin;
        setChildFrame(view, i3, j3 + getLocationOffset(view), j2, k2);
        l1 = j3 + (k2 + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).bottomMargin + getNextLocationOffset(view));
        i2 += getChildrenSkipCount(view, i2);
          goto _L9
_L11:
        i3 = (i + (l - j2) / 2 + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).leftMargin) - ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).rightMargin;
          goto _L13
        i3 = k - j2 - ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).rightMargin;
          goto _L13
_L6:
        return;
        if(true) goto _L15; else goto _L14
_L14:
    }

    void measureChildBeforeLayout(View view, int i, int j, int k, int l, int i1) {
        measureChildWithMargins(view, j, k, l, i1);
    }


// JavaClassFileOutputException: Prev chain is broken

    int measureNullChild(int i) {
        return 0;
    }


// JavaClassFileOutputException: Prev chain is broken

    protected void onDraw(Canvas canvas) {
        if(mDivider != null)
            if(mOrientation == 1)
                drawDividersVertical(canvas);
            else
                drawDividersHorizontal(canvas);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/LinearLayout.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/LinearLayout.getName());
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l) {
        if(mOrientation == 1)
            layoutVertical();
        else
            layoutHorizontal();
    }

    protected void onMeasure(int i, int j) {
        if(mOrientation == 1)
            measureVertical(i, j);
        else
            measureHorizontal(i, j);
    }

    public void setBaselineAligned(boolean flag) {
        mBaselineAligned = flag;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if(i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException((new StringBuilder()).append("base aligned child index out of range (0, ").append(getChildCount()).append(")").toString());
        } else {
            mBaselineAlignedChildIndex = i;
            return;
        }
    }

    public void setDividerDrawable(Drawable drawable) {
        boolean flag = false;
        if(drawable != mDivider) {
            mDivider = drawable;
            if(drawable != null) {
                mDividerWidth = drawable.getIntrinsicWidth();
                mDividerHeight = drawable.getIntrinsicHeight();
            } else {
                mDividerWidth = 0;
                mDividerHeight = 0;
            }
            if(drawable == null)
                flag = true;
            setWillNotDraw(flag);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        mDividerPadding = i;
    }

    public void setGravity(int i) {
        if(mGravity != i) {
            if((0x800007 & i) == 0)
                i |= 0x800003;
            if((i & 0x70) == 0)
                i |= 0x30;
            mGravity = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int j = i & 0x800007;
        if((0x800007 & mGravity) != j) {
            mGravity = j | 0xff7ffff8 & mGravity;
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean flag) {
        mUseLargestChild = flag;
    }

    public void setOrientation(int i) {
        if(mOrientation != i) {
            mOrientation = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if(i != mShowDividers)
            requestLayout();
        mShowDividers = i;
    }

    public void setVerticalGravity(int i) {
        int j = i & 0x70;
        if((0x70 & mGravity) != j) {
            mGravity = j | 0xffffff8f & mGravity;
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        mWeightSum = Math.max(0.0F, f);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int mMaxAscent[];
    private int mMaxDescent[];
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;
}
