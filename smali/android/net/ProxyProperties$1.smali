.class final Landroid/net/ProxyProperties$1;
.super Ljava/lang/Object;
.source "ProxyProperties.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/ProxyProperties;
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
        "Landroid/net/ProxyProperties;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 199
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/net/ProxyProperties;
    .registers 9
    .parameter "in"

    .prologue
    .line 201
    const/4 v1, 0x0

    .line 202
    .local v1, host:Ljava/lang/String;
    const/4 v2, 0x0

    .line 203
    .local v2, port:I
    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v5

    const/4 v6, 0x1

    if-ne v5, v6, :cond_11

    .line 204
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    .line 205
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v2

    .line 207
    :cond_11
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    .line 208
    .local v3, exclList:Ljava/lang/String;
    invoke-virtual {p1}, Landroid/os/Parcel;->readStringArray()[Ljava/lang/String;

    move-result-object v4

    .line 209
    .local v4, parsedExclList:[Ljava/lang/String;
    new-instance v0, Landroid/net/ProxyProperties;

    const/4 v5, 0x0

    invoke-direct/range {v0 .. v5}, Landroid/net/ProxyProperties;-><init>(Ljava/lang/String;ILjava/lang/String;[Ljava/lang/String;Landroid/net/ProxyProperties$1;)V

    .line 211
    .local v0, proxyProperties:Landroid/net/ProxyProperties;
    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 199
    invoke-virtual {p0, p1}, Landroid/net/ProxyProperties$1;->createFromParcel(Landroid/os/Parcel;)Landroid/net/ProxyProperties;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/net/ProxyProperties;
    .registers 3
    .parameter "size"

    .prologue
    .line 215
    new-array v0, p1, [Landroid/net/ProxyProperties;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 199
    invoke-virtual {p0, p1}, Landroid/net/ProxyProperties$1;->newArray(I)[Landroid/net/ProxyProperties;

    move-result-object v0

    return-object v0
.end method
