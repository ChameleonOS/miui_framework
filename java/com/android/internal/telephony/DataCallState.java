// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.net.*;
import android.os.SystemProperties;
import android.util.Log;
import java.net.*;

public class DataCallState {
    public static final class SetupResult extends Enum {

        public static SetupResult valueOf(String s) {
            return (SetupResult)Enum.valueOf(com/android/internal/telephony/DataCallState$SetupResult, s);
        }

        public static SetupResult[] values() {
            return (SetupResult[])$VALUES.clone();
        }

        public String toString() {
            return (new StringBuilder()).append(name()).append("  SetupResult.mFailCause=").append(mFailCause).toString();
        }

        private static final SetupResult $VALUES[];
        public static final SetupResult ERR_BadCommand;
        public static final SetupResult ERR_GetLastErrorFromRil;
        public static final SetupResult ERR_RilError;
        public static final SetupResult ERR_Stale;
        public static final SetupResult ERR_UnacceptableParameter;
        public static final SetupResult SUCCESS;
        public DataConnection.FailCause mFailCause;

        static  {
            SUCCESS = new SetupResult("SUCCESS", 0);
            ERR_BadCommand = new SetupResult("ERR_BadCommand", 1);
            ERR_UnacceptableParameter = new SetupResult("ERR_UnacceptableParameter", 2);
            ERR_GetLastErrorFromRil = new SetupResult("ERR_GetLastErrorFromRil", 3);
            ERR_Stale = new SetupResult("ERR_Stale", 4);
            ERR_RilError = new SetupResult("ERR_RilError", 5);
            SetupResult asetupresult[] = new SetupResult[6];
            asetupresult[0] = SUCCESS;
            asetupresult[1] = ERR_BadCommand;
            asetupresult[2] = ERR_UnacceptableParameter;
            asetupresult[3] = ERR_GetLastErrorFromRil;
            asetupresult[4] = ERR_Stale;
            asetupresult[5] = ERR_RilError;
            $VALUES = asetupresult;
        }

        private SetupResult(String s, int i) {
            super(s, i);
            mFailCause = DataConnection.FailCause.fromInt(0);
        }
    }


    public DataCallState() {
        version = 0;
        status = 0;
        cid = 0;
        active = 0;
        type = "";
        ifname = "";
        addresses = new String[0];
        dnses = new String[0];
        gateways = new String[0];
        suggestedRetryTime = -1;
    }

