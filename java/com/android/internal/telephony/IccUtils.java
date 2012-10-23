// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.Log;
import java.io.UnsupportedEncodingException;

// Referenced classes of package com.android.internal.telephony:
//            GsmAlphabet

public class IccUtils {

    public IccUtils() {
    }

    public static String adnStringFieldToString(byte abyte0[], int i, int j) {
        if(j != 0) goto _L2; else goto _L1
_L1:
        String s = "";
_L6:
        return s;
_L2:
        int i1;
        String s3;
        if(j < 1 || abyte0[i] != -128)
            break MISSING_BLOCK_LABEL_122;
        i1 = (j - 1) / 2;
        s3 = null;
        String s4 = new String(abyte0, i + 1, i1 * 2, "utf-16be");
        s3 = s4;
_L4:
        int j1;
        if(s3 == null)
            break MISSING_BLOCK_LABEL_122;
        for(j1 = s3.length(); j1 > 0 && s3.charAt(j1 - 1) == '\uFFFF'; j1--);
        break; /* Loop/switch isn't completed */
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        Log.e("IccUtils", "implausible UnsupportedEncodingException", unsupportedencodingexception);
        if(true) goto _L4; else goto _L3
_L3:
        s = s3.substring(0, j1);
        continue; /* Loop/switch isn't completed */
        Resources resources;
        String s1;
        boolean flag = false;
        char c = '\0';
        int k = 0;
        if(j >= 3 && abyte0[i] == -127) {
            k = 0xff & abyte0[i + 1];
            if(k > j - 3)
                k = j - 3;
            c = (char)((0xff & abyte0[i + 2]) << 7);
            i += 3;
            flag = true;
        } else
        if(j >= 4 && abyte0[i] == -126) {
            k = 0xff & abyte0[i + 1];
            if(k > j - 4)
                k = j - 4;
            c = (char)((0xff & abyte0[i + 2]) << 8 | 0xff & abyte0[i + 3]);
            i += 4;
            flag = true;
        }
        if(flag) {
            StringBuilder stringbuilder = new StringBuilder();
            int l;
            for(; k > 0; k -= l) {
                if(abyte0[i] < 0) {
                    stringbuilder.append(c + (0x7f & abyte0[i]));
                    i++;
                    k--;
                }
                for(l = 0; l < k && abyte0[i + l] >= 0; l++);
                stringbuilder.append(GsmAlphabet.gsm8BitUnpackedToString(abyte0, i, l));
                i += l;
            }

            s = stringbuilder.toString();
            continue; /* Loop/switch isn't completed */
        }
        resources = Resources.getSystem();
        s1 = "";
        String s2 = resources.getString(0x1040020);
        s1 = s2;
_L7:
        s = GsmAlphabet.gsm8BitUnpackedToString(abyte0, i, j, s1.trim());
        if(true) goto _L6; else goto _L5
_L5:
        android.content.res.Resources.NotFoundException notfoundexception;
        notfoundexception;
          goto _L7
    }

    public static String bcdToString(byte abyte0[], int i, int j) {
        StringBuilder stringbuilder;
        int k;
        stringbuilder = new StringBuilder(j * 2);
        k = i;
_L4:
        if(k >= i + j) goto _L2; else goto _L1
_L1:
        int l = 0xf & abyte0[k];
        if(l <= 9) goto _L3; else goto _L2
_L2:
        return stringbuilder.toString();
_L3:
        int i1;
        stringbuilder.append((char)(l + 48));
        i1 = 0xf & abyte0[k] >> 4;
        if(i1 != 15)
            continue; /* Loop/switch isn't completed */
_L6:
        k++;
          goto _L4
        if(i1 > 9) goto _L2; else goto _L5
_L5:
        stringbuilder.append((char)(i1 + 48));
          goto _L6
    }

    private static int bitToRGB(int i) {
        int j;
        if(i == 1)
            j = -1;
        else
            j = 0xff000000;
        return j;
    }

    public static String bytesToHexString(byte abyte0[]) {
        String s;
        if(abyte0 == null) {
            s = null;
        } else {
            StringBuilder stringbuilder = new StringBuilder(2 * abyte0.length);
            for(int i = 0; i < abyte0.length; i++) {
                stringbuilder.append("0123456789abcdef".charAt(0xf & abyte0[i] >> 4));
                stringbuilder.append("0123456789abcdef".charAt(0xf & abyte0[i]));
            }

            s = stringbuilder.toString();
        }
        return s;
    }

