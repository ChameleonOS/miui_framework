.class Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;
.super Ljava/util/ArrayList;
.source "MultiWaveView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/widget/multiwaveview/MultiWaveView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "AnimationBundle"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/util/ArrayList",
        "<",
        "Lcom/android/internal/widget/multiwaveview/Tweener;",
        ">;"
    }
.end annotation


# static fields
.field private static final serialVersionUID:J = -0x57b2878d90ed8b98L


# instance fields
.field private mSuspended:Z

.field final synthetic this$0:Lcom/android/internal/widget/multiwaveview/MultiWaveView;


# direct methods
.method private constructor <init>(Lcom/android/internal/widget/multiwaveview/MultiWaveView;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->this$0:Lcom/android/internal/widget/multiwaveview/MultiWaveView;

    invoke-direct {p0}, Ljava/util/ArrayList;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/android/internal/widget/multiwaveview/MultiWaveView;Lcom/android/internal/widget/multiwaveview/MultiWaveView$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-direct {p0, p1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;-><init>(Lcom/android/internal/widget/multiwaveview/MultiWaveView;)V

    return-void
.end method


# virtual methods
.method public cancel()V
    .registers 5

    .prologue
    invoke-virtual {p0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->size()I

    move-result v1

    .local v1, count:I
    const/4 v2, 0x0

    .local v2, i:I
    :goto_5
    if-ge v2, v1, :cond_15

    invoke-virtual {p0, v2}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/internal/widget/multiwaveview/Tweener;

    .local v0, anim:Lcom/android/internal/widget/multiwaveview/Tweener;
    iget-object v3, v0, Lcom/android/internal/widget/multiwaveview/Tweener;->animator:Landroid/animation/ObjectAnimator;

    invoke-virtual {v3}, Landroid/animation/ObjectAnimator;->cancel()V

    add-int/lit8 v2, v2, 0x1

    goto :goto_5

    .end local v0           #anim:Lcom/android/internal/widget/multiwaveview/Tweener;
    :cond_15
    invoke-virtual {p0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->clear()V

    return-void
.end method

.method public setSuspended(Z)V
    .registers 2
    .parameter "suspend"

    .prologue
    iput-boolean p1, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->mSuspended:Z

    return-void
.end method

.method public start()V
    .registers 5

    .prologue
    iget-boolean v3, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->mSuspended:Z

    if-eqz v3, :cond_5

    :cond_4
    return-void

    :cond_5
    invoke-virtual {p0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->size()I

    move-result v1

    .local v1, count:I
    const/4 v2, 0x0

    .local v2, i:I
    :goto_a
    if-ge v2, v1, :cond_4

    invoke-virtual {p0, v2}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/internal/widget/multiwaveview/Tweener;

    .local v0, anim:Lcom/android/internal/widget/multiwaveview/Tweener;
    iget-object v3, v0, Lcom/android/internal/widget/multiwaveview/Tweener;->animator:Landroid/animation/ObjectAnimator;

    invoke-virtual {v3}, Landroid/animation/ObjectAnimator;->start()V

    add-int/lit8 v2, v2, 0x1

    goto :goto_a
.end method

.method public stop()V
    .registers 5

    .prologue
    invoke-virtual {p0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->size()I

    move-result v1

    .local v1, count:I
    const/4 v2, 0x0

    .local v2, i:I
    :goto_5
    if-ge v2, v1, :cond_15

    invoke-virtual {p0, v2}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/internal/widget/multiwaveview/Tweener;

    .local v0, anim:Lcom/android/internal/widget/multiwaveview/Tweener;
    iget-object v3, v0, Lcom/android/internal/widget/multiwaveview/Tweener;->animator:Landroid/animation/ObjectAnimator;

    invoke-virtual {v3}, Landroid/animation/ObjectAnimator;->end()V

    add-int/lit8 v2, v2, 0x1

    goto :goto_5

    .end local v0           #anim:Lcom/android/internal/widget/multiwaveview/Tweener;
    :cond_15
    invoke-virtual {p0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->clear()V

    return-void
.end method
