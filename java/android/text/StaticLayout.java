// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text;

import android.emoji.EmojiFactory;
import android.graphics.Bitmap;
import android.text.style.LeadingMarginSpan;
import android.text.style.LineHeightSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.TabStopSpan;
import android.util.Log;
import com.android.internal.util.ArrayUtils;

// Referenced classes of package android.text:
//            Layout, MeasuredText, TextDirectionHeuristics, Spanned, 
//            TextPaint, AndroidBidi, TextUtils, TextDirectionHeuristic

public class StaticLayout extends Layout {

    StaticLayout(CharSequence charsequence) {
        super(charsequence, null, 0, null, 0.0F, 0.0F);
        mMaximumVisibleLineCount = 0x7fffffff;
        mFontMetricsInt = new android.graphics.Paint.FontMetricsInt();
        mColumns = 5;
        mLines = new int[ArrayUtils.idealIntArraySize(2 * mColumns)];
        mLineDirections = new Layout.Directions[ArrayUtils.idealIntArraySize(2 * mColumns)];
        mMeasured = MeasuredText.obtain();
    }

    public StaticLayout(CharSequence charsequence, int i, int j, TextPaint textpaint, int k, Layout.Alignment alignment, float f, 
            float f1, boolean flag) {
        this(charsequence, i, j, textpaint, k, alignment, f, f1, flag, null, 0);
    }

    public StaticLayout(CharSequence charsequence, int i, int j, TextPaint textpaint, int k, Layout.Alignment alignment, float f, 
            float f1, boolean flag, TextUtils.TruncateAt truncateat, int l) {
        this(charsequence, i, j, textpaint, k, alignment, TextDirectionHeuristics.FIRSTSTRONG_LTR, f, f1, flag, truncateat, l, 0x7fffffff);
    }

    public StaticLayout(CharSequence charsequence, int i, int j, TextPaint textpaint, int k, Layout.Alignment alignment, TextDirectionHeuristic textdirectionheuristic, 
            float f, float f1, boolean flag) {
        this(charsequence, i, j, textpaint, k, alignment, textdirectionheuristic, f, f1, flag, null, 0, 0x7fffffff);
    }

    public StaticLayout(CharSequence charsequence, int i, int j, TextPaint textpaint, int k, Layout.Alignment alignment, TextDirectionHeuristic textdirectionheuristic, 
            float f, float f1, boolean flag, TextUtils.TruncateAt truncateat, int l, int i1) {
        Object obj;
        if(truncateat == null)
            obj = charsequence;
        else
        if(charsequence instanceof Spanned)
            obj = new Layout.SpannedEllipsizer(charsequence);
        else
            obj = new Layout.Ellipsizer(charsequence);
        super(((CharSequence) (obj)), textpaint, k, alignment, textdirectionheuristic, f, f1);
        mMaximumVisibleLineCount = 0x7fffffff;
        mFontMetricsInt = new android.graphics.Paint.FontMetricsInt();
        if(truncateat != null) {
            Layout.Ellipsizer ellipsizer = (Layout.Ellipsizer)getText();
            ellipsizer.mLayout = this;
            ellipsizer.mWidth = l;
            ellipsizer.mMethod = truncateat;
            mEllipsizedWidth = l;
            mColumns = 5;
        } else {
            mColumns = 3;
            mEllipsizedWidth = k;
        }
        mLines = new int[ArrayUtils.idealIntArraySize(2 * mColumns)];
        mLineDirections = new Layout.Directions[ArrayUtils.idealIntArraySize(2 * mColumns)];
        mMaximumVisibleLineCount = i1;
        mMeasured = MeasuredText.obtain();
        generate(charsequence, i, j, textpaint, k, textdirectionheuristic, f, f1, flag, flag, l, truncateat);
        mMeasured = MeasuredText.recycle(mMeasured);
        mFontMetricsInt = null;
    }

    public StaticLayout(CharSequence charsequence, TextPaint textpaint, int i, Layout.Alignment alignment, float f, float f1, boolean flag) {
        this(charsequence, 0, charsequence.length(), textpaint, i, alignment, f, f1, flag);
    }

