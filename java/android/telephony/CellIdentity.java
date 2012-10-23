// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.telephony;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class CellIdentity
    implements Parcelable {

    protected CellIdentity(int i, String s) {
        mCellIdType = i;
        mCellIdAttributes = new String(s);
    }

    protected CellIdentity(Parcel parcel) {
        mCellIdType = parcel.readInt();
        mCellIdAttributes = new String(parcel.readString());
    }

    protected CellIdentity(CellIdentity cellidentity) {
        mCellIdType = cellidentity.mCellIdType;
        mCellIdAttributes = new String(cellidentity.mCellIdAttributes);
    }

    public int describeContents() {
        return 0;
    }

    public String getCellIdAttributes() {
        return mCellIdAttributes;
    }

    public int getCellIdType() {
        return mCellIdType;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mCellIdType);
        parcel.writeString(mCellIdAttributes);
    }

    public static final int CELLID_TYPE_CDMA = 2;
    public static final int CELLID_TYPE_GSM = 1;
    public static final int CELLID_TYPE_LTE = 3;
    private String mCellIdAttributes;
    private int mCellIdType;
}
