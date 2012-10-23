.class public Landroid/net/wifi/p2p/nsd/WifiP2pUpnpServiceRequest;
.super Landroid/net/wifi/p2p/nsd/WifiP2pServiceRequest;
.source "WifiP2pUpnpServiceRequest.java"


# direct methods
.method protected constructor <init>()V
    .registers 3

    .prologue
    .line 46
    const/4 v0, 0x2

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Landroid/net/wifi/p2p/nsd/WifiP2pServiceRequest;-><init>(ILjava/lang/String;)V

    .line 47
    return-void
.end method

.method protected constructor <init>(Ljava/lang/String;)V
    .registers 3
    .parameter "query"

    .prologue
    .line 38
    const/4 v0, 0x2

    invoke-direct {p0, v0, p1}, Landroid/net/wifi/p2p/nsd/WifiP2pServiceRequest;-><init>(ILjava/lang/String;)V

    .line 39
    return-void
.end method

.method public static newInstance()Landroid/net/wifi/p2p/nsd/WifiP2pUpnpServiceRequest;
    .registers 1

    .prologue
    .line 55
    new-instance v0, Landroid/net/wifi/p2p/nsd/WifiP2pUpnpServiceRequest;

    invoke-direct {v0}, Landroid/net/wifi/p2p/nsd/WifiP2pUpnpServiceRequest;-><init>()V

    return-object v0
.end method

.method public static newInstance(Ljava/lang/String;)Landroid/net/wifi/p2p/nsd/WifiP2pUpnpServiceRequest;
    .registers 6
    .parameter "st"

    .prologue
    .line 72
    if-nez p0, :cond_b

    .line 73
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "search target cannot be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 75
    :cond_b
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 76
    .local v0, sb:Ljava/lang/StringBuffer;
    const-string v1, "%02x"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    const/16 v4, 0x10

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 77
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v1

    invoke-static {v1}, Landroid/net/wifi/p2p/nsd/WifiP2pServiceInfo;->bin2HexStr([B)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 78
    new-instance v1, Landroid/net/wifi/p2p/nsd/WifiP2pUpnpServiceRequest;

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/net/wifi/p2p/nsd/WifiP2pUpnpServiceRequest;-><init>(Ljava/lang/String;)V

    return-object v1
.end method
