// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cdma;

import android.app.ActivityManagerNative;
import android.content.*;
import android.content.res.Resources;
import android.database.SQLException;
import android.net.Uri;
import android.os.*;
import android.preference.PreferenceManager;
import android.telephony.*;
import android.text.TextUtils;
import android.util.Log;
import com.android.internal.telephony.*;
import com.android.internal.telephony.uicc.UiccController;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.android.internal.telephony.cdma:
//            CdmaCallTracker, CdmaServiceStateTracker, CdmaSubscriptionSourceManager, RuimPhoneBookInterfaceManager, 
//            RuimSmsInterfaceManager, EriManager, CdmaMmiCode, CdmaSMSDispatcher, 
//            CdmaDataConnectionTracker, CdmaCall

public class CDMAPhone extends PhoneBase {

    public CDMAPhone(Context context, CommandsInterface commandsinterface, PhoneNotifier phonenotifier) {
        super(phonenotifier, context, commandsinterface, false);
        mVmNumber = null;
        mPendingMmis = new ArrayList();
        mCdmaSubscriptionSource = -1;
        mEriFileLoadedRegistrants = new RegistrantList();
        mEcmTimerResetRegistrants = new RegistrantList();
        initSstIcc();
        init(context, phonenotifier);
    }

    public CDMAPhone(Context context, CommandsInterface commandsinterface, PhoneNotifier phonenotifier, boolean flag) {
        super(phonenotifier, context, commandsinterface, flag);
        mVmNumber = null;
        mPendingMmis = new ArrayList();
        mCdmaSubscriptionSource = -1;
        mEriFileLoadedRegistrants = new RegistrantList();
        mEcmTimerResetRegistrants = new RegistrantList();
        initSstIcc();
        init(context, phonenotifier);
    }

    private static boolean checkOtaSpNumBasedOnSysSelCode(int i, String as[]) {
        boolean flag = false;
        int j;
        int k;
        j = Integer.parseInt(as[1]);
        k = 0;
_L6:
        if(k >= j) goto _L2; else goto _L1
_L1:
        if(TextUtils.isEmpty(as[k + 2]) || TextUtils.isEmpty(as[k + 3])) goto _L4; else goto _L3
_L3:
        int l;
        int i1;
        l = Integer.parseInt(as[k + 2]);
        i1 = Integer.parseInt(as[k + 3]);
        if(i < l || i > i1) goto _L4; else goto _L5
_L5:
        flag = true;
_L2:
        return flag;
_L4:
        k++;
          goto _L6
        NumberFormatException numberformatexception;
        numberformatexception;
        Log.e("CDMA", "checkOtaSpNumBasedOnSysSelCode, error", numberformatexception);
          goto _L2
    }

    private static int extractSelCodeFromOtaSpNum(String s) {
        int i = s.length();
        int j = -1;
        if(s.regionMatches(0, "*228", 0, 4) && i >= 6)
            j = Integer.parseInt(s.substring(4, 6));
        Log.d("CDMA", (new StringBuilder()).append("extractSelCodeFromOtaSpNum ").append(j).toString());
        return j;
    }

    private void handleCdmaSubscriptionSource(int i) {
        if(i != mCdmaSubscriptionSource) {
            mCdmaSubscriptionSource = i;
            if(i == 1)
                sendMessage(obtainMessage(23));
        }
    }

    private void handleEnterEmergencyCallbackMode(Message message) {
        Log.d("CDMA", (new StringBuilder()).append("handleEnterEmergencyCallbackMode,mIsPhoneInEcmState= ").append(mIsPhoneInEcmState).toString());
        if(!mIsPhoneInEcmState) {
            mIsPhoneInEcmState = true;
            sendEmergencyCallbackModeChange();
            setSystemProperty("ril.cdma.inecmmode", "true");
            long l = SystemProperties.getLong("ro.cdma.ecmexittimer", 0x493e0L);
            postDelayed(mExitEcmRunnable, l);
            mWakeLock.acquire();
        }
    }

    private void handleExitEmergencyCallbackMode(Message message) {
        AsyncResult asyncresult = (AsyncResult)message.obj;
        Log.d("CDMA", (new StringBuilder()).append("handleExitEmergencyCallbackMode,ar.exception , mIsPhoneInEcmState ").append(asyncresult.exception).append(mIsPhoneInEcmState).toString());
        removeCallbacks(mExitEcmRunnable);
        if(mEcmExitRespRegistrant != null)
            mEcmExitRespRegistrant.notifyRegistrant(asyncresult);
        if(asyncresult.exception == null) {
            if(mIsPhoneInEcmState) {
                mIsPhoneInEcmState = false;
                setSystemProperty("ril.cdma.inecmmode", "false");
            }
            sendEmergencyCallbackModeChange();
            super.mDataConnectionTracker.setInternalDataEnabled(true);
        }
    }

