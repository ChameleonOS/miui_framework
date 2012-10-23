// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.telephony;

import android.os.Parcel;
import android.os.Parcelable;

public class NeighboringCellInfo
    implements Parcelable {

    public NeighboringCellInfo() {
        mRssi = 99;
        mLac = -1;
        mCid = -1;
        mPsc = -1;
        mNetworkType = 0;
    }

    public NeighboringCellInfo(int i, int j) {
        mRssi = i;
        mCid = j;
    }

    public NeighboringCellInfo(int i, String s, int j) {
        int k;
        mRssi = i;
        mNetworkType = 0;
        mPsc = -1;
        mLac = -1;
        mCid = -1;
        k = s.length();
        if(k <= 8) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(k < 8) {
            for(int l = 0; l < 8 - k; l++)
                s = (new StringBuilder()).append("0").append(s).toString();

        }
        j;
        JVM INSTR tableswitch 1 10: default 148
    //                   1 151
    //                   2 151
    //                   3 231
    //                   4 148
    //                   5 148
    //                   6 148
    //                   7 148
    //                   8 231
    //                   9 231
    //                   10 231;
           goto _L3 _L4 _L4 _L5 _L3 _L3 _L3 _L3 _L5 _L5 _L5
_L3:
        continue; /* Loop/switch isn't completed */
_L4:
        NumberFormatException numberformatexception;
        mNetworkType = j;
        if(!s.equalsIgnoreCase("FFFFFFFF")) {
            mCid = Integer.valueOf(s.substring(4), 16).intValue();
            mLac = Integer.valueOf(s.substring(0, 4), 16).intValue();
        }
        continue; /* Loop/switch isn't completed */
_L5:
        try {
            mNetworkType = j;
            mPsc = Integer.valueOf(s, 16).intValue();
        }
        // Misplaced declaration of an exception variable
        catch(NumberFormatException numberformatexception) {
            mPsc = -1;
            mLac = -1;
            mCid = -1;
            mNetworkType = 0;
        }
        if(true) goto _L1; else goto _L6
_L6:
    }

    public NeighboringCellInfo(Parcel parcel) {
        mRssi = parcel.readInt();
        mLac = parcel.readInt();
        mCid = parcel.readInt();
        mPsc = parcel.readInt();
        mNetworkType = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public int getCid() {
        return mCid;
    }

    public int getLac() {
        return mLac;
    }

    public int getNetworkType() {
        return mNetworkType;
    }

    public int getPsc() {
        return mPsc;
    }

    public int getRssi() {
        return mRssi;
    }

    public void setCid(int i) {
        mCid = i;
    }

    public void setRssi(int i) {
        mRssi = i;
    }

    public String toString() {
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder();
        stringbuilder.append("[");
        if(mPsc == -1) goto _L2; else goto _L1
_L1:
        StringBuilder stringbuilder2 = stringbuilder.append(Integer.toHexString(mPsc)).append("@");
        Object obj1;
        if(mRssi == 99)
            obj1 = "-";
        else
            obj1 = Integer.valueOf(mRssi);
        stringbuilder2.append(obj1);
_L4:
        stringbuilder.append("]");
        return stringbuilder.toString();
_L2:
        if(mLac != -1 && mCid != -1) {
            StringBuilder stringbuilder1 = stringbuilder.append(Integer.toHexString(mLac)).append(Integer.toHexString(mCid)).append("@");
            Object obj;
            if(mRssi == 99)
                obj = "-";
            else
                obj = Integer.valueOf(mRssi);
            stringbuilder1.append(obj);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mRssi);
        parcel.writeInt(mLac);
        parcel.writeInt(mCid);
        parcel.writeInt(mPsc);
        parcel.writeInt(mNetworkType);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public NeighboringCellInfo createFromParcel(Parcel parcel) {
            return new NeighboringCellInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public NeighboringCellInfo[] newArray(int i) {
            return new NeighboringCellInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int UNKNOWN_CID = -1;
    public static final int UNKNOWN_RSSI = 99;
    private int mCid;
    private int mLac;
    private int mNetworkType;
    private int mPsc;
    private int mRssi;

}
