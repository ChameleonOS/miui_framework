.class abstract Landroid/accounts/AccountManager$AmsTask;
.super Ljava/util/concurrent/FutureTask;
.source "AccountManager.java"

# interfaces
.implements Landroid/accounts/AccountManagerFuture;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/accounts/AccountManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x402
    name = "AmsTask"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/accounts/AccountManager$AmsTask$Response;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/util/concurrent/FutureTask",
        "<",
        "Landroid/os/Bundle;",
        ">;",
        "Landroid/accounts/AccountManagerFuture",
        "<",
        "Landroid/os/Bundle;",
        ">;"
    }
.end annotation


# instance fields
.field final mActivity:Landroid/app/Activity;

.field final mCallback:Landroid/accounts/AccountManagerCallback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/accounts/AccountManagerCallback",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation
.end field

.field final mHandler:Landroid/os/Handler;

.field final mResponse:Landroid/accounts/IAccountManagerResponse;

.field final synthetic this$0:Landroid/accounts/AccountManager;


# direct methods
.method public constructor <init>(Landroid/accounts/AccountManager;Landroid/app/Activity;Landroid/os/Handler;Landroid/accounts/AccountManagerCallback;)V
    .registers 7
    .parameter
    .parameter "activity"
    .parameter "handler"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Landroid/os/Handler;",
            "Landroid/accounts/AccountManagerCallback",
            "<",
            "Landroid/os/Bundle;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1343
    .local p4, callback:Landroid/accounts/AccountManagerCallback;,"Landroid/accounts/AccountManagerCallback<Landroid/os/Bundle;>;"
    iput-object p1, p0, Landroid/accounts/AccountManager$AmsTask;->this$0:Landroid/accounts/AccountManager;

    .line 1344
    new-instance v0, Landroid/accounts/AccountManager$AmsTask$1;

    invoke-direct {v0, p1}, Landroid/accounts/AccountManager$AmsTask$1;-><init>(Landroid/accounts/AccountManager;)V

    invoke-direct {p0, v0}, Ljava/util/concurrent/FutureTask;-><init>(Ljava/util/concurrent/Callable;)V

    .line 1350
    iput-object p3, p0, Landroid/accounts/AccountManager$AmsTask;->mHandler:Landroid/os/Handler;

    .line 1351
    iput-object p4, p0, Landroid/accounts/AccountManager$AmsTask;->mCallback:Landroid/accounts/AccountManagerCallback;

    .line 1352
    iput-object p2, p0, Landroid/accounts/AccountManager$AmsTask;->mActivity:Landroid/app/Activity;

    .line 1353
    new-instance v0, Landroid/accounts/AccountManager$AmsTask$Response;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Landroid/accounts/AccountManager$AmsTask$Response;-><init>(Landroid/accounts/AccountManager$AmsTask;Landroid/accounts/AccountManager$1;)V

    iput-object v0, p0, Landroid/accounts/AccountManager$AmsTask;->mResponse:Landroid/accounts/IAccountManagerResponse;

    .line 1354
    return-void
.end method

