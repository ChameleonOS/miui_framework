// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi.p2p;

import android.app.*;
import android.content.*;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.*;
import android.net.wifi.*;
import android.net.wifi.p2p.nsd.WifiP2pServiceInfo;
import android.net.wifi.p2p.nsd.WifiP2pServiceRequest;
import android.net.wifi.p2p.nsd.WifiP2pServiceResponse;
import android.os.*;
import android.text.TextUtils;
import android.util.Slog;
import android.util.SparseArray;
import android.view.*;
import android.widget.EditText;
import android.widget.TextView;
import com.android.internal.util.*;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.*;

// Referenced classes of package android.net.wifi.p2p:
//            WifiP2pDevice, WifiP2pDeviceList, WifiP2pInfo, WifiP2pConfig, 
//            WifiP2pGroup, WifiP2pProvDiscEvent

public class WifiP2pService extends IWifiP2pManager.Stub {
    private class ClientInfo {

        private Messenger mMessenger;
        private SparseArray mReqList;
        private List mServList;
        final WifiP2pService this$0;




        private ClientInfo(Messenger messenger) {
            this$0 = WifiP2pService.this;
            super();
            mMessenger = messenger;
            mReqList = new SparseArray();
            mServList = new ArrayList();
        }

    }

    private class P2pStateMachine extends StateMachine {
        class UserAuthorizingJoinState extends State {

            public void enter() {
                notifyInvitationReceived();
            }

            public void exit() {
            }

            public boolean processMessage(Message message) {
                message.what;
                JVM INSTR lookupswitch 5: default 56
            //                           143362: 60
            //                           143363: 163
            //                           147489: 121
            //                           147491: 121
            //                           147492: 121;
                   goto _L1 _L2 _L3 _L4 _L4 _L4
_L1:
                boolean flag = false;
_L5:
                return flag;
_L2:
                if(mSavedPeerConfig.wps.setup == 0)
                    mWifiNative.startWpsPbc(mGroup.getInterface(), null);
                else
                    mWifiNative.startWpsPinKeypad(mGroup.getInterface(), mSavedPeerConfig.wps.pin);
                mSavedPeerConfig = null;
                transitionTo(mGroupCreatedState);
_L4:
                flag = true;
                if(true) goto _L5; else goto _L3
_L3:
                mSavedPeerConfig = null;
                transitionTo(mGroupCreatedState);
                  goto _L4
            }

            final P2pStateMachine this$1;

            UserAuthorizingJoinState() {
                this$1 = P2pStateMachine.this;
                super();
            }
        }

        class GroupCreatedState extends State {

            public void enter() {
                mNetworkInfo.setDetailedState(android.net.NetworkInfo.DetailedState.CONNECTED, null, null);
                updateThisDevice(0);
                if(mGroup.isGroupOwner()) {
                    setWifiP2pInfoOnGroupFormation("192.168.49.1");
                    sendP2pConnectionChangedBroadcast();
                }
            }

            public void exit() {
                mSavedProvDiscDevice = null;
                updateThisDevice(3);
                setWifiP2pInfoOnGroupTermination();
                mNetworkInfo.setDetailedState(android.net.NetworkInfo.DetailedState.DISCONNECTED, null, null);
                sendP2pConnectionChangedBroadcast();
            }

            public boolean processMessage(Message message) {
                message.what;
                JVM INSTR lookupswitch 12: default 112
            //                           131204: 808
            //                           139271: 829
            //                           139280: 503
            //                           147478: 774
            //                           147485: 1369
            //                           147486: 553
            //                           147489: 1187
            //                           147491: 1187
            //                           147492: 1187
            //                           147497: 219
            //                           147498: 116
            //                           196613: 404;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L8 _L8 _L9 _L10 _L11
_L6:
                break MISSING_BLOCK_LABEL_1369;
_L1:
                boolean flag = false;
_L12:
                return flag;
_L10:
                String s3 = ((WifiP2pDevice)message.obj).deviceAddress;
                if(s3 != null) {
                    if(mSavedProvDiscDevice != null && s3.equals(mSavedProvDiscDevice.deviceAddress))
                        mSavedProvDiscDevice = null;
                    mGroup.addClient(s3);
                    mPeers.updateStatus(s3, 0);
                    sendP2pPeersChangedBroadcast();
                } else {
                    loge("Connect on null device address, ignore");
                }
_L13:
                flag = true;
                  goto _L12
_L9:
                WifiP2pDevice wifip2pdevice2 = (WifiP2pDevice)message.obj;
                String s2 = wifip2pdevice2.deviceAddress;
                if(s2 != null) {
                    mPeers.updateStatus(s2, 3);
                    if(mGroup.removeClient(s2)) {
                        if(!mAutonomousGroup && mGroup.isClientListEmpty()) {
                            Slog.d("WifiP2pService", "Client list empty, remove non-persistent p2p group");
                            mWifiNative.p2pGroupRemove(mGroup.getInterface());
                        }
                    } else {
                        Iterator iterator1 = mGroup.getClientList().iterator();
                        while(iterator1.hasNext())  {
                            (WifiP2pDevice)iterator1.next();
                        }
                    }
                    sendP2pPeersChangedBroadcast();
                } else {
                    loge((new StringBuilder()).append("Disconnect on unknown device: ").append(wifip2pdevice2).toString());
                }
                  goto _L13
_L11:
                DhcpInfoInternal dhcpinfointernal = (DhcpInfoInternal)message.obj;
                if(message.arg1 == 1 && dhcpinfointernal != null) {
                    setWifiP2pInfoOnGroupFormation(dhcpinfointernal.serverAddress);
                    sendP2pConnectionChangedBroadcast();
                    mWifiNative.setP2pPowerSave(mGroup.getInterface(), true);
                } else {
                    loge("DHCP failed");
                    mWifiNative.p2pGroupRemove(mGroup.getInterface());
                }
                  goto _L13
_L4:
                if(mWifiNative.p2pGroupRemove(mGroup.getInterface()))
                    replyToMessage(message, 0x22012);
                else
                    replyToMessage(message, 0x22011, 0);
                  goto _L13
_L7:
                Collection collection = mGroup.getClientList();
                boolean flag1 = false;
                Iterator iterator = mPeers.getDeviceList().iterator();
                do {
                    if(!iterator.hasNext())
                        break;
                    WifiP2pDevice wifip2pdevice1 = (WifiP2pDevice)iterator.next();
                    if(collection.contains(wifip2pdevice1) || mGroup.getOwner().equals(wifip2pdevice1)) {
                        wifip2pdevice1.status = 3;
                        flag1 = true;
                    }
                } while(true);
                if(mGroup.isGroupOwner()) {
                    stopDhcpServer();
                } else {
                    mDhcpStateMachine.sendMessage(0x30002);
                    mDhcpStateMachine.quit();
                    mDhcpStateMachine = null;
                }
                mGroup = null;
                mWifiNative.p2pFlush();
                mServiceDiscReqId = null;
                if(flag1)
                    sendP2pPeersChangedBroadcast();
                transitionTo(mInactiveState);
                  goto _L13
_L5:
                WifiP2pDevice wifip2pdevice = (WifiP2pDevice)message.obj;
                if(mGroup.contains(wifip2pdevice))
                    flag = true;
                else
                    flag = false;
                  goto _L12
_L2:
                sendMessage(0x22010);
                deferMessage(message);
                  goto _L13
_L3:
                WifiP2pConfig wifip2pconfig = (WifiP2pConfig)message.obj;
                if(wifip2pconfig.deviceAddress == null || mSavedProvDiscDevice != null && mSavedProvDiscDevice.deviceAddress.equals(wifip2pconfig.deviceAddress)) {
                    if(wifip2pconfig.wps.setup == 0)
                        mWifiNative.startWpsPbc(mGroup.getInterface(), null);
                    else
                    if(wifip2pconfig.wps.pin == null) {
                        String s = mWifiNative.startWpsPinDisplay(mGroup.getInterface());
                        WifiP2pProvDiscEvent wifip2pprovdiscevent;
                        try {
                            Integer.parseInt(s);
                            if(!sendShowPinReqToFrontApp(s)) {
                                P2pStateMachine p2pstatemachine = P2pStateMachine.this;
                                String s1;
                                if(wifip2pconfig.deviceAddress != null)
                                    s1 = wifip2pconfig.deviceAddress;
                                else
                                    s1 = "any";
                                p2pstatemachine.notifyInvitationSent(s, s1);
                            }
                        }
                        catch(NumberFormatException numberformatexception) { }
                    } else {
                        mWifiNative.startWpsPinKeypad(mGroup.getInterface(), wifip2pconfig.wps.pin);
                    }
                    if(wifip2pconfig.deviceAddress != null) {
                        mPeers.updateStatus(wifip2pconfig.deviceAddress, 1);
                        sendP2pPeersChangedBroadcast();
                    }
                    replyToMessage(message, 0x22009);
                } else {
                    logd((new StringBuilder()).append("Inviting device : ").append(wifip2pconfig.deviceAddress).toString());
                    if(mWifiNative.p2pInvite(mGroup, wifip2pconfig.deviceAddress)) {
                        mPeers.updateStatus(wifip2pconfig.deviceAddress, 1);
                        sendP2pPeersChangedBroadcast();
                        replyToMessage(message, 0x22009);
                    } else {
                        replyToMessage(message, 0x22008, 0);
                    }
                }
                  goto _L13
_L8:
                wifip2pprovdiscevent = (WifiP2pProvDiscEvent)message.obj;
                mSavedProvDiscDevice = wifip2pprovdiscevent.device;
                mSavedPeerConfig = new WifiP2pConfig();
                mSavedPeerConfig.deviceAddress = wifip2pprovdiscevent.device.deviceAddress;
                if(message.what == 0x24023)
                    mSavedPeerConfig.wps.setup = 2;
                else
                if(message.what == 0x24024) {
                    mSavedPeerConfig.wps.setup = 1;
                    mSavedPeerConfig.wps.pin = wifip2pprovdiscevent.pin;
                } else {
                    mSavedPeerConfig.wps.setup = 0;
                }
                if(!sendConnectNoticeToApp(mSavedProvDiscDevice, mSavedPeerConfig))
                    transitionTo(mUserAuthorizingJoinState);
                  goto _L13
                Slog.e("WifiP2pService", "Duplicate group creation event notice, ignore");
                  goto _L13
            }

