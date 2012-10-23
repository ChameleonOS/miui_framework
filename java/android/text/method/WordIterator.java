// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.method;

import android.text.SpannableStringBuilder;
import java.text.BreakIterator;
import java.util.Locale;

public class WordIterator
    implements android.text.Selection.PositionIterator {

    public WordIterator() {
        this(Locale.getDefault());
    }

    public WordIterator(Locale locale) {
        mIterator = BreakIterator.getWordInstance(locale);
    }

    private void checkOffsetIsValid(int i) {
        if(i < 0 || i > mString.length())
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid offset: ").append(i + mOffsetShift).append(". Valid range is [").append(mOffsetShift).append(", ").append(mString.length() + mOffsetShift).append("]").toString());
        else
            return;
    }

    private boolean isAfterLetterOrDigit(int i) {
        boolean flag = true;
        if(i < flag || i > mString.length() || !Character.isLetterOrDigit(mString.codePointBefore(i)))
            flag = false;
        return flag;
    }

    private boolean isOnLetterOrDigit(int i) {
        boolean flag;
        if(i >= 0 && i < mString.length() && Character.isLetterOrDigit(mString.codePointAt(i)))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public int following(int i) {
        int j;
        int k;
        j = -1;
        k = i - mOffsetShift;
_L2:
        k = mIterator.following(k);
        if(k != j)
            continue; /* Loop/switch isn't completed */
_L3:
        return j;
        if(!isAfterLetterOrDigit(k)) goto _L2; else goto _L1
_L1:
        j = k + mOffsetShift;
          goto _L3
        if(true) goto _L2; else goto _L4
_L4:
    }

    public int getBeginning(int i) {
        int j = i - mOffsetShift;
        checkOffsetIsValid(j);
        int k;
        if(isOnLetterOrDigit(j)) {
            if(mIterator.isBoundary(j))
                k = j + mOffsetShift;
            else
                k = mIterator.preceding(j) + mOffsetShift;
        } else
        if(isAfterLetterOrDigit(j))
            k = mIterator.preceding(j) + mOffsetShift;
        else
            k = -1;
        return k;
    }

    public int getEnd(int i) {
        int j = i - mOffsetShift;
        checkOffsetIsValid(j);
        int k;
        if(isAfterLetterOrDigit(j)) {
            if(mIterator.isBoundary(j))
                k = j + mOffsetShift;
            else
                k = mIterator.following(j) + mOffsetShift;
        } else
        if(isOnLetterOrDigit(j))
            k = mIterator.following(j) + mOffsetShift;
        else
            k = -1;
        return k;
    }

    public int preceding(int i) {
        int j;
        int k;
        j = -1;
        k = i - mOffsetShift;
_L2:
        k = mIterator.preceding(k);
        if(k != j)
            continue; /* Loop/switch isn't completed */
_L3:
        return j;
        if(!isOnLetterOrDigit(k)) goto _L2; else goto _L1
_L1:
        j = k + mOffsetShift;
          goto _L3
        if(true) goto _L2; else goto _L4
_L4:
    }

    public void setCharSequence(CharSequence charsequence, int i, int j) {
        mOffsetShift = Math.max(0, i - 50);
        int k = Math.min(charsequence.length(), j + 50);
        if(charsequence instanceof SpannableStringBuilder)
            mString = ((SpannableStringBuilder)charsequence).substring(mOffsetShift, k);
        else
            mString = charsequence.subSequence(mOffsetShift, k).toString();
        mIterator.setText(mString);
    }

    private static final int WINDOW_WIDTH = 50;
    private BreakIterator mIterator;
    private int mOffsetShift;
    private String mString;
}
