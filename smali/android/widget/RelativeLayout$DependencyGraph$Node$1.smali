.class final Landroid/widget/RelativeLayout$DependencyGraph$Node$1;
.super Ljava/lang/Object;
.source "RelativeLayout.java"

# interfaces
.implements Landroid/util/PoolableManager;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/RelativeLayout$DependencyGraph$Node;
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
        "Landroid/widget/RelativeLayout$DependencyGraph$Node;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 1472
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic newInstance()Landroid/util/Poolable;
    .registers 2

    .prologue
    .line 1472
    invoke-virtual {p0}, Landroid/widget/RelativeLayout$DependencyGraph$Node$1;->newInstance()Landroid/widget/RelativeLayout$DependencyGraph$Node;

    move-result-object v0

    return-object v0
.end method

.method public newInstance()Landroid/widget/RelativeLayout$DependencyGraph$Node;
    .registers 2

    .prologue
    .line 1474
    new-instance v0, Landroid/widget/RelativeLayout$DependencyGraph$Node;

    invoke-direct {v0}, Landroid/widget/RelativeLayout$DependencyGraph$Node;-><init>()V

    return-object v0
.end method

.method public bridge synthetic onAcquired(Landroid/util/Poolable;)V
    .registers 2
    .parameter "x0"

    .prologue
    .line 1472
    check-cast p1, Landroid/widget/RelativeLayout$DependencyGraph$Node;

    .end local p1
    invoke-virtual {p0, p1}, Landroid/widget/RelativeLayout$DependencyGraph$Node$1;->onAcquired(Landroid/widget/RelativeLayout$DependencyGraph$Node;)V

    return-void
.end method

.method public onAcquired(Landroid/widget/RelativeLayout$DependencyGraph$Node;)V
    .registers 2
    .parameter "element"

    .prologue
    .line 1478
    return-void
.end method

.method public bridge synthetic onReleased(Landroid/util/Poolable;)V
    .registers 2
    .parameter "x0"

    .prologue
    .line 1472
    check-cast p1, Landroid/widget/RelativeLayout$DependencyGraph$Node;

    .end local p1
    invoke-virtual {p0, p1}, Landroid/widget/RelativeLayout$DependencyGraph$Node$1;->onReleased(Landroid/widget/RelativeLayout$DependencyGraph$Node;)V

    return-void
.end method

.method public onReleased(Landroid/widget/RelativeLayout$DependencyGraph$Node;)V
    .registers 2
    .parameter "element"

    .prologue
    .line 1481
    return-void
.end method
