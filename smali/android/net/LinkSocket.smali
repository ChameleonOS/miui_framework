.class public Landroid/net/LinkSocket;
.super Ljava/net/Socket;
.source "LinkSocket.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/net/LinkSocket$LinkRequestReason;
    }
.end annotation


# static fields
.field private static final DBG:Z = true

.field private static final TAG:Ljava/lang/String; = "LinkSocket"


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 41
    invoke-direct {p0}, Ljava/net/Socket;-><init>()V

    .line 42
    const-string v0, "LinkSocket() EX"

    invoke-static {v0}, Landroid/net/LinkSocket;->log(Ljava/lang/String;)V

    .line 43
    return-void
.end method

.method public constructor <init>(Landroid/net/LinkSocketNotifier;)V
    .registers 3
    .parameter "notifier"

    .prologue
    .line 49
    invoke-direct {p0}, Ljava/net/Socket;-><init>()V

    .line 50
    const-string v0, "LinkSocket(notifier) EX"

    invoke-static {v0}, Landroid/net/LinkSocket;->log(Ljava/lang/String;)V

    .line 51
    return-void
.end method

.method public constructor <init>(Landroid/net/LinkSocketNotifier;Landroid/net/Proxy;)V
    .registers 4
    .parameter "notifier"
    .parameter "proxy"

    .prologue
    .line 61
    invoke-direct {p0}, Ljava/net/Socket;-><init>()V

    .line 62
    const-string v0, "LinkSocket(notifier, proxy) EX"

    invoke-static {v0}, Landroid/net/LinkSocket;->log(Ljava/lang/String;)V

    .line 63
    return-void
.end method

.method protected static log(Ljava/lang/String;)V
    .registers 2
    .parameter "s"

    .prologue
    .line 274
    const-string v0, "LinkSocket"

    invoke-static {v0, p0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 275
    return-void
.end method


# virtual methods
.method public bind(Ljava/net/SocketAddress;)V
    .registers 4
    .parameter "localAddr"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/UnsupportedOperationException;
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 252
    const-string v0, "bind(localAddr) EX throws IOException"

    invoke-static {v0}, Landroid/net/LinkSocket;->log(Ljava/lang/String;)V

    .line 253
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "bind is deprecated for LinkSocket"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public declared-synchronized close()V
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 226
    monitor-enter p0

    :try_start_1
    const-string v0, "close() EX"

    invoke-static {v0}, Landroid/net/LinkSocket;->log(Ljava/lang/String;)V
    :try_end_6
    .catchall {:try_start_1 .. :try_end_6} :catchall_8

    .line 227
    monitor-exit p0

    return-void

    .line 226
    :catchall_8
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public connect()V
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 216
    const-string v0, "connect() EX"

    invoke-static {v0}, Landroid/net/LinkSocket;->log(Ljava/lang/String;)V

    .line 217
    return-void
.end method

.method public connect(I)V
    .registers 3
    .parameter "timeout"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 206
    const-string v0, "connect(timeout) EX"

    invoke-static {v0}, Landroid/net/LinkSocket;->log(Ljava/lang/String;)V

    .line 207
    return-void
.end method

.method public connect(Ljava/lang/String;I)V
    .registers 4
    .parameter "dstName"
    .parameter "dstPort"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/UnknownHostException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 159
    const-string v0, "connect(dstName, dstPort, timeout) EX"

    invoke-static {v0}, Landroid/net/LinkSocket;->log(Ljava/lang/String;)V

    .line 160
    return-void
.end method

.method public connect(Ljava/lang/String;II)V
    .registers 5
    .parameter "dstName"
    .parameter "dstPort"
    .parameter "timeout"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/UnknownHostException;,
            Ljava/io/IOException;,
            Ljava/net/SocketTimeoutException;
        }
    .end annotation

    .prologue
    .line 145
    const-string v0, "connect(dstName, dstPort, timeout) EX"

    invoke-static {v0}, Landroid/net/LinkSocket;->log(Ljava/lang/String;)V

    .line 146
    return-void
.end method

