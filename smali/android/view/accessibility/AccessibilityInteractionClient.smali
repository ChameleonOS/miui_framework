.class public final Landroid/view/accessibility/AccessibilityInteractionClient;
.super Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback$Stub;
.source "AccessibilityInteractionClient.java"


# static fields
.field private static final CHECK_INTEGRITY:Z = true

.field private static final DEBUG:Z = false

.field private static final LOG_TAG:Ljava/lang/String; = "AccessibilityInteractionClient"

.field public static final NO_ID:I = -0x1

.field private static final TIMEOUT_INTERACTION_MILLIS:J = 0x1388L

.field private static final sAccessibilityNodeInfoCache:Landroid/view/accessibility/AccessibilityNodeInfoCache;

.field private static final sClients:Landroid/util/LongSparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/LongSparseArray",
            "<",
            "Landroid/view/accessibility/AccessibilityInteractionClient;",
            ">;"
        }
    .end annotation
.end field

.field private static final sConnectionCache:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Landroid/accessibilityservice/IAccessibilityServiceConnection;",
            ">;"
        }
    .end annotation
.end field

.field private static final sStaticLock:Ljava/lang/Object;


# instance fields
.field private mFindAccessibilityNodeInfoResult:Landroid/view/accessibility/AccessibilityNodeInfo;

.field private mFindAccessibilityNodeInfosResult:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Landroid/view/accessibility/AccessibilityNodeInfo;",
            ">;"
        }
    .end annotation
.end field

.field private final mInstanceLock:Ljava/lang/Object;

.field private volatile mInteractionId:I

.field private final mInteractionIdCounter:Ljava/util/concurrent/atomic/AtomicInteger;

.field private mPerformAccessibilityActionResult:Z

.field private mSameThreadMessage:Landroid/os/Message;

.field private final mTempBounds:Landroid/graphics/Rect;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Landroid/view/accessibility/AccessibilityInteractionClient;->sStaticLock:Ljava/lang/Object;

    new-instance v0, Landroid/util/LongSparseArray;

    invoke-direct {v0}, Landroid/util/LongSparseArray;-><init>()V

    sput-object v0, Landroid/view/accessibility/AccessibilityInteractionClient;->sClients:Landroid/util/LongSparseArray;

    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    sput-object v0, Landroid/view/accessibility/AccessibilityInteractionClient;->sConnectionCache:Landroid/util/SparseArray;

    new-instance v0, Landroid/view/accessibility/AccessibilityNodeInfoCache;

    invoke-direct {v0}, Landroid/view/accessibility/AccessibilityNodeInfoCache;-><init>()V

    sput-object v0, Landroid/view/accessibility/AccessibilityInteractionClient;->sAccessibilityNodeInfoCache:Landroid/view/accessibility/AccessibilityNodeInfoCache;

    return-void
.end method

.method private constructor <init>()V
    .registers 2

    .prologue
    invoke-direct {p0}, Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback$Stub;-><init>()V

    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    iput-object v0, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mInteractionIdCounter:Ljava/util/concurrent/atomic/AtomicInteger;

    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mInstanceLock:Ljava/lang/Object;

    const/4 v0, -0x1

    iput v0, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mInteractionId:I

    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mTempBounds:Landroid/graphics/Rect;

    return-void
.end method

.method private applyCompatibilityScaleIfNeeded(Landroid/view/accessibility/AccessibilityNodeInfo;F)V
    .registers 5
    .parameter "info"
    .parameter "scale"

    .prologue
    const/high16 v1, 0x3f80

    cmpl-float v1, p2, v1

    if-nez v1, :cond_7

    :goto_6
    return-void

    :cond_7
    iget-object v0, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mTempBounds:Landroid/graphics/Rect;

    .local v0, bounds:Landroid/graphics/Rect;
    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->getBoundsInParent(Landroid/graphics/Rect;)V

    invoke-virtual {v0, p2}, Landroid/graphics/Rect;->scale(F)V

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->setBoundsInParent(Landroid/graphics/Rect;)V

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->getBoundsInScreen(Landroid/graphics/Rect;)V

    invoke-virtual {v0, p2}, Landroid/graphics/Rect;->scale(F)V

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->setBoundsInScreen(Landroid/graphics/Rect;)V

    goto :goto_6
.end method

