// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import java.util.*;

// Referenced classes of package android.webkit:
//            WebViewDatabase, WebTextView

final class WebViewDatabaseClassic extends WebViewDatabase {

    WebViewDatabaseClassic(final Context context) {
        mInitialized = false;
        (new Thread() {

            public void run() {
                init(context);
            }

            final WebViewDatabaseClassic this$0;
            final Context val$context;

             {
                this$0 = WebViewDatabaseClassic.this;
                context = context1;
                super();
            }
        }).start();
    }

    private boolean checkInitialized() {
        this;
        JVM INSTR monitorenter ;
_L2:
        boolean flag = mInitialized;
        Exception exception;
        if(flag)
            break; /* Loop/switch isn't completed */
        try {
            wait();
        }
        catch(InterruptedException interruptedexception) {
            Log.e("WebViewDatabaseClassic", "Caught exception while checking initialization");
            Log.e("WebViewDatabaseClassic", Log.getStackTraceString(interruptedexception));
        }
        finally {
            this;
        }
        if(true) goto _L2; else goto _L1
_L1:
        if(false) goto _L4; else goto _L3
_L4:
        JVM INSTR monitorexit ;
        throw exception;
_L3:
        this;
        JVM INSTR monitorexit ;
        boolean flag1;
        if(sDatabase != null)
            flag1 = true;
        else
            flag1 = false;
        return flag1;
    }

    /**
     * @deprecated Method getInstance is deprecated
     */

    public static WebViewDatabaseClassic getInstance(Context context) {
        android/webkit/WebViewDatabaseClassic;
        JVM INSTR monitorenter ;
        WebViewDatabaseClassic webviewdatabaseclassic;
        if(sInstance == null)
            sInstance = new WebViewDatabaseClassic(context);
        webviewdatabaseclassic = sInstance;
        android/webkit/WebViewDatabaseClassic;
        JVM INSTR monitorexit ;
        return webviewdatabaseclassic;
        Exception exception;
        exception;
        throw exception;
    }

    private boolean hasEntries(int i) {
        boolean flag = false;
        if(checkInitialized()) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        Cursor cursor;
        boolean flag1;
        cursor = null;
        flag1 = false;
        boolean flag2;
        cursor = sDatabase.query(mTableNames[i], ID_PROJECTION, null, null, null, null, null);
        flag2 = cursor.moveToFirst();
        if(flag2)
            flag1 = true;
        else
            flag1 = false;
        if(cursor == null) goto _L4; else goto _L3
_L3:
        cursor.close();
_L4:
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        IllegalStateException illegalstateexception;
        illegalstateexception;
        Log.e("WebViewDatabaseClassic", "hasEntries", illegalstateexception);
        if(cursor == null) goto _L4; else goto _L3
        Exception exception;
        exception;
        if(cursor != null)
            cursor.close();
        throw exception;
        if(true) goto _L1; else goto _L5
_L5:
    }

    /**
     * @deprecated Method init is deprecated
     */

