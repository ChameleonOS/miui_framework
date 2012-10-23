// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.telephony;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package android.telephony:
//            CellIdentity

public final class LteCellIdentity extends CellIdentity
    implements Parcelable {

    public LteCellIdentity(int i, int j, int k, int l, int i1, String s) {
        super(2, s);
        mMcc = i;
        mMnc = j;
        mCi = k;
        mPci = l;
        mTac = i1;
    }

    private LteCellIdentity(Parcel parcel) {
        super(parcel);
        mMcc = parcel.readInt();
        mMnc = parcel.readInt();
        mCi = parcel.readInt();
        mPci = parcel.readInt();
        mTac = parcel.readInt();
    }


    LteCellIdentity(LteCellIdentity ltecellidentity) {
        super(ltecellidentity);
        mMcc = ltecellidentity.mMcc;
        mMnc = ltecellidentity.mMnc;
        mCi = ltecellidentity.mCi;
        mPci = ltecellidentity.mPci;
        mTac = ltecellidentity.mTac;
    }

    public int describeContents() {
        return 0;
    }

    public int getCi() {
        return mCi;
    }

    public int getMcc() {
        return mMcc;
    }

    public int getMnc() {
        return mMnc;
    }

    public int getPci() {
        return mPci;
    }

    public int getTac() {
        return mTac;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(mMcc);
        parcel.writeInt(mMnc);
        parcel.writeInt(mCi);
        parcel.writeInt(mPci);
        parcel.writeInt(mTac);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public LteCellIdentity createFromParcel(Parcel parcel) {
            return new LteCellIdentity(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public LteCellIdentity[] newArray(int i) {
            return new LteCellIdentity[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private final int mCi;
    private final int mMcc;
    private final int mMnc;
    private final int mPci;
    private final int mTac;

}
