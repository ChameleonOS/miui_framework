// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.gsm;

import android.content.Context;
import android.os.*;
import android.telephony.PhoneNumberUtils;
import android.telephony.ServiceState;
import android.util.Log;
import com.android.internal.telephony.*;

// Referenced classes of package com.android.internal.telephony.gsm:
//            GsmCallTracker, GsmCall, GSMPhone

public class GsmConnection extends Connection {
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

        final GsmConnection this$0;

        MyHandler(Looper looper) {
            this$0 = GsmConnection.this;
            super(looper);
        }
    }


    GsmConnection(Context context, DriverCall drivercall, GsmCallTracker gsmcalltracker, int i) {
        cause = com.android.internal.telephony.Connection.DisconnectCause.NOT_DISCONNECTED;
        postDialState = com.android.internal.telephony.Connection.PostDialState.NOT_STARTED;
        numberPresentation = Connection.PRESENTATION_ALLOWED;
        createWakeLock(context);
        acquireWakeLock();
        owner = gsmcalltracker;
        h = new MyHandler(owner.getLooper());
        address = drivercall.number;
        isIncoming = drivercall.isMT;
        createTime = System.currentTimeMillis();
        numberPresentation = drivercall.numberPresentation;
        uusInfo = drivercall.uusInfo;
        index = i;
        parent = parentFromDCState(drivercall.state);
        parent.attach(this, drivercall);
    }

    GsmConnection(Context context, String s, GsmCallTracker gsmcalltracker, GsmCall gsmcall) {
        cause = com.android.internal.telephony.Connection.DisconnectCause.NOT_DISCONNECTED;
        postDialState = com.android.internal.telephony.Connection.PostDialState.NOT_STARTED;
        numberPresentation = Connection.PRESENTATION_ALLOWED;
        createWakeLock(context);
        acquireWakeLock();
        owner = gsmcalltracker;
        h = new MyHandler(owner.getLooper());
        dialString = s;
        address = PhoneNumberUtils.extractNetworkPortionAlt(s);
        postDialString = PhoneNumberUtils.extractPostDialPortion(s);
        index = -1;
        isIncoming = false;
        createTime = System.currentTimeMillis();
        parent = gsmcall;
        gsmcall.attachFake(this, com.android.internal.telephony.Call.State.DIALING);
    }

    private void acquireWakeLock() {
        log("acquireWakeLock");
        mPartialWakeLock.acquire();
    }

    private void createWakeLock(Context context) {
        mPartialWakeLock = ((PowerManager)context.getSystemService("power")).newWakeLock(1, "GSM");
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

    private boolean isConnectingInOrOut() {
        boolean flag;
        if(parent == null || parent == owner.ringingCall || ((Call) (parent)).state == com.android.internal.telephony.Call.State.DIALING || ((Call) (parent)).state == com.android.internal.telephony.Call.State.ALERTING)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private void log(String s) {
        Log.d("GSM", (new StringBuilder()).append("[GSMConn] ").append(s).toString());
    }

    private void onStartedHolding() {
        holdingStartTime = SystemClock.elapsedRealtime();
    }

    private GsmCall parentFromDCState(com.android.internal.telephony.DriverCall.State state) {
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
        GsmCall gsmcall = owner.foregroundCall;
_L6:
        return gsmcall;
_L3:
        gsmcall = owner.backgroundCall;
        continue; /* Loop/switch isn't completed */
_L4:
        gsmcall = owner.ringingCall;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private void processNextPostDialChar() {
        if(postDialState != com.android.internal.telephony.Connection.PostDialState.CANCELLED) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(postDialString != null && postDialString.length() > nextPostDialChar) goto _L4; else goto _L3
_L3:
        int i;
        setPostDialState(com.android.internal.telephony.Connection.PostDialState.COMPLETE);
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
        Log.e("GSM", (new StringBuilder()).append("processNextPostDialChar: c=").append(i).append(" isn't valid!").toString());
        if(true) goto _L1; else goto _L7
_L7:
    }

    private boolean processPostDialChar(char c) {
        boolean flag = true;
        if(PhoneNumberUtils.is12Key(c))
            ((CallTracker) (owner)).cm.sendDtmf(c, h.obtainMessage(flag));
        else
        if(c == ',') {
            if(nextPostDialChar == flag)
                h.sendMessageDelayed(h.obtainMessage(2), 100L);
            else
                h.sendMessageDelayed(h.obtainMessage(2), 3000L);
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
        if(postDialState == com.android.internal.telephony.Connection.PostDialState.STARTED || postdialstate != com.android.internal.telephony.Connection.PostDialState.STARTED) goto _L2; else goto _L1
_L1:
        acquireWakeLock();
        Message message = h.obtainMessage(4);
        h.sendMessageDelayed(message, 60000L);
_L4:
        postDialState = postdialstate;
        return;
_L2:
        if(postDialState == com.android.internal.telephony.Connection.PostDialState.STARTED && postdialstate != com.android.internal.telephony.Connection.PostDialState.STARTED) {
            h.removeMessages(4);
            releaseWakeLock();
        }
        if(true) goto _L4; else goto _L3
_L3:
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
        JVM INSTR lookupswitch 11: default 100
    //                   1: 164
    //                   17: 129
    //                   34: 136
    //                   41: 136
    //                   42: 136
    //                   44: 136
    //                   49: 136
    //                   58: 136
    //                   68: 143
    //                   240: 150
    //                   241: 157;
           goto _L1 _L2 _L3 _L4 _L4 _L4 _L4 _L4 _L4 _L5 _L6 _L7
_L1:
        GSMPhone gsmphone = owner.phone;
        int j = gsmphone.getServiceState().getState();
        com.android.internal.telephony.Connection.DisconnectCause disconnectcause;
        if(j == 3)
            disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.POWER_OFF;
        else
        if(j == 1 || j == 2)
            disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.OUT_OF_SERVICE;
        else
        if(gsmphone.getIccCard().getState() != com.android.internal.telephony.IccCard.State.READY)
            disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.ICC_ERROR;
        else
        if(i == 65535) {
            if(((ServiceStateTracker) (gsmphone.mSST)).mRestrictedState.isCsRestricted())
                disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.CS_RESTRICTED;
            else
            if(((ServiceStateTracker) (gsmphone.mSST)).mRestrictedState.isCsEmergencyRestricted())
                disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.CS_RESTRICTED_EMERGENCY;
            else
            if(((ServiceStateTracker) (gsmphone.mSST)).mRestrictedState.isCsNormalRestricted())
                disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.CS_RESTRICTED_NORMAL;
            else
                disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.ERROR_UNSPECIFIED;
        } else
        if(i == 16)
            disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.NORMAL;
        else
            disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.ERROR_UNSPECIFIED;
_L9:
        return disconnectcause;
_L3:
        disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.BUSY;
        continue; /* Loop/switch isn't completed */
_L4:
        disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.CONGESTION;
        continue; /* Loop/switch isn't completed */
_L5:
        disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.LIMIT_EXCEEDED;
        continue; /* Loop/switch isn't completed */
_L6:
        disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.CALL_BARRED;
        continue; /* Loop/switch isn't completed */
_L7:
        disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.FDN_BLOCKED;
        continue; /* Loop/switch isn't completed */
_L2:
        disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.UNOBTAINABLE_NUMBER;
        if(true) goto _L9; else goto _L8
_L8:
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
            Log.e("GSM", "[GSMConn] UNEXPECTED; mPartialWakeLock is held when finalizing.");
        releaseWakeLock();
    }

    public String getAddress() {
        return address;
    }

    public volatile Call getCall() {
        return getCall();
    }

    public GsmCall getCall() {
        return parent;
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

    int getGSMIndex() throws CallStateException {
        if(index >= 0)
            return 1 + index;
        else
            throw new CallStateException("GSM index not yet assigned");
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

    public com.android.internal.telephony.Connection.PostDialState getPostDialState() {
        return postDialState;
    }

    public String getRemainingPostDialString() {
        String s;
        if(postDialState == com.android.internal.telephony.Connection.PostDialState.CANCELLED || postDialState == com.android.internal.telephony.Connection.PostDialState.COMPLETE || postDialString == null || postDialString.length() <= nextPostDialChar)
            s = "";
        else
            s = postDialString.substring(nextPostDialChar);
        return s;
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
        return uusInfo;
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
        releaseWakeLock();
    }

    void onDisconnect(com.android.internal.telephony.Connection.DisconnectCause disconnectcause) {
        cause = disconnectcause;
        if(!disconnected) {
            index = -1;
            disconnectTime = System.currentTimeMillis();
            duration = SystemClock.elapsedRealtime() - connectTimeReal;
            disconnected = true;
            owner.phone.notifyDisconnect(this);
            if(parent != null)
                parent.connectionDisconnected(this);
        }
        releaseWakeLock();
    }

    void onHangupLocal() {
        cause = com.android.internal.telephony.Connection.DisconnectCause.LOCAL;
    }

    void onRemoteDisconnect(int i) {
        onDisconnect(disconnectCauseFromCode(i));
    }

    public void proceedAfterWaitChar() {
        if(postDialState != com.android.internal.telephony.Connection.PostDialState.WAIT) {
            Log.w("GSM", (new StringBuilder()).append("GsmConnection.proceedAfterWaitChar(): Expected getPostDialState() to be WAIT but was ").append(postDialState).toString());
        } else {
            setPostDialState(com.android.internal.telephony.Connection.PostDialState.STARTED);
            processNextPostDialChar();
        }
    }

    public void proceedAfterWildChar(String s) {
        if(postDialState != com.android.internal.telephony.Connection.PostDialState.WILD) {
            Log.w("GSM", (new StringBuilder()).append("GsmConnection.proceedAfterWaitChar(): Expected getPostDialState() to be WILD but was ").append(postDialState).toString());
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

    public void separate() throws CallStateException {
        if(!disconnected) {
            owner.separate(this);
            return;
        } else {
            throw new CallStateException("disconnected");
        }
    }

    boolean update(DriverCall drivercall) {
        boolean flag = true;
        boolean flag1 = false;
        boolean flag2 = isConnectingInOrOut();
        boolean flag3;
        GsmCall gsmcall;
        boolean flag5;
        StringBuilder stringbuilder;
        if(getState() == com.android.internal.telephony.Call.State.HOLDING)
            flag3 = flag;
        else
            flag3 = false;
        gsmcall = parentFromDCState(drivercall.state);
        if(!equalsHandlesNulls(address, drivercall.number)) {
            log("update: phone # changed!");
            address = drivercall.number;
            flag1 = true;
        }
        if(gsmcall != parent) {
            if(parent != null)
                parent.detach(this);
            gsmcall.attach(this, drivercall);
            parent = gsmcall;
            flag5 = true;
        } else {
            boolean flag4 = parent.update(this, drivercall);
            if(flag1 || flag4)
                flag5 = flag;
            else
                flag5 = false;
        }
        stringbuilder = (new StringBuilder()).append("update: parent=").append(parent).append(", hasNewParent=");
        if(gsmcall == parent)
            flag = false;
        log(stringbuilder.append(flag).append(", wasConnectingInOrOut=").append(flag2).append(", wasHolding=").append(flag3).append(", isConnectingInOrOut=").append(isConnectingInOrOut()).append(", changed=").append(flag5).toString());
        if(flag2 && !isConnectingInOrOut())
            onConnectedInOrOut();
        if(flag5 && !flag3 && getState() == com.android.internal.telephony.Call.State.HOLDING)
            onStartedHolding();
        return flag5;
    }

    static final int EVENT_DTMF_DONE = 1;
    static final int EVENT_NEXT_POST_DIAL = 3;
    static final int EVENT_PAUSE_DONE = 2;
    static final int EVENT_WAKE_LOCK_TIMEOUT = 4;
    static final String LOG_TAG = "GSM";
    static final int PAUSE_DELAY_FIRST_MILLIS = 100;
    static final int PAUSE_DELAY_MILLIS = 3000;
    static final int WAKE_LOCK_TIMEOUT_MILLIS = 60000;
    String address;
    com.android.internal.telephony.Connection.DisconnectCause cause;
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
    GsmCallTracker owner;
    GsmCall parent;
    com.android.internal.telephony.Connection.PostDialState postDialState;
    String postDialString;
    UUSInfo uusInfo;


}
