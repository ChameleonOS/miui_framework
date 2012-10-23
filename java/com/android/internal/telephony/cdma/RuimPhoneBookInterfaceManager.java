// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cdma;

import android.os.Handler;
import android.util.Log;
import com.android.internal.telephony.*;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.android.internal.telephony.cdma:
//            CDMAPhone

public class RuimPhoneBookInterfaceManager extends IccPhoneBookInterfaceManager {

    public RuimPhoneBookInterfaceManager(CDMAPhone cdmaphone) {
        super(cdmaphone);
        super.adnCache = ((PhoneBase) (cdmaphone)).mIccRecords.getAdnCache();
    }

    public void dispose() {
        super.dispose();
    }

    protected void finalize() {
        try {
            super.finalize();
        }
        catch(Throwable throwable) {
            Log.e("CDMA", "Error while finalizing:", throwable);
        }
        Log.d("CDMA", "RuimPhoneBookInterfaceManager finalized");
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
        Log.d("CDMA", (new StringBuilder()).append("[RuimPbInterfaceManager] ").append(s).toString());
    }

    protected void loge(String s) {
        Log.e("CDMA", (new StringBuilder()).append("[RuimPbInterfaceManager] ").append(s).toString());
    }

    static final String LOG_TAG = "CDMA";
}
