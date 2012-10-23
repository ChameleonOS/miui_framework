// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text;


// Referenced classes of package android.text:
//            Spanned, TextUtils, SpannableString

public interface InputFilter {
    public static class LengthFilter
        implements InputFilter {

        public CharSequence filter(CharSequence charsequence, int i, int j, Spanned spanned, int k, int l) {
            int i1 = mMax - (spanned.length() - (l - k));
            Object obj;
            if(i1 <= 0)
                obj = "";
            else
            if(i1 >= j - i) {
                obj = null;
            } else {
                int j1 = i1 + i;
                if(Character.isHighSurrogate(charsequence.charAt(j1 - 1)) && --j1 == i)
                    obj = "";
                else
                    obj = charsequence.subSequence(i, j1);
            }
            return ((CharSequence) (obj));
        }

        private int mMax;

        public LengthFilter(int i) {
            mMax = i;
        }
    }

    public static class AllCaps
        implements InputFilter {

        public CharSequence filter(CharSequence charsequence, int i, int j, Spanned spanned, int k, int l) {
            int i1 = i;
_L3:
            if(i1 >= j)
                break MISSING_BLOCK_LABEL_100;
            if(!Character.isLowerCase(charsequence.charAt(i1))) goto _L2; else goto _L1
_L1:
            Object obj;
            char ac[] = new char[j - i];
            TextUtils.getChars(charsequence, i, j, ac, 0);
            String s = (new String(ac)).toUpperCase();
            if(charsequence instanceof Spanned) {
                obj = new SpannableString(s);
                TextUtils.copySpansFrom((Spanned)charsequence, i, j, null, ((Spannable) (obj)), 0);
            } else {
                obj = s;
            }
_L4:
            return ((CharSequence) (obj));
_L2:
            i1++;
              goto _L3
            obj = null;
              goto _L4
        }

        public AllCaps() {
        }
    }


    public abstract CharSequence filter(CharSequence charsequence, int i, int j, Spanned spanned, int k, int l);
}