    private boolean isCarrierOtaSpNum(String s) {
        boolean flag = false;
        int i = extractSelCodeFromOtaSpNum(s);
        boolean flag1;
        if(i == -1) {
            flag1 = false;
        } else {
            if(!TextUtils.isEmpty(mCarrierOtaSpNumSchema)) {
                Matcher matcher = pOtaSpNumSchema.matcher(mCarrierOtaSpNumSchema);
                Log.d("CDMA", (new StringBuilder()).append("isCarrierOtaSpNum,schema").append(mCarrierOtaSpNumSchema).toString());
                if(matcher.find()) {
                    String as[] = pOtaSpNumSchema.split(mCarrierOtaSpNumSchema);
                    if(!TextUtils.isEmpty(as[0]) && as[0].equals("SELC")) {
                        if(i != -1)
                            flag = checkOtaSpNumBasedOnSysSelCode(i, as);
                        else
                            Log.d("CDMA", "isCarrierOtaSpNum,sysSelCodeInt is invalid");
                    } else
                    if(!TextUtils.isEmpty(as[0]) && as[0].equals("FC")) {
                        int j = Integer.parseInt(as[1]);
                        if(s.regionMatches(0, as[2], 0, j))
                            flag = true;
                        else
                            Log.d("CDMA", "isCarrierOtaSpNum,not otasp number");
                    } else {
                        Log.d("CDMA", (new StringBuilder()).append("isCarrierOtaSpNum,ota schema not supported").append(as[0]).toString());
                    }
                } else {
                    Log.d("CDMA", (new StringBuilder()).append("isCarrierOtaSpNum,ota schema pattern not right").append(mCarrierOtaSpNumSchema).toString());
                }
            } else {
                Log.d("CDMA", "isCarrierOtaSpNum,ota schema pattern empty");
            }
            flag1 = flag;
        }
        return flag1;
    }

