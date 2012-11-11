.class public Lcom/android/internal/widget/DrawableHolder;
.super Ljava/lang/Object;
.source "DrawableHolder.java"

# interfaces
.implements Landroid/animation/Animator$AnimatorListener;


# static fields
.field private static final DBG:Z = false

.field public static final EASE_OUT_INTERPOLATOR:Landroid/view/animation/DecelerateInterpolator; = null

.field private static final TAG:Ljava/lang/String; = "DrawableHolder"


# instance fields
.field private mAlpha:F

.field private mAnimators:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/animation/ObjectAnimator;",
            ">;"
        }
    .end annotation
.end field

.field private mDrawable:Landroid/graphics/drawable/BitmapDrawable;

.field private mNeedToStart:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/animation/ObjectAnimator;",
            ">;"
        }
    .end annotation
.end field

.field private mScaleX:F

.field private mScaleY:F

.field private mX:F

.field private mY:F


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    new-instance v0, Landroid/view/animation/DecelerateInterpolator;

    invoke-direct {v0}, Landroid/view/animation/DecelerateInterpolator;-><init>()V

    sput-object v0, Lcom/android/internal/widget/DrawableHolder;->EASE_OUT_INTERPOLATOR:Landroid/view/animation/DecelerateInterpolator;

    return-void
.end method

.method public constructor <init>(Landroid/graphics/drawable/BitmapDrawable;)V
    .registers 3
    .parameter "drawable"

    .prologue
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0, v0}, Lcom/android/internal/widget/DrawableHolder;-><init>(Landroid/graphics/drawable/BitmapDrawable;FF)V

    return-void
.end method

.method public constructor <init>(Landroid/graphics/drawable/BitmapDrawable;FF)V
    .registers 8
    .parameter "drawable"
    .parameter "x"
    .parameter "y"

    .prologue
    const/4 v3, 0x0

    const/4 v1, 0x0

    const/high16 v0, 0x3f80

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput v1, p0, Lcom/android/internal/widget/DrawableHolder;->mX:F

    iput v1, p0, Lcom/android/internal/widget/DrawableHolder;->mY:F

    iput v0, p0, Lcom/android/internal/widget/DrawableHolder;->mScaleX:F

    iput v0, p0, Lcom/android/internal/widget/DrawableHolder;->mScaleY:F

    iput v0, p0, Lcom/android/internal/widget/DrawableHolder;->mAlpha:F

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/android/internal/widget/DrawableHolder;->mAnimators:Ljava/util/ArrayList;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/android/internal/widget/DrawableHolder;->mNeedToStart:Ljava/util/ArrayList;

    iput-object p1, p0, Lcom/android/internal/widget/DrawableHolder;->mDrawable:Landroid/graphics/drawable/BitmapDrawable;

    iput p2, p0, Lcom/android/internal/widget/DrawableHolder;->mX:F

    iput p3, p0, Lcom/android/internal/widget/DrawableHolder;->mY:F

    iget-object v0, p0, Lcom/android/internal/widget/DrawableHolder;->mDrawable:Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/BitmapDrawable;->getPaint()Landroid/graphics/Paint;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    iget-object v0, p0, Lcom/android/internal/widget/DrawableHolder;->mDrawable:Landroid/graphics/drawable/BitmapDrawable;

    iget-object v1, p0, Lcom/android/internal/widget/DrawableHolder;->mDrawable:Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v1}, Landroid/graphics/drawable/BitmapDrawable;->getIntrinsicWidth()I

    move-result v1

    iget-object v2, p0, Lcom/android/internal/widget/DrawableHolder;->mDrawable:Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v2}, Landroid/graphics/drawable/BitmapDrawable;->getIntrinsicHeight()I

    move-result v2

    invoke-virtual {v0, v3, v3, v1, v2}, Landroid/graphics/drawable/BitmapDrawable;->setBounds(IIII)V

    return-void
.end method

.method private addAnimation(Landroid/animation/ObjectAnimator;Z)Lcom/android/internal/widget/DrawableHolder;
    .registers 4
    .parameter "anim"
    .parameter "overwrite"

    .prologue
    if-eqz p1, :cond_7

    iget-object v0, p0, Lcom/android/internal/widget/DrawableHolder;->mAnimators:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_7
    iget-object v0, p0, Lcom/android/internal/widget/DrawableHolder;->mNeedToStart:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    return-object p0
.end method


