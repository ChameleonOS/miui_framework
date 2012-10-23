// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.gsm;


public interface CallFailCause {

    public static final int ACM_LIMIT_EXCEEDED = 68;
    public static final int BEARER_NOT_AVAIL = 58;
    public static final int CALL_BARRED = 240;
    public static final int CHANNEL_NOT_AVAIL = 44;
    public static final int ERROR_UNSPECIFIED = 65535;
    public static final int FDN_BLOCKED = 241;
    public static final int NORMAL_CLEARING = 16;
    public static final int NORMAL_UNSPECIFIED = 31;
    public static final int NO_CIRCUIT_AVAIL = 34;
    public static final int NUMBER_CHANGED = 22;
    public static final int QOS_NOT_AVAIL = 49;
    public static final int STATUS_ENQUIRY = 30;
    public static final int SWITCHING_CONGESTION = 42;
    public static final int TEMPORARY_FAILURE = 41;
    public static final int UNOBTAINABLE_NUMBER = 1;
    public static final int USER_BUSY = 17;
}
