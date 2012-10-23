// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.*;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.*;
import android.telephony.*;
import android.text.Html;
import android.util.Log;
import android.view.Window;
import com.android.internal.util.HexDump;
import java.io.ByteArrayOutputStream;
import java.util.*;
import miui.provider.ExtraTelephony;

// Referenced classes of package com.android.internal.telephony:
//            WapPushOverSms, PhoneBase, Phone, SmsMessageBase, 
//            SmsHeader, SmsResponse, CommandException, SmsUsageMonitor, 
//            CommandsInterface, SmsStorageMonitor

public abstract class SMSDispatcher extends Handler {
    private final class ConfirmDialogListener
        implements android.content.DialogInterface.OnClickListener, android.content.DialogInterface.OnCancelListener {

        public void onCancel(DialogInterface dialoginterface) {
            Log.d("SMS", "dialog dismissed: don't send SMS");
            sendMessage(obtainMessage(7, mTracker));
        }

        public void onClick(DialogInterface dialoginterface, int i) {
            if(i != -1) goto _L2; else goto _L1
_L1:
            Log.d("SMS", "CONFIRM sending SMS");
            sendMessage(obtainMessage(5, mTracker));
_L4:
            return;
_L2:
            if(i == -2) {
                Log.d("SMS", "DENY sending SMS");
                sendMessage(obtainMessage(7, mTracker));
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        private final SmsTracker mTracker;
        final SMSDispatcher this$0;

        ConfirmDialogListener(SmsTracker smstracker) {
            this$0 = SMSDispatcher.this;
            super();
            mTracker = smstracker;
        }
    }

    protected static final class SmsTracker {

        protected boolean isMultipart() {
            return mData.containsKey("parts");
        }

        public final String mAppPackage;
        public final HashMap mData;
        public final PendingIntent mDeliveryIntent;
        public final String mDestAddress;
        public int mMessageRef;
        public int mRetryCount;
        public final PendingIntent mSentIntent;

        public SmsTracker(HashMap hashmap, PendingIntent pendingintent, PendingIntent pendingintent1, String s, String s1) {
            mData = hashmap;
            mSentIntent = pendingintent;
            mDeliveryIntent = pendingintent1;
            mRetryCount = 0;
            mAppPackage = s;
            mDestAddress = s1;
        }
    }


    protected SMSDispatcher(PhoneBase phonebase, SmsStorageMonitor smsstoragemonitor, SmsUsageMonitor smsusagemonitor) {
        boolean flag = true;
        super();
        mSmsCapable = flag;
        mRemainingMessages = -1;
        mPhone = phonebase;
        mWapPush = new WapPushOverSms(phonebase, this);
        mContext = phonebase.getContext();
        mResolver = mContext.getContentResolver();
        mCm = phonebase.mCM;
        mStorageMonitor = smsstoragemonitor;
        mUsageMonitor = smsusagemonitor;
        mTelephonyManager = (TelephonyManager)mContext.getSystemService("phone");
        createWakelock();
        mSmsCapable = mContext.getResources().getBoolean(0x1110029);
        boolean flag1;
        if(!SystemProperties.getBoolean("telephony.sms.receive", mSmsCapable))
            flag1 = flag;
        else
            flag1 = false;
        mSmsReceiveDisabled = flag1;
        if(SystemProperties.getBoolean("telephony.sms.send", mSmsCapable))
            flag = false;
        mSmsSendDisabled = flag;
        Log.d("SMS", (new StringBuilder()).append("SMSDispatcher: ctor mSmsCapable=").append(mSmsCapable).append(" format=").append(getFormat()).append(" mSmsReceiveDisabled=").append(mSmsReceiveDisabled).append(" mSmsSendDisabled=").append(mSmsSendDisabled).toString());
    }

    private void createWakelock() {
        mWakeLock = ((PowerManager)mContext.getSystemService("power")).newWakeLock(1, "SMSDispatcher");
        mWakeLock.setReferenceCounted(true);
    }

    private boolean denyIfQueueLimitReached(SmsTracker smstracker) {
        boolean flag;
        if(mPendingTrackerCount >= 5) {
            try {
                smstracker.mSentIntent.send(5);
            }
            catch(android.app.PendingIntent.CanceledException canceledexception) {
                Log.e("SMS", "failed to send back RESULT_ERROR_LIMIT_EXCEEDED");
            }
            flag = true;
        } else {
            mPendingTrackerCount = 1 + mPendingTrackerCount;
            flag = false;
        }
        return flag;
    }

    private CharSequence getAppLabel(String s) {
        PackageManager packagemanager = mContext.getPackageManager();
        CharSequence charsequence = packagemanager.getApplicationInfo(s, 0).loadLabel(packagemanager);
        s = charsequence;
_L2:
        return s;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        Log.e("SMS", (new StringBuilder()).append("PackageManager Name Not Found for package ").append(s).toString());
        if(true) goto _L2; else goto _L1
_L1:
    }

    protected static int getNextConcatenatedRef() {
        sConcatenatedRef = 1 + sConcatenatedRef;
        return sConcatenatedRef;
    }

    protected static void handleNotInService(int i, PendingIntent pendingintent) {
        if(pendingintent == null)
            break MISSING_BLOCK_LABEL_26;
        if(i != 3)
            break MISSING_BLOCK_LABEL_17;
        pendingintent.send(2);
        break MISSING_BLOCK_LABEL_26;
        pendingintent.send(4);
        break MISSING_BLOCK_LABEL_26;
        android.app.PendingIntent.CanceledException canceledexception;
        canceledexception;
    }

    private void notifyAndAcknowledgeLastIncomingSms(boolean flag, int i, Message message) {
        if(!flag) {
            Intent intent = new Intent("android.provider.Telephony.SMS_REJECTED");
            intent.putExtra("result", i);
            mWakeLock.acquire(5000L);
            mContext.sendBroadcast(intent, "android.permission.RECEIVE_SMS");
        }
        acknowledgeLastIncomingSms(flag, i, message);
    }

    private void sendMultipartSms(SmsTracker smstracker) {
        HashMap hashmap = smstracker.mData;
        String s = (String)hashmap.get("destination");
        String s1 = (String)hashmap.get("scaddress");
        ArrayList arraylist = (ArrayList)hashmap.get("parts");
        ArrayList arraylist1 = (ArrayList)hashmap.get("sentIntents");
        ArrayList arraylist2 = (ArrayList)hashmap.get("deliveryIntents");
        int i = mPhone.getServiceState().getState();
        if(i != 0) {
            int j = 0;
            for(int k = arraylist.size(); j < k; j++) {
                PendingIntent pendingintent = null;
                if(arraylist1 != null && arraylist1.size() > j)
                    pendingintent = (PendingIntent)arraylist1.get(j);
                handleNotInService(i, pendingintent);
            }

        } else {
            sendMultipartText(s, s1, arraylist, arraylist1, arraylist2);
        }
    }

    protected abstract void acknowledgeLastIncomingSms(boolean flag, int i, Message message);

    protected abstract SmsMessageBase.TextEncodingDetails calculateLength(CharSequence charsequence, boolean flag);

    public void dispatch(Intent intent, String s) {
        mWakeLock.acquire(5000L);
        mContext.sendOrderedBroadcast(intent, s, mResultReceiver, this, -1, null, null);
    }

    protected void dispatchBroadcastMessage(SmsCbMessage smscbmessage) {
        if(smscbmessage.isEmergencyMessage()) {
            Intent intent = new Intent("android.provider.Telephony.SMS_EMERGENCY_CB_RECEIVED");
            intent.putExtra("message", smscbmessage);
            Log.d("SMS", "Dispatching emergency SMS CB");
            dispatch(intent, "android.permission.RECEIVE_EMERGENCY_BROADCAST");
        } else {
            Intent intent1 = new Intent("android.provider.Telephony.SMS_CB_RECEIVED");
            intent1.putExtra("message", smscbmessage);
            Log.d("SMS", "Dispatching SMS CB");
            dispatch(intent1, "android.permission.RECEIVE_SMS");
        }
    }

    public abstract int dispatchMessage(SmsMessageBase smsmessagebase);

    protected int dispatchNormalMessage(SmsMessageBase smsmessagebase) {
        int i = -1;
        SmsHeader smsheader = smsmessagebase.getUserDataHeader();
        if(smsheader == null || smsheader.concatRef == null) {
            byte abyte0[][] = new byte[1][];
            abyte0[0] = smsmessagebase.getPdu();
            if(smsheader != null && smsheader.portAddrs != null) {
                if(smsheader.portAddrs.destPort == 2948)
                    i = mWapPush.dispatchWapPdu(smsmessagebase.getUserData(), smsmessagebase.getOriginatingAddress());
                else
                    dispatchPortAddressedPdus(abyte0, smsheader.portAddrs.destPort);
            } else {
                dispatchPdus(abyte0);
            }
        } else {
            SmsHeader.ConcatRef concatref = smsheader.concatRef;
            SmsHeader.PortAddrs portaddrs = smsheader.portAddrs;
            byte abyte1[] = smsmessagebase.getPdu();
            String s = smsmessagebase.getOriginatingAddress();
            int j = concatref.refNumber;
            int k = concatref.seqNumber;
            int l = concatref.msgCount;
            long l1 = smsmessagebase.getTimestampMillis();
            if(portaddrs != null)
                i = portaddrs.destPort;
            i = processMessagePart(abyte1, s, j, k, l, l1, i, false);
        }
        return i;
    }

    protected void dispatchPdus(byte abyte0[][]) {
        if(ExtraTelephony.checkFirewallForSms(mContext, abyte0)) {
            acknowledgeLastIncomingSms(true, -1, null);
        } else {
            Intent intent = new Intent("android.provider.Telephony.SMS_RECEIVED");
            intent.putExtra("pdus", abyte0);
            intent.putExtra("format", getFormat());
            dispatch(intent, "android.permission.RECEIVE_SMS");
        }
    }

    protected void dispatchPortAddressedPdus(byte abyte0[][], int i) {
        if(ExtraTelephony.checkFirewallForSms(mContext, abyte0)) {
            acknowledgeLastIncomingSms(true, -1, null);
        } else {
            Intent intent = new Intent("android.intent.action.DATA_SMS_RECEIVED", Uri.parse((new StringBuilder()).append("sms://localhost:").append(i).toString()));
            intent.putExtra("pdus", abyte0);
            intent.putExtra("format", getFormat());
            dispatch(intent, "android.permission.RECEIVE_SMS");
        }
    }

    public abstract void dispose();

    protected void finalize() {
        Log.d("SMS", "SMSDispatcher finalized");
    }

    protected abstract String getFormat();

    public void handleMessage(Message message) {
        boolean flag = true;
        message.what;
        JVM INSTR tableswitch 1 7: default 48
    //                   1 49
    //                   2 172
    //                   3 186
    //                   4 200
    //                   5 217
    //                   6 48
    //                   7 263;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L1 _L7
_L1:
        return;
_L2:
        SmsMessage smsmessage;
        AsyncResult asyncresult = (AsyncResult)message.obj;
        if(asyncresult.exception != null) {
            Log.e("SMS", (new StringBuilder()).append("Exception processing incoming SMS. Exception:").append(asyncresult.exception).toString());
            continue; /* Loop/switch isn't completed */
        }
        smsmessage = (SmsMessage)asyncresult.result;
        int i;
        i = dispatchMessage(smsmessage.mWrappedSmsMessage);
        if(i == -1)
            continue; /* Loop/switch isn't completed */
        RuntimeException runtimeexception;
        if(i != flag)
            flag = false;
        notifyAndAcknowledgeLastIncomingSms(flag, i, null);
        continue; /* Loop/switch isn't completed */
        runtimeexception;
        Log.e("SMS", "Exception dispatching message", runtimeexception);
        notifyAndAcknowledgeLastIncomingSms(false, 2, null);
        continue; /* Loop/switch isn't completed */
_L3:
        handleSendComplete((AsyncResult)message.obj);
        continue; /* Loop/switch isn't completed */
_L4:
        sendSms((SmsTracker)message.obj);
        continue; /* Loop/switch isn't completed */
_L5:
        handleReachSentLimit((SmsTracker)(SmsTracker)message.obj);
        continue; /* Loop/switch isn't completed */
_L6:
        SmsTracker smstracker1 = (SmsTracker)message.obj;
        if(smstracker1.isMultipart())
            sendMultipartSms(smstracker1);
        else
            sendSms(smstracker1);
        mPendingTrackerCount = -1 + mPendingTrackerCount;
        continue; /* Loop/switch isn't completed */
_L7:
        SmsTracker smstracker = (SmsTracker)message.obj;
        if(smstracker.mSentIntent != null)
            try {
                smstracker.mSentIntent.send(5);
            }
            catch(android.app.PendingIntent.CanceledException canceledexception) {
                Log.e("SMS", "failed to send RESULT_ERROR_LIMIT_EXCEEDED");
            }
        mPendingTrackerCount = -1 + mPendingTrackerCount;
        if(true) goto _L1; else goto _L8
_L8:
    }

    protected void handleReachSentLimit(SmsTracker smstracker) {
        if(!denyIfQueueLimitReached(smstracker)) {
            CharSequence charsequence = getAppLabel(smstracker.mAppPackage);
            Resources resources = Resources.getSystem();
            Object aobj[] = new Object[1];
            aobj[0] = charsequence;
            android.text.Spanned spanned = Html.fromHtml(resources.getString(0x1040417, aobj));
            ConfirmDialogListener confirmdialoglistener = new ConfirmDialogListener(smstracker);
            AlertDialog alertdialog = (new android.app.AlertDialog.Builder(mContext)).setTitle(0x1040416).setIcon(0x108008a).setMessage(spanned).setPositiveButton(resources.getString(0x1040418), confirmdialoglistener).setNegativeButton(resources.getString(0x1040419), confirmdialoglistener).setOnCancelListener(confirmdialoglistener).create();
            alertdialog.getWindow().setType(2003);
            alertdialog.show();
        }
    }

    protected void handleSendComplete(AsyncResult asyncresult) {
        SmsTracker smstracker = (SmsTracker)asyncresult.userObj;
        PendingIntent pendingintent = smstracker.mSentIntent;
        if(asyncresult.exception == null) {
            if(smstracker.mDeliveryIntent != null) {
                smstracker.mMessageRef = ((SmsResponse)asyncresult.result).messageRef;
                deliveryPendingList.add(smstracker);
            }
            if(pendingintent != null)
                try {
                    if(mRemainingMessages > -1)
                        mRemainingMessages = -1 + mRemainingMessages;
                    if(mRemainingMessages == 0) {
                        Intent intent1 = new Intent();
                        intent1.putExtra("SendNextMsg", true);
                        pendingintent.send(mContext, -1, intent1);
                    } else {
                        pendingintent.send(-1);
                    }
                }
                catch(android.app.PendingIntent.CanceledException canceledexception1) { }
        } else {
            int i = mPhone.getServiceState().getState();
            if(i != 0)
                handleNotInService(i, smstracker.mSentIntent);
            else
            if(((CommandException)(CommandException)asyncresult.exception).getCommandError() == CommandException.Error.SMS_FAIL_RETRY && smstracker.mRetryCount < 3) {
                smstracker.mRetryCount = 1 + smstracker.mRetryCount;
                sendMessageDelayed(obtainMessage(3, smstracker), 2000L);
            } else
            if(smstracker.mSentIntent != null) {
                byte byte0 = 1;
                if(((CommandException)(CommandException)asyncresult.exception).getCommandError() == CommandException.Error.FDN_CHECK_FAILURE)
                    byte0 = 6;
                try {
                    Intent intent = new Intent();
                    if(asyncresult.result != null)
                        intent.putExtra("errorCode", ((SmsResponse)asyncresult.result).errorCode);
                    if(mRemainingMessages > -1)
                        mRemainingMessages = -1 + mRemainingMessages;
                    if(mRemainingMessages == 0)
                        intent.putExtra("SendNextMsg", true);
                    smstracker.mSentIntent.send(mContext, byte0, intent);
                }
                catch(android.app.PendingIntent.CanceledException canceledexception) { }
            }
        }
    }

    protected int processMessagePart(byte abyte0[], String s, int i, int j, int k, long l, 
            int i1, boolean flag) {
        Cursor cursor;
        (byte[][])null;
        cursor = null;
        String s1;
        String s2;
        s1 = Integer.toString(i);
        s2 = Integer.toString(j);
        ContentResolver contentresolver = mResolver;
        Uri uri = mRawUri;
        String as[] = PDU_PROJECTION;
        String as1[] = new String[3];
        as1[0] = s;
        as1[1] = s1;
        as1[2] = s2;
        cursor = contentresolver.query(uri, as, "address=? AND reference_number=? AND sequence=?", as1, null);
        if(!cursor.moveToNext()) goto _L2; else goto _L1
_L1:
        Log.w("SMS", (new StringBuilder()).append("Discarding duplicate message segment from address=").append(s).append(" refNumber=").append(s1).append(" seqNumber=").append(s2).toString());
        byte abyte5[] = HexDump.hexStringToByteArray(cursor.getString(0));
        if(!Arrays.equals(abyte5, abyte0))
            Log.e("SMS", (new StringBuilder()).append("Warning: dup message segment PDU of length ").append(abyte0.length).append(" is different from existing PDU of length ").append(abyte5.length).toString());
        int j1 = 1;
        if(cursor == null) goto _L4; else goto _L3
_L3:
        cursor.close();
_L4:
        return j1;
_L2:
        String as2[];
        int k1;
        cursor.close();
        as2 = new String[2];
        as2[0] = s;
        as2[1] = s1;
        cursor = mResolver.query(mRawUri, PDU_SEQUENCE_PORT_PROJECTION, "address=? AND reference_number=?", as2, null);
        k1 = cursor.getCount();
        if(k1 == k - 1) goto _L6; else goto _L5
_L5:
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("date", Long.valueOf(l));
        contentvalues.put("pdu", HexDump.toHexString(abyte0));
        contentvalues.put("address", s);
        contentvalues.put("reference_number", Integer.valueOf(i));
        contentvalues.put("count", Integer.valueOf(k));
        contentvalues.put("sequence", Integer.valueOf(j));
        if(i1 != -1)
            contentvalues.put("destination_port", Integer.valueOf(i1));
        mResolver.insert(mRawUri, contentvalues);
        j1 = 1;
        if(cursor == null) goto _L4; else goto _L3
_L6:
        byte abyte1[][];
        abyte1 = new byte[k][];
        Exception exception;
        SQLException sqlexception;
        int i2;
        ByteArrayOutputStream bytearrayoutputstream;
        int j2;
        byte abyte2[];
        byte abyte3[][];
        ByteArrayOutputStream bytearrayoutputstream1;
        int k2;
        byte abyte4[];
        for(int l1 = 0; l1 < k1; l1++) {
            cursor.moveToNext();
            int l2 = cursor.getInt(1);
            if(!flag)
                l2--;
            abyte1[l2] = HexDump.hexStringToByteArray(cursor.getString(0));
            if(l2 == 0 && !cursor.isNull(2))
                i1 = cursor.getInt(2);
            break MISSING_BLOCK_LABEL_796;
        }

        if(!flag) goto _L8; else goto _L7
_L7:
        abyte1[j] = abyte0;
_L9:
        mResolver.delete(mRawUri, "address=? AND reference_number=?", as2);
        if(cursor != null)
            cursor.close();
        if(!flag)
            break MISSING_BLOCK_LABEL_686;
        bytearrayoutputstream = new ByteArrayOutputStream();
        for(j2 = 0; j2 < k; j2++)
            bytearrayoutputstream.write(abyte1[j2], 0, abyte1[j2].length);

        break MISSING_BLOCK_LABEL_629;
_L8:
        i2 = j - 1;
        abyte1[i2] = abyte0;
          goto _L9
        sqlexception;
        Log.e("SMS", "Can't access multipart SMS database", sqlexception);
        j1 = 2;
        if(cursor == null) goto _L4; else goto _L3
        exception;
        if(cursor != null)
            cursor.close();
        throw exception;
        abyte2 = bytearrayoutputstream.toByteArray();
        if(i1 == 2948) {
            j1 = mWapPush.dispatchWapPdu(abyte2, s);
        } else {
            abyte3 = new byte[1][];
            abyte3[0] = abyte2;
            dispatchPortAddressedPdus(abyte3, i1);
            j1 = -1;
        }
          goto _L4
label0:
        {
            if(i1 == -1)
                break MISSING_BLOCK_LABEL_787;
            if(i1 != 2948)
                break label0;
            bytearrayoutputstream1 = new ByteArrayOutputStream();
            for(k2 = 0; k2 < k; k2++) {
                abyte4 = SmsMessage.createFromPdu(abyte1[k2], getFormat()).getUserData();
                bytearrayoutputstream1.write(abyte4, 0, abyte4.length);
            }

            j1 = mWapPush.dispatchWapPdu(bytearrayoutputstream1.toByteArray(), s);
        }
          goto _L4
        dispatchPortAddressedPdus(abyte1, i1);
_L10:
        j1 = -1;
          goto _L4
        dispatchPdus(abyte1);
          goto _L10
    }

    protected abstract void sendData(String s, String s1, int i, byte abyte0[], PendingIntent pendingintent, PendingIntent pendingintent1);

    protected void sendMultipartText(String s, String s1, ArrayList arraylist, ArrayList arraylist1, ArrayList arraylist2) {
        int i = 0xff & getNextConcatenatedRef();
        int j = arraylist.size();
        int k = 0;
        mRemainingMessages = j;
        SmsMessageBase.TextEncodingDetails atextencodingdetails[] = new SmsMessageBase.TextEncodingDetails[j];
        for(int l = 0; l < j; l++) {
            SmsMessageBase.TextEncodingDetails textencodingdetails = calculateLength((CharSequence)arraylist.get(l), false);
            if(k != textencodingdetails.codeUnitSize && (k == 0 || k == 1))
                k = textencodingdetails.codeUnitSize;
            atextencodingdetails[l] = textencodingdetails;
        }

        int i1 = 0;
        while(i1 < j)  {
            SmsHeader.ConcatRef concatref = new SmsHeader.ConcatRef();
            concatref.refNumber = i;
            concatref.seqNumber = i1 + 1;
            concatref.msgCount = j;
            concatref.isEightBits = true;
            SmsHeader smsheader = new SmsHeader();
            smsheader.concatRef = concatref;
            if(k == 1) {
                smsheader.languageTable = atextencodingdetails[i1].languageTable;
                smsheader.languageShiftTable = atextencodingdetails[i1].languageShiftTable;
            }
            PendingIntent pendingintent = null;
            if(arraylist1 != null && arraylist1.size() > i1)
                pendingintent = (PendingIntent)arraylist1.get(i1);
            PendingIntent pendingintent1 = null;
            if(arraylist2 != null && arraylist2.size() > i1)
                pendingintent1 = (PendingIntent)arraylist2.get(i1);
            String s2 = (String)arraylist.get(i1);
            boolean flag;
            if(i1 == j - 1)
                flag = true;
            else
                flag = false;
            sendNewSubmitPdu(s, s1, s2, smsheader, k, pendingintent, pendingintent1, flag);
            i1++;
        }
    }

    protected abstract void sendNewSubmitPdu(String s, String s1, String s2, SmsHeader smsheader, int i, PendingIntent pendingintent, PendingIntent pendingintent1, 
            boolean flag);

    protected void sendRawPdu(byte abyte0[], byte abyte1[], PendingIntent pendingintent, PendingIntent pendingintent1, String s) {
label0:
        {
            {
                if(!mSmsSendDisabled)
                    break label0;
                HashMap hashmap;
                String as[];
                android.app.PendingIntent.CanceledException canceledexception;
                String s1;
                SmsTracker smstracker;
                int i;
                android.app.PendingIntent.CanceledException canceledexception1;
                if(pendingintent != null)
                    try {
                        pendingintent.send(4);
                    }
                    catch(android.app.PendingIntent.CanceledException canceledexception2) { }
                Log.d("SMS", "Device does not support sending sms.");
            }
            return;
        }
        if(abyte1 == null) {
            if(pendingintent != null)
                try {
                    pendingintent.send(3);
                }
                // Misplaced declaration of an exception variable
                catch(android.app.PendingIntent.CanceledException canceledexception1) { }
        } else {
            hashmap = new HashMap();
            hashmap.put("smsc", abyte0);
            hashmap.put("pdu", abyte1);
            as = mContext.getPackageManager().getPackagesForUid(Binder.getCallingUid());
            if(as == null || as.length == 0) {
                Log.e("SMS", "Can't get calling app package name: refusing to send SMS");
                if(pendingintent != null)
                    try {
                        pendingintent.send(1);
                    }
                    // Misplaced declaration of an exception variable
                    catch(android.app.PendingIntent.CanceledException canceledexception) {
                        Log.e("SMS", "failed to send error result");
                    }
            } else {
                s1 = as[0];
                smstracker = new SmsTracker(hashmap, pendingintent, pendingintent1, s1, PhoneNumberUtils.extractNetworkPortion(s));
                if(!mUsageMonitor.check(s1, 1)) {
                    sendMessage(obtainMessage(4, smstracker));
                } else {
                    i = mPhone.getServiceState().getState();
                    if(i != 0)
                        handleNotInService(i, smstracker.mSentIntent);
                    else
                        sendSms(smstracker);
                }
            }
        }
        if(false)
            ;
        else
            break MISSING_BLOCK_LABEL_25;
    }

    protected abstract void sendSms(SmsTracker smstracker);

    protected abstract void sendText(String s, String s1, String s2, PendingIntent pendingintent, PendingIntent pendingintent1);

    private static final int DESTINATION_PORT_COLUMN = 2;
    protected static final int EVENT_NEW_SMS = 1;
    static final int EVENT_SEND_CONFIRMED_SMS = 5;
    private static final int EVENT_SEND_LIMIT_REACHED_CONFIRMATION = 4;
    private static final int EVENT_SEND_RETRY = 3;
    protected static final int EVENT_SEND_SMS_COMPLETE = 2;
    static final int EVENT_STOP_SENDING = 7;
    private static final int MAX_SEND_RETRIES = 3;
    private static final int MO_MSG_QUEUE_LIMIT = 5;
    private static final int PDU_COLUMN = 0;
    private static final String PDU_PROJECTION[];
    private static final String PDU_SEQUENCE_PORT_PROJECTION[];
    public static final String RECEIVE_EMERGENCY_BROADCAST_PERMISSION = "android.permission.RECEIVE_EMERGENCY_BROADCAST";
    public static final String RECEIVE_SMS_PERMISSION = "android.permission.RECEIVE_SMS";
    private static final String SEND_NEXT_MSG_EXTRA = "SendNextMsg";
    private static final int SEND_RETRY_DELAY = 2000;
    private static final String SEND_SMS_NO_CONFIRMATION_PERMISSION = "android.permission.SEND_SMS_NO_CONFIRMATION";
    private static final int SEQUENCE_COLUMN = 1;
    private static final int SINGLE_PART_SMS = 1;
    static final String TAG = "SMS";
    private static final int WAKE_LOCK_TIMEOUT = 5000;
    protected static final Uri mRawUri;
    private static int sConcatenatedRef = (new Random()).nextInt(256);
    protected final ArrayList deliveryPendingList = new ArrayList();
    protected final CommandsInterface mCm;
    protected final Context mContext;
    private int mPendingTrackerCount;
    protected final Phone mPhone;
    protected int mRemainingMessages;
    protected final ContentResolver mResolver;
    private final BroadcastReceiver mResultReceiver = new BroadcastReceiver() {

        public void onReceive(Context context, Intent intent) {
            boolean flag2 = true;
            int i = getResultCode();
            if(i != -1 && i != flag2)
                flag2 = false;
            acknowledgeLastIncomingSms(flag2, i, null);
        }

        final SMSDispatcher this$0;

             {
                this$0 = SMSDispatcher.this;
                super();
            }
    };
    protected boolean mSmsCapable;
    protected boolean mSmsReceiveDisabled;
    protected boolean mSmsSendDisabled;
    protected final SmsStorageMonitor mStorageMonitor;
    protected final TelephonyManager mTelephonyManager;
    private final SmsUsageMonitor mUsageMonitor;
    private android.os.PowerManager.WakeLock mWakeLock;
    protected final WapPushOverSms mWapPush;

    static  {
        String as[] = new String[1];
        as[0] = "pdu";
        PDU_PROJECTION = as;
        String as1[] = new String[3];
        as1[0] = "pdu";
        as1[1] = "sequence";
        as1[2] = "destination_port";
        PDU_SEQUENCE_PORT_PROJECTION = as1;
        mRawUri = Uri.withAppendedPath(android.provider.Telephony.Sms.CONTENT_URI, "raw");
    }
}
