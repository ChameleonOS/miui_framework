.class public Landroid/widget/StackView;
.super Landroid/widget/AdapterViewAnimator;
.source "StackView.java"


# annotations
.annotation runtime Landroid/widget/RemoteViews$RemoteView;
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/widget/StackView$HolographicHelper;,
        Landroid/widget/StackView$LayoutParams;,
        Landroid/widget/StackView$StackSlider;,
        Landroid/widget/StackView$StackFrame;
    }
.end annotation


# static fields
.field private static final DEFAULT_ANIMATION_DURATION:I = 0x190

.field private static final FRAME_PADDING:I = 0x4

.field private static final GESTURE_NONE:I = 0x0

.field private static final GESTURE_SLIDE_DOWN:I = 0x2

.field private static final GESTURE_SLIDE_UP:I = 0x1

.field private static final INVALID_POINTER:I = -0x1

.field private static final ITEMS_SLIDE_DOWN:I = 0x1

.field private static final ITEMS_SLIDE_UP:I = 0x0

.field private static final MINIMUM_ANIMATION_DURATION:I = 0x32

.field private static final MIN_TIME_BETWEEN_INTERACTION_AND_AUTOADVANCE:I = 0x1388

.field private static final MIN_TIME_BETWEEN_SCROLLS:J = 0x64L

.field private static final NUM_ACTIVE_VIEWS:I = 0x5

.field private static final PERSPECTIVE_SCALE_FACTOR:F = 0.0f

.field private static final PERSPECTIVE_SHIFT_FACTOR_X:F = 0.1f

.field private static final PERSPECTIVE_SHIFT_FACTOR_Y:F = 0.1f

.field private static final SLIDE_UP_RATIO:F = 0.7f

.field private static final STACK_RELAYOUT_DURATION:I = 0x64

.field private static final SWIPE_THRESHOLD_RATIO:F = 0.2f

.field private static sHolographicHelper:Landroid/widget/StackView$HolographicHelper;


# instance fields
.field private final TAG:Ljava/lang/String;

.field private mActivePointerId:I

.field private mClickColor:I

.field private mClickFeedback:Landroid/widget/ImageView;

.field private mClickFeedbackIsValid:Z

.field private mFirstLayoutHappened:Z

.field private mFramePadding:I

.field private mHighlight:Landroid/widget/ImageView;

.field private mInitialX:F

.field private mInitialY:F

.field private mLastInteractionTime:J

.field private mLastScrollTime:J

.field private mMaximumVelocity:I

.field private mNewPerspectiveShiftX:F

.field private mNewPerspectiveShiftY:F

.field private mPerspectiveShiftX:F

.field private mPerspectiveShiftY:F

.field private mResOutColor:I

.field private mSlideAmount:I

.field private mStackMode:I

.field private mStackSlider:Landroid/widget/StackView$StackSlider;

.field private mSwipeGestureType:I

.field private mSwipeThreshold:I

.field private final mTouchRect:Landroid/graphics/Rect;

.field private mTouchSlop:I

.field private mTransitionIsSetup:Z

.field private mVelocityTracker:Landroid/view/VelocityTracker;

.field private mYVelocity:I

