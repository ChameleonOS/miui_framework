// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database.sqlite;

import android.database.DatabaseUtils;
import android.os.CancellationSignal;
import java.util.Arrays;

// Referenced classes of package android.database.sqlite:
//            SQLiteClosable, SQLiteStatementInfo, SQLiteDatabase, SQLiteSession

public abstract class SQLiteProgram extends SQLiteClosable {

    SQLiteProgram(SQLiteDatabase sqlitedatabase, String s, Object aobj[], CancellationSignal cancellationsignal) {
        boolean flag;
        int i;
        flag = true;
        super();
        mDatabase = sqlitedatabase;
        mSql = s.trim();
        i = DatabaseUtils.getSqlStatementType(mSql);
        i;
        JVM INSTR tableswitch 4 6: default 56
    //                   4 178
    //                   5 178
    //                   6 178;
           goto _L1 _L2 _L2 _L2
_L1:
        SQLiteStatementInfo sqlitestatementinfo;
        if(i != flag)
            flag = false;
        sqlitestatementinfo = new SQLiteStatementInfo();
        sqlitedatabase.getThreadSession().prepare(mSql, sqlitedatabase.getThreadDefaultConnectionFlags(flag), cancellationsignal, sqlitestatementinfo);
        mReadOnly = sqlitestatementinfo.readOnly;
        mColumnNames = sqlitestatementinfo.columnNames;
        mNumParameters = sqlitestatementinfo.numParameters;
_L4:
        if(aobj != null && aobj.length > mNumParameters)
            throw new IllegalArgumentException((new StringBuilder()).append("Too many bind arguments.  ").append(aobj.length).append(" arguments were provided but the statement needs ").append(mNumParameters).append(" arguments.").toString());
        break; /* Loop/switch isn't completed */
_L2:
        mReadOnly = false;
        mColumnNames = EMPTY_STRING_ARRAY;
        mNumParameters = 0;
        if(true) goto _L4; else goto _L3
_L3:
        if(mNumParameters != 0) {
            mBindArgs = new Object[mNumParameters];
            if(aobj != null)
                System.arraycopy(((Object) (aobj)), 0, ((Object) (mBindArgs)), 0, aobj.length);
        } else {
            mBindArgs = null;
        }
        return;
    }

    private void bind(int i, Object obj) {
        if(i < 1 || i > mNumParameters) {
            throw new IllegalArgumentException((new StringBuilder()).append("Cannot bind argument at index ").append(i).append(" because the index is out of range.  ").append("The statement has ").append(mNumParameters).append(" parameters.").toString());
        } else {
            mBindArgs[i - 1] = obj;
            return;
        }
    }

    public void bindAllArgsAsStrings(String as[]) {
        if(as != null) {
            for(int i = as.length; i != 0; i--)
                bindString(i, as[i - 1]);

        }
    }

    public void bindBlob(int i, byte abyte0[]) {
        if(abyte0 == null) {
            throw new IllegalArgumentException((new StringBuilder()).append("the bind value at index ").append(i).append(" is null").toString());
        } else {
            bind(i, abyte0);
            return;
        }
    }

    public void bindDouble(int i, double d) {
        bind(i, Double.valueOf(d));
    }

    public void bindLong(int i, long l) {
        bind(i, Long.valueOf(l));
    }

    public void bindNull(int i) {
        bind(i, null);
    }

    public void bindString(int i, String s) {
        if(s == null) {
            throw new IllegalArgumentException((new StringBuilder()).append("the bind value at index ").append(i).append(" is null").toString());
        } else {
            bind(i, s);
            return;
        }
    }

    public void clearBindings() {
        if(mBindArgs != null)
            Arrays.fill(mBindArgs, null);
    }

    final Object[] getBindArgs() {
        return mBindArgs;
    }

    final String[] getColumnNames() {
        return mColumnNames;
    }

    protected final int getConnectionFlags() {
        return mDatabase.getThreadDefaultConnectionFlags(mReadOnly);
    }

    final SQLiteDatabase getDatabase() {
        return mDatabase;
    }

    protected final SQLiteSession getSession() {
        return mDatabase.getThreadSession();
    }

    final String getSql() {
        return mSql;
    }

    public final int getUniqueId() {
        return -1;
    }

    protected void onAllReferencesReleased() {
        clearBindings();
    }

    protected final void onCorruption() {
        mDatabase.onCorruption();
    }

    private static final String EMPTY_STRING_ARRAY[] = new String[0];
    private final Object mBindArgs[];
    private final String mColumnNames[];
    private final SQLiteDatabase mDatabase;
    private final int mNumParameters;
    private final boolean mReadOnly;
    private final String mSql;

}