    public StaticLayout(CharSequence charsequence, TextPaint textpaint, int i, Layout.Alignment alignment, TextDirectionHeuristic textdirectionheuristic, float f, float f1, 
            boolean flag) {
        this(charsequence, 0, charsequence.length(), textpaint, i, alignment, textdirectionheuristic, f, f1, flag);
    }

    private void calculateEllipsis(int i, int j, float af[], int k, float f, TextUtils.TruncateAt truncateat, int l, 
            float f1, TextPaint textpaint, boolean flag) {
        if(f1 > f || flag) goto _L2; else goto _L1
_L1:
        mLines[3 + l * mColumns] = 0;
        mLines[4 + l * mColumns] = 0;
_L10:
        return;
_L2:
        float f2;
        int i1;
        int j1;
        int k1;
        float f11;
        int k2;
        float f12;
        char ac[];
        if(truncateat == TextUtils.TruncateAt.END_SMALL)
            ac = ELLIPSIS_TWO_DOTS;
        else
            ac = ELLIPSIS_NORMAL;
        f2 = textpaint.measureText(ac, 0, 1);
        i1 = 0;
        j1 = 0;
        k1 = j - i;
        if(truncateat != TextUtils.TruncateAt.START) goto _L4; else goto _L3
_L3:
        if(mMaximumVisibleLineCount != 1) goto _L6; else goto _L5
_L5:
        f11 = 0.0F;
        k2 = k1;
_L11:
        if(k2 < 0) goto _L8; else goto _L7
_L7:
        f12 = af[(i + (k2 - 1)) - k];
        if(f2 + (f12 + f11) <= f) goto _L9; else goto _L8
_L8:
        i1 = 0;
        j1 = k2;
_L12:
        mLines[3 + l * mColumns] = i1;
        mLines[4 + l * mColumns] = j1;
          goto _L10
_L9:
        f11 += f12;
        k2--;
          goto _L11
_L6:
        if(Log.isLoggable("StaticLayout", 5))
            Log.w("StaticLayout", "Start Ellipsis only supported with one line");
          goto _L12
_L4:
        float f3;
        int l1;
        if(truncateat != TextUtils.TruncateAt.END && truncateat != TextUtils.TruncateAt.MARQUEE && truncateat != TextUtils.TruncateAt.END_SMALL)
            break MISSING_BLOCK_LABEL_330;
        f3 = 0.0F;
        l1 = 0;
_L13:
        float f4;
label0:
        {
            if(l1 < k1) {
                f4 = af[(l1 + i) - k];
                if(f2 + (f4 + f3) <= f)
                    break label0;
            }
            i1 = l1;
            j1 = k1 - l1;
            if(flag && j1 == 0 && k1 > 0) {
                i1 = k1 - 1;
                j1 = 1;
            }
        }
          goto _L12
        f3 += f4;
        l1++;
          goto _L13
        float f5;
        float f6;
        float f7;
        int i2;
        if(mMaximumVisibleLineCount != 1)
            break MISSING_BLOCK_LABEL_468;
        f5 = 0.0F;
        f6 = 0.0F;
        f7 = (f - f2) / 2.0F;
        i2 = k1;
_L17:
        if(i2 < 0) goto _L15; else goto _L14
_L14:
        float f10 = af[(i + (i2 - 1)) - k];
        if(f10 + f6 <= f7) goto _L16; else goto _L15
_L15:
        float f8;
        int j2;
        f8 = f - f2 - f6;
        j2 = 0;
_L18:
        float f9;
        if(j2 < i2) {
            f9 = af[(j2 + i) - k];
            if(f9 + f5 <= f8)
                break MISSING_BLOCK_LABEL_455;
        }
        i1 = j2;
        j1 = i2 - j2;
          goto _L12
_L16:
        f6 += f10;
        i2--;
          goto _L17
        f5 += f9;
        j2++;
          goto _L18
        if(Log.isLoggable("StaticLayout", 5))
            Log.w("StaticLayout", "Middle Ellipsis only supported with one line");
          goto _L12
    }

