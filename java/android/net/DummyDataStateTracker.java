// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Slog;

// Referenced classes of package android.net:
//            NetworkStateTracker, NetworkInfo, LinkCapabilities, LinkProperties

public class DummyDataStateTracker
    implements NetworkStateTracker {

    public DummyDataStateTracker(int i, String s) {
        mTeardownRequested = false;
        mPrivateDnsRouteSet = false;
        mDefaultRouteSet = false;
        mIsDefaultOrHipri = false;
        mNetworkInfo = new NetworkInfo(i);
    }

    private static void log(String s) {
        Slog.d("DummyDataStateTracker", s);
    }

    private static void loge(String s) {
        Slog.e("DummyDataStateTracker", s);
    }

    private void setDetailedState(NetworkInfo.DetailedState detailedstate, String s, String s1) {
        log((new StringBuilder()).append("setDetailed state, old =").append(mNetworkInfo.getDetailedState()).append(" and new state=").append(detailedstate).toString());
        mNetworkInfo.setDetailedState(detailedstate, s, s1);
        mTarget.obtainMessage(1, mNetworkInfo).sendToTarget();
    }

    public void defaultRouteSet(boolean flag) {
        mDefaultRouteSet = flag;
    }

    public LinkCapabilities getLinkCapabilities() {
        return new LinkCapabilities(mLinkCapabilities);
    }

    public LinkProperties getLinkProperties() {
        return new LinkProperties(mLinkProperties);
    }

    public NetworkInfo getNetworkInfo() {
        return mNetworkInfo;
    }

    public String getTcpBufferSizesPropName() {
        return "net.tcp.buffersize.unknown";
    }

    public boolean isAvailable() {
        return true;
    }

    public boolean isDefaultRouteSet() {
        return mDefaultRouteSet;
    }

    public boolean isPrivateDnsRouteSet() {
        return mPrivateDnsRouteSet;
    }

    public boolean isTeardownRequested() {
        return mTeardownRequested;
    }

    public void privateDnsRouteSet(boolean flag) {
        mPrivateDnsRouteSet = flag;
    }

    public boolean reconnect() {
        setDetailedState(NetworkInfo.DetailedState.CONNECTING, "enabled", null);
        setDetailedState(NetworkInfo.DetailedState.CONNECTED, "enabled", null);
        setTeardownRequested(false);
        return true;
    }

    public void releaseWakeLock() {
    }

    public void setDependencyMet(boolean flag) {
    }

    public void setPolicyDataEnable(boolean flag) {
    }

    public boolean setRadio(boolean flag) {
        return true;
    }

    public void setTeardownRequested(boolean flag) {
        mTeardownRequested = flag;
    }

    public void setUserDataEnable(boolean flag) {
    }

    public void startMonitoring(Context context, Handler handler) {
        mTarget = handler;
        mContext = context;
    }

    public boolean teardown() {
        setDetailedState(NetworkInfo.DetailedState.DISCONNECTING, "disabled", null);
        setDetailedState(NetworkInfo.DetailedState.DISCONNECTED, "disabled", null);
        return true;
    }

    public String toString() {
        return (new StringBuffer("Dummy data state: none, dummy!")).toString();
    }

    private static final boolean DBG = true;
    private static final String TAG = "DummyDataStateTracker";
    private static final boolean VDBG;
    private Context mContext;
    private boolean mDefaultRouteSet;
    private boolean mIsDefaultOrHipri;
    private LinkCapabilities mLinkCapabilities;
    private LinkProperties mLinkProperties;
    private NetworkInfo mNetworkInfo;
    private boolean mPrivateDnsRouteSet;
    private Handler mTarget;
    private boolean mTeardownRequested;
}