            final P2pStateMachine this$1;

            GroupCreatedState() {
                this$1 = P2pStateMachine.this;
                super();
            }
        }

        class GroupNegotiationState extends State {

            public void enter() {
            }

            public boolean processMessage(Message message) {
                message.what;
                JVM INSTR tableswitch 147481 147486: default 44
            //                           147481 116
            //                           147482 234
            //                           147483 116
            //                           147484 116
            //                           147485 48
            //                           147486 234;
                   goto _L1 _L2 _L3 _L2 _L2 _L4 _L3
_L1:
                boolean flag = false;
_L5:
                return flag;
_L4:
                mGroup = (WifiP2pGroup)message.obj;
                if(mGroup.isGroupOwner()) {
                    startDhcpServer(mGroup.getInterface());
                } else {
                    mWifiNative.setP2pGroupIdle(mGroup.getInterface(), 2);
                    mDhcpStateMachine = DhcpStateMachine.makeDhcpStateMachine(mContext, P2pStateMachine.this, mGroup.getInterface());
                    mDhcpStateMachine.sendMessage(0x30001);
                    WifiP2pDevice wifip2pdevice = mGroup.getOwner();
                    mPeers.updateStatus(wifip2pdevice.deviceAddress, 0);
                    sendP2pPeersChangedBroadcast();
                }
                mSavedPeerConfig = null;
                transitionTo(mGroupCreatedState);
_L2:
                flag = true;
                if(true) goto _L5; else goto _L3
_L3:
                handleGroupCreationFailure();
                transitionTo(mInactiveState);
                  goto _L2
            }

            final P2pStateMachine this$1;

            GroupNegotiationState() {
                this$1 = P2pStateMachine.this;
                super();
            }
        }

        class ProvisionDiscoveryState extends State {

            public void enter() {
                mWifiNative.p2pProvisionDiscovery(mSavedPeerConfig);
            }

            public boolean processMessage(Message message) {
                boolean flag = false;
                message.what;
                JVM INSTR tableswitch 147490 147492: default 32
            //                           147490 34
            //                           147491 125
            //                           147492 260;
                   goto _L1 _L2 _L3 _L4
_L1:
                return flag;
_L6:
                do
                    flag = true;
                while(false);
_L2:
                if(((WifiP2pProvDiscEvent)message.obj).device.deviceAddress.equals(mSavedPeerConfig.deviceAddress) && mSavedPeerConfig.wps.setup == 0) {
                    mWifiNative.p2pConnect(mSavedPeerConfig, WifiP2pService.FORM_GROUP.booleanValue());
                    transitionTo(mGroupNegotiationState);
                }
                break; /* Loop/switch isn't completed */
_L3:
                if(((WifiP2pProvDiscEvent)message.obj).device.deviceAddress.equals(mSavedPeerConfig.deviceAddress) && mSavedPeerConfig.wps.setup == 2)
                    if(!TextUtils.isEmpty(mSavedPeerConfig.wps.pin)) {
                        mWifiNative.p2pConnect(mSavedPeerConfig, WifiP2pService.FORM_GROUP.booleanValue());
                        transitionTo(mGroupNegotiationState);
                    } else {
                        mJoinExistingGroup = false;
                        transitionTo(mUserAuthorizingInvitationState);
                    }
                continue; /* Loop/switch isn't completed */
_L4:
                WifiP2pProvDiscEvent wifip2pprovdiscevent = (WifiP2pProvDiscEvent)message.obj;
                WifiP2pDevice wifip2pdevice = wifip2pprovdiscevent.device;
                if(wifip2pdevice.deviceAddress.equals(mSavedPeerConfig.deviceAddress) && mSavedPeerConfig.wps.setup == 1) {
                    mSavedPeerConfig.wps.pin = wifip2pprovdiscevent.pin;
                    mWifiNative.p2pConnect(mSavedPeerConfig, WifiP2pService.FORM_GROUP.booleanValue());
                    if(!sendShowPinReqToFrontApp(wifip2pprovdiscevent.pin))
                        notifyInvitationSent(wifip2pprovdiscevent.pin, wifip2pdevice.deviceAddress);
                    transitionTo(mGroupNegotiationState);
                }
                if(true) goto _L6; else goto _L5
_L5:
            }

            final P2pStateMachine this$1;

            ProvisionDiscoveryState() {
                this$1 = P2pStateMachine.this;
                super();
            }
        }

        class UserAuthorizingInvitationState extends State {

            public void enter() {
                if(!sendConnectNoticeToApp(mPeers.get(mSavedPeerConfig.deviceAddress), mSavedPeerConfig))
                    notifyInvitationReceived();
            }

            public void exit() {
            }

            public boolean processMessage(Message message) {
                boolean flag = true;
                message.what;
                JVM INSTR tableswitch 143362 143363: default 28
            //                           143362 32
            //                           143363 133;
                   goto _L1 _L2 _L3
_L1:
                flag = false;
_L5:
                return flag;
_L2:
                if(mJoinExistingGroup)
                    p2pConnectWithPinDisplay(mSavedPeerConfig, WifiP2pService.JOIN_GROUP.booleanValue());
                else
                    p2pConnectWithPinDisplay(mSavedPeerConfig, WifiP2pService.FORM_GROUP.booleanValue());
                mPeers.updateStatus(mSavedPeerConfig.deviceAddress, 1);
                sendP2pPeersChangedBroadcast();
                transitionTo(mGroupNegotiationState);
                continue; /* Loop/switch isn't completed */
_L3:
                mSavedPeerConfig = null;
                transitionTo(mInactiveState);
                if(true) goto _L5; else goto _L4
_L4:
            }

            final P2pStateMachine this$1;

            UserAuthorizingInvitationState() {
                this$1 = P2pStateMachine.this;
                super();
            }
        }

        class GroupCreatingState extends State {

