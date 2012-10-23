// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database.sqlite;

import android.os.*;
import android.util.*;
import dalvik.system.CloseGuard;
import java.io.Closeable;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

// Referenced classes of package android.database.sqlite:
//            SQLiteDatabaseConfiguration, SQLiteConnection, SQLiteGlobal

public final class SQLiteConnectionPool
    implements Closeable {
    private static final class ConnectionWaiter {

        public SQLiteConnection mAssignedConnection;
        public int mConnectionFlags;
        public RuntimeException mException;
        public ConnectionWaiter mNext;
        public int mNonce;
        public int mPriority;
        public String mSql;
        public long mStartTime;
        public Thread mThread;
        public boolean mWantPrimaryConnection;

        private ConnectionWaiter() {
        }

    }

    static final class AcquiredConnectionStatus extends Enum {

        public static AcquiredConnectionStatus valueOf(String s) {
            return (AcquiredConnectionStatus)Enum.valueOf(android/database/sqlite/SQLiteConnectionPool$AcquiredConnectionStatus, s);
        }

        public static AcquiredConnectionStatus[] values() {
            return (AcquiredConnectionStatus[])$VALUES.clone();
        }

        private static final AcquiredConnectionStatus $VALUES[];
        public static final AcquiredConnectionStatus DISCARD;
        public static final AcquiredConnectionStatus NORMAL;
        public static final AcquiredConnectionStatus RECONFIGURE;

        static  {
            NORMAL = new AcquiredConnectionStatus("NORMAL", 0);
            RECONFIGURE = new AcquiredConnectionStatus("RECONFIGURE", 1);
            DISCARD = new AcquiredConnectionStatus("DISCARD", 2);
            AcquiredConnectionStatus aacquiredconnectionstatus[] = new AcquiredConnectionStatus[3];
            aacquiredconnectionstatus[0] = NORMAL;
            aacquiredconnectionstatus[1] = RECONFIGURE;
            aacquiredconnectionstatus[2] = DISCARD;
            $VALUES = aacquiredconnectionstatus;
        }

        private AcquiredConnectionStatus(String s, int i) {
            super(s, i);
        }
    }


    private SQLiteConnectionPool(SQLiteDatabaseConfiguration sqlitedatabaseconfiguration) {
        mConfiguration = new SQLiteDatabaseConfiguration(sqlitedatabaseconfiguration);
        setMaxConnectionPoolSizeLocked();
    }

    private void cancelConnectionWaiterLocked(ConnectionWaiter connectionwaiter) {
        if(connectionwaiter.mAssignedConnection == null && connectionwaiter.mException == null) {
            ConnectionWaiter connectionwaiter1 = null;
            for(ConnectionWaiter connectionwaiter2 = mConnectionWaiterQueue; connectionwaiter2 != connectionwaiter; connectionwaiter2 = connectionwaiter2.mNext) {
                if(!$assertionsDisabled && connectionwaiter2 == null)
                    throw new AssertionError();
                connectionwaiter1 = connectionwaiter2;
            }

            if(connectionwaiter1 != null)
                connectionwaiter1.mNext = connectionwaiter.mNext;
            else
                mConnectionWaiterQueue = connectionwaiter.mNext;
            connectionwaiter.mException = new OperationCanceledException();
            LockSupport.unpark(connectionwaiter.mThread);
            wakeConnectionWaitersLocked();
        }
    }

    private void closeAvailableConnectionsAndLogExceptionsLocked() {
        closeAvailableNonPrimaryConnectionsAndLogExceptionsLocked();
        if(mAvailablePrimaryConnection != null) {
            closeConnectionAndLogExceptionsLocked(mAvailablePrimaryConnection);
            mAvailablePrimaryConnection = null;
        }
    }

    private void closeAvailableNonPrimaryConnectionsAndLogExceptionsLocked() {
        int i = mAvailableNonPrimaryConnections.size();
        for(int j = 0; j < i; j++)
            closeConnectionAndLogExceptionsLocked((SQLiteConnection)mAvailableNonPrimaryConnections.get(j));

        mAvailableNonPrimaryConnections.clear();
    }

    private void closeConnectionAndLogExceptionsLocked(SQLiteConnection sqliteconnection) {
        sqliteconnection.close();
_L1:
        return;
        RuntimeException runtimeexception;
        runtimeexception;
        Log.e("SQLiteConnectionPool", (new StringBuilder()).append("Failed to close connection, its fate is now in the hands of the merciful GC: ").append(sqliteconnection).toString(), runtimeexception);
          goto _L1
    }

    private void closeExcessConnectionsAndLogExceptionsLocked() {
        int i = mAvailableNonPrimaryConnections.size();
        do {
            int j = i - 1;
            if(i > -1 + mMaxConnectionPoolSize) {
                closeConnectionAndLogExceptionsLocked((SQLiteConnection)mAvailableNonPrimaryConnections.remove(j));
                i = j;
            } else {
                return;
            }
        } while(true);
    }

    private void discardAcquiredConnectionsLocked() {
        markAcquiredConnectionsLocked(AcquiredConnectionStatus.DISCARD);
    }

    private void dispose(boolean flag) {
        if(mCloseGuard != null) {
            if(flag)
                mCloseGuard.warnIfOpen();
            mCloseGuard.close();
        }
        if(flag)
            break MISSING_BLOCK_LABEL_128;
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        throwIfClosedLocked();
        mIsOpen = false;
        closeAvailableConnectionsAndLogExceptionsLocked();
        int i = mAcquiredConnections.size();
        if(i != 0)
            Log.i("SQLiteConnectionPool", (new StringBuilder()).append("The connection pool for ").append(mConfiguration.label).append(" has been closed but there are still ").append(i).append(" connections in use.  They will be closed ").append("as they are released back to the pool.").toString());
        wakeConnectionWaitersLocked();
    }

    private void finishAcquireConnectionLocked(SQLiteConnection sqliteconnection, int i) {
        boolean flag;
        if((i & 1) != 0)
            flag = true;
        else
            flag = false;
        try {
            sqliteconnection.setOnlyAllowReadOnlyOperations(flag);
            mAcquiredConnections.put(sqliteconnection, AcquiredConnectionStatus.NORMAL);
            return;
        }
        catch(RuntimeException runtimeexception) {
            Log.e("SQLiteConnectionPool", (new StringBuilder()).append("Failed to prepare acquired connection for session, closing it: ").append(sqliteconnection).append(", connectionFlags=").append(i).toString());
            closeConnectionAndLogExceptionsLocked(sqliteconnection);
            throw runtimeexception;
        }
    }

    private static int getPriority(int i) {
        int j;
        if((i & 4) != 0)
            j = 1;
        else
            j = 0;
        return j;
    }

    private boolean isSessionBlockingImportantConnectionWaitersLocked(boolean flag, int i) {
        ConnectionWaiter connectionwaiter = mConnectionWaiterQueue;
        if(connectionwaiter == null) goto _L2; else goto _L1
_L1:
        int j = getPriority(i);
_L6:
        if(j <= connectionwaiter.mPriority) goto _L3; else goto _L2
_L2:
        boolean flag1 = false;
_L5:
        return flag1;
_L3:
        if(!flag && connectionwaiter.mWantPrimaryConnection)
            break; /* Loop/switch isn't completed */
        flag1 = true;
        if(true) goto _L5; else goto _L4
_L4:
        connectionwaiter = connectionwaiter.mNext;
        if(connectionwaiter != null) goto _L6; else goto _L2
    }

    private void logConnectionPoolBusyLocked(long l, int i) {
        Thread thread = Thread.currentThread();
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("The connection pool for database '").append(mConfiguration.label);
        stringbuilder.append("' has been unable to grant a connection to thread ");
        stringbuilder.append(thread.getId()).append(" (").append(thread.getName()).append(") ");
        stringbuilder.append("with flags 0x").append(Integer.toHexString(i));
        stringbuilder.append(" for ").append(0.001F * (float)l).append(" seconds.\n");
        ArrayList arraylist = new ArrayList();
        int j = 0;
        int k = 0;
        if(!mAcquiredConnections.isEmpty()) {
            for(Iterator iterator1 = mAcquiredConnections.keySet().iterator(); iterator1.hasNext();) {
                String s1 = ((SQLiteConnection)iterator1.next()).describeCurrentOperationUnsafe();
                if(s1 != null) {
                    arraylist.add(s1);
                    j++;
                } else {
                    k++;
                }
            }

        }
        int i1 = mAvailableNonPrimaryConnections.size();
        if(mAvailablePrimaryConnection != null)
            i1++;
        stringbuilder.append("Connections: ").append(j).append(" active, ");
        stringbuilder.append(k).append(" idle, ");
        stringbuilder.append(i1).append(" available.\n");
        if(!arraylist.isEmpty()) {
            stringbuilder.append("\nRequests in progress:\n");
            String s;
            for(Iterator iterator = arraylist.iterator(); iterator.hasNext(); stringbuilder.append("  ").append(s).append("\n"))
                s = (String)iterator.next();

        }
        Log.w("SQLiteConnectionPool", stringbuilder.toString());
    }

    private void markAcquiredConnectionsLocked(AcquiredConnectionStatus acquiredconnectionstatus) {
        if(!mAcquiredConnections.isEmpty()) {
            ArrayList arraylist = new ArrayList(mAcquiredConnections.size());
            Iterator iterator = mAcquiredConnections.entrySet().iterator();
            do {
                if(!iterator.hasNext())
                    break;
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                AcquiredConnectionStatus acquiredconnectionstatus1 = (AcquiredConnectionStatus)entry.getValue();
                if(acquiredconnectionstatus != acquiredconnectionstatus1 && acquiredconnectionstatus1 != AcquiredConnectionStatus.DISCARD)
                    arraylist.add(entry.getKey());
            } while(true);
            int i = arraylist.size();
            for(int j = 0; j < i; j++)
                mAcquiredConnections.put(arraylist.get(j), acquiredconnectionstatus);

        }
    }

    private ConnectionWaiter obtainConnectionWaiterLocked(Thread thread, long l, int i, boolean flag, String s, int j) {
        ConnectionWaiter connectionwaiter = mConnectionWaiterPool;
        if(connectionwaiter != null) {
            mConnectionWaiterPool = connectionwaiter.mNext;
            connectionwaiter.mNext = null;
        } else {
            connectionwaiter = new ConnectionWaiter();
        }
        connectionwaiter.mThread = thread;
        connectionwaiter.mStartTime = l;
        connectionwaiter.mPriority = i;
        connectionwaiter.mWantPrimaryConnection = flag;
        connectionwaiter.mSql = s;
        connectionwaiter.mConnectionFlags = j;
        return connectionwaiter;
    }

    public static SQLiteConnectionPool open(SQLiteDatabaseConfiguration sqlitedatabaseconfiguration) {
        if(sqlitedatabaseconfiguration == null) {
            throw new IllegalArgumentException("configuration must not be null.");
        } else {
            SQLiteConnectionPool sqliteconnectionpool = new SQLiteConnectionPool(sqlitedatabaseconfiguration);
            sqliteconnectionpool.open();
            return sqliteconnectionpool;
        }
    }

    private void open() {
        mAvailablePrimaryConnection = openConnectionLocked(mConfiguration, true);
        mIsOpen = true;
        mCloseGuard.open("close");
    }

    private SQLiteConnection openConnectionLocked(SQLiteDatabaseConfiguration sqlitedatabaseconfiguration, boolean flag) {
        int i = mNextConnectionId;
        mNextConnectionId = i + 1;
        return SQLiteConnection.open(this, sqlitedatabaseconfiguration, i, flag);
    }

    private void reconfigureAllConnectionsLocked() {
        int i;
        int j;
        SQLiteConnection sqliteconnection;
        int k;
        if(mAvailablePrimaryConnection != null)
            try {
                mAvailablePrimaryConnection.reconfigure(mConfiguration);
            }
            catch(RuntimeException runtimeexception1) {
                Log.e("SQLiteConnectionPool", (new StringBuilder()).append("Failed to reconfigure available primary connection, closing it: ").append(mAvailablePrimaryConnection).toString(), runtimeexception1);
                closeConnectionAndLogExceptionsLocked(mAvailablePrimaryConnection);
                mAvailablePrimaryConnection = null;
            }
        i = mAvailableNonPrimaryConnections.size();
        j = 0;
        if(j >= i)
            break; /* Loop/switch isn't completed */
        sqliteconnection = (SQLiteConnection)mAvailableNonPrimaryConnections.get(j);
        sqliteconnection.reconfigure(mConfiguration);
        k = j;
_L4:
        j = k + 1;
        if(true) goto _L2; else goto _L1
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break MISSING_BLOCK_LABEL_28;
        RuntimeException runtimeexception;
        runtimeexception;
        Log.e("SQLiteConnectionPool", (new StringBuilder()).append("Failed to reconfigure available non-primary connection, closing it: ").append(sqliteconnection).toString(), runtimeexception);
        closeConnectionAndLogExceptionsLocked(sqliteconnection);
        ArrayList arraylist = mAvailableNonPrimaryConnections;
        k = j - 1;
        arraylist.remove(j);
        i--;
        if(true) goto _L4; else goto _L3
_L3:
        markAcquiredConnectionsLocked(AcquiredConnectionStatus.RECONFIGURE);
        return;
    }

    private boolean recycleConnectionLocked(SQLiteConnection sqliteconnection, AcquiredConnectionStatus acquiredconnectionstatus) {
        boolean flag;
        if(acquiredconnectionstatus == AcquiredConnectionStatus.RECONFIGURE)
            try {
                sqliteconnection.reconfigure(mConfiguration);
            }
            catch(RuntimeException runtimeexception) {
                Log.e("SQLiteConnectionPool", (new StringBuilder()).append("Failed to reconfigure released connection, closing it: ").append(sqliteconnection).toString(), runtimeexception);
                acquiredconnectionstatus = AcquiredConnectionStatus.DISCARD;
            }
        if(acquiredconnectionstatus == AcquiredConnectionStatus.DISCARD) {
            closeConnectionAndLogExceptionsLocked(sqliteconnection);
            flag = false;
        } else {
            flag = true;
        }
        return flag;
    }

    private void recycleConnectionWaiterLocked(ConnectionWaiter connectionwaiter) {
        connectionwaiter.mNext = mConnectionWaiterPool;
        connectionwaiter.mThread = null;
        connectionwaiter.mSql = null;
        connectionwaiter.mAssignedConnection = null;
        connectionwaiter.mException = null;
        connectionwaiter.mNonce = 1 + connectionwaiter.mNonce;
        mConnectionWaiterPool = connectionwaiter;
    }

    private void setMaxConnectionPoolSizeLocked() {
        if((0x20000000 & mConfiguration.openFlags) != 0)
            mMaxConnectionPoolSize = SQLiteGlobal.getWALConnectionPoolSize();
        else
            mMaxConnectionPoolSize = 1;
    }

    private void throwIfClosedLocked() {
        if(!mIsOpen)
            throw new IllegalStateException("Cannot perform this operation because the connection pool has been closed.");
        else
            return;
    }

    private SQLiteConnection tryAcquireNonPrimaryConnectionLocked(String s, int i) {
        int j;
        int l;
        j = mAvailableNonPrimaryConnections.size();
        if(j <= 1 || s == null)
            break MISSING_BLOCK_LABEL_75;
        l = 0;
_L3:
        SQLiteConnection sqliteconnection;
        if(l >= j)
            break MISSING_BLOCK_LABEL_75;
        sqliteconnection = (SQLiteConnection)mAvailableNonPrimaryConnections.get(l);
        if(!sqliteconnection.isPreparedStatementInCache(s)) goto _L2; else goto _L1
_L1:
        mAvailableNonPrimaryConnections.remove(l);
        finishAcquireConnectionLocked(sqliteconnection, i);
_L4:
        return sqliteconnection;
_L2:
        l++;
          goto _L3
        if(j > 0) {
            sqliteconnection = (SQLiteConnection)mAvailableNonPrimaryConnections.remove(j - 1);
            finishAcquireConnectionLocked(sqliteconnection, i);
        } else {
            int k = mAcquiredConnections.size();
            if(mAvailablePrimaryConnection != null)
                k++;
            if(k >= mMaxConnectionPoolSize) {
                sqliteconnection = null;
            } else {
                sqliteconnection = openConnectionLocked(mConfiguration, false);
                finishAcquireConnectionLocked(sqliteconnection, i);
            }
        }
          goto _L4
    }

    private SQLiteConnection tryAcquirePrimaryConnectionLocked(int i) {
        SQLiteConnection sqliteconnection;
        SQLiteConnection sqliteconnection1;
        sqliteconnection = null;
        sqliteconnection1 = mAvailablePrimaryConnection;
        if(sqliteconnection1 == null) goto _L2; else goto _L1
_L1:
        mAvailablePrimaryConnection = null;
        finishAcquireConnectionLocked(sqliteconnection1, i);
        sqliteconnection = sqliteconnection1;
_L4:
        return sqliteconnection;
_L2:
        for(Iterator iterator = mAcquiredConnections.keySet().iterator(); iterator.hasNext();)
            if(((SQLiteConnection)iterator.next()).isPrimaryConnection())
                continue; /* Loop/switch isn't completed */

        SQLiteConnection sqliteconnection2 = openConnectionLocked(mConfiguration, true);
        finishAcquireConnectionLocked(sqliteconnection2, i);
        sqliteconnection = sqliteconnection2;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private SQLiteConnection waitForConnection(String s, int i, CancellationSignal cancellationsignal) {
        boolean flag;
        Object obj;
        Exception exception;
        SQLiteConnection sqliteconnection;
        int j;
        final ConnectionWaiter waiter;
        ConnectionWaiter connectionwaiter;
        ConnectionWaiter connectionwaiter1;
        final int nonce;
        long l1;
        Exception exception1;
        long l2;
        long l3;
        Object obj1;
        Exception exception2;
        RuntimeException runtimeexception;
        long l4;
        if((i & 2) != 0)
            flag = true;
        else
            flag = false;
        obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        throwIfClosedLocked();
        if(cancellationsignal != null)
            cancellationsignal.throwIfCanceled();
        sqliteconnection = null;
        if(!flag)
            sqliteconnection = tryAcquireNonPrimaryConnectionLocked(s, i);
        if(sqliteconnection == null)
            sqliteconnection = tryAcquirePrimaryConnectionLocked(i);
        if(sqliteconnection == null) goto _L2; else goto _L1
_L2:
        j = getPriority(i);
        long l = SystemClock.uptimeMillis();
        waiter = obtainConnectionWaiterLocked(Thread.currentThread(), l, j, flag, s, i);
        connectionwaiter = null;
        connectionwaiter1 = mConnectionWaiterQueue;
_L17:
        if(connectionwaiter1 == null) goto _L4; else goto _L3
_L3:
        if(j <= connectionwaiter1.mPriority) goto _L6; else goto _L5
_L5:
        waiter.mNext = connectionwaiter1;
_L4:
        if(connectionwaiter == null) goto _L8; else goto _L7
_L7:
        connectionwaiter.mNext = waiter;
_L11:
        nonce = waiter.mNonce;
        if(cancellationsignal != null)
            cancellationsignal.setOnCancelListener(new android.os.CancellationSignal.OnCancelListener() {

                public void onCancel() {
                    Object obj3 = mLock;
                    obj3;
                    JVM INSTR monitorenter ;
                    if(waiter.mNonce == nonce)
                        cancelConnectionWaiterLocked(waiter);
                    return;
                }

                final SQLiteConnectionPool this$0;
                final int val$nonce;
                final ConnectionWaiter val$waiter;

             {
                this$0 = SQLiteConnectionPool.this;
                waiter = connectionwaiter;
                nonce = i;
                super();
            }
            });
        l1 = 30000L;
        l2 = l1 + waiter.mStartTime;
_L14:
        if(mConnectionLeaked.compareAndSet(true, false))
            synchronized(mLock) {
                wakeConnectionWaitersLocked();
            }
        l3 = 0xf4240L * l1;
        LockSupport.parkNanos(this, l3);
        Thread.interrupted();
        obj1 = mLock;
        obj1;
        JVM INSTR monitorenter ;
        throwIfClosedLocked();
        sqliteconnection = waiter.mAssignedConnection;
        runtimeexception = waiter.mException;
        if(sqliteconnection == null && runtimeexception == null) goto _L10; else goto _L9
_L9:
        recycleConnectionWaiterLocked(waiter);
        if(sqliteconnection != null) {
            if(cancellationsignal != null)
                cancellationsignal.setOnCancelListener(null);
        } else {
            throw runtimeexception;
        }
          goto _L1
_L6:
        connectionwaiter = connectionwaiter1;
        connectionwaiter1 = connectionwaiter1.mNext;
        continue; /* Loop/switch isn't completed */
_L8:
        mConnectionWaiterQueue = waiter;
          goto _L11
        exception;
        throw exception;
        exception3;
        obj2;
        JVM INSTR monitorexit ;
        throw exception3;
        exception1;
        if(cancellationsignal != null)
            cancellationsignal.setOnCancelListener(null);
        throw exception1;
        exception2;
        throw exception2;
_L10:
        l4 = SystemClock.uptimeMillis();
        if(l4 >= l2) goto _L13; else goto _L12
_L12:
        l1 = l4 - l2;
_L15:
        obj1;
        JVM INSTR monitorexit ;
          goto _L14
_L13:
        logConnectionPoolBusyLocked(l4 - waiter.mStartTime, i);
        l1 = 30000L;
        l2 = l4 + l1;
          goto _L15
_L1:
        return sqliteconnection;
        if(true) goto _L17; else goto _L16
_L16:
    }

    private void wakeConnectionWaitersLocked() {
        ConnectionWaiter connectionwaiter;
        ConnectionWaiter connectionwaiter1;
        boolean flag;
        boolean flag1;
        connectionwaiter = null;
        connectionwaiter1 = mConnectionWaiterQueue;
        flag = false;
        flag1 = false;
_L5:
        if(connectionwaiter1 == null) goto _L2; else goto _L1
_L1:
        boolean flag2 = false;
        if(mIsOpen) goto _L4; else goto _L3
_L3:
        flag2 = true;
_L8:
        ConnectionWaiter connectionwaiter2 = connectionwaiter1.mNext;
        if(flag2) {
            SQLiteConnection sqliteconnection;
            RuntimeException runtimeexception;
            if(connectionwaiter != null)
                connectionwaiter.mNext = connectionwaiter2;
            else
                mConnectionWaiterQueue = connectionwaiter2;
            connectionwaiter1.mNext = null;
            LockSupport.unpark(connectionwaiter1.mThread);
        } else {
            connectionwaiter = connectionwaiter1;
        }
        connectionwaiter1 = connectionwaiter2;
          goto _L5
_L4:
        sqliteconnection = null;
        if(!connectionwaiter1.mWantPrimaryConnection && !flag1) {
            sqliteconnection = tryAcquireNonPrimaryConnectionLocked(connectionwaiter1.mSql, connectionwaiter1.mConnectionFlags);
            if(sqliteconnection == null)
                flag1 = true;
        }
        if(sqliteconnection == null && !flag) {
            sqliteconnection = tryAcquirePrimaryConnectionLocked(connectionwaiter1.mConnectionFlags);
            if(sqliteconnection == null)
                flag = true;
        }
        if(sqliteconnection == null) goto _L7; else goto _L6
_L6:
        connectionwaiter1.mAssignedConnection = sqliteconnection;
        flag2 = true;
          goto _L8
_L7:
        if(!flag1 || !flag) goto _L8; else goto _L2
_L2:
        return;
        runtimeexception;
        connectionwaiter1.mException = runtimeexception;
        flag2 = true;
          goto _L8
    }

    public SQLiteConnection acquireConnection(String s, int i, CancellationSignal cancellationsignal) {
        return waitForConnection(s, i, cancellationsignal);
    }

    public void close() {
        dispose(false);
    }

    public void collectDbStats(ArrayList arraylist) {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        if(mAvailablePrimaryConnection != null)
            mAvailablePrimaryConnection.collectDbStats(arraylist);
        for(Iterator iterator = mAvailableNonPrimaryConnections.iterator(); iterator.hasNext(); ((SQLiteConnection)iterator.next()).collectDbStats(arraylist));
        break MISSING_BLOCK_LABEL_63;
        Exception exception;
        exception;
        throw exception;
        for(Iterator iterator1 = mAcquiredConnections.keySet().iterator(); iterator1.hasNext(); ((SQLiteConnection)iterator1.next()).collectDbStatsUnsafe(arraylist));
        obj;
        JVM INSTR monitorexit ;
    }

    public void dump(Printer printer, boolean flag) {
        Printer printer1 = PrefixPrinter.create(printer, "    ");
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        printer.println((new StringBuilder()).append("Connection pool for ").append(mConfiguration.path).append(":").toString());
        printer.println((new StringBuilder()).append("  Open: ").append(mIsOpen).toString());
        printer.println((new StringBuilder()).append("  Max connections: ").append(mMaxConnectionPoolSize).toString());
        printer.println("  Available primary connection:");
        if(mAvailablePrimaryConnection != null)
            mAvailablePrimaryConnection.dump(printer1, flag);
        else
            printer1.println("<none>");
        printer.println("  Available non-primary connections:");
        if(!mAvailableNonPrimaryConnections.isEmpty()) {
            int j = mAvailableNonPrimaryConnections.size();
            for(int k = 0; k < j; k++)
                ((SQLiteConnection)mAvailableNonPrimaryConnections.get(k)).dump(printer1, flag);

            break MISSING_BLOCK_LABEL_228;
        }
        break MISSING_BLOCK_LABEL_219;
        Exception exception;
        exception;
        throw exception;
        printer1.println("<none>");
        printer.println("  Acquired connections:");
        if(!mAcquiredConnections.isEmpty()) {
            java.util.Map.Entry entry;
            for(Iterator iterator = mAcquiredConnections.entrySet().iterator(); iterator.hasNext(); printer1.println((new StringBuilder()).append("  Status: ").append(entry.getValue()).toString())) {
                entry = (java.util.Map.Entry)iterator.next();
                ((SQLiteConnection)entry.getKey()).dumpUnsafe(printer1, flag);
            }

        } else {
            printer1.println("<none>");
        }
        printer.println("  Connection waiters:");
        if(mConnectionWaiterQueue != null) {
            int i = 0;
            long l = SystemClock.uptimeMillis();
            for(ConnectionWaiter connectionwaiter = mConnectionWaiterQueue; connectionwaiter != null;) {
                printer1.println((new StringBuilder()).append(i).append(": waited for ").append(0.001F * (float)(l - connectionwaiter.mStartTime)).append(" ms - thread=").append(connectionwaiter.mThread).append(", priority=").append(connectionwaiter.mPriority).append(", sql='").append(connectionwaiter.mSql).append("'").toString());
                connectionwaiter = connectionwaiter.mNext;
                i++;
            }

        } else {
            printer1.println("<none>");
        }
        obj;
        JVM INSTR monitorexit ;
    }

    protected void finalize() throws Throwable {
        dispose(true);
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    void onConnectionLeaked() {
        Log.w("SQLiteConnectionPool", (new StringBuilder()).append("A SQLiteConnection object for database '").append(mConfiguration.label).append("' was leaked!  Please fix your application ").append("to end transactions in progress properly and to close the database ").append("when it is no longer needed.").toString());
        mConnectionLeaked.set(true);
    }

    public void reconfigure(SQLiteDatabaseConfiguration sqlitedatabaseconfiguration) {
        boolean flag;
        flag = true;
        if(sqlitedatabaseconfiguration == null)
            throw new IllegalArgumentException("configuration must not be null.");
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        boolean flag1;
        throwIfClosedLocked();
        Exception exception;
        if((0x20000000 & (sqlitedatabaseconfiguration.openFlags ^ mConfiguration.openFlags)) != 0)
            flag1 = flag;
        else
            flag1 = false;
        if(!flag1)
            break MISSING_BLOCK_LABEL_117;
        if(!mAcquiredConnections.isEmpty())
            throw new IllegalStateException("Write Ahead Logging (WAL) mode cannot be enabled or disabled while there are transactions in progress.  Finish all transactions and release all active database connections first.");
        break MISSING_BLOCK_LABEL_89;
        exception;
        throw exception;
        closeAvailableNonPrimaryConnectionsAndLogExceptionsLocked();
        if(!$assertionsDisabled && !mAvailableNonPrimaryConnections.isEmpty())
            throw new AssertionError();
        if(sqlitedatabaseconfiguration.foreignKeyConstraintsEnabled == mConfiguration.foreignKeyConstraintsEnabled)
            flag = false;
        if(flag && !mAcquiredConnections.isEmpty())
            throw new IllegalStateException("Foreign Key Constraints cannot be enabled or disabled while there are transactions in progress.  Finish all transactions and release all active database connections first.");
        if(mConfiguration.openFlags != sqlitedatabaseconfiguration.openFlags) {
            if(flag1)
                closeAvailableConnectionsAndLogExceptionsLocked();
            SQLiteConnection sqliteconnection = openConnectionLocked(sqlitedatabaseconfiguration, true);
            closeAvailableConnectionsAndLogExceptionsLocked();
            discardAcquiredConnectionsLocked();
            mAvailablePrimaryConnection = sqliteconnection;
            mConfiguration.updateParametersFrom(sqlitedatabaseconfiguration);
            setMaxConnectionPoolSizeLocked();
        } else {
            mConfiguration.updateParametersFrom(sqlitedatabaseconfiguration);
            setMaxConnectionPoolSizeLocked();
            closeExcessConnectionsAndLogExceptionsLocked();
            reconfigureAllConnectionsLocked();
        }
        wakeConnectionWaitersLocked();
        obj;
        JVM INSTR monitorexit ;
    }

    public void releaseConnection(SQLiteConnection sqliteconnection) {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        AcquiredConnectionStatus acquiredconnectionstatus;
        acquiredconnectionstatus = (AcquiredConnectionStatus)mAcquiredConnections.remove(sqliteconnection);
        if(acquiredconnectionstatus == null)
            throw new IllegalStateException("Cannot perform this operation because the specified connection was not acquired from this pool or has already been released.");
        break MISSING_BLOCK_LABEL_41;
        Exception exception;
        exception;
        throw exception;
        if(!mIsOpen)
            closeConnectionAndLogExceptionsLocked(sqliteconnection);
        else
        if(sqliteconnection.isPrimaryConnection()) {
            if(recycleConnectionLocked(sqliteconnection, acquiredconnectionstatus)) {
                if(!$assertionsDisabled && mAvailablePrimaryConnection != null)
                    throw new AssertionError();
                mAvailablePrimaryConnection = sqliteconnection;
            }
            wakeConnectionWaitersLocked();
        } else
        if(mAvailableNonPrimaryConnections.size() >= -1 + mMaxConnectionPoolSize) {
            closeConnectionAndLogExceptionsLocked(sqliteconnection);
        } else {
            if(recycleConnectionLocked(sqliteconnection, acquiredconnectionstatus))
                mAvailableNonPrimaryConnections.add(sqliteconnection);
            wakeConnectionWaitersLocked();
        }
        obj;
        JVM INSTR monitorexit ;
    }

    public boolean shouldYieldConnection(SQLiteConnection sqliteconnection, int i) {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        if(!mAcquiredConnections.containsKey(sqliteconnection))
            throw new IllegalStateException("Cannot perform this operation because the specified connection was not acquired from this pool or has already been released.");
        break MISSING_BLOCK_LABEL_36;
        Exception exception;
        exception;
        throw exception;
        if(mIsOpen) goto _L2; else goto _L1
_L1:
        boolean flag = false;
        obj;
        JVM INSTR monitorexit ;
          goto _L3
_L2:
        flag = isSessionBlockingImportantConnectionWaitersLocked(sqliteconnection.isPrimaryConnection(), i);
        obj;
        JVM INSTR monitorexit ;
_L3:
        return flag;
    }

    public String toString() {
        return (new StringBuilder()).append("SQLiteConnectionPool: ").append(mConfiguration.path).toString();
    }

    static final boolean $assertionsDisabled = false;
    public static final int CONNECTION_FLAG_INTERACTIVE = 4;
    public static final int CONNECTION_FLAG_PRIMARY_CONNECTION_AFFINITY = 2;
    public static final int CONNECTION_FLAG_READ_ONLY = 1;
    private static final long CONNECTION_POOL_BUSY_MILLIS = 30000L;
    private static final String TAG = "SQLiteConnectionPool";
    private final WeakHashMap mAcquiredConnections = new WeakHashMap();
    private final ArrayList mAvailableNonPrimaryConnections = new ArrayList();
    private SQLiteConnection mAvailablePrimaryConnection;
    private final CloseGuard mCloseGuard = CloseGuard.get();
    private final SQLiteDatabaseConfiguration mConfiguration;
    private final AtomicBoolean mConnectionLeaked = new AtomicBoolean();
    private ConnectionWaiter mConnectionWaiterPool;
    private ConnectionWaiter mConnectionWaiterQueue;
    private boolean mIsOpen;
    private final Object mLock = new Object();
    private int mMaxConnectionPoolSize;
    private int mNextConnectionId;

    static  {
        boolean flag;
        if(!android/database/sqlite/SQLiteConnectionPool.desiredAssertionStatus())
            flag = true;
        else
            flag = false;
        $assertionsDisabled = flag;
    }


}
