// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.app;

import android.content.Context;

public class ExtraStatusBarManager {

    public ExtraStatusBarManager() {
    }

    public static void enableScreenshotNotification(Context context, boolean flag) {
        android.content.ContentResolver contentresolver = context.getContentResolver();
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        android.provider.Settings.System.putInt(contentresolver, "screenshot_notification_enabled", i);
    }

    public static boolean isExpandableUnderFullscreen(Context context) {
        boolean flag = true;
        if(android.provider.Settings.System.getInt(context.getContentResolver(), "status_bar_expandable_under_fullscreen", flag) == 0)
            flag = false;
        return flag;
    }

    public static boolean isExpandableUnderKeyguard(Context context) {
        boolean flag = false;
        if(android.provider.Settings.System.getInt(context.getContentResolver(), "status_bar_expandable_under_keyguard", 0) != 0)
            flag = true;
        return flag;
    }

    public static boolean isScreenshotNotificationEnabled(Context context) {
        boolean flag = true;
        if(android.provider.Settings.System.getInt(context.getContentResolver(), "screenshot_notification_enabled", flag) == 0)
            flag = false;
        return flag;
    }

    public static boolean isShowFlowInfo(Context context) {
        boolean flag = false;
        if(android.provider.Settings.System.getInt(context.getContentResolver(), "status_bar_show_network_assistant", 0) != 0)
            flag = true;
        return flag;
    }

    public static boolean isShowNetworkSpeed(Context context) {
        boolean flag = false;
        if(android.provider.Settings.System.getInt(context.getContentResolver(), "status_bar_show_network_speed", 0) != 0)
            flag = true;
        return flag;
    }

    public static void setExpandableUnderFullscreen(Context context, boolean flag) {
        android.content.ContentResolver contentresolver = context.getContentResolver();
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        android.provider.Settings.System.putInt(contentresolver, "status_bar_expandable_under_fullscreen", i);
    }

    public static void setExpandableUnderKeyguard(Context context, boolean flag) {
        android.content.ContentResolver contentresolver = context.getContentResolver();
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        android.provider.Settings.System.putInt(contentresolver, "status_bar_expandable_under_keyguard", i);
    }

    public static void setShowFlowInfo(Context context, boolean flag) {
        android.content.ContentResolver contentresolver = context.getContentResolver();
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        android.provider.Settings.System.putInt(contentresolver, "status_bar_show_network_assistant", i);
    }

    public static void setShowNetworkSpeed(Context context, boolean flag) {
        android.content.ContentResolver contentresolver = context.getContentResolver();
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        android.provider.Settings.System.putInt(contentresolver, "status_bar_show_network_speed", i);
    }

    public static final String ACTION_EXIT_FULLSCREEN = "com.miui.app.ExtraStatusBarManager.EXIT_FULLSCREEN";
    public static final String ACTION_EXPAND_NOTIFICATIONS_TAB = "com.miui.app.ExtraStatusBarManager.EXPAND_NOTIFICATIONS_TAB";
    public static final String ACTION_EXPAND_TOGGLES_TAB = "com.miui.app.ExtraStatusBarManager.EXPAND_TOGGLE_TAB";
    public static final String ACTION_PICK_TOGGLE_INTENT = "com.miui.app.ExtraStatusBarManager.action_PICK_TOGGLE_INTENT";
    public static final String ACTION_REQUEST_RESTART = "com.miui.app.ExtraStatusBarManager.REQUEST_RESTART";
    public static final String ACTION_STATUSBAR_LOADED = "com.miui.app.ExtraStatusBarManager.LOADED";
    public static final String ACTION_STATUSBAR_UNLOADED = "com.miui.app.ExtraStatusBarManager.UNLOADED";
    public static final String ACTION_TRIGGER_CAMERA_KEY = "com.miui.app.ExtraStatusBarManager.TRIGGER_CAMERA_KEY";
    public static final String ACTION_TRIGGER_TOGGLE = "com.miui.app.ExtraStatusBarManager.action_TRIGGER_TOGGLE";
    public static final String ACTION_TRIGGER_TOGGLE_LOCK = "com.miui.app.ExtraStatusBarManager.TRIGGER_TOGGLE_LOCK";
    public static final String ACTION_TRIGGER_TOGGLE_SCREEN_BUTTONS = "com.miui.app.ExtraStatusBarManager.TRIGGER_TOGGLE_SCREEN_BUTTONS";
    public static final int DISABLE_BACKGROUND = 0x40000000;
    public static final int DISABLE_FOR_KEYGUARD = 0x80000000;
    public static final int DISABLE_FULLSCREEN = 0x20000000;
    public static final String EXTRA_TOGGLE_ID = "com.miui.app.ExtraStatusBarManager.extra_TOGGLE_ID";
}
