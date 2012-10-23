// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi;

import android.content.Context;
import android.content.Intent;
import android.net.*;
import android.os.*;
import android.text.TextUtils;
import android.util.Log;
import java.io.*;
import java.net.InetAddress;
import java.util.*;

// Referenced classes of package android.net.wifi:
//            WifiConfiguration, WifiNative, NetworkUpdateResult, WpsResult, 
//            WpsInfo

class WifiConfigStore {
    private static class DelayedDiskWrite {

        private static void loge(String s) {
            Log.e("DelayedDiskWrite", s);
        }

        private static void onWriteCalled(List list) {
            DataOutputStream dataoutputstream = null;
            DataOutputStream dataoutputstream1 = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(WifiConfigStore.ipConfigFile)));
            Iterator iterator;
            dataoutputstream1.writeInt(2);
            iterator = list.iterator();
_L11:
            if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
            WifiConfiguration wificonfiguration = (WifiConfiguration)iterator.next();
            boolean flag = false;
            LinkProperties linkproperties = wificonfiguration.linkProperties;
            class _cls1 {

                static final int $SwitchMap$android$net$NetworkInfo$DetailedState[];
                static final int $SwitchMap$android$net$wifi$WifiConfiguration$IpAssignment[];
                static final int $SwitchMap$android$net$wifi$WifiConfiguration$ProxySettings[];

                static  {
                    $SwitchMap$android$net$wifi$WifiConfiguration$ProxySettings = new int[WifiConfiguration.ProxySettings.values().length];
                    NoSuchFieldError nosuchfielderror7;
                    try {
                        $SwitchMap$android$net$wifi$WifiConfiguration$ProxySettings[WifiConfiguration.ProxySettings.STATIC.ordinal()] = 1;
                    }
                    catch(NoSuchFieldError nosuchfielderror) { }
                    try {
                        $SwitchMap$android$net$wifi$WifiConfiguration$ProxySettings[WifiConfiguration.ProxySettings.NONE.ordinal()] = 2;
                    }
                    catch(NoSuchFieldError nosuchfielderror1) { }
                    try {
                        $SwitchMap$android$net$wifi$WifiConfiguration$ProxySettings[WifiConfiguration.ProxySettings.UNASSIGNED.ordinal()] = 3;
                    }
                    catch(NoSuchFieldError nosuchfielderror2) { }
                    $SwitchMap$android$net$wifi$WifiConfiguration$IpAssignment = new int[WifiConfiguration.IpAssignment.values().length];
                    try {
                        $SwitchMap$android$net$wifi$WifiConfiguration$IpAssignment[WifiConfiguration.IpAssignment.STATIC.ordinal()] = 1;
                    }
                    catch(NoSuchFieldError nosuchfielderror3) { }
                    try {
                        $SwitchMap$android$net$wifi$WifiConfiguration$IpAssignment[WifiConfiguration.IpAssignment.DHCP.ordinal()] = 2;
                    }
                    catch(NoSuchFieldError nosuchfielderror4) { }
                    try {
                        $SwitchMap$android$net$wifi$WifiConfiguration$IpAssignment[WifiConfiguration.IpAssignment.UNASSIGNED.ordinal()] = 3;
                    }
                    catch(NoSuchFieldError nosuchfielderror5) { }
                    $SwitchMap$android$net$NetworkInfo$DetailedState = new int[android.net.NetworkInfo.DetailedState.values().length];
                    try {
                        $SwitchMap$android$net$NetworkInfo$DetailedState[android.net.NetworkInfo.DetailedState.CONNECTED.ordinal()] = 1;
                    }
                    catch(NoSuchFieldError nosuchfielderror6) { }
                    $SwitchMap$android$net$NetworkInfo$DetailedState[android.net.NetworkInfo.DetailedState.DISCONNECTED.ordinal()] = 2;
_L2:
                    return;
                    nosuchfielderror7;
                    if(true) goto _L2; else goto _L1
_L1:
                }
            }

            _cls1..SwitchMap.android.net.wifi.WifiConfiguration.IpAssignment[wificonfiguration.ipAssignment.ordinal()];
            JVM INSTR tableswitch 1 3: default 112
        //                       1 249
        //                       2 595
        //                       3 117;
               goto _L3 _L4 _L5 _L6
_L3:
            loge("Ignore invalid ip assignment while writing");
_L6:
            _cls1..SwitchMap.android.net.wifi.WifiConfiguration.ProxySettings[wificonfiguration.proxySettings.ordinal()];
            JVM INSTR tableswitch 1 3: default 156
        //                       1 619
        //                       2 699
        //                       3 161;
               goto _L7 _L8 _L9 _L10
_L10:
            break; /* Loop/switch isn't completed */
_L7:
            loge("Ignthisore invalid proxy settings while writing");
_L15:
            if(flag) {
                dataoutputstream1.writeUTF("id");
                dataoutputstream1.writeInt(WifiConfigStore.configKey(wificonfiguration));
            }
_L13:
            dataoutputstream1.writeUTF("eos");
              goto _L11
            IOException ioexception;
            ioexception;
            dataoutputstream = dataoutputstream1;
_L18:
            loge("Error writing data file");
            Exception exception;
            Exception exception1;
            NullPointerException nullpointerexception;
            if(dataoutputstream != null)
                try {
                    dataoutputstream.close();
                }
                catch(Exception exception4) { }
            android/net/wifi/WifiConfigStore$DelayedDiskWrite;
            JVM INSTR monitorenter ;
            int j = -1 + sWriteSequence;
            sWriteSequence = j;
            if(j == 0) {
                sDiskWriteHandler.getLooper().quit();
                sDiskWriteHandler = null;
                sDiskWriteHandlerThread = null;
            }
            android/net/wifi/WifiConfigStore$DelayedDiskWrite;
            JVM INSTR monitorexit ;
_L16:
            return;
_L4:
            dataoutputstream1.writeUTF("ipAssignment");
            dataoutputstream1.writeUTF(wificonfiguration.ipAssignment.toString());
            LinkAddress linkaddress1;
            for(Iterator iterator1 = linkproperties.getLinkAddresses().iterator(); iterator1.hasNext(); dataoutputstream1.writeInt(linkaddress1.getNetworkPrefixLength())) {
                linkaddress1 = (LinkAddress)iterator1.next();
                dataoutputstream1.writeUTF("linkAddress");
                dataoutputstream1.writeUTF(linkaddress1.getAddress().getHostAddress());
            }

              goto _L12
            nullpointerexception;
            loge((new StringBuilder()).append("Failure in writing ").append(wificonfiguration.linkProperties).append(nullpointerexception).toString());
              goto _L13
            exception;
            dataoutputstream = dataoutputstream1;
_L17:
            if(dataoutputstream != null)
                try {
                    dataoutputstream.close();
                }
                catch(Exception exception2) { }
            android/net/wifi/WifiConfigStore$DelayedDiskWrite;
            JVM INSTR monitorenter ;
            int i = -1 + sWriteSequence;
            sWriteSequence = i;
            if(i == 0) {
                sDiskWriteHandler.getLooper().quit();
                sDiskWriteHandler = null;
                sDiskWriteHandlerThread = null;
            }
            android/net/wifi/WifiConfigStore$DelayedDiskWrite;
            JVM INSTR monitorexit ;
            throw exception;
_L12:
            for(Iterator iterator2 = linkproperties.getRoutes().iterator(); iterator2.hasNext();) {
                RouteInfo routeinfo = (RouteInfo)iterator2.next();
                dataoutputstream1.writeUTF("gateway");
                LinkAddress linkaddress = routeinfo.getDestination();
                if(linkaddress != null) {
                    dataoutputstream1.writeInt(1);
                    dataoutputstream1.writeUTF(linkaddress.getAddress().getHostAddress());
                    dataoutputstream1.writeInt(linkaddress.getNetworkPrefixLength());
                } else {
                    dataoutputstream1.writeInt(0);
                }
                if(routeinfo.getGateway() != null) {
                    dataoutputstream1.writeInt(1);
                    dataoutputstream1.writeUTF(routeinfo.getGateway().getHostAddress());
                } else {
                    dataoutputstream1.writeInt(0);
                }
            }

