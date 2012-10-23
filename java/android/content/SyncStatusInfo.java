// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public class SyncStatusInfo
    implements Parcelable {

    SyncStatusInfo(int i) {
        authorityId = i;
    }

    SyncStatusInfo(Parcel parcel) {
        boolean flag = false;
        super();
        int i = parcel.readInt();
        if(i != 2 && i != 1)
            Log.w("SyncStatusInfo", (new StringBuilder()).append("Unknown version: ").append(i).toString());
        authorityId = parcel.readInt();
        totalElapsedTime = parcel.readLong();
        numSyncs = parcel.readInt();
        numSourcePoll = parcel.readInt();
        numSourceServer = parcel.readInt();
        numSourceLocal = parcel.readInt();
        numSourceUser = parcel.readInt();
        lastSuccessTime = parcel.readLong();
        lastSuccessSource = parcel.readInt();
        lastFailureTime = parcel.readLong();
        lastFailureSource = parcel.readInt();
        lastFailureMesg = parcel.readString();
        initialFailureTime = parcel.readLong();
        boolean flag1;
        if(parcel.readInt() != 0)
            flag1 = true;
        else
            flag1 = false;
        pending = flag1;
        if(parcel.readInt() != 0)
            flag = true;
        initialize = flag;
        if(i != 1) goto _L2; else goto _L1
_L1:
        periodicSyncTimes = null;
_L4:
        return;
_L2:
        int j;
        j = parcel.readInt();
        if(j >= 0)
            break; /* Loop/switch isn't completed */
        periodicSyncTimes = null;
        if(true) goto _L4; else goto _L3
_L3:
        periodicSyncTimes = new ArrayList();
        int k = 0;
        while(k < j)  {
            periodicSyncTimes.add(Long.valueOf(parcel.readLong()));
            k++;
        }
        if(true) goto _L4; else goto _L5
_L5:
    }

    private void ensurePeriodicSyncTimeSize(int i) {
        if(periodicSyncTimes == null)
            periodicSyncTimes = new ArrayList(0);
        int j = i + 1;
        if(periodicSyncTimes.size() < j) {
            for(int k = periodicSyncTimes.size(); k < j; k++)
                periodicSyncTimes.add(Long.valueOf(0L));

        }
    }

    public int describeContents() {
        return 0;
    }

    public int getLastFailureMesgAsInt(int i) {
        int j;
        if(lastFailureMesg == null)
            break MISSING_BLOCK_LABEL_19;
        j = Integer.parseInt(lastFailureMesg);
        i = j;
_L2:
        return i;
        NumberFormatException numberformatexception;
        numberformatexception;
        Log.d("Sync", (new StringBuilder()).append("error parsing lastFailureMesg of ").append(lastFailureMesg).toString(), numberformatexception);
        if(true) goto _L2; else goto _L1
_L1:
    }

    public long getPeriodicSyncTime(int i) {
        long l;
        if(periodicSyncTimes == null || periodicSyncTimes.size() < i + 1)
            l = 0L;
        else
            l = ((Long)periodicSyncTimes.get(i)).longValue();
        return l;
    }

    public void removePeriodicSyncTime(int i) {
        ensurePeriodicSyncTimeSize(i);
        periodicSyncTimes.remove(i);
    }

    public void setPeriodicSyncTime(int i, long l) {
        ensurePeriodicSyncTimeSize(i);
        periodicSyncTimes.set(i, Long.valueOf(l));
    }

    public void writeToParcel(Parcel parcel, int i) {
        int j = 1;
        parcel.writeInt(2);
        parcel.writeInt(authorityId);
        parcel.writeLong(totalElapsedTime);
        parcel.writeInt(numSyncs);
        parcel.writeInt(numSourcePoll);
        parcel.writeInt(numSourceServer);
        parcel.writeInt(numSourceLocal);
        parcel.writeInt(numSourceUser);
        parcel.writeLong(lastSuccessTime);
        parcel.writeInt(lastSuccessSource);
        parcel.writeLong(lastFailureTime);
        parcel.writeInt(lastFailureSource);
        parcel.writeString(lastFailureMesg);
        parcel.writeLong(initialFailureTime);
        int k;
        if(pending)
            k = j;
        else
            k = 0;
        parcel.writeInt(k);
        if(!initialize)
            j = 0;
        parcel.writeInt(j);
        if(periodicSyncTimes != null) {
            parcel.writeInt(periodicSyncTimes.size());
            for(Iterator iterator = periodicSyncTimes.iterator(); iterator.hasNext(); parcel.writeLong(((Long)iterator.next()).longValue()));
        } else {
            parcel.writeInt(-1);
        }
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SyncStatusInfo createFromParcel(Parcel parcel) {
            return new SyncStatusInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public SyncStatusInfo[] newArray(int i) {
            return new SyncStatusInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private static final String TAG = "Sync";
    static final int VERSION = 2;
    public final int authorityId;
    public long initialFailureTime;
    public boolean initialize;
    public String lastFailureMesg;
    public int lastFailureSource;
    public long lastFailureTime;
    public int lastSuccessSource;
    public long lastSuccessTime;
    public int numSourceLocal;
    public int numSourcePeriodic;
    public int numSourcePoll;
    public int numSourceServer;
    public int numSourceUser;
    public int numSyncs;
    public boolean pending;
    public ArrayList periodicSyncTimes;
    public long totalElapsedTime;

}
