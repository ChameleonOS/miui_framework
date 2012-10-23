// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.app.backup.BackupAgent;
import android.content.*;
import android.content.pm.*;
import android.content.res.*;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDebug;
import android.ddm.DdmHandleAppName;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.IConnectivityManager;
import android.net.Proxy;
import android.opengl.GLUtils;
import android.os.*;
import android.renderscript.RenderScript;
import android.util.*;
import android.view.*;
import com.android.internal.os.*;
import dalvik.system.CloseGuard;
import dalvik.system.VMRuntime;
import java.io.*;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.util.*;
import java.util.regex.Pattern;
import libcore.io.IoUtils;
import org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl;

// Referenced classes of package android.app:
//            ActivityManagerNative, IActivityManager, Instrumentation, ContextImpl, 
//            Application, Activity, FragmentManagerImpl, ResultInfo, 
//            LoadedApk, ActivityManager, Service, SuperNotCalledException, 
//            QueuedWork, MiuiThemeHelper, ApplicationPackageManager, OnActivityPausedListener, 
//            RemoteServiceException, ApplicationThreadNative, IInstrumentationWatcher

public final class ActivityThread {
    private static final class ProviderRefCount {

        public final ProviderClientRecord client;
        public final IActivityManager.ContentProviderHolder holder;
        public boolean removePending;
        public int stableCount;
        public int unstableCount;

        ProviderRefCount(IActivityManager.ContentProviderHolder contentproviderholder, ProviderClientRecord providerclientrecord, int i, int j) {
            holder = contentproviderholder;
            client = providerclientrecord;
            stableCount = i;
            unstableCount = j;
        }
    }

    private static class StopInfo
        implements Runnable {

        public void run() {
            ActivityManagerNative.getDefault().activityStopped(activity.token, state, thumbnail, description);
_L2:
            return;
            RemoteException remoteexception;
            remoteexception;
            if(true) goto _L2; else goto _L1
_L1:
        }

        ActivityClientRecord activity;
        CharSequence description;
        Bundle state;
        Bitmap thumbnail;

        private StopInfo() {
        }

    }

    private static class ResourcesKey {

        public boolean equals(Object obj) {
            boolean flag = false;
            if(obj instanceof ResourcesKey) goto _L2; else goto _L1
_L1:
            return flag;
_L2:
            ResourcesKey resourceskey = (ResourcesKey)obj;
            if(mResDir.equals(resourceskey.mResDir) && mScale == resourceskey.mScale)
                flag = true;
            if(true) goto _L1; else goto _L3
_L3:
        }

        public int hashCode() {
            return mHash;
        }

        private final int mHash;
        private final String mResDir;
        private final float mScale;

        ResourcesKey(String s, float f) {
            mResDir = s;
            mScale = f;
            mHash = mResDir.hashCode() << 2 + (int)(2.0F * mScale);
        }
    }

    final class GcIdler
        implements android.os.MessageQueue.IdleHandler {

        public final boolean queueIdle() {
            doGcIfNeeded();
            return false;
        }

        final ActivityThread this$0;

        GcIdler() {
            this$0 = ActivityThread.this;
            super();
        }
    }

    private class Idler
        implements android.os.MessageQueue.IdleHandler {

        public final boolean queueIdle() {
            ActivityClientRecord activityclientrecord = mNewActivities;
            boolean flag = false;
            if(mBoundApplication != null && mProfiler.profileFd != null && mProfiler.autoStopProfiler)
                flag = true;
            if(activityclientrecord != null) {
                mNewActivities = null;
                IActivityManager iactivitymanager = ActivityManagerNative.getDefault();
                do {
                    ActivityClientRecord activityclientrecord1;
                    if(activityclientrecord.activity != null && !activityclientrecord.activity.mFinished)
                        try {
                            iactivitymanager.activityIdle(activityclientrecord.token, activityclientrecord.createdConfig, flag);
                            activityclientrecord.createdConfig = null;
                        }
                        catch(RemoteException remoteexception) { }
                    activityclientrecord1 = activityclientrecord;
                    activityclientrecord = activityclientrecord.nextIdle;
                    activityclientrecord1.nextIdle = null;
                } while(activityclientrecord != null);
            }
            if(flag)
                mProfiler.stopProfiling();
            ensureJitEnabled();
            return false;
        }

        final ActivityThread this$0;

        private Idler() {
            this$0 = ActivityThread.this;
            super();
        }

    }

    private class H extends Handler {

        private void maybeSnapshot() {
            if(mBoundApplication == null || !SamplingProfilerIntegration.isEnabled()) goto _L2; else goto _L1
_L1:
            String s;
            android.content.pm.PackageInfo packageinfo;
            s = mBoundApplication.info.mPackageName;
            packageinfo = null;
            ContextImpl contextimpl = getSystemContext();
            if(contextimpl != null) goto _L4; else goto _L3
_L3:
            Log.e("ActivityThread", "cannot get a valid context");
              goto _L2
_L4:
            PackageManager packagemanager = contextimpl.getPackageManager();
            if(packagemanager != null) goto _L6; else goto _L5
_L5:
            Log.e("ActivityThread", "cannot get a valid PackageManager");
              goto _L2
            android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
            namenotfoundexception;
            Log.e("ActivityThread", (new StringBuilder()).append("cannot get package info for ").append(s).toString(), namenotfoundexception);
_L7:
            SamplingProfilerIntegration.writeSnapshot(mBoundApplication.processName, packageinfo);
            break; /* Loop/switch isn't completed */
_L6:
            android.content.pm.PackageInfo packageinfo1 = packagemanager.getPackageInfo(s, 1);
            packageinfo = packageinfo1;
            if(true) goto _L7; else goto _L2
_L2:
        }

        String codeToString(int i) {
            return Integer.toString(i);
        }

        public void handleMessage(Message message) {
            boolean flag;
            boolean flag1;
            flag = true;
            flag1 = false;
            message.what;
            JVM INSTR tableswitch 100 142: default 196
        //                       100 197
        //                       101 293
        //                       102 354
        //                       103 408
        //                       104 445
        //                       105 482
        //                       106 515
        //                       107 548
        //                       108 599
        //                       109 631
        //                       110 689
        //                       111 725
        //                       112 754
        //                       113 786
        //                       114 822
        //                       115 918
        //                       116 950
        //                       117 986
        //                       118 1018
        //                       119 1051
        //                       120 1081
        //                       121 854
        //                       122 886
        //                       123 1091
        //                       124 1108
        //                       125 1133
        //                       126 258
        //                       127 1165
        //                       128 1203
        //                       129 1235
        //                       130 1267
        //                       131 1276
        //                       132 1308
        //                       133 1318
        //                       134 1357
        //                       135 1372
        //                       136 1398
        //                       137 1432
        //                       138 1485
        //                       139 1517
        //                       140 1534
        //                       141 1415
        //                       142 1563;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43 _L44
_L1:
            return;
_L2:
            Trace.traceBegin(64L, "activityStart");
            ActivityClientRecord activityclientrecord1 = (ActivityClientRecord)message.obj;
            activityclientrecord1.packageInfo = getPackageInfoNoCheck(((ComponentInfo) (activityclientrecord1.activityInfo)).applicationInfo, activityclientrecord1.compatInfo);
            handleLaunchActivity(activityclientrecord1, null);
            Trace.traceEnd(64L);
            continue; /* Loop/switch isn't completed */
_L28:
            Trace.traceBegin(64L, "activityRestart");
            ActivityClientRecord activityclientrecord = (ActivityClientRecord)message.obj;
            handleRelaunchActivity(activityclientrecord);
            Trace.traceEnd(64L);
            continue; /* Loop/switch isn't completed */
_L3:
            Trace.traceBegin(64L, "activityPause");
            ActivityThread activitythread5 = ActivityThread.this;
            IBinder ibinder4 = (IBinder)message.obj;
            if(message.arg1 == 0)
                flag = false;
            activitythread5.handlePauseActivity(ibinder4, false, flag, message.arg2);
            maybeSnapshot();
            Trace.traceEnd(64L);
            continue; /* Loop/switch isn't completed */
_L4:
            Trace.traceBegin(64L, "activityPause");
            ActivityThread activitythread4 = ActivityThread.this;
            IBinder ibinder3 = (IBinder)message.obj;
            if(message.arg1 != 0)
                flag1 = flag;
            activitythread4.handlePauseActivity(ibinder3, flag, flag1, message.arg2);
            Trace.traceEnd(64L);
            continue; /* Loop/switch isn't completed */
_L5:
            Trace.traceBegin(64L, "activityStop");
            handleStopActivity((IBinder)message.obj, flag, message.arg2);
            Trace.traceEnd(64L);
            continue; /* Loop/switch isn't completed */
_L6:
            Trace.traceBegin(64L, "activityStop");
            handleStopActivity((IBinder)message.obj, false, message.arg2);
            Trace.traceEnd(64L);
            continue; /* Loop/switch isn't completed */
_L7:
            Trace.traceBegin(64L, "activityShowWindow");
            handleWindowVisibility((IBinder)message.obj, flag);
            Trace.traceEnd(64L);
            continue; /* Loop/switch isn't completed */
_L8:
            Trace.traceBegin(64L, "activityHideWindow");
            handleWindowVisibility((IBinder)message.obj, false);
            Trace.traceEnd(64L);
            continue; /* Loop/switch isn't completed */
_L9:
            Trace.traceBegin(64L, "activityResume");
            ActivityThread activitythread3 = ActivityThread.this;
            IBinder ibinder2 = (IBinder)message.obj;
            if(message.arg1 != 0)
                flag1 = flag;
            activitythread3.handleResumeActivity(ibinder2, flag, flag1);
            Trace.traceEnd(64L);
            continue; /* Loop/switch isn't completed */
_L10:
            Trace.traceBegin(64L, "activityDeliverResult");
            handleSendResult((ResultData)message.obj);
            Trace.traceEnd(64L);
            continue; /* Loop/switch isn't completed */
_L11:
            Trace.traceBegin(64L, "activityDestroy");
            ActivityThread activitythread2 = ActivityThread.this;
            IBinder ibinder1 = (IBinder)message.obj;
            if(message.arg1 == 0)
                flag = false;
            activitythread2.handleDestroyActivity(ibinder1, flag, message.arg2, false);
            Trace.traceEnd(64L);
            continue; /* Loop/switch isn't completed */
_L12:
            Trace.traceBegin(64L, "bindApplication");
            AppBindData appbinddata = (AppBindData)message.obj;
            handleBindApplication(appbinddata);
            Trace.traceEnd(64L);
            continue; /* Loop/switch isn't completed */
_L13:
            if(mInitialApplication != null)
                mInitialApplication.onTerminate();
            Looper.myLooper().quit();
            continue; /* Loop/switch isn't completed */
_L14:
            Trace.traceBegin(64L, "activityNewIntent");
            handleNewIntent((NewIntentData)message.obj);
            Trace.traceEnd(64L);
            continue; /* Loop/switch isn't completed */
_L15:
            Trace.traceBegin(64L, "broadcastReceiveComp");
            handleReceiver((ReceiverData)message.obj);
            maybeSnapshot();
            Trace.traceEnd(64L);
            continue; /* Loop/switch isn't completed */
_L16:
            Trace.traceBegin(64L, "serviceCreate");
            handleCreateService((CreateServiceData)message.obj);
            Trace.traceEnd(64L);
            continue; /* Loop/switch isn't completed */
_L23:
            Trace.traceBegin(64L, "serviceBind");
            handleBindService((BindServiceData)message.obj);
            Trace.traceEnd(64L);
            continue; /* Loop/switch isn't completed */
_L24:
            Trace.traceBegin(64L, "serviceUnbind");
            handleUnbindService((BindServiceData)message.obj);
            Trace.traceEnd(64L);
            continue; /* Loop/switch isn't completed */
_L17:
            Trace.traceBegin(64L, "serviceStart");
            handleServiceArgs((ServiceArgsData)message.obj);
            Trace.traceEnd(64L);
            continue; /* Loop/switch isn't completed */
_L18:
            Trace.traceBegin(64L, "serviceStop");
            handleStopService((IBinder)message.obj);
            maybeSnapshot();
            Trace.traceEnd(64L);
            continue; /* Loop/switch isn't completed */
_L19:
            Trace.traceBegin(64L, "requestThumbnail");
            handleRequestThumbnail((IBinder)message.obj);
            Trace.traceEnd(64L);
            continue; /* Loop/switch isn't completed */
_L20:
            Trace.traceBegin(64L, "configChanged");
            handleConfigurationChanged((Configuration)message.obj, null);
            Trace.traceEnd(64L);
            continue; /* Loop/switch isn't completed */
_L21:
            ContextCleanupInfo contextcleanupinfo = (ContextCleanupInfo)message.obj;
            contextcleanupinfo.context.performFinalCleanup(contextcleanupinfo.who, contextcleanupinfo.what);
            continue; /* Loop/switch isn't completed */
_L22:
            scheduleGcIdler();
            continue; /* Loop/switch isn't completed */
_L25:
            handleDumpService((DumpComponentInfo)message.obj);
            continue; /* Loop/switch isn't completed */
_L26:
            Trace.traceBegin(64L, "lowMemory");
            handleLowMemory();
            Trace.traceEnd(64L);
            continue; /* Loop/switch isn't completed */
_L27:
            Trace.traceBegin(64L, "activityConfigChanged");
            handleActivityConfigurationChanged((IBinder)message.obj);
            Trace.traceEnd(64L);
            continue; /* Loop/switch isn't completed */
_L29:
            ActivityThread activitythread1 = ActivityThread.this;
            if(message.arg1 == 0)
                flag = false;
            activitythread1.handleProfilerControl(flag, (ProfilerControlData)message.obj, message.arg2);
            continue; /* Loop/switch isn't completed */
_L30:
            Trace.traceBegin(64L, "backupCreateAgent");
            handleCreateBackupAgent((CreateBackupAgentData)message.obj);
            Trace.traceEnd(64L);
            continue; /* Loop/switch isn't completed */
_L31:
            Trace.traceBegin(64L, "backupDestroyAgent");
            handleDestroyBackupAgent((CreateBackupAgentData)message.obj);
            Trace.traceEnd(64L);
            continue; /* Loop/switch isn't completed */
_L32:
            Process.killProcess(Process.myPid());
            continue; /* Loop/switch isn't completed */
_L33:
            Trace.traceBegin(64L, "providerRemove");
            completeRemoveProvider((ProviderRefCount)message.obj);
            Trace.traceEnd(64L);
            continue; /* Loop/switch isn't completed */
_L34:
            ensureJitEnabled();
            continue; /* Loop/switch isn't completed */
_L35:
            Trace.traceBegin(64L, "broadcastPackage");
            handleDispatchPackageBroadcast(message.arg1, (String[])(String[])message.obj);
            Trace.traceEnd(64L);
            continue; /* Loop/switch isn't completed */
_L36:
            throw new RemoteServiceException((String)message.obj);
_L37:
            if(message.arg1 == 0)
                flag = false;
            ActivityThread.handleDumpHeap(flag, (DumpHeapData)message.obj);
            continue; /* Loop/switch isn't completed */
_L38:
            handleDumpActivity((DumpComponentInfo)message.obj);
            continue; /* Loop/switch isn't completed */
_L43:
            handleDumpProvider((DumpComponentInfo)message.obj);
            continue; /* Loop/switch isn't completed */
_L39:
            Trace.traceBegin(64L, "sleeping");
            ActivityThread activitythread = ActivityThread.this;
            IBinder ibinder = (IBinder)message.obj;
            if(message.arg1 == 0)
                flag = false;
            activitythread.handleSleeping(ibinder, flag);
            Trace.traceEnd(64L);
            continue; /* Loop/switch isn't completed */
_L40:
            Trace.traceBegin(64L, "setCoreSettings");
            handleSetCoreSettings((Bundle)message.obj);
            Trace.traceEnd(64L);
            continue; /* Loop/switch isn't completed */
_L41:
            handleUpdatePackageCompatibilityInfo((UpdateCompatibilityData)message.obj);
            continue; /* Loop/switch isn't completed */
_L42:
            Trace.traceBegin(64L, "trimMemory");
            handleTrimMemory(message.arg1);
            Trace.traceEnd(64L);
            continue; /* Loop/switch isn't completed */
_L44:
            handleUnstableProviderDied((IBinder)message.obj, false);
            if(true) goto _L1; else goto _L45
_L45:
        }

        public static final int ACTIVITY_CONFIGURATION_CHANGED = 125;
        public static final int BIND_APPLICATION = 110;
        public static final int BIND_SERVICE = 121;
        public static final int CLEAN_UP_CONTEXT = 119;
        public static final int CONFIGURATION_CHANGED = 118;
        public static final int CREATE_BACKUP_AGENT = 128;
        public static final int CREATE_SERVICE = 114;
        public static final int DESTROY_ACTIVITY = 109;
        public static final int DESTROY_BACKUP_AGENT = 129;
        public static final int DISPATCH_PACKAGE_BROADCAST = 133;
        public static final int DUMP_ACTIVITY = 136;
        public static final int DUMP_HEAP = 135;
        public static final int DUMP_PROVIDER = 141;
        public static final int DUMP_SERVICE = 123;
        public static final int ENABLE_JIT = 132;
        public static final int EXIT_APPLICATION = 111;
        public static final int GC_WHEN_IDLE = 120;
        public static final int HIDE_WINDOW = 106;
        public static final int LAUNCH_ACTIVITY = 100;
        public static final int LOW_MEMORY = 124;
        public static final int NEW_INTENT = 112;
        public static final int PAUSE_ACTIVITY = 101;
        public static final int PAUSE_ACTIVITY_FINISHING = 102;
        public static final int PROFILER_CONTROL = 127;
        public static final int RECEIVER = 113;
        public static final int RELAUNCH_ACTIVITY = 126;
        public static final int REMOVE_PROVIDER = 131;
        public static final int REQUEST_THUMBNAIL = 117;
        public static final int RESUME_ACTIVITY = 107;
        public static final int SCHEDULE_CRASH = 134;
        public static final int SEND_RESULT = 108;
        public static final int SERVICE_ARGS = 115;
        public static final int SET_CORE_SETTINGS = 138;
        public static final int SHOW_WINDOW = 105;
        public static final int SLEEPING = 137;
        public static final int STOP_ACTIVITY_HIDE = 104;
        public static final int STOP_ACTIVITY_SHOW = 103;
        public static final int STOP_SERVICE = 116;
        public static final int SUICIDE = 130;
        public static final int TRIM_MEMORY = 140;
        public static final int UNBIND_SERVICE = 122;
        public static final int UNSTABLE_PROVIDER_DIED = 142;
        public static final int UPDATE_PACKAGE_COMPATIBILITY_INFO = 139;
        final ActivityThread this$0;

        private H() {
            this$0 = ActivityThread.this;
            super();
        }

    }

    private class ApplicationThread extends ApplicationThreadNative {

