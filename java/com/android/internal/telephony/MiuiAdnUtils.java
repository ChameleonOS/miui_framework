// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.util.Log;
import java.io.UnsupportedEncodingException;

// Referenced classes of package com.android.internal.telephony:
//            EncodeException, GsmAlphabet

public class MiuiAdnUtils {

    public MiuiAdnUtils() {
    }

    public static boolean encodeAlphaTag(byte abyte0[], String s, int i) {
        boolean flag = true;
        byte abyte4[];
        GsmAlphabet.stringToGsm7BitPacked(s);
        abyte4 = GsmAlphabet.stringToGsm8BitPacked(s);
        byte abyte3[] = abyte4;
_L1:
        EncodeException encodeexception;
        byte abyte1[];
        UnsupportedEncodingException unsupportedencodingexception;
        byte abyte2[];
        if(abyte3.length <= i)
            i = abyte3.length;
        System.arraycopy(abyte3, 0, abyte0, 0, i);
_L2:
        return flag;
        encodeexception;
        Log.w("MiuiAdnUtils", "[buildAdnString]  can't encode with GSM alphabet, try utf-16be");
        abyte1 = new byte[flag];
        abyte1[0] = -128;
        abyte2 = s.getBytes("utf-16be");
        abyte3 = new byte[1 + abyte2.length];
        System.arraycopy(abyte1, 0, abyte3, 0, flag);
        System.arraycopy(abyte2, 0, abyte3, flag, abyte2.length);
          goto _L1
        unsupportedencodingexception;
        Log.e("MiuiAdnUtils", "Implausible UnsupportedEncodingException ", unsupportedencodingexception);
        flag = false;
          goto _L2
    }

    private static final String TAG = "MiuiAdnUtils";
}
