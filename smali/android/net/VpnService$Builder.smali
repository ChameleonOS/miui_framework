.class public Landroid/net/VpnService$Builder;
.super Ljava/lang/Object;
.source "VpnService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/VpnService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "Builder"
.end annotation


# instance fields
.field private final mAddresses:Ljava/lang/StringBuilder;

.field private final mConfig:Lcom/android/internal/net/VpnConfig;

.field private final mRoutes:Ljava/lang/StringBuilder;

.field final synthetic this$0:Landroid/net/VpnService;


# direct methods
.method public constructor <init>(Landroid/net/VpnService;)V
    .registers 4
    .parameter

    .prologue
    .line 259
    iput-object p1, p0, Landroid/net/VpnService$Builder;->this$0:Landroid/net/VpnService;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 255
    new-instance v0, Lcom/android/internal/net/VpnConfig;

    invoke-direct {v0}, Lcom/android/internal/net/VpnConfig;-><init>()V

    iput-object v0, p0, Landroid/net/VpnService$Builder;->mConfig:Lcom/android/internal/net/VpnConfig;

    .line 256
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iput-object v0, p0, Landroid/net/VpnService$Builder;->mAddresses:Ljava/lang/StringBuilder;

    .line 257
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iput-object v0, p0, Landroid/net/VpnService$Builder;->mRoutes:Ljava/lang/StringBuilder;

    .line 260
    iget-object v0, p0, Landroid/net/VpnService$Builder;->mConfig:Lcom/android/internal/net/VpnConfig;

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/android/internal/net/VpnConfig;->user:Ljava/lang/String;

    .line 261
    return-void
.end method

.method private check(Ljava/net/InetAddress;I)V
    .registers 5
    .parameter "address"
    .parameter "prefixLength"

    .prologue
    .line 302
    invoke-virtual {p1}, Ljava/net/InetAddress;->isLoopbackAddress()Z

    move-result v0

    if-eqz v0, :cond_e

    .line 303
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Bad address"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 305
    :cond_e
    instance-of v0, p1, Ljava/net/Inet4Address;

    if-eqz v0, :cond_20

    .line 306
    if-ltz p2, :cond_18

    const/16 v0, 0x20

    if-le p2, v0, :cond_3a

    .line 307
    :cond_18
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Bad prefixLength"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 309
    :cond_20
    instance-of v0, p1, Ljava/net/Inet6Address;

    if-eqz v0, :cond_32

    .line 310
    if-ltz p2, :cond_2a

    const/16 v0, 0x80

    if-le p2, v0, :cond_3a

    .line 311
    :cond_2a
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Bad prefixLength"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 314
    :cond_32
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Unsupported family"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 316
    :cond_3a
    return-void
.end method


# virtual methods
.method public addAddress(Ljava/lang/String;I)Landroid/net/VpnService$Builder;
    .registers 4
    .parameter "address"
    .parameter "prefixLength"

    .prologue
    .line 345
    invoke-static {p1}, Ljava/net/InetAddress;->parseNumericAddress(Ljava/lang/String;)Ljava/net/InetAddress;

    move-result-object v0

    invoke-virtual {p0, v0, p2}, Landroid/net/VpnService$Builder;->addAddress(Ljava/net/InetAddress;I)Landroid/net/VpnService$Builder;

    move-result-object v0

    return-object v0
.end method

.method public addAddress(Ljava/net/InetAddress;I)Landroid/net/VpnService$Builder;
    .registers 8
    .parameter "address"
    .parameter "prefixLength"

    .prologue
    .line 326
    invoke-direct {p0, p1, p2}, Landroid/net/VpnService$Builder;->check(Ljava/net/InetAddress;I)V

    .line 328
    invoke-virtual {p1}, Ljava/net/InetAddress;->isAnyLocalAddress()Z

    move-result v0

    if-eqz v0, :cond_11

    .line 329
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Bad address"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 332
    :cond_11
    iget-object v0, p0, Landroid/net/VpnService$Builder;->mAddresses:Ljava/lang/StringBuilder;

    const-string v1, " %s/%d"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p1}, Ljava/net/InetAddress;->getHostAddress()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 333
    return-object p0
