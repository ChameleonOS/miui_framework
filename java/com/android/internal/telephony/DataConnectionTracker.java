// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.app.PendingIntent;
import android.content.*;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.net.*;
import android.os.*;
import android.preference.PreferenceManager;
import android.telephony.ServiceState;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.android.internal.telephony:
//            PhoneBase, DataConnectionAc, DataConnection, ApnContext, 
//            ApnSetting

public abstract class DataConnectionTracker extends Handler {
    public class TxRxSum {

        public void reset() {
            txPkts = -1L;
            rxPkts = -1L;
        }

        public String toString() {
            return (new StringBuilder()).append("{txSum=").append(txPkts).append(" rxSum=").append(rxPkts).append("}").toString();
        }

        public void updateTxRxSum() {
            boolean flag = false;
            boolean flag1 = false;
            long l = 0L;
            long l1 = 0L;
            Iterator iterator = mApnContexts.values().iterator();
            do {
                if(!iterator.hasNext())
                    break;
                ApnContext apncontext = (ApnContext)iterator.next();
                if(apncontext.getState() == State.CONNECTED) {
                    DataConnectionAc dataconnectionac = apncontext.getDataConnectionAc();
                    if(dataconnectionac != null) {
                        LinkProperties linkproperties = dataconnectionac.getLinkPropertiesSync();
                        if(linkproperties != null) {
                            String s = linkproperties.getInterfaceName();
                            if(s != null) {
                                long l2 = TrafficStats.getTxPackets(s);
                                if(l2 > 0L) {
                                    flag = true;
                                    l += l2;
                                }
                                long l3 = TrafficStats.getRxPackets(s);
                                if(l3 > 0L) {
                                    flag1 = true;
                                    l1 += l3;
                                }
                            }
                        }
                    }
                }
            } while(true);
            if(flag)
                txPkts = l;
            if(flag1)
                rxPkts = l1;
        }

        public long rxPkts;
        final DataConnectionTracker this$0;
        public long txPkts;

        public TxRxSum() {
            this$0 = DataConnectionTracker.this;
            super();
            reset();
        }

        public TxRxSum(long l, long l1) {
            this$0 = DataConnectionTracker.this;
            super();
            txPkts = l;
            rxPkts = l1;
        }

        public TxRxSum(TxRxSum txrxsum) {
            this$0 = DataConnectionTracker.this;
            super();
            txPkts = txrxsum.txPkts;
            rxPkts = txrxsum.rxPkts;
        }
    }

    private class DataRoamingSettingObserver extends ContentObserver {

        public void onChange(boolean flag) {
            handleDataOnRoamingChange();
        }

        public void register(Context context) {
            context.getContentResolver().registerContentObserver(android.provider.Settings.Secure.getUriFor("data_roaming"), false, this);
        }

        public void unregister(Context context) {
            context.getContentResolver().unregisterContentObserver(this);
        }

        final DataConnectionTracker this$0;

        public DataRoamingSettingObserver(Handler handler) {
            this$0 = DataConnectionTracker.this;
            super(handler);
        }
    }

    public static final class Activity extends Enum {

        public static Activity valueOf(String s) {
            return (Activity)Enum.valueOf(com/android/internal/telephony/DataConnectionTracker$Activity, s);
        }

        public static Activity[] values() {
            return (Activity[])$VALUES.clone();
        }

        private static final Activity $VALUES[];
        public static final Activity DATAIN;
        public static final Activity DATAINANDOUT;
        public static final Activity DATAOUT;
        public static final Activity DORMANT;
        public static final Activity NONE;

        static  {
            NONE = new Activity("NONE", 0);
            DATAIN = new Activity("DATAIN", 1);
            DATAOUT = new Activity("DATAOUT", 2);
            DATAINANDOUT = new Activity("DATAINANDOUT", 3);
            DORMANT = new Activity("DORMANT", 4);
            Activity aactivity[] = new Activity[5];
            aactivity[0] = NONE;
            aactivity[1] = DATAIN;
            aactivity[2] = DATAOUT;
            aactivity[3] = DATAINANDOUT;
            aactivity[4] = DORMANT;
            $VALUES = aactivity;
        }

        private Activity(String s, int i) {
            super(s, i);
        }
    }

    public static final class State extends Enum {

        public static State valueOf(String s) {
            return (State)Enum.valueOf(com/android/internal/telephony/DataConnectionTracker$State, s);
        }

        public static State[] values() {
            return (State[])$VALUES.clone();
        }

        private static final State $VALUES[];
        public static final State CONNECTED;
        public static final State CONNECTING;
        public static final State DISCONNECTING;
        public static final State FAILED;
        public static final State IDLE;
        public static final State INITING;
        public static final State SCANNING;

        static  {
            IDLE = new State("IDLE", 0);
            INITING = new State("INITING", 1);
            CONNECTING = new State("CONNECTING", 2);
            SCANNING = new State("SCANNING", 3);
            CONNECTED = new State("CONNECTED", 4);
            DISCONNECTING = new State("DISCONNECTING", 5);
            FAILED = new State("FAILED", 6);
            State astate[] = new State[7];
            astate[0] = IDLE;
            astate[1] = INITING;
            astate[2] = CONNECTING;
            astate[3] = SCANNING;
            astate[4] = CONNECTED;
            astate[5] = DISCONNECTING;
            astate[6] = FAILED;
            $VALUES = astate;
        }

        private State(String s, int i) {
            super(s, i);
        }
    }

    static class Injector {

        static boolean getAnyDataEnabled(DataConnectionTracker dataconnectiontracker, boolean flag) {
            boolean flag1;
            if(dataconnectiontracker.isMmsDataEnabled() || flag)
                flag1 = true;
            else
                flag1 = false;
            return flag1;
        }

        Injector() {
        }
    }


