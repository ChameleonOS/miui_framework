// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os.storage;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;

public class StorageVolume
    implements Parcelable {

    private StorageVolume(String s, int i, boolean flag, boolean flag1, int j, int k, boolean flag2, 
            long l) {
        mPath = s;
        mDescriptionId = i;
        mRemovable = flag;
        mEmulated = flag1;
        mMtpReserveSpace = j;
        mAllowMassStorage = flag2;
        mStorageId = k;
        mMaxFileSize = l;
    }

    StorageVolume(String s, int i, boolean flag, boolean flag1, int j, int k, boolean flag2, 
            long l, _cls1 _pcls1) {
        this(s, i, flag, flag1, j, k, flag2, l);
    }

    public StorageVolume(String s, int i, boolean flag, boolean flag1, int j, boolean flag2, long l) {
        mPath = s;
        mDescriptionId = i;
        mRemovable = flag;
        mEmulated = flag1;
        mMtpReserveSpace = j;
        mAllowMassStorage = flag2;
        mMaxFileSize = l;
    }

    public boolean allowMassStorage() {
        return mAllowMassStorage;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag;
        if((obj instanceof StorageVolume) && mPath != null) {
            StorageVolume storagevolume = (StorageVolume)obj;
            flag = mPath.equals(storagevolume.mPath);
        } else {
            flag = false;
        }
        return flag;
    }

    public String getDescription(Context context) {
        return context.getResources().getString(mDescriptionId);
    }

    public int getDescriptionId() {
        return mDescriptionId;
    }

    public long getMaxFileSize() {
        return mMaxFileSize;
    }

    public int getMtpReserveSpace() {
        return mMtpReserveSpace;
    }

    public String getPath() {
        return mPath;
    }

    public int getStorageId() {
        return mStorageId;
    }

    public int hashCode() {
        return mPath.hashCode();
    }

    public boolean isEmulated() {
        return mEmulated;
    }

    public boolean isRemovable() {
        return mRemovable;
    }

    public void setStorageId(int i) {
        mStorageId = 1 + (i + 1 << 16);
    }

    public String toString() {
        return (new StringBuilder()).append("StorageVolume [mAllowMassStorage=").append(mAllowMassStorage).append(", mDescriptionId=").append(mDescriptionId).append(", mEmulated=").append(mEmulated).append(", mMaxFileSize=").append(mMaxFileSize).append(", mMtpReserveSpace=").append(mMtpReserveSpace).append(", mPath=").append(mPath).append(", mRemovable=").append(mRemovable).append(", mStorageId=").append(mStorageId).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int j = 1;
        parcel.writeString(mPath);
        parcel.writeInt(mDescriptionId);
        int k;
        int l;
        if(mRemovable)
            k = j;
        else
            k = 0;
        parcel.writeInt(k);
        if(mEmulated)
            l = j;
        else
            l = 0;
        parcel.writeInt(l);
        parcel.writeInt(mStorageId);
        parcel.writeInt(mMtpReserveSpace);
        if(!mAllowMassStorage)
            j = 0;
        parcel.writeInt(j);
        parcel.writeLong(mMaxFileSize);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public StorageVolume createFromParcel(Parcel parcel) {
            boolean flag = true;
            String s = parcel.readString();
            int i = parcel.readInt();
            int j = parcel.readInt();
            int k = parcel.readInt();
            int l = parcel.readInt();
            int i1 = parcel.readInt();
            int j1 = parcel.readInt();
            long l1 = parcel.readLong();
            boolean flag1;
            boolean flag2;
            if(j == flag)
                flag1 = flag;
            else
                flag1 = false;
            if(k == flag)
                flag2 = flag;
            else
                flag2 = false;
            if(j1 != flag)
                flag = false;
            return new StorageVolume(s, i, flag1, flag2, i1, l, flag, l1);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public StorageVolume[] newArray(int i) {
            return new StorageVolume[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final String EXTRA_STORAGE_VOLUME = "storage_volume";
    private final boolean mAllowMassStorage;
    private final int mDescriptionId;
    private final boolean mEmulated;
    private final long mMaxFileSize;
    private final int mMtpReserveSpace;
    private final String mPath;
    private final boolean mRemovable;
    private int mStorageId;

}
