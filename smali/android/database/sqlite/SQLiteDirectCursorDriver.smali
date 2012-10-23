.class public final Landroid/database/sqlite/SQLiteDirectCursorDriver;
.super Ljava/lang/Object;
.source "SQLiteDirectCursorDriver.java"

# interfaces
.implements Landroid/database/sqlite/SQLiteCursorDriver;


# instance fields
.field private final mCancellationSignal:Landroid/os/CancellationSignal;

.field private final mDatabase:Landroid/database/sqlite/SQLiteDatabase;

.field private final mEditTable:Ljava/lang/String;

.field private mQuery:Landroid/database/sqlite/SQLiteQuery;

.field private final mSql:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Landroid/os/CancellationSignal;)V
    .registers 5
    .parameter "db"
    .parameter "sql"
    .parameter "editTable"
    .parameter "cancellationSignal"

    .prologue
    .line 36
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 37
    iput-object p1, p0, Landroid/database/sqlite/SQLiteDirectCursorDriver;->mDatabase:Landroid/database/sqlite/SQLiteDatabase;

    .line 38
    iput-object p3, p0, Landroid/database/sqlite/SQLiteDirectCursorDriver;->mEditTable:Ljava/lang/String;

    .line 39
    iput-object p2, p0, Landroid/database/sqlite/SQLiteDirectCursorDriver;->mSql:Ljava/lang/String;

    .line 40
    iput-object p4, p0, Landroid/database/sqlite/SQLiteDirectCursorDriver;->mCancellationSignal:Landroid/os/CancellationSignal;

    .line 41
    return-void
.end method


# virtual methods
.method public cursorClosed()V
    .registers 1

    .prologue
    .line 65
    return-void
.end method

.method public cursorDeactivated()V
    .registers 1

    .prologue
    .line 73
    return-void
.end method

.method public cursorRequeried(Landroid/database/Cursor;)V
    .registers 2
    .parameter "cursor"

    .prologue
    .line 77
    return-void
.end method

.method public query(Landroid/database/sqlite/SQLiteDatabase$CursorFactory;[Ljava/lang/String;)Landroid/database/Cursor;
    .registers 9
    .parameter "factory"
    .parameter "selectionArgs"

    .prologue
    .line 44
    new-instance v2, Landroid/database/sqlite/SQLiteQuery;

    iget-object v3, p0, Landroid/database/sqlite/SQLiteDirectCursorDriver;->mDatabase:Landroid/database/sqlite/SQLiteDatabase;

    iget-object v4, p0, Landroid/database/sqlite/SQLiteDirectCursorDriver;->mSql:Ljava/lang/String;

    iget-object v5, p0, Landroid/database/sqlite/SQLiteDirectCursorDriver;->mCancellationSignal:Landroid/os/CancellationSignal;

    invoke-direct {v2, v3, v4, v5}, Landroid/database/sqlite/SQLiteQuery;-><init>(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Landroid/os/CancellationSignal;)V

    .line 47
    .local v2, query:Landroid/database/sqlite/SQLiteQuery;
    :try_start_b
    invoke-virtual {v2, p2}, Landroid/database/sqlite/SQLiteQuery;->bindAllArgsAsStrings([Ljava/lang/String;)V

    .line 49
    if-nez p1, :cond_1a

    .line 50
    new-instance v0, Landroid/database/sqlite/SQLiteCursor;

    iget-object v3, p0, Landroid/database/sqlite/SQLiteDirectCursorDriver;->mEditTable:Ljava/lang/String;

    invoke-direct {v0, p0, v3, v2}, Landroid/database/sqlite/SQLiteCursor;-><init>(Landroid/database/sqlite/SQLiteCursorDriver;Ljava/lang/String;Landroid/database/sqlite/SQLiteQuery;)V
    :try_end_17
    .catch Ljava/lang/RuntimeException; {:try_start_b .. :try_end_17} :catch_23

    .line 59
    .local v0, cursor:Landroid/database/Cursor;
    :goto_17
    iput-object v2, p0, Landroid/database/sqlite/SQLiteDirectCursorDriver;->mQuery:Landroid/database/sqlite/SQLiteQuery;

    .line 60
    return-object v0

    .line 52
    .end local v0           #cursor:Landroid/database/Cursor;
    :cond_1a
    :try_start_1a
    iget-object v3, p0, Landroid/database/sqlite/SQLiteDirectCursorDriver;->mDatabase:Landroid/database/sqlite/SQLiteDatabase;

    iget-object v4, p0, Landroid/database/sqlite/SQLiteDirectCursorDriver;->mEditTable:Ljava/lang/String;

    invoke-interface {p1, v3, p0, v4, v2}, Landroid/database/sqlite/SQLiteDatabase$CursorFactory;->newCursor(Landroid/database/sqlite/SQLiteDatabase;Landroid/database/sqlite/SQLiteCursorDriver;Ljava/lang/String;Landroid/database/sqlite/SQLiteQuery;)Landroid/database/Cursor;
    :try_end_21
    .catch Ljava/lang/RuntimeException; {:try_start_1a .. :try_end_21} :catch_23

    move-result-object v0

    .restart local v0       #cursor:Landroid/database/Cursor;
    goto :goto_17

    .line 54
    .end local v0           #cursor:Landroid/database/Cursor;
    :catch_23
    move-exception v1

    .line 55
    .local v1, ex:Ljava/lang/RuntimeException;
    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteQuery;->close()V

    .line 56
    throw v1
.end method

.method public setBindArguments([Ljava/lang/String;)V
    .registers 3
    .parameter "bindArgs"

    .prologue
    .line 68
    iget-object v0, p0, Landroid/database/sqlite/SQLiteDirectCursorDriver;->mQuery:Landroid/database/sqlite/SQLiteQuery;

    invoke-virtual {v0, p1}, Landroid/database/sqlite/SQLiteQuery;->bindAllArgsAsStrings([Ljava/lang/String;)V

    .line 69
    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    .prologue
    .line 81
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "SQLiteDirectCursorDriver: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Landroid/database/sqlite/SQLiteDirectCursorDriver;->mSql:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