    private static boolean isIs683OtaSpDialStr(String s) {
        boolean flag = false;
        if(s.length() != 4) goto _L2; else goto _L1
_L1:
        if(s.equals("*228"))
            flag = true;
_L4:
        return flag;
_L2:
        switch(extractSelCodeFromOtaSpNum(s)) {
        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
            flag = true;
            break;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void processIccRecordEvents(int i) {
        i;
        JVM INSTR tableswitch 0 0: default 20
    //                   0 47;
           goto _L1 _L2
_L1:
        Log.e("CDMA", (new StringBuilder()).append("Unknown icc records event code ").append(i).toString());
_L4:
        return;
_L2:
        notifyMessageWaitingIndicator();
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void registerForRuimRecordEvents() {
        super.mIccRecords.registerForRecordsEvents(this, 30, null);
        super.mIccRecords.registerForRecordsLoaded(this, 22, null);
    }

    private void setIsoCountryProperty(String s) {
        if(!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        setSystemProperty("gsm.sim.operator.iso-country", "");
_L4:
        return;
_L2:
        String s1 = "";
        String s2 = MccTable.countryCodeForMcc(Integer.parseInt(s.substring(0, 3)));
        s1 = s2;
_L5:
        setSystemProperty("gsm.sim.operator.iso-country", s1);
        if(true) goto _L4; else goto _L3
_L3:
        NumberFormatException numberformatexception;
        numberformatexception;
        Log.w("CDMA", (new StringBuilder()).append("countryCodeForMcc error").append(numberformatexception).toString());
          goto _L5
        StringIndexOutOfBoundsException stringindexoutofboundsexception;
        stringindexoutofboundsexception;
        Log.w("CDMA", (new StringBuilder()).append("countryCodeForMcc error").append(stringindexoutofboundsexception).toString());
          goto _L5
    }

    private void storeVoiceMailNumber(String s) {
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(getContext()).edit();
        editor.putString("vm_number_key_cdma", s);
        editor.apply();
    }

    private void unregisterForRuimRecordEvents() {
        super.mIccRecords.unregisterForRecordsEvents(this);
        super.mIccRecords.unregisterForRecordsLoaded(this);
    }

    public void acceptCall() throws CallStateException {
        mCT.acceptCall();
    }

    public void activateCellBroadcastSms(int i, Message message) {
        Log.e("CDMA", "[CDMAPhone] activateCellBroadcastSms() is obsolete; use SmsManager");
        message.sendToTarget();
    }

    public boolean canConference() {
        Log.e("CDMA", "canConference: not possible in CDMA");
        return false;
    }

    public boolean canTransfer() {
        Log.e("CDMA", "canTransfer: not possible in CDMA");
        return false;
    }

    public void clearDisconnected() {
        mCT.clearDisconnected();
    }

    public void conference() throws CallStateException {
        Log.e("CDMA", "conference: not possible in CDMA");
    }

    public Connection dial(String s) throws CallStateException {
        String s1 = PhoneNumberUtils.stripSeparators(s);
        return mCT.dial(s1);
    }

    public Connection dial(String s, UUSInfo uusinfo) throws CallStateException {
        throw new CallStateException("Sending UUS information NOT supported in CDMA!");
    }

    public void disableLocationUpdates() {
        mSST.disableLocationUpdates();
    }

    public void dispose() {
        Object obj = PhoneProxy.lockForRadioTechnologyChange;
        obj;
        JVM INSTR monitorenter ;
        super.dispose();
        log("dispose");
        unregisterForRuimRecordEvents();
        super.mCM.unregisterForAvailable(this);
        super.mCM.unregisterForOffOrNotAvailable(this);
        super.mCM.unregisterForOn(this);
        mSST.unregisterForNetworkAttached(this);
        super.mCM.unSetOnSuppServiceNotification(this);
        removeCallbacks(mExitEcmRunnable);
        mPendingMmis.clear();
        mCT.dispose();
        super.mDataConnectionTracker.dispose();
        mSST.dispose();
        mCdmaSSM.dispose(this);
        super.mSMS.dispose();
        mRuimPhoneBookInterfaceManager.dispose();
        mRuimSmsInterfaceManager.dispose();
        mSubInfo.dispose();
        mEriManager.dispose();
        return;
    }

    public void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        printwriter.println("CDMAPhone extends:");
        super.dump(filedescriptor, printwriter, as);
        printwriter.println((new StringBuilder()).append(" mVmNumber=").append(mVmNumber).toString());
        printwriter.println((new StringBuilder()).append(" mCT=").append(mCT).toString());
        printwriter.println((new StringBuilder()).append(" mSST=").append(mSST).toString());
        printwriter.println((new StringBuilder()).append(" mCdmaSSM=").append(mCdmaSSM).toString());
        printwriter.println((new StringBuilder()).append(" mPendingMmis=").append(mPendingMmis).toString());
        printwriter.println((new StringBuilder()).append(" mRuimPhoneBookInterfaceManager=").append(mRuimPhoneBookInterfaceManager).toString());
        printwriter.println((new StringBuilder()).append(" mRuimSmsInterfaceManager=").append(mRuimSmsInterfaceManager).toString());
        printwriter.println((new StringBuilder()).append(" mCdmaSubscriptionSource=").append(mCdmaSubscriptionSource).toString());
        printwriter.println((new StringBuilder()).append(" mSubInfo=").append(mSubInfo).toString());
        printwriter.println((new StringBuilder()).append(" mEriManager=").append(mEriManager).toString());
        printwriter.println((new StringBuilder()).append(" mWakeLock=").append(mWakeLock).toString());
        printwriter.println((new StringBuilder()).append(" mIsPhoneInEcmState=").append(mIsPhoneInEcmState).toString());
        printwriter.println((new StringBuilder()).append(" mCarrierOtaSpNumSchema=").append(mCarrierOtaSpNumSchema).toString());
        printwriter.println((new StringBuilder()).append(" getCdmaEriIconIndex()=").append(getCdmaEriIconIndex()).toString());
        printwriter.println((new StringBuilder()).append(" getCdmaEriIconMode()=").append(getCdmaEriIconMode()).toString());
        printwriter.println((new StringBuilder()).append(" getCdmaEriText()=").append(getCdmaEriText()).toString());
        printwriter.println((new StringBuilder()).append(" isMinInfoReady()=").append(isMinInfoReady()).toString());
        printwriter.println((new StringBuilder()).append(" isCspPlmnEnabled()=").append(isCspPlmnEnabled()).toString());
    }

    public void enableEnhancedVoicePrivacy(boolean flag, Message message) {
        super.mCM.setPreferredVoicePrivacy(flag, message);
    }

    public void enableLocationUpdates() {
        mSST.enableLocationUpdates();
    }

    public void exitEmergencyCallbackMode() {
        if(mWakeLock.isHeld())
            mWakeLock.release();
        super.mCM.exitEmergencyCallbackMode(obtainMessage(26));
    }

    public void explicitCallTransfer() {
        Log.e("CDMA", "explicitCallTransfer: not possible in CDMA");
    }

    protected void finalize() {
        Log.d("CDMA", "CDMAPhone finalized");
        if(mWakeLock.isHeld()) {
            Log.e("CDMA", "UNEXPECTED; mWakeLock is held when finalizing.");
            mWakeLock.release();
        }
    }

    public void getAvailableNetworks(Message message) {
        Log.e("CDMA", "getAvailableNetworks: not possible in CDMA");
    }

    public volatile Call getBackgroundCall() {
        return getBackgroundCall();
    }

    public CdmaCall getBackgroundCall() {
        return mCT.backgroundCall;
    }

    public boolean getCallForwardingIndicator() {
        Log.e("CDMA", "getCallForwardingIndicator: not possible in CDMA");
        return false;
    }

    public void getCallForwardingOption(int i, Message message) {
        Log.e("CDMA", "getCallForwardingOption: not possible in CDMA");
    }

    public CallTracker getCallTracker() {
        return mCT;
    }

    public void getCallWaiting(Message message) {
        super.mCM.queryCallWaiting(1, message);
    }

    public int getCdmaEriIconIndex() {
        return getServiceState().getCdmaEriIconIndex();
    }

    public int getCdmaEriIconMode() {
        return getServiceState().getCdmaEriIconMode();
    }

    public String getCdmaEriText() {
        int i = getServiceState().getCdmaRoamingIndicator();
        int j = getServiceState().getCdmaDefaultRoamingIndicator();
        return mEriManager.getCdmaEriText(i, j);
    }

    public String getCdmaMin() {
        return mSST.getCdmaMin();
    }

    public String getCdmaPrlVersion() {
        return mSST.getPrlVersion();
    }

    public void getCellBroadcastSmsConfig(Message message) {
        Log.e("CDMA", "[CDMAPhone] getCellBroadcastSmsConfig() is obsolete; use SmsManager");
        message.sendToTarget();
    }

    public CellLocation getCellLocation() {
        return mSST.cellLoc;
    }

    public com.android.internal.telephony.Phone.DataActivityState getDataActivityState() {
        com.android.internal.telephony.Phone.DataActivityState dataactivitystate = com.android.internal.telephony.Phone.DataActivityState.NONE;
        if(mSST.getCurrentDataConnectionState() != 0) goto _L2; else goto _L1
_L1:
        class _cls2 {

            static final int $SwitchMap$com$android$internal$telephony$DataConnectionTracker$Activity[];
            static final int $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[];

            static  {
                $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State = new int[com.android.internal.telephony.DataConnectionTracker.State.values().length];
                NoSuchFieldError nosuchfielderror10;
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[com.android.internal.telephony.DataConnectionTracker.State.FAILED.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[com.android.internal.telephony.DataConnectionTracker.State.IDLE.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror1) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[com.android.internal.telephony.DataConnectionTracker.State.CONNECTED.ordinal()] = 3;
                }
                catch(NoSuchFieldError nosuchfielderror2) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[com.android.internal.telephony.DataConnectionTracker.State.DISCONNECTING.ordinal()] = 4;
                }
                catch(NoSuchFieldError nosuchfielderror3) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[com.android.internal.telephony.DataConnectionTracker.State.INITING.ordinal()] = 5;
                }
                catch(NoSuchFieldError nosuchfielderror4) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[com.android.internal.telephony.DataConnectionTracker.State.CONNECTING.ordinal()] = 6;
                }
                catch(NoSuchFieldError nosuchfielderror5) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[com.android.internal.telephony.DataConnectionTracker.State.SCANNING.ordinal()] = 7;
                }
                catch(NoSuchFieldError nosuchfielderror6) { }
                $SwitchMap$com$android$internal$telephony$DataConnectionTracker$Activity = new int[com.android.internal.telephony.DataConnectionTracker.Activity.values().length];
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$Activity[com.android.internal.telephony.DataConnectionTracker.Activity.DATAIN.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror7) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$Activity[com.android.internal.telephony.DataConnectionTracker.Activity.DATAOUT.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror8) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$Activity[com.android.internal.telephony.DataConnectionTracker.Activity.DATAINANDOUT.ordinal()] = 3;
                }
                catch(NoSuchFieldError nosuchfielderror9) { }
                $SwitchMap$com$android$internal$telephony$DataConnectionTracker$Activity[com.android.internal.telephony.DataConnectionTracker.Activity.DORMANT.ordinal()] = 4;
_L2:
                return;
                nosuchfielderror10;
                if(true) goto _L2; else goto _L1
_L1:
            }
        }

        _cls2..SwitchMap.com.android.internal.telephony.DataConnectionTracker.Activity[super.mDataConnectionTracker.getActivity().ordinal()];
        JVM INSTR tableswitch 1 4: default 60
    //                   1 62
    //                   2 69
    //                   3 76
    //                   4 83;
           goto _L2 _L3 _L4 _L5 _L6
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
        continue; /* Loop/switch isn't completed */
