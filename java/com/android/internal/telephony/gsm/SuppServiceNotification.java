// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.gsm;

import android.telephony.PhoneNumberUtils;

public class SuppServiceNotification {

    public SuppServiceNotification() {
    }

    public String toString() {
        StringBuilder stringbuilder = (new StringBuilder()).append(super.toString()).append(" mobile");
        String s;
        if(notificationType == 0)
            s = " originated ";
        else
            s = " terminated ";
        return stringbuilder.append(s).append(" code: ").append(code).append(" index: ").append(index).append(" \"").append(PhoneNumberUtils.stringFromStringAndTOA(number, type)).append("\" ").toString();
    }

    public static final int MO_CODE_CALL_DEFLECTED = 8;
    public static final int MO_CODE_CALL_FORWARDED = 2;
    public static final int MO_CODE_CALL_IS_WAITING = 3;
    public static final int MO_CODE_CLIR_SUPPRESSION_REJECTED = 7;
    public static final int MO_CODE_CUG_CALL = 4;
    public static final int MO_CODE_INCOMING_CALLS_BARRED = 6;
    public static final int MO_CODE_OUTGOING_CALLS_BARRED = 5;
    public static final int MO_CODE_SOME_CF_ACTIVE = 1;
    public static final int MO_CODE_UNCONDITIONAL_CF_ACTIVE = 0;
    public static final int MT_CODE_ADDITIONAL_CALL_FORWARDED = 10;
    public static final int MT_CODE_CALL_CONNECTED_ECT = 8;
    public static final int MT_CODE_CALL_CONNECTING_ECT = 7;
    public static final int MT_CODE_CALL_ON_HOLD = 2;
    public static final int MT_CODE_CALL_RETRIEVED = 3;
    public static final int MT_CODE_CUG_CALL = 1;
    public static final int MT_CODE_DEFLECTED_CALL = 9;
    public static final int MT_CODE_FORWARDED_CALL = 0;
    public static final int MT_CODE_FORWARD_CHECK_RECEIVED = 6;
    public static final int MT_CODE_MULTI_PARTY_CALL = 4;
    public static final int MT_CODE_ON_HOLD_CALL_RELEASED = 5;
    public int code;
    public int index;
    public int notificationType;
    public String number;
    public int type;
}
