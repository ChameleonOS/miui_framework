// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database.sqlite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.util.Log;
import java.io.File;

// Referenced classes of package android.database.sqlite:
//            SQLiteException, SQLiteDatabase

public abstract class SQLiteOpenHelper {

    public SQLiteOpenHelper(Context context, String s, SQLiteDatabase.CursorFactory cursorfactory, int i) {
        this(context, s, cursorfactory, i, null);
    }

    public SQLiteOpenHelper(Context context, String s, SQLiteDatabase.CursorFactory cursorfactory, int i, DatabaseErrorHandler databaseerrorhandler) {
        if(i < 1) {
            throw new IllegalArgumentException((new StringBuilder()).append("Version must be >= 1, was ").append(i).toString());
        } else {
            mContext = context;
            mName = s;
            mFactory = cursorfactory;
            mNewVersion = i;
            mErrorHandler = databaseerrorhandler;
            return;
        }
    }

    private SQLiteDatabase getDatabaseLocked(boolean flag) {
        if(mDatabase == null) goto _L2; else goto _L1
_L1:
        if(mDatabase.isOpen()) goto _L4; else goto _L3
_L3:
        mDatabase = null;
          goto _L2
_L4:
        if(flag && mDatabase.isReadOnly()) goto _L2; else goto _L5
_L5:
        SQLiteDatabase sqlitedatabase = mDatabase;
_L15:
        return sqlitedatabase;
_L2:
        if(mIsInitializing)
            throw new IllegalStateException("getDatabase called recursively");
        sqlitedatabase = mDatabase;
        mIsInitializing = true;
        if(sqlitedatabase == null) goto _L7; else goto _L6
_L6:
        if(flag && sqlitedatabase.isReadOnly())
            sqlitedatabase.reopenReadWrite();
_L11:
        int i;
        onConfigure(sqlitedatabase);
        i = sqlitedatabase.getVersion();
        if(i == mNewVersion) goto _L9; else goto _L8
_L8:
        if(sqlitedatabase.isReadOnly())
            throw new SQLiteException((new StringBuilder()).append("Can't upgrade read-only database from version ").append(sqlitedatabase.getVersion()).append(" to ").append(mNewVersion).append(": ").append(mName).toString());
          goto _L10
        Exception exception;
        exception;
        mIsInitializing = false;
        if(sqlitedatabase != null && sqlitedatabase != mDatabase)
            sqlitedatabase.close();
        throw exception;
_L7:
        SQLiteDatabase sqlitedatabase2;
        if(mName != null)
            break MISSING_BLOCK_LABEL_213;
        sqlitedatabase2 = SQLiteDatabase.create(null);
        sqlitedatabase = sqlitedatabase2;
          goto _L11
        Context context;
        String s;
        byte byte0;
        context = mContext;
        s = mName;
        if(!mEnableWriteAheadLogging)
            break MISSING_BLOCK_LABEL_261;
        byte0 = 8;
_L12:
        SQLiteDatabase sqlitedatabase1 = context.openOrCreateDatabase(s, byte0, mFactory, mErrorHandler);
        sqlitedatabase = sqlitedatabase1;
          goto _L11
        byte0 = 0;
          goto _L12
        SQLiteException sqliteexception;
        sqliteexception;
        if(!flag)
            break MISSING_BLOCK_LABEL_276;
        throw sqliteexception;
        Log.e(TAG, (new StringBuilder()).append("Couldn't open ").append(mName).append(" for writing (will try read-only):").toString(), sqliteexception);
        sqlitedatabase = SQLiteDatabase.openDatabase(mContext.getDatabasePath(mName).getPath(), mFactory, 1, mErrorHandler);
          goto _L11
_L10:
        sqlitedatabase.beginTransaction();
        if(i != 0) goto _L14; else goto _L13
_L13:
        onCreate(sqlitedatabase);
_L16:
        sqlitedatabase.setVersion(mNewVersion);
        sqlitedatabase.setTransactionSuccessful();
        sqlitedatabase.endTransaction();
_L9:
        onOpen(sqlitedatabase);
        if(sqlitedatabase.isReadOnly())
            Log.w(TAG, (new StringBuilder()).append("Opened ").append(mName).append(" in read-only mode").toString());
        mDatabase = sqlitedatabase;
        mIsInitializing = false;
        if(sqlitedatabase != null && sqlitedatabase != mDatabase)
            sqlitedatabase.close();
          goto _L15
_L14:
        if(i <= mNewVersion)
            break MISSING_BLOCK_LABEL_479;
        onDowngrade(sqlitedatabase, i, mNewVersion);
          goto _L16
        Exception exception1;
        exception1;
        sqlitedatabase.endTransaction();
        throw exception1;
        onUpgrade(sqlitedatabase, i, mNewVersion);
          goto _L16
    }

    /**
     * @deprecated Method close is deprecated
     */

    public void close() {
        this;
        JVM INSTR monitorenter ;
        if(mIsInitializing)
            throw new IllegalStateException("Closed during initialization");
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        if(mDatabase != null && mDatabase.isOpen()) {
            mDatabase.close();
            mDatabase = null;
        }
        this;
        JVM INSTR monitorexit ;
    }

    public String getDatabaseName() {
        return mName;
    }

    public SQLiteDatabase getReadableDatabase() {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = getDatabaseLocked(false);
        return sqlitedatabase;
    }

    public SQLiteDatabase getWritableDatabase() {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = getDatabaseLocked(true);
        return sqlitedatabase;
    }

    public void onConfigure(SQLiteDatabase sqlitedatabase) {
    }

    public abstract void onCreate(SQLiteDatabase sqlitedatabase);

    public void onDowngrade(SQLiteDatabase sqlitedatabase, int i, int j) {
        throw new SQLiteException((new StringBuilder()).append("Can't downgrade database from version ").append(i).append(" to ").append(j).toString());
    }

    public void onOpen(SQLiteDatabase sqlitedatabase) {
    }

    public abstract void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j);

    public void setWriteAheadLoggingEnabled(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        if(mEnableWriteAheadLogging != flag) {
            if(mDatabase != null && mDatabase.isOpen() && !mDatabase.isReadOnly())
                if(flag)
                    mDatabase.enableWriteAheadLogging();
                else
                    mDatabase.disableWriteAheadLogging();
            mEnableWriteAheadLogging = flag;
        }
        return;
    }

    private static final boolean DEBUG_STRICT_READONLY;
    private static final String TAG = android/database/sqlite/SQLiteOpenHelper.getSimpleName();
    private final Context mContext;
    private SQLiteDatabase mDatabase;
    private boolean mEnableWriteAheadLogging;
    private final DatabaseErrorHandler mErrorHandler;
    private final SQLiteDatabase.CursorFactory mFactory;
    private boolean mIsInitializing;
    private final String mName;
    private final int mNewVersion;

}
