// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi;

import android.app.*;
import android.content.*;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.net.*;
import android.net.arp.ArpPeer;
import android.os.*;
import android.util.Log;
import com.android.internal.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package android.net.wifi:
//            WifiManager, WifiInfo

public class WifiWatchdogStateMachine extends StateMachine {
    class OnlineState extends State {

        public void enter() {
            if(WifiWatchdogStateMachine.DBG)
                WifiWatchdogStateMachine.log((new StringBuilder()).append(getName()).append("\n").toString());
        }

        final WifiWatchdogStateMachine this$0;

        OnlineState() {
            this$0 = WifiWatchdogStateMachine.this;
            super();
        }
    }

    class OnlineWatchState extends State {

        private void handleRssiChange() {
            if(mCurrentSignalLevel <= 0)
                transitionTo(mRssiMonitoringState);
        }

        public void enter() {
            if(WifiWatchdogStateMachine.DBG)
                WifiWatchdogStateMachine.log((new StringBuilder()).append(getName()).append("\n").toString());
            if(mPoorNetworkDetectionEnabled)
                handleRssiChange();
            else
                transitionTo(mOnlineState);
        }

        public boolean processMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 135171 135171: default 24
        //                       135171 30;
               goto _L1 _L2
_L1:
            boolean flag = false;
_L4:
            return flag;
_L2:
            long l;
            mCurrentSignalLevel = calculateSignalLevel(message.arg1);
            l = SystemClock.elapsedRealtime();
            if(l - mLastBssidAvoidedTime <= (long)WifiWatchdogStateMachine.MIN_INTERVAL_AVOID_BSSID_MS[mMinIntervalArrayIndex])
                break; /* Loop/switch isn't completed */
            handleRssiChange();
_L6:
            flag = true;
            if(true) goto _L4; else goto _L3
_L3:
            if(!WifiWatchdogStateMachine.DBG) goto _L6; else goto _L5
_L5:
            WifiWatchdogStateMachine.log((new StringBuilder()).append("Early to avoid ").append(mWifiInfo).append(" time: ").append(l).append(" last avoided: ").append(mLastBssidAvoidedTime).append(" mMinIntervalArrayIndex: ").append(mMinIntervalArrayIndex).toString());
              goto _L6
        }

        final WifiWatchdogStateMachine this$0;

