// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.appwidget;

import android.content.*;
import android.os.Bundle;

// Referenced classes of package android.appwidget:
//            AppWidgetManager

public class AppWidgetProvider extends BroadcastReceiver {

    public AppWidgetProvider() {
    }

    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appwidgetmanager, int i, Bundle bundle) {
    }

    public void onDeleted(Context context, int ai[]) {
    }

    public void onDisabled(Context context) {
    }

    public void onEnabled(Context context) {
    }

    public void onReceive(Context context, Intent intent) {
        String s = intent.getAction();
        if(!"android.appwidget.action.APPWIDGET_UPDATE".equals(s)) goto _L2; else goto _L1
_L1:
        Bundle bundle3 = intent.getExtras();
        if(bundle3 != null) {
            int ai1[] = bundle3.getIntArray("appWidgetIds");
            if(ai1 != null && ai1.length > 0)
                onUpdate(context, AppWidgetManager.getInstance(context), ai1);
        }
_L4:
        return;
_L2:
        if("android.appwidget.action.APPWIDGET_DELETED".equals(s)) {
            Bundle bundle2 = intent.getExtras();
            if(bundle2 != null && bundle2.containsKey("appWidgetId")) {
                int j = bundle2.getInt("appWidgetId");
                int ai[] = new int[1];
                ai[0] = j;
                onDeleted(context, ai);
            }
        } else
        if("android.appwidget.action.APPWIDGET_UPDATE_OPTIONS".equals(s)) {
            Bundle bundle = intent.getExtras();
            if(bundle != null && bundle.containsKey("appWidgetId") && bundle.containsKey("appWidgetOptions")) {
                int i = bundle.getInt("appWidgetId");
                Bundle bundle1 = bundle.getBundle("appWidgetOptions");
                onAppWidgetOptionsChanged(context, AppWidgetManager.getInstance(context), i, bundle1);
            }
        } else
        if("android.appwidget.action.APPWIDGET_ENABLED".equals(s))
            onEnabled(context);
        else
        if("android.appwidget.action.APPWIDGET_DISABLED".equals(s))
            onDisabled(context);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void onUpdate(Context context, AppWidgetManager appwidgetmanager, int ai[]) {
    }
}
