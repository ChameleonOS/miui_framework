.class public Lcom/android/internal/widget/SizeAdaptiveLayout;
.super Landroid/view/ViewGroup;
.source "SizeAdaptiveLayout.java"


# annotations
.annotation runtime Landroid/widget/RemoteViews$RemoteView;
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/internal/widget/SizeAdaptiveLayout$BringToFrontOnEnd;,
        Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;
    }
.end annotation


# static fields
.field private static final CROSSFADE_TIME:J = 0xfaL

.field private static final DEBUG:Z = false

.field private static final MAX_VALID_HEIGHT:I = 0x0

.field private static final MIN_VALID_HEIGHT:I = 0x1

.field private static final REPORT_BAD_BOUNDS:Z = true

.field private static final TAG:Ljava/lang/String; = "SizeAdaptiveLayout"


# instance fields
.field private mActiveChild:Landroid/view/View;

.field private mAnimatorListener:Landroid/animation/Animator$AnimatorListener;

.field private mCanceledAnimationCount:I

.field private mEnteringView:Landroid/view/View;

.field private mFadePanel:Landroid/animation/ObjectAnimator;

.field private mFadeView:Landroid/animation/ObjectAnimator;

.field private mLastActive:Landroid/view/View;

.field private mLeavingView:Landroid/view/View;

.field private mModestyPanel:Landroid/view/View;

.field private mModestyPanelTop:I

.field private mTransitionAnimation:Landroid/animation/AnimatorSet;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 2
    .parameter "context"

    .prologue
    invoke-direct {p0, p1}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;)V

    invoke-direct {p0}, Lcom/android/internal/widget/SizeAdaptiveLayout;->initialize()V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 3
    .parameter "context"
    .parameter "attrs"

    .prologue
    invoke-direct {p0, p1, p2}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    invoke-direct {p0}, Lcom/android/internal/widget/SizeAdaptiveLayout;->initialize()V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .registers 4
    .parameter "context"
    .parameter "attrs"
    .parameter "defStyle"

    .prologue
    invoke-direct {p0, p1, p2, p3}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    invoke-direct {p0}, Lcom/android/internal/widget/SizeAdaptiveLayout;->initialize()V

    return-void
.end method

.method static synthetic access$000(Lcom/android/internal/widget/SizeAdaptiveLayout;)I
    .registers 2
    .parameter "x0"

    .prologue
    iget v0, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mCanceledAnimationCount:I

    return v0
.end method

.method static synthetic access$008(Lcom/android/internal/widget/SizeAdaptiveLayout;)I
    .registers 3
    .parameter "x0"

    .prologue
    iget v0, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mCanceledAnimationCount:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mCanceledAnimationCount:I

    return v0
.end method

.method static synthetic access$010(Lcom/android/internal/widget/SizeAdaptiveLayout;)I
    .registers 3
    .parameter "x0"

    .prologue
    iget v0, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mCanceledAnimationCount:I

    add-int/lit8 v1, v0, -0x1

    iput v1, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mCanceledAnimationCount:I

    return v0
.end method

.method static synthetic access$100(Lcom/android/internal/widget/SizeAdaptiveLayout;)Landroid/view/View;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mLeavingView:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$102(Lcom/android/internal/widget/SizeAdaptiveLayout;Landroid/view/View;)Landroid/view/View;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput-object p1, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mLeavingView:Landroid/view/View;

    return-object p1
.end method

.method static synthetic access$200(Lcom/android/internal/widget/SizeAdaptiveLayout;)Landroid/view/View;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mModestyPanel:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$300(Lcom/android/internal/widget/SizeAdaptiveLayout;)Landroid/view/View;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mEnteringView:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$302(Lcom/android/internal/widget/SizeAdaptiveLayout;Landroid/view/View;)Landroid/view/View;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput-object p1, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mEnteringView:Landroid/view/View;

    return-object p1
.end method

