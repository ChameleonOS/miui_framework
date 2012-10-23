// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;


public class ApnSetting {

    public ApnSetting(int i, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6, String s7, String s8, String s9, int j, String as[], String s10, 
            String s11, boolean flag, int k) {
        id = i;
        numeric = s;
        carrier = s1;
        apn = s2;
        proxy = s3;
        port = s4;
        mmsc = s5;
        mmsProxy = s6;
        mmsPort = s7;
        user = s8;
        password = s9;
        authType = j;
        types = as;
        protocol = s10;
        roamingProtocol = s11;
        carrierEnabled = flag;
        bearer = k;
    }

    public static ApnSetting fromString(String s) {
        byte byte0;
        String as[];
        ApnSetting apnsetting;
        if(s == null) {
            apnsetting = null;
        } else {
label0:
            {
                if(s.matches("^\\[ApnSettingV2\\]\\s*.*")) {
                    byte0 = 2;
                    s = s.replaceFirst("^\\[ApnSettingV2\\]\\s*", "");
                } else {
                    byte0 = 1;
                }
                as = s.split("\\s*,\\s*");
                if(as.length >= 14)
                    break label0;
                apnsetting = null;
            }
        }
_L3:
        return apnsetting;
        int k = Integer.parseInt(as[12]);
        int i = k;
_L4:
        if(byte0 != 1) goto _L2; else goto _L1
_L1:
        String as1[];
        String s1;
        String s2;
        boolean flag;
        int j;
        as1 = new String[-13 + as.length];
        System.arraycopy(as, 13, as1, 0, -13 + as.length);
        s1 = "IP";
        s2 = "IP";
        flag = true;
        j = 0;
_L5:
        apnsetting = new ApnSetting(-1, (new StringBuilder()).append(as[10]).append(as[11]).toString(), as[0], as[1], as[2], as[3], as[7], as[8], as[9], as[4], as[5], i, as1, s1, s2, flag, j);
          goto _L3
        Exception exception;
        exception;
        i = 0;
          goto _L4
_L2:
label1:
        {
            if(as.length >= 18)
                break label1;
            apnsetting = null;
        }
          goto _L3
        as1 = as[13].split("\\s*\\|\\s*");
        s1 = as[14];
        s2 = as[15];
        boolean flag1 = Boolean.parseBoolean(as[16]);
        flag = flag1;
_L6:
        j = Integer.parseInt(as[17]);
          goto _L5
        Exception exception1;
        exception1;
        flag = true;
          goto _L6
    }

    public boolean canHandleType(String s) {
        String as[];
        int i;
        int j;
        as = types;
        i = as.length;
        j = 0;
_L3:
        String s1;
        if(j >= i)
            break MISSING_BLOCK_LABEL_73;
        s1 = as[j];
        if(!s1.equalsIgnoreCase(s) && !s1.equalsIgnoreCase("*") && (!s1.equalsIgnoreCase("default") || !s.equalsIgnoreCase("hipri"))) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        j++;
          goto _L3
        flag = false;
          goto _L4
    }

    public boolean equals(Object obj) {
        boolean flag;
        if(!(obj instanceof ApnSetting))
            flag = false;
        else
            flag = toString().equals(obj.toString());
        return flag;
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("[ApnSettingV2] ").append(carrier).append(", ").append(id).append(", ").append(numeric).append(", ").append(apn).append(", ").append(proxy).append(", ").append(mmsc).append(", ").append(mmsProxy).append(", ").append(mmsPort).append(", ").append(port).append(", ").append(authType).append(", ");
        for(int i = 0; i < types.length; i++) {
            stringbuilder.append(types[i]);
            if(i < -1 + types.length)
                stringbuilder.append(" | ");
        }

        stringbuilder.append(", ").append(protocol);
        stringbuilder.append(", ").append(roamingProtocol);
        stringbuilder.append(", ").append(carrierEnabled);
        stringbuilder.append(", ").append(bearer);
        return stringbuilder.toString();
    }

    static final String V2_FORMAT_REGEX = "^\\[ApnSettingV2\\]\\s*";
    public final String apn;
    public final int authType;
    public final int bearer;
    public final String carrier;
    public final boolean carrierEnabled;
    public final int id;
    public final String mmsPort;
    public final String mmsProxy;
    public final String mmsc;
    public final String numeric;
    public final String password;
    public final String port;
    public final String protocol;
    public final String proxy;
    public final String roamingProtocol;
    public final String types[];
    public final String user;
}
