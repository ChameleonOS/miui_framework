// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text;

import android.emoji.EmojiFactory;
import android.graphics.*;
import android.text.method.TextKeyListener;
import android.text.style.AlignmentSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.LineBackgroundSpan;
import android.text.style.ParagraphStyle;
import android.text.style.ReplacementSpan;
import android.text.style.TabStopSpan;
import com.android.internal.util.ArrayUtils;
import java.util.Arrays;

// Referenced classes of package android.text:
//            TextDirectionHeuristics, TextPaint, Spanned, TextUtils, 
//            TextLine, MeasuredText, AndroidBidi, SpanSet, 
//            TextDirectionHeuristic, SpannableString, GetChars

public abstract class Layout {
    public static final class Alignment extends Enum {

        public static Alignment valueOf(String s) {
            return (Alignment)Enum.valueOf(android/text/Layout$Alignment, s);
        }

        public static Alignment[] values() {
            return (Alignment[])$VALUES.clone();
        }

        private static final Alignment $VALUES[];
        public static final Alignment ALIGN_CENTER;
        public static final Alignment ALIGN_LEFT;
        public static final Alignment ALIGN_NORMAL;
        public static final Alignment ALIGN_OPPOSITE;
        public static final Alignment ALIGN_RIGHT;

        static  {
            ALIGN_NORMAL = new Alignment("ALIGN_NORMAL", 0);
            ALIGN_OPPOSITE = new Alignment("ALIGN_OPPOSITE", 1);
            ALIGN_CENTER = new Alignment("ALIGN_CENTER", 2);
            ALIGN_LEFT = new Alignment("ALIGN_LEFT", 3);
            ALIGN_RIGHT = new Alignment("ALIGN_RIGHT", 4);
            Alignment aalignment[] = new Alignment[5];
            aalignment[0] = ALIGN_NORMAL;
            aalignment[1] = ALIGN_OPPOSITE;
            aalignment[2] = ALIGN_CENTER;
            aalignment[3] = ALIGN_LEFT;
            aalignment[4] = ALIGN_RIGHT;
            $VALUES = aalignment;
        }

        private Alignment(String s, int i) {
            super(s, i);
        }
    }

    static class SpannedEllipsizer extends Ellipsizer
        implements Spanned {

        public int getSpanEnd(Object obj) {
            return mSpanned.getSpanEnd(obj);
        }

        public int getSpanFlags(Object obj) {
            return mSpanned.getSpanFlags(obj);
        }

        public int getSpanStart(Object obj) {
            return mSpanned.getSpanStart(obj);
        }

        public Object[] getSpans(int i, int j, Class class1) {
            return mSpanned.getSpans(i, j, class1);
        }

        public int nextSpanTransition(int i, int j, Class class1) {
            return mSpanned.nextSpanTransition(i, j, class1);
        }

        public CharSequence subSequence(int i, int j) {
            char ac[] = new char[j - i];
            getChars(i, j, ac, 0);
            SpannableString spannablestring = new SpannableString(new String(ac));
            TextUtils.copySpansFrom(mSpanned, i, j, java/lang/Object, spannablestring, 0);
            return spannablestring;
        }

        private Spanned mSpanned;

        public SpannedEllipsizer(CharSequence charsequence) {
            super(charsequence);
            mSpanned = (Spanned)charsequence;
        }
    }

    static class Ellipsizer
        implements CharSequence, GetChars {

        public char charAt(int i) {
            char ac[] = TextUtils.obtain(1);
            getChars(i, i + 1, ac, 0);
            char c = ac[0];
            TextUtils.recycle(ac);
            return c;
        }

        public void getChars(int i, int j, char ac[], int k) {
            int l = mLayout.getLineForOffset(i);
            int i1 = mLayout.getLineForOffset(j);
            TextUtils.getChars(mText, i, j, ac, k);
            for(int j1 = l; j1 <= i1; j1++)
                mLayout.ellipsize(i, j, j1, ac, k, mMethod);

        }

        public int length() {
            return mText.length();
        }

        public CharSequence subSequence(int i, int j) {
            char ac[] = new char[j - i];
            getChars(i, j, ac, 0);
            return new String(ac);
        }

        public String toString() {
            char ac[] = new char[length()];
            getChars(0, length(), ac, 0);
            return new String(ac);
        }

        Layout mLayout;
        TextUtils.TruncateAt mMethod;
        CharSequence mText;
        int mWidth;

        public Ellipsizer(CharSequence charsequence) {
            mText = charsequence;
        }
    }

    public static class Directions {

        int mDirections[];

        Directions(int ai[]) {
            mDirections = ai;
        }
    }

    static class TabStops {

        public static float nextDefaultStop(float f, int i) {
            return (float)(i * (int)((f + (float)i) / (float)i));
        }

        float nextTab(float f) {
            int i;
            int ai[];
            int j;
            i = mNumStops;
            if(i <= 0)
                break MISSING_BLOCK_LABEL_51;
            ai = mStops;
            j = 0;
_L3:
            int k;
            if(j >= i)
                break MISSING_BLOCK_LABEL_51;
            k = ai[j];
            if((float)k <= f) goto _L2; else goto _L1
_L1:
            float f1 = k;
_L4:
            return f1;
_L2:
            j++;
              goto _L3
            f1 = nextDefaultStop(f, mIncrement);
              goto _L4
        }

        void reset(int i, Object aobj[]) {
            mIncrement = i;
            int j = 0;
            if(aobj != null) {
                int ai[] = mStops;
                int k = aobj.length;
                int l = 0;
                int i1 = 0;
                while(l < k)  {
                    Object obj = aobj[l];
                    int j1;
                    if(obj instanceof TabStopSpan) {
                        if(ai == null)
                            ai = new int[10];
                        else
                        if(i1 == ai.length) {
                            int ai1[] = new int[i1 * 2];
                            for(int k1 = 0; k1 < i1; k1++)
                                ai1[k1] = ai[k1];

                            ai = ai1;
                        }
                        j1 = i1 + 1;
                        ai[i1] = ((TabStopSpan)obj).getTabStop();
                    } else {
                        j1 = i1;
                    }
                    l++;
                    i1 = j1;
                }
                if(i1 > 1)
                    Arrays.sort(ai, 0, i1);
                if(ai != mStops)
                    mStops = ai;
                j = i1;
            }
            mNumStops = j;
        }

        private int mIncrement;
        private int mNumStops;
        private int mStops[];

        TabStops(int i, Object aobj[]) {
            reset(i, aobj);
        }
    }


