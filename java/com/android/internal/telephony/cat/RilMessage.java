// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;


// Referenced classes of package com.android.internal.telephony.cat:
//            ResultCode

class RilMessage {

    RilMessage(int i, String s) {
        mId = i;
        mData = s;
    }

    RilMessage(RilMessage rilmessage) {
        mId = rilmessage.mId;
        mData = rilmessage.mData;
        mResCode = rilmessage.mResCode;
    }

    Object mData;
    int mId;
    ResultCode mResCode;
}