    protected DataConnectionTracker(PhoneBase phonebase) {
        mDataEnabledLock = new Object();
        mInternalDataEnabled = true;
        mUserDataEnabled = true;
        dataEnabled = new boolean[8];
        enabledCount = 0;
        mRequestedApnType = "default";
        mFailDataSetupCounter = 0;
        mFailDataSetupFailCause = DataConnection.FailCause.ERROR_UNSPECIFIED;
        mActivity = Activity.NONE;
        mState = State.IDLE;
        mDataConnectionTracker = null;
        mNetStatPollEnabled = false;
        mDataStallTxRxSum = new TxRxSum(0L, 0L);
        mDataStallAlarmTag = (int)SystemClock.elapsedRealtime();
        mDataStallAlarmIntent = null;
        mNoRecvPollCount = 0;
        mIsWifiConnected = false;
        mReconnectIntent = null;
        mAutoAttachOnCreation = false;
        mIsScreenOn = true;
        mUniqueIdGenerator = new AtomicInteger(0);
        mDataConnections = new HashMap();
        mDataConnectionAsyncChannels = new HashMap();
        mApnToDataConnectionId = new HashMap();
        mApnContexts = new ConcurrentHashMap();
        mAllApns = null;
        mPreferredApn = null;
        mIsPsRestricted = false;
        mIsDisposed = false;
        mIntentReceiver = new BroadcastReceiver() {

            public void onReceive(Context context, Intent intent) {
                boolean flag1;
                String s;
                flag1 = true;
                s = intent.getAction();
                log((new StringBuilder()).append("onReceive: action=").append(s).toString());
                if(!s.equals("android.intent.action.SCREEN_ON")) goto _L2; else goto _L1
_L1:
                mIsScreenOn = flag1;
                stopNetStatPoll();
                startNetStatPoll();
                restartDataStallAlarm();
_L4:
                return;
_L2:
                if(s.equals("android.intent.action.SCREEN_OFF")) {
                    mIsScreenOn = false;
                    stopNetStatPoll();
                    startNetStatPoll();
                    restartDataStallAlarm();
                } else
                if(s.startsWith(getActionIntentReconnectAlarm())) {
                    log((new StringBuilder()).append("Reconnect alarm. Previous state was ").append(mState).toString());
                    onActionIntentReconnectAlarm(intent);
                } else
                if(s.equals(getActionIntentDataStallAlarm()))
                    onActionIntentDataStallAlarm(intent);
                else
                if(s.equals("android.net.wifi.STATE_CHANGE")) {
                    NetworkInfo networkinfo = (NetworkInfo)intent.getParcelableExtra("networkInfo");
                    DataConnectionTracker dataconnectiontracker = DataConnectionTracker.this;
                    if(networkinfo == null || !networkinfo.isConnected())
                        flag1 = false;
                    dataconnectiontracker.mIsWifiConnected = flag1;
                } else
                if(s.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                    boolean flag2;
                    if(intent.getIntExtra("wifi_state", 4) == 3)
                        flag2 = flag1;
                    else
                        flag2 = false;
                    if(!flag2)
                        mIsWifiConnected = false;
                } else
                if(s.equals("com.android.internal.telephony.dataconnectiontracker.intent_set_fail_data_setup_counter")) {
                    mFailDataSetupCounter = intent.getIntExtra("fail_data_setup_counter", flag1);
                    mFailDataSetupFailCause = DataConnection.FailCause.fromInt(intent.getIntExtra("fail_data_setup_fail_cause", DataConnection.FailCause.ERROR_UNSPECIFIED.getErrorCode()));
                    log((new StringBuilder()).append("set mFailDataSetupCounter=").append(mFailDataSetupCounter).append(" mFailDataSetupFailCause=").append(mFailDataSetupFailCause).toString());
                }
                if(true) goto _L4; else goto _L3
_L3:
            }

            final DataConnectionTracker this$0;

             {
                this$0 = DataConnectionTracker.this;
                super();
            }
        };
        log("DCT.constructor");
        mPhone = phonebase;
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction(getActionIntentReconnectAlarm());
        intentfilter.addAction("android.intent.action.SCREEN_ON");
        intentfilter.addAction("android.intent.action.SCREEN_OFF");
        intentfilter.addAction("android.net.wifi.STATE_CHANGE");
        intentfilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentfilter.addAction("com.android.internal.telephony.dataconnectiontracker.intent_set_fail_data_setup_counter");
        boolean flag;
        if(android.provider.Settings.Secure.getInt(mPhone.getContext().getContentResolver(), "mobile_data", 1) == 1)
            flag = true;
        else
            flag = false;
        mUserDataEnabled = flag;
        mPhone.getContext().registerReceiver(mIntentReceiver, intentfilter, null, mPhone);
        dataEnabled[0] = SystemProperties.getBoolean("net.def_data_on_boot", true);
        if(dataEnabled[0])
            enabledCount = 1 + enabledCount;
        mAutoAttachOnCreation = PreferenceManager.getDefaultSharedPreferences(mPhone.getContext()).getBoolean("disabled_on_boot_key", false);
        mDataRoamingSettingObserver = new DataRoamingSettingObserver(mPhone);
        mDataRoamingSettingObserver.register(mPhone.getContext());
    }

    private void handleDataOnRoamingChange() {
        if(mPhone.getServiceState().getRoaming()) {
            if(getDataOnRoamingEnabled())
                resetAllRetryCounts();
            sendMessage(obtainMessage(0x4200b));
        }
    }

    private void notifyApnIdDisconnected(String s, int i) {
        mPhone.notifyDataConnection(s, apnIdToType(i), Phone.DataState.DISCONNECTED);
    }

    private void notifyApnIdUpToCurrent(String s, int i) {
        class _cls2 {

            static final int $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[];

            static  {
                $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State = new int[State.values().length];
                NoSuchFieldError nosuchfielderror5;
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[State.IDLE.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[State.INITING.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror1) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[State.CONNECTING.ordinal()] = 3;
                }
                catch(NoSuchFieldError nosuchfielderror2) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[State.SCANNING.ordinal()] = 4;
                }
                catch(NoSuchFieldError nosuchfielderror3) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[State.CONNECTED.ordinal()] = 5;
                }
                catch(NoSuchFieldError nosuchfielderror4) { }
                $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[State.DISCONNECTING.ordinal()] = 6;
_L2:
                return;
                nosuchfielderror5;
                if(true) goto _L2; else goto _L1
_L1:
            }
        }

        _cls2..SwitchMap.com.android.internal.telephony.DataConnectionTracker.State[mState.ordinal()];
        JVM INSTR tableswitch 1 6: default 48
    //                   1 48
    //                   2 48
    //                   3 49
    //                   4 49
    //                   5 68
    //                   6 68;
           goto _L1 _L1 _L1 _L2 _L2 _L3 _L3
