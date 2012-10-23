// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cdma;

import android.os.Parcel;
import android.os.SystemProperties;
import android.telephony.*;
import android.util.Log;
import com.android.internal.telephony.*;
import com.android.internal.telephony.cdma.sms.BearerData;
import com.android.internal.telephony.cdma.sms.CdmaSmsAddress;
import com.android.internal.telephony.cdma.sms.CdmaSmsSubaddress;
import com.android.internal.telephony.cdma.sms.SmsEnvelope;
import com.android.internal.telephony.cdma.sms.UserData;
import com.android.internal.util.BitwiseInputStream;
import com.android.internal.util.HexDump;
import java.io.*;
import java.util.List;

public class SmsMessage extends SmsMessageBase {
    public static class SubmitPdu extends com.android.internal.telephony.SmsMessageBase.SubmitPduBase {

        public SubmitPdu() {
        }
    }


    public SmsMessage() {
    }

    public static com.android.internal.telephony.SmsMessageBase.TextEncodingDetails calculateLength(CharSequence charsequence, boolean flag) {
        return BearerData.calcTextEncodingDetails(charsequence, flag);
    }

    private byte convertDtmfToAscii(byte byte0) {
        byte0;
        JVM INSTR tableswitch 0 15: default 80
    //                   0 85
    //                   1 91
    //                   2 97
    //                   3 103
    //                   4 109
    //                   5 115
    //                   6 121
    //                   7 127
    //                   8 133
    //                   9 139
    //                   10 145
    //                   11 151
    //                   12 157
    //                   13 163
    //                   14 169
    //                   15 175;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17
_L1:
        byte byte1 = 32;
_L19:
        return byte1;
_L2:
        byte1 = 68;
        continue; /* Loop/switch isn't completed */
_L3:
        byte1 = 49;
        continue; /* Loop/switch isn't completed */
_L4:
        byte1 = 50;
        continue; /* Loop/switch isn't completed */
_L5:
        byte1 = 51;
        continue; /* Loop/switch isn't completed */
_L6:
        byte1 = 52;
        continue; /* Loop/switch isn't completed */
_L7:
        byte1 = 53;
        continue; /* Loop/switch isn't completed */
_L8:
        byte1 = 54;
        continue; /* Loop/switch isn't completed */
_L9:
        byte1 = 55;
        continue; /* Loop/switch isn't completed */
_L10:
        byte1 = 56;
        continue; /* Loop/switch isn't completed */
_L11:
        byte1 = 57;
        continue; /* Loop/switch isn't completed */
_L12:
        byte1 = 48;
        continue; /* Loop/switch isn't completed */
_L13:
        byte1 = 42;
        continue; /* Loop/switch isn't completed */
_L14:
        byte1 = 35;
        continue; /* Loop/switch isn't completed */
_L15:
        byte1 = 65;
        continue; /* Loop/switch isn't completed */
_L16:
        byte1 = 66;
        continue; /* Loop/switch isn't completed */
_L17:
        byte1 = 67;
        if(true) goto _L19; else goto _L18
_L18:
    }

    public static SmsMessage createFromEfRecord(int i, byte abyte0[]) {
        SmsMessage smsmessage;
        try {
            smsmessage = new SmsMessage();
            smsmessage.indexOnIcc = i;
            if((1 & abyte0[0]) == 0) {
                Log.w("CDMA", "SMS parsing failed: Trying to parse a free record");
                smsmessage = null;
            } else {
                smsmessage.statusOnIcc = 7 & abyte0[0];
                byte byte0 = abyte0[1];
                byte abyte1[] = new byte[byte0];
                System.arraycopy(abyte0, 2, abyte1, 0, byte0);
                smsmessage.parsePduFromEfRecord(abyte1);
            }
        }
        catch(RuntimeException runtimeexception) {
            Log.e("CDMA", "SMS PDU parsing failed: ", runtimeexception);
            smsmessage = null;
        }
        return smsmessage;
    }

