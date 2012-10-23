// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi;

import android.net.NetworkUtils;
import android.os.Parcel;
import android.os.Parcelable;
import java.net.*;
import java.util.EnumMap;

// Referenced classes of package android.net.wifi:
//            SupplicantState

public class WifiInfo
    implements Parcelable {

    WifiInfo() {
        mSSID = null;
        mBSSID = null;
        mNetworkId = -1;
        mSupplicantState = SupplicantState.UNINITIALIZED;
        mRssi = -9999;
        mLinkSpeed = -1;
        mHiddenSSID = false;
    }

    public WifiInfo(WifiInfo wifiinfo) {
        if(wifiinfo != null) {
            mSupplicantState = wifiinfo.mSupplicantState;
            mBSSID = wifiinfo.mBSSID;
            mSSID = wifiinfo.mSSID;
            mNetworkId = wifiinfo.mNetworkId;
            mHiddenSSID = wifiinfo.mHiddenSSID;
            mRssi = wifiinfo.mRssi;
            mLinkSpeed = wifiinfo.mLinkSpeed;
            mIpAddress = wifiinfo.mIpAddress;
            mMacAddress = wifiinfo.mMacAddress;
            mMeteredHint = wifiinfo.mMeteredHint;
        }
    }

    public static android.net.NetworkInfo.DetailedState getDetailedStateOf(SupplicantState supplicantstate) {
        return (android.net.NetworkInfo.DetailedState)stateMap.get(supplicantstate);
    }

    public static String removeDoubleQuotes(String s) {
        if(s != null) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        return s;
_L2:
        int i = s.length();
        if(i > 1 && s.charAt(0) == '"' && s.charAt(i - 1) == '"')
            s = s.substring(1, i - 1);
        if(true) goto _L4; else goto _L3
_L3:
    }

    static SupplicantState valueOf(String s) {
        if(!"4WAY_HANDSHAKE".equalsIgnoreCase(s)) goto _L2; else goto _L1
_L1:
        SupplicantState supplicantstate = SupplicantState.FOUR_WAY_HANDSHAKE;
_L4:
        return supplicantstate;
_L2:
        SupplicantState supplicantstate1 = SupplicantState.valueOf(s.toUpperCase());
        supplicantstate = supplicantstate1;
        continue; /* Loop/switch isn't completed */
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        supplicantstate = SupplicantState.INVALID;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int describeContents() {
        return 0;
    }

    public String getBSSID() {
        return mBSSID;
    }

    public boolean getHiddenSSID() {
        return mHiddenSSID;
    }

    public int getIpAddress() {
        int i;
        if(mIpAddress == null || (mIpAddress instanceof Inet6Address))
            i = 0;
        else
            i = NetworkUtils.inetAddressToInt(mIpAddress);
        return i;
    }

    public int getLinkSpeed() {
        return mLinkSpeed;
    }

    public String getMacAddress() {
        return mMacAddress;
    }

    public boolean getMeteredHint() {
        return mMeteredHint;
    }

    public int getNetworkId() {
        return mNetworkId;
    }

    public int getRssi() {
        return mRssi;
    }

    public String getSSID() {
        return mSSID;
    }

    public SupplicantState getSupplicantState() {
        return mSupplicantState;
    }

    void setBSSID(String s) {
        mBSSID = s;
    }

    public void setHiddenSSID(boolean flag) {
        mHiddenSSID = flag;
    }

    void setInetAddress(InetAddress inetaddress) {
        mIpAddress = inetaddress;
    }

    void setLinkSpeed(int i) {
        mLinkSpeed = i;
    }

    void setMacAddress(String s) {
        mMacAddress = s;
    }

    public void setMeteredHint(boolean flag) {
        mMeteredHint = flag;
    }

    void setNetworkId(int i) {
        mNetworkId = i;
    }

    void setRssi(int i) {
        mRssi = i;
    }

    void setSSID(String s) {
        mSSID = s;
        mHiddenSSID = false;
    }

    void setSupplicantState(SupplicantState supplicantstate) {
        mSupplicantState = supplicantstate;
    }

    void setSupplicantState(String s) {
        mSupplicantState = valueOf(s);
    }

    public String toString() {
        StringBuffer stringbuffer = new StringBuffer();
        Object obj = "<none>";
        StringBuffer stringbuffer1 = stringbuffer.append("SSID: ");
        String s;
        StringBuffer stringbuffer2;
        String s1;
        StringBuffer stringbuffer3;
        String s2;
        StringBuffer stringbuffer4;
        if(mSSID == null)
            s = ((String) (obj));
        else
            s = mSSID;
        stringbuffer2 = stringbuffer1.append(s).append(", BSSID: ");
        if(mBSSID == null)
            s1 = ((String) (obj));
        else
            s1 = mBSSID;
        stringbuffer3 = stringbuffer2.append(s1).append(", MAC: ");
        if(mMacAddress == null)
            s2 = ((String) (obj));
        else
            s2 = mMacAddress;
        stringbuffer4 = stringbuffer3.append(s2).append(", Supplicant state: ");
        if(mSupplicantState != null)
            obj = mSupplicantState;
        stringbuffer4.append(obj).append(", RSSI: ").append(mRssi).append(", Link speed: ").append(mLinkSpeed).append(", Net ID: ").append(mNetworkId).append(", Metered hint: ").append(mMeteredHint);
        return stringbuffer.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte byte0 = 1;
        parcel.writeInt(mNetworkId);
        parcel.writeInt(mRssi);
        parcel.writeInt(mLinkSpeed);
        if(mIpAddress != null) {
            parcel.writeByte(byte0);
            parcel.writeByteArray(mIpAddress.getAddress());
        } else {
            parcel.writeByte((byte)0);
        }
        parcel.writeString(getSSID());
        parcel.writeString(mBSSID);
        parcel.writeString(mMacAddress);
        if(!mMeteredHint)
            byte0 = 0;
        parcel.writeInt(byte0);
        mSupplicantState.writeToParcel(parcel, i);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public WifiInfo createFromParcel(Parcel parcel) {
            boolean flag = true;
            WifiInfo wifiinfo = new WifiInfo();
            wifiinfo.setNetworkId(parcel.readInt());
            wifiinfo.setRssi(parcel.readInt());
            wifiinfo.setLinkSpeed(parcel.readInt());
            if(parcel.readByte() == flag)
                try {
                    wifiinfo.setInetAddress(InetAddress.getByAddress(parcel.createByteArray()));
                }
                catch(UnknownHostException unknownhostexception) { }
            wifiinfo.setSSID(parcel.readString());
            wifiinfo.mBSSID = parcel.readString();
            wifiinfo.mMacAddress = parcel.readString();
            if(parcel.readInt() == 0)
                flag = false;
            wifiinfo.mMeteredHint = flag;
            wifiinfo.mSupplicantState = (SupplicantState)SupplicantState.CREATOR.createFromParcel(parcel);
            return wifiinfo;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public WifiInfo[] newArray(int i) {
            return new WifiInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final String LINK_SPEED_UNITS = "Mbps";
    private static final EnumMap stateMap;
    private String mBSSID;
    private boolean mHiddenSSID;
    private InetAddress mIpAddress;
    private int mLinkSpeed;
    private String mMacAddress;
    private boolean mMeteredHint;
    private int mNetworkId;
    private int mRssi;
    private String mSSID;
    private SupplicantState mSupplicantState;

    static  {
        stateMap = new EnumMap(android/net/wifi/SupplicantState);
        stateMap.put(SupplicantState.DISCONNECTED, android.net.NetworkInfo.DetailedState.DISCONNECTED);
        stateMap.put(SupplicantState.INTERFACE_DISABLED, android.net.NetworkInfo.DetailedState.DISCONNECTED);
        stateMap.put(SupplicantState.INACTIVE, android.net.NetworkInfo.DetailedState.IDLE);
        stateMap.put(SupplicantState.SCANNING, android.net.NetworkInfo.DetailedState.SCANNING);
        stateMap.put(SupplicantState.AUTHENTICATING, android.net.NetworkInfo.DetailedState.CONNECTING);
        stateMap.put(SupplicantState.ASSOCIATING, android.net.NetworkInfo.DetailedState.CONNECTING);
        stateMap.put(SupplicantState.ASSOCIATED, android.net.NetworkInfo.DetailedState.CONNECTING);
        stateMap.put(SupplicantState.FOUR_WAY_HANDSHAKE, android.net.NetworkInfo.DetailedState.AUTHENTICATING);
        stateMap.put(SupplicantState.GROUP_HANDSHAKE, android.net.NetworkInfo.DetailedState.AUTHENTICATING);
        stateMap.put(SupplicantState.COMPLETED, android.net.NetworkInfo.DetailedState.OBTAINING_IPADDR);
        stateMap.put(SupplicantState.DORMANT, android.net.NetworkInfo.DetailedState.DISCONNECTED);
        stateMap.put(SupplicantState.UNINITIALIZED, android.net.NetworkInfo.DetailedState.IDLE);
        stateMap.put(SupplicantState.INVALID, android.net.NetworkInfo.DetailedState.FAILED);
    }


/*
    static String access$002(WifiInfo wifiinfo, String s) {
        wifiinfo.mBSSID = s;
        return s;
    }

*/


/*
    static String access$102(WifiInfo wifiinfo, String s) {
        wifiinfo.mMacAddress = s;
        return s;
    }

*/


/*
    static boolean access$202(WifiInfo wifiinfo, boolean flag) {
        wifiinfo.mMeteredHint = flag;
        return flag;
    }

*/


/*
    static SupplicantState access$302(WifiInfo wifiinfo, SupplicantState supplicantstate) {
        wifiinfo.mSupplicantState = supplicantstate;
        return supplicantstate;
    }

*/
}
