// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.*;
import java.io.*;

// Referenced classes of package android.content:
//            Context, Intent, ServiceConnection, ContentResolver, 
//            SharedPreferences, BroadcastReceiver, IntentFilter, ComponentName, 
//            IntentSender

public class ContextWrapper extends Context {

    public ContextWrapper(Context context) {
        mBase = context;
    }

    protected void attachBaseContext(Context context) {
        if(mBase != null) {
            throw new IllegalStateException("Base context already set");
        } else {
            mBase = context;
            return;
        }
    }

    public boolean bindService(Intent intent, ServiceConnection serviceconnection, int i) {
        return mBase.bindService(intent, serviceconnection, i);
    }

    public boolean bindService(Intent intent, ServiceConnection serviceconnection, int i, int j) {
        return mBase.bindService(intent, serviceconnection, i, j);
    }

    public int checkCallingOrSelfPermission(String s) {
        return mBase.checkCallingOrSelfPermission(s);
    }

    public int checkCallingOrSelfUriPermission(Uri uri, int i) {
        return mBase.checkCallingOrSelfUriPermission(uri, i);
    }

    public int checkCallingPermission(String s) {
        return mBase.checkCallingPermission(s);
    }

    public int checkCallingUriPermission(Uri uri, int i) {
        return mBase.checkCallingUriPermission(uri, i);
    }

    public int checkPermission(String s, int i, int j) {
        return mBase.checkPermission(s, i, j);
    }

    public int checkUriPermission(Uri uri, int i, int j, int k) {
        return mBase.checkUriPermission(uri, i, j, k);
    }

    public int checkUriPermission(Uri uri, String s, String s1, int i, int j, int k) {
        return mBase.checkUriPermission(uri, s, s1, i, j, k);
    }

    public void clearWallpaper() throws IOException {
        mBase.clearWallpaper();
    }

    public Context createPackageContext(String s, int i) throws android.content.pm.PackageManager.NameNotFoundException {
        return mBase.createPackageContext(s, i);
    }

    public String[] databaseList() {
        return mBase.databaseList();
    }

    public boolean deleteDatabase(String s) {
        return mBase.deleteDatabase(s);
    }

    public boolean deleteFile(String s) {
        return mBase.deleteFile(s);
    }

    public void enforceCallingOrSelfPermission(String s, String s1) {
        mBase.enforceCallingOrSelfPermission(s, s1);
    }

    public void enforceCallingOrSelfUriPermission(Uri uri, int i, String s) {
        mBase.enforceCallingOrSelfUriPermission(uri, i, s);
    }

    public void enforceCallingPermission(String s, String s1) {
        mBase.enforceCallingPermission(s, s1);
    }

    public void enforceCallingUriPermission(Uri uri, int i, String s) {
        mBase.enforceCallingUriPermission(uri, i, s);
    }

    public void enforcePermission(String s, int i, int j, String s1) {
        mBase.enforcePermission(s, i, j, s1);
    }

    public void enforceUriPermission(Uri uri, int i, int j, int k, String s) {
        mBase.enforceUriPermission(uri, i, j, k, s);
    }

    public void enforceUriPermission(Uri uri, String s, String s1, int i, int j, int k, String s2) {
        mBase.enforceUriPermission(uri, s, s1, i, j, k, s2);
    }

    public String[] fileList() {
        return mBase.fileList();
    }

    public Context getApplicationContext() {
        return mBase.getApplicationContext();
    }

    public ApplicationInfo getApplicationInfo() {
        return mBase.getApplicationInfo();
    }

    public AssetManager getAssets() {
        return mBase.getAssets();
    }

    public Context getBaseContext() {
        return mBase;
    }

    public File getCacheDir() {
        return mBase.getCacheDir();
    }

    public ClassLoader getClassLoader() {
        return mBase.getClassLoader();
    }

    public ContentResolver getContentResolver() {
        return mBase.getContentResolver();
    }

    public File getDatabasePath(String s) {
        return mBase.getDatabasePath(s);
    }

    public File getDir(String s, int i) {
        return mBase.getDir(s, i);
    }

    public File getExternalCacheDir() {
        return mBase.getExternalCacheDir();
    }

    public File getExternalFilesDir(String s) {
        return mBase.getExternalFilesDir(s);
    }

    public File getFileStreamPath(String s) {
        return mBase.getFileStreamPath(s);
    }

    public File getFilesDir() {
        return mBase.getFilesDir();
    }

    public Looper getMainLooper() {
        return mBase.getMainLooper();
    }

    public File getObbDir() {
        return mBase.getObbDir();
    }

    public String getPackageCodePath() {
        return mBase.getPackageCodePath();
    }

    public PackageManager getPackageManager() {
        return mBase.getPackageManager();
    }

    public String getPackageName() {
        return mBase.getPackageName();
    }

    public String getPackageResourcePath() {
        return mBase.getPackageResourcePath();
    }

    public Resources getResources() {
        return mBase.getResources();
    }

    public SharedPreferences getSharedPreferences(String s, int i) {
        return mBase.getSharedPreferences(s, i);
    }

    public File getSharedPrefsFile(String s) {
        return mBase.getSharedPrefsFile(s);
    }

