// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi.p2p;

import android.net.wifi.WpsInfo;
import android.os.Parcel;
import android.os.Parcelable;

public class WifiP2pConfig
    implements Parcelable {
    public static final class Persist extends Enum {

        public static Persist valueOf(String s) {
            return (Persist)Enum.valueOf(android/net/wifi/p2p/WifiP2pConfig$Persist, s);
        }

        public static Persist[] values() {
            return (Persist[])$VALUES.clone();
        }

        private static final Persist $VALUES[];
        public static final Persist NO;
        public static final Persist SYSTEM_DEFAULT;
        public static final Persist YES;

        static  {
            SYSTEM_DEFAULT = new Persist("SYSTEM_DEFAULT", 0);
            YES = new Persist("YES", 1);
            NO = new Persist("NO", 2);
            Persist apersist[] = new Persist[3];
            apersist[0] = SYSTEM_DEFAULT;
            apersist[1] = YES;
            apersist[2] = NO;
            $VALUES = apersist;
        }

        private Persist(String s, int i) {
            super(s, i);
        }
    }


    public WifiP2pConfig() {
        groupOwnerIntent = -1;
        persist = Persist.SYSTEM_DEFAULT;
        wps = new WpsInfo();
        wps.setup = 0;
    }

    public WifiP2pConfig(WifiP2pConfig wifip2pconfig) {
        groupOwnerIntent = -1;
        persist = Persist.SYSTEM_DEFAULT;
        if(wifip2pconfig != null) {
            deviceAddress = wifip2pconfig.deviceAddress;
            wps = new WpsInfo(wifip2pconfig.wps);
            groupOwnerIntent = wifip2pconfig.groupOwnerIntent;
            persist = wifip2pconfig.persist;
        }
    }

    public WifiP2pConfig(String s) throws IllegalArgumentException {
        String as[];
        groupOwnerIntent = -1;
        persist = Persist.SYSTEM_DEFAULT;
        as = s.split(" ");
        if(as.length < 2 || !as[0].equals("P2P-GO-NEG-REQUEST"))
            throw new IllegalArgumentException("Malformed supplicant event");
        deviceAddress = as[1];
        wps = new WpsInfo();
        if(as.length <= 2) goto _L2; else goto _L1
_L1:
        String as1[] = as[2].split("=");
        int j = Integer.parseInt(as1[1]);
        int i = j;
_L7:
        i;
        JVM INSTR tableswitch 1 5: default 132
    //                   1 149
    //                   2 132
    //                   3 132
    //                   4 160
    //                   5 171;
           goto _L3 _L4 _L3 _L3 _L5 _L6
_L6:
        break MISSING_BLOCK_LABEL_171;
_L3:
        wps.setup = 0;
_L2:
        return;
        NumberFormatException numberformatexception;
        numberformatexception;
        i = 0;
          goto _L7
_L4:
        wps.setup = 1;
          goto _L2
_L5:
        wps.setup = 0;
          goto _L2
        wps.setup = 2;
          goto _L2
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("\n address: ").append(deviceAddress);
        stringbuffer.append("\n wps: ").append(wps);
        stringbuffer.append("\n groupOwnerIntent: ").append(groupOwnerIntent);
        stringbuffer.append("\n persist: ").append(persist.toString());
        return stringbuffer.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(deviceAddress);
        parcel.writeParcelable(wps, i);
        parcel.writeInt(groupOwnerIntent);
        parcel.writeString(persist.name());
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public WifiP2pConfig createFromParcel(Parcel parcel) {
            WifiP2pConfig wifip2pconfig = new WifiP2pConfig();
            wifip2pconfig.deviceAddress = parcel.readString();
            wifip2pconfig.wps = (WpsInfo)parcel.readParcelable(null);
            wifip2pconfig.groupOwnerIntent = parcel.readInt();
            wifip2pconfig.persist = Persist.valueOf(parcel.readString());
            return wifip2pconfig;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public WifiP2pConfig[] newArray(int i) {
            return new WifiP2pConfig[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public String deviceAddress;
    public int groupOwnerIntent;
    public Persist persist;
    public WpsInfo wps;

}
