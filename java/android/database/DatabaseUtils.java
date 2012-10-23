// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database;

import android.content.*;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteProgram;
import android.database.sqlite.SQLiteStatement;
import android.os.*;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.CollationKey;
import java.text.Collator;
import java.util.*;
import org.apache.commons.codec.binary.Hex;

// Referenced classes of package android.database:
//            Cursor, CursorWindow, AbstractWindowedCursor, SQLException

public class DatabaseUtils {
    public static class InsertHelper {

        private void buildSQL() throws SQLException {
            StringBuilder stringbuilder;
            StringBuilder stringbuilder1;
            int i;
            Cursor cursor;
            stringbuilder = new StringBuilder(128);
            stringbuilder.append("INSERT INTO ");
            stringbuilder.append(mTableName);
            stringbuilder.append(" (");
            stringbuilder1 = new StringBuilder(128);
            stringbuilder1.append("VALUES (");
            i = 1;
            cursor = null;
            cursor = mDb.rawQuery((new StringBuilder()).append("PRAGMA table_info(").append(mTableName).append(")").toString(), null);
            mColumns = new HashMap(cursor.getCount());
_L5:
            String s2;
            String s3;
            if(!cursor.moveToNext())
                break MISSING_BLOCK_LABEL_305;
            String s = cursor.getString(1);
            String s1 = cursor.getString(4);
            mColumns.put(s, Integer.valueOf(i));
            stringbuilder.append("'");
            stringbuilder.append(s);
            stringbuilder.append("'");
            if(s1 == null) {
                stringbuilder1.append("?");
            } else {
                stringbuilder1.append("COALESCE(?, ");
                stringbuilder1.append(s1);
                stringbuilder1.append(")");
            }
            if(i != cursor.getCount()) goto _L2; else goto _L1
_L1:
            s2 = ") ";
_L6:
            stringbuilder.append(s2);
            if(i != cursor.getCount()) goto _L4; else goto _L3
_L3:
            s3 = ");";
_L7:
            stringbuilder1.append(s3);
            i++;
              goto _L5
            Exception exception;
            exception;
            if(cursor != null)
                cursor.close();
            throw exception;
_L2:
            s2 = ", ";
              goto _L6
_L4:
            s3 = ", ";
              goto _L7
            if(cursor != null)
                cursor.close();
            stringbuilder.append(stringbuilder1);
            mInsertSQL = stringbuilder.toString();
            return;
              goto _L5
        }

        private SQLiteStatement getStatement(boolean flag) throws SQLException {
            SQLiteStatement sqlitestatement;
            if(flag) {
                if(mReplaceStatement == null) {
                    if(mInsertSQL == null)
                        buildSQL();
                    String s = (new StringBuilder()).append("INSERT OR REPLACE").append(mInsertSQL.substring(6)).toString();
                    mReplaceStatement = mDb.compileStatement(s);
                }
                sqlitestatement = mReplaceStatement;
            } else {
                if(mInsertStatement == null) {
                    if(mInsertSQL == null)
                        buildSQL();
                    mInsertStatement = mDb.compileStatement(mInsertSQL);
                }
                sqlitestatement = mInsertStatement;
            }
            return sqlitestatement;
        }

        /**
         * @deprecated Method insertInternal is deprecated
         */

        private long insertInternal(ContentValues contentvalues, boolean flag) {
            this;
            JVM INSTR monitorenter ;
            SQLiteStatement sqlitestatement;
            sqlitestatement = getStatement(flag);
            sqlitestatement.clearBindings();
            java.util.Map.Entry entry;
            for(Iterator iterator = contentvalues.valueSet().iterator(); iterator.hasNext(); DatabaseUtils.bindObjectToProgram(sqlitestatement, getColumnIndex((String)entry.getKey()), entry.getValue()))
                entry = (java.util.Map.Entry)iterator.next();

              goto _L1
            SQLException sqlexception;
            sqlexception;
            Log.e("DatabaseUtils", (new StringBuilder()).append("Error inserting ").append(contentvalues).append(" into table  ").append(mTableName).toString(), sqlexception);
            long l = -1L;
_L3:
            this;
            JVM INSTR monitorexit ;
            return l;
_L1:
            long l1 = sqlitestatement.executeInsert();
            l = l1;
            if(true) goto _L3; else goto _L2
_L2:
            Exception exception;
            exception;
            throw exception;
        }

