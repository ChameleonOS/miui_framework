.class public final Landroid/os/CancellationSignal;
.super Ljava/lang/Object;
.source "CancellationSignal.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/os/CancellationSignal$1;,
        Landroid/os/CancellationSignal$Transport;,
        Landroid/os/CancellationSignal$OnCancelListener;
    }
.end annotation


# instance fields
.field private mCancelInProgress:Z

.field private mIsCanceled:Z

.field private mOnCancelListener:Landroid/os/CancellationSignal$OnCancelListener;

.field private mRemote:Landroid/os/ICancellationSignal;


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static createTransport()Landroid/os/ICancellationSignal;
    .registers 2

    .prologue
    new-instance v0, Landroid/os/CancellationSignal$Transport;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Landroid/os/CancellationSignal$Transport;-><init>(Landroid/os/CancellationSignal$1;)V

    return-object v0
.end method

.method public static fromTransport(Landroid/os/ICancellationSignal;)Landroid/os/CancellationSignal;
    .registers 2
    .parameter "transport"

    .prologue
    instance-of v0, p0, Landroid/os/CancellationSignal$Transport;

    if-eqz v0, :cond_9

    check-cast p0, Landroid/os/CancellationSignal$Transport;

    .end local p0
    iget-object v0, p0, Landroid/os/CancellationSignal$Transport;->mCancellationSignal:Landroid/os/CancellationSignal;

    :goto_8
    return-object v0

    .restart local p0
    :cond_9
    const/4 v0, 0x0

    goto :goto_8
.end method

.method private waitForCancelFinishedLocked()V
    .registers 2

    .prologue
    :goto_0
    iget-boolean v0, p0, Landroid/os/CancellationSignal;->mCancelInProgress:Z

    if-eqz v0, :cond_a

    :try_start_4
    invoke-virtual {p0}, Ljava/lang/Object;->wait()V
    :try_end_7
    .catch Ljava/lang/InterruptedException; {:try_start_4 .. :try_end_7} :catch_8

    goto :goto_0

    :catch_8
    move-exception v0

    goto :goto_0

    :cond_a
    return-void
.end method


# virtual methods
.method public cancel()V
    .registers 5

    .prologue
    monitor-enter p0

    :try_start_1
    iget-boolean v2, p0, Landroid/os/CancellationSignal;->mIsCanceled:Z

    if-eqz v2, :cond_7

    monitor-exit p0

    :goto_6
    return-void

    :cond_7
    const/4 v2, 0x1

    iput-boolean v2, p0, Landroid/os/CancellationSignal;->mIsCanceled:Z

    const/4 v2, 0x1

    iput-boolean v2, p0, Landroid/os/CancellationSignal;->mCancelInProgress:Z

    iget-object v0, p0, Landroid/os/CancellationSignal;->mOnCancelListener:Landroid/os/CancellationSignal$OnCancelListener;

    .local v0, listener:Landroid/os/CancellationSignal$OnCancelListener;
    iget-object v1, p0, Landroid/os/CancellationSignal;->mRemote:Landroid/os/ICancellationSignal;

    .local v1, remote:Landroid/os/ICancellationSignal;
    monitor-exit p0
    :try_end_12
    .catchall {:try_start_1 .. :try_end_12} :catchall_28

    if-eqz v0, :cond_17

    :try_start_14
    invoke-interface {v0}, Landroid/os/CancellationSignal$OnCancelListener;->onCancel()V
    :try_end_17
    .catchall {:try_start_14 .. :try_end_17} :catchall_2b

    :cond_17
    if-eqz v1, :cond_1c

    :try_start_19
    invoke-interface {v1}, Landroid/os/ICancellationSignal;->cancel()V
    :try_end_1c
    .catchall {:try_start_19 .. :try_end_1c} :catchall_2b
    .catch Landroid/os/RemoteException; {:try_start_19 .. :try_end_1c} :catch_35

    :cond_1c
    :goto_1c
    monitor-enter p0

    const/4 v2, 0x0

    :try_start_1e
    iput-boolean v2, p0, Landroid/os/CancellationSignal;->mCancelInProgress:Z

    invoke-virtual {p0}, Ljava/lang/Object;->notifyAll()V

    monitor-exit p0

    goto :goto_6

    :catchall_25
    move-exception v2

    monitor-exit p0
    :try_end_27
    .catchall {:try_start_1e .. :try_end_27} :catchall_25

    throw v2

    .end local v0           #listener:Landroid/os/CancellationSignal$OnCancelListener;
    .end local v1           #remote:Landroid/os/ICancellationSignal;
    :catchall_28
    move-exception v2

    :try_start_29
    monitor-exit p0
    :try_end_2a
    .catchall {:try_start_29 .. :try_end_2a} :catchall_28

    throw v2

    .restart local v0       #listener:Landroid/os/CancellationSignal$OnCancelListener;
    .restart local v1       #remote:Landroid/os/ICancellationSignal;
    :catchall_2b
    move-exception v2

    monitor-enter p0

    const/4 v3, 0x0

    :try_start_2e
    iput-boolean v3, p0, Landroid/os/CancellationSignal;->mCancelInProgress:Z

    invoke-virtual {p0}, Ljava/lang/Object;->notifyAll()V

    monitor-exit p0
    :try_end_34
    .catchall {:try_start_2e .. :try_end_34} :catchall_37

    throw v2

    :catch_35
    move-exception v2

    goto :goto_1c

    :catchall_37
    move-exception v2

    :try_start_38
    monitor-exit p0
    :try_end_39
    .catchall {:try_start_38 .. :try_end_39} :catchall_37

    throw v2
