// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.os.Parcel;
import android.os.Parcelable;
import java.net.InetAddress;

// Referenced classes of package android.net:
//            NetworkUtils

public class DhcpInfo
    implements Parcelable {

    public DhcpInfo() {
    }

    public DhcpInfo(DhcpInfo dhcpinfo) {
        if(dhcpinfo != null) {
            ipAddress = dhcpinfo.ipAddress;
            gateway = dhcpinfo.gateway;
            netmask = dhcpinfo.netmask;
            dns1 = dhcpinfo.dns1;
            dns2 = dhcpinfo.dns2;
            serverAddress = dhcpinfo.serverAddress;
            leaseDuration = dhcpinfo.leaseDuration;
        }
    }

    private static void putAddress(StringBuffer stringbuffer, int i) {
        stringbuffer.append(NetworkUtils.intToInetAddress(i).getHostAddress());
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("ipaddr ");
        putAddress(stringbuffer, ipAddress);
        stringbuffer.append(" gateway ");
        putAddress(stringbuffer, gateway);
        stringbuffer.append(" netmask ");
        putAddress(stringbuffer, netmask);
        stringbuffer.append(" dns1 ");
        putAddress(stringbuffer, dns1);
        stringbuffer.append(" dns2 ");
        putAddress(stringbuffer, dns2);
        stringbuffer.append(" DHCP server ");
        putAddress(stringbuffer, serverAddress);
        stringbuffer.append(" lease ").append(leaseDuration).append(" seconds");
        return stringbuffer.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ipAddress);
        parcel.writeInt(gateway);
        parcel.writeInt(netmask);
        parcel.writeInt(dns1);
        parcel.writeInt(dns2);
        parcel.writeInt(serverAddress);
        parcel.writeInt(leaseDuration);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public DhcpInfo createFromParcel(Parcel parcel) {
            DhcpInfo dhcpinfo = new DhcpInfo();
            dhcpinfo.ipAddress = parcel.readInt();
            dhcpinfo.gateway = parcel.readInt();
            dhcpinfo.netmask = parcel.readInt();
            dhcpinfo.dns1 = parcel.readInt();
            dhcpinfo.dns2 = parcel.readInt();
            dhcpinfo.serverAddress = parcel.readInt();
            dhcpinfo.leaseDuration = parcel.readInt();
            return dhcpinfo;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public DhcpInfo[] newArray(int i) {
            return new DhcpInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public int dns1;
    public int dns2;
    public int gateway;
    public int ipAddress;
    public int leaseDuration;
    public int netmask;
    public int serverAddress;

}
