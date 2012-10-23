// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.sip;

import com.android.internal.telephony.Call;
import com.android.internal.telephony.Connection;
import java.util.*;

abstract class SipCallBase extends Call {

    SipCallBase() {
        connections = new ArrayList();
    }

    void clearDisconnected() {
        Iterator iterator = connections.iterator();
        do {
            if(!iterator.hasNext())
                break;
            if(((Connection)iterator.next()).getState() == com.android.internal.telephony.Call.State.DISCONNECTED)
                iterator.remove();
        } while(true);
        if(connections.isEmpty())
            setState(com.android.internal.telephony.Call.State.IDLE);
    }

    public List getConnections() {
        return connections;
    }

    public boolean isMultiparty() {
        boolean flag = true;
        if(connections.size() <= flag)
            flag = false;
        return flag;
    }

    protected abstract void setState(com.android.internal.telephony.Call.State state);

    public String toString() {
        return (new StringBuilder()).append(super.state.toString()).append(":").append(super.toString()).toString();
    }

    protected List connections;
}
