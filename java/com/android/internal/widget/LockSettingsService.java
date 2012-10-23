// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.*;
import android.text.TextUtils;
import android.util.Slog;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class LockSettingsService extends ILockSettings.Stub {
    class DatabaseHelper extends SQLiteOpenHelper {

        private void createTable(SQLiteDatabase sqlitedatabase) {
            sqlitedatabase.execSQL("CREATE TABLE locksettings (_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,user INTEGER,value TEXT);");
        }

        public void onCreate(SQLiteDatabase sqlitedatabase) {
            createTable(sqlitedatabase);
        }

        public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j) {
        }

        private static final String DATABASE_NAME = "locksettings.db";
        private static final int DATABASE_VERSION = 1;
        private static final String TAG = "LockSettingsDB";
        final LockSettingsService this$0;

        public DatabaseHelper(Context context) {
            this$0 = LockSettingsService.this;
            super(context, "locksettings.db", null, 1);
            setWriteAheadLoggingEnabled(true);
        }
    }


    public LockSettingsService(Context context) {
        mContext = context;
        mOpenHelper = new DatabaseHelper(mContext);
    }

    private static final void checkPasswordReadPermission(int i) {
        int j = Binder.getCallingUid();
        if(UserId.getAppId(j) != 1000)
            throw new SecurityException((new StringBuilder()).append("uid=").append(j).append(" not authorized to read lock password").toString());
        else
            return;
    }

    private static final void checkReadPermission(int i) {
        int j = Binder.getCallingUid();
        if(UserId.getAppId(j) != 1000 && UserId.getUserId(j) != i)
            throw new SecurityException((new StringBuilder()).append("uid=").append(j).append(" not authorized to read settings of user ").append(i).toString());
        else
            return;
    }

    private static final void checkWritePermission(int i) {
        int j = Binder.getCallingUid();
        if(UserId.getAppId(j) != 1000)
            throw new SecurityException((new StringBuilder()).append("uid=").append(j).append(" not authorized to write lock settings").toString());
        else
            return;
    }

    private String getLockPasswordFilename(int i) {
        String s = (new StringBuilder()).append(Environment.getDataDirectory().getAbsolutePath()).append("/system/").toString();
        String s1;
        if(i == 0)
            s1 = (new StringBuilder()).append(s).append("password.key").toString();
        else
            s1 = (new StringBuilder()).append(s).append("users/").append(i).append("/").append("password.key").toString();
        return s1;
    }

    private String getLockPatternFilename(int i) {
        String s = (new StringBuilder()).append(Environment.getDataDirectory().getAbsolutePath()).append("/system/").toString();
        String s1;
        if(i == 0)
            s1 = (new StringBuilder()).append(s).append("gesture.key").toString();
        else
            s1 = (new StringBuilder()).append(s).append("users/").append(i).append("/").append("gesture.key").toString();
        return s1;
    }

    private void migrateOldData() {
        android.content.ContentResolver contentresolver;
        String as[];
        int i;
        if(getString("migrated", null, 0) != null)
            break MISSING_BLOCK_LABEL_103;
        contentresolver = mContext.getContentResolver();
        as = VALID_SETTINGS;
        i = as.length;
        RemoteException remoteexception;
        for(int j = 0; j < i; j++) {
            String s = as[j];
            String s1 = android.provider.Settings.Secure.getString(contentresolver, s);
            if(s1 != null)
                setString(s, s1, 0);
            break MISSING_BLOCK_LABEL_104;
        }

        setString("migrated", "true", 0);
        Slog.i("LockSettingsService", "Migrated lock settings to new location");
        break MISSING_BLOCK_LABEL_103;
        remoteexception;
        Slog.e("LockSettingsService", "Unable to migrate old data");
    }

    private byte[] passwordToHash(byte abyte0[], byte abyte1[]) {
        if(abyte1 != null && abyte0.length != 72) goto _L2; else goto _L1
_L1:
        byte abyte2[] = abyte1;
_L4:
        return abyte2;
_L2:
        abyte2 = null;
        byte abyte3[];
        abyte2 = MessageDigest.getInstance("MD5").digest(abyte1);
        abyte3 = toHex(abyte2).getBytes();
        abyte2 = abyte3;
        continue; /* Loop/switch isn't completed */
        NoSuchAlgorithmException nosuchalgorithmexception;
        nosuchalgorithmexception;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private String readFromDb(String s, String s1, int i) {
        String s2 = s1;
        SQLiteDatabase sqlitedatabase = mOpenHelper.getReadableDatabase();
        String as[] = COLUMNS_FOR_QUERY;
        String as1[] = new String[2];
        as1[0] = Integer.toString(i);
        as1[1] = s;
        Cursor cursor = sqlitedatabase.query("locksettings", as, "user=? AND name=?", as1, null, null, null);
        if(cursor != null) {
            if(cursor.moveToFirst())
                s2 = cursor.getString(0);
            cursor.close();
        }
        return s2;
    }

    private static String toHex(byte abyte0[]) {
        String s = "";
        for(int i = 0; i < abyte0.length; i++) {
            String s1 = (new StringBuilder()).append(s).append("0123456789ABCDEF".charAt(0xf & abyte0[i] >> 4)).toString();
            s = (new StringBuilder()).append(s1).append("0123456789ABCDEF".charAt(0xf & abyte0[i])).toString();
        }

        return s;
    }

    private void writeFile(String s, byte abyte0[]) {
        try {
            RandomAccessFile randomaccessfile = new RandomAccessFile(s, "rw");
            if(abyte0 == null || abyte0.length == 0)
                randomaccessfile.setLength(0L);
            else
                randomaccessfile.write(abyte0, 0, abyte0.length);
            randomaccessfile.close();
        }
        catch(IOException ioexception) {
            Slog.e("LockSettingsService", (new StringBuilder()).append("Error writing to file ").append(ioexception).toString());
        }
    }

    private void writeToDb(String s, String s1, int i) {
        ContentValues contentvalues;
        SQLiteDatabase sqlitedatabase;
        contentvalues = new ContentValues();
        contentvalues.put("name", s);
        contentvalues.put("user", Integer.valueOf(i));
        contentvalues.put("value", s1);
        sqlitedatabase = mOpenHelper.getWritableDatabase();
        sqlitedatabase.beginTransaction();
        String as[] = new String[2];
        as[0] = s;
        as[1] = Integer.toString(i);
        sqlitedatabase.delete("locksettings", "name=? AND user=?", as);
        sqlitedatabase.insert("locksettings", null, contentvalues);
        sqlitedatabase.setTransactionSuccessful();
        sqlitedatabase.endTransaction();
        return;
        Exception exception;
        exception;
        sqlitedatabase.endTransaction();
        throw exception;
    }

    public boolean checkPassword(byte abyte0[], int i) throws RemoteException {
        boolean flag;
        flag = true;
        checkPasswordReadPermission(i);
        boolean flag1;
        RandomAccessFile randomaccessfile = new RandomAccessFile(getLockPasswordFilename(i), "r");
        byte abyte1[] = new byte[(int)randomaccessfile.length()];
        int j = randomaccessfile.read(abyte1, 0, abyte1.length);
        randomaccessfile.close();
        if(j <= 0)
            break MISSING_BLOCK_LABEL_140;
        flag1 = Arrays.equals(abyte1, passwordToHash(abyte1, abyte0));
        flag = flag1;
        break MISSING_BLOCK_LABEL_140;
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        Slog.e("LockSettingsService", (new StringBuilder()).append("Cannot read file ").append(filenotfoundexception).toString());
        break MISSING_BLOCK_LABEL_140;
        IOException ioexception;
        ioexception;
        Slog.e("LockSettingsService", (new StringBuilder()).append("Cannot read file ").append(ioexception).toString());
        return flag;
    }

    public boolean checkPattern(byte abyte0[], int i) throws RemoteException {
        boolean flag;
        flag = true;
        checkPasswordReadPermission(i);
        boolean flag1;
        RandomAccessFile randomaccessfile = new RandomAccessFile(getLockPatternFilename(i), "r");
        byte abyte1[] = new byte[(int)randomaccessfile.length()];
        int j = randomaccessfile.read(abyte1, 0, abyte1.length);
        randomaccessfile.close();
        if(j <= 0)
            break MISSING_BLOCK_LABEL_134;
        flag1 = Arrays.equals(abyte1, abyte0);
        flag = flag1;
        break MISSING_BLOCK_LABEL_134;
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        Slog.e("LockSettingsService", (new StringBuilder()).append("Cannot read file ").append(filenotfoundexception).toString());
        break MISSING_BLOCK_LABEL_134;
        IOException ioexception;
        ioexception;
        Slog.e("LockSettingsService", (new StringBuilder()).append("Cannot read file ").append(ioexception).toString());
        return flag;
    }

    public boolean getBoolean(String s, boolean flag, int i) throws RemoteException {
        String s1 = readFromDb(s, null, i);
        if(!TextUtils.isEmpty(s1))
            if(s1.equals("1") || s1.equals("true"))
                flag = true;
            else
                flag = false;
        return flag;
    }

    public long getLong(String s, long l, int i) throws RemoteException {
        String s1 = readFromDb(s, null, i);
        if(!TextUtils.isEmpty(s1))
            l = Long.parseLong(s1);
        return l;
    }

    public String getString(String s, String s1, int i) throws RemoteException {
        return readFromDb(s, s1, i);
    }

    public boolean havePassword(int i) throws RemoteException {
        boolean flag;
        if((new File(getLockPasswordFilename(i))).length() > 0L)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean havePattern(int i) throws RemoteException {
        boolean flag;
        if((new File(getLockPatternFilename(i))).length() > 0L)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void removeUser(int i) {
        SQLiteDatabase sqlitedatabase;
        checkWritePermission(i);
        sqlitedatabase = mOpenHelper.getWritableDatabase();
        File file = new File(getLockPasswordFilename(i));
        if(file.exists())
            file.delete();
        File file1 = new File(getLockPatternFilename(i));
        if(file1.exists())
            file1.delete();
        sqlitedatabase.beginTransaction();
        sqlitedatabase.delete("locksettings", (new StringBuilder()).append("user='").append(i).append("'").toString(), null);
        sqlitedatabase.setTransactionSuccessful();
        sqlitedatabase.endTransaction();
        return;
        Exception exception;
        exception;
        sqlitedatabase.endTransaction();
        throw exception;
    }

    public void setBoolean(String s, boolean flag, int i) throws RemoteException {
        checkWritePermission(i);
        String s1;
        if(flag)
            s1 = "1";
        else
            s1 = "0";
        writeToDb(s, s1, i);
    }

    public void setLockPassword(byte abyte0[], int i) throws RemoteException {
        checkWritePermission(i);
        writeFile(getLockPasswordFilename(i), abyte0);
    }

    public void setLockPattern(byte abyte0[], int i) throws RemoteException {
        checkWritePermission(i);
        writeFile(getLockPatternFilename(i), abyte0);
    }

    public void setLong(String s, long l, int i) throws RemoteException {
        checkWritePermission(i);
        writeToDb(s, Long.toString(l), i);
    }

    public void setString(String s, String s1, int i) throws RemoteException {
        checkWritePermission(i);
        writeToDb(s, s1, i);
    }

    public void systemReady() {
        migrateOldData();
    }

    private static final String COLUMNS_FOR_QUERY[];
    private static final String COLUMN_KEY = "name";
    private static final String COLUMN_USERID = "user";
    private static final String COLUMN_VALUE = "value";
    private static final String LOCK_PASSWORD_FILE = "password.key";
    private static final String LOCK_PATTERN_FILE = "gesture.key";
    private static final String SYSTEM_DIRECTORY = "/system/";
    private static final String TABLE = "locksettings";
    private static final String TAG = "LockSettingsService";
    private static final String VALID_SETTINGS[];
    private final Context mContext;
    private final DatabaseHelper mOpenHelper;

    static  {
        String as[] = new String[1];
        as[0] = "value";
        COLUMNS_FOR_QUERY = as;
        String as1[] = new String[16];
        as1[0] = "lockscreen.lockedoutpermanently";
        as1[1] = "lockscreen.lockoutattemptdeadline";
        as1[2] = "lockscreen.patterneverchosen";
        as1[3] = "lockscreen.password_type";
        as1[4] = "lockscreen.password_type_alternate";
        as1[5] = "lockscreen.password_salt";
        as1[6] = "lockscreen.disabled";
        as1[7] = "lockscreen.options";
        as1[8] = "lockscreen.biometric_weak_fallback";
        as1[9] = "lockscreen.biometricweakeverchosen";
        as1[10] = "lockscreen.power_button_instantly_locks";
        as1[11] = "lockscreen.passwordhistory";
        as1[12] = "lock_pattern_autolock";
        as1[13] = "lock_biometric_weak_flags";
        as1[14] = "lock_pattern_visible_pattern";
        as1[15] = "lock_pattern_tactile_feedback_enabled";
        VALID_SETTINGS = as1;
    }
}
