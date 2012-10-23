// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.mms.pdu;

import com.google.android.mms.InvalidHeaderValueException;

// Referenced classes of package com.google.android.mms.pdu:
//            MultimediaMessagePdu, GenericPdu, PduHeaders, PduBody, 
//            EncodedStringValue

public class RetrieveConf extends MultimediaMessagePdu {

    public RetrieveConf() throws InvalidHeaderValueException {
        setMessageType(132);
    }

    RetrieveConf(PduHeaders pduheaders) {
        super(pduheaders);
    }

    RetrieveConf(PduHeaders pduheaders, PduBody pdubody) {
        super(pduheaders, pdubody);
    }

    public void addCc(EncodedStringValue encodedstringvalue) {
        super.mPduHeaders.appendEncodedStringValue(encodedstringvalue, 130);
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

    public EncodedStringValue getFrom() {
        return super.mPduHeaders.getEncodedStringValue(137);
    }

    public byte[] getMessageClass() {
        return super.mPduHeaders.getTextString(138);
    }

    public byte[] getMessageId() {
        return super.mPduHeaders.getTextString(139);
    }

    public int getReadReport() {
        return super.mPduHeaders.getOctet(144);
    }

    public int getRetrieveStatus() {
        return super.mPduHeaders.getOctet(153);
    }

    public EncodedStringValue getRetrieveText() {
        return super.mPduHeaders.getEncodedStringValue(154);
    }

    public byte[] getTransactionId() {
        return super.mPduHeaders.getTextString(152);
    }

    public void setContentType(byte abyte0[]) {
        super.mPduHeaders.setTextString(abyte0, 132);
    }

    public void setDeliveryReport(int i) throws InvalidHeaderValueException {
        super.mPduHeaders.setOctet(i, 134);
    }

    public void setFrom(EncodedStringValue encodedstringvalue) {
        super.mPduHeaders.setEncodedStringValue(encodedstringvalue, 137);
    }

    public void setMessageClass(byte abyte0[]) {
        super.mPduHeaders.setTextString(abyte0, 138);
    }

    public void setMessageId(byte abyte0[]) {
        super.mPduHeaders.setTextString(abyte0, 139);
    }

    public void setReadReport(int i) throws InvalidHeaderValueException {
        super.mPduHeaders.setOctet(i, 144);
    }

    public void setRetrieveStatus(int i) throws InvalidHeaderValueException {
        super.mPduHeaders.setOctet(i, 153);
    }

    public void setRetrieveText(EncodedStringValue encodedstringvalue) {
        super.mPduHeaders.setEncodedStringValue(encodedstringvalue, 154);
    }

    public void setTransactionId(byte abyte0[]) {
        super.mPduHeaders.setTextString(abyte0, 152);
    }
}