.method private checkFindAccessibilityNodeInfoResultIntegrity(Ljava/util/List;)V
    .registers 21
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Landroid/view/accessibility/AccessibilityNodeInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, infos:Ljava/util/List;,"Ljava/util/List<Landroid/view/accessibility/AccessibilityNodeInfo;>;"
    invoke-interface/range {p1 .. p1}, Ljava/util/List;->size()I

    move-result v15

    if-nez v15, :cond_7

    :cond_6
    :goto_6
    return-void

    :cond_7
    const/4 v15, 0x0

    move-object/from16 v0, p1

    invoke-interface {v0, v15}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Landroid/view/accessibility/AccessibilityNodeInfo;

    .local v13, root:Landroid/view/accessibility/AccessibilityNodeInfo;
    invoke-interface/range {p1 .. p1}, Ljava/util/List;->size()I

    move-result v11

    .local v11, infoCount:I
    const/4 v10, 0x1

    .local v10, i:I
    :goto_15
    if-ge v10, v11, :cond_35

    move v12, v10

    .local v12, j:I
    :goto_18
    if-ge v12, v11, :cond_2f

    move-object/from16 v0, p1

    invoke-interface {v0, v12}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/accessibility/AccessibilityNodeInfo;

    .local v1, candidate:Landroid/view/accessibility/AccessibilityNodeInfo;
    invoke-virtual {v13}, Landroid/view/accessibility/AccessibilityNodeInfo;->getParentNodeId()J

    move-result-wide v15

    invoke-virtual {v1}, Landroid/view/accessibility/AccessibilityNodeInfo;->getSourceNodeId()J

    move-result-wide v17

    cmp-long v15, v15, v17

    if-nez v15, :cond_32

    move-object v13, v1

    .end local v1           #candidate:Landroid/view/accessibility/AccessibilityNodeInfo;
    :cond_2f
    add-int/lit8 v10, v10, 0x1

    goto :goto_15

    .restart local v1       #candidate:Landroid/view/accessibility/AccessibilityNodeInfo;
    :cond_32
    add-int/lit8 v12, v12, 0x1

    goto :goto_18

    .end local v1           #candidate:Landroid/view/accessibility/AccessibilityNodeInfo;
    .end local v12           #j:I
    :cond_35
    if-nez v13, :cond_3e

    const-string v15, "AccessibilityInteractionClient"

    const-string v16, "No root."

    invoke-static/range {v15 .. v16}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    :cond_3e
    new-instance v14, Ljava/util/HashSet;

    invoke-direct {v14}, Ljava/util/HashSet;-><init>()V

    .local v14, seen:Ljava/util/HashSet;,"Ljava/util/HashSet<Landroid/view/accessibility/AccessibilityNodeInfo;>;"
    new-instance v9, Ljava/util/LinkedList;

    invoke-direct {v9}, Ljava/util/LinkedList;-><init>()V

    .local v9, fringe:Ljava/util/Queue;,"Ljava/util/Queue<Landroid/view/accessibility/AccessibilityNodeInfo;>;"
    invoke-interface {v9, v13}, Ljava/util/Queue;->add(Ljava/lang/Object;)Z

    :cond_4b
    invoke-interface {v9}, Ljava/util/Queue;->isEmpty()Z

    move-result v15

    if-nez v15, :cond_90

    invoke-interface {v9}, Ljava/util/Queue;->poll()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/view/accessibility/AccessibilityNodeInfo;

    .local v7, current:Landroid/view/accessibility/AccessibilityNodeInfo;
    invoke-virtual {v14, v7}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    move-result v15

    if-nez v15, :cond_65

    const-string v15, "AccessibilityInteractionClient"

    const-string v16, "Duplicate node."

    invoke-static/range {v15 .. v16}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_6

    :cond_65
    invoke-virtual {v7}, Landroid/view/accessibility/AccessibilityNodeInfo;->getChildNodeIds()Landroid/util/SparseLongArray;

    move-result-object v6

    .local v6, childIds:Landroid/util/SparseLongArray;
    invoke-virtual {v6}, Landroid/util/SparseLongArray;->size()I

    move-result v3

    .local v3, childCount:I
    const/4 v10, 0x0

    :goto_6e
    if-ge v10, v3, :cond_4b

    invoke-virtual {v6, v10}, Landroid/util/SparseLongArray;->valueAt(I)J

    move-result-wide v4

    .local v4, childId:J
    const/4 v12, 0x0

    .restart local v12       #j:I
    :goto_75
    if-ge v12, v11, :cond_8d

    move-object/from16 v0, p1

    invoke-interface {v0, v12}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/view/accessibility/AccessibilityNodeInfo;

    .local v2, child:Landroid/view/accessibility/AccessibilityNodeInfo;
    invoke-virtual {v2}, Landroid/view/accessibility/AccessibilityNodeInfo;->getSourceNodeId()J

    move-result-wide v15

    cmp-long v15, v15, v4

    if-nez v15, :cond_8a

    invoke-interface {v9, v2}, Ljava/util/Queue;->add(Ljava/lang/Object;)Z

    :cond_8a
    add-int/lit8 v12, v12, 0x1

    goto :goto_75

    .end local v2           #child:Landroid/view/accessibility/AccessibilityNodeInfo;
    :cond_8d
    add-int/lit8 v10, v10, 0x1

    goto :goto_6e

    .end local v3           #childCount:I
    .end local v4           #childId:J
    .end local v6           #childIds:Landroid/util/SparseLongArray;
    .end local v7           #current:Landroid/view/accessibility/AccessibilityNodeInfo;
    .end local v12           #j:I
    :cond_90
    invoke-interface/range {p1 .. p1}, Ljava/util/List;->size()I

    move-result v15

    invoke-virtual {v14}, Ljava/util/HashSet;->size()I

    move-result v16

    sub-int v8, v15, v16

    .local v8, disconnectedCount:I
    if-lez v8, :cond_6

    const-string v15, "AccessibilityInteractionClient"

    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v16

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v16

    const-string v17, " Disconnected nodes."

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-static/range {v15 .. v16}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_6
.end method

.method private clearResultLocked()V
    .registers 3

    .prologue
    const/4 v1, 0x0

    const/4 v0, -0x1

    iput v0, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mInteractionId:I

    iput-object v1, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mFindAccessibilityNodeInfoResult:Landroid/view/accessibility/AccessibilityNodeInfo;

    iput-object v1, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mFindAccessibilityNodeInfosResult:Ljava/util/List;

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mPerformAccessibilityActionResult:Z

    return-void
.end method

.method private finalizeAndCacheAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;IF)V
    .registers 5
    .parameter "info"
    .parameter "connectionId"
    .parameter "windowScale"

    .prologue
    if-eqz p1, :cond_11

    invoke-direct {p0, p1, p3}, Landroid/view/accessibility/AccessibilityInteractionClient;->applyCompatibilityScaleIfNeeded(Landroid/view/accessibility/AccessibilityNodeInfo;F)V

    invoke-virtual {p1, p2}, Landroid/view/accessibility/AccessibilityNodeInfo;->setConnectionId(I)V

    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->setSealed(Z)V

    sget-object v0, Landroid/view/accessibility/AccessibilityInteractionClient;->sAccessibilityNodeInfoCache:Landroid/view/accessibility/AccessibilityNodeInfoCache;

    invoke-virtual {v0, p1}, Landroid/view/accessibility/AccessibilityNodeInfoCache;->add(Landroid/view/accessibility/AccessibilityNodeInfo;)V

    :cond_11
    return-void
