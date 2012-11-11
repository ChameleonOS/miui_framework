.class abstract Landroid/accounts/AccountManager$Future2Task;
.super Landroid/accounts/AccountManager$BaseFutureTask;
.source "AccountManager.java"

# interfaces
.implements Landroid/accounts/AccountManagerFuture;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/accounts/AccountManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x402
    name = "Future2Task"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Landroid/accounts/AccountManager$BaseFutureTask",
        "<TT;>;",
        "Landroid/accounts/AccountManagerFuture",
        "<TT;>;"
    }
.end annotation


# instance fields
.field final mCallback:Landroid/accounts/AccountManagerCallback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/accounts/AccountManagerCallback",
            "<TT;>;"
        }
    .end annotation
.end field

.field final synthetic this$0:Landroid/accounts/AccountManager;


# direct methods
.method public constructor <init>(Landroid/accounts/AccountManager;Landroid/os/Handler;Landroid/accounts/AccountManagerCallback;)V
    .registers 4
    .parameter
    .parameter "handler"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/Handler;",
            "Landroid/accounts/AccountManagerCallback",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .local p0, this:Landroid/accounts/AccountManager$Future2Task;,"Landroid/accounts/AccountManager$Future2Task<TT;>;"
    .local p3, callback:Landroid/accounts/AccountManagerCallback;,"Landroid/accounts/AccountManagerCallback<TT;>;"
    iput-object p1, p0, Landroid/accounts/AccountManager$Future2Task;->this$0:Landroid/accounts/AccountManager;

    invoke-direct {p0, p1, p2}, Landroid/accounts/AccountManager$BaseFutureTask;-><init>(Landroid/accounts/AccountManager;Landroid/os/Handler;)V

    iput-object p3, p0, Landroid/accounts/AccountManager$Future2Task;->mCallback:Landroid/accounts/AccountManagerCallback;

    return-void
.end method

.method private internalGetResult(Ljava/lang/Long;Ljava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    .registers 8
    .parameter "timeout"
    .parameter "unit"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Long;",
            "Ljava/util/concurrent/TimeUnit;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/accounts/OperationCanceledException;,
            Ljava/io/IOException;,
            Landroid/accounts/AuthenticatorException;
        }
    .end annotation

    .prologue
    .local p0, this:Landroid/accounts/AccountManager$Future2Task;,"Landroid/accounts/AccountManager$Future2Task<TT;>;"
    const/4 v4, 0x1

    invoke-virtual {p0}, Landroid/accounts/AccountManager$Future2Task;->isDone()Z

    move-result v2

    if-nez v2, :cond_c

    iget-object v2, p0, Landroid/accounts/AccountManager$Future2Task;->this$0:Landroid/accounts/AccountManager;

    #calls: Landroid/accounts/AccountManager;->ensureNotOnMainThread()V
    invoke-static {v2}, Landroid/accounts/AccountManager;->access$200(Landroid/accounts/AccountManager;)V

    :cond_c
    if-nez p1, :cond_16

    :try_start_e
    invoke-virtual {p0}, Landroid/accounts/AccountManager$Future2Task;->get()Ljava/lang/Object;
    :try_end_11
    .catchall {:try_start_e .. :try_end_11} :catchall_2b
    .catch Ljava/lang/InterruptedException; {:try_start_e .. :try_end_11} :catch_69
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_e .. :try_end_11} :catch_63
    .catch Ljava/util/concurrent/CancellationException; {:try_start_e .. :try_end_11} :catch_55
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_e .. :try_end_11} :catch_1f

    move-result-object v2

    :goto_12
    invoke-virtual {p0, v4}, Landroid/accounts/AccountManager$Future2Task;->cancel(Z)Z

    return-object v2

    :cond_16
    :try_start_16
    invoke-virtual {p1}, Ljava/lang/Long;->longValue()J
    :try_end_19
    .catchall {:try_start_16 .. :try_end_19} :catchall_2b
    .catch Ljava/lang/InterruptedException; {:try_start_16 .. :try_end_19} :catch_69
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_16 .. :try_end_19} :catch_65
    .catch Ljava/util/concurrent/CancellationException; {:try_start_16 .. :try_end_19} :catch_5f
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_16 .. :try_end_19} :catch_1f

    move-result-wide v2

    :try_start_1a
    invoke-virtual {p0, v2, v3, p2}, Landroid/accounts/AccountManager$Future2Task;->get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    :try_end_1d
    .catchall {:try_start_1a .. :try_end_1d} :catchall_2b
    .catch Ljava/lang/InterruptedException; {:try_start_1a .. :try_end_1d} :catch_69
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_1a .. :try_end_1d} :catch_67
    .catch Ljava/util/concurrent/CancellationException; {:try_start_1a .. :try_end_1d} :catch_61
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_1a .. :try_end_1d} :catch_1f

    move-result-object v2

    goto :goto_12

    :catch_1f
    move-exception v1

    .local v1, e:Ljava/util/concurrent/ExecutionException;
    :try_start_20
    invoke-virtual {v1}, Ljava/util/concurrent/ExecutionException;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    .local v0, cause:Ljava/lang/Throwable;
    instance-of v2, v0, Ljava/io/IOException;

    if-eqz v2, :cond_30

    check-cast v0, Ljava/io/IOException;

    .end local v0           #cause:Ljava/lang/Throwable;
    throw v0
    :try_end_2b
    .catchall {:try_start_20 .. :try_end_2b} :catchall_2b

    .end local v1           #e:Ljava/util/concurrent/ExecutionException;
    :catchall_2b
    move-exception v2

    invoke-virtual {p0, v4}, Landroid/accounts/AccountManager$Future2Task;->cancel(Z)Z

    throw v2

    .restart local v0       #cause:Ljava/lang/Throwable;
    .restart local v1       #e:Ljava/util/concurrent/ExecutionException;
    :cond_30
    :try_start_30
    instance-of v2, v0, Ljava/lang/UnsupportedOperationException;

    if-eqz v2, :cond_3a

    new-instance v2, Landroid/accounts/AuthenticatorException;

    invoke-direct {v2, v0}, Landroid/accounts/AuthenticatorException;-><init>(Ljava/lang/Throwable;)V

    throw v2

    :cond_3a
    instance-of v2, v0, Landroid/accounts/AuthenticatorException;

    if-eqz v2, :cond_41

    check-cast v0, Landroid/accounts/AuthenticatorException;

    .end local v0           #cause:Ljava/lang/Throwable;
    throw v0

    .restart local v0       #cause:Ljava/lang/Throwable;
    :cond_41
    instance-of v2, v0, Ljava/lang/RuntimeException;

    if-eqz v2, :cond_48

    check-cast v0, Ljava/lang/RuntimeException;

    .end local v0           #cause:Ljava/lang/Throwable;
    throw v0

    .restart local v0       #cause:Ljava/lang/Throwable;
    :cond_48
    instance-of v2, v0, Ljava/lang/Error;

    if-eqz v2, :cond_4f

    check-cast v0, Ljava/lang/Error;

    .end local v0           #cause:Ljava/lang/Throwable;
    throw v0

    .restart local v0       #cause:Ljava/lang/Throwable;
    :cond_4f
    new-instance v2, Ljava/lang/IllegalStateException;

    invoke-direct {v2, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/Throwable;)V

    throw v2
    :try_end_55
    .catchall {:try_start_30 .. :try_end_55} :catchall_2b

    .end local v0           #cause:Ljava/lang/Throwable;
    .end local v1           #e:Ljava/util/concurrent/ExecutionException;
    :catch_55
    move-exception v2

    :goto_56
    invoke-virtual {p0, v4}, Landroid/accounts/AccountManager$Future2Task;->cancel(Z)Z

    new-instance v2, Landroid/accounts/OperationCanceledException;

    invoke-direct {v2}, Landroid/accounts/OperationCanceledException;-><init>()V

    throw v2

    :catch_5f
    move-exception v2

    goto :goto_56

    :catch_61
    move-exception v2

    goto :goto_56

    :catch_63
    move-exception v2

    goto :goto_56

    :catch_65
    move-exception v2

    goto :goto_56

    :catch_67
    move-exception v2

    goto :goto_56

    :catch_69
    move-exception v2

    goto :goto_56
