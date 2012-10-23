// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.Context;
import android.os.*;
import android.util.Log;

// Referenced classes of package android.app:
//            INotificationManager, Notification

public class NotificationManager {

    NotificationManager(Context context, Handler handler) {
        mContext = context;
    }

    public static INotificationManager getService() {
        INotificationManager inotificationmanager;
        if(sService != null) {
            inotificationmanager = sService;
        } else {
            sService = INotificationManager.Stub.asInterface(ServiceManager.getService("notification"));
            inotificationmanager = sService;
        }
        return inotificationmanager;
    }

    public void cancel(int i) {
        cancel(null, i);
    }

    public void cancel(String s, int i) {
        INotificationManager inotificationmanager;
        String s1;
        inotificationmanager = getService();
        s1 = mContext.getPackageName();
        if(localLOGV)
            Log.v(TAG, (new StringBuilder()).append(s1).append(": cancel(").append(i).append(")").toString());
        inotificationmanager.cancelNotificationWithTag(s1, s, i);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void cancelAll() {
        INotificationManager inotificationmanager;
        String s;
        inotificationmanager = getService();
        s = mContext.getPackageName();
        if(localLOGV)
            Log.v(TAG, (new StringBuilder()).append(s).append(": cancelAll()").toString());
        inotificationmanager.cancelAllNotifications(s);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void notify(int i, Notification notification) {
        notify(null, i, notification);
    }

    public void notify(String s, int i, Notification notification) {
        int ai[];
        INotificationManager inotificationmanager;
        String s1;
        ai = new int[1];
        inotificationmanager = getService();
        s1 = mContext.getPackageName();
        if(localLOGV)
            Log.v(TAG, (new StringBuilder()).append(s1).append(": notify(").append(i).append(", ").append(notification).append(")").toString());
        inotificationmanager.enqueueNotificationWithTag(s1, s, i, notification, ai);
        if(i != ai[0])
            Log.w(TAG, (new StringBuilder()).append("notify: id corrupted: sent ").append(i).append(", got back ").append(ai[0]).toString());
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private static String TAG = "NotificationManager";
    private static boolean localLOGV = false;
    private static INotificationManager sService;
    private Context mContext;

}