        public void bind(int i, double d) {
            mPreparedStatement.bindDouble(i, d);
        }

        public void bind(int i, float f) {
            mPreparedStatement.bindDouble(i, f);
        }

        public void bind(int i, int j) {
            mPreparedStatement.bindLong(i, j);
        }

        public void bind(int i, long l) {
            mPreparedStatement.bindLong(i, l);
        }

        public void bind(int i, String s) {
            if(s == null)
                mPreparedStatement.bindNull(i);
            else
                mPreparedStatement.bindString(i, s);
        }

        public void bind(int i, boolean flag) {
            SQLiteStatement sqlitestatement = mPreparedStatement;
            long l;
            if(flag)
                l = 1L;
            else
                l = 0L;
            sqlitestatement.bindLong(i, l);
        }

        public void bind(int i, byte abyte0[]) {
            if(abyte0 == null)
                mPreparedStatement.bindNull(i);
            else
                mPreparedStatement.bindBlob(i, abyte0);
        }

        public void bindNull(int i) {
            mPreparedStatement.bindNull(i);
        }

        public void close() {
            if(mInsertStatement != null) {
                mInsertStatement.close();
                mInsertStatement = null;
            }
            if(mReplaceStatement != null) {
                mReplaceStatement.close();
                mReplaceStatement = null;
            }
            mInsertSQL = null;
            mColumns = null;
        }

        public long execute() {
            if(mPreparedStatement == null)
                throw new IllegalStateException("you must prepare this inserter before calling execute");
            long l1 = mPreparedStatement.executeInsert();
            long l;
            l = l1;
            mPreparedStatement = null;
_L2:
            return l;
            SQLException sqlexception;
            sqlexception;
            Log.e("DatabaseUtils", (new StringBuilder()).append("Error executing InsertHelper with table ").append(mTableName).toString(), sqlexception);
            l = -1L;
            mPreparedStatement = null;
            if(true) goto _L2; else goto _L1
_L1:
            Exception exception;
            exception;
            mPreparedStatement = null;
            throw exception;
        }

        public int getColumnIndex(String s) {
            getStatement(false);
            Integer integer = (Integer)mColumns.get(s);
            if(integer == null)
                throw new IllegalArgumentException((new StringBuilder()).append("column '").append(s).append("' is invalid").toString());
            else
                return integer.intValue();
        }

        public long insert(ContentValues contentvalues) {
            return insertInternal(contentvalues, false);
        }

        public void prepareForInsert() {
            mPreparedStatement = getStatement(false);
            mPreparedStatement.clearBindings();
        }

        public void prepareForReplace() {
            mPreparedStatement = getStatement(true);
            mPreparedStatement.clearBindings();
        }

        public long replace(ContentValues contentvalues) {
            return insertInternal(contentvalues, true);
        }

        public static final int TABLE_INFO_PRAGMA_COLUMNNAME_INDEX = 1;
        public static final int TABLE_INFO_PRAGMA_DEFAULT_INDEX = 4;
        private HashMap mColumns;
        private final SQLiteDatabase mDb;
        private String mInsertSQL;
        private SQLiteStatement mInsertStatement;
        private SQLiteStatement mPreparedStatement;
        private SQLiteStatement mReplaceStatement;
        private final String mTableName;

        public InsertHelper(SQLiteDatabase sqlitedatabase, String s) {
            mInsertSQL = null;
            mInsertStatement = null;
            mReplaceStatement = null;
            mPreparedStatement = null;
            mDb = sqlitedatabase;
            mTableName = s;
        }
    }


    public DatabaseUtils() {
    }

    public static void appendEscapedSQLString(StringBuilder stringbuilder, String s) {
        stringbuilder.append('\'');
        if(s.indexOf('\'') != -1) {
            int i = s.length();
            for(int j = 0; j < i; j++) {
                char c = s.charAt(j);
                if(c == '\'')
                    stringbuilder.append('\'');
                stringbuilder.append(c);
            }

        } else {
            stringbuilder.append(s);
        }
        stringbuilder.append('\'');
    }

    public static String[] appendSelectionArgs(String as[], String as1[]) {
        String as2[];
        if(as == null || as.length == 0) {
            as2 = as1;
        } else {
            as2 = new String[as.length + as1.length];
            System.arraycopy(as, 0, as2, 0, as.length);
            System.arraycopy(as1, 0, as2, as.length, as1.length);
        }
        return as2;
    }

