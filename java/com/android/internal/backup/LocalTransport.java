// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.backup;

import android.app.backup.*;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.*;
import android.util.Log;
import com.android.org.bouncycastle.util.encoders.Base64;
import java.io.*;

public class LocalTransport extends IBackupTransport.Stub {

    public LocalTransport(Context context) {
        mDataDir = new File(Environment.getDownloadCacheDirectory(), "backup");
        mRestorePackages = null;
        mRestorePackage = -1;
        mContext = context;
    }

    private void deleteContents(File file) {
        File afile[] = file.listFiles();
        if(afile != null) {
            int i = afile.length;
            for(int j = 0; j < i; j++) {
                File file1 = afile[j];
                if(file1.isDirectory())
                    deleteContents(file1);
                file1.delete();
            }

        }
    }

    public int clearBackupData(PackageInfo packageinfo) {
        Log.v("LocalTransport", (new StringBuilder()).append("clearBackupData() pkg=").append(packageinfo.packageName).toString());
        File file = new File(mDataDir, packageinfo.packageName);
        File afile[] = file.listFiles();
        if(afile != null) {
            int i = afile.length;
            for(int j = 0; j < i; j++)
                afile[j].delete();

            file.delete();
        }
        return 0;
    }

    public Intent configurationIntent() {
        return null;
    }

    public String currentDestinationString() {
        return "Backing up to debug-only private cache";
    }

    public int finishBackup() {
        Log.v("LocalTransport", "finishBackup()");
        return 0;
    }

    public void finishRestore() {
        Log.v("LocalTransport", "finishRestore()");
    }

    public RestoreSet[] getAvailableRestoreSets() throws RemoteException {
        RestoreSet restoreset = new RestoreSet("Local disk image", "flash", 1L);
        RestoreSet arestoreset[] = new RestoreSet[1];
        arestoreset[0] = restoreset;
        return arestoreset;
    }

    public long getCurrentRestoreSet() {
        return 1L;
    }

