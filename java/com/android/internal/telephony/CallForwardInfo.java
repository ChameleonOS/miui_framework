// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.telephony.PhoneNumberUtils;

public class CallForwardInfo {

    public CallForwardInfo() {
    }

    public String toString() {
        StringBuilder stringbuilder = (new StringBuilder()).append(super.toString());
        String s;
        if(status == 0)
            s = " not active ";
        else
            s = " active ";
        return stringbuilder.append(s).append(" reason: ").append(reason).append(" serviceClass: ").append(serviceClass).append(" \"").append(PhoneNumberUtils.stringFromStringAndTOA(number, toa)).append("\" ").append(timeSeconds).append(" seconds").toString();
    }

    public String number;
    public int reason;
    public int serviceClass;
    public int status;
    public int timeSeconds;
    public int toa;
}
