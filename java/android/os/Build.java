// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;


// Referenced classes of package android.os:
//            SystemProperties

public class Build {
    public static class VERSION_CODES {

        public static final int BASE = 1;
        public static final int BASE_1_1 = 2;
        public static final int CUPCAKE = 3;
        public static final int CUR_DEVELOPMENT = 10000;
        public static final int DONUT = 4;
        public static final int ECLAIR = 5;
        public static final int ECLAIR_0_1 = 6;
        public static final int ECLAIR_MR1 = 7;
        public static final int FROYO = 8;
        public static final int GINGERBREAD = 9;
        public static final int GINGERBREAD_MR1 = 10;
        public static final int HONEYCOMB = 11;
        public static final int HONEYCOMB_MR1 = 12;
        public static final int HONEYCOMB_MR2 = 13;
        public static final int ICE_CREAM_SANDWICH = 14;
        public static final int ICE_CREAM_SANDWICH_MR1 = 15;
        public static final int JELLY_BEAN = 16;

        public VERSION_CODES() {
        }
    }

    public static class VERSION {

        public static final String CODENAME = Build.getString("ro.build.version.codename");
        public static final String INCREMENTAL = Build.getString("ro.build.version.incremental");
        public static final String RELEASE = Build.getString("ro.build.version.release");
        public static final int RESOURCES_SDK_INT;
        public static final String SDK = Build.getString("ro.build.version.sdk");
        public static final int SDK_INT;

        static  {
            int i = 0;
            SDK_INT = SystemProperties.getInt("ro.build.version.sdk", 0);
            int j = SDK_INT;
            if(!"REL".equals(CODENAME))
                i = 1;
            RESOURCES_SDK_INT = i + j;
        }

        public VERSION() {
        }
    }


    public Build() {
    }

    private static long getLong(String s) {
        long l1 = Long.parseLong(SystemProperties.get(s));
        long l = l1;
_L2:
        return l;
        NumberFormatException numberformatexception;
        numberformatexception;
        l = -1L;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static String getRadioVersion() {
        return SystemProperties.get("gsm.version.baseband", null);
    }

    private static String getString(String s) {
        return SystemProperties.get(s, "unknown");
    }

    public static final String BOARD = getString("ro.product.board");
    public static final String BOOTLOADER = getString("ro.bootloader");
    public static final String BRAND = getString("ro.product.brand");
    public static final String CPU_ABI = getString("ro.product.cpu.abi");
    public static final String CPU_ABI2 = getString("ro.product.cpu.abi2");
    public static final String DEVICE = getString("ro.product.device");
    public static final String DISPLAY = getString("ro.build.display.id");
    public static final String FINGERPRINT = getString("ro.build.fingerprint");
    public static final String HARDWARE = getString("ro.hardware");
    public static final String HOST = getString("ro.build.host");
    public static final String ID = getString("ro.build.id");
    public static final boolean IS_DEBUGGABLE = false;
    public static final String MANUFACTURER = getString("ro.product.manufacturer");
    public static final String MODEL = getString("ro.product.model");
    public static final String PRODUCT = getString("ro.product.name");
    public static final String RADIO = getString("gsm.version.baseband");
    public static final String SERIAL = getString("ro.serialno");
    public static final String TAGS = getString("ro.build.tags");
    public static final long TIME = 0L;
    public static final String TYPE = getString("ro.build.type");
    public static final String UNKNOWN = "unknown";
    public static final String USER = getString("ro.build.user");

    static  {
        boolean flag = true;
        TIME = 1000L * getLong("ro.build.date.utc");
        if(SystemProperties.getInt("ro.debuggable", 0) != flag)
            flag = false;
        IS_DEBUGGABLE = flag;
    }

}
