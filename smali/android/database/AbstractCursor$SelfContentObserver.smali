.class public Landroid/database/AbstractCursor$SelfContentObserver;
.super Landroid/database/ContentObserver;
.source "AbstractCursor.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/database/AbstractCursor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xc
    name = "SelfContentObserver"
.end annotation


# instance fields
.field mCursor:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Landroid/database/AbstractCursor;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/database/AbstractCursor;)V
    .registers 3
    .parameter "cursor"

    .prologue
    .line 436
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroid/database/ContentObserver;-><init>(Landroid/os/Handler;)V

    .line 437
    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Landroid/database/AbstractCursor$SelfContentObserver;->mCursor:Ljava/lang/ref/WeakReference;

    .line 438
    return-void
.end method


# virtual methods
.method public deliverSelfNotifications()Z
    .registers 2

    .prologue
    .line 442
    const/4 v0, 0x0

    return v0
.end method

.method public onChange(Z)V
    .registers 4
    .parameter "selfChange"

    .prologue
    .line 447
    iget-object v1, p0, Landroid/database/AbstractCursor$SelfContentObserver;->mCursor:Ljava/lang/ref/WeakReference;

    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/database/AbstractCursor;

    .line 448
    .local v0, cursor:Landroid/database/AbstractCursor;
    if-eqz v0, :cond_e

    .line 449
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/database/AbstractCursor;->onChange(Z)V

    .line 451
    :cond_e
    return-void
.end method
