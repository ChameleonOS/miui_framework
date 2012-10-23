// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cdma;

import android.content.Context;
import android.os.*;
import android.util.Log;
import com.android.internal.telephony.CommandsInterface;
import java.util.concurrent.atomic.AtomicInteger;

public class CdmaSubscriptionSourceManager extends Handler {

    private CdmaSubscriptionSourceManager(Context context, CommandsInterface commandsinterface) {
        mCdmaSubscriptionSourceChangedRegistrants = new RegistrantList();
        mCdmaSubscriptionSource = new AtomicInteger(1);
        mContext = context;
        mCM = commandsinterface;
        mCM.registerForCdmaSubscriptionChanged(this, 1, null);
        mCM.registerForOn(this, 3, null);
        int i = getDefaultCdmaSubscriptionSource();
        mCdmaSubscriptionSource.set(i);
    }

    private int getDefaultCdmaSubscriptionSource() {
        return android.provider.Settings.Secure.getInt(mContext.getContentResolver(), "subscription_mode", 1);
    }

    public static CdmaSubscriptionSourceManager getInstance(Context context, CommandsInterface commandsinterface, Handler handler, int i, Object obj) {
        synchronized(sReferenceCountMonitor) {
            if(sInstance == null)
                sInstance = new CdmaSubscriptionSourceManager(context, commandsinterface);
            sInstance;
            sReferenceCount = 1 + sReferenceCount;
        }
        sInstance.registerForCdmaSubscriptionSourceChanged(handler, i, obj);
        return sInstance;
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void handleGetCdmaSubscriptionSource(AsyncResult asyncresult) {
        if(asyncresult.exception == null && asyncresult.result != null) {
            int i = ((int[])(int[])asyncresult.result)[0];
            if(i != mCdmaSubscriptionSource.get()) {
                log((new StringBuilder()).append("Subscription Source Changed : ").append(mCdmaSubscriptionSource).append(" >> ").append(i).toString());
                mCdmaSubscriptionSource.set(i);
                mCdmaSubscriptionSourceChangedRegistrants.notifyRegistrants(new AsyncResult(null, null, null));
            }
        } else {
            logw((new StringBuilder()).append("Unable to get CDMA Subscription Source, Exception: ").append(asyncresult.exception).append(", result: ").append(asyncresult.result).toString());
        }
    }

    private void log(String s) {
        Log.d("CDMA", (new StringBuilder()).append("[CdmaSSM] ").append(s).toString());
    }

    private void loge(String s) {
        Log.e("CDMA", (new StringBuilder()).append("[CdmaSSM] ").append(s).toString());
    }

    private void logw(String s) {
        Log.w("CDMA", (new StringBuilder()).append("[CdmaSSM] ").append(s).toString());
    }

    private void registerForCdmaSubscriptionSourceChanged(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mCdmaSubscriptionSourceChangedRegistrants.add(registrant);
    }

    public void dispose(Handler handler) {
        mCdmaSubscriptionSourceChangedRegistrants.remove(handler);
        Object obj = sReferenceCountMonitor;
        obj;
        JVM INSTR monitorenter ;
        sReferenceCount = -1 + sReferenceCount;
        if(sReferenceCount <= 0) {
            mCM.unregisterForCdmaSubscriptionChanged(this);
            mCM.unregisterForOn(this);
            sInstance = null;
        }
        return;
    }

    public int getCdmaSubscriptionSource() {
        return mCdmaSubscriptionSource.get();
    }

    public void handleMessage(Message message) {
        message.what;
        JVM INSTR tableswitch 1 3: default 32
    //                   1 38
    //                   2 38
    //                   3 78;
           goto _L1 _L2 _L2 _L3
_L1:
        super.handleMessage(message);
_L5:
        return;
_L2:
        log((new StringBuilder()).append("CDMA_SUBSCRIPTION_SOURCE event = ").append(message.what).toString());
        handleGetCdmaSubscriptionSource((AsyncResult)message.obj);
        continue; /* Loop/switch isn't completed */
_L3:
        mCM.getCdmaSubscriptionSource(obtainMessage(2));
        if(true) goto _L5; else goto _L4
_L4:
    }

    private static final int EVENT_CDMA_SUBSCRIPTION_SOURCE_CHANGED = 1;
    private static final int EVENT_GET_CDMA_SUBSCRIPTION_SOURCE = 2;
    private static final int EVENT_RADIO_ON = 3;
    static final String LOG_TAG = "CDMA";
    public static final int PREFERRED_CDMA_SUBSCRIPTION = 1;
    public static final int SUBSCRIPTION_FROM_NV = 1;
    public static final int SUBSCRIPTION_FROM_RUIM = 0;
    public static final int SUBSCRIPTION_SOURCE_UNKNOWN = -1;
    private static CdmaSubscriptionSourceManager sInstance;
    private static int sReferenceCount = 0;
    private static final Object sReferenceCountMonitor = new Object();
    private CommandsInterface mCM;
    private AtomicInteger mCdmaSubscriptionSource;
    private RegistrantList mCdmaSubscriptionSourceChangedRegistrants;
    private Context mContext;

}
