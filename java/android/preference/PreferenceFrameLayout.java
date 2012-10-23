// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.preference;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;

public class PreferenceFrameLayout extends FrameLayout {
    public static class LayoutParams extends android.widget.FrameLayout.LayoutParams {

        public boolean removeBorders;

        public LayoutParams(int i, int j) {
            super(i, j);
            removeBorders = false;
        }

        public LayoutParams(Context context, AttributeSet attributeset) {
            super(context, attributeset);
            removeBorders = false;
            TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.PreferenceFrameLayout_Layout);
            removeBorders = typedarray.getBoolean(0, false);
            typedarray.recycle();
        }
    }


    public PreferenceFrameLayout(Context context) {
        this(context, null);
    }

    public PreferenceFrameLayout(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0x10103d9);
    }

    public PreferenceFrameLayout(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.PreferenceFrameLayout, i, 0);
        float f = context.getResources().getDisplayMetrics().density;
        int j = (int)(0.5F + f * 0.0F);
        int k = (int)(0.5F + f * 0.0F);
        int l = (int)(0.5F + f * 0.0F);
        int i1 = (int)(0.5F + f * 0.0F);
        mBorderTop = typedarray.getDimensionPixelSize(0, j);
        mBorderBottom = typedarray.getDimensionPixelSize(1, k);
        mBorderLeft = typedarray.getDimensionPixelSize(2, l);
        mBorderRight = typedarray.getDimensionPixelSize(3, i1);
        typedarray.recycle();
    }

    public void addView(View view) {
        int i;
        int j;
        int k;
        int l;
        i = getPaddingTop();
        j = getPaddingBottom();
        k = getPaddingLeft();
        l = getPaddingRight();
        LayoutParams layoutparams;
        int i1;
        int j1;
        int k1;
        int l1;
        if(view.getLayoutParams() instanceof LayoutParams)
            layoutparams = (LayoutParams)view.getLayoutParams();
        else
            layoutparams = null;
        if(layoutparams == null || !layoutparams.removeBorders) goto _L2; else goto _L1
_L1:
        if(mPaddingApplied) {
            i -= mBorderTop;
            j -= mBorderBottom;
            k -= mBorderLeft;
            l -= mBorderRight;
            mPaddingApplied = false;
        }
_L4:
        i1 = getPaddingTop();
        j1 = getPaddingBottom();
        k1 = getPaddingLeft();
        l1 = getPaddingRight();
        if(i1 != i || j1 != j || k1 != k || l1 != l)
            setPadding(k, i, l, j);
        super.addView(view);
        return;
_L2:
        if(!mPaddingApplied) {
            i += mBorderTop;
            j += mBorderBottom;
            k += mBorderLeft;
            l += mBorderRight;
            mPaddingApplied = true;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeset) {
        return new LayoutParams(getContext(), attributeset);
    }

    public volatile android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset) {
        return generateLayoutParams(attributeset);
    }

    public volatile android.widget.FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeset) {
        return generateLayoutParams(attributeset);
    }

    private static final int DEFAULT_BORDER_BOTTOM;
    private static final int DEFAULT_BORDER_LEFT;
    private static final int DEFAULT_BORDER_RIGHT;
    private static final int DEFAULT_BORDER_TOP;
    private final int mBorderBottom;
    private final int mBorderLeft;
    private final int mBorderRight;
    private final int mBorderTop;
    private boolean mPaddingApplied;
}
