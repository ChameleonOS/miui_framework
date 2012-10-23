// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cdma;

import android.content.*;
import android.database.SQLException;
import android.net.Uri;
import android.os.AsyncResult;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;
import com.android.internal.telephony.*;
import com.android.internal.telephony.gsm.GsmSMSDispatcher;
import com.android.internal.telephony.gsm.SmsMessage;
import com.android.internal.telephony.ims.IsimRecords;
import com.android.internal.telephony.uicc.UiccController;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.android.internal.telephony.cdma:
//            CDMAPhone, CdmaCallTracker, CdmaServiceStateTracker, CdmaLteServiceStateTracker

public class CDMALTEPhone extends CDMAPhone {
    private static class NetworkSelectMessage {

        public Message message;
        public String operatorAlphaLong;
        public String operatorNumeric;

        private NetworkSelectMessage() {
        }

    }


    public CDMALTEPhone(Context context, CommandsInterface commandsinterface, PhoneNotifier phonenotifier) {
        super(context, commandsinterface, phonenotifier, false);
        m3gppSMS = new GsmSMSDispatcher(this, super.mSmsStorageMonitor, super.mSmsUsageMonitor);
        super.mIccRecords.registerForNewSms(this, 29, null);
    }

    private void handleSetSelectNetwork(AsyncResult asyncresult) {
        if(asyncresult.userObj instanceof NetworkSelectMessage) goto _L2; else goto _L1
_L1:
        Log.e("CDMA", "unexpected result from user object.");
_L4:
        return;
_L2:
        NetworkSelectMessage networkselectmessage = (NetworkSelectMessage)asyncresult.userObj;
        if(networkselectmessage.message != null) {
            log("sending original message to recipient");
            AsyncResult.forMessage(networkselectmessage.message, asyncresult.result, asyncresult.exception);
            networkselectmessage.message.sendToTarget();
        }
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(getContext()).edit();
        editor.putString("network_selection_key", networkselectmessage.operatorNumeric);
        editor.putString("network_selection_name_key", networkselectmessage.operatorAlphaLong);
        if(!editor.commit())
            Log.e("CDMA", "failed to commit network selection preference");
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void dispose() {
        Object obj = PhoneProxy.lockForRadioTechnologyChange;
        obj;
        JVM INSTR monitorenter ;
        super.dispose();
        m3gppSMS.dispose();
        super.mIccRecords.unregisterForNewSms(this);
        return;
    }

    public void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        printwriter.println("CDMALTEPhone extends:");
        super.dump(filedescriptor, printwriter, as);
        printwriter.println((new StringBuilder()).append(" m3gppSMS=").append(m3gppSMS).toString());
    }

    public void getAvailableNetworks(Message message) {
        super.mCM.getAvailableNetworks(message);
    }

    public com.android.internal.telephony.Phone.DataState getDataConnectionState(String s) {
        com.android.internal.telephony.Phone.DataState datastate = com.android.internal.telephony.Phone.DataState.DISCONNECTED;
        if(super.mSST != null) goto _L2; else goto _L1
_L1:
        datastate = com.android.internal.telephony.Phone.DataState.DISCONNECTED;
_L4:
        log((new StringBuilder()).append("getDataConnectionState apnType=").append(s).append(" ret=").append(datastate).toString());
        return datastate;
_L2:
        if(super.mDataConnectionTracker.isApnTypeEnabled(s))
            break; /* Loop/switch isn't completed */
        datastate = com.android.internal.telephony.Phone.DataState.DISCONNECTED;
        if(true) goto _L4; else goto _L3
_L3:
        class _cls1 {

            static final int $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[];

            static  {
                $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State = new int[com.android.internal.telephony.DataConnectionTracker.State.values().length];
                NoSuchFieldError nosuchfielderror6;
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[com.android.internal.telephony.DataConnectionTracker.State.FAILED.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[com.android.internal.telephony.DataConnectionTracker.State.IDLE.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror1) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[com.android.internal.telephony.DataConnectionTracker.State.CONNECTED.ordinal()] = 3;
                }
                catch(NoSuchFieldError nosuchfielderror2) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[com.android.internal.telephony.DataConnectionTracker.State.DISCONNECTING.ordinal()] = 4;
                }
                catch(NoSuchFieldError nosuchfielderror3) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[com.android.internal.telephony.DataConnectionTracker.State.INITING.ordinal()] = 5;
                }
                catch(NoSuchFieldError nosuchfielderror4) { }
                try {
                    $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[com.android.internal.telephony.DataConnectionTracker.State.CONNECTING.ordinal()] = 6;
                }
                catch(NoSuchFieldError nosuchfielderror5) { }
                $SwitchMap$com$android$internal$telephony$DataConnectionTracker$State[com.android.internal.telephony.DataConnectionTracker.State.SCANNING.ordinal()] = 7;
_L2:
                return;
                nosuchfielderror6;
                if(true) goto _L2; else goto _L1
_L1:
            }
        }

        switch(_cls1..SwitchMap.com.android.internal.telephony.DataConnectionTracker.State[super.mDataConnectionTracker.getState(s).ordinal()]) {
        case 1: // '\001'
        case 2: // '\002'
            datastate = com.android.internal.telephony.Phone.DataState.DISCONNECTED;
            break;

        case 3: // '\003'
        case 4: // '\004'
            if(super.mCT.state != com.android.internal.telephony.Phone.State.IDLE && !super.mSST.isConcurrentVoiceAndDataAllowed())
                datastate = com.android.internal.telephony.Phone.DataState.SUSPENDED;
            else
                datastate = com.android.internal.telephony.Phone.DataState.CONNECTED;
            break;

        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
            datastate = com.android.internal.telephony.Phone.DataState.CONNECTING;
            break;
        }
        if(true) goto _L4; else goto _L5
