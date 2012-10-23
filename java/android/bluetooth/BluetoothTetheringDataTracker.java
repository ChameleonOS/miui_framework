// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.bluetooth;

import android.content.Context;
import android.net.*;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package android.bluetooth:
//            BluetoothAdapter, BluetoothPan, BluetoothDevice, BluetoothProfile

public class BluetoothTetheringDataTracker
    implements NetworkStateTracker {

    private BluetoothTetheringDataTracker() {
        mTeardownRequested = new AtomicBoolean(false);
        mPrivateDnsRouteSet = new AtomicBoolean(false);
        mDefaultGatewayAddr = new AtomicInteger(0);
        mDefaultRouteSet = new AtomicBoolean(false);
        mProfileServiceListener = new BluetoothProfile.ServiceListener() {

            public void onServiceConnected(int i, BluetoothProfile bluetoothprofile) {
                mBluetoothPan = (BluetoothPan)bluetoothprofile;
            }

            public void onServiceDisconnected(int i) {
                mBluetoothPan = null;
            }

            final BluetoothTetheringDataTracker this$0;

             {
                this$0 = BluetoothTetheringDataTracker.this;
                super();
            }
        };
        mNetworkInfo = new NetworkInfo(7, 0, "BLUETOOTH_TETHER", "");
        mLinkProperties = new LinkProperties();
        mLinkCapabilities = new LinkCapabilities();
        mNetworkInfo.setIsAvailable(false);
        setTeardownRequested(false);
    }

    /**
     * @deprecated Method getInstance is deprecated
     */

    public static BluetoothTetheringDataTracker getInstance() {
        android/bluetooth/BluetoothTetheringDataTracker;
        JVM INSTR monitorenter ;
        BluetoothTetheringDataTracker bluetoothtetheringdatatracker;
        if(sInstance == null)
            sInstance = new BluetoothTetheringDataTracker();
        bluetoothtetheringdatatracker = sInstance;
        android/bluetooth/BluetoothTetheringDataTracker;
        JVM INSTR monitorexit ;
        return bluetoothtetheringdatatracker;
        Exception exception;
        exception;
        throw exception;
    }

    public Object Clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public void defaultRouteSet(boolean flag) {
        mDefaultRouteSet.set(flag);
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
        mTeardownRequested.set(false);
        return true;
    }

    public void setDependencyMet(boolean flag) {
    }

    public void setPolicyDataEnable(boolean flag) {
        Log.w("BluetoothTethering", (new StringBuilder()).append("ignoring setPolicyDataEnable(").append(flag).append(")").toString());
    }

    public boolean setRadio(boolean flag) {
        return true;
    }

    public void setTeardownRequested(boolean flag) {
        mTeardownRequested.set(flag);
    }

    public void setUserDataEnable(boolean flag) {
        Log.w("BluetoothTethering", (new StringBuilder()).append("ignoring setUserDataEnable(").append(flag).append(")").toString());
    }

    public void startMonitoring(Context context, Handler handler) {
        mContext = context;
        mCsHandler = handler;
        BluetoothAdapter bluetoothadapter = BluetoothAdapter.getDefaultAdapter();
        if(bluetoothadapter != null)
            bluetoothadapter.getProfileProxy(mContext, mProfileServiceListener, 5);
    }

    /**
     * @deprecated Method startReverseTether is deprecated
     */

    public void startReverseTether(String s, BluetoothDevice bluetoothdevice) {
        this;
        JVM INSTR monitorenter ;
        mIface = s;
        mDevice = bluetoothdevice;
        (new Thread(new Runnable() {

            public void run() {
                DhcpInfoInternal dhcpinfointernal = new DhcpInfoInternal();
                if(!NetworkUtils.runDhcp(BluetoothTetheringDataTracker.mIface, dhcpinfointernal)) {
                    Log.e("BluetoothTethering", (new StringBuilder()).append("DHCP request error:").append(NetworkUtils.getDhcpError()).toString());
                } else {
                    mLinkProperties = dhcpinfointernal.makeLinkProperties();
                    mLinkProperties.setInterfaceName(BluetoothTetheringDataTracker.mIface);
                    mNetworkInfo.setIsAvailable(true);
                    mNetworkInfo.setDetailedState(android.net.NetworkInfo.DetailedState.CONNECTED, null, null);
                    mCsHandler.obtainMessage(3, mNetworkInfo).sendToTarget();
                    mCsHandler.obtainMessage(1, mNetworkInfo).sendToTarget();
                }
            }

            final BluetoothTetheringDataTracker this$0;

             {
                this$0 = BluetoothTetheringDataTracker.this;
                super();
            }
        })).start();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public int startUsingNetworkFeature(String s, int i, int j) {
        return -1;
    }

    /**
     * @deprecated Method stopReverseTether is deprecated
     */

    public void stopReverseTether(String s) {
        this;
        JVM INSTR monitorenter ;
        NetworkUtils.stopDhcp(s);
        mLinkProperties.clear();
        mNetworkInfo.setIsAvailable(false);
        mNetworkInfo.setDetailedState(android.net.NetworkInfo.DetailedState.DISCONNECTED, null, null);
        mCsHandler.obtainMessage(3, mNetworkInfo).sendToTarget();
        mCsHandler.obtainMessage(1, mNetworkInfo).sendToTarget();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public int stopUsingNetworkFeature(String s, int i, int j) {
        return -1;
    }

    public boolean teardown() {
        mTeardownRequested.set(true);
        if(mBluetoothPan != null) {
            BluetoothDevice bluetoothdevice;
            for(Iterator iterator = mBluetoothPan.getConnectedDevices().iterator(); iterator.hasNext(); mBluetoothPan.disconnect(bluetoothdevice))
                bluetoothdevice = (BluetoothDevice)iterator.next();

        }
        return true;
    }

    private static final String NETWORKTYPE = "BLUETOOTH_TETHER";
    private static final String TAG = "BluetoothTethering";
    private static String mIface;
    public static BluetoothTetheringDataTracker sInstance;
    private BluetoothPan mBluetoothPan;
    private Context mContext;
    private Handler mCsHandler;
    private AtomicInteger mDefaultGatewayAddr;
    private AtomicBoolean mDefaultRouteSet;
    private BluetoothDevice mDevice;
    private LinkCapabilities mLinkCapabilities;
    private LinkProperties mLinkProperties;
    private NetworkInfo mNetworkInfo;
    private AtomicBoolean mPrivateDnsRouteSet;
    private BluetoothProfile.ServiceListener mProfileServiceListener;
    private AtomicBoolean mTeardownRequested;


/*
    static BluetoothPan access$002(BluetoothTetheringDataTracker bluetoothtetheringdatatracker, BluetoothPan bluetoothpan) {
        bluetoothtetheringdatatracker.mBluetoothPan = bluetoothpan;
        return bluetoothpan;
    }

*/




/*
    static LinkProperties access$202(BluetoothTetheringDataTracker bluetoothtetheringdatatracker, LinkProperties linkproperties) {
        bluetoothtetheringdatatracker.mLinkProperties = linkproperties;
        return linkproperties;
    }

*/


}
