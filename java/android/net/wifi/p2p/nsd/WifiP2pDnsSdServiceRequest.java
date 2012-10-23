// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi.p2p.nsd;


// Referenced classes of package android.net.wifi.p2p.nsd:
//            WifiP2pServiceRequest, WifiP2pDnsSdServiceInfo

public class WifiP2pDnsSdServiceRequest extends WifiP2pServiceRequest {

    private WifiP2pDnsSdServiceRequest() {
        super(1, null);
    }

    private WifiP2pDnsSdServiceRequest(String s) {
        super(1, s);
    }

    private WifiP2pDnsSdServiceRequest(String s, int i, int j) {
        super(1, WifiP2pDnsSdServiceInfo.createRequest(s, i, j));
    }

    public static WifiP2pDnsSdServiceRequest newInstance() {
        return new WifiP2pDnsSdServiceRequest();
    }

    public static WifiP2pDnsSdServiceRequest newInstance(String s) {
        if(s == null)
            throw new IllegalArgumentException("service type cannot be null");
        else
            return new WifiP2pDnsSdServiceRequest((new StringBuilder()).append(s).append(".local.").toString(), 12, 1);
    }

    public static WifiP2pDnsSdServiceRequest newInstance(String s, String s1) {
        if(s == null || s1 == null)
            throw new IllegalArgumentException("instance name or service type cannot be null");
        else
            return new WifiP2pDnsSdServiceRequest((new StringBuilder()).append(s).append(".").append(s1).append(".local.").toString(), 16, 1);
    }
}