        private android.os.Debug.MemoryInfo dumpMemInfo(PrintWriter printwriter, boolean flag, boolean flag1) {
            long l;
            long l1;
            long l2;
            android.os.Debug.MemoryInfo memoryinfo;
            l = Debug.getNativeHeapSize() / 1024L;
            l1 = Debug.getNativeHeapAllocatedSize() / 1024L;
            l2 = Debug.getNativeHeapFreeSize() / 1024L;
            memoryinfo = new android.os.Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryinfo);
            if(flag1) goto _L2; else goto _L1
_L1:
            return memoryinfo;
_L2:
            Runtime runtime = Runtime.getRuntime();
            long l3 = runtime.totalMemory() / 1024L;
            long l4 = runtime.freeMemory() / 1024L;
            long l5 = l3 - l4;
            long l6 = ViewDebug.getViewInstanceCount();
            long l7 = ViewDebug.getViewRootImplCount();
            long l8 = Debug.countInstancesOfClass(android/app/ContextImpl);
            long l9 = Debug.countInstancesOfClass(android/app/Activity);
            int i = AssetManager.getGlobalAssetCount();
            int j = AssetManager.getGlobalAssetManagerCount();
            int k = Debug.getBinderLocalObjectCount();
            int i1 = Debug.getBinderProxyObjectCount();
            int j1 = Debug.getBinderDeathObjectCount();
            long l10 = Debug.countInstancesOfClass(org/apache/harmony/xnet/provider/jsse/OpenSSLSocketImpl);
            android.database.sqlite.SQLiteDebug.PagerStats pagerstats = SQLiteDebug.getDatabaseInfo();
            if(flag) {
                String s4;
                int k3;
                if(mBoundApplication != null)
                    s4 = mBoundApplication.processName;
                else
                    s4 = "unknown";
                printwriter.print(1);
                printwriter.print(',');
                printwriter.print(Process.myPid());
                printwriter.print(',');
                printwriter.print(s4);
                printwriter.print(',');
                printwriter.print(l);
                printwriter.print(',');
                printwriter.print(l3);
                printwriter.print(',');
                printwriter.print("N/A,");
                printwriter.print(l + l3);
                printwriter.print(',');
                printwriter.print(l1);
                printwriter.print(',');
                printwriter.print(l5);
                printwriter.print(',');
                printwriter.print("N/A,");
                printwriter.print(l1 + l5);
                printwriter.print(',');
                printwriter.print(l2);
                printwriter.print(',');
                printwriter.print(l4);
                printwriter.print(',');
                printwriter.print("N/A,");
                printwriter.print(l2 + l4);
                printwriter.print(',');
                printwriter.print(memoryinfo.nativePss);
                printwriter.print(',');
                printwriter.print(memoryinfo.dalvikPss);
                printwriter.print(',');
                printwriter.print(memoryinfo.otherPss);
                printwriter.print(',');
                printwriter.print(memoryinfo.nativePss + memoryinfo.dalvikPss + memoryinfo.otherPss);
                printwriter.print(',');
                printwriter.print(memoryinfo.nativeSharedDirty);
                printwriter.print(',');
                printwriter.print(memoryinfo.dalvikSharedDirty);
                printwriter.print(',');
                printwriter.print(memoryinfo.otherSharedDirty);
                printwriter.print(',');
                printwriter.print(memoryinfo.nativeSharedDirty + memoryinfo.dalvikSharedDirty + memoryinfo.otherSharedDirty);
                printwriter.print(',');
                printwriter.print(memoryinfo.nativePrivateDirty);
                printwriter.print(',');
                printwriter.print(memoryinfo.dalvikPrivateDirty);
                printwriter.print(',');
                printwriter.print(memoryinfo.otherPrivateDirty);
                printwriter.print(',');
                printwriter.print(memoryinfo.nativePrivateDirty + memoryinfo.dalvikPrivateDirty + memoryinfo.otherPrivateDirty);
                printwriter.print(',');
                printwriter.print(l6);
                printwriter.print(',');
                printwriter.print(l7);
                printwriter.print(',');
                printwriter.print(l8);
                printwriter.print(',');
                printwriter.print(l9);
                printwriter.print(',');
                printwriter.print(i);
                printwriter.print(',');
                printwriter.print(j);
                printwriter.print(',');
                printwriter.print(k);
                printwriter.print(',');
                printwriter.print(i1);
                printwriter.print(',');
                printwriter.print(j1);
                printwriter.print(',');
                printwriter.print(l10);
                printwriter.print(',');
                printwriter.print(pagerstats.memoryUsed / 1024);
                printwriter.print(',');
                printwriter.print(pagerstats.memoryUsed / 1024);
                printwriter.print(',');
                printwriter.print(pagerstats.pageCacheOverflow / 1024);
                printwriter.print(',');
                printwriter.print(pagerstats.largestMemAlloc / 1024);
                k3 = 0;
                do {
                    int i4 = pagerstats.dbStats.size();
                    if(k3 >= i4)
                        break;
                    android.database.sqlite.SQLiteDebug.DbStats dbstats1 = (android.database.sqlite.SQLiteDebug.DbStats)pagerstats.dbStats.get(k3);
                    printwriter.print(',');
                    printwriter.print(dbstats1.dbName);
                    printwriter.print(',');
                    printwriter.print(dbstats1.pageSize);
                    printwriter.print(',');
                    printwriter.print(dbstats1.dbSize);
                    printwriter.print(',');
                    printwriter.print(dbstats1.lookaside);
                    printwriter.print(',');
                    printwriter.print(dbstats1.cache);
                    printwriter.print(',');
                    printwriter.print(dbstats1.cache);
                    k3++;
                } while(true);
                printwriter.println();
            } else {
                Object aobj[] = new Object[7];
                aobj[0] = "";
                aobj[1] = "";
                aobj[2] = "Shared";
                aobj[3] = "Private";
                aobj[4] = "Heap";
                aobj[5] = "Heap";
                aobj[6] = "Heap";
                printRow(printwriter, "%13s %8s %8s %8s %8s %8s %8s", aobj);
                Object aobj1[] = new Object[7];
                aobj1[0] = "";
                aobj1[1] = "Pss";
                aobj1[2] = "Dirty";
                aobj1[3] = "Dirty";
                aobj1[4] = "Size";
                aobj1[5] = "Alloc";
                aobj1[6] = "Free";
                printRow(printwriter, "%13s %8s %8s %8s %8s %8s %8s", aobj1);
                Object aobj2[] = new Object[7];
                aobj2[0] = "";
                aobj2[1] = "------";
                aobj2[2] = "------";
                aobj2[3] = "------";
                aobj2[4] = "------";
                aobj2[5] = "------";
                aobj2[6] = "------";
                printRow(printwriter, "%13s %8s %8s %8s %8s %8s %8s", aobj2);
                Object aobj3[] = new Object[7];
                aobj3[0] = "Native";
                aobj3[1] = Integer.valueOf(memoryinfo.nativePss);
                aobj3[2] = Integer.valueOf(memoryinfo.nativeSharedDirty);
                aobj3[3] = Integer.valueOf(memoryinfo.nativePrivateDirty);
                aobj3[4] = Long.valueOf(l);
                aobj3[5] = Long.valueOf(l1);
                aobj3[6] = Long.valueOf(l2);
                printRow(printwriter, "%13s %8s %8s %8s %8s %8s %8s", aobj3);
                Object aobj4[] = new Object[7];
                aobj4[0] = "Dalvik";
                aobj4[1] = Integer.valueOf(memoryinfo.dalvikPss);
                aobj4[2] = Integer.valueOf(memoryinfo.dalvikSharedDirty);
                aobj4[3] = Integer.valueOf(memoryinfo.dalvikPrivateDirty);
                aobj4[4] = Long.valueOf(l3);
                aobj4[5] = Long.valueOf(l5);
                aobj4[6] = Long.valueOf(l4);
                printRow(printwriter, "%13s %8s %8s %8s %8s %8s %8s", aobj4);
                int k1 = memoryinfo.otherPss;
                int i2 = memoryinfo.otherSharedDirty;
                int j2 = memoryinfo.otherPrivateDirty;
                for(int k2 = 0; k2 < 9; k2++) {
                    Object aobj17[] = new Object[7];
                    aobj17[0] = android.os.Debug.MemoryInfo.getOtherLabel(k2);
                    aobj17[1] = Integer.valueOf(memoryinfo.getOtherPss(k2));
                    aobj17[2] = Integer.valueOf(memoryinfo.getOtherSharedDirty(k2));
                    aobj17[3] = Integer.valueOf(memoryinfo.getOtherPrivateDirty(k2));
                    aobj17[4] = "";
                    aobj17[5] = "";
                    aobj17[6] = "";
                    printRow(printwriter, "%13s %8s %8s %8s %8s %8s %8s", aobj17);
                    k1 -= memoryinfo.getOtherPss(k2);
                    i2 -= memoryinfo.getOtherSharedDirty(k2);
                    j2 -= memoryinfo.getOtherPrivateDirty(k2);
                }

                Object aobj5[] = new Object[7];
                aobj5[0] = "Unknown";
                aobj5[1] = Integer.valueOf(k1);
                aobj5[2] = Integer.valueOf(i2);
                aobj5[3] = Integer.valueOf(j2);
                aobj5[4] = "";
                aobj5[5] = "";
                aobj5[6] = "";
                printRow(printwriter, "%13s %8s %8s %8s %8s %8s %8s", aobj5);
                Object aobj6[] = new Object[7];
                aobj6[0] = "TOTAL";
                aobj6[1] = Integer.valueOf(memoryinfo.getTotalPss());
                aobj6[2] = Integer.valueOf(memoryinfo.getTotalSharedDirty());
                aobj6[3] = Integer.valueOf(memoryinfo.getTotalPrivateDirty());
                aobj6[4] = Long.valueOf(l + l3);
                aobj6[5] = Long.valueOf(l1 + l5);
                aobj6[6] = Long.valueOf(l2 + l4);
                printRow(printwriter, "%13s %8s %8s %8s %8s %8s %8s", aobj6);
                printwriter.println(" ");
                printwriter.println(" Objects");
                Object aobj7[] = new Object[4];
                aobj7[0] = "Views:";
                aobj7[1] = Long.valueOf(l6);
                aobj7[2] = "ViewRootImpl:";
                aobj7[3] = Long.valueOf(l7);
                printRow(printwriter, "%21s %8d %21s %8d", aobj7);
                Object aobj8[] = new Object[4];
                aobj8[0] = "AppContexts:";
                aobj8[1] = Long.valueOf(l8);
                aobj8[2] = "Activities:";
                aobj8[3] = Long.valueOf(l9);
                printRow(printwriter, "%21s %8d %21s %8d", aobj8);
                Object aobj9[] = new Object[4];
                aobj9[0] = "Assets:";
                aobj9[1] = Integer.valueOf(i);
                aobj9[2] = "AssetManagers:";
                aobj9[3] = Integer.valueOf(j);
                printRow(printwriter, "%21s %8d %21s %8d", aobj9);
                Object aobj10[] = new Object[4];
                aobj10[0] = "Local Binders:";
                aobj10[1] = Integer.valueOf(k);
                aobj10[2] = "Proxy Binders:";
                aobj10[3] = Integer.valueOf(i1);
                printRow(printwriter, "%21s %8d %21s %8d", aobj10);
                Object aobj11[] = new Object[2];
                aobj11[0] = "Death Recipients:";
                aobj11[1] = Integer.valueOf(j1);
                printRow(printwriter, "%21s %8d", aobj11);
                Object aobj12[] = new Object[2];
                aobj12[0] = "OpenSSL Sockets:";
                aobj12[1] = Long.valueOf(l10);
                printRow(printwriter, "%21s %8d", aobj12);
                printwriter.println(" ");
                printwriter.println(" SQL");
                Object aobj13[] = new Object[2];
                aobj13[0] = "MEMORY_USED:";
                aobj13[1] = Integer.valueOf(pagerstats.memoryUsed / 1024);
                printRow(printwriter, "%21s %8d", aobj13);
                Object aobj14[] = new Object[4];
                aobj14[0] = "PAGECACHE_OVERFLOW:";
                aobj14[1] = Integer.valueOf(pagerstats.pageCacheOverflow / 1024);
                aobj14[2] = "MALLOC_SIZE:";
                aobj14[3] = Integer.valueOf(pagerstats.largestMemAlloc / 1024);
                printRow(printwriter, "%21s %8d %21s %8d", aobj14);
                printwriter.println(" ");
                int i3 = pagerstats.dbStats.size();
                if(i3 > 0) {
                    printwriter.println(" DATABASES");
                    Object aobj15[] = new Object[5];
                    aobj15[0] = "pgsz";
                    aobj15[1] = "dbsz";
                    aobj15[2] = "Lookaside(b)";
                    aobj15[3] = "cache";
                    aobj15[4] = "Dbname";
                    printRow(printwriter, "  %8s %8s %14s %14s  %s", aobj15);
                    int j3 = 0;
                    while(j3 < i3)  {
                        android.database.sqlite.SQLiteDebug.DbStats dbstats = (android.database.sqlite.SQLiteDebug.DbStats)pagerstats.dbStats.get(j3);
                        Object aobj16[] = new Object[5];
                        String s1;
                        String s2;
                        String s3;
                        if(dbstats.pageSize > 0L)
                            s1 = String.valueOf(dbstats.pageSize);
                        else
                            s1 = " ";
                        aobj16[0] = s1;
                        if(dbstats.dbSize > 0L)
                            s2 = String.valueOf(dbstats.dbSize);
                        else
                            s2 = " ";
                        aobj16[1] = s2;
                        if(dbstats.lookaside > 0)
                            s3 = String.valueOf(dbstats.lookaside);
                        else
                            s3 = " ";
                        aobj16[2] = s3;
                        aobj16[3] = dbstats.cache;
                        aobj16[4] = dbstats.dbName;
                        printRow(printwriter, "  %8s %8s %14s %14s  %s", aobj16);
                        j3++;
                    }
                }
                String s = AssetManager.getAssetAllocations();
                if(s != null) {
                    printwriter.println(" ");
                    printwriter.println(" Asset Allocations");
                    printwriter.print(s);
                }
            }
            if(true) goto _L1; else goto _L3
_L3:
        }

        private transient void printRow(PrintWriter printwriter, String s, Object aobj[]) {
            printwriter.println(String.format(s, aobj));
        }

        private void updatePendingConfiguration(Configuration configuration) {
            HashMap hashmap = mPackages;
            hashmap;
            JVM INSTR monitorenter ;
            if(mPendingConfiguration == null || mPendingConfiguration.isOtherSeqNewer(configuration))
                mPendingConfiguration = configuration;
            return;
        }

        public final void bindApplication(String s, ApplicationInfo applicationinfo, List list, ComponentName componentname, String s1, ParcelFileDescriptor parcelfiledescriptor, boolean flag, 
                Bundle bundle, IInstrumentationWatcher iinstrumentationwatcher, int i, boolean flag1, boolean flag2, boolean flag3, Configuration configuration, 
                CompatibilityInfo compatibilityinfo, Map map, Bundle bundle1) {
            if(map != null)
                ServiceManager.initServiceCache(map);
            setCoreSettings(bundle1);
            AppBindData appbinddata = new AppBindData();
            appbinddata.processName = s;
            appbinddata.appInfo = applicationinfo;
            appbinddata.providers = list;
            appbinddata.instrumentationName = componentname;
            appbinddata.instrumentationArgs = bundle;
            appbinddata.instrumentationWatcher = iinstrumentationwatcher;
            appbinddata.debugMode = i;
            appbinddata.enableOpenGlTrace = flag1;
            appbinddata.restrictedBackupMode = flag2;
            appbinddata.persistent = flag3;
            appbinddata.config = configuration;
            appbinddata.compatInfo = compatibilityinfo;
            appbinddata.initProfileFile = s1;
            appbinddata.initProfileFd = parcelfiledescriptor;
            appbinddata.initAutoStopProfiler = false;
            queueOrSendMessage(110, appbinddata);
        }

        public void clearDnsCache() {
            InetAddress.clearDnsCache();
        }

        public void dispatchPackageBroadcast(int i, String as[]) {
            queueOrSendMessage(133, as, i);
        }

        public void dumpActivity(FileDescriptor filedescriptor, IBinder ibinder, String s, String as[]) {
            DumpComponentInfo dumpcomponentinfo = new DumpComponentInfo();
            dumpcomponentinfo.fd = ParcelFileDescriptor.dup(filedescriptor);
            dumpcomponentinfo.token = ibinder;
            dumpcomponentinfo.prefix = s;
            dumpcomponentinfo.args = as;
            queueOrSendMessage(136, dumpcomponentinfo);
_L1:
            return;
            IOException ioexception;
            ioexception;
            Slog.w("ActivityThread", "dumpActivity failed", ioexception);
              goto _L1
        }

        public void dumpDbInfo(FileDescriptor filedescriptor, String as[]) {
            PrintWriter printwriter = new PrintWriter(new FileOutputStream(filedescriptor));
            SQLiteDebug.dump(new PrintWriterPrinter(printwriter), as);
            printwriter.flush();
        }

        public void dumpGfxInfo(FileDescriptor filedescriptor, String as[]) {
            dumpGraphicsInfo(filedescriptor);
            WindowManagerImpl.getDefault().dumpGfxInfo(filedescriptor);
        }

        public void dumpHeap(boolean flag, String s, ParcelFileDescriptor parcelfiledescriptor) {
            DumpHeapData dumpheapdata = new DumpHeapData();
            dumpheapdata.path = s;
            dumpheapdata.fd = parcelfiledescriptor;
            ActivityThread activitythread = ActivityThread.this;
            int i;
            if(flag)
                i = 1;
            else
                i = 0;
            activitythread.queueOrSendMessage(135, dumpheapdata, i);
        }

        public android.os.Debug.MemoryInfo dumpMemInfo(FileDescriptor filedescriptor, boolean flag, boolean flag1, String as[]) {
            PrintWriter printwriter = new PrintWriter(new FileOutputStream(filedescriptor));
            android.os.Debug.MemoryInfo memoryinfo = dumpMemInfo(printwriter, flag, flag1);
            printwriter.flush();
            return memoryinfo;
            Exception exception;
            exception;
            printwriter.flush();
            throw exception;
        }

        public void dumpProvider(FileDescriptor filedescriptor, IBinder ibinder, String as[]) {
            DumpComponentInfo dumpcomponentinfo = new DumpComponentInfo();
            dumpcomponentinfo.fd = ParcelFileDescriptor.dup(filedescriptor);
            dumpcomponentinfo.token = ibinder;
            dumpcomponentinfo.args = as;
            queueOrSendMessage(141, dumpcomponentinfo);
_L1:
            return;
            IOException ioexception;
            ioexception;
            Slog.w("ActivityThread", "dumpProvider failed", ioexception);
              goto _L1
        }

        public void dumpService(FileDescriptor filedescriptor, IBinder ibinder, String as[]) {
            DumpComponentInfo dumpcomponentinfo = new DumpComponentInfo();
            dumpcomponentinfo.fd = ParcelFileDescriptor.dup(filedescriptor);
            dumpcomponentinfo.token = ibinder;
            dumpcomponentinfo.args = as;
            queueOrSendMessage(123, dumpcomponentinfo);
_L1:
            return;
            IOException ioexception;
            ioexception;
            Slog.w("ActivityThread", "dumpService failed", ioexception);
              goto _L1
        }

        public void getMemoryInfo(android.os.Debug.MemoryInfo memoryinfo) {
            Debug.getMemoryInfo(memoryinfo);
        }

        public void processInBackground() {
            mH.removeMessages(120);
            mH.sendMessage(mH.obtainMessage(120));
        }

        public void profilerControl(boolean flag, String s, ParcelFileDescriptor parcelfiledescriptor, int i) {
            ProfilerControlData profilercontroldata = new ProfilerControlData();
            profilercontroldata.path = s;
            profilercontroldata.fd = parcelfiledescriptor;
            ActivityThread activitythread = ActivityThread.this;
            int j;
            if(flag)
                j = 1;
            else
                j = 0;
            activitythread.queueOrSendMessage(127, profilercontroldata, j, i);
        }

        public void requestThumbnail(IBinder ibinder) {
            queueOrSendMessage(117, ibinder);
        }

        public void scheduleActivityConfigurationChanged(IBinder ibinder) {
            queueOrSendMessage(125, ibinder);
        }

        public final void scheduleBindService(IBinder ibinder, Intent intent, boolean flag) {
            BindServiceData bindservicedata = new BindServiceData();
            bindservicedata.token = ibinder;
            bindservicedata.intent = intent;
            bindservicedata.rebind = flag;
            queueOrSendMessage(121, bindservicedata);
        }

        public void scheduleConfigurationChanged(Configuration configuration) {
            updatePendingConfiguration(configuration);
            queueOrSendMessage(118, configuration);
        }