_L6:
        dataactivitystate = com.android.internal.telephony.Phone.DataActivityState.DORMANT;
        if(true) goto _L2; else goto _L7
_L7:
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
        log((new StringBuilder()).append("getDataConnectionState apnType=").append(s).append(" ret=").append(datastate).toString());
        return datastate;
_L2:
        if(mSST.getCurrentDataConnectionState() != 0) {
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
        String s = getMeid();
        if(s == null || s.matches("^0*$")) {
            Log.d("CDMA", "getDeviceId(): MEID is not initialized use ESN");
            s = getEsn();
        }
        return s;
    }

    public String getDeviceSvn() {
        Log.d("CDMA", "getDeviceSvn(): return 0");
        return "0";
    }

    public void getEnhancedVoicePrivacy(Message message) {
        super.mCM.getPreferredVoicePrivacy(message);
    }

    public String getEsn() {
        return mEsn;
    }

    public volatile Call getForegroundCall() {
        return getForegroundCall();
    }

    public CdmaCall getForegroundCall() {
        return mCT.foregroundCall;
    }

    public IccPhoneBookInterfaceManager getIccPhoneBookInterfaceManager() {
        return mRuimPhoneBookInterfaceManager;
    }

    public IccSmsInterfaceManager getIccSmsInterfaceManager() {
        return mRuimSmsInterfaceManager;
    }

    public String getImei() {
        Log.e("CDMA", "IMEI is not available in CDMA");
        return null;
    }

    public String getLine1AlphaTag() {
        Log.e("CDMA", "getLine1AlphaTag: not possible in CDMA");
        return null;
    }

    public String getLine1Number() {
        return mSST.getMdnNumber();
    }

    public String getMeid() {
        return mMeid;
    }

    public boolean getMessageWaitingIndicator() {
        boolean flag;
        if(getVoiceMessageCount() > 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean getMute() {
        return mCT.getMute();
    }

    public void getNeighboringCids(Message message) {
        if(message != null) {
            CommandException commandexception = new CommandException(com.android.internal.telephony.CommandException.Error.REQUEST_NOT_SUPPORTED);
            AsyncResult.forMessage(message).exception = commandexception;
            message.sendToTarget();
        }
    }

    public void getOutgoingCallerIdDisplay(Message message) {
        Log.e("CDMA", "getOutgoingCallerIdDisplay: not possible in CDMA");
    }

    public List getPendingMmiCodes() {
        return mPendingMmis;
    }

    public String getPhoneName() {
        return "CDMA";
    }

    public PhoneSubInfo getPhoneSubInfo() {
        return mSubInfo;
    }

    public int getPhoneType() {
        return 2;
    }

    public volatile Call getRingingCall() {
        return getRingingCall();
    }

    public CdmaCall getRingingCall() {
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
        return mSST.getImsi();
    }

    public String getVoiceMailAlphaTag() {
        String s = "";
        if(s == null || s.length() == 0)
            s = super.mContext.getText(0x1040004).toString();
        return s;
    }

    public String getVoiceMailNumber() {
        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String s;
        if(getContext().getResources().getBoolean(0x111002f))
            s = sharedpreferences.getString("vm_number_key_cdma", getLine1Number());
        else
            s = sharedpreferences.getString("vm_number_key_cdma", "*86");
        return s;
    }

    public int getVoiceMessageCount() {
        int i = super.mIccRecords.getVoiceMessageCount();
        if(i == 0)
            i = PreferenceManager.getDefaultSharedPreferences(getContext()).getInt("vm_count_key_cdma", 0);
        return i;
    }

    public boolean handleInCallMmiCommands(String s) {
        Log.e("CDMA", "method handleInCallMmiCommands is NOT supported in CDMA!");
        return false;
    }

    public void handleMessage(Message message) {
        message.what;
        JVM INSTR tableswitch 1 30: default 140
    //                   1 146
    //                   2 423
    //                   3 140
    //                   4 140
    //                   5 377
    //                   6 179
    //                   7 140
    //                   8 365
    //                   9 140
    //                   10 140
    //                   11 140
    //                   12 140
    //                   13 140
    //                   14 140
    //                   15 140
    //                   16 140
    //                   17 140
    //                   18 140
    //                   19 435
    //                   20 463
    //                   21 244
    //                   22 348
    //                   23 447
    //                   24 140
    //                   25 309
    //                   26 340
    //                   27 400
    //                   28 140
    //                   29 140
    //                   30 317;
           goto _L1 _L2 _L3 _L1 _L1 _L4 _L5 _L1 _L6 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L7 _L8 _L9 _L10 _L11 _L1 _L12 _L13 _L14 _L1 _L1 _L15
_L1:
        super.handleMessage(message);
_L17:
        return;
_L2:
        super.mCM.getBasebandVersion(obtainMessage(6));
        super.mCM.getDeviceIdentity(obtainMessage(21));
        continue; /* Loop/switch isn't completed */
_L5:
        AsyncResult asyncresult2 = (AsyncResult)message.obj;
        if(asyncresult2.exception == null) {
            Log.d("CDMA", (new StringBuilder()).append("Baseband version: ").append(asyncresult2.result).toString());
            setSystemProperty("gsm.version.baseband", (String)asyncresult2.result);
        }
        continue; /* Loop/switch isn't completed */
_L9:
        AsyncResult asyncresult1 = (AsyncResult)message.obj;
        if(asyncresult1.exception == null) {
            String as[] = (String[])(String[])asyncresult1.result;
            mImei = as[0];
            mImeiSv = as[1];
            mEsn = as[2];
            mMeid = as[3];
        }
        continue; /* Loop/switch isn't completed */
_L12:
        handleEnterEmergencyCallbackMode(message);
        continue; /* Loop/switch isn't completed */
_L15:
        processIccRecordEvents(((Integer)((AsyncResult)message.obj).result).intValue());
        continue; /* Loop/switch isn't completed */
_L13:
        handleExitEmergencyCallbackMode(message);
        continue; /* Loop/switch isn't completed */
_L10:
        Log.d("CDMA", "Event EVENT_RUIM_RECORDS_LOADED Received");
        updateCurrentCarrierInProvider();
        continue; /* Loop/switch isn't completed */
_L6:
        Log.d("CDMA", "Event EVENT_RADIO_OFF_OR_NOT_AVAILABLE Received");
        continue; /* Loop/switch isn't completed */
_L4:
        Log.d("CDMA", "Event EVENT_RADIO_ON Received");
        handleCdmaSubscriptionSource(mCdmaSSM.getCdmaSubscriptionSource());
        continue; /* Loop/switch isn't completed */
_L14:
        Log.d("CDMA", "EVENT_CDMA_SUBSCRIPTION_SOURCE_CHANGED");
        handleCdmaSubscriptionSource(mCdmaSSM.getCdmaSubscriptionSource());
        continue; /* Loop/switch isn't completed */
_L3:
        Log.d("CDMA", "Event EVENT_SSN Received");
        continue; /* Loop/switch isn't completed */
_L7:
        Log.d("CDMA", "Event EVENT_REGISTERED_TO_NETWORK Received");
        continue; /* Loop/switch isn't completed */
_L11:
        Log.d("CDMA", "Event EVENT_NV_READY Received");
        prepareEri();
        continue; /* Loop/switch isn't completed */
_L8:
        AsyncResult asyncresult = (AsyncResult)message.obj;
        if(com/android/internal/telephony/IccException.isInstance(asyncresult.exception)) {
            storeVoiceMailNumber(mVmNumber);
            asyncresult.exception = null;
        }
        Message message1 = (Message)asyncresult.userObj;
        if(message1 != null) {
            AsyncResult.forMessage(message1, asyncresult.result, asyncresult.exception);
            message1.sendToTarget();
        }
        if(true) goto _L17; else goto _L16
_L16:
    }

    public boolean handlePinMmi(String s) {
        boolean flag = false;
        CdmaMmiCode cdmammicode = CdmaMmiCode.newFromDialString(s, this);
        if(cdmammicode == null)
            Log.e("CDMA", "Mmi is NULL!");
        else
        if(cdmammicode.isPukCommand()) {
            mPendingMmis.add(cdmammicode);
            super.mMmiRegistrants.notifyRegistrants(new AsyncResult(null, cdmammicode, null));
            cdmammicode.processCode();
            flag = true;
        } else {
            Log.e("CDMA", "Unrecognized mmi!");
        }
        return flag;
    }

    void handleTimerInEmergencyCallbackMode(int i) {
        i;
        JVM INSTR tableswitch 0 1: default 24
    //                   0 72
    //                   1 51;
           goto _L1 _L2 _L3
_L1:
        Log.e("CDMA", (new StringBuilder()).append("handleTimerInEmergencyCallbackMode, unsupported action ").append(i).toString());
_L5:
        return;
_L3:
        removeCallbacks(mExitEcmRunnable);
        mEcmTimerResetRegistrants.notifyResult(Boolean.TRUE);
        continue; /* Loop/switch isn't completed */
_L2:
        long l = SystemProperties.getLong("ro.cdma.ecmexittimer", 0x493e0L);
        postDelayed(mExitEcmRunnable, l);
        mEcmTimerResetRegistrants.notifyResult(Boolean.FALSE);
        if(true) goto _L5; else goto _L4
_L4:
    }

    protected void init(Context context, PhoneNotifier phonenotifier) {
        super.mCM.setPhoneType(2);
        mCT = new CdmaCallTracker(this);
        mCdmaSSM = CdmaSubscriptionSourceManager.getInstance(context, super.mCM, this, 27, null);
        super.mSMS = new CdmaSMSDispatcher(this, super.mSmsStorageMonitor, super.mSmsUsageMonitor);
        super.mDataConnectionTracker = new CdmaDataConnectionTracker(this);
        mRuimPhoneBookInterfaceManager = new RuimPhoneBookInterfaceManager(this);
        mRuimSmsInterfaceManager = new RuimSmsInterfaceManager(this, super.mSMS);
        mSubInfo = new PhoneSubInfo(this);
        mEriManager = new EriManager(this, context, 0);
        super.mCM.registerForAvailable(this, 1, null);
        registerForRuimRecordEvents();
        super.mCM.registerForOffOrNotAvailable(this, 8, null);
        super.mCM.registerForOn(this, 5, null);
        super.mCM.setOnSuppServiceNotification(this, 2, null);
        mSST.registerForNetworkAttached(this, 19, null);
        super.mCM.setEmergencyCallbackMode(this, 25, null);
        mWakeLock = ((PowerManager)context.getSystemService("power")).newWakeLock(1, "CDMA");
        SystemProperties.set("gsm.current.phone-type", Integer.toString(2));
        mIsPhoneInEcmState = SystemProperties.get("ril.cdma.inecmmode", "false").equals("true");
        if(mIsPhoneInEcmState)
            super.mCM.exitEmergencyCallbackMode(obtainMessage(26));
        mCarrierOtaSpNumSchema = SystemProperties.get("ro.cdma.otaspnumschema", "");
        setSystemProperty("gsm.sim.operator.alpha", SystemProperties.get("ro.cdma.home.operator.alpha"));
        String s = SystemProperties.get(PROPERTY_CDMA_HOME_OPERATOR_NUMERIC);
        log((new StringBuilder()).append("CDMAPhone: init set 'gsm.sim.operator.numeric' to operator='").append(s).append("'").toString());
        setSystemProperty("gsm.sim.operator.numeric", s);
        setIsoCountryProperty(s);
        updateCurrentCarrierInProvider(s);
        phonenotifier.notifyMessageWaitingChanged(this);
    }

    protected void initSstIcc() {
        super.mIccCard.set(UiccController.getInstance(this).getIccCard());
        super.mIccRecords = ((IccCard)super.mIccCard.get()).getIccRecords();
        mSST = new CdmaServiceStateTracker(this);
    }

    public boolean isEriFileLoaded() {
        return mEriManager.isEriFileLoaded();
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

    public boolean isInEcm() {
        return mIsPhoneInEcmState;
    }

    public boolean isInEmergencyCall() {
        return mCT.isInEmergencyCall();
    }

    public boolean isMinInfoReady() {
        return mSST.isMinInfoReady();
    }

    public boolean isOtaSpNumber(String s) {
        boolean flag = false;
        String s1 = PhoneNumberUtils.extractNetworkPortionAlt(s);
        if(s1 != null) {
            flag = isIs683OtaSpDialStr(s1);
            if(!flag)
                flag = isCarrierOtaSpNum(s1);
        }
        Log.d("CDMA", (new StringBuilder()).append("isOtaSpNumber ").append(flag).toString());
        return flag;
    }

    protected void log(String s) {
        Log.d("CDMA", (new StringBuilder()).append("[CDMAPhone] ").append(s).toString());
    }

    public boolean needsOtaServiceProvisioning() {
        boolean flag;
        if(mSST.getOtasp() != 3)
            flag = true;
        else
            flag = false;
        return flag;
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

    void notifyUnknownConnection() {
        super.mUnknownConnectionRegistrants.notifyResult(this);
    }

    void onMMIDone(CdmaMmiCode cdmammicode) {
        if(mPendingMmis.remove(cdmammicode))
            super.mMmiCompleteRegistrants.notifyRegistrants(new AsyncResult(null, cdmammicode, null));
    }

    public void prepareEri() {
        mEriManager.loadEriFile();
        if(mEriManager.isEriFileLoaded()) {
            log("ERI read, notify registrants");
            mEriFileLoadedRegistrants.notifyRegistrants();
        }
    }

    public void registerForCallWaiting(Handler handler, int i, Object obj) {
        mCT.registerForCallWaiting(handler, i, obj);
    }

    public void registerForCdmaOtaStatusChange(Handler handler, int i, Object obj) {
        super.mCM.registerForCdmaOtaProvision(handler, i, obj);
    }

    public void registerForEcmTimerReset(Handler handler, int i, Object obj) {
        mEcmTimerResetRegistrants.addUnique(handler, i, obj);
    }

    public void registerForEriFileLoaded(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mEriFileLoadedRegistrants.add(registrant);
    }

    public void registerForSubscriptionInfoReady(Handler handler, int i, Object obj) {
        mSST.registerForSubscriptionInfoReady(handler, i, obj);
    }

    public void registerForSuppServiceNotification(Handler handler, int i, Object obj) {
        Log.e("CDMA", "method registerForSuppServiceNotification is NOT supported in CDMA!");
    }

    public void rejectCall() throws CallStateException {
        mCT.rejectCall();
    }

    public void removeReferences() {
        log("removeReferences");
        mRuimPhoneBookInterfaceManager = null;
        mRuimSmsInterfaceManager = null;
        mSubInfo = null;
        mCT = null;
        mSST = null;
        mEriManager = null;
        mExitEcmRunnable = null;
        super.removeReferences();
    }

    public void selectNetworkManually(OperatorInfo operatorinfo, Message message) {
        Log.e("CDMA", "selectNetworkManually: not possible in CDMA");
    }

    public void sendBurstDtmf(String s, int i, int j, Message message) {
        boolean flag = true;
        int k = 0;
        do {
label0:
            {
                if(k < s.length()) {
                    if(PhoneNumberUtils.is12Key(s.charAt(k)))
                        break label0;
                    Log.e("CDMA", (new StringBuilder()).append("sendDtmf called with invalid character '").append(s.charAt(k)).append("'").toString());
                    flag = false;
                }
                if(mCT.state == com.android.internal.telephony.Phone.State.OFFHOOK && flag)
                    super.mCM.sendBurstDtmf(s, i, j, message);
                return;
            }
            k++;
        } while(true);
    }

    public void sendDtmf(char c) {
        if(PhoneNumberUtils.is12Key(c)) goto _L2; else goto _L1
_L1:
        Log.e("CDMA", (new StringBuilder()).append("sendDtmf called with invalid character '").append(c).append("'").toString());
_L4:
        return;
_L2:
        if(mCT.state == com.android.internal.telephony.Phone.State.OFFHOOK)
            super.mCM.sendDtmf(c, null);
        if(true) goto _L4; else goto _L3
_L3:
    }

    void sendEmergencyCallbackModeChange() {
        Intent intent = new Intent("android.intent.action.EMERGENCY_CALLBACK_MODE_CHANGED");
        intent.putExtra("phoneinECMState", mIsPhoneInEcmState);
        ActivityManagerNative.broadcastStickyIntent(intent, null);
        Log.d("CDMA", "sendEmergencyCallbackModeChange");
    }

    public void sendUssdResponse(String s) {
        Log.e("CDMA", "sendUssdResponse: not possible in CDMA");
    }

    public void setCallForwardingOption(int i, int j, String s, int k, Message message) {
        Log.e("CDMA", "setCallForwardingOption: not possible in CDMA");
    }

    public void setCallWaiting(boolean flag, Message message) {
        Log.e("CDMA", "method setCallWaiting is NOT supported in CDMA!");
    }

    public void setCellBroadcastSmsConfig(int ai[], Message message) {
        Log.e("CDMA", "[CDMAPhone] setCellBroadcastSmsConfig() is obsolete; use SmsManager");
        message.sendToTarget();
    }

    public void setDataRoamingEnabled(boolean flag) {
        super.mDataConnectionTracker.setDataOnRoamingEnabled(flag);
    }

    public void setLine1Number(String s, String s1, Message message) {
        Log.e("CDMA", "setLine1Number: not possible in CDMA");
    }

    public void setMute(boolean flag) {
        mCT.setMute(flag);
    }

    public void setNetworkSelectionModeAutomatic(Message message) {
        Log.e("CDMA", "method setNetworkSelectionModeAutomatic is NOT supported in CDMA!");
    }

    public void setOnEcbModeExitResponse(Handler handler, int i, Object obj) {
        mEcmExitRespRegistrant = new Registrant(handler, i, obj);
    }

    public void setOnPostDialCharacter(Handler handler, int i, Object obj) {
        mPostDialHandler = new Registrant(handler, i, obj);
    }

    public void setOutgoingCallerIdDisplay(int i, Message message) {
        Log.e("CDMA", "setOutgoingCallerIdDisplay: not possible in CDMA");
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
            Log.e("CDMA", (new StringBuilder()).append("startDtmf called with invalid character '").append(c).append("'").toString());
        else
            super.mCM.startDtmf(c, null);
    }

    public void stopDtmf() {
        super.mCM.stopDtmf(null);
    }

    public void switchHoldingAndActive() throws CallStateException {
        mCT.switchWaitingOrHoldingAndActive();
    }

    public void unregisterForCallWaiting(Handler handler) {
        mCT.unregisterForCallWaiting(handler);
    }

    public void unregisterForCdmaOtaStatusChange(Handler handler) {
        super.mCM.unregisterForCdmaOtaProvision(handler);
    }

    public void unregisterForEcmTimerReset(Handler handler) {
        mEcmTimerResetRegistrants.remove(handler);
    }

    public void unregisterForEriFileLoaded(Handler handler) {
        mEriFileLoadedRegistrants.remove(handler);
    }

    public void unregisterForSubscriptionInfoReady(Handler handler) {
        mSST.unregisterForSubscriptionInfoReady(handler);
    }

    public void unregisterForSuppServiceNotification(Handler handler) {
        Log.e("CDMA", "method unregisterForSuppServiceNotification is NOT supported in CDMA!");
    }

    public void unsetOnEcbModeExitResponse(Handler handler) {
        mEcmExitRespRegistrant.clear();
    }

    boolean updateCurrentCarrierInProvider() {
        return true;
    }

    boolean updateCurrentCarrierInProvider(String s) {
        if(TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        Uri uri = Uri.withAppendedPath(android.provider.Telephony.Carriers.CONTENT_URI, "current");
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("numeric", s);
        log((new StringBuilder()).append("updateCurrentCarrierInProvider from system: numeric=").append(s).toString());
        getContext().getContentResolver().insert(uri, contentvalues);
        MccTable.updateMccMncConfiguration(super.mContext, s);
        boolean flag = true;
_L4:
        return flag;
        SQLException sqlexception;
        sqlexception;
        Log.e("CDMA", "Can't store current operator", sqlexception);
_L2:
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void updateServiceLocation() {
        mSST.enableSingleLocationUpdate();
    }

    static final int CANCEL_ECM_TIMER = 1;
    private static final boolean DBG = true;
    private static final int DEFAULT_ECM_EXIT_TIMER_VALUE = 0x493e0;
    private static final int INVALID_SYSTEM_SELECTION_CODE = -1;
    private static final String IS683A_FEATURE_CODE = "*228";
    private static final int IS683A_FEATURE_CODE_NUM_DIGITS = 4;
    private static final int IS683A_SYS_SEL_CODE_NUM_DIGITS = 2;
    private static final int IS683A_SYS_SEL_CODE_OFFSET = 4;
    private static final int IS683_CONST_1900MHZ_A_BLOCK = 2;
    private static final int IS683_CONST_1900MHZ_B_BLOCK = 3;
    private static final int IS683_CONST_1900MHZ_C_BLOCK = 4;
    private static final int IS683_CONST_1900MHZ_D_BLOCK = 5;
    private static final int IS683_CONST_1900MHZ_E_BLOCK = 6;
    private static final int IS683_CONST_1900MHZ_F_BLOCK = 7;
    private static final int IS683_CONST_800MHZ_A_BAND = 0;
    private static final int IS683_CONST_800MHZ_B_BAND = 1;
    static final String LOG_TAG = "CDMA";
    static String PROPERTY_CDMA_HOME_OPERATOR_NUMERIC = "ro.cdma.home.operator.numeric";
    static final int RESTART_ECM_TIMER = 0;
    private static final boolean VDBG = false;
    static final String VM_COUNT_CDMA = "vm_count_key_cdma";
    private static final String VM_NUMBER_CDMA = "vm_number_key_cdma";
    private static Pattern pOtaSpNumSchema = Pattern.compile("[,\\s]+");
    CdmaCallTracker mCT;
    private String mCarrierOtaSpNumSchema;
    CdmaSubscriptionSourceManager mCdmaSSM;
    int mCdmaSubscriptionSource;
    private Registrant mEcmExitRespRegistrant;
    private final RegistrantList mEcmTimerResetRegistrants;
    private final RegistrantList mEriFileLoadedRegistrants;
    EriManager mEriManager;
    private String mEsn;
    private Runnable mExitEcmRunnable = new Runnable() {

        public void run() {
            exitEmergencyCallbackMode();
        }

        final CDMAPhone this$0;

             {
                this$0 = CDMAPhone.this;
                super();
            }
    };
    protected String mImei;
    protected String mImeiSv;
    private boolean mIsPhoneInEcmState;
    private String mMeid;
    ArrayList mPendingMmis;
    Registrant mPostDialHandler;
    RuimPhoneBookInterfaceManager mRuimPhoneBookInterfaceManager;
    RuimSmsInterfaceManager mRuimSmsInterfaceManager;
    CdmaServiceStateTracker mSST;
    PhoneSubInfo mSubInfo;
    private String mVmNumber;
    android.os.PowerManager.WakeLock mWakeLock;

}
