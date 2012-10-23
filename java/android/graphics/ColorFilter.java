// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;


public class ColorFilter {

    public ColorFilter() {
    }

    private static native void finalizer(int i, int j);

    protected void finalize() throws Throwable {
        super.finalize();
        finalizer(native_instance, nativeColorFilter);
        return;
        Exception exception;
        exception;
        finalizer(native_instance, nativeColorFilter);
        throw exception;
    }

    public int nativeColorFilter;
    int native_instance;
}