    private static final boolean isIdeographic(char c, boolean flag) {
        boolean flag1;
        flag1 = true;
        break MISSING_BLOCK_LABEL_2;
label0:
        while(true)  {
            do {
                do
                    return flag1;
                while(c >= '\u2E80' && c <= '\u2FFF' || c == '\u3000');
                if(c < '\u3040' || c > '\u309F')
                    break;
                if(!flag) {
                    switch(c) {
                    case 12353: 
                    case 12355: 
                    case 12357: 
                    case 12359: 
                    case 12361: 
                    case 12387: 
                    case 12419: 
                    case 12421: 
                    case 12423: 
                    case 12430: 
                    case 12437: 
                    case 12438: 
                    case 12443: 
                    case 12444: 
                    case 12445: 
                    case 12446: 
                        flag1 = false;
                        break;
                    }
                    continue label0;
                }
            } while(true);
            if(c >= '\u30A0' && c <= '\u30FF') {
                if(!flag)
                    switch(c) {
                    case 12448: 
                    case 12449: 
                    case 12451: 
                    case 12453: 
                    case 12455: 
                    case 12457: 
                    case 12483: 
                    case 12515: 
                    case 12517: 
                    case 12519: 
                    case 12526: 
                    case 12533: 
                    case 12534: 
                    case 12539: 
                    case 12540: 
                    case 12541: 
                    case 12542: 
                        flag1 = false;
                        break;
                    }
            } else
            if((c < '\u3400' || c > '\u4DB5') && (c < '\u4E00' || c > '\u9FBB') && (c < '\uF900' || c > '\uFAD9') && (c < '\uA000' || c > '\uA48F') && (c < '\uA490' || c > '\uA4CF') && (c < '\uFE62' || c > '\uFE66') && (c < '\uFF10' || c > '\uFF19'))
                flag1 = false;
        }
    }

    private int out(CharSequence charsequence, int i, int j, int k, int l, int i1, int j1, 
            int k1, float f, float f1, LineHeightSpan alineheightspan[], int ai[], android.graphics.Paint.FontMetricsInt fontmetricsint, boolean flag, 
            boolean flag1, byte abyte0[], int l1, boolean flag2, int i2, boolean flag3, boolean flag4, 
            char ac[], float af[], int j2, TextUtils.TruncateAt truncateat, float f2, float f3, TextPaint textpaint, 
            boolean flag5) {
        int k2 = mLineCount;
        int l2 = k2 * mColumns;
        int i3 = 1 + (l2 + mColumns);
        int ai1[] = mLines;
        if(i3 >= ai1.length) {
            int l4 = ArrayUtils.idealIntArraySize(i3 + 1);
            int ai2[] = new int[l4];
            int i5 = ai1.length;
            System.arraycopy(ai1, 0, ai2, 0, i5);
            mLines = ai2;
            ai1 = ai2;
            Layout.Directions adirections[] = new Layout.Directions[l4];
            System.arraycopy(mLineDirections, 0, adirections, 0, mLineDirections.length);
            mLineDirections = adirections;
        }
        if(alineheightspan != null) {
            fontmetricsint.ascent = k;
            fontmetricsint.descent = l;
            fontmetricsint.top = i1;
            fontmetricsint.bottom = j1;
            int j4 = 0;
            do {
                int k4 = alineheightspan.length;
                if(j4 >= k4)
                    break;
                if(alineheightspan[j4] instanceof android.text.style.LineHeightSpan.WithDensity)
                    ((android.text.style.LineHeightSpan.WithDensity)alineheightspan[j4]).chooseHeight(charsequence, i, j, ai[j4], k1, fontmetricsint, textpaint);
                else
                    alineheightspan[j4].chooseHeight(charsequence, i, j, ai[j4], k1, fontmetricsint);
                j4++;
            } while(true);
            k = fontmetricsint.ascent;
            l = fontmetricsint.descent;
            i1 = fontmetricsint.top;
            j1 = fontmetricsint.bottom;
        }
        if(k2 == 0) {
            if(flag4)
                mTopPadding = i1 - k;
            if(flag3)
                k = i1;
        }
        if(j == i2) {
            if(flag4)
                mBottomPadding = j1 - l;
            if(flag3)
                l = j1;
        }
        int j3;
        if(flag1) {
            double d = f1 + (float)(l - k) * (f - 1.0F);
            int k3;
            int l3;
            Layout.Directions directions;
            int i4;
            if(d >= 0.0D)
                j3 = (int)(0.5D + d);
            else
                j3 = -(int)(0.5D + -d);
        } else {
            j3 = 0;
        }
        ai1[l2 + 0] = i;
        ai1[l2 + 1] = k1;
        ai1[l2 + 2] = l + j3;
        k3 = k1 + (j3 + (l - k));
        ai1[0 + (l2 + mColumns)] = j;
        ai1[1 + (l2 + mColumns)] = k3;
        if(flag) {
            i4 = l2 + 0;
            ai1[i4] = 0x20000000 | ai1[i4];
        }
        l3 = l2 + 0;
        ai1[l3] = ai1[l3] | l1 << 30;
        directions = DIRS_ALL_LEFT_TO_RIGHT;
        if(flag2)
            mLineDirections[k2] = directions;
        else
            mLineDirections[k2] = AndroidBidi.directions(l1, abyte0, i - j2, ac, i - j2, j - i);
        if(truncateat != null) {
            boolean flag6;
            boolean flag7;
            boolean flag8;
            boolean flag9;
            if(k2 == 0)
                flag6 = true;
            else
                flag6 = false;
            if(k2 + 1 == mMaximumVisibleLineCount)
                flag7 = true;
            else
                flag7 = false;
            if(flag5 && 1 + mLineCount == mMaximumVisibleLineCount)
                flag8 = true;
            else
                flag8 = false;
            if((mMaximumVisibleLineCount == 1 && flag5 || flag6 && !flag5) && truncateat != TextUtils.TruncateAt.MARQUEE || !flag6 && (flag7 || !flag5) && truncateat == TextUtils.TruncateAt.END)
                flag9 = true;
            else
                flag9 = false;
            if(flag9)
                calculateEllipsis(i, j, af, j2, f2, truncateat, k2, f3, textpaint, flag8);
        }
        mLineCount = 1 + mLineCount;
        return k3;
    }

