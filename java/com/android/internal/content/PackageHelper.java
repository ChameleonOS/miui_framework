// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.content;

import android.os.*;
import android.os.storage.IMountService;
import android.util.Log;
import java.io.*;
import java.util.*;
import java.util.zip.*;
import libcore.io.IoUtils;

public class PackageHelper {

    public PackageHelper() {
    }

    private static void copyZipEntry(ZipEntry zipentry, ZipFile zipfile, ZipOutputStream zipoutputstream) throws IOException {
        InputStream inputstream;
        byte abyte0[] = new byte[4096];
        ZipEntry zipentry1;
        Exception exception;
        int i;
        if(zipentry.getMethod() == 0)
            zipentry1 = new ZipEntry(zipentry);
        else
            zipentry1 = new ZipEntry(zipentry.getName());
        zipoutputstream.putNextEntry(zipentry1);
        inputstream = zipfile.getInputStream(zipentry);
        do {
            i = inputstream.read(abyte0);
            if(i <= 0)
                break;
            zipoutputstream.write(abyte0, 0, i);
        } while(true);
          goto _L1
        exception;
        IoUtils.closeQuietly(inputstream);
        throw exception;
_L1:
        zipoutputstream.flush();
        IoUtils.closeQuietly(inputstream);
        return;
    }

    public static String createSdDir(int i, String s, String s1, int j, boolean flag) {
        String s2;
        try {
            IMountService imountservice = getMountService();
            Log.i("PackageHelper", (new StringBuilder()).append("Size of container ").append(i).append(" MB").toString());
            if(imountservice.createSecureContainer(s, i, "ext4", s1, j, flag) != 0) {
                Log.e("PackageHelper", (new StringBuilder()).append("Failed to create secure container ").append(s).toString());
                s2 = null;
            } else {
                s2 = imountservice.getSecureContainerPath(s);
                Log.i("PackageHelper", (new StringBuilder()).append("Created secure container ").append(s).append(" at ").append(s2).toString());
            }
        }
        catch(RemoteException remoteexception) {
            Log.e("PackageHelper", "MountService running?");
            s2 = null;
        }
        return s2;
    }

