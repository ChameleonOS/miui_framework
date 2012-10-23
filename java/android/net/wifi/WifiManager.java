// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi;

import android.content.Context;
import android.net.DhcpInfo;
import android.os.*;
import android.util.SparseArray;
import com.android.internal.util.AsyncChannel;
import java.util.List;

// Referenced classes of package android.net.wifi:
//            IWifiManager, WifiConfiguration, WifiInfo, WpsInfo, 
//            WpsResult

public class WifiManager {
    public static class Channel {
        class WifiHandler extends Handler {

            public void handleMessage(Message message) {
                Object obj = removeListener(message.arg2);
                message.what;
                JVM INSTR lookupswitch 14: default 140
            //                           69636: 141
            //                           151554: 175
            //                           151555: 195
            //                           151557: 175
            //                           151558: 195
            //                           151560: 175
            //                           151561: 195
            //                           151563: 211
            //                           151564: 293
            //                           151565: 277
            //                           151567: 175
            //                           151568: 195
            //                           151570: 175
            //                           151571: 195;
                   goto _L1 _L2 _L3 _L4 _L3 _L4 _L3 _L4 _L5 _L6 _L7 _L3 _L4 _L3 _L4
_L1:
                return;
_L2:
                if(mChannelListener != null) {
                    mChannelListener.onChannelDisconnected();
                    mChannelListener = null;
                }
                continue; /* Loop/switch isn't completed */
_L3:
                if(obj != null)
                    ((ActionListener)obj).onFailure(message.arg1);
                continue; /* Loop/switch isn't completed */
_L4:
                if(obj != null)
                    ((ActionListener)obj).onSuccess();
                continue; /* Loop/switch isn't completed */
_L5:
                if(obj == null)
                    continue; /* Loop/switch isn't completed */
                WpsResult wpsresult = (WpsResult)message.obj;
                ((WpsListener)obj).onStartSuccess(wpsresult.pin);
                Object obj1 = mListenerMapLock;
                obj1;
                JVM INSTR monitorenter ;
                mListenerMap.put(message.arg2, obj);
                continue; /* Loop/switch isn't completed */
_L7:
                if(obj != null)
                    ((WpsListener)obj).onCompletion();
                continue; /* Loop/switch isn't completed */
_L6:
                if(obj != null)
                    ((WpsListener)obj).onFailure(message.arg1);
                if(true) goto _L1; else goto _L8
_L8:
            }

            final Channel this$0;

            WifiHandler(Looper looper) {
                this$0 = Channel.this;
                super(looper);
            }
        }


        int putListener(Object obj) {
            if(obj != null) goto _L2; else goto _L1
_L1:
            int i = -1;
_L4:
            return i;
_L2:
            Object obj1 = mListenerMapLock;
            obj1;
            JVM INSTR monitorenter ;
            do {
                i = mListenerKey;
                mListenerKey = i + 1;
            } while(i == -1);
            mListenerMap.put(i, obj);
            if(true) goto _L4; else goto _L3
_L3:
        }

        Object removeListener(int i) {
            if(i != -1) goto _L2; else goto _L1
_L1:
            Object obj1 = null;
_L4:
            return obj1;
_L2:
            Object obj = mListenerMapLock;
            obj;
            JVM INSTR monitorenter ;
            obj1 = mListenerMap.get(i);
            mListenerMap.remove(i);
            if(true) goto _L4; else goto _L3
_L3:
        }

        private static final int INVALID_KEY = -1;
        AsyncChannel mAsyncChannel;
        private ChannelListener mChannelListener;
        WifiHandler mHandler;
        private int mListenerKey;
        private SparseArray mListenerMap;
        private Object mListenerMapLock;



/*
        static ChannelListener access$002(Channel channel, ChannelListener channellistener) {
            channel.mChannelListener = channellistener;
            return channellistener;
        }

*/



        Channel(Looper looper, ChannelListener channellistener) {
            mListenerMap = new SparseArray();
            mListenerMapLock = new Object();
            mListenerKey = 0;
            mAsyncChannel = new AsyncChannel();
            mHandler = new WifiHandler(looper);
            mChannelListener = channellistener;
        }
    }

    public static interface WpsListener {

        public abstract void onCompletion();

        public abstract void onFailure(int i);

