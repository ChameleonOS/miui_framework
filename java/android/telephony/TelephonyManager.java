// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.telephony;

import android.content.Context;
import android.content.res.Resources;
import android.os.*;
import com.android.internal.telephony.*;
import java.util.List;
import miui.telephony.ExtraTelephonyManager;

// Referenced classes of package android.telephony:
//            CellLocation, PhoneStateListener

public class TelephonyManager {
    static class Injector {

        static String getSimOperator(String s) {
            return ExtraTelephonyManager.getSimOperator(TelephonyManager.getContext());
        }

        Injector() {
        }
    }


    private TelephonyManager() {
    }

    public TelephonyManager(Context context) {
        if(sContext == null) {
            Context context1 = context.getApplicationContext();
            if(context1 != null)
                sContext = context1;
            else
                sContext = context;
            sRegistry = com.android.internal.telephony.ITelephonyRegistry.Stub.asInterface(ServiceManager.getService("telephony.registry"));
        }
    }

    public static TelephonyManager from(Context context) {
        return (TelephonyManager)context.getSystemService("phone");
    }

    static Context getContext() {
        return sContext;
    }

    public static TelephonyManager getDefault() {
        return sInstance;
    }

    private ITelephony getITelephony() {
        return com.android.internal.telephony.ITelephony.Stub.asInterface(ServiceManager.getService("phone"));
    }

