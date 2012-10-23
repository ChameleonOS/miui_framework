// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;


public class IccRefreshResponse {

    public IccRefreshResponse() {
    }

    public String toString() {
        return (new StringBuilder()).append("{").append(refreshResult).append(", ").append(aid).append(", ").append(efId).append("}").toString();
    }

    public static final int REFRESH_RESULT_FILE_UPDATE = 0;
    public static final int REFRESH_RESULT_INIT = 1;
    public static final int REFRESH_RESULT_RESET = 2;
    public String aid;
    public int efId;
    public int refreshResult;
}
