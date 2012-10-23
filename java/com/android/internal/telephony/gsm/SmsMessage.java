// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.gsm;

import android.telephony.PhoneNumberUtils;
import android.text.format.Time;
import android.util.Log;
import com.android.internal.telephony.*;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

// Referenced classes of package com.android.internal.telephony.gsm:
//            GsmSmsAddress

public class SmsMessage extends SmsMessageBase {
    private static class PduParser {

        int constructUserData(boolean flag, boolean flag1) {
            int i = 0;
            int j = cur;
            byte abyte0[] = pdu;
            int k = j + 1;
            int l = 0xff & abyte0[j];
            int i1 = 0;
            int j1 = 0;
            int k1;
            int i2;
            if(flag) {
                byte abyte1[] = pdu;
                int k2 = k + 1;
                j1 = 0xff & abyte1[k];
                byte abyte2[] = new byte[j1];
                System.arraycopy(pdu, k2, abyte2, 0, j1);
                userDataHeader = SmsHeader.fromByteArray(abyte2);
                k1 = k2 + j1;
                int l2 = 8 * (j1 + 1);
                int i3 = l2 / 7;
                int j3;
                if(l2 % 7 > 0)
                    j3 = 1;
                else
                    j3 = 0;
                i1 = i3 + j3;
                mUserDataSeptetPadding = i1 * 7 - l2;
            } else {
                k1 = k;
            }
            if(flag1) {
                i2 = pdu.length - k1;
            } else {
                int l1;
                if(flag)
                    l1 = j1 + 1;
                else
                    l1 = 0;
                i2 = l - l1;
                if(i2 < 0)
                    i2 = 0;
            }
            userData = new byte[i2];
            System.arraycopy(pdu, k1, userData, 0, userData.length);
            cur = k1;
            if(flag1) {
                int j2 = l - i1;
                if(j2 >= 0)
                    i = j2;
            } else {
                i = userData.length;
            }
            return i;
        }

        GsmSmsAddress getAddress() {
            int i = 2 + (1 + (0xff & pdu[cur])) / 2;
            GsmSmsAddress gsmsmsaddress = new GsmSmsAddress(pdu, cur, i);
            cur = i + cur;
            return gsmsmsaddress;
        }

        int getByte() {
            byte abyte0[] = pdu;
            int i = cur;
            cur = i + 1;
            return 0xff & abyte0[i];
        }

        String getSCAddress() {
            int i = getByte();
            if(i != 0) goto _L2; else goto _L1
_L1:
            String s = null;
_L4:
            cur = i + cur;
            return s;
_L2:
            String s1 = PhoneNumberUtils.calledPartyBCDToString(pdu, cur, i);
            s = s1;
            continue; /* Loop/switch isn't completed */
            RuntimeException runtimeexception;
            runtimeexception;
            Log.d("GSM", "invalid SC address: ", runtimeexception);
            s = null;
            if(true) goto _L4; else goto _L3
_L3:
        }

        long getSCTimestampMillis() {
            byte abyte0[] = pdu;
            int i = cur;
            cur = i + 1;
            int j = IccUtils.gsmBcdByteToInt(abyte0[i]);
            byte abyte1[] = pdu;
            int k = cur;
            cur = k + 1;
            int l = IccUtils.gsmBcdByteToInt(abyte1[k]);
            byte abyte2[] = pdu;
            int i1 = cur;
            cur = i1 + 1;
            int j1 = IccUtils.gsmBcdByteToInt(abyte2[i1]);
            byte abyte3[] = pdu;
            int k1 = cur;
            cur = k1 + 1;
            int l1 = IccUtils.gsmBcdByteToInt(abyte3[k1]);
            byte abyte4[] = pdu;
            int i2 = cur;
            cur = i2 + 1;
            int j2 = IccUtils.gsmBcdByteToInt(abyte4[i2]);
            byte abyte5[] = pdu;
            int k2 = cur;
            cur = k2 + 1;
            int l2 = IccUtils.gsmBcdByteToInt(abyte5[k2]);
            byte abyte6[] = pdu;
            int i3 = cur;
            cur = i3 + 1;
            byte byte0 = abyte6[i3];
            int j3 = IccUtils.gsmBcdByteToInt((byte)(byte0 & -9));
            Time time;
            int k3;
            if((byte0 & 8) != 0)
                j3 = -j3;
            time = new Time("UTC");
            if(j >= 90)
                k3 = j + 1900;
            else
                k3 = j + 2000;
            time.year = k3;
            time.month = l - 1;
            time.monthDay = j1;
            time.hour = l1;
            time.minute = j2;
            time.second = l2;
            return time.toMillis(true) - (long)(1000 * (60 * (j3 * 15)));
        }

