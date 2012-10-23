// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.telephony.phonenumber;

import android.content.res.Resources;
import android.os.SystemProperties;
import android.text.TextUtils;
import java.util.HashMap;

public class CountryCode {

    public CountryCode() {
    }

    public static String getIccCountryCode() {
        updateIcc();
        return ICC_COUNTRY_CODE;
    }

    public static String getIddCode() {
        updateNetwork();
        return NETWORK_IDD_CODE;
    }

    public static String getNetworkCountryCode() {
        updateNetwork();
        return NETWORK_COUNTRY_CODE;
    }

    public static String getUserDefinedCountryCode() {
        return SystemProperties.get("persist.radio.countrycode", "");
    }

    public static boolean isChinaEnvironment() {
        String s = getUserDefinedCountryCode();
        boolean flag;
        if(!TextUtils.isEmpty(s))
            flag = "86".equals(s);
        else
        if("86".equals(getIccCountryCode()) || "86".equals(getNetworkCountryCode()))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isValidCountryCode(String s) {
        return sNameMap.containsKey(s);
    }

    public static String parse(StringBuffer stringbuffer, int i, int j) {
        if(j > 0) goto _L2; else goto _L1
_L1:
        String s = "";
_L13:
        return s;
_L2:
        stringbuffer.charAt(i);
        JVM INSTR tableswitch 49 57: default 64
    //                   49 70
    //                   50 648
    //                   51 1586
    //                   52 2148
    //                   53 2772
    //                   54 3165
    //                   55 3599
    //                   56 3606
    //                   57 3844;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L46:
        s = "";
          goto _L13
_L4:
        if(j <= 3) goto _L15; else goto _L14
_L14:
        char c3;
        char c4;
        c3 = stringbuffer.charAt(i + 2);
        c4 = stringbuffer.charAt(i + 3);
        stringbuffer.charAt(i + 1);
        JVM INSTR tableswitch 50 57: default 148
    //                   50 155
    //                   51 242
    //                   52 277
    //                   53 148
    //                   54 317
    //                   55 414
    //                   56 511
    //                   57 627;
           goto _L15 _L16 _L17 _L18 _L15 _L19 _L20 _L21 _L22
_L15:
        s = "1";
          goto _L13
_L16:
        if(c3 == '4') {
            if(c4 != '2')
                continue; /* Loop/switch isn't completed */
            s = "1242";
        } else {
            if(c3 != '6')
                continue; /* Loop/switch isn't completed */
            if(c4 != '4')
                continue; /* Loop/switch isn't completed */
            s = "1264";
        }
          goto _L13
        if(c4 != '6') goto _L15; else goto _L23
_L23:
        s = "1246";
          goto _L13
        if(c4 != '8') goto _L15; else goto _L24
_L24:
        s = "1268";
          goto _L13
        if(c3 != '8' || c4 != '4') goto _L15; else goto _L25
_L25:
        s = "1284";
          goto _L13
_L17:
        if(c3 != '4') goto _L15; else goto _L26
_L26:
        if(c4 != '0')
            continue; /* Loop/switch isn't completed */
        s = "1340";
          goto _L13
        if(c4 != '5') goto _L15; else goto _L27
_L27:
        s = "1345";
          goto _L13
_L18:
        if(c3 != '4' || c4 != '1')
            continue; /* Loop/switch isn't completed */
        s = "1441";
          goto _L13
        if(c3 != '7' || c4 != '3') goto _L15; else goto _L28
_L28:
        s = "1473";
          goto _L13
_L19:
        if(c3 == '4' && c4 == '9')
            s = "1649";
        else
        if(c3 == '6' && c4 == '4') {
            s = "1664";
        } else {
            if(c3 != '7')
                continue; /* Loop/switch isn't completed */
            if(c4 == '0') {
                s = "1670";
            } else {
                if(c4 != '1')
                    continue; /* Loop/switch isn't completed */
                s = "1671";
            }
        }
          goto _L13
        if(c3 != '8' || c4 != '4') goto _L15; else goto _L29
_L29:
        s = "1684";
          goto _L13
_L20:
        if(c3 == '2' && c4 == '1')
            s = "1721";
        else
        if(c3 == '5' && c4 == '8') {
            s = "1758";
        } else {
            if(c3 != '6' || c4 != '7')
                continue; /* Loop/switch isn't completed */
            s = "1767";
        }
          goto _L13
        if(c3 != '8') goto _L15; else goto _L30
_L30:
        if(c4 != '4')
            continue; /* Loop/switch isn't completed */
        s = "1784";
          goto _L13
        if(c4 != '7') goto _L15; else goto _L31
_L31:
        s = "1787";
          goto _L13
_L21:
        if(c3 == '0' && c4 == '9')
            s = "1809";
        else
        if(c3 == '2' && c4 == '9')
            s = "1829";
        else
        if(c3 == '4' && c4 == '9') {
            s = "1849";
        } else {
            if(c3 != '6')
                continue; /* Loop/switch isn't completed */
            if(c4 == '8') {
                s = "1868";
            } else {
                if(c4 != '9')
                    continue; /* Loop/switch isn't completed */
                s = "1869";
            }
        }
          goto _L13
        if(c3 != '7' || c4 != '6') goto _L15; else goto _L32
_L32:
        s = "1876";
          goto _L13
_L22:
        if(c3 != '3' || c4 != '9') goto _L15; else goto _L33
_L33:
        s = "1939";
          goto _L13
_L5:
        if(j <= 1) goto _L3; else goto _L34
_L34:
        stringbuffer.charAt(i + 1);
        JVM INSTR tableswitch 48 57: default 716
    //                   48 719
    //                   49 725
    //                   50 810
    //                   51 945
    //                   52 1081
    //                   53 1216
    //                   54 1343
    //                   55 1480
    //                   56 716
    //                   57 1487;
           goto _L35 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43 _L35 _L44
_L35:
        break; /* Loop/switch isn't completed */
_L36:
        s = "20";
          goto _L13
_L37:
        if(j > 2)
            switch(stringbuffer.charAt(i + 2)) {
            case 50: // '2'
                s = "212";
                continue; /* Loop/switch isn't completed */

            case 51: // '3'
                s = "213";
                continue; /* Loop/switch isn't completed */

            case 54: // '6'
                s = "216";
                continue; /* Loop/switch isn't completed */

            case 56: // '8'
                s = "218";
                continue; /* Loop/switch isn't completed */
            }
        break; /* Loop/switch isn't completed */
_L38:
        if(j <= 2)
            break; /* Loop/switch isn't completed */
        switch(stringbuffer.charAt(i + 2)) {
        default:
            break; /* Loop/switch isn't completed */

        case 48: // '0'
            s = "220";
            break;

        case 49: // '1'
            s = "221";
            break;

        case 50: // '2'
            s = "222";
            break;

        case 51: // '3'
            s = "223";
            break;

        case 52: // '4'
            s = "224";
            break;

        case 53: // '5'
            s = "225";
            break;

        case 54: // '6'
            s = "226";
            break;

        case 55: // '7'
            s = "227";
            break;

        case 56: // '8'
            s = "228";
            break;

        case 57: // '9'
            s = "229";
            break;
        }
        continue; /* Loop/switch isn't completed */
_L39:
        if(j <= 2)
            break; /* Loop/switch isn't completed */
        switch(stringbuffer.charAt(i + 2)) {
        default:
            break; /* Loop/switch isn't completed */

        case 48: // '0'
            s = "230";
            break;

        case 49: // '1'
            s = "231";
            break;

        case 50: // '2'
            s = "232";
            break;

        case 51: // '3'
            s = "233";
            break;

        case 52: // '4'
            s = "234";
            break;

        case 53: // '5'
            s = "235";
            break;

        case 54: // '6'
            s = "236";
            break;

        case 55: // '7'
            s = "237";
            break;

        case 56: // '8'
            s = "238";
            break;

        case 57: // '9'
            s = "239";
            break;
        }
        continue; /* Loop/switch isn't completed */
_L40:
        if(j <= 2)
            break; /* Loop/switch isn't completed */
        switch(stringbuffer.charAt(i + 2)) {
        default:
            break; /* Loop/switch isn't completed */

        case 48: // '0'
            s = "240";
            break;

        case 49: // '1'
            s = "241";
            break;

        case 50: // '2'
            s = "242";
            break;

        case 51: // '3'
            s = "243";
            break;

        case 52: // '4'
            s = "244";
            break;

        case 53: // '5'
            s = "245";
            break;

        case 54: // '6'
            s = "246";
            break;

        case 55: // '7'
            s = "247";
            break;

        case 56: // '8'
            s = "248";
            break;

        case 57: // '9'
            s = "249";
            break;
        }
        continue; /* Loop/switch isn't completed */
_L41:
        if(j <= 2)
            break; /* Loop/switch isn't completed */
        switch(stringbuffer.charAt(i + 2)) {
        default:
            break; /* Loop/switch isn't completed */

        case 48: // '0'
            s = "250";
            break;

        case 49: // '1'
            s = "251";
            break;

        case 50: // '2'
            s = "252";
            break;

        case 51: // '3'
            s = "253";
            break;

        case 52: // '4'
            s = "254";
            break;

        case 53: // '5'
            s = "255";
            break;

        case 54: // '6'
            s = "256";
            break;

        case 55: // '7'
            s = "257";
            break;

        case 56: // '8'
            s = "258";
            break;
        }
        continue; /* Loop/switch isn't completed */
_L42:
        if(j <= 2)
            break; /* Loop/switch isn't completed */
        switch(stringbuffer.charAt(i + 2)) {
        default:
            break; /* Loop/switch isn't completed */

        case 48: // '0'
            s = "260";
            break;

        case 49: // '1'
            s = "261";
            break;

        case 50: // '2'
            s = "262";
            break;

        case 51: // '3'
            s = "263";
            break;

        case 52: // '4'
            s = "264";
            break;

        case 53: // '5'
            s = "265";
            break;

        case 54: // '6'
            s = "266";
            break;

        case 55: // '7'
            s = "267";
            break;

        case 56: // '8'
            s = "268";
            break;

        case 57: // '9'
            s = "269";
            break;
        }
        continue; /* Loop/switch isn't completed */
_L43:
        s = "27";
        continue; /* Loop/switch isn't completed */
_L44:
        if(j <= 2)
            break; /* Loop/switch isn't completed */
        switch(stringbuffer.charAt(i + 2)) {
        case 50: // '2'
        case 51: // '3'
        case 52: // '4'
        case 53: // '5'
        case 54: // '6'
        default:
            break; /* Loop/switch isn't completed */

        case 48: // '0'
            s = "290";
            break;

        case 49: // '1'
            s = "291";
            break;

        case 55: // '7'
            s = "297";
            break;

        case 56: // '8'
            s = "298";
            break;

        case 57: // '9'
            s = "299";
            break;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if(true) goto _L46; else goto _L45
_L45:
_L6:
        if(j <= 1) goto _L46; else goto _L47
_L47:
        switch(stringbuffer.charAt(i + 1)) {
        case 48: // '0'
            s = "30";
            continue; /* Loop/switch isn't completed */

        case 49: // '1'
            s = "31";
            continue; /* Loop/switch isn't completed */

        case 50: // '2'
            s = "32";
            continue; /* Loop/switch isn't completed */

        case 51: // '3'
            s = "33";
            continue; /* Loop/switch isn't completed */

        case 52: // '4'
            s = "34";
            continue; /* Loop/switch isn't completed */

        case 53: // '5'
            if(j > 2)
                switch(stringbuffer.charAt(i + 2)) {
                case 48: // '0'
                    s = "350";
                    continue; /* Loop/switch isn't completed */

                case 49: // '1'
                    s = "351";
                    continue; /* Loop/switch isn't completed */

                case 50: // '2'
                    s = "352";
                    continue; /* Loop/switch isn't completed */

                case 51: // '3'
                    s = "353";
                    continue; /* Loop/switch isn't completed */

                case 52: // '4'
                    s = "354";
                    continue; /* Loop/switch isn't completed */

                case 53: // '5'
                    s = "355";
                    continue; /* Loop/switch isn't completed */

                case 54: // '6'
                    s = "356";
                    continue; /* Loop/switch isn't completed */

                case 55: // '7'
                    s = "357";
                    continue; /* Loop/switch isn't completed */

                case 56: // '8'
                    s = "358";
                    continue; /* Loop/switch isn't completed */

                case 57: // '9'
                    s = "359";
                    continue; /* Loop/switch isn't completed */
                }
            break;

        case 54: // '6'
            s = "36";
            continue; /* Loop/switch isn't completed */

        case 55: // '7'
            if(j > 2)
                switch(stringbuffer.charAt(i + 2)) {
                case 48: // '0'
                    s = "370";
                    continue; /* Loop/switch isn't completed */

                case 49: // '1'
                    s = "371";
                    continue; /* Loop/switch isn't completed */

                case 50: // '2'
                    s = "372";
                    continue; /* Loop/switch isn't completed */

                case 51: // '3'
                    s = "373";
                    continue; /* Loop/switch isn't completed */

                case 52: // '4'
                    s = "374";
                    continue; /* Loop/switch isn't completed */

                case 53: // '5'
                    s = "375";
                    continue; /* Loop/switch isn't completed */

                case 54: // '6'
                    s = "376";
                    continue; /* Loop/switch isn't completed */

                case 55: // '7'
                    s = "377";
                    continue; /* Loop/switch isn't completed */

                case 56: // '8'
                    s = "378";
                    continue; /* Loop/switch isn't completed */
                }
            break;

        case 56: // '8'
            if(j > 2)
                switch(stringbuffer.charAt(i + 2)) {
                case 48: // '0'
                    s = "380";
                    continue; /* Loop/switch isn't completed */

                case 49: // '1'
                    s = "381";
                    continue; /* Loop/switch isn't completed */

                case 50: // '2'
                    s = "382";
                    continue; /* Loop/switch isn't completed */

                case 53: // '5'
                    s = "385";
                    continue; /* Loop/switch isn't completed */

                case 54: // '6'
                    s = "386";
                    continue; /* Loop/switch isn't completed */

                case 55: // '7'
                    s = "387";
                    continue; /* Loop/switch isn't completed */

                case 57: // '9'
                    s = "389";
                    continue; /* Loop/switch isn't completed */
                }
            break;

        case 57: // '9'
            if(j > 6 && stringbuffer.charAt(i + 2) == '0' && stringbuffer.charAt(i + 3) == '6' && stringbuffer.charAt(i + 4) == '6' && stringbuffer.charAt(i + 5) == '9' && stringbuffer.charAt(i + 6) == '8')
                s = "3906698";
            else
                s = "39";
            continue; /* Loop/switch isn't completed */
        }
        if(true) goto _L46; else goto _L48
_L48:
_L7:
        if(j <= 1) goto _L46; else goto _L49
_L49:
        stringbuffer.charAt(i + 1);
        JVM INSTR tableswitch 48 57: default 2216
    //                   48 2219
    //                   49 2226
    //                   50 2232
    //                   51 2299
    //                   52 2305
    //                   53 2739
    //                   54 2745
    //                   55 2752
    //                   56 2759
    //                   57 2766;
           goto _L50 _L51 _L52 _L53 _L54 _L55 _L56 _L57 _L58 _L59 _L60
_L50:
        continue; /* Loop/switch isn't completed */
_L51:
        s = "40";
        continue; /* Loop/switch isn't completed */
_L52:
        s = "41";
        continue; /* Loop/switch isn't completed */
_L53:
        if(j > 2)
            switch(stringbuffer.charAt(i + 2)) {
            case 48: // '0'
                s = "420";
                continue; /* Loop/switch isn't completed */

            case 49: // '1'
                s = "421";
                continue; /* Loop/switch isn't completed */

            case 51: // '3'
                s = "423";
                continue; /* Loop/switch isn't completed */
            }
        continue; /* Loop/switch isn't completed */
_L54:
        s = "43";
        continue; /* Loop/switch isn't completed */
_L55:
        if(j <= 5) goto _L62; else goto _L61
_L61:
        char c;
        char c1;
        char c2;
        c = stringbuffer.charAt(i + 3);
        c1 = stringbuffer.charAt(i + 4);
        c2 = stringbuffer.charAt(i + 5);
        stringbuffer.charAt(i + 2);
        JVM INSTR lookupswitch 2: default 2372
    //                   49: 2379
    //                   55: 2462;
           goto _L62 _L63 _L64
_L62:
        s = "44";
        continue; /* Loop/switch isn't completed */
_L63:
        if(c == '4' && c1 == '8' && c2 == '1') {
            s = "441481";
            continue; /* Loop/switch isn't completed */
        }
        if(c == '5' && c1 == '3' && c2 == '4') {
            s = "441534";
            continue; /* Loop/switch isn't completed */
        }
        if(c == '6' && c1 == '2' && c2 == '4') {
            s = "441624";
            continue; /* Loop/switch isn't completed */
        }
        if(true) goto _L62; else goto _L64
_L64:
        if(c == '5' && c1 == '0' && c2 == '9') {
            s = "447509";
            continue; /* Loop/switch isn't completed */
        }
        if(c == '5' && c1 == '2' && c2 == '4') {
            s = "447524";
            continue; /* Loop/switch isn't completed */
        }
        if(c == '6' && c1 == '2' && c2 == '4') {
            s = "447624";
            continue; /* Loop/switch isn't completed */
        }
        if(c == '7' && c1 == '0' && c2 == '0') {
            s = "447700";
            continue; /* Loop/switch isn't completed */
        }
        if(c == '7' && c1 == '8' && c2 == '1') {
            s = "447781";
            continue; /* Loop/switch isn't completed */
        }
        if(c == '7' && c1 == '9' && c2 == '7') {
            s = "447797";
            continue; /* Loop/switch isn't completed */
        }
        if(c == '8' && c1 == '2' && c2 == '9') {
            s = "447829";
            continue; /* Loop/switch isn't completed */
        }
        if(c == '8' && c1 == '3' && c2 == '9') {
            s = "447839";
            continue; /* Loop/switch isn't completed */
        }
        if(c == '9' && c1 == '1' && c2 == '1') {
            s = "447911";
            continue; /* Loop/switch isn't completed */
        }
        if(c != '9' || c1 != '2' || c2 != '4') goto _L62; else goto _L65
_L65:
        s = "447924";
        continue; /* Loop/switch isn't completed */
_L56:
        s = "45";
        continue; /* Loop/switch isn't completed */
_L57:
        s = "46";
        continue; /* Loop/switch isn't completed */
_L58:
        s = "47";
        continue; /* Loop/switch isn't completed */
_L59:
        s = "48";
        continue; /* Loop/switch isn't completed */
_L60:
        s = "49";
        continue; /* Loop/switch isn't completed */
        if(true) goto _L46; else goto _L66
_L66:
_L8:
        if(j <= 1) goto _L46; else goto _L67
_L67:
        switch(stringbuffer.charAt(i + 1)) {
        case 48: // '0'
            if(j > 2)
                switch(stringbuffer.charAt(i + 2)) {
                case 48: // '0'
                    s = "500";
                    continue; /* Loop/switch isn't completed */

                case 49: // '1'
                    s = "501";
                    continue; /* Loop/switch isn't completed */

                case 50: // '2'
                    s = "502";
                    continue; /* Loop/switch isn't completed */

                case 51: // '3'
                    s = "503";
                    continue; /* Loop/switch isn't completed */

                case 52: // '4'
                    s = "504";
                    continue; /* Loop/switch isn't completed */

                case 53: // '5'
                    s = "505";
                    continue; /* Loop/switch isn't completed */

                case 54: // '6'
                    s = "506";
                    continue; /* Loop/switch isn't completed */

                case 55: // '7'
                    s = "507";
                    continue; /* Loop/switch isn't completed */

                case 56: // '8'
                    s = "508";
                    continue; /* Loop/switch isn't completed */

                case 57: // '9'
                    s = "509";
                    continue; /* Loop/switch isn't completed */
                }
            break;

        case 49: // '1'
            s = "51";
            continue; /* Loop/switch isn't completed */

        case 50: // '2'
            s = "52";
            continue; /* Loop/switch isn't completed */

        case 51: // '3'
            s = "53";
            continue; /* Loop/switch isn't completed */

        case 52: // '4'
            s = "54";
            continue; /* Loop/switch isn't completed */

        case 53: // '5'
            s = "55";
            continue; /* Loop/switch isn't completed */

        case 54: // '6'
            s = "56";
            continue; /* Loop/switch isn't completed */

        case 55: // '7'
            s = "57";
            continue; /* Loop/switch isn't completed */

        case 56: // '8'
            s = "58";
            continue; /* Loop/switch isn't completed */

        case 57: // '9'
            if(j > 2)
                switch(stringbuffer.charAt(i + 2)) {
                case 48: // '0'
                    s = "590";
                    continue; /* Loop/switch isn't completed */

                case 49: // '1'
                    s = "591";
                    continue; /* Loop/switch isn't completed */

                case 50: // '2'
                    s = "592";
                    continue; /* Loop/switch isn't completed */

                case 51: // '3'
                    s = "593";
                    continue; /* Loop/switch isn't completed */

                case 52: // '4'
                    s = "594";
                    continue; /* Loop/switch isn't completed */

                case 53: // '5'
                    s = "595";
                    continue; /* Loop/switch isn't completed */

                case 54: // '6'
                    s = "596";
                    continue; /* Loop/switch isn't completed */

                case 55: // '7'
                    s = "597";
                    continue; /* Loop/switch isn't completed */

                case 56: // '8'
                    s = "598";
                    continue; /* Loop/switch isn't completed */

                case 57: // '9'
                    s = "599";
                    continue; /* Loop/switch isn't completed */
                }
            break;
        }
        if(true) goto _L46; else goto _L68
_L68:
_L9:
        if(j <= 1) goto _L46; else goto _L69
_L69:
        switch(stringbuffer.charAt(i + 1)) {
        case 48: // '0'
            s = "60";
            continue; /* Loop/switch isn't completed */

        case 49: // '1'
            s = "61";
            continue; /* Loop/switch isn't completed */

        case 50: // '2'
            s = "62";
            continue; /* Loop/switch isn't completed */

        case 51: // '3'
            s = "63";
            continue; /* Loop/switch isn't completed */

        case 52: // '4'
            s = "64";
            continue; /* Loop/switch isn't completed */

        case 53: // '5'
            s = "65";
            continue; /* Loop/switch isn't completed */

        case 54: // '6'
            s = "66";
            continue; /* Loop/switch isn't completed */

        case 55: // '7'
            if(j > 2)
                switch(stringbuffer.charAt(i + 2)) {
                case 48: // '0'
                    s = "670";
                    continue; /* Loop/switch isn't completed */

                case 51: // '3'
                    s = "673";
                    continue; /* Loop/switch isn't completed */

                case 52: // '4'
                    s = "674";
                    continue; /* Loop/switch isn't completed */

                case 53: // '5'
                    s = "675";
                    continue; /* Loop/switch isn't completed */

                case 54: // '6'
                    s = "676";
                    continue; /* Loop/switch isn't completed */

                case 55: // '7'
                    s = "677";
                    continue; /* Loop/switch isn't completed */

                case 56: // '8'
                    s = "678";
                    continue; /* Loop/switch isn't completed */

                case 57: // '9'
                    s = "679";
                    continue; /* Loop/switch isn't completed */
                }
            break;

        case 56: // '8'
            if(j > 2)
                switch(stringbuffer.charAt(i + 2)) {
                case 48: // '0'
                    s = "680";
                    continue; /* Loop/switch isn't completed */

                case 49: // '1'
                    s = "681";
                    continue; /* Loop/switch isn't completed */

                case 50: // '2'
                    s = "682";
                    continue; /* Loop/switch isn't completed */

                case 51: // '3'
                    s = "683";
                    continue; /* Loop/switch isn't completed */

                case 53: // '5'
                    s = "685";
                    continue; /* Loop/switch isn't completed */

                case 54: // '6'
                    s = "686";
                    continue; /* Loop/switch isn't completed */

                case 55: // '7'
                    s = "687";
                    continue; /* Loop/switch isn't completed */

                case 56: // '8'
                    s = "688";
                    continue; /* Loop/switch isn't completed */

                case 57: // '9'
                    s = "689";
                    continue; /* Loop/switch isn't completed */
                }
            break;

        case 57: // '9'
            if(j > 2)
                switch(stringbuffer.charAt(i + 2)) {
                case 48: // '0'
                    s = "690";
                    continue; /* Loop/switch isn't completed */

                case 49: // '1'
                    s = "691";
                    continue; /* Loop/switch isn't completed */

                case 50: // '2'
                    s = "692";
                    continue; /* Loop/switch isn't completed */
                }
            break;
        }
        if(true) goto _L46; else goto _L70
_L70:
_L10:
        s = "7";
        continue; /* Loop/switch isn't completed */
_L11:
        if(j <= 1) goto _L46; else goto _L71
_L71:
        switch(stringbuffer.charAt(i + 1)) {
        case 49: // '1'
            s = "81";
            continue; /* Loop/switch isn't completed */

        case 50: // '2'
            s = "82";
            continue; /* Loop/switch isn't completed */

        case 52: // '4'
            s = "84";
            continue; /* Loop/switch isn't completed */

        case 53: // '5'
            if(j > 2)
                switch(stringbuffer.charAt(i + 2)) {
                case 48: // '0'
                    s = "850";
                    continue; /* Loop/switch isn't completed */

                case 50: // '2'
                    s = "852";
                    continue; /* Loop/switch isn't completed */

                case 51: // '3'
                    s = "853";
                    continue; /* Loop/switch isn't completed */

                case 53: // '5'
                    s = "855";
                    continue; /* Loop/switch isn't completed */

                case 54: // '6'
                    s = "856";
                    continue; /* Loop/switch isn't completed */
                }
            break;

        case 54: // '6'
            s = "86";
            continue; /* Loop/switch isn't completed */

        case 56: // '8'
            if(j > 2)
                switch(stringbuffer.charAt(i + 2)) {
                case 48: // '0'
                    s = "880";
                    continue; /* Loop/switch isn't completed */

                case 54: // '6'
                    s = "886";
                    continue; /* Loop/switch isn't completed */
                }
            break;
        }
        if(true) goto _L46; else goto _L72
_L72:
_L12:
        if(j <= 1) goto _L46; else goto _L73
_L73:
        switch(stringbuffer.charAt(i + 1)) {
        default:
            break;

        case 48: // '0'
            s = "90";
            break;

        case 49: // '1'
            s = "91";
            break;

        case 50: // '2'
            s = "92";
            break;

        case 51: // '3'
            s = "93";
            break;

        case 52: // '4'
            s = "94";
            break;

        case 53: // '5'
            s = "95";
            break;

        case 54: // '6'
            if(j <= 2)
                break;
            switch(stringbuffer.charAt(i + 2)) {
            default:
                break;

            case 48: // '0'
                s = "960";
                break;

            case 49: // '1'
                s = "961";
                break;

            case 50: // '2'
                s = "962";
                break;

            case 51: // '3'
                s = "963";
                break;

            case 52: // '4'
                s = "964";
                break;

            case 53: // '5'
                s = "965";
                break;

            case 54: // '6'
                s = "966";
                break;

            case 55: // '7'
                s = "967";
                break;

            case 56: // '8'
                s = "968";
                break;
            }
            break;

        case 55: // '7'
            if(j <= 2)
                break;
            switch(stringbuffer.charAt(i + 2)) {
            default:
                break;

            case 48: // '0'
                s = "970";
                break;

            case 49: // '1'
                s = "971";
                break;

            case 50: // '2'
                s = "972";
                break;

            case 51: // '3'
                s = "973";
                break;

            case 52: // '4'
                s = "974";
                break;

            case 53: // '5'
                s = "975";
                break;

            case 54: // '6'
                s = "976";
                break;

            case 55: // '7'
                s = "977";
                break;
            }
            break;

        case 56: // '8'
            s = "98";
            break;

        case 57: // '9'
            if(j <= 2)
                break;
            switch(stringbuffer.charAt(i + 2)) {
            case 55: // '7'
            default:
                break;

            case 50: // '2'
                s = "992";
                break;

            case 51: // '3'
                s = "993";
                break;

            case 52: // '4'
                s = "994";
                break;

            case 53: // '5'
                s = "995";
                break;

            case 54: // '6'
                s = "996";
                break;

            case 56: // '8'
                s = "998";
                break;
            }
            break;
        }
        if(true) goto _L46; else goto _L74
_L74:
        if(true) goto _L13; else goto _L75
_L75:
    }

    public static String toName(String s) {
        String s1 = (String)sNameMap.get(s);
        if(s1 == null)
            s1 = "";
        return s1;
    }

    private static void updateIcc() {
        String s = SystemProperties.get("gsm.sim.operator.numeric");
        if(!TextUtils.isEmpty(s) && s.length() >= 3 && !s.equals(ICC_OPERATOR)) {
            ICC_OPERATOR = s;
            ICC_COUNTRY_CODE = (String)sMccMap.get(s.substring(0, 3));
        }
    }

    private static void updateNetwork() {
        String s = SystemProperties.get("gsm.operator.numeric");
        if(!TextUtils.isEmpty(s) && s.length() >= 3 && !s.equals(NETWORK_OPERATOR)) {
            NETWORK_OPERATOR = s;
            String s1 = s.substring(0, 3);
            NETWORK_COUNTRY_CODE = (String)sMccMap.get(s1);
            NETWORK_IDD_CODE = (String)sMcc2Idd.get(s1);
            if(NETWORK_IDD_CODE == null)
                NETWORK_IDD_CODE = "00";
        }
    }

    public static final String AC = "247";
    public static final String AD = "376";
    public static final String AE = "971";
    public static final String AF = "93";
    public static final String AG = "1268";
    public static final String AI = "1264";
    public static final String AL = "355";
    public static final String AM = "374";
    public static final String AN = "599";
    public static final String AO = "244";
    public static final String AR = "54";
    public static final String AS = "1684";
    public static final String AT = "43";
    public static final String AU = "61";
    public static final String AW = "297";
    public static final String AZ = "994";
    public static final String BA = "387";
    public static final String BB = "1246";
    public static final String BD = "880";
    public static final String BE = "32";
    public static final String BF = "226";
    public static final String BG = "359";
    public static final String BH = "973";
    public static final String BI = "257";
    public static final String BJ = "229";
    public static final String BM = "1441";
    public static final String BN = "673";
    public static final String BO = "591";
    public static final String BR = "55";
    public static final String BS = "1242";
    public static final String BT = "975";
    public static final String BW = "267";
    public static final String BY = "375";
    public static final String BZ = "501";
    public static final String CD = "243";
    public static final String CF = "236";
    public static final String CG = "242";
    public static final String CH = "41";
    public static final String CI = "225";
    public static final String CK = "682";
    public static final String CL = "56";
    public static final String CM = "237";
    public static final String CN = "86";
    public static final String CO = "57";
    public static final String CR = "506";
    public static final String CU = "53";
    public static final String CV = "238";
    public static final String CY = "357";
    public static final String CZ = "420";
    public static final String DE = "49";
    private static final String DEFAULT_IDD_CODE = "00";
    public static final String DJ = "253";
    public static final String DK = "45";
    public static final String DM = "1767";
    public static final String DO = "1809";
    public static final String DO1 = "1829";
    public static final String DO2 = "1849";
    public static final String DZ = "213";
    public static final String EC = "593";
    public static final String EE = "372";
    public static final String EG = "20";
    private static final String EMPTY = "";
    public static final String ER = "291";
    public static final String ES = "34";
    public static final String ET = "251";
    public static final String FI = "358";
    public static final String FJ = "679";
    public static final String FK = "500";
    public static final String FM = "691";
    public static final String FO = "298";
    public static final String FR = "33";
    public static final String GA = "241";
    public static final String GD = "1473";
    public static final String GE = "995";
    public static final String GF = "594";
    public static final String GG = "441481";
    public static final String GG1 = "447781";
    public static final String GG2 = "447839";
    public static final String GG3 = "447911";
    public static final String GH = "233";
    public static final String GI = "350";
    public static final String GL = "299";
    public static final String GM = "220";
    public static final String GN = "224";
    public static final String GP_BL_MF = "590";
    public static final String GQ = "240";
    public static final String GR = "30";
    public static final String GSM_GENERAL_IDD_CODE = "+";
    public static final String GT = "502";
    public static final String GU = "1671";
    public static final String GW = "245";
    public static final String GY = "592";
    public static final String HK = "852";
    public static final String HN = "504";
    public static final String HR = "385";
    public static final String HT = "509";
    public static final String HU = "36";
    private static String ICC_COUNTRY_CODE = "";
    private static String ICC_OPERATOR = "";
    public static final String ID = "62";
    public static final String IE = "353";
    public static final String IL = "972";
    public static final String IM = "441624";
    public static final String IM1 = "447524";
    public static final String IM2 = "447624";
    public static final String IM3 = "447924";
    public static final String IN = "91";
    public static final String IO = "246";
    public static final String IQ = "964";
    public static final String IR = "98";
    public static final String IS = "354";
    public static final String IT = "39";
    public static final String JE = "441534";
    public static final String JE1 = "447509";
    public static final String JE2 = "447700";
    public static final String JE3 = "447797";
    public static final String JE4 = "447829";
    public static final String JM = "1876";
    public static final String JO = "962";
    public static final String JP = "81";
    public static final String KE = "254";
    public static final String KG = "996";
    public static final String KH = "855";
    public static final String KI = "686";
    public static final String KM = "269";
    public static final String KN = "1869";
    public static final String KP = "850";
    public static final String KR = "82";
    public static final String KW = "965";
    public static final String KY = "1345";
    public static final String LA = "856";
    public static final String LB = "961";
    public static final String LC = "1758";
    public static final String LI = "423";
    public static final String LK = "94";
    public static final String LR = "231";
    public static final String LS = "266";
    public static final String LT = "370";
    public static final String LU = "352";
    public static final String LV = "371";
    public static final String LY = "218";
    public static final String MA = "212";
    public static final String MC = "377";
    public static final String MD = "373";
    public static final String ME = "382";
    public static final String MG = "261";
    public static final String MH = "692";
    public static final String MK = "389";
    public static final String ML = "223";
    public static final String MM = "95";
    public static final String MN = "976";
    public static final String MO = "853";
    public static final String MP = "1670";
    public static final String MQ = "596";
    public static final String MR = "222";
    public static final String MS = "1664";
    public static final String MT = "356";
    public static final String MU = "230";
    public static final String MV = "960";
    public static final String MW = "265";
    public static final String MX = "52";
    public static final String MY = "60";
    public static final String MZ = "258";
    public static final String NA = "264";
    public static final String NC = "687";
    public static final String NE = "227";
    private static String NETWORK_COUNTRY_CODE = "";
    private static String NETWORK_IDD_CODE = "00";
    private static String NETWORK_OPERATOR = "";
    public static final String NG = "234";
    public static final String NI = "505";
    public static final String NL = "31";
    public static final String NO = "47";
    public static final String NP = "977";
    public static final String NR = "674";
    public static final String NU = "683";
    public static final String NZ = "64";
    public static final String OM = "968";
    public static final String PA = "507";
    public static final String PE = "51";
    public static final String PF = "689";
    public static final String PG = "675";
    public static final String PH = "63";
    public static final String PK = "92";
    public static final String PL = "48";
    public static final String PM = "508";
    public static final String PR = "1787";
    public static final String PR1 = "1939";
    public static final String PS = "970";
    public static final String PT = "351";
    public static final String PW = "680";
    public static final String PY = "595";
    public static final String QA = "974";
    public static final String RE_YT = "262";
    public static final String RO = "40";
    public static final String RS = "381";
    public static final String RU_KZ = "7";
    public static final String RW = "250";
    public static final String SA = "966";
    public static final String SB = "677";
    public static final String SC = "248";
    public static final String SD = "249";
    public static final String SE = "46";
    public static final String SG = "65";
    public static final String SH = "290";
    public static final String SI = "386";
    public static final String SK = "421";
    public static final String SL = "232";
    public static final String SM = "378";
    public static final String SN = "221";
    public static final String SO = "252";
    public static final String SR = "597";
    public static final String ST = "239";
    public static final String SV = "503";
    public static final String SX = "1721";
    public static final String SY = "963";
    public static final String SZ = "268";
    public static final String TC = "1649";
    public static final String TD = "235";
    public static final String TG = "228";
    public static final String TH = "66";
    public static final String TJ = "992";
    public static final String TK = "690";
    public static final String TL = "670";
    public static final String TM = "993";
    public static final String TN = "216";
    public static final String TO = "676";
    public static final String TR = "90";
    public static final String TT = "1868";
    public static final String TV = "688";
    public static final String TW = "886";
    public static final String TZ = "255";
    public static final String UA = "380";
    public static final String UG = "256";
    public static final String UK = "44";
    public static final String US_CA = "1";
    public static final String UY = "598";
    public static final String UZ = "998";
    public static final String VA = "3906698";
    public static final String VC = "1784";
    public static final String VE = "58";
    public static final String VG = "1284";
    public static final String VI = "1340";
    public static final String VN = "84";
    public static final String VU = "678";
    public static final String WF = "681";
    public static final String WS = "685";
    public static final String YE = "967";
    public static final String ZA = "27";
    public static final String ZM = "260";
    public static final String ZW = "263";
    private static final HashMap sMcc2Idd;
    private static final HashMap sMccMap;
    private static final HashMap sNameMap;

    static  {
        sNameMap = new HashMap();
        Resources resources = Resources.getSystem();
        sNameMap.put("1242", resources.getString(0x60c0084));
        sNameMap.put("1246", resources.getString(0x60c0085));
        sNameMap.put("1264", resources.getString(0x60c0086));
        sNameMap.put("1268", resources.getString(0x60c0087));
        sNameMap.put("1284", resources.getString(0x60c0088));
        sNameMap.put("1340", resources.getString(0x60c0089));
        sNameMap.put("1345", resources.getString(0x60c008a));
        sNameMap.put("1441", resources.getString(0x60c008b));
        sNameMap.put("1473", resources.getString(0x60c008c));
        sNameMap.put("1649", resources.getString(0x60c008d));
        sNameMap.put("1664", resources.getString(0x60c008e));
        sNameMap.put("1670", resources.getString(0x60c008f));
        sNameMap.put("1671", resources.getString(0x60c0090));
        sNameMap.put("1684", resources.getString(0x60c0091));
        sNameMap.put("1721", resources.getString(0x60c0092));
        sNameMap.put("1758", resources.getString(0x60c0093));
        sNameMap.put("1767", resources.getString(0x60c0094));
        sNameMap.put("1784", resources.getString(0x60c0095));
        sNameMap.put("1787", resources.getString(0x60c0096));
        sNameMap.put("1809", resources.getString(0x60c0097));
        sNameMap.put("1829", resources.getString(0x60c0097));
        sNameMap.put("1849", resources.getString(0x60c0097));
        sNameMap.put("1868", resources.getString(0x60c0098));
        sNameMap.put("1869", resources.getString(0x60c0099));
        sNameMap.put("1876", resources.getString(0x60c009a));
        sNameMap.put("1939", resources.getString(0x60c0096));
        sNameMap.put("1", resources.getString(0x60c009b));
        sNameMap.put("20", resources.getString(0x60c009c));
        sNameMap.put("212", resources.getString(0x60c009d));
        sNameMap.put("213", resources.getString(0x60c009e));
        sNameMap.put("216", resources.getString(0x60c009f));
        sNameMap.put("218", resources.getString(0x60c00a0));
        sNameMap.put("220", resources.getString(0x60c00a1));
        sNameMap.put("221", resources.getString(0x60c00a2));
        sNameMap.put("222", resources.getString(0x60c00a3));
        sNameMap.put("223", resources.getString(0x60c00a4));
        sNameMap.put("224", resources.getString(0x60c00a5));
        sNameMap.put("225", resources.getString(0x60c00a6));
        sNameMap.put("226", resources.getString(0x60c00a7));
        sNameMap.put("227", resources.getString(0x60c00a8));
        sNameMap.put("228", resources.getString(0x60c00a9));
        sNameMap.put("229", resources.getString(0x60c00aa));
        sNameMap.put("230", resources.getString(0x60c00ab));
        sNameMap.put("231", resources.getString(0x60c00ac));
        sNameMap.put("232", resources.getString(0x60c00ad));
        sNameMap.put("233", resources.getString(0x60c00ae));
        sNameMap.put("234", resources.getString(0x60c00af));
        sNameMap.put("235", resources.getString(0x60c00b0));
        sNameMap.put("236", resources.getString(0x60c00b1));
        sNameMap.put("237", resources.getString(0x60c00b2));
        sNameMap.put("238", resources.getString(0x60c00b3));
        sNameMap.put("239", resources.getString(0x60c00b4));
        sNameMap.put("240", resources.getString(0x60c00b5));
        sNameMap.put("241", resources.getString(0x60c00b6));
        sNameMap.put("242", resources.getString(0x60c00b7));
        sNameMap.put("243", resources.getString(0x60c00b8));
        sNameMap.put("244", resources.getString(0x60c00b9));
        sNameMap.put("245", resources.getString(0x60c00ba));
        sNameMap.put("246", resources.getString(0x60c00bb));
        sNameMap.put("247", resources.getString(0x60c00bc));
        sNameMap.put("248", resources.getString(0x60c00bd));
        sNameMap.put("249", resources.getString(0x60c00be));
        sNameMap.put("250", resources.getString(0x60c00bf));
        sNameMap.put("251", resources.getString(0x60c00c0));
        sNameMap.put("252", resources.getString(0x60c00c1));
        sNameMap.put("253", resources.getString(0x60c00c2));
        sNameMap.put("254", resources.getString(0x60c00c3));
        sNameMap.put("255", resources.getString(0x60c00c4));
        sNameMap.put("256", resources.getString(0x60c00c5));
        sNameMap.put("257", resources.getString(0x60c00c6));
        sNameMap.put("258", resources.getString(0x60c00c7));
        sNameMap.put("260", resources.getString(0x60c00c8));
        sNameMap.put("261", resources.getString(0x60c00c9));
        sNameMap.put("262", resources.getString(0x60c00ca));
        sNameMap.put("263", resources.getString(0x60c00cb));
        sNameMap.put("264", resources.getString(0x60c00cc));
        sNameMap.put("265", resources.getString(0x60c00cd));
        sNameMap.put("266", resources.getString(0x60c00ce));
        sNameMap.put("267", resources.getString(0x60c00cf));
        sNameMap.put("268", resources.getString(0x60c00d0));
        sNameMap.put("269", resources.getString(0x60c00d1));
        sNameMap.put("27", resources.getString(0x60c00d2));
        sNameMap.put("290", resources.getString(0x60c00d3));
        sNameMap.put("291", resources.getString(0x60c00d4));
        sNameMap.put("297", resources.getString(0x60c00d5));
        sNameMap.put("298", resources.getString(0x60c00d6));
        sNameMap.put("299", resources.getString(0x60c00d7));
        sNameMap.put("30", resources.getString(0x60c00d8));
        sNameMap.put("31", resources.getString(0x60c00d9));
        sNameMap.put("32", resources.getString(0x60c00da));
        sNameMap.put("33", resources.getString(0x60c00db));
        sNameMap.put("34", resources.getString(0x60c00dc));
        sNameMap.put("350", resources.getString(0x60c00dd));
        sNameMap.put("351", resources.getString(0x60c00de));
        sNameMap.put("352", resources.getString(0x60c00df));
        sNameMap.put("353", resources.getString(0x60c00e0));
        sNameMap.put("354", resources.getString(0x60c00e1));
        sNameMap.put("355", resources.getString(0x60c00e2));
        sNameMap.put("356", resources.getString(0x60c00e3));
        sNameMap.put("357", resources.getString(0x60c00e4));
        sNameMap.put("358", resources.getString(0x60c00e5));
        sNameMap.put("359", resources.getString(0x60c00e6));
        sNameMap.put("36", resources.getString(0x60c00e7));
        sNameMap.put("370", resources.getString(0x60c00e8));
        sNameMap.put("371", resources.getString(0x60c00e9));
        sNameMap.put("372", resources.getString(0x60c00ea));
        sNameMap.put("373", resources.getString(0x60c00eb));
        sNameMap.put("374", resources.getString(0x60c00ec));
        sNameMap.put("375", resources.getString(0x60c00ed));
        sNameMap.put("376", resources.getString(0x60c00ee));
        sNameMap.put("377", resources.getString(0x60c00ef));
        sNameMap.put("378", resources.getString(0x60c00f0));
        sNameMap.put("380", resources.getString(0x60c00f1));
        sNameMap.put("381", resources.getString(0x60c00f2));
        sNameMap.put("382", resources.getString(0x60c00f3));
        sNameMap.put("385", resources.getString(0x60c00f4));
        sNameMap.put("386", resources.getString(0x60c00f5));
        sNameMap.put("387", resources.getString(0x60c00f6));
        sNameMap.put("389", resources.getString(0x60c00f7));
        sNameMap.put("3906698", resources.getString(0x60c00f8));
        sNameMap.put("39", resources.getString(0x60c00f9));
        sNameMap.put("40", resources.getString(0x60c00fa));
        sNameMap.put("41", resources.getString(0x60c00fb));
        sNameMap.put("420", resources.getString(0x60c00fc));
        sNameMap.put("421", resources.getString(0x60c00fd));
        sNameMap.put("423", resources.getString(0x60c00fe));
        sNameMap.put("43", resources.getString(0x60c00ff));
        sNameMap.put("441481", resources.getString(0x60c0100));
        sNameMap.put("441534", resources.getString(0x60c0101));
        sNameMap.put("441624", resources.getString(0x60c0102));
        sNameMap.put("447509", resources.getString(0x60c0101));
        sNameMap.put("447524", resources.getString(0x60c0102));
        sNameMap.put("447624", resources.getString(0x60c0102));
        sNameMap.put("447700", resources.getString(0x60c0101));
        sNameMap.put("447781", resources.getString(0x60c0100));
        sNameMap.put("447797", resources.getString(0x60c0101));
        sNameMap.put("447829", resources.getString(0x60c0101));
        sNameMap.put("447839", resources.getString(0x60c0100));
        sNameMap.put("447911", resources.getString(0x60c0100));
        sNameMap.put("447924", resources.getString(0x60c0102));
        sNameMap.put("44", resources.getString(0x60c0103));
        sNameMap.put("45", resources.getString(0x60c0104));
        sNameMap.put("46", resources.getString(0x60c0105));
        sNameMap.put("47", resources.getString(0x60c0106));
        sNameMap.put("48", resources.getString(0x60c0107));
        sNameMap.put("49", resources.getString(0x60c0108));
        sNameMap.put("500", resources.getString(0x60c0109));
        sNameMap.put("501", resources.getString(0x60c010a));
        sNameMap.put("502", resources.getString(0x60c010b));
        sNameMap.put("503", resources.getString(0x60c010c));
        sNameMap.put("504", resources.getString(0x60c010d));
        sNameMap.put("505", resources.getString(0x60c010e));
        sNameMap.put("506", resources.getString(0x60c010f));
        sNameMap.put("507", resources.getString(0x60c0110));
        sNameMap.put("508", resources.getString(0x60c0111));
        sNameMap.put("509", resources.getString(0x60c0112));
        sNameMap.put("51", resources.getString(0x60c0113));
        sNameMap.put("52", resources.getString(0x60c0114));
        sNameMap.put("53", resources.getString(0x60c0115));
        sNameMap.put("54", resources.getString(0x60c0116));
        sNameMap.put("55", resources.getString(0x60c0117));
        sNameMap.put("56", resources.getString(0x60c0118));
        sNameMap.put("57", resources.getString(0x60c0119));
        sNameMap.put("58", resources.getString(0x60c011a));
        sNameMap.put("590", resources.getString(0x60c011b));
        sNameMap.put("591", resources.getString(0x60c011c));
        sNameMap.put("592", resources.getString(0x60c011d));
        sNameMap.put("593", resources.getString(0x60c011e));
        sNameMap.put("594", resources.getString(0x60c011f));
        sNameMap.put("595", resources.getString(0x60c0120));
        sNameMap.put("596", resources.getString(0x60c0121));
        sNameMap.put("597", resources.getString(0x60c0122));
        sNameMap.put("598", resources.getString(0x60c0123));
        sNameMap.put("599", resources.getString(0x60c0124));
        sNameMap.put("60", resources.getString(0x60c0125));
        sNameMap.put("61", resources.getString(0x60c0126));
        sNameMap.put("62", resources.getString(0x60c0127));
        sNameMap.put("63", resources.getString(0x60c0128));
        sNameMap.put("64", resources.getString(0x60c0129));
        sNameMap.put("65", resources.getString(0x60c012a));
        sNameMap.put("66", resources.getString(0x60c012b));
        sNameMap.put("670", resources.getString(0x60c012c));
        sNameMap.put("673", resources.getString(0x60c012d));
        sNameMap.put("674", resources.getString(0x60c012e));
        sNameMap.put("675", resources.getString(0x60c012f));
        sNameMap.put("676", resources.getString(0x60c0130));
        sNameMap.put("677", resources.getString(0x60c0131));
        sNameMap.put("678", resources.getString(0x60c0132));
        sNameMap.put("679", resources.getString(0x60c0133));
        sNameMap.put("680", resources.getString(0x60c0134));
        sNameMap.put("681", resources.getString(0x60c0135));
        sNameMap.put("682", resources.getString(0x60c0136));
        sNameMap.put("683", resources.getString(0x60c0137));
        sNameMap.put("685", resources.getString(0x60c0138));
        sNameMap.put("686", resources.getString(0x60c0139));
        sNameMap.put("687", resources.getString(0x60c013a));
        sNameMap.put("688", resources.getString(0x60c013b));
        sNameMap.put("689", resources.getString(0x60c013c));
        sNameMap.put("690", resources.getString(0x60c013d));
        sNameMap.put("691", resources.getString(0x60c013e));
        sNameMap.put("692", resources.getString(0x60c013f));
        sNameMap.put("7", resources.getString(0x60c0140));
        sNameMap.put("81", resources.getString(0x60c0141));
        sNameMap.put("82", resources.getString(0x60c0142));
        sNameMap.put("84", resources.getString(0x60c0143));
        sNameMap.put("850", resources.getString(0x60c0144));
        sNameMap.put("852", resources.getString(0x60c0145));
        sNameMap.put("853", resources.getString(0x60c0146));
        sNameMap.put("855", resources.getString(0x60c0147));
        sNameMap.put("856", resources.getString(0x60c0148));
        sNameMap.put("86", resources.getString(0x60c0149));
        sNameMap.put("880", resources.getString(0x60c014a));
        sNameMap.put("886", resources.getString(0x60c014b));
        sNameMap.put("90", resources.getString(0x60c014c));
        sNameMap.put("91", resources.getString(0x60c014d));
        sNameMap.put("92", resources.getString(0x60c014e));
        sNameMap.put("93", resources.getString(0x60c014f));
        sNameMap.put("94", resources.getString(0x60c0150));
        sNameMap.put("95", resources.getString(0x60c0151));
        sNameMap.put("960", resources.getString(0x60c0152));
        sNameMap.put("961", resources.getString(0x60c0153));
        sNameMap.put("962", resources.getString(0x60c0154));
        sNameMap.put("963", resources.getString(0x60c0155));
        sNameMap.put("964", resources.getString(0x60c0156));
        sNameMap.put("965", resources.getString(0x60c0157));
        sNameMap.put("966", resources.getString(0x60c0158));
        sNameMap.put("967", resources.getString(0x60c0159));
        sNameMap.put("968", resources.getString(0x60c015a));
        sNameMap.put("970", resources.getString(0x60c015b));
        sNameMap.put("971", resources.getString(0x60c015c));
        sNameMap.put("972", resources.getString(0x60c015d));
        sNameMap.put("973", resources.getString(0x60c015e));
        sNameMap.put("974", resources.getString(0x60c015f));
        sNameMap.put("975", resources.getString(0x60c0160));
        sNameMap.put("976", resources.getString(0x60c0161));
        sNameMap.put("977", resources.getString(0x60c0162));
        sNameMap.put("98", resources.getString(0x60c0163));
        sNameMap.put("992", resources.getString(0x60c0164));
        sNameMap.put("993", resources.getString(0x60c0165));
        sNameMap.put("994", resources.getString(0x60c0166));
        sNameMap.put("995", resources.getString(0x60c0167));
        sNameMap.put("996", resources.getString(0x60c0168));
        sNameMap.put("998", resources.getString(0x60c0169));
        sMccMap = new HashMap();
        sMccMap.put("412", "93");
        sMccMap.put("276", "355");
        sMccMap.put("603", "213");
        sMccMap.put("544", "1684");
        sMccMap.put("213", "376");
        sMccMap.put("631", "244");
        sMccMap.put("365", "1264");
        sMccMap.put("344", "1268");
        sMccMap.put("722", "54");
        sMccMap.put("283", "374");
        sMccMap.put("363", "297");
        sMccMap.put("505", "61");
        sMccMap.put("232", "43");
        sMccMap.put("400", "994");
        sMccMap.put("364", "1242");
        sMccMap.put("426", "973");
        sMccMap.put("470", "880");
        sMccMap.put("342", "1246");
        sMccMap.put("257", "375");
        sMccMap.put("206", "32");
        sMccMap.put("702", "501");
        sMccMap.put("616", "229");
        sMccMap.put("350", "1441");
        sMccMap.put("402", "975");
        sMccMap.put("736", "591");
        sMccMap.put("218", "387");
        sMccMap.put("652", "267");
        sMccMap.put("724", "55");
        sMccMap.put("348", "1284");
        sMccMap.put("528", "673");
        sMccMap.put("284", "359");
        sMccMap.put("613", "226");
        sMccMap.put("642", "257");
        sMccMap.put("456", "855");
        sMccMap.put("624", "237");
        sMccMap.put("302", "1");
        sMccMap.put("625", "238");
        sMccMap.put("346", "1345");
        sMccMap.put("623", "236");
        sMccMap.put("622", "235");
        sMccMap.put("730", "56");
        sMccMap.put("460", "86");
        sMccMap.put("732", "57");
        sMccMap.put("654", "269");
        sMccMap.put("548", "682");
        sMccMap.put("712", "506");
        sMccMap.put("612", "225");
        sMccMap.put("219", "385");
        sMccMap.put("368", "53");
        sMccMap.put("280", "357");
        sMccMap.put("230", "420");
        sMccMap.put("630", "243");
        sMccMap.put("238", "45");
        sMccMap.put("638", "253");
        sMccMap.put("366", "1767");
        sMccMap.put("370", "1809");
        sMccMap.put("740", "593");
        sMccMap.put("602", "20");
        sMccMap.put("706", "503");
        sMccMap.put("627", "240");
        sMccMap.put("657", "291");
        sMccMap.put("248", "372");
        sMccMap.put("636", "251");
        sMccMap.put("750", "500");
        sMccMap.put("288", "298");
        sMccMap.put("542", "679");
        sMccMap.put("244", "358");
        sMccMap.put("208", "33");
        sMccMap.put("742", "594");
        sMccMap.put("547", "689");
        sMccMap.put("628", "241");
        sMccMap.put("607", "220");
        sMccMap.put("282", "995");
        sMccMap.put("262", "49");
        sMccMap.put("620", "233");
        sMccMap.put("266", "350");
        sMccMap.put("202", "30");
        sMccMap.put("290", "299");
        sMccMap.put("352", "1473");
        sMccMap.put("535", "1671");
        sMccMap.put("704", "502");
        sMccMap.put("611", "224");
        sMccMap.put("632", "245");
        sMccMap.put("738", "592");
        sMccMap.put("372", "509");
        sMccMap.put("708", "504");
        sMccMap.put("454", "852");
        sMccMap.put("216", "36");
        sMccMap.put("274", "354");
        sMccMap.put("404", "91");
        sMccMap.put("405", "91");
        sMccMap.put("510", "62");
        sMccMap.put("432", "98");
        sMccMap.put("418", "964");
        sMccMap.put("272", "353");
        sMccMap.put("425", "972");
        sMccMap.put("222", "39");
        sMccMap.put("338", "1876");
        sMccMap.put("440", "81");
        sMccMap.put("441", "81");
        sMccMap.put("416", "962");
        sMccMap.put("401", "7");
        sMccMap.put("639", "254");
        sMccMap.put("545", "686");
        sMccMap.put("467", "850");
        sMccMap.put("450", "82");
        sMccMap.put("419", "965");
        sMccMap.put("437", "996");
        sMccMap.put("457", "856");
        sMccMap.put("247", "371");
        sMccMap.put("415", "961");
        sMccMap.put("651", "266");
        sMccMap.put("618", "231");
        sMccMap.put("606", "218");
        sMccMap.put("295", "423");
        sMccMap.put("246", "370");
        sMccMap.put("270", "352");
        sMccMap.put("455", "853");
        sMccMap.put("294", "389");
        sMccMap.put("646", "261");
        sMccMap.put("650", "265");
        sMccMap.put("502", "60");
        sMccMap.put("472", "960");
        sMccMap.put("610", "223");
        sMccMap.put("278", "356");
        sMccMap.put("551", "692");
        sMccMap.put("340", "596");
        sMccMap.put("609", "222");
        sMccMap.put("617", "230");
        sMccMap.put("334", "52");
        sMccMap.put("550", "691");
        sMccMap.put("259", "373");
        sMccMap.put("212", "377");
        sMccMap.put("428", "976");
        sMccMap.put("297", "382");
        sMccMap.put("354", "1664");
        sMccMap.put("604", "212");
        sMccMap.put("643", "258");
        sMccMap.put("414", "95");
        sMccMap.put("649", "264");
        sMccMap.put("536", "674");
        sMccMap.put("429", "977");
        sMccMap.put("204", "31");
        sMccMap.put("362", "599");
        sMccMap.put("546", "687");
        sMccMap.put("530", "64");
        sMccMap.put("710", "505");
        sMccMap.put("614", "227");
        sMccMap.put("621", "234");
        sMccMap.put("534", "1670");
        sMccMap.put("242", "47");
        sMccMap.put("422", "968");
        sMccMap.put("410", "92");
        sMccMap.put("552", "680");
        sMccMap.put("423", "970");
        sMccMap.put("714", "507");
        sMccMap.put("537", "675");
        sMccMap.put("744", "595");
        sMccMap.put("716", "51");
        sMccMap.put("515", "63");
        sMccMap.put("260", "48");
        sMccMap.put("268", "351");
        sMccMap.put("330", "1787");
        sMccMap.put("427", "974");
        sMccMap.put("629", "242");
        sMccMap.put("647", "262");
        sMccMap.put("226", "40");
        sMccMap.put("250", "7");
        sMccMap.put("635", "250");
        sMccMap.put("356", "1869");
        sMccMap.put("358", "1758");
        sMccMap.put("308", "508");
        sMccMap.put("360", "1784");
        sMccMap.put("549", "685");
        sMccMap.put("292", "378");
        sMccMap.put("626", "239");
        sMccMap.put("420", "966");
        sMccMap.put("608", "221");
        sMccMap.put("220", "381");
        sMccMap.put("633", "248");
        sMccMap.put("619", "232");
        sMccMap.put("525", "65");
        sMccMap.put("231", "421");
        sMccMap.put("293", "386");
        sMccMap.put("540", "677");
        sMccMap.put("637", "252");
        sMccMap.put("655", "27");
        sMccMap.put("214", "34");
        sMccMap.put("413", "94");
        sMccMap.put("634", "249");
        sMccMap.put("746", "597");
        sMccMap.put("653", "268");
        sMccMap.put("240", "46");
        sMccMap.put("228", "41");
        sMccMap.put("417", "963");
        sMccMap.put("466", "886");
        sMccMap.put("436", "992");
        sMccMap.put("640", "255");
        sMccMap.put("520", "66");
        sMccMap.put("514", "64");
        sMccMap.put("615", "228");
        sMccMap.put("539", "676");
        sMccMap.put("374", "1868");
        sMccMap.put("605", "216");
        sMccMap.put("286", "90");
        sMccMap.put("438", "993");
        sMccMap.put("376", "1649");
        sMccMap.put("641", "256");
        sMccMap.put("234", "44");
        sMccMap.put("235", "44");
        sMccMap.put("255", "380");
        sMccMap.put("424", "971");
        sMccMap.put("430", "971");
        sMccMap.put("431", "971");
        sMccMap.put("310", "1");
        sMccMap.put("316", "1");
        sMccMap.put("311", "1");
        sMccMap.put("748", "598");
        sMccMap.put("332", "1340");
        sMccMap.put("434", "998");
        sMccMap.put("541", "678");
        sMccMap.put("225", "3906698");
        sMccMap.put("734", "58");
        sMccMap.put("452", "84");
        sMccMap.put("543", "681");
        sMccMap.put("421", "967");
        sMccMap.put("645", "260");
        sMccMap.put("648", "263");
        sMcc2Idd = new HashMap();
        sMcc2Idd.put("302", "011");
        sMcc2Idd.put("310", "011");
        sMcc2Idd.put("311", "011");
        sMcc2Idd.put("316", "011");
        sMcc2Idd.put("334", "00");
        sMcc2Idd.put("404", "00");
        sMcc2Idd.put("405", "00");
        sMcc2Idd.put("425", "00");
        sMcc2Idd.put("428", "002");
        sMcc2Idd.put("440", "010");
        sMcc2Idd.put("441", "010");
        sMcc2Idd.put("450", "00700");
        sMcc2Idd.put("452", "00");
        sMcc2Idd.put("454", "001");
        sMcc2Idd.put("455", "00");
        sMcc2Idd.put("460", "00");
        sMcc2Idd.put("466", "005");
        sMcc2Idd.put("470", "00");
        sMcc2Idd.put("510", "001");
        sMcc2Idd.put("530", "00");
        sMcc2Idd.put("535", "011");
        sMcc2Idd.put("520", "001");
        sMcc2Idd.put("724", "00");
    }
}
