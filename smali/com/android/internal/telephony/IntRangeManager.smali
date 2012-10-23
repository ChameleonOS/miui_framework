.class public abstract Lcom/android/internal/telephony/IntRangeManager;
.super Ljava/lang/Object;
.source "IntRangeManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/internal/telephony/IntRangeManager$ClientRange;,
        Lcom/android/internal/telephony/IntRangeManager$IntRange;
    }
.end annotation


# static fields
.field private static final INITIAL_CLIENTS_ARRAY_SIZE:I = 0x4


# instance fields
.field private mRanges:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/internal/telephony/IntRangeManager$IntRange;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method protected constructor <init>()V
    .registers 2

    .prologue
    .line 165
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 163
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/android/internal/telephony/IntRangeManager;->mRanges:Ljava/util/ArrayList;

    .line 165
    return-void
.end method

.method private tryAddSingleRange(IIZ)Z
    .registers 5
    .parameter "startId"
    .parameter "endId"
    .parameter "selected"

    .prologue
    .line 540
    invoke-virtual {p0}, Lcom/android/internal/telephony/IntRangeManager;->startUpdate()V

    .line 541
    invoke-virtual {p0, p1, p2, p3}, Lcom/android/internal/telephony/IntRangeManager;->addRange(IIZ)V

    .line 542
    invoke-virtual {p0}, Lcom/android/internal/telephony/IntRangeManager;->finishUpdate()Z

    move-result v0

    return v0
.end method


# virtual methods
.method protected abstract addRange(IIZ)V
.end method

