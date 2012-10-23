// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database.sqlite;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Log;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package android.database.sqlite:
//            SQLiteDatabase, SQLiteSession

public class SQLiteQueryBuilder {

    public SQLiteQueryBuilder() {
        mProjectionMap = null;
        mTables = "";
        mWhereClause = null;
        mDistinct = false;
        mFactory = null;
    }

    private static void appendClause(StringBuilder stringbuilder, String s, String s1) {
        if(!TextUtils.isEmpty(s1)) {
            stringbuilder.append(s);
            stringbuilder.append(s1);
        }
    }

    public static void appendColumns(StringBuilder stringbuilder, String as[]) {
        int i = as.length;
        for(int j = 0; j < i; j++) {
            String s = as[j];
            if(s == null)
                continue;
            if(j > 0)
                stringbuilder.append(", ");
            stringbuilder.append(s);
        }

        stringbuilder.append(' ');
    }

    public static String buildQueryString(boolean flag, String s, String as[], String s1, String s2, String s3, String s4, String s5) {
        if(TextUtils.isEmpty(s2) && !TextUtils.isEmpty(s3))
            throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
        if(!TextUtils.isEmpty(s5) && !sLimitPattern.matcher(s5).matches())
            throw new IllegalArgumentException((new StringBuilder()).append("invalid LIMIT clauses:").append(s5).toString());
        StringBuilder stringbuilder = new StringBuilder(120);
        stringbuilder.append("SELECT ");
        if(flag)
            stringbuilder.append("DISTINCT ");
        if(as != null && as.length != 0)
            appendColumns(stringbuilder, as);
        else
            stringbuilder.append("* ");
        stringbuilder.append("FROM ");
        stringbuilder.append(s);
        appendClause(stringbuilder, " WHERE ", s1);
        appendClause(stringbuilder, " GROUP BY ", s2);
        appendClause(stringbuilder, " HAVING ", s3);
        appendClause(stringbuilder, " ORDER BY ", s4);
        appendClause(stringbuilder, " LIMIT ", s5);
        return stringbuilder.toString();
    }

