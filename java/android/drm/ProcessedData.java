// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.drm;


public class ProcessedData {

    ProcessedData(byte abyte0[], String s) {
        mAccountId = "_NO_USER";
        mSubscriptionId = "";
        mData = abyte0;
        mAccountId = s;
    }

    ProcessedData(byte abyte0[], String s, String s1) {
        mAccountId = "_NO_USER";
        mSubscriptionId = "";
        mData = abyte0;
        mAccountId = s;
        mSubscriptionId = s1;
    }

    public String getAccountId() {
        return mAccountId;
    }

    public byte[] getData() {
        return mData;
    }

    public String getSubscriptionId() {
        return mSubscriptionId;
    }

    private String mAccountId;
    private final byte mData[];
    private String mSubscriptionId;
}