    public Object getSystemService(String s) {
        return mBase.getSystemService(s);
    }

    public android.content.res.Resources.Theme getTheme() {
        return mBase.getTheme();
    }

    public int getThemeResId() {
        return mBase.getThemeResId();
    }

    public Drawable getWallpaper() {
        return mBase.getWallpaper();
    }

    public int getWallpaperDesiredMinimumHeight() {
        return mBase.getWallpaperDesiredMinimumHeight();
    }

    public int getWallpaperDesiredMinimumWidth() {
        return mBase.getWallpaperDesiredMinimumWidth();
    }

    public void grantUriPermission(String s, Uri uri, int i) {
        mBase.grantUriPermission(s, uri, i);
    }

    public boolean isRestricted() {
        return mBase.isRestricted();
    }

    public FileInputStream openFileInput(String s) throws FileNotFoundException {
        return mBase.openFileInput(s);
    }

    public FileOutputStream openFileOutput(String s, int i) throws FileNotFoundException {
        return mBase.openFileOutput(s, i);
    }

    public SQLiteDatabase openOrCreateDatabase(String s, int i, android.database.sqlite.SQLiteDatabase.CursorFactory cursorfactory) {
        return mBase.openOrCreateDatabase(s, i, cursorfactory);
    }

    public SQLiteDatabase openOrCreateDatabase(String s, int i, android.database.sqlite.SQLiteDatabase.CursorFactory cursorfactory, DatabaseErrorHandler databaseerrorhandler) {
        return mBase.openOrCreateDatabase(s, i, cursorfactory, databaseerrorhandler);
    }

    public Drawable peekWallpaper() {
        return mBase.peekWallpaper();
    }

    public Intent registerReceiver(BroadcastReceiver broadcastreceiver, IntentFilter intentfilter) {
        return mBase.registerReceiver(broadcastreceiver, intentfilter);
    }

    public Intent registerReceiver(BroadcastReceiver broadcastreceiver, IntentFilter intentfilter, String s, Handler handler) {
        return mBase.registerReceiver(broadcastreceiver, intentfilter, s, handler);
    }

    public void removeStickyBroadcast(Intent intent) {
        mBase.removeStickyBroadcast(intent);
    }

    public void revokeUriPermission(Uri uri, int i) {
        mBase.revokeUriPermission(uri, i);
    }

    public void sendBroadcast(Intent intent) {
        mBase.sendBroadcast(intent);
    }

    public void sendBroadcast(Intent intent, int i) {
        mBase.sendBroadcast(intent, i);
    }

    public void sendBroadcast(Intent intent, String s) {
        mBase.sendBroadcast(intent, s);
    }

    public void sendOrderedBroadcast(Intent intent, String s) {
        mBase.sendOrderedBroadcast(intent, s);
    }

    public void sendOrderedBroadcast(Intent intent, String s, BroadcastReceiver broadcastreceiver, Handler handler, int i, String s1, Bundle bundle) {
        mBase.sendOrderedBroadcast(intent, s, broadcastreceiver, handler, i, s1, bundle);
    }

    public void sendStickyBroadcast(Intent intent) {
        mBase.sendStickyBroadcast(intent);
    }

    public void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver broadcastreceiver, Handler handler, int i, String s, Bundle bundle) {
        mBase.sendStickyOrderedBroadcast(intent, broadcastreceiver, handler, i, s, bundle);
    }

    public void setTheme(int i) {
        mBase.setTheme(i);
    }

    public void setWallpaper(Bitmap bitmap) throws IOException {
        mBase.setWallpaper(bitmap);
    }

    public void setWallpaper(InputStream inputstream) throws IOException {
        mBase.setWallpaper(inputstream);
    }

    public void startActivities(Intent aintent[]) {
        mBase.startActivities(aintent);
    }

    public void startActivities(Intent aintent[], Bundle bundle) {
        mBase.startActivities(aintent, bundle);
    }

    public void startActivity(Intent intent) {
        mBase.startActivity(intent);
    }

    public void startActivity(Intent intent, Bundle bundle) {
        mBase.startActivity(intent, bundle);
    }

    public boolean startInstrumentation(ComponentName componentname, String s, Bundle bundle) {
        return mBase.startInstrumentation(componentname, s, bundle);
    }

    public void startIntentSender(IntentSender intentsender, Intent intent, int i, int j, int k) throws IntentSender.SendIntentException {
        mBase.startIntentSender(intentsender, intent, i, j, k);
    }

    public void startIntentSender(IntentSender intentsender, Intent intent, int i, int j, int k, Bundle bundle) throws IntentSender.SendIntentException {
        mBase.startIntentSender(intentsender, intent, i, j, k, bundle);
    }

    public ComponentName startService(Intent intent) {
        return mBase.startService(intent);
    }

    public boolean stopService(Intent intent) {
        return mBase.stopService(intent);
    }

    public void unbindService(ServiceConnection serviceconnection) {
        mBase.unbindService(serviceconnection);
    }

    public void unregisterReceiver(BroadcastReceiver broadcastreceiver) {
        mBase.unregisterReceiver(broadcastreceiver);
    }

    Context mBase;
}
