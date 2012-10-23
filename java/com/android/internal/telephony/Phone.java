// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.content.Context;
import android.net.LinkCapabilities;
import android.net.LinkProperties;
import android.os.Handler;
import android.os.Message;
import android.telephony.*;
import com.android.internal.telephony.gsm.UsimServiceTable;
import com.android.internal.telephony.ims.IsimRecords;
import com.android.internal.telephony.test.SimulatedRadioControl;
import java.util.List;

// Referenced classes of package com.android.internal.telephony:
//            CallStateException, Connection, UUSInfo, Call, 
//            IccCard, IccPhoneBookInterfaceManager, IccSmsInterfaceManager, PhoneSubInfo, 
//            OperatorInfo

public interface Phone {
    public static final class SuppService extends Enum {

        public static SuppService valueOf(String s) {
            return (SuppService)Enum.valueOf(com/android/internal/telephony/Phone$SuppService, s);
        }

        public static SuppService[] values() {
            return (SuppService[])$VALUES.clone();
        }

        private static final SuppService $VALUES[];
        public static final SuppService CONFERENCE;
        public static final SuppService HANGUP;
        public static final SuppService REJECT;
        public static final SuppService SEPARATE;
        public static final SuppService SWITCH;
        public static final SuppService TRANSFER;
        public static final SuppService UNKNOWN;

        static  {
            UNKNOWN = new SuppService("UNKNOWN", 0);
            SWITCH = new SuppService("SWITCH", 1);
            SEPARATE = new SuppService("SEPARATE", 2);
            TRANSFER = new SuppService("TRANSFER", 3);
            CONFERENCE = new SuppService("CONFERENCE", 4);
            REJECT = new SuppService("REJECT", 5);
            HANGUP = new SuppService("HANGUP", 6);
            SuppService asuppservice[] = new SuppService[7];
            asuppservice[0] = UNKNOWN;
            asuppservice[1] = SWITCH;
            asuppservice[2] = SEPARATE;
            asuppservice[3] = TRANSFER;
            asuppservice[4] = CONFERENCE;
            asuppservice[5] = REJECT;
            asuppservice[6] = HANGUP;
            $VALUES = asuppservice;
        }

        private SuppService(String s, int i) {
            super(s, i);
        }
    }

    public static final class DataActivityState extends Enum {

        public static DataActivityState valueOf(String s) {
            return (DataActivityState)Enum.valueOf(com/android/internal/telephony/Phone$DataActivityState, s);
        }

        public static DataActivityState[] values() {
            return (DataActivityState[])$VALUES.clone();
        }

        private static final DataActivityState $VALUES[];
        public static final DataActivityState DATAIN;
        public static final DataActivityState DATAINANDOUT;
        public static final DataActivityState DATAOUT;
        public static final DataActivityState DORMANT;
        public static final DataActivityState NONE;

        static  {
            NONE = new DataActivityState("NONE", 0);
            DATAIN = new DataActivityState("DATAIN", 1);
            DATAOUT = new DataActivityState("DATAOUT", 2);
            DATAINANDOUT = new DataActivityState("DATAINANDOUT", 3);
            DORMANT = new DataActivityState("DORMANT", 4);
            DataActivityState adataactivitystate[] = new DataActivityState[5];
            adataactivitystate[0] = NONE;
            adataactivitystate[1] = DATAIN;
            adataactivitystate[2] = DATAOUT;
            adataactivitystate[3] = DATAINANDOUT;
            adataactivitystate[4] = DORMANT;
            $VALUES = adataactivitystate;
        }

        private DataActivityState(String s, int i) {
            super(s, i);
        }
    }

    public static final class DataState extends Enum {

        public static DataState valueOf(String s) {
            return (DataState)Enum.valueOf(com/android/internal/telephony/Phone$DataState, s);
        }

        public static DataState[] values() {
            return (DataState[])$VALUES.clone();
        }

