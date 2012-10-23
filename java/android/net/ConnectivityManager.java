// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import com.android.internal.util.Preconditions;
import java.net.InetAddress;

// Referenced classes of package android.net:
//            IConnectivityManager, NetworkUtils, LinkProperties, NetworkInfo, 
//            NetworkQuotaInfo, ProxyProperties

public class ConnectivityManager {

    public ConnectivityManager(IConnectivityManager iconnectivitymanager) {
        mService = (IConnectivityManager)Preconditions.checkNotNull(iconnectivitymanager, "missing IConnectivityManager");
    }

    public static ConnectivityManager from(Context context) {
        return (ConnectivityManager)context.getSystemService("connectivity");
    }

    public static String getNetworkTypeName(int i) {
        i;
        JVM INSTR tableswitch 0 13: default 72
    //                   0 79
    //                   1 85
    //                   2 91
    //                   3 97
    //                   4 103
    //                   5 109
    //                   6 115
    //                   7 121
    //                   8 127
    //                   9 133
    //                   10 139
    //                   11 145
    //                   12 151
    //                   13 157;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L1:
        String s = Integer.toString(i);
_L17:
        return s;
_L2:
        s = "MOBILE";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "WIFI";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "MOBILE_MMS";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "MOBILE_SUPL";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "MOBILE_DUN";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "MOBILE_HIPRI";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "WIMAX";
        continue; /* Loop/switch isn't completed */
_L9:
        s = "BLUETOOTH";
        continue; /* Loop/switch isn't completed */
_L10:
        s = "DUMMY";
        continue; /* Loop/switch isn't completed */
_L11:
        s = "ETHERNET";
        continue; /* Loop/switch isn't completed */
_L12:
        s = "MOBILE_FOTA";
        continue; /* Loop/switch isn't completed */
_L13:
        s = "MOBILE_IMS";
        continue; /* Loop/switch isn't completed */
_L14:
        s = "MOBILE_CBS";
        continue; /* Loop/switch isn't completed */
_L15:
        s = "WIFI_P2P";
        if(true) goto _L17; else goto _L16
_L16:
    }

