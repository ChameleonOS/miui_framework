.class public Landroid/content/SyncQueue;
.super Ljava/lang/Object;
.source "SyncQueue.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "SyncManager"


# instance fields
.field public final mOperationsMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Landroid/content/SyncOperation;",
            ">;"
        }
    .end annotation
.end field

.field private mSyncStorageEngine:Landroid/content/SyncStorageEngine;


# direct methods
.method public constructor <init>(Landroid/content/SyncStorageEngine;Landroid/content/SyncAdaptersCache;)V
    .registers 24
    .parameter "syncStorageEngine"
    .parameter "syncAdapters"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    invoke-static {}, Lcom/google/android/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v3

    move-object/from16 v0, p0

    iput-object v3, v0, Landroid/content/SyncQueue;->mOperationsMap:Ljava/util/HashMap;

    move-object/from16 v0, p1

    move-object/from16 v1, p0

    iput-object v0, v1, Landroid/content/SyncQueue;->mSyncStorageEngine:Landroid/content/SyncStorageEngine;

    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/content/SyncQueue;->mSyncStorageEngine:Landroid/content/SyncStorageEngine;

    invoke-virtual {v3}, Landroid/content/SyncStorageEngine;->getPendingOperations()Ljava/util/ArrayList;

    move-result-object v19

    .local v19, ops:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/content/SyncStorageEngine$PendingOperation;>;"
    invoke-virtual/range {v19 .. v19}, Ljava/util/ArrayList;->size()I

    move-result v15

    .local v15, N:I
    const/16 v17, 0x0

    .local v17, i:I
    :goto_1f
    move/from16 v0, v17

    if-ge v0, v15, :cond_b0

    move-object/from16 v0, v19

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v18

    check-cast v18, Landroid/content/SyncStorageEngine$PendingOperation;

    .local v18, op:Landroid/content/SyncStorageEngine$PendingOperation;
    move-object/from16 v0, v18

    iget-object v3, v0, Landroid/content/SyncStorageEngine$PendingOperation;->account:Landroid/accounts/Account;

    move-object/from16 v0, v18

    iget v4, v0, Landroid/content/SyncStorageEngine$PendingOperation;->userId:I

    move-object/from16 v0, v18

    iget-object v5, v0, Landroid/content/SyncStorageEngine$PendingOperation;->authority:Ljava/lang/String;

    move-object/from16 v0, p1

    invoke-virtual {v0, v3, v4, v5}, Landroid/content/SyncStorageEngine;->getBackoff(Landroid/accounts/Account;ILjava/lang/String;)Landroid/util/Pair;

    move-result-object v16

    .local v16, backoff:Landroid/util/Pair;,"Landroid/util/Pair<Ljava/lang/Long;Ljava/lang/Long;>;"
    move-object/from16 v0, v18

    iget-object v3, v0, Landroid/content/SyncStorageEngine$PendingOperation;->authority:Ljava/lang/String;

    move-object/from16 v0, v18

    iget-object v4, v0, Landroid/content/SyncStorageEngine$PendingOperation;->account:Landroid/accounts/Account;

    iget-object v4, v4, Landroid/accounts/Account;->type:Ljava/lang/String;

    invoke-static {v3, v4}, Landroid/content/SyncAdapterType;->newKey(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SyncAdapterType;

    move-result-object v3

    move-object/from16 v0, p2

    invoke-virtual {v0, v3}, Landroid/content/SyncAdaptersCache;->getServiceInfo(Ljava/lang/Object;)Landroid/content/pm/RegisteredServicesCache$ServiceInfo;

    move-result-object v20

    .local v20, syncAdapterInfo:Landroid/content/pm/RegisteredServicesCache$ServiceInfo;,"Landroid/content/pm/RegisteredServicesCache$ServiceInfo<Landroid/content/SyncAdapterType;>;"
    if-nez v20, :cond_58

    :goto_55
    add-int/lit8 v17, v17, 0x1

    goto :goto_1f

    :cond_58
    new-instance v2, Landroid/content/SyncOperation;

    move-object/from16 v0, v18

    iget-object v3, v0, Landroid/content/SyncStorageEngine$PendingOperation;->account:Landroid/accounts/Account;

    move-object/from16 v0, v18

    iget v4, v0, Landroid/content/SyncStorageEngine$PendingOperation;->userId:I

    move-object/from16 v0, v18

    iget v5, v0, Landroid/content/SyncStorageEngine$PendingOperation;->syncSource:I

    move-object/from16 v0, v18

    iget-object v6, v0, Landroid/content/SyncStorageEngine$PendingOperation;->authority:Ljava/lang/String;

    move-object/from16 v0, v18

    iget-object v7, v0, Landroid/content/SyncStorageEngine$PendingOperation;->extras:Landroid/os/Bundle;

    const-wide/16 v8, 0x0

    if-eqz v16, :cond_ad

    move-object/from16 v0, v16

    iget-object v10, v0, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v10, Ljava/lang/Long;

    invoke-virtual {v10}, Ljava/lang/Long;->longValue()J

    move-result-wide v10

    :goto_7c
    move-object/from16 v0, v18

    iget-object v12, v0, Landroid/content/SyncStorageEngine$PendingOperation;->account:Landroid/accounts/Account;

    move-object/from16 v0, v18

    iget v13, v0, Landroid/content/SyncStorageEngine$PendingOperation;->userId:I

    move-object/from16 v0, v18

    iget-object v14, v0, Landroid/content/SyncStorageEngine$PendingOperation;->authority:Ljava/lang/String;

    move-object/from16 v0, p1

    invoke-virtual {v0, v12, v13, v14}, Landroid/content/SyncStorageEngine;->getDelayUntilTime(Landroid/accounts/Account;ILjava/lang/String;)J

    move-result-wide v12

    move-object/from16 v0, v20

    iget-object v14, v0, Landroid/content/pm/RegisteredServicesCache$ServiceInfo;->type:Ljava/lang/Object;

    check-cast v14, Landroid/content/SyncAdapterType;

    invoke-virtual {v14}, Landroid/content/SyncAdapterType;->allowParallelSyncs()Z

    move-result v14

    invoke-direct/range {v2 .. v14}, Landroid/content/SyncOperation;-><init>(Landroid/accounts/Account;IILjava/lang/String;Landroid/os/Bundle;JJJZ)V

    .local v2, syncOperation:Landroid/content/SyncOperation;
    move-object/from16 v0, v18

    iget-boolean v3, v0, Landroid/content/SyncStorageEngine$PendingOperation;->expedited:Z

    iput-boolean v3, v2, Landroid/content/SyncOperation;->expedited:Z

    move-object/from16 v0, v18

    iput-object v0, v2, Landroid/content/SyncOperation;->pendingOperation:Landroid/content/SyncStorageEngine$PendingOperation;

    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-direct {v0, v2, v1}, Landroid/content/SyncQueue;->add(Landroid/content/SyncOperation;Landroid/content/SyncStorageEngine$PendingOperation;)Z

    goto :goto_55

    .end local v2           #syncOperation:Landroid/content/SyncOperation;
    :cond_ad
    const-wide/16 v10, 0x0

    goto :goto_7c

    .end local v16           #backoff:Landroid/util/Pair;,"Landroid/util/Pair<Ljava/lang/Long;Ljava/lang/Long;>;"
    .end local v18           #op:Landroid/content/SyncStorageEngine$PendingOperation;
    .end local v20           #syncAdapterInfo:Landroid/content/pm/RegisteredServicesCache$ServiceInfo;,"Landroid/content/pm/RegisteredServicesCache$ServiceInfo<Landroid/content/SyncAdapterType;>;"
    :cond_b0
    return-void
.end method

.method private add(Landroid/content/SyncOperation;Landroid/content/SyncStorageEngine$PendingOperation;)Z
    .registers 16
    .parameter "operation"
    .parameter "pop"

    .prologue
    const/4 v12, 0x1

    iget-object v11, p1, Landroid/content/SyncOperation;->key:Ljava/lang/String;

    .local v11, operationKey:Ljava/lang/String;
    iget-object v0, p0, Landroid/content/SyncQueue;->mOperationsMap:Ljava/util/HashMap;

    invoke-virtual {v0, v11}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/content/SyncOperation;

    .local v8, existingOperation:Landroid/content/SyncOperation;
    if-eqz v8, :cond_2e

    const/4 v7, 0x0

    .local v7, changed:Z
    iget-boolean v0, v8, Landroid/content/SyncOperation;->expedited:Z

    iget-boolean v1, p1, Landroid/content/SyncOperation;->expedited:Z

    if-ne v0, v1, :cond_26

    iget-wide v0, v8, Landroid/content/SyncOperation;->earliestRunTime:J

    iget-wide v2, p1, Landroid/content/SyncOperation;->earliestRunTime:J

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v9

    .local v9, newRunTime:J
    iget-wide v0, v8, Landroid/content/SyncOperation;->earliestRunTime:J

    cmp-long v0, v0, v9

    if-eqz v0, :cond_25

    iput-wide v9, v8, Landroid/content/SyncOperation;->earliestRunTime:J

    const/4 v7, 0x1

    .end local v7           #changed:Z
    .end local v9           #newRunTime:J
    :cond_25
    :goto_25
    return v7

    .restart local v7       #changed:Z
    :cond_26
    iget-boolean v0, p1, Landroid/content/SyncOperation;->expedited:Z

    if-eqz v0, :cond_25

    iput-boolean v12, v8, Landroid/content/SyncOperation;->expedited:Z

    const/4 v7, 0x1

    goto :goto_25

    .end local v7           #changed:Z
    :cond_2e
    iput-object p2, p1, Landroid/content/SyncOperation;->pendingOperation:Landroid/content/SyncStorageEngine$PendingOperation;

    iget-object v0, p1, Landroid/content/SyncOperation;->pendingOperation:Landroid/content/SyncStorageEngine$PendingOperation;

    if-nez v0, :cond_69

    new-instance p2, Landroid/content/SyncStorageEngine$PendingOperation;

    .end local p2
    iget-object v1, p1, Landroid/content/SyncOperation;->account:Landroid/accounts/Account;

    iget v2, p1, Landroid/content/SyncOperation;->userId:I

    iget v3, p1, Landroid/content/SyncOperation;->syncSource:I

    iget-object v4, p1, Landroid/content/SyncOperation;->authority:Ljava/lang/String;

    iget-object v5, p1, Landroid/content/SyncOperation;->extras:Landroid/os/Bundle;

    iget-boolean v6, p1, Landroid/content/SyncOperation;->expedited:Z

    move-object v0, p2

    invoke-direct/range {v0 .. v6}, Landroid/content/SyncStorageEngine$PendingOperation;-><init>(Landroid/accounts/Account;IILjava/lang/String;Landroid/os/Bundle;Z)V

    .restart local p2
    iget-object v0, p0, Landroid/content/SyncQueue;->mSyncStorageEngine:Landroid/content/SyncStorageEngine;

    invoke-virtual {v0, p2}, Landroid/content/SyncStorageEngine;->insertIntoPending(Landroid/content/SyncStorageEngine$PendingOperation;)Landroid/content/SyncStorageEngine$PendingOperation;

    move-result-object p2

    if-nez p2, :cond_67

    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "error adding pending sync operation "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_67
    iput-object p2, p1, Landroid/content/SyncOperation;->pendingOperation:Landroid/content/SyncStorageEngine$PendingOperation;

    :cond_69
    iget-object v0, p0, Landroid/content/SyncQueue;->mOperationsMap:Ljava/util/HashMap;

    invoke-virtual {v0, v11, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move v7, v12

    goto :goto_25
.end method


# virtual methods
.method public add(Landroid/content/SyncOperation;)Z
    .registers 3
    .parameter "operation"

    .prologue
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/content/SyncQueue;->add(Landroid/content/SyncOperation;Landroid/content/SyncStorageEngine$PendingOperation;)Z

    move-result v0

    return v0
.end method

.method public dump(Ljava/lang/StringBuilder;)V
    .registers 10
    .parameter "sb"

    .prologue
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v1

    .local v1, now:J
    const-string v4, "SyncQueue: "

    invoke-virtual {p1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Landroid/content/SyncQueue;->mOperationsMap:Ljava/util/HashMap;

    invoke-virtual {v5}, Ljava/util/HashMap;->size()I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " operation(s)\n"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v4, p0, Landroid/content/SyncQueue;->mOperationsMap:Ljava/util/HashMap;

    invoke-virtual {v4}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :goto_23
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_61

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/content/SyncOperation;

    .local v3, operation:Landroid/content/SyncOperation;
    const-string v4, "  "

    invoke-virtual {p1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v4, v3, Landroid/content/SyncOperation;->effectiveRunTime:J

    cmp-long v4, v4, v1

    if-gtz v4, :cond_53

    const-string v4, "READY"

    invoke-virtual {p1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :goto_3f
    const-string v4, " - "

    invoke-virtual {p1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/content/SyncOperation;->dump(Z)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\n"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_23

    :cond_53
    iget-wide v4, v3, Landroid/content/SyncOperation;->effectiveRunTime:J

    sub-long/2addr v4, v1

    const-wide/16 v6, 0x3e8

    div-long/2addr v4, v6

    invoke-static {v4, v5}, Landroid/text/format/DateUtils;->formatElapsedTime(J)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_3f

    .end local v3           #operation:Landroid/content/SyncOperation;
    :cond_61
    return-void
.end method

.method public onBackoffChanged(Landroid/accounts/Account;ILjava/lang/String;J)V
    .registers 9
    .parameter "account"
    .parameter "userId"
    .parameter "providerName"
    .parameter "backoff"

    .prologue
    iget-object v2, p0, Landroid/content/SyncQueue;->mOperationsMap:Ljava/util/HashMap;

    invoke-virtual {v2}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :cond_a
    :goto_a
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_34

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/SyncOperation;

    .local v1, op:Landroid/content/SyncOperation;
    iget-object v2, v1, Landroid/content/SyncOperation;->account:Landroid/accounts/Account;

    invoke-virtual {v2, p1}, Landroid/accounts/Account;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_a

    iget-object v2, v1, Landroid/content/SyncOperation;->authority:Ljava/lang/String;

    invoke-virtual {v2, p3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_a

    iget v2, v1, Landroid/content/SyncOperation;->userId:I

    if-ne v2, p2, :cond_a

    invoke-static {p4, p5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    iput-object v2, v1, Landroid/content/SyncOperation;->backoff:Ljava/lang/Long;

    invoke-virtual {v1}, Landroid/content/SyncOperation;->updateEffectiveRunTime()V

    goto :goto_a

    .end local v1           #op:Landroid/content/SyncOperation;
    :cond_34
    return-void
.end method

.method public onDelayUntilTimeChanged(Landroid/accounts/Account;Ljava/lang/String;J)V
    .registers 8
    .parameter "account"
    .parameter "providerName"
    .parameter "delayUntil"

    .prologue
    iget-object v2, p0, Landroid/content/SyncQueue;->mOperationsMap:Ljava/util/HashMap;

    invoke-virtual {v2}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :cond_a
    :goto_a
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2c

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/SyncOperation;

    .local v1, op:Landroid/content/SyncOperation;
    iget-object v2, v1, Landroid/content/SyncOperation;->account:Landroid/accounts/Account;

    invoke-virtual {v2, p1}, Landroid/accounts/Account;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_a

    iget-object v2, v1, Landroid/content/SyncOperation;->authority:Ljava/lang/String;

    invoke-virtual {v2, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_a

    iput-wide p3, v1, Landroid/content/SyncOperation;->delayUntil:J

    invoke-virtual {v1}, Landroid/content/SyncOperation;->updateEffectiveRunTime()V

    goto :goto_a

    .end local v1           #op:Landroid/content/SyncOperation;
    :cond_2c
    return-void
.end method

.method public remove(Landroid/accounts/Account;ILjava/lang/String;)V
    .registers 10
    .parameter "account"
    .parameter "userId"
    .parameter "authority"

    .prologue
    iget-object v4, p0, Landroid/content/SyncQueue;->mOperationsMap:Ljava/util/HashMap;

    invoke-virtual {v4}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, entries:Ljava/util/Iterator;,"Ljava/util/Iterator<Ljava/util/Map$Entry<Ljava/lang/String;Landroid/content/SyncOperation;>;>;"
    :cond_a
    :goto_a
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_60

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .local v1, entry:Ljava/util/Map$Entry;,"Ljava/util/Map$Entry<Ljava/lang/String;Landroid/content/SyncOperation;>;"
    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/content/SyncOperation;

    .local v3, syncOperation:Landroid/content/SyncOperation;
    if-eqz p1, :cond_26

    iget-object v4, v3, Landroid/content/SyncOperation;->account:Landroid/accounts/Account;

    invoke-virtual {v4, p1}, Landroid/accounts/Account;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_a

    :cond_26
    if-eqz p3, :cond_30

    iget-object v4, v3, Landroid/content/SyncOperation;->authority:Ljava/lang/String;

    invoke-virtual {v4, p3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_a

    :cond_30
    iget v4, v3, Landroid/content/SyncOperation;->userId:I

    if-ne p2, v4, :cond_a

    invoke-interface {v0}, Ljava/util/Iterator;->remove()V

    iget-object v4, p0, Landroid/content/SyncQueue;->mSyncStorageEngine:Landroid/content/SyncStorageEngine;

    iget-object v5, v3, Landroid/content/SyncOperation;->pendingOperation:Landroid/content/SyncStorageEngine$PendingOperation;

    invoke-virtual {v4, v5}, Landroid/content/SyncStorageEngine;->deleteFromPending(Landroid/content/SyncStorageEngine$PendingOperation;)Z

    move-result v4

    if-nez v4, :cond_a

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "unable to find pending row for "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .local v2, errorMessage:Ljava/lang/String;
    const-string v4, "SyncManager"

    new-instance v5, Ljava/lang/IllegalStateException;

    invoke-direct {v5, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-static {v4, v2, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_a

    .end local v1           #entry:Ljava/util/Map$Entry;,"Ljava/util/Map$Entry<Ljava/lang/String;Landroid/content/SyncOperation;>;"
    .end local v2           #errorMessage:Ljava/lang/String;
    .end local v3           #syncOperation:Landroid/content/SyncOperation;
    :cond_60
    return-void
.end method

.method public remove(Landroid/content/SyncOperation;)V
    .registers 6
    .parameter "operation"

    .prologue
    iget-object v2, p0, Landroid/content/SyncQueue;->mOperationsMap:Ljava/util/HashMap;

    iget-object v3, p1, Landroid/content/SyncOperation;->key:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/SyncOperation;

    .local v1, operationToRemove:Landroid/content/SyncOperation;
    if-nez v1, :cond_d

    :cond_c
    :goto_c
    return-void

    :cond_d
    iget-object v2, p0, Landroid/content/SyncQueue;->mSyncStorageEngine:Landroid/content/SyncStorageEngine;

    iget-object v3, v1, Landroid/content/SyncOperation;->pendingOperation:Landroid/content/SyncStorageEngine$PendingOperation;

    invoke-virtual {v2, v3}, Landroid/content/SyncStorageEngine;->deleteFromPending(Landroid/content/SyncStorageEngine$PendingOperation;)Z

    move-result v2

    if-nez v2, :cond_c

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "unable to find pending row for "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .local v0, errorMessage:Ljava/lang/String;
    const-string v2, "SyncManager"

    new-instance v3, Ljava/lang/IllegalStateException;

    invoke-direct {v3, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-static {v2, v0, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_c
.end method

.method public removeUser(I)V
    .registers 6
    .parameter "userId"

    .prologue
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .local v2, opsToRemove:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/content/SyncOperation;>;"
    iget-object v3, p0, Landroid/content/SyncQueue;->mOperationsMap:Ljava/util/HashMap;

    invoke-virtual {v3}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :cond_f
    :goto_f
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_23

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/SyncOperation;

    .local v1, op:Landroid/content/SyncOperation;
    iget v3, v1, Landroid/content/SyncOperation;->userId:I

    if-ne v3, p1, :cond_f

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_f

    .end local v1           #op:Landroid/content/SyncOperation;
    :cond_23
    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_27
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_37

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/SyncOperation;

    .restart local v1       #op:Landroid/content/SyncOperation;
    invoke-virtual {p0, v1}, Landroid/content/SyncQueue;->remove(Landroid/content/SyncOperation;)V

    goto :goto_27

    .end local v1           #op:Landroid/content/SyncOperation;
    :cond_37
    return-void
.end method
