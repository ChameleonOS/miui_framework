// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.test;

import android.os.*;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.android.internal.telephony.test:
//            CallInfo, InvalidStateEx

class SimulatedGsmCallState extends Handler {

    public SimulatedGsmCallState(Looper looper) {
        super(looper);
        calls = new CallInfo[7];
        autoProgressConnecting = true;
    }

    private int countActiveLines() throws InvalidStateEx {
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        int i;
        flag = false;
        flag1 = false;
        flag2 = false;
        flag3 = false;
        flag4 = false;
        flag5 = false;
        i = 0;
_L8:
        CallInfo callinfo;
        if(i >= calls.length)
            break MISSING_BLOCK_LABEL_242;
        callinfo = calls[i];
        if(callinfo == null) goto _L2; else goto _L1
_L1:
        if(flag || !callinfo.isMpty) goto _L4; else goto _L3
_L3:
        boolean flag6;
        boolean flag7;
        if(callinfo.state == CallInfo.State.HOLDING)
            flag5 = true;
        else
            flag5 = false;
_L6:
        flag |= callinfo.isMpty;
        if(callinfo.state == CallInfo.State.HOLDING)
            flag6 = true;
        else
            flag6 = false;
        flag1 |= flag6;
        if(callinfo.state == CallInfo.State.ACTIVE)
            flag7 = true;
        else
            flag7 = false;
        flag2 |= flag7;
        flag3 |= callinfo.isConnecting();
        flag4 |= callinfo.isRinging();
_L2:
        i++;
        continue; /* Loop/switch isn't completed */
_L4:
        if(callinfo.isMpty && flag5 && callinfo.state == CallInfo.State.ACTIVE) {
            Log.e("ModelInterpreter", "Invalid state");
            throw new InvalidStateEx();
        }
        if(callinfo.isMpty || !flag || !flag5 || callinfo.state != CallInfo.State.HOLDING) goto _L6; else goto _L5
_L5:
        Log.e("ModelInterpreter", "Invalid state");
        throw new InvalidStateEx();
        int j = 0;
        if(flag1)
            j = 0 + 1;
        if(flag2)
            j++;
        if(flag3)
            j++;
        if(flag4)
            j++;
        return j;
        if(true) goto _L8; else goto _L7
_L7:
    }

    public boolean conference() {
        boolean flag;
        int i;
        int j;
        flag = true;
        i = 0;
        j = 0;
_L3:
        if(j >= calls.length) goto _L2; else goto _L1
_L1:
        CallInfo callinfo1 = calls[j];
        if(callinfo1 == null)
            continue; /* Loop/switch isn't completed */
        i++;
        if(!callinfo1.isConnecting())
            continue; /* Loop/switch isn't completed */
        flag = false;
_L4:
        return flag;
        j++;
          goto _L3
_L2:
        int k = 0;
        while(k < calls.length)  {
            CallInfo callinfo = calls[k];
            if(callinfo != null) {
                callinfo.state = CallInfo.State.ACTIVE;
                if(i > 0)
                    callinfo.isMpty = flag;
            }
            k++;
        }
          goto _L4
    }

    public boolean explicitCallTransfer() {
        int i;
        int j;
        i = 0;
        j = 0;
_L3:
        if(j >= calls.length) goto _L2; else goto _L1
_L1:
        boolean flag;
        CallInfo callinfo = calls[j];
        if(callinfo == null)
            continue; /* Loop/switch isn't completed */
        i++;
        if(!callinfo.isConnecting())
            continue; /* Loop/switch isn't completed */
        flag = false;
_L4:
        return flag;
        j++;
          goto _L3
_L2:
        flag = triggerHangupAll();
          goto _L4
    }

    public List getClccLines() {
        ArrayList arraylist = new ArrayList(calls.length);
        for(int i = 0; i < calls.length; i++) {
            CallInfo callinfo = calls[i];
            if(callinfo != null)
                arraylist.add(callinfo.toCLCCLine(i + 1));
        }

        return arraylist;
    }

    public List getDriverCalls() {
        ArrayList arraylist = new ArrayList(calls.length);
        for(int i = 0; i < calls.length; i++) {
            CallInfo callinfo = calls[i];
            if(callinfo != null)
                arraylist.add(callinfo.toDriverCall(i + 1));
        }

        Log.d("GSM", (new StringBuilder()).append("SC< getDriverCalls ").append(arraylist).toString());
        return arraylist;
    }

