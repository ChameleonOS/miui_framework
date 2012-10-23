.class public final Landroid/nfc/tech/MifareClassic;
.super Landroid/nfc/tech/BasicTagTechnology;
.source "MifareClassic.java"


# static fields
.field public static final BLOCK_SIZE:I = 0x10

.field public static final KEY_DEFAULT:[B = null

.field public static final KEY_MIFARE_APPLICATION_DIRECTORY:[B = null

.field public static final KEY_NFC_FORUM:[B = null

.field private static final MAX_BLOCK_COUNT:I = 0x100

.field private static final MAX_SECTOR_COUNT:I = 0x28

.field public static final SIZE_1K:I = 0x400

.field public static final SIZE_2K:I = 0x800

.field public static final SIZE_4K:I = 0x1000

.field public static final SIZE_MINI:I = 0x140

.field private static final TAG:Ljava/lang/String; = "NFC"

.field public static final TYPE_CLASSIC:I = 0x0

.field public static final TYPE_PLUS:I = 0x1

.field public static final TYPE_PRO:I = 0x2

.field public static final TYPE_UNKNOWN:I = -0x1


# instance fields
.field private mIsEmulated:Z

.field private mSize:I

.field private mType:I


# direct methods
.method static constructor <clinit>()V
    .registers 2

    .prologue
    const/4 v1, 0x6

    .line 79
    new-array v0, v1, [B

    fill-array-data v0, :array_18

    sput-object v0, Landroid/nfc/tech/MifareClassic;->KEY_DEFAULT:[B

    .line 85
    new-array v0, v1, [B

    fill-array-data v0, :array_20

    sput-object v0, Landroid/nfc/tech/MifareClassic;->KEY_MIFARE_APPLICATION_DIRECTORY:[B

    .line 91
    new-array v0, v1, [B

    fill-array-data v0, :array_28

    sput-object v0, Landroid/nfc/tech/MifareClassic;->KEY_NFC_FORUM:[B

    return-void

    .line 79
    nop

    :array_18
    .array-data 0x1
        0xfft
        0xfft
        0xfft
        0xfft
        0xfft
        0xfft
    .end array-data

    .line 85
    nop

    :array_20
    .array-data 0x1
        0xa0t
        0xa1t
        0xa2t
        0xa3t
        0xa4t
        0xa5t
    .end array-data

    .line 91
    nop

    :array_28
    .array-data 0x1
        0xd3t
        0xf7t
        0xd3t
        0xf7t
        0xd3t
        0xf7t
    .end array-data
.end method

.method public constructor <init>(Landroid/nfc/Tag;)V
    .registers 8
    .parameter "tag"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    const/16 v5, 0x400

    const/16 v4, 0x1000

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 146
    const/16 v1, 0x8

    invoke-direct {p0, p1, v1}, Landroid/nfc/tech/BasicTagTechnology;-><init>(Landroid/nfc/Tag;I)V

    .line 148
    invoke-static {p1}, Landroid/nfc/tech/NfcA;->get(Landroid/nfc/Tag;)Landroid/nfc/tech/NfcA;

    move-result-object v0

    .line 150
    .local v0, a:Landroid/nfc/tech/NfcA;
    iput-boolean v2, p0, Landroid/nfc/tech/MifareClassic;->mIsEmulated:Z

    .line 152
    invoke-virtual {v0}, Landroid/nfc/tech/NfcA;->getSak()S

    move-result v1

    sparse-switch v1, :sswitch_data_6c

    .line 199
    new-instance v1, Ljava/lang/RuntimeException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Tag incorrectly enumerated as MIFARE Classic, SAK = "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Landroid/nfc/tech/NfcA;->getSak()S

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 155
    :sswitch_35
    iput v2, p0, Landroid/nfc/tech/MifareClassic;->mType:I

    .line 156
    iput v5, p0, Landroid/nfc/tech/MifareClassic;->mSize:I

    .line 202
    :goto_39
    return-void

    .line 159
    :sswitch_3a
    iput v2, p0, Landroid/nfc/tech/MifareClassic;->mType:I

    .line 160
    const/16 v1, 0x140

    iput v1, p0, Landroid/nfc/tech/MifareClassic;->mSize:I

    goto :goto_39

    .line 163
    :sswitch_41
    iput v3, p0, Landroid/nfc/tech/MifareClassic;->mType:I

    .line 164
    const/16 v1, 0x800

    iput v1, p0, Landroid/nfc/tech/MifareClassic;->mSize:I

    goto :goto_39

    .line 168
    :sswitch_48
    iput v3, p0, Landroid/nfc/tech/MifareClassic;->mType:I

    .line 169
    iput v4, p0, Landroid/nfc/tech/MifareClassic;->mSize:I

    goto :goto_39

    .line 173
    :sswitch_4d
    iput v2, p0, Landroid/nfc/tech/MifareClassic;->mType:I

    .line 174
    iput v4, p0, Landroid/nfc/tech/MifareClassic;->mSize:I

    goto :goto_39

    .line 177
    :sswitch_52
    iput v2, p0, Landroid/nfc/tech/MifareClassic;->mType:I

    .line 178
    iput v5, p0, Landroid/nfc/tech/MifareClassic;->mSize:I

    .line 179
    iput-boolean v3, p0, Landroid/nfc/tech/MifareClassic;->mIsEmulated:Z

    goto :goto_39

    .line 182
    :sswitch_59
    iput v2, p0, Landroid/nfc/tech/MifareClassic;->mType:I

    .line 183
    iput v4, p0, Landroid/nfc/tech/MifareClassic;->mSize:I

    .line 184
    iput-boolean v3, p0, Landroid/nfc/tech/MifareClassic;->mIsEmulated:Z

    goto :goto_39

    .line 187
    :sswitch_60
    iput v2, p0, Landroid/nfc/tech/MifareClassic;->mType:I

    .line 188
    iput v5, p0, Landroid/nfc/tech/MifareClassic;->mSize:I

    goto :goto_39

    .line 193
    :sswitch_65
    const/4 v1, 0x2

    iput v1, p0, Landroid/nfc/tech/MifareClassic;->mType:I

    .line 194
    iput v4, p0, Landroid/nfc/tech/MifareClassic;->mSize:I

    goto :goto_39

    .line 152
    nop

    :sswitch_data_6c
    .sparse-switch
        0x1 -> :sswitch_35
        0x8 -> :sswitch_35
        0x9 -> :sswitch_3a
        0x10 -> :sswitch_41
        0x11 -> :sswitch_48
        0x18 -> :sswitch_4d
        0x28 -> :sswitch_52
        0x38 -> :sswitch_59
        0x88 -> :sswitch_60
        0x98 -> :sswitch_65
        0xb8 -> :sswitch_65
    .end sparse-switch
.end method

.method private authenticate(I[BZ)Z
    .registers 13
    .parameter "sector"
    .parameter "key"
    .parameter "keyA"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v8, 0x6

    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 370
    invoke-static {p1}, Landroid/nfc/tech/MifareClassic;->validateSector(I)V

    .line 371
    invoke-virtual {p0}, Landroid/nfc/tech/MifareClassic;->checkConnected()V

    .line 373
    const/16 v5, 0xc

    new-array v0, v5, [B

    .line 376
    .local v0, cmd:[B
    if-eqz p3, :cond_35

    .line 377
    const/16 v5, 0x60

    aput-byte v5, v0, v4

    .line 385
    :goto_13
    invoke-virtual {p0, p1}, Landroid/nfc/tech/MifareClassic;->sectorToBlock(I)I

    move-result v5

    int-to-byte v5, v5

    aput-byte v5, v0, v3

    .line 388
    invoke-virtual {p0}, Landroid/nfc/tech/MifareClassic;->getTag()Landroid/nfc/Tag;

    move-result-object v5

    invoke-virtual {v5}, Landroid/nfc/Tag;->getId()[B

    move-result-object v2

    .line 389
    .local v2, uid:[B
    array-length v5, v2

    add-int/lit8 v5, v5, -0x4

    const/4 v6, 0x2

    const/4 v7, 0x4

    invoke-static {v2, v5, v0, v6, v7}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 392
    invoke-static {p2, v4, v0, v8, v8}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 395
    const/4 v5, 0x0

    :try_start_2e
    invoke-virtual {p0, v0, v5}, Landroid/nfc/tech/MifareClassic;->transceive([BZ)[B
    :try_end_31
    .catch Landroid/nfc/TagLostException; {:try_start_2e .. :try_end_31} :catch_3a
    .catch Ljava/io/IOException; {:try_start_2e .. :try_end_31} :catch_3c

    move-result-object v5

    if-eqz v5, :cond_3d

    .line 403
    :goto_34
    return v3

    .line 379
    .end local v2           #uid:[B
    :cond_35
    const/16 v5, 0x61

    aput-byte v5, v0, v4

    goto :goto_13

    .line 398
    .restart local v2       #uid:[B
    :catch_3a
    move-exception v1

    .line 399
    .local v1, e:Landroid/nfc/TagLostException;
    throw v1

    .line 400
    .end local v1           #e:Landroid/nfc/TagLostException;
    :catch_3c
    move-exception v3

    :cond_3d
    move v3, v4

    .line 403
    goto :goto_34
.end method

.method public static get(Landroid/nfc/Tag;)Landroid/nfc/tech/MifareClassic;
    .registers 4
    .parameter "tag"

    .prologue
    const/4 v1, 0x0

    .line 136
    const/16 v2, 0x8

    invoke-virtual {p0, v2}, Landroid/nfc/Tag;->hasTech(I)Z

    move-result v2

    if-nez v2, :cond_a

    .line 140
    :goto_9
    return-object v1

    .line 138
    :cond_a
    :try_start_a
    new-instance v2, Landroid/nfc/tech/MifareClassic;

    invoke-direct {v2, p0}, Landroid/nfc/tech/MifareClassic;-><init>(Landroid/nfc/Tag;)V
    :try_end_f
    .catch Landroid/os/RemoteException; {:try_start_a .. :try_end_f} :catch_11

    move-object v1, v2

    goto :goto_9

    .line 139
    :catch_11
    move-exception v0

    .line 140
    .local v0, e:Landroid/os/RemoteException;
    goto :goto_9
.end method

.method private static validateBlock(I)V
    .registers 4
    .parameter "block"

    .prologue
    .line 643
    if-ltz p0, :cond_6

    const/16 v0, 0x100

    if-lt p0, v0, :cond_1f

    .line 644
    :cond_6
    new-instance v0, Ljava/lang/IndexOutOfBoundsException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "block out of bounds: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 646
    :cond_1f
    return-void
.end method

.method private static validateSector(I)V
    .registers 4
    .parameter "sector"

    .prologue
    .line 636
    if-ltz p0, :cond_6

    const/16 v0, 0x28

    if-lt p0, v0, :cond_20

    .line 637
    :cond_6
    new-instance v0, Ljava/lang/IndexOutOfBoundsException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "sector out of bounds: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 639
    :cond_20
    return-void
.end method

.method private static validateValueOperand(I)V
    .registers 3
    .parameter "value"

    .prologue
    .line 649
    if-gez p0, :cond_b

    .line 650
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "value operand negative"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 652
    :cond_b
    return-void
.end method


# virtual methods
.method public authenticateSectorWithKeyA(I[B)Z
    .registers 4
    .parameter "sectorIndex"
    .parameter "key"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 339
    const/4 v0, 0x1

    invoke-direct {p0, p1, p2, v0}, Landroid/nfc/tech/MifareClassic;->authenticate(I[BZ)Z

    move-result v0

    return v0
.end method

.method public authenticateSectorWithKeyB(I[B)Z
    .registers 4
    .parameter "sectorIndex"
    .parameter "key"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 366
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Landroid/nfc/tech/MifareClassic;->authenticate(I[BZ)Z

    move-result v0

    return v0
.end method

.method public blockToSector(I)I
    .registers 3
    .parameter "blockIndex"

    .prologue
    .line 291
    invoke-static {p1}, Landroid/nfc/tech/MifareClassic;->validateBlock(I)V

    .line 293
    const/16 v0, 0x80

    if-ge p1, v0, :cond_a

    .line 294
    div-int/lit8 v0, p1, 0x4

    .line 296
    :goto_9
    return v0

    :cond_a
    add-int/lit8 v0, p1, -0x80

    div-int/lit8 v0, v0, 0x10

    add-int/lit8 v0, v0, 0x20

    goto :goto_9
.end method

.method public bridge synthetic close()V
    .registers 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 73
    invoke-super {p0}, Landroid/nfc/tech/BasicTagTechnology;->close()V

    return-void
.end method

.method public bridge synthetic connect()V
    .registers 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 73
    invoke-super {p0}, Landroid/nfc/tech/BasicTagTechnology;->connect()V

    return-void
.end method

.method public decrement(II)V
    .registers 6
    .parameter "blockIndex"
    .parameter "value"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 500
    invoke-static {p1}, Landroid/nfc/tech/MifareClassic;->validateBlock(I)V

    .line 501
    invoke-static {p2}, Landroid/nfc/tech/MifareClassic;->validateValueOperand(I)V

    .line 502
    invoke-virtual {p0}, Landroid/nfc/tech/MifareClassic;->checkConnected()V

    .line 504
    const/4 v1, 0x6

    invoke-static {v1}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v0

    .line 505
    .local v0, cmd:Ljava/nio/ByteBuffer;
    sget-object v1, Ljava/nio/ByteOrder;->LITTLE_ENDIAN:Ljava/nio/ByteOrder;

    invoke-virtual {v0, v1}, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;

    .line 506
    const/16 v1, -0x40

    invoke-virtual {v0, v1}, Ljava/nio/ByteBuffer;->put(B)Ljava/nio/ByteBuffer;

    .line 507
    int-to-byte v1, p1

    invoke-virtual {v0, v1}, Ljava/nio/ByteBuffer;->put(B)Ljava/nio/ByteBuffer;

    .line 508
    invoke-virtual {v0, p2}, Ljava/nio/ByteBuffer;->putInt(I)Ljava/nio/ByteBuffer;

    .line 510
    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2}, Landroid/nfc/tech/MifareClassic;->transceive([BZ)[B

    .line 511
    return-void
.end method

.method public getBlockCount()I
    .registers 2

    .prologue
    .line 263
    iget v0, p0, Landroid/nfc/tech/MifareClassic;->mSize:I

    div-int/lit8 v0, v0, 0x10

    return v0
.end method

.method public getBlockCountInSector(I)I
    .registers 3
    .parameter "sectorIndex"

    .prologue
    .line 274
    invoke-static {p1}, Landroid/nfc/tech/MifareClassic;->validateSector(I)V

    .line 276
    const/16 v0, 0x20

    if-ge p1, v0, :cond_9

    .line 277
    const/4 v0, 0x4

    .line 279
    :goto_8
    return v0

    :cond_9
    const/16 v0, 0x10

    goto :goto_8
.end method

.method public getMaxTransceiveLength()I
    .registers 2

    .prologue
    .line 584
    invoke-virtual {p0}, Landroid/nfc/tech/MifareClassic;->getMaxTransceiveLengthInternal()I

    move-result v0

    return v0
.end method

.method public getSectorCount()I
    .registers 2

    .prologue
    .line 243
    iget v0, p0, Landroid/nfc/tech/MifareClassic;->mSize:I

    sparse-switch v0, :sswitch_data_12

    .line 253
    const/4 v0, 0x0

    :goto_6
    return v0

    .line 245
    :sswitch_7
    const/16 v0, 0x10

    goto :goto_6

    .line 247
    :sswitch_a
    const/16 v0, 0x20

    goto :goto_6

    .line 249
    :sswitch_d
    const/16 v0, 0x28

    goto :goto_6

    .line 251
    :sswitch_10
    const/4 v0, 0x5

    goto :goto_6

    .line 243
    :sswitch_data_12
    .sparse-switch
        0x140 -> :sswitch_10
        0x400 -> :sswitch_7
        0x800 -> :sswitch_a
        0x1000 -> :sswitch_d
    .end sparse-switch
.end method

.method public getSize()I
    .registers 2

    .prologue
    .line 224
    iget v0, p0, Landroid/nfc/tech/MifareClassic;->mSize:I

    return v0
.end method

.method public bridge synthetic getTag()Landroid/nfc/Tag;
    .registers 2

    .prologue
    .line 73
    invoke-super {p0}, Landroid/nfc/tech/BasicTagTechnology;->getTag()Landroid/nfc/Tag;

    move-result-object v0

    return-object v0
.end method

.method public getTimeout()I
    .registers 4

    .prologue
    .line 621
    :try_start_0
    iget-object v1, p0, Landroid/nfc/tech/BasicTagTechnology;->mTag:Landroid/nfc/Tag;

    invoke-virtual {v1}, Landroid/nfc/Tag;->getTagService()Landroid/nfc/INfcTag;

    move-result-object v1

    const/16 v2, 0x8

    invoke-interface {v1, v2}, Landroid/nfc/INfcTag;->getTimeout(I)I
    :try_end_b
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_b} :catch_d

    move-result v1

    .line 624
    :goto_c
    return v1

    .line 622
    :catch_d
    move-exception v0

    .line 623
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "NFC"

    const-string v2, "NFC service dead"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 624
    const/4 v1, 0x0

    goto :goto_c
.end method

.method public getType()I
    .registers 2

    .prologue
    .line 213
    iget v0, p0, Landroid/nfc/tech/MifareClassic;->mType:I

    return v0
.end method

.method public increment(II)V
    .registers 6
    .parameter "blockIndex"
    .parameter "value"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 472
    invoke-static {p1}, Landroid/nfc/tech/MifareClassic;->validateBlock(I)V

    .line 473
    invoke-static {p2}, Landroid/nfc/tech/MifareClassic;->validateValueOperand(I)V

    .line 474
    invoke-virtual {p0}, Landroid/nfc/tech/MifareClassic;->checkConnected()V

    .line 476
    const/4 v1, 0x6

    invoke-static {v1}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v0

    .line 477
    .local v0, cmd:Ljava/nio/ByteBuffer;
    sget-object v1, Ljava/nio/ByteOrder;->LITTLE_ENDIAN:Ljava/nio/ByteOrder;

    invoke-virtual {v0, v1}, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;

    .line 478
    const/16 v1, -0x3f

    invoke-virtual {v0, v1}, Ljava/nio/ByteBuffer;->put(B)Ljava/nio/ByteBuffer;

    .line 479
    int-to-byte v1, p1

    invoke-virtual {v0, v1}, Ljava/nio/ByteBuffer;->put(B)Ljava/nio/ByteBuffer;

    .line 480
    invoke-virtual {v0, p2}, Ljava/nio/ByteBuffer;->putInt(I)Ljava/nio/ByteBuffer;

    .line 482
    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2}, Landroid/nfc/tech/MifareClassic;->transceive([BZ)[B

    .line 483
    return-void
.end method

.method public bridge synthetic isConnected()Z
    .registers 2

    .prologue
    .line 73
    invoke-super {p0}, Landroid/nfc/tech/BasicTagTechnology;->isConnected()Z

    move-result v0

    return v0
.end method

.method public isEmulated()Z
    .registers 2

    .prologue
    .line 234
    iget-boolean v0, p0, Landroid/nfc/tech/MifareClassic;->mIsEmulated:Z

    return v0
.end method

.method public readBlock(I)[B
    .registers 6
    .parameter "blockIndex"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 421
    invoke-static {p1}, Landroid/nfc/tech/MifareClassic;->validateBlock(I)V

    .line 422
    invoke-virtual {p0}, Landroid/nfc/tech/MifareClassic;->checkConnected()V

    .line 424
    const/4 v1, 0x2

    new-array v0, v1, [B

    const/16 v1, 0x30

    aput-byte v1, v0, v3

    const/4 v1, 0x1

    int-to-byte v2, p1

    aput-byte v2, v0, v1

    .line 425
    .local v0, cmd:[B
    invoke-virtual {p0, v0, v3}, Landroid/nfc/tech/MifareClassic;->transceive([BZ)[B

    move-result-object v1

    return-object v1
.end method

.method public bridge synthetic reconnect()V
    .registers 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 73
    invoke-super {p0}, Landroid/nfc/tech/BasicTagTechnology;->reconnect()V

    return-void
.end method

.method public restore(I)V
    .registers 6
    .parameter "blockIndex"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 549
    invoke-static {p1}, Landroid/nfc/tech/MifareClassic;->validateBlock(I)V

    .line 550
    invoke-virtual {p0}, Landroid/nfc/tech/MifareClassic;->checkConnected()V

    .line 552
    const/4 v1, 0x2

    new-array v0, v1, [B

    const/16 v1, -0x3e

    aput-byte v1, v0, v3

    const/4 v1, 0x1

    int-to-byte v2, p1

    aput-byte v2, v0, v1

    .line 554
    .local v0, cmd:[B
    invoke-virtual {p0, v0, v3}, Landroid/nfc/tech/MifareClassic;->transceive([BZ)[B

    .line 555
    return-void
.end method

.method public sectorToBlock(I)I
    .registers 3
    .parameter "sectorIndex"

    .prologue
    .line 308
    const/16 v0, 0x20

    if-ge p1, v0, :cond_7

    .line 309
    mul-int/lit8 v0, p1, 0x4

    .line 311
    :goto_6
    return v0

    :cond_7
    add-int/lit8 v0, p1, -0x20

    mul-int/lit8 v0, v0, 0x10

    add-int/lit16 v0, v0, 0x80

    goto :goto_6
.end method

.method public setTimeout(I)V
    .registers 6
    .parameter "timeout"

    .prologue
    .line 603
    :try_start_0
    iget-object v2, p0, Landroid/nfc/tech/BasicTagTechnology;->mTag:Landroid/nfc/Tag;

    invoke-virtual {v2}, Landroid/nfc/Tag;->getTagService()Landroid/nfc/INfcTag;

    move-result-object v2

    const/16 v3, 0x8

    invoke-interface {v2, v3, p1}, Landroid/nfc/INfcTag;->setTimeout(II)I

    move-result v1

    .line 604
    .local v1, err:I
    if-eqz v1, :cond_1e

    .line 605
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "The supplied timeout is not valid"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2
    :try_end_16
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_16} :catch_16

    .line 607
    .end local v1           #err:I
    :catch_16
    move-exception v0

    .line 608
    .local v0, e:Landroid/os/RemoteException;
    const-string v2, "NFC"

    const-string v3, "NFC service dead"

    invoke-static {v2, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 610
    .end local v0           #e:Landroid/os/RemoteException;
    :cond_1e
    return-void
.end method

.method public transceive([B)[B
    .registers 3
    .parameter "data"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 576
    const/4 v0, 0x1

    invoke-virtual {p0, p1, v0}, Landroid/nfc/tech/MifareClassic;->transceive([BZ)[B

    move-result-object v0

    return-object v0
.end method

.method public transfer(I)V
    .registers 6
    .parameter "blockIndex"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 527
    invoke-static {p1}, Landroid/nfc/tech/MifareClassic;->validateBlock(I)V

    .line 528
    invoke-virtual {p0}, Landroid/nfc/tech/MifareClassic;->checkConnected()V

    .line 530
    const/4 v1, 0x2

    new-array v0, v1, [B

    const/16 v1, -0x50

    aput-byte v1, v0, v3

    const/4 v1, 0x1

    int-to-byte v2, p1

    aput-byte v2, v0, v1

    .line 532
    .local v0, cmd:[B
    invoke-virtual {p0, v0, v3}, Landroid/nfc/tech/MifareClassic;->transceive([BZ)[B

    .line 533
    return-void
.end method

.method public writeBlock(I[B)V
    .registers 7
    .parameter "blockIndex"
    .parameter "data"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 443
    invoke-static {p1}, Landroid/nfc/tech/MifareClassic;->validateBlock(I)V

    .line 444
    invoke-virtual {p0}, Landroid/nfc/tech/MifareClassic;->checkConnected()V

    .line 445
    array-length v1, p2

    const/16 v2, 0x10

    if-eq v1, v2, :cond_15

    .line 446
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "must write 16-bytes"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 449
    :cond_15
    array-length v1, p2

    add-int/lit8 v1, v1, 0x2

    new-array v0, v1, [B

    .line 450
    .local v0, cmd:[B
    const/16 v1, -0x60

    aput-byte v1, v0, v3

    .line 451
    const/4 v1, 0x1

    int-to-byte v2, p1

    aput-byte v2, v0, v1

    .line 452
    const/4 v1, 0x2

    array-length v2, p2

    invoke-static {p2, v3, v0, v1, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 454
    invoke-virtual {p0, v0, v3}, Landroid/nfc/tech/MifareClassic;->transceive([BZ)[B

    .line 455
    return-void
.end method
