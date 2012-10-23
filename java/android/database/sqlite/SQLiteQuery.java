// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database.sqlite;

import android.database.CursorWindow;
import android.os.CancellationSignal;
import android.util.Log;

// Referenced classes of package android.database.sqlite:
//            SQLiteProgram, SQLiteDatabaseCorruptException, SQLiteException, SQLiteSession, 
//            SQLiteDatabase

public final class SQLiteQuery extends SQLiteProgram {

    SQLiteQuery(SQLiteDatabase sqlitedatabase, String s, CancellationSignal cancellationsignal) {
        super(sqlitedatabase, s, null, cancellationsignal);
        mCancellationSignal = cancellationsignal;
    }

    int fillWindow(CursorWindow cursorwindow, int i, int j, boolean flag) {
        acquireReference();
        cursorwindow.acquireReference();
        int k = getSession().executeForCursorWindow(getSql(), getBindArgs(), cursorwindow, i, j, flag, getConnectionFlags(), mCancellationSignal);
        cursorwindow.releaseReference();
        releaseReference();
        return k;
        SQLiteDatabaseCorruptException sqlitedatabasecorruptexception;
        sqlitedatabasecorruptexception;
        onCorruption();
        throw sqlitedatabasecorruptexception;
        Exception exception1;
        exception1;
        cursorwindow.releaseReference();
        throw exception1;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
        SQLiteException sqliteexception;
        sqliteexception;
        Log.e("SQLiteQuery", (new StringBuilder()).append("exception: ").append(sqliteexception.getMessage()).append("; query: ").append(getSql()).toString());
        throw sqliteexception;
    }

    public String toString() {
        return (new StringBuilder()).append("SQLiteQuery: ").append(getSql()).toString();
    }

    private static final String TAG = "SQLiteQuery";
    private final CancellationSignal mCancellationSignal;
}
