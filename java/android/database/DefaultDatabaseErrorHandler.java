// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;
import java.io.File;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package android.database:
//            DatabaseErrorHandler

public final class DefaultDatabaseErrorHandler
    implements DatabaseErrorHandler {

    public DefaultDatabaseErrorHandler() {
    }

    private void deleteDatabaseFile(String s) {
        if(!s.equalsIgnoreCase(":memory:") && s.trim().length() != 0) {
            Log.e("DefaultDatabaseErrorHandler", (new StringBuilder()).append("deleting the database file: ").append(s).toString());
            try {
                (new File(s)).delete();
            }
            catch(Exception exception) {
                Log.w("DefaultDatabaseErrorHandler", (new StringBuilder()).append("delete failed: ").append(exception.getMessage()).toString());
            }
        }
    }

    public void onCorruption(SQLiteDatabase sqlitedatabase) {
        Log.e("DefaultDatabaseErrorHandler", (new StringBuilder()).append("Corruption reported by sqlite on database: ").append(sqlitedatabase.getPath()).toString());
        if(sqlitedatabase.isOpen()) goto _L2; else goto _L1
_L1:
        deleteDatabaseFile(sqlitedatabase.getPath());
_L4:
        return;
_L2:
        List list = null;
        List list1 = sqlitedatabase.getAttachedDbs();
        list = list1;
_L5:
        SQLiteException sqliteexception;
        Exception exception;
        Iterator iterator1;
        try {
            sqlitedatabase.close();
        }
        catch(SQLiteException sqliteexception1) { }
        finally {
            if(list == null) goto _L0; else goto _L0
        }
        if(list != null) {
            Iterator iterator = list.iterator();
            while(iterator.hasNext()) 
                deleteDatabaseFile((String)((Pair)iterator.next()).second);
        } else {
            deleteDatabaseFile(sqlitedatabase.getPath());
        }
        if(true) goto _L4; else goto _L3
_L3:
        for(iterator1 = list.iterator(); iterator1.hasNext(); deleteDatabaseFile((String)((Pair)iterator1.next()).second));
        break MISSING_BLOCK_LABEL_170;
        deleteDatabaseFile(sqlitedatabase.getPath());
        throw exception;
        sqliteexception;
          goto _L5
    }

    private static final String TAG = "DefaultDatabaseErrorHandler";
}
