// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;

public class WeightedLinearLayout extends LinearLayout {

    public WeightedLinearLayout(Context context) {
        super(context);
    }

    public WeightedLinearLayout(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.WeightedLinearLayout);
        mMajorWeightMin = typedarray.getFloat(0, 0.0F);
        mMinorWeightMin = typedarray.getFloat(1, 0.0F);
        mMajorWeightMax = typedarray.getFloat(2, 0.0F);
        mMinorWeightMax = typedarray.getFloat(3, 0.0F);
        typedarray.recycle();
    }

    protected void onMeasure(int i, int j) {
        int i1;
        boolean flag1;
        int j1;
        float f1;
        int l1;
        DisplayMetrics displaymetrics = getContext().getResources().getDisplayMetrics();
        int k = displaymetrics.widthPixels;
        boolean flag;
        int l;
        float f;
        int k1;
        if(k < displaymetrics.heightPixels)
            flag = true;
        else
            flag = false;
        l = android.view.View.MeasureSpec.getMode(i);
        super.onMeasure(i, j);
        i1 = getMeasuredWidth();
        flag1 = false;
        j1 = android.view.View.MeasureSpec.makeMeasureSpec(i1, 0x40000000);
        if(flag)
            f = mMinorWeightMin;
        else
            f = mMajorWeightMin;
        if(flag)
            f1 = mMinorWeightMax;
        else
            f1 = mMajorWeightMax;
        if(l != 0x80000000) goto _L2; else goto _L1
_L1:
        k1 = (int)(f * (float)k);
        l1 = (int)(f * (float)k);
        if(f <= 0.0F || i1 >= k1) goto _L4; else goto _L3
_L3:
        j1 = android.view.View.MeasureSpec.makeMeasureSpec(k1, 0x40000000);
        flag1 = true;
_L2:
        if(flag1)
            super.onMeasure(j1, j);
        return;
_L4:
        if(f1 > 0.0F && i1 > l1) {
            j1 = android.view.View.MeasureSpec.makeMeasureSpec(l1, 0x40000000);
            flag1 = true;
        }
        if(true) goto _L2; else goto _L5
_L5:
    }

    private float mMajorWeightMax;
    private float mMajorWeightMin;
    private float mMinorWeightMax;
    private float mMinorWeightMin;
}
