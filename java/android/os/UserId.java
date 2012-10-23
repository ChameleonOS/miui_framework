// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;


// Referenced classes of package android.os:
//            Binder, Process

public final class UserId {

    public UserId() {
    }

    public static final int getAppId(int i) {
        return i % 0x186a0;
    }

    public static final int getCallingUserId() {
        return getUserId(Binder.getCallingUid());
    }

    public static final int getUid(int i, int j) {
        return i * 0x186a0 + j % 0x186a0;
    }

    public static final int getUserId(int i) {
        return i / 0x186a0;
    }

    public static boolean isApp(int i) {
        boolean flag = false;
        if(i > 0) {
            int j = getAppId(i);
            if(j >= 10000 && j <= 19999)
                flag = true;
        }
        return flag;
    }

    public static final boolean isIsolated(int i) {
        int j = getAppId(i);
        boolean flag;
        if(j >= 0x182b8 && j <= 0x1869f)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static final boolean isSameApp(int i, int j) {
        boolean flag;
        if(getAppId(i) == getAppId(j))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static final boolean isSameUser(int i, int j) {
        boolean flag;
        if(getUserId(i) == getUserId(j))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static final int myUserId() {
        return getUserId(Process.myUid());
    }

    public static final boolean MU_ENABLED = true;
    public static final int PER_USER_RANGE = 0x186a0;
    public static final int USER_ALL = -1;
}
