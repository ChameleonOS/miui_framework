.class public Landroid/os/ConditionVariable;
.super Ljava/lang/Object;
.source "ConditionVariable.java"


# instance fields
.field private volatile mCondition:Z


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 40
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 41
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/os/ConditionVariable;->mCondition:Z

    .line 42
    return-void
.end method

.method public constructor <init>(Z)V
    .registers 2
    .parameter "state"

    .prologue
    .line 51
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 52
    iput-boolean p1, p0, Landroid/os/ConditionVariable;->mCondition:Z

    .line 53
    return-void
.end method


# virtual methods
.method public block()V
    .registers 2

    .prologue
    .line 94
    monitor-enter p0

    .line 95
    :goto_1
    :try_start_1
    iget-boolean v0, p0, Landroid/os/ConditionVariable;->mCondition:Z
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_d

    if-nez v0, :cond_b

    .line 97
    :try_start_5
    invoke-virtual {p0}, Ljava/lang/Object;->wait()V
    :try_end_8
    .catchall {:try_start_5 .. :try_end_8} :catchall_d
    .catch Ljava/lang/InterruptedException; {:try_start_5 .. :try_end_8} :catch_9

    goto :goto_1

    .line 99
    :catch_9
    move-exception v0

    goto :goto_1

    .line 102
    :cond_b
    :try_start_b
    monitor-exit p0

    .line 103
    return-void

    .line 102
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
    .line 122
    const-wide/16 v4, 0x0

    cmp-long v4, p1, v4

    if-eqz v4, :cond_26

    .line 123
    monitor-enter p0

    .line 124
    :try_start_7
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 125
    .local v2, now:J
    add-long v0, v2, p1

    .line 126
    .local v0, end:J
    :goto_d
    iget-boolean v4, p0, Landroid/os/ConditionVariable;->mCondition:Z
    :try_end_f
    .catchall {:try_start_7 .. :try_end_f} :catchall_23

    if-nez v4, :cond_1f

    cmp-long v4, v2, v0

    if-gez v4, :cond_1f

    .line 128
    sub-long v4, v0, v2

    :try_start_17
    invoke-virtual {p0, v4, v5}, Ljava/lang/Object;->wait(J)V
    :try_end_1a
    .catchall {:try_start_17 .. :try_end_1a} :catchall_23
    .catch Ljava/lang/InterruptedException; {:try_start_17 .. :try_end_1a} :catch_2b

    .line 132
    :goto_1a
    :try_start_1a
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    goto :goto_d

    .line 134
    :cond_1f
    iget-boolean v4, p0, Landroid/os/ConditionVariable;->mCondition:Z

    monitor-exit p0

    .line 138
    .end local v0           #end:J
    .end local v2           #now:J
    :goto_22
    return v4

    .line 135
    :catchall_23
    move-exception v4

    monitor-exit p0
    :try_end_25
    .catchall {:try_start_1a .. :try_end_25} :catchall_23

    throw v4

    .line 137
    :cond_26
    invoke-virtual {p0}, Landroid/os/ConditionVariable;->block()V

    .line 138
    const/4 v4, 0x1

    goto :goto_22

    .line 130
    .restart local v0       #end:J
    .restart local v2       #now:J
    :catch_2b
    move-exception v4

    goto :goto_1a
.end method

.method public close()V
    .registers 2

    .prologue
    .line 81
    monitor-enter p0

    .line 82
    const/4 v0, 0x0

    :try_start_2
    iput-boolean v0, p0, Landroid/os/ConditionVariable;->mCondition:Z

    .line 83
    monitor-exit p0

    .line 84
    return-void

    .line 83
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
    .line 64
    monitor-enter p0

    .line 65
    :try_start_1
    iget-boolean v0, p0, Landroid/os/ConditionVariable;->mCondition:Z

    .line 66
    .local v0, old:Z
    const/4 v1, 0x1

    iput-boolean v1, p0, Landroid/os/ConditionVariable;->mCondition:Z

    .line 67
    if-nez v0, :cond_b

    .line 68
    invoke-virtual {p0}, Ljava/lang/Object;->notifyAll()V

    .line 70
    :cond_b
    monitor-exit p0

    .line 71
    return-void

    .line 70
    .end local v0           #old:Z
    :catchall_d
    move-exception v1

    monitor-exit p0
    :try_end_f
    .catchall {:try_start_1 .. :try_end_f} :catchall_d

    throw v1
.end method
