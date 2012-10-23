// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.*;
import android.util.AttributeSet;
import java.io.*;

// Referenced classes of package android.content:
//            Intent, ServiceConnection, ContentResolver, SharedPreferences, 
//            ComponentCallbacks, BroadcastReceiver, IntentFilter, ComponentName, 
//            IntentSender

public abstract class Context {

    public Context() {
    }

    public abstract boolean bindService(Intent intent, ServiceConnection serviceconnection, int i);

    public boolean bindService(Intent intent, ServiceConnection serviceconnection, int i, int j) {
        throw new RuntimeException("Not implemented. Must override in a subclass.");
    }

    public abstract int checkCallingOrSelfPermission(String s);

    public abstract int checkCallingOrSelfUriPermission(Uri uri, int i);

    public abstract int checkCallingPermission(String s);

    public abstract int checkCallingUriPermission(Uri uri, int i);

    public abstract int checkPermission(String s, int i, int j);

    public abstract int checkUriPermission(Uri uri, int i, int j, int k);

    public abstract int checkUriPermission(Uri uri, String s, String s1, int i, int j, int k);

    public abstract void clearWallpaper() throws IOException;

    public abstract Context createPackageContext(String s, int i) throws android.content.pm.PackageManager.NameNotFoundException;

    public abstract String[] databaseList();

    public abstract boolean deleteDatabase(String s);

    public abstract boolean deleteFile(String s);

    public abstract void enforceCallingOrSelfPermission(String s, String s1);

    public abstract void enforceCallingOrSelfUriPermission(Uri uri, int i, String s);

    public abstract void enforceCallingPermission(String s, String s1);

    public abstract void enforceCallingUriPermission(Uri uri, int i, String s);

    public abstract void enforcePermission(String s, int i, int j, String s1);

    public abstract void enforceUriPermission(Uri uri, int i, int j, int k, String s);

    public abstract void enforceUriPermission(Uri uri, String s, String s1, int i, int j, int k, String s2);

    public abstract String[] fileList();

    public abstract Context getApplicationContext();

    public abstract ApplicationInfo getApplicationInfo();

    public abstract AssetManager getAssets();

    public abstract File getCacheDir();

    public abstract ClassLoader getClassLoader();

    public abstract ContentResolver getContentResolver();

    public abstract File getDatabasePath(String s);

    public abstract File getDir(String s, int i);

    public abstract File getExternalCacheDir();

    public abstract File getExternalFilesDir(String s);

    public abstract File getFileStreamPath(String s);

    public abstract File getFilesDir();

    public abstract Looper getMainLooper();

    public abstract File getObbDir();

    public abstract String getPackageCodePath();

    public abstract PackageManager getPackageManager();

    public abstract String getPackageName();

    public abstract String getPackageResourcePath();

    public abstract Resources getResources();

    public abstract SharedPreferences getSharedPreferences(String s, int i);

    public abstract File getSharedPrefsFile(String s);

    public final String getString(int i) {
        return getResources().getString(i);
    }

    public final transient String getString(int i, Object aobj[]) {
        return getResources().getString(i, aobj);
    }

    public abstract Object getSystemService(String s);

    public final CharSequence getText(int i) {
        return getResources().getText(i);
    }

    public abstract android.content.res.Resources.Theme getTheme();

    public int getThemeResId() {
        return 0;
    }

    public abstract Drawable getWallpaper();

    public abstract int getWallpaperDesiredMinimumHeight();

    public abstract int getWallpaperDesiredMinimumWidth();

    public abstract void grantUriPermission(String s, Uri uri, int i);

    public boolean isRestricted() {
        return false;
    }

    public final TypedArray obtainStyledAttributes(int i, int ai[]) throws android.content.res.Resources.NotFoundException {
        return getTheme().obtainStyledAttributes(i, ai);
    }

    public final TypedArray obtainStyledAttributes(AttributeSet attributeset, int ai[]) {
        return getTheme().obtainStyledAttributes(attributeset, ai, 0, 0);
    }

    public final TypedArray obtainStyledAttributes(AttributeSet attributeset, int ai[], int i, int j) {
        return getTheme().obtainStyledAttributes(attributeset, ai, i, j);
    }

    public final TypedArray obtainStyledAttributes(int ai[]) {
        return getTheme().obtainStyledAttributes(ai);
    }

    public abstract FileInputStream openFileInput(String s) throws FileNotFoundException;

    public abstract FileOutputStream openFileOutput(String s, int i) throws FileNotFoundException;

    public abstract SQLiteDatabase openOrCreateDatabase(String s, int i, android.database.sqlite.SQLiteDatabase.CursorFactory cursorfactory);

    public abstract SQLiteDatabase openOrCreateDatabase(String s, int i, android.database.sqlite.SQLiteDatabase.CursorFactory cursorfactory, DatabaseErrorHandler databaseerrorhandler);

    public abstract Drawable peekWallpaper();

    public void registerComponentCallbacks(ComponentCallbacks componentcallbacks) {
        getApplicationContext().registerComponentCallbacks(componentcallbacks);
    }

    public abstract Intent registerReceiver(BroadcastReceiver broadcastreceiver, IntentFilter intentfilter);

    public abstract Intent registerReceiver(BroadcastReceiver broadcastreceiver, IntentFilter intentfilter, String s, Handler handler);

    public abstract void removeStickyBroadcast(Intent intent);

    public abstract void revokeUriPermission(Uri uri, int i);

    public abstract void sendBroadcast(Intent intent);

    public void sendBroadcast(Intent intent, int i) {
        throw new RuntimeException("Not implemented. Must override in a subclass.");
    }

