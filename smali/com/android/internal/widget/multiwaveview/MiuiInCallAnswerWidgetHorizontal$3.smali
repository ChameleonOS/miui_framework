.class Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal$3;
.super Ljava/lang/Object;
.source "MiuiInCallAnswerWidgetHorizontal.java"

# interfaces
.implements Landroid/animation/ValueAnimator$AnimatorUpdateListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->startRightHintAnim()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;


# direct methods
.method constructor <init>(Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;)V
    .registers 2
    .parameter

    .prologue
    .line 504
    iput-object p1, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal$3;->this$0:Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationUpdate(Landroid/animation/ValueAnimator;)V
    .registers 6
    .parameter "animation"

    .prologue
    .line 507
    iget-object v2, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal$3;->this$0:Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;

    #getter for: Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mHintAnimation:Landroid/animation/ValueAnimator;
    invoke-static {v2}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->access$100(Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;)Landroid/animation/ValueAnimator;

    move-result-object v2

    invoke-virtual {v2}, Landroid/animation/ValueAnimator;->getAnimatedFraction()F

    move-result v1

    .line 508
    .local v1, value:F
    const/high16 v2, 0x42c8

    mul-float/2addr v2, v1

    const/high16 v3, 0x4160

    div-float/2addr v2, v3

    float-to-int v0, v2

    .line 509
    .local v0, i:I
    iget-object v2, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal$3;->this$0:Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;

    #calls: Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->showRightHintAnim(I)V
    invoke-static {v2, v0}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->access$200(Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;I)V

    .line 510
    return-void
.end method