        private static final DataState $VALUES[];
        public static final DataState CONNECTED;
        public static final DataState CONNECTING;
        public static final DataState DISCONNECTED;
        public static final DataState SUSPENDED;

        static  {
            CONNECTED = new DataState("CONNECTED", 0);
            CONNECTING = new DataState("CONNECTING", 1);
            DISCONNECTED = new DataState("DISCONNECTED", 2);
            SUSPENDED = new DataState("SUSPENDED", 3);
            DataState adatastate[] = new DataState[4];
            adatastate[0] = CONNECTED;
            adatastate[1] = CONNECTING;
            adatastate[2] = DISCONNECTED;
            adatastate[3] = SUSPENDED;
            $VALUES = adatastate;
        }

        private DataState(String s, int i) {
            super(s, i);
        }
    }

    public static final class State extends Enum {

        public static State valueOf(String s) {
            return (State)Enum.valueOf(com/android/internal/telephony/Phone$State, s);
        }

        public static State[] values() {
            return (State[])$VALUES.clone();
        }

        private static final State $VALUES[];
        public static final State IDLE;
        public static final State OFFHOOK;
        public static final State RINGING;

        static  {
            IDLE = new State("IDLE", 0);
            RINGING = new State("RINGING", 1);
            OFFHOOK = new State("OFFHOOK", 2);
            State astate[] = new State[3];
            astate[0] = IDLE;
            astate[1] = RINGING;
            astate[2] = OFFHOOK;
            $VALUES = astate;
        }

        private State(String s, int i) {
            super(s, i);
        }
    }


    public abstract void acceptCall() throws CallStateException;

    public abstract void activateCellBroadcastSms(int i, Message message);

    public abstract boolean canConference();

    public abstract boolean canTransfer();

    public abstract void clearDisconnected();

    public abstract void conference() throws CallStateException;

    public abstract Connection dial(String s) throws CallStateException;

    public abstract Connection dial(String s, UUSInfo uusinfo) throws CallStateException;

    public abstract int disableApnType(String s);

    public abstract void disableDnsCheck(boolean flag);

    public abstract void disableLocationUpdates();

    public abstract void dispose();

    public abstract int enableApnType(String s);

    public abstract void enableEnhancedVoicePrivacy(boolean flag, Message message);

    public abstract void enableLocationUpdates();

    public abstract void exitEmergencyCallbackMode();

    public abstract void explicitCallTransfer() throws CallStateException;

    public abstract String getActiveApnHost(String s);

    public abstract String[] getActiveApnTypes();

    public abstract void getAvailableNetworks(Message message);

    public abstract Call getBackgroundCall();

    public abstract boolean getCallForwardingIndicator();

    public abstract void getCallForwardingOption(int i, Message message);

    public abstract void getCallWaiting(Message message);

    public abstract int getCdmaEriIconIndex();

    public abstract int getCdmaEriIconMode();

    public abstract String getCdmaEriText();

    public abstract String getCdmaMin();

    public abstract String getCdmaPrlVersion();

    public abstract void getCellBroadcastSmsConfig(Message message);

    public abstract CellLocation getCellLocation();

    public abstract Context getContext();

    public abstract DataActivityState getDataActivityState();

    public abstract void getDataCallList(Message message);

    public abstract DataState getDataConnectionState();

    public abstract DataState getDataConnectionState(String s);

    public abstract boolean getDataRoamingEnabled();

    public abstract String getDeviceId();

    public abstract String getDeviceSvn();

    public abstract void getEnhancedVoicePrivacy(Message message);

    public abstract String getEsn();

    public abstract Call getForegroundCall();

    public abstract IccCard getIccCard();

    public abstract IccPhoneBookInterfaceManager getIccPhoneBookInterfaceManager();

    public abstract boolean getIccRecordsLoaded();

    public abstract String getIccSerialNumber();

    public abstract IccSmsInterfaceManager getIccSmsInterfaceManager();