.end method


# virtual methods
.method protected done()V
    .registers 2

    .prologue
    .local p0, this:Landroid/accounts/AccountManager$Future2Task;,"Landroid/accounts/AccountManager$Future2Task<TT;>;"
    iget-object v0, p0, Landroid/accounts/AccountManager$Future2Task;->mCallback:Landroid/accounts/AccountManagerCallback;

    if-eqz v0, :cond_c

    new-instance v0, Landroid/accounts/AccountManager$Future2Task$1;

    invoke-direct {v0, p0}, Landroid/accounts/AccountManager$Future2Task$1;-><init>(Landroid/accounts/AccountManager$Future2Task;)V

    invoke-virtual {p0, v0}, Landroid/accounts/AccountManager$Future2Task;->postRunnableToHandler(Ljava/lang/Runnable;)V

    :cond_c
    return-void
.end method

.method public getResult()Ljava/lang/Object;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/accounts/OperationCanceledException;,
            Ljava/io/IOException;,
            Landroid/accounts/AuthenticatorException;
        }
    .end annotation

    .prologue
    .local p0, this:Landroid/accounts/AccountManager$Future2Task;,"Landroid/accounts/AccountManager$Future2Task<TT;>;"
    const/4 v0, 0x0

    invoke-direct {p0, v0, v0}, Landroid/accounts/AccountManager$Future2Task;->internalGetResult(Ljava/lang/Long;Ljava/util/concurrent/TimeUnit;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getResult(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    .registers 5
    .parameter "timeout"
    .parameter "unit"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Ljava/util/concurrent/TimeUnit;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/accounts/OperationCanceledException;,
            Ljava/io/IOException;,
            Landroid/accounts/AuthenticatorException;
        }
    .end annotation

    .prologue
    .local p0, this:Landroid/accounts/AccountManager$Future2Task;,"Landroid/accounts/AccountManager$Future2Task<TT;>;"
    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-direct {p0, v0, p3}, Landroid/accounts/AccountManager$Future2Task;->internalGetResult(Ljava/lang/Long;Ljava/util/concurrent/TimeUnit;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public start()Landroid/accounts/AccountManager$Future2Task;
    .registers 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroid/accounts/AccountManager$Future2Task",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .local p0, this:Landroid/accounts/AccountManager$Future2Task;,"Landroid/accounts/AccountManager$Future2Task<TT;>;"
    invoke-virtual {p0}, Landroid/accounts/AccountManager$Future2Task;->startTask()V

    return-object p0
.end method
