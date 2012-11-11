.class public Landroid/net/DhcpInfoInternal;
.super Ljava/lang/Object;
.source "DhcpInfoInternal.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "DhcpInfoInternal"


# instance fields
.field public dns1:Ljava/lang/String;

.field public dns2:Ljava/lang/String;

.field public ipAddress:Ljava/lang/String;

.field public leaseDuration:I

.field private mRoutes:Ljava/util/Collection;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Collection",
            "<",
            "Landroid/net/RouteInfo;",
            ">;"
        }
    .end annotation
.end field

.field public prefixLength:I

.field public serverAddress:Ljava/lang/String;

.field public vendorInfo:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/net/DhcpInfoInternal;->mRoutes:Ljava/util/Collection;

    return-void
.end method

.method private convertToInt(Ljava/lang/String;)I
    .registers 4
    .parameter "addr"

    .prologue
    if-eqz p1, :cond_10

    :try_start_2
    invoke-static {p1}, Landroid/net/NetworkUtils;->numericToInetAddress(Ljava/lang/String;)Ljava/net/InetAddress;

    move-result-object v0

    .local v0, inetAddress:Ljava/net/InetAddress;
    instance-of v1, v0, Ljava/net/Inet4Address;

    if-eqz v1, :cond_10

    invoke-static {v0}, Landroid/net/NetworkUtils;->inetAddressToInt(Ljava/net/InetAddress;)I
    :try_end_d
    .catch Ljava/lang/IllegalArgumentException; {:try_start_2 .. :try_end_d} :catch_f

    move-result v1

    .end local v0           #inetAddress:Ljava/net/InetAddress;
    :goto_e
    return v1

    :catch_f
    move-exception v1

    :cond_10
    const/4 v1, 0x0

    goto :goto_e
.end method


# virtual methods
.method public addRoute(Landroid/net/RouteInfo;)V
    .registers 3
    .parameter "routeInfo"

    .prologue
    iget-object v0, p0, Landroid/net/DhcpInfoInternal;->mRoutes:Ljava/util/Collection;

    invoke-interface {v0, p1}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public getRoutes()Ljava/util/Collection;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Collection",
            "<",
            "Landroid/net/RouteInfo;",
            ">;"
        }
    .end annotation

    .prologue
    iget-object v0, p0, Landroid/net/DhcpInfoInternal;->mRoutes:Ljava/util/Collection;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableCollection(Ljava/util/Collection;)Ljava/util/Collection;

    move-result-object v0

    return-object v0
.end method

.method public hasMeteredHint()Z
    .registers 3

    .prologue
    iget-object v0, p0, Landroid/net/DhcpInfoInternal;->vendorInfo:Ljava/lang/String;

    if-eqz v0, :cond_d

    iget-object v0, p0, Landroid/net/DhcpInfoInternal;->vendorInfo:Ljava/lang/String;

    const-string v1, "ANDROID_METERED"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    :goto_c
    return v0

    :cond_d
    const/4 v0, 0x0

    goto :goto_c
.end method

