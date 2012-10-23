// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.appwidget;

import android.content.*;
import android.content.res.Resources;
import android.os.*;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.RemoteViews;
import com.android.internal.appwidget.IAppWidgetService;
import java.lang.ref.WeakReference;
import java.util.*;

// Referenced classes of package android.appwidget:
//            AppWidgetProviderInfo

public class AppWidgetManager {

    private AppWidgetManager(Context context) {
        mContext = context;
        mDisplayMetrics = context.getResources().getDisplayMetrics();
    }

    public static AppWidgetManager getInstance(Context context) {
        WeakHashMap weakhashmap = sManagerCache;
        weakhashmap;
        JVM INSTR monitorenter ;
        if(sService == null)
            sService = com.android.internal.appwidget.IAppWidgetService.Stub.asInterface(ServiceManager.getService("appwidget"));
        WeakReference weakreference = (WeakReference)sManagerCache.get(context);
        AppWidgetManager appwidgetmanager = null;
        if(weakreference != null)
            appwidgetmanager = (AppWidgetManager)weakreference.get();
        if(appwidgetmanager == null) {
            appwidgetmanager = new AppWidgetManager(context);
            sManagerCache.put(context, new WeakReference(appwidgetmanager));
        }
        return appwidgetmanager;
    }

    public void bindAppWidgetId(int i, ComponentName componentname) {
        try {
            sService.bindAppWidgetId(i, componentname);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("system server dead?", remoteexception);
        }
    }

    public boolean bindAppWidgetIdIfAllowed(int i, ComponentName componentname) {
        boolean flag1;
        if(mContext == null) {
            flag1 = false;
        } else {
            boolean flag;
            try {
                flag = sService.bindAppWidgetIdIfAllowed(mContext.getPackageName(), i, componentname);
            }
            catch(RemoteException remoteexception) {
                throw new RuntimeException("system server dead?", remoteexception);
            }
            flag1 = flag;
        }
        return flag1;
    }

    public void bindRemoteViewsService(int i, Intent intent, IBinder ibinder) {
        try {
            sService.bindRemoteViewsService(i, intent, ibinder);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("system server dead?", remoteexception);
        }
    }

    public int[] getAppWidgetIds(ComponentName componentname) {
        int ai[];
        try {
            ai = sService.getAppWidgetIds(componentname);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("system server dead?", remoteexception);
        }
        return ai;
    }

    public AppWidgetProviderInfo getAppWidgetInfo(int i) {
        AppWidgetProviderInfo appwidgetproviderinfo;
        try {
            appwidgetproviderinfo = sService.getAppWidgetInfo(i);
            if(appwidgetproviderinfo != null) {
                appwidgetproviderinfo.minWidth = TypedValue.complexToDimensionPixelSize(appwidgetproviderinfo.minWidth, mDisplayMetrics);
                appwidgetproviderinfo.minHeight = TypedValue.complexToDimensionPixelSize(appwidgetproviderinfo.minHeight, mDisplayMetrics);
                appwidgetproviderinfo.minResizeWidth = TypedValue.complexToDimensionPixelSize(appwidgetproviderinfo.minResizeWidth, mDisplayMetrics);
                appwidgetproviderinfo.minResizeHeight = TypedValue.complexToDimensionPixelSize(appwidgetproviderinfo.minResizeHeight, mDisplayMetrics);
            }
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("system server dead?", remoteexception);
        }
        return appwidgetproviderinfo;
    }

    public Bundle getAppWidgetOptions(int i) {
        Bundle bundle;
        try {
            bundle = sService.getAppWidgetOptions(i);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("system server dead?", remoteexception);
        }
        return bundle;
    }

    public List getInstalledProviders() {
        List list;
        try {
            list = sService.getInstalledProviders();
            for(Iterator iterator = list.iterator(); iterator.hasNext();) {
                AppWidgetProviderInfo appwidgetproviderinfo = (AppWidgetProviderInfo)iterator.next();
                appwidgetproviderinfo.minWidth = TypedValue.complexToDimensionPixelSize(appwidgetproviderinfo.minWidth, mDisplayMetrics);
                appwidgetproviderinfo.minHeight = TypedValue.complexToDimensionPixelSize(appwidgetproviderinfo.minHeight, mDisplayMetrics);
                appwidgetproviderinfo.minResizeWidth = TypedValue.complexToDimensionPixelSize(appwidgetproviderinfo.minResizeWidth, mDisplayMetrics);
                appwidgetproviderinfo.minResizeHeight = TypedValue.complexToDimensionPixelSize(appwidgetproviderinfo.minResizeHeight, mDisplayMetrics);
            }

        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("system server dead?", remoteexception);
        }
        return list;
    }