    public abstract void sendBroadcast(Intent intent, String s);

    public abstract void sendOrderedBroadcast(Intent intent, String s);

    public abstract void sendOrderedBroadcast(Intent intent, String s, BroadcastReceiver broadcastreceiver, Handler handler, int i, String s1, Bundle bundle);

    public abstract void sendStickyBroadcast(Intent intent);

    public abstract void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver broadcastreceiver, Handler handler, int i, String s, Bundle bundle);

    public abstract void setTheme(int i);

    public abstract void setWallpaper(Bitmap bitmap) throws IOException;

    public abstract void setWallpaper(InputStream inputstream) throws IOException;

    public abstract void startActivities(Intent aintent[]);

    public abstract void startActivities(Intent aintent[], Bundle bundle);

    public abstract void startActivity(Intent intent);

    public abstract void startActivity(Intent intent, Bundle bundle);

    public abstract boolean startInstrumentation(ComponentName componentname, String s, Bundle bundle);

    public abstract void startIntentSender(IntentSender intentsender, Intent intent, int i, int j, int k) throws IntentSender.SendIntentException;

    public abstract void startIntentSender(IntentSender intentsender, Intent intent, int i, int j, int k, Bundle bundle) throws IntentSender.SendIntentException;

    public abstract ComponentName startService(Intent intent);

    public abstract boolean stopService(Intent intent);

    public abstract void unbindService(ServiceConnection serviceconnection);

    public void unregisterComponentCallbacks(ComponentCallbacks componentcallbacks) {
        getApplicationContext().unregisterComponentCallbacks(componentcallbacks);
    }

    public abstract void unregisterReceiver(BroadcastReceiver broadcastreceiver);

    public static final String ACCESSIBILITY_SERVICE = "accessibility";
    public static final String ACCOUNT_SERVICE = "account";
    public static final String ACTIVITY_SERVICE = "activity";
    public static final String ALARM_SERVICE = "alarm";
    public static final String APPWIDGET_SERVICE = "appwidget";
    public static final String AUDIO_SERVICE = "audio";
    public static final String BACKUP_SERVICE = "backup";
    public static final int BIND_ABOVE_CLIENT = 8;
    public static final int BIND_ADJUST_WITH_ACTIVITY = 128;
    public static final int BIND_ALLOW_OOM_MANAGEMENT = 16;
    public static final int BIND_AUTO_CREATE = 1;
    public static final int BIND_DEBUG_UNBIND = 2;
    public static final int BIND_IMPORTANT = 64;
    public static final int BIND_NOT_FOREGROUND = 4;
    public static final int BIND_NOT_VISIBLE = 0x40000000;
    public static final int BIND_WAIVE_PRIORITY = 32;
    public static final String CLIPBOARD_SERVICE = "clipboard";
    public static final String CONNECTIVITY_SERVICE = "connectivity";
    public static final int CONTEXT_IGNORE_SECURITY = 2;
    public static final int CONTEXT_INCLUDE_CODE = 1;
    public static final int CONTEXT_RESTRICTED = 4;
    public static final String COUNTRY_DETECTOR = "country_detector";
    public static final String DEVICE_POLICY_SERVICE = "device_policy";
    public static final String DOWNLOAD_SERVICE = "download";
    public static final String DROPBOX_SERVICE = "dropbox";
    public static final String INPUT_METHOD_SERVICE = "input_method";
    public static final String INPUT_SERVICE = "input";
    public static final String KEYGUARD_SERVICE = "keyguard";
    public static final String LAYOUT_INFLATER_SERVICE = "layout_inflater";
    public static final String LOCATION_SERVICE = "location";
    public static final String MEDIA_ROUTER_SERVICE = "media_router";
    public static final int MODE_APPEND = 32768;
    public static final int MODE_ENABLE_WRITE_AHEAD_LOGGING = 8;
    public static final int MODE_MULTI_PROCESS = 4;
    public static final int MODE_PRIVATE = 0;
    public static final int MODE_WORLD_READABLE = 1;
    public static final int MODE_WORLD_WRITEABLE = 2;
    public static final String NETWORKMANAGEMENT_SERVICE = "network_management";
    public static final String NETWORK_POLICY_SERVICE = "netpolicy";
    public static final String NETWORK_STATS_SERVICE = "netstats";
    public static final String NFC_SERVICE = "nfc";
    public static final String NOTIFICATION_SERVICE = "notification";
    public static final String NSD_SERVICE = "servicediscovery";
    public static final String POWER_SERVICE = "power";
    public static final String SCHEDULING_POLICY_SERVICE = "scheduling_policy";
    public static final String SEARCH_SERVICE = "search";
    public static final String SENSOR_SERVICE = "sensor";
    public static final String SERIAL_SERVICE = "serial";
    public static final String SIP_SERVICE = "sip";
    public static final String STATUS_BAR_SERVICE = "statusbar";
    public static final String STORAGE_SERVICE = "storage";
    public static final String TELEPHONY_SERVICE = "phone";
    public static final String TEXT_SERVICES_MANAGER_SERVICE = "textservices";
    public static final String THROTTLE_SERVICE = "throttle";
    public static final String UI_MODE_SERVICE = "uimode";
    public static final String UPDATE_LOCK_SERVICE = "updatelock";
    public static final String USB_SERVICE = "usb";
    public static final String VIBRATOR_SERVICE = "vibrator";
    public static final String WALLPAPER_SERVICE = "wallpaper";
    public static final String WIFI_P2P_SERVICE = "wifip2p";
    public static final String WIFI_SERVICE = "wifi";
    public static final String WINDOW_SERVICE = "window";
}
