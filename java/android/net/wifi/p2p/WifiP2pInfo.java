// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi.p2p;

import android.os.Parcel;
import android.os.Parcelable;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class WifiP2pInfo
    implements Parcelable {

    public WifiP2pInfo() {
    }

    public WifiP2pInfo(WifiP2pInfo wifip2pinfo) {
        if(wifip2pinfo != null) {
            groupFormed = wifip2pinfo.groupFormed;
            isGroupOwner = wifip2pinfo.isGroupOwner;
            groupOwnerAddress = wifip2pinfo.groupOwnerAddress;
        }
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("groupFormed: ").append(groupFormed).append("isGroupOwner: ").append(isGroupOwner).append("groupOwnerAddress: ").append(groupOwnerAddress);
        return stringbuffer.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte byte0;
        byte byte1;
        if(groupFormed)
            byte0 = 1;
        else
            byte0 = 0;
        parcel.writeByte(byte0);
        if(isGroupOwner)
            byte1 = 1;
        else
            byte1 = 0;
        parcel.writeByte(byte1);
        if(groupOwnerAddress != null) {
            parcel.writeByte((byte)1);
            parcel.writeByteArray(groupOwnerAddress.getAddress());
        } else {
            parcel.writeByte((byte)0);
        }
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public WifiP2pInfo createFromParcel(Parcel parcel) {
            boolean flag = false;
            WifiP2pInfo wifip2pinfo = new WifiP2pInfo();
            boolean flag1;
            if(parcel.readByte() == 1)
                flag1 = true;
            else
                flag1 = false;
            wifip2pinfo.groupFormed = flag1;
            if(parcel.readByte() == 1)
                flag = true;
            wifip2pinfo.isGroupOwner = flag;
            if(parcel.readByte() == 1)
                try {
                    wifip2pinfo.groupOwnerAddress = InetAddress.getByAddress(parcel.createByteArray());
                }
                catch(UnknownHostException unknownhostexception) { }
            return wifip2pinfo;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public WifiP2pInfo[] newArray(int i) {
            return new WifiP2pInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public boolean groupFormed;
    public InetAddress groupOwnerAddress;
    public boolean isGroupOwner;

}