.method static synthetic access$500(Landroid/accounts/AccountManager$AmsTask;Ljava/lang/Throwable;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 1338
    invoke-virtual {p0, p1}, Landroid/accounts/AccountManager$AmsTask;->setException(Ljava/lang/Throwable;)V

    return-void
.end method

.method private internalGetResult(Ljava/lang/Long;Ljava/util/concurrent/TimeUnit;)Landroid/os/Bundle;
    .registers 8
    .parameter "timeout"
    .parameter "unit"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/accounts/OperationCanceledException;,
            Ljava/io/IOException;,
            Landroid/accounts/AuthenticatorException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x1

    .line 1379
    invoke-virtual {p0}, Landroid/accounts/AccountManager$AmsTask;->isDone()Z

    move-result v2

    if-nez v2, :cond_c

    .line 1380
    iget-object v2, p0, Landroid/accounts/AccountManager$AmsTask;->this$0:Landroid/accounts/AccountManager;

    #calls: Landroid/accounts/AccountManager;->ensureNotOnMainThread()V
    invoke-static {v2}, Landroid/accounts/AccountManager;->access$200(Landroid/accounts/AccountManager;)V

    .line 1383
    :cond_c
    if-nez p1, :cond_18

    .line 1384
    :try_start_e
    invoke-virtual {p0}, Landroid/accounts/AccountManager$AmsTask;->get()Ljava/lang/Object;
    :try_end_11
    .catchall {:try_start_e .. :try_end_11} :catchall_2a
    .catch Ljava/util/concurrent/CancellationException; {:try_start_e .. :try_end_11} :catch_23
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_e .. :try_end_11} :catch_72
    .catch Ljava/lang/InterruptedException; {:try_start_e .. :try_end_11} :catch_60
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_e .. :try_end_11} :catch_2f

    move-result-object v2

    :try_start_12
    check-cast v2, Landroid/os/Bundle;
    :try_end_14
    .catchall {:try_start_12 .. :try_end_14} :catchall_2a
    .catch Ljava/util/concurrent/CancellationException; {:try_start_12 .. :try_end_14} :catch_23
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_12 .. :try_end_14} :catch_72
    .catch Ljava/lang/InterruptedException; {:try_start_12 .. :try_end_14} :catch_6a
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_12 .. :try_end_14} :catch_2f

    .line 1410
    :goto_14
    invoke-virtual {p0, v4}, Landroid/accounts/AccountManager$AmsTask;->cancel(Z)Z

    .line 1386
    return-object v2

    :cond_18
    :try_start_18
    invoke-virtual {p1}, Ljava/lang/Long;->longValue()J
    :try_end_1b
    .catchall {:try_start_18 .. :try_end_1b} :catchall_2a
    .catch Ljava/util/concurrent/CancellationException; {:try_start_18 .. :try_end_1b} :catch_23
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_18 .. :try_end_1b} :catch_72
    .catch Ljava/lang/InterruptedException; {:try_start_18 .. :try_end_1b} :catch_6c
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_18 .. :try_end_1b} :catch_2f

    move-result-wide v2

    :try_start_1c
    invoke-virtual {p0, v2, v3, p2}, Landroid/accounts/AccountManager$AmsTask;->get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    :try_end_1f
    .catchall {:try_start_1c .. :try_end_1f} :catchall_2a
    .catch Ljava/util/concurrent/CancellationException; {:try_start_1c .. :try_end_1f} :catch_23
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_1c .. :try_end_1f} :catch_72
    .catch Ljava/lang/InterruptedException; {:try_start_1c .. :try_end_1f} :catch_6e
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_1c .. :try_end_1f} :catch_2f

    move-result-object v2

    :try_start_20
    check-cast v2, Landroid/os/Bundle;
    :try_end_22
    .catchall {:try_start_20 .. :try_end_22} :catchall_2a
    .catch Ljava/util/concurrent/CancellationException; {:try_start_20 .. :try_end_22} :catch_23
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_20 .. :try_end_22} :catch_72
    .catch Ljava/lang/InterruptedException; {:try_start_20 .. :try_end_22} :catch_70
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_20 .. :try_end_22} :catch_2f

    goto :goto_14

    .line 1388
    :catch_23
    move-exception v1

    .line 1389
    .local v1, e:Ljava/util/concurrent/CancellationException;
    :try_start_24
    new-instance v2, Landroid/accounts/OperationCanceledException;

    invoke-direct {v2}, Landroid/accounts/OperationCanceledException;-><init>()V

    throw v2
    :try_end_2a
    .catchall {:try_start_24 .. :try_end_2a} :catchall_2a

    .line 1410
    .end local v1           #e:Ljava/util/concurrent/CancellationException;
    :catchall_2a
    move-exception v2

    invoke-virtual {p0, v4}, Landroid/accounts/AccountManager$AmsTask;->cancel(Z)Z

    throw v2

    .line 1394
    :catch_2f
    move-exception v1

    .line 1395
    .local v1, e:Ljava/util/concurrent/ExecutionException;
    :try_start_30
    invoke-virtual {v1}, Ljava/util/concurrent/ExecutionException;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    .line 1396
    .local v0, cause:Ljava/lang/Throwable;
    instance-of v2, v0, Ljava/io/IOException;

    if-eqz v2, :cond_3b

    .line 1397
    check-cast v0, Ljava/io/IOException;

    .end local v0           #cause:Ljava/lang/Throwable;
    throw v0

    .line 1398
    .restart local v0       #cause:Ljava/lang/Throwable;
    :cond_3b
    instance-of v2, v0, Ljava/lang/UnsupportedOperationException;

    if-eqz v2, :cond_45

    .line 1399
    new-instance v2, Landroid/accounts/AuthenticatorException;

    invoke-direct {v2, v0}, Landroid/accounts/AuthenticatorException;-><init>(Ljava/lang/Throwable;)V

    throw v2

    .line 1400
    :cond_45
    instance-of v2, v0, Landroid/accounts/AuthenticatorException;

    if-eqz v2, :cond_4c

    .line 1401
    check-cast v0, Landroid/accounts/AuthenticatorException;

    .end local v0           #cause:Ljava/lang/Throwable;
    throw v0

    .line 1402
    .restart local v0       #cause:Ljava/lang/Throwable;
    :cond_4c
    instance-of v2, v0, Ljava/lang/RuntimeException;

    if-eqz v2, :cond_53

    .line 1403
    check-cast v0, Ljava/lang/RuntimeException;

    .end local v0           #cause:Ljava/lang/Throwable;
    throw v0

    .line 1404
    .restart local v0       #cause:Ljava/lang/Throwable;
    :cond_53
    instance-of v2, v0, Ljava/lang/Error;

    if-eqz v2, :cond_5a

    .line 1405
    check-cast v0, Ljava/lang/Error;

    .end local v0           #cause:Ljava/lang/Throwable;
    throw v0

    .line 1407
    .restart local v0       #cause:Ljava/lang/Throwable;
    :cond_5a
    new-instance v2, Ljava/lang/IllegalStateException;

    invoke-direct {v2, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/Throwable;)V

    throw v2
    :try_end_60
    .catchall {:try_start_30 .. :try_end_60} :catchall_2a

    .line 1392
    .end local v0           #cause:Ljava/lang/Throwable;
    .end local v1           #e:Ljava/util/concurrent/ExecutionException;
    :catch_60
    move-exception v2

    .line 1410
    :goto_61
    invoke-virtual {p0, v4}, Landroid/accounts/AccountManager$AmsTask;->cancel(Z)Z

    .line 1412
    new-instance v2, Landroid/accounts/OperationCanceledException;

    invoke-direct {v2}, Landroid/accounts/OperationCanceledException;-><init>()V

    throw v2

    .line 1392
    :catch_6a
    move-exception v2

    goto :goto_61

    :catch_6c
    move-exception v2

    goto :goto_61

    :catch_6e
    move-exception v2

    goto :goto_61

    :catch_70
    move-exception v2

    goto :goto_61

    .line 1390
    :catch_72
    move-exception v2

    goto :goto_61
