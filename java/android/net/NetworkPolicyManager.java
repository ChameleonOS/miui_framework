// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.content.Context;
import android.os.RemoteException;
import android.text.format.Time;
import java.io.PrintWriter;

// Referenced classes of package android.net:
//            NetworkPolicy, INetworkPolicyManager, INetworkPolicyListener

public class NetworkPolicyManager {

    public NetworkPolicyManager(INetworkPolicyManager inetworkpolicymanager) {
        if(inetworkpolicymanager == null) {
            throw new IllegalArgumentException("missing INetworkPolicyManager");
        } else {
            mService = inetworkpolicymanager;
            return;
        }
    }

    public static long computeLastCycleBoundary(long l, NetworkPolicy networkpolicy) {
        if(networkpolicy.cycleDay == -1)
            throw new IllegalArgumentException("Unable to compute boundary without cycleDay");
        Time time = new Time(networkpolicy.cycleTimezone);
        time.set(l);
        Time time1 = new Time(time);
        time1.second = 0;
        time1.minute = 0;
        time1.hour = 0;
        snapToCycleDay(time1, networkpolicy.cycleDay);
        if(Time.compare(time1, time) >= 0) {
            Time time2 = new Time(time);
            time2.second = 0;
            time2.minute = 0;
            time2.hour = 0;
            time2.monthDay = 1;
            time2.month = -1 + time2.month;
            time2.normalize(true);
            time1.set(time2);
            snapToCycleDay(time1, networkpolicy.cycleDay);
        }
        return time1.toMillis(true);
    }

    public static long computeNextCycleBoundary(long l, NetworkPolicy networkpolicy) {
        if(networkpolicy.cycleDay == -1)
            throw new IllegalArgumentException("Unable to compute boundary without cycleDay");
        Time time = new Time(networkpolicy.cycleTimezone);
        time.set(l);
        Time time1 = new Time(time);
        time1.second = 0;
        time1.minute = 0;
        time1.hour = 0;
        snapToCycleDay(time1, networkpolicy.cycleDay);
        if(Time.compare(time1, time) <= 0) {
            Time time2 = new Time(time);
            time2.second = 0;
            time2.minute = 0;
            time2.hour = 0;
            time2.monthDay = 1;
            time2.month = 1 + time2.month;
            time2.normalize(true);
            time1.set(time2);
            snapToCycleDay(time1, networkpolicy.cycleDay);
        }
        return time1.toMillis(true);
    }

    public static void dumpPolicy(PrintWriter printwriter, int i) {
        printwriter.write("[");
        if((i & 1) != 0)
            printwriter.write("REJECT_METERED_BACKGROUND");
        printwriter.write("]");
    }

    public static void dumpRules(PrintWriter printwriter, int i) {
        printwriter.write("[");
        if((i & 1) != 0)
            printwriter.write("REJECT_METERED");
        printwriter.write("]");
    }

    public static NetworkPolicyManager from(Context context) {
        return (NetworkPolicyManager)context.getSystemService("netpolicy");
    }

    public static NetworkPolicyManager getSystemService(Context context) {
        return from(context);
    }

    public static boolean isUidValidForPolicy(Context context, int i) {
        boolean flag;
        if(i < 10000 || i > 19999)
            flag = false;
        else
            flag = true;
        return flag;
    }

    public static void snapToCycleDay(Time time, int i) {
        if(i > time.getActualMaximum(4)) {
            time.month = 1 + time.month;
            time.monthDay = 1;
            time.second = -1;
        } else {
            time.monthDay = i;
        }
        time.normalize(true);
    }

    public int getAppPolicy(int i) {
        int k = mService.getAppPolicy(i);
        int j = k;
_L2:
        return j;
        RemoteException remoteexception;
        remoteexception;
        j = 0;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int[] getAppsWithPolicy(int i) {
        int ai1[] = mService.getAppsWithPolicy(i);
        int ai[] = ai1;
_L2:
        return ai;
        RemoteException remoteexception;
        remoteexception;
        ai = new int[0];
        if(true) goto _L2; else goto _L1
_L1:
    }

    public NetworkPolicy[] getNetworkPolicies() {
        NetworkPolicy anetworkpolicy1[] = mService.getNetworkPolicies();
        NetworkPolicy anetworkpolicy[] = anetworkpolicy1;
_L2:
        return anetworkpolicy;
        RemoteException remoteexception;
        remoteexception;
        anetworkpolicy = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean getRestrictBackground() {
        boolean flag1 = mService.getRestrictBackground();
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void registerListener(INetworkPolicyListener inetworkpolicylistener) {
        mService.registerListener(inetworkpolicylistener);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void setAppPolicy(int i, int j) {
        mService.setAppPolicy(i, j);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void setNetworkPolicies(NetworkPolicy anetworkpolicy[]) {
        mService.setNetworkPolicies(anetworkpolicy);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void setRestrictBackground(boolean flag) {
        mService.setRestrictBackground(flag);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void unregisterListener(INetworkPolicyListener inetworkpolicylistener) {
        mService.unregisterListener(inetworkpolicylistener);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private static final boolean ALLOW_PLATFORM_APP_POLICY = true;
    public static final String EXTRA_NETWORK_TEMPLATE = "android.net.NETWORK_TEMPLATE";
    public static final int POLICY_NONE = 0;
    public static final int POLICY_REJECT_METERED_BACKGROUND = 1;
    public static final int RULE_ALLOW_ALL = 0;
    public static final int RULE_REJECT_METERED = 1;
    private INetworkPolicyManager mService;
}
