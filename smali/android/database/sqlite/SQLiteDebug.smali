.class public final Landroid/database/sqlite/SQLiteDebug;
.super Ljava/lang/Object;
.source "SQLiteDebug.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/database/sqlite/SQLiteDebug$DbStats;,
        Landroid/database/sqlite/SQLiteDebug$PagerStats;
    }
.end annotation


# static fields
.field public static final DEBUG_LOG_SLOW_QUERIES:Z

.field public static final DEBUG_SQL_LOG:Z

.field public static final DEBUG_SQL_STATEMENTS:Z

.field public static final DEBUG_SQL_TIME:Z


# direct methods
.method static constructor <clinit>()V
    .registers 2

    .prologue
    const/4 v1, 0x2

    const-string v0, "SQLiteLog"

    invoke-static {v0, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    sput-boolean v0, Landroid/database/sqlite/SQLiteDebug;->DEBUG_SQL_LOG:Z

    const-string v0, "SQLiteStatements"

    invoke-static {v0, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    sput-boolean v0, Landroid/database/sqlite/SQLiteDebug;->DEBUG_SQL_STATEMENTS:Z

    const-string v0, "SQLiteTime"

    invoke-static {v0, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    sput-boolean v0, Landroid/database/sqlite/SQLiteDebug;->DEBUG_SQL_TIME:Z

    sget-boolean v0, Landroid/os/Build;->IS_DEBUGGABLE:Z

    sput-boolean v0, Landroid/database/sqlite/SQLiteDebug;->DEBUG_LOG_SLOW_QUERIES:Z

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static dump(Landroid/util/Printer;[Ljava/lang/String;)V
    .registers 8
    .parameter "printer"
    .parameter "args"

    .prologue
    const/4 v4, 0x0

    .local v4, verbose:Z
    move-object v1, p1

    .local v1, arr$:[Ljava/lang/String;
    array-length v3, v1

    .local v3, len$:I
    const/4 v2, 0x0

    .local v2, i$:I
    :goto_4
    if-ge v2, v3, :cond_14

    aget-object v0, v1, v2

    .local v0, arg:Ljava/lang/String;
    const-string v5, "-v"

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_11

    const/4 v4, 0x1

    :cond_11
    add-int/lit8 v2, v2, 0x1

    goto :goto_4

    .end local v0           #arg:Ljava/lang/String;
    :cond_14
    invoke-static {p0, v4}, Landroid/database/sqlite/SQLiteDatabase;->dumpAll(Landroid/util/Printer;Z)V

    return-void
.end method

.method public static getDatabaseInfo()Landroid/database/sqlite/SQLiteDebug$PagerStats;
    .registers 2

    .prologue
    new-instance v0, Landroid/database/sqlite/SQLiteDebug$PagerStats;

    invoke-direct {v0}, Landroid/database/sqlite/SQLiteDebug$PagerStats;-><init>()V

    .local v0, stats:Landroid/database/sqlite/SQLiteDebug$PagerStats;
    invoke-static {v0}, Landroid/database/sqlite/SQLiteDebug;->nativeGetPagerStats(Landroid/database/sqlite/SQLiteDebug$PagerStats;)V

    invoke-static {}, Landroid/database/sqlite/SQLiteDatabase;->getDbStats()Ljava/util/ArrayList;

    move-result-object v1

    iput-object v1, v0, Landroid/database/sqlite/SQLiteDebug$PagerStats;->dbStats:Ljava/util/ArrayList;

    return-object v0
.end method

.method private static native nativeGetPagerStats(Landroid/database/sqlite/SQLiteDebug$PagerStats;)V
.end method

.method public static final shouldLogSlowQuery(J)Z
    .registers 5
    .parameter "elapsedTimeMillis"

    .prologue
    const-string v1, "db.log.slow_query_threshold"

    const/4 v2, -0x1

    invoke-static {v1, v2}, Landroid/os/SystemProperties;->getInt(Ljava/lang/String;I)I

    move-result v0

    .local v0, slowQueryMillis:I
    if-ltz v0, :cond_10

    int-to-long v1, v0

    cmp-long v1, p0, v1

    if-ltz v1, :cond_10

    const/4 v1, 0x1

    :goto_f
    return v1

    :cond_10
    const/4 v1, 0x0

    goto :goto_f
.end method
