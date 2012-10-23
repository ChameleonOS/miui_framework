// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import java.util.UUID;

// Referenced classes of package android.os:
//            Parcelable, Parcel

public final class ParcelUuid
    implements Parcelable {

    public ParcelUuid(UUID uuid) {
        mUuid = uuid;
    }

    public static ParcelUuid fromString(String s) {
        return new ParcelUuid(UUID.fromString(s));
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag = false;
        if(obj != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(this == obj)
            flag = true;
        else
        if(obj instanceof ParcelUuid) {
            ParcelUuid parceluuid = (ParcelUuid)obj;
            flag = mUuid.equals(parceluuid.mUuid);
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public UUID getUuid() {
        return mUuid;
    }

    public int hashCode() {
        return mUuid.hashCode();
    }

    public String toString() {
        return mUuid.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(mUuid.getMostSignificantBits());
        parcel.writeLong(mUuid.getLeastSignificantBits());
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        public ParcelUuid createFromParcel(Parcel parcel) {
            return new ParcelUuid(new UUID(parcel.readLong(), parcel.readLong()));
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public ParcelUuid[] newArray(int i) {
            return new ParcelUuid[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private final UUID mUuid;

}
