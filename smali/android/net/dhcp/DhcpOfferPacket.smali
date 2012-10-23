.class Landroid/net/dhcp/DhcpOfferPacket;
.super Landroid/net/dhcp/DhcpPacket;
.source "DhcpOfferPacket.java"


# instance fields
.field private final mSrcIp:Ljava/net/InetAddress;


# direct methods
.method constructor <init>(IZLjava/net/InetAddress;Ljava/net/InetAddress;[B)V
    .registers 14
    .parameter "transId"
    .parameter "broadcast"
    .parameter "serverAddress"
    .parameter "clientIp"
    .parameter "clientMac"

    .prologue
    .line 38
    sget-object v2, Ljava/net/Inet4Address;->ANY:Ljava/net/InetAddress;

    sget-object v4, Ljava/net/Inet4Address;->ANY:Ljava/net/InetAddress;

    sget-object v5, Ljava/net/Inet4Address;->ANY:Ljava/net/InetAddress;

    move-object v0, p0

    move v1, p1

    move-object v3, p4

    move-object v6, p5

    move v7, p2

    invoke-direct/range {v0 .. v7}, Landroid/net/dhcp/DhcpPacket;-><init>(ILjava/net/InetAddress;Ljava/net/InetAddress;Ljava/net/InetAddress;Ljava/net/InetAddress;[BZ)V

    .line 40
    iput-object p3, p0, Landroid/net/dhcp/DhcpOfferPacket;->mSrcIp:Ljava/net/InetAddress;

    .line 41
    return-void
.end method


# virtual methods
.method public buildPacket(ISS)Ljava/nio/ByteBuffer;
    .registers 13
    .parameter "encap"
    .parameter "destUdp"
    .parameter "srcUdp"

    .prologue
    .line 62
    const/16 v0, 0x5dc

    invoke-static {v0}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v6

    .line 63
    .local v6, result:Ljava/nio/ByteBuffer;
    iget-boolean v0, p0, Landroid/net/dhcp/DhcpPacket;->mBroadcast:Z

    if-eqz v0, :cond_20

    sget-object v2, Ljava/net/Inet4Address;->ALL:Ljava/net/InetAddress;

    .line 64
    .local v2, destIp:Ljava/net/InetAddress;
    :goto_c
    iget-boolean v0, p0, Landroid/net/dhcp/DhcpPacket;->mBroadcast:Z

    if-eqz v0, :cond_23

    sget-object v3, Ljava/net/Inet4Address;->ANY:Ljava/net/InetAddress;

    .line 66
    .local v3, srcIp:Ljava/net/InetAddress;
    :goto_12
    const/4 v7, 0x2

    iget-boolean v8, p0, Landroid/net/dhcp/DhcpPacket;->mBroadcast:Z

    move-object v0, p0

    move v1, p1

    move v4, p2

    move v5, p3

    invoke-virtual/range {v0 .. v8}, Landroid/net/dhcp/DhcpOfferPacket;->fillInPacket(ILjava/net/InetAddress;Ljava/net/InetAddress;SSLjava/nio/ByteBuffer;BZ)V

    .line 68
    invoke-virtual {v6}, Ljava/nio/ByteBuffer;->flip()Ljava/nio/Buffer;

    .line 69
    return-object v6

    .line 63
    .end local v2           #destIp:Ljava/net/InetAddress;
    .end local v3           #srcIp:Ljava/net/InetAddress;
    :cond_20
    iget-object v2, p0, Landroid/net/dhcp/DhcpPacket;->mYourIp:Ljava/net/InetAddress;

    goto :goto_c

    .line 64
    .restart local v2       #destIp:Ljava/net/InetAddress;
    :cond_23
    iget-object v3, p0, Landroid/net/dhcp/DhcpOfferPacket;->mSrcIp:Ljava/net/InetAddress;

    goto :goto_12
.end method

.method public doNextOp(Landroid/net/dhcp/DhcpStateMachine;)V
    .registers 8
    .parameter "machine"

    .prologue
    .line 98
    iget-boolean v1, p0, Landroid/net/dhcp/DhcpPacket;->mBroadcast:Z

    iget v2, p0, Landroid/net/dhcp/DhcpPacket;->mTransId:I

    iget-object v3, p0, Landroid/net/dhcp/DhcpPacket;->mClientMac:[B

    iget-object v4, p0, Landroid/net/dhcp/DhcpPacket;->mYourIp:Ljava/net/InetAddress;

    iget-object v5, p0, Landroid/net/dhcp/DhcpPacket;->mServerIdentifier:Ljava/net/InetAddress;

    move-object v0, p1

    invoke-interface/range {v0 .. v5}, Landroid/net/dhcp/DhcpStateMachine;->onOfferReceived(ZI[BLjava/net/InetAddress;Ljava/net/InetAddress;)V

    .line 100
    return-void
.end method

.method finishPacket(Ljava/nio/ByteBuffer;)V
    .registers 4
    .parameter "buffer"

    .prologue
    .line 76
    const/16 v0, 0x35

    const/4 v1, 0x2

    invoke-virtual {p0, p1, v0, v1}, Landroid/net/dhcp/DhcpOfferPacket;->addTlv(Ljava/nio/ByteBuffer;BB)V

    .line 77
    const/16 v0, 0x36

    iget-object v1, p0, Landroid/net/dhcp/DhcpPacket;->mServerIdentifier:Ljava/net/InetAddress;

    invoke-virtual {p0, p1, v0, v1}, Landroid/net/dhcp/DhcpOfferPacket;->addTlv(Ljava/nio/ByteBuffer;BLjava/net/InetAddress;)V

    .line 78
    const/16 v0, 0x33

    iget-object v1, p0, Landroid/net/dhcp/DhcpPacket;->mLeaseTime:Ljava/lang/Integer;

    invoke-virtual {p0, p1, v0, v1}, Landroid/net/dhcp/DhcpOfferPacket;->addTlv(Ljava/nio/ByteBuffer;BLjava/lang/Integer;)V

    .line 81
    iget-object v0, p0, Landroid/net/dhcp/DhcpPacket;->mLeaseTime:Ljava/lang/Integer;

    if-eqz v0, :cond_29

    .line 82
    const/16 v0, 0x3a

    iget-object v1, p0, Landroid/net/dhcp/DhcpPacket;->mLeaseTime:Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p0, p1, v0, v1}, Landroid/net/dhcp/DhcpOfferPacket;->addTlv(Ljava/nio/ByteBuffer;BLjava/lang/Integer;)V

    .line 86
    :cond_29
    const/4 v0, 0x1

    iget-object v1, p0, Landroid/net/dhcp/DhcpPacket;->mSubnetMask:Ljava/net/InetAddress;

    invoke-virtual {p0, p1, v0, v1}, Landroid/net/dhcp/DhcpOfferPacket;->addTlv(Ljava/nio/ByteBuffer;BLjava/net/InetAddress;)V

    .line 87
    const/4 v0, 0x3

    iget-object v1, p0, Landroid/net/dhcp/DhcpPacket;->mGateway:Ljava/net/InetAddress;

    invoke-virtual {p0, p1, v0, v1}, Landroid/net/dhcp/DhcpOfferPacket;->addTlv(Ljava/nio/ByteBuffer;BLjava/net/InetAddress;)V

    .line 88
    const/16 v0, 0xf

    iget-object v1, p0, Landroid/net/dhcp/DhcpPacket;->mDomainName:Ljava/lang/String;

    invoke-virtual {p0, p1, v0, v1}, Landroid/net/dhcp/DhcpOfferPacket;->addTlv(Ljava/nio/ByteBuffer;BLjava/lang/String;)V

    .line 89
    const/16 v0, 0x1c

    iget-object v1, p0, Landroid/net/dhcp/DhcpPacket;->mBroadcastAddress:Ljava/net/InetAddress;

    invoke-virtual {p0, p1, v0, v1}, Landroid/net/dhcp/DhcpOfferPacket;->addTlv(Ljava/nio/ByteBuffer;BLjava/net/InetAddress;)V

    .line 90
    const/4 v0, 0x6

    iget-object v1, p0, Landroid/net/dhcp/DhcpPacket;->mDnsServers:Ljava/util/List;

    invoke-virtual {p0, p1, v0, v1}, Landroid/net/dhcp/DhcpOfferPacket;->addTlv(Ljava/nio/ByteBuffer;BLjava/util/List;)V

    .line 91
    invoke-virtual {p0, p1}, Landroid/net/dhcp/DhcpOfferPacket;->addTlvEnd(Ljava/nio/ByteBuffer;)V

    .line 92
    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 7

    .prologue
    .line 44
    invoke-super {p0}, Landroid/net/dhcp/DhcpPacket;->toString()Ljava/lang/String;

    move-result-object v3

    .line 45
    .local v3, s:Ljava/lang/String;
    const-string v1, ", DNS servers: "

    .line 47
    .local v1, dnsServers:Ljava/lang/String;
    iget-object v4, p0, Landroid/net/dhcp/DhcpPacket;->mDnsServers:Ljava/util/List;

    if-eqz v4, :cond_34

    .line 48
    iget-object v4, p0, Landroid/net/dhcp/DhcpPacket;->mDnsServers:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, i$:Ljava/util/Iterator;
    :goto_10
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_34

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/net/InetAddress;

    .line 49
    .local v0, dnsServer:Ljava/net/InetAddress;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_10

    .line 53
    .end local v0           #dnsServer:Ljava/net/InetAddress;
    .end local v2           #i$:Ljava/util/Iterator;
    :cond_34
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " OFFER, ip "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Landroid/net/dhcp/DhcpPacket;->mYourIp:Ljava/net/InetAddress;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ", mask "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Landroid/net/dhcp/DhcpPacket;->mSubnetMask:Ljava/net/InetAddress;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ", gateway "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Landroid/net/dhcp/DhcpPacket;->mGateway:Ljava/net/InetAddress;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " lease time "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Landroid/net/dhcp/DhcpPacket;->mLeaseTime:Ljava/lang/Integer;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ", domain "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Landroid/net/dhcp/DhcpPacket;->mDomainName:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    return-object v4
.end method
