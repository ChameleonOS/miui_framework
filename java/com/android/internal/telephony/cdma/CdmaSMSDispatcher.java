// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cdma;

import android.app.PendingIntent;
import android.content.*;
import android.content.res.Resources;
import android.os.*;
import android.preference.PreferenceManager;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import com.android.internal.telephony.*;
import com.android.internal.telephony.cdma.sms.BearerData;
import com.android.internal.telephony.cdma.sms.CdmaSmsAddress;
import com.android.internal.telephony.cdma.sms.UserData;
import java.io.*;
import java.util.*;

// Referenced classes of package com.android.internal.telephony.cdma:
//            SmsMessage, CDMAPhone

final class CdmaSMSDispatcher extends SMSDispatcher {

    CdmaSMSDispatcher(CDMAPhone cdmaphone, SmsStorageMonitor smsstoragemonitor, SmsUsageMonitor smsusagemonitor) {
        super(cdmaphone, smsstoragemonitor, smsusagemonitor);
        super.mCm.setOnNewCdmaSms(this, 1, null);
    }

    private static boolean checkDuplicatePortOmadmWappush(byte abyte0[], int i) {
        boolean flag;
        WspTypeDecoder wsptypedecoder;
        flag = false;
        int j = i + 4;
        byte abyte1[] = new byte[abyte0.length - j];
        System.arraycopy(abyte0, j, abyte1, 0, abyte1.length);
        wsptypedecoder = new WspTypeDecoder(abyte1);
        break MISSING_BLOCK_LABEL_36;
        while(true)  {
            do
                return flag;
            while(!wsptypedecoder.decodeUintvarInteger(2) || !wsptypedecoder.decodeContentType(2 + wsptypedecoder.getDecodedDataLength()));
            String s = wsptypedecoder.getValueString();
            if(s != null && s.equals("application/vnd.syncml.notification"))
                flag = true;
        }
    }

    private void handleCdmaStatusReport(SmsMessage smsmessage) {
        int i;
        int j;
        i = 0;
        j = super.deliveryPendingList.size();
_L5:
        if(i >= j) goto _L2; else goto _L1
_L1:
        com.android.internal.telephony.SMSDispatcher.SmsTracker smstracker = (com.android.internal.telephony.SMSDispatcher.SmsTracker)super.deliveryPendingList.get(i);
        if(smstracker.mMessageRef != ((SmsMessageBase) (smsmessage)).messageRef) goto _L4; else goto _L3
_L3:
        PendingIntent pendingintent;
        Intent intent;
        super.deliveryPendingList.remove(i);
        pendingintent = smstracker.mDeliveryIntent;
        intent = new Intent();
        intent.putExtra("pdu", smsmessage.getPdu());
        intent.putExtra("format", "3gpp2");
        pendingintent.send(super.mContext, -1, intent);
_L2:
        return;
_L4:
        i++;
          goto _L5
        android.app.PendingIntent.CanceledException canceledexception;
        canceledexception;
          goto _L2
    }

    private void handleServiceCategoryProgramData(SmsMessage smsmessage) {
        ArrayList arraylist = smsmessage.getSmsCbProgramData();
        if(arraylist == null) {
            Log.e("CDMA", "handleServiceCategoryProgramData: program data list is null!");
        } else {
            Intent intent = new Intent("android.provider.Telephony.SMS_SERVICE_CATEGORY_PROGRAM_DATA_RECEIVED");
            intent.putExtra("sender", smsmessage.getOriginatingAddress());
            intent.putParcelableArrayListExtra("program_data", arraylist);
            dispatch(intent, "android.permission.RECEIVE_SMS", mScpResultsReceiver);
        }
    }

    private static int resultToCause(int i) {
        i;
        JVM INSTR tableswitch -1 4: default 40
    //                   -1 45
    //                   0 40
    //                   1 45
    //                   2 40
    //                   3 50
    //                   4 56;
           goto _L1 _L2 _L1 _L2 _L1 _L3 _L4
_L1:
        byte byte0 = 96;
_L6:
        return byte0;
_L2:
        byte0 = 0;
        continue; /* Loop/switch isn't completed */
_L3:
        byte0 = 35;
        continue; /* Loop/switch isn't completed */
_L4:
        byte0 = 4;
        if(true) goto _L6; else goto _L5
_L5:
    }

