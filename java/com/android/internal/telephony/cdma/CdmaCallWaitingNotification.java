// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cdma;

import android.util.Log;
import com.android.internal.telephony.Connection;

public class CdmaCallWaitingNotification {

    public CdmaCallWaitingNotification() {
        number = null;
        numberPresentation = 0;
        name = null;
        namePresentation = 0;
        numberType = 0;
        numberPlan = 0;
        isPresent = 0;
        signalType = 0;
        alertPitch = 0;
        signal = 0;
    }

    public static int presentationFromCLIP(int i) {
        i;
        JVM INSTR tableswitch 0 2: default 28
    //                   0 59
    //                   1 66
    //                   2 73;
           goto _L1 _L2 _L3 _L4
_L1:
        int j;
        Log.d("CDMA", (new StringBuilder()).append("Unexpected presentation ").append(i).toString());
        j = Connection.PRESENTATION_UNKNOWN;
_L6:
        return j;
_L2:
        j = Connection.PRESENTATION_ALLOWED;
        continue; /* Loop/switch isn't completed */
_L3:
        j = Connection.PRESENTATION_RESTRICTED;
        continue; /* Loop/switch isn't completed */
_L4:
        j = Connection.PRESENTATION_UNKNOWN;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public String toString() {
        return (new StringBuilder()).append(super.toString()).append("Call Waiting Notification  ").append(" number: ").append(number).append(" numberPresentation: ").append(numberPresentation).append(" name: ").append(name).append(" namePresentation: ").append(namePresentation).append(" numberType: ").append(numberType).append(" numberPlan: ").append(numberPlan).append(" isPresent: ").append(isPresent).append(" signalType: ").append(signalType).append(" alertPitch: ").append(alertPitch).append(" signal: ").append(signal).toString();
    }

    static final String LOG_TAG = "CDMA";
    public int alertPitch;
    public int isPresent;
    public String name;
    public int namePresentation;
    public String number;
    public int numberPlan;
    public int numberPresentation;
    public int numberType;
    public int signal;
    public int signalType;
}
