.class public abstract Landroid/animation/AnimatorListenerAdapter;
.super Ljava/lang/Object;
.source "AnimatorListenerAdapter.java"

# interfaces
.implements Landroid/animation/Animator$AnimatorListener;


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 24
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationCancel(Landroid/animation/Animator;)V
    .registers 2
    .parameter "animation"

    .prologue
    .line 31
    return-void
.end method

.method public onAnimationEnd(Landroid/animation/Animator;)V
    .registers 2
    .parameter "animation"

    .prologue
    .line 38
    return-void
.end method

.method public onAnimationRepeat(Landroid/animation/Animator;)V
    .registers 2
    .parameter "animation"

    .prologue
    .line 45
    return-void
.end method

.method public onAnimationStart(Landroid/animation/Animator;)V
    .registers 2
    .parameter "animation"

    .prologue
    .line 52
    return-void
.end method
