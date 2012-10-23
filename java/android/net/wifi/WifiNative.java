// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi;

import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.nsd.WifiP2pServiceInfo;
import android.text.TextUtils;
import java.util.*;

// Referenced classes of package android.net.wifi:
//            WpsInfo

public class WifiNative {

    public WifiNative(String s) {
        mInterface = "";
        mInterface = s;
        mTAG = (new StringBuilder()).append("WifiNative-").append(s).toString();
    }

    private native void closeSupplicantConnection(String s);

    private native boolean connectToSupplicant(String s);

    private boolean doBooleanCommand(String s) {
        return doBooleanCommand(mInterface, s);
    }

    private native boolean doBooleanCommand(String s, String s1);

    private int doIntCommand(String s) {
        return doIntCommand(mInterface, s);
    }

    private native int doIntCommand(String s, String s1);

    private String doStringCommand(String s) {
        return doStringCommand(mInterface, s);
    }

    private native String doStringCommand(String s, String s1);

    public static native boolean isDriverLoaded();

    public static native boolean killSupplicant();

    public static native boolean loadDriver();

    public static native boolean startSupplicant(boolean flag);

    public static native boolean unloadDriver();

    private native String waitForEvent(String s);

    public int addNetwork() {
        return doIntCommand("ADD_NETWORK");
    }

    public boolean addToBlacklist(String s) {
        boolean flag;
        if(TextUtils.isEmpty(s))
            flag = false;
        else
            flag = doBooleanCommand((new StringBuilder()).append("BLACKLIST ").append(s).toString());
        return flag;
    }

    public boolean cancelWps() {
        return doBooleanCommand("WPS_CANCEL");
    }

    public boolean clearBlacklist() {
        return doBooleanCommand("BLACKLIST clear");
    }

    public void closeSupplicantConnection() {
        closeSupplicantConnection(mInterface);
    }

    public boolean connectToSupplicant() {
        return connectToSupplicant(mInterface);
    }

    public boolean disableNetwork(int i) {
        return doBooleanCommand((new StringBuilder()).append("DISABLE_NETWORK ").append(i).toString());
    }

    public boolean disconnect() {
        return doBooleanCommand("DISCONNECT");
    }

    public void enableBackgroundScan(boolean flag) {
        if(flag)
            doBooleanCommand("SET pno 1");
        else
            doBooleanCommand("SET pno 0");
    }

    public boolean enableNetwork(int i, boolean flag) {
        boolean flag1;
        if(flag)
            flag1 = doBooleanCommand((new StringBuilder()).append("SELECT_NETWORK ").append(i).toString());
        else
            flag1 = doBooleanCommand((new StringBuilder()).append("ENABLE_NETWORK ").append(i).toString());
        return flag1;
    }

