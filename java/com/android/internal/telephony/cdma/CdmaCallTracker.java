// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cdma;

import android.os.*;
import android.telephony.PhoneNumberUtils;
import android.telephony.ServiceState;
import android.util.Log;
import com.android.internal.telephony.*;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.android.internal.telephony.cdma:
//            CdmaConnection, CdmaCall, CDMAPhone, CdmaCallWaitingNotification

public final class CdmaCallTracker extends CallTracker {

    CdmaCallTracker(CDMAPhone cdmaphone) {
        connections = new CdmaConnection[1];
        voiceCallEndedRegistrants = new RegistrantList();
        voiceCallStartedRegistrants = new RegistrantList();
        callWaitingRegistrants = new RegistrantList();
        droppedDuringPoll = new ArrayList(1);
        ringingCall = new CdmaCall(this);
        foregroundCall = new CdmaCall(this);
        backgroundCall = new CdmaCall(this);
        pendingCallInEcm = false;
        mIsInEmergencyCall = false;
        desiredMute = false;
        state = com.android.internal.telephony.Phone.State.IDLE;
        mIsEcmTimerCanceled = false;
        phone = cdmaphone;
        super.cm = ((PhoneBase) (cdmaphone)).mCM;
        super.cm.registerForCallStateChanged(this, 2, null);
        super.cm.registerForOn(this, 9, null);
        super.cm.registerForNotAvailable(this, 10, null);
        super.cm.registerForCallWaitingInfo(this, 15, null);
        foregroundCall.setGeneric(false);
    }

    private void checkAndEnableDataCallAfterEmergencyCallDropped() {
        if(mIsInEmergencyCall) {
            mIsInEmergencyCall = false;
            String s = SystemProperties.get("ril.cdma.inecmmode", "false");
            log((new StringBuilder()).append("checkAndEnableDataCallAfterEmergencyCallDropped,inEcm=").append(s).toString());
            if(s.compareTo("false") == 0)
                ((PhoneBase) (phone)).mDataConnectionTracker.setInternalDataEnabled(true);
        }
    }

    private Connection checkMtFindNewRinging(DriverCall drivercall, int i) {
        CdmaConnection cdmaconnection;
        cdmaconnection = null;
        connections[i] = new CdmaConnection(phone.getContext(), drivercall, this, i);
        if(connections[i].getCall() != ringingCall) goto _L2; else goto _L1
_L1:
        cdmaconnection = connections[i];
        log((new StringBuilder()).append("Notify new ring ").append(drivercall).toString());
_L4:
        return cdmaconnection;
_L2:
        Log.e("CDMA", (new StringBuilder()).append("Phantom call appeared ").append(drivercall).toString());
        if(drivercall.state != com.android.internal.telephony.DriverCall.State.ALERTING && drivercall.state != com.android.internal.telephony.DriverCall.State.DIALING)
            connections[i].connectTime = System.currentTimeMillis();
        if(true) goto _L4; else goto _L3
_L3:
    }

    private Connection dialThreeWay(String s) {
        CdmaConnection cdmaconnection;
        if(!foregroundCall.isIdle()) {
            disableDataCallInEmergencyCall(s);
            pendingMO = new CdmaConnection(phone.getContext(), checkForTestEmergencyNumber(s), this, foregroundCall);
            super.cm.sendCDMAFeatureCode(pendingMO.address, obtainMessage(16));
            cdmaconnection = pendingMO;
        } else {
            cdmaconnection = null;
        }
        return cdmaconnection;
    }

    private void disableDataCallInEmergencyCall(String s) {
        if(PhoneNumberUtils.isLocalEmergencyNumber(s, phone.getContext())) {
            log("disableDataCallInEmergencyCall");
            mIsInEmergencyCall = true;
            ((PhoneBase) (phone)).mDataConnectionTracker.setInternalDataEnabled(false);
        }
    }

