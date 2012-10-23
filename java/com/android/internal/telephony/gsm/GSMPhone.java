// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.gsm;

import android.content.*;
import android.content.pm.PackageManager;
import android.database.SQLException;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.*;
import android.preference.PreferenceManager;
import android.telephony.*;
import android.text.TextUtils;
import android.util.Log;
import com.android.internal.telephony.*;
import com.android.internal.telephony.test.SimulatedRadioControl;
import com.android.internal.telephony.uicc.UiccController;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.android.internal.telephony.gsm:
//            GsmCallTracker, GsmServiceStateTracker, GsmSMSDispatcher, GsmDataConnectionTracker, 
//            SimPhoneBookInterfaceManager, SimSmsInterfaceManager, GsmCall, GsmMmiCode, 
//            SuppServiceNotification, SmsMessage

public class GSMPhone extends PhoneBase {
    private static class NetworkSelectMessage {

        public Message message;
        public String operatorAlphaLong;
        public String operatorNumeric;

        private NetworkSelectMessage() {
        }

        NetworkSelectMessage(_cls1 _pcls1) {
            this();
        }
    }


    public GSMPhone(Context context, CommandsInterface commandsinterface, PhoneNotifier phonenotifier) {
        this(context, commandsinterface, phonenotifier, false);
    }

    public GSMPhone(Context context, CommandsInterface commandsinterface, PhoneNotifier phonenotifier, boolean flag) {
        super(phonenotifier, context, commandsinterface, flag);
        mPendingMMIs = new ArrayList();
        mSsnRegistrants = new RegistrantList();
        if(commandsinterface instanceof SimulatedRadioControl)
            super.mSimulatedRadioControl = (SimulatedRadioControl)commandsinterface;
        super.mCM.setPhoneType(1);
        super.mIccCard.set(UiccController.getInstance(this).getIccCard());
        super.mIccRecords = ((IccCard)super.mIccCard.get()).getIccRecords();
        mCT = new GsmCallTracker(this);
        mSST = new GsmServiceStateTracker(this);
        super.mSMS = new GsmSMSDispatcher(this, super.mSmsStorageMonitor, super.mSmsUsageMonitor);
        super.mDataConnectionTracker = new GsmDataConnectionTracker(this);
        if(!flag) {
            mSimPhoneBookIntManager = new SimPhoneBookInterfaceManager(this);
            mSimSmsIntManager = new SimSmsInterfaceManager(this, super.mSMS);
            mSubInfo = new PhoneSubInfo(this);
        }
        super.mCM.registerForAvailable(this, 1, null);
        registerForSimRecordEvents();
        super.mCM.registerForOffOrNotAvailable(this, 8, null);
        super.mCM.registerForOn(this, 5, null);
        super.mCM.setOnUSSD(this, 7, null);
        super.mCM.setOnSuppServiceNotification(this, 2, null);
        mSST.registerForNetworkAttached(this, 19, null);
        SystemProperties.set("gsm.current.phone-type", (new Integer(1)).toString());
    }

    private String getVmSimImsi() {
        return PreferenceManager.getDefaultSharedPreferences(getContext()).getString("vm_sim_imsi_key", null);
    }

