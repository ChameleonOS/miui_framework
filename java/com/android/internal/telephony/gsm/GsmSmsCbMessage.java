// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.gsm;

import android.telephony.SmsCbLocation;
import android.telephony.SmsCbMessage;
import android.util.Pair;
import com.android.internal.telephony.GsmAlphabet;
import java.io.UnsupportedEncodingException;

// Referenced classes of package com.android.internal.telephony.gsm:
//            SmsCbHeader

public class GsmSmsCbMessage {

    private GsmSmsCbMessage() {
    }

    public static SmsCbMessage createSmsCbMessage(SmsCbLocation smscblocation, byte abyte0[][]) throws IllegalArgumentException {
        return createSmsCbMessage(new SmsCbHeader(abyte0[0]), smscblocation, abyte0);
    }

    static SmsCbMessage createSmsCbMessage(SmsCbHeader smscbheader, SmsCbLocation smscblocation, byte abyte0[][]) throws IllegalArgumentException {
        SmsCbMessage smscbmessage;
        if(smscbheader.isEtwsPrimaryNotification()) {
            smscbmessage = new SmsCbMessage(1, smscbheader.getGeographicalScope(), smscbheader.getSerialNumber(), smscblocation, smscbheader.getServiceCategory(), null, "ETWS", 3, smscbheader.getEtwsInfo(), smscbheader.getCmasInfo());
        } else {
            String s = null;
            StringBuilder stringbuilder = new StringBuilder();
            int i = abyte0.length;
            for(int j = 0; j < i; j++) {
                Pair pair = parseBody(smscbheader, abyte0[j]);
                s = (String)pair.first;
                stringbuilder.append((String)pair.second);
            }

            byte byte0;
            if(smscbheader.isEmergencyMessage())
                byte0 = 3;
            else
                byte0 = 0;
            smscbmessage = new SmsCbMessage(1, smscbheader.getGeographicalScope(), smscbheader.getSerialNumber(), smscblocation, smscbheader.getServiceCategory(), s, stringbuilder.toString(), byte0, smscbheader.getEtwsInfo(), smscbheader.getCmasInfo());
        }
        return smscbmessage;
    }