            public void enter() {
                sendMessageDelayed(obtainMessage(0x23001, int i = 1 + 
// JavaClassFileOutputException: get_constant: invalid tag

            public boolean processMessage(Message message) {
                boolean flag = true;
                message.what;
                JVM INSTR lookupswitch 4: default 48
            //                           139265: 131
            //                           139274: 145
            //                           143361: 52
            //                           147478: 86;
                   goto _L1 _L2 _L3 _L4 _L5
_L1:
                flag = false;
_L7:
                return flag;
_L4:
                if(WifiP2pService.mGroupCreatingTimeoutIndex == message.arg1) {
                    handleGroupCreationFailure();
                    transitionTo(mInactiveState);
                }
                continue; /* Loop/switch isn't completed */
_L5:
                WifiP2pDevice wifip2pdevice = (WifiP2pDevice)message.obj;
                if(mSavedPeerConfig != null && !mSavedPeerConfig.deviceAddress.equals(wifip2pdevice.deviceAddress))
                    flag = false;
                continue; /* Loop/switch isn't completed */
_L2:
                replyToMessage(message, 0x22002, 2);
                continue; /* Loop/switch isn't completed */
_L3:
                mWifiNative.p2pCancelConnect();
                handleGroupCreationFailure();
                transitionTo(mInactiveState);
                replyToMessage(message, 0x2200c);
                if(true) goto _L7; else goto _L6
_L6:
            }

            final P2pStateMachine this$1;

            GroupCreatingState() {
                this$1 = P2pStateMachine.this;
                super();
            }
        }

        class InactiveState extends State {

            public void enter() {
            }

            public boolean processMessage(Message message) {
                message.what;
                JVM INSTR lookupswitch 8: default 80
            //                           139271: 84
            //                           139277: 815
            //                           147479: 462
            //                           147487: 555
            //                           147489: 286
            //                           147491: 286
            //                           147492: 286
            //                           147493: 781;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L6 _L6 _L7
_L3:
                break MISSING_BLOCK_LABEL_815;
_L1:
                boolean flag = false;
_L8:
                return flag;
_L2:
                WifiP2pConfig wifip2pconfig = (WifiP2pConfig)message.obj;
                mAutonomousGroup = false;
                int i = mWifiNative.getGroupCapability(wifip2pconfig.deviceAddress);
                mPeers.updateGroupCapability(wifip2pconfig.deviceAddress, i);
                if(mSavedPeerConfig != null && wifip2pconfig.deviceAddress.equals(mSavedPeerConfig.deviceAddress)) {
                    mSavedPeerConfig = wifip2pconfig;
                    mWifiNative.p2pStopFind();
                    if(mPeers.isGroupOwner(mSavedPeerConfig.deviceAddress))
                        p2pConnectWithPinDisplay(mSavedPeerConfig, WifiP2pService.JOIN_GROUP.booleanValue());
                    else
                        p2pConnectWithPinDisplay(mSavedPeerConfig, WifiP2pService.FORM_GROUP.booleanValue());
                    transitionTo(mGroupNegotiationState);
                } else {
                    mSavedPeerConfig = wifip2pconfig;
                    int j = configuredNetworkId(mSavedPeerConfig.deviceAddress);
                    if(j >= 0) {
                        mWifiNative.p2pReinvoke(j, mSavedPeerConfig.deviceAddress);
                    } else {
                        mWifiNative.p2pStopFind();
                        if(mPeers.isGroupOwner(mSavedPeerConfig.deviceAddress)) {
                            p2pConnectWithPinDisplay(mSavedPeerConfig, WifiP2pService.JOIN_GROUP.booleanValue());
                            transitionTo(mGroupNegotiationState);
                        } else {
                            transitionTo(mProvisionDiscoveryState);
                        }
                    }
                }
                mPeers.updateStatus(mSavedPeerConfig.deviceAddress, 1);
                sendP2pPeersChangedBroadcast();
                replyToMessage(message, 0x22009);
_L6:
                flag = true;
                if(true) goto _L8; else goto _L4
_L4:
                mSavedPeerConfig = (WifiP2pConfig)message.obj;
                mAutonomousGroup = false;
                mJoinExistingGroup = false;
                if(!sendConnectNoticeToApp(mPeers.get(mSavedPeerConfig.deviceAddress), mSavedPeerConfig))
                    transitionTo(mUserAuthorizingInvitationState);
                  goto _L6
_L5:
                WifiP2pGroup wifip2pgroup = (WifiP2pGroup)message.obj;
                WifiP2pDevice wifip2pdevice = wifip2pgroup.getOwner();
                if(wifip2pdevice != null) {
                    mSavedPeerConfig = new WifiP2pConfig();
                    mSavedPeerConfig.deviceAddress = wifip2pgroup.getOwner().deviceAddress;
                    WifiP2pDevice wifip2pdevice1 = mPeers.get(wifip2pdevice.deviceAddress);
                    if(wifip2pdevice1 != null)
                        if(wifip2pdevice1.wpsPbcSupported())
                            mSavedPeerConfig.wps.setup = 0;
                        else
                        if(wifip2pdevice1.wpsKeypadSupported())
                            mSavedPeerConfig.wps.setup = 2;
                        else
                        if(wifip2pdevice1.wpsDisplaySupported())
                            mSavedPeerConfig.wps.setup = 1;
                    mAutonomousGroup = false;
                    mJoinExistingGroup = true;
                    if(!sendConnectNoticeToApp(mPeers.get(mSavedPeerConfig.deviceAddress), mSavedPeerConfig))
                        transitionTo(mUserAuthorizingInvitationState);
                }
                  goto _L6
_L7:
                mWifiNative.p2pFlush();
                mServiceDiscReqId = null;
                sendP2pDiscoveryChangedBroadcast(false);
                  goto _L6
                mAutonomousGroup = true;
                if(mWifiNative.p2pGroupAdd())
                    replyToMessage(message, 0x2200f);
                else
                    replyToMessage(message, 0x2200e, 0);
                transitionTo(mGroupNegotiationState);
                  goto _L6
            }

            final P2pStateMachine this$1;

            InactiveState() {
                this$1 = P2pStateMachine.this;
                super();
            }
        }

        class P2pEnabledState extends State {

            public void enter() {
                sendP2pStateChangedBroadcast(true);
                mNetworkInfo.setIsAvailable(true);
                sendP2pConnectionChangedBroadcast();
                initializeP2pSettings();
            }

            public void exit() {
                sendP2pStateChangedBroadcast(false);
                mNetworkInfo.setIsAvailable(false);
            }

            public boolean processMessage(Message message) {
                boolean flag = false;
                message.what;
                JVM INSTR lookupswitch 16: default 144
            //                           131203: 190
            //                           131204: 146
            //                           139265: 251
            //                           139268: 319
            //                           139292: 514
            //                           139295: 565
            //                           139298: 600
            //                           139301: 624
            //                           139304: 671
            //                           139307: 702
            //                           139310: 359
            //                           139315: 195
            //                           147477: 425
            //                           147478: 480
            //                           147493: 308
            //                           147494: 726;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17
_L17:
                break MISSING_BLOCK_LABEL_726;
_L2:
                break; /* Loop/switch isn't completed */
_L1:
                return flag;
_L3:
                if(mPeers.clear())
                    sendP2pPeersChangedBroadcast();
                mWifiNative.closeSupplicantConnection();
                transitionTo(mP2pDisablingState);
_L18:
                flag = true;
                if(true) goto _L1; else goto _L13
_L13:
                WifiP2pDevice wifip2pdevice2 = (WifiP2pDevice)message.obj;
                if(wifip2pdevice2 != null && setAndPersistDeviceName(wifip2pdevice2.deviceName))
                    replyToMessage(message, 0x22035);
                else
                    replyToMessage(message, 0x22034, 0);
                  goto _L18
_L4:
                clearSupplicantServiceRequest();
                if(mWifiNative.p2pFind(120)) {
                    replyToMessage(message, 0x22003);
                    sendP2pDiscoveryChangedBroadcast(true);
                } else {
                    replyToMessage(message, 0x22002, 0);
                }
                  goto _L18
_L16:
                sendP2pDiscoveryChangedBroadcast(false);
                  goto _L18
_L5:
                if(mWifiNative.p2pStopFind())
                    replyToMessage(message, 0x22006);
                else
                    replyToMessage(message, 0x22005, 0);
                  goto _L18
_L12:
                if(!updateSupplicantServiceRequest())
                    replyToMessage(message, 0x2202f, 3);
                else
                if(mWifiNative.p2pFind(120))
                    replyToMessage(message, 0x22030);
                else
                    replyToMessage(message, 0x2202f, 0);
                  goto _L18
_L14:
                WifiP2pDevice wifip2pdevice1 = (WifiP2pDevice)message.obj;
                if(!mThisDevice.deviceAddress.equals(wifip2pdevice1.deviceAddress)) {
                    mPeers.update(wifip2pdevice1);
                    sendP2pPeersChangedBroadcast();
                }
                  goto _L18
_L15:
                WifiP2pDevice wifip2pdevice = (WifiP2pDevice)message.obj;
                if(mPeers.remove(wifip2pdevice))
                    sendP2pPeersChangedBroadcast();
                  goto _L18
_L6:
                WifiP2pServiceInfo wifip2pserviceinfo1 = (WifiP2pServiceInfo)message.obj;
                if(addLocalService(message.replyTo, wifip2pserviceinfo1))
                    replyToMessage(message, 0x2201e);
                else
                    replyToMessage(message, 0x2201d);
                  goto _L18
_L7:
                WifiP2pServiceInfo wifip2pserviceinfo = (WifiP2pServiceInfo)message.obj;
                removeLocalService(message.replyTo, wifip2pserviceinfo);
                replyToMessage(message, 0x22021);
                  goto _L18
_L8:
                clearLocalServices(message.replyTo);
                replyToMessage(message, 0x22024);
                  goto _L18
_L9:
                if(!addServiceRequest(message.replyTo, (WifiP2pServiceRequest)message.obj))
                    replyToMessage(message, 0x22026);
                else
                    replyToMessage(message, 0x22027);
                  goto _L18
_L10:
                removeServiceRequest(message.replyTo, (WifiP2pServiceRequest)message.obj);
                replyToMessage(message, 0x2202a);
                  goto _L18
_L11:
                clearServiceRequests(message.replyTo);
                replyToMessage(message, 0x2202d);
                  goto _L18
                Iterator iterator = ((List)message.obj).iterator();
                while(iterator.hasNext())  {
                    WifiP2pServiceResponse wifip2pserviceresponse = (WifiP2pServiceResponse)iterator.next();
                    wifip2pserviceresponse.setSrcDevice(mPeers.get(wifip2pserviceresponse.getSrcDevice().deviceAddress));
                    sendServiceResponse(wifip2pserviceresponse);
                }
                  goto _L18
            }

            final P2pStateMachine this$1;

            P2pEnabledState() {
                this$1 = P2pStateMachine.this;
                super();
            }
        }

        class P2pEnablingState extends State {

            public void enter() {
            }

            public boolean processMessage(Message message) {
                message.what;
                JVM INSTR lookupswitch 4: default 48
            //                           131203: 97
            //                           131204: 97
            //                           147457: 52
            //                           147458: 71;
                   goto _L1 _L2 _L2 _L3 _L4
_L2:
                break MISSING_BLOCK_LABEL_97;
_L1:
                boolean flag = false;
_L5:
                return flag;
_L3:
                transitionTo(mInactiveState);
_L6:
                flag = true;
                if(true) goto _L5; else goto _L4
_L4:
                loge("P2p socket connection failed");
                transitionTo(mP2pDisabledState);
                  goto _L6
                deferMessage(message);
                  goto _L6
            }

            final P2pStateMachine this$1;

            P2pEnablingState() {
                this$1 = P2pStateMachine.this;
                super();
            }
        }

        class P2pDisabledState extends State {

            public void enter() {
            }

            public boolean processMessage(Message message) {
                message.what;
                JVM INSTR tableswitch 131203 131204: default 28
            //                           131203 32
            //                           131204 81;
                   goto _L1 _L2 _L3
_L1:
                boolean flag = false;
_L5:
                return flag;
_L2:
                try {
                    mNwService.setInterfaceUp(mInterface);
                }
                catch(RemoteException remoteexception) {
                    loge((new StringBuilder()).append("Unable to change interface settings: ").append(remoteexception).toString());
                }
                catch(IllegalStateException illegalstateexception) {
                    loge((new StringBuilder()).append("Unable to change interface settings: ").append(illegalstateexception).toString());
                }
                mWifiMonitor.startMonitoring();
                transitionTo(mP2pEnablingState);
_L3:
                flag = true;
                if(true) goto _L5; else goto _L4
_L4:
            }

            final P2pStateMachine this$1;

            P2pDisabledState() {
                this$1 = P2pStateMachine.this;
                super();
            }
        }

        class P2pDisablingState extends State {

            public boolean processMessage(Message message) {
                message.what;
                JVM INSTR lookupswitch 3: default 40
            //                           131203: 63
            //                           131204: 63
            //                           147458: 44;
                   goto _L1 _L2 _L2 _L3
_L1:
                boolean flag = false;
_L4:
                return flag;
_L3:
                transitionTo(mP2pDisabledState);
_L5:
                flag = true;
                if(true) goto _L4; else goto _L2
_L2:
                deferMessage(message);
                  goto _L5
            }

            final P2pStateMachine this$1;

            P2pDisablingState() {
                this$1 = P2pStateMachine.this;
                super();
            }
        }

        class P2pNotSupportedState extends State {

            public boolean processMessage(Message message) {
                boolean flag = true;
                message.what;
                JVM INSTR lookupswitch 15: default 136
            //                           139265: 140
            //                           139268: 154
            //                           139271: 182
            //                           139274: 196
            //                           139277: 210
            //                           139280: 224
            //                           139292: 238
            //                           139295: 266
            //                           139298: 280
            //                           139301: 294
            //                           139304: 308
            //                           139307: 322
            //                           139310: 168
            //                           139315: 336
            //                           139318: 252;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16
_L1:
                flag = false;
_L18:
                return flag;
_L2:
                replyToMessage(message, 0x22002, flag);
                continue; /* Loop/switch isn't completed */
_L3:
                replyToMessage(message, 0x22005, flag);
                continue; /* Loop/switch isn't completed */
_L14:
                replyToMessage(message, 0x2202f, flag);
                continue; /* Loop/switch isn't completed */
_L4:
                replyToMessage(message, 0x22008, flag);
                continue; /* Loop/switch isn't completed */
_L5:
                replyToMessage(message, 0x2200b, flag);
                continue; /* Loop/switch isn't completed */
_L6:
                replyToMessage(message, 0x2200e, flag);
                continue; /* Loop/switch isn't completed */
_L7:
                replyToMessage(message, 0x22011, flag);
                continue; /* Loop/switch isn't completed */
_L8:
                replyToMessage(message, 0x2201d, flag);
                continue; /* Loop/switch isn't completed */
_L16:
                replyToMessage(message, 0x22037, flag);
                continue; /* Loop/switch isn't completed */
_L9:
                replyToMessage(message, 0x22020, flag);
                continue; /* Loop/switch isn't completed */
_L10:
                replyToMessage(message, 0x22023, flag);
                continue; /* Loop/switch isn't completed */
_L11:
                replyToMessage(message, 0x22026, flag);
                continue; /* Loop/switch isn't completed */
_L12:
                replyToMessage(message, 0x22029, flag);
                continue; /* Loop/switch isn't completed */
_L13:
                replyToMessage(message, 0x2202c, flag);
                continue; /* Loop/switch isn't completed */
_L15:
                replyToMessage(message, 0x22034, flag);
                if(true) goto _L18; else goto _L17
_L17:
            }

            final P2pStateMachine this$1;

            P2pNotSupportedState() {
                this$1 = P2pStateMachine.this;
                super();
            }
        }

        class DefaultState extends State {

            public boolean processMessage(Message message) {
                message.what;
                JVM INSTR lookupswitch 40: default 336
            //                           69632: 368
            //                           69633: 507
            //                           69636: 443
            //                           131203: 393
            //                           131204: 393
            //                           139265: 541
            //                           139268: 555
            //                           139271: 583
            //                           139274: 597
            //                           139277: 611
            //                           139280: 625
            //                           139283: 737
            //                           139285: 757
            //                           139287: 777
            //                           139292: 639
            //                           139295: 653
            //                           139298: 667
            //                           139301: 681
            //                           139304: 695
            //                           139307: 709
            //                           139310: 569
            //                           139315: 723
            //                           139318: 797
            //                           143361: 393
            //                           143362: 393
            //                           143363: 393
            //                           147457: 393
            //                           147458: 393
            //                           147459: 393
            //                           147460: 393
            //                           147461: 393
            //                           147462: 393
            //                           147477: 393
            //                           147478: 393
            //                           147484: 393
            //                           147485: 864
            //                           147486: 393
            //                           147488: 393
            //                           147493: 393
            //                           147494: 393;
                   goto _L1 _L2 _L3 _L4 _L5 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L5 _L5 _L5 _L5 _L5 _L5 _L5 _L5 _L5 _L5 _L5 _L5 _L24 _L5 _L5 _L5 _L5
_L24:
                break MISSING_BLOCK_LABEL_864;
_L5:
                break; /* Loop/switch isn't completed */
_L1:
                boolean flag;
                loge((new StringBuilder()).append("Unhandled message ").append(message).toString());
                flag = false;
_L25:
                return flag;
_L2:
                if(message.arg1 == 0) {
                    mWifiChannel = (AsyncChannel)message.obj;
                } else {
                    loge((new StringBuilder()).append("Full connection failure, error = ").append(message.arg1).toString());
                    mWifiChannel = null;
                }
_L26:
                flag = true;
                if(true) goto _L25; else goto _L4
_L4:
                if(message.arg1 == 2)
                    loge("Send failed, client connection lost");
                else
                    loge((new StringBuilder()).append("Client connection lost with reason: ").append(message.arg1).toString());
                mWifiChannel = null;
                  goto _L26
_L3:
                (new AsyncChannel()).connect(mContext, getHandler(), message.replyTo);
                  goto _L26
_L6:
                replyToMessage(message, 0x22002, 2);
                  goto _L26
_L7:
                replyToMessage(message, 0x22005, 2);
                  goto _L26
_L21:
                replyToMessage(message, 0x2202f, 2);
                  goto _L26
_L8:
                replyToMessage(message, 0x22008, 2);
                  goto _L26
_L9:
                replyToMessage(message, 0x2200b, 2);
                  goto _L26
_L10:
                replyToMessage(message, 0x2200e, 2);
                  goto _L26
_L11:
                replyToMessage(message, 0x22011, 2);
                  goto _L26
_L15:
                replyToMessage(message, 0x2201d, 2);
                  goto _L26
_L16:
                replyToMessage(message, 0x22020, 2);
                  goto _L26
_L17:
                replyToMessage(message, 0x22023, 2);
                  goto _L26
_L18:
                replyToMessage(message, 0x22026, 2);
                  goto _L26
_L19:
                replyToMessage(message, 0x22029, 2);
                  goto _L26
_L20:
                replyToMessage(message, 0x2202c, 2);
                  goto _L26
_L22:
                replyToMessage(message, 0x22034, 2);
                  goto _L26
_L12:
                replyToMessage(message, 0x22014, mPeers);
                  goto _L26
_L13:
                replyToMessage(message, 0x22016, mWifiP2pInfo);
                  goto _L26
_L14:
                replyToMessage(message, 0x22018, mGroup);
                  goto _L26
_L23:
                String s = message.getData().getString("appPkgName");
                boolean flag1 = message.getData().getBoolean("dialogResetFlag");
                if(setDialogListenerApp(message.replyTo, s, flag1))
                    replyToMessage(message, 0x22038);
                else
                    replyToMessage(message, 0x22037, 4);
                  goto _L26
                mGroup = (WifiP2pGroup)message.obj;
                loge((new StringBuilder()).append("Unexpected group creation, remove ").append(mGroup).toString());
                mWifiNative.p2pGroupRemove(mGroup.getInterface());
                  goto _L26
            }

            final P2pStateMachine this$1;

            DefaultState() {
                this$1 = P2pStateMachine.this;
                super();
            }
        }


        private boolean addLocalService(Messenger messenger, WifiP2pServiceInfo wifip2pserviceinfo) {
            boolean flag;
            ClientInfo clientinfo;
            flag = false;
            clearClientDeadChannels();
            clientinfo = getClientInfo(messenger, true);
            break MISSING_BLOCK_LABEL_14;
            if(clientinfo != null && clientinfo.mServList.add(wifip2pserviceinfo))
                if(!mWifiNative.p2pServiceAdd(wifip2pserviceinfo))
                    clientinfo.mServList.remove(wifip2pserviceinfo);
                else
                    flag = true;
            return flag;
        }

        private void addRowToDialog(ViewGroup viewgroup, int i, String s) {
            Resources resources = Resources.getSystem();
            View view = LayoutInflater.from(mContext).inflate(0x10900ca, viewgroup, false);
            ((TextView)view.findViewById(0x1020365)).setText(resources.getString(i));
            ((TextView)view.findViewById(0x1020292)).setText(s);
            viewgroup.addView(view);
        }

        private boolean addServiceRequest(Messenger messenger, WifiP2pServiceRequest wifip2pservicerequest) {
            boolean flag;
            ClientInfo clientinfo;
            flag = true;
            clearClientDeadChannels();
            clientinfo = getClientInfo(messenger, flag);
            if(clientinfo != null) goto _L2; else goto _L1
_L1:
            flag = false;
_L4:
            return flag;
_L2:
            byte byte0 = 1 + ((mInactiveState) (this)).mInactiveState;
            if(mServiceTransactionId == 0)
                byte byte0 = 1 + ((mInactiveState) (this)).mInactiveState;
            wifip2pservicerequest.setTransactionId(mServiceTransactionId);
            clientinfo.mReqList.put(mServiceTransactionId, wifip2pservicerequest);
            if(mServiceDiscReqId != null)
                flag = updateSupplicantServiceRequest();
            if(true) goto _L4; else goto _L3
_L3:
        }

        private void clearClientDeadChannels() {
            ArrayList arraylist = new ArrayList();
            for(Iterator iterator = mClientInfoList.values().iterator(); iterator.hasNext();) {
                ClientInfo clientinfo = (ClientInfo)iterator.next();
                Message message = Message.obtain();
                message.what = 0x22031;
                message.arg1 = 0;
                message.arg2 = 0;
                message.obj = null;
                try {
                    clientinfo.mMessenger.send(message);
                }
                catch(RemoteException remoteexception) {
                    arraylist.add(clientinfo.mMessenger);
                }
            }

            for(Iterator iterator1 = arraylist.iterator(); iterator1.hasNext(); clearClientInfo((Messenger)iterator1.next()));
        }

        private void clearClientInfo(Messenger messenger) {
            clearLocalServices(messenger);
            clearServiceRequests(messenger);
        }

        private void clearLocalServices(Messenger messenger) {
            ClientInfo clientinfo = getClientInfo(messenger, false);
            if(clientinfo != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            WifiP2pServiceInfo wifip2pserviceinfo;
            for(Iterator iterator = clientinfo.mServList.iterator(); iterator.hasNext(); mWifiNative.p2pServiceDel(wifip2pserviceinfo))
                wifip2pserviceinfo = (WifiP2pServiceInfo)iterator.next();

            clientinfo.mServList.clear();
            if(clientinfo.mReqList.size() == 0)
                mClientInfoList.remove(clientinfo.mMessenger);
            if(true) goto _L1; else goto _L3
_L3:
        }

        private void clearServiceRequests(Messenger messenger) {
            ClientInfo clientinfo;
            clientinfo = getClientInfo(messenger, false);
            break MISSING_BLOCK_LABEL_7;
            while(true)  {
                do
                    return;
                while(clientinfo == null || clientinfo.mReqList.size() == 0);
                clientinfo.mReqList.clear();
                if(clientinfo.mServList.size() == 0)
                    mClientInfoList.remove(clientinfo.mMessenger);
                if(mServiceDiscReqId != null)
                    updateSupplicantServiceRequest();
            }
        }

        private void clearSupplicantServiceRequest() {
            if(mServiceDiscReqId != null) {
                mWifiNative.p2pServDiscCancelReq(mServiceDiscReqId);
                mServiceDiscReqId = null;
            }
        }

        private int configuredNetworkId(String s) {
            return -1;
        }

        private ClientInfo getClientInfo(Messenger messenger, boolean flag) {
            ClientInfo clientinfo = (ClientInfo)mClientInfoList.get(messenger);
            if(clientinfo == null && flag) {
                clientinfo = new ClientInfo(messenger);
                mClientInfoList.put(messenger, clientinfo);
            }
            return clientinfo;
        }

        private String getDeviceName(String s) {
            WifiP2pDevice wifip2pdevice = mPeers.get(s);
            if(wifip2pdevice != null)
                s = wifip2pdevice.deviceName;
            return s;
        }

        private String getPersistedDeviceName() {
            String s = android.provider.Settings.Secure.getString(mContext.getContentResolver(), "wifi_p2p_device_name");
            if(s == null) {
                String s1 = android.provider.Settings.Secure.getString(mContext.getContentResolver(), "android_id");
                s = (new StringBuilder()).append("Android_").append(s1.substring(0, 4)).toString();
            }
            return s;
        }

        private void handleGroupCreationFailure() {
            mSavedPeerConfig = null;
            mWifiNative.p2pFlush();
            mServiceDiscReqId = null;
            sendMessage(0x22001);
        }

        private void initializeP2pSettings() {
            mWifiNative.setPersistentReconnect(true);
            mThisDevice.deviceName = getPersistedDeviceName();
            mWifiNative.setDeviceName(mThisDevice.deviceName);
            mWifiNative.setP2pSsidPostfix((new StringBuilder()).append("-").append(mThisDevice.deviceName).toString());
            mWifiNative.setDeviceType(mThisDevice.primaryDeviceType);
            mWifiNative.setConfigMethods("virtual_push_button physical_display keypad");
            mWifiNative.setConcurrencyPriority("sta");
            mThisDevice.deviceAddress = mWifiNative.p2pGetDeviceAddress();
            updateThisDevice(3);
            mClientInfoList.clear();
            mWifiNative.p2pFlush();
            mWifiNative.p2pServiceFlush();
            mServiceTransactionId = 0;
            mServiceDiscReqId = null;
        }

        private boolean isForegroundApp(String s) {
            boolean flag = false;
            if(s != null) goto _L2; else goto _L1
_L1:
            return flag;
_L2:
            List list = mActivityMgr.getRunningTasks(1);
            if(list.size() != 0)
                flag = s.equals(((android.app.ActivityManager.RunningTaskInfo)list.get(0)).baseActivity.getPackageName());
            if(true) goto _L1; else goto _L3
_L3:
        }

        private void logd(String s) {
            Slog.d("WifiP2pService", s);
        }

        private void loge(String s) {
            Slog.e("WifiP2pService", s);
        }

        private void notifyInvitationReceived() {
            final WpsInfo wps;
            View view;
            ViewGroup viewgroup;
            AlertDialog alertdialog;
            Resources resources = Resources.getSystem();
            wps = mSavedPeerConfig.wps;
            view = LayoutInflater.from(mContext).inflate(0x10900c9, null);
            viewgroup = (ViewGroup)view.findViewById(0x10202e9);
            addRowToDialog(viewgroup, 0x1040411, getDeviceName(mSavedPeerConfig.deviceAddress));
            final EditText pin = (EditText)view.findViewById(0x1020364);
            alertdialog = (new android.app.AlertDialog.Builder(mContext)).setTitle(resources.getString(0x1040410)).setView(view).setPositiveButton(resources.getString(0x104040d), new android.content.DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialoginterface, int i) {
                    if(wps.setup == 2)
                        mSavedPeerConfig.wps.pin = pin.getText().toString();
                    sendMessage(0x23002);
                }

                final P2pStateMachine this$1;
                final EditText val$pin;
                final WpsInfo val$wps;

                 {
                    this$1 = P2pStateMachine.this;
                    wps = wpsinfo;
                    pin = edittext;
                    super();
                }
            }).setNegativeButton(resources.getString(0x104040e), new android.content.DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialoginterface, int i) {
                    sendMessage(0x23003);
                }

                final P2pStateMachine this$1;

                 {
                    this$1 = P2pStateMachine.this;
                    super();
                }
            }).setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                public void onCancel(DialogInterface dialoginterface) {
                    sendMessage(0x23003);
                }

