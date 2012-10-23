.class public Landroid/os/RemoteCallbackList;
.super Ljava/lang/Object;
.source "RemoteCallbackList.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/os/RemoteCallbackList$Callback;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<E::",
        "Landroid/os/IInterface;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private mActiveBroadcast:[Ljava/lang/Object;

.field private mBroadcastCount:I

.field mCallbacks:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Landroid/os/IBinder;",
            "Landroid/os/RemoteCallbackList",
            "<TE;>.Callback;>;"
        }
    .end annotation
.end field

.field private mKilled:Z


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 49
    .local p0, this:Landroid/os/RemoteCallbackList;,"Landroid/os/RemoteCallbackList<TE;>;"
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 50
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroid/os/RemoteCallbackList;->mCallbacks:Ljava/util/HashMap;

    .line 53
    const/4 v0, -0x1

    iput v0, p0, Landroid/os/RemoteCallbackList;->mBroadcastCount:I

    .line 54
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/os/RemoteCallbackList;->mKilled:Z

    .line 56
    return-void
.end method


# virtual methods
.method public beginBroadcast()I
    .registers 10

    .prologue
    .line 227
    .local p0, this:Landroid/os/RemoteCallbackList;,"Landroid/os/RemoteCallbackList<TE;>;"
    iget-object v7, p0, Landroid/os/RemoteCallbackList;->mCallbacks:Ljava/util/HashMap;

    monitor-enter v7

    .line 228
    :try_start_3
    iget v6, p0, Landroid/os/RemoteCallbackList;->mBroadcastCount:I

    if-lez v6, :cond_12

    .line 229
    new-instance v6, Ljava/lang/IllegalStateException;

    const-string v8, "beginBroadcast() called while already in a broadcast"

    invoke-direct {v6, v8}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 246
    :catchall_f
    move-exception v6

    monitor-exit v7
    :try_end_11
    .catchall {:try_start_3 .. :try_end_11} :catchall_f

    throw v6

    .line 233
    :cond_12
    :try_start_12
    iget-object v6, p0, Landroid/os/RemoteCallbackList;->mCallbacks:Ljava/util/HashMap;

    invoke-virtual {v6}, Ljava/util/HashMap;->size()I

    move-result v0

    iput v0, p0, Landroid/os/RemoteCallbackList;->mBroadcastCount:I

    .line 234
    .local v0, N:I
    if-gtz v0, :cond_1f

    .line 235
    const/4 v4, 0x0

    monitor-exit v7

    .line 245
    :goto_1e
    return v4

    .line 237
    :cond_1f
    iget-object v1, p0, Landroid/os/RemoteCallbackList;->mActiveBroadcast:[Ljava/lang/Object;

    .line 238
    .local v1, active:[Ljava/lang/Object;
    if-eqz v1, :cond_26

    array-length v6, v1

    if-ge v6, v0, :cond_2a

    .line 239
    :cond_26
    new-array v1, v0, [Ljava/lang/Object;

    iput-object v1, p0, Landroid/os/RemoteCallbackList;->mActiveBroadcast:[Ljava/lang/Object;

    .line 241
    :cond_2a
    const/4 v3, 0x0

    .line 242
    .local v3, i:I
    iget-object v6, p0, Landroid/os/RemoteCallbackList;->mCallbacks:Ljava/util/HashMap;

    invoke-virtual {v6}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .local v5, i$:Ljava/util/Iterator;
    move v4, v3

    .end local v3           #i:I
    .local v4, i:I
    :goto_36
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_48

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/os/RemoteCallbackList$Callback;

    .line 243
    .local v2, cb:Landroid/os/RemoteCallbackList$Callback;,"Landroid/os/RemoteCallbackList<TE;>.Callback;"
    add-int/lit8 v3, v4, 0x1

    .end local v4           #i:I
    .restart local v3       #i:I
    aput-object v2, v1, v4

    move v4, v3

    .end local v3           #i:I
    .restart local v4       #i:I
    goto :goto_36

    .line 245
    .end local v2           #cb:Landroid/os/RemoteCallbackList$Callback;,"Landroid/os/RemoteCallbackList<TE;>.Callback;"
    :cond_48
    monitor-exit v7
    :try_end_49
    .catchall {:try_start_12 .. :try_end_49} :catchall_f

    goto :goto_1e
.end method

.method public finishBroadcast()V
    .registers 6

    .prologue
    .line 292
    .local p0, this:Landroid/os/RemoteCallbackList;,"Landroid/os/RemoteCallbackList<TE;>;"
    iget v3, p0, Landroid/os/RemoteCallbackList;->mBroadcastCount:I

    if-gez v3, :cond_c

    .line 293
    new-instance v3, Ljava/lang/IllegalStateException;

    const-string v4, "finishBroadcast() called outside of a broadcast"

    invoke-direct {v3, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 297
    :cond_c
    iget-object v1, p0, Landroid/os/RemoteCallbackList;->mActiveBroadcast:[Ljava/lang/Object;

    .line 298
    .local v1, active:[Ljava/lang/Object;
    if-eqz v1, :cond_1b

    .line 299
    iget v0, p0, Landroid/os/RemoteCallbackList;->mBroadcastCount:I

    .line 300
    .local v0, N:I
    const/4 v2, 0x0

    .local v2, i:I
    :goto_13
    if-ge v2, v0, :cond_1b

    .line 301
    const/4 v3, 0x0

    aput-object v3, v1, v2

    .line 300
    add-int/lit8 v2, v2, 0x1

    goto :goto_13

    .line 305
    .end local v0           #N:I
    .end local v2           #i:I
    :cond_1b
    const/4 v3, -0x1

    iput v3, p0, Landroid/os/RemoteCallbackList;->mBroadcastCount:I

    .line 306
    return-void
.end method

.method public getBroadcastCookie(I)Ljava/lang/Object;
    .registers 3
    .parameter "index"

    .prologue
    .line 281
    .local p0, this:Landroid/os/RemoteCallbackList;,"Landroid/os/RemoteCallbackList<TE;>;"
    iget-object v0, p0, Landroid/os/RemoteCallbackList;->mActiveBroadcast:[Ljava/lang/Object;

    aget-object v0, v0, p1

    check-cast v0, Landroid/os/RemoteCallbackList$Callback;

    iget-object v0, v0, Landroid/os/RemoteCallbackList$Callback;->mCookie:Ljava/lang/Object;

    return-object v0
.end method

.method public getBroadcastItem(I)Landroid/os/IInterface;
    .registers 3
    .parameter "index"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)TE;"
        }
    .end annotation

    .prologue
    .line 271
    .local p0, this:Landroid/os/RemoteCallbackList;,"Landroid/os/RemoteCallbackList<TE;>;"
    iget-object v0, p0, Landroid/os/RemoteCallbackList;->mActiveBroadcast:[Ljava/lang/Object;

    aget-object v0, v0, p1

    check-cast v0, Landroid/os/RemoteCallbackList$Callback;

    iget-object v0, v0, Landroid/os/RemoteCallbackList$Callback;->mCallback:Landroid/os/IInterface;

    return-object v0
.end method

.method public kill()V
    .registers 6

    .prologue
    .line 161
    .local p0, this:Landroid/os/RemoteCallbackList;,"Landroid/os/RemoteCallbackList<TE;>;"
    iget-object v3, p0, Landroid/os/RemoteCallbackList;->mCallbacks:Ljava/util/HashMap;

    monitor-enter v3

    .line 162
    :try_start_3
    iget-object v2, p0, Landroid/os/RemoteCallbackList;->mCallbacks:Ljava/util/HashMap;

    invoke-virtual {v2}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, i$:Ljava/util/Iterator;
    :goto_d
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_27

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/RemoteCallbackList$Callback;

    .line 163
    .local v0, cb:Landroid/os/RemoteCallbackList$Callback;,"Landroid/os/RemoteCallbackList<TE;>.Callback;"
    iget-object v2, v0, Landroid/os/RemoteCallbackList$Callback;->mCallback:Landroid/os/IInterface;

    invoke-interface {v2}, Landroid/os/IInterface;->asBinder()Landroid/os/IBinder;

    move-result-object v2

    const/4 v4, 0x0

    invoke-interface {v2, v0, v4}, Landroid/os/IBinder;->unlinkToDeath(Landroid/os/IBinder$DeathRecipient;I)Z

    goto :goto_d

    .line 167
    .end local v0           #cb:Landroid/os/RemoteCallbackList$Callback;,"Landroid/os/RemoteCallbackList<TE;>.Callback;"
    .end local v1           #i$:Ljava/util/Iterator;
    :catchall_24
    move-exception v2

    monitor-exit v3
    :try_end_26
    .catchall {:try_start_3 .. :try_end_26} :catchall_24

    throw v2

    .line 165
    .restart local v1       #i$:Ljava/util/Iterator;
    :cond_27
    :try_start_27
    iget-object v2, p0, Landroid/os/RemoteCallbackList;->mCallbacks:Ljava/util/HashMap;

    invoke-virtual {v2}, Ljava/util/HashMap;->clear()V

    .line 166
    const/4 v2, 0x1

    iput-boolean v2, p0, Landroid/os/RemoteCallbackList;->mKilled:Z

    .line 167
    monitor-exit v3
    :try_end_30
    .catchall {:try_start_27 .. :try_end_30} :catchall_24

    .line 168
    return-void
.end method

.method public onCallbackDied(Landroid/os/IInterface;)V
    .registers 2
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TE;)V"
        }
    .end annotation

    .prologue
    .line 175
    .local p0, this:Landroid/os/RemoteCallbackList;,"Landroid/os/RemoteCallbackList<TE;>;"
    .local p1, callback:Landroid/os/IInterface;,"TE;"
    return-void
.end method

.method public onCallbackDied(Landroid/os/IInterface;Ljava/lang/Object;)V
    .registers 3
    .parameter
    .parameter "cookie"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TE;",
            "Ljava/lang/Object;",
            ")V"
        }
    .end annotation

    .prologue
    .line 192
    .local p0, this:Landroid/os/RemoteCallbackList;,"Landroid/os/RemoteCallbackList<TE;>;"
    .local p1, callback:Landroid/os/IInterface;,"TE;"
    invoke-virtual {p0, p1}, Landroid/os/RemoteCallbackList;->onCallbackDied(Landroid/os/IInterface;)V

    .line 193
    return-void
.end method

.method public register(Landroid/os/IInterface;)Z
    .registers 3
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TE;)Z"
        }
    .end annotation

    .prologue
    .line 78
    .local p0, this:Landroid/os/RemoteCallbackList;,"Landroid/os/RemoteCallbackList<TE;>;"
    .local p1, callback:Landroid/os/IInterface;,"TE;"
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Landroid/os/RemoteCallbackList;->register(Landroid/os/IInterface;Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public register(Landroid/os/IInterface;Ljava/lang/Object;)Z
    .registers 9
    .parameter
    .parameter "cookie"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TE;",
            "Ljava/lang/Object;",
            ")Z"
        }
    .end annotation

    .prologue
    .local p0, this:Landroid/os/RemoteCallbackList;,"Landroid/os/RemoteCallbackList<TE;>;"
    .local p1, callback:Landroid/os/IInterface;,"TE;"
    const/4 v3, 0x0

    .line 108
    iget-object v4, p0, Landroid/os/RemoteCallbackList;->mCallbacks:Ljava/util/HashMap;

    monitor-enter v4

    .line 109
    :try_start_4
    iget-boolean v5, p0, Landroid/os/RemoteCallbackList;->mKilled:Z

    if-eqz v5, :cond_a

    .line 110
    monitor-exit v4

    .line 119
    :goto_9
    return v3

    .line 112
    :cond_a
    invoke-interface {p1}, Landroid/os/IInterface;->asBinder()Landroid/os/IBinder;
    :try_end_d
    .catchall {:try_start_4 .. :try_end_d} :catchall_1f

    move-result-object v0

    .line 114
    .local v0, binder:Landroid/os/IBinder;
    :try_start_e
    new-instance v1, Landroid/os/RemoteCallbackList$Callback;

    invoke-direct {v1, p0, p1, p2}, Landroid/os/RemoteCallbackList$Callback;-><init>(Landroid/os/RemoteCallbackList;Landroid/os/IInterface;Ljava/lang/Object;)V

    .line 115
    .local v1, cb:Landroid/os/RemoteCallbackList$Callback;,"Landroid/os/RemoteCallbackList<TE;>.Callback;"
    const/4 v5, 0x0

    invoke-interface {v0, v1, v5}, Landroid/os/IBinder;->linkToDeath(Landroid/os/IBinder$DeathRecipient;I)V

    .line 116
    iget-object v5, p0, Landroid/os/RemoteCallbackList;->mCallbacks:Ljava/util/HashMap;

    invoke-virtual {v5, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1c
    .catchall {:try_start_e .. :try_end_1c} :catchall_1f
    .catch Landroid/os/RemoteException; {:try_start_e .. :try_end_1c} :catch_22

    .line 117
    const/4 v3, 0x1

    :try_start_1d
    monitor-exit v4

    goto :goto_9

    .line 121
    .end local v0           #binder:Landroid/os/IBinder;
    .end local v1           #cb:Landroid/os/RemoteCallbackList$Callback;,"Landroid/os/RemoteCallbackList<TE;>.Callback;"
    :catchall_1f
    move-exception v3

    monitor-exit v4
    :try_end_21
    .catchall {:try_start_1d .. :try_end_21} :catchall_1f

    throw v3

    .line 118
    .restart local v0       #binder:Landroid/os/IBinder;
    :catch_22
    move-exception v2

    .line 119
    .local v2, e:Landroid/os/RemoteException;
    :try_start_23
    monitor-exit v4
    :try_end_24
    .catchall {:try_start_23 .. :try_end_24} :catchall_1f

    goto :goto_9
.end method

.method public unregister(Landroid/os/IInterface;)Z
    .registers 7
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TE;)Z"
        }
    .end annotation

    .prologue
    .local p0, this:Landroid/os/RemoteCallbackList;,"Landroid/os/RemoteCallbackList<TE;>;"
    .local p1, callback:Landroid/os/IInterface;,"TE;"
    const/4 v1, 0x0

    .line 142
    iget-object v2, p0, Landroid/os/RemoteCallbackList;->mCallbacks:Ljava/util/HashMap;

    monitor-enter v2

    .line 143
    :try_start_4
    iget-object v3, p0, Landroid/os/RemoteCallbackList;->mCallbacks:Ljava/util/HashMap;

    invoke-interface {p1}, Landroid/os/IInterface;->asBinder()Landroid/os/IBinder;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/RemoteCallbackList$Callback;

    .line 144
    .local v0, cb:Landroid/os/RemoteCallbackList$Callback;,"Landroid/os/RemoteCallbackList<TE;>.Callback;"
    if-eqz v0, :cond_1f

    .line 145
    iget-object v1, v0, Landroid/os/RemoteCallbackList$Callback;->mCallback:Landroid/os/IInterface;

    invoke-interface {v1}, Landroid/os/IInterface;->asBinder()Landroid/os/IBinder;

    move-result-object v1

    const/4 v3, 0x0

    invoke-interface {v1, v0, v3}, Landroid/os/IBinder;->unlinkToDeath(Landroid/os/IBinder$DeathRecipient;I)Z

    .line 146
    const/4 v1, 0x1

    monitor-exit v2

    .line 148
    :goto_1e
    return v1

    :cond_1f
    monitor-exit v2

    goto :goto_1e

    .line 149
    .end local v0           #cb:Landroid/os/RemoteCallbackList$Callback;,"Landroid/os/RemoteCallbackList<TE;>.Callback;"
    :catchall_21
    move-exception v1

    monitor-exit v2
    :try_end_23
    .catchall {:try_start_4 .. :try_end_23} :catchall_21

    throw v1
.end method
