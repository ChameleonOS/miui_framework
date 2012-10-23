// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.mms.pdu;

import com.google.android.mms.InvalidHeaderValueException;

// Referenced classes of package com.google.android.mms.pdu:
//            GenericPdu, PduHeaders, PduBody, EncodedStringValue

public class MultimediaMessagePdu extends GenericPdu {

    public MultimediaMessagePdu() {
    }

    MultimediaMessagePdu(PduHeaders pduheaders) {
        super(pduheaders);
    }

    public MultimediaMessagePdu(PduHeaders pduheaders, PduBody pdubody) {
        super(pduheaders);
        mMessageBody = pdubody;
    }

    public void addTo(EncodedStringValue encodedstringvalue) {
        super.mPduHeaders.appendEncodedStringValue(encodedstringvalue, 151);
    }

    public PduBody getBody() {
        return mMessageBody;
    }

    public long getDate() {
        return super.mPduHeaders.getLongInteger(133);
    }

    public int getPriority() {
        return super.mPduHeaders.getOctet(143);
    }

    public EncodedStringValue getSubject() {
        return super.mPduHeaders.getEncodedStringValue(150);
    }

    public EncodedStringValue[] getTo() {
        return super.mPduHeaders.getEncodedStringValues(151);
    }

    public void setBody(PduBody pdubody) {
        mMessageBody = pdubody;
    }

    public void setDate(long l) {
        super.mPduHeaders.setLongInteger(l, 133);
    }

    public void setPriority(int i) throws InvalidHeaderValueException {
        super.mPduHeaders.setOctet(i, 143);
    }

    public void setSubject(EncodedStringValue encodedstringvalue) {
        super.mPduHeaders.setEncodedStringValue(encodedstringvalue, 150);
    }

    private PduBody mMessageBody;
}