    public static final void appendValueToSql(StringBuilder stringbuilder, Object obj) {
        if(obj == null)
            stringbuilder.append("NULL");
        else
        if(obj instanceof Boolean) {
            if(((Boolean)obj).booleanValue())
                stringbuilder.append('1');
            else
                stringbuilder.append('0');
        } else {
            appendEscapedSQLString(stringbuilder, obj.toString());
        }
    }

    public static void bindObjectToProgram(SQLiteProgram sqliteprogram, int i, Object obj) {
        if(obj == null)
            sqliteprogram.bindNull(i);
        else
        if((obj instanceof Double) || (obj instanceof Float))
            sqliteprogram.bindDouble(i, ((Number)obj).doubleValue());
        else
        if(obj instanceof Number)
            sqliteprogram.bindLong(i, ((Number)obj).longValue());
        else
        if(obj instanceof Boolean) {
            if(((Boolean)obj).booleanValue())
                sqliteprogram.bindLong(i, 1L);
            else
                sqliteprogram.bindLong(i, 0L);
        } else
        if(obj instanceof byte[])
            sqliteprogram.bindBlob(i, (byte[])(byte[])obj);
        else
            sqliteprogram.bindString(i, obj.toString());
    }

    public static ParcelFileDescriptor blobFileDescriptorForQuery(SQLiteDatabase sqlitedatabase, String s, String as[]) {
        SQLiteStatement sqlitestatement = sqlitedatabase.compileStatement(s);
        ParcelFileDescriptor parcelfiledescriptor = blobFileDescriptorForQuery(sqlitestatement, as);
        sqlitestatement.close();
        return parcelfiledescriptor;
        Exception exception;
        exception;
        sqlitestatement.close();
        throw exception;
    }

    public static ParcelFileDescriptor blobFileDescriptorForQuery(SQLiteStatement sqlitestatement, String as[]) {
        sqlitestatement.bindAllArgsAsStrings(as);
        return sqlitestatement.simpleQueryForBlobFileDescriptor();
    }

    public static String concatenateWhere(String s, String s1) {
        if(!TextUtils.isEmpty(s))
            if(TextUtils.isEmpty(s1))
                s1 = s;
            else
                s1 = (new StringBuilder()).append("(").append(s).append(") AND (").append(s1).append(")").toString();
        return s1;
    }

    public static void createDbFromSqlStatements(Context context, String s, int i, String s1) {
        SQLiteDatabase sqlitedatabase = context.openOrCreateDatabase(s, 0, null);
        String as[] = TextUtils.split(s1, ";\n");
        int j = as.length;
        int k = 0;
        while(k < j)  {
            String s2 = as[k];
            if(!TextUtils.isEmpty(s2))
                sqlitedatabase.execSQL(s2);
            k++;
        }
        sqlitedatabase.setVersion(i);
        sqlitedatabase.close();
    }

    public static void cursorDoubleToContentValues(Cursor cursor, String s, ContentValues contentvalues, String s1) {
        int i = cursor.getColumnIndex(s);
        if(!cursor.isNull(i))
            contentvalues.put(s1, Double.valueOf(cursor.getDouble(i)));
        else
            contentvalues.put(s1, (Double)null);
    }

    public static void cursorDoubleToContentValuesIfPresent(Cursor cursor, ContentValues contentvalues, String s) {
        int i = cursor.getColumnIndex(s);
        if(i != -1 && !cursor.isNull(i))
            contentvalues.put(s, Double.valueOf(cursor.getDouble(i)));
    }

    public static void cursorDoubleToCursorValues(Cursor cursor, String s, ContentValues contentvalues) {
        cursorDoubleToContentValues(cursor, s, contentvalues, s);
    }

