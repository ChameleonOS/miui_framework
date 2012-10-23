// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.os.Handler;
import android.os.Message;
import com.android.internal.telephony.gsm.SmsBroadcastConfigInfo;

// Referenced classes of package com.android.internal.telephony:
//            UUSInfo

public interface CommandsInterface {
    public static final class RadioState extends Enum {

        public static RadioState valueOf(String s) {
            return (RadioState)Enum.valueOf(com/android/internal/telephony/CommandsInterface$RadioState, s);
        }

        public static RadioState[] values() {
            return (RadioState[])$VALUES.clone();
        }

        public boolean isAvailable() {
            boolean flag;
            if(this != RADIO_UNAVAILABLE)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public boolean isOn() {
            boolean flag;
            if(this == RADIO_ON)
                flag = true;
            else
                flag = false;
            return flag;
        }

        private static final RadioState $VALUES[];
        public static final RadioState RADIO_OFF;
        public static final RadioState RADIO_ON;
        public static final RadioState RADIO_UNAVAILABLE;

        static  {
            RADIO_OFF = new RadioState("RADIO_OFF", 0);
            RADIO_UNAVAILABLE = new RadioState("RADIO_UNAVAILABLE", 1);
            RADIO_ON = new RadioState("RADIO_ON", 2);
            RadioState aradiostate[] = new RadioState[3];
            aradiostate[0] = RADIO_OFF;
            aradiostate[1] = RADIO_UNAVAILABLE;
            aradiostate[2] = RADIO_ON;
            $VALUES = aradiostate;
        }

        private RadioState(String s, int i) {
            super(s, i);
        }
    }


    public abstract void acceptCall(Message message);

    public abstract void acknowledgeIncomingGsmSmsWithPdu(boolean flag, String s, Message message);

    public abstract void acknowledgeLastIncomingCdmaSms(boolean flag, int i, Message message);

    public abstract void acknowledgeLastIncomingGsmSms(boolean flag, int i, Message message);

    public abstract void cancelPendingUssd(Message message);

    public abstract void changeBarringPassword(String s, String s1, String s2, Message message);

    public abstract void changeIccPin(String s, String s1, Message message);

    public abstract void changeIccPin2(String s, String s1, Message message);

    public abstract void changeIccPin2ForApp(String s, String s1, String s2, Message message);

    public abstract void changeIccPinForApp(String s, String s1, String s2, Message message);

    public abstract void conference(Message message);

    public abstract void deactivateDataCall(int i, int j, Message message);

    public abstract void deleteSmsOnRuim(int i, Message message);

    public abstract void deleteSmsOnSim(int i, Message message);

    public abstract void dial(String s, int i, Message message);

    public abstract void dial(String s, int i, UUSInfo uusinfo, Message message);

    public abstract void exitEmergencyCallbackMode(Message message);

    public abstract void explicitCallTransfer(Message message);

    public abstract void getAvailableNetworks(Message message);

    public abstract void getBasebandVersion(Message message);

    public abstract void getCDMASubscription(Message message);

    public abstract void getCLIR(Message message);

    public abstract void getCdmaBroadcastConfig(Message message);

    public abstract void getCdmaSubscriptionSource(Message message);

    public abstract void getCurrentCalls(Message message);

    public abstract void getDataCallList(Message message);

    public abstract void getDataRegistrationState(Message message);

    public abstract void getDeviceIdentity(Message message);

    public abstract void getGsmBroadcastConfig(Message message);

    public abstract void getIMEI(Message message);

    public abstract void getIMEISV(Message message);

    public abstract void getIMSI(Message message);

    public abstract void getIMSIForApp(String s, Message message);

    public abstract void getIccCardStatus(Message message);

    public abstract void getLastCallFailCause(Message message);

    public abstract void getLastDataCallFailCause(Message message);

    public abstract void getLastPdpFailCause(Message message);

