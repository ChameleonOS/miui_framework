// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.util;


public class CharSequences {

    public CharSequences() {
    }

    public static int compareToIgnoreCase(CharSequence charsequence, CharSequence charsequence1) {
        int i;
        int j;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        i = charsequence.length();
        j = charsequence1.length();
        int k;
        char c;
        if(i < j)
            k = i;
        else
            k = j;
        l = 0;
        i1 = 0;
_L6:
        if(i1 >= k) goto _L2; else goto _L1
_L1:
        k1 = i1 + 1;
        c = Character.toLowerCase(charsequence.charAt(i1));
        l1 = l + 1;
        j1 = c - Character.toLowerCase(charsequence1.charAt(l));
        if(j1 == 0) goto _L4; else goto _L3
_L3:
        return j1;
_L2:
        j1 = i - j;
        l;
        i1;
        if(true) goto _L3; else goto _L4
_L4:
        l = l1;
        i1 = k1;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public static boolean equals(CharSequence charsequence, CharSequence charsequence1) {
        boolean flag = false;
        if(charsequence.length() == charsequence1.length()) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        int i = charsequence.length();
        for(int j = 0; j < i; j++)
            if(charsequence.charAt(j) != charsequence1.charAt(j))
                continue; /* Loop/switch isn't completed */

        flag = true;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static CharSequence forAsciiBytes(final byte bytes[]) {
        return new CharSequence() {

            public char charAt(int i) {
                return (char)bytes[i];
            }

            public int length() {
                return bytes.length;
            }

            public CharSequence subSequence(int i, int j) {
                return CharSequences.forAsciiBytes(bytes, i, j);
            }

            public String toString() {
                return new String(bytes);
            }

            final byte val$bytes[];

             {
                bytes = abyte0;
                super();
            }
        };
    }

    public static CharSequence forAsciiBytes(final byte bytes[], final int start, final int end) {
        validate(start, end, bytes.length);
        return new CharSequence() {

            public char charAt(int i) {
                return (char)bytes[i + start];
            }

            public int length() {
                return end - start;
            }

            public CharSequence subSequence(int i, int j) {
                int k = i - start;
                int l = j - start;
                CharSequences.validate(k, l, length());
                return CharSequences.forAsciiBytes(bytes, k, l);
            }

            public String toString() {
                return new String(bytes, start, length());
            }

            final byte val$bytes[];
            final int val$end;
            final int val$start;

             {
                bytes = abyte0;
                start = i;
                end = j;
                super();
            }
        };
    }

    static void validate(int i, int j, int k) {
        if(i < 0)
            throw new IndexOutOfBoundsException();
        if(j < 0)
            throw new IndexOutOfBoundsException();
        if(j > k)
            throw new IndexOutOfBoundsException();
        if(i > j)
            throw new IndexOutOfBoundsException();
        else
            return;
    }
}