.end method

.method private finalizeAndCacheAccessibilityNodeInfos(Ljava/util/List;IF)V
    .registers 7
    .parameter
    .parameter "connectionId"
    .parameter "windowScale"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Landroid/view/accessibility/AccessibilityNodeInfo;",
            ">;IF)V"
        }
    .end annotation

    .prologue
    .local p1, infos:Ljava/util/List;,"Ljava/util/List<Landroid/view/accessibility/AccessibilityNodeInfo;>;"
    if-eqz p1, :cond_15

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v2

    .local v2, infosCount:I
    const/4 v0, 0x0

    .local v0, i:I
    :goto_7
    if-ge v0, v2, :cond_15

    invoke-interface {p1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/accessibility/AccessibilityNodeInfo;

    .local v1, info:Landroid/view/accessibility/AccessibilityNodeInfo;
    invoke-direct {p0, v1, p2, p3}, Landroid/view/accessibility/AccessibilityInteractionClient;->finalizeAndCacheAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;IF)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_7

    .end local v0           #i:I
    .end local v1           #info:Landroid/view/accessibility/AccessibilityNodeInfo;
    .end local v2           #infosCount:I
    :cond_15
    return-void
.end method

.method private getFindAccessibilityNodeInfoResultAndClear(I)Landroid/view/accessibility/AccessibilityNodeInfo;
    .registers 6
    .parameter "interactionId"

    .prologue
    iget-object v3, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mInstanceLock:Ljava/lang/Object;

    monitor-enter v3

    :try_start_3
    invoke-direct {p0, p1}, Landroid/view/accessibility/AccessibilityInteractionClient;->waitForResultTimedLocked(I)Z

    move-result v1

    .local v1, success:Z
    if-eqz v1, :cond_10

    iget-object v0, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mFindAccessibilityNodeInfoResult:Landroid/view/accessibility/AccessibilityNodeInfo;

    .local v0, result:Landroid/view/accessibility/AccessibilityNodeInfo;
    :goto_b
    invoke-direct {p0}, Landroid/view/accessibility/AccessibilityInteractionClient;->clearResultLocked()V

    monitor-exit v3

    return-object v0

    .end local v0           #result:Landroid/view/accessibility/AccessibilityNodeInfo;
    :cond_10
    const/4 v0, 0x0

    goto :goto_b

    .end local v1           #success:Z
    :catchall_12
    move-exception v2

    monitor-exit v3
    :try_end_14
    .catchall {:try_start_3 .. :try_end_14} :catchall_12

    throw v2
.end method

.method private getFindAccessibilityNodeInfosResultAndClear(I)Ljava/util/List;
    .registers 6
    .parameter "interactionId"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Ljava/util/List",
            "<",
            "Landroid/view/accessibility/AccessibilityNodeInfo;",
            ">;"
        }
    .end annotation

    .prologue
    iget-object v3, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mInstanceLock:Ljava/lang/Object;

    monitor-enter v3

    :try_start_3
    invoke-direct {p0, p1}, Landroid/view/accessibility/AccessibilityInteractionClient;->waitForResultTimedLocked(I)Z

    move-result v1

    .local v1, success:Z
    const/4 v0, 0x0

    .local v0, result:Ljava/util/List;,"Ljava/util/List<Landroid/view/accessibility/AccessibilityNodeInfo;>;"
    if-eqz v1, :cond_18

    iget-object v0, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mFindAccessibilityNodeInfosResult:Ljava/util/List;

    :goto_c
    invoke-direct {p0}, Landroid/view/accessibility/AccessibilityInteractionClient;->clearResultLocked()V

    sget-boolean v2, Landroid/os/Build;->IS_DEBUGGABLE:Z

    if-eqz v2, :cond_16

    invoke-direct {p0, v0}, Landroid/view/accessibility/AccessibilityInteractionClient;->checkFindAccessibilityNodeInfoResultIntegrity(Ljava/util/List;)V

    :cond_16
    monitor-exit v3

    return-object v0

    :cond_18
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    goto :goto_c

    .end local v0           #result:Ljava/util/List;,"Ljava/util/List<Landroid/view/accessibility/AccessibilityNodeInfo;>;"
    .end local v1           #success:Z
    :catchall_1d
    move-exception v2

    monitor-exit v3
    :try_end_1f
    .catchall {:try_start_3 .. :try_end_1f} :catchall_1d

    throw v2
.end method

.method public static getInstance()Landroid/view/accessibility/AccessibilityInteractionClient;
    .registers 3

    .prologue
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Thread;->getId()J

    move-result-wide v0

    .local v0, threadId:J
    invoke-static {v0, v1}, Landroid/view/accessibility/AccessibilityInteractionClient;->getInstanceForThread(J)Landroid/view/accessibility/AccessibilityInteractionClient;

    move-result-object v2

    return-object v2
.end method

