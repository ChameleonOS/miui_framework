// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;


public abstract class SmsAddress {

    public SmsAddress() {
    }

    public boolean couldBeEmailGateway() {
        boolean flag;
        if(address.length() <= 4)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public String getAddressString() {
        return address;
    }

    public boolean isAlphanumeric() {
        boolean flag;
        if(ton == 5)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isNetworkSpecific() {
        boolean flag;
        if(ton == 3)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static final int TON_ABBREVIATED = 6;
    public static final int TON_ALPHANUMERIC = 5;
    public static final int TON_INTERNATIONAL = 1;
    public static final int TON_NATIONAL = 2;
    public static final int TON_NETWORK = 3;
    public static final int TON_SUBSCRIBER = 4;
    public static final int TON_UNKNOWN;
    public String address;
    public byte origBytes[];
    public int ton;
}
