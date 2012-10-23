// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.hardware.usb;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package android.hardware.usb:
//            UsbInterface

public class UsbDevice
    implements Parcelable {

    public UsbDevice(String s, int i, int j, int k, int l, int i1, Parcelable aparcelable[]) {
        mName = s;
        mVendorId = i;
        mProductId = j;
        mClass = k;
        mSubclass = l;
        mProtocol = i1;
        mInterfaces = aparcelable;
    }

    public static int getDeviceId(String s) {
        return native_get_device_id(s);
    }

    public static String getDeviceName(int i) {
        return native_get_device_name(i);
    }

    private static native int native_get_device_id(String s);

    private static native String native_get_device_name(int i);

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag;
        if(obj instanceof UsbDevice)
            flag = ((UsbDevice)obj).mName.equals(mName);
        else
        if(obj instanceof String)
            flag = ((String)obj).equals(mName);
        else
            flag = false;
        return flag;
    }

    public int getDeviceClass() {
        return mClass;
    }

    public int getDeviceId() {
        return getDeviceId(mName);
    }

    public String getDeviceName() {
        return mName;
    }

    public int getDeviceProtocol() {
        return mProtocol;
    }

    public int getDeviceSubclass() {
        return mSubclass;
    }

    public UsbInterface getInterface(int i) {
        return (UsbInterface)mInterfaces[i];
    }

    public int getInterfaceCount() {
        return mInterfaces.length;
    }

    public int getProductId() {
        return mProductId;
    }

    public int getVendorId() {
        return mVendorId;
    }

    public int hashCode() {
        return mName.hashCode();
    }

    public String toString() {
        return (new StringBuilder()).append("UsbDevice[mName=").append(mName).append(",mVendorId=").append(mVendorId).append(",mProductId=").append(mProductId).append(",mClass=").append(mClass).append(",mSubclass=").append(mSubclass).append(",mProtocol=").append(mProtocol).append(",mInterfaces=").append(mInterfaces).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mName);
        parcel.writeInt(mVendorId);
        parcel.writeInt(mProductId);
        parcel.writeInt(mClass);
        parcel.writeInt(mSubclass);
        parcel.writeInt(mProtocol);
        parcel.writeParcelableArray(mInterfaces, 0);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public UsbDevice createFromParcel(Parcel parcel) {
            return new UsbDevice(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readParcelableArray(android/hardware/usb/UsbInterface.getClassLoader()));
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public UsbDevice[] newArray(int i) {
            return new UsbDevice[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private static final String TAG = "UsbDevice";
    private final int mClass;
    private final Parcelable mInterfaces[];
    private final String mName;
    private final int mProductId;
    private final int mProtocol;
    private final int mSubclass;
    private final int mVendorId;

}