    private static Pair parseBody(SmsCbHeader smscbheader, byte abyte0[]) {
        String s;
        boolean flag;
        byte byte0;
        s = null;
        flag = false;
        int i = smscbheader.getDataCodingScheme();
        switch((i & 0xf0) >> 4) {
        case 8: // '\b'
        case 10: // '\n'
        case 11: // '\013'
        case 12: // '\f'
        case 13: // '\r'
        default:
            byte0 = 1;
            break MISSING_BLOCK_LABEL_99;

        case 0: // '\0'
            byte0 = 1;
            s = LANGUAGE_CODES_GROUP_0[i & 0xf];
            break;

        case 1: // '\001'
            flag = true;
            if((i & 0xf) == 1)
                byte0 = 3;
            else
                byte0 = 1;
            break;

        case 2: // '\002'
            byte0 = 1;
            s = LANGUAGE_CODES_GROUP_2[i & 0xf];
            break;

        case 3: // '\003'
            byte0 = 1;
            break;

        case 4: // '\004'
        case 5: // '\005'
            switch((i & 0xc) >> 2) {
            default:
                byte0 = 1;
                break;

            case 1: // '\001'
                byte0 = 2;
                break;

            case 2: // '\002'
                byte0 = 3;
                break;
            }
            if(false)
                ;
            break;

        case 6: // '\006'
        case 7: // '\007'
        case 9: // '\t'
        case 14: // '\016'
            throw new IllegalArgumentException((new StringBuilder()).append("Unsupported GSM dataCodingScheme ").append(i).toString());

        case 15: // '\017'
            if((i & 4) >> 2 == 1)
                byte0 = 2;
            else
                byte0 = 1;
            break;
        }
        if(true) goto _L2; else goto _L1
_L2:
        Pair pair;
        if(!smscbheader.isUmtsFormat())
            break; /* Loop/switch isn't completed */
        byte byte1 = abyte0[6];
        if(abyte0.length < 7 + byte1 * 83)
            throw new IllegalArgumentException((new StringBuilder()).append("Pdu length ").append(abyte0.length).append(" does not match ").append(byte1).append(" pages").toString());
        StringBuilder stringbuilder = new StringBuilder();
        for(int j = 0; j < byte1; j++) {
            int k = 7 + j * 83;
            byte byte2 = abyte0[k + 82];
            if(byte2 > 82)
                throw new IllegalArgumentException((new StringBuilder()).append("Page length ").append(byte2).append(" exceeds maximum value ").append(82).toString());
            Pair pair1 = unpackBody(abyte0, byte0, k, byte2, flag, s);
            s = (String)pair1.first;
            stringbuilder.append((String)pair1.second);
        }

        pair = new Pair(s, stringbuilder.toString());
_L4:
        return pair;
_L1:
        pair = unpackBody(abyte0, byte0, 6, abyte0.length - 6, flag, s);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static Pair unpackBody(byte abyte0[], int i, int j, int k, boolean flag, String s) {
        String s1 = null;
        i;
        JVM INSTR tableswitch 1 3: default 32
    //                   1 88
    //                   2 32
    //                   3 141;
           goto _L1 _L2 _L1 _L3
_L1:
        if(s1 == null) goto _L5; else goto _L4
_L4:
        int l = -1 + s1.length();
_L10:
        if(l < 0) goto _L7; else goto _L6
_L6:
        if(s1.charAt(l) == '\r') goto _L9; else goto _L8
_L8:
        s1 = s1.substring(0, l + 1);
_L7:
        return new Pair(s, s1);
_L2:
        s1 = GsmAlphabet.gsm7BitPackedToString(abyte0, j, (k * 8) / 7);
        if(flag && s1 != null && s1.length() > 2) {
            s = s1.substring(0, 2);
            s1 = s1.substring(3);
        }
          goto _L1
_L3:
        if(flag && abyte0.length >= j + 2) {
            s = GsmAlphabet.gsm7BitPackedToString(abyte0, j, 2);
            j += 2;
            k -= 2;
        }
        try {
            s1 = new String(abyte0, j, 0xfffe & k, "utf-16");
        }
        catch(UnsupportedEncodingException unsupportedencodingexception) {
            throw new IllegalArgumentException("Error decoding UTF-16 message", unsupportedencodingexception);
        }
          goto _L1
_L9:
        l--;
          goto _L10
_L5:
        s1 = "";
          goto _L7
    }

    private static final char CARRIAGE_RETURN = 13;
    private static final String LANGUAGE_CODES_GROUP_0[];
    private static final String LANGUAGE_CODES_GROUP_2[];
    private static final int PDU_BODY_PAGE_LENGTH = 82;

    static  {
        String as[] = new String[16];
        as[0] = "de";
        as[1] = "en";
        as[2] = "it";
        as[3] = "fr";
        as[4] = "es";
        as[5] = "nl";
        as[6] = "sv";
        as[7] = "da";
        as[8] = "pt";
        as[9] = "fi";
        as[10] = "no";
        as[11] = "el";
        as[12] = "tr";
        as[13] = "hu";
        as[14] = "pl";
        as[15] = null;
        LANGUAGE_CODES_GROUP_0 = as;
        String as1[] = new String[16];
        as1[0] = "cs";
        as1[1] = "he";
        as1[2] = "ar";
        as1[3] = "ru";
        as1[4] = "is";
        as1[5] = null;
        as1[6] = null;
        as1[7] = null;
        as1[8] = null;
        as1[9] = null;
        as1[10] = null;
        as1[11] = null;
        as1[12] = null;
        as1[13] = null;
        as1[14] = null;
        as1[15] = null;
        LANGUAGE_CODES_GROUP_2 = as1;
    }
}
