// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text;

import android.graphics.*;
import android.text.style.ParagraphStyle;
import android.util.FloatMath;

// Referenced classes of package android.text:
//            Layout, TextPaint, TextUtils, TextDirectionHeuristics, 
//            Spanned, TextLine, TextDirectionHeuristic

public class BoringLayout extends Layout
    implements TextUtils.EllipsizeCallback {
    public static class Metrics extends android.graphics.Paint.FontMetricsInt {

        public String toString() {
            return (new StringBuilder()).append(super.toString()).append(" width=").append(width).toString();
        }

        public int width;

        public Metrics() {
        }
    }


    public BoringLayout(CharSequence charsequence, TextPaint textpaint, int i, Layout.Alignment alignment, float f, float f1, Metrics metrics, 
            boolean flag) {
        super(charsequence, textpaint, i, alignment, f, f1);
        mEllipsizedWidth = i;
        mEllipsizedStart = 0;
        mEllipsizedCount = 0;
        init(charsequence, textpaint, i, alignment, f, f1, metrics, flag, true);
    }

    public BoringLayout(CharSequence charsequence, TextPaint textpaint, int i, Layout.Alignment alignment, float f, float f1, Metrics metrics, 
            boolean flag, TextUtils.TruncateAt truncateat, int j) {
        super(charsequence, textpaint, i, alignment, f, f1);
        boolean flag1;
        if(truncateat == null || truncateat == TextUtils.TruncateAt.MARQUEE) {
            mEllipsizedWidth = i;
            mEllipsizedStart = 0;
            mEllipsizedCount = 0;
            flag1 = true;
        } else {
            replaceWith(TextUtils.ellipsize(charsequence, textpaint, j, truncateat, true, this), textpaint, i, alignment, f, f1);
            mEllipsizedWidth = j;
            flag1 = false;
        }
        init(getText(), textpaint, i, alignment, f, f1, metrics, flag, flag1);
    }

    public static Metrics isBoring(CharSequence charsequence, TextPaint textpaint) {
        return isBoring(charsequence, textpaint, TextDirectionHeuristics.FIRSTSTRONG_LTR, null);
    }

    public static Metrics isBoring(CharSequence charsequence, TextPaint textpaint, Metrics metrics) {
        return isBoring(charsequence, textpaint, TextDirectionHeuristics.FIRSTSTRONG_LTR, metrics);
    }

    public static Metrics isBoring(CharSequence charsequence, TextPaint textpaint, TextDirectionHeuristic textdirectionheuristic) {
        return isBoring(charsequence, textpaint, textdirectionheuristic, null);
    }

    public static Metrics isBoring(CharSequence charsequence, TextPaint textpaint, TextDirectionHeuristic textdirectionheuristic, Metrics metrics) {
        char ac[];
        int i;
        boolean flag;
        int j;
        ac = TextUtils.obtain(500);
        i = charsequence.length();
        flag = true;
        j = 0;
_L7:
        if(j >= i) goto _L2; else goto _L1
_L1:
        int i1;
        int j1;
        int l = 500 + j;
        if(l > i)
            l = i;
        TextUtils.getChars(charsequence, j, l, ac, 0);
        i1 = l - j;
        j1 = 0;
_L5:
        char c;
        if(j1 >= i1)
            break MISSING_BLOCK_LABEL_224;
        c = ac[j1];
        if(c != '\n' && c != '\t' && c < '\u0590') goto _L4; else goto _L3
_L3:
        flag = false;
_L2:
        TextUtils.recycle(ac);
        if(flag && (charsequence instanceof Spanned) && ((Spanned)charsequence).getSpans(0, i, android/text/style/ParagraphStyle).length > 0)
            flag = false;
        Metrics metrics1;
        if(flag) {
            metrics1 = metrics;
            if(metrics1 == null)
                metrics1 = new Metrics();
            TextLine textline = TextLine.obtain();
            textline.set(textpaint, charsequence, 0, i, 1, Layout.DIRS_ALL_LEFT_TO_RIGHT, false, null);
            int k = (int)FloatMath.ceil(textline.metrics(metrics1));
            metrics1.width = k;
            TextLine.recycle(textline);
        } else {
            metrics1 = null;
        }
        return metrics1;
_L4:
        j1++;
          goto _L5
label0:
        {
            if(textdirectionheuristic == null || !textdirectionheuristic.isRtl(ac, 0, i1))
                break label0;
            flag = false;
        }
          goto _L2
        j += 500;
        if(true) goto _L7; else goto _L6
_L6:
    }

    public static BoringLayout make(CharSequence charsequence, TextPaint textpaint, int i, Layout.Alignment alignment, float f, float f1, Metrics metrics, boolean flag) {
        return new BoringLayout(charsequence, textpaint, i, alignment, f, f1, metrics, flag);
    }

    public static BoringLayout make(CharSequence charsequence, TextPaint textpaint, int i, Layout.Alignment alignment, float f, float f1, Metrics metrics, boolean flag, 
            TextUtils.TruncateAt truncateat, int j) {
        return new BoringLayout(charsequence, textpaint, i, alignment, f, f1, metrics, flag, truncateat, j);
    }

    public void draw(Canvas canvas, Path path, Paint paint, int i) {
        if(mDirect != null && path == null)
            canvas.drawText(mDirect, 0.0F, mBottom - mDesc, mPaint);
        else
            super.draw(canvas, path, paint, i);
    }

    public void ellipsized(int i, int j) {
        mEllipsizedStart = i;
        mEllipsizedCount = j - i;
    }

    public int getBottomPadding() {
        return mBottomPadding;
    }

    public int getEllipsisCount(int i) {
        return mEllipsizedCount;
    }

    public int getEllipsisStart(int i) {
        return mEllipsizedStart;
    }

    public int getEllipsizedWidth() {
        return mEllipsizedWidth;
    }

    public int getHeight() {
        return mBottom;
    }

    public boolean getLineContainsTab(int i) {
        return false;
    }

    public int getLineCount() {
        return 1;
    }

    public int getLineDescent(int i) {
        return mDesc;
    }

    public final Layout.Directions getLineDirections(int i) {
        return Layout.DIRS_ALL_LEFT_TO_RIGHT;
    }

    public float getLineMax(int i) {
        return mMax;
    }

    public int getLineStart(int i) {
        int j;
        if(i == 0)
            j = 0;
        else
            j = getText().length();
        return j;
    }

    public int getLineTop(int i) {
        int j;
        if(i == 0)
            j = 0;
        else
            j = mBottom;
        return j;
    }

    public int getParagraphDirection(int i) {
        return 1;
    }

    public int getTopPadding() {
        return mTopPadding;
    }

    void init(CharSequence charsequence, TextPaint textpaint, int i, Layout.Alignment alignment, float f, float f1, Metrics metrics, 
            boolean flag, boolean flag1) {
        int j;
        if((charsequence instanceof String) && alignment == Layout.Alignment.ALIGN_NORMAL)
            mDirect = charsequence.toString();
        else
            mDirect = null;
        mPaint = textpaint;
        if(flag)
            j = ((android.graphics.Paint.FontMetricsInt) (metrics)).bottom - ((android.graphics.Paint.FontMetricsInt) (metrics)).top;
        else
            j = ((android.graphics.Paint.FontMetricsInt) (metrics)).descent - ((android.graphics.Paint.FontMetricsInt) (metrics)).ascent;
        if(f != 1.0F || f1 != 0.0F)
            j = (int)(0.5F + (f1 + f * (float)j));
        mBottom = j;
        if(flag)
            mDesc = j + ((android.graphics.Paint.FontMetricsInt) (metrics)).top;
        else
            mDesc = j + ((android.graphics.Paint.FontMetricsInt) (metrics)).ascent;
        if(flag1) {
            mMax = metrics.width;
        } else {
            TextLine textline = TextLine.obtain();
            textline.set(textpaint, charsequence, 0, charsequence.length(), 1, Layout.DIRS_ALL_LEFT_TO_RIGHT, false, null);
            mMax = (int)FloatMath.ceil(textline.metrics(null));
            TextLine.recycle(textline);
        }
        if(flag) {
            mTopPadding = ((android.graphics.Paint.FontMetricsInt) (metrics)).top - ((android.graphics.Paint.FontMetricsInt) (metrics)).ascent;
            mBottomPadding = ((android.graphics.Paint.FontMetricsInt) (metrics)).bottom - ((android.graphics.Paint.FontMetricsInt) (metrics)).descent;
        }
    }

    public BoringLayout replaceOrMake(CharSequence charsequence, TextPaint textpaint, int i, Layout.Alignment alignment, float f, float f1, Metrics metrics, 
            boolean flag) {
        replaceWith(charsequence, textpaint, i, alignment, f, f1);
        mEllipsizedWidth = i;
        mEllipsizedStart = 0;
        mEllipsizedCount = 0;
        init(charsequence, textpaint, i, alignment, f, f1, metrics, flag, true);
        return this;
    }

    public BoringLayout replaceOrMake(CharSequence charsequence, TextPaint textpaint, int i, Layout.Alignment alignment, float f, float f1, Metrics metrics, 
            boolean flag, TextUtils.TruncateAt truncateat, int j) {
        boolean flag1;
        if(truncateat == null || truncateat == TextUtils.TruncateAt.MARQUEE) {
            replaceWith(charsequence, textpaint, i, alignment, f, f1);
            mEllipsizedWidth = i;
            mEllipsizedStart = 0;
            mEllipsizedCount = 0;
            flag1 = true;
        } else {
            replaceWith(TextUtils.ellipsize(charsequence, textpaint, j, truncateat, true, this), textpaint, i, alignment, f, f1);
            mEllipsizedWidth = j;
            flag1 = false;
        }
        init(getText(), textpaint, i, alignment, f, f1, metrics, flag, flag1);
        return this;
    }

    private static final char FIRST_RIGHT_TO_LEFT = 1424;
    private static final TextPaint sTemp = new TextPaint();
    int mBottom;
    private int mBottomPadding;
    int mDesc;
    private String mDirect;
    private int mEllipsizedCount;
    private int mEllipsizedStart;
    private int mEllipsizedWidth;
    private float mMax;
    private Paint mPaint;
    private int mTopPadding;

}
