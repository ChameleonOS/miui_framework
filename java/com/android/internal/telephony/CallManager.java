// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.content.Context;
import android.media.AudioManager;
import android.os.*;
import android.telephony.ServiceState;
import android.util.Log;
import com.android.internal.telephony.sip.SipPhone;
import java.util.*;

// Referenced classes of package com.android.internal.telephony:
//            Phone, Call, PhoneProxy, CallStateException, 
//            Connection, UUSInfo

public final class CallManager {

    private CallManager() {
        mHandler = new Handler() {

            public void handleMessage(Message message) {
                message.what;
                JVM INSTR tableswitch 100 119: default 100
            //                           100 101
            //                           101 121
            //                           102 141
            //                           103 254
            //                           104 274
            //                           105 304
            //                           106 324
            //                           107 344
            //                           108 364
            //                           109 384
            //                           110 404
            //                           111 424
            //                           112 444
            //                           113 464
            //                           114 484
            //                           115 504
            //                           116 524
            //                           117 544
            //                           118 564
            //                           119 584;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21
_L1:
                return;
_L2:
                mDisconnectRegistrants.notifyRegistrants((AsyncResult)message.obj);
                continue; /* Loop/switch isn't completed */
_L3:
                mPreciseCallStateRegistrants.notifyRegistrants((AsyncResult)message.obj);
                continue; /* Loop/switch isn't completed */
_L4:
                if(getActiveFgCallState().isDialing() || hasMoreThanOneRingingCall()) {
                    Connection connection = (Connection)((AsyncResult)message.obj).result;
                    try {
                        Log.d("CallManager", (new StringBuilder()).append("silently drop incoming call: ").append(connection.getCall()).toString());
                        connection.getCall().hangup();
                    }
                    catch(CallStateException callstateexception) {
                        Log.w("CallManager", "new ringing connection", callstateexception);
                    }
                } else {
                    mNewRingingConnectionRegistrants.notifyRegistrants((AsyncResult)message.obj);
                }
                continue; /* Loop/switch isn't completed */
_L5:
                mUnknownConnectionRegistrants.notifyRegistrants((AsyncResult)message.obj);
                continue; /* Loop/switch isn't completed */
_L6:
                if(!hasActiveFgCall())
                    mIncomingRingRegistrants.notifyRegistrants((AsyncResult)message.obj);
                continue; /* Loop/switch isn't completed */
_L7:
                mRingbackToneRegistrants.notifyRegistrants((AsyncResult)message.obj);
                continue; /* Loop/switch isn't completed */
_L8:
                mInCallVoicePrivacyOnRegistrants.notifyRegistrants((AsyncResult)message.obj);
                continue; /* Loop/switch isn't completed */
_L9:
                mInCallVoicePrivacyOffRegistrants.notifyRegistrants((AsyncResult)message.obj);
                continue; /* Loop/switch isn't completed */
_L10:
                mCallWaitingRegistrants.notifyRegistrants((AsyncResult)message.obj);
                continue; /* Loop/switch isn't completed */
_L11:
                mDisplayInfoRegistrants.notifyRegistrants((AsyncResult)message.obj);
                continue; /* Loop/switch isn't completed */
_L12:
                mSignalInfoRegistrants.notifyRegistrants((AsyncResult)message.obj);
                continue; /* Loop/switch isn't completed */
_L13:
                mCdmaOtaStatusChangeRegistrants.notifyRegistrants((AsyncResult)message.obj);
                continue; /* Loop/switch isn't completed */
_L14:
                mResendIncallMuteRegistrants.notifyRegistrants((AsyncResult)message.obj);
                continue; /* Loop/switch isn't completed */
_L15:
                mMmiInitiateRegistrants.notifyRegistrants((AsyncResult)message.obj);
                continue; /* Loop/switch isn't completed */
_L16:
                mMmiCompleteRegistrants.notifyRegistrants((AsyncResult)message.obj);
                continue; /* Loop/switch isn't completed */
_L17:
                mEcmTimerResetRegistrants.notifyRegistrants((AsyncResult)message.obj);
                continue; /* Loop/switch isn't completed */
_L18:
                mSubscriptionInfoReadyRegistrants.notifyRegistrants((AsyncResult)message.obj);
                continue; /* Loop/switch isn't completed */
_L19:
                mSuppServiceFailedRegistrants.notifyRegistrants((AsyncResult)message.obj);
                continue; /* Loop/switch isn't completed */
_L20:
                mServiceStateChangedRegistrants.notifyRegistrants((AsyncResult)message.obj);
                if(true) goto _L1; else goto _L21
_L21:
                int i = 0;
                while(i < mPostDialCharacterRegistrants.size())  {
                    Message message1 = ((Registrant)mPostDialCharacterRegistrants.get(i)).messageForRegistrant();
                    message1.obj = message.obj;
                    message1.arg1 = message.arg1;
                    message1.sendToTarget();
                    i++;
                }
                if(true) goto _L1; else goto _L22
_L22:
            }

            final CallManager this$0;

             {
                this$0 = CallManager.this;
                super();
            }
        };
        mDefaultPhone = null;
    }

