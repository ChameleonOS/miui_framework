// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.util;

import android.app.Service;
import android.content.Intent;
import android.os.*;
import android.util.Slog;

public abstract class AsyncService extends Service {
    public static final class AsyncServiceInfo {

        public Handler mHandler;
        public int mRestartFlags;

        public AsyncServiceInfo() {
        }
    }


    public AsyncService() {
    }

    public abstract AsyncServiceInfo createHandler();

    public Handler getHandler() {
        return mHandler;
    }

    public IBinder onBind(Intent intent) {
        return mMessenger.getBinder();
    }

    public void onCreate() {
        super.onCreate();
        mAsyncServiceInfo = createHandler();
        mHandler = mAsyncServiceInfo.mHandler;
        mMessenger = new Messenger(mHandler);
    }

    public void onDestroy() {
        Slog.d("AsyncService", "onDestroy");
        Message message = mHandler.obtainMessage();
        message.what = 0x1000000;
        mHandler.sendMessage(message);
    }

    public int onStartCommand(Intent intent, int i, int j) {
        Slog.d("AsyncService", "onStartCommand");
        Message message = mHandler.obtainMessage();
        message.what = 0xffffff;
        message.arg1 = i;
        message.arg2 = j;
        message.obj = intent;
        mHandler.sendMessage(message);
        return mAsyncServiceInfo.mRestartFlags;
    }

    public static final int CMD_ASYNC_SERVICE_DESTROY = 0x1000000;
    public static final int CMD_ASYNC_SERVICE_ON_START_INTENT = 0xffffff;
    protected static final boolean DBG = true;
    private static final String TAG = "AsyncService";
    AsyncServiceInfo mAsyncServiceInfo;
    Handler mHandler;
    protected Messenger mMessenger;
}
