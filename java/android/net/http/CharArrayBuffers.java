// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.http;

import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;

class CharArrayBuffers {

    CharArrayBuffers() {
    }

    static boolean containsIgnoreCaseTrimmed(CharArrayBuffer chararraybuffer, int i, String s) {
        int j = chararraybuffer.length();
        char ac[];
        for(ac = chararraybuffer.buffer(); i < j && HTTP.isWhitespace(ac[i]); i++);
        int k = s.length();
        boolean flag;
        int l;
        if(j >= i + k)
            flag = true;
        else
            flag = false;
        l = 0;
        while(flag && l < k)  {
            char c = ac[i + l];
            char c1 = s.charAt(l);
            if(c != c1)
                if(toLower(c) == toLower(c1))
                    flag = true;
                else
                    flag = false;
            l++;
        }
        return flag;
    }

    static int setLowercaseIndexOf(CharArrayBuffer chararraybuffer, int i) {
        int j;
        char ac[];
        int k;
        j = chararraybuffer.length();
        ac = chararraybuffer.buffer();
        k = 0;
_L5:
        if(k >= j) goto _L2; else goto _L1
_L1:
        char c = ac[k];
        if(c != i) goto _L4; else goto _L3
_L3:
        return k;
_L4:
        if(c >= 'A' && c <= 'Z')
            ac[k] = (char)(c + 32);
        k++;
          goto _L5
_L2:
        k = -1;
          goto _L3
    }

    private static char toLower(char c) {
        if(c >= 'A' && c <= 'Z')
            c += ' ';
        return c;
    }

    static final char uppercaseAddon = 32;
}
