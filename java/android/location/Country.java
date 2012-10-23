// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.location;

import android.os.*;
import java.util.Locale;

public class Country
    implements Parcelable {

    public Country(Country country) {
        mCountryIso = country.mCountryIso;
        mSource = country.mSource;
        mTimestamp = country.mTimestamp;
    }

    public Country(String s, int i) {
        if(s == null || i < 0 || i > 3) {
            throw new IllegalArgumentException();
        } else {
            mCountryIso = s.toUpperCase(Locale.US);
            mSource = i;
            mTimestamp = SystemClock.elapsedRealtime();
            return;
        }
    }

    private Country(String s, int i, long l) {
        if(s == null || i < 0 || i > 3) {
            throw new IllegalArgumentException();
        } else {
            mCountryIso = s.toUpperCase(Locale.US);
            mSource = i;
            mTimestamp = l;
            return;
        }
    }

    Country(String s, int i, long l, _cls1 _pcls1) {
        this(s, i, l);
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
        if(obj instanceof Country) {
            Country country = (Country)obj;
            if(!mCountryIso.equals(country.getCountryIso()) || mSource != country.getSource())
                flag = false;
        } else {
            flag = false;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean equalsIgnoreSource(Country country) {
        boolean flag;
        if(country != null && mCountryIso.equals(country.getCountryIso()))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public final String getCountryIso() {
        return mCountryIso;
    }

    public final int getSource() {
        return mSource;
    }

    public final long getTimestamp() {
        return mTimestamp;
    }

    public int hashCode() {
        if(mHashCode == 0)
            mHashCode = 13 * (221 + mCountryIso.hashCode()) + mSource;
        return mHashCode;
    }

    public String toString() {
        return (new StringBuilder()).append("Country {ISO=").append(mCountryIso).append(", source=").append(mSource).append(", time=").append(mTimestamp).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mCountryIso);
        parcel.writeInt(mSource);
        parcel.writeLong(mTimestamp);
    }

    public static final int COUNTRY_SOURCE_LOCALE = 3;
    public static final int COUNTRY_SOURCE_LOCATION = 1;
    public static final int COUNTRY_SOURCE_NETWORK = 0;
    public static final int COUNTRY_SOURCE_SIM = 2;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Country createFromParcel(Parcel parcel) {
            return new Country(parcel.readString(), parcel.readInt(), parcel.readLong());
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public Country[] newArray(int i) {
            return new Country[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private final String mCountryIso;
    private int mHashCode;
    private final int mSource;
    private final long mTimestamp;

}
