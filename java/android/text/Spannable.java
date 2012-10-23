// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text;


// Referenced classes of package android.text:
//            Spanned, SpannableString

public interface Spannable
    extends Spanned {
    public static class Factory {

        public static Factory getInstance() {
            return sInstance;
        }

        public Spannable newSpannable(CharSequence charsequence) {
            return new SpannableString(charsequence);
        }

        private static Factory sInstance = new Factory();


        public Factory() {
        }
    }


    public abstract void removeSpan(Object obj);

    public abstract void setSpan(Object obj, int i, int j, int k);
}
