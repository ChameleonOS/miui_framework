// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.telephony;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package android.telephony:
//            SignalStrength, CellIdentity, GsmCellIdentity

public final class CellInfo
    implements Parcelable {

    public CellInfo(int i, long l, long l1, boolean flag, SignalStrength signalstrength, 
            CellIdentity cellidentity) {
        if(i < 0 || i > 4)
            mTimeStampType = 0;
        else
            mTimeStampType = i;
        mRegistered = flag;
        mTimeStamp = l;
        mTimingAdvance = l1;
        mStrength = new SignalStrength(signalstrength);
        mCellIdentityType = cellidentity.getCellIdType();
        mCellIdentity = cellidentity;
    }

    private CellInfo(Parcel parcel) {
        boolean flag = true;
        super();
        mTimeStampType = parcel.readInt();
        if(parcel.readInt() != flag)
            flag = false;
        mRegistered = flag;
        mTimeStamp = parcel.readLong();
        mTimingAdvance = parcel.readLong();
        mCellIdentityType = parcel.readInt();
        mStrength = (SignalStrength)SignalStrength.CREATOR.createFromParcel(parcel);
        mCellIdentityType;
        JVM INSTR tableswitch 1 1: default 88
    //                   1 99;
           goto _L1 _L2
_L1:
        mCellIdentity = null;
_L4:
        return;
_L2:
        mCellIdentity = (CellIdentity)GsmCellIdentity.CREATOR.createFromParcel(parcel);
        if(true) goto _L4; else goto _L3
_L3:
    }


    public CellInfo(CellInfo cellinfo) {
        mTimeStampType = cellinfo.mTimeStampType;
        mRegistered = cellinfo.mRegistered;
        mTimeStamp = cellinfo.mTimeStamp;
        mTimingAdvance = cellinfo.mTimingAdvance;
        mCellIdentityType = cellinfo.mCellIdentityType;
        mStrength = new SignalStrength(cellinfo.mStrength);
        mCellIdentityType;
        JVM INSTR tableswitch 1 1: default 80
    //                   1 86;
           goto _L1 _L2
_L1:
        mCellIdentity = null;
_L4:
        return;
_L2:
        mCellIdentity = new GsmCellIdentity((GsmCellIdentity)cellinfo.mCellIdentity);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int describeContents() {
        return 0;
    }

    public CellIdentity getCellIdentity() {
        return mCellIdentity;
    }

    public SignalStrength getSignalStrength() {
        return new SignalStrength(mStrength);
    }

    public long getTimeStamp() {
        return mTimeStamp;
    }

    public int getTimeStampType() {
        return mTimeStampType;
    }

    public long getTimingAdvance() {
        return mTimingAdvance;
    }

    public boolean isRegistered() {
        return mRegistered;
    }

    public String toString() {
        StringBuffer stringbuffer;
        stringbuffer = new StringBuffer();
        stringbuffer.append("TimeStampType: ");
        mTimeStampType;
        JVM INSTR tableswitch 1 4: default 48
    //                   1 174
    //                   2 184
    //                   3 194
    //                   4 204;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_204;
_L1:
        stringbuffer.append("unknown");
_L6:
        stringbuffer.append(", TimeStamp: ").append(mTimeStamp).append(" ns");
        StringBuffer stringbuffer1 = stringbuffer.append(", Registered: ");
        String s;
        if(mRegistered)
            s = "YES";
        else
            s = "NO";
        stringbuffer1.append(s);
        stringbuffer.append(", TimingAdvance: ").append(mTimingAdvance);
        stringbuffer.append((new StringBuilder()).append(", Strength : ").append(mStrength).toString());
        stringbuffer.append((new StringBuilder()).append(", Cell Iden: ").append(mCellIdentity).toString());
        return stringbuffer.toString();
_L2:
        stringbuffer.append("antenna");
          goto _L6
_L3:
        stringbuffer.append("modem");
          goto _L6
_L4:
        stringbuffer.append("oem_ril");
          goto _L6
        stringbuffer.append("java_ril");
          goto _L6
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mTimeStampType);
        int j;
        if(mRegistered)
            j = 1;
        else
            j = 0;
        parcel.writeInt(j);
        parcel.writeLong(mTimeStamp);
        parcel.writeLong(mTimingAdvance);
        parcel.writeInt(mCellIdentityType);
        mStrength.writeToParcel(parcel, i);
        mCellIdentity.writeToParcel(parcel, i);
    }

    public static final int CELL_INFO_TIMESTAMP_TYPE_ANTENNA = 1;
    public static final int CELL_INFO_TIMESTAMP_TYPE_JAVA_RIL = 4;
    public static final int CELL_INFO_TIMESTAMP_TYPE_MODEM = 2;
    public static final int CELL_INFO_TIMESTAMP_TYPE_OEM_RIL = 3;
    public static final int CELL_INFO_TIMESTAMP_TYPE_UNKNOWN;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CellInfo createFromParcel(Parcel parcel) {
            return new CellInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public CellInfo[] newArray(int i) {
            return new CellInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private final CellIdentity mCellIdentity;
    private final int mCellIdentityType;
    private final boolean mRegistered;
    private final SignalStrength mStrength;
    private final long mTimeStamp;
    private final int mTimeStampType;
    private final long mTimingAdvance;

}