    public abstract String getImei();

    public abstract IsimRecords getIsimRecords();

    public abstract String getLine1AlphaTag();

    public abstract String getLine1Number();

    public abstract LinkCapabilities getLinkCapabilities(String s);

    public abstract LinkProperties getLinkProperties(String s);

    public abstract int getLteOnCdmaMode();

    public abstract String getMeid();

    public abstract boolean getMessageWaitingIndicator();

    public abstract String getMsisdn();

    public abstract boolean getMute();

    public abstract void getNeighboringCids(Message message);

    public abstract void getOutgoingCallerIdDisplay(Message message);

    public abstract List getPendingMmiCodes();

    public abstract String getPhoneName();

    public abstract PhoneSubInfo getPhoneSubInfo();

    public abstract int getPhoneType();

    public abstract void getPreferredNetworkType(Message message);

    public abstract Call getRingingCall();

    public abstract ServiceState getServiceState();

    public abstract SignalStrength getSignalStrength();

    public abstract SimulatedRadioControl getSimulatedRadioControl();

    public abstract void getSmscAddress(Message message);

    public abstract State getState();

    public abstract String getSubscriberId();

    public abstract boolean getUnitTestMode();

    public abstract UsimServiceTable getUsimServiceTable();

    public abstract String getVoiceMailAlphaTag();

    public abstract String getVoiceMailNumber();

    public abstract int getVoiceMessageCount();

    public abstract boolean handleInCallMmiCommands(String s) throws CallStateException;

    public abstract boolean handlePinMmi(String s);

    public abstract void invokeOemRilRequestRaw(byte abyte0[], Message message);

    public abstract void invokeOemRilRequestStrings(String as[], Message message);

    public abstract boolean isCspPlmnEnabled();

    public abstract boolean isDataConnectivityPossible();

    public abstract boolean isDataConnectivityPossible(String s);

    public abstract boolean isDnsCheckDisabled();

    public abstract boolean isMinInfoReady();

    public abstract boolean isOtaSpNumber(String s);

    public abstract boolean needsOtaServiceProvisioning();

    public abstract void notifyDataActivity();

    public abstract void queryAvailableBandMode(Message message);

    public abstract void queryCdmaRoamingPreference(Message message);

    public abstract void queryTTYMode(Message message);

    public abstract void registerFoT53ClirlInfo(Handler handler, int i, Object obj);

    public abstract void registerForCallWaiting(Handler handler, int i, Object obj);

    public abstract void registerForCdmaOtaStatusChange(Handler handler, int i, Object obj);

    public abstract void registerForDisconnect(Handler handler, int i, Object obj);

    public abstract void registerForDisplayInfo(Handler handler, int i, Object obj);

    public abstract void registerForEcmTimerReset(Handler handler, int i, Object obj);

    public abstract void registerForInCallVoicePrivacyOff(Handler handler, int i, Object obj);

    public abstract void registerForInCallVoicePrivacyOn(Handler handler, int i, Object obj);

    public abstract void registerForIncomingRing(Handler handler, int i, Object obj);

    public abstract void registerForLineControlInfo(Handler handler, int i, Object obj);

    public abstract void registerForMmiComplete(Handler handler, int i, Object obj);

    public abstract void registerForMmiInitiate(Handler handler, int i, Object obj);

    public abstract void registerForNewRingingConnection(Handler handler, int i, Object obj);

    public abstract void registerForNumberInfo(Handler handler, int i, Object obj);

    public abstract void registerForPreciseCallStateChanged(Handler handler, int i, Object obj);

    public abstract void registerForRedirectedNumberInfo(Handler handler, int i, Object obj);

    public abstract void registerForResendIncallMute(Handler handler, int i, Object obj);

    public abstract void registerForRingbackTone(Handler handler, int i, Object obj);

    public abstract void registerForServiceStateChanged(Handler handler, int i, Object obj);

    public abstract void registerForSignalInfo(Handler handler, int i, Object obj);