    private boolean handleCallDeflectionIncallSupplementaryService(String s) throws CallStateException {
        boolean flag = true;
        if(s.length() <= flag) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        if(getRingingCall().getState() != com.android.internal.telephony.Call.State.IDLE) {
            Log.d("GSM", "MmiCode 0: rejectCall");
            try {
                mCT.rejectCall();
            }
            catch(CallStateException callstateexception) {
                Log.d("GSM", "reject failed", callstateexception);
                notifySuppServiceFailed(com.android.internal.telephony.Phone.SuppService.REJECT);
            }
        } else
        if(getBackgroundCall().getState() != com.android.internal.telephony.Call.State.IDLE) {
            Log.d("GSM", "MmiCode 0: hangupWaitingOrBackground");
            mCT.hangupWaitingOrBackground();
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private boolean handleCallHoldIncallSupplementaryService(String s) throws CallStateException {
        boolean flag;
        int i;
        flag = true;
        i = s.length();
        if(i <= 2) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        GsmCall gsmcall;
        gsmcall = getForegroundCall();
        if(i <= flag)
            break MISSING_BLOCK_LABEL_167;
        int j = -48 + s.charAt(1);
        GsmConnection gsmconnection = mCT.getConnectionByIndex(gsmcall, j);
        CallStateException callstateexception1;
        if(gsmconnection != null && j >= flag && j <= 7) {
            Log.d("GSM", (new StringBuilder()).append("MmiCode 2: separate call ").append(j).toString());
            mCT.separate(gsmconnection);
            continue; /* Loop/switch isn't completed */
        }
        try {
            Log.d("GSM", (new StringBuilder()).append("separate: invalid call index ").append(j).toString());
            notifySuppServiceFailed(com.android.internal.telephony.Phone.SuppService.SEPARATE);
        }
        // Misplaced declaration of an exception variable
        catch(CallStateException callstateexception1) {
            Log.d("GSM", "separate failed", callstateexception1);
            notifySuppServiceFailed(com.android.internal.telephony.Phone.SuppService.SEPARATE);
        }
        continue; /* Loop/switch isn't completed */
        CallStateException callstateexception;
        if(getRingingCall().getState() != com.android.internal.telephony.Call.State.IDLE) {
            Log.d("GSM", "MmiCode 2: accept ringing call");
            mCT.acceptCall();
            continue; /* Loop/switch isn't completed */
        }
        try {
            Log.d("GSM", "MmiCode 2: switchWaitingOrHoldingAndActive");
            mCT.switchWaitingOrHoldingAndActive();
        }
        // Misplaced declaration of an exception variable
        catch(CallStateException callstateexception) {
            Log.d("GSM", "switch failed", callstateexception);
            notifySuppServiceFailed(com.android.internal.telephony.Phone.SuppService.SWITCH);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private boolean handleCallWaitingIncallSupplementaryService(String s) throws CallStateException {
        boolean flag;
        int i;
        flag = true;
        i = s.length();
        if(i <= 2) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        GsmCall gsmcall;
        gsmcall = getForegroundCall();
        if(i <= flag)
            break MISSING_BLOCK_LABEL_114;
        CallStateException callstateexception;
        int j = -48 + s.charAt(1);
        if(j >= flag && j <= 7) {
            Log.d("GSM", (new StringBuilder()).append("MmiCode 1: hangupConnectionByIndex ").append(j).toString());
            mCT.hangupConnectionByIndex(gsmcall, j);
        }
        continue; /* Loop/switch isn't completed */
        try {
            if(gsmcall.getState() != com.android.internal.telephony.Call.State.IDLE) {
                Log.d("GSM", "MmiCode 1: hangup foreground");
                mCT.hangup(gsmcall);
            } else {
                Log.d("GSM", "MmiCode 1: switchWaitingOrHoldingAndActive");
                mCT.switchWaitingOrHoldingAndActive();
            }
        }
        // Misplaced declaration of an exception variable
        catch(CallStateException callstateexception) {
            Log.d("GSM", "hangup failed", callstateexception);
            notifySuppServiceFailed(com.android.internal.telephony.Phone.SuppService.HANGUP);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private boolean handleCcbsIncallSupplementaryService(String s) throws CallStateException {
        boolean flag = true;
        if(s.length() > flag) {
            flag = false;
        } else {
            Log.i("GSM", "MmiCode 5: CCBS not supported!");
            notifySuppServiceFailed(com.android.internal.telephony.Phone.SuppService.UNKNOWN);
        }
        return flag;
    }

    private void handleCfuQueryResult(CallForwardInfo acallforwardinfo[]) {
        boolean flag = false;
        if(acallforwardinfo != null && acallforwardinfo.length != 0) goto _L2; else goto _L1
_L1:
        super.mIccRecords.setVoiceCallForwardingFlag(1, false);
_L4:
        return;
_L2:
        int i = 0;
        int j = acallforwardinfo.length;
        do {
            if(i < j) {
label0:
                {
                    if((1 & acallforwardinfo[i].serviceClass) == 0)
                        break label0;
                    IccRecords iccrecords = super.mIccRecords;
                    if(acallforwardinfo[i].status == 1)
                        flag = true;
                    iccrecords.setVoiceCallForwardingFlag(1, flag);
                }
            }
            if(true)
                continue;
            i++;
        } while(true);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private boolean handleEctIncallSupplementaryService(String s) throws CallStateException {
        boolean flag = true;
        if(s.length() != flag) {
            flag = false;
        } else {
            Log.d("GSM", "MmiCode 4: explicit call transfer");
            try {
                explicitCallTransfer();
            }
            catch(CallStateException callstateexception) {
                Log.d("GSM", "transfer failed", callstateexception);
                notifySuppServiceFailed(com.android.internal.telephony.Phone.SuppService.TRANSFER);
            }
        }
        return flag;
    }

    private boolean handleMultipartyIncallSupplementaryService(String s) throws CallStateException {
        boolean flag = true;
        if(s.length() > flag) {
            flag = false;
        } else {
            Log.d("GSM", "MmiCode 3: merge calls");
            try {
                conference();
            }
            catch(CallStateException callstateexception) {
                Log.d("GSM", "conference failed", callstateexception);
                notifySuppServiceFailed(com.android.internal.telephony.Phone.SuppService.CONFERENCE);
            }
        }
        return flag;
    }

    private void handleSetSelectNetwork(AsyncResult asyncresult) {
        if(asyncresult.userObj instanceof NetworkSelectMessage) goto _L2; else goto _L1
_L1:
        Log.d("GSM", "unexpected result from user object.");
_L4:
        return;
_L2:
        NetworkSelectMessage networkselectmessage = (NetworkSelectMessage)asyncresult.userObj;
        if(networkselectmessage.message != null) {
            Log.d("GSM", "sending original message to recipient");
            AsyncResult.forMessage(networkselectmessage.message, asyncresult.result, asyncresult.exception);
            networkselectmessage.message.sendToTarget();
        }
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(getContext()).edit();
        editor.putString("network_selection_key", networkselectmessage.operatorNumeric);
        editor.putString("network_selection_name_key", networkselectmessage.operatorAlphaLong);
        if(!editor.commit())
            Log.e("GSM", "failed to commit network selection preference");
        if(true) goto _L4; else goto _L3
_L3:
    }

    private boolean isValidCommandInterfaceCFAction(int i) {
        i;
        JVM INSTR tableswitch 0 4: default 36
    //                   0 40
    //                   1 40
    //                   2 36
    //                   3 40
    //                   4 40;
           goto _L1 _L2 _L2 _L1 _L2 _L2
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = true;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private boolean isValidCommandInterfaceCFReason(int i) {
        i;
        JVM INSTR tableswitch 0 5: default 40
    //                   0 44
    //                   1 44
    //                   2 44
    //                   3 44
    //                   4 44
    //                   5 44;
           goto _L1 _L2 _L2 _L2 _L2 _L2 _L2
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = true;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void onIncomingUSSD(int i, String s) {
        int j = 1;
        boolean flag;
        GsmMmiCode gsmmmicode;
        int k;
        int l;
        if(i == j)
            flag = j;
        else
            flag = false;
        if(i == 0 || i == j)
            j = 0;
        gsmmmicode = null;
        k = 0;
        l = mPendingMMIs.size();
        do {
label0:
            {
                if(k < l) {
                    if(!((GsmMmiCode)mPendingMMIs.get(k)).isPendingUSSD())
                        break label0;
                    gsmmmicode = (GsmMmiCode)mPendingMMIs.get(k);
                }
                if(gsmmmicode != null) {
                    if(j != 0)
                        gsmmmicode.onUssdFinishedError();
                    else
                        gsmmmicode.onUssdFinished(s, flag);
                } else
                if(j == 0 && s != null)
                    onNetworkInitiatedUssd(GsmMmiCode.newNetworkInitiatedUssd(s, flag, this));
                return;
            }
            k++;
        } while(true);
    }

    private void onNetworkInitiatedUssd(GsmMmiCode gsmmmicode) {
        super.mMmiCompleteRegistrants.notifyRegistrants(new AsyncResult(null, gsmmmicode, null));
    }

    private void processIccRecordEvents(int i) {
        i;
        JVM INSTR tableswitch 0 1: default 24
    //                   0 32
    //                   1 25;
           goto _L1 _L2 _L3
_L1:
        return;
_L3:
        notifyCallForwardingIndicator();
        continue; /* Loop/switch isn't completed */
_L2:
        notifyMessageWaitingIndicator();
        if(true) goto _L1; else goto _L4
_L4:
    }

    private void registerForSimRecordEvents() {
        super.mIccRecords.registerForNetworkSelectionModeAutomatic(this, 28, null);
        super.mIccRecords.registerForNewSms(this, 29, null);
        super.mIccRecords.registerForRecordsEvents(this, 30, null);
        super.mIccRecords.registerForRecordsLoaded(this, 3, null);
    }

    private void setVmSimImsi(String s) {
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(getContext()).edit();
        editor.putString("vm_sim_imsi_key", s);
        editor.apply();
    }

    private void storeVoiceMailNumber(String s) {
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(getContext()).edit();
        editor.putString("vm_number_key", s);
        editor.apply();
        setVmSimImsi(getSubscriberId());
    }

    private void unregisterForSimRecordEvents() {
        super.mIccRecords.unregisterForNetworkSelectionModeAutomatic(this);
        super.mIccRecords.unregisterForNewSms(this);
        super.mIccRecords.unregisterForRecordsEvents(this);
        super.mIccRecords.unregisterForRecordsLoaded(this);
    }

    public void acceptCall() throws CallStateException {
        removeMessages(15);
        mCT.acceptCall();
    }

    public void activateCellBroadcastSms(int i, Message message) {
        Log.e("GSM", "[GSMPhone] activateCellBroadcastSms() is obsolete; use SmsManager");
        message.sendToTarget();
    }

    public boolean canConference() {
        return mCT.canConference();
    }

    public boolean canDial() {
        return mCT.canDial();
    }

    public boolean canTransfer() {
        return mCT.canTransfer();
    }

    public void clearDisconnected() {
        mCT.clearDisconnected();
    }

    public void conference() throws CallStateException {
        mCT.conference();
    }

    public Connection dial(String s) throws CallStateException {
        return dial(s, null);
    }

    public Connection dial(String s, UUSInfo uusinfo) throws CallStateException {
        Connection connection = null;
        String s1 = PhoneNumberUtils.stripSeparators(s);
        if(!handleInCallMmiCommands(s1)) {
            GsmMmiCode gsmmmicode = GsmMmiCode.newFromDialString(PhoneNumberUtils.extractNetworkPortionAlt(s1), this);
            Log.d("GSM", (new StringBuilder()).append("dialing w/ mmi '").append(gsmmmicode).append("'...").toString());
            if(gsmmmicode == null)
                connection = mCT.dial(s1, uusinfo);
            else
            if(gsmmmicode.isTemporaryModeCLIR()) {
                connection = mCT.dial(gsmmmicode.dialingNumber, gsmmmicode.getCLIRMode(), uusinfo);
            } else {
                mPendingMMIs.add(gsmmmicode);
                super.mMmiRegistrants.notifyRegistrants(new AsyncResult(null, gsmmmicode, null));
                gsmmmicode.processCode();
            }
        }
        return connection;
    }

    public void disableLocationUpdates() {
        mSST.disableLocationUpdates();
    }

    public void dispose() {
        Object obj = PhoneProxy.lockForRadioTechnologyChange;
        obj;
        JVM INSTR monitorenter ;
        super.dispose();
        super.mCM.unregisterForAvailable(this);
        unregisterForSimRecordEvents();
        super.mCM.unregisterForOffOrNotAvailable(this);
        super.mCM.unregisterForOn(this);
        mSST.unregisterForNetworkAttached(this);
        super.mCM.unSetOnUSSD(this);
        super.mCM.unSetOnSuppServiceNotification(this);
        mPendingMMIs.clear();
        mCT.dispose();
        super.mDataConnectionTracker.dispose();
        mSST.dispose();
        mSimPhoneBookIntManager.dispose();
        mSimSmsIntManager.dispose();
        mSubInfo.dispose();
        return;
    }

    public void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        printwriter.println("GSMPhone extends:");
        super.dump(filedescriptor, printwriter, as);
        printwriter.println((new StringBuilder()).append(" mCT=").append(mCT).toString());
        printwriter.println((new StringBuilder()).append(" mSST=").append(mSST).toString());
        printwriter.println((new StringBuilder()).append(" mPendingMMIs=").append(mPendingMMIs).toString());
        printwriter.println((new StringBuilder()).append(" mSimPhoneBookIntManager=").append(mSimPhoneBookIntManager).toString());
        printwriter.println((new StringBuilder()).append(" mSimSmsIntManager=").append(mSimSmsIntManager).toString());
        printwriter.println((new StringBuilder()).append(" mSubInfo=").append(mSubInfo).toString());
        printwriter.println((new StringBuilder()).append(" mVmNumber=").append(mVmNumber).toString());
    }

    public void enableLocationUpdates() {
        mSST.enableLocationUpdates();
    }

    public void explicitCallTransfer() throws CallStateException {
        mCT.explicitCallTransfer();
    }

    protected void finalize() {
        Log.d("GSM", "GSMPhone finalized");
    }

    public void getAvailableNetworks(Message message) {
        super.mCM.getAvailableNetworks(message);
    }

    public volatile Call getBackgroundCall() {
        return getBackgroundCall();
    }

    public GsmCall getBackgroundCall() {
        return mCT.backgroundCall;
    }

    public void getCallForwardingOption(int i, Message message) {
        if(isValidCommandInterfaceCFReason(i)) {
            Log.d("GSM", "requesting call forwarding query.");
            Message message1;
            if(i == 0)
                message1 = obtainMessage(13, message);
            else
                message1 = message;
            super.mCM.queryCallForwardStatus(i, 0, null, message1);
        }
    }

    public CallTracker getCallTracker() {
        return mCT;
    }

    public void getCallWaiting(Message message) {
        super.mCM.queryCallWaiting(0, message);
    }

    public void getCellBroadcastSmsConfig(Message message) {
        Log.e("GSM", "[GSMPhone] getCellBroadcastSmsConfig() is obsolete; use SmsManager");
        message.sendToTarget();
    }

    public CellLocation getCellLocation() {
        return mSST.cellLoc;
    }

    public com.android.internal.telephony.Phone.DataActivityState getDataActivityState() {
        com.android.internal.telephony.Phone.DataActivityState dataactivitystate = com.android.internal.telephony.Phone.DataActivityState.NONE;
        if(mSST.getCurrentGprsState() != 0) goto _L2; else goto _L1
_L1:
        class _cls2 {

            static final int $SwitchMap$com$android$internal$telephony$DataConnectionTracker$Activity[];
            static final int $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[];

            static  {
                $SwitchMap$com$android$internal$telephony$DataConnectionTracker$Activity = new int[com.android.internal.telephony.DataConnectionTracker.Activity.values().length];
                NoSuchFieldError nosuchfielderror9;
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$Activity[com.android.internal.telephony.DataConnectionTracker.Activity.DATAIN.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$Activity[com.android.internal.telephony.DataConnectionTracker.Activity.DATAOUT.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror1) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$Activity[com.android.internal.telephony.DataConnectionTracker.Activity.DATAINANDOUT.ordinal()] = 3;
                }
                catch(NoSuchFieldError nosuchfielderror2) { }
                $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State = new int[com.android.internal.telephony.DataConnectionTracker.State.values().length];
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[com.android.internal.telephony.DataConnectionTracker.State.FAILED.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror3) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[com.android.internal.telephony.DataConnectionTracker.State.IDLE.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror4) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[com.android.internal.telephony.DataConnectionTracker.State.CONNECTED.ordinal()] = 3;
                }
                catch(NoSuchFieldError nosuchfielderror5) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[com.android.internal.telephony.DataConnectionTracker.State.DISCONNECTING.ordinal()] = 4;
                }
                catch(NoSuchFieldError nosuchfielderror6) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[com.android.internal.telephony.DataConnectionTracker.State.INITING.ordinal()] = 5;
                }
                catch(NoSuchFieldError nosuchfielderror7) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[com.android.internal.telephony.DataConnectionTracker.State.CONNECTING.ordinal()] = 6;
                }
                catch(NoSuchFieldError nosuchfielderror8) { }
                $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[com.android.internal.telephony.DataConnectionTracker.State.SCANNING.ordinal()] = 7;
_L2:
                return;
                nosuchfielderror9;
                if(true) goto _L2; else goto _L1
_L1:
            }
        }

        _cls2..SwitchMap.com.android.internal.telephony.DataConnectionTracker.Activity[super.mDataConnectionTracker.getActivity().ordinal()];
        JVM INSTR tableswitch 1 3: default 56
    //                   1 58
    //                   2 65
    //                   3 72;
           goto _L2 _L3 _L4 _L5
_L2:
        return dataactivitystate;
_L3:
        dataactivitystate = com.android.internal.telephony.Phone.DataActivityState.DATAIN;
        continue; /* Loop/switch isn't completed */
_L4:
        dataactivitystate = com.android.internal.telephony.Phone.DataActivityState.DATAOUT;
        continue; /* Loop/switch isn't completed */
_L5:
        dataactivitystate = com.android.internal.telephony.Phone.DataActivityState.DATAINANDOUT;
        if(true) goto _L2; else goto _L6
_L6:
    }

    public void getDataCallList(Message message) {
        super.mCM.getDataCallList(message);
    }

    public com.android.internal.telephony.Phone.DataState getDataConnectionState(String s) {
        com.android.internal.telephony.Phone.DataState datastate = com.android.internal.telephony.Phone.DataState.DISCONNECTED;
        if(mSST != null) goto _L2; else goto _L1
_L1:
        datastate = com.android.internal.telephony.Phone.DataState.DISCONNECTED;
_L4:
        return datastate;
_L2:
        if(mSST.getCurrentGprsState() != 0) {
            datastate = com.android.internal.telephony.Phone.DataState.DISCONNECTED;
            continue; /* Loop/switch isn't completed */
        }
        if(super.mDataConnectionTracker.isApnTypeEnabled(s) && super.mDataConnectionTracker.isApnTypeActive(s))
            break; /* Loop/switch isn't completed */
        datastate = com.android.internal.telephony.Phone.DataState.DISCONNECTED;
        if(true) goto _L4; else goto _L3
_L3:
        switch(_cls2..SwitchMap.com.android.internal.telephony.DataConnectionTracker.State[super.mDataConnectionTracker.getState(s).ordinal()]) {
        case 1: // '\001'
        case 2: // '\002'
            datastate = com.android.internal.telephony.Phone.DataState.DISCONNECTED;
            break;

        case 3: // '\003'
        case 4: // '\004'
            if(mCT.state != com.android.internal.telephony.Phone.State.IDLE && !mSST.isConcurrentVoiceAndDataAllowed())
                datastate = com.android.internal.telephony.Phone.DataState.SUSPENDED;
            else
                datastate = com.android.internal.telephony.Phone.DataState.CONNECTED;
            break;

        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
            datastate = com.android.internal.telephony.Phone.DataState.CONNECTING;
            break;
        }
        if(true) goto _L4; else goto _L5
_L5:
    }

    public boolean getDataRoamingEnabled() {
        return super.mDataConnectionTracker.getDataOnRoamingEnabled();
    }

    public String getDeviceId() {
        if(TextUtils.isEmpty(mImei) && !super.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony") && super.mContext.getPackageManager().hasSystemFeature("android.hardware.wifi")) {
            WifiInfo wifiinfo = ((WifiManager)super.mContext.getSystemService("wifi")).getConnectionInfo();
            if(wifiinfo != null)
                mImei = wifiinfo.getMacAddress();
        }
        return mImei;
    }

    public String getDeviceSvn() {
        return mImeiSv;
    }

    public String getEsn() {
        Log.e("GSM", "[GSMPhone] getEsn() is a CDMA method");
        return "0";
    }

    public volatile Call getForegroundCall() {
        return getForegroundCall();
    }

    public GsmCall getForegroundCall() {
        return mCT.foregroundCall;
    }

    public IccPhoneBookInterfaceManager getIccPhoneBookInterfaceManager() {
        return mSimPhoneBookIntManager;
    }

    public IccSmsInterfaceManager getIccSmsInterfaceManager() {
        return mSimSmsIntManager;
    }

    public String getImei() {
        return mImei;
    }

    public String getLine1AlphaTag() {
        return super.mIccRecords.getMsisdnAlphaTag();
    }

    public String getLine1Number() {
        return super.mIccRecords.getMsisdnNumber();
    }

    public String getMeid() {
        Log.e("GSM", "[GSMPhone] getMeid() is a CDMA method");
        return "0";
    }

    public String getMsisdn() {
        return super.mIccRecords.getMsisdnNumber();
    }

    public boolean getMute() {
        return mCT.getMute();
    }

    public void getNeighboringCids(Message message) {
        super.mCM.getNeighboringCids(message);
    }

    public void getOutgoingCallerIdDisplay(Message message) {
        super.mCM.getCLIR(message);
    }

    public List getPendingMmiCodes() {
        return mPendingMMIs;
    }

    public String getPhoneName() {
        return "GSM";
    }

    public PhoneSubInfo getPhoneSubInfo() {
        return mSubInfo;
    }

    public int getPhoneType() {
        return 1;
    }

    public volatile Call getRingingCall() {
        return getRingingCall();
    }

    public GsmCall getRingingCall() {
        return mCT.ringingCall;
    }

    public ServiceState getServiceState() {
        return ((ServiceStateTracker) (mSST)).ss;
    }

    public ServiceStateTracker getServiceStateTracker() {
        return mSST;
    }

    public SignalStrength getSignalStrength() {
        return ((ServiceStateTracker) (mSST)).mSignalStrength;
    }

    public com.android.internal.telephony.Phone.State getState() {
        return mCT.state;
    }

    public String getSubscriberId() {
        return super.mIccRecords.getIMSI();
    }

    public String getVoiceMailAlphaTag() {
        String s = super.mIccRecords.getVoiceMailAlphaTag();
        if(s == null || s.length() == 0)
            s = super.mContext.getText(0x1040004).toString();
        return s;
    }

    public String getVoiceMailNumber() {
        String s = super.mIccRecords.getVoiceMailNumber();
        if(TextUtils.isEmpty(s))
            s = PreferenceManager.getDefaultSharedPreferences(getContext()).getString("vm_number_key", null);
        return s;
    }

    public boolean handleInCallMmiCommands(String s) throws CallStateException {
        if(isInCall()) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        if(!TextUtils.isEmpty(s))
            break; /* Loop/switch isn't completed */
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
        flag = false;
        switch(s.charAt(0)) {
        case 48: // '0'
            flag = handleCallDeflectionIncallSupplementaryService(s);
            break;

        case 49: // '1'
            flag = handleCallWaitingIncallSupplementaryService(s);
            break;

        case 50: // '2'
            flag = handleCallHoldIncallSupplementaryService(s);
            break;

        case 51: // '3'
            flag = handleMultipartyIncallSupplementaryService(s);
            break;

        case 52: // '4'
            flag = handleEctIncallSupplementaryService(s);
            break;

        case 53: // '5'
            flag = handleCcbsIncallSupplementaryService(s);
            break;
        }
        if(true) goto _L4; else goto _L5
_L5:
    }

    public void handleMessage(Message message) {
        boolean flag = false;
        message.what;
        JVM INSTR tableswitch 1 30: default 140
    //                   1 146
    //                   2 495
    //                   3 201
    //                   4 140
    //                   5 145
    //                   6 251
    //                   7 380
    //                   8 437
    //                   9 316
    //                   10 348
    //                   11 140
    //                   12 525
    //                   13 680
    //                   14 140
    //                   15 140
    //                   16 822
    //                   17 822
    //                   18 836
    //                   19 194
    //                   20 604
    //                   21 140
    //                   22 140
    //                   23 140
    //                   24 140
    //                   25 140
    //                   26 140
    //                   27 140
    //                   28 779
    //                   29 751
    //                   30 799;
           goto _L1 _L2 _L3 _L4 _L1 _L5 _L6 _L7 _L8 _L9 _L10 _L1 _L11 _L12 _L1 _L1 _L13 _L13 _L14 _L15 _L16 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L17 _L18 _L19
_L5:
        break; /* Loop/switch isn't completed */
_L1:
        super.handleMessage(message);
_L21:
        return;
_L2:
        super.mCM.getBasebandVersion(obtainMessage(6));
        super.mCM.getIMEI(obtainMessage(9));
        super.mCM.getIMEISV(obtainMessage(10));
        continue; /* Loop/switch isn't completed */
_L15:
        syncClirSetting();
        continue; /* Loop/switch isn't completed */
_L4:
        updateCurrentCarrierInProvider();
        String s = getVmSimImsi();
        String s1 = getSubscriberId();
        if(s != null && s1 != null && !s1.equals(s)) {
            storeVoiceMailNumber(null);
            setVmSimImsi(null);
        }
        continue; /* Loop/switch isn't completed */
_L6:
        AsyncResult asyncresult8 = (AsyncResult)message.obj;
        if(asyncresult8.exception == null) {
            Log.d("GSM", (new StringBuilder()).append("Baseband version: ").append(asyncresult8.result).toString());
            setSystemProperty("gsm.version.baseband", (String)asyncresult8.result);
        }
        continue; /* Loop/switch isn't completed */
_L9:
        AsyncResult asyncresult7 = (AsyncResult)message.obj;
        if(asyncresult7.exception == null)
            mImei = (String)asyncresult7.result;
        continue; /* Loop/switch isn't completed */
_L10:
        AsyncResult asyncresult6 = (AsyncResult)message.obj;
        if(asyncresult6.exception == null)
            mImeiSv = (String)asyncresult6.result;
        continue; /* Loop/switch isn't completed */
_L7:
        String as[] = (String[])(String[])((AsyncResult)message.obj).result;
        if(as.length > 1)
            try {
                onIncomingUSSD(Integer.parseInt(as[0]), as[1]);
            }
            catch(NumberFormatException numberformatexception) {
                Log.w("GSM", "error parsing USSD");
            }
        continue; /* Loop/switch isn't completed */
_L8:
        int i = 0;
        int j = mPendingMMIs.size();
        while(i < j)  {
            if(((GsmMmiCode)mPendingMMIs.get(i)).isPendingUSSD())
                ((GsmMmiCode)mPendingMMIs.get(i)).onUssdFinishedError();
            i++;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        AsyncResult asyncresult5 = (AsyncResult)message.obj;
        (SuppServiceNotification)asyncresult5.result;
        mSsnRegistrants.notifyRegistrants(asyncresult5);
        continue; /* Loop/switch isn't completed */
_L11:
        AsyncResult asyncresult4 = (AsyncResult)message.obj;
        if(asyncresult4.exception == null) {
            IccRecords iccrecords = super.mIccRecords;
            if(message.arg1 == 1)
                flag = true;
            iccrecords.setVoiceCallForwardingFlag(1, flag);
        }
        Message message4 = (Message)asyncresult4.userObj;
        if(message4 != null) {
            AsyncResult.forMessage(message4, asyncresult4.result, asyncresult4.exception);
            message4.sendToTarget();
        }
        continue; /* Loop/switch isn't completed */
_L16:
        AsyncResult asyncresult3 = (AsyncResult)message.obj;
        if(com/android/internal/telephony/IccVmNotSupportedException.isInstance(asyncresult3.exception)) {
            storeVoiceMailNumber(mVmNumber);
            asyncresult3.exception = null;
        }
        Message message3 = (Message)asyncresult3.userObj;
        if(message3 != null) {
            AsyncResult.forMessage(message3, asyncresult3.result, asyncresult3.exception);
            message3.sendToTarget();
        }
        continue; /* Loop/switch isn't completed */
_L12:
        AsyncResult asyncresult2 = (AsyncResult)message.obj;
        if(asyncresult2.exception == null)
            handleCfuQueryResult((CallForwardInfo[])(CallForwardInfo[])asyncresult2.result);
        Message message2 = (Message)asyncresult2.userObj;
        if(message2 != null) {
            AsyncResult.forMessage(message2, asyncresult2.result, asyncresult2.exception);
            message2.sendToTarget();
        }
        continue; /* Loop/switch isn't completed */
_L18:
        AsyncResult asyncresult1 = (AsyncResult)message.obj;
        super.mSMS.dispatchMessage((SmsMessage)asyncresult1.result);
        continue; /* Loop/switch isn't completed */
_L17:
        setNetworkSelectionModeAutomatic((Message)((AsyncResult)message.obj).result);
        continue; /* Loop/switch isn't completed */
_L19:
        processIccRecordEvents(((Integer)((AsyncResult)message.obj).result).intValue());
        continue; /* Loop/switch isn't completed */
_L13:
        handleSetSelectNetwork((AsyncResult)message.obj);
        continue; /* Loop/switch isn't completed */
_L14:
        AsyncResult asyncresult = (AsyncResult)message.obj;
        if(asyncresult.exception == null)
            saveClirSetting(message.arg1);
        Message message1 = (Message)asyncresult.userObj;
        if(message1 != null) {
            AsyncResult.forMessage(message1, asyncresult.result, asyncresult.exception);
            message1.sendToTarget();
        }
        if(true) goto _L21; else goto _L20
_L20:
    }

    public boolean handlePinMmi(String s) {
        GsmMmiCode gsmmmicode = GsmMmiCode.newFromDialString(s, this);
        boolean flag;
        if(gsmmmicode != null && gsmmmicode.isPinCommand()) {
            mPendingMMIs.add(gsmmmicode);
            super.mMmiRegistrants.notifyRegistrants(new AsyncResult(null, gsmmmicode, null));
            gsmmmicode.processCode();
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    protected boolean isCfEnable(int i) {
        boolean flag = true;
        if(i != flag && i != 3)
            flag = false;
        return flag;
    }

    public boolean isCspPlmnEnabled() {
        return super.mIccRecords.isCspPlmnEnabled();
    }

    boolean isInCall() {
        com.android.internal.telephony.Call.State state = getForegroundCall().getState();
        com.android.internal.telephony.Call.State state1 = getBackgroundCall().getState();
        com.android.internal.telephony.Call.State state2 = getRingingCall().getState();
        boolean flag;
        if(state.isAlive() || state1.isAlive() || state2.isAlive())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void notifyCallForwardingIndicator() {
        super.mNotifier.notifyCallForwardingChanged(this);
    }

    void notifyDisconnect(Connection connection) {
        super.mDisconnectRegistrants.notifyResult(connection);
    }

    void notifyLocationChanged() {
        super.mNotifier.notifyCellLocation(this);
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

    void notifySignalStrength() {
        super.mNotifier.notifySignalStrength(this);
    }

    void notifySuppServiceFailed(com.android.internal.telephony.Phone.SuppService suppservice) {
        super.mSuppServiceFailedRegistrants.notifyResult(suppservice);
    }

    void notifyUnknownConnection() {
        super.mUnknownConnectionRegistrants.notifyResult(this);
    }

    void onMMIDone(GsmMmiCode gsmmmicode) {
        if(mPendingMMIs.remove(gsmmmicode) || gsmmmicode.isUssdRequest())
            super.mMmiCompleteRegistrants.notifyRegistrants(new AsyncResult(null, gsmmmicode, null));
    }

    public void registerForSuppServiceNotification(Handler handler, int i, Object obj) {
        mSsnRegistrants.addUnique(handler, i, obj);
        if(mSsnRegistrants.size() == 1)
            super.mCM.setSuppServiceNotifications(true, null);
    }

    public void rejectCall() throws CallStateException {
        mCT.rejectCall();
    }

    public void removeReferences() {
        Log.d("GSM", "removeReferences");
        super.mSimulatedRadioControl = null;
        mSimPhoneBookIntManager = null;
        mSimSmsIntManager = null;
        mSubInfo = null;
        mCT = null;
        mSST = null;
        super.removeReferences();
    }

    public void saveClirSetting(int i) {
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(getContext()).edit();
        editor.putInt("clir_key", i);
        if(!editor.commit())
            Log.e("GSM", "failed to commit CLIR preference");
    }

    public void selectNetworkManually(OperatorInfo operatorinfo, Message message) {
        NetworkSelectMessage networkselectmessage = new NetworkSelectMessage(null);
        networkselectmessage.message = message;
        networkselectmessage.operatorNumeric = operatorinfo.getOperatorNumeric();
        networkselectmessage.operatorAlphaLong = operatorinfo.getOperatorAlphaLong();
        Message message1 = obtainMessage(16, networkselectmessage);
        super.mCM.setNetworkSelectionModeManual(operatorinfo.getOperatorNumeric(), message1);
    }

    public void sendBurstDtmf(String s) {
        Log.e("GSM", "[GSMPhone] sendBurstDtmf() is a CDMA method");
    }

    public void sendDtmf(char c) {
        if(PhoneNumberUtils.is12Key(c)) goto _L2; else goto _L1
_L1:
        Log.e("GSM", (new StringBuilder()).append("sendDtmf called with invalid character '").append(c).append("'").toString());
_L4:
        return;
_L2:
        if(mCT.state == com.android.internal.telephony.Phone.State.OFFHOOK)
            super.mCM.sendDtmf(c, null);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void sendUssdResponse(String s) {
        GsmMmiCode gsmmmicode = GsmMmiCode.newFromUssdUserInput(s, this);
        mPendingMMIs.add(gsmmmicode);
        super.mMmiRegistrants.notifyRegistrants(new AsyncResult(null, gsmmmicode, null));
        gsmmmicode.sendUssd(s);
    }

    public void setCallForwardingOption(int i, int j, String s, int k, Message message) {
        if(isValidCommandInterfaceCFAction(i) && isValidCommandInterfaceCFReason(j)) {
            Message message1;
            if(j == 0) {
                int l;
                if(isCfEnable(i))
                    l = 1;
                else
                    l = 0;
                message1 = obtainMessage(12, l, 0, message);
            } else {
                message1 = message;
            }
            super.mCM.setCallForward(i, j, 1, s, k, message1);
        }
    }

    public void setCallWaiting(boolean flag, Message message) {
        super.mCM.setCallWaiting(flag, 1, message);
    }

    public void setCellBroadcastSmsConfig(int ai[], Message message) {
        Log.e("GSM", "[GSMPhone] setCellBroadcastSmsConfig() is obsolete; use SmsManager");
        message.sendToTarget();
    }

    public void setDataRoamingEnabled(boolean flag) {
        super.mDataConnectionTracker.setDataOnRoamingEnabled(flag);
    }

    public void setLine1Number(String s, String s1, Message message) {
        super.mIccRecords.setMsisdnNumber(s, s1, message);
    }

    public void setMute(boolean flag) {
        mCT.setMute(flag);
    }

    public void setNetworkSelectionModeAutomatic(Message message) {
        NetworkSelectMessage networkselectmessage = new NetworkSelectMessage(null);
        networkselectmessage.message = message;
        networkselectmessage.operatorNumeric = "";
        networkselectmessage.operatorAlphaLong = "";
        Message message1 = obtainMessage(17, networkselectmessage);
        Log.d("GSM", "wrapping and sending message to connect automatically");
        super.mCM.setNetworkSelectionModeAutomatic(message1);
    }

    public void setOnPostDialCharacter(Handler handler, int i, Object obj) {
        mPostDialHandler = new Registrant(handler, i, obj);
    }

    public void setOutgoingCallerIdDisplay(int i, Message message) {
        super.mCM.setCLIR(i, obtainMessage(18, i, 0, message));
    }

    public void setRadioPower(boolean flag) {
        mSST.setRadioPower(flag);
    }

    public final void setSystemProperty(String s, String s1) {
        super.setSystemProperty(s, s1);
    }

    public void setVoiceMailNumber(String s, String s1, Message message) {
        mVmNumber = s1;
        Message message1 = obtainMessage(20, 0, 0, message);
        super.mIccRecords.setVoiceMailNumber(s, mVmNumber, message1);
    }

    public void startDtmf(char c) {
        if(!PhoneNumberUtils.is12Key(c))
            Log.e("GSM", (new StringBuilder()).append("startDtmf called with invalid character '").append(c).append("'").toString());
        else
            super.mCM.startDtmf(c, null);
    }

    public void stopDtmf() {
        super.mCM.stopDtmf(null);
    }

    public void switchHoldingAndActive() throws CallStateException {
        mCT.switchWaitingOrHoldingAndActive();
    }

    protected void syncClirSetting() {
        int i = PreferenceManager.getDefaultSharedPreferences(getContext()).getInt("clir_key", -1);
        if(i >= 0)
            super.mCM.setCLIR(i, null);
    }

    public void unregisterForSuppServiceNotification(Handler handler) {
        mSsnRegistrants.remove(handler);
        if(mSsnRegistrants.size() == 0)
            super.mCM.setSuppServiceNotifications(false, null);
    }

    boolean updateCurrentCarrierInProvider() {
        if(super.mIccRecords == null) goto _L2; else goto _L1
_L1:
        Uri uri = Uri.withAppendedPath(android.provider.Telephony.Carriers.CONTENT_URI, "current");
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("numeric", super.mIccRecords.getOperatorNumeric());
        super.mContext.getContentResolver().insert(uri, contentvalues);
        boolean flag = true;
_L4:
        return flag;
        SQLException sqlexception;
        sqlexception;
        Log.e("GSM", "Can't store current operator", sqlexception);
_L2:
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void updateServiceLocation() {
        mSST.enableSingleLocationUpdate();
    }

    public static final String CIPHERING_KEY = "ciphering_key";
    private static final boolean LOCAL_DEBUG = true;
    static final String LOG_TAG = "GSM";
    private static final boolean VDBG = false;
    public static final String VM_NUMBER = "vm_number_key";
    public static final String VM_SIM_IMSI = "vm_sim_imsi_key";
    Thread debugPortThread;
    ServerSocket debugSocket;
    GsmCallTracker mCT;
    private String mImei;
    private String mImeiSv;
    ArrayList mPendingMMIs;
    Registrant mPostDialHandler;
    GsmServiceStateTracker mSST;
    SimPhoneBookInterfaceManager mSimPhoneBookIntManager;
    SimSmsInterfaceManager mSimSmsIntManager;
    RegistrantList mSsnRegistrants;
    PhoneSubInfo mSubInfo;
    private String mVmNumber;
}
