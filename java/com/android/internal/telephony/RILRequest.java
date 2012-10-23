// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.os.*;
import android.util.Log;

// Referenced classes of package com.android.internal.telephony:
//            CommandException, RIL

class RILRequest {

    private RILRequest() {
    }

    static RILRequest obtain(int i, Message message) {
        RILRequest rilrequest = null;
        synchronized(sPoolSync) {
            if(sPool != null) {
                rilrequest = sPool;
                sPool = rilrequest.mNext;
                rilrequest.mNext = null;
                sPoolSize = -1 + sPoolSize;
            }
        }
        if(rilrequest == null)
            rilrequest = new RILRequest();
        synchronized(sSerialMonitor) {
            int j = sNextSerial;
            sNextSerial = j + 1;
            rilrequest.mSerial = j;
        }
        rilrequest.mRequest = i;
        rilrequest.mResult = message;
        rilrequest.mp = Parcel.obtain();
        if(message != null && message.getTarget() == null) {
            throw new NullPointerException("Message target must not be null");
        } else {
            rilrequest.mp.writeInt(i);
            rilrequest.mp.writeInt(rilrequest.mSerial);
            return rilrequest;
        }
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        exception1;
        obj1;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    static void resetSerial() {
        Object obj = sSerialMonitor;
        obj;
        JVM INSTR monitorenter ;
        sNextSerial = 0;
        return;
    }

    void onError(int i, Object obj) {
        CommandException commandexception = CommandException.fromRilErrno(i);
        Log.d("RILJ", (new StringBuilder()).append(serialString()).append("< ").append(RIL.requestToString(mRequest)).append(" error: ").append(commandexception).toString());
        if(mResult != null) {
            AsyncResult.forMessage(mResult, obj, commandexception);
            mResult.sendToTarget();
        }
        if(mp != null) {
            mp.recycle();
            mp = null;
        }
    }

    void release() {
        Object obj = sPoolSync;
        obj;
        JVM INSTR monitorenter ;
        if(sPoolSize < 4) {
            mNext = sPool;
            sPool = this;
            sPoolSize = 1 + sPoolSize;
            mResult = null;
        }
        return;
    }

    String serialString() {
        StringBuilder stringbuilder = new StringBuilder(8);
        String s = Integer.toString(mSerial);
        stringbuilder.append('[');
        int i = 0;
        for(int j = s.length(); i < 4 - j; i++)
            stringbuilder.append('0');

        stringbuilder.append(s);
        stringbuilder.append(']');
        return stringbuilder.toString();
    }

    static final String LOG_TAG = "RILJ";
    private static final int MAX_POOL_SIZE = 4;
    static int sNextSerial = 0;
    private static RILRequest sPool = null;
    private static int sPoolSize = 0;
    private static Object sPoolSync = new Object();
    static Object sSerialMonitor = new Object();
    RILRequest mNext;
    int mRequest;
    Message mResult;
    int mSerial;
    Parcel mp;

}
