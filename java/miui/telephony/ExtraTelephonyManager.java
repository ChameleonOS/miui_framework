// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.telephony;

import android.content.*;
import android.os.Looper;
import android.os.SystemProperties;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;
import miui.telephony.exception.IllegalDeviceException;

// Referenced classes of package miui.telephony:
//            PhoneNumberUtils

public class ExtraTelephonyManager {
    private static class AsyncFuture extends FutureTask {

        public void setResult(Object obj) {
            set(obj);
        }

        public AsyncFuture() {
            super(new Callable() {

                public Object call() throws Exception {
                    throw new IllegalStateException("this should never be called");
                }

            });
        }
    }


    public ExtraTelephonyManager() {
    }

    public static String blockingGetDeviceId(final Context context) throws IllegalDeviceException {
        Future future = (Future)mDeviceIdCache.get();
        if(future == null) {
            FutureTask futuretask = new FutureTask(new Callable() {

                public volatile Object call() throws Exception {
                    return call();
                }

                public String call() throws Exception {
                    return ExtraTelephonyManager.waitAndGetDeviceId(context);
                }

                final Context val$context;

             {
                context = context1;
                super();
            }
            });
            if(mDeviceIdCache.compareAndSet(null, futuretask))
                futuretask.run();
            future = (Future)mDeviceIdCache.get();
        }
        String s = null;
        try {
            s = (String)future.get();
        }
        catch(Exception exception) {
            exception.printStackTrace();
        }
        if(TextUtils.isEmpty(s))
            throw new IllegalDeviceException("device id is empty");
        else
            return s;
    }

    public static String blockingGetIccId(final Context context) throws IllegalDeviceException {
        Future future = (Future)mIccIdCache.get();
        if(future == null) {
            FutureTask futuretask = new FutureTask(new Callable() {

                public volatile Object call() throws Exception {
                    return call();
                }

                public String call() throws Exception {
                    return ExtraTelephonyManager.waitAndGetIccid(context);
                }

                final Context val$context;

             {
                context = context1;
                super();
            }
            });
            if(mIccIdCache.compareAndSet(null, futuretask))
                futuretask.run();
            future = (Future)mIccIdCache.get();
        }
        String s = null;
        try {
            s = (String)future.get();
        }
        catch(Exception exception) {
            exception.printStackTrace();
        }
        if(TextUtils.isEmpty(s))
            throw new IllegalDeviceException("icc id is is empty");
        else
            return s;
    }

    public static String blockingGetImsi(final Context context) throws IllegalDeviceException {
        Future future = (Future)mImsiCache.get();
        if(future == null) {
            FutureTask futuretask = new FutureTask(new Callable() {

                public volatile Object call() throws Exception {
                    return call();
                }

                public String call() throws Exception {
                    return ExtraTelephonyManager.waitAndGetImsi(context);
                }

                final Context val$context;

             {
                context = context1;
                super();
            }
            });
            if(mImsiCache.compareAndSet(null, futuretask))
                futuretask.run();
            future = (Future)mImsiCache.get();
        }
        String s = null;
        try {
            s = (String)future.get();
        }
        catch(Exception exception) {
            exception.printStackTrace();
        }
        if(TextUtils.isEmpty(s))
            throw new IllegalDeviceException("imsi is is empty");
        else
            return s;
    }

    private static void ensureNotOnMainThread(Context context) {
        Looper looper = Looper.myLooper();
        if(looper != null && looper == context.getMainLooper())
            throw new IllegalStateException("calling this from your main thread can lead to deadlock");
        else
            return;
    }

    public static String getSimOperator(Context context) {
        String s;
        s = SystemProperties.get("gsm.sim.operator.numeric");
        break MISSING_BLOCK_LABEL_6;
        while(true)  {
            do
                return s;
            while(context == null || !"com.android.vending".equals(context.getPackageName()) || !PhoneNumberUtils.isChineseOperator(s));
            String s1 = android.provider.Settings.System.getString(context.getContentResolver(), "fake_mobile_operator_for_vending");
            if(s1 != null) {
                if(s1.length() != 0)
                    s = s1;
            } else {
                s = "310410";
            }
        }
    }