    public static int getNetworkClass(int i) {
        i;
        JVM INSTR tableswitch 1 15: default 76
    //                   1 80
    //                   2 80
    //                   3 85
    //                   4 80
    //                   5 85
    //                   6 85
    //                   7 80
    //                   8 85
    //                   9 85
    //                   10 85
    //                   11 80
    //                   12 85
    //                   13 90
    //                   14 85
    //                   15 85;
           goto _L1 _L2 _L2 _L3 _L2 _L3 _L3 _L2 _L3 _L3 _L3 _L2 _L3 _L4 _L3 _L3
_L1:
        int j = 0;
_L6:
        return j;
_L2:
        j = 1;
        continue; /* Loop/switch isn't completed */
_L3:
        j = 2;
        continue; /* Loop/switch isn't completed */
_L4:
        j = 3;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public static String getNetworkTypeName(int i) {
        i;
        JVM INSTR tableswitch 1 15: default 76
    //                   1 81
    //                   2 87
    //                   3 93
    //                   4 117
    //                   5 123
    //                   6 129
    //                   7 141
    //                   8 99
    //                   9 105
    //                   10 111
    //                   11 159
    //                   12 135
    //                   13 147
    //                   14 153
    //                   15 165;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16
_L1:
        String s = "UNKNOWN";
_L18:
        return s;
_L2:
        s = "GPRS";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "EDGE";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "UMTS";
        continue; /* Loop/switch isn't completed */
_L9:
        s = "HSDPA";
        continue; /* Loop/switch isn't completed */
_L10:
        s = "HSUPA";
        continue; /* Loop/switch isn't completed */
_L11:
        s = "HSPA";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "CDMA";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "CDMA - EvDo rev. 0";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "CDMA - EvDo rev. A";
        continue; /* Loop/switch isn't completed */
_L13:
        s = "CDMA - EvDo rev. B";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "CDMA - 1xRTT";
        continue; /* Loop/switch isn't completed */
_L14:
        s = "LTE";
        continue; /* Loop/switch isn't completed */
_L15:
        s = "CDMA - eHRPD";
        continue; /* Loop/switch isn't completed */
_L12:
        s = "iDEN";
        continue; /* Loop/switch isn't completed */
_L16:
        s = "HSPA+";
        if(true) goto _L18; else goto _L17
_L17:
    }

    private int getPhoneTypeFromNetworkType() {
        int i = SystemProperties.getInt("ro.telephony.default_network", -1);
        int j;
        if(i == -1)
            j = 0;
        else
            j = PhoneFactory.getPhoneType(i);
        return j;
    }

    private int getPhoneTypeFromProperty() {
        return SystemProperties.getInt("gsm.current.phone-type", getPhoneTypeFromNetworkType());
    }

    private IPhoneSubInfo getSubscriberInfo() {
        return com.android.internal.telephony.IPhoneSubInfo.Stub.asInterface(ServiceManager.getService("iphonesubinfo"));
    }

    public void disableLocationUpdates() {
        getITelephony().disableLocationUpdates();
_L2:
        return;
        NullPointerException nullpointerexception;
        nullpointerexception;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void enableLocationUpdates() {
        getITelephony().enableLocationUpdates();
_L2:
        return;
        NullPointerException nullpointerexception;
        nullpointerexception;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public List getAllCellInfo() {
        List list = null;
        List list1 = getITelephony().getAllCellInfo();
        list = list1;
_L2:
        return list;
        RemoteException remoteexception;
        remoteexception;
        continue; /* Loop/switch isn't completed */
        NullPointerException nullpointerexception;
        nullpointerexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int getCallState() {
        int i = 0;
        int j = getITelephony().getCallState();
        i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        continue; /* Loop/switch isn't completed */
        NullPointerException nullpointerexception;
        nullpointerexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int getCdmaEriIconIndex() {
        int i = -1;
        int j = getITelephony().getCdmaEriIconIndex();
        i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        continue; /* Loop/switch isn't completed */
        NullPointerException nullpointerexception;
        nullpointerexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int getCdmaEriIconMode() {
        int i = -1;
        int j = getITelephony().getCdmaEriIconMode();
        i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        continue; /* Loop/switch isn't completed */
        NullPointerException nullpointerexception;
        nullpointerexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String getCdmaEriText() {
        String s = null;
        String s1 = getITelephony().getCdmaEriText();
        s = s1;
_L2:
        return s;
        RemoteException remoteexception;
        remoteexception;
        continue; /* Loop/switch isn't completed */
        NullPointerException nullpointerexception;
        nullpointerexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public CellLocation getCellLocation() {
        CellLocation celllocation;
        boolean flag;
        celllocation = CellLocation.newFromBundle(getITelephony().getCellLocation());
        flag = celllocation.isEmpty();
        if(flag)
            celllocation = null;
_L2:
        return celllocation;
        RemoteException remoteexception;
        remoteexception;
        celllocation = null;
        continue; /* Loop/switch isn't completed */
        NullPointerException nullpointerexception;
        nullpointerexception;
        celllocation = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String getCompleteVoiceMailNumber() {
        String s = null;
        String s1 = getSubscriberInfo().getCompleteVoiceMailNumber();
        s = s1;
_L2:
        return s;
        RemoteException remoteexception;
        remoteexception;
        continue; /* Loop/switch isn't completed */
        NullPointerException nullpointerexception;
        nullpointerexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int getCurrentPhoneType() {
        int i;
        int j;
        ITelephony itelephony = getITelephony();
        if(itelephony != null) {
            i = itelephony.getActivePhoneType();
            break MISSING_BLOCK_LABEL_49;
        }
        j = getPhoneTypeFromProperty();
        i = j;
        break MISSING_BLOCK_LABEL_49;
        RemoteException remoteexception;
        remoteexception;
        i = getPhoneTypeFromProperty();
        break MISSING_BLOCK_LABEL_49;
        NullPointerException nullpointerexception;
        nullpointerexception;
        i = getPhoneTypeFromProperty();
        return i;
    }

    public int getDataActivity() {
        int i = 0;
        int j = getITelephony().getDataActivity();
        i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        continue; /* Loop/switch isn't completed */
        NullPointerException nullpointerexception;
        nullpointerexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int getDataState() {
        int i = 0;
        int j = getITelephony().getDataState();
        i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        continue; /* Loop/switch isn't completed */
        NullPointerException nullpointerexception;
        nullpointerexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String getDeviceId() {
        String s = null;
        String s1 = getSubscriberInfo().getDeviceId();
        s = s1;
_L2:
        return s;
        RemoteException remoteexception;
        remoteexception;
        continue; /* Loop/switch isn't completed */
        NullPointerException nullpointerexception;
        nullpointerexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String getDeviceSoftwareVersion() {
        String s = null;
        String s1 = getSubscriberInfo().getDeviceSvn();
        s = s1;
_L2:
        return s;
        RemoteException remoteexception;
        remoteexception;
        continue; /* Loop/switch isn't completed */
        NullPointerException nullpointerexception;
        nullpointerexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String getIsimDomain() {
        String s = null;
        String s1 = getSubscriberInfo().getIsimDomain();
        s = s1;
_L2:
        return s;
        RemoteException remoteexception;
        remoteexception;
        continue; /* Loop/switch isn't completed */
        NullPointerException nullpointerexception;
        nullpointerexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String getIsimImpi() {
        String s = null;
        String s1 = getSubscriberInfo().getIsimImpi();
        s = s1;
_L2:
        return s;
        RemoteException remoteexception;
        remoteexception;
        continue; /* Loop/switch isn't completed */
        NullPointerException nullpointerexception;
        nullpointerexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String[] getIsimImpu() {
        String as[] = null;
        String as1[] = getSubscriberInfo().getIsimImpu();
        as = as1;
_L2:
        return as;
        RemoteException remoteexception;
        remoteexception;
        continue; /* Loop/switch isn't completed */
        NullPointerException nullpointerexception;
        nullpointerexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String getLine1AlphaTag() {
        String s = null;
        String s1 = getSubscriberInfo().getLine1AlphaTag();
        s = s1;
_L2:
        return s;
        RemoteException remoteexception;
        remoteexception;
        continue; /* Loop/switch isn't completed */
        NullPointerException nullpointerexception;
        nullpointerexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String getLine1Number() {
        String s = null;
        String s1 = getSubscriberInfo().getLine1Number();
        s = s1;
_L2:
        return s;
        RemoteException remoteexception;
        remoteexception;
        continue; /* Loop/switch isn't completed */
        NullPointerException nullpointerexception;
        nullpointerexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int getLteOnCdmaMode() {
        int i = -1;
        int j = getITelephony().getLteOnCdmaMode();
        i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        continue; /* Loop/switch isn't completed */
        NullPointerException nullpointerexception;
        nullpointerexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String getMsisdn() {
        String s = null;
        String s1 = getSubscriberInfo().getMsisdn();
        s = s1;
_L2:
        return s;
        RemoteException remoteexception;
        remoteexception;
        continue; /* Loop/switch isn't completed */
        NullPointerException nullpointerexception;
        nullpointerexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public List getNeighboringCellInfo() {
        List list = null;
        List list1 = getITelephony().getNeighboringCellInfo();
        list = list1;
_L2:
        return list;
        RemoteException remoteexception;
        remoteexception;
        continue; /* Loop/switch isn't completed */
        NullPointerException nullpointerexception;
        nullpointerexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String getNetworkCountryIso() {
        return SystemProperties.get("gsm.operator.iso-country");
    }

    public String getNetworkOperator() {
        return SystemProperties.get("gsm.operator.numeric");
    }

    public String getNetworkOperatorName() {
        return SystemProperties.get("gsm.operator.alpha");
    }

    public int getNetworkType() {
        int i = 0;
        int j;
        ITelephony itelephony = getITelephony();
        if(itelephony == null)
            break MISSING_BLOCK_LABEL_25;
        j = itelephony.getNetworkType();
        i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        continue; /* Loop/switch isn't completed */
        NullPointerException nullpointerexception;
        nullpointerexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String getNetworkTypeName() {
        return getNetworkTypeName(getNetworkType());
    }

    public int getPhoneType() {
        int i;
        if(!isVoiceCapable())
            i = 0;
        else
            i = getCurrentPhoneType();
        return i;
    }

    public String getSimCountryIso() {
        return SystemProperties.get("gsm.sim.operator.iso-country");
    }

    public String getSimOperator() {
        return Injector.getSimOperator(SystemProperties.get("gsm.sim.operator.numeric"));
    }

    public String getSimOperatorName() {
        return SystemProperties.get("gsm.sim.operator.alpha");
    }

    public String getSimSerialNumber() {
        String s = null;
        String s1 = getSubscriberInfo().getIccSerialNumber();
        s = s1;
_L2:
        return s;
        RemoteException remoteexception;
        remoteexception;
        continue; /* Loop/switch isn't completed */
        NullPointerException nullpointerexception;
        nullpointerexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int getSimState() {
        String s = SystemProperties.get("gsm.sim.state");
        int i;
        if("ABSENT".equals(s))
            i = 1;
        else
        if("PIN_REQUIRED".equals(s))
            i = 2;
        else
        if("PUK_REQUIRED".equals(s))
            i = 3;
        else
        if("NETWORK_LOCKED".equals(s))
            i = 4;
        else
        if("READY".equals(s))
            i = 5;
        else
            i = 0;
        return i;
    }

    public String getSubscriberId() {
        String s = null;
        String s1 = getSubscriberInfo().getSubscriberId();
        s = s1;
_L2:
        return s;
        RemoteException remoteexception;
        remoteexception;
        continue; /* Loop/switch isn't completed */
        NullPointerException nullpointerexception;
        nullpointerexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String getVoiceMailAlphaTag() {
        String s = null;
        String s1 = getSubscriberInfo().getVoiceMailAlphaTag();
        s = s1;
_L2:
        return s;
        RemoteException remoteexception;
        remoteexception;
        continue; /* Loop/switch isn't completed */
        NullPointerException nullpointerexception;
        nullpointerexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String getVoiceMailNumber() {
        String s = null;
        String s1 = getSubscriberInfo().getVoiceMailNumber();
        s = s1;
_L2:
        return s;
        RemoteException remoteexception;
        remoteexception;
        continue; /* Loop/switch isn't completed */
        NullPointerException nullpointerexception;
        nullpointerexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int getVoiceMessageCount() {
        int i = 0;
        int j = getITelephony().getVoiceMessageCount();
        i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        continue; /* Loop/switch isn't completed */
        NullPointerException nullpointerexception;
        nullpointerexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean hasIccCard() {
        boolean flag = false;
        boolean flag1 = getITelephony().hasIccCard();
        flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        continue; /* Loop/switch isn't completed */
        NullPointerException nullpointerexception;
        nullpointerexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean isNetworkRoaming() {
        return "true".equals(SystemProperties.get("gsm.operator.isroaming"));
    }

    public boolean isSmsCapable() {
        boolean flag;
        if(sContext == null)
            flag = true;
        else
            flag = sContext.getResources().getBoolean(0x1110029);
        return flag;
    }

    public boolean isVoiceCapable() {
        boolean flag;
        if(sContext == null)
            flag = true;
        else
            flag = sContext.getResources().getBoolean(0x1110028);
        return flag;
    }

    public void listen(PhoneStateListener phonestatelistener, int i) {
        String s;
        boolean flag;
        if(sContext != null)
            s = sContext.getPackageName();
        else
            s = "<unknown>";
        if(getITelephony() == null) goto _L2; else goto _L1
_L1:
        flag = true;
_L3:
        Boolean boolean1 = Boolean.valueOf(flag);
        sRegistry.listen(s, phonestatelistener.callback, i, boolean1.booleanValue());
_L4:
        return;
_L2:
        flag = false;
          goto _L3
        NullPointerException nullpointerexception;
        nullpointerexception;
          goto _L4
        RemoteException remoteexception;
        remoteexception;
          goto _L4
    }

    public static final String ACTION_PHONE_STATE_CHANGED = "android.intent.action.PHONE_STATE";
    public static final int CALL_STATE_IDLE = 0;
    public static final int CALL_STATE_OFFHOOK = 2;
    public static final int CALL_STATE_RINGING = 1;
    public static final int DATA_ACTIVITY_DORMANT = 4;
    public static final int DATA_ACTIVITY_IN = 1;
    public static final int DATA_ACTIVITY_INOUT = 3;
    public static final int DATA_ACTIVITY_NONE = 0;
    public static final int DATA_ACTIVITY_OUT = 2;
    public static final int DATA_CONNECTED = 2;
    public static final int DATA_CONNECTING = 1;
    public static final int DATA_DISCONNECTED = 0;
    public static final int DATA_SUSPENDED = 3;
    public static final int DATA_UNKNOWN = -1;
    public static final String EXTRA_INCOMING_NUMBER = "incoming_number";
    public static final String EXTRA_STATE = "state";
    public static final String EXTRA_STATE_IDLE;
    public static final String EXTRA_STATE_OFFHOOK;
    public static final String EXTRA_STATE_RINGING;
    public static final int NETWORK_CLASS_2_G = 1;
    public static final int NETWORK_CLASS_3_G = 2;
    public static final int NETWORK_CLASS_4_G = 3;
    public static final int NETWORK_CLASS_UNKNOWN = 0;
    public static final int NETWORK_TYPE_1xRTT = 7;
    public static final int NETWORK_TYPE_CDMA = 4;
    public static final int NETWORK_TYPE_EDGE = 2;
    public static final int NETWORK_TYPE_EHRPD = 14;
    public static final int NETWORK_TYPE_EVDO_0 = 5;
    public static final int NETWORK_TYPE_EVDO_A = 6;
    public static final int NETWORK_TYPE_EVDO_B = 12;
    public static final int NETWORK_TYPE_GPRS = 1;
    public static final int NETWORK_TYPE_HSDPA = 8;
    public static final int NETWORK_TYPE_HSPA = 10;
    public static final int NETWORK_TYPE_HSPAP = 15;
    public static final int NETWORK_TYPE_HSUPA = 9;
    public static final int NETWORK_TYPE_IDEN = 11;
    public static final int NETWORK_TYPE_LTE = 13;
    public static final int NETWORK_TYPE_UMTS = 3;
    public static final int NETWORK_TYPE_UNKNOWN = 0;
    public static final int PHONE_TYPE_CDMA = 2;
    public static final int PHONE_TYPE_GSM = 1;
    public static final int PHONE_TYPE_NONE = 0;
    public static final int PHONE_TYPE_SIP = 3;
    public static final int SIM_STATE_ABSENT = 1;
    public static final int SIM_STATE_NETWORK_LOCKED = 4;
    public static final int SIM_STATE_PIN_REQUIRED = 2;
    public static final int SIM_STATE_PUK_REQUIRED = 3;
    public static final int SIM_STATE_READY = 5;
    public static final int SIM_STATE_UNKNOWN = 0;
    private static final String TAG = "TelephonyManager";
    private static Context sContext;
    private static TelephonyManager sInstance = new TelephonyManager();
    private static ITelephonyRegistry sRegistry;

    static  {
        EXTRA_STATE_IDLE = com.android.internal.telephony.Phone.State.IDLE.toString();
        EXTRA_STATE_RINGING = com.android.internal.telephony.Phone.State.RINGING.toString();
        EXTRA_STATE_OFFHOOK = com.android.internal.telephony.Phone.State.OFFHOOK.toString();
    }
}
