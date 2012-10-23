// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.gsm;

import android.os.Handler;
import android.util.Log;
import com.android.internal.telephony.*;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.android.internal.telephony.gsm:
//            GSMPhone

public class SimPhoneBookInterfaceManager extends IccPhoneBookInterfaceManager {

    public SimPhoneBookInterfaceManager(GSMPhone gsmphone) {
        super(gsmphone);
        super.adnCache = ((PhoneBase) (gsmphone)).mIccRecords.getAdnCache();
    }

    public void dispose() {
        super.dispose();
    }

    protected void finalize() {
        try {
            super.finalize();
        }
        catch(Throwable throwable) {
            Log.e("GSM", "Error while finalizing:", throwable);
        }
        Log.d("GSM", "SimPhoneBookInterfaceManager finalized");
    }

    public int[] getAdnRecordsSize(int i) {
        logd((new StringBuilder()).append("getAdnRecordsSize: efid=").append(i).toString());
        synchronized(super.mLock) {
            checkThread();
            super.recordSize = new int[3];
            AtomicBoolean atomicboolean = new AtomicBoolean(false);
            android.os.Message message = super.mBaseHandler.obtainMessage(1, atomicboolean);
            super.phone.getIccFileHandler().getEFLinearRecordSize(i, message);
            waitForResult(atomicboolean);
        }
        return super.recordSize;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void logd(String s) {
        Log.d("GSM", (new StringBuilder()).append("[SimPbInterfaceManager] ").append(s).toString());
    }

    protected void loge(String s) {
        Log.e("GSM", (new StringBuilder()).append("[SimPbInterfaceManager] ").append(s).toString());
    }

    static final String LOG_TAG = "GSM";
}
