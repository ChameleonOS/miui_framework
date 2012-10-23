// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.sip;

import android.content.Context;
import android.net.LinkProperties;
import android.os.*;
import android.telephony.*;
import android.util.Log;
import com.android.internal.telephony.*;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.android.internal.telephony.sip:
//            SipCommandInterface

abstract class SipPhoneBase extends PhoneBase {

    public SipPhoneBase(Context context, PhoneNotifier phonenotifier) {
        super(phonenotifier, context, new SipCommandInterface(context), false);
        mRingbackRegistrants = new RegistrantList();
        state = com.android.internal.telephony.Phone.State.IDLE;
    }

    static void migrate(RegistrantList registrantlist, RegistrantList registrantlist1) {
        registrantlist1.removeCleared();
        int i = 0;
        for(int j = registrantlist1.size(); i < j; i++)
            registrantlist.add((Registrant)registrantlist1.get(i));

    }

    public void activateCellBroadcastSms(int i, Message message) {
        Log.e("SipPhone", "Error! This functionality is not implemented for SIP.");
    }

    public boolean canDial() {
        boolean flag;
        int i;
        flag = false;
        i = getServiceState().getState();
        Log.v("SipPhone", (new StringBuilder()).append("canDial(): serviceState = ").append(i).toString());
        if(i != 3) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        String s = SystemProperties.get("ro.telephony.disable-call", "false");
        Log.v("SipPhone", (new StringBuilder()).append("canDial(): disableCall = ").append(s).toString());
        if(!s.equals("true")) {
            Log.v("SipPhone", (new StringBuilder()).append("canDial(): ringingCall: ").append(getRingingCall().getState()).toString());
            Log.v("SipPhone", (new StringBuilder()).append("canDial(): foregndCall: ").append(getForegroundCall().getState()).toString());
            Log.v("SipPhone", (new StringBuilder()).append("canDial(): backgndCall: ").append(getBackgroundCall().getState()).toString());
            if(!getRingingCall().isRinging() && (!getForegroundCall().getState().isAlive() || !getBackgroundCall().getState().isAlive()))
                flag = true;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public Connection dial(String s, UUSInfo uusinfo) throws CallStateException {
        return dial(s);
    }

    public boolean disableDataConnectivity() {
        return false;
    }

    public void disableLocationUpdates() {
    }

    public boolean enableDataConnectivity() {
        return false;
    }

    public void enableLocationUpdates() {
    }

    public void getAvailableNetworks(Message message) {
    }

    public abstract Call getBackgroundCall();

    public boolean getCallForwardingIndicator() {
        return false;
    }

    public void getCallForwardingOption(int i, Message message) {
    }

    public void getCallWaiting(Message message) {
        AsyncResult.forMessage(message, null, null);
        message.sendToTarget();
    }

    public void getCellBroadcastSmsConfig(Message message) {
        Log.e("SipPhone", "Error! This functionality is not implemented for SIP.");
    }

    public CellLocation getCellLocation() {
        return null;
    }

    public List getCurrentDataConnectionList() {
        return null;
    }

    public com.android.internal.telephony.Phone.DataActivityState getDataActivityState() {
        return com.android.internal.telephony.Phone.DataActivityState.NONE;
    }

    public void getDataCallList(Message message) {
    }

    public com.android.internal.telephony.Phone.DataState getDataConnectionState() {
        return com.android.internal.telephony.Phone.DataState.DISCONNECTED;
    }

    public com.android.internal.telephony.Phone.DataState getDataConnectionState(String s) {
        return com.android.internal.telephony.Phone.DataState.DISCONNECTED;
    }

    public boolean getDataRoamingEnabled() {
        return false;
    }

    public String getDeviceId() {
        return null;
    }

    public String getDeviceSvn() {
        return null;
    }

    public String getEsn() {
        Log.e("SipPhone", "[SipPhone] getEsn() is a CDMA method");
        return "0";
    }

    public abstract Call getForegroundCall();

    public IccCard getIccCard() {
        return null;
    }

    public IccFileHandler getIccFileHandler() {
        return null;
    }

    public IccPhoneBookInterfaceManager getIccPhoneBookInterfaceManager() {
        return null;
    }

    public boolean getIccRecordsLoaded() {
        return false;
    }

    public String getIccSerialNumber() {
        return null;
    }

    public IccSmsInterfaceManager getIccSmsInterfaceManager() {
        return null;
    }

    public String getImei() {
        return null;
    }

    public String getLine1AlphaTag() {
        return null;
    }

    public String getLine1Number() {
        return null;
    }

    public LinkProperties getLinkProperties(String s) {
        return null;
    }

    public String getMeid() {
        Log.e("SipPhone", "[SipPhone] getMeid() is a CDMA method");
        return "0";
    }

    public boolean getMessageWaitingIndicator() {
        return false;
    }

    public void getNeighboringCids(Message message) {
    }

    public void getOutgoingCallerIdDisplay(Message message) {
        AsyncResult.forMessage(message, null, null);
        message.sendToTarget();
    }

    public List getPendingMmiCodes() {
        return new ArrayList(0);
    }

    public PhoneSubInfo getPhoneSubInfo() {
        return null;
    }

    public int getPhoneType() {
        return 3;
    }

    public abstract Call getRingingCall();

    public ServiceState getServiceState() {
        ServiceState servicestate = new ServiceState();
        servicestate.setState(0);
        return servicestate;
    }

    public SignalStrength getSignalStrength() {
        return new SignalStrength();
    }

    public com.android.internal.telephony.Phone.State getState() {
        return state;
    }

    public String getSubscriberId() {
        return null;
    }

    public String getVoiceMailAlphaTag() {
        return null;
    }

    public String getVoiceMailNumber() {
        return null;
    }

    public boolean handleInCallMmiCommands(String s) throws CallStateException {
        return false;
    }

    public boolean handlePinMmi(String s) {
        return false;
    }

    public boolean isDataConnectivityPossible() {
        return false;
    }

    boolean isInCall() {
        com.android.internal.telephony.Call.State state1 = getForegroundCall().getState();
        com.android.internal.telephony.Call.State state2 = getBackgroundCall().getState();
        com.android.internal.telephony.Call.State state3 = getRingingCall().getState();
        boolean flag;
        if(state1.isAlive() || state2.isAlive() || state3.isAlive())
            flag = true;
        else
            flag = false;
        return flag;
    }

    void migrateFrom(SipPhoneBase sipphonebase) {
        migrate(mRingbackRegistrants, sipphonebase.mRingbackRegistrants);
        migrate(super.mPreciseCallStateRegistrants, ((PhoneBase) (sipphonebase)).mPreciseCallStateRegistrants);
        migrate(super.mNewRingingConnectionRegistrants, ((PhoneBase) (sipphonebase)).mNewRingingConnectionRegistrants);
        migrate(super.mIncomingRingRegistrants, ((PhoneBase) (sipphonebase)).mIncomingRingRegistrants);
        migrate(super.mDisconnectRegistrants, ((PhoneBase) (sipphonebase)).mDisconnectRegistrants);
        migrate(super.mServiceStateRegistrants, ((PhoneBase) (sipphonebase)).mServiceStateRegistrants);
        migrate(super.mMmiCompleteRegistrants, ((PhoneBase) (sipphonebase)).mMmiCompleteRegistrants);
        migrate(super.mMmiRegistrants, ((PhoneBase) (sipphonebase)).mMmiRegistrants);
        migrate(super.mUnknownConnectionRegistrants, ((PhoneBase) (sipphonebase)).mUnknownConnectionRegistrants);
        migrate(super.mSuppServiceFailedRegistrants, ((PhoneBase) (sipphonebase)).mSuppServiceFailedRegistrants);
    }

    public boolean needsOtaServiceProvisioning() {
        return false;
    }

    public void notifyCallForwardingIndicator() {
        super.mNotifier.notifyCallForwardingChanged(this);
    }

    void notifyDisconnect(Connection connection) {
        super.mDisconnectRegistrants.notifyResult(connection);
    }

    void notifyNewRingingConnection(Connection connection) {
        super.notifyNewRingingConnectionP(connection);
    }

    void notifyPhoneStateChanged() {
        super.mNotifier.notifyPhoneState(this);
    }

    void notifyPreciseCallStateChanged() {
        super.notifyPreciseCallStateChangedP();
    }

    void notifyServiceStateChanged(ServiceState servicestate) {
        super.notifyServiceStateChangedP(servicestate);
    }

    void notifySuppServiceFailed(com.android.internal.telephony.Phone.SuppService suppservice) {
        super.mSuppServiceFailedRegistrants.notifyResult(suppservice);
    }

    void notifyUnknownConnection() {
        super.mUnknownConnectionRegistrants.notifyResult(this);
    }

    public void registerForRingbackTone(Handler handler, int i, Object obj) {
        mRingbackRegistrants.addUnique(handler, i, obj);
    }

    public void registerForSuppServiceNotification(Handler handler, int i, Object obj) {
    }

    public void saveClirSetting(int i) {
    }

    public void selectNetworkManually(OperatorInfo operatorinfo, Message message) {
    }

    public void sendUssdResponse(String s) {
    }

    public void setCallForwardingOption(int i, int j, String s, int k, Message message) {
    }

    public void setCallWaiting(boolean flag, Message message) {
        Log.e("SipPhone", "call waiting not supported");
    }

    public void setCellBroadcastSmsConfig(int ai[], Message message) {
        Log.e("SipPhone", "Error! This functionality is not implemented for SIP.");
    }

    public void setDataRoamingEnabled(boolean flag) {
    }

    public void setLine1Number(String s, String s1, Message message) {
        AsyncResult.forMessage(message, null, null);
        message.sendToTarget();
    }

    public void setNetworkSelectionModeAutomatic(Message message) {
    }

    public void setOnPostDialCharacter(Handler handler, int i, Object obj) {
    }

    public void setOutgoingCallerIdDisplay(int i, Message message) {
        AsyncResult.forMessage(message, null, null);
        message.sendToTarget();
    }

    public void setRadioPower(boolean flag) {
    }

    public void setVoiceMailNumber(String s, String s1, Message message) {
        AsyncResult.forMessage(message, null, null);
        message.sendToTarget();
    }

    protected void startRingbackTone() {
        AsyncResult asyncresult = new AsyncResult(null, Boolean.TRUE, null);
        mRingbackRegistrants.notifyRegistrants(asyncresult);
    }

    protected void stopRingbackTone() {
        AsyncResult asyncresult = new AsyncResult(null, Boolean.FALSE, null);
        mRingbackRegistrants.notifyRegistrants(asyncresult);
    }

    public void unregisterForRingbackTone(Handler handler) {
        mRingbackRegistrants.remove(handler);
    }

    public void unregisterForSuppServiceNotification(Handler handler) {
    }

    boolean updateCurrentCarrierInProvider() {
        return false;
    }

    void updatePhoneState() {
        com.android.internal.telephony.Phone.State state1 = state;
        if(getRingingCall().isRinging())
            state = com.android.internal.telephony.Phone.State.RINGING;
        else
        if(getForegroundCall().isIdle() && getBackgroundCall().isIdle())
            state = com.android.internal.telephony.Phone.State.IDLE;
        else
            state = com.android.internal.telephony.Phone.State.OFFHOOK;
        if(state != state1) {
            Log.d("SipPhone", (new StringBuilder()).append(" ^^^ new phone state: ").append(state).toString());
            notifyPhoneStateChanged();
        }
    }

    public void updateServiceLocation() {
    }

    private static final String LOG_TAG = "SipPhone";
    private RegistrantList mRingbackRegistrants;
    private com.android.internal.telephony.Phone.State state;
}
