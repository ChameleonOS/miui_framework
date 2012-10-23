// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database.sqlite;

import android.database.CursorWindow;
import android.database.DatabaseUtils;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;

// Referenced classes of package android.database.sqlite:
//            SQLiteConnectionPool, SQLiteConnection, SQLiteTransactionListener, SQLiteStatementInfo

public final class SQLiteSession {
    private static final class Transaction {

        public boolean mChildFailed;
        public SQLiteTransactionListener mListener;
        public boolean mMarkedSuccessful;
        public int mMode;
        public Transaction mParent;

        private Transaction() {
        }

    }


    public SQLiteSession(SQLiteConnectionPool sqliteconnectionpool) {
        if(sqliteconnectionpool == null) {
            throw new IllegalArgumentException("connectionPool must not be null");
        } else {
            mConnectionPool = sqliteconnectionpool;
            return;
        }
    }

    private void acquireConnection(String s, int i, CancellationSignal cancellationsignal) {
        if(mConnection == null) {
            if(!$assertionsDisabled && mConnectionUseCount != 0)
                throw new AssertionError();
            mConnection = mConnectionPool.acquireConnection(s, i, cancellationsignal);
            mConnectionFlags = i;
        }
        mConnectionUseCount = 1 + mConnectionUseCount;
    }

    private void beginTransactionUnchecked(int i, SQLiteTransactionListener sqlitetransactionlistener, int j, CancellationSignal cancellationsignal) {
        if(cancellationsignal != null)
            cancellationsignal.throwIfCanceled();
        if(mTransactionStack == null)
            acquireConnection(null, j, cancellationsignal);
        if(mTransactionStack != null) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 1 2: default 56
    //                   1 113
    //                   2 144;
           goto _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_144;
_L3:
        mConnection.execute("BEGIN;", null, cancellationsignal);
_L2:
        if(sqlitetransactionlistener == null)
            break MISSING_BLOCK_LABEL_78;
        Exception exception;
        Transaction transaction;
        try {
            sqlitetransactionlistener.onBegin();
        }
        catch(RuntimeException runtimeexception) {
            if(mTransactionStack == null)
                mConnection.execute("ROLLBACK;", null, cancellationsignal);
            throw runtimeexception;
        }
        transaction = obtainTransaction(i, sqlitetransactionlistener);
        transaction.mParent = mTransactionStack;
        mTransactionStack = transaction;
        if(mTransactionStack == null)
            releaseConnection();
        return;
_L4:
        mConnection.execute("BEGIN IMMEDIATE;", null, cancellationsignal);
          goto _L2
        exception;
        if(mTransactionStack == null)
            releaseConnection();
        throw exception;
        mConnection.execute("BEGIN EXCLUSIVE;", null, cancellationsignal);
          goto _L2
    }

    private void endTransactionUnchecked(CancellationSignal cancellationsignal, boolean flag) {
        boolean flag1;
        RuntimeException runtimeexception;
        SQLiteTransactionListener sqlitetransactionlistener;
        if(cancellationsignal != null)
            cancellationsignal.throwIfCanceled();
        Transaction transaction = mTransactionStack;
        if((transaction.mMarkedSuccessful || flag) && !transaction.mChildFailed)
            flag1 = true;
        else
            flag1 = false;
        runtimeexception = null;
        sqlitetransactionlistener = transaction.mListener;
        if(sqlitetransactionlistener == null) goto _L2; else goto _L1
_L1:
        if(!flag1) goto _L4; else goto _L3
_L3:
        try {
            sqlitetransactionlistener.onCommit();
        }
        catch(RuntimeException runtimeexception1) {
            runtimeexception = runtimeexception1;
            flag1 = false;
        }
_L2:
        mTransactionStack = transaction.mParent;
        recycleTransaction(transaction);
        if(mTransactionStack == null) goto _L6; else goto _L5
_L5:
        if(!flag1)
            mTransactionStack.mChildFailed = true;
_L7:
        Exception exception;
        if(runtimeexception != null)
            throw runtimeexception;
        else
            return;
_L4:
        sqlitetransactionlistener.onRollback();
        continue; /* Loop/switch isn't completed */
_L6:
        if(!flag1)
            break MISSING_BLOCK_LABEL_152;
        mConnection.execute("COMMIT;", null, cancellationsignal);
_L8:
        releaseConnection();
          goto _L7
        mConnection.execute("ROLLBACK;", null, cancellationsignal);
          goto _L8
        exception;
        releaseConnection();
        throw exception;
        if(true) goto _L2; else goto _L9
_L9:
    }

