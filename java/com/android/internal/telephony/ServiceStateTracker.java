// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.os.*;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

// Referenced classes of package com.android.internal.telephony:
//            RestrictedState, CommandsInterface, DataConnectionTracker, PhoneBase, 
//            IccCard, Phone

public abstract class ServiceStateTracker extends Handler {

    public ServiceStateTracker() {
        mRestrictedState = new RestrictedState();
        mRilRadioTechnology = 0;
        mNewRilRadioTechnology = 0;
        dontPollSignalStrength = false;
        mRoamingOnRegistrants = new RegistrantList();
        mRoamingOffRegistrants = new RegistrantList();
        mAttachedRegistrants = new RegistrantList();
        mDetachedRegistrants = new RegistrantList();
        mNetworkAttachedRegistrants = new RegistrantList();
        mPsRestrictEnabledRegistrants = new RegistrantList();
        mPsRestrictDisabledRegistrants = new RegistrantList();
        mPendingRadioPowerOffAfterDataOff = false;
        mPendingRadioPowerOffAfterDataOffTag = 0;
    }

    protected void cancelPollState() {
        pollingContext = new int[1];
    }

    public void disableLocationUpdates() {
        mWantContinuousLocationUpdates = false;
        if(!mWantSingleLocationUpdate && !mWantContinuousLocationUpdates)
            cm.setLocationUpdates(false, null);
    }

    protected void disableSingleLocationUpdate() {
        mWantSingleLocationUpdate = false;
        if(!mWantSingleLocationUpdate && !mWantContinuousLocationUpdates)
            cm.setLocationUpdates(false, null);
    }

