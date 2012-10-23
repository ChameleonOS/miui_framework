// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cdma;


public final class EriInfo {

    public EriInfo(int i, int j, int k, String s, int l, int i1) {
        mRoamingIndicator = i;
        mIconIndex = j;
        mIconMode = k;
        mEriText = s;
        mCallPromptId = l;
        mAlertId = i1;
    }

    public static final int ROAMING_ICON_MODE_FLASH = 1;
    public static final int ROAMING_ICON_MODE_NORMAL = 0;
    public static final int ROAMING_INDICATOR_FLASH = 2;
    public static final int ROAMING_INDICATOR_OFF = 1;
    public static final int ROAMING_INDICATOR_ON;
    public int mAlertId;
    public int mCallPromptId;
    public String mEriText;
    public int mIconIndex;
    public int mIconMode;
    public int mRoamingIndicator;
}
