// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.util.Log;

// Referenced classes of package com.android.internal.telephony:
//            Call, CallStateException, UUSInfo

public abstract class Connection {
    public static final class PostDialState extends Enum {

        public static PostDialState valueOf(String s) {
            return (PostDialState)Enum.valueOf(com/android/internal/telephony/Connection$PostDialState, s);
        }

        public static PostDialState[] values() {
            return (PostDialState[])$VALUES.clone();
        }

        private static final PostDialState $VALUES[];
        public static final PostDialState CANCELLED;
        public static final PostDialState COMPLETE;
        public static final PostDialState NOT_STARTED;
        public static final PostDialState PAUSE;
        public static final PostDialState STARTED;
        public static final PostDialState WAIT;
        public static final PostDialState WILD;

        static  {
            NOT_STARTED = new PostDialState("NOT_STARTED", 0);
            STARTED = new PostDialState("STARTED", 1);
            WAIT = new PostDialState("WAIT", 2);
            WILD = new PostDialState("WILD", 3);
            COMPLETE = new PostDialState("COMPLETE", 4);
            CANCELLED = new PostDialState("CANCELLED", 5);
            PAUSE = new PostDialState("PAUSE", 6);
            PostDialState apostdialstate[] = new PostDialState[7];
            apostdialstate[0] = NOT_STARTED;
            apostdialstate[1] = STARTED;
            apostdialstate[2] = WAIT;
            apostdialstate[3] = WILD;
            apostdialstate[4] = COMPLETE;
            apostdialstate[5] = CANCELLED;
            apostdialstate[6] = PAUSE;
            $VALUES = apostdialstate;
        }

        private PostDialState(String s, int i) {
            super(s, i);
        }
    }

    public static final class DisconnectCause extends Enum {

        public static DisconnectCause valueOf(String s) {
            return (DisconnectCause)Enum.valueOf(com/android/internal/telephony/Connection$DisconnectCause, s);
        }

        public static DisconnectCause[] values() {
            return (DisconnectCause[])$VALUES.clone();
        }

        private static final DisconnectCause $VALUES[];
        public static final DisconnectCause BUSY;
        public static final DisconnectCause CALL_BARRED;
        public static final DisconnectCause CDMA_ACCESS_BLOCKED;
        public static final DisconnectCause CDMA_ACCESS_FAILURE;
        public static final DisconnectCause CDMA_DROP;
        public static final DisconnectCause CDMA_INTERCEPT;
        public static final DisconnectCause CDMA_LOCKED_UNTIL_POWER_CYCLE;
        public static final DisconnectCause CDMA_NOT_EMERGENCY;
        public static final DisconnectCause CDMA_PREEMPTED;
        public static final DisconnectCause CDMA_REORDER;
        public static final DisconnectCause CDMA_RETRY_ORDER;
        public static final DisconnectCause CDMA_SO_REJECT;
        public static final DisconnectCause CONGESTION;
        public static final DisconnectCause CS_RESTRICTED;
        public static final DisconnectCause CS_RESTRICTED_EMERGENCY;
        public static final DisconnectCause CS_RESTRICTED_NORMAL;
        public static final DisconnectCause ERROR_UNSPECIFIED;
        public static final DisconnectCause FDN_BLOCKED;
        public static final DisconnectCause ICC_ERROR;
        public static final DisconnectCause INCOMING_MISSED;
        public static final DisconnectCause INCOMING_REJECTED;
        public static final DisconnectCause INVALID_CREDENTIALS;
        public static final DisconnectCause INVALID_NUMBER;
        public static final DisconnectCause LIMIT_EXCEEDED;
        public static final DisconnectCause LOCAL;
        public static final DisconnectCause LOST_SIGNAL;
        public static final DisconnectCause MMI;
        public static final DisconnectCause NORMAL;
        public static final DisconnectCause NOT_DISCONNECTED;
        public static final DisconnectCause NUMBER_UNREACHABLE;
        public static final DisconnectCause OUT_OF_NETWORK;
        public static final DisconnectCause OUT_OF_SERVICE;
        public static final DisconnectCause POWER_OFF;
        public static final DisconnectCause SERVER_ERROR;
        public static final DisconnectCause SERVER_UNREACHABLE;
        public static final DisconnectCause TIMED_OUT;
        public static final DisconnectCause UNOBTAINABLE_NUMBER;

