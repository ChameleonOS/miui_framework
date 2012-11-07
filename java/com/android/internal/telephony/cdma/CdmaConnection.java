// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cdma;

import android.content.Context;
import android.os.*;
import android.telephony.PhoneNumberUtils;
import android.telephony.ServiceState;
import android.text.TextUtils;
import android.util.Log;
import com.android.internal.telephony.*;

// Referenced classes of package com.android.internal.telephony.cdma:
//            CdmaCallTracker, CdmaCall, CdmaCallWaitingNotification, CDMAPhone

public class CdmaConnection extends Connection {
    class MyHandler extends Handler {

        public void handleMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 1 4: default 36
        //                       1 37
        //                       2 37
        //                       3 37
        //                       4 47;
               goto _L1 _L2 _L2 _L2 _L3
_L1:
            return;
_L2:
            processNextPostDialChar();
            continue; /* Loop/switch isn't completed */
_L3:
            releaseWakeLock();
            if(true) goto _L1; else goto _L4
_L4:
        }

        final CdmaConnection this$0;

        MyHandler(Looper looper) {
            this$0 = CdmaConnection.this;
            super(looper);
        }
    }

    static class Injector {

        static String nullifyString(String s) {
            return null;
        }

        static void setPostDialState(CdmaConnection cdmaconnection, com.android.internal.telephony.Connection.PostDialState postdialstate) {
        }

        Injector() {
        }
    }


    CdmaConnection(Context context, DriverCall drivercall, CdmaCallTracker cdmacalltracker, int i) {
        cause = com.android.internal.telephony.Connection.DisconnectCause.NOT_DISCONNECTED;
        postDialState = com.android.internal.telephony.Connection.PostDialState.NOT_STARTED;
        numberPresentation = Connection.PRESENTATION_ALLOWED;
        cnapNamePresentation = Connection.PRESENTATION_ALLOWED;
        createWakeLock(context);
        acquireWakeLock();
        owner = cdmacalltracker;
        h = new MyHandler(owner.getLooper());
        address = drivercall.number;
        isIncoming = drivercall.isMT;
        createTime = System.currentTimeMillis();
        cnapName = drivercall.name;
        cnapNamePresentation = drivercall.namePresentation;
        numberPresentation = drivercall.numberPresentation;
        index = i;
        parent = parentFromDCState(drivercall.state);
        parent.attach(this, drivercall);
    }

    CdmaConnection(Context context, CdmaCallWaitingNotification cdmacallwaitingnotification, CdmaCallTracker cdmacalltracker, CdmaCall cdmacall) {
        cause = com.android.internal.telephony.Connection.DisconnectCause.NOT_DISCONNECTED;
        postDialState = com.android.internal.telephony.Connection.PostDialState.NOT_STARTED;
        numberPresentation = Connection.PRESENTATION_ALLOWED;
        cnapNamePresentation = Connection.PRESENTATION_ALLOWED;
        createWakeLock(context);
        acquireWakeLock();
        owner = cdmacalltracker;
        h = new MyHandler(owner.getLooper());
        address = cdmacallwaitingnotification.number;
        numberPresentation = cdmacallwaitingnotification.numberPresentation;
        cnapName = cdmacallwaitingnotification.name;
        cnapNamePresentation = cdmacallwaitingnotification.namePresentation;
        index = -1;
        isIncoming = true;
        createTime = System.currentTimeMillis();
        connectTime = 0L;
        parent = cdmacall;
        cdmacall.attachFake(this, com.android.internal.telephony.Call.State.WAITING);
    }

    CdmaConnection(Context context, String s, CdmaCallTracker cdmacalltracker, CdmaCall cdmacall) {
        cause = com.android.internal.telephony.Connection.DisconnectCause.NOT_DISCONNECTED;
        postDialState = com.android.internal.telephony.Connection.PostDialState.NOT_STARTED;
        numberPresentation = Connection.PRESENTATION_ALLOWED;
        cnapNamePresentation = Connection.PRESENTATION_ALLOWED;
        createWakeLock(context);
        acquireWakeLock();
        owner = cdmacalltracker;
        h = new MyHandler(owner.getLooper());
        dialString = s;
        Log.d("CDMA", (new StringBuilder()).append("[CDMAConn] CdmaConnection: dialString=").append(s).toString());
        String s1 = formatDialString(s);
        Log.d("CDMA", (new StringBuilder()).append("[CDMAConn] CdmaConnection:formated dialString=").append(s1).toString());
        address = PhoneNumberUtils.extractNetworkPortionAlt(s1);
        postDialString = PhoneNumberUtils.extractPostDialPortion(s1);
        index = -1;
        isIncoming = false;
        cnapName = null;
        cnapNamePresentation = Connection.PRESENTATION_ALLOWED;
        numberPresentation = Connection.PRESENTATION_ALLOWED;
        createTime = System.currentTimeMillis();
        if(cdmacall != null) {
            parent = cdmacall;
            if(cdmacall.state == com.android.internal.telephony.Call.State.ACTIVE)
                cdmacall.attachFake(this, com.android.internal.telephony.Call.State.ACTIVE);
            else
                cdmacall.attachFake(this, com.android.internal.telephony.Call.State.DIALING);
        }
    }

    private void acquireWakeLock() {
        log("acquireWakeLock");
        mPartialWakeLock.acquire();
    }

    private void createWakeLock(Context context) {
        mPartialWakeLock = ((PowerManager)context.getSystemService("power")).newWakeLock(1, "CDMA");
    }

    private void doDisconnect() {
        index = -1;
        disconnectTime = System.currentTimeMillis();
        duration = SystemClock.elapsedRealtime() - connectTimeReal;
        disconnected = true;
    }

    static boolean equalsHandlesNulls(Object obj, Object obj1) {
        boolean flag;
        if(obj == null) {
            if(obj1 == null)
                flag = true;
            else
                flag = false;
        } else {
            flag = obj.equals(obj1);
        }
        return flag;
    }

    private static int findNextPCharOrNonPOrNonWCharIndex(String s, int i) {
        boolean flag = isWait(s.charAt(i));
        int j = i + 1;
        int k = s.length();
        do {
label0:
            {
                if(j < k) {
                    char c = s.charAt(j);
                    if(isWait(c))
                        flag = true;
                    if(isWait(c) || isPause(c))
                        break label0;
                }
                if(j < k && j > i + 1 && !flag && isPause(s.charAt(i)))
                    j = i + 1;
                return j;
            }
            j++;
        } while(true);
    }

    private static char findPOrWCharToAppend(String s, int i, int j) {
        char c;
        if(isPause(s.charAt(i)))
            c = ',';
        else
            c = ';';
        if(j > i + 1)
            c = ';';
        return c;
    }

    public static String formatDialString(String s) {
        if(s != null) goto _L2; else goto _L1
_L1:
        String s1 = null;
_L4:
        return s1;
_L2:
        int i = s.length();
        StringBuilder stringbuilder = new StringBuilder();
        int j = 0;
        while(j < i)  {
            char c = s.charAt(j);
            if(isPause(c) || isWait(c)) {
                if(j < i - 1) {
                    int k = findNextPCharOrNonPOrNonWCharIndex(s, j);
                    if(k < i) {
                        stringbuilder.append(findPOrWCharToAppend(s, j, k));
                        if(k > j + 1)
                            j = k - 1;
                    } else
                    if(k == i)
                        j = i - 1;
                }
            } else {
                stringbuilder.append(c);
            }
            j++;
        }
        s1 = PhoneNumberUtils.cdmaCheckAndProcessPlusCode(stringbuilder.toString());
        if(true) goto _L4; else goto _L3
_L3:
    }

    private boolean isConnectingInOrOut() {
        boolean flag;
        if(parent == null || parent == owner.ringingCall || parent.state == com.android.internal.telephony.Call.State.DIALING || parent.state == com.android.internal.telephony.Call.State.ALERTING)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static boolean isPause(char c) {
        boolean flag;
        if(c == ',')
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static boolean isWait(char c) {
        boolean flag;
        if(c == ';')
            flag = true;
        else
            flag = false;
        return flag;
    }

    private void log(String s) {
        Log.d("CDMA", (new StringBuilder()).append("[CDMAConn] ").append(s).toString());
    }

    private void onStartedHolding() {
        holdingStartTime = SystemClock.elapsedRealtime();
    }

    private CdmaCall parentFromDCState(com.android.internal.telephony.DriverCall.State state) {
        class _cls1 {

            static final int $SwitchMap$com$android$internal$telephony$DriverCall$State[];

            static  {
                $SwitchMap$com$android$internal$telephony$DriverCall$State = new int[com.android.internal.telephony.DriverCall.State.values().length];
                NoSuchFieldError nosuchfielderror5;
                try {
                    $SwitchMap$com$android$internal$telephony$DriverCall$State[com.android.internal.telephony.DriverCall.State.ACTIVE.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DriverCall$State[com.android.internal.telephony.DriverCall.State.DIALING.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror1) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DriverCall$State[com.android.internal.telephony.DriverCall.State.ALERTING.ordinal()] = 3;
                }
                catch(NoSuchFieldError nosuchfielderror2) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DriverCall$State[com.android.internal.telephony.DriverCall.State.HOLDING.ordinal()] = 4;
                }
                catch(NoSuchFieldError nosuchfielderror3) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DriverCall$State[com.android.internal.telephony.DriverCall.State.INCOMING.ordinal()] = 5;
                }
                catch(NoSuchFieldError nosuchfielderror4) { }
                $SwitchMap$com$android$internal$telephony$DriverCall$State[com.android.internal.telephony.DriverCall.State.WAITING.ordinal()] = 6;
_L2:
                return;
                nosuchfielderror5;
                if(true) goto _L2; else goto _L1
_L1:
            }
        }

        _cls1..SwitchMap.com.android.internal.telephony.DriverCall.State[state.ordinal()];
        JVM INSTR tableswitch 1 6: default 48
    //                   1 76
    //                   2 76
    //                   3 76
    //                   4 86
    //                   5 97
    //                   6 97;
           goto _L1 _L2 _L2 _L2 _L3 _L4 _L4
_L1:
        throw new RuntimeException((new StringBuilder()).append("illegal call state: ").append(state).toString());
_L2:
        CdmaCall cdmacall = owner.foregroundCall;
_L6:
        return cdmacall;
_L3:
        cdmacall = owner.backgroundCall;
        continue; /* Loop/switch isn't completed */
_L4:
        cdmacall = owner.ringingCall;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private boolean processPostDialChar(char c) {
        boolean flag = true;
        if(PhoneNumberUtils.is12Key(c))
            ((CallTracker) (owner)).cm.sendDtmf(c, h.obtainMessage(flag));
        else
        if(c == ',') {
            Injector.setPostDialState(this, com.android.internal.telephony.Connection.PostDialState.PAUSE);
            h.sendMessageDelayed(h.obtainMessage(2), 2000L);
        } else
        if(c == ';')
            setPostDialState(com.android.internal.telephony.Connection.PostDialState.WAIT);
        else
        if(c == 'N')
            setPostDialState(com.android.internal.telephony.Connection.PostDialState.WILD);
        else
            flag = false;
        return flag;
    }

    private void releaseWakeLock() {
        android.os.PowerManager.WakeLock wakelock = mPartialWakeLock;
        wakelock;
        JVM INSTR monitorenter ;
        if(mPartialWakeLock.isHeld()) {
            log("releaseWakeLock");
            mPartialWakeLock.release();
        }
        return;
    }

    private void setPostDialState(com.android.internal.telephony.Connection.PostDialState postdialstate) {
        if(postdialstate != com.android.internal.telephony.Connection.PostDialState.STARTED && postdialstate != com.android.internal.telephony.Connection.PostDialState.PAUSE)
            break MISSING_BLOCK_LABEL_82;
        android.os.PowerManager.WakeLock wakelock = mPartialWakeLock;
        wakelock;
        JVM INSTR monitorenter ;
        if(!mPartialWakeLock.isHeld()) goto _L2; else goto _L1
_L1:
        h.removeMessages(4);
_L3:
        Message message = h.obtainMessage(4);
        h.sendMessageDelayed(message, 60000L);
_L4:
        postDialState = postdialstate;
        return;
_L2:
        acquireWakeLock();
          goto _L3
        Exception exception;
        exception;
        throw exception;
        h.removeMessages(4);
        releaseWakeLock();
          goto _L4
    }

    public void cancelPostDial() {
        setPostDialState(com.android.internal.telephony.Connection.PostDialState.CANCELLED);
    }

    boolean compareTo(DriverCall drivercall) {
        boolean flag = true;
        if(isIncoming || drivercall.isMT) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        String s = PhoneNumberUtils.stringFromStringAndTOA(drivercall.number, drivercall.TOA);
        if(isIncoming != drivercall.isMT || !equalsHandlesNulls(address, s))
            flag = false;
        if(true) goto _L1; else goto _L3
_L3:
    }

    com.android.internal.telephony.Connection.DisconnectCause disconnectCauseFromCode(int i) {
        i;
        JVM INSTR lookupswitch 15: default 132
    //                   17: 161
    //                   34: 168
    //                   68: 175
    //                   240: 182
    //                   241: 189
    //                   1000: 196
    //                   1001: 203
    //                   1002: 210
    //                   1003: 217
    //                   1004: 224
    //                   1005: 231
    //                   1006: 238
    //                   1007: 245
    //                   1008: 252
    //                   1009: 259;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16
_L1:
        CDMAPhone cdmaphone = owner.phone;
        int j = cdmaphone.getServiceState().getState();
        com.android.internal.telephony.Connection.DisconnectCause disconnectcause;
        if(j == 3)
            disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.POWER_OFF;
        else
        if(j == 1 || j == 2)
            disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.OUT_OF_SERVICE;
        else
        if(cdmaphone.mCdmaSubscriptionSource == 0 && cdmaphone.getIccCard().getState() != com.android.internal.telephony.IccCard.State.READY)
            disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.ICC_ERROR;
        else
        if(i == 16)
            disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.NORMAL;
        else
            disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.ERROR_UNSPECIFIED;
_L18:
        return disconnectcause;
_L2:
        disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.BUSY;
        continue; /* Loop/switch isn't completed */
_L3:
        disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.CONGESTION;
        continue; /* Loop/switch isn't completed */
_L4:
        disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.LIMIT_EXCEEDED;
        continue; /* Loop/switch isn't completed */
_L5:
        disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.CALL_BARRED;
        continue; /* Loop/switch isn't completed */
_L6:
        disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.FDN_BLOCKED;
        continue; /* Loop/switch isn't completed */
_L7:
        disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.CDMA_LOCKED_UNTIL_POWER_CYCLE;
        continue; /* Loop/switch isn't completed */
_L8:
        disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.CDMA_DROP;
        continue; /* Loop/switch isn't completed */
_L9:
        disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.CDMA_INTERCEPT;
        continue; /* Loop/switch isn't completed */
_L10:
        disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.CDMA_REORDER;
        continue; /* Loop/switch isn't completed */
_L11:
        disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.CDMA_SO_REJECT;
        continue; /* Loop/switch isn't completed */
_L12:
        disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.CDMA_RETRY_ORDER;
        continue; /* Loop/switch isn't completed */
_L13:
        disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.CDMA_ACCESS_FAILURE;
        continue; /* Loop/switch isn't completed */
_L14:
        disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.CDMA_PREEMPTED;
        continue; /* Loop/switch isn't completed */
_L15:
        disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.CDMA_NOT_EMERGENCY;
        continue; /* Loop/switch isn't completed */
_L16:
        disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.CDMA_ACCESS_BLOCKED;
        if(true) goto _L18; else goto _L17
_L17:
    }

    public void dispose() {
    }

    void fakeHoldBeforeDial() {
        if(parent != null)
            parent.detach(this);
        parent = owner.backgroundCall;
        parent.attachFake(this, com.android.internal.telephony.Call.State.HOLDING);
        onStartedHolding();
    }

    protected void finalize() {
        if(mPartialWakeLock.isHeld())
            Log.e("CDMA", "[CdmaConn] UNEXPECTED; mPartialWakeLock is held when finalizing.");
        releaseWakeLock();
    }

    public String getAddress() {
        return address;
    }

    int getCDMAIndex() throws CallStateException {
        if(index >= 0)
            return 1 + index;
        else
            throw new CallStateException("CDMA connection index not assigned");
    }

    public volatile Call getCall() {
        return getCall();
    }

    public CdmaCall getCall() {
        return parent;
    }

    public String getCnapName() {
        return cnapName;
    }

    public int getCnapNamePresentation() {
        return cnapNamePresentation;
    }

    public long getConnectTime() {
        return connectTime;
    }

    public long getCreateTime() {
        return createTime;
    }

    public com.android.internal.telephony.Connection.DisconnectCause getDisconnectCause() {
        return cause;
    }

    public long getDisconnectTime() {
        return disconnectTime;
    }

    public long getDurationMillis() {
        long l = 0L;
        if(connectTimeReal != l)
            if(duration == l)
                l = SystemClock.elapsedRealtime() - connectTimeReal;
            else
                l = duration;
        return l;
    }

    public long getHoldDurationMillis() {
        long l;
        if(getState() != com.android.internal.telephony.Call.State.HOLDING)
            l = 0L;
        else
            l = SystemClock.elapsedRealtime() - holdingStartTime;
        return l;
    }

    public int getNumberPresentation() {
        return numberPresentation;
    }

    public String getOrigDialString() {
        return dialString;
    }

    public com.android.internal.telephony.Connection.PostDialState getPostDialState() {
        return postDialState;
    }

    public String getRemainingPostDialString() {
        if(postDialState != com.android.internal.telephony.Connection.PostDialState.CANCELLED && postDialState != com.android.internal.telephony.Connection.PostDialState.COMPLETE && postDialString != null && postDialString.length() > nextPostDialChar) goto _L2; else goto _L1
_L1:
        String s = "";
_L4:
        return s;
_L2:
        s = postDialString.substring(nextPostDialChar);
        if(Injector.nullifyString(s) != null) {
            int i = s.indexOf(';');
            int j = s.indexOf(',');
            if(i > 0 && (i < j || j <= 0))
                s = s.substring(0, i);
            else
            if(j > 0)
                s = s.substring(0, j);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public com.android.internal.telephony.Call.State getState() {
        com.android.internal.telephony.Call.State state;
        if(disconnected)
            state = com.android.internal.telephony.Call.State.DISCONNECTED;
        else
            state = super.getState();
        return state;
    }

    public UUSInfo getUUSInfo() {
        return null;
    }

    public void hangup() throws CallStateException {
        if(!disconnected) {
            owner.hangup(this);
            return;
        } else {
            throw new CallStateException("disconnected");
        }
    }

    public boolean isIncoming() {
        return isIncoming;
    }

    void onConnectedInOrOut() {
        connectTime = System.currentTimeMillis();
        connectTimeReal = SystemClock.elapsedRealtime();
        duration = 0L;
        log((new StringBuilder()).append("onConnectedInOrOut: connectTime=").append(connectTime).toString());
        if(!isIncoming)
            processNextPostDialChar();
        else
            releaseWakeLock();
    }

    void onDisconnect(com.android.internal.telephony.Connection.DisconnectCause disconnectcause) {
        cause = disconnectcause;
        if(!disconnected) {
            doDisconnect();
            owner.phone.notifyDisconnect(this);
            if(parent != null)
                parent.connectionDisconnected(this);
        }
        releaseWakeLock();
    }

    void onHangupLocal() {
        cause = com.android.internal.telephony.Connection.DisconnectCause.LOCAL;
    }

    void onLocalDisconnect() {
        if(!disconnected) {
            doDisconnect();
            if(parent != null)
                parent.detach(this);
        }
        releaseWakeLock();
    }

    void onRemoteDisconnect(int i) {
        onDisconnect(disconnectCauseFromCode(i));
    }

    public void proceedAfterWaitChar() {
        if(postDialState != com.android.internal.telephony.Connection.PostDialState.WAIT) {
            Log.w("CDMA", (new StringBuilder()).append("CdmaConnection.proceedAfterWaitChar(): Expected getPostDialState() to be WAIT but was ").append(postDialState).toString());
        } else {
            setPostDialState(com.android.internal.telephony.Connection.PostDialState.STARTED);
            processNextPostDialChar();
        }
    }

    public void proceedAfterWildChar(String s) {
        if(postDialState != com.android.internal.telephony.Connection.PostDialState.WILD) {
            Log.w("CDMA", (new StringBuilder()).append("CdmaConnection.proceedAfterWaitChar(): Expected getPostDialState() to be WILD but was ").append(postDialState).toString());
        } else {
            setPostDialState(com.android.internal.telephony.Connection.PostDialState.STARTED);
            StringBuilder stringbuilder = new StringBuilder(s);
            stringbuilder.append(postDialString.substring(nextPostDialChar));
            postDialString = stringbuilder.toString();
            nextPostDialChar = 0;
            log((new StringBuilder()).append("proceedAfterWildChar: new postDialString is ").append(postDialString).toString());
            processNextPostDialChar();
        }
    }

    void processNextPostDialChar() {
        if(postDialState != com.android.internal.telephony.Connection.PostDialState.CANCELLED) goto _L2; else goto _L1
_L1:
        releaseWakeLock();
_L8:
        return;
_L2:
        if(postDialString != null && postDialString.length() > nextPostDialChar) goto _L4; else goto _L3
_L3:
        int i;
        setPostDialState(com.android.internal.telephony.Connection.PostDialState.COMPLETE);
        releaseWakeLock();
        i = 0;
_L6:
        Registrant registrant = owner.phone.mPostDialHandler;
        if(registrant != null) {
            Message message = registrant.messageForRegistrant();
            if(message != null) {
                com.android.internal.telephony.Connection.PostDialState postdialstate = postDialState;
                AsyncResult asyncresult = AsyncResult.forMessage(message);
                asyncresult.result = this;
                asyncresult.userObj = postdialstate;
                message.arg1 = i;
                message.sendToTarget();
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        setPostDialState(com.android.internal.telephony.Connection.PostDialState.STARTED);
        String s = postDialString;
        int j = nextPostDialChar;
        nextPostDialChar = j + 1;
        i = s.charAt(j);
        if(processPostDialChar(i)) goto _L6; else goto _L5
_L5:
        h.obtainMessage(3).sendToTarget();
        Log.e("CDMA", (new StringBuilder()).append("processNextPostDialChar: c=").append(i).append(" isn't valid!").toString());
        if(true) goto _L8; else goto _L7
_L7:
    }

    public void separate() throws CallStateException {
        if(!disconnected) {
            owner.separate(this);
            return;
        } else {
            throw new CallStateException("disconnected");
        }
    }

    boolean update(DriverCall drivercall) {
        boolean flag = false;
        boolean flag1 = isConnectingInOrOut();
        boolean flag2;
        CdmaCall cdmacall;
        boolean flag4;
        if(getState() == com.android.internal.telephony.Call.State.HOLDING)
            flag2 = true;
        else
            flag2 = false;
        cdmacall = parentFromDCState(drivercall.state);
        log((new StringBuilder()).append("parent= ").append(parent).append(", newParent= ").append(cdmacall).toString());
        if(!equalsHandlesNulls(address, drivercall.number)) {
            log("update: phone # changed!");
            address = drivercall.number;
            flag = true;
        }
        if(TextUtils.isEmpty(drivercall.name)) {
            if(!TextUtils.isEmpty(cnapName)) {
                flag = true;
                cnapName = "";
            }
        } else
        if(!drivercall.name.equals(cnapName)) {
            flag = true;
            cnapName = drivercall.name;
        }
        log((new StringBuilder()).append("--dssds----").append(cnapName).toString());
        cnapNamePresentation = drivercall.namePresentation;
        numberPresentation = drivercall.numberPresentation;
        if(cdmacall != parent) {
            if(parent != null)
                parent.detach(this);
            cdmacall.attach(this, drivercall);
            parent = cdmacall;
            flag4 = true;
        } else {
            boolean flag3 = parent.update(this, drivercall);
            if(flag || flag3)
                flag4 = true;
            else
                flag4 = false;
        }
        log((new StringBuilder()).append("Update, wasConnectingInOrOut=").append(flag1).append(", wasHolding=").append(flag2).append(", isConnectingInOrOut=").append(isConnectingInOrOut()).append(", changed=").append(flag4).toString());
        if(flag1 && !isConnectingInOrOut())
            onConnectedInOrOut();
        if(flag4 && !flag2 && getState() == com.android.internal.telephony.Call.State.HOLDING)
            onStartedHolding();
        return flag4;
    }

    public void updateParent(CdmaCall cdmacall, CdmaCall cdmacall1) {
        if(cdmacall1 != cdmacall) {
            if(cdmacall != null)
                cdmacall.detach(this);
            cdmacall1.attachFake(this, com.android.internal.telephony.Call.State.ACTIVE);
            parent = cdmacall1;
        }
    }

    static final int EVENT_DTMF_DONE = 1;
    static final int EVENT_NEXT_POST_DIAL = 3;
    static final int EVENT_PAUSE_DONE = 2;
    static final int EVENT_WAKE_LOCK_TIMEOUT = 4;
    static final String LOG_TAG = "CDMA";
    static final int PAUSE_DELAY_MILLIS = 2000;
    static final int WAKE_LOCK_TIMEOUT_MILLIS = 60000;
    String address;
    com.android.internal.telephony.Connection.DisconnectCause cause;
    String cnapName;
    int cnapNamePresentation;
    long connectTime;
    long connectTimeReal;
    long createTime;
    String dialString;
    long disconnectTime;
    boolean disconnected;
    long duration;
    Handler h;
    long holdingStartTime;
    int index;
    boolean isIncoming;
    private android.os.PowerManager.WakeLock mPartialWakeLock;
    int nextPostDialChar;
    int numberPresentation;
    CdmaCallTracker owner;
    CdmaCall parent;
    com.android.internal.telephony.Connection.PostDialState postDialState;
    String postDialString;

}
