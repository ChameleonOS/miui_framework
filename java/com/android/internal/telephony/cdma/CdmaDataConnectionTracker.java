// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cdma;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.LinkProperties;
import android.net.TrafficStats;
import android.os.*;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.EventLog;
import android.util.Log;
import com.android.internal.telephony.*;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import miui.net.FirewallManager;

// Referenced classes of package com.android.internal.telephony.cdma:
//            CDMAPhone, CdmaCallTracker, CdmaServiceStateTracker, CdmaSubscriptionSourceManager, 
//            CdmaDataConnection

public final class CdmaDataConnectionTracker extends DataConnectionTracker {
    static class Injector {

        static void onDataSetupComplete(CdmaDataConnectionTracker cdmadataconnectiontracker) {
            DataConnectionAc dataconnectionac = null;
            ApnSetting apnsetting = cdmadataconnectiontracker.getActiveApn();
            Iterator iterator = cdmadataconnectiontracker.getDataConnectionAsyncChannels().values().iterator();
            do {
                if(!iterator.hasNext())
                    break;
                DataConnectionAc dataconnectionac1 = (DataConnectionAc)iterator.next();
                if(!dataconnectionac1.getApnSettingSync().equals(apnsetting))
                    continue;
                dataconnectionac = dataconnectionac1;
                break;
            } while(true);
            if(dataconnectionac != null && apnsetting != null)
                FirewallManager.getInstance().onDataConnected(0, FirewallManager.encodeApnSetting(apnsetting), dataconnectionac.getLinkPropertiesSync().getInterfaceName());
        }

        static void onDisconnectDone(CdmaDataConnectionTracker cdmadataconnectiontracker) {
            FirewallManager.getInstance().onDataDisconnected(0, FirewallManager.encodeApnSetting(cdmadataconnectiontracker.getActiveApn()));
        }

        Injector() {
        }
    }


