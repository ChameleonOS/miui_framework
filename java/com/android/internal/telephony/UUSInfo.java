// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;


public class UUSInfo {

    public UUSInfo() {
        uusType = 0;
        uusDcs = 4;
        uusData = null;
    }

    public UUSInfo(int i, int j, byte abyte0[]) {
        uusType = i;
        uusDcs = j;
        uusData = abyte0;
    }

    public int getDcs() {
        return uusDcs;
    }

    public int getType() {
        return uusType;
    }

    public byte[] getUserData() {
        return uusData;
    }

    public void setDcs(int i) {
        uusDcs = i;
    }

    public void setType(int i) {
        uusType = i;
    }

    public void setUserData(byte abyte0[]) {
        uusData = abyte0;
    }

    public static final int UUS_DCS_IA5c = 4;
    public static final int UUS_DCS_OSIHLP = 1;
    public static final int UUS_DCS_RMCF = 3;
    public static final int UUS_DCS_USP = 0;
    public static final int UUS_DCS_X244 = 2;
    public static final int UUS_TYPE1_IMPLICIT = 0;
    public static final int UUS_TYPE1_NOT_REQUIRED = 2;
    public static final int UUS_TYPE1_REQUIRED = 1;
    public static final int UUS_TYPE2_NOT_REQUIRED = 4;
    public static final int UUS_TYPE2_REQUIRED = 3;
    public static final int UUS_TYPE3_NOT_REQUIRED = 6;
    public static final int UUS_TYPE3_REQUIRED = 5;
    private byte uusData[];
    private int uusDcs;
    private int uusType;
}
