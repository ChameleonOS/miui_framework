// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.mtp;


public final class MtpStorageInfo {

    private MtpStorageInfo() {
    }

    public final String getDescription() {
        return mDescription;
    }

    public final long getFreeSpace() {
        return mFreeSpace;
    }

    public final long getMaxCapacity() {
        return mMaxCapacity;
    }

    public final int getStorageId() {
        return mStorageId;
    }

    public final String getVolumeIdentifier() {
        return mVolumeIdentifier;
    }

    private String mDescription;
    private long mFreeSpace;
    private long mMaxCapacity;
    private int mStorageId;
    private String mVolumeIdentifier;
}