.method public static getInstanceForThread(J)Landroid/view/accessibility/AccessibilityInteractionClient;
    .registers 5
    .parameter "threadId"

    .prologue
    sget-object v2, Landroid/view/accessibility/AccessibilityInteractionClient;->sStaticLock:Ljava/lang/Object;

    monitor-enter v2

    :try_start_3
    sget-object v1, Landroid/view/accessibility/AccessibilityInteractionClient;->sClients:Landroid/util/LongSparseArray;

    invoke-virtual {v1, p0, p1}, Landroid/util/LongSparseArray;->get(J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/accessibility/AccessibilityInteractionClient;

    .local v0, client:Landroid/view/accessibility/AccessibilityInteractionClient;
    if-nez v0, :cond_17

    new-instance v0, Landroid/view/accessibility/AccessibilityInteractionClient;

    .end local v0           #client:Landroid/view/accessibility/AccessibilityInteractionClient;
    invoke-direct {v0}, Landroid/view/accessibility/AccessibilityInteractionClient;-><init>()V

    .restart local v0       #client:Landroid/view/accessibility/AccessibilityInteractionClient;
    sget-object v1, Landroid/view/accessibility/AccessibilityInteractionClient;->sClients:Landroid/util/LongSparseArray;

    invoke-virtual {v1, p0, p1, v0}, Landroid/util/LongSparseArray;->put(JLjava/lang/Object;)V

    :cond_17
    monitor-exit v2

    return-object v0

    .end local v0           #client:Landroid/view/accessibility/AccessibilityInteractionClient;
    :catchall_19
    move-exception v1

    monitor-exit v2
    :try_end_1b
    .catchall {:try_start_3 .. :try_end_1b} :catchall_19

    throw v1
.end method

.method private getPerformAccessibilityActionResultAndClear(I)Z
    .registers 6
    .parameter "interactionId"

    .prologue
    iget-object v3, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mInstanceLock:Ljava/lang/Object;

    monitor-enter v3

    :try_start_3
    invoke-direct {p0, p1}, Landroid/view/accessibility/AccessibilityInteractionClient;->waitForResultTimedLocked(I)Z

    move-result v1

    .local v1, success:Z
    if-eqz v1, :cond_10

    iget-boolean v0, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mPerformAccessibilityActionResult:Z

    .local v0, result:Z
    :goto_b
    invoke-direct {p0}, Landroid/view/accessibility/AccessibilityInteractionClient;->clearResultLocked()V

    monitor-exit v3

    return v0

    .end local v0           #result:Z
    :cond_10
    const/4 v0, 0x0

    goto :goto_b

    .end local v1           #success:Z
    :catchall_12
    move-exception v2

    monitor-exit v3
    :try_end_14
    .catchall {:try_start_3 .. :try_end_14} :catchall_12

    throw v2
.end method

.method private getSameProcessMessageAndClear()Landroid/os/Message;
    .registers 4

    .prologue
    iget-object v2, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mInstanceLock:Ljava/lang/Object;

    monitor-enter v2

    :try_start_3
    iget-object v0, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mSameThreadMessage:Landroid/os/Message;

    .local v0, result:Landroid/os/Message;
    const/4 v1, 0x0

    iput-object v1, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mSameThreadMessage:Landroid/os/Message;

    monitor-exit v2

    return-object v0

    .end local v0           #result:Landroid/os/Message;
    :catchall_a
    move-exception v1

    monitor-exit v2
    :try_end_c
    .catchall {:try_start_3 .. :try_end_c} :catchall_a

    throw v1
.end method

.method private waitForResultTimedLocked(I)Z
    .registers 12
    .parameter "interactionId"

    .prologue
    const/4 v7, 0x0

    const-wide/16 v5, 0x1388

    .local v5, waitTimeMillis:J
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v3

    .local v3, startTimeMillis:J
    :goto_7
    :try_start_7
    invoke-direct {p0}, Landroid/view/accessibility/AccessibilityInteractionClient;->getSameProcessMessageAndClear()Landroid/os/Message;

    move-result-object v2

    .local v2, sameProcessMessage:Landroid/os/Message;
    if-eqz v2, :cond_14

    invoke-virtual {v2}, Landroid/os/Message;->getTarget()Landroid/os/Handler;

    move-result-object v8

    invoke-virtual {v8, v2}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    :cond_14
    iget v8, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mInteractionId:I

    if-ne v8, p1, :cond_1a

    const/4 v7, 0x1

    :cond_19
    return v7

    :cond_1a
    iget v8, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mInteractionId:I

    if-gt v8, p1, :cond_19

    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v8

    sub-long v0, v8, v3

    .local v0, elapsedTimeMillis:J
    const-wide/16 v8, 0x1388

    sub-long v5, v8, v0

    const-wide/16 v8, 0x0

    cmp-long v8, v5, v8

    if-lez v8, :cond_19

    iget-object v8, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mInstanceLock:Ljava/lang/Object;

    invoke-virtual {v8, v5, v6}, Ljava/lang/Object;->wait(J)V
    :try_end_33
    .catch Ljava/lang/InterruptedException; {:try_start_7 .. :try_end_33} :catch_34

    goto :goto_7

    .end local v0           #elapsedTimeMillis:J
    .end local v2           #sameProcessMessage:Landroid/os/Message;
    :catch_34
    move-exception v8

    goto :goto_7
.end method


# virtual methods
.method public addConnection(ILandroid/accessibilityservice/IAccessibilityServiceConnection;)V
    .registers 5
    .parameter "connectionId"
    .parameter "connection"

    .prologue
    sget-object v1, Landroid/view/accessibility/AccessibilityInteractionClient;->sConnectionCache:Landroid/util/SparseArray;

    monitor-enter v1

    :try_start_3
    sget-object v0, Landroid/view/accessibility/AccessibilityInteractionClient;->sConnectionCache:Landroid/util/SparseArray;

    invoke-virtual {v0, p1, p2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    monitor-exit v1

    return-void

    :catchall_a
    move-exception v0

    monitor-exit v1
    :try_end_c
    .catchall {:try_start_3 .. :try_end_c} :catchall_a

    throw v0
.end method

.method public clearCache()V
    .registers 2

    .prologue
    sget-object v0, Landroid/view/accessibility/AccessibilityInteractionClient;->sAccessibilityNodeInfoCache:Landroid/view/accessibility/AccessibilityNodeInfoCache;

    invoke-virtual {v0}, Landroid/view/accessibility/AccessibilityNodeInfoCache;->clear()V

    return-void
.end method

.method public findAccessibilityNodeInfoByAccessibilityId(IIJI)Landroid/view/accessibility/AccessibilityNodeInfo;
    .registers 20
    .parameter "connectionId"
    .parameter "accessibilityWindowId"
    .parameter "accessibilityNodeId"
    .parameter "prefetchFlags"

    .prologue
    :try_start_0
    invoke-virtual {p0, p1}, Landroid/view/accessibility/AccessibilityInteractionClient;->getConnection(I)Landroid/accessibilityservice/IAccessibilityServiceConnection;

    move-result-object v2

    .local v2, connection:Landroid/accessibilityservice/IAccessibilityServiceConnection;
    if-eqz v2, :cond_48

    sget-object v3, Landroid/view/accessibility/AccessibilityInteractionClient;->sAccessibilityNodeInfoCache:Landroid/view/accessibility/AccessibilityNodeInfoCache;

    move-wide/from16 v0, p3

    invoke-virtual {v3, v0, v1}, Landroid/view/accessibility/AccessibilityNodeInfoCache;->get(J)Landroid/view/accessibility/AccessibilityNodeInfo;

    move-result-object v11

    .local v11, cachedInfo:Landroid/view/accessibility/AccessibilityNodeInfo;
    if-eqz v11, :cond_11

    .end local v2           #connection:Landroid/accessibilityservice/IAccessibilityServiceConnection;
    .end local v11           #cachedInfo:Landroid/view/accessibility/AccessibilityNodeInfo;
    :goto_10
    return-object v11

    .restart local v2       #connection:Landroid/accessibilityservice/IAccessibilityServiceConnection;
    .restart local v11       #cachedInfo:Landroid/view/accessibility/AccessibilityNodeInfo;
    :cond_11
    iget-object v3, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mInteractionIdCounter:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v3}, Ljava/util/concurrent/atomic/AtomicInteger;->getAndIncrement()I

    move-result v6

    .local v6, interactionId:I
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Thread;->getId()J

    move-result-wide v9

    move/from16 v3, p2

    move-wide/from16 v4, p3

    move-object v7, p0

    move/from16 v8, p5

    invoke-interface/range {v2 .. v10}, Landroid/accessibilityservice/IAccessibilityServiceConnection;->findAccessibilityNodeInfoByAccessibilityId(IJILandroid/view/accessibility/IAccessibilityInteractionConnectionCallback;IJ)F

    move-result v13

    .local v13, windowScale:F
    const/4 v3, 0x0

    cmpl-float v3, v13, v3

    if-lez v3, :cond_48

    invoke-direct {p0, v6}, Landroid/view/accessibility/AccessibilityInteractionClient;->getFindAccessibilityNodeInfosResultAndClear(I)Ljava/util/List;

    move-result-object v12

    .local v12, infos:Ljava/util/List;,"Ljava/util/List<Landroid/view/accessibility/AccessibilityNodeInfo;>;"
    invoke-direct {p0, v12, p1, v13}, Landroid/view/accessibility/AccessibilityInteractionClient;->finalizeAndCacheAccessibilityNodeInfos(Ljava/util/List;IF)V

    if-eqz v12, :cond_48

    invoke-interface {v12}, Ljava/util/List;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_48

    const/4 v3, 0x0

    invoke-interface {v12, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/view/accessibility/AccessibilityNodeInfo;
    :try_end_45
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_45} :catch_47

    move-object v11, v3

    goto :goto_10

    .end local v2           #connection:Landroid/accessibilityservice/IAccessibilityServiceConnection;
    .end local v6           #interactionId:I
    .end local v11           #cachedInfo:Landroid/view/accessibility/AccessibilityNodeInfo;
    .end local v12           #infos:Ljava/util/List;,"Ljava/util/List<Landroid/view/accessibility/AccessibilityNodeInfo;>;"
    .end local v13           #windowScale:F
    :catch_47
    move-exception v3

    :cond_48
    const/4 v11, 0x0

    goto :goto_10
.end method

.method public findAccessibilityNodeInfoByViewId(IIJI)Landroid/view/accessibility/AccessibilityNodeInfo;
    .registers 17
    .parameter "connectionId"
    .parameter "accessibilityWindowId"
    .parameter "accessibilityNodeId"
    .parameter "viewId"

    .prologue
    :try_start_0
    invoke-virtual {p0, p1}, Landroid/view/accessibility/AccessibilityInteractionClient;->getConnection(I)Landroid/accessibilityservice/IAccessibilityServiceConnection;

    move-result-object v0

    .local v0, connection:Landroid/accessibilityservice/IAccessibilityServiceConnection;
    if-eqz v0, :cond_2b

    iget-object v1, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mInteractionIdCounter:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicInteger;->getAndIncrement()I

    move-result v5

    .local v5, interactionId:I
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Thread;->getId()J

    move-result-wide v7

    move v1, p2

    move-wide v2, p3

    move/from16 v4, p5

    move-object v6, p0

    invoke-interface/range {v0 .. v8}, Landroid/accessibilityservice/IAccessibilityServiceConnection;->findAccessibilityNodeInfoByViewId(IJIILandroid/view/accessibility/IAccessibilityInteractionConnectionCallback;J)F

    move-result v10

    .local v10, windowScale:F
    const/4 v1, 0x0

    cmpl-float v1, v10, v1

    if-lez v1, :cond_2b

    invoke-direct {p0, v5}, Landroid/view/accessibility/AccessibilityInteractionClient;->getFindAccessibilityNodeInfoResultAndClear(I)Landroid/view/accessibility/AccessibilityNodeInfo;

    move-result-object v9

    .local v9, info:Landroid/view/accessibility/AccessibilityNodeInfo;
    invoke-direct {p0, v9, p1, v10}, Landroid/view/accessibility/AccessibilityInteractionClient;->finalizeAndCacheAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;IF)V
    :try_end_29
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_29} :catch_2a

    .end local v0           #connection:Landroid/accessibilityservice/IAccessibilityServiceConnection;
    .end local v5           #interactionId:I
    .end local v9           #info:Landroid/view/accessibility/AccessibilityNodeInfo;
    .end local v10           #windowScale:F
    :goto_29
    return-object v9

    :catch_2a
    move-exception v1

    :cond_2b
    const/4 v9, 0x0

    goto :goto_29
