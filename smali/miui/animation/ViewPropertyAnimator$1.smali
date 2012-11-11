.class Lmiui/animation/ViewPropertyAnimator$1;
.super Ljava/lang/Object;
.source "ViewPropertyAnimator.java"

# interfaces
.implements Landroid/animation/Animator$AnimatorListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lmiui/animation/ViewPropertyAnimator;-><init>(Landroid/view/View;IFF)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lmiui/animation/ViewPropertyAnimator;


# direct methods
.method constructor <init>(Lmiui/animation/ViewPropertyAnimator;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Lmiui/animation/ViewPropertyAnimator$1;->this$0:Lmiui/animation/ViewPropertyAnimator;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationCancel(Landroid/animation/Animator;)V
    .registers 7
    .parameter "animation"

    .prologue
    iget-object v3, p0, Lmiui/animation/ViewPropertyAnimator$1;->this$0:Lmiui/animation/ViewPropertyAnimator;

    #getter for: Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;
    invoke-static {v3}, Lmiui/animation/ViewPropertyAnimator;->access$000(Lmiui/animation/ViewPropertyAnimator;)Landroid/view/View;

    move-result-object v3

    const/4 v4, 0x0

    #calls: Lmiui/animation/ViewPropertyAnimator;->setAnimator(Landroid/view/View;Landroid/animation/Animator;)V
    invoke-static {v3, v4}, Lmiui/animation/ViewPropertyAnimator;->access$100(Landroid/view/View;Landroid/animation/Animator;)V

    iget-object v3, p0, Lmiui/animation/ViewPropertyAnimator$1;->this$0:Lmiui/animation/ViewPropertyAnimator;

    #calls: Lmiui/animation/ViewPropertyAnimator;->setFinalValues()V
    invoke-static {v3}, Lmiui/animation/ViewPropertyAnimator;->access$200(Lmiui/animation/ViewPropertyAnimator;)V

    iget-object v3, p0, Lmiui/animation/ViewPropertyAnimator$1;->this$0:Lmiui/animation/ViewPropertyAnimator;

    invoke-virtual {v3}, Lmiui/animation/ViewPropertyAnimator;->getListeners()Ljava/util/ArrayList;

    move-result-object v2

    .local v2, listeners:Ljava/util/ArrayList;,"Ljava/util/ArrayList<*>;"
    if-eqz v2, :cond_33

    invoke-virtual {v2}, Ljava/util/ArrayList;->clone()Ljava/lang/Object;

    move-result-object v2

    .end local v2           #listeners:Ljava/util/ArrayList;,"Ljava/util/ArrayList<*>;"
    check-cast v2, Ljava/util/ArrayList;

    .restart local v2       #listeners:Ljava/util/ArrayList;,"Ljava/util/ArrayList<*>;"
    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :goto_21
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_33

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    .local v1, listener:Ljava/lang/Object;
    check-cast v1, Landroid/animation/Animator$AnimatorListener;

    .end local v1           #listener:Ljava/lang/Object;
    iget-object v3, p0, Lmiui/animation/ViewPropertyAnimator$1;->this$0:Lmiui/animation/ViewPropertyAnimator;

    invoke-interface {v1, v3}, Landroid/animation/Animator$AnimatorListener;->onAnimationCancel(Landroid/animation/Animator;)V

    goto :goto_21

    .end local v0           #i$:Ljava/util/Iterator;
    :cond_33
    return-void
.end method

.method public onAnimationEnd(Landroid/animation/Animator;)V
    .registers 7
    .parameter "animation"

    .prologue
    iget-object v3, p0, Lmiui/animation/ViewPropertyAnimator$1;->this$0:Lmiui/animation/ViewPropertyAnimator;

    #getter for: Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;
    invoke-static {v3}, Lmiui/animation/ViewPropertyAnimator;->access$000(Lmiui/animation/ViewPropertyAnimator;)Landroid/view/View;

    move-result-object v3

    const/4 v4, 0x0

    #calls: Lmiui/animation/ViewPropertyAnimator;->setAnimator(Landroid/view/View;Landroid/animation/Animator;)V
    invoke-static {v3, v4}, Lmiui/animation/ViewPropertyAnimator;->access$100(Landroid/view/View;Landroid/animation/Animator;)V

    iget-object v3, p0, Lmiui/animation/ViewPropertyAnimator$1;->this$0:Lmiui/animation/ViewPropertyAnimator;

    #calls: Lmiui/animation/ViewPropertyAnimator;->setFinalValues()V
    invoke-static {v3}, Lmiui/animation/ViewPropertyAnimator;->access$200(Lmiui/animation/ViewPropertyAnimator;)V

    iget-object v3, p0, Lmiui/animation/ViewPropertyAnimator$1;->this$0:Lmiui/animation/ViewPropertyAnimator;

    invoke-virtual {v3}, Lmiui/animation/ViewPropertyAnimator;->getListeners()Ljava/util/ArrayList;

    move-result-object v2

    .local v2, listeners:Ljava/util/ArrayList;,"Ljava/util/ArrayList<*>;"
    if-eqz v2, :cond_33

    invoke-virtual {v2}, Ljava/util/ArrayList;->clone()Ljava/lang/Object;

    move-result-object v2

    .end local v2           #listeners:Ljava/util/ArrayList;,"Ljava/util/ArrayList<*>;"
    check-cast v2, Ljava/util/ArrayList;

    .restart local v2       #listeners:Ljava/util/ArrayList;,"Ljava/util/ArrayList<*>;"
    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :goto_21
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_33

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    .local v1, listener:Ljava/lang/Object;
    check-cast v1, Landroid/animation/Animator$AnimatorListener;

    .end local v1           #listener:Ljava/lang/Object;
    iget-object v3, p0, Lmiui/animation/ViewPropertyAnimator$1;->this$0:Lmiui/animation/ViewPropertyAnimator;

    invoke-interface {v1, v3}, Landroid/animation/Animator$AnimatorListener;->onAnimationEnd(Landroid/animation/Animator;)V

    goto :goto_21

    .end local v0           #i$:Ljava/util/Iterator;
    :cond_33
    return-void
.end method

.method public onAnimationRepeat(Landroid/animation/Animator;)V
    .registers 6
    .parameter "animation"

    .prologue
    iget-object v3, p0, Lmiui/animation/ViewPropertyAnimator$1;->this$0:Lmiui/animation/ViewPropertyAnimator;

    invoke-virtual {v3}, Lmiui/animation/ViewPropertyAnimator;->getListeners()Ljava/util/ArrayList;

    move-result-object v2

    .local v2, listeners:Ljava/util/ArrayList;,"Ljava/util/ArrayList<*>;"
    if-eqz v2, :cond_24

    invoke-virtual {v2}, Ljava/util/ArrayList;->clone()Ljava/lang/Object;

    move-result-object v2

    .end local v2           #listeners:Ljava/util/ArrayList;,"Ljava/util/ArrayList<*>;"
    check-cast v2, Ljava/util/ArrayList;

    .restart local v2       #listeners:Ljava/util/ArrayList;,"Ljava/util/ArrayList<*>;"
    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :goto_12
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_24

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    .local v1, listener:Ljava/lang/Object;
    check-cast v1, Landroid/animation/Animator$AnimatorListener;

    .end local v1           #listener:Ljava/lang/Object;
    iget-object v3, p0, Lmiui/animation/ViewPropertyAnimator$1;->this$0:Lmiui/animation/ViewPropertyAnimator;

    invoke-interface {v1, v3}, Landroid/animation/Animator$AnimatorListener;->onAnimationRepeat(Landroid/animation/Animator;)V

    goto :goto_12

    .end local v0           #i$:Ljava/util/Iterator;
    :cond_24
    return-void
.end method

.method public onAnimationStart(Landroid/animation/Animator;)V
    .registers 6
    .parameter "animation"

    .prologue
    iget-object v3, p0, Lmiui/animation/ViewPropertyAnimator$1;->this$0:Lmiui/animation/ViewPropertyAnimator;

    invoke-virtual {v3}, Lmiui/animation/ViewPropertyAnimator;->getListeners()Ljava/util/ArrayList;

    move-result-object v2

    .local v2, listeners:Ljava/util/ArrayList;,"Ljava/util/ArrayList<*>;"
    if-eqz v2, :cond_24

    invoke-virtual {v2}, Ljava/util/ArrayList;->clone()Ljava/lang/Object;

    move-result-object v2

    .end local v2           #listeners:Ljava/util/ArrayList;,"Ljava/util/ArrayList<*>;"
    check-cast v2, Ljava/util/ArrayList;

    .restart local v2       #listeners:Ljava/util/ArrayList;,"Ljava/util/ArrayList<*>;"
    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :goto_12
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_24

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    .local v1, listener:Ljava/lang/Object;
    check-cast v1, Landroid/animation/Animator$AnimatorListener;

    .end local v1           #listener:Ljava/lang/Object;
    iget-object v3, p0, Lmiui/animation/ViewPropertyAnimator$1;->this$0:Lmiui/animation/ViewPropertyAnimator;

    invoke-interface {v1, v3}, Landroid/animation/Animator$AnimatorListener;->onAnimationStart(Landroid/animation/Animator;)V

    goto :goto_12

    .end local v0           #i$:Ljava/util/Iterator;
    :cond_24
    return-void
.end method
