.class final Landroid/net/RouteInfo$1;
.super Ljava/lang/Object;
.source "RouteInfo.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/RouteInfo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable$Creator",
        "<",
        "Landroid/net/RouteInfo;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 182
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/net/RouteInfo;
    .registers 9
    .parameter "in"

    .prologue
    const/4 v6, 0x1

    .line 184
    const/4 v2, 0x0

    .line 185
    .local v2, destAddr:Ljava/net/InetAddress;
    const/4 v4, 0x0

    .line 186
    .local v4, prefix:I
    const/4 v3, 0x0

    .line 188
    .local v3, gateway:Ljava/net/InetAddress;
    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v5

    if-ne v5, v6, :cond_16

    .line 189
    invoke-virtual {p1}, Landroid/os/Parcel;->createByteArray()[B

    move-result-object v0

    .line 190
    .local v0, addr:[B
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v4

    .line 193
    :try_start_12
    invoke-static {v0}, Ljava/net/InetAddress;->getByAddress([B)Ljava/net/InetAddress;
    :try_end_15
    .catch Ljava/net/UnknownHostException; {:try_start_12 .. :try_end_15} :catch_32

    move-result-object v2

    .line 197
    .end local v0           #addr:[B
    :cond_16
    :goto_16
    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v5

    if-ne v5, v6, :cond_24

    .line 198
    invoke-virtual {p1}, Landroid/os/Parcel;->createByteArray()[B

    move-result-object v0

    .line 201
    .restart local v0       #addr:[B
    :try_start_20
    invoke-static {v0}, Ljava/net/InetAddress;->getByAddress([B)Ljava/net/InetAddress;
    :try_end_23
    .catch Ljava/net/UnknownHostException; {:try_start_20 .. :try_end_23} :catch_34

    move-result-object v3

    .line 205
    .end local v0           #addr:[B
    :cond_24
    :goto_24
    const/4 v1, 0x0

    .line 207
    .local v1, dest:Landroid/net/LinkAddress;
    if-eqz v2, :cond_2c

    .line 208
    new-instance v1, Landroid/net/LinkAddress;

    .end local v1           #dest:Landroid/net/LinkAddress;
    invoke-direct {v1, v2, v4}, Landroid/net/LinkAddress;-><init>(Ljava/net/InetAddress;I)V

    .line 211
    .restart local v1       #dest:Landroid/net/LinkAddress;
    :cond_2c
    new-instance v5, Landroid/net/RouteInfo;

    invoke-direct {v5, v1, v3}, Landroid/net/RouteInfo;-><init>(Landroid/net/LinkAddress;Ljava/net/InetAddress;)V

    return-object v5

    .line 194
    .end local v1           #dest:Landroid/net/LinkAddress;
    .restart local v0       #addr:[B
    :catch_32
    move-exception v5

    goto :goto_16

    .line 202
    :catch_34
    move-exception v5

    goto :goto_24
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 182
    invoke-virtual {p0, p1}, Landroid/net/RouteInfo$1;->createFromParcel(Landroid/os/Parcel;)Landroid/net/RouteInfo;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/net/RouteInfo;
    .registers 3
    .parameter "size"

    .prologue
    .line 215
    new-array v0, p1, [Landroid/net/RouteInfo;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 182
    invoke-virtual {p0, p1}, Landroid/net/RouteInfo$1;->newArray(I)[Landroid/net/RouteInfo;

    move-result-object v0

    return-object v0
.end method
