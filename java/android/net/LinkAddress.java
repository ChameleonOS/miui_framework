// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.os.Parcel;
import android.os.Parcelable;
import java.net.*;

public class LinkAddress
    implements Parcelable {

    public LinkAddress(InetAddress inetaddress, int i) {
        if(inetaddress == null || i < 0 || (inetaddress instanceof Inet4Address) && i > 32 || i > 128) {
            throw new IllegalArgumentException((new StringBuilder()).append("Bad LinkAddress params ").append(inetaddress).append(i).toString());
        } else {
            address = inetaddress;
            prefixLength = i;
            return;
        }
    }

    public LinkAddress(InterfaceAddress interfaceaddress) {
        address = interfaceaddress.getAddress();
        prefixLength = interfaceaddress.getNetworkPrefixLength();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag = false;
        if(obj instanceof LinkAddress) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        LinkAddress linkaddress = (LinkAddress)obj;
        if(address.equals(linkaddress.address) && prefixLength == linkaddress.prefixLength)
            flag = true;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public InetAddress getAddress() {
        return address;
    }

    public int getNetworkPrefixLength() {
        return prefixLength;
    }

    public int hashCode() {
        int i;
        if(address == null)
            i = 0;
        else
            i = address.hashCode();
        return i + prefixLength;
    }

    public String toString() {
        String s;
        if(address == null)
            s = "";
        else
            s = (new StringBuilder()).append(address.getHostAddress()).append("/").append(prefixLength).toString();
        return s;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if(address != null) {
            parcel.writeByte((byte)1);
            parcel.writeByteArray(address.getAddress());
            parcel.writeInt(prefixLength);
        } else {
            parcel.writeByte((byte)0);
        }
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public LinkAddress createFromParcel(Parcel parcel) {
            InetAddress inetaddress;
            int i;
            inetaddress = null;
            i = 0;
            if(parcel.readByte() != 1)
                break MISSING_BLOCK_LABEL_29;
            int j;
            inetaddress = InetAddress.getByAddress(parcel.createByteArray());
            j = parcel.readInt();
            i = j;
_L2:
            return new LinkAddress(inetaddress, i);
            UnknownHostException unknownhostexception;
            unknownhostexception;
            if(true) goto _L2; else goto _L1
_L1:
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public LinkAddress[] newArray(int i) {
            return new LinkAddress[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private final InetAddress address;
    private final int prefixLength;

}
