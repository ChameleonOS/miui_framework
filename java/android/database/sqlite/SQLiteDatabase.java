// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database.sqlite;

import android.content.ContentValues;
import android.database.*;
import android.os.CancellationSignal;
import android.os.Looper;
import android.text.TextUtils;
import android.util.*;
import dalvik.system.CloseGuard;
import java.io.File;
import java.io.FileFilter;
import java.util.*;

// Referenced classes of package android.database.sqlite:
//            SQLiteClosable, SQLiteDatabaseConfiguration, SQLiteSession, SQLiteConnectionPool, 
//            SQLiteStatement, SQLiteDatabaseCorruptException, SQLiteException, SQLiteGlobal, 
//            SQLiteCustomFunction, SQLiteQueryBuilder, SQLiteDirectCursorDriver, SQLiteCursorDriver, 
//            SQLiteTransactionListener, SQLiteQuery

public final class SQLiteDatabase extends SQLiteClosable {
    public static interface CustomFunction {

        public abstract void callback(String as[]);
    }

    public static interface CursorFactory {

        public abstract Cursor newCursor(SQLiteDatabase sqlitedatabase, SQLiteCursorDriver sqlitecursordriver, String s, SQLiteQuery sqlitequery);
    }


    private SQLiteDatabase(String s, int i, CursorFactory cursorfactory, DatabaseErrorHandler databaseerrorhandler) {
        mCursorFactory = cursorfactory;
        if(databaseerrorhandler == null)
            databaseerrorhandler = new DefaultDatabaseErrorHandler();
        mErrorHandler = databaseerrorhandler;
        mConfigurationLocked = new SQLiteDatabaseConfiguration(s, i);
    }

    private void beginTransaction(SQLiteTransactionListener sqlitetransactionlistener, boolean flag) {
        acquireReference();
        SQLiteSession sqlitesession;
        byte byte0;
        sqlitesession = getThreadSession();
        if(!flag)
            break MISSING_BLOCK_LABEL_36;
        byte0 = 2;
_L1:
        sqlitesession.beginTransaction(byte0, sqlitetransactionlistener, getThreadDefaultConnectionFlags(false), null);
        releaseReference();
        return;
        byte0 = 1;
          goto _L1
        Exception exception;
        exception;
        releaseReference();
        throw exception;
    }

    private void collectDbStats(ArrayList arraylist) {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        if(mConnectionPoolLocked != null)
            mConnectionPoolLocked.collectDbStats(arraylist);
        return;
    }

    public static SQLiteDatabase create(CursorFactory cursorfactory) {
        return openDatabase(":memory:", cursorfactory, 0x10000000);
    }

    public static boolean deleteDatabase(File file) {
        if(file == null)
            throw new IllegalArgumentException("file must not be null");
        boolean flag = false | file.delete() | (new File((new StringBuilder()).append(file.getPath()).append("-journal").toString())).delete() | (new File((new StringBuilder()).append(file.getPath()).append("-shm").toString())).delete() | (new File((new StringBuilder()).append(file.getPath()).append("-wal").toString())).delete();
        File file1 = file.getParentFile();
        if(file1 != null) {
            File afile[] = file1.listFiles(new FileFilter() {

                public boolean accept(File file2) {
                    return file2.getName().startsWith(prefix);
                }

                final String val$prefix;

             {
                prefix = s;
                super();
            }
            });
            int i = afile.length;
            for(int j = 0; j < i; j++)
                flag |= afile[j].delete();

        }
        return flag;
    }

