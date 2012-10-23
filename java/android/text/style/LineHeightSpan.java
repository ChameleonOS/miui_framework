// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.style;

import android.text.TextPaint;

// Referenced classes of package android.text.style:
//            ParagraphStyle, WrapTogetherSpan

public interface LineHeightSpan
    extends ParagraphStyle, WrapTogetherSpan {
    public static interface WithDensity
        extends LineHeightSpan {

        public abstract void chooseHeight(CharSequence charsequence, int i, int j, int k, int l, android.graphics.Paint.FontMetricsInt fontmetricsint, TextPaint textpaint);
    }


    public abstract void chooseHeight(CharSequence charsequence, int i, int j, int k, int l, android.graphics.Paint.FontMetricsInt fontmetricsint);
}
