// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.app.ActivityManagerNative;
import android.content.Context;
import android.content.Intent;
import android.net.LinkCapabilities;
import android.net.LinkProperties;
import android.os.*;
import android.telephony.*;
import android.util.Log;
import com.android.internal.telephony.gsm.UsimServiceTable;
import com.android.internal.telephony.ims.IsimRecords;
import com.android.internal.telephony.test.SimulatedRadioControl;
import java.util.List;

// Referenced classes of package com.android.internal.telephony:
//            Phone, IccSmsInterfaceManagerProxy, IccPhoneBookInterfaceManagerProxy, PhoneSubInfoProxy, 
//            PhoneBase, CommandsInterface, CallManager, PhoneFactory, 
//            CallStateException, Connection, UUSInfo, Call, 
//            IccCard, IccPhoneBookInterfaceManager, IccSmsInterfaceManager, PhoneSubInfo, 
//            OperatorInfo

public class PhoneProxy extends Handler
    implements Phone {

    public PhoneProxy(Phone phone) {
        mResetModemOnRadioTechnologyChange = false;
        mActivePhone = phone;
        mResetModemOnRadioTechnologyChange = SystemProperties.getBoolean("persist.radio.reset_on_switch", false);
        mIccSmsInterfaceManagerProxy = new IccSmsInterfaceManagerProxy(phone.getIccSmsInterfaceManager());
        mIccPhoneBookInterfaceManagerProxy = new IccPhoneBookInterfaceManagerProxy(phone.getIccPhoneBookInterfaceManager());
        mPhoneSubInfoProxy = new PhoneSubInfoProxy(phone.getPhoneSubInfo());
        mCommandsInterface = ((PhoneBase)mActivePhone).mCM;
        mCommandsInterface.registerForRilConnected(this, 4, null);
        mCommandsInterface.registerForOn(this, 2, null);
        mCommandsInterface.registerForVoiceRadioTechChanged(this, 1, null);
    }

    private void deleteAndCreatePhone(int i) {
        String s = "Unknown";
        Phone phone = mActivePhone;
        if(phone != null)
            s = ((PhoneBase)phone).getPhoneName();
        StringBuilder stringbuilder = (new StringBuilder()).append("Switching Voice Phone : ").append(s).append(" >>> ");
        String s1;
        if(ServiceState.isGsm(i))
            s1 = "GSM";
        else
            s1 = "CDMA";
        logd(stringbuilder.append(s1).toString());
        if(phone != null) {
            CallManager.getInstance().unregisterPhone(phone);
            logd("Disposing old phone..");
            phone.dispose();
        }
        if(!ServiceState.isCdma(i)) goto _L2; else goto _L1
_L1:
        mActivePhone = PhoneFactory.getCdmaPhone();
_L4:
        if(phone != null)
            phone.removeReferences();
        if(mActivePhone != null)
            CallManager.getInstance().registerPhone(mActivePhone);
        return;
_L2:
        if(ServiceState.isGsm(i))
            mActivePhone = PhoneFactory.getGsmPhone();
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static void logd(String s) {
        Log.d("PHONE", (new StringBuilder()).append("[PhoneProxy] ").append(s).toString());
    }

    private void loge(String s) {
        Log.e("PHONE", (new StringBuilder()).append("[PhoneProxy] ").append(s).toString());
    }

    private void logw(String s) {
        Log.w("PHONE", (new StringBuilder()).append("[PhoneProxy] ").append(s).toString());
    }

    private void updatePhoneObject(int i) {
        if(mActivePhone == null) goto _L2; else goto _L1
_L1:
        if(mRilVersion != 6 || getLteOnCdmaMode() != 1) goto _L4; else goto _L3
_L3:
        if(mActivePhone.getPhoneType() != 2) goto _L6; else goto _L5
_L5:
        logd((new StringBuilder()).append("LTE ON CDMA property is set. Use CDMA Phone newVoiceRadioTech = ").append(i).append(" Active Phone = ").append(mActivePhone.getPhoneName()).toString());
_L9:
        return;
_L6:
        logd((new StringBuilder()).append("LTE ON CDMA property is set. Switch to CDMALTEPhone newVoiceRadioTech = ").append(i).append(" Active Phone = ").append(mActivePhone.getPhoneName()).toString());
        i = 6;
_L2:
        if(i == 0) {
            logd((new StringBuilder()).append("Ignoring voice radio technology changed message. newVoiceRadioTech = Unknown. Active Phone = ").append(mActivePhone.getPhoneName()).toString());
        } else {
            boolean flag = false;
            if(mResetModemOnRadioTechnologyChange && mCommandsInterface.getRadioState().isOn()) {
                flag = true;
                logd("Setting Radio Power to Off");
                mCommandsInterface.setRadioPower(false, null);
            }
            deleteAndCreatePhone(i);
            if(mResetModemOnRadioTechnologyChange && flag) {
                logd("Resetting Radio");
                mCommandsInterface.setRadioPower(flag, null);
            }
            mIccSmsInterfaceManagerProxy.setmIccSmsInterfaceManager(mActivePhone.getIccSmsInterfaceManager());
            mIccPhoneBookInterfaceManagerProxy.setmIccPhoneBookInterfaceManager(mActivePhone.getIccPhoneBookInterfaceManager());
            mPhoneSubInfoProxy.setmPhoneSubInfo(mActivePhone.getPhoneSubInfo());
            mCommandsInterface = ((PhoneBase)mActivePhone).mCM;
            Intent intent = new Intent("android.intent.action.RADIO_TECHNOLOGY");
            intent.addFlags(0x20000000);
            intent.putExtra("phoneName", mActivePhone.getPhoneName());
            ActivityManagerNative.broadcastStickyIntent(intent, null);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if((!ServiceState.isCdma(i) || mActivePhone.getPhoneType() != 2) && (!ServiceState.isGsm(i) || mActivePhone.getPhoneType() != 1)) goto _L2; else goto _L7
_L7:
        logd((new StringBuilder()).append("Ignoring voice radio technology changed message. newVoiceRadioTech = ").append(i).append(" Active Phone = ").append(mActivePhone.getPhoneName()).toString());
        if(true) goto _L9; else goto _L8
_L8:
    }

    public void acceptCall() throws CallStateException {
        mActivePhone.acceptCall();
    }

    public void activateCellBroadcastSms(int i, Message message) {
        mActivePhone.activateCellBroadcastSms(i, message);
    }

    public boolean canConference() {
        return mActivePhone.canConference();
    }

    public boolean canTransfer() {
        return mActivePhone.canTransfer();
    }

    public void clearDisconnected() {
        mActivePhone.clearDisconnected();
    }

    public void conference() throws CallStateException {
        mActivePhone.conference();
    }

    public Connection dial(String s) throws CallStateException {
        return mActivePhone.dial(s);
    }

    public Connection dial(String s, UUSInfo uusinfo) throws CallStateException {
        return mActivePhone.dial(s, uusinfo);
    }

    public int disableApnType(String s) {
        return mActivePhone.disableApnType(s);
    }

    public void disableDnsCheck(boolean flag) {
        mActivePhone.disableDnsCheck(flag);
    }

    public void disableLocationUpdates() {
        mActivePhone.disableLocationUpdates();
    }

    public void dispose() {
        mCommandsInterface.unregisterForOn(this);
        mCommandsInterface.unregisterForVoiceRadioTechChanged(this);
        mCommandsInterface.unregisterForRilConnected(this);
    }

    public int enableApnType(String s) {
        return mActivePhone.enableApnType(s);
    }

    public void enableEnhancedVoicePrivacy(boolean flag, Message message) {
        mActivePhone.enableEnhancedVoicePrivacy(flag, message);
    }

    public void enableLocationUpdates() {
        mActivePhone.enableLocationUpdates();
    }

    public void exitEmergencyCallbackMode() {
        mActivePhone.exitEmergencyCallbackMode();
    }

    public void explicitCallTransfer() throws CallStateException {
        mActivePhone.explicitCallTransfer();
    }

    public String getActiveApnHost(String s) {
        return mActivePhone.getActiveApnHost(s);
    }

    public String[] getActiveApnTypes() {
        return mActivePhone.getActiveApnTypes();
    }

    public Phone getActivePhone() {
        return mActivePhone;
    }

    public void getAvailableNetworks(Message message) {
        mActivePhone.getAvailableNetworks(message);
    }

    public Call getBackgroundCall() {
        return mActivePhone.getBackgroundCall();
    }

    public boolean getCallForwardingIndicator() {
        return mActivePhone.getCallForwardingIndicator();
    }

    public void getCallForwardingOption(int i, Message message) {
        mActivePhone.getCallForwardingOption(i, message);
    }

    public void getCallWaiting(Message message) {
        mActivePhone.getCallWaiting(message);
    }

    public int getCdmaEriIconIndex() {
        return mActivePhone.getCdmaEriIconIndex();
    }

    public int getCdmaEriIconMode() {
        return mActivePhone.getCdmaEriIconMode();
    }

    public String getCdmaEriText() {
        return mActivePhone.getCdmaEriText();
    }

    public String getCdmaMin() {
        return mActivePhone.getCdmaMin();
    }

    public String getCdmaPrlVersion() {
        return mActivePhone.getCdmaPrlVersion();
    }

    public void getCellBroadcastSmsConfig(Message message) {
        mActivePhone.getCellBroadcastSmsConfig(message);
    }

    public CellLocation getCellLocation() {
        return mActivePhone.getCellLocation();
    }

    public Context getContext() {
        return mActivePhone.getContext();
    }

    public Phone.DataActivityState getDataActivityState() {
        return mActivePhone.getDataActivityState();
    }

    public void getDataCallList(Message message) {
        mActivePhone.getDataCallList(message);
    }

    public Phone.DataState getDataConnectionState() {
        return mActivePhone.getDataConnectionState("default");
    }

    public Phone.DataState getDataConnectionState(String s) {
        return mActivePhone.getDataConnectionState(s);
    }

    public boolean getDataRoamingEnabled() {
        return mActivePhone.getDataRoamingEnabled();
    }

    public String getDeviceId() {
        return mActivePhone.getDeviceId();
    }

    public String getDeviceSvn() {
        return mActivePhone.getDeviceSvn();
    }

    public void getEnhancedVoicePrivacy(Message message) {
        mActivePhone.getEnhancedVoicePrivacy(message);
    }

    public String getEsn() {
        return mActivePhone.getEsn();
    }

    public Call getForegroundCall() {
        return mActivePhone.getForegroundCall();
    }

    public IccCard getIccCard() {
        return mActivePhone.getIccCard();
    }

    public IccPhoneBookInterfaceManager getIccPhoneBookInterfaceManager() {
        return mActivePhone.getIccPhoneBookInterfaceManager();
    }

    public boolean getIccRecordsLoaded() {
        return mActivePhone.getIccRecordsLoaded();
    }

    public String getIccSerialNumber() {
        return mActivePhone.getIccSerialNumber();
    }

    public IccSmsInterfaceManager getIccSmsInterfaceManager() {
        return mActivePhone.getIccSmsInterfaceManager();
    }

    public String getImei() {
        return mActivePhone.getImei();
    }

    public IsimRecords getIsimRecords() {
        return mActivePhone.getIsimRecords();
    }

    public String getLine1AlphaTag() {
        return mActivePhone.getLine1AlphaTag();
    }

    public String getLine1Number() {
        return mActivePhone.getLine1Number();
    }

    public LinkCapabilities getLinkCapabilities(String s) {
        return mActivePhone.getLinkCapabilities(s);
    }

    public LinkProperties getLinkProperties(String s) {
        return mActivePhone.getLinkProperties(s);
    }

    public int getLteOnCdmaMode() {
        return mActivePhone.getLteOnCdmaMode();
    }

    public String getMeid() {
        return mActivePhone.getMeid();
    }

    public boolean getMessageWaitingIndicator() {
        return mActivePhone.getMessageWaitingIndicator();
    }

    public String getMsisdn() {
        return mActivePhone.getMsisdn();
    }

    public boolean getMute() {
        return mActivePhone.getMute();
    }

    public void getNeighboringCids(Message message) {
        mActivePhone.getNeighboringCids(message);
    }

    public void getOutgoingCallerIdDisplay(Message message) {
        mActivePhone.getOutgoingCallerIdDisplay(message);
    }

    public List getPendingMmiCodes() {
        return mActivePhone.getPendingMmiCodes();
    }

    public String getPhoneName() {
        return mActivePhone.getPhoneName();
    }

    public PhoneSubInfo getPhoneSubInfo() {
        return mActivePhone.getPhoneSubInfo();
    }

    public int getPhoneType() {
        return mActivePhone.getPhoneType();
    }

    public void getPreferredNetworkType(Message message) {
        mActivePhone.getPreferredNetworkType(message);
    }

    public Call getRingingCall() {
        return mActivePhone.getRingingCall();
    }

    public ServiceState getServiceState() {
        return mActivePhone.getServiceState();
    }

    public SignalStrength getSignalStrength() {
        return mActivePhone.getSignalStrength();
    }

    public SimulatedRadioControl getSimulatedRadioControl() {
        return mActivePhone.getSimulatedRadioControl();
    }

    public void getSmscAddress(Message message) {
        mActivePhone.getSmscAddress(message);
    }

    public Phone.State getState() {
        return mActivePhone.getState();
    }

    public String getSubscriberId() {
        return mActivePhone.getSubscriberId();
    }

    public boolean getUnitTestMode() {
        return mActivePhone.getUnitTestMode();
    }

    public UsimServiceTable getUsimServiceTable() {
        return mActivePhone.getUsimServiceTable();
    }

    public String getVoiceMailAlphaTag() {
        return mActivePhone.getVoiceMailAlphaTag();
    }

    public String getVoiceMailNumber() {
        return mActivePhone.getVoiceMailNumber();
    }

    public int getVoiceMessageCount() {
        return mActivePhone.getVoiceMessageCount();
    }

    public boolean handleInCallMmiCommands(String s) throws CallStateException {
        return mActivePhone.handleInCallMmiCommands(s);
    }

    public void handleMessage(Message message) {
        AsyncResult asyncresult = (AsyncResult)message.obj;
        message.what;
        JVM INSTR tableswitch 1 4: default 44
    //                   1 140
    //                   2 77
    //                   3 140
    //                   4 94;
           goto _L1 _L2 _L3 _L2 _L4
_L1:
        loge((new StringBuilder()).append("Error! This handler was not registered for this message type. Message: ").append(message.what).toString());
_L6:
        super.handleMessage(message);
        return;
_L3:
        mCommandsInterface.getVoiceRadioTechnology(obtainMessage(3));
        continue; /* Loop/switch isn't completed */
_L4:
        if(asyncresult.exception == null && asyncresult.result != null) {
            mRilVersion = ((Integer)asyncresult.result).intValue();
        } else {
            logd("Unexpected exception on EVENT_RIL_CONNECTED");
            mRilVersion = -1;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if(asyncresult.exception == null) {
            if(asyncresult.result != null && ((int[])(int[])asyncresult.result).length != 0)
                updatePhoneObject(((int[])(int[])asyncresult.result)[0]);
            else
                loge((new StringBuilder()).append("Voice Radio Technology event ").append(message.what).append(" has no tech!").toString());
        } else {
            loge((new StringBuilder()).append("Voice Radio Technology event ").append(message.what).append(" exception!").append(asyncresult.exception).toString());
        }
        if(true) goto _L6; else goto _L5
_L5:
    }

    public boolean handlePinMmi(String s) {
        return mActivePhone.handlePinMmi(s);
    }

    public void invokeOemRilRequestRaw(byte abyte0[], Message message) {
        mActivePhone.invokeOemRilRequestRaw(abyte0, message);
    }

    public void invokeOemRilRequestStrings(String as[], Message message) {
        mActivePhone.invokeOemRilRequestStrings(as, message);
    }

    public boolean isCspPlmnEnabled() {
        return mActivePhone.isCspPlmnEnabled();
    }

    public boolean isDataConnectivityPossible() {
        return mActivePhone.isDataConnectivityPossible("default");
    }

    public boolean isDataConnectivityPossible(String s) {
        return mActivePhone.isDataConnectivityPossible(s);
    }

    public boolean isDnsCheckDisabled() {
        return mActivePhone.isDnsCheckDisabled();
    }

    public boolean isMinInfoReady() {
        return mActivePhone.isMinInfoReady();
    }

    public boolean isOtaSpNumber(String s) {
        return mActivePhone.isOtaSpNumber(s);
    }

    public boolean needsOtaServiceProvisioning() {
        return mActivePhone.needsOtaServiceProvisioning();
    }

    public void notifyDataActivity() {
        mActivePhone.notifyDataActivity();
    }

    public void queryAvailableBandMode(Message message) {
        mActivePhone.queryAvailableBandMode(message);
    }

    public void queryCdmaRoamingPreference(Message message) {
        mActivePhone.queryCdmaRoamingPreference(message);
    }

    public void queryTTYMode(Message message) {
        mActivePhone.queryTTYMode(message);
    }

    public void registerFoT53ClirlInfo(Handler handler, int i, Object obj) {
        mActivePhone.registerFoT53ClirlInfo(handler, i, obj);
    }

    public void registerForCallWaiting(Handler handler, int i, Object obj) {
        mActivePhone.registerForCallWaiting(handler, i, obj);
    }

    public void registerForCdmaOtaStatusChange(Handler handler, int i, Object obj) {
        mActivePhone.registerForCdmaOtaStatusChange(handler, i, obj);
    }

    public void registerForDisconnect(Handler handler, int i, Object obj) {
        mActivePhone.registerForDisconnect(handler, i, obj);
    }

    public void registerForDisplayInfo(Handler handler, int i, Object obj) {
        mActivePhone.registerForDisplayInfo(handler, i, obj);
    }

    public void registerForEcmTimerReset(Handler handler, int i, Object obj) {
        mActivePhone.registerForEcmTimerReset(handler, i, obj);
    }

    public void registerForInCallVoicePrivacyOff(Handler handler, int i, Object obj) {
        mActivePhone.registerForInCallVoicePrivacyOff(handler, i, obj);
    }

    public void registerForInCallVoicePrivacyOn(Handler handler, int i, Object obj) {
        mActivePhone.registerForInCallVoicePrivacyOn(handler, i, obj);
    }

    public void registerForIncomingRing(Handler handler, int i, Object obj) {
        mActivePhone.registerForIncomingRing(handler, i, obj);
    }

    public void registerForLineControlInfo(Handler handler, int i, Object obj) {
        mActivePhone.registerForLineControlInfo(handler, i, obj);
    }

    public void registerForMmiComplete(Handler handler, int i, Object obj) {
        mActivePhone.registerForMmiComplete(handler, i, obj);
    }

    public void registerForMmiInitiate(Handler handler, int i, Object obj) {
        mActivePhone.registerForMmiInitiate(handler, i, obj);
    }

    public void registerForNewRingingConnection(Handler handler, int i, Object obj) {
        mActivePhone.registerForNewRingingConnection(handler, i, obj);
    }

    public void registerForNumberInfo(Handler handler, int i, Object obj) {
        mActivePhone.registerForNumberInfo(handler, i, obj);
    }

    public void registerForPreciseCallStateChanged(Handler handler, int i, Object obj) {
        mActivePhone.registerForPreciseCallStateChanged(handler, i, obj);
    }

    public void registerForRedirectedNumberInfo(Handler handler, int i, Object obj) {
        mActivePhone.registerForRedirectedNumberInfo(handler, i, obj);
    }

    public void registerForResendIncallMute(Handler handler, int i, Object obj) {
        mActivePhone.registerForResendIncallMute(handler, i, obj);
    }

    public void registerForRingbackTone(Handler handler, int i, Object obj) {
        mActivePhone.registerForRingbackTone(handler, i, obj);
    }

    public void registerForServiceStateChanged(Handler handler, int i, Object obj) {
        mActivePhone.registerForServiceStateChanged(handler, i, obj);
    }

    public void registerForSignalInfo(Handler handler, int i, Object obj) {
        mActivePhone.registerForSignalInfo(handler, i, obj);
    }

    public void registerForSubscriptionInfoReady(Handler handler, int i, Object obj) {
        mActivePhone.registerForSubscriptionInfoReady(handler, i, obj);
    }

    public void registerForSuppServiceFailed(Handler handler, int i, Object obj) {
        mActivePhone.registerForSuppServiceFailed(handler, i, obj);
    }

    public void registerForSuppServiceNotification(Handler handler, int i, Object obj) {
        mActivePhone.registerForSuppServiceNotification(handler, i, obj);
    }

    public void registerForT53AudioControlInfo(Handler handler, int i, Object obj) {
        mActivePhone.registerForT53AudioControlInfo(handler, i, obj);
    }

    public void registerForUnknownConnection(Handler handler, int i, Object obj) {
        mActivePhone.registerForUnknownConnection(handler, i, obj);
    }

    public void rejectCall() throws CallStateException {
        mActivePhone.rejectCall();
    }

    public void removeReferences() {
        mActivePhone = null;
        mCommandsInterface = null;
    }

    public void requestIsimAuthentication(String s, Message message) {
        mActivePhone.requestIsimAuthentication(s, message);
    }

    public void selectNetworkManually(OperatorInfo operatorinfo, Message message) {
        mActivePhone.selectNetworkManually(operatorinfo, message);
    }

    public void sendBurstDtmf(String s, int i, int j, Message message) {
        mActivePhone.sendBurstDtmf(s, i, j, message);
    }

    public void sendDtmf(char c) {
        mActivePhone.sendDtmf(c);
    }

    public void sendUssdResponse(String s) {
        mActivePhone.sendUssdResponse(s);
    }

    public void setBandMode(int i, Message message) {
        mActivePhone.setBandMode(i, message);
    }

    public void setCallForwardingOption(int i, int j, String s, int k, Message message) {
        mActivePhone.setCallForwardingOption(i, j, s, k, message);
    }

    public void setCallWaiting(boolean flag, Message message) {
        mActivePhone.setCallWaiting(flag, message);
    }

    public void setCdmaRoamingPreference(int i, Message message) {
        mActivePhone.setCdmaRoamingPreference(i, message);
    }

    public void setCdmaSubscription(int i, Message message) {
        mActivePhone.setCdmaSubscription(i, message);
    }

    public void setCellBroadcastSmsConfig(int ai[], Message message) {
        mActivePhone.setCellBroadcastSmsConfig(ai, message);
    }

    public void setDataRoamingEnabled(boolean flag) {
        mActivePhone.setDataRoamingEnabled(flag);
    }

    public void setEchoSuppressionEnabled(boolean flag) {
        mActivePhone.setEchoSuppressionEnabled(flag);
    }

    public void setLine1Number(String s, String s1, Message message) {
        mActivePhone.setLine1Number(s, s1, message);
    }

    public void setMute(boolean flag) {
        mActivePhone.setMute(flag);
    }

    public void setNetworkSelectionModeAutomatic(Message message) {
        mActivePhone.setNetworkSelectionModeAutomatic(message);
    }

    public void setOnEcbModeExitResponse(Handler handler, int i, Object obj) {
        mActivePhone.setOnEcbModeExitResponse(handler, i, obj);
    }

    public void setOnPostDialCharacter(Handler handler, int i, Object obj) {
        mActivePhone.setOnPostDialCharacter(handler, i, obj);
    }

    public void setOutgoingCallerIdDisplay(int i, Message message) {
        mActivePhone.setOutgoingCallerIdDisplay(i, message);
    }

    public void setPreferredNetworkType(int i, Message message) {
        mActivePhone.setPreferredNetworkType(i, message);
    }

    public void setRadioPower(boolean flag) {
        mActivePhone.setRadioPower(flag);
    }

    public void setSmscAddress(String s, Message message) {
        mActivePhone.setSmscAddress(s, message);
    }

    public void setTTYMode(int i, Message message) {
        mActivePhone.setTTYMode(i, message);
    }

    public void setUnitTestMode(boolean flag) {
        mActivePhone.setUnitTestMode(flag);
    }

    public void setVoiceMailNumber(String s, String s1, Message message) {
        mActivePhone.setVoiceMailNumber(s, s1, message);
    }

    public void setVoiceMessageWaiting(int i, int j) {
        mActivePhone.setVoiceMessageWaiting(i, j);
    }

    public void startDtmf(char c) {
        mActivePhone.startDtmf(c);
    }

    public void stopDtmf() {
        mActivePhone.stopDtmf();
    }

    public void switchHoldingAndActive() throws CallStateException {
        mActivePhone.switchHoldingAndActive();
    }

    public void unregisterForCallWaiting(Handler handler) {
        mActivePhone.unregisterForCallWaiting(handler);
    }

    public void unregisterForCdmaOtaStatusChange(Handler handler) {
        mActivePhone.unregisterForCdmaOtaStatusChange(handler);
    }

    public void unregisterForDisconnect(Handler handler) {
        mActivePhone.unregisterForDisconnect(handler);
    }

    public void unregisterForDisplayInfo(Handler handler) {
        mActivePhone.unregisterForDisplayInfo(handler);
    }

    public void unregisterForEcmTimerReset(Handler handler) {
        mActivePhone.unregisterForEcmTimerReset(handler);
    }

    public void unregisterForInCallVoicePrivacyOff(Handler handler) {
        mActivePhone.unregisterForInCallVoicePrivacyOff(handler);
    }

    public void unregisterForInCallVoicePrivacyOn(Handler handler) {
        mActivePhone.unregisterForInCallVoicePrivacyOn(handler);
    }

    public void unregisterForIncomingRing(Handler handler) {
        mActivePhone.unregisterForIncomingRing(handler);
    }

    public void unregisterForLineControlInfo(Handler handler) {
        mActivePhone.unregisterForLineControlInfo(handler);
    }

    public void unregisterForMmiComplete(Handler handler) {
        mActivePhone.unregisterForMmiComplete(handler);
    }

    public void unregisterForMmiInitiate(Handler handler) {
        mActivePhone.unregisterForMmiInitiate(handler);
    }

    public void unregisterForNewRingingConnection(Handler handler) {
        mActivePhone.unregisterForNewRingingConnection(handler);
    }

    public void unregisterForNumberInfo(Handler handler) {
        mActivePhone.unregisterForNumberInfo(handler);
    }

    public void unregisterForPreciseCallStateChanged(Handler handler) {
        mActivePhone.unregisterForPreciseCallStateChanged(handler);
    }

    public void unregisterForRedirectedNumberInfo(Handler handler) {
        mActivePhone.unregisterForRedirectedNumberInfo(handler);
    }

    public void unregisterForResendIncallMute(Handler handler) {
        mActivePhone.unregisterForResendIncallMute(handler);
    }

    public void unregisterForRingbackTone(Handler handler) {
        mActivePhone.unregisterForRingbackTone(handler);
    }

    public void unregisterForServiceStateChanged(Handler handler) {
        mActivePhone.unregisterForServiceStateChanged(handler);
    }

    public void unregisterForSignalInfo(Handler handler) {
        mActivePhone.unregisterForSignalInfo(handler);
    }

    public void unregisterForSubscriptionInfoReady(Handler handler) {
        mActivePhone.unregisterForSubscriptionInfoReady(handler);
    }

    public void unregisterForSuppServiceFailed(Handler handler) {
        mActivePhone.unregisterForSuppServiceFailed(handler);
    }

    public void unregisterForSuppServiceNotification(Handler handler) {
        mActivePhone.unregisterForSuppServiceNotification(handler);
    }

    public void unregisterForT53AudioControlInfo(Handler handler) {
        mActivePhone.unregisterForT53AudioControlInfo(handler);
    }

    public void unregisterForT53ClirInfo(Handler handler) {
        mActivePhone.unregisterForT53ClirInfo(handler);
    }

    public void unregisterForUnknownConnection(Handler handler) {
        mActivePhone.unregisterForUnknownConnection(handler);
    }

    public void unsetOnEcbModeExitResponse(Handler handler) {
        mActivePhone.unsetOnEcbModeExitResponse(handler);
    }

    public void updateServiceLocation() {
        mActivePhone.updateServiceLocation();
    }

    private static final int EVENT_RADIO_ON = 2;
    private static final int EVENT_REQUEST_VOICE_RADIO_TECH_DONE = 3;
    private static final int EVENT_RIL_CONNECTED = 4;
    private static final int EVENT_VOICE_RADIO_TECH_CHANGED = 1;
    private static final String LOG_TAG = "PHONE";
    public static final Object lockForRadioTechnologyChange = new Object();
    private Phone mActivePhone;
    private CommandsInterface mCommandsInterface;
    private IccPhoneBookInterfaceManagerProxy mIccPhoneBookInterfaceManagerProxy;
    private IccSmsInterfaceManagerProxy mIccSmsInterfaceManagerProxy;
    private PhoneSubInfoProxy mPhoneSubInfoProxy;
    private boolean mResetModemOnRadioTechnologyChange;
    private int mRilVersion;

}
