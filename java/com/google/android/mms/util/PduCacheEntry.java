// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.mms.util;

import com.google.android.mms.pdu.GenericPdu;

public final class PduCacheEntry {

    public PduCacheEntry(GenericPdu genericpdu, int i, long l) {
        mPdu = genericpdu;
        mMessageBox = i;
        mThreadId = l;
    }

    public int getMessageBox() {
        return mMessageBox;
    }

    public GenericPdu getPdu() {
        return mPdu;
    }

    public long getThreadId() {
        return mThreadId;
    }

    private final int mMessageBox;
    private final GenericPdu mPdu;
    private final long mThreadId;
}
