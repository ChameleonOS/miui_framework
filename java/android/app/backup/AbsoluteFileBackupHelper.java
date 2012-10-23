// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app.backup;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import java.io.File;

// Referenced classes of package android.app.backup:
//            FileBackupHelperBase, BackupHelper, BackupDataInputStream, BackupDataOutput

public class AbsoluteFileBackupHelper extends FileBackupHelperBase
    implements BackupHelper {

    public transient AbsoluteFileBackupHelper(Context context, String as[]) {
        super(context);
        mContext = context;
        mFiles = as;
    }

    public void performBackup(ParcelFileDescriptor parcelfiledescriptor, BackupDataOutput backupdataoutput, ParcelFileDescriptor parcelfiledescriptor1) {
        performBackup_checked(parcelfiledescriptor, backupdataoutput, parcelfiledescriptor1, mFiles, mFiles);
    }

    public void restoreEntity(BackupDataInputStream backupdatainputstream) {
        String s = backupdatainputstream.getKey();
        if(isKeyInList(s, mFiles))
            writeFile(new File(s), backupdatainputstream);
    }

    public volatile void writeNewStateDescription(ParcelFileDescriptor parcelfiledescriptor) {
        super.writeNewStateDescription(parcelfiledescriptor);
    }

    private static final boolean DEBUG = false;
    private static final String TAG = "AbsoluteFileBackupHelper";
    Context mContext;
    String mFiles[];
}
