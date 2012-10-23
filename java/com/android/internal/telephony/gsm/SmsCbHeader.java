// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.gsm;

import android.telephony.SmsCbCmasInfo;
import android.telephony.SmsCbEtwsInfo;
import java.util.Arrays;

class SmsCbHeader {

    public SmsCbHeader(byte abyte0[]) throws IllegalArgumentException {
        if(abyte0 == null || abyte0.length < 6)
            throw new IllegalArgumentException("Illegal PDU");
        if(abyte0.length <= 56) {
            format = 3;
            geographicalScope = (0xc0 & abyte0[0]) >> 6;
            serialNumber = (0xff & abyte0[0]) << 8 | 0xff & abyte0[1];
            messageIdentifier = (0xff & abyte0[2]) << 8 | 0xff & abyte0[3];
            dataCodingScheme = -1;
            pageIndex = -1;
            nrOfPages = -1;
            boolean flag2;
            boolean flag3;
            int k1;
            byte abyte1[];
            if((1 & abyte0[4]) != 0)
                flag2 = true;
            else
                flag2 = false;
            if((0x80 & abyte0[5]) != 0)
                flag3 = true;
            else
                flag3 = false;
            k1 = (0xfe & abyte0[4]) >> 1;
            if(abyte0.length > 6)
                abyte1 = Arrays.copyOfRange(abyte0, 6, abyte0.length);
            else
                abyte1 = null;
            mEtwsInfo = new SmsCbEtwsInfo(k1, flag2, flag3, abyte1);
            mCmasInfo = null;
        } else {
            if(abyte0.length <= 88) {
                format = 1;
                geographicalScope = (0xc0 & abyte0[0]) >> 6;
                serialNumber = (0xff & abyte0[0]) << 8 | 0xff & abyte0[1];
                messageIdentifier = (0xff & abyte0[2]) << 8 | 0xff & abyte0[3];
                dataCodingScheme = 0xff & abyte0[4];
                int i1 = (0xf0 & abyte0[5]) >> 4;
                int j1 = 0xf & abyte0[5];
                if(i1 == 0 || j1 == 0 || i1 > j1) {
                    i1 = 1;
                    j1 = 1;
                }
                pageIndex = i1;
                nrOfPages = j1;
            } else {
                format = 2;
                byte byte0 = abyte0[0];
                if(byte0 != 1)
                    throw new IllegalArgumentException((new StringBuilder()).append("Unsupported message type ").append(byte0).toString());
                messageIdentifier = (0xff & abyte0[1]) << 8 | 0xff & abyte0[2];
                geographicalScope = (0xc0 & abyte0[3]) >> 6;
                serialNumber = (0xff & abyte0[3]) << 8 | 0xff & abyte0[4];
                dataCodingScheme = 0xff & abyte0[5];
                pageIndex = 1;
                nrOfPages = 1;
            }
            if(isEtwsMessage()) {
                boolean flag = isEtwsEmergencyUserAlert();
                boolean flag1 = isEtwsPopupAlert();
                mEtwsInfo = new SmsCbEtwsInfo(getEtwsWarningType(), flag, flag1, null);
                mCmasInfo = null;
            } else
            if(isCmasMessage()) {
                int i = getCmasMessageClass();
                int j = getCmasSeverity();
                int k = getCmasUrgency();
                int l = getCmasCertainty();
                mEtwsInfo = null;
                mCmasInfo = new SmsCbCmasInfo(i, -1, -1, j, k, l);
            } else {
                mEtwsInfo = null;
                mCmasInfo = null;
            }
        }
    }

    private int getCmasCertainty() {
        messageIdentifier;
        JVM INSTR tableswitch 4371 4378: default 52
    //                   4371 57
    //                   4372 62
    //                   4373 57
    //                   4374 62
    //                   4375 57
    //                   4376 62
    //                   4377 57
    //                   4378 62;
           goto _L1 _L2 _L3 _L2 _L3 _L2 _L3 _L2 _L3
_L1:
        byte byte0 = -1;
_L5:
        return byte0;
_L2:
        byte0 = 0;
        continue; /* Loop/switch isn't completed */
_L3:
        byte0 = 1;
        if(true) goto _L5; else goto _L4
_L4:
    }