.method public makeDhcpInfo()Landroid/net/DhcpInfo;
    .registers 6

    .prologue
    new-instance v2, Landroid/net/DhcpInfo;

    invoke-direct {v2}, Landroid/net/DhcpInfo;-><init>()V

    .local v2, info:Landroid/net/DhcpInfo;
    iget-object v4, p0, Landroid/net/DhcpInfoInternal;->ipAddress:Ljava/lang/String;

    invoke-direct {p0, v4}, Landroid/net/DhcpInfoInternal;->convertToInt(Ljava/lang/String;)I

    move-result v4

    iput v4, v2, Landroid/net/DhcpInfo;->ipAddress:I

    iget-object v4, p0, Landroid/net/DhcpInfoInternal;->mRoutes:Ljava/util/Collection;

    invoke-interface {v4}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :cond_13
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_33

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/net/RouteInfo;

    .local v3, route:Landroid/net/RouteInfo;
    invoke-virtual {v3}, Landroid/net/RouteInfo;->isDefaultRoute()Z

    move-result v4

    if-eqz v4, :cond_13

    invoke-virtual {v3}, Landroid/net/RouteInfo;->getGateway()Ljava/net/InetAddress;

    move-result-object v4

    invoke-virtual {v4}, Ljava/net/InetAddress;->getHostAddress()Ljava/lang/String;

    move-result-object v4

    invoke-direct {p0, v4}, Landroid/net/DhcpInfoInternal;->convertToInt(Ljava/lang/String;)I

    move-result v4

    iput v4, v2, Landroid/net/DhcpInfo;->gateway:I

    .end local v3           #route:Landroid/net/RouteInfo;
    :cond_33
    :try_start_33
    iget-object v4, p0, Landroid/net/DhcpInfoInternal;->ipAddress:Ljava/lang/String;

    invoke-static {v4}, Landroid/net/NetworkUtils;->numericToInetAddress(Ljava/lang/String;)Ljava/net/InetAddress;

    move-result-object v1

    .local v1, inetAddress:Ljava/net/InetAddress;
    iget v4, p0, Landroid/net/DhcpInfoInternal;->prefixLength:I

    invoke-static {v4}, Landroid/net/NetworkUtils;->prefixLengthToNetmaskInt(I)I

    move-result v4

    iput v4, v2, Landroid/net/DhcpInfo;->netmask:I
    :try_end_41
    .catch Ljava/lang/IllegalArgumentException; {:try_start_33 .. :try_end_41} :catch_5e

    .end local v1           #inetAddress:Ljava/net/InetAddress;
    :goto_41
    iget-object v4, p0, Landroid/net/DhcpInfoInternal;->dns1:Ljava/lang/String;

    invoke-direct {p0, v4}, Landroid/net/DhcpInfoInternal;->convertToInt(Ljava/lang/String;)I

    move-result v4

    iput v4, v2, Landroid/net/DhcpInfo;->dns1:I

    iget-object v4, p0, Landroid/net/DhcpInfoInternal;->dns2:Ljava/lang/String;

    invoke-direct {p0, v4}, Landroid/net/DhcpInfoInternal;->convertToInt(Ljava/lang/String;)I

    move-result v4

    iput v4, v2, Landroid/net/DhcpInfo;->dns2:I

    iget-object v4, p0, Landroid/net/DhcpInfoInternal;->serverAddress:Ljava/lang/String;

    invoke-direct {p0, v4}, Landroid/net/DhcpInfoInternal;->convertToInt(Ljava/lang/String;)I

    move-result v4

    iput v4, v2, Landroid/net/DhcpInfo;->serverAddress:I

    iget v4, p0, Landroid/net/DhcpInfoInternal;->leaseDuration:I

    iput v4, v2, Landroid/net/DhcpInfo;->leaseDuration:I

    return-object v2

    :catch_5e
    move-exception v4

    goto :goto_41
.end method

.method public makeLinkAddress()Landroid/net/LinkAddress;
    .registers 4

    .prologue
    iget-object v0, p0, Landroid/net/DhcpInfoInternal;->ipAddress:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_12

    const-string v0, "DhcpInfoInternal"

    const-string/jumbo v1, "makeLinkAddress with empty ipAddress"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    const/4 v0, 0x0

    :goto_11
    return-object v0

    :cond_12
    new-instance v0, Landroid/net/LinkAddress;

    iget-object v1, p0, Landroid/net/DhcpInfoInternal;->ipAddress:Ljava/lang/String;

    invoke-static {v1}, Landroid/net/NetworkUtils;->numericToInetAddress(Ljava/lang/String;)Ljava/net/InetAddress;

    move-result-object v1

    iget v2, p0, Landroid/net/DhcpInfoInternal;->prefixLength:I

    invoke-direct {v0, v1, v2}, Landroid/net/LinkAddress;-><init>(Ljava/net/InetAddress;I)V

    goto :goto_11
.end method