    private void init(Context context) {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mInitialized;
        if(!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        initDatabase(context);
        context.deleteDatabase("webviewCache.db");
        mInitialized = true;
        notify();
        if(true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private void initDatabase(Context context) {
        try {
            sDatabase = context.openOrCreateDatabase("webview.db", 0, null);
        }
        catch(SQLiteException sqliteexception) {
            if(context.deleteDatabase("webview.db"))
                sDatabase = context.openOrCreateDatabase("webview.db", 0, null);
            continue; /* Loop/switch isn't completed */
        }
_L6:
        if(sDatabase != null) goto _L2; else goto _L1
_L1:
        mInitialized = true;
        notify();
_L4:
        return;
_L2:
        if(sDatabase.getVersion() == 11) goto _L4; else goto _L3
_L3:
        sDatabase.beginTransactionNonExclusive();
        upgradeDatabase();
        sDatabase.setTransactionSuccessful();
        sDatabase.endTransaction();
          goto _L4
        Exception exception;
        exception;
        sDatabase.endTransaction();
        throw exception;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private static void upgradeDatabase() {
        upgradeDatabaseToV10();
        upgradeDatabaseFromV10ToV11();
        sDatabase.setVersion(11);
    }

    private static void upgradeDatabaseFromV10ToV11() {
        if(sDatabase.getVersion() < 11) {
            sDatabase.execSQL("DROP TABLE IF EXISTS cookies");
            sDatabase.execSQL("DROP TABLE IF EXISTS cache");
            Cursor cursor;
            ContentValues contentvalues;
            SQLiteDatabase sqlitedatabase;
            String s2;
            String as[];
            for(cursor = sDatabase.query(mTableNames[1], null, null, null, null, null, null); cursor.moveToNext(); sqlitedatabase.update(s2, contentvalues, "_id=?", as)) {
                String s = Long.toString(cursor.getLong(cursor.getColumnIndex("_id")));
                String s1 = cursor.getString(cursor.getColumnIndex("url"));
                contentvalues = new ContentValues(1);
                contentvalues.put("url", WebTextView.urlForAutoCompleteData(s1));
                sqlitedatabase = sDatabase;
                s2 = mTableNames[1];
                as = new String[1];
                as[0] = s;
            }

            cursor.close();
        }
    }

    private static void upgradeDatabaseToV10() {
        int i = sDatabase.getVersion();
        if(i < 10) {
            if(i != 0)
                Log.i("WebViewDatabaseClassic", (new StringBuilder()).append("Upgrading database from version ").append(i).append(" to ").append(11).append(", which will destroy old data").toString());
            if(9 == i) {
                sDatabase.execSQL((new StringBuilder()).append("DROP TABLE IF EXISTS ").append(mTableNames[3]).toString());
                sDatabase.execSQL((new StringBuilder()).append("CREATE TABLE ").append(mTableNames[3]).append(" (").append("_id").append(" INTEGER PRIMARY KEY, ").append("host").append(" TEXT, ").append("realm").append(" TEXT, ").append("username").append(" TEXT, ").append("password").append(" TEXT,").append(" UNIQUE (").append("host").append(", ").append("realm").append(") ON CONFLICT REPLACE);").toString());
            } else {
                sDatabase.execSQL("DROP TABLE IF EXISTS cookies");
                sDatabase.execSQL("DROP TABLE IF EXISTS cache");
                sDatabase.execSQL((new StringBuilder()).append("DROP TABLE IF EXISTS ").append(mTableNames[1]).toString());
                sDatabase.execSQL((new StringBuilder()).append("DROP TABLE IF EXISTS ").append(mTableNames[2]).toString());
                sDatabase.execSQL((new StringBuilder()).append("DROP TABLE IF EXISTS ").append(mTableNames[3]).toString());
                sDatabase.execSQL((new StringBuilder()).append("DROP TABLE IF EXISTS ").append(mTableNames[0]).toString());
                sDatabase.execSQL((new StringBuilder()).append("CREATE TABLE ").append(mTableNames[1]).append(" (").append("_id").append(" INTEGER PRIMARY KEY, ").append("url").append(" TEXT").append(");").toString());
                sDatabase.execSQL((new StringBuilder()).append("CREATE TABLE ").append(mTableNames[2]).append(" (").append("_id").append(" INTEGER PRIMARY KEY, ").append("urlid").append(" INTEGER, ").append("name").append(" TEXT, ").append("value").append(" TEXT,").append(" UNIQUE (").append("urlid").append(", ").append("name").append(", ").append("value").append(") ON CONFLICT IGNORE);").toString());
                sDatabase.execSQL((new StringBuilder()).append("CREATE TABLE ").append(mTableNames[3]).append(" (").append("_id").append(" INTEGER PRIMARY KEY, ").append("host").append(" TEXT, ").append("realm").append(" TEXT, ").append("username").append(" TEXT, ").append("password").append(" TEXT,").append(" UNIQUE (").append("host").append(", ").append("realm").append(") ON CONFLICT REPLACE);").toString());
                sDatabase.execSQL((new StringBuilder()).append("CREATE TABLE ").append(mTableNames[0]).append(" (").append("_id").append(" INTEGER PRIMARY KEY, ").append("host").append(" TEXT, ").append("username").append(" TEXT, ").append("password").append(" TEXT,").append(" UNIQUE (").append("host").append(", ").append("username").append(") ON CONFLICT REPLACE);").toString());
            }
        }
    }

    public void clearFormData() {
        if(checkInitialized()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj = mFormLock;
        obj;
        JVM INSTR monitorenter ;
        sDatabase.delete(mTableNames[1], null, null);
        sDatabase.delete(mTableNames[2], null, null);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void clearHttpAuthUsernamePassword() {
        if(checkInitialized()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj = mHttpAuthLock;
        obj;
        JVM INSTR monitorenter ;
        sDatabase.delete(mTableNames[3], null, null);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void clearUsernamePassword() {
        if(checkInitialized()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj = mPasswordLock;
        obj;
        JVM INSTR monitorenter ;
        sDatabase.delete(mTableNames[0], null, null);
        if(true) goto _L1; else goto _L3
_L3:
    }

    ArrayList getFormData(String s, String s1) {
        ArrayList arraylist = new ArrayList();
        if(s != null && s1 != null && checkInitialized()) goto _L2; else goto _L1
_L1:
        return arraylist;
_L2:
        Object obj = mFormLock;
        obj;
        JVM INSTR monitorenter ;
        Cursor cursor = null;
        SQLiteDatabase sqlitedatabase = sDatabase;
        String s2 = mTableNames[1];
        String as[] = ID_PROJECTION;
        String as1[] = new String[1];
        as1[0] = s;
        cursor = sqlitedatabase.query(s2, as, "(url == ?)", as1, null, null, null);
_L8:
        if(!cursor.moveToNext()) goto _L4; else goto _L3
_L3:
        long l = cursor.getLong(cursor.getColumnIndex("_id"));
        Cursor cursor1 = null;
        SQLiteDatabase sqlitedatabase1 = sDatabase;
        String s3 = mTableNames[2];
        String as2[] = new String[2];
        as2[0] = "_id";
        as2[1] = "value";
        String as3[] = new String[2];
        as3[0] = Long.toString(l);
        as3[1] = s1;
        cursor1 = sqlitedatabase1.query(s3, as2, "(urlid == ?) AND (name == ?)", as3, null, null, null);
        if(!cursor1.moveToFirst()) goto _L6; else goto _L5
_L5:
        int i = cursor1.getColumnIndex("value");
        boolean flag;
        do {
            arraylist.add(cursor1.getString(i));
            flag = cursor1.moveToNext();
        } while(flag);
_L6:
        if(cursor1 == null) goto _L8; else goto _L7
_L7:
        cursor1.close();
          goto _L8
        IllegalStateException illegalstateexception;
        illegalstateexception;
        Log.e("WebViewDatabaseClassic", "getFormData cursor", illegalstateexception);
        if(cursor != null)
            cursor.close();
_L11:
        obj;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception1;
        exception1;
        throw exception1;
        IllegalStateException illegalstateexception1;
        illegalstateexception1;
        Log.e("WebViewDatabaseClassic", "getFormData dataCursor", illegalstateexception1);
        if(cursor1 == null) goto _L8; else goto _L9
_L9:
        cursor1.close();
          goto _L8
        Exception exception;
        exception;
        if(cursor == null)
            break MISSING_BLOCK_LABEL_329;
        cursor.close();
        throw exception;
        Exception exception2;
        exception2;
        if(cursor1 == null)
            break MISSING_BLOCK_LABEL_346;
        cursor1.close();
        throw exception2;
_L4:
        if(cursor == null) goto _L11; else goto _L10
_L10:
        cursor.close();
          goto _L11
    }

    String[] getHttpAuthUsernamePassword(String s, String s1) {
        String as[] = null;
        if(s != null && s1 != null && checkInitialized()) goto _L2; else goto _L1
_L1:
        return as;
_L2:
        String as1[];
        as1 = new String[2];
        as1[0] = "username";
        as1[1] = "password";
        Object obj = mHttpAuthLock;
        obj;
        JVM INSTR monitorenter ;
        Cursor cursor;
        as = null;
        cursor = null;
        SQLiteDatabase sqlitedatabase = sDatabase;
        String s2 = mTableNames[3];
        String as2[] = new String[2];
        as2[0] = s;
        as2[1] = s1;
        cursor = sqlitedatabase.query(s2, as1, "(host == ?) AND (realm == ?)", as2, null, null, null);
        if(cursor.moveToFirst()) {
            as = new String[2];
            as[0] = cursor.getString(cursor.getColumnIndex("username"));
            as[1] = cursor.getString(cursor.getColumnIndex("password"));
        }
        if(cursor != null)
            cursor.close();
_L4:
        obj;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception1;
        exception1;
        throw exception1;
        IllegalStateException illegalstateexception;
        illegalstateexception;
        Log.e("WebViewDatabaseClassic", "getHttpAuthUsernamePassword", illegalstateexception);
        if(cursor == null) goto _L4; else goto _L3
_L3:
        cursor.close();
          goto _L4
        Exception exception;
        exception;
        if(cursor != null)
            cursor.close();
        throw exception;
          goto _L1
    }

    String[] getUsernamePassword(String s) {
        String as[] = null;
        if(s != null && checkInitialized()) goto _L2; else goto _L1
_L1:
        return as;
_L2:
        String as1[];
        as1 = new String[2];
        as1[0] = "username";
        as1[1] = "password";
        Object obj = mPasswordLock;
        obj;
        JVM INSTR monitorenter ;
        Cursor cursor;
        as = null;
        cursor = null;
        SQLiteDatabase sqlitedatabase = sDatabase;
        String s1 = mTableNames[0];
        String as2[] = new String[1];
        as2[0] = s;
        cursor = sqlitedatabase.query(s1, as1, "(host == ?)", as2, null, null, null);
        if(cursor.moveToFirst()) {
            as = new String[2];
            as[0] = cursor.getString(cursor.getColumnIndex("username"));
            as[1] = cursor.getString(cursor.getColumnIndex("password"));
        }
        if(cursor != null)
            cursor.close();
_L4:
        obj;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception1;
        exception1;
        throw exception1;
        IllegalStateException illegalstateexception;
        illegalstateexception;
        Log.e("WebViewDatabaseClassic", "getUsernamePassword", illegalstateexception);
        if(cursor == null) goto _L4; else goto _L3
_L3:
        cursor.close();
          goto _L4
        Exception exception;
        exception;
        if(cursor != null)
            cursor.close();
        throw exception;
          goto _L1
    }

    public boolean hasFormData() {
        Object obj = mFormLock;
        obj;
        JVM INSTR monitorenter ;
        boolean flag = hasEntries(1);
        return flag;
    }

    public boolean hasHttpAuthUsernamePassword() {
        Object obj = mHttpAuthLock;
        obj;
        JVM INSTR monitorenter ;
        boolean flag = hasEntries(3);
        return flag;
    }

    public boolean hasUsernamePassword() {
        Object obj = mPasswordLock;
        obj;
        JVM INSTR monitorenter ;
        boolean flag = hasEntries(0);
        return flag;
    }

    void setFormData(String s, HashMap hashmap) {
        if(s != null && hashmap != null && checkInitialized()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj = mFormLock;
        obj;
        JVM INSTR monitorenter ;
        long l;
        Cursor cursor;
        l = -1L;
        cursor = null;
        SQLiteDatabase sqlitedatabase = sDatabase;
        String s1 = mTableNames[1];
        String as[] = ID_PROJECTION;
        String as1[] = new String[1];
        as1[0] = s;
        cursor = sqlitedatabase.query(s1, as, "(url == ?)", as1, null, null, null);
        if(!cursor.moveToFirst()) goto _L4; else goto _L3
_L3:
        long l2 = cursor.getLong(cursor.getColumnIndex("_id"));
        l = l2;
_L5:
        if(cursor != null)
            cursor.close();
_L7:
        if(l >= 0L) {
            Iterator iterator = hashmap.entrySet().iterator();
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("urlid", Long.valueOf(l));
            for(; iterator.hasNext(); sDatabase.insert(mTableNames[2], null, contentvalues)) {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                contentvalues.put("name", (String)entry.getKey());
                contentvalues.put("value", (String)entry.getValue());
            }

        }
          goto _L1
        Exception exception1;
        exception1;
        throw exception1;
_L4:
        long l1;
        ContentValues contentvalues1 = new ContentValues();
        contentvalues1.put("url", s);
        l1 = sDatabase.insert(mTableNames[1], null, contentvalues1);
        l = l1;
          goto _L5
        IllegalStateException illegalstateexception;
        illegalstateexception;
        Log.e("WebViewDatabaseClassic", "setFormData", illegalstateexception);
        if(cursor == null) goto _L7; else goto _L6
_L6:
        cursor.close();
          goto _L7
        Exception exception;
        exception;
        if(cursor != null)
            cursor.close();
        throw exception;
          goto _L1
    }

    void setHttpAuthUsernamePassword(String s, String s1, String s2, String s3) {
        if(s != null && s1 != null && checkInitialized()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj = mHttpAuthLock;
        obj;
        JVM INSTR monitorenter ;
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("host", s);
        contentvalues.put("realm", s1);
        contentvalues.put("username", s2);
        contentvalues.put("password", s3);
        sDatabase.insert(mTableNames[3], "host", contentvalues);
        if(true) goto _L1; else goto _L3
_L3:
    }

    void setUsernamePassword(String s, String s1, String s2) {
        if(s != null && checkInitialized()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj = mPasswordLock;
        obj;
        JVM INSTR monitorenter ;
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("host", s);
        contentvalues.put("username", s1);
        contentvalues.put("password", s2);
        sDatabase.insert(mTableNames[0], "host", contentvalues);
        if(true) goto _L1; else goto _L3
_L3:
    }

    private static final String CACHE_DATABASE_FILE = "webviewCache.db";
    private static final String DATABASE_FILE = "webview.db";
    private static final int DATABASE_VERSION = 11;
    private static final String FORMDATA_NAME_COL = "name";
    private static final String FORMDATA_URLID_COL = "urlid";
    private static final String FORMDATA_VALUE_COL = "value";
    private static final String FORMURL_URL_COL = "url";
    private static final String HTTPAUTH_HOST_COL = "host";
    private static final String HTTPAUTH_PASSWORD_COL = "password";
    private static final String HTTPAUTH_REALM_COL = "realm";
    private static final String HTTPAUTH_USERNAME_COL = "username";
    private static final String ID_COL = "_id";
    private static final String ID_PROJECTION[];
    private static final String LOGTAG = "WebViewDatabaseClassic";
    private static final String PASSWORD_HOST_COL = "host";
    private static final String PASSWORD_PASSWORD_COL = "password";
    private static final String PASSWORD_USERNAME_COL = "username";
    private static final int TABLE_FORMDATA_ID = 2;
    private static final int TABLE_FORMURL_ID = 1;
    private static final int TABLE_HTTPAUTH_ID = 3;
    private static final int TABLE_PASSWORD_ID;
    private static final String mTableNames[];
    private static SQLiteDatabase sDatabase = null;
    private static WebViewDatabaseClassic sInstance = null;
    private final Object mFormLock = new Object();
    private final Object mHttpAuthLock = new Object();
    private boolean mInitialized;
    private final Object mPasswordLock = new Object();

    static  {
        String as[] = new String[4];
        as[0] = "password";
        as[1] = "formurl";
        as[2] = "formdata";
        as[3] = "httpauth";
        mTableNames = as;
        String as1[] = new String[1];
        as1[0] = "_id";
        ID_PROJECTION = as1;
    }

}
