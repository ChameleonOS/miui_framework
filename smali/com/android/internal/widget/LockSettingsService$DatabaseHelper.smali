.class Lcom/android/internal/widget/LockSettingsService$DatabaseHelper;
.super Landroid/database/sqlite/SQLiteOpenHelper;
.source "LockSettingsService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/widget/LockSettingsService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "DatabaseHelper"
.end annotation


# static fields
.field private static final DATABASE_NAME:Ljava/lang/String; = "locksettings.db"

.field private static final DATABASE_VERSION:I = 0x1

.field private static final TAG:Ljava/lang/String; = "LockSettingsDB"


# instance fields
.field final synthetic this$0:Lcom/android/internal/widget/LockSettingsService;


# direct methods
.method public constructor <init>(Lcom/android/internal/widget/LockSettingsService;Landroid/content/Context;)V
    .registers 6
    .parameter
    .parameter "context"

    .prologue
    const/4 v2, 0x1

    iput-object p1, p0, Lcom/android/internal/widget/LockSettingsService$DatabaseHelper;->this$0:Lcom/android/internal/widget/LockSettingsService;

    const-string v0, "locksettings.db"

    const/4 v1, 0x0

    invoke-direct {p0, p2, v0, v1, v2}, Landroid/database/sqlite/SQLiteOpenHelper;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V

    invoke-virtual {p0, v2}, Lcom/android/internal/widget/LockSettingsService$DatabaseHelper;->setWriteAheadLoggingEnabled(Z)V

    return-void
.end method

.method private createTable(Landroid/database/sqlite/SQLiteDatabase;)V
    .registers 3
    .parameter "db"

    .prologue
    const-string v0, "CREATE TABLE locksettings (_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,user INTEGER,value TEXT);"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public onCreate(Landroid/database/sqlite/SQLiteDatabase;)V
    .registers 2
    .parameter "db"

    .prologue
    invoke-direct {p0, p1}, Lcom/android/internal/widget/LockSettingsService$DatabaseHelper;->createTable(Landroid/database/sqlite/SQLiteDatabase;)V

    return-void
.end method

.method public onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .registers 4
    .parameter "db"
    .parameter "oldVersion"
    .parameter "currentVersion"

    .prologue
    return-void
.end method
