// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.os;

import android.content.Context;
import android.os.*;

public class HandlerCaller {
    public static interface Callback {

        public abstract void executeMessage(Message message);
    }

    class MyHandler extends Handler {

        public void handleMessage(Message message) {
            mCallback.executeMessage(message);
        }

        final HandlerCaller this$0;

        MyHandler(Looper looper) {
            this$0 = HandlerCaller.this;
            super(looper);
        }
    }

    public static class SomeArgs {

        public Object arg1;
        public Object arg2;
        public Object arg3;
        public Object arg4;
        public int argi1;
        public int argi2;
        public int argi3;
        public int argi4;
        public int argi5;
        public int argi6;
        SomeArgs next;

        public SomeArgs() {
        }
    }


    public HandlerCaller(Context context, Looper looper, Callback callback) {
        mContext = context;
        mMainLooper = looper;
        mH = new MyHandler(mMainLooper);
        mCallback = callback;
    }

    public HandlerCaller(Context context, Callback callback) {
        mContext = context;
        mMainLooper = context.getMainLooper();
        mH = new MyHandler(mMainLooper);
        mCallback = callback;
    }

    public void executeOrSendMessage(Message message) {
        if(Looper.myLooper() == mMainLooper) {
            mCallback.executeMessage(message);
            message.recycle();
        } else {
            mH.sendMessage(message);
        }
    }

    public boolean hasMessages(int i) {
        return mH.hasMessages(i);
    }

    public SomeArgs obtainArgs() {
        SomeArgs someargs;
        synchronized(mH) {
            someargs = mArgsPool;
            if(someargs != null) {
                mArgsPool = someargs.next;
                someargs.next = null;
                mArgsPoolSize = -1 + mArgsPoolSize;
                break MISSING_BLOCK_LABEL_63;
            }
        }
        someargs = new SomeArgs();
          goto _L1
        exception;
        handler;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
        return someargs;
    }

    public Message obtainMessage(int i) {
        return mH.obtainMessage(i);
    }

    public Message obtainMessageBO(int i, boolean flag, Object obj) {
        Handler handler = mH;
        int j;
        if(flag)
            j = 1;
        else
            j = 0;
        return handler.obtainMessage(i, j, 0, obj);
    }

    public Message obtainMessageBOO(int i, boolean flag, Object obj, Object obj1) {
        SomeArgs someargs = obtainArgs();
        someargs.arg1 = obj;
        someargs.arg2 = obj1;
        Handler handler = mH;
        int j;
        if(flag)
            j = 1;
        else
            j = 0;
        return handler.obtainMessage(i, j, 0, someargs);
    }

    public Message obtainMessageI(int i, int j) {
        return mH.obtainMessage(i, j, 0);
    }

    public Message obtainMessageII(int i, int j, int k) {
        return mH.obtainMessage(i, j, k);
    }

    public Message obtainMessageIIII(int i, int j, int k, int l, int i1) {
        SomeArgs someargs = obtainArgs();
        someargs.argi1 = j;
        someargs.argi2 = k;
        someargs.argi3 = l;
        someargs.argi4 = i1;
        return mH.obtainMessage(i, 0, 0, someargs);
    }

    public Message obtainMessageIIIIII(int i, int j, int k, int l, int i1, int j1, int k1) {
        SomeArgs someargs = obtainArgs();
        someargs.argi1 = j;
        someargs.argi2 = k;
        someargs.argi3 = l;
        someargs.argi4 = i1;
        someargs.argi5 = j1;
        someargs.argi6 = k1;
        return mH.obtainMessage(i, 0, 0, someargs);
    }

    public Message obtainMessageIIIIO(int i, int j, int k, int l, int i1, Object obj) {
        SomeArgs someargs = obtainArgs();
        someargs.arg1 = obj;
        someargs.argi1 = j;
        someargs.argi2 = k;
        someargs.argi3 = l;
        someargs.argi4 = i1;
        return mH.obtainMessage(i, 0, 0, someargs);
    }

    public Message obtainMessageIIO(int i, int j, int k, Object obj) {
        return mH.obtainMessage(i, j, k, obj);
    }

    public Message obtainMessageIIOO(int i, int j, int k, Object obj, Object obj1) {
        SomeArgs someargs = obtainArgs();
        someargs.arg1 = obj;
        someargs.arg2 = obj1;
        return mH.obtainMessage(i, j, k, someargs);
    }

    public Message obtainMessageIO(int i, int j, Object obj) {
        return mH.obtainMessage(i, j, 0, obj);
    }

    public Message obtainMessageIOO(int i, int j, Object obj, Object obj1) {
        SomeArgs someargs = obtainArgs();
        someargs.arg1 = obj;
        someargs.arg2 = obj1;
        return mH.obtainMessage(i, j, 0, someargs);
    }

    public Message obtainMessageO(int i, Object obj) {
        return mH.obtainMessage(i, 0, 0, obj);
    }

    public Message obtainMessageOO(int i, Object obj, Object obj1) {
        SomeArgs someargs = obtainArgs();
        someargs.arg1 = obj;
        someargs.arg2 = obj1;
        return mH.obtainMessage(i, 0, 0, someargs);
    }

    public Message obtainMessageOOO(int i, Object obj, Object obj1, Object obj2) {
        SomeArgs someargs = obtainArgs();
        someargs.arg1 = obj;
        someargs.arg2 = obj1;
        someargs.arg3 = obj2;
        return mH.obtainMessage(i, 0, 0, someargs);
    }

    public Message obtainMessageOOOO(int i, Object obj, Object obj1, Object obj2, Object obj3) {
        SomeArgs someargs = obtainArgs();
        someargs.arg1 = obj;
        someargs.arg2 = obj1;
        someargs.arg3 = obj2;
        someargs.arg4 = obj3;
        return mH.obtainMessage(i, 0, 0, someargs);
    }

    public void recycleArgs(SomeArgs someargs) {
        Handler handler = mH;
        handler;
        JVM INSTR monitorenter ;
        if(mArgsPoolSize < 10) {
            someargs.next = mArgsPool;
            mArgsPool = someargs;
            mArgsPoolSize = 1 + mArgsPoolSize;
        }
        return;
    }

    public void removeMessages(int i) {
        mH.removeMessages(i);
    }

    public void removeMessages(int i, Object obj) {
        mH.removeMessages(i, obj);
    }

    public void sendMessage(Message message) {
        mH.sendMessage(message);
    }

    static final int ARGS_POOL_MAX_SIZE = 10;
    private static final boolean DEBUG = false;
    private static final String TAG = "HandlerCaller";
    SomeArgs mArgsPool;
    int mArgsPoolSize;
    final Callback mCallback;
    public final Context mContext;
    final Handler mH;
    final Looper mMainLooper;
}
