// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.mms.pdu;


public class Base64 {

    public Base64() {
    }

    public static byte[] decodeBase64(byte abyte0[]) {
        byte abyte1[] = discardNonBase64(abyte0);
        if(abyte1.length != 0) goto _L2; else goto _L1
_L1:
        byte abyte2[] = new byte[0];
_L4:
        return abyte2;
_L2:
        int i;
        int j;
        int k;
        i = abyte1.length / 4;
        j = 0;
        k = abyte1.length;
        do
            if(abyte1[k - 1] != 61)
                break; /* Loop/switch isn't completed */
        while(--k != 0);
        abyte2 = new byte[0];
        if(true) goto _L4; else goto _L3
_L3:
        abyte2 = new byte[k - i];
        int l = 0;
        while(l < i)  {
            int i1 = l * 4;
            byte byte0 = abyte1[i1 + 2];
            byte byte1 = abyte1[i1 + 3];
            byte byte2 = base64Alphabet[abyte1[i1]];
            byte byte3 = base64Alphabet[abyte1[i1 + 1]];
            if(byte0 != 61 && byte1 != 61) {
                byte byte5 = base64Alphabet[byte0];
                byte byte6 = base64Alphabet[byte1];
                abyte2[j] = (byte)(byte2 << 2 | byte3 >> 4);
                abyte2[j + 1] = (byte)((byte3 & 0xf) << 4 | 0xf & byte5 >> 2);
                abyte2[j + 2] = (byte)(byte6 | byte5 << 6);
            } else
            if(byte0 == 61)
                abyte2[j] = (byte)(byte2 << 2 | byte3 >> 4);
            else
            if(byte1 == 61) {
                byte byte4 = base64Alphabet[byte0];
                abyte2[j] = (byte)(byte2 << 2 | byte3 >> 4);
                abyte2[j + 1] = (byte)((byte3 & 0xf) << 4 | 0xf & byte4 >> 2);
            }
            j += 3;
            l++;
        }
        if(true) goto _L4; else goto _L5
_L5:
    }

    static byte[] discardNonBase64(byte abyte0[]) {
        byte abyte1[] = new byte[abyte0.length];
        int i = 0;
        for(int j = 0; j < abyte0.length; j++)
            if(isBase64(abyte0[j])) {
                int k = i + 1;
                abyte1[i] = abyte0[j];
                i = k;
            }

        byte abyte2[] = new byte[i];
        System.arraycopy(abyte1, 0, abyte2, 0, i);
        return abyte2;
    }

    private static boolean isBase64(byte byte0) {
        boolean flag;
        flag = true;
        break MISSING_BLOCK_LABEL_2;
        if(byte0 != 61 && base64Alphabet[byte0] == -1)
            flag = false;
        return flag;
    }

    static final int BASELENGTH = 255;
    static final int FOURBYTE = 4;
    static final byte PAD = 61;
    private static byte base64Alphabet[];

    static  {
        base64Alphabet = new byte[255];
        for(int i = 0; i < 255; i++)
            base64Alphabet[i] = -1;

        for(int j = 90; j >= 65; j--)
            base64Alphabet[j] = (byte)(j - 65);

        for(int k = 122; k >= 97; k--)
            base64Alphabet[k] = (byte)(26 + (k - 97));

        for(int l = 57; l >= 48; l--)
            base64Alphabet[l] = (byte)(52 + (l - 48));

        base64Alphabet[43] = 62;
        base64Alphabet[47] = 63;
    }
}
