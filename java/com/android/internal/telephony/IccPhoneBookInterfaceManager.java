// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.content.Context;
import android.os.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.android.internal.telephony:
//            PhoneBase, IccCard, AdnRecordCache, AdnRecord

public abstract class IccPhoneBookInterfaceManager extends IIccPhoneBook.Stub {

    public IccPhoneBookInterfaceManager(PhoneBase phonebase) {
        mBaseHandler = new Handler() {

            private void notifyPending(AsyncResult asyncresult) {
                if(asyncresult.userObj != null) {
                    ((AtomicBoolean)asyncresult.userObj).set(true);
                    mLock.notifyAll();
                }
            }

            public void handleMessage(Message message) {
                boolean flag = true;
                message.what;
                JVM INSTR tableswitch 1 3: default 32
            //                           1 33
            //                           2 234
            //                           3 168;
                   goto _L1 _L2 _L3 _L4
_L1:
                return;
_L2:
                AsyncResult asyncresult2 = (AsyncResult)message.obj;
                Object obj2 = mLock;
                obj2;
                JVM INSTR monitorenter ;
                if(asyncresult2.exception == null) {
                    recordSize = (int[])(int[])asyncresult2.result;
                    logd((new StringBuilder()).append("GET_RECORD_SIZE Size ").append(recordSize[0]).append(" total ").append(recordSize[1]).append(" #record ").append(recordSize[2]).toString());
                }
                notifyPending(asyncresult2);
                continue; /* Loop/switch isn't completed */
_L4:
                AsyncResult asyncresult1 = (AsyncResult)message.obj;
                Object obj1 = mLock;
                obj1;
                JVM INSTR monitorenter ;
                IccPhoneBookInterfaceManager iccphonebookinterfacemanager = IccPhoneBookInterfaceManager.this;
                if(asyncresult1.exception != null)
                    flag = false;
                iccphonebookinterfacemanager.success = flag;
                notifyPending(asyncresult1);
                continue; /* Loop/switch isn't completed */
_L3:
                AsyncResult asyncresult = (AsyncResult)message.obj;
                Object obj = mLock;
                obj;
                JVM INSTR monitorenter ;
                if(asyncresult.exception != null)
                    break; /* Loop/switch isn't completed */
                records = (List)asyncresult.result;
_L6:
                notifyPending(asyncresult);
                if(true) goto _L1; else goto _L5
                Exception exception;
                exception;
                throw exception;
_L5:
                logd("Cannot load ADN records");
                if(records != null)
                    records.clear();
                  goto _L6
            }

            final IccPhoneBookInterfaceManager this$0;

             {
                this$0 = IccPhoneBookInterfaceManager.this;
                super();
            }
        };
        phone = phonebase;
    }

    private int updateEfForIccType(int i) {
        if(i == 28474 && phone.getIccCard().isApplicationOnIcc(IccCardApplication.AppType.APPTYPE_USIM))
            i = 20272;
        return i;
    }

    protected void checkThread() {
        if(mBaseHandler.getLooper().equals(Looper.myLooper())) {
            loge("query() called on the main UI thread!");
            throw new IllegalStateException("You cannot call query on this provder from the main UI thread.");
        } else {
            return;
        }
    }

    public void dispose() {
    }

    public int getAdnCapacity() {
        return adnCache.getAdnCapacity();
    }

    public List getAdnRecordsInEf(int i) {
        if(phone.getContext().checkCallingOrSelfPermission("android.permission.READ_CONTACTS") != 0)
            throw new SecurityException("Requires android.permission.READ_CONTACTS permission");
        int j = updateEfForIccType(i);
        logd((new StringBuilder()).append("getAdnRecordsInEF: efid=").append(j).toString());
        synchronized(mLock) {
            checkThread();
            AtomicBoolean atomicboolean = new AtomicBoolean(false);
            Message message = mBaseHandler.obtainMessage(2, atomicboolean);
            adnCache.requestLoadAllAdnLike(j, adnCache.extensionEfForEf(j), message);
            waitForResult(atomicboolean);
        }
        return records;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public abstract int[] getAdnRecordsSize(int i);

    public int getFreeAdn() {
        return adnCache.getFreeAdn();
    }

    protected abstract void logd(String s);

    protected abstract void loge(String s);

    protected void publish() {
        ServiceManager.addService("simphonebook", this);
    }

    public boolean updateAdnRecordsInEfByIndex(int i, String s, String s1, int j, String s2) {
        if(phone.getContext().checkCallingOrSelfPermission("android.permission.WRITE_CONTACTS") != 0)
            throw new SecurityException("Requires android.permission.WRITE_CONTACTS permission");
        logd((new StringBuilder()).append("updateAdnRecordsInEfByIndex: efid=").append(i).append(" Index=").append(j).append(" ==> ").append("(").append(s).append(",").append(s1).append(")").append(" pin2=").append(s2).toString());
        synchronized(mLock) {
            checkThread();
            success = false;
            AtomicBoolean atomicboolean = new AtomicBoolean(false);
            Message message = mBaseHandler.obtainMessage(3, atomicboolean);
            AdnRecord adnrecord = new AdnRecord(s, s1);
            adnCache.updateAdnByIndex(i, adnrecord, j, s2, message);
            waitForResult(atomicboolean);
        }
        return success;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean updateAdnRecordsInEfBySearch(int i, String s, String s1, String s2, String s3, String s4) {
        if(phone.getContext().checkCallingOrSelfPermission("android.permission.WRITE_CONTACTS") != 0)
            throw new SecurityException("Requires android.permission.WRITE_CONTACTS permission");
        logd((new StringBuilder()).append("updateAdnRecordsInEfBySearch: efid=").append(i).append(" (").append(s).append(",").append(s1).append(")").append("==>").append(" (").append(s2).append(",").append(s3).append(")").append(" pin2=").append(s4).toString());
        int j = updateEfForIccType(i);
        synchronized(mLock) {
            checkThread();
            success = false;
            AtomicBoolean atomicboolean = new AtomicBoolean(false);
            Message message = mBaseHandler.obtainMessage(3, atomicboolean);
            AdnRecord adnrecord = new AdnRecord(s, s1);
            AdnRecord adnrecord1 = new AdnRecord(s2, s3);
            adnCache.updateAdnBySearch(j, adnrecord, adnrecord1, s4, message);
            waitForResult(atomicboolean);
        }
        return success;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void waitForResult(AtomicBoolean atomicboolean) {
        while(!atomicboolean.get()) 
            try {
                mLock.wait();
            }
            catch(InterruptedException interruptedexception) {
                logd("interrupted while trying to update by search");
            }
    }

    protected static final boolean ALLOW_SIM_OP_IN_UI_THREAD = false;
    protected static final boolean DBG = true;
    protected static final int EVENT_GET_SIZE_DONE = 1;
    protected static final int EVENT_LOAD_DONE = 2;
    protected static final int EVENT_UPDATE_DONE = 3;
    protected AdnRecordCache adnCache;
    protected Handler mBaseHandler;
    protected final Object mLock = new Object();
    protected PhoneBase phone;
    protected int recordSize[];
    protected List records;
    protected boolean success;
}
