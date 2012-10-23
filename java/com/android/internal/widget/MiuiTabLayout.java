// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import miui.util.ResourceMapper;

public class MiuiTabLayout extends LinearLayout {

    public MiuiTabLayout(Context context, AttributeSet attributeset, int i) {
        boolean flag = true;
        super(context, attributeset, i);
        int ai[] = new int[flag];
        ai[0] = 0x10100d4;
        TypedArray typedarray = context.obtainStyledAttributes(null, ai, 0x10102f3, 0);
        mTabBackgroundId = typedarray.getResourceId(0, 0);
        typedarray.recycle();
        if(mTabBackgroundId != ResourceMapper.resolveReference(context, 0x60201c0))
            flag = false;
        mMIUITheme = flag;
        changeBackgroundRes(0x60201c1, 0x60201c2, 0x60201c3);
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutparams) {
        super.addView(view, i, layoutparams);
        if(mTabBackgroundId != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        view.setBackgroundResource(mTabBackgroundId);
        int j = getChildCount();
        if(j > 1)
            if(i == 0) {
                getChildAt(0).setBackgroundResource(mTabBackgroundIdLeft);
                View view2 = getChildAt(1);
                int l;
                if(j > 2)
                    l = mTabBackgroundId;
                else
                    l = mTabBackgroundIdRight;
                view2.setBackgroundResource(l);
            } else
            if(i == -1 || i == j - 1) {
                getChildAt(j - 1).setBackgroundResource(mTabBackgroundIdRight);
                View view1 = getChildAt(j - 2);
                int k;
                if(j > 2)
                    k = mTabBackgroundId;
                else
                    k = mTabBackgroundIdLeft;
                view1.setBackgroundResource(k);
            }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean changeBackgroundRes(int i, int j, int k) {
        boolean flag;
        if(mMIUITheme) {
            mTabBackgroundId = i;
            mTabBackgroundIdLeft = j;
            mTabBackgroundIdRight = k;
            setDividerDrawable(null);
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public void removeViewAt(int i) {
        int j;
        super.removeViewAt(i);
        j = getChildCount();
        if(mTabBackgroundId != 0 && j != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(j == 1)
            getChildAt(0).setBackgroundResource(mTabBackgroundId);
        else
        if(i == 0)
            getChildAt(0).setBackgroundResource(mTabBackgroundIdLeft);
        else
        if(i == j)
            getChildAt(j - 1).setBackgroundResource(mTabBackgroundIdRight);
        if(true) goto _L1; else goto _L3
_L3:
    }

    private final boolean mMIUITheme;
    private int mTabBackgroundId;
    private int mTabBackgroundIdLeft;
    private int mTabBackgroundIdRight;
}
