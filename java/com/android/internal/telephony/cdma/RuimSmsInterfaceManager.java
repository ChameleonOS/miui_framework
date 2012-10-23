// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cdma;

import android.content.Context;
import android.os.*;
import android.util.Log;
import com.android.internal.telephony.*;
import java.util.*;

// Referenced classes of package com.android.internal.telephony.cdma:
//            CDMAPhone

public class RuimSmsInterfaceManager extends IccSmsInterfaceManager {

    public RuimSmsInterfaceManager(CDMAPhone cdmaphone, SMSDispatcher smsdispatcher) {
        super(cdmaphone);
        mHandler = new Handler() {

            public void handleMessage(Message message) {
                message.what;
                JVM INSTR tableswitch 1 2: default 28
            //                           1 105
            //                           2 29;
                   goto _L1 _L2 _L3
_L1:
                return;
_L3:
                AsyncResult asyncresult1 = (AsyncResult)message.obj;
                Object obj1 = mLock;
                obj1;
                JVM INSTR monitorenter ;
                RuimSmsInterfaceManager ruimsmsinterfacemanager = RuimSmsInterfaceManager.this;
                boolean flag;
                if(asyncresult1.exception == null)
                    flag = true;
                else
                    flag = false;
                ruimsmsinterfacemanager.mSuccess = flag;
                mLock.notifyAll();
                continue; /* Loop/switch isn't completed */
_L2:
                AsyncResult asyncresult = (AsyncResult)message.obj;
                Object obj = mLock;
                obj;
                JVM INSTR monitorenter ;
                if(asyncresult.exception != null)
                    break; /* Loop/switch isn't completed */
                mSms = buildValidRawData((ArrayList)asyncresult.result);
_L5:
                mLock.notifyAll();
                if(true) goto _L1; else goto _L4
                Exception exception;
                exception;
                throw exception;
_L4:
                log("Cannot load Sms records");
                if(mSms != null)
                    mSms.clear();
                  goto _L5
            }

            final RuimSmsInterfaceManager this$0;

             {
                this$0 = RuimSmsInterfaceManager.this;
                super();
            }
        };
        super.mDispatcher = smsdispatcher;
    }

    public boolean copyMessageToIccEf(int i, byte abyte0[], byte abyte1[]) {
        log((new StringBuilder()).append("copyMessageToIccEf: status=").append(i).append(" ==> ").append("pdu=(").append(Arrays.toString(abyte0)).append(")").toString());
        enforceReceiveAndSend("Copying message to RUIM");
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        mSuccess = false;
        Message message = mHandler.obtainMessage(2);
        super.mPhone.mCM.writeSmsToRuim(i, IccUtils.bytesToHexString(abyte0), message);
        try {
            mLock.wait();
        }
        catch(InterruptedException interruptedexception) {
            log("interrupted while trying to update by index");
        }
        return mSuccess;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean disableCellBroadcast(int i) {
        Log.e("CDMA", "Error! Not implemented for CDMA.");
        return false;
    }

    public boolean disableCellBroadcastRange(int i, int j) {
        Log.e("CDMA", "Error! Not implemented for CDMA.");
        return false;
    }

    public void dispose() {
    }

    public boolean enableCellBroadcast(int i) {
        Log.e("CDMA", "Error! Not implemented for CDMA.");
        return false;
    }

    public boolean enableCellBroadcastRange(int i, int j) {
        Log.e("CDMA", "Error! Not implemented for CDMA.");
        return false;
    }

    protected void finalize() {
        try {
            super.finalize();
        }
        catch(Throwable throwable) {
            Log.e("CDMA", "Error while finalizing:", throwable);
        }
        Log.d("CDMA", "RuimSmsInterfaceManager finalized");
    }

    public List getAllMessagesFromIccEf() {
        log("getAllMessagesFromEF");
        super.mPhone.getContext().enforceCallingPermission("android.permission.RECEIVE_SMS", "Reading messages from RUIM");
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        Message message = mHandler.obtainMessage(1);
        super.mPhone.getIccFileHandler().loadEFLinearFixedAll(28476, message);
        try {
            mLock.wait();
        }
        catch(InterruptedException interruptedexception) {
            log("interrupted while trying to load from the RUIM");
        }
        return mSms;
        Exception exception;
        exception;
        throw exception;
    }

    protected void log(String s) {
        Log.d("CDMA", (new StringBuilder()).append("[RuimSmsInterfaceManager] ").append(s).toString());
    }

    public boolean updateMessageOnIccEf(int i, int j, byte abyte0[]) {
        log((new StringBuilder()).append("updateMessageOnIccEf: index=").append(i).append(" status=").append(j).append(" ==> ").append("(").append(abyte0).append(")").toString());
        enforceReceiveAndSend("Updating message on RUIM");
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        Message message;
        mSuccess = false;
        message = mHandler.obtainMessage(2);
        if(j != 0) goto _L2; else goto _L1
_L1:
        super.mPhone.mCM.deleteSmsOnRuim(i, message);
_L3:
        mLock.wait();
_L4:
        return mSuccess;
_L2:
        byte abyte1[] = makeSmsRecordData(j, abyte0);
        super.mPhone.getIccFileHandler().updateEFLinearFixed(28476, i, abyte1, null, message);
          goto _L3
        Exception exception;
        exception;
        throw exception;
        InterruptedException interruptedexception;
        interruptedexception;
        log("interrupted while trying to update by index");
          goto _L4
    }

    static final boolean DBG = true;
    private static final int EVENT_LOAD_DONE = 1;
    private static final int EVENT_UPDATE_DONE = 2;
    static final String LOG_TAG = "CDMA";
    Handler mHandler;
    private final Object mLock = new Object();
    private List mSms;
    private boolean mSuccess;



/*
    static boolean access$102(RuimSmsInterfaceManager ruimsmsinterfacemanager, boolean flag) {
        ruimsmsinterfacemanager.mSuccess = flag;
        return flag;
    }

*/



/*
    static List access$202(RuimSmsInterfaceManager ruimsmsinterfacemanager, List list) {
        ruimsmsinterfacemanager.mSms = list;
        return list;
    }

*/

}