.end method

.method public addDnsServer(Ljava/lang/String;)Landroid/net/VpnService$Builder;
    .registers 3
    .parameter "address"

    .prologue
    .line 410
    invoke-static {p1}, Ljava/net/InetAddress;->parseNumericAddress(Ljava/lang/String;)Ljava/net/InetAddress;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/net/VpnService$Builder;->addDnsServer(Ljava/net/InetAddress;)Landroid/net/VpnService$Builder;

    move-result-object v0

    return-object v0
.end method

.method public addDnsServer(Ljava/net/InetAddress;)Landroid/net/VpnService$Builder;
    .registers 4
    .parameter "address"

    .prologue
    .line 391
    invoke-virtual {p1}, Ljava/net/InetAddress;->isLoopbackAddress()Z

    move-result v0

    if-nez v0, :cond_c

    invoke-virtual {p1}, Ljava/net/InetAddress;->isAnyLocalAddress()Z

    move-result v0

    if-eqz v0, :cond_14

    .line 392
    :cond_c
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Bad address"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 394
    :cond_14
    iget-object v0, p0, Landroid/net/VpnService$Builder;->mConfig:Lcom/android/internal/net/VpnConfig;

    iget-object v0, v0, Lcom/android/internal/net/VpnConfig;->dnsServers:Ljava/util/List;

    if-nez v0, :cond_23

    .line 395
    iget-object v0, p0, Landroid/net/VpnService$Builder;->mConfig:Lcom/android/internal/net/VpnConfig;

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, v0, Lcom/android/internal/net/VpnConfig;->dnsServers:Ljava/util/List;

    .line 397
    :cond_23
    iget-object v0, p0, Landroid/net/VpnService$Builder;->mConfig:Lcom/android/internal/net/VpnConfig;

    iget-object v0, v0, Lcom/android/internal/net/VpnConfig;->dnsServers:Ljava/util/List;

    invoke-virtual {p1}, Ljava/net/InetAddress;->getHostAddress()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 398
    return-object p0
.end method

.method public addRoute(Ljava/lang/String;I)Landroid/net/VpnService$Builder;
    .registers 4
    .parameter "address"
    .parameter "prefixLength"

    .prologue
    .line 380
    invoke-static {p1}, Ljava/net/InetAddress;->parseNumericAddress(Ljava/lang/String;)Ljava/net/InetAddress;

    move-result-object v0

    invoke-virtual {p0, v0, p2}, Landroid/net/VpnService$Builder;->addRoute(Ljava/net/InetAddress;I)Landroid/net/VpnService$Builder;

    move-result-object v0

    return-object v0
.end method