    public abstract int getLteOnCdmaMode();

    public abstract void getMute(Message message);

    public abstract void getNeighboringCids(Message message);

    public abstract void getNetworkSelectionMode(Message message);

    public abstract void getOperator(Message message);

    public abstract void getPDPContextList(Message message);

    public abstract void getPreferredNetworkType(Message message);

    public abstract void getPreferredVoicePrivacy(Message message);

    public abstract RadioState getRadioState();

    public abstract void getSignalStrength(Message message);

    public abstract void getSmscAddress(Message message);

    public abstract void getVoiceRadioTechnology(Message message);

    public abstract void getVoiceRegistrationState(Message message);

    public abstract void handleCallSetupRequestFromSim(boolean flag, Message message);

    public abstract void hangupConnection(int i, Message message);

    public abstract void hangupForegroundResumeBackground(Message message);

    public abstract void hangupWaitingOrBackground(Message message);

    public abstract void iccIO(int i, int j, String s, int k, int l, int i1, String s1, 
            String s2, Message message);

    public abstract void iccIOForApp(int i, int j, String s, int k, int l, int i1, String s1, 
            String s2, String s3, Message message);

    public abstract void invokeOemRilRequestRaw(byte abyte0[], Message message);

    public abstract void invokeOemRilRequestStrings(String as[], Message message);

    public abstract void queryAvailableBandMode(Message message);

    public abstract void queryCLIP(Message message);

    public abstract void queryCallForwardStatus(int i, int j, String s, Message message);

    public abstract void queryCallWaiting(int i, Message message);

    public abstract void queryCdmaRoamingPreference(Message message);

    public abstract void queryFacilityLock(String s, String s1, int i, Message message);

    public abstract void queryFacilityLockForApp(String s, String s1, int i, String s2, Message message);

    public abstract void queryTTYMode(Message message);

    public abstract void registerFoT53ClirlInfo(Handler handler, int i, Object obj);

    public abstract void registerForAvailable(Handler handler, int i, Object obj);

    public abstract void registerForCallStateChanged(Handler handler, int i, Object obj);

    public abstract void registerForCallWaitingInfo(Handler handler, int i, Object obj);

    public abstract void registerForCdmaOtaProvision(Handler handler, int i, Object obj);

    public abstract void registerForCdmaPrlChanged(Handler handler, int i, Object obj);

    public abstract void registerForCdmaSubscriptionChanged(Handler handler, int i, Object obj);

    public abstract void registerForDataNetworkStateChanged(Handler handler, int i, Object obj);

    public abstract void registerForDisplayInfo(Handler handler, int i, Object obj);

    public abstract void registerForExitEmergencyCallbackMode(Handler handler, int i, Object obj);

    public abstract void registerForIccRefresh(Handler handler, int i, Object obj);

    public abstract void registerForIccStatusChanged(Handler handler, int i, Object obj);

    public abstract void registerForInCallVoicePrivacyOff(Handler handler, int i, Object obj);

    public abstract void registerForInCallVoicePrivacyOn(Handler handler, int i, Object obj);

    public abstract void registerForLineControlInfo(Handler handler, int i, Object obj);

    public abstract void registerForNotAvailable(Handler handler, int i, Object obj);

    public abstract void registerForNumberInfo(Handler handler, int i, Object obj);

    public abstract void registerForOffOrNotAvailable(Handler handler, int i, Object obj);

    public abstract void registerForOn(Handler handler, int i, Object obj);

    public abstract void registerForRadioStateChanged(Handler handler, int i, Object obj);

    public abstract void registerForRedirectedNumberInfo(Handler handler, int i, Object obj);

    public abstract void registerForResendIncallMute(Handler handler, int i, Object obj);

    public abstract void registerForRilConnected(Handler handler, int i, Object obj);

    public abstract void registerForRingbackTone(Handler handler, int i, Object obj);

