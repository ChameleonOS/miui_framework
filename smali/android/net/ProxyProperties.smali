.class public Landroid/net/ProxyProperties;
.super Ljava/lang/Object;
.source "ProxyProperties.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/net/ProxyProperties;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private mExclusionList:Ljava/lang/String;

.field private mHost:Ljava/lang/String;

.field private mParsedExclusionList:[Ljava/lang/String;

.field private mPort:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 198
    new-instance v0, Landroid/net/ProxyProperties$1;

    invoke-direct {v0}, Landroid/net/ProxyProperties$1;-><init>()V

    sput-object v0, Landroid/net/ProxyProperties;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(Landroid/net/ProxyProperties;)V
    .registers 3
    .parameter "source"

    .prologue
    .line 54
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 55
    if-eqz p1, :cond_1b

    .line 56
    invoke-virtual {p1}, Landroid/net/ProxyProperties;->getHost()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/net/ProxyProperties;->mHost:Ljava/lang/String;

    .line 57
    invoke-virtual {p1}, Landroid/net/ProxyProperties;->getPort()I

    move-result v0

    iput v0, p0, Landroid/net/ProxyProperties;->mPort:I

    .line 58
    invoke-virtual {p1}, Landroid/net/ProxyProperties;->getExclusionList()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/net/ProxyProperties;->mExclusionList:Ljava/lang/String;

    .line 59
    iget-object v0, p1, Landroid/net/ProxyProperties;->mParsedExclusionList:[Ljava/lang/String;

    iput-object v0, p0, Landroid/net/ProxyProperties;->mParsedExclusionList:[Ljava/lang/String;

    .line 61
    :cond_1b
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .registers 4
    .parameter "host"
    .parameter "port"
    .parameter "exclList"

    .prologue
    .line 40
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 41
    iput-object p1, p0, Landroid/net/ProxyProperties;->mHost:Ljava/lang/String;

    .line 42
    iput p2, p0, Landroid/net/ProxyProperties;->mPort:I

    .line 43
    invoke-direct {p0, p3}, Landroid/net/ProxyProperties;->setExclusionList(Ljava/lang/String;)V

    .line 44
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;[Ljava/lang/String;)V
    .registers 5
    .parameter "host"
    .parameter "port"
    .parameter "exclList"
    .parameter "parsedExclList"

    .prologue
    .line 46
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 47
    iput-object p1, p0, Landroid/net/ProxyProperties;->mHost:Ljava/lang/String;

    .line 48
    iput p2, p0, Landroid/net/ProxyProperties;->mPort:I

    .line 49
    iput-object p3, p0, Landroid/net/ProxyProperties;->mExclusionList:Ljava/lang/String;

    .line 50
    iput-object p4, p0, Landroid/net/ProxyProperties;->mParsedExclusionList:[Ljava/lang/String;

    .line 51
    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/String;ILjava/lang/String;[Ljava/lang/String;Landroid/net/ProxyProperties$1;)V
    .registers 6
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"
    .parameter "x3"
    .parameter "x4"

    .prologue
    .line 33
    invoke-direct {p0, p1, p2, p3, p4}, Landroid/net/ProxyProperties;-><init>(Ljava/lang/String;ILjava/lang/String;[Ljava/lang/String;)V

    return-void
.end method

.method private setExclusionList(Ljava/lang/String;)V
    .registers 9
    .parameter "exclusionList"

    .prologue
    .line 86
    iput-object p1, p0, Landroid/net/ProxyProperties;->mExclusionList:Ljava/lang/String;

    .line 87
    iget-object v3, p0, Landroid/net/ProxyProperties;->mExclusionList:Ljava/lang/String;

    if-nez v3, :cond_c

    .line 88
    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/String;

    iput-object v3, p0, Landroid/net/ProxyProperties;->mParsedExclusionList:[Ljava/lang/String;

    .line 99
    :cond_b
    return-void

    .line 90
    :cond_c
    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v3

    const-string v4, ","

    invoke-virtual {v3, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 91
    .local v2, splitExclusionList:[Ljava/lang/String;
    array-length v3, v2

    mul-int/lit8 v3, v3, 0x2

    new-array v3, v3, [Ljava/lang/String;

    iput-object v3, p0, Landroid/net/ProxyProperties;->mParsedExclusionList:[Ljava/lang/String;

    .line 92
    const/4 v0, 0x0

    .local v0, i:I
    :goto_1e
    array-length v3, v2

    if-ge v0, v3, :cond_b

    .line 93
    aget-object v3, v2, v0

    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 94
    .local v1, s:Ljava/lang/String;
    const-string v3, "."

    invoke-virtual {v1, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_34

    const/4 v3, 0x1

    invoke-virtual {v1, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    .line 95
    :cond_34
    iget-object v3, p0, Landroid/net/ProxyProperties;->mParsedExclusionList:[Ljava/lang/String;

    mul-int/lit8 v4, v0, 0x2

    aput-object v1, v3, v4

    .line 96
    iget-object v3, p0, Landroid/net/ProxyProperties;->mParsedExclusionList:[Ljava/lang/String;

    mul-int/lit8 v4, v0, 0x2

    add-int/lit8 v4, v4, 0x1

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "."

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 92
    add-int/lit8 v0, v0, 0x1

    goto :goto_1e
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    .prologue
    .line 165
    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 6
    .parameter "o"

    .prologue
    const/4 v1, 0x0

    .line 148
    instance-of v2, p1, Landroid/net/ProxyProperties;

    if-nez v2, :cond_6

    .line 157
    :cond_5
    :goto_5
    return v1

    :cond_6
    move-object v0, p1

    .line 149
    check-cast v0, Landroid/net/ProxyProperties;

    .line 150
    .local v0, p:Landroid/net/ProxyProperties;
    iget-object v2, p0, Landroid/net/ProxyProperties;->mExclusionList:Ljava/lang/String;

    if-eqz v2, :cond_19

    iget-object v2, p0, Landroid/net/ProxyProperties;->mExclusionList:Ljava/lang/String;

    invoke-virtual {v0}, Landroid/net/ProxyProperties;->getExclusionList()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 151
    :cond_19
    iget-object v2, p0, Landroid/net/ProxyProperties;->mHost:Ljava/lang/String;

    if-eqz v2, :cond_2f

    invoke-virtual {v0}, Landroid/net/ProxyProperties;->getHost()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_2f

    iget-object v2, p0, Landroid/net/ProxyProperties;->mHost:Ljava/lang/String;

    invoke-virtual {v0}, Landroid/net/ProxyProperties;->getHost()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 154
    :cond_2f
    iget-object v2, p0, Landroid/net/ProxyProperties;->mHost:Ljava/lang/String;

    if-eqz v2, :cond_37

    iget-object v2, v0, Landroid/net/ProxyProperties;->mHost:Ljava/lang/String;

    if-eqz v2, :cond_5

    .line 155
    :cond_37
    iget-object v2, p0, Landroid/net/ProxyProperties;->mHost:Ljava/lang/String;

    if-nez v2, :cond_3f

    iget-object v2, v0, Landroid/net/ProxyProperties;->mHost:Ljava/lang/String;

    if-nez v2, :cond_5

    .line 156
    :cond_3f
    iget v2, p0, Landroid/net/ProxyProperties;->mPort:I

    iget v3, v0, Landroid/net/ProxyProperties;->mPort:I

    if-ne v2, v3, :cond_5

    .line 157
    const/4 v1, 0x1

    goto :goto_5
.end method

.method public getExclusionList()Ljava/lang/String;
    .registers 2

    .prologue
    .line 81
    iget-object v0, p0, Landroid/net/ProxyProperties;->mExclusionList:Ljava/lang/String;

    return-object v0
.end method

.method public getHost()Ljava/lang/String;
    .registers 2

    .prologue
    .line 72
    iget-object v0, p0, Landroid/net/ProxyProperties;->mHost:Ljava/lang/String;

    return-object v0
.end method

.method public getPort()I
    .registers 2

    .prologue
    .line 76
    iget v0, p0, Landroid/net/ProxyProperties;->mPort:I

    return v0
.end method

.method public getSocketAddress()Ljava/net/InetSocketAddress;
    .registers 5

    .prologue
    .line 64
    const/4 v0, 0x0

    .line 66
    .local v0, inetSocketAddress:Ljava/net/InetSocketAddress;
    :try_start_1
    new-instance v1, Ljava/net/InetSocketAddress;

    iget-object v2, p0, Landroid/net/ProxyProperties;->mHost:Ljava/lang/String;

    iget v3, p0, Landroid/net/ProxyProperties;->mPort:I

    invoke-direct {v1, v2, v3}, Ljava/net/InetSocketAddress;-><init>(Ljava/lang/String;I)V
    :try_end_a
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_a} :catch_c

    .end local v0           #inetSocketAddress:Ljava/net/InetSocketAddress;
    .local v1, inetSocketAddress:Ljava/net/InetSocketAddress;
    move-object v0, v1

    .line 68
    .end local v1           #inetSocketAddress:Ljava/net/InetSocketAddress;
    .restart local v0       #inetSocketAddress:Ljava/net/InetSocketAddress;
    :goto_b
    return-object v0

    .line 67
    :catch_c
    move-exception v2

    goto :goto_b
.end method

.method public hashCode()I
    .registers 4

    .prologue
    const/4 v1, 0x0

    .line 173
    iget-object v0, p0, Landroid/net/ProxyProperties;->mHost:Ljava/lang/String;

    if-nez v0, :cond_f

    move v0, v1

    :goto_6
    iget-object v2, p0, Landroid/net/ProxyProperties;->mExclusionList:Ljava/lang/String;

    if-nez v2, :cond_16

    :goto_a
    add-int/2addr v0, v1

    iget v1, p0, Landroid/net/ProxyProperties;->mPort:I

    add-int/2addr v0, v1

    return v0

    :cond_f
    iget-object v0, p0, Landroid/net/ProxyProperties;->mHost:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_6

    :cond_16
    iget-object v1, p0, Landroid/net/ProxyProperties;->mExclusionList:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    goto :goto_a
.end method

.method public isExcluded(Ljava/lang/String;)Z
    .registers 8
    .parameter "url"

    .prologue
    const/4 v3, 0x0

    .line 102
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_10

    iget-object v4, p0, Landroid/net/ProxyProperties;->mParsedExclusionList:[Ljava/lang/String;

    if-eqz v4, :cond_10

    iget-object v4, p0, Landroid/net/ProxyProperties;->mParsedExclusionList:[Ljava/lang/String;

    array-length v4, v4

    if-nez v4, :cond_11

    .line 114
    :cond_10
    :goto_10
    return v3

    .line 105
    :cond_11
    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 106
    .local v1, u:Landroid/net/Uri;
    invoke-virtual {v1}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v2

    .line 107
    .local v2, urlDomain:Ljava/lang/String;
    if-eqz v2, :cond_10

    .line 108
    const/4 v0, 0x0

    .local v0, i:I
    :goto_1c
    iget-object v4, p0, Landroid/net/ProxyProperties;->mParsedExclusionList:[Ljava/lang/String;

    array-length v4, v4

    if-ge v0, v4, :cond_10

    .line 109
    iget-object v4, p0, Landroid/net/ProxyProperties;->mParsedExclusionList:[Ljava/lang/String;

    aget-object v4, v4, v0

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_37

    iget-object v4, p0, Landroid/net/ProxyProperties;->mParsedExclusionList:[Ljava/lang/String;

    add-int/lit8 v5, v0, 0x1

    aget-object v4, v4, v5

    invoke-virtual {v2, v4}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_39

    .line 111
    :cond_37
    const/4 v3, 0x1

    goto :goto_10

    .line 108
    :cond_39
    add-int/lit8 v0, v0, 0x2

    goto :goto_1c
.end method

.method public makeProxy()Ljava/net/Proxy;
    .registers 6

    .prologue
    .line 118
    sget-object v1, Ljava/net/Proxy;->NO_PROXY:Ljava/net/Proxy;

    .line 119
    .local v1, proxy:Ljava/net/Proxy;
    iget-object v3, p0, Landroid/net/ProxyProperties;->mHost:Ljava/lang/String;

    if-eqz v3, :cond_17

    .line 121
    :try_start_6
    new-instance v0, Ljava/net/InetSocketAddress;

    iget-object v3, p0, Landroid/net/ProxyProperties;->mHost:Ljava/lang/String;

    iget v4, p0, Landroid/net/ProxyProperties;->mPort:I

    invoke-direct {v0, v3, v4}, Ljava/net/InetSocketAddress;-><init>(Ljava/lang/String;I)V

    .line 122
    .local v0, inetSocketAddress:Ljava/net/InetSocketAddress;
    new-instance v2, Ljava/net/Proxy;

    sget-object v3, Ljava/net/Proxy$Type;->HTTP:Ljava/net/Proxy$Type;

    invoke-direct {v2, v3, v0}, Ljava/net/Proxy;-><init>(Ljava/net/Proxy$Type;Ljava/net/SocketAddress;)V
    :try_end_16
    .catch Ljava/lang/IllegalArgumentException; {:try_start_6 .. :try_end_16} :catch_18

    .end local v1           #proxy:Ljava/net/Proxy;
    .local v2, proxy:Ljava/net/Proxy;
    move-object v1, v2

    .line 126
    .end local v0           #inetSocketAddress:Ljava/net/InetSocketAddress;
    .end local v2           #proxy:Ljava/net/Proxy;
    .restart local v1       #proxy:Ljava/net/Proxy;
    :cond_17
    :goto_17
    return-object v1

    .line 123
    :catch_18
    move-exception v3

    goto :goto_17
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    .prologue
    .line 131
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 132
    .local v0, sb:Ljava/lang/StringBuilder;
    iget-object v1, p0, Landroid/net/ProxyProperties;->mHost:Ljava/lang/String;

    if-eqz v1, :cond_35

    .line 133
    const-string v1, "["

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 134
    iget-object v1, p0, Landroid/net/ProxyProperties;->mHost:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 135
    const-string v1, "] "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 136
    iget v1, p0, Landroid/net/ProxyProperties;->mPort:I

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 137
    iget-object v1, p0, Landroid/net/ProxyProperties;->mExclusionList:Ljava/lang/String;

    if-eqz v1, :cond_30

    .line 138
    const-string v1, " xl="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/net/ProxyProperties;->mExclusionList:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 143
    :cond_30
    :goto_30
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 141
    :cond_35
    const-string v1, "[ProxyProperties.mHost == null]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_30
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 4
    .parameter "dest"
    .parameter "flags"

    .prologue
    .line 183
    iget-object v0, p0, Landroid/net/ProxyProperties;->mHost:Ljava/lang/String;

    if-eqz v0, :cond_1d

    .line 184
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeByte(B)V

    .line 185
    iget-object v0, p0, Landroid/net/ProxyProperties;->mHost:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 186
    iget v0, p0, Landroid/net/ProxyProperties;->mPort:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 190
    :goto_12
    iget-object v0, p0, Landroid/net/ProxyProperties;->mExclusionList:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 191
    iget-object v0, p0, Landroid/net/ProxyProperties;->mParsedExclusionList:[Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeStringArray([Ljava/lang/String;)V

    .line 192
    return-void

    .line 188
    :cond_1d
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeByte(B)V

    goto :goto_12
.end method
