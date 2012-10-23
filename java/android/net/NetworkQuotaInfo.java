// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.os.Parcel;
import android.os.Parcelable;

public class NetworkQuotaInfo
    implements Parcelable {

    public NetworkQuotaInfo(long l, long l1, long l2) {
        mEstimatedBytes = l;
        mSoftLimitBytes = l1;
        mHardLimitBytes = l2;
    }

    public NetworkQuotaInfo(Parcel parcel) {
        mEstimatedBytes = parcel.readLong();
        mSoftLimitBytes = parcel.readLong();
        mHardLimitBytes = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public long getEstimatedBytes() {
        return mEstimatedBytes;
    }

    public long getHardLimitBytes() {
        return mHardLimitBytes;
    }

    public long getSoftLimitBytes() {
        return mSoftLimitBytes;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(mEstimatedBytes);
        parcel.writeLong(mSoftLimitBytes);
        parcel.writeLong(mHardLimitBytes);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public NetworkQuotaInfo createFromParcel(Parcel parcel) {
            return new NetworkQuotaInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public NetworkQuotaInfo[] newArray(int i) {
            return new NetworkQuotaInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final long NO_LIMIT = -1L;
    private final long mEstimatedBytes;
    private final long mHardLimitBytes;
    private final long mSoftLimitBytes;

}