        static  {
            NOT_DISCONNECTED = new DisconnectCause("NOT_DISCONNECTED", 0);
            INCOMING_MISSED = new DisconnectCause("INCOMING_MISSED", 1);
            NORMAL = new DisconnectCause("NORMAL", 2);
            LOCAL = new DisconnectCause("LOCAL", 3);
            BUSY = new DisconnectCause("BUSY", 4);
            CONGESTION = new DisconnectCause("CONGESTION", 5);
            MMI = new DisconnectCause("MMI", 6);
            INVALID_NUMBER = new DisconnectCause("INVALID_NUMBER", 7);
            NUMBER_UNREACHABLE = new DisconnectCause("NUMBER_UNREACHABLE", 8);
            SERVER_UNREACHABLE = new DisconnectCause("SERVER_UNREACHABLE", 9);
            INVALID_CREDENTIALS = new DisconnectCause("INVALID_CREDENTIALS", 10);
            OUT_OF_NETWORK = new DisconnectCause("OUT_OF_NETWORK", 11);
            SERVER_ERROR = new DisconnectCause("SERVER_ERROR", 12);
            TIMED_OUT = new DisconnectCause("TIMED_OUT", 13);
            LOST_SIGNAL = new DisconnectCause("LOST_SIGNAL", 14);
            LIMIT_EXCEEDED = new DisconnectCause("LIMIT_EXCEEDED", 15);
            INCOMING_REJECTED = new DisconnectCause("INCOMING_REJECTED", 16);
            POWER_OFF = new DisconnectCause("POWER_OFF", 17);
            OUT_OF_SERVICE = new DisconnectCause("OUT_OF_SERVICE", 18);
            ICC_ERROR = new DisconnectCause("ICC_ERROR", 19);
            CALL_BARRED = new DisconnectCause("CALL_BARRED", 20);
            FDN_BLOCKED = new DisconnectCause("FDN_BLOCKED", 21);
            CS_RESTRICTED = new DisconnectCause("CS_RESTRICTED", 22);
            CS_RESTRICTED_NORMAL = new DisconnectCause("CS_RESTRICTED_NORMAL", 23);
            CS_RESTRICTED_EMERGENCY = new DisconnectCause("CS_RESTRICTED_EMERGENCY", 24);
            UNOBTAINABLE_NUMBER = new DisconnectCause("UNOBTAINABLE_NUMBER", 25);
            CDMA_LOCKED_UNTIL_POWER_CYCLE = new DisconnectCause("CDMA_LOCKED_UNTIL_POWER_CYCLE", 26);
            CDMA_DROP = new DisconnectCause("CDMA_DROP", 27);
            CDMA_INTERCEPT = new DisconnectCause("CDMA_INTERCEPT", 28);
            CDMA_REORDER = new DisconnectCause("CDMA_REORDER", 29);
            CDMA_SO_REJECT = new DisconnectCause("CDMA_SO_REJECT", 30);
            CDMA_RETRY_ORDER = new DisconnectCause("CDMA_RETRY_ORDER", 31);
            CDMA_ACCESS_FAILURE = new DisconnectCause("CDMA_ACCESS_FAILURE", 32);
            CDMA_PREEMPTED = new DisconnectCause("CDMA_PREEMPTED", 33);
            CDMA_NOT_EMERGENCY = new DisconnectCause("CDMA_NOT_EMERGENCY", 34);
            CDMA_ACCESS_BLOCKED = new DisconnectCause("CDMA_ACCESS_BLOCKED", 35);
            ERROR_UNSPECIFIED = new DisconnectCause("ERROR_UNSPECIFIED", 36);
            DisconnectCause adisconnectcause[] = new DisconnectCause[37];
            adisconnectcause[0] = NOT_DISCONNECTED;
            adisconnectcause[1] = INCOMING_MISSED;
            adisconnectcause[2] = NORMAL;
            adisconnectcause[3] = LOCAL;
            adisconnectcause[4] = BUSY;
            adisconnectcause[5] = CONGESTION;
            adisconnectcause[6] = MMI;
            adisconnectcause[7] = INVALID_NUMBER;
            adisconnectcause[8] = NUMBER_UNREACHABLE;
            adisconnectcause[9] = SERVER_UNREACHABLE;
            adisconnectcause[10] = INVALID_CREDENTIALS;
            adisconnectcause[11] = OUT_OF_NETWORK;
            adisconnectcause[12] = SERVER_ERROR;
            adisconnectcause[13] = TIMED_OUT;
            adisconnectcause[14] = LOST_SIGNAL;
            adisconnectcause[15] = LIMIT_EXCEEDED;
            adisconnectcause[16] = INCOMING_REJECTED;
            adisconnectcause[17] = POWER_OFF;
            adisconnectcause[18] = OUT_OF_SERVICE;
            adisconnectcause[19] = ICC_ERROR;
            adisconnectcause[20] = CALL_BARRED;
            adisconnectcause[21] = FDN_BLOCKED;
            adisconnectcause[22] = CS_RESTRICTED;
            adisconnectcause[23] = CS_RESTRICTED_NORMAL;
            adisconnectcause[24] = CS_RESTRICTED_EMERGENCY;
            adisconnectcause[25] = UNOBTAINABLE_NUMBER;
            adisconnectcause[26] = CDMA_LOCKED_UNTIL_POWER_CYCLE;
            adisconnectcause[27] = CDMA_DROP;
            adisconnectcause[28] = CDMA_INTERCEPT;
            adisconnectcause[29] = CDMA_REORDER;
            adisconnectcause[30] = CDMA_SO_REJECT;
            adisconnectcause[31] = CDMA_RETRY_ORDER;
            adisconnectcause[32] = CDMA_ACCESS_FAILURE;
            adisconnectcause[33] = CDMA_PREEMPTED;
            adisconnectcause[34] = CDMA_NOT_EMERGENCY;
            adisconnectcause[35] = CDMA_ACCESS_BLOCKED;
            adisconnectcause[36] = ERROR_UNSPECIFIED;
            $VALUES = adisconnectcause;
        }

