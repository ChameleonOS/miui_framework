// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spanned;

// Referenced classes of package android.text.style:
//            LeadingMarginSpan, LineHeightSpan

public class DrawableMarginSpan
    implements LeadingMarginSpan, LineHeightSpan {

    public DrawableMarginSpan(Drawable drawable) {
        mDrawable = drawable;
    }

    public DrawableMarginSpan(Drawable drawable, int i) {
        mDrawable = drawable;
        mPad = i;
    }

    public void chooseHeight(CharSequence charsequence, int i, int j, int k, int l, android.graphics.Paint.FontMetricsInt fontmetricsint) {
        if(j == ((Spanned)charsequence).getSpanEnd(this)) {
            int i1 = mDrawable.getIntrinsicHeight();
            int j1 = i1 - ((l + fontmetricsint.descent) - fontmetricsint.ascent - k);
            if(j1 > 0)
                fontmetricsint.descent = j1 + fontmetricsint.descent;
            int k1 = i1 - ((l + fontmetricsint.bottom) - fontmetricsint.top - k);
            if(k1 > 0)
                fontmetricsint.bottom = k1 + fontmetricsint.bottom;
        }
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int j, int k, int l, int i1, 
            CharSequence charsequence, int j1, int k1, boolean flag, Layout layout) {
        int l1 = layout.getLineTop(layout.getLineForOffset(((Spanned)charsequence).getSpanStart(this)));
        int i2 = mDrawable.getIntrinsicWidth();
        int j2 = mDrawable.getIntrinsicHeight();
        mDrawable.setBounds(i, l1, i + i2, l1 + j2);
        mDrawable.draw(canvas);
    }

    public int getLeadingMargin(boolean flag) {
        return mDrawable.getIntrinsicWidth() + mPad;
    }

    private Drawable mDrawable;
    private int mPad;
}
