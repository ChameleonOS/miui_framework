// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.*;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

// Referenced classes of package android.app:
//            IActivityManager, Application, ActivityThread, Notification

public abstract class Service extends ContextWrapper
    implements ComponentCallbacks2 {

    public Service() {
        super(null);
        mThread = null;
        mClassName = null;
        mToken = null;
        mApplication = null;
        mActivityManager = null;
        mStartCompatibility = false;
    }

    public final void attach(Context context, ActivityThread activitythread, String s, IBinder ibinder, Application application, Object obj) {
        attachBaseContext(context);
        mThread = activitythread;
        mClassName = s;
        mToken = ibinder;
        mApplication = application;
        mActivityManager = (IActivityManager)obj;
        boolean flag;
        if(getApplicationInfo().targetSdkVersion < 5)
            flag = true;
        else
            flag = false;
        mStartCompatibility = flag;
    }

    protected void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        printwriter.println("nothing to dump");
    }

    public final Application getApplication() {
        return mApplication;
    }

    final String getClassName() {
        return mClassName;
    }

    public abstract IBinder onBind(Intent intent);

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onLowMemory() {
    }

    public void onRebind(Intent intent) {
    }

    public void onStart(Intent intent, int i) {
    }

    public int onStartCommand(Intent intent, int i, int j) {
        onStart(intent, j);
        int k;
        if(mStartCompatibility)
            k = 0;
        else
            k = 1;
        return k;
    }

    public void onTaskRemoved(Intent intent) {
    }

    public void onTrimMemory(int i) {
    }

    public boolean onUnbind(Intent intent) {
        return false;
    }

    public final void setForeground(boolean flag) {
        Log.w("Service", (new StringBuilder()).append("setForeground: ignoring old API call on ").append(getClass().getName()).toString());
    }

    public final void startForeground(int i, Notification notification) {
        mActivityManager.setServiceForeground(new ComponentName(this, mClassName), mToken, i, notification, true);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public final void stopForeground(boolean flag) {
        mActivityManager.setServiceForeground(new ComponentName(this, mClassName), mToken, 0, null, flag);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public final void stopSelf() {
        stopSelf(-1);
    }

    public final void stopSelf(int i) {
        if(mActivityManager != null)
            try {
                mActivityManager.stopServiceToken(new ComponentName(this, mClassName), mToken, i);
            }
            catch(RemoteException remoteexception) { }
    }

    public final boolean stopSelfResult(int i) {
        boolean flag = false;
        if(mActivityManager != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        boolean flag1 = mActivityManager.stopServiceToken(new ComponentName(this, mClassName), mToken, i);
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static final int START_CONTINUATION_MASK = 15;
    public static final int START_FLAG_REDELIVERY = 1;
    public static final int START_FLAG_RETRY = 2;
    public static final int START_NOT_STICKY = 2;
    public static final int START_REDELIVER_INTENT = 3;
    public static final int START_STICKY = 1;
    public static final int START_STICKY_COMPATIBILITY = 0;
    public static final int START_TASK_REMOVED_COMPLETE = 1000;
    private static final String TAG = "Service";
    private IActivityManager mActivityManager;
    private Application mApplication;
    private String mClassName;
    private boolean mStartCompatibility;
    private ActivityThread mThread;
    private IBinder mToken;
}
