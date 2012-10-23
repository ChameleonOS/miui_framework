// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.os;

import android.content.ContentResolver;
import android.os.Process;
import android.os.StatFs;
import java.io.File;
import java.util.HashMap;

// Referenced classes of package miui.os:
//            Build, ExtraFileUtils

public class Environment extends android.os.Environment {

    public Environment() {
    }

    public static File getInternalStorageDirectory() {
        return INTERNAL_STORAGE_DIRECTORY;
    }

    public static File getMIUIExternalStorageDirectory() {
        return EXTERNAL_STORAGE_MIUI_DIRECTORY;
    }

    public static File getMIUIInternalStorageDirectory() {
        return INTERNAL_STORAGE_MIUI_DIRECTORY;
    }

    public static File getMIUIStorageDirectory() {
        File file;
        if(isExternalStorageMounted())
            file = EXTERNAL_STORAGE_MIUI_DIRECTORY;
        else
            file = INTERNAL_STORAGE_MIUI_DIRECTORY;
        return file;
    }

    public static File getStorageDirectory() {
        File file;
        if(isExternalStorageMounted())
            file = getExternalStorageDirectory();
        else
            file = INTERNAL_STORAGE_DIRECTORY;
        return file;
    }

    public static long getTotalMemory() {
        if(sTotalMemory == 0L)
            try {
                String as[] = new String[1];
                as[0] = "MemTotal:";
                long al[] = new long[as.length];
                Process.readProcLines("/proc/meminfo", as, al);
                sTotalMemory = al[0];
            }
            catch(Exception exception) { }
        return sTotalMemory;
    }

    public static long getTotalPhysicalMemory() {
        if(sTotalPhysicalMemory == 0L)
            if(sDevice2Memory.containsKey(Build.DEVICE))
                sTotalPhysicalMemory = ((Long)sDevice2Memory.get(Build.DEVICE)).longValue();
            else
                sTotalPhysicalMemory = 1024L * (256L * (1L + getTotalMemory() / 0x40000L));
        return sTotalPhysicalMemory;
    }

    public static void init(File file, File file1) {
        ExtraFileUtils.mkdirs(new File(file, "customized_icons"), 1023, -1, -1);
        ExtraFileUtils.mkdirs(new File(file1, "sdcard"), 511, -1, -1);
    }

    public static boolean isExternalPath(String s) {
        boolean flag;
        if(s != null && (s.startsWith("/sdcard") || s.startsWith("/storage") || s.startsWith(getExternalStorageDirectory().getPath())))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isExternalStorageMounted() {
        return "mounted".equals(getExternalStorageState());
    }

    public static boolean isInternalStorageLow(ContentResolver contentresolver) {
        boolean flag = true;
        long l;
        long l1;
        StatFs statfs = new StatFs(INTERNAL_STORAGE_DIRECTORY.getPath());
        l = (long)statfs.getAvailableBlocks() * (long)statfs.getBlockSize();
        l1 = miui.provider.ExtraSettings.Secure.getStorageThreshold(contentresolver);
        if(l >= l1)
            flag = false;
_L2:
        return flag;
        Exception exception;
        exception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private static final File EXTERNAL_STORAGE_MIUI_DIRECTORY = new File(getExternalStorageDirectory(), "MIUI");
    private static final File INTERNAL_STORAGE_DIRECTORY;
    private static final File INTERNAL_STORAGE_MIUI_DIRECTORY;
    private static HashMap sDevice2Memory;
    private static long sTotalMemory;
    private static long sTotalPhysicalMemory;

    static  {
        INTERNAL_STORAGE_DIRECTORY = new File("/data/sdcard");
        INTERNAL_STORAGE_MIUI_DIRECTORY = new File(INTERNAL_STORAGE_DIRECTORY, "MIUI");
        sDevice2Memory = new HashMap();
        sDevice2Memory.put("hwu9200", Long.valueOf(0x100000L));
        sDevice2Memory.put("maguro", Long.valueOf(0x100000L));
        sDevice2Memory.put("ville", Long.valueOf(0x100000L));
        sDevice2Memory.put("LT26i", Long.valueOf(0x100000L));
        sDevice2Memory.put("ventana", Long.valueOf(0x100000L));
    }
}
