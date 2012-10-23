// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database.sqlite;

import android.database.*;
import android.os.StrictMode;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package android.database.sqlite:
//            DatabaseObjectNotClosedException, SQLiteQuery, SQLiteDatabase, SQLiteCursorDriver

public class SQLiteCursor extends AbstractWindowedCursor {

    public SQLiteCursor(SQLiteCursorDriver sqlitecursordriver, String s, SQLiteQuery sqlitequery) {
        mCount = -1;
        if(sqlitequery == null)
            throw new IllegalArgumentException("query object cannot be null");
        if(StrictMode.vmSqliteObjectLeaksEnabled())
            mStackTrace = (new DatabaseObjectNotClosedException()).fillInStackTrace();
        else
            mStackTrace = null;
        mDriver = sqlitecursordriver;
        mEditTable = s;
        mColumnNameMap = null;
        mQuery = sqlitequery;
        mColumns = sqlitequery.getColumnNames();
        super.mRowIdColumnIndex = DatabaseUtils.findRowIdColumnIndex(mColumns);
    }

    public SQLiteCursor(SQLiteDatabase sqlitedatabase, SQLiteCursorDriver sqlitecursordriver, String s, SQLiteQuery sqlitequery) {
        this(sqlitecursordriver, s, sqlitequery);
    }

    private void fillWindow(int i) {
        clearOrCreateWindow(getDatabase().getPath());
        if(mCount == -1) {
            int k = DatabaseUtils.cursorPickFillWindowStartPosition(i, 0);
            mCount = mQuery.fillWindow(super.mWindow, k, i, true);
            mCursorWindowCapacity = super.mWindow.getNumRows();
            if(Log.isLoggable("SQLiteCursor", 3))
                Log.d("SQLiteCursor", (new StringBuilder()).append("received count(*) from native_fill_window: ").append(mCount).toString());
        } else {
            int j = DatabaseUtils.cursorPickFillWindowStartPosition(i, mCursorWindowCapacity);
            mQuery.fillWindow(super.mWindow, j, i, false);
        }
    }

    public void close() {
        super.close();
        this;
        JVM INSTR monitorenter ;
        mQuery.close();
        mDriver.cursorClosed();
        return;
    }

    public void deactivate() {
        super.deactivate();
        mDriver.cursorDeactivated();
    }

    protected void finalize() {
        if(super.mWindow != null) {
            if(mStackTrace != null) {
                String s = mQuery.getSql();
                int i = s.length();
                StringBuilder stringbuilder = (new StringBuilder()).append("Finalizing a Cursor that has not been deactivated or closed. database = ").append(mQuery.getDatabase().getLabel()).append(", table = ").append(mEditTable).append(", query = ");
                if(i > 1000)
                    i = 1000;
                StrictMode.onSqliteObjectLeaked(stringbuilder.append(s.substring(0, i)).toString(), mStackTrace);
            }
            close();
        }
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public int getColumnIndex(String s) {
        int i = -1;
        if(mColumnNameMap == null) {
            String as[] = mColumns;
            int k = as.length;
            HashMap hashmap = new HashMap(k, 1.0F);
            for(int l = 0; l < k; l++)
                hashmap.put(as[l], Integer.valueOf(l));

            mColumnNameMap = hashmap;
        }
        int j = s.lastIndexOf('.');
        if(j != i) {
            Exception exception = new Exception();
            Log.e("SQLiteCursor", (new StringBuilder()).append("requesting column name with table name -- ").append(s).toString(), exception);
            s = s.substring(j + 1);
        }
        Integer integer = (Integer)mColumnNameMap.get(s);
        if(integer != null)
            i = integer.intValue();
        return i;
    }

    public String[] getColumnNames() {
        return mColumns;
    }

    public int getCount() {
        if(mCount == -1)
            fillWindow(0);
        return mCount;
    }

    public SQLiteDatabase getDatabase() {
        return mQuery.getDatabase();
    }

    public boolean onMove(int i, int j) {
        if(super.mWindow == null || j < super.mWindow.getStartPosition() || j >= super.mWindow.getStartPosition() + super.mWindow.getNumRows())
            fillWindow(j);
        return true;
    }

    public boolean requery() {
        boolean flag = false;
        if(!isClosed()) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        this;
        JVM INSTR monitorenter ;
        if(!mQuery.getDatabase().isOpen())
            continue; /* Loop/switch isn't completed */
        break MISSING_BLOCK_LABEL_36;
        Exception exception;
        exception;
        throw exception;
        if(super.mWindow != null)
            super.mWindow.clear();
        super.mPos = -1;
        mCount = -1;
        mDriver.cursorRequeried(this);
        this;
        JVM INSTR monitorexit ;
        boolean flag1 = super.requery();
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        IllegalStateException illegalstateexception;
        illegalstateexception;
        Log.w("SQLiteCursor", (new StringBuilder()).append("requery() failed ").append(illegalstateexception.getMessage()).toString(), illegalstateexception);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void setSelectionArguments(String as[]) {
        mDriver.setBindArguments(as);
    }

    public void setWindow(CursorWindow cursorwindow) {
        super.setWindow(cursorwindow);
        mCount = -1;
    }

    static final int NO_COUNT = -1;
    static final String TAG = "SQLiteCursor";
    private Map mColumnNameMap;
    private final String mColumns[];
    private int mCount;
    private int mCursorWindowCapacity;
    private final SQLiteCursorDriver mDriver;
    private final String mEditTable;
    private final SQLiteQuery mQuery;
    private final Throwable mStackTrace;
}
