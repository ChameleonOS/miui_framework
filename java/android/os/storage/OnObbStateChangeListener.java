// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os.storage;


public abstract class OnObbStateChangeListener {

    public OnObbStateChangeListener() {
    }

    public void onObbStateChange(String s, int i) {
    }

    public static final int ERROR_ALREADY_MOUNTED = 24;
    public static final int ERROR_COULD_NOT_MOUNT = 21;
    public static final int ERROR_COULD_NOT_UNMOUNT = 22;
    public static final int ERROR_INTERNAL = 20;
    public static final int ERROR_NOT_MOUNTED = 23;
    public static final int ERROR_PERMISSION_DENIED = 25;
    public static final int MOUNTED = 1;
    public static final int UNMOUNTED = 2;
}
