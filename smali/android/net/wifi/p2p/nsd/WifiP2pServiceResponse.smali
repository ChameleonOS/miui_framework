.class public Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;
.super Ljava/lang/Object;
.source "WifiP2pServiceResponse.java"

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse$Status;
    }
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;",
            ">;"
        }
    .end annotation
.end field

.field private static MAX_BUF_SIZE:I


# instance fields
.field protected mData:[B

.field protected mDevice:Landroid/net/wifi/p2p/WifiP2pDevice;

.field protected mServiceType:I

.field protected mStatus:I

.field protected mTransId:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 37
    const/16 v0, 0x400

    sput v0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->MAX_BUF_SIZE:I

    .line 361
    new-instance v0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse$1;

    invoke-direct {v0}, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse$1;-><init>()V

    sput-object v0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method protected constructor <init>(IIILandroid/net/wifi/p2p/WifiP2pDevice;[B)V
    .registers 6
    .parameter "serviceType"
    .parameter "status"
    .parameter "transId"
    .parameter "device"
    .parameter "data"

    .prologue
    .line 119
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 120
    iput p1, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mServiceType:I

    .line 121
    iput p2, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mStatus:I

    .line 122
    iput p3, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mTransId:I

    .line 123
    iput-object p4, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mDevice:Landroid/net/wifi/p2p/WifiP2pDevice;

    .line 124
    iput-object p5, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mData:[B

    .line 125
    return-void
.end method

.method private equals(Ljava/lang/Object;Ljava/lang/Object;)Z
    .registers 4
    .parameter "a"
    .parameter "b"

    .prologue
    .line 321
    if-nez p1, :cond_6

    if-nez p2, :cond_6

    .line 322
    const/4 v0, 0x1

    .line 326
    :goto_5
    return v0

    .line 323
    :cond_6
    if-eqz p1, :cond_d

    .line 324
    invoke-virtual {p1, p2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_5

    .line 326
    :cond_d
    const/4 v0, 0x0

    goto :goto_5
.end method

.method private static hexStr2Bin(Ljava/lang/String;)[B
    .registers 7
    .parameter "hex"

    .prologue
    .line 279
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v4

    div-int/lit8 v3, v4, 0x2

    .line 280
    .local v3, sz:I
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v4

    div-int/lit8 v4, v4, 0x2

    new-array v0, v4, [B

    .line 282
    .local v0, b:[B
    const/4 v2, 0x0

    .local v2, i:I
    :goto_f
    if-ge v2, v3, :cond_2c

    .line 284
    mul-int/lit8 v4, v2, 0x2

    mul-int/lit8 v5, v2, 0x2

    add-int/lit8 v5, v5, 0x2

    :try_start_17
    invoke-virtual {p0, v4, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    const/16 v5, 0x10

    invoke-static {v4, v5}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;I)I

    move-result v4

    int-to-byte v4, v4

    aput-byte v4, v0, v2
    :try_end_24
    .catch Ljava/lang/Exception; {:try_start_17 .. :try_end_24} :catch_27

    .line 282
    add-int/lit8 v2, v2, 0x1

    goto :goto_f

    .line 285
    :catch_27
    move-exception v1

    .line 286
    .local v1, e:Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    .line 287
    const/4 v0, 0x0

    .line 290
    .end local v0           #b:[B
    .end local v1           #e:Ljava/lang/Exception;
    :cond_2c
    return-object v0
.end method

.method public static newInstance(Ljava/lang/String;)Ljava/util/List;
    .registers 16
    .parameter "supplicantEvent"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;",
            ">;"
        }
    .end annotation

    .prologue
    .line 199
    new-instance v11, Ljava/util/ArrayList;

    invoke-direct {v11}, Ljava/util/ArrayList;-><init>()V

    .line 200
    .local v11, respList:Ljava/util/List;,"Ljava/util/List<Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;>;"
    const-string v13, " "

    invoke-virtual {p0, v13}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v6

    .line 201
    .local v6, args:[Ljava/lang/String;
    array-length v13, v6

    const/4 v14, 0x4

    if-eq v13, v14, :cond_11

    .line 202
    const/4 v11, 0x0

    .line 269
    .end local v11           #respList:Ljava/util/List;,"Ljava/util/List<Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;>;"
    :cond_10
    :goto_10
    return-object v11

    .line 204
    .restart local v11       #respList:Ljava/util/List;,"Ljava/util/List<Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;>;"
    :cond_11
    new-instance v4, Landroid/net/wifi/p2p/WifiP2pDevice;

    invoke-direct {v4}, Landroid/net/wifi/p2p/WifiP2pDevice;-><init>()V

    .line 205
    .local v4, dev:Landroid/net/wifi/p2p/WifiP2pDevice;
    const/4 v13, 0x1

    aget-object v12, v6, v13

    .line 206
    .local v12, srcAddr:Ljava/lang/String;
    iput-object v12, v4, Landroid/net/wifi/p2p/WifiP2pDevice;->deviceAddress:Ljava/lang/String;

    .line 208
    const/4 v13, 0x3

    aget-object v13, v6, v13

    invoke-static {v13}, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->hexStr2Bin(Ljava/lang/String;)[B

    move-result-object v7

    .line 209
    .local v7, bin:[B
    if-nez v7, :cond_26

    .line 210
    const/4 v11, 0x0

    goto :goto_10

    .line 213
    :cond_26
    new-instance v8, Ljava/io/DataInputStream;

    new-instance v13, Ljava/io/ByteArrayInputStream;

    invoke-direct {v13, v7}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    invoke-direct {v8, v13}, Ljava/io/DataInputStream;-><init>(Ljava/io/InputStream;)V

    .line 215
    .local v8, dis:Ljava/io/DataInputStream;
    :cond_30
    :goto_30
    :try_start_30
    invoke-virtual {v8}, Ljava/io/DataInputStream;->available()I

    move-result v13

    if-lez v13, :cond_10

    .line 225
    invoke-virtual {v8}, Ljava/io/DataInputStream;->readByte()B

    move-result v13

    and-int/lit16 v13, v13, 0xff

    invoke-virtual {v8}, Ljava/io/DataInputStream;->readByte()B

    move-result v14

    and-int/lit16 v14, v14, 0xff

    shl-int/lit8 v14, v14, 0x8

    add-int/2addr v13, v14

    add-int/lit8 v10, v13, -0x3

    .line 227
    .local v10, length:I
    invoke-virtual {v8}, Ljava/io/DataInputStream;->readUnsignedByte()I

    move-result v1

    .line 228
    .local v1, type:I
    invoke-virtual {v8}, Ljava/io/DataInputStream;->readByte()B

    move-result v3

    .line 229
    .local v3, transId:B
    invoke-virtual {v8}, Ljava/io/DataInputStream;->readUnsignedByte()I

    move-result v2

    .line 230
    .local v2, status:I
    if-gez v10, :cond_57

    .line 231
    const/4 v11, 0x0

    goto :goto_10

    .line 233
    :cond_57
    if-nez v10, :cond_71

    .line 234
    if-nez v2, :cond_30

    .line 235
    new-instance v0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;

    const/4 v5, 0x0

    invoke-direct/range {v0 .. v5}, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;-><init>(IIILandroid/net/wifi/p2p/WifiP2pDevice;[B)V

    invoke-interface {v11, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_64
    .catch Ljava/io/IOException; {:try_start_30 .. :try_end_64} :catch_65

    goto :goto_30

    .line 262
    .end local v1           #type:I
    .end local v2           #status:I
    .end local v3           #transId:B
    .end local v10           #length:I
    :catch_65
    move-exception v9

    .line 263
    .local v9, e:Ljava/io/IOException;
    invoke-virtual {v9}, Ljava/io/IOException;->printStackTrace()V

    .line 266
    invoke-interface {v11}, Ljava/util/List;->size()I

    move-result v13

    if-gtz v13, :cond_10

    .line 269
    const/4 v11, 0x0

    goto :goto_10

    .line 240
    .end local v9           #e:Ljava/io/IOException;
    .restart local v1       #type:I
    .restart local v2       #status:I
    .restart local v3       #transId:B
    .restart local v10       #length:I
    :cond_71
    :try_start_71
    sget v13, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->MAX_BUF_SIZE:I

    if-le v10, v13, :cond_7a

    .line 241
    int-to-long v13, v10

    invoke-virtual {v8, v13, v14}, Ljava/io/DataInputStream;->skip(J)J

    goto :goto_30

    .line 244
    :cond_7a
    new-array v5, v10, [B

    .line 245
    .local v5, data:[B
    invoke-virtual {v8, v5}, Ljava/io/DataInputStream;->readFully([B)V

    .line 248
    const/4 v13, 0x1

    if-ne v1, v13, :cond_92

    .line 249
    invoke-static {v2, v3, v4, v5}, Landroid/net/wifi/p2p/nsd/WifiP2pDnsSdServiceResponse;->newInstance(IILandroid/net/wifi/p2p/WifiP2pDevice;[B)Landroid/net/wifi/p2p/nsd/WifiP2pDnsSdServiceResponse;

    move-result-object v0

    .line 257
    .local v0, resp:Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;
    :goto_86
    if-eqz v0, :cond_30

    invoke-virtual {v0}, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->getStatus()I

    move-result v13

    if-nez v13, :cond_30

    .line 258
    invoke-interface {v11, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_30

    .line 251
    .end local v0           #resp:Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;
    :cond_92
    const/4 v13, 0x2

    if-ne v1, v13, :cond_9a

    .line 252
    invoke-static {v2, v3, v4, v5}, Landroid/net/wifi/p2p/nsd/WifiP2pUpnpServiceResponse;->newInstance(IILandroid/net/wifi/p2p/WifiP2pDevice;[B)Landroid/net/wifi/p2p/nsd/WifiP2pUpnpServiceResponse;

    move-result-object v0

    .restart local v0       #resp:Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;
    goto :goto_86

    .line 255
    .end local v0           #resp:Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;
    :cond_9a
    new-instance v0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;

    invoke-direct/range {v0 .. v5}, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;-><init>(IIILandroid/net/wifi/p2p/WifiP2pDevice;[B)V
    :try_end_9f
    .catch Ljava/io/IOException; {:try_start_71 .. :try_end_9f} :catch_65

    .restart local v0       #resp:Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;
    goto :goto_86
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    .prologue
    .line 343
    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 7
    .parameter "o"

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 305
    if-ne p1, p0, :cond_5

    .line 314
    :cond_4
    :goto_4
    return v1

    .line 308
    :cond_5
    instance-of v3, p1, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;

    if-nez v3, :cond_b

    move v1, v2

    .line 309
    goto :goto_4

    :cond_b
    move-object v0, p1

    .line 312
    check-cast v0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;

    .line 314
    .local v0, req:Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;
    iget v3, v0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mServiceType:I

    iget v4, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mServiceType:I

    if-ne v3, v4, :cond_32

    iget v3, v0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mStatus:I

    iget v4, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mStatus:I

    if-ne v3, v4, :cond_32

    iget-object v3, v0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mDevice:Landroid/net/wifi/p2p/WifiP2pDevice;

    iget-object v3, v3, Landroid/net/wifi/p2p/WifiP2pDevice;->deviceAddress:Ljava/lang/String;

    iget-object v4, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mDevice:Landroid/net/wifi/p2p/WifiP2pDevice;

    iget-object v4, v4, Landroid/net/wifi/p2p/WifiP2pDevice;->deviceAddress:Ljava/lang/String;

    invoke-direct {p0, v3, v4}, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->equals(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_32

    iget-object v3, v0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mData:[B

    iget-object v4, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mData:[B

    invoke-static {v3, v4}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v3

    if-nez v3, :cond_4

    :cond_32
    move v1, v2

    goto :goto_4
.end method

.method public getRawData()[B
    .registers 2

    .prologue
    .line 165
    iget-object v0, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mData:[B

    return-object v0
.end method

.method public getServiceType()I
    .registers 2

    .prologue
    .line 134
    iget v0, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mServiceType:I

    return v0
.end method

.method public getSrcDevice()Landroid/net/wifi/p2p/WifiP2pDevice;
    .registers 2

    .prologue
    .line 176
    iget-object v0, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mDevice:Landroid/net/wifi/p2p/WifiP2pDevice;

    return-object v0
.end method

.method public getStatus()I
    .registers 2

    .prologue
    .line 144
    iget v0, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mStatus:I

    return v0
.end method

.method public getTransactionId()I
    .registers 2

    .prologue
    .line 154
    iget v0, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mTransId:I

    return v0
.end method

.method public hashCode()I
    .registers 5

    .prologue
    const/4 v2, 0x0

    .line 331
    const/16 v0, 0x11

    .line 332
    .local v0, result:I
    iget v1, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mServiceType:I

    add-int/lit16 v0, v1, 0x20f

    .line 333
    mul-int/lit8 v1, v0, 0x1f

    iget v3, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mStatus:I

    add-int v0, v1, v3

    .line 334
    mul-int/lit8 v1, v0, 0x1f

    iget v3, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mTransId:I

    add-int v0, v1, v3

    .line 335
    mul-int/lit8 v3, v0, 0x1f

    iget-object v1, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mDevice:Landroid/net/wifi/p2p/WifiP2pDevice;

    iget-object v1, v1, Landroid/net/wifi/p2p/WifiP2pDevice;->deviceAddress:Ljava/lang/String;

    if-nez v1, :cond_27

    move v1, v2

    :goto_1c
    add-int v0, v3, v1

    .line 337
    mul-int/lit8 v1, v0, 0x1f

    iget-object v3, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mData:[B

    if-nez v3, :cond_30

    :goto_24
    add-int v0, v1, v2

    .line 338
    return v0

    .line 335
    :cond_27
    iget-object v1, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mDevice:Landroid/net/wifi/p2p/WifiP2pDevice;

    iget-object v1, v1, Landroid/net/wifi/p2p/WifiP2pDevice;->deviceAddress:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    goto :goto_1c

    .line 337
    :cond_30
    iget-object v2, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mData:[B

    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v2

    goto :goto_24
.end method

.method public setSrcDevice(Landroid/net/wifi/p2p/WifiP2pDevice;)V
    .registers 2
    .parameter "dev"

    .prologue
    .line 181
    if-nez p1, :cond_3

    .line 183
    :goto_2
    return-void

    .line 182
    :cond_3
    iput-object p1, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mDevice:Landroid/net/wifi/p2p/WifiP2pDevice;

    goto :goto_2
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    .prologue
    .line 295
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 296
    .local v0, sbuf:Ljava/lang/StringBuffer;
    const-string/jumbo v1, "serviceType:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget v2, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mServiceType:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    .line 297
    const-string v1, " status:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget v2, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mStatus:I

    invoke-static {v2}, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse$Status;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 298
    const-string v1, " srcAddr:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-object v2, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mDevice:Landroid/net/wifi/p2p/WifiP2pDevice;

    iget-object v2, v2, Landroid/net/wifi/p2p/WifiP2pDevice;->deviceAddress:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 299
    const-string v1, " data:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-object v2, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mData:[B

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    .line 300
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 4
    .parameter "dest"
    .parameter "flags"

    .prologue
    .line 348
    iget v0, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mServiceType:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 349
    iget v0, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mStatus:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 350
    iget v0, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mTransId:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 351
    iget-object v0, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mDevice:Landroid/net/wifi/p2p/WifiP2pDevice;

    invoke-virtual {p1, v0, p2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 352
    iget-object v0, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mData:[B

    if-eqz v0, :cond_1d

    iget-object v0, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mData:[B

    array-length v0, v0

    if-nez v0, :cond_22

    .line 353
    :cond_1d
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 358
    :goto_21
    return-void

    .line 355
    :cond_22
    iget-object v0, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mData:[B

    array-length v0, v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 356
    iget-object v0, p0, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->mData:[B

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeByteArray([B)V

    goto :goto_21
.end method
