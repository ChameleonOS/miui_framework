// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database.sqlite;

import android.database.CursorWindow;
import android.database.DatabaseUtils;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.*;
import dalvik.system.BlockGuard;
import dalvik.system.CloseGuard;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package android.database.sqlite:
//            SQLiteDatabaseConfiguration, SQLiteBindOrColumnIndexOutOfRangeException, SQLiteException, SQLiteDebug, 
//            SQLiteGlobal, SQLiteDatabaseLockedException, SQLiteConnectionPool, SQLiteStatementInfo, 
//            SQLiteCustomFunction

public final class SQLiteConnection
    implements android.os.CancellationSignal.OnCancelListener {
    private static final class Operation {

        private String getFormattedStartTime() {
            return sDateFormat.format(new Date(mStartTime));
        }

        private String getStatus() {
            String s;
            if(!mFinished)
                s = "running";
            else
            if(mException != null)
                s = "failed";
            else
                s = "succeeded";
            return s;
        }

        public void describe(StringBuilder stringbuilder) {
            stringbuilder.append(mKind);
            if(mFinished)
                stringbuilder.append(" took ").append(mEndTime - mStartTime).append("ms");
            else
                stringbuilder.append(" started ").append(System.currentTimeMillis() - mStartTime).append("ms ago");
            stringbuilder.append(" - ").append(getStatus());
            if(mSql != null)
                stringbuilder.append(", sql=\"").append(SQLiteConnection.trimSqlForDisplay(mSql)).append("\"");
            if(mBindArgs != null && mBindArgs.size() != 0) {
                stringbuilder.append(", bindArgs=[");
                int i = mBindArgs.size();
                int j = 0;
                while(j < i)  {
                    Object obj = mBindArgs.get(j);
                    if(j != 0)
                        stringbuilder.append(", ");
                    if(obj == null)
                        stringbuilder.append("null");
                    else
                    if(obj instanceof byte[])
                        stringbuilder.append("<byte[]>");
                    else
                    if(obj instanceof String)
                        stringbuilder.append("\"").append((String)obj).append("\"");
                    else
                        stringbuilder.append(obj);
                    j++;
                }
                stringbuilder.append("]");
            }
            if(mException != null)
                stringbuilder.append(", exception=\"").append(mException.getMessage()).append("\"");
        }

        private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        public ArrayList mBindArgs;
        public int mCookie;
        public long mEndTime;
        public Exception mException;
        public boolean mFinished;
        public String mKind;
        public String mSql;
        public long mStartTime;



        private Operation() {
        }

    }

    private static final class OperationLog {

        private boolean endOperationDeferLogLocked(int i) {
            boolean flag = true;
            Operation operation = getOperationLocked(i);
            if(operation != null) {
                operation.mEndTime = System.currentTimeMillis();
                operation.mFinished = flag;
                if(!SQLiteDebug.DEBUG_LOG_SLOW_QUERIES || !SQLiteDebug.shouldLogSlowQuery(operation.mEndTime - operation.mStartTime))
                    flag = false;
            } else {
                flag = false;
            }
            return flag;
        }

        private Operation getOperationLocked(int i) {
            int j = i & 0xff;
            Operation operation = mOperations[j];
            if(operation.mCookie != i)
                operation = null;
            return operation;
        }

        private void logOperationLocked(int i, String s) {
            Operation operation = getOperationLocked(i);
            StringBuilder stringbuilder = new StringBuilder();
            operation.describe(stringbuilder);
            if(s != null)
                stringbuilder.append(", ").append(s);
            Log.d("SQLiteConnection", stringbuilder.toString());
        }

        private int newOperationCookieLocked(int i) {
            int j = mGeneration;
            mGeneration = j + 1;
            return i | j << 8;
        }

        public int beginOperation(String s, String s1, Object aobj[]) {
            Operation aoperation[] = mOperations;
            aoperation;
            JVM INSTR monitorenter ;
            int i;
            Operation operation;
            int k;
            Object obj;
            i = (1 + mIndex) % 20;
            operation = mOperations[i];
            if(operation == null) {
                operation = new Operation();
                mOperations[i] = operation;
            } else {
                operation.mFinished = false;
                operation.mException = null;
                if(operation.mBindArgs != null)
                    operation.mBindArgs.clear();
            }
            operation.mStartTime = System.currentTimeMillis();
            operation.mKind = s;
            operation.mSql = s1;
            if(aobj == null) goto _L2; else goto _L1
_L1:
            if(operation.mBindArgs != null) goto _L4; else goto _L3
_L3:
            operation.mBindArgs = new ArrayList();
              goto _L5
_L11:
            if(k >= aobj.length) goto _L2; else goto _L6
_L6:
            obj = aobj[k];
            if(obj == null || !(obj instanceof byte[])) goto _L8; else goto _L7
_L7:
            operation.mBindArgs.add(SQLiteConnection.EMPTY_BYTE_ARRAY);
              goto _L9
            Exception exception;
            exception;
            throw exception;
_L4:
            operation.mBindArgs.clear();
              goto _L5
_L8:
            operation.mBindArgs.add(obj);
              goto _L9
_L2:
            int j;
            operation.mCookie = newOperationCookieLocked(i);
            mIndex = i;
            j = operation.mCookie;
            aoperation;
            JVM INSTR monitorexit ;
            return j;
_L5:
            k = 0;
            continue; /* Loop/switch isn't completed */
_L9:
            k++;
            if(true) goto _L11; else goto _L10
_L10:
        }

        public String describeCurrentOperation() {
            Operation aoperation[] = mOperations;
            aoperation;
            JVM INSTR monitorenter ;
            Operation operation = mOperations[mIndex];
            String s;
            if(operation != null && !operation.mFinished) {
                StringBuilder stringbuilder = new StringBuilder();
                operation.describe(stringbuilder);
                s = stringbuilder.toString();
            } else {
                s = null;
            }
            return s;
        }

        public void dump(Printer printer) {
            Operation aoperation[] = mOperations;
            aoperation;
            JVM INSTR monitorenter ;
            printer.println("  Most recently executed operations:");
            int i = mIndex;
            Operation operation = mOperations[i];
            if(operation != null) {
                int j = 0;
                do {
                    StringBuilder stringbuilder = new StringBuilder();
                    stringbuilder.append("    ").append(j).append(": [");
                    stringbuilder.append(operation.getFormattedStartTime());
                    stringbuilder.append("] ");
                    operation.describe(stringbuilder);
                    printer.println(stringbuilder.toString());
                    if(i > 0)
                        i--;
                    else
                        i = 19;
                    j++;
                    operation = mOperations[i];
                } while(operation != null && j < 20);
            } else {
                printer.println("    <none>");
            }
            return;
        }

        public void endOperation(int i) {
            Operation aoperation[] = mOperations;
            aoperation;
            JVM INSTR monitorenter ;
            if(endOperationDeferLogLocked(i))
                logOperationLocked(i, null);
            return;
        }

        public boolean endOperationDeferLog(int i) {
            Operation aoperation[] = mOperations;
            aoperation;
            JVM INSTR monitorenter ;
            boolean flag = endOperationDeferLogLocked(i);
            return flag;
        }

        public void failOperation(int i, Exception exception) {
            Operation aoperation[] = mOperations;
            aoperation;
            JVM INSTR monitorenter ;
            Operation operation = getOperationLocked(i);
            if(operation != null)
                operation.mException = exception;
            return;
        }

        public void logOperation(int i, String s) {
            Operation aoperation[] = mOperations;
            aoperation;
            JVM INSTR monitorenter ;
            logOperationLocked(i, s);
            return;
        }

        private static final int COOKIE_GENERATION_SHIFT = 8;
        private static final int COOKIE_INDEX_MASK = 255;
        private static final int MAX_RECENT_OPERATIONS = 20;
        private int mGeneration;
        private int mIndex;
        private final Operation mOperations[];

        private OperationLog() {
            mOperations = new Operation[20];
        }

    }

    private final class PreparedStatementCache extends LruCache {

        public void dump(Printer printer) {
            printer.println("  Prepared statement cache:");
            Map map = snapshot();
            if(!map.isEmpty()) {
                int i = 0;
                for(Iterator iterator = map.entrySet().iterator(); iterator.hasNext();) {
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                    PreparedStatement preparedstatement = (PreparedStatement)entry.getValue();
                    if(preparedstatement.mInCache) {
                        String s = (String)entry.getKey();
                        printer.println((new StringBuilder()).append("    ").append(i).append(": statementPtr=0x").append(Integer.toHexString(preparedstatement.mStatementPtr)).append(", numParameters=").append(preparedstatement.mNumParameters).append(", type=").append(preparedstatement.mType).append(", readOnly=").append(preparedstatement.mReadOnly).append(", sql=\"").append(SQLiteConnection.trimSqlForDisplay(s)).append("\"").toString());
                    }
                    i++;
                }

            } else {
                printer.println("    <none>");
            }
        }

        protected volatile void entryRemoved(boolean flag, Object obj, Object obj1, Object obj2) {
            entryRemoved(flag, (String)obj, (PreparedStatement)obj1, (PreparedStatement)obj2);
        }

        protected void entryRemoved(boolean flag, String s, PreparedStatement preparedstatement, PreparedStatement preparedstatement1) {
            preparedstatement.mInCache = false;
            if(!preparedstatement.mInUse)
                finalizePreparedStatement(preparedstatement);
        }

        final SQLiteConnection this$0;

        public PreparedStatementCache(int i) {
            this$0 = SQLiteConnection.this;
            super(i);
        }
    }

    private static final class PreparedStatement {

        public boolean mInCache;
        public boolean mInUse;
        public int mNumParameters;
        public PreparedStatement mPoolNext;
        public boolean mReadOnly;
        public String mSql;
        public int mStatementPtr;
        public int mType;

        private PreparedStatement() {
        }

    }


    private SQLiteConnection(SQLiteConnectionPool sqliteconnectionpool, SQLiteDatabaseConfiguration sqlitedatabaseconfiguration, int i, boolean flag) {
        mPool = sqliteconnectionpool;
        mConfiguration = new SQLiteDatabaseConfiguration(sqlitedatabaseconfiguration);
        mConnectionId = i;
        mIsPrimaryConnection = flag;
        boolean flag1;
        if((1 & sqlitedatabaseconfiguration.openFlags) != 0)
            flag1 = true;
        else
            flag1 = false;
        mIsReadOnlyConnection = flag1;
        mPreparedStatementCache = new PreparedStatementCache(mConfiguration.maxSqlCacheSize);
        mCloseGuard.open("close");
    }

    private PreparedStatement acquirePreparedStatement(String s) {
        PreparedStatement preparedstatement;
        boolean flag;
        preparedstatement = (PreparedStatement)mPreparedStatementCache.get(s);
        flag = false;
        if(preparedstatement == null) goto _L2; else goto _L1
_L1:
        if(preparedstatement.mInUse) goto _L4; else goto _L3
_L3:
        PreparedStatement preparedstatement1 = preparedstatement;
_L6:
        return preparedstatement1;
_L4:
        flag = true;
_L2:
        int i = nativePrepareStatement(mConnectionPtr, s);
        try {
            int j = nativeGetParameterCount(mConnectionPtr, i);
            int k = DatabaseUtils.getSqlStatementType(s);
            preparedstatement = obtainPreparedStatement(s, i, j, k, nativeIsReadOnly(mConnectionPtr, i));
            if(!flag && isCacheable(k)) {
                mPreparedStatementCache.put(s, preparedstatement);
                preparedstatement.mInCache = true;
            }
        }
        catch(RuntimeException runtimeexception) {
            if(preparedstatement == null || !preparedstatement.mInCache)
                nativeFinalizeStatement(mConnectionPtr, i);
            throw runtimeexception;
        }
        preparedstatement.mInUse = true;
        preparedstatement1 = preparedstatement;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private void applyBlockGuardPolicy(PreparedStatement preparedstatement) {
        if(!mConfiguration.isInMemoryDb())
            if(preparedstatement.mReadOnly)
                BlockGuard.getThreadPolicy().onReadFromDisk();
            else
                BlockGuard.getThreadPolicy().onWriteToDisk();
    }

    private void attachCancellationSignal(CancellationSignal cancellationsignal) {
        if(cancellationsignal != null) {
            cancellationsignal.throwIfCanceled();
            mCancellationSignalAttachCount = 1 + mCancellationSignalAttachCount;
            if(mCancellationSignalAttachCount == 1) {
                nativeResetCancel(mConnectionPtr, true);
                cancellationsignal.setOnCancelListener(this);
            }
        }
    }

    private void bindArguments(PreparedStatement preparedstatement, Object aobj[]) {
        int i;
        if(aobj != null)
            i = aobj.length;
        else
            i = 0;
        if(i != preparedstatement.mNumParameters)
            throw new SQLiteBindOrColumnIndexOutOfRangeException((new StringBuilder()).append("Expected ").append(preparedstatement.mNumParameters).append(" bind arguments but ").append(aobj.length).append(" were provided.").toString());
        if(i != 0) {
            int j = preparedstatement.mStatementPtr;
            int k = 0;
            while(k < i)  {
label0:
                {
                    {
                        Object obj = aobj[k];
                        switch(DatabaseUtils.getTypeOfObject(obj)) {
                        case 3: // '\003'
                        default:
                            if(obj instanceof Boolean) {
                                int l = mConnectionPtr;
                                int i1 = k + 1;
                                long l1;
                                if(((Boolean)obj).booleanValue())
                                    l1 = 1L;
                                else
                                    l1 = 0L;
                                nativeBindLong(l, j, i1, l1);
                            } else {
                                nativeBindString(mConnectionPtr, j, k + 1, obj.toString());
                            }
                            break;

                        case 0: // '\0'
                            break label0;

                        case 1: // '\001'
                            break MISSING_BLOCK_LABEL_199;

                        case 2: // '\002'
                            break MISSING_BLOCK_LABEL_223;

                        case 4: // '\004'
                            break MISSING_BLOCK_LABEL_247;
                        }
                    }
                    k++;
                }
            }
        }
        return;
        nativeBindNull(mConnectionPtr, j, k + 1);
        break MISSING_BLOCK_LABEL_177;
        nativeBindLong(mConnectionPtr, j, k + 1, ((Number)obj).longValue());
        break MISSING_BLOCK_LABEL_177;
        nativeBindDouble(mConnectionPtr, j, k + 1, ((Number)obj).doubleValue());
        break MISSING_BLOCK_LABEL_177;
        nativeBindBlob(mConnectionPtr, j, k + 1, (byte[])(byte[])obj);
        break MISSING_BLOCK_LABEL_177;
    }

    private static String canonicalizeSyncMode(String s) {
        if(!s.equals("0")) goto _L2; else goto _L1
_L1:
        s = "OFF";
_L4:
        return s;
_L2:
        if(s.equals("1"))
            s = "NORMAL";
        else
        if(s.equals("2"))
            s = "FULL";
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void detachCancellationSignal(CancellationSignal cancellationsignal) {
        if(cancellationsignal != null) {
            if(!$assertionsDisabled && mCancellationSignalAttachCount <= 0)
                throw new AssertionError();
            mCancellationSignalAttachCount = -1 + mCancellationSignalAttachCount;
            if(mCancellationSignalAttachCount == 0) {
                cancellationsignal.setOnCancelListener(null);
                nativeResetCancel(mConnectionPtr, false);
            }
        }
    }

    private void dispose(boolean flag) {
        int i;
        if(mCloseGuard != null) {
            if(flag)
                mCloseGuard.warnIfOpen();
            mCloseGuard.close();
        }
        if(mConnectionPtr == 0)
            break MISSING_BLOCK_LABEL_71;
        i = mRecentOperations.beginOperation("close", null, null);
        mPreparedStatementCache.evictAll();
        nativeClose(mConnectionPtr);
        mConnectionPtr = 0;
        mRecentOperations.endOperation(i);
        return;
        Exception exception;
        exception;
        mRecentOperations.endOperation(i);
        throw exception;
    }

    private void finalizePreparedStatement(PreparedStatement preparedstatement) {
        nativeFinalizeStatement(mConnectionPtr, preparedstatement.mStatementPtr);
        recyclePreparedStatement(preparedstatement);
    }

    private SQLiteDebug.DbStats getMainDbStatsUnsafe(int i, long l, long l1) {
        String s = mConfiguration.path;
        if(!mIsPrimaryConnection)
            s = (new StringBuilder()).append(s).append(" (").append(mConnectionId).append(")").toString();
        return new SQLiteDebug.DbStats(s, l, l1, i, mPreparedStatementCache.hitCount(), mPreparedStatementCache.missCount(), mPreparedStatementCache.size());
    }

    private static boolean isCacheable(int i) {
        boolean flag = true;
        if(i != 2 && i != flag)
            flag = false;
        return flag;
    }

    private static native void nativeBindBlob(int i, int j, int k, byte abyte0[]);

    private static native void nativeBindDouble(int i, int j, int k, double d);

    private static native void nativeBindLong(int i, int j, int k, long l);

    private static native void nativeBindNull(int i, int j, int k);

    private static native void nativeBindString(int i, int j, int k, String s);

    private static native void nativeCancel(int i);

    private static native void nativeClose(int i);

    private static native void nativeExecute(int i, int j);

    private static native int nativeExecuteForBlobFileDescriptor(int i, int j);

    private static native int nativeExecuteForChangedRowCount(int i, int j);

    private static native long nativeExecuteForCursorWindow(int i, int j, int k, int l, int i1, boolean flag);

    private static native long nativeExecuteForLastInsertedRowId(int i, int j);

    private static native long nativeExecuteForLong(int i, int j);

    private static native String nativeExecuteForString(int i, int j);

    private static native void nativeFinalizeStatement(int i, int j);

    private static native int nativeGetColumnCount(int i, int j);

    private static native String nativeGetColumnName(int i, int j, int k);

    private static native int nativeGetDbLookaside(int i);

    private static native int nativeGetParameterCount(int i, int j);

    private static native boolean nativeIsReadOnly(int i, int j);

    private static native int nativeOpen(String s, int i, String s1, boolean flag, boolean flag1);

    private static native int nativePrepareStatement(int i, String s);

    private static native void nativeRegisterCustomFunction(int i, SQLiteCustomFunction sqlitecustomfunction);

    private static native void nativeRegisterLocalizedCollators(int i, String s);

    private static native void nativeResetCancel(int i, boolean flag);

    private static native void nativeResetStatementAndClearBindings(int i, int j);

    private PreparedStatement obtainPreparedStatement(String s, int i, int j, int k, boolean flag) {
        PreparedStatement preparedstatement = mPreparedStatementPool;
        if(preparedstatement != null) {
            mPreparedStatementPool = preparedstatement.mPoolNext;
            preparedstatement.mPoolNext = null;
            preparedstatement.mInCache = false;
        } else {
            preparedstatement = new PreparedStatement();
        }
        preparedstatement.mSql = s;
        preparedstatement.mStatementPtr = i;
        preparedstatement.mNumParameters = j;
        preparedstatement.mType = k;
        preparedstatement.mReadOnly = flag;
        return preparedstatement;
    }

    static SQLiteConnection open(SQLiteConnectionPool sqliteconnectionpool, SQLiteDatabaseConfiguration sqlitedatabaseconfiguration, int i, boolean flag) {
        SQLiteConnection sqliteconnection = new SQLiteConnection(sqliteconnectionpool, sqlitedatabaseconfiguration, i, flag);
        try {
            sqliteconnection.open();
        }
        catch(SQLiteException sqliteexception) {
            sqliteconnection.dispose(false);
            throw sqliteexception;
        }
        return sqliteconnection;
    }

    private void open() {
        mConnectionPtr = nativeOpen(mConfiguration.path, mConfiguration.openFlags, mConfiguration.label, SQLiteDebug.DEBUG_SQL_STATEMENTS, SQLiteDebug.DEBUG_SQL_TIME);
        setPageSize();
        setForeignKeyModeFromConfiguration();
        setWalModeFromConfiguration();
        setJournalSizeLimit();
        setAutoCheckpointInterval();
        setLocaleFromConfiguration();
    }

    private void recyclePreparedStatement(PreparedStatement preparedstatement) {
        preparedstatement.mSql = null;
        preparedstatement.mPoolNext = mPreparedStatementPool;
        mPreparedStatementPool = preparedstatement;
    }

    private void releasePreparedStatement(PreparedStatement preparedstatement) {
        preparedstatement.mInUse = false;
        if(!preparedstatement.mInCache)
            break MISSING_BLOCK_LABEL_40;
        nativeResetStatementAndClearBindings(mConnectionPtr, preparedstatement.mStatementPtr);
_L1:
        return;
        SQLiteException sqliteexception;
        sqliteexception;
        mPreparedStatementCache.remove(preparedstatement.mSql);
          goto _L1
        finalizePreparedStatement(preparedstatement);
          goto _L1
    }

    private void setAutoCheckpointInterval() {
        if(!mConfiguration.isInMemoryDb() && !mIsReadOnlyConnection) {
            long l = SQLiteGlobal.getWALAutoCheckpoint();
            if(executeForLong("PRAGMA wal_autocheckpoint", null, null) != l)
                executeForLong((new StringBuilder()).append("PRAGMA wal_autocheckpoint=").append(l).toString(), null, null);
        }
    }

    private void setForeignKeyModeFromConfiguration() {
        if(!mIsReadOnlyConnection) {
            long l;
            if(mConfiguration.foreignKeyConstraintsEnabled)
                l = 1L;
            else
                l = 0L;
            if(executeForLong("PRAGMA foreign_keys", null, null) != l)
                execute((new StringBuilder()).append("PRAGMA foreign_keys=").append(l).toString(), null, null);
        }
    }

    private void setJournalMode(String s) {
        String s1 = executeForString("PRAGMA journal_mode", null, null);
        if(s1.equalsIgnoreCase(s)) goto _L2; else goto _L1
_L1:
        boolean flag = executeForString((new StringBuilder()).append("PRAGMA journal_mode=").append(s).toString(), null, null).equalsIgnoreCase(s);
        if(!flag) goto _L3; else goto _L2
_L2:
        return;
        SQLiteDatabaseLockedException sqlitedatabaselockedexception;
        sqlitedatabaselockedexception;
_L3:
        Log.w("SQLiteConnection", (new StringBuilder()).append("Could not change the database journal mode of '").append(mConfiguration.label).append("' from '").append(s1).append("' to '").append(s).append("' because the database is locked.  This usually means that ").append("there are other open connections to the database which prevents ").append("the database from enabling or disabling write-ahead logging mode.  ").append("Proceeding without changing the journal mode.").toString());
        if(true) goto _L2; else goto _L4
_L4:
    }

    private void setJournalSizeLimit() {
        if(!mConfiguration.isInMemoryDb() && !mIsReadOnlyConnection) {
            long l = SQLiteGlobal.getJournalSizeLimit();
            if(executeForLong("PRAGMA journal_size_limit", null, null) != l)
                executeForLong((new StringBuilder()).append("PRAGMA journal_size_limit=").append(l).toString(), null, null);
        }
    }

    private void setLocaleFromConfiguration() {
        if((0x10 & mConfiguration.openFlags) == 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s;
        s = mConfiguration.locale.toString();
        nativeRegisterLocalizedCollators(mConnectionPtr, s);
        if(mIsReadOnlyConnection) goto _L1; else goto _L3
_L3:
        String s1;
        execute("CREATE TABLE IF NOT EXISTS android_metadata (locale TEXT)", null, null);
        s1 = executeForString("SELECT locale FROM android_metadata UNION SELECT NULL ORDER BY locale DESC LIMIT 1", null, null);
        if(s1 != null && s1.equals(s)) goto _L1; else goto _L4
_L4:
        execute("BEGIN", null, null);
        execute("DELETE FROM android_metadata", null, null);
        Object aobj[] = new Object[1];
        aobj[0] = s;
        execute("INSERT INTO android_metadata (locale) VALUES(?)", aobj, null);
        execute("REINDEX LOCALIZED", null, null);
        if(false) goto _L6; else goto _L5
_L5:
        String s3 = "COMMIT";
_L7:
        execute(s3, null, null);
          goto _L1
        RuntimeException runtimeexception;
        runtimeexception;
        throw new SQLiteException((new StringBuilder()).append("Failed to change locale for db '").append(mConfiguration.label).append("' to '").append(s).append("'.").toString(), runtimeexception);
        Exception exception;
        exception;
        if(true)
            break MISSING_BLOCK_LABEL_221;
        String s2 = "COMMIT";
_L8:
        execute(s2, null, null);
        throw exception;
_L6:
        s3 = "ROLLBACK";
          goto _L7
        s2 = "ROLLBACK";
          goto _L8
    }

    private void setPageSize() {
        if(!mConfiguration.isInMemoryDb() && !mIsReadOnlyConnection) {
            long l = SQLiteGlobal.getDefaultPageSize();
            if(executeForLong("PRAGMA page_size", null, null) != l)
                execute((new StringBuilder()).append("PRAGMA page_size=").append(l).toString(), null, null);
        }
    }

    private void setSyncMode(String s) {
        if(!canonicalizeSyncMode(executeForString("PRAGMA synchronous", null, null)).equalsIgnoreCase(canonicalizeSyncMode(s)))
            execute((new StringBuilder()).append("PRAGMA synchronous=").append(s).toString(), null, null);
    }

    private void setWalModeFromConfiguration() {
        if(!mConfiguration.isInMemoryDb() && !mIsReadOnlyConnection)
            if((0x20000000 & mConfiguration.openFlags) != 0) {
                setJournalMode("WAL");
                setSyncMode(SQLiteGlobal.getWALSyncMode());
            } else {
                setJournalMode(SQLiteGlobal.getDefaultJournalMode());
                setSyncMode(SQLiteGlobal.getDefaultSyncMode());
            }
    }

    private void throwIfStatementForbidden(PreparedStatement preparedstatement) {
        if(mOnlyAllowReadOnlyOperations && !preparedstatement.mReadOnly)
            throw new SQLiteException("Cannot execute this statement because it might modify the database but the connection is read-only.");
        else
            return;
    }

    private static String trimSqlForDisplay(String s) {
        return TRIM_SQL_PATTERN.matcher(s).replaceAll(" ");
    }

    void close() {
        dispose(false);
    }

    void collectDbStats(ArrayList arraylist) {
        int i;
        long l;
        long l1;
        i = nativeGetDbLookaside(mConnectionPtr);
        l = 0L;
        l1 = 0L;
        long l5;
        l = executeForLong("PRAGMA page_count;", null, null);
        l5 = executeForLong("PRAGMA page_size;", null, null);
        l1 = l5;
_L6:
        CursorWindow cursorwindow;
        arraylist.add(getMainDbStatsUnsafe(i, l, l1));
        cursorwindow = new CursorWindow("collectDbStats");
        int j;
        executeForCursorWindow("PRAGMA database_list;", null, cursorwindow, 0, 0, false, null);
        j = 1;
_L3:
        int k = cursorwindow.getNumRows();
        if(j >= k) goto _L2; else goto _L1
_L1:
        String s;
        String s1;
        s = cursorwindow.getString(j, 1);
        s1 = cursorwindow.getString(j, 2);
        long l2;
        long l3;
        l2 = 0L;
        l3 = 0L;
        long l4;
        l2 = executeForLong((new StringBuilder()).append("PRAGMA ").append(s).append(".page_count;").toString(), null, null);
        l4 = executeForLong((new StringBuilder()).append("PRAGMA ").append(s).append(".page_size;").toString(), null, null);
        l3 = l4;
_L4:
        String s2 = (new StringBuilder()).append("  (attached) ").append(s).toString();
        if(!s1.isEmpty())
            s2 = (new StringBuilder()).append(s2).append(": ").append(s1).toString();
        arraylist.add(new SQLiteDebug.DbStats(s2, l2, l3, 0, 0, 0, 0));
        j++;
          goto _L3
        Exception exception;
        exception;
        cursorwindow.close();
        throw exception;
        SQLiteException sqliteexception1;
        sqliteexception1;
_L2:
        cursorwindow.close();
        return;
        SQLiteException sqliteexception2;
        sqliteexception2;
          goto _L4
        SQLiteException sqliteexception;
        sqliteexception;
        if(true) goto _L6; else goto _L5
_L5:
    }

    void collectDbStatsUnsafe(ArrayList arraylist) {
        arraylist.add(getMainDbStatsUnsafe(0, 0L, 0L));
    }

    String describeCurrentOperationUnsafe() {
        return mRecentOperations.describeCurrentOperation();
    }

    public void dump(Printer printer, boolean flag) {
        dumpUnsafe(printer, flag);
    }

    void dumpUnsafe(Printer printer, boolean flag) {
        printer.println((new StringBuilder()).append("Connection #").append(mConnectionId).append(":").toString());
        if(flag)
            printer.println((new StringBuilder()).append("  connectionPtr: 0x").append(Integer.toHexString(mConnectionPtr)).toString());
        printer.println((new StringBuilder()).append("  isPrimaryConnection: ").append(mIsPrimaryConnection).toString());
        printer.println((new StringBuilder()).append("  onlyAllowReadOnlyOperations: ").append(mOnlyAllowReadOnlyOperations).toString());
        mRecentOperations.dump(printer);
        if(flag)
            mPreparedStatementCache.dump(printer);
    }

    public void execute(String s, Object aobj[], CancellationSignal cancellationsignal) {
        int i;
        if(s == null)
            throw new IllegalArgumentException("sql must not be null.");
        i = mRecentOperations.beginOperation("execute", s, aobj);
        PreparedStatement preparedstatement = acquirePreparedStatement(s);
        throwIfStatementForbidden(preparedstatement);
        bindArguments(preparedstatement, aobj);
        applyBlockGuardPolicy(preparedstatement);
        attachCancellationSignal(cancellationsignal);
        nativeExecute(mConnectionPtr, preparedstatement.mStatementPtr);
        detachCancellationSignal(cancellationsignal);
        releasePreparedStatement(preparedstatement);
        mRecentOperations.endOperation(i);
        return;
        Exception exception2;
        exception2;
        detachCancellationSignal(cancellationsignal);
        throw exception2;
        Exception exception1;
        exception1;
        releasePreparedStatement(preparedstatement);
        throw exception1;
        RuntimeException runtimeexception;
        runtimeexception;
        mRecentOperations.failOperation(i, runtimeexception);
        throw runtimeexception;
        Exception exception;
        exception;
        mRecentOperations.endOperation(i);
        throw exception;
    }

    public ParcelFileDescriptor executeForBlobFileDescriptor(String s, Object aobj[], CancellationSignal cancellationsignal) {
        int i;
        if(s == null)
            throw new IllegalArgumentException("sql must not be null.");
        i = mRecentOperations.beginOperation("executeForBlobFileDescriptor", s, aobj);
        PreparedStatement preparedstatement = acquirePreparedStatement(s);
        throwIfStatementForbidden(preparedstatement);
        bindArguments(preparedstatement, aobj);
        applyBlockGuardPolicy(preparedstatement);
        attachCancellationSignal(cancellationsignal);
        int j = nativeExecuteForBlobFileDescriptor(mConnectionPtr, preparedstatement.mStatementPtr);
        if(j < 0) goto _L2; else goto _L1
_L1:
        ParcelFileDescriptor parcelfiledescriptor1 = ParcelFileDescriptor.adoptFd(j);
        ParcelFileDescriptor parcelfiledescriptor = parcelfiledescriptor1;
_L4:
        detachCancellationSignal(cancellationsignal);
        releasePreparedStatement(preparedstatement);
        mRecentOperations.endOperation(i);
        return parcelfiledescriptor;
_L2:
        parcelfiledescriptor = null;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception2;
        exception2;
        detachCancellationSignal(cancellationsignal);
        throw exception2;
        Exception exception1;
        exception1;
        releasePreparedStatement(preparedstatement);
        throw exception1;
        RuntimeException runtimeexception;
        runtimeexception;
        mRecentOperations.failOperation(i, runtimeexception);
        throw runtimeexception;
        Exception exception;
        exception;
        mRecentOperations.endOperation(i);
        throw exception;
    }

    public int executeForChangedRowCount(String s, Object aobj[], CancellationSignal cancellationsignal) {
        int i;
        int j;
        if(s == null)
            throw new IllegalArgumentException("sql must not be null.");
        i = 0;
        j = mRecentOperations.beginOperation("executeForChangedRowCount", s, aobj);
        PreparedStatement preparedstatement = acquirePreparedStatement(s);
        throwIfStatementForbidden(preparedstatement);
        bindArguments(preparedstatement, aobj);
        applyBlockGuardPolicy(preparedstatement);
        attachCancellationSignal(cancellationsignal);
        int k = nativeExecuteForChangedRowCount(mConnectionPtr, preparedstatement.mStatementPtr);
        i = k;
        detachCancellationSignal(cancellationsignal);
        releasePreparedStatement(preparedstatement);
        if(mRecentOperations.endOperationDeferLog(j))
            mRecentOperations.logOperation(j, (new StringBuilder()).append("changedRows=").append(i).toString());
        return i;
        Exception exception2;
        exception2;
        detachCancellationSignal(cancellationsignal);
        throw exception2;
        Exception exception1;
        exception1;
        releasePreparedStatement(preparedstatement);
        throw exception1;
        RuntimeException runtimeexception;
        runtimeexception;
        mRecentOperations.failOperation(j, runtimeexception);
        throw runtimeexception;
        Exception exception;
        exception;
        if(mRecentOperations.endOperationDeferLog(j))
            mRecentOperations.logOperation(j, (new StringBuilder()).append("changedRows=").append(i).toString());
        throw exception;
    }

    public int executeForCursorWindow(String s, Object aobj[], CursorWindow cursorwindow, int i, int j, boolean flag, CancellationSignal cancellationsignal) {
        int k;
        int l;
        int i1;
        if(s == null)
            throw new IllegalArgumentException("sql must not be null.");
        if(cursorwindow == null)
            throw new IllegalArgumentException("window must not be null.");
        cursorwindow.acquireReference();
        k = -1;
        l = -1;
        i1 = -1;
        int j1 = mRecentOperations.beginOperation("executeForCursorWindow", s, aobj);
        PreparedStatement preparedstatement = acquirePreparedStatement(s);
        throwIfStatementForbidden(preparedstatement);
        bindArguments(preparedstatement, aobj);
        applyBlockGuardPolicy(preparedstatement);
        attachCancellationSignal(cancellationsignal);
        long l1 = nativeExecuteForCursorWindow(mConnectionPtr, preparedstatement.mStatementPtr, cursorwindow.mWindowPtr, i, j, flag);
        k = (int)(l1 >> 32);
        l = (int)l1;
        i1 = cursorwindow.getNumRows();
        cursorwindow.setStartPosition(k);
        detachCancellationSignal(cancellationsignal);
        releasePreparedStatement(preparedstatement);
        if(mRecentOperations.endOperationDeferLog(j1))
            mRecentOperations.logOperation(j1, (new StringBuilder()).append("window='").append(cursorwindow).append("', startPos=").append(i).append(", actualPos=").append(k).append(", filledRows=").append(i1).append(", countedRows=").append(l).toString());
        cursorwindow.releaseReference();
        return l;
        Exception exception3;
        exception3;
        detachCancellationSignal(cancellationsignal);
        throw exception3;
        Exception exception2;
        exception2;
        releasePreparedStatement(preparedstatement);
        throw exception2;
        RuntimeException runtimeexception;
        runtimeexception;
        mRecentOperations.failOperation(j1, runtimeexception);
        throw runtimeexception;
        Exception exception1;
        exception1;
        if(mRecentOperations.endOperationDeferLog(j1))
            mRecentOperations.logOperation(j1, (new StringBuilder()).append("window='").append(cursorwindow).append("', startPos=").append(i).append(", actualPos=").append(k).append(", filledRows=").append(i1).append(", countedRows=").append(l).toString());
        throw exception1;
        Exception exception;
        exception;
        cursorwindow.releaseReference();
        throw exception;
    }

    public long executeForLastInsertedRowId(String s, Object aobj[], CancellationSignal cancellationsignal) {
        int i;
        if(s == null)
            throw new IllegalArgumentException("sql must not be null.");
        i = mRecentOperations.beginOperation("executeForLastInsertedRowId", s, aobj);
        PreparedStatement preparedstatement = acquirePreparedStatement(s);
        throwIfStatementForbidden(preparedstatement);
        bindArguments(preparedstatement, aobj);
        applyBlockGuardPolicy(preparedstatement);
        attachCancellationSignal(cancellationsignal);
        long l = nativeExecuteForLastInsertedRowId(mConnectionPtr, preparedstatement.mStatementPtr);
        detachCancellationSignal(cancellationsignal);
        releasePreparedStatement(preparedstatement);
        mRecentOperations.endOperation(i);
        return l;
        Exception exception2;
        exception2;
        detachCancellationSignal(cancellationsignal);
        throw exception2;
        Exception exception1;
        exception1;
        releasePreparedStatement(preparedstatement);
        throw exception1;
        RuntimeException runtimeexception;
        runtimeexception;
        mRecentOperations.failOperation(i, runtimeexception);
        throw runtimeexception;
        Exception exception;
        exception;
        mRecentOperations.endOperation(i);
        throw exception;
    }

    public long executeForLong(String s, Object aobj[], CancellationSignal cancellationsignal) {
        int i;
        if(s == null)
            throw new IllegalArgumentException("sql must not be null.");
        i = mRecentOperations.beginOperation("executeForLong", s, aobj);
        PreparedStatement preparedstatement = acquirePreparedStatement(s);
        throwIfStatementForbidden(preparedstatement);
        bindArguments(preparedstatement, aobj);
        applyBlockGuardPolicy(preparedstatement);
        attachCancellationSignal(cancellationsignal);
        long l = nativeExecuteForLong(mConnectionPtr, preparedstatement.mStatementPtr);
        detachCancellationSignal(cancellationsignal);
        releasePreparedStatement(preparedstatement);
        mRecentOperations.endOperation(i);
        return l;
        Exception exception2;
        exception2;
        detachCancellationSignal(cancellationsignal);
        throw exception2;
        Exception exception1;
        exception1;
        releasePreparedStatement(preparedstatement);
        throw exception1;
        RuntimeException runtimeexception;
        runtimeexception;
        mRecentOperations.failOperation(i, runtimeexception);
        throw runtimeexception;
        Exception exception;
        exception;
        mRecentOperations.endOperation(i);
        throw exception;
    }

    public String executeForString(String s, Object aobj[], CancellationSignal cancellationsignal) {
        int i;
        if(s == null)
            throw new IllegalArgumentException("sql must not be null.");
        i = mRecentOperations.beginOperation("executeForString", s, aobj);
        PreparedStatement preparedstatement = acquirePreparedStatement(s);
        throwIfStatementForbidden(preparedstatement);
        bindArguments(preparedstatement, aobj);
        applyBlockGuardPolicy(preparedstatement);
        attachCancellationSignal(cancellationsignal);
        String s1 = nativeExecuteForString(mConnectionPtr, preparedstatement.mStatementPtr);
        detachCancellationSignal(cancellationsignal);
        releasePreparedStatement(preparedstatement);
        mRecentOperations.endOperation(i);
        return s1;
        Exception exception2;
        exception2;
        detachCancellationSignal(cancellationsignal);
        throw exception2;
        Exception exception1;
        exception1;
        releasePreparedStatement(preparedstatement);
        throw exception1;
        RuntimeException runtimeexception;
        runtimeexception;
        mRecentOperations.failOperation(i, runtimeexception);
        throw runtimeexception;
        Exception exception;
        exception;
        mRecentOperations.endOperation(i);
        throw exception;
    }

    protected void finalize() throws Throwable {
        if(mPool != null && mConnectionPtr != 0)
            mPool.onConnectionLeaked();
        dispose(true);
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public int getConnectionId() {
        return mConnectionId;
    }

    boolean isPreparedStatementInCache(String s) {
        boolean flag;
        if(mPreparedStatementCache.get(s) != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isPrimaryConnection() {
        return mIsPrimaryConnection;
    }

    public void onCancel() {
        nativeCancel(mConnectionPtr);
    }

    public void prepare(String s, SQLiteStatementInfo sqlitestatementinfo) {
        int i;
        if(s == null)
            throw new IllegalArgumentException("sql must not be null.");
        i = mRecentOperations.beginOperation("prepare", s, null);
        PreparedStatement preparedstatement = acquirePreparedStatement(s);
        if(sqlitestatementinfo == null) goto _L2; else goto _L1
_L1:
        int j;
        sqlitestatementinfo.numParameters = preparedstatement.mNumParameters;
        sqlitestatementinfo.readOnly = preparedstatement.mReadOnly;
        j = nativeGetColumnCount(mConnectionPtr, preparedstatement.mStatementPtr);
        if(j != 0) goto _L4; else goto _L3
_L3:
        sqlitestatementinfo.columnNames = EMPTY_STRING_ARRAY;
_L2:
        releasePreparedStatement(preparedstatement);
        mRecentOperations.endOperation(i);
        return;
_L4:
        int k;
        sqlitestatementinfo.columnNames = new String[j];
        k = 0;
_L6:
        if(k >= j)
            break; /* Loop/switch isn't completed */
        sqlitestatementinfo.columnNames[k] = nativeGetColumnName(mConnectionPtr, preparedstatement.mStatementPtr, k);
        k++;
        if(true) goto _L6; else goto _L5
_L5:
        if(true) goto _L2; else goto _L7
_L7:
        Exception exception1;
        exception1;
        releasePreparedStatement(preparedstatement);
        throw exception1;
        RuntimeException runtimeexception;
        runtimeexception;
        mRecentOperations.failOperation(i, runtimeexception);
        throw runtimeexception;
        Exception exception;
        exception;
        mRecentOperations.endOperation(i);
        throw exception;
    }

    void reconfigure(SQLiteDatabaseConfiguration sqlitedatabaseconfiguration) {
        mOnlyAllowReadOnlyOperations = false;
        int i = sqlitedatabaseconfiguration.customFunctions.size();
        for(int j = 0; j < i; j++) {
            SQLiteCustomFunction sqlitecustomfunction = (SQLiteCustomFunction)sqlitedatabaseconfiguration.customFunctions.get(j);
            if(!mConfiguration.customFunctions.contains(sqlitecustomfunction))
                nativeRegisterCustomFunction(mConnectionPtr, sqlitecustomfunction);
        }

        boolean flag;
        boolean flag1;
        boolean flag2;
        if(sqlitedatabaseconfiguration.foreignKeyConstraintsEnabled != mConfiguration.foreignKeyConstraintsEnabled)
            flag = true;
        else
            flag = false;
        if((0x20000000 & (sqlitedatabaseconfiguration.openFlags ^ mConfiguration.openFlags)) != 0)
            flag1 = true;
        else
            flag1 = false;
        if(!sqlitedatabaseconfiguration.locale.equals(mConfiguration.locale))
            flag2 = true;
        else
            flag2 = false;
        mConfiguration.updateParametersFrom(sqlitedatabaseconfiguration);
        mPreparedStatementCache.resize(sqlitedatabaseconfiguration.maxSqlCacheSize);
        if(flag)
            setForeignKeyModeFromConfiguration();
        if(flag1)
            setWalModeFromConfiguration();
        if(flag2)
            setLocaleFromConfiguration();
    }

    void setOnlyAllowReadOnlyOperations(boolean flag) {
        mOnlyAllowReadOnlyOperations = flag;
    }

    public String toString() {
        return (new StringBuilder()).append("SQLiteConnection: ").append(mConfiguration.path).append(" (").append(mConnectionId).append(")").toString();
    }

    static final boolean $assertionsDisabled = false;
    private static final boolean DEBUG = false;
    private static final byte EMPTY_BYTE_ARRAY[] = new byte[0];
    private static final String EMPTY_STRING_ARRAY[] = new String[0];
    private static final String TAG = "SQLiteConnection";
    private static final Pattern TRIM_SQL_PATTERN = Pattern.compile("[\\s]*\\n+[\\s]*");
    private int mCancellationSignalAttachCount;
    private final CloseGuard mCloseGuard = CloseGuard.get();
    private final SQLiteDatabaseConfiguration mConfiguration;
    private final int mConnectionId;
    private int mConnectionPtr;
    private final boolean mIsPrimaryConnection;
    private final boolean mIsReadOnlyConnection;
    private boolean mOnlyAllowReadOnlyOperations;
    private final SQLiteConnectionPool mPool;
    private final PreparedStatementCache mPreparedStatementCache;
    private PreparedStatement mPreparedStatementPool;
    private final OperationLog mRecentOperations = new OperationLog();

    static  {
        boolean flag;
        if(!android/database/sqlite/SQLiteConnection.desiredAssertionStatus())
            flag = true;
        else
            flag = false;
        $assertionsDisabled = flag;
    }



}
