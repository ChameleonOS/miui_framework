// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.gsm;


public class SimTlv {

    public SimTlv(byte abyte0[], int i, int j) {
        record = abyte0;
        tlvOffset = i;
        tlvLength = j;
        curOffset = i;
        hasValidTlvObject = parseCurrentTlvObject();
    }

    private boolean parseCurrentTlvObject() {
        boolean flag = false;
        if(record[curOffset] != 0 && (0xff & record[curOffset]) != 255) goto _L2; else goto _L1
_L2:
        if((0xff & record[1 + curOffset]) >= 128) goto _L4; else goto _L3
_L3:
        curDataLength = 0xff & record[1 + curOffset];
        curDataOffset = 2 + curOffset;
_L5:
        if(curDataLength + curDataOffset <= tlvOffset + tlvLength)
            flag = true;
        break; /* Loop/switch isn't completed */
_L4:
        try {
            if((0xff & record[1 + curOffset]) != 129)
                break; /* Loop/switch isn't completed */
            curDataLength = 0xff & record[2 + curOffset];
            curDataOffset = 3 + curOffset;
            continue; /* Loop/switch isn't completed */
        }
        catch(ArrayIndexOutOfBoundsException arrayindexoutofboundsexception) { }
        break; /* Loop/switch isn't completed */
        if(true) goto _L5; else goto _L1
_L1:
        return flag;
    }

    public byte[] getData() {
        byte abyte0[];
        if(!hasValidTlvObject) {
            abyte0 = null;
        } else {
            abyte0 = new byte[curDataLength];
            System.arraycopy(record, curDataOffset, abyte0, 0, curDataLength);
        }
        return abyte0;
    }

    public int getTag() {
        int i;
        if(!hasValidTlvObject)
            i = 0;
        else
            i = 0xff & record[curOffset];
        return i;
    }

    public boolean isValidObject() {
        return hasValidTlvObject;
    }

    public boolean nextObject() {
        boolean flag;
        if(!hasValidTlvObject) {
            flag = false;
        } else {
            curOffset = curDataOffset + curDataLength;
            hasValidTlvObject = parseCurrentTlvObject();
            flag = hasValidTlvObject;
        }
        return flag;
    }

    int curDataLength;
    int curDataOffset;
    int curOffset;
    boolean hasValidTlvObject;
    byte record[];
    int tlvLength;
    int tlvOffset;
}
