// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

// Referenced classes of package com.android.internal.telephony:
//            PhoneFactory, PhoneProxy, PhoneBase, DataConnectionTracker, 
//            ServiceStateTracker, CallTracker, RIL

public class DebugService {

    public DebugService() {
        log("DebugService:");
    }

    private static void log(String s) {
        Log.d(TAG, (new StringBuilder()).append("DebugService ").append(s).toString());
    }

    public void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        log("dump: +");
        PhoneProxy phoneproxy;
        PhoneBase phonebase;
        try {
            phoneproxy = (PhoneProxy)PhoneFactory.getDefaultPhone();
        }
        catch(Exception exception) {
            printwriter.println((new StringBuilder()).append("Telephony DebugService: Could not getDefaultPhone e=").append(exception).toString());
            continue; /* Loop/switch isn't completed */
        }
        phonebase = (PhoneBase)phoneproxy.getActivePhone();
        printwriter.println();
        printwriter.println("++++++++++++++++++++++++++++++++");
        printwriter.flush();
        Exception exception1;
        try {
            phonebase.dump(filedescriptor, printwriter, as);
        }
        catch(Exception exception2) {
            exception2.printStackTrace();
        }
        printwriter.flush();
        printwriter.println("++++++++++++++++++++++++++++++++");
        try {
            phonebase.mDataConnectionTracker.dump(filedescriptor, printwriter, as);
        }
        catch(Exception exception3) {
            exception3.printStackTrace();
        }
        printwriter.flush();
        printwriter.println("++++++++++++++++++++++++++++++++");
        try {
            phonebase.getServiceStateTracker().dump(filedescriptor, printwriter, as);
        }
        catch(Exception exception4) {
            exception4.printStackTrace();
        }
        printwriter.flush();
        printwriter.println("++++++++++++++++++++++++++++++++");
        try {
            phonebase.getCallTracker().dump(filedescriptor, printwriter, as);
        }
        catch(Exception exception5) {
            exception5.printStackTrace();
        }
        printwriter.flush();
        printwriter.println("++++++++++++++++++++++++++++++++");
        try {
            ((RIL)phonebase.mCM).dump(filedescriptor, printwriter, as);
        }
        catch(Exception exception6) {
            exception6.printStackTrace();
        }
        printwriter.flush();
        printwriter.println("++++++++++++++++++++++++++++++++");
        log("dump: -");
        return;
        exception1;
        printwriter.println((new StringBuilder()).append("Telephony DebugService: Could not PhoneBase e=").append(exception1).toString());
        if(true) goto _L2; else goto _L1
_L1:
        break MISSING_BLOCK_LABEL_205;
_L2:
        break MISSING_BLOCK_LABEL_147;
    }

    private static String TAG = "DebugService";

}
