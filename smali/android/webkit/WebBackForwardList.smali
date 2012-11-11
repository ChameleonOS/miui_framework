.class public Landroid/webkit/WebBackForwardList;
.super Ljava/lang/Object;
.source "WebBackForwardList.java"

# interfaces
.implements Ljava/lang/Cloneable;
.implements Ljava/io/Serializable;


# instance fields
.field private mArray:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/webkit/WebHistoryItem;",
            ">;"
        }
    .end annotation
.end field

.field private final mCallbackProxy:Landroid/webkit/CallbackProxy;

.field private mClearPending:Z

.field private mCurrentIndex:I


# direct methods
.method constructor <init>(Landroid/webkit/CallbackProxy;)V
    .registers 3
    .parameter "proxy"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, -0x1

    iput v0, p0, Landroid/webkit/WebBackForwardList;->mCurrentIndex:I

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/webkit/WebBackForwardList;->mArray:Ljava/util/ArrayList;

    iput-object p1, p0, Landroid/webkit/WebBackForwardList;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    return-void
.end method

.method private static native nativeClose(I)V
.end method

.method private declared-synchronized removeHistoryItem(I)V
    .registers 4
    .parameter "index"

    .prologue
    monitor-enter p0

    :try_start_1
    iget-object v1, p0, Landroid/webkit/WebBackForwardList;->mArray:Ljava/util/ArrayList;

    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/webkit/WebHistoryItem;

    .local v0, h:Landroid/webkit/WebHistoryItem;
    iget v1, p0, Landroid/webkit/WebBackForwardList;->mCurrentIndex:I

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Landroid/webkit/WebBackForwardList;->mCurrentIndex:I
    :try_end_f
    .catchall {:try_start_1 .. :try_end_f} :catchall_11

    monitor-exit p0

    return-void

    .end local v0           #h:Landroid/webkit/WebHistoryItem;
    :catchall_11
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method static synchronized native declared-synchronized restoreIndex(II)V
.end method