                final P2pStateMachine this$1;

                 {
                    this$1 = P2pStateMachine.this;
                    super();
                }
            }).create();
            wps.setup;
            JVM INSTR tableswitch 1 2: default 184
        //                       1 215
        //                       2 201;
               goto _L1 _L2 _L3
_L1:
            alertdialog.getWindow().setType(2003);
            alertdialog.show();
            return;
_L3:
            view.findViewById(0x1020363).setVisibility(0);
            continue; /* Loop/switch isn't completed */
_L2:
            addRowToDialog(viewgroup, 0x1040414, wps.pin);
            if(true) goto _L1; else goto _L4
_L4:
        }

        private void notifyInvitationSent(String s, String s1) {
            Resources resources = Resources.getSystem();
            View view = LayoutInflater.from(mContext).inflate(0x10900c9, null);
            ViewGroup viewgroup = (ViewGroup)view.findViewById(0x10202e9);
            addRowToDialog(viewgroup, 0x1040412, getDeviceName(s1));
            addRowToDialog(viewgroup, 0x1040414, s);
            AlertDialog alertdialog = (new android.app.AlertDialog.Builder(mContext)).setTitle(resources.getString(0x104040f)).setView(view).setPositiveButton(resources.getString(0x104000a), null).create();
            alertdialog.getWindow().setType(2003);
            alertdialog.show();
        }

        private void notifyP2pEnableFailure() {
            Resources resources = Resources.getSystem();
            AlertDialog alertdialog = (new android.app.AlertDialog.Builder(mContext)).setTitle(resources.getString(0x1040408)).setMessage(resources.getString(0x104040a)).setPositiveButton(resources.getString(0x104000a), null).create();
            alertdialog.getWindow().setType(2003);
            alertdialog.show();
        }

        private Message obtainMessage(Message message) {
            Message message1 = Message.obtain();
            message1.arg2 = message.arg2;
            return message1;
        }

        private void p2pConnectWithPinDisplay(WifiP2pConfig wifip2pconfig, boolean flag) {
            String s = mWifiNative.p2pConnect(wifip2pconfig, flag);
            Integer.parseInt(s);
            if(!sendShowPinReqToFrontApp(s))
                notifyInvitationSent(s, wifip2pconfig.deviceAddress);
_L2:
            return;
            NumberFormatException numberformatexception;
            numberformatexception;
            if(true) goto _L2; else goto _L1
_L1:
        }

        private void removeLocalService(Messenger messenger, WifiP2pServiceInfo wifip2pserviceinfo) {
            ClientInfo clientinfo = getClientInfo(messenger, false);
            if(clientinfo != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            mWifiNative.p2pServiceDel(wifip2pserviceinfo);
            clientinfo.mServList.remove(wifip2pserviceinfo);
            if(clientinfo.mReqList.size() == 0 && clientinfo.mServList.size() == 0)
                mClientInfoList.remove(clientinfo.mMessenger);
            if(true) goto _L1; else goto _L3
_L3:
        }

        private void removeServiceRequest(Messenger messenger, WifiP2pServiceRequest wifip2pservicerequest) {
            ClientInfo clientinfo = getClientInfo(messenger, false);
            if(clientinfo != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            boolean flag = false;
            int i = 0;
            do {
label0:
                {
                    if(i < clientinfo.mReqList.size()) {
                        if(!wifip2pservicerequest.equals(clientinfo.mReqList.valueAt(i)))
                            break label0;
                        flag = true;
                        clientinfo.mReqList.removeAt(i);
                    }
                    if(flag) {
                        if(clientinfo.mReqList.size() == 0 && clientinfo.mServList.size() == 0)
                            mClientInfoList.remove(clientinfo.mMessenger);
                        if(mServiceDiscReqId != null)
                            updateSupplicantServiceRequest();
                    }
                }
                if(true)
                    continue;
                i++;
            } while(true);
            if(true) goto _L1; else goto _L3
_L3:
        }

        private void replyToMessage(Message message, int i) {
            if(message.replyTo != null) {
                Message message1 = obtainMessage(message);
                message1.what = i;
                mReplyChannel.replyToMessage(message, message1);
            }
        }

        private void replyToMessage(Message message, int i, int j) {
            if(message.replyTo != null) {
                Message message1 = obtainMessage(message);
                message1.what = i;
                message1.arg1 = j;
                mReplyChannel.replyToMessage(message, message1);
            }
        }

        private void replyToMessage(Message message, int i, Object obj) {
            if(message.replyTo != null) {
                Message message1 = obtainMessage(message);
                message1.what = i;
                message1.obj = obj;
                mReplyChannel.replyToMessage(message, message1);
            }
        }

        private boolean sendConnectNoticeToApp(WifiP2pDevice wifip2pdevice, WifiP2pConfig wifip2pconfig) {
            if(wifip2pdevice == null)
                wifip2pdevice = new WifiP2pDevice(wifip2pconfig.deviceAddress);
            boolean flag;
            if(!isForegroundApp(mForegroundAppPkgName)) {
                sendDetachedMsg(4);
                flag = false;
            } else {
                Message message = Message.obtain();
                message.what = 0x22039;
                Bundle bundle = new Bundle();
                bundle.putParcelable("wifiP2pDevice", wifip2pdevice);
                bundle.putParcelable("wifiP2pConfig", wifip2pconfig);
                message.setData(bundle);
                flag = sendDialogMsgToFrontApp(message);
            }
            return flag;
        }

        private void sendDetachedMsg(int i) {
            if(mForegroundAppMessenger != null) {
                Message message = Message.obtain();
                message.what = 0x22037;
                message.arg1 = i;
                try {
                    mForegroundAppMessenger.send(message);
                }
                catch(RemoteException remoteexception) { }
                mForegroundAppMessenger = null;
                mForegroundAppPkgName = null;
            }
        }

        private boolean sendDialogMsgToFrontApp(Message message) {
            mForegroundAppMessenger.send(message);
            boolean flag = true;
_L2:
            return flag;
            RemoteException remoteexception;
            remoteexception;
            mForegroundAppMessenger = null;
            mForegroundAppPkgName = null;
            flag = false;
            if(true) goto _L2; else goto _L1
_L1:
        }

        private void sendP2pConnectionChangedBroadcast() {
            Intent intent = new Intent("android.net.wifi.p2p.CONNECTION_STATE_CHANGE");
            intent.addFlags(0x28000000);
            intent.putExtra("wifiP2pInfo", new WifiP2pInfo(mWifiP2pInfo));
            intent.putExtra("networkInfo", new NetworkInfo(mNetworkInfo));
            mContext.sendStickyBroadcast(intent);
        }

        private void sendP2pDiscoveryChangedBroadcast(boolean flag) {
            if(mDiscoveryStarted != flag) {
                mDiscoveryStarted = flag;
                Intent intent = new Intent("android.net.wifi.p2p.DISCOVERY_STATE_CHANGE");
                intent.addFlags(0x8000000);
                byte byte0;
                if(flag)
                    byte0 = 2;
                else
                    byte0 = 1;
                intent.putExtra("discoveryState", byte0);
                mContext.sendStickyBroadcast(intent);
            }
        }

        private void sendP2pPeersChangedBroadcast() {
            Intent intent = new Intent("android.net.wifi.p2p.PEERS_CHANGED");
            intent.addFlags(0x8000000);
            mContext.sendBroadcast(intent);
        }

        private void sendP2pStateChangedBroadcast(boolean flag) {
            Intent intent = new Intent("android.net.wifi.p2p.STATE_CHANGED");
            intent.addFlags(0x8000000);
            if(flag)
                intent.putExtra("wifi_p2p_state", 2);
            else
                intent.putExtra("wifi_p2p_state", 1);
            mContext.sendStickyBroadcast(intent);
        }

        private void sendServiceResponse(WifiP2pServiceResponse wifip2pserviceresponse) {
            Iterator iterator = mClientInfoList.values().iterator();
_L2:
            ClientInfo clientinfo;
            Message message;
            do {
                if(!iterator.hasNext())
                    break MISSING_BLOCK_LABEL_105;
                clientinfo = (ClientInfo)iterator.next();
            } while((WifiP2pServiceRequest)clientinfo.mReqList.get(wifip2pserviceresponse.getTransactionId()) == null);
            message = Message.obtain();
            message.what = 0x22032;
            message.arg1 = 0;
            message.arg2 = 0;
            message.obj = wifip2pserviceresponse;
            clientinfo.mMessenger.send(message);
            if(true) goto _L2; else goto _L1
_L1:
            RemoteException remoteexception;
            remoteexception;
            clearClientInfo(clientinfo.mMessenger);
        }

        private boolean sendShowPinReqToFrontApp(String s) {
            boolean flag;
            if(!isForegroundApp(mForegroundAppPkgName)) {
                sendDetachedMsg(4);
                flag = false;
            } else {
                Message message = Message.obtain();
                message.what = 0x2203a;
                Bundle bundle = new Bundle();
                bundle.putString("wpsPin", s);
                message.setData(bundle);
                flag = sendDialogMsgToFrontApp(message);
            }
            return flag;
        }

        private void sendThisDeviceChangedBroadcast() {
            Intent intent = new Intent("android.net.wifi.p2p.THIS_DEVICE_CHANGED");
            intent.addFlags(0x8000000);
            intent.putExtra("wifiP2pDevice", new WifiP2pDevice(mThisDevice));
            mContext.sendStickyBroadcast(intent);
        }

        private boolean setAndPersistDeviceName(String s) {
            boolean flag = false;
            if(s != null)
                if(!mWifiNative.setDeviceName(s)) {
                    loge((new StringBuilder()).append("Failed to set device name ").append(s).toString());
                } else {
                    mThisDevice.deviceName = s;
                    mWifiNative.setP2pSsidPostfix((new StringBuilder()).append("-").append(mThisDevice.deviceName).toString());
                    android.provider.Settings.Secure.putString(mContext.getContentResolver(), "wifi_p2p_device_name", s);
                    sendThisDeviceChangedBroadcast();
                    flag = true;
                }
            return flag;
        }

        private boolean setDialogListenerApp(Messenger messenger, String s, boolean flag) {
            boolean flag1 = false;
            if(mForegroundAppPkgName == null || mForegroundAppPkgName.equals(s)) goto _L2; else goto _L1
_L1:
            if(!isForegroundApp(mForegroundAppPkgName)) goto _L4; else goto _L3
_L3:
            return flag1;
_L4:
            sendDetachedMsg(4);
_L2:
            if(flag) {
                mForegroundAppMessenger = null;
                mForegroundAppPkgName = null;
                flag1 = true;
            } else
            if(isForegroundApp(s)) {
                mForegroundAppMessenger = messenger;
                mForegroundAppPkgName = s;
                flag1 = true;
            }
            if(true) goto _L3; else goto _L5
_L5:
        }

        private void setWifiP2pInfoOnGroupFormation(String s) {
            mWifiP2pInfo.groupFormed = true;
            mWifiP2pInfo.isGroupOwner = mGroup.isGroupOwner();
            mWifiP2pInfo.groupOwnerAddress = NetworkUtils.numericToInetAddress(s);
        }

        private void setWifiP2pInfoOnGroupTermination() {
            mWifiP2pInfo.groupFormed = false;
            mWifiP2pInfo.isGroupOwner = false;
            mWifiP2pInfo.groupOwnerAddress = null;
        }

        private void startDhcpServer(String s) {
            InterfaceConfiguration interfaceconfiguration = mNwService.getInterfaceConfig(s);
            interfaceconfiguration.setLinkAddress(new LinkAddress(NetworkUtils.numericToInetAddress("192.168.49.1"), 24));
            interfaceconfiguration.setInterfaceUp();
            mNwService.setInterfaceConfig(s, interfaceconfiguration);
            mNwService.startTethering(WifiP2pService.DHCP_RANGE);
            logd((new StringBuilder()).append("Started Dhcp server on ").append(s).toString());
_L2:
            return;
            Exception exception;
            exception;
            loge((new StringBuilder()).append("Error configuring interface ").append(s).append(", :").append(exception).toString());
            if(true) goto _L2; else goto _L1
_L1:
        }

        private void stopDhcpServer() {
            mNwService.stopTethering();
            logd("Stopped Dhcp server");
_L2:
            return;
            Exception exception;
            exception;
            loge((new StringBuilder()).append("Error stopping Dhcp server").append(exception).toString());
            if(true) goto _L2; else goto _L1
_L1:
        }

        private boolean updateSupplicantServiceRequest() {
            boolean flag;
            StringBuffer stringbuffer;
            flag = false;
            clearSupplicantServiceRequest();
            stringbuffer = new StringBuffer();
            for(Iterator iterator = mClientInfoList.values().iterator(); iterator.hasNext();) {
                ClientInfo clientinfo = (ClientInfo)iterator.next();
                int i = 0;
                while(i < clientinfo.mReqList.size())  {
                    WifiP2pServiceRequest wifip2pservicerequest = (WifiP2pServiceRequest)clientinfo.mReqList.valueAt(i);
                    if(wifip2pservicerequest != null)
                        stringbuffer.append(wifip2pservicerequest.getSupplicantQuery());
                    i++;
                }
            }

            if(stringbuffer.length() != 0) goto _L2; else goto _L1
_L1:
            return flag;
_L2:
            mServiceDiscReqId = mWifiNative.p2pServDiscReq("00:00:00:00:00:00", stringbuffer.toString());
            if(mServiceDiscReqId != null)
                flag = true;
            if(true) goto _L1; else goto _L3
_L3:
        }

        private void updateThisDevice(int i) {
            mThisDevice.status = i;
            sendThisDeviceChangedBroadcast();
        }

        private DefaultState mDefaultState;
        private WifiP2pGroup mGroup;
        private GroupCreatedState mGroupCreatedState;
        private GroupCreatingState mGroupCreatingState;
        private GroupNegotiationState mGroupNegotiationState;
        private InactiveState mInactiveState;
        private P2pDisabledState mP2pDisabledState;
        private P2pDisablingState mP2pDisablingState;
        private P2pEnabledState mP2pEnabledState;
        private P2pEnablingState mP2pEnablingState;
        private P2pNotSupportedState mP2pNotSupportedState;
        private WifiP2pDeviceList mPeers;
        private ProvisionDiscoveryState mProvisionDiscoveryState;
        private WifiP2pGroup mSavedP2pGroup;
        private WifiP2pConfig mSavedPeerConfig;
        private WifiP2pDevice mSavedProvDiscDevice;
        private UserAuthorizingInvitationState mUserAuthorizingInvitationState;
        private UserAuthorizingJoinState mUserAuthorizingJoinState;
        private WifiMonitor mWifiMonitor;
        private WifiNative mWifiNative;
        private WifiP2pInfo mWifiP2pInfo;
        final WifiP2pService this$0;


































/*
        static WifiP2pConfig access$4202(P2pStateMachine p2pstatemachine, WifiP2pConfig wifip2pconfig) {
            p2pstatemachine.mSavedPeerConfig = wifip2pconfig;
            return wifip2pconfig;
        }

*/




































/*
        static WifiP2pDevice access$7902(P2pStateMachine p2pstatemachine, WifiP2pDevice wifip2pdevice) {
            p2pstatemachine.mSavedProvDiscDevice = wifip2pdevice;
            return wifip2pdevice;
        }

*/




/*
        static WifiP2pGroup access$802(P2pStateMachine p2pstatemachine, WifiP2pGroup wifip2pgroup) {
            p2pstatemachine.mGroup = wifip2pgroup;
            return wifip2pgroup;
        }

*/










        P2pStateMachine(String s, boolean flag) {
            this$0 = WifiP2pService.this;
            super(s);
            mDefaultState = new DefaultState();
            mP2pNotSupportedState = new P2pNotSupportedState();
            mP2pDisablingState = new P2pDisablingState();
            mP2pDisabledState = new P2pDisabledState();
            mP2pEnablingState = new P2pEnablingState();
            mP2pEnabledState = new P2pEnabledState();
            mInactiveState = new InactiveState();
            mGroupCreatingState = new GroupCreatingState();
            mUserAuthorizingInvitationState = new UserAuthorizingInvitationState();
            mProvisionDiscoveryState = new ProvisionDiscoveryState();
            mGroupNegotiationState = new GroupNegotiationState();
            mGroupCreatedState = new GroupCreatedState();
            mUserAuthorizingJoinState = new UserAuthorizingJoinState();
            mWifiNative = new WifiNative(mInterface);
            mWifiMonitor = new WifiMonitor(this, mWifiNative);
            mPeers = new WifiP2pDeviceList();
            mWifiP2pInfo = new WifiP2pInfo();
            addState(mDefaultState);
            addState(mP2pNotSupportedState, mDefaultState);
            addState(mP2pDisablingState, mDefaultState);
            addState(mP2pDisabledState, mDefaultState);
            addState(mP2pEnablingState, mDefaultState);
            addState(mP2pEnabledState, mDefaultState);
            addState(mInactiveState, mP2pEnabledState);
            addState(mGroupCreatingState, mP2pEnabledState);
            addState(mUserAuthorizingInvitationState, mGroupCreatingState);
            addState(mProvisionDiscoveryState, mGroupCreatingState);
            addState(mGroupNegotiationState, mGroupCreatingState);
            addState(mGroupCreatedState, mP2pEnabledState);
            addState(mUserAuthorizingJoinState, mGroupCreatedState);
            if(flag)
                setInitialState(mP2pDisabledState);
            else
                setInitialState(mP2pNotSupportedState);
        }
    }


    public WifiP2pService(Context context) {
        mReplyChannel = new AsyncChannel();
        mP2pRestartCount = 0;
        mThisDevice = new WifiP2pDevice();
        mServiceTransactionId = 0;
        mClientInfoList = new HashMap();
        mContext = context;
        mInterface = "p2p0";
        mActivityMgr = (ActivityManager)context.getSystemService("activity");
        mNetworkInfo = new NetworkInfo(13, 0, "WIFI_P2P", "");
        mP2pSupported = mContext.getPackageManager().hasSystemFeature("android.hardware.wifi.direct");
        mThisDevice.primaryDeviceType = mContext.getResources().getString(0x104001a);
        mP2pStateMachine = new P2pStateMachine("WifiP2pService", mP2pSupported);
        mP2pStateMachine.start();
    }

    private void enforceAccessPermission() {
        mContext.enforceCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE", "WifiP2pService");
    }

    private void enforceChangePermission() {
        mContext.enforceCallingOrSelfPermission("android.permission.CHANGE_WIFI_STATE", "WifiP2pService");
    }

    public void connectivityServiceReady() {
        mNwService = android.os.INetworkManagementService.Stub.asInterface(ServiceManager.getService("network_management"));
    }

    protected void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        if(mContext.checkCallingOrSelfPermission("android.permission.DUMP") != 0)
            printwriter.println((new StringBuilder()).append("Permission Denial: can't dump WifiP2pService from from pid=").append(Binder.getCallingPid()).append(", uid=").append(Binder.getCallingUid()).toString());
    }

    public Messenger getMessenger() {
        enforceAccessPermission();
        enforceChangePermission();
        return new Messenger(mP2pStateMachine.getHandler());
    }

    private static final int BASE = 0x23000;
    private static final boolean DBG = false;
    private static final String DHCP_RANGE[];
    private static final int DISCOVER_TIMEOUT_S = 120;
    private static final Boolean FORM_GROUP = Boolean.valueOf(false);
    public static final int GROUP_CREATING_TIMED_OUT = 0x23001;
    private static final int GROUP_CREATING_WAIT_TIME_MS = 0x1d4c0;
    private static final int GROUP_IDLE_TIME_S = 2;
    private static final Boolean JOIN_GROUP = Boolean.valueOf(true);
    private static final String NETWORKTYPE = "WIFI_P2P";
    private static final int P2P_RESTART_INTERVAL_MSECS = 5000;
    private static final int P2P_RESTART_TRIES = 5;
    private static final int PEER_CONNECTION_USER_ACCEPT = 0x23002;
    private static final int PEER_CONNECTION_USER_REJECT = 0x23003;
    private static final String SERVER_ADDRESS = "192.168.49.1";
    private static final String TAG = "WifiP2pService";
    private static int mGroupCreatingTimeoutIndex = 0;
    private ActivityManager mActivityMgr;
    private boolean mAutonomousGroup;
    private HashMap mClientInfoList;
    private Context mContext;
    private DhcpStateMachine mDhcpStateMachine;
    private boolean mDiscoveryStarted;
    private Messenger mForegroundAppMessenger;
    private String mForegroundAppPkgName;
    private String mInterface;
    private boolean mJoinExistingGroup;
    private NetworkInfo mNetworkInfo;
    private Notification mNotification;
    INetworkManagementService mNwService;
    private int mP2pRestartCount;
    private P2pStateMachine mP2pStateMachine;
    private final boolean mP2pSupported;
    private AsyncChannel mReplyChannel;
    private String mServiceDiscReqId;
    private byte mServiceTransactionId;
    private WifiP2pDevice mThisDevice;
    private AsyncChannel mWifiChannel;

    static  {
        String as[] = new String[2];
        as[0] = "192.168.49.2";
        as[1] = "192.168.49.254";
        DHCP_RANGE = as;
    }




