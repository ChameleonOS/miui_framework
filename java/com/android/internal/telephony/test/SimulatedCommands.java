// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.test;

import android.os.*;
import android.util.Log;
import com.android.internal.telephony.*;
import com.android.internal.telephony.gsm.SmsBroadcastConfigInfo;
import com.android.internal.telephony.gsm.SuppServiceNotification;
import java.util.ArrayList;

// Referenced classes of package com.android.internal.telephony.test:
//            SimulatedRadioControl, SimulatedGsmCallState

public final class SimulatedCommands extends BaseCommands
    implements CommandsInterface, SimulatedRadioControl {
    private static final class SimFdnState extends Enum {

        public static SimFdnState valueOf(String s) {
            return (SimFdnState)Enum.valueOf(com/android/internal/telephony/test/SimulatedCommands$SimFdnState, s);
        }

        public static SimFdnState[] values() {
            return (SimFdnState[])$VALUES.clone();
        }

        private static final SimFdnState $VALUES[];
        public static final SimFdnState NONE;
        public static final SimFdnState REQUIRE_PIN2;
        public static final SimFdnState REQUIRE_PUK2;
        public static final SimFdnState SIM_PERM_LOCKED;

        static  {
            NONE = new SimFdnState("NONE", 0);
            REQUIRE_PIN2 = new SimFdnState("REQUIRE_PIN2", 1);
            REQUIRE_PUK2 = new SimFdnState("REQUIRE_PUK2", 2);
            SIM_PERM_LOCKED = new SimFdnState("SIM_PERM_LOCKED", 3);
            SimFdnState asimfdnstate[] = new SimFdnState[4];
            asimfdnstate[0] = NONE;
            asimfdnstate[1] = REQUIRE_PIN2;
            asimfdnstate[2] = REQUIRE_PUK2;
            asimfdnstate[3] = SIM_PERM_LOCKED;
            $VALUES = asimfdnstate;
        }

        private SimFdnState(String s, int i) {
            super(s, i);
        }
    }

    private static final class SimLockState extends Enum {

        public static SimLockState valueOf(String s) {
            return (SimLockState)Enum.valueOf(com/android/internal/telephony/test/SimulatedCommands$SimLockState, s);
        }

        public static SimLockState[] values() {
            return (SimLockState[])$VALUES.clone();
        }

        private static final SimLockState $VALUES[];
        public static final SimLockState NONE;
        public static final SimLockState REQUIRE_PIN;
        public static final SimLockState REQUIRE_PUK;
        public static final SimLockState SIM_PERM_LOCKED;

        static  {
            NONE = new SimLockState("NONE", 0);
            REQUIRE_PIN = new SimLockState("REQUIRE_PIN", 1);
            REQUIRE_PUK = new SimLockState("REQUIRE_PUK", 2);
            SIM_PERM_LOCKED = new SimLockState("SIM_PERM_LOCKED", 3);
            SimLockState asimlockstate[] = new SimLockState[4];
            asimlockstate[0] = NONE;
            asimlockstate[1] = REQUIRE_PIN;
            asimlockstate[2] = REQUIRE_PUK;
            asimlockstate[3] = SIM_PERM_LOCKED;
            $VALUES = asimlockstate;
        }

        private SimLockState(String s, int i) {
            super(s, i);
        }
    }


    public SimulatedCommands() {
        boolean flag = true;
        super(null);
        mSsnNotifyOn = false;
        pausedResponses = new ArrayList();
        nextCallFailCause = 16;
        mHandlerThread = new HandlerThread("SimulatedCommands");
        mHandlerThread.start();
        simulatedCallState = new SimulatedGsmCallState(mHandlerThread.getLooper());
        setRadioState(com.android.internal.telephony.CommandsInterface.RadioState.RADIO_OFF);
        mSimLockedState = INITIAL_LOCK_STATE;
        boolean flag1;
        if(mSimLockedState != SimLockState.NONE)
            flag1 = flag;
        else
            flag1 = false;
        mSimLockEnabled = flag1;
        mPinCode = "1234";
        mSimFdnEnabledState = INITIAL_FDN_STATE;
        if(mSimFdnEnabledState == SimFdnState.NONE)
            flag = false;
        mSimFdnEnabled = flag;
        mPin2Code = "5678";
    }

    private boolean isSimLocked() {
        boolean flag;
        if(mSimLockedState != SimLockState.NONE)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private void resultFail(Message message, Throwable throwable) {
        if(message != null) {
            AsyncResult.forMessage(message).exception = throwable;
            if(pausedResponseCount > 0)
                pausedResponses.add(message);
            else
                message.sendToTarget();
        }
    }

    private void resultSuccess(Message message, Object obj) {
        if(message != null) {
            AsyncResult.forMessage(message).result = obj;
            if(pausedResponseCount > 0)
                pausedResponses.add(message);
            else
                message.sendToTarget();
        }
    }

    private void unimplemented(Message message) {
        if(message != null) {
            AsyncResult.forMessage(message).exception = new RuntimeException("Unimplemented");
            if(pausedResponseCount > 0)
                pausedResponses.add(message);
            else
                message.sendToTarget();
        }
    }

    public void acceptCall(Message message) {
        if(!simulatedCallState.onAnswer())
            resultFail(message, new RuntimeException("Hangup Error"));
        else
            resultSuccess(message, null);
    }

    public void acknowledgeIncomingGsmSmsWithPdu(boolean flag, String s, Message message) {
        unimplemented(message);
    }

    public void acknowledgeLastIncomingCdmaSms(boolean flag, int i, Message message) {
        unimplemented(message);
    }

    public void acknowledgeLastIncomingGsmSms(boolean flag, int i, Message message) {
        unimplemented(message);
    }

    public void cancelPendingUssd(Message message) {
        resultSuccess(message, null);
    }

    public void changeBarringPassword(String s, String s1, String s2, Message message) {
        unimplemented(message);
    }

    public void changeIccPin(String s, String s1, Message message) {
        if(s == null || !s.equals(mPinCode)) goto _L2; else goto _L1
_L1:
        mPinCode = s1;
        if(message != null) {
            AsyncResult.forMessage(message, null, null);
            message.sendToTarget();
        }
_L4:
        return;
_L2:
        if(message != null) {
            Log.i("SIM", "[SimCmd] changeIccPin: pin failed!");
            AsyncResult.forMessage(message, null, new CommandException(com.android.internal.telephony.CommandException.Error.PASSWORD_INCORRECT));
            message.sendToTarget();
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void changeIccPin2(String s, String s1, Message message) {
        if(s == null || !s.equals(mPin2Code)) goto _L2; else goto _L1
_L1:
        mPin2Code = s1;
        if(message != null) {
            AsyncResult.forMessage(message, null, null);
            message.sendToTarget();
        }
_L4:
        return;
_L2:
        if(message != null) {
            Log.i("SIM", "[SimCmd] changeIccPin2: pin2 failed!");
            AsyncResult.forMessage(message, null, new CommandException(com.android.internal.telephony.CommandException.Error.PASSWORD_INCORRECT));
            message.sendToTarget();
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void changeIccPin2ForApp(String s, String s1, String s2, Message message) {
        unimplemented(message);
    }

    public void changeIccPinForApp(String s, String s1, String s2, Message message) {
        unimplemented(message);
    }

    public void conference(Message message) {
        if(!simulatedCallState.onChld('3', '\0'))
            resultFail(message, new RuntimeException("Hangup Error"));
        else
            resultSuccess(message, null);
    }

    public void deactivateDataCall(int i, int j, Message message) {
        unimplemented(message);
    }

    public void deleteSmsOnRuim(int i, Message message) {
        Log.d("SIM", (new StringBuilder()).append("Delete RUIM message at index ").append(i).toString());
        unimplemented(message);
    }

    public void deleteSmsOnSim(int i, Message message) {
        Log.d("SIM", (new StringBuilder()).append("Delete message at index ").append(i).toString());
        unimplemented(message);
    }

    public void dial(String s, int i, Message message) {
        simulatedCallState.onDial(s);
        resultSuccess(message, null);
    }

    public void dial(String s, int i, UUSInfo uusinfo, Message message) {
        simulatedCallState.onDial(s);
        resultSuccess(message, null);
    }

    public void exitEmergencyCallbackMode(Message message) {
        unimplemented(message);
    }

    public void explicitCallTransfer(Message message) {
        if(!simulatedCallState.onChld('4', '\0'))
            resultFail(message, new RuntimeException("Hangup Error"));
        else
            resultSuccess(message, null);
    }

    public void forceDataDormancy(Message message) {
        unimplemented(message);
    }

    public void getAvailableNetworks(Message message) {
        unimplemented(message);
    }

    public void getBasebandVersion(Message message) {
        resultSuccess(message, "SimulatedCommands");
    }

    public void getCDMASubscription(Message message) {
        Log.w("SIM", "CDMA not implemented in SimulatedCommands");
        unimplemented(message);
    }

    public void getCLIR(Message message) {
        unimplemented(message);
    }

    public void getCdmaBroadcastConfig(Message message) {
        unimplemented(message);
    }

    public void getCdmaSubscriptionSource(Message message) {
        unimplemented(message);
    }

    public void getCurrentCalls(Message message) {
        if(super.mState == com.android.internal.telephony.CommandsInterface.RadioState.RADIO_ON && !isSimLocked())
            resultSuccess(message, simulatedCallState.getDriverCalls());
        else
            resultFail(message, new CommandException(com.android.internal.telephony.CommandException.Error.RADIO_NOT_AVAILABLE));
    }

    public void getDataCallList(Message message) {
        resultSuccess(message, new ArrayList(0));
    }

    public void getDataRegistrationState(Message message) {
        String as[] = new String[4];
        as[0] = "5";
        as[1] = null;
        as[2] = null;
        as[3] = "2";
        resultSuccess(message, as);
    }

    public void getDeviceIdentity(Message message) {
        Log.w("SIM", "CDMA not implemented in SimulatedCommands");
        unimplemented(message);
    }

    public void getGsmBroadcastConfig(Message message) {
        unimplemented(message);
    }

    public void getIMEI(Message message) {
        resultSuccess(message, "012345678901234");
    }

    public void getIMEISV(Message message) {
        resultSuccess(message, "99");
    }

    public void getIMSI(Message message) {
        getIMSIForApp(null, message);
    }

    public void getIMSIForApp(String s, Message message) {
        resultSuccess(message, "012345678901234");
    }

    public void getIccCardStatus(Message message) {
        unimplemented(message);
    }

    public void getLastCallFailCause(Message message) {
        int ai[] = new int[1];
        ai[0] = nextCallFailCause;
        resultSuccess(message, ai);
    }

    public void getLastDataCallFailCause(Message message) {
        unimplemented(message);
    }

    public void getLastPdpFailCause(Message message) {
        unimplemented(message);
    }

    public void getMute(Message message) {
        unimplemented(message);
    }

    public void getNeighboringCids(Message message) {
        int ai[] = new int[7];
        ai[0] = 6;
        for(int i = 1; i < 7; i++)
            ai[i] = i;

        resultSuccess(message, ai);
    }

    public void getNetworkSelectionMode(Message message) {
        int ai[] = new int[1];
        ai[0] = 0;
        resultSuccess(message, ai);
    }

    public void getOperator(Message message) {
        String as[] = new String[3];
        as[0] = "El Telco Loco";
        as[1] = "Telco Loco";
        as[2] = "001001";
        resultSuccess(message, as);
    }

    public void getPDPContextList(Message message) {
        getDataCallList(message);
    }

    public void getPreferredNetworkType(Message message) {
        int ai[] = new int[1];
        ai[0] = mNetworkType;
        resultSuccess(message, ai);
    }

    public void getPreferredVoicePrivacy(Message message) {
        Log.w("SIM", "CDMA not implemented in SimulatedCommands");
        unimplemented(message);
    }

    public void getSignalStrength(Message message) {
        int ai[] = new int[2];
        ai[0] = 23;
        ai[1] = 0;
        resultSuccess(message, ai);
    }

    public void getSmscAddress(Message message) {
        unimplemented(message);
    }

    public void getVoiceRadioTechnology(Message message) {
        unimplemented(message);
    }

    public void getVoiceRegistrationState(Message message) {
        String as[] = new String[14];
        as[0] = "5";
        as[1] = null;
        as[2] = null;
        as[3] = null;
        as[4] = null;
        as[5] = null;
        as[6] = null;
        as[7] = null;
        as[8] = null;
        as[9] = null;
        as[10] = null;
        as[11] = null;
        as[12] = null;
        as[13] = null;
        resultSuccess(message, as);
    }

    public void handleCallSetupRequestFromSim(boolean flag, Message message) {
        resultSuccess(message, null);
    }

    public void hangupConnection(int i, Message message) {
        if(!simulatedCallState.onChld('1', (char)(i + 48))) {
            Log.i("GSM", "[SimCmd] hangupConnection: resultFail");
            resultFail(message, new RuntimeException("Hangup Error"));
        } else {
            Log.i("GSM", "[SimCmd] hangupConnection: resultSuccess");
            resultSuccess(message, null);
        }
    }

    public void hangupForegroundResumeBackground(Message message) {
        if(!simulatedCallState.onChld('1', '\0'))
            resultFail(message, new RuntimeException("Hangup Error"));
        else
            resultSuccess(message, null);
    }

    public void hangupWaitingOrBackground(Message message) {
        if(!simulatedCallState.onChld('0', '\0'))
            resultFail(message, new RuntimeException("Hangup Error"));
        else
            resultSuccess(message, null);
    }

    public void iccIO(int i, int j, String s, int k, int l, int i1, String s1, 
            String s2, Message message) {
        iccIOForApp(i, j, s, k, l, i1, s1, s2, null, message);
    }

    public void iccIOForApp(int i, int j, String s, int k, int l, int i1, String s1, 
            String s2, String s3, Message message) {
        unimplemented(message);
    }

    public void invokeOemRilRequestRaw(byte abyte0[], Message message) {
        if(message != null) {
            AsyncResult.forMessage(message).result = abyte0;
            message.sendToTarget();
        }
    }

    public void invokeOemRilRequestStrings(String as[], Message message) {
        if(message != null) {
            AsyncResult.forMessage(message).result = as;
            message.sendToTarget();
        }
    }

    public void pauseResponses() {
        pausedResponseCount = 1 + pausedResponseCount;
    }

    public void progressConnectingCallState() {
        simulatedCallState.progressConnectingCallState();
        super.mCallStateRegistrants.notifyRegistrants();
    }

    public void progressConnectingToActive() {
        simulatedCallState.progressConnectingToActive();
        super.mCallStateRegistrants.notifyRegistrants();
    }

    public void queryAvailableBandMode(Message message) {
        int ai[] = new int[4];
        ai[0] = 4;
        ai[1] = 2;
        ai[2] = 3;
        ai[3] = 4;
        resultSuccess(message, ai);
    }

    public void queryCLIP(Message message) {
        unimplemented(message);
    }

    public void queryCallForwardStatus(int i, int j, String s, Message message) {
        unimplemented(message);
    }

    public void queryCallWaiting(int i, Message message) {
        unimplemented(message);
    }

    public void queryCdmaRoamingPreference(Message message) {
        Log.w("SIM", "CDMA not implemented in SimulatedCommands");
        unimplemented(message);
    }

    public void queryFacilityLock(String s, String s1, int i, Message message) {
        queryFacilityLockForApp(s, s1, i, null, message);
    }

    public void queryFacilityLockForApp(String s, String s1, int i, String s2, Message message) {
        int j = 1;
        if(s == null || !s.equals("SC")) goto _L2; else goto _L1
_L1:
        if(message != null) {
            int ai1[] = new int[j];
            StringBuilder stringbuilder1;
            String s4;
            if(!mSimLockEnabled)
                j = 0;
            ai1[0] = j;
            stringbuilder1 = (new StringBuilder()).append("[SimCmd] queryFacilityLock: SIM is ");
            if(ai1[0] == 0)
                s4 = "unlocked";
            else
                s4 = "locked";
            Log.i("SIM", stringbuilder1.append(s4).toString());
            AsyncResult.forMessage(message, ai1, null);
            message.sendToTarget();
        }
_L4:
        return;
_L2:
        if(s != null && s.equals("FD")) {
            if(message != null) {
                int ai[] = new int[j];
                StringBuilder stringbuilder;
                String s3;
                if(!mSimFdnEnabled)
                    j = 0;
                ai[0] = j;
                stringbuilder = (new StringBuilder()).append("[SimCmd] queryFacilityLock: FDN is ");
                if(ai[0] == 0)
                    s3 = "disabled";
                else
                    s3 = "enabled";
                Log.i("SIM", stringbuilder.append(s3).toString());
                AsyncResult.forMessage(message, ai, null);
                message.sendToTarget();
            }
        } else {
            unimplemented(message);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void queryTTYMode(Message message) {
        Log.w("SIM", "CDMA not implemented in SimulatedCommands");
        unimplemented(message);
    }

    public void rejectCall(Message message) {
        if(!simulatedCallState.onChld('0', '\0'))
            resultFail(message, new RuntimeException("Hangup Error"));
        else
            resultSuccess(message, null);
    }

    public void reportSmsMemoryStatus(boolean flag, Message message) {
        unimplemented(message);
    }

    public void reportStkServiceIsRunning(Message message) {
        resultSuccess(message, null);
    }

    public void requestIsimAuthentication(String s, Message message) {
        unimplemented(message);
    }

    public void resetRadio(Message message) {
        unimplemented(message);
    }

    public void resumeResponses() {
        pausedResponseCount = -1 + pausedResponseCount;
        if(pausedResponseCount == 0) {
            int i = 0;
            for(int j = pausedResponses.size(); i < j; i++)
                ((Message)pausedResponses.get(i)).sendToTarget();

            pausedResponses.clear();
        } else {
            Log.e("GSM", "SimulatedCommands.resumeResponses < 0");
        }
    }

    public void sendBurstDtmf(String s, int i, int j, Message message) {
        resultSuccess(message, null);
    }

    public void sendCDMAFeatureCode(String s, Message message) {
        Log.w("SIM", "CDMA not implemented in SimulatedCommands");
        unimplemented(message);
    }

    public void sendCdmaSms(byte abyte0[], Message message) {
        Log.w("SIM", "CDMA not implemented in SimulatedCommands");
    }

    public void sendDtmf(char c, Message message) {
        resultSuccess(message, null);
    }

    public void sendEnvelope(String s, Message message) {
        resultSuccess(message, null);
    }

    public void sendEnvelopeWithStatus(String s, Message message) {
        resultSuccess(message, null);
    }

    public void sendSMS(String s, String s1, Message message) {
        unimplemented(message);
    }

    public void sendTerminalResponse(String s, Message message) {
        resultSuccess(message, null);
    }

    public void sendUSSD(String s, Message message) {
        if(s.equals("#646#")) {
            resultSuccess(message, null);
            triggerIncomingUssd("0", "You have NNN minutes remaining.");
        } else {
            resultSuccess(message, null);
            triggerIncomingUssd("0", "All Done");
        }
    }

    public void separateConnection(int i, Message message) {
        char c = (char)(i + 48);
        if(!simulatedCallState.onChld('2', c))
            resultFail(message, new RuntimeException("Hangup Error"));
        else
            resultSuccess(message, null);
    }

    public void setAutoProgressConnectingCall(boolean flag) {
        simulatedCallState.setAutoProgressConnectingCall(flag);
    }

    public void setBandMode(int i, Message message) {
        resultSuccess(message, null);
    }

    public void setCLIR(int i, Message message) {
        unimplemented(message);
    }

    public void setCallForward(int i, int j, int k, String s, int l, Message message) {
        unimplemented(message);
    }

    public void setCallWaiting(boolean flag, int i, Message message) {
        unimplemented(message);
    }

    public void setCdmaBroadcastActivation(boolean flag, Message message) {
        unimplemented(message);
    }

    public void setCdmaBroadcastConfig(int ai[], Message message) {
        unimplemented(message);
    }

    public void setCdmaRoamingPreference(int i, Message message) {
        Log.w("SIM", "CDMA not implemented in SimulatedCommands");
        unimplemented(message);
    }

    public void setCdmaSubscriptionSource(int i, Message message) {
        Log.w("SIM", "CDMA not implemented in SimulatedCommands");
        unimplemented(message);
    }

    public void setFacilityLock(String s, boolean flag, String s1, int i, Message message) {
        setFacilityLockForApp(s, flag, s1, i, null, message);
    }

    public void setFacilityLockForApp(String s, boolean flag, String s1, int i, String s2, Message message) {
        if(s == null || !s.equals("SC")) goto _L2; else goto _L1
_L1:
        if(s1 == null || !s1.equals(mPinCode)) goto _L4; else goto _L3
_L3:
        Log.i("SIM", "[SimCmd] setFacilityLock: pin is valid");
        mSimLockEnabled = flag;
        if(message != null) {
            AsyncResult.forMessage(message, null, null);
            message.sendToTarget();
        }
_L6:
        return;
_L4:
        if(message != null) {
            Log.i("SIM", "[SimCmd] setFacilityLock: pin failed!");
            AsyncResult.forMessage(message, null, new CommandException(com.android.internal.telephony.CommandException.Error.GENERIC_FAILURE));
            message.sendToTarget();
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if(s != null && s.equals("FD")) {
            if(s1 != null && s1.equals(mPin2Code)) {
                Log.i("SIM", "[SimCmd] setFacilityLock: pin2 is valid");
                mSimFdnEnabled = flag;
                if(message != null) {
                    AsyncResult.forMessage(message, null, null);
                    message.sendToTarget();
                }
            } else
            if(message != null) {
                Log.i("SIM", "[SimCmd] setFacilityLock: pin2 failed!");
                AsyncResult.forMessage(message, null, new CommandException(com.android.internal.telephony.CommandException.Error.GENERIC_FAILURE));
                message.sendToTarget();
            }
        } else {
            unimplemented(message);
        }
        if(true) goto _L6; else goto _L5
_L5:
    }

    public void setGsmBroadcastActivation(boolean flag, Message message) {
        unimplemented(message);
    }

    public void setGsmBroadcastConfig(SmsBroadcastConfigInfo asmsbroadcastconfiginfo[], Message message) {
        unimplemented(message);
    }

    public void setLocationUpdates(boolean flag, Message message) {
        unimplemented(message);
    }

    public void setMute(boolean flag, Message message) {
        unimplemented(message);
    }

    public void setNetworkSelectionModeAutomatic(Message message) {
        unimplemented(message);
    }

    public void setNetworkSelectionModeManual(String s, Message message) {
        unimplemented(message);
    }

    public void setNextCallFailCause(int i) {
        nextCallFailCause = i;
    }

    public void setNextDialFailImmediately(boolean flag) {
        simulatedCallState.setNextDialFailImmediately(flag);
    }

    public void setPhoneType(int i) {
        Log.w("SIM", "CDMA not implemented in SimulatedCommands");
    }

    public void setPreferredNetworkType(int i, Message message) {
        mNetworkType = i;
        resultSuccess(message, null);
    }

    public void setPreferredVoicePrivacy(boolean flag, Message message) {
        Log.w("SIM", "CDMA not implemented in SimulatedCommands");
        unimplemented(message);
    }

    public void setRadioPower(boolean flag, Message message) {
        if(flag)
            setRadioState(com.android.internal.telephony.CommandsInterface.RadioState.RADIO_ON);
        else
            setRadioState(com.android.internal.telephony.CommandsInterface.RadioState.RADIO_OFF);
    }

    public void setSmscAddress(String s, Message message) {
        unimplemented(message);
    }

    public void setSuppServiceNotifications(boolean flag, Message message) {
        resultSuccess(message, null);
        if(flag && mSsnNotifyOn)
            Log.w("SIM", "Supp Service Notifications already enabled!");
        mSsnNotifyOn = flag;
    }

    public void setTTYMode(int i, Message message) {
        Log.w("SIM", "Not implemented in SimulatedCommands");
        unimplemented(message);
    }

    public void setupDataCall(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            Message message) {
        unimplemented(message);
    }

    public void shutdown() {
        setRadioState(com.android.internal.telephony.CommandsInterface.RadioState.RADIO_UNAVAILABLE);
        Looper looper = mHandlerThread.getLooper();
        if(looper != null)
            looper.quit();
    }

    public void startDtmf(char c, Message message) {
        resultSuccess(message, null);
    }

    public void stopDtmf(Message message) {
        resultSuccess(message, null);
    }

    public void supplyIccPin(String s, Message message) {
        if(mSimLockedState == SimLockState.REQUIRE_PIN) goto _L2; else goto _L1
_L1:
        Log.i("SIM", (new StringBuilder()).append("[SimCmd] supplyIccPin: wrong state, state=").append(mSimLockedState).toString());
        AsyncResult.forMessage(message, null, new CommandException(com.android.internal.telephony.CommandException.Error.PASSWORD_INCORRECT));
        message.sendToTarget();
_L4:
        return;
_L2:
        if(s != null && s.equals(mPinCode)) {
            Log.i("SIM", "[SimCmd] supplyIccPin: success!");
            mPinUnlockAttempts = 0;
            mSimLockedState = SimLockState.NONE;
            super.mIccStatusChangedRegistrants.notifyRegistrants();
            if(message != null) {
                AsyncResult.forMessage(message, null, null);
                message.sendToTarget();
            }
        } else
        if(message != null) {
            mPinUnlockAttempts = 1 + mPinUnlockAttempts;
            Log.i("SIM", (new StringBuilder()).append("[SimCmd] supplyIccPin: failed! attempt=").append(mPinUnlockAttempts).toString());
            if(mPinUnlockAttempts >= 3) {
                Log.i("SIM", "[SimCmd] supplyIccPin: set state to REQUIRE_PUK");
                mSimLockedState = SimLockState.REQUIRE_PUK;
            }
            AsyncResult.forMessage(message, null, new CommandException(com.android.internal.telephony.CommandException.Error.PASSWORD_INCORRECT));
            message.sendToTarget();
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void supplyIccPin2(String s, Message message) {
        if(mSimFdnEnabledState == SimFdnState.REQUIRE_PIN2) goto _L2; else goto _L1
_L1:
        Log.i("SIM", (new StringBuilder()).append("[SimCmd] supplyIccPin2: wrong state, state=").append(mSimFdnEnabledState).toString());
        AsyncResult.forMessage(message, null, new CommandException(com.android.internal.telephony.CommandException.Error.PASSWORD_INCORRECT));
        message.sendToTarget();
_L4:
        return;
_L2:
        if(s != null && s.equals(mPin2Code)) {
            Log.i("SIM", "[SimCmd] supplyIccPin2: success!");
            mPin2UnlockAttempts = 0;
            mSimFdnEnabledState = SimFdnState.NONE;
            if(message != null) {
                AsyncResult.forMessage(message, null, null);
                message.sendToTarget();
            }
        } else
        if(message != null) {
            mPin2UnlockAttempts = 1 + mPin2UnlockAttempts;
            Log.i("SIM", (new StringBuilder()).append("[SimCmd] supplyIccPin2: failed! attempt=").append(mPin2UnlockAttempts).toString());
            if(mPin2UnlockAttempts >= 3) {
                Log.i("SIM", "[SimCmd] supplyIccPin2: set state to REQUIRE_PUK2");
                mSimFdnEnabledState = SimFdnState.REQUIRE_PUK2;
            }
            AsyncResult.forMessage(message, null, new CommandException(com.android.internal.telephony.CommandException.Error.PASSWORD_INCORRECT));
            message.sendToTarget();
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void supplyIccPin2ForApp(String s, String s1, Message message) {
        unimplemented(message);
    }

    public void supplyIccPinForApp(String s, String s1, Message message) {
        unimplemented(message);
    }

    public void supplyIccPuk(String s, String s1, Message message) {
        if(mSimLockedState == SimLockState.REQUIRE_PUK) goto _L2; else goto _L1
_L1:
        Log.i("SIM", (new StringBuilder()).append("[SimCmd] supplyIccPuk: wrong state, state=").append(mSimLockedState).toString());
        AsyncResult.forMessage(message, null, new CommandException(com.android.internal.telephony.CommandException.Error.PASSWORD_INCORRECT));
        message.sendToTarget();
_L4:
        return;
_L2:
        if(s != null && s.equals("12345678")) {
            Log.i("SIM", "[SimCmd] supplyIccPuk: success!");
            mSimLockedState = SimLockState.NONE;
            mPukUnlockAttempts = 0;
            super.mIccStatusChangedRegistrants.notifyRegistrants();
            if(message != null) {
                AsyncResult.forMessage(message, null, null);
                message.sendToTarget();
            }
        } else
        if(message != null) {
            mPukUnlockAttempts = 1 + mPukUnlockAttempts;
            Log.i("SIM", (new StringBuilder()).append("[SimCmd] supplyIccPuk: failed! attempt=").append(mPukUnlockAttempts).toString());
            if(mPukUnlockAttempts >= 10) {
                Log.i("SIM", "[SimCmd] supplyIccPuk: set state to SIM_PERM_LOCKED");
                mSimLockedState = SimLockState.SIM_PERM_LOCKED;
            }
            AsyncResult.forMessage(message, null, new CommandException(com.android.internal.telephony.CommandException.Error.PASSWORD_INCORRECT));
            message.sendToTarget();
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void supplyIccPuk2(String s, String s1, Message message) {
        if(mSimFdnEnabledState == SimFdnState.REQUIRE_PUK2) goto _L2; else goto _L1
_L1:
        Log.i("SIM", (new StringBuilder()).append("[SimCmd] supplyIccPuk2: wrong state, state=").append(mSimLockedState).toString());
        AsyncResult.forMessage(message, null, new CommandException(com.android.internal.telephony.CommandException.Error.PASSWORD_INCORRECT));
        message.sendToTarget();
_L4:
        return;
_L2:
        if(s != null && s.equals("87654321")) {
            Log.i("SIM", "[SimCmd] supplyIccPuk2: success!");
            mSimFdnEnabledState = SimFdnState.NONE;
            mPuk2UnlockAttempts = 0;
            if(message != null) {
                AsyncResult.forMessage(message, null, null);
                message.sendToTarget();
            }
        } else
        if(message != null) {
            mPuk2UnlockAttempts = 1 + mPuk2UnlockAttempts;
            Log.i("SIM", (new StringBuilder()).append("[SimCmd] supplyIccPuk2: failed! attempt=").append(mPuk2UnlockAttempts).toString());
            if(mPuk2UnlockAttempts >= 10) {
                Log.i("SIM", "[SimCmd] supplyIccPuk2: set state to SIM_PERM_LOCKED");
                mSimFdnEnabledState = SimFdnState.SIM_PERM_LOCKED;
            }
            AsyncResult.forMessage(message, null, new CommandException(com.android.internal.telephony.CommandException.Error.PASSWORD_INCORRECT));
            message.sendToTarget();
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void supplyIccPuk2ForApp(String s, String s1, String s2, Message message) {
        unimplemented(message);
    }

    public void supplyIccPukForApp(String s, String s1, String s2, Message message) {
        unimplemented(message);
    }

    public void supplyNetworkDepersonalization(String s, Message message) {
        unimplemented(message);
    }

    public void switchWaitingOrHoldingAndActive(Message message) {
        if(!simulatedCallState.onChld('2', '\0'))
            resultFail(message, new RuntimeException("Hangup Error"));
        else
            resultSuccess(message, null);
    }

    public void triggerHangupAll() {
        simulatedCallState.triggerHangupAll();
        super.mCallStateRegistrants.notifyRegistrants();
    }

    public void triggerHangupBackground() {
        simulatedCallState.triggerHangupBackground();
        super.mCallStateRegistrants.notifyRegistrants();
    }

    public void triggerHangupForeground() {
        simulatedCallState.triggerHangupForeground();
        super.mCallStateRegistrants.notifyRegistrants();
    }

    public void triggerIncomingSMS(String s) {
    }

    public void triggerIncomingUssd(String s, String s1) {
        if(super.mUSSDRegistrant != null) {
            String as[] = new String[2];
            as[0] = s;
            as[1] = s1;
            super.mUSSDRegistrant.notifyResult(as);
        }
    }

    public void triggerRing(String s) {
        simulatedCallState.triggerRing(s);
        super.mCallStateRegistrants.notifyRegistrants();
    }

    public void triggerSsn(int i, int j) {
        SuppServiceNotification suppservicenotification = new SuppServiceNotification();
        suppservicenotification.notificationType = i;
        suppservicenotification.code = j;
        super.mSsnRegistrant.notifyRegistrant(new AsyncResult(null, suppservicenotification, null));
    }

    public void writeSmsToRuim(int i, String s, Message message) {
        Log.d("SIM", (new StringBuilder()).append("Write SMS to RUIM with status ").append(i).toString());
        unimplemented(message);
    }

    public void writeSmsToSim(int i, String s, String s1, Message message) {
        Log.d("SIM", (new StringBuilder()).append("Write SMS to SIM with status ").append(i).toString());
        unimplemented(message);
    }

    private static final String DEFAULT_SIM_PIN2_CODE = "5678";
    private static final String DEFAULT_SIM_PIN_CODE = "1234";
    private static final SimFdnState INITIAL_FDN_STATE;
    private static final SimLockState INITIAL_LOCK_STATE;
    private static final String LOG_TAG = "SIM";
    private static final String SIM_PUK2_CODE = "87654321";
    private static final String SIM_PUK_CODE = "12345678";
    HandlerThread mHandlerThread;
    int mNetworkType;
    String mPin2Code;
    int mPin2UnlockAttempts;
    String mPinCode;
    int mPinUnlockAttempts;
    int mPuk2UnlockAttempts;
    int mPukUnlockAttempts;
    boolean mSimFdnEnabled;
    SimFdnState mSimFdnEnabledState;
    boolean mSimLockEnabled;
    SimLockState mSimLockedState;
    boolean mSsnNotifyOn;
    int nextCallFailCause;
    int pausedResponseCount;
    ArrayList pausedResponses;
    SimulatedGsmCallState simulatedCallState;

    static  {
        INITIAL_LOCK_STATE = SimLockState.NONE;
        INITIAL_FDN_STATE = SimFdnState.NONE;
    }
}
