// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;


// Referenced classes of package com.android.internal.telephony:
//            IccUtils, IccException, IccFileTypeMismatch, IccFileNotFound

public class IccIoResult {

    public IccIoResult(int i, int j, String s) {
        this(i, j, IccUtils.hexStringToBytes(s));
    }

    public IccIoResult(int i, int j, byte abyte0[]) {
        sw1 = i;
        sw2 = j;
        payload = abyte0;
    }

    public IccException getException() {
        if(!success()) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((IccException) (obj));
_L2:
        switch(sw1) {
        default:
            obj = new IccException((new StringBuilder()).append("sw1:").append(sw1).append(" sw2:").append(sw2).toString());
            break;

        case 148: 
            if(sw2 == 8)
                obj = new IccFileTypeMismatch();
            else
                obj = new IccFileNotFound();
            break;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean success() {
        boolean flag;
        if(sw1 == 144 || sw1 == 145 || sw1 == 158 || sw1 == 159)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public String toString() {
        return (new StringBuilder()).append("IccIoResponse sw1:0x").append(Integer.toHexString(sw1)).append(" sw2:0x").append(Integer.toHexString(sw2)).toString();
    }

    public byte payload[];
    public int sw1;
    public int sw2;
}
