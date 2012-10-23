// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi.p2p;

import android.content.Context;
import android.net.wifi.p2p.nsd.WifiP2pDnsSdServiceResponse;
import android.net.wifi.p2p.nsd.WifiP2pServiceInfo;
import android.net.wifi.p2p.nsd.WifiP2pServiceRequest;
import android.net.wifi.p2p.nsd.WifiP2pServiceResponse;
import android.net.wifi.p2p.nsd.WifiP2pUpnpServiceResponse;
import android.os.*;
import android.util.Log;
import com.android.internal.util.AsyncChannel;
import java.util.*;

// Referenced classes of package android.net.wifi.p2p:
//            IWifiP2pManager, WifiP2pDevice, WifiP2pConfig, WifiP2pDeviceList, 
//            WifiP2pInfo, WifiP2pGroup

public class WifiP2pManager {
    public static class Channel {
        class P2pHandler extends Handler {

            public void handleMessage(Message message) {
                Object obj = getListener(message.arg2);
                message.what;
                JVM INSTR lookupswitch 37: default 324
            //                           69636: 350
            //                           139266: 384
            //                           139267: 404
            //                           139269: 384
            //                           139270: 404
            //                           139272: 384
            //                           139273: 404
            //                           139275: 384
            //                           139276: 404
            //                           139278: 384
            //                           139279: 404
            //                           139281: 384
            //                           139282: 404
            //                           139284: 420
            //                           139286: 447
            //                           139288: 474
            //                           139293: 384
            //                           139294: 404
            //                           139296: 384
            //                           139297: 404
            //                           139299: 384
            //                           139300: 404
            //                           139302: 384
            //                           139303: 404
            //                           139305: 384
            //                           139306: 404
            //                           139308: 384
            //                           139309: 404
            //                           139311: 384
            //                           139312: 404
            //                           139314: 501
            //                           139316: 384
            //                           139317: 404
            //                           139319: 636
            //                           139320: 611
            //                           139321: 522
            //                           139322: 573;
                   goto _L1 _L2 _L3 _L4 _L3 _L4 _L3 _L4 _L3 _L4 _L3 _L4 _L3 _L4 _L5 _L6 _L7 _L3 _L4 _L3 _L4 _L3 _L4 _L3 _L4 _L3 _L4 _L3 _L4 _L3 _L4 _L8 _L3 _L4 _L9 _L10 _L11 _L12
_L1:
                Log.d("WifiP2pManager", (new StringBuilder()).append("Ignored ").append(message).toString());
_L14:
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
                WifiP2pDeviceList wifip2pdevicelist = (WifiP2pDeviceList)message.obj;
                if(obj != null)
                    ((PeerListListener)obj).onPeersAvailable(wifip2pdevicelist);
                continue; /* Loop/switch isn't completed */
_L6:
                WifiP2pInfo wifip2pinfo = (WifiP2pInfo)message.obj;
                if(obj != null)
                    ((ConnectionInfoListener)obj).onConnectionInfoAvailable(wifip2pinfo);
                continue; /* Loop/switch isn't completed */
_L7:
                WifiP2pGroup wifip2pgroup = (WifiP2pGroup)message.obj;
                if(obj != null)
                    ((GroupInfoListener)obj).onGroupInfoAvailable(wifip2pgroup);
                continue; /* Loop/switch isn't completed */
_L8:
                WifiP2pServiceResponse wifip2pserviceresponse = (WifiP2pServiceResponse)message.obj;
                handleServiceResponse(wifip2pserviceresponse);
                continue; /* Loop/switch isn't completed */
_L11:
                if(mDialogListener != null) {
                    Bundle bundle1 = message.getData();
                    mDialogListener.onConnectionRequested((WifiP2pDevice)bundle1.getParcelable("wifiP2pDevice"), (WifiP2pConfig)bundle1.getParcelable("wifiP2pConfig"));
                }
                continue; /* Loop/switch isn't completed */
_L12:
                if(mDialogListener != null) {
                    Bundle bundle = message.getData();
                    mDialogListener.onShowPinRequested(bundle.getString("wpsPin"));
                }
                continue; /* Loop/switch isn't completed */
_L10:
                if(mDialogListener != null)
                    mDialogListener.onAttached();
                continue; /* Loop/switch isn't completed */
_L9:
                if(mDialogListener != null) {
                    mDialogListener.onDetached(message.arg1);
                    mDialogListener = null;
                }
                if(true) goto _L14; else goto _L13
_L13:
            }