_L5:
    }

    public String getDeviceSvn() {
        return super.mImeiSv;
    }

    public String getImei() {
        return super.mImei;
    }

    public IsimRecords getIsimRecords() {
        return super.mIccRecords.getIsimRecords();
    }

    public String getMsisdn() {
        return super.mIccRecords.getMsisdnNumber();
    }

    public String getSubscriberId() {
        return super.mIccRecords.getIMSI();
    }

    public void handleMessage(Message message) {
        message.what;
        JVM INSTR lookupswitch 2: default 32
    //                   16: 38
    //                   29: 52;
           goto _L1 _L2 _L3
_L1:
        super.handleMessage(message);
_L5:
        return;
_L2:
        handleSetSelectNetwork((AsyncResult)message.obj);
        continue; /* Loop/switch isn't completed */
_L3:
        AsyncResult asyncresult = (AsyncResult)message.obj;
        m3gppSMS.dispatchMessage((SmsMessage)asyncresult.result);
        if(true) goto _L5; else goto _L4
_L4:
    }

    protected void initSstIcc() {
        super.mIccCard.set(UiccController.getInstance(this).getIccCard());
        super.mIccRecords = ((IccCard)super.mIccCard.get()).getIccRecords();
        super.mSST = new CdmaLteServiceStateTracker(this);
    }

    protected void log(String s) {
        Log.d("CDMA", (new StringBuilder()).append("[CDMALTEPhone] ").append(s).toString());
    }

    public void removeReferences() {
        super.removeReferences();
        m3gppSMS = null;
    }

    public void requestIsimAuthentication(String s, Message message) {
        super.mCM.requestIsimAuthentication(s, message);
    }

    public void selectNetworkManually(OperatorInfo operatorinfo, Message message) {
        NetworkSelectMessage networkselectmessage = new NetworkSelectMessage(null);
        networkselectmessage.message = message;
        networkselectmessage.operatorNumeric = operatorinfo.getOperatorNumeric();
        networkselectmessage.operatorAlphaLong = operatorinfo.getOperatorAlphaLong();
        Message message1 = obtainMessage(16, networkselectmessage);
        super.mCM.setNetworkSelectionModeManual(operatorinfo.getOperatorNumeric(), message1);
    }

    public boolean updateCurrentCarrierInProvider() {
        if(super.mIccRecords == null) goto _L2; else goto _L1
_L1:
        Uri uri = Uri.withAppendedPath(android.provider.Telephony.Carriers.CONTENT_URI, "current");
        ContentValues contentvalues = new ContentValues();
        String s = super.mIccRecords.getOperatorNumeric();
        contentvalues.put("numeric", s);
        log((new StringBuilder()).append("updateCurrentCarrierInProvider from UICC: numeric=").append(s).toString());
        super.mContext.getContentResolver().insert(uri, contentvalues);
        boolean flag = true;
_L3:
        return flag;
        SQLException sqlexception;
        sqlexception;
        Log.e("CDMA", "[CDMALTEPhone] Can't store current operator ret false", sqlexception);
_L4:
        flag = false;
        if(true) goto _L3; else goto _L2
_L2:
        log("updateCurrentCarrierInProvider mIccRecords == null ret false");
          goto _L4
    }

    private static final boolean DBG = true;
    static final String LOG_TAG = "CDMA";
    SMSDispatcher m3gppSMS;
}
