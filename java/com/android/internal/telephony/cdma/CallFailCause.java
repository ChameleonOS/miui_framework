// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cdma;


public interface CallFailCause {

    public static final int ACM_LIMIT_EXCEEDED = 68;
    public static final int CALL_BARRED = 240;
    public static final int CDMA_ACCESS_BLOCKED = 1009;
    public static final int CDMA_ACCESS_FAILURE = 1006;
    public static final int CDMA_DROP = 1001;
    public static final int CDMA_INTERCEPT = 1002;
    public static final int CDMA_LOCKED_UNTIL_POWER_CYCLE = 1000;
    public static final int CDMA_NOT_EMERGENCY = 1008;
    public static final int CDMA_PREEMPTED = 1007;
    public static final int CDMA_REORDER = 1003;
    public static final int CDMA_RETRY_ORDER = 1005;
    public static final int CDMA_SO_REJECT = 1004;
    public static final int ERROR_UNSPECIFIED = 65535;
    public static final int FDN_BLOCKED = 241;
    public static final int NORMAL_CLEARING = 16;
    public static final int NORMAL_UNSPECIFIED = 31;
    public static final int NO_CIRCUIT_AVAIL = 34;
    public static final int USER_BUSY = 17;
}
