// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.os.RemoteException;

// Referenced classes of package android.net:
//            IThrottleManager

public class ThrottleManager {

    private ThrottleManager() {
    }

    public ThrottleManager(IThrottleManager ithrottlemanager) {
        if(ithrottlemanager == null) {
            throw new IllegalArgumentException("ThrottleManager() cannot be constructed with null service");
        } else {
            mService = ithrottlemanager;
            return;
        }
    }

    public long getByteCount(String s, int i, int j, int k) {
        long l1 = mService.getByteCount(s, i, j, k);
        long l = l1;
_L2:
        return l;
        RemoteException remoteexception;
        remoteexception;
        l = -1L;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int getCliffLevel(String s, int i) {
        int k = mService.getCliffLevel(s, i);
        int j = k;
_L2:
        return j;
        RemoteException remoteexception;
        remoteexception;
        j = -1;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public long getCliffThreshold(String s, int i) {
        long l1 = mService.getCliffThreshold(s, i);
        long l = l1;
_L2:
        return l;
        RemoteException remoteexception;
        remoteexception;
        l = -1L;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String getHelpUri() {
        String s1 = mService.getHelpUri();
        String s = s1;
_L2:
        return s;
        RemoteException remoteexception;
        remoteexception;
        s = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public long getPeriodStartTime(String s) {
        long l1 = mService.getPeriodStartTime(s);
        long l = l1;
_L2:
        return l;
        RemoteException remoteexception;
        remoteexception;
        l = -1L;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public long getResetTime(String s) {
        long l1 = mService.getResetTime(s);
        long l = l1;
_L2:
        return l;
        RemoteException remoteexception;
        remoteexception;
        l = -1L;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static final int DIRECTION_RX = 1;
    public static final int DIRECTION_TX = 0;
    public static final String EXTRA_CYCLE_END = "cycleEnd";
    public static final String EXTRA_CYCLE_READ = "cycleRead";
    public static final String EXTRA_CYCLE_START = "cycleStart";
    public static final String EXTRA_CYCLE_WRITE = "cycleWrite";
    public static final String EXTRA_THROTTLE_LEVEL = "level";
    public static final int PERIOD_24HOUR = 6;
    public static final int PERIOD_60MIN = 8;
    public static final int PERIOD_60SEC = 10;
    public static final int PERIOD_7DAY = 4;
    public static final int PERIOD_CYCLE = 0;
    public static final int PERIOD_DAY = 5;
    public static final int PERIOD_HOUR = 7;
    public static final int PERIOD_MINUTE = 9;
    public static final int PERIOD_MONTH = 2;
    public static final int PERIOD_SECOND = 11;
    public static final int PERIOD_WEEK = 3;
    public static final int PERIOD_YEAR = 1;
    public static final String POLICY_CHANGED_ACTION = "android.net.thrott.POLICY_CHANGED_ACTION";
    public static final String THROTTLE_ACTION = "android.net.thrott.THROTTLE_ACTION";
    public static final String THROTTLE_POLL_ACTION = "android.net.thrott.POLL_ACTION";
    private IThrottleManager mService;
}
