// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi;

import android.net.LinkProperties;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.BitSet;

public class WifiConfiguration
    implements Parcelable {
    public static final class ProxySettings extends Enum {

        public static ProxySettings valueOf(String s) {
            return (ProxySettings)Enum.valueOf(android/net/wifi/WifiConfiguration$ProxySettings, s);
        }

        public static ProxySettings[] values() {
            return (ProxySettings[])$VALUES.clone();
        }

        private static final ProxySettings $VALUES[];
        public static final ProxySettings NONE;
        public static final ProxySettings STATIC;
        public static final ProxySettings UNASSIGNED;

        static  {
            NONE = new ProxySettings("NONE", 0);
            STATIC = new ProxySettings("STATIC", 1);
            UNASSIGNED = new ProxySettings("UNASSIGNED", 2);
            ProxySettings aproxysettings[] = new ProxySettings[3];
            aproxysettings[0] = NONE;
            aproxysettings[1] = STATIC;
            aproxysettings[2] = UNASSIGNED;
            $VALUES = aproxysettings;
        }

        private ProxySettings(String s, int i) {
            super(s, i);
        }
    }

    public static final class IpAssignment extends Enum {

        public static IpAssignment valueOf(String s) {
            return (IpAssignment)Enum.valueOf(android/net/wifi/WifiConfiguration$IpAssignment, s);
        }

        public static IpAssignment[] values() {
            return (IpAssignment[])$VALUES.clone();
        }

        private static final IpAssignment $VALUES[];
        public static final IpAssignment DHCP;
        public static final IpAssignment STATIC;
        public static final IpAssignment UNASSIGNED;

        static  {
            STATIC = new IpAssignment("STATIC", 0);
            DHCP = new IpAssignment("DHCP", 1);
            UNASSIGNED = new IpAssignment("UNASSIGNED", 2);
            IpAssignment aipassignment[] = new IpAssignment[3];
            aipassignment[0] = STATIC;
            aipassignment[1] = DHCP;
            aipassignment[2] = UNASSIGNED;
            $VALUES = aipassignment;
        }

        private IpAssignment(String s, int i) {
            super(s, i);
        }
    }

    public static class Status {

        public static final int CURRENT = 0;
        public static final int DISABLED = 1;
        public static final int ENABLED = 2;
        public static final String strings[];

        static  {
            String as[] = new String[3];
            as[0] = "current";
            as[1] = "disabled";
            as[2] = "enabled";
            strings = as;
        }

        private Status() {
        }
    }

    public static class GroupCipher {

        public static final int CCMP = 3;
        public static final int TKIP = 2;
        public static final int WEP104 = 1;
        public static final int WEP40 = 0;
        public static final String strings[];
        public static final String varName = "group";

        static  {
            String as[] = new String[4];
            as[0] = "WEP40";
            as[1] = "WEP104";
            as[2] = "TKIP";
            as[3] = "CCMP";
            strings = as;
        }

        private GroupCipher() {
        }
    }

    public static class PairwiseCipher {

        public static final int CCMP = 2;
        public static final int NONE = 0;
        public static final int TKIP = 1;
        public static final String strings[];
        public static final String varName = "pairwise";

        static  {
            String as[] = new String[3];
            as[0] = "NONE";
            as[1] = "TKIP";
            as[2] = "CCMP";
            strings = as;
        }

        private PairwiseCipher() {
        }
    }

    public static class AuthAlgorithm {

        public static final int LEAP = 2;
        public static final int OPEN = 0;
        public static final int SHARED = 1;
        public static final String strings[];
        public static final String varName = "auth_alg";

        static  {
            String as[] = new String[3];
            as[0] = "OPEN";
            as[1] = "SHARED";
            as[2] = "LEAP";
            strings = as;
        }

        private AuthAlgorithm() {
        }
    }

    public static class Protocol {

        public static final int RSN = 1;
        public static final int WPA = 0;
        public static final String strings[];
        public static final String varName = "proto";

        static  {
            String as[] = new String[2];
            as[0] = "WPA";
            as[1] = "RSN";
            strings = as;
        }

        private Protocol() {
        }
    }

    public static class KeyMgmt {

        public static final int IEEE8021X = 3;
        public static final int NONE = 0;
        public static final int WPA2_PSK = 4;
        public static final int WPA_EAP = 2;
        public static final int WPA_PSK = 1;
        public static final String strings[];
        public static final String varName = "key_mgmt";

        static  {
            String as[] = new String[5];
            as[0] = "NONE";
            as[1] = "WPA_PSK";
            as[2] = "WPA_EAP";
            as[3] = "IEEE8021X";
            as[4] = "WPA2_PSK";
            strings = as;
        }

        private KeyMgmt() {
        }
    }

    public class EnterpriseField {

        public void setValue(String s) {
            value = s;
        }

        public String value() {
            return value;
        }

        public String varName() {
            return varName;
        }

        final WifiConfiguration this$0;
        private String value;
        private String varName;

        private EnterpriseField(String s) {
            this$0 = WifiConfiguration.this;
            super();
            varName = s;
            value = null;
        }

    }


    public WifiConfiguration() {
        private_key = new EnterpriseField("private_key");
        eap = new EnterpriseField("eap");
        phase2 = new EnterpriseField("phase2");
        identity = new EnterpriseField("identity");
        anonymous_identity = new EnterpriseField("anonymous_identity");
        password = new EnterpriseField("password");
        client_cert = new EnterpriseField("client_cert");
        engine = new EnterpriseField("engine");
        engine_id = new EnterpriseField("engine_id");
        key_id = new EnterpriseField("key_id");
        ca_cert = new EnterpriseField("ca_cert");
        EnterpriseField aenterprisefield[] = new EnterpriseField[10];
        aenterprisefield[0] = eap;
        aenterprisefield[1] = phase2;
        aenterprisefield[2] = identity;
        aenterprisefield[3] = anonymous_identity;
        aenterprisefield[4] = password;
        aenterprisefield[5] = client_cert;
        aenterprisefield[6] = engine;
        aenterprisefield[7] = engine_id;
        aenterprisefield[8] = key_id;
        aenterprisefield[9] = ca_cert;
        enterpriseFields = aenterprisefield;
        networkId = -1;
        SSID = null;
        BSSID = null;
        priority = 0;
        hiddenSSID = false;
        disableReason = 0;
        allowedKeyManagement = new BitSet();
        allowedProtocols = new BitSet();
        allowedAuthAlgorithms = new BitSet();
        allowedPairwiseCiphers = new BitSet();
        allowedGroupCiphers = new BitSet();
        wepKeys = new String[4];
        for(int i = 0; i < wepKeys.length; i++)
            wepKeys[i] = null;

        EnterpriseField aenterprisefield1[] = enterpriseFields;
        int j = aenterprisefield1.length;
        for(int k = 0; k < j; k++)
            aenterprisefield1[k].setValue(null);

        ipAssignment = IpAssignment.UNASSIGNED;
        proxySettings = ProxySettings.UNASSIGNED;
        linkProperties = new LinkProperties();
    }

    public WifiConfiguration(WifiConfiguration wificonfiguration) {
        private_key = new EnterpriseField("private_key");
        eap = new EnterpriseField("eap");
        phase2 = new EnterpriseField("phase2");
        identity = new EnterpriseField("identity");
        anonymous_identity = new EnterpriseField("anonymous_identity");
        password = new EnterpriseField("password");
        client_cert = new EnterpriseField("client_cert");
        engine = new EnterpriseField("engine");
        engine_id = new EnterpriseField("engine_id");
        key_id = new EnterpriseField("key_id");
        ca_cert = new EnterpriseField("ca_cert");
        EnterpriseField aenterprisefield[] = new EnterpriseField[10];
        aenterprisefield[0] = eap;
        aenterprisefield[1] = phase2;
        aenterprisefield[2] = identity;
        aenterprisefield[3] = anonymous_identity;
        aenterprisefield[4] = password;
        aenterprisefield[5] = client_cert;
        aenterprisefield[6] = engine;
        aenterprisefield[7] = engine_id;
        aenterprisefield[8] = key_id;
        aenterprisefield[9] = ca_cert;
        enterpriseFields = aenterprisefield;
        if(wificonfiguration != null) {
            networkId = wificonfiguration.networkId;
            status = wificonfiguration.status;
            disableReason = wificonfiguration.disableReason;
            SSID = wificonfiguration.SSID;
            BSSID = wificonfiguration.BSSID;
            preSharedKey = wificonfiguration.preSharedKey;
            wepKeys = new String[4];
            for(int i = 0; i < wepKeys.length; i++)
                wepKeys[i] = wificonfiguration.wepKeys[i];

            wepTxKeyIndex = wificonfiguration.wepTxKeyIndex;
            priority = wificonfiguration.priority;
            hiddenSSID = wificonfiguration.hiddenSSID;
            allowedKeyManagement = (BitSet)wificonfiguration.allowedKeyManagement.clone();
            allowedProtocols = (BitSet)wificonfiguration.allowedProtocols.clone();
            allowedAuthAlgorithms = (BitSet)wificonfiguration.allowedAuthAlgorithms.clone();
            allowedPairwiseCiphers = (BitSet)wificonfiguration.allowedPairwiseCiphers.clone();
            allowedGroupCiphers = (BitSet)wificonfiguration.allowedGroupCiphers.clone();
            for(int j = 0; j < wificonfiguration.enterpriseFields.length; j++)
                enterpriseFields[j].setValue(wificonfiguration.enterpriseFields[j].value());

            ipAssignment = wificonfiguration.ipAssignment;
            proxySettings = wificonfiguration.proxySettings;
            linkProperties = new LinkProperties(wificonfiguration.linkProperties);
        }
    }

    private static BitSet readBitSet(Parcel parcel) {
        int i = parcel.readInt();
        BitSet bitset = new BitSet();
        for(int j = 0; j < i; j++)
            bitset.set(parcel.readInt());

        return bitset;
    }

    private static void writeBitSet(Parcel parcel, BitSet bitset) {
        int i = -1;
        parcel.writeInt(bitset.cardinality());
        do {
            i = bitset.nextSetBit(i + 1);
            if(i != -1)
                parcel.writeInt(i);
            else
                return;
        } while(true);
    }

    public int describeContents() {
        return 0;
    }

    public int getAuthType() {
        int i = 1;
        if(!allowedKeyManagement.get(i))
            if(allowedKeyManagement.get(4))
                i = 4;
            else
            if(allowedKeyManagement.get(2))
                i = 2;
            else
            if(allowedKeyManagement.get(3))
                i = 3;
            else
                i = 0;
        return i;
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        int i;
        if(status == 0)
            stringbuilder.append("* ");
        else
        if(status == 1)
            stringbuilder.append("- DSBLE: ").append(disableReason).append(" ");
        stringbuilder.append("ID: ").append(networkId).append(" SSID: ").append(SSID).append(" BSSID: ").append(BSSID).append(" PRIO: ").append(priority).append('\n');
        stringbuilder.append(" KeyMgmt:");
        i = 0;
        while(i < allowedKeyManagement.size())  {
            if(allowedKeyManagement.get(i)) {
                stringbuilder.append(" ");
                if(i < KeyMgmt.strings.length)
                    stringbuilder.append(KeyMgmt.strings[i]);
                else
                    stringbuilder.append("??");
            }
            i++;
        }
        stringbuilder.append(" Protocols:");
        int j = 0;
        while(j < allowedProtocols.size())  {
            if(allowedProtocols.get(j)) {
                stringbuilder.append(" ");
                if(j < Protocol.strings.length)
                    stringbuilder.append(Protocol.strings[j]);
                else
                    stringbuilder.append("??");
            }
            j++;
        }
        stringbuilder.append('\n');
        stringbuilder.append(" AuthAlgorithms:");
        int k = 0;
        while(k < allowedAuthAlgorithms.size())  {
            if(allowedAuthAlgorithms.get(k)) {
                stringbuilder.append(" ");
                if(k < AuthAlgorithm.strings.length)
                    stringbuilder.append(AuthAlgorithm.strings[k]);
                else
                    stringbuilder.append("??");
            }
            k++;
        }
        stringbuilder.append('\n');
        stringbuilder.append(" PairwiseCiphers:");
        int l = 0;
        while(l < allowedPairwiseCiphers.size())  {
            if(allowedPairwiseCiphers.get(l)) {
                stringbuilder.append(" ");
                if(l < PairwiseCipher.strings.length)
                    stringbuilder.append(PairwiseCipher.strings[l]);
                else
                    stringbuilder.append("??");
            }
            l++;
        }
        stringbuilder.append('\n');
        stringbuilder.append(" GroupCiphers:");
        int i1 = 0;
        while(i1 < allowedGroupCiphers.size())  {
            if(allowedGroupCiphers.get(i1)) {
                stringbuilder.append(" ");
                if(i1 < GroupCipher.strings.length)
                    stringbuilder.append(GroupCipher.strings[i1]);
                else
                    stringbuilder.append("??");
            }
            i1++;
        }
        stringbuilder.append('\n').append(" PSK: ");
        if(preSharedKey != null)
            stringbuilder.append('*');
        EnterpriseField aenterprisefield[] = enterpriseFields;
        int j1 = aenterprisefield.length;
        for(int k1 = 0; k1 < j1; k1++) {
            EnterpriseField enterprisefield = aenterprisefield[k1];
            stringbuilder.append('\n').append((new StringBuilder()).append(" ").append(enterprisefield.varName()).append(": ").toString());
            String s = enterprisefield.value();
            if(s != null)
                stringbuilder.append(s);
        }

        stringbuilder.append('\n');
        stringbuilder.append((new StringBuilder()).append("IP assignment: ").append(ipAssignment.toString()).toString());
        stringbuilder.append("\n");
        stringbuilder.append((new StringBuilder()).append("Proxy settings: ").append(proxySettings.toString()).toString());
        stringbuilder.append("\n");
        stringbuilder.append(linkProperties.toString());
        stringbuilder.append("\n");
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(networkId);
        parcel.writeInt(status);
        parcel.writeInt(disableReason);
        parcel.writeString(SSID);
        parcel.writeString(BSSID);
        parcel.writeString(preSharedKey);
        String as[] = wepKeys;
        int j = as.length;
        for(int k = 0; k < j; k++)
            parcel.writeString(as[k]);

        parcel.writeInt(wepTxKeyIndex);
        parcel.writeInt(priority);
        int l;
        EnterpriseField aenterprisefield[];
        int i1;
        if(hiddenSSID)
            l = 1;
        else
            l = 0;
        parcel.writeInt(l);
        writeBitSet(parcel, allowedKeyManagement);
        writeBitSet(parcel, allowedProtocols);
        writeBitSet(parcel, allowedAuthAlgorithms);
        writeBitSet(parcel, allowedPairwiseCiphers);
        writeBitSet(parcel, allowedGroupCiphers);
        aenterprisefield = enterpriseFields;
        i1 = aenterprisefield.length;
        for(int j1 = 0; j1 < i1; j1++)
            parcel.writeString(aenterprisefield[j1].value());

        parcel.writeString(ipAssignment.name());
        parcel.writeString(proxySettings.name());
        parcel.writeParcelable(linkProperties, i);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public WifiConfiguration createFromParcel(Parcel parcel) {
            WifiConfiguration wificonfiguration = new WifiConfiguration();
            wificonfiguration.networkId = parcel.readInt();
            wificonfiguration.status = parcel.readInt();
            wificonfiguration.disableReason = parcel.readInt();
            wificonfiguration.SSID = parcel.readString();
            wificonfiguration.BSSID = parcel.readString();
            wificonfiguration.preSharedKey = parcel.readString();
            for(int i = 0; i < wificonfiguration.wepKeys.length; i++)
                wificonfiguration.wepKeys[i] = parcel.readString();

            wificonfiguration.wepTxKeyIndex = parcel.readInt();
            wificonfiguration.priority = parcel.readInt();
            boolean flag;
            EnterpriseField aenterprisefield[];
            int j;
            if(parcel.readInt() != 0)
                flag = true;
            else
                flag = false;
            wificonfiguration.hiddenSSID = flag;
            wificonfiguration.allowedKeyManagement = WifiConfiguration.readBitSet(parcel);
            wificonfiguration.allowedProtocols = WifiConfiguration.readBitSet(parcel);
            wificonfiguration.allowedAuthAlgorithms = WifiConfiguration.readBitSet(parcel);
            wificonfiguration.allowedPairwiseCiphers = WifiConfiguration.readBitSet(parcel);
            wificonfiguration.allowedGroupCiphers = WifiConfiguration.readBitSet(parcel);
            aenterprisefield = wificonfiguration.enterpriseFields;
            j = aenterprisefield.length;
            for(int k = 0; k < j; k++)
                aenterprisefield[k].setValue(parcel.readString());

            wificonfiguration.ipAssignment = IpAssignment.valueOf(parcel.readString());
            wificonfiguration.proxySettings = ProxySettings.valueOf(parcel.readString());
            wificonfiguration.linkProperties = (LinkProperties)parcel.readParcelable(null);
            return wificonfiguration;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public WifiConfiguration[] newArray(int i) {
            return new WifiConfiguration[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int DISABLED_AUTH_FAILURE = 3;
    public static final int DISABLED_DHCP_FAILURE = 2;
    public static final int DISABLED_DNS_FAILURE = 1;
    public static final int DISABLED_UNKNOWN_REASON = 0;
    public static final String ENGINE_DISABLE = "0";
    public static final String ENGINE_ENABLE = "1";
    public static final int INVALID_NETWORK_ID = -1;
    public static final String KEYSTORE_ENGINE_ID = "keystore";
    public static final String KEYSTORE_URI = "keystore://";
    public static final String OLD_PRIVATE_KEY_NAME = "private_key";
    public static final String bssidVarName = "bssid";
    public static final String hiddenSSIDVarName = "scan_ssid";
    public static final String priorityVarName = "priority";
    public static final String pskVarName = "psk";
    public static final String ssidVarName = "ssid";
    public static final String wepKeyVarNames[];
    public static final String wepTxKeyIdxVarName = "wep_tx_keyidx";
    public String BSSID;
    public String SSID;
    public BitSet allowedAuthAlgorithms;
    public BitSet allowedGroupCiphers;
    public BitSet allowedKeyManagement;
    public BitSet allowedPairwiseCiphers;
    public BitSet allowedProtocols;
    public EnterpriseField anonymous_identity;
    public EnterpriseField ca_cert;
    public EnterpriseField client_cert;
    public int disableReason;
    public EnterpriseField eap;
    public EnterpriseField engine;
    public EnterpriseField engine_id;
    public EnterpriseField enterpriseFields[];
    public boolean hiddenSSID;
    public EnterpriseField identity;
    public IpAssignment ipAssignment;
    public EnterpriseField key_id;
    public LinkProperties linkProperties;
    public int networkId;
    public EnterpriseField password;
    public EnterpriseField phase2;
    public String preSharedKey;
    public int priority;
    public EnterpriseField private_key;
    public ProxySettings proxySettings;
    public int status;
    public String wapiASCert;
    public String wapiPsk;
    public int wapiPskType;
    public String wapiUserCert;
    public String wepKeys[];
    public int wepTxKeyIndex;

    static  {
        String as[] = new String[4];
        as[0] = "wep_key0";
        as[1] = "wep_key1";
        as[2] = "wep_key2";
        as[3] = "wep_key3";
        wepKeyVarNames = as;
    }

}
