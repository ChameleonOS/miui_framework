// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app.backup;

import android.os.ParcelFileDescriptor;

// Referenced classes of package android.app.backup:
//            BackupDataOutput

public class FullBackupDataOutput {

    public FullBackupDataOutput(ParcelFileDescriptor parcelfiledescriptor) {
        mData = new BackupDataOutput(parcelfiledescriptor.getFileDescriptor());
    }

    public BackupDataOutput getData() {
        return mData;
    }

    private BackupDataOutput mData;
}
