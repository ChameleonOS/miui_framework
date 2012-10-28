.class public Landroid/net/wifi/p2p/nsd/WifiP2pDnsSdServiceInfo;
.super Landroid/net/wifi/p2p/nsd/WifiP2pServiceInfo;
.source "WifiP2pDnsSdServiceInfo.java"


# static fields
.field public static final DNS_TYPE_PTR:I = 0xc

.field public static final DNS_TYPE_TXT:I = 0x10

.field public static final VERSION_1:I = 0x1

.field private static final sVmPacket:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 3

    .prologue
    .line 64
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Landroid/net/wifi/p2p/nsd/WifiP2pDnsSdServiceInfo;->sVmPacket:Ljava/util/Map;

    .line 65
    sget-object v0, Landroid/net/wifi/p2p/nsd/WifiP2pDnsSdServiceInfo;->sVmPacket:Ljava/util/Map;

    const-string v1, "_tcp.local."

    const-string v2, "c00c"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 66
    sget-object v0, Landroid/net/wifi/p2p/nsd/WifiP2pDnsSdServiceInfo;->sVmPacket:Ljava/util/Map;

    const-string v1, "local."

    const-string v2, "c011"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 67
    sget-object v0, Landroid/net/wifi/p2p/nsd/WifiP2pDnsSdServiceInfo;->sVmPacket:Ljava/util/Map;

    const-string v1, "_udp.local."

    const-string v2, "c01c"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 68
    return-void
.end method

.method private constructor <init>(Ljava/util/List;)V
    .registers 2
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 76
    .local p1, queryList:Ljava/util/List;,"Ljava/util/List<Ljava/lang/String;>;"
    invoke-direct {p0, p1}, Landroid/net/wifi/p2p/nsd/WifiP2pServiceInfo;-><init>(Ljava/util/List;)V

    .line 77
    return-void
.end method