    public void handleMessage(Message message) {
        this;
        JVM INSTR monitorenter ;
        message.what;
        JVM INSTR tableswitch 1 1: default 24
    //                   1 27;
           goto _L1 _L2
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        progressConnectingCallState();
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean onAnswer() {
        this;
        JVM INSTR monitorenter ;
        int i = 0;
        do {
label0:
            {
                boolean flag;
                if(i < calls.length) {
                    CallInfo callinfo = calls[i];
                    if(callinfo == null || callinfo.state != CallInfo.State.INCOMING && callinfo.state != CallInfo.State.WAITING)
                        break label0;
                    flag = switchActiveAndHeldOrWaiting();
                } else {
                    flag = false;
                }
                return flag;
            }
            i++;
        } while(true);
    }

    public boolean onChld(char c, char c1) {
        int i = 0;
        if(c1 == 0) goto _L2; else goto _L1
_L1:
        i = c1 + -49;
        if(i >= 0 && i < calls.length) goto _L2; else goto _L3
_L3:
        boolean flag = false;
_L5:
        return flag;
_L2:
        switch(c) {
        default:
            flag = false;
            break;

        case 48: // '0'
            flag = releaseHeldOrUDUB();
            break;

        case 49: // '1'
            if(c1 <= 0)
                flag = releaseActiveAcceptHeldOrWaiting();
            else
            if(calls[i] == null) {
                flag = false;
            } else {
                calls[i] = null;
                flag = true;
            }
            break;

        case 50: // '2'
            if(c1 <= 0)
                flag = switchActiveAndHeldOrWaiting();
            else
                flag = separateCall(i);
            break;

        case 51: // '3'
            flag = conference();
            break;

        case 52: // '4'
            flag = explicitCallTransfer();
            break;

        case 53: // '5'
            flag = false;
            break;
        }
        if(true) goto _L5; else goto _L4
_L4:
    }

    public boolean onDial(String s) {
        boolean flag;
        int i;
        flag = false;
        i = -1;
        Log.d("GSM", (new StringBuilder()).append("SC> dial '").append(s).append("'").toString());
        if(!nextDialFailImmediately) goto _L2; else goto _L1
_L1:
        nextDialFailImmediately = false;
        Log.d("GSM", "SC< dial fail (per request)");
_L4:
        return flag;
_L2:
        String s1 = PhoneNumberUtils.extractNetworkPortion(s);
        if(s1.length() == 0) {
            Log.d("GSM", "SC< dial fail (invalid ph num)");
            continue; /* Loop/switch isn't completed */
        }
        if(s1.startsWith("*99") && s1.endsWith("#")) {
            Log.d("GSM", "SC< dial ignored (gprs)");
            flag = true;
            continue; /* Loop/switch isn't completed */
        }
        try {
            if(countActiveLines() > 1) {
                Log.d("GSM", "SC< dial fail (invalid call state)");
                continue; /* Loop/switch isn't completed */
            }
        }
        catch(InvalidStateEx invalidstateex) {
            Log.d("GSM", "SC< dial fail (invalid call state)");
            continue; /* Loop/switch isn't completed */
        }
        for(int j = 0; j < calls.length; j++) {
            if(i < 0 && calls[j] == null)
                i = j;
            if(calls[j] != null && !calls[j].isActiveOrHeld()) {
                Log.d("GSM", "SC< dial fail (invalid call state)");
                continue; /* Loop/switch isn't completed */
            }
            if(calls[j] != null && calls[j].state == CallInfo.State.ACTIVE)
                calls[j].state = CallInfo.State.HOLDING;
        }

        if(i < 0) {
            Log.d("GSM", "SC< dial fail (invalid call state)");
        } else {
            calls[i] = CallInfo.createOutgoingCall(s1);
            if(autoProgressConnecting)
                sendMessageDelayed(obtainMessage(1, calls[i]), 500L);
            Log.d("GSM", (new StringBuilder()).append("SC< dial (slot = ").append(i).append(")").toString());
            flag = true;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean onHangup() {
        boolean flag = false;
        for(int i = 0; i < calls.length; i++) {
            CallInfo callinfo = calls[i];
            if(callinfo != null && callinfo.state != CallInfo.State.WAITING) {
                calls[i] = null;
                flag = true;
            }
        }

        return flag;
    }

    public void progressConnectingCallState() {
        this;
        JVM INSTR monitorenter ;
        int i = 0;
_L7:
        if(i >= calls.length) goto _L2; else goto _L1
_L1:
        CallInfo callinfo = calls[i];
        if(callinfo == null || callinfo.state != CallInfo.State.DIALING) goto _L4; else goto _L3
_L3:
        callinfo.state = CallInfo.State.ALERTING;
        if(autoProgressConnecting)
            sendMessageDelayed(obtainMessage(1, callinfo), 500L);
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        if(callinfo == null || callinfo.state != CallInfo.State.ALERTING)
            break; /* Loop/switch isn't completed */
        callinfo.state = CallInfo.State.ACTIVE;
        if(true) goto _L2; else goto _L5
_L5:
        i++;
        if(true) goto _L7; else goto _L6
_L6:
    }

    public void progressConnectingToActive() {
        this;
        JVM INSTR monitorenter ;
        int i = 0;
        do {
label0:
            {
                if(i < calls.length) {
                    CallInfo callinfo = calls[i];
                    if(callinfo == null || callinfo.state != CallInfo.State.DIALING && callinfo.state != CallInfo.State.ALERTING)
                        break label0;
                    callinfo.state = CallInfo.State.ACTIVE;
                }
                return;
            }
            i++;
        } while(true);
    }

    public boolean releaseActiveAcceptHeldOrWaiting() {
        boolean flag;
        flag = false;
        boolean flag1 = false;
        for(int i = 0; i < calls.length; i++) {
            CallInfo callinfo3 = calls[i];
            if(callinfo3 != null && callinfo3.state == CallInfo.State.ACTIVE) {
                calls[i] = null;
                flag1 = true;
            }
        }

        if(!flag1) {
            for(int l = 0; l < calls.length; l++) {
                CallInfo callinfo2 = calls[l];
                if(callinfo2 != null && (callinfo2.state == CallInfo.State.DIALING || callinfo2.state == CallInfo.State.ALERTING))
                    calls[l] = null;
            }

        }
        for(int j = 0; j < calls.length; j++) {
            CallInfo callinfo1 = calls[j];
            if(callinfo1 != null && callinfo1.state == CallInfo.State.HOLDING) {
                callinfo1.state = CallInfo.State.ACTIVE;
                flag = true;
            }
        }

        if(!flag) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        int k = 0;
        do {
            if(k < calls.length) {
label0:
                {
                    CallInfo callinfo = calls[k];
                    if(callinfo == null || !callinfo.isRinging())
                        break label0;
                    callinfo.state = CallInfo.State.ACTIVE;
                }
            }
            if(true)
                continue;
            k++;
        } while(true);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean releaseHeldOrUDUB() {
        boolean flag = false;
        int i = 0;
label0:
        do {
label1:
            {
                if(i < calls.length) {
                    CallInfo callinfo1 = calls[i];
                    if(callinfo1 == null || !callinfo1.isRinging())
                        break label1;
                    flag = true;
                    calls[i] = null;
                }
                if(!flag) {
                    for(int j = 0; j < calls.length; j++) {
                        CallInfo callinfo = calls[j];
                        if(callinfo != null && callinfo.state == CallInfo.State.HOLDING)
                            calls[j] = null;
                    }

                }
                break label0;
            }
            i++;
        } while(true);
        return true;
    }

    public boolean separateCall(int i) {
        boolean flag = true;
        int j;
        CallInfo callinfo = calls[i];
        if(callinfo == null || callinfo.isConnecting() || countActiveLines() != flag)
            break MISSING_BLOCK_LABEL_144;
        callinfo.state = CallInfo.State.ACTIVE;
        callinfo.isMpty = false;
        j = 0;
_L1:
        if(j >= calls.length)
            break MISSING_BLOCK_LABEL_146;
        int k = 0;
        int l = 0;
        if(j != i) {
            CallInfo callinfo1 = calls[j];
            if(callinfo1 != null && callinfo1.state == CallInfo.State.ACTIVE) {
                callinfo1.state = CallInfo.State.HOLDING;
                k = 0 + 1;
                l = j;
            }
        }
        if(k == flag)
            calls[l].isMpty = false;
        j++;
          goto _L1
        InvalidStateEx invalidstateex;
        invalidstateex;
        flag = false;
        break MISSING_BLOCK_LABEL_146;
        flag = false;
        return flag;
    }

    public void setAutoProgressConnectingCall(boolean flag) {
        autoProgressConnecting = flag;
    }

    public void setNextDialFailImmediately(boolean flag) {
        nextDialFailImmediately = flag;
    }

    public boolean switchActiveAndHeldOrWaiting() {
        boolean flag = false;
        int i = 0;
        do {
label0:
            {
label1:
                {
                    if(i < calls.length) {
                        CallInfo callinfo1 = calls[i];
                        if(callinfo1 == null || callinfo1.state != CallInfo.State.HOLDING)
                            break label1;
                        flag = true;
                    }
                    int j = 0;
                    while(j < calls.length)  {
                        CallInfo callinfo = calls[j];
                        if(callinfo != null)
                            if(callinfo.state == CallInfo.State.ACTIVE)
                                callinfo.state = CallInfo.State.HOLDING;
                            else
                            if(callinfo.state == CallInfo.State.HOLDING)
                                callinfo.state = CallInfo.State.ACTIVE;
                            else
                            if(!flag && callinfo.isRinging())
                                callinfo.state = CallInfo.State.ACTIVE;
                        j++;
                    }
                    break label0;
                }
                i++;
                continue;
            }
            return true;
        } while(true);
    }

    public boolean triggerHangupAll() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = false;
        for(int i = 0; i < calls.length; i++) {
            calls[i];
            if(calls[i] != null)
                flag = true;
            calls[i] = null;
        }

        return flag;
    }

    public boolean triggerHangupBackground() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = false;
        int i = 0;
        do {
            if(i < calls.length) {
                CallInfo callinfo = calls[i];
                if(callinfo != null && callinfo.state == CallInfo.State.HOLDING) {
                    calls[i] = null;
                    flag = true;
                }
            } else {
                return flag;
            }
            i++;
        } while(true);
    }

    public boolean triggerHangupForeground() {
        this;
        JVM INSTR monitorenter ;
        break MISSING_BLOCK_LABEL_2;
_L2:
        int j;
        if(j < calls.length) {
            CallInfo callinfo = calls[j];
            if(callinfo != null && (callinfo.state == CallInfo.State.DIALING || callinfo.state == CallInfo.State.ACTIVE || callinfo.state == CallInfo.State.ALERTING)) {
                calls[j] = null;
                flag = true;
            }
        } else {
            return flag;
        }
        j++;
        continue; /* Loop/switch isn't completed */
        boolean flag = false;
        for(int i = 0; i < calls.length; i++) {
            CallInfo callinfo1 = calls[i];
            if(callinfo1 != null && (callinfo1.state == CallInfo.State.INCOMING || callinfo1.state == CallInfo.State.WAITING)) {
                calls[i] = null;
                flag = true;
            }
        }

        j = 0;
        continue; /* Loop/switch isn't completed */
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean triggerRing(String s) {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        int i;
        boolean flag1;
        int j;
        i = -1;
        flag1 = false;
        j = 0;
_L2:
        CallInfo callinfo;
        if(j < calls.length) {
            callinfo = calls[j];
            if(callinfo == null && i < 0) {
                i = j;
            } else {
                if(callinfo == null || callinfo.state != CallInfo.State.INCOMING && callinfo.state != CallInfo.State.WAITING)
                    break MISSING_BLOCK_LABEL_156;
                Log.w("ModelInterpreter", "triggerRing failed; phone already ringing");
                break; /* Loop/switch isn't completed */
            }
            break MISSING_BLOCK_LABEL_148;
        }
        if(i < 0) {
            Log.w("ModelInterpreter", "triggerRing failed; all full");
            break; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_111;
        Exception exception;
        exception;
        throw exception;
        calls[i] = CallInfo.createIncomingCall(PhoneNumberUtils.extractNetworkPortion(s));
        if(flag1)
            calls[i].state = CallInfo.State.WAITING;
        this;
        JVM INSTR monitorexit ;
        flag = true;
        break; /* Loop/switch isn't completed */
_L3:
        j++;
        if(true) goto _L2; else goto _L1
_L1:
        return flag;
        if(callinfo != null)
            flag1 = true;
          goto _L3
    }

    static final int CONNECTING_PAUSE_MSEC = 500;
    static final int EVENT_PROGRESS_CALL_STATE = 1;
    static final int MAX_CALLS = 7;
    private boolean autoProgressConnecting;
    CallInfo calls[];
    private boolean nextDialFailImmediately;
}
