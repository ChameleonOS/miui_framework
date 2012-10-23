// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.*;
import android.content.pm.*;
import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.os.*;
import java.io.FileDescriptor;
import java.util.List;
import java.util.Map;

// Referenced classes of package android.app:
//            IInstrumentationWatcher

public interface IApplicationThread
    extends IInterface {

    public abstract void bindApplication(String s, ApplicationInfo applicationinfo, List list, ComponentName componentname, String s1, ParcelFileDescriptor parcelfiledescriptor, boolean flag, 
            Bundle bundle, IInstrumentationWatcher iinstrumentationwatcher, int i, boolean flag1, boolean flag2, boolean flag3, Configuration configuration, 
            CompatibilityInfo compatibilityinfo, Map map, Bundle bundle1) throws RemoteException;

    public abstract void clearDnsCache() throws RemoteException;

    public abstract void dispatchPackageBroadcast(int i, String as[]) throws RemoteException;

    public abstract void dumpActivity(FileDescriptor filedescriptor, IBinder ibinder, String s, String as[]) throws RemoteException;

    public abstract void dumpDbInfo(FileDescriptor filedescriptor, String as[]) throws RemoteException;

    public abstract void dumpGfxInfo(FileDescriptor filedescriptor, String as[]) throws RemoteException;

    public abstract void dumpHeap(boolean flag, String s, ParcelFileDescriptor parcelfiledescriptor) throws RemoteException;

    public abstract android.os.Debug.MemoryInfo dumpMemInfo(FileDescriptor filedescriptor, boolean flag, boolean flag1, String as[]) throws RemoteException;

    public abstract void dumpProvider(FileDescriptor filedescriptor, IBinder ibinder, String as[]) throws RemoteException;

    public abstract void dumpService(FileDescriptor filedescriptor, IBinder ibinder, String as[]) throws RemoteException;

    public abstract void getMemoryInfo(android.os.Debug.MemoryInfo memoryinfo) throws RemoteException;

    public abstract void processInBackground() throws RemoteException;

    public abstract void profilerControl(boolean flag, String s, ParcelFileDescriptor parcelfiledescriptor, int i) throws RemoteException;

    public abstract void requestThumbnail(IBinder ibinder) throws RemoteException;

    public abstract void scheduleActivityConfigurationChanged(IBinder ibinder) throws RemoteException;

    public abstract void scheduleBindService(IBinder ibinder, Intent intent, boolean flag) throws RemoteException;

    public abstract void scheduleConfigurationChanged(Configuration configuration) throws RemoteException;

    public abstract void scheduleCrash(String s) throws RemoteException;

    public abstract void scheduleCreateBackupAgent(ApplicationInfo applicationinfo, CompatibilityInfo compatibilityinfo, int i) throws RemoteException;

    public abstract void scheduleCreateService(IBinder ibinder, ServiceInfo serviceinfo, CompatibilityInfo compatibilityinfo) throws RemoteException;

    public abstract void scheduleDestroyActivity(IBinder ibinder, boolean flag, int i) throws RemoteException;

    public abstract void scheduleDestroyBackupAgent(ApplicationInfo applicationinfo, CompatibilityInfo compatibilityinfo) throws RemoteException;

    public abstract void scheduleExit() throws RemoteException;

    public abstract void scheduleLaunchActivity(Intent intent, IBinder ibinder, int i, ActivityInfo activityinfo, Configuration configuration, CompatibilityInfo compatibilityinfo, Bundle bundle, 
            List list, List list1, boolean flag, boolean flag1, String s, ParcelFileDescriptor parcelfiledescriptor, boolean flag2) throws RemoteException;

    public abstract void scheduleLowMemory() throws RemoteException;

    public abstract void scheduleNewIntent(List list, IBinder ibinder) throws RemoteException;

    public abstract void schedulePauseActivity(IBinder ibinder, boolean flag, boolean flag1, int i) throws RemoteException;

    public abstract void scheduleReceiver(Intent intent, ActivityInfo activityinfo, CompatibilityInfo compatibilityinfo, int i, String s, Bundle bundle, boolean flag) throws RemoteException;

    public abstract void scheduleRegisteredReceiver(IIntentReceiver iintentreceiver, Intent intent, int i, String s, Bundle bundle, boolean flag, boolean flag1) throws RemoteException;

    public abstract void scheduleRelaunchActivity(IBinder ibinder, List list, List list1, int i, boolean flag, Configuration configuration) throws RemoteException;

    public abstract void scheduleResumeActivity(IBinder ibinder, boolean flag) throws RemoteException;

    public abstract void scheduleSendResult(IBinder ibinder, List list) throws RemoteException;

    public abstract void scheduleServiceArgs(IBinder ibinder, boolean flag, int i, int j, Intent intent) throws RemoteException;

    public abstract void scheduleSleeping(IBinder ibinder, boolean flag) throws RemoteException;

    public abstract void scheduleStopActivity(IBinder ibinder, boolean flag, int i) throws RemoteException;

    public abstract void scheduleStopService(IBinder ibinder) throws RemoteException;

    public abstract void scheduleSuicide() throws RemoteException;

    public abstract void scheduleTrimMemory(int i) throws RemoteException;

    public abstract void scheduleUnbindService(IBinder ibinder, Intent intent) throws RemoteException;

    public abstract void scheduleWindowVisibility(IBinder ibinder, boolean flag) throws RemoteException;

    public abstract void setCoreSettings(Bundle bundle) throws RemoteException;

    public abstract void setHttpProxy(String s, String s1, String s2) throws RemoteException;

    public abstract void setSchedulingGroup(int i) throws RemoteException;

    public abstract void unstableProviderDied(IBinder ibinder) throws RemoteException;

    public abstract void updatePackageCompatibilityInfo(String s, CompatibilityInfo compatibilityinfo) throws RemoteException;

    public abstract void updateTimeZone() throws RemoteException;

    public static final int BACKUP_MODE_FULL = 1;
    public static final int BACKUP_MODE_INCREMENTAL = 0;
    public static final int BACKUP_MODE_RESTORE = 2;
    public static final int BACKUP_MODE_RESTORE_FULL = 3;
    public static final int BIND_APPLICATION_TRANSACTION = 13;
    public static final int CLEAR_DNS_CACHE_TRANSACTION = 38;
    public static final int DEBUG_OFF = 0;
    public static final int DEBUG_ON = 1;
    public static final int DEBUG_WAIT = 2;
    public static final int DISPATCH_PACKAGE_BROADCAST_TRANSACTION = 34;
    public static final int DUMP_ACTIVITY_TRANSACTION = 37;
    public static final int DUMP_DB_INFO_TRANSACTION = 46;
    public static final int DUMP_GFX_INFO_TRANSACTION = 44;
    public static final int DUMP_HEAP_TRANSACTION = 36;
    public static final int DUMP_MEM_INFO_TRANSACTION = 43;
    public static final int DUMP_PROVIDER_TRANSACTION = 45;
    public static final int DUMP_SERVICE_TRANSACTION = 22;
    public static final int EXTERNAL_STORAGE_UNAVAILABLE = 1;
    public static final int GET_MEMORY_INFO_TRANSACTION = 32;
    public static final int PACKAGE_REMOVED = 0;
    public static final int PROCESS_IN_BACKGROUND_TRANSACTION = 19;
    public static final int PROFILER_CONTROL_TRANSACTION = 28;
    public static final int REQUEST_THUMBNAIL_TRANSACTION = 15;
    public static final int SCHEDULE_ACTIVITY_CONFIGURATION_CHANGED_TRANSACTION = 25;
    public static final int SCHEDULE_BIND_SERVICE_TRANSACTION = 20;
    public static final int SCHEDULE_CONFIGURATION_CHANGED_TRANSACTION = 16;
    public static final int SCHEDULE_CRASH_TRANSACTION = 35;
    public static final int SCHEDULE_CREATE_BACKUP_AGENT_TRANSACTION = 30;
    public static final int SCHEDULE_CREATE_SERVICE_TRANSACTION = 11;
    public static final int SCHEDULE_DESTROY_BACKUP_AGENT_TRANSACTION = 31;
    public static final int SCHEDULE_EXIT_TRANSACTION = 14;
    public static final int SCHEDULE_FINISH_ACTIVITY_TRANSACTION = 9;
    public static final int SCHEDULE_LAUNCH_ACTIVITY_TRANSACTION = 7;
    public static final int SCHEDULE_LOW_MEMORY_TRANSACTION = 24;
    public static final int SCHEDULE_NEW_INTENT_TRANSACTION = 8;
    public static final int SCHEDULE_PAUSE_ACTIVITY_TRANSACTION = 1;
    public static final int SCHEDULE_RECEIVER_TRANSACTION = 10;
    public static final int SCHEDULE_REGISTERED_RECEIVER_TRANSACTION = 23;
    public static final int SCHEDULE_RELAUNCH_ACTIVITY_TRANSACTION = 26;
    public static final int SCHEDULE_RESUME_ACTIVITY_TRANSACTION = 5;
    public static final int SCHEDULE_SEND_RESULT_TRANSACTION = 6;
    public static final int SCHEDULE_SERVICE_ARGS_TRANSACTION = 17;
    public static final int SCHEDULE_SLEEPING_TRANSACTION = 27;
    public static final int SCHEDULE_STOP_ACTIVITY_TRANSACTION = 3;
    public static final int SCHEDULE_STOP_SERVICE_TRANSACTION = 12;
    public static final int SCHEDULE_SUICIDE_TRANSACTION = 33;
    public static final int SCHEDULE_TRIM_MEMORY_TRANSACTION = 42;
    public static final int SCHEDULE_UNBIND_SERVICE_TRANSACTION = 21;
    public static final int SCHEDULE_WINDOW_VISIBILITY_TRANSACTION = 4;
    public static final int SET_CORE_SETTINGS_TRANSACTION = 40;
    public static final int SET_HTTP_PROXY_TRANSACTION = 39;
    public static final int SET_SCHEDULING_GROUP_TRANSACTION = 29;
    public static final int UNSTABLE_PROVIDER_DIED_TRANSACTION = 47;
    public static final int UPDATE_PACKAGE_COMPATIBILITY_INFO_TRANSACTION = 41;
    public static final int UPDATE_TIME_ZONE_TRANSACTION = 18;
    public static final String descriptor = "android.app.IApplicationThread";
}
