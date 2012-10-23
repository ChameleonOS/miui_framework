// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database.sqlite;

import android.content.*;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

// Referenced classes of package android.database.sqlite:
//            SQLiteException

public final class SqliteWrapper {

    private SqliteWrapper() {
    }

    public static void checkSQLiteException(Context context, SQLiteException sqliteexception) {
        if(isLowMemory(sqliteexception)) {
            Toast.makeText(context, 0x1040123, 0).show();
            return;
        } else {
            throw sqliteexception;
        }
    }

    public static int delete(Context context, ContentResolver contentresolver, Uri uri, String s, String as[]) {
        int j = contentresolver.delete(uri, s, as);
        int i = j;
_L2:
        return i;
        SQLiteException sqliteexception;
        sqliteexception;
        Log.e("SqliteWrapper", "Catch a SQLiteException when delete: ", sqliteexception);
        checkSQLiteException(context, sqliteexception);
        i = -1;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static Uri insert(Context context, ContentResolver contentresolver, Uri uri, ContentValues contentvalues) {
        Uri uri2 = contentresolver.insert(uri, contentvalues);
        Uri uri1 = uri2;
_L2:
        return uri1;
        SQLiteException sqliteexception;
        sqliteexception;
        Log.e("SqliteWrapper", "Catch a SQLiteException when insert: ", sqliteexception);
        checkSQLiteException(context, sqliteexception);
        uri1 = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private static boolean isLowMemory(SQLiteException sqliteexception) {
        return sqliteexception.getMessage().equals("unable to open database file");
    }

    public static Cursor query(Context context, ContentResolver contentresolver, Uri uri, String as[], String s, String as1[], String s1) {
        Cursor cursor1 = contentresolver.query(uri, as, s, as1, s1);
        Cursor cursor = cursor1;
_L2:
        return cursor;
        SQLiteException sqliteexception;
        sqliteexception;
        Log.e("SqliteWrapper", "Catch a SQLiteException when query: ", sqliteexception);
        checkSQLiteException(context, sqliteexception);
        cursor = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static boolean requery(Context context, Cursor cursor) {
        boolean flag1 = cursor.requery();
        boolean flag = flag1;
_L2:
        return flag;
        SQLiteException sqliteexception;
        sqliteexception;
        Log.e("SqliteWrapper", "Catch a SQLiteException when requery: ", sqliteexception);
        checkSQLiteException(context, sqliteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static int update(Context context, ContentResolver contentresolver, Uri uri, ContentValues contentvalues, String s, String as[]) {
        int j = contentresolver.update(uri, contentvalues, s, as);
        int i = j;
_L2:
        return i;
        SQLiteException sqliteexception;
        sqliteexception;
        Log.e("SqliteWrapper", "Catch a SQLiteException when update: ", sqliteexception);
        checkSQLiteException(context, sqliteexception);
        i = -1;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private static final String SQLITE_EXCEPTION_DETAIL_MESSAGE = "unable to open database file";
    private static final String TAG = "SqliteWrapper";
}
