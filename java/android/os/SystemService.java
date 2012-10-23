// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;


// Referenced classes of package android.os:
//            SystemProperties

public class SystemService {

    public SystemService() {
    }

    public static void restart(String s) {
        SystemProperties.set("ctl.restart", s);
    }

    public static void start(String s) {
        SystemProperties.set("ctl.start", s);
    }

    public static void stop(String s) {
        SystemProperties.set("ctl.stop", s);
    }
}
