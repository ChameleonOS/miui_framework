.class public abstract Landroid/database/Observable;
.super Ljava/lang/Object;
.source "Observable.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field protected final mObservers:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 29
    .local p0, this:Landroid/database/Observable;,"Landroid/database/Observable<TT;>;"
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 34
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/database/Observable;->mObservers:Ljava/util/ArrayList;

    return-void
.end method


# virtual methods
.method public registerObserver(Ljava/lang/Object;)V
    .registers 6
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 44
    .local p0, this:Landroid/database/Observable;,"Landroid/database/Observable<TT;>;"
    .local p1, observer:Ljava/lang/Object;,"TT;"
    if-nez p1, :cond_a

    .line 45
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "The observer is null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 47
    :cond_a
    iget-object v1, p0, Landroid/database/Observable;->mObservers:Ljava/util/ArrayList;

    monitor-enter v1

    .line 48
    :try_start_d
    iget-object v0, p0, Landroid/database/Observable;->mObservers:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_37

    .line 49
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Observer "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " is already registered."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 52
    :catchall_34
    move-exception v0

    monitor-exit v1
    :try_end_36
    .catchall {:try_start_d .. :try_end_36} :catchall_34

    throw v0

    .line 51
    :cond_37
    :try_start_37
    iget-object v0, p0, Landroid/database/Observable;->mObservers:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 52
    monitor-exit v1
    :try_end_3d
    .catchall {:try_start_37 .. :try_end_3d} :catchall_34

    .line 53
    return-void
.end method

.method public unregisterAll()V
    .registers 3

    .prologue
    .line 79
    .local p0, this:Landroid/database/Observable;,"Landroid/database/Observable<TT;>;"
    iget-object v1, p0, Landroid/database/Observable;->mObservers:Ljava/util/ArrayList;

    monitor-enter v1

    .line 80
    :try_start_3
    iget-object v0, p0, Landroid/database/Observable;->mObservers:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 81
    monitor-exit v1

    .line 82
    return-void

    .line 81
    :catchall_a
    move-exception v0

    monitor-exit v1
    :try_end_c
    .catchall {:try_start_3 .. :try_end_c} :catchall_a

    throw v0
.end method

.method public unregisterObserver(Ljava/lang/Object;)V
    .registers 7
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 63
    .local p0, this:Landroid/database/Observable;,"Landroid/database/Observable<TT;>;"
    .local p1, observer:Ljava/lang/Object;,"TT;"
    if-nez p1, :cond_a

    .line 64
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "The observer is null."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 66
    :cond_a
    iget-object v2, p0, Landroid/database/Observable;->mObservers:Ljava/util/ArrayList;

    monitor-enter v2

    .line 67
    :try_start_d
    iget-object v1, p0, Landroid/database/Observable;->mObservers:Ljava/util/ArrayList;

    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v0

    .line 68
    .local v0, index:I
    const/4 v1, -0x1

    if-ne v0, v1, :cond_38

    .line 69
    new-instance v1, Ljava/lang/IllegalStateException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Observer "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " was not registered."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 72
    .end local v0           #index:I
    :catchall_35
    move-exception v1

    monitor-exit v2
    :try_end_37
    .catchall {:try_start_d .. :try_end_37} :catchall_35

    throw v1

    .line 71
    .restart local v0       #index:I
    :cond_38
    :try_start_38
    iget-object v1, p0, Landroid/database/Observable;->mObservers:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 72
    monitor-exit v2
    :try_end_3e
    .catchall {:try_start_38 .. :try_end_3e} :catchall_35

    .line 73
    return-void
.end method
