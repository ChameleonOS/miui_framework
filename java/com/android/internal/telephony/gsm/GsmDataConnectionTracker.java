// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.gsm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.*;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.*;
import android.os.*;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.EventLog;
import android.util.Log;
import com.android.internal.telephony.*;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import miui.net.FirewallManager;

// Referenced classes of package com.android.internal.telephony.gsm:
//            GsmDataConnection, GSMPhone

public final class GsmDataConnectionTracker extends DataConnectionTracker {
    private static class RecoveryAction {

        private static boolean isAggressiveRecovery(int i) {
            boolean flag = true;
            if(i != flag && i != 2 && i != 3 && i != 4)
                flag = false;
            return flag;
        }

        public static final int CLEANUP = 1;
        public static final int GET_DATA_CALL_LIST = 0;
        public static final int RADIO_RESTART = 3;
        public static final int RADIO_RESTART_WITH_PROP = 4;
        public static final int REREGISTER = 2;


        private RecoveryAction() {
        }
    }

    /* member class not found */
    class ApnChangeObserver {}


    public GsmDataConnectionTracker(PhoneBase phonebase) {
        DataConnectionTracker(phonebase);
        mReregisterOnReconnectFailure = false;
        canSetPreferApn = false;
        mPollNetStat = new Runnable() ;
        log("GsmDCT.constructor");
        phonebase.mCM.registerForAvailable(this, 0x42001, null);
        phonebase.mCM.registerForOffOrNotAvailable(this, 0x42006, null);
        phonebase.mIccRecords.registerForRecordsLoaded(this, 0x42002, null);
        phonebase.mCM.registerForDataNetworkStateChanged(this, 0x42004, null);
        phonebase.getCallTracker().registerForVoiceCallEnded(this, 0x42008, null);
        phonebase.getCallTracker().registerForVoiceCallStarted(this, 0x42007, null);
        phonebase.getServiceStateTracker().registerForDataConnectionAttached(this, 0x42010, null);
        phonebase.getServiceStateTracker().registerForDataConnectionDetached(this, 0x42009, null);
        phonebase.getServiceStateTracker().registerForRoamingOn(this, 0x4200b, null);
        phonebase.getServiceStateTracker().registerForRoamingOff(this, 0x4200c, null);
        phonebase.getServiceStateTracker().registerForPsRestrictedEnabled(this, 0x42016, null);
        phonebase.getServiceStateTracker().registerForPsRestrictedDisabled(this, 0x42017, null);
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("com.android.internal.telephony.gprs-data-stall");
        phonebase.getContext().registerReceiver(mIntentReceiver, intentfilter, null, phonebase);
        mDataConnectionTracker = this;
        mResolver = mPhone.getContext().getContentResolver();
        mApnObserver = new ApnChangeObserver();
        phonebase.getContext().getContentResolver().registerContentObserver(android.provider.Telephony.Carriers.CONTENT_URI, true, mApnObserver);
        initApnContextsAndDataConnection();
        broadcastMessenger();
    }

    private ApnContext addApnContext(String s) {
        ApnContext apncontext = new ApnContext(s, "GSM");
        apncontext.setDependencyMet(false);
        mApnContexts.put(s, apncontext);
        return apncontext;
    }

    private String apnListToString(ArrayList arraylist) {
        StringBuilder stringbuilder = new StringBuilder();
        int i = 0;
        for(int j = arraylist.size(); i < j; i++)
            stringbuilder.append('[').append(((ApnSetting)arraylist.get(i)).toString()).append(']');

        return stringbuilder.toString();
    }

    private void applyNewState(ApnContext apncontext, boolean flag, boolean flag1) {
        boolean flag2;
        boolean flag3;
        flag2 = false;
        flag3 = false;
        log((new StringBuilder()).append("applyNewState(").append(apncontext.getApnType()).append(", ").append(flag).append("(").append(apncontext.isEnabled()).append("), ").append(flag1).append("(").append(apncontext.getDependencyMet()).append("))").toString());
        if(!apncontext.isReady()) goto _L2; else goto _L1
_L1:
        if(!flag || !flag1) goto _L4; else goto _L3
_L3:
        return;
_L4:
        if(!flag)
            apncontext.setReason("dataDisabled");
        else
            apncontext.setReason("dependencyUnmet");
        flag2 = true;
_L5:
        apncontext.setEnabled(flag);
        apncontext.setDependencyMet(flag1);
        if(flag2)
            cleanUpConnection(true, apncontext);
        if(flag3)
            trySetupData(apncontext);
        if(true) goto _L3; else goto _L2
_L2:
        if(flag && flag1) {
            if(apncontext.isEnabled())
                apncontext.setReason("dependencyMet");
            else
                apncontext.setReason("dataEnabled");
            if(apncontext.getState() == com.android.internal.telephony.DataConnectionTracker.State.FAILED)
                apncontext.setState(com.android.internal.telephony.DataConnectionTracker.State.IDLE);
            flag3 = true;
        }
          goto _L5
    }

    private ArrayList buildWaitingApns(String s) {
        ArrayList arraylist = new ArrayList();
        if(!s.equals("dun")) goto _L2; else goto _L1
_L1:
        ApnSetting apnsetting1 = fetchDunApn();
        if(apnsetting1 == null) goto _L2; else goto _L3
_L3:
        arraylist.add(apnsetting1);
        log((new StringBuilder()).append("buildWaitingApns: X added APN_TYPE_DUN apnList=").append(arraylist).toString());
_L5:
        return arraylist;
_L2:
        String s1 = mPhone.mIccRecords.getOperatorNumeric();
        int i = mPhone.getServiceState().getRilRadioTechnology();
        if(canSetPreferApn && mPreferredApn != null && mPreferredApn.canHandleType(s)) {
            log((new StringBuilder()).append("buildWaitingApns: Preferred APN:").append(s1).append(":").append(mPreferredApn.numeric).append(":").append(mPreferredApn).toString());
            Iterator iterator;
            ApnSetting apnsetting;
            if(mPreferredApn.numeric.equals(s1)) {
                if(mPreferredApn.bearer == 0 || mPreferredApn.bearer == i) {
                    arraylist.add(mPreferredApn);
                    log((new StringBuilder()).append("buildWaitingApns: X added preferred apnList=").append(arraylist).toString());
                    continue; /* Loop/switch isn't completed */
                }
                log("buildWaitingApns: no preferred APN");
                setPreferredApn(-1);
                mPreferredApn = null;
            } else {
                log("buildWaitingApns: no preferred APN");
                setPreferredApn(-1);
                mPreferredApn = null;
            }
        }
        if(mAllApns != null) {
            iterator = mAllApns.iterator();
            do {
                if(!iterator.hasNext())
                    break;
                apnsetting = (ApnSetting)iterator.next();
                if(apnsetting.canHandleType(s) && (apnsetting.bearer == 0 || apnsetting.bearer == i)) {
                    log((new StringBuilder()).append("apn info : ").append(apnsetting.toString()).toString());
                    arraylist.add(apnsetting);
                }
            } while(true);
        } else {
            loge("mAllApns is empty!");
        }
        log((new StringBuilder()).append("buildWaitingApns: X apnList=").append(arraylist).toString());
        if(true) goto _L5; else goto _L4
_L4:
    }

