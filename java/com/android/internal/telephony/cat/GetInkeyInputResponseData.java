// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;

import com.android.internal.telephony.EncodeException;
import com.android.internal.telephony.GsmAlphabet;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

// Referenced classes of package com.android.internal.telephony.cat:
//            ResponseData, ComprehensionTlvTag

class GetInkeyInputResponseData extends ResponseData {

    public GetInkeyInputResponseData(String s, boolean flag, boolean flag1) {
        mIsUcs2 = flag;
        mIsPacked = flag1;
        mInData = s;
        mIsYesNo = false;
    }

    public GetInkeyInputResponseData(boolean flag) {
        mIsUcs2 = false;
        mIsPacked = false;
        mInData = "";
        mIsYesNo = true;
        mYesNoResponse = flag;
    }

    public void format(ByteArrayOutputStream bytearrayoutputstream) {
        int i = 1;
        if(bytearrayoutputstream != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        bytearrayoutputstream.write(0x80 | ComprehensionTlvTag.TEXT_STRING.value());
        if(!mIsYesNo) goto _L4; else goto _L3
_L3:
        byte abyte0[];
        abyte0 = new byte[i];
        byte abyte1[];
        int j;
        int k;
        if(!mYesNoResponse)
            i = 0;
        abyte0[0] = i;
_L5:
        writeLength(bytearrayoutputstream, 1 + abyte0.length);
        EncodeException encodeexception;
        UnsupportedEncodingException unsupportedencodingexception;
        byte abyte2[];
        int l;
        byte abyte3[];
        if(mIsUcs2)
            bytearrayoutputstream.write(8);
        else
        if(mIsPacked)
            bytearrayoutputstream.write(0);
        else
            bytearrayoutputstream.write(4);
        abyte1 = abyte0;
        j = abyte1.length;
        k = 0;
        while(k < j)  {
            bytearrayoutputstream.write(abyte1[k]);
            k++;
        }
        if(true) goto _L1; else goto _L4
_L4:
label0:
        {
            if(mInData == null || mInData.length() <= 0)
                break label0;
            try {
                if(mIsUcs2) {
                    abyte0 = mInData.getBytes("UTF-16");
                } else {
                    if(!mIsPacked)
                        break MISSING_BLOCK_LABEL_193;
                    l = mInData.length();
                    abyte3 = GsmAlphabet.stringToGsm7BitPacked(mInData, 0, 0);
                    abyte0 = new byte[l];
                    System.arraycopy(abyte3, 1, abyte0, 0, l);
                }
            }
            // Misplaced declaration of an exception variable
            catch(UnsupportedEncodingException unsupportedencodingexception) {
                abyte0 = new byte[0];
            }
            // Misplaced declaration of an exception variable
            catch(EncodeException encodeexception) {
                abyte0 = new byte[0];
            }
        }
          goto _L5
        abyte2 = GsmAlphabet.stringToGsm8BitPacked(mInData);
        abyte0 = abyte2;
          goto _L5
        abyte0 = new byte[0];
          goto _L5
    }

    protected static final byte GET_INKEY_NO = 0;
    protected static final byte GET_INKEY_YES = 1;
    public String mInData;
    private boolean mIsPacked;
    private boolean mIsUcs2;
    private boolean mIsYesNo;
    private boolean mYesNoResponse;
}