.method private static compressDnsName(Ljava/lang/String;)Ljava/lang/String;
    .registers 10
    .parameter "dnsName"

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 204
    new-instance v3, Ljava/lang/StringBuffer;

    invoke-direct {v3}, Ljava/lang/StringBuffer;-><init>()V

    .line 209
    .local v3, sb:Ljava/lang/StringBuffer;
    :goto_7
    sget-object v4, Landroid/net/wifi/p2p/nsd/WifiP2pDnsSdServiceInfo;->sVmPacket:Ljava/util/Map;

    invoke-interface {v4, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 210
    .local v0, data:Ljava/lang/String;
    if-eqz v0, :cond_19

    .line 211
    invoke-virtual {v3, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 230
    :goto_14
    invoke-virtual {v3}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v4

    return-object v4

    .line 214
    :cond_19
    const/16 v4, 0x2e

    invoke-virtual {p0, v4}, Ljava/lang/String;->indexOf(I)I

    move-result v1

    .line 215
    .local v1, i:I
    const/4 v4, -0x1

    if-ne v1, v4, :cond_4e

    .line 216
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v4

    if-lez v4, :cond_48

    .line 217
    const-string v4, "%02x"

    new-array v5, v8, [Ljava/lang/Object;

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v7

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 218
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v4

    invoke-static {v4}, Landroid/net/wifi/p2p/nsd/WifiP2pServiceInfo;->bin2HexStr([B)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 221
    :cond_48
    const-string v4, "00"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_14

    .line 225
    :cond_4e
    invoke-virtual {p0, v7, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    .line 226
    .local v2, name:Ljava/lang/String;
    add-int/lit8 v4, v1, 0x1

    invoke-virtual {p0, v4}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object p0

    .line 227
    const-string v4, "%02x"

    new-array v5, v8, [Ljava/lang/Object;

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v7

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 228
    invoke-virtual {v2}, Ljava/lang/String;->getBytes()[B

    move-result-object v4

    invoke-static {v4}, Landroid/net/wifi/p2p/nsd/WifiP2pServiceInfo;->bin2HexStr([B)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_7
.end method

.method private static createPtrServiceQuery(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .registers 8
    .parameter "instanceName"
    .parameter "serviceType"

    .prologue
    const/4 v4, 0x1

    .line 123
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 124
    .local v1, sb:Ljava/lang/StringBuffer;
    const-string v2, "bonjour "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 125
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ".local."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/16 v3, 0xc

    invoke-static {v2, v3, v4}, Landroid/net/wifi/p2p/nsd/WifiP2pDnsSdServiceInfo;->createRequest(Ljava/lang/String;II)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 126
    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 128
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    .line 129
    .local v0, data:[B
    const-string v2, "%02x"

    new-array v3, v4, [Ljava/lang/Object;

    const/4 v4, 0x0

    array-length v5, v0

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 130
    invoke-static {v0}, Landroid/net/wifi/p2p/nsd/WifiP2pServiceInfo;->bin2HexStr([B)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 133
    const-string v2, "c027"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 134
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method static createRequest(Ljava/lang/String;II)Ljava/lang/String;
    .registers 9
    .parameter "dnsName"
    .parameter "dnsType"
    .parameter "version"

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 176
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 185
    .local v0, sb:Ljava/lang/StringBuffer;
    const/16 v1, 0x10

    if-ne p1, v1, :cond_f

    .line 186
    invoke-virtual {p0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object p0

    .line 188
    :cond_f
    invoke-static {p0}, Landroid/net/wifi/p2p/nsd/WifiP2pDnsSdServiceInfo;->compressDnsName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 189
    const-string v1, "%04x"

    new-array v2, v5, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 190
    const-string v1, "%02x"

    new-array v2, v5, [Ljava/lang/Object;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 192
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method private static createTxtServiceQuery(Ljava/lang/String;Ljava/lang/String;Landroid/net/nsd/DnsSdTxtRecord;)Ljava/lang/String;
    .registers 8
    .parameter "instanceName"
    .parameter "serviceType"
    .parameter "txtRecord"

    .prologue
    .line 152
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 153
    .local v1, sb:Ljava/lang/StringBuffer;
    const-string v2, "bonjour "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 155
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ".local."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/16 v3, 0x10

    const/4 v4, 0x1

    invoke-static {v2, v3, v4}, Landroid/net/wifi/p2p/nsd/WifiP2pDnsSdServiceInfo;->createRequest(Ljava/lang/String;II)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 157
    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 158
    invoke-virtual {p2}, Landroid/net/nsd/DnsSdTxtRecord;->getRawData()[B

    move-result-object v0

    .line 159
    .local v0, rawData:[B
    array-length v2, v0

    if-nez v2, :cond_47

    .line 160
    const-string v2, "00"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 164
    :goto_42
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 162
    :cond_47
    invoke-static {v0}, Landroid/net/wifi/p2p/nsd/WifiP2pDnsSdServiceInfo;->bin2HexStr([B)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_42
.end method

.method public static newInstance(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Landroid/net/wifi/p2p/nsd/WifiP2pDnsSdServiceInfo;
    .registers 9
    .parameter "instanceName"
    .parameter "serviceType"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Landroid/net/wifi/p2p/nsd/WifiP2pDnsSdServiceInfo;"
        }
    .end annotation

    .prologue
    .line 92
    .local p2, txtMap:Ljava/util/Map;,"Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_c

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_14

    .line 93
    :cond_c
    new-instance v4, Ljava/lang/IllegalArgumentException;

    const-string v5, "instance name or service type cannot be empty"

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 97
    :cond_14
    new-instance v3, Landroid/net/nsd/DnsSdTxtRecord;

    invoke-direct {v3}, Landroid/net/nsd/DnsSdTxtRecord;-><init>()V

    .line 98
    .local v3, txtRecord:Landroid/net/nsd/DnsSdTxtRecord;
    if-eqz p2, :cond_39

    .line 99
    invoke-interface {p2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :goto_23
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_39

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 100
    .local v1, key:Ljava/lang/String;
    invoke-interface {p2, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {v3, v1, v4}, Landroid/net/nsd/DnsSdTxtRecord;->set(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_23

    .line 104
    .end local v0           #i$:Ljava/util/Iterator;
    .end local v1           #key:Ljava/lang/String;
    :cond_39
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 105
    .local v2, queries:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-static {p0, p1}, Landroid/net/wifi/p2p/nsd/WifiP2pDnsSdServiceInfo;->createPtrServiceQuery(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 106
    invoke-static {p0, p1, v3}, Landroid/net/wifi/p2p/nsd/WifiP2pDnsSdServiceInfo;->createTxtServiceQuery(Ljava/lang/String;Ljava/lang/String;Landroid/net/nsd/DnsSdTxtRecord;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 108
    new-instance v4, Landroid/net/wifi/p2p/nsd/WifiP2pDnsSdServiceInfo;

    invoke-direct {v4, v2}, Landroid/net/wifi/p2p/nsd/WifiP2pDnsSdServiceInfo;-><init>(Ljava/util/List;)V

    return-object v4
.end method
