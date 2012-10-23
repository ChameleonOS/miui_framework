// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.pm;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Printer;
import java.text.Collator;
import java.util.Comparator;

// Referenced classes of package android.content.pm:
//            PackageItemInfo, PackageManager

public class ApplicationInfo extends PackageItemInfo
    implements Parcelable {
    public static class DisplayNameComparator
        implements Comparator {

        public final int compare(ApplicationInfo applicationinfo, ApplicationInfo applicationinfo1) {
            Object obj = mPM.getApplicationLabel(applicationinfo);
            if(obj == null)
                obj = ((PackageItemInfo) (applicationinfo)).packageName;
            Object obj1 = mPM.getApplicationLabel(applicationinfo1);
            if(obj1 == null)
                obj1 = ((PackageItemInfo) (applicationinfo1)).packageName;
            return sCollator.compare(obj.toString(), obj1.toString());
        }

        public volatile int compare(Object obj, Object obj1) {
            return compare((ApplicationInfo)obj, (ApplicationInfo)obj1);
        }

        private PackageManager mPM;
        private final Collator sCollator = Collator.getInstance();

        public DisplayNameComparator(PackageManager packagemanager) {
            mPM = packagemanager;
        }
    }


    public ApplicationInfo() {
        uiOptions = 0;
        flags = 0;
        requiresSmallestWidthDp = 0;
        compatibleWidthLimitDp = 0;
        largestWidthLimitDp = 0;
        enabled = true;
        enabledSetting = 0;
        installLocation = -1;
    }

    public ApplicationInfo(ApplicationInfo applicationinfo) {
        super(applicationinfo);
        uiOptions = 0;
        flags = 0;
        requiresSmallestWidthDp = 0;
        compatibleWidthLimitDp = 0;
        largestWidthLimitDp = 0;
        enabled = true;
        enabledSetting = 0;
        installLocation = -1;
        taskAffinity = applicationinfo.taskAffinity;
        permission = applicationinfo.permission;
        processName = applicationinfo.processName;
        className = applicationinfo.className;
        theme = applicationinfo.theme;
        flags = applicationinfo.flags;
        requiresSmallestWidthDp = applicationinfo.requiresSmallestWidthDp;
        compatibleWidthLimitDp = applicationinfo.compatibleWidthLimitDp;
        largestWidthLimitDp = applicationinfo.largestWidthLimitDp;
        sourceDir = applicationinfo.sourceDir;
        publicSourceDir = applicationinfo.publicSourceDir;
        nativeLibraryDir = applicationinfo.nativeLibraryDir;
        resourceDirs = applicationinfo.resourceDirs;
        sharedLibraryFiles = applicationinfo.sharedLibraryFiles;
        dataDir = applicationinfo.dataDir;
        uid = applicationinfo.uid;
        targetSdkVersion = applicationinfo.targetSdkVersion;
        enabled = applicationinfo.enabled;
        enabledSetting = applicationinfo.enabledSetting;
        installLocation = applicationinfo.installLocation;
        manageSpaceActivityName = applicationinfo.manageSpaceActivityName;
        descriptionRes = applicationinfo.descriptionRes;
        uiOptions = applicationinfo.uiOptions;
    }

    private ApplicationInfo(Parcel parcel) {
        boolean flag = true;
        super(parcel);
        uiOptions = 0;
        flags = 0;
        requiresSmallestWidthDp = 0;
        compatibleWidthLimitDp = 0;
        largestWidthLimitDp = 0;
        enabled = flag;
        enabledSetting = 0;
        installLocation = -1;
        taskAffinity = parcel.readString();
        permission = parcel.readString();
        processName = parcel.readString();
        className = parcel.readString();
        theme = parcel.readInt();
        flags = parcel.readInt();
        requiresSmallestWidthDp = parcel.readInt();
        compatibleWidthLimitDp = parcel.readInt();
        largestWidthLimitDp = parcel.readInt();
        sourceDir = parcel.readString();
        publicSourceDir = parcel.readString();
        nativeLibraryDir = parcel.readString();
        resourceDirs = parcel.readStringArray();
        sharedLibraryFiles = parcel.readStringArray();
        dataDir = parcel.readString();
        uid = parcel.readInt();
        targetSdkVersion = parcel.readInt();
        if(parcel.readInt() == 0)
            flag = false;
        enabled = flag;
        enabledSetting = parcel.readInt();
        installLocation = parcel.readInt();
        manageSpaceActivityName = parcel.readString();
        backupAgentName = parcel.readString();
        descriptionRes = parcel.readInt();
        uiOptions = parcel.readInt();
    }


    private boolean isPackageUnavailable(PackageManager packagemanager) {
        boolean flag = true;
        PackageInfo packageinfo = packagemanager.getPackageInfo(super.packageName, 0);
        if(packageinfo != null)
            flag = false;
_L2:
        return flag;
        PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int describeContents() {
        return 0;
    }

    public void disableCompatibilityMode() {
        flags = 0x83e00 | flags;
    }

    public void dump(Printer printer, String s) {
        super.dumpFront(printer, s);
        if(className != null)
            printer.println((new StringBuilder()).append(s).append("className=").append(className).toString());
        if(permission != null)
            printer.println((new StringBuilder()).append(s).append("permission=").append(permission).toString());
        printer.println((new StringBuilder()).append(s).append("processName=").append(processName).toString());
        printer.println((new StringBuilder()).append(s).append("taskAffinity=").append(taskAffinity).toString());
        printer.println((new StringBuilder()).append(s).append("uid=").append(uid).append(" flags=0x").append(Integer.toHexString(flags)).append(" theme=0x").append(Integer.toHexString(theme)).toString());
        printer.println((new StringBuilder()).append(s).append("requiresSmallestWidthDp=").append(requiresSmallestWidthDp).append(" compatibleWidthLimitDp=").append(compatibleWidthLimitDp).append(" largestWidthLimitDp=").append(largestWidthLimitDp).toString());
        printer.println((new StringBuilder()).append(s).append("sourceDir=").append(sourceDir).toString());
        StringBuilder stringbuilder;
        String s1;
        if(sourceDir == null) {
            if(publicSourceDir != null)
                printer.println((new StringBuilder()).append(s).append("publicSourceDir=").append(publicSourceDir).toString());
        } else
        if(!sourceDir.equals(publicSourceDir))
            printer.println((new StringBuilder()).append(s).append("publicSourceDir=").append(publicSourceDir).toString());
        if(resourceDirs != null)
            printer.println((new StringBuilder()).append(s).append("resourceDirs=").append(resourceDirs).toString());
        printer.println((new StringBuilder()).append(s).append("dataDir=").append(dataDir).toString());
        if(sharedLibraryFiles != null)
            printer.println((new StringBuilder()).append(s).append("sharedLibraryFiles=").append(sharedLibraryFiles).toString());
        printer.println((new StringBuilder()).append(s).append("enabled=").append(enabled).append(" targetSdkVersion=").append(targetSdkVersion).toString());
        if(manageSpaceActivityName != null)
            printer.println((new StringBuilder()).append(s).append("manageSpaceActivityName=").append(manageSpaceActivityName).toString());
        if(descriptionRes != 0)
            printer.println((new StringBuilder()).append(s).append("description=0x").append(Integer.toHexString(descriptionRes)).toString());
        if(uiOptions != 0)
            printer.println((new StringBuilder()).append(s).append("uiOptions=0x").append(Integer.toHexString(uiOptions)).toString());
        stringbuilder = (new StringBuilder()).append(s).append("supportsRtl=");
        if(hasRtlSupport())
            s1 = "true";
        else
            s1 = "false";
        printer.println(stringbuilder.append(s1).toString());
        super.dumpBack(printer, s);
    }

    protected ApplicationInfo getApplicationInfo() {
        return this;
    }

    public boolean hasRtlSupport() {
        boolean flag;
        if((0x400000 & flags) == 0x400000)
            flag = true;
        else
            flag = false;
        return flag;
    }

    protected Drawable loadDefaultIcon(PackageManager packagemanager) {
        Drawable drawable;
        if((0x40000 & flags) != 0 && isPackageUnavailable(packagemanager))
            drawable = Resources.getSystem().getDrawable(0x108057d);
        else
            drawable = packagemanager.getDefaultActivityIcon();
        return drawable;
    }

    public CharSequence loadDescription(PackageManager packagemanager) {
        if(descriptionRes == 0) goto _L2; else goto _L1
_L1:
        CharSequence charsequence = packagemanager.getText(super.packageName, descriptionRes, this);
        if(charsequence == null) goto _L2; else goto _L3
_L3:
        return charsequence;
_L2:
        charsequence = null;
        if(true) goto _L3; else goto _L4
_L4:
    }

    public String toString() {
        return (new StringBuilder()).append("ApplicationInfo{").append(Integer.toHexString(System.identityHashCode(this))).append(" ").append(super.packageName).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(taskAffinity);
        parcel.writeString(permission);
        parcel.writeString(processName);
        parcel.writeString(className);
        parcel.writeInt(theme);
        parcel.writeInt(flags);
        parcel.writeInt(requiresSmallestWidthDp);
        parcel.writeInt(compatibleWidthLimitDp);
        parcel.writeInt(largestWidthLimitDp);
        parcel.writeString(sourceDir);
        parcel.writeString(publicSourceDir);
        parcel.writeString(nativeLibraryDir);
        parcel.writeStringArray(resourceDirs);
        parcel.writeStringArray(sharedLibraryFiles);
        parcel.writeString(dataDir);
        parcel.writeInt(uid);
        parcel.writeInt(targetSdkVersion);
        int j;
        if(enabled)
            j = 1;
        else
            j = 0;
        parcel.writeInt(j);
        parcel.writeInt(enabledSetting);
        parcel.writeInt(installLocation);
        parcel.writeString(manageSpaceActivityName);
        parcel.writeString(backupAgentName);
        parcel.writeInt(descriptionRes);
        parcel.writeInt(uiOptions);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ApplicationInfo createFromParcel(Parcel parcel) {
            return new ApplicationInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public ApplicationInfo[] newArray(int i) {
            return new ApplicationInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int FLAG_ACCESS_CONTROL_PASSWORD = 0x80000000;
    public static final int FLAG_ALLOW_BACKUP = 32768;
    public static final int FLAG_ALLOW_CLEAR_USER_DATA = 64;
    public static final int FLAG_ALLOW_TASK_REPARENTING = 32;
    public static final int FLAG_CANT_SAVE_STATE = 0x10000000;
    public static final int FLAG_DEBUGGABLE = 2;
    public static final int FLAG_EXTERNAL_STORAGE = 0x40000;
    public static final int FLAG_FACTORY_TEST = 16;
    public static final int FLAG_FORWARD_LOCK = 0x20000000;
    public static final int FLAG_HAS_CODE = 4;
    public static final int FLAG_KILL_AFTER_RESTORE = 0x10000;
    public static final int FLAG_LARGE_HEAP = 0x100000;
    public static final int FLAG_PERSISTENT = 8;
    public static final int FLAG_RESIZEABLE_FOR_SCREENS = 4096;
    public static final int FLAG_RESTORE_ANY_VERSION = 0x20000;
    public static final int FLAG_STOPPED = 0x200000;
    public static final int FLAG_SUPPORTS_LARGE_SCREENS = 2048;
    public static final int FLAG_SUPPORTS_NORMAL_SCREENS = 1024;
    public static final int FLAG_SUPPORTS_RTL = 0x400000;
    public static final int FLAG_SUPPORTS_SCREEN_DENSITIES = 8192;
    public static final int FLAG_SUPPORTS_SMALL_SCREENS = 512;
    public static final int FLAG_SUPPORTS_XLARGE_SCREENS = 0x80000;
    public static final int FLAG_SYSTEM = 1;
    public static final int FLAG_TEST_ONLY = 256;
    public static final int FLAG_UPDATED_SYSTEM_APP = 128;
    public static final int FLAG_VM_SAFE_MODE = 16384;
    public String backupAgentName;
    public String className;
    public int compatibleWidthLimitDp;
    public String dataDir;
    public int descriptionRes;
    public boolean enabled;
    public int enabledSetting;
    public int flags;
    public int installLocation;
    public int largestWidthLimitDp;
    public String manageSpaceActivityName;
    public String nativeLibraryDir;
    public String permission;
    public String processName;
    public String publicSourceDir;
    public int requiresSmallestWidthDp;
    public String resourceDirs[];
    public String sharedLibraryFiles[];
    public String sourceDir;
    public int targetSdkVersion;
    public String taskAffinity;
    public int theme;
    public int uiOptions;
    public int uid;

}
