// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.util.Log;
import java.util.List;

// Referenced classes of package com.android.internal.telephony:
//            Connection, CallStateException, Phone

public abstract class Call {
    public static final class State extends Enum {

        public static State valueOf(String s) {
            return (State)Enum.valueOf(com/android/internal/telephony/Call$State, s);
        }

        public static State[] values() {
            return (State[])$VALUES.clone();
        }

        public boolean isAlive() {
            boolean flag;
            if(this != IDLE && this != DISCONNECTED && this != DISCONNECTING)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public boolean isDialing() {
            boolean flag;
            if(this == DIALING || this == ALERTING)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public boolean isRinging() {
            boolean flag;
            if(this == INCOMING || this == WAITING)
                flag = true;
            else
                flag = false;
            return flag;
        }

        private static final State $VALUES[];
        public static final State ACTIVE;
        public static final State ALERTING;
        public static final State DIALING;
        public static final State DISCONNECTED;
        public static final State DISCONNECTING;
        public static final State HOLDING;
        public static final State IDLE;
        public static final State INCOMING;
        public static final State WAITING;

        static  {
            IDLE = new State("IDLE", 0);
            ACTIVE = new State("ACTIVE", 1);
            HOLDING = new State("HOLDING", 2);
            DIALING = new State("DIALING", 3);
            ALERTING = new State("ALERTING", 4);
            INCOMING = new State("INCOMING", 5);
            WAITING = new State("WAITING", 6);
            DISCONNECTED = new State("DISCONNECTED", 7);
            DISCONNECTING = new State("DISCONNECTING", 8);
            State astate[] = new State[9];
            astate[0] = IDLE;
            astate[1] = ACTIVE;
            astate[2] = HOLDING;
            astate[3] = DIALING;
            astate[4] = ALERTING;
            astate[5] = INCOMING;
            astate[6] = WAITING;
            astate[7] = DISCONNECTED;
            astate[8] = DISCONNECTING;
            $VALUES = astate;
        }

        private State(String s, int i) {
            super(s, i);
        }
    }


    public Call() {
        state = State.IDLE;
        isGeneric = false;
    }

    public abstract List getConnections();

    public long getEarliestConnectTime() {
        long l = 0x7fffffffffffffffL;
        List list = getConnections();
        long l1;
        if(list.size() == 0) {
            l1 = 0L;
        } else {
            int i = 0;
            for(int j = list.size(); i < j; i++) {
                long l2 = ((Connection)list.get(i)).getConnectTime();
                if(l2 < l)
                    l = l2;
            }

            l1 = l;
        }
        return l1;
    }

    public Connection getEarliestConnection() {
        long l = 0x7fffffffffffffffL;
        Connection connection = null;
        List list = getConnections();
        Connection connection1;
        if(list.size() == 0) {
            connection1 = null;
        } else {
            int i = 0;
            for(int j = list.size(); i < j; i++) {
                Connection connection2 = (Connection)list.get(i);
                long l1 = connection2.getCreateTime();
                if(l1 < l) {
                    connection = connection2;
                    l = l1;
                }
            }

            connection1 = connection;
        }
        return connection1;
    }

    public long getEarliestCreateTime() {
        long l = 0x7fffffffffffffffL;
        List list = getConnections();
        long l1;
        if(list.size() == 0) {
            l1 = 0L;
        } else {
            int i = 0;
            for(int j = list.size(); i < j; i++) {
                long l2 = ((Connection)list.get(i)).getCreateTime();
                if(l2 < l)
                    l = l2;
            }

            l1 = l;
        }
        return l1;
    }

    public Connection getLatestConnection() {
        List list = getConnections();
        Connection connection;
        if(list.size() == 0) {
            connection = null;
        } else {
            long l = 0L;
            connection = null;
            int i = 0;
            int j = list.size();
            while(i < j)  {
                Connection connection1 = (Connection)list.get(i);
                long l1 = connection1.getCreateTime();
                if(l1 > l) {
                    connection = connection1;
                    l = l1;
                }
                i++;
            }
        }
        return connection;
    }

    public abstract Phone getPhone();

    public State getState() {
        return state;
    }

    public abstract void hangup() throws CallStateException;

    public void hangupIfAlive() {
        if(!getState().isAlive())
            break MISSING_BLOCK_LABEL_14;
        hangup();
_L1:
        return;
        CallStateException callstateexception;
        callstateexception;
        Log.w("Call", (new StringBuilder()).append(" hangupIfActive: caught ").append(callstateexception).toString());
          goto _L1
    }

    public boolean hasConnection(Connection connection) {
        boolean flag;
        if(connection.getCall() == this)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean hasConnections() {
        boolean flag;
        List list;
        flag = false;
        list = getConnections();
        break MISSING_BLOCK_LABEL_7;
        if(list != null && list.size() > 0)
            flag = true;
        return flag;
    }

    public boolean isDialingOrAlerting() {
        return getState().isDialing();
    }

    public boolean isGeneric() {
        return isGeneric;
    }

    public boolean isIdle() {
        boolean flag;
        if(!getState().isAlive())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public abstract boolean isMultiparty();

    public boolean isRinging() {
        return getState().isRinging();
    }

    public void setGeneric(boolean flag) {
        isGeneric = flag;
    }

    protected final String LOG_TAG = "Call";
    protected boolean isGeneric;
    public State state;
}