        public void scheduleCrash(String s) {
            queueOrSendMessage(134, s);
        }

        public final void scheduleCreateBackupAgent(ApplicationInfo applicationinfo, CompatibilityInfo compatibilityinfo, int i) {
            CreateBackupAgentData createbackupagentdata = new CreateBackupAgentData();
            createbackupagentdata.appInfo = applicationinfo;
            createbackupagentdata.compatInfo = compatibilityinfo;
            createbackupagentdata.backupMode = i;
            queueOrSendMessage(128, createbackupagentdata);
        }

        public final void scheduleCreateService(IBinder ibinder, ServiceInfo serviceinfo, CompatibilityInfo compatibilityinfo) {
            CreateServiceData createservicedata = new CreateServiceData();
            createservicedata.token = ibinder;
            createservicedata.info = serviceinfo;
            createservicedata.compatInfo = compatibilityinfo;
            queueOrSendMessage(114, createservicedata);
        }

        public final void scheduleDestroyActivity(IBinder ibinder, boolean flag, int i) {
            ActivityThread activitythread = ActivityThread.this;
            int j;
            if(flag)
                j = 1;
            else
                j = 0;
            activitythread.queueOrSendMessage(109, ibinder, j, i);
        }

        public final void scheduleDestroyBackupAgent(ApplicationInfo applicationinfo, CompatibilityInfo compatibilityinfo) {
            CreateBackupAgentData createbackupagentdata = new CreateBackupAgentData();
            createbackupagentdata.appInfo = applicationinfo;
            createbackupagentdata.compatInfo = compatibilityinfo;
            queueOrSendMessage(129, createbackupagentdata);
        }

        public final void scheduleExit() {
            queueOrSendMessage(111, null);
        }

        public final void scheduleLaunchActivity(Intent intent, IBinder ibinder, int i, ActivityInfo activityinfo, Configuration configuration, CompatibilityInfo compatibilityinfo, Bundle bundle, 
                List list, List list1, boolean flag, boolean flag1, String s, ParcelFileDescriptor parcelfiledescriptor, boolean flag2) {
            ActivityClientRecord activityclientrecord = new ActivityClientRecord();
            activityclientrecord.token = ibinder;
            activityclientrecord.ident = i;
            activityclientrecord.intent = intent;
            activityclientrecord.activityInfo = activityinfo;
            activityclientrecord.compatInfo = compatibilityinfo;
            activityclientrecord.state = bundle;
            activityclientrecord.pendingResults = list;
            activityclientrecord.pendingIntents = list1;
            activityclientrecord.startsNotResumed = flag;
            activityclientrecord.isForward = flag1;
            activityclientrecord.profileFile = s;
            activityclientrecord.profileFd = parcelfiledescriptor;
            activityclientrecord.autoStopProfiler = flag2;
            updatePendingConfiguration(configuration);
            queueOrSendMessage(100, activityclientrecord);
        }

        public void scheduleLowMemory() {
            queueOrSendMessage(124, null);
        }

        public final void scheduleNewIntent(List list, IBinder ibinder) {
            NewIntentData newintentdata = new NewIntentData();
            newintentdata.intents = list;
            newintentdata.token = ibinder;
            queueOrSendMessage(112, newintentdata);
        }

        public final void schedulePauseActivity(IBinder ibinder, boolean flag, boolean flag1, int i) {
            ActivityThread activitythread = ActivityThread.this;
            byte byte0;
            int j;
            if(flag)
                byte0 = 102;
            else
                byte0 = 101;
            if(flag1)
                j = 1;
            else
                j = 0;
            activitythread.queueOrSendMessage(byte0, ibinder, j, i);
        }

        public final void scheduleReceiver(Intent intent, ActivityInfo activityinfo, CompatibilityInfo compatibilityinfo, int i, String s, Bundle bundle, boolean flag) {
            ReceiverData receiverdata = new ReceiverData(intent, i, s, bundle, flag, false, mAppThread.asBinder());
            receiverdata.info = activityinfo;
            receiverdata.compatInfo = compatibilityinfo;
            queueOrSendMessage(113, receiverdata);
        }

        public void scheduleRegisteredReceiver(IIntentReceiver iintentreceiver, Intent intent, int i, String s, Bundle bundle, boolean flag, boolean flag1) throws RemoteException {
            iintentreceiver.performReceive(intent, i, s, bundle, flag, flag1);
        }

        public final void scheduleRelaunchActivity(IBinder ibinder, List list, List list1, int i, boolean flag, Configuration configuration) {
            requestRelaunchActivity(ibinder, list, list1, i, flag, configuration, true);
        }

        public final void scheduleResumeActivity(IBinder ibinder, boolean flag) {
            ActivityThread activitythread = ActivityThread.this;
            int i;
            if(flag)
                i = 1;
            else
                i = 0;
            activitythread.queueOrSendMessage(107, ibinder, i);
        }

        public final void scheduleSendResult(IBinder ibinder, List list) {
            ResultData resultdata = new ResultData();
            resultdata.token = ibinder;
            resultdata.results = list;
            queueOrSendMessage(108, resultdata);
        }

        public final void scheduleServiceArgs(IBinder ibinder, boolean flag, int i, int j, Intent intent) {
            ServiceArgsData serviceargsdata = new ServiceArgsData();
            serviceargsdata.token = ibinder;
            serviceargsdata.taskRemoved = flag;
            serviceargsdata.startId = i;
            serviceargsdata.flags = j;
            serviceargsdata.args = intent;
            queueOrSendMessage(115, serviceargsdata);
        }

        public final void scheduleSleeping(IBinder ibinder, boolean flag) {
            ActivityThread activitythread = ActivityThread.this;
            int i;
            if(flag)
                i = 1;
            else
                i = 0;
            activitythread.queueOrSendMessage(137, ibinder, i);
        }

        public final void scheduleStopActivity(IBinder ibinder, boolean flag, int i) {
            ActivityThread activitythread = ActivityThread.this;
            byte byte0;
            if(flag)
                byte0 = 103;
            else
                byte0 = 104;
            activitythread.queueOrSendMessage(byte0, ibinder, 0, i);
        }

        public final void scheduleStopService(IBinder ibinder) {
            queueOrSendMessage(116, ibinder);
        }

        public final void scheduleSuicide() {
            queueOrSendMessage(130, null);
        }

        public void scheduleTrimMemory(int i) {
            queueOrSendMessage(140, null, i);
        }

        public final void scheduleUnbindService(IBinder ibinder, Intent intent) {
            BindServiceData bindservicedata = new BindServiceData();
            bindservicedata.token = ibinder;
            bindservicedata.intent = intent;
            queueOrSendMessage(122, bindservicedata);
        }

        public final void scheduleWindowVisibility(IBinder ibinder, boolean flag) {
            ActivityThread activitythread = ActivityThread.this;
            byte byte0;
            if(flag)
                byte0 = 105;
            else
                byte0 = 106;
            activitythread.queueOrSendMessage(byte0, ibinder);
        }

        public void setCoreSettings(Bundle bundle) {
            queueOrSendMessage(138, bundle);
        }

        public void setHttpProxy(String s, String s1, String s2) {
            Proxy.setHttpProxySystemProperty(s, s1, s2);
        }

        public void setSchedulingGroup(int i) {
            Process.setProcessGroup(Process.myPid(), i);
_L1:
            return;
            Exception exception;
            exception;
            Slog.w("ActivityThread", (new StringBuilder()).append("Failed setting process group to ").append(i).toString(), exception);
              goto _L1
        }

        public void unstableProviderDied(IBinder ibinder) {
            queueOrSendMessage(142, ibinder);
        }

        public void updatePackageCompatibilityInfo(String s, CompatibilityInfo compatibilityinfo) {
            UpdateCompatibilityData updatecompatibilitydata = new UpdateCompatibilityData();
            updatecompatibilitydata.pkg = s;
            updatecompatibilitydata.info = compatibilityinfo;
            queueOrSendMessage(139, updatecompatibilitydata);
        }

        public void updateTimeZone() {
            TimeZone.setDefault(null);
        }

        private static final int ACTIVITY_THREAD_CHECKIN_VERSION = 1;
        private static final String DB_INFO_FORMAT = "  %8s %8s %14s %14s  %s";
        private static final String HEAP_COLUMN = "%13s %8s %8s %8s %8s %8s %8s";
        private static final String ONE_COUNT_COLUMN = "%21s %8d";
        private static final String TWO_COUNT_COLUMNS = "%21s %8d %21s %8d";
        final ActivityThread this$0;