        byte[] getUserData() {
            return userData;
        }

        String getUserDataGSM7Bit(int i, int j, int k) {
            String s = GsmAlphabet.gsm7BitPackedToString(pdu, cur, i, mUserDataSeptetPadding, j, k);
            cur = cur + (i * 7) / 8;
            return s;
        }

        SmsHeader getUserDataHeader() {
            return userDataHeader;
        }

        String getUserDataKSC5601(int i) {
            String s;
            try {
                s = new String(pdu, cur, i, "KSC5601");
            }
            catch(UnsupportedEncodingException unsupportedencodingexception) {
                s = "";
                Log.e("GSM", "implausible UnsupportedEncodingException", unsupportedencodingexception);
            }
            cur = i + cur;
            return s;
        }

        int getUserDataSeptetPadding() {
            return mUserDataSeptetPadding;
        }

        String getUserDataUCS2(int i) {
            String s;
            try {
                s = new String(pdu, cur, i, "utf-16");
            }
            catch(UnsupportedEncodingException unsupportedencodingexception) {
                s = "";
                Log.e("GSM", "implausible UnsupportedEncodingException", unsupportedencodingexception);
            }
            cur = i + cur;
            return s;
        }

        boolean moreDataPresent() {
            boolean flag;
            if(pdu.length > cur)
                flag = true;
            else
                flag = false;
            return flag;
        }

        int cur;
        int mUserDataSeptetPadding;
        int mUserDataSize;
        byte pdu[];
        byte userData[];
        SmsHeader userDataHeader;

        PduParser(byte abyte0[]) {
            pdu = abyte0;
            cur = 0;
            mUserDataSeptetPadding = 0;
        }
    }

    public static class SubmitPdu extends com.android.internal.telephony.SmsMessageBase.SubmitPduBase {

        public SubmitPdu() {
        }
    }


    public SmsMessage() {
        replyPathPresent = false;
        isStatusReportMessage = false;
    }

    public static com.android.internal.telephony.SmsMessageBase.TextEncodingDetails calculateLength(CharSequence charsequence, boolean flag) {
        com.android.internal.telephony.SmsMessageBase.TextEncodingDetails textencodingdetails = GsmAlphabet.countGsmSeptets(charsequence, flag);
        if(textencodingdetails == null) {
            textencodingdetails = new com.android.internal.telephony.SmsMessageBase.TextEncodingDetails();
            int i = 2 * charsequence.length();
            textencodingdetails.codeUnitCount = charsequence.length();
            if(i > 140) {
                textencodingdetails.msgCount = (i + 133) / 134;
                textencodingdetails.codeUnitsRemaining = (134 * textencodingdetails.msgCount - i) / 2;
            } else {
                textencodingdetails.msgCount = 1;
                textencodingdetails.codeUnitsRemaining = (140 - i) / 2;
            }
            textencodingdetails.codeUnitSize = 3;
        }
        return textencodingdetails;
    }

    public static SmsMessage createFromEfRecord(int i, byte abyte0[]) {
        SmsMessage smsmessage;
        try {
            smsmessage = new SmsMessage();
            smsmessage.indexOnIcc = i;
            if((1 & abyte0[0]) == 0) {
                Log.w("GSM", "SMS parsing failed: Trying to parse a free record");
                smsmessage = null;
            } else {
                smsmessage.statusOnIcc = 7 & abyte0[0];
                int j = -1 + abyte0.length;
                byte abyte1[] = new byte[j];
                System.arraycopy(abyte0, 1, abyte1, 0, j);
                smsmessage.parsePdu(abyte1);
            }
        }
        catch(RuntimeException runtimeexception) {
            Log.e("GSM", "SMS PDU parsing failed: ", runtimeexception);
            smsmessage = null;
        }
        return smsmessage;
    }