    protected Layout(CharSequence charsequence, TextPaint textpaint, int i, Alignment alignment, float f, float f1) {
        this(charsequence, textpaint, i, alignment, TextDirectionHeuristics.FIRSTSTRONG_LTR, f, f1);
    }

    protected Layout(CharSequence charsequence, TextPaint textpaint, int i, Alignment alignment, TextDirectionHeuristic textdirectionheuristic, float f, float f1) {
        mAlignment = Alignment.ALIGN_NORMAL;
        if(i < 0)
            throw new IllegalArgumentException((new StringBuilder()).append("Layout: ").append(i).append(" < 0").toString());
        if(textpaint != null) {
            textpaint.bgColor = 0;
            textpaint.baselineShift = 0;
        }
        mText = charsequence;
        mPaint = textpaint;
        mWorkPaint = new TextPaint();
        mWidth = i;
        mAlignment = alignment;
        mSpacingMult = f;
        mSpacingAdd = f1;
        mSpannedText = charsequence instanceof Spanned;
        mTextDir = textdirectionheuristic;
    }

    private void addSelection(int i, int j, int k, int l, int i1, Path path) {
        int j1 = getLineStart(i);
        int k1 = getLineEnd(i);
        Directions directions = getLineDirections(i);
        if(k1 > j1 && mText.charAt(k1 - 1) == '\n')
            k1--;
        for(int l1 = 0; l1 < directions.mDirections.length; l1 += 2) {
            int i2 = j1 + directions.mDirections[l1];
            int j2 = i2 + (0x3ffffff & directions.mDirections[l1 + 1]);
            if(j2 > k1)
                j2 = k1;
            if(j > j2 || k < i2)
                continue;
            int k2 = Math.max(j, i2);
            int l2 = Math.min(k, j2);
            if(k2 != l2) {
                float f = getHorizontal(k2, false, i);
                float f1 = getHorizontal(l2, true, i);
                float f2 = Math.min(f, f1);
                float f3 = Math.max(f, f1);
                path.addRect(f2, l, f3, i1, android.graphics.Path.Direction.CW);
            }
        }

    }

    private void ellipsize(int i, int j, int k, char ac[], int l, TextUtils.TruncateAt truncateat) {
        int i1 = getEllipsisCount(k);
        if(i1 != 0) {
            int j1 = getEllipsisStart(k);
            int k1 = getLineStart(k);
            int l1 = j1;
            while(l1 < j1 + i1)  {
                int i2;
                int j2;
                if(l1 == j1)
                    i2 = getEllipsisChar(truncateat);
                else
                    i2 = 65279;
                j2 = l1 + k1;
                if(j2 >= i && j2 < j)
                    ac[(l + j2) - i] = i2;
                l1++;
            }
        }
    }

    public static float getDesiredWidth(CharSequence charsequence, int i, int j, TextPaint textpaint) {
        float f = 0.0F;
        int l;
        for(int k = i; k <= j; k = l + 1) {
            l = TextUtils.indexOf(charsequence, '\n', k, j);
            if(l < 0)
                l = j;
            float f1 = measurePara(textpaint, charsequence, k, l);
            if(f1 > f)
                f = f1;
        }

        return f;
    }

    public static float getDesiredWidth(CharSequence charsequence, TextPaint textpaint) {
        return getDesiredWidth(charsequence, 0, charsequence.length(), textpaint);
    }

    private char getEllipsisChar(TextUtils.TruncateAt truncateat) {
        char c;
        if(truncateat == TextUtils.TruncateAt.END_SMALL)
            c = ELLIPSIS_TWO_DOTS[0];
        else
            c = ELLIPSIS_NORMAL[0];
        return c;
    }

    private float getHorizontal(int i, boolean flag) {
        return getHorizontal(i, flag, getLineForOffset(i));
    }

    private float getHorizontal(int i, boolean flag, int j) {
        int k = getLineStart(j);
        int l = getLineEnd(j);
        int i1 = getParagraphDirection(j);
        boolean flag1 = getLineContainsTab(j);
        Directions directions = getLineDirections(j);
        TabStops tabstops = null;
        if(flag1 && (mText instanceof Spanned)) {
            TabStopSpan atabstopspan[] = (TabStopSpan[])getParagraphSpans((Spanned)mText, k, l, android/text/style/TabStopSpan);
            if(atabstopspan.length > 0)
                tabstops = new TabStops(20, atabstopspan);
        }
        TextLine textline = TextLine.obtain();
        textline.set(mPaint, mText, k, l, i1, directions, flag1, tabstops);
        float f = textline.measure(i - k, flag, null);
        TextLine.recycle(textline);
        return f + (float)getLineStartPos(j, getParagraphLeft(j), getParagraphRight(j));
    }

    private float getLineExtent(int i, TabStops tabstops, boolean flag) {
        int j = getLineStart(i);
        int k;
        boolean flag1;
        Directions directions;
        int l;
        TextLine textline;
        float f;
        if(flag)
            k = getLineEnd(i);
        else
            k = getLineVisibleEnd(i);
        flag1 = getLineContainsTab(i);
        directions = getLineDirections(i);
        l = getParagraphDirection(i);
        textline = TextLine.obtain();
        textline.set(mPaint, mText, j, k, l, directions, flag1, tabstops);
        f = textline.metrics(null);
        TextLine.recycle(textline);
        return f;
    }

    private float getLineExtent(int i, boolean flag) {
        int j = getLineStart(i);
        int k;
        boolean flag1;
        TabStops tabstops;
        Directions directions;
        float f;
        if(flag)
            k = getLineEnd(i);
        else
            k = getLineVisibleEnd(i);
        flag1 = getLineContainsTab(i);
        tabstops = null;
        if(flag1 && (mText instanceof Spanned)) {
            TabStopSpan atabstopspan[] = (TabStopSpan[])getParagraphSpans((Spanned)mText, j, k, android/text/style/TabStopSpan);
            if(atabstopspan.length > 0)
                tabstops = new TabStops(20, atabstopspan);
        }
        directions = getLineDirections(i);
        if(directions == null) {
            f = 0.0F;
        } else {
            int l = getParagraphDirection(i);
            TextLine textline = TextLine.obtain();
            textline.set(mPaint, mText, j, k, l, directions, flag1, tabstops);
            f = textline.metrics(null);
            TextLine.recycle(textline);
        }
        return f;
    }