    public abstract void registerForSubscriptionInfoReady(Handler handler, int i, Object obj);

    public abstract void registerForSuppServiceFailed(Handler handler, int i, Object obj);

    public abstract void registerForSuppServiceNotification(Handler handler, int i, Object obj);

    public abstract void registerForT53AudioControlInfo(Handler handler, int i, Object obj);

    public abstract void registerForUnknownConnection(Handler handler, int i, Object obj);

    public abstract void rejectCall() throws CallStateException;

    public abstract void removeReferences();

    public abstract void requestIsimAuthentication(String s, Message message);

    public abstract void selectNetworkManually(OperatorInfo operatorinfo, Message message);

    public abstract void sendBurstDtmf(String s, int i, int j, Message message);

    public abstract void sendDtmf(char c);

    public abstract void sendUssdResponse(String s);

    public abstract void setBandMode(int i, Message message);

    public abstract void setCallForwardingOption(int i, int j, String s, int k, Message message);

    public abstract void setCallWaiting(boolean flag, Message message);

    public abstract void setCdmaRoamingPreference(int i, Message message);

    public abstract void setCdmaSubscription(int i, Message message);

    public abstract void setCellBroadcastSmsConfig(int ai[], Message message);

    public abstract void setDataRoamingEnabled(boolean flag);

    public abstract void setEchoSuppressionEnabled(boolean flag);

    public abstract void setLine1Number(String s, String s1, Message message);

    public abstract void setMute(boolean flag);

    public abstract void setNetworkSelectionModeAutomatic(Message message);

    public abstract void setOnEcbModeExitResponse(Handler handler, int i, Object obj);

    public abstract void setOnPostDialCharacter(Handler handler, int i, Object obj);

    public abstract void setOutgoingCallerIdDisplay(int i, Message message);

    public abstract void setPreferredNetworkType(int i, Message message);

    public abstract void setRadioPower(boolean flag);

    public abstract void setSmscAddress(String s, Message message);

    public abstract void setTTYMode(int i, Message message);

    public abstract void setUnitTestMode(boolean flag);

    public abstract void setVoiceMailNumber(String s, String s1, Message message);

    public abstract void setVoiceMessageWaiting(int i, int j);

    public abstract void startDtmf(char c);

    public abstract void stopDtmf();

    public abstract void switchHoldingAndActive() throws CallStateException;

    public abstract void unregisterForCallWaiting(Handler handler);

    public abstract void unregisterForCdmaOtaStatusChange(Handler handler);

    public abstract void unregisterForDisconnect(Handler handler);

    public abstract void unregisterForDisplayInfo(Handler handler);

    public abstract void unregisterForEcmTimerReset(Handler handler);

    public abstract void unregisterForInCallVoicePrivacyOff(Handler handler);

    public abstract void unregisterForInCallVoicePrivacyOn(Handler handler);

    public abstract void unregisterForIncomingRing(Handler handler);

    public abstract void unregisterForLineControlInfo(Handler handler);

    public abstract void unregisterForMmiComplete(Handler handler);

    public abstract void unregisterForMmiInitiate(Handler handler);

    public abstract void unregisterForNewRingingConnection(Handler handler);

    public abstract void unregisterForNumberInfo(Handler handler);

    public abstract void unregisterForPreciseCallStateChanged(Handler handler);

    public abstract void unregisterForRedirectedNumberInfo(Handler handler);

    public abstract void unregisterForResendIncallMute(Handler handler);

    public abstract void unregisterForRingbackTone(Handler handler);

    public abstract void unregisterForServiceStateChanged(Handler handler);

    public abstract void unregisterForSignalInfo(Handler handler);

    public abstract void unregisterForSubscriptionInfoReady(Handler handler);

    public abstract void unregisterForSuppServiceFailed(Handler handler);

    public abstract void unregisterForSuppServiceNotification(Handler handler);

