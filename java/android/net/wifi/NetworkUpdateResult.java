// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi;


class NetworkUpdateResult {

    public NetworkUpdateResult(int i) {
        isNewNetwork = false;
        netId = i;
        ipChanged = false;
        proxyChanged = false;
    }

    public NetworkUpdateResult(boolean flag, boolean flag1) {
        isNewNetwork = false;
        netId = -1;
        ipChanged = flag;
        proxyChanged = flag1;
    }

    public int getNetworkId() {
        return netId;
    }

    public boolean hasIpChanged() {
        return ipChanged;
    }

    public boolean hasProxyChanged() {
        return proxyChanged;
    }

    public boolean isNewNetwork() {
        return isNewNetwork;
    }

    public void setIpChanged(boolean flag) {
        ipChanged = flag;
    }

    public void setIsNewNetwork(boolean flag) {
        isNewNetwork = flag;
    }

    public void setNetworkId(int i) {
        netId = i;
    }

    public void setProxyChanged(boolean flag) {
        proxyChanged = flag;
    }

    boolean ipChanged;
    boolean isNewNetwork;
    int netId;
    boolean proxyChanged;
}
