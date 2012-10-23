// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.sip;

import android.net.sip.SipAudioCall;
import android.os.SystemClock;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import com.android.internal.telephony.*;

abstract class SipConnectionBase extends Connection {

    SipConnectionBase(String s) {
        duration = -1L;
        mCause = com.android.internal.telephony.Connection.DisconnectCause.NOT_DISCONNECTED;
        postDialState = com.android.internal.telephony.Connection.PostDialState.NOT_STARTED;
        dialString = s;
        postDialString = PhoneNumberUtils.extractPostDialPortion(s);
        isIncoming = false;
        createTime = System.currentTimeMillis();
    }

    private void log(String s) {
        Log.d("SIP_CONN", (new StringBuilder()).append("[SipConn] ").append(s).toString());
    }

    public void cancelPostDial() {
    }

    public long getConnectTime() {
        return connectTime;
    }

    public long getCreateTime() {
        return createTime;
    }

    public com.android.internal.telephony.Connection.DisconnectCause getDisconnectCause() {
        return mCause;
    }

    public long getDisconnectTime() {
        return disconnectTime;
    }

    public long getDurationMillis() {
        long l = 0L;
        if(connectTimeReal != l)
            if(duration < l)
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
        return Connection.PRESENTATION_ALLOWED;
    }

    protected abstract Phone getPhone();

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

    public UUSInfo getUUSInfo() {
        return null;
    }

    public void proceedAfterWaitChar() {
    }

    public void proceedAfterWildChar(String s) {
    }

    void setDisconnectCause(com.android.internal.telephony.Connection.DisconnectCause disconnectcause) {
        mCause = disconnectcause;
    }

    protected void setState(com.android.internal.telephony.Call.State state) {
        class _cls1 {

            static final int $SwitchMap$com$android$internal$telephony$Call$State[];

            static  {
                $SwitchMap$com$android$internal$telephony$Call$State = new int[com.android.internal.telephony.Call.State.values().length];
                NoSuchFieldError nosuchfielderror2;
                try {
                    $SwitchMap$com$android$internal$telephony$Call$State[com.android.internal.telephony.Call.State.ACTIVE.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror) { }
                try {
                    $SwitchMap$com$android$internal$telephony$Call$State[com.android.internal.telephony.Call.State.DISCONNECTED.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror1) { }
                $SwitchMap$com$android$internal$telephony$Call$State[com.android.internal.telephony.Call.State.HOLDING.ordinal()] = 3;
_L2:
                return;
                nosuchfielderror2;
                if(true) goto _L2; else goto _L1
_L1:
            }
        }

        _cls1..SwitchMap.com.android.internal.telephony.Call.State[state.ordinal()];
        JVM INSTR tableswitch 1 3: default 36
    //                   1 37
    //                   2 63
    //                   3 81;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        if(connectTime == 0L) {
            connectTimeReal = SystemClock.elapsedRealtime();
            connectTime = System.currentTimeMillis();
        }
        continue; /* Loop/switch isn't completed */
_L3:
        duration = getDurationMillis();
        disconnectTime = System.currentTimeMillis();
        continue; /* Loop/switch isn't completed */
_L4:
        holdingStartTime = SystemClock.elapsedRealtime();
        if(true) goto _L1; else goto _L5
_L5:
    }

    private static final String LOG_TAG = "SIP_CONN";
    private long connectTime;
    private long connectTimeReal;
    private long createTime;
    private String dialString;
    private long disconnectTime;
    private long duration;
    private long holdingStartTime;
    private boolean isIncoming;
    private com.android.internal.telephony.Connection.DisconnectCause mCause;
    private SipAudioCall mSipAudioCall;
    private int nextPostDialChar;
    private com.android.internal.telephony.Connection.PostDialState postDialState;
    private String postDialString;
}