.end method


# virtual methods
.method public abstract doWork()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

.method protected done()V
    .registers 4

    .prologue
    .line 1426
    iget-object v0, p0, Landroid/accounts/AccountManager$AmsTask;->mCallback:Landroid/accounts/AccountManagerCallback;

    if-eqz v0, :cond_d

    .line 1427
    iget-object v0, p0, Landroid/accounts/AccountManager$AmsTask;->this$0:Landroid/accounts/AccountManager;

    iget-object v1, p0, Landroid/accounts/AccountManager$AmsTask;->mHandler:Landroid/os/Handler;

    iget-object v2, p0, Landroid/accounts/AccountManager$AmsTask;->mCallback:Landroid/accounts/AccountManagerCallback;

    #calls: Landroid/accounts/AccountManager;->postToHandler(Landroid/os/Handler;Landroid/accounts/AccountManagerCallback;Landroid/accounts/AccountManagerFuture;)V
    invoke-static {v0, v1, v2, p0}, Landroid/accounts/AccountManager;->access$300(Landroid/accounts/AccountManager;Landroid/os/Handler;Landroid/accounts/AccountManagerCallback;Landroid/accounts/AccountManagerFuture;)V

    .line 1429
    :cond_d
    return-void
.end method

.method public getResult()Landroid/os/Bundle;
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/accounts/OperationCanceledException;,
            Ljava/io/IOException;,
            Landroid/accounts/AuthenticatorException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 1417
    invoke-direct {p0, v0, v0}, Landroid/accounts/AccountManager$AmsTask;->internalGetResult(Ljava/lang/Long;Ljava/util/concurrent/TimeUnit;)Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method

