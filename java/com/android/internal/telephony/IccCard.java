// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.app.ActivityManagerNative;
import android.app.AlertDialog;
import android.content.*;
import android.content.res.Resources;
import android.os.*;
import android.util.Log;
import android.view.Window;
import com.android.internal.telephony.cat.CatService;
import com.android.internal.telephony.cdma.CDMALTEPhone;
import com.android.internal.telephony.cdma.CdmaLteUiccFileHandler;
import com.android.internal.telephony.cdma.CdmaLteUiccRecords;
import com.android.internal.telephony.cdma.CdmaSubscriptionSourceManager;
import com.android.internal.telephony.cdma.RuimFileHandler;
import com.android.internal.telephony.cdma.RuimRecords;
import com.android.internal.telephony.gsm.SIMFileHandler;
import com.android.internal.telephony.gsm.SIMRecords;

// Referenced classes of package com.android.internal.telephony:
//            PhoneBase, CommandsInterface, IccCardStatus, IccCardApplication, 
//            IccFileHandler, IccRecords

public class IccCard {
    public static final class State extends Enum {

        public static State valueOf(String s) {
            return (State)Enum.valueOf(com/android/internal/telephony/IccCard$State, s);
        }

        public static State[] values() {
            return (State[])$VALUES.clone();
        }

        public boolean iccCardExist() {
            boolean flag;
            if(this == PIN_REQUIRED || this == PUK_REQUIRED || this == NETWORK_LOCKED || this == READY || this == PERM_DISABLED)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public boolean isPinLocked() {
            boolean flag;
            if(this == PIN_REQUIRED || this == PUK_REQUIRED)
                flag = true;
            else
                flag = false;
            return flag;
        }

        private static final State $VALUES[];
        public static final State ABSENT;
        public static final State NETWORK_LOCKED;
        public static final State NOT_READY;
        public static final State PERM_DISABLED;
        public static final State PIN_REQUIRED;
        public static final State PUK_REQUIRED;
        public static final State READY;
        public static final State UNKNOWN;

        static  {
            UNKNOWN = new State("UNKNOWN", 0);
            ABSENT = new State("ABSENT", 1);
            PIN_REQUIRED = new State("PIN_REQUIRED", 2);
            PUK_REQUIRED = new State("PUK_REQUIRED", 3);
            NETWORK_LOCKED = new State("NETWORK_LOCKED", 4);
            READY = new State("READY", 5);
            NOT_READY = new State("NOT_READY", 6);
            PERM_DISABLED = new State("PERM_DISABLED", 7);
            State astate[] = new State[8];
            astate[0] = UNKNOWN;
            astate[1] = ABSENT;
            astate[2] = PIN_REQUIRED;
            astate[3] = PUK_REQUIRED;
            astate[4] = NETWORK_LOCKED;
            astate[5] = READY;
            astate[6] = NOT_READY;
            astate[7] = PERM_DISABLED;
            $VALUES = astate;
        }

        private State(String s, int i) {
            super(s, i);
        }
    }


