// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi;

import android.os.Parcel;
import android.os.Parcelable;

public class WpsInfo
    implements Parcelable {

    public WpsInfo() {
        setup = 4;
        BSSID = null;
        pin = null;
    }

    public WpsInfo(WpsInfo wpsinfo) {
        if(wpsinfo != null) {
            setup = wpsinfo.setup;
            BSSID = wpsinfo.BSSID;
            pin = wpsinfo.pin;
        }
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append(" setup: ").append(setup);
        stringbuffer.append('\n');
        stringbuffer.append(" BSSID: ").append(BSSID);
        stringbuffer.append('\n');
        stringbuffer.append(" pin: ").append(pin);
        stringbuffer.append('\n');
        return stringbuffer.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(setup);
        parcel.writeString(BSSID);
        parcel.writeString(pin);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public WpsInfo createFromParcel(Parcel parcel) {
            WpsInfo wpsinfo = new WpsInfo();
            wpsinfo.setup = parcel.readInt();
            wpsinfo.BSSID = parcel.readString();
            wpsinfo.pin = parcel.readString();
            return wpsinfo;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public WpsInfo[] newArray(int i) {
            return new WpsInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int DISPLAY = 1;
    public static final int INVALID = 4;
    public static final int KEYPAD = 2;
    public static final int LABEL = 3;
    public static final int PBC;
    public String BSSID;
    public String pin;
    public int setup;

}
