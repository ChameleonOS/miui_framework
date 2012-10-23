.class public Landroid/view/accessibility/AccessibilityNodeInfoCache;
.super Ljava/lang/Object;
.source "AccessibilityNodeInfoCache.java"


# static fields
.field private static final CHECK_INTEGRITY:Z = true

.field private static final DEBUG:Z = false

.field private static final ENABLED:Z = true

.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private final mCacheImpl:Landroid/util/LongSparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/LongSparseArray",
            "<",
            "Landroid/view/accessibility/AccessibilityNodeInfo;",
            ">;"
        }
    .end annotation
.end field

.field private final mLock:Ljava/lang/Object;

.field private mWindowId:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 38
    const-class v0, Landroid/view/accessibility/AccessibilityNodeInfoCache;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Landroid/view/accessibility/AccessibilityNodeInfoCache;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .registers 2

    .prologue
    .line 52
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 46
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Landroid/view/accessibility/AccessibilityNodeInfoCache;->mLock:Ljava/lang/Object;

    .line 54
    new-instance v0, Landroid/util/LongSparseArray;

    invoke-direct {v0}, Landroid/util/LongSparseArray;-><init>()V

    iput-object v0, p0, Landroid/view/accessibility/AccessibilityNodeInfoCache;->mCacheImpl:Landroid/util/LongSparseArray;

    .line 58
    return-void
.end method

