// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;


public class Rasterizer {

    public Rasterizer() {
    }

    private static native void finalizer(int i);

    protected void finalize() throws Throwable {
        finalizer(native_instance);
    }

    int native_instance;
}
