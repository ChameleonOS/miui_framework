// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text;

import android.emoji.EmojiFactory;
import android.graphics.*;
import android.text.style.CharacterStyle;
import android.text.style.MetricAffectingSpan;
import android.text.style.ReplacementSpan;
import com.android.internal.util.ArrayUtils;

// Referenced classes of package android.text:
//            TextPaint, SpanSet, TextUtils, Spanned, 
//            Layout

class TextLine {

    TextLine() {
    }

    private float drawRun(Canvas canvas, int i, int j, boolean flag, float f, int k, int l, 
            int i1, boolean flag1) {
        boolean flag2;
        float f1;
        if(mDir == 1)
            flag2 = true;
        else
            flag2 = false;
        if(flag2 == flag) {
            f1 = -measureRun(i, j, j, flag, null);
            handleRun(i, j, j, flag, canvas, f + f1, k, l, i1, null, false);
        } else {
            f1 = handleRun(i, j, j, flag, canvas, f, k, l, i1, null, flag1);
        }
        return f1;
    }

    private void drawTextRun(Canvas canvas, TextPaint textpaint, int i, int j, int k, int l, boolean flag, 
            float f, int i1) {
        int j1;
        if(flag)
            j1 = 1;
        else
            j1 = 0;
        if(mCharsValid) {
            int l1 = j - i;
            int i2 = l - k;
            canvas.drawTextRun(mChars, i, l1, k, i2, f, i1, j1, textpaint);
        } else {
            int k1 = mStart;
            canvas.drawTextRun(mText, k1 + i, k1 + j, k1 + k, k1 + l, f, i1, j1, textpaint);
        }
    }

    private static void expandMetricsFromPaint(android.graphics.Paint.FontMetricsInt fontmetricsint, TextPaint textpaint) {
        int i = fontmetricsint.top;
        int j = fontmetricsint.ascent;
        int k = fontmetricsint.descent;
        int l = fontmetricsint.bottom;
        int i1 = fontmetricsint.leading;
        textpaint.getFontMetricsInt(fontmetricsint);
        updateMetrics(fontmetricsint, i, j, k, l, i1);
    }

