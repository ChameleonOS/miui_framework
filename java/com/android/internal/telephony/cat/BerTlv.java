// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;

import java.util.List;

// Referenced classes of package com.android.internal.telephony.cat:
//            ResultException, ResultCode, ComprehensionTlvTag, ComprehensionTlv

class BerTlv {

    private BerTlv(int i, List list) {
        mTag = 0;
        mCompTlvs = null;
        mTag = i;
        mCompTlvs = list;
    }

    public static BerTlv decode(byte abyte0[]) throws ResultException {
        int i;
        int j;
        int k;
        i = abyte0.length;
        j = 0;
        k = 0 + 1;
        byte byte0 = abyte0[0];
        int i1 = byte0 & 0xff;
        if(i1 != 208) goto _L2; else goto _L1
_L1:
        int l = k + 1;
        byte byte1 = abyte0[k];
        int k1 = byte1 & 0xff;
        if(k1 >= 128) goto _L4; else goto _L3
_L3:
        j = k1;
_L12:
        IndexOutOfBoundsException indexoutofboundsexception;
        int j1;
        IndexOutOfBoundsException indexoutofboundsexception1;
        int l1;
        if(i - l < j)
            throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD, (new StringBuilder()).append("Command had extra data endIndex=").append(i).append(" curIndex=").append(l).append(" length=").append(j).toString());
        else
            return new BerTlv(i1, ComprehensionTlv.decodeMany(abyte0, l));
_L4:
        if(k1 != 129) goto _L6; else goto _L5
_L5:
        k = l + 1;
        l1 = 0xff & abyte0[l];
        if(l1 < 128)
            throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD, (new StringBuilder()).append("length < 0x80 length=").append(Integer.toHexString(0)).append(" curIndex=").append(k).append(" endIndex=").append(i).toString());
          goto _L7
        indexoutofboundsexception;
        l = k;
_L8:
        throw new ResultException(ResultCode.REQUIRED_VALUES_MISSING, (new StringBuilder()).append("IndexOutOfBoundsException  curIndex=").append(l).append(" endIndex=").append(i).toString());
_L7:
        j = l1;
        l = k;
        continue; /* Loop/switch isn't completed */
_L6:
        throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD, (new StringBuilder()).append("Expected first byte to be length or a length tag and < 0x81 byte= ").append(Integer.toHexString(k1)).append(" curIndex=").append(l).append(" endIndex=").append(i).toString());
        indexoutofboundsexception1;
        if(true) goto _L8; else goto _L2
_L2:
        j1 = ComprehensionTlvTag.COMMAND_DETAILS.value();
        ResultException resultexception;
        if(j1 == (i1 & 0xffffff7f)) {
            i1 = 0;
            l = 0;
        } else {
            l = k;
        }
        continue; /* Loop/switch isn't completed */
        resultexception;
        k;
_L10:
        throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD, resultexception.explanation());
        resultexception;
        if(true) goto _L10; else goto _L9
_L9:
        if(true) goto _L12; else goto _L11
_L11:
    }

    public List getComprehensionTlvs() {
        return mCompTlvs;
    }

    public int getTag() {
        return mTag;
    }

    public static final int BER_EVENT_DOWNLOAD_TAG = 214;
    public static final int BER_MENU_SELECTION_TAG = 211;
    public static final int BER_PROACTIVE_COMMAND_TAG = 208;
    public static final int BER_UNKNOWN_TAG;
    private List mCompTlvs;
    private int mTag;
}
