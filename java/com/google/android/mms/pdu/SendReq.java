// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.mms.pdu;

import android.util.Log;
import com.google.android.mms.InvalidHeaderValueException;

// Referenced classes of package com.google.android.mms.pdu:
//            MultimediaMessagePdu, EncodedStringValue, GenericPdu, PduHeaders, 
//            PduBody

public class SendReq extends MultimediaMessagePdu {

    public SendReq() {
        try {
            setMessageType(128);
            setMmsVersion(18);
            setContentType("application/vnd.wap.multipart.related".getBytes());
            setFrom(new EncodedStringValue("insert-address-token".getBytes()));
            setTransactionId(generateTransactionId());
            return;
        }
        catch(InvalidHeaderValueException invalidheadervalueexception) {
            Log.e("SendReq", "Unexpected InvalidHeaderValueException.", invalidheadervalueexception);
            throw new RuntimeException(invalidheadervalueexception);
        }
    }

    SendReq(PduHeaders pduheaders) {
        super(pduheaders);
    }

    SendReq(PduHeaders pduheaders, PduBody pdubody) {
        super(pduheaders, pdubody);
    }

    public SendReq(byte abyte0[], EncodedStringValue encodedstringvalue, int i, byte abyte1[]) throws InvalidHeaderValueException {
        setMessageType(128);
        setContentType(abyte0);
        setFrom(encodedstringvalue);
        setMmsVersion(i);
        setTransactionId(abyte1);
    }

    private byte[] generateTransactionId() {
        return (new StringBuilder()).append("T").append(Long.toHexString(System.currentTimeMillis())).toString().getBytes();
    }

    public void addBcc(EncodedStringValue encodedstringvalue) {
        super.mPduHeaders.appendEncodedStringValue(encodedstringvalue, 129);
    }

    public void addCc(EncodedStringValue encodedstringvalue) {
        super.mPduHeaders.appendEncodedStringValue(encodedstringvalue, 130);
    }

    public EncodedStringValue[] getBcc() {
        return super.mPduHeaders.getEncodedStringValues(129);
    }

    public EncodedStringValue[] getCc() {
        return super.mPduHeaders.getEncodedStringValues(130);
    }

    public byte[] getContentType() {
        return super.mPduHeaders.getTextString(132);
    }

    public int getDeliveryReport() {
        return super.mPduHeaders.getOctet(134);
    }

    public long getExpiry() {
        return super.mPduHeaders.getLongInteger(136);
    }

    public byte[] getMessageClass() {
        return super.mPduHeaders.getTextString(138);
    }

    public long getMessageSize() {
        return super.mPduHeaders.getLongInteger(142);
    }

    public int getReadReport() {
        return super.mPduHeaders.getOctet(144);
    }

    public byte[] getTransactionId() {
        return super.mPduHeaders.getTextString(152);
    }

    public void setBcc(EncodedStringValue aencodedstringvalue[]) {
        super.mPduHeaders.setEncodedStringValues(aencodedstringvalue, 129);
    }

    public void setCc(EncodedStringValue aencodedstringvalue[]) {
        super.mPduHeaders.setEncodedStringValues(aencodedstringvalue, 130);
    }

    public void setContentType(byte abyte0[]) {
        super.mPduHeaders.setTextString(abyte0, 132);
    }

    public void setDeliveryReport(int i) throws InvalidHeaderValueException {
        super.mPduHeaders.setOctet(i, 134);
    }

    public void setExpiry(long l) {
        super.mPduHeaders.setLongInteger(l, 136);
    }

    public void setMessageClass(byte abyte0[]) {
        super.mPduHeaders.setTextString(abyte0, 138);
    }

    public void setMessageSize(long l) {
        super.mPduHeaders.setLongInteger(l, 142);
    }

    public void setReadReport(int i) throws InvalidHeaderValueException {
        super.mPduHeaders.setOctet(i, 144);
    }

    public void setTo(EncodedStringValue aencodedstringvalue[]) {
        super.mPduHeaders.setEncodedStringValues(aencodedstringvalue, 151);
    }

    public void setTransactionId(byte abyte0[]) {
        super.mPduHeaders.setTextString(abyte0, 152);
    }

    private static final String TAG = "SendReq";
}