    private int getOffsetBeforeAfter(int i, int j, int k, boolean flag, int l, boolean flag1) {
        if(i < 0) goto _L2; else goto _L1
_L1:
        int i1;
        int j1;
        if(flag1)
            j1 = mLen;
        else
            j1 = 0;
        if(l != j1) goto _L3; else goto _L2
_L2:
        if(flag1)
            i1 = TextUtils.getOffsetAfter(mText, l + mStart) - mStart;
        else
            i1 = TextUtils.getOffsetBefore(mText, l + mStart) - mStart;
_L10:
        return i1;
_L3:
        TextPaint textpaint;
        int k1;
        textpaint = mWorkPaint;
        textpaint.set(mPaint);
        k1 = j;
        if(mSpanned != null) goto _L5; else goto _L4
_L4:
        i1 = k;
_L6:
        int l1;
        int i2;
        MetricAffectingSpan ametricaffectingspan[];
        ReplacementSpan replacementspan;
        int j2;
        int k2;
        int l2;
        int i3;
        MetricAffectingSpan metricaffectingspan;
        if(flag)
            l2 = 1;
        else
            l2 = 0;
        if(flag1)
            i3 = 0;
        else
            i3 = 2;
        if(mCharsValid) {
            i1 = textpaint.getTextRunCursor(mChars, k1, i1 - k1, l2, l, i3);
        } else {
            CharSequence charsequence = mText;
            int j3 = k1 + mStart;
            int k3 = i1 + mStart;
            int l3 = l + mStart;
            i1 = textpaint.getTextRunCursor(charsequence, j3, k3, l2, l3, i3) - mStart;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if(flag1)
            l1 = l + 1;
        else
            l1 = l;
        i2 = k + mStart;
_L7:
label0:
        {
            i1 = mSpanned.nextSpanTransition(k1 + mStart, i2, android/text/style/MetricAffectingSpan) - mStart;
            if(i1 < l1)
                break label0;
            ametricaffectingspan = (MetricAffectingSpan[])TextUtils.removeEmptySpans((MetricAffectingSpan[])mSpanned.getSpans(k1 + mStart, i1 + mStart, android/text/style/MetricAffectingSpan), mSpanned, android/text/style/MetricAffectingSpan);
            if(ametricaffectingspan.length > 0) {
                replacementspan = null;
                j2 = 0;
                do {
                    k2 = ametricaffectingspan.length;
                    if(j2 >= k2)
                        continue; /* Loop/switch isn't completed */
                    metricaffectingspan = ametricaffectingspan[j2];
                    if(metricaffectingspan instanceof ReplacementSpan)
                        replacementspan = (ReplacementSpan)metricaffectingspan;
                    else
                        metricaffectingspan.updateMeasureState(textpaint);
                    j2++;
                } while(true);
            }
        }
          goto _L6
        k1 = i1;
          goto _L7
        if(replacementspan == null) goto _L6; else goto _L8
_L8:
        if(!flag1)
            i1 = k1;
        if(true) goto _L10; else goto _L9
_L9:
    }

    private float handleReplacement(ReplacementSpan replacementspan, TextPaint textpaint, int i, int j, boolean flag, Canvas canvas, float f, 
            int k, int l, int i1, android.graphics.Paint.FontMetricsInt fontmetricsint, boolean flag1) {
        float f1 = 0.0F;
        int j1 = i + mStart;
        int k1 = j + mStart;
        if(flag1 || canvas != null && flag) {
            int l1 = 0;
            int i2 = 0;
            int j2 = 0;
            int k2 = 0;
            int l2 = 0;
            boolean flag2;
            if(fontmetricsint != null)
                flag2 = true;
            else
                flag2 = false;
            if(flag2) {
                l1 = fontmetricsint.top;
                i2 = fontmetricsint.ascent;
                j2 = fontmetricsint.descent;
                k2 = fontmetricsint.bottom;
                l2 = fontmetricsint.leading;
            }
            f1 = replacementspan.getSize(textpaint, mText, j1, k1, fontmetricsint);
            if(flag2)
                updateMetrics(fontmetricsint, l1, i2, j2, k2, l2);
        }
        if(canvas != null) {
            if(flag)
                f -= f1;
            replacementspan.draw(canvas, mText, j1, k1, f, k, l, i1, textpaint);
        }
        if(flag)
            f1 = -f1;
        return f1;
    }

    private float handleRun(int i, int j, int k, boolean flag, Canvas canvas, float f, int l, 
            int i1, int j1, android.graphics.Paint.FontMetricsInt fontmetricsint, boolean flag1) {
        float f2;
        if(i == j) {
            TextPaint textpaint2 = mWorkPaint;
            textpaint2.set(mPaint);
            if(fontmetricsint != null)
                expandMetricsFromPaint(fontmetricsint, textpaint2);
            f2 = 0.0F;
        } else
        if(mSpanned == null) {
            TextPaint textpaint1 = mWorkPaint;
            textpaint1.set(mPaint);
            boolean flag5;
            if(flag1 || j < j)
                flag5 = true;
            else
                flag5 = false;
            f2 = handleText(textpaint1, i, j, i, k, flag, canvas, f, l, i1, j1, fontmetricsint, flag5);
        } else {
            mMetricAffectingSpanSpanSet.init(mSpanned, i + mStart, k + mStart);
            mCharacterStyleSpanSet.init(mSpanned, i + mStart, k + mStart);
            float f1 = f;
            int k1 = i;
            while(k1 < j)  {
                TextPaint textpaint = mWorkPaint;
                textpaint.set(mPaint);
                int l1 = mMetricAffectingSpanSpanSet.getNextTransition(k1 + mStart, k + mStart) - mStart;
                int i2 = Math.min(l1, j);
                ReplacementSpan replacementspan = null;
                int j2 = 0;
                do {
                    int k2 = mMetricAffectingSpanSpanSet.numberOfSpans;
                    if(j2 >= k2)
                        break;
                    if(mMetricAffectingSpanSpanSet.spanStarts[j2] < i2 + mStart && mMetricAffectingSpanSpanSet.spanEnds[j2] > k1 + mStart) {
                        MetricAffectingSpan metricaffectingspan = ((MetricAffectingSpan[])mMetricAffectingSpanSpanSet.spans)[j2];
                        if(metricaffectingspan instanceof ReplacementSpan)
                            replacementspan = (ReplacementSpan)metricaffectingspan;
                        else
                            metricaffectingspan.updateDrawState(textpaint);
                    }
                    j2++;
                } while(true);
                if(replacementspan != null) {
                    boolean flag4;
                    if(flag1 || i2 < j)
                        flag4 = true;
                    else
                        flag4 = false;
                    f += handleReplacement(replacementspan, textpaint, k1, i2, flag, canvas, f, l, i1, j1, fontmetricsint, flag4);
                    int _tmp = j2;
                } else
                if(canvas == null) {
                    boolean flag3;
                    if(flag1 || i2 < j)
                        flag3 = true;
                    else
                        flag3 = false;
                    f += handleText(textpaint, k1, i2, k1, l1, flag, canvas, f, l, i1, j1, fontmetricsint, flag3);
                    int _tmp1 = j2;
                } else {
                    int l2 = k1;
                    while(l2 < i2)  {
                        int i3 = mCharacterStyleSpanSet.getNextTransition(l2 + mStart, i2 + mStart) - mStart;
                        textpaint.set(mPaint);
                        int j3 = 0;
                        do {
                            int k3 = mCharacterStyleSpanSet.numberOfSpans;
                            if(j3 >= k3)
                                break;
                            if(mCharacterStyleSpanSet.spanStarts[j3] < i3 + mStart && mCharacterStyleSpanSet.spanEnds[j3] > l2 + mStart)
                                ((CharacterStyle[])mCharacterStyleSpanSet.spans)[j3].updateDrawState(textpaint);
                            j3++;
                        } while(true);
                        boolean flag2;
                        if(flag1 || i3 < j)
                            flag2 = true;
                        else
                            flag2 = false;
                        f += handleText(textpaint, l2, i3, k1, l1, flag, canvas, f, l, i1, j1, fontmetricsint, flag2);
                        l2 = i3;
                    }
                }
                k1 = l1;
            }
            f2 = f - f1;
        }
        return f2;
    }

    private float handleText(TextPaint textpaint, int i, int j, int k, int l, boolean flag, Canvas canvas, 
            float f, int i1, int j1, int k1, android.graphics.Paint.FontMetricsInt fontmetricsint, boolean flag1) {
        int l1;
        if(fontmetricsint != null)
            expandMetricsFromPaint(fontmetricsint, textpaint);
        l1 = j - i;
        if(l1 != 0) goto _L2; else goto _L1
_L1:
        float f1 = 0.0F;
_L4:
        return f1;
_L2:
        f1 = 0.0F;
        int i2 = l - k;
        if(flag1 || canvas != null && (textpaint.bgColor != 0 || textpaint.underlineColor != 0 || flag)) {
            int j2;
            int l2;
            float f2;
            int i3;
            android.graphics.Paint.Style style;
            boolean flag2;
            float f3;
            float f4;
            int j3;
            android.graphics.Paint.Style style1;
            float f5;
            float f6;
            float f7;
            if(flag)
                j2 = 1;
            else
                j2 = 0;
            if(mCharsValid) {
                f1 = textpaint.getTextRunAdvances(mChars, i, l1, k, i2, j2, null, 0);
            } else {
                int k2 = mStart;
                f1 = textpaint.getTextRunAdvances(mText, k2 + i, k2 + j, k2 + k, k2 + l, j2, null, 0);
            }
        }
        if(canvas != null) {
            if(flag)
                f -= f1;
            if(textpaint.bgColor != 0) {
                j3 = textpaint.getColor();
                style1 = textpaint.getStyle();
                textpaint.setColor(textpaint.bgColor);
                textpaint.setStyle(android.graphics.Paint.Style.FILL);
                f5 = i1;
                f6 = f + f1;
                f7 = k1;
                canvas.drawRect(f, f5, f6, f7, textpaint);
                textpaint.setStyle(style1);
                textpaint.setColor(j3);
            }
            if(textpaint.underlineColor != 0) {
                f2 = (float)(j1 + textpaint.baselineShift) + 0.1111111F * textpaint.getTextSize();
                i3 = textpaint.getColor();
                style = textpaint.getStyle();
                flag2 = textpaint.isAntiAlias();
                textpaint.setStyle(android.graphics.Paint.Style.FILL);
                textpaint.setAntiAlias(true);
                textpaint.setColor(textpaint.underlineColor);
                f3 = f + f1;
                f4 = f2 + textpaint.underlineThickness;
                canvas.drawRect(f, f2, f3, f4, textpaint);
                textpaint.setStyle(style);
                textpaint.setColor(i3);
                textpaint.setAntiAlias(flag2);
            }
            l2 = j1 + textpaint.baselineShift;
            drawTextRun(canvas, textpaint, i, j, k, l, flag, f, l2);
        }
        if(flag)
            f1 = -f1;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private float measureRun(int i, int j, int k, boolean flag, android.graphics.Paint.FontMetricsInt fontmetricsint) {
        return handleRun(i, j, k, flag, null, 0.0F, 0, 0, 0, fontmetricsint, true);
    }

    static TextLine obtain() {
        TextLine textline;
        synchronized(sCached) {
            for(int i = sCached.length; --i >= 0;)
                if(sCached[i] != null) {
                    textline = sCached[i];
                    sCached[i] = null;
                    break MISSING_BLOCK_LABEL_61;
                }

        }
        textline = new TextLine();
          goto _L1
        exception;
        atextline;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
        return textline;
    }

    static TextLine recycle(TextLine textline) {
        textline.mText = null;
        textline.mPaint = null;
        textline.mDirections = null;
        textline.mMetricAffectingSpanSpanSet.recycle();
        textline.mCharacterStyleSpanSet.recycle();
        textline.mReplacementSpanSpanSet.recycle();
        TextLine atextline[] = sCached;
        atextline;
        JVM INSTR monitorenter ;
        int i = 0;
        do {
label0:
            {
                if(i < sCached.length) {
                    if(sCached[i] != null)
                        break label0;
                    sCached[i] = textline;
                }
                return null;
            }
            i++;
        } while(true);
    }

    static void updateMetrics(android.graphics.Paint.FontMetricsInt fontmetricsint, int i, int j, int k, int l, int i1) {
        fontmetricsint.top = Math.min(fontmetricsint.top, i);
        fontmetricsint.ascent = Math.min(fontmetricsint.ascent, j);
        fontmetricsint.descent = Math.max(fontmetricsint.descent, k);
        fontmetricsint.bottom = Math.max(fontmetricsint.bottom, l);
        fontmetricsint.leading = Math.max(fontmetricsint.leading, i1);
    }

    float ascent(int i) {
        float f;
        if(mSpanned == null) {
            f = mPaint.ascent();
        } else {
            int j = i + mStart;
            MetricAffectingSpan ametricaffectingspan[] = (MetricAffectingSpan[])mSpanned.getSpans(j, j + 1, android/text/style/MetricAffectingSpan);
            if(ametricaffectingspan.length == 0) {
                f = mPaint.ascent();
            } else {
                TextPaint textpaint = mWorkPaint;
                textpaint.set(mPaint);
                int k = ametricaffectingspan.length;
                for(int l = 0; l < k; l++)
                    ametricaffectingspan[l].updateMeasureState(textpaint);

                f = textpaint.ascent();
            }
        }
        return f;
    }

    void draw(Canvas canvas, float f, int i, int j, int k) {
        if(mHasTabs) goto _L2; else goto _L1
_L1:
        if(mDirections != Layout.DIRS_ALL_LEFT_TO_RIGHT) goto _L4; else goto _L3
_L3:
        drawRun(canvas, 0, mLen, false, f, i, j, k, false);
_L5:
        return;
_L4:
        if(mDirections != Layout.DIRS_ALL_RIGHT_TO_LEFT)
            break; /* Loop/switch isn't completed */
        drawRun(canvas, 0, mLen, true, f, i, j, k, false);
        if(true) goto _L5; else goto _L2
_L2:
        float f1;
        int ai[];
        RectF rectf;
        int l;
        int i1;
        f1 = 0.0F;
        ai = mDirections.mDirections;
        rectf = null;
        l = -2 + ai.length;
        i1 = 0;
_L15:
        int j1 = ai.length;
        if(i1 >= j1) goto _L5; else goto _L6
_L6:
        int k2;
        int l2;
        Bitmap bitmap;
        int k1 = ai[i1];
        int l1 = k1 + (0x3ffffff & ai[i1 + 1]);
        int i2 = mLen;
        if(l1 > i2)
            l1 = mLen;
        boolean flag;
        int j2;
        float f2;
        if((0x4000000 & ai[i1 + 1]) != 0)
            flag = true;
        else
            flag = false;
        j2 = k1;
        if(mHasTabs)
            k2 = k1;
        else
            k2 = l1;
        if(k2 > l1)
            break MISSING_BLOCK_LABEL_541;
        l2 = 0;
        bitmap = null;
        if(!mHasTabs || k2 >= l1) goto _L8; else goto _L7
_L7:
        l2 = mChars[k2];
        if(l2 < 55296 || l2 >= 56320 || k2 + 1 >= l1) goto _L8; else goto _L9
_L9:
        l2 = Character.codePointAt(mChars, k2);
        if(l2 < Layout.MIN_EMOJI || l2 > Layout.MAX_EMOJI) goto _L11; else goto _L10
_L10:
        bitmap = Layout.EMOJI_FACTORY.getBitmapFromAndroidPua(l2);
_L8:
        if(k2 == l1 || l2 == 9 || bitmap != null) {
            f2 = f + f1;
            boolean flag1;
            if(i1 != l || k2 != mLen)
                flag1 = true;
            else
                flag1 = false;
            f1 += drawRun(canvas, j2, k2, flag, f2, i, j, k, flag1);
            if(l2 == 9)
                f1 = (float)mDir * nextTab(f1 * (float)mDir);
            else
            if(bitmap != null) {
                float f3 = ascent(k2);
                float f4 = bitmap.getHeight();
                float f5 = (-f3 / f4) * (float)bitmap.getWidth();
                if(rectf == null)
                    rectf = new RectF();
                float f6 = f + f1;
                float f7 = f3 + (float)j;
                float f8 = f5 + (f + f1);
                float f9 = j;
                rectf.set(f6, f7, f8, f9);
                TextPaint textpaint = mPaint;
                canvas.drawBitmap(bitmap, null, rectf, textpaint);
                f1 += f5;
                k2++;
            }
            j2 = k2 + 1;
        }
_L13:
        k2++;
        break MISSING_BLOCK_LABEL_181;
_L11:
        if(l2 <= 65535)
            break; /* Loop/switch isn't completed */
        k2++;
        if(true) goto _L13; else goto _L12
_L12:
        if(true) goto _L8; else goto _L14
_L14:
        i1 += 2;
          goto _L15
    }

    int getOffsetToLeftRightOf(int i, boolean flag) {
        int j;
        int ai[];
        int k;
        int l;
        int i1;
        int j1;
        boolean flag2;
        int k1;
        boolean flag5;
        j = mLen;
        boolean flag1;
        int k2;
        if(mDir == -1)
            flag1 = true;
        else
            flag1 = false;
        ai = mDirections.mDirections;
        k = 0;
        l = 0;
        i1 = j;
        j1 = -1;
        flag2 = false;
        if(i == 0) {
            k1 = -2;
        } else {
label0:
            {
                if(i != j)
                    break label0;
                k1 = ai.length;
            }
        }
        break MISSING_BLOCK_LABEL_50;
        k1 = 0;
_L11:
        if(k1 >= ai.length)
            continue; /* Loop/switch isn't completed */
        l = 0 + ai[k1];
        if(i < l) goto _L2; else goto _L1
_L1:
        i1 = l + (0x3ffffff & ai[k1 + 1]);
        if(i1 > j)
            i1 = j;
        if(i >= i1) goto _L2; else goto _L3
_L3:
        k = 0x3f & ai[k1 + 1] >>> 26;
        if(i != l)
            continue; /* Loop/switch isn't completed */
        l3 = i - 1;
        i4 = 0;
_L10:
        int j4 = ai.length;
        if(i4 >= j4)
            continue; /* Loop/switch isn't completed */
        k4 = 0 + ai[i4];
        if(l3 < k4) goto _L5; else goto _L4
_L4:
        l4 = k4 + (0x3ffffff & ai[i4 + 1]);
        if(l4 > j)
            l4 = j;
        if(l3 >= l4) goto _L5; else goto _L6
_L6:
        i5 = 0x3f & ai[i4 + 1] >>> 26;
        if(i5 >= k) goto _L5; else goto _L7
_L7:
        k1 = i4;
        k = i5;
        l = k4;
        i1 = l4;
        flag2 = true;
        if(k1 == ai.length) goto _L9; else goto _L8
_L8:
        boolean flag3;
        boolean flag4;
        int l1;
        int i2;
        if((k & 1) != 0)
            flag3 = true;
        else
            flag3 = false;
        if(flag == flag3)
            flag4 = true;
        else
            flag4 = false;
        if(flag4)
            l1 = i1;
        else
            l1 = l;
        if(i == l1 && flag4 == flag2)
            continue;
        j1 = getOffsetBeforeAfter(k1, l, i1, flag3, i, flag4);
        if(flag4)
            i2 = i1;
        else
            i2 = l;
        if(j1 == i2)
            continue;
        j2 = j1;
_L12:
        return j2;
_L5:
        i4 += 2;
          goto _L10
_L2:
        k1 += 2;
          goto _L11
_L9:
        int j2;
        int l2;
        int i3;
        int j3;
        boolean flag7;
        do {
            byte byte0;
            boolean flag6;
            int k3;
            int l3;
            int i4;
            int k4;
            int l4;
            int i5;
            if(flag == flag1)
                flag5 = true;
            else
                flag5 = false;
            if(flag5)
                byte0 = 2;
            else
                byte0 = -2;
            k2 = k1 + byte0;
            if(k2 < 0 || k2 >= ai.length)
                break MISSING_BLOCK_LABEL_614;
            l2 = 0 + ai[k2];
            i3 = l2 + (0x3ffffff & ai[k2 + 1]);
            if(i3 > j)
                i3 = j;
            j3 = 0x3f & ai[k2 + 1] >>> 26;
            if((j3 & 1) != 0)
                flag6 = true;
            else
                flag6 = false;
            if(flag == flag6)
                flag7 = true;
            else
                flag7 = false;
            if(j1 != -1)
                break;
            if(flag7)
                k3 = l2;
            else
                k3 = i3;
            j1 = getOffsetBeforeAfter(k2, l2, i3, flag6, k3, flag7);
            if(!flag7)
                i3 = l2;
            if(j1 != i3)
                break MISSING_BLOCK_LABEL_600;
            k1 = k2;
            k = j3;
        } while(true);
        if(j3 < k)
            if(flag7)
                j1 = l2;
            else
                j1 = i3;
_L13:
        j2 = j1;
          goto _L12
        if(j1 == -1) {
            if(flag5)
                j1 = 1 + mLen;
            else
                j1 = -1;
        } else
        if(j1 <= j)
            if(flag5)
                j1 = j;
            else
                j1 = 0;
          goto _L13
    }

    float measure(int i, boolean flag, android.graphics.Paint.FontMetricsInt fontmetricsint) {
        int j;
        float f;
        if(flag)
            j = i - 1;
        else
            j = i;
        if(j < 0) {
            f = 0.0F;
        } else {
label0:
            {
                f = 0.0F;
                if(mHasTabs)
                    break label0;
                if(mDirections == Layout.DIRS_ALL_LEFT_TO_RIGHT) {
                    f = measureRun(0, i, mLen, false, fontmetricsint);
                } else {
                    if(mDirections != Layout.DIRS_ALL_RIGHT_TO_LEFT)
                        break label0;
                    f = measureRun(0, i, mLen, true, fontmetricsint);
                }
            }
        }
_L2:
        return f;
        char ac[];
        int ai[];
        int k;
        ac = mChars;
        ai = mDirections.mDirections;
        k = 0;
_L13:
        if(k >= ai.length) goto _L2; else goto _L1
_L1:
        boolean flag1;
        int j1;
        int k1;
        int l1;
        Bitmap bitmap;
        int l = ai[k];
        int i1 = l + (0x3ffffff & ai[k + 1]);
        if(i1 > mLen)
            i1 = mLen;
        if((0x4000000 & ai[k + 1]) != 0)
            flag1 = true;
        else
            flag1 = false;
        j1 = l;
        if(mHasTabs)
            k1 = l;
        else
            k1 = i1;
_L9:
        if(k1 > i1)
            break MISSING_BLOCK_LABEL_569;
        l1 = 0;
        bitmap = null;
        if(!mHasTabs || k1 >= i1) goto _L4; else goto _L3
_L3:
        l1 = ac[k1];
        if(l1 < 55296 || l1 >= 56320 || k1 + 1 >= i1) goto _L4; else goto _L5
_L5:
        l1 = Character.codePointAt(ac, k1);
        if(l1 < Layout.MIN_EMOJI || l1 > Layout.MAX_EMOJI) goto _L7; else goto _L6
_L6:
        bitmap = Layout.EMOJI_FACTORY.getBitmapFromAndroidPua(l1);
_L4:
        if(k1 != i1 && l1 != 9 && bitmap == null)
            break MISSING_BLOCK_LABEL_392;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        if(j >= j1 && j < k1)
            flag2 = true;
        else
            flag2 = false;
        if(mDir == -1)
            flag3 = true;
        else
            flag3 = false;
        if(flag3 == flag1)
            flag4 = true;
        else
            flag4 = false;
        if(flag2 && flag4) {
            f += measureRun(j1, i, k1, flag1, fontmetricsint);
        } else {
label1:
            {
                float f1 = measureRun(j1, k1, k1, flag1, fontmetricsint);
                if(!flag4)
                    f1 = -f1;
                f += f1;
                if(!flag2)
                    break label1;
                f += measureRun(j1, i, k1, flag1, null);
            }
        }
          goto _L2
_L7:
        if(l1 <= 65535) goto _L4; else goto _L8
_L8:
        k1++;
_L12:
        k1++;
          goto _L9
        if(l1 != 9)
            break; /* Loop/switch isn't completed */
        if(i == k1) goto _L2; else goto _L10
_L10:
        f = (float)mDir * nextTab(f * (float)mDir);
        if(j == k1) goto _L2; else goto _L11
_L11:
        if(bitmap != null) {
            float f2 = ascent(k1);
            f += (((float)bitmap.getWidth() * -f2) / (float)bitmap.getHeight()) * (float)mDir;
            k1++;
        }
        j1 = k1 + 1;
          goto _L12
        k += 2;
          goto _L13
    }

    float metrics(android.graphics.Paint.FontMetricsInt fontmetricsint) {
        return measure(mLen, false, fontmetricsint);
    }

    float nextTab(float f) {
        float f1;
        if(mTabs != null)
            f1 = mTabs.nextTab(f);
        else
            f1 = Layout.TabStops.nextDefaultStop(f, 20);
        return f1;
    }

    void set(TextPaint textpaint, CharSequence charsequence, int i, int j, int k, Layout.Directions directions, boolean flag, 
            Layout.TabStops tabstops) {
        mPaint = textpaint;
        mText = charsequence;
        mStart = i;
        mLen = j - i;
        mDir = k;
        mDirections = directions;
        if(mDirections == null)
            throw new IllegalArgumentException("Directions cannot be null");
        mHasTabs = flag;
        mSpanned = null;
        boolean flag1 = false;
        boolean flag2;
        if(charsequence instanceof Spanned) {
            mSpanned = (Spanned)charsequence;
            mReplacementSpanSpanSet.init(mSpanned, i, j);
            char ac[];
            int j1;
            int k1;
            if(mReplacementSpanSpanSet.numberOfSpans > 0)
                flag1 = true;
            else
                flag1 = false;
        }
        if(flag1 || flag || directions != Layout.DIRS_ALL_LEFT_TO_RIGHT)
            flag2 = true;
        else
            flag2 = false;
        mCharsValid = flag2;
        if(mCharsValid) {
            if(mChars == null || mChars.length < mLen)
                mChars = new char[ArrayUtils.idealCharArraySize(mLen)];
            TextUtils.getChars(charsequence, i, j, mChars, 0);
            if(flag1) {
                ac = mChars;
                int i1;
                for(int l = i; l < j; l = i1) {
                    i1 = mReplacementSpanSpanSet.getNextTransition(l, j);
                    if(!mReplacementSpanSpanSet.hasSpansIntersecting(l, i1))
                        continue;
                    ac[l - i] = '\uFFFC';
                    j1 = 1 + (l - i);
                    for(k1 = i1 - i; j1 < k1; j1++)
                        ac[j1] = '\uFEFF';

                }

            }
        }
        mTabs = tabstops;
    }

    private static final boolean DEBUG = false;
    private static final int TAB_INCREMENT = 20;
    private static final TextLine sCached[] = new TextLine[3];
    private final SpanSet mCharacterStyleSpanSet = new SpanSet(android/text/style/CharacterStyle);
    private char mChars[];
    private boolean mCharsValid;
    private int mDir;
    private Layout.Directions mDirections;
    private boolean mHasTabs;
    private int mLen;
    private final SpanSet mMetricAffectingSpanSpanSet = new SpanSet(android/text/style/MetricAffectingSpan);
    private TextPaint mPaint;
    private final SpanSet mReplacementSpanSpanSet = new SpanSet(android/text/style/ReplacementSpan);
    private Spanned mSpanned;
    private int mStart;
    private Layout.TabStops mTabs;
    private CharSequence mText;
    private final TextPaint mWorkPaint = new TextPaint();

}