    public static int cdmaBcdByteToInt(byte byte0) {
        int i = 0;
        if((byte0 & 0xf0) <= 144)
            i = 10 * (0xf & byte0 >> 4);
        if((byte0 & 0xf) <= 9)
            i += byte0 & 0xf;
        return i;
    }

    public static String cdmaBcdToString(byte abyte0[], int i, int j) {
        StringBuilder stringbuilder = new StringBuilder(j);
        int k = 0;
        int l = i;
        do {
            int j1;
label0:
            {
                if(k < j) {
                    int i1 = 0xf & abyte0[l];
                    if(i1 > 9)
                        i1 = 0;
                    stringbuilder.append((char)(i1 + 48));
                    j1 = k + 1;
                    if(j1 != j)
                        break label0;
                }
                return stringbuilder.toString();
            }
            int k1 = 0xf & abyte0[l] >> 4;
            if(k1 > 9)
                k1 = 0;
            stringbuilder.append((char)(k1 + 48));
            k = j1 + 1;
            l++;
        } while(true);
    }

    private static int[] getCLUT(byte abyte0[], int i, int j) {
        if(abyte0 != null) goto _L2; else goto _L1
_L1:
        int ai[] = null;
_L4:
        return ai;
_L2:
        ai = new int[j];
        int k = i + j * 3;
        int l = i;
        int i1 = 0;
        do {
            int j1 = i1 + 1;
            int k1 = l + 1;
            int l1 = 0xff000000 | (0xff & abyte0[l]) << 16;
            int i2 = k1 + 1;
            int j2 = l1 | (0xff & abyte0[k1]) << 8;
            int k2 = i2 + 1;
            ai[i1] = j2 | 0xff & abyte0[i2];
            if(k2 >= k)
                continue;
            i1 = j1;
            l = k2;
        } while(true);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static int gsmBcdByteToInt(byte byte0) {
        int i = 0;
        if((byte0 & 0xf0) <= 144)
            i = 0xf & byte0 >> 4;
        if((byte0 & 0xf) <= 9)
            i += 10 * (byte0 & 0xf);
        return i;
    }

    static int hexCharToInt(char c) {
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
            throw new RuntimeException((new StringBuilder()).append("invalid hex char '").append(c).append("'").toString());
        return i;
    }

    public static byte[] hexStringToBytes(String s) {
        byte abyte0[];
        if(s == null) {
            abyte0 = null;
        } else {
            int i = s.length();
            abyte0 = new byte[i / 2];
            int j = 0;
            while(j < i)  {
                abyte0[j / 2] = (byte)(hexCharToInt(s.charAt(j)) << 4 | hexCharToInt(s.charAt(j + 1)));
                j += 2;
            }
        }
        return abyte0;
    }

    private static int[] mapTo2OrderBitColor(byte abyte0[], int i, int j, int ai[], int k) {
        if(8 % k == 0) goto _L2; else goto _L1
_L1:
        int ai1[];
        Log.e("IccUtils", "not event number of color");
        ai1 = mapToNon2OrderBitColor(abyte0, i, j, ai, k);
_L10:
        return ai1;
_L2:
        char c = '\001';
        k;
        JVM INSTR tableswitch 1 8: default 80
    //                   1 174
    //                   2 180
    //                   3 80
    //                   4 186
    //                   5 80
    //                   6 80
    //                   7 80
    //                   8 193;
           goto _L3 _L4 _L5 _L3 _L6 _L3 _L3 _L3 _L7
_L3:
        int l;
        int i1;
        int j1;
        ai1 = new int[j];
        l = 0;
        i1 = 8 / k;
        j1 = i;
_L8:
        int k1;
        int i2;
        if(l >= j)
            break MISSING_BLOCK_LABEL_212;
        k1 = j1 + 1;
        byte byte0 = abyte0[j1];
        int l1 = 0;
        int k2;
        for(i2 = l; l1 < i1; i2 = k2) {
            int j2 = -1 + (i1 - l1);
            k2 = i2 + 1;
            ai1[i2] = ai[c & byte0 >> j2 * k];
            l1++;
        }

        break MISSING_BLOCK_LABEL_201;
_L4:
        c = '\001';
          goto _L3
_L5:
        c = '\003';
          goto _L3
_L6:
        c = '\017';
          goto _L3
_L7:
        c = '\377';
          goto _L3
        l = i2;
        j1 = k1;
          goto _L8
        j1;
        if(true) goto _L10; else goto _L9
_L9:
    }

    private static int[] mapToNon2OrderBitColor(byte abyte0[], int i, int j, int ai[], int k) {
        int ai1[];
        if(8 % k == 0) {
            Log.e("IccUtils", "not odd number of color");
            ai1 = mapTo2OrderBitColor(abyte0, i, j, ai, k);
        } else {
            ai1 = new int[j];
        }
        return ai1;
    }

    public static String networkNameToString(byte abyte0[], int i, int j) {
        if((0x80 & abyte0[i]) == 128 && j >= 1) goto _L2; else goto _L1
_L1:
        String s = "";
_L4:
        return s;
_L2:
        switch(7 & abyte0[i] >>> 4) {
        default:
            s = "";
            break;

        case 0: // '\0'
            break; /* Loop/switch isn't completed */

        case 1: // '\001'
            break MISSING_BLOCK_LABEL_102;
        }
_L5:
        if((0x40 & abyte0[i]) == 0);
        if(true) goto _L4; else goto _L3
_L3:
        int k = 7 & abyte0[i];
        int l = (8 * (j - 1) - k) / 7;
        s = GsmAlphabet.gsm7BitPackedToString(abyte0, i + 1, l);
          goto _L5
        try {
            s = new String(abyte0, i + 1, j - 1, "utf-16");
        }
        catch(UnsupportedEncodingException unsupportedencodingexception) {
            s = "";
            Log.e("IccUtils", "implausible UnsupportedEncodingException", unsupportedencodingexception);
        }
          goto _L5
    }

    public static Bitmap parseToBnW(byte abyte0[], int i) {
        int j = 0 + 1;
        int k = 0xff & abyte0[0];
        int l = j + 1;
        int i1 = 0xff & abyte0[j];
        int j1 = k * i1;
        int ai[] = new int[j1];
        int k1 = 7;
        byte byte0 = 0;
        int l1 = 0;
        int i2 = l;
        while(l1 < j1)  {
            int j2;
            int k2;
            int l2;
            if(l1 % 8 == 0) {
                j2 = i2 + 1;
                byte0 = abyte0[i2];
                k1 = 7;
            } else {
                j2 = i2;
            }
            k2 = l1 + 1;
            l2 = k1 - 1;
            ai[l1] = bitToRGB(1 & byte0 >> k1);
            k1 = l2;
            l1 = k2;
            i2 = j2;
        }
        if(l1 != j1)
            Log.e("IccUtils", "parse end and size error");
        return Bitmap.createBitmap(ai, k, i1, android.graphics.Bitmap.Config.ARGB_8888);
    }

    public static Bitmap parseToRGB(byte abyte0[], int i, boolean flag) {
        int j = 0 + 1;
        int k = 0xff & abyte0[0];
        int l = j + 1;
        int i1 = 0xff & abyte0[j];
        int j1 = l + 1;
        int k1 = 0xff & abyte0[l];
        int l1 = j1 + 1;
        int i2 = 0xff & abyte0[j1];
        int j2 = l1 + 1;
        int k2 = (0xff & abyte0[l1]) << 8;
        int l2 = j2 + 1;
        int ai[] = getCLUT(abyte0, k2 | 0xff & abyte0[j2], i2);
        if(flag)
            ai[i2 - 1] = 0;
        int ai1[];
        if(8 % k1 == 0)
            ai1 = mapTo2OrderBitColor(abyte0, l2, k * i1, ai, k1);
        else
            ai1 = mapToNon2OrderBitColor(abyte0, l2, k * i1, ai, k1);
        return Bitmap.createBitmap(ai1, k, i1, android.graphics.Bitmap.Config.RGB_565);
    }

    static final String LOG_TAG = "IccUtils";
}
