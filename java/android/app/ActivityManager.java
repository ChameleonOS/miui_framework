// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.*;
import android.content.pm.*;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.*;
import android.text.TextUtils;
import android.util.*;
import android.view.Display;
import com.android.internal.app.IUsageStats;
import com.android.internal.os.PkgUsageStats;
import com.android.internal.util.MemInfoReader;
import java.util.*;

// Referenced classes of package android.app:
//            AppGlobals, ActivityManagerNative, IActivityManager, ExtraActivityManager, 
//            PendingIntent, IThumbnailReceiver, IThumbnailRetriever

public class ActivityManager {
    public static class RunningAppProcessInfo
        implements Parcelable {

        public int describeContents() {
            return 0;
        }

        public void readFromParcel(Parcel parcel) {
            processName = parcel.readString();
            pid = parcel.readInt();
            uid = parcel.readInt();
            pkgList = parcel.readStringArray();
            flags = parcel.readInt();
            lastTrimLevel = parcel.readInt();
            importance = parcel.readInt();
            lru = parcel.readInt();
            importanceReasonCode = parcel.readInt();
            importanceReasonPid = parcel.readInt();
            importanceReasonComponent = ComponentName.readFromParcel(parcel);
            importanceReasonImportance = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(processName);
            parcel.writeInt(pid);
            parcel.writeInt(uid);
            parcel.writeStringArray(pkgList);
            parcel.writeInt(flags);
            parcel.writeInt(lastTrimLevel);
            parcel.writeInt(importance);
            parcel.writeInt(lru);
            parcel.writeInt(importanceReasonCode);
            parcel.writeInt(importanceReasonPid);
            ComponentName.writeToParcel(importanceReasonComponent, parcel);
            parcel.writeInt(importanceReasonImportance);
        }

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public RunningAppProcessInfo createFromParcel(Parcel parcel) {
                return new RunningAppProcessInfo(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            public RunningAppProcessInfo[] newArray(int i) {
                return new RunningAppProcessInfo[i];
            }

            public volatile Object[] newArray(int i) {
                return newArray(i);
            }

        };
        public static final int FLAG_CANT_SAVE_STATE = 1;
        public static final int FLAG_PERSISTENT = 2;
        public static final int IMPORTANCE_BACKGROUND = 400;
        public static final int IMPORTANCE_CANT_SAVE_STATE = 170;
        public static final int IMPORTANCE_EMPTY = 500;
        public static final int IMPORTANCE_FOREGROUND = 100;
        public static final int IMPORTANCE_PERCEPTIBLE = 130;
        public static final int IMPORTANCE_PERSISTENT = 50;
        public static final int IMPORTANCE_SERVICE = 300;
        public static final int IMPORTANCE_VISIBLE = 200;
        public static final int REASON_PROVIDER_IN_USE = 1;
        public static final int REASON_SERVICE_IN_USE = 2;
        public static final int REASON_UNKNOWN;
        public int flags;
        public int importance;
        public int importanceReasonCode;
        public ComponentName importanceReasonComponent;
        public int importanceReasonImportance;
        public int importanceReasonPid;
        public int lastTrimLevel;
        public int lru;
        public int pid;
        public String pkgList[];
        public String processName;
        public int uid;


        public RunningAppProcessInfo() {
            importance = 100;
            importanceReasonCode = 0;
        }

        private RunningAppProcessInfo(Parcel parcel) {
            readFromParcel(parcel);
        }


        public RunningAppProcessInfo(String s, int i, String as[]) {
            processName = s;
            pid = i;
            pkgList = as;
        }
    }

    public static class ProcessErrorStateInfo
        implements Parcelable {

        public int describeContents() {
            return 0;
        }

        public void readFromParcel(Parcel parcel) {
            condition = parcel.readInt();
            processName = parcel.readString();
            pid = parcel.readInt();
            uid = parcel.readInt();
            tag = parcel.readString();
            shortMsg = parcel.readString();
            longMsg = parcel.readString();
            stackTrace = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(condition);
            parcel.writeString(processName);
            parcel.writeInt(pid);
            parcel.writeInt(uid);
            parcel.writeString(tag);
            parcel.writeString(shortMsg);
            parcel.writeString(longMsg);
            parcel.writeString(stackTrace);
        }

        public static final int CRASHED = 1;
        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public ProcessErrorStateInfo createFromParcel(Parcel parcel) {
                return new ProcessErrorStateInfo(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            public ProcessErrorStateInfo[] newArray(int i) {
                return new ProcessErrorStateInfo[i];
            }

            public volatile Object[] newArray(int i) {
                return newArray(i);
            }

        };
        public static final int NOT_RESPONDING = 2;
        public static final int NO_ERROR;
        public int condition;
        public byte crashData[];
        public String longMsg;
        public int pid;
        public String processName;
        public String shortMsg;
        public String stackTrace;
        public String tag;
        public int uid;


        public ProcessErrorStateInfo() {
            crashData = null;
        }

        private ProcessErrorStateInfo(Parcel parcel) {
            crashData = null;
            readFromParcel(parcel);
        }

    }

    public static class MemoryInfo
        implements Parcelable {

        public int describeContents() {
            return 0;
        }

        public void readFromParcel(Parcel parcel) {
            availMem = parcel.readLong();
            totalMem = parcel.readLong();
            threshold = parcel.readLong();
            boolean flag;
            if(parcel.readInt() != 0)
                flag = true;
            else
                flag = false;
            lowMemory = flag;
            hiddenAppThreshold = parcel.readLong();
            secondaryServerThreshold = parcel.readLong();
            visibleAppThreshold = parcel.readLong();
            foregroundAppThreshold = parcel.readLong();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(availMem);
            parcel.writeLong(totalMem);
            parcel.writeLong(threshold);
            int j;
            if(lowMemory)
                j = 1;
            else
                j = 0;
            parcel.writeInt(j);
            parcel.writeLong(hiddenAppThreshold);
            parcel.writeLong(secondaryServerThreshold);
            parcel.writeLong(visibleAppThreshold);
            parcel.writeLong(foregroundAppThreshold);
        }

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public MemoryInfo createFromParcel(Parcel parcel) {
                return new MemoryInfo(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            public MemoryInfo[] newArray(int i) {
                return new MemoryInfo[i];
            }

            public volatile Object[] newArray(int i) {
                return newArray(i);
            }

        };
        public long availMem;
        public long foregroundAppThreshold;
        public long hiddenAppThreshold;
        public boolean lowMemory;
        public long secondaryServerThreshold;
        public long threshold;
        public long totalMem;
        public long visibleAppThreshold;


        public MemoryInfo() {
        }

        private MemoryInfo(Parcel parcel) {
            readFromParcel(parcel);
        }

    }

    public static class RunningServiceInfo
        implements Parcelable {

        public int describeContents() {
            return 0;
        }

        public void readFromParcel(Parcel parcel) {
            boolean flag = true;
            service = ComponentName.readFromParcel(parcel);
            pid = parcel.readInt();
            uid = parcel.readInt();
            process = parcel.readString();
            boolean flag1;
            if(parcel.readInt() != 0)
                flag1 = flag;
            else
                flag1 = false;
            foreground = flag1;
            activeSince = parcel.readLong();
            if(parcel.readInt() == 0)
                flag = false;
            started = flag;
            clientCount = parcel.readInt();
            crashCount = parcel.readInt();
            lastActivityTime = parcel.readLong();
            restarting = parcel.readLong();
            flags = parcel.readInt();
            clientPackage = parcel.readString();
            clientLabel = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            int j = 1;
            ComponentName.writeToParcel(service, parcel);
            parcel.writeInt(pid);
            parcel.writeInt(uid);
            parcel.writeString(process);
            int k;
            if(foreground)
                k = j;
            else
                k = 0;
            parcel.writeInt(k);
            parcel.writeLong(activeSince);
            if(!started)
                j = 0;
            parcel.writeInt(j);
            parcel.writeInt(clientCount);
            parcel.writeInt(crashCount);
            parcel.writeLong(lastActivityTime);
            parcel.writeLong(restarting);
            parcel.writeInt(flags);
            parcel.writeString(clientPackage);
            parcel.writeInt(clientLabel);
        }

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public RunningServiceInfo createFromParcel(Parcel parcel) {
                return new RunningServiceInfo(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            public RunningServiceInfo[] newArray(int i) {
                return new RunningServiceInfo[i];
            }

            public volatile Object[] newArray(int i) {
                return newArray(i);
            }

        };
        public static final int FLAG_FOREGROUND = 2;
        public static final int FLAG_PERSISTENT_PROCESS = 8;
        public static final int FLAG_STARTED = 1;
        public static final int FLAG_SYSTEM_PROCESS = 4;
        public long activeSince;
        public int clientCount;
        public int clientLabel;
        public String clientPackage;
        public int crashCount;
        public int flags;
        public boolean foreground;
        public long lastActivityTime;
        public int pid;
        public String process;
        public long restarting;
        public ComponentName service;
        public boolean started;
        public int uid;


        public RunningServiceInfo() {
        }

        private RunningServiceInfo(Parcel parcel) {
            readFromParcel(parcel);
        }

    }

    public static class TaskThumbnails
        implements Parcelable {

        public int describeContents() {
            return 0;
        }

        public Bitmap getSubThumbnail(int i) {
            Bitmap bitmap1 = retriever.getThumbnail(i);
            Bitmap bitmap = bitmap1;
_L2:
            return bitmap;
            RemoteException remoteexception;
            remoteexception;
            bitmap = null;
            if(true) goto _L2; else goto _L1
_L1:
        }

        public void readFromParcel(Parcel parcel) {
            if(parcel.readInt() != 0)
                mainThumbnail = (Bitmap)Bitmap.CREATOR.createFromParcel(parcel);
            else
                mainThumbnail = null;
            numSubThumbbails = parcel.readInt();
            retriever = IThumbnailRetriever.Stub.asInterface(parcel.readStrongBinder());
        }

        public void writeToParcel(Parcel parcel, int i) {
            if(mainThumbnail != null) {
                parcel.writeInt(1);
                mainThumbnail.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeInt(numSubThumbbails);
            parcel.writeStrongInterface(retriever);
        }

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public TaskThumbnails createFromParcel(Parcel parcel) {
                return new TaskThumbnails(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            public TaskThumbnails[] newArray(int i) {
                return new TaskThumbnails[i];
            }

            public volatile Object[] newArray(int i) {
                return newArray(i);
            }

        };
        public Bitmap mainThumbnail;
        public int numSubThumbbails;
        public IThumbnailRetriever retriever;


        public TaskThumbnails() {
        }

        private TaskThumbnails(Parcel parcel) {
            readFromParcel(parcel);
        }

    }

    public static class RunningTaskInfo
        implements Parcelable {

        public int describeContents() {
            return 0;
        }

        public void readFromParcel(Parcel parcel) {
            id = parcel.readInt();
            baseActivity = ComponentName.readFromParcel(parcel);
            topActivity = ComponentName.readFromParcel(parcel);
            if(parcel.readInt() != 0)
                thumbnail = (Bitmap)Bitmap.CREATOR.createFromParcel(parcel);
            else
                thumbnail = null;
            description = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            numActivities = parcel.readInt();
            numRunning = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(id);
            ComponentName.writeToParcel(baseActivity, parcel);
            ComponentName.writeToParcel(topActivity, parcel);
            if(thumbnail != null) {
                parcel.writeInt(1);
                thumbnail.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            TextUtils.writeToParcel(description, parcel, 1);
            parcel.writeInt(numActivities);
            parcel.writeInt(numRunning);
        }

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public RunningTaskInfo createFromParcel(Parcel parcel) {
                return new RunningTaskInfo(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            public RunningTaskInfo[] newArray(int i) {
                return new RunningTaskInfo[i];
            }

            public volatile Object[] newArray(int i) {
                return newArray(i);
            }

        };
        public ComponentName baseActivity;
        public CharSequence description;
        public int id;
        public int numActivities;
        public int numRunning;
        public Bitmap thumbnail;
        public ComponentName topActivity;


        public RunningTaskInfo() {
        }

        private RunningTaskInfo(Parcel parcel) {
            readFromParcel(parcel);
        }

    }

    public static class RecentTaskInfo
        implements Parcelable {

        public int describeContents() {
            return 0;
        }

        public void readFromParcel(Parcel parcel) {
            id = parcel.readInt();
            persistentId = parcel.readInt();
            if(parcel.readInt() != 0)
                baseIntent = (Intent)Intent.CREATOR.createFromParcel(parcel);
            else
                baseIntent = null;
            origActivity = ComponentName.readFromParcel(parcel);
            description = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(id);
            parcel.writeInt(persistentId);
            if(baseIntent != null) {
                parcel.writeInt(1);
                baseIntent.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            ComponentName.writeToParcel(origActivity, parcel);
            TextUtils.writeToParcel(description, parcel, 1);
        }

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public RecentTaskInfo createFromParcel(Parcel parcel) {
                return new RecentTaskInfo(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            public RecentTaskInfo[] newArray(int i) {
                return new RecentTaskInfo[i];
            }

            public volatile Object[] newArray(int i) {
                return newArray(i);
            }

        };
        public Intent baseIntent;
        public CharSequence description;
        public int id;
        public ComponentName origActivity;
        public int persistentId;


        public RecentTaskInfo() {
        }

        private RecentTaskInfo(Parcel parcel) {
            readFromParcel(parcel);
        }

    }


    ActivityManager(Context context, Handler handler) {
        mContext = context;
        mHandler = handler;
    }

    public static int checkComponentPermission(String s, int i, int j, boolean flag) {
        int k = -1;
        if(i != 0 && i != 1000) goto _L2; else goto _L1
_L1:
        k = 0;
_L4:
        return k;
_L2:
        if(UserId.isIsolated(i))
            continue; /* Loop/switch isn't completed */
        if(j >= 0 && UserId.isSameApp(i, j)) {
            k = 0;
            continue; /* Loop/switch isn't completed */
        }
        if(!flag) {
            Slog.w(TAG, (new StringBuilder()).append("Permission denied: checkComponentPermission() owningUid=").append(j).toString());
            continue; /* Loop/switch isn't completed */
        }
        if(s == null) {
            k = 0;
            continue; /* Loop/switch isn't completed */
        }
        int l = AppGlobals.getPackageManager().checkUidPermission(s, i);
        k = l;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        Slog.e(TAG, "PackageManager is dead?!?", remoteexception);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static void getMyMemoryState(RunningAppProcessInfo runningappprocessinfo) {
        ActivityManagerNative.getDefault().getMyMemoryState(runningappprocessinfo);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static boolean isHighEndGfx(Display display) {
        boolean flag;
        MemInfoReader meminforeader;
        flag = true;
        meminforeader = new MemInfoReader();
        meminforeader.readMemInfo();
        if(meminforeader.getTotalSize() < 0x20000000L) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        Point point = new Point();
        display.getRealSize(point);
        if(point.x * point.y < 0x96000)
            flag = ExtraActivityManager.isHighEndGfx(display);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static boolean isLargeRAM() {
        MemInfoReader meminforeader = new MemInfoReader();
        meminforeader.readMemInfo();
        boolean flag;
        if(meminforeader.getTotalSize() >= 0x28000000L)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isRunningInTestHarness() {
        return SystemProperties.getBoolean("ro.test_harness", false);
    }

    public static boolean isUserAMonkey() {
        boolean flag1 = ActivityManagerNative.getDefault().isUserAMonkey();
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static int staticGetLargeMemoryClass() {
        String s = SystemProperties.get("dalvik.vm.heapsize", "16m");
        return Integer.parseInt(s.substring(0, -1 + s.length()));
    }

    public static int staticGetMemoryClass() {
        String s = SystemProperties.get("dalvik.vm.heapgrowthlimit", "");
        int i;
        if(s != null && !"".equals(s))
            i = Integer.parseInt(s.substring(0, -1 + s.length()));
        else
            i = staticGetLargeMemoryClass();
        return i;
    }

    public boolean clearApplicationUserData(String s, IPackageDataObserver ipackagedataobserver) {
        boolean flag1 = ActivityManagerNative.getDefault().clearApplicationUserData(s, ipackagedataobserver, Binder.getOrigCallingUser());
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void forceStopPackage(String s) {
        ActivityManagerNative.getDefault().forceStopPackage(s);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public Map getAllPackageLaunchCounts() {
        HashMap hashmap;
        PkgUsageStats apkgusagestats[];
        try {
            IUsageStats iusagestats = com.android.internal.app.IUsageStats.Stub.asInterface(ServiceManager.getService("usagestats"));
            if(iusagestats == null) {
                hashmap = new HashMap();
                break MISSING_BLOCK_LABEL_131;
            }
            apkgusagestats = iusagestats.getAllPkgUsageStats();
            if(apkgusagestats == null) {
                hashmap = new HashMap();
                break MISSING_BLOCK_LABEL_131;
            }
        }
        catch(RemoteException remoteexception) {
            Log.w(TAG, "Could not query launch counts", remoteexception);
            hashmap = new HashMap();
            break MISSING_BLOCK_LABEL_131;
        }
        int i;
        int j;
        hashmap = new HashMap();
        i = apkgusagestats.length;
        j = 0;
_L1:
        if(j >= i)
            break MISSING_BLOCK_LABEL_131;
        PkgUsageStats pkgusagestats = apkgusagestats[j];
        hashmap.put(pkgusagestats.packageName, Integer.valueOf(pkgusagestats.launchCount));
        j++;
          goto _L1
        return hashmap;
    }

    public PkgUsageStats[] getAllPackageUsageStats() {
        IUsageStats iusagestats = com.android.internal.app.IUsageStats.Stub.asInterface(ServiceManager.getService("usagestats"));
        if(iusagestats == null) goto _L2; else goto _L1
_L1:
        PkgUsageStats apkgusagestats1[] = iusagestats.getAllPkgUsageStats();
        PkgUsageStats apkgusagestats[] = apkgusagestats1;
_L4:
        return apkgusagestats;
        RemoteException remoteexception;
        remoteexception;
        Log.w(TAG, "Could not query usage stats", remoteexception);
_L2:
        apkgusagestats = new PkgUsageStats[0];
        if(true) goto _L4; else goto _L3
_L3:
    }

    public ConfigurationInfo getDeviceConfigurationInfo() {
        ConfigurationInfo configurationinfo1 = ActivityManagerNative.getDefault().getDeviceConfigurationInfo();
        ConfigurationInfo configurationinfo = configurationinfo1;
_L2:
        return configurationinfo;
        RemoteException remoteexception;
        remoteexception;
        configurationinfo = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int getFrontActivityScreenCompatMode() {
        int j = ActivityManagerNative.getDefault().getFrontActivityScreenCompatMode();
        int i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        i = 0;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int getLargeMemoryClass() {
        return staticGetLargeMemoryClass();
    }

    public int getLauncherLargeIconDensity() {
        Resources resources;
        int i;
        resources = mContext.getResources();
        i = resources.getDisplayMetrics().densityDpi;
        if(resources.getConfiguration().smallestScreenWidthDp >= 600) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        switch(i) {
        default:
            i = (int)(0.5F + 1.5F * (float)i);
            break;

        case 120: // 'x'
            i = 160;
            break;

        case 160: 
            i = 240;
            break;

        case 213: 
            i = 320;
            break;

        case 240: 
            i = 320;
            break;

        case 320: 
            i = 480;
            break;

        case 480: 
            i = 640;
            break;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public int getLauncherLargeIconSize() {
        Resources resources;
        int i;
        resources = mContext.getResources();
        i = resources.getDimensionPixelSize(0x1050000);
        if(resources.getConfiguration().smallestScreenWidthDp >= 600) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        switch(resources.getDisplayMetrics().densityDpi) {
        default:
            i = (int)(0.5F + 1.5F * (float)i);
            break;

        case 120: // 'x'
            i = (i * 160) / 120;
            break;

        case 160: 
            i = (i * 240) / 160;
            break;

        case 213: 
            i = (i * 320) / 240;
            break;

        case 240: 
            i = (i * 320) / 240;
            break;

        case 320: 
            i = (i * 480) / 320;
            break;

        case 480: 
            i = (2 * (i * 320)) / 480;
            break;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public int getMemoryClass() {
        return staticGetMemoryClass();
    }

    public void getMemoryInfo(MemoryInfo memoryinfo) {
        ActivityManagerNative.getDefault().getMemoryInfo(memoryinfo);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean getPackageAskScreenCompat(String s) {
        boolean flag1 = ActivityManagerNative.getDefault().getPackageAskScreenCompat(s);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int getPackageScreenCompatMode(String s) {
        int j = ActivityManagerNative.getDefault().getPackageScreenCompatMode(s);
        int i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        i = 0;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public android.os.Debug.MemoryInfo[] getProcessMemoryInfo(int ai[]) {
        android.os.Debug.MemoryInfo amemoryinfo1[] = ActivityManagerNative.getDefault().getProcessMemoryInfo(ai);
        android.os.Debug.MemoryInfo amemoryinfo[] = amemoryinfo1;
_L2:
        return amemoryinfo;
        RemoteException remoteexception;
        remoteexception;
        amemoryinfo = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public List getProcessesInErrorState() {
        List list1 = ActivityManagerNative.getDefault().getProcessesInErrorState();
        List list = list1;
_L2:
        return list;
        RemoteException remoteexception;
        remoteexception;
        list = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public List getRecentTasks(int i, int j) throws SecurityException {
        List list1 = ActivityManagerNative.getDefault().getRecentTasks(i, j);
        List list = list1;
_L2:
        return list;
        RemoteException remoteexception;
        remoteexception;
        list = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public List getRunningAppProcesses() {
        List list1 = ActivityManagerNative.getDefault().getRunningAppProcesses();
        List list = list1;
_L2:
        return list;
        RemoteException remoteexception;
        remoteexception;
        list = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public List getRunningExternalApplications() {
        List list1 = ActivityManagerNative.getDefault().getRunningExternalApplications();
        List list = list1;
_L2:
        return list;
        RemoteException remoteexception;
        remoteexception;
        list = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public PendingIntent getRunningServiceControlPanel(ComponentName componentname) throws SecurityException {
        PendingIntent pendingintent1 = ActivityManagerNative.getDefault().getRunningServiceControlPanel(componentname);
        PendingIntent pendingintent = pendingintent1;
_L2:
        return pendingintent;
        RemoteException remoteexception;
        remoteexception;
        pendingintent = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public List getRunningServices(int i) throws SecurityException {
        List list1 = ActivityManagerNative.getDefault().getServices(i, 0);
        List list = list1;
_L2:
        return list;
        RemoteException remoteexception;
        remoteexception;
        list = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public List getRunningTasks(int i) throws SecurityException {
        return getRunningTasks(i, 0, null);
    }

    public List getRunningTasks(int i, int j, IThumbnailReceiver ithumbnailreceiver) throws SecurityException {
        List list1 = ActivityManagerNative.getDefault().getTasks(i, j, ithumbnailreceiver);
        List list = list1;
_L2:
        return list;
        RemoteException remoteexception;
        remoteexception;
        list = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public TaskThumbnails getTaskThumbnails(int i) throws SecurityException {
        TaskThumbnails taskthumbnails1 = ActivityManagerNative.getDefault().getTaskThumbnails(i);
        TaskThumbnails taskthumbnails = taskthumbnails1;
_L2:
        return taskthumbnails;
        RemoteException remoteexception;
        remoteexception;
        taskthumbnails = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void killBackgroundProcesses(String s) {
        ActivityManagerNative.getDefault().killBackgroundProcesses(s);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void moveTaskToFront(int i, int j) {
        moveTaskToFront(i, j, null);
    }

    public void moveTaskToFront(int i, int j, Bundle bundle) {
        ActivityManagerNative.getDefault().moveTaskToFront(i, j, bundle);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean removeSubTask(int i, int j) throws SecurityException {
        boolean flag1 = ActivityManagerNative.getDefault().removeSubTask(i, j);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean removeTask(int i, int j) throws SecurityException {
        boolean flag1 = ActivityManagerNative.getDefault().removeTask(i, j);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void restartPackage(String s) {
        killBackgroundProcesses(s);
    }

    public void setFrontActivityScreenCompatMode(int i) {
        ActivityManagerNative.getDefault().setFrontActivityScreenCompatMode(i);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void setPackageAskScreenCompat(String s, boolean flag) {
        ActivityManagerNative.getDefault().setPackageAskScreenCompat(s, flag);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void setPackageScreenCompatMode(String s, int i) {
        ActivityManagerNative.getDefault().setPackageScreenCompatMode(s, i);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean switchUser(int i) {
        boolean flag1 = ActivityManagerNative.getDefault().switchUser(i);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static final int BROADCAST_STICKY_CANT_HAVE_PERMISSION = -1;
    public static final int BROADCAST_SUCCESS = 0;
    public static final int COMPAT_MODE_ALWAYS = -1;
    public static final int COMPAT_MODE_DISABLED = 0;
    public static final int COMPAT_MODE_ENABLED = 1;
    public static final int COMPAT_MODE_NEVER = -2;
    public static final int COMPAT_MODE_TOGGLE = 2;
    public static final int COMPAT_MODE_UNKNOWN = -3;
    public static final int INTENT_SENDER_ACTIVITY = 2;
    public static final int INTENT_SENDER_ACTIVITY_RESULT = 3;
    public static final int INTENT_SENDER_BROADCAST = 1;
    public static final int INTENT_SENDER_SERVICE = 4;
    public static final int MOVE_TASK_NO_USER_ACTION = 2;
    public static final int MOVE_TASK_WITH_HOME = 1;
    public static final int RECENT_IGNORE_UNAVAILABLE = 2;
    public static final int RECENT_WITH_EXCLUDED = 1;
    public static final int REMOVE_TASK_KILL_PROCESS = 1;
    public static final int START_CANCELED = -6;
    public static final int START_CLASS_NOT_FOUND = -2;
    public static final int START_DELIVERED_TO_TOP = 3;
    public static final int START_FLAG_AUTO_STOP_PROFILER = 8;
    public static final int START_FLAG_DEBUG = 2;
    public static final int START_FLAG_ONLY_IF_NEEDED = 1;
    public static final int START_FLAG_OPENGL_TRACES = 4;
    public static final int START_FORWARD_AND_REQUEST_CONFLICT = -3;
    public static final int START_INTENT_NOT_RESOLVED = -1;
    public static final int START_NOT_ACTIVITY = -5;
    public static final int START_PERMISSION_DENIED = -4;
    public static final int START_RETURN_INTENT_TO_CALLER = 1;
    public static final int START_SUCCESS = 0;
    public static final int START_SWITCHES_CANCELED = 4;
    public static final int START_TASK_TO_FRONT = 2;
    private static String TAG = "ActivityManager";
    private static boolean localLOGV = false;
    private final Context mContext;
    private final Handler mHandler;

}
