// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi.p2p;


// Referenced classes of package android.net.wifi.p2p:
//            WifiP2pDevice

public class WifiP2pProvDiscEvent {

    public WifiP2pProvDiscEvent() {
        device = new WifiP2pDevice();
    }

    public WifiP2pProvDiscEvent(String s) throws IllegalArgumentException {
        String as[] = s.split(" ");
        if(as.length < 2)
            throw new IllegalArgumentException((new StringBuilder()).append("Malformed event ").append(s).toString());
        if(as[0].endsWith("PBC-REQ"))
            event = 1;
        else
        if(as[0].endsWith("PBC-RESP"))
            event = 2;
        else
        if(as[0].endsWith("ENTER-PIN"))
            event = 3;
        else
        if(as[0].endsWith("SHOW-PIN"))
            event = 4;
        else
            throw new IllegalArgumentException((new StringBuilder()).append("Malformed event ").append(s).toString());
        device = new WifiP2pDevice();
        device.deviceAddress = as[1];
        if(event == 4)
            pin = as[2];
    }

    public String toString() {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append(device);
        stringbuffer.append("\n event: ").append(event);
        stringbuffer.append("\n pin: ").append(pin);
        return stringbuffer.toString();
    }

    public static final int ENTER_PIN = 3;
    public static final int PBC_REQ = 1;
    public static final int PBC_RSP = 2;
    public static final int SHOW_PIN = 4;
    private static final String TAG = "WifiP2pProvDiscEvent";
    public WifiP2pDevice device;
    public int event;
    public String pin;
}
