// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.android.internal.telephony.cat:
//            ResultException, ResultCode, CatLog

class ComprehensionTlv {

    protected ComprehensionTlv(int i, boolean flag, int j, byte abyte0[], int k) {
        mTag = i;
        mCr = flag;
        mLength = j;
        mValueIndex = k;
        mRawValue = abyte0;
    }

    public static ComprehensionTlv decode(byte abyte0[], int i) throws ResultException {
        boolean flag;
        int j;
        int k;
        flag = true;
        j = abyte0.length;
        k = i + 1;
        byte byte0 = abyte0[i];
        int i1 = byte0 & 0xff;
        i1;
        JVM INSTR lookupswitch 4: default 68
    //                   0: 133
    //                   127: 199
    //                   128: 133
    //                   255: 133;
           goto _L1 _L2 _L3 _L2 _L2
_L1:
        IndexOutOfBoundsException indexoutofboundsexception;
        int l;
        int j1;
        int k1;
        int l1;
        int i2;
        ComprehensionTlv comprehensiontlv;
        if((i1 & 0x80) == 0)
            flag = false;
        k1 = i1 & 0xffffff7f;
_L11:
        l = k + 1;
        l1 = 0xff & abyte0[k];
        if(l1 >= 128) goto _L5; else goto _L4
_L4:
        i2 = l1;
_L10:
        comprehensiontlv = new ComprehensionTlv(k1, flag, i2, abyte0, l);
_L6:
        return comprehensiontlv;
_L2:
        Log.d("CAT     ", (new StringBuilder()).append("decode: unexpected first tag byte=").append(Integer.toHexString(i1)).append(", startIndex=").append(i).append(" curIndex=").append(k).append(" endIndex=").append(j).toString());
        comprehensiontlv = null;
        k;
          goto _L6
_L3:
        j1 = (0xff & abyte0[k]) << 8 | 0xff & abyte0[k + 1];
        break; /* Loop/switch isn't completed */
_L5:
        if(l1 != 129) goto _L8; else goto _L7
_L7:
        k = l + 1;
        i2 = 0xff & abyte0[l];
        if(i2 < 128)
            throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD, (new StringBuilder()).append("length < 0x80 length=").append(Integer.toHexString(i2)).append(" startIndex=").append(i).append(" curIndex=").append(k).append(" endIndex=").append(j).toString());
          goto _L9
        indexoutofboundsexception;
        l = k;
_L12:
        throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD, (new StringBuilder()).append("IndexOutOfBoundsException startIndex=").append(i).append(" curIndex=").append(l).append(" endIndex=").append(j).toString());
_L8:
        if(l1 != 130)
            break MISSING_BLOCK_LABEL_488;
        i2 = (0xff & abyte0[l]) << 8 | 0xff & abyte0[l + 1];
        l += 2;
        if(i2 < 256)
            throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD, (new StringBuilder()).append("two byte length < 0x100 length=").append(Integer.toHexString(i2)).append(" startIndex=").append(i).append(" curIndex=").append(l).append(" endIndex=").append(j).toString());
          goto _L10
        if(l1 == 131) {
            i2 = (0xff & abyte0[l]) << 16 | (0xff & abyte0[l + 1]) << 8 | 0xff & abyte0[l + 2];
            l += 3;
            if(i2 < 0x10000)
                throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD, (new StringBuilder()).append("three byte length < 0x10000 length=0x").append(Integer.toHexString(i2)).append(" startIndex=").append(i).append(" curIndex=").append(l).append(" endIndex=").append(j).toString());
        } else {
            throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD, (new StringBuilder()).append("Bad length modifer=").append(l1).append(" startIndex=").append(i).append(" curIndex=").append(l).append(" endIndex=").append(j).toString());
        }
          goto _L10
_L9:
        l = k;
          goto _L10
        if((0x8000 & j1) == 0)
            flag = false;
        k1 = j1 & 0xffff7fff;
        k += 2;
          goto _L11
        IndexOutOfBoundsException indexoutofboundsexception1;
        indexoutofboundsexception1;
          goto _L12
    }

    public static List decodeMany(byte abyte0[], int i) throws ResultException {
        ArrayList arraylist;
label0:
        {
            arraylist = new ArrayList();
            int j = abyte0.length;
            do {
                if(i >= j)
                    break label0;
                ComprehensionTlv comprehensiontlv = decode(abyte0, i);
                if(comprehensiontlv == null)
                    break;
                arraylist.add(comprehensiontlv);
                i = comprehensiontlv.mValueIndex + comprehensiontlv.mLength;
            } while(true);
            CatLog.d("ComprehensionTlv", "decodeMany: ctlv is null, stop decoding");
        }
        return arraylist;
    }

    public int getLength() {
        return mLength;
    }

    public byte[] getRawValue() {
        return mRawValue;
    }

    public int getTag() {
        return mTag;
    }

    public int getValueIndex() {
        return mValueIndex;
    }

    public boolean isComprehensionRequired() {
        return mCr;
    }

    private static final String LOG_TAG = "ComprehensionTlv";
    private boolean mCr;
    private int mLength;
    private byte mRawValue[];
    private int mTag;
    private int mValueIndex;
}
