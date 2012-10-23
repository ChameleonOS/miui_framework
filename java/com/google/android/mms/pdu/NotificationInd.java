// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.mms.pdu;

import com.google.android.mms.InvalidHeaderValueException;

// Referenced classes of package com.google.android.mms.pdu:
//            GenericPdu, PduHeaders, EncodedStringValue

public class NotificationInd extends GenericPdu {

    public NotificationInd() throws InvalidHeaderValueException {
        setMessageType(130);
    }

    NotificationInd(PduHeaders pduheaders) {
        super(pduheaders);
    }

    public int getContentClass() {
        return super.mPduHeaders.getOctet(186);
    }

    public byte[] getContentLocation() {
        return super.mPduHeaders.getTextString(131);
    }

    public int getDeliveryReport() {
        return super.mPduHeaders.getOctet(134);
    }

    public long getExpiry() {
        return super.mPduHeaders.getLongInteger(136);
    }

    public EncodedStringValue getFrom() {
        return super.mPduHeaders.getEncodedStringValue(137);
    }

    public byte[] getMessageClass() {
        return super.mPduHeaders.getTextString(138);
    }

    public long getMessageSize() {
        return super.mPduHeaders.getLongInteger(142);
    }

    public EncodedStringValue getSubject() {
        return super.mPduHeaders.getEncodedStringValue(150);
    }

    public byte[] getTransactionId() {
        return super.mPduHeaders.getTextString(152);
    }

    public void setContentClass(int i) throws InvalidHeaderValueException {
        super.mPduHeaders.setOctet(i, 186);
    }

    public void setContentLocation(byte abyte0[]) {
        super.mPduHeaders.setTextString(abyte0, 131);
    }

    public void setDeliveryReport(int i) throws InvalidHeaderValueException {
        super.mPduHeaders.setOctet(i, 134);
    }

    public void setExpiry(long l) {
        super.mPduHeaders.setLongInteger(l, 136);
    }

    public void setFrom(EncodedStringValue encodedstringvalue) {
        super.mPduHeaders.setEncodedStringValue(encodedstringvalue, 137);
    }

    public void setMessageClass(byte abyte0[]) {
        super.mPduHeaders.setTextString(abyte0, 138);
    }

    public void setMessageSize(long l) {
        super.mPduHeaders.setLongInteger(l, 142);
    }

    public void setSubject(EncodedStringValue encodedstringvalue) {
        super.mPduHeaders.setEncodedStringValue(encodedstringvalue, 150);
    }

    public void setTransactionId(byte abyte0[]) {
        super.mPduHeaders.setTextString(abyte0, 152);
    }
}