    public int getBand() {
        int i;
        String as[];
        i = -1;
        String s = doStringCommand("DRIVER GETBAND");
        if(TextUtils.isEmpty(s))
            break MISSING_BLOCK_LABEL_41;
        as = s.split(" ");
        int j;
        if(as.length != 2)
            break MISSING_BLOCK_LABEL_41;
        j = Integer.parseInt(as[1]);
        i = j;
_L2:
        return i;
        NumberFormatException numberformatexception;
        numberformatexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int getGroupCapability(String s) {
        int i = 0;
        if(!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        String s1 = p2pPeer(s);
        if(TextUtils.isEmpty(s1)) goto _L1; else goto _L3
_L3:
        String as[];
        int j;
        int k;
        as = s1.split("\n");
        j = as.length;
        k = 0;
_L6:
        if(k >= j) goto _L1; else goto _L4
_L4:
        String as1[];
        String s2 = as[k];
        if(!s2.startsWith("group_capab="))
            break MISSING_BLOCK_LABEL_103;
        as1 = s2.split("=");
        if(as1.length != 2) goto _L1; else goto _L5
_L5:
        int l = Integer.decode(as1[1]).intValue();
        i = l;
          goto _L1
        NumberFormatException numberformatexception;
        numberformatexception;
          goto _L1
        k++;
          goto _L6
    }

    public String getMacAddress() {
        String s = doStringCommand("DRIVER MACADDR");
        if(TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        String as[] = s.split(" = ");
        if(as.length != 2) goto _L2; else goto _L3
_L3:
        String s1 = as[1];
_L5:
        return s1;
_L2:
        s1 = null;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public String getNetworkVariable(int i, String s) {
        String s1;
        if(TextUtils.isEmpty(s))
            s1 = null;
        else
            s1 = doStringCommand((new StringBuilder()).append("GET_NETWORK ").append(i).append(" ").append(s).toString());
        return s1;
    }

    public String listNetworks() {
        return doStringCommand("LIST_NETWORKS");
    }

    public boolean p2pCancelConnect() {
        return doBooleanCommand("P2P_CANCEL");
    }

    public String p2pConnect(WifiP2pConfig wifip2pconfig, boolean flag) {
        if(wifip2pconfig != null) goto _L2; else goto _L1
_L1:
        String s1 = null;
_L10:
        return s1;
_L2:
        ArrayList arraylist;
        WpsInfo wpsinfo;
        arraylist = new ArrayList();
        wpsinfo = wifip2pconfig.wps;
        arraylist.add(wifip2pconfig.deviceAddress);
        wpsinfo.setup;
        JVM INSTR tableswitch 0 3: default 72
    //                   0 149
    //                   1 161
    //                   2 208
    //                   3 232;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_232;
_L8:
        String s;
        if(flag) {
            arraylist.add("join");
        } else {
            int i = wifip2pconfig.groupOwnerIntent;
            if(i < 0 || i > 15)
                i = 7;
            arraylist.add((new StringBuilder()).append("go_intent=").append(i).toString());
        }
        s = "P2P_CONNECT ";
        for(Iterator iterator = arraylist.iterator(); iterator.hasNext();) {
            String s2 = (String)iterator.next();
            s = (new StringBuilder()).append(s).append(s2).append(" ").toString();
        }

        break MISSING_BLOCK_LABEL_308;
_L4:
        arraylist.add("pbc");
          goto _L8
_L5:
        if(TextUtils.isEmpty(wpsinfo.pin))
            arraylist.add("pin");
        else
            arraylist.add(wpsinfo.pin);
        arraylist.add("display");
          goto _L8
_L6:
        arraylist.add(wpsinfo.pin);
        arraylist.add("keypad");
          goto _L8
        arraylist.add(wpsinfo.pin);
        arraylist.add("label");
          goto _L8
        s1 = doStringCommand(s);
        if(true) goto _L10; else goto _L9
_L9:
    }

    public boolean p2pFind() {
        return doBooleanCommand("P2P_FIND");
    }

    public boolean p2pFind(int i) {
        boolean flag;
        if(i <= 0)
            flag = p2pFind();
        else
            flag = doBooleanCommand((new StringBuilder()).append("P2P_FIND ").append(i).toString());
        return flag;
    }

    public boolean p2pFlush() {
        return doBooleanCommand("P2P_FLUSH");
    }

    public String p2pGetDeviceAddress() {
        String s = status();
        if(s != null) goto _L2; else goto _L1
_L1:
        String s1 = "";
_L3:
        return s1;
_L2:
        String as[];
        int i;
        int j;
        as = s.split("\n");
        i = as.length;
        j = 0;
_L4:
        String as1[];
label0:
        {
            if(j < i) {
                String s2 = as[j];
                if(!s2.startsWith("p2p_device_address="))
                    break MISSING_BLOCK_LABEL_83;
                as1 = s2.split("=");
                if(as1.length == 2)
                    break label0;
            }
            s1 = "";
        }
          goto _L3
        s1 = as1[1];
          goto _L3
        j++;
          goto _L4
    }

    public boolean p2pGroupAdd() {
        return doBooleanCommand("P2P_GROUP_ADD");
    }

    public boolean p2pGroupRemove(String s) {
        boolean flag;
        if(TextUtils.isEmpty(s))
            flag = false;
        else
            flag = doBooleanCommand((new StringBuilder()).append("P2P_GROUP_REMOVE ").append(s).toString());
        return flag;
    }

    public boolean p2pInvite(WifiP2pGroup wifip2pgroup, String s) {
        boolean flag;
        if(TextUtils.isEmpty(s))
            flag = false;
        else
        if(wifip2pgroup == null)
            flag = doBooleanCommand((new StringBuilder()).append("P2P_INVITE peer=").append(s).toString());
        else
            flag = doBooleanCommand((new StringBuilder()).append("P2P_INVITE group=").append(wifip2pgroup.getInterface()).append(" peer=").append(s).append(" go_dev_addr=").append(wifip2pgroup.getOwner().deviceAddress).toString());
        return flag;
    }

    public boolean p2pListen() {
        return doBooleanCommand("P2P_LISTEN");
    }

    public boolean p2pListen(int i) {
        boolean flag;
        if(i <= 0)
            flag = p2pListen();
        else
            flag = doBooleanCommand((new StringBuilder()).append("P2P_LISTEN ").append(i).toString());
        return flag;
    }

    public String p2pPeer(String s) {
        return doStringCommand((new StringBuilder()).append("P2P_PEER ").append(s).toString());
    }

    public boolean p2pProvisionDiscovery(WifiP2pConfig wifip2pconfig) {
        boolean flag = false;
        if(wifip2pconfig != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        switch(wifip2pconfig.wps.setup) {
        case 0: // '\0'
            flag = doBooleanCommand((new StringBuilder()).append("P2P_PROV_DISC ").append(wifip2pconfig.deviceAddress).append(" pbc").toString());
            break;

        case 1: // '\001'
            flag = doBooleanCommand((new StringBuilder()).append("P2P_PROV_DISC ").append(wifip2pconfig.deviceAddress).append(" keypad").toString());
            break;

        case 2: // '\002'
            flag = doBooleanCommand((new StringBuilder()).append("P2P_PROV_DISC ").append(wifip2pconfig.deviceAddress).append(" display").toString());
            break;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean p2pReinvoke(int i, String s) {
        boolean flag;
        if(TextUtils.isEmpty(s) || i < 0)
            flag = false;
        else
            flag = doBooleanCommand((new StringBuilder()).append("P2P_INVITE persistent=").append(i).append(" peer=").append(s).toString());
        return flag;
    }

    public boolean p2pReject(String s) {
        return doBooleanCommand((new StringBuilder()).append("P2P_REJECT ").append(s).toString());
    }

    public boolean p2pServDiscCancelReq(String s) {
        return doBooleanCommand((new StringBuilder()).append("P2P_SERV_DISC_CANCEL_REQ ").append(s).toString());
    }

    public String p2pServDiscReq(String s, String s1) {
        String s2 = (new StringBuilder()).append("P2P_SERV_DISC_REQ").append(" ").append(s).toString();
        return doStringCommand((new StringBuilder()).append(s2).append(" ").append(s1).toString());
    }

    public boolean p2pServiceAdd(WifiP2pServiceInfo wifip2pserviceinfo) {
        Iterator iterator = wifip2pserviceinfo.getSupplicantQueryList().iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        String s = (String)iterator.next();
        if(doBooleanCommand((new StringBuilder()).append("P2P_SERVICE_ADD").append(" ").append(s).toString())) goto _L4; else goto _L3
_L3:
        boolean flag = false;
_L6:
        return flag;
_L2:
        flag = true;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public boolean p2pServiceDel(WifiP2pServiceInfo wifip2pserviceinfo) {
        boolean flag;
        Iterator iterator;
        flag = false;
        iterator = wifip2pserviceinfo.getSupplicantQueryList().iterator();
_L5:
        String s;
        String as[];
        if(!iterator.hasNext())
            break MISSING_BLOCK_LABEL_168;
        s = (String)iterator.next();
        as = s.split(" ");
        if(as.length >= 2) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(!"upnp".equals(as[0])) goto _L4; else goto _L3
_L3:
        String s2 = (new StringBuilder()).append("P2P_SERVICE_DEL ").append(s).toString();
_L7:
        if(doBooleanCommand(s2)) goto _L5; else goto _L1
_L4:
        if(!"bonjour".equals(as[0])) goto _L1; else goto _L6
_L6:
        String s1 = (new StringBuilder()).append("P2P_SERVICE_DEL ").append(as[0]).toString();
        s2 = (new StringBuilder()).append(s1).append(" ").append(as[1]).toString();
          goto _L7
        flag = true;
          goto _L1
    }

    public boolean p2pServiceFlush() {
        return doBooleanCommand("P2P_SERVICE_FLUSH");
    }

    public boolean p2pStopFind() {
        return doBooleanCommand("P2P_STOP_FIND");
    }

    public boolean ping() {
        String s = doStringCommand("PING");
        boolean flag;
        if(s != null && s.equals("PONG"))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean reassociate() {
        return doBooleanCommand("REASSOCIATE");
    }

    public boolean reconnect() {
        return doBooleanCommand("RECONNECT");
    }

    public boolean removeNetwork(int i) {
        return doBooleanCommand((new StringBuilder()).append("REMOVE_NETWORK ").append(i).toString());
    }

    public boolean saveConfig() {
        boolean flag;
        if(doBooleanCommand("AP_SCAN 1") && doBooleanCommand("SAVE_CONFIG"))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean scan() {
        return doBooleanCommand("SCAN");
    }

    public String scanResults() {
        return doStringCommand("SCAN_RESULTS");
    }

    public boolean setBand(int i) {
        return doBooleanCommand((new StringBuilder()).append("DRIVER SETBAND ").append(i).toString());
    }

    public boolean setBluetoothCoexistenceMode(int i) {
        return doBooleanCommand((new StringBuilder()).append("DRIVER BTCOEXMODE ").append(i).toString());
    }

    public boolean setBluetoothCoexistenceScanMode(boolean flag) {
        boolean flag1;
        if(flag)
            flag1 = doBooleanCommand("DRIVER BTCOEXSCAN-START");
        else
            flag1 = doBooleanCommand("DRIVER BTCOEXSCAN-STOP");
        return flag1;
    }

    public boolean setConcurrencyPriority(String s) {
        return doBooleanCommand((new StringBuilder()).append("P2P_SET conc_pref ").append(s).toString());
    }

    public boolean setConfigMethods(String s) {
        return doBooleanCommand((new StringBuilder()).append("SET config_methods ").append(s).toString());
    }

    public boolean setCountryCode(String s) {
        return doBooleanCommand((new StringBuilder()).append("DRIVER COUNTRY ").append(s).toString());
    }

    public boolean setDeviceName(String s) {
        return doBooleanCommand((new StringBuilder()).append("SET device_name ").append(s).toString());
    }

    public boolean setDeviceType(String s) {
        return doBooleanCommand((new StringBuilder()).append("SET device_type ").append(s).toString());
    }

    public boolean setManufacturer(String s) {
        return doBooleanCommand((new StringBuilder()).append("SET manufacturer ").append(s).toString());
    }

    public boolean setModelName(String s) {
        return doBooleanCommand((new StringBuilder()).append("SET model_name ").append(s).toString());
    }

    public boolean setModelNumber(String s) {
        return doBooleanCommand((new StringBuilder()).append("SET model_number ").append(s).toString());
    }

    public boolean setNetworkVariable(int i, String s, String s1) {
        boolean flag;
        if(TextUtils.isEmpty(s) || TextUtils.isEmpty(s1))
            flag = false;
        else
            flag = doBooleanCommand((new StringBuilder()).append("SET_NETWORK ").append(i).append(" ").append(s).append(" ").append(s1).toString());
        return flag;
    }

    public boolean setP2pGroupIdle(String s, int i) {
        return doBooleanCommand((new StringBuilder()).append("SET interface=").append(s).append(" p2p_group_idle ").append(i).toString());
    }

    public boolean setP2pPowerSave(String s, boolean flag) {
        boolean flag1;
        if(flag)
            flag1 = doBooleanCommand((new StringBuilder()).append("P2P_SET interface=").append(s).append(" ps 1").toString());
        else
            flag1 = doBooleanCommand((new StringBuilder()).append("P2P_SET interface=").append(s).append(" ps 0").toString());
        return flag1;
    }

    public boolean setP2pSsidPostfix(String s) {
        return doBooleanCommand((new StringBuilder()).append("SET p2p_ssid_postfix ").append(s).toString());
    }

    public boolean setPersistentReconnect(boolean flag) {
        int i = 1;
        if(flag != i)
            i = 0;
        return doBooleanCommand((new StringBuilder()).append("SET persistent_reconnect ").append(i).toString());
    }

    public void setPowerSave(boolean flag) {
        if(flag)
            doBooleanCommand("SET ps 1");
        else
            doBooleanCommand("SET ps 0");
    }

    public void setScanInterval(int i) {
        doBooleanCommand((new StringBuilder()).append("SCAN_INTERVAL ").append(i).toString());
    }

    public boolean setScanMode(boolean flag) {
        boolean flag1;
        if(flag)
            flag1 = doBooleanCommand("DRIVER SCAN-ACTIVE");
        else
            flag1 = doBooleanCommand("DRIVER SCAN-PASSIVE");
        return flag1;
    }

    public boolean setScanResultHandling(int i) {
        return doBooleanCommand((new StringBuilder()).append("AP_SCAN ").append(i).toString());
    }

    public boolean setSerialNumber(String s) {
        return doBooleanCommand((new StringBuilder()).append("SET serial_number ").append(s).toString());
    }

    public boolean setSuspendOptimizations(boolean flag) {
        boolean flag1;
        if(flag)
            flag1 = doBooleanCommand("DRIVER SETSUSPENDMODE 1");
        else
            flag1 = doBooleanCommand("DRIVER SETSUSPENDMODE 0");
        return flag1;
    }

    public String signalPoll() {
        return doStringCommand("SIGNAL_POLL");
    }

    public boolean startDriver() {
        return doBooleanCommand("DRIVER START");
    }

    public boolean startFilteringMulticastV4Packets() {
        boolean flag;
        if(doBooleanCommand("DRIVER RXFILTER-STOP") && doBooleanCommand("DRIVER RXFILTER-REMOVE 2") && doBooleanCommand("DRIVER RXFILTER-START"))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean startFilteringMulticastV6Packets() {
        boolean flag;
        if(doBooleanCommand("DRIVER RXFILTER-STOP") && doBooleanCommand("DRIVER RXFILTER-REMOVE 3") && doBooleanCommand("DRIVER RXFILTER-START"))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean startWpsPbc(String s) {
        boolean flag;
        if(TextUtils.isEmpty(s))
            flag = doBooleanCommand("WPS_PBC");
        else
            flag = doBooleanCommand((new StringBuilder()).append("WPS_PBC ").append(s).toString());
        return flag;
    }

    public boolean startWpsPbc(String s, String s1) {
        boolean flag;
        if(TextUtils.isEmpty(s1))
            flag = doBooleanCommand((new StringBuilder()).append("WPS_PBC interface=").append(s).toString());
        else
            flag = doBooleanCommand((new StringBuilder()).append("WPS_PBC interface=").append(s).append(" ").append(s1).toString());
        return flag;
    }

    public String startWpsPinDisplay(String s) {
        String s1;
        if(TextUtils.isEmpty(s))
            s1 = doStringCommand("WPS_PIN any");
        else
            s1 = doStringCommand((new StringBuilder()).append("WPS_PIN ").append(s).toString());
        return s1;
    }

    public String startWpsPinDisplay(String s, String s1) {
        String s2;
        if(TextUtils.isEmpty(s1))
            s2 = doStringCommand((new StringBuilder()).append("WPS_PIN interface=").append(s).append(" any").toString());
        else
            s2 = doStringCommand((new StringBuilder()).append("WPS_PIN interface=").append(s).append(" ").append(s1).toString());
        return s2;
    }

    public boolean startWpsPinKeypad(String s) {
        boolean flag;
        if(TextUtils.isEmpty(s))
            flag = false;
        else
            flag = doBooleanCommand((new StringBuilder()).append("WPS_PIN any ").append(s).toString());
        return flag;
    }

    public boolean startWpsPinKeypad(String s, String s1) {
        boolean flag;
        if(TextUtils.isEmpty(s1))
            flag = false;
        else
            flag = doBooleanCommand((new StringBuilder()).append("WPS_PIN interface=").append(s).append(" any ").append(s1).toString());
        return flag;
    }

    public boolean startWpsRegistrar(String s, String s1) {
        boolean flag;
        if(TextUtils.isEmpty(s) || TextUtils.isEmpty(s1))
            flag = false;
        else
            flag = doBooleanCommand((new StringBuilder()).append("WPS_REG ").append(s).append(" ").append(s1).toString());
        return flag;
    }

    public String status() {
        return doStringCommand("STATUS");
    }

    public boolean stopDriver() {
        return doBooleanCommand("DRIVER STOP");
    }

    public boolean stopFilteringMulticastV4Packets() {
        boolean flag;
        if(doBooleanCommand("DRIVER RXFILTER-STOP") && doBooleanCommand("DRIVER RXFILTER-ADD 2") && doBooleanCommand("DRIVER RXFILTER-START"))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean stopFilteringMulticastV6Packets() {
        boolean flag;
        if(doBooleanCommand("DRIVER RXFILTER-STOP") && doBooleanCommand("DRIVER RXFILTER-ADD 3") && doBooleanCommand("DRIVER RXFILTER-START"))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean stopSupplicant() {
        return doBooleanCommand("TERMINATE");
    }

    public String waitForEvent() {
        return waitForEvent(mInterface);
    }

    static final int BLUETOOTH_COEXISTENCE_MODE_DISABLED = 1;
    static final int BLUETOOTH_COEXISTENCE_MODE_ENABLED = 0;
    static final int BLUETOOTH_COEXISTENCE_MODE_SENSE = 2;
    private static final boolean DBG = false;
    private static final int DEFAULT_GROUP_OWNER_INTENT = 7;
    String mInterface;
    private final String mTAG;
}
