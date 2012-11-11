.class abstract Landroid/net/http/Connection;
.super Ljava/lang/Object;
.source "Connection.java"


# static fields
.field private static final DONE:I = 0x3

.field private static final DRAIN:I = 0x2

.field private static final HTTP_CONNECTION:Ljava/lang/String; = "http.connection"

.field private static final MAX_PIPE:I = 0x3

.field private static final MIN_PIPE:I = 0x2

.field private static final READ:I = 0x1

.field private static final RETRY_REQUEST_LIMIT:I = 0x2

.field private static final SEND:I = 0x0

.field static final SOCKET_TIMEOUT:I = 0xea60

.field private static STATE_CANCEL_REQUESTED:I

.field private static STATE_NORMAL:I

.field private static final states:[Ljava/lang/String;


# instance fields
.field private mActive:I

.field private mBuf:[B

.field private mCanPersist:Z

.field protected mCertificate:Landroid/net/http/SslCertificate;

.field mContext:Landroid/content/Context;

.field mHost:Lorg/apache/http/HttpHost;

.field protected mHttpClientConnection:Landroid/net/http/AndroidHttpClientConnection;

.field private mHttpContext:Lorg/apache/http/protocol/HttpContext;

.field mRequestFeeder:Landroid/net/http/RequestFeeder;


# direct methods
.method static constructor <clinit>()V
    .registers 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    const/4 v0, 0x4

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "SEND"

    aput-object v1, v0, v3

    const-string v1, "READ"

    aput-object v1, v0, v4

    const/4 v1, 0x2

    const-string v2, "DRAIN"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "DONE"

    aput-object v2, v0, v1

    sput-object v0, Landroid/net/http/Connection;->states:[Ljava/lang/String;

    sput v3, Landroid/net/http/Connection;->STATE_NORMAL:I

    sput v4, Landroid/net/http/Connection;->STATE_CANCEL_REQUESTED:I

    return-void
.end method

.method protected constructor <init>(Landroid/content/Context;Lorg/apache/http/HttpHost;Landroid/net/http/RequestFeeder;)V
    .registers 6
    .parameter "context"
    .parameter "host"
    .parameter "requestFeeder"

    .prologue
    const/4 v1, 0x0

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object v1, p0, Landroid/net/http/Connection;->mHttpClientConnection:Landroid/net/http/AndroidHttpClientConnection;

    iput-object v1, p0, Landroid/net/http/Connection;->mCertificate:Landroid/net/http/SslCertificate;

    sget v0, Landroid/net/http/Connection;->STATE_NORMAL:I

    iput v0, p0, Landroid/net/http/Connection;->mActive:I

    iput-object p1, p0, Landroid/net/http/Connection;->mContext:Landroid/content/Context;

    iput-object p2, p0, Landroid/net/http/Connection;->mHost:Lorg/apache/http/HttpHost;

    iput-object p3, p0, Landroid/net/http/Connection;->mRequestFeeder:Landroid/net/http/RequestFeeder;

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/net/http/Connection;->mCanPersist:Z

    new-instance v0, Lorg/apache/http/protocol/BasicHttpContext;

    invoke-direct {v0, v1}, Lorg/apache/http/protocol/BasicHttpContext;-><init>(Lorg/apache/http/protocol/HttpContext;)V

    iput-object v0, p0, Landroid/net/http/Connection;->mHttpContext:Lorg/apache/http/protocol/HttpContext;

    return-void
.end method

.method private clearPipe(Ljava/util/LinkedList;)Z
    .registers 7
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/LinkedList",
            "<",
            "Landroid/net/http/Request;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .local p1, pipe:Ljava/util/LinkedList;,"Ljava/util/LinkedList<Landroid/net/http/Request;>;"
    const/4 v0, 0x1

    .local v0, empty:Z
    iget-object v3, p0, Landroid/net/http/Connection;->mRequestFeeder:Landroid/net/http/RequestFeeder;

    monitor-enter v3

    :goto_4
    :try_start_4
    invoke-virtual {p1}, Ljava/util/LinkedList;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_17

    invoke-virtual {p1}, Ljava/util/LinkedList;->removeLast()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/net/http/Request;

    .local v1, tReq:Landroid/net/http/Request;
    iget-object v2, p0, Landroid/net/http/Connection;->mRequestFeeder:Landroid/net/http/RequestFeeder;

    invoke-interface {v2, v1}, Landroid/net/http/RequestFeeder;->requeueRequest(Landroid/net/http/Request;)V

    const/4 v0, 0x0

    goto :goto_4

    .end local v1           #tReq:Landroid/net/http/Request;
    :cond_17
    if-eqz v0, :cond_24

    iget-object v2, p0, Landroid/net/http/Connection;->mRequestFeeder:Landroid/net/http/RequestFeeder;

    iget-object v4, p0, Landroid/net/http/Connection;->mHost:Lorg/apache/http/HttpHost;

    invoke-interface {v2, v4}, Landroid/net/http/RequestFeeder;->haveRequest(Lorg/apache/http/HttpHost;)Z

    move-result v2

    if-nez v2, :cond_26

    const/4 v0, 0x1

    :cond_24
    :goto_24
    monitor-exit v3

    return v0

    :cond_26
    const/4 v0, 0x0

    goto :goto_24

    :catchall_28
    move-exception v2

    monitor-exit v3
    :try_end_2a
    .catchall {:try_start_4 .. :try_end_2a} :catchall_28

    throw v2
.end method

.method static getConnection(Landroid/content/Context;Lorg/apache/http/HttpHost;Lorg/apache/http/HttpHost;Landroid/net/http/RequestFeeder;)Landroid/net/http/Connection;
    .registers 6
    .parameter "context"
    .parameter "host"
    .parameter "proxy"
    .parameter "requestFeeder"

    .prologue
    invoke-virtual {p1}, Lorg/apache/http/HttpHost;->getSchemeName()Ljava/lang/String;

    move-result-object v0

    const-string v1, "http"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_12

    new-instance v0, Landroid/net/http/HttpConnection;

    invoke-direct {v0, p0, p1, p3}, Landroid/net/http/HttpConnection;-><init>(Landroid/content/Context;Lorg/apache/http/HttpHost;Landroid/net/http/RequestFeeder;)V

    :goto_11
    return-object v0

    :cond_12
    new-instance v0, Landroid/net/http/HttpsConnection;

    invoke-direct {v0, p0, p1, p2, p3}, Landroid/net/http/HttpsConnection;-><init>(Landroid/content/Context;Lorg/apache/http/HttpHost;Lorg/apache/http/HttpHost;Landroid/net/http/RequestFeeder;)V

    goto :goto_11
.end method

.method private httpFailure(Landroid/net/http/Request;ILjava/lang/Exception;)Z
    .registers 9
    .parameter "req"
    .parameter "errorId"
    .parameter "e"

    .prologue
    const/4 v2, 0x1

    .local v2, ret:Z
    iget v3, p1, Landroid/net/http/Request;->mFailCount:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p1, Landroid/net/http/Request;->mFailCount:I

    const/4 v4, 0x2

    if-lt v3, v4, :cond_1b

    const/4 v2, 0x0

    if-gez p2, :cond_26

    iget-object v3, p0, Landroid/net/http/Connection;->mContext:Landroid/content/Context;

    invoke-static {p2, v3}, Landroid/net/http/ErrorStrings;->getString(ILandroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    .local v1, error:Ljava/lang/String;
    :goto_13
    iget-object v3, p1, Landroid/net/http/Request;->mEventHandler:Landroid/net/http/EventHandler;

    invoke-interface {v3, p2, v1}, Landroid/net/http/EventHandler;->error(ILjava/lang/String;)V

    invoke-virtual {p1}, Landroid/net/http/Request;->complete()V

    .end local v1           #error:Ljava/lang/String;
    :cond_1b
    invoke-virtual {p0}, Landroid/net/http/Connection;->closeConnection()V

    iget-object v3, p0, Landroid/net/http/Connection;->mHttpContext:Lorg/apache/http/protocol/HttpContext;

    const-string v4, "http.connection"

    invoke-interface {v3, v4}, Lorg/apache/http/protocol/HttpContext;->removeAttribute(Ljava/lang/String;)Ljava/lang/Object;

    return v2

    :cond_26
    invoke-virtual {p3}, Ljava/lang/Exception;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    .local v0, cause:Ljava/lang/Throwable;
    if-eqz v0, :cond_31

    invoke-virtual {v0}, Ljava/lang/Throwable;->toString()Ljava/lang/String;

    move-result-object v1

    .restart local v1       #error:Ljava/lang/String;
    :goto_30
    goto :goto_13

    .end local v1           #error:Ljava/lang/String;
    :cond_31
    invoke-virtual {p3}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    goto :goto_30
.end method

.method private keepAlive(Lorg/apache/http/HttpEntity;Lorg/apache/http/ProtocolVersion;ILorg/apache/http/protocol/HttpContext;)Z
    .registers 12
    .parameter "entity"
    .parameter "ver"
    .parameter "connType"
    .parameter "context"

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    const-string v3, "http.connection"

    invoke-interface {p4, v3}, Lorg/apache/http/protocol/HttpContext;->getAttribute(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/apache/http/HttpConnection;

    .local v0, conn:Lorg/apache/http/HttpConnection;
    if-eqz v0, :cond_13

    invoke-interface {v0}, Lorg/apache/http/HttpConnection;->isOpen()Z

    move-result v3

    if-nez v3, :cond_13

    :cond_12
    :goto_12
    return v2

    :cond_13
    if-eqz p1, :cond_2d

    invoke-interface {p1}, Lorg/apache/http/HttpEntity;->getContentLength()J

    move-result-wide v3

    const-wide/16 v5, 0x0

    cmp-long v3, v3, v5

    if-gez v3, :cond_2d

    invoke-interface {p1}, Lorg/apache/http/HttpEntity;->isChunked()Z

    move-result v3

    if-eqz v3, :cond_12

    sget-object v3, Lorg/apache/http/HttpVersion;->HTTP_1_0:Lorg/apache/http/HttpVersion;

    invoke-virtual {p2, v3}, Lorg/apache/http/ProtocolVersion;->lessEquals(Lorg/apache/http/ProtocolVersion;)Z

    move-result v3

    if-nez v3, :cond_12

    :cond_2d
    if-eq p3, v1, :cond_12

    const/4 v3, 0x2

    if-ne p3, v3, :cond_34

    move v2, v1

    goto :goto_12

    :cond_34
    sget-object v3, Lorg/apache/http/HttpVersion;->HTTP_1_0:Lorg/apache/http/HttpVersion;

    invoke-virtual {p2, v3}, Lorg/apache/http/ProtocolVersion;->lessEquals(Lorg/apache/http/ProtocolVersion;)Z

    move-result v3

    if-nez v3, :cond_3e

    :goto_3c
    move v2, v1

    goto :goto_12

    :cond_3e
    move v1, v2

    goto :goto_3c
.end method

.method private openHttpConnection(Landroid/net/http/Request;)Z
    .registers 13
    .parameter "req"

    .prologue
    const/4 v5, 0x1

    const/4 v6, 0x0

    const/4 v10, 0x2

    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v3

    .local v3, now:J
    const/4 v1, 0x0

    .local v1, error:I
    const/4 v2, 0x0

    .local v2, exception:Ljava/lang/Exception;
    const/4 v7, 0x0

    :try_start_a
    iput-object v7, p0, Landroid/net/http/Connection;->mCertificate:Landroid/net/http/SslCertificate;

    invoke-virtual {p0, p1}, Landroid/net/http/Connection;->openConnection(Landroid/net/http/Request;)Landroid/net/http/AndroidHttpClientConnection;

    move-result-object v7

    iput-object v7, p0, Landroid/net/http/Connection;->mHttpClientConnection:Landroid/net/http/AndroidHttpClientConnection;

    iget-object v7, p0, Landroid/net/http/Connection;->mHttpClientConnection:Landroid/net/http/AndroidHttpClientConnection;

    if-eqz v7, :cond_2b

    iget-object v7, p0, Landroid/net/http/Connection;->mHttpClientConnection:Landroid/net/http/AndroidHttpClientConnection;

    const v8, 0xea60

    invoke-virtual {v7, v8}, Landroid/net/http/AndroidHttpClientConnection;->setSocketTimeout(I)V

    iget-object v7, p0, Landroid/net/http/Connection;->mHttpContext:Lorg/apache/http/protocol/HttpContext;

    const-string v8, "http.connection"

    iget-object v9, p0, Landroid/net/http/Connection;->mHttpClientConnection:Landroid/net/http/AndroidHttpClientConnection;

    invoke-interface {v7, v8, v9}, Lorg/apache/http/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    :goto_27
    if-nez v1, :cond_48

    move v6, v5

    :goto_2a
    return v6

    :cond_2b
    const/4 v7, 0x2

    iput v7, p1, Landroid/net/http/Request;->mFailCount:I
    :try_end_2e
    .catch Ljava/net/UnknownHostException; {:try_start_a .. :try_end_2e} :catch_2f
    .catch Ljava/lang/IllegalArgumentException; {:try_start_a .. :try_end_2e} :catch_33
    .catch Landroid/net/http/SSLConnectionClosedByUserException; {:try_start_a .. :try_end_2e} :catch_39
    .catch Ljavax/net/ssl/SSLHandshakeException; {:try_start_a .. :try_end_2e} :catch_3d
    .catch Ljava/io/IOException; {:try_start_a .. :try_end_2e} :catch_44

    goto :goto_2a

    :catch_2f
    move-exception v0

    .local v0, e:Ljava/net/UnknownHostException;
    const/4 v1, -0x2

    move-object v2, v0

    goto :goto_27

    .end local v0           #e:Ljava/net/UnknownHostException;
    :catch_33
    move-exception v0

    .local v0, e:Ljava/lang/IllegalArgumentException;
    const/4 v1, -0x6

    iput v10, p1, Landroid/net/http/Request;->mFailCount:I

    move-object v2, v0

    goto :goto_27

    .end local v0           #e:Ljava/lang/IllegalArgumentException;
    :catch_39
    move-exception v0

    .local v0, e:Landroid/net/http/SSLConnectionClosedByUserException;
    iput v10, p1, Landroid/net/http/Request;->mFailCount:I

    goto :goto_2a

    .end local v0           #e:Landroid/net/http/SSLConnectionClosedByUserException;
    :catch_3d
    move-exception v0

    .local v0, e:Ljavax/net/ssl/SSLHandshakeException;
    iput v10, p1, Landroid/net/http/Request;->mFailCount:I

    const/16 v1, -0xb

    move-object v2, v0

    goto :goto_27

    .end local v0           #e:Ljavax/net/ssl/SSLHandshakeException;
    :catch_44
    move-exception v0

    .local v0, e:Ljava/io/IOException;
    const/4 v1, -0x6

    move-object v2, v0

    goto :goto_27

    .end local v0           #e:Ljava/io/IOException;
    :cond_48
    iget v7, p1, Landroid/net/http/Request;->mFailCount:I

    if-ge v7, v10, :cond_5b

    iget-object v7, p0, Landroid/net/http/Connection;->mRequestFeeder:Landroid/net/http/RequestFeeder;

    invoke-interface {v7, p1}, Landroid/net/http/RequestFeeder;->requeueRequest(Landroid/net/http/Request;)V

    iget v7, p1, Landroid/net/http/Request;->mFailCount:I

    add-int/lit8 v7, v7, 0x1

    iput v7, p1, Landroid/net/http/Request;->mFailCount:I

    :goto_57
    if-nez v1, :cond_5f

    :goto_59
    move v6, v5

    goto :goto_2a

    :cond_5b
    invoke-direct {p0, p1, v1, v2}, Landroid/net/http/Connection;->httpFailure(Landroid/net/http/Request;ILjava/lang/Exception;)Z

    goto :goto_57

    :cond_5f
    move v5, v6

    goto :goto_59
.end method


# virtual methods
.method cancel()V
    .registers 2

    .prologue
    sget v0, Landroid/net/http/Connection;->STATE_CANCEL_REQUESTED:I

    iput v0, p0, Landroid/net/http/Connection;->mActive:I

    invoke-virtual {p0}, Landroid/net/http/Connection;->closeConnection()V

    return-void
.end method

.method abstract closeConnection()V
.end method

.method getBuf()[B
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/net/http/Connection;->mBuf:[B

    if-nez v0, :cond_a

    const/16 v0, 0x2000

    new-array v0, v0, [B

    iput-object v0, p0, Landroid/net/http/Connection;->mBuf:[B

    :cond_a
    iget-object v0, p0, Landroid/net/http/Connection;->mBuf:[B

    return-object v0
.end method

.method getCanPersist()Z
    .registers 2

    .prologue
    iget-boolean v0, p0, Landroid/net/http/Connection;->mCanPersist:Z

    return v0
.end method

.method getCertificate()Landroid/net/http/SslCertificate;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/net/http/Connection;->mCertificate:Landroid/net/http/SslCertificate;

    return-object v0
.end method

.method getHost()Lorg/apache/http/HttpHost;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/net/http/Connection;->mHost:Lorg/apache/http/HttpHost;

    return-object v0
.end method

.method getHttpContext()Lorg/apache/http/protocol/HttpContext;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/net/http/Connection;->mHttpContext:Lorg/apache/http/protocol/HttpContext;

    return-object v0
.end method

.method abstract getScheme()Ljava/lang/String;
.end method

.method abstract openConnection(Landroid/net/http/Request;)Landroid/net/http/AndroidHttpClientConnection;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method processRequests(Landroid/net/http/Request;)V
    .registers 16
    .parameter "firstRequest"

    .prologue
    const/4 v10, 0x3

    const/4 v11, 0x0

    const/4 v8, 0x0

    .local v8, req:Landroid/net/http/Request;
    const/4 v2, 0x0

    .local v2, error:I
    const/4 v3, 0x0

    .local v3, exception:Ljava/lang/Exception;
    new-instance v6, Ljava/util/LinkedList;

    invoke-direct {v6}, Ljava/util/LinkedList;-><init>()V

    .local v6, pipe:Ljava/util/LinkedList;,"Ljava/util/LinkedList<Landroid/net/http/Request;>;"
    const/4 v5, 0x2

    .local v5, minPipe:I
    const/4 v4, 0x3

    .local v4, maxPipe:I
    const/4 v9, 0x0

    .local v9, state:I
    :cond_d
    :goto_d
    if-eq v9, v10, :cond_105

    iget v12, p0, Landroid/net/http/Connection;->mActive:I

    sget v13, Landroid/net/http/Connection;->STATE_CANCEL_REQUESTED:I

    if-ne v12, v13, :cond_1e

    const-wide/16 v12, 0x64

    :try_start_17
    invoke-static {v12, v13}, Ljava/lang/Thread;->sleep(J)V
    :try_end_1a
    .catch Ljava/lang/InterruptedException; {:try_start_17 .. :try_end_1a} :catch_102

    :goto_1a
    sget v12, Landroid/net/http/Connection;->STATE_NORMAL:I

    iput v12, p0, Landroid/net/http/Connection;->mActive:I

    :cond_1e
    packed-switch v9, :pswitch_data_106

    goto :goto_d

    :pswitch_22
    invoke-virtual {v6}, Ljava/util/LinkedList;->size()I

    move-result v12

    if-ne v12, v4, :cond_2a

    const/4 v9, 0x1

    goto :goto_d

    :cond_2a
    if-nez p1, :cond_38

    iget-object v12, p0, Landroid/net/http/Connection;->mRequestFeeder:Landroid/net/http/RequestFeeder;

    iget-object v13, p0, Landroid/net/http/Connection;->mHost:Lorg/apache/http/HttpHost;

    invoke-interface {v12, v13}, Landroid/net/http/RequestFeeder;->getRequest(Lorg/apache/http/HttpHost;)Landroid/net/http/Request;

    move-result-object v8

    :goto_34
    if-nez v8, :cond_3b

    const/4 v9, 0x2

    goto :goto_d

    :cond_38
    move-object v8, p1

    const/4 p1, 0x0

    goto :goto_34

    :cond_3b
    invoke-virtual {v8, p0}, Landroid/net/http/Request;->setConnection(Landroid/net/http/Connection;)V

    iget-boolean v12, v8, Landroid/net/http/Request;->mCancelled:Z

    if-eqz v12, :cond_46

    invoke-virtual {v8}, Landroid/net/http/Request;->complete()V

    goto :goto_d

    :cond_46
    iget-object v12, p0, Landroid/net/http/Connection;->mHttpClientConnection:Landroid/net/http/AndroidHttpClientConnection;

    if-eqz v12, :cond_52

    iget-object v12, p0, Landroid/net/http/Connection;->mHttpClientConnection:Landroid/net/http/AndroidHttpClientConnection;

    invoke-virtual {v12}, Landroid/net/http/AndroidHttpClientConnection;->isOpen()Z

    move-result v12

    if-nez v12, :cond_5a

    :cond_52
    invoke-direct {p0, v8}, Landroid/net/http/Connection;->openHttpConnection(Landroid/net/http/Request;)Z

    move-result v12

    if-nez v12, :cond_5a

    const/4 v9, 0x3

    goto :goto_d

    :cond_5a
    iget-object v12, v8, Landroid/net/http/Request;->mEventHandler:Landroid/net/http/EventHandler;

    iget-object v13, p0, Landroid/net/http/Connection;->mCertificate:Landroid/net/http/SslCertificate;

    invoke-interface {v12, v13}, Landroid/net/http/EventHandler;->certificate(Landroid/net/http/SslCertificate;)V

    :try_start_61
    iget-object v12, p0, Landroid/net/http/Connection;->mHttpClientConnection:Landroid/net/http/AndroidHttpClientConnection;

    invoke-virtual {v8, v12}, Landroid/net/http/Request;->sendRequest(Landroid/net/http/AndroidHttpClientConnection;)V
    :try_end_66
    .catch Lorg/apache/http/HttpException; {:try_start_61 .. :try_end_66} :catch_80
    .catch Ljava/io/IOException; {:try_start_61 .. :try_end_66} :catch_84
    .catch Ljava/lang/IllegalStateException; {:try_start_61 .. :try_end_66} :catch_88

    :goto_66
    if-eqz v3, :cond_8e

    invoke-direct {p0, v8, v2, v3}, Landroid/net/http/Connection;->httpFailure(Landroid/net/http/Request;ILjava/lang/Exception;)Z

    move-result v12

    if-eqz v12, :cond_75

    iget-boolean v12, v8, Landroid/net/http/Request;->mCancelled:Z

    if-nez v12, :cond_75

    invoke-virtual {v6, v8}, Ljava/util/LinkedList;->addLast(Ljava/lang/Object;)V

    :cond_75
    const/4 v3, 0x0

    invoke-direct {p0, v6}, Landroid/net/http/Connection;->clearPipe(Ljava/util/LinkedList;)Z

    move-result v12

    if-eqz v12, :cond_8c

    move v9, v10

    :goto_7d
    const/4 v4, 0x1

    move v5, v4

    goto :goto_d

    :catch_80
    move-exception v0

    .local v0, e:Lorg/apache/http/HttpException;
    move-object v3, v0

    const/4 v2, -0x1

    goto :goto_66

    .end local v0           #e:Lorg/apache/http/HttpException;
    :catch_84
    move-exception v0

    .local v0, e:Ljava/io/IOException;
    move-object v3, v0

    const/4 v2, -0x7

    goto :goto_66

    .end local v0           #e:Ljava/io/IOException;
    :catch_88
    move-exception v0

    .local v0, e:Ljava/lang/IllegalStateException;
    move-object v3, v0

    const/4 v2, -0x7

    goto :goto_66

    .end local v0           #e:Ljava/lang/IllegalStateException;
    :cond_8c
    move v9, v11

    goto :goto_7d

    :cond_8e
    invoke-virtual {v6, v8}, Ljava/util/LinkedList;->addLast(Ljava/lang/Object;)V

    iget-boolean v12, p0, Landroid/net/http/Connection;->mCanPersist:Z

    if-nez v12, :cond_d

    const/4 v9, 0x1

    goto/16 :goto_d

    :pswitch_98
    iget-object v12, p0, Landroid/net/http/Connection;->mRequestFeeder:Landroid/net/http/RequestFeeder;

    iget-object v13, p0, Landroid/net/http/Connection;->mHost:Lorg/apache/http/HttpHost;

    invoke-interface {v12, v13}, Landroid/net/http/RequestFeeder;->haveRequest(Lorg/apache/http/HttpHost;)Z

    move-result v12

    if-nez v12, :cond_b5

    const/4 v1, 0x1

    .local v1, empty:Z
    :goto_a3
    invoke-virtual {v6}, Ljava/util/LinkedList;->size()I

    move-result v7

    .local v7, pipeSize:I
    const/4 v12, 0x2

    if-eq v9, v12, :cond_b7

    if-ge v7, v5, :cond_b7

    if-nez v1, :cond_b7

    iget-boolean v12, p0, Landroid/net/http/Connection;->mCanPersist:Z

    if-eqz v12, :cond_b7

    const/4 v9, 0x0

    goto/16 :goto_d

    .end local v1           #empty:Z
    .end local v7           #pipeSize:I
    :cond_b5
    move v1, v11

    goto :goto_a3

    .restart local v1       #empty:Z
    .restart local v7       #pipeSize:I
    :cond_b7
    if-nez v7, :cond_c0

    if-eqz v1, :cond_be

    move v9, v10

    :goto_bc
    goto/16 :goto_d

    :cond_be
    move v9, v11

    goto :goto_bc

    :cond_c0
    invoke-virtual {v6}, Ljava/util/LinkedList;->removeFirst()Ljava/lang/Object;

    move-result-object v8

    .end local v8           #req:Landroid/net/http/Request;
    check-cast v8, Landroid/net/http/Request;

    .restart local v8       #req:Landroid/net/http/Request;
    :try_start_c6
    iget-object v12, p0, Landroid/net/http/Connection;->mHttpClientConnection:Landroid/net/http/AndroidHttpClientConnection;

    invoke-virtual {v8, v12}, Landroid/net/http/Request;->readResponse(Landroid/net/http/AndroidHttpClientConnection;)V
    :try_end_cb
    .catch Lorg/apache/http/ParseException; {:try_start_c6 .. :try_end_cb} :catch_f6
    .catch Ljava/io/IOException; {:try_start_c6 .. :try_end_cb} :catch_fa
    .catch Ljava/lang/IllegalStateException; {:try_start_c6 .. :try_end_cb} :catch_fe

    :goto_cb
    if-eqz v3, :cond_e0

    invoke-direct {p0, v8, v2, v3}, Landroid/net/http/Connection;->httpFailure(Landroid/net/http/Request;ILjava/lang/Exception;)Z

    move-result v12

    if-eqz v12, :cond_dd

    iget-boolean v12, v8, Landroid/net/http/Request;->mCancelled:Z

    if-nez v12, :cond_dd

    invoke-virtual {v8}, Landroid/net/http/Request;->reset()V

    invoke-virtual {v6, v8}, Ljava/util/LinkedList;->addFirst(Ljava/lang/Object;)V

    :cond_dd
    const/4 v3, 0x0

    iput-boolean v11, p0, Landroid/net/http/Connection;->mCanPersist:Z

    :cond_e0
    iget-boolean v12, p0, Landroid/net/http/Connection;->mCanPersist:Z

    if-nez v12, :cond_d

    invoke-virtual {p0}, Landroid/net/http/Connection;->closeConnection()V

    iget-object v12, p0, Landroid/net/http/Connection;->mHttpContext:Lorg/apache/http/protocol/HttpContext;

    const-string v13, "http.connection"

    invoke-interface {v12, v13}, Lorg/apache/http/protocol/HttpContext;->removeAttribute(Ljava/lang/String;)Ljava/lang/Object;

    invoke-direct {p0, v6}, Landroid/net/http/Connection;->clearPipe(Ljava/util/LinkedList;)Z

    const/4 v4, 0x1

    move v5, v4

    const/4 v9, 0x0

    goto/16 :goto_d

    :catch_f6
    move-exception v0

    .local v0, e:Lorg/apache/http/ParseException;
    move-object v3, v0

    const/4 v2, -0x7

    goto :goto_cb

    .end local v0           #e:Lorg/apache/http/ParseException;
    :catch_fa
    move-exception v0

    .local v0, e:Ljava/io/IOException;
    move-object v3, v0

    const/4 v2, -0x7

    goto :goto_cb

    .end local v0           #e:Ljava/io/IOException;
    :catch_fe
    move-exception v0

    .local v0, e:Ljava/lang/IllegalStateException;
    move-object v3, v0

    const/4 v2, -0x7

    goto :goto_cb

    .end local v0           #e:Ljava/lang/IllegalStateException;
    .end local v1           #empty:Z
    .end local v7           #pipeSize:I
    :catch_102
    move-exception v12

    goto/16 :goto_1a

    :cond_105
    return-void

    :pswitch_data_106
    .packed-switch 0x0
        :pswitch_22
        :pswitch_98
        :pswitch_98
    .end packed-switch
.end method

.method setCanPersist(Lorg/apache/http/HttpEntity;Lorg/apache/http/ProtocolVersion;I)V
    .registers 5
    .parameter "entity"
    .parameter "ver"
    .parameter "connType"

    .prologue
    iget-object v0, p0, Landroid/net/http/Connection;->mHttpContext:Lorg/apache/http/protocol/HttpContext;

    invoke-direct {p0, p1, p2, p3, v0}, Landroid/net/http/Connection;->keepAlive(Lorg/apache/http/HttpEntity;Lorg/apache/http/ProtocolVersion;ILorg/apache/http/protocol/HttpContext;)Z

    move-result v0

    iput-boolean v0, p0, Landroid/net/http/Connection;->mCanPersist:Z

    return-void
.end method

.method setCanPersist(Z)V
    .registers 2
    .parameter "canPersist"

    .prologue
    iput-boolean p1, p0, Landroid/net/http/Connection;->mCanPersist:Z

    return-void
.end method

.method public declared-synchronized toString()Ljava/lang/String;
    .registers 2

    .prologue
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroid/net/http/Connection;->mHost:Lorg/apache/http/HttpHost;

    invoke-virtual {v0}, Lorg/apache/http/HttpHost;->toString()Ljava/lang/String;
    :try_end_6
    .catchall {:try_start_1 .. :try_end_6} :catchall_9

    move-result-object v0

    monitor-exit p0

    return-object v0

    :catchall_9
    move-exception v0

    monitor-exit p0

    throw v0
.end method
