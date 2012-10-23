// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import com.android.internal.util.ArrayUtils;
import java.io.IOException;
import java.lang.reflect.Array;

// Referenced classes of package android.text:
//            GetChars, Spannable, Editable, GraphicsOperations, 
//            InputFilter, TextUtils, Spanned, NoCopySpan, 
//            TextWatcher, SpanWatcher, Selection

public class SpannableStringBuilder
    implements CharSequence, GetChars, Spannable, Editable, Appendable, GraphicsOperations {

    public SpannableStringBuilder() {
        this("");
    }

    public SpannableStringBuilder(CharSequence charsequence) {
        this(charsequence, 0, charsequence.length());
    }

    public SpannableStringBuilder(CharSequence charsequence, int i, int j) {
        mFilters = NO_FILTERS;
        int k = j - i;
        if(k < 0)
            throw new StringIndexOutOfBoundsException();
        int l = ArrayUtils.idealCharArraySize(k + 1);
        mText = new char[l];
        mGapStart = k;
        mGapLength = l - k;
        TextUtils.getChars(charsequence, i, j, mText, 0);
        mSpanCount = 0;
        int i1 = ArrayUtils.idealIntArraySize(0);
        mSpans = new Object[i1];
        mSpanStarts = new int[i1];
        mSpanEnds = new int[i1];
        mSpanFlags = new int[i1];
        if(charsequence instanceof Spanned) {
            Spanned spanned = (Spanned)charsequence;
            Object aobj[] = spanned.getSpans(i, j, java/lang/Object);
            int j1 = 0;
            while(j1 < aobj.length)  {
                if(!(aobj[j1] instanceof NoCopySpan)) {
                    int k1 = spanned.getSpanStart(aobj[j1]) - i;
                    int l1 = spanned.getSpanEnd(aobj[j1]) - i;
                    int i2 = spanned.getSpanFlags(aobj[j1]);
                    if(k1 < 0)
                        k1 = 0;
                    if(k1 > j - i)
                        k1 = j - i;
                    if(l1 < 0)
                        l1 = 0;
                    if(l1 > j - i)
                        l1 = j - i;
                    setSpan(false, aobj[j1], k1, l1, i2);
                }
                j1++;
            }
        }
    }

    private void change(int i, int j, CharSequence charsequence, int k, int l) {
        int i1;
        int j1;
        int k1;
        int l1;
        i1 = j - i;
        j1 = l - k;
        k1 = j1 - i1;
        l1 = -1 + mSpanCount;
_L9:
        int k4;
        int l4;
        if(l1 < 0)
            break MISSING_BLOCK_LABEL_340;
        k4 = mSpanStarts[l1];
        if(k4 > mGapStart)
            k4 -= mGapLength;
        l4 = mSpanEnds[l1];
        if(l4 > mGapStart)
            l4 -= mGapLength;
        if((0x33 & mSpanFlags[l1]) != 51) goto _L2; else goto _L1
_L1:
        int j5;
        int k5;
        int l5;
        j5 = k4;
        k5 = l4;
        l5 = length();
        if(k4 <= i || k4 > j) goto _L4; else goto _L3
_L3:
        k4 = j;
_L7:
        if(k4 < l5 && (k4 <= j || charAt(k4 - 1) != '\n')) goto _L5; else goto _L4
_L4:
        int i5;
        if(l4 > i && l4 <= j) {
            int ai[];
            for(l4 = j; l4 < l5 && (l4 <= j || charAt(l4 - 1) != '\n'); l4++)
                break MISSING_BLOCK_LABEL_296;

        }
        if(k4 != j5 || l4 != k5)
            setSpan(false, mSpans[l1], k4, l4, mSpanFlags[l1]);
_L2:
        i5 = 0;
        if(k4 == i)
            i5 = 0 | 0x1000;
        else
        if(k4 == j + k1)
            i5 = 0 | 0x2000;
        if(l4 == i)
            i5 = 0x4000 | i5;
        else
        if(l4 == j + k1)
            i5 |= 0x8000;
        ai = mSpanFlags;
        ai[l1] = i5 | ai[l1];
        l1--;
        continue; /* Loop/switch isn't completed */
_L5:
        k4++;
        if(true) goto _L7; else goto _L6
_L6:
        moveGapTo(j);
        if(k1 >= mGapLength)
            resizeFor((k1 + mText.length) - mGapLength);
        boolean flag;
        if(j1 == 0)
            flag = true;
        else
            flag = false;
        if(i1 > 0) {
            int i4 = 0;
            do {
                int j4 = mSpanCount;
                if(i4 >= j4)
                    break;
                if((0x21 & mSpanFlags[i4]) == 33 && mSpanStarts[i4] >= i && mSpanStarts[i4] < mGapStart + mGapLength && mSpanEnds[i4] >= i && mSpanEnds[i4] < mGapStart + mGapLength && (flag || mSpanStarts[i4] > i || mSpanEnds[i4] < mGapStart))
                    removeSpan(i4);
                else
                    i4++;
            } while(true);
        }
        mGapStart = k1 + mGapStart;
        mGapLength = mGapLength - k1;
        if(mGapLength < 1)
            (new Exception("mGapLength < 1")).printStackTrace();
        TextUtils.getChars(charsequence, k, l, mText, i);
        if(i1 > 0) {
            boolean flag1;
            int i3;
            if(mGapStart + mGapLength == mText.length)
                flag1 = true;
            else
                flag1 = false;
            i3 = 0;
            do {
                int j3 = mSpanCount;
                if(i3 >= j3)
                    break;
                int k3 = (0xf0 & mSpanFlags[i3]) >> 4;
                mSpanStarts[i3] = updatedIntervalBound(mSpanStarts[i3], i, k1, k3, flag1, flag);
                int l3 = 0xf & mSpanFlags[i3];
                mSpanEnds[i3] = updatedIntervalBound(mSpanEnds[i3], i, k1, l3, flag1, flag);
                i3++;
            } while(true);
        }
        mSpanCountBeforeAdd = mSpanCount;
        if(charsequence instanceof Spanned) {
            Spanned spanned = (Spanned)charsequence;
            Object aobj[] = spanned.getSpans(k, l, java/lang/Object);
            int i2 = 0;
            do {
                int j2 = aobj.length;
                if(i2 >= j2)
                    break;
                int k2 = spanned.getSpanStart(aobj[i2]);
                int l2 = spanned.getSpanEnd(aobj[i2]);
                if(k2 < k)
                    k2 = k;
                if(l2 > l)
                    l2 = l;
                if(getSpanStart(aobj[i2]) < 0)
                    setSpan(false, aobj[i2], i + (k2 - k), i + (l2 - k), spanned.getSpanFlags(aobj[i2]));
                i2++;
            } while(true);
        }
        return;
        if(true) goto _L9; else goto _L8
_L8:
    }

    private void checkRange(String s, int i, int j) {
        if(j < i)
            throw new IndexOutOfBoundsException((new StringBuilder()).append(s).append(" ").append(region(i, j)).append(" has end before start").toString());
        int k = length();
        if(i > k || j > k)
            throw new IndexOutOfBoundsException((new StringBuilder()).append(s).append(" ").append(region(i, j)).append(" ends beyond length ").append(k).toString());
        if(i < 0 || j < 0)
            throw new IndexOutOfBoundsException((new StringBuilder()).append(s).append(" ").append(region(i, j)).append(" starts before 0").toString());
        else
            return;
    }

    private static boolean hasNonExclusiveExclusiveSpanAt(CharSequence charsequence, int i) {
        Spanned spanned;
        Object aobj[];
        int j;
        int k;
        if(!(charsequence instanceof Spanned))
            break MISSING_BLOCK_LABEL_65;
        spanned = (Spanned)charsequence;
        aobj = spanned.getSpans(i, i, java/lang/Object);
        j = aobj.length;
        k = 0;
_L3:
        if(k >= j)
            break MISSING_BLOCK_LABEL_65;
        if(spanned.getSpanFlags(aobj[k]) == 33) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        k++;
          goto _L3
        flag = false;
          goto _L4
    }

    private void moveGapTo(int i) {
        if(i != mGapStart) goto _L2; else goto _L1
_L1:
        return;
_L2:
        boolean flag;
        int k;
        if(i == length())
            flag = true;
        else
            flag = false;
        if(i < mGapStart) {
            int l1 = mGapStart - i;
            System.arraycopy(mText, i, mText, (mGapStart + mGapLength) - l1, l1);
        } else {
            int j = i - mGapStart;
            System.arraycopy(mText, (i + mGapLength) - j, mText, mGapStart, j);
        }
        k = 0;
        while(k < mSpanCount)  {
            int l = mSpanStarts[k];
            int i1 = mSpanEnds[k];
            if(l > mGapStart)
                l -= mGapLength;
            if(l > i)
                l += mGapLength;
            else
            if(l == i) {
                int j1 = (0xf0 & mSpanFlags[k]) >> 4;
                if(j1 == 2 || flag && j1 == 3)
                    l += mGapLength;
            }
            if(i1 > mGapStart)
                i1 -= mGapLength;
            if(i1 > i)
                i1 += mGapLength;
            else
            if(i1 == i) {
                int k1 = 0xf & mSpanFlags[k];
                if(k1 == 2 || flag && k1 == 3)
                    i1 += mGapLength;
            }
            mSpanStarts[k] = l;
            mSpanEnds[k] = i1;
            k++;
        }
        mGapStart = i;
        if(true) goto _L1; else goto _L3
_L3:
    }

    private static String region(int i, int j) {
        return (new StringBuilder()).append("(").append(i).append(" ... ").append(j).append(")").toString();
    }

    private void removeSpan(int i) {
        Object obj = mSpans[i];
        int j = mSpanStarts[i];
        int k = mSpanEnds[i];
        if(j > mGapStart)
            j -= mGapLength;
        if(k > mGapStart)
            k -= mGapLength;
        int l = mSpanCount - (i + 1);
        System.arraycopy(((Object) (mSpans)), i + 1, ((Object) (mSpans)), i, l);
        System.arraycopy(mSpanStarts, i + 1, mSpanStarts, i, l);
        System.arraycopy(mSpanEnds, i + 1, mSpanEnds, i, l);
        System.arraycopy(mSpanFlags, i + 1, mSpanFlags, i, l);
        mSpanCount = -1 + mSpanCount;
        mSpans[mSpanCount] = null;
        sendSpanRemoved(obj, j, k);
    }

    private void resizeFor(int i) {
        int j = mText.length;
        int k = ArrayUtils.idealCharArraySize(i + 1);
        int l = k - j;
        if(l != 0) {
            char ac[] = new char[k];
            System.arraycopy(mText, 0, ac, 0, mGapStart);
            int i1 = j - (mGapStart + mGapLength);
            System.arraycopy(mText, j - i1, ac, k - i1, i1);
            mText = ac;
            mGapLength = l + mGapLength;
            if(mGapLength < 1)
                (new Exception("mGapLength < 1")).printStackTrace();
            int j1 = 0;
            while(j1 < mSpanCount)  {
                if(mSpanStarts[j1] > mGapStart) {
                    int ai1[] = mSpanStarts;
                    ai1[j1] = l + ai1[j1];
                }
                if(mSpanEnds[j1] > mGapStart) {
                    int ai[] = mSpanEnds;
                    ai[j1] = l + ai[j1];
                }
                j1++;
            }
        }
    }

    private void sendAfterTextChanged(TextWatcher atextwatcher[]) {
        int i = atextwatcher.length;
        for(int j = 0; j < i; j++)
            atextwatcher[j].afterTextChanged(this);

    }

    private void sendBeforeTextChanged(TextWatcher atextwatcher[], int i, int j, int k) {
        int l = atextwatcher.length;
        for(int i1 = 0; i1 < l; i1++)
            atextwatcher[i1].beforeTextChanged(this, i, j, k);

    }

    private void sendSpanAdded(Object obj, int i, int j) {
        SpanWatcher aspanwatcher[] = (SpanWatcher[])getSpans(i, j, android/text/SpanWatcher);
        int k = aspanwatcher.length;
        for(int l = 0; l < k; l++)
            aspanwatcher[l].onSpanAdded(this, obj, i, j);

    }

    private void sendSpanChanged(Object obj, int i, int j, int k, int l) {
        SpanWatcher aspanwatcher[] = (SpanWatcher[])getSpans(Math.min(i, k), Math.min(Math.max(j, l), length()), android/text/SpanWatcher);
        int i1 = aspanwatcher.length;
        for(int j1 = 0; j1 < i1; j1++)
            aspanwatcher[j1].onSpanChanged(this, obj, i, j, k, l);

    }

    private void sendSpanRemoved(Object obj, int i, int j) {
        SpanWatcher aspanwatcher[] = (SpanWatcher[])getSpans(i, j, android/text/SpanWatcher);
        int k = aspanwatcher.length;
        for(int l = 0; l < k; l++)
            aspanwatcher[l].onSpanRemoved(this, obj, i, j);

    }

    private void sendTextChanged(TextWatcher atextwatcher[], int i, int j, int k) {
        int l = atextwatcher.length;
        for(int i1 = 0; i1 < l; i1++)
            atextwatcher[i1].onTextChanged(this, i, j, k);

    }

    private void sendToSpanWatchers(int i, int j, int k) {
        int l = 0;
        do {
            if(l < mSpanCountBeforeAdd) {
                int l1 = mSpanStarts[l];
                int i2 = mSpanEnds[l];
                if(l1 > mGapStart)
                    l1 -= mGapLength;
                if(i2 > mGapStart)
                    i2 -= mGapLength;
                int j2 = mSpanFlags[l];
                int k2 = j + k;
                boolean flag = false;
                int l2 = l1;
                int i3;
                int ai[];
                if(l1 > k2) {
                    if(k != 0) {
                        l2 -= k;
                        flag = true;
                    }
                } else
                if(l1 >= i && (l1 != i || (j2 & 0x1000) != 4096) && (l1 != k2 || (j2 & 0x2000) != 8192))
                    flag = true;
                i3 = i2;
                if(i2 > k2) {
                    if(k != 0) {
                        i3 -= k;
                        flag = true;
                    }
                } else
                if(i2 >= i && (i2 != i || (j2 & 0x4000) != 16384) && (i2 != k2 || (j2 & 0x8000) != 32768))
                    flag = true;
                if(flag)
                    sendSpanChanged(mSpans[l], l2, i3, l1, i2);
                ai = mSpanFlags;
                ai[l] = 0xffff0fff & ai[l];
                l++;
                continue;
            }
            for(int i1 = mSpanCountBeforeAdd; i1 < mSpanCount; i1++) {
                int j1 = mSpanStarts[i1];
                int k1 = mSpanEnds[i1];
                if(j1 > mGapStart)
                    j1 -= mGapLength;
                if(k1 > mGapStart)
                    k1 -= mGapLength;
                sendSpanAdded(mSpans[i1], j1, k1);
            }

            return;
        } while(true);
    }

    private void setSpan(boolean flag, Object obj, int i, int j, int k) {
        int l;
        int i1;
        checkRange("setSpan", i, j);
        l = (k & 0xf0) >> 4;
        if(l == 3 && i != 0) {
            int l4 = length();
            if(i != l4 && charAt(i - 1) != '\n')
                throw new RuntimeException("PARAGRAPH span must start at paragraph boundary");
        }
        i1 = k & 0xf;
        if(i1 == 3 && j != 0) {
            int k4 = length();
            if(j != k4 && charAt(j - 1) != '\n')
                throw new RuntimeException("PARAGRAPH span must end at paragraph boundary");
        }
        if(l != 2 || i1 != 1 || i != j) goto _L2; else goto _L1
_L1:
        if(flag)
            Log.e("SpannableStringBuilder", "SPAN_EXCLUSIVE_EXCLUSIVE spans cannot have a zero length");
_L19:
        return;
_L2:
        int j1;
        int k1;
        int l1;
        j1 = i;
        k1 = j;
        l1 = mGapStart;
        if(i <= l1) goto _L4; else goto _L3
_L3:
        i += mGapLength;
_L8:
        int j2 = mGapStart;
        if(j <= j2) goto _L6; else goto _L5
_L5:
        j += mGapLength;
_L13:
        int l2;
        Object aobj[];
        int i3;
        l2 = mSpanCount;
        aobj = mSpans;
        i3 = 0;
_L17:
        if(i3 >= l2)
            break MISSING_BLOCK_LABEL_434;
        if(aobj[i3] == obj) {
            int k3 = mSpanStarts[i3];
            int l3 = mSpanEnds[i3];
            if(k3 > mGapStart)
                k3 -= mGapLength;
            if(l3 > mGapStart)
                l3 -= mGapLength;
            mSpanStarts[i3] = i;
            mSpanEnds[i3] = j;
            mSpanFlags[i3] = k;
            if(flag)
                sendSpanChanged(obj, k3, l3, j1, k1);
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_428;
_L4:
        int i2 = mGapStart;
        if(i != i2) goto _L8; else goto _L7
_L7:
        if(l == 2) goto _L10; else goto _L9
_L9:
        if(l != 3) goto _L8; else goto _L11
_L11:
        int j4 = length();
        if(i != j4) goto _L8; else goto _L10
_L10:
        i += mGapLength;
          goto _L8
_L6:
        int k2 = mGapStart;
        if(j != k2) goto _L13; else goto _L12
_L12:
        if(i1 == 2) goto _L15; else goto _L14
_L14:
        if(i1 != 3) goto _L13; else goto _L16
_L16:
        int i4 = length();
        if(j != i4) goto _L13; else goto _L15
_L15:
        j += mGapLength;
          goto _L13
        i3++;
          goto _L17
        if(1 + mSpanCount >= mSpans.length) {
            int j3 = ArrayUtils.idealIntArraySize(1 + mSpanCount);
            Object aobj1[] = new Object[j3];
            int ai[] = new int[j3];
            int ai1[] = new int[j3];
            int ai2[] = new int[j3];
            System.arraycopy(((Object) (mSpans)), 0, ((Object) (aobj1)), 0, mSpanCount);
            System.arraycopy(mSpanStarts, 0, ai, 0, mSpanCount);
            System.arraycopy(mSpanEnds, 0, ai1, 0, mSpanCount);
            System.arraycopy(mSpanFlags, 0, ai2, 0, mSpanCount);
            mSpans = aobj1;
            mSpanStarts = ai;
            mSpanEnds = ai1;
            mSpanFlags = ai2;
        }
        mSpans[mSpanCount] = obj;
        mSpanStarts[mSpanCount] = i;
        mSpanEnds[mSpanCount] = j;
        mSpanFlags[mSpanCount] = k;
        mSpanCount = 1 + mSpanCount;
        if(flag)
            sendSpanAdded(obj, j1, k1);
        if(true) goto _L19; else goto _L18
_L18:
    }

    private int updatedIntervalBound(int i, int j, int k, int l, boolean flag, boolean flag1) {
        if(i < j || i >= mGapStart + mGapLength) goto _L2; else goto _L1
_L1:
        if(l != 2) goto _L4; else goto _L3
_L3:
        if(!flag1 && i <= j) goto _L2; else goto _L5
_L5:
        j = mGapStart + mGapLength;
_L7:
        return j;
_L4:
        if(l == 3) {
            if(flag) {
                j = mGapStart + mGapLength;
                continue; /* Loop/switch isn't completed */
            }
        } else {
            if(!flag1 && i >= mGapStart - k)
                j = mGapStart;
            continue; /* Loop/switch isn't completed */
        }
_L2:
        j = i;
        if(true) goto _L7; else goto _L6
_L6:
    }

    public static SpannableStringBuilder valueOf(CharSequence charsequence) {
        SpannableStringBuilder spannablestringbuilder;
        if(charsequence instanceof SpannableStringBuilder)
            spannablestringbuilder = (SpannableStringBuilder)charsequence;
        else
            spannablestringbuilder = new SpannableStringBuilder(charsequence);
        return spannablestringbuilder;
    }

    public volatile Editable append(char c) {
        return append(c);
    }

    public volatile Editable append(CharSequence charsequence) {
        return append(charsequence);
    }

    public volatile Editable append(CharSequence charsequence, int i, int j) {
        return append(charsequence, i, j);
    }

    public SpannableStringBuilder append(char c) {
        return append(((CharSequence) (String.valueOf(c))));
    }

    public SpannableStringBuilder append(CharSequence charsequence) {
        int i = length();
        return replace(i, i, charsequence, 0, charsequence.length());
    }

    public SpannableStringBuilder append(CharSequence charsequence, int i, int j) {
        int k = length();
        return replace(k, k, charsequence, i, j);
    }

    public volatile Appendable append(char c) throws IOException {
        return append(c);
    }

    public volatile Appendable append(CharSequence charsequence) throws IOException {
        return append(charsequence);
    }

    public volatile Appendable append(CharSequence charsequence, int i, int j) throws IOException {
        return append(charsequence, i, j);
    }

    public char charAt(int i) {
        int j = length();
        if(i < 0)
            throw new IndexOutOfBoundsException((new StringBuilder()).append("charAt: ").append(i).append(" < 0").toString());
        if(i >= j)
            throw new IndexOutOfBoundsException((new StringBuilder()).append("charAt: ").append(i).append(" >= length ").append(j).toString());
        char c;
        if(i >= mGapStart)
            c = mText[i + mGapLength];
        else
            c = mText[i];
        return c;
    }

    public void clear() {
        replace(0, length(), "", 0, 0);
    }

    public void clearSpans() {
        for(int i = -1 + mSpanCount; i >= 0; i--) {
            Object obj = mSpans[i];
            int j = mSpanStarts[i];
            int k = mSpanEnds[i];
            if(j > mGapStart)
                j -= mGapLength;
            if(k > mGapStart)
                k -= mGapLength;
            mSpanCount = i;
            mSpans[i] = null;
            sendSpanRemoved(obj, j, k);
        }

    }

    public volatile Editable delete(int i, int j) {
        return delete(i, j);
    }

    public SpannableStringBuilder delete(int i, int j) {
        SpannableStringBuilder spannablestringbuilder = replace(i, j, "", 0, 0);
        if(mGapLength > 2 * length())
            resizeFor(length());
        return spannablestringbuilder;
    }

    public void drawText(Canvas canvas, int i, int j, float f, float f1, Paint paint) {
        checkRange("drawText", i, j);
        if(j <= mGapStart)
            canvas.drawText(mText, i, j - i, f, f1, paint);
        else
        if(i >= mGapStart) {
            canvas.drawText(mText, i + mGapLength, j - i, f, f1, paint);
        } else {
            char ac[] = TextUtils.obtain(j - i);
            getChars(i, j, ac, 0);
            canvas.drawText(ac, 0, j - i, f, f1, paint);
            TextUtils.recycle(ac);
        }
    }

    public void drawTextRun(Canvas canvas, int i, int j, int k, int l, float f, float f1, 
            int i1, Paint paint) {
        checkRange("drawTextRun", i, j);
        int j1 = l - k;
        int k1 = j - i;
        if(l <= mGapStart)
            canvas.drawTextRun(mText, i, k1, k, j1, f, f1, i1, paint);
        else
        if(k >= mGapStart) {
            canvas.drawTextRun(mText, i + mGapLength, k1, k + mGapLength, j1, f, f1, i1, paint);
        } else {
            char ac[] = TextUtils.obtain(j1);
            getChars(k, l, ac, 0);
            canvas.drawTextRun(ac, i - k, k1, 0, j1, f, f1, i1, paint);
            TextUtils.recycle(ac);
        }
    }

    public void getChars(int i, int j, char ac[], int k) {
        checkRange("getChars", i, j);
        if(j <= mGapStart)
            System.arraycopy(mText, i, ac, k, j - i);
        else
        if(i >= mGapStart) {
            System.arraycopy(mText, i + mGapLength, ac, k, j - i);
        } else {
            System.arraycopy(mText, i, ac, k, mGapStart - i);
            System.arraycopy(mText, mGapStart + mGapLength, ac, k + (mGapStart - i), j - mGapStart);
        }
    }

    public InputFilter[] getFilters() {
        return mFilters;
    }

    public int getSpanEnd(Object obj) {
        Object aobj[];
        int j;
        int i = mSpanCount;
        aobj = mSpans;
        j = i - 1;
_L3:
        if(j < 0)
            break MISSING_BLOCK_LABEL_64;
        if(aobj[j] != obj) goto _L2; else goto _L1
_L1:
        int k;
        k = mSpanEnds[j];
        if(k > mGapStart)
            k -= mGapLength;
_L4:
        return k;
_L2:
        j--;
          goto _L3
        k = -1;
          goto _L4
    }

    public int getSpanFlags(Object obj) {
        Object aobj[];
        int j;
        int i = mSpanCount;
        aobj = mSpans;
        j = i - 1;
_L3:
        if(j < 0)
            break MISSING_BLOCK_LABEL_46;
        if(aobj[j] != obj) goto _L2; else goto _L1
_L1:
        int k = mSpanFlags[j];
_L4:
        return k;
_L2:
        j--;
          goto _L3
        k = 0;
          goto _L4
    }

    public int getSpanStart(Object obj) {
        Object aobj[];
        int j;
        int i = mSpanCount;
        aobj = mSpans;
        j = i - 1;
_L3:
        if(j < 0)
            break MISSING_BLOCK_LABEL_64;
        if(aobj[j] != obj) goto _L2; else goto _L1
_L1:
        int k;
        k = mSpanStarts[j];
        if(k > mGapStart)
            k -= mGapLength;
_L4:
        return k;
_L2:
        j--;
          goto _L3
        k = -1;
          goto _L4
    }

    public Object[] getSpans(int i, int j, Class class1) {
        if(class1 != null) goto _L2; else goto _L1
_L1:
        Object aobj1[] = ArrayUtils.emptyArray(class1);
_L7:
        return aobj1;
_L2:
        int k;
        Object aobj[];
        int ai[];
        int ai1[];
        int ai2[];
        int l;
        int i1;
        Object obj;
        int j1;
        int k1;
        k = mSpanCount;
        aobj = mSpans;
        ai = mSpanStarts;
        ai1 = mSpanEnds;
        ai2 = mSpanFlags;
        l = mGapStart;
        i1 = mGapLength;
        aobj1 = null;
        obj = null;
        j1 = 0;
        k1 = 0;
_L4:
        int l1;
        int k2;
        if(j1 >= k)
            break MISSING_BLOCK_LABEL_364;
        l1 = ai[j1];
        if(l1 > l)
            l1 -= i1;
        if(l1 <= j)
            break; /* Loop/switch isn't completed */
        k2 = k1;
_L5:
        j1++;
        k1 = k2;
        if(true) goto _L4; else goto _L3
_L3:
        int i2 = ai1[j1];
        if(i2 > l)
            i2 -= i1;
        if(i2 < i) {
            k2 = k1;
        } else {
label0:
            {
                if(l1 == i2 || i == j)
                    break label0;
                if(l1 == j) {
                    k2 = k1;
                } else {
                    if(i2 != i)
                        break label0;
                    k2 = k1;
                }
            }
        }
          goto _L5
        if(!class1.isInstance(aobj[j1]))
            k2 = k1;
        else
        if(k1 == 0) {
            obj = aobj[j1];
            k2 = k1 + 1;
        } else {
label1:
            {
                if(k1 == 1) {
                    aobj1 = (Object[])(Object[])Array.newInstance(class1, 1 + (k - j1));
                    aobj1[0] = obj;
                }
                int j2 = 0xff0000 & ai2[j1];
                if(j2 == 0)
                    break MISSING_BLOCK_LABEL_345;
                for(int l2 = 0; l2 < k1 && j2 <= (0xff0000 & getSpanFlags(aobj1[l2])); l2++)
                    break label1;

                System.arraycopy(((Object) (aobj1)), l2, ((Object) (aobj1)), l2 + 1, k1 - l2);
                aobj1[l2] = aobj[j1];
                k2 = k1 + 1;
            }
        }
          goto _L5
        k2 = k1 + 1;
        aobj1[k1] = aobj[j1];
          goto _L5
        if(k1 == 0)
            aobj1 = ArrayUtils.emptyArray(class1);
        else
        if(k1 == 1) {
            aobj1 = (Object[])(Object[])Array.newInstance(class1, 1);
            aobj1[0] = obj;
        } else
        if(k1 != aobj1.length) {
            Object aobj2[] = (Object[])(Object[])Array.newInstance(class1, k1);
            System.arraycopy(((Object) (aobj1)), 0, ((Object) (aobj2)), 0, k1);
            aobj1 = aobj2;
        }
        if(true) goto _L7; else goto _L6
_L6:
    }

    public float getTextRunAdvances(int i, int j, int k, int l, int i1, float af[], int j1, 
            Paint paint) {
        int k1 = l - k;
        int l1 = j - i;
        float f;
        if(j <= mGapStart)
            f = paint.getTextRunAdvances(mText, i, l1, k, k1, i1, af, j1);
        else
        if(i >= mGapStart) {
            f = paint.getTextRunAdvances(mText, i + mGapLength, l1, k + mGapLength, k1, i1, af, j1);
        } else {
            char ac[] = TextUtils.obtain(k1);
            getChars(k, l, ac, 0);
            f = paint.getTextRunAdvances(ac, i - k, l1, 0, k1, i1, af, j1);
            TextUtils.recycle(ac);
        }
        return f;
    }

    public float getTextRunAdvances(int i, int j, int k, int l, int i1, float af[], int j1, 
            Paint paint, int k1) {
        int l1 = l - k;
        int i2 = j - i;
        float f;
        if(j <= mGapStart)
            f = paint.getTextRunAdvances(mText, i, i2, k, l1, i1, af, j1, k1);
        else
        if(i >= mGapStart) {
            f = paint.getTextRunAdvances(mText, i + mGapLength, i2, k + mGapLength, l1, i1, af, j1, k1);
        } else {
            char ac[] = TextUtils.obtain(l1);
            getChars(k, l, ac, 0);
            f = paint.getTextRunAdvances(ac, i - k, i2, 0, l1, i1, af, j1, k1);
            TextUtils.recycle(ac);
        }
        return f;
    }

    public int getTextRunCursor(int i, int j, int k, int l, int i1, Paint paint) {
        int j1 = j - i;
        int k1;
        if(j <= mGapStart)
            k1 = paint.getTextRunCursor(mText, i, j1, k, l, i1);
        else
        if(i >= mGapStart) {
            k1 = paint.getTextRunCursor(mText, i + mGapLength, j1, k, l + mGapLength, i1) - mGapLength;
        } else {
            char ac[] = TextUtils.obtain(j1);
            getChars(i, j, ac, 0);
            k1 = i + paint.getTextRunCursor(ac, 0, j1, k, l - i, i1);
            TextUtils.recycle(ac);
        }
        return k1;
    }

    public int getTextWidths(int i, int j, float af[], Paint paint) {
        checkRange("getTextWidths", i, j);
        int k;
        if(j <= mGapStart)
            k = paint.getTextWidths(mText, i, j - i, af);
        else
        if(i >= mGapStart) {
            k = paint.getTextWidths(mText, i + mGapLength, j - i, af);
        } else {
            char ac[] = TextUtils.obtain(j - i);
            getChars(i, j, ac, 0);
            k = paint.getTextWidths(ac, 0, j - i, af);
            TextUtils.recycle(ac);
        }
        return k;
    }

    public volatile Editable insert(int i, CharSequence charsequence) {
        return insert(i, charsequence);
    }

    public volatile Editable insert(int i, CharSequence charsequence, int j, int k) {
        return insert(i, charsequence, j, k);
    }

    public SpannableStringBuilder insert(int i, CharSequence charsequence) {
        return replace(i, i, charsequence, 0, charsequence.length());
    }

    public SpannableStringBuilder insert(int i, CharSequence charsequence, int j, int k) {
        return replace(i, i, charsequence, j, k);
    }

    public int length() {
        return mText.length - mGapLength;
    }

    public float measureText(int i, int j, Paint paint) {
        checkRange("measureText", i, j);
        float f;
        if(j <= mGapStart)
            f = paint.measureText(mText, i, j - i);
        else
        if(i >= mGapStart) {
            f = paint.measureText(mText, i + mGapLength, j - i);
        } else {
            char ac[] = TextUtils.obtain(j - i);
            getChars(i, j, ac, 0);
            f = paint.measureText(ac, 0, j - i);
            TextUtils.recycle(ac);
        }
        return f;
    }

    public int nextSpanTransition(int i, int j, Class class1) {
        int k = mSpanCount;
        Object aobj[] = mSpans;
        int ai[] = mSpanStarts;
        int ai1[] = mSpanEnds;
        int l = mGapStart;
        int i1 = mGapLength;
        if(class1 == null)
            class1 = java/lang/Object;
        for(int j1 = 0; j1 < k; j1++) {
            int k1 = ai[j1];
            int l1 = ai1[j1];
            if(k1 > l)
                k1 -= i1;
            if(l1 > l)
                l1 -= i1;
            if(k1 > i && k1 < j && class1.isInstance(aobj[j1]))
                j = k1;
            if(l1 > i && l1 < j && class1.isInstance(aobj[j1]))
                j = l1;
        }

        return j;
    }

    public void removeSpan(Object obj) {
        int i = -1 + mSpanCount;
        do {
label0:
            {
                if(i >= 0) {
                    if(mSpans[i] != obj)
                        break label0;
                    removeSpan(i);
                }
                return;
            }
            i--;
        } while(true);
    }

    public volatile Editable replace(int i, int j, CharSequence charsequence) {
        return replace(i, j, charsequence);
    }

    public volatile Editable replace(int i, int j, CharSequence charsequence, int k, int l) {
        return replace(i, j, charsequence, k, l);
    }

    public SpannableStringBuilder replace(int i, int j, CharSequence charsequence) {
        return replace(i, j, charsequence, 0, charsequence.length());
    }

    public SpannableStringBuilder replace(int i, int j, CharSequence charsequence, int k, int l) {
        checkRange("replace", i, j);
        int i1 = mFilters.length;
        for(int j1 = 0; j1 < i1; j1++) {
            CharSequence charsequence1 = mFilters[j1].filter(charsequence, k, l, this, i, j);
            if(charsequence1 != null) {
                charsequence = charsequence1;
                k = 0;
                l = charsequence1.length();
            }
        }

        int k1 = j - i;
        int l1 = l - k;
        if(k1 != 0 || l1 != 0 || hasNonExclusiveExclusiveSpanAt(charsequence, k)) {
            TextWatcher atextwatcher[] = (TextWatcher[])getSpans(i, i + k1, android/text/TextWatcher);
            sendBeforeTextChanged(atextwatcher, i, k1, l1);
            boolean flag;
            int i2;
            int j2;
            if(k1 != 0 && l1 != 0)
                flag = true;
            else
                flag = false;
            i2 = 0;
            j2 = 0;
            if(flag) {
                i2 = Selection.getSelectionStart(this);
                j2 = Selection.getSelectionEnd(this);
            }
            change(i, j, charsequence, k, l);
            if(flag) {
                if(i2 > i && i2 < j) {
                    int l2 = i + (l1 * (i2 - i)) / k1;
                    setSpan(false, Selection.SELECTION_START, l2, l2, 34);
                }
                if(j2 > i && j2 < j) {
                    int k2 = i + (l1 * (j2 - i)) / k1;
                    setSpan(false, Selection.SELECTION_END, k2, k2, 34);
                }
            }
            sendTextChanged(atextwatcher, i, k1, l1);
            sendAfterTextChanged(atextwatcher);
            sendToSpanWatchers(i, j, l1 - k1);
        }
        return this;
    }

    public void setFilters(InputFilter ainputfilter[]) {
        if(ainputfilter == null) {
            throw new IllegalArgumentException();
        } else {
            mFilters = ainputfilter;
            return;
        }
    }

    public void setSpan(Object obj, int i, int j, int k) {
        setSpan(true, obj, i, j, k);
    }

    public CharSequence subSequence(int i, int j) {
        return new SpannableStringBuilder(this, i, j);
    }

    public String substring(int i, int j) {
        char ac[] = new char[j - i];
        getChars(i, j, ac, 0);
        return new String(ac);
    }

    public String toString() {
        int i = length();
        char ac[] = new char[i];
        getChars(0, i, ac, 0);
        return new String(ac);
    }

    private static final int END_MASK = 15;
    private static final int MARK = 1;
    private static final InputFilter NO_FILTERS[] = new InputFilter[0];
    private static final int PARAGRAPH = 3;
    private static final int POINT = 2;
    private static final int SPAN_END_AT_END = 32768;
    private static final int SPAN_END_AT_START = 16384;
    private static final int SPAN_START_AT_END = 8192;
    private static final int SPAN_START_AT_START = 4096;
    private static final int SPAN_START_END_MASK = 61440;
    private static final int START_MASK = 240;
    private static final int START_SHIFT = 4;
    private InputFilter mFilters[];
    private int mGapLength;
    private int mGapStart;
    private int mSpanCount;
    private int mSpanCountBeforeAdd;
    private int mSpanEnds[];
    private int mSpanFlags[];
    private int mSpanStarts[];
    private Object mSpans[];
    private char mText[];

}
