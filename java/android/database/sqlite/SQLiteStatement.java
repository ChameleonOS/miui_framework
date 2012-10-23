// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database.sqlite;

import android.os.ParcelFileDescriptor;

// Referenced classes of package android.database.sqlite:
//            SQLiteProgram, SQLiteDatabaseCorruptException, SQLiteSession, SQLiteDatabase

public final class SQLiteStatement extends SQLiteProgram {

    SQLiteStatement(SQLiteDatabase sqlitedatabase, String s, Object aobj[]) {
        super(sqlitedatabase, s, aobj, null);
    }

    public void execute() {
        acquireReference();
        getSession().execute(getSql(), getBindArgs(), getConnectionFlags(), null);
        releaseReference();
        return;
        SQLiteDatabaseCorruptException sqlitedatabasecorruptexception;
        sqlitedatabasecorruptexception;
        onCorruption();
        throw sqlitedatabasecorruptexception;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
    }

    public long executeInsert() {
        acquireReference();
        long l = getSession().executeForLastInsertedRowId(getSql(), getBindArgs(), getConnectionFlags(), null);
        releaseReference();
        return l;
        SQLiteDatabaseCorruptException sqlitedatabasecorruptexception;
        sqlitedatabasecorruptexception;
        onCorruption();
        throw sqlitedatabasecorruptexception;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
    }

    public int executeUpdateDelete() {
        acquireReference();
        int i = getSession().executeForChangedRowCount(getSql(), getBindArgs(), getConnectionFlags(), null);
        releaseReference();
        return i;
        SQLiteDatabaseCorruptException sqlitedatabasecorruptexception;
        sqlitedatabasecorruptexception;
        onCorruption();
        throw sqlitedatabasecorruptexception;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
    }

    public ParcelFileDescriptor simpleQueryForBlobFileDescriptor() {
        acquireReference();
        ParcelFileDescriptor parcelfiledescriptor = getSession().executeForBlobFileDescriptor(getSql(), getBindArgs(), getConnectionFlags(), null);
        releaseReference();
        return parcelfiledescriptor;
        SQLiteDatabaseCorruptException sqlitedatabasecorruptexception;
        sqlitedatabasecorruptexception;
        onCorruption();
        throw sqlitedatabasecorruptexception;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
    }

    public long simpleQueryForLong() {
        acquireReference();
        long l = getSession().executeForLong(getSql(), getBindArgs(), getConnectionFlags(), null);
        releaseReference();
        return l;
        SQLiteDatabaseCorruptException sqlitedatabasecorruptexception;
        sqlitedatabasecorruptexception;
        onCorruption();
        throw sqlitedatabasecorruptexception;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
    }

    public String simpleQueryForString() {
        acquireReference();
        String s = getSession().executeForString(getSql(), getBindArgs(), getConnectionFlags(), null);
        releaseReference();
        return s;
        SQLiteDatabaseCorruptException sqlitedatabasecorruptexception;
        sqlitedatabasecorruptexception;
        onCorruption();
        throw sqlitedatabasecorruptexception;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
    }

    public String toString() {
        return (new StringBuilder()).append("SQLiteProgram: ").append(getSql()).toString();
    }
}
