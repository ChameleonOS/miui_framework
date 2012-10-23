// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text;

import android.text.style.MetricAffectingSpan;
import android.text.style.ReplacementSpan;
import com.android.internal.util.ArrayUtils;

// Referenced classes of package android.text:
//            TextPaint, TextUtils, Spanned, TextDirectionHeuristics, 
//            AndroidBidi, TextDirectionHeuristic

class MeasuredText {

    private MeasuredText() {
        mWorkPaint = new TextPaint();
    }

    static MeasuredText obtain() {
        MeasuredText measuredtext;
        synchronized(sLock) {
            for(int i = sCached.length; --i >= 0;)
                if(sCached[i] != null) {
                    measuredtext = sCached[i];
                    sCached[i] = null;
                    break MISSING_BLOCK_LABEL_61;
                }

        }
        measuredtext = new MeasuredText();
          goto _L1
        exception;
        aobj;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
        return measuredtext;
    }

    static MeasuredText recycle(MeasuredText measuredtext) {
        measuredtext.mText = null;
        if(measuredtext.mLen >= 1000) goto _L2; else goto _L1
_L1:
        Object aobj[] = sLock;
        aobj;
        JVM INSTR monitorenter ;
        int i = 0;
_L8:
        if(i >= sCached.length) goto _L4; else goto _L3
_L3:
        if(sCached[i] != null) goto _L6; else goto _L5
_L5:
        sCached[i] = measuredtext;
        measuredtext.mText = null;
_L4:
        aobj;
        JVM INSTR monitorexit ;
_L2:
        return null;
_L6:
        i++;
        if(true) goto _L8; else goto _L7
_L7:
    }

    float addStyleRun(TextPaint textpaint, int i, android.graphics.Paint.FontMetricsInt fontmetricsint) {
        int j;
        if(fontmetricsint != null)
            textpaint.getFontMetricsInt(fontmetricsint);
        j = mPos;
        mPos = j + i;
        if(!mEasy) goto _L2; else goto _L1
_L1:
        float f;
        int i2;
        if(mDir == 1)
            i2 = 0;
        else
            i2 = 1;
        f = textpaint.getTextRunAdvances(mChars, j, i, j, i, i2, mWidths, j);
_L4:
        return f;
_L2:
        byte byte0;
        int k;
        int l;
        int i1;
        f = 0.0F;
        byte0 = mLevels[j];
        k = j;
        l = j + 1;
        i1 = j + i;
_L5:
        if(l != i1 && mLevels[l] == byte0)
            break MISSING_BLOCK_LABEL_203;
        int j1;
        char ac[];
        int k1;
        int l1;
        float af[];
        if((byte0 & 1) == 0)
            j1 = 0;
        else
            j1 = 1;
        ac = mChars;
        k1 = l - k;
        l1 = l - k;
        af = mWidths;
        f += textpaint.getTextRunAdvances(ac, k, k1, k, l1, j1, af, k);
        if(l == i1) goto _L4; else goto _L3
_L3:
        k = l;
        byte0 = mLevels[l];
        l++;
          goto _L5
    }

    float addStyleRun(TextPaint textpaint, MetricAffectingSpan ametricaffectingspan[], int i, android.graphics.Paint.FontMetricsInt fontmetricsint) {
        TextPaint textpaint1 = mWorkPaint;
        textpaint1.set(textpaint);
        textpaint1.baselineShift = 0;
        ReplacementSpan replacementspan = null;
        int j = 0;
        while(j < ametricaffectingspan.length)  {
            MetricAffectingSpan metricaffectingspan = ametricaffectingspan[j];
            if(metricaffectingspan instanceof ReplacementSpan)
                replacementspan = (ReplacementSpan)metricaffectingspan;
            else
                metricaffectingspan.updateMeasureState(textpaint1);
            j++;
        }
        float f;
        if(replacementspan == null) {
            f = addStyleRun(textpaint1, i, fontmetricsint);
        } else {
            f = replacementspan.getSize(textpaint1, mText, mTextStart + mPos, i + (mTextStart + mPos), fontmetricsint);
            float af[] = mWidths;
            af[mPos] = f;
            int k = 1 + mPos;
            for(int l = i + mPos; k < l; k++)
                af[k] = 0.0F;

            mPos = i + mPos;
        }
        if(fontmetricsint != null)
            if(textpaint1.baselineShift < 0) {
                fontmetricsint.ascent = fontmetricsint.ascent + textpaint1.baselineShift;
                fontmetricsint.top = fontmetricsint.top + textpaint1.baselineShift;
            } else {
                fontmetricsint.descent = fontmetricsint.descent + textpaint1.baselineShift;
                fontmetricsint.bottom = fontmetricsint.bottom + textpaint1.baselineShift;
            }
        return f;
    }