    private boolean canDial(Phone phone) {
        int i = phone.getServiceState().getState();
        boolean flag = hasActiveRingingCall();
        boolean flag1 = hasActiveFgCall();
        boolean flag2 = hasActiveBgCall();
        boolean flag3;
        Call.State state;
        boolean flag4;
        if(flag1 && flag2)
            flag3 = true;
        else
            flag3 = false;
        state = getActiveFgCallState();
        if(i != 3 && !flag && !flag3 && (state == Call.State.ACTIVE || state == Call.State.IDLE || state == Call.State.DISCONNECTED))
            flag4 = true;
        else
            flag4 = false;
        if(!flag4)
            Log.d("CallManager", (new StringBuilder()).append("canDial serviceState=").append(i).append(" hasRingingCall=").append(flag).append(" hasActiveCall=").append(flag1).append(" hasHoldingCall=").append(flag2).append(" allLinesTaken=").append(flag3).append(" fgCallState=").append(state).toString());
        return flag4;
    }

    private Context getContext() {
        Phone phone = getDefaultPhone();
        Context context;
        if(phone == null)
            context = null;
        else
            context = phone.getContext();
        return context;
    }

    private Call getFirstActiveCall(ArrayList arraylist) {
        Iterator iterator = arraylist.iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Call call = (Call)iterator.next();
        if(call.isIdle()) goto _L4; else goto _L3
_L3:
        return call;
_L2:
        call = null;
        if(true) goto _L3; else goto _L5
_L5:
    }

    private Call getFirstCallOfState(ArrayList arraylist, Call.State state) {
        Iterator iterator = arraylist.iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Call call = (Call)iterator.next();
        if(call.getState() != state) goto _L4; else goto _L3
_L3:
        return call;
_L2:
        call = null;
        if(true) goto _L3; else goto _L5
_L5:
    }

    private Call getFirstNonIdleCall(List list) {
        Call call;
        Iterator iterator;
        call = null;
        iterator = list.iterator();
_L3:
        Call call1;
        if(!iterator.hasNext())
            break MISSING_BLOCK_LABEL_61;
        call1 = (Call)iterator.next();
        if(call1.isIdle()) goto _L2; else goto _L1
_L1:
        return call1;
_L2:
        if(call1.getState() != Call.State.IDLE && call == null)
            call = call1;
          goto _L3
        call1 = call;
          goto _L1
    }

    public static CallManager getInstance() {
        return INSTANCE;
    }

    private static Phone getPhoneBase(Phone phone) {
        if(phone instanceof PhoneProxy)
            phone = phone.getForegroundCall().getPhone();
        return phone;
    }

    private boolean hasMoreThanOneRingingCall() {
        boolean flag;
        int i;
        Iterator iterator;
        flag = true;
        i = 0;
        iterator = mRingingCalls.iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        if(!((Call)iterator.next()).getState().isRinging()) goto _L4; else goto _L3
_L3:
        i++;
        if(i <= flag) goto _L4; else goto _L5
_L5:
        return flag;
_L2:
        flag = false;
        if(true) goto _L5; else goto _L6
_L6:
    }

    public static boolean isSamePhone(Phone phone, Phone phone1) {
        boolean flag;
        if(getPhoneBase(phone) == getPhoneBase(phone1))
            flag = true;
        else
            flag = false;
        return flag;
    }

