// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Printer;

// Referenced classes of package android.content.pm:
//            ComponentInfo, ApplicationInfo, PackageItemInfo

public class ActivityInfo extends ComponentInfo
    implements Parcelable {

    public ActivityInfo() {
        screenOrientation = -1;
        uiOptions = 0;
    }

    public ActivityInfo(ActivityInfo activityinfo) {
        super(activityinfo);
        screenOrientation = -1;
        uiOptions = 0;
        theme = activityinfo.theme;
        launchMode = activityinfo.launchMode;
        permission = activityinfo.permission;
        taskAffinity = activityinfo.taskAffinity;
        targetActivity = activityinfo.targetActivity;
        flags = activityinfo.flags;
        screenOrientation = activityinfo.screenOrientation;
        configChanges = activityinfo.configChanges;
        softInputMode = activityinfo.softInputMode;
        uiOptions = activityinfo.uiOptions;
        parentActivityName = activityinfo.parentActivityName;
    }

    private ActivityInfo(Parcel parcel) {
        super(parcel);
        screenOrientation = -1;
        uiOptions = 0;
        theme = parcel.readInt();
        launchMode = parcel.readInt();
        permission = parcel.readString();
        taskAffinity = parcel.readString();
        targetActivity = parcel.readString();
        flags = parcel.readInt();
        screenOrientation = parcel.readInt();
        configChanges = parcel.readInt();
        softInputMode = parcel.readInt();
        uiOptions = parcel.readInt();
        parentActivityName = parcel.readString();
    }


    public static int activityInfoConfigToNative(int i) {
        int j = 0;
        for(int k = 0; k < CONFIG_NATIVE_BITS.length; k++)
            if((i & 1 << k) != 0)
                j |= CONFIG_NATIVE_BITS[k];

        return j;
    }

    public int describeContents() {
        return 0;
    }

    public void dump(Printer printer, String s) {
        super.dumpFront(printer, s);
        if(permission != null)
            printer.println((new StringBuilder()).append(s).append("permission=").append(permission).toString());
        printer.println((new StringBuilder()).append(s).append("taskAffinity=").append(taskAffinity).append(" targetActivity=").append(targetActivity).toString());
        if(launchMode != 0 || flags != 0 || theme != 0)
            printer.println((new StringBuilder()).append(s).append("launchMode=").append(launchMode).append(" flags=0x").append(Integer.toHexString(flags)).append(" theme=0x").append(Integer.toHexString(theme)).toString());
        if(screenOrientation != -1 || configChanges != 0 || softInputMode != 0)
            printer.println((new StringBuilder()).append(s).append("screenOrientation=").append(screenOrientation).append(" configChanges=0x").append(Integer.toHexString(configChanges)).append(" softInputMode=0x").append(Integer.toHexString(softInputMode)).toString());
        if(uiOptions != 0)
            printer.println((new StringBuilder()).append(s).append(" uiOptions=0x").append(Integer.toHexString(uiOptions)).toString());
        super.dumpBack(printer, s);
    }

    public int getRealConfigChanged() {
        int i;
        if(super.applicationInfo.targetSdkVersion < 13)
            i = 0x800 | (0x400 | configChanges);
        else
            i = configChanges;
        return i;
    }

    public final int getThemeResource() {
        int i;
        if(theme != 0)
            i = theme;
        else
            i = super.applicationInfo.theme;
        return i;
    }

    public String toString() {
        return (new StringBuilder()).append("ActivityInfo{").append(Integer.toHexString(System.identityHashCode(this))).append(" ").append(super.name).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(theme);
        parcel.writeInt(launchMode);
        parcel.writeString(permission);
        parcel.writeString(taskAffinity);
        parcel.writeString(targetActivity);
        parcel.writeInt(flags);
        parcel.writeInt(screenOrientation);
        parcel.writeInt(configChanges);
        parcel.writeInt(softInputMode);
        parcel.writeInt(uiOptions);
        parcel.writeString(parentActivityName);
    }

    public static final int CONFIG_FONT_SCALE = 0x40000000;
    public static final int CONFIG_KEYBOARD = 16;
    public static final int CONFIG_KEYBOARD_HIDDEN = 32;
    public static final int CONFIG_LOCALE = 4;
    public static final int CONFIG_MCC = 1;
    public static final int CONFIG_MNC = 2;
    public static int CONFIG_NATIVE_BITS[];
    public static final int CONFIG_NAVIGATION = 64;
    public static final int CONFIG_ORIENTATION = 128;
    public static final int CONFIG_SCREEN_LAYOUT = 256;
    public static final int CONFIG_SCREEN_SIZE = 1024;
    public static final int CONFIG_SMALLEST_SCREEN_SIZE = 2048;
    public static final int CONFIG_TOUCHSCREEN = 8;
    public static final int CONFIG_UI_MODE = 512;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ActivityInfo createFromParcel(Parcel parcel) {
            return new ActivityInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public ActivityInfo[] newArray(int i) {
            return new ActivityInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int FLAG_ALLOW_TASK_REPARENTING = 64;
    public static final int FLAG_ALWAYS_RETAIN_TASK_STATE = 8;
    public static final int FLAG_CLEAR_TASK_ON_LAUNCH = 4;
    public static final int FLAG_EXCLUDE_FROM_RECENTS = 32;
    public static final int FLAG_FINISH_ON_CLOSE_SYSTEM_DIALOGS = 256;
    public static final int FLAG_FINISH_ON_TASK_LAUNCH = 2;
    public static final int FLAG_HARDWARE_ACCELERATED = 512;
    public static final int FLAG_IMMERSIVE = 1024;
    public static final int FLAG_MULTIPROCESS = 1;
    public static final int FLAG_NO_HISTORY = 128;
    public static final int FLAG_STATE_NOT_NEEDED = 16;
    public static final int LAUNCH_MULTIPLE = 0;
    public static final int LAUNCH_SINGLE_INSTANCE = 3;
    public static final int LAUNCH_SINGLE_TASK = 2;
    public static final int LAUNCH_SINGLE_TOP = 1;
    public static final int SCREEN_ORIENTATION_BEHIND = 3;
    public static final int SCREEN_ORIENTATION_FULL_SENSOR = 10;
    public static final int SCREEN_ORIENTATION_LANDSCAPE = 0;
    public static final int SCREEN_ORIENTATION_NOSENSOR = 5;
    public static final int SCREEN_ORIENTATION_PORTRAIT = 1;
    public static final int SCREEN_ORIENTATION_REVERSE_LANDSCAPE = 8;
    public static final int SCREEN_ORIENTATION_REVERSE_PORTRAIT = 9;
    public static final int SCREEN_ORIENTATION_SENSOR = 4;
    public static final int SCREEN_ORIENTATION_SENSOR_LANDSCAPE = 6;
    public static final int SCREEN_ORIENTATION_SENSOR_PORTRAIT = 7;
    public static final int SCREEN_ORIENTATION_UNSPECIFIED = -1;
    public static final int SCREEN_ORIENTATION_USER = 2;
    public static final int UIOPTION_SPLIT_ACTION_BAR_WHEN_NARROW = 1;
    public int configChanges;
    public int flags;
    public int launchMode;
    public String parentActivityName;
    public String permission;
    public int screenOrientation;
    public int softInputMode;
    public String targetActivity;
    public String taskAffinity;
    public int theme;
    public int uiOptions;

    static  {
        int ai[] = new int[12];
        ai[0] = 1;
        ai[1] = 2;
        ai[2] = 4;
        ai[3] = 8;
        ai[4] = 16;
        ai[5] = 32;
        ai[6] = 64;
        ai[7] = 128;
        ai[8] = 2048;
        ai[9] = 4096;
        ai[10] = 512;
        ai[11] = 8192;
        CONFIG_NATIVE_BITS = ai;
    }
}