    public IccCard(PhoneBase phonebase, String s, Boolean boolean1, Boolean boolean2) {
        mIccCardStatus = null;
        mState = null;
        is3gpp = true;
        isSubscriptionFromIccCard = true;
        mCdmaSSM = null;
        mAbsentRegistrants = new RegistrantList();
        mPinLockedRegistrants = new RegistrantList();
        mNetworkLockedRegistrants = new RegistrantList();
        mReadyRegistrants = new RegistrantList();
        mRuimReadyRegistrants = new RegistrantList();
        mIccPinLocked = true;
        mIccFdnEnabled = false;
        mHandler = new Handler() {

            public void handleMessage(Message message) {
                if(mPhone.mIsTheCurrentActivePhone) goto _L2; else goto _L1
_L1:
                Log.e(mLogTag, (new StringBuilder()).append("Received message ").append(message).append("[").append(message.what).append("] while being destroyed. Ignoring.").toString());
_L4:
                return;
_L2:
                switch(message.what) {
                default:
                    Log.e(mLogTag, (new StringBuilder()).append("[IccCard] Unknown Event ").append(message.what).toString());
                    break;

                case 3: // '\003'
                    mState = null;
                    updateStateProperty();
                    broadcastIccStateChangedIntent("NOT_READY", null);
                    break;

                case 16: // '\020'
                    if(!is3gpp)
                        handleCdmaSubscriptionSource();
                    mPhone.mCM.getIccCardStatus(obtainMessage(2));
                    break;

                case 15: // '\017'
                    handleCdmaSubscriptionSource();
                    break;

                case 6: // '\006'
                    if(isSubscriptionFromIccCard) {
                        mPhone.mCM.queryFacilityLock("SC", "", 7, obtainMessage(7));
                        mPhone.mCM.queryFacilityLock("FD", "", 7, obtainMessage(10));
                    }
                    break;

                case 1: // '\001'
                    mPhone.mCM.queryFacilityLock("SC", "", 7, obtainMessage(7));
                    break;

                case 2: // '\002'
                    AsyncResult asyncresult7 = (AsyncResult)message.obj;
                    getIccCardStatusDone(asyncresult7);
                    break;

                case 4: // '\004'
                    AsyncResult asyncresult6 = (AsyncResult)message.obj;
                    AsyncResult.forMessage((Message)asyncresult6.userObj).exception = asyncresult6.exception;
                    mPhone.mCM.getIccCardStatus(obtainMessage(5, asyncresult6.userObj));
                    break;

                case 5: // '\005'
                    AsyncResult asyncresult5 = (AsyncResult)message.obj;
                    getIccCardStatusDone(asyncresult5);
                    ((Message)asyncresult5.userObj).sendToTarget();
                    break;

                case 7: // '\007'
                    AsyncResult asyncresult4 = (AsyncResult)message.obj;
                    onQueryFacilityLock(asyncresult4);
                    break;

                case 10: // '\n'
                    AsyncResult asyncresult3 = (AsyncResult)message.obj;
                    onQueryFdnEnabled(asyncresult3);
                    break;

                case 8: // '\b'
                    AsyncResult asyncresult2 = (AsyncResult)message.obj;
                    if(asyncresult2.exception == null) {
                        mIccPinLocked = mDesiredPinLocked;
                        if(mDbg)
                            log((new StringBuilder()).append("EVENT_CHANGE_FACILITY_LOCK_DONE: mIccPinLocked= ").append(mIccPinLocked).toString());
                    } else {
                        Log.e(mLogTag, (new StringBuilder()).append("Error change facility lock with exception ").append(asyncresult2.exception).toString());
                    }
                    AsyncResult.forMessage((Message)asyncresult2.userObj).exception = asyncresult2.exception;
                    ((Message)asyncresult2.userObj).sendToTarget();
                    break;

                case 11: // '\013'
                    AsyncResult asyncresult1 = (AsyncResult)message.obj;
                    if(asyncresult1.exception == null) {
                        mIccFdnEnabled = mDesiredFdnEnabled;
                        if(mDbg)
                            log((new StringBuilder()).append("EVENT_CHANGE_FACILITY_FDN_DONE: mIccFdnEnabled=").append(mIccFdnEnabled).toString());
                    } else {
                        Log.e(mLogTag, (new StringBuilder()).append("Error change facility fdn with exception ").append(asyncresult1.exception).toString());
                    }
                    AsyncResult.forMessage((Message)asyncresult1.userObj).exception = asyncresult1.exception;
                    ((Message)asyncresult1.userObj).sendToTarget();
                    break;

                case 9: // '\t'
                    AsyncResult asyncresult = (AsyncResult)message.obj;
                    if(asyncresult.exception != null)
                        Log.e(mLogTag, (new StringBuilder()).append("Error in change sim password with exception").append(asyncresult.exception).toString());
                    AsyncResult.forMessage((Message)asyncresult.userObj).exception = asyncresult.exception;
                    ((Message)asyncresult.userObj).sendToTarget();
                    break;

                case 12: // '\f'
                    Log.d(mLogTag, "Received Event EVENT_ICC_STATUS_CHANGED");
                    mPhone.mCM.getIccCardStatus(obtainMessage(2));
                    break;

                case 13: // '\r'
                    onIccSwap(false);
                    break;

                case 14: // '\016'
                    onIccSwap(true);
                    break;
                }
                if(true) goto _L4; else goto _L3
_L3:
            }

            final IccCard this$0;

             {
                this$0 = IccCard.this;
                super();
            }
        };
        mLogTag = s;
        mDbg = boolean2.booleanValue();
        if(mDbg) {
            StringBuilder stringbuilder = (new StringBuilder()).append("[IccCard] Creating card type ");
            String s1;
            if(boolean1.booleanValue())
                s1 = "3gpp";
            else
                s1 = "3gpp2";
            log(stringbuilder.append(s1).toString());
        }
        mPhone = phonebase;
        is3gpp = boolean1.booleanValue();
        mCdmaSSM = CdmaSubscriptionSourceManager.getInstance(mPhone.getContext(), mPhone.mCM, mHandler, 15, null);
        if(phonebase.mCM.getLteOnCdmaMode() == 1 && (phonebase instanceof CDMALTEPhone)) {
            mIccFileHandler = new CdmaLteUiccFileHandler(this, "", mPhone.mCM);
            mIccRecords = new CdmaLteUiccRecords(this, mPhone.mContext, mPhone.mCM);
        } else {
            Object obj;
            Object obj1;
            if(boolean1.booleanValue())
                obj = new SIMFileHandler(this, "", mPhone.mCM);
            else
                obj = new RuimFileHandler(this, "", mPhone.mCM);
            mIccFileHandler = ((IccFileHandler) (obj));
            if(boolean1.booleanValue())
                obj1 = new SIMRecords(this, mPhone.mContext, mPhone.mCM);
            else
                obj1 = new RuimRecords(this, mPhone.mContext, mPhone.mCM);
            mIccRecords = ((IccRecords) (obj1));
        }
        mCatService = CatService.getInstance(mPhone.mCM, mIccRecords, mPhone.mContext, mIccFileHandler, this);
        mPhone.mCM.registerForOffOrNotAvailable(mHandler, 3, null);
        mPhone.mCM.registerForOn(mHandler, 16, null);
        mPhone.mCM.registerForIccStatusChanged(mHandler, 12, null);
    }

