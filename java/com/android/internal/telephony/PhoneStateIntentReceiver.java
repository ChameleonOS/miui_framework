// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.content.*;
import android.os.Handler;
import android.os.Message;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.util.Log;

public final class PhoneStateIntentReceiver extends BroadcastReceiver {

    public PhoneStateIntentReceiver() {
        mPhoneState = Phone.State.IDLE;
        mServiceState = new ServiceState();
        mSignalStrength = new SignalStrength();
        mFilter = new IntentFilter();
    }

    public PhoneStateIntentReceiver(Context context, Handler handler) {
        this();
        setContext(context);
        setTarget(handler);
    }

    public boolean getNotifyPhoneCallState() {
        boolean flag;
        if((1 & mWants) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean getNotifyServiceState() {
        boolean flag;
        if((2 & mWants) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean getNotifySignalStrength() {
        boolean flag;
        if((4 & mWants) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public Phone.State getPhoneState() {
        if((1 & mWants) == 0)
            throw new RuntimeException("client must call notifyPhoneCallState(int)");
        else
            return mPhoneState;
    }

    public ServiceState getServiceState() {
        if((2 & mWants) == 0)
            throw new RuntimeException("client must call notifyServiceState(int)");
        else
            return mServiceState;
    }

    public int getSignalStrengthDbm() {
        if((4 & mWants) == 0)
            throw new RuntimeException("client must call notifySignalStrength(int)");
        else
            return mSignalStrength.getDbm();
    }

    public int getSignalStrengthLevelAsu() {
        if((4 & mWants) == 0)
            throw new RuntimeException("client must call notifySignalStrength(int)");
        else
            return mSignalStrength.getAsuLevel();
    }

    public void notifyPhoneCallState(int i) {
        mWants = 1 | mWants;
        mPhoneStateEventWhat = i;
        mFilter.addAction("android.intent.action.PHONE_STATE");
    }

    public void notifyServiceState(int i) {
        mWants = 2 | mWants;
        mServiceStateEventWhat = i;
        mFilter.addAction("android.intent.action.SERVICE_STATE");
    }

    public void notifySignalStrength(int i) {
        mWants = 4 | mWants;
        mAsuEventWhat = i;
        mFilter.addAction("android.intent.action.SIG_STR");
    }

    public void onReceive(Context context, Intent intent) {
        String s;
        s = intent.getAction();
        try {
            if("android.intent.action.SIG_STR".equals(s)) {
                mSignalStrength = SignalStrength.newFromBundle(intent.getExtras());
                if(mTarget != null && getNotifySignalStrength()) {
                    Message message2 = Message.obtain(mTarget, mAsuEventWhat);
                    mTarget.sendMessage(message2);
                }
                break MISSING_BLOCK_LABEL_225;
            }
            if("android.intent.action.PHONE_STATE".equals(s)) {
                mPhoneState = (Phone.State)Enum.valueOf(com/android/internal/telephony/Phone$State, intent.getStringExtra("state"));
                if(mTarget != null && getNotifyPhoneCallState()) {
                    Message message1 = Message.obtain(mTarget, mPhoneStateEventWhat);
                    mTarget.sendMessage(message1);
                }
                break MISSING_BLOCK_LABEL_225;
            }
        }
        catch(Exception exception) {
            Log.e("PHONE", (new StringBuilder()).append("[PhoneStateIntentRecv] caught ").append(exception).toString());
            exception.printStackTrace();
            break MISSING_BLOCK_LABEL_225;
        }
        if("android.intent.action.SERVICE_STATE".equals(s)) {
            mServiceState = ServiceState.newFromBundle(intent.getExtras());
            if(mTarget != null && getNotifyServiceState()) {
                Message message = Message.obtain(mTarget, mServiceStateEventWhat);
                mTarget.sendMessage(message);
            }
        }
    }

    public void registerIntent() {
        mContext.registerReceiver(this, mFilter);
    }

    public void setContext(Context context) {
        mContext = context;
    }

    public void setTarget(Handler handler) {
        mTarget = handler;
    }

    public void unregisterIntent() {
        mContext.unregisterReceiver(this);
    }

    private static final boolean DBG = false;
    private static final String LOG_TAG = "PHONE";
    private static final int NOTIF_MAX = 32;
    private static final int NOTIF_PHONE = 1;
    private static final int NOTIF_SERVICE = 2;
    private static final int NOTIF_SIGNAL = 4;
    private int mAsuEventWhat;
    private Context mContext;
    private IntentFilter mFilter;
    private int mLocationEventWhat;
    Phone.State mPhoneState;
    private int mPhoneStateEventWhat;
    ServiceState mServiceState;
    private int mServiceStateEventWhat;
    SignalStrength mSignalStrength;
    private Handler mTarget;
    private int mWants;
}
