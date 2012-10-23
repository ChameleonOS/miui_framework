// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.gsm;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.*;
import android.util.Log;
import com.android.internal.telephony.*;
import java.util.*;

// Referenced classes of package com.android.internal.telephony.gsm:
//            GSMPhone, SmsBroadcastConfigInfo

public class SimSmsInterfaceManager extends IccSmsInterfaceManager {
    class CellBroadcastRangeManager extends IntRangeManager {

        protected void addRange(int i, int j, boolean flag) {
            mConfigList.add(new SmsBroadcastConfigInfo(i, j, 0, 255, flag));
        }

        protected boolean finishUpdate() {
            boolean flag;
            if(mConfigList.isEmpty()) {
                flag = true;
            } else {
                SmsBroadcastConfigInfo asmsbroadcastconfiginfo[] = (SmsBroadcastConfigInfo[])mConfigList.toArray(new SmsBroadcastConfigInfo[mConfigList.size()]);
                flag = setCellBroadcastConfig(asmsbroadcastconfiginfo);
            }
            return flag;
        }

        protected void startUpdate() {
            mConfigList.clear();
        }

        private ArrayList mConfigList;
        final SimSmsInterfaceManager this$0;

        CellBroadcastRangeManager() {
            this$0 = SimSmsInterfaceManager.this;
            super();
            mConfigList = new ArrayList();
        }
    }


    public SimSmsInterfaceManager(GSMPhone gsmphone, SMSDispatcher smsdispatcher) {
        super(gsmphone);
        mCellBroadcastSubscriptions = new HashMap();
        mCellBroadcastRangeManager = new CellBroadcastRangeManager();
        mHandler = new Handler() {

            public void handleMessage(Message message) {
                boolean flag = true;
                message.what;
                JVM INSTR tableswitch 1 4: default 36
            //                           1 108
            //                           2 37
            //                           3 218
            //                           4 218;
                   goto _L1 _L2 _L3 _L4 _L4
_L1:
                return;
_L3:
                AsyncResult asyncresult2 = (AsyncResult)message.obj;
                Object obj2 = mLock;
                obj2;
                JVM INSTR monitorenter ;
                SimSmsInterfaceManager simsmsinterfacemanager1 = SimSmsInterfaceManager.this;
                if(asyncresult2.exception != null)
                    flag = false;
                simsmsinterfacemanager1.mSuccess = flag;
                mLock.notifyAll();
                continue; /* Loop/switch isn't completed */
_L2:
                AsyncResult asyncresult1 = (AsyncResult)message.obj;
                Object obj1 = mLock;
                obj1;
                JVM INSTR monitorenter ;
                if(asyncresult1.exception != null) goto _L6; else goto _L5
_L5:
                mSms = buildValidRawData((ArrayList)asyncresult1.result);
_L7:
                mLock.notifyAll();
                continue; /* Loop/switch isn't completed */
                Exception exception;
                exception;
                throw exception;
_L6:
                log("Cannot load Sms records");
                if(mSms != null)
                    mSms.clear();
                  goto _L7
_L4:
                AsyncResult asyncresult = (AsyncResult)message.obj;
                Object obj = mLock;
                obj;
                JVM INSTR monitorenter ;
                SimSmsInterfaceManager simsmsinterfacemanager = SimSmsInterfaceManager.this;
                if(asyncresult.exception != null)
                    flag = false;
                simsmsinterfacemanager.mSuccess = flag;
                mLock.notifyAll();
                if(true) goto _L1; else goto _L8
_L8:
            }

            final SimSmsInterfaceManager this$0;

             {
                this$0 = SimSmsInterfaceManager.this;
                super();
            }
        };
        super.mDispatcher = smsdispatcher;
    }

    private boolean setCellBroadcastActivation(boolean flag) {
        log((new StringBuilder()).append("Calling setCellBroadcastActivation(").append(flag).append(')').toString());
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        Message message = mHandler.obtainMessage(3);
        mSuccess = false;
        super.mPhone.mCM.setGsmBroadcastActivation(flag, message);
        try {
            mLock.wait();
        }
        catch(InterruptedException interruptedexception) {
            log("interrupted while trying to set cell broadcast activation");
        }
        return mSuccess;
        Exception exception;
        exception;
        throw exception;
    }