.end method

.method public findAccessibilityNodeInfosByText(IIJLjava/lang/String;)Ljava/util/List;
    .registers 17
    .parameter "connectionId"
    .parameter "accessibilityWindowId"
    .parameter "accessibilityNodeId"
    .parameter "text"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(IIJ",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Landroid/view/accessibility/AccessibilityNodeInfo;",
            ">;"
        }
    .end annotation

    .prologue
    :try_start_0
    invoke-virtual {p0, p1}, Landroid/view/accessibility/AccessibilityInteractionClient;->getConnection(I)Landroid/accessibilityservice/IAccessibilityServiceConnection;

    move-result-object v0

    .local v0, connection:Landroid/accessibilityservice/IAccessibilityServiceConnection;
    if-eqz v0, :cond_2b

    iget-object v1, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mInteractionIdCounter:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicInteger;->getAndIncrement()I

    move-result v5

    .local v5, interactionId:I
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Thread;->getId()J

    move-result-wide v7

    move v1, p2

    move-wide v2, p3

    move-object/from16 v4, p5

    move-object v6, p0

    invoke-interface/range {v0 .. v8}, Landroid/accessibilityservice/IAccessibilityServiceConnection;->findAccessibilityNodeInfosByText(IJLjava/lang/String;ILandroid/view/accessibility/IAccessibilityInteractionConnectionCallback;J)F

    move-result v10

    .local v10, windowScale:F
    const/4 v1, 0x0

    cmpl-float v1, v10, v1

    if-lez v1, :cond_2b

    invoke-direct {p0, v5}, Landroid/view/accessibility/AccessibilityInteractionClient;->getFindAccessibilityNodeInfosResultAndClear(I)Ljava/util/List;

    move-result-object v9

    .local v9, infos:Ljava/util/List;,"Ljava/util/List<Landroid/view/accessibility/AccessibilityNodeInfo;>;"
    invoke-direct {p0, v9, p1, v10}, Landroid/view/accessibility/AccessibilityInteractionClient;->finalizeAndCacheAccessibilityNodeInfos(Ljava/util/List;IF)V
    :try_end_29
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_29} :catch_2a

    .end local v0           #connection:Landroid/accessibilityservice/IAccessibilityServiceConnection;
    .end local v5           #interactionId:I
    .end local v9           #infos:Ljava/util/List;,"Ljava/util/List<Landroid/view/accessibility/AccessibilityNodeInfo;>;"
    .end local v10           #windowScale:F
    :goto_29
    return-object v9

    :catch_2a
    move-exception v1

    :cond_2b
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v9

    goto :goto_29
