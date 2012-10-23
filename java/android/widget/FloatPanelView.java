// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

// Referenced classes of package android.widget:
//            FrameLayout, LinearLayout

public class FloatPanelView extends FrameLayout {

    public FloatPanelView(Context context) {
        super(context);
        initArrowOffset(context);
    }

    public FloatPanelView(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        initArrowOffset(context);
    }

    private void initArrowOffset(Context context) {
        mTopOffset = (int)context.getResources().getDimension(0x60a0027);
        mBottomOffset = (int)context.getResources().getDimension(0x60a0028);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l) {
        View view;
        View view1;
        LinearLayout linearlayout;
        super.onLayout(flag, i, j, k, l);
        view = findViewById(0x60b001f);
        view1 = findViewById(0x60b0020);
        linearlayout = (LinearLayout)findViewById(0x60b001b);
        if(view != null && view1 != null && linearlayout != null) goto _L2; else goto _L1
_L1:
        Log.e("FloatPanelView", "couldn't find view");
_L5:
        return;
_L2:
        View view2;
        int j1;
        view.setVisibility(8);
        view1.setVisibility(8);
        int i1;
        if(mIsArrowUp)
            view2 = view;
        else
            view2 = view1;
        if(mIsArrowUp)
            i1 = 0;
        else
            i1 = linearlayout.getMeasuredHeight() - mBottomOffset;
        view2.setVisibility(0);
        j1 = mPos - view2.getMeasuredWidth() / 2;
        if(j1 >= 0) goto _L4; else goto _L3
_L3:
        j1 = 0;
_L6:
        view2.layout(j1, i1, j1 + view2.getMeasuredWidth(), i1 + view2.getMeasuredHeight());
        int k1;
        if(mIsArrowUp)
            k1 = view.getHeight() - mTopOffset;
        else
            k1 = 0;
        linearlayout.layout(linearlayout.getLeft(), k1, linearlayout.getLeft() + linearlayout.getMeasuredWidth(), k1 + linearlayout.getMeasuredHeight());
        if(true) goto _L5; else goto _L4
_L4:
        if(j1 > k - view2.getMeasuredWidth())
            j1 = k - view2.getMeasuredWidth();
          goto _L6
    }

    public void setArrow(boolean flag) {
        if(flag != mIsArrowUp) {
            mIsArrowUp = flag;
            requestLayout();
        }
    }

    public void setArrowPos(int i) {
        if(i != mPos) {
            mPos = i;
            requestLayout();
        }
    }

    private int mBottomOffset;
    private boolean mIsArrowUp;
    private int mPos;
    private int mTopOffset;
}
