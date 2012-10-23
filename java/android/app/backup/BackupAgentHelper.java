// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app.backup;

import android.os.ParcelFileDescriptor;
import java.io.IOException;

// Referenced classes of package android.app.backup:
//            BackupAgent, BackupHelperDispatcher, BackupHelper, BackupDataOutput, 
//            BackupDataInput

public class BackupAgentHelper extends BackupAgent {

    public BackupAgentHelper() {
        mDispatcher = new BackupHelperDispatcher();
    }

    public void addHelper(String s, BackupHelper backuphelper) {
        mDispatcher.addHelper(s, backuphelper);
    }

    public BackupHelperDispatcher getDispatcher() {
        return mDispatcher;
    }

    public void onBackup(ParcelFileDescriptor parcelfiledescriptor, BackupDataOutput backupdataoutput, ParcelFileDescriptor parcelfiledescriptor1) throws IOException {
        mDispatcher.performBackup(parcelfiledescriptor, backupdataoutput, parcelfiledescriptor1);
    }

    public void onRestore(BackupDataInput backupdatainput, int i, ParcelFileDescriptor parcelfiledescriptor) throws IOException {
        mDispatcher.performRestore(backupdatainput, i, parcelfiledescriptor);
    }

    static final String TAG = "BackupAgentHelper";
    BackupHelperDispatcher mDispatcher;
}
