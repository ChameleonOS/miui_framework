// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.os;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.*;

public class PkgUsageStats
    implements Parcelable {

    public PkgUsageStats(Parcel parcel) {
        packageName = parcel.readString();
        launchCount = parcel.readInt();
        usageTime = parcel.readLong();
        int i = parcel.readInt();
        componentResumeTimes = new HashMap(i);
        for(int j = 0; j < i; j++) {
            String s = parcel.readString();
            long l = parcel.readLong();
            componentResumeTimes.put(s, Long.valueOf(l));
        }

    }

    public PkgUsageStats(PkgUsageStats pkgusagestats) {
        packageName = pkgusagestats.packageName;
        launchCount = pkgusagestats.launchCount;
        usageTime = pkgusagestats.usageTime;
        componentResumeTimes = new HashMap(pkgusagestats.componentResumeTimes);
    }

    public PkgUsageStats(String s, int i, long l, Map map) {
        packageName = s;
        launchCount = i;
        usageTime = l;
        componentResumeTimes = new HashMap(map);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return (new StringBuilder()).append("PkgUsageStats{").append(Integer.toHexString(System.identityHashCode(this))).append(" ").append(packageName).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(packageName);
        parcel.writeInt(launchCount);
        parcel.writeLong(usageTime);
        parcel.writeInt(componentResumeTimes.size());
        java.util.Map.Entry entry;
        for(Iterator iterator = componentResumeTimes.entrySet().iterator(); iterator.hasNext(); parcel.writeLong(((Long)entry.getValue()).longValue())) {
            entry = (java.util.Map.Entry)iterator.next();
            parcel.writeString((String)entry.getKey());
        }

    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public PkgUsageStats createFromParcel(Parcel parcel) {
            return new PkgUsageStats(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public PkgUsageStats[] newArray(int i) {
            return new PkgUsageStats[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public Map componentResumeTimes;
    public int launchCount;
    public String packageName;
    public long usageTime;

}