.end method

.method public findFocus(IIJI)Landroid/view/accessibility/AccessibilityNodeInfo;
    .registers 17
    .parameter "connectionId"
    .parameter "accessibilityWindowId"
    .parameter "accessibilityNodeId"
    .parameter "focusType"

    .prologue
    :try_start_0
    invoke-virtual {p0, p1}, Landroid/view/accessibility/AccessibilityInteractionClient;->getConnection(I)Landroid/accessibilityservice/IAccessibilityServiceConnection;

    move-result-object v0

    .local v0, connection:Landroid/accessibilityservice/IAccessibilityServiceConnection;
    if-eqz v0, :cond_2b

    iget-object v1, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mInteractionIdCounter:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicInteger;->getAndIncrement()I

    move-result v5

    .local v5, interactionId:I
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Thread;->getId()J

    move-result-wide v7

    move v1, p2

    move-wide v2, p3

    move/from16 v4, p5

    move-object v6, p0

    invoke-interface/range {v0 .. v8}, Landroid/accessibilityservice/IAccessibilityServiceConnection;->findFocus(IJIILandroid/view/accessibility/IAccessibilityInteractionConnectionCallback;J)F

    move-result v10

    .local v10, windowScale:F
    const/4 v1, 0x0

    cmpl-float v1, v10, v1

    if-lez v1, :cond_2b

    invoke-direct {p0, v5}, Landroid/view/accessibility/AccessibilityInteractionClient;->getFindAccessibilityNodeInfoResultAndClear(I)Landroid/view/accessibility/AccessibilityNodeInfo;

    move-result-object v9

    .local v9, info:Landroid/view/accessibility/AccessibilityNodeInfo;
    invoke-direct {p0, v9, p1, v10}, Landroid/view/accessibility/AccessibilityInteractionClient;->finalizeAndCacheAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;IF)V
    :try_end_29
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_29} :catch_2a

    .end local v0           #connection:Landroid/accessibilityservice/IAccessibilityServiceConnection;
    .end local v5           #interactionId:I
    .end local v9           #info:Landroid/view/accessibility/AccessibilityNodeInfo;
    .end local v10           #windowScale:F
    :goto_29
    return-object v9

    :catch_2a
    move-exception v1

    :cond_2b
    const/4 v9, 0x0

    goto :goto_29
