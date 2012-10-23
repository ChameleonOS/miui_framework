// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text;


// Referenced classes of package android.text:
//            InputFilter, Spanned, SpannableStringBuilder

public abstract class LoginFilter
    implements InputFilter {
    public static class PasswordFilterGMail extends LoginFilter {

        public boolean isAllowed(char c) {
            boolean flag;
            flag = true;
            break MISSING_BLOCK_LABEL_2;
            if((' ' > c || c > '\177') && ('\240' > c || c > '\377'))
                flag = false;
            return flag;
        }

        public PasswordFilterGMail() {
            super(false);
        }

        public PasswordFilterGMail(boolean flag) {
            super(flag);
        }
    }

    public static class UsernameFilterGeneric extends LoginFilter {

        public boolean isAllowed(char c) {
            boolean flag;
            flag = true;
            break MISSING_BLOCK_LABEL_2;
            if(('0' > c || c > '9') && ('a' > c || c > 'z') && ('A' > c || c > 'Z') && "@_-+.".indexOf(c) == -1)
                flag = false;
            return flag;
        }

        private static final String mAllowed = "@_-+.";

        public UsernameFilterGeneric() {
            super(false);
        }

        public UsernameFilterGeneric(boolean flag) {
            super(flag);
        }
    }

    public static class UsernameFilterGMail extends LoginFilter {

        public boolean isAllowed(char c) {
            boolean flag;
            flag = true;
            break MISSING_BLOCK_LABEL_2;
            if(('0' > c || c > '9') && ('a' > c || c > 'z') && ('A' > c || c > 'Z') && '.' != c)
                flag = false;
            return flag;
        }

        public UsernameFilterGMail() {
            super(false);
        }

        public UsernameFilterGMail(boolean flag) {
            super(flag);
        }
    }


    LoginFilter() {
        mAppendInvalid = false;
    }

    LoginFilter(boolean flag) {
        mAppendInvalid = flag;
    }

    public CharSequence filter(CharSequence charsequence, int i, int j, Spanned spanned, int k, int l) {
        onStart();
        for(int i1 = 0; i1 < k; i1++) {
            char c2 = spanned.charAt(i1);
            if(!isAllowed(c2))
                onInvalidCharacter(c2);
        }

        SpannableStringBuilder spannablestringbuilder = null;
        int j1 = 0;
        int k1 = i;
        while(k1 < j)  {
            char c1 = charsequence.charAt(k1);
            if(isAllowed(c1)) {
                j1++;
            } else {
                if(mAppendInvalid) {
                    j1++;
                } else {
                    if(spannablestringbuilder == null) {
                        spannablestringbuilder = new SpannableStringBuilder(charsequence, i, j);
                        j1 = k1 - i;
                    }
                    spannablestringbuilder.delete(j1, j1 + 1);
                }
                onInvalidCharacter(c1);
            }
            k1++;
        }
        for(int l1 = l; l1 < spanned.length(); l1++) {
            char c = spanned.charAt(l1);
            if(!isAllowed(c))
                onInvalidCharacter(c);
        }

        onStop();
        return spannablestringbuilder;
    }

    public abstract boolean isAllowed(char c);

    public void onInvalidCharacter(char c) {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    private boolean mAppendInvalid;
}