.method public getResult(JLjava/util/concurrent/TimeUnit;)Landroid/os/Bundle;
    .registers 5
    .parameter "timeout"
    .parameter "unit"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/accounts/OperationCanceledException;,
            Ljava/io/IOException;,
            Landroid/accounts/AuthenticatorException;
        }
    .end annotation

    .prologue
    .line 1422
    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-direct {p0, v0, p3}, Landroid/accounts/AccountManager$AmsTask;->internalGetResult(Ljava/lang/Long;Ljava/util/concurrent/TimeUnit;)Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getResult()Ljava/lang/Object;
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/accounts/OperationCanceledException;,
            Ljava/io/IOException;,
            Landroid/accounts/AuthenticatorException;
        }
    .end annotation

    .prologue
    .line 1338
    invoke-virtual {p0}, Landroid/accounts/AccountManager$AmsTask;->getResult()Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getResult(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    .registers 5
    .parameter "x0"
    .parameter "x1"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/accounts/OperationCanceledException;,
            Ljava/io/IOException;,
            Landroid/accounts/AuthenticatorException;
        }
    .end annotation

    .prologue
    .line 1338
    invoke-virtual {p0, p1, p2, p3}, Landroid/accounts/AccountManager$AmsTask;->getResult(JLjava/util/concurrent/TimeUnit;)Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method

.method protected set(Landroid/os/Bundle;)V
    .registers 5
    .parameter "bundle"

    .prologue
    .line 1369
    if-nez p1, :cond_f

    .line 1370
    const-string v0, "AccountManager"

    const-string/jumbo v1, "the bundle must not be null"

    new-instance v2, Ljava/lang/Exception;

    invoke-direct {v2}, Ljava/lang/Exception;-><init>()V

    invoke-static {v0, v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 1372
    :cond_f
    invoke-super {p0, p1}, Ljava/util/concurrent/FutureTask;->set(Ljava/lang/Object;)V

    .line 1373
    return-void
.end method

.method protected bridge synthetic set(Ljava/lang/Object;)V
    .registers 2
    .parameter "x0"

    .prologue
    .line 1338
    check-cast p1, Landroid/os/Bundle;

    .end local p1
    invoke-virtual {p0, p1}, Landroid/accounts/AccountManager$AmsTask;->set(Landroid/os/Bundle;)V

    return-void
.end method

.method public final start()Landroid/accounts/AccountManagerFuture;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroid/accounts/AccountManagerFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1358
    :try_start_0
    invoke-virtual {p0}, Landroid/accounts/AccountManager$AmsTask;->doWork()V
    :try_end_3
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_3} :catch_4

    .line 1362
    :goto_3
    return-object p0

    .line 1359
    :catch_4
    move-exception v0

    .line 1360
    .local v0, e:Landroid/os/RemoteException;
    invoke-virtual {p0, v0}, Landroid/accounts/AccountManager$AmsTask;->setException(Ljava/lang/Throwable;)V

    goto :goto_3
.end method