            final Channel this$0;

            P2pHandler(Looper looper) {
                this$0 = Channel.this;
                super(looper);
            }
        }


        private Object getListener(int i) {
            if(i != 0) goto _L2; else goto _L1
_L1:
            Object obj1 = null;
_L4:
            return obj1;
_L2:
            Object obj = mListenerMapLock;
            obj;
            JVM INSTR monitorenter ;
            obj1 = mListenerMap.remove(Integer.valueOf(i));
            if(true) goto _L4; else goto _L3
_L3:
        }

        private void handleDnsSdServiceResponse(WifiP2pDnsSdServiceResponse wifip2pdnssdserviceresponse) {
            if(wifip2pdnssdserviceresponse.getDnsType() != 12) goto _L2; else goto _L1
_L1:
            if(mDnsSdServRspListener != null)
                mDnsSdServRspListener.onDnsSdServiceAvailable(wifip2pdnssdserviceresponse.getInstanceName(), wifip2pdnssdserviceresponse.getDnsQueryName(), wifip2pdnssdserviceresponse.getSrcDevice());
_L4:
            return;
_L2:
            if(wifip2pdnssdserviceresponse.getDnsType() == 16) {
                if(mDnsSdTxtListener != null)
                    mDnsSdTxtListener.onDnsSdTxtRecordAvailable(wifip2pdnssdserviceresponse.getDnsQueryName(), wifip2pdnssdserviceresponse.getTxtRecord(), wifip2pdnssdserviceresponse.getSrcDevice());
            } else {
                Log.e("WifiP2pManager", (new StringBuilder()).append("Unhandled resp ").append(wifip2pdnssdserviceresponse).toString());
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        private void handleServiceResponse(WifiP2pServiceResponse wifip2pserviceresponse) {
            if(!(wifip2pserviceresponse instanceof WifiP2pDnsSdServiceResponse)) goto _L2; else goto _L1
_L1:
            handleDnsSdServiceResponse((WifiP2pDnsSdServiceResponse)wifip2pserviceresponse);
_L4:
            return;
_L2:
            if(wifip2pserviceresponse instanceof WifiP2pUpnpServiceResponse) {
                if(mUpnpServRspListener != null)
                    handleUpnpServiceResponse((WifiP2pUpnpServiceResponse)wifip2pserviceresponse);
            } else
            if(mServRspListener != null)
                mServRspListener.onServiceAvailable(wifip2pserviceresponse.getServiceType(), wifip2pserviceresponse.getRawData(), wifip2pserviceresponse.getSrcDevice());
            if(true) goto _L4; else goto _L3
_L3:
        }

        private void handleUpnpServiceResponse(WifiP2pUpnpServiceResponse wifip2pupnpserviceresponse) {
            mUpnpServRspListener.onUpnpServiceAvailable(wifip2pupnpserviceresponse.getUniqueServiceNames(), wifip2pupnpserviceresponse.getSrcDevice());
        }

        private int putListener(Object obj) {
            if(obj != null) goto _L2; else goto _L1
_L1:
            int i = 0;
_L4:
            return i;
_L2:
            Object obj1 = mListenerMapLock;
            obj1;
            JVM INSTR monitorenter ;
            do {
                i = mListenerKey;
                mListenerKey = i + 1;
            } while(i == 0);
            mListenerMap.put(Integer.valueOf(i), obj);
            if(true) goto _L4; else goto _L3
_L3:
        }

        private void setDialogListener(DialogListener dialoglistener) {
            mDialogListener = dialoglistener;
        }

        private static final int INVALID_LISTENER_KEY;
        private AsyncChannel mAsyncChannel;
        private ChannelListener mChannelListener;
        Context mContext;
        private DialogListener mDialogListener;
        private DnsSdServiceResponseListener mDnsSdServRspListener;
        private DnsSdTxtRecordListener mDnsSdTxtListener;
        private P2pHandler mHandler;
        private int mListenerKey;
        private HashMap mListenerMap;
        private Object mListenerMapLock;
        private ServiceResponseListener mServRspListener;
        private UpnpServiceResponseListener mUpnpServRspListener;




/*
        static UpnpServiceResponseListener access$1002(Channel channel, UpnpServiceResponseListener upnpserviceresponselistener) {
            channel.mUpnpServRspListener = upnpserviceresponselistener;
            return upnpserviceresponselistener;
        }

*/


/*
        static ChannelListener access$102(Channel channel, ChannelListener channellistener) {
            channel.mChannelListener = channellistener;
            return channellistener;
        }

*/





/*
        static DialogListener access$302(Channel channel, DialogListener dialoglistener) {
            channel.mDialogListener = dialoglistener;
            return dialoglistener;
        }

*/





/*
        static ServiceResponseListener access$702(Channel channel, ServiceResponseListener serviceresponselistener) {
            channel.mServRspListener = serviceresponselistener;
            return serviceresponselistener;
        }

*/


/*
        static DnsSdServiceResponseListener access$802(Channel channel, DnsSdServiceResponseListener dnssdserviceresponselistener) {
            channel.mDnsSdServRspListener = dnssdserviceresponselistener;
            return dnssdserviceresponselistener;
        }

*/


/*
        static DnsSdTxtRecordListener access$902(Channel channel, DnsSdTxtRecordListener dnssdtxtrecordlistener) {
            channel.mDnsSdTxtListener = dnssdtxtrecordlistener;
            return dnssdtxtrecordlistener;
        }

*/

        Channel(Context context, Looper looper, ChannelListener channellistener) {
            mListenerMap = new HashMap();
            mListenerMapLock = new Object();
            mListenerKey = 0;
            mAsyncChannel = new AsyncChannel();
            mHandler = new P2pHandler(looper);
            mChannelListener = channellistener;
            mContext = context;
        }
    }

    public static interface DialogListener {

        public abstract void onAttached();

        public abstract void onConnectionRequested(WifiP2pDevice wifip2pdevice, WifiP2pConfig wifip2pconfig);

        public abstract void onDetached(int i);

        public abstract void onShowPinRequested(String s);
    }

    public static interface UpnpServiceResponseListener {

        public abstract void onUpnpServiceAvailable(List list, WifiP2pDevice wifip2pdevice);
    }

    public static interface DnsSdTxtRecordListener {

        public abstract void onDnsSdTxtRecordAvailable(String s, Map map, WifiP2pDevice wifip2pdevice);
    }

    public static interface DnsSdServiceResponseListener {

        public abstract void onDnsSdServiceAvailable(String s, String s1, WifiP2pDevice wifip2pdevice);
    }

    public static interface ServiceResponseListener {

        public abstract void onServiceAvailable(int i, byte abyte0[], WifiP2pDevice wifip2pdevice);
    }

    public static interface GroupInfoListener {

        public abstract void onGroupInfoAvailable(WifiP2pGroup wifip2pgroup);
    }

    public static interface ConnectionInfoListener {

        public abstract void onConnectionInfoAvailable(WifiP2pInfo wifip2pinfo);
    }

    public static interface PeerListListener {

        public abstract void onPeersAvailable(WifiP2pDeviceList wifip2pdevicelist);
    }

    public static interface ActionListener {

        public abstract void onFailure(int i);

        public abstract void onSuccess();
    }

    public static interface ChannelListener {

        public abstract void onChannelDisconnected();
    }


    public WifiP2pManager(IWifiP2pManager iwifip2pmanager) {
        mService = iwifip2pmanager;
    }

    private static void checkChannel(Channel channel) {
        if(channel == null)
            throw new IllegalArgumentException("Channel needs to be initialized");
        else
            return;
    }

    private static void checkServiceInfo(WifiP2pServiceInfo wifip2pserviceinfo) {
        if(wifip2pserviceinfo == null)
            throw new IllegalArgumentException("service info is null");
        else
            return;
    }

    private static void checkServiceRequest(WifiP2pServiceRequest wifip2pservicerequest) {
        if(wifip2pservicerequest == null)
            throw new IllegalArgumentException("service request is null");
        else
            return;
    }

    public void addLocalService(Channel channel, WifiP2pServiceInfo wifip2pserviceinfo, ActionListener actionlistener) {
        checkChannel(channel);
        checkServiceInfo(wifip2pserviceinfo);
        channel.mAsyncChannel.sendMessage(0x2201c, 0, channel.putListener(actionlistener), wifip2pserviceinfo);
    }

    public void addServiceRequest(Channel channel, WifiP2pServiceRequest wifip2pservicerequest, ActionListener actionlistener) {
        checkChannel(channel);
        checkServiceRequest(wifip2pservicerequest);
        channel.mAsyncChannel.sendMessage(0x22025, 0, channel.putListener(actionlistener), wifip2pservicerequest);
    }

    public void cancelConnect(Channel channel, ActionListener actionlistener) {
        checkChannel(channel);
        channel.mAsyncChannel.sendMessage(0x2200a, 0, channel.putListener(actionlistener));
    }

    public void clearLocalServices(Channel channel, ActionListener actionlistener) {
        checkChannel(channel);
        channel.mAsyncChannel.sendMessage(0x22022, 0, channel.putListener(actionlistener));
    }

    public void clearServiceRequests(Channel channel, ActionListener actionlistener) {
        checkChannel(channel);
        channel.mAsyncChannel.sendMessage(0x2202b, 0, channel.putListener(actionlistener));
    }

    public void connect(Channel channel, WifiP2pConfig wifip2pconfig, ActionListener actionlistener) {
        checkChannel(channel);
        channel.mAsyncChannel.sendMessage(0x22007, 0, channel.putListener(actionlistener), wifip2pconfig);
    }

    public void createGroup(Channel channel, ActionListener actionlistener) {
        checkChannel(channel);
        channel.mAsyncChannel.sendMessage(0x2200d, 0, channel.putListener(actionlistener));
    }

    public void discoverPeers(Channel channel, ActionListener actionlistener) {
        checkChannel(channel);
        channel.mAsyncChannel.sendMessage(0x22001, 0, channel.putListener(actionlistener));
    }

    public void discoverServices(Channel channel, ActionListener actionlistener) {
        checkChannel(channel);
        channel.mAsyncChannel.sendMessage(0x2202e, 0, channel.putListener(actionlistener));
    }

    public Messenger getMessenger() {
        Messenger messenger1 = mService.getMessenger();
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
        Messenger messenger = getMessenger();
        if(messenger != null) goto _L2; else goto _L1
_L1:
        Channel channel = null;
_L4:
        return channel;
_L2:
        channel = new Channel(context, looper, channellistener);
        if(channel.mAsyncChannel.connectSync(context, channel.mHandler, messenger) != 0)
            channel = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void removeGroup(Channel channel, ActionListener actionlistener) {
        checkChannel(channel);
        channel.mAsyncChannel.sendMessage(0x22010, 0, channel.putListener(actionlistener));
    }

    public void removeLocalService(Channel channel, WifiP2pServiceInfo wifip2pserviceinfo, ActionListener actionlistener) {
        checkChannel(channel);
        checkServiceInfo(wifip2pserviceinfo);
        channel.mAsyncChannel.sendMessage(0x2201f, 0, channel.putListener(actionlistener), wifip2pserviceinfo);
    }

    public void removeServiceRequest(Channel channel, WifiP2pServiceRequest wifip2pservicerequest, ActionListener actionlistener) {
        checkChannel(channel);
        checkServiceRequest(wifip2pservicerequest);
        channel.mAsyncChannel.sendMessage(0x22028, 0, channel.putListener(actionlistener), wifip2pservicerequest);
    }

    public void requestConnectionInfo(Channel channel, ConnectionInfoListener connectioninfolistener) {
        checkChannel(channel);
        channel.mAsyncChannel.sendMessage(0x22015, 0, channel.putListener(connectioninfolistener));
    }

    public void requestGroupInfo(Channel channel, GroupInfoListener groupinfolistener) {
        checkChannel(channel);
        channel.mAsyncChannel.sendMessage(0x22017, 0, channel.putListener(groupinfolistener));
    }

    public void requestPeers(Channel channel, PeerListListener peerlistlistener) {
        checkChannel(channel);
        channel.mAsyncChannel.sendMessage(0x22013, 0, channel.putListener(peerlistlistener));
    }

    public void setDeviceName(Channel channel, String s, ActionListener actionlistener) {
        checkChannel(channel);
        WifiP2pDevice wifip2pdevice = new WifiP2pDevice();
        wifip2pdevice.deviceName = s;
        channel.mAsyncChannel.sendMessage(0x22033, 0, channel.putListener(actionlistener), wifip2pdevice);
    }

    public void setDialogListener(Channel channel, DialogListener dialoglistener) {
        checkChannel(channel);
        channel.setDialogListener(dialoglistener);
        Message message = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putString("appPkgName", channel.mContext.getPackageName());
        boolean flag;
        if(dialoglistener == null)
            flag = true;
        else
            flag = false;
        bundle.putBoolean("dialogResetFlag", flag);
        message.what = 0x22036;
        message.setData(bundle);
        channel.mAsyncChannel.sendMessage(message);
    }

    public void setDnsSdResponseListeners(Channel channel, DnsSdServiceResponseListener dnssdserviceresponselistener, DnsSdTxtRecordListener dnssdtxtrecordlistener) {
        checkChannel(channel);
        channel.mDnsSdServRspListener = dnssdserviceresponselistener;
        channel.mDnsSdTxtListener = dnssdtxtrecordlistener;
    }

    public void setServiceResponseListener(Channel channel, ServiceResponseListener serviceresponselistener) {
        checkChannel(channel);
        channel.mServRspListener = serviceresponselistener;
    }

    public void setUpnpServiceResponseListener(Channel channel, UpnpServiceResponseListener upnpserviceresponselistener) {
        checkChannel(channel);
        channel.mUpnpServRspListener = upnpserviceresponselistener;
    }

    public void stopPeerDiscovery(Channel channel, ActionListener actionlistener) {
        checkChannel(channel);
        channel.mAsyncChannel.sendMessage(0x22004, 0, channel.putListener(actionlistener));
    }

    public static final int ADD_LOCAL_SERVICE = 0x2201c;
    public static final int ADD_LOCAL_SERVICE_FAILED = 0x2201d;
    public static final int ADD_LOCAL_SERVICE_SUCCEEDED = 0x2201e;
    public static final int ADD_SERVICE_REQUEST = 0x22025;
    public static final int ADD_SERVICE_REQUEST_FAILED = 0x22026;
    public static final int ADD_SERVICE_REQUEST_SUCCEEDED = 0x22027;
    public static final String APP_PKG_BUNDLE_KEY = "appPkgName";
    private static final int BASE = 0x22000;
    public static final int BUSY = 2;
    public static final int CANCEL_CONNECT = 0x2200a;
    public static final int CANCEL_CONNECT_FAILED = 0x2200b;
    public static final int CANCEL_CONNECT_SUCCEEDED = 0x2200c;
    public static final int CLEAR_LOCAL_SERVICES = 0x22022;
    public static final int CLEAR_LOCAL_SERVICES_FAILED = 0x22023;
    public static final int CLEAR_LOCAL_SERVICES_SUCCEEDED = 0x22024;
    public static final int CLEAR_SERVICE_REQUESTS = 0x2202b;
    public static final int CLEAR_SERVICE_REQUESTS_FAILED = 0x2202c;
    public static final int CLEAR_SERVICE_REQUESTS_SUCCEEDED = 0x2202d;
    public static final int CONNECT = 0x22007;
    public static final int CONNECTION_REQUESTED = 0x22039;
    public static final int CONNECT_FAILED = 0x22008;
    public static final int CONNECT_SUCCEEDED = 0x22009;
    public static final int CREATE_GROUP = 0x2200d;
    public static final int CREATE_GROUP_FAILED = 0x2200e;
    public static final int CREATE_GROUP_SUCCEEDED = 0x2200f;
    public static final int DIALOG_LISTENER_ATTACHED = 0x22038;
    public static final int DIALOG_LISTENER_DETACHED = 0x22037;
    public static final int DISCOVER_PEERS = 0x22001;
    public static final int DISCOVER_PEERS_FAILED = 0x22002;
    public static final int DISCOVER_PEERS_SUCCEEDED = 0x22003;
    public static final int DISCOVER_SERVICES = 0x2202e;
    public static final int DISCOVER_SERVICES_FAILED = 0x2202f;
    public static final int DISCOVER_SERVICES_SUCCEEDED = 0x22030;
    public static final int ERROR = 0;
    public static final String EXTRA_DISCOVERY_STATE = "discoveryState";
    public static final String EXTRA_LINK_CAPABILITIES = "linkCapabilities";
    public static final String EXTRA_LINK_PROPERTIES = "linkProperties";
    public static final String EXTRA_NETWORK_INFO = "networkInfo";
    public static final String EXTRA_WIFI_P2P_DEVICE = "wifiP2pDevice";
    public static final String EXTRA_WIFI_P2P_INFO = "wifiP2pInfo";
    public static final String EXTRA_WIFI_STATE = "wifi_p2p_state";
    public static final int NOT_IN_FOREGROUND = 4;
    public static final int NO_SERVICE_REQUESTS = 3;
    public static final String P2P_CONFIG_BUNDLE_KEY = "wifiP2pConfig";
    public static final String P2P_DEV_BUNDLE_KEY = "wifiP2pDevice";
    public static final int P2P_UNSUPPORTED = 1;
    public static final int PING = 0x22031;
    public static final int REMOVE_GROUP = 0x22010;
    public static final int REMOVE_GROUP_FAILED = 0x22011;
    public static final int REMOVE_GROUP_SUCCEEDED = 0x22012;
    public static final int REMOVE_LOCAL_SERVICE = 0x2201f;
    public static final int REMOVE_LOCAL_SERVICE_FAILED = 0x22020;
    public static final int REMOVE_LOCAL_SERVICE_SUCCEEDED = 0x22021;
    public static final int REMOVE_SERVICE_REQUEST = 0x22028;
    public static final int REMOVE_SERVICE_REQUEST_FAILED = 0x22029;
    public static final int REMOVE_SERVICE_REQUEST_SUCCEEDED = 0x2202a;
    public static final int REQUEST_CONNECTION_INFO = 0x22015;
    public static final int REQUEST_GROUP_INFO = 0x22017;
    public static final int REQUEST_PEERS = 0x22013;
    public static final String RESET_DIALOG_LISTENER_BUNDLE_KEY = "dialogResetFlag";
    public static final int RESPONSE_CONNECTION_INFO = 0x22016;
    public static final int RESPONSE_GROUP_INFO = 0x22018;
    public static final int RESPONSE_PEERS = 0x22014;
    public static final int RESPONSE_SERVICE = 0x22032;
    public static final int SET_DEVICE_NAME = 0x22033;
    public static final int SET_DEVICE_NAME_FAILED = 0x22034;
    public static final int SET_DEVICE_NAME_SUCCEEDED = 0x22035;
    public static final int SET_DIALOG_LISTENER = 0x22036;
    public static final int SHOW_PIN_REQUESTED = 0x2203a;
    public static final int STOP_DISCOVERY = 0x22004;
    public static final int STOP_DISCOVERY_FAILED = 0x22005;
    public static final int STOP_DISCOVERY_SUCCEEDED = 0x22006;
    private static final String TAG = "WifiP2pManager";
    public static final String WIFI_P2P_CONNECTION_CHANGED_ACTION = "android.net.wifi.p2p.CONNECTION_STATE_CHANGE";
    public static final String WIFI_P2P_DISCOVERY_CHANGED_ACTION = "android.net.wifi.p2p.DISCOVERY_STATE_CHANGE";
    public static final int WIFI_P2P_DISCOVERY_STARTED = 2;
    public static final int WIFI_P2P_DISCOVERY_STOPPED = 1;
    public static final String WIFI_P2P_PEERS_CHANGED_ACTION = "android.net.wifi.p2p.PEERS_CHANGED";
    public static final String WIFI_P2P_STATE_CHANGED_ACTION = "android.net.wifi.p2p.STATE_CHANGED";
    public static final int WIFI_P2P_STATE_DISABLED = 1;
    public static final int WIFI_P2P_STATE_ENABLED = 2;
    public static final String WIFI_P2P_THIS_DEVICE_CHANGED_ACTION = "android.net.wifi.p2p.THIS_DEVICE_CHANGED";
    public static final String WPS_PIN_BUNDLE_KEY = "wpsPin";
    IWifiP2pManager mService;
}
