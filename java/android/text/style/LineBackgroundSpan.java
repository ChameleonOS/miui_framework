// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.style;

import android.graphics.Canvas;
import android.graphics.Paint;

// Referenced classes of package android.text.style:
//            ParagraphStyle

public interface LineBackgroundSpan
    extends ParagraphStyle {

    public abstract void drawBackground(Canvas canvas, Paint paint, int i, int j, int k, int l, int i1, 
            CharSequence charsequence, int j1, int k1, int l1);
}
