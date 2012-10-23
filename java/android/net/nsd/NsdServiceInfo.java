// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.nsd;

import android.os.Parcel;
import android.os.Parcelable;
import java.net.InetAddress;
import java.net.UnknownHostException;

// Referenced classes of package android.net.nsd:
//            DnsSdTxtRecord

public final class NsdServiceInfo
    implements Parcelable {

    public NsdServiceInfo() {
    }

    public NsdServiceInfo(String s, String s1, DnsSdTxtRecord dnssdtxtrecord) {
        mServiceName = s;
        mServiceType = s1;
        mTxtRecord = dnssdtxtrecord;
    }

    public int describeContents() {
        return 0;
    }

    public InetAddress getHost() {
        return mHost;
    }

    public int getPort() {
        return mPort;
    }

    public String getServiceName() {
        return mServiceName;
    }

    public String getServiceType() {
        return mServiceType;
    }

    public DnsSdTxtRecord getTxtRecord() {
        return mTxtRecord;
    }

    public void setHost(InetAddress inetaddress) {
        mHost = inetaddress;
    }

    public void setPort(int i) {
        mPort = i;
    }

    public void setServiceName(String s) {
        mServiceName = s;
    }

    public void setServiceType(String s) {
        mServiceType = s;
    }

    public void setTxtRecord(DnsSdTxtRecord dnssdtxtrecord) {
        mTxtRecord = new DnsSdTxtRecord(dnssdtxtrecord);
    }

    public String toString() {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("name: ").append(mServiceName).append("type: ").append(mServiceType).append("host: ").append(mHost).append("port: ").append(mPort).append("txtRecord: ").append(mTxtRecord);
        return stringbuffer.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mServiceName);
        parcel.writeString(mServiceType);
        parcel.writeParcelable(mTxtRecord, i);
        if(mHost != null) {
            parcel.writeByte((byte)1);
            parcel.writeByteArray(mHost.getAddress());
        } else {
            parcel.writeByte((byte)0);
        }
        parcel.writeInt(mPort);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public NsdServiceInfo createFromParcel(Parcel parcel) {
            NsdServiceInfo nsdserviceinfo = new NsdServiceInfo();
            nsdserviceinfo.mServiceName = parcel.readString();
            nsdserviceinfo.mServiceType = parcel.readString();
            nsdserviceinfo.mTxtRecord = (DnsSdTxtRecord)parcel.readParcelable(null);
            if(parcel.readByte() == 1)
                try {
                    nsdserviceinfo.mHost = InetAddress.getByAddress(parcel.createByteArray());
                }
                catch(UnknownHostException unknownhostexception) { }
            nsdserviceinfo.mPort = parcel.readInt();
            return nsdserviceinfo;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public NsdServiceInfo[] newArray(int i) {
            return new NsdServiceInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private InetAddress mHost;
    private int mPort;
    private String mServiceName;
    private String mServiceType;
    private DnsSdTxtRecord mTxtRecord;



/*
    static String access$002(NsdServiceInfo nsdserviceinfo, String s) {
        nsdserviceinfo.mServiceName = s;
        return s;
    }

*/


/*
    static String access$102(NsdServiceInfo nsdserviceinfo, String s) {
        nsdserviceinfo.mServiceType = s;
        return s;
    }

*/


/*
    static DnsSdTxtRecord access$202(NsdServiceInfo nsdserviceinfo, DnsSdTxtRecord dnssdtxtrecord) {
        nsdserviceinfo.mTxtRecord = dnssdtxtrecord;
        return dnssdtxtrecord;
    }

*/


/*
    static InetAddress access$302(NsdServiceInfo nsdserviceinfo, InetAddress inetaddress) {
        nsdserviceinfo.mHost = inetaddress;
        return inetaddress;
    }

*/


/*
    static int access$402(NsdServiceInfo nsdserviceinfo, int i) {
        nsdserviceinfo.mPort = i;
        return i;
    }

*/
}
