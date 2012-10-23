// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.text.TextUtils;
import android.util.Log;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.*;

// Referenced classes of package android.net:
//            NetworkUtils, DhcpInfo, RouteInfo, LinkAddress, 
//            LinkProperties

public class DhcpInfoInternal {

    public DhcpInfoInternal() {
        mRoutes = new ArrayList();
    }

    private int convertToInt(String s) {
        if(s == null) goto _L2; else goto _L1
_L1:
        InetAddress inetaddress = NetworkUtils.numericToInetAddress(s);
        if(!(inetaddress instanceof Inet4Address)) goto _L2; else goto _L3
_L3:
        int j = NetworkUtils.inetAddressToInt(inetaddress);
        int i = j;
_L5:
        return i;
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
_L2:
        i = 0;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public void addRoute(RouteInfo routeinfo) {
        mRoutes.add(routeinfo);
    }

    public Collection getRoutes() {
        return Collections.unmodifiableCollection(mRoutes);
    }

    public boolean hasMeteredHint() {
        boolean flag;
        if(vendorInfo != null)
            flag = vendorInfo.contains("ANDROID_METERED");
        else
            flag = false;
        return flag;
    }

    public DhcpInfo makeDhcpInfo() {
        DhcpInfo dhcpinfo = new DhcpInfo();
        dhcpinfo.ipAddress = convertToInt(ipAddress);
        Iterator iterator = mRoutes.iterator();
        do {
            if(!iterator.hasNext())
                break;
            RouteInfo routeinfo = (RouteInfo)iterator.next();
            if(!routeinfo.isDefaultRoute())
                continue;
            dhcpinfo.gateway = convertToInt(routeinfo.getGateway().getHostAddress());
            break;
        } while(true);
        try {
            NetworkUtils.numericToInetAddress(ipAddress);
            dhcpinfo.netmask = NetworkUtils.prefixLengthToNetmaskInt(prefixLength);
        }
        catch(IllegalArgumentException illegalargumentexception) { }
        dhcpinfo.dns1 = convertToInt(dns1);
        dhcpinfo.dns2 = convertToInt(dns2);
        dhcpinfo.serverAddress = convertToInt(serverAddress);
        dhcpinfo.leaseDuration = leaseDuration;
        return dhcpinfo;
    }

    public LinkAddress makeLinkAddress() {
        LinkAddress linkaddress;
        if(TextUtils.isEmpty(ipAddress)) {
            Log.e("DhcpInfoInternal", "makeLinkAddress with empty ipAddress");
            linkaddress = null;
        } else {
            linkaddress = new LinkAddress(NetworkUtils.numericToInetAddress(ipAddress), prefixLength);
        }
        return linkaddress;
    }

    public LinkProperties makeLinkProperties() {
        LinkProperties linkproperties = new LinkProperties();
        linkproperties.addLinkAddress(makeLinkAddress());
        for(Iterator iterator = mRoutes.iterator(); iterator.hasNext(); linkproperties.addRoute((RouteInfo)iterator.next()));
        if(!TextUtils.isEmpty(dns1))
            linkproperties.addDns(NetworkUtils.numericToInetAddress(dns1));
        else
            Log.d("DhcpInfoInternal", "makeLinkProperties with empty dns1!");
        if(!TextUtils.isEmpty(dns2))
            linkproperties.addDns(NetworkUtils.numericToInetAddress(dns2));
        else
            Log.d("DhcpInfoInternal", "makeLinkProperties with empty dns2!");
        return linkproperties;
    }

    public String toString() {
        String s = "";
        for(Iterator iterator = mRoutes.iterator(); iterator.hasNext();) {
            RouteInfo routeinfo = (RouteInfo)iterator.next();
            s = (new StringBuilder()).append(s).append(routeinfo.toString()).append(" | ").toString();
        }

        return (new StringBuilder()).append("addr: ").append(ipAddress).append("/").append(prefixLength).append(" mRoutes: ").append(s).append(" dns: ").append(dns1).append(",").append(dns2).append(" dhcpServer: ").append(serverAddress).append(" leaseDuration: ").append(leaseDuration).toString();
    }

    public void updateFromDhcpRequest(DhcpInfoInternal dhcpinfointernal) {
        if(dhcpinfointernal != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(TextUtils.isEmpty(dns1))
            dns1 = dhcpinfointernal.dns1;
        if(TextUtils.isEmpty(dns2))
            dns2 = dhcpinfointernal.dns2;
        if(mRoutes.size() == 0) {
            Iterator iterator = dhcpinfointernal.getRoutes().iterator();
            while(iterator.hasNext()) 
                addRoute((RouteInfo)iterator.next());
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private static final String TAG = "DhcpInfoInternal";
    public String dns1;
    public String dns2;
    public String ipAddress;
    public int leaseDuration;
    private Collection mRoutes;
    public int prefixLength;
    public String serverAddress;
    public String vendorInfo;
}
