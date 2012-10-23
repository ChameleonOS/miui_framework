// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.content.Context;
import android.util.Log;
import java.util.*;

public class SmsUsageMonitor {

    public SmsUsageMonitor(Context context) {
        android.content.ContentResolver contentresolver = context.getContentResolver();
        mMaxAllowed = android.provider.Settings.Secure.getInt(contentresolver, "sms_outgoing_check_max_count", 30);
        mCheckPeriod = android.provider.Settings.Secure.getInt(contentresolver, "sms_outgoing_check_interval_ms", 0x1b7740);
    }

    private boolean isUnderLimit(ArrayList arraylist, int i) {
        Long long1 = Long.valueOf(System.currentTimeMillis());
        for(long l = long1.longValue() - (long)mCheckPeriod; !arraylist.isEmpty() && ((Long)arraylist.get(0)).longValue() < l; arraylist.remove(0));
        boolean flag;
        if(i + arraylist.size() <= mMaxAllowed) {
            for(int j = 0; j < i; j++)
                arraylist.add(long1);

            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    private static void log(String s) {
        Log.d("SmsUsageMonitor", s);
    }

    private void removeExpiredTimestamps() {
        long l = System.currentTimeMillis() - (long)mCheckPeriod;
        HashMap hashmap = mSmsStamp;
        hashmap;
        JVM INSTR monitorenter ;
        Iterator iterator = mSmsStamp.entrySet().iterator();
        do {
            if(!iterator.hasNext())
                break;
            ArrayList arraylist = (ArrayList)((java.util.Map.Entry)iterator.next()).getValue();
            if(arraylist.isEmpty() || ((Long)arraylist.get(-1 + arraylist.size())).longValue() < l)
                iterator.remove();
        } while(true);
        break MISSING_BLOCK_LABEL_110;
        Exception exception;
        exception;
        throw exception;
        hashmap;
        JVM INSTR monitorexit ;
    }

    public boolean check(String s, int i) {
        if(!"com.android.mms".equals(s)) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        HashMap hashmap = mSmsStamp;
        hashmap;
        JVM INSTR monitorenter ;
        removeExpiredTimestamps();
        ArrayList arraylist = (ArrayList)mSmsStamp.get(s);
        if(arraylist == null) {
            arraylist = new ArrayList();
            mSmsStamp.put(s, arraylist);
        }
        flag = isUnderLimit(arraylist, i);
        if(true) goto _L4; else goto _L3
_L3:
    }

    void dispose() {
        mSmsStamp.clear();
    }

    private static final boolean DBG = true;
    private static final int DEFAULT_SMS_CHECK_PERIOD = 0x1b7740;
    private static final int DEFAULT_SMS_MAX_COUNT = 30;
    private static final String TAG = "SmsUsageMonitor";
    private static final boolean VDBG;
    private final int mCheckPeriod;
    private final int mMaxAllowed;
    private final HashMap mSmsStamp = new HashMap();
}