    public static boolean destroySdDir(String s) {
        boolean flag = false;
        Log.i("PackageHelper", (new StringBuilder()).append("Forcibly destroying container ").append(s).toString());
        if(getMountService().destroySecureContainer(s, true) == 0) goto _L2; else goto _L1
_L1:
        Log.i("PackageHelper", (new StringBuilder()).append("Failed to destroy container ").append(s).toString());
_L4:
        return flag;
_L2:
        flag = true;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        Log.e("PackageHelper", (new StringBuilder()).append("Failed to destroy container ").append(s).append(" with exception ").append(remoteexception).toString());
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static int extractPublicFiles(String s, File file) throws IOException {
        FileOutputStream fileoutputstream;
        ZipOutputStream zipoutputstream;
        int i;
        ZipFile zipfile;
        Exception exception;
        Exception exception1;
        Iterator iterator;
        ZipEntry zipentry;
        String s1;
        if(file == null) {
            fileoutputstream = null;
            zipoutputstream = null;
        } else {
            fileoutputstream = new FileOutputStream(file);
            zipoutputstream = new ZipOutputStream(fileoutputstream);
        }
        i = 0;
        zipfile = new ZipFile(s);
        iterator = Collections.list(zipfile.entries()).iterator();
        do {
            if(!iterator.hasNext())
                break;
            zipentry = (ZipEntry)iterator.next();
            s1 = zipentry.getName();
            if("AndroidManifest.xml".equals(s1) || "resources.arsc".equals(s1) || s1.startsWith("res/")) {
                i = (int)((long)i + zipentry.getSize());
                if(file != null)
                    copyZipEntry(zipentry, zipfile, zipoutputstream);
            }
        } while(true);
        break MISSING_BLOCK_LABEL_160;
        exception;
        try {
            zipfile.close();
        }
        catch(IOException ioexception) { }
        throw exception;
        try {
            zipfile.close();
        }
        catch(IOException ioexception1) { }
        finally {
            IoUtils.closeQuietly(zipoutputstream);
            throw exception1;
        }
        if(file == null)
            break MISSING_BLOCK_LABEL_201;
        zipoutputstream.finish();
        zipoutputstream.flush();
        FileUtils.sync(fileoutputstream);
        zipoutputstream.close();
        FileUtils.setPermissions(file.getAbsolutePath(), 420, -1, -1);
        IoUtils.closeQuietly(zipoutputstream);
        return i;
    }

    public static boolean finalizeSdDir(String s) {
        boolean flag = false;
        if(getMountService().finalizeSecureContainer(s) == 0) goto _L2; else goto _L1
_L1:
        Log.i("PackageHelper", (new StringBuilder()).append("Failed to finalize container ").append(s).toString());
_L4:
        return flag;
_L2:
        flag = true;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        Log.e("PackageHelper", (new StringBuilder()).append("Failed to finalize container ").append(s).append(" with exception ").append(remoteexception).toString());
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static boolean fixSdPermissions(String s, int i, String s1) {
        boolean flag = false;
        if(getMountService().fixPermissionsSecureContainer(s, i, s1) == 0) goto _L2; else goto _L1
_L1:
        Log.i("PackageHelper", (new StringBuilder()).append("Failed to fixperms container ").append(s).toString());
_L4:
        return flag;
_L2:
        flag = true;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        Log.e("PackageHelper", (new StringBuilder()).append("Failed to fixperms container ").append(s).append(" with exception ").append(remoteexception).toString());
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static IMountService getMountService() throws RemoteException {
        android.os.IBinder ibinder = ServiceManager.getService("mount");
        if(ibinder != null) {
            return android.os.storage.IMountService.Stub.asInterface(ibinder);
        } else {
            Log.e("PackageHelper", "Can't get mount service");
            throw new RemoteException("Could not contact mount service");
        }
    }

    public static String getSdDir(String s) {
        String s2 = getMountService().getSecureContainerPath(s);
        String s1 = s2;
_L2:
        return s1;
        RemoteException remoteexception;
        remoteexception;
        Log.e("PackageHelper", (new StringBuilder()).append("Failed to get container path for ").append(s).append(" with exception ").append(remoteexception).toString());
        s1 = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static String getSdFilesystem(String s) {
        String s2 = getMountService().getSecureContainerFilesystemPath(s);
        String s1 = s2;
_L2:
        return s1;
        RemoteException remoteexception;
        remoteexception;
        Log.e("PackageHelper", (new StringBuilder()).append("Failed to get container path for ").append(s).append(" with exception ").append(remoteexception).toString());
        s1 = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static String[] getSecureContainerList() {
        String as1[] = getMountService().getSecureContainerList();
        String as[] = as1;
_L2:
        return as;
        RemoteException remoteexception;
        remoteexception;
        Log.e("PackageHelper", (new StringBuilder()).append("Failed to get secure container list with exception").append(remoteexception).toString());
        as = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static boolean isContainerMounted(String s) {
        boolean flag1 = getMountService().isSecureContainerMounted(s);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("PackageHelper", (new StringBuilder()).append("Failed to find out if container ").append(s).append(" mounted").toString());
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static String mountSdDir(String s, String s1, int i) {
        String s2 = null;
        String s3;
        int j = getMountService().mountSecureContainer(s, s1, i);
        if(j != 0) {
            Log.i("PackageHelper", (new StringBuilder()).append("Failed to mount container ").append(s).append(" rc : ").append(j).toString());
            break MISSING_BLOCK_LABEL_87;
        }
        s3 = getMountService().getSecureContainerPath(s);
        s2 = s3;
        break MISSING_BLOCK_LABEL_87;
        RemoteException remoteexception;
        remoteexception;
        Log.e("PackageHelper", "MountService running?");
        return s2;
    }

    public static boolean renameSdDir(String s, String s1) {
        boolean flag = false;
        int i = getMountService().renameSecureContainer(s, s1);
        if(i == 0) goto _L2; else goto _L1
_L1:
        Log.e("PackageHelper", (new StringBuilder()).append("Failed to rename ").append(s).append(" to ").append(s1).append("with rc ").append(i).toString());
_L4:
        return flag;
_L2:
        flag = true;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        Log.i("PackageHelper", (new StringBuilder()).append("Failed ot rename  ").append(s).append(" to ").append(s1).append(" with exception : ").append(remoteexception).toString());
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static boolean unMountSdDir(String s) {
        boolean flag = false;
        int i = getMountService().unmountSecureContainer(s, true);
        if(i == 0) goto _L2; else goto _L1
_L1:
        Log.e("PackageHelper", (new StringBuilder()).append("Failed to unmount ").append(s).append(" with rc ").append(i).toString());
_L4:
        return flag;
_L2:
        flag = true;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        Log.e("PackageHelper", "MountService running?");
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static final int APP_INSTALL_AUTO = 0;
    public static final int APP_INSTALL_EXTERNAL = 2;
    public static final int APP_INSTALL_INTERNAL = 1;
    public static final int RECOMMEND_FAILED_ALREADY_EXISTS = -4;
    public static final int RECOMMEND_FAILED_INSUFFICIENT_STORAGE = -1;
    public static final int RECOMMEND_FAILED_INVALID_APK = -2;
    public static final int RECOMMEND_FAILED_INVALID_LOCATION = -3;
    public static final int RECOMMEND_FAILED_INVALID_URI = -6;
    public static final int RECOMMEND_INSTALL_EXTERNAL = 2;
    public static final int RECOMMEND_INSTALL_INTERNAL = 1;
    public static final int RECOMMEND_MEDIA_UNAVAILABLE = -5;
    private static final String TAG = "PackageHelper";
    private static final boolean localLOGV = true;
}
