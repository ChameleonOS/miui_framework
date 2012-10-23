// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.util;


public class Rfc822Token {

    public Rfc822Token(String s, String s1, String s2) {
        mName = s;
        mAddress = s1;
        mComment = s2;
    }

    public static String quoteComment(String s) {
        int i = s.length();
        StringBuilder stringbuilder = new StringBuilder();
        for(int j = 0; j < i; j++) {
            char c = s.charAt(j);
            if(c == '(' || c == ')' || c == '\\')
                stringbuilder.append('\\');
            stringbuilder.append(c);
        }

        return stringbuilder.toString();
    }

    public static String quoteName(String s) {
        StringBuilder stringbuilder = new StringBuilder();
        int i = s.length();
        for(int j = 0; j < i; j++) {
            char c = s.charAt(j);
            if(c == '\\' || c == '"')
                stringbuilder.append('\\');
            stringbuilder.append(c);
        }

        return stringbuilder.toString();
    }

    public static String quoteNameIfNecessary(String s) {
        int i = s.length();
        int j = 0;
        do {
label0:
            {
                if(j < i) {
                    char c = s.charAt(j);
                    if(c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' || c == ' ' || c >= '0' && c <= '9')
                        break label0;
                    s = (new StringBuilder()).append('"').append(quoteName(s)).append('"').toString();
                }
                return s;
            }
            j++;
        } while(true);
    }

    private static boolean stringEquals(String s, String s1) {
        boolean flag;
        if(s == null) {
            if(s1 == null)
                flag = true;
            else
                flag = false;
        } else {
            flag = s.equals(s1);
        }
        return flag;
    }

    public boolean equals(Object obj) {
        boolean flag = false;
        if(obj instanceof Rfc822Token) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        Rfc822Token rfc822token = (Rfc822Token)obj;
        if(stringEquals(mName, rfc822token.mName) && stringEquals(mAddress, rfc822token.mAddress) && stringEquals(mComment, rfc822token.mComment))
            flag = true;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public String getAddress() {
        return mAddress;
    }

    public String getComment() {
        return mComment;
    }

    public String getName() {
        return mName;
    }

    public int hashCode() {
        int i = 17;
        if(mName != null)
            i = 527 + mName.hashCode();
        if(mAddress != null)
            i = i * 31 + mAddress.hashCode();
        if(mComment != null)
            i = i * 31 + mComment.hashCode();
        return i;
    }

    public void setAddress(String s) {
        mAddress = s;
    }

    public void setComment(String s) {
        mComment = s;
    }

    public void setName(String s) {
        mName = s;
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        if(mName != null && mName.length() != 0) {
            stringbuilder.append(quoteNameIfNecessary(mName));
            stringbuilder.append(' ');
        }
        if(mComment != null && mComment.length() != 0) {
            stringbuilder.append('(');
            stringbuilder.append(quoteComment(mComment));
            stringbuilder.append(") ");
        }
        if(mAddress != null && mAddress.length() != 0) {
            stringbuilder.append('<');
            stringbuilder.append(mAddress);
            stringbuilder.append('>');
        }
        return stringbuilder.toString();
    }

    private String mAddress;
    private String mComment;
    private String mName;
}
