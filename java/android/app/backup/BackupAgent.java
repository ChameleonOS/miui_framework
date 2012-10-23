// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app.backup;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.os.*;
import android.util.Log;
import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import libcore.io.*;

// Referenced classes of package android.app.backup:
//            FullBackupDataOutput, FullBackup, BackupDataOutput, BackupDataInput, 
//            IBackupManager

public abstract class BackupAgent extends ContextWrapper {
    private class BackupServiceBinder extends android.app.IBackupAgent.Stub {

        public void doBackup(ParcelFileDescriptor parcelfiledescriptor, ParcelFileDescriptor parcelfiledescriptor1, ParcelFileDescriptor parcelfiledescriptor2, int i, IBackupManager ibackupmanager) throws RemoteException {
            long l;
            BackupDataOutput backupdataoutput;
            l = Binder.clearCallingIdentity();
            Log.v("BackupServiceBinder", "doBackup() invoked");
            backupdataoutput = new BackupDataOutput(parcelfiledescriptor1.getFileDescriptor());
            onBackup(parcelfiledescriptor, backupdataoutput, parcelfiledescriptor2);
            Binder.restoreCallingIdentity(l);
            ibackupmanager.opComplete(i);
_L2:
            return;
            IOException ioexception;
            ioexception;
            Log.d("BackupServiceBinder", (new StringBuilder()).append("onBackup (").append(getClass().getName()).append(") threw").toString(), ioexception);
            throw new RuntimeException(ioexception);
            Exception exception;
            exception;
            Binder.restoreCallingIdentity(l);
            RuntimeException runtimeexception;
            try {
                ibackupmanager.opComplete(i);
            }
            catch(RemoteException remoteexception) { }
            throw exception;
            runtimeexception;
            Log.d("BackupServiceBinder", (new StringBuilder()).append("onBackup (").append(getClass().getName()).append(") threw").toString(), runtimeexception);
            throw runtimeexception;
            RemoteException remoteexception1;
            remoteexception1;
            if(true) goto _L2; else goto _L1
_L1:
        }

        public void doFullBackup(ParcelFileDescriptor parcelfiledescriptor, int i, IBackupManager ibackupmanager) {
            long l;
            l = Binder.clearCallingIdentity();
            Log.v("BackupServiceBinder", "doFullBackup() invoked");
            onFullBackup(new FullBackupDataOutput(parcelfiledescriptor));
            RuntimeException runtimeexception;
            Exception exception;
            IOException ioexception;
            RemoteException remoteexception;
            IOException ioexception1;
            try {
                (new FileOutputStream(parcelfiledescriptor.getFileDescriptor())).write(new byte[4]);
            }
            catch(IOException ioexception2) {
                Log.e("BackupServiceBinder", "Unable to finalize backup stream!");
            }
            Binder.restoreCallingIdentity(l);
            ibackupmanager.opComplete(i);
_L2:
            return;
            ioexception1;
            Log.d("BackupServiceBinder", (new StringBuilder()).append("onBackup (").append(getClass().getName()).append(") threw").toString(), ioexception1);
            throw new RuntimeException(ioexception1);
            exception;
            try {
                (new FileOutputStream(parcelfiledescriptor.getFileDescriptor())).write(new byte[4]);
            }
            // Misplaced declaration of an exception variable
            catch(IOException ioexception) {
                Log.e("BackupServiceBinder", "Unable to finalize backup stream!");
            }
            Binder.restoreCallingIdentity(l);
            try {
                ibackupmanager.opComplete(i);
            }
            // Misplaced declaration of an exception variable
            catch(RemoteException remoteexception) { }
            throw exception;
            runtimeexception;
            Log.d("BackupServiceBinder", (new StringBuilder()).append("onBackup (").append(getClass().getName()).append(") threw").toString(), runtimeexception);
            throw runtimeexception;
            RemoteException remoteexception1;
            remoteexception1;
            if(true) goto _L2; else goto _L1
_L1:
        }

        public void doRestore(ParcelFileDescriptor parcelfiledescriptor, int i, ParcelFileDescriptor parcelfiledescriptor1, int j, IBackupManager ibackupmanager) throws RemoteException {
            long l;
            BackupDataInput backupdatainput;
            l = Binder.clearCallingIdentity();
            Log.v("BackupServiceBinder", "doRestore() invoked");
            backupdatainput = new BackupDataInput(parcelfiledescriptor.getFileDescriptor());
            onRestore(backupdatainput, i, parcelfiledescriptor1);
            Binder.restoreCallingIdentity(l);
            ibackupmanager.opComplete(j);
_L2:
            return;
            IOException ioexception;
            ioexception;
            Log.d("BackupServiceBinder", (new StringBuilder()).append("onRestore (").append(getClass().getName()).append(") threw").toString(), ioexception);
            throw new RuntimeException(ioexception);
            Exception exception;
            exception;
            Binder.restoreCallingIdentity(l);
            RuntimeException runtimeexception;
            try {
                ibackupmanager.opComplete(j);
            }
            catch(RemoteException remoteexception) { }
            throw exception;
            runtimeexception;
            Log.d("BackupServiceBinder", (new StringBuilder()).append("onRestore (").append(getClass().getName()).append(") threw").toString(), runtimeexception);
            throw runtimeexception;
            RemoteException remoteexception1;
            remoteexception1;
            if(true) goto _L2; else goto _L1
_L1:
        }

