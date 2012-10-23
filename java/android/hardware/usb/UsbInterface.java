// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.hardware.usb;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package android.hardware.usb:
//            UsbEndpoint

public class UsbInterface
    implements Parcelable {

    public UsbInterface(int i, int j, int k, int l, Parcelable aparcelable[]) {
        mId = i;
        mClass = j;
        mSubclass = k;
        mProtocol = l;
        mEndpoints = aparcelable;
    }

    public int describeContents() {
        return 0;
    }

    public UsbEndpoint getEndpoint(int i) {
        return (UsbEndpoint)mEndpoints[i];
    }

    public int getEndpointCount() {
        return mEndpoints.length;
    }

    public int getId() {
        return mId;
    }

    public int getInterfaceClass() {
        return mClass;
    }

    public int getInterfaceProtocol() {
        return mProtocol;
    }

    public int getInterfaceSubclass() {
        return mSubclass;
    }

    public String toString() {
        return (new StringBuilder()).append("UsbInterface[mId=").append(mId).append(",mClass=").append(mClass).append(",mSubclass=").append(mSubclass).append(",mProtocol=").append(mProtocol).append(",mEndpoints=").append(mEndpoints).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mId);
        parcel.writeInt(mClass);
        parcel.writeInt(mSubclass);
        parcel.writeInt(mProtocol);
        parcel.writeParcelableArray(mEndpoints, 0);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public UsbInterface createFromParcel(Parcel parcel) {
            return new UsbInterface(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readParcelableArray(android/hardware/usb/UsbEndpoint.getClassLoader()));
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public UsbInterface[] newArray(int i) {
            return new UsbInterface[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private final int mClass;
    private final Parcelable mEndpoints[];
    private final int mId;
    private final int mProtocol;
    private final int mSubclass;

}
