// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.os.*;
import android.telephony.*;
import android.util.Log;

// Referenced classes of package com.android.internal.telephony:
//            PhoneNotifier, Phone, ITelephonyRegistry, Call, 
//            Connection

public class DefaultPhoneNotifier
    implements PhoneNotifier {

    DefaultPhoneNotifier() {
        mRegistry = ITelephonyRegistry.Stub.asInterface(ServiceManager.getService("telephony.registry"));
    }

    public static int convertCallState(Phone.State state) {
        class _cls1 {

            static final int $SwitchMap$com$android$internal$telephony$Phone$DataActivityState[];
            static final int $SwitchMap$com$android$internal$telephony$Phone$DataState[];
            static final int $SwitchMap$com$android$internal$telephony$Phone$State[];

            static  {
                $SwitchMap$com$android$internal$telephony$Phone$DataActivityState = new int[Phone.DataActivityState.values().length];
                NoSuchFieldError nosuchfielderror8;
                try {
                    $SwitchMap$com$android$internal$telephony$Phone$DataActivityState[Phone.DataActivityState.DATAIN.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror) { }
                try {
                    $SwitchMap$com$android$internal$telephony$Phone$DataActivityState[Phone.DataActivityState.DATAOUT.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror1) { }
                try {
                    $SwitchMap$com$android$internal$telephony$Phone$DataActivityState[Phone.DataActivityState.DATAINANDOUT.ordinal()] = 3;
                }
                catch(NoSuchFieldError nosuchfielderror2) { }
                try {
                    $SwitchMap$com$android$internal$telephony$Phone$DataActivityState[Phone.DataActivityState.DORMANT.ordinal()] = 4;
                }
                catch(NoSuchFieldError nosuchfielderror3) { }
                $SwitchMap$com$android$internal$telephony$Phone$DataState = new int[Phone.DataState.values().length];
                try {
                    $SwitchMap$com$android$internal$telephony$Phone$DataState[Phone.DataState.CONNECTING.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror4) { }
                try {
                    $SwitchMap$com$android$internal$telephony$Phone$DataState[Phone.DataState.CONNECTED.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror5) { }
                try {
                    $SwitchMap$com$android$internal$telephony$Phone$DataState[Phone.DataState.SUSPENDED.ordinal()] = 3;
                }
                catch(NoSuchFieldError nosuchfielderror6) { }
                $SwitchMap$com$android$internal$telephony$Phone$State = new int[Phone.State.values().length];
                try {
                    $SwitchMap$com$android$internal$telephony$Phone$State[Phone.State.RINGING.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror7) { }
                $SwitchMap$com$android$internal$telephony$Phone$State[Phone.State.OFFHOOK.ordinal()] = 2;
_L2:
                return;
                nosuchfielderror8;
                if(true) goto _L2; else goto _L1
_L1:
            }
        }

        _cls1..SwitchMap.com.android.internal.telephony.Phone.State[state.ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 36
    //                   2 41;
           goto _L1 _L2 _L3
_L1:
        int i = 0;
_L5:
        return i;
_L2:
        i = 1;
        continue; /* Loop/switch isn't completed */
_L3:
        i = 2;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public static Phone.State convertCallState(int i) {
        i;
        JVM INSTR tableswitch 1 2: default 24
    //                   1 30
    //                   2 37;
           goto _L1 _L2 _L3
_L1:
        Phone.State state = Phone.State.IDLE;
_L5:
        return state;
_L2:
        state = Phone.State.RINGING;
        continue; /* Loop/switch isn't completed */
_L3:
        state = Phone.State.OFFHOOK;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public static int convertDataActivityState(Phone.DataActivityState dataactivitystate) {
        _cls1..SwitchMap.com.android.internal.telephony.Phone.DataActivityState[dataactivitystate.ordinal()];
        JVM INSTR tableswitch 1 4: default 40
    //                   1 44
    //                   2 49
    //                   3 54
    //                   4 59;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        int i = 0;
_L7:
        return i;
_L2:
        i = 1;
        continue; /* Loop/switch isn't completed */
_L3:
        i = 2;
        continue; /* Loop/switch isn't completed */
_L4:
        i = 3;
        continue; /* Loop/switch isn't completed */
_L5:
        i = 4;
        if(true) goto _L7; else goto _L6
_L6:
    }

    public static Phone.DataActivityState convertDataActivityState(int i) {
        i;
        JVM INSTR tableswitch 1 4: default 32
    //                   1 38
    //                   2 45
    //                   3 52
    //                   4 59;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        Phone.DataActivityState dataactivitystate = Phone.DataActivityState.NONE;
_L7:
        return dataactivitystate;
_L2:
        dataactivitystate = Phone.DataActivityState.DATAIN;
        continue; /* Loop/switch isn't completed */
_L3:
        dataactivitystate = Phone.DataActivityState.DATAOUT;
        continue; /* Loop/switch isn't completed */
_L4:
        dataactivitystate = Phone.DataActivityState.DATAINANDOUT;
        continue; /* Loop/switch isn't completed */
_L5:
        dataactivitystate = Phone.DataActivityState.DORMANT;
        if(true) goto _L7; else goto _L6
_L6:
    }

    public static int convertDataState(Phone.DataState datastate) {
        _cls1..SwitchMap.com.android.internal.telephony.Phone.DataState[datastate.ordinal()];
        JVM INSTR tableswitch 1 3: default 36
    //                   1 40
    //                   2 45
    //                   3 50;
           goto _L1 _L2 _L3 _L4
_L1:
        int i = 0;
_L6:
        return i;
_L2:
        i = 1;
        continue; /* Loop/switch isn't completed */
_L3:
        i = 2;
        continue; /* Loop/switch isn't completed */
_L4:
        i = 3;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public static Phone.DataState convertDataState(int i) {
        i;
        JVM INSTR tableswitch 1 3: default 28
    //                   1 34
    //                   2 41
    //                   3 48;
           goto _L1 _L2 _L3 _L4
_L1:
        Phone.DataState datastate = Phone.DataState.DISCONNECTED;
_L6:
        return datastate;
_L2:
        datastate = Phone.DataState.CONNECTING;
        continue; /* Loop/switch isn't completed */
_L3:
        datastate = Phone.DataState.CONNECTED;
        continue; /* Loop/switch isn't completed */
_L4:
        datastate = Phone.DataState.SUSPENDED;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private void doNotifyDataConnection(Phone phone, String s, String s1, Phone.DataState datastate) {
        TelephonyManager telephonymanager;
        android.net.LinkProperties linkproperties;
        android.net.LinkCapabilities linkcapabilities;
        boolean flag;
        telephonymanager = TelephonyManager.getDefault();
        linkproperties = null;
        linkcapabilities = null;
        flag = false;
        if(datastate == Phone.DataState.CONNECTED) {
            linkproperties = phone.getLinkProperties(s1);
            linkcapabilities = phone.getLinkCapabilities(s1);
        }
        ServiceState servicestate = phone.getServiceState();
        if(servicestate != null)
            flag = servicestate.getRoaming();
        ITelephonyRegistry itelephonyregistry;
        int i;
        boolean flag1;
        String s2;
        itelephonyregistry = mRegistry;
        i = convertDataState(datastate);
        flag1 = phone.isDataConnectivityPossible(s1);
        s2 = phone.getActiveApnHost(s1);
        if(telephonymanager == null) goto _L2; else goto _L1
_L1:
        int j = telephonymanager.getNetworkType();
_L3:
        itelephonyregistry.notifyDataConnection(i, flag1, s, s2, s1, linkproperties, linkcapabilities, j, flag);
_L4:
        return;
_L2:
        j = 0;
          goto _L3
        RemoteException remoteexception;
        remoteexception;
          goto _L4
    }

    private void log(String s) {
        Log.d("GSM", (new StringBuilder()).append("[PhoneNotifier] ").append(s).toString());
    }

    public void notifyCallForwardingChanged(Phone phone) {
        mRegistry.notifyCallForwardingChanged(phone.getCallForwardingIndicator());
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void notifyCellInfo(Phone phone, CellInfo cellinfo) {
        mRegistry.notifyCellInfo(cellinfo);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void notifyCellLocation(Phone phone) {
        Bundle bundle;
        bundle = new Bundle();
        phone.getCellLocation().fillInNotifierBundle(bundle);
        mRegistry.notifyCellLocation(bundle);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void notifyDataActivity(Phone phone) {
        mRegistry.notifyDataActivity(convertDataActivityState(phone.getDataActivityState()));
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void notifyDataConnection(Phone phone, String s, String s1, Phone.DataState datastate) {
        doNotifyDataConnection(phone, s, s1, datastate);
    }

    public void notifyDataConnectionFailed(Phone phone, String s, String s1) {
        mRegistry.notifyDataConnectionFailed(s, s1);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void notifyMessageWaitingChanged(Phone phone) {
        mRegistry.notifyMessageWaitingChanged(phone.getMessageWaitingIndicator());
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void notifyOtaspChanged(Phone phone, int i) {
        mRegistry.notifyOtaspChanged(i);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void notifyPhoneState(Phone phone) {
        String s;
        Call call = phone.getRingingCall();
        s = "";
        if(call != null && call.getEarliestConnection() != null)
            s = call.getEarliestConnection().getAddress();
        mRegistry.notifyCallState(convertCallState(phone.getState()), s);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void notifyServiceState(Phone phone) {
        ServiceState servicestate;
        servicestate = phone.getServiceState();
        if(servicestate == null) {
            servicestate = new ServiceState();
            servicestate.setStateOutOfService();
        }
        mRegistry.notifyServiceState(servicestate);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void notifySignalStrength(Phone phone) {
        mRegistry.notifySignalStrength(phone.getSignalStrength());
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private static final boolean DBG = true;
    static final String LOG_TAG = "GSM";
    private ITelephonyRegistry mRegistry;
}
