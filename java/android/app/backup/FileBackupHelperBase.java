// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app.backup;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.File;
import java.io.FileDescriptor;

// Referenced classes of package android.app.backup:
//            BackupDataOutput, BackupDataInputStream, BackupDataInput

class FileBackupHelperBase {

    FileBackupHelperBase(Context context) {
        mPtr = ctor();
        mContext = context;
    }

    private static native int ctor();

    private static native void dtor(int i);

    static void performBackup_checked(ParcelFileDescriptor parcelfiledescriptor, BackupDataOutput backupdataoutput, ParcelFileDescriptor parcelfiledescriptor1, String as[], String as1[]) {
        if(as.length != 0) {
            int i = as.length;
            for(int j = 0; j < i; j++) {
                String s = as[j];
                if(s.charAt(0) != '/')
                    throw new RuntimeException((new StringBuilder()).append("files must have all absolute paths: ").append(s).toString());
            }

            if(as.length != as1.length)
                throw new RuntimeException((new StringBuilder()).append("files.length=").append(as.length).append(" keys.length=").append(as1.length).toString());
            FileDescriptor filedescriptor;
            FileDescriptor filedescriptor1;
            if(parcelfiledescriptor != null)
                filedescriptor = parcelfiledescriptor.getFileDescriptor();
            else
                filedescriptor = null;
            filedescriptor1 = parcelfiledescriptor1.getFileDescriptor();
            if(filedescriptor1 == null)
                throw new NullPointerException();
            int k = performBackup_native(filedescriptor, backupdataoutput.mBackupWriter, filedescriptor1, as, as1);
            if(k != 0)
                throw new RuntimeException((new StringBuilder()).append("Backup failed 0x").append(Integer.toHexString(k)).toString());
        }
    }

    private static native int performBackup_native(FileDescriptor filedescriptor, int i, FileDescriptor filedescriptor1, String as[], String as1[]);

    private static native int writeFile_native(int i, String s, int j);

    private static native int writeSnapshot_native(int i, FileDescriptor filedescriptor);

    protected void finalize() throws Throwable {
        dtor(mPtr);
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    boolean isKeyInList(String s, String as[]) {
        int i;
        int j;
        i = as.length;
        j = 0;
_L3:
        if(j >= i)
            break MISSING_BLOCK_LABEL_35;
        if(!as[j].equals(s)) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        j++;
          goto _L3
        flag = false;
          goto _L4
    }

    boolean writeFile(File file, BackupDataInputStream backupdatainputstream) {
        boolean flag = true;
        file.getParentFile().mkdirs();
        int i = writeFile_native(mPtr, file.getAbsolutePath(), backupdatainputstream.mData.mBackupReader);
        if(i != 0 && !mExceptionLogged) {
            Log.e("FileBackupHelperBase", (new StringBuilder()).append("Failed restoring file '").append(file).append("' for app '").append(mContext.getPackageName()).append("' result=0x").append(Integer.toHexString(i)).toString());
            mExceptionLogged = flag;
        }
        if(i != 0)
            flag = false;
        return flag;
    }

    public void writeNewStateDescription(ParcelFileDescriptor parcelfiledescriptor) {
        writeSnapshot_native(mPtr, parcelfiledescriptor.getFileDescriptor());
    }

    private static final String TAG = "FileBackupHelperBase";
    Context mContext;
    boolean mExceptionLogged;
    int mPtr;
}
