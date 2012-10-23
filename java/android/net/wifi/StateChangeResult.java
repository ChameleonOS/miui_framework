// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi;


// Referenced classes of package android.net.wifi:
//            SupplicantState

public class StateChangeResult {

    StateChangeResult(int i, String s, String s1, SupplicantState supplicantstate) {
        state = supplicantstate;
        SSID = s;
        BSSID = s1;
        networkId = i;
    }

    String BSSID;
    String SSID;
    int networkId;
    SupplicantState state;
}