    int breakText(int i, boolean flag, float f) {
        float af[] = mWidths;
        if(!flag) goto _L2; else goto _L1
_L1:
        int k;
        int l = 0;
label0:
        do {
label1:
            {
                if(l < i) {
                    f -= af[l];
                    if(f >= 0.0F)
                        break label1;
                }
                for(; l > 0 && mChars[l - 1] == ' '; l--);
                break label0;
            }
            l++;
        } while(true);
        k = l;
_L4:
        return k;
_L2:
        int j = i - 1;
label2:
        do {
label3:
            {
                if(j >= 0) {
                    f -= af[j];
                    if(f >= 0.0F)
                        break label3;
                }
                for(; j < i - 1 && mChars[j + 1] == ' '; j++);
                break label2;
            }
            j--;
        } while(true);
        k = -1 + (i - j);
        if(true) goto _L4; else goto _L3
_L3:
    }

    float measure(int i, int j) {
        float f = 0.0F;
        float af[] = mWidths;
        for(int k = i; k < j; k++)
            f += af[k];

        return f;
    }

    void setPara(CharSequence charsequence, int i, int j, TextDirectionHeuristic textdirectionheuristic) {
        int k;
        mText = charsequence;
        mTextStart = i;
        k = j - i;
        mLen = k;
        mPos = 0;
        if(mWidths == null || mWidths.length < k)
            mWidths = new float[ArrayUtils.idealFloatArraySize(k)];
        if(mChars == null || mChars.length < k)
            mChars = new char[ArrayUtils.idealCharArraySize(k)];
        TextUtils.getChars(charsequence, i, j, mChars, 0);
        if(charsequence instanceof Spanned) {
            Spanned spanned = (Spanned)charsequence;
            ReplacementSpan areplacementspan[] = (ReplacementSpan[])spanned.getSpans(i, j, android/text/style/ReplacementSpan);
            for(int i1 = 0; i1 < areplacementspan.length; i1++) {
                int j1 = spanned.getSpanStart(areplacementspan[i1]) - i;
                int k1 = spanned.getSpanEnd(areplacementspan[i1]) - i;
                if(j1 < 0)
                    j1 = 0;
                if(k1 > k)
                    k1 = k;
                for(int l1 = j1; l1 < k1; l1++)
                    mChars[l1] = '\uFFFC';

            }

        }
        if(textdirectionheuristic != TextDirectionHeuristics.LTR && textdirectionheuristic != TextDirectionHeuristics.FIRSTSTRONG_LTR && textdirectionheuristic != TextDirectionHeuristics.ANYRTL_LTR || !TextUtils.doesNotNeedBidi(mChars, 0, k)) goto _L2; else goto _L1
_L1:
        mDir = 1;
        mEasy = true;
_L4:
        return;
_L2:
        int l;
        if(mLevels == null || mLevels.length < k)
            mLevels = new byte[ArrayUtils.idealByteArraySize(k)];
        if(textdirectionheuristic != TextDirectionHeuristics.LTR)
            break; /* Loop/switch isn't completed */
        l = 1;
_L5:
        mDir = AndroidBidi.bidi(l, mChars, mLevels, k, false);
        mEasy = false;
        if(true) goto _L4; else goto _L3
_L3:
        if(textdirectionheuristic == TextDirectionHeuristics.RTL)
            l = -1;
        else
        if(textdirectionheuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR)
            l = 2;
        else
        if(textdirectionheuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL)
            l = -2;
        else
        if(textdirectionheuristic.isRtl(mChars, 0, k))
            l = -1;
        else
            l = 1;
          goto _L5
        if(true) goto _L4; else goto _L6
_L6:
    }

    void setPos(int i) {
        mPos = i;
    }

    private static final boolean localLOGV;
    private static MeasuredText sCached[] = new MeasuredText[3];
    private static final Object sLock[] = new Object[0];
    char mChars[];
    int mDir;
    boolean mEasy;
    int mLen;
    byte mLevels[];
    private int mPos;
    CharSequence mText;
    int mTextStart;
    float mWidths[];
    private TextPaint mWorkPaint;

}
