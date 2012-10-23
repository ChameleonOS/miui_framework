// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.method;

import android.graphics.Rect;
import android.text.*;
import android.view.View;

// Referenced classes of package android.text.method:
//            TransformationMethod

public abstract class ReplacementTransformationMethod
    implements TransformationMethod {
    private static class SpannedReplacementCharSequence extends ReplacementCharSequence
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
            return (new SpannedString(this)).subSequence(i, j);
        }

        private Spanned mSpanned;

        public SpannedReplacementCharSequence(Spanned spanned, char ac[], char ac1[]) {
            super(spanned, ac, ac1);
            mSpanned = spanned;
        }
    }

    private static class ReplacementCharSequence
        implements CharSequence, GetChars {

        public char charAt(int i) {
            char c = mSource.charAt(i);
            int j = mOriginal.length;
            for(int k = 0; k < j; k++)
                if(c == mOriginal[k])
                    c = mReplacement[k];

            return c;
        }

        public void getChars(int i, int j, char ac[], int k) {
            TextUtils.getChars(mSource, i, j, ac, k);
            int l = k + (j - i);
            int i1 = mOriginal.length;
            for(int j1 = k; j1 < l; j1++) {
                char c = ac[j1];
                for(int k1 = 0; k1 < i1; k1++)
                    if(c == mOriginal[k1])
                        ac[j1] = mReplacement[k1];

            }

        }

        public int length() {
            return mSource.length();
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

        private char mOriginal[];
        private char mReplacement[];
        private CharSequence mSource;

        public ReplacementCharSequence(CharSequence charsequence, char ac[], char ac1[]) {
            mSource = charsequence;
            mOriginal = ac;
            mReplacement = ac1;
        }
    }


    public ReplacementTransformationMethod() {
    }

    protected abstract char[] getOriginal();

    protected abstract char[] getReplacement();

    public CharSequence getTransformation(CharSequence charsequence, View view) {
        char ac[];
        char ac1[];
        boolean flag;
        int i;
        int j;
        ac = getOriginal();
        ac1 = getReplacement();
        if(charsequence instanceof Editable)
            break MISSING_BLOCK_LABEL_119;
        flag = true;
        i = ac.length;
        j = 0;
_L5:
        if(j >= i) goto _L2; else goto _L1
_L1:
        if(TextUtils.indexOf(charsequence, ac[j]) < 0) goto _L4; else goto _L3
_L3:
        flag = false;
_L2:
        if(!flag) {
            if(charsequence instanceof Spannable)
                break MISSING_BLOCK_LABEL_119;
            if(charsequence instanceof Spanned)
                charsequence = new SpannedString(new SpannedReplacementCharSequence((Spanned)charsequence, ac, ac1));
            else
                charsequence = (new ReplacementCharSequence(charsequence, ac, ac1)).toString();
        }
_L6:
        return charsequence;
_L4:
        j++;
          goto _L5
        if(charsequence instanceof Spanned)
            charsequence = new SpannedReplacementCharSequence((Spanned)charsequence, ac, ac1);
        else
            charsequence = new ReplacementCharSequence(charsequence, ac, ac1);
          goto _L6
    }

    public void onFocusChanged(View view, CharSequence charsequence, boolean flag, int i, Rect rect) {
    }
}
