.class final Landroid/webkit/WebViewDatabaseClassic;
.super Landroid/webkit/WebViewDatabase;
.source "WebViewDatabaseClassic.java"


# static fields
.field private static final CACHE_DATABASE_FILE:Ljava/lang/String; = "webviewCache.db"

.field private static final DATABASE_FILE:Ljava/lang/String; = "webview.db"

.field private static final DATABASE_VERSION:I = 0xb

.field private static final FORMDATA_NAME_COL:Ljava/lang/String; = "name"

.field private static final FORMDATA_URLID_COL:Ljava/lang/String; = "urlid"

.field private static final FORMDATA_VALUE_COL:Ljava/lang/String; = "value"

.field private static final FORMURL_URL_COL:Ljava/lang/String; = "url"

.field private static final HTTPAUTH_HOST_COL:Ljava/lang/String; = "host"

.field private static final HTTPAUTH_PASSWORD_COL:Ljava/lang/String; = "password"

.field private static final HTTPAUTH_REALM_COL:Ljava/lang/String; = "realm"

.field private static final HTTPAUTH_USERNAME_COL:Ljava/lang/String; = "username"

.field private static final ID_COL:Ljava/lang/String; = "_id"

.field private static final ID_PROJECTION:[Ljava/lang/String; = null

.field private static final LOGTAG:Ljava/lang/String; = "WebViewDatabaseClassic"

.field private static final PASSWORD_HOST_COL:Ljava/lang/String; = "host"

.field private static final PASSWORD_PASSWORD_COL:Ljava/lang/String; = "password"

.field private static final PASSWORD_USERNAME_COL:Ljava/lang/String; = "username"

.field private static final TABLE_FORMDATA_ID:I = 0x2

.field private static final TABLE_FORMURL_ID:I = 0x1

.field private static final TABLE_HTTPAUTH_ID:I = 0x3

.field private static final TABLE_PASSWORD_ID:I

.field private static final mTableNames:[Ljava/lang/String;

.field private static sDatabase:Landroid/database/sqlite/SQLiteDatabase;

.field private static sInstance:Landroid/webkit/WebViewDatabaseClassic;


# instance fields
.field private final mFormLock:Ljava/lang/Object;

.field private final mHttpAuthLock:Ljava/lang/Object;

.field private mInitialized:Z

.field private final mPasswordLock:Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .registers 5

    .prologue
    const/4 v0, 0x0

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 54
    sput-object v0, Landroid/webkit/WebViewDatabaseClassic;->sInstance:Landroid/webkit/WebViewDatabaseClassic;

    .line 56
    sput-object v0, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    .line 63
    const/4 v0, 0x4

    new-array v0, v0, [Ljava/lang/String;

    const-string/jumbo v1, "password"

    aput-object v1, v0, v3

    const-string v1, "formurl"

    aput-object v1, v0, v4

    const/4 v1, 0x2

    const-string v2, "formdata"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "httpauth"

    aput-object v2, v0, v1

    sput-object v0, Landroid/webkit/WebViewDatabaseClassic;->mTableNames:[Ljava/lang/String;

    .line 76
    new-array v0, v4, [Ljava/lang/String;

    const-string v1, "_id"

    aput-object v1, v0, v3

    sput-object v0, Landroid/webkit/WebViewDatabaseClassic;->ID_PROJECTION:[Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Landroid/content/Context;)V
    .registers 3
    .parameter "context"

    .prologue
    .line 102
    invoke-direct {p0}, Landroid/webkit/WebViewDatabase;-><init>()V

    .line 59
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Landroid/webkit/WebViewDatabaseClassic;->mPasswordLock:Ljava/lang/Object;

    .line 60
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Landroid/webkit/WebViewDatabaseClassic;->mFormLock:Ljava/lang/Object;

    .line 61
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Landroid/webkit/WebViewDatabaseClassic;->mHttpAuthLock:Ljava/lang/Object;

    .line 100
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/webkit/WebViewDatabaseClassic;->mInitialized:Z

    .line 103
    new-instance v0, Landroid/webkit/WebViewDatabaseClassic$1;

    invoke-direct {v0, p0, p1}, Landroid/webkit/WebViewDatabaseClassic$1;-><init>(Landroid/webkit/WebViewDatabaseClassic;Landroid/content/Context;)V

    invoke-virtual {v0}, Landroid/webkit/WebViewDatabaseClassic$1;->start()V

    .line 111
    return-void
.end method

.method static synthetic access$000(Landroid/webkit/WebViewDatabaseClassic;Landroid/content/Context;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 35
    invoke-direct {p0, p1}, Landroid/webkit/WebViewDatabaseClassic;->init(Landroid/content/Context;)V

    return-void
.end method

.method private checkInitialized()Z
    .registers 4

    .prologue
    .line 273
    monitor-enter p0

    .line 274
    :goto_1
    :try_start_1
    iget-boolean v1, p0, Landroid/webkit/WebViewDatabaseClassic;->mInitialized:Z
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_1b

    if-nez v1, :cond_1e

    .line 276
    :try_start_5
    invoke-virtual {p0}, Ljava/lang/Object;->wait()V
    :try_end_8
    .catchall {:try_start_5 .. :try_end_8} :catchall_1b
    .catch Ljava/lang/InterruptedException; {:try_start_5 .. :try_end_8} :catch_9

    goto :goto_1

    .line 277
    :catch_9
    move-exception v0

    .line 278
    .local v0, e:Ljava/lang/InterruptedException;
    :try_start_a
    const-string v1, "WebViewDatabaseClassic"

    const-string v2, "Caught exception while checking initialization"

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 280
    const-string v1, "WebViewDatabaseClassic"

    invoke-static {v0}, Landroid/util/Log;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 283
    .end local v0           #e:Ljava/lang/InterruptedException;
    :catchall_1b
    move-exception v1

    monitor-exit p0
    :try_end_1d
    .catchall {:try_start_a .. :try_end_1d} :catchall_1b

    throw v1

    :cond_1e
    :try_start_1e
    monitor-exit p0
    :try_end_1f
    .catchall {:try_start_1e .. :try_end_1f} :catchall_1b

    .line 284
    sget-object v1, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    if-eqz v1, :cond_25

    const/4 v1, 0x1

    :goto_24
    return v1

    :cond_25
    const/4 v1, 0x0

    goto :goto_24
.end method

.method public static declared-synchronized getInstance(Landroid/content/Context;)Landroid/webkit/WebViewDatabaseClassic;
    .registers 3
    .parameter "context"

    .prologue
    .line 114
    const-class v1, Landroid/webkit/WebViewDatabaseClassic;

    monitor-enter v1

    :try_start_3
    sget-object v0, Landroid/webkit/WebViewDatabaseClassic;->sInstance:Landroid/webkit/WebViewDatabaseClassic;

    if-nez v0, :cond_e

    .line 115
    new-instance v0, Landroid/webkit/WebViewDatabaseClassic;

    invoke-direct {v0, p0}, Landroid/webkit/WebViewDatabaseClassic;-><init>(Landroid/content/Context;)V

    sput-object v0, Landroid/webkit/WebViewDatabaseClassic;->sInstance:Landroid/webkit/WebViewDatabaseClassic;

    .line 117
    :cond_e
    sget-object v0, Landroid/webkit/WebViewDatabaseClassic;->sInstance:Landroid/webkit/WebViewDatabaseClassic;
    :try_end_10
    .catchall {:try_start_3 .. :try_end_10} :catchall_12

    monitor-exit v1

    return-object v0

    .line 114
    :catchall_12
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private hasEntries(I)Z
    .registers 15
    .parameter "tableId"

    .prologue
    const/4 v11, 0x1

    const/4 v12, 0x0

    .line 288
    invoke-direct {p0}, Landroid/webkit/WebViewDatabaseClassic;->checkInitialized()Z

    move-result v0

    if-nez v0, :cond_9

    .line 303
    :goto_8
    return v12

    .line 292
    :cond_9
    const/4 v8, 0x0

    .line 293
    .local v8, cursor:Landroid/database/Cursor;
    const/4 v10, 0x0

    .line 295
    .local v10, ret:Z
    :try_start_b
    sget-object v0, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    sget-object v1, Landroid/webkit/WebViewDatabaseClassic;->mTableNames:[Ljava/lang/String;

    aget-object v1, v1, p1

    sget-object v2, Landroid/webkit/WebViewDatabaseClassic;->ID_PROJECTION:[Ljava/lang/String;

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 297
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z
    :try_end_1f
    .catchall {:try_start_b .. :try_end_1f} :catchall_37
    .catch Ljava/lang/IllegalStateException; {:try_start_b .. :try_end_1f} :catch_2c

    move-result v0

    if-ne v0, v11, :cond_2a

    move v10, v11

    .line 301
    :goto_23
    if-eqz v8, :cond_28

    :goto_25
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    :cond_28
    move v12, v10

    .line 303
    goto :goto_8

    :cond_2a
    move v10, v12

    .line 297
    goto :goto_23

    .line 298
    :catch_2c
    move-exception v9

    .line 299
    .local v9, e:Ljava/lang/IllegalStateException;
    :try_start_2d
    const-string v0, "WebViewDatabaseClassic"

    const-string v1, "hasEntries"

    invoke-static {v0, v1, v9}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_34
    .catchall {:try_start_2d .. :try_end_34} :catchall_37

    .line 301
    if-eqz v8, :cond_28

    goto :goto_25

    .end local v9           #e:Ljava/lang/IllegalStateException;
    :catchall_37
    move-exception v0

    if-eqz v8, :cond_3d

    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    :cond_3d
    throw v0
.end method

.method private declared-synchronized init(Landroid/content/Context;)V
    .registers 3
    .parameter "context"

    .prologue
    .line 121
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebViewDatabaseClassic;->mInitialized:Z
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_17

    if-eqz v0, :cond_7

    .line 133
    :goto_5
    monitor-exit p0

    return-void

    .line 125
    :cond_7
    :try_start_7
    invoke-direct {p0, p1}, Landroid/webkit/WebViewDatabaseClassic;->initDatabase(Landroid/content/Context;)V

    .line 128
    const-string/jumbo v0, "webviewCache.db"

    invoke-virtual {p1, v0}, Landroid/content/Context;->deleteDatabase(Ljava/lang/String;)Z

    .line 131
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/webkit/WebViewDatabaseClassic;->mInitialized:Z

    .line 132
    invoke-virtual {p0}, Ljava/lang/Object;->notify()V
    :try_end_16
    .catchall {:try_start_7 .. :try_end_16} :catchall_17

    goto :goto_5

    .line 121
    :catchall_17
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private initDatabase(Landroid/content/Context;)V
    .registers 8
    .parameter "context"

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x0

    .line 137
    :try_start_2
    const-string/jumbo v1, "webview.db"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {p1, v1, v2, v3}, Landroid/content/Context;->openOrCreateDatabase(Ljava/lang/String;ILandroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    sput-object v1, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;
    :try_end_d
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_2 .. :try_end_d} :catch_18

    .line 148
    :cond_d
    :goto_d
    sget-object v1, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    if-nez v1, :cond_2c

    .line 149
    const/4 v1, 0x1

    iput-boolean v1, p0, Landroid/webkit/WebViewDatabaseClassic;->mInitialized:Z

    .line 150
    invoke-virtual {p0}, Ljava/lang/Object;->notify()V

    .line 163
    :cond_17
    :goto_17
    return-void

    .line 138
    :catch_18
    move-exception v0

    .line 140
    .local v0, e:Landroid/database/sqlite/SQLiteException;
    const-string/jumbo v1, "webview.db"

    invoke-virtual {p1, v1}, Landroid/content/Context;->deleteDatabase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_d

    .line 141
    const-string/jumbo v1, "webview.db"

    invoke-virtual {p1, v1, v4, v5}, Landroid/content/Context;->openOrCreateDatabase(Ljava/lang/String;ILandroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    sput-object v1, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    goto :goto_d

    .line 154
    .end local v0           #e:Landroid/database/sqlite/SQLiteException;
    :cond_2c
    sget-object v1, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->getVersion()I

    move-result v1

    const/16 v2, 0xb

    if-eq v1, v2, :cond_17

    .line 155
    sget-object v1, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransactionNonExclusive()V

    .line 157
    :try_start_3b
    invoke-static {}, Landroid/webkit/WebViewDatabaseClassic;->upgradeDatabase()V

    .line 158
    sget-object v1, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_43
    .catchall {:try_start_3b .. :try_end_43} :catchall_49

    .line 160
    sget-object v1, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    goto :goto_17

    :catchall_49
    move-exception v1

    sget-object v2, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    throw v1
.end method

.method private static upgradeDatabase()V
    .registers 2

    .prologue
    .line 166
    invoke-static {}, Landroid/webkit/WebViewDatabaseClassic;->upgradeDatabaseToV10()V

    .line 167
    invoke-static {}, Landroid/webkit/WebViewDatabaseClassic;->upgradeDatabaseFromV10ToV11()V

    .line 170
    sget-object v0, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    const/16 v1, 0xb

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->setVersion(I)V

    .line 171
    return-void
.end method

.method private static upgradeDatabaseFromV10ToV11()V
    .registers 14

    .prologue
    const/4 v13, 0x1

    const/4 v2, 0x0

    .line 174
    sget-object v0, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->getVersion()I

    move-result v10

    .line 176
    .local v10, oldVersion:I
    const/16 v0, 0xb

    if-lt v10, v0, :cond_d

    .line 200
    :goto_c
    return-void

    .line 183
    :cond_d
    sget-object v0, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "DROP TABLE IF EXISTS cookies"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 186
    sget-object v0, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "DROP TABLE IF EXISTS cache"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 189
    sget-object v0, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    sget-object v1, Landroid/webkit/WebViewDatabaseClassic;->mTableNames:[Ljava/lang/String;

    aget-object v1, v1, v13

    move-object v3, v2

    move-object v4, v2

    move-object v5, v2

    move-object v6, v2

    move-object v7, v2

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 191
    .local v8, c:Landroid/database/Cursor;
    :goto_2a
    invoke-interface {v8}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_69

    .line 192
    const-string v0, "_id"

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v12

    .line 193
    .local v12, urlId:Ljava/lang/String;
    const-string/jumbo v0, "url"

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v11

    .line 194
    .local v11, url:Ljava/lang/String;
    new-instance v9, Landroid/content/ContentValues;

    invoke-direct {v9, v13}, Landroid/content/ContentValues;-><init>(I)V

    .line 195
    .local v9, cv:Landroid/content/ContentValues;
    const-string/jumbo v0, "url"

    invoke-static {v11}, Landroid/webkit/WebTextView;->urlForAutoCompleteData(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v9, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 196
    sget-object v0, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    sget-object v1, Landroid/webkit/WebViewDatabaseClassic;->mTableNames:[Ljava/lang/String;

    aget-object v1, v1, v13

    const-string v2, "_id=?"

    new-array v3, v13, [Ljava/lang/String;

    const/4 v4, 0x0

    aput-object v12, v3, v4

    invoke-virtual {v0, v1, v9, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    goto :goto_2a

    .line 199
    .end local v9           #cv:Landroid/content/ContentValues;
    .end local v11           #url:Ljava/lang/String;
    .end local v12           #urlId:Ljava/lang/String;
    :cond_69
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    goto :goto_c
.end method

.method private static upgradeDatabaseToV10()V
    .registers 8

    .prologue
    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    const/4 v4, 0x3

    .line 203
    sget-object v1, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->getVersion()I

    move-result v0

    .line 205
    .local v0, oldVersion:I
    const/16 v1, 0xa

    if-lt v0, v1, :cond_f

    .line 268
    :goto_e
    return-void

    .line 210
    :cond_f
    if-eqz v0, :cond_3b

    .line 211
    const-string v1, "WebViewDatabaseClassic"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Upgrading database from version "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " to "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/16 v3, 0xb

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", which will destroy old data"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 216
    :cond_3b
    const/16 v1, 0x9

    if-ne v1, v0, :cond_dd

    .line 217
    sget-object v1, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "DROP TABLE IF EXISTS "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Landroid/webkit/WebViewDatabaseClassic;->mTableNames:[Ljava/lang/String;

    aget-object v3, v3, v4

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 219
    sget-object v1, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "CREATE TABLE "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Landroid/webkit/WebViewDatabaseClassic;->mTableNames:[Ljava/lang/String;

    aget-object v3, v3, v4

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " ("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "_id"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " INTEGER PRIMARY KEY, "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "host"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " TEXT, "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "realm"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " TEXT, "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "username"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " TEXT, "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "password"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " TEXT,"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " UNIQUE ("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "host"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "realm"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ") ON CONFLICT REPLACE);"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    goto/16 :goto_e

    .line 229
    :cond_dd
    sget-object v1, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "DROP TABLE IF EXISTS cookies"

    invoke-virtual {v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 230
    sget-object v1, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "DROP TABLE IF EXISTS cache"

    invoke-virtual {v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 231
    sget-object v1, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "DROP TABLE IF EXISTS "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Landroid/webkit/WebViewDatabaseClassic;->mTableNames:[Ljava/lang/String;

    aget-object v3, v3, v6

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 233
    sget-object v1, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "DROP TABLE IF EXISTS "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Landroid/webkit/WebViewDatabaseClassic;->mTableNames:[Ljava/lang/String;

    aget-object v3, v3, v7

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 235
    sget-object v1, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "DROP TABLE IF EXISTS "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Landroid/webkit/WebViewDatabaseClassic;->mTableNames:[Ljava/lang/String;

    aget-object v3, v3, v4

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 237
    sget-object v1, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "DROP TABLE IF EXISTS "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Landroid/webkit/WebViewDatabaseClassic;->mTableNames:[Ljava/lang/String;

    aget-object v3, v3, v5

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 241
    sget-object v1, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "CREATE TABLE "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Landroid/webkit/WebViewDatabaseClassic;->mTableNames:[Ljava/lang/String;

    aget-object v3, v3, v6

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " ("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "_id"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " INTEGER PRIMARY KEY, "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "url"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " TEXT"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ");"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 246
    sget-object v1, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "CREATE TABLE "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Landroid/webkit/WebViewDatabaseClassic;->mTableNames:[Ljava/lang/String;

    aget-object v3, v3, v7

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " ("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "_id"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " INTEGER PRIMARY KEY, "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "urlid"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " INTEGER, "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "name"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " TEXT, "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "value"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " TEXT,"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " UNIQUE ("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "urlid"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "name"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "value"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ") ON CONFLICT IGNORE);"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 254
    sget-object v1, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "CREATE TABLE "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Landroid/webkit/WebViewDatabaseClassic;->mTableNames:[Ljava/lang/String;

    aget-object v3, v3, v4

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " ("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "_id"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " INTEGER PRIMARY KEY, "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "host"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " TEXT, "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "realm"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " TEXT, "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "username"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " TEXT, "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "password"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " TEXT,"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " UNIQUE ("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "host"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "realm"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ") ON CONFLICT REPLACE);"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 262
    sget-object v1, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "CREATE TABLE "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Landroid/webkit/WebViewDatabaseClassic;->mTableNames:[Ljava/lang/String;

    aget-object v3, v3, v5

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " ("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "_id"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " INTEGER PRIMARY KEY, "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "host"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " TEXT, "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "username"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " TEXT, "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "password"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " TEXT,"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " UNIQUE ("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "host"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "username"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ") ON CONFLICT REPLACE);"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    goto/16 :goto_e
.end method


# virtual methods
.method public clearFormData()V
    .registers 6

    .prologue
    .line 615
    invoke-direct {p0}, Landroid/webkit/WebViewDatabaseClassic;->checkInitialized()Z

    move-result v0

    if-nez v0, :cond_7

    .line 623
    :goto_6
    return-void

    .line 619
    :cond_7
    iget-object v1, p0, Landroid/webkit/WebViewDatabaseClassic;->mFormLock:Ljava/lang/Object;

    monitor-enter v1

    .line 620
    :try_start_a
    sget-object v0, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    sget-object v2, Landroid/webkit/WebViewDatabaseClassic;->mTableNames:[Ljava/lang/String;

    const/4 v3, 0x1

    aget-object v2, v2, v3

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v0, v2, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 621
    sget-object v0, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    sget-object v2, Landroid/webkit/WebViewDatabaseClassic;->mTableNames:[Ljava/lang/String;

    const/4 v3, 0x2

    aget-object v2, v2, v3

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v0, v2, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 622
    monitor-exit v1

    goto :goto_6

    :catchall_24
    move-exception v0

    monitor-exit v1
    :try_end_26
    .catchall {:try_start_a .. :try_end_26} :catchall_24

    throw v0
.end method

.method public clearHttpAuthUsernamePassword()V
    .registers 6

    .prologue
    .line 485
    invoke-direct {p0}, Landroid/webkit/WebViewDatabaseClassic;->checkInitialized()Z

    move-result v0

    if-nez v0, :cond_7

    .line 492
    :goto_6
    return-void

    .line 489
    :cond_7
    iget-object v1, p0, Landroid/webkit/WebViewDatabaseClassic;->mHttpAuthLock:Ljava/lang/Object;

    monitor-enter v1

    .line 490
    :try_start_a
    sget-object v0, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    sget-object v2, Landroid/webkit/WebViewDatabaseClassic;->mTableNames:[Ljava/lang/String;

    const/4 v3, 0x3

    aget-object v2, v2, v3

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v0, v2, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 491
    monitor-exit v1

    goto :goto_6

    :catchall_18
    move-exception v0

    monitor-exit v1
    :try_end_1a
    .catchall {:try_start_a .. :try_end_1a} :catchall_18

    throw v0
.end method

.method public clearUsernamePassword()V
    .registers 6

    .prologue
    .line 388
    invoke-direct {p0}, Landroid/webkit/WebViewDatabaseClassic;->checkInitialized()Z

    move-result v0

    if-nez v0, :cond_7

    .line 395
    :goto_6
    return-void

    .line 392
    :cond_7
    iget-object v1, p0, Landroid/webkit/WebViewDatabaseClassic;->mPasswordLock:Ljava/lang/Object;

    monitor-enter v1

    .line 393
    :try_start_a
    sget-object v0, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    sget-object v2, Landroid/webkit/WebViewDatabaseClassic;->mTableNames:[Ljava/lang/String;

    const/4 v3, 0x0

    aget-object v2, v2, v3

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v0, v2, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 394
    monitor-exit v1

    goto :goto_6

    :catchall_18
    move-exception v0

    monitor-exit v1
    :try_end_1a
    .catchall {:try_start_a .. :try_end_1a} :catchall_18

    throw v0
.end method

.method getFormData(Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;
    .registers 22
    .parameter "url"
    .parameter "name"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 554
    new-instance v17, Ljava/util/ArrayList;

    invoke-direct/range {v17 .. v17}, Ljava/util/ArrayList;-><init>()V

    .line 555
    .local v17, values:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/lang/String;>;"
    if-eqz p1, :cond_f

    if-eqz p2, :cond_f

    invoke-direct/range {p0 .. p0}, Landroid/webkit/WebViewDatabaseClassic;->checkInitialized()Z

    move-result v1

    if-nez v1, :cond_10

    .line 596
    :cond_f
    :goto_f
    return-object v17

    .line 559
    :cond_10
    const-string v13, "(url == ?)"

    .line 560
    .local v13, urlSelection:Ljava/lang/String;
    const-string v11, "(urlid == ?) AND (name == ?)"

    .line 562
    .local v11, dataSelection:Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/webkit/WebViewDatabaseClassic;->mFormLock:Ljava/lang/Object;

    move-object/from16 v18, v0

    monitor-enter v18

    .line 563
    const/4 v9, 0x0

    .line 565
    .local v9, cursor:Landroid/database/Cursor;
    :try_start_1c
    sget-object v1, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    sget-object v2, Landroid/webkit/WebViewDatabaseClassic;->mTableNames:[Ljava/lang/String;

    const/4 v3, 0x1

    aget-object v2, v2, v3

    sget-object v3, Landroid/webkit/WebViewDatabaseClassic;->ID_PROJECTION:[Ljava/lang/String;

    const-string v4, "(url == ?)"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    aput-object p1, v5, v6

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    .line 568
    :cond_34
    :goto_34
    invoke-interface {v9}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    if-eqz v1, :cond_c3

    .line 569
    const-string v1, "_id"

    invoke-interface {v9, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v9, v1}, Landroid/database/Cursor;->getLong(I)J
    :try_end_43
    .catchall {:try_start_1c .. :try_end_43} :catchall_b5
    .catch Ljava/lang/IllegalStateException; {:try_start_1c .. :try_end_43} :catch_94

    move-result-wide v14

    .line 570
    .local v14, urlid:J
    const/4 v10, 0x0

    .line 572
    .local v10, dataCursor:Landroid/database/Cursor;
    :try_start_45
    sget-object v1, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    sget-object v2, Landroid/webkit/WebViewDatabaseClassic;->mTableNames:[Ljava/lang/String;

    const/4 v3, 0x2

    aget-object v2, v2, v3

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v5, "_id"

    aput-object v5, v3, v4

    const/4 v4, 0x1

    const-string/jumbo v5, "value"

    aput-object v5, v3, v4

    const-string v4, "(urlid == ?) AND (name == ?)"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    invoke-static {v14, v15}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x1

    aput-object p2, v5, v6

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v10

    .line 578
    invoke-interface {v10}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_8e

    .line 579
    const-string/jumbo v1, "value"

    invoke-interface {v10, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v16

    .line 582
    .local v16, valueCol:I
    :cond_7d
    move/from16 v0, v16

    invoke-interface {v10, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    move-object/from16 v0, v17

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 583
    invoke-interface {v10}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_8b
    .catchall {:try_start_45 .. :try_end_8b} :catchall_bc
    .catch Ljava/lang/IllegalStateException; {:try_start_45 .. :try_end_8b} :catch_a7

    move-result v1

    if-nez v1, :cond_7d

    .line 588
    .end local v16           #valueCol:I
    :cond_8e
    if-eqz v10, :cond_34

    :try_start_90
    invoke-interface {v10}, Landroid/database/Cursor;->close()V
    :try_end_93
    .catchall {:try_start_90 .. :try_end_93} :catchall_b5
    .catch Ljava/lang/IllegalStateException; {:try_start_90 .. :try_end_93} :catch_94

    goto :goto_34

    .line 591
    .end local v10           #dataCursor:Landroid/database/Cursor;
    .end local v14           #urlid:J
    :catch_94
    move-exception v12

    .line 592
    .local v12, e:Ljava/lang/IllegalStateException;
    :try_start_95
    const-string v1, "WebViewDatabaseClassic"

    const-string v2, "getFormData cursor"

    invoke-static {v1, v2, v12}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_9c
    .catchall {:try_start_95 .. :try_end_9c} :catchall_b5

    .line 594
    if-eqz v9, :cond_a1

    :try_start_9e
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    .line 596
    .end local v12           #e:Ljava/lang/IllegalStateException;
    :cond_a1
    :goto_a1
    monitor-exit v18

    goto/16 :goto_f

    .line 597
    :catchall_a4
    move-exception v1

    monitor-exit v18
    :try_end_a6
    .catchall {:try_start_9e .. :try_end_a6} :catchall_a4

    throw v1

    .line 585
    .restart local v10       #dataCursor:Landroid/database/Cursor;
    .restart local v14       #urlid:J
    :catch_a7
    move-exception v12

    .line 586
    .restart local v12       #e:Ljava/lang/IllegalStateException;
    :try_start_a8
    const-string v1, "WebViewDatabaseClassic"

    const-string v2, "getFormData dataCursor"

    invoke-static {v1, v2, v12}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_af
    .catchall {:try_start_a8 .. :try_end_af} :catchall_bc

    .line 588
    if-eqz v10, :cond_34

    :try_start_b1
    invoke-interface {v10}, Landroid/database/Cursor;->close()V
    :try_end_b4
    .catchall {:try_start_b1 .. :try_end_b4} :catchall_b5
    .catch Ljava/lang/IllegalStateException; {:try_start_b1 .. :try_end_b4} :catch_94

    goto :goto_34

    .line 594
    .end local v10           #dataCursor:Landroid/database/Cursor;
    .end local v12           #e:Ljava/lang/IllegalStateException;
    .end local v14           #urlid:J
    :catchall_b5
    move-exception v1

    if-eqz v9, :cond_bb

    :try_start_b8
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    :cond_bb
    throw v1
    :try_end_bc
    .catchall {:try_start_b8 .. :try_end_bc} :catchall_a4

    .line 588
    .restart local v10       #dataCursor:Landroid/database/Cursor;
    .restart local v14       #urlid:J
    :catchall_bc
    move-exception v1

    if-eqz v10, :cond_c2

    :try_start_bf
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    :cond_c2
    throw v1
    :try_end_c3
    .catchall {:try_start_bf .. :try_end_c3} :catchall_b5
    .catch Ljava/lang/IllegalStateException; {:try_start_bf .. :try_end_c3} :catch_94

    .line 594
    .end local v10           #dataCursor:Landroid/database/Cursor;
    .end local v14           #urlid:J
    :cond_c3
    if-eqz v9, :cond_a1

    :try_start_c5
    invoke-interface {v9}, Landroid/database/Cursor;->close()V
    :try_end_c8
    .catchall {:try_start_c5 .. :try_end_c8} :catchall_a4

    goto :goto_a1
.end method

.method getHttpAuthUsernamePassword(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;
    .registers 16
    .parameter "host"
    .parameter "realm"

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v1, 0x0

    const/4 v10, 0x0

    .line 438
    if-eqz p1, :cond_e

    if-eqz p2, :cond_e

    invoke-direct {p0}, Landroid/webkit/WebViewDatabaseClassic;->checkInitialized()Z

    move-result v0

    if-nez v0, :cond_f

    .line 466
    :cond_e
    :goto_e
    return-object v10

    .line 442
    :cond_f
    new-array v2, v4, [Ljava/lang/String;

    const-string/jumbo v0, "username"

    aput-object v0, v2, v1

    const-string/jumbo v0, "password"

    aput-object v0, v2, v3

    .line 445
    .local v2, columns:[Ljava/lang/String;
    const-string v11, "(host == ?) AND (realm == ?)"

    .line 447
    .local v11, selection:Ljava/lang/String;
    iget-object v12, p0, Landroid/webkit/WebViewDatabaseClassic;->mHttpAuthLock:Ljava/lang/Object;

    monitor-enter v12

    .line 448
    const/4 v10, 0x0

    .line 449
    .local v10, ret:[Ljava/lang/String;
    const/4 v8, 0x0

    .line 451
    .local v8, cursor:Landroid/database/Cursor;
    :try_start_22
    sget-object v0, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    sget-object v1, Landroid/webkit/WebViewDatabaseClassic;->mTableNames:[Ljava/lang/String;

    const/4 v3, 0x3

    aget-object v1, v1, v3

    const-string v3, "(host == ?) AND (realm == ?)"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    aput-object p1, v4, v5

    const/4 v5, 0x1

    aput-object p2, v4, v5

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 454
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_60

    .line 455
    const/4 v0, 0x2

    new-array v10, v0, [Ljava/lang/String;

    .line 456
    const/4 v0, 0x0

    const-string/jumbo v1, "username"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v10, v0

    .line 458
    const/4 v0, 0x1

    const-string/jumbo v1, "password"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v10, v0
    :try_end_60
    .catchall {:try_start_22 .. :try_end_60} :catchall_78
    .catch Ljava/lang/IllegalStateException; {:try_start_22 .. :try_end_60} :catch_6a

    .line 464
    :cond_60
    if-eqz v8, :cond_65

    :try_start_62
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 466
    :cond_65
    :goto_65
    monitor-exit v12

    goto :goto_e

    .line 467
    :catchall_67
    move-exception v0

    monitor-exit v12
    :try_end_69
    .catchall {:try_start_62 .. :try_end_69} :catchall_67

    throw v0

    .line 461
    :catch_6a
    move-exception v9

    .line 462
    .local v9, e:Ljava/lang/IllegalStateException;
    :try_start_6b
    const-string v0, "WebViewDatabaseClassic"

    const-string v1, "getHttpAuthUsernamePassword"

    invoke-static {v0, v1, v9}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_72
    .catchall {:try_start_6b .. :try_end_72} :catchall_78

    .line 464
    if-eqz v8, :cond_65

    :try_start_74
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    goto :goto_65

    .end local v9           #e:Ljava/lang/IllegalStateException;
    :catchall_78
    move-exception v0

    if-eqz v8, :cond_7e

    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    :cond_7e
    throw v0
    :try_end_7f
    .catchall {:try_start_74 .. :try_end_7f} :catchall_67
.end method

.method getUsernamePassword(Ljava/lang/String;)[Ljava/lang/String;
    .registers 15
    .parameter "schemePlusHost"

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v10, 0x0

    const/4 v1, 0x0

    .line 342
    if-eqz p1, :cond_c

    invoke-direct {p0}, Landroid/webkit/WebViewDatabaseClassic;->checkInitialized()Z

    move-result v0

    if-nez v0, :cond_d

    .line 369
    :cond_c
    :goto_c
    return-object v10

    .line 346
    :cond_d
    new-array v2, v4, [Ljava/lang/String;

    const-string/jumbo v0, "username"

    aput-object v0, v2, v1

    const-string/jumbo v0, "password"

    aput-object v0, v2, v3

    .line 349
    .local v2, columns:[Ljava/lang/String;
    const-string v11, "(host == ?)"

    .line 350
    .local v11, selection:Ljava/lang/String;
    iget-object v12, p0, Landroid/webkit/WebViewDatabaseClassic;->mPasswordLock:Ljava/lang/Object;

    monitor-enter v12

    .line 351
    const/4 v10, 0x0

    .line 352
    .local v10, ret:[Ljava/lang/String;
    const/4 v8, 0x0

    .line 354
    .local v8, cursor:Landroid/database/Cursor;
    :try_start_20
    sget-object v0, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    sget-object v1, Landroid/webkit/WebViewDatabaseClassic;->mTableNames:[Ljava/lang/String;

    const/4 v3, 0x0

    aget-object v1, v1, v3

    const-string v3, "(host == ?)"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    aput-object p1, v4, v5

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 357
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_5b

    .line 358
    const/4 v0, 0x2

    new-array v10, v0, [Ljava/lang/String;

    .line 359
    const/4 v0, 0x0

    const-string/jumbo v1, "username"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v10, v0

    .line 361
    const/4 v0, 0x1

    const-string/jumbo v1, "password"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v10, v0
    :try_end_5b
    .catchall {:try_start_20 .. :try_end_5b} :catchall_73
    .catch Ljava/lang/IllegalStateException; {:try_start_20 .. :try_end_5b} :catch_65

    .line 367
    :cond_5b
    if-eqz v8, :cond_60

    :try_start_5d
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 369
    :cond_60
    :goto_60
    monitor-exit v12

    goto :goto_c

    .line 370
    :catchall_62
    move-exception v0

    monitor-exit v12
    :try_end_64
    .catchall {:try_start_5d .. :try_end_64} :catchall_62

    throw v0

    .line 364
    :catch_65
    move-exception v9

    .line 365
    .local v9, e:Ljava/lang/IllegalStateException;
    :try_start_66
    const-string v0, "WebViewDatabaseClassic"

    const-string v1, "getUsernamePassword"

    invoke-static {v0, v1, v9}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_6d
    .catchall {:try_start_66 .. :try_end_6d} :catchall_73

    .line 367
    if-eqz v8, :cond_60

    :try_start_6f
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    goto :goto_60

    .end local v9           #e:Ljava/lang/IllegalStateException;
    :catchall_73
    move-exception v0

    if-eqz v8, :cond_79

    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    :cond_79
    throw v0
    :try_end_7a
    .catchall {:try_start_6f .. :try_end_7a} :catchall_62
.end method

.method public hasFormData()Z
    .registers 3

    .prologue
    .line 605
    iget-object v1, p0, Landroid/webkit/WebViewDatabaseClassic;->mFormLock:Ljava/lang/Object;

    monitor-enter v1

    .line 606
    const/4 v0, 0x1

    :try_start_4
    invoke-direct {p0, v0}, Landroid/webkit/WebViewDatabaseClassic;->hasEntries(I)Z

    move-result v0

    monitor-exit v1

    return v0

    .line 607
    :catchall_a
    move-exception v0

    monitor-exit v1
    :try_end_c
    .catchall {:try_start_4 .. :try_end_c} :catchall_a

    throw v0
.end method

.method public hasHttpAuthUsernamePassword()Z
    .registers 3

    .prologue
    .line 475
    iget-object v1, p0, Landroid/webkit/WebViewDatabaseClassic;->mHttpAuthLock:Ljava/lang/Object;

    monitor-enter v1

    .line 476
    const/4 v0, 0x3

    :try_start_4
    invoke-direct {p0, v0}, Landroid/webkit/WebViewDatabaseClassic;->hasEntries(I)Z

    move-result v0

    monitor-exit v1

    return v0

    .line 477
    :catchall_a
    move-exception v0

    monitor-exit v1
    :try_end_c
    .catchall {:try_start_4 .. :try_end_c} :catchall_a

    throw v0
.end method

.method public hasUsernamePassword()Z
    .registers 3

    .prologue
    .line 378
    iget-object v1, p0, Landroid/webkit/WebViewDatabaseClassic;->mPasswordLock:Ljava/lang/Object;

    monitor-enter v1

    .line 379
    const/4 v0, 0x0

    :try_start_4
    invoke-direct {p0, v0}, Landroid/webkit/WebViewDatabaseClassic;->hasEntries(I)Z

    move-result v0

    monitor-exit v1

    return v0

    .line 380
    :catchall_a
    move-exception v0

    monitor-exit v1
    :try_end_c
    .catchall {:try_start_4 .. :try_end_c} :catchall_a

    throw v0
.end method

.method setFormData(Ljava/lang/String;Ljava/util/HashMap;)V
    .registers 23
    .parameter "url"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 506
    .local p2, formdata:Ljava/util/HashMap;,"Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz p1, :cond_a

    if-eqz p2, :cond_a

    invoke-direct/range {p0 .. p0}, Landroid/webkit/WebViewDatabaseClassic;->checkInitialized()Z

    move-result v1

    if-nez v1, :cond_b

    .line 544
    :cond_a
    :goto_a
    return-void

    .line 510
    :cond_b
    const-string v15, "(url == ?)"

    .line 511
    .local v15, selection:Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/webkit/WebViewDatabaseClassic;->mFormLock:Ljava/lang/Object;

    move-object/from16 v19, v0

    monitor-enter v19

    .line 512
    const-wide/16 v17, -0x1

    .line 513
    .local v17, urlid:J
    const/4 v10, 0x0

    .line 515
    .local v10, cursor:Landroid/database/Cursor;
    :try_start_17
    sget-object v1, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    sget-object v2, Landroid/webkit/WebViewDatabaseClassic;->mTableNames:[Ljava/lang/String;

    const/4 v3, 0x1

    aget-object v2, v2, v3

    sget-object v3, Landroid/webkit/WebViewDatabaseClassic;->ID_PROJECTION:[Ljava/lang/String;

    const-string v4, "(url == ?)"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    aput-object p1, v5, v6

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v10

    .line 518
    invoke-interface {v10}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_94

    .line 519
    const-string v1, "_id"

    invoke-interface {v10, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v10, v1}, Landroid/database/Cursor;->getLong(I)J
    :try_end_3e
    .catchall {:try_start_17 .. :try_end_3e} :catchall_bd
    .catch Ljava/lang/IllegalStateException; {:try_start_17 .. :try_end_3e} :catch_ae

    move-result-wide v17

    .line 529
    :goto_3f
    if-eqz v10, :cond_44

    :try_start_41
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    .line 531
    :cond_44
    :goto_44
    const-wide/16 v1, 0x0

    cmp-long v1, v17, v1

    if-ltz v1, :cond_c4

    .line 532
    invoke-virtual/range {p2 .. p2}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v16

    .line 533
    .local v16, set:Ljava/util/Set;,"Ljava/util/Set<Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;>;"
    invoke-interface/range {v16 .. v16}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v13

    .line 534
    .local v13, iter:Ljava/util/Iterator;,"Ljava/util/Iterator<Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;>;"
    new-instance v14, Landroid/content/ContentValues;

    invoke-direct {v14}, Landroid/content/ContentValues;-><init>()V

    .line 535
    .local v14, map:Landroid/content/ContentValues;
    const-string/jumbo v1, "urlid"

    invoke-static/range {v17 .. v18}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v14, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 536
    :goto_61
    invoke-interface {v13}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_c4

    .line 537
    invoke-interface {v13}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/util/Map$Entry;

    .line 538
    .local v12, entry:Ljava/util/Map$Entry;,"Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v2, "name"

    invoke-interface {v12}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v14, v2, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 539
    const-string/jumbo v2, "value"

    invoke-interface {v12}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v14, v2, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 540
    sget-object v1, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    sget-object v2, Landroid/webkit/WebViewDatabaseClassic;->mTableNames:[Ljava/lang/String;

    const/4 v3, 0x2

    aget-object v2, v2, v3

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3, v14}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    goto :goto_61

    .line 543
    .end local v12           #entry:Ljava/util/Map$Entry;,"Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v13           #iter:Ljava/util/Iterator;,"Ljava/util/Iterator<Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;>;"
    .end local v14           #map:Landroid/content/ContentValues;
    .end local v16           #set:Ljava/util/Set;,"Ljava/util/Set<Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;>;"
    :catchall_91
    move-exception v1

    monitor-exit v19
    :try_end_93
    .catchall {:try_start_41 .. :try_end_93} :catchall_91

    throw v1

    .line 521
    :cond_94
    :try_start_94
    new-instance v9, Landroid/content/ContentValues;

    invoke-direct {v9}, Landroid/content/ContentValues;-><init>()V

    .line 522
    .local v9, c:Landroid/content/ContentValues;
    const-string/jumbo v1, "url"

    move-object/from16 v0, p1

    invoke-virtual {v9, v1, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 523
    sget-object v1, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    sget-object v2, Landroid/webkit/WebViewDatabaseClassic;->mTableNames:[Ljava/lang/String;

    const/4 v3, 0x1

    aget-object v2, v2, v3

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3, v9}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    :try_end_ac
    .catchall {:try_start_94 .. :try_end_ac} :catchall_bd
    .catch Ljava/lang/IllegalStateException; {:try_start_94 .. :try_end_ac} :catch_ae

    move-result-wide v17

    goto :goto_3f

    .line 526
    .end local v9           #c:Landroid/content/ContentValues;
    :catch_ae
    move-exception v11

    .line 527
    .local v11, e:Ljava/lang/IllegalStateException;
    :try_start_af
    const-string v1, "WebViewDatabaseClassic"

    const-string/jumbo v2, "setFormData"

    invoke-static {v1, v2, v11}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_b7
    .catchall {:try_start_af .. :try_end_b7} :catchall_bd

    .line 529
    if-eqz v10, :cond_44

    :try_start_b9
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    goto :goto_44

    .end local v11           #e:Ljava/lang/IllegalStateException;
    :catchall_bd
    move-exception v1

    if-eqz v10, :cond_c3

    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    :cond_c3
    throw v1

    .line 543
    :cond_c4
    monitor-exit v19
    :try_end_c5
    .catchall {:try_start_b9 .. :try_end_c5} :catchall_91

    goto/16 :goto_a
.end method

.method setHttpAuthUsernamePassword(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .registers 10
    .parameter "host"
    .parameter "realm"
    .parameter "username"
    .parameter "password"

    .prologue
    .line 413
    if-eqz p1, :cond_a

    if-eqz p2, :cond_a

    invoke-direct {p0}, Landroid/webkit/WebViewDatabaseClassic;->checkInitialized()Z

    move-result v1

    if-nez v1, :cond_b

    .line 426
    :cond_a
    :goto_a
    return-void

    .line 417
    :cond_b
    iget-object v2, p0, Landroid/webkit/WebViewDatabaseClassic;->mHttpAuthLock:Ljava/lang/Object;

    monitor-enter v2

    .line 418
    :try_start_e
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 419
    .local v0, c:Landroid/content/ContentValues;
    const-string v1, "host"

    invoke-virtual {v0, v1, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 420
    const-string/jumbo v1, "realm"

    invoke-virtual {v0, v1, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 421
    const-string/jumbo v1, "username"

    invoke-virtual {v0, v1, p3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 422
    const-string/jumbo v1, "password"

    invoke-virtual {v0, v1, p4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 423
    sget-object v1, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    sget-object v3, Landroid/webkit/WebViewDatabaseClassic;->mTableNames:[Ljava/lang/String;

    const/4 v4, 0x3

    aget-object v3, v3, v4

    const-string v4, "host"

    invoke-virtual {v1, v3, v4, v0}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 425
    monitor-exit v2

    goto :goto_a

    .end local v0           #c:Landroid/content/ContentValues;
    :catchall_38
    move-exception v1

    monitor-exit v2
    :try_end_3a
    .catchall {:try_start_e .. :try_end_3a} :catchall_38

    throw v1
.end method

.method setUsernamePassword(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .registers 9
    .parameter "schemePlusHost"
    .parameter "username"
    .parameter "password"

    .prologue
    .line 320
    if-eqz p1, :cond_8

    invoke-direct {p0}, Landroid/webkit/WebViewDatabaseClassic;->checkInitialized()Z

    move-result v1

    if-nez v1, :cond_9

    .line 332
    :cond_8
    :goto_8
    return-void

    .line 324
    :cond_9
    iget-object v2, p0, Landroid/webkit/WebViewDatabaseClassic;->mPasswordLock:Ljava/lang/Object;

    monitor-enter v2

    .line 325
    :try_start_c
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 326
    .local v0, c:Landroid/content/ContentValues;
    const-string v1, "host"

    invoke-virtual {v0, v1, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 327
    const-string/jumbo v1, "username"

    invoke-virtual {v0, v1, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 328
    const-string/jumbo v1, "password"

    invoke-virtual {v0, v1, p3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 329
    sget-object v1, Landroid/webkit/WebViewDatabaseClassic;->sDatabase:Landroid/database/sqlite/SQLiteDatabase;

    sget-object v3, Landroid/webkit/WebViewDatabaseClassic;->mTableNames:[Ljava/lang/String;

    const/4 v4, 0x0

    aget-object v3, v3, v4

    const-string v4, "host"

    invoke-virtual {v1, v3, v4, v0}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 331
    monitor-exit v2

    goto :goto_8

    .end local v0           #c:Landroid/content/ContentValues;
    :catchall_30
    move-exception v1

    monitor-exit v2
    :try_end_32
    .catchall {:try_start_c .. :try_end_32} :catchall_30

    throw v1
.end method
