// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cdma;

import android.os.Message;
import android.util.Log;
import com.android.internal.telephony.*;
import com.android.internal.util.IState;
import java.io.FileDescriptor;
import java.io.PrintWriter;

// Referenced classes of package com.android.internal.telephony.cdma:
//            CDMAPhone

public class CdmaDataConnection extends DataConnection {

    private CdmaDataConnection(CDMAPhone cdmaphone, String s, int i, RetryManager retrymanager, DataConnectionTracker dataconnectiontracker) {
        super(cdmaphone, s, i, retrymanager, dataconnectiontracker);
    }

    static CdmaDataConnection makeDataConnection(CDMAPhone cdmaphone, int i, RetryManager retrymanager, DataConnectionTracker dataconnectiontracker) {
        synchronized(mCountLock) {
            mCount = 1 + mCount;
        }
        CdmaDataConnection cdmadataconnection = new CdmaDataConnection(cdmaphone, (new StringBuilder()).append("CdmaDC-").append(mCount).toString(), i, retrymanager, dataconnectiontracker);
        cdmadataconnection.start();
        cdmadataconnection.log((new StringBuilder()).append("Made ").append(cdmadataconnection.getName()).toString());
        return cdmadataconnection;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        printwriter.println("CdmaDataConnection extends:");
        super.dump(filedescriptor, printwriter, as);
    }

    protected boolean isDnsOk(String as[]) {
        boolean flag = false;
        if(!"0.0.0.0".equals(as[0]) || !"0.0.0.0".equals(as[1]) || super.phone.isDnsCheckDisabled())
            flag = true;
        return flag;
    }

    protected void log(String s) {
        Log.d("CDMA", (new StringBuilder()).append("[").append(getName()).append("] ").append(s).toString());
    }

    protected void onConnect(com.android.internal.telephony.DataConnection.ConnectionParams connectionparams) {
        log("CdmaDataConnection Connecting...");
        super.mApn = connectionparams.apn;
        super.createTime = -1L;
        super.lastFailTime = -1L;
        super.lastFailCause = com.android.internal.telephony.DataConnection.FailCause.NONE;
        int i;
        Message message;
        if(connectionparams.apn != null && connectionparams.apn.types.length > 0 && connectionparams.apn.types[0] != null && connectionparams.apn.types[0].equals("dun")) {
            log("CdmaDataConnection using DUN");
            i = 1;
        } else {
            i = 0;
        }
        message = obtainMessage(0x40001, connectionparams);
        message.obj = connectionparams;
        super.phone.mCM.setupDataCall(Integer.toString(getRilRadioTechnology(0)), Integer.toString(i), null, null, null, Integer.toString(3), "IP", message);
    }

    public String toString() {
        return (new StringBuilder()).append("State=").append(getCurrentState().getName()).append(" create=").append(super.createTime).append(" lastFail=").append(super.lastFailTime).append(" lastFasilCause=").append(super.lastFailCause).toString();
    }

    private static final String LOG_TAG = "CDMA";
}