    private String[] computeProjection(String as[]) {
        if(as == null || as.length <= 0) goto _L2; else goto _L1
_L1:
        String as1[];
        if(mProjectionMap != null) {
            as1 = new String[as.length];
            int k = as.length;
            int l = 0;
            while(l < k)  {
                String s = as[l];
                String s1 = (String)mProjectionMap.get(s);
                if(s1 != null)
                    as1[l] = s1;
                else
                if(!mStrict && (s.contains(" AS ") || s.contains(" as ")))
                    as1[l] = s;
                else
                    throw new IllegalArgumentException((new StringBuilder()).append("Invalid column ").append(as[l]).toString());
                l++;
            }
        } else {
            as1 = as;
        }
_L4:
        return as1;
_L2:
        if(mProjectionMap != null) {
            Set set = mProjectionMap.entrySet();
            as1 = new String[set.size()];
            Iterator iterator = set.iterator();
            int i = 0;
            do {
                java.util.Map.Entry entry;
                do {
                    if(!iterator.hasNext())
                        continue; /* Loop/switch isn't completed */
                    entry = (java.util.Map.Entry)iterator.next();
                } while(((String)entry.getKey()).equals("_count"));
                int j = i + 1;
                as1[i] = (String)entry.getValue();
                i = j;
            } while(true);
        }
        as1 = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void validateQuerySql(SQLiteDatabase sqlitedatabase, String s, CancellationSignal cancellationsignal) {
        sqlitedatabase.getThreadSession().prepare(s, sqlitedatabase.getThreadDefaultConnectionFlags(true), cancellationsignal, null);
    }

    public void appendWhere(CharSequence charsequence) {
        if(mWhereClause == null)
            mWhereClause = new StringBuilder(16 + charsequence.length());
        if(mWhereClause.length() == 0)
            mWhereClause.append('(');
        mWhereClause.append(charsequence);
    }

    public void appendWhereEscapeString(String s) {
        if(mWhereClause == null)
            mWhereClause = new StringBuilder(16 + s.length());
        if(mWhereClause.length() == 0)
            mWhereClause.append('(');
        DatabaseUtils.appendEscapedSQLString(mWhereClause, s);
    }

    public String buildQuery(String as[], String s, String s1, String s2, String s3, String s4) {
        String as1[] = computeProjection(as);
        StringBuilder stringbuilder = new StringBuilder();
        boolean flag;
        if(mWhereClause != null && mWhereClause.length() > 0)
            flag = true;
        else
            flag = false;
        if(flag) {
            stringbuilder.append(mWhereClause.toString());
            stringbuilder.append(')');
        }
        if(s != null && s.length() > 0) {
            if(flag)
                stringbuilder.append(" AND ");
            stringbuilder.append('(');
            stringbuilder.append(s);
            stringbuilder.append(')');
        }
        return buildQueryString(mDistinct, mTables, as1, stringbuilder.toString(), s1, s2, s3, s4);
    }

    public String buildQuery(String as[], String s, String as1[], String s1, String s2, String s3, String s4) {
        return buildQuery(as, s, s1, s2, s3, s4);
    }

    public String buildUnionQuery(String as[], String s, String s1) {
        StringBuilder stringbuilder = new StringBuilder(128);
        int i = as.length;
        String s2;
        int j;
        if(mDistinct)
            s2 = " UNION ";
        else
            s2 = " UNION ALL ";
        for(j = 0; j < i; j++) {
            if(j > 0)
                stringbuilder.append(s2);
            stringbuilder.append(as[j]);
        }

        appendClause(stringbuilder, " ORDER BY ", s);
        appendClause(stringbuilder, " LIMIT ", s1);
        return stringbuilder.toString();
    }

    public String buildUnionSubQuery(String s, String as[], Set set, int i, String s1, String s2, String s3, 
            String s4) {
        int j = as.length;
        String as1[] = new String[j];
        int k = 0;
        while(k < j)  {
            String s5 = as[k];
            if(s5.equals(s))
                as1[k] = (new StringBuilder()).append("'").append(s1).append("' AS ").append(s).toString();
            else
            if(k <= i || set.contains(s5))
                as1[k] = s5;
            else
                as1[k] = (new StringBuilder()).append("NULL AS ").append(s5).toString();
            k++;
        }
        return buildQuery(as1, s2, s3, s4, null, null);
    }

    public String buildUnionSubQuery(String s, String as[], Set set, int i, String s1, String s2, String as1[], 
            String s3, String s4) {
        return buildUnionSubQuery(s, as, set, i, s1, s2, s3, s4);
    }

    public String getTables() {
        return mTables;
    }

    public Cursor query(SQLiteDatabase sqlitedatabase, String as[], String s, String as1[], String s1, String s2, String s3) {
        return query(sqlitedatabase, as, s, as1, s1, s2, s3, null, null);
    }

    public Cursor query(SQLiteDatabase sqlitedatabase, String as[], String s, String as1[], String s1, String s2, String s3, 
            String s4) {
        return query(sqlitedatabase, as, s, as1, s1, s2, s3, s4, null);
    }

    public Cursor query(SQLiteDatabase sqlitedatabase, String as[], String s, String as1[], String s1, String s2, String s3, 
            String s4, CancellationSignal cancellationsignal) {
        Cursor cursor;
        if(mTables == null) {
            cursor = null;
        } else {
            if(mStrict && s != null && s.length() > 0)
                validateQuerySql(sqlitedatabase, buildQuery(as, (new StringBuilder()).append("(").append(s).append(")").toString(), s1, s2, s3, s4), cancellationsignal);
            String s5 = buildQuery(as, s, s1, s2, s3, s4);
            if(Log.isLoggable("SQLiteQueryBuilder", 3))
                Log.d("SQLiteQueryBuilder", (new StringBuilder()).append("Performing query: ").append(s5).toString());
            cursor = sqlitedatabase.rawQueryWithFactory(mFactory, s5, as1, SQLiteDatabase.findEditTable(mTables), cancellationsignal);
        }
        return cursor;
    }

    public void setCursorFactory(SQLiteDatabase.CursorFactory cursorfactory) {
        mFactory = cursorfactory;
    }

    public void setDistinct(boolean flag) {
        mDistinct = flag;
    }

    public void setProjectionMap(Map map) {
        mProjectionMap = map;
    }

    public void setStrict(boolean flag) {
        mStrict = flag;
    }

    public void setTables(String s) {
        mTables = s;
    }

    private static final String TAG = "SQLiteQueryBuilder";
    private static final Pattern sLimitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    private boolean mDistinct;
    private SQLiteDatabase.CursorFactory mFactory;
    private Map mProjectionMap;
    private boolean mStrict;
    private String mTables;
    private StringBuilder mWhereClause;

}