    private void dispose(boolean flag) {
        SQLiteConnectionPool sqliteconnectionpool;
        synchronized(mLock) {
            if(mCloseGuardLocked != null) {
                if(flag)
                    mCloseGuardLocked.warnIfOpen();
                mCloseGuardLocked.close();
            }
            sqliteconnectionpool = mConnectionPoolLocked;
            mConnectionPoolLocked = null;
        }
        if(!flag) {
            synchronized(sActiveDatabases) {
                sActiveDatabases.remove(this);
            }
            if(sqliteconnectionpool != null)
                sqliteconnectionpool.close();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        exception1;
        weakhashmap;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    private void dump(Printer printer, boolean flag) {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        if(mConnectionPoolLocked != null) {
            printer.println("");
            mConnectionPoolLocked.dump(printer, flag);
        }
        return;
    }

    static void dumpAll(Printer printer, boolean flag) {
        for(Iterator iterator = getActiveDatabases().iterator(); iterator.hasNext(); ((SQLiteDatabase)iterator.next()).dump(printer, flag));
    }

    private int executeSql(String s, Object aobj[]) throws SQLException {
        acquireReference();
        boolean flag;
        if(DatabaseUtils.getSqlStatementType(s) != 3)
            break MISSING_BLOCK_LABEL_51;
        flag = false;
        synchronized(mLock) {
            if(!mHasAttachedDbsLocked) {
                mHasAttachedDbsLocked = true;
                flag = true;
            }
        }
        if(!flag)
            break MISSING_BLOCK_LABEL_51;
        disableWriteAheadLogging();
        SQLiteStatement sqlitestatement = new SQLiteStatement(this, s, aobj);
        int i = sqlitestatement.executeUpdateDelete();
        sqlitestatement.close();
        releaseReference();
        return i;
        exception2;
        obj;
        JVM INSTR monitorexit ;
        throw exception2;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
        Exception exception1;
        exception1;
        sqlitestatement.close();
        throw exception1;
    }

    public static String findEditTable(String s) {
        if(TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        i = s.indexOf(' ');
        j = s.indexOf(',');
        if(i <= 0 || i >= j && j >= 0) goto _L4; else goto _L3
_L3:
        s = s.substring(0, i);
_L5:
        return s;
_L4:
        if(j > 0 && (j < i || i < 0))
            s = s.substring(0, j);
        if(true) goto _L5; else goto _L2
_L2:
        throw new IllegalStateException("Invalid tables");
    }

    private static ArrayList getActiveDatabases() {
        ArrayList arraylist = new ArrayList();
        WeakHashMap weakhashmap = sActiveDatabases;
        weakhashmap;
        JVM INSTR monitorenter ;
        arraylist.addAll(sActiveDatabases.keySet());
        return arraylist;
    }

    static ArrayList getDbStats() {
        ArrayList arraylist = new ArrayList();
        for(Iterator iterator = getActiveDatabases().iterator(); iterator.hasNext(); ((SQLiteDatabase)iterator.next()).collectDbStats(arraylist));
        return arraylist;
    }

    private static boolean isMainThread() {
        Looper looper = Looper.myLooper();
        boolean flag;
        if(looper != null && looper == Looper.getMainLooper())
            flag = true;
        else
            flag = false;
        return flag;
    }

    private boolean isReadOnlyLocked() {
        boolean flag = true;
        if((1 & mConfigurationLocked.openFlags) != flag)
            flag = false;
        return flag;
    }

    private void open() {
        openInner();
_L1:
        return;
        SQLiteDatabaseCorruptException sqlitedatabasecorruptexception;
        sqlitedatabasecorruptexception;
        try {
            onCorruption();
            openInner();
        }
        catch(SQLiteException sqliteexception) {
            Log.e("SQLiteDatabase", (new StringBuilder()).append("Failed to open database '").append(getLabel()).append("'.").toString(), sqliteexception);
            close();
            throw sqliteexception;
        }
          goto _L1
    }

    public static SQLiteDatabase openDatabase(String s, CursorFactory cursorfactory, int i) {
        return openDatabase(s, cursorfactory, i, null);
    }

    public static SQLiteDatabase openDatabase(String s, CursorFactory cursorfactory, int i, DatabaseErrorHandler databaseerrorhandler) {
        SQLiteDatabase sqlitedatabase = new SQLiteDatabase(s, i, cursorfactory, databaseerrorhandler);
        sqlitedatabase.open();
        return sqlitedatabase;
    }

    private void openInner() {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        if(!$assertionsDisabled && mConnectionPoolLocked != null)
            throw new AssertionError();
        break MISSING_BLOCK_LABEL_33;
        Exception exception;
        exception;
        throw exception;
        mConnectionPoolLocked = SQLiteConnectionPool.open(mConfigurationLocked);
        mCloseGuardLocked.open("close");
        obj;
        JVM INSTR monitorexit ;
        WeakHashMap weakhashmap = sActiveDatabases;
        weakhashmap;
        JVM INSTR monitorenter ;
        sActiveDatabases.put(this, null);
        return;
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, CursorFactory cursorfactory) {
        return openOrCreateDatabase(file.getPath(), cursorfactory);
    }

    public static SQLiteDatabase openOrCreateDatabase(String s, CursorFactory cursorfactory) {
        return openDatabase(s, cursorfactory, 0x10000000, null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String s, CursorFactory cursorfactory, DatabaseErrorHandler databaseerrorhandler) {
        return openDatabase(s, cursorfactory, 0x10000000, databaseerrorhandler);
    }

    public static int releaseMemory() {
        return SQLiteGlobal.releaseMemory();
    }

    private void throwIfNotOpenLocked() {
        if(mConnectionPoolLocked == null)
            throw new IllegalStateException((new StringBuilder()).append("The database '").append(mConfigurationLocked.label).append("' is not open.").toString());
        else
            return;
    }

    private boolean yieldIfContendedHelper(boolean flag, long l) {
        acquireReference();
        boolean flag1 = getThreadSession().yieldTransaction(l, flag, null);
        releaseReference();
        return flag1;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
    }

    public void addCustomFunction(String s, int i, CustomFunction customfunction) {
        SQLiteCustomFunction sqlitecustomfunction = new SQLiteCustomFunction(s, i, customfunction);
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        throwIfNotOpenLocked();
        mConfigurationLocked.customFunctions.add(sqlitecustomfunction);
        try {
            mConnectionPoolLocked.reconfigure(mConfigurationLocked);
        }
        catch(RuntimeException runtimeexception) {
            mConfigurationLocked.customFunctions.remove(sqlitecustomfunction);
            throw runtimeexception;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void beginTransaction() {
        beginTransaction(null, true);
    }

    public void beginTransactionNonExclusive() {
        beginTransaction(null, false);
    }

    public void beginTransactionWithListener(SQLiteTransactionListener sqlitetransactionlistener) {
        beginTransaction(sqlitetransactionlistener, true);
    }

    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sqlitetransactionlistener) {
        beginTransaction(sqlitetransactionlistener, false);
    }

    public SQLiteStatement compileStatement(String s) throws SQLException {
        acquireReference();
        SQLiteStatement sqlitestatement = new SQLiteStatement(this, s, null);
        releaseReference();
        return sqlitestatement;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
    }

    SQLiteSession createSession() {
        SQLiteConnectionPool sqliteconnectionpool;
        synchronized(mLock) {
            throwIfNotOpenLocked();
            sqliteconnectionpool = mConnectionPoolLocked;
        }
        return new SQLiteSession(sqliteconnectionpool);
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int delete(String s, String s1, String as[]) {
        acquireReference();
        StringBuilder stringbuilder;
        String s2;
        stringbuilder = (new StringBuilder()).append("DELETE FROM ").append(s);
        if(TextUtils.isEmpty(s1))
            break MISSING_BLOCK_LABEL_92;
        s2 = (new StringBuilder()).append(" WHERE ").append(s1).toString();
_L1:
        SQLiteStatement sqlitestatement = new SQLiteStatement(this, stringbuilder.append(s2).toString(), as);
        int i = sqlitestatement.executeUpdateDelete();
        sqlitestatement.close();
        releaseReference();
        return i;
        s2 = "";
          goto _L1
        Exception exception1;
        exception1;
        sqlitestatement.close();
        throw exception1;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
    }

    public void disableWriteAheadLogging() {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        throwIfNotOpenLocked();
        if((0x20000000 & mConfigurationLocked.openFlags) == 0)
            break MISSING_BLOCK_LABEL_91;
        SQLiteDatabaseConfiguration sqlitedatabaseconfiguration = mConfigurationLocked;
        sqlitedatabaseconfiguration.openFlags = 0xdfffffff & sqlitedatabaseconfiguration.openFlags;
        mConnectionPoolLocked.reconfigure(mConfigurationLocked);
        obj;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_91;
        Exception exception;
        exception;
        throw exception;
        RuntimeException runtimeexception;
        runtimeexception;
        SQLiteDatabaseConfiguration sqlitedatabaseconfiguration1 = mConfigurationLocked;
        sqlitedatabaseconfiguration1.openFlags = 0x20000000 | sqlitedatabaseconfiguration1.openFlags;
        throw runtimeexception;
    }

    public boolean enableWriteAheadLogging() {
        boolean flag = true;
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        throwIfNotOpenLocked();
        if((0x20000000 & mConfigurationLocked.openFlags) != 0)
            break MISSING_BLOCK_LABEL_197;
        if(isReadOnlyLocked()) {
            flag = false;
            break MISSING_BLOCK_LABEL_197;
        }
        if(mConfigurationLocked.isInMemoryDb()) {
            Log.i("SQLiteDatabase", "can't enable WAL for memory databases.");
            flag = false;
            break MISSING_BLOCK_LABEL_197;
        }
        if(mHasAttachedDbsLocked) {
            if(Log.isLoggable("SQLiteDatabase", 3))
                Log.d("SQLiteDatabase", (new StringBuilder()).append("this database: ").append(mConfigurationLocked.label).append(" has attached databases. can't  enable WAL.").toString());
            flag = false;
            break MISSING_BLOCK_LABEL_197;
        }
        SQLiteDatabaseConfiguration sqlitedatabaseconfiguration = mConfigurationLocked;
        sqlitedatabaseconfiguration.openFlags = 0x20000000 | sqlitedatabaseconfiguration.openFlags;
        mConnectionPoolLocked.reconfigure(mConfigurationLocked);
        obj;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_197;
        Exception exception;
        exception;
        throw exception;
        RuntimeException runtimeexception;
        runtimeexception;
        SQLiteDatabaseConfiguration sqlitedatabaseconfiguration1 = mConfigurationLocked;
        sqlitedatabaseconfiguration1.openFlags = 0xdfffffff & sqlitedatabaseconfiguration1.openFlags;
        throw runtimeexception;
        return flag;
    }

    public void endTransaction() {
        acquireReference();
        getThreadSession().endTransaction(null);
        releaseReference();
        return;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
    }

    public void execSQL(String s) throws SQLException {
        executeSql(s, null);
    }

    public void execSQL(String s, Object aobj[]) throws SQLException {
        if(aobj == null) {
            throw new IllegalArgumentException("Empty bindArgs");
        } else {
            executeSql(s, aobj);
            return;
        }
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

    public List getAttachedDbs() {
        ArrayList arraylist = new ArrayList();
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        if(mConnectionPoolLocked == null) {
            arraylist = null;
            break MISSING_BLOCK_LABEL_170;
        }
        if(!mHasAttachedDbsLocked) {
            arraylist.add(new Pair("main", mConfigurationLocked.path));
            break MISSING_BLOCK_LABEL_170;
        }
        break MISSING_BLOCK_LABEL_68;
        Exception exception;
        exception;
        throw exception;
        acquireReference();
        obj;
        JVM INSTR monitorexit ;
        Cursor cursor = null;
        for(cursor = rawQuery("pragma database_list;", null); cursor.moveToNext(); arraylist.add(new Pair(cursor.getString(1), cursor.getString(2))));
        break MISSING_BLOCK_LABEL_154;
        Exception exception1;
        exception1;
        if(cursor == null)
            break MISSING_BLOCK_LABEL_142;
        cursor.close();
        throw exception1;
        Exception exception2;
        exception2;
        releaseReference();
        throw exception2;
        if(cursor == null)
            break MISSING_BLOCK_LABEL_166;
        cursor.close();
        releaseReference();
        return arraylist;
    }

    String getLabel() {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        String s = mConfigurationLocked.label;
        return s;
    }

    public long getMaximumSize() {
        return DatabaseUtils.longForQuery(this, "PRAGMA max_page_count;", null) * getPageSize();
    }

    public long getPageSize() {
        return DatabaseUtils.longForQuery(this, "PRAGMA page_size;", null);
    }

    public final String getPath() {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        String s = mConfigurationLocked.path;
        return s;
    }

    public Map getSyncedTables() {
        return new HashMap(0);
    }

    int getThreadDefaultConnectionFlags(boolean flag) {
        int i;
        if(flag)
            i = 1;
        else
            i = 2;
        if(isMainThread())
            i |= 4;
        return i;
    }

    SQLiteSession getThreadSession() {
        return (SQLiteSession)mThreadSession.get();
    }

    public int getVersion() {
        return Long.valueOf(DatabaseUtils.longForQuery(this, "PRAGMA user_version;", null)).intValue();
    }

    public boolean inTransaction() {
        acquireReference();
        boolean flag = getThreadSession().hasTransaction();
        releaseReference();
        return flag;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
    }

    public long insert(String s, String s1, ContentValues contentvalues) {
        long l1 = insertWithOnConflict(s, s1, contentvalues, 0);
        long l = l1;
_L2:
        return l;
        SQLException sqlexception;
        sqlexception;
        Log.e("SQLiteDatabase", (new StringBuilder()).append("Error inserting ").append(contentvalues).toString(), sqlexception);
        l = -1L;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public long insertOrThrow(String s, String s1, ContentValues contentvalues) throws SQLException {
        return insertWithOnConflict(s, s1, contentvalues, 0);
    }

    public long insertWithOnConflict(String s, String s1, ContentValues contentvalues, int i) {
        acquireReference();
        StringBuilder stringbuilder;
        Object aobj[];
        stringbuilder = new StringBuilder();
        stringbuilder.append("INSERT");
        stringbuilder.append(CONFLICT_VALUES[i]);
        stringbuilder.append(" INTO ");
        stringbuilder.append(s);
        stringbuilder.append('(');
        aobj = null;
        if(contentvalues == null || contentvalues.size() <= 0) goto _L2; else goto _L1
_L1:
        int j = contentvalues.size();
_L11:
        if(j <= 0) goto _L4; else goto _L3
_L3:
        Iterator iterator;
        int k;
        aobj = new Object[j];
        iterator = contentvalues.keySet().iterator();
        k = 0;
_L9:
        if(!iterator.hasNext()) goto _L6; else goto _L5
_L5:
        String s3 = (String)iterator.next();
        if(k <= 0) goto _L8; else goto _L7
_L7:
        String s4 = ",";
_L12:
        stringbuilder.append(s4);
        stringbuilder.append(s3);
        int j1 = k + 1;
        aobj[k] = contentvalues.get(s3);
        k = j1;
          goto _L9
_L6:
        int i1;
        stringbuilder.append(')');
        stringbuilder.append(" VALUES (");
        i1 = 0;
          goto _L10
_L15:
        String s2;
        stringbuilder.append(s2);
        i1++;
          goto _L10
_L4:
        stringbuilder.append((new StringBuilder()).append(s1).append(") VALUES (NULL").toString());
_L14:
        SQLiteStatement sqlitestatement;
        stringbuilder.append(')');
        sqlitestatement = new SQLiteStatement(this, stringbuilder.toString(), aobj);
        long l = sqlitestatement.executeInsert();
        sqlitestatement.close();
        releaseReference();
        return l;
        Exception exception1;
        exception1;
        sqlitestatement.close();
        throw exception1;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
_L2:
        j = 0;
          goto _L11
_L8:
        s4 = "";
          goto _L12
_L10:
        if(i1 >= j) goto _L14; else goto _L13
_L13:
        if(i1 > 0)
            s2 = ",?";
        else
            s2 = "?";
          goto _L15
    }

    public boolean isDatabaseIntegrityOk() {
        Exception exception;
        int i;
        boolean flag;
        SQLiteStatement sqlitestatement;
        acquireReference();
        Object obj = null;
        Pair pair;
        Exception exception1;
        String s;
        try {
            obj = getAttachedDbs();
            if(obj == null)
                throw new IllegalStateException((new StringBuilder()).append("databaselist for: ").append(getPath()).append(" couldn't ").append("be retrieved. probably because the database is closed").toString());
            break MISSING_BLOCK_LABEL_293;
        }
        catch(SQLiteException sqliteexception) {
            obj;
        }
        finally { }
        obj = new ArrayList();
        ((List) (obj)).add(new Pair("main", getPath()));
        break MISSING_BLOCK_LABEL_293;
_L5:
        if(i >= ((List) (obj)).size()) goto _L2; else goto _L1
_L1:
        pair = (Pair)((List) (obj)).get(i);
        sqlitestatement = null;
        sqlitestatement = compileStatement((new StringBuilder()).append("PRAGMA ").append((String)pair.first).append(".integrity_check(1);").toString());
        s = sqlitestatement.simpleQueryForString();
        if(s.equalsIgnoreCase("ok")) goto _L4; else goto _L3
_L3:
        Log.e("SQLiteDatabase", (new StringBuilder()).append("PRAGMA integrity_check on ").append((String)pair.second).append(" returned: ").append(s).toString());
        flag = false;
        if(sqlitestatement == null)
            break MISSING_BLOCK_LABEL_234;
        sqlitestatement.close();
        releaseReference();
_L6:
        return flag;
        exception1;
        if(sqlitestatement == null)
            break MISSING_BLOCK_LABEL_253;
        sqlitestatement.close();
        throw exception1;
_L7:
        releaseReference();
        throw exception;
_L4:
        if(sqlitestatement == null)
            break MISSING_BLOCK_LABEL_273;
        sqlitestatement.close();
        i++;
          goto _L5
_L2:
        releaseReference();
        flag = true;
          goto _L6
        exception;
          goto _L7
        i = 0;
          goto _L5
    }

    public boolean isDbLockedByCurrentThread() {
        acquireReference();
        boolean flag = getThreadSession().hasConnection();
        releaseReference();
        return flag;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
    }

    public boolean isDbLockedByOtherThreads() {
        return false;
    }

    public boolean isInMemoryDatabase() {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        boolean flag = mConfigurationLocked.isInMemoryDb();
        return flag;
    }

    public boolean isOpen() {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        boolean flag;
        if(mConnectionPoolLocked != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isReadOnly() {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        boolean flag = isReadOnlyLocked();
        return flag;
    }

    public boolean isWriteAheadLoggingEnabled() {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        throwIfNotOpenLocked();
        boolean flag;
        if((0x20000000 & mConfigurationLocked.openFlags) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void markTableSyncable(String s, String s1) {
    }

    public void markTableSyncable(String s, String s1, String s2) {
    }

    public boolean needUpgrade(int i) {
        boolean flag;
        if(i > getVersion())
            flag = true;
        else
            flag = false;
        return flag;
    }

    protected void onAllReferencesReleased() {
        dispose(false);
    }

    void onCorruption() {
        EventLog.writeEvent(0x124fc, getLabel());
        mErrorHandler.onCorruption(this);
    }

    public Cursor query(String s, String as[], String s1, String as1[], String s2, String s3, String s4) {
        return query(false, s, as, s1, as1, s2, s3, s4, null);
    }

    public Cursor query(String s, String as[], String s1, String as1[], String s2, String s3, String s4, 
            String s5) {
        return query(false, s, as, s1, as1, s2, s3, s4, s5);
    }

    public Cursor query(boolean flag, String s, String as[], String s1, String as1[], String s2, String s3, 
            String s4, String s5) {
        return queryWithFactory(null, flag, s, as, s1, as1, s2, s3, s4, s5, null);
    }

    public Cursor query(boolean flag, String s, String as[], String s1, String as1[], String s2, String s3, 
            String s4, String s5, CancellationSignal cancellationsignal) {
        return queryWithFactory(null, flag, s, as, s1, as1, s2, s3, s4, s5, cancellationsignal);
    }

    public Cursor queryWithFactory(CursorFactory cursorfactory, boolean flag, String s, String as[], String s1, String as1[], String s2, 
            String s3, String s4, String s5) {
        return queryWithFactory(cursorfactory, flag, s, as, s1, as1, s2, s3, s4, s5, null);
    }

    public Cursor queryWithFactory(CursorFactory cursorfactory, boolean flag, String s, String as[], String s1, String as1[], String s2, 
            String s3, String s4, String s5, CancellationSignal cancellationsignal) {
        acquireReference();
        Cursor cursor = rawQueryWithFactory(cursorfactory, SQLiteQueryBuilder.buildQueryString(flag, s, as, s1, s2, s3, s4, s5), as1, findEditTable(s), cancellationsignal);
        releaseReference();
        return cursor;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
    }

    public Cursor rawQuery(String s, String as[]) {
        return rawQueryWithFactory(null, s, as, null, null);
    }

    public Cursor rawQuery(String s, String as[], CancellationSignal cancellationsignal) {
        return rawQueryWithFactory(null, s, as, null, cancellationsignal);
    }

    public Cursor rawQueryWithFactory(CursorFactory cursorfactory, String s, String as[], String s1) {
        return rawQueryWithFactory(cursorfactory, s, as, s1, null);
    }

    public Cursor rawQueryWithFactory(CursorFactory cursorfactory, String s, String as[], String s1, CancellationSignal cancellationsignal) {
        acquireReference();
        SQLiteDirectCursorDriver sqlitedirectcursordriver;
        sqlitedirectcursordriver = new SQLiteDirectCursorDriver(this, s, s1, cancellationsignal);
        if(cursorfactory == null)
            break MISSING_BLOCK_LABEL_41;
_L1:
        Cursor cursor = sqlitedirectcursordriver.query(cursorfactory, as);
        releaseReference();
        return cursor;
        cursorfactory = mCursorFactory;
          goto _L1
        Exception exception;
        exception;
        releaseReference();
        throw exception;
    }

    public void reopenReadWrite() {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        int i;
        throwIfNotOpenLocked();
        if(!isReadOnlyLocked())
            break MISSING_BLOCK_LABEL_84;
        i = mConfigurationLocked.openFlags;
        mConfigurationLocked.openFlags = 0 | -2 & mConfigurationLocked.openFlags;
        mConnectionPoolLocked.reconfigure(mConfigurationLocked);
        obj;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_84;
        Exception exception;
        exception;
        throw exception;
        RuntimeException runtimeexception;
        runtimeexception;
        mConfigurationLocked.openFlags = i;
        throw runtimeexception;
    }

    public long replace(String s, String s1, ContentValues contentvalues) {
        long l1 = insertWithOnConflict(s, s1, contentvalues, 5);
        long l = l1;
_L2:
        return l;
        SQLException sqlexception;
        sqlexception;
        Log.e("SQLiteDatabase", (new StringBuilder()).append("Error inserting ").append(contentvalues).toString(), sqlexception);
        l = -1L;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public long replaceOrThrow(String s, String s1, ContentValues contentvalues) throws SQLException {
        return insertWithOnConflict(s, s1, contentvalues, 5);
    }

    public void setForeignKeyConstraintsEnabled(boolean flag) {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        throwIfNotOpenLocked();
        if(mConfigurationLocked.foreignKeyConstraintsEnabled == flag)
            break MISSING_BLOCK_LABEL_87;
        mConfigurationLocked.foreignKeyConstraintsEnabled = flag;
        mConnectionPoolLocked.reconfigure(mConfigurationLocked);
        obj;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_87;
        Exception exception;
        exception;
        throw exception;
        RuntimeException runtimeexception;
        runtimeexception;
        SQLiteDatabaseConfiguration sqlitedatabaseconfiguration;
        boolean flag1;
        sqlitedatabaseconfiguration = mConfigurationLocked;
        if(flag)
            break MISSING_BLOCK_LABEL_81;
        flag1 = true;
_L1:
        sqlitedatabaseconfiguration.foreignKeyConstraintsEnabled = flag1;
        throw runtimeexception;
        flag1 = false;
          goto _L1
    }

    public void setLocale(Locale locale) {
        if(locale == null)
            throw new IllegalArgumentException("locale must not be null.");
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        Locale locale1;
        throwIfNotOpenLocked();
        locale1 = mConfigurationLocked.locale;
        mConfigurationLocked.locale = locale;
        try {
            mConnectionPoolLocked.reconfigure(mConfigurationLocked);
        }
        catch(RuntimeException runtimeexception) {
            mConfigurationLocked.locale = locale1;
            throw runtimeexception;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setLockingEnabled(boolean flag) {
    }

    public void setMaxSqlCacheSize(int i) {
        if(i > 100 || i < 0)
            throw new IllegalStateException("expected value between 0 and 100");
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        int j;
        throwIfNotOpenLocked();
        j = mConfigurationLocked.maxSqlCacheSize;
        mConfigurationLocked.maxSqlCacheSize = i;
        try {
            mConnectionPoolLocked.reconfigure(mConfigurationLocked);
        }
        catch(RuntimeException runtimeexception) {
            mConfigurationLocked.maxSqlCacheSize = j;
            throw runtimeexception;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public long setMaximumSize(long l) {
        long l1 = getPageSize();
        long l2 = l / l1;
        if(l % l1 != 0L)
            l2++;
        return l1 * DatabaseUtils.longForQuery(this, (new StringBuilder()).append("PRAGMA max_page_count = ").append(l2).toString(), null);
    }

    public void setPageSize(long l) {
        execSQL((new StringBuilder()).append("PRAGMA page_size = ").append(l).toString());
    }

    public void setTransactionSuccessful() {
        acquireReference();
        getThreadSession().setTransactionSuccessful();
        releaseReference();
        return;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
    }

    public void setVersion(int i) {
        execSQL((new StringBuilder()).append("PRAGMA user_version = ").append(i).toString());
    }

    public String toString() {
        return (new StringBuilder()).append("SQLiteDatabase: ").append(getPath()).toString();
    }

    public int update(String s, ContentValues contentvalues, String s1, String as[]) {
        return updateWithOnConflict(s, contentvalues, s1, as, 0);
    }

    public int updateWithOnConflict(String s, ContentValues contentvalues, String s1, String as[], int i) {
        if(contentvalues == null || contentvalues.size() == 0)
            throw new IllegalArgumentException("Empty values");
        acquireReference();
        StringBuilder stringbuilder;
        int j;
        int k;
        Object aobj[];
        int l;
        String s3;
        stringbuilder = new StringBuilder(120);
        stringbuilder.append("UPDATE ");
        stringbuilder.append(CONFLICT_VALUES[i]);
        stringbuilder.append(s);
        stringbuilder.append(" SET ");
        j = contentvalues.size();
        Iterator iterator;
        String s2;
        int k1;
        if(as == null)
            k = j;
        else
            k = j + as.length;
        aobj = new Object[k];
        iterator = contentvalues.keySet().iterator();
        l = 0;
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        s2 = (String)iterator.next();
        if(l <= 0) goto _L4; else goto _L3
_L3:
        s3 = ",";
_L5:
        stringbuilder.append(s3);
        stringbuilder.append(s2);
        k1 = l + 1;
        aobj[l] = contentvalues.get(s2);
        stringbuilder.append("=?");
        l = k1;
        break MISSING_BLOCK_LABEL_110;
_L6:
        int j1;
        for(; j1 < k; j1++)
            aobj[j1] = as[j1 - j];

_L7:
        SQLiteStatement sqlitestatement;
        if(!TextUtils.isEmpty(s1)) {
            stringbuilder.append(" WHERE ");
            stringbuilder.append(s1);
        }
        sqlitestatement = new SQLiteStatement(this, stringbuilder.toString(), aobj);
        int i1 = sqlitestatement.executeUpdateDelete();
        sqlitestatement.close();
        releaseReference();
        return i1;
        Exception exception1;
        exception1;
        sqlitestatement.close();
        throw exception1;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
_L4:
        s3 = "";
          goto _L5
_L2:
label0:
        {
            if(as == null)
                break label0;
            j1 = j;
        }
          goto _L6
        l;
          goto _L7
    }

    public boolean yieldIfContended() {
        return yieldIfContendedHelper(false, -1L);
    }

    public boolean yieldIfContendedSafely() {
        return yieldIfContendedHelper(true, -1L);
    }

    public boolean yieldIfContendedSafely(long l) {
        return yieldIfContendedHelper(true, l);
    }

    static final boolean $assertionsDisabled = false;
    public static final int CONFLICT_ABORT = 2;
    public static final int CONFLICT_FAIL = 3;
    public static final int CONFLICT_IGNORE = 4;
    public static final int CONFLICT_NONE = 0;
    public static final int CONFLICT_REPLACE = 5;
    public static final int CONFLICT_ROLLBACK = 1;
    private static final String CONFLICT_VALUES[];
    public static final int CREATE_IF_NECESSARY = 0x10000000;
    public static final int ENABLE_WRITE_AHEAD_LOGGING = 0x20000000;
    private static final int EVENT_DB_CORRUPT = 0x124fc;
    public static final int MAX_SQL_CACHE_SIZE = 100;
    public static final int NO_LOCALIZED_COLLATORS = 16;
    public static final int OPEN_READONLY = 1;
    public static final int OPEN_READWRITE = 0;
    private static final int OPEN_READ_MASK = 1;
    public static final int SQLITE_MAX_LIKE_PATTERN_LENGTH = 50000;
    private static final String TAG = "SQLiteDatabase";
    private static WeakHashMap sActiveDatabases = new WeakHashMap();
    private final CloseGuard mCloseGuardLocked = CloseGuard.get();
    private final SQLiteDatabaseConfiguration mConfigurationLocked;
    private SQLiteConnectionPool mConnectionPoolLocked;
    private final CursorFactory mCursorFactory;
    private final DatabaseErrorHandler mErrorHandler;
    private boolean mHasAttachedDbsLocked;
    private final Object mLock = new Object();
    private final ThreadLocal mThreadSession = new ThreadLocal() {

        protected SQLiteSession initialValue() {
            return createSession();
        }

        protected volatile Object initialValue() {
            return initialValue();
        }

        final SQLiteDatabase this$0;

             {
                this$0 = SQLiteDatabase.this;
                super();
            }
    };

    static  {
        boolean flag;
        String as[];
        if(!android/database/sqlite/SQLiteDatabase.desiredAssertionStatus())
            flag = true;
        else
            flag = false;
        $assertionsDisabled = flag;
        as = new String[6];
        as[0] = "";
        as[1] = " OR ROLLBACK ";
        as[2] = " OR ABORT ";
        as[3] = " OR FAIL ";
        as[4] = " OR IGNORE ";
        as[5] = " OR REPLACE ";
        CONFLICT_VALUES = as;
    }
}
