// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.gsm;

import android.os.*;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.util.EventLog;
import android.util.Log;
import com.android.internal.telephony.*;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.android.internal.telephony.gsm:
//            GsmConnection, GsmCall, GSMPhone

public final class GsmCallTracker extends CallTracker {

    GsmCallTracker(GSMPhone gsmphone) {
        connections = new GsmConnection[7];
        voiceCallEndedRegistrants = new RegistrantList();
        voiceCallStartedRegistrants = new RegistrantList();
        droppedDuringPoll = new ArrayList(7);
        ringingCall = new GsmCall(this);
        foregroundCall = new GsmCall(this);
        backgroundCall = new GsmCall(this);
        desiredMute = false;
        state = com.android.internal.telephony.Phone.State.IDLE;
        phone = gsmphone;
        super.cm = ((PhoneBase) (gsmphone)).mCM;
        super.cm.registerForCallStateChanged(this, 2, null);
        super.cm.registerForOn(this, 9, null);
        super.cm.registerForNotAvailable(this, 10, null);
    }

    private void dumpState() {
        Log.i("GSM", (new StringBuilder()).append("Phone State:").append(state).toString());
        Log.i("GSM", (new StringBuilder()).append("Ringing call: ").append(ringingCall.toString()).toString());
        List list = ringingCall.getConnections();
        int i = 0;
        for(int j = list.size(); i < j; i++)
            Log.i("GSM", list.get(i).toString());

        Log.i("GSM", (new StringBuilder()).append("Foreground call: ").append(foregroundCall.toString()).toString());
        List list1 = foregroundCall.getConnections();
        int k = 0;
        for(int l = list1.size(); k < l; k++)
            Log.i("GSM", list1.get(k).toString());

        Log.i("GSM", (new StringBuilder()).append("Background call: ").append(backgroundCall.toString()).toString());
        List list2 = backgroundCall.getConnections();
        int i1 = 0;
        for(int j1 = list2.size(); i1 < j1; i1++)
            Log.i("GSM", list2.get(i1).toString());

    }

    private void fakeHoldForegroundBeforeDial() {
        List list = (List)foregroundCall.connections.clone();
        int i = 0;
        for(int j = list.size(); i < j; i++)
            ((GsmConnection)list.get(i)).fakeHoldBeforeDial();

    }

    private com.android.internal.telephony.Phone.SuppService getFailedService(int i) {
        i;
        JVM INSTR tableswitch 8 13: default 40
    //                   8 46
    //                   9 40
    //                   10 40
    //                   11 53
    //                   12 60
    //                   13 67;
           goto _L1 _L2 _L1 _L1 _L3 _L4 _L5
_L1:
        com.android.internal.telephony.Phone.SuppService suppservice = com.android.internal.telephony.Phone.SuppService.UNKNOWN;
_L7:
        return suppservice;
_L2:
        suppservice = com.android.internal.telephony.Phone.SuppService.SWITCH;
        continue; /* Loop/switch isn't completed */
_L3:
        suppservice = com.android.internal.telephony.Phone.SuppService.CONFERENCE;
        continue; /* Loop/switch isn't completed */
_L4:
        suppservice = com.android.internal.telephony.Phone.SuppService.SEPARATE;
        continue; /* Loop/switch isn't completed */
_L5:
        suppservice = com.android.internal.telephony.Phone.SuppService.TRANSFER;
        if(true) goto _L7; else goto _L6
_L6:
    }

    private void handleRadioNotAvailable() {
        pollCallsWhenSafe();
    }

    private void internalClearDisconnected() {
        ringingCall.clearDisconnected();
        foregroundCall.clearDisconnected();
        backgroundCall.clearDisconnected();
    }

    private Message obtainCompleteMessage() {
        return obtainCompleteMessage(4);
    }

    private Message obtainCompleteMessage(int i) {
        super.pendingOperations = 1 + super.pendingOperations;
        super.lastRelevantPoll = null;
        super.needsPoll = true;
        return obtainMessage(i);
    }