.end method

.method public isCanceled()Z
    .registers 2

    .prologue
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/os/CancellationSignal;->mIsCanceled:Z

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0
    :try_end_7
    .catchall {:try_start_1 .. :try_end_7} :catchall_5

    throw v0
.end method

.method public setOnCancelListener(Landroid/os/CancellationSignal$OnCancelListener;)V
    .registers 3
    .parameter "listener"

    .prologue
    monitor-enter p0

    :try_start_1
    invoke-direct {p0}, Landroid/os/CancellationSignal;->waitForCancelFinishedLocked()V

    iget-object v0, p0, Landroid/os/CancellationSignal;->mOnCancelListener:Landroid/os/CancellationSignal$OnCancelListener;

    if-ne v0, p1, :cond_a

    monitor-exit p0

    :goto_9
    return-void

    :cond_a
    iput-object p1, p0, Landroid/os/CancellationSignal;->mOnCancelListener:Landroid/os/CancellationSignal$OnCancelListener;

    iget-boolean v0, p0, Landroid/os/CancellationSignal;->mIsCanceled:Z

    if-eqz v0, :cond_12

    if-nez p1, :cond_17

    :cond_12
    monitor-exit p0

    goto :goto_9

    :catchall_14
    move-exception v0

    monitor-exit p0
    :try_end_16
    .catchall {:try_start_1 .. :try_end_16} :catchall_14

    throw v0

    :cond_17
    :try_start_17
    monitor-exit p0
    :try_end_18
    .catchall {:try_start_17 .. :try_end_18} :catchall_14

    invoke-interface {p1}, Landroid/os/CancellationSignal$OnCancelListener;->onCancel()V

    goto :goto_9
.end method

.method public setRemote(Landroid/os/ICancellationSignal;)V
    .registers 3
    .parameter "remote"

    .prologue
    monitor-enter p0

    :try_start_1
    invoke-direct {p0}, Landroid/os/CancellationSignal;->waitForCancelFinishedLocked()V

    iget-object v0, p0, Landroid/os/CancellationSignal;->mRemote:Landroid/os/ICancellationSignal;

    if-ne v0, p1, :cond_a

    monitor-exit p0

    :goto_9
    return-void

    :cond_a
    iput-object p1, p0, Landroid/os/CancellationSignal;->mRemote:Landroid/os/ICancellationSignal;

    iget-boolean v0, p0, Landroid/os/CancellationSignal;->mIsCanceled:Z

    if-eqz v0, :cond_12

    if-nez p1, :cond_17

    :cond_12
    monitor-exit p0

    goto :goto_9

    :catchall_14
    move-exception v0

    monitor-exit p0
    :try_end_16
    .catchall {:try_start_1 .. :try_end_16} :catchall_14

    throw v0

    :cond_17
    :try_start_17
    monitor-exit p0
    :try_end_18
    .catchall {:try_start_17 .. :try_end_18} :catchall_14

    :try_start_18
    invoke-interface {p1}, Landroid/os/ICancellationSignal;->cancel()V
    :try_end_1b
    .catch Landroid/os/RemoteException; {:try_start_18 .. :try_end_1b} :catch_1c

    goto :goto_9

    :catch_1c
    move-exception v0

    goto :goto_9
.end method

.method public throwIfCanceled()V
    .registers 2

    .prologue
    invoke-virtual {p0}, Landroid/os/CancellationSignal;->isCanceled()Z

    move-result v0

    if-eqz v0, :cond_c

    new-instance v0, Landroid/os/OperationCanceledException;

    invoke-direct {v0}, Landroid/os/OperationCanceledException;-><init>()V

    throw v0

    :cond_c
    return-void
.end method
