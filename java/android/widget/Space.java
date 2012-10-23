// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public final class Space extends View {

    public Space(Context context) {
        this(context, null);
    }

    public Space(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0);
    }

    public Space(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        if(getVisibility() == 0)
            setVisibility(4);
    }

    private static int getDefaultSize2(int i, int j) {
        int k;
        int l;
        int i1;
        k = i;
        l = android.view.View.MeasureSpec.getMode(j);
        i1 = android.view.View.MeasureSpec.getSize(j);
        l;
        JVM INSTR lookupswitch 3: default 48
    //                   -2147483648: 55
    //                   0: 50
    //                   1073741824: 65;
           goto _L1 _L2 _L3 _L4
_L1:
        return k;
_L3:
        k = i;
        continue; /* Loop/switch isn't completed */
_L2:
        k = Math.min(i, i1);
        continue; /* Loop/switch isn't completed */
_L4:
        k = i1;
        if(true) goto _L1; else goto _L5
_L5:
    }

    public void draw(Canvas canvas) {
    }

    protected void onMeasure(int i, int j) {
        setMeasuredDimension(getDefaultSize2(getSuggestedMinimumWidth(), i), getDefaultSize2(getSuggestedMinimumHeight(), j));
    }
}