    void finish() {
        mMeasured = MeasuredText.recycle(mMeasured);
    }

    void generate(CharSequence charsequence, int i, int j, TextPaint textpaint, int k, TextDirectionHeuristic textdirectionheuristic, float f, 
            float f1, boolean flag, boolean flag1, float f2, TextUtils.TruncateAt truncateat) {
        int l;
        boolean flag2;
        android.graphics.Paint.FontMetricsInt fontmetricsint;
        int ai[];
        MeasuredText measuredtext;
        Spanned spanned;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        LineHeightSpan alineheightspan[];
        mLineCount = 0;
        l = 0;
        LeadingMarginSpan aleadingmarginspan[];
        int j9;
        int k9;
        LeadingMarginSpan leadingmarginspan;
        android.text.style.LeadingMarginSpan.LeadingMarginSpan2 leadingmarginspan2;
        if(f != 1.0F || f1 != 0.0F)
            flag2 = true;
        else
            flag2 = false;
        fontmetricsint = mFontMetricsInt;
        ai = null;
        measuredtext = mMeasured;
        spanned = null;
        if(charsequence instanceof Spanned)
            spanned = (Spanned)charsequence;
        i1 = i;
_L10:
        char ac[];
        float af[];
        byte abyte0[];
        int k2;
        boolean flag3;
        int l2;
        float f3;
        int i3;
        int j3;
        float f4;
        int k3;
        int l3;
        int i4;
        int j4;
        int k4;
        float f5;
        int l4;
        int i5;
        int j5;
        int k5;
        boolean flag4;
        boolean flag5;
        Layout.TabStops tabstops;
        int l5;
        if(i1 > j)
            break MISSING_BLOCK_LABEL_1644;
        j1 = TextUtils.indexOf(charsequence, '\n', i1, j);
        if(j1 < 0)
            k1 = j;
        else
            k1 = j1 + 1;
        l1 = 1 + mLineCount;
        i2 = k;
        j2 = k;
        alineheightspan = null;
        if(spanned != null) {
            aleadingmarginspan = (LeadingMarginSpan[])getParagraphSpans(spanned, i1, k1, android/text/style/LeadingMarginSpan);
            j9 = 0;
            do {
                k9 = aleadingmarginspan.length;
                if(j9 >= k9)
                    break;
                leadingmarginspan = aleadingmarginspan[j9];
                i2 -= aleadingmarginspan[j9].getLeadingMargin(true);
                j2 -= aleadingmarginspan[j9].getLeadingMargin(false);
                if(leadingmarginspan instanceof android.text.style.LeadingMarginSpan.LeadingMarginSpan2) {
                    leadingmarginspan2 = (android.text.style.LeadingMarginSpan.LeadingMarginSpan2)leadingmarginspan;
                    l1 = getLineForOffset(spanned.getSpanStart(leadingmarginspan2)) + leadingmarginspan2.getLeadingMarginLineCount();
                }
                j9++;
            } while(true);
            alineheightspan = (LineHeightSpan[])getParagraphSpans(spanned, i1, k1, android/text/style/LineHeightSpan);
            if(alineheightspan.length != 0) {
                if(ai == null || ai.length < alineheightspan.length)
                    ai = new int[ArrayUtils.idealIntArraySize(alineheightspan.length)];
                int l9 = 0;
                do {
                    int i10 = alineheightspan.length;
                    if(l9 >= i10)
                        break;
                    LineHeightSpan lineheightspan = alineheightspan[l9];
                    int j10 = spanned.getSpanStart(lineheightspan);
                    if(j10 < i1)
                        ai[l9] = getLineTop(getLineForOffset(j10));
                    else
                        ai[l9] = l;
                    l9++;
                } while(true);
            }
        }
        measuredtext.setPara(charsequence, i1, k1, textdirectionheuristic);
        ac = measuredtext.mChars;
        af = measuredtext.mWidths;
        abyte0 = measuredtext.mLevels;
        k2 = measuredtext.mDir;
        flag3 = measuredtext.mEasy;
        l2 = i2;
        f3 = 0.0F;
        i3 = i1;
        j3 = i1;
        f4 = 0.0F;
        k3 = 0;
        l3 = 0;
        i4 = 0;
        j4 = 0;
        k4 = i1;
        f5 = 0.0F;
        l4 = 0;
        i5 = 0;
        j5 = 0;
        k5 = 0;
        flag4 = false;
        flag5 = false;
        tabstops = null;
        l5 = i1;
_L5:
        int i6;
        int k7;
        char c;
        if(l5 >= k1)
            break MISSING_BLOCK_LABEL_1496;
        int k6;
        int l6;
        int i7;
        int j7;
        if(spanned == null) {
            i6 = k1;
            measuredtext.addStyleRun(textpaint, i6 - l5, fontmetricsint);
        } else {
            i6 = spanned.nextSpanTransition(l5, k1, android/text/style/MetricAffectingSpan);
            int j6 = i6 - l5;
            measuredtext.addStyleRun(textpaint, (MetricAffectingSpan[])TextUtils.removeEmptySpans((MetricAffectingSpan[])spanned.getSpans(l5, i6, android/text/style/MetricAffectingSpan), spanned, android/text/style/MetricAffectingSpan), j6, fontmetricsint);
        }
        k6 = fontmetricsint.top;
        l6 = fontmetricsint.bottom;
        i7 = fontmetricsint.ascent;
        j7 = fontmetricsint.descent;
        k7 = l5;
_L8:
        if(k7 >= i6) goto _L2; else goto _L1
_L1:
        c = ac[k7 - i1];
        if(c != '\n')
            if(c == '\t') {
                if(!flag5) {
                    flag5 = true;
                    flag4 = true;
                    if(spanned != null) {
                        TabStopSpan atabstopspan[] = (TabStopSpan[])getParagraphSpans(spanned, i1, k1, android/text/style/TabStopSpan);
                        if(atabstopspan.length > 0)
                            tabstops = new Layout.TabStops(20, atabstopspan);
                    }
                }
                if(tabstops != null)
                    f3 = tabstops.nextTab(f3);
                else
                    f3 = Layout.TabStops.nextDefaultStop(f3, 20);
            } else
            if(c >= '\uD800' && c <= '\uDFFF' && k7 + 1 < i6) {
                int i9 = Character.codePointAt(ac, k7 - i1);
                if(i9 >= MIN_EMOJI && i9 <= MAX_EMOJI) {
                    Bitmap bitmap = EMOJI_FACTORY.getBitmapFromAndroidPua(i9);
                    if(bitmap != null) {
                        TextPaint textpaint1;
                        if(spanned == null)
                            textpaint1 = textpaint;
                        else
                            textpaint1 = super.mWorkPaint;
                        f3 += ((float)bitmap.getWidth() * -textpaint1.ascent()) / (float)bitmap.getHeight();
                        flag4 = true;
                        k7++;
                    } else {
                        f3 += af[k7 - i1];
                    }
                } else {
                    f3 += af[k7 - i1];
                }
            } else {
                f3 += af[k7 - i1];
            }
        if(f3 > (float)l2) goto _L4; else goto _L3
_L3:
        f5 = f3;
        k4 = k7 + 1;
        if(k6 < j5)
            j5 = k6;
        if(i7 < l4)
            l4 = i7;
        if(j7 > i5)
            i5 = j7;
        if(l6 > k5)
            k5 = l6;
        if(c == ' ' || c == '\t' || (c == '.' || c == ',' || c == ':' || c == ';') && (k7 - 1 < i3 || !Character.isDigit(ac[k7 - 1 - i1])) && (k7 + 1 >= i6 || !Character.isDigit(ac[(k7 + 1) - i1])) || (c == '/' || c == '-') && (k7 + 1 >= i6 || !Character.isDigit(ac[(k7 + 1) - i1])) || c >= '\u2E80' && isIdeographic(c, true) && k7 + 1 < i6 && isIdeographic(ac[(k7 + 1) - i1], false)) {
            f4 = f3;
            j3 = k7 + 1;
            if(j5 < i4)
                i4 = j5;
            if(l4 < k3)
                k3 = l4;
            if(i5 > l3)
                l3 = i5;
            if(k5 > j4)
                j4 = k5;
        }
_L7:
        if(mLineCount < mMaximumVisibleLineCount)
            break MISSING_BLOCK_LABEL_1490;
_L2:
        l5 = i6;
          goto _L5
_L4:
        boolean flag7;
        if(k7 + 1 < i6)
            flag7 = true;
        else
            flag7 = false;
        int l7;
        int i8;
        int j8;
        int k8;
        int l8;
        float f6;
        if(j3 != i3) {
            if(c == ' ')
                j3 = k7 + 1;
            for(; j3 < i6 && ac[j3 - i1] == ' '; j3++);
            l7 = j3;
            i8 = k3;
            j8 = l3;
            k8 = i4;
            l8 = j4;
            f6 = f4;
        } else
        if(k4 != i3) {
            l7 = k4;
            i8 = l4;
            j8 = i5;
            k8 = j5;
            l8 = k5;
            f6 = f5;
        } else {
            l7 = i3 + 1;
            i8 = fontmetricsint.ascent;
            j8 = fontmetricsint.descent;
            k8 = fontmetricsint.top;
            l8 = fontmetricsint.bottom;
            f6 = af[i3 - i1];
        }
        l = out(charsequence, i3, l7, i8, j8, k8, l8, l, f, f1, alineheightspan, ai, fontmetricsint, flag4, flag2, abyte0, k2, flag3, j, flag, flag1, ac, af, i1, truncateat, f2, f6, textpaint, flag7);
        i3 = l7;
        k7 = i3 - 1;
        k4 = i3;
        j3 = i3;
        f3 = 0.0F;
        k5 = 0;
        j5 = 0;
        i5 = 0;
        l4 = 0;
        j4 = 0;
        i4 = 0;
        l3 = 0;
        k3 = 0;
        if(--l1 <= 0)
            l2 = j2;
        if(i3 >= l5) goto _L7; else goto _L6
_L6:
        measuredtext.setPos(i3);
        i6 = i3;
          goto _L2
        k7++;
          goto _L8
        if(k1 != i3 && mLineCount < mMaximumVisibleLineCount) {
            if((l4 | (i5 | (j5 | k5))) == 0) {
                textpaint.getFontMetricsInt(fontmetricsint);
                j5 = fontmetricsint.top;
                k5 = fontmetricsint.bottom;
                l4 = fontmetricsint.ascent;
                i5 = fontmetricsint.descent;
            }
            boolean flag6;
            if(k1 != j)
                flag6 = true;
            else
                flag6 = false;
            l = out(charsequence, i3, k1, l4, i5, j5, k5, l, f, f1, alineheightspan, ai, fontmetricsint, flag4, flag2, abyte0, k2, flag3, j, flag, flag1, ac, af, i1, truncateat, f2, f3, textpaint, flag6);
        }
        k1;
        if(k1 != j)
            break MISSING_BLOCK_LABEL_1749;
        if((j == i || charsequence.charAt(j - 1) == '\n') && mLineCount < mMaximumVisibleLineCount) {
            textpaint.getFontMetricsInt(fontmetricsint);
            out(charsequence, j, j, fontmetricsint.ascent, fontmetricsint.descent, fontmetricsint.top, fontmetricsint.bottom, l, f, f1, null, null, fontmetricsint, false, flag2, null, 1, true, j, flag, flag1, null, null, i, truncateat, f2, 0.0F, textpaint, false);
        }
        return;
        i1 = k1;
        if(true) goto _L10; else goto _L9
_L9:
    }

