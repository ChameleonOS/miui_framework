// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;


public class OperationApplicationException extends Exception {

    public OperationApplicationException() {
        mNumSuccessfulYieldPoints = 0;
    }

    public OperationApplicationException(int i) {
        mNumSuccessfulYieldPoints = i;
    }

    public OperationApplicationException(String s) {
        super(s);
        mNumSuccessfulYieldPoints = 0;
    }

    public OperationApplicationException(String s, int i) {
        super(s);
        mNumSuccessfulYieldPoints = i;
    }

    public OperationApplicationException(String s, Throwable throwable) {
        super(s, throwable);
        mNumSuccessfulYieldPoints = 0;
    }

    public OperationApplicationException(Throwable throwable) {
        super(throwable);
        mNumSuccessfulYieldPoints = 0;
    }

    public int getNumSuccessfulYieldPoints() {
        return mNumSuccessfulYieldPoints;
    }

    private final int mNumSuccessfulYieldPoints;
}
