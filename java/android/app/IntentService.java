// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.Intent;
import android.os.*;

// Referenced classes of package android.app:
//            Service

public abstract class IntentService extends Service {
    private final class ServiceHandler extends Handler {

        public void handleMessage(Message message) {
            onHandleIntent((Intent)message.obj);
            stopSelf(message.arg1);
        }

        final IntentService this$0;

        public ServiceHandler(Looper looper) {
            this$0 = IntentService.this;
            super(looper);
        }
    }


    public IntentService(String s) {
        mName = s;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        HandlerThread handlerthread = new HandlerThread((new StringBuilder()).append("IntentService[").append(mName).append("]").toString());
        handlerthread.start();
        mServiceLooper = handlerthread.getLooper();
        mServiceHandler = new ServiceHandler(mServiceLooper);
    }

    public void onDestroy() {
        mServiceLooper.quit();
    }

    protected abstract void onHandleIntent(Intent intent);

    public void onStart(Intent intent, int i) {
        Message message = mServiceHandler.obtainMessage();
        message.arg1 = i;
        message.obj = intent;
        mServiceHandler.sendMessage(message);
    }

    public int onStartCommand(Intent intent, int i, int j) {
        onStart(intent, j);
        byte byte0;
        if(mRedelivery)
            byte0 = 3;
        else
            byte0 = 2;
        return byte0;
    }

    public void setIntentRedelivery(boolean flag) {
        mRedelivery = flag;
    }

    private String mName;
    private boolean mRedelivery;
    private volatile ServiceHandler mServiceHandler;
    private volatile Looper mServiceLooper;
}
