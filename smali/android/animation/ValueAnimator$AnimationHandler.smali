.class Landroid/animation/ValueAnimator$AnimationHandler;
.super Ljava/lang/Object;
.source "ValueAnimator.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/animation/ValueAnimator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "AnimationHandler"
.end annotation


# instance fields
.field private mAnimationScheduled:Z

.field private final mAnimations:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/animation/ValueAnimator;",
            ">;"
        }
    .end annotation
.end field

.field private final mChoreographer:Landroid/view/Choreographer;

.field private final mDelayedAnims:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/animation/ValueAnimator;",
            ">;"
        }
    .end annotation
.end field

.field private final mEndingAnims:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/animation/ValueAnimator;",
            ">;"
        }
    .end annotation
.end field

.field private final mPendingAnimations:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/animation/ValueAnimator;",
            ">;"
        }
    .end annotation
.end field

.field private final mReadyAnims:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/animation/ValueAnimator;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>()V
    .registers 2

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mAnimations:Ljava/util/ArrayList;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mPendingAnimations:Ljava/util/ArrayList;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mDelayedAnims:Ljava/util/ArrayList;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mEndingAnims:Ljava/util/ArrayList;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mReadyAnims:Ljava/util/ArrayList;

    invoke-static {}, Landroid/view/Choreographer;->getInstance()Landroid/view/Choreographer;

    move-result-object v0

    iput-object v0, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mChoreographer:Landroid/view/Choreographer;

    return-void
.end method

.method synthetic constructor <init>(Landroid/animation/ValueAnimator$1;)V
    .registers 2
    .parameter "x0"

    .prologue
    invoke-direct {p0}, Landroid/animation/ValueAnimator$AnimationHandler;-><init>()V

    return-void
.end method

.method static synthetic access$500(Landroid/animation/ValueAnimator$AnimationHandler;)Ljava/util/ArrayList;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mPendingAnimations:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic access$600(Landroid/animation/ValueAnimator$AnimationHandler;)Ljava/util/ArrayList;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mDelayedAnims:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic access$700(Landroid/animation/ValueAnimator$AnimationHandler;)Ljava/util/ArrayList;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mAnimations:Ljava/util/ArrayList;

    return-object v0
.end method

