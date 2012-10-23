// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;


public class SurfaceSession {

    public SurfaceSession() {
        init();
    }

    private native void destroy();

    private native void init();

    protected void finalize() throws Throwable {
        destroy();
    }

    public native void kill();

    private int mClient;
}
