.class public Landroid/animation/TimeAnimator;
.super Landroid/animation/ValueAnimator;
.source "TimeAnimator.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/animation/TimeAnimator$TimeListener;
    }
.end annotation


# instance fields
.field private mListener:Landroid/animation/TimeAnimator$TimeListener;

.field private mPreviousTime:J


# direct methods
.method public constructor <init>()V
    .registers 3

    .prologue
    .line 10
    invoke-direct {p0}, Landroid/animation/ValueAnimator;-><init>()V

    .line 13
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Landroid/animation/TimeAnimator;->mPreviousTime:J

    .line 55
    return-void
.end method


# virtual methods
.method animateValue(F)V
    .registers 2
    .parameter "fraction"

    .prologue
    .line 39
    return-void
.end method

.method animationFrame(J)Z
    .registers 9
    .parameter "currentTime"

    .prologue
    const-wide/16 v4, 0x0

    .line 17
    iget-object v0, p0, Landroid/animation/TimeAnimator;->mListener:Landroid/animation/TimeAnimator$TimeListener;

    if-eqz v0, :cond_18

    .line 18
    iget-wide v0, p0, Landroid/animation/ValueAnimator;->mStartTime:J

    sub-long v2, p1, v0

    .line 19
    .local v2, totalTime:J
    iget-wide v0, p0, Landroid/animation/TimeAnimator;->mPreviousTime:J

    cmp-long v0, v0, v4

    if-gez v0, :cond_1a

    .line 20
    .local v4, deltaTime:J
    :goto_10
    iput-wide p1, p0, Landroid/animation/TimeAnimator;->mPreviousTime:J

    .line 21
    iget-object v0, p0, Landroid/animation/TimeAnimator;->mListener:Landroid/animation/TimeAnimator$TimeListener;

    move-object v1, p0

    invoke-interface/range {v0 .. v5}, Landroid/animation/TimeAnimator$TimeListener;->onTimeUpdate(Landroid/animation/TimeAnimator;JJ)V

    .line 23
    .end local v2           #totalTime:J
    .end local v4           #deltaTime:J
    :cond_18
    const/4 v0, 0x0

    return v0

    .line 19
    .restart local v2       #totalTime:J
    :cond_1a
    iget-wide v0, p0, Landroid/animation/TimeAnimator;->mPreviousTime:J

    sub-long v4, p1, v0

    goto :goto_10
.end method

.method initAnimation()V
    .registers 1

    .prologue
    .line 44
    return-void
.end method

.method public setTimeListener(Landroid/animation/TimeAnimator$TimeListener;)V
    .registers 2
    .parameter "listener"

    .prologue
    .line 33
    iput-object p1, p0, Landroid/animation/TimeAnimator;->mListener:Landroid/animation/TimeAnimator$TimeListener;

    .line 34
    return-void
.end method
