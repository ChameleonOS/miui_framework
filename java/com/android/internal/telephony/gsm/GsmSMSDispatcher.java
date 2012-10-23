// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.gsm;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.*;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsCbLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;
import com.android.internal.telephony.*;
import java.util.*;

// Referenced classes of package com.android.internal.telephony.gsm:
//            UsimDataDownloadHandler, SmsCbHeader, GsmSmsCbMessage, SmsMessage, 
//            UsimServiceTable

public final class GsmSMSDispatcher extends SMSDispatcher {
    private static final class SmsCbConcatInfo {

        public boolean equals(Object obj) {
            boolean flag = false;
            if(obj instanceof SmsCbConcatInfo) {
                SmsCbConcatInfo smscbconcatinfo = (SmsCbConcatInfo)obj;
                if(mHeader.getSerialNumber() == smscbconcatinfo.mHeader.getSerialNumber() && mLocation.equals(smscbconcatinfo.mLocation))
                    flag = true;
            }
            return flag;
        }

        public int hashCode() {
            return 31 * mHeader.getSerialNumber() + mLocation.hashCode();
        }

        public boolean matchesLocation(String s, int i, int j) {
            return mLocation.isInLocationArea(s, i, j);
        }

        private final SmsCbHeader mHeader;
        private final SmsCbLocation mLocation;

        public SmsCbConcatInfo(SmsCbHeader smscbheader, SmsCbLocation smscblocation) {
            mHeader = smscbheader;
            mLocation = smscblocation;
        }
    }


    public GsmSMSDispatcher(PhoneBase phonebase, SmsStorageMonitor smsstoragemonitor, SmsUsageMonitor smsusagemonitor) {
        super(phonebase, smsstoragemonitor, smsusagemonitor);
        mDataDownloadHandler = new UsimDataDownloadHandler(super.mCm);
        super.mCm.setOnNewGsmSms(this, 1, null);
        super.mCm.setOnSmsStatus(this, 100, null);
        super.mCm.setOnNewGsmBroadcastSms(this, 101, null);
    }

    private void handleBroadcastSms(AsyncResult asyncresult) {
        byte abyte0[];
        SmsCbHeader smscbheader;
        String s;
        int i;
        int j;
        abyte0 = (byte[])(byte[])asyncresult.result;
        smscbheader = new SmsCbHeader(abyte0);
        s = SystemProperties.get("gsm.operator.numeric");
        GsmCellLocation gsmcelllocation = (GsmCellLocation)super.mPhone.getCellLocation();
        i = gsmcelllocation.getLac();
        j = gsmcelllocation.getCid();
        smscbheader.getGeographicalScope();
        JVM INSTR tableswitch 0 3: default 92
    //                   0 220
    //                   1 92
    //                   2 202
    //                   3 220;
           goto _L1 _L2 _L1 _L3 _L2
_L1:
        SmsCbLocation smscblocation = new SmsCbLocation(s);
_L9:
        int k = smscbheader.getNumberOfPages();
        if(k <= 1) goto _L5; else goto _L4
_L4:
        SmsCbConcatInfo smscbconcatinfo;
        byte abyte1[][];
        int l;
        smscbconcatinfo = new SmsCbConcatInfo(smscbheader, smscblocation);
        abyte1 = (byte[][])mSmsCbPageMap.get(smscbconcatinfo);
        if(abyte1 == null) {
            abyte1 = new byte[k][];
            mSmsCbPageMap.put(smscbconcatinfo, abyte1);
        }
        abyte1[-1 + smscbheader.getPageIndex()] = abyte0;
        l = 0;
_L11:
        if(l >= abyte1.length) goto _L7; else goto _L6
_L6:
        if(abyte1[l] != null)
            break MISSING_BLOCK_LABEL_346;
          goto _L8
_L3:
        smscblocation = new SmsCbLocation(s, i, -1);
          goto _L9
_L2:
        smscblocation = new SmsCbLocation(s, i, j);
          goto _L9
_L7:
        mSmsCbPageMap.remove(smscbconcatinfo);
_L10:
        RuntimeException runtimeexception;
        dispatchBroadcastMessage(GsmSmsCbMessage.createSmsCbMessage(smscbheader, smscblocation, abyte1));
        Iterator iterator = mSmsCbPageMap.keySet().iterator();
        do {
            if(!iterator.hasNext())
                break;
            if(!((SmsCbConcatInfo)iterator.next()).matchesLocation(s, i, j))
                iterator.remove();
        } while(true);
        break; /* Loop/switch isn't completed */
_L5:
        try {
            abyte1 = new byte[1][];
            abyte1[0] = abyte0;
        }
        // Misplaced declaration of an exception variable
        catch(RuntimeException runtimeexception) {
            Log.e("GSM", "Error in decoding SMS CB pdu", runtimeexception);
            break; /* Loop/switch isn't completed */
        }
        if(true) goto _L10; else goto _L8
_L8:
        return;
        l++;
          goto _L11
    }