    private void cancelReconnectAlarm(DataConnectionAc dataconnectionac) {
        if(dataconnectionac != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        PendingIntent pendingintent = dataconnectionac.getReconnectIntentSync();
        if(pendingintent != null) {
            ((AlarmManager)mPhone.getContext().getSystemService("alarm")).cancel(pendingintent);
            dataconnectionac.setReconnectIntentSync(null);
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private DataConnection checkForConnectionForApnContext(ApnContext apncontext) {
        String s;
        ApnSetting apnsetting;
        DataConnection dataconnection;
        Iterator iterator;
        s = apncontext.getApnType();
        apnsetting = null;
        if("dun".equals(s))
            apnsetting = fetchDunApn();
        dataconnection = null;
        iterator = mApnContexts.values().iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        DataConnection dataconnection1;
        ApnContext apncontext1;
        apncontext1 = (ApnContext)iterator.next();
        dataconnection1 = apncontext1.getDataConnection();
        if(dataconnection1 == null) goto _L4; else goto _L3
_L3:
        ApnSetting apnsetting1 = apncontext1.getApnSetting();
        if(apnsetting == null) goto _L6; else goto _L5
_L5:
        if(!apnsetting.equals(apnsetting1)) goto _L4; else goto _L7
_L7:
        class _cls2 {

            static final int $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[];

            static  {
                $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State = new int[com.android.internal.telephony.DataConnectionTracker.State.values().length];
                NoSuchFieldError nosuchfielderror5;
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[com.android.internal.telephony.DataConnectionTracker.State.CONNECTED.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[com.android.internal.telephony.DataConnectionTracker.State.DISCONNECTING.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror1) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[com.android.internal.telephony.DataConnectionTracker.State.CONNECTING.ordinal()] = 3;
                }
                catch(NoSuchFieldError nosuchfielderror2) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[com.android.internal.telephony.DataConnectionTracker.State.INITING.ordinal()] = 4;
                }
                catch(NoSuchFieldError nosuchfielderror3) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[com.android.internal.telephony.DataConnectionTracker.State.IDLE.ordinal()] = 5;
                }
                catch(NoSuchFieldError nosuchfielderror4) { }
                $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[com.android.internal.telephony.DataConnectionTracker.State.SCANNING.ordinal()] = 6;
_L2:
                return;
                nosuchfielderror5;
                if(true) goto _L2; else goto _L1
_L1:
            }
        }

        _cls2..SwitchMap.com.android.internal.telephony.DataConnectionTracker.State[apncontext1.getState().ordinal()];
        JVM INSTR tableswitch 1 3: default 132
    //                   1 135
    //                   2 132
    //                   3 173;
           goto _L4 _L8 _L4 _L9
_L8:
        log((new StringBuilder()).append("checkForConnectionForApnContext: apnContext=").append(apncontext).append(" found conn=").append(dataconnection1).toString());
_L13:
        return dataconnection1;
_L9:
        dataconnection = dataconnection1;
          goto _L4
_L6:
        if(apnsetting1 == null || !apnsetting1.canHandleType(s)) goto _L4; else goto _L10
_L10:
        _cls2..SwitchMap.com.android.internal.telephony.DataConnectionTracker.State[apncontext1.getState().ordinal()];
        JVM INSTR tableswitch 1 3: default 232
    //                   1 235
    //                   2 232
    //                   3 273;
           goto _L4 _L11 _L4 _L12
_L11:
        log((new StringBuilder()).append("checkForConnectionForApnContext: apnContext=").append(apncontext).append(" found conn=").append(dataconnection1).toString());
          goto _L13
_L12:
        dataconnection = dataconnection1;
          goto _L4
_L2:
        if(dataconnection != null) {
            log((new StringBuilder()).append("checkForConnectionForApnContext: apnContext=").append(apncontext).append(" found conn=").append(dataconnection).toString());
            dataconnection1 = dataconnection;
        } else {
            log((new StringBuilder()).append("checkForConnectionForApnContext: apnContext=").append(apncontext).append(" NO conn").toString());
            dataconnection1 = null;
        }
          goto _L13
    }

    private void cleanUpConnection(boolean flag, ApnContext apncontext) {
        if(apncontext == null) {
            log("cleanUpConnection: apn context is null");
        } else {
            DataConnectionAc dataconnectionac = apncontext.getDataConnectionAc();
            log((new StringBuilder()).append("cleanUpConnection: E tearDown=").append(flag).append(" reason=").append(apncontext.getReason()).append(" apnContext=").append(apncontext).toString());
            if(flag) {
                if(apncontext.isDisconnected()) {
                    apncontext.setState(com.android.internal.telephony.DataConnectionTracker.State.IDLE);
                    if(!apncontext.isReady()) {
                        apncontext.setDataConnection(null);
                        apncontext.setDataConnectionAc(null);
                    }
                } else
                if(dataconnectionac != null) {
                    if(apncontext.getState() != com.android.internal.telephony.DataConnectionTracker.State.DISCONNECTING) {
                        boolean flag1 = false;
                        if("dun".equals(apncontext.getApnType())) {
                            ApnSetting apnsetting = fetchDunApn();
                            if(apnsetting != null && apnsetting.equals(apncontext.getApnSetting())) {
                                log("tearing down dedicated DUN connection");
                                flag1 = true;
                            }
                        }
                        StringBuilder stringbuilder = (new StringBuilder()).append("cleanUpConnection: tearing down");
                        String s;
                        Message message;
                        if(flag1)
                            s = " all";
                        else
                            s = "";
                        log(stringbuilder.append(s).toString());
                        message = obtainMessage(0x4200f, apncontext);
                        if(flag1)
                            apncontext.getDataConnection().tearDownAll(apncontext.getReason(), message);
                        else
                            apncontext.getDataConnection().tearDown(apncontext.getReason(), message);
                        apncontext.setState(com.android.internal.telephony.DataConnectionTracker.State.DISCONNECTING);
                    }
                } else {
                    apncontext.setState(com.android.internal.telephony.DataConnectionTracker.State.IDLE);
                    mPhone.notifyDataConnection(apncontext.getReason(), apncontext.getApnType());
                }
            } else {
                if(dataconnectionac != null)
                    dataconnectionac.resetSync();
                apncontext.setState(com.android.internal.telephony.DataConnectionTracker.State.IDLE);
                mPhone.notifyDataConnection(apncontext.getReason(), apncontext.getApnType());
                apncontext.setDataConnection(null);
                apncontext.setDataConnectionAc(null);
            }
            if(dataconnectionac != null && dataconnectionac.getApnListSync().isEmpty())
                cancelReconnectAlarm(dataconnectionac);
            log((new StringBuilder()).append("cleanUpConnection: X tearDown=").append(flag).append(" reason=").append(apncontext.getReason()).append(" apnContext=").append(apncontext).append(" dc=").append(apncontext.getDataConnection()).toString());
        }
    }

    private void configureRetry(DataConnection dataconnection, boolean flag, int i) {
        log((new StringBuilder()).append("configureRetry: forDefault=").append(flag).append(" retryCount=").append(i).append(" dc=").append(dataconnection).toString());
        if(dataconnection != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(!dataconnection.configureRetry(getReryConfig(flag))) {
            if(!flag)
                break; /* Loop/switch isn't completed */
            if(!dataconnection.configureRetry("default_randomization=2000,5000,10000,20000,40000,80000:5000,160000:5000,320000:5000,640000:5000,1280000:5000,1800000:5000")) {
                loge("configureRetry: Could not configure using DEFAULT_DATA_RETRY_CONFIG=default_randomization=2000,5000,10000,20000,40000,80000:5000,160000:5000,320000:5000,640000:5000,1280000:5000,1800000:5000");
                dataconnection.configureRetry(20, 2000, 1000);
            }
        }
_L5:
        dataconnection.setRetryCount(i);
        if(true) goto _L1; else goto _L3
_L3:
        if(dataconnection.configureRetry("max_retries=3, 5000, 5000, 5000")) goto _L5; else goto _L4
_L4:
        loge("configureRetry: Could note configure using SECONDARY_DATA_RETRY_CONFIG=max_retries=3, 5000, 5000, 5000");
        dataconnection.configureRetry("max_retries=3, 333, 333, 333");
          goto _L5
    }

    private void createAllApnList() {
        mAllApns = new ArrayList();
        String s = mPhone.mIccRecords.getOperatorNumeric();
        if(s != null) {
            String s1 = (new StringBuilder()).append("numeric = '").append(s).append("'").toString();
            String s2 = (new StringBuilder()).append(s1).append(" and carrier_enabled = 1").toString();
            log((new StringBuilder()).append("createAllApnList: selection=").append(s2).toString());
            Cursor cursor = mPhone.getContext().getContentResolver().query(android.provider.Telephony.Carriers.CONTENT_URI, null, s2, null, null);
            if(cursor != null) {
                if(cursor.getCount() > 0)
                    mAllApns = createApnList(cursor);
                cursor.close();
            }
        }
        if(mAllApns.isEmpty()) {
            log((new StringBuilder()).append("createAllApnList: No APN found for carrier: ").append(s).toString());
            mPreferredApn = null;
        } else {
            mPreferredApn = getPreferredApn();
            if(mPreferredApn != null && !mPreferredApn.numeric.equals(s)) {
                mPreferredApn = null;
                setPreferredApn(-1);
            }
            log((new StringBuilder()).append("createAllApnList: mPreferredApn=").append(mPreferredApn).toString());
        }
        log((new StringBuilder()).append("createAllApnList: X mAllApns=").append(mAllApns).toString());
    }

    private ArrayList createApnList(Cursor cursor) {
        ArrayList arraylist = new ArrayList();
        if(cursor.moveToFirst())
            do {
                String as[] = parseTypes(cursor.getString(cursor.getColumnIndexOrThrow("type")));
                int i = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
                String s = cursor.getString(cursor.getColumnIndexOrThrow("numeric"));
                String s1 = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                String s2 = cursor.getString(cursor.getColumnIndexOrThrow("apn"));
                String s3 = NetworkUtils.trimV4AddrZeros(cursor.getString(cursor.getColumnIndexOrThrow("proxy")));
                String s4 = cursor.getString(cursor.getColumnIndexOrThrow("port"));
                String s5 = NetworkUtils.trimV4AddrZeros(cursor.getString(cursor.getColumnIndexOrThrow("mmsc")));
                String s6 = NetworkUtils.trimV4AddrZeros(cursor.getString(cursor.getColumnIndexOrThrow("mmsproxy")));
                String s7 = cursor.getString(cursor.getColumnIndexOrThrow("mmsport"));
                String s8 = cursor.getString(cursor.getColumnIndexOrThrow("user"));
                String s9 = cursor.getString(cursor.getColumnIndexOrThrow("password"));
                int j = cursor.getInt(cursor.getColumnIndexOrThrow("authtype"));
                String s10 = cursor.getString(cursor.getColumnIndexOrThrow("protocol"));
                String s11 = cursor.getString(cursor.getColumnIndexOrThrow("roaming_protocol"));
                boolean flag;
                if(cursor.getInt(cursor.getColumnIndexOrThrow("carrier_enabled")) == 1)
                    flag = true;
                else
                    flag = false;
                arraylist.add(new ApnSetting(i, s, s1, s2, s3, s4, s5, s6, s7, s8, s9, j, as, s10, s11, flag, cursor.getInt(cursor.getColumnIndexOrThrow("bearer"))));
            } while(cursor.moveToNext());
        log((new StringBuilder()).append("createApnList: X result=").append(arraylist).toString());
        return arraylist;
    }

    private GsmDataConnection createDataConnection() {
        log("createDataConnection E");
        RetryManager retrymanager = new RetryManager();
        int i = mUniqueIdGenerator.getAndIncrement();
        GsmDataConnection gsmdataconnection = GsmDataConnection.makeDataConnection(mPhone, i, retrymanager, this);
        mDataConnections.put(Integer.valueOf(i), gsmdataconnection);
        DataConnectionAc dataconnectionac = new DataConnectionAc(gsmdataconnection, "GSM");
        int j = dataconnectionac.fullyConnectSync(mPhone.getContext(), this, gsmdataconnection.getHandler());
        IntentFilter intentfilter;
        if(j == 0)
            mDataConnectionAsyncChannels.put(Integer.valueOf(dataconnectionac.dataConnection.getDataConnectionId()), dataconnectionac);
        else
            loge((new StringBuilder()).append("createDataConnection: Could not connect to dcac.mDc=").append(dataconnectionac.dataConnection).append(" status=").append(j).toString());
        intentfilter = new IntentFilter();
        intentfilter.addAction((new StringBuilder()).append("com.android.internal.telephony.gprs-reconnect.").append(i).toString());
        mPhone.getContext().registerReceiver(mIntentReceiver, intentfilter, null, mPhone);
        log((new StringBuilder()).append("createDataConnection() X id=").append(i).append(" dc=").append(gsmdataconnection).toString());
        return gsmdataconnection;
    }

    private boolean dataConnectionNotInUse(DataConnectionAc dataconnectionac) {
        Iterator iterator;
        log((new StringBuilder()).append("dataConnectionNotInUse: check if dcac is inuse dc=").append(dataconnectionac.dataConnection).toString());
        iterator = mApnContexts.values().iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        ApnContext apncontext1 = (ApnContext)iterator.next();
        if(apncontext1.getDataConnectionAc() != dataconnectionac) goto _L4; else goto _L3
_L3:
        boolean flag;
        log((new StringBuilder()).append("dataConnectionNotInUse: in use by apnContext=").append(apncontext1).toString());
        flag = false;
_L6:
        return flag;
_L2:
        ApnContext apncontext;
        for(Iterator iterator1 = dataconnectionac.getApnListSync().iterator(); iterator1.hasNext(); dataconnectionac.removeApnContextSync(apncontext)) {
            apncontext = (ApnContext)iterator1.next();
            log((new StringBuilder()).append("dataConnectionNotInUse: removing apnContext=").append(apncontext).toString());
        }

        log("dataConnectionNotInUse: not in use return true");
        flag = true;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private void destroyDataConnections() {
        if(mDataConnections != null) {
            log("destroyDataConnections: clear mDataConnectionList");
            mDataConnections.clear();
        } else {
            log("destroyDataConnections: mDataConnecitonList is empty, ignore");
        }
    }

    private void doRecovery() {
        if(getOverallState() != com.android.internal.telephony.DataConnectionTracker.State.CONNECTED) goto _L2; else goto _L1
_L1:
        int i = getRecoveryAction();
        i;
        JVM INSTR tableswitch 0 4: default 52
    //                   0 80
    //                   1 122
    //                   2 156
    //                   3 193
    //                   4 223;
           goto _L3 _L4 _L5 _L6 _L7 _L8
_L3:
        throw new RuntimeException((new StringBuilder()).append("doRecovery: Invalid recoveryAction=").append(i).toString());
_L4:
        EventLog.writeEvent(50118, mSentSinceLastRecv);
        log("doRecovery() get data call list");
        mPhone.mCM.getDataCallList(obtainMessage(0x42004));
        putRecoveryAction(1);
_L2:
        return;
_L5:
        EventLog.writeEvent(50119, mSentSinceLastRecv);
        log("doRecovery() cleanup all connections");
        cleanUpAllConnections(true, "pdpReset");
        putRecoveryAction(2);
        continue; /* Loop/switch isn't completed */
_L6:
        EventLog.writeEvent(50120, mSentSinceLastRecv);
        log("doRecovery() re-register");
        mPhone.getServiceStateTracker().reRegisterNetwork(null);
        putRecoveryAction(3);
        continue; /* Loop/switch isn't completed */
_L7:
        EventLog.writeEvent(50121, mSentSinceLastRecv);
        log("restarting radio");
        putRecoveryAction(4);
        restartRadio();
        continue; /* Loop/switch isn't completed */
_L8:
        EventLog.writeEvent(50122, -1);
        log("restarting radio with gsm.radioreset to true");
        SystemProperties.set("gsm.radioreset", "true");
        try {
            Thread.sleep(1000L);
        }
        catch(InterruptedException interruptedexception) { }
        restartRadio();
        putRecoveryAction(0);
        if(true) goto _L2; else goto _L9
_L9:
    }

    private List findApnContextToClean(Collection collection) {
        if(collection != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((List) (obj));
_L2:
        log((new StringBuilder()).append("findApnContextToClean(ar): E dcacs=").append(collection).toString());
        obj = new ArrayList();
        Iterator iterator = mApnContexts.values().iterator();
        do {
            if(!iterator.hasNext())
                break;
            ApnContext apncontext = (ApnContext)iterator.next();
            if(apncontext.getState() != com.android.internal.telephony.DataConnectionTracker.State.CONNECTED)
                continue;
            boolean flag = false;
            Iterator iterator1 = collection.iterator();
            do {
                if(!iterator1.hasNext())
                    break;
                if((DataConnectionAc)iterator1.next() != apncontext.getDataConnectionAc())
                    continue;
                flag = true;
                break;
            } while(true);
            if(!flag) {
                log((new StringBuilder()).append("findApnContextToClean(ar): Connected apn not found in the list (").append(apncontext.toString()).append(")").toString());
                if(apncontext.getDataConnectionAc() != null)
                    ((ArrayList) (obj)).addAll(apncontext.getDataConnectionAc().getApnListSync());
                else
                    ((ArrayList) (obj)).add(apncontext);
            }
        } while(true);
        log((new StringBuilder()).append("findApnContextToClean(ar): X list=").append(obj).toString());
        if(true) goto _L4; else goto _L3
_L3:
    }

    private DataConnectionAc findDataConnectionAcByCid(int i) {
        Iterator iterator = mDataConnectionAsyncChannels.values().iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        DataConnectionAc dataconnectionac = (DataConnectionAc)iterator.next();
        if(dataconnectionac.getCidSync() != i) goto _L4; else goto _L3
_L3:
        return dataconnectionac;
_L2:
        dataconnectionac = null;
        if(true) goto _L3; else goto _L5
_L5:
    }

    private GsmDataConnection findFreeDataConnection() {
        Iterator iterator = mDataConnectionAsyncChannels.values().iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        DataConnectionAc dataconnectionac = (DataConnectionAc)iterator.next();
        if(!dataconnectionac.isInactiveSync() || !dataConnectionNotInUse(dataconnectionac)) goto _L4; else goto _L3
_L3:
        GsmDataConnection gsmdataconnection;
        DataConnection dataconnection = dataconnectionac.dataConnection;
        log((new StringBuilder()).append("findFreeDataConnection: found free GsmDataConnection= dcac=").append(dataconnectionac).append(" dc=").append(dataconnection).toString());
        gsmdataconnection = (GsmDataConnection)dataconnection;
_L6:
        return gsmdataconnection;
_L2:
        log("findFreeDataConnection: NO free GsmDataConnection");
        gsmdataconnection = null;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private String getApnType(int i, int j) {
        String s;
        if(i == 1)
            s = apnIdToType(j);
        else
            s = "default";
        return s;
    }

    private int getCellLocationId() {
        int i;
        android.telephony.CellLocation celllocation;
        i = -1;
        celllocation = mPhone.getCellLocation();
        if(celllocation == null) goto _L2; else goto _L1
_L1:
        if(!(celllocation instanceof GsmCellLocation)) goto _L4; else goto _L3
_L3:
        i = ((GsmCellLocation)celllocation).getCid();
_L2:
        return i;
_L4:
        if(celllocation instanceof CdmaCellLocation)
            i = ((CdmaCellLocation)celllocation).getBaseStationId();
        if(true) goto _L2; else goto _L5
_L5:
    }

    private ApnSetting getPreferredApn() {
        ApnSetting apnsetting = null;
        if(!mAllApns.isEmpty()) goto _L2; else goto _L1
_L1:
        log("getPreferredApn: X not found mAllApns.isEmpty");
_L4:
        return apnsetting;
_L2:
        Cursor cursor;
label0:
        {
            ContentResolver contentresolver = mPhone.getContext().getContentResolver();
            Uri uri = PREFERAPN_NO_UPDATE_URI;
            String as[] = new String[3];
            as[0] = "_id";
            as[1] = "name";
            as[2] = "apn";
            cursor = contentresolver.query(uri, as, null, null, "name ASC");
            int i;
            Iterator iterator;
            ApnSetting apnsetting1;
            if(cursor != null)
                canSetPreferApn = true;
            else
                canSetPreferApn = false;
            if(!canSetPreferApn || cursor.getCount() <= 0)
                break label0;
            cursor.moveToFirst();
            i = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
            iterator = mAllApns.iterator();
            do {
                if(!iterator.hasNext())
                    break label0;
                apnsetting1 = (ApnSetting)iterator.next();
            } while(apnsetting1.id != i || !apnsetting1.canHandleType(mRequestedApnType));
            log((new StringBuilder()).append("getPreferredApn: X found apnSetting").append(apnsetting1).toString());
            cursor.close();
            apnsetting = apnsetting1;
            continue; /* Loop/switch isn't completed */
        }
        if(cursor != null)
            cursor.close();
        log("getPreferredApn: X not found");
        if(true) goto _L4; else goto _L3
_L3:
    }

    private boolean isDataAllowed(ApnContext apncontext) {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_2;
        if((mInternalDataEnabled && mUserDataEnabled && sPolicyDataEnabled || "mms".equals(apncontext.getApnType()) && isMmsDataEnabled()) && apncontext.isReady() && isDataAllowed())
            flag = true;
        return flag;
    }

    private void notifyApnIdUpToCurrent(String s, ApnContext apncontext, String s1) {
        _cls2..SwitchMap.com.android.internal.telephony.DataConnectionTracker.State[apncontext.getState().ordinal()];
        JVM INSTR tableswitch 1 6: default 48
    //                   1 64
    //                   2 64
    //                   3 49
    //                   4 48
    //                   5 48
    //                   6 49;
           goto _L1 _L2 _L2 _L3 _L1 _L1 _L3
_L1:
        return;
_L3:
        mPhone.notifyDataConnection(s, s1, com.android.internal.telephony.Phone.DataState.CONNECTING);
        continue; /* Loop/switch isn't completed */
_L2:
        mPhone.notifyDataConnection(s, s1, com.android.internal.telephony.Phone.DataState.CONNECTING);
        mPhone.notifyDataConnection(s, s1, com.android.internal.telephony.Phone.DataState.CONNECTED);
        if(true) goto _L1; else goto _L4
_L4:
    }

    private void notifyDefaultData(ApnContext apncontext) {
        log((new StringBuilder()).append("notifyDefaultData: type=").append(apncontext.getApnType()).append(", reason:").append(apncontext.getReason()).toString());
        apncontext.setState(com.android.internal.telephony.DataConnectionTracker.State.CONNECTED);
        mPhone.notifyDataConnection(apncontext.getReason(), apncontext.getApnType());
        startNetStatPoll();
        startDataStallAlarm(false);
        apncontext.setRetryCount(0);
    }

    private void notifyNoData(com.android.internal.telephony.DataConnection.FailCause failcause, ApnContext apncontext) {
        log((new StringBuilder()).append("notifyNoData: type=").append(apncontext.getApnType()).toString());
        apncontext.setState(com.android.internal.telephony.DataConnectionTracker.State.FAILED);
        if(failcause.isPermanentFail() && !apncontext.getApnType().equals("default"))
            mPhone.notifyDataConnectionFailed(apncontext.getReason(), apncontext.getApnType());
    }

    private void onApnChanged() {
        boolean flag = true;
        com.android.internal.telephony.DataConnectionTracker.State state = getOverallState();
        boolean flag1;
        if(state == com.android.internal.telephony.DataConnectionTracker.State.IDLE || state == com.android.internal.telephony.DataConnectionTracker.State.FAILED)
            flag1 = flag;
        else
            flag1 = false;
        if(mPhone instanceof GSMPhone)
            ((GSMPhone)mPhone).updateCurrentCarrierInProvider();
        log("onApnChanged: createAllApnList and cleanUpAllConnections");
        createAllApnList();
        if(flag1)
            flag = false;
        cleanUpAllConnections(flag, "apnChanged");
        if(flag1)
            setupDataOnReadyApns("apnChanged");
    }

    private void onDataConnectionAttached() {
        log("onDataConnectionAttached");
        if(getOverallState() == com.android.internal.telephony.DataConnectionTracker.State.CONNECTED) {
            log("onDataConnectionAttached: start polling notify attached");
            startNetStatPoll();
            startDataStallAlarm(false);
            notifyDataConnection("dataAttached");
        } else {
            notifyOffApnsOfAvailability("dataAttached");
        }
        setupDataOnReadyApns("dataAttached");
    }

    private void onDataStateChanged(AsyncResult asyncresult) {
        log("onDataStateChanged(ar): E");
        ArrayList arraylist = (ArrayList)(ArrayList)asyncresult.result;
        if(asyncresult.exception != null) {
            log("onDataStateChanged(ar): exception; likely radio not available, ignore");
        } else {
            log((new StringBuilder()).append("onDataStateChanged(ar): DataCallState size=").append(arraylist.size()).toString());
            HashMap hashmap = new HashMap();
            Iterator iterator = arraylist.iterator();
            do {
                if(!iterator.hasNext())
                    break;
                DataCallState datacallstate1 = (DataCallState)iterator.next();
                DataConnectionAc dataconnectionac1 = findDataConnectionAcByCid(datacallstate1.cid);
                if(dataconnectionac1 != null)
                    hashmap.put(datacallstate1, dataconnectionac1);
            } while(true);
            List list = findApnContextToClean(hashmap.values());
            for(Iterator iterator1 = arraylist.iterator(); iterator1.hasNext();) {
                DataCallState datacallstate = (DataCallState)iterator1.next();
                DataConnectionAc dataconnectionac = (DataConnectionAc)hashmap.get(datacallstate);
                if(dataconnectionac == null) {
                    loge("onDataStateChanged(ar): No associated DataConnection ignore");
                } else {
                    Collection collection = dataconnectionac.getApnListSync();
                    ArrayList arraylist1 = new ArrayList();
                    Iterator iterator3 = collection.iterator();
                    do {
                        if(!iterator3.hasNext())
                            break;
                        ApnContext apncontext1 = (ApnContext)iterator3.next();
                        if(apncontext1.getState() == com.android.internal.telephony.DataConnectionTracker.State.CONNECTED || apncontext1.getState() == com.android.internal.telephony.DataConnectionTracker.State.CONNECTING || apncontext1.getState() == com.android.internal.telephony.DataConnectionTracker.State.INITING)
                            arraylist1.add(apncontext1);
                    } while(true);
                    if(arraylist1.size() == 0) {
                        log("onDataStateChanged(ar): no connected apns");
                    } else {
                        log((new StringBuilder()).append("onDataStateChanged(ar): Found ConnId=").append(datacallstate.cid).append(" newState=").append(datacallstate.toString()).toString());
                        if(datacallstate.active == 0) {
                            log((new StringBuilder()).append("onDataStateChanged(ar): inactive, cleanup apns=").append(arraylist1).toString());
                            list.addAll(arraylist1);
                        } else {
                            com.android.internal.telephony.DataConnection.UpdateLinkPropertyResult updatelinkpropertyresult = dataconnectionac.updateLinkPropertiesDataCallStateSync(datacallstate);
                            if(updatelinkpropertyresult.oldLp.equals(updatelinkpropertyresult.newLp))
                                log("onDataStateChanged(ar): no change");
                            else
                            if(updatelinkpropertyresult.oldLp.isIdenticalInterfaceName(updatelinkpropertyresult.newLp)) {
                                if(!updatelinkpropertyresult.oldLp.isIdenticalDnses(updatelinkpropertyresult.newLp) || !updatelinkpropertyresult.oldLp.isIdenticalRoutes(updatelinkpropertyresult.newLp) || !updatelinkpropertyresult.oldLp.isIdenticalHttpProxy(updatelinkpropertyresult.newLp) || !updatelinkpropertyresult.oldLp.isIdenticalAddresses(updatelinkpropertyresult.newLp)) {
                                    android.net.LinkProperties.CompareResult compareresult = updatelinkpropertyresult.oldLp.compareAddresses(updatelinkpropertyresult.newLp);
                                    log((new StringBuilder()).append("onDataStateChanged: oldLp=").append(updatelinkpropertyresult.oldLp).append(" newLp=").append(updatelinkpropertyresult.newLp).append(" car=").append(compareresult).toString());
                                    boolean flag = false;
                                    Iterator iterator4 = compareresult.added.iterator();
label0:
                                    do {
                                        if(!iterator4.hasNext())
                                            break;
                                        LinkAddress linkaddress = (LinkAddress)iterator4.next();
                                        Iterator iterator6 = compareresult.removed.iterator();
                                        do
                                            if(!iterator6.hasNext())
                                                continue label0;
                                        while(!NetworkUtils.addressTypeMatches(((LinkAddress)iterator6.next()).getAddress(), linkaddress.getAddress()));
                                        flag = true;
                                    } while(true);
                                    if(flag) {
                                        log((new StringBuilder()).append("onDataStateChanged(ar): addr change, cleanup apns=").append(arraylist1).append(" oldLp=").append(updatelinkpropertyresult.oldLp).append(" newLp=").append(updatelinkpropertyresult.newLp).toString());
                                        list.addAll(arraylist1);
                                    } else {
                                        log("onDataStateChanged(ar): simple change");
                                        Iterator iterator5 = arraylist1.iterator();
                                        while(iterator5.hasNext())  {
                                            ApnContext apncontext = (ApnContext)iterator5.next();
                                            mPhone.notifyDataConnection("linkPropertiesChanged", apncontext.getApnType());
                                        }
                                    }
                                } else {
                                    log("onDataStateChanged(ar): no changes");
                                }
                            } else {
                                log((new StringBuilder()).append("onDataStateChanged(ar): interface change, cleanup apns=").append(arraylist1).toString());
                                list.addAll(arraylist1);
                            }
                        }
                    }
                }
            }

            if(list.size() != 0) {
                int i = getCellLocationId();
                Object aobj[] = new Object[2];
                aobj[0] = Integer.valueOf(i);
                aobj[1] = Integer.valueOf(TelephonyManager.getDefault().getNetworkType());
                EventLog.writeEvent(50109, aobj);
            }
            log((new StringBuilder()).append("onDataStateChange(ar): apnsToCleanup=").append(list).toString());
            for(Iterator iterator2 = list.iterator(); iterator2.hasNext(); cleanUpConnection(true, (ApnContext)iterator2.next()));
            log("onDataStateChanged(ar): X");
        }
    }

    private void onRecordsLoaded() {
        log("onRecordsLoaded: createAllApnList");
        createAllApnList();
        if(mPhone.mCM.getRadioState().isOn()) {
            log("onRecordsLoaded: notifying data availability");
            notifyOffApnsOfAvailability("simLoaded");
        }
        setupDataOnReadyApns("simLoaded");
    }

    private String[] parseTypes(String s) {
        String as[];
        if(s == null || s.equals("")) {
            as = new String[1];
            as[0] = "*";
        } else {
            as = s.split(",");
        }
        return as;
    }

    private void reconnectAfterFail(com.android.internal.telephony.DataConnection.FailCause failcause, ApnContext apncontext, int i) {
        if(apncontext != null) goto _L2; else goto _L1
_L1:
        loge("reconnectAfterFail: apnContext == null, impossible");
_L4:
        return;
_L2:
label0:
        {
            log((new StringBuilder()).append("reconnectAfterFail: lastFailCause=").append(failcause).append(" retryOverride=").append(i).append(" apnContext=").append(apncontext).toString());
            if(apncontext.getState() != com.android.internal.telephony.DataConnectionTracker.State.FAILED || apncontext.getDataConnection() == null)
                continue; /* Loop/switch isn't completed */
            if(!apncontext.getDataConnection().isRetryNeeded()) {
                if(!apncontext.getApnType().equals("default")) {
                    mPhone.notifyDataConnection("apnFailed", apncontext.getApnType());
                    continue; /* Loop/switch isn't completed */
                }
                if(!mReregisterOnReconnectFailure)
                    break label0;
                apncontext.getDataConnection().retryForeverUsingLastTimeout();
            }
            int j = i;
            if(j < 0) {
                j = apncontext.getDataConnection().getRetryTimer();
                apncontext.getDataConnection().increaseRetryCount();
                log((new StringBuilder()).append("reconnectAfterFail: increaseRetryCount=").append(apncontext.getDataConnection().getRetryCount()).append(" nextReconnectDelay=").append(j).toString());
            }
            startAlarmForReconnect(j, apncontext);
            if(!shouldPostNotification(failcause))
                log("reconnectAfterFail: NOT Posting GPRS Unavailable notification -- likely transient error");
            else
                notifyNoData(failcause, apncontext);
            continue; /* Loop/switch isn't completed */
        }
        log("reconnectAfterFail: activate failed, Reregistering to network");
        mReregisterOnReconnectFailure = true;
        mPhone.getServiceStateTracker().reRegisterNetwork(null);
        apncontext.setRetryCount(0);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void resetPollStats() {
        mTxPkts = -1L;
        mRxPkts = -1L;
        mNetStatPollPeriod = 1000;
    }

    private boolean retryAfterDisconnected(String s) {
        boolean flag = true;
        if("radioTurnedOff".equals(s))
            flag = false;
        return flag;
    }

    private void setPreferredApn(int i) {
        if(canSetPreferApn) goto _L2; else goto _L1
_L1:
        log("setPreferredApn: X !canSEtPreferApn");
_L4:
        return;
_L2:
        log("setPreferredApn: delete");
        ContentResolver contentresolver = mPhone.getContext().getContentResolver();
        contentresolver.delete(PREFERAPN_NO_UPDATE_URI, null, null);
        if(i >= 0) {
            log("setPreferredApn: insert");
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("apn_id", Integer.valueOf(i));
            contentresolver.insert(PREFERAPN_NO_UPDATE_URI, contentvalues);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private boolean setupData(ApnContext apncontext) {
        boolean flag;
        int i;
        ApnSetting apnsetting;
        flag = false;
        log((new StringBuilder()).append("setupData: apnContext=").append(apncontext).toString());
        i = getApnProfileID(apncontext.getApnType());
        apnsetting = apncontext.getNextWaitingApn();
        if(apnsetting != null) goto _L2; else goto _L1
_L1:
        log("setupData: return for no apn found!");
_L4:
        return flag;
_L2:
        GsmDataConnection gsmdataconnection = (GsmDataConnection)checkForConnectionForApnContext(apncontext);
        if(gsmdataconnection == null) {
            gsmdataconnection = findReadyDataConnection(apnsetting);
            if(gsmdataconnection == null) {
                log("setupData: No ready GsmDataConnection found!");
                gsmdataconnection = findFreeDataConnection();
            }
            if(gsmdataconnection == null)
                gsmdataconnection = createDataConnection();
            if(gsmdataconnection == null) {
                log("setupData: No free GsmDataConnection found!");
                continue; /* Loop/switch isn't completed */
            }
        } else {
            apnsetting = ((DataConnectionAc)mDataConnectionAsyncChannels.get(Integer.valueOf(gsmdataconnection.getDataConnectionId()))).getApnSettingSync();
        }
        DataConnectionAc dataconnectionac = (DataConnectionAc)mDataConnectionAsyncChannels.get(Integer.valueOf(gsmdataconnection.getDataConnectionId()));
        gsmdataconnection.setProfileId(i);
        int j = dataconnectionac.getRefCountSync();
        log((new StringBuilder()).append("setupData: init dc and apnContext refCount=").append(j).toString());
        if(j == 0)
            configureRetry(gsmdataconnection, apnsetting.canHandleType("default"), apncontext.getRetryCount());
        apncontext.setDataConnectionAc(dataconnectionac);
        apncontext.setDataConnection(gsmdataconnection);
        apncontext.setApnSetting(apnsetting);
        apncontext.setState(com.android.internal.telephony.DataConnectionTracker.State.INITING);
        mPhone.notifyDataConnection(apncontext.getReason(), apncontext.getApnType());
        if(apncontext.getDataConnectionAc().getReconnectIntentSync() != null) {
            log("setupData: data reconnection pending");
            apncontext.setState(com.android.internal.telephony.DataConnectionTracker.State.FAILED);
            mPhone.notifyDataConnection(apncontext.getReason(), apncontext.getApnType());
            flag = true;
        } else {
            Message message = obtainMessage();
            message.what = 0x42000;
            message.obj = apncontext;
            gsmdataconnection.bringUp(message, apnsetting);
            log("setupData: initing!");
            flag = true;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void setupDataOnReadyApns(String s) {
        Iterator iterator = mDataConnectionAsyncChannels.values().iterator();
        do {
            if(!iterator.hasNext())
                break;
            DataConnectionAc dataconnectionac = (DataConnectionAc)iterator.next();
            if(dataconnectionac.getReconnectIntentSync() != null)
                cancelReconnectAlarm(dataconnectionac);
            if(dataconnectionac.dataConnection == null)
                continue;
            Collection collection = dataconnectionac.getApnListSync();
            boolean flag = false;
            Iterator iterator2 = collection.iterator();
            do {
                if(!iterator2.hasNext())
                    break;
                if(!((ApnContext)iterator2.next()).getApnType().equals("default"))
                    continue;
                flag = true;
                break;
            } while(true);
            configureRetry(dataconnectionac.dataConnection, flag, 0);
        } while(true);
        resetAllRetryCounts();
        Iterator iterator1 = mApnContexts.values().iterator();
        do {
            if(!iterator1.hasNext())
                break;
            ApnContext apncontext = (ApnContext)iterator1.next();
            if(apncontext.getState() == com.android.internal.telephony.DataConnectionTracker.State.FAILED)
                apncontext.setState(com.android.internal.telephony.DataConnectionTracker.State.IDLE);
            if(apncontext.isReady() && apncontext.getState() == com.android.internal.telephony.DataConnectionTracker.State.IDLE) {
                apncontext.setReason(s);
                trySetupData(apncontext);
            }
        } while(true);
    }

    private boolean shouldPostNotification(com.android.internal.telephony.DataConnection.FailCause failcause) {
        boolean flag;
        if(failcause != com.android.internal.telephony.DataConnection.FailCause.UNKNOWN)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private void startAlarmForReconnect(int i, ApnContext apncontext) {
        DataConnectionAc dataconnectionac = apncontext.getDataConnectionAc();
        if(dataconnectionac == null || dataconnectionac.dataConnection == null) {
            loge("startAlarmForReconnect: null dcac or dc.");
        } else {
            AlarmManager alarmmanager = (AlarmManager)mPhone.getContext().getSystemService("alarm");
            Intent intent = new Intent((new StringBuilder()).append("com.android.internal.telephony.gprs-reconnect.").append(dataconnectionac.dataConnection.getDataConnectionId()).toString());
            String s = apncontext.getReason();
            intent.putExtra("reconnect_alarm_extra_reason", s);
            int j = dataconnectionac.dataConnection.getDataConnectionId();
            intent.putExtra("reconnect_alarm_extra_type", j);
            int k = dataconnectionac.dataConnection.getRetryCount();
            intent.putExtra("reconnect_alaram_extra_retry_count", k);
            log((new StringBuilder()).append("startAlarmForReconnect: next attempt in ").append(i / 1000).append("s").append(" reason='").append(s).append("' connectionId=").append(j).append(" retryCount=").append(k).toString());
            PendingIntent pendingintent = PendingIntent.getBroadcast(mPhone.getContext(), 0, intent, 0x8000000);
            dataconnectionac.setReconnectIntentSync(pendingintent);
            alarmmanager.set(2, SystemClock.elapsedRealtime() + (long)i, pendingintent);
        }
    }

    private void startDataStallAlarm(boolean flag) {
        int i = getRecoveryAction();
        int j;
        AlarmManager alarmmanager;
        Intent intent;
        if(mIsScreenOn || flag || RecoveryAction.isAggressiveRecovery(i))
            j = android.provider.Settings.Secure.getInt(mResolver, "data_stall_alarm_aggressive_delay_in_ms", 60000);
        else
            j = android.provider.Settings.Secure.getInt(mResolver, "data_stall_alarm_non_aggressive_delay_in_ms", 0x57e40);
        mDataStallAlarmTag = 1 + mDataStallAlarmTag;
        alarmmanager = (AlarmManager)mPhone.getContext().getSystemService("alarm");
        intent = new Intent("com.android.internal.telephony.gprs-data-stall");
        intent.putExtra("data.stall.alram.tag", mDataStallAlarmTag);
        mDataStallAlarmIntent = PendingIntent.getBroadcast(mPhone.getContext(), 0, intent, 0x8000000);
        alarmmanager.set(2, SystemClock.elapsedRealtime() + (long)j, mDataStallAlarmIntent);
    }

    private void startDelayedRetry(com.android.internal.telephony.DataConnection.FailCause failcause, ApnContext apncontext, int i) {
        notifyNoData(failcause, apncontext);
        reconnectAfterFail(failcause, apncontext, i);
    }

    private void stopDataStallAlarm() {
        AlarmManager alarmmanager = (AlarmManager)mPhone.getContext().getSystemService("alarm");
        mDataStallAlarmTag = 1 + mDataStallAlarmTag;
        if(mDataStallAlarmIntent != null) {
            alarmmanager.cancel(mDataStallAlarmIntent);
            mDataStallAlarmIntent = null;
        }
    }

    private boolean trySetupData(ApnContext apncontext) {
        boolean flag;
        flag = false;
        log((new StringBuilder()).append("trySetupData for type:").append(apncontext.getApnType()).append(" due to ").append(apncontext.getReason()).toString());
        log((new StringBuilder()).append("trySetupData with mIsPsRestricted=").append(mIsPsRestricted).toString());
        if(mPhone.getSimulatedRadioControl() == null) goto _L2; else goto _L1
_L1:
        apncontext.setState(com.android.internal.telephony.DataConnectionTracker.State.CONNECTED);
        mPhone.notifyDataConnection(apncontext.getReason(), apncontext.getApnType());
        log("trySetupData: (fix?) We're on the simulator; assuming data is connected");
        flag = true;
_L4:
        return flag;
_L2:
        mPhone.getServiceStateTracker().getDesiredPowerState();
        if((apncontext.getState() == com.android.internal.telephony.DataConnectionTracker.State.IDLE || apncontext.getState() == com.android.internal.telephony.DataConnectionTracker.State.SCANNING) && isDataAllowed(apncontext) && getAnyDataEnabled() && !isEmergency()) {
            if(apncontext.getState() == com.android.internal.telephony.DataConnectionTracker.State.IDLE) {
                ArrayList arraylist = buildWaitingApns(apncontext.getApnType());
                if(arraylist.isEmpty()) {
                    log("trySetupData: No APN found");
                    notifyNoData(com.android.internal.telephony.DataConnection.FailCause.MISSING_UNKNOWN_APN, apncontext);
                    notifyOffApnsOfAvailability(apncontext.getReason());
                    continue; /* Loop/switch isn't completed */
                }
                apncontext.setWaitingApns(arraylist);
                log((new StringBuilder()).append("trySetupData: Create from mAllApns : ").append(apnListToString(mAllApns)).toString());
            }
            log((new StringBuilder()).append("Setup watingApns : ").append(apnListToString(apncontext.getWaitingApns())).toString());
            flag = setupData(apncontext);
            notifyOffApnsOfAvailability(apncontext.getReason());
        } else {
            if(!apncontext.getApnType().equals("default") && (apncontext.getState() == com.android.internal.telephony.DataConnectionTracker.State.IDLE || apncontext.getState() == com.android.internal.telephony.DataConnectionTracker.State.SCANNING))
                mPhone.notifyDataConnectionFailed(apncontext.getReason(), apncontext.getApnType());
            notifyOffApnsOfAvailability(apncontext.getReason());
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private boolean trySetupData(String s, String s1) {
        StringBuilder stringbuilder = (new StringBuilder()).append("trySetupData: ").append(s1).append(" due to ");
        String s2;
        ApnContext apncontext;
        if(s == null)
            s2 = "(unspecified)";
        else
            s2 = s;
        log(stringbuilder.append(s2).append(" isPsRestricted=").append(mIsPsRestricted).toString());
        if(s1 == null)
            s1 = "default";
        apncontext = (ApnContext)mApnContexts.get(s1);
        if(apncontext == null) {
            log((new StringBuilder()).append("trySetupData new apn context for type:").append(s1).toString());
            apncontext = new ApnContext(s1, "GSM");
            mApnContexts.put(s1, apncontext);
        }
        apncontext.setReason(s);
        return trySetupData(apncontext);
    }

    private void updateDataActivity() {
        com.android.internal.telephony.DataConnectionTracker.TxRxSum txrxsum = new com.android.internal.telephony.DataConnectionTracker.TxRxSum(this, mTxPkts, mRxPkts);
        com.android.internal.telephony.DataConnectionTracker.TxRxSum txrxsum1 = new com.android.internal.telephony.DataConnectionTracker.TxRxSum(this);
        txrxsum1.updateTxRxSum();
        mTxPkts = txrxsum1.txPkts;
        mRxPkts = txrxsum1.rxPkts;
        if(mNetStatPollEnabled && (txrxsum.txPkts > 0L || txrxsum.rxPkts > 0L)) {
            long l = mTxPkts - txrxsum.txPkts;
            long l1 = mRxPkts - txrxsum.rxPkts;
            com.android.internal.telephony.DataConnectionTracker.Activity activity;
            if(l > 0L && l1 > 0L)
                activity = com.android.internal.telephony.DataConnectionTracker.Activity.DATAINANDOUT;
            else
            if(l > 0L && l1 == 0L)
                activity = com.android.internal.telephony.DataConnectionTracker.Activity.DATAOUT;
            else
            if(l == 0L && l1 > 0L)
                activity = com.android.internal.telephony.DataConnectionTracker.Activity.DATAIN;
            else
                activity = com.android.internal.telephony.DataConnectionTracker.Activity.NONE;
            if(mActivity != activity && mIsScreenOn) {
                mActivity = activity;
                mPhone.notifyDataActivity();
            }
        }
    }

    private void updateDataStallInfo() {
        long l;
        long l1;
        com.android.internal.telephony.DataConnectionTracker.TxRxSum txrxsum = new com.android.internal.telephony.DataConnectionTracker.TxRxSum(this, mDataStallTxRxSum);
        mDataStallTxRxSum.updateTxRxSum();
        l = mDataStallTxRxSum.txPkts - txrxsum.txPkts;
        l1 = mDataStallTxRxSum.rxPkts - txrxsum.rxPkts;
        if(l <= 0L || l1 <= 0L) goto _L2; else goto _L1
_L1:
        mSentSinceLastRecv = 0L;
        putRecoveryAction(0);
_L4:
        return;
_L2:
        if(l > 0L && l1 == 0L) {
            if(mPhone.getState() == com.android.internal.telephony.Phone.State.IDLE)
                mSentSinceLastRecv = l + mSentSinceLastRecv;
            else
                mSentSinceLastRecv = 0L;
            log((new StringBuilder()).append("updateDataStallInfo: OUT sent=").append(l).append(" mSentSinceLastRecv=").append(mSentSinceLastRecv).toString());
        } else
        if(l == 0L && l1 > 0L) {
            mSentSinceLastRecv = 0L;
            putRecoveryAction(0);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected void cleanUpAllConnections(boolean flag, String s) {
        log((new StringBuilder()).append("cleanUpAllConnections: tearDown=").append(flag).append(" reason=").append(s).toString());
        ApnContext apncontext;
        for(Iterator iterator = mApnContexts.values().iterator(); iterator.hasNext(); cleanUpConnection(flag, apncontext)) {
            apncontext = (ApnContext)iterator.next();
            apncontext.setReason(s);
        }

        stopNetStatPoll();
        stopDataStallAlarm();
        mRequestedApnType = "default";
    }

    /**
     * @deprecated Method disableApnType is deprecated
     */

    public int disableApnType(String s) {
        this;
        JVM INSTR monitorenter ;
        ApnContext apncontext;
        log((new StringBuilder()).append("disableApnType:").append(s).toString());
        apncontext = (ApnContext)mApnContexts.get(s);
        if(apncontext == null) goto _L2; else goto _L1
_L1:
        setEnabled(apnTypeToId(s), false);
        if(apncontext.getState() == com.android.internal.telephony.DataConnectionTracker.State.IDLE || apncontext.getState() == com.android.internal.telephony.DataConnectionTracker.State.FAILED) goto _L4; else goto _L3
_L3:
        log("diableApnType: return APN_REQUEST_STARTED");
        int i = 1;
_L6:
        this;
        JVM INSTR monitorexit ;
        return i;
_L4:
        log("disableApnType: return APN_ALREADY_INACTIVE");
        i = 4;
        continue; /* Loop/switch isn't completed */
_L2:
        log("disableApnType: no apn context was found, return APN_REQUEST_FAILED");
        i = 3;
        if(true) goto _L6; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }

    public void dispose() {
        log("GsmDCT.dispose");
        cleanUpAllConnections(false, null);
        super.dispose();
        mPhone.mCM.unregisterForAvailable(this);
        mPhone.mCM.unregisterForOffOrNotAvailable(this);
        mPhone.mIccRecords.unregisterForRecordsLoaded(this);
        mPhone.mCM.unregisterForDataNetworkStateChanged(this);
        mPhone.getCallTracker().unregisterForVoiceCallEnded(this);
        mPhone.getCallTracker().unregisterForVoiceCallStarted(this);
        mPhone.getServiceStateTracker().unregisterForDataConnectionAttached(this);
        mPhone.getServiceStateTracker().unregisterForDataConnectionDetached(this);
        mPhone.getServiceStateTracker().unregisterForRoamingOn(this);
        mPhone.getServiceStateTracker().unregisterForRoamingOff(this);
        mPhone.getServiceStateTracker().unregisterForPsRestrictedEnabled(this);
        mPhone.getServiceStateTracker().unregisterForPsRestrictedDisabled(this);
        mPhone.getContext().getContentResolver().unregisterContentObserver(mApnObserver);
        mApnContexts.clear();
        destroyDataConnections();
    }

    public void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        printwriter.println("GsmDataConnectionTracker extends:");
        super.dump(filedescriptor, printwriter, as);
        printwriter.println(" RADIO_TESTS=false");
        printwriter.println((new StringBuilder()).append(" mReregisterOnReconnectFailure=").append(mReregisterOnReconnectFailure).toString());
        printwriter.println((new StringBuilder()).append(" mResolver=").append(mResolver).toString());
        printwriter.println((new StringBuilder()).append(" canSetPreferApn=").append(canSetPreferApn).toString());
        printwriter.println((new StringBuilder()).append(" mApnObserver=").append(mApnObserver).toString());
        printwriter.println((new StringBuilder()).append(" getOverallState=").append(getOverallState()).toString());
    }

    /**
     * @deprecated Method enableApnType is deprecated
     */

    public int enableApnType(String s) {
        byte byte0 = 1;
        this;
        JVM INSTR monitorenter ;
        ApnContext apncontext = (ApnContext)mApnContexts.get(s);
        if(apncontext != null && isApnTypeAvailable(s)) goto _L2; else goto _L1
_L1:
        log((new StringBuilder()).append("enableApnType: ").append(s).append(" is type not available").toString());
        byte0 = 2;
_L4:
        this;
        JVM INSTR monitorexit ;
        return byte0;
_L2:
        log((new StringBuilder()).append("enableApnType: ").append(s).append(" mState(").append(apncontext.getState()).append(")").toString());
        if(apncontext.getState() == com.android.internal.telephony.DataConnectionTracker.State.CONNECTED) {
            log("enableApnType: return APN_ALREADY_ACTIVE");
            byte0 = 0;
        } else {
            setEnabled(apnTypeToId(s), true);
            log((new StringBuilder()).append("enableApnType: new apn request for type ").append(s).append(" return APN_REQUEST_STARTED").toString());
        }
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    protected void finalize() {
        log("finalize");
    }

    protected GsmDataConnection findReadyDataConnection(ApnSetting apnsetting) {
        GsmDataConnection gsmdataconnection = null;
        if(apnsetting != null) goto _L2; else goto _L1
_L1:
        return gsmdataconnection;
_L2:
        log((new StringBuilder()).append("findReadyDataConnection: apn string <").append(apnsetting).append(">").append(" dcacs.size=").append(mDataConnectionAsyncChannels.size()).toString());
        Iterator iterator = mDataConnectionAsyncChannels.values().iterator();
        do {
            if(!iterator.hasNext())
                continue; /* Loop/switch isn't completed */
            DataConnectionAc dataconnectionac = (DataConnectionAc)iterator.next();
            ApnSetting apnsetting1 = dataconnectionac.getApnSettingSync();
            StringBuilder stringbuilder = (new StringBuilder()).append("findReadyDataConnection: dc apn string <");
            String s;
            DataConnection dataconnection;
            if(apnsetting1 != null)
                s = apnsetting1.toString();
            else
                s = "null";
            log(stringbuilder.append(s).append(">").toString());
        } while(apnsetting1 == null || !TextUtils.equals(apnsetting1.toString(), apnsetting.toString()));
        dataconnection = dataconnectionac.dataConnection;
        log((new StringBuilder()).append("findReadyDataConnection: found ready GsmDataConnection= dcac=").append(dataconnectionac).append(" dc=").append(dataconnection).toString());
        gsmdataconnection = (GsmDataConnection)dataconnection;
        if(true) goto _L1; else goto _L3
_L3:
    }

    protected String getActionIntentDataStallAlarm() {
        return "com.android.internal.telephony.gprs-data-stall";
    }

    protected String getActionIntentReconnectAlarm() {
        return "com.android.internal.telephony.gprs-reconnect";
    }

    public String getActiveApnString(String s) {
        ApnContext apncontext;
        log((new StringBuilder()).append("get active apn string for type:").append(s).toString());
        apncontext = (ApnContext)mApnContexts.get(s);
        if(apncontext == null) goto _L2; else goto _L1
_L1:
        ApnSetting apnsetting = apncontext.getApnSetting();
        if(apnsetting == null) goto _L2; else goto _L3
_L3:
        String s1 = apnsetting.apn;
_L5:
        return s1;
_L2:
        s1 = null;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public String[] getActiveApnTypes() {
        log("get all active apn types");
        ArrayList arraylist = new ArrayList();
        Iterator iterator = mApnContexts.values().iterator();
        do {
            if(!iterator.hasNext())
                break;
            ApnContext apncontext = (ApnContext)iterator.next();
            if(apncontext.isReady())
                arraylist.add(apncontext.getApnType());
        } while(true);
        return (String[])(String[])arraylist.toArray(new String[0]);
    }

    public boolean getAnyDataEnabled() {
        boolean flag = false;
        Object obj = mDataEnabledLock;
        obj;
        JVM INSTR monitorenter ;
        if(isMmsDataEnabled() || mInternalDataEnabled && mUserDataEnabled && sPolicyDataEnabled) goto _L2; else goto _L1
_L2:
        Iterator iterator = mApnContexts.values().iterator();
_L6:
        if(!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        if(!isDataAllowed((ApnContext)iterator.next())) goto _L6; else goto _L5
_L5:
        flag = true;
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L4:
        obj;
        JVM INSTR monitorexit ;
_L1:
        return flag;
    }

    protected int getApnProfileID(String s) {
        byte byte0;
        if(TextUtils.equals(s, "ims"))
            byte0 = 2;
        else
        if(TextUtils.equals(s, "fota"))
            byte0 = 3;
        else
        if(TextUtils.equals(s, "cbs"))
            byte0 = 4;
        else
            byte0 = 0;
        return byte0;
    }

    protected LinkCapabilities getLinkCapabilities(String s) {
        ApnContext apncontext = (ApnContext)mApnContexts.get(s);
        if(apncontext == null) goto _L2; else goto _L1
_L1:
        DataConnectionAc dataconnectionac = apncontext.getDataConnectionAc();
        if(dataconnectionac == null) goto _L2; else goto _L3
_L3:
        LinkCapabilities linkcapabilities;
        log((new StringBuilder()).append("get active pdp is not null, return link Capabilities for ").append(s).toString());
        linkcapabilities = dataconnectionac.getLinkCapabilitiesSync();
_L5:
        return linkcapabilities;
_L2:
        log("return new LinkCapabilities");
        linkcapabilities = new LinkCapabilities();
        if(true) goto _L5; else goto _L4
_L4:
    }

    protected LinkProperties getLinkProperties(String s) {
        ApnContext apncontext = (ApnContext)mApnContexts.get(s);
        if(apncontext == null) goto _L2; else goto _L1
_L1:
        DataConnectionAc dataconnectionac = apncontext.getDataConnectionAc();
        if(dataconnectionac == null) goto _L2; else goto _L3
_L3:
        LinkProperties linkproperties;
        log((new StringBuilder()).append("return link properites for ").append(s).toString());
        linkproperties = dataconnectionac.getLinkPropertiesSync();
_L5:
        return linkproperties;
_L2:
        log("return new LinkProperties");
        linkproperties = new LinkProperties();
        if(true) goto _L5; else goto _L4
_L4:
    }

    public com.android.internal.telephony.DataConnectionTracker.State getOverallState() {
        boolean flag;
        boolean flag1;
        boolean flag2;
        Iterator iterator;
        flag = false;
        flag1 = true;
        flag2 = false;
        iterator = mApnContexts.values().iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        ApnContext apncontext = (ApnContext)iterator.next();
        if(!apncontext.isEnabled()) goto _L4; else goto _L3
_L3:
        flag2 = true;
        _cls2..SwitchMap.com.android.internal.telephony.DataConnectionTracker.State[apncontext.getState().ordinal()];
        JVM INSTR tableswitch 1 6: default 104
    //                   1 107
    //                   2 107
    //                   3 122
    //                   4 122
    //                   5 129
    //                   6 129;
           goto _L4 _L5 _L5 _L6 _L6 _L7 _L7
_L5:
        com.android.internal.telephony.DataConnectionTracker.State state;
        log("overall state is CONNECTED");
        state = com.android.internal.telephony.DataConnectionTracker.State.CONNECTED;
_L8:
        return state;
_L6:
        flag = true;
        flag1 = false;
          goto _L4
_L7:
        flag1 = false;
          goto _L4
_L2:
        if(!flag2) {
            log("overall state is IDLE");
            state = com.android.internal.telephony.DataConnectionTracker.State.IDLE;
        } else
        if(flag) {
            log("overall state is CONNECTING");
            state = com.android.internal.telephony.DataConnectionTracker.State.CONNECTING;
        } else
        if(!flag1) {
            log("overall state is IDLE");
            state = com.android.internal.telephony.DataConnectionTracker.State.IDLE;
        } else {
            log("overall state is FAILED");
            state = com.android.internal.telephony.DataConnectionTracker.State.FAILED;
        }
          goto _L8
    }

    public int getRecoveryAction() {
        return android.provider.Settings.System.getInt(mPhone.getContext().getContentResolver(), "radio.data.stall.recovery.action", 0);
    }

    public com.android.internal.telephony.DataConnectionTracker.State getState(String s) {
        ApnContext apncontext = (ApnContext)mApnContexts.get(s);
        com.android.internal.telephony.DataConnectionTracker.State state;
        if(apncontext != null)
            state = apncontext.getState();
        else
            state = com.android.internal.telephony.DataConnectionTracker.State.FAILED;
        return state;
    }

    protected void gotoIdleAndNotifyDataConnection(String s) {
        log((new StringBuilder()).append("gotoIdleAndNotifyDataConnection: reason=").append(s).toString());
        notifyDataConnection(s);
        mActiveApn = null;
    }

    public void handleMessage(Message message) {
        boolean flag;
        flag = false;
        log((new StringBuilder()).append("handleMessage msg=").append(message).toString());
        if(mPhone.mIsTheCurrentActivePhone && !mIsDisposed) goto _L2; else goto _L1
_L1:
        loge("handleMessage: Ignore GSM msgs since GSM phone is inactive");
_L4:
        return;
_L2:
        switch(message.what) {
        case 270342: 
        case 270343: 
        case 270344: 
        case 270346: 
        case 270347: 
        case 270348: 
        case 270349: 
        case 270350: 
        case 270351: 
        case 270353: 
        case 270356: 
        case 270357: 
        default:
            super.handleMessage(message);
            break;

        case 270338: 
            onRecordsLoaded();
            break;

        case 270345: 
            onDataConnectionDetached();
            break;

        case 270352: 
            onDataConnectionAttached();
            break;

        case 270340: 
            onDataStateChanged((AsyncResult)message.obj);
            break;

        case 270341: 
            onPollPdp();
            break;

        case 270354: 
            doRecovery();
            break;

        case 270355: 
            onApnChanged();
            break;

        case 270358: 
            log((new StringBuilder()).append("EVENT_PS_RESTRICT_ENABLED ").append(mIsPsRestricted).toString());
            stopNetStatPoll();
            stopDataStallAlarm();
            mIsPsRestricted = true;
            break;

        case 270359: 
            log((new StringBuilder()).append("EVENT_PS_RESTRICT_DISABLED ").append(mIsPsRestricted).toString());
            mIsPsRestricted = false;
            if(isConnected()) {
                startNetStatPoll();
                startDataStallAlarm(false);
            } else {
                if(mState == com.android.internal.telephony.DataConnectionTracker.State.FAILED) {
                    cleanUpAllConnections(false, "psRestrictEnabled");
                    resetAllRetryCounts();
                    mReregisterOnReconnectFailure = false;
                }
                trySetupData("psRestrictEnabled", "default");
            }
            break;

        case 270339: 
            if(message.obj instanceof ApnContext)
                onTrySetupData((ApnContext)message.obj);
            else
            if(message.obj instanceof String)
                onTrySetupData((String)message.obj);
            else
                loge("EVENT_TRY_SETUP request w/o apnContext or String");
            break;

        case 270360: 
            if(message.arg1 != 0)
                flag = true;
            log((new StringBuilder()).append("EVENT_CLEAN_UP_CONNECTION tearDown=").append(flag).toString());
            if(message.obj instanceof ApnContext)
                cleanUpConnection(flag, (ApnContext)message.obj);
            else
                loge("EVENT_CLEAN_UP_CONNECTION request w/o apn context");
            break;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected void initApnContextsAndDataConnection() {
        boolean flag;
        String as[];
        int i;
        int j;
        flag = SystemProperties.getBoolean("net.def_data_on_boot", true);
        as = mPhone.getContext().getResources().getStringArray(0x1070013);
        i = as.length;
        j = 0;
_L12:
        if(j >= i) goto _L2; else goto _L1
_L1:
        NetworkConfig networkconfig = new NetworkConfig(as[j]);
        networkconfig.type;
        JVM INSTR tableswitch 0 12: default 120
    //                   0 126
    //                   1 120
    //                   2 163
    //                   3 175
    //                   4 187
    //                   5 199
    //                   6 120
    //                   7 120
    //                   8 120
    //                   9 120
    //                   10 247
    //                   11 259
    //                   12 271;
           goto _L3 _L4 _L3 _L5 _L6 _L7 _L8 _L3 _L3 _L3 _L3 _L9 _L10 _L11
_L3:
        j++;
          goto _L12
_L4:
        ApnContext apncontext;
        apncontext = addApnContext("default");
        apncontext.setEnabled(flag);
_L13:
        if(apncontext != null)
            onSetDependencyMet(apncontext.getApnType(), networkconfig.dependencyMet);
          goto _L3
_L5:
        apncontext = addApnContext("mms");
          goto _L13
_L6:
        apncontext = addApnContext("supl");
          goto _L13
_L7:
        apncontext = addApnContext("dun");
          goto _L13
_L8:
        ApnContext apncontext1 = addApnContext("hipri");
        ApnContext apncontext2 = (ApnContext)mApnContexts.get("default");
        if(apncontext2 != null)
            applyNewState(apncontext1, apncontext1.isEnabled(), apncontext2.getDependencyMet());
          goto _L3
_L9:
        apncontext = addApnContext("fota");
          goto _L13
_L10:
        apncontext = addApnContext("ims");
          goto _L13
_L11:
        apncontext = addApnContext("cbs");
          goto _L13
_L2:
          goto _L3
    }

    public boolean isApnTypeActive(String s) {
        boolean flag;
        ApnContext apncontext;
        flag = false;
        apncontext = (ApnContext)mApnContexts.get(s);
        break MISSING_BLOCK_LABEL_14;
        if(apncontext != null && apncontext.getDataConnection() != null)
            flag = true;
        return flag;
    }

    protected boolean isApnTypeAvailable(String s) {
        boolean flag = true;
        if(!s.equals("dun") || fetchDunApn() == null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
label0:
        {
            if(mAllApns == null)
                break label0;
            Iterator iterator = mAllApns.iterator();
            do
                if(!iterator.hasNext())
                    break label0;
            while(!((ApnSetting)iterator.next()).canHandleType(s));
            continue; /* Loop/switch isn't completed */
        }
        flag = false;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean isApnTypeEnabled(String s) {
        ApnContext apncontext = (ApnContext)mApnContexts.get(s);
        boolean flag;
        if(apncontext == null)
            flag = false;
        else
            flag = apncontext.isEnabled();
        return flag;
    }

    protected boolean isConnected() {
        Iterator iterator = mApnContexts.values().iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        if(((ApnContext)iterator.next()).getState() != com.android.internal.telephony.DataConnectionTracker.State.CONNECTED) goto _L4; else goto _L3
_L3:
        boolean flag = true;
_L6:
        return flag;
_L2:
        flag = false;
        if(true) goto _L6; else goto _L5
_L5:
    }

    protected boolean isDataAllowed() {
        boolean flag;
        synchronized(mDataEnabledLock) {
            flag = mInternalDataEnabled;
        }
        int i = mPhone.getServiceStateTracker().getCurrentDataConnectionState();
        boolean flag1 = mPhone.getServiceStateTracker().getDesiredPowerState();
        boolean flag2;
        if((i == 0 || mAutoAttachOnCreation) && mPhone.mIccRecords.getRecordsLoaded() && (mPhone.getState() == com.android.internal.telephony.Phone.State.IDLE || mPhone.getServiceStateTracker().isConcurrentVoiceAndDataAllowed()) && flag && (!mPhone.getServiceState().getRoaming() || getDataOnRoamingEnabled()) && !mIsPsRestricted && flag1)
            flag2 = true;
        else
            flag2 = false;
        if(!flag2) {
            String s = "";
            if(i != 0 && !mAutoAttachOnCreation)
                s = (new StringBuilder()).append(s).append(" - gprs= ").append(i).toString();
            if(!mPhone.mIccRecords.getRecordsLoaded())
                s = (new StringBuilder()).append(s).append(" - SIM not loaded").toString();
            if(mPhone.getState() != com.android.internal.telephony.Phone.State.IDLE && !mPhone.getServiceStateTracker().isConcurrentVoiceAndDataAllowed()) {
                String s1 = (new StringBuilder()).append(s).append(" - PhoneState= ").append(mPhone.getState()).toString();
                s = (new StringBuilder()).append(s1).append(" - Concurrent voice and data not allowed").toString();
            }
            if(!flag)
                s = (new StringBuilder()).append(s).append(" - mInternalDataEnabled= false").toString();
            if(mPhone.getServiceState().getRoaming() && !getDataOnRoamingEnabled())
                s = (new StringBuilder()).append(s).append(" - Roaming and data roaming not enabled").toString();
            if(mIsPsRestricted)
                s = (new StringBuilder()).append(s).append(" - mIsPsRestricted= true").toString();
            if(!flag1)
                s = (new StringBuilder()).append(s).append(" - desiredPowerState= false").toString();
            log((new StringBuilder()).append("isDataAllowed: not allowed due to").append(s).toString());
        }
        return flag2;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected boolean isDataPossible(String s) {
        boolean flag = false;
        ApnContext apncontext = (ApnContext)mApnContexts.get(s);
        if(apncontext != null) {
            boolean flag1 = apncontext.isEnabled();
            com.android.internal.telephony.DataConnectionTracker.State state = apncontext.getState();
            boolean flag2;
            boolean flag3;
            boolean flag4;
            Object aobj[];
            if(!flag1 || state != com.android.internal.telephony.DataConnectionTracker.State.FAILED)
                flag2 = true;
            else
                flag2 = false;
            flag3 = isDataAllowed();
            if(flag3 && flag2)
                flag4 = true;
            else
                flag4 = false;
            aobj = new Object[6];
            aobj[flag] = s;
            aobj[1] = Boolean.valueOf(flag4);
            aobj[2] = Boolean.valueOf(flag3);
            aobj[3] = Boolean.valueOf(flag2);
            aobj[4] = Boolean.valueOf(flag1);
            aobj[5] = state;
            log(String.format("isDataPossible(%s): possible=%b isDataAllowed=%b apnTypePossible=%b apnContextisEnabled=%b apnContextState()=%s", aobj));
            flag = flag4;
        }
        return flag;
    }

    public boolean isDisconnected() {
        Iterator iterator = mApnContexts.values().iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        if(((ApnContext)iterator.next()).isDisconnected()) goto _L4; else goto _L3
_L3:
        boolean flag = false;
_L6:
        return flag;
_L2:
        flag = true;
        if(true) goto _L6; else goto _L5
_L5:
    }

    protected void log(String s) {
        Log.d("GSM", (new StringBuilder()).append("[GsmDCT] ").append(s).toString());
    }

    protected void loge(String s) {
        Log.e("GSM", (new StringBuilder()).append("[GsmDCT] ").append(s).toString());
    }

    protected void notifyDataConnection(String s) {
        log((new StringBuilder()).append("notifyDataConnection: reason=").append(s).toString());
        Iterator iterator = mApnContexts.values().iterator();
        do {
            if(!iterator.hasNext())
                break;
            ApnContext apncontext = (ApnContext)iterator.next();
            if(apncontext.isReady()) {
                log((new StringBuilder()).append("notifyDataConnection: type:").append(apncontext.getApnType()).toString());
                PhoneBase phonebase = mPhone;
                String s1;
                if(s != null)
                    s1 = s;
                else
                    s1 = apncontext.getReason();
                phonebase.notifyDataConnection(s1, apncontext.getApnType());
            }
        } while(true);
        notifyOffApnsOfAvailability(s);
    }

    protected void notifyOffApnsOfAvailability(String s) {
        for(Iterator iterator = mApnContexts.values().iterator(); iterator.hasNext();) {
            ApnContext apncontext = (ApnContext)iterator.next();
            if(!apncontext.isReady()) {
                log((new StringBuilder()).append("notifyOffApnOfAvailability type:").append(apncontext.getApnType()).toString());
                PhoneBase phonebase = mPhone;
                String s1;
                if(s != null)
                    s1 = s;
                else
                    s1 = apncontext.getReason();
                phonebase.notifyDataConnection(s1, apncontext.getApnType(), com.android.internal.telephony.Phone.DataState.DISCONNECTED);
            } else {
                log((new StringBuilder()).append("notifyOffApnsOfAvailability skipped apn due to isReady==false: ").append(apncontext.toString()).toString());
            }
        }

    }

    protected void onActionIntentReconnectAlarm(Intent intent) {
        String s = intent.getStringExtra("reconnect_alarm_extra_reason");
        int i = intent.getIntExtra("reconnect_alarm_extra_type", -1);
        int j = intent.getIntExtra("reconnect_alaram_extra_retry_count", 0);
        DataConnectionAc dataconnectionac = (DataConnectionAc)mDataConnectionAsyncChannels.get(Integer.valueOf(i));
        log((new StringBuilder()).append("onActionIntentReconnectAlarm: mState=").append(mState).append(" reason=").append(s).append(" connectionId=").append(i).append(" retryCount=").append(j).toString());
        if(dataconnectionac != null) {
            ApnContext apncontext;
            for(Iterator iterator = dataconnectionac.getApnListSync().iterator(); iterator.hasNext(); sendMessage(obtainMessage(0x42003, apncontext))) {
                apncontext = (ApnContext)iterator.next();
                apncontext.setDataConnectionAc(null);
                apncontext.setDataConnection(null);
                apncontext.setReason(s);
                apncontext.setRetryCount(j);
                if(apncontext.getState() == com.android.internal.telephony.DataConnectionTracker.State.FAILED)
                    apncontext.setState(com.android.internal.telephony.DataConnectionTracker.State.IDLE);
            }

            dataconnectionac.setReconnectIntentSync(null);
        }
    }

    protected void onCleanUpAllConnections(String s) {
        cleanUpAllConnections(true, s);
    }

    protected void onCleanUpConnection(boolean flag, int i, String s) {
        log("onCleanUpConnection");
        ApnContext apncontext = (ApnContext)mApnContexts.get(apnIdToType(i));
        if(apncontext != null) {
            apncontext.setReason(s);
            cleanUpConnection(flag, apncontext);
        }
    }

    protected void onDataConnectionDetached() {
        log("onDataConnectionDetached: stop polling and notify detached");
        stopNetStatPoll();
        stopDataStallAlarm();
        notifyDataConnection("dataDetached");
    }

    protected void onDataSetupComplete(AsyncResult asyncresult) {
        com.android.internal.telephony.DataConnection.FailCause failcause = com.android.internal.telephony.DataConnection.FailCause.UNKNOWN;
        boolean flag = false;
        if(asyncresult.userObj instanceof ApnContext) {
            ApnContext apncontext = (ApnContext)asyncresult.userObj;
            if(isDataSetupCompleteOk(asyncresult)) {
                DataConnectionAc dataconnectionac = apncontext.getDataConnectionAc();
                if(dataconnectionac == null) {
                    log("onDataSetupComplete: no connection to DC, handle as error");
                    failcause = com.android.internal.telephony.DataConnection.FailCause.CONNECTION_TO_DATACONNECTIONAC_BROKEN;
                    flag = true;
                } else {
                    apncontext.getDataConnection();
                    ApnSetting apnsetting1 = apncontext.getApnSetting();
                    StringBuilder stringbuilder = (new StringBuilder()).append("onDataSetupComplete: success apn=");
                    String s1;
                    if(apnsetting1 == null)
                        s1 = "unknown";
                    else
                        s1 = apnsetting1.apn;
                    log(stringbuilder.append(s1).toString());
                    if(apnsetting1 != null && apnsetting1.proxy != null && apnsetting1.proxy.length() != 0)
                        try {
                            String s2 = apnsetting1.port;
                            if(TextUtils.isEmpty(s2))
                                s2 = "8080";
                            dataconnectionac.setLinkPropertiesHttpProxySync(new ProxyProperties(apnsetting1.proxy, Integer.parseInt(s2), null));
                        }
                        catch(NumberFormatException numberformatexception) {
                            loge((new StringBuilder()).append("onDataSetupComplete: NumberFormatException making ProxyProperties (").append(apnsetting1.port).append("): ").append(numberformatexception).toString());
                        }
                    FirewallManager.getInstance().onDataConnected(0, FirewallManager.encodeApnSetting(apnsetting1), dataconnectionac.getLinkPropertiesSync().getInterfaceName());
                    if(TextUtils.equals(apncontext.getApnType(), "default")) {
                        SystemProperties.set("gsm.defaultpdpcontext.active", "true");
                        if(canSetPreferApn && mPreferredApn == null) {
                            log("onDataSetupComplete: PREFERED APN is null");
                            mPreferredApn = apnsetting1;
                            if(mPreferredApn != null)
                                setPreferredApn(mPreferredApn.id);
                        }
                    } else {
                        SystemProperties.set("gsm.defaultpdpcontext.active", "false");
                    }
                    notifyDefaultData(apncontext);
                }
            } else {
                failcause = (com.android.internal.telephony.DataConnection.FailCause)(com.android.internal.telephony.DataConnection.FailCause)asyncresult.result;
                ApnSetting apnsetting = apncontext.getApnSetting();
                Object aobj[] = new Object[2];
                String s;
                Object aobj1[];
                if(apnsetting == null)
                    s = "unknown";
                else
                    s = apnsetting.apn;
                aobj[0] = s;
                aobj[1] = failcause;
                log(String.format("onDataSetupComplete: error apn=%s cause=%s", aobj));
                if(failcause.isEventLoggable()) {
                    int j = getCellLocationId();
                    Object aobj2[] = new Object[3];
                    aobj2[0] = Integer.valueOf(failcause.ordinal());
                    aobj2[1] = Integer.valueOf(j);
                    aobj2[2] = Integer.valueOf(TelephonyManager.getDefault().getNetworkType());
                    EventLog.writeEvent(50105, aobj2);
                }
                if(failcause.isPermanentFail())
                    apncontext.decWaitingApnsPermFailCount();
                apncontext.removeWaitingApn(apncontext.getApnSetting());
                aobj1 = new Object[2];
                aobj1[0] = Integer.valueOf(apncontext.getWaitingApns().size());
                aobj1[1] = Integer.valueOf(apncontext.getWaitingApnsPermFailCount());
                log(String.format("onDataSetupComplete: WaitingApns.size=%d WaitingApnsPermFailureCountDown=%d", aobj1));
                flag = true;
            }
            if(flag)
                if(apncontext.getWaitingApns().isEmpty()) {
                    if(apncontext.getWaitingApnsPermFailCount() == 0) {
                        log("onDataSetupComplete: All APN's had permanent failures, stop retrying");
                        apncontext.setState(com.android.internal.telephony.DataConnectionTracker.State.FAILED);
                        mPhone.notifyDataConnection("apnFailed", apncontext.getApnType());
                        apncontext.setDataConnection(null);
                        apncontext.setDataConnectionAc(null);
                    } else {
                        log("onDataSetupComplete: Not all permanent failures, retry");
                        int i = -1;
                        if(asyncresult.exception instanceof com.android.internal.telephony.DataConnection.CallSetupException)
                            i = ((com.android.internal.telephony.DataConnection.CallSetupException)asyncresult.exception).getRetryOverride();
                        if(i == 0x7fffffff)
                            log("No retry is suggested.");
                        else
                            startDelayedRetry(failcause, apncontext, i);
                    }
                } else {
                    log("onDataSetupComplete: Try next APN");
                    apncontext.setState(com.android.internal.telephony.DataConnectionTracker.State.SCANNING);
                    startAlarmForReconnect(APN_DELAY_MILLIS, apncontext);
                }
            return;
        } else {
            throw new RuntimeException("onDataSetupComplete: No apnContext");
        }
    }

    protected void onDataStallAlarm(int i) {
        if(mDataStallAlarmTag != i) {
            log((new StringBuilder()).append("onDataStallAlarm: ignore, tag=").append(i).append(" expecting ").append(mDataStallAlarmTag).toString());
        } else {
            updateDataStallInfo();
            int j = android.provider.Settings.Secure.getInt(mResolver, "pdp_watchdog_trigger_packet_count", 10);
            boolean flag = false;
            if(mSentSinceLastRecv >= (long)j) {
                log((new StringBuilder()).append("onDataStallAlarm: tag=").append(i).append(" do recovery action=").append(getRecoveryAction()).toString());
                flag = true;
                sendMessage(obtainMessage(0x42012));
            }
            startDataStallAlarm(flag);
        }
    }

    protected void onDisconnectDone(int i, AsyncResult asyncresult) {
        if(asyncresult.userObj instanceof ApnContext) {
            ApnContext apncontext = (ApnContext)asyncresult.userObj;
            log((new StringBuilder()).append("onDisconnectDone: EVENT_DISCONNECT_DONE apnContext=").append(apncontext).toString());
            apncontext.setState(com.android.internal.telephony.DataConnectionTracker.State.IDLE);
            if(apncontext.getApnSetting() != null)
                FirewallManager.getInstance().onDataDisconnected(0, FirewallManager.encodeApnSetting(apncontext.getApnSetting()));
            mPhone.notifyDataConnection(apncontext.getReason(), apncontext.getApnType());
            if(isDisconnected() && mPhone.getServiceStateTracker().processPendingRadioPowerOffAfterDataOff()) {
                apncontext.setApnSetting(null);
                apncontext.setDataConnection(null);
                apncontext.setDataConnectionAc(null);
            } else
            if(apncontext.isReady() && retryAfterDisconnected(apncontext.getReason())) {
                SystemProperties.set("gsm.defaultpdpcontext.active", "false");
                startAlarmForReconnect(APN_DELAY_MILLIS, apncontext);
            } else {
                apncontext.setApnSetting(null);
                apncontext.setDataConnection(null);
                apncontext.setDataConnectionAc(null);
            }
        } else {
            loge("onDisconnectDone: Invalid ar in onDisconnectDone, ignore");
        }
    }

    protected void onEnableApn(int i, int j) {
        boolean flag = true;
        mRequestedApnType = getApnType(j, i);
        ApnContext apncontext = (ApnContext)mApnContexts.get(apnIdToType(i));
        if(apncontext == null) {
            loge((new StringBuilder()).append("onEnableApn(").append(i).append(", ").append(j).append("): NO ApnContext").toString());
        } else {
            log((new StringBuilder()).append("onEnableApn: apnContext=").append(apncontext).append(" call applyNewState").toString());
            if(j != flag)
                flag = false;
            applyNewState(apncontext, flag, apncontext.getDependencyMet());
        }
    }

    protected void onPollPdp() {
        if(getOverallState() == com.android.internal.telephony.DataConnectionTracker.State.CONNECTED) {
            mPhone.mCM.getDataCallList(obtainMessage(0x42004));
            sendMessageDelayed(obtainMessage(0x42005), 5000L);
        }
    }

    protected void onRadioAvailable() {
        log("onRadioAvailable");
        if(mPhone.getSimulatedRadioControl() != null) {
            notifyDataConnection(null);
            log("onRadioAvailable: We're on the simulator; assuming data is connected");
        }
        if(mPhone.mIccRecords.getRecordsLoaded())
            notifyOffApnsOfAvailability(null);
        if(getOverallState() != com.android.internal.telephony.DataConnectionTracker.State.IDLE)
            cleanUpConnection(true, null);
    }

    protected void onRadioOffOrNotAvailable() {
        resetAllRetryCounts();
        mReregisterOnReconnectFailure = false;
        if(mPhone.getSimulatedRadioControl() != null) {
            log("We're on the simulator; assuming radio off is meaningless");
        } else {
            log("onRadioOffOrNotAvailable: is off and clean up all connections");
            cleanUpAllConnections(false, "radioTurnedOff");
        }
        notifyOffApnsOfAvailability(null);
    }

    protected void onRoamingOff() {
        log("onRoamingOff");
        if(mUserDataEnabled)
            if(!getDataOnRoamingEnabled()) {
                notifyOffApnsOfAvailability("roamingOff");
                setupDataOnReadyApns("roamingOff");
            } else {
                notifyDataConnection("roamingOff");
            }
    }

    protected void onRoamingOn() {
        if(mUserDataEnabled)
            if(getDataOnRoamingEnabled()) {
                log("onRoamingOn: setup data on roaming");
                setupDataOnReadyApns("roamingOn");
                notifyDataConnection("roamingOn");
            } else {
                log("onRoamingOn: Tear down data connection on roaming.");
                cleanUpAllConnections(true, "roamingOn");
                notifyOffApnsOfAvailability("roamingOn");
            }
    }

    protected void onSetDependencyMet(String s, boolean flag) {
        if(!"hipri".equals(s)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        ApnContext apncontext = (ApnContext)mApnContexts.get(s);
        if(apncontext == null) {
            loge((new StringBuilder()).append("onSetDependencyMet: ApnContext not found in onSetDependencyMet(").append(s).append(", ").append(flag).append(")").toString());
        } else {
            applyNewState(apncontext, apncontext.isEnabled(), flag);
            if("default".equals(s)) {
                ApnContext apncontext1 = (ApnContext)mApnContexts.get("hipri");
                if(apncontext1 != null)
                    applyNewState(apncontext1, apncontext1.isEnabled(), flag);
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    protected boolean onTrySetupData(ApnContext apncontext) {
        log((new StringBuilder()).append("onTrySetupData: apnContext=").append(apncontext).toString());
        return trySetupData(apncontext);
    }

    protected boolean onTrySetupData(String s) {
        log((new StringBuilder()).append("onTrySetupData: reason=").append(s).toString());
        setupDataOnReadyApns(s);
        return true;
    }

    protected void onVoiceCallEnded() {
        log("onVoiceCallEnded");
        if(isConnected())
            if(!mPhone.getServiceStateTracker().isConcurrentVoiceAndDataAllowed()) {
                startNetStatPoll();
                startDataStallAlarm(false);
                notifyDataConnection("2GVoiceCallEnded");
            } else {
                resetPollStats();
            }
        setupDataOnReadyApns("2GVoiceCallEnded");
    }

    protected void onVoiceCallStarted() {
        log("onVoiceCallStarted");
        if(isConnected() && !mPhone.getServiceStateTracker().isConcurrentVoiceAndDataAllowed()) {
            log("onVoiceCallStarted stop polling");
            stopNetStatPoll();
            stopDataStallAlarm();
            notifyDataConnection("2GVoiceCallStarted");
        }
    }

    public void putRecoveryAction(int i) {
        android.provider.Settings.System.putInt(mPhone.getContext().getContentResolver(), "radio.data.stall.recovery.action", i);
    }

    protected void restartDataStallAlarm() {
        if(isConnected())
            if(RecoveryAction.isAggressiveRecovery(getRecoveryAction())) {
                log("data stall recovery action is pending. not resetting the alarm.");
            } else {
                stopDataStallAlarm();
                startDataStallAlarm(false);
            }
    }

    protected void restartRadio() {
        log("restartRadio: ************TURN OFF RADIO**************");
        cleanUpAllConnections(true, "radioTurnedOff");
        mPhone.getServiceStateTracker().powerOffRadioSafely(this);
        SystemProperties.set("net.ppp.reset-by-timeout", String.valueOf(1 + Integer.parseInt(SystemProperties.get("net.ppp.reset-by-timeout", "0"))));
    }

    protected void setState(com.android.internal.telephony.DataConnectionTracker.State state) {
        log((new StringBuilder()).append("setState should not be used in GSM").append(state).toString());
    }

    protected void startNetStatPoll() {
        if(getOverallState() == com.android.internal.telephony.DataConnectionTracker.State.CONNECTED && !mNetStatPollEnabled) {
            log("startNetStatPoll");
            resetPollStats();
            mNetStatPollEnabled = true;
            mPollNetStat.run();
        }
    }

    protected void stopNetStatPoll() {
        mNetStatPollEnabled = false;
        removeCallbacks(mPollNetStat);
        log("stopNetStatPoll");
    }

    static final String APN_ID = "apn_id";
    private static final boolean DATA_STALL_NOT_SUSPECTED = false;
    private static final boolean DATA_STALL_SUSPECTED = true;
    private static final String INTENT_DATA_STALL_ALARM = "com.android.internal.telephony.gprs-data-stall";
    private static final String INTENT_RECONNECT_ALARM = "com.android.internal.telephony.gprs-reconnect";
    private static final String INTENT_RECONNECT_ALARM_EXTRA_RETRY_COUNT = "reconnect_alaram_extra_retry_count";
    private static final String INTENT_RECONNECT_ALARM_EXTRA_TYPE = "reconnect_alarm_extra_type";
    private static final int POLL_PDP_MILLIS = 5000;
    static final Uri PREFERAPN_NO_UPDATE_URI = Uri.parse("content://telephony/carriers/preferapn_no_update");
    private static final boolean RADIO_TESTS;
    protected final String LOG_TAG = "GSM";
    private boolean canSetPreferApn;
    private ApnChangeObserver mApnObserver;
    private Runnable mPollNetStat;
    private boolean mReregisterOnReconnectFailure;
    private ContentResolver mResolver;






/*
    static int access$302(GsmDataConnectionTracker gsmdataconnectiontracker, int i) {
        gsmdataconnectiontracker.mNetStatPollPeriod = i;
        return i;
    }

*/



/*
    static int access$502(GsmDataConnectionTracker gsmdataconnectiontracker, int i) {
        gsmdataconnectiontracker.mNetStatPollPeriod = i;
        return i;
    }

*/



}
