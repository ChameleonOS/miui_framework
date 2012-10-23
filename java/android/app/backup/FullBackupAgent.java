// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app.backup;

import android.os.ParcelFileDescriptor;
import java.io.IOException;

// Referenced classes of package android.app.backup:
//            BackupAgent, BackupDataOutput, BackupDataInput

public class FullBackupAgent extends BackupAgent {

    public FullBackupAgent() {
    }

    public void onBackup(ParcelFileDescriptor parcelfiledescriptor, BackupDataOutput backupdataoutput, ParcelFileDescriptor parcelfiledescriptor1) throws IOException {
    }

    public void onRestore(BackupDataInput backupdatainput, int i, ParcelFileDescriptor parcelfiledescriptor) throws IOException {
    }
}
