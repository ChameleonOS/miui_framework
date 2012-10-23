// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database.sqlite;

import android.database.Cursor;
import android.os.CancellationSignal;

// Referenced classes of package android.database.sqlite:
//            SQLiteCursorDriver, SQLiteQuery, SQLiteCursor, SQLiteDatabase

public final class SQLiteDirectCursorDriver
    implements SQLiteCursorDriver {

    public SQLiteDirectCursorDriver(SQLiteDatabase sqlitedatabase, String s, String s1, CancellationSignal cancellationsignal) {
        mDatabase = sqlitedatabase;
        mEditTable = s1;
        mSql = s;
        mCancellationSignal = cancellationsignal;
    }

    public void cursorClosed() {
    }

    public void cursorDeactivated() {
    }

    public void cursorRequeried(Cursor cursor) {
    }

    public Cursor query(SQLiteDatabase.CursorFactory cursorfactory, String as[]) {
        SQLiteQuery sqlitequery = new SQLiteQuery(mDatabase, mSql, mCancellationSignal);
        sqlitequery.bindAllArgsAsStrings(as);
        if(cursorfactory != null) goto _L2; else goto _L1
_L1:
        Object obj = new SQLiteCursor(this, mEditTable, sqlitequery);
_L4:
        mQuery = sqlitequery;
        return ((Cursor) (obj));
_L2:
        Cursor cursor;
        try {
            cursor = cursorfactory.newCursor(mDatabase, this, mEditTable, sqlitequery);
        }
        catch(RuntimeException runtimeexception) {
            sqlitequery.close();
            throw runtimeexception;
        }
        obj = cursor;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void setBindArguments(String as[]) {
        mQuery.bindAllArgsAsStrings(as);
    }

    public String toString() {
        return (new StringBuilder()).append("SQLiteDirectCursorDriver: ").append(mSql).toString();
    }

    private final CancellationSignal mCancellationSignal;
    private final SQLiteDatabase mDatabase;
    private final String mEditTable;
    private SQLiteQuery mQuery;
    private final String mSql;
}