.method public makeLinkProperties()Landroid/net/LinkProperties;
    .registers 6

    .prologue
    new-instance v1, Landroid/net/LinkProperties;

    invoke-direct {v1}, Landroid/net/LinkProperties;-><init>()V

    .local v1, p:Landroid/net/LinkProperties;
    invoke-virtual {p0}, Landroid/net/DhcpInfoInternal;->makeLinkAddress()Landroid/net/LinkAddress;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/net/LinkProperties;->addLinkAddress(Landroid/net/LinkAddress;)V

    iget-object v3, p0, Landroid/net/DhcpInfoInternal;->mRoutes:Ljava/util/Collection;

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :goto_12
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_22

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/net/RouteInfo;

    .local v2, route:Landroid/net/RouteInfo;
    invoke-virtual {v1, v2}, Landroid/net/LinkProperties;->addRoute(Landroid/net/RouteInfo;)V

    goto :goto_12

    .end local v2           #route:Landroid/net/RouteInfo;
    :cond_22
    iget-object v3, p0, Landroid/net/DhcpInfoInternal;->dns1:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_45

    iget-object v3, p0, Landroid/net/DhcpInfoInternal;->dns1:Ljava/lang/String;

    invoke-static {v3}, Landroid/net/NetworkUtils;->numericToInetAddress(Ljava/lang/String;)Ljava/net/InetAddress;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/net/LinkProperties;->addDns(Ljava/net/InetAddress;)V

    :goto_33
    iget-object v3, p0, Landroid/net/DhcpInfoInternal;->dns2:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_4e

    iget-object v3, p0, Landroid/net/DhcpInfoInternal;->dns2:Ljava/lang/String;

    invoke-static {v3}, Landroid/net/NetworkUtils;->numericToInetAddress(Ljava/lang/String;)Ljava/net/InetAddress;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/net/LinkProperties;->addDns(Ljava/net/InetAddress;)V

    :goto_44
    return-object v1

    :cond_45
    const-string v3, "DhcpInfoInternal"

    const-string/jumbo v4, "makeLinkProperties with empty dns1!"

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_33

    :cond_4e
    const-string v3, "DhcpInfoInternal"

    const-string/jumbo v4, "makeLinkProperties with empty dns2!"

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_44
.end method

.method public toString()Ljava/lang/String;
    .registers 6

    .prologue
    const-string v2, ""

    .local v2, routeString:Ljava/lang/String;
    iget-object v3, p0, Landroid/net/DhcpInfoInternal;->mRoutes:Ljava/util/Collection;

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :goto_8
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_30

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/net/RouteInfo;

    .local v1, route:Landroid/net/RouteInfo;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v1}, Landroid/net/RouteInfo;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " | "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_8

    .end local v1           #route:Landroid/net/RouteInfo;
    :cond_30
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "addr: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Landroid/net/DhcpInfoInternal;->ipAddress:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget v4, p0, Landroid/net/DhcpInfoInternal;->prefixLength:I

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " mRoutes: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " dns: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Landroid/net/DhcpInfoInternal;->dns1:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ","

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Landroid/net/DhcpInfoInternal;->dns2:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " dhcpServer: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Landroid/net/DhcpInfoInternal;->serverAddress:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " leaseDuration: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget v4, p0, Landroid/net/DhcpInfoInternal;->leaseDuration:I

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method

.method public updateFromDhcpRequest(Landroid/net/DhcpInfoInternal;)V
    .registers 5
    .parameter "orig"

    .prologue
    if-nez p1, :cond_3

    :cond_2
    return-void

    :cond_3
    iget-object v2, p0, Landroid/net/DhcpInfoInternal;->dns1:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_f

    iget-object v2, p1, Landroid/net/DhcpInfoInternal;->dns1:Ljava/lang/String;

    iput-object v2, p0, Landroid/net/DhcpInfoInternal;->dns1:Ljava/lang/String;

    :cond_f
    iget-object v2, p0, Landroid/net/DhcpInfoInternal;->dns2:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_1b

    iget-object v2, p1, Landroid/net/DhcpInfoInternal;->dns2:Ljava/lang/String;

    iput-object v2, p0, Landroid/net/DhcpInfoInternal;->dns2:Ljava/lang/String;

    :cond_1b
    iget-object v2, p0, Landroid/net/DhcpInfoInternal;->mRoutes:Ljava/util/Collection;

    invoke-interface {v2}, Ljava/util/Collection;->size()I

    move-result v2

    if-nez v2, :cond_2

    invoke-virtual {p1}, Landroid/net/DhcpInfoInternal;->getRoutes()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :goto_2b
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/net/RouteInfo;

    .local v1, route:Landroid/net/RouteInfo;
    invoke-virtual {p0, v1}, Landroid/net/DhcpInfoInternal;->addRoute(Landroid/net/RouteInfo;)V

    goto :goto_2b
.end method
