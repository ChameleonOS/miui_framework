.class Landroid/net/http/AndroidHttpClient$LoggingConfiguration;
.super Ljava/lang/Object;
.source "AndroidHttpClient.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/http/AndroidHttpClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "LoggingConfiguration"
.end annotation


# instance fields
.field private final level:I

.field private final tag:Ljava/lang/String;


# direct methods
.method private constructor <init>(Ljava/lang/String;I)V
    .registers 3
    .parameter "tag"
    .parameter "level"

    .prologue
    .line 335
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 336
    iput-object p1, p0, Landroid/net/http/AndroidHttpClient$LoggingConfiguration;->tag:Ljava/lang/String;

    .line 337
    iput p2, p0, Landroid/net/http/AndroidHttpClient$LoggingConfiguration;->level:I

    .line 338
    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/String;ILandroid/net/http/AndroidHttpClient$1;)V
    .registers 4
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"

    .prologue
    .line 330
    invoke-direct {p0, p1, p2}, Landroid/net/http/AndroidHttpClient$LoggingConfiguration;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method static synthetic access$400(Landroid/net/http/AndroidHttpClient$LoggingConfiguration;)Z
    .registers 2
    .parameter "x0"

    .prologue
    .line 330
    invoke-direct {p0}, Landroid/net/http/AndroidHttpClient$LoggingConfiguration;->isLoggable()Z

    move-result v0

    return v0
.end method

.method static synthetic access$600(Landroid/net/http/AndroidHttpClient$LoggingConfiguration;Ljava/lang/String;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 330
    invoke-direct {p0, p1}, Landroid/net/http/AndroidHttpClient$LoggingConfiguration;->println(Ljava/lang/String;)V

    return-void
.end method

.method private isLoggable()Z
    .registers 3

    .prologue
    .line 344
    iget-object v0, p0, Landroid/net/http/AndroidHttpClient$LoggingConfiguration;->tag:Ljava/lang/String;

    iget v1, p0, Landroid/net/http/AndroidHttpClient$LoggingConfiguration;->level:I

    invoke-static {v0, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    return v0
.end method

.method private println(Ljava/lang/String;)V
    .registers 4
    .parameter "message"

    .prologue
    .line 351
    iget v0, p0, Landroid/net/http/AndroidHttpClient$LoggingConfiguration;->level:I

    iget-object v1, p0, Landroid/net/http/AndroidHttpClient$LoggingConfiguration;->tag:Ljava/lang/String;

    invoke-static {v0, v1, p1}, Landroid/util/Log;->println(ILjava/lang/String;Ljava/lang/String;)I

    .line 352
    return-void
.end method
