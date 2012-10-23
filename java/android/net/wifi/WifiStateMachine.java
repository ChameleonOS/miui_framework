// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.backup.IBackupManager;
import android.content.*;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.*;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.*;
import android.util.*;
import com.android.internal.app.IBatteryStats;
import com.android.internal.util.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

// Referenced classes of package android.net.wifi:
//            WifiNative, WifiConfigStore, WifiMonitor, WifiInfo, 
//            SupplicantStateTracker, WifiApConfigStore, WifiManager, StateChangeResult, 
//            SupplicantState, ScanResult, WifiConfiguration, NetworkUpdateResult, 
//            WpsInfo, WpsResult

public class WifiStateMachine extends StateMachine {
    class TetheredState extends State {

        public void enter() {
            EventLog.writeEvent(50021, getName());
        }

        public boolean processMessage(Message message) {
            boolean flag = true;
            message.what;
            JVM INSTR lookupswitch 2: default 32
        //                       131096: 79
        //                       131101: 36;
               goto _L1 _L2 _L3
_L1:
            flag = false;
_L5:
            return flag;
_L3:
            TetherStateChange tetherstatechange = (TetherStateChange)message.obj;
            if(!isWifiTethered(tetherstatechange.active)) {
                loge("Tethering reports wifi as untethered!, shut down soft Ap");
                setWifiApEnabled(null, false);
            }
            continue; /* Loop/switch isn't completed */
_L2:
            setWifiApState(10);
            stopTethering();
            transitionTo(mSoftApStoppingState);
            if(true) goto _L5; else goto _L4
_L4:
        }

        final WifiStateMachine this$0;

        TetheredState() {
            this$0 = WifiStateMachine.this;
            super();
        }
    }

    class SoftApStartedState extends State {

        public void enter() {
            EventLog.writeEvent(50021, getName());
        }

        public boolean processMessage(Message message) {
            message.what;
            JVM INSTR lookupswitch 4: default 48
        //                       131083: 113
        //                       131093: 94
        //                       131096: 52
        //                       131101: 133;
               goto _L1 _L2 _L3 _L4 _L5
_L5:
            break MISSING_BLOCK_LABEL_133;
_L1:
            boolean flag = false;
_L6:
            return flag;
_L4:
            setWifiApState(10);
            try {
                mNwService.stopAccessPoint(mInterfaceName);
            }
            catch(Exception exception) {
                loge("Exception in stopAccessPoint()");
            }
            transitionTo(mDriverLoadedState);
_L3:
            flag = true;
            if(true) goto _L6; else goto _L2
_L2:
            loge("Cannot start supplicant with a running soft AP");
            setWifiState(4);
              goto _L3
            TetherStateChange tetherstatechange = (TetherStateChange)message.obj;
            if(startTethering(tetherstatechange.available))
                transitionTo(mTetheringState);
              goto _L3
        }

        final WifiStateMachine this$0;

        SoftApStartedState() {
            this$0 = WifiStateMachine.this;
            super();
        }
    }

    class SoftApStartingState extends State {

        public void enter() {
            EventLog.writeEvent(50021, getName());
            Message message = getCurrentMessage();
            if(message.what == 0x20015) {
                WifiConfiguration wificonfiguration = (WifiConfiguration)message.obj;
                if(wificonfiguration == null) {
                    mWifiApConfigChannel.sendMessage(0x2001b);
                } else {
                    mWifiApConfigChannel.sendMessage(0x20019, wificonfiguration);
                    startSoftApWithConfig(wificonfiguration);
                }
                return;
            } else {
                throw new RuntimeException((new StringBuilder()).append("Illegal transition to SoftApStartingState: ").append(message).toString());
            }
        }

        public boolean processMessage(Message message) {
            boolean flag = false;
            message.what;
            JVM INSTR lookupswitch 18: default 160
        //                       131073: 162
        //                       131074: 162
        //                       131083: 162
        //                       131084: 162
        //                       131085: 162
        //                       131086: 162
        //                       131093: 162
        //                       131094: 219
        //                       131095: 245
        //                       131096: 162
        //                       131100: 175
        //                       131101: 162
        //                       131144: 162
        //                       131145: 162
        //                       131152: 162
        //                       131156: 162
        //                       131157: 162
        //                       131162: 162;
               goto _L1 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L3 _L4 _L2 _L5 _L2 _L2 _L2 _L2 _L2 _L2 _L2
_L4:
            break MISSING_BLOCK_LABEL_245;
_L1:
            return flag;
_L2:
            deferMessage(message);
_L6:
            flag = true;
            if(true) goto _L1; else goto _L5
_L5:
            WifiConfiguration wificonfiguration = (WifiConfiguration)message.obj;
            if(wificonfiguration != null) {
                startSoftApWithConfig(wificonfiguration);
            } else {
                loge("Softap config is null!");
                sendMessage(0x20017);
            }
              goto _L6
_L3:
            setWifiApState(13);
            transitionTo(mSoftApStartedState);
              goto _L6
            sendMessage(obtainMessage(0x20002, 14, 0));
              goto _L6
        }

        final WifiStateMachine this$0;

        SoftApStartingState() {
            this$0 = WifiStateMachine.this;
            super();
        }
    }

    class WpsRunningState extends State {

        public void enter() {
            EventLog.writeEvent(50021, getName());
            mSourceMessage = Message.obtain(getCurrentMessage());
        }

        public void exit() {
            mWifiConfigStore.enableAllNetworks();
            mWifiConfigStore.loadConfiguredNetworks();
        }

        public boolean processMessage(Message message) {
            boolean flag = false;
            message.what;
            JVM INSTR lookupswitch 15: default 136
        //                       131086: 383
        //                       131126: 383
        //                       131144: 383
        //                       131147: 383
        //                       131148: 383
        //                       147459: 383
        //                       147460: 394
        //                       147462: 177
        //                       147464: 138
        //                       147465: 225
        //                       147466: 182
        //                       147467: 271
        //                       151553: 383
        //                       151562: 315
        //                       151566: 329;
               goto _L1 _L2 _L2 _L2 _L2 _L2 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L2 _L9 _L10
_L3:
            break MISSING_BLOCK_LABEL_394;
_L4:
            break; /* Loop/switch isn't completed */
_L1:
            return flag;
_L5:
            replyToMessage(mSourceMessage, 0x2500d);
            mSourceMessage.recycle();
            mSourceMessage = null;
            transitionTo(mDisconnectedState);
_L11:
            flag = true;
            if(true) goto _L1; else goto _L7
_L7:
            replyToMessage(mSourceMessage, 0x2500c, 3);
            mSourceMessage.recycle();
            mSourceMessage = null;
            transitionTo(mDisconnectedState);
              goto _L11
_L6:
            replyToMessage(mSourceMessage, 0x2500c, message.arg1);
            mSourceMessage.recycle();
            mSourceMessage = null;
            transitionTo(mDisconnectedState);
              goto _L11
_L8:
            replyToMessage(mSourceMessage, 0x2500c, 7);
            mSourceMessage.recycle();
            mSourceMessage = null;
            transitionTo(mDisconnectedState);
              goto _L11
_L9:
            replyToMessage(message, 0x2500c, 1);
              goto _L11
_L10:
            if(mWifiNative.cancelWps())
                replyToMessage(message, 0x25010);
            else
                replyToMessage(message, 0x2500f, 0);
            transitionTo(mDisconnectedState);
              goto _L11
_L2:
            deferMessage(message);
              goto _L11
            handleNetworkDisconnect();
              goto _L11
        }

        private Message mSourceMessage;
        final WifiStateMachine this$0;

        WpsRunningState() {
            this$0 = WifiStateMachine.this;
            super();
        }
    }

    class DisconnectingState extends State {

        public void enter() {
            EventLog.writeEvent(50021, getName());
        }

        public boolean processMessage(Message message) {
            message.what;
            JVM INSTR lookupswitch 2: default 32
        //                       131144: 36
        //                       147462: 57;
               goto _L1 _L2 _L3
_L1:
            boolean flag = false;
_L4:
            return flag;
_L2:
            if(message.arg1 == 2)
                deferMessage(message);
_L5:
            flag = true;
            if(true) goto _L4; else goto _L3
_L3:
            deferMessage(message);
            handleNetworkDisconnect();
            transitionTo(mDisconnectedState);
              goto _L5
        }

        final WifiStateMachine this$0;

        DisconnectingState() {
            this$0 = WifiStateMachine.this;
            super();
        }
    }

    class ConnectedState extends State {

        public void enter() {
            EventLog.writeEvent(50021, getName());
        }

        public void exit() {
            checkAndSetConnectivityInstance();
            mCm.requestNetworkTransitionWakelock("WifiStateMachine");
        }

        public boolean processMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 135189 135189: default 24
        //                       135189 28;
               goto _L1 _L2
_L1:
            boolean flag = false;
_L4:
            return flag;
_L2:
            try {
                mNwService.disableIpv6(mInterfaceName);
            }
            catch(RemoteException remoteexception) {
                loge((new StringBuilder()).append("Failed to disable IPv6: ").append(remoteexception).toString());
            }
            catch(IllegalStateException illegalstateexception) {
                loge((new StringBuilder()).append("Failed to disable IPv6: ").append(illegalstateexception).toString());
            }
            setNetworkDetailedState(android.net.NetworkInfo.DetailedState.DISCONNECTED);
            mWifiConfigStore.updateStatus(mLastNetworkId, android.net.NetworkInfo.DetailedState.DISCONNECTED);
            sendNetworkStateChangeBroadcast(mLastBssid);
            transitionTo(mVerifyingLinkState);
            flag = true;
            if(true) goto _L4; else goto _L3
_L3:
        }

        final WifiStateMachine this$0;