.method public connect(Ljava/net/SocketAddress;)V
    .registers 3
    .parameter "remoteAddr"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 195
    const-string v0, "connect(remoteAddr) EX DEPRECATED"

    invoke-static {v0}, Landroid/net/LinkSocket;->log(Ljava/lang/String;)V

    .line 196
    return-void
.end method

.method public connect(Ljava/net/SocketAddress;I)V
    .registers 4
    .parameter "remoteAddr"
    .parameter "timeout"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/net/SocketTimeoutException;
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 177
    const-string v0, "connect(remoteAddr, timeout) EX DEPRECATED"

    invoke-static {v0}, Landroid/net/LinkSocket;->log(Ljava/lang/String;)V

    .line 178
    return-void
.end method

.method public getCapabilities()Landroid/net/LinkCapabilities;
    .registers 2

    .prologue
    .line 98
    const-string v0, "getCapabilities() EX"

    invoke-static {v0}, Landroid/net/LinkSocket;->log(Ljava/lang/String;)V

    .line 99
    const/4 v0, 0x0

    return-object v0
.end method

.method public getCapabilities(Ljava/util/Set;)Landroid/net/LinkCapabilities;
    .registers 3
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Integer;",
            ">;)",
            "Landroid/net/LinkCapabilities;"
        }
    .end annotation

    .prologue
    .line 111
    .local p1, capabilities:Ljava/util/Set;,"Ljava/util/Set<Ljava/lang/Integer;>;"
    const-string v0, "getCapabilities(capabilities) EX"

    invoke-static {v0}, Landroid/net/LinkSocket;->log(Ljava/lang/String;)V

    .line 112
    new-instance v0, Landroid/net/LinkCapabilities;

    invoke-direct {v0}, Landroid/net/LinkCapabilities;-><init>()V

    return-object v0
.end method

.method public getLinkProperties()Landroid/net/LinkProperties;
    .registers 2

    .prologue
    .line 69
    const-string v0, "LinkProperties() EX"

    invoke-static {v0}, Landroid/net/LinkSocket;->log(Ljava/lang/String;)V

    .line 70
    new-instance v0, Landroid/net/LinkProperties;

    invoke-direct {v0}, Landroid/net/LinkProperties;-><init>()V

    return-object v0
.end method

.method public getNeededCapabilities()Landroid/net/LinkCapabilities;
    .registers 2

    .prologue
    .line 90
    const-string v0, "getNeeds() EX"

    invoke-static {v0}, Landroid/net/LinkSocket;->log(Ljava/lang/String;)V

    .line 91
    const/4 v0, 0x0

    return-object v0
.end method

.method public getTrackedCapabilities()Ljava/util/Set;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 128
    const-string v0, "getTrackedCapabilities(capabilities) EX"

    invoke-static {v0}, Landroid/net/LinkSocket;->log(Ljava/lang/String;)V

    .line 129
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    return-object v0
.end method

.method public requestNewLink(Landroid/net/LinkSocket$LinkRequestReason;)V
    .registers 3
    .parameter "linkRequestReason"

    .prologue
    .line 239
    const-string/jumbo v0, "requestNewLink(linkRequestReason) EX"

    invoke-static {v0}, Landroid/net/LinkSocket;->log(Ljava/lang/String;)V

    .line 240
    return-void
.end method

.method public setNeededCapabilities(Landroid/net/LinkCapabilities;)Z
    .registers 3
    .parameter "needs"

    .prologue
    .line 82
    const-string/jumbo v0, "setNeeds() EX"

    invoke-static {v0}, Landroid/net/LinkSocket;->log(Ljava/lang/String;)V

    .line 83
    const/4 v0, 0x0

    return v0
.end method

.method public setTrackedCapabilities(Ljava/util/Set;)V
    .registers 3
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 121
    .local p1, capabilities:Ljava/util/Set;,"Ljava/util/Set<Ljava/lang/Integer;>;"
    const-string/jumbo v0, "setTrackedCapabilities(capabilities) EX"

    invoke-static {v0}, Landroid/net/LinkSocket;->log(Ljava/lang/String;)V

    .line 122
    return-void
.end method
