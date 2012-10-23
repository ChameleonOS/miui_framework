// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.mtp;

import android.content.Context;
import android.content.res.Resources;
import android.os.storage.StorageVolume;

public class MtpStorage {

    public MtpStorage(StorageVolume storagevolume, Context context) {
        mStorageId = storagevolume.getStorageId();
        mPath = storagevolume.getPath();
        mDescription = context.getResources().getString(storagevolume.getDescriptionId());
        mReserveSpace = storagevolume.getMtpReserveSpace();
        mRemovable = storagevolume.isRemovable();
        mMaxFileSize = storagevolume.getMaxFileSize();
    }

    public static int getStorageId(int i) {
        return 1 + (i + 1 << 16);
    }

    public final String getDescription() {
        return mDescription;
    }

    public long getMaxFileSize() {
        return mMaxFileSize;
    }

    public final String getPath() {
        return mPath;
    }

    public final long getReserveSpace() {
        return mReserveSpace;
    }

    public final int getStorageId() {
        return mStorageId;
    }

    public final boolean isRemovable() {
        return mRemovable;
    }

    private final String mDescription;
    private final long mMaxFileSize;
    private final String mPath;
    private final boolean mRemovable;
    private final long mReserveSpace;
    private final int mStorageId;
}