    public abstract void registerForSignalInfo(Handler handler, int i, Object obj);

    public abstract void registerForT53AudioControlInfo(Handler handler, int i, Object obj);

    public abstract void registerForVoiceNetworkStateChanged(Handler handler, int i, Object obj);

    public abstract void registerForVoiceRadioTechChanged(Handler handler, int i, Object obj);

    public abstract void rejectCall(Message message);

    public abstract void reportSmsMemoryStatus(boolean flag, Message message);

    public abstract void reportStkServiceIsRunning(Message message);

    public abstract void requestIsimAuthentication(String s, Message message);

    public abstract void resetRadio(Message message);

    public abstract void sendBurstDtmf(String s, int i, int j, Message message);

    public abstract void sendCDMAFeatureCode(String s, Message message);

    public abstract void sendCdmaSms(byte abyte0[], Message message);

    public abstract void sendDtmf(char c, Message message);

    public abstract void sendEnvelope(String s, Message message);

    public abstract void sendEnvelopeWithStatus(String s, Message message);

    public abstract void sendSMS(String s, String s1, Message message);

    public abstract void sendTerminalResponse(String s, Message message);

    public abstract void sendUSSD(String s, Message message);

    public abstract void separateConnection(int i, Message message);

    public abstract void setBandMode(int i, Message message);

    public abstract void setCLIR(int i, Message message);

    public abstract void setCallForward(int i, int j, int k, String s, int l, Message message);

    public abstract void setCallWaiting(boolean flag, int i, Message message);

    public abstract void setCdmaBroadcastActivation(boolean flag, Message message);

    public abstract void setCdmaBroadcastConfig(int ai[], Message message);

    public abstract void setCdmaRoamingPreference(int i, Message message);

    public abstract void setCdmaSubscriptionSource(int i, Message message);

    public abstract void setCurrentPreferredNetworkType();

    public abstract void setEmergencyCallbackMode(Handler handler, int i, Object obj);

    public abstract void setFacilityLock(String s, boolean flag, String s1, int i, Message message);

    public abstract void setFacilityLockForApp(String s, boolean flag, String s1, int i, String s2, Message message);

    public abstract void setGsmBroadcastActivation(boolean flag, Message message);

    public abstract void setGsmBroadcastConfig(SmsBroadcastConfigInfo asmsbroadcastconfiginfo[], Message message);

    public abstract void setLocationUpdates(boolean flag, Message message);

    public abstract void setMute(boolean flag, Message message);

    public abstract void setNetworkSelectionModeAutomatic(Message message);

    public abstract void setNetworkSelectionModeManual(String s, Message message);

    public abstract void setOnCallRing(Handler handler, int i, Object obj);

    public abstract void setOnCatCallSetUp(Handler handler, int i, Object obj);

    public abstract void setOnCatEvent(Handler handler, int i, Object obj);

    public abstract void setOnCatProactiveCmd(Handler handler, int i, Object obj);

    public abstract void setOnCatSessionEnd(Handler handler, int i, Object obj);

    public abstract void setOnIccRefresh(Handler handler, int i, Object obj);

    public abstract void setOnIccSmsFull(Handler handler, int i, Object obj);

    public abstract void setOnNITZTime(Handler handler, int i, Object obj);

    public abstract void setOnNewCdmaSms(Handler handler, int i, Object obj);

    public abstract void setOnNewGsmBroadcastSms(Handler handler, int i, Object obj);

    public abstract void setOnNewGsmSms(Handler handler, int i, Object obj);

    public abstract void setOnRestrictedStateChanged(Handler handler, int i, Object obj);

    public abstract void setOnSignalStrengthUpdate(Handler handler, int i, Object obj);

    public abstract void setOnSmsOnSim(Handler handler, int i, Object obj);

    public abstract void setOnSmsStatus(Handler handler, int i, Object obj);

    public abstract void setOnSuppServiceNotification(Handler handler, int i, Object obj);

