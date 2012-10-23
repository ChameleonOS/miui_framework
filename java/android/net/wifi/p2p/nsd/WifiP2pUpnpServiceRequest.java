// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi.p2p.nsd;


// Referenced classes of package android.net.wifi.p2p.nsd:
//            WifiP2pServiceRequest, WifiP2pServiceInfo

public class WifiP2pUpnpServiceRequest extends WifiP2pServiceRequest {

    protected WifiP2pUpnpServiceRequest() {
        super(2, null);
    }

    protected WifiP2pUpnpServiceRequest(String s) {
        super(2, s);
    }

    public static WifiP2pUpnpServiceRequest newInstance() {
        return new WifiP2pUpnpServiceRequest();
    }

    public static WifiP2pUpnpServiceRequest newInstance(String s) {
        if(s == null) {
            throw new IllegalArgumentException("search target cannot be null");
        } else {
            StringBuffer stringbuffer = new StringBuffer();
            Object aobj[] = new Object[1];
            aobj[0] = Integer.valueOf(16);
            stringbuffer.append(String.format("%02x", aobj));
            stringbuffer.append(WifiP2pServiceInfo.bin2HexStr(s.getBytes()));
            return new WifiP2pUpnpServiceRequest(stringbuffer.toString());
        }
    }
}
