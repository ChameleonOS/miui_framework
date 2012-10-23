// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text;

import android.content.res.Resources;
import android.os.Parcel;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.BulletSpan;
import android.text.style.CharacterStyle;
import android.text.style.EasyEditSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.QuoteSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ReplacementSpan;
import android.text.style.ScaleXSpan;
import android.text.style.SpellCheckSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuggestionRangeSpan;
import android.text.style.SuggestionSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.util.Printer;
import com.android.internal.util.ArrayUtils;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.regex.Pattern;

// Referenced classes of package android.text:
//            TextDirectionHeuristics, MeasuredText, SpannableStringBuilder, Spanned, 
//            SpannableString, SpannedString, Spannable, TextPaint, 
//            GetChars, ParcelableSpan, TextDirectionHeuristic, AndroidCharacter, 
//            Annotation

public class TextUtils {
    public static interface EllipsizeCallback {

        public abstract void ellipsized(int i, int j);
    }

    public static final class TruncateAt extends Enum {

        public static TruncateAt valueOf(String s) {
            return (TruncateAt)Enum.valueOf(android/text/TextUtils$TruncateAt, s);
        }

        public static TruncateAt[] values() {
            return (TruncateAt[])$VALUES.clone();
        }

        private static final TruncateAt $VALUES[];
        public static final TruncateAt END;
        public static final TruncateAt END_SMALL;
        public static final TruncateAt MARQUEE;
        public static final TruncateAt MIDDLE;
        public static final TruncateAt START;

        static  {
            START = new TruncateAt("START", 0);
            MIDDLE = new TruncateAt("MIDDLE", 1);
            END = new TruncateAt("END", 2);
            MARQUEE = new TruncateAt("MARQUEE", 3);
            END_SMALL = new TruncateAt("END_SMALL", 4);
            TruncateAt atruncateat[] = new TruncateAt[5];
            atruncateat[0] = START;
            atruncateat[1] = MIDDLE;
            atruncateat[2] = END;
            atruncateat[3] = MARQUEE;
            atruncateat[4] = END_SMALL;
            $VALUES = atruncateat;
        }

        private TruncateAt(String s, int i) {
            super(s, i);
        }
    }

    private static class Reverser
        implements CharSequence, GetChars {

        public char charAt(int i) {
            return AndroidCharacter.getMirror(mSource.charAt((-1 + mEnd) - i));
        }

        public void getChars(int i, int j, char ac[], int k) {
            TextUtils.getChars(mSource, i + mStart, j + mStart, ac, k);
            AndroidCharacter.mirror(ac, 0, j - i);
            int l = j - i;
            int i1 = (j - i) / 2;
            for(int j1 = 0; j1 < i1; j1++) {
                char c = ac[k + j1];
                ac[k + j1] = ac[-1 + ((k + l) - j1)];
                ac[-1 + ((k + l) - j1)] = c;
            }

        }

        public int length() {
            return mEnd - mStart;
        }

        public CharSequence subSequence(int i, int j) {
            char ac[] = new char[j - i];
            getChars(i, j, ac, 0);
            return new String(ac);
        }

        public String toString() {
            return subSequence(0, length()).toString();
        }

        private int mEnd;
        private CharSequence mSource;
        private int mStart;

        public Reverser(CharSequence charsequence, int i, int j) {
            mSource = charsequence;
            mStart = i;
            mEnd = j;
        }
    }

