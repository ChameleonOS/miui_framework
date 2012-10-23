// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.content.Context;
import android.content.res.Resources;
import android.os.*;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package android.net:
//            NetworkStateTracker, NetworkInfo, LinkProperties, LinkCapabilities, 
//            NetworkUtils, InterfaceConfiguration, DhcpInfoInternal

public class EthernetDataTracker
    implements NetworkStateTracker {
    private static class InterfaceObserver extends INetworkManagementEventObserver.Stub {

        public void interfaceAdded(String s) {
            mTracker.interfaceAdded(s);
        }

        public void interfaceLinkStateChanged(String s, boolean flag) {
            if(EthernetDataTracker.mIface.equals(s) && EthernetDataTracker.mLinkUp != flag) {
                StringBuilder stringbuilder = (new StringBuilder()).append("Interface ").append(s).append(" link ");
                String s1;
                if(flag)
                    s1 = "up";
                else
                    s1 = "down";
                Log.d("Ethernet", stringbuilder.append(s1).toString());
                EthernetDataTracker.mLinkUp = flag;
                mTracker.mNetworkInfo.setIsAvailable(flag);
                if(flag)
                    mTracker.reconnect();
                else
                    mTracker.disconnect();
            }
        }

        public void interfaceRemoved(String s) {
            mTracker.interfaceRemoved(s);
        }

        public void interfaceStatusChanged(String s, boolean flag) {
            StringBuilder stringbuilder = (new StringBuilder()).append("Interface status changed: ").append(s);
            String s1;
            if(flag)
                s1 = "up";
            else
                s1 = "down";
            Log.d("Ethernet", stringbuilder.append(s1).toString());
        }

        public void limitReached(String s, String s1) {
        }

        private EthernetDataTracker mTracker;

        InterfaceObserver(EthernetDataTracker ethernetdatatracker) {
            mTracker = ethernetdatatracker;
        }
    }


    private EthernetDataTracker() {
        mTeardownRequested = new AtomicBoolean(false);
        mPrivateDnsRouteSet = new AtomicBoolean(false);
        mDefaultGatewayAddr = new AtomicInteger(0);
        mDefaultRouteSet = new AtomicBoolean(false);
        mNetworkInfo = new NetworkInfo(9, 0, "ETHERNET", "");
        mLinkProperties = new LinkProperties();
        mLinkCapabilities = new LinkCapabilities();
    }

    /**
     * @deprecated Method getInstance is deprecated
     */

    public static EthernetDataTracker getInstance() {
        android/net/EthernetDataTracker;
        JVM INSTR monitorenter ;
        EthernetDataTracker ethernetdatatracker;
        if(sInstance == null)
            sInstance = new EthernetDataTracker();
        ethernetdatatracker = sInstance;
        android/net/EthernetDataTracker;
        JVM INSTR monitorexit ;
        return ethernetdatatracker;
        Exception exception;
        exception;
        throw exception;
    }

    private void interfaceAdded(String s) {
        if(s.matches(sIfaceMatch)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Log.d("Ethernet", (new StringBuilder()).append("Adding ").append(s).toString());
        this;
        JVM INSTR monitorenter ;
        if(!mIface.isEmpty())
            continue; /* Loop/switch isn't completed */
        break MISSING_BLOCK_LABEL_57;
        Exception exception;
        exception;
        throw exception;
        mIface = s;
        this;
        JVM INSTR monitorexit ;
        try {
            mNMService.setInterfaceUp(s);
        }
        catch(Exception exception1) {
            Log.e("Ethernet", (new StringBuilder()).append("Error upping interface ").append(s).append(": ").append(exception1).toString());
        }
        mNetworkInfo.setIsAvailable(true);
        mCsHandler.obtainMessage(3, mNetworkInfo).sendToTarget();
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void interfaceRemoved(String s) {
        if(s.equals(mIface)) {
            Log.d("Ethernet", (new StringBuilder()).append("Removing ").append(s).toString());
            disconnect();
            mIface = "";
        }
    }

    private void runDhcp() {
        (new Thread(new Runnable() {

            public void run() {
                DhcpInfoInternal dhcpinfointernal = new DhcpInfoInternal();
                if(!NetworkUtils.runDhcp(EthernetDataTracker.mIface, dhcpinfointernal)) {
                    Log.e("Ethernet", (new StringBuilder()).append("DHCP request error:").append(NetworkUtils.getDhcpError()).toString());
                } else {
                    mLinkProperties = dhcpinfointernal.makeLinkProperties();
                    mLinkProperties.setInterfaceName(EthernetDataTracker.mIface);
                    mNetworkInfo.setDetailedState(NetworkInfo.DetailedState.CONNECTED, null, mHwAddr);
                    mCsHandler.obtainMessage(1, mNetworkInfo).sendToTarget();
                }
            }

            final EthernetDataTracker this$0;

             {
                this$0 = EthernetDataTracker.this;
                super();
            }
        })).start();
    }

    public Object Clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public void defaultRouteSet(boolean flag) {
        mDefaultRouteSet.set(flag);
    }

    public void disconnect() {
        INetworkManagementService inetworkmanagementservice;
        NetworkUtils.stopDhcp(mIface);
        mLinkProperties.clear();
        mNetworkInfo.setIsAvailable(false);
        mNetworkInfo.setDetailedState(NetworkInfo.DetailedState.DISCONNECTED, null, mHwAddr);
        mCsHandler.obtainMessage(3, mNetworkInfo).sendToTarget();
        mCsHandler.obtainMessage(1, mNetworkInfo).sendToTarget();
        inetworkmanagementservice = android.os.INetworkManagementService.Stub.asInterface(ServiceManager.getService("network_management"));
        inetworkmanagementservice.clearInterfaceAddresses(mIface);
_L1:
        return;
        Exception exception;
        exception;
        Log.e("Ethernet", (new StringBuilder()).append("Failed to clear addresses or disable ipv6").append(exception).toString());
          goto _L1
    }

    public int getDefaultGatewayAddr() {
        return mDefaultGatewayAddr.get();
    }

    public LinkCapabilities getLinkCapabilities() {
        return new LinkCapabilities(mLinkCapabilities);
    }

    /**
     * @deprecated Method getLinkProperties is deprecated
     */

    public LinkProperties getLinkProperties() {
        this;
        JVM INSTR monitorenter ;
        LinkProperties linkproperties = new LinkProperties(mLinkProperties);
        this;
        JVM INSTR monitorexit ;
        return linkproperties;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getNetworkInfo is deprecated
     */

    public NetworkInfo getNetworkInfo() {
        this;
        JVM INSTR monitorenter ;
        NetworkInfo networkinfo = mNetworkInfo;
        this;
        JVM INSTR monitorexit ;
        return networkinfo;
        Exception exception;
        exception;
        throw exception;
    }

    public String getTcpBufferSizesPropName() {
        return "net.tcp.buffersize.wifi";
    }

    /**
     * @deprecated Method isAvailable is deprecated
     */

    public boolean isAvailable() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mNetworkInfo.isAvailable();
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isDefaultRouteSet() {
        return mDefaultRouteSet.get();
    }

    public boolean isPrivateDnsRouteSet() {
        return mPrivateDnsRouteSet.get();
    }

    public boolean isTeardownRequested() {
        return mTeardownRequested.get();
    }

    public void privateDnsRouteSet(boolean flag) {
        mPrivateDnsRouteSet.set(flag);
    }

    public boolean reconnect() {
        if(mLinkUp) {
            mTeardownRequested.set(false);
            runDhcp();
        }
        return mLinkUp;
    }

    public void setDependencyMet(boolean flag) {
    }

    public void setPolicyDataEnable(boolean flag) {
        Log.w("Ethernet", (new StringBuilder()).append("ignoring setPolicyDataEnable(").append(flag).append(")").toString());
    }

    public boolean setRadio(boolean flag) {
        return true;
    }

    public void setTeardownRequested(boolean flag) {
        mTeardownRequested.set(flag);
    }

    public void setUserDataEnable(boolean flag) {
        Log.w("Ethernet", (new StringBuilder()).append("ignoring setUserDataEnable(").append(flag).append(")").toString());
    }

    public void startMonitoring(Context context, Handler handler) {
        mContext = context;
        mCsHandler = handler;
        mNMService = android.os.INetworkManagementService.Stub.asInterface(ServiceManager.getService("network_management"));
        mInterfaceObserver = new InterfaceObserver(this);
        sIfaceMatch = context.getResources().getString(0x1040018);
        String as[];
        int i;
        int j;
        as = mNMService.listInterfaces();
        i = as.length;
        j = 0;
_L5:
        if(j >= i) goto _L2; else goto _L1
_L1:
        String s = as[j];
        if(!s.matches(sIfaceMatch)) goto _L4; else goto _L3
_L3:
        mIface = s;
        mNMService.setInterfaceUp(s);
        InterfaceConfiguration interfaceconfiguration = mNMService.getInterfaceConfig(s);
        mLinkUp = interfaceconfiguration.isActive();
        if(interfaceconfiguration != null && mHwAddr == null) {
            mHwAddr = interfaceconfiguration.getHardwareAddress();
            if(mHwAddr != null)
                mNetworkInfo.setExtraInfo(mHwAddr);
        }
        reconnect();
_L2:
        mNMService.registerObserver(mInterfaceObserver);
_L6:
        return;
_L4:
        j++;
          goto _L5
        RemoteException remoteexception;
        remoteexception;
        Log.e("Ethernet", (new StringBuilder()).append("Could not get list of interfaces ").append(remoteexception).toString());
          goto _L2
        RemoteException remoteexception1;
        remoteexception1;
        Log.e("Ethernet", (new StringBuilder()).append("Could not register InterfaceObserver ").append(remoteexception1).toString());
          goto _L6
    }

    public int startUsingNetworkFeature(String s, int i, int j) {
        return -1;
    }

    public int stopUsingNetworkFeature(String s, int i, int j) {
        return -1;
    }

    public boolean teardown() {
        mTeardownRequested.set(true);
        NetworkUtils.stopDhcp(mIface);
        return true;
    }

    private static final String NETWORKTYPE = "ETHERNET";
    private static final String TAG = "Ethernet";
    private static String mIface = "";
    private static boolean mLinkUp;
    private static String sIfaceMatch = "";
    private static EthernetDataTracker sInstance;
    private Context mContext;
    private Handler mCsHandler;
    private AtomicInteger mDefaultGatewayAddr;
    private AtomicBoolean mDefaultRouteSet;
    private String mHwAddr;
    private InterfaceObserver mInterfaceObserver;
    private LinkCapabilities mLinkCapabilities;
    private LinkProperties mLinkProperties;
    private INetworkManagementService mNMService;
    private NetworkInfo mNetworkInfo;
    private AtomicBoolean mPrivateDnsRouteSet;
    private AtomicBoolean mTeardownRequested;





/*
    static boolean access$102(boolean flag) {
        mLinkUp = flag;
        return flag;
    }

*/






/*
    static LinkProperties access$502(EthernetDataTracker ethernetdatatracker, LinkProperties linkproperties) {
        ethernetdatatracker.mLinkProperties = linkproperties;
        return linkproperties;
    }

*/


}
