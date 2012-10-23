// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.sip;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.android.internal.telephony.*;
import com.android.internal.telephony.gsm.SmsBroadcastConfigInfo;

class SipCommandInterface extends BaseCommands
    implements CommandsInterface {

    SipCommandInterface(Context context) {
        super(context);
    }

    public void acceptCall(Message message) {
    }

    public void acknowledgeIncomingGsmSmsWithPdu(boolean flag, String s, Message message) {
    }

    public void acknowledgeLastIncomingCdmaSms(boolean flag, int i, Message message) {
    }

    public void acknowledgeLastIncomingGsmSms(boolean flag, int i, Message message) {
    }

    public void cancelPendingUssd(Message message) {
    }

    public void changeBarringPassword(String s, String s1, String s2, Message message) {
    }

    public void changeIccPin(String s, String s1, Message message) {
    }

    public void changeIccPin2(String s, String s1, Message message) {
    }

    public void changeIccPin2ForApp(String s, String s1, String s2, Message message) {
    }

    public void changeIccPinForApp(String s, String s1, String s2, Message message) {
    }

    public void conference(Message message) {
    }

    public void deactivateDataCall(int i, int j, Message message) {
    }

    public void deleteSmsOnRuim(int i, Message message) {
    }

    public void deleteSmsOnSim(int i, Message message) {
    }

    public void dial(String s, int i, Message message) {
    }

    public void dial(String s, int i, UUSInfo uusinfo, Message message) {
    }

    public void exitEmergencyCallbackMode(Message message) {
    }

    public void explicitCallTransfer(Message message) {
    }

    public void getAvailableNetworks(Message message) {
    }

    public void getBasebandVersion(Message message) {
    }

    public void getCDMASubscription(Message message) {
    }

    public void getCLIR(Message message) {
    }

    public void getCdmaBroadcastConfig(Message message) {
    }

    public void getCdmaSubscriptionSource(Message message) {
    }

    public void getCurrentCalls(Message message) {
    }

    public void getDataCallList(Message message) {
    }

    public void getDataRegistrationState(Message message) {
    }

    public void getDeviceIdentity(Message message) {
    }

    public void getGsmBroadcastConfig(Message message) {
    }

    public void getIMEI(Message message) {
    }

    public void getIMEISV(Message message) {
    }

    public void getIMSI(Message message) {
    }

    public void getIMSIForApp(String s, Message message) {
    }

    public void getIccCardStatus(Message message) {
    }

    public void getLastCallFailCause(Message message) {
    }

    public void getLastDataCallFailCause(Message message) {
    }

    public void getLastPdpFailCause(Message message) {
    }

    public void getMute(Message message) {
    }

    public void getNeighboringCids(Message message) {
    }

    public void getNetworkSelectionMode(Message message) {
    }

    public void getOperator(Message message) {
    }

    public void getPDPContextList(Message message) {
    }

    public void getPreferredNetworkType(Message message) {
    }

    public void getPreferredVoicePrivacy(Message message) {
    }

    public void getSignalStrength(Message message) {
    }

    public void getSmscAddress(Message message) {
    }

    public void getVoiceRadioTechnology(Message message) {
    }

    public void getVoiceRegistrationState(Message message) {
    }

    public void handleCallSetupRequestFromSim(boolean flag, Message message) {
    }

    public void hangupConnection(int i, Message message) {
    }

    public void hangupForegroundResumeBackground(Message message) {
    }

    public void hangupWaitingOrBackground(Message message) {
    }

    public void iccIO(int i, int j, String s, int k, int l, int i1, String s1, 
            String s2, Message message) {
    }

    public void iccIOForApp(int i, int j, String s, int k, int l, int i1, String s1, 
            String s2, String s3, Message message) {
    }

    public void invokeOemRilRequestRaw(byte abyte0[], Message message) {
    }

    public void invokeOemRilRequestStrings(String as[], Message message) {
    }

    public void queryAvailableBandMode(Message message) {
    }

    public void queryCLIP(Message message) {
    }

    public void queryCallForwardStatus(int i, int j, String s, Message message) {
    }

    public void queryCallWaiting(int i, Message message) {
    }

    public void queryCdmaRoamingPreference(Message message) {
    }

    public void queryFacilityLock(String s, String s1, int i, Message message) {
    }

    public void queryFacilityLockForApp(String s, String s1, int i, String s2, Message message) {
    }

    public void queryTTYMode(Message message) {
    }

    public void rejectCall(Message message) {
    }

    public void reportSmsMemoryStatus(boolean flag, Message message) {
    }

    public void reportStkServiceIsRunning(Message message) {
    }

    public void requestIsimAuthentication(String s, Message message) {
    }

    public void resetRadio(Message message) {
    }

    public void sendBurstDtmf(String s, int i, int j, Message message) {
    }

    public void sendCDMAFeatureCode(String s, Message message) {
    }

    public void sendCdmaSms(byte abyte0[], Message message) {
    }

    public void sendDtmf(char c, Message message) {
    }

    public void sendEnvelope(String s, Message message) {
    }

    public void sendEnvelopeWithStatus(String s, Message message) {
    }

    public void sendSMS(String s, String s1, Message message) {
    }

    public void sendTerminalResponse(String s, Message message) {
    }

    public void sendUSSD(String s, Message message) {
    }

    public void separateConnection(int i, Message message) {
    }

    public void setBandMode(int i, Message message) {
    }

    public void setCLIR(int i, Message message) {
    }

    public void setCallForward(int i, int j, int k, String s, int l, Message message) {
    }

    public void setCallWaiting(boolean flag, int i, Message message) {
    }

    public void setCdmaBroadcastActivation(boolean flag, Message message) {
    }

    public void setCdmaBroadcastConfig(int ai[], Message message) {
    }

    public void setCdmaRoamingPreference(int i, Message message) {
    }

    public void setCdmaSubscriptionSource(int i, Message message) {
    }

    public void setFacilityLock(String s, boolean flag, String s1, int i, Message message) {
    }

    public void setFacilityLockForApp(String s, boolean flag, String s1, int i, String s2, Message message) {
    }

    public void setGsmBroadcastActivation(boolean flag, Message message) {
    }

    public void setGsmBroadcastConfig(SmsBroadcastConfigInfo asmsbroadcastconfiginfo[], Message message) {
    }

    public void setLocationUpdates(boolean flag, Message message) {
    }

    public void setMute(boolean flag, Message message) {
    }

    public void setNetworkSelectionModeAutomatic(Message message) {
    }

    public void setNetworkSelectionModeManual(String s, Message message) {
    }

    public void setOnNITZTime(Handler handler, int i, Object obj) {
    }

    public void setPhoneType(int i) {
    }

    public void setPreferredNetworkType(int i, Message message) {
    }

    public void setPreferredVoicePrivacy(boolean flag, Message message) {
    }

    public void setRadioPower(boolean flag, Message message) {
    }

    public void setSmscAddress(String s, Message message) {
    }

    public void setSuppServiceNotifications(boolean flag, Message message) {
    }

    public void setTTYMode(int i, Message message) {
    }

    public void setupDataCall(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            Message message) {
    }

    public void startDtmf(char c, Message message) {
    }

    public void stopDtmf(Message message) {
    }

    public void supplyIccPin(String s, Message message) {
    }

    public void supplyIccPin2(String s, Message message) {
    }

    public void supplyIccPin2ForApp(String s, String s1, Message message) {
    }

    public void supplyIccPinForApp(String s, String s1, Message message) {
    }

    public void supplyIccPuk(String s, String s1, Message message) {
    }

    public void supplyIccPuk2(String s, String s1, Message message) {
    }

    public void supplyIccPuk2ForApp(String s, String s1, String s2, Message message) {
    }

    public void supplyIccPukForApp(String s, String s1, String s2, Message message) {
    }

    public void supplyNetworkDepersonalization(String s, Message message) {
    }

    public void switchWaitingOrHoldingAndActive(Message message) {
    }

    public void writeSmsToRuim(int i, String s, Message message) {
    }

    public void writeSmsToSim(int i, String s, String s1, Message message) {
    }
}
