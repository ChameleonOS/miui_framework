// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;

public class PackageStats
    implements Parcelable {

    public PackageStats(PackageStats packagestats) {
        packageName = packagestats.packageName;
        codeSize = packagestats.codeSize;
        dataSize = packagestats.dataSize;
        cacheSize = packagestats.cacheSize;
        externalCodeSize = packagestats.externalCodeSize;
        externalDataSize = packagestats.externalDataSize;
        externalCacheSize = packagestats.externalCacheSize;
        externalMediaSize = packagestats.externalMediaSize;
        externalObbSize = packagestats.externalObbSize;
    }

    public PackageStats(Parcel parcel) {
        packageName = parcel.readString();
        codeSize = parcel.readLong();
        dataSize = parcel.readLong();
        cacheSize = parcel.readLong();
        externalCodeSize = parcel.readLong();
        externalDataSize = parcel.readLong();
        externalCacheSize = parcel.readLong();
        externalMediaSize = parcel.readLong();
        externalObbSize = parcel.readLong();
    }

    public PackageStats(String s) {
        packageName = s;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder("PackageStats{");
        stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringbuilder.append(" packageName=");
        stringbuilder.append(packageName);
        stringbuilder.append(",codeSize=");
        stringbuilder.append(codeSize);
        stringbuilder.append(",dataSize=");
        stringbuilder.append(dataSize);
        stringbuilder.append(",cacheSize=");
        stringbuilder.append(cacheSize);
        stringbuilder.append(",externalCodeSize=");
        stringbuilder.append(externalCodeSize);
        stringbuilder.append(",externalDataSize=");
        stringbuilder.append(externalDataSize);
        stringbuilder.append(",externalCacheSize=");
        stringbuilder.append(externalCacheSize);
        stringbuilder.append(",externalMediaSize=");
        stringbuilder.append(externalMediaSize);
        stringbuilder.append(",externalObbSize=");
        stringbuilder.append(externalObbSize);
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(packageName);
        parcel.writeLong(codeSize);
        parcel.writeLong(dataSize);
        parcel.writeLong(cacheSize);
        parcel.writeLong(externalCodeSize);
        parcel.writeLong(externalDataSize);
        parcel.writeLong(externalCacheSize);
        parcel.writeLong(externalMediaSize);
        parcel.writeLong(externalObbSize);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public PackageStats createFromParcel(Parcel parcel) {
            return new PackageStats(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public PackageStats[] newArray(int i) {
            return new PackageStats[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public long cacheSize;
    public long codeSize;
    public long dataSize;
    public long externalCacheSize;
    public long externalCodeSize;
    public long externalDataSize;
    public long externalMediaSize;
    public long externalObbSize;
    public String packageName;

}
