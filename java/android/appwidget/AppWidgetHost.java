// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.appwidget;

import android.content.Context;
import android.content.res.Resources;
import android.os.*;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.RemoteViews;
import com.android.internal.appwidget.IAppWidgetService;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package android.appwidget:
//            AppWidgetHostView, AppWidgetProviderInfo

public class AppWidgetHost {
    class UpdateHandler extends Handler {

        public void handleMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 1 3: default 32
        //                       1 33
        //                       2 54
        //                       3 75;
               goto _L1 _L2 _L3 _L4
_L1:
            return;
_L2:
            updateAppWidgetView(message.arg1, (RemoteViews)message.obj);
            continue; /* Loop/switch isn't completed */
_L3:
            onProviderChanged(message.arg1, (AppWidgetProviderInfo)message.obj);
            continue; /* Loop/switch isn't completed */
_L4:
            viewDataChanged(message.arg1, message.arg2);
            if(true) goto _L1; else goto _L5
_L5:
        }

        final AppWidgetHost this$0;

        public UpdateHandler(Looper looper) {
            this$0 = AppWidgetHost.this;
            super(looper);
        }
    }

    class Callbacks extends com.android.internal.appwidget.IAppWidgetHost.Stub {

        public void providerChanged(int i, AppWidgetProviderInfo appwidgetproviderinfo) {
            Message message = mHandler.obtainMessage(2);
            message.arg1 = i;
            message.obj = appwidgetproviderinfo;
            message.sendToTarget();
        }

        public void updateAppWidget(int i, RemoteViews remoteviews) {
            Message message = mHandler.obtainMessage(1);
            message.arg1 = i;
            message.obj = remoteviews;
            message.sendToTarget();
        }

        public void viewDataChanged(int i, int j) {
            Message message = mHandler.obtainMessage(3);
            message.arg1 = i;
            message.arg2 = j;
            message.sendToTarget();
        }

        final AppWidgetHost this$0;

        Callbacks() {
            this$0 = AppWidgetHost.this;
            super();
        }
    }


    public AppWidgetHost(Context context, int i) {
        mCallbacks = new Callbacks();
        mViews = new HashMap();
        mContext = context;
        mHostId = i;
        mHandler = new UpdateHandler(context.getMainLooper());
        mDisplayMetrics = context.getResources().getDisplayMetrics();
        Object obj = sServiceLock;
        obj;
        JVM INSTR monitorenter ;
        if(sService == null)
            sService = com.android.internal.appwidget.IAppWidgetService.Stub.asInterface(ServiceManager.getService("appwidget"));
        return;
    }

    public static void deleteAllHosts() {
        try {
            sService.deleteAllHosts();
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("system server dead?", remoteexception);
        }
    }

    public int allocateAppWidgetId() {
        int i;
        try {
            if(mPackageName == null)
                mPackageName = mContext.getPackageName();
            i = sService.allocateAppWidgetId(mPackageName, mHostId);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("system server dead?", remoteexception);
        }
        return i;
    }

    protected void clearViews() {
        mViews.clear();
    }

    public final AppWidgetHostView createView(Context context, int i, AppWidgetProviderInfo appwidgetproviderinfo) {
        AppWidgetHostView appwidgethostview = onCreateView(context, i, appwidgetproviderinfo);
        appwidgethostview.setAppWidget(i, appwidgetproviderinfo);
        synchronized(mViews) {
            mViews.put(Integer.valueOf(i), appwidgethostview);
        }
        RemoteViews remoteviews;
        try {
            remoteviews = sService.getAppWidgetViews(i);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("system server dead?", remoteexception);
        }
        appwidgethostview.updateAppWidget(remoteviews);
        return appwidgethostview;
        exception;
        hashmap;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void deleteAppWidgetId(int i) {
        HashMap hashmap = mViews;
        hashmap;
        JVM INSTR monitorenter ;
        mViews.remove(Integer.valueOf(i));
        try {
            sService.deleteAppWidgetId(i);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("system server dead?", remoteexception);
        }
        hashmap;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void deleteHost() {
        try {
            sService.deleteHost(mHostId);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("system server dead?", remoteexception);
        }
    }

    protected AppWidgetHostView onCreateView(Context context, int i, AppWidgetProviderInfo appwidgetproviderinfo) {
        return new AppWidgetHostView(context);
    }

    protected void onProviderChanged(int i, AppWidgetProviderInfo appwidgetproviderinfo) {
        appwidgetproviderinfo.minWidth = TypedValue.complexToDimensionPixelSize(appwidgetproviderinfo.minWidth, mDisplayMetrics);
        appwidgetproviderinfo.minHeight = TypedValue.complexToDimensionPixelSize(appwidgetproviderinfo.minHeight, mDisplayMetrics);
        appwidgetproviderinfo.minResizeWidth = TypedValue.complexToDimensionPixelSize(appwidgetproviderinfo.minResizeWidth, mDisplayMetrics);
        appwidgetproviderinfo.minResizeHeight = TypedValue.complexToDimensionPixelSize(appwidgetproviderinfo.minResizeHeight, mDisplayMetrics);
        AppWidgetHostView appwidgethostview;
        synchronized(mViews) {
            appwidgethostview = (AppWidgetHostView)mViews.get(Integer.valueOf(i));
        }
        if(appwidgethostview != null)
            appwidgethostview.resetAppWidget(appwidgetproviderinfo);
        return;
        exception;
        hashmap;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void startListening() {
        ArrayList arraylist = new ArrayList();
        int ai[];
        int i;
        try {
            if(mPackageName == null)
                mPackageName = mContext.getPackageName();
            ai = sService.startListening(mCallbacks, mPackageName, mHostId, arraylist);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("system server dead?", remoteexception);
        }
        i = ai.length;
        for(int j = 0; j < i; j++)
            updateAppWidgetView(ai[j], (RemoteViews)arraylist.get(j));

    }

    public void stopListening() {
        try {
            sService.stopListening(mHostId);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("system server dead?", remoteexception);
        }
    }

    void updateAppWidgetView(int i, RemoteViews remoteviews) {
        AppWidgetHostView appwidgethostview;
        synchronized(mViews) {
            appwidgethostview = (AppWidgetHostView)mViews.get(Integer.valueOf(i));
        }
        if(appwidgethostview != null)
            appwidgethostview.updateAppWidget(remoteviews);
        return;
        exception;
        hashmap;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void viewDataChanged(int i, int j) {
        AppWidgetHostView appwidgethostview;
        synchronized(mViews) {
            appwidgethostview = (AppWidgetHostView)mViews.get(Integer.valueOf(i));
        }
        if(appwidgethostview != null)
            appwidgethostview.viewDataChanged(j);
        return;
        exception;
        hashmap;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static final int HANDLE_PROVIDER_CHANGED = 2;
    static final int HANDLE_UPDATE = 1;
    static final int HANDLE_VIEW_DATA_CHANGED = 3;
    static IAppWidgetService sService;
    static final Object sServiceLock = new Object();
    Callbacks mCallbacks;
    Context mContext;
    private DisplayMetrics mDisplayMetrics;
    Handler mHandler;
    int mHostId;
    String mPackageName;
    final HashMap mViews;

}
