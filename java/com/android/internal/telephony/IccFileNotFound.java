// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;


// Referenced classes of package com.android.internal.telephony:
//            IccException

public class IccFileNotFound extends IccException {

    IccFileNotFound() {
    }

    IccFileNotFound(int i) {
        super((new StringBuilder()).append("ICC EF Not Found 0x").append(Integer.toHexString(i)).toString());
    }

    IccFileNotFound(String s) {
        super(s);
    }
}
