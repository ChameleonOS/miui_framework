.class final Landroid/database/sqlite/SQLiteConnection$PreparedStatement;
.super Ljava/lang/Object;
.source "SQLiteConnection.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/database/sqlite/SQLiteConnection;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "PreparedStatement"
.end annotation


# instance fields
.field public mInCache:Z

.field public mInUse:Z

.field public mNumParameters:I

.field public mPoolNext:Landroid/database/sqlite/SQLiteConnection$PreparedStatement;

.field public mReadOnly:Z

.field public mSql:Ljava/lang/String;

.field public mStatementPtr:I

.field public mType:I


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/database/sqlite/SQLiteConnection$1;)V
    .registers 2
    .parameter "x0"

    .prologue
    invoke-direct {p0}, Landroid/database/sqlite/SQLiteConnection$PreparedStatement;-><init>()V

    return-void
.end method
