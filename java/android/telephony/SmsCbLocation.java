// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.telephony;

import android.os.Parcel;
import android.os.Parcelable;

public class SmsCbLocation
    implements Parcelable {

    public SmsCbLocation() {
        mPlmn = "";
        mLac = -1;
        mCid = -1;
    }

    public SmsCbLocation(Parcel parcel) {
        mPlmn = parcel.readString();
        mLac = parcel.readInt();
        mCid = parcel.readInt();
    }

    public SmsCbLocation(String s) {
        mPlmn = s;
        mLac = -1;
        mCid = -1;
    }

    public SmsCbLocation(String s, int i, int j) {
        mPlmn = s;
        mLac = i;
        mCid = j;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag = true;
        if(obj != this) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(obj == null || !(obj instanceof SmsCbLocation)) {
            flag = false;
        } else {
            SmsCbLocation smscblocation = (SmsCbLocation)obj;
            if(!mPlmn.equals(smscblocation.mPlmn) || mLac != smscblocation.mLac || mCid != smscblocation.mCid)
                flag = false;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public int getCid() {
        return mCid;
    }

    public int getLac() {
        return mLac;
    }

    public String getPlmn() {
        return mPlmn;
    }

    public int hashCode() {
        return 31 * (31 * mPlmn.hashCode() + mLac) + mCid;
    }

    public boolean isInLocationArea(SmsCbLocation smscblocation) {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_2;
        if((mCid == -1 || mCid == smscblocation.mCid) && (mLac == -1 || mLac == smscblocation.mLac))
            flag = mPlmn.equals(smscblocation.mPlmn);
        return flag;
    }

    public boolean isInLocationArea(String s, int i, int j) {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_3;
        if(mPlmn.equals(s) && (mLac == -1 || mLac == i) && (mCid == -1 || mCid == j))
            flag = true;
        return flag;
    }

    public String toString() {
        return (new StringBuilder()).append('[').append(mPlmn).append(',').append(mLac).append(',').append(mCid).append(']').toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mPlmn);
        parcel.writeInt(mLac);
        parcel.writeInt(mCid);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SmsCbLocation createFromParcel(Parcel parcel) {
            return new SmsCbLocation(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public SmsCbLocation[] newArray(int i) {
            return new SmsCbLocation[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private final int mCid;
    private final int mLac;
    private final String mPlmn;

}
