// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.os.RemoteException;

// Referenced classes of package android.app:
//            IAlarmManager, PendingIntent

public class AlarmManager {

    AlarmManager(IAlarmManager ialarmmanager) {
        mService = ialarmmanager;
    }

    public void cancel(PendingIntent pendingintent) {
        mService.remove(pendingintent);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void set(int i, long l, PendingIntent pendingintent) {
        mService.set(i, l, pendingintent);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void setInexactRepeating(int i, long l, long l1, PendingIntent pendingintent) {
        mService.setInexactRepeating(i, l, l1, pendingintent);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void setRepeating(int i, long l, long l1, PendingIntent pendingintent) {
        mService.setRepeating(i, l, l1, pendingintent);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void setTime(long l) {
        mService.setTime(l);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void setTimeZone(String s) {
        mService.setTimeZone(s);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static final int ELAPSED_REALTIME = 3;
    public static final int ELAPSED_REALTIME_WAKEUP = 2;
    public static final long INTERVAL_DAY = 0x5265c00L;
    public static final long INTERVAL_FIFTEEN_MINUTES = 0xdbba0L;
    public static final long INTERVAL_HALF_DAY = 0x2932e00L;
    public static final long INTERVAL_HALF_HOUR = 0x1b7740L;
    public static final long INTERVAL_HOUR = 0x36ee80L;
    public static final int RTC = 1;
    public static final int RTC_WAKEUP;
    private final IAlarmManager mService;
}
