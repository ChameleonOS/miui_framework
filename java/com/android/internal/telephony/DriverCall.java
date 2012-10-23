// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.telephony.PhoneNumberUtils;
import android.util.Log;

// Referenced classes of package com.android.internal.telephony:
//            ATParseEx, ATResponseParser, Connection, UUSInfo

public class DriverCall
    implements Comparable {
    public static final class State extends Enum {

        public static State valueOf(String s) {
            return (State)Enum.valueOf(com/android/internal/telephony/DriverCall$State, s);
        }

        public static State[] values() {
            return (State[])$VALUES.clone();
        }

        private static final State $VALUES[];
        public static final State ACTIVE;
        public static final State ALERTING;
        public static final State DIALING;
        public static final State HOLDING;
        public static final State INCOMING;
        public static final State WAITING;

        static  {
            ACTIVE = new State("ACTIVE", 0);
            HOLDING = new State("HOLDING", 1);
            DIALING = new State("DIALING", 2);
            ALERTING = new State("ALERTING", 3);
            INCOMING = new State("INCOMING", 4);
            WAITING = new State("WAITING", 5);
            State astate[] = new State[6];
            astate[0] = ACTIVE;
            astate[1] = HOLDING;
            astate[2] = DIALING;
            astate[3] = ALERTING;
            astate[4] = INCOMING;
            astate[5] = WAITING;
            $VALUES = astate;
        }

        private State(String s, int i) {
            super(s, i);
        }
    }


    public DriverCall() {
    }

    static DriverCall fromCLCCLine(String s) {
        DriverCall drivercall;
        ATResponseParser atresponseparser;
        drivercall = new DriverCall();
        atresponseparser = new ATResponseParser(s);
        drivercall.index = atresponseparser.nextInt();
        drivercall.isMT = atresponseparser.nextBoolean();
        drivercall.state = stateFromCLCC(atresponseparser.nextInt());
        if(atresponseparser.nextInt() != 0) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L3:
        drivercall.isVoice = flag;
        drivercall.isMpty = atresponseparser.nextBoolean();
        drivercall.numberPresentation = Connection.PRESENTATION_ALLOWED;
        if(atresponseparser.hasMore()) {
            drivercall.number = PhoneNumberUtils.extractNetworkPortionAlt(atresponseparser.nextString());
            if(drivercall.number.length() == 0)
                drivercall.number = null;
            drivercall.TOA = atresponseparser.nextInt();
            drivercall.number = PhoneNumberUtils.stringFromStringAndTOA(drivercall.number, drivercall.TOA);
        }
_L4:
        return drivercall;
_L2:
        flag = false;
          goto _L3
        ATParseEx atparseex;
        atparseex;
        Log.e("RILB", (new StringBuilder()).append("Invalid CLCC line: '").append(s).append("'").toString());
        drivercall = null;
          goto _L4
    }

    public static int presentationFromCLIP(int i) throws ATParseEx {
        i;
        JVM INSTR tableswitch 0 3: default 32
    //                   0 59
    //                   1 65
    //                   2 72
    //                   3 79;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        throw new ATParseEx((new StringBuilder()).append("illegal presentation ").append(i).toString());
_L2:
        int j = Connection.PRESENTATION_ALLOWED;
_L7:
        return j;
_L3:
        j = Connection.PRESENTATION_RESTRICTED;
        continue; /* Loop/switch isn't completed */
_L4:
        j = Connection.PRESENTATION_UNKNOWN;
        continue; /* Loop/switch isn't completed */
_L5:
        j = Connection.PRESENTATION_PAYPHONE;
        if(true) goto _L7; else goto _L6
_L6:
    }

    public static State stateFromCLCC(int i) throws ATParseEx {
        i;
        JVM INSTR tableswitch 0 5: default 40
    //                   0 67
    //                   1 73
    //                   2 80
    //                   3 87
    //                   4 94
    //                   5 101;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        throw new ATParseEx((new StringBuilder()).append("illegal call state ").append(i).toString());
_L2:
        State state1 = State.ACTIVE;
_L9:
        return state1;
_L3:
        state1 = State.HOLDING;
        continue; /* Loop/switch isn't completed */
_L4:
        state1 = State.DIALING;
        continue; /* Loop/switch isn't completed */
_L5:
        state1 = State.ALERTING;
        continue; /* Loop/switch isn't completed */
_L6:
        state1 = State.INCOMING;
        continue; /* Loop/switch isn't completed */
_L7:
        state1 = State.WAITING;
        if(true) goto _L9; else goto _L8
_L8:
    }

    public int compareTo(Object obj) {
        DriverCall drivercall = (DriverCall)obj;
        byte byte0;
        if(index < drivercall.index)
            byte0 = -1;
        else
        if(index == drivercall.index)
            byte0 = 0;
        else
            byte0 = 1;
        return byte0;
    }

    public String toString() {
        StringBuilder stringbuilder = (new StringBuilder()).append("id=").append(index).append(",").append(state).append(",").append("toa=").append(TOA).append(",");
        String s;
        StringBuilder stringbuilder1;
        String s1;
        StringBuilder stringbuilder2;
        String s2;
        StringBuilder stringbuilder3;
        String s3;
        if(isMpty)
            s = "conf";
        else
            s = "norm";
        stringbuilder1 = stringbuilder.append(s).append(",");
        if(isMT)
            s1 = "mt";
        else
            s1 = "mo";
        stringbuilder2 = stringbuilder1.append(s1).append(",").append(als).append(",");
        if(isVoice)
            s2 = "voc";
        else
            s2 = "nonvoc";
        stringbuilder3 = stringbuilder2.append(s2).append(",");
        if(isVoicePrivacy)
            s3 = "evp";
        else
            s3 = "noevp";
        return stringbuilder3.append(s3).append(",").append(",cli=").append(numberPresentation).append(",").append(",").append(namePresentation).toString();
    }

    static final String LOG_TAG = "RILB";
    public int TOA;
    public int als;
    public int index;
    public boolean isMT;
    public boolean isMpty;
    public boolean isVoice;
    public boolean isVoicePrivacy;
    public String name;
    public int namePresentation;
    public String number;
    public int numberPresentation;
    public State state;
    public UUSInfo uusInfo;
}
