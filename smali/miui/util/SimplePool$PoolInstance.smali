.class public Lmiui/util/SimplePool$PoolInstance;
.super Ljava/lang/Object;
.source "SimplePool.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/util/SimplePool;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PoolInstance"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private mElements:[Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "[TT;"
        }
    .end annotation
.end field

.field private mIndex:I

.field private mManager:Lmiui/util/SimplePool$Manager;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lmiui/util/SimplePool$Manager",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lmiui/util/SimplePool$Manager;I)V
    .registers 5
    .parameter
    .parameter "size"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lmiui/util/SimplePool$Manager",
            "<TT;>;I)V"
        }
    .end annotation

    .prologue
    .line 19
    .local p0, this:Lmiui/util/SimplePool$PoolInstance;,"Lmiui/util/SimplePool$PoolInstance<TT;>;"
    .local p1, manager:Lmiui/util/SimplePool$Manager;,"Lmiui/util/SimplePool$Manager<TT;>;"
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 20
    iput-object p1, p0, Lmiui/util/SimplePool$PoolInstance;->mManager:Lmiui/util/SimplePool$Manager;

    .line 22
    const-class v1, Ljava/lang/Object;

    invoke-static {v1, p2}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Ljava/lang/Object;

    move-object v0, v1

    check-cast v0, [Ljava/lang/Object;

    .line 23
    .local v0, elements:[Ljava/lang/Object;,"[TT;"
    iput-object v0, p0, Lmiui/util/SimplePool$PoolInstance;->mElements:[Ljava/lang/Object;

    .line 24
    const/4 v1, -0x1

    iput v1, p0, Lmiui/util/SimplePool$PoolInstance;->mIndex:I

    .line 25
    return-void
.end method


# virtual methods
.method public acquire()Ljava/lang/Object;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 28
    .local p0, this:Lmiui/util/SimplePool$PoolInstance;,"Lmiui/util/SimplePool$PoolInstance<TT;>;"
    const/4 v0, 0x0

    .line 29
    .local v0, element:Ljava/lang/Object;,"TT;"
    monitor-enter p0

    .line 30
    :try_start_2
    iget v1, p0, Lmiui/util/SimplePool$PoolInstance;->mIndex:I

    if-ltz v1, :cond_17

    .line 31
    iget-object v1, p0, Lmiui/util/SimplePool$PoolInstance;->mElements:[Ljava/lang/Object;

    iget v2, p0, Lmiui/util/SimplePool$PoolInstance;->mIndex:I

    aget-object v0, v1, v2

    .line 32
    iget-object v1, p0, Lmiui/util/SimplePool$PoolInstance;->mElements:[Ljava/lang/Object;

    iget v2, p0, Lmiui/util/SimplePool$PoolInstance;->mIndex:I

    add-int/lit8 v3, v2, -0x1

    iput v3, p0, Lmiui/util/SimplePool$PoolInstance;->mIndex:I

    const/4 v3, 0x0

    aput-object v3, v1, v2

    .line 34
    .end local v0           #element:Ljava/lang/Object;,"TT;"
    :cond_17
    monitor-exit p0
    :try_end_18
    .catchall {:try_start_2 .. :try_end_18} :catchall_26

    .line 35
    if-nez v0, :cond_20

    .line 36
    iget-object v1, p0, Lmiui/util/SimplePool$PoolInstance;->mManager:Lmiui/util/SimplePool$Manager;

    invoke-virtual {v1}, Lmiui/util/SimplePool$Manager;->createInstance()Ljava/lang/Object;

    move-result-object v0

    .line 38
    :cond_20
    iget-object v1, p0, Lmiui/util/SimplePool$PoolInstance;->mManager:Lmiui/util/SimplePool$Manager;

    invoke-virtual {v1, v0}, Lmiui/util/SimplePool$Manager;->onAcquire(Ljava/lang/Object;)V

    .line 39
    return-object v0

    .line 34
    :catchall_26
    move-exception v1

    :try_start_27
    monitor-exit p0
    :try_end_28
    .catchall {:try_start_27 .. :try_end_28} :catchall_26

    throw v1
.end method

.method public release(Ljava/lang/Object;)V
    .registers 4
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 43
    .local p0, this:Lmiui/util/SimplePool$PoolInstance;,"Lmiui/util/SimplePool$PoolInstance<TT;>;"
    .local p1, element:Ljava/lang/Object;,"TT;"
    iget-object v0, p0, Lmiui/util/SimplePool$PoolInstance;->mManager:Lmiui/util/SimplePool$Manager;

    invoke-virtual {v0, p1}, Lmiui/util/SimplePool$Manager;->onRelease(Ljava/lang/Object;)V

    .line 44
    monitor-enter p0

    .line 45
    :try_start_6
    iget v0, p0, Lmiui/util/SimplePool$PoolInstance;->mIndex:I

    add-int/lit8 v0, v0, 0x1

    iget-object v1, p0, Lmiui/util/SimplePool$PoolInstance;->mElements:[Ljava/lang/Object;

    array-length v1, v1

    if-ge v0, v1, :cond_19

    .line 46
    iget-object v0, p0, Lmiui/util/SimplePool$PoolInstance;->mElements:[Ljava/lang/Object;

    iget v1, p0, Lmiui/util/SimplePool$PoolInstance;->mIndex:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lmiui/util/SimplePool$PoolInstance;->mIndex:I

    aput-object p1, v0, v1

    .line 48
    :cond_19
    monitor-exit p0

    .line 49
    return-void

    .line 48
    :catchall_1b
    move-exception v0

    monitor-exit p0
    :try_end_1d
    .catchall {:try_start_6 .. :try_end_1d} :catchall_1b

    throw v0
.end method