    public void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        printwriter.println("ServiceStateTracker:");
        printwriter.println((new StringBuilder()).append(" ss=").append(ss).toString());
        printwriter.println((new StringBuilder()).append(" newSS=").append(newSS).toString());
        printwriter.println((new StringBuilder()).append(" mSignalStrength=").append(mSignalStrength).toString());
        printwriter.println((new StringBuilder()).append(" mRestrictedState=").append(mRestrictedState).toString());
        printwriter.println((new StringBuilder()).append(" pollingContext=").append(pollingContext).toString());
        printwriter.println((new StringBuilder()).append(" mDesiredPowerState=").append(mDesiredPowerState).toString());
        printwriter.println((new StringBuilder()).append(" mRilRadioTechnology=").append(mRilRadioTechnology).toString());
        printwriter.println((new StringBuilder()).append(" mNewRilRadioTechnology=").append(mNewRilRadioTechnology).toString());
        printwriter.println((new StringBuilder()).append(" dontPollSignalStrength=").append(dontPollSignalStrength).toString());
        printwriter.println((new StringBuilder()).append(" mPendingRadioPowerOffAfterDataOff=").append(mPendingRadioPowerOffAfterDataOff).toString());
        printwriter.println((new StringBuilder()).append(" mPendingRadioPowerOffAfterDataOffTag=").append(mPendingRadioPowerOffAfterDataOffTag).toString());
    }

    public void enableLocationUpdates() {
        if(!mWantSingleLocationUpdate && !mWantContinuousLocationUpdates) {
            mWantContinuousLocationUpdates = true;
            cm.setLocationUpdates(true, obtainMessage(18));
        }
    }

    public void enableSingleLocationUpdate() {
        if(!mWantSingleLocationUpdate && !mWantContinuousLocationUpdates) {
            mWantSingleLocationUpdate = true;
            cm.setLocationUpdates(true, obtainMessage(18));
        }
    }

    public abstract int getCurrentDataConnectionState();

    public boolean getDesiredPowerState() {
        return mDesiredPowerState;
    }

    protected abstract Phone getPhone();

    public void handleMessage(Message message) {
        message.what;
        JVM INSTR tableswitch 38 38: default 24
    //                   38 52;
           goto _L1 _L2
_L1:
        log((new StringBuilder()).append("Unhandled message with number: ").append(message.what).toString());
_L5:
        return;
_L2:
        this;
        JVM INSTR monitorenter ;
        if(!mPendingRadioPowerOffAfterDataOff || message.arg1 != mPendingRadioPowerOffAfterDataOffTag) goto _L4; else goto _L3
_L3:
        log("EVENT_SET_RADIO_OFF, turn radio off now.");
        hangupAndPowerOff();
        mPendingRadioPowerOffAfterDataOffTag = 1 + mPendingRadioPowerOffAfterDataOffTag;
        mPendingRadioPowerOffAfterDataOff = false;
_L6:
        this;
        JVM INSTR monitorexit ;
          goto _L5
        Exception exception;
        exception;
        throw exception;
_L4:
        log((new StringBuilder()).append("EVENT_SET_RADIO_OFF is stale arg1=").append(message.arg1).append("!= tag=").append(mPendingRadioPowerOffAfterDataOffTag).toString());
          goto _L6
    }

    protected abstract void handlePollStateResult(int i, AsyncResult asyncresult);

    protected abstract void hangupAndPowerOff();

    public abstract boolean isConcurrentVoiceAndDataAllowed();

    protected abstract void log(String s);

    protected abstract void loge(String s);

    public void powerOffRadioSafely(DataConnectionTracker dataconnectiontracker) {
        this;
        JVM INSTR monitorenter ;
        if(!mPendingRadioPowerOffAfterDataOff)
            if(dataconnectiontracker.isDisconnected()) {
                dataconnectiontracker.cleanUpAllConnections("radioTurnedOff");
                log("Data disconnected, turn off radio right away.");
                hangupAndPowerOff();
            } else {
                dataconnectiontracker.cleanUpAllConnections("radioTurnedOff");
                Message message = Message.obtain(this);
                message.what = 38;
                int i = 1 + mPendingRadioPowerOffAfterDataOffTag;
                mPendingRadioPowerOffAfterDataOffTag = i;
                message.arg1 = i;
                if(!sendMessageDelayed(message, 30000L))
                    break MISSING_BLOCK_LABEL_106;
                log("Wait upto 30s for data to disconnect, then turn off radio.");
                mPendingRadioPowerOffAfterDataOff = true;
            }
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
        log("Cannot send delayed Msg, turn off radio right away.");
        hangupAndPowerOff();
          goto _L1
    }

    public boolean processPendingRadioPowerOffAfterDataOff() {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        if(mPendingRadioPowerOffAfterDataOff) {
            log("Process pending request to turn radio off.");
            mPendingRadioPowerOffAfterDataOffTag = 1 + mPendingRadioPowerOffAfterDataOffTag;
            hangupAndPowerOff();
            mPendingRadioPowerOffAfterDataOff = false;
            flag = true;
        }
        return flag;
    }

    public void reRegisterNetwork(Message message) {
        cm.getPreferredNetworkType(obtainMessage(19, message));
    }

    public void registerForDataConnectionAttached(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mAttachedRegistrants.add(registrant);
        if(getCurrentDataConnectionState() == 0)
            registrant.notifyRegistrant();
    }

    public void registerForDataConnectionDetached(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mDetachedRegistrants.add(registrant);
        if(getCurrentDataConnectionState() != 0)
            registrant.notifyRegistrant();
    }

    public void registerForNetworkAttached(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mNetworkAttachedRegistrants.add(registrant);
        if(ss.getState() == 0)
            registrant.notifyRegistrant();
    }

    public void registerForPsRestrictedDisabled(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mPsRestrictDisabledRegistrants.add(registrant);
        if(mRestrictedState.isPsRestricted())
            registrant.notifyRegistrant();
    }

    public void registerForPsRestrictedEnabled(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mPsRestrictEnabledRegistrants.add(registrant);
        if(mRestrictedState.isPsRestricted())
            registrant.notifyRegistrant();
    }

    public void registerForRoamingOff(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mRoamingOffRegistrants.add(registrant);
        if(!ss.getRoaming())
            registrant.notifyRegistrant();
    }

    public void registerForRoamingOn(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mRoamingOnRegistrants.add(registrant);
        if(ss.getRoaming())
            registrant.notifyRegistrant();
    }

    protected abstract void setPowerStateToDesired();

    public void setRadioPower(boolean flag) {
        mDesiredPowerState = flag;
        setPowerStateToDesired();
    }

    protected boolean shouldFixTimeZoneNow(PhoneBase phonebase, String s, String s1, boolean flag) {
        boolean flag1 = true;
        int i = Integer.parseInt(s.substring(0, 3));
        int k = Integer.parseInt(s1.substring(0, 3));
        int j = k;
_L3:
        IccCard icccard = phonebase.getIccCard();
        Exception exception;
        Exception exception1;
        boolean flag2;
        long l;
        StringBuilder stringbuilder;
        String s2;
        if(icccard != null && icccard.getState().iccCardExist())
            flag2 = flag1;
        else
            flag2 = false;
        if((!flag2 || i == j) && !flag)
            flag1 = false;
        l = System.currentTimeMillis();
        stringbuilder = (new StringBuilder()).append("shouldFixTimeZoneNow: retVal=").append(flag1).append(" iccCard=").append(icccard).append(" iccCard.state=");
        if(icccard == null)
            s2 = "null";
        else
            s2 = icccard.getState().toString();
        log(stringbuilder.append(s2).append(" iccCardExist=").append(flag2).append(" operatorNumeric=").append(s).append(" mcc=").append(i).append(" prevOperatorNumeric=").append(s1).append(" prevMcc=").append(j).append(" needToFixTimeZone=").append(flag).append(" ltod=").append(TimeUtils.logTimeOfDay(l)).toString());
_L2:
        return flag1;
        exception;
        log((new StringBuilder()).append("shouldFixTimeZoneNow: no mcc, operatorNumeric=").append(s).append(" retVal=false").toString());
        flag1 = false;
        if(true) goto _L2; else goto _L1
_L1:
        exception1;
        j = i + 1;
          goto _L3
    }

    public void unregisterForDataConnectionAttached(Handler handler) {
        mAttachedRegistrants.remove(handler);
    }

    public void unregisterForDataConnectionDetached(Handler handler) {
        mDetachedRegistrants.remove(handler);
    }

    public void unregisterForNetworkAttached(Handler handler) {
        mNetworkAttachedRegistrants.remove(handler);
    }

    public void unregisterForPsRestrictedDisabled(Handler handler) {
        mPsRestrictDisabledRegistrants.remove(handler);
    }

    public void unregisterForPsRestrictedEnabled(Handler handler) {
        mPsRestrictEnabledRegistrants.remove(handler);
    }

    public void unregisterForRoamingOff(Handler handler) {
        mRoamingOffRegistrants.remove(handler);
    }

    public void unregisterForRoamingOn(Handler handler) {
        mRoamingOnRegistrants.remove(handler);
    }

    protected abstract void updateSpnDisplay();

    protected static final boolean DBG = true;
    public static final int DEFAULT_GPRS_CHECK_PERIOD_MILLIS = 60000;
    protected static final int EVENT_CDMA_PRL_VERSION_CHANGED = 40;
    protected static final int EVENT_CDMA_SUBSCRIPTION_SOURCE_CHANGED = 39;
    protected static final int EVENT_CHECK_REPORT_GPRS = 22;
    protected static final int EVENT_ERI_FILE_LOADED = 36;
    protected static final int EVENT_GET_LOC_DONE = 15;
    protected static final int EVENT_GET_LOC_DONE_CDMA = 31;
    protected static final int EVENT_GET_PREFERRED_NETWORK_TYPE = 19;
    protected static final int EVENT_GET_SIGNAL_STRENGTH = 3;
    protected static final int EVENT_GET_SIGNAL_STRENGTH_CDMA = 29;
    protected static final int EVENT_LOCATION_UPDATES_ENABLED = 18;
    protected static final int EVENT_NETWORK_STATE_CHANGED = 2;
    protected static final int EVENT_NETWORK_STATE_CHANGED_CDMA = 30;
    protected static final int EVENT_NITZ_TIME = 11;
    protected static final int EVENT_NV_LOADED = 33;
    protected static final int EVENT_NV_READY = 35;
    protected static final int EVENT_OTA_PROVISION_STATUS_CHANGE = 37;
    protected static final int EVENT_POLL_SIGNAL_STRENGTH = 10;
    protected static final int EVENT_POLL_SIGNAL_STRENGTH_CDMA = 28;
    protected static final int EVENT_POLL_STATE_CDMA_SUBSCRIPTION = 34;
    protected static final int EVENT_POLL_STATE_GPRS = 5;
    protected static final int EVENT_POLL_STATE_NETWORK_SELECTION_MODE = 14;
    protected static final int EVENT_POLL_STATE_OPERATOR = 6;
    protected static final int EVENT_POLL_STATE_OPERATOR_CDMA = 25;
    protected static final int EVENT_POLL_STATE_REGISTRATION = 4;
    protected static final int EVENT_POLL_STATE_REGISTRATION_CDMA = 24;
    protected static final int EVENT_RADIO_AVAILABLE = 13;
    protected static final int EVENT_RADIO_ON = 41;
    protected static final int EVENT_RADIO_STATE_CHANGED = 1;
    protected static final int EVENT_RESET_PREFERRED_NETWORK_TYPE = 21;
    protected static final int EVENT_RESTRICTED_STATE_CHANGED = 23;
    protected static final int EVENT_RUIM_READY = 26;
    protected static final int EVENT_RUIM_RECORDS_LOADED = 27;
    protected static final int EVENT_SET_PREFERRED_NETWORK_TYPE = 20;
    protected static final int EVENT_SET_RADIO_POWER_OFF = 38;
    protected static final int EVENT_SIGNAL_STRENGTH_UPDATE = 12;
    protected static final int EVENT_SIGNAL_STRENGTH_UPDATE_CDMA = 32;
    protected static final int EVENT_SIM_READY = 17;
    protected static final int EVENT_SIM_RECORDS_LOADED = 16;
    protected static final String GMT_COUNTRY_CODES[];
    public static final int OTASP_NEEDED = 2;
    public static final int OTASP_NOT_NEEDED = 3;
    public static final int OTASP_UNINITIALIZED = 0;
    public static final int OTASP_UNKNOWN = 1;
    protected static final int POLL_PERIOD_MILLIS = 20000;
    protected static final String REGISTRATION_DENIED_AUTH = "Authentication Failure";
    protected static final String REGISTRATION_DENIED_GEN = "General";
    protected static final String TIMEZONE_PROPERTY = "persist.sys.timezone";
    protected CommandsInterface cm;
    protected boolean dontPollSignalStrength;
    protected RegistrantList mAttachedRegistrants;
    protected boolean mDesiredPowerState;
    protected RegistrantList mDetachedRegistrants;
    protected RegistrantList mNetworkAttachedRegistrants;
    protected int mNewRilRadioTechnology;
    private boolean mPendingRadioPowerOffAfterDataOff;
    private int mPendingRadioPowerOffAfterDataOffTag;
    protected RegistrantList mPsRestrictDisabledRegistrants;
    protected RegistrantList mPsRestrictEnabledRegistrants;
    public RestrictedState mRestrictedState;
    protected int mRilRadioTechnology;
    protected RegistrantList mRoamingOffRegistrants;
    protected RegistrantList mRoamingOnRegistrants;
    public SignalStrength mSignalStrength;
    private boolean mWantContinuousLocationUpdates;
    private boolean mWantSingleLocationUpdate;
    protected ServiceState newSS;
    protected int pollingContext[];
    public ServiceState ss;

    static  {
        String as[] = new String[20];
        as[0] = "bf";
        as[1] = "ci";
        as[2] = "eh";
        as[3] = "fo";
        as[4] = "gb";
        as[5] = "gh";
        as[6] = "gm";
        as[7] = "gn";
        as[8] = "gw";
        as[9] = "ie";
        as[10] = "lr";
        as[11] = "is";
        as[12] = "ma";
        as[13] = "ml";
        as[14] = "mr";
        as[15] = "pt";
        as[16] = "sl";
        as[17] = "sn";
        as[18] = "st";
        as[19] = "tg";
        GMT_COUNTRY_CODES = as;
    }
}