    public static SmsMessage createFromPdu(byte abyte0[]) {
        SmsMessage smsmessage = new SmsMessage();
        try {
            smsmessage.parsePdu(abyte0);
        }
        catch(RuntimeException runtimeexception) {
            Log.e("CDMA", "SMS PDU parsing failed: ", runtimeexception);
            smsmessage = null;
        }
        return smsmessage;
    }

    private void createPdu() {
        SmsEnvelope smsenvelope;
        CdmaSmsAddress cdmasmsaddress;
        ByteArrayOutputStream bytearrayoutputstream;
        DataOutputStream dataoutputstream;
        smsenvelope = mEnvelope;
        cdmasmsaddress = smsenvelope.origAddress;
        bytearrayoutputstream = new ByteArrayOutputStream(100);
        dataoutputstream = new DataOutputStream(new BufferedOutputStream(bytearrayoutputstream));
        dataoutputstream.writeInt(smsenvelope.messageType);
        dataoutputstream.writeInt(smsenvelope.teleService);
        dataoutputstream.writeInt(smsenvelope.serviceCategory);
        dataoutputstream.writeByte(cdmasmsaddress.digitMode);
        dataoutputstream.writeByte(cdmasmsaddress.numberMode);
        dataoutputstream.writeByte(((SmsAddress) (cdmasmsaddress)).ton);
        dataoutputstream.writeByte(cdmasmsaddress.numberPlan);
        dataoutputstream.writeByte(cdmasmsaddress.numberOfDigits);
        dataoutputstream.write(((SmsAddress) (cdmasmsaddress)).origBytes, 0, ((SmsAddress) (cdmasmsaddress)).origBytes.length);
        dataoutputstream.writeInt(smsenvelope.bearerReply);
        dataoutputstream.writeByte(smsenvelope.replySeqNo);
        dataoutputstream.writeByte(smsenvelope.errorClass);
        dataoutputstream.writeByte(smsenvelope.causeCode);
        dataoutputstream.writeInt(smsenvelope.bearerData.length);
        dataoutputstream.write(smsenvelope.bearerData, 0, smsenvelope.bearerData.length);
        dataoutputstream.close();
        super.mPdu = bytearrayoutputstream.toByteArray();
_L1:
        return;
        IOException ioexception;
        ioexception;
        Log.e("CDMA", (new StringBuilder()).append("createPdu: conversion from object to byte array failed: ").append(ioexception).toString());
          goto _L1
    }

    /**
     * @deprecated Method getNextMessageId is deprecated
     */