    private boolean executeSpecial(String s, Object aobj[], int i, CancellationSignal cancellationsignal) {
        boolean flag;
        flag = true;
        if(cancellationsignal != null)
            cancellationsignal.throwIfCanceled();
        DatabaseUtils.getSqlStatementType(s);
        JVM INSTR tableswitch 4 6: default 44
    //                   4 50
    //                   5 62
    //                   6 75;
           goto _L1 _L2 _L3 _L4
_L1:
        flag = false;
_L6:
        return flag;
_L2:
        beginTransaction(2, null, i, cancellationsignal);
        continue; /* Loop/switch isn't completed */
_L3:
        setTransactionSuccessful();
        endTransaction(cancellationsignal);
        continue; /* Loop/switch isn't completed */
_L4:
        endTransaction(cancellationsignal);
        if(true) goto _L6; else goto _L5
_L5:
    }

    private Transaction obtainTransaction(int i, SQLiteTransactionListener sqlitetransactionlistener) {
        Transaction transaction = mTransactionPool;
        if(transaction != null) {
            mTransactionPool = transaction.mParent;
            transaction.mParent = null;
            transaction.mMarkedSuccessful = false;
            transaction.mChildFailed = false;
        } else {
            transaction = new Transaction();
        }
        transaction.mMode = i;
        transaction.mListener = sqlitetransactionlistener;
        return transaction;
    }

    private void recycleTransaction(Transaction transaction) {
        transaction.mParent = mTransactionPool;
        transaction.mListener = null;
        mTransactionPool = transaction;
    }

    private void releaseConnection() {
        if(!$assertionsDisabled && mConnection == null)
            throw new AssertionError();
        if(!$assertionsDisabled && mConnectionUseCount <= 0)
            throw new AssertionError();
        int i = -1 + mConnectionUseCount;
        mConnectionUseCount = i;
        if(i != 0)
            break MISSING_BLOCK_LABEL_75;
        mConnectionPool.releaseConnection(mConnection);
        mConnection = null;
        return;
        Exception exception;
        exception;
        mConnection = null;
        throw exception;
    }

    private void throwIfNestedTransaction() {
        if(mTransactionStack == null && mTransactionStack.mParent != null)
            throw new IllegalStateException("Cannot perform this operation because a nested transaction is in progress.");
        else
            return;
    }

    private void throwIfNoTransaction() {
        if(mTransactionStack == null)
            throw new IllegalStateException("Cannot perform this operation because there is no current transaction.");
        else
            return;
    }

    private void throwIfTransactionMarkedSuccessful() {
        if(mTransactionStack != null && mTransactionStack.mMarkedSuccessful)
            throw new IllegalStateException("Cannot perform this operation because the transaction has already been marked successful.  The only thing you can do now is call endTransaction().");
        else
            return;
    }

    private boolean yieldTransactionUnchecked(long l, CancellationSignal cancellationsignal) {
        boolean flag = true;
        if(cancellationsignal != null)
            cancellationsignal.throwIfCanceled();
        if(!mConnectionPool.shouldYieldConnection(mConnection, mConnectionFlags)) {
            flag = false;
        } else {
            int i = mTransactionStack.mMode;
            SQLiteTransactionListener sqlitetransactionlistener = mTransactionStack.mListener;
            int j = mConnectionFlags;
            endTransactionUnchecked(cancellationsignal, flag);
            if(l > 0L)
                try {
                    Thread.sleep(l);
                }
                catch(InterruptedException interruptedexception) { }
            beginTransactionUnchecked(i, sqlitetransactionlistener, j, cancellationsignal);
        }
        return flag;
    }