        private ApplicationThread() {
            this$0 = ActivityThread.this;
            super();
        }

    }

    static final class UpdateCompatibilityData {

        CompatibilityInfo info;
        String pkg;

        UpdateCompatibilityData() {
        }
    }

    static final class DumpHeapData {

        ParcelFileDescriptor fd;
        String path;

        DumpHeapData() {
        }
    }

    static final class ProfilerControlData {

        ParcelFileDescriptor fd;
        String path;

        ProfilerControlData() {
        }
    }

    static final class ContextCleanupInfo {

        ContextImpl context;
        String what;
        String who;

        ContextCleanupInfo() {
        }
    }

    static final class ResultData {

        public String toString() {
            return (new StringBuilder()).append("ResultData{token=").append(token).append(" results").append(results).append("}").toString();
        }

        List results;
        IBinder token;

        ResultData() {
        }
    }

    static final class DumpComponentInfo {

        String args[];
        ParcelFileDescriptor fd;
        String prefix;
        IBinder token;

        DumpComponentInfo() {
        }
    }

    static final class Profiler {

        public void setProfiler(String s, ParcelFileDescriptor parcelfiledescriptor) {
            if(!profiling) goto _L2; else goto _L1
_L1:
            if(parcelfiledescriptor == null)
                break MISSING_BLOCK_LABEL_15;
            parcelfiledescriptor.close();
_L4:
            return;
_L2:
            IOException ioexception1;
            if(profileFd != null)
                try {
                    profileFd.close();
                }
                catch(IOException ioexception) { }
            profileFile = s;
            profileFd = parcelfiledescriptor;
            continue; /* Loop/switch isn't completed */
            ioexception1;
            if(true) goto _L4; else goto _L3
_L3:
        }

        public void startProfiling() {
            if(profileFd != null && !profiling)
                try {
                    Debug.startMethodTracing(profileFile, profileFd.getFileDescriptor(), 0x800000, 0);
                    profiling = true;
                }
                catch(RuntimeException runtimeexception) {
                    Slog.w("ActivityThread", (new StringBuilder()).append("Profiling failed on path ").append(profileFile).toString());
                    try {
                        profileFd.close();
                        profileFd = null;
                    }
                    catch(IOException ioexception) {
                        Slog.w("ActivityThread", "Failure closing profile fd", ioexception);
                    }
                }
        }

        public void stopProfiling() {
            if(profiling) {
                profiling = false;
                Debug.stopMethodTracing();
                if(profileFd != null)
                    try {
                        profileFd.close();
                    }
                    catch(IOException ioexception) { }
                profileFd = null;
                profileFile = null;
            }
        }

        boolean autoStopProfiler;
        boolean handlingProfiling;
        ParcelFileDescriptor profileFd;
        String profileFile;
        boolean profiling;

        Profiler() {
        }
    }

    static final class AppBindData {

        public String toString() {
            return (new StringBuilder()).append("AppBindData{appInfo=").append(appInfo).append("}").toString();
        }

        ApplicationInfo appInfo;
        CompatibilityInfo compatInfo;
        Configuration config;
        int debugMode;
        boolean enableOpenGlTrace;
        LoadedApk info;
        boolean initAutoStopProfiler;
        ParcelFileDescriptor initProfileFd;
        String initProfileFile;
        Bundle instrumentationArgs;
        ComponentName instrumentationName;
        IInstrumentationWatcher instrumentationWatcher;
        boolean persistent;
        String processName;
        List providers;
        boolean restrictedBackupMode;

        AppBindData() {
        }
    }

    static final class ServiceArgsData {

        public String toString() {
            return (new StringBuilder()).append("ServiceArgsData{token=").append(token).append(" startId=").append(startId).append(" args=").append(args).append("}").toString();
        }

        Intent args;
        int flags;
        int startId;
        boolean taskRemoved;
        IBinder token;

        ServiceArgsData() {
        }
    }

    static final class BindServiceData {

        public String toString() {
            return (new StringBuilder()).append("BindServiceData{token=").append(token).append(" intent=").append(intent).append("}").toString();
        }

        Intent intent;
        boolean rebind;
        IBinder token;

        BindServiceData() {
        }
    }

    static final class CreateServiceData {

        public String toString() {
            return (new StringBuilder()).append("CreateServiceData{token=").append(token).append(" className=").append(((PackageItemInfo) (info)).name).append(" packageName=").append(((PackageItemInfo) (info)).packageName).append(" intent=").append(intent).append("}").toString();
        }

        CompatibilityInfo compatInfo;
        ServiceInfo info;
        Intent intent;
        IBinder token;

        CreateServiceData() {
        }
    }

    static final class CreateBackupAgentData {

        public String toString() {
            return (new StringBuilder()).append("CreateBackupAgentData{appInfo=").append(appInfo).append(" backupAgent=").append(appInfo.backupAgentName).append(" mode=").append(backupMode).append("}").toString();
        }

        ApplicationInfo appInfo;
        int backupMode;
        CompatibilityInfo compatInfo;

        CreateBackupAgentData() {
        }
    }

    static final class ReceiverData extends android.content.BroadcastReceiver.PendingResult {

        public String toString() {
            return (new StringBuilder()).append("ReceiverData{intent=").append(intent).append(" packageName=").append(((PackageItemInfo) (info)).packageName).append(" resultCode=").append(getResultCode()).append(" resultData=").append(getResultData()).append(" resultExtras=").append(getResultExtras(false)).append("}").toString();
        }

        CompatibilityInfo compatInfo;
        ActivityInfo info;
        Intent intent;

        public ReceiverData(Intent intent1, int i, String s, Bundle bundle, boolean flag, boolean flag1, IBinder ibinder) {
            super(i, s, bundle, 0, flag, flag1, ibinder);
            intent = intent1;
        }
    }

    static final class NewIntentData {

        public String toString() {
            return (new StringBuilder()).append("NewIntentData{intents=").append(intents).append(" token=").append(token).append("}").toString();
        }

        List intents;
        IBinder token;

        NewIntentData() {
        }
    }

    final class ProviderClientRecord {

        final IActivityManager.ContentProviderHolder mHolder;
        final ContentProvider mLocalProvider;
        final String mNames[];
        final IContentProvider mProvider;
        final ActivityThread this$0;

        ProviderClientRecord(String as[], IContentProvider icontentprovider, ContentProvider contentprovider, IActivityManager.ContentProviderHolder contentproviderholder) {
            this$0 = ActivityThread.this;
            super();
            mNames = as;
            mProvider = icontentprovider;
            mLocalProvider = contentprovider;
            mHolder = contentproviderholder;
        }
    }

    static final class ActivityClientRecord {

        public boolean isPreHoneycomb() {
            boolean flag = false;
            if(activity != null && activity.getApplicationInfo().targetSdkVersion < 11)
                flag = true;
            return flag;
        }

        public String toString() {
            ComponentName componentname;
            StringBuilder stringbuilder;
            String s;
            if(intent != null)
                componentname = intent.getComponent();
            else
                componentname = null;
            stringbuilder = (new StringBuilder()).append("ActivityRecord{").append(Integer.toHexString(System.identityHashCode(this))).append(" token=").append(token).append(" ");
            if(componentname == null)
                s = "no component name";
            else
                s = componentname.toShortString();
            return stringbuilder.append(s).append("}").toString();
        }

        Activity activity;
        ActivityInfo activityInfo;
        boolean autoStopProfiler;
        CompatibilityInfo compatInfo;
        Configuration createdConfig;
        String embeddedID;
        boolean hideForNow;
        int ident;
        Intent intent;
        boolean isForward;
        Activity.NonConfigurationInstances lastNonConfigurationInstances;
        View mPendingRemoveWindow;
        WindowManager mPendingRemoveWindowManager;
        Configuration newConfig;
        ActivityClientRecord nextIdle;
        boolean onlyLocalRequest;
        LoadedApk packageInfo;
        Activity parent;
        boolean paused;
        int pendingConfigChanges;
        List pendingIntents;
        List pendingResults;
        ParcelFileDescriptor profileFd;
        String profileFile;
        boolean startsNotResumed;
        Bundle state;
        boolean stopped;
        IBinder token;
        Window window;

        ActivityClientRecord() {
            parent = null;
            embeddedID = null;
            paused = false;
            stopped = false;
            hideForNow = false;
            nextIdle = null;
        }
    }


    ActivityThread() {
        mNewActivities = null;
        mNumVisibleActivities = 0;
        mInstrumentationAppDir = null;
        mInstrumentationAppLibraryDir = null;
        mInstrumentationAppPackage = null;
        mInstrumentedAppDir = null;
        mInstrumentedAppLibraryDir = null;
        mSystemThread = false;
        mJitEnabled = false;
        mPendingConfiguration = null;
        mGcIdlerScheduled = false;
        mCoreSettings = null;
        mMainThreadConfig = new Configuration();
        mThumbnailWidth = -1;
        mThumbnailHeight = -1;
        mAvailThumbnailBitmap = null;
        mThumbnailCanvas = null;
    }

    private void attach(boolean flag) {
        sThreadLocal.set(this);
        mSystemThread = flag;
        if(!flag) {
            ViewRootImpl.addFirstDrawHandler(new Runnable() {

                public void run() {
                    ensureJitEnabled();
                }

                final ActivityThread this$0;

             {
                this$0 = ActivityThread.this;
                super();
            }
            });
            DdmHandleAppName.setAppName("<pre-initialized>");
            RuntimeInit.setApplicationObject(mAppThread.asBinder());
            IActivityManager iactivitymanager = ActivityManagerNative.getDefault();
            Exception exception;
            ContextImpl contextimpl;
            Application application;
            try {
                iactivitymanager.attachApplication(mAppThread);
            }
            catch(RemoteException remoteexception) { }
        } else {
            DdmHandleAppName.setAppName("system_process");
            try {
                mInstrumentation = new Instrumentation();
                contextimpl = new ContextImpl();
                contextimpl.init(getSystemContext().mPackageInfo, null, this);
                application = Instrumentation.newApplication(android/app/Application, contextimpl);
                mAllApplications.add(application);
                mInitialApplication = application;
                application.onCreate();
            }
            // Misplaced declaration of an exception variable
            catch(Exception exception) {
                throw new RuntimeException((new StringBuilder()).append("Unable to instantiate Application():").append(exception.toString()).toString(), exception);
            }
        }
        ViewRootImpl.addConfigCallback(new ComponentCallbacks2() {

            public void onConfigurationChanged(Configuration configuration) {
                HashMap hashmap = mPackages;
                hashmap;
                JVM INSTR monitorenter ;
                if(applyConfigurationToResourcesLocked(configuration, null) && (mPendingConfiguration == null || mPendingConfiguration.isOtherSeqNewer(configuration))) {
                    mPendingConfiguration = configuration;
                    queueOrSendMessage(118, configuration);
                }
                return;
            }

            public void onLowMemory() {
            }

            public void onTrimMemory(int i) {
            }

            final ActivityThread this$0;

             {
                this$0 = ActivityThread.this;
                super();
            }
        });
    }

    static final void cleanUpPendingRemoveWindows(ActivityClientRecord activityclientrecord) {
        if(activityclientrecord.mPendingRemoveWindow != null) {
            activityclientrecord.mPendingRemoveWindowManager.removeViewImmediate(activityclientrecord.mPendingRemoveWindow);
            IBinder ibinder = activityclientrecord.mPendingRemoveWindow.getWindowToken();
            if(ibinder != null)
                WindowManagerImpl.getDefault().closeAll(ibinder, activityclientrecord.activity.getClass().getName(), "Activity");
        }
        activityclientrecord.mPendingRemoveWindow = null;
        activityclientrecord.mPendingRemoveWindowManager = null;
    }

    private Bitmap createThumbnailBitmap(ActivityClientRecord activityclientrecord) {
        Bitmap bitmap;
        bitmap = mAvailThumbnailBitmap;
        if(bitmap != null)
            break MISSING_BLOCK_LABEL_87;
        int i = mThumbnailWidth;
        Canvas canvas;
        int j;
        if(i < 0) {
            Resources resources = activityclientrecord.activity.getResources();
            j = resources.getDimensionPixelSize(0x1050001);
            mThumbnailHeight = j;
            i = resources.getDimensionPixelSize(0x1050002);
            mThumbnailWidth = i;
        } else {
            j = mThumbnailHeight;
        }
        if(i > 0 && j > 0) {
            bitmap = Bitmap.createBitmap(i, j, THUMBNAIL_FORMAT);
            bitmap.eraseColor(0);
        }
        if(bitmap != null) {
            canvas = mThumbnailCanvas;
            if(canvas == null) {
                canvas = new Canvas();
                mThumbnailCanvas = canvas;
            }
            canvas.setBitmap(bitmap);
            if(!activityclientrecord.activity.onCreateThumbnail(bitmap, canvas)) {
                mAvailThumbnailBitmap = bitmap;
                bitmap = null;
            }
            canvas.setBitmap(null);
        }
        break MISSING_BLOCK_LABEL_230;
        Exception exception;
        exception;
        if(!mInstrumentation.onException(activityclientrecord.activity, exception))
            throw new RuntimeException((new StringBuilder()).append("Unable to create thumbnail of ").append(activityclientrecord.intent.getComponent().toShortString()).append(": ").append(exception.toString()).toString(), exception);
        bitmap = null;
        return bitmap;
    }

    public static ActivityThread currentActivityThread() {
        return (ActivityThread)sThreadLocal.get();
    }

    public static Application currentApplication() {
        ActivityThread activitythread = currentActivityThread();
        Application application;
        if(activitythread != null)
            application = activitythread.mInitialApplication;
        else
            application = null;
        return application;
    }

    public static String currentPackageName() {
        ActivityThread activitythread = currentActivityThread();
        String s;
        if(activitythread != null && activitythread.mBoundApplication != null)
            s = activitythread.mBoundApplication.processName;
        else
            s = null;
        return s;
    }

    private void deliverNewIntents(ActivityClientRecord activityclientrecord, List list) {
        int i = list.size();
        for(int j = 0; j < i; j++) {
            Intent intent = (Intent)list.get(j);
            intent.setExtrasClassLoader(activityclientrecord.activity.getClassLoader());
            activityclientrecord.activity.mFragments.noteStateNotSaved();
            mInstrumentation.callActivityOnNewIntent(activityclientrecord.activity, intent);
        }

    }

    private void deliverResults(ActivityClientRecord activityclientrecord, List list) {
        int i = list.size();
        int j = 0;
        do {
            if(j >= i)
                break;
            ResultInfo resultinfo = (ResultInfo)list.get(j);
            try {
                if(resultinfo.mData != null)
                    resultinfo.mData.setExtrasClassLoader(activityclientrecord.activity.getClassLoader());
                activityclientrecord.activity.dispatchActivityResult(resultinfo.mResultWho, resultinfo.mRequestCode, resultinfo.mResultCode, resultinfo.mData);
            }
            catch(Exception exception) {
                if(!mInstrumentation.onException(activityclientrecord.activity, exception))
                    throw new RuntimeException((new StringBuilder()).append("Failure delivering result ").append(resultinfo).append(" to activity ").append(activityclientrecord.intent.getComponent().toShortString()).append(": ").append(exception.toString()).toString(), exception);
            }
            j++;
        } while(true);
    }

    private native void dumpGraphicsInfo(FileDescriptor filedescriptor);

    public static Intent getIntentBeingBroadcast() {
        return (Intent)sCurrentBroadcastIntent.get();
    }

    private LoadedApk getPackageInfo(ApplicationInfo applicationinfo, CompatibilityInfo compatibilityinfo, ClassLoader classloader, boolean flag, boolean flag1) {
        HashMap hashmap = mPackages;
        hashmap;
        JVM INSTR monitorenter ;
        WeakReference weakreference;
        LoadedApk loadedapk;
        if(flag1)
            weakreference = (WeakReference)mPackages.get(((PackageItemInfo) (applicationinfo)).packageName);
        else
            weakreference = (WeakReference)mResourcePackages.get(((PackageItemInfo) (applicationinfo)).packageName);
        if(weakreference != null)
            loadedapk = (LoadedApk)weakreference.get();
        else
            loadedapk = null;
        if(loadedapk == null || loadedapk.mResources != null && !loadedapk.mResources.getAssets().isUpToDate()) {
            boolean flag2;
            if(flag1 && (4 & applicationinfo.flags) != 0)
                flag2 = true;
            else
                flag2 = false;
            loadedapk = new LoadedApk(this, applicationinfo, compatibilityinfo, this, classloader, flag, flag2);
            if(flag1)
                mPackages.put(((PackageItemInfo) (applicationinfo)).packageName, new WeakReference(loadedapk));
            else
                mResourcePackages.put(((PackageItemInfo) (applicationinfo)).packageName, new WeakReference(loadedapk));
        }
        return loadedapk;
    }

    public static IPackageManager getPackageManager() {
        IPackageManager ipackagemanager;
        if(sPackageManager != null) {
            ipackagemanager = sPackageManager;
        } else {
            sPackageManager = android.content.pm.IPackageManager.Stub.asInterface(ServiceManager.getService("package"));
            ipackagemanager = sPackageManager;
        }
        return ipackagemanager;
    }

    private void handleBindApplication(AppBindData appbinddata) {
        mBoundApplication = appbinddata;
        mConfiguration = new Configuration(appbinddata.config);
        mCompatConfiguration = new Configuration(appbinddata.config);
        mProfiler = new Profiler();
        mProfiler.profileFile = appbinddata.initProfileFile;
        mProfiler.profileFd = appbinddata.initProfileFd;
        mProfiler.autoStopProfiler = appbinddata.initAutoStopProfiler;
        Process.setArgV0(appbinddata.processName);
        DdmHandleAppName.setAppName(appbinddata.processName);
        if(appbinddata.persistent && !ActivityManager.isHighEndGfx(WindowManagerImpl.getDefault().getDefaultDisplay()))
            HardwareRenderer.disable(false);
        if(mProfiler.profileFd != null)
            mProfiler.startProfiling();
        if(appbinddata.appInfo.targetSdkVersion <= 12)
            AsyncTask.setDefaultExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        TimeZone.setDefault(null);
        Locale.setDefault(appbinddata.config.locale);
        applyConfigurationToResourcesLocked(appbinddata.config, appbinddata.compatInfo);
        applyCompatConfiguration();
        appbinddata.info = getPackageInfoNoCheck(appbinddata.appInfo, appbinddata.compatInfo);
        ContextImpl contextimpl = new ContextImpl();
        contextimpl.init(appbinddata.info, null, this);
        File file = contextimpl.getCacheDir();
        System.setProperty("java.io.tmpdir", file.getAbsolutePath());
        setupGraphicsSupport(appbinddata.info, file);
        if((0x81 & appbinddata.appInfo.flags) != 0)
            StrictMode.conditionallyEnableDebugLogging();
        if(appbinddata.appInfo.targetSdkVersion > 9)
            StrictMode.enableDeathOnNetwork();
        if((0x2000 & appbinddata.appInfo.flags) == 0)
            Bitmap.setDefaultDensity(160);
        if(appbinddata.debugMode != 0) {
            Debug.changeDebugPort(8100);
            if(appbinddata.debugMode == 2) {
                Slog.w("ActivityThread", (new StringBuilder()).append("Application ").append(appbinddata.info.getPackageName()).append(" is waiting for the debugger on port 8100...").toString());
                IActivityManager iactivitymanager = ActivityManagerNative.getDefault();
                IBinder ibinder;
                android.os.StrictMode.ThreadPolicy threadpolicy;
                Exception exception;
                Application application;
                Exception exception1;
                Exception exception2;
                List list;
                InstrumentationInfo instrumentationinfo;
                android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
                ApplicationInfo applicationinfo;
                LoadedApk loadedapk;
                ContextImpl contextimpl1;
                Exception exception3;
                File file1;
                InstrumentationInfo instrumentationinfo1;
                IConnectivityManager iconnectivitymanager;
                RemoteException remoteexception;
                try {
                    iactivitymanager.showWaitingForDebugger(mAppThread, true);
                }
                catch(RemoteException remoteexception1) { }
                Debug.waitForDebugger();
                try {
                    iactivitymanager.showWaitingForDebugger(mAppThread, false);
                }
                catch(RemoteException remoteexception2) { }
            } else {
                Slog.w("ActivityThread", (new StringBuilder()).append("Application ").append(appbinddata.info.getPackageName()).append(" can be debugged on port 8100...").toString());
            }
        }
        if(appbinddata.enableOpenGlTrace)
            GLUtils.enableTracing();
        ibinder = ServiceManager.getService("connectivity");
        if(ibinder != null) {
            iconnectivitymanager = android.net.IConnectivityManager.Stub.asInterface(ibinder);
            try {
                Proxy.setHttpProxySystemProperty(iconnectivitymanager.getProxy());
            }
            // Misplaced declaration of an exception variable
            catch(RemoteException remoteexception) { }
        }
        if(appbinddata.instrumentationName == null) goto _L2; else goto _L1
_L1:
        instrumentationinfo = null;
        instrumentationinfo1 = contextimpl.getPackageManager().getInstrumentationInfo(appbinddata.instrumentationName, 0);
        instrumentationinfo = instrumentationinfo1;
_L7:
        if(instrumentationinfo == null)
            throw new RuntimeException((new StringBuilder()).append("Unable to find instrumentation info for: ").append(appbinddata.instrumentationName).toString());
        mInstrumentationAppDir = instrumentationinfo.sourceDir;
        mInstrumentationAppLibraryDir = instrumentationinfo.nativeLibraryDir;
        mInstrumentationAppPackage = ((PackageItemInfo) (instrumentationinfo)).packageName;
        mInstrumentedAppDir = appbinddata.info.getAppDir();
        mInstrumentedAppLibraryDir = appbinddata.info.getLibDir();
        applicationinfo = new ApplicationInfo();
        applicationinfo.packageName = ((PackageItemInfo) (instrumentationinfo)).packageName;
        applicationinfo.sourceDir = instrumentationinfo.sourceDir;
        applicationinfo.publicSourceDir = instrumentationinfo.publicSourceDir;
        applicationinfo.dataDir = instrumentationinfo.dataDir;
        applicationinfo.nativeLibraryDir = instrumentationinfo.nativeLibraryDir;
        loadedapk = getPackageInfo(applicationinfo, appbinddata.compatInfo, contextimpl.getClassLoader(), false, true);
        contextimpl1 = new ContextImpl();
        contextimpl1.init(loadedapk, null, this);
        try {
            mInstrumentation = (Instrumentation)contextimpl1.getClassLoader().loadClass(appbinddata.instrumentationName.getClassName()).newInstance();
        }
        // Misplaced declaration of an exception variable
        catch(Exception exception3) {
            throw new RuntimeException((new StringBuilder()).append("Unable to instantiate instrumentation ").append(appbinddata.instrumentationName).append(": ").append(exception3.toString()).toString(), exception3);
        }
        mInstrumentation.init(this, contextimpl1, contextimpl, new ComponentName(((PackageItemInfo) (instrumentationinfo)).packageName, ((PackageItemInfo) (instrumentationinfo)).name), appbinddata.instrumentationWatcher);
        if(mProfiler.profileFile != null && !instrumentationinfo.handleProfiling && mProfiler.profileFd == null) {
            mProfiler.handlingProfiling = true;
            file1 = new File(mProfiler.profileFile);
            file1.getParentFile().mkdirs();
            Debug.startMethodTracing(file1.toString(), 0x800000);
        }
_L3:
        if((0x100000 & appbinddata.appInfo.flags) != 0)
            VMRuntime.getRuntime().clearGrowthLimit();
        threadpolicy = StrictMode.allowThreadDiskWrites();
        application = appbinddata.info.makeApplication(appbinddata.restrictedBackupMode, null);
        mInitialApplication = application;
        if(!appbinddata.restrictedBackupMode) {
            list = appbinddata.providers;
            if(list != null) {
                installContentProviders(application, list);
                mH.sendEmptyMessageDelayed(132, 10000L);
            }
        }
        mInstrumentation.onCreate(appbinddata.instrumentationArgs);
        mInstrumentation.callApplicationOnCreate(application);
_L5:
        StrictMode.setThreadPolicy(threadpolicy);
        return;
_L2:
        mInstrumentation = new Instrumentation();
          goto _L3
        exception1;
        throw new RuntimeException((new StringBuilder()).append("Exception thrown in onCreate() of ").append(appbinddata.instrumentationName).append(": ").append(exception1.toString()).toString(), exception1);
        exception;
        StrictMode.setThreadPolicy(threadpolicy);
        throw exception;
        exception2;
        if(mInstrumentation.onException(application, exception2)) goto _L5; else goto _L4
_L4:
        throw new RuntimeException((new StringBuilder()).append("Unable to create application ").append(application.getClass().getName()).append(": ").append(exception2.toString()).toString(), exception2);
        namenotfoundexception;
        if(true) goto _L7; else goto _L6
_L6:
    }

    private void handleBindService(BindServiceData bindservicedata) {
        Service service;
        service = (Service)mServices.get(bindservicedata.token);
        if(service == null)
            break MISSING_BLOCK_LABEL_171;
        bindservicedata.intent.setExtrasClassLoader(service.getClassLoader());
        try {
            if(!bindservicedata.rebind) {
                IBinder ibinder = service.onBind(bindservicedata.intent);
                ActivityManagerNative.getDefault().publishService(bindservicedata.token, bindservicedata.intent, ibinder);
            } else {
                service.onRebind(bindservicedata.intent);
                ActivityManagerNative.getDefault().serviceDoneExecuting(bindservicedata.token, 0, 0, 0);
            }
            ensureJitEnabled();
        }
        catch(RemoteException remoteexception) { }
        break MISSING_BLOCK_LABEL_171;
        Exception exception;
        exception;
        if(!mInstrumentation.onException(service, exception))
            throw new RuntimeException((new StringBuilder()).append("Unable to bind to service ").append(service).append(" with ").append(bindservicedata.intent).append(": ").append(exception.toString()).toString(), exception);
    }

    private void handleCreateBackupAgent(CreateBackupAgentData createbackupagentdata) {
        LoadedApk loadedapk;
        String s;
        unscheduleGcIdler();
        loadedapk = getPackageInfoNoCheck(createbackupagentdata.appInfo, createbackupagentdata.compatInfo);
        s = loadedapk.mPackageName;
        if(mBackupAgents.get(s) == null) goto _L2; else goto _L1
_L1:
        Slog.d("ActivityThread", (new StringBuilder()).append("BackupAgent   for ").append(s).append(" already exists").toString());
_L4:
        return;
_L2:
        String s1;
        IBinder ibinder;
        s1 = createbackupagentdata.appInfo.backupAgentName;
        if(s1 == null && (createbackupagentdata.backupMode == 1 || createbackupagentdata.backupMode == 3))
            s1 = "android.app.backup.FullBackupAgent";
        ibinder = null;
        BackupAgent backupagent = (BackupAgent)loadedapk.getClassLoader().loadClass(s1).newInstance();
        ContextImpl contextimpl = new ContextImpl();
        contextimpl.init(loadedapk, null, this);
        contextimpl.setOuterContext(backupagent);
        backupagent.attach(contextimpl);
        backupagent.onCreate();
        ibinder = backupagent.onBind();
        mBackupAgents.put(s, backupagent);
_L5:
        Exception exception;
        try {
            ActivityManagerNative.getDefault().backupAgentCreated(s, ibinder);
        }
        catch(RemoteException remoteexception) { }
        catch(Exception exception1) {
            throw new RuntimeException((new StringBuilder()).append("Unable to create BackupAgent ").append(s1).append(": ").append(exception1.toString()).toString(), exception1);
        }
        if(true) goto _L4; else goto _L3
_L3:
        exception;
        Slog.e("ActivityThread", (new StringBuilder()).append("Agent threw during creation: ").append(exception).toString());
        if(createbackupagentdata.backupMode != 2 && createbackupagentdata.backupMode != 3)
            throw exception;
          goto _L5
    }

    private void handleCreateService(CreateServiceData createservicedata) {
        Service service;
        unscheduleGcIdler();
        LoadedApk loadedapk = getPackageInfoNoCheck(((ComponentInfo) (createservicedata.info)).applicationInfo, createservicedata.compatInfo);
        service = null;
        ContextImpl contextimpl;
        Application application;
        try {
            service = (Service)loadedapk.getClassLoader().loadClass(((PackageItemInfo) (createservicedata.info)).name).newInstance();
        }
        catch(Exception exception) {
            if(!mInstrumentation.onException(null, exception))
                throw new RuntimeException((new StringBuilder()).append("Unable to instantiate service ").append(((PackageItemInfo) (createservicedata.info)).name).append(": ").append(exception.toString()).toString(), exception);
        }
        contextimpl = new ContextImpl();
        contextimpl.init(loadedapk, null, this);
        application = loadedapk.makeApplication(false, mInstrumentation);
        contextimpl.setOuterContext(service);
        service.attach(contextimpl, this, ((PackageItemInfo) (createservicedata.info)).name, createservicedata.token, application, ActivityManagerNative.getDefault());
        service.onCreate();
        mServices.put(createservicedata.token, service);
        ActivityManagerNative.getDefault().serviceDoneExecuting(createservicedata.token, 0, 0, 0);
_L2:
        return;
        Exception exception1;
        exception1;
        if(!mInstrumentation.onException(service, exception1))
            throw new RuntimeException((new StringBuilder()).append("Unable to create service ").append(((PackageItemInfo) (createservicedata.info)).name).append(": ").append(exception1.toString()).toString(), exception1);
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private void handleDestroyActivity(IBinder ibinder, boolean flag, int i, boolean flag1) {
        ActivityClientRecord activityclientrecord = performDestroyActivity(ibinder, flag, i, flag1);
        if(activityclientrecord != null) {
            cleanUpPendingRemoveWindows(activityclientrecord);
            WindowManager windowmanager = activityclientrecord.activity.getWindowManager();
            View view = activityclientrecord.activity.mDecor;
            if(view != null) {
                if(activityclientrecord.activity.mVisibleFromServer)
                    mNumVisibleActivities = -1 + mNumVisibleActivities;
                IBinder ibinder1 = view.getWindowToken();
                Context context;
                if(activityclientrecord.activity.mWindowAdded)
                    if(activityclientrecord.onlyLocalRequest) {
                        activityclientrecord.mPendingRemoveWindow = view;
                        activityclientrecord.mPendingRemoveWindowManager = windowmanager;
                    } else {
                        windowmanager.removeViewImmediate(view);
                    }
                if(ibinder1 != null && activityclientrecord.mPendingRemoveWindow == null)
                    WindowManagerImpl.getDefault().closeAll(ibinder1, activityclientrecord.activity.getClass().getName(), "Activity");
                activityclientrecord.activity.mDecor = null;
            }
            if(activityclientrecord.mPendingRemoveWindow == null)
                WindowManagerImpl.getDefault().closeAll(ibinder, activityclientrecord.activity.getClass().getName(), "Activity");
            context = activityclientrecord.activity.getBaseContext();
            if(context instanceof ContextImpl)
                ((ContextImpl)context).scheduleFinalCleanup(activityclientrecord.activity.getClass().getName(), "Activity");
        }
        if(!flag)
            break MISSING_BLOCK_LABEL_234;
        ActivityManagerNative.getDefault().activityDestroyed(ibinder);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private void handleDestroyBackupAgent(CreateBackupAgentData createbackupagentdata) {
        String s = getPackageInfoNoCheck(createbackupagentdata.appInfo, createbackupagentdata.compatInfo).mPackageName;
        BackupAgent backupagent = (BackupAgent)mBackupAgents.get(s);
        if(backupagent != null) {
            try {
                backupagent.onDestroy();
            }
            catch(Exception exception) {
                Slog.w("ActivityThread", (new StringBuilder()).append("Exception thrown in onDestroy by backup agent of ").append(createbackupagentdata.appInfo).toString());
                exception.printStackTrace();
            }
            mBackupAgents.remove(s);
        } else {
            Slog.w("ActivityThread", (new StringBuilder()).append("Attempt to destroy unknown backup agent ").append(createbackupagentdata).toString());
        }
    }

    private void handleDumpActivity(DumpComponentInfo dumpcomponentinfo) {
        android.os.StrictMode.ThreadPolicy threadpolicy = StrictMode.allowThreadDiskWrites();
        ActivityClientRecord activityclientrecord = (ActivityClientRecord)mActivities.get(dumpcomponentinfo.token);
        if(activityclientrecord != null && activityclientrecord.activity != null) {
            PrintWriter printwriter = new PrintWriter(new FileOutputStream(dumpcomponentinfo.fd.getFileDescriptor()));
            activityclientrecord.activity.dump(dumpcomponentinfo.prefix, dumpcomponentinfo.fd.getFileDescriptor(), printwriter, dumpcomponentinfo.args);
            printwriter.flush();
        }
        IoUtils.closeQuietly(dumpcomponentinfo.fd);
        StrictMode.setThreadPolicy(threadpolicy);
        return;
        Exception exception;
        exception;
        IoUtils.closeQuietly(dumpcomponentinfo.fd);
        StrictMode.setThreadPolicy(threadpolicy);
        throw exception;
    }

    static final void handleDumpHeap(boolean flag, DumpHeapData dumpheapdata) {
        if(!flag) goto _L2; else goto _L1
_L1:
        Debug.dumpHprofData(dumpheapdata.path, dumpheapdata.fd.getFileDescriptor());
        dumpheapdata.fd.close();
_L3:
        return;
        IOException ioexception1;
        ioexception1;
        Slog.w("ActivityThread", (new StringBuilder()).append("Managed heap dump failed on path ").append(dumpheapdata.path).append(" -- can the process access this path?").toString());
        dumpheapdata.fd.close();
          goto _L3
        IOException ioexception2;
        ioexception2;
        String s;
        String s1;
        s = "ActivityThread";
        s1 = "Failure closing profile fd";
_L4:
        Slog.w(s, s1, ioexception2);
          goto _L3
        Exception exception;
        exception;
        try {
            dumpheapdata.fd.close();
        }
        catch(IOException ioexception) {
            Slog.w("ActivityThread", "Failure closing profile fd", ioexception);
        }
        throw exception;
_L2:
        Debug.dumpNativeHeap(dumpheapdata.fd.getFileDescriptor());
          goto _L3
        ioexception2;
        s = "ActivityThread";
        s1 = "Failure closing profile fd";
          goto _L4
    }

    private void handleDumpProvider(DumpComponentInfo dumpcomponentinfo) {
        android.os.StrictMode.ThreadPolicy threadpolicy = StrictMode.allowThreadDiskWrites();
        ProviderClientRecord providerclientrecord = (ProviderClientRecord)mLocalProviders.get(dumpcomponentinfo.token);
        if(providerclientrecord != null && providerclientrecord.mLocalProvider != null) {
            PrintWriter printwriter = new PrintWriter(new FileOutputStream(dumpcomponentinfo.fd.getFileDescriptor()));
            providerclientrecord.mLocalProvider.dump(dumpcomponentinfo.fd.getFileDescriptor(), printwriter, dumpcomponentinfo.args);
            printwriter.flush();
        }
        IoUtils.closeQuietly(dumpcomponentinfo.fd);
        StrictMode.setThreadPolicy(threadpolicy);
        return;
        Exception exception;
        exception;
        IoUtils.closeQuietly(dumpcomponentinfo.fd);
        StrictMode.setThreadPolicy(threadpolicy);
        throw exception;
    }

    private void handleDumpService(DumpComponentInfo dumpcomponentinfo) {
        android.os.StrictMode.ThreadPolicy threadpolicy = StrictMode.allowThreadDiskWrites();
        Service service = (Service)mServices.get(dumpcomponentinfo.token);
        if(service != null) {
            PrintWriter printwriter = new PrintWriter(new FileOutputStream(dumpcomponentinfo.fd.getFileDescriptor()));
            service.dump(dumpcomponentinfo.fd.getFileDescriptor(), printwriter, dumpcomponentinfo.args);
            printwriter.flush();
        }
        IoUtils.closeQuietly(dumpcomponentinfo.fd);
        StrictMode.setThreadPolicy(threadpolicy);
        return;
        Exception exception;
        exception;
        IoUtils.closeQuietly(dumpcomponentinfo.fd);
        StrictMode.setThreadPolicy(threadpolicy);
        throw exception;
    }

    private void handleLaunchActivity(ActivityClientRecord activityclientrecord, Intent intent) {
        unscheduleGcIdler();
        if(activityclientrecord.profileFd != null) {
            mProfiler.setProfiler(activityclientrecord.profileFile, activityclientrecord.profileFd);
            mProfiler.startProfiling();
            mProfiler.autoStopProfiler = activityclientrecord.autoStopProfiler;
        }
        handleConfigurationChanged(null, null);
        if(performLaunchActivity(activityclientrecord, intent) != null) {
            activityclientrecord.createdConfig = new Configuration(mConfiguration);
            Bundle bundle = activityclientrecord.state;
            handleResumeActivity(activityclientrecord.token, false, activityclientrecord.isForward);
            if(!activityclientrecord.activity.mFinished && activityclientrecord.startsNotResumed) {
                try {
                    activityclientrecord.activity.mCalled = false;
                    mInstrumentation.callActivityOnPause(activityclientrecord.activity);
                    if(activityclientrecord.isPreHoneycomb())
                        activityclientrecord.state = bundle;
                    if(!activityclientrecord.activity.mCalled)
                        throw new SuperNotCalledException((new StringBuilder()).append("Activity ").append(activityclientrecord.intent.getComponent().toShortString()).append(" did not call through to super.onPause()").toString());
                }
                catch(SuperNotCalledException supernotcalledexception) {
                    throw supernotcalledexception;
                }
                catch(Exception exception) {
                    if(!mInstrumentation.onException(activityclientrecord.activity, exception))
                        throw new RuntimeException((new StringBuilder()).append("Unable to pause activity ").append(activityclientrecord.intent.getComponent().toShortString()).append(": ").append(exception.toString()).toString(), exception);
                }
                activityclientrecord.paused = true;
            }
        } else {
            try {
                ActivityManagerNative.getDefault().finishActivity(activityclientrecord.token, 0, null);
            }
            catch(RemoteException remoteexception) { }
        }
    }

    private void handleNewIntent(NewIntentData newintentdata) {
        performNewIntents(newintentdata.token, newintentdata.intents);
    }

    private void handlePauseActivity(IBinder ibinder, boolean flag, boolean flag1, int i) {
        ActivityClientRecord activityclientrecord = (ActivityClientRecord)mActivities.get(ibinder);
        if(activityclientrecord == null)
            break MISSING_BLOCK_LABEL_80;
        if(flag1)
            performUserLeavingActivity(activityclientrecord);
        Activity activity = activityclientrecord.activity;
        activity.mConfigChangeFlags = i | activity.mConfigChangeFlags;
        performPauseActivity(ibinder, flag, activityclientrecord.isPreHoneycomb());
        if(activityclientrecord.isPreHoneycomb())
            QueuedWork.waitToFinish();
        ActivityManagerNative.getDefault().activityPaused(ibinder);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private void handleReceiver(ReceiverData receiverdata) {
        String s;
        IActivityManager iactivitymanager;
        BroadcastReceiver broadcastreceiver;
        ThreadLocal threadlocal;
        unscheduleGcIdler();
        s = receiverdata.intent.getComponent().getClassName();
        LoadedApk loadedapk = getPackageInfoNoCheck(((ComponentInfo) (receiverdata.info)).applicationInfo, receiverdata.compatInfo);
        iactivitymanager = ActivityManagerNative.getDefault();
        ContextImpl contextimpl;
        try {
            ClassLoader classloader = loadedapk.getClassLoader();
            receiverdata.intent.setExtrasClassLoader(classloader);
            receiverdata.setExtrasClassLoader(classloader);
            broadcastreceiver = (BroadcastReceiver)classloader.loadClass(s).newInstance();
        }
        catch(Exception exception) {
            receiverdata.sendFinished(iactivitymanager);
            throw new RuntimeException((new StringBuilder()).append("Unable to instantiate receiver ").append(s).append(": ").append(exception.toString()).toString(), exception);
        }
        contextimpl = (ContextImpl)loadedapk.makeApplication(false, mInstrumentation).getBaseContext();
        sCurrentBroadcastIntent.set(receiverdata.intent);
        broadcastreceiver.setPendingResult(receiverdata);
        broadcastreceiver.onReceive(contextimpl.getReceiverRestrictedContext(), receiverdata.intent);
        threadlocal = sCurrentBroadcastIntent;
_L2:
        threadlocal.set(null);
        if(broadcastreceiver.getPendingResult() != null)
            receiverdata.finish();
        return;
        Exception exception2;
        exception2;
        receiverdata.sendFinished(iactivitymanager);
        if(!mInstrumentation.onException(broadcastreceiver, exception2))
            throw new RuntimeException((new StringBuilder()).append("Unable to start receiver ").append(s).append(": ").append(exception2.toString()).toString(), exception2);
        break MISSING_BLOCK_LABEL_272;
        Exception exception1;
        exception1;
        sCurrentBroadcastIntent.set(null);
        throw exception1;
        threadlocal = sCurrentBroadcastIntent;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private void handleRelaunchActivity(ActivityClientRecord activityclientrecord) {
        Configuration configuration;
        int i;
        unscheduleGcIdler();
        configuration = null;
        i = 0;
        HashMap hashmap = mPackages;
        hashmap;
        JVM INSTR monitorenter ;
        int j;
        IBinder ibinder;
        ActivityClientRecord activityclientrecord1;
        j = mRelaunchingActivities.size();
        ibinder = activityclientrecord.token;
        activityclientrecord1 = null;
        Exception exception;
        ActivityClientRecord activityclientrecord2;
        Activity activity;
        Intent intent;
        for(int k = 0; k < j; k++) {
            ActivityClientRecord activityclientrecord3 = (ActivityClientRecord)mRelaunchingActivities.get(k);
            if(activityclientrecord3.token == ibinder) {
                activityclientrecord1 = activityclientrecord3;
                i |= activityclientrecord1.pendingConfigChanges;
                mRelaunchingActivities.remove(k);
                k--;
                j--;
            }
            break MISSING_BLOCK_LABEL_520;
        }

        if(activityclientrecord1 == null)
            break MISSING_BLOCK_LABEL_526;
        if(mPendingConfiguration != null) {
            configuration = mPendingConfiguration;
            mPendingConfiguration = null;
        }
        if(activityclientrecord1.createdConfig != null && (mConfiguration == null || activityclientrecord1.createdConfig.isOtherSeqNewer(mConfiguration) && mConfiguration.diff(activityclientrecord1.createdConfig) != 0) && (configuration == null || activityclientrecord1.createdConfig.isOtherSeqNewer(configuration)))
            configuration = activityclientrecord1.createdConfig;
        if(configuration != null)
            handleConfigurationChanged(configuration, null);
        activityclientrecord2 = (ActivityClientRecord)mActivities.get(activityclientrecord1.token);
        if(activityclientrecord2 != null) {
            activity = activityclientrecord2.activity;
            activity.mConfigChangeFlags = i | activity.mConfigChangeFlags;
            activityclientrecord2.onlyLocalRequest = activityclientrecord1.onlyLocalRequest;
            intent = activityclientrecord2.activity.mIntent;
            activityclientrecord2.activity.mChangingConfigurations = true;
            if(!activityclientrecord2.paused)
                performPauseActivity(activityclientrecord2.token, false, activityclientrecord2.isPreHoneycomb());
            if(activityclientrecord2.state == null && !activityclientrecord2.stopped && !activityclientrecord2.isPreHoneycomb()) {
                activityclientrecord2.state = new Bundle();
                activityclientrecord2.state.setAllowFds(false);
                mInstrumentation.callActivityOnSaveInstanceState(activityclientrecord2.activity, activityclientrecord2.state);
            }
            handleDestroyActivity(activityclientrecord2.token, false, i, true);
            activityclientrecord2.activity = null;
            activityclientrecord2.window = null;
            activityclientrecord2.hideForNow = false;
            activityclientrecord2.nextIdle = null;
            if(activityclientrecord1.pendingResults != null)
                if(activityclientrecord2.pendingResults == null)
                    activityclientrecord2.pendingResults = activityclientrecord1.pendingResults;
                else
                    activityclientrecord2.pendingResults.addAll(activityclientrecord1.pendingResults);
            if(activityclientrecord1.pendingIntents != null)
                if(activityclientrecord2.pendingIntents == null)
                    activityclientrecord2.pendingIntents = activityclientrecord1.pendingIntents;
                else
                    activityclientrecord2.pendingIntents.addAll(activityclientrecord1.pendingIntents);
            activityclientrecord2.startsNotResumed = activityclientrecord1.startsNotResumed;
            handleLaunchActivity(activityclientrecord2, intent);
        }
        break MISSING_BLOCK_LABEL_526;
        exception;
        hashmap;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void handleRequestThumbnail(IBinder ibinder) {
        ActivityClientRecord activityclientrecord;
        Bitmap bitmap;
        CharSequence charsequence;
        activityclientrecord = (ActivityClientRecord)mActivities.get(ibinder);
        bitmap = createThumbnailBitmap(activityclientrecord);
        charsequence = null;
        CharSequence charsequence1 = activityclientrecord.activity.onCreateDescription();
        charsequence = charsequence1;
_L1:
        ActivityManagerNative.getDefault().reportThumbnail(ibinder, bitmap, charsequence);
_L2:
        return;
        Exception exception;
        exception;
        if(!mInstrumentation.onException(activityclientrecord.activity, exception))
            throw new RuntimeException((new StringBuilder()).append("Unable to create description of activity ").append(activityclientrecord.intent.getComponent().toShortString()).append(": ").append(exception.toString()).toString(), exception);
          goto _L1
        RemoteException remoteexception;
        remoteexception;
          goto _L2
    }

    private void handleSendResult(ResultData resultdata) {
        ActivityClientRecord activityclientrecord = (ActivityClientRecord)mActivities.get(resultdata.token);
        if(activityclientrecord != null) {
            boolean flag;
            if(!activityclientrecord.paused)
                flag = true;
            else
                flag = false;
            if(!activityclientrecord.activity.mFinished && activityclientrecord.activity.mDecor != null && activityclientrecord.hideForNow && flag)
                updateVisibility(activityclientrecord, true);
            if(flag)
                try {
                    activityclientrecord.activity.mCalled = false;
                    activityclientrecord.activity.mTemporaryPause = true;
                    mInstrumentation.callActivityOnPause(activityclientrecord.activity);
                    if(!activityclientrecord.activity.mCalled)
                        throw new SuperNotCalledException((new StringBuilder()).append("Activity ").append(activityclientrecord.intent.getComponent().toShortString()).append(" did not call through to super.onPause()").toString());
                }
                catch(SuperNotCalledException supernotcalledexception) {
                    throw supernotcalledexception;
                }
                catch(Exception exception) {
                    if(!mInstrumentation.onException(activityclientrecord.activity, exception))
                        throw new RuntimeException((new StringBuilder()).append("Unable to pause activity ").append(activityclientrecord.intent.getComponent().toShortString()).append(": ").append(exception.toString()).toString(), exception);
                }
            deliverResults(activityclientrecord, resultdata.results);
            if(flag) {
                activityclientrecord.activity.performResume();
                activityclientrecord.activity.mTemporaryPause = false;
            }
        }
    }

    private void handleServiceArgs(ServiceArgsData serviceargsdata) {
        Service service;
        service = (Service)mServices.get(serviceargsdata.token);
        if(service == null)
            break MISSING_BLOCK_LABEL_180;
        if(serviceargsdata.args != null)
            serviceargsdata.args.setExtrasClassLoader(service.getClassLoader());
        if(serviceargsdata.taskRemoved) goto _L2; else goto _L1
_L1:
        int i = service.onStartCommand(serviceargsdata.args, serviceargsdata.flags, serviceargsdata.startId);
_L3:
        QueuedWork.waitToFinish();
        Exception exception;
        try {
            ActivityManagerNative.getDefault().serviceDoneExecuting(serviceargsdata.token, 1, serviceargsdata.startId, i);
        }
        catch(RemoteException remoteexception) { }
        ensureJitEnabled();
        break MISSING_BLOCK_LABEL_180;
_L2:
        service.onTaskRemoved(serviceargsdata.args);
        i = 1000;
          goto _L3
        exception;
        if(!mInstrumentation.onException(service, exception))
            throw new RuntimeException((new StringBuilder()).append("Unable to start service ").append(service).append(" with ").append(serviceargsdata.args).append(": ").append(exception.toString()).toString(), exception);
    }

    private void handleSetCoreSettings(Bundle bundle) {
        HashMap hashmap = mPackages;
        hashmap;
        JVM INSTR monitorenter ;
        mCoreSettings = bundle;
        return;
    }

    private void handleSleeping(IBinder ibinder, boolean flag) {
        ActivityClientRecord activityclientrecord = (ActivityClientRecord)mActivities.get(ibinder);
        if(activityclientrecord != null) goto _L2; else goto _L1
_L1:
        Log.w("ActivityThread", (new StringBuilder()).append("handleSleeping: no activity for token ").append(ibinder).toString());
_L8:
        return;
_L2:
        if(!flag)
            break MISSING_BLOCK_LABEL_174;
        if(activityclientrecord.stopped || activityclientrecord.isPreHoneycomb()) goto _L4; else goto _L3
_L3:
        activityclientrecord.activity.performStop();
_L6:
        activityclientrecord.stopped = true;
_L4:
        if(!activityclientrecord.isPreHoneycomb())
            QueuedWork.waitToFinish();
        try {
            ActivityManagerNative.getDefault().activitySlept(activityclientrecord.token);
        }
        catch(RemoteException remoteexception) { }
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        if(mInstrumentation.onException(activityclientrecord.activity, exception)) goto _L6; else goto _L5
_L5:
        throw new RuntimeException((new StringBuilder()).append("Unable to stop activity ").append(activityclientrecord.intent.getComponent().toShortString()).append(": ").append(exception.toString()).toString(), exception);
        if(activityclientrecord.stopped && activityclientrecord.activity.mVisibleFromServer) {
            activityclientrecord.activity.performRestart();
            activityclientrecord.stopped = false;
        }
        if(true) goto _L8; else goto _L7
_L7:
    }

    private void handleStopActivity(IBinder ibinder, boolean flag, int i) {
        ActivityClientRecord activityclientrecord = (ActivityClientRecord)mActivities.get(ibinder);
        Activity activity = activityclientrecord.activity;
        activity.mConfigChangeFlags = i | activity.mConfigChangeFlags;
        StopInfo stopinfo = new StopInfo();
        performStopActivityInner(activityclientrecord, stopinfo, flag, true);
        updateVisibility(activityclientrecord, flag);
        if(!activityclientrecord.isPreHoneycomb())
            QueuedWork.waitToFinish();
        stopinfo.activity = activityclientrecord;
        stopinfo.state = activityclientrecord.state;
        mH.post(stopinfo);
    }

    private void handleStopService(IBinder ibinder) {
        Service service;
        service = (Service)mServices.remove(ibinder);
        if(service == null)
            break MISSING_BLOCK_LABEL_68;
        service.onDestroy();
        Context context = service.getBaseContext();
        if(context instanceof ContextImpl) {
            String s = service.getClassName();
            ((ContextImpl)context).scheduleFinalCleanup(s, "Service");
        }
        QueuedWork.waitToFinish();
        ActivityManagerNative.getDefault().serviceDoneExecuting(ibinder, 0, 0, 0);
_L2:
        return;
        Exception exception;
        exception;
        if(!mInstrumentation.onException(service, exception))
            throw new RuntimeException((new StringBuilder()).append("Unable to stop service ").append(service).append(": ").append(exception.toString()).toString(), exception);
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private void handleUnbindService(BindServiceData bindservicedata) {
        Service service;
        service = (Service)mServices.get(bindservicedata.token);
        if(service == null)
            break MISSING_BLOCK_LABEL_157;
        boolean flag;
        bindservicedata.intent.setExtrasClassLoader(service.getClassLoader());
        flag = service.onUnbind(bindservicedata.intent);
        if(!flag)
            break MISSING_BLOCK_LABEL_66;
        ActivityManagerNative.getDefault().unbindFinished(bindservicedata.token, bindservicedata.intent, flag);
        break MISSING_BLOCK_LABEL_157;
        ActivityManagerNative.getDefault().serviceDoneExecuting(bindservicedata.token, 0, 0, 0);
        break MISSING_BLOCK_LABEL_157;
        RemoteException remoteexception;
        remoteexception;
        break MISSING_BLOCK_LABEL_157;
        Exception exception;
        exception;
        if(!mInstrumentation.onException(service, exception))
            throw new RuntimeException((new StringBuilder()).append("Unable to unbind to service ").append(service).append(" with ").append(bindservicedata.intent).append(": ").append(exception.toString()).toString(), exception);
    }

    private void handleUpdatePackageCompatibilityInfo(UpdateCompatibilityData updatecompatibilitydata) {
        LoadedApk loadedapk = peekPackageInfo(updatecompatibilitydata.pkg, false);
        if(loadedapk != null)
            loadedapk.mCompatibilityInfo.set(updatecompatibilitydata.info);
        LoadedApk loadedapk1 = peekPackageInfo(updatecompatibilitydata.pkg, true);
        if(loadedapk1 != null)
            loadedapk1.mCompatibilityInfo.set(updatecompatibilitydata.info);
        handleConfigurationChanged(mConfiguration, updatecompatibilitydata.info);
        WindowManagerImpl.getDefault().reportNewConfiguration(mConfiguration);
    }

    private void handleWindowVisibility(IBinder ibinder, boolean flag) {
        ActivityClientRecord activityclientrecord = (ActivityClientRecord)mActivities.get(ibinder);
        if(activityclientrecord != null) goto _L2; else goto _L1
_L1:
        Log.w("ActivityThread", (new StringBuilder()).append("handleWindowVisibility: no activity for token ").append(ibinder).toString());
_L4:
        return;
_L2:
        if(flag || activityclientrecord.stopped)
            break; /* Loop/switch isn't completed */
        performStopActivityInner(activityclientrecord, null, flag, false);
_L6:
        if(activityclientrecord.activity.mDecor != null)
            updateVisibility(activityclientrecord, flag);
        if(true) goto _L4; else goto _L3
_L3:
        if(!flag || !activityclientrecord.stopped) goto _L6; else goto _L5
_L5:
        unscheduleGcIdler();
        activityclientrecord.activity.performRestart();
        activityclientrecord.stopped = false;
          goto _L6
    }

    private final void incProviderRefLocked(ProviderRefCount providerrefcount, boolean flag) {
        if(!flag) goto _L2; else goto _L1
_L1:
        providerrefcount.stableCount = 1 + providerrefcount.stableCount;
        if(providerrefcount.stableCount != 1)
            break MISSING_BLOCK_LABEL_68;
        byte byte0;
        if(providerrefcount.removePending) {
            byte0 = -1;
            providerrefcount.removePending = false;
            mH.removeMessages(131, providerrefcount);
        } else {
            byte0 = 0;
        }
        ActivityManagerNative.getDefault().refContentProvider(providerrefcount.holder.connection, 1, byte0);
_L4:
        return;
_L2:
        providerrefcount.unstableCount = 1 + providerrefcount.unstableCount;
        if(providerrefcount.unstableCount == 1)
            if(providerrefcount.removePending) {
                providerrefcount.removePending = false;
                mH.removeMessages(131, providerrefcount);
            } else {
                try {
                    ActivityManagerNative.getDefault().refContentProvider(providerrefcount.holder.connection, 0, 1);
                }
                catch(RemoteException remoteexception) { }
            }
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception1;
        remoteexception1;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void installContentProviders(Context context, List list) {
        ArrayList arraylist;
        arraylist = new ArrayList();
        Iterator iterator = list.iterator();
        do {
            if(!iterator.hasNext())
                break;
            ProviderInfo providerinfo = (ProviderInfo)iterator.next();
            StringBuilder stringbuilder = new StringBuilder(128);
            stringbuilder.append("Pub ");
            stringbuilder.append(providerinfo.authority);
            stringbuilder.append(": ");
            stringbuilder.append(((PackageItemInfo) (providerinfo)).name);
            Log.i("ActivityThread", stringbuilder.toString());
            IActivityManager.ContentProviderHolder contentproviderholder = installProvider(context, null, providerinfo, false, true, true);
            if(contentproviderholder != null) {
                contentproviderholder.noReleaseNeeded = true;
                arraylist.add(contentproviderholder);
            }
        } while(true);
        ActivityManagerNative.getDefault().publishContentProviders(getApplicationThread(), arraylist);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private IActivityManager.ContentProviderHolder installProvider(Context context, IActivityManager.ContentProviderHolder contentproviderholder, ProviderInfo providerinfo, boolean flag, boolean flag1, boolean flag2) {
        ContentProvider contentprovider = null;
        if(contentproviderholder != null && contentproviderholder.provider != null) goto _L2; else goto _L1
_L1:
        Object obj;
        ApplicationInfo applicationinfo;
        IActivityManager.ContentProviderHolder contentproviderholder1;
        if(flag)
            Slog.d("ActivityThread", (new StringBuilder()).append("Loading provider ").append(providerinfo.authority).append(": ").append(((PackageItemInfo) (providerinfo)).name).toString());
        obj = null;
        applicationinfo = ((ComponentInfo) (providerinfo)).applicationInfo;
        if(context.getPackageName().equals(((PackageItemInfo) (applicationinfo)).packageName)) {
            obj = context;
        } else {
label0:
            {
                if(mInitialApplication == null || !mInitialApplication.getPackageName().equals(((PackageItemInfo) (applicationinfo)).packageName))
                    break label0;
                obj = mInitialApplication;
            }
        }
_L5:
        if(obj != null) goto _L4; else goto _L3
_L3:
        Slog.w("ActivityThread", (new StringBuilder()).append("Unable to get context for package ").append(((PackageItemInfo) (applicationinfo)).packageName).append(" while loading content provider ").append(((PackageItemInfo) (providerinfo)).name).toString());
        contentproviderholder1 = null;
_L7:
        return contentproviderholder1;
        Context context1 = context.createPackageContext(((PackageItemInfo) (applicationinfo)).packageName, 1);
        obj = context1;
          goto _L5
_L4:
        IContentProvider icontentprovider;
label1:
        {
            contentprovider = (ContentProvider)((Context) (obj)).getClassLoader().loadClass(((PackageItemInfo) (providerinfo)).name).newInstance();
            icontentprovider = contentprovider.getIContentProvider();
            if(icontentprovider != null)
                break label1;
            Slog.e("ActivityThread", (new StringBuilder()).append("Failed to instantiate class ").append(((PackageItemInfo) (providerinfo)).name).append(" from sourceDir ").append(((ComponentInfo) (providerinfo)).applicationInfo.sourceDir).toString());
            contentproviderholder1 = null;
        }
        if(true) goto _L7; else goto _L6
_L6:
        contentprovider.attachInfo(((Context) (obj)), providerinfo);
_L12:
        HashMap hashmap = mProviderMap;
        hashmap;
        JVM INSTR monitorenter ;
        IBinder ibinder = icontentprovider.asBinder();
        if(contentprovider == null) goto _L9; else goto _L8
_L8:
        ComponentName componentname;
        ProviderClientRecord providerclientrecord;
        componentname = new ComponentName(((PackageItemInfo) (providerinfo)).packageName, ((PackageItemInfo) (providerinfo)).name);
        providerclientrecord = (ProviderClientRecord)mLocalProvidersByName.get(componentname);
        if(providerclientrecord == null) goto _L11; else goto _L10
_L10:
        providerclientrecord.mProvider;
_L13:
        contentproviderholder1 = providerclientrecord.mHolder;
          goto _L7
_L14:
        Exception exception1;
        throw exception1;
        Exception exception;
        exception;
        if(!mInstrumentation.onException(null, exception))
            throw new RuntimeException((new StringBuilder()).append("Unable to get provider ").append(((PackageItemInfo) (providerinfo)).name).append(": ").append(exception.toString()).toString(), exception);
        contentproviderholder1 = null;
          goto _L7
_L2:
        icontentprovider = contentproviderholder.provider;
          goto _L12
_L11:
        IActivityManager.ContentProviderHolder contentproviderholder2 = new IActivityManager.ContentProviderHolder(providerinfo);
        contentproviderholder2.provider = icontentprovider;
        contentproviderholder2.noReleaseNeeded = true;
        providerclientrecord = installProviderAuthoritiesLocked(icontentprovider, contentprovider, contentproviderholder2);
        mLocalProviders.put(ibinder, providerclientrecord);
        mLocalProvidersByName.put(componentname, providerclientrecord);
          goto _L13
_L9:
        ProviderRefCount providerrefcount;
        providerrefcount = (ProviderRefCount)mProviderRefCountMap.get(ibinder);
        if(providerrefcount == null)
            break MISSING_BLOCK_LABEL_565;
        if(flag1)
            break MISSING_BLOCK_LABEL_555;
        incProviderRefLocked(providerrefcount, flag2);
        try {
            ActivityManagerNative.getDefault().removeContentProvider(contentproviderholder.connection, flag2);
        }
        catch(RemoteException remoteexception) { }
        contentproviderholder1 = providerrefcount.holder;
          goto _L7
        ProviderClientRecord providerclientrecord1 = installProviderAuthoritiesLocked(icontentprovider, contentprovider, contentproviderholder);
        if(flag1)
            providerrefcount = new ProviderRefCount(contentproviderholder, providerclientrecord1, 1000, 1000);
        else
        if(flag2)
            providerrefcount = new ProviderRefCount(contentproviderholder, providerclientrecord1, 1, 0);
        else
            providerrefcount = new ProviderRefCount(contentproviderholder, providerclientrecord1, 0, 1);
        mProviderRefCountMap.put(ibinder, providerrefcount);
        break MISSING_BLOCK_LABEL_555;
        exception1;
          goto _L14
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
          goto _L5
        exception1;
          goto _L14
    }

    private ProviderClientRecord installProviderAuthoritiesLocked(IContentProvider icontentprovider, ContentProvider contentprovider, IActivityManager.ContentProviderHolder contentproviderholder) {
        String as[] = PATTERN_SEMICOLON.split(contentproviderholder.info.authority);
        ProviderClientRecord providerclientrecord = new ProviderClientRecord(as, icontentprovider, contentprovider, contentproviderholder);
        int i = 0;
        while(i < as.length)  {
            if((ProviderClientRecord)mProviderMap.get(as[i]) != null)
                Slog.w("ActivityThread", (new StringBuilder()).append("Content provider ").append(((PackageItemInfo) (providerclientrecord.mHolder.info)).name).append(" already published as ").append(as[i]).toString());
            else
                mProviderMap.put(as[i], providerclientrecord);
            i++;
        }
        return providerclientrecord;
    }

    public static void main(String args[]) {
        SamplingProfilerIntegration.start();
        CloseGuard.setEnabled(false);
        Process.setArgV0("<pre-initialized>");
        Looper.prepareMainLooper();
        if(sMainThreadHandler == null)
            sMainThreadHandler = new Handler();
        (new ActivityThread()).attach(false);
        AsyncTask.init();
        Looper.loop();
        throw new RuntimeException("Main thread loop unexpectedly exited");
    }

    private static void performConfigurationChanged(ComponentCallbacks2 componentcallbacks2, Configuration configuration) {
        Activity activity;
        boolean flag;
        if(componentcallbacks2 instanceof Activity)
            activity = (Activity)componentcallbacks2;
        else
            activity = null;
        if(activity != null)
            activity.mCalled = false;
        flag = false;
        if(activity == null || activity.mCurrentConfig == null) {
            flag = true;
        } else {
            int i = activity.mCurrentConfig.diff(configuration);
            if(i != 0 && (i & (-1 ^ activity.mActivityInfo.getRealConfigChanged())) == 0)
                flag = true;
        }
        if(flag) {
            componentcallbacks2.onConfigurationChanged(configuration);
            if(activity != null) {
                if(!activity.mCalled)
                    throw new SuperNotCalledException((new StringBuilder()).append("Activity ").append(activity.getLocalClassName()).append(" did not call through to super.onConfigurationChanged()").toString());
                activity.mConfigChangeFlags = 0;
                activity.mCurrentConfig = new Configuration(configuration);
            }
        }
    }

    private ActivityClientRecord performDestroyActivity(IBinder ibinder, boolean flag, int i, boolean flag1) {
        ActivityClientRecord activityclientrecord;
        Class class1;
        activityclientrecord = (ActivityClientRecord)mActivities.get(ibinder);
        class1 = null;
        if(activityclientrecord == null)
            break MISSING_BLOCK_LABEL_525;
        class1 = activityclientrecord.activity.getClass();
        Activity activity = activityclientrecord.activity;
        activity.mConfigChangeFlags = i | activity.mConfigChangeFlags;
        if(flag)
            activityclientrecord.activity.mFinished = true;
        if(!activityclientrecord.paused) {
            try {
                activityclientrecord.activity.mCalled = false;
                mInstrumentation.callActivityOnPause(activityclientrecord.activity);
                EventLog.writeEvent(30021, activityclientrecord.activity.getComponentName().getClassName());
                if(!activityclientrecord.activity.mCalled)
                    throw new SuperNotCalledException((new StringBuilder()).append("Activity ").append(safeToComponentShortString(activityclientrecord.intent)).append(" did not call through to super.onPause()").toString());
            }
            catch(SuperNotCalledException supernotcalledexception2) {
                throw supernotcalledexception2;
            }
            catch(Exception exception3) {
                if(!mInstrumentation.onException(activityclientrecord.activity, exception3))
                    throw new RuntimeException((new StringBuilder()).append("Unable to pause activity ").append(safeToComponentShortString(activityclientrecord.intent)).append(": ").append(exception3.toString()).toString(), exception3);
            }
            activityclientrecord.paused = true;
        }
        if(!activityclientrecord.stopped) {
            SuperNotCalledException supernotcalledexception;
            try {
                activityclientrecord.activity.performStop();
            }
            catch(SuperNotCalledException supernotcalledexception1) {
                throw supernotcalledexception1;
            }
            catch(Exception exception2) {
                if(!mInstrumentation.onException(activityclientrecord.activity, exception2))
                    throw new RuntimeException((new StringBuilder()).append("Unable to stop activity ").append(safeToComponentShortString(activityclientrecord.intent)).append(": ").append(exception2.toString()).toString(), exception2);
            }
            activityclientrecord.stopped = true;
        }
        if(flag1)
            try {
                activityclientrecord.lastNonConfigurationInstances = activityclientrecord.activity.retainNonConfigurationInstances();
            }
            catch(Exception exception1) {
                if(!mInstrumentation.onException(activityclientrecord.activity, exception1))
                    throw new RuntimeException((new StringBuilder()).append("Unable to retain activity ").append(activityclientrecord.intent.getComponent().toShortString()).append(": ").append(exception1.toString()).toString(), exception1);
            }
        activityclientrecord.activity.mCalled = false;
        mInstrumentation.callActivityOnDestroy(activityclientrecord.activity);
        if(!activityclientrecord.activity.mCalled)
            throw new SuperNotCalledException((new StringBuilder()).append("Activity ").append(safeToComponentShortString(activityclientrecord.intent)).append(" did not call through to super.onDestroy()").toString());
        try {
            if(activityclientrecord.window != null)
                activityclientrecord.window.closeAllPanels();
        }
        // Misplaced declaration of an exception variable
        catch(SuperNotCalledException supernotcalledexception) {
            throw supernotcalledexception;
        }
        catch(Exception exception) {
            if(!mInstrumentation.onException(activityclientrecord.activity, exception))
                throw new RuntimeException((new StringBuilder()).append("Unable to destroy activity ").append(safeToComponentShortString(activityclientrecord.intent)).append(": ").append(exception.toString()).toString(), exception);
        }
        mActivities.remove(ibinder);
        StrictMode.decrementExpectedActivityCount(class1);
        return activityclientrecord;
    }

    private Activity performLaunchActivity(ActivityClientRecord activityclientrecord, Intent intent) {
        ComponentName componentname;
        Activity activity;
        ActivityInfo activityinfo = activityclientrecord.activityInfo;
        if(activityclientrecord.packageInfo == null)
            activityclientrecord.packageInfo = getPackageInfo(((ComponentInfo) (activityinfo)).applicationInfo, activityclientrecord.compatInfo, 1);
        componentname = activityclientrecord.intent.getComponent();
        if(componentname == null) {
            componentname = activityclientrecord.intent.resolveActivity(mInitialApplication.getPackageManager());
            activityclientrecord.intent.setComponent(componentname);
        }
        if(activityclientrecord.activityInfo.targetActivity != null) {
            String s = ((PackageItemInfo) (activityclientrecord.activityInfo)).packageName;
            String s1 = activityclientrecord.activityInfo.targetActivity;
            componentname = new ComponentName(s, s1);
        }
        activity = null;
        ClassLoader classloader = activityclientrecord.packageInfo.getClassLoader();
        activity = mInstrumentation.newActivity(classloader, componentname.getClassName(), activityclientrecord.intent);
        StrictMode.incrementExpectedActivityCount(activity.getClass());
        activityclientrecord.intent.setExtrasClassLoader(classloader);
        if(activityclientrecord.state != null)
            activityclientrecord.state.setClassLoader(classloader);
_L2:
        SuperNotCalledException supernotcalledexception;
        Application application = activityclientrecord.packageInfo.makeApplication(false, mInstrumentation);
        if(activity == null)
            break MISSING_BLOCK_LABEL_677;
        ContextImpl contextimpl = new ContextImpl();
        contextimpl.init(activityclientrecord.packageInfo, activityclientrecord.token, this);
        contextimpl.setOuterContext(activity);
        CharSequence charsequence = activityclientrecord.activityInfo.loadLabel(contextimpl.getPackageManager());
        Configuration configuration = new Configuration(mCompatConfiguration);
        activity.attach(contextimpl, this, getInstrumentation(), activityclientrecord.token, activityclientrecord.ident, application, activityclientrecord.intent, activityclientrecord.activityInfo, charsequence, activityclientrecord.parent, activityclientrecord.embeddedID, activityclientrecord.lastNonConfigurationInstances, configuration);
        if(intent != null)
            activity.mIntent = intent;
        activityclientrecord.lastNonConfigurationInstances = null;
        activity.mStartedActivity = false;
        int i = activityclientrecord.activityInfo.getThemeResource();
        if(i != 0)
            activity.setTheme(i);
        activity.mCalled = false;
        mInstrumentation.callActivityOnCreate(activity, activityclientrecord.state);
        if(!activity.mCalled)
            throw new SuperNotCalledException((new StringBuilder()).append("Activity ").append(activityclientrecord.intent.getComponent().toShortString()).append(" did not call through to super.onCreate()").toString());
        break MISSING_BLOCK_LABEL_475;
        Exception exception;
        exception;
        if(mInstrumentation.onException(activity, exception)) goto _L2; else goto _L1
_L1:
        throw new RuntimeException((new StringBuilder()).append("Unable to instantiate activity ").append(componentname).append(": ").append(exception.toString()).toString(), exception);
        Exception exception1;
        activityclientrecord.activity = activity;
        activityclientrecord.stopped = true;
        if(!activityclientrecord.activity.mFinished) {
            activity.performStart();
            activityclientrecord.stopped = false;
        }
        if(!activityclientrecord.activity.mFinished && activityclientrecord.state != null)
            mInstrumentation.callActivityOnRestoreInstanceState(activity, activityclientrecord.state);
        if(!activityclientrecord.activity.mFinished) {
            activity.mCalled = false;
            mInstrumentation.callActivityOnPostCreate(activity, activityclientrecord.state);
            if(!activity.mCalled)
                throw new SuperNotCalledException((new StringBuilder()).append("Activity ").append(activityclientrecord.intent.getComponent().toShortString()).append(" did not call through to super.onPostCreate()").toString());
        }
        try {
            activityclientrecord.paused = true;
            mActivities.put(activityclientrecord.token, activityclientrecord);
        }
        // Misplaced declaration of an exception variable
        catch(SuperNotCalledException supernotcalledexception) {
            throw supernotcalledexception;
        }
        // Misplaced declaration of an exception variable
        catch(Exception exception1) {
            if(!mInstrumentation.onException(activity, exception1))
                throw new RuntimeException((new StringBuilder()).append("Unable to start activity ").append(componentname).append(": ").append(exception1.toString()).toString(), exception1);
        }
        return activity;
    }

    private void performStopActivityInner(ActivityClientRecord activityclientrecord, StopInfo stopinfo, boolean flag, boolean flag1) {
        if(activityclientrecord == null) goto _L2; else goto _L1
_L1:
        if(flag || !activityclientrecord.stopped) goto _L4; else goto _L3
_L3:
        if(!activityclientrecord.activity.mFinished) goto _L5; else goto _L2
_L2:
        return;
_L5:
        RuntimeException runtimeexception = new RuntimeException((new StringBuilder()).append("Performing stop of activity that is not resumed: ").append(activityclientrecord.intent.getComponent().toShortString()).toString());
        Slog.e("ActivityThread", runtimeexception.getMessage(), runtimeexception);
_L4:
        if(stopinfo != null)
            try {
                stopinfo.thumbnail = null;
                stopinfo.description = activityclientrecord.activity.onCreateDescription();
            }
            catch(Exception exception1) {
                if(!mInstrumentation.onException(activityclientrecord.activity, exception1))
                    throw new RuntimeException((new StringBuilder()).append("Unable to save state of activity ").append(activityclientrecord.intent.getComponent().toShortString()).append(": ").append(exception1.toString()).toString(), exception1);
            }
        if(!activityclientrecord.activity.mFinished && flag1)
            if(activityclientrecord.state == null) {
                Bundle bundle = new Bundle();
                bundle.setAllowFds(false);
                mInstrumentation.callActivityOnSaveInstanceState(activityclientrecord.activity, bundle);
                activityclientrecord.state = bundle;
            } else {
                activityclientrecord.state;
            }
        if(flag) goto _L7; else goto _L6
_L6:
        activityclientrecord.activity.performStop();
_L9:
        activityclientrecord.stopped = true;
_L7:
        activityclientrecord.paused = true;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        if(mInstrumentation.onException(activityclientrecord.activity, exception)) goto _L9; else goto _L8
_L8:
        throw new RuntimeException((new StringBuilder()).append("Unable to stop activity ").append(activityclientrecord.intent.getComponent().toShortString()).append(": ").append(exception.toString()).toString(), exception);
        if(true) goto _L2; else goto _L10
_L10:
    }

    private void queueOrSendMessage(int i, Object obj) {
        queueOrSendMessage(i, obj, 0, 0);
    }

    private void queueOrSendMessage(int i, Object obj, int j) {
        queueOrSendMessage(i, obj, j, 0);
    }

    private void queueOrSendMessage(int i, Object obj, int j, int k) {
        this;
        JVM INSTR monitorenter ;
        Message message = Message.obtain();
        message.what = i;
        message.obj = obj;
        message.arg1 = j;
        message.arg2 = k;
        mH.sendMessage(message);
        return;
    }

    private static String safeToComponentShortString(Intent intent) {
        ComponentName componentname = intent.getComponent();
        String s;
        if(componentname == null)
            s = "[Unknown]";
        else
            s = componentname.toShortString();
        return s;
    }

    private void setupGraphicsSupport(LoadedApk loadedapk, File file) {
        if(!Process.isIsolated()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        try {
            int i = Process.myUid();
            String as[] = getPackageManager().getPackagesForUid(i);
            if(as != null && as.length == 1) {
                HardwareRenderer.setupDiskCache(file);
                RenderScript.setupDiskCache(file);
            }
        }
        catch(RemoteException remoteexception) { }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static ActivityThread systemMain() {
        HardwareRenderer.disable(true);
        ActivityThread activitythread = new ActivityThread();
        activitythread.attach(true);
        return activitythread;
    }

    private void updateVisibility(ActivityClientRecord activityclientrecord, boolean flag) {
        View view = activityclientrecord.activity.mDecor;
        if(view == null) goto _L2; else goto _L1
_L1:
        if(!flag) goto _L4; else goto _L3
_L3:
        if(!activityclientrecord.activity.mVisibleFromServer) {
            activityclientrecord.activity.mVisibleFromServer = true;
            mNumVisibleActivities = 1 + mNumVisibleActivities;
            if(activityclientrecord.activity.mVisibleFromClient)
                activityclientrecord.activity.makeVisible();
        }
        if(activityclientrecord.newConfig != null) {
            performConfigurationChanged(activityclientrecord.activity, activityclientrecord.newConfig);
            freeTextLayoutCachesIfNeeded(activityclientrecord.activity.mCurrentConfig.diff(activityclientrecord.newConfig));
            activityclientrecord.newConfig = null;
        }
_L2:
        return;
_L4:
        if(activityclientrecord.activity.mVisibleFromServer) {
            activityclientrecord.activity.mVisibleFromServer = false;
            mNumVisibleActivities = -1 + mNumVisibleActivities;
            view.setVisibility(4);
        }
        if(true) goto _L2; else goto _L5
_L5:
    }

    public final IContentProvider acquireExistingProvider(Context context, String s, boolean flag) {
        HashMap hashmap = mProviderMap;
        hashmap;
        JVM INSTR monitorenter ;
        ProviderClientRecord providerclientrecord = (ProviderClientRecord)mProviderMap.get(s);
        IContentProvider icontentprovider;
        if(providerclientrecord == null) {
            icontentprovider = null;
        } else {
            icontentprovider = providerclientrecord.mProvider;
            IBinder ibinder = icontentprovider.asBinder();
            ProviderRefCount providerrefcount = (ProviderRefCount)mProviderRefCountMap.get(ibinder);
            if(providerrefcount != null)
                incProviderRefLocked(providerrefcount, flag);
        }
        return icontentprovider;
    }

    public final IContentProvider acquireProvider(Context context, String s, boolean flag) {
        IContentProvider icontentprovider = acquireExistingProvider(context, s, flag);
        if(icontentprovider == null) goto _L2; else goto _L1
_L1:
        return icontentprovider;
_L2:
        IActivityManager.ContentProviderHolder contentproviderholder = null;
        IActivityManager.ContentProviderHolder contentproviderholder1 = ActivityManagerNative.getDefault().getContentProvider(getApplicationThread(), s, flag);
        contentproviderholder = contentproviderholder1;
_L4:
        if(contentproviderholder == null) {
            Slog.e("ActivityThread", (new StringBuilder()).append("Failed to find provider info for ").append(s).toString());
            icontentprovider = null;
        } else {
            icontentprovider = installProvider(context, contentproviderholder, contentproviderholder.info, true, contentproviderholder.noReleaseNeeded, flag).provider;
        }
        if(true) goto _L1; else goto _L3
_L3:
        RemoteException remoteexception;
        remoteexception;
          goto _L4
    }

    final Configuration applyCompatConfiguration() {
        Configuration configuration = mConfiguration;
        if(mCompatConfiguration == null)
            mCompatConfiguration = new Configuration();
        mCompatConfiguration.setTo(mConfiguration);
        if(mResCompatibilityInfo != null && !mResCompatibilityInfo.supportsScreen()) {
            mResCompatibilityInfo.applyToConfiguration(mCompatConfiguration);
            configuration = mCompatConfiguration;
        }
        return configuration;
    }

    Configuration applyConfigCompatMainThread(Configuration configuration, CompatibilityInfo compatibilityinfo) {
        Configuration configuration1;
        if(configuration == null) {
            configuration1 = null;
        } else {
            if(compatibilityinfo != null && !compatibilityinfo.supportsScreen()) {
                mMainThreadConfig.setTo(configuration);
                configuration = mMainThreadConfig;
                compatibilityinfo.applyToConfiguration(configuration);
            }
            configuration1 = configuration;
        }
        return configuration1;
    }

    public final void applyConfigurationToResources(Configuration configuration) {
        HashMap hashmap = mPackages;
        hashmap;
        JVM INSTR monitorenter ;
        applyConfigurationToResourcesLocked(configuration, null);
        return;
    }

    final boolean applyConfigurationToResourcesLocked(Configuration configuration, CompatibilityInfo compatibilityinfo) {
        boolean flag = true;
        boolean flag1 = false;
        if(mResConfiguration == null)
            mResConfiguration = new Configuration();
        if(mResConfiguration.isOtherSeqNewer(configuration) || compatibilityinfo != null) {
            int i = mResConfiguration.updateFrom(configuration);
            DisplayMetrics displaymetrics = getDisplayMetricsLocked(null, flag);
            if(compatibilityinfo != null && (mResCompatibilityInfo == null || !mResCompatibilityInfo.equals(compatibilityinfo))) {
                mResCompatibilityInfo = compatibilityinfo;
                i |= 0xd00;
            }
            MiuiThemeHelper.handleExtraConfigurationChanges(i);
            if(configuration.locale != null)
                Locale.setDefault(configuration.locale);
            Resources.updateSystemConfiguration(configuration, displaymetrics, compatibilityinfo);
            ApplicationPackageManager.configurationChanged();
            for(Iterator iterator = mActiveResources.values().iterator(); iterator.hasNext();) {
                Resources resources = (Resources)((WeakReference)iterator.next()).get();
                if(resources != null)
                    resources.updateConfiguration(configuration, displaymetrics, compatibilityinfo);
                else
                    iterator.remove();
            }

            if(i == 0)
                flag = false;
            flag1 = flag;
        }
        return flag1;
    }

    ArrayList collectComponentCallbacksLocked(boolean flag, Configuration configuration) {
        ArrayList arraylist;
        arraylist = new ArrayList();
        if(mActivities.size() > 0) {
            Iterator iterator2 = mActivities.values().iterator();
            do {
                if(!iterator2.hasNext())
                    break;
                ActivityClientRecord activityclientrecord = (ActivityClientRecord)iterator2.next();
                Activity activity = activityclientrecord.activity;
                if(activity != null) {
                    Configuration configuration1 = applyConfigCompatMainThread(configuration, activityclientrecord.packageInfo.mCompatibilityInfo.getIfNeeded());
                    if(!activityclientrecord.activity.mFinished && (flag || !activityclientrecord.paused))
                        arraylist.add(activity);
                    else
                    if(configuration1 != null)
                        activityclientrecord.newConfig = configuration1;
                }
            } while(true);
        }
        if(mServices.size() > 0) {
            for(Iterator iterator1 = mServices.values().iterator(); iterator1.hasNext(); arraylist.add((Service)iterator1.next()));
        }
        HashMap hashmap = mProviderMap;
        hashmap;
        JVM INSTR monitorenter ;
        if(mLocalProviders.size() > 0) {
            for(Iterator iterator = mLocalProviders.values().iterator(); iterator.hasNext(); arraylist.add(((ProviderClientRecord)iterator.next()).mLocalProvider));
        }
        break MISSING_BLOCK_LABEL_256;
        Exception exception;
        exception;
        throw exception;
        hashmap;
        JVM INSTR monitorexit ;
        int i = mAllApplications.size();
        for(int j = 0; j < i; j++)
            arraylist.add(mAllApplications.get(j));

        return arraylist;
    }

    final void completeRemoveProvider(ProviderRefCount providerrefcount) {
        HashMap hashmap = mProviderMap;
        hashmap;
        JVM INSTR monitorenter ;
        if(!providerrefcount.removePending)
            break MISSING_BLOCK_LABEL_144;
        IBinder ibinder = providerrefcount.holder.provider.asBinder();
        if((ProviderRefCount)mProviderRefCountMap.get(ibinder) == providerrefcount)
            mProviderRefCountMap.remove(ibinder);
        Iterator iterator = mProviderMap.values().iterator();
        do {
            if(!iterator.hasNext())
                break;
            if(((ProviderClientRecord)iterator.next()).mProvider.asBinder() == ibinder)
                iterator.remove();
        } while(true);
        break MISSING_BLOCK_LABEL_121;
        Exception exception;
        exception;
        throw exception;
        hashmap;
        JVM INSTR monitorexit ;
        try {
            ActivityManagerNative.getDefault().removeContentProvider(providerrefcount.holder.connection, false);
        }
        catch(RemoteException remoteexception) { }
    }

    void doGcIfNeeded() {
        mGcIdlerScheduled = false;
        long l = SystemClock.uptimeMillis();
        if(5000L + BinderInternal.getLastGcTime() < l)
            BinderInternal.forceGc("bg");
    }

    void ensureJitEnabled() {
        if(!mJitEnabled) {
            mJitEnabled = true;
            VMRuntime.getRuntime().startJitCompilation();
        }
    }

    final void finishInstrumentation(int i, Bundle bundle) {
        IActivityManager iactivitymanager;
        iactivitymanager = ActivityManagerNative.getDefault();
        if(mProfiler.profileFile != null && mProfiler.handlingProfiling && mProfiler.profileFd == null)
            Debug.stopMethodTracing();
        iactivitymanager.finishInstrumentation(mAppThread, i, bundle);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    final void freeTextLayoutCachesIfNeeded(int i) {
        if(i != 0) {
            boolean flag;
            if((i & 4) != 0)
                flag = true;
            else
                flag = false;
            if(flag)
                Canvas.freeTextLayoutCaches();
        }
    }

    public final Activity getActivity(IBinder ibinder) {
        return ((ActivityClientRecord)mActivities.get(ibinder)).activity;
    }

    public Application getApplication() {
        return mInitialApplication;
    }

    public ApplicationThread getApplicationThread() {
        return mAppThread;
    }

    public Configuration getConfiguration() {
        return mResConfiguration;
    }

    DisplayMetrics getDisplayMetricsLocked(CompatibilityInfo compatibilityinfo, boolean flag) {
        DisplayMetrics displaymetrics = (DisplayMetrics)mDisplayMetrics.get(compatibilityinfo);
        DisplayMetrics displaymetrics1;
        if(displaymetrics != null && !flag) {
            displaymetrics1 = displaymetrics;
        } else {
            if(displaymetrics == null) {
                displaymetrics = new DisplayMetrics();
                mDisplayMetrics.put(compatibilityinfo, displaymetrics);
            }
            WindowManagerImpl.getDefault(compatibilityinfo).getDefaultDisplay().getMetrics(displaymetrics);
            displaymetrics1 = displaymetrics;
        }
        return displaymetrics1;
    }

    final Handler getHandler() {
        return mH;
    }

    public Instrumentation getInstrumentation() {
        return mInstrumentation;
    }

    public int getIntCoreSetting(String s, int i) {
        HashMap hashmap = mPackages;
        hashmap;
        JVM INSTR monitorenter ;
        if(mCoreSettings != null)
            i = mCoreSettings.getInt(s, i);
        return i;
    }

    public Looper getLooper() {
        return mLooper;
    }

    public final LoadedApk getPackageInfo(ApplicationInfo applicationinfo, CompatibilityInfo compatibilityinfo, int i) {
        boolean flag = false;
        boolean flag1;
        if((i & 1) != 0)
            flag1 = true;
        else
            flag1 = false;
        if(flag1 && applicationinfo.uid != 0 && applicationinfo.uid != 1000 && (mBoundApplication == null || !UserId.isSameApp(applicationinfo.uid, mBoundApplication.appInfo.uid)))
            flag = true;
        if((i & 3) == 1 && flag) {
            String s = (new StringBuilder()).append("Requesting code from ").append(((PackageItemInfo) (applicationinfo)).packageName).append(" (with uid ").append(applicationinfo.uid).append(")").toString();
            if(mBoundApplication != null)
                s = (new StringBuilder()).append(s).append(" to be run in process ").append(mBoundApplication.processName).append(" (with uid ").append(mBoundApplication.appInfo.uid).append(")").toString();
            throw new SecurityException(s);
        } else {
            return getPackageInfo(applicationinfo, compatibilityinfo, null, flag, flag1);
        }
    }

    public final LoadedApk getPackageInfo(String s, CompatibilityInfo compatibilityinfo, int i) {
        HashMap hashmap = mPackages;
        hashmap;
        JVM INSTR monitorenter ;
        WeakReference weakreference;
        if((i & 1) == 0)
            break MISSING_BLOCK_LABEL_155;
        weakreference = (WeakReference)mPackages.get(s);
_L1:
        LoadedApk loadedapk;
        ApplicationInfo applicationinfo;
        RemoteException remoteexception;
        ApplicationInfo applicationinfo1;
        Exception exception;
        if(weakreference != null)
            loadedapk = (LoadedApk)weakreference.get();
        else
            loadedapk = null;
        if(loadedapk != null && (loadedapk.mResources == null || loadedapk.mResources.getAssets().isUpToDate())) {
            if(loadedapk.isSecurityViolation() && (i & 2) == 0)
                throw new SecurityException((new StringBuilder()).append("Requesting code from ").append(s).append(" to be run in process ").append(mBoundApplication.processName).append("/").append(mBoundApplication.appInfo.uid).toString());
            break MISSING_BLOCK_LABEL_239;
        }
        break MISSING_BLOCK_LABEL_179;
        exception;
        throw exception;
        weakreference = (WeakReference)mResourcePackages.get(s);
          goto _L1
        applicationinfo = null;
        applicationinfo1 = getPackageManager().getApplicationInfo(s, 1024, UserId.myUserId());
        applicationinfo = applicationinfo1;
_L3:
        if(applicationinfo != null)
            loadedapk = getPackageInfo(applicationinfo, compatibilityinfo, i);
        else
            loadedapk = null;
        break MISSING_BLOCK_LABEL_239;
        remoteexception;
        if(true) goto _L3; else goto _L2
_L2:
        return loadedapk;
    }

    public final LoadedApk getPackageInfoNoCheck(ApplicationInfo applicationinfo, CompatibilityInfo compatibilityinfo) {
        return getPackageInfo(applicationinfo, compatibilityinfo, null, false, true);
    }

    public String getProcessName() {
        return mBoundApplication.processName;
    }

    public String getProfileFilePath() {
        return mProfiler.profileFile;
    }

    public ContextImpl getSystemContext() {
        this;
        JVM INSTR monitorenter ;
        if(mSystemContext == null) {
            ContextImpl contextimpl = ContextImpl.createSystemContext(this);
            contextimpl.init(new LoadedApk(this, "android", contextimpl, null, CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO), null, this);
            contextimpl.getResources().updateConfiguration(getConfiguration(), getDisplayMetricsLocked(CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO, false));
            mSystemContext = contextimpl;
        }
        this;
        JVM INSTR monitorexit ;
        return mSystemContext;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    Resources getTopLevelResources(String s, LoadedApk loadedapk) {
        return getTopLevelResources(s, loadedapk.mCompatibilityInfo.get());
    }

    Resources getTopLevelResources(String s, CompatibilityInfo compatibilityinfo) {
        Resources resources;
        ResourcesKey resourceskey;
        resources = null;
        resourceskey = new ResourcesKey(s, compatibilityinfo.applicationScale);
        HashMap hashmap = mPackages;
        hashmap;
        JVM INSTR monitorenter ;
        Resources resources1;
        WeakReference weakreference = (WeakReference)mActiveResources.get(resourceskey);
        if(weakreference == null)
            break MISSING_BLOCK_LABEL_226;
        resources1 = (Resources)weakreference.get();
_L7:
        if(resources1 == null || !resources1.getAssets().isUpToDate()) goto _L2; else goto _L1
_L1:
        resources = resources1;
          goto _L3
_L2:
        AssetManager assetmanager = new AssetManager();
        if(assetmanager.addAssetPath(s) == 0) goto _L3; else goto _L4
_L4:
        Resources resources2 = MiuiClassFactory.newResources(assetmanager, getDisplayMetricsLocked(null, false), getConfiguration(), compatibilityinfo);
        HashMap hashmap1 = mPackages;
        hashmap1;
        JVM INSTR monitorenter ;
        WeakReference weakreference1 = (WeakReference)mActiveResources.get(resourceskey);
        if(weakreference1 != null)
            resources = (Resources)weakreference1.get();
        if(resources == null || !resources.getAssets().isUpToDate()) goto _L6; else goto _L5
_L5:
        resources2.getAssets().close();
          goto _L3
        Exception exception1;
        exception1;
        throw exception1;
        Exception exception;
        exception;
        hashmap;
        JVM INSTR monitorexit ;
        throw exception;
_L6:
        mActiveResources.put(resourceskey, new WeakReference(resources2));
        hashmap1;
        JVM INSTR monitorexit ;
        resources = resources2;
_L3:
        return resources;
        resources1 = null;
          goto _L7
    }

    Resources getTopLevelResources(String s, String s1, CompatibilityInfo compatibilityinfo) {
        Resources resources = getTopLevelResources(s1, compatibilityinfo);
        ((MiuiResources)resources).init(s);
        return resources;
    }

    final void handleActivityConfigurationChanged(IBinder ibinder) {
        ActivityClientRecord activityclientrecord = (ActivityClientRecord)mActivities.get(ibinder);
        if(activityclientrecord != null && activityclientrecord.activity != null) {
            performConfigurationChanged(activityclientrecord.activity, mCompatConfiguration);
            freeTextLayoutCachesIfNeeded(activityclientrecord.activity.mCurrentConfig.diff(mCompatConfiguration));
        }
    }

    final void handleConfigurationChanged(Configuration configuration, CompatibilityInfo compatibilityinfo) {
        HashMap hashmap = mPackages;
        hashmap;
        JVM INSTR monitorenter ;
        if(mPendingConfiguration != null) {
            if(!mPendingConfiguration.isOtherSeqNewer(configuration))
                configuration = mPendingConfiguration;
            mPendingConfiguration = null;
        }
        if(configuration == null)
            break MISSING_BLOCK_LABEL_187;
        applyConfigurationToResourcesLocked(configuration, compatibilityinfo);
        if(mConfiguration == null)
            mConfiguration = new Configuration();
        if(!mConfiguration.isOtherSeqNewer(configuration) && compatibilityinfo == null)
            break MISSING_BLOCK_LABEL_187;
        break MISSING_BLOCK_LABEL_96;
        Exception exception;
        exception;
        throw exception;
        int i;
        Configuration configuration1;
        ArrayList arraylist;
        i = mConfiguration.diff(configuration);
        mConfiguration.updateFrom(configuration);
        configuration1 = applyCompatConfiguration();
        arraylist = collectComponentCallbacksLocked(false, configuration1);
        hashmap;
        JVM INSTR monitorexit ;
        WindowManagerImpl.getDefault().trimLocalMemory();
        freeTextLayoutCachesIfNeeded(i);
        if(arraylist != null) {
            int j = arraylist.size();
            for(int k = 0; k < j; k++)
                performConfigurationChanged((ComponentCallbacks2)arraylist.get(k), configuration1);

        }
    }

    final void handleDispatchPackageBroadcast(int i, String as[]) {
        boolean flag = false;
        if(as != null) {
            int j = -1 + as.length;
            while(j >= 0)  {
                if(!flag) {
                    WeakReference weakreference = (WeakReference)mPackages.get(as[j]);
                    if(weakreference != null && weakreference.get() != null) {
                        flag = true;
                    } else {
                        WeakReference weakreference1 = (WeakReference)mResourcePackages.get(as[j]);
                        if(weakreference1 != null && weakreference1.get() != null)
                            flag = true;
                    }
                }
                mPackages.remove(as[j]);
                mResourcePackages.remove(as[j]);
                j--;
            }
        }
        ApplicationPackageManager.handlePackageBroadcast(i, as, flag);
    }

    final void handleLowMemory() {
        ArrayList arraylist;
        synchronized(mPackages) {
            arraylist = collectComponentCallbacksLocked(true, null);
        }
        int i = arraylist.size();
        for(int j = 0; j < i; j++)
            ((ComponentCallbacks2)arraylist.get(j)).onLowMemory();

        break MISSING_BLOCK_LABEL_57;
        exception;
        hashmap;
        JVM INSTR monitorexit ;
        throw exception;
        if(Process.myUid() != 1000)
            EventLog.writeEvent(0x124fb, SQLiteDatabase.releaseMemory());
        Canvas.freeCaches();
        Canvas.freeTextLayoutCaches();
        BinderInternal.forceGc("mem");
        return;
    }

    final void handleProfilerControl(boolean flag, ProfilerControlData profilercontroldata, int i) {
        if(!flag) goto _L2; else goto _L1
_L1:
        mProfiler.setProfiler(profilercontroldata.path, profilercontroldata.fd);
        mProfiler.autoStopProfiler = false;
        mProfiler.startProfiling();
        profilercontroldata.fd.close();
_L3:
        return;
        RuntimeException runtimeexception;
        runtimeexception;
        Slog.w("ActivityThread", (new StringBuilder()).append("Profiling failed on path ").append(profilercontroldata.path).append(" -- can the process access this path?").toString());
        profilercontroldata.fd.close();
          goto _L3
        IOException ioexception1;
        ioexception1;
        String s;
        String s1;
        s = "ActivityThread";
        s1 = "Failure closing profile fd";
_L4:
        Slog.w(s, s1, ioexception1);
          goto _L3
        Exception exception;
        exception;
        try {
            profilercontroldata.fd.close();
        }
        catch(IOException ioexception) {
            Slog.w("ActivityThread", "Failure closing profile fd", ioexception);
        }
        throw exception;
_L2:
        mProfiler.stopProfiling();
          goto _L3
        ioexception1;
        s = "ActivityThread";
        s1 = "Failure closing profile fd";
          goto _L4
    }

    final void handleResumeActivity(IBinder ibinder, boolean flag, boolean flag1) {
        ActivityClientRecord activityclientrecord;
        unscheduleGcIdler();
        activityclientrecord = performResumeActivity(ibinder, flag);
        if(activityclientrecord == null) goto _L2; else goto _L1
_L1:
        boolean flag2;
        Activity activity = activityclientrecord.activity;
        char c;
        android.view.WindowManager.LayoutParams layoutparams;
        View view;
        WindowManager windowmanager;
        android.view.WindowManager.LayoutParams layoutparams1;
        boolean flag3;
        if(flag1)
            c = '\u0100';
        else
            c = '\0';
        if(!activity.mStartedActivity)
            flag2 = true;
        else
            flag2 = false;
        if(flag2)
            break MISSING_BLOCK_LABEL_68;
        flag3 = ActivityManagerNative.getDefault().willActivityBeVisible(activity.getActivityToken());
        flag2 = flag3;
_L6:
        if(activityclientrecord.window == null && !activity.mFinished && flag2) {
            activityclientrecord.window = activityclientrecord.activity.getWindow();
            view = activityclientrecord.window.getDecorView();
            view.setVisibility(4);
            windowmanager = activity.getWindowManager();
            layoutparams1 = activityclientrecord.window.getAttributes();
            activity.mDecor = view;
            layoutparams1.type = 1;
            layoutparams1.softInputMode = c | layoutparams1.softInputMode;
            if(activity.mVisibleFromClient) {
                activity.mWindowAdded = true;
                windowmanager.addView(view, layoutparams1);
            }
        } else
        if(!flag2)
            activityclientrecord.hideForNow = true;
        cleanUpPendingRemoveWindows(activityclientrecord);
        if(!activityclientrecord.activity.mFinished && flag2 && activityclientrecord.activity.mDecor != null && !activityclientrecord.hideForNow) {
            if(activityclientrecord.newConfig != null) {
                performConfigurationChanged(activityclientrecord.activity, activityclientrecord.newConfig);
                freeTextLayoutCachesIfNeeded(activityclientrecord.activity.mCurrentConfig.diff(activityclientrecord.newConfig));
                activityclientrecord.newConfig = null;
            }
            layoutparams = activityclientrecord.window.getAttributes();
            if((0x100 & layoutparams.softInputMode) != c) {
                layoutparams.softInputMode = c | 0xfffffeff & layoutparams.softInputMode;
                if(activityclientrecord.activity.mVisibleFromClient)
                    activity.getWindowManager().updateViewLayout(activityclientrecord.window.getDecorView(), layoutparams);
            }
            activityclientrecord.activity.mVisibleFromServer = true;
            mNumVisibleActivities = 1 + mNumVisibleActivities;
            if(activityclientrecord.activity.mVisibleFromClient)
                activityclientrecord.activity.makeVisible();
        }
        if(!activityclientrecord.onlyLocalRequest) {
            activityclientrecord.nextIdle = mNewActivities;
            mNewActivities = activityclientrecord;
            Looper.myQueue().addIdleHandler(new Idler());
        }
        activityclientrecord.onlyLocalRequest = false;
_L4:
        return;
_L2:
        try {
            ActivityManagerNative.getDefault().finishActivity(ibinder, 0, null);
        }
        catch(RemoteException remoteexception) { }
        if(true) goto _L4; else goto _L3
_L3:
        RemoteException remoteexception1;
        remoteexception1;
        if(true) goto _L6; else goto _L5
_L5:
    }

    final void handleTrimMemory(int i) {
        WindowManagerImpl windowmanagerimpl;
        windowmanagerimpl = WindowManagerImpl.getDefault();
        windowmanagerimpl.startTrimMemory(i);
        ArrayList arraylist;
        synchronized(mPackages) {
            arraylist = collectComponentCallbacksLocked(true, null);
        }
        int j = arraylist.size();
        for(int k = 0; k < j; k++)
            ((ComponentCallbacks2)arraylist.get(k)).onTrimMemory(i);

        break MISSING_BLOCK_LABEL_72;
        exception;
        hashmap;
        JVM INSTR monitorexit ;
        throw exception;
        windowmanagerimpl.endTrimMemory();
        return;
    }

    final void handleUnstableProviderDied(IBinder ibinder, boolean flag) {
        HashMap hashmap = mProviderMap;
        hashmap;
        JVM INSTR monitorenter ;
        ProviderRefCount providerrefcount;
        String as[];
        int i;
        int j;
        providerrefcount = (ProviderRefCount)mProviderRefCountMap.get(ibinder);
        if(providerrefcount == null)
            break MISSING_BLOCK_LABEL_181;
        mProviderRefCountMap.remove(ibinder);
        if(providerrefcount.client == null || providerrefcount.client.mNames == null)
            break MISSING_BLOCK_LABEL_161;
        as = providerrefcount.client.mNames;
        i = as.length;
        j = 0;
_L1:
        if(j >= i)
            break MISSING_BLOCK_LABEL_161;
        String s = as[j];
        ProviderClientRecord providerclientrecord = (ProviderClientRecord)mProviderMap.get(s);
        if(providerclientrecord != null && providerclientrecord.mProvider.asBinder() == ibinder) {
            Slog.i("ActivityThread", (new StringBuilder()).append("Removing dead content provider: ").append(s).toString());
            mProviderMap.remove(s);
        }
        j++;
          goto _L1
        Exception exception;
        if(flag)
            try {
                ActivityManagerNative.getDefault().unstableProviderDied(providerrefcount.holder.connection);
            }
            catch(RemoteException remoteexception) { }
            finally {
                hashmap;
            }
        return;
        throw exception;
    }

    public void installSystemApplicationInfo(ApplicationInfo applicationinfo) {
        this;
        JVM INSTR monitorenter ;
        ContextImpl contextimpl = getSystemContext();
        contextimpl.init(new LoadedApk(this, "android", contextimpl, applicationinfo, CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO), null, this);
        mProfiler = new Profiler();
        return;
    }

    public final void installSystemProviders(List list) {
        if(list != null)
            installContentProviders(mInitialApplication, list);
    }

    public boolean isProfiling() {
        boolean flag;
        if(mProfiler != null && mProfiler.profileFile != null && mProfiler.profileFd == null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public final LoadedApk peekPackageInfo(String s, boolean flag) {
        HashMap hashmap = mPackages;
        hashmap;
        JVM INSTR monitorenter ;
        WeakReference weakreference;
        LoadedApk loadedapk;
        if(flag)
            weakreference = (WeakReference)mPackages.get(s);
        else
            weakreference = (WeakReference)mResourcePackages.get(s);
        if(weakreference != null)
            loadedapk = (LoadedApk)weakreference.get();
        else
            loadedapk = null;
        return loadedapk;
    }

    public final ActivityClientRecord performDestroyActivity(IBinder ibinder, boolean flag) {
        return performDestroyActivity(ibinder, flag, 0, false);
    }

    public final void performNewIntents(IBinder ibinder, List list) {
        ActivityClientRecord activityclientrecord = (ActivityClientRecord)mActivities.get(ibinder);
        if(activityclientrecord != null) {
            boolean flag;
            if(!activityclientrecord.paused)
                flag = true;
            else
                flag = false;
            if(flag) {
                activityclientrecord.activity.mTemporaryPause = true;
                mInstrumentation.callActivityOnPause(activityclientrecord.activity);
            }
            deliverNewIntents(activityclientrecord, list);
            if(flag) {
                activityclientrecord.activity.performResume();
                activityclientrecord.activity.mTemporaryPause = false;
            }
        }
    }

    final Bundle performPauseActivity(ActivityClientRecord activityclientrecord, boolean flag, boolean flag1) {
        int i = 0;
        if(!activityclientrecord.paused) goto _L2; else goto _L1
_L1:
        if(!activityclientrecord.activity.mFinished) goto _L4; else goto _L3
_L3:
        Bundle bundle = null;
_L6:
        return bundle;
_L4:
        RuntimeException runtimeexception = new RuntimeException((new StringBuilder()).append("Performing pause of activity that is not resumed: ").append(activityclientrecord.intent.getComponent().toShortString()).toString());
        Slog.e("ActivityThread", runtimeexception.getMessage(), runtimeexception);
_L2:
        bundle = null;
        if(flag)
            activityclientrecord.activity.mFinished = true;
        Bundle bundle1;
        if(activityclientrecord.activity.mFinished || !flag1)
            break MISSING_BLOCK_LABEL_145;
        bundle1 = new Bundle();
        bundle1.setAllowFds(false);
        mInstrumentation.callActivityOnSaveInstanceState(activityclientrecord.activity, bundle1);
        activityclientrecord.state = bundle1;
        bundle = bundle1;
        activityclientrecord.activity.mCalled = false;
        mInstrumentation.callActivityOnPause(activityclientrecord.activity);
        EventLog.writeEvent(30021, activityclientrecord.activity.getComponentName().getClassName());
        if(!activityclientrecord.activity.mCalled)
            throw new SuperNotCalledException((new StringBuilder()).append("Activity ").append(activityclientrecord.intent.getComponent().toShortString()).append(" did not call through to super.onPause()").toString());
          goto _L5
        SuperNotCalledException supernotcalledexception;
        supernotcalledexception;
_L8:
        throw supernotcalledexception;
        Exception exception;
        exception;
_L7:
        if(!mInstrumentation.onException(activityclientrecord.activity, exception))
            throw new RuntimeException((new StringBuilder()).append("Unable to pause activity ").append(activityclientrecord.intent.getComponent().toShortString()).append(": ").append(exception.toString()).toString(), exception);
_L5:
        activityclientrecord.paused = true;
        ArrayList arraylist;
        synchronized(mOnPauseListeners) {
            arraylist = (ArrayList)mOnPauseListeners.remove(activityclientrecord.activity);
        }
        if(arraylist != null)
            i = arraylist.size();
        int j = 0;
        while(j < i)  {
            ((OnActivityPausedListener)arraylist.get(j)).onPaused(activityclientrecord.activity);
            j++;
        }
          goto _L6
        exception1;
        hashmap;
        JVM INSTR monitorexit ;
        throw exception1;
        exception;
        bundle = bundle1;
          goto _L7
        supernotcalledexception;
          goto _L8
    }

    final Bundle performPauseActivity(IBinder ibinder, boolean flag, boolean flag1) {
        ActivityClientRecord activityclientrecord = (ActivityClientRecord)mActivities.get(ibinder);
        Bundle bundle;
        if(activityclientrecord != null)
            bundle = performPauseActivity(activityclientrecord, flag, flag1);
        else
            bundle = null;
        return bundle;
    }

    final void performRestartActivity(IBinder ibinder) {
        ActivityClientRecord activityclientrecord = (ActivityClientRecord)mActivities.get(ibinder);
        if(activityclientrecord.stopped) {
            activityclientrecord.activity.performRestart();
            activityclientrecord.stopped = false;
        }
    }

    public final ActivityClientRecord performResumeActivity(IBinder ibinder, boolean flag) {
        ActivityClientRecord activityclientrecord = (ActivityClientRecord)mActivities.get(ibinder);
        if(activityclientrecord != null && !activityclientrecord.activity.mFinished) {
            if(flag) {
                activityclientrecord.hideForNow = false;
                activityclientrecord.activity.mStartedActivity = false;
            }
            try {
                if(activityclientrecord.pendingIntents != null) {
                    deliverNewIntents(activityclientrecord, activityclientrecord.pendingIntents);
                    activityclientrecord.pendingIntents = null;
                }
                if(activityclientrecord.pendingResults != null) {
                    deliverResults(activityclientrecord, activityclientrecord.pendingResults);
                    activityclientrecord.pendingResults = null;
                }
                activityclientrecord.activity.performResume();
                EventLog.writeEvent(30022, activityclientrecord.activity.getComponentName().getClassName());
                activityclientrecord.paused = false;
                activityclientrecord.stopped = false;
                activityclientrecord.state = null;
            }
            catch(Exception exception) {
                if(!mInstrumentation.onException(activityclientrecord.activity, exception))
                    throw new RuntimeException((new StringBuilder()).append("Unable to resume activity ").append(activityclientrecord.intent.getComponent().toShortString()).append(": ").append(exception.toString()).toString(), exception);
            }
        }
        return activityclientrecord;
    }

    final void performStopActivity(IBinder ibinder, boolean flag) {
        performStopActivityInner((ActivityClientRecord)mActivities.get(ibinder), null, false, flag);
    }

    final void performUserLeavingActivity(ActivityClientRecord activityclientrecord) {
        mInstrumentation.callActivityOnUserLeaving(activityclientrecord.activity);
    }

    public void registerOnActivityPausedListener(Activity activity, OnActivityPausedListener onactivitypausedlistener) {
        HashMap hashmap = mOnPauseListeners;
        hashmap;
        JVM INSTR monitorenter ;
        ArrayList arraylist = (ArrayList)mOnPauseListeners.get(activity);
        if(arraylist == null) {
            arraylist = new ArrayList();
            mOnPauseListeners.put(activity, arraylist);
        }
      