.method private checkIntegrity()V
    .registers 24

    .prologue
    .line 268
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/accessibility/AccessibilityNodeInfoCache;->mLock:Ljava/lang/Object;

    move-object/from16 v20, v0

    monitor-enter v20

    .line 270
    :try_start_7
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/accessibility/AccessibilityNodeInfoCache;->mCacheImpl:Landroid/util/LongSparseArray;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Landroid/util/LongSparseArray;->size()I

    move-result v19

    if-gtz v19, :cond_15

    .line 271
    monitor-exit v20

    .line 342
    :goto_14
    return-void

    .line 276
    :cond_15
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/accessibility/AccessibilityNodeInfoCache;->mCacheImpl:Landroid/util/LongSparseArray;

    move-object/from16 v19, v0

    const/16 v21, 0x0

    move-object/from16 v0, v19

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Landroid/util/LongSparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Landroid/view/accessibility/AccessibilityNodeInfo;

    .line 277
    .local v16, root:Landroid/view/accessibility/AccessibilityNodeInfo;
    move-object/from16 v15, v16

    .line 278
    .local v15, parent:Landroid/view/accessibility/AccessibilityNodeInfo;
    :goto_29
    if-eqz v15, :cond_42

    .line 279
    move-object/from16 v16, v15

    .line 280
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/accessibility/AccessibilityNodeInfoCache;->mCacheImpl:Landroid/util/LongSparseArray;

    move-object/from16 v19, v0

    invoke-virtual {v15}, Landroid/view/accessibility/AccessibilityNodeInfo;->getParentNodeId()J

    move-result-wide v21

    move-object/from16 v0, v19

    move-wide/from16 v1, v21

    invoke-virtual {v0, v1, v2}, Landroid/util/LongSparseArray;->get(J)Ljava/lang/Object;

    move-result-object v15

    .end local v15           #parent:Landroid/view/accessibility/AccessibilityNodeInfo;
    check-cast v15, Landroid/view/accessibility/AccessibilityNodeInfo;

    .restart local v15       #parent:Landroid/view/accessibility/AccessibilityNodeInfo;
    goto :goto_29

    .line 284
    :cond_42
    invoke-virtual/range {v16 .. v16}, Landroid/view/accessibility/AccessibilityNodeInfo;->getWindowId()I

    move-result v18

    .line 285
    .local v18, windowId:I
    const/4 v3, 0x0

    .line 286
    .local v3, accessFocus:Landroid/view/accessibility/AccessibilityNodeInfo;
    const/4 v14, 0x0

    .line 287
    .local v14, inputFocus:Landroid/view/accessibility/AccessibilityNodeInfo;
    new-instance v17, Ljava/util/HashSet;

    invoke-direct/range {v17 .. v17}, Ljava/util/HashSet;-><init>()V

    .line 288
    .local v17, seen:Ljava/util/HashSet;,"Ljava/util/HashSet<Landroid/view/accessibility/AccessibilityNodeInfo;>;"
    new-instance v11, Ljava/util/LinkedList;

    invoke-direct {v11}, Ljava/util/LinkedList;-><init>()V

    .line 289
    .local v11, fringe:Ljava/util/Queue;,"Ljava/util/Queue<Landroid/view/accessibility/AccessibilityNodeInfo;>;"
    move-object/from16 v0, v16

    invoke-interface {v11, v0}, Ljava/util/Queue;->add(Ljava/lang/Object;)Z

    .line 291
    :cond_57
    invoke-interface {v11}, Ljava/util/Queue;->isEmpty()Z

    move-result v19

    if-nez v19, :cond_103

    .line 292
    invoke-interface {v11}, Ljava/util/Queue;->poll()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Landroid/view/accessibility/AccessibilityNodeInfo;

    .line 294
    .local v10, current:Landroid/view/accessibility/AccessibilityNodeInfo;
    move-object/from16 v0, v17

    invoke-virtual {v0, v10}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    move-result v19

    if-nez v19, :cond_8e

    .line 295
    sget-object v19, Landroid/view/accessibility/AccessibilityNodeInfoCache;->LOG_TAG:Ljava/lang/String;

    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "Duplicate node: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v19

    move-object/from16 v1, v21

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 296
    monitor-exit v20

    goto :goto_14

    .line 341
    .end local v3           #accessFocus:Landroid/view/accessibility/AccessibilityNodeInfo;
    .end local v10           #current:Landroid/view/accessibility/AccessibilityNodeInfo;
    .end local v11           #fringe:Ljava/util/Queue;,"Ljava/util/Queue<Landroid/view/accessibility/AccessibilityNodeInfo;>;"
    .end local v14           #inputFocus:Landroid/view/accessibility/AccessibilityNodeInfo;
    .end local v15           #parent:Landroid/view/accessibility/AccessibilityNodeInfo;
    .end local v16           #root:Landroid/view/accessibility/AccessibilityNodeInfo;
    .end local v17           #seen:Ljava/util/HashSet;,"Ljava/util/HashSet<Landroid/view/accessibility/AccessibilityNodeInfo;>;"
    .end local v18           #windowId:I
    :catchall_8b
    move-exception v19

    monitor-exit v20
    :try_end_8d
    .catchall {:try_start_7 .. :try_end_8d} :catchall_8b

    throw v19

    .line 300
    .restart local v3       #accessFocus:Landroid/view/accessibility/AccessibilityNodeInfo;
    .restart local v10       #current:Landroid/view/accessibility/AccessibilityNodeInfo;
    .restart local v11       #fringe:Ljava/util/Queue;,"Ljava/util/Queue<Landroid/view/accessibility/AccessibilityNodeInfo;>;"
    .restart local v14       #inputFocus:Landroid/view/accessibility/AccessibilityNodeInfo;
    .restart local v15       #parent:Landroid/view/accessibility/AccessibilityNodeInfo;
    .restart local v16       #root:Landroid/view/accessibility/AccessibilityNodeInfo;
    .restart local v17       #seen:Ljava/util/HashSet;,"Ljava/util/HashSet<Landroid/view/accessibility/AccessibilityNodeInfo;>;"
    .restart local v18       #windowId:I
    :cond_8e
    :try_start_8e
    invoke-virtual {v10}, Landroid/view/accessibility/AccessibilityNodeInfo;->isAccessibilityFocused()Z

    move-result v19

    if-eqz v19, :cond_b4

    .line 301
    if-eqz v3, :cond_ff

    .line 302
    sget-object v19, Landroid/view/accessibility/AccessibilityNodeInfoCache;->LOG_TAG:Ljava/lang/String;

    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "Duplicate accessibility focus:"

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v19

    move-object/from16 v1, v21

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 309
    :cond_b4
    :goto_b4
    invoke-virtual {v10}, Landroid/view/accessibility/AccessibilityNodeInfo;->isFocused()Z

    move-result v19

    if-eqz v19, :cond_da

    .line 310
    if-eqz v14, :cond_101

    .line 311
    sget-object v19, Landroid/view/accessibility/AccessibilityNodeInfoCache;->LOG_TAG:Ljava/lang/String;

    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "Duplicate input focus: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v19

    move-object/from16 v1, v21

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 317
    :cond_da
    :goto_da
    invoke-virtual {v10}, Landroid/view/accessibility/AccessibilityNodeInfo;->getChildNodeIds()Landroid/util/SparseLongArray;

    move-result-object v9

    .line 318
    .local v9, childIds:Landroid/util/SparseLongArray;
    invoke-virtual {v9}, Landroid/util/SparseLongArray;->size()I

    move-result v6

    .line 319
    .local v6, childCount:I
    const/4 v12, 0x0

    .local v12, i:I
    :goto_e3
    if-ge v12, v6, :cond_57

    .line 320
    invoke-virtual {v9, v12}, Landroid/util/SparseLongArray;->valueAt(I)J

    move-result-wide v7

    .line 321
    .local v7, childId:J
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/accessibility/AccessibilityNodeInfoCache;->mCacheImpl:Landroid/util/LongSparseArray;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    invoke-virtual {v0, v7, v8}, Landroid/util/LongSparseArray;->get(J)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/view/accessibility/AccessibilityNodeInfo;

    .line 322
    .local v5, child:Landroid/view/accessibility/AccessibilityNodeInfo;
    if-eqz v5, :cond_fc

    .line 323
    invoke-interface {v11, v5}, Ljava/util/Queue;->add(Ljava/lang/Object;)Z

    .line 319
    :cond_fc
    add-int/lit8 v12, v12, 0x1

    goto :goto_e3

    .line 304
    .end local v5           #child:Landroid/view/accessibility/AccessibilityNodeInfo;
    .end local v6           #childCount:I
    .end local v7           #childId:J
    .end local v9           #childIds:Landroid/util/SparseLongArray;
    .end local v12           #i:I
    :cond_ff
    move-object v3, v10

    goto :goto_b4

    .line 313
    :cond_101
    move-object v14, v10

    goto :goto_da

    .line 329
    .end local v10           #current:Landroid/view/accessibility/AccessibilityNodeInfo;
    :cond_103
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/accessibility/AccessibilityNodeInfoCache;->mCacheImpl:Landroid/util/LongSparseArray;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Landroid/util/LongSparseArray;->size()I

    move-result v4

    .line 330
    .local v4, cacheSize:I
    const/4 v12, 0x0

    .restart local v12       #i:I
    :goto_10e
    if-ge v12, v4, :cond_179

    .line 331
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/accessibility/AccessibilityNodeInfoCache;->mCacheImpl:Landroid/util/LongSparseArray;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    invoke-virtual {v0, v12}, Landroid/util/LongSparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Landroid/view/accessibility/AccessibilityNodeInfo;

    .line 332
    .local v13, info:Landroid/view/accessibility/AccessibilityNodeInfo;
    move-object/from16 v0, v17

    invoke-virtual {v0, v13}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v19

    if-nez v19, :cond_13b

    .line 333
    invoke-virtual {v13}, Landroid/view/accessibility/AccessibilityNodeInfo;->getWindowId()I

    move-result v19

    move/from16 v0, v19

    move/from16 v1, v18

    if-ne v0, v1, :cond_13e

    .line 334
    sget-object v19, Landroid/view/accessibility/AccessibilityNodeInfoCache;->LOG_TAG:Ljava/lang/String;

    const-string v21, "Disconneced node: "

    move-object/from16 v0, v19

    move-object/from16 v1, v21

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 330
    :cond_13b
    :goto_13b
    add-int/lit8 v12, v12, 0x1

    goto :goto_10e

    .line 336
    :cond_13e
    sget-object v19, Landroid/view/accessibility/AccessibilityNodeInfoCache;->LOG_TAG:Ljava/lang/String;

    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "Node from: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual {v13}, Landroid/view/accessibility/AccessibilityNodeInfo;->getWindowId()I

    move-result v22

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v21

    const-string v22, " not from:"

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    move-object/from16 v0, v21

    move/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v21

    const-string v22, " "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v0, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v19

    move-object/from16 v1, v21

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_13b

    .line 341
    .end local v13           #info:Landroid/view/accessibility/AccessibilityNodeInfo;
    :cond_179
    monitor-exit v20
    :try_end_17a
    .catchall {:try_start_8e .. :try_end_17a} :catchall_8b

    goto/16 :goto_14