        public abstract void onStartSuccess(String s);
    }

    public static interface ActionListener {

        public abstract void onFailure(int i);

        public abstract void onSuccess();
    }

    public static interface ChannelListener {

        public abstract void onChannelDisconnected();
    }


    public WifiManager(IWifiManager iwifimanager, Handler handler) {
        mService = iwifimanager;
        mHandler = handler;
    }

    private int addOrUpdateNetwork(WifiConfiguration wificonfiguration) {
        int j = mService.addOrUpdateNetwork(wificonfiguration);
        int i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        i = -1;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static int calculateSignalLevel(int i, int j) {
        int k;
        if(i <= -100)
            k = 0;
        else
        if(i >= -55)
            k = j - 1;
        else
            k = (int)(((float)(j - 1) * (float)(i + 100)) / 45F);
        return k;
    }

    public static int compareSignalLevel(int i, int j) {
        return i - j;
    }

    public int addNetwork(WifiConfiguration wificonfiguration) {
        int i = -1;
        if(wificonfiguration != null) {
            wificonfiguration.networkId = i;
            i = addOrUpdateNetwork(wificonfiguration);
        }
        return i;
    }

    public boolean addToBlacklist(String s) {
        mService.addToBlacklist(s);
        boolean flag = true;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void cancelWps(Channel channel, ActionListener actionlistener) {
        if(channel == null) {
            throw new IllegalArgumentException("Channel needs to be initialized");
        } else {
            channel.mAsyncChannel.sendMessage(0x2500e, 0, channel.putListener(actionlistener));
            return;
        }
    }

    public boolean clearBlacklist() {
        mService.clearBlacklist();
        boolean flag = true;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void connect(Channel channel, int i, ActionListener actionlistener) {
        if(channel == null)
            throw new IllegalArgumentException("Channel needs to be initialized");
        if(i < 0) {
            throw new IllegalArgumentException("Network id cannot be negative");
        } else {
            channel.mAsyncChannel.sendMessage(0x25001, i, channel.putListener(actionlistener));
            return;
        }
    }

    public void connect(Channel channel, WifiConfiguration wificonfiguration, ActionListener actionlistener) {
        if(channel == null)
            throw new IllegalArgumentException("Channel needs to be initialized");
        if(wificonfiguration == null) {
            throw new IllegalArgumentException("config cannot be null");
        } else {
            channel.mAsyncChannel.sendMessage(0x25001, -1, channel.putListener(actionlistener), wificonfiguration);
            return;
        }
    }

    public MulticastLock createMulticastLock(String s) {
        return new MulticastLock(s);
    }

    public WifiLock createWifiLock(int i, String s) {
        return new WifiLock(i, s);
    }

    public WifiLock createWifiLock(String s) {
        return new WifiLock(1, s);
    }

    public void disable(Channel channel, int i, ActionListener actionlistener) {
        if(channel == null)
            throw new IllegalArgumentException("Channel needs to be initialized");
        if(i < 0) {
            throw new IllegalArgumentException("Network id cannot be negative");
        } else {
            channel.mAsyncChannel.sendMessage(0x25011, i, channel.putListener(actionlistener));
            return;
        }
    }

    public boolean disableNetwork(int i) {
        boolean flag1 = mService.disableNetwork(i);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean disconnect() {
        mService.disconnect();
        boolean flag = true;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean enableNetwork(int i, boolean flag) {
        boolean flag2 = mService.enableNetwork(i, flag);
        boolean flag1 = flag2;
_L2:
        return flag1;
        RemoteException remoteexception;
        remoteexception;
        flag1 = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void forget(Channel channel, int i, ActionListener actionlistener) {
        if(channel == null)
            throw new IllegalArgumentException("Channel needs to be initialized");
        if(i < 0) {
            throw new IllegalArgumentException("Network id cannot be negative");
        } else {
            channel.mAsyncChannel.sendMessage(0x25004, i, channel.putListener(actionlistener));
            return;
        }
    }

    public String getConfigFile() {
        String s1 = mService.getConfigFile();
        String s = s1;
_L2:
        return s;
        RemoteException remoteexception;
        remoteexception;
        s = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public List getConfiguredNetworks() {
        List list1 = mService.getConfiguredNetworks();
        List list = list1;
_L2:
        return list;
        RemoteException remoteexception;
        remoteexception;
        list = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public WifiInfo getConnectionInfo() {
        WifiInfo wifiinfo1 = mService.getConnectionInfo();
        WifiInfo wifiinfo = wifiinfo1;
_L2:
        return wifiinfo;
        RemoteException remoteexception;
        remoteexception;
        wifiinfo = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public DhcpInfo getDhcpInfo() {
        DhcpInfo dhcpinfo1 = mService.getDhcpInfo();
        DhcpInfo dhcpinfo = dhcpinfo1;
_L2:
        return dhcpinfo;
        RemoteException remoteexception;
        remoteexception;
        dhcpinfo = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int getFrequencyBand() {
        int j = mService.getFrequencyBand();
        int i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        i = -1;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public List getScanResults() {
        List list1 = mService.getScanResults();
        List list = list1;
_L2:
        return list;
        RemoteException remoteexception;
        remoteexception;
        list = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public WifiConfiguration getWifiApConfiguration() {
        WifiConfiguration wificonfiguration1 = mService.getWifiApConfiguration();
        WifiConfiguration wificonfiguration = wificonfiguration1;
_L2:
        return wificonfiguration;
        RemoteException remoteexception;
        remoteexception;
        wificonfiguration = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int getWifiApState() {
        int j = mService.getWifiApEnabledState();
        int i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        i = 14;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public Messenger getWifiServiceMessenger() {
        Messenger messenger1 = mService.getWifiServiceMessenger();
        Messenger messenger = messenger1;
_L2:
        return messenger;
        RemoteException remoteexception;
        remoteexception;
        messenger = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int getWifiState() {
        int j = mService.getWifiEnabledState();
        int i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        i = 4;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public Messenger getWifiStateMachineMessenger() {
        Messenger messenger1 = mService.getWifiStateMachineMessenger();
        Messenger messenger = messenger1;
_L2:
        return messenger;
        RemoteException remoteexception;
        remoteexception;
        messenger = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public Channel initialize(Context context, Looper looper, ChannelListener channellistener) {
        Messenger messenger = getWifiServiceMessenger();
        if(messenger != null) goto _L2; else goto _L1
_L1:
        Channel channel = null;
_L4:
        return channel;
_L2:
        channel = new Channel(looper, channellistener);
        if(channel.mAsyncChannel.connectSync(context, channel.mHandler, messenger) != 0)
            channel = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean initializeMulticastFiltering() {
        mService.initializeMulticastFiltering();
        boolean flag = true;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean isDualBandSupported() {
        boolean flag1 = mService.isDualBandSupported();
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean isMulticastEnabled() {
        boolean flag1 = mService.isMulticastEnabled();
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean isWifiApEnabled() {
        boolean flag;
        if(getWifiApState() == 13)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isWifiEnabled() {
        boolean flag;
        if(getWifiState() == 3)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean pingSupplicant() {
        boolean flag = false;
        if(mService != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        boolean flag1 = mService.pingSupplicant();
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean reassociate() {
        mService.reassociate();
        boolean flag = true;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean reconnect() {
        mService.reconnect();
        boolean flag = true;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean removeNetwork(int i) {
        boolean flag1 = mService.removeNetwork(i);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void save(Channel channel, WifiConfiguration wificonfiguration, ActionListener actionlistener) {
        if(channel == null)
            throw new IllegalArgumentException("Channel needs to be initialized");
        if(wificonfiguration == null) {
            throw new IllegalArgumentException("config cannot be null");
        } else {
            channel.mAsyncChannel.sendMessage(0x25007, 0, channel.putListener(actionlistener), wificonfiguration);
            return;
        }
    }

    public boolean saveConfiguration() {
        boolean flag1 = mService.saveConfiguration();
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void setCountryCode(String s, boolean flag) {
        mService.setCountryCode(s, flag);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void setFrequencyBand(int i, boolean flag) {
        mService.setFrequencyBand(i, flag);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean setWifiApConfiguration(WifiConfiguration wificonfiguration) {
        mService.setWifiApConfiguration(wificonfiguration);
        boolean flag = true;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean setWifiApEnabled(WifiConfiguration wificonfiguration, boolean flag) {
        mService.setWifiApEnabled(wificonfiguration, flag);
        boolean flag1 = true;
_L2:
        return flag1;
        RemoteException remoteexception;
        remoteexception;
        flag1 = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean setWifiEnabled(boolean flag) {
        boolean flag2 = mService.setWifiEnabled(flag);
        boolean flag1 = flag2;
_L2:
        return flag1;
        RemoteException remoteexception;
        remoteexception;
        flag1 = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean startScan() {
        boolean flag = false;
        mService.startScan(false);
        flag = true;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean startScanActive() {
        boolean flag = true;
        try {
            mService.startScan(true);
        }
        catch(RemoteException remoteexception) {
            flag = false;
        }
        return flag;
    }

    public boolean startWifi() {
        mService.startWifi();
        boolean flag = true;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void startWps(Channel channel, WpsInfo wpsinfo, WpsListener wpslistener) {
        if(channel == null)
            throw new IllegalArgumentException("Channel needs to be initialized");
        if(wpsinfo == null) {
            throw new IllegalArgumentException("config cannot be null");
        } else {
            channel.mAsyncChannel.sendMessage(0x2500a, 0, channel.putListener(wpslistener), wpsinfo);
            return;
        }
    }

    public boolean stopWifi() {
        mService.stopWifi();
        boolean flag = true;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int updateNetwork(WifiConfiguration wificonfiguration) {
        int i;
        if(wificonfiguration == null || wificonfiguration.networkId < 0)
            i = -1;
        else
            i = addOrUpdateNetwork(wificonfiguration);
        return i;
    }

    public static final String ACTION_PICK_WIFI_NETWORK = "android.net.wifi.PICK_WIFI_NETWORK";
    private static final int BASE = 0x25000;
    public static final int BUSY = 2;
    public static final int CANCEL_WPS = 0x2500e;
    public static final int CANCEL_WPS_FAILED = 0x2500f;
    public static final int CANCEL_WPS_SUCCEDED = 0x25010;
    public static final int CHANGE_REASON_ADDED = 0;
    public static final int CHANGE_REASON_CONFIG_CHANGE = 2;
    public static final int CHANGE_REASON_REMOVED = 1;
    public static final String CONFIGURED_NETWORKS_CHANGED_ACTION = "android.net.wifi.CONFIGURED_NETWORKS_CHANGE";
    public static final int CONNECT_NETWORK = 0x25001;
    public static final int CONNECT_NETWORK_FAILED = 0x25002;
    public static final int CONNECT_NETWORK_SUCCEEDED = 0x25003;
    public static final int DATA_ACTIVITY_IN = 1;
    public static final int DATA_ACTIVITY_INOUT = 3;
    public static final int DATA_ACTIVITY_NONE = 0;
    public static final int DATA_ACTIVITY_NOTIFICATION = 1;
    public static final int DATA_ACTIVITY_OUT = 2;
    public static final int DISABLE_NETWORK = 0x25011;
    public static final int DISABLE_NETWORK_FAILED = 0x25012;
    public static final int DISABLE_NETWORK_SUCCEEDED = 0x25013;
    public static final int ENABLE_TRAFFIC_STATS_POLL = 0x25015;
    public static final int ERROR = 0;
    public static final int ERROR_AUTHENTICATING = 1;
    public static final String EXTRA_BSSID = "bssid";
    public static final String EXTRA_CHANGE_REASON = "changeReason";
    public static final String EXTRA_LINK_CAPABILITIES = "linkCapabilities";
    public static final String EXTRA_LINK_PROPERTIES = "linkProperties";
    public static final String EXTRA_MULTIPLE_NETWORKS_CHANGED = "multipleChanges";
    public static final String EXTRA_NETWORK_INFO = "networkInfo";
    public static final String EXTRA_NEW_RSSI = "newRssi";
    public static final String EXTRA_NEW_STATE = "newState";
    public static final String EXTRA_PREVIOUS_WIFI_AP_STATE = "previous_wifi_state";
    public static final String EXTRA_PREVIOUS_WIFI_STATE = "previous_wifi_state";
    public static final String EXTRA_SUPPLICANT_CONNECTED = "connected";
    public static final String EXTRA_SUPPLICANT_ERROR = "supplicantError";
    public static final String EXTRA_WIFI_AP_STATE = "wifi_state";
    public static final String EXTRA_WIFI_CONFIGURATION = "wifiConfiguration";
    public static final String EXTRA_WIFI_INFO = "wifiInfo";
    public static final String EXTRA_WIFI_STATE = "wifi_state";
    public static final int FORGET_NETWORK = 0x25004;
    public static final int FORGET_NETWORK_FAILED = 0x25005;
    public static final int FORGET_NETWORK_SUCCEEDED = 0x25006;
    public static final int IN_PROGRESS = 1;
    public static final String LINK_CONFIGURATION_CHANGED_ACTION = "android.net.wifi.LINK_CONFIGURATION_CHANGED";
    private static final int MAX_ACTIVE_LOCKS = 50;
    private static final int MAX_RSSI = -55;
    private static final int MIN_RSSI = -100;
    public static final String NETWORK_IDS_CHANGED_ACTION = "android.net.wifi.NETWORK_IDS_CHANGED";
    public static final String NETWORK_STATE_CHANGED_ACTION = "android.net.wifi.STATE_CHANGE";
    public static final String RSSI_CHANGED_ACTION = "android.net.wifi.RSSI_CHANGED";
    public static final int RSSI_LEVELS = 5;
    public static final int SAVE_NETWORK = 0x25007;
    public static final int SAVE_NETWORK_FAILED = 0x25008;
    public static final int SAVE_NETWORK_SUCCEEDED = 0x25009;
    public static final String SCAN_RESULTS_AVAILABLE_ACTION = "android.net.wifi.SCAN_RESULTS";
    public static final int START_WPS = 0x2500a;
    public static final int START_WPS_SUCCEEDED = 0x2500b;
    public static final String SUPPLICANT_CONNECTION_CHANGE_ACTION = "android.net.wifi.supplicant.CONNECTION_CHANGE";
    public static final String SUPPLICANT_STATE_CHANGED_ACTION = "android.net.wifi.supplicant.STATE_CHANGE";
    public static final int TRAFFIC_STATS_POLL = 0x25016;
    public static final String WIFI_AP_STATE_CHANGED_ACTION = "android.net.wifi.WIFI_AP_STATE_CHANGED";
    public static final int WIFI_AP_STATE_DISABLED = 11;
    public static final int WIFI_AP_STATE_DISABLING = 10;
    public static final int WIFI_AP_STATE_ENABLED = 13;
    public static final int WIFI_AP_STATE_ENABLING = 12;
    public static final int WIFI_AP_STATE_FAILED = 14;
    public static final int WIFI_FREQUENCY_BAND_2GHZ = 2;
    public static final int WIFI_FREQUENCY_BAND_5GHZ = 1;
    public static final int WIFI_FREQUENCY_BAND_AUTO = 0;
    public static final int WIFI_MODE_FULL = 1;
    public static final int WIFI_MODE_FULL_HIGH_PERF = 3;
    public static final int WIFI_MODE_SCAN_ONLY = 2;
    public static final String WIFI_STATE_CHANGED_ACTION = "android.net.wifi.WIFI_STATE_CHANGED";
    public static final int WIFI_STATE_DISABLED = 1;
    public static final int WIFI_STATE_DISABLING = 0;
    public static final int WIFI_STATE_ENABLED = 3;
    public static final int WIFI_STATE_ENABLING = 2;
    public static final int WIFI_STATE_UNKNOWN = 4;
    public static final int WPS_AUTH_FAILURE = 6;
    public static final int WPS_COMPLETED = 0x2500d;
    public static final int WPS_FAILED = 0x2500c;
    public static final int WPS_OVERLAP_ERROR = 3;
    public static final int WPS_TIMED_OUT = 7;
    public static final int WPS_TKIP_ONLY_PROHIBITED = 5;
    public static final int WPS_WEP_PROHIBITED = 4;
    private int mActiveLockCount;
    Handler mHandler;
    IWifiManager mService;



/*
    static int access$308(WifiManager wifimanager) {
        int i = wifimanager.mActiveLockCount;
        wifimanager.mActiveLockCount = i + 1;
        return i;
    }

*/


/*
    static int access$310(WifiManager wifimanager) {
        int i = wifimanager.mActiveLockCount;
        wifimanager.mActiveLockCount = i - 1;
        return i;
    }

*/
}