    public boolean hasBindAppWidgetPermission(String s) {
        boolean flag;
        try {
            flag = sService.hasBindAppWidgetPermission(s);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("system server dead?", remoteexception);
        }
        return flag;
    }

    public void notifyAppWidgetViewDataChanged(int i, int j) {
        int ai[] = new int[1];
        ai[0] = i;
        notifyAppWidgetViewDataChanged(ai, j);
    }

    public void notifyAppWidgetViewDataChanged(int ai[], int i) {
        try {
            sService.notifyAppWidgetViewDataChanged(ai, i);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("system server dead?", remoteexception);
        }
    }

    public void partiallyUpdateAppWidget(int i, RemoteViews remoteviews) {
        int ai[] = new int[1];
        ai[0] = i;
        partiallyUpdateAppWidget(ai, remoteviews);
    }

    public void partiallyUpdateAppWidget(int ai[], RemoteViews remoteviews) {
        try {
            sService.partiallyUpdateAppWidgetIds(ai, remoteviews);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("system server dead?", remoteexception);
        }
    }

    public void setBindAppWidgetPermission(String s, boolean flag) {
        try {
            sService.setBindAppWidgetPermission(s, flag);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("system server dead?", remoteexception);
        }
    }

    public void unbindRemoteViewsService(int i, Intent intent) {
        try {
            sService.unbindRemoteViewsService(i, intent);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("system server dead?", remoteexception);
        }
    }

    public void updateAppWidget(int i, RemoteViews remoteviews) {
        int ai[] = new int[1];
        ai[0] = i;
        updateAppWidget(ai, remoteviews);
    }

    public void updateAppWidget(ComponentName componentname, RemoteViews remoteviews) {
        try {
            sService.updateAppWidgetProvider(componentname, remoteviews);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("system server dead?", remoteexception);
        }
    }

    public void updateAppWidget(int ai[], RemoteViews remoteviews) {
        try {
            sService.updateAppWidgetIds(ai, remoteviews);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("system server dead?", remoteexception);
        }
    }

    public void updateAppWidgetOptions(int i, Bundle bundle) {
        try {
            sService.updateAppWidgetOptions(i, bundle);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("system server dead?", remoteexception);
        }
    }

    public static final String ACTION_APPWIDGET_BIND = "android.appwidget.action.APPWIDGET_BIND";
    public static final String ACTION_APPWIDGET_CONFIGURE = "android.appwidget.action.APPWIDGET_CONFIGURE";
    public static final String ACTION_APPWIDGET_DELETED = "android.appwidget.action.APPWIDGET_DELETED";
    public static final String ACTION_APPWIDGET_DISABLED = "android.appwidget.action.APPWIDGET_DISABLED";
    public static final String ACTION_APPWIDGET_ENABLED = "android.appwidget.action.APPWIDGET_ENABLED";
    public static final String ACTION_APPWIDGET_OPTIONS_CHANGED = "android.appwidget.action.APPWIDGET_UPDATE_OPTIONS";
    public static final String ACTION_APPWIDGET_PICK = "android.appwidget.action.APPWIDGET_PICK";
    public static final String ACTION_APPWIDGET_UPDATE = "android.appwidget.action.APPWIDGET_UPDATE";
    public static final String EXTRA_APPWIDGET_ID = "appWidgetId";
    public static final String EXTRA_APPWIDGET_IDS = "appWidgetIds";
    public static final String EXTRA_APPWIDGET_OPTIONS = "appWidgetOptions";
    public static final String EXTRA_APPWIDGET_PROVIDER = "appWidgetProvider";
    public static final String EXTRA_CUSTOM_EXTRAS = "customExtras";
    public static final String EXTRA_CUSTOM_INFO = "customInfo";
    public static final int INVALID_APPWIDGET_ID = 0;
    public static final String META_DATA_APPWIDGET_PROVIDER = "android.appwidget.provider";
    public static final String OPTION_APPWIDGET_MAX_HEIGHT = "appWidgetMaxHeight";
    public static final String OPTION_APPWIDGET_MAX_WIDTH = "appWidgetMaxWidth";
    public static final String OPTION_APPWIDGET_MIN_HEIGHT = "appWidgetMinHeight";
    public static final String OPTION_APPWIDGET_MIN_WIDTH = "appWidgetMinWidth";
    static final String TAG = "AppWidgetManager";
    static WeakHashMap sManagerCache = new WeakHashMap();
    static IAppWidgetService sService;
    Context mContext;
    private DisplayMetrics mDisplayMetrics;

}