    private void handleStatusReport(AsyncResult asyncresult) {
        String s;
        SmsMessage smsmessage;
        s = (String)asyncresult.result;
        smsmessage = SmsMessage.newFromCDS(s);
        if(smsmessage == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        int k;
        int l;
        i = smsmessage.getStatus();
        j = ((SmsMessageBase) (smsmessage)).messageRef;
        k = 0;
        l = super.deliveryPendingList.size();
_L7:
        if(k >= l) goto _L2; else goto _L3
_L3:
        com.android.internal.telephony.SMSDispatcher.SmsTracker smstracker = (com.android.internal.telephony.SMSDispatcher.SmsTracker)super.deliveryPendingList.get(k);
        if(smstracker.mMessageRef != j) goto _L5; else goto _L4
_L4:
        if(i >= 64 || i < 32)
            super.deliveryPendingList.remove(k);
        PendingIntent pendingintent = smstracker.mDeliveryIntent;
        Intent intent = new Intent();
        intent.putExtra("pdu", IccUtils.hexStringToBytes(s));
        intent.putExtra("format", "3gpp");
        try {
            pendingintent.send(super.mContext, -1, intent);
        }
        catch(android.app.PendingIntent.CanceledException canceledexception) { }
_L2:
        acknowledgeLastIncomingSms(true, 1, null);
        return;
_L5:
        k++;
        if(true) goto _L7; else goto _L6
_L6:
    }

    private static int resultToCause(int i) {
        i;
        JVM INSTR tableswitch -1 3: default 36
    //                   -1 42
    //                   0 36
    //                   1 42
    //                   2 36
    //                   3 47;
           goto _L1 _L2 _L1 _L2 _L1 _L3
_L1:
        char c = '\377';
_L5:
        return c;
_L2:
        c = '\0';
        continue; /* Loop/switch isn't completed */
_L3:
        c = '\323';
        if(true) goto _L5; else goto _L4
_L4:
    }

    protected void acknowledgeLastIncomingSms(boolean flag, int i, Message message) {
        super.mCm.acknowledgeLastIncomingGsmSms(flag, resultToCause(i), message);
    }

    protected com.android.internal.telephony.SmsMessageBase.TextEncodingDetails calculateLength(CharSequence charsequence, boolean flag) {
        return SmsMessage.calculateLength(charsequence, flag);
    }

    public int dispatchMessage(SmsMessageBase smsmessagebase) {
        int i = 1;
        if(smsmessagebase != null) goto _L2; else goto _L1
_L1:
        Log.e("GSM", "dispatchMessage: message is null");
        i = 2;
_L12:
        return i;
_L2:
        SmsMessage smsmessage = (SmsMessage)smsmessagebase;
        if(!smsmessage.isTypeZero()) goto _L4; else goto _L3
_L3:
        Log.d("GSM", "Received short message type 0, Don't display or store it. Send Ack");
          goto _L5
_L4:
        if(!smsmessage.isUsimDataDownload()) goto _L7; else goto _L6
_L6:
        UsimServiceTable usimservicetable = super.mPhone.getUsimServiceTable();
        if(usimservicetable != null && usimservicetable.isAvailable(UsimServiceTable.UsimService.DATA_DL_VIA_SMS_PP)) {
            Log.d("GSM", "Received SMS-PP data download, sending to UICC.");
            i = mDataDownloadHandler.startDataDownload(smsmessage);
        } else {
            Log.d("GSM", "DATA_DL_VIA_SMS_PP service not available, storing message to UICC.");
            String s = IccUtils.bytesToHexString(PhoneNumberUtils.networkPortionToCalledPartyBCDWithLength(smsmessage.getServiceCenterAddress()));
            super.mCm.writeSmsToSim(3, s, IccUtils.bytesToHexString(smsmessage.getPdu()), obtainMessage(102));
            i = -1;
        }
          goto _L5
_L7:
        if(!super.mSmsReceiveDisabled) goto _L9; else goto _L8
_L8:
        Log.d("GSM", "Received short message on device which doesn't support SMS service. Ignored.");
          goto _L5
_L9:
        boolean flag = false;
        if(!smsmessage.isMWISetMessage()) goto _L11; else goto _L10
_L10:
        super.mPhone.setVoiceMessageWaiting(i, -1);
        flag = smsmessage.isMwiDontStore();
_L13:
        if(!flag)
            if(!super.mStorageMonitor.isStorageAvailable() && smsmessage.getMessageClass() != android.telephony.SmsMessage.MessageClass.CLASS_0)
                i = 3;
            else
                i = dispatchNormalMessage(smsmessagebase);
_L5:
        if(true) goto _L12; else goto _L11
_L11:
        if(smsmessage.isMWIClearMessage()) {
            super.mPhone.setVoiceMessageWaiting(i, 0);
            flag = smsmessage.isMwiDontStore();
        }
          goto _L13
    }

    public void dispose() {
        super.mCm.unSetOnNewGsmSms(this);
        super.mCm.unSetOnSmsStatus(this);
        super.mCm.unSetOnNewGsmBroadcastSms(this);
    }

    protected String getFormat() {
        return "3gpp";
    }

    public void handleMessage(Message message) {
        message.what;
        JVM INSTR tableswitch 100 102: default 32
    //                   100 38
    //                   101 52
    //                   102 66;
           goto _L1 _L2 _L3 _L4
_L1:
        super.handleMessage(message);
_L6:
        return;
_L2:
        handleStatusReport((AsyncResult)message.obj);
        continue; /* Loop/switch isn't completed */
_L3:
        handleBroadcastSms((AsyncResult)message.obj);
        continue; /* Loop/switch isn't completed */
_L4:
        AsyncResult asyncresult = (AsyncResult)message.obj;
        if(asyncresult.exception == null) {
            Log.d("GSM", "Successfully wrote SMS-PP message to UICC");
            super.mCm.acknowledgeLastIncomingGsmSms(true, 0, null);
        } else {
            Log.d("GSM", "Failed to write SMS-PP message to UICC", asyncresult.exception);
            super.mCm.acknowledgeLastIncomingGsmSms(false, 255, null);
        }
        if(true) goto _L6; else goto _L5
_L5:
    }

    protected void sendData(String s, String s1, int i, byte abyte0[], PendingIntent pendingintent, PendingIntent pendingintent1) {
        boolean flag;
        SmsMessage.SubmitPdu submitpdu;
        if(pendingintent1 != null)
            flag = true;
        else
            flag = false;
        submitpdu = SmsMessage.getSubmitPdu(s1, s, i, abyte0, flag);
        if(submitpdu != null)
            sendRawPdu(((com.android.internal.telephony.SmsMessageBase.SubmitPduBase) (submitpdu)).encodedScAddress, ((com.android.internal.telephony.SmsMessageBase.SubmitPduBase) (submitpdu)).encodedMessage, pendingintent, pendingintent1, s);
        else
            Log.e("GSM", "GsmSMSDispatcher.sendData(): getSubmitPdu() returned null");
    }

    protected void sendNewSubmitPdu(String s, String s1, String s2, SmsHeader smsheader, int i, PendingIntent pendingintent, PendingIntent pendingintent1, 
            boolean flag) {
        boolean flag1;
        SmsMessage.SubmitPdu submitpdu;
        if(pendingintent1 != null)
            flag1 = true;
        else
            flag1 = false;
        submitpdu = SmsMessage.getSubmitPdu(s1, s, s2, flag1, SmsHeader.toByteArray(smsheader), i, smsheader.languageTable, smsheader.languageShiftTable);
        if(submitpdu != null)
            sendRawPdu(((com.android.internal.telephony.SmsMessageBase.SubmitPduBase) (submitpdu)).encodedScAddress, ((com.android.internal.telephony.SmsMessageBase.SubmitPduBase) (submitpdu)).encodedMessage, pendingintent, pendingintent1, s);
        else
            Log.e("GSM", "GsmSMSDispatcher.sendNewSubmitPdu(): getSubmitPdu() returned null");
    }

    protected void sendSms(com.android.internal.telephony.SMSDispatcher.SmsTracker smstracker) {
        HashMap hashmap = smstracker.mData;
        byte abyte0[] = (byte[])(byte[])hashmap.get("smsc");
        byte abyte1[] = (byte[])(byte[])hashmap.get("pdu");
        Message message = obtainMessage(2, smstracker);
        super.mCm.sendSMS(IccUtils.bytesToHexString(abyte0), IccUtils.bytesToHexString(abyte1), message);
    }

    protected void sendText(String s, String s1, String s2, PendingIntent pendingintent, PendingIntent pendingintent1) {
        boolean flag;
        SmsMessage.SubmitPdu submitpdu;
        if(pendingintent1 != null)
            flag = true;
        else
            flag = false;
        submitpdu = SmsMessage.getSubmitPdu(s1, s, s2, flag);
        if(submitpdu != null)
            sendRawPdu(((com.android.internal.telephony.SmsMessageBase.SubmitPduBase) (submitpdu)).encodedScAddress, ((com.android.internal.telephony.SmsMessageBase.SubmitPduBase) (submitpdu)).encodedMessage, pendingintent, pendingintent1, s);
        else
            Log.e("GSM", "GsmSMSDispatcher.sendText(): getSubmitPdu() returned null");
    }

    private static final int EVENT_NEW_BROADCAST_SMS = 101;
    private static final int EVENT_NEW_SMS_STATUS_REPORT = 100;
    private static final int EVENT_WRITE_SMS_COMPLETE = 102;
    private static final String TAG = "GSM";
    private final UsimDataDownloadHandler mDataDownloadHandler;
    private final HashMap mSmsCbPageMap = new HashMap();
}
