// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.util.Log;

// Referenced classes of package com.android.internal.telephony:
//            Phone

public class TelephonyCapabilities {

    protected TelephonyCapabilities() {
    }

    public static int getDeviceIdLabel(Phone phone) {
        int i;
        if(phone.getPhoneType() == 1)
            i = 0x10400d6;
        else
        if(phone.getPhoneType() == 2) {
            i = 0x10400d7;
        } else {
            Log.w("TelephonyCapabilities", (new StringBuilder()).append("getDeviceIdLabel: no known label for phone ").append(phone.getPhoneName()).toString());
            i = 0;
        }
        return i;
    }

    public static boolean supportsAdn(int i) {
        boolean flag = true;
        if(i != flag)
            flag = false;
        return flag;
    }

    public static boolean supportsAnswerAndHold(Phone phone) {
        boolean flag = true;
        if(phone.getPhoneType() != flag && phone.getPhoneType() != 3)
            flag = false;
        return flag;
    }

    public static boolean supportsConferenceCallManagement(Phone phone) {
        boolean flag = true;
        if(phone.getPhoneType() != flag && phone.getPhoneType() != 3)
            flag = false;
        return flag;
    }

    public static boolean supportsEcm(Phone phone) {
        boolean flag;
        if(phone.getPhoneType() == 2)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean supportsHoldAndUnhold(Phone phone) {
        boolean flag = true;
        if(phone.getPhoneType() != flag && phone.getPhoneType() != 3)
            flag = false;
        return flag;
    }

    public static boolean supportsNetworkSelection(Phone phone) {
        boolean flag = true;
        if(phone.getPhoneType() != flag)
            flag = false;
        return flag;
    }

    public static boolean supportsOtasp(Phone phone) {
        boolean flag;
        if(phone.getPhoneType() == 2)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean supportsVoiceMessageCount(Phone phone) {
        boolean flag;
        if(phone.getPhoneType() == 2)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static final String LOG_TAG = "TelephonyCapabilities";
}