    private static String waitAndGetDeviceId(Context context) throws IllegalDeviceException {
        Exception exception;
        ensureNotOnMainThread(context);
        TelephonyManager telephonymanager = (TelephonyManager)context.getSystemService("phone");
        final AsyncFuture future = new AsyncFuture();
        BroadcastReceiver broadcastreceiver = new BroadcastReceiver() {

            public void onReceive(Context context1, Intent intent) {
                future.setResult(intent.getStringExtra("device_id"));
            }

            final AsyncFuture val$future;

             {
                future = asyncfuture;
                super();
            }
        };
        context.registerReceiver(broadcastreceiver, new IntentFilter("android.intent.action.DEVICE_ID_READY"));
        String s = telephonymanager.getDeviceId();
        if(!TextUtils.isEmpty(s))
            future.setResult(s);
        String s1;
        try {
            s1 = (String)future.get();
        }
        catch(Exception exception1) {
            s1 = null;
        }
        finally {
            context.unregisterReceiver(broadcastreceiver);
        }
        context.unregisterReceiver(broadcastreceiver);
        return s1;
        throw exception;
    }

    private static String waitAndGetIccid(Context context) {
        Exception exception;
        ensureNotOnMainThread(context);
        TelephonyManager telephonymanager = (TelephonyManager)context.getSystemService("phone");
        final AsyncFuture future = new AsyncFuture();
        BroadcastReceiver broadcastreceiver = new BroadcastReceiver() {

            public void onReceive(Context context1, Intent intent) {
                if("LOADED".equals(intent.getStringExtra("ss"))) {
                    TelephonyManager telephonymanager1 = (TelephonyManager)context1.getSystemService("phone");
                    future.setResult(telephonymanager1.getSimSerialNumber());
                }
            }

            final AsyncFuture val$future;

             {
                future = asyncfuture;
                super();
            }
        };
        context.registerReceiver(broadcastreceiver, new IntentFilter("android.intent.action.SIM_STATE_CHANGED"));
        String s = telephonymanager.getSimSerialNumber();
        if(!TextUtils.isEmpty(s))
            future.setResult(s);
        String s1;
        try {
            s1 = (String)future.get();
        }
        catch(Exception exception1) {
            s1 = null;
        }
        finally {
            context.unregisterReceiver(broadcastreceiver);
        }
        context.unregisterReceiver(broadcastreceiver);
        return s1;
        throw exception;
    }

    private static String waitAndGetImsi(Context context) {
        Exception exception;
        ensureNotOnMainThread(context);
        TelephonyManager telephonymanager = (TelephonyManager)context.getSystemService("phone");
        final AsyncFuture future = new AsyncFuture();
        BroadcastReceiver broadcastreceiver = new BroadcastReceiver() {

            public void onReceive(Context context1, Intent intent) {
                if("IMSI".equals(intent.getStringExtra("ss"))) {
                    TelephonyManager telephonymanager1 = (TelephonyManager)context1.getSystemService("phone");
                    future.setResult(telephonymanager1.getSubscriberId());
                }
            }

            final AsyncFuture val$future;

             {
                future = asyncfuture;
                super();
            }
        };
        context.registerReceiver(broadcastreceiver, new IntentFilter("android.intent.action.SIM_STATE_CHANGED"));
        String s = telephonymanager.getSubscriberId();
        if(!TextUtils.isEmpty(s))
            future.setResult(s);
        String s1;
        try {
            s1 = (String)future.get();
        }
        catch(Exception exception1) {
            s1 = null;
        }
        finally {
            context.unregisterReceiver(broadcastreceiver);
        }
        context.unregisterReceiver(broadcastreceiver);
        return s1;
        throw exception;
    }

    public static final String ACTION_DEVICE_ID_READY = "android.intent.action.DEVICE_ID_READY";
    public static final String ACTION_ENTER_INCALL_SCREEN_DURING_CALL = "android.intent.action.ENTER_INCALL_SCREEN_DURING_CALL";
    public static final String ACTION_LEAVE_INCALL_SCREEN_DURING_CALL = "android.intent.action.LEAVE_INCALL_SCREEN_DURING_CALL";
    public static final String EXTRA_BASE_TIME = "base_time";
    public static final String EXTRA_CALL_STATE = "call_state";
    public static final String EXTRA_CALL_STATE_ACTIVE;
    public static final String EXTRA_CALL_STATE_DIALING;
    public static final String EXTRA_CALL_STATE_HOLDING;
    public static final String EXTRA_DEVICE_ID = "device_id";
    private static final AtomicReference mDeviceIdCache = new AtomicReference();
    private static final AtomicReference mIccIdCache = new AtomicReference();
    private static final AtomicReference mImsiCache = new AtomicReference();

    static  {
        EXTRA_CALL_STATE_DIALING = com.android.internal.telephony.Call.State.DIALING.toString();
        EXTRA_CALL_STATE_ACTIVE = com.android.internal.telephony.Call.State.ACTIVE.toString();
        EXTRA_CALL_STATE_HOLDING = com.android.internal.telephony.Call.State.HOLDING.toString();
    }



}
