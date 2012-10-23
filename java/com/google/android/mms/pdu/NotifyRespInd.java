// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.mms.pdu;

import com.google.android.mms.InvalidHeaderValueException;

// Referenced classes of package com.google.android.mms.pdu:
//            GenericPdu, PduHeaders

public class NotifyRespInd extends GenericPdu {

    public NotifyRespInd(int i, byte abyte0[], int j) throws InvalidHeaderValueException {
        setMessageType(131);
        setMmsVersion(i);
        setTransactionId(abyte0);
        setStatus(j);
    }

    NotifyRespInd(PduHeaders pduheaders) {
        super(pduheaders);
    }

    public int getReportAllowed() {
        return super.mPduHeaders.getOctet(145);
    }

    public int getStatus() {
        return super.mPduHeaders.getOctet(149);
    }

    public byte[] getTransactionId() {
        return super.mPduHeaders.getTextString(152);
    }

    public void setReportAllowed(int i) throws InvalidHeaderValueException {
        super.mPduHeaders.setOctet(i, 145);
    }

    public void setStatus(int i) throws InvalidHeaderValueException {
        super.mPduHeaders.setOctet(i, 149);
    }

    public void setTransactionId(byte abyte0[]) {
        super.mPduHeaders.setTextString(abyte0, 152);
    }
}