# virtual methods
.method public addAnimTo(JJLjava/lang/String;FZ)Landroid/animation/ObjectAnimator;
    .registers 11
    .parameter "duration"
    .parameter "delay"
    .parameter "property"
    .parameter "toValue"
    .parameter "replace"

    .prologue
    if-eqz p7, :cond_5

    invoke-virtual {p0, p5}, Lcom/android/internal/widget/DrawableHolder;->removeAnimationFor(Ljava/lang/String;)V

    :cond_5
    const/4 v1, 0x1

    new-array v1, v1, [F

    const/4 v2, 0x0

    aput p6, v1, v2

    invoke-static {p0, p5, v1}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v0

    .local v0, anim:Landroid/animation/ObjectAnimator;
    invoke-virtual {v0, p1, p2}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    invoke-virtual {v0, p3, p4}, Landroid/animation/ObjectAnimator;->setStartDelay(J)V

    sget-object v1, Lcom/android/internal/widget/DrawableHolder;->EASE_OUT_INTERPOLATOR:Landroid/view/animation/DecelerateInterpolator;

    invoke-virtual {v0, v1}, Landroid/animation/ObjectAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    invoke-direct {p0, v0, p7}, Lcom/android/internal/widget/DrawableHolder;->addAnimation(Landroid/animation/ObjectAnimator;Z)Lcom/android/internal/widget/DrawableHolder;

    return-object v0
.end method

.method public clearAnimations()V
    .registers 4

    .prologue
    iget-object v2, p0, Lcom/android/internal/widget/DrawableHolder;->mAnimators:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, i$:Ljava/util/Iterator;
    :goto_6
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_16

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/animation/ObjectAnimator;

    .local v0, currentAnim:Landroid/animation/ObjectAnimator;
    invoke-virtual {v0}, Landroid/animation/ObjectAnimator;->cancel()V

    goto :goto_6

    .end local v0           #currentAnim:Landroid/animation/ObjectAnimator;
    :cond_16
    iget-object v2, p0, Lcom/android/internal/widget/DrawableHolder;->mAnimators:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V

    return-void
.end method

.method public draw(Landroid/graphics/Canvas;)V
    .registers 6
    .parameter "canvas"

    .prologue
    const/high16 v3, -0x4100

    const/high16 v0, 0x3b80

    .local v0, threshold:F
    iget v1, p0, Lcom/android/internal/widget/DrawableHolder;->mAlpha:F

    const/high16 v2, 0x3b80

    cmpg-float v1, v1, v2

    if-gtz v1, :cond_d

    :goto_c
    return-void

    :cond_d
    const/4 v1, 0x1

    invoke-virtual {p1, v1}, Landroid/graphics/Canvas;->save(I)I

    iget v1, p0, Lcom/android/internal/widget/DrawableHolder;->mX:F

    iget v2, p0, Lcom/android/internal/widget/DrawableHolder;->mY:F

    invoke-virtual {p1, v1, v2}, Landroid/graphics/Canvas;->translate(FF)V

    iget v1, p0, Lcom/android/internal/widget/DrawableHolder;->mScaleX:F

    iget v2, p0, Lcom/android/internal/widget/DrawableHolder;->mScaleY:F

    invoke-virtual {p1, v1, v2}, Landroid/graphics/Canvas;->scale(FF)V

    invoke-virtual {p0}, Lcom/android/internal/widget/DrawableHolder;->getWidth()I

    move-result v1

    int-to-float v1, v1

    mul-float/2addr v1, v3

    invoke-virtual {p0}, Lcom/android/internal/widget/DrawableHolder;->getHeight()I

    move-result v2

    int-to-float v2, v2

    mul-float/2addr v2, v3

    invoke-virtual {p1, v1, v2}, Landroid/graphics/Canvas;->translate(FF)V

    iget-object v1, p0, Lcom/android/internal/widget/DrawableHolder;->mDrawable:Landroid/graphics/drawable/BitmapDrawable;

    iget v2, p0, Lcom/android/internal/widget/DrawableHolder;->mAlpha:F

    const/high16 v3, 0x437f

    mul-float/2addr v2, v3

    invoke-static {v2}, Ljava/lang/Math;->round(F)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/graphics/drawable/BitmapDrawable;->setAlpha(I)V

    iget-object v1, p0, Lcom/android/internal/widget/DrawableHolder;->mDrawable:Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v1, p1}, Landroid/graphics/drawable/BitmapDrawable;->draw(Landroid/graphics/Canvas;)V

    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    goto :goto_c
.end method

.method public getAlpha()F
    .registers 2

    .prologue
    iget v0, p0, Lcom/android/internal/widget/DrawableHolder;->mAlpha:F

    return v0
.end method

.method public getDrawable()Landroid/graphics/drawable/BitmapDrawable;
    .registers 2

    .prologue
    iget-object v0, p0, Lcom/android/internal/widget/DrawableHolder;->mDrawable:Landroid/graphics/drawable/BitmapDrawable;

    return-object v0
.end method

