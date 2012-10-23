// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package android.content:
//            SyncStats

public final class SyncResult
    implements Parcelable {

    public SyncResult() {
        this(false);
    }

    private SyncResult(Parcel parcel) {
        boolean flag = true;
        super();
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        boolean flag6;
        if(parcel.readInt() != 0)
            flag1 = flag;
        else
            flag1 = false;
        syncAlreadyInProgress = flag1;
        if(parcel.readInt() != 0)
            flag2 = flag;
        else
            flag2 = false;
        tooManyDeletions = flag2;
        if(parcel.readInt() != 0)
            flag3 = flag;
        else
            flag3 = false;
        tooManyRetries = flag3;
        if(parcel.readInt() != 0)
            flag4 = flag;
        else
            flag4 = false;
        databaseError = flag4;
        if(parcel.readInt() != 0)
            flag5 = flag;
        else
            flag5 = false;
        fullSyncRequested = flag5;
        if(parcel.readInt() != 0)
            flag6 = flag;
        else
            flag6 = false;
        partialSyncUnavailable = flag6;
        if(parcel.readInt() == 0)
            flag = false;
        moreRecordsToGet = flag;
        delayUntil = parcel.readLong();
        stats = new SyncStats(parcel);
    }


    private SyncResult(boolean flag) {
        syncAlreadyInProgress = flag;
        tooManyDeletions = false;
        tooManyRetries = false;
        fullSyncRequested = false;
        partialSyncUnavailable = false;
        moreRecordsToGet = false;
        delayUntil = 0L;
        stats = new SyncStats();
    }

    public void clear() {
        if(syncAlreadyInProgress) {
            throw new UnsupportedOperationException("you are not allowed to clear the ALREADY_IN_PROGRESS SyncStats");
        } else {
            tooManyDeletions = false;
            tooManyRetries = false;
            databaseError = false;
            fullSyncRequested = false;
            partialSyncUnavailable = false;
            moreRecordsToGet = false;
            delayUntil = 0L;
            stats.clear();
            return;
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean hasError() {
        boolean flag;
        if(hasSoftError() || hasHardError())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean hasHardError() {
        boolean flag;
        if(stats.numParseExceptions > 0L || stats.numConflictDetectedExceptions > 0L || stats.numAuthExceptions > 0L || tooManyDeletions || tooManyRetries || databaseError)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean hasSoftError() {
        boolean flag;
        if(syncAlreadyInProgress || stats.numIoExceptions > 0L)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean madeSomeProgress() {
        boolean flag;
        if(stats.numDeletes > 0L && !tooManyDeletions || stats.numInserts > 0L || stats.numUpdates > 0L)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public String toDebugString() {
        StringBuffer stringbuffer = new StringBuffer();
        if(fullSyncRequested)
            stringbuffer.append("f1");
        if(partialSyncUnavailable)
            stringbuffer.append("r1");
        if(hasHardError())
            stringbuffer.append("X1");
        if(stats.numParseExceptions > 0L)
            stringbuffer.append("e").append(stats.numParseExceptions);
        if(stats.numConflictDetectedExceptions > 0L)
            stringbuffer.append("c").append(stats.numConflictDetectedExceptions);
        if(stats.numAuthExceptions > 0L)
            stringbuffer.append("a").append(stats.numAuthExceptions);
        if(tooManyDeletions)
            stringbuffer.append("D1");
        if(tooManyRetries)
            stringbuffer.append("R1");
        if(databaseError)
            stringbuffer.append("b1");
        if(hasSoftError())
            stringbuffer.append("x1");
        if(syncAlreadyInProgress)
            stringbuffer.append("l1");
        if(stats.numIoExceptions > 0L)
            stringbuffer.append("I").append(stats.numIoExceptions);
        return stringbuffer.toString();
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("SyncResult:");
        if(syncAlreadyInProgress)
            stringbuilder.append(" syncAlreadyInProgress: ").append(syncAlreadyInProgress);
        if(tooManyDeletions)
            stringbuilder.append(" tooManyDeletions: ").append(tooManyDeletions);
        if(tooManyRetries)
            stringbuilder.append(" tooManyRetries: ").append(tooManyRetries);
        if(databaseError)
            stringbuilder.append(" databaseError: ").append(databaseError);
        if(fullSyncRequested)
            stringbuilder.append(" fullSyncRequested: ").append(fullSyncRequested);
        if(partialSyncUnavailable)
            stringbuilder.append(" partialSyncUnavailable: ").append(partialSyncUnavailable);
        if(moreRecordsToGet)
            stringbuilder.append(" moreRecordsToGet: ").append(moreRecordsToGet);
        if(delayUntil > 0L)
            stringbuilder.append(" delayUntil: ").append(delayUntil);
        stringbuilder.append(stats);
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int j = 1;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        if(syncAlreadyInProgress)
            k = j;
        else
            k = 0;
        parcel.writeInt(k);
        if(tooManyDeletions)
            l = j;
        else
            l = 0;
        parcel.writeInt(l);
        if(tooManyRetries)
            i1 = j;
        else
            i1 = 0;
        parcel.writeInt(i1);
        if(databaseError)
            j1 = j;
        else
            j1 = 0;
        parcel.writeInt(j1);
        if(fullSyncRequested)
            k1 = j;
        else
            k1 = 0;
        parcel.writeInt(k1);
        if(partialSyncUnavailable)
            l1 = j;
        else
            l1 = 0;
        parcel.writeInt(l1);
        if(!moreRecordsToGet)
            j = 0;
        parcel.writeInt(j);
        parcel.writeLong(delayUntil);
        stats.writeToParcel(parcel, i);
    }

    public static final SyncResult ALREADY_IN_PROGRESS = new SyncResult(true);
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SyncResult createFromParcel(Parcel parcel) {
            return new SyncResult(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public SyncResult[] newArray(int i) {
            return new SyncResult[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public boolean databaseError;
    public long delayUntil;
    public boolean fullSyncRequested;
    public boolean moreRecordsToGet;
    public boolean partialSyncUnavailable;
    public final SyncStats stats;
    public final boolean syncAlreadyInProgress;
    public boolean tooManyDeletions;
    public boolean tooManyRetries;

}
