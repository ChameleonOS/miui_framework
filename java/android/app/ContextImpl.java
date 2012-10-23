// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.accounts.AccountManager;
import android.app.admin.DevicePolicyManager;
import android.content.*;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.hardware.SerialManager;
import android.hardware.SystemSensorManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.CountryDetector;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.net.*;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.*;
import android.os.storage.StorageManager;
import android.telephony.TelephonyManager;
import android.util.*;
import android.view.ContextThemeWrapper;
import android.view.WindowManagerImpl;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import com.android.internal.policy.PolicyManager;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package android.app:
//            LoadedApk, WallpaperManager, ActivityThread, ActivityManagerNative, 
//            IActivityManager, ApplicationPackageManager, ReceiverRestrictedContext, SharedPreferencesImpl, 
//            Activity, Instrumentation, KeyguardManager, NotificationManager, 
//            SearchManager, StatusBarManager, UiModeManager, ActivityManager, 
//            AlarmManager

class ContextImpl extends Context {
    private static final class ApplicationContentResolver extends ContentResolver {

        protected IContentProvider acquireExistingProvider(Context context, String s) {
            return mMainThread.acquireExistingProvider(context, s, true);
        }

        protected IContentProvider acquireProvider(Context context, String s) {
            return mMainThread.acquireProvider(context, s, true);
        }

        protected IContentProvider acquireUnstableProvider(Context context, String s) {
            return mMainThread.acquireProvider(context, s, false);
        }

        public boolean releaseProvider(IContentProvider icontentprovider) {
            return mMainThread.releaseProvider(icontentprovider, true);
        }

        public boolean releaseUnstableProvider(IContentProvider icontentprovider) {
            return mMainThread.releaseProvider(icontentprovider, false);
        }

        public void unstableProviderDied(IContentProvider icontentprovider) {
            mMainThread.handleUnstableProviderDied(icontentprovider.asBinder(), true);
        }

        private final ActivityThread mMainThread;

        public ApplicationContentResolver(Context context, ActivityThread activitythread) {
            super(context);
            mMainThread = activitythread;
        }
    }

    static abstract class StaticServiceFetcher extends ServiceFetcher {

        public abstract Object createStaticService();

        public final Object getService(ContextImpl contextimpl) {
            this;
            JVM INSTR monitorenter ;
            Object obj = mCachedInstance;
            if(obj == null) {
                obj = createStaticService();
                mCachedInstance = obj;
            }
            return obj;
        }

        private Object mCachedInstance;

        StaticServiceFetcher() {
        }
    }

    static class ServiceFetcher {

        public Object createService(ContextImpl contextimpl) {
            throw new RuntimeException("Not implemented");
        }

        public Object getService(ContextImpl contextimpl) {
            ArrayList arraylist = contextimpl.mServiceCache;
            arraylist;
            JVM INSTR monitorenter ;
            Object obj2;
label0:
            {
                if(arraylist.size() == 0) {
                    for(int i = 0; i < ContextImpl.sNextPerContextServiceCacheIndex; i++)
                        arraylist.add(null);

                } else {
                    Object obj = arraylist.get(mContextCacheIndex);
                    if(obj != null) {
                        obj2 = obj;
                        break label0;
                    }
                }
                Object obj1 = createService(contextimpl);
                arraylist.set(mContextCacheIndex, obj1);
                obj2 = obj1;
            }
            return obj2;
        }

        int mContextCacheIndex;

        ServiceFetcher() {
            mContextCacheIndex = -1;
        }
    }


    ContextImpl() {
        mActivityToken = null;
        mThemeResource = 0;
        mTheme = null;
        mReceiverRestrictedContext = null;
        mSync = new Object();
        mServiceCache = new ArrayList();
        mOuterContext = this;
    }

    public ContextImpl(ContextImpl contextimpl) {
        mActivityToken = null;
        mThemeResource = 0;
        mTheme = null;
        mReceiverRestrictedContext = null;
        mSync = new Object();
        mServiceCache = new ArrayList();
        mPackageInfo = contextimpl.mPackageInfo;
        mBasePackageName = contextimpl.mBasePackageName;
        mResources = contextimpl.mResources;
        mMainThread = contextimpl.mMainThread;
        mContentResolver = contextimpl.mContentResolver;
        mOuterContext = this;
    }

    private void checkPriority(IntentFilter intentfilter) {
        if(mPackageInfo == null) goto _L2; else goto _L1
_L1:
        ApplicationInfo applicationinfo = mPackageInfo.getApplicationInfo();
        if(applicationinfo == null || (1 & applicationinfo.flags) != 0) goto _L2; else goto _L3
_L3:
        if(intentfilter.getPriority() < 1000) goto _L5; else goto _L4
_L4:
        intentfilter.setPriority(999);
_L2:
        return;
_L5:
        if(intentfilter.getPriority() <= -1000)
            intentfilter.setPriority(-999);
        if(true) goto _L2; else goto _L6
_L6:
    }

    static DropBoxManager createDropBoxManager() {
        com.android.internal.os.IDropBoxManagerService idropboxmanagerservice = com.android.internal.os.IDropBoxManagerService.Stub.asInterface(ServiceManager.getService("dropbox"));
        DropBoxManager dropboxmanager;
        if(idropboxmanagerservice == null)
            dropboxmanager = null;
        else
            dropboxmanager = new DropBoxManager(idropboxmanagerservice);
        return dropboxmanager;
    }

    static ContextImpl createSystemContext(ActivityThread activitythread) {
        ContextImpl contextimpl = new ContextImpl();
        contextimpl.init(Resources.getSystem(), activitythread);
        return contextimpl;
    }

    private void enforce(String s, int i, boolean flag, int j, String s1) {
        if(i != 0) {
            StringBuilder stringbuilder = new StringBuilder();
            String s2;
            StringBuilder stringbuilder1;
            String s3;
            if(s1 != null)
                s2 = (new StringBuilder()).append(s1).append(": ").toString();
            else
                s2 = "";
            stringbuilder1 = stringbuilder.append(s2);
            if(flag)
                s3 = (new StringBuilder()).append("Neither user ").append(j).append(" nor current process has ").toString();
            else
                s3 = (new StringBuilder()).append("User ").append(j).append(" does not have ").toString();
            throw new SecurityException(stringbuilder1.append(s3).append(s).append(".").toString());
        } else {
            return;
        }
    }