    private int getCmasMessageClass() {
        messageIdentifier;
        JVM INSTR tableswitch 4370 4382: default 72
    //                   4370 77
    //                   4371 82
    //                   4372 82
    //                   4373 82
    //                   4374 82
    //                   4375 87
    //                   4376 87
    //                   4377 87
    //                   4378 87
    //                   4379 92
    //                   4380 97
    //                   4381 102
    //                   4382 107;
           goto _L1 _L2 _L3 _L3 _L3 _L3 _L4 _L4 _L4 _L4 _L5 _L6 _L7 _L8
_L1:
        byte byte0 = -1;
_L10:
        return byte0;
_L2:
        byte0 = 0;
        continue; /* Loop/switch isn't completed */
_L3:
        byte0 = 1;
        continue; /* Loop/switch isn't completed */
_L4:
        byte0 = 2;
        continue; /* Loop/switch isn't completed */
_L5:
        byte0 = 3;
        continue; /* Loop/switch isn't completed */
_L6:
        byte0 = 4;
        continue; /* Loop/switch isn't completed */
_L7:
        byte0 = 5;
        continue; /* Loop/switch isn't completed */
_L8:
        byte0 = 6;
        if(true) goto _L10; else goto _L9
_L9:
    }

    private int getCmasSeverity() {
        messageIdentifier;
        JVM INSTR tableswitch 4371 4378: default 52
    //                   4371 57
    //                   4372 57
    //                   4373 57
    //                   4374 57
    //                   4375 62
    //                   4376 62
    //                   4377 62
    //                   4378 62;
           goto _L1 _L2 _L2 _L2 _L2 _L3 _L3 _L3 _L3
_L1:
        byte byte0 = -1;
_L5:
        return byte0;
_L2:
        byte0 = 0;
        continue; /* Loop/switch isn't completed */
_L3:
        byte0 = 1;
        if(true) goto _L5; else goto _L4
_L4:
    }

    private int getCmasUrgency() {
        messageIdentifier;
        JVM INSTR tableswitch 4371 4378: default 52
    //                   4371 57
    //                   4372 57
    //                   4373 62
    //                   4374 62
    //                   4375 57
    //                   4376 57
    //                   4377 62
    //                   4378 62;
           goto _L1 _L2 _L2 _L3 _L3 _L2 _L2 _L3 _L3
_L1:
        byte byte0 = -1;
_L5:
        return byte0;
_L2:
        byte0 = 0;
        continue; /* Loop/switch isn't completed */
_L3:
        byte0 = 1;
        if(true) goto _L5; else goto _L4
_L4:
    }

    private int getEtwsWarningType() {
        return -4352 + messageIdentifier;
    }

    private boolean isCmasMessage() {
        boolean flag;
        if(messageIdentifier >= 4370 && messageIdentifier <= 4399)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private boolean isEtwsEmergencyUserAlert() {
        boolean flag;
        if((0x2000 & serialNumber) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private boolean isEtwsMessage() {
        boolean flag;
        if((0xfff8 & messageIdentifier) == 4352)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private boolean isEtwsPopupAlert() {
        boolean flag;
        if((0x1000 & serialNumber) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    SmsCbCmasInfo getCmasInfo() {
        return mCmasInfo;
    }

    int getDataCodingScheme() {
        return dataCodingScheme;
    }

    SmsCbEtwsInfo getEtwsInfo() {
        return mEtwsInfo;
    }

    int getGeographicalScope() {
        return geographicalScope;
    }

    int getNumberOfPages() {
        return nrOfPages;
    }

    int getPageIndex() {
        return pageIndex;
    }

    int getSerialNumber() {
        return serialNumber;
    }

    int getServiceCategory() {
        return messageIdentifier;
    }

    boolean isEmergencyMessage() {
        boolean flag;
        if(messageIdentifier >= 4352 && messageIdentifier <= 6399)
            flag = true;
        else
            flag = false;
        return flag;
    }

    boolean isEtwsPrimaryNotification() {
        boolean flag;
        if(format == 3)
            flag = true;
        else
            flag = false;
        return flag;
    }

    boolean isUmtsFormat() {
        boolean flag;
        if(format == 2)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public String toString() {
        return (new StringBuilder()).append("SmsCbHeader{GS=").append(geographicalScope).append(", serialNumber=0x").append(Integer.toHexString(serialNumber)).append(", messageIdentifier=0x").append(Integer.toHexString(messageIdentifier)).append(", DCS=0x").append(Integer.toHexString(dataCodingScheme)).append(", page ").append(pageIndex).append(" of ").append(nrOfPages).append('}').toString();
    }

    static final int FORMAT_ETWS_PRIMARY = 3;
    static final int FORMAT_GSM = 1;
    static final int FORMAT_UMTS = 2;
    private static final int MESSAGE_TYPE_CBS_MESSAGE = 1;
    static final int PDU_HEADER_LENGTH = 6;
    private static final int PDU_LENGTH_ETWS = 56;
    private static final int PDU_LENGTH_GSM = 88;
    private final int dataCodingScheme;
    private final int format;
    private final int geographicalScope;
    private final SmsCbCmasInfo mCmasInfo;
    private final SmsCbEtwsInfo mEtwsInfo;
    private final int messageIdentifier;
    private final int nrOfPages;
    private final int pageIndex;
    private final int serialNumber;
}
