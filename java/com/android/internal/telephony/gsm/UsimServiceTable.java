// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.gsm;

import com.android.internal.telephony.IccServiceTable;

public final class UsimServiceTable extends IccServiceTable {
    public static final class UsimService extends Enum {

        public static UsimService valueOf(String s) {
            return (UsimService)Enum.valueOf(com/android/internal/telephony/gsm/UsimServiceTable$UsimService, s);
        }

        public static UsimService[] values() {
            return (UsimService[])$VALUES.clone();
        }

        private static final UsimService $VALUES[];
        public static final UsimService ADVICE_OF_CHARGE;
        public static final UsimService ALLOWED_CSG_LISTS_AND_INDICATIONS;
        public static final UsimService APN_CONTROL_LIST;
        public static final UsimService BDN;
        public static final UsimService BDN_EXTENSION;
        public static final UsimService CALL_CONTROL_BY_USIM;
        public static final UsimService CALL_CONTROL_ON_EPS_PDN_CONNECTION_BY_USIM;
        public static final UsimService CAP_CONFIG_PARAMS_2;
        public static final UsimService CB_MESSAGE_ID;
        public static final UsimService CB_MESSAGE_ID_RANGES;
        public static final UsimService CFI_STATUS;
        public static final UsimService COOPERATIVE_NETWORK_LIST;
        public static final UsimService CPBCCH_INFO;
        public static final UsimService CSG_DISPLAY_CONTROL;
        public static final UsimService DATA_DL_VIA_SMS_CB;
        public static final UsimService DATA_DL_VIA_SMS_PP;
        public static final UsimService DATA_DL_VIA_USSD;
        public static final UsimService DEPERSONALISATION_CONTROL_KEYS;
        public static final UsimService ECALL_DATA;
        public static final UsimService EMLPP;
        public static final UsimService EMLPP_AUTO_ANSWER;
        public static final UsimService ENABLED_SERVICES_TABLE;
        public static final UsimService EPS_MOBILITY_MANAGEMENT_INFO;
        public static final UsimService EQUIVALENT_HPLMN;
        public static final UsimService EQUIVALENT_HPLMN_PRESENTATION;
        public static final UsimService EXTENDED_TERMINAL_APPLICATIONS;
        public static final UsimService EXTENSION_5;
        public static final UsimService FDN;
        public static final UsimService FDN_EXTENSION;
        public static final UsimService GBA;
        public static final UsimService GBA_LOCAL_KEY_ESTABLISHMENT;
        public static final UsimService GPRS_CALL_CONTROL_BY_USIM;
        public static final UsimService GROUP_ID_LEVEL_1;
        public static final UsimService GROUP_ID_LEVEL_2;
        public static final UsimService GSM_ACCESS;
        public static final UsimService GSM_SECURITY_CONTEXT;
        public static final UsimService HPLMN_DIRECT_ACCESS;
        public static final UsimService HPLMN_SELECT;
        public static final UsimService IGNORED_1;
        public static final UsimService IGNORED_2;
        public static final UsimService IMAGE;
        public static final UsimService IMS_COMMUNICATION_CONTROL_BY_USIM;
        public static final UsimService INCOMING_CALL_INFO;
        public static final UsimService INVESTIGATION_SCAN;
        public static final UsimService IWLAN_EQUIVALENT_HPLMN_PRESENTATION;
        public static final UsimService IWLAN_HOME_ID_LIST;
        public static final UsimService IWLAN_HPLMN_PRIORITY_INDICATION;
        public static final UsimService IWLAN_LAST_REGISTERED_PLMN;
        public static final UsimService IWLAN_OPERATOR_PLMN_SELECT;
        public static final UsimService IWLAN_USER_PLMN_SELECT;
        public static final UsimService LAST_RPLMN_SELECTION_INDICATION;
        public static final UsimService LOCALISED_SERVICE_AREAS;
        public static final UsimService MBDN;
        public static final UsimService MBMS_SECURITY;
        public static final UsimService MEXE;
        public static final UsimService MMS_CONNECTIVITY_PARAMS;
        public static final UsimService MMS_NOTIFICATION;
        public static final UsimService MMS_NOTIFICATION_EXTENSION;
        public static final UsimService MM_STORAGE;
        public static final UsimService MO_SMS_CONTROL_BY_USIM;
        public static final UsimService MSISDN;
        public static final UsimService MWI_STATUS;
        public static final UsimService NAS_CONFIG_BY_USIM;
        public static final UsimService NETWORK_INDICATION_OF_ALERTING;
        public static final UsimService OMA_BCAST_PROFILE;
        public static final UsimService OPERATOR_CSG_LISTS_AND_INDICATIONS;
        public static final UsimService OPERATOR_PLMN_LIST;
        public static final UsimService OPERATOR_PLMN_SELECT;
        public static final UsimService OPERATOR_WSID_LIST;
        public static final UsimService OUTGOING_CALL_INFO;
        public static final UsimService PHONEBOOK;
        public static final UsimService PLMN_NETWORK_NAME;
        public static final UsimService PLMN_NETWORK_NAME_ICON;
        public static final UsimService PSEUDONYM;
        public static final UsimService RFU;
        public static final UsimService RUN_AT_COMMAND;
        public static final UsimService SDN;
        public static final UsimService SDN_EXTENSION;
        public static final UsimService SERVICE_PROVIDER_DISPLAY_INFO;
        public static final UsimService SM_OVER_IP;
        public static final UsimService SM_SERVICE_PARAMS;
        public static final UsimService SM_STATUS_REPORTS;
        public static final UsimService SM_STORAGE;
        public static final UsimService SPN;
        public static final UsimService SPN_ICON;
        public static final UsimService TERMINAL_APPLICATIONS;
        public static final UsimService TERMINAL_PROFILE_AFTER_UICC_ACTIVATION;
        public static final UsimService UICC_ACCESS_TO_IMS;
        public static final UsimService USER_PLMN_SELECT;
        public static final UsimService USER_WSID_LIST;
        public static final UsimService USIM_IP_CONNECTION_PARAMS;
        public static final UsimService VBS_GROUP_ID_LIST;
        public static final UsimService VBS_SECURITY;
        public static final UsimService VGCS_GROUP_ID_LIST;
        public static final UsimService VGCS_SECURITY;
        public static final UsimService WLAN_REAUTH_IDENTITY;

