.class public Landroid/os/ConditionVariable;
.super Ljava/lang/Object;
.source "ConditionVariable.java"


# instance fields
.field private volatile mCondition:Z


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/os/ConditionVariable;->mCondition:Z

    return-void
.end method

.method public constructor <init>(Z)V
    .registers 2
    .parameter "state"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-boolean p1, p0, Landroid/os/ConditionVariable;->mCondition:Z

    return-void
.end method


# virtual methods
.method public block()V
    .registers 2

    .prologue
    monitor-enter p0

    :goto_1
    :try_start_1
    iget-boolean v0, p0, Landroid/os/ConditionVariable;->mCondition:Z
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_d

    if-nez v0, :cond_b

    :try_start_5
    invoke-virtual {p0}, Ljava/lang/Object;->wait()V
    :try_end_8
    .catchall {:try_start_5 .. :try_end_8} :catchall_d
    .catch Ljava/lang/InterruptedException; {:try_start_5 .. :try_end_8} :catch_9

    goto :goto_1

    :catch_9
    move-exception v0

    goto :goto_1

    :cond_b
    :try_start_b
    monitor-exit p0

    return-void

    :catchall_d
    move-exception v0

    monitor-exit p0
    :try_end_f
    .catchall {:try_start_b .. :try_end_f} :catchall_d

    throw v0
.end method

.method public block(J)Z
    .registers 9
    .parameter "timeout"

    .prologue
    const-wide/16 v4, 0x0

    cmp-long v4, p1, v4

    if-eqz v4, :cond_26

    monitor-enter p0

    :try_start_7
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .local v2, now:J
    add-long v0, v2, p1

    .local v0, end:J
    :goto_d
    iget-boolean v4, p0, Landroid/os/ConditionVariable;->mCondition:Z
    :try_end_f
    .catchall {:try_start_7 .. :try_end_f} :catchall_23

    if-nez v4, :cond_1f

    cmp-long v4, v2, v0

    if-gez v4, :cond_1f

    sub-long v4, v0, v2

    :try_start_17
    invoke-virtual {p0, v4, v5}, Ljava/lang/Object;->wait(J)V
    :try_end_1a
    .catchall {:try_start_17 .. :try_end_1a} :catchall_23
    .catch Ljava/lang/InterruptedException; {:try_start_17 .. :try_end_1a} :catch_2b

    :goto_1a
    :try_start_1a
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    goto :goto_d

    :cond_1f
    iget-boolean v4, p0, Landroid/os/ConditionVariable;->mCondition:Z

    monitor-exit p0

    .end local v0           #end:J
    .end local v2           #now:J
    :goto_22
    return v4

    :catchall_23
    move-exception v4

    monitor-exit p0
    :try_end_25
    .catchall {:try_start_1a .. :try_end_25} :catchall_23

    throw v4

    :cond_26
    invoke-virtual {p0}, Landroid/os/ConditionVariable;->block()V

    const/4 v4, 0x1

    goto :goto_22

    .restart local v0       #end:J
    .restart local v2       #now:J
    :catch_2b
    move-exception v4

    goto :goto_1a
.end method

.method public close()V
    .registers 2

    .prologue
    monitor-enter p0

    const/4 v0, 0x0

    :try_start_2
    iput-boolean v0, p0, Landroid/os/ConditionVariable;->mCondition:Z

    monitor-exit p0

    return-void

    :catchall_6
    move-exception v0

    monitor-exit p0
    :try_end_8
    .catchall {:try_start_2 .. :try_end_8} :catchall_6

    throw v0
.end method

.method public open()V
    .registers 3

    .prologue
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/os/ConditionVariable;->mCondition:Z

    .local v0, old:Z
    const/4 v1, 0x1

    iput-boolean v1, p0, Landroid/os/ConditionVariable;->mCondition:Z

    if-nez v0, :cond_b

    invoke-virtual {p0}, Ljava/lang/Object;->notifyAll()V

    :cond_b
    monitor-exit p0

    return-void

    .end local v0           #old:Z
    :catchall_d
    move-exception v1

    monitor-exit p0
    :try_end_f
    .catchall {:try_start_1 .. :try_end_f} :catchall_d

    throw v1
.end method
