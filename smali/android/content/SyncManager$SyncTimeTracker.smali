.class Landroid/content/SyncManager$SyncTimeTracker;
.super Ljava/lang/Object;
.source "SyncManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/content/SyncManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SyncTimeTracker"
.end annotation


# instance fields
.field mLastWasSyncing:Z

.field private mTimeSpentSyncing:J

.field mWhenSyncStarted:J

.field final synthetic this$0:Landroid/content/SyncManager;


# direct methods
.method private constructor <init>(Landroid/content/SyncManager;)V
    .registers 4
    .parameter

    .prologue
    .line 1520
    iput-object p1, p0, Landroid/content/SyncManager$SyncTimeTracker;->this$0:Landroid/content/SyncManager;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 1522
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/content/SyncManager$SyncTimeTracker;->mLastWasSyncing:Z

    .line 1524
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Landroid/content/SyncManager$SyncTimeTracker;->mWhenSyncStarted:J

    return-void
.end method

.method synthetic constructor <init>(Landroid/content/SyncManager;Landroid/content/SyncManager$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 1520
    invoke-direct {p0, p1}, Landroid/content/SyncManager$SyncTimeTracker;-><init>(Landroid/content/SyncManager;)V

    return-void
.end method


# virtual methods
.method public declared-synchronized timeSpentSyncing()J
    .registers 7

    .prologue
    .line 1543
    monitor-enter p0

    :try_start_1
    iget-boolean v2, p0, Landroid/content/SyncManager$SyncTimeTracker;->mLastWasSyncing:Z

    if-nez v2, :cond_9

    iget-wide v2, p0, Landroid/content/SyncManager$SyncTimeTracker;->mTimeSpentSyncing:J
    :try_end_7
    .catchall {:try_start_1 .. :try_end_7} :catchall_15

    .line 1546
    :goto_7
    monitor-exit p0

    return-wide v2

    .line 1545
    :cond_9
    :try_start_9
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v0

    .line 1546
    .local v0, now:J
    iget-wide v2, p0, Landroid/content/SyncManager$SyncTimeTracker;->mTimeSpentSyncing:J

    iget-wide v4, p0, Landroid/content/SyncManager$SyncTimeTracker;->mWhenSyncStarted:J
    :try_end_11
    .catchall {:try_start_9 .. :try_end_11} :catchall_15

    sub-long v4, v0, v4

    add-long/2addr v2, v4

    goto :goto_7

    .line 1543
    .end local v0           #now:J
    :catchall_15
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized update()V
    .registers 8

    .prologue
    .line 1530
    monitor-enter p0

    :try_start_1
    iget-object v3, p0, Landroid/content/SyncManager$SyncTimeTracker;->this$0:Landroid/content/SyncManager;

    iget-object v3, v3, Landroid/content/SyncManager;->mActiveSyncContexts:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_12

    const/4 v0, 0x1

    .line 1531
    .local v0, isSyncInProgress:Z
    :goto_c
    iget-boolean v3, p0, Landroid/content/SyncManager$SyncTimeTracker;->mLastWasSyncing:Z
    :try_end_e
    .catchall {:try_start_1 .. :try_end_e} :catchall_1f

    if-ne v0, v3, :cond_14

    .line 1539
    :goto_10
    monitor-exit p0

    return-void

    .line 1530
    .end local v0           #isSyncInProgress:Z
    :cond_12
    const/4 v0, 0x0

    goto :goto_c

    .line 1532
    .restart local v0       #isSyncInProgress:Z
    :cond_14
    :try_start_14
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v1

    .line 1533
    .local v1, now:J
    if-eqz v0, :cond_22

    .line 1534
    iput-wide v1, p0, Landroid/content/SyncManager$SyncTimeTracker;->mWhenSyncStarted:J

    .line 1538
    :goto_1c
    iput-boolean v0, p0, Landroid/content/SyncManager$SyncTimeTracker;->mLastWasSyncing:Z
    :try_end_1e
    .catchall {:try_start_14 .. :try_end_1e} :catchall_1f

    goto :goto_10

    .line 1530
    .end local v0           #isSyncInProgress:Z
    .end local v1           #now:J
    :catchall_1f
    move-exception v3

    monitor-exit p0

    throw v3

    .line 1536
    .restart local v0       #isSyncInProgress:Z
    .restart local v1       #now:J
    :cond_22
    :try_start_22
    iget-wide v3, p0, Landroid/content/SyncManager$SyncTimeTracker;->mTimeSpentSyncing:J

    iget-wide v5, p0, Landroid/content/SyncManager$SyncTimeTracker;->mWhenSyncStarted:J

    sub-long v5, v1, v5

    add-long/2addr v3, v5

    iput-wide v3, p0, Landroid/content/SyncManager$SyncTimeTracker;->mTimeSpentSyncing:J
    :try_end_2b
    .catchall {:try_start_22 .. :try_end_2b} :catchall_1f

    goto :goto_1c
.end method