        ConnectedState() {
            this$0 = WifiStateMachine.this;
            super();
        }
    }

    class VerifyingLinkState extends State {

        public void enter() {
            EventLog.writeEvent(50021, getName());
            setNetworkDetailedState(android.net.NetworkInfo.DetailedState.VERIFYING_POOR_LINK);
            mWifiConfigStore.updateStatus(mLastNetworkId, android.net.NetworkInfo.DetailedState.VERIFYING_POOR_LINK);
            sendNetworkStateChangeBroadcast(mLastBssid);
        }

        public boolean processMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 135189 135190: default 28
        //                       135189 109
        //                       135190 32;
               goto _L1 _L2 _L3
_L1:
            boolean flag = false;
_L5:
            return flag;
_L3:
            try {
                mNwService.enableIpv6(mInterfaceName);
            }
            catch(RemoteException remoteexception) {
                loge((new StringBuilder()).append("Failed to enable IPv6: ").append(remoteexception).toString());
            }
            catch(IllegalStateException illegalstateexception) {
                loge((new StringBuilder()).append("Failed to enable IPv6: ").append(illegalstateexception).toString());
            }
            setNetworkDetailedState(android.net.NetworkInfo.DetailedState.CONNECTED);
            mWifiConfigStore.updateStatus(mLastNetworkId, android.net.NetworkInfo.DetailedState.CONNECTED);
            sendNetworkStateChangeBroadcast(mLastBssid);
            transitionTo(mConnectedState);
_L2:
            flag = true;
            if(true) goto _L5; else goto _L4
_L4:
        }

        final WifiStateMachine this$0;

        VerifyingLinkState() {
            this$0 = WifiStateMachine.this;
            super();
        }
    }

    class ObtainingIpState extends State {

        public void enter() {
            EventLog.writeEvent(50021, getName());
            if(!mWifiConfigStore.isUsingStaticIp(mLastNetworkId)) {
                mDhcpStateMachine = DhcpStateMachine.makeDhcpStateMachine(mContext, WifiStateMachine.this, mInterfaceName);
                mDhcpStateMachine.registerForPreDhcpNotification();
                mDhcpStateMachine.sendMessage(0x30001);
            } else {
                DhcpInfoInternal dhcpinfointernal = mWifiConfigStore.getIpConfiguration(mLastNetworkId);
                InterfaceConfiguration interfaceconfiguration = new InterfaceConfiguration();
                interfaceconfiguration.setLinkAddress(dhcpinfointernal.makeLinkAddress());
                interfaceconfiguration.setInterfaceUp();
                try {
                    mNwService.setInterfaceConfig(mInterfaceName, interfaceconfiguration);
                    sendMessage(0x2000f, dhcpinfointernal);
                }
                catch(RemoteException remoteexception) {
                    loge((new StringBuilder()).append("Static IP configuration failed: ").append(remoteexception).toString());
                    sendMessage(0x20010);
                }
                catch(IllegalStateException illegalstateexception) {
                    loge((new StringBuilder()).append("Static IP configuration failed: ").append(illegalstateexception).toString());
                    sendMessage(0x20010);
                }
            }
        }

        public boolean processMessage(Message message) {
            message.what;
            JVM INSTR lookupswitch 4: default 48
        //                       131087: 52
        //                       131088: 85
        //                       131149: 120
        //                       151559: 109;
               goto _L1 _L2 _L3 _L4 _L5
_L4:
            break MISSING_BLOCK_LABEL_120;
_L1:
            boolean flag = false;
_L6:
            return flag;
_L2:
            handleSuccessfulIpConfiguration((DhcpInfoInternal)message.obj);
            transitionTo(mVerifyingLinkState);
_L7:
            flag = true;
            if(true) goto _L6; else goto _L3
_L3:
            handleFailedIpConfiguration();
            transitionTo(mDisconnectingState);
              goto _L7
_L5:
            deferMessage(message);
              goto _L7
            deferMessage(message);
              goto _L7
        }

        final WifiStateMachine this$0;

        ObtainingIpState() {
            this$0 = WifiStateMachine.this;
            super();
        }
    }

    class ConnectModeState extends State {

        public void enter() {
            EventLog.writeEvent(50021, getName());
        }

        public boolean processMessage(Message message) {
            boolean flag = false;
            message.what;
            JVM INSTR lookupswitch 10: default 96
        //                       131146: 239
        //                       131147: 253
        //                       131148: 267
        //                       147459: 645
        //                       147460: 747
        //                       147461: 630
        //                       147462: 115
        //                       147463: 98
        //                       151553: 281
        //                       151562: 436;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
            return flag;
_L9:
            mSupplicantStateTracker.sendMessage(0x24007);
_L12:
            flag = true;
              goto _L1
_L8:
            SupplicantState supplicantstate = handleSupplicantStateChange(message);
            if(!SupplicantState.isDriverActive(supplicantstate)) {
                if(mNetworkInfo.getState() != android.net.NetworkInfo.State.DISCONNECTED)
                    handleNetworkDisconnect();
                log("Detected an interface down, restart driver");
                transitionTo(mDriverStoppedState);
                sendMessage(0x2000d);
            } else
            if(supplicantstate == SupplicantState.DISCONNECTED && mNetworkInfo.getState() != android.net.NetworkInfo.State.DISCONNECTED) {
                handleNetworkDisconnect();
                transitionTo(mDisconnectedState);
            }
              goto _L12
_L2:
            mWifiNative.disconnect();
              goto _L12
_L3:
            mWifiNative.reconnect();
              goto _L12
_L4:
            mWifiNative.reassociate();
              goto _L12
_L10:
            int i = message.arg1;
            WifiConfiguration wificonfiguration = (WifiConfiguration)message.obj;
            if(wificonfiguration != null)
                i = mWifiConfigStore.saveNetwork(wificonfiguration).getNetworkId();
            if(mWifiConfigStore.selectNetwork(i) && mWifiNative.reconnect()) {
                mSupplicantStateTracker.sendMessage(0x25001);
                replyToMessage(message, 0x25003);
                transitionTo(mDisconnectingState);
            } else {
                loge((new StringBuilder()).append("Failed to connect config: ").append(wificonfiguration).append(" netId: ").append(i).toString());
                replyToMessage(message, 0x25002, 0);
            }
              goto _L12
_L11:
            WpsInfo wpsinfo = (WpsInfo)message.obj;
            wpsinfo.setup;
            JVM INSTR tableswitch 0 2: default 476
        //                       0 536
        //                       1 570
        //                       2 553;
               goto _L13 _L14 _L15 _L16
_L13:
            WpsResult wpsresult;
            wpsresult = new WpsResult(WpsResult.Status.FAILURE);
            Log.e("WifiStateMachine", "Invalid setup for WPS");
_L17:
            if(wpsresult.status == WpsResult.Status.SUCCESS) {
                replyToMessage(message, 0x2500b, wpsresult);
                transitionTo(mWpsRunningState);
            } else {
                Log.e("WifiStateMachine", (new StringBuilder()).append("Failed to start WPS with config ").append(wpsinfo.toString()).toString());
                replyToMessage(message, 0x2500c, 0);
            }
              goto _L12
_L14:
            wpsresult = mWifiConfigStore.startWpsPbc(wpsinfo);
              goto _L17
_L16:
            wpsresult = mWifiConfigStore.startWpsWithPinFromAccessPoint(wpsinfo);
              goto _L17
_L15:
            wpsresult = mWifiConfigStore.startWpsWithPinFromDevice(wpsinfo);
              goto _L17
_L7:
            mWifiNative.setScanResultHandling(1);
              goto _L1
_L5:
            mLastNetworkId = message.arg1;
            mLastBssid = (String)message.obj;
            mWifiInfo.setBSSID(mLastBssid);
            mWifiInfo.setNetworkId(mLastNetworkId);
            setNetworkDetailedState(android.net.NetworkInfo.DetailedState.OBTAINING_IPADDR);
            sendNetworkStateChangeBroadcast(mLastBssid);
            transitionTo(mObtainingIpState);
              goto _L12
_L6:
            handleNetworkDisconnect();
            transitionTo(mDisconnectedState);
              goto _L12
        }

        final WifiStateMachine this$0;

        ConnectModeState() {
            this$0 = WifiStateMachine.this;
            super();
        }
    }

    class ScanModeState extends State {

        public void enter() {
            EventLog.writeEvent(50021, getName());
        }

        public boolean processMessage(Message message) {
            boolean flag = true;
            message.what;
            JVM INSTR lookupswitch 7: default 72
        //                       131144: 76
        //                       131146: 74
        //                       131147: 74
        //                       131148: 74
        //                       147459: 74
        //                       147460: 74
        //                       147462: 74;
               goto _L1 _L2 _L3 _L3 _L3 _L3 _L3 _L3
_L1:
            flag = false;
_L3:
            return flag;
_L2:
            if(message.arg1 != 2) {
                mWifiNative.setScanResultHandling(message.arg1);
                mWifiNative.reconnect();
                mIsScanMode = false;
                transitionTo(mDisconnectedState);
            }
            if(true) goto _L3; else goto _L4
_L4:
        }

        final WifiStateMachine this$0;

        ScanModeState() {
            this$0 = WifiStateMachine.this;
            super();
        }
    }

    class DriverStoppedState extends State {

        public void enter() {
            EventLog.writeEvent(50021, getName());
        }

        public boolean processMessage(Message message) {
            message.what;
            JVM INSTR lookupswitch 2: default 32
        //                       131085: 71
        //                       147462: 36;
               goto _L1 _L2 _L3
_L1:
            boolean flag = false;
_L4:
            return flag;
_L3:
            if(SupplicantState.isDriverActive(((StateChangeResult)message.obj).state))
                transitionTo(mDriverStartedState);
_L5:
            flag = true;
            if(true) goto _L4; else goto _L2
_L2:
            mWakeLock.acquire();
            mWifiNative.startDriver();
            mWakeLock.release();
            transitionTo(mDriverStartingState);
              goto _L5
        }

        final WifiStateMachine this$0;

        DriverStoppedState() {
            this$0 = WifiStateMachine.this;
            super();
        }
    }

    class DriverStoppingState extends State {

        public void enter() {
            EventLog.writeEvent(50021, getName());
        }

        public boolean processMessage(Message message) {
            message.what;
            JVM INSTR lookupswitch 12: default 112
        //                       131085: 149
        //                       131086: 149
        //                       131143: 149
        //                       131145: 149
        //                       131146: 149
        //                       131147: 149
        //                       131148: 149
        //                       131152: 149
        //                       131156: 149
        //                       131157: 149
        //                       131162: 149
        //                       147462: 116;
               goto _L1 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L3
_L1:
            boolean flag = false;
_L4:
            return flag;
_L3:
            if(handleSupplicantStateChange(message) == SupplicantState.INTERFACE_DISABLED)
                transitionTo(mDriverStoppedState);
_L5:
            flag = true;
            if(true) goto _L4; else goto _L2
_L2:
            deferMessage(message);
              goto _L5
        }

        final WifiStateMachine this$0;

        DriverStoppingState() {
            this$0 = WifiStateMachine.this;
            super();
        }
    }

    class SupplicantStartedState extends State {

        public void enter() {
            EventLog.writeEvent(50021, getName());
            mIsScanMode = false;
            mNetworkInfo.setIsAvailable(true);
            int i = mContext.getResources().getInteger(0x10e000b);
            mSupplicantScanIntervalMs = android.provider.Settings.Secure.getLong(mContext.getContentResolver(), "wifi_supplicant_scan_interval_ms", i);
            mWifiNative.setScanInterval((int)mSupplicantScanIntervalMs / 1000);
        }

        public void exit() {
            mNetworkInfo.setIsAvailable(false);
        }

        public boolean processMessage(Message message) {
            byte byte0;
            boolean flag;
            byte0 = -1;
            flag = false;
            message.what;
            JVM INSTR lookupswitch 17: default 156
        //                       131084: 158
        //                       131093: 719
        //                       131123: 311
        //                       131124: 354
        //                       131125: 388
        //                       131126: 435
        //                       131127: 501
        //                       131128: 592
        //                       131129: 613
        //                       131130: 627
        //                       131131: 694
        //                       131144: 741
        //                       147458: 177
        //                       147461: 275
        //                       151556: 834
        //                       151559: 767
        //                       151569: 546;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18
_L16:
            break MISSING_BLOCK_LABEL_834;
_L1:
            return flag;
_L2:
            transitionTo(mSupplicantStoppingState);
_L19:
            flag = true;
            if(true) goto _L1; else goto _L14
_L14:
            loge("Connection lost, restart supplicant");
            mWifiNative;
            WifiNative.killSupplicant();
            mWifiNative.closeSupplicantConnection();
            mNetworkInfo.setIsAvailable(false);
            handleNetworkDisconnect();
            sendSupplicantConnectionChangedBroadcast(false);
            mSupplicantStateTracker.sendMessage(0x2006f);
            transitionTo(mDriverLoadedState);
            sendMessageDelayed(0x2000b, 5000L);
              goto _L19
_L15:
            setScanResults(mWifiNative.scanResults());
            sendScanResultsAvailableBroadcast();
            mScanResultIsPending = false;
              goto _L19
_L4:
            boolean flag4 = mWifiNative.ping();
            WifiStateMachine wifistatemachine4 = WifiStateMachine.this;
            int i1 = message.what;
            if(flag4)
                byte0 = 1;
            wifistatemachine4.replyToMessage(message, i1, byte0);
              goto _L19
_L5:
            WifiConfiguration wificonfiguration1 = (WifiConfiguration)message.obj;
            replyToMessage(message, 0x20034, mWifiConfigStore.addOrUpdateNetwork(wificonfiguration1));
              goto _L19
_L6:
            boolean flag3 = mWifiConfigStore.removeNetwork(message.arg1);
            WifiStateMachine wifistatemachine3 = WifiStateMachine.this;
            int k = message.what;
            if(flag3)
                byte0 = 1;
            wifistatemachine3.replyToMessage(message, k, byte0);
              goto _L19
_L7:
            WifiConfigStore wificonfigstore = mWifiConfigStore;
            int i = message.arg1;
            if(message.arg2 == 1)
                flag = true;
            boolean flag2 = wificonfigstore.enableNetwork(i, flag);
            WifiStateMachine wifistatemachine2 = WifiStateMachine.this;
            int j = message.what;
            if(flag2)
                byte0 = 1;
            wifistatemachine2.replyToMessage(message, j, byte0);
              goto _L19
_L8:
            long l = SystemClock.elapsedRealtime();
            if(l - mLastEnableAllNetworksTime > 0x927c0L) {
                mWifiConfigStore.enableAllNetworks();
                mLastEnableAllNetworksTime = l;
            }
              goto _L19
_L18:
            if(mWifiConfigStore.disableNetwork(message.arg1, 0))
                replyToMessage(message, 0x25013);
            else
                replyToMessage(message, 0x25012, 0);
              goto _L19
_L9:
            mWifiNative.addToBlacklist((String)message.obj);
              goto _L19
_L10:
            mWifiNative.clearBlacklist();
              goto _L19
_L11:
            boolean flag1 = mWifiConfigStore.saveConfig();
            WifiStateMachine wifistatemachine1 = WifiStateMachine.this;
            if(flag1)
                byte0 = 1;
            wifistatemachine1.replyToMessage(message, 0x2003a, byte0);
            IBackupManager ibackupmanager = android.app.backup.IBackupManager.Stub.asInterface(ServiceManager.getService("backup"));
            if(ibackupmanager != null)
                try {
                    ibackupmanager.dataChanged("com.android.providers.settings");
                }
                catch(Exception exception) { }
              goto _L19
_L12:
            replyToMessage(message, message.what, mWifiConfigStore.getConfiguredNetworks());
              goto _L19
_L3:
            loge("Failed to start soft AP with a running supplicant");
            setWifiApState(14);
              goto _L19
_L13:
            WifiStateMachine wifistatemachine = WifiStateMachine.this;
            if(message.arg1 == 2)
                flag = true;
            wifistatemachine.mIsScanMode = flag;
              goto _L19
_L17:
            WifiConfiguration wificonfiguration = (WifiConfiguration)message.obj;
            if(mWifiConfigStore.saveNetwork(wificonfiguration).getNetworkId() != byte0) {
                replyToMessage(message, 0x25009);
            } else {
                loge("Failed to save network");
                replyToMessage(message, 0x25008, 0);
            }
              goto _L19
            if(mWifiConfigStore.forgetNetwork(message.arg1)) {
                replyToMessage(message, 0x25006);
            } else {
                loge("Failed to forget network");
                replyToMessage(message, 0x25005, 0);
            }
              goto _L19
        }

        final WifiStateMachine this$0;

        SupplicantStartedState() {
            this$0 = WifiStateMachine.this;
            super();
        }
    }

    class DriverFailedState extends State {

        public void enter() {
            loge((new StringBuilder()).append(getName()).append("\n").toString());
            EventLog.writeEvent(50021, getName());
        }

        public boolean processMessage(Message message) {
            return false;
        }

        final WifiStateMachine this$0;

        DriverFailedState() {
            this$0 = WifiStateMachine.this;
            super();
        }
    }

    class DriverUnloadedState extends State {

        public void enter() {
            EventLog.writeEvent(50021, getName());
        }

        public boolean processMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 131073 131073: default 24
        //                       131073 28;
               goto _L1 _L2
_L1:
            boolean flag = false;
_L4:
            return flag;
_L2:
            transitionTo(mDriverLoadingState);
            flag = true;
            if(true) goto _L4; else goto _L3
_L3:
        }

        final WifiStateMachine this$0;

        DriverUnloadedState() {
            this$0 = WifiStateMachine.this;
            super();
        }
    }

    class DriverUnloadingState extends State {

        public void enter() {
            EventLog.writeEvent(50021, getName());
            final Message message = new Message();
            message.copyFrom(getCurrentMessage());
            (new Thread(new Runnable() {

                public void run() {
                    mWakeLock.acquire();
                    mWifiNative;
                    if(!WifiNative.unloadDriver()) goto _L2; else goto _L1
_L1:
                    sendMessage(0x20005);
                    message.arg1;
                    JVM INSTR lookupswitch 4: default 92
                //                               1: 106
                //                               4: 106
                //                               11: 126
                //                               14: 126;
                       goto _L3 _L4 _L4 _L5 _L5
_L3:
                    mWakeLock.release();
                    return;
_L4:
                    setWifiState(message.arg1);
                    continue; /* Loop/switch isn't completed */
_L5:
                    setWifiApState(message.arg1);
                    if(true) goto _L3; else goto _L2
_L2:
                    loge("Failed to unload driver!");
                    sendMessage(0x20006);
                    switch(message.arg1) {
                    case 1: // '\001'
                    case 4: // '\004'
                        setWifiState(4);
                        break;

                    case 11: // '\013'
                    case 14: // '\016'
                        setWifiApState(14);
                        break;
                    }
                    if(true) goto _L3; else goto _L6
_L6:
                }

                final DriverUnloadingState this$1;
                final Message val$message;

                 {
                    this$1 = DriverUnloadingState.this;
                    message = message1;
                    super();
                }
            })).start();
        }

        public boolean processMessage(Message message) {
            message.what;
            JVM INSTR lookupswitch 16: default 144
        //                       131073: 184
        //                       131074: 184
        //                       131077: 148
        //                       131078: 167
        //                       131083: 184
        //                       131084: 184
        //                       131085: 184
        //                       131086: 184
        //                       131093: 184
        //                       131096: 184
        //                       131144: 184
        //                       131145: 184
        //                       131152: 184
        //                       131156: 184
        //                       131157: 184
        //                       131162: 184;
               goto _L1 _L2 _L2 _L3 _L4 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2
_L2:
            break MISSING_BLOCK_LABEL_184;
_L1:
            boolean flag = false;
_L5:
            return flag;
_L3:
            transitionTo(mDriverUnloadedState);
_L6:
            flag = true;
            if(true) goto _L5; else goto _L4
_L4:
            transitionTo(mDriverFailedState);
              goto _L6
            deferMessage(message);
              goto _L6
        }

        final WifiStateMachine this$0;

        DriverUnloadingState() {
            this$0 = WifiStateMachine.this;
            super();
        }
    }

    class DriverLoadedState extends State {

        public void enter() {
            EventLog.writeEvent(50021, getName());
        }

        public boolean processMessage(Message message) {
            boolean flag = false;
            message.what;
            JVM INSTR lookupswitch 3: default 40
        //                       131074: 42
        //                       131083: 61
        //                       131093: 293;
               goto _L1 _L2 _L3 _L4
_L4:
            break MISSING_BLOCK_LABEL_293;
_L1:
            return flag;
_L2:
            transitionTo(mDriverUnloadingState);
_L5:
            flag = true;
            if(true) goto _L1; else goto _L3
_L3:
            try {
                mNwService.wifiFirmwareReload(mInterfaceName, "STA");
            }
            catch(Exception exception) {
                loge((new StringBuilder()).append("Failed to reload STA firmware ").append(exception).toString());
            }
            try {
                mNwService.setInterfaceDown(mInterfaceName);
                mNwService.setInterfaceIpv6PrivacyExtensions(mInterfaceName, true);
            }
            catch(RemoteException remoteexception) {
                loge((new StringBuilder()).append("Unable to change interface settings: ").append(remoteexception).toString());
            }
            catch(IllegalStateException illegalstateexception) {
                loge((new StringBuilder()).append("Unable to change interface settings: ").append(illegalstateexception).toString());
            }
            mWifiNative;
            if(WifiNative.startSupplicant(mP2pSupported)) {
                mWifiMonitor.startMonitoring();
                transitionTo(mSupplicantStartingState);
            } else {
                loge("Failed to start supplicant!");
                sendMessage(obtainMessage(0x20002, 4, 0));
            }
              goto _L5
            transitionTo(mSoftApStartingState);
              goto _L5
        }

        final WifiStateMachine this$0;

        DriverLoadedState() {
            this$0 = WifiStateMachine.this;
            super();
        }
    }

    class DriverLoadingState extends State {

        public void enter() {
            EventLog.writeEvent(50021, getName());
            final Message message = new Message();
            message.copyFrom(getCurrentMessage());
            (new Thread(new Runnable() {

                public void run() {
                    mWakeLock.acquire();
                    message.arg1;
                    JVM INSTR lookupswitch 2: default 48
                //                               2: 91
                //                               12: 105;
                       goto _L1 _L2 _L3
_L1:
                    mWifiNative;
                    if(!WifiNative.loadDriver()) goto _L5; else goto _L4
_L4:
                    sendMessage(0x20003);
_L9:
                    mWakeLock.release();
                    return;
_L2:
                    setWifiState(2);
                      goto _L1
_L3:
                    setWifiApState(12);
                      goto _L1
_L5:
                    loge("Failed to load driver!");
                    message.arg1;
                    JVM INSTR lookupswitch 2: default 164
                //                               2: 179
                //                               12: 193;
                       goto _L6 _L7 _L8
_L6:
                    break; /* Loop/switch isn't completed */
_L8:
                    break MISSING_BLOCK_LABEL_193;
_L10:
                    sendMessage(0x20004);
                      goto _L9
_L7:
                    setWifiState(4);
                      goto _L10
                    setWifiApState(14);
                      goto _L10
                }

                final DriverLoadingState this$1;
                final Message val$message;

                 {
                    this$1 = DriverLoadingState.this;
                    message = message1;
                    super();
                }
            })).start();
        }

        public boolean processMessage(Message message) {
            message.what;
            JVM INSTR lookupswitch 16: default 144
        //                       131073: 184
        //                       131074: 184
        //                       131075: 148
        //                       131076: 167
        //                       131083: 184
        //                       131084: 184
        //                       131085: 184
        //                       131086: 184
        //                       131093: 184
        //                       131096: 184
        //                       131144: 184
        //                       131145: 184
        //                       131152: 184
        //                       131156: 184
        //                       131157: 184
        //                       131162: 184;
               goto _L1 _L2 _L2 _L3 _L4 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2
_L2:
            break MISSING_BLOCK_LABEL_184;
_L1:
            boolean flag = false;
_L5:
            return flag;
_L3:
            transitionTo(mDriverLoadedState);
_L6:
            flag = true;
            if(true) goto _L5; else goto _L4
_L4:
            transitionTo(mDriverFailedState);
              goto _L6
            deferMessage(message);
              goto _L6
        }

        final WifiStateMachine this$0;

        DriverLoadingState() {
            this$0 = WifiStateMachine.this;
            super();
        }
    }

    class InitialState extends State {

        public void enter() {
            EventLog.writeEvent(50021, getName());
            mWifiNative;
            if(WifiNative.isDriverLoaded())
                transitionTo(mDriverLoadedState);
            else
                transitionTo(mDriverUnloadedState);
            mWifiP2pManager = (WifiP2pManager)mContext.getSystemService("wifip2p");
            mWifiP2pChannel.connect(mContext, getHandler(), mWifiP2pManager.getMessenger());
            mNwService.disableIpv6(mInterfaceName);
_L1:
            return;
            RemoteException remoteexception;
            remoteexception;
            loge((new StringBuilder()).append("Failed to disable IPv6: ").append(remoteexception).toString());
              goto _L1
            IllegalStateException illegalstateexception;
            illegalstateexception;
            loge((new StringBuilder()).append("Failed to disable IPv6: ").append(illegalstateexception).toString());
              goto _L1
        }

        final WifiStateMachine this$0;

        InitialState() {
            this$0 = WifiStateMachine.this;
            super();
        }
    }

    class DefaultState extends State {

        public boolean processMessage(Message message) {
            boolean flag = false;
            message.what;
            JVM INSTR lookupswitch 66: default 544
        //                       69632: 572
        //                       69636: 626
        //                       131073: 570
        //                       131074: 570
        //                       131083: 570
        //                       131084: 570
        //                       131085: 570
        //                       131086: 570
        //                       131089: 570
        //                       131090: 570
        //                       131091: 570
        //                       131093: 570
        //                       131094: 570
        //                       131095: 570
        //                       131096: 570
        //                       131097: 570
        //                       131098: 570
        //                       131099: 570
        //                       131100: 570
        //                       131101: 570
        //                       131102: 570
        //                       131103: 658
        //                       131123: 683
        //                       131124: 683
        //                       131125: 683
        //                       131126: 683
        //                       131127: 570
        //                       131128: 570
        //                       131129: 570
        //                       131130: 683
        //                       131131: 700
        //                       131143: 570
        //                       131144: 570
        //                       131145: 570
        //                       131146: 570
        //                       131147: 570
        //                       131148: 570
        //                       131149: 771
        //                       131152: 570
        //                       131154: 719
        //                       131155: 570
        //                       131158: 795
        //                       131159: 570
        //                       131160: 570
        //                       131162: 570
        //                       131163: 745
        //                       135189: 570
        //                       135190: 570
        //                       135191: 911
        //                       147457: 570
        //                       147458: 570
        //                       147459: 570
        //                       147460: 570
        //                       147461: 570
        //                       147462: 570
        //                       147463: 570
        //                       147466: 570
        //                       147468: 808
        //                       151553: 827
        //                       151556: 841
        //                       151559: 855
        //                       151562: 869
        //                       151566: 883
        //                       151569: 897
        //                       196612: 570
        //                       196613: 570;
               goto _L1 _L2 _L3 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L5 _L6 _L6 _L6 _L6 _L4 _L4 _L4 _L6 _L7 _L4 _L4 _L4 _L4 _L4 _L4 _L8 _L4 _L9 _L4 _L10 _L4 _L4 _L4 _L11 _L4 _L4 _L12 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L4 _L4
_L4:
            break; /* Loop/switch isn't completed */
_L1:
            loge((new StringBuilder()).append("Error! unhandled message").append(message).toString());
_L21:
            return true;
_L2:
            if(message.arg1 == 0)
                mWifiP2pChannel.sendMessage(0x11001);
            else
                loge((new StringBuilder()).append("WifiP2pService connection failure, error=").append(message.arg1).toString());
            continue; /* Loop/switch isn't completed */
_L3:
            loge((new StringBuilder()).append("WifiP2pService channel lost, message.arg1 =").append(message.arg1).toString());
            continue; /* Loop/switch isn't completed */
_L5:
            WifiStateMachine wifistatemachine3 = WifiStateMachine.this;
            if(message.arg1 != 0)
                flag = true;
            wifistatemachine3.mBluetoothConnectionActive = flag;
            continue; /* Loop/switch isn't completed */
_L6:
            replyToMessage(message, message.what, -1);
            continue; /* Loop/switch isn't completed */
_L7:
            replyToMessage(message, message.what, (List)null);
            continue; /* Loop/switch isn't completed */
_L9:
            WifiStateMachine wifistatemachine2 = WifiStateMachine.this;
            if(message.arg1 == 1)
                flag = true;
            wifistatemachine2.mEnableRssiPolling = flag;
            continue; /* Loop/switch isn't completed */
_L11:
            WifiStateMachine wifistatemachine1 = WifiStateMachine.this;
            if(message.arg1 == 1)
                flag = true;
            wifistatemachine1.mEnableBackgroundScan = flag;
            continue; /* Loop/switch isn't completed */
_L8:
            WifiStateMachine wifistatemachine = WifiStateMachine.this;
            if(message.arg1 == 1)
                flag = true;
            wifistatemachine.mHighPerfMode = flag;
            continue; /* Loop/switch isn't completed */
_L10:
            mSuspendWakeLock.release();
            continue; /* Loop/switch isn't completed */
_L13:
            setWifiEnabled(false);
            setWifiEnabled(true);
            continue; /* Loop/switch isn't completed */
_L14:
            replyToMessage(message, 0x25002, 2);
            continue; /* Loop/switch isn't completed */
_L15:
            replyToMessage(message, 0x25005, 2);
            continue; /* Loop/switch isn't completed */
_L16:
            replyToMessage(message, 0x25008, 2);
            continue; /* Loop/switch isn't completed */
_L17:
            replyToMessage(message, 0x2500c, 2);
            continue; /* Loop/switch isn't completed */
_L18:
            replyToMessage(message, 0x2500f, 2);
            continue; /* Loop/switch isn't completed */
_L19:
            replyToMessage(message, 0x25012, 2);
            continue; /* Loop/switch isn't completed */
_L12:
            replyToMessage(message, 0x21019);
            if(true) goto _L21; else goto _L20
_L20:
        }

        final WifiStateMachine this$0;

        DefaultState() {
            this$0 = WifiStateMachine.this;
            super();
        }
    }

    private class TetherStateChange {

        ArrayList active;
        ArrayList available;
        final WifiStateMachine this$0;

        TetherStateChange(ArrayList arraylist, ArrayList arraylist1) {
            this$0 = WifiStateMachine.this;
            super();
            available = arraylist;
            active = arraylist1;
        }
    }


    public WifiStateMachine(Context context, String s) {
        super("WifiStateMachine");
        mLastSignalLevel = -1;
        mEnableRssiPolling = false;
        mEnableBackgroundScan = false;
        mRssiPollToken = 0;
        mReconnectCount = 0;
        mIsScanMode = false;
        mScanResultIsPending = false;
        mSetScanActive = false;
        mHighPerfMode = false;
        mBluetoothConnectionActive = false;
        mSupplicantRestartCount = 0;
        mSupplicantStopFailureToken = 0;
        mTetherToken = 0;
        mDriverStartToken = 0;
        mPeriodicScanToken = 0;
        mFrequencyBand = new AtomicInteger(0);
        mFilteringMulticastV4Packets = new AtomicBoolean(true);
        mReplyChannel = new AsyncChannel();
        mWifiP2pChannel = new AsyncChannel();
        mWifiApConfigChannel = new AsyncChannel();
        mPowerSaveEnabled = true;
        mInDelayedStop = false;
        mDefaultState = new DefaultState();
        mInitialState = new InitialState();
        mDriverUnloadingState = new DriverUnloadingState();
        mDriverUnloadedState = new DriverUnloadedState();
        mDriverFailedState = new DriverFailedState();
        mDriverLoadingState = new DriverLoadingState();
        mDriverLoadedState = new DriverLoadedState();
        mSupplicantStartingState = new SupplicantStartingState();
        mSupplicantStartedState = new SupplicantStartedState();
        mSupplicantStoppingState = new SupplicantStoppingState();
        mDriverStartingState = new DriverStartingState();
        mDriverStartedState = new DriverStartedState();
        mDriverStoppingState = new DriverStoppingState();
        mDriverStoppedState = new DriverStoppedState();
        mScanModeState = new ScanModeState();
        mConnectModeState = new ConnectModeState();
        mL2ConnectedState = new L2ConnectedState();
        mObtainingIpState = new ObtainingIpState();
        mVerifyingLinkState = new VerifyingLinkState();
        mConnectedState = new ConnectedState();
        mDisconnectingState = new DisconnectingState();
        mDisconnectedState = new DisconnectedState();
        mWpsRunningState = new WpsRunningState();
        mSoftApStartingState = new SoftApStartingState();
        mSoftApStartedState = new SoftApStartedState();
        mTetheringState = new TetheringState();
        mTetheredState = new TetheredState();
        mSoftApStoppingState = new SoftApStoppingState();
        mIsRunning = false;
        mReportedRunning = false;
        mContext = context;
        mInterfaceName = s;
        mNetworkInfo = new NetworkInfo(1, 0, "WIFI", "");
        mNwService = android.os.INetworkManagementService.Stub.asInterface(ServiceManager.getService("network_management"));
        mP2pSupported = mContext.getPackageManager().hasSystemFeature("android.hardware.wifi.direct");
        mWifiNative = new WifiNative(mInterfaceName);
        mWifiConfigStore = new WifiConfigStore(context, mWifiNative);
        mWifiMonitor = new WifiMonitor(this, mWifiNative);
        mDhcpInfoInternal = new DhcpInfoInternal();
        mWifiInfo = new WifiInfo();
        mSupplicantStateTracker = new SupplicantStateTracker(context, this, mWifiConfigStore, getHandler());
        mLinkProperties = new LinkProperties();
        WifiApConfigStore wifiapconfigstore = WifiApConfigStore.makeWifiApConfigStore(context, getHandler());
        wifiapconfigstore.loadApConfiguration();
        mWifiApConfigChannel.connectSync(mContext, getHandler(), wifiapconfigstore.getMessenger());
        mNetworkInfo.setIsAvailable(false);
        mLinkProperties.clear();
        mLastBssid = null;
        mLastNetworkId = -1;
        mLastSignalLevel = -1;
        mAlarmManager = (AlarmManager)mContext.getSystemService("alarm");
        Intent intent = new Intent("com.android.server.WifiManager.action.START_SCAN", null);
        mScanIntent = PendingIntent.getBroadcast(mContext, 0, intent, 0);
        mDefaultFrameworkScanIntervalMs = mContext.getResources().getInteger(0x10e000c);
        mDriverStopDelayMs = mContext.getResources().getInteger(0x10e000d);
        mBackgroundScanSupported = mContext.getResources().getBoolean(0x1110010);
        mPrimaryDeviceType = mContext.getResources().getString(0x104001a);
        mContext.registerReceiver(new BroadcastReceiver() {

            public void onReceive(Context context1, Intent intent1) {
                ArrayList arraylist = intent1.getStringArrayListExtra("availableArray");
                ArrayList arraylist1 = intent1.getStringArrayListExtra("activeArray");
                sendMessage(0x2001d, new TetherStateChange(arraylist, arraylist1));
            }

            final WifiStateMachine this$0;

             {
                this$0 = WifiStateMachine.this;
                super();
            }
        }, new IntentFilter("android.net.conn.TETHER_STATE_CHANGED"));
        mContext.registerReceiver(new BroadcastReceiver() {

            public void onReceive(Context context1, Intent intent1) {
                startScan(false);
            }

            final WifiStateMachine this$0;

             {
                this$0 = WifiStateMachine.this;
                super();
            }
        }, new IntentFilter("com.android.server.WifiManager.action.START_SCAN"));
        mScreenFilter = new IntentFilter();
        mScreenFilter.addAction("android.intent.action.SCREEN_ON");
        mScreenFilter.addAction("android.intent.action.SCREEN_OFF");
        mScreenReceiver = new BroadcastReceiver() {

            public void onReceive(Context context1, Intent intent1) {
                String s1 = intent1.getAction();
                if(!s1.equals("android.intent.action.SCREEN_ON")) goto _L2; else goto _L1
_L1:
                enableRssiPolling(true);
                if(mBackgroundScanSupported)
                    enableBackgroundScanCommand(false);
                enableAllNetworks();
                sendMessage(0x20057);
_L4:
                return;
_L2:
                if(s1.equals("android.intent.action.SCREEN_OFF")) {
                    enableRssiPolling(false);
                    if(mBackgroundScanSupported)
                        enableBackgroundScanCommand(true);
                    mSuspendWakeLock.acquire(2000L);
                    sendMessage(0x20056);
                }
                if(true) goto _L4; else goto _L3
_L3:
            }

            final WifiStateMachine this$0;

             {
                this$0 = WifiStateMachine.this;
                super();
            }
        };
        mContext.registerReceiver(new BroadcastReceiver() {

            public void onReceive(Context context1, Intent intent1) {
                int i = intent1.getIntExtra("DelayedStopCounter", 0);
                sendMessage(obtainMessage(0x20012, i, 0));
            }

            final WifiStateMachine this$0;

             {
                this$0 = WifiStateMachine.this;
                super();
            }
        }, new IntentFilter("com.android.server.WifiManager.action.DELAYED_DRIVER_STOP"));
        PowerManager powermanager = (PowerManager)mContext.getSystemService("power");
        mWakeLock = powermanager.newWakeLock(1, "WifiStateMachine");
        mSuspendWakeLock = powermanager.newWakeLock(1, "WifiSuspend");
        mSuspendWakeLock.setReferenceCounted(false);
        addState(mDefaultState);
        addState(mInitialState, mDefaultState);
        addState(mDriverUnloadingState, mDefaultState);
        addState(mDriverUnloadedState, mDefaultState);
        addState(mDriverFailedState, mDriverUnloadedState);
        addState(mDriverLoadingState, mDefaultState);
        addState(mDriverLoadedState, mDefaultState);
        addState(mSupplicantStartingState, mDefaultState);
        addState(mSupplicantStartedState, mDefaultState);
        addState(mDriverStartingState, mSupplicantStartedState);
        addState(mDriverStartedState, mSupplicantStartedState);
        addState(mScanModeState, mDriverStartedState);
        addState(mConnectModeState, mDriverStartedState);
        addState(mL2ConnectedState, mConnectModeState);
        addState(mObtainingIpState, mL2ConnectedState);
        addState(mVerifyingLinkState, mL2ConnectedState);
        addState(mConnectedState, mL2ConnectedState);
        addState(mDisconnectingState, mConnectModeState);
        addState(mDisconnectedState, mConnectModeState);
        addState(mWpsRunningState, mConnectModeState);
        addState(mDriverStoppingState, mSupplicantStartedState);
        addState(mDriverStoppedState, mSupplicantStartedState);
        addState(mSupplicantStoppingState, mDefaultState);
        addState(mSoftApStartingState, mDefaultState);
        addState(mSoftApStartedState, mDefaultState);
        addState(mTetheringState, mSoftApStartedState);
        addState(mTetheredState, mSoftApStartedState);
        addState(mSoftApStoppingState, mDefaultState);
        setInitialState(mInitialState);
        setProcessedMessagesSize(100);
        start();
    }

    private void checkAndSetConnectivityInstance() {
        if(mCm == null)
            mCm = (ConnectivityManager)mContext.getSystemService("connectivity");
    }

    private void configureLinkProperties() {
        if(mWifiConfigStore.isUsingStaticIp(mLastNetworkId)) {
            mLinkProperties = mWifiConfigStore.getLinkProperties(mLastNetworkId);
        } else {
            synchronized(mDhcpInfoInternal) {
                mLinkProperties = mDhcpInfoInternal.makeLinkProperties();
            }
            mLinkProperties.setHttpProxy(mWifiConfigStore.getProxyProperties(mLastNetworkId));
        }
        mLinkProperties.setInterfaceName(mInterfaceName);
        return;
        exception;
        dhcpinfointernal;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void fetchRssiAndLinkSpeedNative() {
        int i;
        int j;
        String s;
        i = -1;
        j = -1;
        s = mWifiNative.signalPoll();
        if(s == null) goto _L2; else goto _L1
_L1:
        String as[];
        int l;
        int i1;
        as = s.split("\n");
        l = as.length;
        i1 = 0;
_L6:
        if(i1 >= l) goto _L2; else goto _L3
_L3:
        String as1[] = as[i1].split("=");
        if(as1.length >= 2) goto _L5; else goto _L4
_L4:
        i1++;
          goto _L6
_L5:
        if(!as1[0].equals("RSSI")) goto _L8; else goto _L7
_L7:
        i = Integer.parseInt(as1[1]);
          goto _L4
_L8:
        if(!as1[0].equals("LINKSPEED")) goto _L4; else goto _L9
_L9:
        int j1 = Integer.parseInt(as1[1]);
        j = j1;
          goto _L4
_L2:
        if(i != -1 && -200 < i && i < 256) {
            if(i > 0)
                i -= 256;
            mWifiInfo.setRssi(i);
            int k = WifiManager.calculateSignalLevel(i, 5);
            if(k != mLastSignalLevel)
                sendRssiChangeBroadcast(i);
            mLastSignalLevel = k;
        } else {
            mWifiInfo.setRssi(-200);
        }
        if(j != -1)
            mWifiInfo.setLinkSpeed(j);
        return;
        NumberFormatException numberformatexception;
        numberformatexception;
          goto _L4
    }

    private int getMaxDhcpRetries() {
        return android.provider.Settings.Secure.getInt(mContext.getContentResolver(), "wifi_max_dhcp_retry_count", 9);
    }

    private android.net.NetworkInfo.DetailedState getNetworkDetailedState() {
        return mNetworkInfo.getDetailedState();
    }

    private void handleFailedIpConfiguration() {
        loge("IP configuration failed");
        mWifiInfo.setInetAddress(null);
        mWifiInfo.setMeteredHint(false);
        int i = getMaxDhcpRetries();
        if(i > 0) {
            int j = 1 + mReconnectCount;
            mReconnectCount = j;
            if(j > i) {
                loge((new StringBuilder()).append("Failed ").append(mReconnectCount).append(" times, Disabling ").append(mLastNetworkId).toString());
                mWifiConfigStore.disableNetwork(mLastNetworkId, 2);
                mReconnectCount = 0;
            }
        }
        mWifiNative.disconnect();
        mWifiNative.reconnect();
    }

    private void handleNetworkDisconnect() {
        if(mDhcpStateMachine != null) {
            handlePostDhcpSetup();
            mDhcpStateMachine.sendMessage(0x30002);
            mDhcpStateMachine.quit();
            mDhcpStateMachine = null;
        }
        try {
            mNwService.clearInterfaceAddresses(mInterfaceName);
            mNwService.disableIpv6(mInterfaceName);
        }
        catch(Exception exception) {
            loge((new StringBuilder()).append("Failed to clear addresses or disable ipv6").append(exception).toString());
        }
        mWifiInfo.setInetAddress(null);
        mWifiInfo.setBSSID(null);
        mWifiInfo.setSSID(null);
        mWifiInfo.setNetworkId(-1);
        mWifiInfo.setRssi(-200);
        mWifiInfo.setLinkSpeed(-1);
        mWifiInfo.setMeteredHint(false);
        setNetworkDetailedState(android.net.NetworkInfo.DetailedState.DISCONNECTED);
        mWifiConfigStore.updateStatus(mLastNetworkId, android.net.NetworkInfo.DetailedState.DISCONNECTED);
        sendNetworkStateChangeBroadcast(mLastBssid);
        mLinkProperties.clear();
        if(!mWifiConfigStore.isUsingStaticIp(mLastNetworkId))
            mWifiConfigStore.clearIpConfiguration(mLastNetworkId);
        mLastBssid = null;
        mLastNetworkId = -1;
    }

    private void handleSuccessfulIpConfiguration(DhcpInfoInternal dhcpinfointernal) {
        synchronized(mDhcpInfoInternal) {
            mDhcpInfoInternal = dhcpinfointernal;
        }
        mLastSignalLevel = -1;
        mReconnectCount = 0;
        mWifiConfigStore.setIpConfiguration(mLastNetworkId, dhcpinfointernal);
        java.net.InetAddress inetaddress = NetworkUtils.numericToInetAddress(dhcpinfointernal.ipAddress);
        mWifiInfo.setInetAddress(inetaddress);
        mWifiInfo.setMeteredHint(dhcpinfointernal.hasMeteredHint());
        if(getNetworkDetailedState() == android.net.NetworkInfo.DetailedState.CONNECTED) {
            LinkProperties linkproperties = dhcpinfointernal.makeLinkProperties();
            linkproperties.setHttpProxy(mWifiConfigStore.getProxyProperties(mLastNetworkId));
            linkproperties.setInterfaceName(mInterfaceName);
            if(!linkproperties.equals(mLinkProperties)) {
                mLinkProperties = linkproperties;
                sendLinkConfigurationChangedBroadcast();
            }
        } else {
            configureLinkProperties();
        }
        return;
        exception;
        dhcpinfointernal1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private SupplicantState handleSupplicantStateChange(Message message) {
        StateChangeResult statechangeresult = (StateChangeResult)message.obj;
        SupplicantState supplicantstate = statechangeresult.state;
        EventLog.writeEvent(50023, supplicantstate.ordinal());
        mWifiInfo.setSupplicantState(supplicantstate);
        if(SupplicantState.isConnecting(supplicantstate))
            mWifiInfo.setNetworkId(statechangeresult.networkId);
        else
            mWifiInfo.setNetworkId(-1);
        if(supplicantstate == SupplicantState.ASSOCIATING)
            mWifiInfo.setBSSID(statechangeresult.BSSID);
        mWifiInfo.setSSID(statechangeresult.SSID);
        mSupplicantStateTracker.sendMessage(Message.obtain(message));
        return supplicantstate;
    }

    private boolean isWifiTethered(ArrayList arraylist) {
        String as[];
        Iterator iterator;
        checkAndSetConnectivityInstance();
        as = mCm.getTetherableWifiRegexs();
        iterator = arraylist.iterator();
_L2:
        String s;
        int i;
        int j;
        if(!iterator.hasNext())
            break MISSING_BLOCK_LABEL_75;
        s = (String)iterator.next();
        i = as.length;
        j = 0;
_L5:
        if(j >= i) goto _L2; else goto _L1
_L1:
        if(!s.matches(as[j])) goto _L4; else goto _L3
_L3:
        boolean flag = true;
_L6:
        return flag;
_L4:
        j++;
          goto _L5
        flag = false;
          goto _L6
    }

    private void log(String s) {
        Log.d("WifiStateMachine", s);
    }

    private void loge(String s) {
        Log.e("WifiStateMachine", s);
    }

    private Message obtainMessageWithArg2(Message message) {
        Message message1 = Message.obtain();
        message1.arg2 = message.arg2;
        return message1;
    }

    private ScanResult parseScanResult(String s) {
        ScanResult scanresult = null;
        if(s == null) goto _L2; else goto _L1
_L1:
        LruCache lrucache = mScanResultCache;
        lrucache;
        JVM INSTR monitorenter ;
        String as[] = scanResultPattern.split(s);
        if(3 > as.length || as.length > 5) goto _L4; else goto _L3
_L3:
        String s1 = as[0];
        int i;
        int k;
        i = Integer.parseInt(as[1]);
        k = Integer.parseInt(as[2]);
        int j;
        j = k;
        if(j > 0)
            j -= 256;
_L16:
        if(as.length != 4) goto _L6; else goto _L5
_L5:
        if(as[3].charAt(0) != '[') goto _L8; else goto _L7
_L7:
        String s2;
        String s3;
        s2 = as[3];
        s3 = "";
_L11:
        String s4;
        ScanResult scanresult1;
        s4 = (new StringBuilder()).append(s1).append(s3).toString();
        scanresult1 = (ScanResult)mScanResultCache.get(s4);
        if(scanresult1 == null) goto _L10; else goto _L9
_L9:
        scanresult1.level = j;
        scanresult1.SSID = s3;
        scanresult1.capabilities = s2;
        scanresult1.frequency = i;
        scanresult = scanresult1;
_L14:
        lrucache;
        JVM INSTR monitorexit ;
          goto _L2
_L8:
        s2 = "";
        s3 = as[3];
          goto _L11
_L6:
        if(as.length == 5) {
            s2 = as[3];
            s3 = as[4];
        } else {
            s2 = "";
            s3 = "";
        }
          goto _L11
_L10:
        if(s3.trim().length() <= 0) goto _L13; else goto _L12
_L12:
        scanresult = new ScanResult(s3, s1, s2, j, i);
        mScanResultCache.put(s4, scanresult);
          goto _L14
_L15:
        lrucache;
        JVM INSTR monitorexit ;
        Exception exception;
        throw exception;
_L4:
        loge((new StringBuilder()).append("Misformatted scan result text with ").append(as.length).append(" fields: ").append(s).toString());
          goto _L14
        exception;
          goto _L15
_L13:
        scanresult = scanresult1;
          goto _L14
_L2:
        return scanresult;
        NumberFormatException numberformatexception;
        numberformatexception;
        i = 0;
        j = 0;
          goto _L16
        exception;
          goto _L15
    }

    private void replyToMessage(Message message, int i) {
        if(message.replyTo != null) {
            Message message1 = obtainMessageWithArg2(message);
            message1.what = i;
            mReplyChannel.replyToMessage(message, message1);
        }
    }

    private void replyToMessage(Message message, int i, int j) {
        if(message.replyTo != null) {
            Message message1 = obtainMessageWithArg2(message);
            message1.what = i;
            message1.arg1 = j;
            mReplyChannel.replyToMessage(message, message1);
        }
    }

    private void replyToMessage(Message message, int i, Object obj) {
        if(message.replyTo != null) {
            Message message1 = obtainMessageWithArg2(message);
            message1.what = i;
            message1.obj = obj;
            mReplyChannel.replyToMessage(message, message1);
        }
    }

    private void sendLinkConfigurationChangedBroadcast() {
        Intent intent = new Intent("android.net.wifi.LINK_CONFIGURATION_CHANGED");
        intent.addFlags(0x8000000);
        intent.putExtra("linkProperties", new LinkProperties(mLinkProperties));
        mContext.sendBroadcast(intent);
    }

    private void sendNetworkStateChangeBroadcast(String s) {
        Intent intent = new Intent("android.net.wifi.STATE_CHANGE");
        intent.addFlags(0x8000000);
        intent.putExtra("networkInfo", new NetworkInfo(mNetworkInfo));
        intent.putExtra("linkProperties", new LinkProperties(mLinkProperties));
        if(s != null)
            intent.putExtra("bssid", s);
        if(mNetworkInfo.getDetailedState() == android.net.NetworkInfo.DetailedState.VERIFYING_POOR_LINK || mNetworkInfo.getDetailedState() == android.net.NetworkInfo.DetailedState.CONNECTED)
            intent.putExtra("wifiInfo", new WifiInfo(mWifiInfo));
        mContext.sendStickyBroadcast(intent);
    }

    private void sendRssiChangeBroadcast(int i) {
        Intent intent = new Intent("android.net.wifi.RSSI_CHANGED");
        intent.addFlags(0x8000000);
        intent.putExtra("newRssi", i);
        mContext.sendBroadcast(intent);
    }

    private void sendScanResultsAvailableBroadcast() {
        Intent intent = new Intent("android.net.wifi.SCAN_RESULTS");
        intent.addFlags(0x8000000);
        mContext.sendBroadcast(intent);
    }

    private void sendSupplicantConnectionChangedBroadcast(boolean flag) {
        Intent intent = new Intent("android.net.wifi.supplicant.CONNECTION_CHANGE");
        intent.addFlags(0x8000000);
        intent.putExtra("connected", flag);
        mContext.sendBroadcast(intent);
    }

    private void setCountryCode() {
        String s = android.provider.Settings.Secure.getString(mContext.getContentResolver(), "wifi_country_code");
        if(s != null && !s.isEmpty())
            setCountryCode(s, false);
    }

    private void setFrequencyBand() {
        setFrequencyBand(android.provider.Settings.Secure.getInt(mContext.getContentResolver(), "wifi_frequency_band", 0), false);
    }

    private void setNetworkDetailedState(android.net.NetworkInfo.DetailedState detailedstate) {
        if(detailedstate != mNetworkInfo.getDetailedState())
            mNetworkInfo.setDetailedState(detailedstate, null, null);
    }

    private void setScanResults(String s) {
        if(s != null) {
            ArrayList arraylist = new ArrayList();
            int i = 0;
            int j = s.length();
            int k = 0;
            int l = 0;
            while(l <= j)  {
                if(l == j || s.charAt(l) == '\n')
                    if(++i == 1) {
                        k = l + 1;
                    } else {
                        if(l > k) {
                            ScanResult scanresult = parseScanResult(s.substring(k, l));
                            if(scanresult != null)
                                arraylist.add(scanresult);
                        }
                        k = l + 1;
                    }
                l++;
            }
            mScanResults = arraylist;
        }
    }

    private void setWifiApState(int i) {
label0:
        {
            {
                int j = mWifiApState.get();
                if(i != 13)
                    break label0;
                Intent intent;
                try {
                    mBatteryStats.noteWifiOn();
                }
                catch(RemoteException remoteexception) {
                    loge("Failed to note battery stats in wifi");
                }
            }
            mWifiApState.set(i);
            intent = new Intent("android.net.wifi.WIFI_AP_STATE_CHANGED");
            intent.addFlags(0x8000000);
            intent.putExtra("wifi_state", i);
            intent.putExtra("previous_wifi_state", j);
            mContext.sendStickyBroadcast(intent);
            return;
        }
        if(i != 11)
            break MISSING_BLOCK_LABEL_23;
        mBatteryStats.noteWifiOff();
        break MISSING_BLOCK_LABEL_23;
    }

    private void setWifiState(int i) {
label0:
        {
            {
                int j = mWifiState.get();
                if(i != 3)
                    break label0;
                Intent intent;
                try {
                    mBatteryStats.noteWifiOn();
                }
                catch(RemoteException remoteexception) {
                    loge("Failed to note battery stats in wifi");
                }
            }
            mWifiState.set(i);
            intent = new Intent("android.net.wifi.WIFI_STATE_CHANGED");
            intent.addFlags(0x8000000);
            intent.putExtra("wifi_state", i);
            intent.putExtra("previous_wifi_state", j);
            mContext.sendStickyBroadcast(intent);
            return;
        }
        if(i != 1)
            break MISSING_BLOCK_LABEL_22;
        mBatteryStats.noteWifiOff();
        break MISSING_BLOCK_LABEL_22;
    }

    private void startSoftApWithConfig(final WifiConfiguration config) {
        (new Thread(new Runnable() {

            public void run() {
                mNwService.startAccessPoint(config, mInterfaceName, "wl0.1");
_L1:
                sendMessage(0x20016);
_L2:
                return;
                Exception exception;
                exception;
                loge((new StringBuilder()).append("Exception in softap start ").append(exception).toString());
                mNwService.stopAccessPoint(mInterfaceName);
                mNwService.startAccessPoint(config, mInterfaceName, "wl0.1");
                  goto _L1
                Exception exception1;
                exception1;
                loge((new StringBuilder()).append("Exception in softap re-start ").append(exception1).toString());
                sendMessage(0x20017);
                  goto _L2
            }

            final WifiStateMachine this$0;
            final WifiConfiguration val$config;

             {
                this$0 = WifiStateMachine.this;
                config = wificonfiguration;
                super();
            }
        })).start();
    }

    private boolean startTethering(ArrayList arraylist) {
        boolean flag;
        String as[];
        Iterator iterator;
        flag = false;
        checkAndSetConnectivityInstance();
        as = mCm.getTetherableWifiRegexs();
        iterator = arraylist.iterator();
_L8:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        String s;
        int i;
        int j;
        s = (String)iterator.next();
        i = as.length;
        j = 0;
_L6:
        if(j >= i)
            continue; /* Loop/switch isn't completed */
        if(!s.matches(as[j])) goto _L4; else goto _L3
_L3:
        InterfaceConfiguration interfaceconfiguration = mNwService.getInterfaceConfig(s);
        if(interfaceconfiguration != null) {
            interfaceconfiguration.setLinkAddress(new LinkAddress(NetworkUtils.numericToInetAddress("192.168.43.1"), 24));
            interfaceconfiguration.setInterfaceUp();
            mNwService.setInterfaceConfig(s, interfaceconfiguration);
        }
        Exception exception;
        if(mCm.tether(s) != 0) {
            loge((new StringBuilder()).append("Error tethering on ").append(s).toString());
        } else {
            mTetherInterfaceName = s;
            flag = true;
        }
_L2:
        return flag;
        exception;
        loge((new StringBuilder()).append("Error configuring interface ").append(s).append(", :").append(exception).toString());
        if(true) goto _L2; else goto _L4
_L4:
        j++;
        if(true) goto _L6; else goto _L5
_L5:
        if(true) goto _L8; else goto _L7
_L7:
    }

    private void stopTethering() {
        checkAndSetConnectivityInstance();
        try {
            InterfaceConfiguration interfaceconfiguration = mNwService.getInterfaceConfig(mInterfaceName);
            if(interfaceconfiguration != null) {
                interfaceconfiguration.setLinkAddress(new LinkAddress(NetworkUtils.numericToInetAddress("0.0.0.0"), 0));
                mNwService.setInterfaceConfig(mInterfaceName, interfaceconfiguration);
            }
        }
        catch(Exception exception) {
            loge((new StringBuilder()).append("Error resetting interface ").append(mInterfaceName).append(", :").append(exception).toString());
        }
        if(mCm.untether(mTetherInterfaceName) != 0)
            loge("Untether initiate failed!");
    }

    public void addToBlacklist(String s) {
        sendMessage(obtainMessage(0x20038, s));
    }

    public void clearBlacklist() {
        sendMessage(obtainMessage(0x20039));
    }

    public void disconnectCommand() {
        sendMessage(0x2004a);
    }

    public void enableAllNetworks() {
        sendMessage(0x20037);
    }

    public void enableBackgroundScanCommand(boolean flag) {
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        sendMessage(obtainMessage(0x2005b, i, 0));
    }

    public void enableRssiPolling(boolean flag) {
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        sendMessage(obtainMessage(0x20052, i, 0));
    }

    public String getConfigFile() {
        return mWifiConfigStore.getConfigFile();
    }

    public int getFrequencyBand() {
        return mFrequencyBand.get();
    }

    public Messenger getMessenger() {
        return new Messenger(getHandler());
    }

    void handlePostDhcpSetup() {
        mPowerSaveEnabled = true;
        mWifiNative.setPowerSave(mPowerSaveEnabled);
        WifiNative wifinative = mWifiNative;
        WifiNative _tmp = mWifiNative;
        wifinative.setBluetoothCoexistenceMode(2);
    }

    void handlePreDhcpSetup() {
        if(!mBluetoothConnectionActive) {
            WifiNative wifinative = mWifiNative;
            WifiNative _tmp = mWifiNative;
            wifinative.setBluetoothCoexistenceMode(1);
        }
        if(mPowerSaveEnabled) {
            mPowerSaveEnabled = false;
            mWifiNative.setPowerSave(mPowerSaveEnabled);
        }
    }

    public void reassociateCommand() {
        sendMessage(0x2004c);
    }

    public void reconnectCommand() {
        sendMessage(0x2004b);
    }

    protected boolean recordProcessedMessage(Message message) {
        boolean flag = false;
        if(getCurrentState() != mConnectedState && getCurrentState() != mDisconnectedState) goto _L2; else goto _L1
_L1:
        message.what;
        JVM INSTR lookupswitch 9: default 112
    //                   131073: 178
    //                   131083: 178
    //                   131085: 178
    //                   131127: 178
    //                   131144: 178
    //                   131149: 178
    //                   131158: 178
    //                   131159: 178
    //                   131163: 178;
           goto _L2 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3
_L2:
        switch(message.what) {
        default:
            flag = true;
            break;

        case 131090: 
        case 131143: 
        case 131154: 
        case 131155: 
        case 135191: 
        case 147461: 
            break;
        }
_L3:
        return flag;
    }

    public void sendBluetoothAdapterStateChange(int i) {
        sendMessage(obtainMessage(0x2001f, i, 0));
    }

    public void setCountryCode(String s, boolean flag) {
        if(flag)
            android.provider.Settings.Secure.putString(mContext.getContentResolver(), "wifi_country_code", s);
        sendMessage(obtainMessage(0x20050, s));
    }

    public void setDriverStart(boolean flag, boolean flag1) {
        if(flag) {
            sendMessage(0x2000d);
        } else {
            int i;
            if(flag1)
                i = 1;
            else
                i = 0;
            sendMessage(obtainMessage(0x2000e, i, 0));
        }
    }

    public void setFrequencyBand(int i, boolean flag) {
        if(flag)
            android.provider.Settings.Secure.putInt(mContext.getContentResolver(), "wifi_frequency_band", i);
        sendMessage(obtainMessage(0x2005a, i, 0));
    }

    public void setHighPerfModeEnabled(boolean flag) {
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        sendMessage(obtainMessage(0x2004d, i, 0));
    }

    public void setScanOnlyMode(boolean flag) {
        if(flag)
            sendMessage(obtainMessage(0x20048, 2, 0));
        else
            sendMessage(obtainMessage(0x20048, 1, 0));
    }

    public void setScanType(boolean flag) {
        if(flag)
            sendMessage(obtainMessage(0x20049, 1, 0));
        else
            sendMessage(obtainMessage(0x20049, 2, 0));
    }

    public void setWifiApConfiguration(WifiConfiguration wificonfiguration) {
        mWifiApConfigChannel.sendMessage(0x20019, wificonfiguration);
    }

    public void setWifiApEnabled(WifiConfiguration wificonfiguration, boolean flag) {
        mLastApEnableUid.set(Binder.getCallingUid());
        if(flag) {
            sendMessage(obtainMessage(0x20001, 12, 0));
            sendMessage(obtainMessage(0x20015, wificonfiguration));
        } else {
            sendMessage(0x20018);
            sendMessage(obtainMessage(0x20002, 11, 0));
        }
    }

    public void setWifiEnabled(boolean flag) {
        mLastEnableUid.set(Binder.getCallingUid());
        if(flag) {
            sendMessage(obtainMessage(0x20001, 2, 0));
            sendMessage(0x2000b);
        } else {
            sendMessage(0x2000c);
            sendMessage(obtainMessage(0x20002, 1, 0));
        }
    }

    public void startFilteringMulticastV4Packets() {
        mFilteringMulticastV4Packets.set(true);
        sendMessage(obtainMessage(0x20054, 0, 0));
    }

    public void startFilteringMulticastV6Packets() {
        sendMessage(obtainMessage(0x20054, 1, 0));
    }

    public void startScan(boolean flag) {
        int i;
        if(flag)
            i = 1;
        else
            i = 2;
        sendMessage(obtainMessage(0x20047, i, 0));
    }

    public void stopFilteringMulticastV4Packets() {
        mFilteringMulticastV4Packets.set(false);
        sendMessage(obtainMessage(0x20055, 0, 0));
    }

    public void stopFilteringMulticastV6Packets() {
        sendMessage(obtainMessage(0x20055, 1, 0));
    }

    public int syncAddOrUpdateNetwork(AsyncChannel asyncchannel, WifiConfiguration wificonfiguration) {
        Message message = asyncchannel.sendMessageSynchronously(0x20034, wificonfiguration);
        int i = message.arg1;
        message.recycle();
        return i;
    }

    public boolean syncDisableNetwork(AsyncChannel asyncchannel, int i) {
        Message message = asyncchannel.sendMessageSynchronously(0x25011, i);
        boolean flag;
        if(message.arg1 != 0x25012)
            flag = true;
        else
            flag = false;
        message.recycle();
        return flag;
    }

    public boolean syncEnableNetwork(AsyncChannel asyncchannel, int i, boolean flag) {
        int j;
        Message message;
        boolean flag1;
        if(flag)
            j = 1;
        else
            j = 0;
        message = asyncchannel.sendMessageSynchronously(0x20036, i, j);
        if(message.arg1 != -1)
            flag1 = true;
        else
            flag1 = false;
        message.recycle();
        return flag1;
    }

    public List syncGetConfiguredNetworks(AsyncChannel asyncchannel) {
        Message message = asyncchannel.sendMessageSynchronously(0x2003b);
        List list = (List)message.obj;
        message.recycle();
        return list;
    }

    public DhcpInfo syncGetDhcpInfo() {
        DhcpInfoInternal dhcpinfointernal = mDhcpInfoInternal;
        dhcpinfointernal;
        JVM INSTR monitorenter ;
        DhcpInfo dhcpinfo = mDhcpInfoInternal.makeDhcpInfo();
        return dhcpinfo;
    }

    public List syncGetScanResultsList() {
        return mScanResults;
    }

    public WifiConfiguration syncGetWifiApConfiguration() {
        Message message = mWifiApConfigChannel.sendMessageSynchronously(0x2001b);
        WifiConfiguration wificonfiguration = (WifiConfiguration)message.obj;
        message.recycle();
        return wificonfiguration;
    }

    public int syncGetWifiApState() {
        return mWifiApState.get();
    }

    public String syncGetWifiApStateByName() {
        mWifiApState.get();
        JVM INSTR tableswitch 10 14: default 40
    //                   10 46
    //                   11 53
    //                   12 60
    //                   13 67
    //                   14 74;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        String s = "[invalid state]";
_L8:
        return s;
_L2:
        s = "disabling";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "disabled";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "enabling";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "enabled";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "failed";
        if(true) goto _L8; else goto _L7
_L7:
    }

    public int syncGetWifiState() {
        return mWifiState.get();
    }

    public String syncGetWifiStateByName() {
        mWifiState.get();
        JVM INSTR tableswitch 0 4: default 40
    //                   0 46
    //                   1 53
    //                   2 60
    //                   3 67
    //                   4 74;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        String s = "[invalid state]";
_L8:
        return s;
_L2:
        s = "disabling";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "disabled";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "enabling";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "enabled";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "unknown state";
        if(true) goto _L8; else goto _L7
_L7:
    }

    public boolean syncPingSupplicant(AsyncChannel asyncchannel) {
        Message message = asyncchannel.sendMessageSynchronously(0x20033);
        boolean flag;
        if(message.arg1 != -1)
            flag = true;
        else
            flag = false;
        message.recycle();
        return flag;
    }

    public boolean syncRemoveNetwork(AsyncChannel asyncchannel, int i) {
        Message message = asyncchannel.sendMessageSynchronously(0x20035, i);
        boolean flag;
        if(message.arg1 != -1)
            flag = true;
        else
            flag = false;
        message.recycle();
        return flag;
    }

    public WifiInfo syncRequestConnectionInfo() {
        return mWifiInfo;
    }

    public boolean syncSaveConfig(AsyncChannel asyncchannel) {
        Message message = asyncchannel.sendMessageSynchronously(0x2003a);
        boolean flag;
        if(message.arg1 != -1)
            flag = true;
        else
            flag = false;
        message.recycle();
        return flag;
    }

    public String toString() {
        StringBuffer stringbuffer = new StringBuffer();
        String s = System.getProperty("line.separator");
        stringbuffer.append("current HSM state: ").append(getCurrentState().getName()).append(s);
        stringbuffer.append("mLinkProperties ").append(mLinkProperties).append(s);
        stringbuffer.append("mWifiInfo ").append(mWifiInfo).append(s);
        stringbuffer.append("mDhcpInfoInternal ").append(mDhcpInfoInternal).append(s);
        stringbuffer.append("mNetworkInfo ").append(mNetworkInfo).append(s);
        stringbuffer.append("mLastSignalLevel ").append(mLastSignalLevel).append(s);
        stringbuffer.append("mLastBssid ").append(mLastBssid).append(s);
        stringbuffer.append("mLastNetworkId ").append(mLastNetworkId).append(s);
        stringbuffer.append("mReconnectCount ").append(mReconnectCount).append(s);
        stringbuffer.append("mIsScanMode ").append(mIsScanMode).append(s);
        stringbuffer.append("Supplicant status").append(s).append(mWifiNative.status()).append(s).append(s);
        stringbuffer.append(mWifiConfigStore.dump());
        return stringbuffer.toString();
    }

    public void updateBatteryWorkSource(WorkSource worksource) {
        WorkSource worksource1 = mRunningWifiUids;
        worksource1;
        JVM INSTR monitorenter ;
        if(worksource == null)
            break MISSING_BLOCK_LABEL_19;
        mRunningWifiUids.set(worksource);
        if(!mIsRunning) goto _L2; else goto _L1
_L1:
        if(!mReportedRunning) goto _L4; else goto _L3
_L3:
        if(mLastRunningWifiUids.diff(mRunningWifiUids)) {
            mBatteryStats.noteWifiRunningChanged(mLastRunningWifiUids, mRunningWifiUids);
            mLastRunningWifiUids.set(mRunningWifiUids);
        }
_L5:
        mWakeLock.setWorkSource(worksource);
_L6:
        worksource1;
        JVM INSTR monitorexit ;
        return;
_L4:
        mBatteryStats.noteWifiRunning(mRunningWifiUids);
        mLastRunningWifiUids.set(mRunningWifiUids);
        mReportedRunning = true;
          goto _L5
_L2:
        if(mReportedRunning) {
            mBatteryStats.noteWifiStopped(mLastRunningWifiUids);
            mLastRunningWifiUids.clear();
            mReportedRunning = false;
        }
          goto _L5
        Exception exception;
        exception;
        worksource1;
        JVM INSTR monitorexit ;
        throw exception;
        RemoteException remoteexception;
        remoteexception;
          goto _L6
    }

    private static final String ACTION_DELAYED_DRIVER_STOP = "com.android.server.WifiManager.action.DELAYED_DRIVER_STOP";
    private static final String ACTION_START_SCAN = "com.android.server.WifiManager.action.START_SCAN";
    static final int BASE = 0x20000;
    static final int CMD_ADD_OR_UPDATE_NETWORK = 0x20034;
    static final int CMD_BLACKLIST_NETWORK = 0x20038;
    static final int CMD_BLUETOOTH_ADAPTER_STATE_CHANGE = 0x2001f;
    static final int CMD_CLEAR_BLACKLIST = 0x20039;
    static final int CMD_CLEAR_SUSPEND_OPTIMIZATIONS = 0x20057;
    static final int CMD_DELAYED_STOP_DRIVER = 0x20012;
    public static final int CMD_DISABLE_P2P = 0x20084;
    static final int CMD_DISCONNECT = 0x2004a;
    static final int CMD_DRIVER_START_TIMED_OUT = 0x20013;
    static final int CMD_ENABLE_ALL_NETWORKS = 0x20037;
    static final int CMD_ENABLE_BACKGROUND_SCAN = 0x2005b;
    static final int CMD_ENABLE_NETWORK = 0x20036;
    public static final int CMD_ENABLE_P2P = 0x20083;
    static final int CMD_ENABLE_RSSI_POLL = 0x20052;
    static final int CMD_GET_CONFIGURED_NETWORKS = 0x2003b;
    static final int CMD_LOAD_DRIVER = 0x20001;
    static final int CMD_LOAD_DRIVER_FAILURE = 0x20004;
    static final int CMD_LOAD_DRIVER_SUCCESS = 0x20003;
    static final int CMD_NO_NETWORKS_PERIODIC_SCAN = 0x20058;
    static final int CMD_PING_SUPPLICANT = 0x20033;
    static final int CMD_REASSOCIATE = 0x2004c;
    static final int CMD_RECONNECT = 0x2004b;
    static final int CMD_REMOVE_NETWORK = 0x20035;
    static final int CMD_REQUEST_AP_CONFIG = 0x2001b;
    static final int CMD_RESET_SUPPLICANT_STATE = 0x2006f;
    static final int CMD_RESPONSE_AP_CONFIG = 0x2001c;
    static final int CMD_RSSI_POLL = 0x20053;
    static final int CMD_SAVE_CONFIG = 0x2003a;
    static final int CMD_SET_AP_CONFIG = 0x20019;
    static final int CMD_SET_AP_CONFIG_COMPLETED = 0x2001a;
    static final int CMD_SET_COUNTRY_CODE = 0x20050;
    static final int CMD_SET_FREQUENCY_BAND = 0x2005a;
    static final int CMD_SET_HIGH_PERF_MODE = 0x2004d;
    static final int CMD_SET_SCAN_MODE = 0x20048;
    static final int CMD_SET_SCAN_TYPE = 0x20049;
    static final int CMD_SET_SUSPEND_OPTIMIZATIONS = 0x20056;
    static final int CMD_START_AP = 0x20015;
    static final int CMD_START_AP_FAILURE = 0x20017;
    static final int CMD_START_AP_SUCCESS = 0x20016;
    static final int CMD_START_DRIVER = 0x2000d;
    static final int CMD_START_PACKET_FILTERING = 0x20054;
    static final int CMD_START_SCAN = 0x20047;
    static final int CMD_START_SUPPLICANT = 0x2000b;
    static final int CMD_STATIC_IP_FAILURE = 0x20010;
    static final int CMD_STATIC_IP_SUCCESS = 0x2000f;
    static final int CMD_STOP_AP = 0x20018;
    static final int CMD_STOP_DRIVER = 0x2000e;
    static final int CMD_STOP_PACKET_FILTERING = 0x20055;
    static final int CMD_STOP_SUPPLICANT = 0x2000c;
    static final int CMD_STOP_SUPPLICANT_FAILED = 0x20011;
    static final int CMD_TETHER_NOTIFICATION_TIMED_OUT = 0x2001e;
    static final int CMD_TETHER_STATE_CHANGE = 0x2001d;
    static final int CMD_UNLOAD_DRIVER = 0x20002;
    static final int CMD_UNLOAD_DRIVER_FAILURE = 0x20006;
    static final int CMD_UNLOAD_DRIVER_SUCCESS = 0x20005;
    private static final int CONNECT_MODE = 1;
    private static final boolean DBG = false;
    private static final int DEFAULT_MAX_DHCP_RETRIES = 9;
    private static final String DELAYED_STOP_COUNTER = "DelayedStopCounter";
    private static final int DRIVER_START_TIME_OUT_MSECS = 10000;
    private static final int DRIVER_STOP_REQUEST = 0;
    private static final int EVENTLOG_SUPPLICANT_STATE_CHANGED = 50023;
    private static final int EVENTLOG_WIFI_EVENT_HANDLED = 50022;
    private static final int EVENTLOG_WIFI_STATE_CHANGED = 50021;
    private static final int FAILURE = -1;
    private static final int IN_ECM_STATE = 1;
    private static final int MAX_RSSI = 256;
    private static final int MIN_INTERVAL_ENABLE_ALL_NETWORKS_MS = 0x927c0;
    private static final int MIN_RSSI = -200;
    static final int MULTICAST_V4 = 0;
    static final int MULTICAST_V6 = 1;
    private static final String NETWORKTYPE = "WIFI";
    private static final int NOT_IN_ECM_STATE = 0;
    private static final int POLL_RSSI_INTERVAL_MSECS = 3000;
    private static final int SCAN_ACTIVE = 1;
    private static final int SCAN_ONLY_MODE = 2;
    private static final int SCAN_PASSIVE = 2;
    private static final int SCAN_REQUEST = 0;
    private static final int SCAN_RESULT_CACHE_SIZE = 80;
    private static final String SOFTAP_IFACE = "wl0.1";
    private static final int SUCCESS = 1;
    private static final int SUPPLICANT_RESTART_INTERVAL_MSECS = 5000;
    private static final int SUPPLICANT_RESTART_TRIES = 5;
    private static final String TAG = "WifiStateMachine";
    private static final int TETHER_NOTIFICATION_TIME_OUT_MSECS = 5000;
    private static final Pattern scanResultPattern = Pattern.compile("\t+");
    private AlarmManager mAlarmManager;
    private final boolean mBackgroundScanSupported;
    private final IBatteryStats mBatteryStats = com.android.internal.app.IBatteryStats.Stub.asInterface(ServiceManager.getService("batteryinfo"));
    private boolean mBluetoothConnectionActive;
    private ConnectivityManager mCm;
    private State mConnectModeState;
    private State mConnectedState;
    private Context mContext;
    private final int mDefaultFrameworkScanIntervalMs;
    private State mDefaultState;
    private int mDelayedStopCounter;
    private DhcpInfoInternal mDhcpInfoInternal;
    private DhcpStateMachine mDhcpStateMachine;
    private State mDisconnectedState;
    private State mDisconnectingState;
    private State mDriverFailedState;
    private State mDriverLoadedState;
    private State mDriverLoadingState;
    private int mDriverStartToken;
    private State mDriverStartedState;
    private State mDriverStartingState;
    private final int mDriverStopDelayMs;
    private PendingIntent mDriverStopIntent;
    private State mDriverStoppedState;
    private State mDriverStoppingState;
    private State mDriverUnloadedState;
    private State mDriverUnloadingState;
    private boolean mEnableBackgroundScan;
    private boolean mEnableRssiPolling;
    private AtomicBoolean mFilteringMulticastV4Packets;
    private AtomicInteger mFrequencyBand;
    private boolean mHighPerfMode;
    private boolean mInDelayedStop;
    private State mInitialState;
    private String mInterfaceName;
    private boolean mIsRunning;
    private boolean mIsScanMode;
    private State mL2ConnectedState;
    private final AtomicInteger mLastApEnableUid = new AtomicInteger(Process.myUid());
    private String mLastBssid;
    private long mLastEnableAllNetworksTime;
    private final AtomicInteger mLastEnableUid = new AtomicInteger(Process.myUid());
    private int mLastNetworkId;
    private final WorkSource mLastRunningWifiUids = new WorkSource();
    private int mLastSignalLevel;
    private LinkProperties mLinkProperties;
    private NetworkInfo mNetworkInfo;
    private INetworkManagementService mNwService;
    private State mObtainingIpState;
    private final boolean mP2pSupported;
    private int mPeriodicScanToken;
    private boolean mPowerSaveEnabled;
    private final String mPrimaryDeviceType;
    private int mReconnectCount;
    private AsyncChannel mReplyChannel;
    private boolean mReportedRunning;
    private int mRssiPollToken;
    private final WorkSource mRunningWifiUids = new WorkSource();
    private PendingIntent mScanIntent;
    private State mScanModeState;
    private final LruCache mScanResultCache = new LruCache(80);
    private boolean mScanResultIsPending;
    private List mScanResults;
    private IntentFilter mScreenFilter;
    private BroadcastReceiver mScreenReceiver;
    private boolean mSetScanActive;
    private State mSoftApStartedState;
    private State mSoftApStartingState;
    private State mSoftApStoppingState;
    private int mSupplicantRestartCount;
    private long mSupplicantScanIntervalMs;
    private State mSupplicantStartedState;
    private State mSupplicantStartingState;
    private SupplicantStateTracker mSupplicantStateTracker;
    private int mSupplicantStopFailureToken;
    private State mSupplicantStoppingState;
    private android.os.PowerManager.WakeLock mSuspendWakeLock;
    private String mTetherInterfaceName;
    private int mTetherToken;
    private State mTetheredState;
    private State mTetheringState;
    private State mVerifyingLinkState;
    private android.os.PowerManager.WakeLock mWakeLock;
    private AsyncChannel mWifiApConfigChannel;
    private final AtomicInteger mWifiApState = new AtomicInteger(11);
    private WifiConfigStore mWifiConfigStore;
    private WifiInfo mWifiInfo;
    private WifiMonitor mWifiMonitor;
    private WifiNative mWifiNative;
    private AsyncChannel mWifiP2pChannel;
    private WifiP2pManager mWifiP2pManager;
    private final AtomicInteger mWifiState = new AtomicInteger(1);
    private State mWpsRunningState;







/*
    static boolean access$1002(WifiStateMachine wifistatemachine, boolean flag) {
        wifistatemachine.mEnableBackgroundScan = flag;
        return flag;
    }

*/













/*
    static boolean access$1102(WifiStateMachine wifistatemachine, boolean flag) {
        wifistatemachine.mHighPerfMode = flag;
        return flag;
    }

*/









/*
    static int access$11708(WifiStateMachine wifistatemachine) {
        int i = wifistatemachine.mRssiPollToken;
        wifistatemachine.mRssiPollToken = i + 1;
        return i;
    }

*/



/*
    static DhcpStateMachine access$11802(WifiStateMachine wifistatemachine, DhcpStateMachine dhcpstatemachine) {
        wifistatemachine.mDhcpStateMachine = dhcpstatemachine;
        return dhcpstatemachine;
    }

*/































/*
    static int access$14404(WifiStateMachine wifistatemachine) {
        int i = 1 + wifistatemachine.mPeriodicScanToken;
        wifistatemachine.mPeriodicScanToken = i;
        return i;
    }

*/























/*
    static int access$16304(WifiStateMachine wifistatemachine) {
        int i = 1 + wifistatemachine.mTetherToken;
        wifistatemachine.mTetherToken = i;
        return i;
    }

*/














/*
    static WifiP2pManager access$1802(WifiStateMachine wifistatemachine, WifiP2pManager wifip2pmanager) {
        wifistatemachine.mWifiP2pManager = wifip2pmanager;
        return wifip2pmanager;
    }

*/






























/*
    static int access$4302(WifiStateMachine wifistatemachine, int i) {
        wifistatemachine.mSupplicantRestartCount = i;
        return i;
    }

*/


/*
    static int access$4304(WifiStateMachine wifistatemachine) {
        int i = 1 + wifistatemachine.mSupplicantRestartCount;
        wifistatemachine.mSupplicantRestartCount = i;
        return i;
    }

*/




/*
    static String access$4502(WifiStateMachine wifistatemachine, String s) {
        wifistatemachine.mLastBssid = s;
        return s;
    }

*/



/*
    static int access$4602(WifiStateMachine wifistatemachine, int i) {
        wifistatemachine.mLastNetworkId = i;
        return i;
    }

*/


/*
    static int access$4702(WifiStateMachine wifistatemachine, int i) {
        wifistatemachine.mLastSignalLevel = i;
        return i;
    }

*/












/*
    static boolean access$5602(WifiStateMachine wifistatemachine, boolean flag) {
        wifistatemachine.mIsScanMode = flag;
        return flag;
    }

*/




/*
    static long access$5802(WifiStateMachine wifistatemachine, long l) {
        wifistatemachine.mSupplicantScanIntervalMs = l;
        return l;
    }

*/





/*
    static boolean access$602(WifiStateMachine wifistatemachine, boolean flag) {
        wifistatemachine.mBluetoothConnectionActive = flag;
        return flag;
    }

*/







/*
    static boolean access$6502(WifiStateMachine wifistatemachine, boolean flag) {
        wifistatemachine.mScanResultIsPending = flag;
        return flag;
    }

*/



/*
    static long access$6602(WifiStateMachine wifistatemachine, long l) {
        wifistatemachine.mLastEnableAllNetworksTime = l;
        return l;
    }

*/



/*
    static int access$6704(WifiStateMachine wifistatemachine) {
        int i = 1 + wifistatemachine.mSupplicantStopFailureToken;
        wifistatemachine.mSupplicantStopFailureToken = i;
        return i;
    }

*/







/*
    static int access$7104(WifiStateMachine wifistatemachine) {
        int i = 1 + wifistatemachine.mDriverStartToken;
        wifistatemachine.mDriverStartToken = i;
        return i;
    }

*/







/*
    static boolean access$7702(WifiStateMachine wifistatemachine, boolean flag) {
        wifistatemachine.mIsRunning = flag;
        return flag;
    }

*/



/*
    static boolean access$7802(WifiStateMachine wifistatemachine, boolean flag) {
        wifistatemachine.mInDelayedStop = flag;
        return flag;
    }

*/
















/*
    static boolean access$9002(WifiStateMachine wifistatemachine, boolean flag) {
        wifistatemachine.mSetScanActive = flag;
        return flag;
    }

*/


/*
    static boolean access$902(WifiStateMachine wifistatemachine, boolean flag) {
        wifistatemachine.mEnableRssiPolling = flag;
        return flag;
    }

*/




/*
    static int access$9208(WifiStateMachine wifistatemachine) {
        int i = wifistatemachine.mDelayedStopCounter;
        wifistatemachine.mDelayedStopCounter = i + 1;
        return i;
    }

*/



/*
    static PendingIntent access$9302(WifiStateMachine wifistatemachine, PendingIntent pendingintent) {
        wifistatemachine.mDriverStopIntent = pendingintent;
        return pendingintent;
    }

*/







/*
    static List access$9902(WifiStateMachine wifistatemachine, List list) {
        wifistatemachine.mScanResults = list;
        return list;
    }

*/
}