.field private final stackInvalidateRect:Landroid/graphics/Rect;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 3
    .parameter "context"

    .prologue
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/widget/StackView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 4
    .parameter "context"
    .parameter "attrs"

    .prologue
    const v0, 0x10103c1

    invoke-direct {p0, p1, p2, v0}, Landroid/widget/StackView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .registers 8
    .parameter "context"
    .parameter "attrs"
    .parameter "defStyleAttr"

    .prologue
    const/4 v3, 0x0

    invoke-direct {p0, p1, p2, p3}, Landroid/widget/AdapterViewAnimator;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    const-string v1, "StackView"

    iput-object v1, p0, Landroid/widget/StackView;->TAG:Ljava/lang/String;

    new-instance v1, Landroid/graphics/Rect;

    invoke-direct {v1}, Landroid/graphics/Rect;-><init>()V

    iput-object v1, p0, Landroid/widget/StackView;->mTouchRect:Landroid/graphics/Rect;

    iput v3, p0, Landroid/widget/StackView;->mYVelocity:I

    iput v3, p0, Landroid/widget/StackView;->mSwipeGestureType:I

    iput-boolean v3, p0, Landroid/widget/StackView;->mTransitionIsSetup:Z

    iput-boolean v3, p0, Landroid/widget/StackView;->mClickFeedbackIsValid:Z

    iput-boolean v3, p0, Landroid/widget/StackView;->mFirstLayoutHappened:Z

    const-wide/16 v1, 0x0

    iput-wide v1, p0, Landroid/widget/StackView;->mLastInteractionTime:J

    new-instance v1, Landroid/graphics/Rect;

    invoke-direct {v1}, Landroid/graphics/Rect;-><init>()V

    iput-object v1, p0, Landroid/widget/StackView;->stackInvalidateRect:Landroid/graphics/Rect;

    sget-object v1, Lcom/android/internal/R$styleable;->StackView:[I

    invoke-virtual {p1, p2, v1, p3, v3}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .local v0, a:Landroid/content/res/TypedArray;
    invoke-virtual {v0, v3, v3}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v1

    iput v1, p0, Landroid/widget/StackView;->mResOutColor:I

    const/4 v1, 0x1

    invoke-virtual {v0, v1, v3}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v1

    iput v1, p0, Landroid/widget/StackView;->mClickColor:I

    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    invoke-direct {p0}, Landroid/widget/StackView;->initStackView()V

    return-void
.end method

.method static synthetic access$000(Landroid/widget/StackView;)Landroid/widget/ImageView;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/widget/StackView;->mHighlight:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$100(Landroid/widget/StackView;)I
    .registers 2
    .parameter "x0"

    .prologue
    iget v0, p0, Landroid/widget/StackView;->mStackMode:I

    return v0
.end method

.method static synthetic access$200(Landroid/widget/StackView;)I
    .registers 2
    .parameter "x0"

    .prologue
    iget v0, p0, Landroid/widget/StackView;->mSlideAmount:I

    return v0
.end method

.method private beginGestureIfNeeded(F)V
    .registers 14
    .parameter "deltaY"

    .prologue
    const/4 v8, 0x2

    const/4 v9, 0x0

    const/4 v7, 0x1

    invoke-static {p1}, Ljava/lang/Math;->abs(F)F

    move-result v10

    float-to-int v10, v10

    iget v11, p0, Landroid/widget/StackView;->mTouchSlop:I

    if-le v10, v11, :cond_20

    iget v10, p0, Landroid/widget/StackView;->mSwipeGestureType:I

    if-nez v10, :cond_20

    const/4 v10, 0x0

    cmpg-float v10, p1, v10

    if-gez v10, :cond_21

    move v5, v7

    .local v5, swipeGestureType:I
    :goto_16
    invoke-virtual {p0}, Landroid/widget/StackView;->cancelLongPress()V

    invoke-virtual {p0, v7}, Landroid/widget/StackView;->requestDisallowInterceptTouchEvent(Z)V

    iget-object v10, p0, Landroid/widget/AdapterViewAnimator;->mAdapter:Landroid/widget/Adapter;

    if-nez v10, :cond_23

    .end local v5           #swipeGestureType:I
    :cond_20
    :goto_20
    return-void

    :cond_21
    move v5, v8

    goto :goto_16

    .restart local v5       #swipeGestureType:I
    :cond_23
    invoke-virtual {p0}, Landroid/widget/StackView;->getCount()I

    move-result v1

    .local v1, adapterCount:I
    iget v10, p0, Landroid/widget/StackView;->mStackMode:I

    if-nez v10, :cond_72

    if-ne v5, v8, :cond_70

    move v0, v9

    .local v0, activeIndex:I
    :goto_2e
    iget-boolean v10, p0, Landroid/widget/AdapterViewAnimator;->mLoopViews:Z

    if-eqz v10, :cond_78

    if-ne v1, v7, :cond_78

    iget v10, p0, Landroid/widget/StackView;->mStackMode:I

    if-nez v10, :cond_3a

    if-eq v5, v7, :cond_40

    :cond_3a
    iget v10, p0, Landroid/widget/StackView;->mStackMode:I

    if-ne v10, v7, :cond_78

    if-ne v5, v8, :cond_78

    :cond_40
    move v3, v7

    .local v3, endOfStack:Z
    :goto_41
    iget-boolean v10, p0, Landroid/widget/AdapterViewAnimator;->mLoopViews:Z

    if-eqz v10, :cond_7a

    if-ne v1, v7, :cond_7a

    iget v10, p0, Landroid/widget/StackView;->mStackMode:I

    if-ne v10, v7, :cond_4d

    if-eq v5, v7, :cond_53

    :cond_4d
    iget v10, p0, Landroid/widget/StackView;->mStackMode:I

    if-nez v10, :cond_7a

    if-ne v5, v8, :cond_7a

    :cond_53
    move v2, v7

    .local v2, beginningOfStack:Z
    :goto_54
    iget-boolean v8, p0, Landroid/widget/AdapterViewAnimator;->mLoopViews:Z

    if-eqz v8, :cond_7c

    if-nez v2, :cond_7c

    if-nez v3, :cond_7c

    const/4 v4, 0x0

    .local v4, stackMode:I
    :goto_5d
    if-nez v4, :cond_95

    :goto_5f
    iput-boolean v7, p0, Landroid/widget/StackView;->mTransitionIsSetup:Z

    invoke-virtual {p0, v0}, Landroid/widget/StackView;->getViewAtRelativeIndex(I)Landroid/view/View;

    move-result-object v6

    .local v6, v:Landroid/view/View;
    if-eqz v6, :cond_20

    invoke-direct {p0, v6, v4}, Landroid/widget/StackView;->setupStackSlider(Landroid/view/View;I)V

    iput v5, p0, Landroid/widget/StackView;->mSwipeGestureType:I

    invoke-virtual {p0}, Landroid/widget/StackView;->cancelHandleClick()V

    goto :goto_20

    .end local v0           #activeIndex:I
    .end local v2           #beginningOfStack:Z
    .end local v3           #endOfStack:Z
    .end local v4           #stackMode:I
    .end local v6           #v:Landroid/view/View;
    :cond_70
    move v0, v7

    goto :goto_2e

    :cond_72
    if-ne v5, v8, :cond_76

    move v0, v7

    .restart local v0       #activeIndex:I
    :goto_75
    goto :goto_2e

    .end local v0           #activeIndex:I
    :cond_76
    move v0, v9

    goto :goto_75

    .restart local v0       #activeIndex:I
    :cond_78
    move v3, v9

    goto :goto_41

    .restart local v3       #endOfStack:Z
    :cond_7a
    move v2, v9

    goto :goto_54

    .restart local v2       #beginningOfStack:Z
    :cond_7c
    iget v8, p0, Landroid/widget/AdapterViewAnimator;->mCurrentWindowStartUnbounded:I

    add-int/2addr v8, v0

    const/4 v10, -0x1

    if-eq v8, v10, :cond_84

    if-eqz v2, :cond_88

    :cond_84
    add-int/lit8 v0, v0, 0x1

    const/4 v4, 0x1

    .restart local v4       #stackMode:I
    goto :goto_5d

    .end local v4           #stackMode:I
    :cond_88
    iget v8, p0, Landroid/widget/AdapterViewAnimator;->mCurrentWindowStartUnbounded:I

    add-int/2addr v8, v0

    add-int/lit8 v10, v1, -0x1

    if-eq v8, v10, :cond_91

    if-eqz v3, :cond_93

    :cond_91
    const/4 v4, 0x2

    .restart local v4       #stackMode:I
    goto :goto_5d

    .end local v4           #stackMode:I
    :cond_93
    const/4 v4, 0x0

    .restart local v4       #stackMode:I
    goto :goto_5d

    :cond_95
    move v7, v9

    goto :goto_5f
.end method

.method private handlePointerUp(Landroid/view/MotionEvent;)V
    .registers 15
    .parameter "ev"

    .prologue
    iget v9, p0, Landroid/widget/StackView;->mActivePointerId:I

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->findPointerIndex(I)I

    move-result v6

    .local v6, pointerIndex:I
    invoke-virtual {p1, v6}, Landroid/view/MotionEvent;->getY(I)F

    move-result v4

    .local v4, newY:F
    iget v9, p0, Landroid/widget/StackView;->mInitialY:F

    sub-float v9, v4, v9

    float-to-int v1, v9

    .local v1, deltaY:I
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v9

    iput-wide v9, p0, Landroid/widget/StackView;->mLastInteractionTime:J

    iget-object v9, p0, Landroid/widget/StackView;->mVelocityTracker:Landroid/view/VelocityTracker;

    if-eqz v9, :cond_2e

    iget-object v9, p0, Landroid/widget/StackView;->mVelocityTracker:Landroid/view/VelocityTracker;

    const/16 v10, 0x3e8

    iget v11, p0, Landroid/widget/StackView;->mMaximumVelocity:I

    int-to-float v11, v11

    invoke-virtual {v9, v10, v11}, Landroid/view/VelocityTracker;->computeCurrentVelocity(IF)V

    iget-object v9, p0, Landroid/widget/StackView;->mVelocityTracker:Landroid/view/VelocityTracker;

    iget v10, p0, Landroid/widget/StackView;->mActivePointerId:I

    invoke-virtual {v9, v10}, Landroid/view/VelocityTracker;->getYVelocity(I)F

    move-result v9

    float-to-int v9, v9

    iput v9, p0, Landroid/widget/StackView;->mYVelocity:I

    :cond_2e
    iget-object v9, p0, Landroid/widget/StackView;->mVelocityTracker:Landroid/view/VelocityTracker;

    if-eqz v9, :cond_3a

    iget-object v9, p0, Landroid/widget/StackView;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v9}, Landroid/view/VelocityTracker;->recycle()V

    const/4 v9, 0x0

    iput-object v9, p0, Landroid/widget/StackView;->mVelocityTracker:Landroid/view/VelocityTracker;

    :cond_3a
    iget v9, p0, Landroid/widget/StackView;->mSwipeThreshold:I

    if-le v1, v9, :cond_63

    iget v9, p0, Landroid/widget/StackView;->mSwipeGestureType:I

    const/4 v10, 0x2

    if-ne v9, v10, :cond_63

    iget-object v9, p0, Landroid/widget/StackView;->mStackSlider:Landroid/widget/StackView$StackSlider;

    iget v9, v9, Landroid/widget/StackView$StackSlider;->mMode:I

    if-nez v9, :cond_63

    const/4 v9, 0x0

    iput v9, p0, Landroid/widget/StackView;->mSwipeGestureType:I

    iget v9, p0, Landroid/widget/StackView;->mStackMode:I

    if-nez v9, :cond_5f

    invoke-virtual {p0}, Landroid/widget/StackView;->showPrevious()V

    :goto_53
    iget-object v9, p0, Landroid/widget/StackView;->mHighlight:Landroid/widget/ImageView;

    invoke-virtual {v9}, Landroid/widget/ImageView;->bringToFront()V

    :cond_58
    :goto_58
    const/4 v9, -0x1

    iput v9, p0, Landroid/widget/StackView;->mActivePointerId:I

    const/4 v9, 0x0

    iput v9, p0, Landroid/widget/StackView;->mSwipeGestureType:I

    return-void

    :cond_5f
    invoke-virtual {p0}, Landroid/widget/StackView;->showNext()V

    goto :goto_53

    :cond_63
    iget v9, p0, Landroid/widget/StackView;->mSwipeThreshold:I

    neg-int v9, v9

    if-ge v1, v9, :cond_87

    iget v9, p0, Landroid/widget/StackView;->mSwipeGestureType:I

    const/4 v10, 0x1

    if-ne v9, v10, :cond_87

    iget-object v9, p0, Landroid/widget/StackView;->mStackSlider:Landroid/widget/StackView$StackSlider;

    iget v9, v9, Landroid/widget/StackView$StackSlider;->mMode:I

    if-nez v9, :cond_87

    const/4 v9, 0x0

    iput v9, p0, Landroid/widget/StackView;->mSwipeGestureType:I

    iget v9, p0, Landroid/widget/StackView;->mStackMode:I

    if-nez v9, :cond_83

    invoke-virtual {p0}, Landroid/widget/StackView;->showNext()V

    :goto_7d
    iget-object v9, p0, Landroid/widget/StackView;->mHighlight:Landroid/widget/ImageView;

    invoke-virtual {v9}, Landroid/widget/ImageView;->bringToFront()V

    goto :goto_58

    :cond_83
    invoke-virtual {p0}, Landroid/widget/StackView;->showPrevious()V

    goto :goto_7d

    :cond_87
    iget v9, p0, Landroid/widget/StackView;->mSwipeGestureType:I

    const/4 v10, 0x1

    if-ne v9, v10, :cond_f2

    iget v9, p0, Landroid/widget/StackView;->mStackMode:I

    const/4 v10, 0x1

    if-ne v9, v10, :cond_e5

    const/high16 v3, 0x3f80

    .local v3, finalYProgress:F
    :goto_93
    iget v9, p0, Landroid/widget/StackView;->mStackMode:I

    if-eqz v9, :cond_9d

    iget-object v9, p0, Landroid/widget/StackView;->mStackSlider:Landroid/widget/StackView$StackSlider;

    iget v9, v9, Landroid/widget/StackView$StackSlider;->mMode:I

    if-eqz v9, :cond_e7

    :cond_9d
    iget-object v9, p0, Landroid/widget/StackView;->mStackSlider:Landroid/widget/StackView$StackSlider;

    invoke-virtual {v9}, Landroid/widget/StackView$StackSlider;->getDurationForNeutralPosition()F

    move-result v9

    invoke-static {v9}, Ljava/lang/Math;->round(F)I

    move-result v2

    .local v2, duration:I
    :goto_a7
    new-instance v0, Landroid/widget/StackView$StackSlider;

    iget-object v9, p0, Landroid/widget/StackView;->mStackSlider:Landroid/widget/StackView$StackSlider;

    invoke-direct {v0, p0, v9}, Landroid/widget/StackView$StackSlider;-><init>(Landroid/widget/StackView;Landroid/widget/StackView$StackSlider;)V

    .local v0, animationSlider:Landroid/widget/StackView$StackSlider;
    const-string v9, "YProgress"

    const/4 v10, 0x1

    new-array v10, v10, [F

    const/4 v11, 0x0

    aput v3, v10, v11

    invoke-static {v9, v10}, Landroid/animation/PropertyValuesHolder;->ofFloat(Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;

    move-result-object v8

    .local v8, snapBackY:Landroid/animation/PropertyValuesHolder;
    const-string v9, "XProgress"

    const/4 v10, 0x1

    new-array v10, v10, [F

    const/4 v11, 0x0

    const/4 v12, 0x0

    aput v12, v10, v11

    invoke-static {v9, v10}, Landroid/animation/PropertyValuesHolder;->ofFloat(Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;

    move-result-object v7

    .local v7, snapBackX:Landroid/animation/PropertyValuesHolder;
    const/4 v9, 0x2

    new-array v9, v9, [Landroid/animation/PropertyValuesHolder;

    const/4 v10, 0x0

    aput-object v7, v9, v10

    const/4 v10, 0x1

    aput-object v8, v9, v10

    invoke-static {v0, v9}, Landroid/animation/ObjectAnimator;->ofPropertyValuesHolder(Ljava/lang/Object;[Landroid/animation/PropertyValuesHolder;)Landroid/animation/ObjectAnimator;

    move-result-object v5

    .local v5, pa:Landroid/animation/ObjectAnimator;
    int-to-long v9, v2

    invoke-virtual {v5, v9, v10}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    new-instance v9, Landroid/view/animation/LinearInterpolator;

    invoke-direct {v9}, Landroid/view/animation/LinearInterpolator;-><init>()V

    invoke-virtual {v5, v9}, Landroid/animation/ObjectAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    invoke-virtual {v5}, Landroid/animation/ObjectAnimator;->start()V

    goto/16 :goto_58

    .end local v0           #animationSlider:Landroid/widget/StackView$StackSlider;
    .end local v2           #duration:I
    .end local v3           #finalYProgress:F
    .end local v5           #pa:Landroid/animation/ObjectAnimator;
    .end local v7           #snapBackX:Landroid/animation/PropertyValuesHolder;
    .end local v8           #snapBackY:Landroid/animation/PropertyValuesHolder;
    :cond_e5
    const/4 v3, 0x0

    goto :goto_93

    .restart local v3       #finalYProgress:F
    :cond_e7
    iget-object v9, p0, Landroid/widget/StackView;->mStackSlider:Landroid/widget/StackView$StackSlider;

    invoke-virtual {v9}, Landroid/widget/StackView$StackSlider;->getDurationForOffscreenPosition()F

    move-result v9

    invoke-static {v9}, Ljava/lang/Math;->round(F)I

    move-result v2

    .restart local v2       #duration:I
    goto :goto_a7

    .end local v2           #duration:I
    .end local v3           #finalYProgress:F
    :cond_f2
    iget v9, p0, Landroid/widget/StackView;->mSwipeGestureType:I

    const/4 v10, 0x2

    if-ne v9, v10, :cond_58

    iget v9, p0, Landroid/widget/StackView;->mStackMode:I

    const/4 v10, 0x1

    if-ne v9, v10, :cond_148

    const/4 v3, 0x0

    .restart local v3       #finalYProgress:F
    :goto_fd
    iget v9, p0, Landroid/widget/StackView;->mStackMode:I

    const/4 v10, 0x1

    if-eq v9, v10, :cond_108

    iget-object v9, p0, Landroid/widget/StackView;->mStackSlider:Landroid/widget/StackView$StackSlider;

    iget v9, v9, Landroid/widget/StackView$StackSlider;->mMode:I

    if-eqz v9, :cond_14b

    :cond_108
    iget-object v9, p0, Landroid/widget/StackView;->mStackSlider:Landroid/widget/StackView$StackSlider;

    invoke-virtual {v9}, Landroid/widget/StackView$StackSlider;->getDurationForNeutralPosition()F

    move-result v9

    invoke-static {v9}, Ljava/lang/Math;->round(F)I

    move-result v2

    .restart local v2       #duration:I
    :goto_112
    new-instance v0, Landroid/widget/StackView$StackSlider;

    iget-object v9, p0, Landroid/widget/StackView;->mStackSlider:Landroid/widget/StackView$StackSlider;

    invoke-direct {v0, p0, v9}, Landroid/widget/StackView$StackSlider;-><init>(Landroid/widget/StackView;Landroid/widget/StackView$StackSlider;)V

    .restart local v0       #animationSlider:Landroid/widget/StackView$StackSlider;
    const-string v9, "YProgress"

    const/4 v10, 0x1

    new-array v10, v10, [F

    const/4 v11, 0x0

    aput v3, v10, v11

    invoke-static {v9, v10}, Landroid/animation/PropertyValuesHolder;->ofFloat(Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;

    move-result-object v8

    .restart local v8       #snapBackY:Landroid/animation/PropertyValuesHolder;
    const-string v9, "XProgress"

    const/4 v10, 0x1

    new-array v10, v10, [F

    const/4 v11, 0x0

    const/4 v12, 0x0

    aput v12, v10, v11

    invoke-static {v9, v10}, Landroid/animation/PropertyValuesHolder;->ofFloat(Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;

    move-result-object v7

    .restart local v7       #snapBackX:Landroid/animation/PropertyValuesHolder;
    const/4 v9, 0x2

    new-array v9, v9, [Landroid/animation/PropertyValuesHolder;

    const/4 v10, 0x0

    aput-object v7, v9, v10

    const/4 v10, 0x1

    aput-object v8, v9, v10

    invoke-static {v0, v9}, Landroid/animation/ObjectAnimator;->ofPropertyValuesHolder(Ljava/lang/Object;[Landroid/animation/PropertyValuesHolder;)Landroid/animation/ObjectAnimator;

    move-result-object v5

    .restart local v5       #pa:Landroid/animation/ObjectAnimator;
    int-to-long v9, v2

    invoke-virtual {v5, v9, v10}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    invoke-virtual {v5}, Landroid/animation/ObjectAnimator;->start()V

    goto/16 :goto_58

    .end local v0           #animationSlider:Landroid/widget/StackView$StackSlider;
    .end local v2           #duration:I
    .end local v3           #finalYProgress:F
    .end local v5           #pa:Landroid/animation/ObjectAnimator;
    .end local v7           #snapBackX:Landroid/animation/PropertyValuesHolder;
    .end local v8           #snapBackY:Landroid/animation/PropertyValuesHolder;
    :cond_148
    const/high16 v3, 0x3f80

    goto :goto_fd

    .restart local v3       #finalYProgress:F
    :cond_14b
    iget-object v9, p0, Landroid/widget/StackView;->mStackSlider:Landroid/widget/StackView$StackSlider;

    invoke-virtual {v9}, Landroid/widget/StackView$StackSlider;->getDurationForOffscreenPosition()F

    move-result v9

    invoke-static {v9}, Ljava/lang/Math;->round(F)I

    move-result v2

    .restart local v2       #duration:I
    goto :goto_112
.end method

.method private initStackView()V
    .registers 9

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x1

    const/4 v5, -0x1

    const/4 v2, 0x5

    invoke-virtual {p0, v2, v6}, Landroid/widget/StackView;->configureViewAnimator(II)V

    invoke-virtual {p0, v6}, Landroid/widget/StackView;->setStaticTransformationsEnabled(Z)V

    invoke-virtual {p0}, Landroid/widget/StackView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v0

    .local v0, configuration:Landroid/view/ViewConfiguration;
    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledTouchSlop()I

    move-result v2

    iput v2, p0, Landroid/widget/StackView;->mTouchSlop:I

    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledMaximumFlingVelocity()I

    move-result v2

    iput v2, p0, Landroid/widget/StackView;->mMaximumVelocity:I

    iput v5, p0, Landroid/widget/StackView;->mActivePointerId:I

    new-instance v2, Landroid/widget/ImageView;

    invoke-virtual {p0}, Landroid/widget/StackView;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-direct {v2, v3}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    iput-object v2, p0, Landroid/widget/StackView;->mHighlight:Landroid/widget/ImageView;

    iget-object v2, p0, Landroid/widget/StackView;->mHighlight:Landroid/widget/ImageView;

    new-instance v3, Landroid/widget/StackView$LayoutParams;

    iget-object v4, p0, Landroid/widget/StackView;->mHighlight:Landroid/widget/ImageView;

    invoke-direct {v3, p0, v4}, Landroid/widget/StackView$LayoutParams;-><init>(Landroid/widget/StackView;Landroid/view/View;)V

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    iget-object v2, p0, Landroid/widget/StackView;->mHighlight:Landroid/widget/ImageView;

    new-instance v3, Landroid/widget/StackView$LayoutParams;

    iget-object v4, p0, Landroid/widget/StackView;->mHighlight:Landroid/widget/ImageView;

    invoke-direct {v3, p0, v4}, Landroid/widget/StackView$LayoutParams;-><init>(Landroid/widget/StackView;Landroid/view/View;)V

    invoke-virtual {p0, v2, v5, v3}, Landroid/widget/StackView;->addViewInLayout(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)Z

    new-instance v2, Landroid/widget/ImageView;

    invoke-virtual {p0}, Landroid/widget/StackView;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-direct {v2, v3}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    iput-object v2, p0, Landroid/widget/StackView;->mClickFeedback:Landroid/widget/ImageView;

    iget-object v2, p0, Landroid/widget/StackView;->mClickFeedback:Landroid/widget/ImageView;

    new-instance v3, Landroid/widget/StackView$LayoutParams;

    iget-object v4, p0, Landroid/widget/StackView;->mClickFeedback:Landroid/widget/ImageView;

    invoke-direct {v3, p0, v4}, Landroid/widget/StackView$LayoutParams;-><init>(Landroid/widget/StackView;Landroid/view/View;)V

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    iget-object v2, p0, Landroid/widget/StackView;->mClickFeedback:Landroid/widget/ImageView;

    new-instance v3, Landroid/widget/StackView$LayoutParams;

    iget-object v4, p0, Landroid/widget/StackView;->mClickFeedback:Landroid/widget/ImageView;

    invoke-direct {v3, p0, v4}, Landroid/widget/StackView$LayoutParams;-><init>(Landroid/widget/StackView;Landroid/view/View;)V

    invoke-virtual {p0, v2, v5, v3}, Landroid/widget/StackView;->addViewInLayout(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)Z

    iget-object v2, p0, Landroid/widget/StackView;->mClickFeedback:Landroid/widget/ImageView;

    const/4 v3, 0x4

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    new-instance v2, Landroid/widget/StackView$StackSlider;

    invoke-direct {v2, p0}, Landroid/widget/StackView$StackSlider;-><init>(Landroid/widget/StackView;)V

    iput-object v2, p0, Landroid/widget/StackView;->mStackSlider:Landroid/widget/StackView$StackSlider;

    sget-object v2, Landroid/widget/StackView;->sHolographicHelper:Landroid/widget/StackView$HolographicHelper;

    if-nez v2, :cond_80

    new-instance v2, Landroid/widget/StackView$HolographicHelper;

    iget-object v3, p0, Landroid/view/View;->mContext:Landroid/content/Context;

    invoke-direct {v2, v3}, Landroid/widget/StackView$HolographicHelper;-><init>(Landroid/content/Context;)V

    sput-object v2, Landroid/widget/StackView;->sHolographicHelper:Landroid/widget/StackView$HolographicHelper;

    :cond_80
    invoke-virtual {p0, v7}, Landroid/widget/StackView;->setClipChildren(Z)V

    invoke-virtual {p0, v7}, Landroid/widget/StackView;->setClipToPadding(Z)V

    iput v6, p0, Landroid/widget/StackView;->mStackMode:I

    iput v5, p0, Landroid/widget/AdapterViewAnimator;->mWhichChild:I

    iget-object v2, p0, Landroid/view/View;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    iget v1, v2, Landroid/util/DisplayMetrics;->density:F

    .local v1, density:F
    const/high16 v2, 0x4080

    mul-float/2addr v2, v1

    float-to-double v2, v2

    invoke-static {v2, v3}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v2

    double-to-int v2, v2

    iput v2, p0, Landroid/widget/StackView;->mFramePadding:I

    return-void
.end method

.method private measureChildren()V
    .registers 14

    .prologue
    invoke-virtual {p0}, Landroid/widget/StackView;->getChildCount()I

    move-result v5

    .local v5, count:I
    invoke-virtual {p0}, Landroid/widget/StackView;->getMeasuredWidth()I

    move-result v10

    .local v10, measuredWidth:I
    invoke-virtual {p0}, Landroid/widget/StackView;->getMeasuredHeight()I

    move-result v9

    .local v9, measuredHeight:I
    int-to-float v11, v10

    const v12, 0x3f666666

    mul-float/2addr v11, v12

    invoke-static {v11}, Ljava/lang/Math;->round(F)I

    move-result v11

    iget v12, p0, Landroid/view/View;->mPaddingLeft:I

    sub-int/2addr v11, v12

    iget v12, p0, Landroid/view/View;->mPaddingRight:I

    sub-int v4, v11, v12

    .local v4, childWidth:I
    int-to-float v11, v9

    const v12, 0x3f666666

    mul-float/2addr v11, v12

    invoke-static {v11}, Ljava/lang/Math;->round(F)I

    move-result v11

    iget v12, p0, Landroid/view/View;->mPaddingTop:I

    sub-int/2addr v11, v12

    iget v12, p0, Landroid/view/View;->mPaddingBottom:I

    sub-int v1, v11, v12

    .local v1, childHeight:I
    const/4 v8, 0x0

    .local v8, maxWidth:I
    const/4 v7, 0x0

    .local v7, maxHeight:I
    const/4 v6, 0x0

    .local v6, i:I
    :goto_2f
    if-ge v6, v5, :cond_5d

    invoke-virtual {p0, v6}, Landroid/widget/StackView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .local v0, child:Landroid/view/View;
    const/high16 v11, -0x8000

    invoke-static {v4, v11}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v11

    const/high16 v12, -0x8000

    invoke-static {v1, v12}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v12

    invoke-virtual {v0, v11, v12}, Landroid/view/View;->measure(II)V

    iget-object v11, p0, Landroid/widget/StackView;->mHighlight:Landroid/widget/ImageView;

    if-eq v0, v11, :cond_5a

    iget-object v11, p0, Landroid/widget/StackView;->mClickFeedback:Landroid/widget/ImageView;

    if-eq v0, v11, :cond_5a

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v3

    .local v3, childMeasuredWidth:I
    invoke-virtual {v0}, Landroid/view/View;->getMeasuredHeight()I

    move-result v2

    .local v2, childMeasuredHeight:I
    if-le v3, v8, :cond_57

    move v8, v3

    :cond_57
    if-le v2, v7, :cond_5a

    move v7, v2

    .end local v2           #childMeasuredHeight:I
    .end local v3           #childMeasuredWidth:I
    :cond_5a
    add-int/lit8 v6, v6, 0x1

    goto :goto_2f

    .end local v0           #child:Landroid/view/View;
    :cond_5d
    const v11, 0x3dcccccd

    int-to-float v12, v10

    mul-float/2addr v11, v12

    iput v11, p0, Landroid/widget/StackView;->mNewPerspectiveShiftX:F

    const v11, 0x3dcccccd

    int-to-float v12, v9

    mul-float/2addr v11, v12

    iput v11, p0, Landroid/widget/StackView;->mNewPerspectiveShiftY:F

    if-lez v8, :cond_76

    if-lez v5, :cond_76

    if-ge v8, v4, :cond_76

    sub-int v11, v10, v8

    int-to-float v11, v11

    iput v11, p0, Landroid/widget/StackView;->mNewPerspectiveShiftX:F

    :cond_76
    if-lez v7, :cond_81

    if-lez v5, :cond_81

    if-ge v7, v1, :cond_81

    sub-int v11, v9, v7

    int-to-float v11, v11

    iput v11, p0, Landroid/widget/StackView;->mNewPerspectiveShiftY:F

    :cond_81
    return-void
.end method

.method private onLayout()V
    .registers 4

    .prologue
    iget-boolean v1, p0, Landroid/widget/StackView;->mFirstLayoutHappened:Z

    if-nez v1, :cond_a

    const/4 v1, 0x1

    iput-boolean v1, p0, Landroid/widget/StackView;->mFirstLayoutHappened:Z

    invoke-direct {p0}, Landroid/widget/StackView;->updateChildTransforms()V

    :cond_a
    const v1, 0x3f333333

    invoke-virtual {p0}, Landroid/widget/StackView;->getMeasuredHeight()I

    move-result v2

    int-to-float v2, v2

    mul-float/2addr v1, v2

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v0

    .local v0, newSlideAmount:I
    iget v1, p0, Landroid/widget/StackView;->mSlideAmount:I

    if-eq v1, v0, :cond_28

    iput v0, p0, Landroid/widget/StackView;->mSlideAmount:I

    const v1, 0x3e4ccccd

    int-to-float v2, v0

    mul-float/2addr v1, v2

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v1

    iput v1, p0, Landroid/widget/StackView;->mSwipeThreshold:I

    :cond_28
    iget v1, p0, Landroid/widget/StackView;->mPerspectiveShiftY:F

    iget v2, p0, Landroid/widget/StackView;->mNewPerspectiveShiftY:F

    invoke-static {v1, v2}, Ljava/lang/Float;->compare(FF)I

    move-result v1

    if-nez v1, :cond_3c

    iget v1, p0, Landroid/widget/StackView;->mPerspectiveShiftX:F

    iget v2, p0, Landroid/widget/StackView;->mNewPerspectiveShiftX:F

    invoke-static {v1, v2}, Ljava/lang/Float;->compare(FF)I

    move-result v1

    if-eqz v1, :cond_47

    :cond_3c
    iget v1, p0, Landroid/widget/StackView;->mNewPerspectiveShiftY:F

    iput v1, p0, Landroid/widget/StackView;->mPerspectiveShiftY:F

    iget v1, p0, Landroid/widget/StackView;->mNewPerspectiveShiftX:F

    iput v1, p0, Landroid/widget/StackView;->mPerspectiveShiftX:F

    invoke-direct {p0}, Landroid/widget/StackView;->updateChildTransforms()V

    :cond_47
    return-void
.end method

.method private onSecondaryPointerUp(Landroid/view/MotionEvent;)V
    .registers 16
    .parameter "ev"

    .prologue
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionIndex()I

    move-result v0

    .local v0, activePointerIndex:I
    invoke-virtual {p1, v0}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v5

    .local v5, pointerId:I
    iget v9, p0, Landroid/widget/StackView;->mActivePointerId:I

    if-ne v5, v9, :cond_18

    iget v9, p0, Landroid/widget/StackView;->mSwipeGestureType:I

    const/4 v10, 0x2

    if-ne v9, v10, :cond_19

    const/4 v1, 0x0

    .local v1, activeViewIndex:I
    :goto_12
    invoke-virtual {p0, v1}, Landroid/widget/StackView;->getViewAtRelativeIndex(I)Landroid/view/View;

    move-result-object v6

    .local v6, v:Landroid/view/View;
    if-nez v6, :cond_1b

    .end local v1           #activeViewIndex:I
    .end local v6           #v:Landroid/view/View;
    :cond_18
    :goto_18
    return-void

    :cond_19
    const/4 v1, 0x1

    goto :goto_12

    .restart local v1       #activeViewIndex:I
    .restart local v6       #v:Landroid/view/View;
    :cond_1b
    const/4 v2, 0x0

    .local v2, index:I
    :goto_1c
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result v9

    if-ge v2, v9, :cond_7a

    if-eq v2, v0, :cond_77

    invoke-virtual {p1, v2}, Landroid/view/MotionEvent;->getX(I)F

    move-result v7

    .local v7, x:F
    invoke-virtual {p1, v2}, Landroid/view/MotionEvent;->getY(I)F

    move-result v8

    .local v8, y:F
    iget-object v9, p0, Landroid/widget/StackView;->mTouchRect:Landroid/graphics/Rect;

    invoke-virtual {v6}, Landroid/view/View;->getLeft()I

    move-result v10

    invoke-virtual {v6}, Landroid/view/View;->getTop()I

    move-result v11

    invoke-virtual {v6}, Landroid/view/View;->getRight()I

    move-result v12

    invoke-virtual {v6}, Landroid/view/View;->getBottom()I

    move-result v13

    invoke-virtual {v9, v10, v11, v12, v13}, Landroid/graphics/Rect;->set(IIII)V

    iget-object v9, p0, Landroid/widget/StackView;->mTouchRect:Landroid/graphics/Rect;

    invoke-static {v7}, Ljava/lang/Math;->round(F)I

    move-result v10

    invoke-static {v8}, Ljava/lang/Math;->round(F)I

    move-result v11

    invoke-virtual {v9, v10, v11}, Landroid/graphics/Rect;->contains(II)Z

    move-result v9

    if-eqz v9, :cond_77

    invoke-virtual {p1, v0}, Landroid/view/MotionEvent;->getX(I)F

    move-result v3

    .local v3, oldX:F
    invoke-virtual {p1, v0}, Landroid/view/MotionEvent;->getY(I)F

    move-result v4

    .local v4, oldY:F
    iget v9, p0, Landroid/widget/StackView;->mInitialY:F

    sub-float v10, v8, v4

    add-float/2addr v9, v10

    iput v9, p0, Landroid/widget/StackView;->mInitialY:F

    iget v9, p0, Landroid/widget/StackView;->mInitialX:F

    sub-float v10, v7, v3

    add-float/2addr v9, v10

    iput v9, p0, Landroid/widget/StackView;->mInitialX:F

    invoke-virtual {p1, v2}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v9

    iput v9, p0, Landroid/widget/StackView;->mActivePointerId:I

    iget-object v9, p0, Landroid/widget/StackView;->mVelocityTracker:Landroid/view/VelocityTracker;

    if-eqz v9, :cond_18

    iget-object v9, p0, Landroid/widget/StackView;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v9}, Landroid/view/VelocityTracker;->clear()V

    goto :goto_18

    .end local v3           #oldX:F
    .end local v4           #oldY:F
    .end local v7           #x:F
    .end local v8           #y:F
    :cond_77
    add-int/lit8 v2, v2, 0x1

    goto :goto_1c

    :cond_7a
    invoke-direct {p0, p1}, Landroid/widget/StackView;->handlePointerUp(Landroid/view/MotionEvent;)V

    goto :goto_18
.end method

.method private pacedScroll(Z)V
    .registers 8
    .parameter "up"

    .prologue
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-wide v4, p0, Landroid/widget/StackView;->mLastScrollTime:J

    sub-long v0, v2, v4

    .local v0, timeSinceLastScroll:J
    const-wide/16 v2, 0x64

    cmp-long v2, v0, v2

    if-lez v2, :cond_19

    if-eqz p1, :cond_1a

    invoke-virtual {p0}, Landroid/widget/StackView;->showPrevious()V

    :goto_13
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iput-wide v2, p0, Landroid/widget/StackView;->mLastScrollTime:J

    :cond_19
    return-void

    :cond_1a
    invoke-virtual {p0}, Landroid/widget/StackView;->showNext()V

    goto :goto_13
.end method

.method private setupStackSlider(Landroid/view/View;I)V
    .registers 6
    .parameter "v"
    .parameter "mode"

    .prologue
    iget-object v0, p0, Landroid/widget/StackView;->mStackSlider:Landroid/widget/StackView$StackSlider;

    invoke-virtual {v0, p2}, Landroid/widget/StackView$StackSlider;->setMode(I)V

    if-eqz p1, :cond_40

    iget-object v0, p0, Landroid/widget/StackView;->mHighlight:Landroid/widget/ImageView;

    sget-object v1, Landroid/widget/StackView;->sHolographicHelper:Landroid/widget/StackView$HolographicHelper;

    iget v2, p0, Landroid/widget/StackView;->mResOutColor:I

    invoke-virtual {v1, p1, v2}, Landroid/widget/StackView$HolographicHelper;->createResOutline(Landroid/view/View;I)Landroid/graphics/Bitmap;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    iget-object v0, p0, Landroid/widget/StackView;->mHighlight:Landroid/widget/ImageView;

    invoke-virtual {p1}, Landroid/view/View;->getRotation()F

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setRotation(F)V

    iget-object v0, p0, Landroid/widget/StackView;->mHighlight:Landroid/widget/ImageView;

    invoke-virtual {p1}, Landroid/view/View;->getTranslationY()F

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setTranslationY(F)V

    iget-object v0, p0, Landroid/widget/StackView;->mHighlight:Landroid/widget/ImageView;

    invoke-virtual {p1}, Landroid/view/View;->getTranslationX()F

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setTranslationX(F)V

    iget-object v0, p0, Landroid/widget/StackView;->mHighlight:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->bringToFront()V

    invoke-virtual {p1}, Landroid/view/View;->bringToFront()V

    iget-object v0, p0, Landroid/widget/StackView;->mStackSlider:Landroid/widget/StackView$StackSlider;

    invoke-virtual {v0, p1}, Landroid/widget/StackView$StackSlider;->setView(Landroid/view/View;)V

    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/view/View;->setVisibility(I)V

    :cond_40
    return-void
.end method

.method private transformViewAtIndex(ILandroid/view/View;Z)V
    .registers 24
    .parameter "index"
    .parameter "view"
    .parameter "animate"

    .prologue
    move-object/from16 v0, p0

    iget v3, v0, Landroid/widget/StackView;->mPerspectiveShiftY:F

    .local v3, maxPerspectiveShiftY:F
    move-object/from16 v0, p0

    iget v2, v0, Landroid/widget/StackView;->mPerspectiveShiftX:F

    .local v2, maxPerspectiveShiftX:F
    move-object/from16 v0, p0

    iget v0, v0, Landroid/widget/StackView;->mStackMode:I

    move/from16 v17, v0

    const/16 v18, 0x1

    move/from16 v0, v17

    move/from16 v1, v18

    if-ne v0, v1, :cond_127

    move-object/from16 v0, p0

    iget v0, v0, Landroid/widget/AdapterViewAnimator;->mMaxNumActiveViews:I

    move/from16 v17, v0

    sub-int v17, v17, p1

    add-int/lit8 p1, v17, -0x1

    move-object/from16 v0, p0

    iget v0, v0, Landroid/widget/AdapterViewAnimator;->mMaxNumActiveViews:I

    move/from16 v17, v0

    add-int/lit8 v17, v17, -0x1

    move/from16 v0, p1

    move/from16 v1, v17

    if-ne v0, v1, :cond_30

    add-int/lit8 p1, p1, -0x1

    :cond_30
    :goto_30
    move/from16 v0, p1

    int-to-float v0, v0

    move/from16 v17, v0

    const/high16 v18, 0x3f80

    mul-float v17, v17, v18

    move-object/from16 v0, p0

    iget v0, v0, Landroid/widget/AdapterViewAnimator;->mMaxNumActiveViews:I

    move/from16 v18, v0

    add-int/lit8 v18, v18, -0x2

    move/from16 v0, v18

    int-to-float v0, v0

    move/from16 v18, v0

    div-float v7, v17, v18

    .local v7, r:F
    const/high16 v17, 0x3f80

    const/16 v18, 0x0

    const/high16 v19, 0x3f80

    sub-float v19, v19, v7

    mul-float v18, v18, v19

    sub-float v8, v17, v18

    .local v8, scale:F
    mul-float v6, v7, v3

    .local v6, perspectiveTranslationY:F
    const/high16 v17, 0x3f80

    sub-float v17, v8, v17

    invoke-virtual/range {p0 .. p0}, Landroid/widget/StackView;->getMeasuredHeight()I

    move-result v18

    move/from16 v0, v18

    int-to-float v0, v0

    move/from16 v18, v0

    const v19, 0x3f666666

    mul-float v18, v18, v19

    const/high16 v19, 0x4000

    div-float v18, v18, v19

    mul-float v12, v17, v18

    .local v12, scaleShiftCorrectionY:F
    add-float v14, v6, v12

    .local v14, transY:F
    const/high16 v17, 0x3f80

    sub-float v17, v17, v7

    mul-float v5, v17, v2

    .local v5, perspectiveTranslationX:F
    const/high16 v17, 0x3f80

    sub-float v17, v17, v8

    invoke-virtual/range {p0 .. p0}, Landroid/widget/StackView;->getMeasuredWidth()I

    move-result v18

    move/from16 v0, v18

    int-to-float v0, v0

    move/from16 v18, v0

    const v19, 0x3f666666

    mul-float v18, v18, v19

    const/high16 v19, 0x4000

    div-float v18, v18, v19

    mul-float v11, v17, v18

    .local v11, scaleShiftCorrectionX:F
    add-float v13, v5, v11

    .local v13, transX:F
    move-object/from16 v0, p2

    instance-of v0, v0, Landroid/widget/StackView$StackFrame;

    move/from16 v17, v0

    if-eqz v17, :cond_9f

    move-object/from16 v17, p2

    check-cast v17, Landroid/widget/StackView$StackFrame;

    invoke-virtual/range {v17 .. v17}, Landroid/widget/StackView$StackFrame;->cancelTransformAnimator()Z

    :cond_9f
    if-eqz p3, :cond_12f

    const-string/jumbo v17, "translationX"

    const/16 v18, 0x1

    move/from16 v0, v18

    new-array v0, v0, [F

    move-object/from16 v18, v0

    const/16 v19, 0x0

    aput v13, v18, v19

    invoke-static/range {v17 .. v18}, Landroid/animation/PropertyValuesHolder;->ofFloat(Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;

    move-result-object v15

    .local v15, translationX:Landroid/animation/PropertyValuesHolder;
    const-string/jumbo v17, "translationY"

    const/16 v18, 0x1

    move/from16 v0, v18

    new-array v0, v0, [F

    move-object/from16 v18, v0

    const/16 v19, 0x0

    aput v14, v18, v19

    invoke-static/range {v17 .. v18}, Landroid/animation/PropertyValuesHolder;->ofFloat(Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;

    move-result-object v16

    .local v16, translationY:Landroid/animation/PropertyValuesHolder;
    const-string/jumbo v17, "scaleX"

    const/16 v18, 0x1

    move/from16 v0, v18

    new-array v0, v0, [F

    move-object/from16 v18, v0

    const/16 v19, 0x0

    aput v8, v18, v19

    invoke-static/range {v17 .. v18}, Landroid/animation/PropertyValuesHolder;->ofFloat(Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;

    move-result-object v9

    .local v9, scalePropX:Landroid/animation/PropertyValuesHolder;
    const-string/jumbo v17, "scaleY"

    const/16 v18, 0x1

    move/from16 v0, v18

    new-array v0, v0, [F

    move-object/from16 v18, v0

    const/16 v19, 0x0

    aput v8, v18, v19

    invoke-static/range {v17 .. v18}, Landroid/animation/PropertyValuesHolder;->ofFloat(Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;

    move-result-object v10

    .local v10, scalePropY:Landroid/animation/PropertyValuesHolder;
    const/16 v17, 0x4

    move/from16 v0, v17

    new-array v0, v0, [Landroid/animation/PropertyValuesHolder;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    aput-object v9, v17, v18

    const/16 v18, 0x1

    aput-object v10, v17, v18

    const/16 v18, 0x2

    aput-object v16, v17, v18

    const/16 v18, 0x3

    aput-object v15, v17, v18

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    invoke-static {v0, v1}, Landroid/animation/ObjectAnimator;->ofPropertyValuesHolder(Ljava/lang/Object;[Landroid/animation/PropertyValuesHolder;)Landroid/animation/ObjectAnimator;

    move-result-object v4

    .local v4, oa:Landroid/animation/ObjectAnimator;
    const-wide/16 v17, 0x64

    move-wide/from16 v0, v17

    invoke-virtual {v4, v0, v1}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    move-object/from16 v0, p2

    instance-of v0, v0, Landroid/widget/StackView$StackFrame;

    move/from16 v17, v0

    if-eqz v17, :cond_123

    check-cast p2, Landroid/widget/StackView$StackFrame;

    .end local p2
    move-object/from16 v0, p2

    invoke-virtual {v0, v4}, Landroid/widget/StackView$StackFrame;->setTransformAnimator(Landroid/animation/ObjectAnimator;)V

    :cond_123
    invoke-virtual {v4}, Landroid/animation/ObjectAnimator;->start()V

    .end local v4           #oa:Landroid/animation/ObjectAnimator;
    .end local v9           #scalePropX:Landroid/animation/PropertyValuesHolder;
    .end local v10           #scalePropY:Landroid/animation/PropertyValuesHolder;
    .end local v15           #translationX:Landroid/animation/PropertyValuesHolder;
    .end local v16           #translationY:Landroid/animation/PropertyValuesHolder;
    :goto_126
    return-void

    .end local v5           #perspectiveTranslationX:F
    .end local v6           #perspectiveTranslationY:F
    .end local v7           #r:F
    .end local v8           #scale:F
    .end local v11           #scaleShiftCorrectionX:F
    .end local v12           #scaleShiftCorrectionY:F
    .end local v13           #transX:F
    .end local v14           #transY:F
    .restart local p2
    :cond_127
    add-int/lit8 p1, p1, -0x1

    if-gez p1, :cond_30

    add-int/lit8 p1, p1, 0x1

    goto/16 :goto_30

    .restart local v5       #perspectiveTranslationX:F
    .restart local v6       #perspectiveTranslationY:F
    .restart local v7       #r:F
    .restart local v8       #scale:F
    .restart local v11       #scaleShiftCorrectionX:F
    .restart local v12       #scaleShiftCorrectionY:F
    .restart local v13       #transX:F
    .restart local v14       #transY:F
    :cond_12f
    move-object/from16 v0, p2

    invoke-virtual {v0, v13}, Landroid/view/View;->setTranslationX(F)V

    move-object/from16 v0, p2

    invoke-virtual {v0, v14}, Landroid/view/View;->setTranslationY(F)V

    move-object/from16 v0, p2

    invoke-virtual {v0, v8}, Landroid/view/View;->setScaleX(F)V

    move-object/from16 v0, p2

    invoke-virtual {v0, v8}, Landroid/view/View;->setScaleY(F)V

    goto :goto_126
.end method

.method private updateChildTransforms()V
    .registers 4

    .prologue
    const/4 v0, 0x0

    .local v0, i:I
    :goto_1
    invoke-virtual {p0}, Landroid/widget/StackView;->getNumActiveViews()I

    move-result v2

    if-ge v0, v2, :cond_14

    invoke-virtual {p0, v0}, Landroid/widget/StackView;->getViewAtRelativeIndex(I)Landroid/view/View;

    move-result-object v1

    .local v1, v:Landroid/view/View;
    if-eqz v1, :cond_11

    const/4 v2, 0x0

    invoke-direct {p0, v0, v1, v2}, Landroid/widget/StackView;->transformViewAtIndex(ILandroid/view/View;Z)V

    :cond_11
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .end local v1           #v:Landroid/view/View;
    :cond_14
    return-void
.end method


# virtual methods
.method public advance()V
    .registers 8

    .prologue
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    iget-wide v5, p0, Landroid/widget/StackView;->mLastInteractionTime:J

    sub-long v1, v3, v5

    .local v1, timeSinceLastInteraction:J
    iget-object v3, p0, Landroid/widget/AdapterViewAnimator;->mAdapter:Landroid/widget/Adapter;

    if-nez v3, :cond_d

    :cond_c
    :goto_c
    return-void

    :cond_d
    invoke-virtual {p0}, Landroid/widget/StackView;->getCount()I

    move-result v0

    .local v0, adapterCount:I
    const/4 v3, 0x1

    if-ne v0, v3, :cond_18

    iget-boolean v3, p0, Landroid/widget/AdapterViewAnimator;->mLoopViews:Z

    if-nez v3, :cond_c

    :cond_18
    iget v3, p0, Landroid/widget/StackView;->mSwipeGestureType:I

    if-nez v3, :cond_c

    const-wide/16 v3, 0x1388

    cmp-long v3, v1, v3

    if-lez v3, :cond_c

    invoke-virtual {p0}, Landroid/widget/StackView;->showNext()V

    goto :goto_c
.end method

.method applyTransformForChildAtIndex(Landroid/view/View;I)V
    .registers 3
    .parameter "child"
    .parameter "relativeIndex"

    .prologue
    return-void
.end method

.method bridge synthetic createOrReuseLayoutParams(Landroid/view/View;)Landroid/view/ViewGroup$LayoutParams;
    .registers 3
    .parameter "x0"

    .prologue
    invoke-virtual {p0, p1}, Landroid/widget/StackView;->createOrReuseLayoutParams(Landroid/view/View;)Landroid/widget/StackView$LayoutParams;

    move-result-object v0

    return-object v0
.end method

.method createOrReuseLayoutParams(Landroid/view/View;)Landroid/widget/StackView$LayoutParams;
    .registers 6
    .parameter "v"

    .prologue
    const/4 v3, 0x0

    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .local v0, currentLp:Landroid/view/ViewGroup$LayoutParams;
    instance-of v2, v0, Landroid/widget/StackView$LayoutParams;

    if-eqz v2, :cond_17

    move-object v1, v0

    check-cast v1, Landroid/widget/StackView$LayoutParams;

    .local v1, lp:Landroid/widget/StackView$LayoutParams;
    invoke-virtual {v1, v3}, Landroid/widget/StackView$LayoutParams;->setHorizontalOffset(I)V

    invoke-virtual {v1, v3}, Landroid/widget/StackView$LayoutParams;->setVerticalOffset(I)V

    iput v3, v1, Landroid/view/ViewGroup$LayoutParams;->width:I

    iput v3, v1, Landroid/view/ViewGroup$LayoutParams;->width:I

    .end local v1           #lp:Landroid/widget/StackView$LayoutParams;
    :goto_16
    return-object v1

    :cond_17
    new-instance v1, Landroid/widget/StackView$LayoutParams;

    invoke-direct {v1, p0, p1}, Landroid/widget/StackView$LayoutParams;-><init>(Landroid/widget/StackView;Landroid/view/View;)V

    goto :goto_16
.end method

.method protected dispatchDraw(Landroid/graphics/Canvas;)V
    .registers 10
    .parameter "canvas"

    .prologue
    const/4 v3, 0x0

    .local v3, expandClipRegion:Z
    iget-object v6, p0, Landroid/widget/StackView;->stackInvalidateRect:Landroid/graphics/Rect;

    invoke-virtual {p1, v6}, Landroid/graphics/Canvas;->getClipBounds(Landroid/graphics/Rect;)Z

    invoke-virtual {p0}, Landroid/widget/StackView;->getChildCount()I

    move-result v1

    .local v1, childCount:I
    const/4 v4, 0x0

    .local v4, i:I
    :goto_b
    if-ge v4, v1, :cond_44

    invoke-virtual {p0, v4}, Landroid/widget/StackView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .local v0, child:Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v5

    check-cast v5, Landroid/widget/StackView$LayoutParams;

    .local v5, lp:Landroid/widget/StackView$LayoutParams;
    iget v6, v5, Landroid/widget/StackView$LayoutParams;->horizontalOffset:I

    if-nez v6, :cond_1f

    iget v6, v5, Landroid/widget/StackView$LayoutParams;->verticalOffset:I

    if-eqz v6, :cond_2e

    :cond_1f
    invoke-virtual {v0}, Landroid/view/View;->getAlpha()F

    move-result v6

    const/4 v7, 0x0

    cmpl-float v6, v6, v7

    if-eqz v6, :cond_2e

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v6

    if-eqz v6, :cond_31

    :cond_2e
    invoke-virtual {v5}, Landroid/widget/StackView$LayoutParams;->resetInvalidateRect()V

    :cond_31
    invoke-virtual {v5}, Landroid/widget/StackView$LayoutParams;->getInvalidateRect()Landroid/graphics/Rect;

    move-result-object v2

    .local v2, childInvalidateRect:Landroid/graphics/Rect;
    invoke-virtual {v2}, Landroid/graphics/Rect;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_41

    const/4 v3, 0x1

    iget-object v6, p0, Landroid/widget/StackView;->stackInvalidateRect:Landroid/graphics/Rect;

    invoke-virtual {v6, v2}, Landroid/graphics/Rect;->union(Landroid/graphics/Rect;)V

    :cond_41
    add-int/lit8 v4, v4, 0x1

    goto :goto_b

    .end local v0           #child:Landroid/view/View;
    .end local v2           #childInvalidateRect:Landroid/graphics/Rect;
    .end local v5           #lp:Landroid/widget/StackView$LayoutParams;
    :cond_44
    if-eqz v3, :cond_58

    const/4 v6, 0x2

    invoke-virtual {p1, v6}, Landroid/graphics/Canvas;->save(I)I

    iget-object v6, p0, Landroid/widget/StackView;->stackInvalidateRect:Landroid/graphics/Rect;

    sget-object v7, Landroid/graphics/Region$Op;->UNION:Landroid/graphics/Region$Op;

    invoke-virtual {p1, v6, v7}, Landroid/graphics/Canvas;->clipRect(Landroid/graphics/Rect;Landroid/graphics/Region$Op;)Z

    invoke-super {p0, p1}, Landroid/widget/AdapterViewAnimator;->dispatchDraw(Landroid/graphics/Canvas;)V

    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    :goto_57
    return-void

    :cond_58
    invoke-super {p0, p1}, Landroid/widget/AdapterViewAnimator;->dispatchDraw(Landroid/graphics/Canvas;)V

    goto :goto_57
.end method

.method getFrameForChild()Landroid/widget/FrameLayout;
    .registers 6

    .prologue
    new-instance v0, Landroid/widget/StackView$StackFrame;

    iget-object v1, p0, Landroid/view/View;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/widget/StackView$StackFrame;-><init>(Landroid/content/Context;)V

    .local v0, fl:Landroid/widget/StackView$StackFrame;
    iget v1, p0, Landroid/widget/StackView;->mFramePadding:I

    iget v2, p0, Landroid/widget/StackView;->mFramePadding:I

    iget v3, p0, Landroid/widget/StackView;->mFramePadding:I

    iget v4, p0, Landroid/widget/StackView;->mFramePadding:I

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/widget/StackView$StackFrame;->setPadding(IIII)V

    return-object v0
.end method

.method hideTapFeedback(Landroid/view/View;)V
    .registers 4
    .parameter "v"

    .prologue
    iget-object v0, p0, Landroid/widget/StackView;->mClickFeedback:Landroid/widget/ImageView;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    invoke-virtual {p0}, Landroid/widget/StackView;->invalidate()V

    return-void
.end method

.method public onGenericMotionEvent(Landroid/view/MotionEvent;)Z
    .registers 6
    .parameter "event"

    .prologue
    const/4 v3, 0x0

    const/4 v1, 0x1

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getSource()I

    move-result v2

    and-int/lit8 v2, v2, 0x2

    if-eqz v2, :cond_11

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v2

    packed-switch v2, :pswitch_data_2e

    :cond_11
    invoke-super {p0, p1}, Landroid/widget/AdapterViewAnimator;->onGenericMotionEvent(Landroid/view/MotionEvent;)Z

    move-result v1

    :goto_15
    return v1

    :pswitch_16
    const/16 v2, 0x9

    invoke-virtual {p1, v2}, Landroid/view/MotionEvent;->getAxisValue(I)F

    move-result v0

    .local v0, vscroll:F
    cmpg-float v2, v0, v3

    if-gez v2, :cond_25

    const/4 v2, 0x0

    invoke-direct {p0, v2}, Landroid/widget/StackView;->pacedScroll(Z)V

    goto :goto_15

    :cond_25
    cmpl-float v2, v0, v3

    if-lez v2, :cond_11

    invoke-direct {p0, v1}, Landroid/widget/StackView;->pacedScroll(Z)V

    goto :goto_15

    nop

    :pswitch_data_2e
    .packed-switch 0x8
        :pswitch_16
    .end packed-switch
.end method

.method public onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V
    .registers 3
    .parameter "event"

    .prologue
    invoke-super {p0, p1}, Landroid/widget/AdapterViewAnimator;->onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V

    const-class v0, Landroid/widget/StackView;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityEvent;->setClassName(Ljava/lang/CharSequence;)V

    return-void
.end method

.method public onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V
    .registers 4
    .parameter "info"

    .prologue
    const/4 v0, 0x1

    invoke-super {p0, p1}, Landroid/widget/AdapterViewAnimator;->onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V

    const-class v1, Landroid/widget/StackView;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Landroid/view/accessibility/AccessibilityNodeInfo;->setClassName(Ljava/lang/CharSequence;)V

    invoke-virtual {p0}, Landroid/widget/StackView;->getChildCount()I

    move-result v1

    if-le v1, v0, :cond_39

    :goto_13
    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->setScrollable(Z)V

    invoke-virtual {p0}, Landroid/widget/StackView;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_38

    invoke-virtual {p0}, Landroid/widget/StackView;->getDisplayedChild()I

    move-result v0

    invoke-virtual {p0}, Landroid/widget/StackView;->getChildCount()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    if-ge v0, v1, :cond_2d

    const/16 v0, 0x1000

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->addAction(I)V

    :cond_2d
    invoke-virtual {p0}, Landroid/widget/StackView;->getDisplayedChild()I

    move-result v0

    if-lez v0, :cond_38

    const/16 v0, 0x2000

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->addAction(I)V

    :cond_38
    return-void

    :cond_39
    const/4 v0, 0x0

    goto :goto_13
.end method

.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .registers 9
    .parameter "ev"

    .prologue
    const/4 v6, -0x1

    const/4 v4, 0x0

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    .local v0, action:I
    and-int/lit16 v5, v0, 0xff

    packed-switch v5, :pswitch_data_4e

    :cond_b
    :goto_b
    :pswitch_b
    iget v5, p0, Landroid/widget/StackView;->mSwipeGestureType:I

    if-eqz v5, :cond_10

    const/4 v4, 0x1

    :cond_10
    :goto_10
    return v4

    :pswitch_11
    iget v5, p0, Landroid/widget/StackView;->mActivePointerId:I

    if-ne v5, v6, :cond_b

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v5

    iput v5, p0, Landroid/widget/StackView;->mInitialX:F

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v5

    iput v5, p0, Landroid/widget/StackView;->mInitialY:F

    invoke-virtual {p1, v4}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v5

    iput v5, p0, Landroid/widget/StackView;->mActivePointerId:I

    goto :goto_b

    :pswitch_28
    iget v5, p0, Landroid/widget/StackView;->mActivePointerId:I

    invoke-virtual {p1, v5}, Landroid/view/MotionEvent;->findPointerIndex(I)I

    move-result v3

    .local v3, pointerIndex:I
    if-ne v3, v6, :cond_38

    const-string v5, "StackView"

    const-string v6, "Error: No data for our primary pointer."

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_10

    :cond_38
    invoke-virtual {p1, v3}, Landroid/view/MotionEvent;->getY(I)F

    move-result v2

    .local v2, newY:F
    iget v5, p0, Landroid/widget/StackView;->mInitialY:F

    sub-float v1, v2, v5

    .local v1, deltaY:F
    invoke-direct {p0, v1}, Landroid/widget/StackView;->beginGestureIfNeeded(F)V

    goto :goto_b

    .end local v1           #deltaY:F
    .end local v2           #newY:F
    .end local v3           #pointerIndex:I
    :pswitch_44
    invoke-direct {p0, p1}, Landroid/widget/StackView;->onSecondaryPointerUp(Landroid/view/MotionEvent;)V

    goto :goto_b

    :pswitch_48
    iput v6, p0, Landroid/widget/StackView;->mActivePointerId:I

    iput v4, p0, Landroid/widget/StackView;->mSwipeGestureType:I

    goto :goto_b

    nop

    :pswitch_data_4e
    .packed-switch 0x0
        :pswitch_11
        :pswitch_48
        :pswitch_28
        :pswitch_48
        :pswitch_b
        :pswitch_b
        :pswitch_44
    .end packed-switch
.end method

.method protected onLayout(ZIIII)V
    .registers 16
    .parameter "changed"
    .parameter "left"
    .parameter "top"
    .parameter "right"
    .parameter "bottom"

    .prologue
    invoke-virtual {p0}, Landroid/widget/StackView;->checkForAndHandleDataChanged()V

    invoke-virtual {p0}, Landroid/widget/StackView;->getChildCount()I

    move-result v2

    .local v2, childCount:I
    const/4 v4, 0x0

    .local v4, i:I
    :goto_8
    if-ge v4, v2, :cond_3a

    invoke-virtual {p0, v4}, Landroid/widget/StackView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .local v0, child:Landroid/view/View;
    iget v6, p0, Landroid/view/View;->mPaddingLeft:I

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v7

    add-int v3, v6, v7

    .local v3, childRight:I
    iget v6, p0, Landroid/view/View;->mPaddingTop:I

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredHeight()I

    move-result v7

    add-int v1, v6, v7

    .local v1, childBottom:I
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v5

    check-cast v5, Landroid/widget/StackView$LayoutParams;

    .local v5, lp:Landroid/widget/StackView$LayoutParams;
    iget v6, p0, Landroid/view/View;->mPaddingLeft:I

    iget v7, v5, Landroid/widget/StackView$LayoutParams;->horizontalOffset:I

    add-int/2addr v6, v7

    iget v7, p0, Landroid/view/View;->mPaddingTop:I

    iget v8, v5, Landroid/widget/StackView$LayoutParams;->verticalOffset:I

    add-int/2addr v7, v8

    iget v8, v5, Landroid/widget/StackView$LayoutParams;->horizontalOffset:I

    add-int/2addr v8, v3

    iget v9, v5, Landroid/widget/StackView$LayoutParams;->verticalOffset:I

    add-int/2addr v9, v1

    invoke-virtual {v0, v6, v7, v8, v9}, Landroid/view/View;->layout(IIII)V

    add-int/lit8 v4, v4, 0x1

    goto :goto_8

    .end local v0           #child:Landroid/view/View;
    .end local v1           #childBottom:I
    .end local v3           #childRight:I
    .end local v5           #lp:Landroid/widget/StackView$LayoutParams;
    :cond_3a
    invoke-direct {p0}, Landroid/widget/StackView;->onLayout()V

    return-void
.end method

.method protected onMeasure(II)V
    .registers 14
    .parameter "widthMeasureSpec"
    .parameter "heightMeasureSpec"

    .prologue
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v8

    .local v8, widthSpecSize:I
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v5

    .local v5, heightSpecSize:I
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v7

    .local v7, widthSpecMode:I
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v4

    .local v4, heightSpecMode:I
    iget v9, p0, Landroid/widget/AdapterViewAnimator;->mReferenceChildWidth:I

    const/4 v10, -0x1

    if-eq v9, v10, :cond_54

    iget v9, p0, Landroid/widget/AdapterViewAnimator;->mReferenceChildHeight:I

    const/4 v10, -0x1

    if-eq v9, v10, :cond_54

    const/4 v2, 0x1

    .local v2, haveChildRefSize:Z
    :goto_1b
    const v1, 0x3f8e38e4

    .local v1, factorY:F
    if-nez v4, :cond_58

    if-eqz v2, :cond_56

    iget v9, p0, Landroid/widget/AdapterViewAnimator;->mReferenceChildHeight:I

    int-to-float v9, v9

    const/high16 v10, 0x3f80

    add-float/2addr v10, v1

    mul-float/2addr v9, v10

    invoke-static {v9}, Ljava/lang/Math;->round(F)I

    move-result v9

    iget v10, p0, Landroid/view/View;->mPaddingTop:I

    add-int/2addr v9, v10

    iget v10, p0, Landroid/view/View;->mPaddingBottom:I

    add-int v5, v9, v10

    :cond_34
    :goto_34
    const v0, 0x3f8e38e4

    .local v0, factorX:F
    if-nez v7, :cond_7c

    if-eqz v2, :cond_7a

    iget v9, p0, Landroid/widget/AdapterViewAnimator;->mReferenceChildWidth:I

    int-to-float v9, v9

    const/high16 v10, 0x3f80

    add-float/2addr v10, v0

    mul-float/2addr v9, v10

    invoke-static {v9}, Ljava/lang/Math;->round(F)I

    move-result v9

    iget v10, p0, Landroid/view/View;->mPaddingLeft:I

    add-int/2addr v9, v10

    iget v10, p0, Landroid/view/View;->mPaddingRight:I

    add-int v8, v9, v10

    :cond_4d
    :goto_4d
    invoke-virtual {p0, v8, v5}, Landroid/widget/StackView;->setMeasuredDimension(II)V

    invoke-direct {p0}, Landroid/widget/StackView;->measureChildren()V

    return-void

    .end local v0           #factorX:F
    .end local v1           #factorY:F
    .end local v2           #haveChildRefSize:Z
    :cond_54
    const/4 v2, 0x0

    goto :goto_1b

    .restart local v1       #factorY:F
    .restart local v2       #haveChildRefSize:Z
    :cond_56
    const/4 v5, 0x0

    goto :goto_34

    :cond_58
    const/high16 v9, -0x8000

    if-ne v4, v9, :cond_34

    if-eqz v2, :cond_78

    iget v9, p0, Landroid/widget/AdapterViewAnimator;->mReferenceChildHeight:I

    int-to-float v9, v9

    const/high16 v10, 0x3f80

    add-float/2addr v10, v1

    mul-float/2addr v9, v10

    invoke-static {v9}, Ljava/lang/Math;->round(F)I

    move-result v9

    iget v10, p0, Landroid/view/View;->mPaddingTop:I

    add-int/2addr v9, v10

    iget v10, p0, Landroid/view/View;->mPaddingBottom:I

    add-int v3, v9, v10

    .local v3, height:I
    if-gt v3, v5, :cond_74

    move v5, v3

    goto :goto_34

    :cond_74
    const/high16 v9, 0x100

    or-int/2addr v5, v9

    goto :goto_34

    .end local v3           #height:I
    :cond_78
    const/4 v5, 0x0

    goto :goto_34

    .restart local v0       #factorX:F
    :cond_7a
    const/4 v8, 0x0

    goto :goto_4d

    :cond_7c
    const/high16 v9, -0x8000

    if-ne v4, v9, :cond_4d

    if-eqz v2, :cond_93

    iget v9, p0, Landroid/widget/AdapterViewAnimator;->mReferenceChildWidth:I

    iget v10, p0, Landroid/view/View;->mPaddingLeft:I

    add-int/2addr v9, v10

    iget v10, p0, Landroid/view/View;->mPaddingRight:I

    add-int v6, v9, v10

    .local v6, width:I
    if-gt v6, v8, :cond_8f

    move v8, v6

    goto :goto_4d

    :cond_8f
    const/high16 v9, 0x100

    or-int/2addr v8, v9

    goto :goto_4d

    .end local v6           #width:I
    :cond_93
    const/4 v8, 0x0

    goto :goto_4d
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .registers 15
    .parameter "ev"

    .prologue
    const/4 v8, 0x0

    const/4 v12, -0x1

    const/4 v9, 0x1

    const/high16 v11, 0x3f80

    invoke-super {p0, p1}, Landroid/widget/AdapterViewAnimator;->onTouchEvent(Landroid/view/MotionEvent;)Z

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    .local v0, action:I
    iget v10, p0, Landroid/widget/StackView;->mActivePointerId:I

    invoke-virtual {p1, v10}, Landroid/view/MotionEvent;->findPointerIndex(I)I

    move-result v5

    .local v5, pointerIndex:I
    if-ne v5, v12, :cond_1c

    const-string v9, "StackView"

    const-string v10, "Error: No data for our primary pointer."

    invoke-static {v9, v10}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :goto_1b
    return v8

    :cond_1c
    invoke-virtual {p1, v5}, Landroid/view/MotionEvent;->getY(I)F

    move-result v4

    .local v4, newY:F
    invoke-virtual {p1, v5}, Landroid/view/MotionEvent;->getX(I)F

    move-result v3

    .local v3, newX:F
    iget v10, p0, Landroid/widget/StackView;->mInitialY:F

    sub-float v2, v4, v10

    .local v2, deltaY:F
    iget v10, p0, Landroid/widget/StackView;->mInitialX:F

    sub-float v1, v3, v10

    .local v1, deltaX:F
    iget-object v10, p0, Landroid/widget/StackView;->mVelocityTracker:Landroid/view/VelocityTracker;

    if-nez v10, :cond_36

    invoke-static {}, Landroid/view/VelocityTracker;->obtain()Landroid/view/VelocityTracker;

    move-result-object v10

    iput-object v10, p0, Landroid/widget/StackView;->mVelocityTracker:Landroid/view/VelocityTracker;

    :cond_36
    iget-object v10, p0, Landroid/widget/StackView;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v10, p1}, Landroid/view/VelocityTracker;->addMovement(Landroid/view/MotionEvent;)V

    and-int/lit16 v10, v0, 0xff

    packed-switch v10, :pswitch_data_a0

    :cond_40
    :goto_40
    :pswitch_40
    move v8, v9

    goto :goto_1b

    :pswitch_42
    invoke-direct {p0, v2}, Landroid/widget/StackView;->beginGestureIfNeeded(F)V

    iget v8, p0, Landroid/widget/StackView;->mSlideAmount:I

    int-to-float v8, v8

    mul-float/2addr v8, v11

    div-float v7, v1, v8

    .local v7, rx:F
    iget v8, p0, Landroid/widget/StackView;->mSwipeGestureType:I

    const/4 v10, 0x2

    if-ne v8, v10, :cond_70

    iget v8, p0, Landroid/widget/StackView;->mTouchSlop:I

    int-to-float v8, v8

    mul-float/2addr v8, v11

    sub-float v8, v2, v8

    iget v10, p0, Landroid/widget/StackView;->mSlideAmount:I

    int-to-float v10, v10

    div-float/2addr v8, v10

    mul-float v6, v8, v11

    .local v6, r:F
    iget v8, p0, Landroid/widget/StackView;->mStackMode:I

    if-ne v8, v9, :cond_62

    sub-float v6, v11, v6

    :cond_62
    iget-object v8, p0, Landroid/widget/StackView;->mStackSlider:Landroid/widget/StackView$StackSlider;

    sub-float v10, v11, v6

    invoke-virtual {v8, v10}, Landroid/widget/StackView$StackSlider;->setYProgress(F)V

    iget-object v8, p0, Landroid/widget/StackView;->mStackSlider:Landroid/widget/StackView$StackSlider;

    invoke-virtual {v8, v7}, Landroid/widget/StackView$StackSlider;->setXProgress(F)V

    move v8, v9

    goto :goto_1b

    .end local v6           #r:F
    :cond_70
    iget v8, p0, Landroid/widget/StackView;->mSwipeGestureType:I

    if-ne v8, v9, :cond_40

    iget v8, p0, Landroid/widget/StackView;->mTouchSlop:I

    int-to-float v8, v8

    mul-float/2addr v8, v11

    add-float/2addr v8, v2

    neg-float v8, v8

    iget v10, p0, Landroid/widget/StackView;->mSlideAmount:I

    int-to-float v10, v10

    div-float/2addr v8, v10

    mul-float v6, v8, v11

    .restart local v6       #r:F
    iget v8, p0, Landroid/widget/StackView;->mStackMode:I

    if-ne v8, v9, :cond_86

    sub-float v6, v11, v6

    :cond_86
    iget-object v8, p0, Landroid/widget/StackView;->mStackSlider:Landroid/widget/StackView$StackSlider;

    invoke-virtual {v8, v6}, Landroid/widget/StackView$StackSlider;->setYProgress(F)V

    iget-object v8, p0, Landroid/widget/StackView;->mStackSlider:Landroid/widget/StackView$StackSlider;

    invoke-virtual {v8, v7}, Landroid/widget/StackView$StackSlider;->setXProgress(F)V

    move v8, v9

    goto :goto_1b

    .end local v6           #r:F
    .end local v7           #rx:F
    :pswitch_92
    invoke-direct {p0, p1}, Landroid/widget/StackView;->handlePointerUp(Landroid/view/MotionEvent;)V

    goto :goto_40

    :pswitch_96
    invoke-direct {p0, p1}, Landroid/widget/StackView;->onSecondaryPointerUp(Landroid/view/MotionEvent;)V

    goto :goto_40

    :pswitch_9a
    iput v12, p0, Landroid/widget/StackView;->mActivePointerId:I

    iput v8, p0, Landroid/widget/StackView;->mSwipeGestureType:I

    goto :goto_40

    nop

    :pswitch_data_a0
    .packed-switch 0x1
        :pswitch_92
        :pswitch_42
        :pswitch_9a
        :pswitch_40
        :pswitch_40
        :pswitch_96
    .end packed-switch
.end method

.method public performAccessibilityAction(ILandroid/os/Bundle;)Z
    .registers 7
    .parameter "action"
    .parameter "arguments"

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    invoke-super {p0, p1, p2}, Landroid/widget/AdapterViewAnimator;->performAccessibilityAction(ILandroid/os/Bundle;)Z

    move-result v2

    if-eqz v2, :cond_9

    :goto_8
    return v0

    :cond_9
    invoke-virtual {p0}, Landroid/widget/StackView;->isEnabled()Z

    move-result v2

    if-nez v2, :cond_11

    move v0, v1

    goto :goto_8

    :cond_11
    sparse-switch p1, :sswitch_data_34

    move v0, v1

    goto :goto_8

    :sswitch_16
    invoke-virtual {p0}, Landroid/widget/StackView;->getDisplayedChild()I

    move-result v2

    invoke-virtual {p0}, Landroid/widget/StackView;->getChildCount()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    if-ge v2, v3, :cond_26

    invoke-virtual {p0}, Landroid/widget/StackView;->showNext()V

    goto :goto_8

    :cond_26
    move v0, v1

    goto :goto_8

    :sswitch_28
    invoke-virtual {p0}, Landroid/widget/StackView;->getDisplayedChild()I

    move-result v2

    if-lez v2, :cond_32

    invoke-virtual {p0}, Landroid/widget/StackView;->showPrevious()V

    goto :goto_8

    :cond_32
    move v0, v1

    goto :goto_8

    :sswitch_data_34
    .sparse-switch
        0x1000 -> :sswitch_16
        0x2000 -> :sswitch_28
    .end sparse-switch
.end method

.method public showNext()V
    .registers 4
    .annotation runtime Landroid/view/RemotableViewMethod;
    .end annotation

    .prologue
    const/4 v2, 0x0

    iget v1, p0, Landroid/widget/StackView;->mSwipeGestureType:I

    if-eqz v1, :cond_6

    :goto_5
    return-void

    :cond_6
    iget-boolean v1, p0, Landroid/widget/StackView;->mTransitionIsSetup:Z

    if-nez v1, :cond_1f

    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Landroid/widget/StackView;->getViewAtRelativeIndex(I)Landroid/view/View;

    move-result-object v0

    .local v0, v:Landroid/view/View;
    if-eqz v0, :cond_1f

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Landroid/widget/StackView;->setupStackSlider(Landroid/view/View;I)V

    iget-object v1, p0, Landroid/widget/StackView;->mStackSlider:Landroid/widget/StackView$StackSlider;

    invoke-virtual {v1, v2}, Landroid/widget/StackView$StackSlider;->setYProgress(F)V

    iget-object v1, p0, Landroid/widget/StackView;->mStackSlider:Landroid/widget/StackView$StackSlider;

    invoke-virtual {v1, v2}, Landroid/widget/StackView$StackSlider;->setXProgress(F)V

    .end local v0           #v:Landroid/view/View;
    :cond_1f
    invoke-super {p0}, Landroid/widget/AdapterViewAnimator;->showNext()V

    goto :goto_5
.end method

.method showOnly(IZ)V
    .registers 10
    .parameter "childIndex"
    .parameter "animate"

    .prologue
    const/4 v6, 0x0

    invoke-super {p0, p1, p2}, Landroid/widget/AdapterViewAnimator;->showOnly(IZ)V

    iget v0, p0, Landroid/widget/AdapterViewAnimator;->mCurrentWindowEnd:I

    .local v0, i:I
    :goto_6
    iget v4, p0, Landroid/widget/AdapterViewAnimator;->mCurrentWindowStart:I

    if-lt v0, v4, :cond_36

    invoke-virtual {p0}, Landroid/widget/StackView;->getWindowSize()I

    move-result v4

    invoke-virtual {p0, v0, v4}, Landroid/widget/StackView;->modulo(II)I

    move-result v1

    .local v1, index:I
    iget-object v4, p0, Landroid/widget/AdapterViewAnimator;->mViewsMap:Ljava/util/HashMap;

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/widget/AdapterViewAnimator$ViewAndMetaData;

    .local v3, vm:Landroid/widget/AdapterViewAnimator$ViewAndMetaData;
    if-eqz v3, :cond_33

    iget-object v4, p0, Landroid/widget/AdapterViewAnimator;->mViewsMap:Ljava/util/HashMap;

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/widget/AdapterViewAnimator$ViewAndMetaData;

    iget-object v2, v4, Landroid/widget/AdapterViewAnimator$ViewAndMetaData;->view:Landroid/view/View;

    .local v2, v:Landroid/view/View;
    if-eqz v2, :cond_33

    invoke-virtual {v2}, Landroid/view/View;->bringToFront()V

    .end local v2           #v:Landroid/view/View;
    :cond_33
    add-int/lit8 v0, v0, -0x1

    goto :goto_6

    .end local v1           #index:I
    .end local v3           #vm:Landroid/widget/AdapterViewAnimator$ViewAndMetaData;
    :cond_36
    iget-object v4, p0, Landroid/widget/StackView;->mHighlight:Landroid/widget/ImageView;

    if-eqz v4, :cond_3f

    iget-object v4, p0, Landroid/widget/StackView;->mHighlight:Landroid/widget/ImageView;

    invoke-virtual {v4}, Landroid/widget/ImageView;->bringToFront()V

    :cond_3f
    iput-boolean v6, p0, Landroid/widget/StackView;->mTransitionIsSetup:Z

    iput-boolean v6, p0, Landroid/widget/StackView;->mClickFeedbackIsValid:Z

    return-void
.end method

.method public showPrevious()V
    .registers 4
    .annotation runtime Landroid/view/RemotableViewMethod;
    .end annotation

    .prologue
    const/4 v2, 0x0

    iget v1, p0, Landroid/widget/StackView;->mSwipeGestureType:I

    if-eqz v1, :cond_6

    :goto_5
    return-void

    :cond_6
    iget-boolean v1, p0, Landroid/widget/StackView;->mTransitionIsSetup:Z

    if-nez v1, :cond_20

    invoke-virtual {p0, v2}, Landroid/widget/StackView;->getViewAtRelativeIndex(I)Landroid/view/View;

    move-result-object v0

    .local v0, v:Landroid/view/View;
    if-eqz v0, :cond_20

    invoke-direct {p0, v0, v2}, Landroid/widget/StackView;->setupStackSlider(Landroid/view/View;I)V

    iget-object v1, p0, Landroid/widget/StackView;->mStackSlider:Landroid/widget/StackView$StackSlider;

    const/high16 v2, 0x3f80

    invoke-virtual {v1, v2}, Landroid/widget/StackView$StackSlider;->setYProgress(F)V

    iget-object v1, p0, Landroid/widget/StackView;->mStackSlider:Landroid/widget/StackView$StackSlider;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/StackView$StackSlider;->setXProgress(F)V

    .end local v0           #v:Landroid/view/View;
    :cond_20
    invoke-super {p0}, Landroid/widget/AdapterViewAnimator;->showPrevious()V

    goto :goto_5
.end method

.method showTapFeedback(Landroid/view/View;)V
    .registers 4
    .parameter "v"

    .prologue
    invoke-virtual {p0}, Landroid/widget/StackView;->updateClickFeedback()V

    iget-object v0, p0, Landroid/widget/StackView;->mClickFeedback:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    iget-object v0, p0, Landroid/widget/StackView;->mClickFeedback:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->bringToFront()V

    invoke-virtual {p0}, Landroid/widget/StackView;->invalidate()V

    return-void
.end method

.method transformViewForTransition(IILandroid/view/View;Z)V
    .registers 22
    .parameter "fromIndex"
    .parameter "toIndex"
    .parameter "view"
    .parameter "animate"

    .prologue
    if-nez p4, :cond_1d

    move-object/from16 v13, p3

    check-cast v13, Landroid/widget/StackView$StackFrame;

    invoke-virtual {v13}, Landroid/widget/StackView$StackFrame;->cancelSliderAnimator()Z

    const/4 v13, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v13}, Landroid/view/View;->setRotationX(F)V

    invoke-virtual/range {p3 .. p3}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v6

    check-cast v6, Landroid/widget/StackView$LayoutParams;

    .local v6, lp:Landroid/widget/StackView$LayoutParams;
    const/4 v13, 0x0

    invoke-virtual {v6, v13}, Landroid/widget/StackView$LayoutParams;->setVerticalOffset(I)V

    const/4 v13, 0x0

    invoke-virtual {v6, v13}, Landroid/widget/StackView$LayoutParams;->setHorizontalOffset(I)V

    .end local v6           #lp:Landroid/widget/StackView$LayoutParams;
    :cond_1d
    const/4 v13, -0x1

    move/from16 v0, p1

    if-ne v0, v13, :cond_54

    invoke-virtual/range {p0 .. p0}, Landroid/widget/StackView;->getNumActiveViews()I

    move-result v13

    add-int/lit8 v13, v13, -0x1

    move/from16 v0, p2

    if-ne v0, v13, :cond_54

    const/4 v13, 0x0

    move-object/from16 v0, p0

    move/from16 v1, p2

    move-object/from16 v2, p3

    invoke-direct {v0, v1, v2, v13}, Landroid/widget/StackView;->transformViewAtIndex(ILandroid/view/View;Z)V

    const/4 v13, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v13}, Landroid/view/View;->setVisibility(I)V

    const/high16 v13, 0x3f80

    move-object/from16 v0, p3

    invoke-virtual {v0, v13}, Landroid/view/View;->setAlpha(F)V

    :cond_43
    :goto_43
    const/4 v13, -0x1

    move/from16 v0, p2

    if-eq v0, v13, :cond_53

    move-object/from16 v0, p0

    move/from16 v1, p2

    move-object/from16 v2, p3

    move/from16 v3, p4

    invoke-direct {v0, v1, v2, v3}, Landroid/widget/StackView;->transformViewAtIndex(ILandroid/view/View;Z)V

    :cond_53
    return-void

    :cond_54
    if-nez p1, :cond_d6

    const/4 v13, 0x1

    move/from16 v0, p2

    if-ne v0, v13, :cond_d6

    move-object/from16 v13, p3

    check-cast v13, Landroid/widget/StackView$StackFrame;

    invoke-virtual {v13}, Landroid/widget/StackView$StackFrame;->cancelSliderAnimator()Z

    const/4 v13, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v13}, Landroid/view/View;->setVisibility(I)V

    move-object/from16 v0, p0

    iget-object v13, v0, Landroid/widget/StackView;->mStackSlider:Landroid/widget/StackView$StackSlider;

    move-object/from16 v0, p0

    iget v14, v0, Landroid/widget/StackView;->mYVelocity:I

    int-to-float v14, v14

    invoke-virtual {v13, v14}, Landroid/widget/StackView$StackSlider;->getDurationForNeutralPosition(F)F

    move-result v13

    invoke-static {v13}, Ljava/lang/Math;->round(F)I

    move-result v5

    .local v5, duration:I
    new-instance v4, Landroid/widget/StackView$StackSlider;

    move-object/from16 v0, p0

    iget-object v13, v0, Landroid/widget/StackView;->mStackSlider:Landroid/widget/StackView$StackSlider;

    move-object/from16 v0, p0

    invoke-direct {v4, v0, v13}, Landroid/widget/StackView$StackSlider;-><init>(Landroid/widget/StackView;Landroid/widget/StackView$StackSlider;)V

    .local v4, animationSlider:Landroid/widget/StackView$StackSlider;
    move-object/from16 v0, p3

    invoke-virtual {v4, v0}, Landroid/widget/StackView$StackSlider;->setView(Landroid/view/View;)V

    if-eqz p4, :cond_cc

    const-string v13, "YProgress"

    const/4 v14, 0x1

    new-array v14, v14, [F

    const/4 v15, 0x0

    const/16 v16, 0x0

    aput v16, v14, v15

    invoke-static {v13, v14}, Landroid/animation/PropertyValuesHolder;->ofFloat(Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;

    move-result-object v9

    .local v9, slideInY:Landroid/animation/PropertyValuesHolder;
    const-string v13, "XProgress"

    const/4 v14, 0x1

    new-array v14, v14, [F

    const/4 v15, 0x0

    const/16 v16, 0x0

    aput v16, v14, v15

    invoke-static {v13, v14}, Landroid/animation/PropertyValuesHolder;->ofFloat(Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;

    move-result-object v8

    .local v8, slideInX:Landroid/animation/PropertyValuesHolder;
    const/4 v13, 0x2

    new-array v13, v13, [Landroid/animation/PropertyValuesHolder;

    const/4 v14, 0x0

    aput-object v8, v13, v14

    const/4 v14, 0x1

    aput-object v9, v13, v14

    invoke-static {v4, v13}, Landroid/animation/ObjectAnimator;->ofPropertyValuesHolder(Ljava/lang/Object;[Landroid/animation/PropertyValuesHolder;)Landroid/animation/ObjectAnimator;

    move-result-object v7

    .local v7, slideIn:Landroid/animation/ObjectAnimator;
    int-to-long v13, v5

    invoke-virtual {v7, v13, v14}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    new-instance v13, Landroid/view/animation/LinearInterpolator;

    invoke-direct {v13}, Landroid/view/animation/LinearInterpolator;-><init>()V

    invoke-virtual {v7, v13}, Landroid/animation/ObjectAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    move-object/from16 v13, p3

    check-cast v13, Landroid/widget/StackView$StackFrame;

    invoke-virtual {v13, v7}, Landroid/widget/StackView$StackFrame;->setSliderAnimator(Landroid/animation/ObjectAnimator;)V

    invoke-virtual {v7}, Landroid/animation/ObjectAnimator;->start()V

    goto/16 :goto_43

    .end local v7           #slideIn:Landroid/animation/ObjectAnimator;
    .end local v8           #slideInX:Landroid/animation/PropertyValuesHolder;
    .end local v9           #slideInY:Landroid/animation/PropertyValuesHolder;
    :cond_cc
    const/4 v13, 0x0

    invoke-virtual {v4, v13}, Landroid/widget/StackView$StackSlider;->setYProgress(F)V

    const/4 v13, 0x0

    invoke-virtual {v4, v13}, Landroid/widget/StackView$StackSlider;->setXProgress(F)V

    goto/16 :goto_43

    .end local v4           #animationSlider:Landroid/widget/StackView$StackSlider;
    .end local v5           #duration:I
    :cond_d6
    const/4 v13, 0x1

    move/from16 v0, p1

    if-ne v0, v13, :cond_153

    if-nez p2, :cond_153

    move-object/from16 v13, p3

    check-cast v13, Landroid/widget/StackView$StackFrame;

    invoke-virtual {v13}, Landroid/widget/StackView$StackFrame;->cancelSliderAnimator()Z

    move-object/from16 v0, p0

    iget-object v13, v0, Landroid/widget/StackView;->mStackSlider:Landroid/widget/StackView$StackSlider;

    move-object/from16 v0, p0

    iget v14, v0, Landroid/widget/StackView;->mYVelocity:I

    int-to-float v14, v14

    invoke-virtual {v13, v14}, Landroid/widget/StackView$StackSlider;->getDurationForOffscreenPosition(F)F

    move-result v13

    invoke-static {v13}, Ljava/lang/Math;->round(F)I

    move-result v5

    .restart local v5       #duration:I
    new-instance v4, Landroid/widget/StackView$StackSlider;

    move-object/from16 v0, p0

    iget-object v13, v0, Landroid/widget/StackView;->mStackSlider:Landroid/widget/StackView$StackSlider;

    move-object/from16 v0, p0

    invoke-direct {v4, v0, v13}, Landroid/widget/StackView$StackSlider;-><init>(Landroid/widget/StackView;Landroid/widget/StackView$StackSlider;)V

    .restart local v4       #animationSlider:Landroid/widget/StackView$StackSlider;
    move-object/from16 v0, p3

    invoke-virtual {v4, v0}, Landroid/widget/StackView$StackSlider;->setView(Landroid/view/View;)V

    if-eqz p4, :cond_148

    const-string v13, "YProgress"

    const/4 v14, 0x1

    new-array v14, v14, [F

    const/4 v15, 0x0

    const/high16 v16, 0x3f80

    aput v16, v14, v15

    invoke-static {v13, v14}, Landroid/animation/PropertyValuesHolder;->ofFloat(Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;

    move-result-object v12

    .local v12, slideOutY:Landroid/animation/PropertyValuesHolder;
    const-string v13, "XProgress"

    const/4 v14, 0x1

    new-array v14, v14, [F

    const/4 v15, 0x0

    const/16 v16, 0x0

    aput v16, v14, v15

    invoke-static {v13, v14}, Landroid/animation/PropertyValuesHolder;->ofFloat(Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;

    move-result-object v11

    .local v11, slideOutX:Landroid/animation/PropertyValuesHolder;
    const/4 v13, 0x2

    new-array v13, v13, [Landroid/animation/PropertyValuesHolder;

    const/4 v14, 0x0

    aput-object v11, v13, v14

    const/4 v14, 0x1

    aput-object v12, v13, v14

    invoke-static {v4, v13}, Landroid/animation/ObjectAnimator;->ofPropertyValuesHolder(Ljava/lang/Object;[Landroid/animation/PropertyValuesHolder;)Landroid/animation/ObjectAnimator;

    move-result-object v10

    .local v10, slideOut:Landroid/animation/ObjectAnimator;
    int-to-long v13, v5

    invoke-virtual {v10, v13, v14}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    new-instance v13, Landroid/view/animation/LinearInterpolator;

    invoke-direct {v13}, Landroid/view/animation/LinearInterpolator;-><init>()V

    invoke-virtual {v10, v13}, Landroid/animation/ObjectAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    move-object/from16 v13, p3

    check-cast v13, Landroid/widget/StackView$StackFrame;

    invoke-virtual {v13, v10}, Landroid/widget/StackView$StackFrame;->setSliderAnimator(Landroid/animation/ObjectAnimator;)V

    invoke-virtual {v10}, Landroid/animation/ObjectAnimator;->start()V

    goto/16 :goto_43

    .end local v10           #slideOut:Landroid/animation/ObjectAnimator;
    .end local v11           #slideOutX:Landroid/animation/PropertyValuesHolder;
    .end local v12           #slideOutY:Landroid/animation/PropertyValuesHolder;
    :cond_148
    const/high16 v13, 0x3f80

    invoke-virtual {v4, v13}, Landroid/widget/StackView$StackSlider;->setYProgress(F)V

    const/4 v13, 0x0

    invoke-virtual {v4, v13}, Landroid/widget/StackView$StackSlider;->setXProgress(F)V

    goto/16 :goto_43

    .end local v4           #animationSlider:Landroid/widget/StackView$StackSlider;
    .end local v5           #duration:I
    :cond_153
    if-nez p2, :cond_163

    const/4 v13, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v13}, Landroid/view/View;->setAlpha(F)V

    const/4 v13, 0x4

    move-object/from16 v0, p3

    invoke-virtual {v0, v13}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_43

    :cond_163
    if-eqz p1, :cond_16a

    const/4 v13, 0x1

    move/from16 v0, p1

    if-ne v0, v13, :cond_192

    :cond_16a
    const/4 v13, 0x1

    move/from16 v0, p2

    if-le v0, v13, :cond_192

    const/4 v13, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v13}, Landroid/view/View;->setVisibility(I)V

    const/high16 v13, 0x3f80

    move-object/from16 v0, p3

    invoke-virtual {v0, v13}, Landroid/view/View;->setAlpha(F)V

    const/4 v13, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v13}, Landroid/view/View;->setRotationX(F)V

    invoke-virtual/range {p3 .. p3}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v6

    check-cast v6, Landroid/widget/StackView$LayoutParams;

    .restart local v6       #lp:Landroid/widget/StackView$LayoutParams;
    const/4 v13, 0x0

    invoke-virtual {v6, v13}, Landroid/widget/StackView$LayoutParams;->setVerticalOffset(I)V

    const/4 v13, 0x0

    invoke-virtual {v6, v13}, Landroid/widget/StackView$LayoutParams;->setHorizontalOffset(I)V

    goto/16 :goto_43

    .end local v6           #lp:Landroid/widget/StackView$LayoutParams;
    :cond_192
    const/4 v13, -0x1

    move/from16 v0, p1

    if-ne v0, v13, :cond_1a6

    const/high16 v13, 0x3f80

    move-object/from16 v0, p3

    invoke-virtual {v0, v13}, Landroid/view/View;->setAlpha(F)V

    const/4 v13, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v13}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_43

    :cond_1a6
    const/4 v13, -0x1

    move/from16 v0, p2

    if-ne v0, v13, :cond_43

    if-eqz p4, :cond_1bf

    new-instance v13, Landroid/widget/StackView$1;

    move-object/from16 v0, p0

    move-object/from16 v1, p3

    invoke-direct {v13, v0, v1}, Landroid/widget/StackView$1;-><init>(Landroid/widget/StackView;Landroid/view/View;)V

    const-wide/16 v14, 0x64

    move-object/from16 v0, p0

    invoke-virtual {v0, v13, v14, v15}, Landroid/widget/StackView;->postDelayed(Ljava/lang/Runnable;J)Z

    goto/16 :goto_43

    :cond_1bf
    const/4 v13, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v13}, Landroid/view/View;->setAlpha(F)V

    goto/16 :goto_43
.end method

.method updateClickFeedback()V
    .registers 6

    .prologue
    const/4 v4, 0x1

    iget-boolean v1, p0, Landroid/widget/StackView;->mClickFeedbackIsValid:Z

    if-nez v1, :cond_2c

    invoke-virtual {p0, v4}, Landroid/widget/StackView;->getViewAtRelativeIndex(I)Landroid/view/View;

    move-result-object v0

    .local v0, v:Landroid/view/View;
    if-eqz v0, :cond_2a

    iget-object v1, p0, Landroid/widget/StackView;->mClickFeedback:Landroid/widget/ImageView;

    sget-object v2, Landroid/widget/StackView;->sHolographicHelper:Landroid/widget/StackView$HolographicHelper;

    iget v3, p0, Landroid/widget/StackView;->mClickColor:I

    invoke-virtual {v2, v0, v3}, Landroid/widget/StackView$HolographicHelper;->createClickOutline(Landroid/view/View;I)Landroid/graphics/Bitmap;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    iget-object v1, p0, Landroid/widget/StackView;->mClickFeedback:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/view/View;->getTranslationX()F

    move-result v2

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setTranslationX(F)V

    iget-object v1, p0, Landroid/widget/StackView;->mClickFeedback:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/view/View;->getTranslationY()F

    move-result v2

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setTranslationY(F)V

    :cond_2a
    iput-boolean v4, p0, Landroid/widget/StackView;->mClickFeedbackIsValid:Z

    .end local v0           #v:Landroid/view/View;
    :cond_2c
    return-void
.end method
