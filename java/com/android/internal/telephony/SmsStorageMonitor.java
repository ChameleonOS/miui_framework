// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.content.*;
import android.os.*;
import android.util.Log;

// Referenced classes of package com.android.internal.telephony:
//            PhoneBase, CommandsInterface

public final class SmsStorageMonitor extends Handler {

    public SmsStorageMonitor(PhoneBase phonebase) {
        mStorageAvailable = true;
        mContext = phonebase.getContext();
        mCm = phonebase.mCM;
        createWakelock();
        mCm.setOnIccSmsFull(this, 1, null);
        mCm.registerForOn(this, 3, null);
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.intent.action.DEVICE_STORAGE_FULL");
        intentfilter.addAction("android.intent.action.DEVICE_STORAGE_NOT_FULL");
        mContext.registerReceiver(mResultReceiver, intentfilter);
    }

    private void createWakelock() {
        mWakeLock = ((PowerManager)mContext.getSystemService("power")).newWakeLock(1, "SmsStorageMonitor");
        mWakeLock.setReferenceCounted(true);
    }

    private void handleIccFull() {
        Intent intent = new Intent("android.provider.Telephony.SIM_FULL");
        mWakeLock.acquire(5000L);
        mContext.sendBroadcast(intent, "android.permission.RECEIVE_SMS");
    }

    public void dispose() {
        mCm.unSetOnIccSmsFull(this);
        mCm.unregisterForOn(this);
        mContext.unregisterReceiver(mResultReceiver);
    }

    public void handleMessage(Message message) {
        message.what;
        JVM INSTR tableswitch 1 3: default 32
    //                   1 33
    //                   2 40
    //                   3 97;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        handleIccFull();
        continue; /* Loop/switch isn't completed */
_L3:
        if(((AsyncResult)message.obj).exception != null) {
            mReportMemoryStatusPending = true;
            Log.v("SmsStorageMonitor", (new StringBuilder()).append("Memory status report to modem pending : mStorageAvailable = ").append(mStorageAvailable).toString());
        } else {
            mReportMemoryStatusPending = false;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if(mReportMemoryStatusPending) {
            Log.v("SmsStorageMonitor", (new StringBuilder()).append("Sending pending memory status report : mStorageAvailable = ").append(mStorageAvailable).toString());
            mCm.reportSmsMemoryStatus(mStorageAvailable, obtainMessage(2));
        }
        if(true) goto _L1; else goto _L5
_L5:
    }

    public boolean isStorageAvailable() {
        return mStorageAvailable;
    }

    private static final int EVENT_ICC_FULL = 1;
    private static final int EVENT_RADIO_ON = 3;
    private static final int EVENT_REPORT_MEMORY_STATUS_DONE = 2;
    private static final String TAG = "SmsStorageMonitor";
    private static final int WAKE_LOCK_TIMEOUT = 5000;
    final CommandsInterface mCm;
    private final Context mContext;
    private boolean mReportMemoryStatusPending;
    private final BroadcastReceiver mResultReceiver = new BroadcastReceiver() {

        public void onReceive(Context context, Intent intent) {
            if(!intent.getAction().equals("android.intent.action.DEVICE_STORAGE_FULL")) goto _L2; else goto _L1
_L1:
            mStorageAvailable = false;
            mCm.reportSmsMemoryStatus(false, obtainMessage(2));
_L4:
            return;
_L2:
            if(intent.getAction().equals("android.intent.action.DEVICE_STORAGE_NOT_FULL")) {
                mStorageAvailable = true;
                mCm.reportSmsMemoryStatus(true, obtainMessage(2));
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        final SmsStorageMonitor this$0;

             {
                this$0 = SmsStorageMonitor.this;
                super();
            }
    };
    boolean mStorageAvailable;
    private android.os.PowerManager.WakeLock mWakeLock;
}