        OnlineWatchState() {
            this$0 = WifiWatchdogStateMachine.this;
            super();
        }
    }

    class WalledGardenCheckState extends State {

        public void enter() {
            if(WifiWatchdogStateMachine.DBG)
                WifiWatchdogStateMachine.log((new StringBuilder()).append(getName()).append("\n").toString());
            WifiWatchdogStateMachine wifiwatchdogstatemachine = WifiWatchdogStateMachine.this;
            WifiWatchdogStateMachine wifiwatchdogstatemachine1 = WifiWatchdogStateMachine.this;
            int i = 1 + mWalledGardenToken;
            mWalledGardenToken = i;
            wifiwatchdogstatemachine.sendMessageDelayed(wifiwatchdogstatemachine1.obtainMessage(0x2100c, i, 0), 3000L);
        }

        public boolean processMessage(Message message) {
            boolean flag = true;
            message.what;
            JVM INSTR tableswitch 135180 135180: default 24
        //                       135180 28;
               goto _L1 _L2
_L1:
            flag = false;
_L4:
            return flag;
_L2:
            if(message.arg1 == mWalledGardenToken) {
                mLastWalledGardenCheckTime = SystemClock.elapsedRealtime();
                if(isWalledGardenConnection()) {
                    if(WifiWatchdogStateMachine.DBG)
                        WifiWatchdogStateMachine.log("Walled garden detected");
                    setWalledGardenNotificationVisible(flag);
                }
                transitionTo(mOnlineWatchState);
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        private int mWalledGardenToken;
        final WifiWatchdogStateMachine this$0;

        WalledGardenCheckState() {
            this$0 = WifiWatchdogStateMachine.this;
            super();
            mWalledGardenToken = 0;
        }
    }

    class ConnectedState extends State {

        public void enter() {
            if(WifiWatchdogStateMachine.DBG)
                WifiWatchdogStateMachine.log((new StringBuilder()).append(getName()).append("\n").toString());
        }

        public boolean processMessage(Message message) {
            boolean flag = true;
            message.what;
            JVM INSTR tableswitch 135174 135174: default 24
        //                       135174 28;
               goto _L1 _L2
_L1:
            flag = false;
_L4:
            return flag;
_L2:
            updateSettings();
            WifiWatchdogStateMachine.DBG = flag;
            if(WifiWatchdogStateMachine.DBG)
                WifiWatchdogStateMachine.log("Updated secure settings and turned debug on");
            if(mPoorNetworkDetectionEnabled)
                transitionTo(mOnlineWatchState);
            else
                transitionTo(mOnlineState);
            if(true) goto _L4; else goto _L3
_L3:
        }

        final WifiWatchdogStateMachine this$0;

        ConnectedState() {
            this$0 = WifiWatchdogStateMachine.this;
            super();
        }
    }

    class NotConnectedState extends State {

        public void enter() {
            if(WifiWatchdogStateMachine.DBG)
                WifiWatchdogStateMachine.log((new StringBuilder()).append(getName()).append("\n").toString());
        }

        final WifiWatchdogStateMachine this$0;

        NotConnectedState() {
            this$0 = WifiWatchdogStateMachine.this;
            super();
        }
    }

    class WatchdogEnabledState extends State {

        public void enter() {
            if(WifiWatchdogStateMachine.DBG)
                WifiWatchdogStateMachine.log("WifiWatchdogService enabled");
        }

        public void exit() {
            if(WifiWatchdogStateMachine.DBG)
                WifiWatchdogStateMachine.log("WifiWatchdogService disabled");
        }

        public boolean processMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 135169 135173: default 40
        //                       135169 44
        //                       135170 81
        //                       135171 40
        //                       135172 40
        //                       135173 335;
               goto _L1 _L2 _L3 _L1 _L1 _L4
_L4:
            break MISSING_BLOCK_LABEL_335;
_L1:
            boolean flag = false;
_L5:
            return flag;
_L2:
            if(!isWatchdogEnabled())
                transitionTo(mWatchdogDisabledState);
_L7:
            setWalledGardenNotificationVisible(false);
            flag = true;
            if(true) goto _L5; else goto _L3
_L3:
            Intent intent = (Intent)message.obj;
            NetworkInfo networkinfo = (NetworkInfo)intent.getParcelableExtra("networkInfo");
            if(WifiWatchdogStateMachine.DBG)
                WifiWatchdogStateMachine.log((new StringBuilder()).append("network state change ").append(networkinfo.getDetailedState()).toString());
            class _cls4 {

                static final int $SwitchMap$android$net$NetworkInfo$DetailedState[];

                static  {
                    $SwitchMap$android$net$NetworkInfo$DetailedState = new int[android.net.NetworkInfo.DetailedState.values().length];
                    NoSuchFieldError nosuchfielderror1;
                    try {
                        $SwitchMap$android$net$NetworkInfo$DetailedState[android.net.NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal()] = 1;
                    }
                    catch(NoSuchFieldError nosuchfielderror) { }
                    $SwitchMap$android$net$NetworkInfo$DetailedState[android.net.NetworkInfo.DetailedState.CONNECTED.ordinal()] = 2;
_L2:
                    return;
                    nosuchfielderror1;
                    if(true) goto _L2; else goto _L1
_L1:
                }
            }

            switch(_cls4..SwitchMap.android.net.NetworkInfo.DetailedState[networkinfo.getDetailedState().ordinal()]) {
            default:
                transitionTo(mNotConnectedState);
                break;

            case 1: // '\001'
                mLinkProperties = (LinkProperties)intent.getParcelableExtra("linkProperties");
                mWifiInfo = (WifiInfo)intent.getParcelableExtra("wifiInfo");
                if(mPoorNetworkDetectionEnabled) {
                    if(mWifiInfo == null) {
                        WifiWatchdogStateMachine.log("Ignoring link verification, mWifiInfo is NULL");
                        mWsmChannel.sendMessage(0x21016);
                    } else {
                        transitionTo(mVerifyingLinkState);
                    }
                } else {
                    mWsmChannel.sendMessage(0x21016);
                }
                break;

            case 2: // '\002'
                if(shouldCheckWalledGarden())
                    transitionTo(mWalledGardenCheckState);
                else
                    transitionTo(mOnlineWatchState);
                break;
            }
            if(true) goto _L7; else goto _L6
_L6:
            if(((Integer)message.obj).intValue() == 0) {
                if(WifiWatchdogStateMachine.DBG)
                    WifiWatchdogStateMachine.log("WifiStateDisabling -- Resetting WatchdogState");
                transitionTo(mNotConnectedState);
            }
              goto _L7
        }

        final WifiWatchdogStateMachine this$0;

        WatchdogEnabledState() {
            this$0 = WifiWatchdogStateMachine.this;
            super();
        }
    }

    class WatchdogDisabledState extends State {

        public void enter() {
            if(WifiWatchdogStateMachine.DBG)
                WifiWatchdogStateMachine.log((new StringBuilder()).append(getName()).append("\n").toString());
        }

        public boolean processMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 135169 135170: default 28
        //                       135169 32
        //                       135170 61;
               goto _L1 _L2 _L3
_L1:
            boolean flag = false;
_L4:
            return flag;
_L2:
            if(isWatchdogEnabled())
                transitionTo(mNotConnectedState);
            flag = true;
            if(true) goto _L4; else goto _L3
_L3:
            NetworkInfo networkinfo = (NetworkInfo)((Intent)message.obj).getParcelableExtra("networkInfo");
            switch(_cls4..SwitchMap.android.net.NetworkInfo.DetailedState[networkinfo.getDetailedState().ordinal()]) {
            case 1: // '\001'
                if(WifiWatchdogStateMachine.DBG)
                    WifiWatchdogStateMachine.log("Watchdog disabled, verify link");
                mWsmChannel.sendMessage(0x21016);
                break;
            }
            if(true) goto _L1; else goto _L5
_L5:
        }

        final WifiWatchdogStateMachine this$0;

        WatchdogDisabledState() {
            this$0 = WifiWatchdogStateMachine.this;
            super();
        }
    }

    class DefaultState extends State {

        public void enter() {
            if(WifiWatchdogStateMachine.DBG)
                WifiWatchdogStateMachine.log((new StringBuilder()).append(getName()).append("\n").toString());
        }

        public boolean processMessage(Message message) {
            message.what;
            JVM INSTR lookupswitch 9: default 88
        //                       135170: 130
        //                       135171: 153
        //                       135173: 130
        //                       135174: 132
        //                       135179: 130
        //                       135180: 130
        //                       135181: 130
        //                       135192: 130
        //                       135193: 130;
               goto _L1 _L2 _L3 _L2 _L4 _L2 _L2 _L2 _L2 _L2
_L2:
            break; /* Loop/switch isn't completed */
_L1:
            WifiWatchdogStateMachine.log((new StringBuilder()).append("Unhandled message ").append(message).append(" in state ").append(getCurrentState().getName()).toString());
_L6:
            return true;
_L4:
            updateSettings();
            if(WifiWatchdogStateMachine.DBG)
                WifiWatchdogStateMachine.log("Updating wifi-watchdog secure settings");
            continue; /* Loop/switch isn't completed */
_L3:
            mCurrentSignalLevel = calculateSignalLevel(message.arg1);
            if(true) goto _L6; else goto _L5
_L5:
        }

        final WifiWatchdogStateMachine this$0;

        DefaultState() {
            this$0 = WifiWatchdogStateMachine.this;
            super();
        }
    }


    private WifiWatchdogStateMachine(Context context) {
        super("WifiWatchdogStateMachine");
        mRssiMonitorCount = 0;
        mMinIntervalArrayIndex = 0;
        mWsmChannel = new AsyncChannel();
        mDefaultState = new DefaultState();
        mWatchdogDisabledState = new WatchdogDisabledState();
        mWatchdogEnabledState = new WatchdogEnabledState();
        mNotConnectedState = new NotConnectedState();
        mVerifyingLinkState = new VerifyingLinkState();
        mConnectedState = new ConnectedState();
        mWalledGardenCheckState = new WalledGardenCheckState();
        mOnlineWatchState = new OnlineWatchState();
        mRssiMonitoringState = new RssiMonitoringState();
        mOnlineState = new OnlineState();
        mArpToken = 0;
        mRssiFetchToken = 0;
        mLastWalledGardenCheckTime = 0L;
        mContext = context;
        mContentResolver = context.getContentResolver();
        mWifiManager = (WifiManager)context.getSystemService("wifi");
        mWsmChannel.connectSync(mContext, getHandler(), mWifiManager.getWifiStateMachineMessenger());
        setupNetworkReceiver();
        registerForSettingsChanges();
        registerForWatchdogToggle();
        addState(mDefaultState);
        addState(mWatchdogDisabledState, mDefaultState);
        addState(mWatchdogEnabledState, mDefaultState);
        addState(mNotConnectedState, mWatchdogEnabledState);
        addState(mVerifyingLinkState, mWatchdogEnabledState);
        addState(mConnectedState, mWatchdogEnabledState);
        addState(mWalledGardenCheckState, mConnectedState);
        addState(mOnlineWatchState, mConnectedState);
        addState(mRssiMonitoringState, mOnlineWatchState);
        addState(mOnlineState, mConnectedState);
        if(isWatchdogEnabled())
            setInitialState(mNotConnectedState);
        else
            setInitialState(mWatchdogDisabledState);
        updateSettings();
    }

    private int calculateSignalLevel(int i) {
        int j = WifiManager.calculateSignalLevel(i, 5);
        if(DBG)
            log((new StringBuilder()).append("RSSI current: ").append(mCurrentSignalLevel).append("new: ").append(i).append(", ").append(j).toString());
        return j;
    }

    private boolean doArpTest(int i) {
        String s;
        String s1;
        java.net.InetAddress inetaddress;
        java.net.InetAddress inetaddress1;
        s = mLinkProperties.getInterfaceName();
        s1 = mWifiInfo.getMacAddress();
        inetaddress = null;
        inetaddress1 = null;
        Iterator iterator = mLinkProperties.getLinkAddresses().iterator();
        if(iterator.hasNext())
            inetaddress = ((LinkAddress)iterator.next()).getAddress();
        Iterator iterator1 = mLinkProperties.getRoutes().iterator();
        if(iterator1.hasNext())
            inetaddress1 = ((RouteInfo)iterator1.next()).getGateway();
        if(DBG)
            log((new StringBuilder()).append("ARP ").append(s).append("addr: ").append(inetaddress).append("mac: ").append(s1).append("gw: ").append(inetaddress1).toString());
        ArpPeer arppeer;
        boolean flag;
        arppeer = new ArpPeer(s, inetaddress, s1, inetaddress1);
        if(i != 0)
            break MISSING_BLOCK_LABEL_374;
        if(arppeer.doArp(mArpPingTimeoutMs) == null)
            break MISSING_BLOCK_LABEL_368;
        flag = true;
_L3:
        if(DBG)
            log((new StringBuilder()).append("single ARP test result: ").append(flag).toString());
_L2:
        arppeer.close();
          goto _L1
        j = 0;
        k = 0;
        IllegalArgumentException illegalargumentexception;
        SocketException socketexception;
        int j;
        int k;
        int l;
        for(; k < mNumArpPings; k++) {
            if(arppeer.doArp(mArpPingTimeoutMs) != null)
                j++;
            break MISSING_BLOCK_LABEL_383;
        }

        if(DBG)
            log((new StringBuilder()).append("full ARP test result: ").append(j).append("/").append(mNumArpPings).toString());
        l = mMinArpResponses;
        if(j >= l)
            flag = true;
        else
            flag = false;
          goto _L2
        socketexception;
        loge((new StringBuilder()).append("ARP test initiation failure: ").append(socketexception).toString());
        flag = true;
          goto _L1
        illegalargumentexception;
        flag = true;
_L1:
        return flag;
        flag = false;
          goto _L3
    }

    private static boolean getSettingsBoolean(ContentResolver contentresolver, String s, boolean flag) {
        boolean flag1 = true;
        int i;
        if(flag)
            i = ((flag1) ? 1 : 0);
        else
            i = 0;
        if(android.provider.Settings.Secure.getInt(contentresolver, s, i) != flag1)
            flag1 = false;
        return flag1;
    }

    private static String getSettingsStr(ContentResolver contentresolver, String s, String s1) {
        String s2 = android.provider.Settings.Secure.getString(contentresolver, s);
        if(s2 == null)
            s2 = s1;
        return s2;
    }

    private boolean isWalledGardenConnection() {
        HttpURLConnection httpurlconnection = null;
        int i;
        httpurlconnection = (HttpURLConnection)(new URL(mWalledGardenUrl)).openConnection();
        httpurlconnection.setInstanceFollowRedirects(false);
        httpurlconnection.setConnectTimeout(10000);
        httpurlconnection.setReadTimeout(10000);
        httpurlconnection.setUseCaches(false);
        httpurlconnection.getInputStream();
        i = httpurlconnection.getResponseCode();
        boolean flag;
        if(i != 204)
            flag = true;
        else
            flag = false;
        if(httpurlconnection != null)
            httpurlconnection.disconnect();
_L2:
        return flag;
        IOException ioexception;
        ioexception;
        if(DBG)
            log((new StringBuilder()).append("Walled garden check - probably not a portal: exception ").append(ioexception).toString());
        if(httpurlconnection != null)
            httpurlconnection.disconnect();
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        if(httpurlconnection != null)
            httpurlconnection.disconnect();
        throw exception;
    }

    private boolean isWatchdogEnabled() {
        boolean flag = getSettingsBoolean(mContentResolver, "wifi_watchdog_on", true);
        if(DBG)
            log((new StringBuilder()).append("watchdog enabled ").append(flag).toString());
        return flag;
    }

    private static void log(String s) {
        Log.d("WifiWatchdogStateMachine", s);
    }

    private static void loge(String s) {
        Log.e("WifiWatchdogStateMachine", s);
    }

    public static WifiWatchdogStateMachine makeWifiWatchdogStateMachine(Context context) {
        ContentResolver contentresolver = context.getContentResolver();
        boolean flag;
        WifiWatchdogStateMachine wifiwatchdogstatemachine;
        if(!((ConnectivityManager)context.getSystemService("connectivity")).isNetworkSupported(0))
            flag = true;
        else
            flag = false;
        sWifiOnly = flag;
        putSettingsBoolean(contentresolver, "wifi_watchdog_on", true);
        if(sWifiOnly) {
            log("Disabling poor network avoidance for wi-fi only device");
            putSettingsBoolean(contentresolver, "wifi_watchdog_poor_network_test_enabled", false);
        }
        wifiwatchdogstatemachine = new WifiWatchdogStateMachine(context);
        wifiwatchdogstatemachine.start();
        return wifiwatchdogstatemachine;
    }

    private static boolean putSettingsBoolean(ContentResolver contentresolver, String s, boolean flag) {
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        return android.provider.Settings.Secure.putInt(contentresolver, s, i);
    }

    private void registerForSettingsChanges() {
        ContentObserver contentobserver = new ContentObserver(getHandler()) {

            public void onChange(boolean flag) {
                sendMessage(0x21006);
            }

            final WifiWatchdogStateMachine this$0;

             {
                this$0 = WifiWatchdogStateMachine.this;
                super(handler);
            }
        };
        mContext.getContentResolver().registerContentObserver(android.provider.Settings.Secure.getUriFor("wifi_watchdog_arp_interval_ms"), false, contentobserver);
        mContext.getContentResolver().registerContentObserver(android.provider.Settings.Secure.getUriFor("wifi_watchdog_walled_garden_interval_ms"), false, contentobserver);
        mContext.getContentResolver().registerContentObserver(android.provider.Settings.Secure.getUriFor("wifi_watchdog_num_arp_pings"), false, contentobserver);
        mContext.getContentResolver().registerContentObserver(android.provider.Settings.Secure.getUriFor("wifi_watchdog_min_arp_responses"), false, contentobserver);
        mContext.getContentResolver().registerContentObserver(android.provider.Settings.Secure.getUriFor("wifi_watchdog_arp_ping_timeout_ms"), false, contentobserver);
        mContext.getContentResolver().registerContentObserver(android.provider.Settings.Secure.getUriFor("wifi_watchdog_poor_network_test_enabled"), false, contentobserver);
        mContext.getContentResolver().registerContentObserver(android.provider.Settings.Secure.getUriFor("wifi_watchdog_walled_garden_test_enabled"), false, contentobserver);
        mContext.getContentResolver().registerContentObserver(android.provider.Settings.Secure.getUriFor("wifi_watchdog_walled_garden_url"), false, contentobserver);
    }

    private void registerForWatchdogToggle() {
        ContentObserver contentobserver = new ContentObserver(getHandler()) {

            public void onChange(boolean flag) {
                sendMessage(0x21001);
            }

            final WifiWatchdogStateMachine this$0;

             {
                this$0 = WifiWatchdogStateMachine.this;
                super(handler);
            }
        };
        mContext.getContentResolver().registerContentObserver(android.provider.Settings.Secure.getUriFor("wifi_watchdog_on"), false, contentobserver);
    }

    private void sendPoorLinkDetected() {
        if(DBG)
            log((new StringBuilder()).append("send POOR_LINK_DETECTED ").append(mWifiInfo).toString());
        mWsmChannel.sendMessage(0x21015);
        if(SystemClock.elapsedRealtime() - mLastBssidAvoidedTime <= (long)MIN_INTERVAL_AVOID_BSSID_MS[-1 + MIN_INTERVAL_AVOID_BSSID_MS.length]) goto _L2; else goto _L1
_L1:
        mMinIntervalArrayIndex = 1;
        if(DBG)
            log("set mMinIntervalArrayIndex to 1");
_L4:
        mLastBssidAvoidedTime = SystemClock.elapsedRealtime();
        return;
_L2:
        if(mMinIntervalArrayIndex < -1 + MIN_INTERVAL_AVOID_BSSID_MS.length)
            mMinIntervalArrayIndex = 1 + mMinIntervalArrayIndex;
        if(DBG)
            log((new StringBuilder()).append("mMinIntervalArrayIndex: ").append(mMinIntervalArrayIndex).toString());
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void setWalledGardenNotificationVisible(boolean flag) {
        if(flag || mWalledGardenNotificationShown) {
            Resources resources = Resources.getSystem();
            NotificationManager notificationmanager = (NotificationManager)mContext.getSystemService("notification");
            if(flag) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(mWalledGardenUrl));
                intent.setFlags(0x10400000);
                Object aobj[] = new Object[1];
                aobj[0] = Integer.valueOf(0);
                String s = resources.getString(0x1040403, aobj);
                Object aobj1[] = new Object[1];
                aobj1[0] = mWifiInfo.getSSID();
                String s1 = resources.getString(0x1040404, aobj1);
                Notification notification = new Notification();
                notification.when = 0L;
                notification.icon = 0x1080517;
                notification.flags = 16;
                notification.contentIntent = PendingIntent.getActivity(mContext, 0, intent, 0);
                notification.tickerText = s;
                notification.setLatestEventInfo(mContext, s, s1, notification.contentIntent);
                notificationmanager.notify("WifiWatchdog.walledgarden", 1, notification);
            } else {
                notificationmanager.cancel("WifiWatchdog.walledgarden", 1);
            }
            mWalledGardenNotificationShown = flag;
        }
    }

    private void setupNetworkReceiver() {
        mBroadcastReceiver = new BroadcastReceiver() {

            public void onReceive(Context context, Intent intent) {
                String s = intent.getAction();
                if(!s.equals("android.net.wifi.STATE_CHANGE")) goto _L2; else goto _L1
_L1:
                sendMessage(0x21002, intent);
_L4:
                return;
_L2:
                if(s.equals("android.net.wifi.RSSI_CHANGED"))
                    obtainMessage(0x21003, intent.getIntExtra("newRssi", -200), 0).sendToTarget();
                else
                if(s.equals("android.net.wifi.WIFI_STATE_CHANGED"))
                    sendMessage(0x21005, Integer.valueOf(intent.getIntExtra("wifi_state", 4)));
                if(true) goto _L4; else goto _L3
_L3:
            }

            final WifiWatchdogStateMachine this$0;

             {
                this$0 = WifiWatchdogStateMachine.this;
                super();
            }
        };
        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
        mIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        mIntentFilter.addAction("android.net.wifi.RSSI_CHANGED");
        mContext.registerReceiver(mBroadcastReceiver, mIntentFilter);
    }

    private boolean shouldCheckWalledGarden() {
        boolean flag = false;
        if(mWalledGardenTestEnabled) goto _L2; else goto _L1
_L1:
        if(DBG)
            log("Skipping walled garden check - disabled");
_L4:
        return flag;
_L2:
        long l = (mWalledGardenIntervalMs + mLastWalledGardenCheckTime) - SystemClock.elapsedRealtime();
        if(mLastWalledGardenCheckTime != 0L && l > 0L) {
            if(DBG)
                log((new StringBuilder()).append("Skipping walled garden check - wait ").append(l).append(" ms.").toString());
        } else {
            flag = true;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void updateSettings() {
        if(DBG)
            log("Updating secure settings");
        mArpCheckIntervalMs = android.provider.Settings.Secure.getLong(mContentResolver, "wifi_watchdog_arp_interval_ms", 0x1d4c0L);
        mRssiFetchIntervalMs = android.provider.Settings.Secure.getLong(mContentResolver, "wifi_watchdog_rssi_fetch_interval_ms", 1000L);
        mNumArpPings = android.provider.Settings.Secure.getInt(mContentResolver, "wifi_watchdog_num_arp_pings", 5);
        mMinArpResponses = android.provider.Settings.Secure.getInt(mContentResolver, "wifi_watchdog_min_arp_responses", 1);
        mArpPingTimeoutMs = android.provider.Settings.Secure.getInt(mContentResolver, "wifi_watchdog_arp_ping_timeout_ms", 100);
        mPoorNetworkDetectionEnabled = getSettingsBoolean(mContentResolver, "wifi_watchdog_poor_network_test_enabled", true);
        mWalledGardenTestEnabled = getSettingsBoolean(mContentResolver, "wifi_watchdog_walled_garden_test_enabled", true);
        mWalledGardenUrl = getSettingsStr(mContentResolver, "wifi_watchdog_walled_garden_url", "http://clients3.google.com/generate_204");
        mWalledGardenIntervalMs = android.provider.Settings.Secure.getLong(mContentResolver, "wifi_watchdog_walled_garden_interval_ms", 0x1b7740L);
    }

    public void dump(PrintWriter printwriter) {
        printwriter.print("WatchdogStatus: ");
        printwriter.print((new StringBuilder()).append("State: ").append(getCurrentState()).toString());
        printwriter.println((new StringBuilder()).append("mWifiInfo: [").append(mWifiInfo).append("]").toString());
        printwriter.println((new StringBuilder()).append("mLinkProperties: [").append(mLinkProperties).append("]").toString());
        printwriter.println((new StringBuilder()).append("mCurrentSignalLevel: [").append(mCurrentSignalLevel).append("]").toString());
        printwriter.println((new StringBuilder()).append("mArpCheckIntervalMs: [").append(mArpCheckIntervalMs).append("]").toString());
        printwriter.println((new StringBuilder()).append("mRssiFetchIntervalMs: [").append(mRssiFetchIntervalMs).append("]").toString());
        printwriter.println((new StringBuilder()).append("mWalledGardenIntervalMs: [").append(mWalledGardenIntervalMs).append("]").toString());
        printwriter.println((new StringBuilder()).append("mNumArpPings: [").append(mNumArpPings).append("]").toString());
        printwriter.println((new StringBuilder()).append("mMinArpResponses: [").append(mMinArpResponses).append("]").toString());
        printwriter.println((new StringBuilder()).append("mArpPingTimeoutMs: [").append(mArpPingTimeoutMs).append("]").toString());
        printwriter.println((new StringBuilder()).append("mPoorNetworkDetectionEnabled: [").append(mPoorNetworkDetectionEnabled).append("]").toString());
        printwriter.println((new StringBuilder()).append("mWalledGardenTestEnabled: [").append(mWalledGardenTestEnabled).append("]").toString());
        printwriter.println((new StringBuilder()).append("mWalledGardenUrl: [").append(mWalledGardenUrl).append("]").toString());
    }

    private static final int BASE = 0x21000;
    private static final int CMD_ARP_CHECK = 0x2100b;
    private static final int CMD_DELAYED_WALLED_GARDEN_CHECK = 0x2100c;
    private static final int CMD_RSSI_FETCH = 0x2100d;
    private static boolean DBG = false;
    private static final long DEFAULT_ARP_CHECK_INTERVAL_MS = 0x1d4c0L;
    private static final int DEFAULT_ARP_PING_TIMEOUT_MS = 100;
    private static final int DEFAULT_MIN_ARP_RESPONSES = 1;
    private static final int DEFAULT_NUM_ARP_PINGS = 5;
    private static final long DEFAULT_RSSI_FETCH_INTERVAL_MS = 1000L;
    private static final long DEFAULT_WALLED_GARDEN_INTERVAL_MS = 0x1b7740L;
    private static final String DEFAULT_WALLED_GARDEN_URL = "http://clients3.google.com/generate_204";
    private static final int EVENT_NETWORK_STATE_CHANGE = 0x21002;
    private static final int EVENT_RSSI_CHANGE = 0x21003;
    private static final int EVENT_WATCHDOG_SETTINGS_CHANGE = 0x21006;
    private static final int EVENT_WATCHDOG_TOGGLED = 0x21001;
    private static final int EVENT_WIFI_RADIO_STATE_CHANGE = 0x21005;
    private static final int FULL_ARP_CHECK = 1;
    static final int GOOD_LINK_DETECTED = 0x21016;
    private static final int MIN_INTERVAL_AVOID_BSSID_MS[];
    static final int POOR_LINK_DETECTED = 0x21015;
    static final int RSSI_FETCH = 0x21017;
    static final int RSSI_FETCH_FAILED = 0x21019;
    static final int RSSI_FETCH_SUCCEEDED = 0x21018;
    private static final int RSSI_LEVEL_MONITOR = 0;
    private static final int RSSI_MONITOR_COUNT = 5;
    private static final int RSSI_MONITOR_THRESHOLD = -88;
    private static final int SINGLE_ARP_CHECK = 0;
    private static final String TAG = "WifiWatchdogStateMachine";
    private static final String WALLED_GARDEN_NOTIFICATION_ID = "WifiWatchdog.walledgarden";
    private static final int WALLED_GARDEN_SOCKET_TIMEOUT_MS = 10000;
    private static final int WALLED_GARDEN_START_DELAY_MS = 3000;
    private static boolean sWifiOnly = false;
    private long mArpCheckIntervalMs;
    private int mArpPingTimeoutMs;
    private int mArpToken;
    private BroadcastReceiver mBroadcastReceiver;
    private ConnectedState mConnectedState;
    private ContentResolver mContentResolver;
    private Context mContext;
    private int mCurrentSignalLevel;
    private DefaultState mDefaultState;
    private IntentFilter mIntentFilter;
    private long mLastBssidAvoidedTime;
    private long mLastWalledGardenCheckTime;
    private LinkProperties mLinkProperties;
    private int mMinArpResponses;
    private int mMinIntervalArrayIndex;
    private NotConnectedState mNotConnectedState;
    private int mNumArpPings;
    private OnlineState mOnlineState;
    private OnlineWatchState mOnlineWatchState;
    private boolean mPoorNetworkDetectionEnabled;
    private long mRssiFetchIntervalMs;
    private int mRssiFetchToken;
    private int mRssiMonitorCount;
    private RssiMonitoringState mRssiMonitoringState;
    private VerifyingLinkState mVerifyingLinkState;
    private WalledGardenCheckState mWalledGardenCheckState;
    private long mWalledGardenIntervalMs;
    private boolean mWalledGardenNotificationShown;
    private boolean mWalledGardenTestEnabled;
    private String mWalledGardenUrl;
    private WatchdogDisabledState mWatchdogDisabledState;
    private WatchdogEnabledState mWatchdogEnabledState;
    private WifiInfo mWifiInfo;
    private WifiManager mWifiManager;
    private AsyncChannel mWsmChannel;

    static  {
        DBG = false;
        int ai[] = new int[5];
        ai[0] = 0;
        ai[1] = 30000;
        ai[2] = 60000;
        ai[3] = 0x493e0;
        ai[4] = 0x1b7740;
        MIN_INTERVAL_AVOID_BSSID_MS = ai;
    }



/*
    static boolean access$002(boolean flag) {
        DBG = flag;
        return flag;
    }

*/





/*
    static LinkProperties access$1202(WifiWatchdogStateMachine wifiwatchdogstatemachine, LinkProperties linkproperties) {
        wifiwatchdogstatemachine.mLinkProperties = linkproperties;
        return linkproperties;
    }

*/



/*
    static WifiInfo access$1302(WifiWatchdogStateMachine wifiwatchdogstatemachine, WifiInfo wifiinfo) {
        wifiwatchdogstatemachine.mWifiInfo = wifiinfo;
        return wifiinfo;
    }

*/















/*
    static int access$2504(WifiWatchdogStateMachine wifiwatchdogstatemachine) {
        int i = 1 + wifiwatchdogstatemachine.mArpToken;
        wifiwatchdogstatemachine.mArpToken = i;
        return i;
    }

*/








/*
    static int access$302(WifiWatchdogStateMachine wifiwatchdogstatemachine, int i) {
        wifiwatchdogstatemachine.mCurrentSignalLevel = i;
        return i;
    }

*/


/*
    static long access$3102(WifiWatchdogStateMachine wifiwatchdogstatemachine, long l) {
        wifiwatchdogstatemachine.mLastWalledGardenCheckTime = l;
        return l;
    }

*/












/*
    static int access$4004(WifiWatchdogStateMachine wifiwatchdogstatemachine) {
        int i = 1 + wifiwatchdogstatemachine.mRssiFetchToken;
        wifiwatchdogstatemachine.mRssiFetchToken = i;
        return i;
    }

*/





/*
    static int access$4302(WifiWatchdogStateMachine wifiwatchdogstatemachine, int i) {
        wifiwatchdogstatemachine.mRssiMonitorCount = i;
        return i;
    }

*/


/*
    static int access$4308(WifiWatchdogStateMachine wifiwatchdogstatemachine) {
        int i = wifiwatchdogstatemachine.mRssiMonitorCount;
        wifiwatchdogstatemachine.mRssiMonitorCount = i + 1;
        return i;
    }

*/






}
