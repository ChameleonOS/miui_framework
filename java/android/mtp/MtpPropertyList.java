// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.mtp;


class MtpPropertyList {

    public MtpPropertyList(int i, int j) {
        mMaxCount = i;
        mResult = j;
        mObjectHandles = new int[i];
        mPropertyCodes = new int[i];
        mDataTypes = new int[i];
    }

    public void append(int i, int j, int k, long l) {
        int i1 = mCount;
        mCount = i1 + 1;
        if(mLongValues == null)
            mLongValues = new long[mMaxCount];
        mObjectHandles[i1] = i;
        mPropertyCodes[i1] = j;
        mDataTypes[i1] = k;
        mLongValues[i1] = l;
    }

    public void append(int i, int j, String s) {
        int k = mCount;
        mCount = k + 1;
        if(mStringValues == null)
            mStringValues = new String[mMaxCount];
        mObjectHandles[k] = i;
        mPropertyCodes[k] = j;
        mDataTypes[k] = 65535;
        mStringValues[k] = s;
    }

    public void setResult(int i) {
        mResult = i;
    }

    private int mCount;
    public final int mDataTypes[];
    public long mLongValues[];
    private final int mMaxCount;
    public final int mObjectHandles[];
    public final int mPropertyCodes[];
    public int mResult;
    public String mStringValues[];
}
