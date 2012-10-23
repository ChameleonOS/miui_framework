// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app.backup;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.*;
import libcore.io.*;

// Referenced classes of package android.app.backup:
//            BackupDataOutput

public class FullBackup {

    public FullBackup() {
    }

    public static native int backupToTar(String s, String s1, String s2, String s3, String s4, BackupDataOutput backupdataoutput);

    public static void restoreFile(ParcelFileDescriptor parcelfiledescriptor, long l, int i, long l1, long l2, 
            File file) throws IOException {
        if(i != 2) goto _L2; else goto _L1
_L1:
        if(file != null)
            file.mkdirs();
_L3:
        if(l1 >= 0L && file != null) {
            long l4 = l1 & 448L;
            FileOutputStream fileoutputstream;
            byte abyte0[];
            long l3;
            FileInputStream fileinputstream;
            int j;
            int k;
            IOException ioexception;
            IOException ioexception1;
            File file1;
            FileOutputStream fileoutputstream1;
            try {
                Libcore.os.chmod(file.getPath(), (int)l4);
            }
            catch(ErrnoException errnoexception) {
                errnoexception.rethrowAsIOException();
            }
            file.setLastModified(l2);
        }
        return;
_L2:
        fileoutputstream = null;
        if(file == null)
            break MISSING_BLOCK_LABEL_105;
        file1 = file.getParentFile();
        if(!file1.exists())
            file1.mkdirs();
        fileoutputstream1 = new FileOutputStream(file);
        fileoutputstream = fileoutputstream1;
_L4:
        abyte0 = new byte[32768];
        l3 = l;
        fileinputstream = new FileInputStream(parcelfiledescriptor.getFileDescriptor());
_L5:
        if(l > 0L) {
            if(l > (long)abyte0.length)
                j = abyte0.length;
            else
                j = (int)l;
            k = fileinputstream.read(abyte0, 0, j);
            if(k > 0)
                break MISSING_BLOCK_LABEL_257;
            Log.w("FullBackup", (new StringBuilder()).append("Incomplete read: expected ").append(l).append(" but got ").append(l3 - l).toString());
        }
        if(fileoutputstream != null)
            fileoutputstream.close();
          goto _L3
        ioexception1;
        Log.e("FullBackup", (new StringBuilder()).append("Unable to create/open file ").append(file.getPath()).toString(), ioexception1);
          goto _L4
        if(fileoutputstream != null)
            try {
                fileoutputstream.write(abyte0, 0, k);
            }
            // Misplaced declaration of an exception variable
            catch(IOException ioexception) {
                Log.e("FullBackup", (new StringBuilder()).append("Unable to write to file ").append(file.getPath()).toString(), ioexception);
                fileoutputstream.close();
                fileoutputstream = null;
                file.delete();
            }
        l -= k;
          goto _L5
    }

    public static final String APK_TREE_TOKEN = "a";
    public static final String APPS_PREFIX = "apps/";
    public static final String CACHE_TREE_TOKEN = "c";
    public static final String CONF_TOKEN_INTENT_EXTRA = "conftoken";
    public static final String DATABASE_TREE_TOKEN = "db";
    public static final String DATA_TREE_TOKEN = "f";
    public static final String FULL_BACKUP_INTENT_ACTION = "fullback";
    public static final String FULL_RESTORE_INTENT_ACTION = "fullrest";
    public static final String OBB_TREE_TOKEN = "obb";
    public static final String ROOT_TREE_TOKEN = "r";
    public static final String SHAREDPREFS_TREE_TOKEN = "sp";
    public static final String SHARED_PREFIX = "shared/";
    public static final String SHARED_STORAGE_TOKEN = "shared";
    static final String TAG = "FullBackup";
}