    private boolean setCellBroadcastConfig(SmsBroadcastConfigInfo asmsbroadcastconfiginfo[]) {
        log((new StringBuilder()).append("Calling setGsmBroadcastConfig with ").append(asmsbroadcastconfiginfo.length).append(" configurations").toString());
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        Message message = mHandler.obtainMessage(4);
        mSuccess = false;
        super.mPhone.mCM.setGsmBroadcastConfig(asmsbroadcastconfiginfo, message);
        try {
            mLock.wait();
        }
        catch(InterruptedException interruptedexception) {
            log("interrupted while trying to set cell broadcast config");
        }
        return mSuccess;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean copyMessageToIccEf(int i, byte abyte0[], byte abyte1[]) {
        log((new StringBuilder()).append("copyMessageToIccEf: status=").append(i).append(" ==> ").append("pdu=(").append(Arrays.toString(abyte0)).append("), smsm=(").append(Arrays.toString(abyte1)).append(")").toString());
        enforceReceiveAndSend("Copying message to SIM");
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        mSuccess = false;
        Message message = mHandler.obtainMessage(2);
        super.mPhone.mCM.writeSmsToSim(i, IccUtils.bytesToHexString(abyte1), IccUtils.bytesToHexString(abyte0), message);
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
        return disableCellBroadcastRange(i, i);
    }

    public boolean disableCellBroadcastRange(int i, int j) {
        boolean flag = false;
        log("disableCellBroadcastRange");
        Context context = super.mPhone.getContext();
        context.enforceCallingPermission("android.permission.RECEIVE_SMS", "Disabling cell broadcast SMS");
        String s = context.getPackageManager().getNameForUid(Binder.getCallingUid());
        if(!mCellBroadcastRangeManager.disableRange(i, j, s)) {
            log((new StringBuilder()).append("Failed to remove cell broadcast subscription for MID range ").append(i).append(" to ").append(j).append(" from client ").append(s).toString());
        } else {
            log((new StringBuilder()).append("Removed cell broadcast subscription for MID range ").append(i).append(" to ").append(j).append(" from client ").append(s).toString());
            if(!mCellBroadcastRangeManager.isEmpty())
                flag = true;
            setCellBroadcastActivation(flag);
            flag = true;
        }
        return flag;
    }

    public void dispose() {
    }

    public boolean enableCellBroadcast(int i) {
        return enableCellBroadcastRange(i, i);
    }

    public boolean enableCellBroadcastRange(int i, int j) {
        boolean flag = false;
        log("enableCellBroadcastRange");
        Context context = super.mPhone.getContext();
        context.enforceCallingPermission("android.permission.RECEIVE_SMS", "Enabling cell broadcast SMS");
        String s = context.getPackageManager().getNameForUid(Binder.getCallingUid());
        if(!mCellBroadcastRangeManager.enableRange(i, j, s)) {
            log((new StringBuilder()).append("Failed to add cell broadcast subscription for MID range ").append(i).append(" to ").append(j).append(" from client ").append(s).toString());
        } else {
            log((new StringBuilder()).append("Added cell broadcast subscription for MID range ").append(i).append(" to ").append(j).append(" from client ").append(s).toString());
            if(!mCellBroadcastRangeManager.isEmpty())
                flag = true;
            setCellBroadcastActivation(flag);
            flag = true;
        }
        return flag;
    }

    protected void finalize() {
        try {
            super.finalize();
        }
        catch(Throwable throwable) {
            Log.e("GSM", "Error while finalizing:", throwable);
        }
        Log.d("GSM", "SimSmsInterfaceManager finalized");
    }

    public List getAllMessagesFromIccEf() {
        log("getAllMessagesFromEF");
        super.mPhone.getContext().enforceCallingPermission("android.permission.RECEIVE_SMS", "Reading messages from SIM");
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        Message message = mHandler.obtainMessage(1);
        super.mPhone.getIccFileHandler().loadEFLinearFixedAll(28476, message);
        try {
            mLock.wait();
        }
        catch(InterruptedException interruptedexception) {
            log("interrupted while trying to load from the SIM");
        }
        return mSms;
        Exception exception;
        exception;
        throw exception;
    }

    protected void log(String s) {
        Log.d("GSM", (new StringBuilder()).append("[SimSmsInterfaceManager] ").append(s).toString());
    }

    public boolean updateMessageOnIccEf(int i, int j, byte abyte0[]) {
        log((new StringBuilder()).append("updateMessageOnIccEf: index=").append(i).append(" status=").append(j).append(" ==> ").append("(").append(Arrays.toString(abyte0)).append(")").toString());
        enforceReceiveAndSend("Updating message on SIM");
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        Message message;
        mSuccess = false;
        message = mHandler.obtainMessage(2);
        if(j != 0) goto _L2; else goto _L1
_L1:
        super.mPhone.mCM.deleteSmsOnSim(i, message);
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
    private static final int EVENT_SET_BROADCAST_ACTIVATION_DONE = 3;
    private static final int EVENT_SET_BROADCAST_CONFIG_DONE = 4;
    private static final int EVENT_UPDATE_DONE = 2;
    static final String LOG_TAG = "GSM";
    private static final int SMS_CB_CODE_SCHEME_MAX = 255;
    private static final int SMS_CB_CODE_SCHEME_MIN;
    private CellBroadcastRangeManager mCellBroadcastRangeManager;
    private HashMap mCellBroadcastSubscriptions;
    Handler mHandler;
    private final Object mLock = new Object();
    private List mSms;
    private boolean mSuccess;



/*
    static boolean access$102(SimSmsInterfaceManager simsmsinterfacemanager, boolean flag) {
        simsmsinterfacemanager.mSuccess = flag;
        return flag;
    }

*/



/*
    static List access$202(SimSmsInterfaceManager simsmsinterfacemanager, List list) {
        simsmsinterfacemanager.mSms = list;
        return list;
    }

*/


}
