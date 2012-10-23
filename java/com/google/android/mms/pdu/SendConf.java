// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.mms.pdu;

import com.google.android.mms.InvalidHeaderValueException;

// Referenced classes of package com.google.android.mms.pdu:
//            GenericPdu, PduHeaders

public class SendConf extends GenericPdu {

    public SendConf() throws InvalidHeaderValueException {
        setMessageType(129);
    }

    SendConf(PduHeaders pduheaders) {
        super(pduheaders);
    }

    public byte[] getMessageId() {
        return super.mPduHeaders.getTextString(139);
    }

    public int getResponseStatus() {
        return super.mPduHeaders.getOctet(146);
    }

    public byte[] getTransactionId() {
        return super.mPduHeaders.getTextString(152);
    }

    public void setMessageId(byte abyte0[]) {
        super.mPduHeaders.setTextString(abyte0, 139);
    }

    public void setResponseStatus(int i) throws InvalidHeaderValueException {
        super.mPduHeaders.setOctet(i, 146);
    }

    public void setTransactionId(byte abyte0[]) {
        super.mPduHeaders.setTextString(abyte0, 152);
    }
}