    public static SmsMessage createFromPdu(byte abyte0[]) {
        SmsMessage smsmessage;
        try {
            smsmessage = new SmsMessage();
            smsmessage.parsePdu(abyte0);
        }
        catch(RuntimeException runtimeexception) {
            Log.e("GSM", "SMS PDU parsing failed: ", runtimeexception);
            smsmessage = null;
        }
        return smsmessage;
    }

    private static byte[] encodeUCS2(String s, byte abyte0[]) throws UnsupportedEncodingException {
        byte abyte1[] = s.getBytes("utf-16be");
        byte abyte2[];
        byte abyte3[];
        if(abyte0 != null) {
            abyte2 = new byte[1 + (abyte0.length + abyte1.length)];
            abyte2[0] = (byte)abyte0.length;
            System.arraycopy(abyte0, 0, abyte2, 1, abyte0.length);
            System.arraycopy(abyte1, 0, abyte2, 1 + abyte0.length, abyte1.length);
        } else {
            abyte2 = abyte1;
        }
        abyte3 = new byte[1 + abyte2.length];
        abyte3[0] = (byte)(0xff & abyte2.length);
        System.arraycopy(abyte2, 0, abyte3, 1, abyte2.length);
        return abyte3;
    }

    public static SubmitPdu getSubmitPdu(String s, String s1, int i, byte abyte0[], boolean flag) {
        com.android.internal.telephony.SmsHeader.PortAddrs portaddrs = new com.android.internal.telephony.SmsHeader.PortAddrs();
        portaddrs.destPort = i;
        portaddrs.origPort = 0;
        portaddrs.areEightBits = false;
        SmsHeader smsheader = new SmsHeader();
        smsheader.portAddrs = portaddrs;
        byte abyte1[] = SmsHeader.toByteArray(smsheader);
        SubmitPdu submitpdu;
        if(1 + (abyte0.length + abyte1.length) > 140) {
            Log.e("GSM", (new StringBuilder()).append("SMS data message may only contain ").append(-1 + (140 - abyte1.length)).append(" bytes").toString());
            submitpdu = null;
        } else {
            submitpdu = new SubmitPdu();
            ByteArrayOutputStream bytearrayoutputstream = getSubmitPduHead(s, s1, (byte)65, flag, submitpdu);
            bytearrayoutputstream.write(4);
            bytearrayoutputstream.write(1 + (abyte0.length + abyte1.length));
            bytearrayoutputstream.write(abyte1.length);
            bytearrayoutputstream.write(abyte1, 0, abyte1.length);
            bytearrayoutputstream.write(abyte0, 0, abyte0.length);
            submitpdu.encodedMessage = bytearrayoutputstream.toByteArray();
        }
        return submitpdu;
    }

    public static SubmitPdu getSubmitPdu(String s, String s1, String s2, boolean flag) {
        return getSubmitPdu(s, s1, s2, flag, ((byte []) (null)));
    }

    public static SubmitPdu getSubmitPdu(String s, String s1, String s2, boolean flag, byte abyte0[]) {
        return getSubmitPdu(s, s1, s2, flag, abyte0, 0, 0, 0);
    }

