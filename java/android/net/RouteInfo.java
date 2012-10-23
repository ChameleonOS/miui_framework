// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.os.Parcel;
import android.os.Parcelable;
import java.net.*;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package android.net:
//            LinkAddress, NetworkUtils

public class RouteInfo
    implements Parcelable {

    public RouteInfo(LinkAddress linkaddress, InetAddress inetaddress) {
label0:
        {
            super();
            if(linkaddress == null) {
                if(inetaddress == null)
                    break label0;
                if(inetaddress instanceof Inet4Address)
                    linkaddress = new LinkAddress(Inet4Address.ANY, 0);
                else
                    linkaddress = new LinkAddress(Inet6Address.ANY, 0);
            }
            if(inetaddress == null)
                if(linkaddress.getAddress() instanceof Inet4Address)
                    inetaddress = Inet4Address.ANY;
                else
                    inetaddress = Inet6Address.ANY;
            mDestination = new LinkAddress(NetworkUtils.getNetworkPart(linkaddress.getAddress(), linkaddress.getNetworkPrefixLength()), linkaddress.getNetworkPrefixLength());
            mGateway = inetaddress;
            mIsDefault = isDefault();
            mIsHost = isHost();
            return;
        }
        throw new RuntimeException("Invalid arguments passed in.");
    }

    public RouteInfo(InetAddress inetaddress) {
        this(null, inetaddress);
    }

    private boolean isDefault() {
        boolean flag = false;
        if(mGateway != null)
            if(mGateway instanceof Inet4Address) {
                if(mDestination == null || mDestination.getNetworkPrefixLength() == 0)
                    flag = true;
                else
                    flag = false;
            } else
            if(mDestination == null || mDestination.getNetworkPrefixLength() == 0)
                flag = true;
            else
                flag = false;
        return flag;
    }

    private boolean isHost() {
        boolean flag;
        if(mGateway.equals(Inet4Address.ANY) || mGateway.equals(Inet6Address.ANY))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static RouteInfo makeHostRoute(InetAddress inetaddress) {
        return makeHostRoute(inetaddress, null);
    }

    public static RouteInfo makeHostRoute(InetAddress inetaddress, InetAddress inetaddress1) {
        RouteInfo routeinfo;
        if(inetaddress == null)
            routeinfo = null;
        else
        if(inetaddress instanceof Inet4Address)
            routeinfo = new RouteInfo(new LinkAddress(inetaddress, 32), inetaddress1);
        else
            routeinfo = new RouteInfo(new LinkAddress(inetaddress, 128), inetaddress1);
        return routeinfo;
    }

    private boolean matches(InetAddress inetaddress) {
        boolean flag;
        if(inetaddress == null)
            flag = false;
        else
        if(isDefault()) {
            flag = true;
        } else {
            InetAddress inetaddress1 = NetworkUtils.getNetworkPart(inetaddress, mDestination.getNetworkPrefixLength());
            flag = mDestination.getAddress().equals(inetaddress1);
        }
        return flag;
    }

    public static RouteInfo selectBestRoute(Collection collection, InetAddress inetaddress) {
        RouteInfo routeinfo;
        if(collection == null || inetaddress == null) {
            routeinfo = null;
        } else {
            routeinfo = null;
            Iterator iterator = collection.iterator();
            while(iterator.hasNext())  {
                RouteInfo routeinfo1 = (RouteInfo)iterator.next();
                if(NetworkUtils.addressTypeMatches(routeinfo1.mDestination.getAddress(), inetaddress) && (routeinfo == null || routeinfo.mDestination.getNetworkPrefixLength() < routeinfo1.mDestination.getNetworkPrefixLength()) && routeinfo1.matches(inetaddress))
                    routeinfo = routeinfo1;
            }
        }
        return routeinfo;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag = true;
        if(this != obj) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(!(obj instanceof RouteInfo)) {
            flag = false;
        } else {
            RouteInfo routeinfo = (RouteInfo)obj;
            boolean flag1;
            boolean flag2;
            if(mDestination == null) {
                if(routeinfo.getDestination() == null)
                    flag1 = flag;
                else
                    flag1 = false;
            } else {
                flag1 = mDestination.equals(routeinfo.getDestination());
            }
            if(mGateway == null) {
                if(routeinfo.getGateway() == null)
                    flag2 = flag;
                else
                    flag2 = false;
            } else {
                flag2 = mGateway.equals(routeinfo.getGateway());
            }
            if(!flag1 || !flag2 || mIsDefault != routeinfo.mIsDefault)
                flag = false;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public LinkAddress getDestination() {
        return mDestination;
    }

    public InetAddress getGateway() {
        return mGateway;
    }

    public int hashCode() {
        int i = 0;
        int j;
        int k;
        byte byte0;
        if(mDestination == null)
            j = 0;
        else
            j = mDestination.hashCode();
        if(mGateway != null)
            i = mGateway.hashCode();
        k = i + j;
        if(mIsDefault)
            byte0 = 3;
        else
            byte0 = 7;
        return byte0 + k;
    }

    public boolean isDefaultRoute() {
        return mIsDefault;
    }

    public boolean isHostRoute() {
        return mIsHost;
    }

    public String toString() {
        String s = "";
        if(mDestination != null)
            s = mDestination.toString();
        if(mGateway != null)
            s = (new StringBuilder()).append(s).append(" -> ").append(mGateway.getHostAddress()).toString();
        return s;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if(mDestination == null) {
            parcel.writeByte((byte)0);
        } else {
            parcel.writeByte((byte)1);
            parcel.writeByteArray(mDestination.getAddress().getAddress());
            parcel.writeInt(mDestination.getNetworkPrefixLength());
        }
        if(mGateway == null) {
            parcel.writeByte((byte)0);
        } else {
            parcel.writeByte((byte)1);
            parcel.writeByteArray(mGateway.getAddress());
        }
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public RouteInfo createFromParcel(Parcel parcel) {
            InetAddress inetaddress;
            int i;
            InetAddress inetaddress1;
            byte abyte1[];
            inetaddress = null;
            i = 0;
            inetaddress1 = null;
            if(parcel.readByte() != 1)
                break MISSING_BLOCK_LABEL_36;
            abyte1 = parcel.createByteArray();
            i = parcel.readInt();
            InetAddress inetaddress3 = InetAddress.getByAddress(abyte1);
            inetaddress = inetaddress3;
_L1:
            byte abyte0[];
            if(parcel.readByte() != 1)
                break MISSING_BLOCK_LABEL_61;
            abyte0 = parcel.createByteArray();
            InetAddress inetaddress2 = InetAddress.getByAddress(abyte0);
            inetaddress1 = inetaddress2;
_L2:
            LinkAddress linkaddress = null;
            if(inetaddress != null)
                linkaddress = new LinkAddress(inetaddress, i);
            return new RouteInfo(linkaddress, inetaddress1);
            UnknownHostException unknownhostexception1;
            unknownhostexception1;
              goto _L1
            UnknownHostException unknownhostexception;
            unknownhostexception;
              goto _L2
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public RouteInfo[] newArray(int i) {
            return new RouteInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private final LinkAddress mDestination;
    private final InetAddress mGateway;
    private final boolean mIsDefault;
    private final boolean mIsHost;

}
