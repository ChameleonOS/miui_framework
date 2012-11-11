.class public Lmiui/animation/ViewPropertyAnimator$Builder;
.super Lmiui/animation/AnimatorBuilder;
.source "ViewPropertyAnimator.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/animation/ViewPropertyAnimator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# direct methods
.method public constructor <init>(Lmiui/animation/ViewPropertyAnimator;)V
    .registers 2
    .parameter "animator"

    .prologue
    invoke-direct {p0, p1}, Lmiui/animation/AnimatorBuilder;-><init>(Landroid/animation/Animator;)V

    return-void
.end method


# virtual methods
.method public bridge synthetic addListener(Landroid/animation/Animator$AnimatorListener;)Lmiui/animation/AnimatorBuilder;
    .registers 3
    .parameter "x0"

    .prologue
    invoke-virtual {p0, p1}, Lmiui/animation/ViewPropertyAnimator$Builder;->addListener(Landroid/animation/Animator$AnimatorListener;)Lmiui/animation/ViewPropertyAnimator$Builder;

    move-result-object v0

    return-object v0
.end method

.method public addListener(Landroid/animation/Animator$AnimatorListener;)Lmiui/animation/ViewPropertyAnimator$Builder;
    .registers 3
    .parameter "listener"

    .prologue
    iget-object v0, p0, Lmiui/animation/AnimatorBuilder;->mAnimator:Landroid/animation/Animator;

    invoke-virtual {v0, p1}, Landroid/animation/Animator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    return-object p0
.end method

.method public bridge synthetic setDuration(J)Lmiui/animation/AnimatorBuilder;
    .registers 4
    .parameter "x0"

    .prologue
    invoke-virtual {p0, p1, p2}, Lmiui/animation/ViewPropertyAnimator$Builder;->setDuration(J)Lmiui/animation/ViewPropertyAnimator$Builder;

    move-result-object v0

    return-object v0
.end method

.method public setDuration(J)Lmiui/animation/ViewPropertyAnimator$Builder;
    .registers 4
    .parameter "duration"

    .prologue
    iget-object v0, p0, Lmiui/animation/AnimatorBuilder;->mAnimator:Landroid/animation/Animator;

    invoke-virtual {v0, p1, p2}, Landroid/animation/Animator;->setDuration(J)Landroid/animation/Animator;

    return-object p0
.end method

.method public setFinalValue(F)Lmiui/animation/ViewPropertyAnimator$Builder;
    .registers 3
    .parameter "value"

    .prologue
    iget-object v0, p0, Lmiui/animation/AnimatorBuilder;->mAnimator:Landroid/animation/Animator;

    check-cast v0, Lmiui/animation/ViewPropertyAnimator;

    invoke-virtual {v0, p1}, Lmiui/animation/ViewPropertyAnimator;->setFinalValue(F)V

    return-object p0
.end method

.method public setFinalVisibility(I)Lmiui/animation/ViewPropertyAnimator$Builder;
    .registers 3
    .parameter "visibility"

    .prologue
    iget-object v0, p0, Lmiui/animation/AnimatorBuilder;->mAnimator:Landroid/animation/Animator;

    check-cast v0, Lmiui/animation/ViewPropertyAnimator;

    invoke-virtual {v0, p1}, Lmiui/animation/ViewPropertyAnimator;->setFinalVisibility(I)V

    return-object p0
.end method

.method public bridge synthetic setInterpolator(Landroid/animation/TimeInterpolator;)Lmiui/animation/AnimatorBuilder;
    .registers 3
    .parameter "x0"

    .prologue
    invoke-virtual {p0, p1}, Lmiui/animation/ViewPropertyAnimator$Builder;->setInterpolator(Landroid/animation/TimeInterpolator;)Lmiui/animation/ViewPropertyAnimator$Builder;

    move-result-object v0

    return-object v0
.end method

.method public setInterpolator(Landroid/animation/TimeInterpolator;)Lmiui/animation/ViewPropertyAnimator$Builder;
    .registers 3
    .parameter "value"

    .prologue
    iget-object v0, p0, Lmiui/animation/AnimatorBuilder;->mAnimator:Landroid/animation/Animator;

    invoke-virtual {v0, p1}, Landroid/animation/Animator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    return-object p0
.end method

.method public setRepeatCount(I)Lmiui/animation/ViewPropertyAnimator$Builder;
    .registers 3
    .parameter "value"

    .prologue
    iget-object v0, p0, Lmiui/animation/AnimatorBuilder;->mAnimator:Landroid/animation/Animator;

    check-cast v0, Lmiui/animation/ViewPropertyAnimator;

    invoke-virtual {v0, p1}, Lmiui/animation/ViewPropertyAnimator;->setRepeatCount(I)V

    return-object p0
.end method

.method public setRepeatMode(I)Lmiui/animation/ViewPropertyAnimator$Builder;
    .registers 3
    .parameter "value"

    .prologue
    iget-object v0, p0, Lmiui/animation/AnimatorBuilder;->mAnimator:Landroid/animation/Animator;

    check-cast v0, Lmiui/animation/ViewPropertyAnimator;

    invoke-virtual {v0, p1}, Lmiui/animation/ViewPropertyAnimator;->setRepeatMode(I)V

    return-object p0
.end method

.method public bridge synthetic setStartDelay(J)Lmiui/animation/AnimatorBuilder;
    .registers 4
    .parameter "x0"

    .prologue
    invoke-virtual {p0, p1, p2}, Lmiui/animation/ViewPropertyAnimator$Builder;->setStartDelay(J)Lmiui/animation/ViewPropertyAnimator$Builder;

    move-result-object v0

    return-object v0
.end method

.method public setStartDelay(J)Lmiui/animation/ViewPropertyAnimator$Builder;
    .registers 4
    .parameter "startDelay"

    .prologue
    iget-object v0, p0, Lmiui/animation/AnimatorBuilder;->mAnimator:Landroid/animation/Animator;

    invoke-virtual {v0, p1, p2}, Landroid/animation/Animator;->setStartDelay(J)V

    return-object p0
.end method
