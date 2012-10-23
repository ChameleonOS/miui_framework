// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi;

import android.content.*;
import android.net.*;
import android.os.Handler;
import android.os.Message;
import android.util.Slog;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package android.net.wifi:
//            WifiManager

public class WifiStateTracker
    implements NetworkStateTracker {
    private class WifiStateReceiver extends BroadcastReceiver {

        public void onReceive(Context context, Intent intent) {
            if(!intent.getAction().equals("android.net.wifi.p2p.CONNECTION_STATE_CHANGE")) goto _L2; else goto _L1
_L1:
            mNetworkInfo = (NetworkInfo)intent.getParcelableExtra("networkInfo");
            mLinkProperties = (LinkProperties)intent.getParcelableExtra("linkProperties");
            if(mLinkProperties == null)
                mLinkProperties = new LinkProperties();
            mLinkCapabilities = (LinkCapabilities)intent.getParcelableExtra("linkCapabilities");
            if(mLinkCapabilities == null)
                mLinkCapabilities = new LinkCapabilities();
_L4:
            return;
_L2:
            if(intent.getAction().equals("android.net.wifi.STATE_CHANGE")) {
                mNetworkInfo = (NetworkInfo)intent.getParcelableExtra("networkInfo");
                mLinkProperties = (LinkProperties)intent.getParcelableExtra("linkProperties");
                if(mLinkProperties == null)
                    mLinkProperties = new LinkProperties();
                mLinkCapabilities = (LinkCapabilities)intent.getParcelableExtra("linkCapabilities");
                if(mLinkCapabilities == null)
                    mLinkCapabilities = new LinkCapabilities();
                android.net.NetworkInfo.State state = mNetworkInfo.getState();
                if(mLastState != state) {
                    mLastState = state;
                    mCsHandler.obtainMessage(1, new NetworkInfo(mNetworkInfo)).sendToTarget();
                }
            } else
            if(intent.getAction().equals("android.net.wifi.LINK_CONFIGURATION_CHANGED")) {
                mLinkProperties = (LinkProperties)intent.getParcelableExtra("linkProperties");
                mCsHandler.obtainMessage(3, mNetworkInfo).sendToTarget();
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        final WifiStateTracker this$0;

        private WifiStateReceiver() {
            this$0 = WifiStateTracker.this;
            super();
        }

    }


    public WifiStateTracker(int i, String s) {
        mTeardownRequested = new AtomicBoolean(false);
        mPrivateDnsRouteSet = new AtomicBoolean(false);
        mDefaultRouteSet = new AtomicBoolean(false);
        mLastState = android.net.NetworkInfo.State.UNKNOWN;
        mNetworkInfo = new NetworkInfo(i, 0, s, "");
        mLinkProperties = new LinkProperties();
        mLinkCapabilities = new LinkCapabilities();
        mNetworkInfo.setIsAvailable(false);
        setTeardownRequested(false);
    }

    public void defaultRouteSet(boolean flag) {
        mDefaultRouteSet.set(flag);
    }

    public LinkCapabilities getLinkCapabilities() {
        return new LinkCapabilities(mLinkCapabilities);
    }

    public LinkProperties getLinkProperties() {
        return new LinkProperties(mLinkProperties);
    }

    public NetworkInfo getNetworkInfo() {
        return new NetworkInfo(mNetworkInfo);
    }

    public String getTcpBufferSizesPropName() {
        return "net.tcp.buffersize.wifi";
    }

    public boolean isAvailable() {
        return mNetworkInfo.isAvailable();
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
        mWifiManager.startWifi();
        return true;
    }

    public void setDependencyMet(boolean flag) {
    }

    public void setPolicyDataEnable(boolean flag) {
    }

    public boolean setRadio(boolean flag) {
        mWifiManager.setWifiEnabled(flag);
        return true;
    }

    public void setTeardownRequested(boolean flag) {
        mTeardownRequested.set(flag);
    }

    public void setUserDataEnable(boolean flag) {
        Slog.w("WifiStateTracker", (new StringBuilder()).append("ignoring setUserDataEnable(").append(flag).append(")").toString());
    }

    public void startMonitoring(Context context, Handler handler) {
        mCsHandler = handler;
        mContext = context;
        mWifiManager = (WifiManager)mContext.getSystemService("wifi");
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.net.wifi.STATE_CHANGE");
        intentfilter.addAction("android.net.wifi.LINK_CONFIGURATION_CHANGED");
        intentfilter.addAction("android.net.wifi.p2p.CONNECTION_STATE_CHANGE");
        mWifiStateReceiver = new WifiStateReceiver();
        mContext.registerReceiver(mWifiStateReceiver, intentfilter);
    }

    public boolean teardown() {
        mTeardownRequested.set(true);
        mWifiManager.stopWifi();
        return true;
    }

    private static final boolean LOGV = true;
    private static final String NETWORKTYPE = "WIFI";
    private static final String TAG = "WifiStateTracker";
    private Context mContext;
    private Handler mCsHandler;
    private AtomicBoolean mDefaultRouteSet;
    private android.net.NetworkInfo.State mLastState;
    private LinkCapabilities mLinkCapabilities;
    private LinkProperties mLinkProperties;
    private NetworkInfo mNetworkInfo;
    private AtomicBoolean mPrivateDnsRouteSet;
    private AtomicBoolean mTeardownRequested;
    private WifiManager mWifiManager;
    private BroadcastReceiver mWifiStateReceiver;



/*
    static NetworkInfo access$102(WifiStateTracker wifistatetracker, NetworkInfo networkinfo) {
        wifistatetracker.mNetworkInfo = networkinfo;
        return networkinfo;
    }

*/



/*
    static LinkProperties access$202(WifiStateTracker wifistatetracker, LinkProperties linkproperties) {
        wifistatetracker.mLinkProperties = linkproperties;
        return linkproperties;
    }

*/



/*
    static LinkCapabilities access$302(WifiStateTracker wifistatetracker, LinkCapabilities linkcapabilities) {
        wifistatetracker.mLinkCapabilities = linkcapabilities;
        return linkcapabilities;
    }

*/



/*
    static android.net.NetworkInfo.State access$402(WifiStateTracker wifistatetracker, android.net.NetworkInfo.State state) {
        wifistatetracker.mLastState = state;
        return state;
    }

*/

}
