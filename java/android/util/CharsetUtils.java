// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;

import android.os.Build;
import android.text.TextUtils;
import java.nio.charset.*;
import java.util.HashMap;
import java.util.Map;

public final class CharsetUtils {

    private CharsetUtils() {
    }

    public static Charset charsetForVendor(String s) throws UnsupportedCharsetException, IllegalCharsetNameException {
        return charsetForVendor(s, getDefaultVendor());
    }

    public static Charset charsetForVendor(String s, String s1) throws UnsupportedCharsetException, IllegalCharsetNameException {
        return Charset.forName(nameForVendor(s, s1));
    }

    private static String getDefaultVendor() {
        return Build.BRAND;
    }

    private static boolean isShiftJis(String s) {
        boolean flag = false;
        if(s != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        int i = s.length();
        if((i == 4 || i == 9) && (s.equalsIgnoreCase("shift_jis") || s.equalsIgnoreCase("shift-jis") || s.equalsIgnoreCase("sjis")))
            flag = true;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static String nameForDefaultVendor(String s) {
        return nameForVendor(s, getDefaultVendor());
    }

    public static String nameForVendor(String s, String s1) {
        if(TextUtils.isEmpty(s) || TextUtils.isEmpty(s1) || !isShiftJis(s)) goto _L2; else goto _L1
_L1:
        String s2 = (String)sVendorShiftJisMap.get(s1);
        if(s2 == null) goto _L2; else goto _L3
_L3:
        return s2;
_L2:
        s2 = s;
        if(true) goto _L3; else goto _L4
_L4:
    }

    private static final String VENDOR_DOCOMO = "docomo";
    private static final String VENDOR_KDDI = "kddi";
    private static final String VENDOR_SOFTBANK = "softbank";
    private static final Map sVendorShiftJisMap;

    static  {
        sVendorShiftJisMap = new HashMap();
        sVendorShiftJisMap.put("docomo", "docomo-shift_jis-2007");
        sVendorShiftJisMap.put("kddi", "kddi-shift_jis-2007");
        sVendorShiftJisMap.put("softbank", "softbank-shift_jis-2007");
    }
}