        public void doRestoreFile(ParcelFileDescriptor parcelfiledescriptor, long l, int i, String s, String s1, long l1, long l2, int j, IBackupManager ibackupmanager) throws RemoteException {
            long l3 = Binder.clearCallingIdentity();
            onRestoreFile(parcelfiledescriptor, l, i, s, s1, l1, l2);
            Binder.restoreCallingIdentity(l3);
            ibackupmanager.opComplete(j);
_L2:
            return;
            IOException ioexception;
            ioexception;
            throw new RuntimeException(ioexception);
            Exception exception;
            exception;
            Binder.restoreCallingIdentity(l3);
            try {
                ibackupmanager.opComplete(j);
            }
            catch(RemoteException remoteexception) { }
            throw exception;
            RemoteException remoteexception1;
            remoteexception1;
            if(true) goto _L2; else goto _L1
_L1:
        }

        private static final String TAG = "BackupServiceBinder";
        final BackupAgent this$0;

        private BackupServiceBinder() {
            this$0 = BackupAgent.this;
            super();
        }

    }


    public BackupAgent() {
        super(null);
    }

    public void attach(Context context) {
        attachBaseContext(context);
    }

    public final void fullBackupFile(File file, FullBackupDataOutput fullbackupdataoutput) {
        ApplicationInfo applicationinfo = getApplicationInfo();
        String s;
        String s1;
        String s2;
        String s3;
        String s4;
        s = (new File(applicationinfo.dataDir)).getCanonicalPath();
        s1 = getFilesDir().getCanonicalPath();
        s2 = getDatabasePath("foo").getParentFile().getCanonicalPath();
        s3 = getSharedPrefsFile("foo").getParentFile().getCanonicalPath();
        s4 = getCacheDir().getCanonicalPath();
        if(applicationinfo.nativeLibraryDir != null) goto _L2; else goto _L1
_L1:
        String s6 = null;
_L3:
        String s7 = file.getCanonicalPath();
        if(s7.startsWith(s4) || s7.startsWith(s6)) {
            Log.w("BackupAgent", "lib and cache files are not backed up");
        } else {
            String s8;
            String s9;
            if(s7.startsWith(s2)) {
                s8 = "db";
                s9 = s2;
            } else
            if(s7.startsWith(s3)) {
                s8 = "sp";
                s9 = s3;
            } else
            if(s7.startsWith(s1)) {
                s8 = "f";
                s9 = s1;
            } else {
label0:
                {
                    if(!s7.startsWith(s))
                        break label0;
                    s8 = "r";
                    s9 = s;
                }
            }
            Log.i("BackupAgent", (new StringBuilder()).append("backupFile() of ").append(s7).append(" => domain=").append(s8).append(" rootpath=").append(s9).toString());
            FullBackup.backupToTar(getPackageName(), s8, null, s9, s7, fullbackupdataoutput.getData());
        }
_L4:
        return;
_L2:
        String s5;
        try {
            s5 = (new File(applicationinfo.nativeLibraryDir)).getCanonicalPath();
        }
        catch(IOException ioexception) {
            Log.w("BackupAgent", "Unable to obtain canonical paths");
            break MISSING_BLOCK_LABEL_111;
        }
        s6 = s5;
          goto _L3
        Log.w("BackupAgent", (new StringBuilder()).append("File ").append(s7).append(" is in an unsupported location; skipping").toString());
          goto _L4
    }

    protected final void fullBackupFileTree(String s, String s1, String s2, HashSet hashset, FullBackupDataOutput fullbackupdataoutput) {
        File file = new File(s2);
        if(!file.exists()) goto _L2; else goto _L1
_L1:
        LinkedList linkedlist;
        linkedlist = new LinkedList();
        linkedlist.add(file);
_L4:
        String s3;
        if(linkedlist.size() <= 0)
            break; /* Loop/switch isn't completed */
        File file1 = (File)linkedlist.remove(0);
        StructStat structstat;
        File afile[];
        int i;
        int j;
        try {
            s3 = file1.getCanonicalPath();
            if(hashset != null && hashset.contains(s3))
                continue; /* Loop/switch isn't completed */
            structstat = Libcore.os.lstat(s3);
            if(OsConstants.S_ISLNK(structstat.st_mode)) {
                Log.i("BackupAgent", (new StringBuilder()).append("Symlink (skipping)!: ").append(file1).toString());
                continue; /* Loop/switch isn't completed */
            }
        }
        catch(IOException ioexception) {
            Log.w("BackupAgent", (new StringBuilder()).append("Error canonicalizing path of ").append(file1).toString());
            continue; /* Loop/switch isn't completed */
        }
        catch(ErrnoException errnoexception) {
            Log.w("BackupAgent", (new StringBuilder()).append("Error scanning file ").append(file1).append(" : ").append(errnoexception).toString());
            continue; /* Loop/switch isn't completed */
        }
        if(!OsConstants.S_ISDIR(structstat.st_mode))
            break MISSING_BLOCK_LABEL_255;
        afile = file1.listFiles();
        if(afile == null)
            break MISSING_BLOCK_LABEL_255;
        i = afile.length;
        j = 0;
_L3:
        if(j >= i)
            break MISSING_BLOCK_LABEL_255;
        linkedlist.add(0, afile[j]);
        j++;
          goto _L3
        FullBackup.backupToTar(s, s1, null, s2, s3, fullbackupdataoutput.getData());
        if(true) goto _L4; else goto _L2
_L2:
    }

