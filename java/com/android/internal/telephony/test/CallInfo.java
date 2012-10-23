// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.test;

import com.android.internal.telephony.ATParseEx;
import com.android.internal.telephony.DriverCall;

class CallInfo {
    static final class State extends Enum {

        public static State valueOf(String s) {
            return (State)Enum.valueOf(com/android/internal/telephony/test/CallInfo$State, s);
        }

        public static State[] values() {
            return (State[])$VALUES.clone();
        }

        public int value() {
            return value;
        }

        private static final State $VALUES[];
        public static final State ACTIVE;
        public static final State ALERTING;
        public static final State DIALING;
        public static final State HOLDING;
        public static final State INCOMING;
        public static final State WAITING;
        private final int value;

        static  {
            ACTIVE = new State("ACTIVE", 0, 0);
            HOLDING = new State("HOLDING", 1, 1);
            DIALING = new State("DIALING", 2, 2);
            ALERTING = new State("ALERTING", 3, 3);
            INCOMING = new State("INCOMING", 4, 4);
            WAITING = new State("WAITING", 5, 5);
            State astate[] = new State[6];
            astate[0] = ACTIVE;
            astate[1] = HOLDING;
            astate[2] = DIALING;
            astate[3] = ALERTING;
            astate[4] = INCOMING;
            astate[5] = WAITING;
            $VALUES = astate;
        }

        private State(String s, int i, int j) {
            super(s, i);
            value = j;
        }
    }


    CallInfo(boolean flag, State state1, boolean flag1, String s) {
        isMT = flag;
        state = state1;
        isMpty = flag1;
        number = s;
        if(s.length() > 0 && s.charAt(0) == '+')
            TOA = 145;
        else
            TOA = 129;
    }

    static CallInfo createIncomingCall(String s) {
        return new CallInfo(true, State.INCOMING, false, s);
    }

    static CallInfo createOutgoingCall(String s) {
        return new CallInfo(false, State.DIALING, false, s);
    }

    boolean isActiveOrHeld() {
        boolean flag;
        if(state == State.ACTIVE || state == State.HOLDING)
            flag = true;
        else
            flag = false;
        return flag;
    }

    boolean isConnecting() {
        boolean flag;
        if(state == State.DIALING || state == State.ALERTING)
            flag = true;
        else
            flag = false;
        return flag;
    }

    boolean isRinging() {
        boolean flag;
        if(state == State.INCOMING || state == State.WAITING)
            flag = true;
        else
            flag = false;
        return flag;
    }

    String toCLCCLine(int i) {
        StringBuilder stringbuilder = (new StringBuilder()).append("+CLCC: ").append(i).append(",");
        String s;
        StringBuilder stringbuilder1;
        String s1;
        if(isMT)
            s = "1";
        else
            s = "0";
        stringbuilder1 = stringbuilder.append(s).append(",").append(state.value()).append(",0,");
        if(isMpty)
            s1 = "1";
        else
            s1 = "0";
        return stringbuilder1.append(s1).append(",\"").append(number).append("\",").append(TOA).toString();
    }

    DriverCall toDriverCall(int i) {
        DriverCall drivercall = new DriverCall();
        drivercall.index = i;
        drivercall.isMT = isMT;
        try {
            drivercall.state = DriverCall.stateFromCLCC(state.value());
        }
        catch(ATParseEx atparseex) {
            throw new RuntimeException("should never happen", atparseex);
        }
        drivercall.isMpty = isMpty;
        drivercall.number = number;
        drivercall.TOA = TOA;
        drivercall.isVoice = true;
        drivercall.als = 0;
        return drivercall;
    }

    int TOA;
    boolean isMT;
    boolean isMpty;
    String number;
    State state;
}
