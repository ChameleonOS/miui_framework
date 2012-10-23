// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.telephony;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package android.telephony:
//            CellIdentity

public final class CdmaCellIdentity extends CellIdentity
    implements Parcelable {

    public CdmaCellIdentity(int i, int j, int k, int l, int i1, String s) {
        super(2, s);
        mNetworkId = i;
        mSystemId = j;
        mBasestationId = k;
        mLongitude = l;
        mLatitude = i1;
    }

    private CdmaCellIdentity(Parcel parcel) {
        super(parcel);
        mNetworkId = parcel.readInt();
        mSystemId = parcel.readInt();
        mBasestationId = parcel.readInt();
        mLongitude = parcel.readInt();
        mLatitude = parcel.readInt();
    }


    CdmaCellIdentity(CdmaCellIdentity cdmacellidentity) {
        super(cdmacellidentity);
        mNetworkId = cdmacellidentity.mNetworkId;
        mSystemId = cdmacellidentity.mSystemId;
        mBasestationId = cdmacellidentity.mBasestationId;
        mLongitude = cdmacellidentity.mLongitude;
        mLatitude = cdmacellidentity.mLatitude;
    }

    public int describeContents() {
        return 0;
    }

    public int getBasestationId() {
        return mBasestationId;
    }

    public int getLatitude() {
        return mLatitude;
    }

    public int getLongitude() {
        return mLongitude;
    }

    public int getNetworkId() {
        return mNetworkId;
    }

    public int getSystemId() {
        return mSystemId;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(mNetworkId);
        parcel.writeInt(mSystemId);
        parcel.writeInt(mBasestationId);
        parcel.writeInt(mLongitude);
        parcel.writeInt(mLatitude);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CdmaCellIdentity createFromParcel(Parcel parcel) {
            return new CdmaCellIdentity(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public CdmaCellIdentity[] newArray(int i) {
            return new CdmaCellIdentity[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private final int mBasestationId;
    private final int mLatitude;
    private final int mLongitude;
    private final int mNetworkId;
    private final int mSystemId;

}
