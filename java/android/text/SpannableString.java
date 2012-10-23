// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text;


// Referenced classes of package android.text:
//            SpannableStringInternal, GetChars, Spannable

public class SpannableString extends SpannableStringInternal
    implements CharSequence, GetChars, Spannable {

    public SpannableString(CharSequence charsequence) {
        super(charsequence, 0, charsequence.length());
    }

    private SpannableString(CharSequence charsequence, int i, int j) {
        super(charsequence, i, j);
    }

    public static SpannableString valueOf(CharSequence charsequence) {
        SpannableString spannablestring;
        if(charsequence instanceof SpannableString)
            spannablestring = (SpannableString)charsequence;
        else
            spannablestring = new SpannableString(charsequence);
        return spannablestring;
    }

    public volatile int getSpanEnd(Object obj) {
        return super.getSpanEnd(obj);
    }

    public volatile int getSpanFlags(Object obj) {
        return super.getSpanFlags(obj);
    }

    public volatile int getSpanStart(Object obj) {
        return super.getSpanStart(obj);
    }

    public volatile Object[] getSpans(int i, int j, Class class1) {
        return super.getSpans(i, j, class1);
    }

    public volatile int nextSpanTransition(int i, int j, Class class1) {
        return super.nextSpanTransition(i, j, class1);
    }

    public void removeSpan(Object obj) {
        super.removeSpan(obj);
    }

    public void setSpan(Object obj, int i, int j, int k) {
        super.setSpan(obj, i, j, k);
    }

    public final CharSequence subSequence(int i, int j) {
        return new SpannableString(this, i, j);
    }
}