    public int getRestoreData(ParcelFileDescriptor parcelfiledescriptor) {
        File file;
        File afile[];
        if(mRestorePackages == null)
            throw new IllegalStateException("startRestore not called");
        if(mRestorePackage < 0)
            throw new IllegalStateException("nextRestorePackage not called");
        file = new File(mDataDir, mRestorePackages[mRestorePackage].packageName);
        afile = file.listFiles();
        if(afile != null) goto _L2; else goto _L1
_L1:
        int i;
        Log.e("LocalTransport", (new StringBuilder()).append("Error listing directory: ").append(file).toString());
        i = 1;
_L5:
        return i;
_L2:
        BackupDataOutput backupdataoutput;
        Log.v("LocalTransport", (new StringBuilder()).append("  getRestoreData() found ").append(afile.length).append(" key files").toString());
        backupdataoutput = new BackupDataOutput(parcelfiledescriptor.getFileDescriptor());
        int j;
        int k;
        j = afile.length;
        k = 0;
_L3:
        File file1;
        FileInputStream fileinputstream;
        if(k >= j)
            break MISSING_BLOCK_LABEL_307;
        file1 = afile[k];
        fileinputstream = new FileInputStream(file1);
        int l = (int)file1.length();
        byte abyte0[] = new byte[l];
        fileinputstream.read(abyte0);
        String s = new String(Base64.decode(file1.getName()));
        Log.v("LocalTransport", (new StringBuilder()).append("    ... key=").append(s).append(" size=").append(l).toString());
        backupdataoutput.writeEntityHeader(s, l);
        backupdataoutput.writeEntityData(abyte0, l);
        fileinputstream.close();
        k++;
          goto _L3
        Exception exception;
        exception;
        fileinputstream.close();
        throw exception;
        IOException ioexception;
        ioexception;
        Log.e("LocalTransport", "Unable to read backup records", ioexception);
        i = 1;
        continue; /* Loop/switch isn't completed */
        i = 0;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public int initializeDevice() {
        Log.v("LocalTransport", "wiping all data");
        deleteContents(mDataDir);
        return 0;
    }

    public String nextRestorePackage() {
        if(mRestorePackages == null)
            throw new IllegalStateException("startRestore not called");
_L4:
        int i;
        i = 1 + mRestorePackage;
        mRestorePackage = i;
        if(i >= mRestorePackages.length) goto _L2; else goto _L1
_L1:
        String s = mRestorePackages[mRestorePackage].packageName;
        if(!(new File(mDataDir, s)).isDirectory()) goto _L4; else goto _L3
_L3:
        Log.v("LocalTransport", (new StringBuilder()).append("  nextRestorePackage() = ").append(s).toString());
_L6:
        return s;
_L2:
        Log.v("LocalTransport", "  no more packages to restore");
        s = "";
        if(true) goto _L6; else goto _L5
_L5:
    }

    public int performBackup(PackageInfo packageinfo, ParcelFileDescriptor parcelfiledescriptor) {
        File file;
        BackupDataInput backupdatainput;
        int i;
        Log.v("LocalTransport", (new StringBuilder()).append("performBackup() pkg=").append(packageinfo.packageName).toString());
        file = new File(mDataDir, packageinfo.packageName);
        file.mkdirs();
        backupdatainput = new BackupDataInput(parcelfiledescriptor.getFileDescriptor());
        i = 512;
        byte abyte0[] = new byte[i];
_L3:
        File file1;
        int k;
        if(!backupdatainput.readNextHeader())
            break MISSING_BLOCK_LABEL_357;
        String s = backupdatainput.getKey();
        String s1 = new String(Base64.encode(s.getBytes()));
        file1 = new File(file, s1);
        k = backupdatainput.getDataSize();
        Log.v("LocalTransport", (new StringBuilder()).append("Got change set key=").append(s).append(" size=").append(k).append(" key64=").append(s1).toString());
        if(k < 0) goto _L2; else goto _L1
_L1:
        FileOutputStream fileoutputstream;
        if(file1.exists())
            file1.delete();
        fileoutputstream = new FileOutputStream(file1);
        if(k > i) {
            i = k;
            abyte0 = new byte[i];
        }
        backupdatainput.readEntityData(abyte0, 0, k);
        Log.v("LocalTransport", (new StringBuilder()).append("  data size ").append(k).toString());
        fileoutputstream.write(abyte0, 0, k);
        fileoutputstream.close();
          goto _L3
        IOException ioexception;
        ioexception;
        int j;
        Log.v("LocalTransport", "Exception reading backup input:", ioexception);
        j = 1;
_L4:
        return j;
        IOException ioexception1;
        ioexception1;
        Log.e("LocalTransport", (new StringBuilder()).append("Unable to update key file ").append(file1.getAbsolutePath()).toString());
        j = 1;
        fileoutputstream.close();
          goto _L4
        Exception exception;
        exception;
        fileoutputstream.close();
        throw exception;
_L2:
        file1.delete();
          goto _L3
        j = 0;
          goto _L4
    }

    public long requestBackupTime() {
        return 0L;
    }

    public int startRestore(long l, PackageInfo apackageinfo[]) {
        Log.v("LocalTransport", (new StringBuilder()).append("start restore ").append(l).toString());
        mRestorePackages = apackageinfo;
        mRestorePackage = -1;
        return 0;
    }

    public String transportDirName() {
        return "com.android.internal.backup.LocalTransport";
    }

    private static final boolean DEBUG = true;
    private static final long RESTORE_TOKEN = 1L;
    private static final String TAG = "LocalTransport";
    private static final String TRANSPORT_DESTINATION_STRING = "Backing up to debug-only private cache";
    private static final String TRANSPORT_DIR_NAME = "com.android.internal.backup.LocalTransport";
    private Context mContext;
    private File mDataDir;
    private int mRestorePackage;
    private PackageInfo mRestorePackages[];
}
