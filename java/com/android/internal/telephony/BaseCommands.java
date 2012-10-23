// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.content.Context;
import android.os.*;
import android.util.Log;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.android.internal.telephony:
//            CommandsInterface

public abstract class BaseCommands
    implements CommandsInterface {

    public BaseCommands(Context context) {
        mState = CommandsInterface.RadioState.RADIO_UNAVAILABLE;
        mStateMonitor = new Object();
        mRadioStateChangedRegistrants = new RegistrantList();
        mOnRegistrants = new RegistrantList();
        mAvailRegistrants = new RegistrantList();
        mOffOrNotAvailRegistrants = new RegistrantList();
        mNotAvailRegistrants = new RegistrantList();
        mCallStateRegistrants = new RegistrantList();
        mVoiceNetworkStateRegistrants = new RegistrantList();
        mDataNetworkStateRegistrants = new RegistrantList();
        mVoiceRadioTechChangedRegistrants = new RegistrantList();
        mIccStatusChangedRegistrants = new RegistrantList();
        mVoicePrivacyOnRegistrants = new RegistrantList();
        mVoicePrivacyOffRegistrants = new RegistrantList();
        mOtaProvisionRegistrants = new RegistrantList();
        mCallWaitingInfoRegistrants = new RegistrantList();
        mDisplayInfoRegistrants = new RegistrantList();
        mSignalInfoRegistrants = new RegistrantList();
        mNumberInfoRegistrants = new RegistrantList();
        mRedirNumInfoRegistrants = new RegistrantList();
        mLineControlInfoRegistrants = new RegistrantList();
        mT53ClirInfoRegistrants = new RegistrantList();
        mT53AudCntrlInfoRegistrants = new RegistrantList();
        mRingbackToneRegistrants = new RegistrantList();
        mResendIncallMuteRegistrants = new RegistrantList();
        mCdmaSubscriptionChangedRegistrants = new RegistrantList();
        mCdmaPrlChangedRegistrants = new RegistrantList();
        mExitEmergencyCallbackModeRegistrants = new RegistrantList();
        mRilConnectedRegistrants = new RegistrantList();
        mIccRefreshRegistrants = new RegistrantList();
        mRilVersion = -1;
        mContext = context;
    }

    public static int getLteOnCdmaModeStatic() {
        String s = "";
        int i = SystemProperties.getInt("telephony.lteOnCdmaDevice", -1);
        int j = i;
        if(j == -1) {
            Matcher matcher = sProductTypePattern.matcher(sKernelCmdLine);
            if(matcher.find()) {
                s = matcher.group(1);
                if(sLteOnCdmaProductType.equals(s))
                    j = 1;
                else
                    j = 0;
            } else {
                j = 0;
            }
        }
        Log.d("RILB", (new StringBuilder()).append("getLteOnCdmaMode=").append(j).append(" curVal=").append(i).append(" product_type='").append(s).append("' lteOnCdmaProductType='").append(sLteOnCdmaProductType).append("'").toString());
        return j;
    }

    private static String getProcCmdLine() {
        String s;
        FileInputStream fileinputstream;
        s = "";
        fileinputstream = null;
        FileInputStream fileinputstream1 = new FileInputStream("/proc/cmdline");
        String s1;
        byte abyte0[] = new byte[2048];
        int i = fileinputstream1.read(abyte0);
        if(i <= 0)
            break MISSING_BLOCK_LABEL_52;
        s1 = new String(abyte0, 0, i);
        s = s1;
        IOException ioexception;
        Exception exception;
        if(fileinputstream1 != null)
            try {
                fileinputstream1.close();
            }
            catch(IOException ioexception3) { }
        Log.d("RILB", (new StringBuilder()).append("/proc/cmdline=").append(s).toString());
        return s;
        ioexception;
_L4:
        Log.d("RILB", (new StringBuilder()).append("No /proc/cmdline exception=").append(ioexception).toString());
        if(fileinputstream != null)
            try {
                fileinputstream.close();
            }
            catch(IOException ioexception2) { }
        break MISSING_BLOCK_LABEL_60;
        exception;
_L2:
        if(fileinputstream != null)
            try {
                fileinputstream.close();
            }
            catch(IOException ioexception1) { }
        throw exception;
        exception;
        fileinputstream = fileinputstream1;
        if(true) goto _L2; else goto _L1
_L1:
        ioexception;
        fileinputstream = fileinputstream1;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int getLteOnCdmaMode() {
        return getLteOnCdmaModeStatic();
    }

    public CommandsInterface.RadioState getRadioState() {
        return mState;
    }

    protected void onRadioAvailable() {
    }

    public void registerFoT53ClirlInfo(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mT53ClirInfoRegistrants.add(registrant);
    }

    public void registerForAvailable(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        Object obj1 = mStateMonitor;
        obj1;
        JVM INSTR monitorenter ;
        mAvailRegistrants.add(registrant);
        if(mState.isAvailable())
            registrant.notifyRegistrant(new AsyncResult(null, null, null));
        return;
    }

    public void registerForCallStateChanged(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mCallStateRegistrants.add(registrant);
    }

    public void registerForCallWaitingInfo(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mCallWaitingInfoRegistrants.add(registrant);
    }

    public void registerForCdmaOtaProvision(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mOtaProvisionRegistrants.add(registrant);
    }

    public void registerForCdmaPrlChanged(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mCdmaPrlChangedRegistrants.add(registrant);
    }

    public void registerForCdmaSubscriptionChanged(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mCdmaSubscriptionChangedRegistrants.add(registrant);
    }

    public void registerForDataNetworkStateChanged(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mDataNetworkStateRegistrants.add(registrant);
    }

    public void registerForDisplayInfo(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mDisplayInfoRegistrants.add(registrant);
    }

    public void registerForExitEmergencyCallbackMode(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mExitEmergencyCallbackModeRegistrants.add(registrant);
    }

    public void registerForIccRefresh(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mIccRefreshRegistrants.add(registrant);
    }

    public void registerForIccStatusChanged(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mIccStatusChangedRegistrants.add(registrant);
    }

    public void registerForInCallVoicePrivacyOff(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mVoicePrivacyOffRegistrants.add(registrant);
    }

    public void registerForInCallVoicePrivacyOn(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mVoicePrivacyOnRegistrants.add(registrant);
    }

    public void registerForLineControlInfo(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mLineControlInfoRegistrants.add(registrant);
    }

    public void registerForNotAvailable(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        Object obj1 = mStateMonitor;
        obj1;
        JVM INSTR monitorenter ;
        mNotAvailRegistrants.add(registrant);
        if(!mState.isAvailable())
            registrant.notifyRegistrant(new AsyncResult(null, null, null));
        return;
    }

    public void registerForNumberInfo(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mNumberInfoRegistrants.add(registrant);
    }

    public void registerForOffOrNotAvailable(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        Object obj1 = mStateMonitor;
        obj1;
        JVM INSTR monitorenter ;
        mOffOrNotAvailRegistrants.add(registrant);
        if(mState == CommandsInterface.RadioState.RADIO_OFF || !mState.isAvailable())
            registrant.notifyRegistrant(new AsyncResult(null, null, null));
        return;
    }

    public void registerForOn(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        Object obj1 = mStateMonitor;
        obj1;
        JVM INSTR monitorenter ;
        mOnRegistrants.add(registrant);
        if(mState.isOn())
            registrant.notifyRegistrant(new AsyncResult(null, null, null));
        return;
    }

    public void registerForRadioStateChanged(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        Object obj1 = mStateMonitor;
        obj1;
        JVM INSTR monitorenter ;
        mRadioStateChangedRegistrants.add(registrant);
        registrant.notifyRegistrant();
        return;
    }

    public void registerForRedirectedNumberInfo(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mRedirNumInfoRegistrants.add(registrant);
    }

    public void registerForResendIncallMute(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mResendIncallMuteRegistrants.add(registrant);
    }

    public void registerForRilConnected(Handler handler, int i, Object obj) {
        Log.d("RILB", (new StringBuilder()).append("registerForRilConnected h=").append(handler).append(" w=").append(i).toString());
        Registrant registrant = new Registrant(handler, i, obj);
        mRilConnectedRegistrants.add(registrant);
        if(mRilVersion != -1) {
            Log.d("RILB", (new StringBuilder()).append("Notifying: ril connected mRilVersion=").append(mRilVersion).toString());
            registrant.notifyRegistrant(new AsyncResult(null, new Integer(mRilVersion), null));
        }
    }

    public void registerForRingbackTone(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mRingbackToneRegistrants.add(registrant);
    }

    public void registerForSignalInfo(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mSignalInfoRegistrants.add(registrant);
    }

    public void registerForT53AudioControlInfo(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mT53AudCntrlInfoRegistrants.add(registrant);
    }

    public void registerForVoiceNetworkStateChanged(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mVoiceNetworkStateRegistrants.add(registrant);
    }

    public void registerForVoiceRadioTechChanged(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mVoiceRadioTechChangedRegistrants.add(registrant);
    }

    public void setCurrentPreferredNetworkType() {
    }

    public void setEmergencyCallbackMode(Handler handler, int i, Object obj) {
        mEmergencyCallbackModeRegistrant = new Registrant(handler, i, obj);
    }

    public void setOnCallRing(Handler handler, int i, Object obj) {
        mRingRegistrant = new Registrant(handler, i, obj);
    }

    public void setOnCatCallSetUp(Handler handler, int i, Object obj) {
        mCatCallSetUpRegistrant = new Registrant(handler, i, obj);
    }

    public void setOnCatEvent(Handler handler, int i, Object obj) {
        mCatEventRegistrant = new Registrant(handler, i, obj);
    }

    public void setOnCatProactiveCmd(Handler handler, int i, Object obj) {
        mCatProCmdRegistrant = new Registrant(handler, i, obj);
    }

    public void setOnCatSessionEnd(Handler handler, int i, Object obj) {
        mCatSessionEndRegistrant = new Registrant(handler, i, obj);
    }

    public void setOnIccRefresh(Handler handler, int i, Object obj) {
        registerForIccRefresh(handler, i, obj);
    }

    public void setOnIccSmsFull(Handler handler, int i, Object obj) {
        mIccSmsFullRegistrant = new Registrant(handler, i, obj);
    }

    public void setOnNITZTime(Handler handler, int i, Object obj) {
        mNITZTimeRegistrant = new Registrant(handler, i, obj);
    }

    public void setOnNewCdmaSms(Handler handler, int i, Object obj) {
        mCdmaSmsRegistrant = new Registrant(handler, i, obj);
    }

    public void setOnNewGsmBroadcastSms(Handler handler, int i, Object obj) {
        mGsmBroadcastSmsRegistrant = new Registrant(handler, i, obj);
    }

    public void setOnNewGsmSms(Handler handler, int i, Object obj) {
        mGsmSmsRegistrant = new Registrant(handler, i, obj);
    }

    public void setOnRestrictedStateChanged(Handler handler, int i, Object obj) {
        mRestrictedStateRegistrant = new Registrant(handler, i, obj);
    }

    public void setOnSignalStrengthUpdate(Handler handler, int i, Object obj) {
        mSignalStrengthRegistrant = new Registrant(handler, i, obj);
    }

    public void setOnSmsOnSim(Handler handler, int i, Object obj) {
        mSmsOnSimRegistrant = new Registrant(handler, i, obj);
    }

    public void setOnSmsStatus(Handler handler, int i, Object obj) {
        mSmsStatusRegistrant = new Registrant(handler, i, obj);
    }

    public void setOnSuppServiceNotification(Handler handler, int i, Object obj) {
        mSsnRegistrant = new Registrant(handler, i, obj);
    }

    public void setOnUSSD(Handler handler, int i, Object obj) {
        mUSSDRegistrant = new Registrant(handler, i, obj);
    }

    public void setOnUnsolOemHookRaw(Handler handler, int i, Object obj) {
        mUnsolOemHookRawRegistrant = new Registrant(handler, i, obj);
    }

    protected void setRadioState(CommandsInterface.RadioState radiostate) {
        Object obj = mStateMonitor;
        obj;
        JVM INSTR monitorenter ;
        CommandsInterface.RadioState radiostate1 = mState;
        mState = radiostate;
        if(radiostate1 != mState) {
            mRadioStateChangedRegistrants.notifyRegistrants();
            if(mState.isAvailable() && !radiostate1.isAvailable()) {
                Log.d("RILB", "Notifying: radio available");
                mAvailRegistrants.notifyRegistrants();
                onRadioAvailable();
            }
            if(!mState.isAvailable() && radiostate1.isAvailable()) {
                Log.d("RILB", "Notifying: radio not available");
                mNotAvailRegistrants.notifyRegistrants();
            }
            if(mState.isOn() && !radiostate1.isOn()) {
                Log.d("RILB", "Notifying: Radio On");
                mOnRegistrants.notifyRegistrants();
            }
            if((!mState.isOn() || !mState.isAvailable()) && radiostate1.isOn() && radiostate1.isAvailable()) {
                Log.d("RILB", "Notifying: radio off or not available");
                mOffOrNotAvailRegistrants.notifyRegistrants();
            }
        }
        return;
    }

    public void testingEmergencyCall() {
    }

    public void unSetOnCallRing(Handler handler) {
        mRingRegistrant.clear();
    }

    public void unSetOnCatCallSetUp(Handler handler) {
        mCatCallSetUpRegistrant.clear();
    }

    public void unSetOnCatEvent(Handler handler) {
        mCatEventRegistrant.clear();
    }

    public void unSetOnCatProactiveCmd(Handler handler) {
        mCatProCmdRegistrant.clear();
    }

    public void unSetOnCatSessionEnd(Handler handler) {
        mCatSessionEndRegistrant.clear();
    }

    public void unSetOnIccSmsFull(Handler handler) {
        mIccSmsFullRegistrant.clear();
    }

    public void unSetOnNITZTime(Handler handler) {
        mNITZTimeRegistrant.clear();
    }

    public void unSetOnNewCdmaSms(Handler handler) {
        mCdmaSmsRegistrant.clear();
    }

    public void unSetOnNewGsmBroadcastSms(Handler handler) {
        mGsmBroadcastSmsRegistrant.clear();
    }

    public void unSetOnNewGsmSms(Handler handler) {
        mGsmSmsRegistrant.clear();
    }

    public void unSetOnRestrictedStateChanged(Handler handler) {
        mRestrictedStateRegistrant.clear();
    }

    public void unSetOnSignalStrengthUpdate(Handler handler) {
        mSignalStrengthRegistrant.clear();
    }

    public void unSetOnSmsOnSim(Handler handler) {
        mSmsOnSimRegistrant.clear();
    }

    public void unSetOnSmsStatus(Handler handler) {
        mSmsStatusRegistrant.clear();
    }

    public void unSetOnSuppServiceNotification(Handler handler) {
        mSsnRegistrant.clear();
    }

    public void unSetOnUSSD(Handler handler) {
        mUSSDRegistrant.clear();
    }

    public void unSetOnUnsolOemHookRaw(Handler handler) {
        mUnsolOemHookRawRegistrant.clear();
    }

    public void unregisterForAvailable(Handler handler) {
        Object obj = mStateMonitor;
        obj;
        JVM INSTR monitorenter ;
        mAvailRegistrants.remove(handler);
        return;
    }

    public void unregisterForCallStateChanged(Handler handler) {
        mCallStateRegistrants.remove(handler);
    }

    public void unregisterForCallWaitingInfo(Handler handler) {
        mCallWaitingInfoRegistrants.remove(handler);
    }

    public void unregisterForCdmaOtaProvision(Handler handler) {
        mOtaProvisionRegistrants.remove(handler);
    }

    public void unregisterForCdmaPrlChanged(Handler handler) {
        mCdmaPrlChangedRegistrants.remove(handler);
    }

    public void unregisterForCdmaSubscriptionChanged(Handler handler) {
        mCdmaSubscriptionChangedRegistrants.remove(handler);
    }

    public void unregisterForDataNetworkStateChanged(Handler handler) {
        mDataNetworkStateRegistrants.remove(handler);
    }

    public void unregisterForDisplayInfo(Handler handler) {
        mDisplayInfoRegistrants.remove(handler);
    }

    public void unregisterForExitEmergencyCallbackMode(Handler handler) {
        mExitEmergencyCallbackModeRegistrants.remove(handler);
    }

    public void unregisterForIccRefresh(Handler handler) {
        mIccRefreshRegistrants.remove(handler);
    }

    public void unregisterForIccStatusChanged(Handler handler) {
        mIccStatusChangedRegistrants.remove(handler);
    }

    public void unregisterForInCallVoicePrivacyOff(Handler handler) {
        mVoicePrivacyOffRegistrants.remove(handler);
    }

    public void unregisterForInCallVoicePrivacyOn(Handler handler) {
        mVoicePrivacyOnRegistrants.remove(handler);
    }

    public void unregisterForLineControlInfo(Handler handler) {
        mLineControlInfoRegistrants.remove(handler);
    }

    public void unregisterForNotAvailable(Handler handler) {
        Object obj = mStateMonitor;
        obj;
        JVM INSTR monitorenter ;
        mNotAvailRegistrants.remove(handler);
        return;
    }

    public void unregisterForNumberInfo(Handler handler) {
        mNumberInfoRegistrants.remove(handler);
    }

    public void unregisterForOffOrNotAvailable(Handler handler) {
        Object obj = mStateMonitor;
        obj;
        JVM INSTR monitorenter ;
        mOffOrNotAvailRegistrants.remove(handler);
        return;
    }

    public void unregisterForOn(Handler handler) {
        Object obj = mStateMonitor;
        obj;
        JVM INSTR monitorenter ;
        mOnRegistrants.remove(handler);
        return;
    }

    public void unregisterForRadioStateChanged(Handler handler) {
        Object obj = mStateMonitor;
        obj;
        JVM INSTR monitorenter ;
        mRadioStateChangedRegistrants.remove(handler);
        return;
    }

    public void unregisterForRedirectedNumberInfo(Handler handler) {
        mRedirNumInfoRegistrants.remove(handler);
    }

    public void unregisterForResendIncallMute(Handler handler) {
        mResendIncallMuteRegistrants.remove(handler);
    }

    public void unregisterForRilConnected(Handler handler) {
        mRilConnectedRegistrants.remove(handler);
    }

    public void unregisterForRingbackTone(Handler handler) {
        mRingbackToneRegistrants.remove(handler);
    }

    public void unregisterForSignalInfo(Handler handler) {
        mSignalInfoRegistrants.remove(handler);
    }

    public void unregisterForT53AudioControlInfo(Handler handler) {
        mT53AudCntrlInfoRegistrants.remove(handler);
    }

    public void unregisterForT53ClirInfo(Handler handler) {
        mT53ClirInfoRegistrants.remove(handler);
    }

    public void unregisterForVoiceNetworkStateChanged(Handler handler) {
        mVoiceNetworkStateRegistrants.remove(handler);
    }

    public void unregisterForVoiceRadioTechChanged(Handler handler) {
        mVoiceRadioTechChangedRegistrants.remove(handler);
    }

    public void unsetOnIccRefresh(Handler handler) {
        unregisterForIccRefresh(handler);
    }

    static final String LOG_TAG = "RILB";
    private static final String sKernelCmdLine = getProcCmdLine();
    private static final String sLteOnCdmaProductType = SystemProperties.get("telephony.lteOnCdmaProductType", "");
    private static final Pattern sProductTypePattern = Pattern.compile("\\sproduct_type\\s*=\\s*(\\w+)");
    protected RegistrantList mAvailRegistrants;
    protected RegistrantList mCallStateRegistrants;
    protected RegistrantList mCallWaitingInfoRegistrants;
    protected Registrant mCatCallSetUpRegistrant;
    protected Registrant mCatEventRegistrant;
    protected Registrant mCatProCmdRegistrant;
    protected Registrant mCatSessionEndRegistrant;
    protected RegistrantList mCdmaPrlChangedRegistrants;
    protected Registrant mCdmaSmsRegistrant;
    protected int mCdmaSubscription;
    protected RegistrantList mCdmaSubscriptionChangedRegistrants;
    protected Context mContext;
    protected RegistrantList mDataNetworkStateRegistrants;
    protected RegistrantList mDisplayInfoRegistrants;
    protected Registrant mEmergencyCallbackModeRegistrant;
    protected RegistrantList mExitEmergencyCallbackModeRegistrants;
    protected Registrant mGsmBroadcastSmsRegistrant;
    protected Registrant mGsmSmsRegistrant;
    protected RegistrantList mIccRefreshRegistrants;
    protected Registrant mIccSmsFullRegistrant;
    protected RegistrantList mIccStatusChangedRegistrants;
    protected RegistrantList mLineControlInfoRegistrants;
    protected Registrant mNITZTimeRegistrant;
    protected RegistrantList mNotAvailRegistrants;
    protected RegistrantList mNumberInfoRegistrants;
    protected RegistrantList mOffOrNotAvailRegistrants;
    protected RegistrantList mOnRegistrants;
    protected RegistrantList mOtaProvisionRegistrants;
    protected int mPhoneType;
    protected int mPreferredNetworkType;
    protected RegistrantList mRadioStateChangedRegistrants;
    protected RegistrantList mRedirNumInfoRegistrants;
    protected RegistrantList mResendIncallMuteRegistrants;
    protected Registrant mRestrictedStateRegistrant;
    protected RegistrantList mRilConnectedRegistrants;
    protected int mRilVersion;
    protected Registrant mRingRegistrant;
    protected RegistrantList mRingbackToneRegistrants;
    protected RegistrantList mSignalInfoRegistrants;
    protected Registrant mSignalStrengthRegistrant;
    protected Registrant mSmsOnSimRegistrant;
    protected Registrant mSmsStatusRegistrant;
    protected Registrant mSsnRegistrant;
    protected CommandsInterface.RadioState mState;
    protected Object mStateMonitor;
    protected RegistrantList mT53AudCntrlInfoRegistrants;
    protected RegistrantList mT53ClirInfoRegistrants;
    protected Registrant mUSSDRegistrant;
    protected Registrant mUnsolOemHookRawRegistrant;
    protected RegistrantList mVoiceNetworkStateRegistrants;
    protected RegistrantList mVoicePrivacyOffRegistrants;
    protected RegistrantList mVoicePrivacyOnRegistrants;
    protected RegistrantList mVoiceRadioTechChangedRegistrants;

}