    private void fakeHoldForegroundBeforeDial() {
        List list = (List)foregroundCall.connections.clone();
        int i = 0;
        for(int j = list.size(); i < j; i++)
            ((CdmaConnection)list.get(i)).fakeHoldBeforeDial();

    }

    private void flashAndSetGenericTrue() throws CallStateException {
        super.cm.sendCDMAFeatureCode("", obtainMessage(8));
        foregroundCall.setGeneric(true);
        phone.notifyPreciseCallStateChanged();
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

    private void handleCallWaitingInfo(CdmaCallWaitingNotification cdmacallwaitingnotification) {
        if(foregroundCall.connections.size() > 1)
            foregroundCall.setGeneric(true);
        ringingCall.setGeneric(false);
        new CdmaConnection(phone.getContext(), cdmacallwaitingnotification, this, ringingCall);
        updatePhoneState();
        notifyCallWaitingInfo(cdmacallwaitingnotification);
    }

    private void handleEcmTimer(int i) {
        phone.handleTimerInEmergencyCallbackMode(i);
        i;
        JVM INSTR tableswitch 0 1: default 32
    //                   0 67
    //                   1 59;
           goto _L1 _L2 _L3
_L1:
        Log.e("CDMA", (new StringBuilder()).append("handleEcmTimer, unsupported action ").append(i).toString());
_L5:
        return;
_L3:
        mIsEcmTimerCanceled = true;
        continue; /* Loop/switch isn't completed */
_L2:
        mIsEcmTimerCanceled = false;
        if(true) goto _L5; else goto _L4
_L4:
    }

    private void handleRadioNotAvailable() {
        pollCallsWhenSafe();
    }

    private void internalClearDisconnected() {
        ringingCall.clearDisconnected();
        foregroundCall.clearDisconnected();
        backgroundCall.clearDisconnected();
    }

    private void notifyCallWaitingInfo(CdmaCallWaitingNotification cdmacallwaitingnotification) {
        if(callWaitingRegistrants != null)
            callWaitingRegistrants.notifyRegistrants(new AsyncResult(null, cdmacallwaitingnotification, null));
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
            Log.e("CDMA", "CdmaCallTracker.pendingOperations < 0");
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
        log((new StringBuilder()).append("update phone state, old=").append(state1).append(" new=").append(state).toString());
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
            CdmaConnection cdmaconnection = (CdmaConnection)(CdmaConnection)ringingCall.getLatestConnection();
            cdmaconnection.updateParent(ringingCall, foregroundCall);
            cdmaconnection.onConnectedInOrOut();
            updatePhoneState();
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
        boolean flag = true;
        int i = phone.getServiceState().getState();
        String s = SystemProperties.get("ro.telephony.disable-call", "false");
        boolean flag1;
        if(i != 3 && pendingMO == null && !ringingCall.isRinging() && !s.equals("true") && (!foregroundCall.getState().isAlive() || foregroundCall.getState() == com.android.internal.telephony.Call.State.ACTIVE || !backgroundCall.getState().isAlive()))
            flag1 = flag;
        else
            flag1 = false;
        if(!flag1) {
            Object aobj[] = new Object[8];
            aobj[0] = Integer.valueOf(i);
            boolean flag2;
            boolean flag3;
            boolean flag4;
            boolean flag5;
            boolean flag6;
            boolean flag7;
            if(i != 3)
                flag2 = flag;
            else
                flag2 = false;
            aobj[flag] = Boolean.valueOf(flag2);
            if(pendingMO == null)
                flag3 = flag;
            else
                flag3 = false;
            aobj[2] = Boolean.valueOf(flag3);
            if(!ringingCall.isRinging())
                flag4 = flag;
            else
                flag4 = false;
            aobj[3] = Boolean.valueOf(flag4);
            if(!s.equals("true"))
                flag5 = flag;
            else
                flag5 = false;
            aobj[4] = Boolean.valueOf(flag5);
            if(!foregroundCall.getState().isAlive())
                flag6 = flag;
            else
                flag6 = false;
            aobj[5] = Boolean.valueOf(flag6);
            if(foregroundCall.getState() == com.android.internal.telephony.Call.State.ACTIVE)
                flag7 = flag;
            else
                flag7 = false;
            aobj[6] = Boolean.valueOf(flag7);
            if(backgroundCall.getState().isAlive())
                flag = false;
            aobj[7] = Boolean.valueOf(flag);
            log(String.format("canDial is false\n((serviceState=%d) != ServiceState.STATE_POWER_OFF)::=%s\n&& pendingMO == null::=%s\n&& !ringingCall.isRinging()::=%s\n&& !disableCall.equals(\"true\")::=%s\n&& (!foregroundCall.getState().isAlive()::=%s\n   || foregroundCall.getState() == CdmaCall.State.ACTIVE::=%s\n   ||!backgroundCall.getState().isAlive())::=%s)", aobj));
        }
        return flag1;
    }

    boolean canTransfer() {
        Log.e("CDMA", "canTransfer: not possible in CDMA");
        return false;
    }

    void clearDisconnected() {
        internalClearDisconnected();
        updatePhoneState();
        phone.notifyPreciseCallStateChanged();
    }

    void conference() throws CallStateException {
        flashAndSetGenericTrue();
    }

    Connection dial(String s) throws CallStateException {
        return dial(s, 0);
    }

    Connection dial(String s, int i) throws CallStateException {
        boolean flag;
        boolean flag1;
        clearDisconnected();
        if(!canDial())
            throw new CallStateException("cannot dial in current state");
        flag = SystemProperties.get("ril.cdma.inecmmode", "false").equals("true");
        flag1 = PhoneNumberUtils.isLocalEmergencyNumber(s, phone.getContext());
        if(flag && flag1) {
            phone;
            handleEcmTimer(1);
        }
        foregroundCall.setGeneric(false);
        if(foregroundCall.getState() != com.android.internal.telephony.Call.State.ACTIVE) goto _L2; else goto _L1
_L1:
        Object obj = dialThreeWay(s);
_L4:
        return ((Connection) (obj));
_L2:
        pendingMO = new CdmaConnection(phone.getContext(), checkForTestEmergencyNumber(s), this, foregroundCall);
        hangupPendingMO = false;
        if(pendingMO.address != null && pendingMO.address.length() != 0 && pendingMO.address.indexOf('N') < 0)
            break; /* Loop/switch isn't completed */
        pendingMO.cause = com.android.internal.telephony.Connection.DisconnectCause.INVALID_NUMBER;
        pollCallsWhenSafe();
_L5:
        updatePhoneState();
        phone.notifyPreciseCallStateChanged();
        obj = pendingMO;
        if(true) goto _L4; else goto _L3
_L3:
        setMute(false);
        disableDataCallInEmergencyCall(s);
        if(!flag || flag && flag1) {
            super.cm.dial(pendingMO.address, i, obtainCompleteMessage());
        } else {
            phone.exitEmergencyCallbackMode();
            phone.setOnEcbModeExitResponse(this, 14, null);
            pendingCallClirMode = i;
            pendingCallInEcm = true;
        }
          goto _L5
        if(true) goto _L4; else goto _L6
_L6:
    }

    public void dispose() {
        super.cm.unregisterForCallStateChanged(this);
        super.cm.unregisterForOn(this);
        super.cm.unregisterForNotAvailable(this);
        super.cm.unregisterForCallWaitingInfo(this);
        CdmaConnection acdmaconnection[] = connections;
        int i = acdmaconnection.length;
        int j = 0;
        while(j < i)  {
            CdmaConnection cdmaconnection = acdmaconnection[j];
            if(cdmaconnection != null)
                try {
                    hangup(cdmaconnection);
                }
                catch(CallStateException callstateexception1) {
                    Log.e("CDMA", "unexpected error on hangup during dispose");
                }
            j++;
        }
        try {
            if(pendingMO != null)
                hangup(pendingMO);
        }
        catch(CallStateException callstateexception) {
            Log.e("CDMA", "unexpected error on hangup during dispose");
        }
        clearDisconnected();
    }

    public void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        printwriter.println("GsmCallTracker extends:");
        super.dump(filedescriptor, printwriter, as);
        printwriter.println((new StringBuilder()).append("droppedDuringPoll: length=").append(connections.length).toString());
        for(int i = 0; i < connections.length; i++) {
            Object aobj1[] = new Object[2];
            aobj1[0] = Integer.valueOf(i);
            aobj1[1] = connections[i];
            printwriter.printf(" connections[%d]=%s\n", aobj1);
        }

        printwriter.println((new StringBuilder()).append(" voiceCallEndedRegistrants=").append(voiceCallEndedRegistrants).toString());
        printwriter.println((new StringBuilder()).append(" voiceCallStartedRegistrants=").append(voiceCallStartedRegistrants).toString());
        printwriter.println((new StringBuilder()).append(" callWaitingRegistrants=").append(callWaitingRegistrants).toString());
        printwriter.println((new StringBuilder()).append("droppedDuringPoll: size=").append(droppedDuringPoll.size()).toString());
        for(int j = 0; j < droppedDuringPoll.size(); j++) {
            Object aobj[] = new Object[2];
            aobj[0] = Integer.valueOf(j);
            aobj[1] = droppedDuringPoll.get(j);
            printwriter.printf(" droppedDuringPoll[%d]=%s\n", aobj);
        }

        printwriter.println((new StringBuilder()).append(" ringingCall=").append(ringingCall).toString());
        printwriter.println((new StringBuilder()).append(" foregroundCall=").append(foregroundCall).toString());
        printwriter.println((new StringBuilder()).append(" backgroundCall=").append(backgroundCall).toString());
        printwriter.println((new StringBuilder()).append(" pendingMO=").append(pendingMO).toString());
        printwriter.println((new StringBuilder()).append(" hangupPendingMO=").append(hangupPendingMO).toString());
        printwriter.println((new StringBuilder()).append(" pendingCallInEcm=").append(pendingCallInEcm).toString());
        printwriter.println((new StringBuilder()).append(" mIsInEmergencyCall=").append(mIsInEmergencyCall).toString());
        printwriter.println((new StringBuilder()).append(" phone=").append(phone).toString());
        printwriter.println((new StringBuilder()).append(" desiredMute=").append(desiredMute).toString());
        printwriter.println((new StringBuilder()).append(" pendingCallClirMode=").append(pendingCallClirMode).toString());
        printwriter.println((new StringBuilder()).append(" state=").append(state).toString());
        printwriter.println((new StringBuilder()).append(" mIsEcmTimerCanceled=").append(mIsEcmTimerCanceled).toString());
    }

