.class Landroid/net/dhcp/DhcpDeclinePacket;
.super Landroid/net/dhcp/DhcpPacket;
.source "DhcpDeclinePacket.java"


# direct methods
.method constructor <init>(ILjava/net/InetAddress;Ljava/net/InetAddress;Ljava/net/InetAddress;Ljava/net/InetAddress;[B)V
    .registers 15
    .parameter "transId"
    .parameter "clientIp"
    .parameter "yourIp"
    .parameter "nextIp"
    .parameter "relayIp"
    .parameter "clientMac"

    .prologue
    .line 32
    const/4 v7, 0x0

    move-object v0, p0

    move v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    move-object v6, p6

    invoke-direct/range {v0 .. v7}, Landroid/net/dhcp/DhcpPacket;-><init>(ILjava/net/InetAddress;Ljava/net/InetAddress;Ljava/net/InetAddress;Ljava/net/InetAddress;[BZ)V

    .line 33
    return-void
.end method


# virtual methods
.method public buildPacket(ISS)Ljava/nio/ByteBuffer;
    .registers 13
    .parameter "encap"
    .parameter "destUdp"
    .parameter "srcUdp"

    .prologue
    .line 44
    const/16 v0, 0x5dc

    invoke-static {v0}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v6

    .line 46
    .local v6, result:Ljava/nio/ByteBuffer;
    iget-object v2, p0, Landroid/net/dhcp/DhcpPacket;->mClientIp:Ljava/net/InetAddress;

    iget-object v3, p0, Landroid/net/dhcp/DhcpPacket;->mYourIp:Ljava/net/InetAddress;

    const/4 v7, 0x1

    const/4 v8, 0x0

    move-object v0, p0

    move v1, p1

    move v4, p2

    move v5, p3

    invoke-virtual/range {v0 .. v8}, Landroid/net/dhcp/DhcpDeclinePacket;->fillInPacket(ILjava/net/InetAddress;Ljava/net/InetAddress;SSLjava/nio/ByteBuffer;BZ)V

    .line 48
    invoke-virtual {v6}, Ljava/nio/ByteBuffer;->flip()Ljava/nio/Buffer;

    .line 49
    return-object v6
.end method

.method public doNextOp(Landroid/net/dhcp/DhcpStateMachine;)V
    .registers 4
    .parameter "machine"

    .prologue
    .line 63
    iget-object v0, p0, Landroid/net/dhcp/DhcpPacket;->mClientMac:[B

    iget-object v1, p0, Landroid/net/dhcp/DhcpPacket;->mRequestedIp:Ljava/net/InetAddress;

    invoke-interface {p1, v0, v1}, Landroid/net/dhcp/DhcpStateMachine;->onDeclineReceived([BLjava/net/InetAddress;)V

    .line 64
    return-void
.end method

.method finishPacket(Ljava/nio/ByteBuffer;)V
    .registers 2
    .parameter "buffer"

    .prologue
    .line 57
    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    .prologue
    .line 36
    invoke-super {p0}, Landroid/net/dhcp/DhcpPacket;->toString()Ljava/lang/String;

    move-result-object v0

    .line 37
    .local v0, s:Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " DECLINE"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
