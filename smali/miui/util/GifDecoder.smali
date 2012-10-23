.class public Lmiui/util/GifDecoder;
.super Ljava/lang/Object;
.source "GifDecoder.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lmiui/util/GifDecoder$GifFrame;
    }
.end annotation


# static fields
.field public static final MAX_DECODE_SIZE:I = 0x100000

.field protected static final MAX_STACK_SIZE:I = 0x1000

.field public static final STATUS_DECODE_CANCEL:I = 0x3

.field public static final STATUS_FORMAT_ERROR:I = 0x1

.field public static final STATUS_OK:I = 0x0

.field public static final STATUS_OPEN_ERROR:I = 0x2


# instance fields
.field protected act:[I

.field protected bgColor:I

.field protected bgIndex:I

.field protected block:[B

.field protected blockSize:I

.field private calledOnce:Z

.field protected delay:I

.field private dest:[I

.field protected dispose:I

.field protected frames:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<",
            "Lmiui/util/GifDecoder$GifFrame;",
            ">;"
        }
    .end annotation
.end field

.field protected gct:[I

.field protected gctFlag:Z

.field protected gctSize:I

.field private height:I

.field protected ih:I

.field protected image:Landroid/graphics/Bitmap;

.field protected in:Ljava/io/BufferedInputStream;

.field protected interlace:Z

.field protected iw:I

.field protected ix:I

.field protected iy:I

.field protected lastBgColor:I

.field protected lastBitmap:Landroid/graphics/Bitmap;

.field protected lastDispose:I

.field protected lct:[I

.field protected lctFlag:Z

.field protected lctSize:I

.field protected loopCount:I

.field protected lrh:I

.field protected lrw:I

.field protected lrx:I

.field protected lry:I

.field private mCancel:Z

.field private mDecodeBmSize:J

.field private mDecodeToTheEnd:Z

.field private mDecodedFrames:I

.field private mMaxDecodeSize:J

.field private mStartFrame:I

.field protected pixelAspect:I

.field protected pixelStack:[B

.field protected pixels:[B

.field protected prefix:[S

.field protected status:I

.field protected suffix:[B

.field protected transIndex:I

.field protected transparency:Z

.field private width:I


# direct methods
.method public constructor <init>()V
    .registers 4

    .prologue
    const/4 v2, 0x0

    .line 13
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 40
    const-wide/32 v0, 0x100000

    iput-wide v0, p0, Lmiui/util/GifDecoder;->mMaxDecodeSize:J

    .line 66
    const/4 v0, 0x1

    iput v0, p0, Lmiui/util/GifDecoder;->loopCount:I

    .line 96
    const/16 v0, 0x100

    new-array v0, v0, [B

    iput-object v0, p0, Lmiui/util/GifDecoder;->block:[B

    .line 98
    iput v2, p0, Lmiui/util/GifDecoder;->blockSize:I

    .line 101
    iput v2, p0, Lmiui/util/GifDecoder;->dispose:I

    .line 104
    iput v2, p0, Lmiui/util/GifDecoder;->lastDispose:I

    .line 106
    iput-boolean v2, p0, Lmiui/util/GifDecoder;->transparency:Z

    .line 108
    iput v2, p0, Lmiui/util/GifDecoder;->delay:I

    .line 324
    iput-boolean v2, p0, Lmiui/util/GifDecoder;->mCancel:Z

    .line 373
    iput-boolean v2, p0, Lmiui/util/GifDecoder;->calledOnce:Z

    return-void
.end method

.method public static isGifStream(Ljava/io/InputStream;)Z
    .registers 7
    .parameter "is"

    .prologue
    .line 358
    const/4 v3, 0x0

    .line 359
    .local v3, ret:Z
    if-eqz p0, :cond_16

    .line 360
    const-string v2, ""

    .line 361
    .local v2, id:Ljava/lang/String;
    const/4 v1, 0x0

    .local v1, i:I
    :goto_6
    const/4 v4, 0x6

    if-ge v1, v4, :cond_10

    .line 362
    invoke-static {p0}, Lmiui/util/GifDecoder;->readOneByte(Ljava/io/InputStream;)I

    move-result v0

    .line 363
    .local v0, ch:I
    const/4 v4, -0x1

    if-ne v0, v4, :cond_17

    .line 368
    .end local v0           #ch:I
    :cond_10
    const-string v4, "GIF"

    invoke-virtual {v2, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    .line 370
    .end local v1           #i:I
    .end local v2           #id:Ljava/lang/String;
    :cond_16
    return v3

    .line 366
    .restart local v0       #ch:I
    .restart local v1       #i:I
    .restart local v2       #id:Ljava/lang/String;
    :cond_17
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    int-to-char v5, v0

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 361
    add-int/lit8 v1, v1, 0x1

    goto :goto_6
.end method

.method protected static readOneByte(Ljava/io/InputStream;)I
    .registers 4
    .parameter "is"

    .prologue
    .line 341
    const/4 v0, 0x0

    .line 343
    .local v0, curByte:I
    :try_start_1
    invoke-virtual {p0}, Ljava/io/InputStream;->read()I
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_4} :catch_7

    move-result v0

    move v2, v0

    .line 347
    :goto_6
    return v2

    .line 344
    :catch_7
    move-exception v1

    .line 345
    .local v1, e:Ljava/lang/Exception;
    const/4 v2, -0x1

    goto :goto_6
.end method

.method private requestCancel()V
    .registers 1

    .prologue
    .line 335
    return-void
.end method


# virtual methods
.method protected decodeBitmapData()V
    .registers 26

    .prologue
    .line 419
    const/16 v17, -0x1

    .line 420
    .local v17, nullCode:I
    move-object/from16 v0, p0

    iget v0, v0, Lmiui/util/GifDecoder;->iw:I

    move/from16 v23, v0

    move-object/from16 v0, p0

    iget v0, v0, Lmiui/util/GifDecoder;->ih:I

    move/from16 v24, v0

    mul-int v16, v23, v24

    .line 422
    .local v16, npix:I
    move-object/from16 v0, p0

    iget-object v0, v0, Lmiui/util/GifDecoder;->pixels:[B

    move-object/from16 v23, v0

    if-eqz v23, :cond_29

    move-object/from16 v0, p0

    iget-object v0, v0, Lmiui/util/GifDecoder;->pixels:[B

    move-object/from16 v23, v0

    move-object/from16 v0, v23

    array-length v0, v0

    move/from16 v23, v0

    move/from16 v0, v23

    move/from16 v1, v16

    if-ge v0, v1, :cond_35

    .line 423
    :cond_29
    move/from16 v0, v16

    new-array v0, v0, [B

    move-object/from16 v23, v0

    move-object/from16 v0, v23

    move-object/from16 v1, p0

    iput-object v0, v1, Lmiui/util/GifDecoder;->pixels:[B

    .line 425
    :cond_35
    move-object/from16 v0, p0

    iget-object v0, v0, Lmiui/util/GifDecoder;->prefix:[S

    move-object/from16 v23, v0

    if-nez v23, :cond_4b

    .line 426
    const/16 v23, 0x1000

    move/from16 v0, v23

    new-array v0, v0, [S

    move-object/from16 v23, v0

    move-object/from16 v0, v23

    move-object/from16 v1, p0

    iput-object v0, v1, Lmiui/util/GifDecoder;->prefix:[S

    .line 428
    :cond_4b
    move-object/from16 v0, p0

    iget-object v0, v0, Lmiui/util/GifDecoder;->suffix:[B

    move-object/from16 v23, v0

    if-nez v23, :cond_61

    .line 429
    const/16 v23, 0x1000

    move/from16 v0, v23

    new-array v0, v0, [B

    move-object/from16 v23, v0

    move-object/from16 v0, v23

    move-object/from16 v1, p0

    iput-object v0, v1, Lmiui/util/GifDecoder;->suffix:[B

    .line 431
    :cond_61
    move-object/from16 v0, p0

    iget-object v0, v0, Lmiui/util/GifDecoder;->pixelStack:[B

    move-object/from16 v23, v0

    if-nez v23, :cond_77

    .line 432
    const/16 v23, 0x1001

    move/from16 v0, v23

    new-array v0, v0, [B

    move-object/from16 v23, v0

    move-object/from16 v0, v23

    move-object/from16 v1, p0

    iput-object v0, v1, Lmiui/util/GifDecoder;->pixelStack:[B

    .line 435
    :cond_77
    invoke-virtual/range {p0 .. p0}, Lmiui/util/GifDecoder;->read()I

    move-result v10

    .line 436
    .local v10, data_size:I
    const/16 v23, 0x1

    shl-int v5, v23, v10

    .line 437
    .local v5, clear:I
    add-int/lit8 v12, v5, 0x1

    .line 438
    .local v12, end_of_information:I
    add-int/lit8 v2, v5, 0x2

    .line 439
    .local v2, available:I
    move/from16 v18, v17

    .line 440
    .local v18, old_code:I
    add-int/lit8 v8, v10, 0x1

    .line 441
    .local v8, code_size:I
    const/16 v23, 0x1

    shl-int v23, v23, v8

    add-int/lit8 v7, v23, -0x1

    .line 442
    .local v7, code_mask:I
    const/4 v6, 0x0

    .local v6, code:I
    :goto_8e
    if-ge v6, v5, :cond_a8

    .line 443
    move-object/from16 v0, p0

    iget-object v0, v0, Lmiui/util/GifDecoder;->prefix:[S

    move-object/from16 v23, v0

    const/16 v24, 0x0

    aput-short v24, v23, v6

    .line 444
    move-object/from16 v0, p0

    iget-object v0, v0, Lmiui/util/GifDecoder;->suffix:[B

    move-object/from16 v23, v0

    int-to-byte v0, v6

    move/from16 v24, v0

    aput-byte v24, v23, v6

    .line 442
    add-int/lit8 v6, v6, 0x1

    goto :goto_8e

    .line 447
    :cond_a8
    const/4 v3, 0x0

    .local v3, bi:I
    move/from16 v19, v3

    .local v19, pi:I
    move/from16 v21, v3

    .local v21, top:I
    move v13, v3

    .local v13, first:I
    move v9, v3

    .local v9, count:I
    move v4, v3

    .local v4, bits:I
    move v11, v3

    .line 448
    .local v11, datum:I
    const/4 v14, 0x0

    .local v14, i:I
    move/from16 v20, v19

    .end local v19           #pi:I
    .local v20, pi:I
    move/from16 v22, v21

    .end local v21           #top:I
    .local v22, top:I
    :goto_b6
    move/from16 v0, v16

    if-ge v14, v0, :cond_1c9

    .line 449
    if-nez v22, :cond_1cd

    .line 450
    if-ge v4, v8, :cond_f5

    .line 452
    if-nez v9, :cond_dc

    .line 454
    invoke-virtual/range {p0 .. p0}, Lmiui/util/GifDecoder;->readBlock()I

    move-result v9

    .line 455
    if-gtz v9, :cond_db

    move/from16 v21, v22

    .line 517
    .end local v22           #top:I
    .restart local v21       #top:I
    :goto_c8
    move/from16 v14, v20

    :goto_ca
    move/from16 v0, v16

    if-ge v14, v0, :cond_1c8

    .line 518
    move-object/from16 v0, p0

    iget-object v0, v0, Lmiui/util/GifDecoder;->pixels:[B

    move-object/from16 v23, v0

    const/16 v24, 0x0

    aput-byte v24, v23, v14

    .line 517
    add-int/lit8 v14, v14, 0x1

    goto :goto_ca

    .line 458
    .end local v21           #top:I
    .restart local v22       #top:I
    :cond_db
    const/4 v3, 0x0

    .line 460
    :cond_dc
    move-object/from16 v0, p0

    iget-object v0, v0, Lmiui/util/GifDecoder;->block:[B

    move-object/from16 v23, v0

    aget-byte v23, v23, v3

    move/from16 v0, v23

    and-int/lit16 v0, v0, 0xff

    move/from16 v23, v0

    shl-int v23, v23, v4

    add-int v11, v11, v23

    .line 461
    add-int/lit8 v4, v4, 0x8

    .line 462
    add-int/lit8 v3, v3, 0x1

    .line 463
    add-int/lit8 v9, v9, -0x1

    .line 464
    goto :goto_b6

    .line 467
    :cond_f5
    and-int v6, v11, v7

    .line 468
    shr-int/2addr v11, v8

    .line 469
    sub-int/2addr v4, v8

    .line 471
    if-gt v6, v2, :cond_1c9

    if-ne v6, v12, :cond_100

    move/from16 v21, v22

    .line 472
    .end local v22           #top:I
    .restart local v21       #top:I
    goto :goto_c8

    .line 474
    .end local v21           #top:I
    .restart local v22       #top:I
    :cond_100
    if-ne v6, v5, :cond_10f

    .line 476
    add-int/lit8 v8, v10, 0x1

    .line 477
    const/16 v23, 0x1

    shl-int v23, v23, v8

    add-int/lit8 v7, v23, -0x1

    .line 478
    add-int/lit8 v2, v5, 0x2

    .line 479
    move/from16 v18, v17

    .line 480
    goto :goto_b6

    .line 482
    :cond_10f
    move/from16 v0, v18

    move/from16 v1, v17

    if-ne v0, v1, :cond_12d

    .line 483
    move-object/from16 v0, p0

    iget-object v0, v0, Lmiui/util/GifDecoder;->pixelStack:[B

    move-object/from16 v23, v0

    add-int/lit8 v21, v22, 0x1

    .end local v22           #top:I
    .restart local v21       #top:I
    move-object/from16 v0, p0

    iget-object v0, v0, Lmiui/util/GifDecoder;->suffix:[B

    move-object/from16 v24, v0

    aget-byte v24, v24, v6

    aput-byte v24, v23, v22

    .line 484
    move/from16 v18, v6

    .line 485
    move v13, v6

    move/from16 v22, v21

    .line 486
    .end local v21           #top:I
    .restart local v22       #top:I
    goto :goto_b6

    .line 488
    :cond_12d
    move v15, v6

    .line 489
    .local v15, in_code:I
    if-ne v6, v2, :cond_141

    .line 490
    move-object/from16 v0, p0

    iget-object v0, v0, Lmiui/util/GifDecoder;->pixelStack:[B

    move-object/from16 v23, v0

    add-int/lit8 v21, v22, 0x1

    .end local v22           #top:I
    .restart local v21       #top:I
    int-to-byte v0, v13

    move/from16 v24, v0

    aput-byte v24, v23, v22

    .line 491
    move/from16 v6, v18

    move/from16 v22, v21

    .line 493
    .end local v21           #top:I
    .restart local v22       #top:I
    :cond_141
    :goto_141
    if-le v6, v5, :cond_160

    .line 494
    move-object/from16 v0, p0

    iget-object v0, v0, Lmiui/util/GifDecoder;->pixelStack:[B

    move-object/from16 v23, v0

    add-int/lit8 v21, v22, 0x1

    .end local v22           #top:I
    .restart local v21       #top:I
    move-object/from16 v0, p0

    iget-object v0, v0, Lmiui/util/GifDecoder;->suffix:[B

    move-object/from16 v24, v0

    aget-byte v24, v24, v6

    aput-byte v24, v23, v22

    .line 495
    move-object/from16 v0, p0

    iget-object v0, v0, Lmiui/util/GifDecoder;->prefix:[S

    move-object/from16 v23, v0

    aget-short v6, v23, v6

    move/from16 v22, v21

    .end local v21           #top:I
    .restart local v22       #top:I
    goto :goto_141

    .line 497
    :cond_160
    move-object/from16 v0, p0

    iget-object v0, v0, Lmiui/util/GifDecoder;->suffix:[B

    move-object/from16 v23, v0

    aget-byte v23, v23, v6

    move/from16 v0, v23

    and-int/lit16 v13, v0, 0xff

    .line 499
    const/16 v23, 0x1000

    move/from16 v0, v23

    if-lt v2, v0, :cond_176

    move/from16 v21, v22

    .line 500
    .end local v22           #top:I
    .restart local v21       #top:I
    goto/16 :goto_c8

    .line 502
    .end local v21           #top:I
    .restart local v22       #top:I
    :cond_176
    move-object/from16 v0, p0

    iget-object v0, v0, Lmiui/util/GifDecoder;->pixelStack:[B

    move-object/from16 v23, v0

    add-int/lit8 v21, v22, 0x1

    .end local v22           #top:I
    .restart local v21       #top:I
    int-to-byte v0, v13

    move/from16 v24, v0

    aput-byte v24, v23, v22

    .line 503
    move-object/from16 v0, p0

    iget-object v0, v0, Lmiui/util/GifDecoder;->prefix:[S

    move-object/from16 v23, v0

    move/from16 v0, v18

    int-to-short v0, v0

    move/from16 v24, v0

    aput-short v24, v23, v2

    .line 504
    move-object/from16 v0, p0

    iget-object v0, v0, Lmiui/util/GifDecoder;->suffix:[B

    move-object/from16 v23, v0

    int-to-byte v0, v13

    move/from16 v24, v0

    aput-byte v24, v23, v2

    .line 505
    add-int/lit8 v2, v2, 0x1

    .line 506
    and-int v23, v2, v7

    if-nez v23, :cond_1aa

    const/16 v23, 0x1000

    move/from16 v0, v23

    if-ge v2, v0, :cond_1aa

    .line 507
    add-int/lit8 v8, v8, 0x1

    .line 508
    add-int/2addr v7, v2

    .line 510
    :cond_1aa
    move/from16 v18, v15

    .line 513
    .end local v15           #in_code:I
    :goto_1ac
    add-int/lit8 v21, v21, -0x1

    .line 514
    move-object/from16 v0, p0

    iget-object v0, v0, Lmiui/util/GifDecoder;->pixels:[B

    move-object/from16 v23, v0

    add-int/lit8 v19, v20, 0x1

    .end local v20           #pi:I
    .restart local v19       #pi:I
    move-object/from16 v0, p0

    iget-object v0, v0, Lmiui/util/GifDecoder;->pixelStack:[B

    move-object/from16 v24, v0

    aget-byte v24, v24, v21

    aput-byte v24, v23, v20

    .line 515
    add-int/lit8 v14, v14, 0x1

    move/from16 v20, v19

    .end local v19           #pi:I
    .restart local v20       #pi:I
    move/from16 v22, v21

    .end local v21           #top:I
    .restart local v22       #top:I
    goto/16 :goto_b6

    .line 520
    .end local v22           #top:I
    .restart local v21       #top:I
    :cond_1c8
    return-void

    .end local v21           #top:I
    .restart local v22       #top:I
    :cond_1c9
    move/from16 v21, v22

    .end local v22           #top:I
    .restart local v21       #top:I
    goto/16 :goto_c8

    .end local v21           #top:I
    .restart local v22       #top:I
    :cond_1cd
    move/from16 v21, v22

    .end local v22           #top:I
    .restart local v21       #top:I
    goto :goto_1ac
.end method

.method protected err()Z
    .registers 2

    .prologue
    .line 526
    iget v0, p0, Lmiui/util/GifDecoder;->status:I

    if-eqz v0, :cond_6

    const/4 v0, 0x1

    :goto_5
    return v0

    :cond_6
    const/4 v0, 0x0

    goto :goto_5
.end method

.method public getBitmap()Landroid/graphics/Bitmap;
    .registers 2

    .prologue
    .line 193
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lmiui/util/GifDecoder;->getFrame(I)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method public getDelay(I)I
    .registers 4
    .parameter "n"

    .prologue
    .line 170
    const/4 v1, -0x1

    iput v1, p0, Lmiui/util/GifDecoder;->delay:I

    .line 171
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->getFrameCount()I

    move-result v0

    .line 172
    .local v0, frameCount:I
    if-ltz p1, :cond_17

    if-ge p1, v0, :cond_17

    .line 173
    iget-object v1, p0, Lmiui/util/GifDecoder;->frames:Ljava/util/Vector;

    invoke-virtual {v1, p1}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lmiui/util/GifDecoder$GifFrame;

    iget v1, v1, Lmiui/util/GifDecoder$GifFrame;->delay:I

    iput v1, p0, Lmiui/util/GifDecoder;->delay:I

    .line 175
    :cond_17
    iget v1, p0, Lmiui/util/GifDecoder;->delay:I

    return v1
.end method

.method public getFrame(I)Landroid/graphics/Bitmap;
    .registers 4
    .parameter "n"

    .prologue
    .line 317
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->getFrameCount()I

    move-result v0

    .line 318
    .local v0, frameCount:I
    if-gtz v0, :cond_8

    .line 319
    const/4 v1, 0x0

    .line 321
    :goto_7
    return-object v1

    .line 320
    :cond_8
    rem-int/2addr p1, v0

    .line 321
    iget-object v1, p0, Lmiui/util/GifDecoder;->frames:Ljava/util/Vector;

    invoke-virtual {v1, p1}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lmiui/util/GifDecoder$GifFrame;

    iget-object v1, v1, Lmiui/util/GifDecoder$GifFrame;->image:Landroid/graphics/Bitmap;

    goto :goto_7
.end method

.method public getFrameCount()I
    .registers 2

    .prologue
    .line 184
    iget-object v0, p0, Lmiui/util/GifDecoder;->frames:Ljava/util/Vector;

    if-nez v0, :cond_6

    const/4 v0, 0x0

    :goto_5
    return v0

    :cond_6
    iget-object v0, p0, Lmiui/util/GifDecoder;->frames:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->size()I

    move-result v0

    goto :goto_5
.end method

.method public getHeight()I
    .registers 2

    .prologue
    .line 863
    iget v0, p0, Lmiui/util/GifDecoder;->height:I

    return v0
.end method

.method public getLoopCount()I
    .registers 2

    .prologue
    .line 203
    iget v0, p0, Lmiui/util/GifDecoder;->loopCount:I

    return v0
.end method

.method public getRealFrameCount()I
    .registers 2

    .prologue
    .line 617
    iget-boolean v0, p0, Lmiui/util/GifDecoder;->mDecodeToTheEnd:Z

    if-eqz v0, :cond_7

    .line 618
    iget v0, p0, Lmiui/util/GifDecoder;->mDecodedFrames:I

    .line 620
    :goto_6
    return v0

    :cond_7
    const/4 v0, 0x0

    goto :goto_6
.end method

.method public getWidth()I
    .registers 2

    .prologue
    .line 859
    iget v0, p0, Lmiui/util/GifDecoder;->width:I

    return v0
.end method

.method protected init()V
    .registers 3

    .prologue
    const/4 v1, 0x0

    .line 533
    const/4 v0, 0x0

    iput v0, p0, Lmiui/util/GifDecoder;->status:I

    .line 534
    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    iput-object v0, p0, Lmiui/util/GifDecoder;->frames:Ljava/util/Vector;

    .line 535
    iput-object v1, p0, Lmiui/util/GifDecoder;->gct:[I

    .line 536
    iput-object v1, p0, Lmiui/util/GifDecoder;->lct:[I

    .line 537
    return-void
.end method

.method public isDecodeToTheEnd()Z
    .registers 2

    .prologue
    .line 126
    iget-boolean v0, p0, Lmiui/util/GifDecoder;->mDecodeToTheEnd:Z

    return v0
.end method

.method protected read()I
    .registers 4

    .prologue
    .line 543
    const/4 v0, 0x0

    .line 545
    .local v0, curByte:I
    :try_start_1
    iget-object v2, p0, Lmiui/util/GifDecoder;->in:Ljava/io/BufferedInputStream;

    invoke-virtual {v2}, Ljava/io/BufferedInputStream;->read()I
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_6} :catch_8

    move-result v0

    .line 549
    :goto_7
    return v0

    .line 546
    :catch_8
    move-exception v1

    .line 547
    .local v1, e:Ljava/lang/Exception;
    const/4 v2, 0x1

    iput v2, p0, Lmiui/util/GifDecoder;->status:I

    goto :goto_7
.end method

.method public read(Ljava/io/InputStream;)I
    .registers 7
    .parameter "is"

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    .line 382
    const/4 v2, 0x0

    iput-boolean v2, p0, Lmiui/util/GifDecoder;->mDecodeToTheEnd:Z

    .line 383
    iget-boolean v2, p0, Lmiui/util/GifDecoder;->calledOnce:Z

    if-eqz v2, :cond_11

    .line 384
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string v3, "decoder cannot be called more than once"

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 386
    :cond_11
    iput-boolean v3, p0, Lmiui/util/GifDecoder;->calledOnce:Z

    .line 387
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->init()V

    .line 388
    if-eqz p1, :cond_4c

    .line 389
    new-instance v2, Ljava/io/BufferedInputStream;

    invoke-direct {v2, p1}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    iput-object v2, p0, Lmiui/util/GifDecoder;->in:Ljava/io/BufferedInputStream;

    .line 391
    :try_start_1f
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->readHeader()V

    .line 392
    iget-boolean v2, p0, Lmiui/util/GifDecoder;->mCancel:Z

    if-nez v2, :cond_38

    invoke-virtual {p0}, Lmiui/util/GifDecoder;->err()Z

    move-result v2

    if-nez v2, :cond_38

    .line 393
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->readContents()V

    .line 394
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->getFrameCount()I

    move-result v1

    .line 395
    .local v1, frameCount:I
    if-gez v1, :cond_38

    .line 396
    const/4 v2, 0x1

    iput v2, p0, Lmiui/util/GifDecoder;->status:I
    :try_end_38
    .catch Ljava/lang/OutOfMemoryError; {:try_start_1f .. :try_end_38} :catch_45

    .line 407
    .end local v1           #frameCount:I
    :cond_38
    :goto_38
    iget-boolean v2, p0, Lmiui/util/GifDecoder;->mCancel:Z

    if-eqz v2, :cond_42

    .line 408
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->recycle()V

    .line 409
    const/4 v2, 0x3

    iput v2, p0, Lmiui/util/GifDecoder;->status:I

    .line 411
    :cond_42
    iget v2, p0, Lmiui/util/GifDecoder;->status:I

    return v2

    .line 399
    :catch_45
    move-exception v0

    .line 400
    .local v0, ex:Ljava/lang/OutOfMemoryError;
    iput v4, p0, Lmiui/util/GifDecoder;->status:I

    .line 401
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->recycle()V

    goto :goto_38

    .line 404
    .end local v0           #ex:Ljava/lang/OutOfMemoryError;
    :cond_4c
    iput v4, p0, Lmiui/util/GifDecoder;->status:I

    goto :goto_38
.end method

.method protected readBitmap()V
    .registers 7

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 737
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->readShort()I

    move-result v2

    iput v2, p0, Lmiui/util/GifDecoder;->ix:I

    .line 738
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->readShort()I

    move-result v2

    iput v2, p0, Lmiui/util/GifDecoder;->iy:I

    .line 739
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->readShort()I

    move-result v2

    iput v2, p0, Lmiui/util/GifDecoder;->iw:I

    .line 740
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->readShort()I

    move-result v2

    iput v2, p0, Lmiui/util/GifDecoder;->ih:I

    .line 741
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->read()I

    move-result v0

    .line 742
    .local v0, packed:I
    and-int/lit16 v2, v0, 0x80

    if-eqz v2, :cond_60

    move v2, v3

    :goto_23
    iput-boolean v2, p0, Lmiui/util/GifDecoder;->lctFlag:Z

    .line 743
    const/4 v2, 0x2

    and-int/lit8 v5, v0, 0x7

    shl-int/2addr v2, v5

    iput v2, p0, Lmiui/util/GifDecoder;->lctSize:I

    .line 747
    and-int/lit8 v2, v0, 0x40

    if-eqz v2, :cond_62

    move v2, v3

    :goto_30
    iput-boolean v2, p0, Lmiui/util/GifDecoder;->interlace:Z

    .line 748
    iget-boolean v2, p0, Lmiui/util/GifDecoder;->lctFlag:Z

    if-eqz v2, :cond_64

    .line 749
    iget v2, p0, Lmiui/util/GifDecoder;->lctSize:I

    invoke-virtual {p0, v2}, Lmiui/util/GifDecoder;->readColorTable(I)[I

    move-result-object v2

    iput-object v2, p0, Lmiui/util/GifDecoder;->lct:[I

    .line 750
    iget-object v2, p0, Lmiui/util/GifDecoder;->lct:[I

    iput-object v2, p0, Lmiui/util/GifDecoder;->act:[I

    .line 757
    :cond_42
    :goto_42
    const/4 v1, 0x0

    .line 758
    .local v1, save:I
    iget-boolean v2, p0, Lmiui/util/GifDecoder;->transparency:Z

    if-eqz v2, :cond_53

    .line 759
    iget-object v2, p0, Lmiui/util/GifDecoder;->act:[I

    iget v5, p0, Lmiui/util/GifDecoder;->transIndex:I

    aget v1, v2, v5

    .line 760
    iget-object v2, p0, Lmiui/util/GifDecoder;->act:[I

    iget v5, p0, Lmiui/util/GifDecoder;->transIndex:I

    aput v4, v2, v5

    .line 762
    :cond_53
    iget-object v2, p0, Lmiui/util/GifDecoder;->act:[I

    if-nez v2, :cond_59

    .line 763
    iput v3, p0, Lmiui/util/GifDecoder;->status:I

    .line 765
    :cond_59
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->err()Z

    move-result v2

    if-eqz v2, :cond_71

    .line 790
    :cond_5f
    :goto_5f
    return-void

    .end local v1           #save:I
    :cond_60
    move v2, v4

    .line 742
    goto :goto_23

    :cond_62
    move v2, v4

    .line 747
    goto :goto_30

    .line 752
    :cond_64
    iget-object v2, p0, Lmiui/util/GifDecoder;->gct:[I

    iput-object v2, p0, Lmiui/util/GifDecoder;->act:[I

    .line 753
    iget v2, p0, Lmiui/util/GifDecoder;->bgIndex:I

    iget v5, p0, Lmiui/util/GifDecoder;->transIndex:I

    if-ne v2, v5, :cond_42

    .line 754
    iput v4, p0, Lmiui/util/GifDecoder;->bgColor:I

    goto :goto_42

    .line 768
    .restart local v1       #save:I
    :cond_71
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->decodeBitmapData()V

    .line 769
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->skip()V

    .line 770
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->err()Z

    move-result v2

    if-nez v2, :cond_5f

    .line 774
    iget-boolean v2, p0, Lmiui/util/GifDecoder;->mCancel:Z

    if-nez v2, :cond_5f

    .line 777
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->setPixels()V

    .line 780
    iget v2, p0, Lmiui/util/GifDecoder;->mDecodedFrames:I

    iget v3, p0, Lmiui/util/GifDecoder;->mStartFrame:I

    if-lt v2, v3, :cond_98

    .line 781
    iget-object v2, p0, Lmiui/util/GifDecoder;->frames:Ljava/util/Vector;

    new-instance v3, Lmiui/util/GifDecoder$GifFrame;

    iget-object v4, p0, Lmiui/util/GifDecoder;->image:Landroid/graphics/Bitmap;

    iget v5, p0, Lmiui/util/GifDecoder;->delay:I

    invoke-direct {v3, v4, v5}, Lmiui/util/GifDecoder$GifFrame;-><init>(Landroid/graphics/Bitmap;I)V

    invoke-virtual {v2, v3}, Ljava/util/Vector;->addElement(Ljava/lang/Object;)V

    .line 783
    :cond_98
    iget v2, p0, Lmiui/util/GifDecoder;->mDecodedFrames:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lmiui/util/GifDecoder;->mDecodedFrames:I

    .line 786
    iget-boolean v2, p0, Lmiui/util/GifDecoder;->transparency:Z

    if-eqz v2, :cond_a8

    .line 787
    iget-object v2, p0, Lmiui/util/GifDecoder;->act:[I

    iget v3, p0, Lmiui/util/GifDecoder;->transIndex:I

    aput v1, v2, v3

    .line 789
    :cond_a8
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->resetFrame()V

    goto :goto_5f
.end method

.method protected readBlock()I
    .registers 7

    .prologue
    .line 558
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->read()I

    move-result v3

    iput v3, p0, Lmiui/util/GifDecoder;->blockSize:I

    .line 559
    const/4 v2, 0x0

    .line 560
    .local v2, n:I
    iget v3, p0, Lmiui/util/GifDecoder;->blockSize:I

    if-lez v3, :cond_25

    .line 562
    const/4 v0, 0x0

    .line 563
    .local v0, count:I
    :goto_c
    :try_start_c
    iget v3, p0, Lmiui/util/GifDecoder;->blockSize:I

    if-ge v2, v3, :cond_1e

    .line 564
    iget-object v3, p0, Lmiui/util/GifDecoder;->in:Ljava/io/BufferedInputStream;

    iget-object v4, p0, Lmiui/util/GifDecoder;->block:[B

    iget v5, p0, Lmiui/util/GifDecoder;->blockSize:I

    sub-int/2addr v5, v2

    invoke-virtual {v3, v4, v2, v5}, Ljava/io/BufferedInputStream;->read([BII)I
    :try_end_1a
    .catch Ljava/lang/Exception; {:try_start_c .. :try_end_1a} :catch_28

    move-result v0

    .line 565
    const/4 v3, -0x1

    if-ne v0, v3, :cond_26

    .line 573
    :cond_1e
    :goto_1e
    iget v3, p0, Lmiui/util/GifDecoder;->blockSize:I

    if-ge v2, v3, :cond_25

    .line 574
    const/4 v3, 0x1

    iput v3, p0, Lmiui/util/GifDecoder;->status:I

    .line 577
    .end local v0           #count:I
    :cond_25
    return v2

    .line 568
    .restart local v0       #count:I
    :cond_26
    add-int/2addr v2, v0

    goto :goto_c

    .line 570
    :catch_28
    move-exception v1

    .line 571
    .local v1, e:Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1e
.end method

.method protected readColorTable(I)[I
    .registers 18
    .parameter "ncolors"

    .prologue
    .line 587
    mul-int/lit8 v10, p1, 0x3

    .line 588
    .local v10, nbytes:I
    const/4 v12, 0x0

    .line 589
    .local v12, tab:[I
    new-array v2, v10, [B

    .line 590
    .local v2, c:[B
    const/4 v9, 0x0

    .line 592
    .local v9, n:I
    :try_start_6
    move-object/from16 v0, p0

    iget-object v13, v0, Lmiui/util/GifDecoder;->in:Ljava/io/BufferedInputStream;

    const/4 v14, 0x0

    array-length v15, v2

    invoke-virtual {v13, v2, v14, v15}, Ljava/io/BufferedInputStream;->read([BII)I
    :try_end_f
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_f} :catch_18

    move-result v9

    .line 596
    :goto_10
    if-ge v9, v10, :cond_1d

    .line 597
    const/4 v13, 0x1

    move-object/from16 v0, p0

    iput v13, v0, Lmiui/util/GifDecoder;->status:I

    .line 609
    :cond_17
    return-object v12

    .line 593
    :catch_18
    move-exception v3

    .line 594
    .local v3, e:Ljava/lang/Exception;
    invoke-virtual {v3}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_10

    .line 599
    .end local v3           #e:Ljava/lang/Exception;
    :cond_1d
    const/16 v13, 0x100

    new-array v12, v13, [I

    .line 600
    const/4 v5, 0x0

    .line 601
    .local v5, i:I
    const/4 v7, 0x0

    .local v7, j:I
    move v8, v7

    .end local v7           #j:I
    .local v8, j:I
    move v6, v5

    .line 602
    .end local v5           #i:I
    .local v6, i:I
    :goto_25
    move/from16 v0, p1

    if-ge v6, v0, :cond_17

    .line 603
    add-int/lit8 v7, v8, 0x1

    .end local v8           #j:I
    .restart local v7       #j:I
    aget-byte v13, v2, v8

    and-int/lit16 v11, v13, 0xff

    .line 604
    .local v11, r:I
    add-int/lit8 v8, v7, 0x1

    .end local v7           #j:I
    .restart local v8       #j:I
    aget-byte v13, v2, v7

    and-int/lit16 v4, v13, 0xff

    .line 605
    .local v4, g:I
    add-int/lit8 v7, v8, 0x1

    .end local v8           #j:I
    .restart local v7       #j:I
    aget-byte v13, v2, v8

    and-int/lit16 v1, v13, 0xff

    .line 606
    .local v1, b:I
    add-int/lit8 v5, v6, 0x1

    .end local v6           #i:I
    .restart local v5       #i:I
    const/high16 v13, -0x100

    shl-int/lit8 v14, v11, 0x10

    or-int/2addr v13, v14

    shl-int/lit8 v14, v4, 0x8

    or-int/2addr v13, v14

    or-int/2addr v13, v1

    aput v13, v12, v6

    move v8, v7

    .end local v7           #j:I
    .restart local v8       #j:I
    move v6, v5

    .line 607
    .end local v5           #i:I
    .restart local v6       #i:I
    goto :goto_25
.end method

.method protected readContents()V
    .registers 11

    .prologue
    const/4 v9, 0x1

    .line 628
    const/4 v5, 0x0

    iput v5, p0, Lmiui/util/GifDecoder;->mDecodedFrames:I

    .line 629
    const/4 v2, 0x0

    .line 630
    .local v2, done:Z
    :cond_5
    :goto_5
    if-nez v2, :cond_11

    invoke-virtual {p0}, Lmiui/util/GifDecoder;->err()Z

    move-result v5

    if-nez v5, :cond_11

    .line 631
    iget-boolean v5, p0, Lmiui/util/GifDecoder;->mCancel:Z

    if-eqz v5, :cond_12

    .line 688
    :cond_11
    return-void

    .line 634
    :cond_12
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->read()I

    move-result v1

    .line 635
    .local v1, code:I
    sparse-switch v1, :sswitch_data_9e

    .line 685
    iput v9, p0, Lmiui/util/GifDecoder;->status:I

    goto :goto_5

    .line 638
    :sswitch_1c
    iget-object v5, p0, Lmiui/util/GifDecoder;->frames:Ljava/util/Vector;

    invoke-virtual {v5}, Ljava/util/Vector;->size()I

    move-result v3

    .line 640
    .local v3, framesBeforeRead:I
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->readBitmap()V

    .line 642
    iget-object v5, p0, Lmiui/util/GifDecoder;->frames:Ljava/util/Vector;

    invoke-virtual {v5}, Ljava/util/Vector;->size()I

    move-result v5

    if-le v5, v3, :cond_40

    .line 643
    iget-wide v5, p0, Lmiui/util/GifDecoder;->mDecodeBmSize:J

    iget-object v7, p0, Lmiui/util/GifDecoder;->image:Landroid/graphics/Bitmap;

    invoke-virtual {v7}, Landroid/graphics/Bitmap;->getRowBytes()I

    move-result v7

    iget-object v8, p0, Lmiui/util/GifDecoder;->image:Landroid/graphics/Bitmap;

    invoke-virtual {v8}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v8

    mul-int/2addr v7, v8

    int-to-long v7, v7

    add-long/2addr v5, v7

    iput-wide v5, p0, Lmiui/util/GifDecoder;->mDecodeBmSize:J

    .line 645
    :cond_40
    iget-wide v5, p0, Lmiui/util/GifDecoder;->mDecodeBmSize:J

    iget-wide v7, p0, Lmiui/util/GifDecoder;->mMaxDecodeSize:J

    cmp-long v5, v5, v7

    if-lez v5, :cond_5

    .line 646
    const/4 v2, 0x1

    goto :goto_5

    .line 650
    .end local v3           #framesBeforeRead:I
    :sswitch_4a
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->read()I

    move-result v1

    .line 651
    sparse-switch v1, :sswitch_data_ac

    .line 674
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->skip()V

    goto :goto_5

    .line 653
    :sswitch_55
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->readGraphicControlExt()V

    goto :goto_5

    .line 656
    :sswitch_59
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->readBlock()I

    .line 657
    const-string v0, ""

    .line 658
    .local v0, app:Ljava/lang/String;
    const/4 v4, 0x0

    .local v4, i:I
    :goto_5f
    const/16 v5, 0xb

    if-ge v4, v5, :cond_7c

    .line 659
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lmiui/util/GifDecoder;->block:[B

    aget-byte v6, v6, v4

    int-to-char v6, v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 658
    add-int/lit8 v4, v4, 0x1

    goto :goto_5f

    .line 661
    :cond_7c
    const-string v5, "NETSCAPE2.0"

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_89

    .line 662
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->readNetscapeExt()V

    goto/16 :goto_5

    .line 664
    :cond_89
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->skip()V

    goto/16 :goto_5

    .line 668
    .end local v0           #app:Ljava/lang/String;
    .end local v4           #i:I
    :sswitch_8e
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->skip()V

    goto/16 :goto_5

    .line 671
    :sswitch_93
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->skip()V

    goto/16 :goto_5

    .line 678
    :sswitch_98
    const/4 v2, 0x1

    .line 680
    iput-boolean v9, p0, Lmiui/util/GifDecoder;->mDecodeToTheEnd:Z

    goto/16 :goto_5

    .line 635
    nop

    :sswitch_data_9e
    .sparse-switch
        0x21 -> :sswitch_4a
        0x2c -> :sswitch_1c
        0x3b -> :sswitch_98
    .end sparse-switch

    .line 651
    :sswitch_data_ac
    .sparse-switch
        0x1 -> :sswitch_93
        0xf9 -> :sswitch_55
        0xfe -> :sswitch_8e
        0xff -> :sswitch_59
    .end sparse-switch
.end method

.method protected readGraphicControlExt()V
    .registers 4

    .prologue
    const/4 v1, 0x1

    .line 694
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->read()I

    .line 695
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->read()I

    move-result v0

    .line 696
    .local v0, packed:I
    and-int/lit8 v2, v0, 0x1c

    shr-int/lit8 v2, v2, 0x2

    iput v2, p0, Lmiui/util/GifDecoder;->dispose:I

    .line 697
    iget v2, p0, Lmiui/util/GifDecoder;->dispose:I

    if-nez v2, :cond_14

    .line 698
    iput v1, p0, Lmiui/util/GifDecoder;->dispose:I

    .line 700
    :cond_14
    and-int/lit8 v2, v0, 0x1

    if-eqz v2, :cond_34

    :goto_18
    iput-boolean v1, p0, Lmiui/util/GifDecoder;->transparency:Z

    .line 701
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->readShort()I

    move-result v1

    mul-int/lit8 v1, v1, 0xa

    iput v1, p0, Lmiui/util/GifDecoder;->delay:I

    .line 702
    iget v1, p0, Lmiui/util/GifDecoder;->delay:I

    if-gtz v1, :cond_2a

    .line 703
    const/16 v1, 0x64

    iput v1, p0, Lmiui/util/GifDecoder;->delay:I

    .line 705
    :cond_2a
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->read()I

    move-result v1

    iput v1, p0, Lmiui/util/GifDecoder;->transIndex:I

    .line 706
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->read()I

    .line 707
    return-void

    .line 700
    :cond_34
    const/4 v1, 0x0

    goto :goto_18
.end method

.method protected readHeader()V
    .registers 5

    .prologue
    .line 713
    iget-boolean v2, p0, Lmiui/util/GifDecoder;->mCancel:Z

    if-eqz v2, :cond_5

    .line 731
    :cond_4
    :goto_4
    return-void

    .line 717
    :cond_5
    const-string v1, ""

    .line 718
    .local v1, id:Ljava/lang/String;
    const/4 v0, 0x0

    .local v0, i:I
    :goto_8
    const/4 v2, 0x6

    if-ge v0, v2, :cond_24

    .line 719
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lmiui/util/GifDecoder;->read()I

    move-result v3

    int-to-char v3, v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 718
    add-int/lit8 v0, v0, 0x1

    goto :goto_8

    .line 721
    :cond_24
    const-string v2, "GIF"

    invoke-virtual {v1, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_30

    .line 722
    const/4 v2, 0x1

    iput v2, p0, Lmiui/util/GifDecoder;->status:I

    goto :goto_4

    .line 726
    :cond_30
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->readLSD()V

    .line 727
    iget-boolean v2, p0, Lmiui/util/GifDecoder;->gctFlag:Z

    if-eqz v2, :cond_4

    invoke-virtual {p0}, Lmiui/util/GifDecoder;->err()Z

    move-result v2

    if-nez v2, :cond_4

    .line 728
    iget v2, p0, Lmiui/util/GifDecoder;->gctSize:I

    invoke-virtual {p0, v2}, Lmiui/util/GifDecoder;->readColorTable(I)[I

    move-result-object v2

    iput-object v2, p0, Lmiui/util/GifDecoder;->gct:[I

    .line 729
    iget-object v2, p0, Lmiui/util/GifDecoder;->gct:[I

    iget v3, p0, Lmiui/util/GifDecoder;->bgIndex:I

    aget v2, v2, v3

    iput v2, p0, Lmiui/util/GifDecoder;->bgColor:I

    goto :goto_4
.end method

.method protected readLSD()V
    .registers 4

    .prologue
    .line 797
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->readShort()I

    move-result v1

    iput v1, p0, Lmiui/util/GifDecoder;->width:I

    .line 798
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->readShort()I

    move-result v1

    iput v1, p0, Lmiui/util/GifDecoder;->height:I

    .line 800
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->read()I

    move-result v0

    .line 801
    .local v0, packed:I
    and-int/lit16 v1, v0, 0x80

    if-eqz v1, :cond_2a

    const/4 v1, 0x1

    :goto_15
    iput-boolean v1, p0, Lmiui/util/GifDecoder;->gctFlag:Z

    .line 804
    const/4 v1, 0x2

    and-int/lit8 v2, v0, 0x7

    shl-int/2addr v1, v2

    iput v1, p0, Lmiui/util/GifDecoder;->gctSize:I

    .line 805
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->read()I

    move-result v1

    iput v1, p0, Lmiui/util/GifDecoder;->bgIndex:I

    .line 806
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->read()I

    move-result v1

    iput v1, p0, Lmiui/util/GifDecoder;->pixelAspect:I

    .line 807
    return-void

    .line 801
    :cond_2a
    const/4 v1, 0x0

    goto :goto_15
.end method

.method protected readNetscapeExt()V
    .registers 6

    .prologue
    const/4 v4, 0x1

    .line 814
    :cond_1
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->readBlock()I

    .line 815
    iget-object v2, p0, Lmiui/util/GifDecoder;->block:[B

    const/4 v3, 0x0

    aget-byte v2, v2, v3

    if-ne v2, v4, :cond_1d

    .line 817
    iget-object v2, p0, Lmiui/util/GifDecoder;->block:[B

    aget-byte v2, v2, v4

    and-int/lit16 v0, v2, 0xff

    .line 818
    .local v0, b1:I
    iget-object v2, p0, Lmiui/util/GifDecoder;->block:[B

    const/4 v3, 0x2

    aget-byte v2, v2, v3

    and-int/lit16 v1, v2, 0xff

    .line 819
    .local v1, b2:I
    shl-int/lit8 v2, v1, 0x8

    or-int/2addr v2, v0

    iput v2, p0, Lmiui/util/GifDecoder;->loopCount:I

    .line 821
    .end local v0           #b1:I
    .end local v1           #b2:I
    :cond_1d
    iget v2, p0, Lmiui/util/GifDecoder;->blockSize:I

    if-lez v2, :cond_27

    invoke-virtual {p0}, Lmiui/util/GifDecoder;->err()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 822
    :cond_27
    return-void
.end method

.method protected readShort()I
    .registers 3

    .prologue
    .line 829
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->read()I

    move-result v0

    invoke-virtual {p0}, Lmiui/util/GifDecoder;->read()I

    move-result v1

    shl-int/lit8 v1, v1, 0x8

    or-int/2addr v0, v1

    return v0
.end method

.method public recycle()V
    .registers 4

    .prologue
    .line 134
    iget-object v2, p0, Lmiui/util/GifDecoder;->frames:Ljava/util/Vector;

    if-eqz v2, :cond_1b

    .line 135
    iget-object v2, p0, Lmiui/util/GifDecoder;->frames:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->size()I

    move-result v0

    .line 136
    .local v0, count:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_b
    if-ge v1, v0, :cond_1b

    .line 137
    iget-object v2, p0, Lmiui/util/GifDecoder;->frames:Ljava/util/Vector;

    invoke-virtual {v2, v1}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lmiui/util/GifDecoder$GifFrame;

    invoke-virtual {v2}, Lmiui/util/GifDecoder$GifFrame;->recycle()V

    .line 136
    add-int/lit8 v1, v1, 0x1

    goto :goto_b

    .line 140
    .end local v0           #count:I
    .end local v1           #i:I
    :cond_1b
    return-void
.end method

.method public requestCancelDecode()V
    .registers 2

    .prologue
    .line 329
    const/4 v0, 0x1

    iput-boolean v0, p0, Lmiui/util/GifDecoder;->mCancel:Z

    .line 330
    invoke-direct {p0}, Lmiui/util/GifDecoder;->requestCancel()V

    .line 331
    return-void
.end method

.method protected resetFrame()V
    .registers 3

    .prologue
    const/4 v1, 0x0

    .line 836
    iget v0, p0, Lmiui/util/GifDecoder;->dispose:I

    iput v0, p0, Lmiui/util/GifDecoder;->lastDispose:I

    .line 837
    iget v0, p0, Lmiui/util/GifDecoder;->ix:I

    iput v0, p0, Lmiui/util/GifDecoder;->lrx:I

    .line 838
    iget v0, p0, Lmiui/util/GifDecoder;->iy:I

    iput v0, p0, Lmiui/util/GifDecoder;->lry:I

    .line 839
    iget v0, p0, Lmiui/util/GifDecoder;->iw:I

    iput v0, p0, Lmiui/util/GifDecoder;->lrw:I

    .line 840
    iget v0, p0, Lmiui/util/GifDecoder;->ih:I

    iput v0, p0, Lmiui/util/GifDecoder;->lrh:I

    .line 841
    iget-object v0, p0, Lmiui/util/GifDecoder;->image:Landroid/graphics/Bitmap;

    iput-object v0, p0, Lmiui/util/GifDecoder;->lastBitmap:Landroid/graphics/Bitmap;

    .line 842
    iget v0, p0, Lmiui/util/GifDecoder;->bgColor:I

    iput v0, p0, Lmiui/util/GifDecoder;->lastBgColor:I

    .line 843
    iput v1, p0, Lmiui/util/GifDecoder;->dispose:I

    .line 844
    iput-boolean v1, p0, Lmiui/util/GifDecoder;->transparency:Z

    .line 845
    iput v1, p0, Lmiui/util/GifDecoder;->delay:I

    .line 846
    const/4 v0, 0x0

    iput-object v0, p0, Lmiui/util/GifDecoder;->lct:[I

    .line 847
    return-void
.end method

.method public setMaxDecodeSize(J)V
    .registers 3
    .parameter "maxDecodeSize"

    .prologue
    .line 143
    iput-wide p1, p0, Lmiui/util/GifDecoder;->mMaxDecodeSize:J

    .line 144
    return-void
.end method

.method protected setPixels()V
    .registers 26

    .prologue
    .line 212
    move-object/from16 v0, p0

    iget-object v1, v0, Lmiui/util/GifDecoder;->dest:[I

    if-nez v1, :cond_15

    .line 213
    move-object/from16 v0, p0

    iget v1, v0, Lmiui/util/GifDecoder;->width:I

    move-object/from16 v0, p0

    iget v2, v0, Lmiui/util/GifDecoder;->height:I

    mul-int/2addr v1, v2

    new-array v1, v1, [I

    move-object/from16 v0, p0

    iput-object v1, v0, Lmiui/util/GifDecoder;->dest:[I

    .line 216
    :cond_15
    move-object/from16 v0, p0

    iget v1, v0, Lmiui/util/GifDecoder;->lastDispose:I

    if-lez v1, :cond_bb

    .line 217
    move-object/from16 v0, p0

    iget v1, v0, Lmiui/util/GifDecoder;->lastDispose:I

    const/4 v2, 0x3

    if-ne v1, v2, :cond_5a

    .line 219
    invoke-virtual/range {p0 .. p0}, Lmiui/util/GifDecoder;->getFrameCount()I

    move-result v1

    add-int/lit8 v20, v1, -0x2

    .line 220
    .local v20, n:I
    if-lez v20, :cond_9d

    .line 221
    add-int/lit8 v1, v20, -0x1

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Lmiui/util/GifDecoder;->getFrame(I)Landroid/graphics/Bitmap;

    move-result-object v9

    .line 222
    .local v9, bm:Landroid/graphics/Bitmap;
    move-object/from16 v0, p0

    iget-object v1, v0, Lmiui/util/GifDecoder;->lastBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v9, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_5a

    .line 223
    move-object/from16 v0, p0

    iput-object v9, v0, Lmiui/util/GifDecoder;->lastBitmap:Landroid/graphics/Bitmap;

    .line 224
    move-object/from16 v0, p0

    iget-object v1, v0, Lmiui/util/GifDecoder;->lastBitmap:Landroid/graphics/Bitmap;

    move-object/from16 v0, p0

    iget-object v2, v0, Lmiui/util/GifDecoder;->dest:[I

    const/4 v3, 0x0

    move-object/from16 v0, p0

    iget v4, v0, Lmiui/util/GifDecoder;->width:I

    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object/from16 v0, p0

    iget v7, v0, Lmiui/util/GifDecoder;->width:I

    move-object/from16 v0, p0

    iget v8, v0, Lmiui/util/GifDecoder;->height:I

    invoke-virtual/range {v1 .. v8}, Landroid/graphics/Bitmap;->getPixels([IIIIIII)V

    .line 231
    .end local v9           #bm:Landroid/graphics/Bitmap;
    .end local v20           #n:I
    :cond_5a
    :goto_5a
    move-object/from16 v0, p0

    iget-object v1, v0, Lmiui/util/GifDecoder;->lastBitmap:Landroid/graphics/Bitmap;

    if-eqz v1, :cond_bb

    .line 233
    move-object/from16 v0, p0

    iget v1, v0, Lmiui/util/GifDecoder;->lastDispose:I

    const/4 v2, 0x2

    if-ne v1, v2, :cond_bb

    .line 235
    const/4 v10, 0x0

    .line 236
    .local v10, c:I
    move-object/from16 v0, p0

    iget-boolean v1, v0, Lmiui/util/GifDecoder;->transparency:Z

    if-nez v1, :cond_72

    .line 237
    move-object/from16 v0, p0

    iget v10, v0, Lmiui/util/GifDecoder;->lastBgColor:I

    .line 239
    :cond_72
    move-object/from16 v0, p0

    iget v1, v0, Lmiui/util/GifDecoder;->lry:I

    move-object/from16 v0, p0

    iget v2, v0, Lmiui/util/GifDecoder;->width:I

    mul-int/2addr v1, v2

    move-object/from16 v0, p0

    iget v2, v0, Lmiui/util/GifDecoder;->lrx:I

    add-int v22, v1, v2

    .line 240
    .local v22, start:I
    const/4 v14, 0x0

    .local v14, i:I
    :goto_82
    move-object/from16 v0, p0

    iget v1, v0, Lmiui/util/GifDecoder;->lrh:I

    if-ge v14, v1, :cond_bb

    .line 241
    move-object/from16 v0, p0

    iget v1, v0, Lmiui/util/GifDecoder;->lrw:I

    add-int v13, v22, v1

    .line 242
    .local v13, end:I
    move/from16 v18, v22

    .local v18, k:I
    :goto_90
    move/from16 v0, v18

    if-ge v0, v13, :cond_b2

    .line 243
    move-object/from16 v0, p0

    iget-object v1, v0, Lmiui/util/GifDecoder;->dest:[I

    aput v10, v1, v18

    .line 242
    add-int/lit8 v18, v18, 0x1

    goto :goto_90

    .line 227
    .end local v10           #c:I
    .end local v13           #end:I
    .end local v14           #i:I
    .end local v18           #k:I
    .end local v22           #start:I
    .restart local v20       #n:I
    :cond_9d
    const/4 v1, 0x0

    move-object/from16 v0, p0

    iput-object v1, v0, Lmiui/util/GifDecoder;->lastBitmap:Landroid/graphics/Bitmap;

    .line 228
    move-object/from16 v0, p0

    iget v1, v0, Lmiui/util/GifDecoder;->width:I

    move-object/from16 v0, p0

    iget v2, v0, Lmiui/util/GifDecoder;->height:I

    mul-int/2addr v1, v2

    new-array v1, v1, [I

    move-object/from16 v0, p0

    iput-object v1, v0, Lmiui/util/GifDecoder;->dest:[I

    goto :goto_5a

    .line 245
    .end local v20           #n:I
    .restart local v10       #c:I
    .restart local v13       #end:I
    .restart local v14       #i:I
    .restart local v18       #k:I
    .restart local v22       #start:I
    :cond_b2
    move-object/from16 v0, p0

    iget v1, v0, Lmiui/util/GifDecoder;->width:I

    add-int v22, v22, v1

    .line 240
    add-int/lit8 v14, v14, 0x1

    goto :goto_82

    .line 251
    .end local v10           #c:I
    .end local v13           #end:I
    .end local v14           #i:I
    .end local v18           #k:I
    .end local v22           #start:I
    :cond_bb
    const/16 v21, 0x1

    .line 252
    .local v21, pass:I
    const/16 v16, 0x8

    .line 253
    .local v16, inc:I
    const/4 v15, 0x0

    .line 254
    .local v15, iline:I
    const/4 v14, 0x0

    .restart local v14       #i:I
    :goto_c1
    move-object/from16 v0, p0

    iget v1, v0, Lmiui/util/GifDecoder;->ih:I

    if-ge v14, v1, :cond_142

    .line 255
    move/from16 v19, v14

    .line 256
    .local v19, line:I
    move-object/from16 v0, p0

    iget-boolean v1, v0, Lmiui/util/GifDecoder;->interlace:Z

    if-eqz v1, :cond_de

    .line 257
    move-object/from16 v0, p0

    iget v1, v0, Lmiui/util/GifDecoder;->ih:I

    if-lt v15, v1, :cond_da

    .line 258
    add-int/lit8 v21, v21, 0x1

    .line 259
    packed-switch v21, :pswitch_data_17a

    .line 275
    :cond_da
    :goto_da
    move/from16 v19, v15

    .line 276
    add-int v15, v15, v16

    .line 278
    :cond_de
    move-object/from16 v0, p0

    iget v1, v0, Lmiui/util/GifDecoder;->iy:I

    add-int v19, v19, v1

    .line 279
    move-object/from16 v0, p0

    iget v1, v0, Lmiui/util/GifDecoder;->height:I

    move/from16 v0, v19

    if-ge v0, v1, :cond_13f

    .line 280
    move-object/from16 v0, p0

    iget v1, v0, Lmiui/util/GifDecoder;->width:I

    mul-int v18, v19, v1

    .line 281
    .restart local v18       #k:I
    move-object/from16 v0, p0

    iget v1, v0, Lmiui/util/GifDecoder;->ix:I

    add-int v12, v18, v1

    .line 282
    .local v12, dx:I
    move-object/from16 v0, p0

    iget v1, v0, Lmiui/util/GifDecoder;->iw:I

    add-int v11, v12, v1

    .line 283
    .local v11, dlim:I
    move-object/from16 v0, p0

    iget v1, v0, Lmiui/util/GifDecoder;->width:I

    add-int v1, v1, v18

    if-ge v1, v11, :cond_10c

    .line 284
    move-object/from16 v0, p0

    iget v1, v0, Lmiui/util/GifDecoder;->width:I

    add-int v11, v18, v1

    .line 286
    :cond_10c
    move-object/from16 v0, p0

    iget v1, v0, Lmiui/util/GifDecoder;->iw:I

    mul-int v23, v14, v1

    .local v23, sx:I
    move/from16 v24, v23

    .line 287
    .end local v23           #sx:I
    .local v24, sx:I
    :goto_114
    if-ge v12, v11, :cond_13f

    .line 289
    move-object/from16 v0, p0

    iget-object v1, v0, Lmiui/util/GifDecoder;->pixels:[B

    add-int/lit8 v23, v24, 0x1

    .end local v24           #sx:I
    .restart local v23       #sx:I
    aget-byte v1, v1, v24

    and-int/lit16 v0, v1, 0xff

    move/from16 v17, v0

    .line 290
    .local v17, index:I
    move-object/from16 v0, p0

    iget-object v1, v0, Lmiui/util/GifDecoder;->act:[I

    aget v10, v1, v17

    .line 291
    .restart local v10       #c:I
    if-eqz v10, :cond_130

    .line 292
    move-object/from16 v0, p0

    iget-object v1, v0, Lmiui/util/GifDecoder;->dest:[I

    aput v10, v1, v12

    .line 294
    :cond_130
    add-int/lit8 v12, v12, 0x1

    move/from16 v24, v23

    .line 295
    .end local v23           #sx:I
    .restart local v24       #sx:I
    goto :goto_114

    .line 261
    .end local v10           #c:I
    .end local v11           #dlim:I
    .end local v12           #dx:I
    .end local v17           #index:I
    .end local v18           #k:I
    .end local v24           #sx:I
    :pswitch_135
    const/4 v15, 0x4

    .line 262
    goto :goto_da

    .line 264
    :pswitch_137
    const/4 v15, 0x2

    .line 265
    const/16 v16, 0x4

    .line 266
    goto :goto_da

    .line 268
    :pswitch_13b
    const/4 v15, 0x1

    .line 269
    const/16 v16, 0x2

    .line 270
    goto :goto_da

    .line 254
    :cond_13f
    add-int/lit8 v14, v14, 0x1

    goto :goto_c1

    .line 302
    .end local v19           #line:I
    :cond_142
    move-object/from16 v0, p0

    iget v1, v0, Lmiui/util/GifDecoder;->mDecodedFrames:I

    move-object/from16 v0, p0

    iget v2, v0, Lmiui/util/GifDecoder;->mStartFrame:I

    if-gt v1, v2, :cond_163

    .line 303
    move-object/from16 v0, p0

    iget-object v1, v0, Lmiui/util/GifDecoder;->image:Landroid/graphics/Bitmap;

    if-eqz v1, :cond_163

    move-object/from16 v0, p0

    iget-object v1, v0, Lmiui/util/GifDecoder;->image:Landroid/graphics/Bitmap;

    invoke-virtual {v1}, Landroid/graphics/Bitmap;->isRecycled()Z

    move-result v1

    if-nez v1, :cond_163

    .line 304
    move-object/from16 v0, p0

    iget-object v1, v0, Lmiui/util/GifDecoder;->image:Landroid/graphics/Bitmap;

    invoke-virtual {v1}, Landroid/graphics/Bitmap;->recycle()V

    .line 308
    :cond_163
    move-object/from16 v0, p0

    iget-object v1, v0, Lmiui/util/GifDecoder;->dest:[I

    move-object/from16 v0, p0

    iget v2, v0, Lmiui/util/GifDecoder;->width:I

    move-object/from16 v0, p0

    iget v3, v0, Lmiui/util/GifDecoder;->height:I

    sget-object v4, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v1, v2, v3, v4}, Landroid/graphics/Bitmap;->createBitmap([IIILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lmiui/util/GifDecoder;->image:Landroid/graphics/Bitmap;

    .line 309
    return-void

    .line 259
    :pswitch_data_17a
    .packed-switch 0x2
        :pswitch_135
        :pswitch_137
        :pswitch_13b
    .end packed-switch
.end method

.method public setStartFrame(I)V
    .registers 2
    .parameter "startFrame"

    .prologue
    .line 130
    iput p1, p0, Lmiui/util/GifDecoder;->mStartFrame:I

    .line 131
    return-void
.end method

.method protected skip()V
    .registers 2

    .prologue
    .line 854
    :cond_0
    invoke-virtual {p0}, Lmiui/util/GifDecoder;->readBlock()I

    .line 855
    iget v0, p0, Lmiui/util/GifDecoder;->blockSize:I

    if-lez v0, :cond_d

    invoke-virtual {p0}, Lmiui/util/GifDecoder;->err()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 856
    :cond_d
    return-void
.end method
