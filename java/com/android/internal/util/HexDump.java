// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.util;


public class HexDump {

    public HexDump() {
    }

    public static String dumpHexString(byte abyte0[]) {
        return dumpHexString(abyte0, 0, abyte0.length);
    }

    public static String dumpHexString(byte abyte0[], int i, int j) {
        StringBuilder stringbuilder = new StringBuilder();
        byte abyte1[] = new byte[16];
        int k = 0;
        stringbuilder.append("\n0x");
        stringbuilder.append(toHexString(i));
        for(int l = i; l < i + j;) {
            if(k == 16) {
                stringbuilder.append(" ");
                int i2 = 0;
                while(i2 < 16)  {
                    if(abyte1[i2] > 32 && abyte1[i2] < 126)
                        stringbuilder.append(new String(abyte1, i2, 1));
                    else
                        stringbuilder.append(".");
                    i2++;
                }
                stringbuilder.append("\n0x");
                stringbuilder.append(toHexString(l));
                k = 0;
            }
            byte byte0 = abyte0[l];
            stringbuilder.append(" ");
            stringbuilder.append(HEX_DIGITS[0xf & byte0 >>> 4]);
            stringbuilder.append(HEX_DIGITS[byte0 & 0xf]);
            int l1 = k + 1;
            abyte1[k] = byte0;
            l++;
            k = l1;
        }

        if(k != 16) {
            int i1 = 1 + 3 * (16 - k);
            for(int j1 = 0; j1 < i1; j1++)
                stringbuilder.append(" ");

            int k1 = 0;
            while(k1 < k)  {
                if(abyte1[k1] > 32 && abyte1[k1] < 126)
                    stringbuilder.append(new String(abyte1, k1, 1));
                else
                    stringbuilder.append(".");
                k1++;
            }
        }
        return stringbuilder.toString();
    }

    public static byte[] hexStringToByteArray(String s) {
        int i = s.length();
        byte abyte0[] = new byte[i / 2];
        for(int j = 0; j < i; j += 2)
            abyte0[j / 2] = (byte)(toByte(s.charAt(j)) << 4 | toByte(s.charAt(j + 1)));

        return abyte0;
    }

    private static int toByte(char c) {
        int i;
        if(c >= '0' && c <= '9')
            i = c + -48;
        else
        if(c >= 'A' && c <= 'F')
            i = 10 + (c + -65);
        else
        if(c >= 'a' && c <= 'f')
            i = 10 + (c + -97);
        else
            throw new RuntimeException((new StringBuilder()).append("Invalid hex char '").append(c).append("'").toString());
        return i;
    }

    public static byte[] toByteArray(byte byte0) {
        byte abyte0[] = new byte[1];
        abyte0[0] = byte0;
        return abyte0;
    }

    public static byte[] toByteArray(int i) {
        byte abyte0[] = new byte[4];
        abyte0[3] = (byte)(i & 0xff);
        abyte0[2] = (byte)(0xff & i >> 8);
        abyte0[1] = (byte)(0xff & i >> 16);
        abyte0[0] = (byte)(0xff & i >> 24);
        return abyte0;
    }

    public static String toHexString(byte byte0) {
        return toHexString(toByteArray(byte0));
    }

    public static String toHexString(int i) {
        return toHexString(toByteArray(i));
    }

    public static String toHexString(byte abyte0[]) {
        return toHexString(abyte0, 0, abyte0.length);
    }

    public static String toHexString(byte abyte0[], int i, int j) {
        char ac[] = new char[j * 2];
        int k = i;
        int l = 0;
        for(; k < i + j; k++) {
            byte byte0 = abyte0[k];
            int i1 = l + 1;
            ac[l] = HEX_DIGITS[0xf & byte0 >>> 4];
            l = i1 + 1;
            ac[i1] = HEX_DIGITS[byte0 & 0xf];
        }

        return new String(ac);
    }

    private static final char HEX_DIGITS[];

    static  {
        char ac[] = new char[16];
        ac[0] = '0';
        ac[1] = '1';
        ac[2] = '2';
        ac[3] = '3';
        ac[4] = '4';
        ac[5] = '5';
        ac[6] = '6';
        ac[7] = '7';
        ac[8] = '8';
        ac[9] = '9';
        ac[10] = 'A';
        ac[11] = 'B';
        ac[12] = 'C';
        ac[13] = 'D';
        ac[14] = 'E';
        ac[15] = 'F';
        HEX_DIGITS = ac;
    }
}
