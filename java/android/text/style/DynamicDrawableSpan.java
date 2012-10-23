// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.style;

import android.graphics.*;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

// Referenced classes of package android.text.style:
//            ReplacementSpan

public abstract class DynamicDrawableSpan extends ReplacementSpan {

    public DynamicDrawableSpan() {
        mVerticalAlignment = 0;
    }

    protected DynamicDrawableSpan(int i) {
        mVerticalAlignment = i;
    }

    private Drawable getCachedDrawable() {
        WeakReference weakreference = mDrawableRef;
        Drawable drawable = null;
        if(weakreference != null)
            drawable = (Drawable)weakreference.get();
        if(drawable == null) {
            drawable = getDrawable();
            mDrawableRef = new WeakReference(drawable);
        }
        return drawable;
    }

    public void draw(Canvas canvas, CharSequence charsequence, int i, int j, float f, int k, int l, 
            int i1, Paint paint) {
        Drawable drawable = getCachedDrawable();
        canvas.save();
        int j1 = i1 - drawable.getBounds().bottom;
        if(mVerticalAlignment == 1)
            j1 -= paint.getFontMetricsInt().descent;
        canvas.translate(f, j1);
        drawable.draw(canvas);
        canvas.restore();
    }

    public abstract Drawable getDrawable();

    public int getSize(Paint paint, CharSequence charsequence, int i, int j, android.graphics.Paint.FontMetricsInt fontmetricsint) {
        Rect rect = getCachedDrawable().getBounds();
        if(fontmetricsint != null) {
            fontmetricsint.ascent = -rect.bottom;
            fontmetricsint.descent = 0;
            fontmetricsint.top = fontmetricsint.ascent;
            fontmetricsint.bottom = 0;
        }
        return rect.right;
    }

    public int getVerticalAlignment() {
        return mVerticalAlignment;
    }

    public static final int ALIGN_BASELINE = 1;
    public static final int ALIGN_BOTTOM = 0;
    private static final String TAG = "DynamicDrawableSpan";
    private WeakReference mDrawableRef;
    protected final int mVerticalAlignment;
}