    private void operationComplete() {
        super.pendingOperations = -1 + super.pendingOperations;
        if(super.pendingOperations != 0 || !super.needsPoll) goto _L2; else goto _L1
_L1:
        super.lastRelevantPoll = obtainMessage(1);
        super.cm.getCurrentCalls(super.lastRelevantPoll);
_L4:
        return;
_L2:
        if(super.pendingOperations < 0) {
            Log.e("GSM", "GsmCallTracker.pendingOperations < 0");
            super.pendingOperations = 0;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void updatePhoneState() {
        com.android.internal.telephony.Phone.State state1;
        state1 = state;
        if(ringingCall.isRinging())
            state = com.android.internal.telephony.Phone.State.RINGING;
        else
        if(pendingMO != null || !foregroundCall.isIdle() || !backgroundCall.isIdle())
            state = com.android.internal.telephony.Phone.State.OFFHOOK;
        else
            state = com.android.internal.telephony.Phone.State.IDLE;
        if(state != com.android.internal.telephony.Phone.State.IDLE || state1 == state) goto _L2; else goto _L1
_L1:
        voiceCallEndedRegistrants.notifyRegistrants(new AsyncResult(null, null, null));
_L4:
        if(state != state1)
            phone.notifyPhoneStateChanged();
        return;
_L2:
        if(state1 == com.android.internal.telephony.Phone.State.IDLE && state1 != state)
            voiceCallStartedRegistrants.notifyRegistrants(new AsyncResult(null, null, null));
        if(true) goto _L4; else goto _L3
_L3:
    }

    void acceptCall() throws CallStateException {
        if(ringingCall.getState() == com.android.internal.telephony.Call.State.INCOMING) {
            Log.i("phone", "acceptCall: incoming...");
            setMute(false);
            super.cm.acceptCall(obtainCompleteMessage());
        } else
        if(ringingCall.getState() == com.android.internal.telephony.Call.State.WAITING) {
            setMute(false);
            switchWaitingOrHoldingAndActive();
        } else {
            throw new CallStateException("phone not ringing");
        }
    }

    boolean canConference() {
        boolean flag;
        if(foregroundCall.getState() == com.android.internal.telephony.Call.State.ACTIVE && backgroundCall.getState() == com.android.internal.telephony.Call.State.HOLDING && !backgroundCall.isFull() && !foregroundCall.isFull())
            flag = true;
        else
            flag = false;
        return flag;
    }

    boolean canDial() {
        int i = phone.getServiceState().getState();
        String s = SystemProperties.get("ro.telephony.disable-call", "false");
        boolean flag;
        if(i != 3 && pendingMO == null && !ringingCall.isRinging() && !s.equals("true") && (!foregroundCall.getState().isAlive() || !backgroundCall.getState().isAlive()))
            flag = true;
        else
            flag = false;
        return flag;
    }

    boolean canTransfer() {
        boolean flag;
        if(foregroundCall.getState() == com.android.internal.telephony.Call.State.ACTIVE && backgroundCall.getState() == com.android.internal.telephony.Call.State.HOLDING)
            flag = true;
        else
            flag = false;
        return flag;
    }

    void clearDisconnected() {
        internalClearDisconnected();
        updatePhoneState();
        phone.notifyPreciseCallStateChanged();
    }

    void conference() throws CallStateException {
        super.cm.conference(obtainCompleteMessage(11));
    }

    Connection dial(String s) throws CallStateException {
        return dial(s, 0, null);
    }

    Connection dial(String s, int i) throws CallStateException {
        return dial(s, i, null);
    }

    /**
     * @deprecated Method dial is deprecated
     */

    Connection dial(String s, int i, UUSInfo uusinfo) throws CallStateException {
        this;
        JVM INSTR monitorenter ;
        clearDisconnected();
        if(!canDial())
            throw new CallStateException("cannot dial in current state");
        break MISSING_BLOCK_LABEL_31;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        if(foregroundCall.getState() == com.android.internal.telephony.Call.State.ACTIVE) {
            switchWaitingOrHoldingAndActive();
            fakeHoldForegroundBeforeDial();
        }
        if(foregroundCall.getState() != com.android.internal.telephony.Call.State.IDLE)
            throw new CallStateException("cannot dial in current state");
        pendingMO = new GsmConnection(phone.getContext(), checkForTestEmergencyNumber(s), this, foregroundCall);
        hangupPendingMO = false;
        if(pendingMO.address != null && pendingMO.address.length() != 0 && pendingMO.address.indexOf('N') < 0)
            break MISSING_BLOCK_LABEL_183;
        pendingMO.cause = com.android.internal.telephony.Connection.DisconnectCause.INVALID_NUMBER;
        pollCallsWhenSafe();
_L1:
        GsmConnection gsmconnection;
        updatePhoneState();
        phone.notifyPreciseCallStateChanged();
        gsmconnection = pendingMO;
        this;
        JVM INSTR monitorexit ;
        return gsmconnection;
        setMute(false);
        super.cm.dial(pendingMO.address, i, uusinfo, obtainCompleteMessage());
          goto _L1
    }

    Connection dial(String s, UUSInfo uusinfo) throws CallStateException {
        return dial(s, 0, uusinfo);
    }

    public void dispose() {
        super.cm.unregisterForCallStateChanged(this);
        super.cm.unregisterForOn(this);
        super.cm.unregisterForNotAvailable(this);
        GsmConnection agsmconnection[] = connections;
        int i = agsmconnection.length;
        int j = 0;
        while(j < i)  {
            GsmConnection gsmconnection = agsmconnection[j];
            if(gsmconnection != null)
                try {
                    hangup(gsmconnection);
                }
                catch(CallStateException callstateexception1) {
                    Log.e("GSM", "unexpected error on hangup during dispose");
                }
            j++;
        }
        try {
            if(pendingMO != null)
                hangup(pendingMO);
        }
        catch(CallStateException callstateexception) {
            Log.e("GSM", "unexpected error on hangup during dispose");
        }
        clearDisconnected();
    }

    public void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        printwriter.println("GsmCallTracker extends:");
        super.dump(filedescriptor, printwriter, as);
        printwriter.println((new StringBuilder()).append("connections: length=").append(connections.length).toString());
        for(int i = 0; i < connections.length; i++) {
            Object aobj1[] = new Object[2];
            aobj1[0] = Integer.valueOf(i);
            aobj1[1] = connections[i];
            printwriter.printf("  connections[%d]=%s\n", aobj1);
        }

        printwriter.println((new StringBuilder()).append(" voiceCallEndedRegistrants=").append(voiceCallEndedRegistrants).toString());
        printwriter.println((new StringBuilder()).append(" voiceCallStartedRegistrants=").append(voiceCallStartedRegistrants).toString());
        printwriter.println((new StringBuilder()).append(" droppedDuringPoll: size=").append(droppedDuringPoll.size()).toString());
        for(int j = 0; j < droppedDuringPoll.size(); j++) {
            Object aobj[] = new Object[2];
            aobj[0] = Integer.valueOf(j);
            aobj[1] = droppedDuringPoll.get(j);
            printwriter.printf("  droppedDuringPoll[%d]=%s\n", aobj);
        }

        printwriter.println((new StringBuilder()).append(" ringingCall=").append(ringingCall).toString());
        printwriter.println((new StringBuilder()).append(" foregroundCall=").append(foregroundCall).toString());
        printwriter.println((new StringBuilder()).append(" backgroundCall=").append(backgroundCall).toString());
        printwriter.println((new StringBuilder()).append(" pendingMO=").append(pendingMO).toString());
        printwriter.println((new StringBuilder()).append(" hangupPendingMO=").append(hangupPendingMO).toString());
        printwriter.println((new StringBuilder()).append(" phone=").append(phone).toString());
        printwriter.println((new StringBuilder()).append(" desiredMute=").append(desiredMute).toString());
        printwriter.println((new StringBuilder()).append(" state=").append(state).toString());
    }

    void explicitCallTransfer() throws CallStateException {
        super.cm.explicitCallTransfer(obtainCompleteMessage(13));
    }

    protected void finalize() {
        Log.d("GSM", "GsmCallTracker finalized");
    }

    GsmConnection getConnectionByIndex(GsmCall gsmcall, int i) throws CallStateException {
        int j;
        int k;
        j = gsmcall.connections.size();
        k = 0;
_L3:
        GsmConnection gsmconnection;
        if(k >= j)
            break MISSING_BLOCK_LABEL_49;
        gsmconnection = (GsmConnection)gsmcall.connections.get(k);
        if(gsmconnection.getGSMIndex() != i) goto _L2; else goto _L1
_L1:
        return gsmconnection;
_L2:
        k++;
          goto _L3
        gsmconnection = null;
          goto _L1
    }

    boolean getMute() {
        return desiredMute;
    }

    public void handleMessage(Message message) {
        message.what;
        JVM INSTR tableswitch 1 13: default 72
    //                   1 73
    //                   2 391
    //                   3 391
    //                   4 113
    //                   5 163
    //                   6 72
    //                   7 72
    //                   8 128
    //                   9 398
    //                   10 405
    //                   11 128
    //                   12 128
    //                   13 128;
           goto _L1 _L2 _L3 _L3 _L4 _L5 _L1 _L1 _L6 _L7 _L8 _L6 _L6 _L6
_L1:
        return;
_L2:
        (AsyncResult)message.obj;
        if(message == super.lastRelevantPoll) {
            super.needsPoll = false;
            super.lastRelevantPoll = null;
            handlePollCalls((AsyncResult)message.obj);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        (AsyncResult)message.obj;
        operationComplete();
        continue; /* Loop/switch isn't completed */
_L6:
        if(((AsyncResult)message.obj).exception != null)
            phone.notifySuppServiceFailed(getFailedService(message.what));
        operationComplete();
        continue; /* Loop/switch isn't completed */
_L5:
        AsyncResult asyncresult = (AsyncResult)message.obj;
        operationComplete();
        int i;
        if(asyncresult.exception != null) {
            i = 16;
            Log.i("GSM", "Exception during getLastCallFailCause, assuming normal disconnect");
        } else {
            i = ((int[])(int[])asyncresult.result)[0];
        }
        if(i == 34 || i == 41 || i == 42 || i == 44 || i == 49 || i == 58 || i == 65535) {
            GsmCellLocation gsmcelllocation = (GsmCellLocation)phone.getCellLocation();
            Object aobj[] = new Object[3];
            aobj[0] = Integer.valueOf(i);
            int j;
            int k;
            int l;
            if(gsmcelllocation != null)
                j = gsmcelllocation.getCid();
            else
                j = -1;
            aobj[1] = Integer.valueOf(j);
            aobj[2] = Integer.valueOf(TelephonyManager.getDefault().getNetworkType());
            EventLog.writeEvent(50106, aobj);
        }
        k = 0;
        for(l = droppedDuringPoll.size(); k < l; k++)
            ((GsmConnection)droppedDuringPoll.get(k)).onRemoteDisconnect(i);

        updatePhoneState();
        phone.notifyPreciseCallStateChanged();
        droppedDuringPoll.clear();
        continue; /* Loop/switch isn't completed */
_L3:
        pollCallsWhenSafe();
        continue; /* Loop/switch isn't completed */
_L7:
        handleRadioAvailable();
        continue; /* Loop/switch isn't completed */
_L8:
        handleRadioNotAvailable();
        if(true) goto _L1; else goto _L9
_L9:
    }

    /**
     * @deprecated Method handlePollCalls is deprecated
     */

    protected void handlePollCalls(AsyncResult asyncresult) {
        this;
        JVM INSTR monitorenter ;
        if(asyncresult.exception != null) goto _L2; else goto _L1
_L1:
        Object obj = (List)asyncresult.result;
_L16:
        GsmConnection gsmconnection;
        boolean flag;
        boolean flag1;
        int i;
        int j;
        int k;
        gsmconnection = null;
        flag = false;
        flag1 = false;
        i = 0;
        j = 0;
        k = ((List) (obj)).size();
_L33:
        if(i >= connections.length) goto _L4; else goto _L3
_L3:
        GsmConnection gsmconnection2;
        DriverCall drivercall;
        gsmconnection2 = connections[i];
        drivercall = null;
        if(j >= k) goto _L6; else goto _L5
_L5:
        drivercall = (DriverCall)((List) (obj)).get(j);
        if(drivercall.index != i + 1) goto _L8; else goto _L7
_L7:
        j++;
_L6:
        if(gsmconnection2 != null || drivercall == null) goto _L10; else goto _L9
_L9:
        if(pendingMO == null || !pendingMO.compareTo(drivercall)) goto _L12; else goto _L11
_L11:
        connections[i] = pendingMO;
        pendingMO.index = i;
        pendingMO.update(drivercall);
        pendingMO = null;
        if(!hangupPendingMO) goto _L14; else goto _L13
_L13:
        hangupPendingMO = false;
        log((new StringBuilder()).append("poll: hangupPendingMO, hangup conn ").append(i).toString());
        hangup(connections[i]);
_L17:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
label0:
        {
            if(!isCommandExceptionRadioNotAvailable(asyncresult.exception))
                break label0;
            obj = new ArrayList();
        }
        if(true) goto _L16; else goto _L15
_L15:
        pollCallsAfterDelay();
          goto _L17
        Exception exception;
        exception;
        throw exception;
_L8:
        drivercall = null;
          goto _L6
        CallStateException callstateexception;
        callstateexception;
        Log.e("GSM", "unexpected error on hangup");
          goto _L17
_L12:
        GsmConnection agsmconnection1[] = connections;
        GsmConnection gsmconnection4 = new GsmConnection(phone.getContext(), drivercall, this, i);
        agsmconnection1[i] = gsmconnection4;
        if(connections[i].getCall() != ringingCall) goto _L19; else goto _L18
_L18:
        gsmconnection = connections[i];
          goto _L14
_L19:
        Log.i("GSM", (new StringBuilder()).append("Phantom call appeared ").append(drivercall).toString());
        if(drivercall.state != com.android.internal.telephony.DriverCall.State.ALERTING && drivercall.state != com.android.internal.telephony.DriverCall.State.DIALING)
            connections[i].connectTime = System.currentTimeMillis();
          goto _L20
_L10:
        if(gsmconnection2 == null || drivercall != null) goto _L22; else goto _L21
_L21:
        droppedDuringPoll.add(gsmconnection2);
        connections[i] = null;
          goto _L23
_L22:
        if(gsmconnection2 == null || drivercall == null || gsmconnection2.compareTo(drivercall)) goto _L25; else goto _L24
_L24:
        droppedDuringPoll.add(gsmconnection2);
        GsmConnection agsmconnection[] = connections;
        GsmConnection gsmconnection3 = new GsmConnection(phone.getContext(), drivercall, this, i);
        agsmconnection[i] = gsmconnection3;
        if(connections[i].getCall() == ringingCall)
            gsmconnection = connections[i];
          goto _L26
_L25:
        if(gsmconnection2 == null || drivercall == null) goto _L23; else goto _L27
_L27:
        boolean flag2 = gsmconnection2.update(drivercall);
        int l;
        if(flag || flag2)
            flag = true;
        else
            flag = false;
          goto _L23
_L4:
        if(pendingMO != null) {
            Log.d("GSM", (new StringBuilder()).append("Pending MO dropped before poll fg state:").append(foregroundCall.getState()).toString());
            droppedDuringPoll.add(pendingMO);
            pendingMO = null;
            hangupPendingMO = false;
        }
        if(gsmconnection != null)
            phone.notifyNewRingingConnection(gsmconnection);
        l = -1 + droppedDuringPoll.size();
_L34:
        if(l < 0) goto _L29; else goto _L28
_L28:
        GsmConnection gsmconnection1 = (GsmConnection)droppedDuringPoll.get(l);
        if(gsmconnection1.isIncoming() && gsmconnection1.getConnectTime() == 0L) {
            com.android.internal.telephony.Connection.DisconnectCause disconnectcause;
            if(gsmconnection1.cause == com.android.internal.telephony.Connection.DisconnectCause.LOCAL)
                disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.INCOMING_REJECTED;
            else
                disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.INCOMING_MISSED;
            log((new StringBuilder()).append("missed/rejected call, conn.cause=").append(gsmconnection1.cause).toString());
            log((new StringBuilder()).append("setting cause to ").append(disconnectcause).toString());
            droppedDuringPoll.remove(l);
            gsmconnection1.onDisconnect(disconnectcause);
        } else
        if(gsmconnection1.cause == com.android.internal.telephony.Connection.DisconnectCause.LOCAL) {
            droppedDuringPoll.remove(l);
            gsmconnection1.onDisconnect(com.android.internal.telephony.Connection.DisconnectCause.LOCAL);
        } else
        if(gsmconnection1.cause == com.android.internal.telephony.Connection.DisconnectCause.INVALID_NUMBER) {
            droppedDuringPoll.remove(l);
            gsmconnection1.onDisconnect(com.android.internal.telephony.Connection.DisconnectCause.INVALID_NUMBER);
        }
          goto _L30
_L29:
        if(droppedDuringPoll.size() > 0)
            super.cm.getLastCallFailCause(obtainNoPollCompleteMessage(5));
        if(false)
            pollCallsAfterDelay();
          goto _L31
_L35:
        internalClearDisconnected();
_L36:
        updatePhoneState();
        if(flag1)
            phone.notifyUnknownConnection();
          goto _L32
_L37:
        phone.notifyPreciseCallStateChanged();
        break; /* Loop/switch isn't completed */
_L14:
        flag = true;
_L23:
        i++;
          goto _L33
_L20:
        flag1 = true;
          goto _L14
_L26:
        flag = true;
          goto _L23
_L30:
        l--;
          goto _L34
_L31:
        if(gsmconnection == null && !flag) goto _L36; else goto _L35
_L32:
        if(!flag && gsmconnection == null) goto _L17; else goto _L37
    }

    void hangup(GsmCall gsmcall) throws CallStateException {
        if(gsmcall.getConnections().size() == 0)
            throw new CallStateException("no connections in call");
        if(gsmcall == ringingCall) {
            log("(ringing) hangup waiting or background");
            super.cm.hangupWaitingOrBackground(obtainCompleteMessage());
        } else
        if(gsmcall == foregroundCall) {
            if(gsmcall.isDialingOrAlerting()) {
                log("(foregnd) hangup dialing or alerting...");
                hangup((GsmConnection)(GsmConnection)gsmcall.getConnections().get(0));
            } else {
                hangupForegroundResumeBackground();
            }
        } else
        if(gsmcall == backgroundCall) {
            if(ringingCall.isRinging()) {
                log("hangup all conns in background call");
                hangupAllConnections(gsmcall);
            } else {
                hangupWaitingOrBackground();
            }
        } else {
            throw new RuntimeException((new StringBuilder()).append("GsmCall ").append(gsmcall).append("does not belong to GsmCallTracker ").append(this).toString());
        }
        gsmcall.onHangupLocal();
        phone.notifyPreciseCallStateChanged();
    }

    void hangup(GsmConnection gsmconnection) throws CallStateException {
        if(gsmconnection.owner != this)
            throw new CallStateException((new StringBuilder()).append("GsmConnection ").append(gsmconnection).append("does not belong to GsmCallTracker ").append(this).toString());
        if(gsmconnection == pendingMO) {
            log("hangup: set hangupPendingMO to true");
            hangupPendingMO = true;
        } else {
            try {
                super.cm.hangupConnection(gsmconnection.getGSMIndex(), obtainCompleteMessage());
            }
            catch(CallStateException callstateexception) {
                Log.w("GSM", (new StringBuilder()).append("GsmCallTracker WARN: hangup() on absent connection ").append(gsmconnection).toString());
            }
        }
        gsmconnection.onHangupLocal();
    }

    void hangupAllConnections(GsmCall gsmcall) throws CallStateException {
        int i;
        int j;
        i = gsmcall.connections.size();
        j = 0;
_L1:
        if(j >= i)
            break MISSING_BLOCK_LABEL_84;
        GsmConnection gsmconnection = (GsmConnection)gsmcall.connections.get(j);
        super.cm.hangupConnection(gsmconnection.getGSMIndex(), obtainCompleteMessage());
        j++;
          goto _L1
        CallStateException callstateexception;
        callstateexception;
        Log.e("GSM", (new StringBuilder()).append("hangupConnectionByIndex caught ").append(callstateexception).toString());
    }

    void hangupConnectionByIndex(GsmCall gsmcall, int i) throws CallStateException {
        int j = gsmcall.connections.size();
        for(int k = 0; k < j; k++)
            if(((GsmConnection)gsmcall.connections.get(k)).getGSMIndex() == i) {
                super.cm.hangupConnection(i, obtainCompleteMessage());
                return;
            }

        throw new CallStateException("no gsm index found");
    }

    void hangupForegroundResumeBackground() {
        log("hangupForegroundResumeBackground");
        super.cm.hangupForegroundResumeBackground(obtainCompleteMessage());
    }

    void hangupWaitingOrBackground() {
        log("hangupWaitingOrBackground");
        super.cm.hangupWaitingOrBackground(obtainCompleteMessage());
    }

    protected void log(String s) {
        Log.d("GSM", (new StringBuilder()).append("[GsmCallTracker] ").append(s).toString());
    }

    public void registerForVoiceCallEnded(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        voiceCallEndedRegistrants.add(registrant);
    }

    public void registerForVoiceCallStarted(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        voiceCallStartedRegistrants.add(registrant);
    }

    void rejectCall() throws CallStateException {
        if(ringingCall.getState().isRinging()) {
            super.cm.rejectCall(obtainCompleteMessage());
            return;
        } else {
            throw new CallStateException("phone not ringing");
        }
    }

    void separate(GsmConnection gsmconnection) throws CallStateException {
        if(gsmconnection.owner != this)
            throw new CallStateException((new StringBuilder()).append("GsmConnection ").append(gsmconnection).append("does not belong to GsmCallTracker ").append(this).toString());
        super.cm.separateConnection(gsmconnection.getGSMIndex(), obtainCompleteMessage(12));
_L1:
        return;
        CallStateException callstateexception;
        callstateexception;
        Log.w("GSM", (new StringBuilder()).append("GsmCallTracker WARN: separate() on absent connection ").append(gsmconnection).toString());
          goto _L1
    }

    void setMute(boolean flag) {
        desiredMute = flag;
        super.cm.setMute(desiredMute, null);
    }

    void switchWaitingOrHoldingAndActive() throws CallStateException {
        if(ringingCall.getState() == com.android.internal.telephony.Call.State.INCOMING) {
            throw new CallStateException("cannot be in the incoming state");
        } else {
            super.cm.switchWaitingOrHoldingAndActive(obtainCompleteMessage(8));
            return;
        }
    }

    public void unregisterForVoiceCallEnded(Handler handler) {
        voiceCallEndedRegistrants.remove(handler);
    }

    public void unregisterForVoiceCallStarted(Handler handler) {
        voiceCallStartedRegistrants.remove(handler);
    }

    private static final boolean DBG_POLL = false;
    static final String LOG_TAG = "GSM";
    static final int MAX_CONNECTIONS = 7;
    static final int MAX_CONNECTIONS_PER_CALL = 5;
    private static final boolean REPEAT_POLLING;
    GsmCall backgroundCall;
    GsmConnection connections[];
    boolean desiredMute;
    ArrayList droppedDuringPoll;
    GsmCall foregroundCall;
    boolean hangupPendingMO;
    GsmConnection pendingMO;
    GSMPhone phone;
    GsmCall ringingCall;
    com.android.internal.telephony.Phone.State state;
    RegistrantList voiceCallEndedRegistrants;
    RegistrantList voiceCallStartedRegistrants;
}
