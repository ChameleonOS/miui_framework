// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi.p2p;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WifiP2pDevice
    implements Parcelable {

    public WifiP2pDevice() {
        deviceName = "";
        deviceAddress = "";
        status = 4;
    }

    public WifiP2pDevice(WifiP2pDevice wifip2pdevice) {
        deviceName = "";
        deviceAddress = "";
        status = 4;
        if(wifip2pdevice != null) {
            deviceName = wifip2pdevice.deviceName;
            deviceAddress = wifip2pdevice.deviceAddress;
            primaryDeviceType = wifip2pdevice.primaryDeviceType;
            secondaryDeviceType = wifip2pdevice.secondaryDeviceType;
            wpsConfigMethodsSupported = wifip2pdevice.wpsConfigMethodsSupported;
            deviceCapability = wifip2pdevice.deviceCapability;
            groupCapability = wifip2pdevice.groupCapability;
            status = wifip2pdevice.status;
        }
    }

    public WifiP2pDevice(String s) throws IllegalArgumentException {
        String as[];
        deviceName = "";
        deviceAddress = "";
        status = 4;
        as = s.split("[ \n]");
        if(as.length < 1)
            throw new IllegalArgumentException("Malformed supplicant event");
        as.length;
        JVM INSTR tableswitch 1 3: default 72
    //                   1 99
    //                   2 105
    //                   3 145;
           goto _L1 _L2 _L3 _L4
_L1:
        Matcher matcher2;
        matcher2 = detailedDevicePattern.matcher(s);
        if(!matcher2.find())
            throw new IllegalArgumentException("Malformed supplicant event");
        break; /* Loop/switch isn't completed */
_L2:
        deviceAddress = s;
_L6:
        return;
_L3:
        Matcher matcher1 = twoTokenPattern.matcher(s);
        if(!matcher1.find())
            throw new IllegalArgumentException("Malformed supplicant event");
        deviceAddress = matcher1.group(2);
        continue; /* Loop/switch isn't completed */
_L4:
        Matcher matcher = threeTokenPattern.matcher(s);
        if(!matcher.find())
            throw new IllegalArgumentException("Malformed supplicant event");
        deviceAddress = matcher.group(1);
        continue; /* Loop/switch isn't completed */
        deviceAddress = matcher2.group(3);
        primaryDeviceType = matcher2.group(4);
        deviceName = matcher2.group(5);
        wpsConfigMethodsSupported = parseHex(matcher2.group(6));
        deviceCapability = parseHex(matcher2.group(7));
        groupCapability = parseHex(matcher2.group(8));
        if(as[0].startsWith("P2P-DEVICE-FOUND"))
            status = 3;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private int parseHex(String s) {
        int i;
        i = 0;
        if(s.startsWith("0x") || s.startsWith("0X"))
            s = s.substring(2);
        int j = Integer.parseInt(s, 16);
        i = j;
_L2:
        return i;
        NumberFormatException numberformatexception;
        numberformatexception;
        Log.e("WifiP2pDevice", (new StringBuilder()).append("Failed to parse hex string ").append(s).toString());
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag = true;
        if(this != obj) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(!(obj instanceof WifiP2pDevice)) {
            flag = false;
        } else {
            WifiP2pDevice wifip2pdevice = (WifiP2pDevice)obj;
            if(wifip2pdevice == null || wifip2pdevice.deviceAddress == null) {
                if(deviceAddress != null)
                    flag = false;
            } else {
                flag = wifip2pdevice.deviceAddress.equals(deviceAddress);
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean isGroupOwner() {
        boolean flag;
        if((1 & groupCapability) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isServiceDiscoveryCapable() {
        boolean flag;
        if((1 & deviceCapability) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public String toString() {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("Device: ").append(deviceName);
        stringbuffer.append("\n deviceAddress: ").append(deviceAddress);
        stringbuffer.append("\n primary type: ").append(primaryDeviceType);
        stringbuffer.append("\n secondary type: ").append(secondaryDeviceType);
        stringbuffer.append("\n wps: ").append(wpsConfigMethodsSupported);
        stringbuffer.append("\n grpcapab: ").append(groupCapability);
        stringbuffer.append("\n devcapab: ").append(deviceCapability);
        stringbuffer.append("\n status: ").append(status);
        return stringbuffer.toString();
    }

    public boolean wpsDisplaySupported() {
        boolean flag;
        if((8 & wpsConfigMethodsSupported) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean wpsKeypadSupported() {
        boolean flag;
        if((0x100 & wpsConfigMethodsSupported) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean wpsPbcSupported() {
        boolean flag;
        if((0x80 & wpsConfigMethodsSupported) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(deviceName);
        parcel.writeString(deviceAddress);
        parcel.writeString(primaryDeviceType);
        parcel.writeString(secondaryDeviceType);
        parcel.writeInt(wpsConfigMethodsSupported);
        parcel.writeInt(deviceCapability);
        parcel.writeInt(groupCapability);
        parcel.writeInt(status);
    }

    public static final int AVAILABLE = 3;
    public static final int CONNECTED = 0;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public WifiP2pDevice createFromParcel(Parcel parcel) {
            WifiP2pDevice wifip2pdevice = new WifiP2pDevice();
            wifip2pdevice.deviceName = parcel.readString();
            wifip2pdevice.deviceAddress = parcel.readString();
            wifip2pdevice.primaryDeviceType = parcel.readString();
            wifip2pdevice.secondaryDeviceType = parcel.readString();
            wifip2pdevice.wpsConfigMethodsSupported = parcel.readInt();
            wifip2pdevice.deviceCapability = parcel.readInt();
            wifip2pdevice.groupCapability = parcel.readInt();
            wifip2pdevice.status = parcel.readInt();
            return wifip2pdevice;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public WifiP2pDevice[] newArray(int i) {
            return new WifiP2pDevice[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private static final int DEVICE_CAPAB_CLIENT_DISCOVERABILITY = 2;
    private static final int DEVICE_CAPAB_CONCURRENT_OPER = 4;
    private static final int DEVICE_CAPAB_DEVICE_LIMIT = 16;
    private static final int DEVICE_CAPAB_INFRA_MANAGED = 8;
    private static final int DEVICE_CAPAB_INVITATION_PROCEDURE = 32;
    private static final int DEVICE_CAPAB_SERVICE_DISCOVERY = 1;
    public static final int FAILED = 2;
    private static final int GROUP_CAPAB_CROSS_CONN = 16;
    private static final int GROUP_CAPAB_GROUP_FORMATION = 64;
    private static final int GROUP_CAPAB_GROUP_LIMIT = 4;
    private static final int GROUP_CAPAB_GROUP_OWNER = 1;
    private static final int GROUP_CAPAB_INTRA_BSS_DIST = 8;
    private static final int GROUP_CAPAB_PERSISTENT_GROUP = 2;
    private static final int GROUP_CAPAB_PERSISTENT_RECONN = 32;
    public static final int INVITED = 1;
    private static final String TAG = "WifiP2pDevice";
    public static final int UNAVAILABLE = 4;
    private static final int WPS_CONFIG_DISPLAY = 8;
    private static final int WPS_CONFIG_KEYPAD = 256;
    private static final int WPS_CONFIG_PUSHBUTTON = 128;
    private static final Pattern detailedDevicePattern = Pattern.compile("((?:[0-9a-f]{2}:){5}[0-9a-f]{2}) (\\d+ )?p2p_dev_addr=((?:[0-9a-f]{2}:){5}[0-9a-f]{2}) pri_dev_type=(\\d+-[0-9a-fA-F]+-\\d+) name='(.*)' config_methods=(0x[0-9a-fA-F]+) dev_capab=(0x[0-9a-fA-F]+) group_capab=(0x[0-9a-fA-F]+)");
    private static final Pattern threeTokenPattern = Pattern.compile("(?:[0-9a-f]{2}:){5}[0-9a-f]{2} p2p_dev_addr=((?:[0-9a-f]{2}:){5}[0-9a-f]{2})");
    private static final Pattern twoTokenPattern = Pattern.compile("(p2p_dev_addr=)?((?:[0-9a-f]{2}:){5}[0-9a-f]{2})");
    public String deviceAddress;
    public int deviceCapability;
    public String deviceName;
    public int groupCapability;
    public String primaryDeviceType;
    public String secondaryDeviceType;
    public int status;
    public int wpsConfigMethodsSupported;

}