    public SetupResult setLinkProperties(LinkProperties linkproperties, boolean flag) {
        String s;
        String as[];
        int i;
        int j;
        String s6;
        boolean flag3;
        if(linkproperties == null)
            linkproperties = new LinkProperties();
        else
            linkproperties.clear();
        if(status != DataConnection.FailCause.NONE.getErrorCode()) goto _L2; else goto _L1
_L1:
        s = (new StringBuilder()).append("net.").append(ifname).append(".").toString();
        String s1 = ifname;
        linkproperties.setInterfaceName(s1);
        if(addresses == null || addresses.length <= 0) goto _L4; else goto _L3
_L3:
        as = addresses;
        i = as.length;
        j = 0;
_L9:
        if(j >= i) goto _L6; else goto _L5
_L5:
        s6 = as[j].trim();
        flag3 = s6.isEmpty();
        if(!flag3) goto _L8; else goto _L7
_L7:
        j++;
          goto _L9
_L8:
        String as4[] = s6.split("/");
        if(as4.length != 2) goto _L11; else goto _L10
_L10:
        int j2;
        s6 = as4[0];
        j2 = Integer.parseInt(as4[1]);
        int i2 = j2;
_L17:
        InetAddress inetaddress3 = NetworkUtils.numericToInetAddress(s6);
        if(inetaddress3.isAnyLocalAddress()) goto _L7; else goto _L12
_L12:
        if(i2 != 0) goto _L14; else goto _L13
_L13:
        if(!(inetaddress3 instanceof Inet4Address)) goto _L16; else goto _L15
_L15:
        i2 = 32;
_L14:
        Log.d("GSM", (new StringBuilder()).append("addr/pl=").append(s6).append("/").append(i2).toString());
        LinkAddress linkaddress = new LinkAddress(inetaddress3, i2);
        linkproperties.addLinkAddress(linkaddress);
          goto _L7
        UnknownHostException unknownhostexception;
        unknownhostexception;
        SetupResult setupresult;
        Log.d("GSM", (new StringBuilder()).append("setLinkProperties: UnknownHostException ").append(unknownhostexception).toString());
        unknownhostexception.printStackTrace();
        setupresult = SetupResult.ERR_UnacceptableParameter;
_L31:
        if(setupresult != SetupResult.SUCCESS) {
            Log.d("GSM", (new StringBuilder()).append("setLinkProperties: error clearing LinkProperties status=").append(status).append(" result=").append(setupresult).toString());
            linkproperties.clear();
        }
        return setupresult;
_L11:
        i2 = 0;
          goto _L17
        IllegalArgumentException illegalargumentexception3;
        illegalargumentexception3;
        throw new UnknownHostException((new StringBuilder()).append("Non-numeric ip addr=").append(s6).toString());
_L4:
        throw new UnknownHostException((new StringBuilder()).append("no address for ifname=").append(ifname).toString());
_L6:
        if(dnses == null || dnses.length <= 0) goto _L19; else goto _L18
_L18:
        String as3[];
        int k1;
        int l1;
        as3 = dnses;
        k1 = as3.length;
        l1 = 0;
_L22:
        if(l1 >= k1) goto _L21; else goto _L20
_L20:
        String s5;
        boolean flag2;
        s5 = as3[l1].trim();
        flag2 = s5.isEmpty();
        if(!flag2)
            break MISSING_BLOCK_LABEL_479;
_L23:
        l1++;
          goto _L22
        InetAddress inetaddress2;
        try {
            inetaddress2 = NetworkUtils.numericToInetAddress(s5);
        }
        catch(IllegalArgumentException illegalargumentexception2) {
            throw new UnknownHostException((new StringBuilder()).append("Non-numeric dns addr=").append(s5).toString());
        }
        if(!inetaddress2.isAnyLocalAddress())
            linkproperties.addDns(inetaddress2);
          goto _L23
_L19:
        if(!flag) goto _L25; else goto _L24
_L24:
        String as1[];
        int k;
        int l;
        as1 = new String[2];
        as1[0] = SystemProperties.get((new StringBuilder()).append(s).append("dns1").toString());
        as1[1] = SystemProperties.get((new StringBuilder()).append(s).append("dns2").toString());
        k = as1.length;
        l = 0;
_L27:
        if(l >= k) goto _L21; else goto _L26
_L26:
        String s4;
        boolean flag1;
        s4 = as1[l].trim();
        flag1 = s4.isEmpty();
        if(!flag1)
            break MISSING_BLOCK_LABEL_640;
_L28:
        l++;
          goto _L27
        InetAddress inetaddress1;
        try {
            inetaddress1 = NetworkUtils.numericToInetAddress(s4);
        }
        catch(IllegalArgumentException illegalargumentexception1) {
            throw new UnknownHostException((new StringBuilder()).append("Non-numeric dns addr=").append(s4).toString());
        }
        if(!inetaddress1.isAnyLocalAddress())
            linkproperties.addDns(inetaddress1);
          goto _L28
_L25:
        throw new UnknownHostException("Empty dns response and no system default dns");
          goto _L27
_L21:
        int j1;
        String s3;
        if(gateways == null || gateways.length == 0) {
            String s2 = SystemProperties.get((new StringBuilder()).append(s).append("gw").toString());
            String as2[];
            int i1;
            if(s2 != null)
                gateways = s2.split(" ");
            else
                gateways = new String[0];
        }
        as2 = gateways;
        i1 = as2.length;
        j1 = 0;
_L32:
        if(j1 >= i1) goto _L30; else goto _L29
_L29:
        s3 = as2[j1].trim();
        if(s3.isEmpty())
            break MISSING_BLOCK_LABEL_915;
        InetAddress inetaddress;
        try {
            inetaddress = NetworkUtils.numericToInetAddress(s3);
        }
        catch(IllegalArgumentException illegalargumentexception) {
            throw new UnknownHostException((new StringBuilder()).append("Non-numeric gateway addr=").append(s3).toString());
        }
        if(!inetaddress.isAnyLocalAddress()) {
            RouteInfo routeinfo = new RouteInfo(inetaddress);
            linkproperties.addRoute(routeinfo);
        }
        break MISSING_BLOCK_LABEL_915;
_L30:
        setupresult = SetupResult.SUCCESS;
          goto _L31
_L2:
        if(version < 4)
            setupresult = SetupResult.ERR_GetLastErrorFromRil;
        else
            setupresult = SetupResult.ERR_RilError;
          goto _L31
_L16:
        i2 = 128;
          goto _L14
        j1++;
          goto _L32
    }

    public String toString() {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("DataCallState: {").append("version=").append(version).append(" status=").append(status).append(" retry=").append(suggestedRetryTime).append(" cid=").append(cid).append(" active=").append(active).append(" type=").append(type).append("' ifname='").append(ifname);
        stringbuffer.append("' addresses=[");
        String as[] = addresses;
        int i = as.length;
        for(int j = 0; j < i; j++) {
            stringbuffer.append(as[j]);
            stringbuffer.append(",");
        }

        if(addresses.length > 0)
            stringbuffer.deleteCharAt(-1 + stringbuffer.length());
        stringbuffer.append("] dnses=[");
        String as1[] = dnses;
        int k = as1.length;
        for(int l = 0; l < k; l++) {
            stringbuffer.append(as1[l]);
            stringbuffer.append(",");
        }

        if(dnses.length > 0)
            stringbuffer.deleteCharAt(-1 + stringbuffer.length());
        stringbuffer.append("] gateways=[");
        String as2[] = gateways;
        int i1 = as2.length;
        for(int j1 = 0; j1 < i1; j1++) {
            stringbuffer.append(as2[j1]);
            stringbuffer.append(",");
        }

        if(gateways.length > 0)
            stringbuffer.deleteCharAt(-1 + stringbuffer.length());
        stringbuffer.append("]}");
        return stringbuffer.toString();
    }

    private final boolean DBG = true;
    private final String LOG_TAG = "GSM";
    public int active;
    public String addresses[];
    public int cid;
    public String dnses[];
    public String gateways[];
    public String ifname;
    public int status;
    public int suggestedRetryTime;
    public String type;
    public int version;
}
