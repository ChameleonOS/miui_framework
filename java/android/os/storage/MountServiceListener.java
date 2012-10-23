// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os.storage;


public abstract class MountServiceListener {

    public MountServiceListener() {
    }

    void onStorageStateChange(String s, String s1, String s2) {
    }

    void onUsbMassStorageConnectionChanged(boolean flag) {
    }
}
