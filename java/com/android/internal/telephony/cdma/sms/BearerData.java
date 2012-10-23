// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cdma.sms;

import android.content.res.Resources;
import android.telephony.SmsCbCmasInfo;
import android.telephony.cdma.CdmaSmsCbProgramData;
import android.telephony.cdma.CdmaSmsCbProgramResults;
import android.text.format.Time;
import android.util.Log;
import android.util.SparseIntArray;
import com.android.internal.telephony.*;
import com.android.internal.telephony.gsm.SmsMessage;
import com.android.internal.util.BitwiseInputStream;
import com.android.internal.util.BitwiseOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

// Referenced classes of package com.android.internal.telephony.cdma.sms:
//            UserData, CdmaSmsAddress

public final class BearerData {
    private static class Gsm7bitCodingResult {

        byte data[];
        int septets;

        private Gsm7bitCodingResult() {
        }

    }

    private static class CodingException extends Exception {

        public CodingException(String s) {
            super(s);
        }
    }

    public static class TimeStamp extends Time {

        public static TimeStamp fromByteArray(byte abyte0[]) {
            TimeStamp timestamp = new TimeStamp();
            int i = IccUtils.cdmaBcdByteToInt(abyte0[0]);
            if(i > 99 || i < 0) {
                timestamp = null;
            } else {
                int j;
                int k;
                if(i >= 96)
                    j = i + 1900;
                else
                    j = i + 2000;
                timestamp.year = j;
                k = IccUtils.cdmaBcdByteToInt(abyte0[1]);
                if(k < 1 || k > 12) {
                    timestamp = null;
                } else {
                    timestamp.month = k - 1;
                    int l = IccUtils.cdmaBcdByteToInt(abyte0[2]);
                    if(l < 1 || l > 31) {
                        timestamp = null;
                    } else {
                        timestamp.monthDay = l;
                        int i1 = IccUtils.cdmaBcdByteToInt(abyte0[3]);
                        if(i1 < 0 || i1 > 23) {
                            timestamp = null;
                        } else {
                            timestamp.hour = i1;
                            int j1 = IccUtils.cdmaBcdByteToInt(abyte0[4]);
                            if(j1 < 0 || j1 > 59) {
                                timestamp = null;
                            } else {
                                timestamp.minute = j1;
                                int k1 = IccUtils.cdmaBcdByteToInt(abyte0[5]);
                                if(k1 < 0 || k1 > 59)
                                    timestamp = null;
                                else
                                    timestamp.second = k1;
                            }
                        }
                    }
                }
            }
            return timestamp;
        }

        public String toString() {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("TimeStamp ");
            stringbuilder.append((new StringBuilder()).append("{ year=").append(super.year).toString());
            stringbuilder.append((new StringBuilder()).append(", month=").append(super.month).toString());
            stringbuilder.append((new StringBuilder()).append(", day=").append(super.monthDay).toString());
            stringbuilder.append((new StringBuilder()).append(", hour=").append(super.hour).toString());
            stringbuilder.append((new StringBuilder()).append(", minute=").append(super.minute).toString());
            stringbuilder.append((new StringBuilder()).append(", second=").append(super.second).toString());
            stringbuilder.append(" }");
            return stringbuilder.toString();
        }

        public TimeStamp() {
            super(TimeZone.getDefault().getID());
        }
    }


    public BearerData() {
        priorityIndicatorSet = false;
        priority = 0;
        privacyIndicatorSet = false;
        privacy = 0;
        alertIndicatorSet = false;
        alert = 0;
        displayModeSet = false;
        displayMode = 1;
        languageIndicatorSet = false;
        language = 0;
        messageStatusSet = false;
        errorClass = 255;
        messageStatus = 255;
        userResponseCodeSet = false;
    }

