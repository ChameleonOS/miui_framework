// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text;


// Referenced classes of package android.text:
//            GetChars, Spanned, TextUtils

public class AlteredCharSequence
    implements CharSequence, GetChars {
    private static class AlteredSpanned extends AlteredCharSequence
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

        private Spanned mSpanned;

        private AlteredSpanned(CharSequence charsequence, char ac[], int i, int j) {
            super(charsequence, ac, i, j, null);
            mSpanned = (Spanned)charsequence;
        }

    }


    private AlteredCharSequence(CharSequence charsequence, char ac[], int i, int j) {
        mSource = charsequence;
        mChars = ac;
        mStart = i;
        mEnd = j;
    }


    public static AlteredCharSequence make(CharSequence charsequence, char ac[], int i, int j) {
        Object obj;
        if(charsequence instanceof Spanned)
            obj = new AlteredSpanned(charsequence, ac, i, j);
        else
            obj = new AlteredCharSequence(charsequence, ac, i, j);
        return ((AlteredCharSequence) (obj));
    }

    public char charAt(int i) {
        char c;
        if(i >= mStart && i < mEnd)
            c = mChars[i - mStart];
        else
            c = mSource.charAt(i);
        return c;
    }

    public void getChars(int i, int j, char ac[], int k) {
        TextUtils.getChars(mSource, i, j, ac, k);
        int l = Math.max(mStart, i);
        int i1 = Math.min(mEnd, j);
        if(l > i1)
            System.arraycopy(mChars, l - mStart, ac, k, i1 - l);
    }

    public int length() {
        return mSource.length();
    }

    public CharSequence subSequence(int i, int j) {
        return make(mSource.subSequence(i, j), mChars, mStart - i, mEnd - i);
    }

    public String toString() {
        int i = length();
        char ac[] = new char[i];
        getChars(0, i, ac, 0);
        return String.valueOf(ac);
    }

    void update(char ac[], int i, int j) {
        mChars = ac;
        mStart = i;
        mEnd = j;
    }

    private char mChars[];
    private int mEnd;
    private CharSequence mSource;
    private int mStart;
}