    public static class SimpleStringSplitter
        implements StringSplitter, Iterator {

        public boolean hasNext() {
            boolean flag;
            if(mPosition < mLength)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public Iterator iterator() {
            return this;
        }

        public volatile Object next() {
            return next();
        }

        public String next() {
            int i = mString.indexOf(mDelimiter, mPosition);
            if(i == -1)
                i = mLength;
            String s = mString.substring(mPosition, i);
            mPosition = i + 1;
            return s;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public void setString(String s) {
            mString = s;
            mPosition = 0;
            mLength = mString.length();
        }

        private char mDelimiter;
        private int mLength;
        private int mPosition;
        private String mString;

        public SimpleStringSplitter(char c) {
            mDelimiter = c;
        }
    }

    public static interface StringSplitter
        extends Iterable {

        public abstract void setString(String s);
    }


    private TextUtils() {
    }

    public static CharSequence commaEllipsize(CharSequence charsequence, TextPaint textpaint, float f, String s, String s1) {
        return commaEllipsize(charsequence, textpaint, f, s, s1, TextDirectionHeuristics.FIRSTSTRONG_LTR);
    }

    public static CharSequence commaEllipsize(CharSequence charsequence, TextPaint textpaint, float f, String s, String s1, TextDirectionHeuristic textdirectionheuristic) {
        MeasuredText measuredtext = MeasuredText.obtain();
        int i;
        float f1;
        i = charsequence.length();
        f1 = setPara(measuredtext, textpaint, charsequence, 0, i, textdirectionheuristic);
        if(f1 > f) goto _L2; else goto _L1
_L1:
        MeasuredText.recycle(measuredtext);
_L4:
        return charsequence;
_L2:
        char ac[];
        int j;
        ac = measuredtext.mChars;
        j = 0;
        Exception exception;
        int l;
        int i1;
        String s2;
        int j1;
        int k1;
        float af[];
        MeasuredText measuredtext1;
        SpannableStringBuilder spannablestringbuilder;
        StringBuilder stringbuilder;
        Object aobj[];
        String s3;
        for(int k = 0; k < i; k++) {
            if(ac[k] == ',')
                j++;
            break MISSING_BLOCK_LABEL_323;
        }

        l = j + 1;
        i1 = 0;
        s2 = "";
        j1 = 0;
        k1 = 0;
        af = measuredtext.mWidths;
        measuredtext1 = MeasuredText.obtain();
        for(int l1 = 0; l1 < i; l1++) {
            j1 = (int)((float)j1 + af[l1]);
            if(ac[l1] == ',') {
                k1++;
                if(--l == 1) {
                    s3 = (new StringBuilder()).append(" ").append(s).toString();
                } else {
                    stringbuilder = (new StringBuilder()).append(" ");
                    aobj = new Object[1];
                    aobj[0] = Integer.valueOf(l);
                    s3 = stringbuilder.append(String.format(s1, aobj)).toString();
                }
                measuredtext1.setPara(s3, 0, s3.length(), textdirectionheuristic);
                if(measuredtext1.addStyleRun(textpaint, measuredtext1.mLen, null) + (float)j1 <= f) {
                    i1 = l1 + 1;
                    s2 = s3;
                }
            }
            break MISSING_BLOCK_LABEL_329;
        }

        MeasuredText.recycle(measuredtext1);
        spannablestringbuilder = new SpannableStringBuilder(s2);
        spannablestringbuilder.insert(0, charsequence, 0, i1);
        MeasuredText.recycle(measuredtext);
        charsequence = spannablestringbuilder;
        if(true) goto _L4; else goto _L3
_L3:
        exception;
        MeasuredText.recycle(measuredtext);
        throw exception;
    }

    public static transient CharSequence concat(CharSequence acharsequence[]) {
        if(acharsequence.length != 0) goto _L2; else goto _L1
_L1:
        Object obj = "";
_L4:
        return ((CharSequence) (obj));
_L2:
        if(acharsequence.length == 1) {
            obj = acharsequence[0];
            continue; /* Loop/switch isn't completed */
        }
        boolean flag = false;
        int i = 0;
        StringBuilder stringbuilder;
label0:
        do {
label1:
            {
                if(i < acharsequence.length) {
                    if(!(acharsequence[i] instanceof Spanned))
                        break label1;
                    flag = true;
                }
                stringbuilder = new StringBuilder();
                for(int j = 0; j < acharsequence.length; j++)
                    stringbuilder.append(acharsequence[j]);

                break label0;
            }
            i++;
        } while(true);
        if(!flag) {
            obj = stringbuilder.toString();
        } else {
            SpannableString spannablestring = new SpannableString(stringbuilder);
            int k = 0;
            for(int l = 0; l < acharsequence.length; l++) {
                int i1 = acharsequence[l].length();
                if(acharsequence[l] instanceof Spanned)
                    copySpansFrom((Spanned)acharsequence[l], 0, i1, java/lang/Object, spannablestring, k);
                k += i1;
            }

            obj = new SpannedString(spannablestring);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static void copySpansFrom(Spanned spanned, int i, int j, Class class1, Spannable spannable, int k) {
        if(class1 == null)
            class1 = java/lang/Object;
        Object aobj[] = spanned.getSpans(i, j, class1);
        for(int l = 0; l < aobj.length; l++) {
            int i1 = spanned.getSpanStart(aobj[l]);
            int j1 = spanned.getSpanEnd(aobj[l]);
            int k1 = spanned.getSpanFlags(aobj[l]);
            if(i1 < i)
                i1 = i;
            if(j1 > j)
                j1 = j;
            spannable.setSpan(aobj[l], k + (i1 - i), k + (j1 - i), k1);
        }

    }

    public static boolean delimitedStringContains(String s, char c, String s1) {
        boolean flag = true;
        if(!isEmpty(s) && !isEmpty(s1)) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        int i = -1;
        int j = s.length();
        do {
            i = s.indexOf(s1, i + 1);
            if(i == -1)
                break;
            if(i <= 0 || s.charAt(i - 1) == c) {
                int k = i + s1.length();
                if(k == j || s.charAt(k) == c)
                    continue; /* Loop/switch isn't completed */
            }
        } while(true);
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    static boolean doesNotNeedBidi(CharSequence charsequence, int i, int j) {
        int k = i;
_L3:
        if(k >= j)
            break MISSING_BLOCK_LABEL_32;
        if(charsequence.charAt(k) < '\u0590') goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        k++;
          goto _L3
        flag = true;
          goto _L4
    }

    static boolean doesNotNeedBidi(char ac[], int i, int j) {
        int k;
        int l;
        k = i;
        l = k + j;
_L3:
        if(k >= l)
            break MISSING_BLOCK_LABEL_34;
        if(ac[k] < '\u0590') goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        k++;
          goto _L3
        flag = true;
          goto _L4
    }

    public static void dumpSpans(CharSequence charsequence, Printer printer, String s) {
        if(charsequence instanceof Spanned) {
            Spanned spanned = (Spanned)charsequence;
            Object aobj[] = spanned.getSpans(0, charsequence.length(), java/lang/Object);
            for(int i = 0; i < aobj.length; i++) {
                Object obj = aobj[i];
                printer.println((new StringBuilder()).append(s).append(charsequence.subSequence(spanned.getSpanStart(obj), spanned.getSpanEnd(obj))).append(": ").append(Integer.toHexString(System.identityHashCode(obj))).append(" ").append(obj.getClass().getCanonicalName()).append(" (").append(spanned.getSpanStart(obj)).append("-").append(spanned.getSpanEnd(obj)).append(") fl=#").append(spanned.getSpanFlags(obj)).toString());
            }

        } else {
            printer.println((new StringBuilder()).append(s).append(charsequence).append(": (no spans)").toString());
        }
    }

    public static CharSequence ellipsize(CharSequence charsequence, TextPaint textpaint, float f, TruncateAt truncateat) {
        return ellipsize(charsequence, textpaint, f, truncateat, false, null);
    }

    public static CharSequence ellipsize(CharSequence charsequence, TextPaint textpaint, float f, TruncateAt truncateat, boolean flag, EllipsizeCallback ellipsizecallback) {
        TextDirectionHeuristic textdirectionheuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        String s;
        if(truncateat == TruncateAt.END_SMALL)
            s = ELLIPSIS_TWO_DOTS;
        else
            s = ELLIPSIS_NORMAL;
        return ellipsize(charsequence, textpaint, f, truncateat, flag, ellipsizecallback, textdirectionheuristic, s);
    }

    public static CharSequence ellipsize(CharSequence charsequence, TextPaint textpaint, float f, TruncateAt truncateat, boolean flag, EllipsizeCallback ellipsizecallback, TextDirectionHeuristic textdirectionheuristic, String s) {
        int i;
        MeasuredText measuredtext;
        i = charsequence.length();
        measuredtext = MeasuredText.obtain();
        int j = charsequence.length();
        if(setPara(measuredtext, textpaint, charsequence, 0, j, textdirectionheuristic) > f) goto _L2; else goto _L1
_L1:
        if(ellipsizecallback != null)
            ellipsizecallback.ellipsized(0, 0);
        MeasuredText.recycle(measuredtext);
_L8:
        return charsequence;
_L2:
        int k;
        int l;
        char ac[];
        Spanned spanned;
        int i1;
        int k1;
        int l1;
        float f1 = f - textpaint.measureText(s);
        k = i;
        if(f1 < 0.0F)
            l = 0;
        else
        if(truncateat == TruncateAt.START) {
            k = i - measuredtext.breakText(i, false, f1);
            l = 0;
        } else
        if(truncateat == TruncateAt.END || truncateat == TruncateAt.END_SMALL) {
            l = measuredtext.breakText(i, true, f1);
        } else {
            k = i - measuredtext.breakText(i, false, f1 / 2.0F);
            float f2 = f1 - measuredtext.measure(k, i);
            l = measuredtext.breakText(k, true, f2);
        }
        if(ellipsizecallback != null)
            ellipsizecallback.ellipsized(l, k);
        ac = measuredtext.mChars;
        if(!(charsequence instanceof Spanned))
            break MISSING_BLOCK_LABEL_518;
        spanned = (Spanned)charsequence;
_L10:
        i1 = i - (k - l);
        if(!flag) goto _L4; else goto _L3
_L3:
        if(i1 <= 0) goto _L6; else goto _L5
_L5:
        k1 = l + 1;
        ac[l] = s.charAt(0);
          goto _L7
_L9:
        String s2;
        for(; l1 < k; l1++)
            ac[l1] = '\uFEFF';

        s2 = new String(ac, 0, i);
label0:
        {
            if(spanned != null)
                break label0;
            MeasuredText.recycle(measuredtext);
            charsequence = s2;
        }
          goto _L8
        SpannableString spannablestring;
        spannablestring = new SpannableString(s2);
        copySpansFrom(spanned, 0, i, java/lang/Object, spannablestring, 0);
        MeasuredText.recycle(measuredtext);
        charsequence = spannablestring;
          goto _L8
_L4:
        if(i1 != 0)
            break MISSING_BLOCK_LABEL_367;
        charsequence = "";
        MeasuredText.recycle(measuredtext);
          goto _L8
        if(spanned != null)
            break MISSING_BLOCK_LABEL_446;
        String s1;
        StringBuilder stringbuilder = new StringBuilder(i1 + s.length());
        stringbuilder.append(ac, 0, l);
        stringbuilder.append(s);
        int j1 = i - k;
        stringbuilder.append(ac, k, j1);
        s1 = stringbuilder.toString();
        charsequence = s1;
        MeasuredText.recycle(measuredtext);
          goto _L8
        SpannableStringBuilder spannablestringbuilder;
        spannablestringbuilder = new SpannableStringBuilder();
        spannablestringbuilder.append(charsequence, 0, l);
        spannablestringbuilder.append(s);
        spannablestringbuilder.append(charsequence, k, i);
        MeasuredText.recycle(measuredtext);
        charsequence = spannablestringbuilder;
          goto _L8
        Exception exception;
        exception;
        MeasuredText.recycle(measuredtext);
        throw exception;
_L6:
        k1 = l;
_L7:
        l1 = k1;
          goto _L9
        spanned = null;
          goto _L10
    }

    public static boolean equals(CharSequence charsequence, CharSequence charsequence1) {
        boolean flag = true;
        if(charsequence != charsequence1) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(charsequence != null && charsequence1 != null) {
            int i = charsequence.length();
            if(i == charsequence1.length()) {
                if((charsequence instanceof String) && (charsequence1 instanceof String)) {
                    flag = charsequence.equals(charsequence1);
                    continue; /* Loop/switch isn't completed */
                }
                int j = 0;
                do {
                    if(j >= i)
                        continue; /* Loop/switch isn't completed */
                    if(charsequence.charAt(j) != charsequence1.charAt(j)) {
                        flag = false;
                        continue; /* Loop/switch isn't completed */
                    }
                    j++;
                } while(true);
            }
        }
        flag = false;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static transient CharSequence expandTemplate(CharSequence charsequence, CharSequence acharsequence[]) {
        if(acharsequence.length > 9)
            throw new IllegalArgumentException("max of 9 values are supported");
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(charsequence);
        int i = 0;
label0:
        do {
label1:
            {
                int k;
                try {
                    if(i >= spannablestringbuilder.length())
                        break label0;
                    if(spannablestringbuilder.charAt(i) != '^')
                        break label1;
                    char c = spannablestringbuilder.charAt(i + 1);
                    if(c == '^') {
                        spannablestringbuilder.delete(i + 1, i + 2);
                        i++;
                        continue;
                    }
                    if(!Character.isDigit(c))
                        break label1;
                    int j = -1 + Character.getNumericValue(c);
                    if(j < 0)
                        throw new IllegalArgumentException((new StringBuilder()).append("template requests value ^").append(j + 1).toString());
                    if(j >= acharsequence.length)
                        throw new IllegalArgumentException((new StringBuilder()).append("template requests value ^").append(j + 1).append("; only ").append(acharsequence.length).append(" provided").toString());
                    spannablestringbuilder.replace(i, i + 2, acharsequence[j]);
                    k = acharsequence[j].length();
                }
                catch(IndexOutOfBoundsException indexoutofboundsexception) {
                    break label0;
                }
                i += k;
                continue;
            }
            i++;
        } while(true);
        return spannablestringbuilder;
    }

    public static int getCapsMode(CharSequence charsequence, int i, int j) {
        int k;
        int l;
        int i1;
        if(i < 0) {
            k = 0;
        } else {
            k = 0;
            if((j & 0x1000) != 0)
                k = 0 | 0x1000;
            if((j & 0x6000) != 0) {
                l = i;
label0:
                do {
label1:
                    {
                        if(l > 0) {
                            char c4 = charsequence.charAt(l - 1);
                            if(c4 == '"' || c4 == '\'' || Character.getType(c4) == 21)
                                break label1;
                        }
                        i1 = l;
                        do {
                            if(i1 <= 0)
                                break;
                            char c3 = charsequence.charAt(i1 - 1);
                            if(c3 != ' ' && c3 != '\t')
                                break;
                            i1--;
                        } while(true);
                        break label0;
                    }
                    l--;
                } while(true);
label2:
                {
                    if(i1 != 0 && charsequence.charAt(i1 - 1) != '\n')
                        break label2;
                    k |= 0x2000;
                }
            }
        }
_L3:
        return k;
        if((j & 0x4000) != 0) goto _L2; else goto _L1
_L1:
        if(l != i1)
            k |= 0x2000;
          goto _L3
_L2:
        if(l == i1) goto _L3; else goto _L4
_L4:
        if(i1 <= 0) goto _L6; else goto _L5
_L5:
        char c2 = charsequence.charAt(i1 - 1);
        if(c2 == '"' || c2 == '\'' || Character.getType(c2) == 22) goto _L7; else goto _L6
_L6:
        if(i1 <= 0) goto _L3; else goto _L8
_L8:
        char c = charsequence.charAt(i1 - 1);
        if(c != '.' && c != '?' && c != '!') goto _L3; else goto _L9
_L9:
        if(c != '.') goto _L11; else goto _L10
_L10:
        int j1 = i1 - 2;
_L14:
        if(j1 < 0) goto _L11; else goto _L12
_L12:
        char c1 = charsequence.charAt(j1);
        if(c1 == '.') goto _L3; else goto _L13
_L13:
        if(Character.isLetter(c1))
            break MISSING_BLOCK_LABEL_320;
_L11:
        k |= 0x4000;
          goto _L3
_L7:
        i1--;
          goto _L4
        j1--;
          goto _L14
    }

    public static void getChars(CharSequence charsequence, int i, int j, char ac[], int k) {
        Class class1 = charsequence.getClass();
        if(class1 == java/lang/String)
            ((String)charsequence).getChars(i, j, ac, k);
        else
        if(class1 == java/lang/StringBuffer)
            ((StringBuffer)charsequence).getChars(i, j, ac, k);
        else
        if(class1 == java/lang/StringBuilder)
            ((StringBuilder)charsequence).getChars(i, j, ac, k);
        else
        if(charsequence instanceof GetChars) {
            ((GetChars)charsequence).getChars(i, j, ac, k);
        } else {
            int l = i;
            int i1;
            int j1;
            for(i1 = k; l < j; i1 = j1) {
                j1 = i1 + 1;
                ac[i1] = charsequence.charAt(l);
                l++;
            }

            int _tmp = i1;
        }
    }

    public static int getOffsetAfter(CharSequence charsequence, int i) {
        int j;
        j = charsequence.length();
        break MISSING_BLOCK_LABEL_7;
        if(i != j && i != j - 1) {
            char c = charsequence.charAt(i);
            int k;
            if(c >= '\uD800' && c <= '\uDBFF') {
                char c1 = charsequence.charAt(i + 1);
                ReplacementSpan areplacementspan[];
                int l;
                int i1;
                int j1;
                if(c1 >= '\uDC00' && c1 <= '\uDFFF')
                    k = i + 2;
                else
                    k = i + 1;
            } else {
                k = i + 1;
            }
            if(charsequence instanceof Spanned) {
                areplacementspan = (ReplacementSpan[])((Spanned)charsequence).getSpans(k, k, android/text/style/ReplacementSpan);
                for(l = 0; l < areplacementspan.length; l++) {
                    i1 = ((Spanned)charsequence).getSpanStart(areplacementspan[l]);
                    j1 = ((Spanned)charsequence).getSpanEnd(areplacementspan[l]);
                    if(i1 < k && j1 > k)
                        k = j1;
                }

            }
            j = k;
        }
        return j;
    }

    public static int getOffsetBefore(CharSequence charsequence, int i) {
        int j;
        j = 0;
        break MISSING_BLOCK_LABEL_2;
        if(i != 0 && i != 1) {
            char c = charsequence.charAt(i - 1);
            int k;
            if(c >= '\uDC00' && c <= '\uDFFF') {
                char c1 = charsequence.charAt(i - 2);
                ReplacementSpan areplacementspan[];
                int l;
                int i1;
                int j1;
                if(c1 >= '\uD800' && c1 <= '\uDBFF')
                    k = i - 2;
                else
                    k = i - 1;
            } else {
                k = i - 1;
            }
            if(charsequence instanceof Spanned) {
                areplacementspan = (ReplacementSpan[])((Spanned)charsequence).getSpans(k, k, android/text/style/ReplacementSpan);
                for(l = 0; l < areplacementspan.length; l++) {
                    i1 = ((Spanned)charsequence).getSpanStart(areplacementspan[l]);
                    j1 = ((Spanned)charsequence).getSpanEnd(areplacementspan[l]);
                    if(i1 < k && j1 > k)
                        k = i1;
                }

            }
            j = k;
        }
        return j;
    }

    public static CharSequence getReverse(CharSequence charsequence, int i, int j) {
        return new Reverser(charsequence, i, j);
    }

    public static int getTrimmedLength(CharSequence charsequence) {
        int i = charsequence.length();
        int j;
        for(j = 0; j < i && charsequence.charAt(j) <= ' '; j++);
        int k;
        for(k = i; k > j && charsequence.charAt(k - 1) <= ' '; k--);
        return k - j;
    }

    public static String htmlEncode(String s) {
        StringBuilder stringbuilder;
        int i;
        stringbuilder = new StringBuilder();
        i = 0;
_L8:
        char c;
        if(i >= s.length())
            break MISSING_BLOCK_LABEL_143;
        c = s.charAt(i);
        c;
        JVM INSTR lookupswitch 5: default 76
    //                   34: 132
    //                   38: 110
    //                   39: 121
    //                   60: 88
    //                   62: 99;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L2:
        break MISSING_BLOCK_LABEL_132;
_L5:
        break; /* Loop/switch isn't completed */
_L1:
        stringbuilder.append(c);
_L9:
        i++;
        if(true) goto _L8; else goto _L7
_L7:
        stringbuilder.append("&lt;");
          goto _L9
_L6:
        stringbuilder.append("&gt;");
          goto _L9
_L3:
        stringbuilder.append("&amp;");
          goto _L9
_L4:
        stringbuilder.append("&#39;");
          goto _L9
        stringbuilder.append("&quot;");
          goto _L9
        return stringbuilder.toString();
    }

    public static int indexOf(CharSequence charsequence, char c) {
        return indexOf(charsequence, c, 0);
    }

    public static int indexOf(CharSequence charsequence, char c, int i) {
        int j;
        if(charsequence.getClass() == java/lang/String)
            j = ((String)charsequence).indexOf(c, i);
        else
            j = indexOf(charsequence, c, i, charsequence.length());
        return j;
    }

    public static int indexOf(CharSequence charsequence, char c, int i, int j) {
        Class class1 = charsequence.getClass();
        if(!(charsequence instanceof GetChars) && class1 != java/lang/StringBuffer && class1 != java/lang/StringBuilder && class1 != java/lang/String) goto _L2; else goto _L1
_L1:
        char ac[] = obtain(500);
_L10:
        if(i >= j) goto _L4; else goto _L3
_L3:
        int l;
        int i1;
        int j1;
        l = i + 500;
        if(l > j)
            l = j;
        getChars(charsequence, i, l, ac, 0);
        i1 = l - i;
        j1 = 0;
_L9:
        if(j1 >= i1) goto _L6; else goto _L5
_L5:
        if(ac[j1] != c) goto _L8; else goto _L7
_L7:
        int k;
        recycle(ac);
        k = j1 + i;
_L11:
        return k;
_L8:
        j1++;
          goto _L9
_L6:
        i = l;
          goto _L10
_L4:
        recycle(ac);
        k = -1;
          goto _L11
_L2:
        k = i;
_L13:
        if(k >= j)
            break MISSING_BLOCK_LABEL_164;
        if(charsequence.charAt(k) == c) goto _L11; else goto _L12
_L12:
        k++;
          goto _L13
        k = -1;
          goto _L11
    }

    public static int indexOf(CharSequence charsequence, CharSequence charsequence1) {
        return indexOf(charsequence, charsequence1, 0, charsequence.length());
    }

    public static int indexOf(CharSequence charsequence, CharSequence charsequence1, int i) {
        return indexOf(charsequence, charsequence1, i, charsequence.length());
    }

    public static int indexOf(CharSequence charsequence, CharSequence charsequence1, int i, int j) {
        int k;
        int l;
        k = -1;
        l = charsequence1.length();
        if(l != 0) goto _L2; else goto _L1
_L1:
        k = i;
_L4:
        return k;
_L2:
        char c = charsequence1.charAt(0);
        do {
            int i1 = indexOf(charsequence, c, i);
            if(i1 <= j - l && i1 >= 0) {
label0:
                {
                    if(!regionMatches(charsequence, i1, charsequence1, 0, l))
                        break label0;
                    k = i1;
                }
            }
            if(true)
                continue;
            i = i1 + 1;
        } while(true);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static boolean isDigitsOnly(CharSequence charsequence) {
        int i;
        int j;
        i = charsequence.length();
        j = 0;
_L3:
        if(j >= i)
            break MISSING_BLOCK_LABEL_37;
        if(Character.isDigit(charsequence.charAt(j))) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        j++;
          goto _L3
        flag = true;
          goto _L4
    }

    public static boolean isEmpty(CharSequence charsequence) {
        boolean flag;
        if(charsequence == null || charsequence.length() == 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isGraphic(char c) {
        int i = Character.getType(c);
        boolean flag;
        if(i != 15 && i != 16 && i != 19 && i != 0 && i != 13 && i != 14 && i != 12)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isGraphic(CharSequence charsequence) {
        int i;
        int j;
        i = charsequence.length();
        j = 0;
_L3:
        int k;
        if(j >= i)
            break MISSING_BLOCK_LABEL_83;
        k = Character.getType(charsequence.charAt(j));
        if(k == 15 || k == 16 || k == 19 || k == 0 || k == 13 || k == 14 || k == 12) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        j++;
          goto _L3
        flag = false;
          goto _L4
    }

    public static boolean isPrintableAscii(char c) {
        boolean flag;
        if(' ' <= c && c <= '~' || c == '\r' || c == '\n')
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isPrintableAsciiOnly(CharSequence charsequence) {
        int i;
        int j;
        i = charsequence.length();
        j = 0;
_L3:
        if(j >= i)
            break MISSING_BLOCK_LABEL_37;
        if(isPrintableAscii(charsequence.charAt(j))) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        j++;
          goto _L3
        flag = true;
          goto _L4
    }

    public static CharSequence join(Iterable iterable) {
        return join(Resources.getSystem().getText(0x10404f7), iterable);
    }

    public static String join(CharSequence charsequence, Iterable iterable) {
        StringBuilder stringbuilder = new StringBuilder();
        boolean flag = true;
        Iterator iterator = iterable.iterator();
        while(iterator.hasNext())  {
            Object obj = iterator.next();
            if(flag)
                flag = false;
            else
                stringbuilder.append(charsequence);
            stringbuilder.append(obj);
        }
        return stringbuilder.toString();
    }

    public static String join(CharSequence charsequence, Object aobj[]) {
        StringBuilder stringbuilder = new StringBuilder();
        boolean flag = true;
        int i = aobj.length;
        int j = 0;
        while(j < i)  {
            Object obj = aobj[j];
            if(flag)
                flag = false;
            else
                stringbuilder.append(charsequence);
            stringbuilder.append(obj);
            j++;
        }
        return stringbuilder.toString();
    }

    public static int lastIndexOf(CharSequence charsequence, char c) {
        return lastIndexOf(charsequence, c, -1 + charsequence.length());
    }

    public static int lastIndexOf(CharSequence charsequence, char c, int i) {
        int j;
        if(charsequence.getClass() == java/lang/String)
            j = ((String)charsequence).lastIndexOf(c, i);
        else
            j = lastIndexOf(charsequence, c, 0, i);
        return j;
    }

    public static int lastIndexOf(CharSequence charsequence, char c, int i, int j) {
        if(j >= 0) goto _L2; else goto _L1
_L1:
        int l = -1;
_L4:
        return l;
_L2:
        if(j >= charsequence.length())
            j = -1 + charsequence.length();
        int k = j + 1;
        Class class1 = charsequence.getClass();
        if((charsequence instanceof GetChars) || class1 == java/lang/StringBuffer || class1 == java/lang/StringBuilder || class1 == java/lang/String) {
            char ac[] = obtain(500);
            int i1;
label0:
            for(; i < k; k = i1) {
                i1 = k - 500;
                if(i1 < i)
                    i1 = i;
                getChars(charsequence, i1, k, ac, 0);
                int j1 = -1 + (k - i1);
                do {
                    if(j1 < 0)
                        continue label0;
                    if(ac[j1] == c) {
                        recycle(ac);
                        l = j1 + i1;
                        continue; /* Loop/switch isn't completed */
                    }
                    j1--;
                } while(true);
            }

            recycle(ac);
            l = -1;
            continue; /* Loop/switch isn't completed */
        }
        for(l = k - 1; l >= i; l--)
            if(charsequence.charAt(l) == c)
                continue; /* Loop/switch isn't completed */

        l = -1;
        if(true) goto _L4; else goto _L3
_L3:
    }

    static char[] obtain(int i) {
        char ac[];
        synchronized(sLock) {
            ac = sTemp;
            sTemp = null;
        }
        if(ac == null || ac.length < i)
            ac = new char[ArrayUtils.idealCharArraySize(i)];
        return ac;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static long packRangeInLong(int i, int j) {
        return (long)i << 32 | (long)j;
    }

    private static void readSpan(Parcel parcel, Spannable spannable, Object obj) {
        spannable.setSpan(obj, parcel.readInt(), parcel.readInt(), parcel.readInt());
    }

    static void recycle(char ac[]) {
        if(ac.length <= 1000) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj = sLock;
        obj;
        JVM INSTR monitorenter ;
        sTemp = ac;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static boolean regionMatches(CharSequence charsequence, int i, CharSequence charsequence1, int j, int k) {
        char ac[] = obtain(k * 2);
        getChars(charsequence, i, i + k, ac, 0);
        getChars(charsequence1, j, j + k, ac, k);
        boolean flag = true;
        int l = 0;
        do {
label0:
            {
                if(l < k) {
                    if(ac[l] == ac[l + k])
                        break label0;
                    flag = false;
                }
                recycle(ac);
                return flag;
            }
            l++;
        } while(true);
    }

    public static Object[] removeEmptySpans(Object aobj[], Spanned spanned, Class class1) {
        Object aobj1[] = null;
        int i = 0;
        int j = 0;
        while(j < aobj.length)  {
            Object obj = aobj[j];
            if(spanned.getSpanStart(obj) == spanned.getSpanEnd(obj)) {
                if(aobj1 == null) {
                    aobj1 = (Object[])(Object[])Array.newInstance(class1, -1 + aobj.length);
                    System.arraycopy(((Object) (aobj)), 0, ((Object) (aobj1)), 0, j);
                    i = j;
                }
            } else
            if(aobj1 != null) {
                aobj1[i] = obj;
                i++;
            }
            j++;
        }
        Object aobj2[];
        if(aobj1 != null) {
            aobj2 = (Object[])(Object[])Array.newInstance(class1, i);
            System.arraycopy(((Object) (aobj1)), 0, ((Object) (aobj2)), 0, i);
        } else {
            aobj2 = aobj;
        }
        return aobj2;
    }

    public static CharSequence replace(CharSequence charsequence, String as[], CharSequence acharsequence[]) {
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(charsequence);
        for(int i = 0; i < as.length; i++) {
            int i1 = indexOf(spannablestringbuilder, as[i]);
            if(i1 >= 0)
                spannablestringbuilder.setSpan(as[i], i1, i1 + as[i].length(), 33);
        }

        for(int j = 0; j < as.length; j++) {
            int k = spannablestringbuilder.getSpanStart(as[j]);
            int l = spannablestringbuilder.getSpanEnd(as[j]);
            if(k >= 0)
                spannablestringbuilder.replace(k, l, acharsequence[j]);
        }

        return spannablestringbuilder;
    }

    private static float setPara(MeasuredText measuredtext, TextPaint textpaint, CharSequence charsequence, int i, int j, TextDirectionHeuristic textdirectionheuristic) {
        measuredtext.setPara(charsequence, i, j, textdirectionheuristic);
        Spanned spanned;
        int k;
        float f;
        if(charsequence instanceof Spanned)
            spanned = (Spanned)charsequence;
        else
            spanned = null;
        k = j - i;
        if(spanned == null) {
            f = measuredtext.addStyleRun(textpaint, k, null);
        } else {
            f = 0.0F;
            int l = 0;
            while(l < k)  {
                int i1 = spanned.nextSpanTransition(l, k, android/text/style/MetricAffectingSpan);
                f += measuredtext.addStyleRun(textpaint, (MetricAffectingSpan[])removeEmptySpans((MetricAffectingSpan[])spanned.getSpans(l, i1, android/text/style/MetricAffectingSpan), spanned, android/text/style/MetricAffectingSpan), i1 - l, null);
                l = i1;
            }
        }
        return f;
    }

    public static String[] split(String s, String s1) {
        String as[];
        if(s.length() == 0)
            as = EMPTY_STRING_ARRAY;
        else
            as = s.split(s1, -1);
        return as;
    }

    public static String[] split(String s, Pattern pattern) {
        String as[];
        if(s.length() == 0)
            as = EMPTY_STRING_ARRAY;
        else
            as = pattern.split(s, -1);
        return as;
    }

    public static CharSequence stringOrSpannedString(CharSequence charsequence) {
        if(charsequence != null) goto _L2; else goto _L1
_L1:
        charsequence = null;
_L4:
        return charsequence;
_L2:
        if(!(charsequence instanceof SpannedString))
            if(charsequence instanceof Spanned)
                charsequence = new SpannedString(charsequence);
            else
                charsequence = charsequence.toString();
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static String substring(CharSequence charsequence, int i, int j) {
        String s;
        if(charsequence instanceof String)
            s = ((String)charsequence).substring(i, j);
        else
        if(charsequence instanceof StringBuilder)
            s = ((StringBuilder)charsequence).substring(i, j);
        else
        if(charsequence instanceof StringBuffer) {
            s = ((StringBuffer)charsequence).substring(i, j);
        } else {
            char ac[] = obtain(j - i);
            getChars(charsequence, i, j, ac, 0);
            s = new String(ac, 0, j - i);
            recycle(ac);
        }
        return s;
    }

    public static int unpackRangeEndFromLong(long l) {
        return (int)(0xffffffffL & l);
    }

    public static int unpackRangeStartFromLong(long l) {
        return (int)(l >>> 32);
    }

    public static void writeToParcel(CharSequence charsequence, Parcel parcel, int i) {
        if(charsequence instanceof Spanned) {
            parcel.writeInt(0);
            parcel.writeString(charsequence.toString());
            Spanned spanned = (Spanned)charsequence;
            Object aobj[] = spanned.getSpans(0, charsequence.length(), java/lang/Object);
            for(int j = 0; j < aobj.length; j++) {
                Object obj = aobj[j];
                Object obj1 = aobj[j];
                if(obj1 instanceof CharacterStyle)
                    obj1 = ((CharacterStyle)obj1).getUnderlying();
                if(obj1 instanceof ParcelableSpan) {
                    ParcelableSpan parcelablespan = (ParcelableSpan)obj1;
                    parcel.writeInt(parcelablespan.getSpanTypeId());
                    parcelablespan.writeToParcel(parcel, i);
                    writeWhere(parcel, spanned, obj);
                }
            }

            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            if(charsequence != null)
                parcel.writeString(charsequence.toString());
            else
                parcel.writeString(null);
        }
    }

    private static void writeWhere(Parcel parcel, Spanned spanned, Object obj) {
        parcel.writeInt(spanned.getSpanStart(obj));
        parcel.writeInt(spanned.getSpanEnd(obj));
        parcel.writeInt(spanned.getSpanFlags(obj));
    }

    public static final int ABSOLUTE_SIZE_SPAN = 16;
    public static final int ALIGNMENT_SPAN = 1;
    public static final int ANNOTATION = 18;
    public static final int BACKGROUND_COLOR_SPAN = 12;
    public static final int BULLET_SPAN = 8;
    public static final int CAP_MODE_CHARACTERS = 4096;
    public static final int CAP_MODE_SENTENCES = 16384;
    public static final int CAP_MODE_WORDS = 8192;
    public static final android.os.Parcelable.Creator CHAR_SEQUENCE_CREATOR = new android.os.Parcelable.Creator() {

        public CharSequence createFromParcel(Parcel parcel) {
            int i;
            Object obj;
            i = parcel.readInt();
            obj = parcel.readString();
            if(obj != null) goto _L2; else goto _L1
_L1:
            obj = null;
_L4:
            return ((CharSequence) (obj));
_L2:
            if(i == 1)
                continue; /* Loop/switch isn't completed */
            SpannableString spannablestring = new SpannableString(((CharSequence) (obj)));
            do {
                int j = parcel.readInt();
                if(j == 0) {
                    obj = spannablestring;
                    continue; /* Loop/switch isn't completed */
                }
                switch(j) {
                default:
                    throw new RuntimeException((new StringBuilder()).append("bogus span encoding ").append(j).toString());

                case 1: // '\001'
                    TextUtils.readSpan(parcel, spannablestring, new Standard(parcel));
                    break;

                case 2: // '\002'
                    TextUtils.readSpan(parcel, spannablestring, new ForegroundColorSpan(parcel));
                    break;

                case 3: // '\003'
                    TextUtils.readSpan(parcel, spannablestring, new RelativeSizeSpan(parcel));
                    break;

                case 4: // '\004'
                    TextUtils.readSpan(parcel, spannablestring, new ScaleXSpan(parcel));
                    break;

                case 5: // '\005'
                    TextUtils.readSpan(parcel, spannablestring, new StrikethroughSpan(parcel));
                    break;

                case 6: // '\006'
                    TextUtils.readSpan(parcel, spannablestring, new UnderlineSpan(parcel));
                    break;

                case 7: // '\007'
                    TextUtils.readSpan(parcel, spannablestring, new StyleSpan(parcel));
                    break;

                case 8: // '\b'
                    TextUtils.readSpan(parcel, spannablestring, new BulletSpan(parcel));
                    break;

                case 9: // '\t'
                    TextUtils.readSpan(parcel, spannablestring, new QuoteSpan(parcel));
                    break;

                case 10: // '\n'
                    TextUtils.readSpan(parcel, spannablestring, new Standard(parcel));
                    break;

                case 11: // '\013'
                    TextUtils.readSpan(parcel, spannablestring, new URLSpan(parcel));
                    break;

                case 12: // '\f'
                    TextUtils.readSpan(parcel, spannablestring, new BackgroundColorSpan(parcel));
                    break;

                case 13: // '\r'
                    TextUtils.readSpan(parcel, spannablestring, new TypefaceSpan(parcel));
                    break;

                case 14: // '\016'
                    TextUtils.readSpan(parcel, spannablestring, new SuperscriptSpan(parcel));
                    break;

                case 15: // '\017'
                    TextUtils.readSpan(parcel, spannablestring, new SubscriptSpan(parcel));
                    break;

                case 16: // '\020'
                    TextUtils.readSpan(parcel, spannablestring, new AbsoluteSizeSpan(parcel));
                    break;

                case 17: // '\021'
                    TextUtils.readSpan(parcel, spannablestring, new TextAppearanceSpan(parcel));
                    break;

                case 18: // '\022'
                    TextUtils.readSpan(parcel, spannablestring, new Annotation(parcel));
                    break;

                case 19: // '\023'
                    TextUtils.readSpan(parcel, spannablestring, new SuggestionSpan(parcel));
                    break;

                case 20: // '\024'
                    TextUtils.readSpan(parcel, spannablestring, new SpellCheckSpan(parcel));
                    break;

                case 21: // '\025'
                    TextUtils.readSpan(parcel, spannablestring, new SuggestionRangeSpan(parcel));
                    break;

                case 22: // '\026'
                    TextUtils.readSpan(parcel, spannablestring, new EasyEditSpan());
                    break;
                }
            } while(true);
            if(true) goto _L4; else goto _L3
_L3:
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public CharSequence[] newArray(int i) {
            return new CharSequence[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int EASY_EDIT_SPAN = 22;
    private static final String ELLIPSIS_NORMAL = Resources.getSystem().getString(0x10400c4);
    private static final String ELLIPSIS_TWO_DOTS = Resources.getSystem().getString(0x10400c5);
    private static String EMPTY_STRING_ARRAY[] = new String[0];
    private static final char FIRST_RIGHT_TO_LEFT = 1424;
    public static final int FOREGROUND_COLOR_SPAN = 2;
    public static final int LEADING_MARGIN_SPAN = 10;
    public static final int QUOTE_SPAN = 9;
    public static final int RELATIVE_SIZE_SPAN = 3;
    public static final int SCALE_X_SPAN = 4;
    public static final int SPELL_CHECK_SPAN = 20;
    public static final int STRIKETHROUGH_SPAN = 5;
    public static final int STYLE_SPAN = 7;
    public static final int SUBSCRIPT_SPAN = 15;
    public static final int SUGGESTION_RANGE_SPAN = 21;
    public static final int SUGGESTION_SPAN = 19;
    public static final int SUPERSCRIPT_SPAN = 14;
    public static final int TEXT_APPEARANCE_SPAN = 17;
    public static final int TYPEFACE_SPAN = 13;
    public static final int UNDERLINE_SPAN = 6;
    public static final int URL_SPAN = 11;
    private static final char ZWNBS_CHAR = 65279;
    private static Object sLock = new Object();
    private static char sTemp[] = null;


}