.end method

.method public focusSearch(IIJI)Landroid/view/accessibility/AccessibilityNodeInfo;
    .registers 17
    .parameter "connectionId"
    .parameter "accessibilityWindowId"
    .parameter "accessibilityNodeId"
    .parameter "direction"

    .prologue
    :try_start_0
    invoke-virtual {p0, p1}, Landroid/view/accessibility/AccessibilityInteractionClient;->getConnection(I)Landroid/accessibilityservice/IAccessibilityServiceConnection;

    move-result-object v0

    .local v0, connection:Landroid/accessibilityservice/IAccessibilityServiceConnection;
    if-eqz v0, :cond_2b

    iget-object v1, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mInteractionIdCounter:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicInteger;->getAndIncrement()I

    move-result v5

    .local v5, interactionId:I
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Thread;->getId()J

    move-result-wide v7

    move v1, p2

    move-wide v2, p3

    move/from16 v4, p5

    move-object v6, p0

    invoke-interface/range {v0 .. v8}, Landroid/accessibilityservice/IAccessibilityServiceConnection;->focusSearch(IJIILandroid/view/accessibility/IAccessibilityInteractionConnectionCallback;J)F

    move-result v10

    .local v10, windowScale:F
    const/4 v1, 0x0

    cmpl-float v1, v10, v1

    if-lez v1, :cond_2b

    invoke-direct {p0, v5}, Landroid/view/accessibility/AccessibilityInteractionClient;->getFindAccessibilityNodeInfoResultAndClear(I)Landroid/view/accessibility/AccessibilityNodeInfo;

    move-result-object v9

    .local v9, info:Landroid/view/accessibility/AccessibilityNodeInfo;
    invoke-direct {p0, v9, p1, v10}, Landroid/view/accessibility/AccessibilityInteractionClient;->finalizeAndCacheAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;IF)V
    :try_end_29
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_29} :catch_2a

    .end local v0           #connection:Landroid/accessibilityservice/IAccessibilityServiceConnection;
    .end local v5           #interactionId:I
    .end local v9           #info:Landroid/view/accessibility/AccessibilityNodeInfo;
    .end local v10           #windowScale:F
    :goto_29
    return-object v9

    :catch_2a
    move-exception v1

    :cond_2b
    const/4 v9, 0x0

    goto :goto_29
.end method

.method public getConnection(I)Landroid/accessibilityservice/IAccessibilityServiceConnection;
    .registers 4
    .parameter "connectionId"

    .prologue
    sget-object v1, Landroid/view/accessibility/AccessibilityInteractionClient;->sConnectionCache:Landroid/util/SparseArray;

    monitor-enter v1

    :try_start_3
    sget-object v0, Landroid/view/accessibility/AccessibilityInteractionClient;->sConnectionCache:Landroid/util/SparseArray;

    invoke-virtual {v0, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/accessibilityservice/IAccessibilityServiceConnection;

    monitor-exit v1

    return-object v0

    :catchall_d
    move-exception v0

    monitor-exit v1
    :try_end_f
    .catchall {:try_start_3 .. :try_end_f} :catchall_d

    throw v0
.end method

.method public getRootInActiveWindow(I)Landroid/view/accessibility/AccessibilityNodeInfo;
    .registers 8
    .parameter "connectionId"

    .prologue
    const/4 v2, -0x1

    sget-wide v3, Landroid/view/accessibility/AccessibilityNodeInfo;->ROOT_NODE_ID:J

    const/4 v5, 0x4

    move-object v0, p0

    move v1, p1

    invoke-virtual/range {v0 .. v5}, Landroid/view/accessibility/AccessibilityInteractionClient;->findAccessibilityNodeInfoByAccessibilityId(IIJI)Landroid/view/accessibility/AccessibilityNodeInfo;

    move-result-object v0

    return-object v0
.end method

.method public onAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V
    .registers 3
    .parameter "event"

    .prologue
    sget-object v0, Landroid/view/accessibility/AccessibilityInteractionClient;->sAccessibilityNodeInfoCache:Landroid/view/accessibility/AccessibilityNodeInfoCache;

    invoke-virtual {v0, p1}, Landroid/view/accessibility/AccessibilityNodeInfoCache;->onAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V

    return-void
.end method

.method public performAccessibilityAction(IIJILandroid/os/Bundle;)Z
    .registers 18
    .parameter "connectionId"
    .parameter "accessibilityWindowId"
    .parameter "accessibilityNodeId"
    .parameter "action"
    .parameter "arguments"

    .prologue
    :try_start_0
    invoke-virtual {p0, p1}, Landroid/view/accessibility/AccessibilityInteractionClient;->getConnection(I)Landroid/accessibilityservice/IAccessibilityServiceConnection;

    move-result-object v0

    .local v0, connection:Landroid/accessibilityservice/IAccessibilityServiceConnection;
    if-eqz v0, :cond_27

    iget-object v1, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mInteractionIdCounter:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicInteger;->getAndIncrement()I

    move-result v6

    .local v6, interactionId:I
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Thread;->getId()J

    move-result-wide v8

    move v1, p2

    move-wide v2, p3

    move/from16 v4, p5

    move-object/from16 v5, p6

    move-object v7, p0

    invoke-interface/range {v0 .. v9}, Landroid/accessibilityservice/IAccessibilityServiceConnection;->performAccessibilityAction(IJILandroid/os/Bundle;ILandroid/view/accessibility/IAccessibilityInteractionConnectionCallback;J)Z

    move-result v10

    .local v10, success:Z
    if-eqz v10, :cond_27

    invoke-direct {p0, v6}, Landroid/view/accessibility/AccessibilityInteractionClient;->getPerformAccessibilityActionResultAndClear(I)Z
    :try_end_24
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_24} :catch_26

    move-result v1

    .end local v0           #connection:Landroid/accessibilityservice/IAccessibilityServiceConnection;
    .end local v6           #interactionId:I
    .end local v10           #success:Z
    :goto_25
    return v1

    :catch_26
    move-exception v1

    :cond_27
    const/4 v1, 0x0

    goto :goto_25