    public void beginTransaction(int i, SQLiteTransactionListener sqlitetransactionlistener, int j, CancellationSignal cancellationsignal) {
        throwIfTransactionMarkedSuccessful();
        beginTransactionUnchecked(i, sqlitetransactionlistener, j, cancellationsignal);
    }

    public void endTransaction(CancellationSignal cancellationsignal) {
        throwIfNoTransaction();
        if(!$assertionsDisabled && mConnection == null) {
            throw new AssertionError();
        } else {
            endTransactionUnchecked(cancellationsignal, false);
            return;
        }
    }

    public void execute(String s, Object aobj[], int i, CancellationSignal cancellationsignal) {
        if(s == null)
            throw new IllegalArgumentException("sql must not be null.");
        if(!executeSpecial(s, aobj, i, cancellationsignal)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        acquireConnection(s, i, cancellationsignal);
        mConnection.execute(s, aobj, cancellationsignal);
        releaseConnection();
        if(true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        releaseConnection();
        throw exception;
    }

    public ParcelFileDescriptor executeForBlobFileDescriptor(String s, Object aobj[], int i, CancellationSignal cancellationsignal) {
        if(s == null)
            throw new IllegalArgumentException("sql must not be null.");
        if(!executeSpecial(s, aobj, i, cancellationsignal)) goto _L2; else goto _L1
_L1:
        ParcelFileDescriptor parcelfiledescriptor1 = null;
_L4:
        return parcelfiledescriptor1;
_L2:
        acquireConnection(s, i, cancellationsignal);
        ParcelFileDescriptor parcelfiledescriptor = mConnection.executeForBlobFileDescriptor(s, aobj, cancellationsignal);
        parcelfiledescriptor1 = parcelfiledescriptor;
        releaseConnection();
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        releaseConnection();
        throw exception;
    }

    public int executeForChangedRowCount(String s, Object aobj[], int i, CancellationSignal cancellationsignal) {
        if(s == null)
            throw new IllegalArgumentException("sql must not be null.");
        if(!executeSpecial(s, aobj, i, cancellationsignal)) goto _L2; else goto _L1
_L1:
        int k = 0;
_L4:
        return k;
_L2:
        acquireConnection(s, i, cancellationsignal);
        int j = mConnection.executeForChangedRowCount(s, aobj, cancellationsignal);
        k = j;
        releaseConnection();
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        releaseConnection();
        throw exception;
    }

    public int executeForCursorWindow(String s, Object aobj[], CursorWindow cursorwindow, int i, int j, boolean flag, int k, 
            CancellationSignal cancellationsignal) {
        if(s == null)
            throw new IllegalArgumentException("sql must not be null.");
        if(cursorwindow == null)
            throw new IllegalArgumentException("window must not be null.");
        if(!executeSpecial(s, aobj, k, cancellationsignal)) goto _L2; else goto _L1
_L1:
        int i1;
        cursorwindow.clear();
        i1 = 0;
_L4:
        return i1;
_L2:
        acquireConnection(s, k, cancellationsignal);
        int l = mConnection.executeForCursorWindow(s, aobj, cursorwindow, i, j, flag, cancellationsignal);
        i1 = l;
        releaseConnection();
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        releaseConnection();
        throw exception;
    }

    public long executeForLastInsertedRowId(String s, Object aobj[], int i, CancellationSignal cancellationsignal) {
        if(s == null)
            throw new IllegalArgumentException("sql must not be null.");
        if(!executeSpecial(s, aobj, i, cancellationsignal)) goto _L2; else goto _L1
_L1:
        long l1 = 0L;
_L4:
        return l1;
_L2:
        acquireConnection(s, i, cancellationsignal);
        long l = mConnection.executeForLastInsertedRowId(s, aobj, cancellationsignal);
        l1 = l;
        releaseConnection();
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        releaseConnection();
        throw exception;
    }

    public long executeForLong(String s, Object aobj[], int i, CancellationSignal cancellationsignal) {
        if(s == null)
            throw new IllegalArgumentException("sql must not be null.");
        if(!executeSpecial(s, aobj, i, cancellationsignal)) goto _L2; else goto _L1
_L1:
        long l1 = 0L;
_L4:
        return l1;
_L2:
        acquireConnection(s, i, cancellationsignal);
        long l = mConnection.executeForLong(s, aobj, cancellationsignal);
        l1 = l;
        releaseConnection();
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        releaseConnection();
        throw exception;
    }

    public String executeForString(String s, Object aobj[], int i, CancellationSignal cancellationsignal) {
        if(s == null)
            throw new IllegalArgumentException("sql must not be null.");
        if(!executeSpecial(s, aobj, i, cancellationsignal)) goto _L2; else goto _L1
_L1:
        String s2 = null;
_L4:
        return s2;
_L2:
        acquireConnection(s, i, cancellationsignal);
        String s1 = mConnection.executeForString(s, aobj, cancellationsignal);
        s2 = s1;
        releaseConnection();
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        releaseConnection();
        throw exception;
    }

    public boolean hasConnection() {
        boolean flag;
        if(mConnection != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean hasNestedTransaction() {
        boolean flag;
        if(mTransactionStack != null && mTransactionStack.mParent != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean hasTransaction() {
        boolean flag;
        if(mTransactionStack != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void prepare(String s, int i, CancellationSignal cancellationsignal, SQLiteStatementInfo sqlitestatementinfo) {
        if(s == null)
            throw new IllegalArgumentException("sql must not be null.");
        if(cancellationsignal != null)
            cancellationsignal.throwIfCanceled();
        acquireConnection(s, i, cancellationsignal);
        mConnection.prepare(s, sqlitestatementinfo);
        releaseConnection();
        return;
        Exception exception;
        exception;
        releaseConnection();
        throw exception;
    }

    public void setTransactionSuccessful() {
        throwIfNoTransaction();
        throwIfTransactionMarkedSuccessful();
        mTransactionStack.mMarkedSuccessful = true;
    }

    public boolean yieldTransaction(long l, boolean flag, CancellationSignal cancellationsignal) {
        boolean flag1 = false;
        if(!flag) goto _L2; else goto _L1
_L1:
        throwIfNoTransaction();
        throwIfTransactionMarkedSuccessful();
        throwIfNestedTransaction();
_L5:
        if(!$assertionsDisabled && mConnection == null)
            throw new AssertionError();
        if(!mTransactionStack.mChildFailed)
            flag1 = yieldTransactionUnchecked(l, cancellationsignal);
          goto _L3
_L2:
        if(mTransactionStack != null && !mTransactionStack.mMarkedSuccessful && mTransactionStack.mParent == null) goto _L5; else goto _L4
_L4:
        return flag1;
_L3:
        if(true) goto _L4; else goto _L6
_L6:
    }

    static final boolean $assertionsDisabled = false;
    public static final int TRANSACTION_MODE_DEFERRED = 0;
    public static final int TRANSACTION_MODE_EXCLUSIVE = 2;
    public static final int TRANSACTION_MODE_IMMEDIATE = 1;
    private SQLiteConnection mConnection;
    private int mConnectionFlags;
    private final SQLiteConnectionPool mConnectionPool;
    private int mConnectionUseCount;
    private Transaction mTransactionPool;
    private Transaction mTransactionStack;

    static  {
        boolean flag;
        if(!android/database/sqlite/SQLiteSession.desiredAssertionStatus())
            flag = true;
        else
            flag = false;
        $assertionsDisabled = flag;
    }
}