    void explicitCallTransfer() throws CallStateException {
        super.cm.explicitCallTransfer(obtainCompleteMessage(13));
    }

    protected void finalize() {
        Log.d("CDMA", "CdmaCallTracker finalized");
    }

    CdmaConnection getConnectionByIndex(CdmaCall cdmacall, int i) throws CallStateException {
        int j;
        int k;
        j = cdmacall.connections.size();
        k = 0;
_L3:
        CdmaConnection cdmaconnection;
        if(k >= j)
            break MISSING_BLOCK_LABEL_49;
        cdmaconnection = (CdmaConnection)cdmacall.connections.get(k);
        if(cdmaconnection.getCDMAIndex() != i) goto _L2; else goto _L1
_L1:
        return cdmaconnection;
_L2:
        k++;
          goto _L3
        cdmaconnection = null;
          goto _L1
    }

    boolean getMute() {
        return desiredMute;
    }

    public void handleMessage(Message message) {
        message.what;
        JVM INSTR tableswitch 1 16: default 84
    //                   1 95
    //                   2 264
    //                   3 264
    //                   4 142
    //                   5 149
    //                   6 84
    //                   7 84
    //                   8 141
    //                   9 271
    //                   10 278
    //                   11 84
    //                   12 84
    //                   13 84
    //                   14 285
    //                   15 332
    //                   16 370;
           goto _L1 _L2 _L3 _L3 _L4 _L5 _L1 _L1 _L6 _L7 _L8 _L1 _L1 _L1 _L9 _L10 _L11
_L6:
        break; /* Loop/switch isn't completed */
_L1:
        throw new RuntimeException("unexpected event not handled");
_L2:
        Log.d("CDMA", "Event EVENT_POLL_CALLS_RESULT Received");
        (AsyncResult)message.obj;
        if(message == super.lastRelevantPoll) {
            super.needsPoll = false;
            super.lastRelevantPoll = null;
            handlePollCalls((AsyncResult)message.obj);
        }
_L13:
        return;
_L4:
        operationComplete();
        continue; /* Loop/switch isn't completed */
_L5:
        AsyncResult asyncresult1 = (AsyncResult)message.obj;
        operationComplete();
        int i;
        int j;
        if(asyncresult1.exception != null) {
            i = 16;
            Log.i("CDMA", "Exception during getLastCallFailCause, assuming normal disconnect");
        } else {
            i = ((int[])(int[])asyncresult1.result)[0];
        }
        j = 0;
        for(int k = droppedDuringPoll.size(); j < k; j++)
            ((CdmaConnection)droppedDuringPoll.get(j)).onRemoteDisconnect(i);

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
        continue; /* Loop/switch isn't completed */
_L9:
        if(pendingCallInEcm) {
            super.cm.dial(pendingMO.address, pendingCallClirMode, obtainCompleteMessage());
            pendingCallInEcm = false;
        }
        phone.unsetOnEcbModeExitResponse(this);
        continue; /* Loop/switch isn't completed */
_L10:
        AsyncResult asyncresult = (AsyncResult)message.obj;
        if(asyncresult.exception == null) {
            handleCallWaitingInfo((CdmaCallWaitingNotification)asyncresult.result);
            Log.d("CDMA", "Event EVENT_CALL_WAITING_INFO_CDMA Received");
        }
        continue; /* Loop/switch isn't completed */
_L11:
        if(((AsyncResult)message.obj).exception == null) {
            pendingMO.onConnectedInOrOut();
            pendingMO = null;
        }
        if(true) goto _L13; else goto _L12
_L12:
    }