.end method

.method private clearSubTreeLocked(J)V
    .registers 10
    .parameter "rootNodeId"

    .prologue
    .line 214
    iget-object v6, p0, Landroid/view/accessibility/AccessibilityNodeInfoCache;->mCacheImpl:Landroid/util/LongSparseArray;

    invoke-virtual {v6, p1, p2}, Landroid/util/LongSparseArray;->get(J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/view/accessibility/AccessibilityNodeInfo;

    .line 215
    .local v4, current:Landroid/view/accessibility/AccessibilityNodeInfo;
    if-nez v4, :cond_b

    .line 225
    :cond_a
    return-void

    .line 218
    :cond_b
    iget-object v6, p0, Landroid/view/accessibility/AccessibilityNodeInfoCache;->mCacheImpl:Landroid/util/LongSparseArray;

    invoke-virtual {v6, p1, p2}, Landroid/util/LongSparseArray;->remove(J)V

    .line 219
    invoke-virtual {v4}, Landroid/view/accessibility/AccessibilityNodeInfo;->getChildNodeIds()Landroid/util/SparseLongArray;

    move-result-object v3

    .line 220
    .local v3, childNodeIds:Landroid/util/SparseLongArray;
    invoke-virtual {v3}, Landroid/util/SparseLongArray;->size()I

    move-result v0

    .line 221
    .local v0, childCount:I
    const/4 v5, 0x0

    .local v5, i:I
    :goto_19
    if-ge v5, v0, :cond_a

    .line 222
    invoke-virtual {v3, v5}, Landroid/util/SparseLongArray;->valueAt(I)J

    move-result-wide v1

    .line 223
    .local v1, childNodeId:J
    invoke-direct {p0, v1, v2}, Landroid/view/accessibility/AccessibilityNodeInfoCache;->clearSubTreeLocked(J)V

    .line 221
    add-int/lit8 v5, v5, 0x1

    goto :goto_19
.end method

.method private clearSubtreeWithOldAccessibilityFocusLocked(J)V
    .registers 9
    .parameter "currentAccessibilityFocusId"

    .prologue
    .line 250
    iget-object v5, p0, Landroid/view/accessibility/AccessibilityNodeInfoCache;->mCacheImpl:Landroid/util/LongSparseArray;

    invoke-virtual {v5}, Landroid/util/LongSparseArray;->size()I

    move-result v0

    .line 251
    .local v0, cacheSize:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_7
    if-ge v1, v0, :cond_22

    .line 252
    iget-object v5, p0, Landroid/view/accessibility/AccessibilityNodeInfoCache;->mCacheImpl:Landroid/util/LongSparseArray;

    invoke-virtual {v5, v1}, Landroid/util/LongSparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/view/accessibility/AccessibilityNodeInfo;

    .line 253
    .local v2, info:Landroid/view/accessibility/AccessibilityNodeInfo;
    invoke-virtual {v2}, Landroid/view/accessibility/AccessibilityNodeInfo;->getSourceNodeId()J

    move-result-wide v3

    .line 254
    .local v3, infoSourceId:J
    cmp-long v5, v3, p1

    if-eqz v5, :cond_23

    invoke-virtual {v2}, Landroid/view/accessibility/AccessibilityNodeInfo;->isAccessibilityFocused()Z

    move-result v5

    if-eqz v5, :cond_23

    .line 255
    invoke-direct {p0, v3, v4}, Landroid/view/accessibility/AccessibilityNodeInfoCache;->clearSubTreeLocked(J)V

    .line 259
    .end local v2           #info:Landroid/view/accessibility/AccessibilityNodeInfo;
    .end local v3           #infoSourceId:J
    :cond_22
    return-void

    .line 251
    .restart local v2       #info:Landroid/view/accessibility/AccessibilityNodeInfo;
    .restart local v3       #infoSourceId:J
    :cond_23
    add-int/lit8 v1, v1, 0x1

    goto :goto_7
.end method

.method private clearSubtreeWithOldInputFocusLocked(J)V
    .registers 9
    .parameter "currentInputFocusId"

    .prologue
    .line 233
    iget-object v5, p0, Landroid/view/accessibility/AccessibilityNodeInfoCache;->mCacheImpl:Landroid/util/LongSparseArray;

    invoke-virtual {v5}, Landroid/util/LongSparseArray;->size()I

    move-result v0

    .line 234
    .local v0, cacheSize:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_7
    if-ge v1, v0, :cond_22

    .line 235
    iget-object v5, p0, Landroid/view/accessibility/AccessibilityNodeInfoCache;->mCacheImpl:Landroid/util/LongSparseArray;

    invoke-virtual {v5, v1}, Landroid/util/LongSparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/view/accessibility/AccessibilityNodeInfo;

    .line 236
    .local v2, info:Landroid/view/accessibility/AccessibilityNodeInfo;
    invoke-virtual {v2}, Landroid/view/accessibility/AccessibilityNodeInfo;->getSourceNodeId()J

    move-result-wide v3

    .line 237
    .local v3, infoSourceId:J
    cmp-long v5, v3, p1

    if-eqz v5, :cond_23

    invoke-virtual {v2}, Landroid/view/accessibility/AccessibilityNodeInfo;->isFocused()Z

    move-result v5

    if-eqz v5, :cond_23

    .line 238
    invoke-direct {p0, v3, v4}, Landroid/view/accessibility/AccessibilityNodeInfoCache;->clearSubTreeLocked(J)V

    .line 242
    .end local v2           #info:Landroid/view/accessibility/AccessibilityNodeInfo;
    .end local v3           #infoSourceId:J
    :cond_22
    return-void

    .line 234
    .restart local v2       #info:Landroid/view/accessibility/AccessibilityNodeInfo;
    .restart local v3       #infoSourceId:J
    :cond_23
    add-int/lit8 v1, v1, 0x1

    goto :goto_7
.end method


# virtual methods
.method public add(Landroid/view/accessibility/AccessibilityNodeInfo;)V
    .registers 19
    .parameter "info"

    .prologue
    .line 149
    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/view/accessibility/AccessibilityNodeInfoCache;->mLock:Ljava/lang/Object;

    monitor-enter v14

    .line 154
    :try_start_5
    invoke-virtual/range {p1 .. p1}, Landroid/view/accessibility/AccessibilityNodeInfo;->getSourceNodeId()J

    move-result-wide v11

    .line 155
    .local v11, sourceId:J
    move-object/from16 v0, p0

    iget-object v13, v0, Landroid/view/accessibility/AccessibilityNodeInfoCache;->mCacheImpl:Landroid/util/LongSparseArray;

    invoke-virtual {v13, v11, v12}, Landroid/util/LongSparseArray;->get(J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/view/accessibility/AccessibilityNodeInfo;

    .line 156
    .local v8, oldInfo:Landroid/view/accessibility/AccessibilityNodeInfo;
    if-eqz v8, :cond_47

    .line 161
    invoke-virtual {v8}, Landroid/view/accessibility/AccessibilityNodeInfo;->getChildNodeIds()Landroid/util/SparseLongArray;

    move-result-object v7

    .line 162
    .local v7, oldChildrenIds:Landroid/util/SparseLongArray;
    invoke-virtual/range {p1 .. p1}, Landroid/view/accessibility/AccessibilityNodeInfo;->getChildNodeIds()Landroid/util/SparseLongArray;

    move-result-object v3

    .line 163
    .local v3, newChildrenIds:Landroid/util/SparseLongArray;
    invoke-virtual {v7}, Landroid/util/SparseLongArray;->size()I

    move-result v4

    .line 164
    .local v4, oldChildCount:I
    const/4 v2, 0x0

    .local v2, i:I
    :goto_22
    if-ge v2, v4, :cond_36

    .line 165
    invoke-virtual {v7, v2}, Landroid/util/SparseLongArray;->valueAt(I)J

    move-result-wide v5

    .line 166
    .local v5, oldChildId:J
    invoke-virtual {v3, v5, v6}, Landroid/util/SparseLongArray;->indexOfValue(J)I

    move-result v13

    if-gez v13, :cond_33

    .line 167
    move-object/from16 v0, p0

    invoke-direct {v0, v5, v6}, Landroid/view/accessibility/AccessibilityNodeInfoCache;->clearSubTreeLocked(J)V

    .line 164
    :cond_33
    add-int/lit8 v2, v2, 0x1

    goto :goto_22

    .line 174
    .end local v5           #oldChildId:J
    :cond_36
    invoke-virtual {v8}, Landroid/view/accessibility/AccessibilityNodeInfo;->getParentNodeId()J

    move-result-wide v9

    .line 175
    .local v9, oldParentId:J
    invoke-virtual/range {p1 .. p1}, Landroid/view/accessibility/AccessibilityNodeInfo;->getParentNodeId()J

    move-result-wide v15

    cmp-long v13, v15, v9

    if-eqz v13, :cond_47

    .line 176
    move-object/from16 v0, p0

    invoke-direct {v0, v9, v10}, Landroid/view/accessibility/AccessibilityNodeInfoCache;->clearSubTreeLocked(J)V

    .line 182
    .end local v2           #i:I
    .end local v3           #newChildrenIds:Landroid/util/SparseLongArray;
    .end local v4           #oldChildCount:I
    .end local v7           #oldChildrenIds:Landroid/util/SparseLongArray;
    .end local v9           #oldParentId:J
    :cond_47
    invoke-static/range {p1 .. p1}, Landroid/view/accessibility/AccessibilityNodeInfo;->obtain(Landroid/view/accessibility/AccessibilityNodeInfo;)Landroid/view/accessibility/AccessibilityNodeInfo;

    move-result-object v1

    .line 183
    .local v1, clone:Landroid/view/accessibility/AccessibilityNodeInfo;
    move-object/from16 v0, p0

    iget-object v13, v0, Landroid/view/accessibility/AccessibilityNodeInfoCache;->mCacheImpl:Landroid/util/LongSparseArray;

    invoke-virtual {v13, v11, v12, v1}, Landroid/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 184
    monitor-exit v14

    .line 186
    return-void

    .line 184
    .end local v1           #clone:Landroid/view/accessibility/AccessibilityNodeInfo;
    .end local v8           #oldInfo:Landroid/view/accessibility/AccessibilityNodeInfo;
    .end local v11           #sourceId:J
    :catchall_54
    move-exception v13

    monitor-exit v14
    :try_end_56
    .catchall {:try_start_5 .. :try_end_56} :catchall_54

    throw v13
.end method

.method public clear()V
    .registers 6

    .prologue
    .line 193
    iget-object v4, p0, Landroid/view/accessibility/AccessibilityNodeInfoCache;->mLock:Ljava/lang/Object;

    monitor-enter v4

    .line 198
    :try_start_3
    iget-object v3, p0, Landroid/view/accessibility/AccessibilityNodeInfoCache;->mCacheImpl:Landroid/util/LongSparseArray;

    invoke-virtual {v3}, Landroid/util/LongSparseArray;->size()I

    move-result v2

    .line 199
    .local v2, nodeCount:I
    const/4 v0, 0x0

    .local v0, i:I
    :goto_a
    if-ge v0, v2, :cond_1a

    .line 200
    iget-object v3, p0, Landroid/view/accessibility/AccessibilityNodeInfoCache;->mCacheImpl:Landroid/util/LongSparseArray;

    invoke-virtual {v3, v0}, Landroid/util/LongSparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/accessibility/AccessibilityNodeInfo;

    .line 201
    .local v1, info:Landroid/view/accessibility/AccessibilityNodeInfo;
    invoke-virtual {v1}, Landroid/view/accessibility/AccessibilityNodeInfo;->recycle()V

    .line 199
    add-int/lit8 v0, v0, 0x1

    goto :goto_a

    .line 203
    .end local v1           #info:Landroid/view/accessibility/AccessibilityNodeInfo;
    :cond_1a
    iget-object v3, p0, Landroid/view/accessibility/AccessibilityNodeInfoCache;->mCacheImpl:Landroid/util/LongSparseArray;

    invoke-virtual {v3}, Landroid/util/LongSparseArray;->clear()V

    .line 204
    monitor-exit v4

    .line 206
    return-void

    .line 204
    .end local v0           #i:I
    .end local v2           #nodeCount:I
    :catchall_21
    move-exception v3

    monitor-exit v4
    :try_end_23
    .catchall {:try_start_3 .. :try_end_23} :catchall_21

    throw v3
.end method

.method public get(J)Landroid/view/accessibility/AccessibilityNodeInfo;
    .registers 6
    .parameter "accessibilityNodeId"

    .prologue
    .line 125
    iget-object v2, p0, Landroid/view/accessibility/AccessibilityNodeInfoCache;->mLock:Ljava/lang/Object;

    monitor-enter v2

    .line 126
    :try_start_3
    iget-object v1, p0, Landroid/view/accessibility/AccessibilityNodeInfoCache;->mCacheImpl:Landroid/util/LongSparseArray;

    invoke-virtual {v1, p1, p2}, Landroid/util/LongSparseArray;->get(J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/accessibility/AccessibilityNodeInfo;

    .line 127
    .local v0, info:Landroid/view/accessibility/AccessibilityNodeInfo;
    if-eqz v0, :cond_11

    .line 130
    invoke-static {v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->obtain(Landroid/view/accessibility/AccessibilityNodeInfo;)Landroid/view/accessibility/AccessibilityNodeInfo;

    move-result-object v0

    .line 135
    :cond_11
    monitor-exit v2

    return-object v0

    .line 136
    .end local v0           #info:Landroid/view/accessibility/AccessibilityNodeInfo;
    :catchall_13
    move-exception v1

    monitor-exit v2
    :try_end_15
    .catchall {:try_start_3 .. :try_end_15} :catchall_13

    throw v1
.end method

.method public onAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V
    .registers 10
    .parameter "event"

    .prologue
    .line 68
    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityEvent;->getEventType()I

    move-result v2

    .line 69
    .local v2, eventType:I
    sparse-switch v2, :sswitch_data_54

    .line 111
    :cond_7
    :goto_7
    sget-boolean v6, Landroid/os/Build;->IS_DEBUGGABLE:Z

    if-eqz v6, :cond_e

    .line 112
    invoke-direct {p0}, Landroid/view/accessibility/AccessibilityNodeInfoCache;->checkIntegrity()V

    .line 115
    :cond_e
    return-void

    .line 72
    :sswitch_f
    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityEvent;->getWindowId()I

    move-result v6

    iput v6, p0, Landroid/view/accessibility/AccessibilityNodeInfoCache;->mWindowId:I

    .line 73
    invoke-virtual {p0}, Landroid/view/accessibility/AccessibilityNodeInfoCache;->clear()V

    goto :goto_7

    .line 77
    :sswitch_19
    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityEvent;->getWindowId()I

    move-result v5

    .line 78
    .local v5, windowId:I
    iget v6, p0, Landroid/view/accessibility/AccessibilityNodeInfoCache;->mWindowId:I

    if-eq v6, v5, :cond_7

    .line 80
    iput v5, p0, Landroid/view/accessibility/AccessibilityNodeInfoCache;->mWindowId:I

    .line 81
    invoke-virtual {p0}, Landroid/view/accessibility/AccessibilityNodeInfoCache;->clear()V

    goto :goto_7

    .line 92
    .end local v5           #windowId:I
    :sswitch_27
    iget-object v7, p0, Landroid/view/accessibility/AccessibilityNodeInfoCache;->mLock:Ljava/lang/Object;

    monitor-enter v7

    .line 93
    :try_start_2a
    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityEvent;->getSourceNodeId()J

    move-result-wide v3

    .line 94
    .local v3, sourceId:J
    invoke-direct {p0, v3, v4}, Landroid/view/accessibility/AccessibilityNodeInfoCache;->clearSubTreeLocked(J)V

    .line 95
    const/16 v6, 0x8

    if-ne v2, v6, :cond_38

    .line 96
    invoke-direct {p0, v3, v4}, Landroid/view/accessibility/AccessibilityNodeInfoCache;->clearSubtreeWithOldInputFocusLocked(J)V

    .line 98
    :cond_38
    const v6, 0x8000

    if-ne v2, v6, :cond_40

    .line 99
    invoke-direct {p0, v3, v4}, Landroid/view/accessibility/AccessibilityNodeInfoCache;->clearSubtreeWithOldAccessibilityFocusLocked(J)V

    .line 101
    :cond_40
    monitor-exit v7

    goto :goto_7

    .end local v3           #sourceId:J
    :catchall_42
    move-exception v6

    monitor-exit v7
    :try_end_44
    .catchall {:try_start_2a .. :try_end_44} :catchall_42

    throw v6

    .line 105
    :sswitch_45
    iget-object v7, p0, Landroid/view/accessibility/AccessibilityNodeInfoCache;->mLock:Ljava/lang/Object;

    monitor-enter v7

    .line 106
    :try_start_48
    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityEvent;->getSourceNodeId()J

    move-result-wide v0

    .line 107
    .local v0, accessibilityNodeId:J
    invoke-direct {p0, v0, v1}, Landroid/view/accessibility/AccessibilityNodeInfoCache;->clearSubTreeLocked(J)V

    .line 108
    monitor-exit v7

    goto :goto_7

    .end local v0           #accessibilityNodeId:J
    :catchall_51
    move-exception v6

    monitor-exit v7
    :try_end_53
    .catchall {:try_start_48 .. :try_end_53} :catchall_51

    throw v6

    .line 69
    :sswitch_data_54
    .sparse-switch
        0x4 -> :sswitch_27
        0x8 -> :sswitch_27
        0x10 -> :sswitch_27
        0x20 -> :sswitch_f
        0x80 -> :sswitch_19
        0x100 -> :sswitch_19
        0x800 -> :sswitch_45
        0x1000 -> :sswitch_45
        0x2000 -> :sswitch_27
        0x8000 -> :sswitch_27
    .end sparse-switch
.end method