    public int getBottomPadding() {
        return mBottomPadding;
    }

    public int getEllipsisCount(int i) {
        int j;
        if(mColumns < 5)
            j = 0;
        else
            j = mLines[4 + i * mColumns];
        return j;
    }

    public int getEllipsisStart(int i) {
        int j;
        if(mColumns < 5)
            j = 0;
        else
            j = mLines[3 + i * mColumns];
        return j;
    }

    public int getEllipsizedWidth() {
        return mEllipsizedWidth;
    }

    public boolean getLineContainsTab(int i) {
        boolean flag;
        if((0x20000000 & mLines[0 + i * mColumns]) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public int getLineCount() {
        return mLineCount;
    }

    public int getLineDescent(int i) {
        int j = mLines[2 + i * mColumns];
        if(mMaximumVisibleLineCount > 0 && i >= -1 + mMaximumVisibleLineCount && i != mLineCount)
            j += getBottomPadding();
        return j;
    }

    public final Layout.Directions getLineDirections(int i) {
        return mLineDirections[i];
    }

    public int getLineForVertical(int i) {
        int j = mLineCount;
        int k = -1;
        int ai[] = mLines;
        while(j - k > 1)  {
            int l = j + k >> 1;
            if(ai[1 + l * mColumns] > i)
                j = l;
            else
                k = l;
        }
        if(k < 0)
            k = 0;
        return k;
    }

    public int getLineStart(int i) {
        return 0x1fffffff & mLines[0 + i * mColumns];
    }

    public int getLineTop(int i) {
        int j = mLines[1 + i * mColumns];
        if(mMaximumVisibleLineCount > 0 && i >= mMaximumVisibleLineCount && i != mLineCount)
            j += getBottomPadding();
        return j;
    }

    public int getParagraphDirection(int i) {
        return mLines[0 + i * mColumns] >> 30;
    }

    public int getTopPadding() {
        return mTopPadding;
    }

    void prepare() {
        mMeasured = MeasuredText.obtain();
    }

    private static final char CHAR_COLON = 58;
    private static final char CHAR_COMMA = 44;
    private static final char CHAR_DOT = 46;
    private static final char CHAR_FIRST_CJK = 11904;
    private static final int CHAR_FIRST_HIGH_SURROGATE = 55296;
    private static final char CHAR_HYPHEN = 45;
    private static final int CHAR_LAST_LOW_SURROGATE = 57343;
    private static final char CHAR_NEW_LINE = 10;
    private static final char CHAR_SEMICOLON = 59;
    private static final char CHAR_SLASH = 47;
    private static final char CHAR_SPACE = 32;
    private static final char CHAR_TAB = 9;
    private static final int COLUMNS_ELLIPSIZE = 5;
    private static final int COLUMNS_NORMAL = 3;
    private static final int DESCENT = 2;
    private static final int DIR = 0;
    private static final int DIR_SHIFT = 30;
    private static final int ELLIPSIS_COUNT = 4;
    private static final int ELLIPSIS_START = 3;
    private static final double EXTRA_ROUNDING = 0.5D;
    private static final int START = 0;
    private static final int START_MASK = 0x1fffffff;
    private static final int TAB = 0;
    private static final int TAB_INCREMENT = 20;
    private static final int TAB_MASK = 0x20000000;
    static final String TAG = "StaticLayout";
    private static final int TOP = 1;
    private int mBottomPadding;
    private int mColumns;
    private int mEllipsizedWidth;
    private android.graphics.Paint.FontMetricsInt mFontMetricsInt;
    private int mLineCount;
    private Layout.Directions mLineDirections[];
    private int mLines[];
    private int mMaximumVisibleLineCount;
    private MeasuredText mMeasured;
    private int mTopPadding;
}
