// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.LinkCapabilities;
import android.net.LinkProperties;
import android.net.wifi.WifiManager;
import android.os.*;
import android.preference.PreferenceManager;
import android.telephony.ServiceState;
import android.text.TextUtils;
import android.util.Log;
import com.android.internal.telephony.gsm.UsimServiceTable;
import com.android.internal.telephony.ims.IsimRecords;
import com.android.internal.telephony.test.SimulatedRadioControl;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.android.internal.telephony:
//            Phone, CommandsInterface, SmsStorageMonitor, SmsUsageMonitor, 
//            MccTable, DataConnectionTracker, PhoneProxy, IccRecords, 
//            IccCard, PhoneNotifier, SMSDispatcher, CallTracker, 
//            IccFileHandler, ServiceStateTracker, Connection

public abstract class PhoneBase extends Handler
    implements Phone {

    protected PhoneBase(PhoneNotifier phonenotifier, Context context, CommandsInterface commandsinterface) {
        this(phonenotifier, context, commandsinterface, false);
    }

    protected PhoneBase(PhoneNotifier phonenotifier, Context context, CommandsInterface commandsinterface, boolean flag) {
        mIsTheCurrentActivePhone = true;
        mIsVoiceCapable = true;
        mIccCard = new AtomicReference();
        mPreciseCallStateRegistrants = new RegistrantList();
        mNewRingingConnectionRegistrants = new RegistrantList();
        mIncomingRingRegistrants = new RegistrantList();
        mDisconnectRegistrants = new RegistrantList();
        mServiceStateRegistrants = new RegistrantList();
        mMmiCompleteRegistrants = new RegistrantList();
        mMmiRegistrants = new RegistrantList();
        mUnknownConnectionRegistrants = new RegistrantList();
        mSuppServiceFailedRegistrants = new RegistrantList();
        mNotifier = phonenotifier;
        mContext = context;
        mLooper = Looper.myLooper();
        mCM = commandsinterface;
        setPropertiesByCarrier();
        setUnitTestMode(flag);
        mDnsCheckDisabled = PreferenceManager.getDefaultSharedPreferences(context).getBoolean("dns_server_check_disabled_key", false);
        mCM.setOnCallRing(this, 14, null);
        mIsVoiceCapable = mContext.getResources().getBoolean(0x1110028);
        mDoesRilSendMultipleCallRing = SystemProperties.getBoolean("ro.telephony.call_ring.multiple", true);
        Log.d("PHONE", (new StringBuilder()).append("mDoesRilSendMultipleCallRing=").append(mDoesRilSendMultipleCallRing).toString());
        mCallRingDelay = SystemProperties.getInt("ro.telephony.call_ring.delay", 3000);
        Log.d("PHONE", (new StringBuilder()).append("mCallRingDelay=").append(mCallRingDelay).toString());
        mSmsStorageMonitor = new SmsStorageMonitor(this);
        mSmsUsageMonitor = new SmsUsageMonitor(context);
    }

    private void checkCorrectThread(Handler handler) {
        if(handler.getLooper() != mLooper)
            throw new RuntimeException("com.android.internal.telephony.Phone must be used from within one thread");
        else
            return;
    }

    private String getSavedNetworkSelection() {
        return PreferenceManager.getDefaultSharedPreferences(getContext()).getString("network_selection_key", "");
    }

    private static void logUnexpectedCdmaMethodCall(String s) {
        Log.e("PHONE", (new StringBuilder()).append("Error! ").append(s).append("() in PhoneBase should not be ").append("called, CDMAPhone inactive.").toString());
    }

    private static void logUnexpectedGsmMethodCall(String s) {
        Log.e("PHONE", (new StringBuilder()).append("Error! ").append(s).append("() in PhoneBase should not be ").append("called, GSMPhone inactive.").toString());
    }

    private void notifyIncomingRing() {
        if(mIsVoiceCapable) {
            AsyncResult asyncresult = new AsyncResult(null, this, null);
            mIncomingRingRegistrants.notifyRegistrants(asyncresult);
        }
    }

    private void sendIncomingCallRingNotification(int i) {
        if(mIsVoiceCapable && !mDoesRilSendMultipleCallRing && i == mCallRingContinueToken) {
            Log.d("PHONE", "Sending notifyIncomingRing");
            notifyIncomingRing();
            sendMessageDelayed(obtainMessage(15, i, 0), mCallRingDelay);
        } else {
            Log.d("PHONE", (new StringBuilder()).append("Ignoring ring notification request, mDoesRilSendMultipleCallRing=").append(mDoesRilSendMultipleCallRing).append(" token=").append(i).append(" mCallRingContinueToken=").append(mCallRingContinueToken).append(" mIsVoiceCapable=").append(mIsVoiceCapable).toString());
        }
    }

    private void setPropertiesByCarrier() {
        String s = SystemProperties.get("ro.carrier");
        if(s != null && s.length() != 0 && !"unknown".equals(s)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        CharSequence acharsequence[] = mContext.getResources().getTextArray(0x1070033);
        int i = 0;
        do {
            if(i < acharsequence.length) {
label0:
                {
                    if(!s.equals(acharsequence[i].toString()))
                        break label0;
                    String s1 = acharsequence[i + 1].toString();
                    String s2 = s1.substring(0, 2);
                    String s3 = "";
                    if(s1.length() >= 5)
                        s3 = s1.substring(3, 5);
                    MccTable.setSystemLocale(mContext, s2, s3);
                    if(!s3.isEmpty())
                        try {
                            android.provider.Settings.Secure.getInt(mContext.getContentResolver(), "wifi_country_code");
                        }
                        catch(android.provider.Settings.SettingNotFoundException settingnotfoundexception) {
                            ((WifiManager)mContext.getSystemService("wifi")).setCountryCode(s3, false);
                        }
                }
            }
            if(true)
                continue;
            i += 3;
        } while(true);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public int disableApnType(String s) {
        return mDataConnectionTracker.disableApnType(s);
    }

    public void disableDnsCheck(boolean flag) {
        mDnsCheckDisabled = flag;
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(getContext()).edit();
        editor.putBoolean("dns_server_check_disabled_key", flag);
        editor.apply();
    }

    public void dispose() {
        Object obj = PhoneProxy.lockForRadioTechnologyChange;
        obj;
        JVM INSTR monitorenter ;
        mCM.unSetOnCallRing(this);
        mDataConnectionTracker.cleanUpAllConnections(null);
        mIsTheCurrentActivePhone = false;
        mSmsStorageMonitor.dispose();
        mSmsUsageMonitor.dispose();
        return;
    }

    public void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        printwriter.println("PhoneBase:");
        printwriter.println((new StringBuilder()).append(" mCM=").append(mCM).toString());
        printwriter.println((new StringBuilder()).append(" mDnsCheckDisabled=").append(mDnsCheckDisabled).toString());
        printwriter.println((new StringBuilder()).append(" mDataConnectionTracker=").append(mDataConnectionTracker).toString());
        printwriter.println((new StringBuilder()).append(" mDoesRilSendMultipleCallRing=").append(mDoesRilSendMultipleCallRing).toString());
        printwriter.println((new StringBuilder()).append(" mCallRingContinueToken=").append(mCallRingContinueToken).toString());
        printwriter.println((new StringBuilder()).append(" mCallRingDelay=").append(mCallRingDelay).toString());
        printwriter.println((new StringBuilder()).append(" mIsTheCurrentActivePhone=").append(mIsTheCurrentActivePhone).toString());
        printwriter.println((new StringBuilder()).append(" mIsVoiceCapable=").append(mIsVoiceCapable).toString());
        printwriter.println((new StringBuilder()).append(" mIccRecords=").append(mIccRecords).toString());
        printwriter.println((new StringBuilder()).append(" mIccCard=").append(mIccCard.get()).toString());
        printwriter.println((new StringBuilder()).append(" mSmsStorageMonitor=").append(mSmsStorageMonitor).toString());
        printwriter.println((new StringBuilder()).append(" mSmsUsageMonitor=").append(mSmsUsageMonitor).toString());
        printwriter.println((new StringBuilder()).append(" mSMS=").append(mSMS).toString());
        printwriter.flush();
        printwriter.println((new StringBuilder()).append(" mLooper=").append(mLooper).toString());
        printwriter.println((new StringBuilder()).append(" mContext=").append(mContext).toString());
        printwriter.println((new StringBuilder()).append(" mNotifier=").append(mNotifier).toString());
        printwriter.println((new StringBuilder()).append(" mSimulatedRadioControl=").append(mSimulatedRadioControl).toString());
        printwriter.println((new StringBuilder()).append(" mUnitTestMode=").append(mUnitTestMode).toString());
        printwriter.println((new StringBuilder()).append(" isDnsCheckDisabled()=").append(isDnsCheckDisabled()).toString());
        printwriter.println((new StringBuilder()).append(" getUnitTestMode()=").append(getUnitTestMode()).toString());
        printwriter.println((new StringBuilder()).append(" getState()=").append(getState()).toString());
        printwriter.println((new StringBuilder()).append(" getIccSerialNumber()=").append(getIccSerialNumber()).toString());
        printwriter.println((new StringBuilder()).append(" getIccRecordsLoaded()=").append(getIccRecordsLoaded()).toString());
        printwriter.println((new StringBuilder()).append(" getMessageWaitingIndicator()=").append(getMessageWaitingIndicator()).toString());
        printwriter.println((new StringBuilder()).append(" getCallForwardingIndicator()=").append(getCallForwardingIndicator()).toString());
        printwriter.println((new StringBuilder()).append(" isInEmergencyCall()=").append(isInEmergencyCall()).toString());
        printwriter.flush();
        printwriter.println((new StringBuilder()).append(" isInEcm()=").append(isInEcm()).toString());
        printwriter.println((new StringBuilder()).append(" getPhoneName()=").append(getPhoneName()).toString());
        printwriter.println((new StringBuilder()).append(" getPhoneType()=").append(getPhoneType()).toString());
        printwriter.println((new StringBuilder()).append(" getVoiceMessageCount()=").append(getVoiceMessageCount()).toString());
        printwriter.println((new StringBuilder()).append(" getActiveApnTypes()=").append(getActiveApnTypes()).toString());
        printwriter.println((new StringBuilder()).append(" isDataConnectivityPossible()=").append(isDataConnectivityPossible()).toString());
        printwriter.println((new StringBuilder()).append(" needsOtaServiceProvisioning=").append(needsOtaServiceProvisioning()).toString());
    }

    public int enableApnType(String s) {
        return mDataConnectionTracker.enableApnType(s);
    }

    public void enableEnhancedVoicePrivacy(boolean flag, Message message) {
        logUnexpectedCdmaMethodCall("enableEnhancedVoicePrivacy");
    }

    public void exitEmergencyCallbackMode() {
        logUnexpectedCdmaMethodCall("exitEmergencyCallbackMode");
    }

    public String getActiveApnHost(String s) {
        return mDataConnectionTracker.getActiveApnString(s);
    }

    public String[] getActiveApnTypes() {
        return mDataConnectionTracker.getActiveApnTypes();
    }

    public boolean getCallForwardingIndicator() {
        return mIccRecords.getVoiceCallForwardingFlag();
    }

    public CallTracker getCallTracker() {
        return null;
    }

    public int getCdmaEriIconIndex() {
        logUnexpectedCdmaMethodCall("getCdmaEriIconIndex");
        return -1;
    }

    public int getCdmaEriIconMode() {
        logUnexpectedCdmaMethodCall("getCdmaEriIconMode");
        return -1;
    }

    public String getCdmaEriText() {
        logUnexpectedCdmaMethodCall("getCdmaEriText");
        return "GSM nw, no ERI";
    }

    public String getCdmaMin() {
        logUnexpectedCdmaMethodCall("getCdmaMin");
        return null;
    }

    public String getCdmaPrlVersion() {
        logUnexpectedCdmaMethodCall("getCdmaPrlVersion");
        return null;
    }

    public Context getContext() {
        return mContext;
    }

    public Phone.DataState getDataConnectionState() {
        return getDataConnectionState("default");
    }

    public void getEnhancedVoicePrivacy(Message message) {
        logUnexpectedCdmaMethodCall("getEnhancedVoicePrivacy");
    }

    public Handler getHandler() {
        return this;
    }

    public IccCard getIccCard() {
        return (IccCard)mIccCard.get();
    }

    public IccFileHandler getIccFileHandler() {
        IccCard icccard = (IccCard)mIccCard.get();
        IccFileHandler iccfilehandler;
        if(icccard == null)
            iccfilehandler = null;
        else
            iccfilehandler = icccard.getIccFileHandler();
        return iccfilehandler;
    }

    public boolean getIccRecordsLoaded() {
        return mIccRecords.getRecordsLoaded();
    }

    public String getIccSerialNumber() {
        return mIccRecords.iccid;
    }

    public IsimRecords getIsimRecords() {
        Log.e("PHONE", "getIsimRecords() is only supported on LTE devices");
        return null;
    }

    public LinkCapabilities getLinkCapabilities(String s) {
        return mDataConnectionTracker.getLinkCapabilities(s);
    }

    public LinkProperties getLinkProperties(String s) {
        return mDataConnectionTracker.getLinkProperties(s);
    }

    public int getLteOnCdmaMode() {
        return mCM.getLteOnCdmaMode();
    }

    public boolean getMessageWaitingIndicator() {
        return mIccRecords.getVoiceMessageWaiting();
    }

    public String getMsisdn() {
        logUnexpectedGsmMethodCall("getMsisdn");
        return null;
    }

    public abstract String getPhoneName();

    public abstract int getPhoneType();

    public void getPreferredNetworkType(Message message) {
        mCM.getPreferredNetworkType(message);
    }

    public ServiceStateTracker getServiceStateTracker() {
        return null;
    }

    public SimulatedRadioControl getSimulatedRadioControl() {
        return mSimulatedRadioControl;
    }

    public void getSmscAddress(Message message) {
        mCM.getSmscAddress(message);
    }

    public abstract Phone.State getState();

    public boolean getUnitTestMode() {
        return mUnitTestMode;
    }

    public UsimServiceTable getUsimServiceTable() {
        return mIccRecords.getUsimServiceTable();
    }

    public int getVoiceMessageCount() {
        return 0;
    }

    public void handleMessage(Message message) {
        message.what;
        JVM INSTR tableswitch 14 15: default 28
    //                   14 39
    //                   15 136;
           goto _L1 _L2 _L3
_L1:
        throw new RuntimeException("unexpected event not handled");
_L2:
        Log.d("PHONE", (new StringBuilder()).append("Event EVENT_CALL_RING Received state=").append(getState()).toString());
        if(((AsyncResult)message.obj).exception == null) {
            Phone.State state = getState();
            if(!mDoesRilSendMultipleCallRing && (state == Phone.State.RINGING || state == Phone.State.IDLE)) {
                mCallRingContinueToken = 1 + mCallRingContinueToken;
                sendIncomingCallRingNotification(mCallRingContinueToken);
            } else {
                notifyIncomingRing();
            }
        }
_L5:
        return;
_L3:
        Log.d("PHONE", (new StringBuilder()).append("Event EVENT_CALL_RING_CONTINUE Received stat=").append(getState()).toString());
        if(getState() == Phone.State.RINGING)
            sendIncomingCallRingNotification(message.arg1);
        if(true) goto _L5; else goto _L4
_L4:
    }

    public void invokeOemRilRequestRaw(byte abyte0[], Message message) {
        mCM.invokeOemRilRequestRaw(abyte0, message);
    }

    public void invokeOemRilRequestStrings(String as[], Message message) {
        mCM.invokeOemRilRequestStrings(as, message);
    }

    public boolean isCspPlmnEnabled() {
        logUnexpectedGsmMethodCall("isCspPlmnEnabled");
        return false;
    }

    public boolean isDataConnectivityPossible() {
        return isDataConnectivityPossible("default");
    }

    public boolean isDataConnectivityPossible(String s) {
        boolean flag;
        if(mDataConnectionTracker != null && mDataConnectionTracker.isDataPossible(s))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isDnsCheckDisabled() {
        return mDnsCheckDisabled;
    }

    public boolean isInEcm() {
        return false;
    }

    public boolean isInEmergencyCall() {
        return false;
    }

    public boolean isMinInfoReady() {
        logUnexpectedCdmaMethodCall("isMinInfoReady");
        return false;
    }

    public boolean isOtaSpNumber(String s) {
        return false;
    }

    public boolean needsOtaServiceProvisioning() {
        return false;
    }

    public void notifyCallForwardingIndicator() {
        Log.e("PHONE", "Error! This function should never be executed, inactive CDMAPhone.");
    }

    public void notifyDataActivity() {
        mNotifier.notifyDataActivity(this);
    }

    public void notifyDataConnection(String s) {
        String as[] = getActiveApnTypes();
        int i = as.length;
        for(int j = 0; j < i; j++) {
            String s1 = as[j];
            mNotifier.notifyDataConnection(this, s, s1, getDataConnectionState(s1));
        }

    }

    public void notifyDataConnection(String s, String s1) {
        mNotifier.notifyDataConnection(this, s, s1, getDataConnectionState(s1));
    }

    public void notifyDataConnection(String s, String s1, Phone.DataState datastate) {
        mNotifier.notifyDataConnection(this, s, s1, datastate);
    }

    public void notifyDataConnectionFailed(String s, String s1) {
        mNotifier.notifyDataConnectionFailed(this, s, s1);
    }

    protected void notifyDisconnectP(Connection connection) {
        AsyncResult asyncresult = new AsyncResult(null, connection, null);
        mDisconnectRegistrants.notifyRegistrants(asyncresult);
    }

    public void notifyMessageWaitingIndicator() {
        if(mIsVoiceCapable)
            mNotifier.notifyMessageWaitingChanged(this);
    }

    protected void notifyNewRingingConnectionP(Connection connection) {
        if(mIsVoiceCapable) {
            AsyncResult asyncresult = new AsyncResult(null, connection, null);
            mNewRingingConnectionRegistrants.notifyRegistrants(asyncresult);
        }
    }

    public void notifyOtaspChanged(int i) {
        mNotifier.notifyOtaspChanged(this, i);
    }

    protected void notifyPreciseCallStateChangedP() {
        AsyncResult asyncresult = new AsyncResult(null, this, null);
        mPreciseCallStateRegistrants.notifyRegistrants(asyncresult);
    }

    protected void notifyServiceStateChangedP(ServiceState servicestate) {
        AsyncResult asyncresult = new AsyncResult(null, servicestate, null);
        mServiceStateRegistrants.notifyRegistrants(asyncresult);
        mNotifier.notifyServiceState(this);
    }

    public void queryAvailableBandMode(Message message) {
        mCM.queryAvailableBandMode(message);
    }

    public void queryCdmaRoamingPreference(Message message) {
        mCM.queryCdmaRoamingPreference(message);
    }

    public void queryTTYMode(Message message) {
        mCM.queryTTYMode(message);
    }

    public void registerFoT53ClirlInfo(Handler handler, int i, Object obj) {
        mCM.registerFoT53ClirlInfo(handler, i, obj);
    }

    public void registerForCallWaiting(Handler handler, int i, Object obj) {
        logUnexpectedCdmaMethodCall("registerForCallWaiting");
    }

    public void registerForCdmaOtaStatusChange(Handler handler, int i, Object obj) {
        logUnexpectedCdmaMethodCall("registerForCdmaOtaStatusChange");
    }

    public void registerForDisconnect(Handler handler, int i, Object obj) {
        checkCorrectThread(handler);
        mDisconnectRegistrants.addUnique(handler, i, obj);
    }

    public void registerForDisplayInfo(Handler handler, int i, Object obj) {
        mCM.registerForDisplayInfo(handler, i, obj);
    }

    public void registerForEcmTimerReset(Handler handler, int i, Object obj) {
        logUnexpectedCdmaMethodCall("registerForEcmTimerReset");
    }

    public void registerForInCallVoicePrivacyOff(Handler handler, int i, Object obj) {
        mCM.registerForInCallVoicePrivacyOff(handler, i, obj);
    }

    public void registerForInCallVoicePrivacyOn(Handler handler, int i, Object obj) {
        mCM.registerForInCallVoicePrivacyOn(handler, i, obj);
    }

    public void registerForIncomingRing(Handler handler, int i, Object obj) {
        checkCorrectThread(handler);
        mIncomingRingRegistrants.addUnique(handler, i, obj);
    }

    public void registerForLineControlInfo(Handler handler, int i, Object obj) {
        mCM.registerForLineControlInfo(handler, i, obj);
    }

    public void registerForMmiComplete(Handler handler, int i, Object obj) {
        checkCorrectThread(handler);
        mMmiCompleteRegistrants.addUnique(handler, i, obj);
    }

    public void registerForMmiInitiate(Handler handler, int i, Object obj) {
        checkCorrectThread(handler);
        mMmiRegistrants.addUnique(handler, i, obj);
    }

    public void registerForNewRingingConnection(Handler handler, int i, Object obj) {
        checkCorrectThread(handler);
        mNewRingingConnectionRegistrants.addUnique(handler, i, obj);
    }

    public void registerForNumberInfo(Handler handler, int i, Object obj) {
        mCM.registerForNumberInfo(handler, i, obj);
    }

    public void registerForPreciseCallStateChanged(Handler handler, int i, Object obj) {
        checkCorrectThread(handler);
        mPreciseCallStateRegistrants.addUnique(handler, i, obj);
    }

    public void registerForRedirectedNumberInfo(Handler handler, int i, Object obj) {
        mCM.registerForRedirectedNumberInfo(handler, i, obj);
    }

    public void registerForResendIncallMute(Handler handler, int i, Object obj) {
        mCM.registerForResendIncallMute(handler, i, obj);
    }

    public void registerForRingbackTone(Handler handler, int i, Object obj) {
        mCM.registerForRingbackTone(handler, i, obj);
    }

    public void registerForServiceStateChanged(Handler handler, int i, Object obj) {
        checkCorrectThread(handler);
        mServiceStateRegistrants.add(handler, i, obj);
    }

    public void registerForSignalInfo(Handler handler, int i, Object obj) {
        mCM.registerForSignalInfo(handler, i, obj);
    }

    public void registerForSubscriptionInfoReady(Handler handler, int i, Object obj) {
        logUnexpectedCdmaMethodCall("registerForSubscriptionInfoReady");
    }

    public void registerForSuppServiceFailed(Handler handler, int i, Object obj) {
        checkCorrectThread(handler);
        mSuppServiceFailedRegistrants.addUnique(handler, i, obj);
    }

    public void registerForT53AudioControlInfo(Handler handler, int i, Object obj) {
        mCM.registerForT53AudioControlInfo(handler, i, obj);
    }

    public void registerForUnknownConnection(Handler handler, int i, Object obj) {
        checkCorrectThread(handler);
        mUnknownConnectionRegistrants.addUnique(handler, i, obj);
    }

    public void removeReferences() {
        mSmsStorageMonitor = null;
        mSmsUsageMonitor = null;
        mSMS = null;
        mIccRecords = null;
        mIccCard.set(null);
        mDataConnectionTracker = null;
    }

    public void requestIsimAuthentication(String s, Message message) {
        Log.e("PHONE", "requestIsimAuthentication() is only supported on LTE devices");
    }

    public void restoreSavedNetworkSelection(Message message) {
        String s = getSavedNetworkSelection();
        if(TextUtils.isEmpty(s))
            mCM.setNetworkSelectionModeAutomatic(message);
        else
            mCM.setNetworkSelectionModeManual(s, message);
    }

    public void sendBurstDtmf(String s, int i, int j, Message message) {
        logUnexpectedCdmaMethodCall("sendBurstDtmf");
    }

    public void setBandMode(int i, Message message) {
        mCM.setBandMode(i, message);
    }

    public void setCdmaRoamingPreference(int i, Message message) {
        mCM.setCdmaRoamingPreference(i, message);
    }

    public void setCdmaSubscription(int i, Message message) {
        mCM.setCdmaSubscriptionSource(i, message);
    }

    public void setEchoSuppressionEnabled(boolean flag) {
    }

    public void setOnEcbModeExitResponse(Handler handler, int i, Object obj) {
        logUnexpectedCdmaMethodCall("setOnEcbModeExitResponse");
    }

    public void setPreferredNetworkType(int i, Message message) {
        mCM.setPreferredNetworkType(i, message);
    }

    public void setSmscAddress(String s, Message message) {
        mCM.setSmscAddress(s, message);
    }

    public void setSystemProperty(String s, String s1) {
        if(!getUnitTestMode())
            SystemProperties.set(s, s1);
    }

    public void setTTYMode(int i, Message message) {
        mCM.setTTYMode(i, message);
    }

    public void setUnitTestMode(boolean flag) {
        mUnitTestMode = flag;
    }

    public void setVoiceMessageWaiting(int i, int j) {
        mIccRecords.setVoiceMessageWaiting(i, j);
    }

    public void unregisterForCallWaiting(Handler handler) {
        logUnexpectedCdmaMethodCall("unregisterForCallWaiting");
    }

    public void unregisterForCdmaOtaStatusChange(Handler handler) {
        logUnexpectedCdmaMethodCall("unregisterForCdmaOtaStatusChange");
    }

    public void unregisterForDisconnect(Handler handler) {
        mDisconnectRegistrants.remove(handler);
    }

    public void unregisterForDisplayInfo(Handler handler) {
        mCM.unregisterForDisplayInfo(handler);
    }

    public void unregisterForEcmTimerReset(Handler handler) {
        logUnexpectedCdmaMethodCall("unregisterForEcmTimerReset");
    }

    public void unregisterForInCallVoicePrivacyOff(Handler handler) {
        mCM.unregisterForInCallVoicePrivacyOff(handler);
    }

    public void unregisterForInCallVoicePrivacyOn(Handler handler) {
        mCM.unregisterForInCallVoicePrivacyOn(handler);
    }

    public void unregisterForIncomingRing(Handler handler) {
        mIncomingRingRegistrants.remove(handler);
    }

    public void unregisterForLineControlInfo(Handler handler) {
        mCM.unregisterForLineControlInfo(handler);
    }

    public void unregisterForMmiComplete(Handler handler) {
        checkCorrectThread(handler);
        mMmiCompleteRegistrants.remove(handler);
    }

    public void unregisterForMmiInitiate(Handler handler) {
        mMmiRegistrants.remove(handler);
    }

    public void unregisterForNewRingingConnection(Handler handler) {
        mNewRingingConnectionRegistrants.remove(handler);
    }

    public void unregisterForNumberInfo(Handler handler) {
        mCM.unregisterForNumberInfo(handler);
    }

    public void unregisterForPreciseCallStateChanged(Handler handler) {
        mPreciseCallStateRegistrants.remove(handler);
    }

    public void unregisterForRedirectedNumberInfo(Handler handler) {
        mCM.unregisterForRedirectedNumberInfo(handler);
    }

    public void unregisterForResendIncallMute(Handler handler) {
        mCM.unregisterForResendIncallMute(handler);
    }

    public void unregisterForRingbackTone(Handler handler) {
        mCM.unregisterForRingbackTone(handler);
    }

    public void unregisterForServiceStateChanged(Handler handler) {
        mServiceStateRegistrants.remove(handler);
    }

    public void unregisterForSignalInfo(Handler handler) {
        mCM.unregisterForSignalInfo(handler);
    }

    public void unregisterForSubscriptionInfoReady(Handler handler) {
        logUnexpectedCdmaMethodCall("unregisterForSubscriptionInfoReady");
    }

    public void unregisterForSuppServiceFailed(Handler handler) {
        mSuppServiceFailedRegistrants.remove(handler);
    }

    public void unregisterForT53AudioControlInfo(Handler handler) {
        mCM.unregisterForT53AudioControlInfo(handler);
    }

    public void unregisterForT53ClirInfo(Handler handler) {
        mCM.unregisterForT53ClirInfo(handler);
    }

    public void unregisterForUnknownConnection(Handler handler) {
        mUnknownConnectionRegistrants.remove(handler);
    }

    public void unsetOnEcbModeExitResponse(Handler handler) {
        logUnexpectedCdmaMethodCall("unsetOnEcbModeExitResponse");
    }

    public static final String CLIR_KEY = "clir_key";
    public static final String DATA_DISABLED_ON_BOOT_KEY = "disabled_on_boot_key";
    public static final String DNS_SERVER_CHECK_DISABLED_KEY = "dns_server_check_disabled_key";
    protected static final int EVENT_CALL_RING = 14;
    protected static final int EVENT_CALL_RING_CONTINUE = 15;
    protected static final int EVENT_CDMA_SUBSCRIPTION_SOURCE_CHANGED = 27;
    protected static final int EVENT_EMERGENCY_CALLBACK_MODE_ENTER = 25;
    protected static final int EVENT_EXIT_EMERGENCY_CALLBACK_RESPONSE = 26;
    protected static final int EVENT_GET_BASEBAND_VERSION_DONE = 6;
    protected static final int EVENT_GET_CALL_FORWARD_DONE = 13;
    protected static final int EVENT_GET_DEVICE_IDENTITY_DONE = 21;
    protected static final int EVENT_GET_IMEISV_DONE = 10;
    protected static final int EVENT_GET_IMEI_DONE = 9;
    protected static final int EVENT_GET_SIM_STATUS_DONE = 11;
    protected static final int EVENT_ICC_RECORD_EVENTS = 30;
    protected static final int EVENT_MMI_DONE = 4;
    protected static final int EVENT_NEW_ICC_SMS = 29;
    protected static final int EVENT_NV_READY = 23;
    protected static final int EVENT_RADIO_AVAILABLE = 1;
    protected static final int EVENT_RADIO_OFF_OR_NOT_AVAILABLE = 8;
    protected static final int EVENT_RADIO_ON = 5;
    protected static final int EVENT_REGISTERED_TO_NETWORK = 19;
    protected static final int EVENT_RUIM_RECORDS_LOADED = 22;
    protected static final int EVENT_SET_CALL_FORWARD_DONE = 12;
    protected static final int EVENT_SET_CLIR_COMPLETE = 18;
    protected static final int EVENT_SET_ENHANCED_VP = 24;
    protected static final int EVENT_SET_NETWORK_AUTOMATIC = 28;
    protected static final int EVENT_SET_NETWORK_AUTOMATIC_COMPLETE = 17;
    protected static final int EVENT_SET_NETWORK_MANUAL_COMPLETE = 16;
    protected static final int EVENT_SET_VM_NUMBER_DONE = 20;
    protected static final int EVENT_SIM_RECORDS_LOADED = 3;
    protected static final int EVENT_SSN = 2;
    protected static final int EVENT_USSD = 7;
    private static final boolean LOCAL_DEBUG = true;
    private static final String LOG_TAG = "PHONE";
    public static final String NETWORK_SELECTION_KEY = "network_selection_key";
    public static final String NETWORK_SELECTION_NAME_KEY = "network_selection_name_key";
    public CommandsInterface mCM;
    int mCallRingContinueToken;
    int mCallRingDelay;
    protected final Context mContext;
    public DataConnectionTracker mDataConnectionTracker;
    protected final RegistrantList mDisconnectRegistrants;
    boolean mDnsCheckDisabled;
    boolean mDoesRilSendMultipleCallRing;
    protected AtomicReference mIccCard;
    public IccRecords mIccRecords;
    protected final RegistrantList mIncomingRingRegistrants;
    public boolean mIsTheCurrentActivePhone;
    boolean mIsVoiceCapable;
    protected Looper mLooper;
    protected final RegistrantList mMmiCompleteRegistrants;
    protected final RegistrantList mMmiRegistrants;
    protected final RegistrantList mNewRingingConnectionRegistrants;
    protected PhoneNotifier mNotifier;
    protected final RegistrantList mPreciseCallStateRegistrants;
    public SMSDispatcher mSMS;
    protected final RegistrantList mServiceStateRegistrants;
    protected SimulatedRadioControl mSimulatedRadioControl;
    public SmsStorageMonitor mSmsStorageMonitor;
    public SmsUsageMonitor mSmsUsageMonitor;
    protected final RegistrantList mSuppServiceFailedRegistrants;
    boolean mUnitTestMode;
    protected final RegistrantList mUnknownConnectionRegistrants;
}