    public static void cursorFillWindow(Cursor cursor, int i, CursorWindow cursorwindow) {
        if(i >= 0 && i < cursor.getCount()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int j;
        int k;
        j = cursor.getPosition();
        k = cursor.getColumnCount();
        cursorwindow.clear();
        cursorwindow.setStartPosition(i);
        cursorwindow.setNumColumns(k);
        if(!cursor.moveToPosition(i)) goto _L4; else goto _L3
_L3:
        if(cursorwindow.allocRow()) goto _L5; else goto _L4
_L4:
        cursor.moveToPosition(j);
          goto _L1
_L5:
        int l = 0;
_L15:
        if(l >= k) goto _L7; else goto _L6
_L6:
        cursor.getType(l);
        JVM INSTR tableswitch 0 4: default 128
    //                   0 178
    //                   1 190
    //                   2 210
    //                   3 128
    //                   4 230;
           goto _L8 _L9 _L10 _L11 _L8 _L12
_L8:
        String s = cursor.getString(l);
        byte abyte0[];
        boolean flag;
        if(s != null)
            flag = cursorwindow.putString(s, i, l);
        else
            flag = cursorwindow.putNull(i, l);
        if(flag) goto _L14; else goto _L13
_L13:
        cursorwindow.freeLastRow();
_L7:
        i++;
        if(cursor.moveToNext()) goto _L3; else goto _L4
_L9:
        flag = cursorwindow.putNull(i, l);
        break MISSING_BLOCK_LABEL_154;
_L10:
        flag = cursorwindow.putLong(cursor.getLong(l), i, l);
        break MISSING_BLOCK_LABEL_154;
_L11:
        flag = cursorwindow.putDouble(cursor.getDouble(l), i, l);
        break MISSING_BLOCK_LABEL_154;
_L12:
        abyte0 = cursor.getBlob(l);
        if(abyte0 != null)
            flag = cursorwindow.putBlob(abyte0, i, l);
        else
            flag = cursorwindow.putNull(i, l);
        break MISSING_BLOCK_LABEL_154;
_L14:
        l++;
          goto _L15
    }

    public static void cursorFloatToContentValuesIfPresent(Cursor cursor, ContentValues contentvalues, String s) {
        int i = cursor.getColumnIndex(s);
        if(i != -1 && !cursor.isNull(i))
            contentvalues.put(s, Float.valueOf(cursor.getFloat(i)));
    }

    public static void cursorIntToContentValues(Cursor cursor, String s, ContentValues contentvalues) {
        cursorIntToContentValues(cursor, s, contentvalues, s);
    }

    public static void cursorIntToContentValues(Cursor cursor, String s, ContentValues contentvalues, String s1) {
        int i = cursor.getColumnIndex(s);
        if(!cursor.isNull(i))
            contentvalues.put(s1, Integer.valueOf(cursor.getInt(i)));
        else
            contentvalues.put(s1, (Integer)null);
    }

    public static void cursorIntToContentValuesIfPresent(Cursor cursor, ContentValues contentvalues, String s) {
        int i = cursor.getColumnIndex(s);
        if(i != -1 && !cursor.isNull(i))
            contentvalues.put(s, Integer.valueOf(cursor.getInt(i)));
    }

    public static void cursorLongToContentValues(Cursor cursor, String s, ContentValues contentvalues) {
        cursorLongToContentValues(cursor, s, contentvalues, s);
    }

    public static void cursorLongToContentValues(Cursor cursor, String s, ContentValues contentvalues, String s1) {
        int i = cursor.getColumnIndex(s);
        if(!cursor.isNull(i))
            contentvalues.put(s1, Long.valueOf(cursor.getLong(i)));
        else
            contentvalues.put(s1, (Long)null);
    }

    public static void cursorLongToContentValuesIfPresent(Cursor cursor, ContentValues contentvalues, String s) {
        int i = cursor.getColumnIndex(s);
        if(i != -1 && !cursor.isNull(i))
            contentvalues.put(s, Long.valueOf(cursor.getLong(i)));
    }

    public static int cursorPickFillWindowStartPosition(int i, int j) {
        return Math.max(i - j / 3, 0);
    }

    public static void cursorRowToContentValues(Cursor cursor, ContentValues contentvalues) {
        AbstractWindowedCursor abstractwindowedcursor;
        String as[];
        int i;
        int j;
        if(cursor instanceof AbstractWindowedCursor)
            abstractwindowedcursor = (AbstractWindowedCursor)cursor;
        else
            abstractwindowedcursor = null;
        as = cursor.getColumnNames();
        i = as.length;
        j = 0;
        while(j < i)  {
            if(abstractwindowedcursor != null && abstractwindowedcursor.isBlob(j))
                contentvalues.put(as[j], cursor.getBlob(j));
            else
                contentvalues.put(as[j], cursor.getString(j));
            j++;
        }
    }

    public static void cursorShortToContentValuesIfPresent(Cursor cursor, ContentValues contentvalues, String s) {
        int i = cursor.getColumnIndex(s);
        if(i != -1 && !cursor.isNull(i))
            contentvalues.put(s, Short.valueOf(cursor.getShort(i)));
    }

    public static void cursorStringToContentValues(Cursor cursor, String s, ContentValues contentvalues) {
        cursorStringToContentValues(cursor, s, contentvalues, s);
    }

    public static void cursorStringToContentValues(Cursor cursor, String s, ContentValues contentvalues, String s1) {
        contentvalues.put(s1, cursor.getString(cursor.getColumnIndexOrThrow(s)));
    }

    public static void cursorStringToContentValuesIfPresent(Cursor cursor, ContentValues contentvalues, String s) {
        int i = cursor.getColumnIndex(s);
        if(i != -1 && !cursor.isNull(i))
            contentvalues.put(s, cursor.getString(i));
    }

    public static void cursorStringToInsertHelper(Cursor cursor, String s, InsertHelper inserthelper, int i) {
        inserthelper.bind(i, cursor.getString(cursor.getColumnIndexOrThrow(s)));
    }

    public static void dumpCurrentRow(Cursor cursor) {
        dumpCurrentRow(cursor, System.out);
    }

    public static void dumpCurrentRow(Cursor cursor, PrintStream printstream) {
        String as[];
        int i;
        int j;
        as = cursor.getColumnNames();
        printstream.println((new StringBuilder()).append("").append(cursor.getPosition()).append(" {").toString());
        i = as.length;
        j = 0;
_L2:
        if(j >= i)
            break; /* Loop/switch isn't completed */
        String s1 = cursor.getString(j);
        String s = s1;
_L3:
        printstream.println((new StringBuilder()).append("   ").append(as[j]).append('=').append(s).toString());
        j++;
        if(true) goto _L2; else goto _L1
        SQLiteException sqliteexception;
        sqliteexception;
        s = "<unprintable>";
          goto _L3
_L1:
        printstream.println("}");
        return;
    }

    public static void dumpCurrentRow(Cursor cursor, StringBuilder stringbuilder) {
        String as[];
        int i;
        int j;
        as = cursor.getColumnNames();
        stringbuilder.append((new StringBuilder()).append("").append(cursor.getPosition()).append(" {\n").toString());
        i = as.length;
        j = 0;
_L2:
        if(j >= i)
            break; /* Loop/switch isn't completed */
        String s1 = cursor.getString(j);
        String s = s1;
_L3:
        stringbuilder.append((new StringBuilder()).append("   ").append(as[j]).append('=').append(s).append("\n").toString());
        j++;
        if(true) goto _L2; else goto _L1
        SQLiteException sqliteexception;
        sqliteexception;
        s = "<unprintable>";
          goto _L3
_L1:
        stringbuilder.append("}\n");
        return;
    }

    public static String dumpCurrentRowToString(Cursor cursor) {
        StringBuilder stringbuilder = new StringBuilder();
        dumpCurrentRow(cursor, stringbuilder);
        return stringbuilder.toString();
    }

    public static void dumpCursor(Cursor cursor) {
        dumpCursor(cursor, System.out);
    }

    public static void dumpCursor(Cursor cursor, PrintStream printstream) {
        printstream.println((new StringBuilder()).append(">>>>> Dumping cursor ").append(cursor).toString());
        if(cursor != null) {
            int i = cursor.getPosition();
            cursor.moveToPosition(-1);
            for(; cursor.moveToNext(); dumpCurrentRow(cursor, printstream));
            cursor.moveToPosition(i);
        }
        printstream.println("<<<<<");
    }

    public static void dumpCursor(Cursor cursor, StringBuilder stringbuilder) {
        stringbuilder.append((new StringBuilder()).append(">>>>> Dumping cursor ").append(cursor).append("\n").toString());
        if(cursor != null) {
            int i = cursor.getPosition();
            cursor.moveToPosition(-1);
            for(; cursor.moveToNext(); dumpCurrentRow(cursor, stringbuilder));
            cursor.moveToPosition(i);
        }
        stringbuilder.append("<<<<<\n");
    }

    public static String dumpCursorToString(Cursor cursor) {
        StringBuilder stringbuilder = new StringBuilder();
        dumpCursor(cursor, stringbuilder);
        return stringbuilder.toString();
    }

    public static int findRowIdColumnIndex(String as[]) {
        int i;
        int j;
        i = as.length;
        j = 0;
_L3:
        if(j >= i)
            break MISSING_BLOCK_LABEL_30;
        if(!as[j].equals("_id")) goto _L2; else goto _L1
_L1:
        return j;
_L2:
        j++;
          goto _L3
        j = -1;
          goto _L1
    }

    public static String getCollationKey(String s) {
        byte abyte0[] = getCollationKeyInBytes(s);
        String s1;
        try {
            s1 = new String(abyte0, 0, getKeyLen(abyte0), "ISO8859_1");
        }
        catch(Exception exception) {
            s1 = "";
        }
        return s1;
    }

    private static byte[] getCollationKeyInBytes(String s) {
        if(mColl == null) {
            mColl = Collator.getInstance();
            mColl.setStrength(0);
        }
        return mColl.getCollationKey(s).toByteArray();
    }

    public static String getHexCollationKey(String s) {
        byte abyte0[] = getCollationKeyInBytes(s);
        return new String(Hex.encodeHex(abyte0), 0, 2 * getKeyLen(abyte0));
    }

    private static int getKeyLen(byte abyte0[]) {
        int i;
        if(abyte0[-1 + abyte0.length] != 0)
            i = abyte0.length;
        else
            i = -1 + abyte0.length;
        return i;
    }

    public static int getSqlStatementType(String s) {
        byte byte0;
        String s1;
        byte0 = 99;
        s1 = s.trim();
        if(s1.length() >= 3) goto _L2; else goto _L1
_L1:
        return byte0;
_L2:
        String s2 = s1.substring(0, 3).toUpperCase(Locale.US);
        if(s2.equals("SEL"))
            byte0 = 1;
        else
        if(s2.equals("INS") || s2.equals("UPD") || s2.equals("REP") || s2.equals("DEL"))
            byte0 = 2;
        else
        if(s2.equals("ATT"))
            byte0 = 3;
        else
        if(s2.equals("COM"))
            byte0 = 5;
        else
        if(s2.equals("END"))
            byte0 = 5;
        else
        if(s2.equals("ROL"))
            byte0 = 6;
        else
        if(s2.equals("BEG"))
            byte0 = 4;
        else
        if(s2.equals("PRA"))
            byte0 = 7;
        else
        if(s2.equals("CRE") || s2.equals("DRO") || s2.equals("ALT"))
            byte0 = 8;
        else
        if(s2.equals("ANA") || s2.equals("DET"))
            byte0 = 9;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static int getTypeOfObject(Object obj) {
        int i;
        if(obj == null)
            i = 0;
        else
        if(obj instanceof byte[])
            i = 4;
        else
        if((obj instanceof Float) || (obj instanceof Double))
            i = 2;
        else
        if((obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte))
            i = 1;
        else
            i = 3;
        return i;
    }

    public static long longForQuery(SQLiteDatabase sqlitedatabase, String s, String as[]) {
        SQLiteStatement sqlitestatement = sqlitedatabase.compileStatement(s);
        long l = longForQuery(sqlitestatement, as);
        sqlitestatement.close();
        return l;
        Exception exception;
        exception;
        sqlitestatement.close();
        throw exception;
    }

    public static long longForQuery(SQLiteStatement sqlitestatement, String as[]) {
        sqlitestatement.bindAllArgsAsStrings(as);
        return sqlitestatement.simpleQueryForLong();
    }

    public static long queryNumEntries(SQLiteDatabase sqlitedatabase, String s) {
        return queryNumEntries(sqlitedatabase, s, null, null);
    }

    public static long queryNumEntries(SQLiteDatabase sqlitedatabase, String s, String s1) {
        return queryNumEntries(sqlitedatabase, s, s1, null);
    }

    public static long queryNumEntries(SQLiteDatabase sqlitedatabase, String s, String s1, String as[]) {
        String s2;
        if(!TextUtils.isEmpty(s1))
            s2 = (new StringBuilder()).append(" where ").append(s1).toString();
        else
            s2 = "";
        return longForQuery(sqlitedatabase, (new StringBuilder()).append("select count(*) from ").append(s).append(s2).toString(), as);
    }

    public static final void readExceptionFromParcel(Parcel parcel) {
        int i = parcel.readExceptionCode();
        if(i != 0)
            readExceptionFromParcel(parcel, parcel.readString(), i);
    }

    private static final void readExceptionFromParcel(Parcel parcel, String s, int i) {
        switch(i) {
        case 10: // '\n'
        default:
            parcel.readException(i, s);
            return;

        case 2: // '\002'
            throw new IllegalArgumentException(s);

        case 3: // '\003'
            throw new UnsupportedOperationException(s);

        case 4: // '\004'
            throw new SQLiteAbortException(s);

        case 5: // '\005'
            throw new SQLiteConstraintException(s);

        case 6: // '\006'
            throw new SQLiteDatabaseCorruptException(s);

        case 7: // '\007'
            throw new SQLiteFullException(s);

        case 8: // '\b'
            throw new SQLiteDiskIOException(s);

        case 9: // '\t'
            throw new SQLiteException(s);

        case 11: // '\013'
            throw new OperationCanceledException(s);
        }
    }

    public static void readExceptionWithFileNotFoundExceptionFromParcel(Parcel parcel) throws FileNotFoundException {
        int i = parcel.readExceptionCode();
        if(i != 0) {
            String s = parcel.readString();
            if(i == 1)
                throw new FileNotFoundException(s);
            readExceptionFromParcel(parcel, s, i);
        }
    }

    public static void readExceptionWithOperationApplicationExceptionFromParcel(Parcel parcel) throws OperationApplicationException {
        int i = parcel.readExceptionCode();
        if(i != 0) {
            String s = parcel.readString();
            if(i == 10)
                throw new OperationApplicationException(s);
            readExceptionFromParcel(parcel, s, i);
        }
    }

    public static String sqlEscapeString(String s) {
        StringBuilder stringbuilder = new StringBuilder();
        appendEscapedSQLString(stringbuilder, s);
        return stringbuilder.toString();
    }

    public static String stringForQuery(SQLiteDatabase sqlitedatabase, String s, String as[]) {
        SQLiteStatement sqlitestatement = sqlitedatabase.compileStatement(s);
        String s1 = stringForQuery(sqlitestatement, as);
        sqlitestatement.close();
        return s1;
        Exception exception;
        exception;
        sqlitestatement.close();
        throw exception;
    }

    public static String stringForQuery(SQLiteStatement sqlitestatement, String as[]) {
        sqlitestatement.bindAllArgsAsStrings(as);
        return sqlitestatement.simpleQueryForString();
    }

    public static final void writeExceptionToParcel(Parcel parcel, Exception exception) {
        boolean flag = true;
        int i;
        if(exception instanceof FileNotFoundException) {
            i = 1;
            flag = false;
        } else
        if(exception instanceof IllegalArgumentException)
            i = 2;
        else
        if(exception instanceof UnsupportedOperationException)
            i = 3;
        else
        if(exception instanceof SQLiteAbortException)
            i = 4;
        else
        if(exception instanceof SQLiteConstraintException)
            i = 5;
        else
        if(exception instanceof SQLiteDatabaseCorruptException)
            i = 6;
        else
        if(exception instanceof SQLiteFullException)
            i = 7;
        else
        if(exception instanceof SQLiteDiskIOException)
            i = 8;
        else
        if(exception instanceof SQLiteException)
            i = 9;
        else
        if(exception instanceof OperationApplicationException) {
            i = 10;
        } else {
label0:
            {
                if(!(exception instanceof OperationCanceledException))
                    break label0;
                i = 11;
                flag = false;
            }
        }
        parcel.writeInt(i);
        parcel.writeString(exception.getMessage());
        if(flag)
            Log.e("DatabaseUtils", "Writing exception to parcel", exception);
_L2:
        return;
        parcel.writeException(exception);
        Log.e("DatabaseUtils", "Writing exception to parcel", exception);
        if(true) goto _L2; else goto _L1
_L1:
    }

    private static final boolean DEBUG = false;
    private static final boolean LOCAL_LOGV = false;
    public static final int STATEMENT_ABORT = 6;
    public static final int STATEMENT_ATTACH = 3;
    public static final int STATEMENT_BEGIN = 4;
    public static final int STATEMENT_COMMIT = 5;
    public static final int STATEMENT_DDL = 8;
    public static final int STATEMENT_OTHER = 99;
    public static final int STATEMENT_PRAGMA = 7;
    public static final int STATEMENT_SELECT = 1;
    public static final int STATEMENT_UNPREPARED = 9;
    public static final int STATEMENT_UPDATE = 2;
    private static final String TAG = "DatabaseUtils";
    private static final String countProjection[];
    private static Collator mColl = null;

    static  {
        String as[] = new String[1];
        as[0] = "count(*)";
        countProjection = as;
    }
}