    private int getLineStartPos(int i, int j, int k) {
        Alignment alignment = getParagraphAlignment(i);
        int l = getParagraphDirection(i);
        int k1;
        if(alignment == Alignment.ALIGN_LEFT)
            k1 = j;
        else
        if(alignment == Alignment.ALIGN_NORMAL) {
            if(l == 1)
                k1 = j;
            else
                k1 = k;
        } else {
            TabStops tabstops = null;
            if(mSpannedText && getLineContainsTab(i)) {
                Spanned spanned = (Spanned)mText;
                int l1 = getLineStart(i);
                TabStopSpan atabstopspan[] = (TabStopSpan[])getParagraphSpans(spanned, l1, spanned.nextSpanTransition(l1, spanned.length(), android/text/style/TabStopSpan), android/text/style/TabStopSpan);
                if(atabstopspan.length > 0)
                    tabstops = new TabStops(20, atabstopspan);
            }
            int i1 = (int)getLineExtent(i, tabstops, false);
            if(alignment == Alignment.ALIGN_RIGHT)
                k1 = k - i1;
            else
            if(alignment == Alignment.ALIGN_OPPOSITE) {
                if(l == 1)
                    k1 = k - i1;
                else
                    k1 = j - i1;
            } else {
                int j1 = i1 & -2;
                k1 = (j + k) - j1 >> 1;
            }
        }
        return k1;
    }

