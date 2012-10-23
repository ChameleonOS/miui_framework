.class Landroid/view/AccessibilityInteractionController$1;
.super Ljava/lang/Object;
.source "AccessibilityInteractionController.java"

# interfaces
.implements Landroid/util/PoolableManager;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/view/AccessibilityInteractionController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/util/PoolableManager",
        "<",
        "Landroid/view/AccessibilityInteractionController$SomeArgs;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Landroid/view/AccessibilityInteractionController;


# direct methods
.method constructor <init>(Landroid/view/AccessibilityInteractionController;)V
    .registers 2
    .parameter

    .prologue
    .line 80
    iput-object p1, p0, Landroid/view/AccessibilityInteractionController$1;->this$0:Landroid/view/AccessibilityInteractionController;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic newInstance()Landroid/util/Poolable;
    .registers 2

    .prologue
    .line 80
    invoke-virtual {p0}, Landroid/view/AccessibilityInteractionController$1;->newInstance()Landroid/view/AccessibilityInteractionController$SomeArgs;

    move-result-object v0

    return-object v0
.end method

.method public newInstance()Landroid/view/AccessibilityInteractionController$SomeArgs;
    .registers 4

    .prologue
    .line 82
    new-instance v0, Landroid/view/AccessibilityInteractionController$SomeArgs;

    iget-object v1, p0, Landroid/view/AccessibilityInteractionController$1;->this$0:Landroid/view/AccessibilityInteractionController;

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Landroid/view/AccessibilityInteractionController$SomeArgs;-><init>(Landroid/view/AccessibilityInteractionController;Landroid/view/AccessibilityInteractionController$1;)V

    return-object v0
.end method

.method public bridge synthetic onAcquired(Landroid/util/Poolable;)V
    .registers 2
    .parameter "x0"

    .prologue
    .line 80
    check-cast p1, Landroid/view/AccessibilityInteractionController$SomeArgs;

    .end local p1
    invoke-virtual {p0, p1}, Landroid/view/AccessibilityInteractionController$1;->onAcquired(Landroid/view/AccessibilityInteractionController$SomeArgs;)V

    return-void
.end method

.method public onAcquired(Landroid/view/AccessibilityInteractionController$SomeArgs;)V
    .registers 2
    .parameter "info"

    .prologue
    .line 87
    return-void
.end method

.method public bridge synthetic onReleased(Landroid/util/Poolable;)V
    .registers 2
    .parameter "x0"

    .prologue
    .line 80
    check-cast p1, Landroid/view/AccessibilityInteractionController$SomeArgs;

    .end local p1
    invoke-virtual {p0, p1}, Landroid/view/AccessibilityInteractionController$1;->onReleased(Landroid/view/AccessibilityInteractionController$SomeArgs;)V

    return-void
.end method

.method public onReleased(Landroid/view/AccessibilityInteractionController$SomeArgs;)V
    .registers 2
    .parameter "info"

    .prologue
    .line 90
    #calls: Landroid/view/AccessibilityInteractionController$SomeArgs;->clear()V
    invoke-static {p1}, Landroid/view/AccessibilityInteractionController$SomeArgs;->access$200(Landroid/view/AccessibilityInteractionController$SomeArgs;)V

    .line 91
    return-void
.end method
