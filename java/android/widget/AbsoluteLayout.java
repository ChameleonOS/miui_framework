// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class AbsoluteLayout extends ViewGroup {
    public static class LayoutParams extends android.view.ViewGroup.LayoutParams {

        public String debug(String s) {
            return (new StringBuilder()).append(s).append("Absolute.LayoutParams={width=").append(sizeToString(super.width)).append(", height=").append(sizeToString(super.height)).append(" x=").append(x).append(" y=").append(y).append("}").toString();
        }

        public int x;
        public int y;

        public LayoutParams(int i, int j, int k, int l) {
            super(i, j);
            x = k;
            y = l;
        }

        public LayoutParams(Context context, AttributeSet attributeset) {
            super(context, attributeset);
            TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.AbsoluteLayout_Layout);
            x = typedarray.getDimensionPixelOffset(0, 0);
            y = typedarray.getDimensionPixelOffset(1, 0);
            typedarray.recycle();
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutparams) {
            super(layoutparams);
        }
    }


    public AbsoluteLayout(Context context) {
        super(context);
    }

    public AbsoluteLayout(Context context, AttributeSet attributeset) {
        super(context, attributeset);
    }

    public AbsoluteLayout(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams) {
        return layoutparams instanceof LayoutParams;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2, 0, 0);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset) {
        return new LayoutParams(getContext(), attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams) {
        return new LayoutParams(layoutparams);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l) {
        int i1 = getChildCount();
        for(int j1 = 0; j1 < i1; j1++) {
            View view = getChildAt(j1);
            if(view.getVisibility() != 8) {
                LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
                int k1 = super.mPaddingLeft + layoutparams.x;
                int l1 = super.mPaddingTop + layoutparams.y;
                view.layout(k1, l1, k1 + view.getMeasuredWidth(), l1 + view.getMeasuredHeight());
            }
        }

    }

    protected void onMeasure(int i, int j) {
        int k = getChildCount();
        int l = 0;
        int i1 = 0;
        measureChildren(i, j);
        for(int j1 = 0; j1 < k; j1++) {
            View view = getChildAt(j1);
            if(view.getVisibility() != 8) {
                LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
                int i2 = layoutparams.x + view.getMeasuredWidth();
                int j2 = layoutparams.y + view.getMeasuredHeight();
                i1 = Math.max(i1, i2);
                l = Math.max(l, j2);
            }
        }

        int k1 = i1 + (super.mPaddingLeft + super.mPaddingRight);
        int l1 = Math.max(l + (super.mPaddingTop + super.mPaddingBottom), getSuggestedMinimumHeight());
        setMeasuredDimension(resolveSizeAndState(Math.max(k1, getSuggestedMinimumWidth()), i, 0), resolveSizeAndState(l1, j, 0));
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