    protected void handlePollCalls(AsyncResult asyncresult) {
        Connection connection;
        boolean flag;
        boolean flag1;
        int i;
        CdmaConnection cdmaconnection1;
        DriverCall drivercall;
        Object obj;
        int j;
        int k;
        if(asyncresult.exception == null) {
            obj = (List)asyncresult.result;
        } else {
label0:
            {
                if(!isCommandExceptionRadioNotAvailable(asyncresult.exception))
                    break label0;
                obj = new ArrayList();
            }
        }
        connection = null;
        flag = false;
        flag1 = false;
        i = 0;
        j = 0;
        k = ((List) (obj)).size();
_L8:
        if(i >= connections.length)
            break MISSING_BLOCK_LABEL_696;
        cdmaconnection1 = connections[i];
        drivercall = null;
        if(j < k) {
            drivercall = (DriverCall)((List) (obj)).get(j);
            if(drivercall.index == i + 1)
                j++;
            else
                drivercall = null;
        }
        if(cdmaconnection1 != null || drivercall == null) goto _L2; else goto _L1
_L1:
        if(pendingMO == null || !pendingMO.compareTo(drivercall)) goto _L4; else goto _L3
_L3:
        connections[i] = pendingMO;
        pendingMO.index = i;
        pendingMO.update(drivercall);
        pendingMO = null;
        if(!hangupPendingMO) goto _L6; else goto _L5
_L5:
        hangupPendingMO = false;
        if(mIsEcmTimerCanceled) {
            phone;
            handleEcmTimer(0);
        }
        log((new StringBuilder()).append("poll: hangupPendingMO, hangup conn ").append(i).toString());
        hangup(connections[i]);
_L7:
        return;
        pollCallsAfterDelay();
          goto _L7
        CallStateException callstateexception;
        callstateexception;
        Log.e("CDMA", "unexpected error on hangup");
          goto _L7
_L4:
        log((new StringBuilder()).append("pendingMo=").append(pendingMO).append(", dc=").append(drivercall).toString());
        connection = checkMtFindNewRinging(drivercall, i);
        if(connection == null)
            flag1 = true;
        checkAndEnableDataCallAfterEmergencyCallDropped();
_L6:
        flag = true;
_L9:
        i++;
          goto _L8
_L2:
        if(cdmaconnection1 != null && drivercall == null) {
            int i1 = foregroundCall.connections.size();
            for(int j1 = 0; j1 < i1; j1++) {
                log((new StringBuilder()).append("adding fgCall cn ").append(j1).append(" to droppedDuringPoll").toString());
                CdmaConnection cdmaconnection3 = (CdmaConnection)foregroundCall.connections.get(j1);
                droppedDuringPoll.add(cdmaconnection3);
            }

            int k1 = ringingCall.connections.size();
            for(int l1 = 0; l1 < k1; l1++) {
                log((new StringBuilder()).append("adding rgCall cn ").append(l1).append(" to droppedDuringPoll").toString());
                CdmaConnection cdmaconnection2 = (CdmaConnection)ringingCall.connections.get(l1);
                droppedDuringPoll.add(cdmaconnection2);
            }

            foregroundCall.setGeneric(false);
            ringingCall.setGeneric(false);
            if(mIsEcmTimerCanceled) {
                phone;
                handleEcmTimer(0);
            }
            checkAndEnableDataCallAfterEmergencyCallDropped();
            connections[i] = null;
        } else
        if(cdmaconnection1 != null && drivercall != null)
            if(cdmaconnection1.isIncoming != drivercall.isMT) {
                if(drivercall.isMT) {
                    droppedDuringPoll.add(cdmaconnection1);
                    connection = checkMtFindNewRinging(drivercall, i);
                    if(connection == null)
                        flag1 = true;
                    checkAndEnableDataCallAfterEmergencyCallDropped();
                } else {
                    Log.e("CDMA", (new StringBuilder()).append("Error in RIL, Phantom call appeared ").append(drivercall).toString());
                }
            } else {
                boolean flag2 = cdmaconnection1.update(drivercall);
                if(flag || flag2)
                    flag = true;
                else
                    flag = false;
            }
          goto _L9
        if(pendingMO != null) {
            Log.d("CDMA", (new StringBuilder()).append("Pending MO dropped before poll fg state:").append(foregroundCall.getState()).toString());
            droppedDuringPoll.add(pendingMO);
            pendingMO = null;
            hangupPendingMO = false;
            if(pendingCallInEcm)
                pendingCallInEcm = false;
        }
        if(connection != null)
            phone.notifyNewRingingConnection(connection);
        int l = -1 + droppedDuringPoll.size();
        while(l >= 0)  {
            CdmaConnection cdmaconnection = (CdmaConnection)droppedDuringPoll.get(l);
            if(cdmaconnection.isIncoming() && cdmaconnection.getConnectTime() == 0L) {
                com.android.internal.telephony.Connection.DisconnectCause disconnectcause;
                if(cdmaconnection.cause == com.android.internal.telephony.Connection.DisconnectCause.LOCAL)
                    disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.INCOMING_REJECTED;
                else
                    disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.INCOMING_MISSED;
                log((new StringBuilder()).append("missed/rejected call, conn.cause=").append(cdmaconnection.cause).toString());
                log((new StringBuilder()).append("setting cause to ").append(disconnectcause).toString());
                droppedDuringPoll.remove(l);
                cdmaconnection.onDisconnect(disconnectcause);
            } else
            if(cdmaconnection.cause == com.android.internal.telephony.Connection.DisconnectCause.LOCAL) {
                droppedDuringPoll.remove(l);
                cdmaconnection.onDisconnect(com.android.internal.telephony.Connection.DisconnectCause.LOCAL);
            } else
            if(cdmaconnection.cause == com.android.internal.telephony.Connection.DisconnectCause.INVALID_NUMBER) {
                droppedDuringPoll.remove(l);
                cdmaconnection.onDisconnect(com.android.internal.telephony.Connection.DisconnectCause.INVALID_NUMBER);
            }
            l--;
        }
        if(droppedDuringPoll.size() > 0)
            super.cm.getLastCallFailCause(obtainNoPollCompleteMessage(5));
        if(false)
            pollCallsAfterDelay();
        if(connection != null || flag)
            internalClearDisconnected();
        updatePhoneState();
        if(flag1)
            phone.notifyUnknownConnection();
        if(flag || connection != null)
            phone.notifyPreciseCallStateChanged();
          goto _L7
    }

