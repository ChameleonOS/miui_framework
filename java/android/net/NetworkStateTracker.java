// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.content.Context;
import android.os.Handler;

// Referenced classes of package android.net:
//            LinkCapabilities, LinkProperties, NetworkInfo

public interface NetworkStateTracker {

    public abstract void defaultRouteSet(boolean flag);

    public abstract LinkCapabilities getLinkCapabilities();

    public abstract LinkProperties getLinkProperties();

    public abstract NetworkInfo getNetworkInfo();

    public abstract String getTcpBufferSizesPropName();

    public abstract boolean isAvailable();

    public abstract boolean isDefaultRouteSet();

    public abstract boolean isPrivateDnsRouteSet();

    public abstract boolean isTeardownRequested();

    public abstract void privateDnsRouteSet(boolean flag);

    public abstract boolean reconnect();

    public abstract void setDependencyMet(boolean flag);

    public abstract void setPolicyDataEnable(boolean flag);

    public abstract boolean setRadio(boolean flag);

    public abstract void setTeardownRequested(boolean flag);

    public abstract void setUserDataEnable(boolean flag);

    public abstract void startMonitoring(Context context, Handler handler);

    public abstract boolean teardown();

    public static final int EVENT_CONFIGURATION_CHANGED = 3;
    public static final int EVENT_RESTORE_DEFAULT_NETWORK = 6;
    public static final int EVENT_STATE_CHANGED = 1;
    public static final int MAX_NETWORK_STATE_TRACKER_EVENT = 100;
    public static final int MIN_NETWORK_STATE_TRACKER_EVENT = 1;
}
