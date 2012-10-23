// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.telephony.TelephonyManager;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.Objects;

// Referenced classes of package android.net:
//            NetworkIdentity

public class NetworkTemplate
    implements Parcelable {

    public NetworkTemplate(int i, String s, String s1) {
        mMatchRule = i;
        mSubscriberId = s;
        mNetworkId = s1;
    }

    private NetworkTemplate(Parcel parcel) {
        mMatchRule = parcel.readInt();
        mSubscriberId = parcel.readString();
        mNetworkId = parcel.readString();
    }


    public static NetworkTemplate buildTemplateEthernet() {
        return new NetworkTemplate(5, null, null);
    }

    public static NetworkTemplate buildTemplateMobile3gLower(String s) {
        return new NetworkTemplate(2, s, null);
    }

    public static NetworkTemplate buildTemplateMobile4g(String s) {
        return new NetworkTemplate(3, s, null);
    }

    public static NetworkTemplate buildTemplateMobileAll(String s) {
        return new NetworkTemplate(1, s, null);
    }

    public static NetworkTemplate buildTemplateMobileWildcard() {
        return new NetworkTemplate(6, null, null);
    }

    public static NetworkTemplate buildTemplateWifi() {
        return buildTemplateWifiWildcard();
    }

    public static NetworkTemplate buildTemplateWifi(String s) {
        return new NetworkTemplate(4, null, s);
    }

    public static NetworkTemplate buildTemplateWifiWildcard() {
        return new NetworkTemplate(7, null, null);
    }

    private static void ensureSubtypeAvailable() {
        throw new IllegalArgumentException("Unable to enforce 3G_LOWER template on combined data.");
    }

    public static void forceAllNetworkTypes() {
        sForceAllNetworkTypes = true;
    }

    private static String getMatchRuleName(int i) {
        i;
        JVM INSTR tableswitch 1 7: default 44
    //                   1 61
    //                   2 49
    //                   3 55
    //                   4 67
    //                   5 73
    //                   6 79
    //                   7 85;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        String s = "UNKNOWN";
_L10:
        return s;
_L3:
        s = "MOBILE_3G_LOWER";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "MOBILE_4G";
        continue; /* Loop/switch isn't completed */
_L2:
        s = "MOBILE_ALL";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "WIFI";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "ETHERNET";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "MOBILE_WILDCARD";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "WIFI_WILDCARD";
        if(true) goto _L10; else goto _L9
_L9:
    }

    private boolean matchesEthernet(NetworkIdentity networkidentity) {
        boolean flag;
        if(networkidentity.mType == 9)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private boolean matchesMobile(NetworkIdentity networkidentity) {
        boolean flag;
        flag = true;
        break MISSING_BLOCK_LABEL_2;
        if(networkidentity.mType != 6 && (!sForceAllNetworkTypes && !ArrayUtils.contains(DATA_USAGE_NETWORK_TYPES, networkidentity.mType) || !Objects.equal(mSubscriberId, networkidentity.mSubscriberId)))
            flag = false;
        return flag;
    }

    private boolean matchesMobile3gLower(NetworkIdentity networkidentity) {
        boolean flag;
        flag = false;
        ensureSubtypeAvailable();
        break MISSING_BLOCK_LABEL_5;
        while(true)  {
            do
                return flag;
            while(networkidentity.mType == 6 || !matchesMobile(networkidentity));
            switch(TelephonyManager.getNetworkClass(networkidentity.mSubType)) {
            case 0: // '\0'
            case 1: // '\001'
            case 2: // '\002'
                flag = true;
                break;
            }
        }
    }

    private boolean matchesMobile4g(NetworkIdentity networkidentity) {
        boolean flag;
        flag = true;
        ensureSubtypeAvailable();
        if(networkidentity.mType != 6) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(matchesMobile(networkidentity))
            switch(TelephonyManager.getNetworkClass(networkidentity.mSubType)) {
            case 3: // '\003'
                break;
            }
        flag = false;
        if(true) goto _L1; else goto _L3
_L3:
    }

    private boolean matchesMobileWildcard(NetworkIdentity networkidentity) {
        boolean flag;
        flag = true;
        break MISSING_BLOCK_LABEL_2;
        if(networkidentity.mType != 6 && !sForceAllNetworkTypes && !ArrayUtils.contains(DATA_USAGE_NETWORK_TYPES, networkidentity.mType))
            flag = false;
        return flag;
    }

    private boolean matchesWifi(NetworkIdentity networkidentity) {
        networkidentity.mType;
        JVM INSTR tableswitch 1 1: default 24
    //                   1 28;
           goto _L1 _L2
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = Objects.equal(mNetworkId, networkidentity.mNetworkId);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private boolean matchesWifiWildcard(NetworkIdentity networkidentity) {
        networkidentity.mType;
        JVM INSTR lookupswitch 2: default 32
    //                   1: 36
    //                   13: 36;
           goto _L1 _L2 _L2
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = true;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag = false;
        if(obj instanceof NetworkTemplate) {
            NetworkTemplate networktemplate = (NetworkTemplate)obj;
            if(mMatchRule == networktemplate.mMatchRule && Objects.equal(mSubscriberId, networktemplate.mSubscriberId) && Objects.equal(mNetworkId, networktemplate.mNetworkId))
                flag = true;
        }
        return flag;
    }

    public int getMatchRule() {
        return mMatchRule;
    }

    public String getNetworkId() {
        return mNetworkId;
    }

    public String getSubscriberId() {
        return mSubscriberId;
    }

    public int hashCode() {
        Object aobj[] = new Object[3];
        aobj[0] = Integer.valueOf(mMatchRule);
        aobj[1] = mSubscriberId;
        aobj[2] = mNetworkId;
        return Objects.hashCode(aobj);
    }

    public boolean matches(NetworkIdentity networkidentity) {
        mMatchRule;
        JVM INSTR tableswitch 1 7: default 48
    //                   1 58
    //                   2 66
    //                   3 75
    //                   4 84
    //                   5 93
    //                   6 102
    //                   7 111;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        throw new IllegalArgumentException("unknown network template");
_L2:
        boolean flag = matchesMobile(networkidentity);
_L10:
        return flag;
_L3:
        flag = matchesMobile3gLower(networkidentity);
        continue; /* Loop/switch isn't completed */
_L4:
        flag = matchesMobile4g(networkidentity);
        continue; /* Loop/switch isn't completed */
_L5:
        flag = matchesWifi(networkidentity);
        continue; /* Loop/switch isn't completed */
_L6:
        flag = matchesEthernet(networkidentity);
        continue; /* Loop/switch isn't completed */
_L7:
        flag = matchesMobileWildcard(networkidentity);
        continue; /* Loop/switch isn't completed */
_L8:
        flag = matchesWifiWildcard(networkidentity);
        if(true) goto _L10; else goto _L9
_L9:
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder("NetworkTemplate: ");
        stringbuilder.append("matchRule=").append(getMatchRuleName(mMatchRule));
        if(mSubscriberId != null)
            stringbuilder.append(", subscriberId=").append(NetworkIdentity.scrubSubscriberId(mSubscriberId));
        if(mNetworkId != null)
            stringbuilder.append(", networkId=").append(mNetworkId);
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mMatchRule);
        parcel.writeString(mSubscriberId);
        parcel.writeString(mNetworkId);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public NetworkTemplate createFromParcel(Parcel parcel) {
            return new NetworkTemplate(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public NetworkTemplate[] newArray(int i) {
            return new NetworkTemplate[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private static final int DATA_USAGE_NETWORK_TYPES[] = Resources.getSystem().getIntArray(0x1070016);
    public static final int MATCH_ETHERNET = 5;
    public static final int MATCH_MOBILE_3G_LOWER = 2;
    public static final int MATCH_MOBILE_4G = 3;
    public static final int MATCH_MOBILE_ALL = 1;
    public static final int MATCH_MOBILE_WILDCARD = 6;
    public static final int MATCH_WIFI = 4;
    public static final int MATCH_WIFI_WILDCARD = 7;
    private static boolean sForceAllNetworkTypes = false;
    private final int mMatchRule;
    private final String mNetworkId;
    private final String mSubscriberId;

}
