// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.content.*;
import android.os.*;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Slog;
import com.android.internal.telephony.DataConnectionTracker;
import com.android.internal.telephony.ITelephony;
import com.android.internal.util.AsyncChannel;
import java.io.CharArrayWriter;
import java.io.PrintWriter;

// Referenced classes of package android.net:
//            NetworkStateTracker, NetworkInfo, LinkCapabilities, LinkProperties

public class MobileDataStateTracker
    implements NetworkStateTracker {
    private class MobileDataStateReceiver extends BroadcastReceiver {

        public void onReceive(Context context, Intent intent) {
            if(!intent.getAction().equals("android.intent.action.ANY_DATA_STATE")) goto _L2; else goto _L1
_L1:
            if(TextUtils.equals(intent.getStringExtra("apnType"), mApnType)) goto _L4; else goto _L3
_L3:
            return;
_L4:
            mNetworkInfo.setSubtype(TelephonyManager.getDefault().getNetworkType(), TelephonyManager.getDefault().getNetworkTypeName());
            com.android.internal.telephony.Phone.DataState datastate = (com.android.internal.telephony.Phone.DataState)Enum.valueOf(com/android/internal/telephony/Phone$DataState, intent.getStringExtra("state"));
            String s2 = intent.getStringExtra("reason");
            String s3 = intent.getStringExtra("apn");
            mNetworkInfo.setRoaming(intent.getBooleanExtra("networkRoaming", false));
            NetworkInfo networkinfo = mNetworkInfo;
            boolean flag;
            if(!intent.getBooleanExtra("networkUnvailable", false))
                flag = true;
            else
                flag = false;
            networkinfo.setIsAvailable(flag);
            if(mMobileDataState != datastate) {
                mMobileDataState = datastate;
                class _cls1 {

                    static final int $SwitchMap$com$android$internal$telephony$Phone$DataState[];

                    static  {
                        $SwitchMap$com$android$internal$telephony$Phone$DataState = new int[com.android.internal.telephony.Phone.DataState.values().length];
                        NoSuchFieldError nosuchfielderror3;
                        try {
                            $SwitchMap$com$android$internal$telephony$Phone$DataState[com.android.internal.telephony.Phone.DataState.DISCONNECTED.ordinal()] = 1;
                        }
                        catch(NoSuchFieldError nosuchfielderror) { }
                        try {
                            $SwitchMap$com$android$internal$telephony$Phone$DataState[com.android.internal.telephony.Phone.DataState.CONNECTING.ordinal()] = 2;
                        }
                        catch(NoSuchFieldError nosuchfielderror1) { }
                        try {
                            $SwitchMap$com$android$internal$telephony$Phone$DataState[com.android.internal.telephony.Phone.DataState.SUSPENDED.ordinal()] = 3;
                        }
                        catch(NoSuchFieldError nosuchfielderror2) { }
                        $SwitchMap$com$android$internal$telephony$Phone$DataState[com.android.internal.telephony.Phone.DataState.CONNECTED.ordinal()] = 4;
_L2:
                        return;
                        nosuchfielderror3;
                        if(true) goto _L2; else goto _L1
_L1:
                    }
                }

                switch(_cls1..SwitchMap.com.android.internal.telephony.Phone.DataState[datastate.ordinal()]) {
                case 1: // '\001'
                    if(isTeardownRequested())
                        setTeardownRequested(false);
                    setDetailedState(NetworkInfo.DetailedState.DISCONNECTED, s2, s3);
                    break;

                case 2: // '\002'
                    setDetailedState(NetworkInfo.DetailedState.CONNECTING, s2, s3);
                    break;

                case 3: // '\003'
                    setDetailedState(NetworkInfo.DetailedState.SUSPENDED, s2, s3);
                    break;

                case 4: // '\004'
                    mLinkProperties = (LinkProperties)intent.getParcelableExtra("linkProperties");
                    if(mLinkProperties == null) {
                        loge("CONNECTED event did not supply link properties.");
                        mLinkProperties = new LinkProperties();
                    }
                    mLinkCapabilities = (LinkCapabilities)intent.getParcelableExtra("linkCapabilities");
                    if(mLinkCapabilities == null) {
                        loge("CONNECTED event did not supply link capabilities.");
                        mLinkCapabilities = new LinkCapabilities();
                    }
                    setDetailedState(NetworkInfo.DetailedState.CONNECTED, s2, s3);
                    break;
                }
            } else
            if(TextUtils.equals(s2, "linkPropertiesChanged")) {
                mLinkProperties = (LinkProperties)intent.getParcelableExtra("linkProperties");
                if(mLinkProperties == null) {
                    loge("No link property in LINK_PROPERTIES change event.");
                    mLinkProperties = new LinkProperties();
                }
                mNetworkInfo.setDetailedState(mNetworkInfo.getDetailedState(), s2, mNetworkInfo.getExtraInfo());
                mTarget.obtainMessage(3, mNetworkInfo).sendToTarget();
            }
            continue; /* Loop/switch isn't completed */
_L2:
            if(intent.getAction().equals("android.intent.action.DATA_CONNECTION_FAILED")) {
                if(TextUtils.equals(intent.getStringExtra("apnType"), mApnType)) {
                    String s = intent.getStringExtra("reason");
                    String s1 = intent.getStringExtra("apn");
                    setDetailedState(NetworkInfo.DetailedState.FAILED, s, s1);
                }
            } else
            if(intent.getAction().equals(DataConnectionTracker.ACTION_DATA_CONNECTION_TRACKER_MESSENGER)) {
                mMessenger = (Messenger)intent.getParcelableExtra(DataConnectionTracker.EXTRA_MESSENGER);
                (new AsyncChannel()).connect(mContext, mHandler, mMessenger);
            }
            if(true) goto _L3; else goto _L5
_L5:
        }

        final MobileDataStateTracker this$0;

        private MobileDataStateReceiver() {
            this$0 = MobileDataStateTracker.this;
            super();
        }

    }

    static class MdstHandler extends Handler {

        public void handleMessage(Message message) {
            message.what;
            JVM INSTR lookupswitch 2: default 32
        //                       69632: 33
        //                       69636: 58;
               goto _L1 _L2 _L3
_L1:
            return;
_L2:
            if(message.arg1 == 0)
                mMdst.mDataConnectionTrackerAc = (AsyncChannel)message.obj;
            continue; /* Loop/switch isn't completed */
_L3:
            mMdst.mDataConnectionTrackerAc = null;
            if(true) goto _L1; else goto _L4
_L4:
        }

        private MobileDataStateTracker mMdst;

        MdstHandler(Looper looper, MobileDataStateTracker mobiledatastatetracker) {
            super(looper);
            mMdst = mobiledatastatetracker;
        }
    }


    public MobileDataStateTracker(int i, String s) {
        mTeardownRequested = false;
        mPrivateDnsRouteSet = false;
        mDefaultRouteSet = false;
        mUserDataEnabled = true;
        mPolicyDataEnabled = true;
        mNetworkInfo = new NetworkInfo(i, TelephonyManager.getDefault().getNetworkType(), s, TelephonyManager.getDefault().getNetworkTypeName());
        mApnType = networkTypeToApnType(i);
    }

    private void getPhoneService(boolean flag) {
        if(mPhoneService == null || flag)
            mPhoneService = com.android.internal.telephony.ITelephony.Stub.asInterface(ServiceManager.getService("phone"));
    }

    private void log(String s) {
        Slog.d("MobileDataStateTracker", (new StringBuilder()).append(mApnType).append(": ").append(s).toString());
    }

    private void loge(String s) {
        Slog.e("MobileDataStateTracker", (new StringBuilder()).append(mApnType).append(": ").append(s).toString());
    }

    public static String networkTypeToApnType(int i) {
        i;
        JVM INSTR tableswitch 0 12: default 68
    //                   0 99
    //                   1 68
    //                   2 105
    //                   3 111
    //                   4 117
    //                   5 123
    //                   6 68
    //                   7 68
    //                   8 68
    //                   9 68
    //                   10 129
    //                   11 135
    //                   12 141;
           goto _L1 _L2 _L1 _L3 _L4 _L5 _L6 _L1 _L1 _L1 _L1 _L7 _L8 _L9
_L1:
        String s;
        sloge((new StringBuilder()).append("Error mapping networkType ").append(i).append(" to apnType.").toString());
        s = null;
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
        s = "fota";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "ims";
        continue; /* Loop/switch isn't completed */
_L9:
        s = "cbs";
        if(true) goto _L11; else goto _L10
_L10:
    }

    private void setDetailedState(NetworkInfo.DetailedState detailedstate, String s, String s1) {
        if(detailedstate != mNetworkInfo.getDetailedState()) {
            boolean flag;
            String s2;
            if(mNetworkInfo.getState() == NetworkInfo.State.CONNECTING)
                flag = true;
            else
                flag = false;
            s2 = mNetworkInfo.getReason();
            if(flag && detailedstate == NetworkInfo.DetailedState.CONNECTED && s == null && s2 != null)
                s = s2;
            mNetworkInfo.setDetailedState(detailedstate, s, s1);
            mTarget.obtainMessage(1, new NetworkInfo(mNetworkInfo)).sendToTarget();
        }
    }

    private int setEnableApn(String s, boolean flag) {
        int i;
        getPhoneService(false);
        i = 0;
_L2:
label0:
        {
            {
                if(i < 2) {
                    if(mPhoneService != null)
                        break label0;
                    loge("Ignoring feature request because could not acquire PhoneService");
                }
                StringBuilder stringbuilder = (new StringBuilder()).append("Could not ");
                String s1;
                int j;
                RemoteException remoteexception;
                int k;
                if(flag)
                    s1 = "enable";
                else
                    s1 = "disable";
                loge(stringbuilder.append(s1).append(" APN type \"").append(s).append("\"").toString());
                j = 3;
            }
            return j;
        }
        if(!flag)
            break MISSING_BLOCK_LABEL_105;
        j = mPhoneService.enableApnType(s);
        break MISSING_BLOCK_LABEL_83;
        k = mPhoneService.disableApnType(s);
        j = k;
        if(false)
            ;
        else
            break MISSING_BLOCK_LABEL_83;
        remoteexception;
        if(i == 0)
            getPhoneService(true);
        i++;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private static void sloge(String s) {
        Slog.e("MobileDataStateTracker", s);
    }

    public void defaultRouteSet(boolean flag) {
        mDefaultRouteSet = flag;
    }

    public LinkCapabilities getLinkCapabilities() {
        return new LinkCapabilities(mLinkCapabilities);
    }

    public LinkProperties getLinkProperties() {
        return new LinkProperties(mLinkProperties);
    }

    public NetworkInfo getNetworkInfo() {
        return mNetworkInfo;
    }

    public String getTcpBufferSizesPropName() {
        String s;
        TelephonyManager telephonymanager;
        s = "unknown";
        telephonymanager = new TelephonyManager(mContext);
        telephonymanager.getNetworkType();
        JVM INSTR tableswitch 1 14: default 92
    //                   1 140
    //                   2 147
    //                   3 154
    //                   4 182
    //                   5 196
    //                   6 203
    //                   7 189
    //                   8 161
    //                   9 168
    //                   10 175
    //                   11 217
    //                   12 210
    //                   13 224
    //                   14 231;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L1:
        loge((new StringBuilder()).append("unknown network type: ").append(telephonymanager.getNetworkType()).toString());
_L17:
        return (new StringBuilder()).append("net.tcp.buffersize.").append(s).toString();
_L2:
        s = "gprs";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "edge";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "umts";
        continue; /* Loop/switch isn't completed */
_L9:
        s = "hsdpa";
        continue; /* Loop/switch isn't completed */
_L10:
        s = "hsupa";
        continue; /* Loop/switch isn't completed */
_L11:
        s = "hspa";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "cdma";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "1xrtt";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "evdo";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "evdo";
        continue; /* Loop/switch isn't completed */
_L13:
        s = "evdo";
        continue; /* Loop/switch isn't completed */
_L12:
        s = "iden";
        continue; /* Loop/switch isn't completed */
_L14:
        s = "lte";
        continue; /* Loop/switch isn't completed */
_L15:
        s = "ehrpd";
        if(true) goto _L17; else goto _L16
_L16:
    }

    public boolean isAvailable() {
        return mNetworkInfo.isAvailable();
    }

    public boolean isDefaultRouteSet() {
        return mDefaultRouteSet;
    }

    public boolean isPrivateDnsRouteSet() {
        return mPrivateDnsRouteSet;
    }

    public boolean isTeardownRequested() {
        return mTeardownRequested;
    }

    public void privateDnsRouteSet(boolean flag) {
        mPrivateDnsRouteSet = flag;
    }

    public boolean reconnect() {
        boolean flag;
        flag = false;
        setTeardownRequested(false);
        setEnableApn(mApnType, true);
        JVM INSTR tableswitch 0 3: default 48
    //                   0 57
    //                   1 62
    //                   2 55
    //                   3 55;
           goto _L1 _L2 _L3 _L4 _L4
_L4:
        break; /* Loop/switch isn't completed */
_L1:
        loge("Error in reconnect - unexpected response.");
_L6:
        return flag;
_L2:
        flag = true;
        continue; /* Loop/switch isn't completed */
_L3:
        mNetworkInfo.setDetailedState(NetworkInfo.DetailedState.IDLE, null, null);
        flag = true;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public void releaseWakeLock() {
    }

    public void setDependencyMet(boolean flag) {
        Bundle bundle = Bundle.forPair("apnType", mApnType);
        Message message;
        message = Message.obtain();
        message.what = 0x4201f;
        if(!flag) goto _L2; else goto _L1
_L1:
        int i = 1;
_L3:
        message.arg1 = i;
        message.setData(bundle);
        mDataConnectionTrackerAc.sendMessage(message);
_L4:
        return;
_L2:
        i = 0;
          goto _L3
        NullPointerException nullpointerexception;
        nullpointerexception;
        loge((new StringBuilder()).append("setDependencyMet: X mAc was null").append(nullpointerexception).toString());
          goto _L4
    }

    public void setPolicyDataEnable(boolean flag) {
        AsyncChannel asyncchannel = mDataConnectionTrackerAc;
        if(asyncchannel != null) {
            int i;
            if(flag)
                i = 1;
            else
                i = 0;
            asyncchannel.sendMessage(0x42020, i);
            mPolicyDataEnabled = flag;
        }
    }

    public boolean setRadio(boolean flag) {
        int i;
        getPhoneService(false);
        i = 0;
_L2:
label0:
        {
            {
                if(i < 2) {
                    if(mPhoneService != null)
                        break label0;
                    loge("Ignoring mobile radio request because could not acquire PhoneService");
                }
                StringBuilder stringbuilder = (new StringBuilder()).append("Could not set radio power to ");
                String s;
                boolean flag1;
                RemoteException remoteexception;
                boolean flag2;
                if(flag)
                    s = "on";
                else
                    s = "off";
                loge(stringbuilder.append(s).toString());
                flag1 = false;
            }
            return flag1;
        }
        flag2 = mPhoneService.setRadio(flag);
        flag1 = flag2;
        if(false)
            ;
        else
            break MISSING_BLOCK_LABEL_65;
        remoteexception;
        if(i == 0)
            getPhoneService(true);
        i++;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void setTeardownRequested(boolean flag) {
        mTeardownRequested = flag;
    }

    public void setUserDataEnable(boolean flag) {
        AsyncChannel asyncchannel = mDataConnectionTrackerAc;
        if(asyncchannel != null) {
            int i;
            if(flag)
                i = 1;
            else
                i = 0;
            asyncchannel.sendMessage(0x4201d, i);
            mUserDataEnabled = flag;
        }
    }

    public void startMonitoring(Context context, Handler handler) {
        mTarget = handler;
        mContext = context;
        mHandler = new MdstHandler(handler.getLooper(), this);
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.intent.action.ANY_DATA_STATE");
        intentfilter.addAction("android.intent.action.DATA_CONNECTION_FAILED");
        intentfilter.addAction(DataConnectionTracker.ACTION_DATA_CONNECTION_TRACKER_MESSENGER);
        mContext.registerReceiver(new MobileDataStateReceiver(null), intentfilter);
        mMobileDataState = com.android.internal.telephony.Phone.DataState.DISCONNECTED;
    }

    public boolean teardown() {
        boolean flag = true;
        setTeardownRequested(flag);
        if(setEnableApn(mApnType, false) == 3)
            flag = false;
        return flag;
    }

    public String toString() {
        CharArrayWriter chararraywriter = new CharArrayWriter();
        PrintWriter printwriter = new PrintWriter(chararraywriter);
        printwriter.print("Mobile data state: ");
        printwriter.println(mMobileDataState);
        printwriter.print("Data enabled: user=");
        printwriter.print(mUserDataEnabled);
        printwriter.print(", policy=");
        printwriter.println(mPolicyDataEnabled);
        return chararraywriter.toString();
    }

    private static final boolean DBG = false;
    private static final String TAG = "MobileDataStateTracker";
    private static final boolean VDBG;
    private String mApnType;
    private Context mContext;
    private AsyncChannel mDataConnectionTrackerAc;
    private boolean mDefaultRouteSet;
    private Handler mHandler;
    private LinkCapabilities mLinkCapabilities;
    private LinkProperties mLinkProperties;
    private Messenger mMessenger;
    private com.android.internal.telephony.Phone.DataState mMobileDataState;
    private NetworkInfo mNetworkInfo;
    private ITelephony mPhoneService;
    protected boolean mPolicyDataEnabled;
    private boolean mPrivateDnsRouteSet;
    private Handler mTarget;
    private boolean mTeardownRequested;
    protected boolean mUserDataEnabled;



/*
    static Messenger access$1002(MobileDataStateTracker mobiledatastatetracker, Messenger messenger) {
        mobiledatastatetracker.mMessenger = messenger;
        return messenger;
    }

*/


/*
    static AsyncChannel access$102(MobileDataStateTracker mobiledatastatetracker, AsyncChannel asyncchannel) {
        mobiledatastatetracker.mDataConnectionTrackerAc = asyncchannel;
        return asyncchannel;
    }

*/







/*
    static com.android.internal.telephony.Phone.DataState access$402(MobileDataStateTracker mobiledatastatetracker, com.android.internal.telephony.Phone.DataState datastate) {
        mobiledatastatetracker.mMobileDataState = datastate;
        return datastate;
    }

*/




/*
    static LinkProperties access$602(MobileDataStateTracker mobiledatastatetracker, LinkProperties linkproperties) {
        mobiledatastatetracker.mLinkProperties = linkproperties;
        return linkproperties;
    }

*/




/*
    static LinkCapabilities access$802(MobileDataStateTracker mobiledatastatetracker, LinkCapabilities linkcapabilities) {
        mobiledatastatetracker.mLinkCapabilities = linkcapabilities;
        return linkcapabilities;
    }

*/

}
