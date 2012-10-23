// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.server;

import android.os.ConditionVariable;
import android.os.SystemClock;

abstract class ResettableTimeout {
    private class T extends Thread {

        public void run() {
            mLock.open();
_L2:
            this;
            JVM INSTR monitorenter ;
            long l;
            l = mOffAt - SystemClock.uptimeMillis();
            if(l > 0L)
                break MISSING_BLOCK_LABEL_58;
            mOffCalled = true;
            off();
            mThread = null;
            this;
            JVM INSTR monitorexit ;
            return;
            this;
            JVM INSTR monitorexit ;
            try {
                sleep(l);
            }
            catch(InterruptedException interruptedexception) { }
            if(true) goto _L2; else goto _L1
_L1:
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }

        final ResettableTimeout this$0;

        private T() {
            this$0 = ResettableTimeout.this;
            super();
        }

    }


    ResettableTimeout() {
        mLock = new ConditionVariable();
    }

    public void cancel() {
        this;
        JVM INSTR monitorenter ;
        mOffAt = 0L;
        if(mThread != null) {
            mThread.interrupt();
            mThread = null;
        }
        if(!mOffCalled) {
            mOffCalled = true;
            off();
        }
        return;
    }

    public void go(long l) {
        this;
        JVM INSTR monitorenter ;
        mOffAt = l + SystemClock.uptimeMillis();
        boolean flag;
        if(mThread == null) {
            flag = false;
            mLock.close();
            mThread = new T();
            mThread.start();
            mLock.block();
            mOffCalled = false;
        } else {
            flag = true;
            mThread.interrupt();
        }
        on(flag);
        return;
    }

    public abstract void off();

    public abstract void on(boolean flag);

    private ConditionVariable mLock;
    private volatile long mOffAt;
    private volatile boolean mOffCalled;
    private Thread mThread;




/*
    static boolean access$302(ResettableTimeout resettabletimeout, boolean flag) {
        resettabletimeout.mOffCalled = flag;
        return flag;
    }

*/


/*
    static Thread access$402(ResettableTimeout resettabletimeout, Thread thread) {
        resettabletimeout.mThread = thread;
        return thread;
    }

*/
}
