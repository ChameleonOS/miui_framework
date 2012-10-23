// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.mms.pdu;

import com.google.android.mms.InvalidHeaderValueException;

// Referenced classes of package com.google.android.mms.pdu:
//            GenericPdu, PduHeaders

public class AcknowledgeInd extends GenericPdu {

    public AcknowledgeInd(int i, byte abyte0[]) throws InvalidHeaderValueException {
        setMessageType(133);
        setMmsVersion(i);
        setTransactionId(abyte0);
    }

    AcknowledgeInd(PduHeaders pduheaders) {
        super(pduheaders);
    }

    public int getReportAllowed() {
        return super.mPduHeaders.getOctet(145);
    }

    public byte[] getTransactionId() {
        return super.mPduHeaders.getTextString(152);
    }

    public void setReportAllowed(int i) throws InvalidHeaderValueException {
        super.mPduHeaders.setOctet(i, 145);
    }

    public void setTransactionId(byte abyte0[]) {
        super.mPduHeaders.setTextString(abyte0, 152);
    }
}
