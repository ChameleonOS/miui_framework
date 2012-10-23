.class Lmiui/animation/ViewPropertyAnimator$2;
.super Ljava/lang/Object;
.source "ViewPropertyAnimator.java"

# interfaces
.implements Landroid/animation/ValueAnimator$AnimatorUpdateListener;


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
    .line 159
    iput-object p1, p0, Lmiui/animation/ViewPropertyAnimator$2;->this$0:Lmiui/animation/ViewPropertyAnimator;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationUpdate(Landroid/animation/ValueAnimator;)V
    .registers 7
    .parameter "animation"

    .prologue
    .line 162
    iget-object v0, p0, Lmiui/animation/ViewPropertyAnimator$2;->this$0:Lmiui/animation/ViewPropertyAnimator;

    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator$2;->this$0:Lmiui/animation/ViewPropertyAnimator;

    #getter for: Lmiui/animation/ViewPropertyAnimator;->mFromValue:F
    invoke-static {v1}, Lmiui/animation/ViewPropertyAnimator;->access$300(Lmiui/animation/ViewPropertyAnimator;)F

    move-result v1

    invoke-virtual {p1}, Landroid/animation/ValueAnimator;->getAnimatedFraction()F

    move-result v2

    iget-object v3, p0, Lmiui/animation/ViewPropertyAnimator$2;->this$0:Lmiui/animation/ViewPropertyAnimator;

    #getter for: Lmiui/animation/ViewPropertyAnimator;->mToValue:F
    invoke-static {v3}, Lmiui/animation/ViewPropertyAnimator;->access$400(Lmiui/animation/ViewPropertyAnimator;)F

    move-result v3

    iget-object v4, p0, Lmiui/animation/ViewPropertyAnimator$2;->this$0:Lmiui/animation/ViewPropertyAnimator;

    #getter for: Lmiui/animation/ViewPropertyAnimator;->mFromValue:F
    invoke-static {v4}, Lmiui/animation/ViewPropertyAnimator;->access$300(Lmiui/animation/ViewPropertyAnimator;)F

    move-result v4

    sub-float/2addr v3, v4

    mul-float/2addr v2, v3

    add-float/2addr v1, v2

    #calls: Lmiui/animation/ViewPropertyAnimator;->setValue(F)V
    invoke-static {v0, v1}, Lmiui/animation/ViewPropertyAnimator;->access$500(Lmiui/animation/ViewPropertyAnimator;F)V

    .line 163
    return-void
.end method