    private void registerForPhoneStates(Phone phone) {
        phone.registerForPreciseCallStateChanged(mHandler, 101, null);
        phone.registerForDisconnect(mHandler, 100, null);
        phone.registerForNewRingingConnection(mHandler, 102, null);
        phone.registerForUnknownConnection(mHandler, 103, null);
        phone.registerForIncomingRing(mHandler, 104, null);
        phone.registerForRingbackTone(mHandler, 105, null);
        phone.registerForInCallVoicePrivacyOn(mHandler, 106, null);
        phone.registerForInCallVoicePrivacyOff(mHandler, 107, null);
        phone.registerForDisplayInfo(mHandler, 109, null);
        phone.registerForSignalInfo(mHandler, 110, null);
        phone.registerForResendIncallMute(mHandler, 112, null);
        phone.registerForMmiInitiate(mHandler, 113, null);
        phone.registerForMmiComplete(mHandler, 114, null);
        phone.registerForSuppServiceFailed(mHandler, 117, null);
        phone.registerForServiceStateChanged(mHandler, 118, null);
        if(phone.getPhoneType() == 1 || phone.getPhoneType() == 2)
            phone.setOnPostDialCharacter(mHandler, 119, null);
        if(phone.getPhoneType() == 2) {
            phone.registerForCdmaOtaStatusChange(mHandler, 111, null);
            phone.registerForSubscriptionInfoReady(mHandler, 116, null);
            phone.registerForCallWaiting(mHandler, 108, null);
            phone.registerForEcmTimerReset(mHandler, 115, null);
        }
    }

    private void unregisterForPhoneStates(Phone phone) {
        phone.unregisterForPreciseCallStateChanged(mHandler);
        phone.unregisterForDisconnect(mHandler);
        phone.unregisterForNewRingingConnection(mHandler);
        phone.unregisterForUnknownConnection(mHandler);
        phone.unregisterForIncomingRing(mHandler);
        phone.unregisterForRingbackTone(mHandler);
        phone.unregisterForInCallVoicePrivacyOn(mHandler);
        phone.unregisterForInCallVoicePrivacyOff(mHandler);
        phone.unregisterForDisplayInfo(mHandler);
        phone.unregisterForSignalInfo(mHandler);
        phone.unregisterForResendIncallMute(mHandler);
        phone.unregisterForMmiInitiate(mHandler);
        phone.unregisterForMmiComplete(mHandler);
        phone.unregisterForSuppServiceFailed(mHandler);
        phone.unregisterForServiceStateChanged(mHandler);
        if(phone.getPhoneType() == 1 || phone.getPhoneType() == 2)
            phone.setOnPostDialCharacter(null, 119, null);
        if(phone.getPhoneType() == 2) {
            phone.unregisterForCdmaOtaStatusChange(mHandler);
            phone.unregisterForSubscriptionInfoReady(mHandler);
            phone.unregisterForCallWaiting(mHandler);
            phone.unregisterForEcmTimerReset(mHandler);
        }
    }

    public void acceptCall(Call call) throws CallStateException {
        boolean flag;
        Phone phone;
        flag = true;
        phone = call.getPhone();
        if(!hasActiveFgCall()) goto _L2; else goto _L1
_L1:
        Phone phone1;
        boolean flag1;
        phone1 = getActiveFgCall().getPhone();
        if(!phone1.getBackgroundCall().isIdle())
            flag1 = flag;
        else
            flag1 = false;
        if(phone1 != phone)
            flag = false;
        if(!flag || !flag1) goto _L4; else goto _L3
_L3:
        getActiveFgCall().hangup();
_L2:
        phone.acceptCall();
        return;
_L4:
        if(!flag && !flag1)
            phone1.switchHoldingAndActive();
        else
        if(!flag && flag1)
            getActiveFgCall().hangup();
        if(true) goto _L2; else goto _L5
_L5:
    }

    public boolean canConference(Call call) {
        Phone phone = null;
        Phone phone1 = null;
        if(hasActiveFgCall())
            phone = getActiveFgCall().getPhone();
        if(call != null)
            phone1 = call.getPhone();
        return phone1.getClass().equals(phone.getClass());
    }