    private State getAppState(int i) {
        if(i >= 0 && i < 8) {
            IccCardApplication icccardapplication = mIccCardStatus.getApplication(i);
            State state;
            if(icccardapplication == null) {
                Log.e(mLogTag, "[IccCard] Subscription Application in not present");
                state = State.ABSENT;
            } else
            if(icccardapplication.pin1.isPermBlocked())
                state = State.PERM_DISABLED;
            else
            if(icccardapplication.app_state.isPinRequired())
                state = State.PIN_REQUIRED;
            else
            if(icccardapplication.app_state.isPukRequired())
                state = State.PUK_REQUIRED;
            else
            if(icccardapplication.app_state.isSubscriptionPersoEnabled())
                state = State.NETWORK_LOCKED;
            else
            if(icccardapplication.app_state.isAppReady())
                state = State.READY;
            else
            if(icccardapplication.app_state.isAppNotReady())
                state = State.NOT_READY;
            else
                state = State.NOT_READY;
        } else {
            Log.e(mLogTag, (new StringBuilder()).append("[IccCard] Invalid Subscription Application index:").append(i).toString());
            state = State.ABSENT;
        }
        return state;
    }

    private State getConsolidatedState(State state, State state1, State state2) {
        if(state1 != State.ABSENT) goto _L2; else goto _L1
_L1:
        return state;
_L2:
        if(state == State.ABSENT)
            state = state1;
        else
        if(state == State.READY && state1 == State.READY)
            state = State.READY;
        else
        if(state1 == State.NOT_READY && state == State.READY || state == State.NOT_READY && state1 == State.READY)
            state = State.NOT_READY;
        else
        if(state1 != State.NOT_READY)
            if(state == State.NOT_READY)
                state = state1;
            else
                state = state2;
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void getIccCardStatusDone(AsyncResult asyncresult) {
        if(asyncresult.exception != null)
            Log.e(mLogTag, "Error getting ICC status. RIL_REQUEST_GET_ICC_STATUS should never return an error", asyncresult.exception);
        else
            handleIccCardStatus((IccCardStatus)asyncresult.result);
    }

    private void handleCdmaSubscriptionSource() {
        if(mCdmaSSM != null) {
            int i = mCdmaSSM.getCdmaSubscriptionSource();
            Log.d(mLogTag, (new StringBuilder()).append("Received Cdma subscription source: ").append(i).toString());
            boolean flag;
            if(i == 0)
                flag = true;
            else
                flag = false;
            if(flag != isSubscriptionFromIccCard) {
                isSubscriptionFromIccCard = flag;
                handleIccCardStatus(mIccCardStatus);
            }
        }
    }

    private void handleIccCardStatus(IccCardStatus icccardstatus) {
        State state;
        State state1;
        State state2;
        state = getRuimState();
        state1 = mState;
        mIccCardStatus = icccardstatus;
        state2 = getIccCardState();
        Object obj = mStateMonitor;
        obj;
        JVM INSTR monitorenter ;
        mState = state2;
        updateStateProperty();
        if(state1 == State.READY || state2 != State.READY)
            break MISSING_BLOCK_LABEL_365;
        mHandler.sendMessage(mHandler.obtainMessage(6));
        mReadyRegistrants.notifyRegistrants();
_L1:
        if(state != State.READY && getRuimState() == State.READY)
            mRuimReadyRegistrants.notifyRegistrants();
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        if(state1 != State.PIN_REQUIRED && state2 == State.PIN_REQUIRED || state1 != State.PUK_REQUIRED && state2 == State.PUK_REQUIRED)
            flag = true;
        else
            flag = false;
        if(state1 != State.ABSENT && state2 == State.ABSENT)
            flag1 = true;
        else
            flag1 = false;
        if(state1 != State.NETWORK_LOCKED && state2 == State.NETWORK_LOCKED)
            flag2 = true;
        else
            flag2 = false;
        if(state1 != State.PERM_DISABLED && state2 == State.PERM_DISABLED)
            flag3 = true;
        else
            flag3 = false;
        if(state1 != null && state1.iccCardExist() && state2 == State.ABSENT)
            flag4 = true;
        else
            flag4 = false;
        if(state1 == State.ABSENT && state2 != null && state2.iccCardExist())
            flag5 = true;
        else
            flag5 = false;
        if(flag) {
            if(mDbg)
                log("Notify SIM pin or puk locked.");
            mPinLockedRegistrants.notifyRegistrants();
            Exception exception;
            String s;
            if(state2 == State.PIN_REQUIRED)
                s = "PIN";
            else
                s = "PUK";
            broadcastIccStateChangedIntent("LOCKED", s);
        } else
        if(flag1) {
            if(mDbg)
                log("Notify SIM missing.");
            mAbsentRegistrants.notifyRegistrants();
            broadcastIccStateChangedIntent("ABSENT", null);
        } else
        if(flag2) {
            if(mDbg)
                log("Notify SIM network locked.");
            mNetworkLockedRegistrants.notifyRegistrants();
            broadcastIccStateChangedIntent("LOCKED", "NETWORK");
        } else
        if(flag3) {
            if(mDbg)
                log("Notify SIM permanently disabled.");
            broadcastIccStateChangedIntent("ABSENT", "PERM_DISABLED");
        }
        if(flag4)
            mHandler.sendMessage(mHandler.obtainMessage(13, null));
        else
        if(flag5)
            mHandler.sendMessage(mHandler.obtainMessage(14, null));
        if(state1 != State.READY && state2 == State.READY && (is3gpp || isSubscriptionFromIccCard)) {
            if(!(mIccFileHandler instanceof CdmaLteUiccFileHandler))
                mIccFileHandler.setAid(getAid());
            mIccRecords.onReady();
        }
        return;
        if(state2.isPinLocked())
            mHandler.sendMessage(mHandler.obtainMessage(1));
          goto _L1
        exception;
        throw exception;
    }

    private void log(String s) {
        Log.d(mLogTag, (new StringBuilder()).append("[IccCard] ").append(s).toString());
    }

    private void onIccSwap(boolean flag) {
        android.content.DialogInterface.OnClickListener onclicklistener = new android.content.DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialoginterface, int i) {
                if(i == -1) {
                    if(mDbg)
                        log("Reboot due to SIM swap");
                    ((PowerManager)mPhone.getContext().getSystemService("power")).reboot("SIM is added.");
                }
            }

            final IccCard this$0;

             {
                this$0 = IccCard.this;
                super();
            }
        };
        Resources resources = Resources.getSystem();
        String s;
        String s1;
        String s2;
        AlertDialog alertdialog;
        if(flag)
            s = resources.getString(0x104041d);
        else
            s = resources.getString(0x104041a);
        if(flag)
            s1 = resources.getString(0x104041e);
        else
            s1 = resources.getString(0x104041b);
        s2 = resources.getString(0x104041f);
        alertdialog = (new android.app.AlertDialog.Builder(mPhone.getContext())).setTitle(s).setMessage(s1).setPositiveButton(s2, onclicklistener).create();
        alertdialog.getWindow().setType(2003);
        alertdialog.show();
    }

