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

    .line 27
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 25
    iput-boolean v0, p0, Landroid/net/wifi/NetworkUpdateResult;->isNewNetwork:Z

    .line 28
    iput p1, p0, Landroid/net/wifi/NetworkUpdateResult;->netId:I

    .line 29
    iput-boolean v0, p0, Landroid/net/wifi/NetworkUpdateResult;->ipChanged:Z

    .line 30
    iput-boolean v0, p0, Landroid/net/wifi/NetworkUpdateResult;->proxyChanged:Z

    .line 31
    return-void
.end method

.method public constructor <init>(ZZ)V
    .registers 4
    .parameter "ip"
    .parameter "proxy"

    .prologue
    .line 33
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 25
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/net/wifi/NetworkUpdateResult;->isNewNetwork:Z

    .line 34
    const/4 v0, -0x1

    iput v0, p0, Landroid/net/wifi/NetworkUpdateResult;->netId:I

    .line 35
    iput-boolean p1, p0, Landroid/net/wifi/NetworkUpdateResult;->ipChanged:Z

    .line 36
    iput-boolean p2, p0, Landroid/net/wifi/NetworkUpdateResult;->proxyChanged:Z

    .line 37
    return-void
.end method


# virtual methods
.method public getNetworkId()I
    .registers 2

    .prologue
    .line 44
    iget v0, p0, Landroid/net/wifi/NetworkUpdateResult;->netId:I

    return v0
.end method

.method public hasIpChanged()Z
    .registers 2

    .prologue
    .line 52
    iget-boolean v0, p0, Landroid/net/wifi/NetworkUpdateResult;->ipChanged:Z

    return v0
.end method

.method public hasProxyChanged()Z
    .registers 2

    .prologue
    .line 60
    iget-boolean v0, p0, Landroid/net/wifi/NetworkUpdateResult;->proxyChanged:Z

    return v0
.end method

.method public isNewNetwork()Z
    .registers 2

    .prologue
    .line 64
    iget-boolean v0, p0, Landroid/net/wifi/NetworkUpdateResult;->isNewNetwork:Z

    return v0
.end method

.method public setIpChanged(Z)V
    .registers 2
    .parameter "ip"

    .prologue
    .line 48
    iput-boolean p1, p0, Landroid/net/wifi/NetworkUpdateResult;->ipChanged:Z

    .line 49
    return-void
.end method

.method public setIsNewNetwork(Z)V
    .registers 2
    .parameter "isNew"

    .prologue
    .line 68
    iput-boolean p1, p0, Landroid/net/wifi/NetworkUpdateResult;->isNewNetwork:Z

    .line 69
    return-void
.end method

.method public setNetworkId(I)V
    .registers 2
    .parameter "id"

    .prologue
    .line 40
    iput p1, p0, Landroid/net/wifi/NetworkUpdateResult;->netId:I

    .line 41
    return-void
.end method

.method public setProxyChanged(Z)V
    .registers 2
    .parameter "proxy"

    .prologue
    .line 56
    iput-boolean p1, p0, Landroid/net/wifi/NetworkUpdateResult;->proxyChanged:Z

    .line 57
    return-void
.end method