    protected void acknowledgeLastIncomingSms(boolean flag, int i, Message message) {
        if(!SystemProperties.get("ril.cdma.inecmmode", "false").equals("true")) {
            int j = resultToCause(i);
            super.mCm.acknowledgeLastIncomingCdmaSms(flag, j, message);
            if(j == 0)
                mLastAcknowledgedSmsFingerprint = mLastDispatchedSmsFingerprint;
            mLastDispatchedSmsFingerprint = null;
        }
    }

    protected com.android.internal.telephony.SmsMessageBase.TextEncodingDetails calculateLength(CharSequence charsequence, boolean flag) {
        return SmsMessage.calculateLength(charsequence, flag);
    }

    public int dispatchMessage(SmsMessageBase smsmessagebase) {
        int i = 1;
        if(smsmessagebase != null) goto _L2; else goto _L1
_L1:
        Log.e("CDMA", "dispatchMessage: message is null");
        i = 2;
_L13:
        return i;
_L2:
        if(!SystemProperties.get("ril.cdma.inecmmode", "false").equals("true")) goto _L4; else goto _L3
_L3:
        i = -1;
          goto _L5
_L4:
        if(!super.mSmsReceiveDisabled) goto _L7; else goto _L6
_L6:
        Log.d("CDMA", "Received short message on device which doesn't support receiving SMS. Ignored.");
          goto _L5
_L7:
        SmsMessage smsmessage = (SmsMessage)smsmessagebase;
        if(i != smsmessage.getMessageType()) goto _L9; else goto _L8
_L8:
        Log.d("CDMA", "Broadcast type message");
        android.telephony.SmsCbMessage smscbmessage = smsmessage.parseBroadcastSms();
        if(smscbmessage != null)
            dispatchBroadcastMessage(smscbmessage);
          goto _L5
_L9:
        mLastDispatchedSmsFingerprint = smsmessage.getIncomingSmsFingerprint();
        if(mLastAcknowledgedSmsFingerprint != null && Arrays.equals(mLastDispatchedSmsFingerprint, mLastAcknowledgedSmsFingerprint)) goto _L5; else goto _L10
_L10:
        int j;
        boolean flag;
        smsmessage.parseSms();
        j = smsmessage.getTeleService();
        flag = false;
        if(4099 != j && 0x40000 != j) goto _L12; else goto _L11
_L11:
        int k = smsmessage.getNumOfVoicemails();
        Log.d("CDMA", (new StringBuilder()).append("Voicemail count=").append(k).toString());
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(super.mContext).edit();
        editor.putInt("vm_count_key_cdma", k);
        editor.apply();
        super.mPhone.setVoiceMessageWaiting(i, k);
        flag = true;
_L14:
        if(!flag)
            if(!super.mStorageMonitor.isStorageAvailable() && smsmessage.getMessageClass() != android.telephony.SmsMessage.MessageClass.CLASS_0)
                i = 3;
            else
            if(4100 == j)
                i = processCdmaWapPdu(smsmessage.getUserData(), ((SmsMessageBase) (smsmessage)).messageRef, smsmessage.getOriginatingAddress());
            else
            if(4098 != j && 4101 != j && i != smsmessage.getMessageType())
                i = 4;
            else
                i = dispatchNormalMessage(smsmessagebase);
_L5:
        if(true) goto _L13; else goto _L12
_L12:
        if((4098 == j || 4101 == j) && smsmessage.isStatusReportMessage()) {
            handleCdmaStatusReport(smsmessage);
            flag = true;
        } else
        if(4102 == j) {
            handleServiceCategoryProgramData(smsmessage);
            flag = true;
        } else
        if(smsmessage.getUserData() == null)
            flag = true;
          goto _L14
    }

    public void dispose() {
        super.mCm.unSetOnNewCdmaSms(this);
    }

