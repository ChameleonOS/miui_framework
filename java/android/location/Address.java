// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.location;

import android.os.*;
import java.util.*;

public class Address
    implements Parcelable {

    public Address(Locale locale) {
        mMaxAddressLineIndex = -1;
        mHasLatitude = false;
        mHasLongitude = false;
        mExtras = null;
        mLocale = locale;
    }

    public void clearLatitude() {
        mHasLatitude = false;
    }

    public void clearLongitude() {
        mHasLongitude = false;
    }

    public int describeContents() {
        int i;
        if(mExtras != null)
            i = mExtras.describeContents();
        else
            i = 0;
        return i;
    }

    public String getAddressLine(int i) {
        if(i < 0)
            throw new IllegalArgumentException((new StringBuilder()).append("index = ").append(i).append(" < 0").toString());
        String s;
        if(mAddressLines == null)
            s = null;
        else
            s = (String)mAddressLines.get(Integer.valueOf(i));
        return s;
    }

    public String getAdminArea() {
        return mAdminArea;
    }

    public String getCountryCode() {
        return mCountryCode;
    }

    public String getCountryName() {
        return mCountryName;
    }

    public Bundle getExtras() {
        return mExtras;
    }

    public String getFeatureName() {
        return mFeatureName;
    }

    public double getLatitude() {
        if(mHasLatitude)
            return mLatitude;
        else
            throw new IllegalStateException();
    }

    public Locale getLocale() {
        return mLocale;
    }

    public String getLocality() {
        return mLocality;
    }

    public double getLongitude() {
        if(mHasLongitude)
            return mLongitude;
        else
            throw new IllegalStateException();
    }

    public int getMaxAddressLineIndex() {
        return mMaxAddressLineIndex;
    }

    public String getPhone() {
        return mPhone;
    }

    public String getPostalCode() {
        return mPostalCode;
    }

    public String getPremises() {
        return mPremises;
    }

    public String getSubAdminArea() {
        return mSubAdminArea;
    }

    public String getSubLocality() {
        return mSubLocality;
    }

    public String getSubThoroughfare() {
        return mSubThoroughfare;
    }

    public String getThoroughfare() {
        return mThoroughfare;
    }

    public String getUrl() {
        return mUrl;
    }

    public boolean hasLatitude() {
        return mHasLatitude;
    }

    public boolean hasLongitude() {
        return mHasLongitude;
    }

    public void setAddressLine(int i, String s) {
        if(i < 0)
            throw new IllegalArgumentException((new StringBuilder()).append("index = ").append(i).append(" < 0").toString());
        if(mAddressLines == null)
            mAddressLines = new HashMap();
        mAddressLines.put(Integer.valueOf(i), s);
        if(s == null) {
            mMaxAddressLineIndex = -1;
            for(Iterator iterator = mAddressLines.keySet().iterator(); iterator.hasNext();) {
                Integer integer = (Integer)iterator.next();
                mMaxAddressLineIndex = Math.max(mMaxAddressLineIndex, integer.intValue());
            }

        } else {
            mMaxAddressLineIndex = Math.max(mMaxAddressLineIndex, i);
        }
    }

    public void setAdminArea(String s) {
        mAdminArea = s;
    }

    public void setCountryCode(String s) {
        mCountryCode = s;
    }

    public void setCountryName(String s) {
        mCountryName = s;
    }

    public void setExtras(Bundle bundle) {
        Bundle bundle1;
        if(bundle == null)
            bundle1 = null;
        else
            bundle1 = new Bundle(bundle);
        mExtras = bundle1;
    }

    public void setFeatureName(String s) {
        mFeatureName = s;
    }

    public void setLatitude(double d) {
        mLatitude = d;
        mHasLatitude = true;
    }

    public void setLocality(String s) {
        mLocality = s;
    }

    public void setLongitude(double d) {
        mLongitude = d;
        mHasLongitude = true;
    }

    public void setPhone(String s) {
        mPhone = s;
    }

    public void setPostalCode(String s) {
        mPostalCode = s;
    }

    public void setPremises(String s) {
        mPremises = s;
    }

    public void setSubAdminArea(String s) {
        mSubAdminArea = s;
    }

    public void setSubLocality(String s) {
        mSubLocality = s;
    }

    public void setSubThoroughfare(String s) {
        mSubThoroughfare = s;
    }

    public void setThoroughfare(String s) {
        mThoroughfare = s;
    }

    public void setUrl(String s) {
        mUrl = s;
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Address[addressLines=[");
        int i = 0;
        while(i <= mMaxAddressLineIndex)  {
            if(i > 0)
                stringbuilder.append(',');
            stringbuilder.append(i);
            stringbuilder.append(':');
            String s = (String)mAddressLines.get(Integer.valueOf(i));
            if(s == null) {
                stringbuilder.append("null");
            } else {
                stringbuilder.append('"');
                stringbuilder.append(s);
                stringbuilder.append('"');
            }
            i++;
        }
        stringbuilder.append(']');
        stringbuilder.append(",feature=");
        stringbuilder.append(mFeatureName);
        stringbuilder.append(",admin=");
        stringbuilder.append(mAdminArea);
        stringbuilder.append(",sub-admin=");
        stringbuilder.append(mSubAdminArea);
        stringbuilder.append(",locality=");
        stringbuilder.append(mLocality);
        stringbuilder.append(",thoroughfare=");
        stringbuilder.append(mThoroughfare);
        stringbuilder.append(",postalCode=");
        stringbuilder.append(mPostalCode);
        stringbuilder.append(",countryCode=");
        stringbuilder.append(mCountryCode);
        stringbuilder.append(",countryName=");
        stringbuilder.append(mCountryName);
        stringbuilder.append(",hasLatitude=");
        stringbuilder.append(mHasLatitude);
        stringbuilder.append(",latitude=");
        stringbuilder.append(mLatitude);
        stringbuilder.append(",hasLongitude=");
        stringbuilder.append(mHasLongitude);
        stringbuilder.append(",longitude=");
        stringbuilder.append(mLongitude);
        stringbuilder.append(",phone=");
        stringbuilder.append(mPhone);
        stringbuilder.append(",url=");
        stringbuilder.append(mUrl);
        stringbuilder.append(",extras=");
        stringbuilder.append(mExtras);
        stringbuilder.append(']');
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int j = 1;
        parcel.writeString(mLocale.getLanguage());
        parcel.writeString(mLocale.getCountry());
        int k;
        if(mAddressLines == null) {
            parcel.writeInt(0);
        } else {
            Set set = mAddressLines.entrySet();
            parcel.writeInt(set.size());
            Iterator iterator = set.iterator();
            while(iterator.hasNext())  {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                parcel.writeInt(((Integer)entry.getKey()).intValue());
                parcel.writeString((String)entry.getValue());
            }
        }
        parcel.writeString(mFeatureName);
        parcel.writeString(mAdminArea);
        parcel.writeString(mSubAdminArea);
        parcel.writeString(mLocality);
        parcel.writeString(mSubLocality);
        parcel.writeString(mThoroughfare);
        parcel.writeString(mSubThoroughfare);
        parcel.writeString(mPremises);
        parcel.writeString(mPostalCode);
        parcel.writeString(mCountryCode);
        parcel.writeString(mCountryName);
        if(mHasLatitude)
            k = j;
        else
            k = 0;
        parcel.writeInt(k);
        if(mHasLatitude)
            parcel.writeDouble(mLatitude);
        if(!mHasLongitude)
            j = 0;
        parcel.writeInt(j);
        if(mHasLongitude)
            parcel.writeDouble(mLongitude);
        parcel.writeString(mPhone);
        parcel.writeString(mUrl);
        parcel.writeBundle(mExtras);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Address createFromParcel(Parcel parcel) {
            boolean flag = false;
            String s = parcel.readString();
            String s1 = parcel.readString();
            Locale locale;
            Address address;
            int i;
            if(s1.length() > 0)
                locale = new Locale(s, s1);
            else
                locale = new Locale(s);
            address = new Address(locale);
            i = parcel.readInt();
            if(i > 0) {
                address.mAddressLines = new HashMap(i);
                for(int j = 0; j < i; j++) {
                    int k = parcel.readInt();
                    String s2 = parcel.readString();
                    address.mAddressLines.put(Integer.valueOf(k), s2);
                    address.mMaxAddressLineIndex = Math.max(address.mMaxAddressLineIndex, k);
                }

            } else {
                address.mAddressLines = null;
                address.mMaxAddressLineIndex = -1;
            }
            address.mFeatureName = parcel.readString();
            address.mAdminArea = parcel.readString();
            address.mSubAdminArea = parcel.readString();
            address.mLocality = parcel.readString();
            address.mSubLocality = parcel.readString();
            address.mThoroughfare = parcel.readString();
            address.mSubThoroughfare = parcel.readString();
            address.mPremises = parcel.readString();
            address.mPostalCode = parcel.readString();
            address.mCountryCode = parcel.readString();
            address.mCountryName = parcel.readString();
            boolean flag1;
            if(parcel.readInt() == 0)
                flag1 = false;
            else
                flag1 = true;
            address.mHasLatitude = flag1;
            if(address.mHasLatitude)
                address.mLatitude = parcel.readDouble();
            if(parcel.readInt() != 0)
                flag = true;
            address.mHasLongitude = flag;
            if(address.mHasLongitude)
                address.mLongitude = parcel.readDouble();
            address.mPhone = parcel.readString();
            address.mUrl = parcel.readString();
            address.mExtras = parcel.readBundle();
            return address;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public Address[] newArray(int i) {
            return new Address[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private HashMap mAddressLines;
    private String mAdminArea;
    private String mCountryCode;
    private String mCountryName;
    private Bundle mExtras;
    private String mFeatureName;
    private boolean mHasLatitude;
    private boolean mHasLongitude;
    private double mLatitude;
    private Locale mLocale;
    private String mLocality;
    private double mLongitude;
    private int mMaxAddressLineIndex;
    private String mPhone;
    private String mPostalCode;
    private String mPremises;
    private String mSubAdminArea;
    private String mSubLocality;
    private String mSubThoroughfare;
    private String mThoroughfare;
    private String mUrl;




/*
    static HashMap access$002(Address address, HashMap hashmap) {
        address.mAddressLines = hashmap;
        return hashmap;
    }

*/



/*
    static String access$1002(Address address, String s) {
        address.mPostalCode = s;
        return s;
    }

*/


/*
    static int access$102(Address address, int i) {
        address.mMaxAddressLineIndex = i;
        return i;
    }

*/


/*
    static String access$1102(Address address, String s) {
        address.mCountryCode = s;
        return s;
    }

*/


/*
    static String access$1202(Address address, String s) {
        address.mCountryName = s;
        return s;
    }

*/



/*
    static boolean access$1302(Address address, boolean flag) {
        address.mHasLatitude = flag;
        return flag;
    }

*/


/*
    static double access$1402(Address address, double d) {
        address.mLatitude = d;
        return d;
    }

*/



/*
    static boolean access$1502(Address address, boolean flag) {
        address.mHasLongitude = flag;
        return flag;
    }

*/


/*
    static double access$1602(Address address, double d) {
        address.mLongitude = d;
        return d;
    }

*/


/*
    static String access$1702(Address address, String s) {
        address.mPhone = s;
        return s;
    }

*/


/*
    static String access$1802(Address address, String s) {
        address.mUrl = s;
        return s;
    }

*/


/*
    static Bundle access$1902(Address address, Bundle bundle) {
        address.mExtras = bundle;
        return bundle;
    }

*/


/*
    static String access$202(Address address, String s) {
        address.mFeatureName = s;
        return s;
    }

*/


/*
    static String access$302(Address address, String s) {
        address.mAdminArea = s;
        return s;
    }

*/


/*
    static String access$402(Address address, String s) {
        address.mSubAdminArea = s;
        return s;
    }

*/


/*
    static String access$502(Address address, String s) {
        address.mLocality = s;
        return s;
    }

*/


/*
    static String access$602(Address address, String s) {
        address.mSubLocality = s;
        return s;
    }

*/


/*
    static String access$702(Address address, String s) {
        address.mThoroughfare = s;
        return s;
    }

*/


/*
    static String access$802(Address address, String s) {
        address.mSubThoroughfare = s;
        return s;
    }

*/


/*
    static String access$902(Address address, String s) {
        address.mPremises = s;
        return s;
    }

*/
}
