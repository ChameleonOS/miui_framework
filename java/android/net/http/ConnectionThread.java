// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.http;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;

// Referenced classes of package android.net.http:
//            RequestFeeder, Request, Connection

class ConnectionThread extends Thread {

    ConnectionThread(Context context, int i, RequestQueue.ConnectionManager connectionmanager, RequestFeeder requestfeeder) {
        mRunning = true;
        mContext = context;
        setName((new StringBuilder()).append("http").append(i).toString());
        mId = i;
        mConnectionManager = connectionmanager;
        mRequestFeeder = requestfeeder;
    }

    void requestStop() {
        RequestFeeder requestfeeder = mRequestFeeder;
        requestfeeder;
        JVM INSTR monitorenter ;
        mRunning = false;
        mRequestFeeder.notify();
        return;
    }

    public void run() {
        Process.setThreadPriority(1);
        mCurrentThreadTime = 0L;
        mTotalThreadTime = 0L;
_L2:
        Request request;
        if(!mRunning)
            break MISSING_BLOCK_LABEL_225;
        if(mCurrentThreadTime == -1L)
            mCurrentThreadTime = SystemClock.currentThreadTimeMillis();
        request = mRequestFeeder.getRequest();
        if(request != null)
            break MISSING_BLOCK_LABEL_109;
        RequestFeeder requestfeeder = mRequestFeeder;
        requestfeeder;
        JVM INSTR monitorenter ;
        mWaiting = true;
        long l;
        Exception exception;
        try {
            mRequestFeeder.wait();
        }
        catch(InterruptedException interruptedexception) { }
        mWaiting = false;
        if(mCurrentThreadTime != 0L)
            mCurrentThreadTime = SystemClock.currentThreadTimeMillis();
        requestfeeder;
        JVM INSTR monitorexit ;
        continue; /* Loop/switch isn't completed */
        exception;
        throw exception;
        mConnection = mConnectionManager.getConnection(mContext, request.mHost);
        mConnection.processRequests(request);
        if(mConnection.getCanPersist()) {
            if(!mConnectionManager.recycleConnection(mConnection))
                mConnection.closeConnection();
        } else {
            mConnection.closeConnection();
        }
        mConnection = null;
        if(mCurrentThreadTime > 0L) {
            l = mCurrentThreadTime;
            mCurrentThreadTime = SystemClock.currentThreadTimeMillis();
            mTotalThreadTime = mTotalThreadTime + (mCurrentThreadTime - l);
        }
        continue; /* Loop/switch isn't completed */
        return;
        if(true) goto _L2; else goto _L1
_L1:
    }

    /**
     * @deprecated Method toString is deprecated
     */

    public String toString() {
        this;
        JVM INSTR monitorenter ;
        if(mConnection != null) goto _L2; else goto _L1
_L1:
        String s = "";
_L5:
        if(!mWaiting) goto _L4; else goto _L3
_L3:
        String s1 = "w";
_L6:
        String s2 = (new StringBuilder()).append("cid ").append(mId).append(" ").append(s1).append(" ").append(s).toString();
        this;
        JVM INSTR monitorexit ;
        return s2;
_L2:
        s = mConnection.toString();
          goto _L5
_L4:
        s1 = "a";
          goto _L6
        Exception exception;
        exception;
        throw exception;
          goto _L5
    }

    static final int WAIT_TICK = 1000;
    static final int WAIT_TIMEOUT = 5000;
    Connection mConnection;
    private RequestQueue.ConnectionManager mConnectionManager;
    private Context mContext;
    long mCurrentThreadTime;
    private int mId;
    private RequestFeeder mRequestFeeder;
    private volatile boolean mRunning;
    long mTotalThreadTime;
    private boolean mWaiting;
}