.end method

.method public removeConnection(I)V
    .registers 4
    .parameter "connectionId"

    .prologue
    sget-object v1, Landroid/view/accessibility/AccessibilityInteractionClient;->sConnectionCache:Landroid/util/SparseArray;

    monitor-enter v1

    :try_start_3
    sget-object v0, Landroid/view/accessibility/AccessibilityInteractionClient;->sConnectionCache:Landroid/util/SparseArray;

    invoke-virtual {v0, p1}, Landroid/util/SparseArray;->remove(I)V

    monitor-exit v1

    return-void

    :catchall_a
    move-exception v0

    monitor-exit v1
    :try_end_c
    .catchall {:try_start_3 .. :try_end_c} :catchall_a

    throw v0
.end method

.method public setFindAccessibilityNodeInfoResult(Landroid/view/accessibility/AccessibilityNodeInfo;I)V
    .registers 5
    .parameter "info"
    .parameter "interactionId"

    .prologue
    iget-object v1, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mInstanceLock:Ljava/lang/Object;

    monitor-enter v1

    :try_start_3
    iget v0, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mInteractionId:I

    if-le p2, v0, :cond_b

    iput-object p1, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mFindAccessibilityNodeInfoResult:Landroid/view/accessibility/AccessibilityNodeInfo;

    iput p2, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mInteractionId:I

    :cond_b
    iget-object v0, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mInstanceLock:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->notifyAll()V

    monitor-exit v1

    return-void

    :catchall_12
    move-exception v0

    monitor-exit v1
    :try_end_14
    .catchall {:try_start_3 .. :try_end_14} :catchall_12

    throw v0
.end method

.method public setFindAccessibilityNodeInfosResult(Ljava/util/List;I)V
    .registers 7
    .parameter
    .parameter "interactionId"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Landroid/view/accessibility/AccessibilityNodeInfo;",
            ">;I)V"
        }
    .end annotation

    .prologue
    .local p1, infos:Ljava/util/List;,"Ljava/util/List<Landroid/view/accessibility/AccessibilityNodeInfo;>;"
    iget-object v2, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mInstanceLock:Ljava/lang/Object;

    monitor-enter v2

    :try_start_3
    iget v1, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mInteractionId:I

    if-le p2, v1, :cond_1f

    if-eqz p1, :cond_2e

    invoke-static {}, Landroid/os/Binder;->getCallingPid()I

    move-result v1

    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v3

    if-eq v1, v3, :cond_26

    const/4 v0, 0x1

    .local v0, isIpcCall:Z
    :goto_14
    if-nez v0, :cond_28

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1, p1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v1, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mFindAccessibilityNodeInfosResult:Ljava/util/List;

    .end local v0           #isIpcCall:Z
    :goto_1d
    iput p2, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mInteractionId:I

    :cond_1f
    iget-object v1, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mInstanceLock:Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/lang/Object;->notifyAll()V

    monitor-exit v2

    return-void

    :cond_26
    const/4 v0, 0x0

    goto :goto_14

    .restart local v0       #isIpcCall:Z
    :cond_28
    iput-object p1, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mFindAccessibilityNodeInfosResult:Ljava/util/List;

    goto :goto_1d

    .end local v0           #isIpcCall:Z
    :catchall_2b
    move-exception v1

    monitor-exit v2
    :try_end_2d
    .catchall {:try_start_3 .. :try_end_2d} :catchall_2b

    throw v1

    :cond_2e
    :try_start_2e
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v1

    iput-object v1, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mFindAccessibilityNodeInfosResult:Ljava/util/List;
    :try_end_34
    .catchall {:try_start_2e .. :try_end_34} :catchall_2b

    goto :goto_1d
.end method

.method public setPerformAccessibilityActionResult(ZI)V
    .registers 5
    .parameter "succeeded"
    .parameter "interactionId"

    .prologue
    iget-object v1, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mInstanceLock:Ljava/lang/Object;

    monitor-enter v1

    :try_start_3
    iget v0, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mInteractionId:I

    if-le p2, v0, :cond_b

    iput-boolean p1, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mPerformAccessibilityActionResult:Z

    iput p2, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mInteractionId:I

    :cond_b
    iget-object v0, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mInstanceLock:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->notifyAll()V

    monitor-exit v1

    return-void

    :catchall_12
    move-exception v0

    monitor-exit v1
    :try_end_14
    .catchall {:try_start_3 .. :try_end_14} :catchall_12

    throw v0
.end method

.method public setSameThreadMessage(Landroid/os/Message;)V
    .registers 4
    .parameter "message"

    .prologue
    iget-object v1, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mInstanceLock:Ljava/lang/Object;

    monitor-enter v1

    :try_start_3
    iput-object p1, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mSameThreadMessage:Landroid/os/Message;

    iget-object v0, p0, Landroid/view/accessibility/AccessibilityInteractionClient;->mInstanceLock:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->notifyAll()V

    monitor-exit v1

    return-void

    :catchall_c
    move-exception v0

    monitor-exit v1
    :try_end_e
    .catchall {:try_start_3 .. :try_end_e} :catchall_c

    throw v0
.end method