    CdmaDataConnectionTracker(CDMAPhone cdmaphone) {
        super(cdmaphone);
        mPendingRestartRadio = false;
        String as[] = new String[1];
        as[0] = "dun";
        mDunApnTypes = as;
        mPollNetStat = new Runnable() {

            public void run() {
                long l = 
// JavaClassFileOutputException: get_constant: invalid tag

            final CdmaDataConnectionTracker this$0;

             {
                this$0 = CdmaDataConnectionTracker.this;
                super();
            }
        };
        mCdmaPhone = cdmaphone;
        ((PhoneBase) (cdmaphone)).mCM.registerForAvailable(this, 0x42001, null);
        ((PhoneBase) (cdmaphone)).mCM.registerForOffOrNotAvailable(this, 0x42006, null);
        ((PhoneBase) (cdmaphone)).mIccRecords.registerForRecordsLoaded(this, 0x42002, null);
        ((PhoneBase) (cdmaphone)).mCM.registerForDataNetworkStateChanged(this, 0x42004, null);
        cdmaphone.mCT.registerForVoiceCallEnded(this, 0x42008, null);
        cdmaphone.mCT.registerForVoiceCallStarted(this, 0x42007, null);
        cdmaphone.mSST.registerForDataConnectionAttached(this, 0x42003, null);
        cdmaphone.mSST.registerForDataConnectionDetached(this, 0x42014, null);
        cdmaphone.mSST.registerForRoamingOn(this, 0x4200b, null);
        cdmaphone.mSST.registerForRoamingOff(this, 0x4200c, null);
        ((PhoneBase) (cdmaphone)).mCM.registerForCdmaOtaProvision(this, 0x42019, null);
        mCdmaSSM = CdmaSubscriptionSourceManager.getInstance(cdmaphone.getContext(), ((PhoneBase) (cdmaphone)).mCM, this, 0x42015, null);
        super.mDataConnectionTracker = this;
        createAllDataConnectionList();
        broadcastMessenger();
        String as1[] = mCdmaPhone.getContext().getResources().getStringArray(0x107001e);
        if(as1 != null && as1.length > 0) {
            ArrayList arraylist = new ArrayList();
            for(int i = 0; i < as1.length; i++)
                if(!"dun".equalsIgnoreCase(as1[i]))
                    arraylist.add(as1[i]);

            arraylist.add(0, "dun");
            mDunApnTypes = (String[])arraylist.toArray(as1);
        }
    }

    private void cleanUpConnection(boolean flag, String s, boolean flag1) {
        log((new StringBuilder()).append("cleanUpConnection: reason: ").append(s).toString());
        if(super.mReconnectIntent != null) {
            ((AlarmManager)super.mPhone.getContext().getSystemService("alarm")).cancel(super.mReconnectIntent);
            super.mReconnectIntent = null;
        }
        setState(com.android.internal.telephony.DataConnectionTracker.State.DISCONNECTING);
        notifyOffApnsOfAvailability(s);
        boolean flag2 = false;
        Iterator iterator = super.mDataConnections.values().iterator();
        do {
            if(!iterator.hasNext())
                break;
            DataConnection dataconnection = (DataConnection)iterator.next();
            if(dataconnection != null) {
                DataConnectionAc dataconnectionac = (DataConnectionAc)super.mDataConnectionAsyncChannels.get(Integer.valueOf(dataconnection.getDataConnectionId()));
                if(flag) {
                    if(flag1) {
                        log("cleanUpConnection: teardown, conn.tearDownAll");
                        dataconnection.tearDownAll(s, obtainMessage(0x4200f, dataconnection.getDataConnectionId(), 0, s));
                    } else {
                        log("cleanUpConnection: teardown, conn.tearDown");
                        dataconnection.tearDown(s, obtainMessage(0x4200f, dataconnection.getDataConnectionId(), 0, s));
                    }
                    flag2 = true;
                } else {
                    log("cleanUpConnection: !tearDown, call conn.resetSynchronously");
                    if(dataconnectionac != null)
                        dataconnectionac.resetSync();
                    flag2 = false;
                }
            }
        } while(true);
        stopNetStatPoll();
        if(!flag2) {
            log("cleanupConnection: !notificationDeferred");
            gotoIdleAndNotifyDataConnection(s);
        }
    }

    private void createAllDataConnectionList() {
        String s = SystemProperties.get("ro.cdma.data_retry_config");
        int i = 0;
        while(i < 1)  {
            RetryManager retrymanager = new RetryManager();
            if(!retrymanager.configure(s) && !retrymanager.configure("default_randomization=2000,5000,10000,20000,40000,80000:5000,160000:5000,320000:5000,640000:5000,1280000:5000,1800000:5000")) {
                log("Could not configure using DEFAULT_DATA_RETRY_CONFIG=default_randomization=2000,5000,10000,20000,40000,80000:5000,160000:5000,320000:5000,640000:5000,1280000:5000,1800000:5000");
                retrymanager.configure(20, 2000, 1000);
            }
            int j = super.mUniqueIdGenerator.getAndIncrement();
            CdmaDataConnection cdmadataconnection = CdmaDataConnection.makeDataConnection(mCdmaPhone, j, retrymanager, this);
            super.mDataConnections.put(Integer.valueOf(j), cdmadataconnection);
            DataConnectionAc dataconnectionac = new DataConnectionAc(cdmadataconnection, "CDMA");
            int k = dataconnectionac.fullyConnectSync(super.mPhone.getContext(), this, cdmadataconnection.getHandler());
            if(k == 0) {
                log("Fully connected");
                super.mDataConnectionAsyncChannels.put(Integer.valueOf(dataconnectionac.dataConnection.getDataConnectionId()), dataconnectionac);
            } else {
                log((new StringBuilder()).append("Could not connect to dcac.dataConnection=").append(dataconnectionac.dataConnection).append(" status=").append(k).toString());
            }
            i++;
        }
    }

    private void destroyAllDataConnectionList() {
        if(super.mDataConnections != null)
            super.mDataConnections.clear();
    }

    private CdmaDataConnection findFreeDataConnection() {
        Iterator iterator = super.mDataConnectionAsyncChannels.values().iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        DataConnectionAc dataconnectionac = (DataConnectionAc)iterator.next();
        if(!dataconnectionac.isInactiveSync()) goto _L4; else goto _L3
_L3:
        CdmaDataConnection cdmadataconnection;
        log("found free GsmDataConnection");
        cdmadataconnection = (CdmaDataConnection)dataconnectionac.dataConnection;
_L6:
        return cdmadataconnection;
_L2:
        log("NO free CdmaDataConnection");
        cdmadataconnection = null;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private void notifyDefaultData(String s) {
        setState(com.android.internal.telephony.DataConnectionTracker.State.CONNECTED);
        notifyDataConnection(s);
        startNetStatPoll();
        ((DataConnection)super.mDataConnections.get(Integer.valueOf(0))).resetRetryCount();
    }

    private void notifyNoData(com.android.internal.telephony.DataConnection.FailCause failcause) {
        setState(com.android.internal.telephony.DataConnectionTracker.State.FAILED);
        notifyOffApnsOfAvailability(null);
    }

    private void onCdmaDataDetached() {
        if(super.mState == com.android.internal.telephony.DataConnectionTracker.State.CONNECTED) {
            startNetStatPoll();
            notifyDataConnection("cdmaDataDetached");
        } else {
            if(super.mState == com.android.internal.telephony.DataConnectionTracker.State.FAILED) {
                cleanUpConnection(false, "cdmaDataDetached", false);
                ((DataConnection)super.mDataConnections.get(Integer.valueOf(0))).resetRetryCount();
                CdmaCellLocation cdmacelllocation = (CdmaCellLocation)(CdmaCellLocation)super.mPhone.getCellLocation();
                Object aobj[] = new Object[2];
                int i;
                if(cdmacelllocation != null)
                    i = cdmacelllocation.getBaseStationId();
                else
                    i = -1;
                aobj[0] = Integer.valueOf(i);
                aobj[1] = Integer.valueOf(TelephonyManager.getDefault().getNetworkType());
                EventLog.writeEvent(50110, aobj);
            }
            trySetupData("cdmaDataDetached");
        }
    }

    private void onCdmaOtaProvision(AsyncResult asyncresult) {
        if(asyncresult.exception == null) goto _L2; else goto _L1
_L1:
        int ai[] = (int[])(int[])asyncresult.result;
        if(ai == null || ai.length <= 1) goto _L2; else goto _L3
_L3:
        ai[0];
        JVM INSTR tableswitch 8 10: default 56
    //                   8 57
    //                   9 56
    //                   10 57;
           goto _L2 _L4 _L2 _L4
_L2:
        return;
_L4:
        ((DataConnection)super.mDataConnections.get(Integer.valueOf(0))).resetRetryCount();
        if(true) goto _L2; else goto _L5
_L5:
    }

    private void onRestartRadio() {
        if(mPendingRestartRadio) {
            log("************TURN OFF RADIO**************");
            super.mPhone.mCM.setRadioPower(false, null);
            mPendingRestartRadio = false;
        }
    }

    private void reconnectAfterFail(com.android.internal.telephony.DataConnection.FailCause failcause, String s, int i) {
        if(super.mState == com.android.internal.telephony.DataConnectionTracker.State.FAILED) {
            int j = i;
            if(j < 0) {
                j = ((DataConnection)super.mDataConnections.get(Integer.valueOf(0))).getRetryTimer();
                ((DataConnection)super.mDataConnections.get(Integer.valueOf(0))).increaseRetryCount();
            }
            startAlarmForReconnect(j, s);
            if(!shouldPostNotification(failcause))
                log("NOT Posting Data Connection Unavailable notification -- likely transient error");
            else
                notifyNoData(failcause);
        }
    }

    private void resetPollStats() {
        super.mTxPkts = -1L;
        super.mRxPkts = -1L;
        super.mSentSinceLastRecv = 0L;
        super.mNetStatPollPeriod = 1000;
        super.mNoRecvPollCount = 0;
    }

    private boolean retryAfterDisconnected(String s) {
        boolean flag = true;
        if("radioTurnedOff".equals(s))
            flag = false;
        return flag;
    }

    private boolean setupData(String s) {
        CdmaDataConnection cdmadataconnection = findFreeDataConnection();
        boolean flag;
        if(cdmadataconnection == null) {
            log("setupData: No free CdmaDataConnection found!");
            flag = false;
        } else {
            mPendingDataConnection = cdmadataconnection;
            String as[];
            byte byte0;
            Message message;
            if(super.mRequestedApnType.equals("dun")) {
                as = mDunApnTypes;
                byte0 = 3;
            } else {
                as = mDefaultApnTypes;
                byte0 = 0;
            }
            super.mActiveApn = new ApnSetting(byte0, "", "", "", "", "", "", "", "", "", "", 0, as, "IP", "IP", true, 0);
            log((new StringBuilder()).append("call conn.bringUp mActiveApn=").append(super.mActiveApn).toString());
            message = obtainMessage();
            message.what = 0x42000;
            message.obj = s;
            cdmadataconnection.bringUp(message, super.mActiveApn);
            setState(com.android.internal.telephony.DataConnectionTracker.State.INITING);
            notifyDataConnection(s);
            flag = true;
        }
        return flag;
    }

    private boolean shouldPostNotification(com.android.internal.telephony.DataConnection.FailCause failcause) {
        boolean flag;
        if(failcause != com.android.internal.telephony.DataConnection.FailCause.UNKNOWN)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private void startAlarmForReconnect(int i, String s) {
        log((new StringBuilder()).append("Data Connection activate failed. Scheduling next attempt for ").append(i / 1000).append("s").toString());
        AlarmManager alarmmanager = (AlarmManager)super.mPhone.getContext().getSystemService("alarm");
        Intent intent = new Intent("com.android.internal.telephony.cdma-reconnect");
        intent.putExtra("reconnect_alarm_extra_reason", s);
        super.mReconnectIntent = PendingIntent.getBroadcast(super.mPhone.getContext(), 0, intent, 0);
        alarmmanager.set(2, SystemClock.elapsedRealtime() + (long)i, super.mReconnectIntent);
    }

    private void startDelayedRetry(com.android.internal.telephony.DataConnection.FailCause failcause, String s, int i) {
        notifyNoData(failcause);
        reconnectAfterFail(failcause, s, i);
    }

    private boolean trySetupData(String s) {
        StringBuilder stringbuilder = (new StringBuilder()).append("***trySetupData due to ");
        String s1;
        boolean flag;
        if(s == null)
            s1 = "(unspecified)";
        else
            s1 = s;
        log(stringbuilder.append(s1).toString());
        if(super.mPhone.getSimulatedRadioControl() != null) {
            setState(com.android.internal.telephony.DataConnectionTracker.State.CONNECTED);
            notifyDataConnection(s);
            notifyOffApnsOfAvailability(s);
            log("(fix?) We're on the simulator; assuming data is connected");
            flag = true;
        } else {
            mCdmaPhone.mSST.getCurrentDataConnectionState();
            super.mPhone.getServiceState().getRoaming();
            mCdmaPhone.mSST.getDesiredPowerState();
            if((super.mState == com.android.internal.telephony.DataConnectionTracker.State.IDLE || super.mState == com.android.internal.telephony.DataConnectionTracker.State.SCANNING) && isDataAllowed() && getAnyDataEnabled() && !isEmergency()) {
                flag = setupData(s);
                notifyOffApnsOfAvailability(s);
            } else {
                notifyOffApnsOfAvailability(s);
                flag = false;
            }
        }
        return flag;
    }

    private void writeEventLogCdmaDataDrop() {
        CdmaCellLocation cdmacelllocation = (CdmaCellLocation)(CdmaCellLocation)super.mPhone.getCellLocation();
        Object aobj[] = new Object[2];
        int i;
        if(cdmacelllocation != null)
            i = cdmacelllocation.getBaseStationId();
        else
            i = -1;
        aobj[0] = Integer.valueOf(i);
        aobj[1] = Integer.valueOf(TelephonyManager.getDefault().getNetworkType());
        EventLog.writeEvent(50111, aobj);
    }

    public void dispose() {
        cleanUpConnection(false, null, false);
        dispose();
        super.mPhone.mCM.unregisterForAvailable(this);
        super.mPhone.mCM.unregisterForOffOrNotAvailable(this);
        ((PhoneBase) (mCdmaPhone)).mIccRecords.unregisterForRecordsLoaded(this);
        super.mPhone.mCM.unregisterForDataNetworkStateChanged(this);
        mCdmaPhone.mCT.unregisterForVoiceCallEnded(this);
        mCdmaPhone.mCT.unregisterForVoiceCallStarted(this);
        mCdmaPhone.mSST.unregisterForDataConnectionAttached(this);
        mCdmaPhone.mSST.unregisterForDataConnectionDetached(this);
        mCdmaPhone.mSST.unregisterForRoamingOn(this);
        mCdmaPhone.mSST.unregisterForRoamingOff(this);
        mCdmaSSM.dispose(this);
        super.mPhone.mCM.unregisterForCdmaOtaProvision(this);
        destroyAllDataConnectionList();
    }

    public void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        printwriter.println("CdmaDataConnectionTracker extends:");
        dump(filedescriptor, printwriter, as);
        printwriter.println((new StringBuilder()).append(" mCdmaPhone=").append(mCdmaPhone).toString());
        printwriter.println((new StringBuilder()).append(" mCdmaSSM=").append(mCdmaSSM).toString());
        printwriter.println((new StringBuilder()).append(" mPendingDataConnection=").append(mPendingDataConnection).toString());
        printwriter.println((new StringBuilder()).append(" mPendingRestartRadio=").append(mPendingRestartRadio).toString());
        printwriter.println((new StringBuilder()).append(" mSupportedApnTypes=").append(mSupportedApnTypes).toString());
        printwriter.println((new StringBuilder()).append(" mDefaultApnTypes=").append(mDefaultApnTypes).toString());
        printwriter.println((new StringBuilder()).append(" mDunApnTypes=").append(mDunApnTypes).toString());
        printwriter.println(" mDefaultApnId=0");
    }

    protected void finalize() {
        log("CdmaDataConnectionTracker finalized");
    }

    protected String getActionIntentDataStallAlarm() {
        return "com.android.internal.telephony.cdma-data-stall";
    }

    protected String getActionIntentReconnectAlarm() {
        return "com.android.internal.telephony.cdma-reconnect";
    }

    ApnSetting getActiveApn() {
        return super.mActiveApn;
    }

    HashMap getDataConnectionAsyncChannels() {
        return super.mDataConnectionAsyncChannels;
    }

    /**
     * @deprecated Method getState is deprecated
     */

    public com.android.internal.telephony.DataConnectionTracker.State getState(String s) {
        this;
        JVM INSTR monitorenter ;
        com.android.internal.telephony.DataConnectionTracker.State state = super.mState;
        this;
        JVM INSTR monitorexit ;
        return state;
        Exception exception;
        exception;
        throw exception;
    }

    protected void gotoIdleAndNotifyDataConnection(String s) {
        log((new StringBuilder()).append("gotoIdleAndNotifyDataConnection: reason=").append(s).toString());
        setState(com.android.internal.telephony.DataConnectionTracker.State.IDLE);
        notifyDataConnection(s);
        super.mActiveApn = null;
    }

    public void handleMessage(Message message) {
        log((new StringBuilder()).append("CdmaDCT handleMessage msg=").append(message).toString());
        if(super.mPhone.mIsTheCurrentActivePhone && !super.mIsDisposed) goto _L2; else goto _L1
_L1:
        log("Ignore CDMA msgs since CDMA phone is inactive");
_L4:
        return;
_L2:
        switch(message.what) {
        default:
            handleMessage(message);
            break;

        case 270338: 
            onRecordsLoaded();
            break;

        case 270357: 
            if(mCdmaSSM.getCdmaSubscriptionSource() == 1)
                onNVReady();
            break;

        case 270356: 
            onCdmaDataDetached();
            break;

        case 270340: 
            onDataStateChanged((AsyncResult)message.obj);
            break;

        case 270361: 
            onCdmaOtaProvision((AsyncResult)message.obj);
            break;

        case 270362: 
            log("EVENT_RESTART_RADIO");
            onRestartRadio();
            break;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected boolean isApnTypeAvailable(String s) {
        String as[];
        int i;
        int j;
        as = mSupportedApnTypes;
        i = as.length;
        j = 0;
_L3:
        if(j >= i)
            break MISSING_BLOCK_LABEL_39;
        if(!TextUtils.equals(s, as[j])) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        j++;
          goto _L3
        flag = false;
          goto _L4
    }

    protected boolean isDataAllowed() {
        boolean flag;
        synchronized(super.mDataEnabledLock) {
            flag = super.mInternalDataEnabled;
        }
        int i = mCdmaPhone.mSST.getCurrentDataConnectionState();
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        if(super.mPhone.getServiceState().getRoaming() && !getDataOnRoamingEnabled())
            flag1 = true;
        else
            flag1 = false;
        flag2 = mCdmaPhone.mSST.getDesiredPowerState();
        if(mCdmaSSM.getCdmaSubscriptionSource() == 1)
            flag3 = true;
        else
            flag3 = false;
        if((i == 0 || super.mAutoAttachOnCreation) && (flag3 || ((PhoneBase) (mCdmaPhone)).mIccRecords.getRecordsLoaded()) && (mCdmaPhone.mSST.isConcurrentVoiceAndDataAllowed() || super.mPhone.getState() == com.android.internal.telephony.Phone.State.IDLE) && !flag1 && flag && flag2 && !mPendingRestartRadio && (super.mPhone.getLteOnCdmaMode() == 1 || !mCdmaPhone.needsOtaServiceProvisioning()))
            flag4 = true;
        else
            flag4 = false;
        if(!flag4) {
            String s = "";
            if(i != 0 && !super.mAutoAttachOnCreation)
                s = (new StringBuilder()).append(s).append(" - psState= ").append(i).toString();
            if(!flag3 && !((PhoneBase) (mCdmaPhone)).mIccRecords.getRecordsLoaded())
                s = (new StringBuilder()).append(s).append(" - RUIM not loaded").toString();
            if(!mCdmaPhone.mSST.isConcurrentVoiceAndDataAllowed() && super.mPhone.getState() != com.android.internal.telephony.Phone.State.IDLE)
                s = (new StringBuilder()).append(s).append(" - concurrentVoiceAndData not allowed and state= ").append(super.mPhone.getState()).toString();
            if(flag1)
                s = (new StringBuilder()).append(s).append(" - Roaming").toString();
            if(!flag)
                s = (new StringBuilder()).append(s).append(" - mInternalDataEnabled= false").toString();
            if(!flag2)
                s = (new StringBuilder()).append(s).append(" - desiredPowerState= false").toString();
            if(mPendingRestartRadio)
                s = (new StringBuilder()).append(s).append(" - mPendingRestartRadio= true").toString();
            if(mCdmaPhone.needsOtaServiceProvisioning())
                s = (new StringBuilder()).append(s).append(" - needs Provisioning").toString();
            log((new StringBuilder()).append("Data not allowed due to").append(s).toString());
        }
        return flag4;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected boolean isDataPossible(String s) {
        boolean flag;
        if(isDataAllowed() && (!getAnyDataEnabled() || super.mState != com.android.internal.telephony.DataConnectionTracker.State.FAILED && super.mState != com.android.internal.telephony.DataConnectionTracker.State.IDLE))
            flag = true;
        else
            flag = false;
        if(!flag && isDataAllowed())
            log((new StringBuilder()).append("Data not possible.  No coverage: dataState = ").append(super.mState).toString());
        return flag;
    }

    public boolean isDisconnected() {
        boolean flag;
        if(super.mState == com.android.internal.telephony.DataConnectionTracker.State.IDLE || super.mState == com.android.internal.telephony.DataConnectionTracker.State.FAILED)
            flag = true;
        else
            flag = false;
        return flag;
    }

    protected void log(String s) {
        Log.d("CDMA", (new StringBuilder()).append("[CdmaDCT] ").append(s).toString());
    }

    protected void loge(String s) {
        Log.e("CDMA", (new StringBuilder()).append("[CdmaDCT] ").append(s).toString());
    }

    protected void onCleanUpAllConnections(String s) {
        cleanUpConnection(true, s, false);
    }

    protected void onCleanUpConnection(boolean flag, int i, String s) {
        boolean flag1;
        if(i == 3)
            flag1 = true;
        else
            flag1 = false;
        cleanUpConnection(flag, s, flag1);
    }

    protected void onDataSetupComplete(AsyncResult asyncresult) {
        String s = null;
        if(asyncresult.userObj instanceof String)
            s = (String)asyncresult.userObj;
        if(isDataSetupCompleteOk(asyncresult)) {
            Injector.onDataSetupComplete(this);
            notifyDefaultData(s);
        } else {
            com.android.internal.telephony.DataConnection.FailCause failcause = (com.android.internal.telephony.DataConnection.FailCause)(com.android.internal.telephony.DataConnection.FailCause)asyncresult.result;
            log((new StringBuilder()).append("Data Connection setup failed ").append(failcause).toString());
            if(failcause.isPermanentFail()) {
                notifyNoData(failcause);
            } else {
                int i = -1;
                if(asyncresult.exception instanceof com.android.internal.telephony.DataConnection.CallSetupException)
                    i = ((com.android.internal.telephony.DataConnection.CallSetupException)asyncresult.exception).getRetryOverride();
                if(i == 0x7fffffff)
                    log("No retry is suggested.");
                else
                    startDelayedRetry(failcause, s, i);
            }
        }
    }

    protected void onDataStateChanged(AsyncResult asyncresult) {
        ArrayList arraylist = (ArrayList)(ArrayList)asyncresult.result;
        if(asyncresult.exception == null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        boolean flag;
        int i;
        int j;
        if(super.mState != com.android.internal.telephony.DataConnectionTracker.State.CONNECTED)
            break MISSING_BLOCK_LABEL_208;
        flag = false;
        i = 0;
        j = 0;
_L4:
label0:
        {
            if(j < arraylist.size()) {
                i = ((DataCallState)arraylist.get(j)).active;
                if(i == 0)
                    break label0;
                flag = true;
            }
            if(!flag) {
                log("onDataStateChanged: No active connectionstate is CONNECTED, disconnecting/cleanup");
                writeEventLogCdmaDataDrop();
                cleanUpConnection(true, null, false);
            } else {
                switch(i) {
                default:
                    log((new StringBuilder()).append("onDataStateChanged: IGNORE unexpected DataCallState.active=").append(i).toString());
                    break;

                case 2: // '\002'
                    log("onDataStateChanged: active=LINK_ACTIVE && CONNECTED, ignore");
                    super.mActivity = com.android.internal.telephony.DataConnectionTracker.Activity.NONE;
                    super.mPhone.notifyDataActivity();
                    startNetStatPoll();
                    break;

                case 1: // '\001'
                    log("onDataStateChanged active=LINK_DOWN && CONNECTED, dormant");
                    super.mActivity = com.android.internal.telephony.DataConnectionTracker.Activity.DORMANT;
                    super.mPhone.notifyDataActivity();
                    stopNetStatPoll();
                    break;
                }
                continue; /* Loop/switch isn't completed */
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
        j++;
          goto _L4
        log((new StringBuilder()).append("onDataStateChanged: not connected, state=").append(super.mState).append(" ignoring").toString());
        if(true) goto _L1; else goto _L5
_L5:
    }

    protected void onDisconnectDone(int i, AsyncResult asyncresult) {
        log((new StringBuilder()).append("EVENT_DISCONNECT_DONE connId=").append(i).toString());
        String s = null;
        if(asyncresult.userObj instanceof String)
            s = (String)asyncresult.userObj;
        setState(com.android.internal.telephony.DataConnectionTracker.State.IDLE);
        Injector.onDisconnectDone(this);
        if(mPendingRestartRadio)
            removeMessages(0x4201a);
        if(mCdmaPhone.mSST.processPendingRadioPowerOffAfterDataOff())
            mPendingRestartRadio = false;
        else
            onRestartRadio();
        notifyDataConnection(s);
        super.mActiveApn = null;
        if(retryAfterDisconnected(s))
            startAlarmForReconnect(APN_DELAY_MILLIS, s);
    }

    protected void onEnableNewApn() {
        cleanUpConnection(true, "apnSwitched", false);
    }

    protected void onNVReady() {
        if(super.mState == com.android.internal.telephony.DataConnectionTracker.State.FAILED)
            cleanUpAllConnections(null);
        sendMessage(obtainMessage(0x42003));
    }

    protected void onRadioAvailable() {
        if(super.mPhone.getSimulatedRadioControl() != null) {
            setState(com.android.internal.telephony.DataConnectionTracker.State.CONNECTED);
            notifyDataConnection(null);
            log("We're on the simulator; assuming data is connected");
        }
        notifyOffApnsOfAvailability(null);
        if(super.mState != com.android.internal.telephony.DataConnectionTracker.State.IDLE)
            cleanUpAllConnections(null);
    }

    protected void onRadioOffOrNotAvailable() {
        ((DataConnection)super.mDataConnections.get(Integer.valueOf(0))).resetRetryCount();
        if(super.mPhone.getSimulatedRadioControl() != null) {
            log("We're on the simulator; assuming radio off is meaningless");
        } else {
            log("Radio is off and clean up all connection");
            cleanUpAllConnections(null);
        }
    }

    protected void onRecordsLoaded() {
        if(super.mState == com.android.internal.telephony.DataConnectionTracker.State.FAILED)
            cleanUpAllConnections(null);
        sendMessage(obtainMessage(0x42003, "simLoaded"));
    }

    protected void onRoamingOff() {
        if(super.mUserDataEnabled)
            if(!getDataOnRoamingEnabled()) {
                notifyOffApnsOfAvailability("roamingOff");
                trySetupData("roamingOff");
            } else {
                notifyDataConnection("roamingOff");
            }
    }

    protected void onRoamingOn() {
        if(super.mUserDataEnabled)
            if(getDataOnRoamingEnabled()) {
                trySetupData("roamingOn");
                notifyDataConnection("roamingOn");
            } else {
                log("Tear down data connection on roaming.");
                cleanUpAllConnections(null);
                notifyOffApnsOfAvailability("roamingOn");
            }
    }

    protected boolean onTrySetupData(String s) {
        return trySetupData(s);
    }

    protected void onVoiceCallEnded() {
        if(super.mState == com.android.internal.telephony.DataConnectionTracker.State.CONNECTED) {
            if(!mCdmaPhone.mSST.isConcurrentVoiceAndDataAllowed()) {
                startNetStatPoll();
                notifyDataConnection("2GVoiceCallEnded");
            } else {
                resetPollStats();
            }
            notifyOffApnsOfAvailability("2GVoiceCallEnded");
        } else {
            ((DataConnection)super.mDataConnections.get(Integer.valueOf(0))).resetRetryCount();
            trySetupData("2GVoiceCallEnded");
        }
    }

    protected void onVoiceCallStarted() {
        if(super.mState == com.android.internal.telephony.DataConnectionTracker.State.CONNECTED && !mCdmaPhone.mSST.isConcurrentVoiceAndDataAllowed()) {
            stopNetStatPoll();
            notifyDataConnection("2GVoiceCallStarted");
            notifyOffApnsOfAvailability("2GVoiceCallStarted");
        }
    }

    protected void restartDataStallAlarm() {
    }

    protected void restartRadio() {
        log((new StringBuilder()).append("Cleanup connection and wait ").append(TIME_DELAYED_TO_RESTART_RADIO / 1000).append("s to restart radio").toString());
        cleanUpAllConnections(null);
        sendEmptyMessageDelayed(0x4201a, TIME_DELAYED_TO_RESTART_RADIO);
        mPendingRestartRadio = true;
    }

    protected void setState(com.android.internal.telephony.DataConnectionTracker.State state) {
        log((new StringBuilder()).append("setState: ").append(state).toString());
        if(super.mState != state) {
            Object aobj[] = new Object[2];
            aobj[0] = super.mState.toString();
            aobj[1] = state.toString();
            EventLog.writeEvent(50115, aobj);
            super.mState = state;
        }
    }

    protected void startNetStatPoll() {
        if(super.mState == com.android.internal.telephony.DataConnectionTracker.State.CONNECTED && !super.mNetStatPollEnabled) {
            log("[DataConnection] Start poll NetStat");
            resetPollStats();
            super.mNetStatPollEnabled = true;
            mPollNetStat.run();
        }
    }

    protected void stopNetStatPoll() {
        super.mNetStatPollEnabled = false;
        removeCallbacks(mPollNetStat);
        log("[DataConnection] Stop poll NetStat");
    }

    private static final int DATA_CONNECTION_ACTIVE_PH_LINK_DOWN = 1;
    private static final int DATA_CONNECTION_ACTIVE_PH_LINK_INACTIVE = 0;
    private static final int DATA_CONNECTION_ACTIVE_PH_LINK_UP = 2;
    private static final int DATA_CONNECTION_POOL_SIZE = 1;
    private static final String INTENT_DATA_STALL_ALARM = "com.android.internal.telephony.cdma-data-stall";
    private static final String INTENT_RECONNECT_ALARM = "com.android.internal.telephony.cdma-reconnect";
    private static final int TIME_DELAYED_TO_RESTART_RADIO = SystemProperties.getInt("ro.cdma.timetoradiorestart", 60000);
    private static final int mDefaultApnId;
    private static final String mDefaultApnTypes[];
    private static final String mSupportedApnTypes[];
    protected final String LOG_TAG = "CDMA";
    private CDMAPhone mCdmaPhone;
    private CdmaSubscriptionSourceManager mCdmaSSM;
    private String mDunApnTypes[];
    private CdmaDataConnection mPendingDataConnection;
    private boolean mPendingRestartRadio;
    private Runnable mPollNetStat;

    static  {
        String as[] = new String[4];
        as[0] = "default";
        as[1] = "mms";
        as[2] = "dun";
        as[3] = "hipri";
        mSupportedApnTypes = as;
        String as1[] = new String[3];
        as1[0] = "default";
        as1[1] = "mms";
        as1[2] = "hipri";
        mDefaultApnTypes = as1;
    }




/*
    static long access$1002(CdmaDataConnectionTracker cdmadataconnectiontracker, long l) {
        cdmadataconnectiontracker.mSentSinceLastRecv = l;
        return l;
    }

*/


/*
    static long access$1102(CdmaDataConnectionTracker cdmadataconnectiontracker, long l) {
        cdmadataconnectiontracker.mSentSinceLastRecv = l;
        return l;
    }

*/




/*
    static long access$1402(CdmaDataConnectionTracker cdmadataconnectiontracker, long l) {
        cdmadataconnectiontracker.mSentSinceLastRecv = l;
        return l;
    }

*/






/*
    static com.android.internal.telephony.DataConnectionTracker.Activity access$1902(CdmaDataConnectionTracker cdmadataconnectiontracker, com.android.internal.telephony.DataConnectionTracker.Activity activity) {
        cdmadataconnectiontracker.mActivity = activity;
        return activity;
    }

*/



/*
    static long access$202(CdmaDataConnectionTracker cdmadataconnectiontracker, long l) {
        cdmadataconnectiontracker.mTxPkts = l;
        return l;
    }

*/






/*
    static int access$2508(CdmaDataConnectionTracker cdmadataconnectiontracker) {
        int i = ((DataConnectionTracker) (cdmadataconnectiontracker)).mNoRecvPollCount;
        cdmadataconnectiontracker.mNoRecvPollCount = i + 1;
        return i;
    }

*/


/*
    static int access$2602(CdmaDataConnectionTracker cdmadataconnectiontracker, int i) {
        cdmadataconnectiontracker.mNetStatPollPeriod = i;
        return i;
    }

*/



/*
    static boolean access$2802(CdmaDataConnectionTracker cdmadataconnectiontracker, boolean flag) {
        cdmadataconnectiontracker.mNetStatPollEnabled = flag;
        return flag;
    }

*/


/*
    static int access$2902(CdmaDataConnectionTracker cdmadataconnectiontracker, int i) {
        cdmadataconnectiontracker.mNoRecvPollCount = i;
        return i;
    }

*/


/*
    static int access$3002(CdmaDataConnectionTracker cdmadataconnectiontracker, int i) {
        cdmadataconnectiontracker.mNetStatPollPeriod = i;
        return i;
    }

*/


/*
    static long access$302(CdmaDataConnectionTracker cdmadataconnectiontracker, long l) {
        cdmadataconnectiontracker.mRxPkts = l;
        return l;
    }

*/








/*
    static long access$702(CdmaDataConnectionTracker cdmadataconnectiontracker, long l) {
        cdmadataconnectiontracker.mSentSinceLastRecv = l;
        return l;
    }

*/



/*
    static long access$914(CdmaDataConnectionTracker cdmadataconnectiontracker, long l) {
        long l1 = l + ((DataConnectionTracker) (cdmadataconnectiontracker)).mSentSinceLastRecv;
        cdmadataconnectiontracker.mSentSinceLastRecv = l1;
        return l1;
    }

*/
}