    void hangup(CdmaCall cdmacall) throws CallStateException {
        if(cdmacall.getConnections().size() == 0)
            throw new CallStateException("no connections in call");
        if(cdmacall == ringingCall) {
            log("(ringing) hangup waiting or background");
            super.cm.hangupWaitingOrBackground(obtainCompleteMessage());
        } else
        if(cdmacall == foregroundCall) {
            if(cdmacall.isDialingOrAlerting()) {
                log("(foregnd) hangup dialing or alerting...");
                hangup((CdmaConnection)(CdmaConnection)cdmacall.getConnections().get(0));
            } else {
                hangupForegroundResumeBackground();
            }
        } else
        if(cdmacall == backgroundCall) {
            if(ringingCall.isRinging()) {
                log("hangup all conns in background call");
                hangupAllConnections(cdmacall);
            } else {
                hangupWaitingOrBackground();
            }
        } else {
            throw new RuntimeException((new StringBuilder()).append("CdmaCall ").append(cdmacall).append("does not belong to CdmaCallTracker ").append(this).toString());
        }
        cdmacall.onHangupLocal();
        phone.notifyPreciseCallStateChanged();
    }

    void hangup(CdmaConnection cdmaconnection) throws CallStateException {
        if(cdmaconnection.owner != this)
            throw new CallStateException((new StringBuilder()).append("CdmaConnection ").append(cdmaconnection).append("does not belong to CdmaCallTracker ").append(this).toString());
        if(cdmaconnection != pendingMO) goto _L2; else goto _L1
_L1:
        log("hangup: set hangupPendingMO to true");
        hangupPendingMO = true;
_L6:
        cdmaconnection.onHangupLocal();
_L4:
        return;
_L2:
        if(cdmaconnection.getCall() != ringingCall || ringingCall.getState() != com.android.internal.telephony.Call.State.WAITING)
            break; /* Loop/switch isn't completed */
        cdmaconnection.onLocalDisconnect();
        updatePhoneState();
        phone.notifyPreciseCallStateChanged();
        if(true) goto _L4; else goto _L3
_L3:
        try {
            super.cm.hangupConnection(cdmaconnection.getCDMAIndex(), obtainCompleteMessage());
        }
        catch(CallStateException callstateexception) {
            Log.w("CDMA", (new StringBuilder()).append("CdmaCallTracker WARN: hangup() on absent connection ").append(cdmaconnection).toString());
        }
        if(true) goto _L6; else goto _L5
_L5:
    }