    protected String getFormat() {
        return "3gpp2";
    }

    protected int processCdmaWapPdu(byte abyte0[], int i, String s) {
        int j;
        int k;
        j = 0 + 1;
        k = 0xff & abyte0[0];
        if(k == 0) goto _L2; else goto _L1
_L1:
        int k2;
        Log.w("CDMA", "Received a WAP SMS which is not WDP. Discard.");
        k2 = 1;
_L4:
        return k2;
_L2:
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int l = j + 1;
        i1 = 0xff & abyte0[j];
        j1 = l + 1;
        k1 = 0xff & abyte0[l];
        if(k1 >= i1) {
            Log.e("CDMA", (new StringBuilder()).append("WDP bad segment #").append(k1).append(" expecting 0-").append(i1 - 1).toString());
            k2 = 1;
            j1;
            continue; /* Loop/switch isn't completed */
        }
        l1 = 0;
        i2 = 0;
        if(k1 != 0)
            break; /* Loop/switch isn't completed */
        int l2 = j1 + 1;
        int i3 = (0xff & abyte0[j1]) << 8;
        int j3 = l2 + 1;
        l1 = i3 | 0xff & abyte0[l2];
        int k3 = j3 + 1;
        int l3 = (0xff & abyte0[j3]) << 8;
        j1 = k3 + 1;
        i2 = l3 | 0xff & abyte0[k3];
        if(!mCheckForDuplicatePortsInOmadmWapPush || !checkDuplicatePortOmadmWappush(abyte0, j1))
            break; /* Loop/switch isn't completed */
        j2 = j1 + 4;
_L5:
        Log.i("CDMA", (new StringBuilder()).append("Received WAP PDU. Type = ").append(k).append(", originator = ").append(s).append(", src-port = ").append(l1).append(", dst-port = ").append(i2).append(", ID = ").append(i).append(", segment# = ").append(k1).append('/').append(i1).toString());
        byte abyte1[] = new byte[abyte0.length - j2];
        System.arraycopy(abyte0, j2, abyte1, 0, abyte0.length - j2);
        k2 = processMessagePart(abyte1, s, i, k1, i1, 0L, i2, true);
        if(true) goto _L4; else goto _L3
_L3:
        j2 = j1;
          goto _L5
        if(true) goto _L4; else goto _L6
_L6:
    }

    protected void sendData(String s, String s1, int i, byte abyte0[], PendingIntent pendingintent, PendingIntent pendingintent1) {
        boolean flag;
        if(pendingintent1 != null)
            flag = true;
        else
            flag = false;
        sendSubmitPdu(SmsMessage.getSubmitPdu(s1, s, i, abyte0, flag), pendingintent, pendingintent1, s);
    }

    protected void sendNewSubmitPdu(String s, String s1, String s2, SmsHeader smsheader, int i, PendingIntent pendingintent, PendingIntent pendingintent1, 
            boolean flag) {
        boolean flag1 = true;
        UserData userdata = new UserData();
        userdata.payloadStr = s2;
        userdata.userDataHeader = smsheader;
        if(i == flag1)
            userdata.msgEncoding = 9;
        else
            userdata.msgEncoding = 4;
        userdata.msgEncodingSet = flag1;
        if(pendingintent1 == null || !flag)
            flag1 = false;
        sendSubmitPdu(SmsMessage.getSubmitPdu(s, userdata, flag1), pendingintent, pendingintent1, s);
    }

    protected void sendSms(com.android.internal.telephony.SMSDispatcher.SmsTracker smstracker) {
        byte abyte0[] = (byte[])(byte[])smstracker.mData.get("pdu");
        Message message = obtainMessage(2, smstracker);
        super.mCm.sendCdmaSms(abyte0, message);
    }

