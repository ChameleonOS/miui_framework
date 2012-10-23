// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cdma.sms;

import android.util.SparseBooleanArray;
import com.android.internal.telephony.SmsAddress;
import com.android.internal.util.HexDump;

// Referenced classes of package com.android.internal.telephony.cdma.sms:
//            UserData

public class CdmaSmsAddress extends SmsAddress {

    public CdmaSmsAddress() {
    }

    private static String filterNumericSugar(String s) {
        StringBuilder stringbuilder;
        int i;
        int j;
        stringbuilder = new StringBuilder();
        i = s.length();
        j = 0;
_L3:
        char c;
        int k;
        if(j >= i)
            break MISSING_BLOCK_LABEL_75;
        c = s.charAt(j);
        k = numericCharDialableMap.indexOfKey(c);
        if(k >= 0) goto _L2; else goto _L1
_L1:
        String s1 = null;
_L4:
        return s1;
_L2:
        if(numericCharDialableMap.valueAt(k))
            stringbuilder.append(c);
        j++;
          goto _L3
        s1 = stringbuilder.toString();
          goto _L4
    }

    private static String filterWhitespace(String s) {
        StringBuilder stringbuilder = new StringBuilder();
        int i = s.length();
        int j = 0;
        while(j < i)  {
            char c = s.charAt(j);
            if(c != ' ' && c != '\r' && c != '\n' && c != '\t')
                stringbuilder.append(c);
            j++;
        }
        return stringbuilder.toString();
    }

    public static CdmaSmsAddress parse(String s) {
        CdmaSmsAddress cdmasmsaddress;
        byte abyte0[];
        cdmasmsaddress = new CdmaSmsAddress();
        cdmasmsaddress.address = s;
        cdmasmsaddress.ton = 0;
        abyte0 = null;
        String s1 = filterNumericSugar(s);
        if(s1 != null)
            abyte0 = parseToDtmf(s1);
        if(abyte0 == null) goto _L2; else goto _L1
_L1:
        cdmasmsaddress.digitMode = 0;
        cdmasmsaddress.numberMode = 0;
        if(s.indexOf('+') != -1)
            cdmasmsaddress.ton = 1;
_L6:
        cdmasmsaddress.origBytes = abyte0;
        cdmasmsaddress.numberOfDigits = abyte0.length;
_L4:
        return cdmasmsaddress;
_L2:
        abyte0 = UserData.stringToAscii(filterWhitespace(s));
        if(abyte0 != null)
            break; /* Loop/switch isn't completed */
        cdmasmsaddress = null;
        if(true) goto _L4; else goto _L3
_L3:
        cdmasmsaddress.digitMode = 1;
        cdmasmsaddress.numberMode = 1;
        if(s.indexOf('@') != -1)
            cdmasmsaddress.ton = 2;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private static byte[] parseToDtmf(String s) {
        int i;
        byte abyte0[];
        int j;
        i = s.length();
        abyte0 = new byte[i];
        j = 0;
_L2:
        char c;
        int k;
        if(j >= i)
            break MISSING_BLOCK_LABEL_100;
        c = s.charAt(j);
        if(c < '1' || c > '9')
            break; /* Loop/switch isn't completed */
        k = c + -48;
_L3:
        abyte0[j] = (byte)k;
        j++;
        if(true) goto _L2; else goto _L1
_L1:
        if(c == '0')
            k = 10;
        else
        if(c == '*') {
            k = 11;
        } else {
label0:
            {
                if(c != '#')
                    break label0;
                k = 12;
            }
        }
          goto _L3
        if(true) goto _L2; else goto _L4
_L4:
        abyte0 = null;
        return abyte0;
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("CdmaSmsAddress ");
        stringbuilder.append((new StringBuilder()).append("{ digitMode=").append(digitMode).toString());
        stringbuilder.append((new StringBuilder()).append(", numberMode=").append(numberMode).toString());
        stringbuilder.append((new StringBuilder()).append(", numberPlan=").append(numberPlan).toString());
        stringbuilder.append((new StringBuilder()).append(", numberOfDigits=").append(numberOfDigits).toString());
        stringbuilder.append((new StringBuilder()).append(", ton=").append(super.ton).toString());
        stringbuilder.append((new StringBuilder()).append(", address=\"").append(super.address).append("\"").toString());
        stringbuilder.append((new StringBuilder()).append(", origBytes=").append(HexDump.toHexString(super.origBytes)).toString());
        stringbuilder.append(" }");
        return stringbuilder.toString();
    }

    public static final int DIGIT_MODE_4BIT_DTMF = 0;
    public static final int DIGIT_MODE_8BIT_CHAR = 1;
    public static final int NUMBERING_PLAN_ISDN_TELEPHONY = 1;
    public static final int NUMBERING_PLAN_UNKNOWN = 0;
    public static final int NUMBER_MODE_DATA_NETWORK = 1;
    public static final int NUMBER_MODE_NOT_DATA_NETWORK = 0;
    public static final int SMS_ADDRESS_MAX = 36;
    public static final int SMS_SUBADDRESS_MAX = 36;
    public static final int TON_ABBREVIATED = 6;
    public static final int TON_ALPHANUMERIC = 5;
    public static final int TON_INTERNATIONAL_OR_IP = 1;
    public static final int TON_NATIONAL_OR_EMAIL = 2;
    public static final int TON_NETWORK = 3;
    public static final int TON_RESERVED = 7;
    public static final int TON_SUBSCRIBER = 4;
    public static final int TON_UNKNOWN;
    private static final SparseBooleanArray numericCharDialableMap;
    private static final char numericCharsDialable[];
    private static final char numericCharsSugar[];
    public int digitMode;
    public int numberMode;
    public int numberOfDigits;
    public int numberPlan;

    static  {
        char ac[] = new char[12];
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
        ac[10] = '*';
        ac[11] = '#';
        numericCharsDialable = ac;
        char ac1[] = new char[8];
        ac1[0] = '(';
        ac1[1] = ')';
        ac1[2] = ' ';
        ac1[3] = '-';
        ac1[4] = '+';
        ac1[5] = '.';
        ac1[6] = '/';
        ac1[7] = '\\';
        numericCharsSugar = ac1;
        numericCharDialableMap = new SparseBooleanArray(numericCharsDialable.length + numericCharsSugar.length);
        for(int i = 0; i < numericCharsDialable.length; i++)
            numericCharDialableMap.put(numericCharsDialable[i], true);

        for(int j = 0; j < numericCharsSugar.length; j++)
            numericCharDialableMap.put(numericCharsSugar[j], false);

    }
}