    public boolean canTransfer(Call call) {
        Phone phone = null;
        Phone phone1 = null;
        if(hasActiveFgCall())
            phone = getActiveFgCall().getPhone();
        if(call != null)
            phone1 = call.getPhone();
        boolean flag;
        if(phone1 == phone && phone.canTransfer())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void clearDisconnected() {
        for(Iterator iterator = mPhones.iterator(); iterator.hasNext(); ((Phone)iterator.next()).clearDisconnected());
    }

    public void conference(Call call) throws CallStateException {
        Phone phone = getFgPhone();
        if(phone instanceof SipPhone)
            ((SipPhone)phone).conference(call);
        else
        if(canConference(call))
            phone.conference();
        else
            throw new CallStateException("Can't conference foreground and selected background call");
    }

    public Connection dial(Phone phone, String s) throws CallStateException {
        boolean flag = true;
        Phone phone1 = getPhoneBase(phone);
        if(!canDial(phone))
            throw new CallStateException("cannot dial in current state");
        if(hasActiveFgCall()) {
            Phone phone2 = getActiveFgCall().getPhone();
            boolean flag1;
            StringBuilder stringbuilder;
            if(!phone2.getBackgroundCall().isIdle())
                flag1 = flag;
            else
                flag1 = false;
            stringbuilder = (new StringBuilder()).append("hasBgCall: ").append(flag1).append(" sameChannel:");
            if(phone2 != phone1)
                flag = false;
            Log.d("CallManager", stringbuilder.append(flag).toString());
            if(phone2 != phone1)
                if(flag1) {
                    Log.d("CallManager", "Hangup");
                    getActiveFgCall().hangup();
                } else {
                    Log.d("CallManager", "Switch");
                    phone2.switchHoldingAndActive();
                }
        }
        return phone1.dial(s);
    }

    public Connection dial(Phone phone, String s, UUSInfo uusinfo) throws CallStateException {
        return phone.dial(s, uusinfo);
    }

    public void explicitCallTransfer(Call call) throws CallStateException {
        if(canTransfer(call))
            call.getPhone().explicitCallTransfer();
    }

    public Call getActiveFgCall() {
        Call call = getFirstNonIdleCall(mForegroundCalls);
        if(call == null)
            if(mDefaultPhone == null)
                call = null;
            else
                call = mDefaultPhone.getForegroundCall();
        return call;
    }

    public Call.State getActiveFgCallState() {
        Call call = getActiveFgCall();
        Call.State state;
        if(call != null)
            state = call.getState();
        else
            state = Call.State.IDLE;
        return state;
    }

    public List getAllPhones() {
        return Collections.unmodifiableList(mPhones);
    }

    public List getBackgroundCalls() {
        return Collections.unmodifiableList(mBackgroundCalls);
    }

    public List getBgCallConnections() {
        Call call = getFirstActiveBgCall();
        Object obj;
        if(call != null)
            obj = call.getConnections();
        else
            obj = emptyConnections;
        return ((List) (obj));
    }

    public Phone getBgPhone() {
        return getFirstActiveBgCall().getPhone();
    }

    public Phone getDefaultPhone() {
        return mDefaultPhone;
    }

    public List getFgCallConnections() {
        Call call = getActiveFgCall();
        Object obj;
        if(call != null)
            obj = call.getConnections();
        else
            obj = emptyConnections;
        return ((List) (obj));
    }

    public Connection getFgCallLatestConnection() {
        Call call = getActiveFgCall();
        Connection connection;
        if(call != null)
            connection = call.getLatestConnection();
        else
            connection = null;
        return connection;
    }

    public Phone getFgPhone() {
        return getActiveFgCall().getPhone();
    }

    public Call getFirstActiveBgCall() {
        Call call = getFirstNonIdleCall(mBackgroundCalls);
        if(call == null)
            if(mDefaultPhone == null)
                call = null;
            else
                call = mDefaultPhone.getBackgroundCall();
        return call;
    }

    public Call getFirstActiveRingingCall() {
        Call call = getFirstNonIdleCall(mRingingCalls);
        if(call == null)
            if(mDefaultPhone == null)
                call = null;
            else
                call = mDefaultPhone.getRingingCall();
        return call;
    }

    public List getForegroundCalls() {
        return Collections.unmodifiableList(mForegroundCalls);
    }

    public boolean getMute() {
        boolean flag;
        if(hasActiveFgCall())
            flag = getActiveFgCall().getPhone().getMute();
        else
        if(hasActiveBgCall())
            flag = getFirstActiveBgCall().getPhone().getMute();
        else
            flag = false;
        return flag;
    }

    public List getPendingMmiCodes(Phone phone) {
        Log.e("CallManager", "getPendingMmiCodes not implemented");
        return null;
    }

    public List getRingingCalls() {
        return Collections.unmodifiableList(mRingingCalls);
    }

    public Phone getRingingPhone() {
        return getFirstActiveRingingCall().getPhone();
    }

    public int getServiceState() {
        int i = 1;
        Iterator iterator = mPhones.iterator();
        do {
            int j;
label0:
            {
                if(iterator.hasNext()) {
                    j = ((Phone)iterator.next()).getServiceState().getState();
                    if(j != 0)
                        break label0;
                    i = j;
                }
                return i;
            }
            if(j == 1) {
                if(i == 2 || i == 3)
                    i = j;
            } else
            if(j == 2 && i == 3)
                i = j;
        } while(true);
    }

    public Phone.State getState() {
        Phone.State state = Phone.State.IDLE;
        Iterator iterator = mPhones.iterator();
        do {
            if(!iterator.hasNext())
                break;
            Phone phone = (Phone)iterator.next();
            if(phone.getState() == Phone.State.RINGING)
                state = Phone.State.RINGING;
            else
            if(phone.getState() == Phone.State.OFFHOOK && state == Phone.State.IDLE)
                state = Phone.State.OFFHOOK;
        } while(true);
        return state;
    }

    public void hangupForegroundResumeBackground(Call call) throws CallStateException {
        if(hasActiveFgCall()) {
            Phone phone = getFgPhone();
            if(call != null)
                if(phone == call.getPhone()) {
                    getActiveFgCall().hangup();
                } else {
                    getActiveFgCall().hangup();
                    switchHoldingAndActive(call);
                }
        }
    }

    public boolean hasActiveBgCall() {
        boolean flag;
        if(getFirstActiveCall(mBackgroundCalls) != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean hasActiveFgCall() {
        boolean flag;
        if(getFirstActiveCall(mForegroundCalls) != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean hasActiveRingingCall() {
        boolean flag;
        if(getFirstActiveCall(mRingingCalls) != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean hasDisconnectedBgCall() {
        boolean flag;
        if(getFirstCallOfState(mBackgroundCalls, Call.State.DISCONNECTED) != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean hasDisconnectedFgCall() {
        boolean flag;
        if(getFirstCallOfState(mForegroundCalls, Call.State.DISCONNECTED) != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void registerForCallWaiting(Handler handler, int i, Object obj) {
        mCallWaitingRegistrants.addUnique(handler, i, obj);
    }

    public void registerForCdmaOtaStatusChange(Handler handler, int i, Object obj) {
        mCdmaOtaStatusChangeRegistrants.addUnique(handler, i, obj);
    }

    public void registerForDisconnect(Handler handler, int i, Object obj) {
        mDisconnectRegistrants.addUnique(handler, i, obj);
    }

    public void registerForDisplayInfo(Handler handler, int i, Object obj) {
        mDisplayInfoRegistrants.addUnique(handler, i, obj);
    }

    public void registerForEcmTimerReset(Handler handler, int i, Object obj) {
        mEcmTimerResetRegistrants.addUnique(handler, i, obj);
    }

    public void registerForInCallVoicePrivacyOff(Handler handler, int i, Object obj) {
        mInCallVoicePrivacyOffRegistrants.addUnique(handler, i, obj);
    }

    public void registerForInCallVoicePrivacyOn(Handler handler, int i, Object obj) {
        mInCallVoicePrivacyOnRegistrants.addUnique(handler, i, obj);
    }

    public void registerForIncomingRing(Handler handler, int i, Object obj) {
        mIncomingRingRegistrants.addUnique(handler, i, obj);
    }

    public void registerForMmiComplete(Handler handler, int i, Object obj) {
        mMmiCompleteRegistrants.addUnique(handler, i, obj);
    }

    public void registerForMmiInitiate(Handler handler, int i, Object obj) {
        mMmiInitiateRegistrants.addUnique(handler, i, obj);
    }

    public void registerForNewRingingConnection(Handler handler, int i, Object obj) {
        mNewRingingConnectionRegistrants.addUnique(handler, i, obj);
    }

    public void registerForPostDialCharacter(Handler handler, int i, Object obj) {
        mPostDialCharacterRegistrants.addUnique(handler, i, obj);
    }

    public void registerForPreciseCallStateChanged(Handler handler, int i, Object obj) {
        mPreciseCallStateRegistrants.addUnique(handler, i, obj);
    }

    public void registerForResendIncallMute(Handler handler, int i, Object obj) {
        mResendIncallMuteRegistrants.addUnique(handler, i, obj);
    }

    public void registerForRingbackTone(Handler handler, int i, Object obj) {
        mRingbackToneRegistrants.addUnique(handler, i, obj);
    }

    public void registerForServiceStateChanged(Handler handler, int i, Object obj) {
        mServiceStateChangedRegistrants.addUnique(handler, i, obj);
    }

    public void registerForSignalInfo(Handler handler, int i, Object obj) {
        mSignalInfoRegistrants.addUnique(handler, i, obj);
    }

    public void registerForSubscriptionInfoReady(Handler handler, int i, Object obj) {
        mSubscriptionInfoReadyRegistrants.addUnique(handler, i, obj);
    }

    public void registerForSuppServiceFailed(Handler handler, int i, Object obj) {
        mSuppServiceFailedRegistrants.addUnique(handler, i, obj);
    }

    public void registerForUnknownConnection(Handler handler, int i, Object obj) {
        mUnknownConnectionRegistrants.addUnique(handler, i, obj);
    }

    public boolean registerPhone(Phone phone) {
        Phone phone1 = getPhoneBase(phone);
        boolean flag;
        if(phone1 != null && !mPhones.contains(phone1)) {
            Log.d("CallManager", (new StringBuilder()).append("registerPhone(").append(phone.getPhoneName()).append(" ").append(phone).append(")").toString());
            if(mPhones.isEmpty())
                mDefaultPhone = phone1;
            mPhones.add(phone1);
            mRingingCalls.add(phone1.getRingingCall());
            mBackgroundCalls.add(phone1.getBackgroundCall());
            mForegroundCalls.add(phone1.getForegroundCall());
            registerForPhoneStates(phone1);
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public void rejectCall(Call call) throws CallStateException {
        call.getPhone().rejectCall();
    }

    public boolean sendBurstDtmf(String s, int i, int j, Message message) {
        boolean flag;
        if(hasActiveFgCall()) {
            getActiveFgCall().getPhone().sendBurstDtmf(s, i, j, message);
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public boolean sendDtmf(char c) {
        boolean flag = false;
        if(hasActiveFgCall()) {
            getActiveFgCall().getPhone().sendDtmf(c);
            flag = true;
        }
        return flag;
    }

    public boolean sendUssdResponse(Phone phone, String s) {
        Log.e("CallManager", "sendUssdResponse not implemented");
        return false;
    }

    public void setAudioMode() {
        Context context = getContext();
        if(context != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        AudioManager audiomanager = (AudioManager)context.getSystemService("audio");
        class _cls2 {

            static final int $SwitchMap$com$android$internal$telephony$Phone$State[];

            static  {
                $SwitchMap$com$android$internal$telephony$Phone$State = new int[Phone.State.values().length];
                NoSuchFieldError nosuchfielderror2;
                try {
                    $SwitchMap$com$android$internal$telephony$Phone$State[Phone.State.RINGING.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror) { }
                try {
                    $SwitchMap$com$android$internal$telephony$Phone$State[Phone.State.OFFHOOK.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror1) { }
                $SwitchMap$com$android$internal$telephony$Phone$State[Phone.State.IDLE.ordinal()] = 3;
_L2:
                return;
                nosuchfielderror2;
                if(true) goto _L2; else goto _L1
_L1:
            }
        }

        switch(_cls2..SwitchMap.com.android.internal.telephony.Phone.State[getState().ordinal()]) {
        case 1: // '\001'
            if(audiomanager.getMode() != 1) {
                if(audiomanager.getStreamVolume(2) > 0)
                    audiomanager.requestAudioFocusForCall(2, 2);
                audiomanager.setMode(1);
            }
            break;

        case 2: // '\002'
            Phone phone = getFgPhone();
            if(getActiveFgCallState() == Call.State.IDLE)
                phone = getBgPhone();
            byte byte0 = 2;
            if(phone instanceof SipPhone)
                byte0 = 3;
            if(audiomanager.getMode() != byte0) {
                audiomanager.requestAudioFocusForCall(0, 2);
                audiomanager.setMode(byte0);
            }
            break;

        case 3: // '\003'
            if(audiomanager.getMode() != 0) {
                audiomanager.setMode(0);
                audiomanager.abandonAudioFocusForCall();
            }
            break;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void setEchoSuppressionEnabled(boolean flag) {
        if(hasActiveFgCall())
            getActiveFgCall().getPhone().setEchoSuppressionEnabled(flag);
    }

    public void setMute(boolean flag) {
        if(hasActiveFgCall())
            getActiveFgCall().getPhone().setMute(flag);
    }

    public boolean startDtmf(char c) {
        boolean flag = false;
        if(hasActiveFgCall()) {
            getActiveFgCall().getPhone().startDtmf(c);
            flag = true;
        }
        return flag;
    }

    public void stopDtmf() {
        if(hasActiveFgCall())
            getFgPhone().stopDtmf();
    }

    public void switchHoldingAndActive(Call call) throws CallStateException {
        Phone phone = null;
        Phone phone1 = null;
        if(hasActiveFgCall())
            phone = getActiveFgCall().getPhone();
        if(call != null)
            phone1 = call.getPhone();
        if(phone != null)
            phone.switchHoldingAndActive();
        if(phone1 != null && phone1 != phone)
            phone1.switchHoldingAndActive();
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("CallManager {");
        stringbuilder.append((new StringBuilder()).append("\nstate = ").append(getState()).toString());
        Call call = getActiveFgCall();
        stringbuilder.append((new StringBuilder()).append("\n- Foreground: ").append(getActiveFgCallState()).toString());
        stringbuilder.append((new StringBuilder()).append(" from ").append(call.getPhone()).toString());
        stringbuilder.append("\n  Conn: ").append(getFgCallConnections());
        Call call1 = getFirstActiveBgCall();
        stringbuilder.append((new StringBuilder()).append("\n- Background: ").append(call1.getState()).toString());
        stringbuilder.append((new StringBuilder()).append(" from ").append(call1.getPhone()).toString());
        stringbuilder.append("\n  Conn: ").append(getBgCallConnections());
        Call call2 = getFirstActiveRingingCall();
        stringbuilder.append((new StringBuilder()).append("\n- Ringing: ").append(call2.getState()).toString());
        stringbuilder.append((new StringBuilder()).append(" from ").append(call2.getPhone()).toString());
        Iterator iterator = getAllPhones().iterator();
        do {
            if(!iterator.hasNext())
                break;
            Phone phone = (Phone)iterator.next();
            if(phone != null) {
                stringbuilder.append((new StringBuilder()).append("\nPhone: ").append(phone).append(", name = ").append(phone.getPhoneName()).append(", state = ").append(phone.getState()).toString());
                Call call3 = phone.getForegroundCall();
                stringbuilder.append("\n- Foreground: ").append(call3);
                Call call4 = phone.getBackgroundCall();
                stringbuilder.append(" Background: ").append(call4);
                Call call5 = phone.getRingingCall();
                stringbuilder.append(" Ringing: ").append(call5);
            }
        } while(true);
        stringbuilder.append("\n}");
        return stringbuilder.toString();
    }

    public void unregisterForCallWaiting(Handler handler) {
        mCallWaitingRegistrants.remove(handler);
    }

    public void unregisterForCdmaOtaStatusChange(Handler handler) {
        mCdmaOtaStatusChangeRegistrants.remove(handler);
    }

    public void unregisterForDisconnect(Handler handler) {
        mDisconnectRegistrants.remove(handler);
    }

    public void unregisterForDisplayInfo(Handler handler) {
        mDisplayInfoRegistrants.remove(handler);
    }

    public void unregisterForEcmTimerReset(Handler handler) {
        mEcmTimerResetRegistrants.remove(handler);
    }

    public void unregisterForInCallVoicePrivacyOff(Handler handler) {
        mInCallVoicePrivacyOffRegistrants.remove(handler);
    }

    public void unregisterForInCallVoicePrivacyOn(Handler handler) {
        mInCallVoicePrivacyOnRegistrants.remove(handler);
    }

    public void unregisterForIncomingRing(Handler handler) {
        mIncomingRingRegistrants.remove(handler);
    }

    public void unregisterForMmiComplete(Handler handler) {
        mMmiCompleteRegistrants.remove(handler);
    }

    public void unregisterForMmiInitiate(Handler handler) {
        mMmiInitiateRegistrants.remove(handler);
    }

    public void unregisterForNewRingingConnection(Handler handler) {
        mNewRingingConnectionRegistrants.remove(handler);
    }

    public void unregisterForPostDialCharacter(Handler handler) {
        mPostDialCharacterRegistrants.remove(handler);
    }

    public void unregisterForPreciseCallStateChanged(Handler handler) {
        mPreciseCallStateRegistrants.remove(handler);
    }

    public void unregisterForResendIncallMute(Handler handler) {
        mResendIncallMuteRegistrants.remove(handler);
    }

    public void unregisterForRingbackTone(Handler handler) {
        mRingbackToneRegistrants.remove(handler);
    }

    public void unregisterForServiceStateChanged(Handler handler) {
        mServiceStateChangedRegistrants.remove(handler);
    }

    public void unregisterForSignalInfo(Handler handler) {
        mSignalInfoRegistrants.remove(handler);
    }

    public void unregisterForSubscriptionInfoReady(Handler handler) {
        mSubscriptionInfoReadyRegistrants.remove(handler);
    }

    public void unregisterForSuppServiceFailed(Handler handler) {
        mSuppServiceFailedRegistrants.remove(handler);
    }

    public void unregisterForUnknownConnection(Handler handler) {
        mUnknownConnectionRegistrants.remove(handler);
    }

    public void unregisterPhone(Phone phone) {
        Phone phone1 = getPhoneBase(phone);
        if(phone1 != null && mPhones.contains(phone1)) {
            Log.d("CallManager", (new StringBuilder()).append("unregisterPhone(").append(phone.getPhoneName()).append(" ").append(phone).append(")").toString());
            mPhones.remove(phone1);
            mRingingCalls.remove(phone1.getRingingCall());
            mBackgroundCalls.remove(phone1.getBackgroundCall());
            mForegroundCalls.remove(phone1.getForegroundCall());
            unregisterForPhoneStates(phone1);
            if(phone1 == mDefaultPhone)
                if(mPhones.isEmpty())
                    mDefaultPhone = null;
                else
                    mDefaultPhone = (Phone)mPhones.get(0);
        }
    }

    private static final boolean DBG = true;
    private static final int EVENT_CALL_WAITING = 108;
    private static final int EVENT_CDMA_OTA_STATUS_CHANGE = 111;
    private static final int EVENT_DISCONNECT = 100;
    private static final int EVENT_DISPLAY_INFO = 109;
    private static final int EVENT_ECM_TIMER_RESET = 115;
    private static final int EVENT_INCOMING_RING = 104;
    private static final int EVENT_IN_CALL_VOICE_PRIVACY_OFF = 107;
    private static final int EVENT_IN_CALL_VOICE_PRIVACY_ON = 106;
    private static final int EVENT_MMI_COMPLETE = 114;
    private static final int EVENT_MMI_INITIATE = 113;
    private static final int EVENT_NEW_RINGING_CONNECTION = 102;
    private static final int EVENT_POST_DIAL_CHARACTER = 119;
    private static final int EVENT_PRECISE_CALL_STATE_CHANGED = 101;
    private static final int EVENT_RESEND_INCALL_MUTE = 112;
    private static final int EVENT_RINGBACK_TONE = 105;
    private static final int EVENT_SERVICE_STATE_CHANGED = 118;
    private static final int EVENT_SIGNAL_INFO = 110;
    private static final int EVENT_SUBSCRIPTION_INFO_READY = 116;
    private static final int EVENT_SUPP_SERVICE_FAILED = 117;
    private static final int EVENT_UNKNOWN_CONNECTION = 103;
    private static final CallManager INSTANCE = new CallManager();
    private static final String LOG_TAG = "CallManager";
    private static final boolean VDBG;
    private final ArrayList emptyConnections = new ArrayList();
    private final ArrayList mBackgroundCalls = new ArrayList();
    protected final RegistrantList mCallWaitingRegistrants = new RegistrantList();
    protected final RegistrantList mCdmaOtaStatusChangeRegistrants = new RegistrantList();
    private Phone mDefaultPhone;
    protected final RegistrantList mDisconnectRegistrants = new RegistrantList();
    protected final RegistrantList mDisplayInfoRegistrants = new RegistrantList();
    protected final RegistrantList mEcmTimerResetRegistrants = new RegistrantList();
    private final ArrayList mForegroundCalls = new ArrayList();
    private Handler mHandler;
    protected final RegistrantList mInCallVoicePrivacyOffRegistrants = new RegistrantList();
    protected final RegistrantList mInCallVoicePrivacyOnRegistrants = new RegistrantList();
    protected final RegistrantList mIncomingRingRegistrants = new RegistrantList();
    protected final RegistrantList mMmiCompleteRegistrants = new RegistrantList();
    protected final RegistrantList mMmiInitiateRegistrants = new RegistrantList();
    protected final RegistrantList mMmiRegistrants = new RegistrantList();
    protected final RegistrantList mNewRingingConnectionRegistrants = new RegistrantList();
    private final ArrayList mPhones = new ArrayList();
    protected final RegistrantList mPostDialCharacterRegistrants = new RegistrantList();
    protected final RegistrantList mPreciseCallStateRegistrants = new RegistrantList();
    protected final RegistrantList mResendIncallMuteRegistrants = new RegistrantList();
    protected final RegistrantList mRingbackToneRegistrants = new RegistrantList();
    private final ArrayList mRingingCalls = new ArrayList();
    protected final RegistrantList mServiceStateChangedRegistrants = new RegistrantList();
    protected final RegistrantList mSignalInfoRegistrants = new RegistrantList();
    protected final RegistrantList mSubscriptionInfoReadyRegistrants = new RegistrantList();
    protected final RegistrantList mSuppServiceFailedRegistrants = new RegistrantList();
    protected final RegistrantList mUnknownConnectionRegistrants = new RegistrantList();


}