.method public declared-synchronized disableRange(IILjava/lang/String;)Z
    .registers 26
    .parameter "startId"
    .parameter "endId"
    .parameter "client"

    .prologue
    .line 364
    monitor-enter p0

    :try_start_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/telephony/IntRangeManager;->mRanges:Ljava/util/ArrayList;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Ljava/util/ArrayList;->size()I

    move-result v11

    .line 366
    .local v11, len:I
    const/4 v9, 0x0

    .local v9, i:I
    :goto_c
    if-ge v9, v11, :cond_20a

    .line 367
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/telephony/IntRangeManager;->mRanges:Ljava/util/ArrayList;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    invoke-virtual {v0, v9}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Lcom/android/internal/telephony/IntRangeManager$IntRange;

    .line 368
    .local v16, range:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    move-object/from16 v0, v16

    iget v0, v0, Lcom/android/internal/telephony/IntRangeManager$IntRange;->startId:I

    move/from16 v19, v0
    :try_end_22
    .catchall {:try_start_1 .. :try_end_22} :catchall_1b0

    move/from16 v0, p1

    move/from16 v1, v19

    if-ge v0, v1, :cond_2c

    .line 369
    const/16 v19, 0x0

    .line 496
    .end local v16           #range:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    :goto_2a
    monitor-exit p0

    return v19

    .line 370
    .restart local v16       #range:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    :cond_2c
    :try_start_2c
    move-object/from16 v0, v16

    iget v0, v0, Lcom/android/internal/telephony/IntRangeManager$IntRange;->endId:I

    move/from16 v19, v0

    move/from16 v0, p2

    move/from16 v1, v19

    if-gt v0, v1, :cond_206

    .line 373
    move-object/from16 v0, v16

    iget-object v4, v0, Lcom/android/internal/telephony/IntRangeManager$IntRange;->clients:Ljava/util/ArrayList;

    .line 376
    .local v4, clients:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Lcom/android/internal/telephony/IntRangeManager$ClientRange;>;"
    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v7

    .line 377
    .local v7, crLength:I
    const/16 v19, 0x1

    move/from16 v0, v19

    if-ne v7, v0, :cond_96

    .line 378
    const/16 v19, 0x0

    move/from16 v0, v19

    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/android/internal/telephony/IntRangeManager$ClientRange;

    .line 379
    .local v5, cr:Lcom/android/internal/telephony/IntRangeManager$ClientRange;
    iget v0, v5, Lcom/android/internal/telephony/IntRangeManager$ClientRange;->startId:I

    move/from16 v19, v0

    move/from16 v0, v19

    move/from16 v1, p1

    if-ne v0, v1, :cond_93

    iget v0, v5, Lcom/android/internal/telephony/IntRangeManager$ClientRange;->endId:I

    move/from16 v19, v0

    move/from16 v0, v19

    move/from16 v1, p2

    if-ne v0, v1, :cond_93

    iget-object v0, v5, Lcom/android/internal/telephony/IntRangeManager$ClientRange;->client:Ljava/lang/String;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    move-object/from16 v1, p3

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_93

    .line 381
    const/16 v19, 0x0

    move-object/from16 v0, p0

    move/from16 v1, p1

    move/from16 v2, p2

    move/from16 v3, v19

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/IntRangeManager;->tryAddSingleRange(IIZ)Z

    move-result v19

    if-eqz v19, :cond_90

    .line 382
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/telephony/IntRangeManager;->mRanges:Ljava/util/ArrayList;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    invoke-virtual {v0, v9}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 383
    const/16 v19, 0x1

    goto :goto_2a

    .line 385
    :cond_90
    const/16 v19, 0x0

    goto :goto_2a

    .line 388
    :cond_93
    const/16 v19, 0x0

    goto :goto_2a

    .line 396
    .end local v5           #cr:Lcom/android/internal/telephony/IntRangeManager$ClientRange;
    :cond_96
    const/high16 v10, -0x8000

    .line 397
    .local v10, largestEndId:I
    const/16 v18, 0x0

    .line 399
    .local v18, updateStarted:Z
    const/4 v6, 0x0

    .local v6, crIndex:I
    :goto_9b
    if-ge v6, v7, :cond_206

    .line 400
    invoke-virtual {v4, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/android/internal/telephony/IntRangeManager$ClientRange;

    .line 401
    .restart local v5       #cr:Lcom/android/internal/telephony/IntRangeManager$ClientRange;
    iget v0, v5, Lcom/android/internal/telephony/IntRangeManager$ClientRange;->startId:I

    move/from16 v19, v0

    move/from16 v0, v19

    move/from16 v1, p1

    if-ne v0, v1, :cond_1f8

    iget v0, v5, Lcom/android/internal/telephony/IntRangeManager$ClientRange;->endId:I

    move/from16 v19, v0

    move/from16 v0, v19

    move/from16 v1, p2

    if-ne v0, v1, :cond_1f8

    iget-object v0, v5, Lcom/android/internal/telephony/IntRangeManager$ClientRange;->client:Ljava/lang/String;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    move-object/from16 v1, p3

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_1f8

    .line 403
    add-int/lit8 v19, v7, -0x1

    move/from16 v0, v19

    if-ne v6, v0, :cond_103

    .line 404
    move-object/from16 v0, v16

    iget v0, v0, Lcom/android/internal/telephony/IntRangeManager$IntRange;->endId:I

    move/from16 v19, v0

    move/from16 v0, v19

    if-ne v0, v10, :cond_dc

    .line 406
    invoke-virtual {v4, v6}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 407
    const/16 v19, 0x1

    goto/16 :goto_2a

    .line 410
    :cond_dc
    add-int/lit8 v19, v10, 0x1

    move-object/from16 v0, v16

    iget v0, v0, Lcom/android/internal/telephony/IntRangeManager$IntRange;->endId:I

    move/from16 v20, v0

    const/16 v21, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v19

    move/from16 v2, v20

    move/from16 v3, v21

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/IntRangeManager;->tryAddSingleRange(IIZ)Z

    move-result v19

    if-eqz v19, :cond_ff

    .line 411
    invoke-virtual {v4, v6}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 412
    move-object/from16 v0, v16

    iput v10, v0, Lcom/android/internal/telephony/IntRangeManager$IntRange;->endId:I

    .line 413
    const/16 v19, 0x1

    goto/16 :goto_2a

    .line 415
    :cond_ff
    const/16 v19, 0x0

    goto/16 :goto_2a

    .line 423
    :cond_103
    new-instance v17, Lcom/android/internal/telephony/IntRangeManager$IntRange;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    move-object/from16 v2, v16

    invoke-direct {v0, v1, v2, v6}, Lcom/android/internal/telephony/IntRangeManager$IntRange;-><init>(Lcom/android/internal/telephony/IntRangeManager;Lcom/android/internal/telephony/IntRangeManager$IntRange;I)V

    .line 425
    .local v17, rangeCopy:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    if-nez v6, :cond_154

    .line 430
    const/16 v19, 0x1

    move/from16 v0, v19

    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v19

    check-cast v19, Lcom/android/internal/telephony/IntRangeManager$ClientRange;

    move-object/from16 v0, v19

    iget v15, v0, Lcom/android/internal/telephony/IntRangeManager$ClientRange;->startId:I

    .line 431
    .local v15, nextStartId:I
    move-object/from16 v0, v16

    iget v0, v0, Lcom/android/internal/telephony/IntRangeManager$IntRange;->startId:I

    move/from16 v19, v0

    move/from16 v0, v19

    if-eq v15, v0, :cond_146

    .line 432
    invoke-virtual/range {p0 .. p0}, Lcom/android/internal/telephony/IntRangeManager;->startUpdate()V

    .line 433
    const/16 v18, 0x1

    .line 434
    move-object/from16 v0, v16

    iget v0, v0, Lcom/android/internal/telephony/IntRangeManager$IntRange;->startId:I

    move/from16 v19, v0

    add-int/lit8 v20, v15, -0x1

    const/16 v21, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v19

    move/from16 v2, v20

    move/from16 v3, v21

    invoke-virtual {v0, v1, v2, v3}, Lcom/android/internal/telephony/IntRangeManager;->addRange(IIZ)V

    .line 435
    move-object/from16 v0, v17

    iput v15, v0, Lcom/android/internal/telephony/IntRangeManager$IntRange;->startId:I

    .line 438
    :cond_146
    const/16 v19, 0x1

    move/from16 v0, v19

    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v19

    check-cast v19, Lcom/android/internal/telephony/IntRangeManager$ClientRange;

    move-object/from16 v0, v19

    iget v10, v0, Lcom/android/internal/telephony/IntRangeManager$ClientRange;->endId:I

    .line 445
    .end local v15           #nextStartId:I
    :cond_154
    new-instance v12, Ljava/util/ArrayList;

    invoke-direct {v12}, Ljava/util/ArrayList;-><init>()V

    .line 447
    .local v12, newRanges:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Lcom/android/internal/telephony/IntRangeManager$IntRange;>;"
    move-object/from16 v8, v17

    .line 448
    .local v8, currentRange:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    add-int/lit8 v14, v6, 0x1

    .local v14, nextIndex:I
    :goto_15d
    if-ge v14, v7, :cond_1b3

    .line 449
    invoke-virtual {v4, v14}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Lcom/android/internal/telephony/IntRangeManager$ClientRange;

    .line 450
    .local v13, nextCr:Lcom/android/internal/telephony/IntRangeManager$ClientRange;
    iget v0, v13, Lcom/android/internal/telephony/IntRangeManager$ClientRange;->startId:I

    move/from16 v19, v0

    add-int/lit8 v20, v10, 0x1

    move/from16 v0, v19

    move/from16 v1, v20

    if-le v0, v1, :cond_1a6

    .line 451
    if-nez v18, :cond_178

    .line 452
    invoke-virtual/range {p0 .. p0}, Lcom/android/internal/telephony/IntRangeManager;->startUpdate()V

    .line 453
    const/16 v18, 0x1

    .line 455
    :cond_178
    add-int/lit8 v19, v10, 0x1

    iget v0, v13, Lcom/android/internal/telephony/IntRangeManager$ClientRange;->startId:I

    move/from16 v20, v0

    add-int/lit8 v20, v20, -0x1

    const/16 v21, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v19

    move/from16 v2, v20

    move/from16 v3, v21

    invoke-virtual {v0, v1, v2, v3}, Lcom/android/internal/telephony/IntRangeManager;->addRange(IIZ)V

    .line 456
    iput v10, v8, Lcom/android/internal/telephony/IntRangeManager$IntRange;->endId:I

    .line 457
    invoke-virtual {v12, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 458
    new-instance v8, Lcom/android/internal/telephony/IntRangeManager$IntRange;

    .end local v8           #currentRange:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    move-object/from16 v0, p0

    invoke-direct {v8, v0, v13}, Lcom/android/internal/telephony/IntRangeManager$IntRange;-><init>(Lcom/android/internal/telephony/IntRangeManager;Lcom/android/internal/telephony/IntRangeManager$ClientRange;)V

    .line 462
    .restart local v8       #currentRange:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    :goto_199
    iget v0, v13, Lcom/android/internal/telephony/IntRangeManager$ClientRange;->endId:I

    move/from16 v19, v0

    move/from16 v0, v19

    if-le v0, v10, :cond_1a3

    .line 463
    iget v10, v13, Lcom/android/internal/telephony/IntRangeManager$ClientRange;->endId:I

    .line 448
    :cond_1a3
    add-int/lit8 v14, v14, 0x1

    goto :goto_15d

    .line 460
    :cond_1a6
    iget-object v0, v8, Lcom/android/internal/telephony/IntRangeManager$IntRange;->clients:Ljava/util/ArrayList;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    invoke-virtual {v0, v13}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_1af
    .catchall {:try_start_2c .. :try_end_1af} :catchall_1b0

    goto :goto_199

    .line 364
    .end local v4           #clients:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Lcom/android/internal/telephony/IntRangeManager$ClientRange;>;"
    .end local v5           #cr:Lcom/android/internal/telephony/IntRangeManager$ClientRange;
    .end local v6           #crIndex:I
    .end local v7           #crLength:I
    .end local v8           #currentRange:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    .end local v9           #i:I
    .end local v10           #largestEndId:I
    .end local v11           #len:I
    .end local v12           #newRanges:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Lcom/android/internal/telephony/IntRangeManager$IntRange;>;"
    .end local v13           #nextCr:Lcom/android/internal/telephony/IntRangeManager$ClientRange;
    .end local v14           #nextIndex:I
    .end local v16           #range:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    .end local v17           #rangeCopy:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    .end local v18           #updateStarted:Z
    :catchall_1b0
    move-exception v19

    monitor-exit p0

    throw v19

    .line 468
    .restart local v4       #clients:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Lcom/android/internal/telephony/IntRangeManager$ClientRange;>;"
    .restart local v5       #cr:Lcom/android/internal/telephony/IntRangeManager$ClientRange;
    .restart local v6       #crIndex:I
    .restart local v7       #crLength:I
    .restart local v8       #currentRange:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    .restart local v9       #i:I
    .restart local v10       #largestEndId:I
    .restart local v11       #len:I
    .restart local v12       #newRanges:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Lcom/android/internal/telephony/IntRangeManager$IntRange;>;"
    .restart local v14       #nextIndex:I
    .restart local v16       #range:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    .restart local v17       #rangeCopy:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    .restart local v18       #updateStarted:Z
    :cond_1b3
    move/from16 v0, p2

    if-ge v10, v0, :cond_1cf

    .line 469
    if-nez v18, :cond_1be

    .line 470
    :try_start_1b9
    invoke-virtual/range {p0 .. p0}, Lcom/android/internal/telephony/IntRangeManager;->startUpdate()V

    .line 471
    const/16 v18, 0x1

    .line 473
    :cond_1be
    add-int/lit8 v19, v10, 0x1

    const/16 v20, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v19

    move/from16 v2, p2

    move/from16 v3, v20

    invoke-virtual {v0, v1, v2, v3}, Lcom/android/internal/telephony/IntRangeManager;->addRange(IIZ)V

    .line 474
    iput v10, v8, Lcom/android/internal/telephony/IntRangeManager$IntRange;->endId:I

    .line 476
    :cond_1cf
    invoke-virtual {v12, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 478
    if-eqz v18, :cond_1de

    invoke-virtual/range {p0 .. p0}, Lcom/android/internal/telephony/IntRangeManager;->finishUpdate()Z

    move-result v19

    if-nez v19, :cond_1de

    .line 479
    const/16 v19, 0x0

    goto/16 :goto_2a

    .line 483
    :cond_1de
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/telephony/IntRangeManager;->mRanges:Ljava/util/ArrayList;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    invoke-virtual {v0, v9}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 484
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/telephony/IntRangeManager;->mRanges:Ljava/util/ArrayList;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    invoke-virtual {v0, v9, v12}, Ljava/util/ArrayList;->addAll(ILjava/util/Collection;)Z

    .line 485
    const/16 v19, 0x1

    goto/16 :goto_2a

    .line 488
    .end local v8           #currentRange:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    .end local v12           #newRanges:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Lcom/android/internal/telephony/IntRangeManager$IntRange;>;"
    .end local v14           #nextIndex:I
    .end local v17           #rangeCopy:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    :cond_1f8
    iget v0, v5, Lcom/android/internal/telephony/IntRangeManager$ClientRange;->endId:I

    move/from16 v19, v0

    move/from16 v0, v19

    if-le v0, v10, :cond_202

    .line 489
    iget v10, v5, Lcom/android/internal/telephony/IntRangeManager$ClientRange;->endId:I
    :try_end_202
    .catchall {:try_start_1b9 .. :try_end_202} :catchall_1b0

    .line 399
    :cond_202
    add-int/lit8 v6, v6, 0x1

    goto/16 :goto_9b

    .line 366
    .end local v4           #clients:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Lcom/android/internal/telephony/IntRangeManager$ClientRange;>;"
    .end local v5           #cr:Lcom/android/internal/telephony/IntRangeManager$ClientRange;
    .end local v6           #crIndex:I
    .end local v7           #crLength:I
    .end local v10           #largestEndId:I
    .end local v18           #updateStarted:Z
    :cond_206
    add-int/lit8 v9, v9, 0x1

    goto/16 :goto_c

    .line 496
    .end local v16           #range:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    :cond_20a
    const/16 v19, 0x0

    goto/16 :goto_2a
.end method

.method public declared-synchronized enableRange(IILjava/lang/String;)Z
    .registers 23
    .parameter "startId"
    .parameter "endId"
    .parameter "client"

    .prologue
    .line 178
    monitor-enter p0

    :try_start_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/telephony/IntRangeManager;->mRanges:Ljava/util/ArrayList;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Ljava/util/ArrayList;->size()I

    move-result v10

    .line 181
    .local v10, len:I
    if-nez v10, :cond_3c

    .line 182
    const/16 v16, 0x1

    move-object/from16 v0, p0

    move/from16 v1, p1

    move/from16 v2, p2

    move/from16 v3, v16

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/IntRangeManager;->tryAddSingleRange(IIZ)Z

    move-result v16

    if-eqz v16, :cond_39

    .line 183
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/telephony/IntRangeManager;->mRanges:Ljava/util/ArrayList;

    move-object/from16 v16, v0

    new-instance v17, Lcom/android/internal/telephony/IntRangeManager$IntRange;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    move/from16 v2, p1

    move/from16 v3, p2

    move-object/from16 v4, p3

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/android/internal/telephony/IntRangeManager$IntRange;-><init>(Lcom/android/internal/telephony/IntRangeManager;IILjava/lang/String;)V

    invoke-virtual/range {v16 .. v17}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_35
    .catchall {:try_start_1 .. :try_end_35} :catchall_351

    .line 184
    const/16 v16, 0x1

    .line 349
    :goto_37
    monitor-exit p0

    return v16

    .line 186
    :cond_39
    const/16 v16, 0x0

    goto :goto_37

    .line 190
    :cond_3c
    const/4 v13, 0x0

    .local v13, startIndex:I
    :goto_3d
    if-ge v13, v10, :cond_321

    .line 191
    :try_start_3f
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/telephony/IntRangeManager;->mRanges:Ljava/util/ArrayList;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-virtual {v0, v13}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Lcom/android/internal/telephony/IntRangeManager$IntRange;

    .line 192
    .local v12, range:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    iget v0, v12, Lcom/android/internal/telephony/IntRangeManager$IntRange;->startId:I

    move/from16 v16, v0

    move/from16 v0, p1

    move/from16 v1, v16

    if-ge v0, v1, :cond_213

    .line 195
    add-int/lit8 v16, p2, 0x1

    iget v0, v12, Lcom/android/internal/telephony/IntRangeManager$IntRange;->startId:I

    move/from16 v17, v0

    move/from16 v0, v16

    move/from16 v1, v17

    if-ge v0, v1, :cond_95

    .line 197
    const/16 v16, 0x1

    move-object/from16 v0, p0

    move/from16 v1, p1

    move/from16 v2, p2

    move/from16 v3, v16

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/IntRangeManager;->tryAddSingleRange(IIZ)Z

    move-result v16

    if-eqz v16, :cond_92

    .line 198
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/telephony/IntRangeManager;->mRanges:Ljava/util/ArrayList;

    move-object/from16 v16, v0

    new-instance v17, Lcom/android/internal/telephony/IntRangeManager$IntRange;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    move/from16 v2, p1

    move/from16 v3, p2

    move-object/from16 v4, p3

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/android/internal/telephony/IntRangeManager$IntRange;-><init>(Lcom/android/internal/telephony/IntRangeManager;IILjava/lang/String;)V

    move-object/from16 v0, v16

    move-object/from16 v1, v17

    invoke-virtual {v0, v13, v1}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 199
    const/16 v16, 0x1

    goto :goto_37

    .line 201
    :cond_92
    const/16 v16, 0x0

    goto :goto_37

    .line 203
    :cond_95
    iget v0, v12, Lcom/android/internal/telephony/IntRangeManager$IntRange;->endId:I

    move/from16 v16, v0

    move/from16 v0, p2

    move/from16 v1, v16

    if-gt v0, v1, :cond_cf

    .line 205
    iget v0, v12, Lcom/android/internal/telephony/IntRangeManager$IntRange;->startId:I

    move/from16 v16, v0

    add-int/lit8 v16, v16, -0x1

    const/16 v17, 0x1

    move-object/from16 v0, p0

    move/from16 v1, p1

    move/from16 v2, v16

    move/from16 v3, v17

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/IntRangeManager;->tryAddSingleRange(IIZ)Z

    move-result v16

    if-eqz v16, :cond_cb

    .line 206
    move/from16 v0, p1

    iput v0, v12, Lcom/android/internal/telephony/IntRangeManager$IntRange;->startId:I

    .line 207
    iget-object v0, v12, Lcom/android/internal/telephony/IntRangeManager$IntRange;->clients:Ljava/util/ArrayList;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    new-instance v18, Lcom/android/internal/telephony/IntRangeManager$ClientRange;

    invoke-direct/range {v18 .. v22}, Lcom/android/internal/telephony/IntRangeManager$ClientRange;-><init>(Lcom/android/internal/telephony/IntRangeManager;IILjava/lang/String;)V

    invoke-virtual/range {v16 .. v18}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 208
    const/16 v16, 0x1

    goto/16 :goto_37

    .line 210
    :cond_cb
    const/16 v16, 0x0

    goto/16 :goto_37

    .line 214
    :cond_cf
    add-int/lit8 v5, v13, 0x1

    .local v5, endIndex:I
    :goto_d1
    if-ge v5, v10, :cond_1b9

    .line 215
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/telephony/IntRangeManager;->mRanges:Ljava/util/ArrayList;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-virtual {v0, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/android/internal/telephony/IntRangeManager$IntRange;

    .line 216
    .local v6, endRange:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    add-int/lit8 v16, p2, 0x1

    iget v0, v6, Lcom/android/internal/telephony/IntRangeManager$IntRange;->startId:I

    move/from16 v17, v0

    move/from16 v0, v16

    move/from16 v1, v17

    if-ge v0, v1, :cond_147

    .line 218
    const/16 v16, 0x1

    move-object/from16 v0, p0

    move/from16 v1, p1

    move/from16 v2, p2

    move/from16 v3, v16

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/IntRangeManager;->tryAddSingleRange(IIZ)Z

    move-result v16

    if-eqz v16, :cond_143

    .line 219
    move/from16 v0, p1

    iput v0, v12, Lcom/android/internal/telephony/IntRangeManager$IntRange;->startId:I

    .line 220
    move/from16 v0, p2

    iput v0, v12, Lcom/android/internal/telephony/IntRangeManager$IntRange;->endId:I

    .line 222
    iget-object v0, v12, Lcom/android/internal/telephony/IntRangeManager$IntRange;->clients:Ljava/util/ArrayList;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    new-instance v18, Lcom/android/internal/telephony/IntRangeManager$ClientRange;

    invoke-direct/range {v18 .. v22}, Lcom/android/internal/telephony/IntRangeManager$ClientRange;-><init>(Lcom/android/internal/telephony/IntRangeManager;IILjava/lang/String;)V

    invoke-virtual/range {v16 .. v18}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 228
    add-int/lit8 v8, v13, 0x1

    .line 229
    .local v8, joinIndex:I
    move v7, v8

    .local v7, i:I
    :goto_116
    if-ge v7, v5, :cond_13f

    .line 230
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/telephony/IntRangeManager;->mRanges:Ljava/util/ArrayList;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-virtual {v0, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/android/internal/telephony/IntRangeManager$IntRange;

    .line 231
    .local v9, joinRange:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    iget-object v0, v12, Lcom/android/internal/telephony/IntRangeManager$IntRange;->clients:Ljava/util/ArrayList;

    move-object/from16 v16, v0

    iget-object v0, v9, Lcom/android/internal/telephony/IntRangeManager$IntRange;->clients:Ljava/util/ArrayList;

    move-object/from16 v17, v0

    invoke-virtual/range {v16 .. v17}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 232
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/telephony/IntRangeManager;->mRanges:Ljava/util/ArrayList;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-virtual {v0, v9}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 229
    add-int/lit8 v7, v7, 0x1

    goto :goto_116

    .line 234
    .end local v9           #joinRange:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    :cond_13f
    const/16 v16, 0x1

    goto/16 :goto_37

    .line 236
    .end local v7           #i:I
    .end local v8           #joinIndex:I
    :cond_143
    const/16 v16, 0x0

    goto/16 :goto_37

    .line 238
    :cond_147
    iget v0, v6, Lcom/android/internal/telephony/IntRangeManager$IntRange;->endId:I

    move/from16 v16, v0

    move/from16 v0, p2

    move/from16 v1, v16

    if-gt v0, v1, :cond_1b5

    .line 241
    iget v0, v6, Lcom/android/internal/telephony/IntRangeManager$IntRange;->startId:I

    move/from16 v16, v0

    add-int/lit8 v16, v16, -0x1

    const/16 v17, 0x1

    move-object/from16 v0, p0

    move/from16 v1, p1

    move/from16 v2, v16

    move/from16 v3, v17

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/IntRangeManager;->tryAddSingleRange(IIZ)Z

    move-result v16

    if-eqz v16, :cond_1b1

    .line 242
    move/from16 v0, p1

    iput v0, v12, Lcom/android/internal/telephony/IntRangeManager$IntRange;->startId:I

    .line 243
    iget v0, v6, Lcom/android/internal/telephony/IntRangeManager$IntRange;->endId:I

    move/from16 v16, v0

    move/from16 v0, v16

    iput v0, v12, Lcom/android/internal/telephony/IntRangeManager$IntRange;->endId:I

    .line 245
    iget-object v0, v12, Lcom/android/internal/telephony/IntRangeManager$IntRange;->clients:Ljava/util/ArrayList;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    new-instance v18, Lcom/android/internal/telephony/IntRangeManager$ClientRange;

    invoke-direct/range {v18 .. v22}, Lcom/android/internal/telephony/IntRangeManager$ClientRange;-><init>(Lcom/android/internal/telephony/IntRangeManager;IILjava/lang/String;)V

    invoke-virtual/range {v16 .. v18}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 251
    add-int/lit8 v8, v13, 0x1

    .line 252
    .restart local v8       #joinIndex:I
    move v7, v8

    .restart local v7       #i:I
    :goto_184
    if-gt v7, v5, :cond_1ad

    .line 253
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/telephony/IntRangeManager;->mRanges:Ljava/util/ArrayList;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-virtual {v0, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/android/internal/telephony/IntRangeManager$IntRange;

    .line 254
    .restart local v9       #joinRange:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    iget-object v0, v12, Lcom/android/internal/telephony/IntRangeManager$IntRange;->clients:Ljava/util/ArrayList;

    move-object/from16 v16, v0

    iget-object v0, v9, Lcom/android/internal/telephony/IntRangeManager$IntRange;->clients:Ljava/util/ArrayList;

    move-object/from16 v17, v0

    invoke-virtual/range {v16 .. v17}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 255
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/telephony/IntRangeManager;->mRanges:Ljava/util/ArrayList;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-virtual {v0, v9}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 252
    add-int/lit8 v7, v7, 0x1

    goto :goto_184

    .line 257
    .end local v9           #joinRange:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    :cond_1ad
    const/16 v16, 0x1

    goto/16 :goto_37

    .line 259
    .end local v7           #i:I
    .end local v8           #joinIndex:I
    :cond_1b1
    const/16 v16, 0x0

    goto/16 :goto_37

    .line 214
    :cond_1b5
    add-int/lit8 v5, v5, 0x1

    goto/16 :goto_d1

    .line 265
    .end local v6           #endRange:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    :cond_1b9
    const/16 v16, 0x1

    move-object/from16 v0, p0

    move/from16 v1, p1

    move/from16 v2, p2

    move/from16 v3, v16

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/IntRangeManager;->tryAddSingleRange(IIZ)Z

    move-result v16

    if-eqz v16, :cond_20f

    .line 266
    move/from16 v0, p1

    iput v0, v12, Lcom/android/internal/telephony/IntRangeManager$IntRange;->startId:I

    .line 267
    move/from16 v0, p2

    iput v0, v12, Lcom/android/internal/telephony/IntRangeManager$IntRange;->endId:I

    .line 269
    iget-object v0, v12, Lcom/android/internal/telephony/IntRangeManager$IntRange;->clients:Ljava/util/ArrayList;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    new-instance v18, Lcom/android/internal/telephony/IntRangeManager$ClientRange;

    invoke-direct/range {v18 .. v22}, Lcom/android/internal/telephony/IntRangeManager$ClientRange;-><init>(Lcom/android/internal/telephony/IntRangeManager;IILjava/lang/String;)V

    invoke-virtual/range {v16 .. v18}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 275
    add-int/lit8 v8, v13, 0x1

    .line 276
    .restart local v8       #joinIndex:I
    move v7, v8

    .restart local v7       #i:I
    :goto_1e2
    if-ge v7, v10, :cond_20b

    .line 277
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/telephony/IntRangeManager;->mRanges:Ljava/util/ArrayList;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-virtual {v0, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/android/internal/telephony/IntRangeManager$IntRange;

    .line 278
    .restart local v9       #joinRange:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    iget-object v0, v12, Lcom/android/internal/telephony/IntRangeManager$IntRange;->clients:Ljava/util/ArrayList;

    move-object/from16 v16, v0

    iget-object v0, v9, Lcom/android/internal/telephony/IntRangeManager$IntRange;->clients:Ljava/util/ArrayList;

    move-object/from16 v17, v0

    invoke-virtual/range {v16 .. v17}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 279
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/telephony/IntRangeManager;->mRanges:Ljava/util/ArrayList;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-virtual {v0, v9}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 276
    add-int/lit8 v7, v7, 0x1

    goto :goto_1e2

    .line 281
    .end local v9           #joinRange:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    :cond_20b
    const/16 v16, 0x1

    goto/16 :goto_37

    .line 283
    .end local v7           #i:I
    .end local v8           #joinIndex:I
    :cond_20f
    const/16 v16, 0x0

    goto/16 :goto_37

    .line 286
    .end local v5           #endIndex:I
    :cond_213
    add-int/lit8 v16, p1, 0x1

    iget v0, v12, Lcom/android/internal/telephony/IntRangeManager$IntRange;->endId:I

    move/from16 v17, v0

    move/from16 v0, v16

    move/from16 v1, v17

    if-gt v0, v1, :cond_31d

    .line 287
    iget v0, v12, Lcom/android/internal/telephony/IntRangeManager$IntRange;->endId:I

    move/from16 v16, v0

    move/from16 v0, p2

    move/from16 v1, v16

    if-gt v0, v1, :cond_241

    .line 289
    new-instance v16, Lcom/android/internal/telephony/IntRangeManager$ClientRange;

    move-object/from16 v0, v16

    move-object/from16 v1, p0

    move/from16 v2, p1

    move/from16 v3, p2

    move-object/from16 v4, p3

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/android/internal/telephony/IntRangeManager$ClientRange;-><init>(Lcom/android/internal/telephony/IntRangeManager;IILjava/lang/String;)V

    move-object/from16 v0, v16

    invoke-virtual {v12, v0}, Lcom/android/internal/telephony/IntRangeManager$IntRange;->insert(Lcom/android/internal/telephony/IntRangeManager$ClientRange;)V

    .line 290
    const/16 v16, 0x1

    goto/16 :goto_37

    .line 293
    :cond_241
    move v5, v13

    .line 294
    .restart local v5       #endIndex:I
    add-int/lit8 v14, v13, 0x1

    .local v14, testIndex:I
    :goto_244
    if-ge v14, v10, :cond_260

    .line 295
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/telephony/IntRangeManager;->mRanges:Ljava/util/ArrayList;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-virtual {v0, v14}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Lcom/android/internal/telephony/IntRangeManager$IntRange;

    .line 296
    .local v15, testRange:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    add-int/lit8 v16, p2, 0x1

    iget v0, v15, Lcom/android/internal/telephony/IntRangeManager$IntRange;->startId:I

    move/from16 v17, v0

    move/from16 v0, v16

    move/from16 v1, v17

    if-ge v0, v1, :cond_294

    .line 303
    .end local v15           #testRange:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    :cond_260
    if-ne v5, v13, :cond_29c

    .line 306
    iget v0, v12, Lcom/android/internal/telephony/IntRangeManager$IntRange;->endId:I

    move/from16 v16, v0

    add-int/lit8 v16, v16, 0x1

    const/16 v17, 0x1

    move-object/from16 v0, p0

    move/from16 v1, v16

    move/from16 v2, p2

    move/from16 v3, v17

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/IntRangeManager;->tryAddSingleRange(IIZ)Z

    move-result v16

    if-eqz v16, :cond_298

    .line 307
    move/from16 v0, p2

    iput v0, v12, Lcom/android/internal/telephony/IntRangeManager$IntRange;->endId:I

    .line 308
    new-instance v16, Lcom/android/internal/telephony/IntRangeManager$ClientRange;

    move-object/from16 v0, v16

    move-object/from16 v1, p0

    move/from16 v2, p1

    move/from16 v3, p2

    move-object/from16 v4, p3

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/android/internal/telephony/IntRangeManager$ClientRange;-><init>(Lcom/android/internal/telephony/IntRangeManager;IILjava/lang/String;)V

    move-object/from16 v0, v16

    invoke-virtual {v12, v0}, Lcom/android/internal/telephony/IntRangeManager$IntRange;->insert(Lcom/android/internal/telephony/IntRangeManager$ClientRange;)V

    .line 309
    const/16 v16, 0x1

    goto/16 :goto_37

    .line 299
    .restart local v15       #testRange:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    :cond_294
    move v5, v14

    .line 294
    add-int/lit8 v14, v14, 0x1

    goto :goto_244

    .line 311
    .end local v15           #testRange:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    :cond_298
    const/16 v16, 0x0

    goto/16 :goto_37

    .line 315
    :cond_29c
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/telephony/IntRangeManager;->mRanges:Ljava/util/ArrayList;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-virtual {v0, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/android/internal/telephony/IntRangeManager$IntRange;

    .line 320
    .restart local v6       #endRange:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    iget v0, v6, Lcom/android/internal/telephony/IntRangeManager$IntRange;->endId:I

    move/from16 v16, v0

    move/from16 v0, p2

    move/from16 v1, v16

    if-gt v0, v1, :cond_312

    iget v0, v6, Lcom/android/internal/telephony/IntRangeManager$IntRange;->startId:I

    move/from16 v16, v0

    add-int/lit8 v11, v16, -0x1

    .line 321
    .local v11, newRangeEndId:I
    :goto_2ba
    iget v0, v12, Lcom/android/internal/telephony/IntRangeManager$IntRange;->endId:I

    move/from16 v16, v0

    add-int/lit8 v16, v16, 0x1

    const/16 v17, 0x1

    move-object/from16 v0, p0

    move/from16 v1, v16

    move/from16 v2, v17

    invoke-direct {v0, v1, v11, v2}, Lcom/android/internal/telephony/IntRangeManager;->tryAddSingleRange(IIZ)Z

    move-result v16

    if-eqz v16, :cond_319

    .line 322
    move/from16 v0, p2

    iput v0, v12, Lcom/android/internal/telephony/IntRangeManager$IntRange;->endId:I

    .line 324
    new-instance v16, Lcom/android/internal/telephony/IntRangeManager$ClientRange;

    move-object/from16 v0, v16

    move-object/from16 v1, p0

    move/from16 v2, p1

    move/from16 v3, p2

    move-object/from16 v4, p3

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/android/internal/telephony/IntRangeManager$ClientRange;-><init>(Lcom/android/internal/telephony/IntRangeManager;IILjava/lang/String;)V

    move-object/from16 v0, v16

    invoke-virtual {v12, v0}, Lcom/android/internal/telephony/IntRangeManager$IntRange;->insert(Lcom/android/internal/telephony/IntRangeManager$ClientRange;)V

    .line 330
    add-int/lit8 v8, v13, 0x1

    .line 331
    .restart local v8       #joinIndex:I
    move v7, v8

    .restart local v7       #i:I
    :goto_2e9
    if-ge v7, v5, :cond_315

    .line 332
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/telephony/IntRangeManager;->mRanges:Ljava/util/ArrayList;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-virtual {v0, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/android/internal/telephony/IntRangeManager$IntRange;

    .line 333
    .restart local v9       #joinRange:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    iget-object v0, v12, Lcom/android/internal/telephony/IntRangeManager$IntRange;->clients:Ljava/util/ArrayList;

    move-object/from16 v16, v0

    iget-object v0, v9, Lcom/android/internal/telephony/IntRangeManager$IntRange;->clients:Ljava/util/ArrayList;

    move-object/from16 v17, v0

    invoke-virtual/range {v16 .. v17}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 334
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/telephony/IntRangeManager;->mRanges:Ljava/util/ArrayList;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-virtual {v0, v9}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 331
    add-int/lit8 v7, v7, 0x1

    goto :goto_2e9

    .end local v7           #i:I
    .end local v8           #joinIndex:I
    .end local v9           #joinRange:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    .end local v11           #newRangeEndId:I
    :cond_312
    move/from16 v11, p2

    .line 320
    goto :goto_2ba

    .line 336
    .restart local v7       #i:I
    .restart local v8       #joinIndex:I
    .restart local v11       #newRangeEndId:I
    :cond_315
    const/16 v16, 0x1

    goto/16 :goto_37

    .line 338
    .end local v7           #i:I
    .end local v8           #joinIndex:I
    :cond_319
    const/16 v16, 0x0

    goto/16 :goto_37

    .line 190
    .end local v5           #endIndex:I
    .end local v6           #endRange:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    .end local v11           #newRangeEndId:I
    .end local v14           #testIndex:I
    :cond_31d
    add-int/lit8 v13, v13, 0x1

    goto/16 :goto_3d

    .line 345
    .end local v12           #range:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    :cond_321
    const/16 v16, 0x1

    move-object/from16 v0, p0

    move/from16 v1, p1

    move/from16 v2, p2

    move/from16 v3, v16

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/telephony/IntRangeManager;->tryAddSingleRange(IIZ)Z

    move-result v16

    if-eqz v16, :cond_34d

    .line 346
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/telephony/IntRangeManager;->mRanges:Ljava/util/ArrayList;

    move-object/from16 v16, v0

    new-instance v17, Lcom/android/internal/telephony/IntRangeManager$IntRange;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    move/from16 v2, p1

    move/from16 v3, p2

    move-object/from16 v4, p3

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/android/internal/telephony/IntRangeManager$IntRange;-><init>(Lcom/android/internal/telephony/IntRangeManager;IILjava/lang/String;)V

    invoke-virtual/range {v16 .. v17}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_349
    .catchall {:try_start_3f .. :try_end_349} :catchall_351

    .line 347
    const/16 v16, 0x1

    goto/16 :goto_37

    .line 349
    :cond_34d
    const/16 v16, 0x0

    goto/16 :goto_37

    .line 178
    .end local v10           #len:I
    .end local v13           #startIndex:I
    :catchall_351
    move-exception v16

    monitor-exit p0

    throw v16
.end method

.method protected abstract finishUpdate()Z
.end method

.method public isEmpty()Z
    .registers 2

    .prologue
    .line 550
    iget-object v0, p0, Lcom/android/internal/telephony/IntRangeManager;->mRanges:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    return v0
.end method

.method protected abstract startUpdate()V
.end method

.method public updateRanges()Z
    .registers 9

    .prologue
    const/4 v7, 0x1

    .line 506
    invoke-virtual {p0}, Lcom/android/internal/telephony/IntRangeManager;->startUpdate()V

    .line 507
    iget-object v5, p0, Lcom/android/internal/telephony/IntRangeManager;->mRanges:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 508
    .local v1, iterator:Ljava/util/Iterator;,"Ljava/util/Iterator<Lcom/android/internal/telephony/IntRangeManager$IntRange;>;"
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_3e

    .line 509
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/android/internal/telephony/IntRangeManager$IntRange;

    .line 510
    .local v3, range:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    iget v4, v3, Lcom/android/internal/telephony/IntRangeManager$IntRange;->startId:I

    .line 511
    .local v4, start:I
    iget v0, v3, Lcom/android/internal/telephony/IntRangeManager$IntRange;->endId:I

    .line 513
    .local v0, end:I
    :cond_1a
    :goto_1a
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_3b

    .line 514
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/android/internal/telephony/IntRangeManager$IntRange;

    .line 516
    .local v2, nextNode:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    iget v5, v2, Lcom/android/internal/telephony/IntRangeManager$IntRange;->startId:I

    add-int/lit8 v6, v0, 0x1

    if-gt v5, v6, :cond_33

    .line 517
    iget v5, v2, Lcom/android/internal/telephony/IntRangeManager$IntRange;->endId:I

    if-le v5, v0, :cond_1a

    .line 518
    iget v0, v2, Lcom/android/internal/telephony/IntRangeManager$IntRange;->endId:I

    goto :goto_1a

    .line 521
    :cond_33
    invoke-virtual {p0, v4, v0, v7}, Lcom/android/internal/telephony/IntRangeManager;->addRange(IIZ)V

    .line 522
    iget v4, v2, Lcom/android/internal/telephony/IntRangeManager$IntRange;->startId:I

    .line 523
    iget v0, v2, Lcom/android/internal/telephony/IntRangeManager$IntRange;->endId:I

    goto :goto_1a

    .line 527
    .end local v2           #nextNode:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    :cond_3b
    invoke-virtual {p0, v4, v0, v7}, Lcom/android/internal/telephony/IntRangeManager;->addRange(IIZ)V

    .line 529
    .end local v0           #end:I
    .end local v3           #range:Lcom/android/internal/telephony/IntRangeManager$IntRange;
    .end local v4           #start:I
    :cond_3e
    invoke-virtual {p0}, Lcom/android/internal/telephony/IntRangeManager;->finishUpdate()Z

    move-result v5

    return v5
.end method