    void hangupAllConnections(CdmaCall cdmacall) throws CallStateException {
        int i;
        int j;
        i = cdmacall.connections.size();
        j = 0;
_L1:
        if(j >= i)
            break MISSING_BLOCK_LABEL_84;
        CdmaConnection cdmaconnection = (CdmaConnection)cdmacall.connections.get(j);
        super.cm.hangupConnection(cdmaconnection.getCDMAIndex(), obtainCompleteMessage());
        j++;
          goto _L1
        CallStateException callstateexception;
        callstateexception;
        Log.e("CDMA", (new StringBuilder()).append("hangupConnectionByIndex caught ").append(callstateexception).toString());
    }

    void hangupConnectionByIndex(CdmaCall cdmacall, int i) throws CallStateException {
        int j = cdmacall.connections.size();
        for(int k = 0; k < j; k++)
            if(((CdmaConnection)cdmacall.connections.get(k)).getCDMAIndex() == i) {
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

    boolean isInEmergencyCall() {
        return mIsInEmergencyCall;
    }

    protected void log(String s) {
        Log.d("CDMA", (new StringBuilder()).append("[CdmaCallTracker] ").append(s).toString());
    }

    public void registerForCallWaiting(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        callWaitingRegistrants.add(registrant);
    }

    public void registerForVoiceCallEnded(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        voiceCallEndedRegistrants.add(registrant);
    }

    public void registerForVoiceCallStarted(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        voiceCallStartedRegistrants.add(registrant);
        if(state != com.android.internal.telephony.Phone.State.IDLE)
            registrant.notifyRegistrant(new AsyncResult(null, null, null));
    }

    void rejectCall() throws CallStateException {
        if(ringingCall.getState().isRinging()) {
            super.cm.rejectCall(obtainCompleteMessage());
            return;
        } else {
            throw new CallStateException("phone not ringing");
        }
    }

    void separate(CdmaConnection cdmaconnection) throws CallStateException {
        if(cdmaconnection.owner != this)
            throw new CallStateException((new StringBuilder()).append("CdmaConnection ").append(cdmaconnection).append("does not belong to CdmaCallTracker ").append(this).toString());
        super.cm.separateConnection(cdmaconnection.getCDMAIndex(), obtainCompleteMessage(12));
_L1:
        return;
        CallStateException callstateexception;
        callstateexception;
        Log.w("CDMA", (new StringBuilder()).append("CdmaCallTracker WARN: separate() on absent connection ").append(cdmaconnection).toString());
          goto _L1
    }

    void setMute(boolean flag) {
        desiredMute = flag;
        super.cm.setMute(desiredMute, null);
    }

    void switchWaitingOrHoldingAndActive() throws CallStateException {
        if(ringingCall.getState() == com.android.internal.telephony.Call.State.INCOMING)
            throw new CallStateException("cannot be in the incoming state");
        if(foregroundCall.getConnections().size() > 1)
            flashAndSetGenericTrue();
        else
            super.cm.sendCDMAFeatureCode("", obtainMessage(8));
    }

    public void unregisterForCallWaiting(Handler handler) {
        callWaitingRegistrants.remove(handler);
    }

    public void unregisterForVoiceCallEnded(Handler handler) {
        voiceCallEndedRegistrants.remove(handler);
    }

    public void unregisterForVoiceCallStarted(Handler handler) {
        voiceCallStartedRegistrants.remove(handler);
    }

    private static final boolean DBG_POLL = false;
    static final String LOG_TAG = "CDMA";
    static final int MAX_CONNECTIONS = 1;
    static final int MAX_CONNECTIONS_PER_CALL = 1;
    private static final boolean REPEAT_POLLING;
    CdmaCall backgroundCall;
    RegistrantList callWaitingRegistrants;
    CdmaConnection connections[];
    boolean desiredMute;
    ArrayList droppedDuringPoll;
    CdmaCall foregroundCall;
    boolean hangupPendingMO;
    private boolean mIsEcmTimerCanceled;
    boolean mIsInEmergencyCall;
    int pendingCallClirMode;
    boolean pendingCallInEcm;
    CdmaConnection pendingMO;
    CDMAPhone phone;
    CdmaCall ringingCall;
    com.android.internal.telephony.Phone.State state;
    RegistrantList voiceCallEndedRegistrants;
    RegistrantList voiceCallStartedRegistrants;
}
