// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database.sqlite;

import android.os.Build;
import android.os.SystemProperties;
import android.util.Log;
import android.util.Printer;
import java.util.ArrayList;

// Referenced classes of package android.database.sqlite:
//            SQLiteDatabase

public final class SQLiteDebug {
    public static class DbStats {

        public String cache;
        public String dbName;
        public long dbSize;
        public int lookaside;
        public long pageSize;

        public DbStats(String s, long l, long l1, int i, int j, 
                int k, int i1) {
            dbName = s;
            pageSize = l1 / 1024L;
            dbSize = (l * l1) / 1024L;
            lookaside = i;
            cache = (new StringBuilder()).append(j).append("/").append(k).append("/").append(i1).toString();
        }
    }

    public static class PagerStats {

        public ArrayList dbStats;
        public int largestMemAlloc;
        public int memoryUsed;
        public int pageCacheOverflow;

        public PagerStats() {
        }
    }


    private SQLiteDebug() {
    }

    public static void dump(Printer printer, String as[]) {
        boolean flag = false;
        int i = as.length;
        for(int j = 0; j < i; j++)
            if(as[j].equals("-v"))
                flag = true;

        SQLiteDatabase.dumpAll(printer, flag);
    }

    public static PagerStats getDatabaseInfo() {
        PagerStats pagerstats = new PagerStats();
        nativeGetPagerStats(pagerstats);
        pagerstats.dbStats = SQLiteDatabase.getDbStats();
        return pagerstats;
    }

    private static native void nativeGetPagerStats(PagerStats pagerstats);

    public static final boolean shouldLogSlowQuery(long l) {
        int i = SystemProperties.getInt("db.log.slow_query_threshold", -1);
        boolean flag;
        if(i >= 0 && l >= (long)i)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static final boolean DEBUG_LOG_SLOW_QUERIES;
    public static final boolean DEBUG_SQL_LOG = Log.isLoggable("SQLiteLog", 2);
    public static final boolean DEBUG_SQL_STATEMENTS = Log.isLoggable("SQLiteStatements", 2);
    public static final boolean DEBUG_SQL_TIME = Log.isLoggable("SQLiteTime", 2);

    static  {
        DEBUG_LOG_SLOW_QUERIES = Build.IS_DEBUGGABLE;
    }
}
