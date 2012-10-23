// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.http;

import android.os.Process;
import android.os.SystemClock;
import org.apache.http.HttpHost;

// Referenced classes of package android.net.http:
//            Connection

class IdleCache {
    private class IdleReaper extends Thread {

        public void run() {
            int i;
            i = 0;
            setName("IdleReaper");
            Process.setThreadPriority(10);
            IdleCache idlecache = IdleCache.this;
            idlecache;
            JVM INSTR monitorenter ;
            while(i < 5)  {
                Exception exception;
                try {
                    wait(2000L);
                }
                catch(InterruptedException interruptedexception) { }
                finally {
                    idlecache;
                }
                if(mCount == 0) {
                    i++;
                } else {
                    i = 0;
                    clearIdle();
                }
            }
            if(true)
                break MISSING_BLOCK_LABEL_70;
            JVM INSTR monitorexit ;
            throw exception;
            mThread = null;
            idlecache;
            JVM INSTR monitorexit ;
        }

        final IdleCache this$0;

        private IdleReaper() {
            this$0 = IdleCache.this;
            super();
        }

    }

    class Entry {

        Connection mConnection;
        HttpHost mHost;
        long mTimeout;
        final IdleCache this$0;

        Entry() {
            this$0 = IdleCache.this;
            super();
        }
    }


    IdleCache() {
        mEntries = new Entry[8];
        mCount = 0;
        mThread = null;
        mCached = 0;
        mReused = 0;
        for(int i = 0; i < 8; i++)
            mEntries[i] = new Entry();

    }

    /**
     * @deprecated Method clearIdle is deprecated
     */

    private void clearIdle() {
        this;
        JVM INSTR monitorenter ;
        long l;
        int i;
        if(mCount <= 0)
            break MISSING_BLOCK_LABEL_87;
        l = SystemClock.uptimeMillis();
        i = 0;
_L1:
        if(i >= 8)
            break MISSING_BLOCK_LABEL_87;
        Entry entry = mEntries[i];
        if(entry.mHost != null && l > entry.mTimeout) {
            entry.mHost = null;
            entry.mConnection.closeConnection();
            entry.mConnection = null;
            mCount = -1 + mCount;
        }
        i++;
          goto _L1
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method cacheConnection is deprecated
     */

    boolean cacheConnection(HttpHost httphost, Connection connection) {
        this;
        JVM INSTR monitorenter ;
        boolean flag = false;
        if(mCount >= 8) goto _L2; else goto _L1
_L1:
        long l;
        int i;
        l = SystemClock.uptimeMillis();
        i = 0;
_L3:
        if(i < 8) {
            Entry entry = mEntries[i];
            if(entry.mHost != null)
                break MISSING_BLOCK_LABEL_111;
            entry.mHost = httphost;
            entry.mConnection = connection;
            entry.mTimeout = 6000L + l;
            mCount = 1 + mCount;
            flag = true;
            if(mThread == null) {
                mThread = new IdleReaper();
                mThread.start();
            }
        }
_L2:
        this;
        JVM INSTR monitorexit ;
        return flag;
        i++;
          goto _L3
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method clear is deprecated
     */

    void clear() {
        this;
        JVM INSTR monitorenter ;
        int i = 0;
_L2:
        if(mCount <= 0 || i >= 8)
            break; /* Loop/switch isn't completed */
        Entry entry = mEntries[i];
        if(entry.mHost != null) {
            entry.mHost = null;
            entry.mConnection.closeConnection();
            entry.mConnection = null;
            mCount = -1 + mCount;
        }
        i++;
        if(true) goto _L2; else goto _L1
_L1:
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getConnection is deprecated
     */

    Connection getConnection(HttpHost httphost) {
        this;
        JVM INSTR monitorenter ;
        Connection connection = null;
        if(mCount <= 0) goto _L2; else goto _L1
_L1:
        int i = 0;
_L3:
        if(i < 8) {
            Entry entry = mEntries[i];
            HttpHost httphost1 = entry.mHost;
            if(httphost1 == null || !httphost1.equals(httphost))
                break MISSING_BLOCK_LABEL_84;
            connection = entry.mConnection;
            entry.mHost = null;
            entry.mConnection = null;
            mCount = -1 + mCount;
        }
_L2:
        this;
        JVM INSTR monitorexit ;
        return connection;
        i++;
          goto _L3
        Exception exception;
        exception;
        throw exception;
    }

    private static final int CHECK_INTERVAL = 2000;
    private static final int EMPTY_CHECK_MAX = 5;
    private static final int IDLE_CACHE_MAX = 8;
    private static final int TIMEOUT = 6000;
    private int mCached;
    private int mCount;
    private Entry mEntries[];
    private int mReused;
    private IdleReaper mThread;




/*
    static IdleReaper access$302(IdleCache idlecache, IdleReaper idlereaper) {
        idlecache.mThread = idlereaper;
        return idlereaper;
    }

*/
}