    public static com.android.internal.telephony.SmsMessageBase.TextEncodingDetails calcTextEncodingDetails(CharSequence charsequence, boolean flag) {
        int i = countAsciiSeptets(charsequence, flag);
        if(i == -1 || i > 160) goto _L2; else goto _L1
_L1:
        com.android.internal.telephony.SmsMessageBase.TextEncodingDetails textencodingdetails;
        textencodingdetails = new com.android.internal.telephony.SmsMessageBase.TextEncodingDetails();
        textencodingdetails.msgCount = 1;
        textencodingdetails.codeUnitCount = i;
        textencodingdetails.codeUnitsRemaining = 160 - i;
        textencodingdetails.codeUnitSize = 1;
_L4:
        return textencodingdetails;
_L2:
        textencodingdetails = SmsMessage.calculateLength(charsequence, flag);
        if(textencodingdetails.msgCount == 1 && textencodingdetails.codeUnitSize == 1) {
            textencodingdetails.codeUnitCount = charsequence.length();
            int j = 2 * textencodingdetails.codeUnitCount;
            if(j > 140) {
                textencodingdetails.msgCount = (j + 133) / 134;
                textencodingdetails.codeUnitsRemaining = (134 * textencodingdetails.msgCount - j) / 2;
            } else {
                textencodingdetails.msgCount = 1;
                textencodingdetails.codeUnitsRemaining = (140 - j) / 2;
            }
            textencodingdetails.codeUnitSize = 3;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static int countAsciiSeptets(CharSequence charsequence, boolean flag) {
        int i = charsequence.length();
        if(!flag) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        int j = 0;
        do {
            if(j < i) {
label0:
                {
                    if(UserData.charToAscii.get(charsequence.charAt(j), -1) != -1)
                        break label0;
                    i = -1;
                }
            }
            if(true)
                continue;
            j++;
        } while(true);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static BearerData decode(byte abyte0[]) {
        return decode(abyte0, 0);
    }

    public static BearerData decode(byte abyte0[], int i) {
        BitwiseInputStream bitwiseinputstream;
        BearerData bearerdata;
        int j;
        bitwiseinputstream = new BitwiseInputStream(abyte0);
        bearerdata = new BearerData();
        j = 0;
_L27:
        if(bitwiseinputstream.available() <= 0) goto _L2; else goto _L1
_L1:
        com.android.internal.util.BitwiseInputStream.AccessException accessexception;
        int k;
        int l;
        k = bitwiseinputstream.read(8);
        l = 1 << k;
        if((j & l) != 0)
            throw new CodingException((new StringBuilder()).append("illegal duplicate subparameter (").append(k).append(")").toString());
          goto _L3
_L4:
        try {
            throw new CodingException((new StringBuilder()).append("unsupported bearer data subparameter (").append(k).append(")").toString());
        }
        // Misplaced declaration of an exception variable
        catch(com.android.internal.util.BitwiseInputStream.AccessException accessexception) {
            Log.e("SMS", (new StringBuilder()).append("BearerData decode failed: ").append(accessexception).toString());
        }
        catch(CodingException codingexception) {
            Log.e("SMS", (new StringBuilder()).append("BearerData decode failed: ").append(codingexception).toString());
        }
        bearerdata = null;
_L25:
        return bearerdata;
_L3:
        k;
        JVM INSTR tableswitch 0 20: default 216
    //                   0 283
    //                   1 293
    //                   2 303
    //                   3 353
    //                   4 363
    //                   5 373
    //                   6 383
    //                   7 393
    //                   8 433
    //                   9 403
    //                   10 313
    //                   11 323
    //                   12 443
    //                   13 413
    //                   14 333
    //                   15 423
    //                   16 216
    //                   17 453
    //                   18 463
    //                   19 216
    //                   20 343;
           goto _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L4 _L21 _L22 _L4 _L23
_L5:
        boolean flag = decodeMessageId(bearerdata, bitwiseinputstream);
          goto _L24
_L6:
        flag = decodeUserData(bearerdata, bitwiseinputstream);
          goto _L24
_L7:
        flag = decodeUserResponseCode(bearerdata, bitwiseinputstream);
          goto _L24
_L15:
        flag = decodeReplyOption(bearerdata, bitwiseinputstream);
          goto _L24
_L16:
        flag = decodeMsgCount(bearerdata, bitwiseinputstream);
          goto _L24
_L19:
        flag = decodeCallbackNumber(bearerdata, bitwiseinputstream);
          goto _L24
_L23:
        flag = decodeMsgStatus(bearerdata, bitwiseinputstream);
          goto _L24
_L8:
        flag = decodeMsgCenterTimeStamp(bearerdata, bitwiseinputstream);
          goto _L24
_L9:
        flag = decodeValidityAbs(bearerdata, bitwiseinputstream);
          goto _L24
_L10:
        flag = decodeValidityRel(bearerdata, bitwiseinputstream);
          goto _L24
_L11:
        flag = decodeDeferredDeliveryAbs(bearerdata, bitwiseinputstream);
          goto _L24
_L12:
        flag = decodeDeferredDeliveryRel(bearerdata, bitwiseinputstream);
          goto _L24
_L14:
        flag = decodePrivacyIndicator(bearerdata, bitwiseinputstream);
          goto _L24
_L18:
        flag = decodeLanguageIndicator(bearerdata, bitwiseinputstream);
          goto _L24
_L20:
        flag = decodeDisplayMode(bearerdata, bitwiseinputstream);
          goto _L24
_L13:
        flag = decodePriorityIndicator(bearerdata, bitwiseinputstream);
          goto _L24
_L17:
        flag = decodeMsgDeliveryAlert(bearerdata, bitwiseinputstream);
          goto _L24
_L21:
        flag = decodeDepositIndex(bearerdata, bitwiseinputstream);
          goto _L24
_L22:
        flag = decodeServiceCategoryProgramData(bearerdata, bitwiseinputstream);
          goto _L24
_L2:
        if((j & 1) == 0)
            throw new CodingException("missing MESSAGE_IDENTIFIER subparam");
        if(bearerdata.userData != null)
            if(isCmasAlertCategory(i))
                decodeCmasUserData(bearerdata, i);
            else
            if(bearerdata.userData.msgEncoding == 1) {
                if((2 ^ (j ^ 1)) != 0)
                    Log.e("SMS", (new StringBuilder()).append("IS-91 must occur without extra subparams (").append(j).append(")").toString());
                decodeIs91(bearerdata);
            } else {
                decodeUserDataPayload(bearerdata.userData, bearerdata.hasUserDataHeader);
            }
          goto _L25
_L24:
        if(!flag) goto _L27; else goto _L26
_L26:
        j |= l;
          goto _L27
    }

    private static String decode7bitAscii(byte abyte0[], int i, int j) throws CodingException {
        int k;
        StringBuffer stringbuffer;
        BitwiseInputStream bitwiseinputstream;
        k = i * 8;
        try {
            stringbuffer = new StringBuffer(j);
            bitwiseinputstream = new BitwiseInputStream(abyte0);
            int l = k * 8 + j * 7;
            if(bitwiseinputstream.available() < l)
                throw new CodingException((new StringBuilder()).append("insufficient data (wanted ").append(l).append(" bits, but only have ").append(bitwiseinputstream.available()).append(")").toString());
        }
        catch(com.android.internal.util.BitwiseInputStream.AccessException accessexception) {
            throw new CodingException((new StringBuilder()).append("7bit ASCII decode failed: ").append(accessexception).toString());
        }
        bitwiseinputstream.skip(k);
        String s;
        for(int i1 = 0; i1 < j; i1++) {
            int j1 = bitwiseinputstream.read(7);
            if(j1 >= 32 && j1 <= UserData.ASCII_MAP_MAX_INDEX)
                stringbuffer.append(UserData.ASCII_MAP[j1 - 32]);
            else
            if(j1 == 10)
                stringbuffer.append('\n');
            else
            if(j1 == 13)
                stringbuffer.append('\r');
            else
                stringbuffer.append(' ');
            break MISSING_BLOCK_LABEL_240;
        }

        s = stringbuffer.toString();
        return s;
    }

    private static String decode7bitGsm(byte abyte0[], int i, int j) throws CodingException {
        int k = i * 8;
        int l = (k + 6) / 7;
        String s = GsmAlphabet.gsm7BitPackedToString(abyte0, i, j - l, l * 7 - k, 0, 0);
        if(s == null)
            throw new CodingException("7bit GSM decoding failed");
        else
            return s;
    }

    private static boolean decodeCallbackNumber(BearerData bearerdata, BitwiseInputStream bitwiseinputstream) throws com.android.internal.util.BitwiseInputStream.AccessException, CodingException {
        int i = 8 * bitwiseinputstream.read(8);
        CdmaSmsAddress cdmasmsaddress = new CdmaSmsAddress();
        cdmasmsaddress.digitMode = bitwiseinputstream.read(1);
        byte byte0 = 4;
        byte byte1 = 1;
        if(cdmasmsaddress.digitMode == 1) {
            cdmasmsaddress.ton = bitwiseinputstream.read(3);
            cdmasmsaddress.numberPlan = bitwiseinputstream.read(4);
            byte0 = 8;
            byte1 = (byte)8;
        }
        cdmasmsaddress.numberOfDigits = bitwiseinputstream.read(8);
        int j = i - (byte1 + 8);
        int k = byte0 * cdmasmsaddress.numberOfDigits;
        int l = j - k;
        if(j < k) {
            throw new CodingException((new StringBuilder()).append("CALLBACK_NUMBER subparam encoding size error (remainingBits + ").append(j).append(", dataBits + ").append(k).append(", paddingBits + ").append(l).append(")").toString());
        } else {
            cdmasmsaddress.origBytes = bitwiseinputstream.readByteArray(k);
            bitwiseinputstream.skip(l);
            decodeSmsAddress(cdmasmsaddress);
            bearerdata.callbackNumber = cdmasmsaddress;
            return true;
        }
    }

    private static void decodeCmasUserData(BearerData bearerdata, int i) throws com.android.internal.util.BitwiseInputStream.AccessException, CodingException {
        BitwiseInputStream bitwiseinputstream;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        bitwiseinputstream = new BitwiseInputStream(bearerdata.userData.payload);
        if(bitwiseinputstream.available() < 8)
            throw new CodingException("emergency CB with no CMAE_protocol_version");
        int j = bitwiseinputstream.read(8);
        if(j != 0)
            throw new CodingException((new StringBuilder()).append("unsupported CMAE_protocol_version ").append(j).toString());
        k = serviceCategoryToCmasMessageClass(i);
        l = -1;
        i1 = -1;
        j1 = -1;
        k1 = -1;
        l1 = -1;
_L10:
        int i2;
        int j2;
        if(bitwiseinputstream.available() < 16)
            break; /* Loop/switch isn't completed */
        i2 = bitwiseinputstream.read(8);
        j2 = bitwiseinputstream.read(8);
        i2;
        JVM INSTR tableswitch 0 1: default 148
    //                   0 187
    //                   1 354;
           goto _L1 _L2 _L3
_L1:
        Log.w("SMS", (new StringBuilder()).append("skipping unsupported CMAS record type ").append(i2).toString());
        bitwiseinputstream.skip(j2 * 8);
        continue; /* Loop/switch isn't completed */
_L2:
        UserData userdata;
        userdata = new UserData();
        userdata.msgEncoding = bitwiseinputstream.read(5);
        userdata.msgEncodingSet = true;
        userdata.msgType = 0;
        userdata.msgEncoding;
        JVM INSTR tableswitch 0 9: default 276
    //                   0 318
    //                   1 276
    //                   2 327
    //                   3 327
    //                   4 343
    //                   5 276
    //                   6 276
    //                   7 276
    //                   8 318
    //                   9 327;
           goto _L4 _L5 _L4 _L6 _L6 _L7 _L4 _L4 _L4 _L5 _L6
_L4:
        int k2 = 0;
_L8:
        userdata.numFields = k2;
        userdata.payload = bitwiseinputstream.readByteArray(-5 + j2 * 8);
        decodeUserDataPayload(userdata, false);
        bearerdata.userData = userdata;
        continue; /* Loop/switch isn't completed */
_L5:
        k2 = j2 - 1;
          goto _L8
_L6:
        k2 = (-5 + j2 * 8) / 7;
          goto _L8
_L7:
        k2 = (j2 - 1) / 2;
          goto _L8
_L3:
        l = bitwiseinputstream.read(8);
        i1 = bitwiseinputstream.read(8);
        j1 = bitwiseinputstream.read(4);
        k1 = bitwiseinputstream.read(4);
        l1 = bitwiseinputstream.read(4);
        bitwiseinputstream.skip(-28 + j2 * 8);
        if(true) goto _L10; else goto _L9
_L9:
        bearerdata.cmasWarningInfo = new SmsCbCmasInfo(k, l, i1, j1, k1, l1);
        return;
    }

    private static boolean decodeDeferredDeliveryAbs(BearerData bearerdata, BitwiseInputStream bitwiseinputstream) throws com.android.internal.util.BitwiseInputStream.AccessException, CodingException {
        boolean flag = false;
        int i = 8 * bitwiseinputstream.read(8);
        if(i >= 48) {
            i -= 48;
            flag = true;
            bearerdata.deferredDeliveryTimeAbsolute = TimeStamp.fromByteArray(bitwiseinputstream.readByteArray(48));
        }
        if(!flag || i > 0) {
            StringBuilder stringbuilder = (new StringBuilder()).append("DEFERRED_DELIVERY_TIME_ABSOLUTE decode ");
            String s;
            if(flag)
                s = "succeeded";
            else
                s = "failed";
            Log.d("SMS", stringbuilder.append(s).append(" (extra bits = ").append(i).append(")").toString());
        }
        bitwiseinputstream.skip(i);
        return flag;
    }

    private static boolean decodeDeferredDeliveryRel(BearerData bearerdata, BitwiseInputStream bitwiseinputstream) throws com.android.internal.util.BitwiseInputStream.AccessException, CodingException {
        boolean flag = false;
        int i = 8 * bitwiseinputstream.read(8);
        if(i >= 8) {
            i -= 8;
            flag = true;
            bearerdata.validityPeriodRelative = bitwiseinputstream.read(8);
        }
        if(!flag || i > 0) {
            StringBuilder stringbuilder = (new StringBuilder()).append("DEFERRED_DELIVERY_TIME_RELATIVE decode ");
            String s;
            if(flag)
                s = "succeeded";
            else
                s = "failed";
            Log.d("SMS", stringbuilder.append(s).append(" (extra bits = ").append(i).append(")").toString());
        }
        bitwiseinputstream.skip(i);
        bearerdata.validityPeriodRelativeSet = flag;
        return flag;
    }

    private static boolean decodeDepositIndex(BearerData bearerdata, BitwiseInputStream bitwiseinputstream) throws com.android.internal.util.BitwiseInputStream.AccessException, CodingException {
        boolean flag = false;
        int i = 8 * bitwiseinputstream.read(8);
        if(i >= 16) {
            i -= 16;
            flag = true;
            bearerdata.depositIndex = bitwiseinputstream.read(8) << 8 | bitwiseinputstream.read(8);
        }
        if(!flag || i > 0) {
            StringBuilder stringbuilder = (new StringBuilder()).append("MESSAGE_DEPOSIT_INDEX decode ");
            String s;
            if(flag)
                s = "succeeded";
            else
                s = "failed";
            Log.d("SMS", stringbuilder.append(s).append(" (extra bits = ").append(i).append(")").toString());
        }
        bitwiseinputstream.skip(i);
        return flag;
    }

    private static boolean decodeDisplayMode(BearerData bearerdata, BitwiseInputStream bitwiseinputstream) throws com.android.internal.util.BitwiseInputStream.AccessException, CodingException {
        boolean flag = false;
        int i = 8 * bitwiseinputstream.read(8);
        if(i >= 8) {
            i -= 8;
            flag = true;
            bearerdata.displayMode = bitwiseinputstream.read(2);
            bitwiseinputstream.skip(6);
        }
        if(!flag || i > 0) {
            StringBuilder stringbuilder = (new StringBuilder()).append("DISPLAY_MODE decode ");
            String s;
            if(flag)
                s = "succeeded";
            else
                s = "failed";
            Log.d("SMS", stringbuilder.append(s).append(" (extra bits = ").append(i).append(")").toString());
        }
        bitwiseinputstream.skip(i);
        bearerdata.displayModeSet = flag;
        return flag;
    }

    private static String decodeDtmfSmsAddress(byte abyte0[], int i) throws CodingException {
        StringBuffer stringbuffer = new StringBuffer(i);
        int j = 0;
        while(j < i)  {
            int k = 0xf & abyte0[j / 2] >>> 4 - 4 * (j % 2);
            if(k >= 1 && k <= 9)
                stringbuffer.append(Integer.toString(k, 10));
            else
            if(k == 10)
                stringbuffer.append('0');
            else
            if(k == 11)
                stringbuffer.append('*');
            else
            if(k == 12)
                stringbuffer.append('#');
            else
                throw new CodingException((new StringBuilder()).append("invalid SMS address DTMF code (").append(k).append(")").toString());
            j++;
        }
        return stringbuffer.toString();
    }

    private static void decodeIs91(BearerData bearerdata) throws com.android.internal.util.BitwiseInputStream.AccessException, CodingException {
        bearerdata.userData.msgType;
        JVM INSTR tableswitch 130 133: default 36
    //                   130 76
    //                   131 88
    //                   132 81
    //                   133 88;
           goto _L1 _L2 _L3 _L4 _L3
_L1:
        throw new CodingException((new StringBuilder()).append("unsupported IS-91 message type (").append(bearerdata.userData.msgType).append(")").toString());
_L2:
        decodeIs91VoicemailStatus(bearerdata);
_L6:
        return;
_L4:
        decodeIs91Cli(bearerdata);
        continue; /* Loop/switch isn't completed */
_L3:
        decodeIs91ShortMessage(bearerdata);
        if(true) goto _L6; else goto _L5
_L5:
    }

    private static void decodeIs91Cli(BearerData bearerdata) throws CodingException {
        int i = (new BitwiseInputStream(bearerdata.userData.payload)).available() / 4;
        int j = bearerdata.userData.numFields;
        if(i > 14 || i < 3 || i < j) {
            throw new CodingException("IS-91 voicemail status decoding failed");
        } else {
            CdmaSmsAddress cdmasmsaddress = new CdmaSmsAddress();
            cdmasmsaddress.digitMode = 0;
            cdmasmsaddress.origBytes = bearerdata.userData.payload;
            cdmasmsaddress.numberOfDigits = (byte)j;
            decodeSmsAddress(cdmasmsaddress);
            bearerdata.callbackNumber = cdmasmsaddress;
            return;
        }
    }

    private static void decodeIs91ShortMessage(BearerData bearerdata) throws com.android.internal.util.BitwiseInputStream.AccessException, CodingException {
        BitwiseInputStream bitwiseinputstream = new BitwiseInputStream(bearerdata.userData.payload);
        int i = bitwiseinputstream.available() / 6;
        int j = bearerdata.userData.numFields;
        if(j > 14 || i < j)
            throw new CodingException("IS-91 short message decoding failed");
        StringBuffer stringbuffer = new StringBuffer(i);
        for(int k = 0; k < j; k++)
            stringbuffer.append(UserData.ASCII_MAP[bitwiseinputstream.read(6)]);

        bearerdata.userData.payloadStr = stringbuffer.toString();
    }

    private static void decodeIs91VoicemailStatus(BearerData bearerdata) throws com.android.internal.util.BitwiseInputStream.AccessException, CodingException {
        char c;
        BitwiseInputStream bitwiseinputstream = new BitwiseInputStream(bearerdata.userData.payload);
        int i = bitwiseinputstream.available() / 6;
        int j = bearerdata.userData.numFields;
        if(i > 14 || i < 3 || i < j)
            throw new CodingException("IS-91 voicemail status decoding failed");
        StringBuffer stringbuffer;
        String s;
        try {
            stringbuffer = new StringBuffer(i);
            for(; bitwiseinputstream.available() >= 6; stringbuffer.append(UserData.ASCII_MAP[bitwiseinputstream.read(6)]));
        }
        catch(NumberFormatException numberformatexception) {
            throw new CodingException((new StringBuilder()).append("IS-91 voicemail status decoding failed: ").append(numberformatexception).toString());
        }
        catch(IndexOutOfBoundsException indexoutofboundsexception) {
            throw new CodingException((new StringBuilder()).append("IS-91 voicemail status decoding failed: ").append(indexoutofboundsexception).toString());
        }
        s = stringbuffer.toString();
        bearerdata.numberOfMessages = Integer.parseInt(s.substring(0, 2));
        c = s.charAt(2);
        if(c != ' ') goto _L2; else goto _L1
_L1:
        bearerdata.priority = 0;
_L4:
        bearerdata.priorityIndicatorSet = true;
        bearerdata.userData.payloadStr = s.substring(3, j - 3);
        return;
_L2:
        if(c != '!')
            break; /* Loop/switch isn't completed */
        bearerdata.priority = 2;
        if(true) goto _L4; else goto _L3
_L3:
        throw new CodingException((new StringBuilder()).append("IS-91 voicemail status decoding failed: illegal priority setting (").append(c).append(")").toString());
    }

    private static boolean decodeLanguageIndicator(BearerData bearerdata, BitwiseInputStream bitwiseinputstream) throws com.android.internal.util.BitwiseInputStream.AccessException, CodingException {
        boolean flag = false;
        int i = 8 * bitwiseinputstream.read(8);
        if(i >= 8) {
            i -= 8;
            flag = true;
            bearerdata.language = bitwiseinputstream.read(8);
        }
        if(!flag || i > 0) {
            StringBuilder stringbuilder = (new StringBuilder()).append("LANGUAGE_INDICATOR decode ");
            String s;
            if(flag)
                s = "succeeded";
            else
                s = "failed";
            Log.d("SMS", stringbuilder.append(s).append(" (extra bits = ").append(i).append(")").toString());
        }
        bitwiseinputstream.skip(i);
        bearerdata.languageIndicatorSet = flag;
        return flag;
    }

    private static String decodeLatin(byte abyte0[], int i, int j) throws CodingException {
        if(j < 0 || j + i > abyte0.length)
            throw new CodingException("ISO-8859-1 decode failed: offset or length out of range");
        String s;
        try {
            s = new String(abyte0, i, j, "ISO-8859-1");
        }
        catch(UnsupportedEncodingException unsupportedencodingexception) {
            throw new CodingException((new StringBuilder()).append("ISO-8859-1 decode failed: ").append(unsupportedencodingexception).toString());
        }
        return s;
    }

    private static boolean decodeMessageId(BearerData bearerdata, BitwiseInputStream bitwiseinputstream) throws com.android.internal.util.BitwiseInputStream.AccessException, CodingException {
        boolean flag = true;
        boolean flag1 = false;
        int i = 8 * bitwiseinputstream.read(8);
        if(i >= 24) {
            i -= 24;
            flag1 = true;
            bearerdata.messageType = bitwiseinputstream.read(4);
            bearerdata.messageId = bitwiseinputstream.read(8) << 8;
            bearerdata.messageId = bearerdata.messageId | bitwiseinputstream.read(8);
            StringBuilder stringbuilder;
            if(bitwiseinputstream.read(flag) != flag)
                flag = false;
            bearerdata.hasUserDataHeader = flag;
            bitwiseinputstream.skip(3);
        }
        if(!flag1 || i > 0) {
            stringbuilder = (new StringBuilder()).append("MESSAGE_IDENTIFIER decode ");
            String s;
            if(flag1)
                s = "succeeded";
            else
                s = "failed";
            Log.d("SMS", stringbuilder.append(s).append(" (extra bits = ").append(i).append(")").toString());
        }
        bitwiseinputstream.skip(i);
        return flag1;
    }

    private static boolean decodeMsgCenterTimeStamp(BearerData bearerdata, BitwiseInputStream bitwiseinputstream) throws com.android.internal.util.BitwiseInputStream.AccessException, CodingException {
        boolean flag = false;
        int i = 8 * bitwiseinputstream.read(8);
        if(i >= 48) {
            i -= 48;
            flag = true;
            bearerdata.msgCenterTimeStamp = TimeStamp.fromByteArray(bitwiseinputstream.readByteArray(48));
        }
        if(!flag || i > 0) {
            StringBuilder stringbuilder = (new StringBuilder()).append("MESSAGE_CENTER_TIME_STAMP decode ");
            String s;
            if(flag)
                s = "succeeded";
            else
                s = "failed";
            Log.d("SMS", stringbuilder.append(s).append(" (extra bits = ").append(i).append(")").toString());
        }
        bitwiseinputstream.skip(i);
        return flag;
    }

    private static boolean decodeMsgCount(BearerData bearerdata, BitwiseInputStream bitwiseinputstream) throws com.android.internal.util.BitwiseInputStream.AccessException, CodingException {
        boolean flag = false;
        int i = 8 * bitwiseinputstream.read(8);
        if(i >= 8) {
            i -= 8;
            flag = true;
            bearerdata.numberOfMessages = IccUtils.cdmaBcdByteToInt((byte)bitwiseinputstream.read(8));
        }
        if(!flag || i > 0) {
            StringBuilder stringbuilder = (new StringBuilder()).append("NUMBER_OF_MESSAGES decode ");
            String s;
            if(flag)
                s = "succeeded";
            else
                s = "failed";
            Log.d("SMS", stringbuilder.append(s).append(" (extra bits = ").append(i).append(")").toString());
        }
        bitwiseinputstream.skip(i);
        return flag;
    }

    private static boolean decodeMsgDeliveryAlert(BearerData bearerdata, BitwiseInputStream bitwiseinputstream) throws com.android.internal.util.BitwiseInputStream.AccessException, CodingException {
        boolean flag = false;
        int i = 8 * bitwiseinputstream.read(8);
        if(i >= 8) {
            i -= 8;
            flag = true;
            bearerdata.alert = bitwiseinputstream.read(2);
            bitwiseinputstream.skip(6);
        }
        if(!flag || i > 0) {
            StringBuilder stringbuilder = (new StringBuilder()).append("ALERT_ON_MESSAGE_DELIVERY decode ");
            String s;
            if(flag)
                s = "succeeded";
            else
                s = "failed";
            Log.d("SMS", stringbuilder.append(s).append(" (extra bits = ").append(i).append(")").toString());
        }
        bitwiseinputstream.skip(i);
        bearerdata.alertIndicatorSet = flag;
        return flag;
    }

    private static boolean decodeMsgStatus(BearerData bearerdata, BitwiseInputStream bitwiseinputstream) throws com.android.internal.util.BitwiseInputStream.AccessException, CodingException {
        boolean flag = false;
        int i = 8 * bitwiseinputstream.read(8);
        if(i >= 8) {
            i -= 8;
            flag = true;
            bearerdata.errorClass = bitwiseinputstream.read(2);
            bearerdata.messageStatus = bitwiseinputstream.read(6);
        }
        if(!flag || i > 0) {
            StringBuilder stringbuilder = (new StringBuilder()).append("MESSAGE_STATUS decode ");
            String s;
            if(flag)
                s = "succeeded";
            else
                s = "failed";
            Log.d("SMS", stringbuilder.append(s).append(" (extra bits = ").append(i).append(")").toString());
        }
        bitwiseinputstream.skip(i);
        bearerdata.messageStatusSet = flag;
        return flag;
    }

    private static boolean decodePriorityIndicator(BearerData bearerdata, BitwiseInputStream bitwiseinputstream) throws com.android.internal.util.BitwiseInputStream.AccessException, CodingException {
        boolean flag = false;
        int i = 8 * bitwiseinputstream.read(8);
        if(i >= 8) {
            i -= 8;
            flag = true;
            bearerdata.priority = bitwiseinputstream.read(2);
            bitwiseinputstream.skip(6);
        }
        if(!flag || i > 0) {
            StringBuilder stringbuilder = (new StringBuilder()).append("PRIORITY_INDICATOR decode ");
            String s;
            if(flag)
                s = "succeeded";
            else
                s = "failed";
            Log.d("SMS", stringbuilder.append(s).append(" (extra bits = ").append(i).append(")").toString());
        }
        bitwiseinputstream.skip(i);
        bearerdata.priorityIndicatorSet = flag;
        return flag;
    }

    private static boolean decodePrivacyIndicator(BearerData bearerdata, BitwiseInputStream bitwiseinputstream) throws com.android.internal.util.BitwiseInputStream.AccessException, CodingException {
        boolean flag = false;
        int i = 8 * bitwiseinputstream.read(8);
        if(i >= 8) {
            i -= 8;
            flag = true;
            bearerdata.privacy = bitwiseinputstream.read(2);
            bitwiseinputstream.skip(6);
        }
        if(!flag || i > 0) {
            StringBuilder stringbuilder = (new StringBuilder()).append("PRIVACY_INDICATOR decode ");
            String s;
            if(flag)
                s = "succeeded";
            else
                s = "failed";
            Log.d("SMS", stringbuilder.append(s).append(" (extra bits = ").append(i).append(")").toString());
        }
        bitwiseinputstream.skip(i);
        bearerdata.privacyIndicatorSet = flag;
        return flag;
    }

    private static boolean decodeReplyOption(BearerData bearerdata, BitwiseInputStream bitwiseinputstream) throws com.android.internal.util.BitwiseInputStream.AccessException, CodingException {
        boolean flag = true;
        boolean flag1 = false;
        int i = 8 * bitwiseinputstream.read(8);
        if(i >= 8) {
            i -= 8;
            flag1 = true;
            StringBuilder stringbuilder;
            boolean flag2;
            boolean flag3;
            boolean flag4;
            if(bitwiseinputstream.read(flag) == flag)
                flag2 = flag;
            else
                flag2 = false;
            bearerdata.userAckReq = flag2;
            if(bitwiseinputstream.read(flag) == flag)
                flag3 = flag;
            else
                flag3 = false;
            bearerdata.deliveryAckReq = flag3;
            if(bitwiseinputstream.read(flag) == flag)
                flag4 = flag;
            else
                flag4 = false;
            bearerdata.readAckReq = flag4;
            if(bitwiseinputstream.read(flag) != flag)
                flag = false;
            bearerdata.reportReq = flag;
            bitwiseinputstream.skip(4);
        }
        if(!flag1 || i > 0) {
            stringbuilder = (new StringBuilder()).append("REPLY_OPTION decode ");
            String s;
            if(flag1)
                s = "succeeded";
            else
                s = "failed";
            Log.d("SMS", stringbuilder.append(s).append(" (extra bits = ").append(i).append(")").toString());
        }
        bitwiseinputstream.skip(i);
        return flag1;
    }

    private static boolean decodeServiceCategoryProgramData(BearerData bearerdata, BitwiseInputStream bitwiseinputstream) throws com.android.internal.util.BitwiseInputStream.AccessException, CodingException {
        if(bitwiseinputstream.available() < 13)
            throw new CodingException((new StringBuilder()).append("SERVICE_CATEGORY_PROGRAM_DATA decode failed: only ").append(bitwiseinputstream.available()).append(" bits available").toString());
        int i = 8 * bitwiseinputstream.read(8);
        int j = bitwiseinputstream.read(5);
        int k = i - 5;
        if(bitwiseinputstream.available() < k)
            throw new CodingException((new StringBuilder()).append("SERVICE_CATEGORY_PROGRAM_DATA decode failed: only ").append(bitwiseinputstream.available()).append(" bits available (").append(k).append(" bits expected)").toString());
        ArrayList arraylist = new ArrayList();
        boolean flag;
        for(flag = false; k >= 48; flag = true) {
            int l = bitwiseinputstream.read(4);
            int i1 = bitwiseinputstream.read(8) << 8 | bitwiseinputstream.read(8);
            int j1 = bitwiseinputstream.read(8);
            int k1 = bitwiseinputstream.read(8);
            int l1 = bitwiseinputstream.read(4);
            int i2 = bitwiseinputstream.read(8);
            int j2 = k - 48;
            int k2 = getBitsForNumFields(j, i2);
            if(j2 < k2)
                throw new CodingException((new StringBuilder()).append("category name is ").append(k2).append(" bits in length,").append(" but there are only ").append(j2).append(" bits available").toString());
            UserData userdata = new UserData();
            userdata.msgEncoding = j;
            userdata.msgEncodingSet = true;
            userdata.numFields = i2;
            userdata.payload = bitwiseinputstream.readByteArray(k2);
            k = j2 - k2;
            decodeUserDataPayload(userdata, false);
            arraylist.add(new CdmaSmsCbProgramData(l, i1, j1, k1, l1, userdata.payloadStr));
        }

        if(!flag || k > 0) {
            StringBuilder stringbuilder = (new StringBuilder()).append("SERVICE_CATEGORY_PROGRAM_DATA decode ");
            String s;
            if(flag)
                s = "succeeded";
            else
                s = "failed";
            Log.d("SMS", stringbuilder.append(s).append(" (extra bits = ").append(k).append(')').toString());
        }
        bitwiseinputstream.skip(k);
        bearerdata.serviceCategoryProgramData = arraylist;
        return flag;
    }

    private static void decodeSmsAddress(CdmaSmsAddress cdmasmsaddress) throws CodingException {
        if(cdmasmsaddress.digitMode != 1)
            break MISSING_BLOCK_LABEL_45;
        cdmasmsaddress.address = new String(((SmsAddress) (cdmasmsaddress)).origBytes, 0, ((SmsAddress) (cdmasmsaddress)).origBytes.length, "US-ASCII");
_L1:
        return;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        throw new CodingException("invalid SMS address ASCII code");
        cdmasmsaddress.address = decodeDtmfSmsAddress(((SmsAddress) (cdmasmsaddress)).origBytes, cdmasmsaddress.numberOfDigits);
          goto _L1
    }

    private static boolean decodeUserData(BearerData bearerdata, BitwiseInputStream bitwiseinputstream) throws com.android.internal.util.BitwiseInputStream.AccessException {
        int i = 8 * bitwiseinputstream.read(8);
        bearerdata.userData = new UserData();
        bearerdata.userData.msgEncoding = bitwiseinputstream.read(5);
        bearerdata.userData.msgEncodingSet = true;
        bearerdata.userData.msgType = 0;
        int j = 5;
        if(bearerdata.userData.msgEncoding == 1 || bearerdata.userData.msgEncoding == 10) {
            bearerdata.userData.msgType = bitwiseinputstream.read(8);
            j += 8;
        }
        bearerdata.userData.numFields = bitwiseinputstream.read(8);
        int k = i - (j + 8);
        bearerdata.userData.payload = bitwiseinputstream.readByteArray(k);
        return true;
    }

    private static void decodeUserDataPayload(UserData userdata, boolean flag) throws CodingException {
        int i;
        i = 0;
        if(flag) {
            int k = 0xff & userdata.payload[0];
            i = 0 + (k + 1);
            byte abyte1[] = new byte[k];
            System.arraycopy(userdata.payload, 1, abyte1, 0, k);
            userdata.userDataHeader = SmsHeader.fromByteArray(abyte1);
        }
        userdata.msgEncoding;
        JVM INSTR tableswitch 0 9: default 112
    //                   0 149
    //                   1 112
    //                   2 254
    //                   3 254
    //                   4 273
    //                   5 112
    //                   6 112
    //                   7 112
    //                   8 311
    //                   9 292;
           goto _L1 _L2 _L1 _L3 _L3 _L4 _L1 _L1 _L1 _L5 _L6
_L1:
        throw new CodingException((new StringBuilder()).append("unsupported user data encoding (").append(userdata.msgEncoding).append(")").toString());
_L2:
        boolean flag1 = Resources.getSystem().getBoolean(0x1110030);
        byte abyte0[] = new byte[userdata.numFields];
        int j;
        if(userdata.numFields < userdata.payload.length)
            j = userdata.numFields;
        else
            j = userdata.payload.length;
        System.arraycopy(userdata.payload, 0, abyte0, 0, j);
        userdata.payload = abyte0;
        if(!flag1)
            userdata.payloadStr = decodeLatin(userdata.payload, i, userdata.numFields);
        else
            userdata.payloadStr = decodeUtf8(userdata.payload, i, userdata.numFields);
_L8:
        return;
_L3:
        userdata.payloadStr = decode7bitAscii(userdata.payload, i, userdata.numFields);
        continue; /* Loop/switch isn't completed */
_L4:
        userdata.payloadStr = decodeUtf16(userdata.payload, i, userdata.numFields);
        continue; /* Loop/switch isn't completed */
_L6:
        userdata.payloadStr = decode7bitGsm(userdata.payload, i, userdata.numFields);
        continue; /* Loop/switch isn't completed */
_L5:
        userdata.payloadStr = decodeLatin(userdata.payload, i, userdata.numFields);
        if(true) goto _L8; else goto _L7
_L7:
    }

    private static boolean decodeUserResponseCode(BearerData bearerdata, BitwiseInputStream bitwiseinputstream) throws com.android.internal.util.BitwiseInputStream.AccessException, CodingException {
        boolean flag = false;
        int i = 8 * bitwiseinputstream.read(8);
        if(i >= 8) {
            i -= 8;
            flag = true;
            bearerdata.userResponseCode = bitwiseinputstream.read(8);
        }
        if(!flag || i > 0) {
            StringBuilder stringbuilder = (new StringBuilder()).append("USER_RESPONSE_CODE decode ");
            String s;
            if(flag)
                s = "succeeded";
            else
                s = "failed";
            Log.d("SMS", stringbuilder.append(s).append(" (extra bits = ").append(i).append(")").toString());
        }
        bitwiseinputstream.skip(i);
        bearerdata.userResponseCodeSet = flag;
        return flag;
    }

    private static String decodeUtf16(byte abyte0[], int i, int j) throws CodingException {
        int k = j * 2;
        if(k < 0 || k + i > abyte0.length)
            throw new CodingException("UTF-16 decode failed: offset or length out of range");
        String s;
        try {
            s = new String(abyte0, i, k, "utf-16be");
        }
        catch(UnsupportedEncodingException unsupportedencodingexception) {
            throw new CodingException((new StringBuilder()).append("UTF-16 decode failed: ").append(unsupportedencodingexception).toString());
        }
        return s;
    }

    private static String decodeUtf8(byte abyte0[], int i, int j) throws CodingException {
        if(j < 0 || j + i > abyte0.length)
            throw new CodingException("UTF-8 decode failed: offset or length out of range");
        String s;
        try {
            s = new String(abyte0, i, j, "UTF-8");
        }
        catch(UnsupportedEncodingException unsupportedencodingexception) {
            throw new CodingException((new StringBuilder()).append("UTF-8 decode failed: ").append(unsupportedencodingexception).toString());
        }
        return s;
    }

    private static boolean decodeValidityAbs(BearerData bearerdata, BitwiseInputStream bitwiseinputstream) throws com.android.internal.util.BitwiseInputStream.AccessException, CodingException {
        boolean flag = false;
        int i = 8 * bitwiseinputstream.read(8);
        if(i >= 48) {
            i -= 48;
            flag = true;
            bearerdata.validityPeriodAbsolute = TimeStamp.fromByteArray(bitwiseinputstream.readByteArray(48));
        }
        if(!flag || i > 0) {
            StringBuilder stringbuilder = (new StringBuilder()).append("VALIDITY_PERIOD_ABSOLUTE decode ");
            String s;
            if(flag)
                s = "succeeded";
            else
                s = "failed";
            Log.d("SMS", stringbuilder.append(s).append(" (extra bits = ").append(i).append(")").toString());
        }
        bitwiseinputstream.skip(i);
        return flag;
    }

    private static boolean decodeValidityRel(BearerData bearerdata, BitwiseInputStream bitwiseinputstream) throws com.android.internal.util.BitwiseInputStream.AccessException, CodingException {
        boolean flag = false;
        int i = 8 * bitwiseinputstream.read(8);
        if(i >= 8) {
            i -= 8;
            flag = true;
            bearerdata.deferredDeliveryTimeRelative = bitwiseinputstream.read(8);
        }
        if(!flag || i > 0) {
            StringBuilder stringbuilder = (new StringBuilder()).append("VALIDITY_PERIOD_RELATIVE decode ");
            String s;
            if(flag)
                s = "succeeded";
            else
                s = "failed";
            Log.d("SMS", stringbuilder.append(s).append(" (extra bits = ").append(i).append(")").toString());
        }
        bitwiseinputstream.skip(i);
        bearerdata.deferredDeliveryTimeRelativeSet = flag;
        return flag;
    }

    public static byte[] encode(BearerData bearerdata) {
        byte abyte0[];
        boolean flag = true;
        BitwiseOutputStream bitwiseoutputstream;
        byte abyte1[];
        if(bearerdata.userData == null || bearerdata.userData.userDataHeader == null)
            flag = false;
        bearerdata.hasUserDataHeader = flag;
        bitwiseoutputstream = new BitwiseOutputStream(200);
        bitwiseoutputstream.write(8, 0);
        encodeMessageId(bearerdata, bitwiseoutputstream);
        if(bearerdata.userData != null) {
            bitwiseoutputstream.write(8, 1);
            encodeUserData(bearerdata, bitwiseoutputstream);
        }
        if(bearerdata.callbackNumber != null) {
            bitwiseoutputstream.write(8, 14);
            encodeCallbackNumber(bearerdata, bitwiseoutputstream);
        }
        if(bearerdata.userAckReq || bearerdata.deliveryAckReq || bearerdata.readAckReq || bearerdata.reportReq) {
            bitwiseoutputstream.write(8, 10);
            encodeReplyOption(bearerdata, bitwiseoutputstream);
        }
        if(bearerdata.numberOfMessages != 0) {
            bitwiseoutputstream.write(8, 11);
            encodeMsgCount(bearerdata, bitwiseoutputstream);
        }
        if(bearerdata.validityPeriodRelativeSet) {
            bitwiseoutputstream.write(8, 5);
            encodeValidityPeriodRel(bearerdata, bitwiseoutputstream);
        }
        if(bearerdata.privacyIndicatorSet) {
            bitwiseoutputstream.write(8, 9);
            encodePrivacyIndicator(bearerdata, bitwiseoutputstream);
        }
        if(bearerdata.languageIndicatorSet) {
            bitwiseoutputstream.write(8, 13);
            encodeLanguageIndicator(bearerdata, bitwiseoutputstream);
        }
        if(bearerdata.displayModeSet) {
            bitwiseoutputstream.write(8, 15);
            encodeDisplayMode(bearerdata, bitwiseoutputstream);
        }
        if(bearerdata.priorityIndicatorSet) {
            bitwiseoutputstream.write(8, 8);
            encodePriorityIndicator(bearerdata, bitwiseoutputstream);
        }
        if(bearerdata.alertIndicatorSet) {
            bitwiseoutputstream.write(8, 12);
            encodeMsgDeliveryAlert(bearerdata, bitwiseoutputstream);
        }
        if(bearerdata.messageStatusSet) {
            bitwiseoutputstream.write(8, 20);
            encodeMsgStatus(bearerdata, bitwiseoutputstream);
        }
        if(bearerdata.serviceCategoryProgramResults != null) {
            bitwiseoutputstream.write(8, 19);
            encodeScpResults(bearerdata, bitwiseoutputstream);
        }
        abyte1 = bitwiseoutputstream.toByteArray();
        abyte0 = abyte1;
_L2:
        return abyte0;
        com.android.internal.util.BitwiseOutputStream.AccessException accessexception;
        accessexception;
        Log.e("SMS", (new StringBuilder()).append("BearerData encode failed: ").append(accessexception).toString());
_L3:
        abyte0 = null;
        if(true) goto _L2; else goto _L1
_L1:
        CodingException codingexception;
        codingexception;
        Log.e("SMS", (new StringBuilder()).append("BearerData encode failed: ").append(codingexception).toString());
          goto _L3
    }

    private static void encode16bitEms(UserData userdata, byte abyte0[]) throws CodingException {
        byte abyte1[] = encodeUtf16(userdata.payloadStr);
        int i = 1 + abyte0.length;
        int j = (i + 1) / 2;
        int k = i % 2;
        int l = abyte1.length / 2;
        userdata.msgEncoding = 4;
        userdata.msgEncodingSet = true;
        userdata.numFields = j + l;
        userdata.payload = new byte[2 * userdata.numFields];
        userdata.payload[0] = (byte)abyte0.length;
        System.arraycopy(abyte0, 0, userdata.payload, 1, abyte0.length);
        System.arraycopy(abyte1, 0, userdata.payload, i + k, abyte1.length);
    }

    private static byte[] encode7bitAscii(String s, boolean flag) throws CodingException {
        BitwiseOutputStream bitwiseoutputstream;
        int i;
        int j;
        bitwiseoutputstream = new BitwiseOutputStream(s.length());
        i = s.length();
        j = 0;
_L4:
        if(j >= i) goto _L2; else goto _L1
_L1:
        int k;
        k = UserData.charToAscii.get(s.charAt(j), -1);
        if(k == -1) {
            if(flag)
                bitwiseoutputstream.write(7, 32);
            else
                throw new CodingException((new StringBuilder()).append("cannot ASCII encode (").append(s.charAt(j)).append(")").toString());
            break MISSING_BLOCK_LABEL_154;
        }
          goto _L3
        com.android.internal.util.BitwiseOutputStream.AccessException accessexception;
        accessexception;
        throw new CodingException((new StringBuilder()).append("7bit ASCII encode failed: ").append(accessexception).toString());
_L3:
        bitwiseoutputstream.write(7, k);
        break MISSING_BLOCK_LABEL_154;
_L2:
        byte abyte0[] = bitwiseoutputstream.toByteArray();
        return abyte0;
        j++;
          goto _L4
    }

    private static void encode7bitEms(UserData userdata, byte abyte0[], boolean flag) throws CodingException {
        int i = (6 + 8 * (1 + abyte0.length)) / 7;
        Gsm7bitCodingResult gsm7bitcodingresult = encode7bitGsm(userdata.payloadStr, i, flag);
        userdata.msgEncoding = 9;
        userdata.msgEncodingSet = true;
        userdata.numFields = gsm7bitcodingresult.septets;
        userdata.payload = gsm7bitcodingresult.data;
        userdata.payload[0] = (byte)abyte0.length;
        System.arraycopy(abyte0, 0, userdata.payload, 1, abyte0.length);
    }

    private static Gsm7bitCodingResult encode7bitGsm(String s, int i, boolean flag) throws CodingException {
        boolean flag1 = true;
        Gsm7bitCodingResult gsm7bitcodingresult;
        if(flag)
            flag1 = false;
        try {
            byte abyte0[] = GsmAlphabet.stringToGsm7BitPacked(s, i, flag1, 0, 0);
            gsm7bitcodingresult = new Gsm7bitCodingResult();
            gsm7bitcodingresult.data = new byte[-1 + abyte0.length];
            System.arraycopy(abyte0, 1, gsm7bitcodingresult.data, 0, -1 + abyte0.length);
            gsm7bitcodingresult.septets = 0xff & abyte0[0];
        }
        catch(EncodeException encodeexception) {
            throw new CodingException((new StringBuilder()).append("7bit GSM encode failed: ").append(encodeexception).toString());
        }
        return gsm7bitcodingresult;
    }

    private static void encodeCallbackNumber(BearerData bearerdata, BitwiseOutputStream bitwiseoutputstream) throws com.android.internal.util.BitwiseOutputStream.AccessException, CodingException {
        CdmaSmsAddress cdmasmsaddress = bearerdata.callbackNumber;
        encodeCdmaSmsAddress(cdmasmsaddress);
        int i = 9;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        if(cdmasmsaddress.digitMode == 1) {
            i += 7;
            j = 8 * cdmasmsaddress.numberOfDigits;
        } else {
            j = 4 * cdmasmsaddress.numberOfDigits;
        }
        k = i + j;
        l = k / 8;
        if(k % 8 > 0)
            i1 = 1;
        else
            i1 = 0;
        j1 = l + i1;
        k1 = j1 * 8 - k;
        bitwiseoutputstream.write(8, j1);
        bitwiseoutputstream.write(1, cdmasmsaddress.digitMode);
        if(cdmasmsaddress.digitMode == 1) {
            bitwiseoutputstream.write(3, ((SmsAddress) (cdmasmsaddress)).ton);
            bitwiseoutputstream.write(4, cdmasmsaddress.numberPlan);
        }
        bitwiseoutputstream.write(8, cdmasmsaddress.numberOfDigits);
        bitwiseoutputstream.writeByteArray(j, ((SmsAddress) (cdmasmsaddress)).origBytes);
        if(k1 > 0)
            bitwiseoutputstream.write(k1, 0);
    }

    private static void encodeCdmaSmsAddress(CdmaSmsAddress cdmasmsaddress) throws CodingException {
        if(cdmasmsaddress.digitMode != 1)
            break MISSING_BLOCK_LABEL_35;
        cdmasmsaddress.origBytes = ((SmsAddress) (cdmasmsaddress)).address.getBytes("US-ASCII");
_L1:
        return;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        throw new CodingException("invalid SMS address, cannot convert to ASCII");
        cdmasmsaddress.origBytes = encodeDtmfSmsAddress(((SmsAddress) (cdmasmsaddress)).address);
          goto _L1
    }

    private static void encodeDisplayMode(BearerData bearerdata, BitwiseOutputStream bitwiseoutputstream) throws com.android.internal.util.BitwiseOutputStream.AccessException {
        bitwiseoutputstream.write(8, 1);
        bitwiseoutputstream.write(2, bearerdata.displayMode);
        bitwiseoutputstream.skip(6);
    }

    private static byte[] encodeDtmfSmsAddress(String s) {
        byte abyte0[];
        char c;
        int j1;
        int i = s.length();
        int j = i * 4;
        int k = j / 8;
        int l;
        int i1;
        int k1;
        if(j % 8 > 0)
            l = 1;
        else
            l = 0;
        abyte0 = new byte[k + l];
        i1 = 0;
_L6:
        if(i1 >= i)
            break MISSING_BLOCK_LABEL_156;
        c = s.charAt(i1);
        if(c < '1' || c > '9')
            break; /* Loop/switch isn't completed */
        j1 = c + -48;
_L4:
        k1 = i1 / 2;
        abyte0[k1] = (byte)(abyte0[k1] | j1 << 4 - 4 * (i1 % 2));
        i1++;
        if(true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_35;
_L1:
        if(c == '0')
            j1 = 10;
        else
        if(c == '*') {
            j1 = 11;
        } else {
label0:
            {
                if(c != '#')
                    break label0;
                j1 = 12;
            }
        }
        if(true) goto _L4; else goto _L3
_L3:
        if(true) goto _L6; else goto _L5
_L5:
        abyte0 = null;
        return abyte0;
    }

    private static void encodeEmsUserDataPayload(UserData userdata) throws CodingException {
        byte abyte0[] = SmsHeader.toByteArray(userdata.userDataHeader);
        if(userdata.msgEncodingSet) {
            if(userdata.msgEncoding == 9)
                encode7bitEms(userdata, abyte0, true);
            else
            if(userdata.msgEncoding == 4)
                encode16bitEms(userdata, abyte0);
            else
                throw new CodingException((new StringBuilder()).append("unsupported EMS user data encoding (").append(userdata.msgEncoding).append(")").toString());
        } else {
            try {
                encode7bitEms(userdata, abyte0, false);
            }
            catch(CodingException codingexception) {
                encode16bitEms(userdata, abyte0);
            }
        }
    }

    private static void encodeLanguageIndicator(BearerData bearerdata, BitwiseOutputStream bitwiseoutputstream) throws com.android.internal.util.BitwiseOutputStream.AccessException {
        bitwiseoutputstream.write(8, 1);
        bitwiseoutputstream.write(8, bearerdata.language);
    }

    private static void encodeMessageId(BearerData bearerdata, BitwiseOutputStream bitwiseoutputstream) throws com.android.internal.util.BitwiseOutputStream.AccessException {
        bitwiseoutputstream.write(8, 3);
        bitwiseoutputstream.write(4, bearerdata.messageType);
        bitwiseoutputstream.write(8, bearerdata.messageId >> 8);
        bitwiseoutputstream.write(8, bearerdata.messageId);
        int i;
        if(bearerdata.hasUserDataHeader)
            i = 1;
        else
            i = 0;
        bitwiseoutputstream.write(1, i);
        bitwiseoutputstream.skip(3);
    }

    private static void encodeMsgCount(BearerData bearerdata, BitwiseOutputStream bitwiseoutputstream) throws com.android.internal.util.BitwiseOutputStream.AccessException {
        bitwiseoutputstream.write(8, 1);
        bitwiseoutputstream.write(8, bearerdata.numberOfMessages);
    }

    private static void encodeMsgDeliveryAlert(BearerData bearerdata, BitwiseOutputStream bitwiseoutputstream) throws com.android.internal.util.BitwiseOutputStream.AccessException {
        bitwiseoutputstream.write(8, 1);
        bitwiseoutputstream.write(2, bearerdata.alert);
        bitwiseoutputstream.skip(6);
    }

    private static void encodeMsgStatus(BearerData bearerdata, BitwiseOutputStream bitwiseoutputstream) throws com.android.internal.util.BitwiseOutputStream.AccessException {
        bitwiseoutputstream.write(8, 1);
        bitwiseoutputstream.write(2, bearerdata.errorClass);
        bitwiseoutputstream.write(6, bearerdata.messageStatus);
    }

    private static void encodePriorityIndicator(BearerData bearerdata, BitwiseOutputStream bitwiseoutputstream) throws com.android.internal.util.BitwiseOutputStream.AccessException {
        bitwiseoutputstream.write(8, 1);
        bitwiseoutputstream.write(2, bearerdata.priority);
        bitwiseoutputstream.skip(6);
    }

    private static void encodePrivacyIndicator(BearerData bearerdata, BitwiseOutputStream bitwiseoutputstream) throws com.android.internal.util.BitwiseOutputStream.AccessException {
        bitwiseoutputstream.write(8, 1);
        bitwiseoutputstream.write(2, bearerdata.privacy);
        bitwiseoutputstream.skip(6);
    }

    private static void encodeReplyOption(BearerData bearerdata, BitwiseOutputStream bitwiseoutputstream) throws com.android.internal.util.BitwiseOutputStream.AccessException {
        bitwiseoutputstream.write(8, 1);
        int i;
        int j;
        int k;
        int l;
        if(bearerdata.userAckReq)
            i = 1;
        else
            i = 0;
        bitwiseoutputstream.write(1, i);
        if(bearerdata.deliveryAckReq)
            j = 1;
        else
            j = 0;
        bitwiseoutputstream.write(1, j);
        if(bearerdata.readAckReq)
            k = 1;
        else
            k = 0;
        bitwiseoutputstream.write(1, k);
        if(bearerdata.reportReq)
            l = 1;
        else
            l = 0;
        bitwiseoutputstream.write(1, l);
        bitwiseoutputstream.write(4, 0);
    }

    private static void encodeScpResults(BearerData bearerdata, BitwiseOutputStream bitwiseoutputstream) throws com.android.internal.util.BitwiseOutputStream.AccessException {
        ArrayList arraylist = bearerdata.serviceCategoryProgramResults;
        bitwiseoutputstream.write(8, 4 * arraylist.size());
        for(Iterator iterator = arraylist.iterator(); iterator.hasNext(); bitwiseoutputstream.skip(4)) {
            CdmaSmsCbProgramResults cdmasmscbprogramresults = (CdmaSmsCbProgramResults)iterator.next();
            int i = cdmasmscbprogramresults.getCategory();
            bitwiseoutputstream.write(8, i >> 8);
            bitwiseoutputstream.write(8, i);
            bitwiseoutputstream.write(8, cdmasmscbprogramresults.getLanguage());
            bitwiseoutputstream.write(4, cdmasmscbprogramresults.getCategoryResult());
        }

    }

    private static void encodeUserData(BearerData bearerdata, BitwiseOutputStream bitwiseoutputstream) throws com.android.internal.util.BitwiseOutputStream.AccessException, CodingException {
        encodeUserDataPayload(bearerdata.userData);
        boolean flag;
        if(bearerdata.userData.userDataHeader != null)
            flag = true;
        else
            flag = false;
        bearerdata.hasUserDataHeader = flag;
        if(bearerdata.userData.payload.length > 140)
            throw new CodingException((new StringBuilder()).append("encoded user data too large (").append(bearerdata.userData.payload.length).append(" > ").append(140).append(" bytes)").toString());
        int i = 8 * bearerdata.userData.payload.length - bearerdata.userData.paddingBits;
        int j = i + 13;
        if(bearerdata.userData.msgEncoding == 1 || bearerdata.userData.msgEncoding == 10)
            j += 8;
        int k = j / 8;
        int l;
        int i1;
        int j1;
        if(j % 8 > 0)
            l = 1;
        else
            l = 0;
        i1 = k + l;
        j1 = i1 * 8 - j;
        bitwiseoutputstream.write(8, i1);
        bitwiseoutputstream.write(5, bearerdata.userData.msgEncoding);
        if(bearerdata.userData.msgEncoding == 1 || bearerdata.userData.msgEncoding == 10)
            bitwiseoutputstream.write(8, bearerdata.userData.msgType);
        bitwiseoutputstream.write(8, bearerdata.userData.numFields);
        bitwiseoutputstream.writeByteArray(i, bearerdata.userData.payload);
        if(j1 > 0)
            bitwiseoutputstream.write(j1, 0);
    }

    private static void encodeUserDataPayload(UserData userdata) throws CodingException {
        if(userdata.payloadStr == null && userdata.msgEncoding != 0) {
            Log.e("SMS", "user data with null payloadStr");
            userdata.payloadStr = "";
        }
        if(userdata.userDataHeader != null)
            encodeEmsUserDataPayload(userdata);
        else
        if(userdata.msgEncodingSet) {
            if(userdata.msgEncoding == 0) {
                if(userdata.payload == null) {
                    Log.e("SMS", "user data with octet encoding but null payload");
                    userdata.payload = new byte[0];
                    userdata.numFields = 0;
                } else {
                    userdata.numFields = userdata.payload.length;
                }
            } else {
                if(userdata.payloadStr == null) {
                    Log.e("SMS", "non-octet user data with null payloadStr");
                    userdata.payloadStr = "";
                }
                if(userdata.msgEncoding == 9) {
                    Gsm7bitCodingResult gsm7bitcodingresult = encode7bitGsm(userdata.payloadStr, 0, true);
                    userdata.payload = gsm7bitcodingresult.data;
                    userdata.numFields = gsm7bitcodingresult.septets;
                } else
                if(userdata.msgEncoding == 2) {
                    userdata.payload = encode7bitAscii(userdata.payloadStr, true);
                    userdata.numFields = userdata.payloadStr.length();
                } else
                if(userdata.msgEncoding == 4) {
                    userdata.payload = encodeUtf16(userdata.payloadStr);
                    userdata.numFields = userdata.payloadStr.length();
                } else {
                    throw new CodingException((new StringBuilder()).append("unsupported user data encoding (").append(userdata.msgEncoding).append(")").toString());
                }
            }
        } else {
            try {
                userdata.payload = encode7bitAscii(userdata.payloadStr, false);
                userdata.msgEncoding = 2;
            }
            catch(CodingException codingexception) {
                userdata.payload = encodeUtf16(userdata.payloadStr);
                userdata.msgEncoding = 4;
            }
            userdata.numFields = userdata.payloadStr.length();
            userdata.msgEncodingSet = true;
        }
    }

    private static byte[] encodeUtf16(String s) throws CodingException {
        byte abyte0[];
        try {
            abyte0 = s.getBytes("utf-16be");
        }
        catch(UnsupportedEncodingException unsupportedencodingexception) {
            throw new CodingException((new StringBuilder()).append("UTF-16 encode failed: ").append(unsupportedencodingexception).toString());
        }
        return abyte0;
    }

    private static void encodeValidityPeriodRel(BearerData bearerdata, BitwiseOutputStream bitwiseoutputstream) throws com.android.internal.util.BitwiseOutputStream.AccessException {
        bitwiseoutputstream.write(8, 1);
        bitwiseoutputstream.write(8, bearerdata.validityPeriodRelative);
    }

    private static int getBitsForNumFields(int i, int j) throws CodingException {
        i;
        JVM INSTR tableswitch 0 9: default 56
    //                   0 89
    //                   1 56
    //                   2 96
    //                   3 96
    //                   4 104
    //                   5 89
    //                   6 89
    //                   7 89
    //                   8 89
    //                   9 96;
           goto _L1 _L2 _L1 _L3 _L3 _L4 _L2 _L2 _L2 _L2 _L3
_L1:
        throw new CodingException((new StringBuilder()).append("unsupported message encoding (").append(i).append(')').toString());
_L2:
        int k = j * 8;
_L6:
        return k;
_L3:
        k = j * 7;
        continue; /* Loop/switch isn't completed */
_L4:
        k = j * 16;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private static String getLanguageCodeForValue(int i) {
        i;
        JVM INSTR tableswitch 1 7: default 44
    //                   1 48
    //                   2 55
    //                   3 62
    //                   4 69
    //                   5 76
    //                   6 83
    //                   7 90;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        String s = null;
_L10:
        return s;
_L2:
        s = "en";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "fr";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "es";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "ja";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "ko";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "zh";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "he";
        if(true) goto _L10; else goto _L9
_L9:
    }

    private static boolean isCmasAlertCategory(int i) {
        boolean flag;
        if(i >= 4096 && i <= 4351)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static int serviceCategoryToCmasMessageClass(int i) {
        i;
        JVM INSTR tableswitch 4096 4100: default 36
    //                   4096 41
    //                   4097 46
    //                   4098 51
    //                   4099 56
    //                   4100 61;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        byte byte0 = -1;
_L8:
        return byte0;
_L2:
        byte0 = 0;
        continue; /* Loop/switch isn't completed */
_L3:
        byte0 = 1;
        continue; /* Loop/switch isn't completed */
_L4:
        byte0 = 2;
        continue; /* Loop/switch isn't completed */
_L5:
        byte0 = 3;
        continue; /* Loop/switch isn't completed */
_L6:
        byte0 = 4;
        if(true) goto _L8; else goto _L7
_L7:
    }

    public String getLanguage() {
        return getLanguageCodeForValue(language);
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("BearerData ");
        stringbuilder.append((new StringBuilder()).append("{ messageType=").append(messageType).toString());
        stringbuilder.append((new StringBuilder()).append(", messageId=").append(messageId).toString());
        StringBuilder stringbuilder1 = (new StringBuilder()).append(", priority=");
        Object obj;
        StringBuilder stringbuilder2;
        Object obj1;
        StringBuilder stringbuilder3;
        Object obj2;
        StringBuilder stringbuilder4;
        Object obj3;
        StringBuilder stringbuilder5;
        Object obj4;
        StringBuilder stringbuilder6;
        Object obj5;
        StringBuilder stringbuilder7;
        Object obj6;
        StringBuilder stringbuilder8;
        Object obj7;
        StringBuilder stringbuilder9;
        Object obj8;
        StringBuilder stringbuilder10;
        Object obj9;
        StringBuilder stringbuilder11;
        Object obj10;
        StringBuilder stringbuilder12;
        Object obj11;
        if(priorityIndicatorSet)
            obj = Integer.valueOf(priority);
        else
            obj = "unset";
        stringbuilder.append(stringbuilder1.append(obj).toString());
        stringbuilder2 = (new StringBuilder()).append(", privacy=");
        if(privacyIndicatorSet)
            obj1 = Integer.valueOf(privacy);
        else
            obj1 = "unset";
        stringbuilder.append(stringbuilder2.append(obj1).toString());
        stringbuilder3 = (new StringBuilder()).append(", alert=");
        if(alertIndicatorSet)
            obj2 = Integer.valueOf(alert);
        else
            obj2 = "unset";
        stringbuilder.append(stringbuilder3.append(obj2).toString());
        stringbuilder4 = (new StringBuilder()).append(", displayMode=");
        if(displayModeSet)
            obj3 = Integer.valueOf(displayMode);
        else
            obj3 = "unset";
        stringbuilder.append(stringbuilder4.append(obj3).toString());
        stringbuilder5 = (new StringBuilder()).append(", language=");
        if(languageIndicatorSet)
            obj4 = Integer.valueOf(language);
        else
            obj4 = "unset";
        stringbuilder.append(stringbuilder5.append(obj4).toString());
        stringbuilder6 = (new StringBuilder()).append(", errorClass=");
        if(messageStatusSet)
            obj5 = Integer.valueOf(errorClass);
        else
            obj5 = "unset";
        stringbuilder.append(stringbuilder6.append(obj5).toString());
        stringbuilder7 = (new StringBuilder()).append(", msgStatus=");
        if(messageStatusSet)
            obj6 = Integer.valueOf(messageStatus);
        else
            obj6 = "unset";
        stringbuilder.append(stringbuilder7.append(obj6).toString());
        stringbuilder8 = (new StringBuilder()).append(", msgCenterTimeStamp=");
        if(msgCenterTimeStamp != null)
            obj7 = msgCenterTimeStamp;
        else
            obj7 = "unset";
        stringbuilder.append(stringbuilder8.append(obj7).toString());
        stringbuilder9 = (new StringBuilder()).append(", validityPeriodAbsolute=");
        if(validityPeriodAbsolute != null)
            obj8 = validityPeriodAbsolute;
        else
            obj8 = "unset";
        stringbuilder.append(stringbuilder9.append(obj8).toString());
        stringbuilder10 = (new StringBuilder()).append(", validityPeriodRelative=");
        if(validityPeriodRelativeSet)
            obj9 = Integer.valueOf(validityPeriodRelative);
        else
            obj9 = "unset";
        stringbuilder.append(stringbuilder10.append(obj9).toString());
        stringbuilder11 = (new StringBuilder()).append(", deferredDeliveryTimeAbsolute=");
        if(deferredDeliveryTimeAbsolute != null)
            obj10 = deferredDeliveryTimeAbsolute;
        else
            obj10 = "unset";
        stringbuilder.append(stringbuilder11.append(obj10).toString());
        stringbuilder12 = (new StringBuilder()).append(", deferredDeliveryTimeRelative=");
        if(deferredDeliveryTimeRelativeSet)
            obj11 = Integer.valueOf(deferredDeliveryTimeRelative);
        else
            obj11 = "unset";
        stringbuilder.append(stringbuilder12.append(obj11).toString());
        stringbuilder.append((new StringBuilder()).append(", userAckReq=").append(userAckReq).toString());
        stringbuilder.append((new StringBuilder()).append(", deliveryAckReq=").append(deliveryAckReq).toString());
        stringbuilder.append((new StringBuilder()).append(", readAckReq=").append(readAckReq).toString());
        stringbuilder.append((new StringBuilder()).append(", reportReq=").append(reportReq).toString());
        stringbuilder.append((new StringBuilder()).append(", numberOfMessages=").append(numberOfMessages).toString());
        stringbuilder.append((new StringBuilder()).append(", callbackNumber=").append(callbackNumber).toString());
        stringbuilder.append((new StringBuilder()).append(", depositIndex=").append(depositIndex).toString());
        stringbuilder.append((new StringBuilder()).append(", hasUserDataHeader=").append(hasUserDataHeader).toString());
        stringbuilder.append((new StringBuilder()).append(", userData=").append(userData).toString());
        stringbuilder.append(" }");
        return stringbuilder.toString();
    }

    public static final int ALERT_DEFAULT = 0;
    public static final int ALERT_HIGH_PRIO = 3;
    public static final int ALERT_LOW_PRIO = 1;
    public static final int ALERT_MEDIUM_PRIO = 2;
    public static final int DISPLAY_MODE_DEFAULT = 1;
    public static final int DISPLAY_MODE_IMMEDIATE = 0;
    public static final int DISPLAY_MODE_USER = 2;
    public static final int ERROR_NONE = 0;
    public static final int ERROR_PERMANENT = 3;
    public static final int ERROR_TEMPORARY = 2;
    public static final int ERROR_UNDEFINED = 255;
    public static final int LANGUAGE_CHINESE = 6;
    public static final int LANGUAGE_ENGLISH = 1;
    public static final int LANGUAGE_FRENCH = 2;
    public static final int LANGUAGE_HEBREW = 7;
    public static final int LANGUAGE_JAPANESE = 4;
    public static final int LANGUAGE_KOREAN = 5;
    public static final int LANGUAGE_SPANISH = 3;
    public static final int LANGUAGE_UNKNOWN = 0;
    private static final String LOG_TAG = "SMS";
    public static final int MESSAGE_TYPE_CANCELLATION = 3;
    public static final int MESSAGE_TYPE_DELIVER = 1;
    public static final int MESSAGE_TYPE_DELIVERY_ACK = 4;
    public static final int MESSAGE_TYPE_DELIVER_REPORT = 7;
    public static final int MESSAGE_TYPE_READ_ACK = 6;
    public static final int MESSAGE_TYPE_SUBMIT = 2;
    public static final int MESSAGE_TYPE_SUBMIT_REPORT = 8;
    public static final int MESSAGE_TYPE_USER_ACK = 5;
    public static final int PRIORITY_EMERGENCY = 3;
    public static final int PRIORITY_INTERACTIVE = 1;
    public static final int PRIORITY_NORMAL = 0;
    public static final int PRIORITY_URGENT = 2;
    public static final int PRIVACY_CONFIDENTIAL = 2;
    public static final int PRIVACY_NOT_RESTRICTED = 0;
    public static final int PRIVACY_RESTRICTED = 1;
    public static final int PRIVACY_SECRET = 3;
    public static final int RELATIVE_TIME_DAYS_LIMIT = 196;
    public static final int RELATIVE_TIME_HOURS_LIMIT = 167;
    public static final int RELATIVE_TIME_INDEFINITE = 245;
    public static final int RELATIVE_TIME_MINS_LIMIT = 143;
    public static final int RELATIVE_TIME_MOBILE_INACTIVE = 247;
    public static final int RELATIVE_TIME_NOW = 246;
    public static final int RELATIVE_TIME_RESERVED = 248;
    public static final int RELATIVE_TIME_WEEKS_LIMIT = 244;
    public static final int STATUS_ACCEPTED = 0;
    public static final int STATUS_BLOCKED_DESTINATION = 7;
    public static final int STATUS_CANCELLED = 3;
    public static final int STATUS_CANCEL_FAILED = 6;
    public static final int STATUS_DELIVERED = 2;
    public static final int STATUS_DEPOSITED_TO_INTERNET = 1;
    public static final int STATUS_DUPLICATE_MESSAGE = 9;
    public static final int STATUS_INVALID_DESTINATION = 10;
    public static final int STATUS_MESSAGE_EXPIRED = 13;
    public static final int STATUS_NETWORK_CONGESTION = 4;
    public static final int STATUS_NETWORK_ERROR = 5;
    public static final int STATUS_TEXT_TOO_LONG = 8;
    public static final int STATUS_UNDEFINED = 255;
    public static final int STATUS_UNKNOWN_ERROR = 31;
    private static final byte SUBPARAM_ALERT_ON_MESSAGE_DELIVERY = 12;
    private static final byte SUBPARAM_CALLBACK_NUMBER = 14;
    private static final byte SUBPARAM_DEFERRED_DELIVERY_TIME_ABSOLUTE = 6;
    private static final byte SUBPARAM_DEFERRED_DELIVERY_TIME_RELATIVE = 7;
    private static final byte SUBPARAM_LANGUAGE_INDICATOR = 13;
    private static final byte SUBPARAM_MESSAGE_CENTER_TIME_STAMP = 3;
    private static final byte SUBPARAM_MESSAGE_DEPOSIT_INDEX = 17;
    private static final byte SUBPARAM_MESSAGE_DISPLAY_MODE = 15;
    private static final byte SUBPARAM_MESSAGE_IDENTIFIER = 0;
    private static final byte SUBPARAM_MESSAGE_STATUS = 20;
    private static final byte SUBPARAM_NUMBER_OF_MESSAGES = 11;
    private static final byte SUBPARAM_PRIORITY_INDICATOR = 8;
    private static final byte SUBPARAM_PRIVACY_INDICATOR = 9;
    private static final byte SUBPARAM_REPLY_OPTION = 10;
    private static final byte SUBPARAM_SERVICE_CATEGORY_PROGRAM_DATA = 18;
    private static final byte SUBPARAM_SERVICE_CATEGORY_PROGRAM_RESULTS = 19;
    private static final byte SUBPARAM_USER_DATA = 1;
    private static final byte SUBPARAM_USER_RESPONSE_CODE = 2;
    private static final byte SUBPARAM_VALIDITY_PERIOD_ABSOLUTE = 4;
    private static final byte SUBPARAM_VALIDITY_PERIOD_RELATIVE = 5;
    public int alert;
    public boolean alertIndicatorSet;
    public CdmaSmsAddress callbackNumber;
    public SmsCbCmasInfo cmasWarningInfo;
    public TimeStamp deferredDeliveryTimeAbsolute;
    public int deferredDeliveryTimeRelative;
    public boolean deferredDeliveryTimeRelativeSet;
    public boolean deliveryAckReq;
    public int depositIndex;
    public int displayMode;
    public boolean displayModeSet;
    public int errorClass;
    public boolean hasUserDataHeader;
    public int language;
    public boolean languageIndicatorSet;
    public int messageId;
    public int messageStatus;
    public boolean messageStatusSet;
    public int messageType;
    public TimeStamp msgCenterTimeStamp;
    public int numberOfMessages;
    public int priority;
    public boolean priorityIndicatorSet;
    public int privacy;
    public boolean privacyIndicatorSet;
    public boolean readAckReq;
    public boolean reportReq;
    public ArrayList serviceCategoryProgramData;
    public ArrayList serviceCategoryProgramResults;
    public boolean userAckReq;
    public UserData userData;
    public int userResponseCode;
    public boolean userResponseCodeSet;
    public TimeStamp validityPeriodAbsolute;
    public int validityPeriodRelative;
    public boolean validityPeriodRelativeSet;
}
