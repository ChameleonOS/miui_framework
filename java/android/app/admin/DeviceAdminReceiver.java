// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app.admin;

import android.content.*;
import android.os.Bundle;

// Referenced classes of package android.app.admin:
//            DevicePolicyManager

public class DeviceAdminReceiver extends BroadcastReceiver {

    public DeviceAdminReceiver() {
    }

    public DevicePolicyManager getManager(Context context) {
        DevicePolicyManager devicepolicymanager;
        if(mManager != null) {
            devicepolicymanager = mManager;
        } else {
            mManager = (DevicePolicyManager)context.getSystemService("device_policy");
            devicepolicymanager = mManager;
        }
        return devicepolicymanager;
    }

    public ComponentName getWho(Context context) {
        ComponentName componentname;
        if(mWho != null) {
            componentname = mWho;
        } else {
            mWho = new ComponentName(context, getClass());
            componentname = mWho;
        }
        return componentname;
    }

    public CharSequence onDisableRequested(Context context, Intent intent) {
        return null;
    }

    public void onDisabled(Context context, Intent intent) {
    }

    public void onEnabled(Context context, Intent intent) {
    }

    public void onPasswordChanged(Context context, Intent intent) {
    }

    public void onPasswordExpiring(Context context, Intent intent) {
    }

    public void onPasswordFailed(Context context, Intent intent) {
    }

    public void onPasswordSucceeded(Context context, Intent intent) {
    }

    public void onReceive(Context context, Intent intent) {
        String s = intent.getAction();
        if(!"android.app.action.ACTION_PASSWORD_CHANGED".equals(s)) goto _L2; else goto _L1
_L1:
        onPasswordChanged(context, intent);
_L4:
        return;
_L2:
        if("android.app.action.ACTION_PASSWORD_FAILED".equals(s))
            onPasswordFailed(context, intent);
        else
        if("android.app.action.ACTION_PASSWORD_SUCCEEDED".equals(s))
            onPasswordSucceeded(context, intent);
        else
        if("android.app.action.DEVICE_ADMIN_ENABLED".equals(s))
            onEnabled(context, intent);
        else
        if("android.app.action.DEVICE_ADMIN_DISABLE_REQUESTED".equals(s)) {
            CharSequence charsequence = onDisableRequested(context, intent);
            if(charsequence != null)
                getResultExtras(true).putCharSequence("android.app.extra.DISABLE_WARNING", charsequence);
        } else
        if("android.app.action.DEVICE_ADMIN_DISABLED".equals(s))
            onDisabled(context, intent);
        else
        if("android.app.action.ACTION_PASSWORD_EXPIRING".equals(s))
            onPasswordExpiring(context, intent);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static final String ACTION_DEVICE_ADMIN_DISABLED = "android.app.action.DEVICE_ADMIN_DISABLED";
    public static final String ACTION_DEVICE_ADMIN_DISABLE_REQUESTED = "android.app.action.DEVICE_ADMIN_DISABLE_REQUESTED";
    public static final String ACTION_DEVICE_ADMIN_ENABLED = "android.app.action.DEVICE_ADMIN_ENABLED";
    public static final String ACTION_PASSWORD_CHANGED = "android.app.action.ACTION_PASSWORD_CHANGED";
    public static final String ACTION_PASSWORD_EXPIRING = "android.app.action.ACTION_PASSWORD_EXPIRING";
    public static final String ACTION_PASSWORD_FAILED = "android.app.action.ACTION_PASSWORD_FAILED";
    public static final String ACTION_PASSWORD_SUCCEEDED = "android.app.action.ACTION_PASSWORD_SUCCEEDED";
    public static final String DEVICE_ADMIN_META_DATA = "android.app.device_admin";
    public static final String EXTRA_DISABLE_WARNING = "android.app.extra.DISABLE_WARNING";
    private static String TAG = "DevicePolicy";
    private static boolean localLOGV = false;
    private DevicePolicyManager mManager;
    private ComponentName mWho;

}