    public abstract void onBackup(ParcelFileDescriptor parcelfiledescriptor, BackupDataOutput backupdataoutput, ParcelFileDescriptor parcelfiledescriptor1) throws IOException;

    public final IBinder onBind() {
        return mBinder;
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onFullBackup(FullBackupDataOutput fullbackupdataoutput) throws IOException {
        ApplicationInfo applicationinfo = getApplicationInfo();
        String s = (new File(applicationinfo.dataDir)).getCanonicalPath();
        String s1 = getFilesDir().getCanonicalPath();
        String s2 = getDatabasePath("foo").getParentFile().getCanonicalPath();
        String s3 = getSharedPrefsFile("foo").getParentFile().getCanonicalPath();
        String s4 = getCacheDir().getCanonicalPath();
        String s5;
        HashSet hashset;
        String s6;
        if(applicationinfo.nativeLibraryDir != null)
            s5 = (new File(applicationinfo.nativeLibraryDir)).getCanonicalPath();
        else
            s5 = null;
        hashset = new HashSet();
        s6 = getPackageName();
        if(s5 != null)
            hashset.add(s5);
        hashset.add(s4);
        hashset.add(s2);
        hashset.add(s3);
        hashset.add(s1);
        fullBackupFileTree(s6, "r", s, hashset, fullbackupdataoutput);
        hashset.add(s);
        hashset.remove(s1);
        fullBackupFileTree(s6, "f", s1, hashset, fullbackupdataoutput);
        hashset.add(s1);
        hashset.remove(s2);
        fullBackupFileTree(s6, "db", s2, hashset, fullbackupdataoutput);
        hashset.add(s2);
        hashset.remove(s3);
        fullBackupFileTree(s6, "sp", s3, hashset, fullbackupdataoutput);
    }

    public abstract void onRestore(BackupDataInput backupdatainput, int i, ParcelFileDescriptor parcelfiledescriptor) throws IOException;

    protected void onRestoreFile(ParcelFileDescriptor parcelfiledescriptor, long l, int i, String s, String s1, long l1, long l2) throws IOException {
        String s2 = null;
        Log.d("BackupAgent", (new StringBuilder()).append("onRestoreFile() size=").append(l).append(" type=").append(i).append(" domain=").append(s).append(" relpath=").append(s1).append(" mode=").append(l1).append(" mtime=").append(l2).toString());
        if(s.equals("f"))
            s2 = getFilesDir().getCanonicalPath();
        else
        if(s.equals("db"))
            s2 = getDatabasePath("foo").getParentFile().getCanonicalPath();
        else
        if(s.equals("r"))
            s2 = (new File(getApplicationInfo().dataDir)).getCanonicalPath();
        else
        if(s.equals("sp"))
            s2 = getSharedPrefsFile("foo").getParentFile().getCanonicalPath();
        else
        if(s.equals("c"))
            s2 = getCacheDir().getCanonicalPath();
        else
            Log.i("BackupAgent", (new StringBuilder()).append("Data restored from non-app domain ").append(s).append(", ignoring").toString());
        if(s2 != null) {
            File file = new File(s2, s1);
            Log.i("BackupAgent", (new StringBuilder()).append("[").append(s).append(" : ").append(s1).append("] mapped to ").append(file.getPath()).toString());
            onRestoreFile(parcelfiledescriptor, l, file, i, l1, l2);
        } else {
            Log.i("BackupAgent", (new StringBuilder()).append("[ skipping data from unsupported domain ").append(s).append("]").toString());
            FullBackup.restoreFile(parcelfiledescriptor, l, i, l1, l2, null);
        }
    }

    public void onRestoreFile(ParcelFileDescriptor parcelfiledescriptor, long l, File file, int i, long l1, 
            long l2) throws IOException {
        FullBackup.restoreFile(parcelfiledescriptor, l, i, l1, l2, file);
    }

    private static final boolean DEBUG = true;
    private static final String TAG = "BackupAgent";
    public static final int TYPE_DIRECTORY = 2;
    public static final int TYPE_EOF = 0;
    public static final int TYPE_FILE = 1;
    public static final int TYPE_SYMLINK = 3;
    private final IBinder mBinder = (new BackupServiceBinder()).asBinder();
}
