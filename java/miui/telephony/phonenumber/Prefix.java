// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.telephony.phonenumber;

import android.text.TextUtils;

// Referenced classes of package miui.telephony.phonenumber:
//            CountryCode

public class Prefix {

    public Prefix() {
    }

    public static boolean isSmsPrefix(String s) {
        String as[];
        int i;
        int j;
        if(TextUtils.isEmpty(s))
            break MISSING_BLOCK_LABEL_44;
        as = SMS_PREFIXES;
        i = as.length;
        j = 0;
_L3:
        if(j >= i)
            break MISSING_BLOCK_LABEL_44;
        if(!as[j].equals(s)) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        j++;
          goto _L3
        flag = false;
          goto _L4
    }

    public static String parse(StringBuffer stringbuffer, int i, int j) {
        String s;
        if(!CountryCode.isChinaEnvironment()) {
            s = "";
        } else {
label0:
            {
                if(j > 0)
                    break label0;
                s = "";
            }
        }
_L4:
        return s;
        stringbuffer.charAt(i);
        JVM INSTR lookupswitch 2: default 52
    //                   49: 58
    //                   54: 501;
           goto _L1 _L2 _L3
_L6:
        s = "";
          goto _L4
_L2:
        if(j > 4)
            switch(stringbuffer.charAt(i + 1)) {
            default:
                break;

            case 48: // '0'
                if(stringbuffer.charAt(i + 2) == '6' && stringbuffer.charAt(i + 3) == '5') {
                    switch(stringbuffer.charAt(i + 4)) {
                    case 48: // '0'
                        s = "10650";
                        continue; /* Loop/switch isn't completed */

                    case 49: // '1'
                        s = "10651";
                        continue; /* Loop/switch isn't completed */

                    case 54: // '6'
                        s = "10656";
                        continue; /* Loop/switch isn't completed */

                    case 55: // '7'
                        s = "10657";
                        continue; /* Loop/switch isn't completed */

                    case 57: // '9'
                        s = "10659";
                        continue; /* Loop/switch isn't completed */
                    }
                    break;
                }
                if(stringbuffer.charAt(i + 2) != '1' || stringbuffer.charAt(i + 3) != '9' || stringbuffer.charAt(i + 4) != '3')
                    break;
                s = "10193";
                continue; /* Loop/switch isn't completed */

            case 50: // '2'
                if(stringbuffer.charAt(i + 2) != '5')
                    break;
                if(stringbuffer.charAt(i + 3) == '9' && stringbuffer.charAt(i + 4) == '3') {
                    s = "12593";
                    continue; /* Loop/switch isn't completed */
                }
                if(stringbuffer.charAt(i + 3) != '2' || stringbuffer.charAt(i + 4) != '0')
                    break;
                s = "12520";
                continue; /* Loop/switch isn't completed */

            case 55: // '7'
                if(stringbuffer.charAt(i + 2) != '9')
                    break;
                if(stringbuffer.charAt(i + 3) == '0' && stringbuffer.charAt(i + 4) == '1') {
                    s = "17901";
                    continue; /* Loop/switch isn't completed */
                }
                if(stringbuffer.charAt(i + 3) == '0' && stringbuffer.charAt(i + 4) == '9') {
                    s = "17909";
                    continue; /* Loop/switch isn't completed */
                }
                if(stringbuffer.charAt(i + 3) == '1' && stringbuffer.charAt(i + 4) == '1') {
                    s = "17911";
                    continue; /* Loop/switch isn't completed */
                }
                if(stringbuffer.charAt(i + 3) == '5' && stringbuffer.charAt(i + 4) == '1') {
                    s = "17951";
                    continue; /* Loop/switch isn't completed */
                }
                if(stringbuffer.charAt(i + 3) != '6' || stringbuffer.charAt(i + 4) != '1')
                    break;
                s = "17961";
                continue; /* Loop/switch isn't completed */
            }
_L1:
        if(true) goto _L6; else goto _L5
_L5:
_L3:
        if(j <= 13 || stringbuffer.charAt(i + 1) != '0' || stringbuffer.charAt(i + 2) != '0') goto _L6; else goto _L7
_L7:
        s = "600";
        if(true) goto _L4; else goto _L8
_L8:
    }

    public static final String EMPTY = "";
    public static final String PREFIX_10193 = "10193";
    public static final String PREFIX_10650 = "10650";
    public static final String PREFIX_10651 = "10651";
    public static final String PREFIX_10656 = "10656";
    public static final String PREFIX_10657 = "10657";
    public static final String PREFIX_10659 = "10659";
    public static final String PREFIX_12520 = "12520";
    public static final String PREFIX_12593 = "12593";
    public static final String PREFIX_17901 = "17901";
    public static final String PREFIX_17909 = "17909";
    public static final String PREFIX_17911 = "17911";
    public static final String PREFIX_17951 = "17951";
    public static final String PREFIX_17961 = "17961";
    public static final String PREFIX_600 = "600";
    public static final String SMS_PREFIXES[];

    static  {
        String as[] = new String[6];
        as[0] = "12520";
        as[1] = "10657";
        as[2] = "10656";
        as[3] = "10650";
        as[4] = "10651";
        as[5] = "10659";
        SMS_PREFIXES = as;
    }
}
