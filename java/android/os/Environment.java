// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import android.os.storage.IMountService;
import android.os.storage.StorageVolume;
import android.util.Log;
import java.io.File;

// Referenced classes of package android.os:
//            ServiceManager, SystemProperties

public class Environment {

    public Environment() {
    }

    public static File getDataDirectory() {
        return DATA_DIRECTORY;
    }

    static File getDirectory(String s, String s1) {
        String s2 = System.getenv(s);
        File file;
        if(s2 == null)
            file = new File(s1);
        else
            file = new File(s2);
        return file;
    }

    public static File getDownloadCacheDirectory() {
        return DOWNLOAD_CACHE_DIRECTORY;
    }

    public static File getExternalStorageAndroidDataDir() {
        return EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY;
    }

    public static File getExternalStorageAppCacheDirectory(String s) {
        return new File(new File(EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY, s), "cache");
    }

    public static File getExternalStorageAppDataDirectory(String s) {
        return new File(EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY, s);
    }

    public static File getExternalStorageAppFilesDirectory(String s) {
        return new File(new File(EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY, s), "files");
    }

    public static File getExternalStorageAppMediaDirectory(String s) {
        return new File(EXTERNAL_STORAGE_ANDROID_MEDIA_DIRECTORY, s);
    }

    public static File getExternalStorageAppObbDirectory(String s) {
        return new File(EXTERNAL_STORAGE_ANDROID_OBB_DIRECTORY, s);
    }

    public static File getExternalStorageDirectory() {
        return EXTERNAL_STORAGE_DIRECTORY;
    }

    public static File getExternalStoragePublicDirectory(String s) {
        return new File(getExternalStorageDirectory(), s);
    }

    public static String getExternalStorageState() {
        String s1 = android.os.storage.IMountService.Stub.asInterface(ServiceManager.getService("mount")).getVolumeState(getExternalStorageDirectory().toString());
        String s = s1;
_L2:
        return s;
        Exception exception;
        exception;
        s = "removed";
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static File getMediaStorageDirectory() {
        return MEDIA_STORAGE_DIRECTORY;
    }

    private static StorageVolume getPrimaryVolume() {
        if(mPrimaryVolume != null) goto _L2; else goto _L1
_L1:
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        StorageVolume storagevolume = mPrimaryVolume;
        if(storagevolume != null)
            break MISSING_BLOCK_LABEL_41;
        try {
            mPrimaryVolume = (StorageVolume)android.os.storage.IMountService.Stub.asInterface(ServiceManager.getService("mount")).getVolumeList()[0];
        }
        catch(Exception exception1) {
            Log.e("Environment", "couldn't talk to MountService", exception1);
        }
        obj;
        JVM INSTR monitorexit ;
_L2:
        return mPrimaryVolume;
        Exception exception;
        exception;
        throw exception;
    }

    public static File getRootDirectory() {
        return ROOT_DIRECTORY;
    }

    public static File getSecureDataDirectory() {
        File file;
        if(isEncryptedFilesystemEnabled())
            file = SECURE_DATA_DIRECTORY;
        else
            file = DATA_DIRECTORY;
        return file;
    }

    public static File getSystemSecureDirectory() {
        File file;
        if(isEncryptedFilesystemEnabled())
            file = new File(SECURE_DATA_DIRECTORY, "system");
        else
            file = new File(DATA_DIRECTORY, "system");
        return file;
    }

    public static boolean isEncryptedFilesystemEnabled() {
        return SystemProperties.getBoolean("persist.security.efs.enabled", false);
    }

    public static boolean isExternalStorageEmulated() {
        StorageVolume storagevolume = getPrimaryVolume();
        boolean flag;
        if(storagevolume != null && storagevolume.isEmulated())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isExternalStorageRemovable() {
        StorageVolume storagevolume = getPrimaryVolume();
        boolean flag;
        if(storagevolume != null && storagevolume.isRemovable())
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static final File DATA_DIRECTORY = getDirectory("ANDROID_DATA", "/data");
    public static String DIRECTORY_ALARMS = "Alarms";
    public static String DIRECTORY_DCIM = "DCIM";
    public static String DIRECTORY_DOWNLOADS = "Download";
    public static String DIRECTORY_MOVIES = "Movies";
    public static String DIRECTORY_MUSIC = "Music";
    public static String DIRECTORY_NOTIFICATIONS = "Notifications";
    public static String DIRECTORY_PICTURES = "Pictures";
    public static String DIRECTORY_PODCASTS = "Podcasts";
    public static String DIRECTORY_RINGTONES = "Ringtones";
    private static final File DOWNLOAD_CACHE_DIRECTORY = getDirectory("DOWNLOAD_CACHE", "/cache");
    private static final File EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY = new File(new File(getDirectory("EXTERNAL_STORAGE", "/storage/sdcard0"), "Android"), "data");
    private static final File EXTERNAL_STORAGE_ANDROID_MEDIA_DIRECTORY = new File(new File(getDirectory("EXTERNAL_STORAGE", "/storage/sdcard0"), "Android"), "media");
    private static final File EXTERNAL_STORAGE_ANDROID_OBB_DIRECTORY = new File(new File(getDirectory("EXTERNAL_STORAGE", "/storage/sdcard0"), "Android"), "obb");
    private static final File EXTERNAL_STORAGE_DIRECTORY = getDirectory("EXTERNAL_STORAGE", "/storage/sdcard0");
    public static final String MEDIA_BAD_REMOVAL = "bad_removal";
    public static final String MEDIA_CHECKING = "checking";
    public static final String MEDIA_MOUNTED = "mounted";
    public static final String MEDIA_MOUNTED_READ_ONLY = "mounted_ro";
    public static final String MEDIA_NOFS = "nofs";
    public static final String MEDIA_REMOVED = "removed";
    public static final String MEDIA_SHARED = "shared";
    private static final File MEDIA_STORAGE_DIRECTORY = getDirectory("MEDIA_STORAGE", "/data/media");
    public static final String MEDIA_UNMOUNTABLE = "unmountable";
    public static final String MEDIA_UNMOUNTED = "unmounted";
    private static final File ROOT_DIRECTORY = getDirectory("ANDROID_ROOT", "/system");
    private static final File SECURE_DATA_DIRECTORY = getDirectory("ANDROID_SECURE_DATA", "/data/secure");
    private static final String SYSTEM_PROPERTY_EFS_ENABLED = "persist.security.efs.enabled";
    private static final String TAG = "Environment";
    private static final Object mLock = new Object();
    private static volatile StorageVolume mPrimaryVolume = null;

}
