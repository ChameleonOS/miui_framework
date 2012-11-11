.class public Lmiui/content/res/ThemeZipFile$ThemeFileInfo;
.super Ljava/lang/Object;
.source "ThemeZipFile.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/content/res/ThemeZipFile;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "ThemeFileInfo"
.end annotation


# instance fields
.field public mDensity:I

.field public mInput:Ljava/io/InputStream;

.field public mSize:J

.field final synthetic this$0:Lmiui/content/res/ThemeZipFile;


# direct methods
.method constructor <init>(Lmiui/content/res/ThemeZipFile;Ljava/io/InputStream;J)V
    .registers 5
    .parameter
    .parameter "in"
    .parameter "size"

    .prologue
    iput-object p1, p0, Lmiui/content/res/ThemeZipFile$ThemeFileInfo;->this$0:Lmiui/content/res/ThemeZipFile;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p2, p0, Lmiui/content/res/ThemeZipFile$ThemeFileInfo;->mInput:Ljava/io/InputStream;

    iput-wide p3, p0, Lmiui/content/res/ThemeZipFile$ThemeFileInfo;->mSize:J

    return-void
.end method
