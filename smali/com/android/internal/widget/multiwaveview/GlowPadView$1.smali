.class Lcom/android/internal/widget/multiwaveview/GlowPadView$1;
.super Landroid/animation/AnimatorListenerAdapter;
.source "GlowPadView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/widget/multiwaveview/GlowPadView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/internal/widget/multiwaveview/GlowPadView;


# direct methods
.method constructor <init>(Lcom/android/internal/widget/multiwaveview/GlowPadView;)V
    .registers 2
    .parameter

    .prologue
    .line 172
    iput-object p1, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView$1;->this$0:Lcom/android/internal/widget/multiwaveview/GlowPadView;

    invoke-direct {p0}, Landroid/animation/AnimatorListenerAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/animation/Animator;)V
    .registers 6
    .parameter "animator"

    .prologue
    .line 174
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView$1;->this$0:Lcom/android/internal/widget/multiwaveview/GlowPadView;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView$1;->this$0:Lcom/android/internal/widget/multiwaveview/GlowPadView;

    iget v2, v2, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mWaveCenterX:F

    iget-object v3, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView$1;->this$0:Lcom/android/internal/widget/multiwaveview/GlowPadView;

    iget v3, v3, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mWaveCenterY:F

    invoke-virtual {v0, v1, v2, v3}, Lcom/android/internal/widget/multiwaveview/GlowPadView;->switchToState(IFF)V

    .line 175
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView$1;->this$0:Lcom/android/internal/widget/multiwaveview/GlowPadView;

    #calls: Lcom/android/internal/widget/multiwaveview/GlowPadView;->dispatchOnFinishFinalAnimation()V
    invoke-static {v0}, Lcom/android/internal/widget/multiwaveview/GlowPadView;->access$000(Lcom/android/internal/widget/multiwaveview/GlowPadView;)V

    .line 176
    return-void
.end method
