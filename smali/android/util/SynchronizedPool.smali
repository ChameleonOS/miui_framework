.class Landroid/util/SynchronizedPool;
.super Ljava/lang/Object;
.source "SynchronizedPool.java"

# interfaces
.implements Landroid/util/Pool;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T::",
        "Landroid/util/Poolable",
        "<TT;>;>",
        "Ljava/lang/Object;",
        "Landroid/util/Pool",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final mLock:Ljava/lang/Object;

.field private final mPool:Landroid/util/Pool;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/Pool",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/util/Pool;)V
    .registers 2
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/util/Pool",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .local p0, this:Landroid/util/SynchronizedPool;,"Landroid/util/SynchronizedPool<TT;>;"
    .local p1, pool:Landroid/util/Pool;,"Landroid/util/Pool<TT;>;"
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroid/util/SynchronizedPool;->mPool:Landroid/util/Pool;

    iput-object p0, p0, Landroid/util/SynchronizedPool;->mLock:Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>(Landroid/util/Pool;Ljava/lang/Object;)V
    .registers 3
    .parameter
    .parameter "lock"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/util/Pool",
            "<TT;>;",
            "Ljava/lang/Object;",
            ")V"
        }
    .end annotation

    .prologue
    .local p0, this:Landroid/util/SynchronizedPool;,"Landroid/util/SynchronizedPool<TT;>;"
    .local p1, pool:Landroid/util/Pool;,"Landroid/util/Pool<TT;>;"
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroid/util/SynchronizedPool;->mPool:Landroid/util/Pool;

    iput-object p2, p0, Landroid/util/SynchronizedPool;->mLock:Ljava/lang/Object;

    return-void
.end method


# virtual methods
.method public acquire()Landroid/util/Poolable;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .local p0, this:Landroid/util/SynchronizedPool;,"Landroid/util/SynchronizedPool<TT;>;"
    iget-object v1, p0, Landroid/util/SynchronizedPool;->mLock:Ljava/lang/Object;

    monitor-enter v1

    :try_start_3
    iget-object v0, p0, Landroid/util/SynchronizedPool;->mPool:Landroid/util/Pool;

    invoke-interface {v0}, Landroid/util/Pool;->acquire()Landroid/util/Poolable;

    move-result-object v0

    monitor-exit v1

    return-object v0

    :catchall_b
    move-exception v0

    monitor-exit v1
    :try_end_d
    .catchall {:try_start_3 .. :try_end_d} :catchall_b

    throw v0
.end method

.method public release(Landroid/util/Poolable;)V
    .registers 4
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .local p0, this:Landroid/util/SynchronizedPool;,"Landroid/util/SynchronizedPool<TT;>;"
    .local p1, element:Landroid/util/Poolable;,"TT;"
    iget-object v1, p0, Landroid/util/SynchronizedPool;->mLock:Ljava/lang/Object;

    monitor-enter v1

    :try_start_3
    iget-object v0, p0, Landroid/util/SynchronizedPool;->mPool:Landroid/util/Pool;

    invoke-interface {v0, p1}, Landroid/util/Pool;->release(Landroid/util/Poolable;)V

    monitor-exit v1

    return-void

    :catchall_a
    move-exception v0

    monitor-exit v1
    :try_end_c
    .catchall {:try_start_3 .. :try_end_c} :catchall_a

    throw v0
.end method
