.class Landroid/net/http/AndroidHttpClient$CurlLogger;
.super Ljava/lang/Object;
.source "AndroidHttpClient.java"

# interfaces
.implements Lorg/apache/http/HttpRequestInterceptor;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/http/AndroidHttpClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "CurlLogger"
.end annotation


# instance fields
.field final synthetic this$0:Landroid/net/http/AndroidHttpClient;


# direct methods
.method private constructor <init>(Landroid/net/http/AndroidHttpClient;)V
    .registers 2
    .parameter

    .prologue
    .line 386
    iput-object p1, p0, Landroid/net/http/AndroidHttpClient$CurlLogger;->this$0:Landroid/net/http/AndroidHttpClient;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/net/http/AndroidHttpClient;Landroid/net/http/AndroidHttpClient$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 386
    invoke-direct {p0, p1}, Landroid/net/http/AndroidHttpClient$CurlLogger;-><init>(Landroid/net/http/AndroidHttpClient;)V

    return-void
.end method


# virtual methods
.method public process(Lorg/apache/http/HttpRequest;Lorg/apache/http/protocol/HttpContext;)V
    .registers 5
    .parameter "request"
    .parameter "context"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/apache/http/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 389
    iget-object v1, p0, Landroid/net/http/AndroidHttpClient$CurlLogger;->this$0:Landroid/net/http/AndroidHttpClient;

    #getter for: Landroid/net/http/AndroidHttpClient;->curlConfiguration:Landroid/net/http/AndroidHttpClient$LoggingConfiguration;
    invoke-static {v1}, Landroid/net/http/AndroidHttpClient;->access$300(Landroid/net/http/AndroidHttpClient;)Landroid/net/http/AndroidHttpClient$LoggingConfiguration;

    move-result-object v0

    .line 390
    .local v0, configuration:Landroid/net/http/AndroidHttpClient$LoggingConfiguration;
    if-eqz v0, :cond_1c

    #calls: Landroid/net/http/AndroidHttpClient$LoggingConfiguration;->isLoggable()Z
    invoke-static {v0}, Landroid/net/http/AndroidHttpClient$LoggingConfiguration;->access$400(Landroid/net/http/AndroidHttpClient$LoggingConfiguration;)Z

    move-result v1

    if-eqz v1, :cond_1c

    instance-of v1, p1, Lorg/apache/http/client/methods/HttpUriRequest;

    if-eqz v1, :cond_1c

    .line 395
    check-cast p1, Lorg/apache/http/client/methods/HttpUriRequest;

    .end local p1
    const/4 v1, 0x0

    #calls: Landroid/net/http/AndroidHttpClient;->toCurl(Lorg/apache/http/client/methods/HttpUriRequest;Z)Ljava/lang/String;
    invoke-static {p1, v1}, Landroid/net/http/AndroidHttpClient;->access$500(Lorg/apache/http/client/methods/HttpUriRequest;Z)Ljava/lang/String;

    move-result-object v1

    #calls: Landroid/net/http/AndroidHttpClient$LoggingConfiguration;->println(Ljava/lang/String;)V
    invoke-static {v0, v1}, Landroid/net/http/AndroidHttpClient$LoggingConfiguration;->access$600(Landroid/net/http/AndroidHttpClient$LoggingConfiguration;Ljava/lang/String;)V

    .line 397
    :cond_1c
    return-void
.end method
