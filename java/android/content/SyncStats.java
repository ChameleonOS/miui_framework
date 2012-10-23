// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.os.Parcel;
import android.os.Parcelable;

public class SyncStats
    implements Parcelable {

    public SyncStats() {
        numAuthExceptions = 0L;
        numIoExceptions = 0L;
        numParseExceptions = 0L;
        numConflictDetectedExceptions = 0L;
        numInserts = 0L;
        numUpdates = 0L;
        numDeletes = 0L;
        numEntries = 0L;
        numSkippedEntries = 0L;
    }

    public SyncStats(Parcel parcel) {
        numAuthExceptions = parcel.readLong();
        numIoExceptions = parcel.readLong();
        numParseExceptions = parcel.readLong();
        numConflictDetectedExceptions = parcel.readLong();
        numInserts = parcel.readLong();
        numUpdates = parcel.readLong();
        numDeletes = parcel.readLong();
        numEntries = parcel.readLong();
        numSkippedEntries = parcel.readLong();
    }

    public void clear() {
        numAuthExceptions = 0L;
        numIoExceptions = 0L;
        numParseExceptions = 0L;
        numConflictDetectedExceptions = 0L;
        numInserts = 0L;
        numUpdates = 0L;
        numDeletes = 0L;
        numEntries = 0L;
        numSkippedEntries = 0L;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(" stats [");
        if(numAuthExceptions > 0L)
            stringbuilder.append(" numAuthExceptions: ").append(numAuthExceptions);
        if(numIoExceptions > 0L)
            stringbuilder.append(" numIoExceptions: ").append(numIoExceptions);
        if(numParseExceptions > 0L)
            stringbuilder.append(" numParseExceptions: ").append(numParseExceptions);
        if(numConflictDetectedExceptions > 0L)
            stringbuilder.append(" numConflictDetectedExceptions: ").append(numConflictDetectedExceptions);
        if(numInserts > 0L)
            stringbuilder.append(" numInserts: ").append(numInserts);
        if(numUpdates > 0L)
            stringbuilder.append(" numUpdates: ").append(numUpdates);
        if(numDeletes > 0L)
            stringbuilder.append(" numDeletes: ").append(numDeletes);
        if(numEntries > 0L)
            stringbuilder.append(" numEntries: ").append(numEntries);
        if(numSkippedEntries > 0L)
            stringbuilder.append(" numSkippedEntries: ").append(numSkippedEntries);
        stringbuilder.append("]");
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(numAuthExceptions);
        parcel.writeLong(numIoExceptions);
        parcel.writeLong(numParseExceptions);
        parcel.writeLong(numConflictDetectedExceptions);
        parcel.writeLong(numInserts);
        parcel.writeLong(numUpdates);
        parcel.writeLong(numDeletes);
        parcel.writeLong(numEntries);
        parcel.writeLong(numSkippedEntries);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SyncStats createFromParcel(Parcel parcel) {
            return new SyncStats(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public SyncStats[] newArray(int i) {
            return new SyncStats[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public long numAuthExceptions;
    public long numConflictDetectedExceptions;
    public long numDeletes;
    public long numEntries;
    public long numInserts;
    public long numIoExceptions;
    public long numParseExceptions;
    public long numSkippedEntries;
    public long numUpdates;

}