_L1:
        return;
_L2:
        mPhone.notifyDataConnection(s, apnIdToType(i), Phone.DataState.CONNECTING);
        continue; /* Loop/switch isn't completed */
_L3:
        mPhone.notifyDataConnection(s, apnIdToType(i), Phone.DataState.CONNECTING);
        mPhone.notifyDataConnection(s, apnIdToType(i), Phone.DataState.CONNECTED);
        if(true) goto _L1; else goto _L4
_L4:
    }

    protected String apnIdToType(int i) {
        i;
        JVM INSTR tableswitch 0 7: default 48
    //                   0 84
    //                   1 91
    //                   2 98
    //                   3 105
    //                   4 112
    //                   5 119
    //                   6 126
    //                   7 133;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        String s;
        log((new StringBuilder()).append("Unknown id (").append(i).append(") in apnIdToType").toString());
        s = "default";
_L11:
        return s;
_L2:
        s = "default";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "mms";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "supl";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "dun";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "hipri";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "ims";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "fota";
        continue; /* Loop/switch isn't completed */
_L9:
        s = "cbs";
        if(true) goto _L11; else goto _L10
_L10:
    }

    protected int apnTypeToId(String s) {
        int i;
        if(TextUtils.equals(s, "default"))
            i = 0;
        else
        if(TextUtils.equals(s, "mms"))
            i = 1;
        else
        if(TextUtils.equals(s, "supl"))
            i = 2;
        else
        if(TextUtils.equals(s, "dun"))
            i = 3;
        else
        if(TextUtils.equals(s, "hipri"))
            i = 4;
        else
        if(TextUtils.equals(s, "ims"))
            i = 5;
        else
        if(TextUtils.equals(s, "fota"))
            i = 6;
        else
        if(TextUtils.equals(s, "cbs"))
            i = 7;
        else
            i = -1;
        return i;
    }

    protected void broadcastMessenger() {
        Intent intent = new Intent(ACTION_DATA_CONNECTION_TRACKER_MESSENGER);
        intent.putExtra(EXTRA_MESSENGER, new Messenger(this));
        mPhone.getContext().sendBroadcast(intent);
    }

    public void cleanUpAllConnections(String s) {
        Message message = obtainMessage(0x4201e);
        message.obj = s;
        sendMessage(message);
    }

    /**
     * @deprecated Method disableApnType is deprecated
     */

    public int disableApnType(String s) {
        byte byte0 = 3;
        this;
        JVM INSTR monitorenter ;
        int i;
        log((new StringBuilder()).append("disableApnType(").append(s).append(")").toString());
        i = apnTypeToId(s);
        if(i != -1) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return byte0;
_L2:
        boolean flag;
        if(!isApnIdEnabled(i))
            continue; /* Loop/switch isn't completed */
        setEnabled(i, false);
        if(!isApnTypeActive("default"))
            break MISSING_BLOCK_LABEL_101;
        flag = dataEnabled[0];
        if(flag)
            byte0 = 0;
        else
            byte0 = 1;
        continue; /* Loop/switch isn't completed */
        byte0 = 1;
        if(true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void dispose() {
        log("DCT.dispose");
        for(Iterator iterator = mDataConnectionAsyncChannels.values().iterator(); iterator.hasNext(); ((DataConnectionAc)iterator.next()).disconnect());
        mDataConnectionAsyncChannels.clear();
        mIsDisposed = true;
        mPhone.getContext().unregisterReceiver(mIntentReceiver);
        mDataRoamingSettingObserver.unregister(mPhone.getContext());
    }

    public void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        printwriter.println("DataConnectionTracker:");
        printwriter.println((new StringBuilder()).append(" mInternalDataEnabled=").append(mInternalDataEnabled).toString());
        printwriter.println((new StringBuilder()).append(" mUserDataEnabled=").append(mUserDataEnabled).toString());
        printwriter.println((new StringBuilder()).append(" sPolicyDataEnabed=").append(sPolicyDataEnabled).toString());
        printwriter.println(" dataEnabled:");
        for(int i = 0; i < dataEnabled.length; i++) {
            Object aobj3[] = new Object[2];
            aobj3[0] = Integer.valueOf(i);
            aobj3[1] = Boolean.valueOf(dataEnabled[i]);
            printwriter.printf("  dataEnabled[%d]=%b\n", aobj3);
        }

        printwriter.flush();
        printwriter.println((new StringBuilder()).append(" enabledCount=").append(enabledCount).toString());
        printwriter.println((new StringBuilder()).append(" mRequestedApnType=").append(mRequestedApnType).toString());
        printwriter.println((new StringBuilder()).append(" mPhone=").append(mPhone.getPhoneName()).toString());
        printwriter.println((new StringBuilder()).append(" mActivity=").append(mActivity).toString());
        printwriter.println((new StringBuilder()).append(" mState=").append(mState).toString());
        printwriter.println((new StringBuilder()).append(" mTxPkts=").append(mTxPkts).toString());
        printwriter.println((new StringBuilder()).append(" mRxPkts=").append(mRxPkts).toString());
        printwriter.println((new StringBuilder()).append(" mNetStatPollPeriod=").append(mNetStatPollPeriod).toString());
        printwriter.println((new StringBuilder()).append(" mNetStatPollEnabled=").append(mNetStatPollEnabled).toString());
        printwriter.println((new StringBuilder()).append(" mDataStallTxRxSum=").append(mDataStallTxRxSum).toString());
        printwriter.println((new StringBuilder()).append(" mDataStallAlarmTag=").append(mDataStallAlarmTag).toString());
        printwriter.println((new StringBuilder()).append(" mSentSinceLastRecv=").append(mSentSinceLastRecv).toString());
        printwriter.println((new StringBuilder()).append(" mNoRecvPollCount=").append(mNoRecvPollCount).toString());
        printwriter.println((new StringBuilder()).append(" mIsWifiConnected=").append(mIsWifiConnected).toString());
        printwriter.println((new StringBuilder()).append(" mReconnectIntent=").append(mReconnectIntent).toString());
        printwriter.println((new StringBuilder()).append(" mCidActive=").append(mCidActive).toString());
        printwriter.println((new StringBuilder()).append(" mAutoAttachOnCreation=").append(mAutoAttachOnCreation).toString());
        printwriter.println((new StringBuilder()).append(" mIsScreenOn=").append(mIsScreenOn).toString());
        printwriter.println((new StringBuilder()).append(" mUniqueIdGenerator=").append(mUniqueIdGenerator).toString());
        printwriter.flush();
        printwriter.println(" ***************************************");
        Set set = mDataConnections.entrySet();
        printwriter.println((new StringBuilder()).append(" mDataConnections: count=").append(set.size()).toString());
        java.util.Map.Entry entry1;
        for(Iterator iterator = set.iterator(); iterator.hasNext(); ((DataConnection)entry1.getValue()).dump(filedescriptor, printwriter, as)) {
            entry1 = (java.util.Map.Entry)iterator.next();
            Object aobj2[] = new Object[1];
            aobj2[0] = entry1.getKey();
            printwriter.printf(" *** mDataConnection[%d] \n", aobj2);
        }

        printwriter.println(" ***************************************");
        printwriter.flush();
        Set set1 = mApnToDataConnectionId.entrySet();
        printwriter.println((new StringBuilder()).append(" mApnToDataConnectonId size=").append(set1.size()).toString());
        Object aobj1[];
        for(Iterator iterator1 = set1.iterator(); iterator1.hasNext(); printwriter.printf(" mApnToDataConnectonId[%s]=%d\n", aobj1)) {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator1.next();
            aobj1 = new Object[2];
            aobj1[0] = entry.getKey();
            aobj1[1] = entry.getValue();
        }

        printwriter.println(" ***************************************");
        printwriter.flush();
        if(mApnContexts != null) {
            Set set2 = mApnContexts.entrySet();
            printwriter.println((new StringBuilder()).append(" mApnContexts size=").append(set2.size()).toString());
            for(Iterator iterator2 = set2.iterator(); iterator2.hasNext(); ((ApnContext)((java.util.Map.Entry)iterator2.next()).getValue()).dump(filedescriptor, printwriter, as));
            printwriter.println(" ***************************************");
        } else {
            printwriter.println(" mApnContexts=null");
        }
        printwriter.flush();
        printwriter.println((new StringBuilder()).append(" mActiveApn=").append(mActiveApn).toString());
        if(mAllApns != null) {
            printwriter.println((new StringBuilder()).append(" mAllApns size=").append(mAllApns.size()).toString());
            for(int j = 0; j < mAllApns.size(); j++) {
                Object aobj[] = new Object[2];
                aobj[0] = Integer.valueOf(j);
                aobj[1] = mAllApns.get(j);
                printwriter.printf(" mAllApns[%d]: %s\n", aobj);
            }

            printwriter.flush();
        } else {
            printwriter.println(" mAllApns=null");
        }
        printwriter.println((new StringBuilder()).append(" mPreferredApn=").append(mPreferredApn).toString());
        printwriter.println((new StringBuilder()).append(" mIsPsRestricted=").append(mIsPsRestricted).toString());
        printwriter.println((new StringBuilder()).append(" mIsDisposed=").append(mIsDisposed).toString());
        printwriter.println((new StringBuilder()).append(" mIntentReceiver=").append(mIntentReceiver).toString());
        printwriter.println((new StringBuilder()).append(" mDataRoamingSettingObserver=").append(mDataRoamingSettingObserver).toString());
        printwriter.flush();
    }

    /**
     * @deprecated Method enableApnType is deprecated
     */

    public int enableApnType(String s) {
        byte byte0 = 1;
        this;
        JVM INSTR monitorenter ;
        int i = apnTypeToId(s);
        if(i != -1) goto _L2; else goto _L1
_L1:
        byte0 = 3;
_L4:
        this;
        JVM INSTR monitorexit ;
        return byte0;
_L2:
        log((new StringBuilder()).append("enableApnType(").append(s).append("), isApnTypeActive = ").append(isApnTypeActive(s)).append(", isApnIdEnabled =").append(isApnIdEnabled(i)).append(" and state = ").append(mState).toString());
        if(!isApnTypeAvailable(s)) {
            log("type not available");
            byte0 = 2;
        } else
        if(isApnIdEnabled(i))
            byte0 = 0;
        else
            setEnabled(i, true);
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    protected ApnSetting fetchDunApn() {
        if(!SystemProperties.getBoolean("net.tethering.noprovisioning", false)) goto _L2; else goto _L1
_L1:
        ApnSetting apnsetting;
        log("fetchDunApn: net.tethering.noprovisioning=true ret: null");
        apnsetting = null;
_L4:
        return apnsetting;
_L2:
        Context context = mPhone.getContext();
        apnsetting = ApnSetting.fromString(android.provider.Settings.Secure.getString(context.getContentResolver(), "tether_dun_apn"));
        if(apnsetting == null)
            apnsetting = ApnSetting.fromString(context.getResources().getString(0x1040019));
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected abstract String getActionIntentDataStallAlarm();

    protected abstract String getActionIntentReconnectAlarm();

    public String getActiveApnString(String s) {
        String s1 = null;
        if(mActiveApn != null)
            s1 = mActiveApn.apn;
        return s1;
    }

    public String[] getActiveApnTypes() {
        String as[];
        if(mActiveApn != null) {
            as = mActiveApn.types;
        } else {
            as = new String[1];
            as[0] = "default";
        }
        return as;
    }

    public Activity getActivity() {
        return mActivity;
    }

    public boolean getAnyDataEnabled() {
        Object obj = mDataEnabledLock;
        obj;
        JVM INSTR monitorenter ;
        boolean flag;
        if(!mInternalDataEnabled || !mUserDataEnabled || !sPolicyDataEnabled || enabledCount == 0)
            break MISSING_BLOCK_LABEL_78;
        flag = true;
_L1:
        boolean flag1 = Injector.getAnyDataEnabled(this, flag);
        if(!flag1)
            log((new StringBuilder()).append("getAnyDataEnabled ").append(flag1).toString());
        return flag1;
        flag = false;
          goto _L1
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean getDataOnRoamingEnabled() {
        boolean flag = false;
        int i = android.provider.Settings.Secure.getInt(mPhone.getContext().getContentResolver(), "data_roaming");
        if(i != 0)
            flag = true;
_L2:
        return flag;
        android.provider.Settings.SettingNotFoundException settingnotfoundexception;
        settingnotfoundexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    protected LinkCapabilities getLinkCapabilities(String s) {
        LinkCapabilities linkcapabilities;
        if(isApnIdEnabled(apnTypeToId(s)))
            linkcapabilities = ((DataConnectionAc)mDataConnectionAsyncChannels.get(Integer.valueOf(0))).getLinkCapabilitiesSync();
        else
            linkcapabilities = new LinkCapabilities();
        return linkcapabilities;
    }

    protected LinkProperties getLinkProperties(String s) {
        LinkProperties linkproperties;
        if(isApnIdEnabled(apnTypeToId(s)))
            linkproperties = ((DataConnectionAc)mDataConnectionAsyncChannels.get(Integer.valueOf(0))).getLinkPropertiesSync();
        else
            linkproperties = new LinkProperties();
        return linkproperties;
    }

    protected String getReryConfig(boolean flag) {
        int i = mPhone.getServiceState().getNetworkType();
        String s;
        if(i == 4 || i == 7 || i == 5 || i == 6 || i == 12 || i == 14)
            s = SystemProperties.get("ro.cdma.data_retry_config");
        else
        if(flag)
            s = SystemProperties.get("ro.gsm.data_retry_config");
        else
            s = SystemProperties.get("ro.gsm.2nd_data_retry_config");
        return s;
    }

    public abstract State getState(String s);

    protected abstract void gotoIdleAndNotifyDataConnection(String s);

    public void handleMessage(Message message) {
        boolean flag = false;
        message.what;
        JVM INSTR lookupswitch 19: default 168
    //                   69636: 196
    //                   270336: 353
    //                   270337: 339
    //                   270339: 271
    //                   270342: 346
    //                   270343: 417
    //                   270344: 424
    //                   270347: 332
    //                   270348: 314
    //                   270349: 256
    //                   270351: 375
    //                   270353: 303
    //                   270360: 445
    //                   270363: 476
    //                   270364: 502
    //                   270365: 523
    //                   270366: 431
    //                   270367: 574
    //                   270368: 655;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20
_L1:
        Log.e("DATA", (new StringBuilder()).append("Unidentified event msg=").append(message).toString());
_L22:
        return;
_L2:
        log((new StringBuilder()).append("DISCONNECTED_CONNECTED: msg=").append(message).toString());
        DataConnectionAc dataconnectionac = (DataConnectionAc)message.obj;
        mDataConnectionAsyncChannels.remove(Integer.valueOf(dataconnectionac.dataConnection.getDataConnectionId()));
        dataconnectionac.disconnected();
        continue; /* Loop/switch isn't completed */
_L11:
        onEnableApn(message.arg1, message.arg2);
        continue; /* Loop/switch isn't completed */
_L5:
        String s1 = null;
        if(message.obj instanceof String)
            s1 = (String)message.obj;
        onTrySetupData(s1);
        continue; /* Loop/switch isn't completed */
_L13:
        onDataStallAlarm(message.arg1);
        continue; /* Loop/switch isn't completed */
_L10:
        if(!getDataOnRoamingEnabled())
            resetAllRetryCounts();
        onRoamingOff();
        continue; /* Loop/switch isn't completed */
_L9:
        onRoamingOn();
        continue; /* Loop/switch isn't completed */
_L4:
        onRadioAvailable();
        continue; /* Loop/switch isn't completed */
_L6:
        onRadioOffOrNotAvailable();
        continue; /* Loop/switch isn't completed */
_L3:
        mCidActive = message.arg1;
        onDataSetupComplete((AsyncResult)message.obj);
        continue; /* Loop/switch isn't completed */
_L12:
        log((new StringBuilder()).append("DataConnectoinTracker.handleMessage: EVENT_DISCONNECT_DONE msg=").append(message).toString());
        onDisconnectDone(message.arg1, (AsyncResult)message.obj);
        continue; /* Loop/switch isn't completed */
_L7:
        onVoiceCallStarted();
        continue; /* Loop/switch isn't completed */
_L8:
        onVoiceCallEnded();
        continue; /* Loop/switch isn't completed */
_L18:
        onCleanUpAllConnections((String)message.obj);
        continue; /* Loop/switch isn't completed */
_L14:
        if(message.arg1 != 0)
            flag = true;
        onCleanUpConnection(flag, message.arg2, (String)message.obj);
        continue; /* Loop/switch isn't completed */
_L15:
        boolean flag4;
        if(message.arg1 == 1)
            flag4 = true;
        else
            flag4 = false;
        onSetInternalDataEnabled(flag4);
        continue; /* Loop/switch isn't completed */
_L16:
        log("EVENT_RESET_DONE");
        onResetDone((AsyncResult)message.obj);
        continue; /* Loop/switch isn't completed */
_L17:
        boolean flag3;
        if(message.arg1 == 1)
            flag3 = true;
        else
            flag3 = false;
        log((new StringBuilder()).append("CMD_SET_USER_DATA_ENABLE enabled=").append(flag3).toString());
        onSetUserDataEnabled(flag3);
        continue; /* Loop/switch isn't completed */
_L19:
        boolean flag2;
        Bundle bundle;
        if(message.arg1 == 1)
            flag2 = true;
        else
            flag2 = false;
        log((new StringBuilder()).append("CMD_SET_DEPENDENCY_MET met=").append(flag2).toString());
        bundle = message.getData();
        if(bundle != null) {
            String s = (String)bundle.get("apnType");
            if(s != null)
                onSetDependencyMet(s, flag2);
        }
        continue; /* Loop/switch isn't completed */
_L20:
        boolean flag1;
        if(message.arg1 == 1)
            flag1 = true;
        else
            flag1 = false;
        onSetPolicyDataEnabled(flag1);
        if(true) goto _L22; else goto _L21
_L21:
    }

    /**
     * @deprecated Method isApnIdEnabled is deprecated
     */

    protected boolean isApnIdEnabled(int i) {
        this;
        JVM INSTR monitorenter ;
        if(i == -1) goto _L2; else goto _L1
_L1:
        boolean flag = dataEnabled[i];
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isApnTypeActive(String s) {
        boolean flag = true;
        if(!"dun".equals(s)) goto _L2; else goto _L1
_L1:
        ApnSetting apnsetting = fetchDunApn();
        if(apnsetting == null) goto _L2; else goto _L3
_L3:
        if(mActiveApn == null || !apnsetting.toString().equals(mActiveApn.toString()))
            flag = false;
_L5:
        return flag;
_L2:
        if(mActiveApn == null || !mActiveApn.canHandleType(s))
            flag = false;
        if(true) goto _L5; else goto _L4
_L4:
    }

    protected abstract boolean isApnTypeAvailable(String s);

    public boolean isApnTypeEnabled(String s) {
        boolean flag;
        if(s == null)
            flag = false;
        else
            flag = isApnIdEnabled(apnTypeToId(s));
        return flag;
    }

    protected abstract boolean isDataAllowed();

    protected abstract boolean isDataPossible(String s);

    protected boolean isDataSetupCompleteOk(AsyncResult asyncresult) {
        boolean flag = false;
        if(asyncresult.exception != null)
            log((new StringBuilder()).append("isDataSetupCompleteOk return false, ar.result=").append(asyncresult.result).toString());
        else
        if(mFailDataSetupCounter <= 0) {
            log("isDataSetupCompleteOk return true");
            flag = true;
        } else {
            asyncresult.result = mFailDataSetupFailCause;
            log((new StringBuilder()).append("isDataSetupCompleteOk return false mFailDataSetupCounter=").append(mFailDataSetupCounter).append(" mFailDataSetupFailCause=").append(mFailDataSetupFailCause).toString());
            mFailDataSetupCounter = -1 + mFailDataSetupCounter;
        }
        return flag;
    }

    public abstract boolean isDisconnected();

    protected boolean isEmergency() {
        boolean flag;
        synchronized(mDataEnabledLock) {
            if(!mPhone.isInEcm() && !mPhone.isInEmergencyCall())
                flag = false;
            else
                flag = true;
        }
        log((new StringBuilder()).append("isEmergency: result=").append(flag).toString());
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected boolean isMmsDataEnabled() {
        boolean flag = true;
        if(!mRequestedApnType.equals("mms") || android.provider.Settings.System.getInt(mPhone.getContext().getContentResolver(), "always_enable_mms", flag) != flag)
            flag = false;
        return flag;
    }

    protected abstract void log(String s);

    protected abstract void loge(String s);

    protected void notifyDataConnection(String s) {
        for(int i = 0; i < 8; i++)
            if(dataEnabled[i])
                mPhone.notifyDataConnection(s, apnIdToType(i));

        notifyOffApnsOfAvailability(s);
    }

    protected void notifyOffApnsOfAvailability(String s) {
        log((new StringBuilder()).append("notifyOffApnsOfAvailability - reason= ").append(s).toString());
        for(int i = 0; i < 8; i++)
            if(!isApnIdEnabled(i))
                notifyApnIdDisconnected(s, i);

    }

    protected void onActionIntentDataStallAlarm(Intent intent) {
        Message message = obtainMessage(0x42011, intent.getAction());
        message.arg1 = intent.getIntExtra("data.stall.alram.tag", 0);
        sendMessage(message);
    }

    protected void onActionIntentReconnectAlarm(Intent intent) {
        String s = intent.getStringExtra("reconnect_alarm_extra_reason");
        if(mState == State.FAILED) {
            Message message = obtainMessage(0x42018);
            message.arg1 = 0;
            message.arg2 = 0;
            message.obj = s;
            sendMessage(message);
        }
        sendMessage(obtainMessage(0x42003));
    }

    protected abstract void onCleanUpAllConnections(String s);

    protected abstract void onCleanUpConnection(boolean flag, int i, String s);

    protected abstract void onDataSetupComplete(AsyncResult asyncresult);

    protected void onDataStallAlarm(int i) {
        loge((new StringBuilder()).append("onDataStallAlarm: not impleted tag=").append(i).toString());
    }

    protected abstract void onDisconnectDone(int i, AsyncResult asyncresult);

    protected void onEnableApn(int i, int j) {
        log((new StringBuilder()).append("EVENT_APN_ENABLE_REQUEST apnId=").append(i).append(", apnType=").append(apnIdToType(i)).append(", enabled=").append(j).append(", dataEnabled = ").append(dataEnabled[i]).append(", enabledCount = ").append(enabledCount).append(", isApnTypeActive = ").append(isApnTypeActive(apnIdToType(i))).toString());
        if(j != 1) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if(!dataEnabled[i]) {
            dataEnabled[i] = true;
            enabledCount = 1 + enabledCount;
        }
        this;
        JVM INSTR monitorexit ;
        String s = apnIdToType(i);
        Exception exception1;
        if(!isApnTypeActive(s)) {
            mRequestedApnType = s;
            onEnableNewApn();
        } else {
            notifyApnIdUpToCurrent("apnSwitched", i);
        }
_L4:
        return;
        exception1;
        this;
        JVM INSTR monitorexit ;
        throw exception1;
_L2:
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        if(dataEnabled[i]) {
            dataEnabled[i] = false;
            enabledCount = -1 + enabledCount;
            flag = true;
        }
        this;
        JVM INSTR monitorexit ;
        if(flag) {
            if(enabledCount == 0 || i == 3) {
                mRequestedApnType = "default";
                onCleanUpConnection(true, i, "dataDisabled");
            }
            notifyApnIdDisconnected("dataDisabled", i);
            if(dataEnabled[0] && !isApnTypeActive("default")) {
                mRequestedApnType = "default";
                onEnableNewApn();
            }
        }
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void onEnableNewApn() {
    }

    protected abstract void onRadioAvailable();

    protected abstract void onRadioOffOrNotAvailable();

    protected void onResetDone(AsyncResult asyncresult) {
        log("EVENT_RESET_DONE");
        String s = null;
        if(asyncresult.userObj instanceof String)
            s = (String)asyncresult.userObj;
        gotoIdleAndNotifyDataConnection(s);
    }

    protected abstract void onRoamingOff();

    protected abstract void onRoamingOn();

    protected void onSetDependencyMet(String s, boolean flag) {
    }

    protected void onSetInternalDataEnabled(boolean flag) {
        Object obj = mDataEnabledLock;
        obj;
        JVM INSTR monitorenter ;
        mInternalDataEnabled = flag;
        if(flag) {
            log("onSetInternalDataEnabled: changed to enabled, try to setup data call");
            resetAllRetryCounts();
            onTrySetupData("dataEnabled");
        } else {
            log("onSetInternalDataEnabled: changed to disabled, cleanUpAllConnections");
            cleanUpAllConnections(null);
        }
        return;
    }

    protected void onSetPolicyDataEnabled(boolean flag) {
        Object obj = mDataEnabledLock;
        obj;
        JVM INSTR monitorenter ;
        boolean flag1 = getAnyDataEnabled();
        if(sPolicyDataEnabled != flag) {
            sPolicyDataEnabled = flag;
            if(flag1 != getAnyDataEnabled())
                if(!flag1) {
                    resetAllRetryCounts();
                    onTrySetupData("dataEnabled");
                } else {
                    onCleanUpAllConnections("dataDisabled");
                }
        }
        return;
    }

    protected void onSetUserDataEnabled(boolean flag) {
        Object obj = mDataEnabledLock;
        obj;
        JVM INSTR monitorenter ;
        boolean flag1 = getAnyDataEnabled();
        if(mUserDataEnabled != flag) {
            mUserDataEnabled = flag;
            ContentResolver contentresolver = mPhone.getContext().getContentResolver();
            Exception exception;
            int i;
            if(flag)
                i = 1;
            else
                i = 0;
            android.provider.Settings.Secure.putInt(contentresolver, "mobile_data", i);
            if(!getDataOnRoamingEnabled() && mPhone.getServiceState().getRoaming())
                if(flag)
                    notifyOffApnsOfAvailability("roamingOn");
                else
                    notifyOffApnsOfAvailability("dataDisabled");
            if(flag1 != getAnyDataEnabled()) {
                if(flag1)
                    break MISSING_BLOCK_LABEL_132;
                resetAllRetryCounts();
                onTrySetupData("dataEnabled");
            }
        }
        return;
        exception;
        throw exception;
        onCleanUpAllConnections("dataDisabled");
        break MISSING_BLOCK_LABEL_114;
    }

    protected abstract boolean onTrySetupData(String s);

    protected abstract void onVoiceCallEnded();

    protected abstract void onVoiceCallStarted();

    protected void resetAllRetryCounts() {
        for(Iterator iterator = mApnContexts.values().iterator(); iterator.hasNext(); ((ApnContext)iterator.next()).setRetryCount(0));
        for(Iterator iterator1 = mDataConnections.values().iterator(); iterator1.hasNext(); ((DataConnection)iterator1.next()).resetRetryCount());
    }

    protected abstract void restartDataStallAlarm();

    protected abstract void restartRadio();

    public void setDataOnRoamingEnabled(boolean flag) {
        if(getDataOnRoamingEnabled() != flag) {
            ContentResolver contentresolver = mPhone.getContext().getContentResolver();
            int i;
            if(flag)
                i = 1;
            else
                i = 0;
            android.provider.Settings.Secure.putInt(contentresolver, "data_roaming", i);
        }
    }

    protected void setEnabled(int i, boolean flag) {
        log((new StringBuilder()).append("setEnabled(").append(i).append(", ").append(flag).append(") with old state = ").append(dataEnabled[i]).append(" and enabledCount = ").append(enabledCount).toString());
        Message message = obtainMessage(0x4200d);
        message.arg1 = i;
        int j;
        if(flag)
            j = 1;
        else
            j = 0;
        message.arg2 = j;
        sendMessage(message);
    }

    public boolean setInternalDataEnabled(boolean flag) {
        log((new StringBuilder()).append("setInternalDataEnabled(").append(flag).append(")").toString());
        Message message = obtainMessage(0x4201b);
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        message.arg1 = i;
        sendMessage(message);
        return true;
    }

    protected abstract void setState(State state);

    protected abstract void startNetStatPoll();

    protected abstract void stopNetStatPoll();

    public static String ACTION_DATA_CONNECTION_TRACKER_MESSENGER = "com.android.internal.telephony";
    protected static final int APN_CBS_ID = 7;
    protected static final int APN_DEFAULT_ID = 0;
    protected static final int APN_DELAY_MILLIS = 0;
    protected static final int APN_DUN_ID = 3;
    protected static final int APN_FOTA_ID = 6;
    protected static final int APN_HIPRI_ID = 4;
    protected static final int APN_IMS_ID = 5;
    protected static final int APN_INVALID_ID = -1;
    protected static final int APN_MMS_ID = 1;
    protected static final int APN_NUM_TYPES = 8;
    protected static final String APN_RESTORE_DELAY_PROP_NAME = "android.telephony.apn-restore";
    protected static final int APN_SUPL_ID = 2;
    public static final String APN_TYPE_KEY = "apnType";
    protected static final int BASE = 0x42000;
    public static final int CMD_SET_DEPENDENCY_MET = 0x4201f;
    public static final int CMD_SET_POLICY_DATA_ENABLE = 0x42020;
    public static final int CMD_SET_USER_DATA_ENABLE = 0x4201d;
    protected static final int DATA_STALL_ALARM_AGGRESSIVE_DELAY_IN_MS_DEFAULT = 60000;
    protected static final int DATA_STALL_ALARM_NON_AGGRESSIVE_DELAY_IN_MS_DEFAULT = 0x57e40;
    protected static final String DATA_STALL_ALARM_TAG_EXTRA = "data.stall.alram.tag";
    protected static final int DATA_STALL_NO_RECV_POLL_LIMIT = 1;
    protected static final boolean DBG = true;
    protected static final String DEFALUT_DATA_ON_BOOT_PROP = "net.def_data_on_boot";
    protected static final String DEFAULT_DATA_RETRY_CONFIG = "default_randomization=2000,5000,10000,20000,40000,80000:5000,160000:5000,320000:5000,640000:5000,1280000:5000,1800000:5000";
    protected static final int DEFAULT_MAX_PDP_RESET_FAIL = 3;
    public static final int DISABLED = 0;
    public static final int ENABLED = 1;
    protected static final int EVENT_APN_CHANGED = 0x42013;
    protected static final int EVENT_CDMA_DATA_DETACHED = 0x42014;
    protected static final int EVENT_CDMA_OTA_PROVISION = 0x42019;
    protected static final int EVENT_CDMA_SUBSCRIPTION_SOURCE_CHANGED = 0x42015;
    public static final int EVENT_CLEAN_UP_ALL_CONNECTIONS = 0x4201e;
    public static final int EVENT_CLEAN_UP_CONNECTION = 0x42018;
    protected static final int EVENT_DATA_CONNECTION_ATTACHED = 0x42010;
    protected static final int EVENT_DATA_CONNECTION_DETACHED = 0x42009;
    protected static final int EVENT_DATA_SETUP_COMPLETE = 0x42000;
    protected static final int EVENT_DATA_STALL_ALARM = 0x42011;
    protected static final int EVENT_DATA_STATE_CHANGED = 0x42004;
    protected static final int EVENT_DISCONNECT_DONE = 0x4200f;
    protected static final int EVENT_DO_RECOVERY = 0x42012;
    protected static final int EVENT_ENABLE_NEW_APN = 0x4200d;
    protected static final int EVENT_LINK_STATE_CHANGED = 0x4200a;
    protected static final int EVENT_POLL_PDP = 0x42005;
    protected static final int EVENT_PS_RESTRICT_DISABLED = 0x42017;
    protected static final int EVENT_PS_RESTRICT_ENABLED = 0x42016;
    protected static final int EVENT_RADIO_AVAILABLE = 0x42001;
    protected static final int EVENT_RADIO_OFF_OR_NOT_AVAILABLE = 0x42006;
    protected static final int EVENT_RECORDS_LOADED = 0x42002;
    protected static final int EVENT_RESET_DONE = 0x4201c;
    protected static final int EVENT_RESTART_RADIO = 0x4201a;
    protected static final int EVENT_RESTORE_DEFAULT_APN = 0x4200e;
    protected static final int EVENT_ROAMING_OFF = 0x4200c;
    protected static final int EVENT_ROAMING_ON = 0x4200b;
    protected static final int EVENT_SET_INTERNAL_DATA_ENABLE = 0x4201b;
    protected static final int EVENT_TRY_SETUP_DATA = 0x42003;
    protected static final int EVENT_VOICE_CALL_ENDED = 0x42008;
    protected static final int EVENT_VOICE_CALL_STARTED = 0x42007;
    public static String EXTRA_MESSENGER = "EXTRA_MESSENGER";
    protected static final String FAIL_DATA_SETUP_COUNTER = "fail_data_setup_counter";
    protected static final String FAIL_DATA_SETUP_FAIL_CAUSE = "fail_data_setup_fail_cause";
    protected static final String INTENT_RECONNECT_ALARM_EXTRA_REASON = "reconnect_alarm_extra_reason";
    protected static final String INTENT_SET_FAIL_DATA_SETUP_COUNTER = "com.android.internal.telephony.dataconnectiontracker.intent_set_fail_data_setup_counter";
    protected static final int NO_RECV_POLL_LIMIT = 24;
    protected static final String NULL_IP = "0.0.0.0";
    protected static final int NUMBER_SENT_PACKETS_OF_HANG = 10;
    protected static final int POLL_LONGEST_RTT = 0x1d4c0;
    protected static final int POLL_NETSTAT_MILLIS = 1000;
    protected static final int POLL_NETSTAT_SCREEN_OFF_MILLIS = 0x927c0;
    protected static final int POLL_NETSTAT_SLOW_MILLIS = 5000;
    protected static final int RESTORE_DEFAULT_APN_DELAY = 60000;
    protected static final String SECONDARY_DATA_RETRY_CONFIG = "max_retries=3, 5000, 5000, 5000";
    protected static final boolean VDBG;
    protected static boolean sPolicyDataEnabled = true;
    private boolean dataEnabled[];
    private int enabledCount;
    protected ApnSetting mActiveApn;
    protected Activity mActivity;
    protected ArrayList mAllApns;
    protected ConcurrentHashMap mApnContexts;
    protected HashMap mApnToDataConnectionId;
    protected boolean mAutoAttachOnCreation;
    protected int mCidActive;
    protected HashMap mDataConnectionAsyncChannels;
    protected Handler mDataConnectionTracker;
    protected HashMap mDataConnections;
    protected Object mDataEnabledLock;
    private final DataRoamingSettingObserver mDataRoamingSettingObserver;
    protected PendingIntent mDataStallAlarmIntent;
    protected int mDataStallAlarmTag;
    protected TxRxSum mDataStallTxRxSum;
    protected int mFailDataSetupCounter;
    protected DataConnection.FailCause mFailDataSetupFailCause;
    protected BroadcastReceiver mIntentReceiver;
    protected boolean mInternalDataEnabled;
    protected boolean mIsDisposed;
    protected boolean mIsPsRestricted;
    protected boolean mIsScreenOn;
    protected boolean mIsWifiConnected;
    protected boolean mNetStatPollEnabled;
    protected int mNetStatPollPeriod;
    protected int mNoRecvPollCount;
    protected PhoneBase mPhone;
    protected ApnSetting mPreferredApn;
    protected PendingIntent mReconnectIntent;
    protected String mRequestedApnType;
    protected long mRxPkts;
    protected long mSentSinceLastRecv;
    protected State mState;
    protected long mTxPkts;
    protected AtomicInteger mUniqueIdGenerator;
    protected boolean mUserDataEnabled;

    static  {
        APN_DELAY_MILLIS = SystemProperties.getInt("persist.radio.apn_delay", 5000);
    }

}
