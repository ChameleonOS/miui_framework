// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;


public class Credentials {

    public Credentials(int i, int j, int k) {
        pid = i;
        uid = j;
        gid = k;
    }

    public int getGid() {
        return gid;
    }

    public int getPid() {
        return pid;
    }

    public int getUid() {
        return uid;
    }

    private final int gid;
    private final int pid;
    private final int uid;
}
