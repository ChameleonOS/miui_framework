// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.util;

import android.content.ComponentName;
import android.content.Context;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.android.internal.app.IUsageStats;

public final class Jlog {

    private Jlog() {
    }

    public static int d(String s, String s1) {
        return 0;
    }

    public static int d(String s, String s1, Throwable throwable) {
        return 0;
    }

    public static int e(String s, String s1) {
        return 0;
    }

    public static int e(String s, String s1, Throwable throwable) {
        return 0;
    }

    public static int i(String s, String s1) {
        return 0;
    }

    public static int i(String s, String s1, Throwable throwable) {
        return 0;
    }

    public static int println(int j, String s, String s1) {
        return 0;
    }

    public static void usage(Context context, String s) {
        ComponentName componentname;
        if(sUsageStatsService == null)
            sUsageStatsService = com.android.internal.app.IUsageStats.Stub.asInterface(ServiceManager.getService("usagestats"));
        componentname = new ComponentName(context.getPackageName(), (new StringBuilder()).append("#").append(s).append("#").append(System.currentTimeMillis()).toString());
        sUsageStatsService.noteLaunchTime(componentname, 0);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static int w(String s, String s1) {
        return 0;
    }

    public static int w(String s, String s1, Throwable throwable) {
        return 0;
    }

    public static int w(String s, Throwable throwable) {
        return 0;
    }

    private static final int LOG_ID_MIUI = 4;
    private static IUsageStats sUsageStatsService;
}
