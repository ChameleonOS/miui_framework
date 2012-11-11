.class Landroid/net/wifi/NetworkUpdateResult;
.super Ljava/lang/Object;
.source "NetworkUpdateResult.java"


# instance fields
.field ipChanged:Z

.field isNewNetwork:Z

.field netId:I

.field proxyChanged:Z


# direct methods
.method public constructor <init>(I)V
    .registers 3
    .parameter "id"

    .prologue
    const/4 v0, 0x0

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-boolean v0, p0, Landroid/net/wifi/NetworkUpdateResult;->isNewNetwork:Z

    iput p1, p0, Landroid/net/wifi/NetworkUpdateResult;->netId:I

    iput-boolean v0, p0, Landroid/net/wifi/NetworkUpdateResult;->ipChanged:Z

    iput-boolean v0, p0, Landroid/net/wifi/NetworkUpdateResult;->proxyChanged:Z

    return-void
.end method

.method public constructor <init>(ZZ)V
    .registers 4
    .parameter "ip"
    .parameter "proxy"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/net/wifi/NetworkUpdateResult;->isNewNetwork:Z

    const/4 v0, -0x1

    iput v0, p0, Landroid/net/wifi/NetworkUpdateResult;->netId:I

    iput-boolean p1, p0, Landroid/net/wifi/NetworkUpdateResult;->ipChanged:Z

    iput-boolean p2, p0, Landroid/net/wifi/NetworkUpdateResult;->proxyChanged:Z

    return-void
.end method


# virtual methods
.method public getNetworkId()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/net/wifi/NetworkUpdateResult;->netId:I

    return v0
.end method

.method public hasIpChanged()Z
    .registers 2

    .prologue
    iget-boolean v0, p0, Landroid/net/wifi/NetworkUpdateResult;->ipChanged:Z

    return v0
.end method

.method public hasProxyChanged()Z
    .registers 2

    .prologue
    iget-boolean v0, p0, Landroid/net/wifi/NetworkUpdateResult;->proxyChanged:Z

    return v0
.end method

.method public isNewNetwork()Z
    .registers 2

    .prologue
    iget-boolean v0, p0, Landroid/net/wifi/NetworkUpdateResult;->isNewNetwork:Z

    return v0
.end method

.method public setIpChanged(Z)V
    .registers 2
    .parameter "ip"

    .prologue
    iput-boolean p1, p0, Landroid/net/wifi/NetworkUpdateResult;->ipChanged:Z

    return-void
.end method

.method public setIsNewNetwork(Z)V
    .registers 2
    .parameter "isNew"

    .prologue
    iput-boolean p1, p0, Landroid/net/wifi/NetworkUpdateResult;->isNewNetwork:Z

    return-void
.end method

.method public setNetworkId(I)V
    .registers 2
    .parameter "id"

    .prologue
    iput p1, p0, Landroid/net/wifi/NetworkUpdateResult;->netId:I

    return-void
.end method

.method public setProxyChanged(Z)V
    .registers 2
    .parameter "proxy"

    .prologue
    iput-boolean p1, p0, Landroid/net/wifi/NetworkUpdateResult;->proxyChanged:Z

    return-void
.end method