        private DisconnectCause(String s, int i) {
            super(s, i);
        }
    }


    public Connection() {
    }

    public abstract void cancelPostDial();

    public void clearUserData() {
        userData = null;
    }

    public abstract String getAddress();

    public abstract Call getCall();

    public String getCnapName() {
        return null;
    }

    public int getCnapNamePresentation() {
        return 0;
    }

    public abstract long getConnectTime();

    public abstract long getCreateTime();

    public abstract DisconnectCause getDisconnectCause();

    public abstract long getDisconnectTime();

    public abstract long getDurationMillis();

    public abstract long getHoldDurationMillis();

    public abstract int getNumberPresentation();

    public String getOrigDialString() {
        return null;
    }

    public abstract PostDialState getPostDialState();

    public abstract String getRemainingPostDialString();

    public Call.State getState() {
        Call call = getCall();
        Call.State state;
        if(call == null)
            state = Call.State.IDLE;
        else
            state = call.getState();
        return state;
    }

    public abstract UUSInfo getUUSInfo();

    public Object getUserData() {
        return userData;
    }

    public abstract void hangup() throws CallStateException;

    public boolean isAlive() {
        return getState().isAlive();
    }

    public abstract boolean isIncoming();

    public boolean isRinging() {
        return getState().isRinging();
    }

    public abstract void proceedAfterWaitChar();

    public abstract void proceedAfterWildChar(String s);

    public abstract void separate() throws CallStateException;

    public void setUserData(Object obj) {
        userData = obj;
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder(128);
        if(Log.isLoggable(LOG_TAG, 3))
            stringbuilder.append((new StringBuilder()).append("addr: ").append(getAddress()).toString()).append((new StringBuilder()).append(" pres.: ").append(getNumberPresentation()).toString()).append((new StringBuilder()).append(" dial: ").append(getOrigDialString()).toString()).append((new StringBuilder()).append(" postdial: ").append(getRemainingPostDialString()).toString()).append((new StringBuilder()).append(" cnap name: ").append(getCnapName()).toString()).append((new StringBuilder()).append("(").append(getCnapNamePresentation()).append(")").toString());
        stringbuilder.append((new StringBuilder()).append(" incoming: ").append(isIncoming()).toString()).append((new StringBuilder()).append(" state: ").append(getState()).toString()).append((new StringBuilder()).append(" post dial state: ").append(getPostDialState()).toString());
        return stringbuilder.toString();
    }

    private static String LOG_TAG = "TelephonyConnection";
    public static int PRESENTATION_ALLOWED = 1;
    public static int PRESENTATION_PAYPHONE = 4;
    public static int PRESENTATION_RESTRICTED = 2;
    public static int PRESENTATION_UNKNOWN = 3;
    Object userData;

}