    public abstract void setOnUSSD(Handler handler, int i, Object obj);

    public abstract void setPhoneType(int i);

    public abstract void setPreferredNetworkType(int i, Message message);

    public abstract void setPreferredVoicePrivacy(boolean flag, Message message);

    public abstract void setRadioPower(boolean flag, Message message);

    public abstract void setSmscAddress(String s, Message message);

    public abstract void setSuppServiceNotifications(boolean flag, Message message);

    public abstract void setTTYMode(int i, Message message);

    public abstract void setupDataCall(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            Message message);

    public abstract void startDtmf(char c, Message message);

    public abstract void stopDtmf(Message message);

    public abstract void supplyIccPin(String s, Message message);

    public abstract void supplyIccPin2(String s, Message message);

    public abstract void supplyIccPin2ForApp(String s, String s1, Message message);

    public abstract void supplyIccPinForApp(String s, String s1, Message message);

    public abstract void supplyIccPuk(String s, String s1, Message message);

    public abstract void supplyIccPuk2(String s, String s1, Message message);

    public abstract void supplyIccPuk2ForApp(String s, String s1, String s2, Message message);

    public abstract void supplyIccPukForApp(String s, String s1, String s2, Message message);

    public abstract void supplyNetworkDepersonalization(String s, Message message);

    public abstract void switchWaitingOrHoldingAndActive(Message message);

    public abstract void testingEmergencyCall();

    public abstract void unSetOnCallRing(Handler handler);

    public abstract void unSetOnCatCallSetUp(Handler handler);

    public abstract void unSetOnCatEvent(Handler handler);

    public abstract void unSetOnCatProactiveCmd(Handler handler);

    public abstract void unSetOnCatSessionEnd(Handler handler);

    public abstract void unSetOnIccSmsFull(Handler handler);

    public abstract void unSetOnNITZTime(Handler handler);

    public abstract void unSetOnNewCdmaSms(Handler handler);

    public abstract void unSetOnNewGsmBroadcastSms(Handler handler);

    public abstract void unSetOnNewGsmSms(Handler handler);

    public abstract void unSetOnRestrictedStateChanged(Handler handler);

    public abstract void unSetOnSignalStrengthUpdate(Handler handler);

    public abstract void unSetOnSmsOnSim(Handler handler);

    public abstract void unSetOnSmsStatus(Handler handler);

    public abstract void unSetOnSuppServiceNotification(Handler handler);

    public abstract void unSetOnUSSD(Handler handler);

    public abstract void unregisterForAvailable(Handler handler);

    public abstract void unregisterForCallStateChanged(Handler handler);

    public abstract void unregisterForCallWaitingInfo(Handler handler);

    public abstract void unregisterForCdmaOtaProvision(Handler handler);

    public abstract void unregisterForCdmaPrlChanged(Handler handler);

    public abstract void unregisterForCdmaSubscriptionChanged(Handler handler);

    public abstract void unregisterForDataNetworkStateChanged(Handler handler);

    public abstract void unregisterForDisplayInfo(Handler handler);

    public abstract void unregisterForExitEmergencyCallbackMode(Handler handler);

    public abstract void unregisterForIccRefresh(Handler handler);

    public abstract void unregisterForIccStatusChanged(Handler handler);

    public abstract void unregisterForInCallVoicePrivacyOff(Handler handler);

    public abstract void unregisterForInCallVoicePrivacyOn(Handler handler);

    public abstract void unregisterForLineControlInfo(Handler handler);

    public abstract void unregisterForNotAvailable(Handler handler);

    public abstract void unregisterForNumberInfo(Handler handler);

    public abstract void unregisterForOffOrNotAvailable(Handler handler);

    public abstract void unregisterForOn(Handler handler);

    public abstract void unregisterForRadioStateChanged(Handler handler);

    public abstract void unregisterForRedirectedNumberInfo(Handler handler);

