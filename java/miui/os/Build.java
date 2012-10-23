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
        return IS_DEVELOPMENT_VERSION;
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
        if(IS_DEVELOPMENT_VERSION || IS_STABLE_VERSION)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isStableVersion() {
        return IS_STABLE_VERSION;
    }

    public static final boolean IS_DEFY = false;
    public static final boolean IS_DESIRE = false;
    public static final boolean IS_DEVELOPMENT_VERSION = false;
    public static final boolean IS_FAST_GPU_DEVICE = false;
    public static final boolean IS_FINAL_USER_BUILD = false;
    public static final boolean IS_FULL_SOURCE_CODE_DEVICE = false;
    public static final boolean IS_GALAXYS2 = false;
    public static final boolean IS_GALAXYS_NEXUS = false;
    public static final boolean IS_HK_BUILD = false;
    public static final boolean IS_HTC_HD2 = false;
    public static final boolean IS_I9000 = false;
    public static final boolean IS_LOW_MEMORY_DEVICE = false;
    public static final boolean IS_MI1S = false;
    public static final boolean IS_MILESTONE = false;
    public static final boolean IS_MIONE = false;
    public static final boolean IS_MIONE_CT_CUSTOMIZATION = false;
    public static final boolean IS_MIONE_PLUS_CDMA = false;
    public static final boolean IS_MITWO = false;
    private static final boolean IS_MITWO_HK_BUILD = false;
    private static final boolean IS_MITWO_TW_BUILD = false;
    public static final boolean IS_NEED_UNCOMPRESSED_UCS2_SMS_DEVICE = false;
    public static final boolean IS_NEXUS_7 = false;
    public static final boolean IS_NEXUS_ONE = false;
    public static final boolean IS_NEXUS_S = false;
    public static final boolean IS_P990 = false;
    public static final boolean IS_RICH_MEMORY_DEVICE = false;
    public static final boolean IS_STABLE_VERSION = false;
    public static final boolean IS_T959 = false;
    public static final boolean IS_TW_BUILD = false;
    public static final boolean IS_U8860 = false;
    public static final boolean IS_U9200 = false;
    public static final boolean IS_XIAOMI = false;
    private static final String REGULAR_EXPRESSION_FOR_DEVELOPMENT = "\\d+.\\d+.\\d+(.ALPHA)?";
    public static final boolean SHOW_MAGNIFIER_WHEN_INPUT;

    static  {
        boolean flag = true;
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
        boolean flag9;
        boolean flag10;
        boolean flag11;
        if("htcleo".equals(DEVICE) || "leo".equals(DEVICE))
            flag1 = flag;
        else
            flag1 = false;
        IS_HTC_HD2 = flag1;
        IS_I9000 = "aries".equals(BOARD);
        IS_MILESTONE = "umts_sholes".equals(DEVICE);
        if("mione".equals(DEVICE) || "mione_plus".equals(DEVICE))
            flag2 = flag;
        else
            flag2 = false;
        IS_MIONE = flag2;
        IS_MITWO = "aries".equals(DEVICE);
        if(IS_MIONE || IS_MITWO)
            flag3 = flag;
        else
            flag3 = false;
        IS_XIAOMI = flag3;
        IS_NEXUS_ONE = "passion".equals(DEVICE);
        IS_NEXUS_S = "crespo".equals(DEVICE);
        IS_NEXUS_7 = "grouper".equals(DEVICE);
        IS_GALAXYS_NEXUS = "maguro".equals(DEVICE);
        IS_P990 = "p990".equals(DEVICE);
        IS_T959 = DEVICE.startsWith("vibrant");
        IS_U8860 = "hwu8860".equals(DEVICE);
        IS_U9200 = "hwu9200".equals(DEVICE);
        if("MI 1S".equals(MODEL) || "MI 1SC".equals(MODEL))
            flag4 = flag;
        else
            flag4 = false;
        IS_MI1S = flag4;
        if(IS_MIONE || IS_GALAXYS2)
            flag5 = flag;
        else
            flag5 = false;
        IS_RICH_MEMORY_DEVICE = flag5;
        IS_LOW_MEMORY_DEVICE = IS_MILESTONE;
        if(IS_MIONE || IS_I9000 || IS_P990 || IS_NEXUS_S || IS_GALAXYS2)
            flag6 = flag;
        else
            flag6 = false;
        IS_FAST_GPU_DEVICE = flag6;
        if(IS_MILESTONE || IS_NEXUS_S || IS_I9000 || IS_DEFY || IS_GALAXYS2 || IS_P990)
            flag7 = flag;
        else
            flag7 = false;
        IS_NEED_UNCOMPRESSED_UCS2_SMS_DEVICE = flag7;
        if(IS_MIONE && isMsm8660())
            flag8 = flag;
        else
            flag8 = false;
        IS_MIONE_PLUS_CDMA = flag8;
        IS_MIONE_CT_CUSTOMIZATION = "ct".equals(getString("ro.carrier.name"));
        if(IS_XIAOMI || IS_GALAXYS_NEXUS || IS_NEXUS_S)
            flag9 = flag;
        else
            flag9 = false;
        SHOW_MAGNIFIER_WHEN_INPUT = flag9;
        if(IS_XIAOMI || IS_GALAXYS_NEXUS || IS_NEXUS_S || IS_NEXUS_7)
            flag10 = flag;
        else
            flag10 = false;
        IS_FULL_SOURCE_CODE_DEVICE = flag10;
        if(!TextUtils.isEmpty(android.os.VERSION.INCREMENTAL) && android.os.VERSION.INCREMENTAL.matches("\\d+.\\d+.\\d+(.ALPHA)?"))
            flag11 = flag;
        else
            flag11 = false;
        IS_DEVELOPMENT_VERSION = flag11;
        if(!"user".equals(TYPE) || IS_DEVELOPMENT_VERSION)
            flag = false;
        IS_STABLE_VERSION = flag;
        IS_MITWO_TW_BUILD = "aries_tw".equals(SystemProperties.get("ro.product.mod_device", ""));
        IS_MITWO_HK_BUILD = "aries_hk".equals(SystemProperties.get("ro.product.mod_device", ""));
        IS_TW_BUILD = IS_MITWO_TW_BUILD;
        IS_HK_BUILD = IS_MITWO_HK_BUILD;
    }
}