    public static SubmitPdu getSubmitPdu(String s, String s1, String s2, boolean flag, byte abyte0[], int i, int j, int k) {
        if(s2 != null && s1 != null) goto _L2; else goto _L1
_L1:
        SubmitPdu submitpdu = null;
_L9:
        return submitpdu;
_L2:
        ByteArrayOutputStream bytearrayoutputstream;
        byte abyte2[];
        byte byte0;
        if(i == 0) {
            com.android.internal.telephony.SmsMessageBase.TextEncodingDetails textencodingdetails = calculateLength(s2, false);
            i = textencodingdetails.codeUnitSize;
            j = textencodingdetails.languageTable;
            k = textencodingdetails.languageShiftTable;
            byte abyte4[];
            if(i == 1 && (j != 0 || k != 0))
                if(abyte0 != null) {
                    SmsHeader smsheader1 = SmsHeader.fromByteArray(abyte0);
                    if(smsheader1.languageTable != j || smsheader1.languageShiftTable != k) {
                        Log.w("GSM", (new StringBuilder()).append("Updating language table in SMS header: ").append(smsheader1.languageTable).append(" -> ").append(j).append(", ").append(smsheader1.languageShiftTable).append(" -> ").append(k).toString());
                        smsheader1.languageTable = j;
                        smsheader1.languageShiftTable = k;
                        abyte0 = SmsHeader.toByteArray(smsheader1);
                    }
                } else {
                    SmsHeader smsheader = new SmsHeader();
                    smsheader.languageTable = j;
                    smsheader.languageShiftTable = k;
                    abyte0 = SmsHeader.toByteArray(smsheader);
                }
        }
        submitpdu = new SubmitPdu();
        if(abyte0 != null)
            byte0 = 64;
        else
            byte0 = 0;
        bytearrayoutputstream = getSubmitPduHead(s, s1, (byte)(byte0 | 1), flag, submitpdu);
        if(i != 1) goto _L4; else goto _L3
_L3:
        abyte4 = GsmAlphabet.stringToGsm7BitPackedWithHeader(s2, abyte0, j, k);
        abyte2 = abyte4;
_L10:
        if(i != 1) goto _L6; else goto _L5
_L5:
        if((0xff & abyte2[0]) <= 160) goto _L8; else goto _L7
_L7:
        Log.e("GSM", (new StringBuilder()).append("Message too long (").append(0xff & abyte2[0]).append(" septets)").toString());
        submitpdu = null;
          goto _L9
_L4:
        byte abyte3[] = encodeUCS2(s2, abyte0);
        abyte2 = abyte3;
          goto _L10
        UnsupportedEncodingException unsupportedencodingexception1;
        unsupportedencodingexception1;
        Log.e("GSM", "Implausible UnsupportedEncodingException ", unsupportedencodingexception1);
        submitpdu = null;
          goto _L9
        EncodeException encodeexception;
        encodeexception;
        byte abyte1[] = encodeUCS2(s2, abyte0);
        abyte2 = abyte1;
        i = 3;
          goto _L10
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        Log.e("GSM", "Implausible UnsupportedEncodingException ", unsupportedencodingexception);
        submitpdu = null;
          goto _L9
_L8:
        bytearrayoutputstream.write(0);
_L11:
        bytearrayoutputstream.write(abyte2, 0, abyte2.length);
        submitpdu.encodedMessage = bytearrayoutputstream.toByteArray();
          goto _L9
_L6:
label0:
        {
            if((0xff & abyte2[0]) <= 140)
                break label0;
            Log.e("GSM", (new StringBuilder()).append("Message too long (").append(0xff & abyte2[0]).append(" bytes)").toString());
            submitpdu = null;
        }
          goto _L9
        bytearrayoutputstream.write(8);
          goto _L11
    }

    private static ByteArrayOutputStream getSubmitPduHead(String s, String s1, byte byte0, boolean flag, SubmitPdu submitpdu) {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream(180);
        byte abyte0[];
        int i;
        int j;
        if(s == null)
            submitpdu.encodedScAddress = null;
        else
            submitpdu.encodedScAddress = PhoneNumberUtils.networkPortionToCalledPartyBCDWithLength(s);
        if(flag)
            byte0 |= 0x20;
        bytearrayoutputstream.write(byte0);
        bytearrayoutputstream.write(0);
        abyte0 = PhoneNumberUtils.networkPortionToCalledPartyBCD(s1);
        i = 2 * (-1 + abyte0.length);
        if((0xf0 & abyte0[-1 + abyte0.length]) == 240)
            j = 1;
        else
            j = 0;
        bytearrayoutputstream.write(i - j);
        bytearrayoutputstream.write(abyte0, 0, abyte0.length);
        bytearrayoutputstream.write(0);
        return bytearrayoutputstream;
    }