    public abstract void unregisterForResendIncallMute(Handler handler);

    public abstract void unregisterForRilConnected(Handler handler);

    public abstract void unregisterForRingbackTone(Handler handler);

    public abstract void unregisterForSignalInfo(Handler handler);

    public abstract void unregisterForT53AudioControlInfo(Handler handler);

    public abstract void unregisterForT53ClirInfo(Handler handler);

    public abstract void unregisterForVoiceNetworkStateChanged(Handler handler);

    public abstract void unregisterForVoiceRadioTechChanged(Handler handler);

    public abstract void unsetOnIccRefresh(Handler handler);

    public abstract void writeSmsToRuim(int i, String s, Message message);

    public abstract void writeSmsToSim(int i, String s, String s1, Message message);

    public static final String CB_FACILITY_BAIC = "AI";
    public static final String CB_FACILITY_BAICr = "IR";
    public static final String CB_FACILITY_BAOC = "AO";
    public static final String CB_FACILITY_BAOIC = "OI";
    public static final String CB_FACILITY_BAOICxH = "OX";
    public static final String CB_FACILITY_BA_ALL = "AB";
    public static final String CB_FACILITY_BA_FD = "FD";
    public static final String CB_FACILITY_BA_MO = "AG";
    public static final String CB_FACILITY_BA_MT = "AC";
    public static final String CB_FACILITY_BA_SIM = "SC";
    public static final int CDMA_SMS_FAIL_CAUSE_ENCODING_PROBLEM = 96;
    public static final int CDMA_SMS_FAIL_CAUSE_INVALID_TELESERVICE_ID = 4;
    public static final int CDMA_SMS_FAIL_CAUSE_OTHER_TERMINAL_PROBLEM = 39;
    public static final int CDMA_SMS_FAIL_CAUSE_RESOURCE_SHORTAGE = 35;
    public static final int CF_ACTION_DISABLE = 0;
    public static final int CF_ACTION_ENABLE = 1;
    public static final int CF_ACTION_ERASURE = 4;
    public static final int CF_ACTION_REGISTRATION = 3;
    public static final int CF_REASON_ALL = 4;
    public static final int CF_REASON_ALL_CONDITIONAL = 5;
    public static final int CF_REASON_BUSY = 1;
    public static final int CF_REASON_NOT_REACHABLE = 3;
    public static final int CF_REASON_NO_REPLY = 2;
    public static final int CF_REASON_UNCONDITIONAL = 0;
    public static final int CLIR_DEFAULT = 0;
    public static final int CLIR_INVOCATION = 1;
    public static final int CLIR_SUPPRESSION = 2;
    public static final int GSM_SMS_FAIL_CAUSE_MEMORY_CAPACITY_EXCEEDED = 211;
    public static final int GSM_SMS_FAIL_CAUSE_UNSPECIFIED_ERROR = 255;
    public static final int GSM_SMS_FAIL_CAUSE_USIM_APP_TOOLKIT_BUSY = 212;
    public static final int GSM_SMS_FAIL_CAUSE_USIM_DATA_DOWNLOAD_ERROR = 213;
    public static final int SERVICE_CLASS_DATA = 2;
    public static final int SERVICE_CLASS_DATA_ASYNC = 32;
    public static final int SERVICE_CLASS_DATA_SYNC = 16;
    public static final int SERVICE_CLASS_FAX = 4;
    public static final int SERVICE_CLASS_MAX = 128;
    public static final int SERVICE_CLASS_NONE = 0;
    public static final int SERVICE_CLASS_PACKET = 64;
    public static final int SERVICE_CLASS_PAD = 128;
    public static final int SERVICE_CLASS_SMS = 8;
    public static final int SERVICE_CLASS_VOICE = 1;
    public static final int USSD_MODE_NOTIFY = 0;
    public static final int USSD_MODE_REQUEST = 1;
}