    private void enforceForUri(int i, int j, boolean flag, int k, Uri uri, String s) {
        if(j != 0) {
            StringBuilder stringbuilder = new StringBuilder();
            String s1;
            StringBuilder stringbuilder1;
            String s2;
            if(s != null)
                s1 = (new StringBuilder()).append(s).append(": ").toString();
            else
                s1 = "";
            stringbuilder1 = stringbuilder.append(s1);
            if(flag)
                s2 = (new StringBuilder()).append("Neither user ").append(k).append(" nor current process has ").toString();
            else
                s2 = (new StringBuilder()).append("User ").append(k).append(" does not have ").toString();
            throw new SecurityException(stringbuilder1.append(s2).append(uriModeFlagToString(i)).append(" permission on ").append(uri).append(".").toString());
        } else {
            return;
        }
    }

    private File getDataDirFile() {
        if(mPackageInfo != null)
            return mPackageInfo.getDataDirFile();
        else
            throw new RuntimeException("Not supported in system context");
    }

    private File getDatabasesDir() {
        Object obj = mSync;
        obj;
        JVM INSTR monitorenter ;
        if(mDatabasesDir == null)
            mDatabasesDir = new File(getDataDirFile(), "databases");
        if(mDatabasesDir.getPath().equals("databases"))
            mDatabasesDir = new File("/data/system");
        File file = mDatabasesDir;
        return file;
    }

    static ContextImpl getImpl(Context context) {
        do {
            if(!(context instanceof ContextWrapper))
                break;
            Context context1 = ((ContextWrapper)context).getBaseContext();
            if(context1 == null)
                break;
            context = context1;
        } while(true);
        return (ContextImpl)context;
    }

    private File getPreferencesDir() {
        Object obj = mSync;
        obj;
        JVM INSTR monitorenter ;
        if(mPreferencesDir == null)
            mPreferencesDir = new File(getDataDirFile(), "shared_prefs");
        File file = mPreferencesDir;
        return file;
    }

    private WallpaperManager getWallpaperManager() {
        return (WallpaperManager)WALLPAPER_FETCHER.getService(this);
    }

    private File makeFilename(File file, String s) {
        if(s.indexOf(File.separatorChar) < 0)
            return new File(file, s);
        else
            throw new IllegalArgumentException((new StringBuilder()).append("File ").append(s).append(" contains a path separator").toString());
    }