    public static int getTPLayerLengthForPDU(String s) {
        return -1 + (s.length() / 2 - Integer.parseInt(s.substring(0, 2), 16));
    }

    public static SmsMessage newFromCDS(String s) {
        SmsMessage smsmessage;
        try {
            smsmessage = new SmsMessage();
            smsmessage.parsePdu(IccUtils.hexStringToBytes(s));
        }
        catch(RuntimeException runtimeexception) {
            Log.e("GSM", "CDS SMS PDU parsing failed: ", runtimeexception);
            smsmessage = null;
        }
        return smsmessage;
    }

    public static SmsMessage newFromCMT(String as[]) {
        SmsMessage smsmessage;
        try {
            smsmessage = new SmsMessage();
            smsmessage.parsePdu(IccUtils.hexStringToBytes(as[1]));
        }
        catch(RuntimeException runtimeexception) {
            Log.e("GSM", "SMS PDU parsing failed: ", runtimeexception);
            smsmessage = null;
        }
        return smsmessage;
    }

    private void parsePdu(byte abyte0[]) {
        PduParser pduparser;
        int i;
        super.mPdu = abyte0;
        pduparser = new PduParser(abyte0);
        super.scAddress = pduparser.getSCAddress();
        i = pduparser.getByte();
        mti = i & 3;
        mti;
        JVM INSTR tableswitch 0 3: default 68
    //                   0 79
    //                   1 86
    //                   2 95
    //                   3 79;
           goto _L1 _L2 _L3 _L4 _L2
_L1:
        throw new RuntimeException("Unsupported message type");
_L2:
        parseSmsDeliver(pduparser, i);
_L6:
        return;
_L3:
        parseSmsSubmit(pduparser, i);
        continue; /* Loop/switch isn't completed */
_L4:
        parseSmsStatusReport(pduparser, i);
        if(true) goto _L6; else goto _L5
_L5:
    }

    private void parseSmsDeliver(PduParser pduparser, int i) {
        boolean flag;
        boolean flag1;
        if((i & 0x80) == 128)
            flag = true;
        else
            flag = false;
        replyPathPresent = flag;
        super.originatingAddress = pduparser.getAddress();
        if(super.originatingAddress == null);
        protocolIdentifier = pduparser.getByte();
        dataCodingScheme = pduparser.getByte();
        super.scTimeMillis = pduparser.getSCTimestampMillis();
        if((i & 0x40) == 64)
            flag1 = true;
        else
            flag1 = false;
        parseUserData(pduparser, flag1);
    }

    private void parseSmsStatusReport(PduParser pduparser, int i) {
        isStatusReportMessage = true;
        boolean flag;
        if((i & 0x20) == 0)
            flag = true;
        else
            flag = false;
        forSubmit = flag;
        super.messageRef = pduparser.getByte();
        recipientAddress = pduparser.getAddress();
        super.scTimeMillis = pduparser.getSCTimestampMillis();
        dischargeTimeMillis = pduparser.getSCTimestampMillis();
        status = pduparser.getByte();
        if(pduparser.moreDataPresent()) {
            int j = pduparser.getByte();
            for(int k = j; (k & 0x80) != 0; k = pduparser.getByte());
            if((j & 1) != 0)
                protocolIdentifier = pduparser.getByte();
            if((j & 2) != 0)
                dataCodingScheme = pduparser.getByte();
            if((j & 4) != 0) {
                boolean flag1;
                if((i & 0x40) == 64)
                    flag1 = true;
                else
                    flag1 = false;
                parseUserData(pduparser, flag1);
            }
        }
    }

    private void parseSmsSubmit(PduParser pduparser, int i) {
        boolean flag;
        boolean flag1;
        if((i & 0x80) == 128)
            flag = true;
        else
            flag = false;
        replyPathPresent = flag;
        super.messageRef = pduparser.getByte();
        recipientAddress = pduparser.getAddress();
        if(recipientAddress != null)
            Log.v("GSM", (new StringBuilder()).append("SMS recipient address: ").append(((SmsAddress) (recipientAddress)).address).toString());
        protocolIdentifier = pduparser.getByte();
        dataCodingScheme = pduparser.getByte();
        if((i & 0x40) == 64)
            flag1 = true;
        else
            flag1 = false;
        parseUserData(pduparser, flag1);
    }

