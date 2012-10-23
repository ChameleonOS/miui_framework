// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.*;
import android.content.pm.*;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.*;
import java.util.List;

// Referenced classes of package android.app:
//            IApplicationThread, IServiceConnection, PendingIntent, IThumbnailReceiver, 
//            IProcessObserver, IActivityController, Notification, IInstrumentationWatcher

public interface IActivityManager
    extends IInterface {
    public static class WaitResult
        implements Parcelable {

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(result);
            int j;
            if(timeout)
                j = 1;
            else
                j = 0;
            parcel.writeInt(j);
            ComponentName.writeToParcel(who, parcel);
            parcel.writeLong(thisTime);
            parcel.writeLong(totalTime);
        }

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public WaitResult createFromParcel(Parcel parcel) {
                return new WaitResult(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            public WaitResult[] newArray(int i) {
                return new WaitResult[i];
            }

            public volatile Object[] newArray(int i) {
                return newArray(i);
            }

        };
        public int result;
        public long thisTime;
        public boolean timeout;
        public long totalTime;
        public ComponentName who;


        public WaitResult() {
        }

        private WaitResult(Parcel parcel) {
            result = parcel.readInt();
            boolean flag;
            if(parcel.readInt() != 0)
                flag = true;
            else
                flag = false;
            timeout = flag;
            who = ComponentName.readFromParcel(parcel);
            thisTime = parcel.readLong();
            totalTime = parcel.readLong();
        }

    }

    public static class ContentProviderHolder
        implements Parcelable {

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int j = 0;
            info.writeToParcel(parcel, 0);
            if(provider != null)
                parcel.writeStrongBinder(provider.asBinder());
            else
                parcel.writeStrongBinder(null);
            parcel.writeStrongBinder(connection);
            if(noReleaseNeeded)
                j = 1;
            parcel.writeInt(j);
        }

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public ContentProviderHolder createFromParcel(Parcel parcel) {
                return new ContentProviderHolder(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            public ContentProviderHolder[] newArray(int i) {
                return new ContentProviderHolder[i];
            }

            public volatile Object[] newArray(int i) {
                return newArray(i);
            }

        };
        public IBinder connection;
        public final ProviderInfo info;
        public boolean noReleaseNeeded;
        public IContentProvider provider;


        public ContentProviderHolder(ProviderInfo providerinfo) {
            info = providerinfo;
        }

        private ContentProviderHolder(Parcel parcel) {
            info = (ProviderInfo)ProviderInfo.CREATOR.createFromParcel(parcel);
            provider = ContentProviderNative.asInterface(parcel.readStrongBinder());
            connection = parcel.readStrongBinder();
            boolean flag;
            if(parcel.readInt() != 0)
                flag = true;
            else
                flag = false;
            noReleaseNeeded = flag;
        }

    }


    public abstract void activityDestroyed(IBinder ibinder) throws RemoteException;

    public abstract void activityIdle(IBinder ibinder, Configuration configuration, boolean flag) throws RemoteException;

    public abstract void activityPaused(IBinder ibinder) throws RemoteException;

    public abstract void activitySlept(IBinder ibinder) throws RemoteException;

    public abstract void activityStopped(IBinder ibinder, Bundle bundle, Bitmap bitmap, CharSequence charsequence) throws RemoteException;

    public abstract void attachApplication(IApplicationThread iapplicationthread) throws RemoteException;

    public abstract void backupAgentCreated(String s, IBinder ibinder) throws RemoteException;

    public abstract boolean bindBackupAgent(ApplicationInfo applicationinfo, int i) throws RemoteException;

    public abstract int bindService(IApplicationThread iapplicationthread, IBinder ibinder, Intent intent, String s, IServiceConnection iserviceconnection, int i, int j) throws RemoteException;

    public abstract int broadcastIntent(IApplicationThread iapplicationthread, Intent intent, String s, IIntentReceiver iintentreceiver, int i, String s1, Bundle bundle, 
            String s2, boolean flag, boolean flag1, int j) throws RemoteException;

    public abstract void cancelIntentSender(IIntentSender iintentsender) throws RemoteException;

    public abstract int checkGrantUriPermission(int i, String s, Uri uri, int j) throws RemoteException;

    public abstract int checkPermission(String s, int i, int j) throws RemoteException;

    public abstract int checkUriPermission(Uri uri, int i, int j, int k) throws RemoteException;

    public abstract boolean clearApplicationUserData(String s, IPackageDataObserver ipackagedataobserver, int i) throws RemoteException;

    public abstract void closeSystemDialogs(String s) throws RemoteException;

    public abstract void crashApplication(int i, int j, String s, String s1) throws RemoteException;

    public abstract void dismissKeyguardOnNextActivity() throws RemoteException;

    public abstract boolean dumpHeap(String s, boolean flag, String s1, ParcelFileDescriptor parcelfiledescriptor) throws RemoteException;

    public abstract void enterSafeMode() throws RemoteException;

    public abstract boolean finishActivity(IBinder ibinder, int i, Intent intent) throws RemoteException;

    public abstract boolean finishActivityAffinity(IBinder ibinder) throws RemoteException;

    public abstract void finishHeavyWeightApp() throws RemoteException;

    public abstract void finishInstrumentation(IApplicationThread iapplicationthread, int i, Bundle bundle) throws RemoteException;

    public abstract void finishReceiver(IBinder ibinder, int i, String s, Bundle bundle, boolean flag) throws RemoteException;

    public abstract void finishSubActivity(IBinder ibinder, String s, int i) throws RemoteException;

    public abstract void forceStopPackage(String s) throws RemoteException;

    public abstract ComponentName getActivityClassForToken(IBinder ibinder) throws RemoteException;

    public abstract ComponentName getCallingActivity(IBinder ibinder) throws RemoteException;

    public abstract String getCallingPackage(IBinder ibinder) throws RemoteException;

    public abstract Configuration getConfiguration() throws RemoteException;

    public abstract ContentProviderHolder getContentProvider(IApplicationThread iapplicationthread, String s, boolean flag) throws RemoteException;

    public abstract ContentProviderHolder getContentProviderExternal(String s, IBinder ibinder) throws RemoteException;

    public abstract UserInfo getCurrentUser() throws RemoteException;

    public abstract ConfigurationInfo getDeviceConfigurationInfo() throws RemoteException;

    public abstract int getFrontActivityScreenCompatMode() throws RemoteException;

    public abstract IIntentSender getIntentSender(int i, String s, IBinder ibinder, String s1, int j, Intent aintent[], String as[], 
            int k, Bundle bundle) throws RemoteException;

    public abstract int getLaunchedFromUid(IBinder ibinder) throws RemoteException;

    public abstract void getMemoryInfo(ActivityManager.MemoryInfo memoryinfo) throws RemoteException;

    public abstract void getMyMemoryState(ActivityManager.RunningAppProcessInfo runningappprocessinfo) throws RemoteException;

    public abstract boolean getPackageAskScreenCompat(String s) throws RemoteException;

    public abstract String getPackageForIntentSender(IIntentSender iintentsender) throws RemoteException;

    public abstract String getPackageForToken(IBinder ibinder) throws RemoteException;

    public abstract int getPackageScreenCompatMode(String s) throws RemoteException;

    public abstract int getProcessLimit() throws RemoteException;

    public abstract android.os.Debug.MemoryInfo[] getProcessMemoryInfo(int ai[]) throws RemoteException;

    public abstract long[] getProcessPss(int ai[]) throws RemoteException;

    public abstract List getProcessesInErrorState() throws RemoteException;

    public abstract String getProviderMimeType(Uri uri) throws RemoteException;

    public abstract List getRecentTasks(int i, int j) throws RemoteException;

    public abstract int getRequestedOrientation(IBinder ibinder) throws RemoteException;

    public abstract List getRunningAppProcesses() throws RemoteException;

    public abstract List getRunningExternalApplications() throws RemoteException;

    public abstract PendingIntent getRunningServiceControlPanel(ComponentName componentname) throws RemoteException;

    public abstract List getServices(int i, int j) throws RemoteException;

    public abstract int getTaskForActivity(IBinder ibinder, boolean flag) throws RemoteException;

    public abstract ActivityManager.TaskThumbnails getTaskThumbnails(int i) throws RemoteException;

    public abstract List getTasks(int i, int j, IThumbnailReceiver ithumbnailreceiver) throws RemoteException;

    public abstract int getUidForIntentSender(IIntentSender iintentsender) throws RemoteException;

    public abstract void goingToSleep() throws RemoteException;

    public abstract void grantUriPermission(IApplicationThread iapplicationthread, String s, Uri uri, int i) throws RemoteException;

    public abstract void grantUriPermissionFromOwner(IBinder ibinder, int i, String s, Uri uri, int j) throws RemoteException;

    public abstract void handleApplicationCrash(IBinder ibinder, ApplicationErrorReport.CrashInfo crashinfo) throws RemoteException;

    public abstract void handleApplicationStrictModeViolation(IBinder ibinder, int i, android.os.StrictMode.ViolationInfo violationinfo) throws RemoteException;

    public abstract boolean handleApplicationWtf(IBinder ibinder, String s, ApplicationErrorReport.CrashInfo crashinfo) throws RemoteException;

    public abstract boolean isImmersive(IBinder ibinder) throws RemoteException;

    public abstract boolean isIntentSenderAnActivity(IIntentSender iintentsender) throws RemoteException;

    public abstract boolean isIntentSenderTargetedToPackage(IIntentSender iintentsender) throws RemoteException;

    public abstract boolean isTopActivityImmersive() throws RemoteException;

    public abstract boolean isUserAMonkey() throws RemoteException;

    public abstract void killAllBackgroundProcesses() throws RemoteException;

    public abstract void killApplicationProcess(String s, int i) throws RemoteException;

    public abstract void killApplicationWithUid(String s, int i) throws RemoteException;

    public abstract void killBackgroundProcesses(String s) throws RemoteException;

    public abstract boolean killPids(int ai[], String s, boolean flag) throws RemoteException;

    public abstract boolean killProcessesBelowForeground(String s) throws RemoteException;

    public abstract boolean moveActivityTaskToBack(IBinder ibinder, boolean flag) throws RemoteException;

    public abstract void moveTaskBackwards(int i) throws RemoteException;

    public abstract void moveTaskToBack(int i) throws RemoteException;

    public abstract void moveTaskToFront(int i, int j, Bundle bundle) throws RemoteException;

    public abstract boolean navigateUpTo(IBinder ibinder, Intent intent, int i, Intent intent1) throws RemoteException;

    public abstract IBinder newUriPermissionOwner(String s) throws RemoteException;

    public abstract void noteWakeupAlarm(IIntentSender iintentsender) throws RemoteException;

    public abstract ParcelFileDescriptor openContentUri(Uri uri) throws RemoteException;

    public abstract void overridePendingTransition(IBinder ibinder, String s, int i, int j) throws RemoteException;

    public abstract IBinder peekService(Intent intent, String s) throws RemoteException;

    public abstract boolean profileControl(String s, boolean flag, String s1, ParcelFileDescriptor parcelfiledescriptor, int i) throws RemoteException;

    public abstract void publishContentProviders(IApplicationThread iapplicationthread, List list) throws RemoteException;

    public abstract void publishService(IBinder ibinder, Intent intent, IBinder ibinder1) throws RemoteException;

    public abstract boolean refContentProvider(IBinder ibinder, int i, int j) throws RemoteException;

    public abstract void registerProcessObserver(IProcessObserver iprocessobserver) throws RemoteException;

    public abstract Intent registerReceiver(IApplicationThread iapplicationthread, String s, IIntentReceiver iintentreceiver, IntentFilter intentfilter, String s1) throws RemoteException;

    public abstract void removeContentProvider(IBinder ibinder, boolean flag) throws RemoteException;

    public abstract void removeContentProviderExternal(String s, IBinder ibinder) throws RemoteException;

    public abstract boolean removeSubTask(int i, int j) throws RemoteException;

    public abstract boolean removeTask(int i, int j) throws RemoteException;

    public abstract void reportThumbnail(IBinder ibinder, Bitmap bitmap, CharSequence charsequence) throws RemoteException;

    public abstract void resumeAppSwitches() throws RemoteException;

    public abstract void revokeUriPermission(IApplicationThread iapplicationthread, Uri uri, int i) throws RemoteException;

    public abstract void revokeUriPermissionFromOwner(IBinder ibinder, Uri uri, int i) throws RemoteException;

    public abstract void serviceDoneExecuting(IBinder ibinder, int i, int j, int k) throws RemoteException;

    public abstract void setActivityController(IActivityController iactivitycontroller) throws RemoteException;

    public abstract void setAlwaysFinish(boolean flag) throws RemoteException;

    public abstract void setDebugApp(String s, boolean flag, boolean flag1) throws RemoteException;

    public abstract void setFrontActivityScreenCompatMode(int i) throws RemoteException;

    public abstract void setImmersive(IBinder ibinder, boolean flag) throws RemoteException;

    public abstract void setLockScreenShown(boolean flag) throws RemoteException;

    public abstract void setPackageAskScreenCompat(String s, boolean flag) throws RemoteException;

    public abstract void setPackageScreenCompatMode(String s, int i) throws RemoteException;

    public abstract void setProcessForeground(IBinder ibinder, int i, boolean flag) throws RemoteException;

    public abstract void setProcessLimit(int i) throws RemoteException;

    public abstract void setRequestedOrientation(IBinder ibinder, int i) throws RemoteException;

    public abstract void setServiceForeground(ComponentName componentname, IBinder ibinder, int i, Notification notification, boolean flag) throws RemoteException;

    public abstract void showBootMessage(CharSequence charsequence, boolean flag) throws RemoteException;

    public abstract void showWaitingForDebugger(IApplicationThread iapplicationthread, boolean flag) throws RemoteException;

    public abstract boolean shutdown(int i) throws RemoteException;

    public abstract void signalPersistentProcesses(int i) throws RemoteException;

    public abstract int startActivities(IApplicationThread iapplicationthread, Intent aintent[], String as[], IBinder ibinder, Bundle bundle) throws RemoteException;

    public abstract int startActivitiesInPackage(int i, Intent aintent[], String as[], IBinder ibinder, Bundle bundle) throws RemoteException;

    public abstract int startActivity(IApplicationThread iapplicationthread, Intent intent, String s, IBinder ibinder, String s1, int i, int j, 
            String s2, ParcelFileDescriptor parcelfiledescriptor, Bundle bundle) throws RemoteException;

    public abstract WaitResult startActivityAndWait(IApplicationThread iapplicationthread, Intent intent, String s, IBinder ibinder, String s1, int i, int j, 
            String s2, ParcelFileDescriptor parcelfiledescriptor, Bundle bundle) throws RemoteException;

    public abstract int startActivityInPackage(int i, Intent intent, String s, IBinder ibinder, String s1, int j, int k, 
            Bundle bundle) throws RemoteException;

    public abstract int startActivityIntentSender(IApplicationThread iapplicationthread, IntentSender intentsender, Intent intent, String s, IBinder ibinder, String s1, int i, 
            int j, int k, Bundle bundle) throws RemoteException;

    public abstract int startActivityWithConfig(IApplicationThread iapplicationthread, Intent intent, String s, IBinder ibinder, String s1, int i, int j, 
            Configuration configuration, Bundle bundle) throws RemoteException;

    public abstract boolean startInstrumentation(ComponentName componentname, String s, int i, Bundle bundle, IInstrumentationWatcher iinstrumentationwatcher) throws RemoteException;

    public abstract boolean startNextMatchingActivity(IBinder ibinder, Intent intent, Bundle bundle) throws RemoteException;

    public abstract void startRunning(String s, String s1, String s2, String s3) throws RemoteException;

    public abstract ComponentName startService(IApplicationThread iapplicationthread, Intent intent, String s) throws RemoteException;

    public abstract void stopAppSwitches() throws RemoteException;

    public abstract int stopService(IApplicationThread iapplicationthread, Intent intent, String s) throws RemoteException;

    public abstract boolean stopServiceToken(ComponentName componentname, IBinder ibinder, int i) throws RemoteException;

    public abstract boolean switchUser(int i) throws RemoteException;

    public abstract boolean targetTaskAffinityMatchesActivity(IBinder ibinder, String s) throws RemoteException;

    public abstract boolean testIsSystemReady();

    public abstract void unbindBackupAgent(ApplicationInfo applicationinfo) throws RemoteException;

    public abstract void unbindFinished(IBinder ibinder, Intent intent, boolean flag) throws RemoteException;

    public abstract boolean unbindService(IServiceConnection iserviceconnection) throws RemoteException;

    public abstract void unbroadcastIntent(IApplicationThread iapplicationthread, Intent intent, int i) throws RemoteException;

    public abstract void unhandledBack() throws RemoteException;

    public abstract void unregisterProcessObserver(IProcessObserver iprocessobserver) throws RemoteException;

    public abstract void unregisterReceiver(IIntentReceiver iintentreceiver) throws RemoteException;

    public abstract void unstableProviderDied(IBinder ibinder) throws RemoteException;

    public abstract void updateConfiguration(Configuration configuration) throws RemoteException;

    public abstract void updatePersistentConfiguration(Configuration configuration) throws RemoteException;

    public abstract void wakingUp() throws RemoteException;

    public abstract boolean willActivityBeVisible(IBinder ibinder) throws RemoteException;

    public static final int ACTIVITY_DESTROYED_TRANSACTION = 62;
    public static final int ACTIVITY_IDLE_TRANSACTION = 18;
    public static final int ACTIVITY_PAUSED_TRANSACTION = 19;
    public static final int ACTIVITY_SLEPT_TRANSACTION = 123;
    public static final int ACTIVITY_STOPPED_TRANSACTION = 20;
    public static final int ATTACH_APPLICATION_TRANSACTION = 17;
    public static final int BACKUP_AGENT_CREATED_TRANSACTION = 91;
    public static final int BIND_SERVICE_TRANSACTION = 36;
    public static final int BROADCAST_INTENT_TRANSACTION = 14;
    public static final int CANCEL_INTENT_SENDER_TRANSACTION = 64;
    public static final int CHECK_GRANT_URI_PERMISSION_TRANSACTION = 119;
    public static final int CHECK_PERMISSION_TRANSACTION = 53;
    public static final int CHECK_URI_PERMISSION_TRANSACTION = 54;
    public static final int CLEAR_APP_DATA_TRANSACTION = 78;
    public static final int CLOSE_SYSTEM_DIALOGS_TRANSACTION = 97;
    public static final int CRASH_APPLICATION_TRANSACTION = 114;
    public static final int DISMISS_KEYGUARD_ON_NEXT_ACTIVITY_TRANSACTION = 139;
    public static final int DUMP_HEAP_TRANSACTION = 120;
    public static final int ENTER_SAFE_MODE_TRANSACTION = 66;
    public static final int FINISH_ACTIVITY_AFFINITY_TRANSACTION = 149;
    public static final int FINISH_ACTIVITY_TRANSACTION = 11;
    public static final int FINISH_HEAVY_WEIGHT_APP_TRANSACTION = 109;
    public static final int FINISH_INSTRUMENTATION_TRANSACTION = 45;
    public static final int FINISH_RECEIVER_TRANSACTION = 16;
    public static final int FINISH_SUB_ACTIVITY_TRANSACTION = 32;
    public static final int FORCE_STOP_PACKAGE_TRANSACTION = 79;
    public static final int GET_ACTIVITY_CLASS_FOR_TOKEN_TRANSACTION = 49;
    public static final int GET_CALLING_ACTIVITY_TRANSACTION = 22;
    public static final int GET_CALLING_PACKAGE_TRANSACTION = 21;
    public static final int GET_CONFIGURATION_TRANSACTION = 46;
    public static final int GET_CONTENT_PROVIDER_EXTERNAL_TRANSACTION = 141;
    public static final int GET_CONTENT_PROVIDER_TRANSACTION = 29;
    public static final int GET_CURRENT_USER_TRANSACTION = 145;
    public static final int GET_DEVICE_CONFIGURATION_TRANSACTION = 84;
    public static final int GET_FRONT_ACTIVITY_SCREEN_COMPAT_MODE_TRANSACTION = 124;
    public static final int GET_INTENT_SENDER_TRANSACTION = 63;
    public static final int GET_LAUNCHED_FROM_UID_TRANSACTION = 150;
    public static final int GET_MEMORY_INFO_TRANSACTION = 76;
    public static final int GET_MY_MEMORY_STATE_TRANSACTION = 143;
    public static final int GET_PACKAGE_ASK_SCREEN_COMPAT_TRANSACTION = 128;
    public static final int GET_PACKAGE_FOR_INTENT_SENDER_TRANSACTION = 65;
    public static final int GET_PACKAGE_FOR_TOKEN_TRANSACTION = 50;
    public static final int GET_PACKAGE_SCREEN_COMPAT_MODE_TRANSACTION = 126;
    public static final int GET_PROCESSES_IN_ERROR_STATE_TRANSACTION = 77;
    public static final int GET_PROCESS_LIMIT_TRANSACTION = 52;
    public static final int GET_PROCESS_MEMORY_INFO_TRANSACTION = 98;
    public static final int GET_PROCESS_PSS_TRANSACTION = 137;
    public static final int GET_PROVIDER_MIME_TYPE_TRANSACTION = 115;
    public static final int GET_RECENT_TASKS_TRANSACTION = 60;
    public static final int GET_REQUESTED_ORIENTATION_TRANSACTION = 71;
    public static final int GET_RUNNING_APP_PROCESSES_TRANSACTION = 83;
    public static final int GET_RUNNING_EXTERNAL_APPLICATIONS_TRANSACTION = 108;
    public static final int GET_RUNNING_SERVICE_CONTROL_PANEL_TRANSACTION = 33;
    public static final int GET_SERVICES_TRANSACTION = 81;
    public static final int GET_TASKS_TRANSACTION = 23;
    public static final int GET_TASK_FOR_ACTIVITY_TRANSACTION = 27;
    public static final int GET_TASK_THUMBNAILS_TRANSACTION = 82;
    public static final int GET_UID_FOR_INTENT_SENDER_TRANSACTION = 93;
    public static final int GOING_TO_SLEEP_TRANSACTION = 40;
    public static final int GRANT_URI_PERMISSION_FROM_OWNER_TRANSACTION = 117;
    public static final int GRANT_URI_PERMISSION_TRANSACTION = 55;
    public static final int HANDLE_APPLICATION_CRASH_TRANSACTION = 2;
    public static final int HANDLE_APPLICATION_STRICT_MODE_VIOLATION_TRANSACTION = 110;
    public static final int HANDLE_APPLICATION_WTF_TRANSACTION = 102;
    public static final int IS_IMMERSIVE_TRANSACTION = 111;
    public static final int IS_INTENT_SENDER_AN_ACTIVITY_TRANSACTION = 152;
    public static final int IS_INTENT_SENDER_TARGETED_TO_PACKAGE_TRANSACTION = 135;
    public static final int IS_TOP_ACTIVITY_IMMERSIVE_TRANSACTION = 113;
    public static final int IS_USER_A_MONKEY_TRANSACTION = 104;
    public static final int KILL_ALL_BACKGROUND_PROCESSES_TRANSACTION = 140;
    public static final int KILL_APPLICATION_PROCESS_TRANSACTION = 99;
    public static final int KILL_APPLICATION_WITH_UID_TRANSACTION = 96;
    public static final int KILL_BACKGROUND_PROCESSES_TRANSACTION = 103;
    public static final int KILL_PIDS_TRANSACTION = 80;
    public static final int KILL_PROCESSES_BELOW_FOREGROUND_TRANSACTION = 144;
    public static final int MOVE_ACTIVITY_TASK_TO_BACK_TRANSACTION = 75;
    public static final int MOVE_TASK_BACKWARDS_TRANSACTION = 26;
    public static final int MOVE_TASK_TO_BACK_TRANSACTION = 25;
    public static final int MOVE_TASK_TO_FRONT_TRANSACTION = 24;
    public static final int NAVIGATE_UP_TO_TRANSACTION = 147;
    public static final int NEW_URI_PERMISSION_OWNER_TRANSACTION = 116;
    public static final int NOTE_WAKEUP_ALARM_TRANSACTION = 68;
    public static final int OPEN_CONTENT_URI_TRANSACTION = 5;
    public static final int OVERRIDE_PENDING_TRANSITION_TRANSACTION = 101;
    public static final int PEEK_SERVICE_TRANSACTION = 85;
    public static final int PROFILE_CONTROL_TRANSACTION = 86;
    public static final int PUBLISH_CONTENT_PROVIDERS_TRANSACTION = 30;
    public static final int PUBLISH_SERVICE_TRANSACTION = 38;
    public static final int REF_CONTENT_PROVIDER_TRANSACTION = 31;
    public static final int REGISTER_PROCESS_OBSERVER_TRANSACTION = 133;
    public static final int REGISTER_RECEIVER_TRANSACTION = 12;
    public static final int REMOVE_CONTENT_PROVIDER_EXTERNAL_TRANSACTION = 142;
    public static final int REMOVE_CONTENT_PROVIDER_TRANSACTION = 69;
    public static final int REMOVE_SUB_TASK_TRANSACTION = 131;
    public static final int REMOVE_TASK_TRANSACTION = 132;
    public static final int REPORT_THUMBNAIL_TRANSACTION = 28;
    public static final int RESUME_APP_SWITCHES_TRANSACTION = 89;
    public static final int REVOKE_URI_PERMISSION_FROM_OWNER_TRANSACTION = 118;
    public static final int REVOKE_URI_PERMISSION_TRANSACTION = 56;
    public static final int SERVICE_DONE_EXECUTING_TRANSACTION = 61;
    public static final int SET_ACTIVITY_CONTROLLER_TRANSACTION = 57;
    public static final int SET_ALWAYS_FINISH_TRANSACTION = 43;
    public static final int SET_DEBUG_APP_TRANSACTION = 42;
    public static final int SET_FRONT_ACTIVITY_SCREEN_COMPAT_MODE_TRANSACTION = 125;
    public static final int SET_IMMERSIVE_TRANSACTION = 112;
    public static final int SET_LOCK_SCREEN_SHOWN_TRANSACTION = 148;
    public static final int SET_PACKAGE_ASK_SCREEN_COMPAT_TRANSACTION = 129;
    public static final int SET_PACKAGE_SCREEN_COMPAT_MODE_TRANSACTION = 127;
    public static final int SET_PROCESS_FOREGROUND_TRANSACTION = 73;
    public static final int SET_PROCESS_LIMIT_TRANSACTION = 51;
    public static final int SET_REQUESTED_ORIENTATION_TRANSACTION = 70;
    public static final int SET_SERVICE_FOREGROUND_TRANSACTION = 74;
    public static final int SHOW_BOOT_MESSAGE_TRANSACTION = 138;
    public static final int SHOW_WAITING_FOR_DEBUGGER_TRANSACTION = 58;
    public static final int SHUTDOWN_TRANSACTION = 87;
    public static final int SIGNAL_PERSISTENT_PROCESSES_TRANSACTION = 59;
    public static final int START_ACTIVITIES_IN_PACKAGE_TRANSACTION = 122;
    public static final int START_ACTIVITIES_TRANSACTION = 121;
    public static final int START_ACTIVITY_AND_WAIT_TRANSACTION = 105;
    public static final int START_ACTIVITY_INTENT_SENDER_TRANSACTION = 100;
    public static final int START_ACTIVITY_IN_PACKAGE_TRANSACTION = 95;
    public static final int START_ACTIVITY_TRANSACTION = 3;
    public static final int START_ACTIVITY_WITH_CONFIG_TRANSACTION = 107;
    public static final int START_BACKUP_AGENT_TRANSACTION = 90;
    public static final int START_INSTRUMENTATION_TRANSACTION = 44;
    public static final int START_NEXT_MATCHING_ACTIVITY_TRANSACTION = 67;
    public static final int START_RUNNING_TRANSACTION = 1;
    public static final int START_SERVICE_TRANSACTION = 34;
    public static final int STOP_APP_SWITCHES_TRANSACTION = 88;
    public static final int STOP_SERVICE_TOKEN_TRANSACTION = 48;
    public static final int STOP_SERVICE_TRANSACTION = 35;
    public static final int SWITCH_USER_TRANSACTION = 130;
    public static final int TARGET_TASK_AFFINITY_MATCHES_ACTIVITY_TRANSACTION = 146;
    public static final int UNBIND_BACKUP_AGENT_TRANSACTION = 92;
    public static final int UNBIND_FINISHED_TRANSACTION = 72;
    public static final int UNBIND_SERVICE_TRANSACTION = 37;
    public static final int UNBROADCAST_INTENT_TRANSACTION = 15;
    public static final int UNHANDLED_BACK_TRANSACTION = 4;
    public static final int UNREGISTER_PROCESS_OBSERVER_TRANSACTION = 134;
    public static final int UNREGISTER_RECEIVER_TRANSACTION = 13;
    public static final int UNSTABLE_PROVIDER_DIED_TRANSACTION = 151;
    public static final int UPDATE_CONFIGURATION_TRANSACTION = 47;
    public static final int UPDATE_PERSISTENT_CONFIGURATION_TRANSACTION = 136;
    public static final int WAKING_UP_TRANSACTION = 41;
    public static final int WILL_ACTIVITY_BE_VISIBLE_TRANSACTION = 106;
    public static final String descriptor = "android.app.IActivityManager";
}
