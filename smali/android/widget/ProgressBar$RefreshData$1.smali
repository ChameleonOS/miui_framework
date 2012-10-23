.class final Landroid/widget/ProgressBar$RefreshData$1;
.super Ljava/lang/Object;
.source "ProgressBar.java"

# interfaces
.implements Landroid/util/PoolableManager;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/ProgressBar$RefreshData;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/util/PoolableManager",
        "<",
        "Landroid/widget/ProgressBar$RefreshData;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 594
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic newInstance()Landroid/util/Poolable;
    .registers 2

    .prologue
    .line 594
    invoke-virtual {p0}, Landroid/widget/ProgressBar$RefreshData$1;->newInstance()Landroid/widget/ProgressBar$RefreshData;

    move-result-object v0

    return-object v0
.end method

.method public newInstance()Landroid/widget/ProgressBar$RefreshData;
    .registers 3

    .prologue
    .line 597
    new-instance v0, Landroid/widget/ProgressBar$RefreshData;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Landroid/widget/ProgressBar$RefreshData;-><init>(Landroid/widget/ProgressBar$1;)V

    return-object v0
.end method

.method public bridge synthetic onAcquired(Landroid/util/Poolable;)V
    .registers 2
    .parameter "x0"

    .prologue
    .line 594
    check-cast p1, Landroid/widget/ProgressBar$RefreshData;

    .end local p1
    invoke-virtual {p0, p1}, Landroid/widget/ProgressBar$RefreshData$1;->onAcquired(Landroid/widget/ProgressBar$RefreshData;)V

    return-void
.end method

.method public onAcquired(Landroid/widget/ProgressBar$RefreshData;)V
    .registers 2
    .parameter "element"

    .prologue
    .line 602
    return-void
.end method

.method public bridge synthetic onReleased(Landroid/util/Poolable;)V
    .registers 2
    .parameter "x0"

    .prologue
    .line 594
    check-cast p1, Landroid/widget/ProgressBar$RefreshData;

    .end local p1
    invoke-virtual {p0, p1}, Landroid/widget/ProgressBar$RefreshData$1;->onReleased(Landroid/widget/ProgressBar$RefreshData;)V

    return-void
.end method

.method public onReleased(Landroid/widget/ProgressBar$RefreshData;)V
    .registers 2
    .parameter "element"

    .prologue
    .line 606
    return-void
.end method
