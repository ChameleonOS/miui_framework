// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;


public class DrawFilter {

    public DrawFilter() {
    }

    private static native void nativeDestructor(int i);

    protected void finalize() throws Throwable {
        nativeDestructor(mNativeInt);
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    int mNativeInt;
}