    private static int getNextMessageId() {
        com/android/internal/telephony/cdma/SmsMessage;
        JVM INSTR monitorenter ;
        int i;
        i = SystemProperties.getInt("persist.radio.cdma.msgid", 1);
        String s = Integer.toString(1 + i % 65535);
        SystemProperties.set("persist.radio.cdma.msgid", s);
        if(Log.isLoggable("CDMA:SMS", 2)) {
            Log.d("CDMA", (new StringBuilder()).append("next persist.radio.cdma.msgid = ").append(s).toString());
            Log.d("CDMA", (new StringBuilder()).append("readback gets ").append(SystemProperties.get("persist.radio.cdma.msgid")).toString());
        }
        com/android/internal/telephony/cdma/SmsMessage;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public static SubmitPdu getSubmitPdu(String s, UserData userdata, boolean flag) {
        return privateGetSubmitPdu(s, flag, userdata);
    }

    public static SubmitPdu getSubmitPdu(String s, String s1, int i, byte abyte0[], boolean flag) {
        com.android.internal.telephony.SmsHeader.PortAddrs portaddrs = new com.android.internal.telephony.SmsHeader.PortAddrs();
        portaddrs.destPort = i;
        portaddrs.origPort = 0;
        portaddrs.areEightBits = false;
        SmsHeader smsheader = new SmsHeader();
        smsheader.portAddrs = portaddrs;
        UserData userdata = new UserData();
        userdata.userDataHeader = smsheader;
        userdata.msgEncoding = 0;
        userdata.msgEncodingSet = true;
        userdata.payload = abyte0;
        return privateGetSubmitPdu(s1, flag, userdata);
    }

    public static SubmitPdu getSubmitPdu(String s, String s1, String s2, boolean flag, SmsHeader smsheader) {
        SubmitPdu submitpdu;
        if(s2 == null || s1 == null) {
            submitpdu = null;
        } else {
            UserData userdata = new UserData();
            userdata.payloadStr = s2;
            userdata.userDataHeader = smsheader;
            submitpdu = privateGetSubmitPdu(s1, flag, userdata);
        }
        return submitpdu;
    }

    public static int getTPLayerLengthForPDU(String s) {
        Log.w("CDMA", "getTPLayerLengthForPDU: is not supported in CDMA mode.");
        return 0;
    }

    public static SmsMessage newFromParcel(Parcel parcel) {
        SmsMessage smsmessage = new SmsMessage();
        SmsEnvelope smsenvelope = new SmsEnvelope();
        CdmaSmsAddress cdmasmsaddress = new CdmaSmsAddress();
        CdmaSmsSubaddress cdmasmssubaddress = new CdmaSmsSubaddress();
        smsenvelope.teleService = parcel.readInt();
        int i;
        int j;
        byte abyte0[];
        if(parcel.readByte() != 0)
            smsenvelope.messageType = 1;
        else
        if(smsenvelope.teleService == 0)
            smsenvelope.messageType = 2;
        else
            smsenvelope.messageType = 0;
        smsenvelope.serviceCategory = parcel.readInt();
        i = parcel.readInt();
        cdmasmsaddress.digitMode = (byte)(i & 0xff);
        cdmasmsaddress.numberMode = (byte)(0xff & parcel.readInt());
        cdmasmsaddress.ton = parcel.readInt();
        cdmasmsaddress.numberPlan = (byte)(0xff & parcel.readInt());
        j = parcel.readByte();
        cdmasmsaddress.numberOfDigits = j;
        abyte0 = new byte[j];
        for(int k = 0; k < j; k++) {
            abyte0[k] = parcel.readByte();
            if(i == 0)
                abyte0[k] = smsmessage.convertDtmfToAscii(abyte0[k]);
        }

        cdmasmsaddress.origBytes = abyte0;
        cdmasmssubaddress.type = parcel.readInt();
        cdmasmssubaddress.odd = parcel.readByte();
        byte byte0 = parcel.readByte();
        if(byte0 < 0)
            byte0 = 0;
        byte abyte1[] = new byte[byte0];
        for(int l = 0; l < byte0; l++)
            abyte1[l] = parcel.readByte();

        cdmasmssubaddress.origBytes = abyte1;
        int i1 = parcel.readInt();
        if(i1 < 0)
            i1 = 0;
        byte abyte2[] = new byte[i1];
        for(int j1 = 0; j1 < i1; j1++)
            abyte2[j1] = parcel.readByte();

        smsenvelope.bearerData = abyte2;
        smsenvelope.origAddress = cdmasmsaddress;
        smsenvelope.origSubaddress = cdmasmssubaddress;
        smsmessage.originatingAddress = cdmasmsaddress;
        smsmessage.mEnvelope = smsenvelope;
        smsmessage.createPdu();
        return smsmessage;
    }

    private void parsePdu(byte abyte0[]) {
        DataInputStream datainputstream = new DataInputStream(new ByteArrayInputStream(abyte0));
        SmsEnvelope smsenvelope = new SmsEnvelope();
        CdmaSmsAddress cdmasmsaddress = new CdmaSmsAddress();
        try {
            smsenvelope.messageType = datainputstream.readInt();
            smsenvelope.teleService = datainputstream.readInt();
            smsenvelope.serviceCategory = datainputstream.readInt();
            cdmasmsaddress.digitMode = datainputstream.readByte();
            cdmasmsaddress.numberMode = datainputstream.readByte();
            cdmasmsaddress.ton = datainputstream.readByte();
            cdmasmsaddress.numberPlan = datainputstream.readByte();
            int i = datainputstream.readByte();
            cdmasmsaddress.numberOfDigits = i;
            cdmasmsaddress.origBytes = new byte[i];
            datainputstream.read(((SmsAddress) (cdmasmsaddress)).origBytes, 0, i);
            smsenvelope.bearerReply = datainputstream.readInt();
            smsenvelope.replySeqNo = datainputstream.readByte();
            smsenvelope.errorClass = datainputstream.readByte();
            smsenvelope.causeCode = datainputstream.readByte();
            int j = datainputstream.readInt();
            smsenvelope.bearerData = new byte[j];
            datainputstream.read(smsenvelope.bearerData, 0, j);
            datainputstream.close();
        }
        catch(Exception exception) {
            Log.e("CDMA", (new StringBuilder()).append("createFromPdu: conversion from byte array to object failed: ").append(exception).toString());
        }
        super.originatingAddress = cdmasmsaddress;
        smsenvelope.origAddress = cdmasmsaddress;
        mEnvelope = smsenvelope;
        super.mPdu = abyte0;
        parseSms();
    }

    private void parsePduFromEfRecord(byte abyte0[]) {
        ByteArrayInputStream bytearrayinputstream;
        DataInputStream datainputstream;
        SmsEnvelope smsenvelope;
        CdmaSmsAddress cdmasmsaddress;
        CdmaSmsSubaddress cdmasmssubaddress;
        bytearrayinputstream = new ByteArrayInputStream(abyte0);
        datainputstream = new DataInputStream(bytearrayinputstream);
        smsenvelope = new SmsEnvelope();
        cdmasmsaddress = new CdmaSmsAddress();
        cdmasmssubaddress = new CdmaSmsSubaddress();
        smsenvelope.messageType = datainputstream.readByte();
_L11:
        if(datainputstream.available() <= 0) goto _L2; else goto _L1
_L1:
        byte byte0;
        byte byte1;
        byte abyte1[];
        byte0 = datainputstream.readByte();
        byte1 = datainputstream.readByte();
        abyte1 = new byte[byte1];
        byte0;
        JVM INSTR tableswitch 0 8: default 132
    //                   0 232
    //                   1 274
    //                   2 286
    //                   3 595
    //                   4 286
    //                   5 595
    //                   6 701
    //                   7 737
    //                   8 810;
           goto _L3 _L4 _L5 _L6 _L7 _L6 _L7 _L8 _L9 _L10
_L3:
        throw new Exception((new StringBuilder()).append("unsupported parameterId (").append(byte0).append(")").toString());
        Exception exception;
        exception;
        Log.e("CDMA", (new StringBuilder()).append("parsePduFromEfRecord: conversion from pdu to SmsMessage failed").append(exception).toString());
_L12:
        super.originatingAddress = cdmasmsaddress;
        smsenvelope.origAddress = cdmasmsaddress;
        smsenvelope.origSubaddress = cdmasmssubaddress;
        mEnvelope = smsenvelope;
        super.mPdu = abyte0;
        parseSms();
        return;
_L4:
        smsenvelope.teleService = datainputstream.readUnsignedShort();
        Log.i("CDMA", (new StringBuilder()).append("teleservice = ").append(smsenvelope.teleService).toString());
          goto _L11
_L5:
        smsenvelope.serviceCategory = datainputstream.readUnsignedShort();
          goto _L11
_L6:
        datainputstream.read(abyte1, 0, byte1);
        BitwiseInputStream bitwiseinputstream3 = new BitwiseInputStream(abyte1);
        cdmasmsaddress.digitMode = bitwiseinputstream3.read(1);
        cdmasmsaddress.numberMode = bitwiseinputstream3.read(1);
        int k = 0;
        if(cdmasmsaddress.digitMode == 1) {
            k = bitwiseinputstream3.read(3);
            cdmasmsaddress.ton = k;
            if(cdmasmsaddress.numberMode == 0)
                cdmasmsaddress.numberPlan = bitwiseinputstream3.read(4);
        }
        cdmasmsaddress.numberOfDigits = bitwiseinputstream3.read(8);
        byte abyte3[] = new byte[cdmasmsaddress.numberOfDigits];
        if(cdmasmsaddress.digitMode == 0) {
            for(int i1 = 0; i1 < cdmasmsaddress.numberOfDigits; i1++)
                abyte3[i1] = convertDtmfToAscii((byte)(0xf & bitwiseinputstream3.read(4)));

        } else
        if(cdmasmsaddress.digitMode == 1) {
            if(cdmasmsaddress.numberMode == 0) {
                for(int l = 0; l < cdmasmsaddress.numberOfDigits; l++)
                    abyte3[l] = (byte)(0xff & bitwiseinputstream3.read(8));

            } else
            if(cdmasmsaddress.numberMode == 1) {
                if(k == 2)
                    Log.e("CDMA", "TODO: Originating Addr is email id");
                else
                    Log.e("CDMA", "TODO: Originating Addr is data network address");
            } else {
                Log.e("CDMA", "Originating Addr is of incorrect type");
            }
        } else {
            Log.e("CDMA", "Incorrect Digit mode");
        }
        cdmasmsaddress.origBytes = abyte3;
        Log.i("CDMA", (new StringBuilder()).append("Originating Addr=").append(cdmasmsaddress.toString()).toString());
          goto _L11
_L7:
        datainputstream.read(abyte1, 0, byte1);
        BitwiseInputStream bitwiseinputstream2 = new BitwiseInputStream(abyte1);
        cdmasmssubaddress.type = bitwiseinputstream2.read(3);
        cdmasmssubaddress.odd = bitwiseinputstream2.readByteArray(1)[0];
        int i = bitwiseinputstream2.read(8);
        byte abyte2[] = new byte[i];
        for(int j = 0; j < i; j++)
            abyte2[j] = convertDtmfToAscii((byte)(0xff & bitwiseinputstream2.read(4)));

        cdmasmssubaddress.origBytes = abyte2;
          goto _L11
_L8:
        datainputstream.read(abyte1, 0, byte1);
        BitwiseInputStream bitwiseinputstream1 = new BitwiseInputStream(abyte1);
        smsenvelope.bearerReply = bitwiseinputstream1.read(6);
          goto _L11
_L9:
        datainputstream.read(abyte1, 0, byte1);
        BitwiseInputStream bitwiseinputstream = new BitwiseInputStream(abyte1);
        smsenvelope.replySeqNo = bitwiseinputstream.readByteArray(6)[0];
        smsenvelope.errorClass = bitwiseinputstream.readByteArray(2)[0];
        if(smsenvelope.errorClass != 0)
            smsenvelope.causeCode = bitwiseinputstream.readByteArray(8)[0];
          goto _L11
_L10:
        datainputstream.read(abyte1, 0, byte1);
        smsenvelope.bearerData = abyte1;
          goto _L11
_L2:
        bytearrayinputstream.close();
        datainputstream.close();
          goto _L12
    }

    private static SubmitPdu privateGetSubmitPdu(String s, boolean flag, UserData userdata) {
        CdmaSmsAddress cdmasmsaddress = CdmaSmsAddress.parse(PhoneNumberUtils.cdmaCheckAndProcessPlusCode(s));
        SubmitPdu submitpdu;
        if(cdmasmsaddress == null) {
            submitpdu = null;
        } else {
            BearerData bearerdata = new BearerData();
            bearerdata.messageType = 2;
            bearerdata.messageId = getNextMessageId();
            bearerdata.deliveryAckReq = flag;
            bearerdata.userAckReq = false;
            bearerdata.readAckReq = false;
            bearerdata.reportReq = false;
            bearerdata.userData = userdata;
            byte abyte0[] = BearerData.encode(bearerdata);
            if(Log.isLoggable("CDMA:SMS", 2)) {
                Log.d("CDMA", (new StringBuilder()).append("MO (encoded) BearerData = ").append(bearerdata).toString());
                Log.d("CDMA", (new StringBuilder()).append("MO raw BearerData = '").append(HexDump.toHexString(abyte0)).append("'").toString());
            }
            if(abyte0 == null) {
                submitpdu = null;
            } else {
                int i;
                SmsEnvelope smsenvelope;
                if(bearerdata.hasUserDataHeader)
                    i = 4101;
                else
                    i = 4098;
                smsenvelope = new SmsEnvelope();
                smsenvelope.messageType = 0;
                smsenvelope.teleService = i;
                smsenvelope.destAddress = cdmasmsaddress;
                smsenvelope.bearerReply = 1;
                smsenvelope.bearerData = abyte0;
                try {
                    ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream(100);
                    DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
                    dataoutputstream.writeInt(smsenvelope.teleService);
                    dataoutputstream.writeInt(0);
                    dataoutputstream.writeInt(0);
                    dataoutputstream.write(cdmasmsaddress.digitMode);
                    dataoutputstream.write(cdmasmsaddress.numberMode);
                    dataoutputstream.write(((SmsAddress) (cdmasmsaddress)).ton);
                    dataoutputstream.write(cdmasmsaddress.numberPlan);
                    dataoutputstream.write(cdmasmsaddress.numberOfDigits);
                    dataoutputstream.write(((SmsAddress) (cdmasmsaddress)).origBytes, 0, ((SmsAddress) (cdmasmsaddress)).origBytes.length);
                    dataoutputstream.write(0);
                    dataoutputstream.write(0);
                    dataoutputstream.write(0);
                    dataoutputstream.write(abyte0.length);
                    dataoutputstream.write(abyte0, 0, abyte0.length);
                    dataoutputstream.close();
                    submitpdu = new SubmitPdu();
                    submitpdu.encodedMessage = bytearrayoutputstream.toByteArray();
                    submitpdu.encodedScAddress = null;
                }
                catch(IOException ioexception) {
                    Log.e("CDMA", (new StringBuilder()).append("creating SubmitPdu failed: ").append(ioexception).toString());
                    submitpdu = null;
                }
            }
        }
        return submitpdu;
    }

    byte[] getIncomingSmsFingerprint() {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        bytearrayoutputstream.write(mEnvelope.teleService);
        bytearrayoutputstream.write(((SmsAddress) (mEnvelope.origAddress)).origBytes, 0, ((SmsAddress) (mEnvelope.origAddress)).origBytes.length);
        bytearrayoutputstream.write(mEnvelope.bearerData, 0, mEnvelope.bearerData.length);
        bytearrayoutputstream.write(mEnvelope.origSubaddress.origBytes, 0, mEnvelope.origSubaddress.origBytes.length);
        return bytearrayoutputstream.toByteArray();
    }

    public android.telephony.MessageClass getMessageClass() {
        android.telephony.MessageClass messageclass;
        if(mBearerData.displayMode == 0)
            messageclass = android.telephony.MessageClass.CLASS_0;
        else
            messageclass = android.telephony.MessageClass.UNKNOWN;
        return messageclass;
    }

    int getMessageType() {
        return mEnvelope.messageType;
    }

    int getNumOfVoicemails() {
        return mBearerData.numberOfMessages;
    }

    public int getProtocolIdentifier() {
        Log.w("CDMA", "getProtocolIdentifier: is not supported in CDMA mode.");
        return 0;
    }

    List getSmsCbProgramData() {
        return mBearerData.serviceCategoryProgramData;
    }

    public int getStatus() {
        return status << 16;
    }

    int getTeleService() {
        return mEnvelope.teleService;
    }

    public boolean isCphsMwiMessage() {
        Log.w("CDMA", "isCphsMwiMessage: is not supported in CDMA mode.");
        return false;
    }

    public boolean isMWIClearMessage() {
        boolean flag;
        if(mBearerData != null && mBearerData.numberOfMessages == 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isMWISetMessage() {
        boolean flag;
        if(mBearerData != null && mBearerData.numberOfMessages > 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isMwiDontStore() {
        boolean flag;
        if(mBearerData != null && mBearerData.numberOfMessages > 0 && mBearerData.userData == null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isReplace() {
        Log.w("CDMA", "isReplace: is not supported in CDMA mode.");
        return false;
    }

    public boolean isReplyPathPresent() {
        Log.w("CDMA", "isReplyPathPresent: is not supported in CDMA mode.");
        return false;
    }

    public boolean isStatusReportMessage() {
        boolean flag;
        if(mBearerData.messageType == 4)
            flag = true;
        else
            flag = false;
        return flag;
    }

    SmsCbMessage parseBroadcastSms() {
        SmsCbMessage smscbmessage = null;
        BearerData bearerdata = BearerData.decode(mEnvelope.bearerData, mEnvelope.serviceCategory);
        if(bearerdata == null) {
            Log.w("CDMA", "BearerData.decode() returned null");
        } else {
            if(Log.isLoggable("CDMA:SMS", 2))
                Log.d("CDMA", (new StringBuilder()).append("MT raw BearerData = ").append(HexDump.toHexString(mEnvelope.bearerData)).toString());
            SmsCbLocation smscblocation = new SmsCbLocation(SystemProperties.get("gsm.operator.numeric"));
            smscbmessage = new SmsCbMessage(2, 1, bearerdata.messageId, smscblocation, mEnvelope.serviceCategory, bearerdata.getLanguage(), bearerdata.userData.payloadStr, bearerdata.priority, null, bearerdata.cmasWarningInfo);
        }
        return smscbmessage;
    }

    protected void parseSms() {
        if(mEnvelope.teleService != 0x40000) goto _L2; else goto _L1
_L1:
        mBearerData = new BearerData();
        if(mEnvelope.bearerData != null)
            mBearerData.numberOfMessages = 0xff & mEnvelope.bearerData[0];
_L5:
        return;
_L2:
        mBearerData = BearerData.decode(mEnvelope.bearerData);
        if(Log.isLoggable("CDMA:SMS", 2)) {
            Log.d("CDMA", (new StringBuilder()).append("MT raw BearerData = '").append(HexDump.toHexString(mEnvelope.bearerData)).append("'").toString());
            Log.d("CDMA", (new StringBuilder()).append("MT (decoded) BearerData = ").append(mBearerData).toString());
        }
        super.messageRef = mBearerData.messageId;
        if(mBearerData.userData != null) {
            super.userData = mBearerData.userData.payload;
            super.userDataHeader = mBearerData.userData.userDataHeader;
            super.messageBody = mBearerData.userData.payloadStr;
        }
        if(super.originatingAddress != null)
            super.originatingAddress.address = new String(super.originatingAddress.origBytes);
        if(mBearerData.msgCenterTimeStamp != null)
            super.scTimeMillis = mBearerData.msgCenterTimeStamp.toMillis(true);
        if(mBearerData.messageType != 4) goto _L4; else goto _L3
_L3:
        if(!mBearerData.messageStatusSet) {
            StringBuilder stringbuilder = (new StringBuilder()).append("DELIVERY_ACK message without msgStatus (");
            String s;
            if(super.userData == null)
                s = "also missing";
            else
                s = "does have";
            Log.d("CDMA", stringbuilder.append(s).append(" userData).").toString());
            status = 0;
        } else {
            status = mBearerData.errorClass << 8;
            status = status | mBearerData.messageStatus;
        }
_L6:
        if(super.messageBody != null)
            parseMessageBody();
        else
        if(super.userData == null);
        if(true) goto _L5; else goto _L4
_L4:
        if(mBearerData.messageType != 1)
            throw new RuntimeException((new StringBuilder()).append("Unsupported message type: ").append(mBearerData.messageType).toString());
          goto _L6
    }

    private static final byte BEARER_DATA = 8;
    private static final byte BEARER_REPLY_OPTION = 6;
    private static final byte CAUSE_CODES = 7;
    private static final byte DESTINATION_ADDRESS = 4;
    private static final byte DESTINATION_SUB_ADDRESS = 5;
    private static final String LOGGABLE_TAG = "CDMA:SMS";
    static final String LOG_TAG = "CDMA";
    private static final byte ORIGINATING_ADDRESS = 2;
    private static final byte ORIGINATING_SUB_ADDRESS = 3;
    private static final int RETURN_ACK = 1;
    private static final int RETURN_NO_ACK = 0;
    private static final byte SERVICE_CATEGORY = 1;
    private static final byte TELESERVICE_IDENTIFIER;
    private BearerData mBearerData;
    private SmsEnvelope mEnvelope;
    private int status;
}
