.class public abstract Landroid/util/Singleton;
.super Ljava/lang/Object;
.source "Singleton.java"


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
.field private mInstance:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .local p0, this:Landroid/util/Singleton;,"Landroid/util/Singleton<TT;>;"
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method protected abstract create()Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation
.end method

.method public final get()Ljava/lang/Object;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .local p0, this:Landroid/util/Singleton;,"Landroid/util/Singleton<TT;>;"
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroid/util/Singleton;->mInstance:Ljava/lang/Object;

    if-nez v0, :cond_b

    invoke-virtual {p0}, Landroid/util/Singleton;->create()Ljava/lang/Object;

    move-result-object v0

    iput-object v0, p0, Landroid/util/Singleton;->mInstance:Ljava/lang/Object;

    :cond_b
    iget-object v0, p0, Landroid/util/Singleton;->mInstance:Ljava/lang/Object;

    monitor-exit p0

    return-object v0

    :catchall_f
    move-exception v0

    monitor-exit p0
    :try_end_11
    .catchall {:try_start_1 .. :try_end_11} :catchall_f

    throw v0
.end method
