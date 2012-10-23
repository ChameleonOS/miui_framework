// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.gsm;

import com.android.internal.telephony.*;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.android.internal.telephony.gsm:
//            GsmConnection, GsmCallTracker

class GsmCall extends Call {

    GsmCall(GsmCallTracker gsmcalltracker) {
        connections = new ArrayList();
        owner = gsmcalltracker;
    }

    static com.android.internal.telephony.Call.State stateFromDCState(com.android.internal.telephony.DriverCall.State state) {
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
                    $SwitchMap$com$android$internal$telephony$DriverCall$State[com.android.internal.telephony.DriverCall.State.HOLDING.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror1) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DriverCall$State[com.android.internal.telephony.DriverCall.State.DIALING.ordinal()] = 3;
                }
                catch(NoSuchFieldError nosuchfielderror2) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DriverCall$State[com.android.internal.telephony.DriverCall.State.ALERTING.ordinal()] = 4;
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
    //                   1 75
    //                   2 81
    //                   3 88
    //                   4 95
    //                   5 102
    //                   6 109;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        throw new RuntimeException((new StringBuilder()).append("illegal call state:").append(state).toString());
_L2:
        com.android.internal.telephony.Call.State state1 = com.android.internal.telephony.Call.State.ACTIVE;
_L9:
        return state1;
_L3:
        state1 = com.android.internal.telephony.Call.State.HOLDING;
        continue; /* Loop/switch isn't completed */
_L4:
        state1 = com.android.internal.telephony.Call.State.DIALING;
        continue; /* Loop/switch isn't completed */
_L5:
        state1 = com.android.internal.telephony.Call.State.ALERTING;
        continue; /* Loop/switch isn't completed */
_L6:
        state1 = com.android.internal.telephony.Call.State.INCOMING;
        continue; /* Loop/switch isn't completed */
_L7:
        state1 = com.android.internal.telephony.Call.State.WAITING;
        if(true) goto _L9; else goto _L8
_L8:
    }

    void attach(Connection connection, DriverCall drivercall) {
        connections.add(connection);
        super.state = stateFromDCState(drivercall.state);
    }

    void attachFake(Connection connection, com.android.internal.telephony.Call.State state) {
        connections.add(connection);
        super.state = state;
    }

    void clearDisconnected() {
        for(int i = -1 + connections.size(); i >= 0; i--)
            if(((GsmConnection)connections.get(i)).getState() == com.android.internal.telephony.Call.State.DISCONNECTED)
                connections.remove(i);

        if(connections.size() == 0)
            super.state = com.android.internal.telephony.Call.State.IDLE;
    }

    void connectionDisconnected(GsmConnection gsmconnection) {
        if(super.state == com.android.internal.telephony.Call.State.DISCONNECTED) goto _L2; else goto _L1
_L1:
        boolean flag;
        int i;
        int j;
        flag = true;
        i = 0;
        j = connections.size();
_L8:
        if(i >= j) goto _L4; else goto _L3
_L3:
        if(((Connection)connections.get(i)).getState() == com.android.internal.telephony.Call.State.DISCONNECTED) goto _L6; else goto _L5
_L5:
        flag = false;
_L4:
        if(flag)
            super.state = com.android.internal.telephony.Call.State.DISCONNECTED;
_L2:
        return;
_L6:
        i++;
        if(true) goto _L8; else goto _L7
_L7:
    }

    void detach(GsmConnection gsmconnection) {
        connections.remove(gsmconnection);
        if(connections.size() == 0)
            super.state = com.android.internal.telephony.Call.State.IDLE;
    }

    public void dispose() {
    }

    public List getConnections() {
        return connections;
    }

    public Phone getPhone() {
        return owner.phone;
    }

    public void hangup() throws CallStateException {
        owner.hangup(this);
    }

    boolean isFull() {
        boolean flag;
        if(connections.size() == 5)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isMultiparty() {
        boolean flag = true;
        if(connections.size() <= flag)
            flag = false;
        return flag;
    }

    void onHangupLocal() {
        int i = 0;
        for(int j = connections.size(); i < j; i++)
            ((GsmConnection)connections.get(i)).onHangupLocal();

        super.state = com.android.internal.telephony.Call.State.DISCONNECTING;
    }

    public String toString() {
        return super.state.toString();
    }

    boolean update(GsmConnection gsmconnection, DriverCall drivercall) {
        boolean flag = false;
        com.android.internal.telephony.Call.State state = stateFromDCState(drivercall.state);
        if(state != super.state) {
            super.state = state;
            flag = true;
        }
        return flag;
    }

    ArrayList connections;
    GsmCallTracker owner;
}