        static  {
            PHONEBOOK = new UsimService("PHONEBOOK", 0);
            FDN = new UsimService("FDN", 1);
            FDN_EXTENSION = new UsimService("FDN_EXTENSION", 2);
            SDN = new UsimService("SDN", 3);
            SDN_EXTENSION = new UsimService("SDN_EXTENSION", 4);
            BDN = new UsimService("BDN", 5);
            BDN_EXTENSION = new UsimService("BDN_EXTENSION", 6);
            OUTGOING_CALL_INFO = new UsimService("OUTGOING_CALL_INFO", 7);
            INCOMING_CALL_INFO = new UsimService("INCOMING_CALL_INFO", 8);
            SM_STORAGE = new UsimService("SM_STORAGE", 9);
            SM_STATUS_REPORTS = new UsimService("SM_STATUS_REPORTS", 10);
            SM_SERVICE_PARAMS = new UsimService("SM_SERVICE_PARAMS", 11);
            ADVICE_OF_CHARGE = new UsimService("ADVICE_OF_CHARGE", 12);
            CAP_CONFIG_PARAMS_2 = new UsimService("CAP_CONFIG_PARAMS_2", 13);
            CB_MESSAGE_ID = new UsimService("CB_MESSAGE_ID", 14);
            CB_MESSAGE_ID_RANGES = new UsimService("CB_MESSAGE_ID_RANGES", 15);
            GROUP_ID_LEVEL_1 = new UsimService("GROUP_ID_LEVEL_1", 16);
            GROUP_ID_LEVEL_2 = new UsimService("GROUP_ID_LEVEL_2", 17);
            SPN = new UsimService("SPN", 18);
            USER_PLMN_SELECT = new UsimService("USER_PLMN_SELECT", 19);
            MSISDN = new UsimService("MSISDN", 20);
            IMAGE = new UsimService("IMAGE", 21);
            LOCALISED_SERVICE_AREAS = new UsimService("LOCALISED_SERVICE_AREAS", 22);
            EMLPP = new UsimService("EMLPP", 23);
            EMLPP_AUTO_ANSWER = new UsimService("EMLPP_AUTO_ANSWER", 24);
            RFU = new UsimService("RFU", 25);
            GSM_ACCESS = new UsimService("GSM_ACCESS", 26);
            DATA_DL_VIA_SMS_PP = new UsimService("DATA_DL_VIA_SMS_PP", 27);
            DATA_DL_VIA_SMS_CB = new UsimService("DATA_DL_VIA_SMS_CB", 28);
            CALL_CONTROL_BY_USIM = new UsimService("CALL_CONTROL_BY_USIM", 29);
            MO_SMS_CONTROL_BY_USIM = new UsimService("MO_SMS_CONTROL_BY_USIM", 30);
            RUN_AT_COMMAND = new UsimService("RUN_AT_COMMAND", 31);
            IGNORED_1 = new UsimService("IGNORED_1", 32);
            ENABLED_SERVICES_TABLE = new UsimService("ENABLED_SERVICES_TABLE", 33);
            APN_CONTROL_LIST = new UsimService("APN_CONTROL_LIST", 34);
            DEPERSONALISATION_CONTROL_KEYS = new UsimService("DEPERSONALISATION_CONTROL_KEYS", 35);
            COOPERATIVE_NETWORK_LIST = new UsimService("COOPERATIVE_NETWORK_LIST", 36);
            GSM_SECURITY_CONTEXT = new UsimService("GSM_SECURITY_CONTEXT", 37);
            CPBCCH_INFO = new UsimService("CPBCCH_INFO", 38);
            INVESTIGATION_SCAN = new UsimService("INVESTIGATION_SCAN", 39);
            MEXE = new UsimService("MEXE", 40);
            OPERATOR_PLMN_SELECT = new UsimService("OPERATOR_PLMN_SELECT", 41);
            HPLMN_SELECT = new UsimService("HPLMN_SELECT", 42);
            EXTENSION_5 = new UsimService("EXTENSION_5", 43);
            PLMN_NETWORK_NAME = new UsimService("PLMN_NETWORK_NAME", 44);
            OPERATOR_PLMN_LIST = new UsimService("OPERATOR_PLMN_LIST", 45);
            MBDN = new UsimService("MBDN", 46);
            MWI_STATUS = new UsimService("MWI_STATUS", 47);
            CFI_STATUS = new UsimService("CFI_STATUS", 48);
            IGNORED_2 = new UsimService("IGNORED_2", 49);
            SERVICE_PROVIDER_DISPLAY_INFO = new UsimService("SERVICE_PROVIDER_DISPLAY_INFO", 50);
            MMS_NOTIFICATION = new UsimService("MMS_NOTIFICATION", 51);
            MMS_NOTIFICATION_EXTENSION = new UsimService("MMS_NOTIFICATION_EXTENSION", 52);
            GPRS_CALL_CONTROL_BY_USIM = new UsimService("GPRS_CALL_CONTROL_BY_USIM", 53);
            MMS_CONNECTIVITY_PARAMS = new UsimService("MMS_CONNECTIVITY_PARAMS", 54);
            NETWORK_INDICATION_OF_ALERTING = new UsimService("NETWORK_INDICATION_OF_ALERTING", 55);
            VGCS_GROUP_ID_LIST = new UsimService("VGCS_GROUP_ID_LIST", 56);
            VBS_GROUP_ID_LIST = new UsimService("VBS_GROUP_ID_LIST", 57);
            PSEUDONYM = new UsimService("PSEUDONYM", 58);
            IWLAN_USER_PLMN_SELECT = new UsimService("IWLAN_USER_PLMN_SELECT", 59);
            IWLAN_OPERATOR_PLMN_SELECT = new UsimService("IWLAN_OPERATOR_PLMN_SELECT", 60);
            USER_WSID_LIST = new UsimService("USER_WSID_LIST", 61);
            OPERATOR_WSID_LIST = new UsimService("OPERATOR_WSID_LIST", 62);
            VGCS_SECURITY = new UsimService("VGCS_SECURITY", 63);
            VBS_SECURITY = new UsimService("VBS_SECURITY", 64);
            WLAN_REAUTH_IDENTITY = new UsimService("WLAN_REAUTH_IDENTITY", 65);
            MM_STORAGE = new UsimService("MM_STORAGE", 66);
            GBA = new UsimService("GBA", 67);
            MBMS_SECURITY = new UsimService("MBMS_SECURITY", 68);
            DATA_DL_VIA_USSD = new UsimService("DATA_DL_VIA_USSD", 69);
            EQUIVALENT_HPLMN = new UsimService("EQUIVALENT_HPLMN", 70);
            TERMINAL_PROFILE_AFTER_UICC_ACTIVATION = new UsimService("TERMINAL_PROFILE_AFTER_UICC_ACTIVATION", 71);
            EQUIVALENT_HPLMN_PRESENTATION = new UsimService("EQUIVALENT_HPLMN_PRESENTATION", 72);
            LAST_RPLMN_SELECTION_INDICATION = new UsimService("LAST_RPLMN_SELECTION_INDICATION", 73);
            OMA_BCAST_PROFILE = new UsimService("OMA_BCAST_PROFILE", 74);
            GBA_LOCAL_KEY_ESTABLISHMENT = new UsimService("GBA_LOCAL_KEY_ESTABLISHMENT", 75);
            TERMINAL_APPLICATIONS = new UsimService("TERMINAL_APPLICATIONS", 76);
            SPN_ICON = new UsimService("SPN_ICON", 77);
            PLMN_NETWORK_NAME_ICON = new UsimService("PLMN_NETWORK_NAME_ICON", 78);
            USIM_IP_CONNECTION_PARAMS = new UsimService("USIM_IP_CONNECTION_PARAMS", 79);
            IWLAN_HOME_ID_LIST = new UsimService("IWLAN_HOME_ID_LIST", 80);
            IWLAN_EQUIVALENT_HPLMN_PRESENTATION = new UsimService("IWLAN_EQUIVALENT_HPLMN_PRESENTATION", 81);
            IWLAN_HPLMN_PRIORITY_INDICATION = new UsimService("IWLAN_HPLMN_PRIORITY_INDICATION", 82);
            IWLAN_LAST_REGISTERED_PLMN = new UsimService("IWLAN_LAST_REGISTERED_PLMN", 83);
            EPS_MOBILITY_MANAGEMENT_INFO = new UsimService("EPS_MOBILITY_MANAGEMENT_INFO", 84);
            ALLOWED_CSG_LISTS_AND_INDICATIONS = new UsimService("ALLOWED_CSG_LISTS_AND_INDICATIONS", 85);
            CALL_CONTROL_ON_EPS_PDN_CONNECTION_BY_USIM = new UsimService("CALL_CONTROL_ON_EPS_PDN_CONNECTION_BY_USIM", 86);
            HPLMN_DIRECT_ACCESS = new UsimService("HPLMN_DIRECT_ACCESS", 87);
            ECALL_DATA = new UsimService("ECALL_DATA", 88);
            OPERATOR_CSG_LISTS_AND_INDICATIONS = new UsimService("OPERATOR_CSG_LISTS_AND_INDICATIONS", 89);
            SM_OVER_IP = new UsimService("SM_OVER_IP", 90);
            CSG_DISPLAY_CONTROL = new UsimService("CSG_DISPLAY_CONTROL", 91);
            IMS_COMMUNICATION_CONTROL_BY_USIM = new UsimService("IMS_COMMUNICATION_CONTROL_BY_USIM", 92);
            EXTENDED_TERMINAL_APPLICATIONS = new UsimService("EXTENDED_TERMINAL_APPLICATIONS", 93);
            UICC_ACCESS_TO_IMS = new UsimService("UICC_ACCESS_TO_IMS", 94);
            NAS_CONFIG_BY_USIM = new UsimService("NAS_CONFIG_BY_USIM", 95);
            UsimService ausimservice[] = new UsimService[96];
            ausimservice[0] = PHONEBOOK;
            ausimservice[1] = FDN;
            ausimservice[2] = FDN_EXTENSION;
            ausimservice[3] = SDN;
            ausimservice[4] = SDN_EXTENSION;
            ausimservice[5] = BDN;
            ausimservice[6] = BDN_EXTENSION;
            ausimservice[7] = OUTGOING_CALL_INFO;
            ausimservice[8] = INCOMING_CALL_INFO;
            ausimservice[9] = SM_STORAGE;
            ausimservice[10] = SM_STATUS_REPORTS;
            ausimservice[11] = SM_SERVICE_PARAMS;
            ausimservice[12] = ADVICE_OF_CHARGE;
            ausimservice[13] = CAP_CONFIG_PARAMS_2;
            ausimservice[14] = CB_MESSAGE_ID;
            ausimservice[15] = CB_MESSAGE_ID_RANGES;
            ausimservice[16] = GROUP_ID_LEVEL_1;
            ausimservice[17] = GROUP_ID_LEVEL_2;
            ausimservice[18] = SPN;
            ausimservice[19] = USER_PLMN_SELECT;
            ausimservice[20] = MSISDN;
            ausimservice[21] = IMAGE;
            ausimservice[22] = LOCALISED_SERVICE_AREAS;
            ausimservice[23] = EMLPP;
            ausimservice[24] = EMLPP_AUTO_ANSWER;
            ausimservice[25] = RFU;
            ausimservice[26] = GSM_ACCESS;
            ausimservice[27] = DATA_DL_VIA_SMS_PP;
            ausimservice[28] = DATA_DL_VIA_SMS_CB;
            ausimservice[29] = CALL_CONTROL_BY_USIM;
            ausimservice[30] = MO_SMS_CONTROL_BY_USIM;
            ausimservice[31] = RUN_AT_COMMAND;
            ausimservice[32] = IGNORED_1;
            ausimservice[33] = ENABLED_SERVICES_TABLE;
            ausimservice[34] = APN_CONTROL_LIST;
            ausimservice[35] = DEPERSONALISATION_CONTROL_KEYS;
            ausimservice[36] = COOPERATIVE_NETWORK_LIST;
            ausimservice[37] = GSM_SECURITY_CONTEXT;
            ausimservice[38] = CPBCCH_INFO;
            ausimservice[39] = INVESTIGATION_SCAN;
            ausimservice[40] = MEXE;
            ausimservice[41] = OPERATOR_PLMN_SELECT;
            ausimservice[42] = HPLMN_SELECT;
            ausimservice[43] = EXTENSION_5;
            ausimservice[44] = PLMN_NETWORK_NAME;
            ausimservice[45] = OPERATOR_PLMN_LIST;
            ausimservice[46] = MBDN;
            ausimservice[47] = MWI_STATUS;
            ausimservice[48] = CFI_STATUS;
            ausimservice[49] = IGNORED_2;
            ausimservice[50] = SERVICE_PROVIDER_DISPLAY_INFO;
            ausimservice[51] = MMS_NOTIFICATION;
            ausimservice[52] = MMS_NOTIFICATION_EXTENSION;
            ausimservice[53] = GPRS_CALL_CONTROL_BY_USIM;
            ausimservice[54] = MMS_CONNECTIVITY_PARAMS;
            ausimservice[55] = NETWORK_INDICATION_OF_ALERTING;
            ausimservice[56] = VGCS_GROUP_ID_LIST;
            ausimservice[57] = VBS_GROUP_ID_LIST;
            ausimservice[58] = PSEUDONYM;
            ausimservice[59] = IWLAN_USER_PLMN_SELECT;
            ausimservice[60] = IWLAN_OPERATOR_PLMN_SELECT;
            ausimservice[61] = USER_WSID_LIST;
            ausimservice[62] = OPERATOR_WSID_LIST;
            ausimservice[63] = VGCS_SECURITY;
            ausimservice[64] = VBS_SECURITY;
            ausimservice[65] = WLAN_REAUTH_IDENTITY;
            ausimservice[66] = MM_STORAGE;
            ausimservice[67] = GBA;
            ausimservice[68] = MBMS_SECURITY;
            ausimservice[69] = DATA_DL_VIA_USSD;
            ausimservice[70] = EQUIVALENT_HPLMN;
            ausimservice[71] = TERMINAL_PROFILE_AFTER_UICC_ACTIVATION;
            ausimservice[72] = EQUIVALENT_HPLMN_PRESENTATION;
            ausimservice[73] = LAST_RPLMN_SELECTION_INDICATION;
            ausimservice[74] = OMA_BCAST_PROFILE;
            ausimservice[75] = GBA_LOCAL_KEY_ESTABLISHMENT;
            ausimservice[76] = TERMINAL_APPLICATIONS;
            ausimservice[77] = SPN_ICON;
            ausimservice[78] = PLMN_NETWORK_NAME_ICON;
            ausimservice[79] = USIM_IP_CONNECTION_PARAMS;
            ausimservice[80] = IWLAN_HOME_ID_LIST;
            ausimservice[81] = IWLAN_EQUIVALENT_HPLMN_PRESENTATION;
            ausimservice[82] = IWLAN_HPLMN_PRIORITY_INDICATION;
            ausimservice[83] = IWLAN_LAST_REGISTERED_PLMN;
            ausimservice[84] = EPS_MOBILITY_MANAGEMENT_INFO;
            ausimservice[85] = ALLOWED_CSG_LISTS_AND_INDICATIONS;
            ausimservice[86] = CALL_CONTROL_ON_EPS_PDN_CONNECTION_BY_USIM;
            ausimservice[87] = HPLMN_DIRECT_ACCESS;
            ausimservice[88] = ECALL_DATA;
            ausimservice[89] = OPERATOR_CSG_LISTS_AND_INDICATIONS;
            ausimservice[90] = SM_OVER_IP;
            ausimservice[91] = CSG_DISPLAY_CONTROL;
            ausimservice[92] = IMS_COMMUNICATION_CONTROL_BY_USIM;
            ausimservice[93] = EXTENDED_TERMINAL_APPLICATIONS;
            ausimservice[94] = UICC_ACCESS_TO_IMS;
            ausimservice[95] = NAS_CONFIG_BY_USIM;
            $VALUES = ausimservice;
        }

        private UsimService(String s, int i) {
            super(s, i);
        }
    }


    public UsimServiceTable(byte abyte0[]) {
        super(abyte0);
    }

    protected String getTag() {
        return "UsimServiceTable";
    }

    protected Object[] getValues() {
        return UsimService.values();
    }

    public boolean isAvailable(UsimService usimservice) {
        return super.isAvailable(usimservice.ordinal());
    }
}
