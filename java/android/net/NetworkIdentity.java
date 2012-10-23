// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.android.internal.util.Objects;

// Referenced classes of package android.net:
//            NetworkState, NetworkInfo, ConnectivityManager

public class NetworkIdentity {

    public NetworkIdentity(int i, int j, String s, String s1, boolean flag) {
        mType = i;
        mSubscriberId = s;
        mNetworkId = s1;
        mRoaming = flag;
    }

    public static NetworkIdentity buildNetworkIdentity(Context context, NetworkState networkstate) {
        int i;
        int j;
        String s;
        String s1;
        boolean flag;
        i = networkstate.networkInfo.getType();
        j = networkstate.networkInfo.getSubtype();
        s = null;
        s1 = null;
        flag = false;
        if(!ConnectivityManager.isNetworkTypeMobile(i)) goto _L2; else goto _L1
_L1:
        TelephonyManager telephonymanager = (TelephonyManager)context.getSystemService("phone");
        flag = telephonymanager.isNetworkRoaming();
        if(networkstate.subscriberId != null)
            s = networkstate.subscriberId;
        else
            s = telephonymanager.getSubscriberId();
_L4:
        return new NetworkIdentity(i, j, s, s1, flag);
_L2:
        if(i == 1)
            if(networkstate.networkId != null) {
                s1 = networkstate.networkId;
            } else {
                WifiInfo wifiinfo = ((WifiManager)context.getSystemService("wifi")).getConnectionInfo();
                if(wifiinfo != null)
                    s1 = wifiinfo.getSSID();
                else
                    s1 = null;
            }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static String scrubSubscriberId(String s) {
        if(!"eng".equals(Build.TYPE))
            if(s != null)
                s = (new StringBuilder()).append(s.substring(0, Math.min(6, s.length()))).append("...").toString();
            else
                s = "null";
        return s;
    }

    public boolean equals(Object obj) {
        boolean flag = false;
        if(obj instanceof NetworkIdentity) {
            NetworkIdentity networkidentity = (NetworkIdentity)obj;
            if(mType == networkidentity.mType && mSubType == networkidentity.mSubType && mRoaming == networkidentity.mRoaming && Objects.equal(mSubscriberId, networkidentity.mSubscriberId) && Objects.equal(mNetworkId, networkidentity.mNetworkId))
                flag = true;
        }
        return flag;
    }

    public String getNetworkId() {
        return mNetworkId;
    }

    public boolean getRoaming() {
        return mRoaming;
    }

    public int getSubType() {
        return mSubType;
    }

    public String getSubscriberId() {
        return mSubscriberId;
    }

    public int getType() {
        return mType;
    }

    public int hashCode() {
        Object aobj[] = new Object[5];
        aobj[0] = Integer.valueOf(mType);
        aobj[1] = Integer.valueOf(mSubType);
        aobj[2] = mSubscriberId;
        aobj[3] = mNetworkId;
        aobj[4] = Boolean.valueOf(mRoaming);
        return Objects.hashCode(aobj);
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder("[");
        stringbuilder.append("type=").append(ConnectivityManager.getNetworkTypeName(mType));
        stringbuilder.append(", subType=");
        stringbuilder.append("COMBINED");
        if(mSubscriberId != null)
            stringbuilder.append(", subscriberId=").append(scrubSubscriberId(mSubscriberId));
        if(mNetworkId != null)
            stringbuilder.append(", networkId=").append(mNetworkId);
        if(mRoaming)
            stringbuilder.append(", ROAMING");
        return stringbuilder.append("]").toString();
    }

    public static final boolean COMBINE_SUBTYPE_ENABLED = true;
    public static final int SUBTYPE_COMBINED = -1;
    final String mNetworkId;
    final boolean mRoaming;
    final int mSubType = -1;
    final String mSubscriberId;
    final int mType;
}
