// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.telephony;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package android.telephony:
//            CellIdentity

public final class GsmCellIdentity extends CellIdentity
    implements Parcelable {

    public GsmCellIdentity(int i, int j, int k, int l, int i1, String s) {
        super(1, s);
        mMcc = i;
        mMnc = j;
        mLac = k;
        mCid = l;
        mPsc = i1;
    }

    private GsmCellIdentity(Parcel parcel) {
        super(parcel);
        mMcc = parcel.readInt();
        mMnc = parcel.readInt();
        mLac = parcel.readInt();
        mCid = parcel.readInt();
        mPsc = parcel.readInt();
    }


    GsmCellIdentity(GsmCellIdentity gsmcellidentity) {
        super(gsmcellidentity);
        mMcc = gsmcellidentity.mMcc;
        mMnc = gsmcellidentity.mMnc;
        mLac = gsmcellidentity.mLac;
        mCid = gsmcellidentity.mCid;
        mPsc = gsmcellidentity.mPsc;
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

    public int getMcc() {
        return mMcc;
    }

    public int getMnc() {
        return mMnc;
    }

    public int getPsc() {
        return mPsc;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(mMcc);
        parcel.writeInt(mMnc);
        parcel.writeInt(mLac);
        parcel.writeInt(mCid);
        parcel.writeInt(mPsc);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public GsmCellIdentity createFromParcel(Parcel parcel) {
            return new GsmCellIdentity(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public GsmCellIdentity[] newArray(int i) {
            return new GsmCellIdentity[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private final int mCid;
    private final int mLac;
    private final int mMcc;
    private final int mMnc;
    private final int mPsc;

}