.method public getHeight()I
    .registers 2

    .prologue
    iget-object v0, p0, Lcom/android/internal/widget/DrawableHolder;->mDrawable:Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/BitmapDrawable;->getIntrinsicHeight()I

    move-result v0

    return v0
.end method

.method public getScaleX()F
    .registers 2

    .prologue
    iget v0, p0, Lcom/android/internal/widget/DrawableHolder;->mScaleX:F

    return v0
.end method

.method public getScaleY()F
    .registers 2

    .prologue
    iget v0, p0, Lcom/android/internal/widget/DrawableHolder;->mScaleY:F

    return v0
.end method

.method public getWidth()I
    .registers 2

    .prologue
    iget-object v0, p0, Lcom/android/internal/widget/DrawableHolder;->mDrawable:Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/BitmapDrawable;->getIntrinsicWidth()I

    move-result v0

    return v0
.end method

.method public getX()F
    .registers 2

    .prologue
    iget v0, p0, Lcom/android/internal/widget/DrawableHolder;->mX:F

    return v0
.end method

.method public getY()F
    .registers 2

    .prologue
    iget v0, p0, Lcom/android/internal/widget/DrawableHolder;->mY:F

    return v0
.end method

.method public onAnimationCancel(Landroid/animation/Animator;)V
    .registers 2
    .parameter "animation"

    .prologue
    return-void
.end method

.method public onAnimationEnd(Landroid/animation/Animator;)V
    .registers 3
    .parameter "animation"

    .prologue
    iget-object v0, p0, Lcom/android/internal/widget/DrawableHolder;->mAnimators:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    return-void
.end method

.method public onAnimationRepeat(Landroid/animation/Animator;)V
    .registers 2
    .parameter "animation"

    .prologue
    return-void
.end method

.method public onAnimationStart(Landroid/animation/Animator;)V
    .registers 2
    .parameter "animation"

    .prologue
    return-void
.end method

.method public removeAnimationFor(Ljava/lang/String;)V
    .registers 6
    .parameter "property"

    .prologue
    iget-object v3, p0, Lcom/android/internal/widget/DrawableHolder;->mAnimators:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->clone()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/ArrayList;

    .local v2, removalList:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/animation/ObjectAnimator;>;"
    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, i$:Ljava/util/Iterator;
    :cond_c
    :goto_c
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_26

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/animation/ObjectAnimator;

    .local v0, currentAnim:Landroid/animation/ObjectAnimator;
    invoke-virtual {v0}, Landroid/animation/ObjectAnimator;->getPropertyName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_c

    invoke-virtual {v0}, Landroid/animation/ObjectAnimator;->cancel()V

    goto :goto_c

    .end local v0           #currentAnim:Landroid/animation/ObjectAnimator;
    :cond_26
    return-void
.end method

.method public setAlpha(F)V
    .registers 2
    .parameter "alpha"

    .prologue
    iput p1, p0, Lcom/android/internal/widget/DrawableHolder;->mAlpha:F

    return-void
.end method

.method public setScaleX(F)V
    .registers 2
    .parameter "value"

    .prologue
    iput p1, p0, Lcom/android/internal/widget/DrawableHolder;->mScaleX:F

    return-void
.end method

.method public setScaleY(F)V
    .registers 2
    .parameter "value"

    .prologue
    iput p1, p0, Lcom/android/internal/widget/DrawableHolder;->mScaleY:F

    return-void
.end method

.method public setX(F)V
    .registers 2
    .parameter "value"

    .prologue
    iput p1, p0, Lcom/android/internal/widget/DrawableHolder;->mX:F

    return-void
.end method

.method public setY(F)V
    .registers 2
    .parameter "value"

    .prologue
    iput p1, p0, Lcom/android/internal/widget/DrawableHolder;->mY:F

    return-void
.end method

.method public startAnimations(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V
    .registers 5
    .parameter "listener"

    .prologue
    const/4 v1, 0x0

    .local v1, i:I
    :goto_1
    iget-object v2, p0, Lcom/android/internal/widget/DrawableHolder;->mNeedToStart:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-ge v1, v2, :cond_1d

    iget-object v2, p0, Lcom/android/internal/widget/DrawableHolder;->mNeedToStart:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/animation/ObjectAnimator;

    .local v0, anim:Landroid/animation/ObjectAnimator;
    invoke-virtual {v0, p1}, Landroid/animation/ObjectAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V

    invoke-virtual {v0, p0}, Landroid/animation/ObjectAnimator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    invoke-virtual {v0}, Landroid/animation/ObjectAnimator;->start()V

    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .end local v0           #anim:Landroid/animation/ObjectAnimator;
    :cond_1d
    iget-object v2, p0, Lcom/android/internal/widget/DrawableHolder;->mNeedToStart:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V

    return-void
.end method
