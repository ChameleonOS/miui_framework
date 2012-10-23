.class Landroid/net/dhcp/DhcpNakPacket;
.super Landroid/net/dhcp/DhcpPacket;
.source "DhcpNakPacket.java"


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
    .line 33
    sget-object v2, Ljava/net/Inet4Address;->ANY:Ljava/net/InetAddress;

    sget-object v3, Ljava/net/Inet4Address;->ANY:Ljava/net/InetAddress;

    const/4 v7, 0x0

    move-object v0, p0

    move v1, p1

    move-object v4, p4

    move-object v5, p5

    move-object v6, p6

    invoke-direct/range {v0 .. v7}, Landroid/net/dhcp/DhcpPacket;-><init>(ILjava/net/InetAddress;Ljava/net/InetAddress;Ljava/net/InetAddress;Ljava/net/InetAddress;[BZ)V

    .line 35
    return-void
.end method


# virtual methods
.method public buildPacket(ISS)Ljava/nio/ByteBuffer;
    .registers 13
    .parameter "encap"
    .parameter "destUdp"
    .parameter "srcUdp"

    .prologue
    .line 46
    const/16 v0, 0x5dc

    invoke-static {v0}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v6

    .line 47
    .local v6, result:Ljava/nio/ByteBuffer;
    iget-object v2, p0, Landroid/net/dhcp/DhcpPacket;->mClientIp:Ljava/net/InetAddress;

    .line 48
    .local v2, destIp:Ljava/net/InetAddress;
    iget-object v3, p0, Landroid/net/dhcp/DhcpPacket;->mYourIp:Ljava/net/InetAddress;

    .line 50
    .local v3, srcIp:Ljava/net/InetAddress;
    const/4 v7, 0x2

    iget-boolean v8, p0, Landroid/net/dhcp/DhcpPacket;->mBroadcast:Z

    move-object v0, p0

    move v1, p1

    move v4, p2

    move v5, p3

    invoke-virtual/range {v0 .. v8}, Landroid/net/dhcp/DhcpNakPacket;->fillInPacket(ILjava/net/InetAddress;Ljava/net/InetAddress;SSLjava/nio/ByteBuffer;BZ)V

    .line 52
    invoke-virtual {v6}, Ljava/nio/ByteBuffer;->flip()Ljava/nio/Buffer;

    .line 53
    return-object v6
.end method

.method public doNextOp(Landroid/net/dhcp/DhcpStateMachine;)V
    .registers 2
    .parameter "machine"

    .prologue
    .line 70
    invoke-interface {p1}, Landroid/net/dhcp/DhcpStateMachine;->onNakReceived()V

    .line 71
    return-void
.end method

.method finishPacket(Ljava/nio/ByteBuffer;)V
    .registers 4
    .parameter "buffer"

    .prologue
    .line 60
    const/16 v0, 0x35

    const/4 v1, 0x6

    invoke-virtual {p0, p1, v0, v1}, Landroid/net/dhcp/DhcpNakPacket;->addTlv(Ljava/nio/ByteBuffer;BB)V

    .line 61
    const/16 v0, 0x36

    iget-object v1, p0, Landroid/net/dhcp/DhcpPacket;->mServerIdentifier:Ljava/net/InetAddress;

    invoke-virtual {p0, p1, v0, v1}, Landroid/net/dhcp/DhcpNakPacket;->addTlv(Ljava/nio/ByteBuffer;BLjava/net/InetAddress;)V

    .line 62
    const/16 v0, 0x38

    iget-object v1, p0, Landroid/net/dhcp/DhcpPacket;->mMessage:Ljava/lang/String;

    invoke-virtual {p0, p1, v0, v1}, Landroid/net/dhcp/DhcpNakPacket;->addTlv(Ljava/nio/ByteBuffer;BLjava/lang/String;)V

    .line 63
    invoke-virtual {p0, p1}, Landroid/net/dhcp/DhcpNakPacket;->addTlvEnd(Ljava/nio/ByteBuffer;)V

    .line 64
    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    .prologue
    .line 38
    invoke-super {p0}, Landroid/net/dhcp/DhcpPacket;->toString()Ljava/lang/String;

    move-result-object v0

    .line 39
    .local v0, s:Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " NAK, reason "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v1, p0, Landroid/net/dhcp/DhcpPacket;->mMessage:Ljava/lang/String;

    if-nez v1, :cond_22

    const-string v1, "(none)"

    :goto_19
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1

    :cond_22
    iget-object v1, p0, Landroid/net/dhcp/DhcpPacket;->mMessage:Ljava/lang/String;

    goto :goto_19
.end method
