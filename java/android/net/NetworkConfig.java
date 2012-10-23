// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;


public class NetworkConfig {

    public NetworkConfig(String s) {
        String as[] = s.split(",");
        name = as[0].trim().toLowerCase();
        type = Integer.parseInt(as[1]);
        radio = Integer.parseInt(as[2]);
        priority = Integer.parseInt(as[3]);
        restoreTime = Integer.parseInt(as[4]);
        dependencyMet = Boolean.parseBoolean(as[5]);
    }

    public boolean isDefault() {
        boolean flag;
        if(type == radio)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean dependencyMet;
    public String name;
    public int priority;
    public int radio;
    public int restoreTime;
    public int type;
}