    private Intent registerReceiverInternal(BroadcastReceiver broadcastreceiver, IntentFilter intentfilter, String s, Handler handler, Context context) {
        Intent intent;
        android.content.IIntentReceiver iintentreceiver = null;
        Intent intent1;
        if(broadcastreceiver != null)
            if(mPackageInfo != null && context != null) {
                if(handler == null)
                    handler = mMainThread.getHandler();
                LoadedApk loadedapk = mPackageInfo;
                Instrumentation instrumentation = mMainThread.getInstrumentation();
                iintentreceiver = loadedapk.getReceiverDispatcher(broadcastreceiver, context, handler, instrumentation, true);
            } else {
                if(handler == null)
                    handler = mMainThread.getHandler();
                iintentreceiver = (new LoadedApk.ReceiverDispatcher(broadcastreceiver, context, handler, null, true)).getIIntentReceiver();
            }
        checkPriority(intentfilter);
        intent1 = ActivityManagerNative.getDefault().registerReceiver(mMainThread.getApplicationThread(), mBasePackageName, iintentreceiver, intentfilter, s);
        intent = intent1;
_L2:
        return intent;
        RemoteException remoteexception;
        remoteexception;
        intent = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private static void registerService(String s, ServiceFetcher servicefetcher) {
        if(!(servicefetcher instanceof StaticServiceFetcher)) {
            int i = sNextPerContextServiceCacheIndex;
            sNextPerContextServiceCacheIndex = i + 1;
            servicefetcher.mContextCacheIndex = i;
        }
        SYSTEM_SERVICE_MAP.put(s, servicefetcher);
    }

    static void setFilePermissionsFromMode(String s, int i, int j) {
        int k = j | 0x1b0;
        if((i & 1) != 0)
            k |= 4;
        if((i & 2) != 0)
            k |= 2;
        FileUtils.setPermissions(s, k, -1, -1);
    }

    private String uriModeFlagToString(int i) {
        i;
        JVM INSTR tableswitch 1 3: default 28
    //                   1 62
    //                   2 69
    //                   3 56;
           goto _L1 _L2 _L3 _L4
_L1:
        throw new IllegalArgumentException((new StringBuilder()).append("Unknown permission mode flags: ").append(i).toString());
_L4:
        String s = "read and write";
_L6:
        return s;
_L2:
        s = "read";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "write";
        if(true) goto _L6; else goto _L5
_L5:
    }

    private File validateFilePath(String s, boolean flag) {
        File file;
        File file1;
        if(s.charAt(0) == File.separatorChar) {
            file = new File(s.substring(0, s.lastIndexOf(File.separatorChar)));
            file1 = new File(file, s.substring(s.lastIndexOf(File.separatorChar)));
        } else {
            file = getDatabasesDir();
            file1 = makeFilename(file, s);
        }
        if(flag && !file.isDirectory() && file.mkdir())
            FileUtils.setPermissions(file.getPath(), 505, -1, -1);
        return file1;
    }

    public boolean bindService(Intent intent, ServiceConnection serviceconnection, int i) {
        return bindService(intent, serviceconnection, i, UserId.getUserId(Process.myUid()));
    }

    public boolean bindService(Intent intent, ServiceConnection serviceconnection, int i, int j) {
        if(mPackageInfo == null) goto _L2; else goto _L1
_L1:
        IServiceConnection iserviceconnection = mPackageInfo.getServiceDispatcher(serviceconnection, getOuterContext(), mMainThread.getHandler(), i);
        int k;
        if(getActivityToken() == null && (i & 1) == 0 && mPackageInfo != null && mPackageInfo.getApplicationInfo().targetSdkVersion < 14)
            i |= 0x20;
        intent.setAllowFds(false);
        k = ActivityManagerNative.getDefault().bindService(mMainThread.getApplicationThread(), getActivityToken(), intent, intent.resolveTypeIfNeeded(getContentResolver()), iserviceconnection, i, j);
        if(k < 0)
            throw new SecurityException((new StringBuilder()).append("Not allowed to bind to service ").append(intent).toString());
          goto _L3
        RemoteException remoteexception;
        remoteexception;
        boolean flag = false;
_L5:
        return flag;
_L2:
        throw new RuntimeException("Not supported in system context");
_L3:
        if(k != 0)
            flag = true;
        else
            flag = false;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public int checkCallingOrSelfPermission(String s) {
        if(s == null)
            throw new IllegalArgumentException("permission is null");
        else
            return checkPermission(s, Binder.getCallingPid(), Binder.getCallingUid());
    }

    public int checkCallingOrSelfUriPermission(Uri uri, int i) {
        return checkUriPermission(uri, Binder.getCallingPid(), Binder.getCallingUid(), i);
    }

    public int checkCallingPermission(String s) {
        if(s == null)
            throw new IllegalArgumentException("permission is null");
        int i = Binder.getCallingPid();
        int j;
        if(i != Process.myPid())
            j = checkPermission(s, i, Binder.getCallingUid());
        else
            j = -1;
        return j;
    }

    public int checkCallingUriPermission(Uri uri, int i) {
        int j = Binder.getCallingPid();
        int k;
        if(j != Process.myPid())
            k = checkUriPermission(uri, j, Binder.getCallingUid(), i);
        else
            k = -1;
        return k;
    }

    public int checkPermission(String s, int i, int j) {
        if(s == null)
            throw new IllegalArgumentException("permission is null");
        int l = ActivityManagerNative.getDefault().checkPermission(s, i, j);
        int k = l;
_L2:
        return k;
        RemoteException remoteexception;
        remoteexception;
        k = -1;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int checkUriPermission(Uri uri, int i, int j, int k) {
        int i1 = ActivityManagerNative.getDefault().checkUriPermission(uri, i, j, k);
        int l = i1;
_L2:
        return l;
        RemoteException remoteexception;
        remoteexception;
        l = -1;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int checkUriPermission(Uri uri, String s, String s1, int i, int j, int k) {
        int l;
        l = 0;
        break MISSING_BLOCK_LABEL_3;
        if(((k & 1) == 0 || s != null && checkPermission(s, i, j) != 0) && ((k & 2) == 0 || s1 != null && checkPermission(s1, i, j) != 0))
            if(uri != null)
                l = checkUriPermission(uri, i, j, k);
            else
                l = -1;
        return l;
    }

    public void clearWallpaper() throws IOException {
        getWallpaperManager().clear();
    }

    public Context createPackageContext(String s, int i) throws android.content.pm.PackageManager.NameNotFoundException {
        if(!s.equals("system") && !s.equals("android")) goto _L2; else goto _L1
_L1:
        ContextImpl contextimpl1;
        ContextImpl contextimpl = new ContextImpl(mMainThread.getSystemContext());
        contextimpl.mBasePackageName = mBasePackageName;
        contextimpl1 = contextimpl;
_L4:
        return contextimpl1;
_L2:
        LoadedApk loadedapk = mMainThread.getPackageInfo(s, mResources.getCompatibilityInfo(), i);
        if(loadedapk == null)
            break; /* Loop/switch isn't completed */
        contextimpl1 = new ContextImpl();
        boolean flag;
        if((i & 4) == 4)
            flag = true;
        else
            flag = false;
        contextimpl1.mRestricted = flag;
        contextimpl1.init(loadedapk, null, mMainThread, mResources, mBasePackageName);
        if(contextimpl1.mResources != null) goto _L4; else goto _L3
_L3:
        throw new android.content.pm.PackageManager.NameNotFoundException((new StringBuilder()).append("Application package ").append(s).append(" not found").toString());
    }

    public String[] databaseList() {
        String as[] = getDatabasesDir().list();
        if(as == null)
            as = EMPTY_FILE_LIST;
        return as;
    }

    public boolean deleteDatabase(String s) {
        boolean flag = false;
        boolean flag1 = SQLiteDatabase.deleteDatabase(validateFilePath(s, false));
        flag = flag1;
_L2:
        return flag;
        Exception exception;
        exception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean deleteFile(String s) {
        return makeFilename(getFilesDir(), s).delete();
    }

    public void enforceCallingOrSelfPermission(String s, String s1) {
        enforce(s, checkCallingOrSelfPermission(s), true, Binder.getCallingUid(), s1);
    }

    public void enforceCallingOrSelfUriPermission(Uri uri, int i, String s) {
        enforceForUri(i, checkCallingOrSelfUriPermission(uri, i), true, Binder.getCallingUid(), uri, s);
    }

    public void enforceCallingPermission(String s, String s1) {
        enforce(s, checkCallingPermission(s), false, Binder.getCallingUid(), s1);
    }

    public void enforceCallingUriPermission(Uri uri, int i, String s) {
        enforceForUri(i, checkCallingUriPermission(uri, i), false, Binder.getCallingUid(), uri, s);
    }

    public void enforcePermission(String s, int i, int j, String s1) {
        enforce(s, checkPermission(s, i, j), false, j, s1);
    }

    public void enforceUriPermission(Uri uri, int i, int j, int k, String s) {
        enforceForUri(k, checkUriPermission(uri, i, j, k), false, j, uri, s);
    }

    public void enforceUriPermission(Uri uri, String s, String s1, int i, int j, int k, String s2) {
        enforceForUri(k, checkUriPermission(uri, s, s1, i, j, k), false, j, uri, s2);
    }

    public String[] fileList() {
        String as[] = getFilesDir().list();
        if(as == null)
            as = EMPTY_FILE_LIST;
        return as;
    }

    final IBinder getActivityToken() {
        return mActivityToken;
    }

    public Context getApplicationContext() {
        Application application;
        if(mPackageInfo != null)
            application = mPackageInfo.getApplication();
        else
            application = mMainThread.getApplication();
        return application;
    }

    public ApplicationInfo getApplicationInfo() {
        if(mPackageInfo != null)
            return mPackageInfo.getApplicationInfo();
        else
            throw new RuntimeException("Not supported in system context");
    }

    public AssetManager getAssets() {
        return mResources.getAssets();
    }

    public File getCacheDir() {
        File file;
        synchronized(mSync) {
            if(mCacheDir == null)
                mCacheDir = new File(getDataDirFile(), "cache");
            if(!mCacheDir.exists()) {
                if(!mCacheDir.mkdirs()) {
                    Log.w("ApplicationContext", "Unable to create cache directory");
                    file = null;
                    break MISSING_BLOCK_LABEL_101;
                }
                FileUtils.setPermissions(mCacheDir.getPath(), 505, -1, -1);
            }
        }
        file = mCacheDir;
          goto _L1
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
        return file;
    }

    public ClassLoader getClassLoader() {
        ClassLoader classloader;
        if(mPackageInfo != null)
            classloader = mPackageInfo.getClassLoader();
        else
            classloader = ClassLoader.getSystemClassLoader();
        return classloader;
    }

    public ContentResolver getContentResolver() {
        return mContentResolver;
    }

    public File getDatabasePath(String s) {
        return validateFilePath(s, false);
    }

    public File getDir(String s, int i) {
        String s1 = (new StringBuilder()).append("app_").append(s).toString();
        File file = makeFilename(getDataDirFile(), s1);
        if(!file.exists()) {
            file.mkdir();
            setFilePermissionsFromMode(file.getPath(), i, 505);
        }
        return file;
    }

    public File getExternalCacheDir() {
        Object obj = mSync;
        obj;
        JVM INSTR monitorenter ;
        boolean flag;
        if(mExternalCacheDir == null)
            mExternalCacheDir = Environment.getExternalStorageAppCacheDirectory(getPackageName());
        flag = mExternalCacheDir.exists();
        File file;
        if(!flag) {
            Exception exception;
            try {
                (new File(Environment.getExternalStorageAndroidDataDir(), ".nomedia")).createNewFile();
            }
            catch(IOException ioexception) { }
            finally {
                obj;
            }
            if(!mExternalCacheDir.mkdirs()) {
                Log.w("ApplicationContext", "Unable to create external cache directory");
                file = null;
                break MISSING_BLOCK_LABEL_102;
            }
        }
        file = mExternalCacheDir;
        if(true)
            break MISSING_BLOCK_LABEL_102;
        JVM INSTR monitorexit ;
        throw exception;
        return file;
    }

    public File getExternalFilesDir(String s) {
        Object obj = mSync;
        obj;
        JVM INSTR monitorenter ;
        boolean flag;
        if(mExternalFilesDir == null)
            mExternalFilesDir = Environment.getExternalStorageAppFilesDirectory(getPackageName());
        flag = mExternalFilesDir.exists();
        if(flag) goto _L2; else goto _L1
_L1:
        Exception exception;
        File file;
        try {
            (new File(Environment.getExternalStorageAndroidDataDir(), ".nomedia")).createNewFile();
        }
        catch(IOException ioexception) { }
        finally {
            obj;
        }
        if(mExternalFilesDir.mkdirs()) goto _L2; else goto _L3
_L3:
        Log.w("ApplicationContext", "Unable to create external files directory");
        file = null;
          goto _L4
_L2:
        if(s != null) goto _L6; else goto _L5
_L5:
        file = mExternalFilesDir;
        if(false) goto _L7; else goto _L4
_L7:
        JVM INSTR monitorexit ;
        throw exception;
_L6:
        file = new File(mExternalFilesDir, s);
        if(file.exists() || file.mkdirs()) goto _L9; else goto _L8
_L8:
        Log.w("ApplicationContext", (new StringBuilder()).append("Unable to create external media directory ").append(file).toString());
        obj;
        JVM INSTR monitorexit ;
        file = null;
          goto _L4
_L9:
        obj;
        JVM INSTR monitorexit ;
_L4:
        return file;
    }

    public File getFileStreamPath(String s) {
        return makeFilename(getFilesDir(), s);
    }

    public File getFilesDir() {
        Object obj = mSync;
        obj;
        JVM INSTR monitorenter ;
        File file;
label0:
        {
            if(mFilesDir == null)
                mFilesDir = new File(getDataDirFile(), "files");
            if(!mFilesDir.exists()) {
                if(!mFilesDir.mkdirs()) {
                    Log.w("ApplicationContext", (new StringBuilder()).append("Unable to create files directory ").append(mFilesDir.getPath()).toString());
                    file = null;
                    break label0;
                }
                FileUtils.setPermissions(mFilesDir.getPath(), 505, -1, -1);
            }
            file = mFilesDir;
        }
        return file;
    }

    public Looper getMainLooper() {
        return mMainThread.getLooper();
    }

    public File getObbDir() {
        Object obj = mSync;
        obj;
        JVM INSTR monitorenter ;
        if(mObbDir == null)
            mObbDir = Environment.getExternalStorageAppObbDirectory(getPackageName());
        File file = mObbDir;
        return file;
    }

    final Context getOuterContext() {
        return mOuterContext;
    }

    public String getPackageCodePath() {
        if(mPackageInfo != null)
            return mPackageInfo.getAppDir();
        else
            throw new RuntimeException("Not supported in system context");
    }

    public PackageManager getPackageManager() {
        Object obj;
        if(mPackageManager != null) {
            obj = mPackageManager;
        } else {
            android.content.pm.IPackageManager ipackagemanager = ActivityThread.getPackageManager();
            if(ipackagemanager != null) {
                obj = new ApplicationPackageManager(this, ipackagemanager);
                mPackageManager = ((PackageManager) (obj));
            } else {
                obj = null;
            }
        }
        return ((PackageManager) (obj));
    }

    public String getPackageName() {
        if(mPackageInfo != null)
            return mPackageInfo.getPackageName();
        else
            throw new RuntimeException("Not supported in system context");
    }

    public String getPackageResourcePath() {
        if(mPackageInfo != null)
            return mPackageInfo.getResDir();
        else
            throw new RuntimeException("Not supported in system context");
    }

    final Context getReceiverRestrictedContext() {
        Object obj;
        if(mReceiverRestrictedContext != null) {
            obj = mReceiverRestrictedContext;
        } else {
            obj = new ReceiverRestrictedContext(getOuterContext());
            mReceiverRestrictedContext = ((Context) (obj));
        }
        return ((Context) (obj));
    }

    public Resources getResources() {
        return mResources;
    }

    public SharedPreferences getSharedPreferences(String s, int i) {
        SharedPreferencesImpl sharedpreferencesimpl2;
        SharedPreferencesImpl sharedpreferencesimpl;
        synchronized(sSharedPrefs) {
            sharedpreferencesimpl = (SharedPreferencesImpl)sSharedPrefs.get(s);
            if(sharedpreferencesimpl == null) {
                SharedPreferencesImpl sharedpreferencesimpl1 = new SharedPreferencesImpl(getSharedPrefsFile(s), i);
                sSharedPrefs.put(s, sharedpreferencesimpl1);
                sharedpreferencesimpl2 = sharedpreferencesimpl1;
                break MISSING_BLOCK_LABEL_96;
            }
        }
        if((i & 4) != 0 || getApplicationInfo().targetSdkVersion < 11)
            sharedpreferencesimpl.startReloadIfChangedUnexpectedly();
        sharedpreferencesimpl2 = sharedpreferencesimpl;
          goto _L1
        exception;
        hashmap;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
        return sharedpreferencesimpl2;
    }

    public File getSharedPrefsFile(String s) {
        return makeFilename(getPreferencesDir(), (new StringBuilder()).append(s).append(".xml").toString());
    }

    public Object getSystemService(String s) {
        ServiceFetcher servicefetcher = (ServiceFetcher)SYSTEM_SERVICE_MAP.get(s);
        Object obj;
        if(servicefetcher == null)
            obj = null;
        else
            obj = servicefetcher.getService(this);
        return obj;
    }

    public android.content.res.Resources.Theme getTheme() {
        if(mTheme == null) {
            mThemeResource = Resources.selectDefaultTheme(mThemeResource, getOuterContext().getApplicationInfo().targetSdkVersion);
            mTheme = mResources.newTheme();
            mTheme.applyStyle(mThemeResource, true);
        }
        return mTheme;
    }

    public int getThemeResId() {
        return mThemeResource;
    }

    public Drawable getWallpaper() {
        return getWallpaperManager().getDrawable();
    }

    public int getWallpaperDesiredMinimumHeight() {
        return getWallpaperManager().getDesiredMinimumHeight();
    }

    public int getWallpaperDesiredMinimumWidth() {
        return getWallpaperManager().getDesiredMinimumWidth();
    }

    public void grantUriPermission(String s, Uri uri, int i) {
        ActivityManagerNative.getDefault().grantUriPermission(mMainThread.getApplicationThread(), s, uri, i);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    final void init(LoadedApk loadedapk, IBinder ibinder, ActivityThread activitythread) {
        init(loadedapk, ibinder, activitythread, null, null);
    }

    final void init(LoadedApk loadedapk, IBinder ibinder, ActivityThread activitythread, Resources resources, String s) {
        mPackageInfo = loadedapk;
        if(s == null)
            s = loadedapk.mPackageName;
        mBasePackageName = s;
        mResources = mPackageInfo.getResources(activitythread);
        if(mResources != null && resources != null && resources.getCompatibilityInfo().applicationScale != mResources.getCompatibilityInfo().applicationScale)
            mResources = activitythread.getTopLevelResources(mPackageInfo.mPackageName, mPackageInfo.getResDir(), resources.getCompatibilityInfo());
        mMainThread = activitythread;
        mContentResolver = new ApplicationContentResolver(this, activitythread);
        setActivityToken(ibinder);
    }

    final void init(Resources resources, ActivityThread activitythread) {
        mPackageInfo = null;
        mBasePackageName = null;
        mResources = resources;
        mMainThread = activitythread;
        mContentResolver = new ApplicationContentResolver(this, activitythread);
    }

    public boolean isRestricted() {
        return mRestricted;
    }

    public FileInputStream openFileInput(String s) throws FileNotFoundException {
        return new FileInputStream(makeFilename(getFilesDir(), s));
    }

    public FileOutputStream openFileOutput(String s, int i) throws FileNotFoundException {
        boolean flag;
        File file;
        FileOutputStream fileoutputstream;
        if((0x8000 & i) != 0)
            flag = true;
        else
            flag = false;
        file = makeFilename(getFilesDir(), s);
        try {
            fileoutputstream = new FileOutputStream(file, flag);
            setFilePermissionsFromMode(file.getPath(), i, 0);
        }
        catch(FileNotFoundException filenotfoundexception) {
            File file1 = file.getParentFile();
            file1.mkdir();
            FileUtils.setPermissions(file1.getPath(), 505, -1, -1);
            fileoutputstream = new FileOutputStream(file, flag);
            setFilePermissionsFromMode(file.getPath(), i, 0);
        }
        return fileoutputstream;
    }

    public SQLiteDatabase openOrCreateDatabase(String s, int i, android.database.sqlite.SQLiteDatabase.CursorFactory cursorfactory) {
        return openOrCreateDatabase(s, i, cursorfactory, null);
    }

    public SQLiteDatabase openOrCreateDatabase(String s, int i, android.database.sqlite.SQLiteDatabase.CursorFactory cursorfactory, DatabaseErrorHandler databaseerrorhandler) {
        File file = validateFilePath(s, true);
        int j = 0x10000000;
        if((i & 8) != 0)
            j |= 0x20000000;
        SQLiteDatabase sqlitedatabase = SQLiteDatabase.openDatabase(file.getPath(), cursorfactory, j, databaseerrorhandler);
        setFilePermissionsFromMode(file.getPath(), i, 0);
        return sqlitedatabase;
    }

    public Drawable peekWallpaper() {
        return getWallpaperManager().peekDrawable();
    }

    final void performFinalCleanup(String s, String s1) {
        mPackageInfo.removeContextRegistrations(getOuterContext(), s, s1);
    }

    public Intent registerReceiver(BroadcastReceiver broadcastreceiver, IntentFilter intentfilter) {
        return registerReceiver(broadcastreceiver, intentfilter, null, null);
    }

    public Intent registerReceiver(BroadcastReceiver broadcastreceiver, IntentFilter intentfilter, String s, Handler handler) {
        return registerReceiverInternal(broadcastreceiver, intentfilter, s, handler, getOuterContext());
    }

    public void removeStickyBroadcast(Intent intent) {
        String s = intent.resolveTypeIfNeeded(getContentResolver());
        if(s != null) {
            Intent intent1 = new Intent(intent);
            intent1.setDataAndType(intent1.getData(), s);
            intent = intent1;
        }
        intent.setAllowFds(false);
        ActivityManagerNative.getDefault().unbroadcastIntent(mMainThread.getApplicationThread(), intent, Binder.getOrigCallingUser());
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void revokeUriPermission(Uri uri, int i) {
        ActivityManagerNative.getDefault().revokeUriPermission(mMainThread.getApplicationThread(), uri, i);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    final void scheduleFinalCleanup(String s, String s1) {
        mMainThread.scheduleContextCleanup(this, s, s1);
    }

    public void sendBroadcast(Intent intent) {
        String s = intent.resolveTypeIfNeeded(getContentResolver());
        intent.setAllowFds(false);
        ActivityManagerNative.getDefault().broadcastIntent(mMainThread.getApplicationThread(), intent, s, null, -1, null, null, null, false, false, Binder.getOrigCallingUser());
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void sendBroadcast(Intent intent, int i) {
        String s = intent.resolveTypeIfNeeded(getContentResolver());
        intent.setAllowFds(false);
        ActivityManagerNative.getDefault().broadcastIntent(mMainThread.getApplicationThread(), intent, s, null, -1, null, null, null, false, false, i);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void sendBroadcast(Intent intent, String s) {
        String s1 = intent.resolveTypeIfNeeded(getContentResolver());
        intent.setAllowFds(false);
        ActivityManagerNative.getDefault().broadcastIntent(mMainThread.getApplicationThread(), intent, s1, null, -1, null, null, s, false, false, Binder.getOrigCallingUser());
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void sendOrderedBroadcast(Intent intent, String s) {
        String s1 = intent.resolveTypeIfNeeded(getContentResolver());
        intent.setAllowFds(false);
        ActivityManagerNative.getDefault().broadcastIntent(mMainThread.getApplicationThread(), intent, s1, null, -1, null, null, s, true, false, Binder.getOrigCallingUser());
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void sendOrderedBroadcast(Intent intent, String s, BroadcastReceiver broadcastreceiver, Handler handler, int i, String s1, Bundle bundle) {
        android.content.IIntentReceiver iintentreceiver = null;
        String s2;
        if(broadcastreceiver != null)
            if(mPackageInfo != null) {
                if(handler == null)
                    handler = mMainThread.getHandler();
                LoadedApk loadedapk = mPackageInfo;
                Context context = getOuterContext();
                Instrumentation instrumentation = mMainThread.getInstrumentation();
                iintentreceiver = loadedapk.getReceiverDispatcher(broadcastreceiver, context, handler, instrumentation, false);
            } else {
                if(handler == null)
                    handler = mMainThread.getHandler();
                iintentreceiver = (new LoadedApk.ReceiverDispatcher(broadcastreceiver, getOuterContext(), handler, null, false)).getIIntentReceiver();
            }
        s2 = intent.resolveTypeIfNeeded(getContentResolver());
        intent.setAllowFds(false);
        ActivityManagerNative.getDefault().broadcastIntent(mMainThread.getApplicationThread(), intent, s2, iintentreceiver, i, s1, bundle, s, true, false, Binder.getOrigCallingUser());
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void sendStickyBroadcast(Intent intent) {
        String s = intent.resolveTypeIfNeeded(getContentResolver());
        intent.setAllowFds(false);
        ActivityManagerNative.getDefault().broadcastIntent(mMainThread.getApplicationThread(), intent, s, null, -1, null, null, null, false, true, Binder.getOrigCallingUser());
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver broadcastreceiver, Handler handler, int i, String s, Bundle bundle) {
        android.content.IIntentReceiver iintentreceiver = null;
        String s1;
        if(broadcastreceiver != null)
            if(mPackageInfo != null) {
                if(handler == null)
                    handler = mMainThread.getHandler();
                LoadedApk loadedapk = mPackageInfo;
                Context context = getOuterContext();
                Instrumentation instrumentation = mMainThread.getInstrumentation();
                iintentreceiver = loadedapk.getReceiverDispatcher(broadcastreceiver, context, handler, instrumentation, false);
            } else {
                if(handler == null)
                    handler = mMainThread.getHandler();
                iintentreceiver = (new LoadedApk.ReceiverDispatcher(broadcastreceiver, getOuterContext(), handler, null, false)).getIIntentReceiver();
            }
        s1 = intent.resolveTypeIfNeeded(getContentResolver());
        intent.setAllowFds(false);
        ActivityManagerNative.getDefault().broadcastIntent(mMainThread.getApplicationThread(), intent, s1, iintentreceiver, i, s, bundle, null, true, true, Binder.getOrigCallingUser());
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    final void setActivityToken(IBinder ibinder) {
        mActivityToken = ibinder;
    }

    final void setOuterContext(Context context) {
        mOuterContext = context;
    }

    public void setTheme(int i) {
        mThemeResource = i;
    }

    public void setWallpaper(Bitmap bitmap) throws IOException {
        getWallpaperManager().setBitmap(bitmap);
    }

    public void setWallpaper(InputStream inputstream) throws IOException {
        getWallpaperManager().setStream(inputstream);
    }

    public void startActivities(Intent aintent[]) {
        startActivities(aintent, null);
    }

    public void startActivities(Intent aintent[], Bundle bundle) {
        if((0x10000000 & aintent[0].getFlags()) == 0) {
            throw new AndroidRuntimeException("Calling startActivities() from outside of an Activity  context requires the FLAG_ACTIVITY_NEW_TASK flag on first Intent. Is this really what you want?");
        } else {
            mMainThread.getInstrumentation().execStartActivities(getOuterContext(), mMainThread.getApplicationThread(), null, (Activity)null, aintent, bundle);
            return;
        }
    }

    public void startActivity(Intent intent) {
        startActivity(intent, null);
    }

    public void startActivity(Intent intent, Bundle bundle) {
        if((0x10000000 & intent.getFlags()) == 0) {
            throw new AndroidRuntimeException("Calling startActivity() from outside of an Activity  context requires the FLAG_ACTIVITY_NEW_TASK flag. Is this really what you want?");
        } else {
            mMainThread.getInstrumentation().execStartActivity(getOuterContext(), mMainThread.getApplicationThread(), null, (Activity)null, intent, -1, bundle);
            return;
        }
    }

    public boolean startInstrumentation(ComponentName componentname, String s, Bundle bundle) {
        if(bundle == null)
            break MISSING_BLOCK_LABEL_10;
        bundle.setAllowFds(false);
        boolean flag1 = ActivityManagerNative.getDefault().startInstrumentation(componentname, s, 0, bundle, null);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void startIntentSender(IntentSender intentsender, Intent intent, int i, int j, int k) throws android.content.IntentSender.SendIntentException {
        startIntentSender(intentsender, intent, i, j, k, null);
    }

    public void startIntentSender(IntentSender intentsender, Intent intent, int i, int j, int k, Bundle bundle) throws android.content.IntentSender.SendIntentException {
        String s;
        s = null;
        if(intent == null)
            break MISSING_BLOCK_LABEL_22;
        intent.setAllowFds(false);
        s = intent.resolveTypeIfNeeded(getContentResolver());
        int l = ActivityManagerNative.getDefault().startActivityIntentSender(mMainThread.getApplicationThread(), intentsender, intent, s, null, null, 0, i, j, bundle);
        if(l == -6)
            throw new android.content.IntentSender.SendIntentException();
        Instrumentation.checkStartActivityResult(l, null);
        break MISSING_BLOCK_LABEL_77;
        RemoteException remoteexception;
        remoteexception;
    }

    public ComponentName startService(Intent intent) {
        ComponentName componentname;
        try {
            intent.setAllowFds(false);
            componentname = ActivityManagerNative.getDefault().startService(mMainThread.getApplicationThread(), intent, intent.resolveTypeIfNeeded(getContentResolver()));
            if(componentname != null && componentname.getPackageName().equals("!"))
                throw new SecurityException((new StringBuilder()).append("Not allowed to start service ").append(intent).append(" without permission ").append(componentname.getClassName()).toString());
        }
        catch(RemoteException remoteexception) {
            componentname = null;
        }
        return componentname;
    }

    public boolean stopService(Intent intent) {
        boolean flag = false;
        int i;
        intent.setAllowFds(false);
        i = ActivityManagerNative.getDefault().stopService(mMainThread.getApplicationThread(), intent, intent.resolveTypeIfNeeded(getContentResolver()));
        if(i < 0)
            throw new SecurityException((new StringBuilder()).append("Not allowed to stop service ").append(intent).toString());
          goto _L1
        RemoteException remoteexception;
        remoteexception;
_L3:
        return flag;
_L1:
        if(i != 0)
            flag = true;
        if(true) goto _L3; else goto _L2
_L2:
    }

    public void unbindService(ServiceConnection serviceconnection) {
        if(mPackageInfo == null) goto _L2; else goto _L1
_L1:
        IServiceConnection iserviceconnection = mPackageInfo.forgetServiceDispatcher(getOuterContext(), serviceconnection);
        ActivityManagerNative.getDefault().unbindService(iserviceconnection);
_L4:
        return;
_L2:
        throw new RuntimeException("Not supported in system context");
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void unregisterReceiver(BroadcastReceiver broadcastreceiver) {
        if(mPackageInfo == null) goto _L2; else goto _L1
_L1:
        android.content.IIntentReceiver iintentreceiver = mPackageInfo.forgetReceiverDispatcher(getOuterContext(), broadcastreceiver);
        ActivityManagerNative.getDefault().unregisterReceiver(iintentreceiver);
_L4:
        return;
_L2:
        throw new RuntimeException("Not supported in system context");
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static final boolean DEBUG = false;
    private static final String EMPTY_FILE_LIST[] = new String[0];
    private static final HashMap SYSTEM_SERVICE_MAP = new HashMap();
    private static final String TAG = "ApplicationContext";
    private static ServiceFetcher WALLPAPER_FETCHER;
    private static int sNextPerContextServiceCacheIndex = 0;
    private static final HashMap sSharedPrefs = new HashMap();
    private IBinder mActivityToken;
    private String mBasePackageName;
    private File mCacheDir;
    private ApplicationContentResolver mContentResolver;
    private File mDatabasesDir;
    private File mExternalCacheDir;
    private File mExternalFilesDir;
    private File mFilesDir;
    ActivityThread mMainThread;
    private File mObbDir;
    private Context mOuterContext;
    LoadedApk mPackageInfo;
    private PackageManager mPackageManager;
    private File mPreferencesDir;
    private Context mReceiverRestrictedContext;
    private Resources mResources;
    private boolean mRestricted;
    final ArrayList mServiceCache;
    private final Object mSync;
    private android.content.res.Resources.Theme mTheme;
    private int mThemeResource;

    static  {
        WALLPAPER_FETCHER = new ServiceFetcher() {

            public Object createService(ContextImpl contextimpl) {
                return new WallpaperManager(contextimpl.getOuterContext(), contextimpl.mMainThread.getHandler());
            }

        };
        registerService("accessibility", new ServiceFetcher() {

            public Object getService(ContextImpl contextimpl) {
                return AccessibilityManager.getInstance(contextimpl);
            }

        });
        registerService("account", new ServiceFetcher() {

            public Object createService(ContextImpl contextimpl) {
                return new AccountManager(contextimpl, android.accounts.IAccountManager.Stub.asInterface(ServiceManager.getService("account")));
            }

        });
        registerService("activity", new ServiceFetcher() {

            public Object createService(ContextImpl contextimpl) {
                return new ActivityManager(contextimpl.getOuterContext(), contextimpl.mMainThread.getHandler());
            }

        });
        registerService("alarm", new StaticServiceFetcher() {

            public Object createStaticService() {
                return new AlarmManager(IAlarmManager.Stub.asInterface(ServiceManager.getService("alarm")));
            }

        });
        registerService("audio", new ServiceFetcher() {

            public Object createService(ContextImpl contextimpl) {
                return new AudioManager(contextimpl);
            }

        });
        registerService("media_router", new ServiceFetcher() {

            public Object createService(ContextImpl contextimpl) {
                return new MediaRouter(contextimpl);
            }

        });
        registerService("clipboard", new ServiceFetcher() {

            public Object createService(ContextImpl contextimpl) {
                return new ClipboardManager(contextimpl.getOuterContext(), contextimpl.mMainThread.getHandler());
            }

        });
        registerService("connectivity", new StaticServiceFetcher() {

            public Object createStaticService() {
                return new ConnectivityManager(android.net.IConnectivityManager.Stub.asInterface(ServiceManager.getService("connectivity")));
            }

        });
        registerService("country_detector", new StaticServiceFetcher() {

            public Object createStaticService() {
                return new CountryDetector(android.location.ICountryDetector.Stub.asInterface(ServiceManager.getService("country_detector")));
            }

        });
        registerService("device_policy", new ServiceFetcher() {

            public Object createService(ContextImpl contextimpl) {
                return DevicePolicyManager.create(contextimpl, contextimpl.mMainThread.getHandler());
            }

        });
        registerService("download", new ServiceFetcher() {

            public Object createService(ContextImpl contextimpl) {
                return MiuiClassFactory.newDownloadManager(contextimpl.getContentResolver(), contextimpl.getPackageName());
            }

        });
        registerService("nfc", new ServiceFetcher() {

            public Object createService(ContextImpl contextimpl) {
                return new NfcManager(contextimpl);
            }

        });
        registerService("dropbox", new StaticServiceFetcher() {

            public Object createStaticService() {
                return ContextImpl.createDropBoxManager();
            }

        });
        registerService("input", new StaticServiceFetcher() {

            public Object createStaticService() {
                return InputManager.getInstance();
            }

        });
        registerService("input_method", new ServiceFetcher() {

            public Object createService(ContextImpl contextimpl) {
                return InputMethodManager.getInstance(contextimpl);
            }

        });
        registerService("textservices", new ServiceFetcher() {

            public Object createService(ContextImpl contextimpl) {
                return TextServicesManager.getInstance();
            }

        });
        registerService("keyguard", new ServiceFetcher() {

            public Object getService(ContextImpl contextimpl) {
                return new KeyguardManager();
            }

        });
        registerService("layout_inflater", new ServiceFetcher() {

            public Object createService(ContextImpl contextimpl) {
                return PolicyManager.makeNewLayoutInflater(contextimpl.getOuterContext());
            }

        });
        registerService("location", new ServiceFetcher() {

            public Object createService(ContextImpl contextimpl) {
                return new LocationManager(contextimpl, android.location.ILocationManager.Stub.asInterface(ServiceManager.getService("location")));
            }

        });
        registerService("netpolicy", new ServiceFetcher() {

            public Object createService(ContextImpl contextimpl) {
                return new NetworkPolicyManager(android.net.INetworkPolicyManager.Stub.asInterface(ServiceManager.getService("netpolicy")));
            }

        });
        registerService("notification", new ServiceFetcher() {

            public Object createService(ContextImpl contextimpl) {
                Context context = contextimpl.getOuterContext();
                return new NotificationManager(new ContextThemeWrapper(context, Resources.selectSystemTheme(0, context.getApplicationInfo().targetSdkVersion, 0x103000b, 0x103006f, 0x103012e)), contextimpl.mMainThread.getHandler());
            }

        });
        registerService("servicediscovery", new ServiceFetcher() {

            public Object createService(ContextImpl contextimpl) {
                android.net.nsd.INsdManager insdmanager = android.net.nsd.INsdManager.Stub.asInterface(ServiceManager.getService("servicediscovery"));
                return new NsdManager(contextimpl.getOuterContext(), insdmanager);
            }

        });
        registerService("power", new ServiceFetcher() {

            public Object createService(ContextImpl contextimpl) {
                return new PowerManager(android.os.IPowerManager.Stub.asInterface(ServiceManager.getService("power")), contextimpl.mMainThread.getHandler());
            }

        });
        registerService("search", new ServiceFetcher() {

            public Object createService(ContextImpl contextimpl) {
                return new SearchManager(contextimpl.getOuterContext(), contextimpl.mMainThread.getHandler());
            }

        });
        registerService("sensor", new ServiceFetcher() {

            public Object createService(ContextImpl contextimpl) {
                return new SystemSensorManager(contextimpl.mMainThread.getHandler().getLooper());
            }

        });
        registerService("statusbar", new ServiceFetcher() {

            public Object createService(ContextImpl contextimpl) {
                return new StatusBarManager(contextimpl.getOuterContext());
            }

        });
        registerService("storage", new ServiceFetcher() {

            public Object createService(ContextImpl contextimpl) {
                StorageManager storagemanager;
                try {
                    storagemanager = new StorageManager(contextimpl.mMainThread.getHandler().getLooper());
                }
                catch(RemoteException remoteexception) {
                    Log.e("ApplicationContext", "Failed to create StorageManager", remoteexception);
                    storagemanager = null;
                }
                return storagemanager;
            }

        });
        registerService("phone", new ServiceFetcher() {

            public Object createService(ContextImpl contextimpl) {
                return new TelephonyManager(contextimpl.getOuterContext());
            }

        });
        registerService("throttle", new StaticServiceFetcher() {

            public Object createStaticService() {
                return new ThrottleManager(android.net.IThrottleManager.Stub.asInterface(ServiceManager.getService("throttle")));
            }

        });
        registerService("uimode", new ServiceFetcher() {

            public Object createService(ContextImpl contextimpl) {
                return new UiModeManager();
            }

        });
        registerService("usb", new ServiceFetcher() {

            public Object createService(ContextImpl contextimpl) {
                return new UsbManager(contextimpl, android.hardware.usb.IUsbManager.Stub.asInterface(ServiceManager.getService("usb")));
            }

        });
        registerService("serial", new ServiceFetcher() {

            public Object createService(ContextImpl contextimpl) {
                return new SerialManager(contextimpl, android.hardware.ISerialManager.Stub.asInterface(ServiceManager.getService("serial")));
            }

        });
        registerService("vibrator", new ServiceFetcher() {

            public Object createService(ContextImpl contextimpl) {
                return new SystemVibrator();
            }

        });
        registerService("wallpaper", WALLPAPER_FETCHER);
        registerService("wifi", new ServiceFetcher() {

            public Object createService(ContextImpl contextimpl) {
                return new WifiManager(android.net.wifi.IWifiManager.Stub.asInterface(ServiceManager.getService("wifi")), contextimpl.mMainThread.getHandler());
            }

        });
        registerService("wifip2p", new ServiceFetcher() {

            public Object createService(ContextImpl contextimpl) {
                return new WifiP2pManager(android.net.wifi.p2p.IWifiP2pManager.Stub.asInterface(ServiceManager.getService("wifip2p")));
            }

        });
        registerService("window", new ServiceFetcher() {

            public Object getService(ContextImpl contextimpl) {
                return WindowManagerImpl.getDefault(contextimpl.mPackageInfo.mCompatibilityInfo);
            }

        });
    }

}