    private void parseUserData(PduParser pduparser, boolean flag) {
        boolean flag1;
        int i;
        boolean flag2;
        int j;
        flag1 = true;
        i = 0;
        flag2 = false;
        j = 0;
        if((0x80 & dataCodingScheme) != 0) goto _L2; else goto _L1
_L1:
        int k;
        boolean flag5;
        boolean flag6;
        if((0x40 & dataCodingScheme) != 0)
            flag5 = flag1;
        else
            flag5 = false;
        automaticDeletion = flag5;
        if((0x20 & dataCodingScheme) != 0)
            flag6 = flag1;
        else
            flag6 = false;
        if((0x10 & dataCodingScheme) != 0)
            flag2 = flag1;
        else
            flag2 = false;
        if(!flag6) goto _L4; else goto _L3
_L3:
        Log.w("GSM", (new StringBuilder()).append("4 - Unsupported SMS data coding scheme (compression) ").append(0xff & dataCodingScheme).toString());
_L15:
        boolean flag3;
        boolean flag4;
        if(j != flag1)
            flag1 = false;
        k = pduparser.constructUserData(flag, flag1);
        super.userData = pduparser.getUserData();
        super.userDataHeader = pduparser.getUserDataHeader();
        j;
        JVM INSTR tableswitch 0 4: default 172
    //                   0 635
    //                   1 643
    //                   2 635
    //                   3 692
    //                   4 705;
           goto _L5 _L6 _L7 _L6 _L8 _L9
_L5:
        if(super.messageBody != null)
            parseMessageBody();
        if(flag2) goto _L11; else goto _L10
_L10:
        messageClass = android.telephony.MessageClass.UNKNOWN;
_L13:
        return;
_L4:
        switch(3 & dataCodingScheme >> 2) {
        case 0: // '\0'
            j = 1;
            break;

        case 2: // '\002'
            j = 3;
            break;

        case 1: // '\001'
        case 3: // '\003'
            Log.w("GSM", (new StringBuilder()).append("1 - Unsupported SMS data coding scheme ").append(0xff & dataCodingScheme).toString());
            j = 2;
            break;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if((0xf0 & dataCodingScheme) == 240) {
            automaticDeletion = false;
            flag2 = true;
            if((4 & dataCodingScheme) == 0)
                j = 1;
            else
                j = 2;
        } else
        if((0xf0 & dataCodingScheme) == 192 || (0xf0 & dataCodingScheme) == 208 || (0xf0 & dataCodingScheme) == 224) {
            if((0xf0 & dataCodingScheme) == 224)
                j = 3;
            else
                j = 1;
            if((8 & dataCodingScheme) == 8)
                flag3 = flag1;
            else
                flag3 = false;
            if((3 & dataCodingScheme) == 0) {
                super.isMwi = flag1;
                super.mwiSense = flag3;
                if((0xf0 & dataCodingScheme) == 192)
                    flag4 = flag1;
                else
                    flag4 = false;
                super.mwiDontStore = flag4;
            } else {
                super.isMwi = false;
                Log.w("GSM", (new StringBuilder()).append("MWI for fax, email, or other ").append(0xff & dataCodingScheme).toString());
            }
        } else
        if((0xc0 & dataCodingScheme) == 128) {
            if(dataCodingScheme == 132)
                j = 4;
            else
                Log.w("GSM", (new StringBuilder()).append("5 - Unsupported SMS data coding scheme ").append(0xff & dataCodingScheme).toString());
        } else {
            Log.w("GSM", (new StringBuilder()).append("3 - Unsupported SMS data coding scheme ").append(0xff & dataCodingScheme).toString());
        }
        continue; /* Loop/switch isn't completed */
_L6:
        super.messageBody = null;
          goto _L5
_L7:
        int l;
        if(flag)
            l = super.userDataHeader.languageTable;
        else
            l = 0;
        if(flag)
            i = super.userDataHeader.languageShiftTable;
        super.messageBody = pduparser.getUserDataGSM7Bit(k, l, i);
          goto _L5
_L8:
        super.messageBody = pduparser.getUserDataUCS2(k);
          goto _L5
_L9:
        super.messageBody = pduparser.getUserDataKSC5601(k);
          goto _L5
_L11:
        switch(3 & dataCodingScheme) {
        case 0: // '\0'
            messageClass = android.telephony.MessageClass.CLASS_0;
            break;

        case 1: // '\001'
            messageClass = android.telephony.MessageClass.CLASS_1;
            break;

        case 2: // '\002'
            messageClass = android.telephony.MessageClass.CLASS_2;
            break;

        case 3: // '\003'
            messageClass = android.telephony.MessageClass.CLASS_3;
            break;
        }
        if(true) goto _L13; else goto _L12
_L12:
        if(true) goto _L15; else goto _L14
_L14:
    }

    int getDataCodingScheme() {
        return dataCodingScheme;
    }

    public android.telephony.MessageClass getMessageClass() {
        return messageClass;
    }

    public int getProtocolIdentifier() {
        return protocolIdentifier;
    }

    public String getRecipientAddress() {
        String s;
        if(recipientAddress != null) {
            s = recipientAddress.getAddressString();
        } else {
            Log.v("GSM", "SMS recipient address is null");
            s = null;
        }
        return s;
    }

    public int getStatus() {
        return status;
    }

    public boolean isCphsMwiMessage() {
        boolean flag;
        if(((GsmSmsAddress)super.originatingAddress).isCphsVoiceMessageClear() || ((GsmSmsAddress)super.originatingAddress).isCphsVoiceMessageSet())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isMWIClearMessage() {
        boolean flag = true;
        if(!super.isMwi || super.mwiSense) {
            boolean flag1;
            if(super.originatingAddress != null && ((GsmSmsAddress)super.originatingAddress).isCphsVoiceMessageClear())
                flag1 = flag;
            else
                flag1 = false;
            flag = flag1;
        }
        return flag;
    }

    public boolean isMWISetMessage() {
        boolean flag = true;
        if(!super.isMwi || !super.mwiSense) {
            boolean flag1;
            if(super.originatingAddress != null && ((GsmSmsAddress)super.originatingAddress).isCphsVoiceMessageSet())
                flag1 = flag;
            else
                flag1 = false;
            flag = flag1;
        }
        return flag;
    }

    public boolean isMwiDontStore() {
        boolean flag = true;
        if(!super.isMwi || !super.mwiDontStore)
            if(isCphsMwiMessage()) {
                if(!" ".equals(getMessageBody()));
            } else {
                flag = false;
            }
        return flag;
    }

    public boolean isReplace() {
        boolean flag;
        if((0xc0 & protocolIdentifier) == 64 && (0x3f & protocolIdentifier) > 0 && (0x3f & protocolIdentifier) < 8)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isReplyPathPresent() {
        return replyPathPresent;
    }

    public boolean isStatusReportMessage() {
        return isStatusReportMessage;
    }

    public boolean isTypeZero() {
        boolean flag;
        if(protocolIdentifier == 64)
            flag = true;
        else
            flag = false;
        return flag;
    }

    boolean isUsimDataDownload() {
        boolean flag;
        if(messageClass == android.telephony.MessageClass.CLASS_2 && (protocolIdentifier == 127 || protocolIdentifier == 124))
            flag = true;
        else
            flag = false;
        return flag;
    }

    static final String LOG_TAG = "GSM";
    private boolean automaticDeletion;
    private int dataCodingScheme;
    private long dischargeTimeMillis;
    private boolean forSubmit;
    private boolean isStatusReportMessage;
    private android.telephony.MessageClass messageClass;
    private int mti;
    private int protocolIdentifier;
    private GsmSmsAddress recipientAddress;
    private boolean replyPathPresent;
    private int status;
}
