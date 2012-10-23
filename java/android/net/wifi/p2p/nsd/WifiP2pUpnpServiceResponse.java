// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi.p2p.nsd;

import android.net.wifi.p2p.WifiP2pDevice;
import java.util.*;

// Referenced classes of package android.net.wifi.p2p.nsd:
//            WifiP2pServiceResponse

public class WifiP2pUpnpServiceResponse extends WifiP2pServiceResponse {

    protected WifiP2pUpnpServiceResponse(int i, int j, WifiP2pDevice wifip2pdevice, byte abyte0[]) {
        super(2, i, j, wifip2pdevice, abyte0);
        if(!parse())
            throw new IllegalArgumentException("Malformed upnp service response");
        else
            return;
    }

    static WifiP2pUpnpServiceResponse newInstance(int i, int j, WifiP2pDevice wifip2pdevice, byte abyte0[]) {
        WifiP2pUpnpServiceResponse wifip2pupnpserviceresponse;
        if(i != 0)
            wifip2pupnpserviceresponse = new WifiP2pUpnpServiceResponse(i, j, wifip2pdevice, null);
        else
            try {
                wifip2pupnpserviceresponse = new WifiP2pUpnpServiceResponse(i, j, wifip2pdevice, abyte0);
            }
            catch(IllegalArgumentException illegalargumentexception) {
                illegalargumentexception.printStackTrace();
                wifip2pupnpserviceresponse = null;
            }
        return wifip2pupnpserviceresponse;
    }

    private boolean parse() {
        boolean flag = true;
        if(super.mData != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(super.mData.length >= flag)
            break; /* Loop/switch isn't completed */
        flag = false;
        if(true) goto _L1; else goto _L3
_L3:
        mVersion = 0xff & super.mData[0];
        String as[] = (new String(super.mData, flag, -1 + super.mData.length)).split(",");
        mUniqueServiceNames = new ArrayList();
        int i = as.length;
        int j = 0;
        while(j < i)  {
            String s = as[j];
            mUniqueServiceNames.add(s);
            j++;
        }
        if(true) goto _L1; else goto _L4
_L4:
    }

    public List getUniqueServiceNames() {
        return mUniqueServiceNames;
    }

    public int getVersion() {
        return mVersion;
    }

    public String toString() {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("serviceType:UPnP(").append(super.mServiceType).append(")");
        stringbuffer.append(" status:").append(WifiP2pServiceResponse.Status.toString(super.mStatus));
        stringbuffer.append(" srcAddr:").append(super.mDevice.deviceAddress);
        StringBuffer stringbuffer1 = stringbuffer.append(" version:");
        Object aobj[] = new Object[1];
        aobj[0] = Integer.valueOf(mVersion);
        stringbuffer1.append(String.format("%02x", aobj));
        if(mUniqueServiceNames != null) {
            String s;
            for(Iterator iterator = mUniqueServiceNames.iterator(); iterator.hasNext(); stringbuffer.append(" usn:").append(s))
                s = (String)iterator.next();

        }
        return stringbuffer.toString();
    }

    private List mUniqueServiceNames;
    private int mVersion;
}
