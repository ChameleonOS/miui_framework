// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi.p2p.nsd;

import android.net.wifi.p2p.WifiP2pDevice;
import java.io.*;
import java.util.*;

// Referenced classes of package android.net.wifi.p2p.nsd:
//            WifiP2pServiceResponse

public class WifiP2pDnsSdServiceResponse extends WifiP2pServiceResponse {

    protected WifiP2pDnsSdServiceResponse(int i, int j, WifiP2pDevice wifip2pdevice, byte abyte0[]) {
        super(1, i, j, wifip2pdevice, abyte0);
        if(!parse())
            throw new IllegalArgumentException("Malformed bonjour service response");
        else
            return;
    }

    static WifiP2pDnsSdServiceResponse newInstance(int i, int j, WifiP2pDevice wifip2pdevice, byte abyte0[]) {
        WifiP2pDnsSdServiceResponse wifip2pdnssdserviceresponse;
        if(i != 0)
            wifip2pdnssdserviceresponse = new WifiP2pDnsSdServiceResponse(i, j, wifip2pdevice, null);
        else
            try {
                wifip2pdnssdserviceresponse = new WifiP2pDnsSdServiceResponse(i, j, wifip2pdevice, abyte0);
            }
            catch(IllegalArgumentException illegalargumentexception) {
                illegalargumentexception.printStackTrace();
                wifip2pdnssdserviceresponse = null;
            }
        return wifip2pdnssdserviceresponse;
    }

    private boolean parse() {
        boolean flag = true;
        if(super.mData != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        DataInputStream datainputstream;
        datainputstream = new DataInputStream(new ByteArrayInputStream(super.mData));
        mDnsQueryName = readDnsName(datainputstream);
        if(mDnsQueryName == null) {
            flag = false;
            continue; /* Loop/switch isn't completed */
        }
        mDnsType = datainputstream.readUnsignedShort();
        mVersion = datainputstream.readUnsignedByte();
        if(mDnsType == 12) {
            String s = readDnsName(datainputstream);
            IOException ioexception;
            if(s == null)
                flag = false;
            else
            if(s.length() <= mDnsQueryName.length())
                flag = false;
            else
                mInstanceName = s.substring(0, -1 + (s.length() - mDnsQueryName.length()));
        } else
        if(mDnsType == 16)
            flag = readTxtData(datainputstream);
        else
            flag = false;
        continue; /* Loop/switch isn't completed */
        ioexception;
        ioexception.printStackTrace();
        flag = false;
        if(true) goto _L1; else goto _L3
_L3:
    }

    private String readDnsName(DataInputStream datainputstream) {
        String s = null;
        StringBuffer stringbuffer = new StringBuffer();
        HashMap hashmap = new HashMap(sVmpack);
        if(mDnsQueryName != null)
            hashmap.put(Integer.valueOf(39), mDnsQueryName);
        try {
            do {
                int i = datainputstream.readUnsignedByte();
                if(i == 0) {
                    s = stringbuffer.toString();
                    break;
                }
                if(i == 192) {
                    String s1 = (String)hashmap.get(Integer.valueOf(datainputstream.readUnsignedByte()));
                    if(s1 != null) {
                        stringbuffer.append(s1);
                        s = stringbuffer.toString();
                    }
                    break;
                }
                byte abyte0[] = new byte[i];
                datainputstream.readFully(abyte0);
                stringbuffer.append(new String(abyte0));
                stringbuffer.append(".");
            } while(true);
        }
        catch(IOException ioexception) {
            ioexception.printStackTrace();
        }
        return s;
    }

    private boolean readTxtData(DataInputStream datainputstream) {
        boolean flag;
label0:
        {
            flag = false;
            try {
                do {
                    if(datainputstream.available() <= 0)
                        break;
                    int i = datainputstream.readUnsignedByte();
                    if(i == 0)
                        break;
                    byte abyte0[] = new byte[i];
                    datainputstream.readFully(abyte0);
                    String as[] = (new String(abyte0)).split("=");
                    if(as.length != 2)
                        break label0;
                    mTxtRecord.put(as[0], as[1]);
                } while(true);
            }
            catch(IOException ioexception) {
                ioexception.printStackTrace();
                break label0;
            }
            flag = true;
        }
        return flag;
    }

    public String getDnsQueryName() {
        return mDnsQueryName;
    }

    public int getDnsType() {
        return mDnsType;
    }

    public String getInstanceName() {
        return mInstanceName;
    }

    public Map getTxtRecord() {
        return mTxtRecord;
    }

    public int getVersion() {
        return mVersion;
    }

    public String toString() {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("serviceType:DnsSd(").append(super.mServiceType).append(")");
        stringbuffer.append(" status:").append(WifiP2pServiceResponse.Status.toString(super.mStatus));
        stringbuffer.append(" srcAddr:").append(super.mDevice.deviceAddress);
        StringBuffer stringbuffer1 = stringbuffer.append(" version:");
        Object aobj[] = new Object[1];
        aobj[0] = Integer.valueOf(mVersion);
        stringbuffer1.append(String.format("%02x", aobj));
        stringbuffer.append(" dnsName:").append(mDnsQueryName);
        stringbuffer.append(" TxtRecord:");
        String s;
        for(Iterator iterator = mTxtRecord.keySet().iterator(); iterator.hasNext(); stringbuffer.append(" key:").append(s).append(" value:").append((String)mTxtRecord.get(s)))
            s = (String)iterator.next();

        if(mInstanceName != null)
            stringbuffer.append(" InsName:").append(mInstanceName);
        return stringbuffer.toString();
    }

    private static final Map sVmpack;
    private String mDnsQueryName;
    private int mDnsType;
    private String mInstanceName;
    private final HashMap mTxtRecord = new HashMap();
    private int mVersion;

    static  {
        sVmpack = new HashMap();
        sVmpack.put(Integer.valueOf(12), "_tcp.local.");
        sVmpack.put(Integer.valueOf(17), "local.");
        sVmpack.put(Integer.valueOf(28), "_udp.local.");
    }
}