.method private doAnimationFrame(J)V
    .registers 14
    .parameter "frameTime"

    .prologue
    :cond_0
    iget-object v7, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mPendingAnimations:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v7

    if-lez v7, :cond_38

    iget-object v7, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mPendingAnimations:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->clone()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/ArrayList;

    .local v6, pendingCopy:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/animation/ValueAnimator;>;"
    iget-object v7, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mPendingAnimations:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->clear()V

    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v1

    .local v1, count:I
    const/4 v2, 0x0

    .local v2, i:I
    :goto_1a
    if-ge v2, v1, :cond_0

    invoke-virtual {v6, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/animation/ValueAnimator;

    .local v0, anim:Landroid/animation/ValueAnimator;
    #getter for: Landroid/animation/ValueAnimator;->mStartDelay:J
    invoke-static {v0}, Landroid/animation/ValueAnimator;->access$000(Landroid/animation/ValueAnimator;)J

    move-result-wide v7

    const-wide/16 v9, 0x0

    cmp-long v7, v7, v9

    if-nez v7, :cond_32

    #calls: Landroid/animation/ValueAnimator;->startAnimation(Landroid/animation/ValueAnimator$AnimationHandler;)V
    invoke-static {v0, p0}, Landroid/animation/ValueAnimator;->access$100(Landroid/animation/ValueAnimator;Landroid/animation/ValueAnimator$AnimationHandler;)V

    :goto_2f
    add-int/lit8 v2, v2, 0x1

    goto :goto_1a

    :cond_32
    iget-object v7, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mDelayedAnims:Ljava/util/ArrayList;

    invoke-virtual {v7, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_2f

    .end local v0           #anim:Landroid/animation/ValueAnimator;
    .end local v1           #count:I
    .end local v2           #i:I
    .end local v6           #pendingCopy:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/animation/ValueAnimator;>;"
    :cond_38
    iget-object v7, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mDelayedAnims:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v4

    .local v4, numDelayedAnims:I
    const/4 v2, 0x0

    .restart local v2       #i:I
    :goto_3f
    if-ge v2, v4, :cond_57

    iget-object v7, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mDelayedAnims:Ljava/util/ArrayList;

    invoke-virtual {v7, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/animation/ValueAnimator;

    .restart local v0       #anim:Landroid/animation/ValueAnimator;
    #calls: Landroid/animation/ValueAnimator;->delayedAnimationFrame(J)Z
    invoke-static {v0, p1, p2}, Landroid/animation/ValueAnimator;->access$200(Landroid/animation/ValueAnimator;J)Z

    move-result v7

    if-eqz v7, :cond_54

    iget-object v7, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mReadyAnims:Ljava/util/ArrayList;

    invoke-virtual {v7, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_54
    add-int/lit8 v2, v2, 0x1

    goto :goto_3f

    .end local v0           #anim:Landroid/animation/ValueAnimator;
    :cond_57
    iget-object v7, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mReadyAnims:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v5

    .local v5, numReadyAnims:I
    if-lez v5, :cond_7e

    const/4 v2, 0x0

    :goto_60
    if-ge v2, v5, :cond_79

    iget-object v7, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mReadyAnims:Ljava/util/ArrayList;

    invoke-virtual {v7, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/animation/ValueAnimator;

    .restart local v0       #anim:Landroid/animation/ValueAnimator;
    #calls: Landroid/animation/ValueAnimator;->startAnimation(Landroid/animation/ValueAnimator$AnimationHandler;)V
    invoke-static {v0, p0}, Landroid/animation/ValueAnimator;->access$100(Landroid/animation/ValueAnimator;Landroid/animation/ValueAnimator$AnimationHandler;)V

    const/4 v7, 0x1

    #setter for: Landroid/animation/ValueAnimator;->mRunning:Z
    invoke-static {v0, v7}, Landroid/animation/ValueAnimator;->access$302(Landroid/animation/ValueAnimator;Z)Z

    iget-object v7, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mDelayedAnims:Ljava/util/ArrayList;

    invoke-virtual {v7, v0}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    add-int/lit8 v2, v2, 0x1

    goto :goto_60

    .end local v0           #anim:Landroid/animation/ValueAnimator;
    :cond_79
    iget-object v7, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mReadyAnims:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->clear()V

    :cond_7e
    iget-object v7, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mAnimations:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v3

    .local v3, numAnims:I
    const/4 v2, 0x0

    :goto_85
    if-ge v2, v3, :cond_ad

    iget-object v7, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mAnimations:Ljava/util/ArrayList;

    invoke-virtual {v7, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/animation/ValueAnimator;

    .restart local v0       #anim:Landroid/animation/ValueAnimator;
    invoke-virtual {v0, p1, p2}, Landroid/animation/ValueAnimator;->doAnimationFrame(J)Z

    move-result v7

    if-eqz v7, :cond_9a

    iget-object v7, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mEndingAnims:Ljava/util/ArrayList;

    invoke-virtual {v7, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_9a
    iget-object v7, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mAnimations:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v7

    if-ne v7, v3, :cond_a5

    add-int/lit8 v2, v2, 0x1

    goto :goto_85

    :cond_a5
    add-int/lit8 v3, v3, -0x1

    iget-object v7, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mEndingAnims:Ljava/util/ArrayList;

    invoke-virtual {v7, v0}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    goto :goto_85

    .end local v0           #anim:Landroid/animation/ValueAnimator;
    :cond_ad
    iget-object v7, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mEndingAnims:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v7

    if-lez v7, :cond_d1

    const/4 v2, 0x0

    :goto_b6
    iget-object v7, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mEndingAnims:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v7

    if-ge v2, v7, :cond_cc

    iget-object v7, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mEndingAnims:Ljava/util/ArrayList;

    invoke-virtual {v7, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/animation/ValueAnimator;

    #calls: Landroid/animation/ValueAnimator;->endAnimation(Landroid/animation/ValueAnimator$AnimationHandler;)V
    invoke-static {v7, p0}, Landroid/animation/ValueAnimator;->access$400(Landroid/animation/ValueAnimator;Landroid/animation/ValueAnimator$AnimationHandler;)V

    add-int/lit8 v2, v2, 0x1

    goto :goto_b6

    :cond_cc
    iget-object v7, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mEndingAnims:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->clear()V

    :cond_d1
    iget-object v7, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mAnimations:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v7

    if-eqz v7, :cond_e1

    iget-object v7, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mDelayedAnims:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v7

    if-nez v7, :cond_e4

    :cond_e1
    invoke-direct {p0}, Landroid/animation/ValueAnimator$AnimationHandler;->scheduleAnimation()V

    :cond_e4
    return-void
.end method

.method private scheduleAnimation()V
    .registers 4

    .prologue
    const/4 v2, 0x1

    iget-boolean v0, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mAnimationScheduled:Z

    if-nez v0, :cond_d

    iget-object v0, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mChoreographer:Landroid/view/Choreographer;

    const/4 v1, 0x0

    invoke-virtual {v0, v2, p0, v1}, Landroid/view/Choreographer;->postCallback(ILjava/lang/Runnable;Ljava/lang/Object;)V

    iput-boolean v2, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mAnimationScheduled:Z

    :cond_d
    return-void
.end method


# virtual methods
.method public run()V
    .registers 3

    .prologue
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mAnimationScheduled:Z

    iget-object v0, p0, Landroid/animation/ValueAnimator$AnimationHandler;->mChoreographer:Landroid/view/Choreographer;

    invoke-virtual {v0}, Landroid/view/Choreographer;->getFrameTime()J

    move-result-wide v0

    invoke-direct {p0, v0, v1}, Landroid/animation/ValueAnimator$AnimationHandler;->doAnimationFrame(J)V

    return-void
.end method

.method public start()V
    .registers 1

    .prologue
    invoke-direct {p0}, Landroid/animation/ValueAnimator$AnimationHandler;->scheduleAnimation()V

    return-void
.end method