    public abstract void unregisterForT53AudioControlInfo(Handler handler);

    public abstract void unregisterForT53ClirInfo(Handler handler);

    public abstract void unregisterForUnknownConnection(Handler handler);

    public abstract void unsetOnEcbModeExitResponse(Handler handler);

    public abstract void updateServiceLocation();

    public static final int APN_ALREADY_ACTIVE = 0;
    public static final int APN_ALREADY_INACTIVE = 4;
    public static final int APN_REQUEST_FAILED = 3;
    public static final int APN_REQUEST_STARTED = 1;
    public static final String APN_TYPE_ALL = "*";
    public static final String APN_TYPE_CBS = "cbs";
    public static final String APN_TYPE_DEFAULT = "default";
    public static final String APN_TYPE_DUN = "dun";
    public static final String APN_TYPE_FOTA = "fota";
    public static final String APN_TYPE_HIPRI = "hipri";
    public static final String APN_TYPE_IMS = "ims";
    public static final String APN_TYPE_MMS = "mms";
    public static final int APN_TYPE_NOT_AVAILABLE = 2;
    public static final String APN_TYPE_SUPL = "supl";
    public static final int BM_AUS2_BAND = 5;
    public static final int BM_AUS_BAND = 4;
    public static final int BM_BOUNDARY = 6;
    public static final int BM_EURO_BAND = 1;
    public static final int BM_JPN_BAND = 3;
    public static final int BM_UNSPECIFIED = 0;
    public static final int BM_US_BAND = 2;
    public static final int CDMA_OTA_PROVISION_STATUS_A_KEY_EXCHANGED = 2;
    public static final int CDMA_OTA_PROVISION_STATUS_COMMITTED = 8;
    public static final int CDMA_OTA_PROVISION_STATUS_IMSI_DOWNLOADED = 6;
    public static final int CDMA_OTA_PROVISION_STATUS_MDN_DOWNLOADED = 5;
    public static final int CDMA_OTA_PROVISION_STATUS_NAM_DOWNLOADED = 4;
    public static final int CDMA_OTA_PROVISION_STATUS_OTAPA_ABORTED = 11;
    public static final int CDMA_OTA_PROVISION_STATUS_OTAPA_STARTED = 9;
    public static final int CDMA_OTA_PROVISION_STATUS_OTAPA_STOPPED = 10;
    public static final int CDMA_OTA_PROVISION_STATUS_PRL_DOWNLOADED = 7;
    public static final int CDMA_OTA_PROVISION_STATUS_SPC_RETRIES_EXCEEDED = 1;
    public static final int CDMA_OTA_PROVISION_STATUS_SPL_UNLOCKED = 0;
    public static final int CDMA_OTA_PROVISION_STATUS_SSD_UPDATED = 3;
    public static final int CDMA_RM_AFFILIATED = 1;
    public static final int CDMA_RM_ANY = 2;
    public static final int CDMA_RM_HOME = 0;
    public static final int CDMA_SUBSCRIPTION_NV = 1;
    public static final int CDMA_SUBSCRIPTION_RUIM_SIM = 0;
    public static final String DATA_APN_KEY = "apn";
    public static final String DATA_APN_TYPE_KEY = "apnType";
    public static final String DATA_IFACE_NAME_KEY = "iface";
    public static final String DATA_LINK_CAPABILITIES_KEY = "linkCapabilities";
    public static final String DATA_LINK_PROPERTIES_KEY = "linkProperties";
    public static final String DATA_NETWORK_ROAMING_KEY = "networkRoaming";
    public static final boolean DEBUG_PHONE = true;
    public static final String FAILURE_REASON_KEY = "reason";
    public static final String FEATURE_ENABLE_CBS = "enableCBS";
    public static final String FEATURE_ENABLE_DUN = "enableDUN";
    public static final String FEATURE_ENABLE_DUN_ALWAYS = "enableDUNAlways";
    public static final String FEATURE_ENABLE_FOTA = "enableFOTA";
    public static final String FEATURE_ENABLE_HIPRI = "enableHIPRI";
    public static final String FEATURE_ENABLE_IMS = "enableIMS";
    public static final String FEATURE_ENABLE_MMS = "enableMMS";
    public static final String FEATURE_ENABLE_SUPL = "enableSUPL";
    public static final int LTE_ON_CDMA_FALSE = 0;
    public static final int LTE_ON_CDMA_TRUE = 1;
    public static final int LTE_ON_CDMA_UNKNOWN = -1;
    public static final String NETWORK_UNAVAILABLE_KEY = "networkUnvailable";
    public static final int NT_MODE_CDMA = 4;
    public static final int NT_MODE_CDMA_NO_EVDO = 5;
    public static final int NT_MODE_EVDO_NO_CDMA = 6;
    public static final int NT_MODE_GLOBAL = 7;
    public static final int NT_MODE_GSM_ONLY = 1;
    public static final int NT_MODE_GSM_UMTS = 3;
    public static final int NT_MODE_LTE_ONLY = 11;
    public static final int NT_MODE_WCDMA_ONLY = 2;
    public static final int NT_MODE_WCDMA_PREF = 0;
    public static final String PHONE_IN_ECM_STATE = "phoneinECMState";
    public static final String PHONE_NAME_KEY = "phoneName";
    public static final int PHONE_TYPE_CDMA = 2;
    public static final int PHONE_TYPE_GSM = 1;
    public static final int PHONE_TYPE_NONE = 0;
    public static final int PHONE_TYPE_SIP = 3;
    public static final int PREFERRED_CDMA_SUBSCRIPTION = 1;
    public static final int PREFERRED_NT_MODE = 0;
    public static final String REASON_APN_CHANGED = "apnChanged";
    public static final String REASON_APN_FAILED = "apnFailed";
    public static final String REASON_APN_SWITCHED = "apnSwitched";
    public static final String REASON_CDMA_DATA_ATTACHED = "cdmaDataAttached";
    public static final String REASON_CDMA_DATA_DETACHED = "cdmaDataDetached";
    public static final String REASON_DATA_ATTACHED = "dataAttached";
    public static final String REASON_DATA_DEPENDENCY_MET = "dependencyMet";
    public static final String REASON_DATA_DEPENDENCY_UNMET = "dependencyUnmet";
    public static final String REASON_DATA_DETACHED = "dataDetached";
    public static final String REASON_DATA_DISABLED = "dataDisabled";
    public static final String REASON_DATA_ENABLED = "dataEnabled";
    public static final String REASON_LINK_PROPERTIES_CHANGED = "linkPropertiesChanged";
    public static final String REASON_NW_TYPE_CHANGED = "nwTypeChanged";
    public static final String REASON_PDP_RESET = "pdpReset";
    public static final String REASON_PS_RESTRICT_DISABLED = "psRestrictDisabled";
    public static final String REASON_PS_RESTRICT_ENABLED = "psRestrictEnabled";
    public static final String REASON_RADIO_TURNED_OFF = "radioTurnedOff";
    public static final String REASON_RESTORE_DEFAULT_APN = "restoreDefaultApn";
    public static final String REASON_ROAMING_OFF = "roamingOff";
    public static final String REASON_ROAMING_ON = "roamingOn";
    public static final String REASON_SIM_LOADED = "simLoaded";
    public static final String REASON_VOICE_CALL_ENDED = "2GVoiceCallEnded";
    public static final String REASON_VOICE_CALL_STARTED = "2GVoiceCallStarted";
    public static final String STATE_CHANGE_REASON_KEY = "reason";
    public static final String STATE_KEY = "state";
    public static final int TTY_MODE_FULL = 1;
    public static final int TTY_MODE_HCO = 2;
    public static final int TTY_MODE_OFF = 0;
    public static final int TTY_MODE_VCO = 3;
}