            InetAddress inetaddress;
            for(Iterator iterator3 = linkproperties.getDnses().iterator(); iterator3.hasNext(); dataoutputstream1.writeUTF(inetaddress.getHostAddress())) {
                inetaddress = (InetAddress)iterator3.next();
                dataoutputstream1.writeUTF("dns");
            }

              goto _L14
_L5:
            dataoutputstream1.writeUTF("ipAssignment");
            dataoutputstream1.writeUTF(wificonfiguration.ipAssignment.toString());
            flag = true;
              goto _L6
_L8:
            ProxyProperties proxyproperties = linkproperties.getHttpProxy();
            String s = proxyproperties.getExclusionList();
            dataoutputstream1.writeUTF("proxySettings");
            dataoutputstream1.writeUTF(wificonfiguration.proxySettings.toString());
            dataoutputstream1.writeUTF("proxyHost");
            dataoutputstream1.writeUTF(proxyproperties.getHost());
            dataoutputstream1.writeUTF("proxyPort");
            dataoutputstream1.writeInt(proxyproperties.getPort());
            dataoutputstream1.writeUTF("exclusionList");
            dataoutputstream1.writeUTF(s);
            flag = true;
              goto _L15
_L9:
            dataoutputstream1.writeUTF("proxySettings");
            dataoutputstream1.writeUTF(wificonfiguration.proxySettings.toString());
            flag = true;
              goto _L15
_L2:
            Exception exception3;
            if(dataoutputstream1 != null)
                try {
                    dataoutputstream1.close();
                }
                catch(Exception exception6) { }
            android/net/wifi/WifiConfigStore$DelayedDiskWrite;
            JVM INSTR monitorenter ;
            int k = -1 + sWriteSequence;
            sWriteSequence = k;
            if(k == 0) {
                sDiskWriteHandler.getLooper().quit();
                sDiskWriteHandler = null;
                sDiskWriteHandlerThread = null;
            }
            android/net/wifi/WifiConfigStore$DelayedDiskWrite;
            JVM INSTR monitorexit ;
              goto _L16
            exception1;
            android/net/wifi/WifiConfigStore$DelayedDiskWrite;
            JVM INSTR monitorexit ;
            throw exception1;
            exception3;
            android/net/wifi/WifiConfigStore$DelayedDiskWrite;
            JVM INSTR monitorexit ;
            throw exception3;
            Exception exception5;
            exception5;
            android/net/wifi/WifiConfigStore$DelayedDiskWrite;
            JVM INSTR monitorexit ;
            throw exception5;
            exception;
              goto _L17
            IOException ioexception1;
            ioexception1;
              goto _L18
_L14:
            flag = true;
              goto _L6
        }

        static void write(final List networks) {
            android/net/wifi/WifiConfigStore$DelayedDiskWrite;
            JVM INSTR monitorenter ;
            int i = 1 + sWriteSequence;
            sWriteSequence = i;
            if(i == 1) {
                sDiskWriteHandlerThread = new HandlerThread("WifiConfigThread");
                sDiskWriteHandlerThread.start();
                sDiskWriteHandler = new Handler(sDiskWriteHandlerThread.getLooper());
            }
            android/net/wifi/WifiConfigStore$DelayedDiskWrite;
            JVM INSTR monitorexit ;
            sDiskWriteHandler.post(new Runnable() {

                public void run() {
                    DelayedDiskWrite.onWriteCalled(networks);
                }

                final List val$networks;

                 {
                    networks = list;
                    super();
                }
            });
            return;
            Exception exception;
            exception;
            android/net/wifi/WifiConfigStore$DelayedDiskWrite;
            JVM INSTR monitorexit ;
            throw exception;
        }

        private static final String TAG = "DelayedDiskWrite";
        private static Handler sDiskWriteHandler;
        private static HandlerThread sDiskWriteHandlerThread;
        private static int sWriteSequence = 0;



        private DelayedDiskWrite() {
        }
    }


    WifiConfigStore(Context context, WifiNative wifinative) {
        mConfiguredNetworks = new HashMap();
        mNetworkIds = new HashMap();
        mLastPriority = -1;
        mContext = context;
        mWifiNative = wifinative;
    }

    private void addIpSettingsFromConfig(LinkProperties linkproperties, WifiConfiguration wificonfiguration) {
        for(Iterator iterator = wificonfiguration.linkProperties.getLinkAddresses().iterator(); iterator.hasNext(); linkproperties.addLinkAddress((LinkAddress)iterator.next()));
        for(Iterator iterator1 = wificonfiguration.linkProperties.getRoutes().iterator(); iterator1.hasNext(); linkproperties.addRoute((RouteInfo)iterator1.next()));
        for(Iterator iterator2 = wificonfiguration.linkProperties.getDnses().iterator(); iterator2.hasNext(); linkproperties.addDns((InetAddress)iterator2.next()));
    }

    private NetworkUpdateResult addOrUpdateNetworkNative(WifiConfiguration wificonfiguration) {
        int i;
        boolean flag;
        i = wificonfiguration.networkId;
        flag = false;
        if(i != -1) goto _L2; else goto _L1
_L1:
        Integer integer = (Integer)mNetworkIds.get(Integer.valueOf(configKey(wificonfiguration)));
        if(integer == null) goto _L4; else goto _L3
_L3:
        i = integer.intValue();
_L2:
        boolean flag1;
        NetworkUpdateResult networkupdateresult;
        flag1 = true;
        if(wificonfiguration.SSID != null && !mWifiNative.setNetworkVariable(i, "ssid", wificonfiguration.SSID))
            loge((new StringBuilder()).append("failed to set SSID: ").append(wificonfiguration.SSID).toString());
        else
        if(wificonfiguration.BSSID != null && !mWifiNative.setNetworkVariable(i, "bssid", wificonfiguration.BSSID)) {
            loge((new StringBuilder()).append("failed to set BSSID: ").append(wificonfiguration.BSSID).toString());
        } else {
            String s = makeString(wificonfiguration.allowedKeyManagement, WifiConfiguration.KeyMgmt.strings);
            if(wificonfiguration.allowedKeyManagement.cardinality() != 0 && !mWifiNative.setNetworkVariable(i, "key_mgmt", s)) {
                loge((new StringBuilder()).append("failed to set key_mgmt: ").append(s).toString());
            } else {
                String s1 = makeString(wificonfiguration.allowedProtocols, WifiConfiguration.Protocol.strings);
                if(wificonfiguration.allowedProtocols.cardinality() != 0 && !mWifiNative.setNetworkVariable(i, "proto", s1)) {
                    loge((new StringBuilder()).append("failed to set proto: ").append(s1).toString());
                } else {
                    String s2 = makeString(wificonfiguration.allowedAuthAlgorithms, WifiConfiguration.AuthAlgorithm.strings);
                    if(wificonfiguration.allowedAuthAlgorithms.cardinality() != 0 && !mWifiNative.setNetworkVariable(i, "auth_alg", s2)) {
                        loge((new StringBuilder()).append("failed to set auth_alg: ").append(s2).toString());
                    } else {
                        String s3 = makeString(wificonfiguration.allowedPairwiseCiphers, WifiConfiguration.PairwiseCipher.strings);
                        if(wificonfiguration.allowedPairwiseCiphers.cardinality() != 0 && !mWifiNative.setNetworkVariable(i, "pairwise", s3)) {
                            loge((new StringBuilder()).append("failed to set pairwise: ").append(s3).toString());
                        } else {
                            String s4 = makeString(wificonfiguration.allowedGroupCiphers, WifiConfiguration.GroupCipher.strings);
                            if(wificonfiguration.allowedGroupCiphers.cardinality() != 0 && !mWifiNative.setNetworkVariable(i, "group", s4)) {
                                loge((new StringBuilder()).append("failed to set group: ").append(s4).toString());
                            } else {
label0:
                                {
                                    if(wificonfiguration.preSharedKey == null || wificonfiguration.preSharedKey.equals("*") || mWifiNative.setNetworkVariable(i, "psk", wificonfiguration.preSharedKey))
                                        break label0;
                                    loge("failed to set psk");
                                }
                            }
                        }
                    }
                }
            }
        }
_L9:
        boolean flag2;
        WifiConfiguration.EnterpriseField aenterprisefield[];
        int j;
        int k;
        int i1;
        if(flag1) {
            if(flag) {
                mWifiNative.removeNetwork(i);
                loge((new StringBuilder()).append("Failed to set a network variable, removed network: ").append(i).toString());
            }
            networkupdateresult = new NetworkUpdateResult(-1);
        } else {
            WifiConfiguration wificonfiguration1 = (WifiConfiguration)mConfiguredNetworks.get(Integer.valueOf(i));
            if(wificonfiguration1 == null) {
                wificonfiguration1 = new WifiConfiguration();
                wificonfiguration1.networkId = i;
            }
            readNetworkVariables(wificonfiguration1);
            mConfiguredNetworks.put(Integer.valueOf(i), wificonfiguration1);
            mNetworkIds.put(Integer.valueOf(configKey(wificonfiguration1)), Integer.valueOf(i));
            networkupdateresult = writeIpAndProxyConfigurationsOnChange(wificonfiguration1, wificonfiguration);
            networkupdateresult.setIsNewNetwork(flag);
            networkupdateresult.setNetworkId(i);
        }
_L6:
        return networkupdateresult;
_L4:
        flag = true;
        i = mWifiNative.addNetwork();
        if(i >= 0) goto _L2; else goto _L5
_L5:
        loge("Failed to add a network!");
        networkupdateresult = new NetworkUpdateResult(-1);
          goto _L6
        flag2 = false;
        if(wificonfiguration.wepKeys == null)
            break MISSING_BLOCK_LABEL_745;
        i1 = 0;
_L10:
        if(i1 >= wificonfiguration.wepKeys.length) goto _L8; else goto _L7
_L7:
label1:
        {
            if(wificonfiguration.wepKeys[i1] == null || wificonfiguration.wepKeys[i1].equals("*"))
                continue; /* Loop/switch isn't completed */
            if(mWifiNative.setNetworkVariable(i, WifiConfiguration.wepKeyVarNames[i1], wificonfiguration.wepKeys[i1]))
                break label1;
            loge((new StringBuilder()).append("failed to set wep_key").append(i1).append(": ").append(wificonfiguration.wepKeys[i1]).toString());
        }
          goto _L9
        flag2 = true;
        i1++;
          goto _L10
_L8:
        if(flag2 && !mWifiNative.setNetworkVariable(i, "wep_tx_keyidx", Integer.toString(wificonfiguration.wepTxKeyIndex)))
            loge((new StringBuilder()).append("failed to set wep_tx_keyidx: ").append(wificonfiguration.wepTxKeyIndex).toString());
        else
        if(!mWifiNative.setNetworkVariable(i, "priority", Integer.toString(wificonfiguration.priority))) {
            loge((new StringBuilder()).append(wificonfiguration.SSID).append(": failed to set priority: ").append(wificonfiguration.priority).toString());
        } else {
label2:
            {
                if(!wificonfiguration.hiddenSSID)
                    break label2;
                WifiNative wifinative = mWifiNative;
                int l;
                if(wificonfiguration.hiddenSSID)
                    l = 1;
                else
                    l = 0;
                if(wifinative.setNetworkVariable(i, "scan_ssid", Integer.toString(l)))
                    break label2;
                loge((new StringBuilder()).append(wificonfiguration.SSID).append(": failed to set hiddenSSID: ").append(wificonfiguration.hiddenSSID).toString());
            }
        }
          goto _L9
        aenterprisefield = wificonfiguration.enterpriseFields;
        j = aenterprisefield.length;
        k = 0;
_L13:
        if(k >= j) goto _L12; else goto _L11
_L11:
        WifiConfiguration.EnterpriseField enterprisefield = aenterprisefield[k];
        String s5 = enterprisefield.varName();
        String s6 = enterprisefield.value();
        if(s6 == null)
            continue; /* Loop/switch isn't completed */
        if(enterprisefield == wificonfiguration.engine) {
            if(s6.length() == 0)
                s6 = "0";
        } else
        if(enterprisefield != wificonfiguration.eap)
            if(s6.length() == 0)
                s6 = "NULL";
            else
                s6 = convertToQuotedString(s6);
        if(mWifiNative.setNetworkVariable(i, s5, s6))
            continue; /* Loop/switch isn't completed */
        loge((new StringBuilder()).append(wificonfiguration.SSID).append(": failed to set ").append(s5).append(": ").append(s6).toString());
          goto _L9
        k++;
          goto _L13
_L12:
        flag1 = false;
          goto _L9
    }

    private static int configKey(WifiConfiguration wificonfiguration) {
        String s;
        if(wificonfiguration.allowedKeyManagement.get(1))
            s = (new StringBuilder()).append(wificonfiguration.SSID).append(WifiConfiguration.KeyMgmt.strings[1]).toString();
        else
        if(wificonfiguration.allowedKeyManagement.get(2) || wificonfiguration.allowedKeyManagement.get(3))
            s = (new StringBuilder()).append(wificonfiguration.SSID).append(WifiConfiguration.KeyMgmt.strings[2]).toString();
        else
        if(wificonfiguration.wepKeys[0] != null)
            s = (new StringBuilder()).append(wificonfiguration.SSID).append("WEP").toString();
        else
            s = (new StringBuilder()).append(wificonfiguration.SSID).append(WifiConfiguration.KeyMgmt.strings[0]).toString();
        return s.hashCode();
    }

    private String convertToQuotedString(String s) {
        return (new StringBuilder()).append("\"").append(s).append("\"").toString();
    }

    private void log(String s) {
        Log.d("WifiConfigStore", s);
    }

    private void loge(String s) {
        Log.e("WifiConfigStore", s);
    }

    private int lookupString(String s, String as[]) {
        int i;
        String s1;
        int j;
        i = as.length;
        s1 = s.replace('-', '_');
        j = 0;
_L3:
        if(j >= i)
            break MISSING_BLOCK_LABEL_43;
        if(!s1.equals(as[j])) goto _L2; else goto _L1
_L1:
        return j;
_L2:
        j++;
          goto _L3
        loge((new StringBuilder()).append("Failed to look-up a string: ").append(s1).toString());
        j = -1;
          goto _L1
    }

    private String makeString(BitSet bitset, String as[]) {
        StringBuffer stringbuffer = new StringBuffer();
        int i = -1;
        BitSet bitset1 = bitset.get(0, as.length);
        do {
            i = bitset1.nextSetBit(i + 1);
            if(i == -1)
                break;
            stringbuffer.append(as[i].replace('_', '-')).append(' ');
        } while(true);
        if(bitset1.cardinality() > 0)
            stringbuffer.setLength(-1 + stringbuffer.length());
        return stringbuffer.toString();
    }

    private void markAllNetworksDisabled() {
        markAllNetworksDisabledExcept(-1);
    }

    private void markAllNetworksDisabledExcept(int i) {
        Iterator iterator = mConfiguredNetworks.values().iterator();
        do {
            if(!iterator.hasNext())
                break;
            WifiConfiguration wificonfiguration = (WifiConfiguration)iterator.next();
            if(wificonfiguration != null && wificonfiguration.networkId != i && wificonfiguration.status != 1) {
                wificonfiguration.status = 1;
                wificonfiguration.disableReason = 0;
            }
        } while(true);
    }

    private void migrateOldEapTlsIfNecessary(WifiConfiguration wificonfiguration, int i) {
        String s = mWifiNative.getNetworkVariable(i, "private_key");
        if(!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s1 = removeDoubleQuotes(s);
        if(!TextUtils.isEmpty(s1)) {
            wificonfiguration.engine.setValue("1");
            wificonfiguration.engine_id.setValue(convertToQuotedString("keystore"));
            String s2;
            WifiConfiguration.EnterpriseField aenterprisefield[];
            int j;
            if(s1.startsWith("keystore://"))
                s2 = new String(s1.substring("keystore://".length()));
            else
                s2 = s1;
            wificonfiguration.key_id.setValue(convertToQuotedString(s2));
            aenterprisefield = new WifiConfiguration.EnterpriseField[3];
            aenterprisefield[0] = wificonfiguration.engine;
            aenterprisefield[1] = wificonfiguration.engine_id;
            aenterprisefield[2] = wificonfiguration.key_id;
            j = aenterprisefield.length;
            for(int k = 0; k < j; k++) {
                WifiConfiguration.EnterpriseField enterprisefield = aenterprisefield[k];
                mWifiNative.setNetworkVariable(i, enterprisefield.varName(), enterprisefield.value());
            }

            mWifiNative.setNetworkVariable(i, "private_key", convertToQuotedString(""));
            saveConfig();
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void readIpAndProxyConfigurations() {
        DataInputStream datainputstream = null;
        DataInputStream datainputstream1 = new DataInputStream(new BufferedInputStream(new FileInputStream(ipConfigFile)));
        int i = datainputstream1.readInt();
        if(i == 2 || i == 1) goto _L2; else goto _L1
_L1:
        loge("Bad version on IP configuration file, ignore read");
        if(datainputstream1 == null)
            break MISSING_BLOCK_LABEL_60;
        datainputstream1.close();
_L15:
        return;
_L25:
        String s2;
        boolean flag = s2.equals("eos");
        if(!flag) goto _L4; else goto _L3
_L3:
        int j;
        if(j == -1) goto _L2; else goto _L5
_L5:
        WifiConfiguration wificonfiguration = (WifiConfiguration)mConfiguredNetworks.get(mNetworkIds.get(Integer.valueOf(j)));
        if(wificonfiguration != null) goto _L7; else goto _L6
_L6:
        loge("configuration found for missing network, ignored");
_L2:
        WifiConfiguration.IpAssignment ipassignment;
        WifiConfiguration.ProxySettings proxysettings;
        LinkProperties linkproperties;
        String s;
        int k;
        String s1;
        j = -1;
        ipassignment = WifiConfiguration.IpAssignment.UNASSIGNED;
        proxysettings = WifiConfiguration.ProxySettings.UNASSIGNED;
        linkproperties = new LinkProperties();
        s = null;
        k = -1;
        s1 = null;
_L10:
        s2 = datainputstream1.readUTF();
        if(!s2.equals("id")) goto _L9; else goto _L8
_L8:
        j = datainputstream1.readInt();
          goto _L10
_L9:
        if(!s2.equals("ipAssignment")) goto _L12; else goto _L11
_L11:
        ipassignment = WifiConfiguration.IpAssignment.valueOf(datainputstream1.readUTF());
          goto _L10
_L12:
        if(!s2.equals("linkAddress")) goto _L14; else goto _L13
_L13:
        linkproperties.addLinkAddress(new LinkAddress(NetworkUtils.numericToInetAddress(datainputstream1.readUTF()), datainputstream1.readInt()));
          goto _L10
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        loge((new StringBuilder()).append("Ignore invalid address while reading").append(illegalargumentexception).toString());
          goto _L10
        EOFException eofexception;
        eofexception;
        datainputstream = datainputstream1;
_L36:
        if(datainputstream != null)
            try {
                datainputstream.close();
            }
            catch(Exception exception2) { }
          goto _L15
_L14:
        if(!s2.equals("gateway")) goto _L17; else goto _L16
_L16:
        LinkAddress linkaddress;
        InetAddress inetaddress;
        linkaddress = null;
        inetaddress = null;
        if(i != 1) goto _L19; else goto _L18
_L18:
        inetaddress = NetworkUtils.numericToInetAddress(datainputstream1.readUTF());
_L21:
        RouteInfo routeinfo = new RouteInfo(linkaddress, inetaddress);
        linkproperties.addRoute(routeinfo);
          goto _L10
        IOException ioexception;
        ioexception;
        datainputstream = datainputstream1;
_L35:
        loge((new StringBuilder()).append("Error parsing configuration").append(ioexception).toString());
        if(datainputstream == null) goto _L15; else goto _L20
_L20:
        datainputstream.close();
          goto _L15
_L19:
        if(datainputstream1.readInt() == 1)
            linkaddress = new LinkAddress(NetworkUtils.numericToInetAddress(datainputstream1.readUTF()), datainputstream1.readInt());
        if(datainputstream1.readInt() == 1)
            inetaddress = NetworkUtils.numericToInetAddress(datainputstream1.readUTF());
          goto _L21
_L17:
        if(!s2.equals("dns")) goto _L23; else goto _L22
_L22:
        linkproperties.addDns(NetworkUtils.numericToInetAddress(datainputstream1.readUTF()));
          goto _L10
        Exception exception;
        exception;
        datainputstream = datainputstream1;
_L34:
        ProxyProperties proxyproperties;
        if(datainputstream != null)
            try {
                datainputstream.close();
            }
            catch(Exception exception1) { }
        throw exception;
_L23:
        if(s2.equals("proxySettings"))
            proxysettings = WifiConfiguration.ProxySettings.valueOf(datainputstream1.readUTF());
        else
        if(s2.equals("proxyHost")) {
            s = datainputstream1.readUTF();
        } else {
            if(!s2.equals("proxyPort"))
                continue; /* Loop/switch isn't completed */
            k = datainputstream1.readInt();
        }
          goto _L10
        if(!s2.equals("exclusionList")) goto _L25; else goto _L24
_L24:
        s1 = datainputstream1.readUTF();
          goto _L10
_L4:
        loge((new StringBuilder()).append("Ignore unknown key ").append(s2).append("while reading").toString());
          goto _L10
_L7:
        wificonfiguration.linkProperties = linkproperties;
        _cls1..SwitchMap.android.net.wifi.WifiConfiguration.IpAssignment[ipassignment.ordinal()];
        JVM INSTR tableswitch 1 3: default 620
    //                   1 674
    //                   2 674
    //                   3 627;
           goto _L26 _L27 _L27 _L28
_L26:
        loge("Ignore invalid ip assignment while reading");
_L28:
        _cls1..SwitchMap.android.net.wifi.WifiConfiguration.ProxySettings[proxysettings.ordinal()];
        JVM INSTR tableswitch 1 3: default 664
    //                   1 684
    //                   2 716
    //                   3 118;
           goto _L29 _L30 _L31 _L32
_L32:
        if(true) goto _L2; else goto _L33
_L33:
_L29:
        loge("Ignore invalid proxy settings while reading");
          goto _L2
_L27:
        wificonfiguration.ipAssignment = ipassignment;
          goto _L28
_L30:
        wificonfiguration.proxySettings = proxysettings;
        proxyproperties = new ProxyProperties(s, k, s1);
        linkproperties.setHttpProxy(proxyproperties);
          goto _L2
_L31:
        wificonfiguration.proxySettings = proxysettings;
          goto _L2
        Exception exception3;
        exception3;
          goto _L15
        exception;
          goto _L34
        ioexception;
          goto _L35
        EOFException eofexception1;
        eofexception1;
          goto _L36
    }

    private void readNetworkVariables(WifiConfiguration wificonfiguration) {
        int i = wificonfiguration.networkId;
        if(i >= 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s = mWifiNative.getNetworkVariable(i, "ssid");
        String s1;
        String s2;
        String s3;
        String s4;
        int j;
        String s12;
        boolean flag;
        if(!TextUtils.isEmpty(s))
            wificonfiguration.SSID = s;
        else
            wificonfiguration.SSID = null;
        s1 = mWifiNative.getNetworkVariable(i, "bssid");
        if(!TextUtils.isEmpty(s1))
            wificonfiguration.BSSID = s1;
        else
            wificonfiguration.BSSID = null;
        s2 = mWifiNative.getNetworkVariable(i, "priority");
        wificonfiguration.priority = -1;
        String s5;
        String s6;
        String s7;
        String s8;
        String s9;
        String s10;
        WifiConfiguration.EnterpriseField aenterprisefield[];
        int k;
        int l;
        WifiConfiguration.EnterpriseField enterprisefield;
        String s11;
        String as[];
        int i1;
        int j1;
        int k1;
        String as1[];
        int l1;
        int i2;
        int j2;
        String as2[];
        int k2;
        int l2;
        int i3;
        String as3[];
        int j3;
        int k3;
        int l3;
        String as4[];
        int i4;
        int j4;
        int k4;
        NumberFormatException numberformatexception;
        NumberFormatException numberformatexception1;
        if(!TextUtils.isEmpty(s2))
            try {
                wificonfiguration.priority = Integer.parseInt(s2);
            }
            catch(NumberFormatException numberformatexception2) { }
        s3 = mWifiNative.getNetworkVariable(i, "scan_ssid");
        wificonfiguration.hiddenSSID = false;
        if(TextUtils.isEmpty(s3)) goto _L4; else goto _L3
_L3:
        if(Integer.parseInt(s3) == 0) goto _L6; else goto _L5
_L5:
        flag = true;
_L7:
        wificonfiguration.hiddenSSID = flag;
          goto _L4
_L6:
        flag = false;
          goto _L7
_L4:
        s4 = mWifiNative.getNetworkVariable(i, "wep_tx_keyidx");
        wificonfiguration.wepTxKeyIndex = -1;
        if(!TextUtils.isEmpty(s4))
            try {
                wificonfiguration.wepTxKeyIndex = Integer.parseInt(s4);
            }
            // Misplaced declaration of an exception variable
            catch(NumberFormatException numberformatexception) { }
        j = 0;
        while(j < 4)  {
            s12 = mWifiNative.getNetworkVariable(i, WifiConfiguration.wepKeyVarNames[j]);
            if(!TextUtils.isEmpty(s12))
                wificonfiguration.wepKeys[j] = s12;
            else
                wificonfiguration.wepKeys[j] = null;
            j++;
        }
        s5 = mWifiNative.getNetworkVariable(i, "psk");
        if(!TextUtils.isEmpty(s5))
            wificonfiguration.preSharedKey = s5;
        else
            wificonfiguration.preSharedKey = null;
        s6 = mWifiNative.getNetworkVariable(wificonfiguration.networkId, "proto");
        if(!TextUtils.isEmpty(s6)) {
            as4 = s6.split(" ");
            i4 = as4.length;
            for(j4 = 0; j4 < i4; j4++) {
                k4 = lookupString(as4[j4], WifiConfiguration.Protocol.strings);
                if(k4 >= 0)
                    wificonfiguration.allowedProtocols.set(k4);
            }

        }
        s7 = mWifiNative.getNetworkVariable(wificonfiguration.networkId, "key_mgmt");
        if(!TextUtils.isEmpty(s7)) {
            as3 = s7.split(" ");
            j3 = as3.length;
            for(k3 = 0; k3 < j3; k3++) {
                l3 = lookupString(as3[k3], WifiConfiguration.KeyMgmt.strings);
                if(l3 >= 0)
                    wificonfiguration.allowedKeyManagement.set(l3);
            }

        }
        s8 = mWifiNative.getNetworkVariable(wificonfiguration.networkId, "auth_alg");
        if(!TextUtils.isEmpty(s8)) {
            as2 = s8.split(" ");
            k2 = as2.length;
            for(l2 = 0; l2 < k2; l2++) {
                i3 = lookupString(as2[l2], WifiConfiguration.AuthAlgorithm.strings);
                if(i3 >= 0)
                    wificonfiguration.allowedAuthAlgorithms.set(i3);
            }

        }
        s9 = mWifiNative.getNetworkVariable(wificonfiguration.networkId, "pairwise");
        if(!TextUtils.isEmpty(s9)) {
            as1 = s9.split(" ");
            l1 = as1.length;
            for(i2 = 0; i2 < l1; i2++) {
                j2 = lookupString(as1[i2], WifiConfiguration.PairwiseCipher.strings);
                if(j2 >= 0)
                    wificonfiguration.allowedPairwiseCiphers.set(j2);
            }

        }
        s10 = mWifiNative.getNetworkVariable(wificonfiguration.networkId, "group");
        if(!TextUtils.isEmpty(s10)) {
            as = s10.split(" ");
            i1 = as.length;
            for(j1 = 0; j1 < i1; j1++) {
                k1 = lookupString(as[j1], WifiConfiguration.GroupCipher.strings);
                if(k1 >= 0)
                    wificonfiguration.allowedGroupCiphers.set(k1);
            }

        }
        aenterprisefield = wificonfiguration.enterpriseFields;
        k = aenterprisefield.length;
        for(l = 0; l < k; l++) {
            enterprisefield = aenterprisefield[l];
            s11 = mWifiNative.getNetworkVariable(i, enterprisefield.varName());
            if(TextUtils.isEmpty(s11))
                continue;
            if(enterprisefield != wificonfiguration.eap && enterprisefield != wificonfiguration.engine)
                s11 = removeDoubleQuotes(s11);
            enterprisefield.setValue(s11);
        }

        migrateOldEapTlsIfNecessary(wificonfiguration, i);
        if(true) goto _L1; else goto _L8
_L8:
        numberformatexception1;
          goto _L4
    }

    private String removeDoubleQuotes(String s) {
        String s1;
        if(s.length() <= 2)
            s1 = "";
        else
            s1 = s.substring(1, -1 + s.length());
        return s1;
    }

    private void sendConfiguredNetworksChangedBroadcast() {
        Intent intent = new Intent("android.net.wifi.CONFIGURED_NETWORKS_CHANGE");
        intent.addFlags(0x8000000);
        intent.putExtra("multipleChanges", true);
        mContext.sendBroadcast(intent);
    }

    private void sendConfiguredNetworksChangedBroadcast(WifiConfiguration wificonfiguration, int i) {
        Intent intent = new Intent("android.net.wifi.CONFIGURED_NETWORKS_CHANGE");
        intent.addFlags(0x8000000);
        intent.putExtra("multipleChanges", false);
        intent.putExtra("wifiConfiguration", wificonfiguration);
        intent.putExtra("changeReason", i);
        mContext.sendBroadcast(intent);
    }

    private void writeIpAndProxyConfigurations() {
        ArrayList arraylist = new ArrayList();
        for(Iterator iterator = mConfiguredNetworks.values().iterator(); iterator.hasNext(); arraylist.add(new WifiConfiguration((WifiConfiguration)iterator.next())));
        DelayedDiskWrite.write(arraylist);
    }

    private NetworkUpdateResult writeIpAndProxyConfigurationsOnChange(WifiConfiguration wificonfiguration, WifiConfiguration wificonfiguration1) {
        boolean flag;
        boolean flag1;
        LinkProperties linkproperties;
        flag = false;
        flag1 = false;
        linkproperties = new LinkProperties();
        _cls1..SwitchMap.android.net.wifi.WifiConfiguration.IpAssignment[wificonfiguration1.ipAssignment.ordinal()];
        JVM INSTR tableswitch 1 3: default 52
    //                   1 171
    //                   2 370
    //                   3 59;
           goto _L1 _L2 _L3 _L4
_L1:
        loge("Ignore invalid ip assignment during write");
_L4:
        _cls1..SwitchMap.android.net.wifi.WifiConfiguration.ProxySettings[wificonfiguration1.proxySettings.ordinal()];
        JVM INSTR tableswitch 1 3: default 96
    //                   1 386
    //                   2 448
    //                   3 103;
           goto _L5 _L6 _L7 _L8
_L8:
        break; /* Loop/switch isn't completed */
_L5:
        loge("Ignore invalid proxy configuration during write");
_L9:
        NetworkUpdateResult networkupdateresult;
        ProxyProperties proxyproperties;
        ProxyProperties proxyproperties1;
        Collection collection;
        Collection collection1;
        Collection collection2;
        Collection collection3;
        Collection collection4;
        Collection collection5;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        if(!flag) {
            addIpSettingsFromConfig(linkproperties, wificonfiguration);
        } else {
            wificonfiguration.ipAssignment = wificonfiguration1.ipAssignment;
            addIpSettingsFromConfig(linkproperties, wificonfiguration1);
            log((new StringBuilder()).append("IP config changed SSID = ").append(wificonfiguration.SSID).append(" linkProperties: ").append(linkproperties.toString()).toString());
        }
        if(!flag1) {
            linkproperties.setHttpProxy(wificonfiguration.linkProperties.getHttpProxy());
        } else {
            wificonfiguration.proxySettings = wificonfiguration1.proxySettings;
            linkproperties.setHttpProxy(wificonfiguration1.linkProperties.getHttpProxy());
            log((new StringBuilder()).append("proxy changed SSID = ").append(wificonfiguration.SSID).toString());
            if(linkproperties.getHttpProxy() != null)
                log((new StringBuilder()).append(" proxyProperties: ").append(linkproperties.getHttpProxy().toString()).toString());
        }
        if(flag || flag1) {
            wificonfiguration.linkProperties = linkproperties;
            writeIpAndProxyConfigurations();
            sendConfiguredNetworksChangedBroadcast(wificonfiguration, 2);
        }
        networkupdateresult = new NetworkUpdateResult(flag, flag1);
        return networkupdateresult;
_L2:
        collection = wificonfiguration.linkProperties.getLinkAddresses();
        collection1 = wificonfiguration1.linkProperties.getLinkAddresses();
        collection2 = wificonfiguration.linkProperties.getDnses();
        collection3 = wificonfiguration1.linkProperties.getDnses();
        collection4 = wificonfiguration.linkProperties.getRoutes();
        collection5 = wificonfiguration1.linkProperties.getRoutes();
        if(collection.size() != collection1.size() || !collection.containsAll(collection1))
            flag2 = true;
        else
            flag2 = false;
        if(collection2.size() != collection3.size() || !collection2.containsAll(collection3))
            flag3 = true;
        else
            flag3 = false;
        if(collection4.size() != collection5.size() || !collection4.containsAll(collection5))
            flag4 = true;
        else
            flag4 = false;
        if(wificonfiguration.ipAssignment != wificonfiguration1.ipAssignment || flag2 || flag3 || flag4)
            flag = true;
          goto _L4
_L3:
        if(wificonfiguration.ipAssignment != wificonfiguration1.ipAssignment)
            flag = true;
          goto _L4
_L6:
        proxyproperties = wificonfiguration1.linkProperties.getHttpProxy();
        proxyproperties1 = wificonfiguration.linkProperties.getHttpProxy();
        if(proxyproperties != null) {
            if(!proxyproperties.equals(proxyproperties1))
                flag1 = true;
            else
                flag1 = false;
        } else
        if(proxyproperties1 != null)
            flag1 = true;
        else
            flag1 = false;
          goto _L9
_L7:
        if(wificonfiguration.proxySettings != wificonfiguration1.proxySettings)
            flag1 = true;
          goto _L9
    }

    int addOrUpdateNetwork(WifiConfiguration wificonfiguration) {
        NetworkUpdateResult networkupdateresult = addOrUpdateNetworkNative(wificonfiguration);
        if(networkupdateresult.getNetworkId() != -1) {
            WifiConfiguration wificonfiguration1 = (WifiConfiguration)mConfiguredNetworks.get(Integer.valueOf(networkupdateresult.getNetworkId()));
            int i;
            if(networkupdateresult.isNewNetwork)
                i = 0;
            else
                i = 2;
            sendConfiguredNetworksChangedBroadcast(wificonfiguration1, i);
        }
        return networkupdateresult.getNetworkId();
    }

    void clearIpConfiguration(int i) {
        WifiConfiguration wificonfiguration = (WifiConfiguration)mConfiguredNetworks.get(Integer.valueOf(i));
        if(wificonfiguration != null && wificonfiguration.linkProperties != null) {
            ProxyProperties proxyproperties = wificonfiguration.linkProperties.getHttpProxy();
            wificonfiguration.linkProperties.clear();
            wificonfiguration.linkProperties.setHttpProxy(proxyproperties);
        }
    }

    boolean disableNetwork(int i) {
        return disableNetwork(i, 0);
    }

    boolean disableNetwork(int i, int j) {
        boolean flag = mWifiNative.disableNetwork(i);
        WifiConfiguration wificonfiguration = null;
        WifiConfiguration wificonfiguration1 = (WifiConfiguration)mConfiguredNetworks.get(Integer.valueOf(i));
        if(wificonfiguration1 != null && wificonfiguration1.status != 1) {
            wificonfiguration1.status = 1;
            wificonfiguration1.disableReason = j;
            wificonfiguration = wificonfiguration1;
        }
        if(wificonfiguration != null)
            sendConfiguredNetworksChangedBroadcast(wificonfiguration, 2);
        return flag;
    }

    String dump() {
        StringBuffer stringbuffer = new StringBuffer();
        String s = System.getProperty("line.separator");
        stringbuffer.append("mLastPriority ").append(mLastPriority).append(s);
        stringbuffer.append("Configured networks ").append(s);
        for(Iterator iterator = getConfiguredNetworks().iterator(); iterator.hasNext(); stringbuffer.append((WifiConfiguration)iterator.next()).append(s));
        return stringbuffer.toString();
    }

    void enableAllNetworks() {
        boolean flag = false;
        Iterator iterator = mConfiguredNetworks.values().iterator();
        do {
            if(!iterator.hasNext())
                break;
            WifiConfiguration wificonfiguration = (WifiConfiguration)iterator.next();
            if(wificonfiguration != null && wificonfiguration.status == 1)
                if(mWifiNative.enableNetwork(wificonfiguration.networkId, false)) {
                    flag = true;
                    wificonfiguration.status = 2;
                } else {
                    loge((new StringBuilder()).append("Enable network failed on ").append(wificonfiguration.networkId).toString());
                }
        } while(true);
        if(flag) {
            mWifiNative.saveConfig();
            sendConfiguredNetworksChangedBroadcast();
        }
    }

    boolean enableNetwork(int i, boolean flag) {
        boolean flag1 = enableNetworkWithoutBroadcast(i, flag);
        if(!flag) goto _L2; else goto _L1
_L1:
        sendConfiguredNetworksChangedBroadcast();
_L4:
        return flag1;
_L2:
        WifiConfiguration wificonfiguration;
        synchronized(mConfiguredNetworks) {
            wificonfiguration = (WifiConfiguration)mConfiguredNetworks.get(Integer.valueOf(i));
        }
        if(wificonfiguration != null)
            sendConfiguredNetworksChangedBroadcast(wificonfiguration, 2);
        if(true) goto _L4; else goto _L3
_L3:
        exception;
        hashmap;
        JVM INSTR monitorexit ;
        throw exception;
    }

    boolean enableNetworkWithoutBroadcast(int i, boolean flag) {
        boolean flag1 = mWifiNative.enableNetwork(i, flag);
        WifiConfiguration wificonfiguration = (WifiConfiguration)mConfiguredNetworks.get(Integer.valueOf(i));
        if(wificonfiguration != null)
            wificonfiguration.status = 2;
        if(flag)
            markAllNetworksDisabledExcept(i);
        return flag1;
    }

    boolean forgetNetwork(int i) {
        boolean flag = true;
        if(mWifiNative.removeNetwork(i)) {
            mWifiNative.saveConfig();
            WifiConfiguration wificonfiguration = null;
            WifiConfiguration wificonfiguration1 = (WifiConfiguration)mConfiguredNetworks.get(Integer.valueOf(i));
            if(wificonfiguration1 != null) {
                wificonfiguration = (WifiConfiguration)mConfiguredNetworks.remove(Integer.valueOf(i));
                mNetworkIds.remove(Integer.valueOf(configKey(wificonfiguration1)));
            }
            if(wificonfiguration != null) {
                writeIpAndProxyConfigurations();
                sendConfiguredNetworksChangedBroadcast(wificonfiguration, flag);
            }
        } else {
            loge((new StringBuilder()).append("Failed to remove network ").append(i).toString());
            flag = false;
        }
        return flag;
    }

    public String getConfigFile() {
        return ipConfigFile;
    }

    List getConfiguredNetworks() {
        ArrayList arraylist = new ArrayList();
        for(Iterator iterator = mConfiguredNetworks.values().iterator(); iterator.hasNext(); arraylist.add(new WifiConfiguration((WifiConfiguration)iterator.next())));
        return arraylist;
    }

    DhcpInfoInternal getIpConfiguration(int i) {
        DhcpInfoInternal dhcpinfointernal = new DhcpInfoInternal();
        LinkProperties linkproperties = getLinkProperties(i);
        if(linkproperties != null) {
            Iterator iterator = linkproperties.getLinkAddresses().iterator();
            if(iterator.hasNext()) {
                LinkAddress linkaddress = (LinkAddress)iterator.next();
                dhcpinfointernal.ipAddress = linkaddress.getAddress().getHostAddress();
                for(Iterator iterator1 = linkproperties.getRoutes().iterator(); iterator1.hasNext(); dhcpinfointernal.addRoute((RouteInfo)iterator1.next()));
                dhcpinfointernal.prefixLength = linkaddress.getNetworkPrefixLength();
                Iterator iterator2 = linkproperties.getDnses().iterator();
                dhcpinfointernal.dns1 = ((InetAddress)iterator2.next()).getHostAddress();
                if(iterator2.hasNext())
                    dhcpinfointernal.dns2 = ((InetAddress)iterator2.next()).getHostAddress();
            }
        }
        return dhcpinfointernal;
    }

    LinkProperties getLinkProperties(int i) {
        WifiConfiguration wificonfiguration = (WifiConfiguration)mConfiguredNetworks.get(Integer.valueOf(i));
        LinkProperties linkproperties;
        if(wificonfiguration != null)
            linkproperties = new LinkProperties(wificonfiguration.linkProperties);
        else
            linkproperties = null;
        return linkproperties;
    }

    ProxyProperties getProxyProperties(int i) {
        LinkProperties linkproperties = getLinkProperties(i);
        ProxyProperties proxyproperties;
        if(linkproperties != null)
            proxyproperties = new ProxyProperties(linkproperties.getHttpProxy());
        else
            proxyproperties = null;
        return proxyproperties;
    }

    void initialize() {
        loadConfiguredNetworks();
        enableAllNetworks();
    }

    boolean isUsingStaticIp(int i) {
        WifiConfiguration wificonfiguration = (WifiConfiguration)mConfiguredNetworks.get(Integer.valueOf(i));
        boolean flag;
        if(wificonfiguration != null && wificonfiguration.ipAssignment == WifiConfiguration.IpAssignment.STATIC)
            flag = true;
        else
            flag = false;
        return flag;
    }

    void loadConfiguredNetworks() {
        String s;
        s = mWifiNative.listNetworks();
        mLastPriority = 0;
        mConfiguredNetworks.clear();
        mNetworkIds.clear();
        if(s != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String as[] = s.split("\n");
        int i = 1;
label0:
        do {
label1:
            {
                if(i >= as.length)
                    break label0;
                String as1[] = as[i].split("\t");
                WifiConfiguration wificonfiguration = new WifiConfiguration();
                try {
                    wificonfiguration.networkId = Integer.parseInt(as1[0]);
                }
                catch(NumberFormatException numberformatexception) {
                    break label1;
                }
                if(as1.length > 3) {
                    if(as1[3].indexOf("[CURRENT]") != -1)
                        wificonfiguration.status = 0;
                    else
                    if(as1[3].indexOf("[DISABLED]") != -1)
                        wificonfiguration.status = 1;
                    else
                        wificonfiguration.status = 2;
                } else {
                    wificonfiguration.status = 2;
                }
                readNetworkVariables(wificonfiguration);
                if(wificonfiguration.priority > mLastPriority)
                    mLastPriority = wificonfiguration.priority;
                mConfiguredNetworks.put(Integer.valueOf(wificonfiguration.networkId), wificonfiguration);
                mNetworkIds.put(Integer.valueOf(configKey(wificonfiguration)), Integer.valueOf(wificonfiguration.networkId));
            }
            i++;
        } while(true);
        readIpAndProxyConfigurations();
        sendConfiguredNetworksChangedBroadcast();
        if(true) goto _L1; else goto _L3
_L3:
    }

    boolean removeNetwork(int i) {
        boolean flag = mWifiNative.removeNetwork(i);
        WifiConfiguration wificonfiguration = null;
        if(flag) {
            wificonfiguration = (WifiConfiguration)mConfiguredNetworks.get(Integer.valueOf(i));
            if(wificonfiguration != null) {
                wificonfiguration = (WifiConfiguration)mConfiguredNetworks.remove(Integer.valueOf(i));
                mNetworkIds.remove(Integer.valueOf(configKey(wificonfiguration)));
            }
        }
        if(wificonfiguration != null)
            sendConfiguredNetworksChangedBroadcast(wificonfiguration, 1);
        return flag;
    }

    boolean saveConfig() {
        return mWifiNative.saveConfig();
    }

    NetworkUpdateResult saveNetwork(WifiConfiguration wificonfiguration) {
        int i = 0;
        NetworkUpdateResult networkupdateresult;
        if(wificonfiguration == null || wificonfiguration.networkId == -1 && wificonfiguration.SSID == null) {
            networkupdateresult = new NetworkUpdateResult(-1);
        } else {
            boolean flag;
            int j;
            if(wificonfiguration.networkId == -1)
                flag = true;
            else
                flag = false;
            networkupdateresult = addOrUpdateNetworkNative(wificonfiguration);
            j = networkupdateresult.getNetworkId();
            if(flag && j != -1) {
                mWifiNative.enableNetwork(j, false);
                ((WifiConfiguration)mConfiguredNetworks.get(Integer.valueOf(j))).status = 2;
            }
            mWifiNative.saveConfig();
            if(!networkupdateresult.isNewNetwork())
                i = 2;
            sendConfiguredNetworksChangedBroadcast(wificonfiguration, i);
        }
        return networkupdateresult;
    }

    boolean selectNetwork(int i) {
        boolean flag = false;
        if(i != -1) {
            if(mLastPriority == -1 || mLastPriority > 0xf4240) {
                Iterator iterator = mConfiguredNetworks.values().iterator();
                do {
                    if(!iterator.hasNext())
                        break;
                    WifiConfiguration wificonfiguration1 = (WifiConfiguration)iterator.next();
                    if(wificonfiguration1.networkId != -1) {
                        wificonfiguration1.priority = 0;
                        addOrUpdateNetworkNative(wificonfiguration1);
                    }
                } while(true);
                mLastPriority = 0;
            }
            WifiConfiguration wificonfiguration = new WifiConfiguration();
            wificonfiguration.networkId = i;
            int j = 1 + mLastPriority;
            mLastPriority = j;
            wificonfiguration.priority = j;
            addOrUpdateNetworkNative(wificonfiguration);
            mWifiNative.saveConfig();
            enableNetworkWithoutBroadcast(i, true);
            flag = true;
        }
        return flag;
    }

    void setIpConfiguration(int i, DhcpInfoInternal dhcpinfointernal) {
        LinkProperties linkproperties = dhcpinfointernal.makeLinkProperties();
        WifiConfiguration wificonfiguration = (WifiConfiguration)mConfiguredNetworks.get(Integer.valueOf(i));
        if(wificonfiguration != null) {
            if(wificonfiguration.linkProperties != null)
                linkproperties.setHttpProxy(wificonfiguration.linkProperties.getHttpProxy());
            wificonfiguration.linkProperties = linkproperties;
        }
    }

    WpsResult startWpsPbc(WpsInfo wpsinfo) {
        WpsResult wpsresult = new WpsResult();
        if(mWifiNative.startWpsPbc(wpsinfo.BSSID)) {
            markAllNetworksDisabled();
            wpsresult.status = WpsResult.Status.SUCCESS;
        } else {
            loge("Failed to start WPS push button configuration");
            wpsresult.status = WpsResult.Status.FAILURE;
        }
        return wpsresult;
    }

    WpsResult startWpsWithPinFromAccessPoint(WpsInfo wpsinfo) {
        WpsResult wpsresult = new WpsResult();
        if(mWifiNative.startWpsRegistrar(wpsinfo.BSSID, wpsinfo.pin)) {
            markAllNetworksDisabled();
            wpsresult.status = WpsResult.Status.SUCCESS;
        } else {
            loge("Failed to start WPS pin method configuration");
            wpsresult.status = WpsResult.Status.FAILURE;
        }
        return wpsresult;
    }

    WpsResult startWpsWithPinFromDevice(WpsInfo wpsinfo) {
        WpsResult wpsresult = new WpsResult();
        wpsresult.pin = mWifiNative.startWpsPinDisplay(wpsinfo.BSSID);
        if(!TextUtils.isEmpty(wpsresult.pin)) {
            markAllNetworksDisabled();
            wpsresult.status = WpsResult.Status.SUCCESS;
        } else {
            loge("Failed to start WPS pin method configuration");
            wpsresult.status = WpsResult.Status.FAILURE;
        }
        return wpsresult;
    }

    void updateStatus(int i, android.net.NetworkInfo.DetailedState detailedstate) {
        if(i == -1) goto _L2; else goto _L1
_L1:
        WifiConfiguration wificonfiguration = (WifiConfiguration)mConfiguredNetworks.get(Integer.valueOf(i));
        if(wificonfiguration != null) goto _L3; else goto _L2
_L2:
        return;
_L3:
        switch(_cls1..SwitchMap.android.net.NetworkInfo.DetailedState[detailedstate.ordinal()]) {
        case 1: // '\001'
            wificonfiguration.status = 0;
            break;

        case 2: // '\002'
            if(wificonfiguration.status == 0)
                wificonfiguration.status = 2;
            break;
        }
        if(true) goto _L2; else goto _L4
_L4:
    }

    private static final boolean DBG = false;
    private static final String DNS_KEY = "dns";
    private static final String EOS = "eos";
    private static final String EXCLUSION_LIST_KEY = "exclusionList";
    private static final String GATEWAY_KEY = "gateway";
    private static final String ID_KEY = "id";
    private static final int IPCONFIG_FILE_VERSION = 2;
    private static final String IP_ASSIGNMENT_KEY = "ipAssignment";
    private static final String LINK_ADDRESS_KEY = "linkAddress";
    private static final String PROXY_HOST_KEY = "proxyHost";
    private static final String PROXY_PORT_KEY = "proxyPort";
    private static final String PROXY_SETTINGS_KEY = "proxySettings";
    private static final String TAG = "WifiConfigStore";
    private static final String ipConfigFile = (new StringBuilder()).append(Environment.getDataDirectory()).append("/misc/wifi/ipconfig.txt").toString();
    private HashMap mConfiguredNetworks;
    private Context mContext;
    private int mLastPriority;
    private HashMap mNetworkIds;
    private WifiNative mWifiNative;



}