    public static boolean isNetworkTypeMobile(int i) {
        i;
        JVM INSTR tableswitch 0 12: default 68
    //                   0 72
    //                   1 68
    //                   2 72
    //                   3 72
    //                   4 72
    //                   5 72
    //                   6 68
    //                   7 68
    //                   8 68
    //                   9 68
    //                   10 72
    //                   11 72
    //                   12 72;
           goto _L1 _L2 _L1 _L2 _L2 _L2 _L2 _L1 _L1 _L1 _L1 _L2 _L2 _L2
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = true;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static boolean isNetworkTypeValid(int i) {
        boolean flag;
        if(i >= 0 && i <= 13)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public LinkProperties getActiveLinkProperties() {
        LinkProperties linkproperties1 = mService.getActiveLinkProperties();
        LinkProperties linkproperties = linkproperties1;
_L2:
        return linkproperties;
        RemoteException remoteexception;
        remoteexception;
        linkproperties = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public NetworkInfo getActiveNetworkInfo() {
        NetworkInfo networkinfo1 = mService.getActiveNetworkInfo();
        NetworkInfo networkinfo = networkinfo1;
_L2:
        return networkinfo;
        RemoteException remoteexception;
        remoteexception;
        networkinfo = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public NetworkInfo getActiveNetworkInfoForUid(int i) {
        NetworkInfo networkinfo1 = mService.getActiveNetworkInfoForUid(i);
        NetworkInfo networkinfo = networkinfo1;
_L2:
        return networkinfo;
        RemoteException remoteexception;
        remoteexception;
        networkinfo = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public NetworkQuotaInfo getActiveNetworkQuotaInfo() {
        NetworkQuotaInfo networkquotainfo1 = mService.getActiveNetworkQuotaInfo();
        NetworkQuotaInfo networkquotainfo = networkquotainfo1;
_L2:
        return networkquotainfo;
        RemoteException remoteexception;
        remoteexception;
        networkquotainfo = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public NetworkInfo[] getAllNetworkInfo() {
        NetworkInfo anetworkinfo1[] = mService.getAllNetworkInfo();
        NetworkInfo anetworkinfo[] = anetworkinfo1;
_L2:
        return anetworkinfo;
        RemoteException remoteexception;
        remoteexception;
        anetworkinfo = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean getBackgroundDataSetting() {
        return true;
    }

    public ProxyProperties getGlobalProxy() {
        ProxyProperties proxyproperties1 = mService.getGlobalProxy();
        ProxyProperties proxyproperties = proxyproperties1;
_L2:
        return proxyproperties;
        RemoteException remoteexception;
        remoteexception;
        proxyproperties = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int getLastTetherError(String s) {
        int j = mService.getLastTetherError(s);
        int i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        i = 2;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public LinkProperties getLinkProperties(int i) {
        LinkProperties linkproperties1 = mService.getLinkProperties(i);
        LinkProperties linkproperties = linkproperties1;
_L2:
        return linkproperties;
        RemoteException remoteexception;
        remoteexception;
        linkproperties = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean getMobileDataEnabled() {
        boolean flag1 = mService.getMobileDataEnabled();
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = true;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public NetworkInfo getNetworkInfo(int i) {
        NetworkInfo networkinfo1 = mService.getNetworkInfo(i);
        NetworkInfo networkinfo = networkinfo1;
_L2:
        return networkinfo;
        RemoteException remoteexception;
        remoteexception;
        networkinfo = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int getNetworkPreference() {
        int j = mService.getNetworkPreference();
        int i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        i = -1;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public ProxyProperties getProxy() {
        ProxyProperties proxyproperties1 = mService.getProxy();
        ProxyProperties proxyproperties = proxyproperties1;
_L2:
        return proxyproperties;
        RemoteException remoteexception;
        remoteexception;
        proxyproperties = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String[] getTetherableBluetoothRegexs() {
        String as1[] = mService.getTetherableBluetoothRegexs();
        String as[] = as1;
_L2:
        return as;
        RemoteException remoteexception;
        remoteexception;
        as = new String[0];
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String[] getTetherableIfaces() {
        String as1[] = mService.getTetherableIfaces();
        String as[] = as1;
_L2:
        return as;
        RemoteException remoteexception;
        remoteexception;
        as = new String[0];
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String[] getTetherableUsbRegexs() {
        String as1[] = mService.getTetherableUsbRegexs();
        String as[] = as1;
_L2:
        return as;
        RemoteException remoteexception;
        remoteexception;
        as = new String[0];
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String[] getTetherableWifiRegexs() {
        String as1[] = mService.getTetherableWifiRegexs();
        String as[] = as1;
_L2:
        return as;
        RemoteException remoteexception;
        remoteexception;
        as = new String[0];
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String[] getTetheredIfaces() {
        String as1[] = mService.getTetheredIfaces();
        String as[] = as1;
_L2:
        return as;
        RemoteException remoteexception;
        remoteexception;
        as = new String[0];
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String[] getTetheringErroredIfaces() {
        String as1[] = mService.getTetheringErroredIfaces();
        String as[] = as1;
_L2:
        return as;
        RemoteException remoteexception;
        remoteexception;
        as = new String[0];
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean isActiveNetworkMetered() {
        boolean flag1 = mService.isActiveNetworkMetered();
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean isNetworkSupported(int i) {
        boolean flag1 = mService.isNetworkSupported(i);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean isTetheringSupported() {
        boolean flag1 = mService.isTetheringSupported();
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void reportInetCondition(int i, int j) {
        mService.reportInetCondition(i, j);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean requestNetworkTransitionWakelock(String s) {
        mService.requestNetworkTransitionWakelock(s);
        boolean flag = true;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean requestRouteToHost(int i, int j) {
        InetAddress inetaddress = NetworkUtils.intToInetAddress(j);
        boolean flag;
        if(inetaddress == null)
            flag = false;
        else
            flag = requestRouteToHostAddress(i, inetaddress);
        return flag;
    }

    public boolean requestRouteToHostAddress(int i, InetAddress inetaddress) {
        byte abyte0[] = inetaddress.getAddress();
        boolean flag1 = mService.requestRouteToHostAddress(i, abyte0);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void setBackgroundDataSetting(boolean flag) {
    }

    public void setDataDependency(int i, boolean flag) {
        mService.setDataDependency(i, flag);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void setGlobalProxy(ProxyProperties proxyproperties) {
        mService.setGlobalProxy(proxyproperties);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void setMobileDataEnabled(boolean flag) {
        mService.setMobileDataEnabled(flag);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void setNetworkPreference(int i) {
        mService.setNetworkPreference(i);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean setRadio(int i, boolean flag) {
        boolean flag2 = mService.setRadio(i, flag);
        boolean flag1 = flag2;
_L2:
        return flag1;
        RemoteException remoteexception;
        remoteexception;
        flag1 = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean setRadios(boolean flag) {
        boolean flag2 = mService.setRadios(flag);
        boolean flag1 = flag2;
_L2:
        return flag1;
        RemoteException remoteexception;
        remoteexception;
        flag1 = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int setUsbTethering(boolean flag) {
        int j = mService.setUsbTethering(flag);
        int i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        i = 2;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int startUsingNetworkFeature(int i, String s) {
        int k = mService.startUsingNetworkFeature(i, s, new Binder());
        int j = k;
_L2:
        return j;
        RemoteException remoteexception;
        remoteexception;
        j = -1;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int stopUsingNetworkFeature(int i, String s) {
        int k = mService.stopUsingNetworkFeature(i, s);
        int j = k;
_L2:
        return j;
        RemoteException remoteexception;
        remoteexception;
        j = -1;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int tether(String s) {
        int j = mService.tether(s);
        int i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        i = 2;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int untether(String s) {
        int j = mService.untether(s);
        int i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        i = 2;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static final String ACTION_BACKGROUND_DATA_SETTING_CHANGED = "android.net.conn.BACKGROUND_DATA_SETTING_CHANGED";
    public static final String ACTION_TETHER_STATE_CHANGED = "android.net.conn.TETHER_STATE_CHANGED";
    public static final String CONNECTIVITY_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";
    public static final String CONNECTIVITY_ACTION_IMMEDIATE = "android.net.conn.CONNECTIVITY_CHANGE_IMMEDIATE";
    public static final int DEFAULT_NETWORK_PREFERENCE = 1;
    public static final String EXTRA_ACTIVE_TETHER = "activeArray";
    public static final String EXTRA_AVAILABLE_TETHER = "availableArray";
    public static final String EXTRA_ERRORED_TETHER = "erroredArray";
    public static final String EXTRA_EXTRA_INFO = "extraInfo";
    public static final String EXTRA_INET_CONDITION = "inetCondition";
    public static final String EXTRA_IS_FAILOVER = "isFailover";
    public static final String EXTRA_NETWORK_INFO = "networkInfo";
    public static final String EXTRA_NO_CONNECTIVITY = "noConnectivity";
    public static final String EXTRA_OTHER_NETWORK_INFO = "otherNetwork";
    public static final String EXTRA_REASON = "reason";
    public static final String INET_CONDITION_ACTION = "android.net.conn.INET_CONDITION_ACTION";
    public static final int MAX_NETWORK_TYPE = 13;
    public static final int MAX_RADIO_TYPE = 13;
    private static final String TAG = "ConnectivityManager";
    public static final int TETHER_ERROR_DISABLE_NAT_ERROR = 9;
    public static final int TETHER_ERROR_ENABLE_NAT_ERROR = 8;
    public static final int TETHER_ERROR_IFACE_CFG_ERROR = 10;
    public static final int TETHER_ERROR_MASTER_ERROR = 5;
    public static final int TETHER_ERROR_NO_ERROR = 0;
    public static final int TETHER_ERROR_SERVICE_UNAVAIL = 2;
    public static final int TETHER_ERROR_TETHER_IFACE_ERROR = 6;
    public static final int TETHER_ERROR_UNAVAIL_IFACE = 4;
    public static final int TETHER_ERROR_UNKNOWN_IFACE = 1;
    public static final int TETHER_ERROR_UNSUPPORTED = 3;
    public static final int TETHER_ERROR_UNTETHER_IFACE_ERROR = 7;
    public static final int TYPE_BLUETOOTH = 7;
    public static final int TYPE_DUMMY = 8;
    public static final int TYPE_ETHERNET = 9;
    public static final int TYPE_MOBILE = 0;
    public static final int TYPE_MOBILE_CBS = 12;
    public static final int TYPE_MOBILE_DUN = 4;
    public static final int TYPE_MOBILE_FOTA = 10;
    public static final int TYPE_MOBILE_HIPRI = 5;
    public static final int TYPE_MOBILE_IMS = 11;
    public static final int TYPE_MOBILE_MMS = 2;
    public static final int TYPE_MOBILE_SUPL = 3;
    public static final int TYPE_NONE = -1;
    public static final int TYPE_WIFI = 1;
    public static final int TYPE_WIFI_P2P = 13;
    public static final int TYPE_WIMAX = 6;
    private final IConnectivityManager mService;
}
