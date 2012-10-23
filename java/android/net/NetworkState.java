// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package android.net:
//            NetworkInfo, LinkProperties, LinkCapabilities

public class NetworkState
    implements Parcelable {

    public NetworkState(NetworkInfo networkinfo, LinkProperties linkproperties, LinkCapabilities linkcapabilities) {
        this(networkinfo, linkproperties, linkcapabilities, null, null);
    }

    public NetworkState(NetworkInfo networkinfo, LinkProperties linkproperties, LinkCapabilities linkcapabilities, String s, String s1) {
        networkInfo = networkinfo;
        linkProperties = linkproperties;
        linkCapabilities = linkcapabilities;
        subscriberId = s;
        networkId = s1;
    }

    public NetworkState(Parcel parcel) {
        networkInfo = (NetworkInfo)parcel.readParcelable(null);
        linkProperties = (LinkProperties)parcel.readParcelable(null);
        linkCapabilities = (LinkCapabilities)parcel.readParcelable(null);
        subscriberId = parcel.readString();
        networkId = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(networkInfo, i);
        parcel.writeParcelable(linkProperties, i);
        parcel.writeParcelable(linkCapabilities, i);
        parcel.writeString(subscriberId);
        parcel.writeString(networkId);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public NetworkState createFromParcel(Parcel parcel) {
            return new NetworkState(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public NetworkState[] newArray(int i) {
            return new NetworkState[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public final LinkCapabilities linkCapabilities;
    public final LinkProperties linkProperties;
    public final String networkId;
    public final NetworkInfo networkInfo;
    public final String subscriberId;

}