    private void onQueryFacilityLock(AsyncResult asyncresult) {
        if(asyncresult.exception == null) goto _L2; else goto _L1
_L1:
        if(mDbg)
            log((new StringBuilder()).append("Error in querying facility lock:").append(asyncresult.exception).toString());
_L4:
        return;
_L2:
        int ai[] = (int[])(int[])asyncresult.result;
        if(ai.length != 0) {
            boolean flag;
            if(ai[0] != 0)
                flag = true;
            else
                flag = false;
            mIccPinLocked = flag;
            if(mDbg)
                log((new StringBuilder()).append("Query facility lock : ").append(mIccPinLocked).toString());
        } else {
            Log.e(mLogTag, "[IccCard] Bogus facility lock response");
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void onQueryFdnEnabled(AsyncResult asyncresult) {
        if(asyncresult.exception == null) goto _L2; else goto _L1
_L1:
        if(mDbg)
            log((new StringBuilder()).append("Error in querying facility lock:").append(asyncresult.exception).toString());
_L4:
        return;
_L2:
        int ai[] = (int[])(int[])asyncresult.result;
        if(ai.length != 0) {
            boolean flag;
            if(ai[0] != 0)
                flag = true;
            else
                flag = false;
            mIccFdnEnabled = flag;
            if(mDbg)
                log((new StringBuilder()).append("Query facility lock : ").append(mIccFdnEnabled).toString());
        } else {
            Log.e(mLogTag, "[IccCard] Bogus facility lock response");
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void broadcastIccStateChangedIntent(String s, String s1) {
        Intent intent = new Intent("android.intent.action.SIM_STATE_CHANGED");
        intent.addFlags(0x20000000);
        intent.putExtra("phoneName", mPhone.getPhoneName());
        intent.putExtra("ss", s);
        intent.putExtra("reason", s1);
        if(mDbg)
            log((new StringBuilder()).append("Broadcasting intent ACTION_SIM_STATE_CHANGED ").append(s).append(" reason ").append(s1).toString());
        ActivityManagerNative.broadcastStickyIntent(intent, "android.permission.READ_PHONE_STATE");
    }

    public void changeIccFdnPassword(String s, String s1, Message message) {
        mPhone.mCM.changeIccPin2(s, s1, mHandler.obtainMessage(9, message));
    }

    public void changeIccLockPassword(String s, String s1, Message message) {
        mPhone.mCM.changeIccPin(s, s1, mHandler.obtainMessage(9, message));
    }

    public void dispose() {
        if(mDbg) {
            StringBuilder stringbuilder = (new StringBuilder()).append("[IccCard] Disposing card type ");
            String s;
            if(is3gpp)
                s = "3gpp";
            else
                s = "3gpp2";
            log(stringbuilder.append(s).toString());
        }
        mPhone.mCM.unregisterForIccStatusChanged(mHandler);
        mPhone.mCM.unregisterForOffOrNotAvailable(mHandler);
        mPhone.mCM.unregisterForOn(mHandler);
        mCatService.dispose();
        mCdmaSSM.dispose(mHandler);
        mIccRecords.dispose();
        mIccFileHandler.dispose();
    }

    protected void finalize() {
        if(mDbg) {
            StringBuilder stringbuilder = (new StringBuilder()).append("[IccCard] Finalized card type ");
            String s;
            if(is3gpp)
                s = "3gpp";
            else
                s = "3gpp2";
            log(stringbuilder.append(s).toString());
        }
    }

    public String getAid() {
        String s = "";
        String s1;
        if(mIccCardStatus == null) {
            s1 = s;
        } else {
            int i = getCurrentApplicationIndex();
            if(i >= 0 && i < 8) {
                IccCardApplication icccardapplication = mIccCardStatus.getApplication(i);
                if(icccardapplication != null)
                    s = icccardapplication.aid;
                else
                    Log.e(mLogTag, (new StringBuilder()).append("[IccCard] getAid: no current application index=").append(i).toString());
            } else {
                Log.e(mLogTag, (new StringBuilder()).append("[IccCard] getAid: Invalid Subscription Application index=").append(i).toString());
            }
            s1 = s;
        }
        return s1;
    }

    protected int getCurrentApplicationIndex() {
        int i;
        if(is3gpp)
            i = mIccCardStatus.getGsmUmtsSubscriptionAppIndex();
        else
            i = mIccCardStatus.getCdmaSubscriptionAppIndex();
        return i;
    }

    public State getIccCardState() {
        if(is3gpp || isSubscriptionFromIccCard) goto _L2; else goto _L1
_L1:
        State state = State.READY;
_L4:
        return state;
_L2:
        if(mIccCardStatus == null) {
            Log.e(mLogTag, "[IccCard] IccCardStatus is null");
            state = State.ABSENT;
        } else
        if(!mIccCardStatus.getCardState().isCardPresent()) {
            state = State.ABSENT;
        } else {
            CommandsInterface.RadioState radiostate = mPhone.mCM.getRadioState();
            if(radiostate == CommandsInterface.RadioState.RADIO_OFF || radiostate == CommandsInterface.RadioState.RADIO_UNAVAILABLE)
                state = State.NOT_READY;
            else
            if(radiostate == CommandsInterface.RadioState.RADIO_ON) {
                state = getAppState(mIccCardStatus.getCdmaSubscriptionAppIndex());
                State state1 = getAppState(mIccCardStatus.getGsmUmtsSubscriptionAppIndex());
                if(mDbg)
                    log((new StringBuilder()).append("USIM=").append(state1).append(" CSIM=").append(state).toString());
                if(mPhone.getLteOnCdmaMode() == 1)
                    state = getConsolidatedState(state, state1, state);
                else
                if(is3gpp)
                    state = state1;
            } else {
                state = State.ABSENT;
            }
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean getIccFdnEnabled() {
        return mIccFdnEnabled;
    }

    public IccFileHandler getIccFileHandler() {
        return mIccFileHandler;
    }

    public boolean getIccLockEnabled() {
        return mIccPinLocked;
    }

    public IccRecords getIccRecords() {
        return mIccRecords;
    }

    public State getRuimState() {
        State state;
        if(mIccCardStatus != null)
            state = getAppState(mIccCardStatus.getCdmaSubscriptionAppIndex());
        else
            state = State.UNKNOWN;
        return state;
    }

    public String getServiceProviderName() {
        return mPhone.mIccRecords.getServiceProviderName();
    }

    public State getState() {
        if(mState != null) goto _L2; else goto _L1
_L1:
        class _cls3 {

            static final int $SwitchMap$com$android$internal$telephony$CommandsInterface$RadioState[];

            static  {
                $SwitchMap$com$android$internal$telephony$CommandsInterface$RadioState = new int[CommandsInterface.RadioState.values().length];
                NoSuchFieldError nosuchfielderror1;
                try {
                    $SwitchMap$com$android$internal$telephony$CommandsInterface$RadioState[CommandsInterface.RadioState.RADIO_OFF.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror) { }
                $SwitchMap$com$android$internal$telephony$CommandsInterface$RadioState[CommandsInterface.RadioState.RADIO_UNAVAILABLE.ordinal()] = 2;
_L2:
                return;
                nosuchfielderror1;
                if(true) goto _L2; else goto _L1
_L1:
            }
        }

        _cls3..SwitchMap.com.android.internal.telephony.CommandsInterface.RadioState[mPhone.mCM.getRadioState().ordinal()];
        JVM INSTR tableswitch 1 2: default 48
    //                   1 68
    //                   2 68;
           goto _L3 _L4 _L4
_L3:
        State state;
        if(!is3gpp && !isSubscriptionFromIccCard)
            state = State.READY;
        else
            state = State.UNKNOWN;
_L6:
        return state;
_L4:
        state = State.UNKNOWN;
        continue; /* Loop/switch isn't completed */
_L2:
        state = mState;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public boolean hasIccCard() {
        boolean flag;
        if(mIccCardStatus == null)
            flag = false;
        else
            flag = mIccCardStatus.getCardState().isCardPresent();
        return flag;
    }

    public boolean isApplicationOnIcc(IccCardApplication.AppType apptype) {
        boolean flag = false;
        if(mIccCardStatus != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        int i = 0;
        do {
            if(i < mIccCardStatus.getNumApplications()) {
label0:
                {
                    IccCardApplication icccardapplication = mIccCardStatus.getApplication(i);
                    if(icccardapplication == null || icccardapplication.app_type != apptype)
                        break label0;
                    flag = true;
                }
            }
            if(true)
                continue;
            i++;
        } while(true);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void registerForAbsent(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mAbsentRegistrants.add(registrant);
        if(getState() == State.ABSENT)
            registrant.notifyRegistrant();
    }

    public void registerForLocked(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mPinLockedRegistrants.add(registrant);
        if(getState().isPinLocked())
            registrant.notifyRegistrant();
    }

    public void registerForNetworkLocked(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mNetworkLockedRegistrants.add(registrant);
        if(getState() == State.NETWORK_LOCKED)
            registrant.notifyRegistrant();
    }

    public void registerForReady(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        Object obj1 = mStateMonitor;
        obj1;
        JVM INSTR monitorenter ;
        mReadyRegistrants.add(registrant);
        if(getState() == State.READY)
            registrant.notifyRegistrant(new AsyncResult(null, null, null));
        return;
    }

    public void registerForRuimReady(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        Object obj1 = mStateMonitor;
        obj1;
        JVM INSTR monitorenter ;
        mRuimReadyRegistrants.add(registrant);
        if(getState() == State.READY && getRuimState() == State.READY)
            registrant.notifyRegistrant(new AsyncResult(null, null, null));
        return;
    }

    public void setIccFdnEnabled(boolean flag, String s, Message message) {
        mDesiredFdnEnabled = flag;
        mPhone.mCM.setFacilityLock("FD", flag, s, 15, mHandler.obtainMessage(11, message));
    }

    public void setIccLockEnabled(boolean flag, String s, Message message) {
        mDesiredPinLocked = flag;
        mPhone.mCM.setFacilityLock("SC", flag, s, 7, mHandler.obtainMessage(8, message));
    }

    public void supplyNetworkDepersonalization(String s, Message message) {
        mPhone.mCM.supplyNetworkDepersonalization(s, mHandler.obtainMessage(4, message));
    }

    public void supplyPin(String s, Message message) {
        mPhone.mCM.supplyIccPin(s, mHandler.obtainMessage(4, message));
    }

    public void supplyPin2(String s, Message message) {
        mPhone.mCM.supplyIccPin2(s, mHandler.obtainMessage(4, message));
    }

    public void supplyPuk(String s, String s1, Message message) {
        mPhone.mCM.supplyIccPuk(s, s1, mHandler.obtainMessage(4, message));
    }

    public void supplyPuk2(String s, String s1, Message message) {
        mPhone.mCM.supplyIccPuk2(s, s1, mHandler.obtainMessage(4, message));
    }

    public void unregisterForAbsent(Handler handler) {
        mAbsentRegistrants.remove(handler);
    }

    public void unregisterForLocked(Handler handler) {
        mPinLockedRegistrants.remove(handler);
    }

    public void unregisterForNetworkLocked(Handler handler) {
        mNetworkLockedRegistrants.remove(handler);
    }

    public void unregisterForReady(Handler handler) {
        Object obj = mStateMonitor;
        obj;
        JVM INSTR monitorenter ;
        mReadyRegistrants.remove(handler);
        return;
    }

    public void unregisterForRuimReady(Handler handler) {
        Object obj = mStateMonitor;
        obj;
        JVM INSTR monitorenter ;
        mRuimReadyRegistrants.remove(handler);
        return;
    }

    protected void updateStateProperty() {
        mPhone.setSystemProperty("gsm.sim.state", getState().toString());
    }

    public static final boolean CARD_IS_3GPP = true;
    public static final boolean CARD_IS_NOT_3GPP = false;
    private static final int EVENT_CARD_ADDED = 14;
    private static final int EVENT_CARD_REMOVED = 13;
    protected static final int EVENT_CDMA_SUBSCRIPTION_SOURCE_CHANGED = 15;
    private static final int EVENT_CHANGE_FACILITY_FDN_DONE = 11;
    private static final int EVENT_CHANGE_FACILITY_LOCK_DONE = 8;
    private static final int EVENT_CHANGE_ICC_PASSWORD_DONE = 9;
    private static final int EVENT_GET_ICC_STATUS_DONE = 2;
    protected static final int EVENT_ICC_LOCKED = 1;
    protected static final int EVENT_ICC_READY = 6;
    private static final int EVENT_ICC_STATUS_CHANGED = 12;
    private static final int EVENT_PINPUK_DONE = 4;
    private static final int EVENT_QUERY_FACILITY_FDN_DONE = 10;
    private static final int EVENT_QUERY_FACILITY_LOCK_DONE = 7;
    protected static final int EVENT_RADIO_OFF_OR_NOT_AVAILABLE = 3;
    protected static final int EVENT_RADIO_ON = 16;
    private static final int EVENT_REPOLL_STATUS_DONE = 5;
    public static final String INTENT_KEY_ICC_STATE = "ss";
    public static final String INTENT_KEY_LOCKED_REASON = "reason";
    public static final String INTENT_VALUE_ABSENT_ON_PERM_DISABLED = "PERM_DISABLED";
    public static final String INTENT_VALUE_ICC_ABSENT = "ABSENT";
    public static final String INTENT_VALUE_ICC_IMSI = "IMSI";
    public static final String INTENT_VALUE_ICC_LOADED = "LOADED";
    public static final String INTENT_VALUE_ICC_LOCKED = "LOCKED";
    public static final String INTENT_VALUE_ICC_NOT_READY = "NOT_READY";
    public static final String INTENT_VALUE_ICC_READY = "READY";
    public static final String INTENT_VALUE_LOCKED_NETWORK = "NETWORK";
    public static final String INTENT_VALUE_LOCKED_ON_PIN = "PIN";
    public static final String INTENT_VALUE_LOCKED_ON_PUK = "PUK";
    protected boolean is3gpp;
    protected boolean isSubscriptionFromIccCard;
    private RegistrantList mAbsentRegistrants;
    private CatService mCatService;
    protected CdmaSubscriptionSourceManager mCdmaSSM;
    protected boolean mDbg;
    private boolean mDesiredFdnEnabled;
    private boolean mDesiredPinLocked;
    protected Handler mHandler;
    protected IccCardStatus mIccCardStatus;
    private boolean mIccFdnEnabled;
    private IccFileHandler mIccFileHandler;
    private boolean mIccPinLocked;
    private IccRecords mIccRecords;
    protected String mLogTag;
    private RegistrantList mNetworkLockedRegistrants;
    protected PhoneBase mPhone;
    private RegistrantList mPinLockedRegistrants;
    protected RegistrantList mReadyRegistrants;
    protected RegistrantList mRuimReadyRegistrants;
    protected State mState;
    private final Object mStateMonitor = new Object();








/*
    static boolean access$502(IccCard icccard, boolean flag) {
        icccard.mIccPinLocked = flag;
        return flag;
    }

*/




/*
    static boolean access$702(IccCard icccard, boolean flag) {
        icccard.mIccFdnEnabled = flag;
        return flag;
    }

*/


}
