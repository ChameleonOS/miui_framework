// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi;

import android.os.Parcel;
import android.os.Parcelable;

public class ScanResult
    implements Parcelable {

    public ScanResult(String s, String s1, String s2, int i, int j) {
        SSID = s;
        BSSID = s1;
        capabilities = s2;
        level = i;
        frequency = j;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuffer stringbuffer = new StringBuffer();
        String s = "<none>";
        StringBuffer stringbuffer1 = stringbuffer.append("SSID: ");
        String s1;
        StringBuffer stringbuffer2;
        String s2;
        StringBuffer stringbuffer3;
        if(SSID == null)
            s1 = s;
        else
            s1 = SSID;
        stringbuffer2 = stringbuffer1.append(s1).append(", BSSID: ");
        if(BSSID == null)
            s2 = s;
        else
            s2 = BSSID;
        stringbuffer3 = stringbuffer2.append(s2).append(", capabilities: ");
        if(capabilities != null)
            s = capabilities;
        stringbuffer3.append(s).append(", level: ").append(level).append(", frequency: ").append(frequency);
        return stringbuffer.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(SSID);
        parcel.writeString(BSSID);
        parcel.writeString(capabilities);
        parcel.writeInt(level);
        parcel.writeInt(frequency);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ScanResult createFromParcel(Parcel parcel) {
            return new ScanResult(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public ScanResult[] newArray(int i) {
            return new ScanResult[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public String BSSID;
    public String SSID;
    public String capabilities;
    public int frequency;
    public int level;

}