    protected void sendSubmitPdu(SmsMessage.SubmitPdu submitpdu, PendingIntent pendingintent, PendingIntent pendingintent1, String s) {
        if(!SystemProperties.getBoolean("ril.cdma.inecmmode", false)) goto _L2; else goto _L1
_L1:
        if(pendingintent == null)
            break MISSING_BLOCK_LABEL_18;
        pendingintent.send(4);
_L4:
        return;
_L2:
        sendRawPdu(((com.android.internal.telephony.SmsMessageBase.SubmitPduBase) (submitpdu)).encodedScAddress, ((com.android.internal.telephony.SmsMessageBase.SubmitPduBase) (submitpdu)).encodedMessage, pendingintent, pendingintent1, s);
        continue; /* Loop/switch isn't completed */
        android.app.PendingIntent.CanceledException canceledexception;
        canceledexception;
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected void sendText(String s, String s1, String s2, PendingIntent pendingintent, PendingIntent pendingintent1) {
        boolean flag;
        if(pendingintent1 != null)
            flag = true;
        else
            flag = false;
        sendSubmitPdu(SmsMessage.getSubmitPdu(s1, s, s2, flag, null), pendingintent, pendingintent1, s);
    }

    private static final String TAG = "CDMA";
    private final boolean mCheckForDuplicatePortsInOmadmWapPush = Resources.getSystem().getBoolean(0x1110033);
    private byte mLastAcknowledgedSmsFingerprint[];
    private byte mLastDispatchedSmsFingerprint[];
    private final BroadcastReceiver mScpResultsReceiver = new BroadcastReceiver() {

        public void onReceive(Context context, Intent intent) {
            String s;
            ArrayList arraylist;
            int i = getResultCode();
            boolean flag;
            if(i == -1 || i == 1)
                flag = true;
            else
                flag = false;
            if(!flag) {
                Log.e("CDMA", (new StringBuilder()).append("SCP results error: result code = ").append(i).toString());
            } else {
                Bundle bundle = getResultExtras(false);
                if(bundle == null) {
                    Log.e("CDMA", "SCP results error: missing extras");
                } else {
                    s = bundle.getString("sender");
                    if(s == null) {
                        Log.e("CDMA", "SCP results error: missing sender extra.");
                    } else {
label0:
                        {
                            arraylist = bundle.getParcelableArrayList("results");
                            if(arraylist != null)
                                break label0;
                            Log.e("CDMA", "SCP results error: missing results extra.");
                        }
                    }
                }
            }
_L1:
            return;
            byte abyte0[];
            ByteArrayOutputStream bytearrayoutputstream;
            DataOutputStream dataoutputstream;
            BearerData bearerdata = new BearerData();
            bearerdata.messageType = 2;
            bearerdata.messageId = SmsMessage.getNextMessageId();
            bearerdata.serviceCategoryProgramResults = arraylist;
            abyte0 = BearerData.encode(bearerdata);
            bytearrayoutputstream = new ByteArrayOutputStream(100);
            dataoutputstream = new DataOutputStream(bytearrayoutputstream);
            dataoutputstream.writeInt(4102);
            dataoutputstream.writeInt(0);
            dataoutputstream.writeInt(0);
            CdmaSmsAddress cdmasmsaddress = CdmaSmsAddress.parse(PhoneNumberUtils.cdmaCheckAndProcessPlusCode(s));
            dataoutputstream.write(cdmasmsaddress.digitMode);
            dataoutputstream.write(cdmasmsaddress.numberMode);
            dataoutputstream.write(((SmsAddress) (cdmasmsaddress)).ton);
            dataoutputstream.write(cdmasmsaddress.numberPlan);
            dataoutputstream.write(cdmasmsaddress.numberOfDigits);
            dataoutputstream.write(((SmsAddress) (cdmasmsaddress)).origBytes, 0, ((SmsAddress) (cdmasmsaddress)).origBytes.length);
            dataoutputstream.write(0);
            dataoutputstream.write(0);
            dataoutputstream.write(0);
            dataoutputstream.write(abyte0.length);
            dataoutputstream.write(abyte0, 0, abyte0.length);
            
// JavaClassFileOutputException: get_constant: invalid tag

        final CdmaSMSDispatcher this$0;

             {
                this$0 = CdmaSMSDispatcher.this;
                super();
            }
    };

}
