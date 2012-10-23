// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;


public class StatFs {

    public StatFs(String s) {
        native_setup(s);
    }

    private native void native_finalize();

    private native void native_restat(String s);

    private native void native_setup(String s);

    protected void finalize() {
        native_finalize();
    }

    public native int getAvailableBlocks();

    public native int getBlockCount();

    public native int getBlockSize();

    public native int getFreeBlocks();

    public void restat(String s) {
        native_restat(s);
    }

    private int mNativeContext;
}
