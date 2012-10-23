// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database.sqlite;

import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SQLiteDatabaseConfiguration {

    public SQLiteDatabaseConfiguration(SQLiteDatabaseConfiguration sqlitedatabaseconfiguration) {
        customFunctions = new ArrayList();
        if(sqlitedatabaseconfiguration == null) {
            throw new IllegalArgumentException("other must not be null.");
        } else {
            path = sqlitedatabaseconfiguration.path;
            label = sqlitedatabaseconfiguration.label;
            updateParametersFrom(sqlitedatabaseconfiguration);
            return;
        }
    }

    public SQLiteDatabaseConfiguration(String s, int i) {
        customFunctions = new ArrayList();
        if(s == null) {
            throw new IllegalArgumentException("path must not be null.");
        } else {
            path = s;
            label = stripPathForLogs(s);
            openFlags = i;
            maxSqlCacheSize = 25;
            locale = Locale.getDefault();
            return;
        }
    }

    private static String stripPathForLogs(String s) {
        if(s.indexOf('@') != -1)
            s = EMAIL_IN_DB_PATTERN.matcher(s).replaceAll("XX@YY");
        return s;
    }

    public boolean isInMemoryDb() {
        return path.equalsIgnoreCase(":memory:");
    }

    public void updateParametersFrom(SQLiteDatabaseConfiguration sqlitedatabaseconfiguration) {
        if(sqlitedatabaseconfiguration == null)
            throw new IllegalArgumentException("other must not be null.");
        if(!path.equals(sqlitedatabaseconfiguration.path)) {
            throw new IllegalArgumentException("other configuration must refer to the same database.");
        } else {
            openFlags = sqlitedatabaseconfiguration.openFlags;
            maxSqlCacheSize = sqlitedatabaseconfiguration.maxSqlCacheSize;
            locale = sqlitedatabaseconfiguration.locale;
            foreignKeyConstraintsEnabled = sqlitedatabaseconfiguration.foreignKeyConstraintsEnabled;
            customFunctions.clear();
            customFunctions.addAll(sqlitedatabaseconfiguration.customFunctions);
            return;
        }
    }

    private static final Pattern EMAIL_IN_DB_PATTERN = Pattern.compile("[\\w\\.\\-]+@[\\w\\.\\-]+");
    public static final String MEMORY_DB_PATH = ":memory:";
    public final ArrayList customFunctions;
    public boolean foreignKeyConstraintsEnabled;
    public final String label;
    public Locale locale;
    public int maxSqlCacheSize;
    public int openFlags;
    public final String path;

}