.method private clampSizeToBounds(ILandroid/view/View;)I
    .registers 9
    .parameter "measuredHeight"
    .parameter "child"

    .prologue
    invoke-virtual {p2}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    check-cast v2, Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;

    .local v2, lp:Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;
    const v3, 0xffffff

    and-int v1, v3, p1

    .local v1, heightIn:I
    iget v3, v2, Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;->minHeight:I

    invoke-static {v1, v3}, Ljava/lang/Math;->max(II)I

    move-result v0

    .local v0, height:I
    iget v3, v2, Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;->maxHeight:I

    const/4 v4, -0x1

    if-eq v3, v4, :cond_1c

    iget v3, v2, Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;->maxHeight:I

    invoke-static {v0, v3}, Ljava/lang/Math;->min(II)I

    move-result v0

    :cond_1c
    if-eq v1, v0, :cond_63

    const-string v3, "SizeAdaptiveLayout"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "child view "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, "measured out of bounds at "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, "px "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "clamped to "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, "px"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_63
    return v0
.end method

.method private initialize()V
    .registers 10
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->CHANGE_CODE:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation

    .prologue
    const/4 v8, 0x1

    const/4 v5, -0x1

    const/4 v7, 0x0

    const/4 v6, 0x0

    new-instance v3, Landroid/view/View;

    invoke-virtual {p0}, Lcom/android/internal/widget/SizeAdaptiveLayout;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-direct {v3, v4}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    iput-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mModestyPanel:Landroid/view/View;

    invoke-virtual {p0}, Lcom/android/internal/widget/SizeAdaptiveLayout;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .local v0, background:Landroid/graphics/drawable/Drawable;
    instance-of v3, v0, Landroid/graphics/drawable/StateListDrawable;

    if-eqz v3, :cond_23

    move-object v2, v0

    check-cast v2, Landroid/graphics/drawable/StateListDrawable;

    .local v2, sld:Landroid/graphics/drawable/StateListDrawable;
    sget-object v3, Landroid/util/StateSet;->WILD_CARD:[I

    invoke-virtual {v2, v3}, Landroid/graphics/drawable/StateListDrawable;->setState([I)Z

    invoke-virtual {v2}, Landroid/graphics/drawable/StateListDrawable;->getCurrent()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .end local v2           #sld:Landroid/graphics/drawable/StateListDrawable;
    :cond_23
    instance-of v3, v0, Landroid/graphics/drawable/ColorDrawable;

    if-eqz v3, :cond_80

    iget-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mModestyPanel:Landroid/view/View;

    invoke-virtual {v3, v0}, Landroid/view/View;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    :goto_2c
    new-instance v1, Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;

    invoke-direct {v1, v5, v5}, Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;-><init>(II)V

    .local v1, layout:Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;
    iget-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mModestyPanel:Landroid/view/View;

    invoke-virtual {v3, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    iget-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mModestyPanel:Landroid/view/View;

    invoke-virtual {p0, v3}, Lcom/android/internal/widget/SizeAdaptiveLayout;->addView(Landroid/view/View;)V

    iget-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mModestyPanel:Landroid/view/View;

    const-string v4, "alpha"

    new-array v5, v8, [F

    aput v7, v5, v6

    invoke-static {v3, v4, v5}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v3

    iput-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mFadePanel:Landroid/animation/ObjectAnimator;

    const/4 v3, 0x0

    const-string v4, "alpha"

    new-array v5, v8, [F

    aput v7, v5, v6

    invoke-static {v3, v4, v5}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v3

    iput-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mFadeView:Landroid/animation/ObjectAnimator;

    new-instance v3, Lcom/android/internal/widget/SizeAdaptiveLayout$BringToFrontOnEnd;

    invoke-direct {v3, p0}, Lcom/android/internal/widget/SizeAdaptiveLayout$BringToFrontOnEnd;-><init>(Lcom/android/internal/widget/SizeAdaptiveLayout;)V

    iput-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mAnimatorListener:Landroid/animation/Animator$AnimatorListener;

    new-instance v3, Landroid/animation/AnimatorSet;

    invoke-direct {v3}, Landroid/animation/AnimatorSet;-><init>()V

    iput-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mTransitionAnimation:Landroid/animation/AnimatorSet;

    iget-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mTransitionAnimation:Landroid/animation/AnimatorSet;

    iget-object v4, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mFadeView:Landroid/animation/ObjectAnimator;

    invoke-virtual {v3, v4}, Landroid/animation/AnimatorSet;->play(Landroid/animation/Animator;)Landroid/animation/AnimatorSet$Builder;

    move-result-object v3

    iget-object v4, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mFadePanel:Landroid/animation/ObjectAnimator;

    invoke-virtual {v3, v4}, Landroid/animation/AnimatorSet$Builder;->with(Landroid/animation/Animator;)Landroid/animation/AnimatorSet$Builder;

    iget-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mTransitionAnimation:Landroid/animation/AnimatorSet;

    const-wide/16 v4, 0xfa

    invoke-virtual {v3, v4, v5}, Landroid/animation/AnimatorSet;->setDuration(J)Landroid/animation/AnimatorSet;

    iget-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mTransitionAnimation:Landroid/animation/AnimatorSet;

    iget-object v4, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mAnimatorListener:Landroid/animation/Animator$AnimatorListener;

    invoke-virtual {v3, v4}, Landroid/animation/AnimatorSet;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    return-void

    .end local v1           #layout:Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;
    :cond_80
    iget-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mModestyPanel:Landroid/view/View;

    invoke-virtual {v3, v6}, Landroid/view/View;->setBackgroundColor(I)V

    goto :goto_2c
.end method

.method private selectActiveChild(I)Landroid/view/View;
    .registers 14
    .parameter "heightMeasureSpec"

    .prologue
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v1

    .local v1, heightMode:I
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v2

    .local v2, heightSize:I
    const/4 v9, 0x0

    .local v9, unboundedView:Landroid/view/View;
    const/4 v7, 0x0

    .local v7, tallestView:Landroid/view/View;
    const/4 v8, 0x0

    .local v8, tallestViewSize:I
    const/4 v5, 0x0

    .local v5, smallestView:Landroid/view/View;
    const v6, 0x7fffffff

    .local v6, smallestViewSize:I
    const/4 v3, 0x0

    .local v3, i:I
    :goto_10
    invoke-virtual {p0}, Lcom/android/internal/widget/SizeAdaptiveLayout;->getChildCount()I

    move-result v10

    if-ge v3, v10, :cond_48

    invoke-virtual {p0, v3}, Lcom/android/internal/widget/SizeAdaptiveLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .local v0, child:Landroid/view/View;
    iget-object v10, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mModestyPanel:Landroid/view/View;

    if-eq v0, v10, :cond_45

    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v4

    check-cast v4, Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;

    .local v4, lp:Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;
    iget v10, v4, Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;->maxHeight:I

    const/4 v11, -0x1

    if-ne v10, v11, :cond_2c

    if-nez v9, :cond_2c

    move-object v9, v0

    :cond_2c
    iget v10, v4, Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;->maxHeight:I

    if-le v10, v8, :cond_33

    iget v8, v4, Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;->maxHeight:I

    move-object v7, v0

    :cond_33
    iget v10, v4, Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;->minHeight:I

    if-ge v10, v6, :cond_3a

    iget v6, v4, Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;->minHeight:I

    move-object v5, v0

    :cond_3a
    if-eqz v1, :cond_45

    iget v10, v4, Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;->minHeight:I

    if-lt v2, v10, :cond_45

    iget v10, v4, Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;->maxHeight:I

    if-gt v2, v10, :cond_45

    .end local v0           #child:Landroid/view/View;
    .end local v4           #lp:Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;
    :goto_44
    return-object v0

    .restart local v0       #child:Landroid/view/View;
    :cond_45
    add-int/lit8 v3, v3, 0x1

    goto :goto_10

    .end local v0           #child:Landroid/view/View;
    :cond_48
    if-eqz v9, :cond_4b

    move-object v7, v9

    :cond_4b
    if-nez v1, :cond_4f

    move-object v0, v7

    goto :goto_44

    :cond_4f
    if-le v2, v8, :cond_53

    move-object v0, v7

    goto :goto_44

    :cond_53
    move-object v0, v5

    goto :goto_44
.end method


# virtual methods
.method protected checkLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Z
    .registers 3
    .parameter "p"

    .prologue
    instance-of v0, p1, Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;

    return v0
.end method

.method protected bridge synthetic generateDefaultLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    .registers 2

    .prologue
    invoke-virtual {p0}, Lcom/android/internal/widget/SizeAdaptiveLayout;->generateDefaultLayoutParams()Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;

    move-result-object v0

    return-object v0
.end method

.method protected generateDefaultLayoutParams()Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;
    .registers 2

    .prologue
    new-instance v0, Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;

    invoke-direct {v0}, Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;-><init>()V

    return-object v0
.end method

.method public bridge synthetic generateLayoutParams(Landroid/util/AttributeSet;)Landroid/view/ViewGroup$LayoutParams;
    .registers 3
    .parameter "x0"

    .prologue
    invoke-virtual {p0, p1}, Lcom/android/internal/widget/SizeAdaptiveLayout;->generateLayoutParams(Landroid/util/AttributeSet;)Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;

    move-result-object v0

    return-object v0
.end method

.method protected bridge synthetic generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;
    .registers 3
    .parameter "x0"

    .prologue
    invoke-virtual {p0, p1}, Lcom/android/internal/widget/SizeAdaptiveLayout;->generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;

    move-result-object v0

    return-object v0
.end method

.method public generateLayoutParams(Landroid/util/AttributeSet;)Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;
    .registers 4
    .parameter "attrs"

    .prologue
    new-instance v0, Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;

    invoke-virtual {p0}, Lcom/android/internal/widget/SizeAdaptiveLayout;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-object v0
.end method

.method protected generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;
    .registers 3
    .parameter "p"

    .prologue
    new-instance v0, Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;

    invoke-direct {v0, p1}, Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V

    return-object v0
.end method

.method public getModestyPanel()Landroid/view/View;
    .registers 2

    .prologue
    iget-object v0, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mModestyPanel:Landroid/view/View;

    return-object v0
.end method

.method public getTransitionAnimation()Landroid/animation/Animator;
    .registers 2

    .prologue
    iget-object v0, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mTransitionAnimation:Landroid/animation/AnimatorSet;

    return-object v0
.end method

.method public onAttachedToWindow()V
    .registers 4

    .prologue
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mLastActive:Landroid/view/View;

    const/4 v0, 0x0

    .local v0, i:I
    :goto_4
    invoke-virtual {p0}, Lcom/android/internal/widget/SizeAdaptiveLayout;->getChildCount()I

    move-result v1

    if-ge v0, v1, :cond_16

    invoke-virtual {p0, v0}, Lcom/android/internal/widget/SizeAdaptiveLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_4

    :cond_16
    return-void
.end method

.method protected onLayout(ZIIII)V
    .registers 15
    .parameter "changed"
    .parameter "left"
    .parameter "top"
    .parameter "right"
    .parameter "bottom"

    .prologue
    const/4 v8, 0x1

    const/high16 v6, 0x3f80

    const/4 v5, 0x0

    const/4 v7, 0x0

    iget-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mActiveChild:Landroid/view/View;

    iput-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mLastActive:Landroid/view/View;

    sub-int v3, p5, p3

    const/high16 v4, 0x4000

    invoke-static {v3, v4}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v2

    .local v2, measureSpec:I
    invoke-direct {p0, v2}, Lcom/android/internal/widget/SizeAdaptiveLayout;->selectActiveChild(I)Landroid/view/View;

    move-result-object v3

    iput-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mActiveChild:Landroid/view/View;

    iget-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mActiveChild:Landroid/view/View;

    invoke-virtual {v3, v7}, Landroid/view/View;->setVisibility(I)V

    iget-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mLastActive:Landroid/view/View;

    iget-object v4, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mActiveChild:Landroid/view/View;

    if-eq v3, v4, :cond_7f

    iget-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mLastActive:Landroid/view/View;

    if-eqz v3, :cond_7f

    iget-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mActiveChild:Landroid/view/View;

    iput-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mEnteringView:Landroid/view/View;

    iget-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mLastActive:Landroid/view/View;

    iput-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mLeavingView:Landroid/view/View;

    iget-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mEnteringView:Landroid/view/View;

    invoke-virtual {v3, v6}, Landroid/view/View;->setAlpha(F)V

    iget-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mModestyPanel:Landroid/view/View;

    invoke-virtual {v3, v6}, Landroid/view/View;->setAlpha(F)V

    iget-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mModestyPanel:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->bringToFront()V

    iget-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mLeavingView:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getHeight()I

    move-result v3

    iput v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mModestyPanelTop:I

    iget-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mModestyPanel:Landroid/view/View;

    invoke-virtual {v3, v7}, Landroid/view/View;->setVisibility(I)V

    iget-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mLeavingView:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->bringToFront()V

    iget-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mTransitionAnimation:Landroid/animation/AnimatorSet;

    invoke-virtual {v3}, Landroid/animation/AnimatorSet;->isRunning()Z

    move-result v3

    if-eqz v3, :cond_5c

    iget-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mTransitionAnimation:Landroid/animation/AnimatorSet;

    invoke-virtual {v3}, Landroid/animation/AnimatorSet;->cancel()V

    :cond_5c
    iget-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mFadeView:Landroid/animation/ObjectAnimator;

    iget-object v4, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mLeavingView:Landroid/view/View;

    invoke-virtual {v3, v4}, Landroid/animation/ObjectAnimator;->setTarget(Ljava/lang/Object;)V

    iget-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mFadeView:Landroid/animation/ObjectAnimator;

    new-array v4, v8, [F

    aput v5, v4, v7

    invoke-virtual {v3, v4}, Landroid/animation/ObjectAnimator;->setFloatValues([F)V

    iget-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mFadePanel:Landroid/animation/ObjectAnimator;

    new-array v4, v8, [F

    aput v5, v4, v7

    invoke-virtual {v3, v4}, Landroid/animation/ObjectAnimator;->setFloatValues([F)V

    iget-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mTransitionAnimation:Landroid/animation/AnimatorSet;

    invoke-virtual {v3}, Landroid/animation/AnimatorSet;->setupStartValues()V

    iget-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mTransitionAnimation:Landroid/animation/AnimatorSet;

    invoke-virtual {v3}, Landroid/animation/AnimatorSet;->start()V

    :cond_7f
    iget-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mActiveChild:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getMeasuredWidth()I

    move-result v1

    .local v1, childWidth:I
    iget-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mActiveChild:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getMeasuredHeight()I

    move-result v0

    .local v0, childHeight:I
    iget-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mActiveChild:Landroid/view/View;

    add-int/lit8 v4, v1, 0x0

    add-int/lit8 v5, v0, 0x0

    invoke-virtual {v3, v7, v7, v4, v5}, Landroid/view/View;->layout(IIII)V

    iget-object v3, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mModestyPanel:Landroid/view/View;

    iget v4, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mModestyPanelTop:I

    add-int/lit8 v5, v1, 0x0

    iget v6, p0, Lcom/android/internal/widget/SizeAdaptiveLayout;->mModestyPanelTop:I

    add-int/2addr v6, v0

    invoke-virtual {v3, v7, v4, v5, v6}, Landroid/view/View;->layout(IIII)V

    return-void
.end method

.method protected onMeasure(II)V
    .registers 13
    .parameter "widthMeasureSpec"
    .parameter "heightMeasureSpec"

    .prologue
    invoke-direct {p0, p2}, Lcom/android/internal/widget/SizeAdaptiveLayout;->selectActiveChild(I)Landroid/view/View;

    move-result-object v5

    .local v5, model:Landroid/view/View;
    invoke-virtual {v5}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v4

    check-cast v4, Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;

    .local v4, lp:Lcom/android/internal/widget/SizeAdaptiveLayout$LayoutParams;
    invoke-virtual {p0, v5, p1, p2}, Lcom/android/internal/widget/SizeAdaptiveLayout;->measureChild(Landroid/view/View;II)V

    invoke-virtual {v5}, Landroid/view/View;->getMeasuredHeight()I

    move-result v1

    .local v1, childHeight:I
    invoke-virtual {v5}, Landroid/view/View;->getMeasuredHeight()I

    move-result v3

    .local v3, childWidth:I
    const/4 v8, 0x0

    invoke-virtual {v5}, Landroid/view/View;->getMeasuredState()I

    move-result v9

    invoke-static {v8, v9}, Lcom/android/internal/widget/SizeAdaptiveLayout;->combineMeasuredStates(II)I

    move-result v2

    .local v2, childState:I
    invoke-static {v3, p1, v2}, Lcom/android/internal/widget/SizeAdaptiveLayout;->resolveSizeAndState(III)I

    move-result v7

    .local v7, resolvedWidth:I
    invoke-static {v1, p2, v2}, Lcom/android/internal/widget/SizeAdaptiveLayout;->resolveSizeAndState(III)I

    move-result v6

    .local v6, resolvedHeight:I
    invoke-direct {p0, v6, v5}, Lcom/android/internal/widget/SizeAdaptiveLayout;->clampSizeToBounds(ILandroid/view/View;)I

    move-result v0

    .local v0, boundedHeight:I
    invoke-virtual {p0, v7, v0}, Lcom/android/internal/widget/SizeAdaptiveLayout;->setMeasuredDimension(II)V

    return-void
.end method