# virtual methods
.method declared-synchronized addHistoryItem(Landroid/webkit/WebHistoryItem;)V
    .registers 6
    .parameter "item"

    .prologue
    monitor-enter p0

    :try_start_1
    iget v3, p0, Landroid/webkit/WebBackForwardList;->mCurrentIndex:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Landroid/webkit/WebBackForwardList;->mCurrentIndex:I

    iget-object v3, p0, Landroid/webkit/WebBackForwardList;->mArray:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v2

    .local v2, size:I
    iget v1, p0, Landroid/webkit/WebBackForwardList;->mCurrentIndex:I

    .local v1, newPos:I
    if-eq v1, v2, :cond_20

    add-int/lit8 v0, v2, -0x1

    .local v0, i:I
    :goto_13
    if-lt v0, v1, :cond_20

    iget-object v3, p0, Landroid/webkit/WebBackForwardList;->mArray:Ljava/util/ArrayList;

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/webkit/WebHistoryItem;

    add-int/lit8 v0, v0, -0x1

    goto :goto_13

    .end local v0           #i:I
    :cond_20
    iget-object v3, p0, Landroid/webkit/WebBackForwardList;->mArray:Ljava/util/ArrayList;

    invoke-virtual {v3, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    iget-object v3, p0, Landroid/webkit/WebBackForwardList;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    if-eqz v3, :cond_2e

    iget-object v3, p0, Landroid/webkit/WebBackForwardList;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    invoke-virtual {v3, p1}, Landroid/webkit/CallbackProxy;->onNewHistoryItem(Landroid/webkit/WebHistoryItem;)V
    :try_end_2e
    .catchall {:try_start_1 .. :try_end_2e} :catchall_30

    :cond_2e
    monitor-exit p0

    return-void

    .end local v1           #newPos:I
    .end local v2           #size:I
    :catchall_30
    move-exception v3

    monitor-exit p0

    throw v3
.end method

.method protected declared-synchronized clone()Landroid/webkit/WebBackForwardList;
    .registers 6

    .prologue
    monitor-enter p0

    :try_start_1
    new-instance v1, Landroid/webkit/WebBackForwardList;

    const/4 v3, 0x0

    invoke-direct {v1, v3}, Landroid/webkit/WebBackForwardList;-><init>(Landroid/webkit/CallbackProxy;)V

    .local v1, l:Landroid/webkit/WebBackForwardList;
    iget-boolean v3, p0, Landroid/webkit/WebBackForwardList;->mClearPending:Z

    if-eqz v3, :cond_14

    invoke-virtual {p0}, Landroid/webkit/WebBackForwardList;->getCurrentItem()Landroid/webkit/WebHistoryItem;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/webkit/WebBackForwardList;->addHistoryItem(Landroid/webkit/WebHistoryItem;)V
    :try_end_12
    .catchall {:try_start_1 .. :try_end_12} :catchall_3a

    :cond_12
    monitor-exit p0

    return-object v1

    :cond_14
    :try_start_14
    iget v3, p0, Landroid/webkit/WebBackForwardList;->mCurrentIndex:I

    iput v3, v1, Landroid/webkit/WebBackForwardList;->mCurrentIndex:I

    invoke-virtual {p0}, Landroid/webkit/WebBackForwardList;->getSize()I

    move-result v2

    .local v2, size:I
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3, v2}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v3, v1, Landroid/webkit/WebBackForwardList;->mArray:Ljava/util/ArrayList;

    const/4 v0, 0x0

    .local v0, i:I
    :goto_24
    if-ge v0, v2, :cond_12

    iget-object v4, v1, Landroid/webkit/WebBackForwardList;->mArray:Ljava/util/ArrayList;

    iget-object v3, p0, Landroid/webkit/WebBackForwardList;->mArray:Ljava/util/ArrayList;

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/webkit/WebHistoryItem;

    invoke-virtual {v3}, Landroid/webkit/WebHistoryItem;->clone()Landroid/webkit/WebHistoryItem;

    move-result-object v3

    invoke-virtual {v4, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_37
    .catchall {:try_start_14 .. :try_end_37} :catchall_3a

    add-int/lit8 v0, v0, 0x1

    goto :goto_24

    .end local v0           #i:I
    .end local v1           #l:Landroid/webkit/WebBackForwardList;
    .end local v2           #size:I
    :catchall_3a
    move-exception v3

    monitor-exit p0

    throw v3
.end method

.method protected bridge synthetic clone()Ljava/lang/Object;
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    invoke-virtual {p0}, Landroid/webkit/WebBackForwardList;->clone()Landroid/webkit/WebBackForwardList;

    move-result-object v0

    return-object v0
.end method

.method declared-synchronized close(I)V
    .registers 3
    .parameter "nativeFrame"

    .prologue
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroid/webkit/WebBackForwardList;->mArray:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    const/4 v0, -0x1

    iput v0, p0, Landroid/webkit/WebBackForwardList;->mCurrentIndex:I

    invoke-static {p1}, Landroid/webkit/WebBackForwardList;->nativeClose(I)V

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/webkit/WebBackForwardList;->mClearPending:Z
    :try_end_f
    .catchall {:try_start_1 .. :try_end_f} :catchall_11

    monitor-exit p0

    return-void

    :catchall_11
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized getClearPending()Z
    .registers 2

    .prologue
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebBackForwardList;->mClearPending:Z
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getCurrentIndex()I
    .registers 2

    .prologue
    monitor-enter p0

    :try_start_1
    iget v0, p0, Landroid/webkit/WebBackForwardList;->mCurrentIndex:I
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getCurrentItem()Landroid/webkit/WebHistoryItem;
    .registers 2

    .prologue
    monitor-enter p0

    :try_start_1
    iget v0, p0, Landroid/webkit/WebBackForwardList;->mCurrentIndex:I

    invoke-virtual {p0, v0}, Landroid/webkit/WebBackForwardList;->getItemAtIndex(I)Landroid/webkit/WebHistoryItem;
    :try_end_6
    .catchall {:try_start_1 .. :try_end_6} :catchall_9

    move-result-object v0

    monitor-exit p0

    return-object v0

    :catchall_9
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getItemAtIndex(I)Landroid/webkit/WebHistoryItem;
    .registers 3
    .parameter "index"

    .prologue
    monitor-enter p0

    if-ltz p1, :cond_9

    :try_start_3
    invoke-virtual {p0}, Landroid/webkit/WebBackForwardList;->getSize()I
    :try_end_6
    .catchall {:try_start_3 .. :try_end_6} :catchall_15

    move-result v0

    if-lt p1, v0, :cond_c

    :cond_9
    const/4 v0, 0x0

    :goto_a
    monitor-exit p0

    return-object v0

    :cond_c
    :try_start_c
    iget-object v0, p0, Landroid/webkit/WebBackForwardList;->mArray:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/webkit/WebHistoryItem;
    :try_end_14
    .catchall {:try_start_c .. :try_end_14} :catchall_15

    goto :goto_a

    :catchall_15
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getSize()I
    .registers 2

    .prologue
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroid/webkit/WebBackForwardList;->mArray:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I
    :try_end_6
    .catchall {:try_start_1 .. :try_end_6} :catchall_9

    move-result v0

    monitor-exit p0

    return v0

    :catchall_9
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized setClearPending()V
    .registers 2

    .prologue
    monitor-enter p0

    const/4 v0, 0x1

    :try_start_2
    iput-boolean v0, p0, Landroid/webkit/WebBackForwardList;->mClearPending:Z
    :try_end_4
    .catchall {:try_start_2 .. :try_end_4} :catchall_6

    monitor-exit p0

    return-void

    :catchall_6
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized setCurrentIndex(I)V
    .registers 4
    .parameter "newIndex"

    .prologue
    monitor-enter p0

    :try_start_1
    iput p1, p0, Landroid/webkit/WebBackForwardList;->mCurrentIndex:I

    iget-object v0, p0, Landroid/webkit/WebBackForwardList;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    if-eqz v0, :cond_10

    iget-object v0, p0, Landroid/webkit/WebBackForwardList;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    invoke-virtual {p0, p1}, Landroid/webkit/WebBackForwardList;->getItemAtIndex(I)Landroid/webkit/WebHistoryItem;

    move-result-object v1

    invoke-virtual {v0, v1, p1}, Landroid/webkit/CallbackProxy;->onIndexChanged(Landroid/webkit/WebHistoryItem;I)V
    :try_end_10
    .catchall {:try_start_1 .. :try_end_10} :catchall_12

    :cond_10
    monitor-exit p0

    return-void

    :catchall_12
    move-exception v0

    monitor-exit p0

    throw v0
.end method