/*
    static AsyncChannel access$102(WifiP2pService wifip2pservice, AsyncChannel asyncchannel) {
        wifip2pservice.mWifiChannel = asyncchannel;
        return asyncchannel;
    }

*/






/*
    static boolean access$4102(WifiP2pService wifip2pservice, boolean flag) {
        wifip2pservice.mAutonomousGroup = flag;
        return flag;
    }

*/





/*
    static boolean access$5202(WifiP2pService wifip2pservice, boolean flag) {
        wifip2pservice.mJoinExistingGroup = flag;
        return flag;
    }

*/



/*
    static String access$5702(WifiP2pService wifip2pservice, String s) {
        wifip2pservice.mServiceDiscReqId = s;
        return s;
    }

*/



/*
    static int access$5904() {
        int i = 1 + mGroupCreatingTimeoutIndex;
        mGroupCreatingTimeoutIndex = i;
        return i;
    }

*/



/*
    static DhcpStateMachine access$7302(WifiP2pService wifip2pservice, DhcpStateMachine dhcpstatemachine) {
        wifip2pservice.mDhcpStateMachine = dhcpstatemachine;
        return dhcpstatemachine;
    }

*/



/*
    static boolean access$8902(WifiP2pService wifip2pservice, boolean flag) {
        wifip2pservice.mDiscoveryStarted = flag;
        return flag;
    }

*/





/*
    static byte access$9202(WifiP2pService wifip2pservice, byte byte0) {
        wifip2pservice.mServiceTransactionId = byte0;
        return byte0;
    }

*/


/*
    static byte access$9204(WifiP2pService wifip2pservice) {
        byte byte0 = 1 + wifip2pservice.mServiceTransactionId;
        wifip2pservice.mServiceTransactionId = byte0;
        return byte0;
    }

*/




/*
    static Messenger access$9802(WifiP2pService wifip2pservice, Messenger messenger) {
        wifip2pservice.mForegroundAppMessenger = messenger;
        return messenger;
    }

*/



/*
    static String access$9902(WifiP2pService wifip2pservice, String s) {
        wifip2pservice.mForegroundAppPkgName = s;
        return s;
    }

*/
}