    private int getLineVisibleEnd(int i, int j, int k) {
        CharSequence charsequence = mText;
        if(i != -1 + getLineCount()) goto _L2; else goto _L1
_L1:
        int l = k;
_L6:
        return l;
_L4:
        k--;
_L2:
        char c;
        if(k <= j)
            break; /* Loop/switch isn't completed */
        c = charsequence.charAt(k - 1);
        if(c != '\n')
            continue; /* Loop/switch isn't completed */
        l = k - 1;
        continue; /* Loop/switch isn't completed */
        if(c == ' ' || c == '\t') goto _L4; else goto _L3
_L3:
        l = k;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private int getOffsetAtStartOf(int i) {
        int j;
        if(i == 0) {
            j = 0;
        } else {
            CharSequence charsequence = mText;
            char c = charsequence.charAt(i);
            if(c >= '\uDC00' && c <= '\uDFFF') {
                char c1 = charsequence.charAt(i - 1);
                if(c1 >= '\uD800' && c1 <= '\uDBFF')
                    i--;
            }
            if(mSpannedText) {
                ReplacementSpan areplacementspan[] = (ReplacementSpan[])((Spanned)charsequence).getSpans(i, i, android/text/style/ReplacementSpan);
                for(int k = 0; k < areplacementspan.length; k++) {
                    int l = ((Spanned)charsequence).getSpanStart(areplacementspan[k]);
                    int i1 = ((Spanned)charsequence).getSpanEnd(areplacementspan[k]);
                    if(l < i && i1 > i)
                        i = l;
                }

            }
            j = i;
        }
        return j;
    }

    private int getOffsetToLeftRightOf(int i, boolean flag) {
        int j;
        int k;
        boolean flag1;
        j = getLineForOffset(i);
        k = getLineStart(j);
        int l = getLineEnd(j);
        int i1 = getParagraphDirection(j);
        flag1 = false;
        boolean flag2;
        boolean flag3;
        Directions directions;
        TextLine textline;
        int k1;
        int l1;
        if(i1 == -1)
            flag2 = true;
        else
            flag2 = false;
        if(flag == flag2)
            flag3 = true;
        else
            flag3 = false;
        if(!flag3) goto _L2; else goto _L1
_L1:
        if(i != l) goto _L4; else goto _L3
_L3:
        if(j >= -1 + getLineCount()) goto _L6; else goto _L5
_L5:
        flag1 = true;
        j++;
_L4:
        if(flag1) {
            k = getLineStart(j);
            l = getLineEnd(j);
            l1 = getParagraphDirection(j);
            if(l1 != i1) {
                int j1;
                if(!flag)
                    flag = true;
                else
                    flag = false;
                i1 = l1;
            }
        }
        directions = getLineDirections(j);
        textline = TextLine.obtain();
        textline.set(mPaint, mText, k, l, i1, directions, false, null);
        k1 = k + textline.getOffsetToLeftRightOf(i - k, flag);
        TextLine.recycle(textline);
        j1 = k1;
_L7:
        return j1;
_L6:
        j1 = i;
          goto _L7
_L2:
        if(i == k) {
label0:
            {
                if(j <= 0)
                    break label0;
                flag1 = true;
                j--;
            }
        }
          goto _L4
        j1 = i;
          goto _L7
    }

    private int getParagraphLeadingMargin(int i) {
        if(mSpannedText) goto _L2; else goto _L1
_L1:
        int k = 0;
_L4:
        return k;
_L2:
        Spanned spanned;
        int j;
        LeadingMarginSpan aleadingmarginspan[];
        spanned = (Spanned)mText;
        j = getLineStart(i);
        aleadingmarginspan = (LeadingMarginSpan[])getParagraphSpans(spanned, j, spanned.nextSpanTransition(j, getLineEnd(i), android/text/style/LeadingMarginSpan), android/text/style/LeadingMarginSpan);
        if(aleadingmarginspan.length != 0)
            break; /* Loop/switch isn't completed */
        k = 0;
        if(true) goto _L4; else goto _L3
_L3:
        k = 0;
        boolean flag;
        int l;
        if(j == 0 || spanned.charAt(j - 1) == '\n')
            flag = true;
        else
            flag = false;
        l = 0;
        while(l < aleadingmarginspan.length)  {
            LeadingMarginSpan leadingmarginspan = aleadingmarginspan[l];
            boolean flag1 = flag;
            if(leadingmarginspan instanceof android.text.style.LeadingMarginSpan.LeadingMarginSpan2)
                if(i < getLineForOffset(spanned.getSpanStart(leadingmarginspan)) + ((android.text.style.LeadingMarginSpan.LeadingMarginSpan2)leadingmarginspan).getLeadingMarginLineCount())
                    flag1 = true;
                else
                    flag1 = false;
            k += leadingmarginspan.getLeadingMargin(flag1);
            l++;
        }
        if(true) goto _L4; else goto _L5
_L5:
    }

    static Object[] getParagraphSpans(Spanned spanned, int i, int j, Class class1) {
        Object aobj[];
        if(i == j && i > 0)
            aobj = ArrayUtils.emptyArray(class1);
        else
            aobj = spanned.getSpans(i, j, class1);
        return aobj;
    }

    static float measurePara(TextPaint textpaint, CharSequence charsequence, int i, int j) {
        MeasuredText measuredtext;
        TextLine textline;
        measuredtext = MeasuredText.obtain();
        textline = TextLine.obtain();
        measuredtext.setPara(charsequence, i, j, TextDirectionHeuristics.LTR);
        if(!measuredtext.mEasy) goto _L2; else goto _L1
_L1:
        Directions directions;
        int k;
        directions = DIRS_ALL_LEFT_TO_RIGHT;
        k = 1;
_L7:
        char ac[];
        int l;
        boolean flag;
        TabStops tabstops;
        int i1;
        ac = measuredtext.mChars;
        l = measuredtext.mLen;
        flag = false;
        tabstops = null;
        i1 = 0;
_L8:
        if(i1 >= l) goto _L4; else goto _L3
_L3:
        if(ac[i1] != '\t') goto _L6; else goto _L5
_L5:
        flag = true;
        if(charsequence instanceof Spanned) {
            Spanned spanned = (Spanned)charsequence;
            TabStopSpan atabstopspan[] = (TabStopSpan[])getParagraphSpans(spanned, i, spanned.nextSpanTransition(i, j, android/text/style/TabStopSpan), android/text/style/TabStopSpan);
            if(atabstopspan.length > 0)
                tabstops = new TabStops(20, atabstopspan);
        }
_L4:
        float f;
        textline.set(textpaint, charsequence, i, j, k, directions, flag, tabstops);
        f = textline.metrics(null);
        TextLine.recycle(textline);
        MeasuredText.recycle(measuredtext);
        return f;
_L2:
        directions = AndroidBidi.directions(measuredtext.mDir, measuredtext.mLevels, 0, measuredtext.mChars, 0, measuredtext.mLen);
        k = measuredtext.mDir;
          goto _L7
_L6:
        i1++;
          goto _L8
        Exception exception;
        exception;
        TextLine.recycle(textline);
        MeasuredText.recycle(measuredtext);
        throw exception;
          goto _L7
    }

    static float nextTab(CharSequence charsequence, int i, int j, float f, Object aobj[]) {
        float f1;
        boolean flag;
        f1 = 3.402823E+38F;
        flag = false;
        if(!(charsequence instanceof Spanned)) goto _L2; else goto _L1
_L1:
        if(aobj == null) {
            aobj = getParagraphSpans((Spanned)charsequence, i, j, android/text/style/TabStopSpan);
            flag = true;
        }
        int k = 0;
        while(k < aobj.length)  {
            if(flag || (aobj[k] instanceof TabStopSpan)) {
                int l = ((TabStopSpan)aobj[k]).getTabStop();
                if((float)l < f1 && (float)l > f)
                    f1 = l;
            }
            k++;
        }
        if(f1 == 3.402823E+38F) goto _L2; else goto _L3
_L3:
        float f2 = f1;
_L5:
        return f2;
_L2:
        f2 = 20 * (int)((f + 20F) / 20F);
        if(true) goto _L5; else goto _L4
_L4:
    }

    private boolean primaryIsTrailingPrevious(int i) {
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int ai[];
        int k1;
        int l1;
        j = 0;
        k = 1;
        l = getLineForOffset(i);
        i1 = getLineStart(l);
        j1 = getLineEnd(l);
        ai = getLineDirections(l).mDirections;
        k1 = -1;
        l1 = 0;
_L9:
        if(l1 >= ai.length) goto _L2; else goto _L1
_L1:
        int j3;
        int k3;
        j3 = i1 + ai[l1];
        k3 = j3 + (0x3ffffff & ai[l1 + 1]);
        if(k3 > j1)
            k3 = j1;
        if(i < j3 || i >= k3) goto _L4; else goto _L3
_L3:
        if(i <= j3) goto _L6; else goto _L5
_L5:
        return j;
_L6:
        k1 = 0x3f & ai[l1 + 1] >>> 26;
_L2:
        int i2;
        if(k1 == -1)
            if(getParagraphDirection(l) == k)
                k1 = 0;
            else
                k1 = k;
        i2 = -1;
        if(i != i1) goto _L8; else goto _L7
_L7:
        if(getParagraphDirection(l) == k)
            i2 = 0;
        else
            i2 = k;
_L10:
        int j2;
        int k2;
        int l2;
        int i3;
        if(i2 >= k1)
            k = 0;
        j = k;
        if(true) goto _L5; else goto _L8
_L4:
        l1 += 2;
          goto _L9
_L8:
        j2 = i - 1;
        k2 = 0;
_L11:
        if(k2 < ai.length) {
label0:
            {
                l2 = i1 + ai[k2];
                i3 = l2 + (0x3ffffff & ai[k2 + 1]);
                if(i3 > j1)
                    i3 = j1;
                if(j2 < l2 || j2 >= i3)
                    break label0;
                i2 = 0x3f & ai[k2 + 1] >>> 26;
            }
        }
          goto _L10
        k2 += 2;
          goto _L11
    }

    public void draw(Canvas canvas) {
        draw(canvas, null, null, 0);
    }

    public void draw(Canvas canvas, Path path, Paint paint, int i) {
        long l = getLineRangeForDraw(canvas);
        int j = TextUtils.unpackRangeStartFromLong(l);
        int k = TextUtils.unpackRangeEndFromLong(l);
        if(k >= 0) {
            drawBackground(canvas, path, paint, i, j, k);
            drawText(canvas, j, k);
        }
    }

    public void drawBackground(Canvas canvas, Path path, Paint paint, int i, int j, int k) {
        if(mSpannedText) {
            if(mLineBackgroundSpans == null)
                mLineBackgroundSpans = new SpanSet(android/text/style/LineBackgroundSpan);
            Spanned spanned = (Spanned)mText;
            int l = spanned.length();
            mLineBackgroundSpans.init(spanned, 0, l);
            if(mLineBackgroundSpans.numberOfSpans > 0) {
                int i1 = getLineTop(j);
                int j1 = getLineStart(j);
                ParagraphStyle aparagraphstyle[] = NO_PARA_SPANS;
                int k1 = 0;
                TextPaint textpaint = mPaint;
                int l1 = 0;
                int i2 = mWidth;
                for(int j2 = j; j2 <= k; j2++) {
                    int k2 = j1;
                    int l2 = getLineStart(j2 + 1);
                    j1 = l2;
                    int i3 = i1;
                    int j3 = getLineTop(j2 + 1);
                    i1 = j3;
                    int k3 = j3 - getLineDescent(j2);
                    if(k2 >= l1) {
                        l1 = mLineBackgroundSpans.getNextTransition(k2, l);
                        k1 = 0;
                        if(k2 != l2 || k2 == 0) {
                            int i4 = 0;
                            while(i4 < mLineBackgroundSpans.numberOfSpans)  {
                                if(mLineBackgroundSpans.spanStarts[i4] < l2 && mLineBackgroundSpans.spanEnds[i4] > k2) {
                                    int j4 = aparagraphstyle.length;
                                    if(k1 == j4) {
                                        ParagraphStyle aparagraphstyle1[] = new ParagraphStyle[ArrayUtils.idealObjectArraySize(k1 * 2)];
                                        System.arraycopy(aparagraphstyle, 0, aparagraphstyle1, 0, k1);
                                        aparagraphstyle = aparagraphstyle1;
                                    }
                                    int k4 = k1 + 1;
                                    aparagraphstyle[k1] = ((LineBackgroundSpan[])mLineBackgroundSpans.spans)[i4];
                                    k1 = k4;
                                }
                                i4++;
                            }
                        }
                    }
                    for(int l3 = 0; l3 < k1; l3++)
                        ((LineBackgroundSpan)aparagraphstyle[l3]).drawBackground(canvas, textpaint, 0, i2, i3, k3, j3, spanned, k2, l2, j2);

                }

            }
            mLineBackgroundSpans.recycle();
        }
        if(path != null) {
            if(i != 0)
                canvas.translate(0.0F, i);
            canvas.drawPath(path, paint);
            if(i != 0)
                canvas.translate(0.0F, -i);
        }
    }

    public void drawText(Canvas canvas, int i, int j) {
        int k;
        int l;
        ParagraphStyle aparagraphstyle[];
        int i1;
        TextPaint textpaint;
        CharSequence charsequence;
        Alignment alignment;
        boolean flag;
        TextLine textline;
        int j1;
        TabStops tabstops;
        k = getLineTop(i);
        l = getLineStart(i);
        aparagraphstyle = NO_PARA_SPANS;
        i1 = 0;
        textpaint = mPaint;
        charsequence = mText;
        alignment = mAlignment;
        flag = false;
        textline = TextLine.obtain();
        j1 = i;
        tabstops = null;
_L11:
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        if(j1 > j)
            break MISSING_BLOCK_LABEL_800;
        k1 = l;
        l = getLineStart(j1 + 1);
        l1 = getLineVisibleEnd(j1, k1, l);
        i2 = k;
        j2 = getLineTop(j1 + 1);
        k = j2;
        k2 = j2 - getLineDescent(j1);
        l2 = getParagraphDirection(j1);
        i3 = 0;
        j3 = mWidth;
        if(!mSpannedText) goto _L2; else goto _L1
_L1:
        boolean flag2;
        int j5;
        Spanned spanned = (Spanned)charsequence;
        int j4 = charsequence.length();
        int k4;
        int l4;
        int i5;
        if(k1 == 0 || charsequence.charAt(k1 - 1) == '\n')
            flag2 = true;
        else
            flag2 = false;
        if(k1 < i1 || j1 != i && !flag2) goto _L4; else goto _L3
_L3:
        i1 = spanned.nextSpanTransition(k1, j4, android/text/style/ParagraphStyle);
        aparagraphstyle = (ParagraphStyle[])getParagraphSpans(spanned, k1, i1, android/text/style/ParagraphStyle);
        alignment = mAlignment;
        j5 = -1 + aparagraphstyle.length;
_L9:
        if(j5 < 0) goto _L6; else goto _L5
_L5:
        if(!(aparagraphstyle[j5] instanceof AlignmentSpan)) goto _L8; else goto _L7
_L7:
        alignment = ((AlignmentSpan)aparagraphstyle[j5]).getAlignment();
_L6:
        flag = false;
_L4:
        k4 = aparagraphstyle.length;
        l4 = 0;
        while(l4 < k4)  {
            if(aparagraphstyle[l4] instanceof LeadingMarginSpan) {
                LeadingMarginSpan leadingmarginspan = (LeadingMarginSpan)aparagraphstyle[l4];
                boolean flag3 = flag2;
                if(leadingmarginspan instanceof android.text.style.LeadingMarginSpan.LeadingMarginSpan2) {
                    i5 = ((android.text.style.LeadingMarginSpan.LeadingMarginSpan2)leadingmarginspan).getLeadingMarginLineCount() + getLineForOffset(spanned.getSpanStart(leadingmarginspan));
                    if(j1 < i5)
                        flag3 = true;
                    else
                        flag3 = false;
                }
                if(l2 == -1) {
                    leadingmarginspan.drawLeadingMargin(canvas, textpaint, j3, l2, i2, k2, j2, charsequence, k1, l1, flag2, this);
                    j3 -= leadingmarginspan.getLeadingMargin(flag3);
                } else {
                    leadingmarginspan.drawLeadingMargin(canvas, textpaint, i3, l2, i2, k2, j2, charsequence, k1, l1, flag2, this);
                    i3 += leadingmarginspan.getLeadingMargin(flag3);
                }
            }
            l4++;
        }
        break; /* Loop/switch isn't completed */
_L8:
        j5--;
        if(true) goto _L9; else goto _L2
_L2:
        boolean flag1 = getLineContainsTab(j1);
        TabStops tabstops1;
        Alignment alignment1;
        int i4;
        Directions directions;
        if(flag1 && !flag) {
            Alignment alignment2;
            Alignment alignment4;
            if(tabstops == null) {
                tabstops1 = new TabStops(20, aparagraphstyle);
            } else {
                tabstops.reset(20, aparagraphstyle);
                tabstops1 = tabstops;
            }
            flag = true;
        } else {
            tabstops1 = tabstops;
        }
        alignment1 = alignment;
        alignment2 = Alignment.ALIGN_LEFT;
        if(alignment1 == alignment2) {
            if(l2 == 1)
                alignment1 = Alignment.ALIGN_NORMAL;
            else
                alignment1 = Alignment.ALIGN_OPPOSITE;
        } else {
            Alignment alignment3 = Alignment.ALIGN_RIGHT;
            if(alignment1 == alignment3)
                if(l2 == 1)
                    alignment1 = Alignment.ALIGN_OPPOSITE;
                else
                    alignment1 = Alignment.ALIGN_NORMAL;
        }
        alignment4 = Alignment.ALIGN_NORMAL;
        if(alignment1 == alignment4) {
            if(l2 == 1)
                i4 = i3;
            else
                i4 = j3;
        } else {
            int k3 = (int)getLineExtent(j1, tabstops1, false);
            Alignment alignment5 = Alignment.ALIGN_OPPOSITE;
            if(alignment1 == alignment5) {
                if(l2 == 1)
                    i4 = j3 - k3;
                else
                    i4 = i3 - k3;
            } else {
                int l3 = k3 & -2;
                i4 = (j3 + i3) - l3 >> 1;
            }
        }
        directions = getLineDirections(j1);
        if(directions == DIRS_ALL_LEFT_TO_RIGHT && !mSpannedText && !flag1) {
            canvas.drawText(charsequence, k1, l1, i4, k2, textpaint);
        } else {
            textline.set(textpaint, charsequence, k1, l1, l2, directions, flag1, tabstops1);
            textline.draw(canvas, i4, i2, k2, j2);
        }
        j1++;
        tabstops = tabstops1;
        continue; /* Loop/switch isn't completed */
        TextLine.recycle(textline);
        return;
        if(true) goto _L11; else goto _L10
_L10:
    }

    public final Alignment getAlignment() {
        return mAlignment;
    }

    public abstract int getBottomPadding();

    public void getCursorPath(int i, Path path, CharSequence charsequence) {
        path.reset();
        int j = getLineForOffset(i);
        int k = getLineTop(j);
        int l = getLineTop(j + 1);
        float f = getPrimaryHorizontal(i) - 0.5F;
        float f1;
        int i1;
        int j1;
        int k1;
        if(isLevelBoundary(i))
            f1 = getSecondaryHorizontal(i) - 0.5F;
        else
            f1 = f;
        i1 = TextKeyListener.getMetaState(charsequence, 1) | TextKeyListener.getMetaState(charsequence, 2048);
        j1 = TextKeyListener.getMetaState(charsequence, 2);
        k1 = 0;
        if(i1 != 0 || j1 != 0) {
            k1 = l - k >> 2;
            if(j1 != 0)
                k += k1;
            if(i1 != 0)
                l -= k1;
        }
        if(f < 0.5F)
            f = 0.5F;
        if(f1 < 0.5F)
            f1 = 0.5F;
        if(Float.compare(f, f1) == 0) {
            path.moveTo(f, k);
            path.lineTo(f, l);
        } else {
            path.moveTo(f, k);
            path.lineTo(f, k + l >> 1);
            path.moveTo(f1, k + l >> 1);
            path.lineTo(f1, l);
        }
        if(i1 == 2) {
            path.moveTo(f1, l);
            path.lineTo(f1 - (float)k1, l + k1);
            path.lineTo(f1, l);
            path.lineTo(f1 + (float)k1, l + k1);
        } else
        if(i1 == 1) {
            path.moveTo(f1, l);
            path.lineTo(f1 - (float)k1, l + k1);
            path.moveTo(f1 - (float)k1, (float)(l + k1) - 0.5F);
            path.lineTo(f1 + (float)k1, (float)(l + k1) - 0.5F);
            path.moveTo(f1 + (float)k1, l + k1);
            path.lineTo(f1, l);
        }
        if(j1 == 2) {
            path.moveTo(f, k);
            path.lineTo(f - (float)k1, k - k1);
            path.lineTo(f, k);
            path.lineTo(f + (float)k1, k - k1);
        } else
        if(j1 == 1) {
            path.moveTo(f, k);
            path.lineTo(f - (float)k1, k - k1);
            path.moveTo(f - (float)k1, 0.5F + (float)(k - k1));
            path.lineTo(f + (float)k1, 0.5F + (float)(k - k1));
            path.moveTo(f + (float)k1, k - k1);
            path.lineTo(f, k);
        }
    }

    public abstract int getEllipsisCount(int i);

    public abstract int getEllipsisStart(int i);

    public int getEllipsizedWidth() {
        return mWidth;
    }

    public int getHeight() {
        return getLineTop(getLineCount());
    }

    public final int getLineAscent(int i) {
        return getLineTop(i) - (getLineTop(i + 1) - getLineDescent(i));
    }

    public final int getLineBaseline(int i) {
        return getLineTop(i + 1) - getLineDescent(i);
    }

    public final int getLineBottom(int i) {
        return getLineTop(i + 1);
    }

    public int getLineBounds(int i, Rect rect) {
        if(rect != null) {
            rect.left = 0;
            rect.top = getLineTop(i);
            rect.right = mWidth;
            rect.bottom = getLineTop(i + 1);
        }
        return getLineBaseline(i);
    }

    public abstract boolean getLineContainsTab(int i);

    public abstract int getLineCount();

    public abstract int getLineDescent(int i);

    public abstract Directions getLineDirections(int i);

    public final int getLineEnd(int i) {
        return getLineStart(i + 1);
    }

    public int getLineForOffset(int i) {
        int j = getLineCount();
        int k;
        for(k = -1; j - k > 1;) {
            int l = (j + k) / 2;
            if(getLineStart(l) > i)
                j = l;
            else
                k = l;
        }

        if(k < 0)
            k = 0;
        return k;
    }

    public int getLineForVertical(int i) {
        int j = getLineCount();
        int k;
        for(k = -1; j - k > 1;) {
            int l = (j + k) / 2;
            if(getLineTop(l) > i)
                j = l;
            else
                k = l;
        }

        if(k < 0)
            k = 0;
        return k;
    }

    public float getLineLeft(int i) {
        float f;
        int j;
        Alignment alignment;
        f = 0.0F;
        j = getParagraphDirection(i);
        alignment = getParagraphAlignment(i);
        if(alignment != Alignment.ALIGN_LEFT) goto _L2; else goto _L1
_L1:
        return f;
_L2:
        if(alignment == Alignment.ALIGN_NORMAL) {
            if(j == -1)
                f = (float)getParagraphRight(i) - getLineMax(i);
        } else
        if(alignment == Alignment.ALIGN_RIGHT)
            f = (float)mWidth - getLineMax(i);
        else
        if(alignment == Alignment.ALIGN_OPPOSITE) {
            if(j != -1)
                f = (float)mWidth - getLineMax(i);
        } else {
            int k = getParagraphLeft(i);
            int l = getParagraphRight(i);
            int i1 = -2 & (int)getLineMax(i);
            f = k + (l - k - i1) / 2;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public float getLineMax(int i) {
        float f = getParagraphLeadingMargin(i);
        float f1 = getLineExtent(i, false);
        if(f + f1 < 0.0F)
            f1 = -f1;
        return f1;
    }

    public long getLineRangeForDraw(Canvas canvas) {
        long l1;
        int i;
        int j;
        synchronized(sTempRect) {
            if(!canvas.getClipBounds(sTempRect)) {
                l1 = TextUtils.packRangeInLong(0, -1);
                break MISSING_BLOCK_LABEL_110;
            }
            i = sTempRect.top;
            j = sTempRect.bottom;
        }
        int k = Math.max(i, 0);
        int l = Math.min(getLineTop(getLineCount()), j);
        if(k >= l)
            l1 = TextUtils.packRangeInLong(0, -1);
        else
            l1 = TextUtils.packRangeInLong(getLineForVertical(k), getLineForVertical(l));
          goto _L1
        exception;
        rect;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
        return l1;
    }

    public float getLineRight(int i) {
        int j = getParagraphDirection(i);
        Alignment alignment = getParagraphAlignment(i);
        float f;
        if(alignment == Alignment.ALIGN_LEFT)
            f = (float)getParagraphLeft(i) + getLineMax(i);
        else
        if(alignment == Alignment.ALIGN_NORMAL) {
            if(j == -1)
                f = mWidth;
            else
                f = (float)getParagraphLeft(i) + getLineMax(i);
        } else
        if(alignment == Alignment.ALIGN_RIGHT)
            f = mWidth;
        else
        if(alignment == Alignment.ALIGN_OPPOSITE) {
            if(j == -1)
                f = getLineMax(i);
            else
                f = mWidth;
        } else {
            int k = getParagraphLeft(i);
            int l = getParagraphRight(i);
            int i1 = -2 & (int)getLineMax(i);
            f = l - (l - k - i1) / 2;
        }
        return f;
    }

    public abstract int getLineStart(int i);

    public abstract int getLineTop(int i);

    public int getLineVisibleEnd(int i) {
        return getLineVisibleEnd(i, getLineStart(i), getLineStart(i + 1));
    }

    public float getLineWidth(int i) {
        float f = getParagraphLeadingMargin(i);
        float f1 = getLineExtent(i, true);
        if(f + f1 < 0.0F)
            f1 = -f1;
        return f1;
    }

    public int getOffsetForHorizontal(int i, float f) {
        int j = -1 + getLineEnd(i);
        int k = getLineStart(i);
        Directions directions = getLineDirections(i);
        if(i == -1 + getLineCount())
            j++;
        int l = k;
        float f1 = Math.abs(getPrimaryHorizontal(l) - f);
        for(int i1 = 0; i1 < directions.mDirections.length; i1 += 2) {
            int j1 = k + directions.mDirections[i1];
            int k1 = j1 + (0x3ffffff & directions.mDirections[i1 + 1]);
            int l1;
            int i2;
            int j2;
            if((0x4000000 & directions.mDirections[i1 + 1]) != 0)
                l1 = -1;
            else
                l1 = 1;
            if(k1 > j)
                k1 = j;
            i2 = 1 + (k1 - 1);
            for(j2 = -1 + (j1 + 1); i2 - j2 > 1;) {
                int i3 = (i2 + j2) / 2;
                if(getPrimaryHorizontal(getOffsetAtStartOf(i3)) * (float)l1 >= f * (float)l1)
                    i2 = i3;
                else
                    j2 = i3;
            }

            if(j2 < j1 + 1)
                j2 = j1 + 1;
            if(j2 < k1) {
                int k2 = getOffsetAtStartOf(j2);
                float f3 = Math.abs(getPrimaryHorizontal(k2) - f);
                int l2 = TextUtils.getOffsetAfter(mText, k2);
                if(l2 < k1) {
                    float f4 = Math.abs(getPrimaryHorizontal(l2) - f);
                    if(f4 < f3) {
                        f3 = f4;
                        k2 = l2;
                    }
                }
                if(f3 < f1) {
                    f1 = f3;
                    l = k2;
                }
            }
            float f2 = Math.abs(getPrimaryHorizontal(j1) - f);
            if(f2 < f1) {
                f1 = f2;
                l = j1;
            }
        }

        if(Math.abs(getPrimaryHorizontal(j) - f) < f1)
            l = j;
        return l;
    }

    public int getOffsetToLeftOf(int i) {
        return getOffsetToLeftRightOf(i, true);
    }

    public int getOffsetToRightOf(int i) {
        return getOffsetToLeftRightOf(i, false);
    }

    public final TextPaint getPaint() {
        return mPaint;
    }

    public final Alignment getParagraphAlignment(int i) {
        Alignment alignment = mAlignment;
        if(mSpannedText) {
            AlignmentSpan aalignmentspan[] = (AlignmentSpan[])getParagraphSpans((Spanned)mText, getLineStart(i), getLineEnd(i), android/text/style/AlignmentSpan);
            int j = aalignmentspan.length;
            if(j > 0)
                alignment = aalignmentspan[j - 1].getAlignment();
        }
        return alignment;
    }

    public abstract int getParagraphDirection(int i);

    public final int getParagraphLeft(int i) {
        int j = 0;
        if(getParagraphDirection(i) != -1 && mSpannedText)
            j = getParagraphLeadingMargin(i);
        return j;
    }

    public final int getParagraphRight(int i) {
        int j = mWidth;
        if(getParagraphDirection(i) != 1 && mSpannedText)
            j -= getParagraphLeadingMargin(i);
        return j;
    }

    public float getPrimaryHorizontal(int i) {
        return getHorizontal(i, primaryIsTrailingPrevious(i));
    }

    public float getSecondaryHorizontal(int i) {
        boolean flag;
        if(!primaryIsTrailingPrevious(i))
            flag = true;
        else
            flag = false;
        return getHorizontal(i, flag);
    }

    public void getSelectionPath(int i, int j, Path path) {
        path.reset();
        if(i != j) {
            if(j < i) {
                int j3 = j;
                j = i;
                i = j3;
            }
            int k = getLineForOffset(i);
            int l = getLineForOffset(j);
            int i1 = getLineTop(k);
            int j1 = getLineBottom(l);
            if(k == l) {
                addSelection(k, i, j, i1, j1, path);
            } else {
                float f = mWidth;
                int k1 = getLineEnd(k);
                int l1 = getLineBottom(k);
                addSelection(k, i, k1, i1, l1, path);
                int i2;
                if(getParagraphDirection(k) == -1)
                    path.addRect(getLineLeft(k), i1, 0.0F, getLineBottom(k), android.graphics.Path.Direction.CW);
                else
                    path.addRect(getLineRight(k), i1, f, getLineBottom(k), android.graphics.Path.Direction.CW);
                for(i2 = k + 1; i2 < l; i2++) {
                    int l2 = getLineTop(i2);
                    int i3 = getLineBottom(i2);
                    path.addRect(0.0F, l2, f, i3, android.graphics.Path.Direction.CW);
                }

                int j2 = getLineTop(l);
                int k2 = getLineBottom(l);
                addSelection(l, getLineStart(l), j, j2, k2, path);
                if(getParagraphDirection(l) == -1)
                    path.addRect(f, j2, getLineRight(l), k2, android.graphics.Path.Direction.CW);
                else
                    path.addRect(0.0F, j2, getLineLeft(l), k2, android.graphics.Path.Direction.CW);
            }
        }
    }

    public final float getSpacingAdd() {
        return mSpacingAdd;
    }

    public final float getSpacingMultiplier() {
        return mSpacingMult;
    }

    public final CharSequence getText() {
        return mText;
    }

    public final TextDirectionHeuristic getTextDirectionHeuristic() {
        return mTextDir;
    }

    public abstract int getTopPadding();

    public final int getWidth() {
        return mWidth;
    }

    public final void increaseWidthTo(int i) {
        if(i < mWidth) {
            throw new RuntimeException("attempted to reduce Layout width");
        } else {
            mWidth = i;
            return;
        }
    }

    public boolean isLevelBoundary(int i) {
        boolean flag;
        int j;
        Directions directions;
        flag = false;
        j = getLineForOffset(i);
        directions = getLineDirections(j);
        if(directions != DIRS_ALL_LEFT_TO_RIGHT && directions != DIRS_ALL_RIGHT_TO_LEFT) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        int ai[];
        int k1;
        int l1;
        ai = directions.mDirections;
        int k = getLineStart(j);
        int l = getLineEnd(j);
        if(i == k || i == l) {
            int i1;
            int j1;
            if(getParagraphDirection(j) == 1)
                i1 = 0;
            else
                i1 = 1;
            if(i == k)
                j1 = 0;
            else
                j1 = -2 + ai.length;
            if((0x3f & ai[j1 + 1] >>> 26) != i1)
                flag = true;
            continue; /* Loop/switch isn't completed */
        }
        k1 = i - k;
        l1 = 0;
_L4:
        if(l1 < ai.length) {
label0:
            {
                if(k1 != ai[l1])
                    break label0;
                flag = true;
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
        l1 += 2;
          goto _L4
        if(true) goto _L1; else goto _L5
_L5:
    }

    public boolean isRtlCharAt(int i) {
        boolean flag;
        boolean flag1;
        int j;
        Directions directions;
        flag = true;
        flag1 = false;
        j = getLineForOffset(i);
        directions = getLineDirections(j);
        if(directions != DIRS_ALL_LEFT_TO_RIGHT) goto _L2; else goto _L1
_L1:
        return flag1;
_L2:
        int ai[];
        int k;
        int l;
        if(directions == DIRS_ALL_RIGHT_TO_LEFT) {
            flag1 = flag;
            continue; /* Loop/switch isn't completed */
        }
        ai = directions.mDirections;
        k = getLineStart(j);
        l = 0;
_L4:
        if(l < ai.length) {
label0:
            {
                if(i < k + (0x3ffffff & ai[l]))
                    break label0;
                if((1 & (0x3f & ai[l + 1] >>> 26)) == 0)
                    flag = false;
                flag1 = flag;
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
        l += 2;
          goto _L4
        if(true) goto _L1; else goto _L5
_L5:
    }

    protected final boolean isSpanned() {
        return mSpannedText;
    }

    void replaceWith(CharSequence charsequence, TextPaint textpaint, int i, Alignment alignment, float f, float f1) {
        if(i < 0) {
            throw new IllegalArgumentException((new StringBuilder()).append("Layout: ").append(i).append(" < 0").toString());
        } else {
            mText = charsequence;
            mPaint = textpaint;
            mWidth = i;
            mAlignment = alignment;
            mSpacingMult = f;
            mSpacingAdd = f1;
            mSpannedText = charsequence instanceof Spanned;
            return;
        }
    }

    static final Directions DIRS_ALL_LEFT_TO_RIGHT;
    static final Directions DIRS_ALL_RIGHT_TO_LEFT;
    public static final int DIR_LEFT_TO_RIGHT = 1;
    static final int DIR_REQUEST_DEFAULT_LTR = 2;
    static final int DIR_REQUEST_DEFAULT_RTL = -2;
    static final int DIR_REQUEST_LTR = 1;
    static final int DIR_REQUEST_RTL = -1;
    public static final int DIR_RIGHT_TO_LEFT = -1;
    static final char ELLIPSIS_NORMAL[];
    static final char ELLIPSIS_TWO_DOTS[];
    static final EmojiFactory EMOJI_FACTORY;
    static final int MAX_EMOJI = 0;
    static final int MIN_EMOJI = 0;
    private static final ParagraphStyle NO_PARA_SPANS[] = (ParagraphStyle[])ArrayUtils.emptyArray(android/text/style/ParagraphStyle);
    static final int RUN_LENGTH_MASK = 0x3ffffff;
    static final int RUN_LEVEL_MASK = 63;
    static final int RUN_LEVEL_SHIFT = 26;
    static final int RUN_RTL_FLAG = 0x4000000;
    private static final int TAB_INCREMENT = 20;
    private static final Rect sTempRect = new Rect();
    private Alignment mAlignment;
    private SpanSet mLineBackgroundSpans;
    private TextPaint mPaint;
    private float mSpacingAdd;
    private float mSpacingMult;
    private boolean mSpannedText;
    private CharSequence mText;
    private TextDirectionHeuristic mTextDir;
    private int mWidth;
    TextPaint mWorkPaint;

    static  {
        EMOJI_FACTORY = EmojiFactory.newAvailableInstance();
        int ai[];
        int ai1[];
        char ac[];
        char ac1[];
        if(EMOJI_FACTORY != null) {
            MIN_EMOJI = EMOJI_FACTORY.getMinimumAndroidPua();
            MAX_EMOJI = EMOJI_FACTORY.getMaximumAndroidPua();
        } else {
            MIN_EMOJI = -1;
            MAX_EMOJI = -1;
        }
        ai = new int[2];
        ai[0] = 0;
        ai[1] = 0x3ffffff;
        DIRS_ALL_LEFT_TO_RIGHT = new Directions(ai);
        ai1 = new int[2];
        ai1[0] = 0;
        ai1[1] = 0x7ffffff;
        DIRS_ALL_RIGHT_TO_LEFT = new Directions(ai1);
        ac = new char[1];
        ac[0] = '\u2026';
        ELLIPSIS_NORMAL = ac;
        ac1 = new char[1];
        ac1[0] = '\u2025';
        ELLIPSIS_TWO_DOTS = ac1;
    }

}