.method public addRoute(Ljava/net/InetAddress;I)Landroid/net/VpnService$Builder;
    .registers 10
    .parameter "address"
    .parameter "prefixLength"

    .prologue
    .line 355
    invoke-direct {p0, p1, p2}, Landroid/net/VpnService$Builder;->check(Ljava/net/InetAddress;I)V

    .line 357
    div-int/lit8 v1, p2, 0x8

    .line 358
    .local v1, offset:I
    invoke-virtual {p1}, Ljava/net/InetAddress;->getAddress()[B

    move-result-object v0

    .line 359
    .local v0, bytes:[B
    array-length v2, v0

    if-ge v1, v2, :cond_26

    .line 360
    aget-byte v2, v0, v1

    rem-int/lit8 v3, p2, 0x8

    shl-int/2addr v2, v3

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    :goto_14
    array-length v2, v0

    if-ge v1, v2, :cond_26

    .line 361
    aget-byte v2, v0, v1

    if-eqz v2, :cond_23

    .line 362
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "Bad address"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 360
    :cond_23
    add-int/lit8 v1, v1, 0x1

    goto :goto_14

    .line 367
    :cond_26
    iget-object v2, p0, Landroid/net/VpnService$Builder;->mRoutes:Ljava/lang/StringBuilder;

    const-string v3, " %s/%d"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {p1}, Ljava/net/InetAddress;->getHostAddress()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 368
    return-object p0
.end method

.method public addSearchDomain(Ljava/lang/String;)Landroid/net/VpnService$Builder;
    .registers 4
    .parameter "domain"

    .prologue
    .line 417
    iget-object v0, p0, Landroid/net/VpnService$Builder;->mConfig:Lcom/android/internal/net/VpnConfig;

    iget-object v0, v0, Lcom/android/internal/net/VpnConfig;->searchDomains:Ljava/util/List;

    if-nez v0, :cond_f

    .line 418
    iget-object v0, p0, Landroid/net/VpnService$Builder;->mConfig:Lcom/android/internal/net/VpnConfig;

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, v0, Lcom/android/internal/net/VpnConfig;->searchDomains:Ljava/util/List;

    .line 420
    :cond_f
    iget-object v0, p0, Landroid/net/VpnService$Builder;->mConfig:Lcom/android/internal/net/VpnConfig;

    iget-object v0, v0, Lcom/android/internal/net/VpnConfig;->searchDomains:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 421
    return-object p0
.end method

.method public establish()Landroid/os/ParcelFileDescriptor;
    .registers 4

    .prologue
    .line 468
    iget-object v1, p0, Landroid/net/VpnService$Builder;->mConfig:Lcom/android/internal/net/VpnConfig;

    iget-object v2, p0, Landroid/net/VpnService$Builder;->mAddresses:Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/android/internal/net/VpnConfig;->addresses:Ljava/lang/String;

    .line 469
    iget-object v1, p0, Landroid/net/VpnService$Builder;->mConfig:Lcom/android/internal/net/VpnConfig;

    iget-object v2, p0, Landroid/net/VpnService$Builder;->mRoutes:Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/android/internal/net/VpnConfig;->routes:Ljava/lang/String;

    .line 472
    :try_start_14
    #calls: Landroid/net/VpnService;->getService()Landroid/net/IConnectivityManager;
    invoke-static {}, Landroid/net/VpnService;->access$100()Landroid/net/IConnectivityManager;

    move-result-object v1

    iget-object v2, p0, Landroid/net/VpnService$Builder;->mConfig:Lcom/android/internal/net/VpnConfig;

    invoke-interface {v1, v2}, Landroid/net/IConnectivityManager;->establishVpn(Lcom/android/internal/net/VpnConfig;)Landroid/os/ParcelFileDescriptor;
    :try_end_1d
    .catch Landroid/os/RemoteException; {:try_start_14 .. :try_end_1d} :catch_1f

    move-result-object v1

    return-object v1

    .line 473
    :catch_1f
    move-exception v0

    .line 474
    .local v0, e:Landroid/os/RemoteException;
    new-instance v1, Ljava/lang/IllegalStateException;

    invoke-direct {v1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public setConfigureIntent(Landroid/app/PendingIntent;)Landroid/net/VpnService$Builder;
    .registers 3
    .parameter "intent"

    .prologue
    .line 279
    iget-object v0, p0, Landroid/net/VpnService$Builder;->mConfig:Lcom/android/internal/net/VpnConfig;

    iput-object p1, v0, Lcom/android/internal/net/VpnConfig;->configureIntent:Landroid/app/PendingIntent;

    .line 280
    return-object p0
.end method

.method public setMtu(I)Landroid/net/VpnService$Builder;
    .registers 4
    .parameter "mtu"

    .prologue
    .line 291
    if-gtz p1, :cond_a

    .line 292
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Bad mtu"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 294
    :cond_a
    iget-object v0, p0, Landroid/net/VpnService$Builder;->mConfig:Lcom/android/internal/net/VpnConfig;

    iput p1, v0, Lcom/android/internal/net/VpnConfig;->mtu:I

    .line 295
    return-object p0
.end method

.method public setSession(Ljava/lang/String;)Landroid/net/VpnService$Builder;
    .registers 3
    .parameter "session"

    .prologue
    .line 269
    iget-object v0, p0, Landroid/net/VpnService$Builder;->mConfig:Lcom/android/internal/net/VpnConfig;

    iput-object p1, v0, Lcom/android/internal/net/VpnConfig;->session:Ljava/lang/String;

    .line 270
    return-object p0
.end method
