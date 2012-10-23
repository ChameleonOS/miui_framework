// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.os;

import android.os.SystemProperties;
import android.text.TextUtils;

public class Build extends android.os.Build {

    public Build() {
    }

    private static String getString(String s) {
        return SystemProperties.get(s, "unknown");
    }

    public static boolean isDevelopmentVersion() {
        boolean flag;
        if(!TextUtils.isEmpty(android.os.VERSION.INCREMENTAL) && android.os.VERSION.INCREMENTAL.matches("\\d+.\\d+.\\d+(.ALPHA)?"))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isMsm8660() {
        String s = SystemProperties.get("ro.soc.name");
        boolean flag;
        if(TextUtils.equals(s, "msm8660") || TextUtils.equals(s, "unkown"))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isOfficialVersion() {
        boolean flag;
        if(isDevelopmentVersion() || isStableVersion())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isStableVersion() {
        boolean flag;
        if(!TextUtils.isEmpty(android.os.VERSION.INCREMENTAL) && android.os.VERSION.INCREMENTAL.matches("ICS\\d+.\\d+"))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static final boolean IS_DEFY;
    public static final boolean IS_DESIRE;
    public static final boolean IS_FAST_GPU_DEVICE;
    public static final boolean IS_FINAL_USER_BUILD;
    public static final boolean IS_GALAXYS2;
    public static final boolean IS_GALAXYS_NEXUS;
    public static final boolean IS_HTC_HD2;
    public static final boolean IS_I9000;
    public static final boolean IS_LOW_MEMORY_DEVICE;
    public static final boolean IS_MI1S;
    public static final boolean IS_MILESTONE;
    public static final boolean IS_MIONE;
    public static final boolean IS_MIONE_CT_CUSTOMIZATION = "ct".equals(getString("ro.carrier.name"));
    public static final boolean IS_MIONE_PLUS_CDMA;
    public static final boolean IS_MITWO;
    public static final boolean IS_NEED_UNCOMPRESSED_UCS2_SMS_DEVICE;
    public static final boolean IS_NEXUS_ONE;
    public static final boolean IS_NEXUS_S;
    public static final boolean IS_P990;
    public static final boolean IS_RICH_MEMORY_DEVICE;
    public static final boolean IS_T959;
    public static final boolean IS_U8860;
    public static final boolean IS_U9200;
    public static final boolean IS_XIAOMI;
    public static final boolean SHOW_MAGNIFIER_WHEN_INPUT;

    static  {
        boolean flag = false;
        IS_DEFY = "jordan".equals(BOARD);
        IS_DESIRE = "bravo".equals(DEVICE);
        IS_GALAXYS2 = "galaxys2".equals(DEVICE);
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        boolean flag6;
        boolean flag7;
        boolean flag8;
        if("htcleo".equals(DEVICE) || "leo".equals(DEVICE))
            flag1 = true;
        else
            flag1 = false;
        IS_HTC_HD2 = flag1;
        IS_I9000 = "aries".equals(BOARD);
        IS_MILESTONE = "umts_sholes".equals(DEVICE);
        if("mione".equals(DEVICE) || "mione_plus".equals(DEVICE))
            flag2 = true;
        else
            flag2 = false;
        IS_MIONE = flag2;
        IS_MITWO = "aries".equals(DEVICE);
        if(IS_MIONE || IS_MITWO)
            flag3 = true;
        else
            flag3 = false;
        IS_XIAOMI = flag3;
        IS_NEXUS_ONE = "passion".equals(DEVICE);
        IS_NEXUS_S = "crespo".equals(DEVICE);
        IS_GALAXYS_NEXUS = "maguro".equals(DEVICE);
        IS_P990 = "p990".equals(DEVICE);
        IS_T959 = DEVICE.startsWith("vibrant");
        IS_U8860 = "hwu8860".equals(DEVICE);
        IS_U9200 = "hwu9200".equals(DEVICE);
        if("MI 1S".equals(MODEL) || "MI 1SC".equals(MODEL))
            flag4 = true;
        else
            flag4 = false;
        IS_MI1S = flag4;
        if(IS_MIONE || IS_GALAXYS2)
            flag5 = true;
        else
            flag5 = false;
        IS_RICH_MEMORY_DEVICE = flag5;
        IS_LOW_MEMORY_DEVICE = IS_MILESTONE;
        if(IS_MIONE || IS_I9000 || IS_P990 || IS_NEXUS_S || IS_GALAXYS2)
            flag6 = true;
        else
            flag6 = false;
        IS_FAST_GPU_DEVICE = flag6;
        if(IS_MILESTONE || IS_NEXUS_S || IS_I9000 || IS_DEFY || IS_GALAXYS2 || IS_P990)
            flag7 = true;
        else
            flag7 = false;
        IS_NEED_UNCOMPRESSED_UCS2_SMS_DEVICE = flag7;
        if(IS_MIONE && isMsm8660())
            flag8 = true;
        else
            flag8 = false;
        IS_MIONE_PLUS_CDMA = flag8;
        if(IS_XIAOMI || IS_GALAXYS_NEXUS || IS_NEXUS_S)
            flag = true;
        SHOW_MAGNIFIER_WHEN_INPUT = flag;
    }
}
