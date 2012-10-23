// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;


// Referenced classes of package android.os:
//            Looper, Process

public class HandlerThread extends Thread {

    public HandlerThread(String s) {
        super(s);
        mTid = -1;
        mPriority = 0;
    }

    public HandlerThread(String s, int i) {
        super(s);
        mTid = -1;
        mPriority = i;
    }

    public Looper getLooper() {
        if(isAlive()) goto _L2; else goto _L1
_L1:
        Looper looper = null;
_L8:
        return looper;
_L2:
        this;
        JVM INSTR monitorenter ;
_L6:
        if(!isAlive()) goto _L4; else goto _L3
_L3:
        Looper looper1 = mLooper;
        if(looper1 != null) goto _L4; else goto _L5
_L5:
        Exception exception;
        try {
            wait();
        }
        catch(InterruptedException interruptedexception) { }
        finally { }
        if(true) goto _L6; else goto _L4
_L4:
        this;
        JVM INSTR monitorexit ;
        looper = mLooper;
        if(true) goto _L8; else goto _L7
_L7:
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int getThreadId() {
        return mTid;
    }

    protected void onLooperPrepared() {
    }

    public boolean quit() {
        Looper looper = getLooper();
        boolean flag;
        if(looper != null) {
            looper.quit();
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public void run() {
        mTid = Process.myTid();
        Looper.prepare();
        this;
        JVM INSTR monitorenter ;
        mLooper = Looper.myLooper();
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        Process.setThreadPriority(mPriority);
        onLooperPrepared();
        Looper.loop();
        mTid = -1;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    Looper mLooper;
    int mPriority;
    int mTid;
}
