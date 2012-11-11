.class public Landroid/database/sqlite/SQLiteDatabaseLockedException;
.super Landroid/database/sqlite/SQLiteException;
.source "SQLiteDatabaseLockedException.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct {p0}, Landroid/database/sqlite/SQLiteException;-><init>()V

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .registers 2
    .parameter "error"

    .prologue
    invoke-direct {p0, p1}, Landroid/database/sqlite/SQLiteException;-><init>(Ljava/lang/String;)V

    return-void
.end method
