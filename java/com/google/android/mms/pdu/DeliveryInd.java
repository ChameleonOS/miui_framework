// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.mms.pdu;

import com.google.android.mms.InvalidHeaderValueException;

// Referenced classes of package com.google.android.mms.pdu:
//            GenericPdu, PduHeaders, EncodedStringValue

public class DeliveryInd extends GenericPdu {

    public DeliveryInd() throws InvalidHeaderValueException {
        setMessageType(134);
    }

    DeliveryInd(PduHeaders pduheaders) {
        super(pduheaders);
    }

    public long getDate() {
        return super.mPduHeaders.getLongInteger(133);
    }

    public byte[] getMessageId() {
        return super.mPduHeaders.getTextString(139);
    }

    public int getStatus() {
        return super.mPduHeaders.getOctet(149);
    }

    public EncodedStringValue[] getTo() {
        return super.mPduHeaders.getEncodedStringValues(151);
    }

    public void setDate(long l) {
        super.mPduHeaders.setLongInteger(l, 133);
    }

    public void setMessageId(byte abyte0[]) {
        super.mPduHeaders.setTextString(abyte0, 139);
    }

    public void setStatus(int i) throws InvalidHeaderValueException {
        super.mPduHeaders.setOctet(i, 149);
    }

    public void setTo(EncodedStringValue aencodedstringvalue[]) {
        super.mPduHeaders.setEncodedStringValues(aencodedstringvalue, 151);
    }
}
