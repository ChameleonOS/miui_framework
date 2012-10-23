// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.hardware.usb;

import android.os.Parcel;
import android.os.Parcelable;

public class UsbAccessory
    implements Parcelable {

    public UsbAccessory(String s, String s1, String s2, String s3, String s4, String s5) {
        mManufacturer = s;
        mModel = s1;
        mDescription = s2;
        mVersion = s3;
        mUri = s4;
        mSerial = s5;
    }

    public UsbAccessory(String as[]) {
        mManufacturer = as[0];
        mModel = as[1];
        mDescription = as[2];
        mVersion = as[3];
        mUri = as[4];
        mSerial = as[5];
    }

    private static boolean compare(String s, String s1) {
        boolean flag;
        if(s == null) {
            if(s1 == null)
                flag = true;
            else
                flag = false;
        } else {
            flag = s.equals(s1);
        }
        return flag;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag = false;
        if(obj instanceof UsbAccessory) {
            UsbAccessory usbaccessory = (UsbAccessory)obj;
            if(compare(mManufacturer, usbaccessory.getManufacturer()) && compare(mModel, usbaccessory.getModel()) && compare(mDescription, usbaccessory.getDescription()) && compare(mVersion, usbaccessory.getVersion()) && compare(mUri, usbaccessory.getUri()) && compare(mSerial, usbaccessory.getSerial()))
                flag = true;
        }
        return flag;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getManufacturer() {
        return mManufacturer;
    }

    public String getModel() {
        return mModel;
    }

    public String getSerial() {
        return mSerial;
    }

    public String getUri() {
        return mUri;
    }

    public String getVersion() {
        return mVersion;
    }

    public int hashCode() {
        int i = 0;
        int j;
        int k;
        boolean flag;
        int l;
        boolean flag1;
        int i1;
        boolean flag2;
        int j1;
        boolean flag3;
        if(mManufacturer == null)
            j = 0;
        else
            j = mManufacturer.hashCode();
        if(mModel == null)
            k = 0;
        else
            k = mModel.hashCode();
        flag = k ^ j;
        if(mDescription == null)
            l = 0;
        else
            l = mDescription.hashCode();
        flag1 = flag ^ l;
        if(mVersion == null)
            i1 = 0;
        else
            i1 = mVersion.hashCode();
        flag2 = flag1 ^ i1;
        if(mUri == null)
            j1 = 0;
        else
            j1 = mUri.hashCode();
        flag3 = j1 ^ flag2;
        if(mSerial != null)
            i = mSerial.hashCode();
        return flag3 ^ i;
    }

    public String toString() {
        return (new StringBuilder()).append("UsbAccessory[mManufacturer=").append(mManufacturer).append(", mModel=").append(mModel).append(", mDescription=").append(mDescription).append(", mVersion=").append(mVersion).append(", mUri=").append(mUri).append(", mSerial=").append(mSerial).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mManufacturer);
        parcel.writeString(mModel);
        parcel.writeString(mDescription);
        parcel.writeString(mVersion);
        parcel.writeString(mUri);
        parcel.writeString(mSerial);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public UsbAccessory createFromParcel(Parcel parcel) {
            return new UsbAccessory(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public UsbAccessory[] newArray(int i) {
            return new UsbAccessory[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int DESCRIPTION_STRING = 2;
    public static final int MANUFACTURER_STRING = 0;
    public static final int MODEL_STRING = 1;
    public static final int SERIAL_STRING = 5;
    private static final String TAG = "UsbAccessory";
    public static final int URI_STRING = 4;
    public static final int VERSION_STRING = 3;
    private final String mDescription;
    private final String mManufacturer;
    private final String mModel;
    private final String mSerial;
    private final String mUri;
    private final String mVersion;

}
