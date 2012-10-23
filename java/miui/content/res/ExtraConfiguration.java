// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.content.res;

import android.app.ActivityManagerNative;
import android.app.IActivityManager;
import android.content.res.Configuration;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.*;

public class ExtraConfiguration
    implements Comparable {

    public ExtraConfiguration() {
    }

    public static void addNeedRestartActivity(long l) {
        if(needRestartLauncher(l))
            needRestartActivitySet.add("com.miui.home");
        if(needRestartSettings(l))
            needRestartActivitySet.add("com.android.settings");
        if(needRestartMms(l))
            needRestartActivitySet.add("com.android.mms");
        if(needRestartContacts(l))
            needRestartActivitySet.add("com.android.contacts");
    }

    public static int getScaleMode() {
        int i = 1;
        int j;
        Configuration configuration = ActivityManagerNative.getDefault().getConfiguration();
        if(configuration == null)
            break MISSING_BLOCK_LABEL_51;
        j = configuration.uiMode;
        i = j & 0xf;
        if(i != 12 && i != 13 && i != 14 && i != 15)
            i = 1;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static boolean needNewResources(int i) {
        boolean flag;
        if((0x80000000 & i) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean needRestart3rdApp(long l) {
        boolean flag;
        if((0x10000011L & l) != 0L)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean needRestartActivity(String s, long l) {
        if(s == null) goto _L2; else goto _L1
_L1:
        if(!s.startsWith("com.miui.home")) goto _L4; else goto _L3
_L3:
        boolean flag = needRestartLauncher(l);
_L6:
        return flag;
_L4:
        if(s.startsWith("com.android.settings")) {
            flag = needRestartSettings(l);
            continue; /* Loop/switch isn't completed */
        }
        if(s.startsWith("com.android.mms")) {
            flag = needRestartMms(l);
            continue; /* Loop/switch isn't completed */
        }
        if(s.startsWith("com.android.contacts")) {
            flag = needRestartContacts(l);
            continue; /* Loop/switch isn't completed */
        }
_L2:
        flag = needRestart3rdApp(l);
        if(true) goto _L6; else goto _L5
_L5:
    }

    public static boolean needRestartContacts(long l) {
        boolean flag;
        if((2065L & l) != 0L)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean needRestartLauncher(long l) {
        boolean flag;
        if((16409L & l) != 0L)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean needRestartMms(long l) {
        boolean flag;
        if((145L & l) != 0L)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean needRestartSettings(long l) {
        boolean flag;
        if((25L & l) != 0L)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean needRestartStatusBar(long l) {
        boolean flag;
        if((8217L & l) != 0L)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean removeNeedRestartActivity(String s) {
        return needRestartActivitySet.remove(s);
    }

    public volatile int compareTo(Object obj) {
        return compareTo((ExtraConfiguration)obj);
    }

    public int compareTo(ExtraConfiguration extraconfiguration) {
        int i = themeChanged - extraconfiguration.themeChanged;
        if(i == 0);
        return i;
    }

    public int diff(ExtraConfiguration extraconfiguration) {
        int i = 0;
        if(themeChanged < extraconfiguration.themeChanged)
            i = 0 | 0x80000000;
        return i;
    }

    public int hashCode() {
        return themeChanged + (int)themeChangedFlags;
    }

    public void readFromParcel(Parcel parcel) {
        themeChanged = parcel.readInt();
        themeChangedFlags = parcel.readLong();
    }

    public void setTo(ExtraConfiguration extraconfiguration) {
        themeChanged = extraconfiguration.themeChanged;
        themeChangedFlags = extraconfiguration.themeChangedFlags;
    }

    public void setToDefaults() {
        themeChanged = 0;
        themeChangedFlags = 0L;
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(" themeChanged=");
        stringbuilder.append(themeChanged);
        stringbuilder.append(" themeChangedFlags=");
        stringbuilder.append(themeChangedFlags);
        return stringbuilder.toString();
    }

    public int updateFrom(ExtraConfiguration extraconfiguration) {
        int i = 0;
        if(themeChanged < extraconfiguration.themeChanged) {
            i = 0 | 0x80000000;
            themeChanged = extraconfiguration.themeChanged;
            themeChangedFlags = extraconfiguration.themeChangedFlags;
        }
        return i;
    }

    public void updateTheme(long l) {
        themeChanged = 1 + themeChanged;
        themeChangedFlags = l;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(themeChanged);
        parcel.writeLong(themeChangedFlags);
    }

    public static final String CONTACTS_PKG_NAME = "com.android.contacts";
    public static final String LAUNCHER_PKG_NAME = "com.miui.home";
    public static final String MMS_PKG_NAME = "com.android.mms";
    public static final String SETTINGS_PKG_NAME = "com.android.settings";
    public static final String SYSTEMUI_PKG_NAME = "com.android.systemui";
    public static final long SYSTEM_INTRESTE_CHANGE_FLAG = 0x10007899L;
    public static final long THEME_FLAG_ALARM = 1024L;
    public static final long THEME_FLAG_AUDIO_EFFECT = 32768L;
    public static final long THEME_FLAG_BOOT_ANIMATION = 32L;
    public static final long THEME_FLAG_BOOT_AUDIO = 64L;
    public static final long THEME_FLAG_CLOCK = 0x10000L;
    public static final long THEME_FLAG_CONTACT = 2048L;
    public static final long THEME_FLAG_FONT = 16L;
    public static final long THEME_FLAG_FRAMEWORK = 1L;
    public static final long THEME_FLAG_ICON = 8L;
    public static final long THEME_FLAG_LAST = 0x20000L;
    public static final long THEME_FLAG_LAUNCHER = 16384L;
    public static final long THEME_FLAG_LOCKSCREEN = 4L;
    public static final long THEME_FLAG_LOCKSTYLE = 4096L;
    public static final long THEME_FLAG_MMS = 128L;
    public static final long THEME_FLAG_NOTIFICATION = 512L;
    public static final long THEME_FLAG_PHOTO_FRAME = 0x20000L;
    public static final long THEME_FLAG_RINGTONE = 256L;
    public static final long THEME_FLAG_STATUSBAR = 8192L;
    public static final long THEME_FLAG_THIRD_APP = 0x10000000L;
    public static final long THEME_FLAG_WALLPAPER = 2L;
    private static final Set needRestartActivitySet = Collections.synchronizedSet(new HashSet());
    public int themeChanged;
    public long themeChangedFlags;

}
