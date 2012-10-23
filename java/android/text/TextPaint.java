// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text;

import android.graphics.Paint;

public class TextPaint extends Paint {

    public TextPaint() {
        density = 1.0F;
        underlineColor = 0;
    }

    public TextPaint(int i) {
        super(i);
        density = 1.0F;
        underlineColor = 0;
    }

    public TextPaint(Paint paint) {
        super(paint);
        density = 1.0F;
        underlineColor = 0;
    }

    public void set(TextPaint textpaint) {
        super.set(textpaint);
        bgColor = textpaint.bgColor;
        baselineShift = textpaint.baselineShift;
        linkColor = textpaint.linkColor;
        drawableState = textpaint.drawableState;
        density = textpaint.density;
        underlineColor = textpaint.underlineColor;
        underlineThickness = textpaint.underlineThickness;
    }

    public void setUnderlineText(int i, float f) {
        underlineColor = i;
        underlineThickness = f;
    }

    public int baselineShift;
    public int bgColor;
    public float density;
    public int drawableState[];
    public int linkColor;
    public int underlineColor;
    public float underlineThickness;
}
