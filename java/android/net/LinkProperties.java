// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

// Referenced classes of package android.net:
//            LinkAddress, RouteInfo, ProxyProperties

public class LinkProperties
    implements Parcelable {
    public static class CompareResult {

        public String toString() {
            String s = "removed=[";
            for(Iterator iterator = removed.iterator(); iterator.hasNext();) {
                Object obj1 = iterator.next();
                s = (new StringBuilder()).append(s).append(obj1.toString()).append(",").toString();
            }

            String s1 = (new StringBuilder()).append(s).append("] added=[").toString();
            for(Iterator iterator1 = added.iterator(); iterator1.hasNext();) {
                Object obj = iterator1.next();
                s1 = (new StringBuilder()).append(s1).append(obj.toString()).append(",").toString();
            }

            return (new StringBuilder()).append(s1).append("]").toString();
        }

        public Collection added;
        public Collection removed;

        public CompareResult() {
            removed = new ArrayList();
            added = new ArrayList();
        }
    }


    public LinkProperties() {
        mLinkAddresses = new ArrayList();
        mDnses = new ArrayList();
        mRoutes = new ArrayList();
        clear();
    }

    public LinkProperties(LinkProperties linkproperties) {
        mLinkAddresses = new ArrayList();
        mDnses = new ArrayList();
        mRoutes = new ArrayList();
        if(linkproperties != null) {
            mIfaceName = linkproperties.getInterfaceName();
            LinkAddress linkaddress;
            for(Iterator iterator = linkproperties.getLinkAddresses().iterator(); iterator.hasNext(); mLinkAddresses.add(linkaddress))
                linkaddress = (LinkAddress)iterator.next();

            InetAddress inetaddress;
            for(Iterator iterator1 = linkproperties.getDnses().iterator(); iterator1.hasNext(); mDnses.add(inetaddress))
                inetaddress = (InetAddress)iterator1.next();

            RouteInfo routeinfo;
            for(Iterator iterator2 = linkproperties.getRoutes().iterator(); iterator2.hasNext(); mRoutes.add(routeinfo))
                routeinfo = (RouteInfo)iterator2.next();

            ProxyProperties proxyproperties;
            if(linkproperties.getHttpProxy() == null)
                proxyproperties = null;
            else
                proxyproperties = new ProxyProperties(linkproperties.getHttpProxy());
            mHttpProxy = proxyproperties;
        }
    }

    public void addDns(InetAddress inetaddress) {
        if(inetaddress != null)
            mDnses.add(inetaddress);
    }

    public void addLinkAddress(LinkAddress linkaddress) {
        if(linkaddress != null)
            mLinkAddresses.add(linkaddress);
    }

    public void addRoute(RouteInfo routeinfo) {
        if(routeinfo != null)
            mRoutes.add(routeinfo);
    }

    public void clear() {
        mIfaceName = null;
        mLinkAddresses.clear();
        mDnses.clear();
        mRoutes.clear();
        mHttpProxy = null;
    }

    public CompareResult compareAddresses(LinkProperties linkproperties) {
        CompareResult compareresult = new CompareResult();
        compareresult.removed = new ArrayList(mLinkAddresses);
        compareresult.added.clear();
        if(linkproperties != null) {
            Iterator iterator = linkproperties.getLinkAddresses().iterator();
            do {
                if(!iterator.hasNext())
                    break;
                LinkAddress linkaddress = (LinkAddress)iterator.next();
                if(!compareresult.removed.remove(linkaddress))
                    compareresult.added.add(linkaddress);
            } while(true);
        }
        return compareresult;
    }

    public CompareResult compareDnses(LinkProperties linkproperties) {
        CompareResult compareresult = new CompareResult();
        compareresult.removed = new ArrayList(mDnses);
        compareresult.added.clear();
        if(linkproperties != null) {
            Iterator iterator = linkproperties.getDnses().iterator();
            do {
                if(!iterator.hasNext())
                    break;
                InetAddress inetaddress = (InetAddress)iterator.next();
                if(!compareresult.removed.remove(inetaddress))
                    compareresult.added.add(inetaddress);
            } while(true);
        }
        return compareresult;
    }

    public CompareResult compareRoutes(LinkProperties linkproperties) {
        CompareResult compareresult = new CompareResult();
        compareresult.removed = new ArrayList(mRoutes);
        compareresult.added.clear();
        if(linkproperties != null) {
            Iterator iterator = linkproperties.getRoutes().iterator();
            do {
                if(!iterator.hasNext())
                    break;
                RouteInfo routeinfo = (RouteInfo)iterator.next();
                if(!compareresult.removed.remove(routeinfo))
                    compareresult.added.add(routeinfo);
            } while(true);
        }
        return compareresult;
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
        if(!(obj instanceof LinkProperties)) {
            flag = false;
        } else {
            LinkProperties linkproperties = (LinkProperties)obj;
            if(!isIdenticalInterfaceName(linkproperties) || !isIdenticalAddresses(linkproperties) || !isIdenticalDnses(linkproperties) || !isIdenticalRoutes(linkproperties) || !isIdenticalHttpProxy(linkproperties))
                flag = false;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public Collection getAddresses() {
        ArrayList arraylist = new ArrayList();
        for(Iterator iterator = mLinkAddresses.iterator(); iterator.hasNext(); arraylist.add(((LinkAddress)iterator.next()).getAddress()));
        return Collections.unmodifiableCollection(arraylist);
    }

    public Collection getDnses() {
        return Collections.unmodifiableCollection(mDnses);
    }

    public ProxyProperties getHttpProxy() {
        return mHttpProxy;
    }

    public String getInterfaceName() {
        return mIfaceName;
    }

    public Collection getLinkAddresses() {
        return Collections.unmodifiableCollection(mLinkAddresses);
    }

    public Collection getRoutes() {
        return Collections.unmodifiableCollection(mRoutes);
    }

    public int hashCode() {
        int i = 0;
        if(mIfaceName != null) {
            int j = mIfaceName.hashCode() + 31 * mLinkAddresses.size() + 37 * mDnses.size() + 41 * mRoutes.size();
            if(mHttpProxy != null)
                i = mHttpProxy.hashCode();
            i += j;
        }
        return i;
    }

    public boolean isIdenticalAddresses(LinkProperties linkproperties) {
        Collection collection = linkproperties.getAddresses();
        Collection collection1 = getAddresses();
        boolean flag;
        if(collection1.size() == collection.size())
            flag = collection1.containsAll(collection);
        else
            flag = false;
        return flag;
    }

    public boolean isIdenticalDnses(LinkProperties linkproperties) {
        Collection collection = linkproperties.getDnses();
        boolean flag;
        if(mDnses.size() == collection.size())
            flag = mDnses.containsAll(collection);
        else
            flag = false;
        return flag;
    }

    public boolean isIdenticalHttpProxy(LinkProperties linkproperties) {
        boolean flag;
        if(getHttpProxy() == null) {
            if(linkproperties.getHttpProxy() == null)
                flag = true;
            else
                flag = false;
        } else {
            flag = getHttpProxy().equals(linkproperties.getHttpProxy());
        }
        return flag;
    }

    public boolean isIdenticalInterfaceName(LinkProperties linkproperties) {
        return TextUtils.equals(getInterfaceName(), linkproperties.getInterfaceName());
    }

    public boolean isIdenticalRoutes(LinkProperties linkproperties) {
        Collection collection = linkproperties.getRoutes();
        boolean flag;
        if(mRoutes.size() == collection.size())
            flag = mRoutes.containsAll(collection);
        else
            flag = false;
        return flag;
    }

    public void setHttpProxy(ProxyProperties proxyproperties) {
        mHttpProxy = proxyproperties;
    }

    public void setInterfaceName(String s) {
        mIfaceName = s;
    }

    public String toString() {
        String s;
        String s1;
        if(mIfaceName == null)
            s = "";
        else
            s = (new StringBuilder()).append("InterfaceName: ").append(mIfaceName).append(" ").toString();
        s1 = "LinkAddresses: [";
        for(Iterator iterator = mLinkAddresses.iterator(); iterator.hasNext();) {
            LinkAddress linkaddress = (LinkAddress)iterator.next();
            s1 = (new StringBuilder()).append(s1).append(linkaddress.toString()).append(",").toString();
        }

        String s2 = (new StringBuilder()).append(s1).append("] ").toString();
        String s3 = "DnsAddresses: [";
        for(Iterator iterator1 = mDnses.iterator(); iterator1.hasNext();) {
            InetAddress inetaddress = (InetAddress)iterator1.next();
            s3 = (new StringBuilder()).append(s3).append(inetaddress.getHostAddress()).append(",").toString();
        }

        String s4 = (new StringBuilder()).append(s3).append("] ").toString();
        String s5 = "Routes: [";
        for(Iterator iterator2 = mRoutes.iterator(); iterator2.hasNext();) {
            RouteInfo routeinfo = (RouteInfo)iterator2.next();
            s5 = (new StringBuilder()).append(s5).append(routeinfo.toString()).append(",").toString();
        }

        String s6 = (new StringBuilder()).append(s5).append("] ").toString();
        String s7;
        if(mHttpProxy == null)
            s7 = "";
        else
            s7 = (new StringBuilder()).append("HttpProxy: ").append(mHttpProxy.toString()).append(" ").toString();
        return (new StringBuilder()).append(s).append(s2).append(s6).append(s4).append(s7).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getInterfaceName());
        parcel.writeInt(mLinkAddresses.size());
        for(Iterator iterator = mLinkAddresses.iterator(); iterator.hasNext(); parcel.writeParcelable((LinkAddress)iterator.next(), i));
        parcel.writeInt(mDnses.size());
        for(Iterator iterator1 = mDnses.iterator(); iterator1.hasNext(); parcel.writeByteArray(((InetAddress)iterator1.next()).getAddress()));
        parcel.writeInt(mRoutes.size());
        for(Iterator iterator2 = mRoutes.iterator(); iterator2.hasNext(); parcel.writeParcelable((RouteInfo)iterator2.next(), i));
        if(mHttpProxy != null) {
            parcel.writeByte((byte)1);
            parcel.writeParcelable(mHttpProxy, i);
        } else {
            parcel.writeByte((byte)0);
        }
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public LinkProperties createFromParcel(Parcel parcel) {
            LinkProperties linkproperties;
            linkproperties = new LinkProperties();
            String s = parcel.readString();
            if(s == null)
                break MISSING_BLOCK_LABEL_22;
            int i;
            int j;
            try {
                linkproperties.setInterfaceName(s);
                break MISSING_BLOCK_LABEL_22;
            }
            catch(Exception exception) {
                linkproperties = null;
            }
_L2:
            return linkproperties;
            i = parcel.readInt();
            for(j = 0; j < i; j++)
                linkproperties.addLinkAddress((LinkAddress)parcel.readParcelable(null));

            int k = parcel.readInt();
            int l = 0;
            while(l < k)  {
                int i1;
                int j1;
                try {
                    linkproperties.addDns(InetAddress.getByAddress(parcel.createByteArray()));
                }
                catch(UnknownHostException unknownhostexception) { }
                l++;
            }
            i1 = parcel.readInt();
            for(j1 = 0; j1 < i1; j1++)
                linkproperties.addRoute((RouteInfo)parcel.readParcelable(null));

            if(parcel.readByte() == 1)
                linkproperties.setHttpProxy((ProxyProperties)parcel.readParcelable(null));
            if(true) goto _L2; else goto _L1
_L1:
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public LinkProperties[] newArray(int i) {
            return new LinkProperties[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private Collection mDnses;
    private ProxyProperties mHttpProxy;
    String mIfaceName;
    private Collection mLinkAddresses;
    private Collection mRoutes;

}
