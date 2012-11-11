.class public Lmiui/animation/AnimatorBuilder;
.super Ljava/lang/Object;
.source "AnimatorBuilder.java"


# instance fields
.field protected mAnimator:Landroid/animation/Animator;


# direct methods
.method public constructor <init>(Landroid/animation/Animator;)V
    .registers 2
    .parameter "animator"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lmiui/animation/AnimatorBuilder;->mAnimator:Landroid/animation/Animator;

    return-void
.end method

.method public static of(Landroid/animation/Animator;)Lmiui/animation/AnimatorBuilder;
    .registers 2
    .parameter "animator"

    .prologue
    new-instance v0, Lmiui/animation/AnimatorBuilder;

    invoke-direct {v0, p0}, Lmiui/animation/AnimatorBuilder;-><init>(Landroid/animation/Animator;)V

    return-object v0
.end method

.method public static of(Lmiui/animation/ViewPropertyAnimator;)Lmiui/animation/ViewPropertyAnimator$Builder;
    .registers 2
    .parameter "animator"

    .prologue
    new-instance v0, Lmiui/animation/ViewPropertyAnimator$Builder;

    invoke-direct {v0, p0}, Lmiui/animation/ViewPropertyAnimator$Builder;-><init>(Lmiui/animation/ViewPropertyAnimator;)V

    return-object v0
.end method


# virtual methods
.method public addListener(Landroid/animation/Animator$AnimatorListener;)Lmiui/animation/AnimatorBuilder;
    .registers 3
    .parameter "listener"

    .prologue
    iget-object v0, p0, Lmiui/animation/AnimatorBuilder;->mAnimator:Landroid/animation/Animator;

    invoke-virtual {v0, p1}, Landroid/animation/Animator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    return-object p0
.end method

.method public animator()Landroid/animation/Animator;
    .registers 2

    .prologue
    iget-object v0, p0, Lmiui/animation/AnimatorBuilder;->mAnimator:Landroid/animation/Animator;

    return-object v0
.end method

.method public setDuration(J)Lmiui/animation/AnimatorBuilder;
    .registers 4
    .parameter "duration"

    .prologue
    iget-object v0, p0, Lmiui/animation/AnimatorBuilder;->mAnimator:Landroid/animation/Animator;

    invoke-virtual {v0, p1, p2}, Landroid/animation/Animator;->setDuration(J)Landroid/animation/Animator;

    return-object p0
.end method

.method public setInterpolator(Landroid/animation/TimeInterpolator;)Lmiui/animation/AnimatorBuilder;
    .registers 3
    .parameter "value"

    .prologue
    iget-object v0, p0, Lmiui/animation/AnimatorBuilder;->mAnimator:Landroid/animation/Animator;

    invoke-virtual {v0, p1}, Landroid/animation/Animator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    return-object p0
.end method

.method public setStartDelay(J)Lmiui/animation/AnimatorBuilder;
    .registers 4
    .parameter "startDelay"

    .prologue
    iget-object v0, p0, Lmiui/animation/AnimatorBuilder;->mAnimator:Landroid/animation/Animator;

    invoke-virtual {v0, p1, p2}, Landroid/animation/Animator;->setStartDelay(J)V

    return-object p0
.end method

.method public start()Landroid/animation/Animator;
    .registers 2

    .prologue
    iget-object v0, p0, Lmiui/animation/AnimatorBuilder;->mAnimator:Landroid/animation/Animator;

    invoke-virtual {v0}, Landroid/animation/Animator;->start()V

    iget-object v0, p0, Lmiui/animation/AnimatorBuilder;->mAnimator:Landroid/animation/Animator;

    return-object v0
.end method
