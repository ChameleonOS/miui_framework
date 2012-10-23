// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;


// Referenced classes of package com.android.internal.telephony:
//            ATParseEx

public class ATResponseParser {

    public ATResponseParser(String s) {
        next = 0;
        line = s;
    }

    private void nextTok() {
        int i;
        char c;
        i = line.length();
        if(next == 0)
            skipPrefix();
        if(next >= i)
            throw new ATParseEx();
        try {
            String s = line;
            int j = next;
            next = j + 1;
            c = skipWhiteSpace(s.charAt(j));
            if(c != '"')
                break MISSING_BLOCK_LABEL_259;
            if(next >= i)
                throw new ATParseEx();
        }
        catch(StringIndexOutOfBoundsException stringindexoutofboundsexception) {
            throw new ATParseEx();
        }
        String s2 = line;
        int l = next;
        next = l + 1;
        char c2 = s2.charAt(l);
        tokStart = -1 + next;
        String s4;
        int j1;
        for(; c2 != '"' && next < i; c2 = s4.charAt(j1)) {
            s4 = line;
            j1 = next;
            next = j1 + 1;
        }

        if(c2 != '"')
            throw new ATParseEx();
        tokEnd = -1 + next;
        if(next < i) {
            String s3 = line;
            int i1 = next;
            next = i1 + 1;
            if(s3.charAt(i1) != ',')
                throw new ATParseEx();
        }
        break MISSING_BLOCK_LABEL_348;
        tokStart = -1 + next;
        tokEnd = tokStart;
_L1:
        char c1;
        if(c == ',')
            break MISSING_BLOCK_LABEL_348;
        if(!Character.isWhitespace(c))
            tokEnd = next;
        if(next == i)
            break MISSING_BLOCK_LABEL_348;
        String s1 = line;
        int k = next;
        next = k + 1;
        c1 = s1.charAt(k);
        c = c1;
          goto _L1
    }

    private void skipPrefix() {
        next = 0;
        for(int i = line.length(); next < i;) {
            String s = line;
            int j = next;
            next = j + 1;
            if(s.charAt(j) == ':')
                return;
        }

        throw new ATParseEx("missing prefix");
    }

    private char skipWhiteSpace(char c) {
        String s;
        int j;
        for(int i = line.length(); next < i && Character.isWhitespace(c); c = s.charAt(j)) {
            s = line;
            j = next;
            next = j + 1;
        }

        if(Character.isWhitespace(c))
            throw new ATParseEx();
        else
            return c;
    }

    public boolean hasMore() {
        boolean flag;
        if(next < line.length())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean nextBoolean() {
        boolean flag = true;
        nextTok();
        if(tokEnd - tokStart > flag)
            throw new ATParseEx();
        char c = line.charAt(tokStart);
        if(c == '0')
            flag = false;
        else
        if(c != '1')
            throw new ATParseEx();
        return flag;
    }

    public int nextInt() {
        int i = 0;
        nextTok();
        for(int j = tokStart; j < tokEnd; j++) {
            char c = line.charAt(j);
            if(c < '0' || c > '9')
                throw new ATParseEx();
            i = i * 10 + (c + -48);
        }

        return i;
    }

    public String nextString() {
        nextTok();
        return line.substring(tokStart, tokEnd);
    }

    private String line;
    private int next;
    private int tokEnd;
    private int tokStart;
}
