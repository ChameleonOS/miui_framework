.class Lcom/android/internal/telephony/RIL$RILSender;
.super Landroid/os/Handler;
.source "RIL.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/telephony/RIL;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "RILSender"
.end annotation


# instance fields
.field dataLength:[B

.field final synthetic this$0:Lcom/android/internal/telephony/RIL;


# direct methods
.method public constructor <init>(Lcom/android/internal/telephony/RIL;Landroid/os/Looper;)V
    .registers 4
    .parameter
    .parameter "looper"

    .prologue
    .line 277
    iput-object p1, p0, Lcom/android/internal/telephony/RIL$RILSender;->this$0:Lcom/android/internal/telephony/RIL;

    .line 278
    invoke-direct {p0, p2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 282
    const/4 v0, 0x4

    new-array v0, v0, [B

    iput-object v0, p0, Lcom/android/internal/telephony/RIL$RILSender;->dataLength:[B

    .line 279
    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .registers 17
    .parameter "msg"

    .prologue
    .line 294
    move-object/from16 v0, p1

    iget-object v10, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v10, Lcom/android/internal/telephony/RILRequest;

    move-object v8, v10

    check-cast v8, Lcom/android/internal/telephony/RILRequest;

    .line 295
    .local v8, rr:Lcom/android/internal/telephony/RILRequest;
    const/4 v7, 0x0

    .line 297
    .local v7, req:Lcom/android/internal/telephony/RILRequest;
    move-object/from16 v0, p1

    iget v10, v0, Landroid/os/Message;->what:I

    packed-switch v10, :pswitch_data_1fa

    .line 433
    :cond_11
    :goto_11
    return-void

    .line 304
    :pswitch_12
    const/4 v1, 0x0

    .line 308
    .local v1, alreadySubtracted:Z
    :try_start_13
    iget-object v10, p0, Lcom/android/internal/telephony/RIL$RILSender;->this$0:Lcom/android/internal/telephony/RIL;

    iget-object v9, v10, Lcom/android/internal/telephony/RIL;->mSocket:Landroid/net/LocalSocket;

    .line 310
    .local v9, s:Landroid/net/LocalSocket;
    if-nez v9, :cond_36

    .line 311
    const/4 v10, 0x1

    const/4 v11, 0x0

    invoke-virtual {v8, v10, v11}, Lcom/android/internal/telephony/RILRequest;->onError(ILjava/lang/Object;)V

    .line 312
    invoke-virtual {v8}, Lcom/android/internal/telephony/RILRequest;->release()V

    .line 313
    iget-object v10, p0, Lcom/android/internal/telephony/RIL$RILSender;->this$0:Lcom/android/internal/telephony/RIL;

    iget v10, v10, Lcom/android/internal/telephony/RIL;->mRequestMessagesPending:I

    if-lez v10, :cond_2f

    .line 314
    iget-object v10, p0, Lcom/android/internal/telephony/RIL$RILSender;->this$0:Lcom/android/internal/telephony/RIL;

    iget v11, v10, Lcom/android/internal/telephony/RIL;->mRequestMessagesPending:I

    add-int/lit8 v11, v11, -0x1

    iput v11, v10, Lcom/android/internal/telephony/RIL;->mRequestMessagesPending:I
    :try_end_2f
    .catchall {:try_start_13 .. :try_end_2f} :catchall_10e
    .catch Ljava/io/IOException; {:try_start_13 .. :try_end_2f} :catch_87
    .catch Ljava/lang/RuntimeException; {:try_start_13 .. :try_end_2f} :catch_bd

    .line 315
    :cond_2f
    const/4 v1, 0x1

    .line 371
    iget-object v10, p0, Lcom/android/internal/telephony/RIL$RILSender;->this$0:Lcom/android/internal/telephony/RIL;

    #calls: Lcom/android/internal/telephony/RIL;->releaseWakeLockIfDone()V
    invoke-static {v10}, Lcom/android/internal/telephony/RIL;->access$200(Lcom/android/internal/telephony/RIL;)V

    goto :goto_11

    .line 319
    :cond_36
    :try_start_36
    iget-object v10, p0, Lcom/android/internal/telephony/RIL$RILSender;->this$0:Lcom/android/internal/telephony/RIL;

    iget-object v11, v10, Lcom/android/internal/telephony/RIL;->mRequestsList:Ljava/util/ArrayList;

    monitor-enter v11
    :try_end_3b
    .catchall {:try_start_36 .. :try_end_3b} :catchall_10e
    .catch Ljava/io/IOException; {:try_start_36 .. :try_end_3b} :catch_87
    .catch Ljava/lang/RuntimeException; {:try_start_36 .. :try_end_3b} :catch_bd

    .line 320
    :try_start_3b
    iget-object v10, p0, Lcom/android/internal/telephony/RIL$RILSender;->this$0:Lcom/android/internal/telephony/RIL;

    iget-object v10, v10, Lcom/android/internal/telephony/RIL;->mRequestsList:Ljava/util/ArrayList;

    invoke-virtual {v10, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 321
    iget-object v10, p0, Lcom/android/internal/telephony/RIL$RILSender;->this$0:Lcom/android/internal/telephony/RIL;

    iget v12, v10, Lcom/android/internal/telephony/RIL;->mRequestMessagesWaiting:I

    add-int/lit8 v12, v12, 0x1

    iput v12, v10, Lcom/android/internal/telephony/RIL;->mRequestMessagesWaiting:I

    .line 322
    monitor-exit v11
    :try_end_4b
    .catchall {:try_start_3b .. :try_end_4b} :catchall_ba

    .line 324
    :try_start_4b
    iget-object v10, p0, Lcom/android/internal/telephony/RIL$RILSender;->this$0:Lcom/android/internal/telephony/RIL;

    iget v10, v10, Lcom/android/internal/telephony/RIL;->mRequestMessagesPending:I

    if-lez v10, :cond_59

    .line 325
    iget-object v10, p0, Lcom/android/internal/telephony/RIL$RILSender;->this$0:Lcom/android/internal/telephony/RIL;

    iget v11, v10, Lcom/android/internal/telephony/RIL;->mRequestMessagesPending:I

    add-int/lit8 v11, v11, -0x1

    iput v11, v10, Lcom/android/internal/telephony/RIL;->mRequestMessagesPending:I

    .line 326
    :cond_59
    const/4 v1, 0x1

    .line 330
    iget-object v10, v8, Lcom/android/internal/telephony/RILRequest;->mp:Landroid/os/Parcel;

    invoke-virtual {v10}, Landroid/os/Parcel;->marshall()[B

    move-result-object v3

    .line 331
    .local v3, data:[B
    iget-object v10, v8, Lcom/android/internal/telephony/RILRequest;->mp:Landroid/os/Parcel;

    invoke-virtual {v10}, Landroid/os/Parcel;->recycle()V

    .line 332
    const/4 v10, 0x0

    iput-object v10, v8, Lcom/android/internal/telephony/RILRequest;->mp:Landroid/os/Parcel;

    .line 334
    array-length v10, v3

    const/16 v11, 0x2000

    if-le v10, v11, :cond_dc

    .line 335
    new-instance v10, Ljava/lang/RuntimeException;

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "Parcel larger than max bytes allowed! "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    array-length v12, v3

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-direct {v10, v11}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v10
    :try_end_87
    .catchall {:try_start_4b .. :try_end_87} :catchall_10e
    .catch Ljava/io/IOException; {:try_start_4b .. :try_end_87} :catch_87
    .catch Ljava/lang/RuntimeException; {:try_start_4b .. :try_end_87} :catch_bd

    .line 349
    .end local v3           #data:[B
    .end local v9           #s:Landroid/net/LocalSocket;
    :catch_87
    move-exception v4

    .line 350
    .local v4, ex:Ljava/io/IOException;
    :try_start_88
    const-string v10, "RILJ"

    const-string v11, "IOException"

    invoke-static {v10, v11, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 351
    iget-object v10, p0, Lcom/android/internal/telephony/RIL$RILSender;->this$0:Lcom/android/internal/telephony/RIL;

    iget v11, v8, Lcom/android/internal/telephony/RILRequest;->mSerial:I

    #calls: Lcom/android/internal/telephony/RIL;->findAndRemoveRequestFromList(I)Lcom/android/internal/telephony/RILRequest;
    invoke-static {v10, v11}, Lcom/android/internal/telephony/RIL;->access$100(Lcom/android/internal/telephony/RIL;I)Lcom/android/internal/telephony/RILRequest;

    move-result-object v7

    .line 354
    if-nez v7, :cond_9b

    if-nez v1, :cond_a3

    .line 355
    :cond_9b
    const/4 v10, 0x1

    const/4 v11, 0x0

    invoke-virtual {v8, v10, v11}, Lcom/android/internal/telephony/RILRequest;->onError(ILjava/lang/Object;)V

    .line 356
    invoke-virtual {v8}, Lcom/android/internal/telephony/RILRequest;->release()V
    :try_end_a3
    .catchall {:try_start_88 .. :try_end_a3} :catchall_10e

    .line 371
    :cond_a3
    iget-object v10, p0, Lcom/android/internal/telephony/RIL$RILSender;->this$0:Lcom/android/internal/telephony/RIL;

    .end local v4           #ex:Ljava/io/IOException;
    :goto_a5
    #calls: Lcom/android/internal/telephony/RIL;->releaseWakeLockIfDone()V
    invoke-static {v10}, Lcom/android/internal/telephony/RIL;->access$200(Lcom/android/internal/telephony/RIL;)V

    .line 374
    if-nez v1, :cond_11

    iget-object v10, p0, Lcom/android/internal/telephony/RIL$RILSender;->this$0:Lcom/android/internal/telephony/RIL;

    iget v10, v10, Lcom/android/internal/telephony/RIL;->mRequestMessagesPending:I

    if-lez v10, :cond_11

    .line 375
    iget-object v10, p0, Lcom/android/internal/telephony/RIL$RILSender;->this$0:Lcom/android/internal/telephony/RIL;

    iget v11, v10, Lcom/android/internal/telephony/RIL;->mRequestMessagesPending:I

    add-int/lit8 v11, v11, -0x1

    iput v11, v10, Lcom/android/internal/telephony/RIL;->mRequestMessagesPending:I

    goto/16 :goto_11

    .line 322
    .restart local v9       #s:Landroid/net/LocalSocket;
    :catchall_ba
    move-exception v10

    :try_start_bb
    monitor-exit v11
    :try_end_bc
    .catchall {:try_start_bb .. :try_end_bc} :catchall_ba

    :try_start_bc
    throw v10
    :try_end_bd
    .catchall {:try_start_bc .. :try_end_bd} :catchall_10e
    .catch Ljava/io/IOException; {:try_start_bc .. :try_end_bd} :catch_87
    .catch Ljava/lang/RuntimeException; {:try_start_bc .. :try_end_bd} :catch_bd

    .line 358
    .end local v9           #s:Landroid/net/LocalSocket;
    :catch_bd
    move-exception v5

    .line 359
    .local v5, exc:Ljava/lang/RuntimeException;
    :try_start_be
    const-string v10, "RILJ"

    const-string v11, "Uncaught exception "

    invoke-static {v10, v11, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 360
    iget-object v10, p0, Lcom/android/internal/telephony/RIL$RILSender;->this$0:Lcom/android/internal/telephony/RIL;

    iget v11, v8, Lcom/android/internal/telephony/RILRequest;->mSerial:I

    #calls: Lcom/android/internal/telephony/RIL;->findAndRemoveRequestFromList(I)Lcom/android/internal/telephony/RILRequest;
    invoke-static {v10, v11}, Lcom/android/internal/telephony/RIL;->access$100(Lcom/android/internal/telephony/RIL;I)Lcom/android/internal/telephony/RILRequest;

    move-result-object v7

    .line 363
    if-nez v7, :cond_d1

    if-nez v1, :cond_d9

    .line 364
    :cond_d1
    const/4 v10, 0x2

    const/4 v11, 0x0

    invoke-virtual {v8, v10, v11}, Lcom/android/internal/telephony/RILRequest;->onError(ILjava/lang/Object;)V

    .line 365
    invoke-virtual {v8}, Lcom/android/internal/telephony/RILRequest;->release()V
    :try_end_d9
    .catchall {:try_start_be .. :try_end_d9} :catchall_10e

    .line 371
    :cond_d9
    iget-object v10, p0, Lcom/android/internal/telephony/RIL$RILSender;->this$0:Lcom/android/internal/telephony/RIL;

    goto :goto_a5

    .line 341
    .end local v5           #exc:Ljava/lang/RuntimeException;
    .restart local v3       #data:[B
    .restart local v9       #s:Landroid/net/LocalSocket;
    :cond_dc
    :try_start_dc
    iget-object v10, p0, Lcom/android/internal/telephony/RIL$RILSender;->dataLength:[B

    const/4 v11, 0x0

    iget-object v12, p0, Lcom/android/internal/telephony/RIL$RILSender;->dataLength:[B

    const/4 v13, 0x1

    const/4 v14, 0x0

    aput-byte v14, v12, v13

    aput-byte v14, v10, v11

    .line 342
    iget-object v10, p0, Lcom/android/internal/telephony/RIL$RILSender;->dataLength:[B

    const/4 v11, 0x2

    array-length v12, v3

    shr-int/lit8 v12, v12, 0x8

    and-int/lit16 v12, v12, 0xff

    int-to-byte v12, v12

    aput-byte v12, v10, v11

    .line 343
    iget-object v10, p0, Lcom/android/internal/telephony/RIL$RILSender;->dataLength:[B

    const/4 v11, 0x3

    array-length v12, v3

    and-int/lit16 v12, v12, 0xff

    int-to-byte v12, v12

    aput-byte v12, v10, v11

    .line 347
    invoke-virtual {v9}, Landroid/net/LocalSocket;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v10

    iget-object v11, p0, Lcom/android/internal/telephony/RIL$RILSender;->dataLength:[B

    invoke-virtual {v10, v11}, Ljava/io/OutputStream;->write([B)V

    .line 348
    invoke-virtual {v9}, Landroid/net/LocalSocket;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v10

    invoke-virtual {v10, v3}, Ljava/io/OutputStream;->write([B)V
    :try_end_10b
    .catchall {:try_start_dc .. :try_end_10b} :catchall_10e
    .catch Ljava/io/IOException; {:try_start_dc .. :try_end_10b} :catch_87
    .catch Ljava/lang/RuntimeException; {:try_start_dc .. :try_end_10b} :catch_bd

    .line 371
    iget-object v10, p0, Lcom/android/internal/telephony/RIL$RILSender;->this$0:Lcom/android/internal/telephony/RIL;

    goto :goto_a5

    .end local v3           #data:[B
    .end local v9           #s:Landroid/net/LocalSocket;
    :catchall_10e
    move-exception v10

    iget-object v11, p0, Lcom/android/internal/telephony/RIL$RILSender;->this$0:Lcom/android/internal/telephony/RIL;

    #calls: Lcom/android/internal/telephony/RIL;->releaseWakeLockIfDone()V
    invoke-static {v11}, Lcom/android/internal/telephony/RIL;->access$200(Lcom/android/internal/telephony/RIL;)V

    throw v10

    .line 383
    .end local v1           #alreadySubtracted:Z
    :pswitch_115
    iget-object v10, p0, Lcom/android/internal/telephony/RIL$RILSender;->this$0:Lcom/android/internal/telephony/RIL;

    iget-object v11, v10, Lcom/android/internal/telephony/RIL;->mWakeLock:Landroid/os/PowerManager$WakeLock;

    monitor-enter v11

    .line 384
    :try_start_11a
    iget-object v10, p0, Lcom/android/internal/telephony/RIL$RILSender;->this$0:Lcom/android/internal/telephony/RIL;

    iget-object v10, v10, Lcom/android/internal/telephony/RIL;->mWakeLock:Landroid/os/PowerManager$WakeLock;

    invoke-virtual {v10}, Landroid/os/PowerManager$WakeLock;->isHeld()Z

    move-result v10

    if-eqz v10, :cond_1f1

    .line 394
    iget-object v10, p0, Lcom/android/internal/telephony/RIL$RILSender;->this$0:Lcom/android/internal/telephony/RIL;

    iget v10, v10, Lcom/android/internal/telephony/RIL;->mRequestMessagesWaiting:I

    if-eqz v10, :cond_1bd

    .line 395
    const-string v10, "RILJ"

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const-string v13, "NOTE: mReqWaiting is NOT 0 but"

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    iget-object v13, p0, Lcom/android/internal/telephony/RIL$RILSender;->this$0:Lcom/android/internal/telephony/RIL;

    iget v13, v13, Lcom/android/internal/telephony/RIL;->mRequestMessagesWaiting:I

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string v13, " at TIMEOUT, reset!"

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string v13, " There still msg waitng for response"

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v10, v12}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 399
    iget-object v10, p0, Lcom/android/internal/telephony/RIL$RILSender;->this$0:Lcom/android/internal/telephony/RIL;

    const/4 v12, 0x0

    iput v12, v10, Lcom/android/internal/telephony/RIL;->mRequestMessagesWaiting:I

    .line 402
    iget-object v10, p0, Lcom/android/internal/telephony/RIL$RILSender;->this$0:Lcom/android/internal/telephony/RIL;

    iget-object v12, v10, Lcom/android/internal/telephony/RIL;->mRequestsList:Ljava/util/ArrayList;

    monitor-enter v12
    :try_end_15c
    .catchall {:try_start_11a .. :try_end_15c} :catchall_1f4

    .line 403
    :try_start_15c
    iget-object v10, p0, Lcom/android/internal/telephony/RIL$RILSender;->this$0:Lcom/android/internal/telephony/RIL;

    iget-object v10, v10, Lcom/android/internal/telephony/RIL;->mRequestsList:Ljava/util/ArrayList;

    invoke-virtual {v10}, Ljava/util/ArrayList;->size()I

    move-result v2

    .line 404
    .local v2, count:I
    const-string v10, "RILJ"

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const-string v14, "WAKE_LOCK_TIMEOUT  mRequestList="

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-static {v10, v13}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 407
    const/4 v6, 0x0

    .local v6, i:I
    :goto_17d
    if-ge v6, v2, :cond_1bc

    .line 408
    iget-object v10, p0, Lcom/android/internal/telephony/RIL$RILSender;->this$0:Lcom/android/internal/telephony/RIL;

    iget-object v10, v10, Lcom/android/internal/telephony/RIL;->mRequestsList:Ljava/util/ArrayList;

    invoke-virtual {v10, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v10

    move-object v0, v10

    check-cast v0, Lcom/android/internal/telephony/RILRequest;

    move-object v8, v0

    .line 409
    const-string v10, "RILJ"

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v13, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, ": ["

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    iget v14, v8, Lcom/android/internal/telephony/RILRequest;->mSerial:I

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, "] "

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    iget v14, v8, Lcom/android/internal/telephony/RILRequest;->mRequest:I

    invoke-static {v14}, Lcom/android/internal/telephony/RIL;->requestToString(I)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-static {v10, v13}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 407
    add-int/lit8 v6, v6, 0x1

    goto :goto_17d

    .line 412
    :cond_1bc
    monitor-exit v12
    :try_end_1bd
    .catchall {:try_start_15c .. :try_end_1bd} :catchall_1f7

    .line 422
    .end local v2           #count:I
    .end local v6           #i:I
    :cond_1bd
    :try_start_1bd
    iget-object v10, p0, Lcom/android/internal/telephony/RIL$RILSender;->this$0:Lcom/android/internal/telephony/RIL;

    iget v10, v10, Lcom/android/internal/telephony/RIL;->mRequestMessagesPending:I

    if-eqz v10, :cond_1ea

    .line 423
    const-string v10, "RILJ"

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const-string v13, "ERROR: mReqPending is NOT 0 but"

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    iget-object v13, p0, Lcom/android/internal/telephony/RIL$RILSender;->this$0:Lcom/android/internal/telephony/RIL;

    iget v13, v13, Lcom/android/internal/telephony/RIL;->mRequestMessagesPending:I

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string v13, " at TIMEOUT, reset!"

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v10, v12}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 425
    iget-object v10, p0, Lcom/android/internal/telephony/RIL$RILSender;->this$0:Lcom/android/internal/telephony/RIL;

    const/4 v12, 0x0

    iput v12, v10, Lcom/android/internal/telephony/RIL;->mRequestMessagesPending:I

    .line 428
    :cond_1ea
    iget-object v10, p0, Lcom/android/internal/telephony/RIL$RILSender;->this$0:Lcom/android/internal/telephony/RIL;

    iget-object v10, v10, Lcom/android/internal/telephony/RIL;->mWakeLock:Landroid/os/PowerManager$WakeLock;

    invoke-virtual {v10}, Landroid/os/PowerManager$WakeLock;->release()V

    .line 430
    :cond_1f1
    monitor-exit v11

    goto/16 :goto_11

    :catchall_1f4
    move-exception v10

    monitor-exit v11
    :try_end_1f6
    .catchall {:try_start_1bd .. :try_end_1f6} :catchall_1f4

    throw v10

    .line 412
    :catchall_1f7
    move-exception v10

    :try_start_1f8
    monitor-exit v12
    :try_end_1f9
    .catchall {:try_start_1f8 .. :try_end_1f9} :catchall_1f7

    :try_start_1f9
    throw v10
    :try_end_1fa
    .catchall {:try_start_1f9 .. :try_end_1fa} :catchall_1f4

    .line 297
    :pswitch_data_1fa
    .packed-switch 0x1
        :pswitch_12
        :pswitch_115
    .end packed-switch
.end method

.method public run()V
    .registers 1

    .prologue
    .line 288
    return-void
.end method
