.class public Lcom/android/internal/widget/RotarySelector;
.super Landroid/view/View;
.source "RotarySelector.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/internal/widget/RotarySelector$OnDialTriggerListener;
    }
.end annotation


# static fields
.field private static final ARROW_SCRUNCH_DIP:I = 0x6

.field private static final DBG:Z = false

.field private static final EDGE_PADDING_DIP:I = 0x9

.field private static final EDGE_TRIGGER_DIP:I = 0x64

.field public static final HORIZONTAL:I = 0x0

.field public static final LEFT_HANDLE_GRABBED:I = 0x1

.field private static final LOG_TAG:Ljava/lang/String; = "RotarySelector"

.field public static final NOTHING_GRABBED:I = 0x0

.field static final OUTER_ROTARY_RADIUS_DIP:I = 0x186

.field public static final RIGHT_HANDLE_GRABBED:I = 0x2

.field static final ROTARY_STROKE_WIDTH_DIP:I = 0x53

.field static final SNAP_BACK_ANIMATION_DURATION_MILLIS:I = 0x12c

.field static final SPIN_ANIMATION_DURATION_MILLIS:I = 0x320

.field public static final VERTICAL:I = 0x1

.field private static final VIBRATE_LONG:J = 0x14L

.field private static final VIBRATE_SHORT:J = 0x14L

.field private static final VISUAL_DEBUG:Z


# instance fields
.field private mAnimating:Z

.field private mAnimatingDeltaXEnd:I

.field private mAnimatingDeltaXStart:I

.field private mAnimationDuration:J

.field private mAnimationStartTime:J

.field private mArrowLongLeft:Landroid/graphics/Bitmap;

.field private mArrowLongRight:Landroid/graphics/Bitmap;

.field final mArrowMatrix:Landroid/graphics/Matrix;

.field private mArrowShortLeftAndRight:Landroid/graphics/Bitmap;

.field private mBackground:Landroid/graphics/Bitmap;

.field private mBackgroundHeight:I

.field private mBackgroundWidth:I

.field final mBgMatrix:Landroid/graphics/Matrix;

.field private mDensity:F

.field private mDimple:Landroid/graphics/Bitmap;

.field private mDimpleDim:Landroid/graphics/Bitmap;

.field private mDimpleSpacing:I

.field private mDimpleWidth:I

.field private mDimplesOfFling:I

.field private mEdgeTriggerThresh:I

.field private mGrabbedState:I

.field private final mInnerRadius:I

.field private mInterpolator:Landroid/view/animation/DecelerateInterpolator;

.field private mLeftHandleIcon:Landroid/graphics/Bitmap;

.field private mLeftHandleX:I

.field private mMaximumVelocity:I

.field private mMinimumVelocity:I

.field private mOnDialTriggerListener:Lcom/android/internal/widget/RotarySelector$OnDialTriggerListener;

.field private mOrientation:I

.field private final mOuterRadius:I

.field private mPaint:Landroid/graphics/Paint;

.field private mRightHandleIcon:Landroid/graphics/Bitmap;

.field private mRightHandleX:I

.field private mRotaryOffsetX:I

.field private mTriggered:Z

.field private mVelocityTracker:Landroid/view/VelocityTracker;

.field private mVibrator:Landroid/os/Vibrator;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 3
    .parameter "context"

    .prologue
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/android/internal/widget/RotarySelector;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 8
    .parameter "context"
    .parameter "attrs"

    .prologue
    const/4 v4, 0x0

    invoke-direct {p0, p1, p2}, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    iput v4, p0, Lcom/android/internal/widget/RotarySelector;->mRotaryOffsetX:I

    iput-boolean v4, p0, Lcom/android/internal/widget/RotarySelector;->mAnimating:Z

    new-instance v3, Landroid/graphics/Paint;

    invoke-direct {v3}, Landroid/graphics/Paint;-><init>()V

    iput-object v3, p0, Lcom/android/internal/widget/RotarySelector;->mPaint:Landroid/graphics/Paint;

    new-instance v3, Landroid/graphics/Matrix;

    invoke-direct {v3}, Landroid/graphics/Matrix;-><init>()V

    iput-object v3, p0, Lcom/android/internal/widget/RotarySelector;->mBgMatrix:Landroid/graphics/Matrix;

    new-instance v3, Landroid/graphics/Matrix;

    invoke-direct {v3}, Landroid/graphics/Matrix;-><init>()V

    iput-object v3, p0, Lcom/android/internal/widget/RotarySelector;->mArrowMatrix:Landroid/graphics/Matrix;

    iput v4, p0, Lcom/android/internal/widget/RotarySelector;->mGrabbedState:I

    iput-boolean v4, p0, Lcom/android/internal/widget/RotarySelector;->mTriggered:Z

    iput v4, p0, Lcom/android/internal/widget/RotarySelector;->mDimplesOfFling:I

    sget-object v3, Lcom/android/internal/R$styleable;->RotarySelector:[I

    invoke-virtual {p1, p2, v3}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .local v0, a:Landroid/content/res/TypedArray;
    invoke-virtual {v0, v4, v4}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v3

    iput v3, p0, Lcom/android/internal/widget/RotarySelector;->mOrientation:I

    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    invoke-virtual {p0}, Lcom/android/internal/widget/RotarySelector;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .local v2, r:Landroid/content/res/Resources;
    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v3

    iget v3, v3, Landroid/util/DisplayMetrics;->density:F

    iput v3, p0, Lcom/android/internal/widget/RotarySelector;->mDensity:F

    const v3, 0x1080382

    invoke-direct {p0, v3}, Lcom/android/internal/widget/RotarySelector;->getBitmapFor(I)Landroid/graphics/Bitmap;

    move-result-object v3

    iput-object v3, p0, Lcom/android/internal/widget/RotarySelector;->mBackground:Landroid/graphics/Bitmap;

    const v3, 0x1080383

    invoke-direct {p0, v3}, Lcom/android/internal/widget/RotarySelector;->getBitmapFor(I)Landroid/graphics/Bitmap;

    move-result-object v3

    iput-object v3, p0, Lcom/android/internal/widget/RotarySelector;->mDimple:Landroid/graphics/Bitmap;

    const v3, 0x1080384

    invoke-direct {p0, v3}, Lcom/android/internal/widget/RotarySelector;->getBitmapFor(I)Landroid/graphics/Bitmap;

    move-result-object v3

    iput-object v3, p0, Lcom/android/internal/widget/RotarySelector;->mDimpleDim:Landroid/graphics/Bitmap;

    const v3, 0x108037a

    invoke-direct {p0, v3}, Lcom/android/internal/widget/RotarySelector;->getBitmapFor(I)Landroid/graphics/Bitmap;

    move-result-object v3

    iput-object v3, p0, Lcom/android/internal/widget/RotarySelector;->mArrowLongLeft:Landroid/graphics/Bitmap;

    const v3, 0x108037d

    invoke-direct {p0, v3}, Lcom/android/internal/widget/RotarySelector;->getBitmapFor(I)Landroid/graphics/Bitmap;

    move-result-object v3

    iput-object v3, p0, Lcom/android/internal/widget/RotarySelector;->mArrowLongRight:Landroid/graphics/Bitmap;

    const v3, 0x1080380

    invoke-direct {p0, v3}, Lcom/android/internal/widget/RotarySelector;->getBitmapFor(I)Landroid/graphics/Bitmap;

    move-result-object v3

    iput-object v3, p0, Lcom/android/internal/widget/RotarySelector;->mArrowShortLeftAndRight:Landroid/graphics/Bitmap;

    new-instance v3, Landroid/view/animation/DecelerateInterpolator;

    const/high16 v4, 0x3f80

    invoke-direct {v3, v4}, Landroid/view/animation/DecelerateInterpolator;-><init>(F)V

    iput-object v3, p0, Lcom/android/internal/widget/RotarySelector;->mInterpolator:Landroid/view/animation/DecelerateInterpolator;

    iget v3, p0, Lcom/android/internal/widget/RotarySelector;->mDensity:F

    const/high16 v4, 0x42c8

    mul-float/2addr v3, v4

    float-to-int v3, v3

    iput v3, p0, Lcom/android/internal/widget/RotarySelector;->mEdgeTriggerThresh:I

    iget-object v3, p0, Lcom/android/internal/widget/RotarySelector;->mDimple:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    iput v3, p0, Lcom/android/internal/widget/RotarySelector;->mDimpleWidth:I

    iget-object v3, p0, Lcom/android/internal/widget/RotarySelector;->mBackground:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    iput v3, p0, Lcom/android/internal/widget/RotarySelector;->mBackgroundWidth:I

    iget-object v3, p0, Lcom/android/internal/widget/RotarySelector;->mBackground:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v3

    iput v3, p0, Lcom/android/internal/widget/RotarySelector;->mBackgroundHeight:I

    iget v3, p0, Lcom/android/internal/widget/RotarySelector;->mDensity:F

    const/high16 v4, 0x43c3

    mul-float/2addr v3, v4

    float-to-int v3, v3

    iput v3, p0, Lcom/android/internal/widget/RotarySelector;->mOuterRadius:I

    const v3, 0x43998000

    iget v4, p0, Lcom/android/internal/widget/RotarySelector;->mDensity:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    iput v3, p0, Lcom/android/internal/widget/RotarySelector;->mInnerRadius:I

    iget-object v3, p0, Landroid/view/View;->mContext:Landroid/content/Context;

    invoke-static {v3}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v1

    .local v1, configuration:Landroid/view/ViewConfiguration;
    invoke-virtual {v1}, Landroid/view/ViewConfiguration;->getScaledMinimumFlingVelocity()I

    move-result v3

    mul-int/lit8 v3, v3, 0x2

    iput v3, p0, Lcom/android/internal/widget/RotarySelector;->mMinimumVelocity:I

    invoke-virtual {v1}, Landroid/view/ViewConfiguration;->getScaledMaximumFlingVelocity()I

    move-result v3

    iput v3, p0, Lcom/android/internal/widget/RotarySelector;->mMaximumVelocity:I

    return-void
.end method

.method private dispatchTriggerEvent(I)V
    .registers 4
    .parameter "whichHandle"

    .prologue
    const-wide/16 v0, 0x14

    invoke-direct {p0, v0, v1}, Lcom/android/internal/widget/RotarySelector;->vibrate(J)V

    iget-object v0, p0, Lcom/android/internal/widget/RotarySelector;->mOnDialTriggerListener:Lcom/android/internal/widget/RotarySelector$OnDialTriggerListener;

    if-eqz v0, :cond_e

    iget-object v0, p0, Lcom/android/internal/widget/RotarySelector;->mOnDialTriggerListener:Lcom/android/internal/widget/RotarySelector$OnDialTriggerListener;

    invoke-interface {v0, p0, p1}, Lcom/android/internal/widget/RotarySelector$OnDialTriggerListener;->onDialTrigger(Landroid/view/View;I)V

    :cond_e
    return-void
.end method

.method private drawCentered(Landroid/graphics/Bitmap;Landroid/graphics/Canvas;II)V
    .registers 10
    .parameter "d"
    .parameter "c"
    .parameter "x"
    .parameter "y"

    .prologue
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v1

    .local v1, w:I
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v0

    .local v0, h:I
    div-int/lit8 v2, v1, 0x2

    sub-int v2, p3, v2

    int-to-float v2, v2

    div-int/lit8 v3, v0, 0x2

    sub-int v3, p4, v3

    int-to-float v3, v3

    iget-object v4, p0, Lcom/android/internal/widget/RotarySelector;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {p2, p1, v2, v3, v4}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    return-void
.end method

.method private getBitmapFor(I)Landroid/graphics/Bitmap;
    .registers 3
    .parameter "resId"

    .prologue
    invoke-virtual {p0}, Lcom/android/internal/widget/RotarySelector;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-static {v0, p1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method private getYOnArc(IIII)I
    .registers 11
    .parameter "backgroundWidth"
    .parameter "innerRadius"
    .parameter "outerRadius"
    .parameter "x"

    .prologue
    sub-int v4, p3, p2

    div-int/lit8 v0, v4, 0x2

    .local v0, halfWidth:I
    add-int v1, p2, v0

    .local v1, middleRadius:I
    div-int/lit8 v4, p1, 0x2

    sub-int v2, v4, p4

    .local v2, triangleBottom:I
    mul-int v4, v1, v1

    mul-int v5, v2, v2

    sub-int/2addr v4, v5

    int-to-double v4, v4

    invoke-static {v4, v5}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v4

    double-to-int v3, v4

    .local v3, triangleY:I
    sub-int v4, v1, v3

    add-int/2addr v4, v0

    return v4
.end method

.method private isHoriz()Z
    .registers 2

    .prologue
    iget v0, p0, Lcom/android/internal/widget/RotarySelector;->mOrientation:I

    if-nez v0, :cond_6

    const/4 v0, 0x1

    :goto_5
    return v0

    :cond_6
    const/4 v0, 0x0

    goto :goto_5
.end method

.method private log(Ljava/lang/String;)V
    .registers 3
    .parameter "msg"

    .prologue
    const-string v0, "RotarySelector"

    invoke-static {v0, p1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    return-void
.end method

.method private reset()V
    .registers 2

    .prologue
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/internal/widget/RotarySelector;->mAnimating:Z

    iput v0, p0, Lcom/android/internal/widget/RotarySelector;->mRotaryOffsetX:I

    iput v0, p0, Lcom/android/internal/widget/RotarySelector;->mDimplesOfFling:I

    invoke-direct {p0, v0}, Lcom/android/internal/widget/RotarySelector;->setGrabbedState(I)V

    iput-boolean v0, p0, Lcom/android/internal/widget/RotarySelector;->mTriggered:Z

    return-void
.end method

.method private setGrabbedState(I)V
    .registers 4
    .parameter "newState"

    .prologue
    iget v0, p0, Lcom/android/internal/widget/RotarySelector;->mGrabbedState:I

    if-eq p1, v0, :cond_11

    iput p1, p0, Lcom/android/internal/widget/RotarySelector;->mGrabbedState:I

    iget-object v0, p0, Lcom/android/internal/widget/RotarySelector;->mOnDialTriggerListener:Lcom/android/internal/widget/RotarySelector$OnDialTriggerListener;

    if-eqz v0, :cond_11

    iget-object v0, p0, Lcom/android/internal/widget/RotarySelector;->mOnDialTriggerListener:Lcom/android/internal/widget/RotarySelector$OnDialTriggerListener;

    iget v1, p0, Lcom/android/internal/widget/RotarySelector;->mGrabbedState:I

    invoke-interface {v0, p0, v1}, Lcom/android/internal/widget/RotarySelector$OnDialTriggerListener;->onGrabbedStateChange(Landroid/view/View;I)V

    :cond_11
    return-void
.end method

.method private startAnimation(III)V
    .registers 7
    .parameter "startX"
    .parameter "endX"
    .parameter "duration"

    .prologue
    const/4 v2, 0x0

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/internal/widget/RotarySelector;->mAnimating:Z

    invoke-static {}, Landroid/view/animation/AnimationUtils;->currentAnimationTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/android/internal/widget/RotarySelector;->mAnimationStartTime:J

    int-to-long v0, p3

    iput-wide v0, p0, Lcom/android/internal/widget/RotarySelector;->mAnimationDuration:J

    iput p1, p0, Lcom/android/internal/widget/RotarySelector;->mAnimatingDeltaXStart:I

    iput p2, p0, Lcom/android/internal/widget/RotarySelector;->mAnimatingDeltaXEnd:I

    invoke-direct {p0, v2}, Lcom/android/internal/widget/RotarySelector;->setGrabbedState(I)V

    iput v2, p0, Lcom/android/internal/widget/RotarySelector;->mDimplesOfFling:I

    invoke-virtual {p0}, Lcom/android/internal/widget/RotarySelector;->invalidate()V

    return-void
.end method

.method private startAnimationWithVelocity(III)V
    .registers 6
    .parameter "startX"
    .parameter "endX"
    .parameter "pixelsPerSecond"

    .prologue
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/internal/widget/RotarySelector;->mAnimating:Z

    invoke-static {}, Landroid/view/animation/AnimationUtils;->currentAnimationTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/android/internal/widget/RotarySelector;->mAnimationStartTime:J

    sub-int v0, p2, p1

    mul-int/lit16 v0, v0, 0x3e8

    div-int/2addr v0, p3

    int-to-long v0, v0

    iput-wide v0, p0, Lcom/android/internal/widget/RotarySelector;->mAnimationDuration:J

    iput p1, p0, Lcom/android/internal/widget/RotarySelector;->mAnimatingDeltaXStart:I

    iput p2, p0, Lcom/android/internal/widget/RotarySelector;->mAnimatingDeltaXEnd:I

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/android/internal/widget/RotarySelector;->setGrabbedState(I)V

    invoke-virtual {p0}, Lcom/android/internal/widget/RotarySelector;->invalidate()V

    return-void
.end method

.method private updateAnimation()V
    .registers 13

    .prologue
    invoke-static {}, Landroid/view/animation/AnimationUtils;->currentAnimationTimeMillis()J

    move-result-wide v8

    iget-wide v10, p0, Lcom/android/internal/widget/RotarySelector;->mAnimationStartTime:J

    sub-long v5, v8, v10

    .local v5, millisSoFar:J
    iget-wide v8, p0, Lcom/android/internal/widget/RotarySelector;->mAnimationDuration:J

    sub-long v3, v8, v5

    .local v3, millisLeft:J
    iget v8, p0, Lcom/android/internal/widget/RotarySelector;->mAnimatingDeltaXStart:I

    iget v9, p0, Lcom/android/internal/widget/RotarySelector;->mAnimatingDeltaXEnd:I

    sub-int v7, v8, v9

    .local v7, totalDeltaX:I
    if-gez v7, :cond_1f

    const/4 v1, 0x1

    .local v1, goingRight:Z
    :goto_15
    const-wide/16 v8, 0x0

    cmp-long v8, v3, v8

    if-gtz v8, :cond_21

    invoke-direct {p0}, Lcom/android/internal/widget/RotarySelector;->reset()V

    :goto_1e
    return-void

    .end local v1           #goingRight:Z
    :cond_1f
    const/4 v1, 0x0

    goto :goto_15

    .restart local v1       #goingRight:Z
    :cond_21
    iget-object v8, p0, Lcom/android/internal/widget/RotarySelector;->mInterpolator:Landroid/view/animation/DecelerateInterpolator;

    long-to-float v9, v5

    iget-wide v10, p0, Lcom/android/internal/widget/RotarySelector;->mAnimationDuration:J

    long-to-float v10, v10

    div-float/2addr v9, v10

    invoke-virtual {v8, v9}, Landroid/view/animation/DecelerateInterpolator;->getInterpolation(F)F

    move-result v2

    .local v2, interpolation:F
    int-to-float v8, v7

    const/high16 v9, 0x3f80

    sub-float/2addr v9, v2

    mul-float/2addr v8, v9

    float-to-int v0, v8

    .local v0, dx:I
    iget v8, p0, Lcom/android/internal/widget/RotarySelector;->mAnimatingDeltaXEnd:I

    add-int/2addr v8, v0

    iput v8, p0, Lcom/android/internal/widget/RotarySelector;->mRotaryOffsetX:I

    iget v8, p0, Lcom/android/internal/widget/RotarySelector;->mDimplesOfFling:I

    if-lez v8, :cond_4f

    if-nez v1, :cond_53

    iget v8, p0, Lcom/android/internal/widget/RotarySelector;->mRotaryOffsetX:I

    iget v9, p0, Lcom/android/internal/widget/RotarySelector;->mDimpleSpacing:I

    mul-int/lit8 v9, v9, -0x3

    if-ge v8, v9, :cond_53

    iget v8, p0, Lcom/android/internal/widget/RotarySelector;->mRotaryOffsetX:I

    iget v9, p0, Lcom/android/internal/widget/RotarySelector;->mDimplesOfFling:I

    iget v10, p0, Lcom/android/internal/widget/RotarySelector;->mDimpleSpacing:I

    mul-int/2addr v9, v10

    add-int/2addr v8, v9

    iput v8, p0, Lcom/android/internal/widget/RotarySelector;->mRotaryOffsetX:I

    :cond_4f
    :goto_4f
    invoke-virtual {p0}, Lcom/android/internal/widget/RotarySelector;->invalidate()V

    goto :goto_1e

    :cond_53
    if-eqz v1, :cond_4f

    iget v8, p0, Lcom/android/internal/widget/RotarySelector;->mRotaryOffsetX:I

    iget v9, p0, Lcom/android/internal/widget/RotarySelector;->mDimpleSpacing:I

    mul-int/lit8 v9, v9, 0x3

    if-le v8, v9, :cond_4f

    iget v8, p0, Lcom/android/internal/widget/RotarySelector;->mRotaryOffsetX:I

    iget v9, p0, Lcom/android/internal/widget/RotarySelector;->mDimplesOfFling:I

    iget v10, p0, Lcom/android/internal/widget/RotarySelector;->mDimpleSpacing:I

    mul-int/2addr v9, v10

    sub-int/2addr v8, v9

    iput v8, p0, Lcom/android/internal/widget/RotarySelector;->mRotaryOffsetX:I

    goto :goto_4f
.end method

.method private declared-synchronized vibrate(J)V
    .registers 5
    .parameter "duration"

    .prologue
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lcom/android/internal/widget/RotarySelector;->mVibrator:Landroid/os/Vibrator;

    if-nez v0, :cond_14

    invoke-virtual {p0}, Lcom/android/internal/widget/RotarySelector;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string/jumbo v1, "vibrator"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/Vibrator;

    iput-object v0, p0, Lcom/android/internal/widget/RotarySelector;->mVibrator:Landroid/os/Vibrator;

    :cond_14
    iget-object v0, p0, Lcom/android/internal/widget/RotarySelector;->mVibrator:Landroid/os/Vibrator;

    invoke-virtual {v0, p1, p2}, Landroid/os/Vibrator;->vibrate(J)V
    :try_end_19
    .catchall {:try_start_1 .. :try_end_19} :catchall_1b

    monitor-exit p0

    return-void

    :catchall_1b
    move-exception v0

    monitor-exit p0

    throw v0
.end method


# virtual methods
.method protected onDraw(Landroid/graphics/Canvas;)V
    .registers 23
    .parameter "canvas"

    .prologue
    invoke-super/range {p0 .. p1}, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V

    invoke-virtual/range {p0 .. p0}, Lcom/android/internal/widget/RotarySelector;->getWidth()I

    move-result v13

    .local v13, width:I
    invoke-virtual/range {p0 .. p0}, Lcom/android/internal/widget/RotarySelector;->getHeight()I

    move-result v11

    .local v11, height:I
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/android/internal/widget/RotarySelector;->mAnimating:Z

    move/from16 v17, v0

    if-eqz v17, :cond_16

    invoke-direct/range {p0 .. p0}, Lcom/android/internal/widget/RotarySelector;->updateAnimation()V

    :cond_16
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/RotarySelector;->mBackground:Landroid/graphics/Bitmap;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/RotarySelector;->mBgMatrix:Landroid/graphics/Matrix;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/RotarySelector;->mPaint:Landroid/graphics/Paint;

    move-object/from16 v19, v0

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    move-object/from16 v2, v18

    move-object/from16 v3, v19

    invoke-virtual {v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/RotarySelector;->mArrowMatrix:Landroid/graphics/Matrix;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Landroid/graphics/Matrix;->reset()V

    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mGrabbedState:I

    move/from16 v17, v0

    packed-switch v17, :pswitch_data_38c

    new-instance v17, Ljava/lang/IllegalStateException;

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, "invalid mGrabbedState: "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mGrabbedState:I

    move/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-direct/range {v17 .. v18}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v17

    :pswitch_64
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/RotarySelector;->mArrowMatrix:Landroid/graphics/Matrix;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    const/16 v19, 0x0

    invoke-virtual/range {v17 .. v19}, Landroid/graphics/Matrix;->setTranslate(FF)V

    invoke-direct/range {p0 .. p0}, Lcom/android/internal/widget/RotarySelector;->isHoriz()Z

    move-result v17

    if-nez v17, :cond_94

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/RotarySelector;->mArrowMatrix:Landroid/graphics/Matrix;

    move-object/from16 v17, v0

    const/high16 v18, -0x3d4c

    const/16 v19, 0x0

    const/16 v20, 0x0

    invoke-virtual/range {v17 .. v20}, Landroid/graphics/Matrix;->preRotate(FFF)Z

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/RotarySelector;->mArrowMatrix:Landroid/graphics/Matrix;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    int-to-float v0, v11

    move/from16 v19, v0

    invoke-virtual/range {v17 .. v19}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    :cond_94
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/RotarySelector;->mArrowLongLeft:Landroid/graphics/Bitmap;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/RotarySelector;->mArrowMatrix:Landroid/graphics/Matrix;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/RotarySelector;->mPaint:Landroid/graphics/Paint;

    move-object/from16 v19, v0

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    move-object/from16 v2, v18

    move-object/from16 v3, v19

    invoke-virtual {v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V

    :goto_b1
    :pswitch_b1
    move-object/from16 v0, p0

    iget v5, v0, Lcom/android/internal/widget/RotarySelector;->mBackgroundHeight:I

    .local v5, bgHeight:I
    invoke-direct/range {p0 .. p0}, Lcom/android/internal/widget/RotarySelector;->isHoriz()Z

    move-result v17

    if-eqz v17, :cond_29a

    sub-int v6, v11, v5

    .local v6, bgTop:I
    :goto_bd
    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mLeftHandleX:I

    move/from16 v17, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mRotaryOffsetX:I

    move/from16 v18, v0

    add-int v15, v17, v18

    .local v15, xOffset:I
    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mBackgroundWidth:I

    move/from16 v17, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mInnerRadius:I

    move/from16 v18, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mOuterRadius:I

    move/from16 v19, v0

    move-object/from16 v0, p0

    move/from16 v1, v17

    move/from16 v2, v18

    move/from16 v3, v19

    invoke-direct {v0, v1, v2, v3, v15}, Lcom/android/internal/widget/RotarySelector;->getYOnArc(IIII)I

    move-result v9

    .local v9, drawableY:I
    invoke-direct/range {p0 .. p0}, Lcom/android/internal/widget/RotarySelector;->isHoriz()Z

    move-result v17

    if-eqz v17, :cond_29e

    move v14, v15

    .local v14, x:I
    :goto_f0
    invoke-direct/range {p0 .. p0}, Lcom/android/internal/widget/RotarySelector;->isHoriz()Z

    move-result v17

    if-eqz v17, :cond_2a2

    add-int v16, v9, v6

    .local v16, y:I
    :goto_f8
    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mGrabbedState:I

    move/from16 v17, v0

    const/16 v18, 0x2

    move/from16 v0, v17

    move/from16 v1, v18

    if-eq v0, v1, :cond_2a6

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/RotarySelector;->mDimple:Landroid/graphics/Bitmap;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move-object/from16 v2, p1

    move/from16 v3, v16

    invoke-direct {v0, v1, v2, v14, v3}, Lcom/android/internal/widget/RotarySelector;->drawCentered(Landroid/graphics/Bitmap;Landroid/graphics/Canvas;II)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/RotarySelector;->mLeftHandleIcon:Landroid/graphics/Bitmap;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move-object/from16 v2, p1

    move/from16 v3, v16

    invoke-direct {v0, v1, v2, v14, v3}, Lcom/android/internal/widget/RotarySelector;->drawCentered(Landroid/graphics/Bitmap;Landroid/graphics/Canvas;II)V

    :goto_128
    invoke-direct/range {p0 .. p0}, Lcom/android/internal/widget/RotarySelector;->isHoriz()Z

    move-result v17

    if-eqz v17, :cond_2b9

    div-int/lit8 v17, v13, 0x2

    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mRotaryOffsetX:I

    move/from16 v18, v0

    add-int v15, v17, v18

    :goto_138
    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mBackgroundWidth:I

    move/from16 v17, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mInnerRadius:I

    move/from16 v18, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mOuterRadius:I

    move/from16 v19, v0

    move-object/from16 v0, p0

    move/from16 v1, v17

    move/from16 v2, v18

    move/from16 v3, v19

    invoke-direct {v0, v1, v2, v3, v15}, Lcom/android/internal/widget/RotarySelector;->getYOnArc(IIII)I

    move-result v9

    invoke-direct/range {p0 .. p0}, Lcom/android/internal/widget/RotarySelector;->isHoriz()Z

    move-result v17

    if-eqz v17, :cond_2c5

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/RotarySelector;->mDimpleDim:Landroid/graphics/Bitmap;

    move-object/from16 v17, v0

    add-int v18, v9, v6

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move-object/from16 v2, p1

    move/from16 v3, v18

    invoke-direct {v0, v1, v2, v15, v3}, Lcom/android/internal/widget/RotarySelector;->drawCentered(Landroid/graphics/Bitmap;Landroid/graphics/Canvas;II)V

    :goto_16f
    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mRightHandleX:I

    move/from16 v17, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mRotaryOffsetX:I

    move/from16 v18, v0

    add-int v15, v17, v18

    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mBackgroundWidth:I

    move/from16 v17, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mInnerRadius:I

    move/from16 v18, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mOuterRadius:I

    move/from16 v19, v0

    move-object/from16 v0, p0

    move/from16 v1, v17

    move/from16 v2, v18

    move/from16 v3, v19

    invoke-direct {v0, v1, v2, v3, v15}, Lcom/android/internal/widget/RotarySelector;->getYOnArc(IIII)I

    move-result v9

    invoke-direct/range {p0 .. p0}, Lcom/android/internal/widget/RotarySelector;->isHoriz()Z

    move-result v17

    if-eqz v17, :cond_2de

    move v14, v15

    :goto_1a2
    invoke-direct/range {p0 .. p0}, Lcom/android/internal/widget/RotarySelector;->isHoriz()Z

    move-result v17

    if-eqz v17, :cond_2e2

    add-int v16, v9, v6

    :goto_1aa
    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mGrabbedState:I

    move/from16 v17, v0

    const/16 v18, 0x1

    move/from16 v0, v17

    move/from16 v1, v18

    if-eq v0, v1, :cond_2e6

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/RotarySelector;->mDimple:Landroid/graphics/Bitmap;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move-object/from16 v2, p1

    move/from16 v3, v16

    invoke-direct {v0, v1, v2, v14, v3}, Lcom/android/internal/widget/RotarySelector;->drawCentered(Landroid/graphics/Bitmap;Landroid/graphics/Canvas;II)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/RotarySelector;->mRightHandleIcon:Landroid/graphics/Bitmap;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move-object/from16 v2, p1

    move/from16 v3, v16

    invoke-direct {v0, v1, v2, v14, v3}, Lcom/android/internal/widget/RotarySelector;->drawCentered(Landroid/graphics/Bitmap;Landroid/graphics/Canvas;II)V

    :goto_1da
    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mRotaryOffsetX:I

    move/from16 v17, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mLeftHandleX:I

    move/from16 v18, v0

    add-int v17, v17, v18

    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mDimpleSpacing:I

    move/from16 v18, v0

    sub-int v7, v17, v18

    .local v7, dimpleLeft:I
    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mDimpleWidth:I

    move/from16 v17, v0

    div-int/lit8 v10, v17, 0x2

    .local v10, halfdimple:I
    :goto_1f8
    neg-int v0, v10

    move/from16 v17, v0

    move/from16 v0, v17

    if-le v7, v0, :cond_312

    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mBackgroundWidth:I

    move/from16 v17, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mInnerRadius:I

    move/from16 v18, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mOuterRadius:I

    move/from16 v19, v0

    move-object/from16 v0, p0

    move/from16 v1, v17

    move/from16 v2, v18

    move/from16 v3, v19

    invoke-direct {v0, v1, v2, v3, v7}, Lcom/android/internal/widget/RotarySelector;->getYOnArc(IIII)I

    move-result v9

    invoke-direct/range {p0 .. p0}, Lcom/android/internal/widget/RotarySelector;->isHoriz()Z

    move-result v17

    if-eqz v17, :cond_2f9

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/RotarySelector;->mDimpleDim:Landroid/graphics/Bitmap;

    move-object/from16 v17, v0

    add-int v18, v9, v6

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move-object/from16 v2, p1

    move/from16 v3, v18

    invoke-direct {v0, v1, v2, v7, v3}, Lcom/android/internal/widget/RotarySelector;->drawCentered(Landroid/graphics/Bitmap;Landroid/graphics/Canvas;II)V

    :goto_236
    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mDimpleSpacing:I

    move/from16 v17, v0

    sub-int v7, v7, v17

    goto :goto_1f8

    .end local v5           #bgHeight:I
    .end local v6           #bgTop:I
    .end local v7           #dimpleLeft:I
    .end local v9           #drawableY:I
    .end local v10           #halfdimple:I
    .end local v14           #x:I
    .end local v15           #xOffset:I
    .end local v16           #y:I
    :pswitch_23f
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/RotarySelector;->mArrowMatrix:Landroid/graphics/Matrix;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    const/16 v19, 0x0

    invoke-virtual/range {v17 .. v19}, Landroid/graphics/Matrix;->setTranslate(FF)V

    invoke-direct/range {p0 .. p0}, Lcom/android/internal/widget/RotarySelector;->isHoriz()Z

    move-result v17

    if-nez v17, :cond_27b

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/RotarySelector;->mArrowMatrix:Landroid/graphics/Matrix;

    move-object/from16 v17, v0

    const/high16 v18, -0x3d4c

    const/16 v19, 0x0

    const/16 v20, 0x0

    invoke-virtual/range {v17 .. v20}, Landroid/graphics/Matrix;->preRotate(FFF)Z

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/RotarySelector;->mArrowMatrix:Landroid/graphics/Matrix;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mBackgroundWidth:I

    move/from16 v19, v0

    sub-int v19, v19, v11

    add-int v19, v19, v11

    move/from16 v0, v19

    int-to-float v0, v0

    move/from16 v19, v0

    invoke-virtual/range {v17 .. v19}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    :cond_27b
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/RotarySelector;->mArrowLongRight:Landroid/graphics/Bitmap;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/RotarySelector;->mArrowMatrix:Landroid/graphics/Matrix;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/RotarySelector;->mPaint:Landroid/graphics/Paint;

    move-object/from16 v19, v0

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    move-object/from16 v2, v18

    move-object/from16 v3, v19

    invoke-virtual {v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V

    goto/16 :goto_b1

    .restart local v5       #bgHeight:I
    :cond_29a
    sub-int v6, v13, v5

    goto/16 :goto_bd

    .restart local v6       #bgTop:I
    .restart local v9       #drawableY:I
    .restart local v15       #xOffset:I
    :cond_29e
    add-int v14, v9, v6

    goto/16 :goto_f0

    .restart local v14       #x:I
    :cond_2a2
    sub-int v16, v11, v15

    goto/16 :goto_f8

    .restart local v16       #y:I
    :cond_2a6
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/RotarySelector;->mDimpleDim:Landroid/graphics/Bitmap;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move-object/from16 v2, p1

    move/from16 v3, v16

    invoke-direct {v0, v1, v2, v14, v3}, Lcom/android/internal/widget/RotarySelector;->drawCentered(Landroid/graphics/Bitmap;Landroid/graphics/Canvas;II)V

    goto/16 :goto_128

    :cond_2b9
    div-int/lit8 v17, v11, 0x2

    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mRotaryOffsetX:I

    move/from16 v18, v0

    add-int v15, v17, v18

    goto/16 :goto_138

    :cond_2c5
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/RotarySelector;->mDimpleDim:Landroid/graphics/Bitmap;

    move-object/from16 v17, v0

    add-int v18, v9, v6

    sub-int v19, v11, v15

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move-object/from16 v2, p1

    move/from16 v3, v18

    move/from16 v4, v19

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/android/internal/widget/RotarySelector;->drawCentered(Landroid/graphics/Bitmap;Landroid/graphics/Canvas;II)V

    goto/16 :goto_16f

    :cond_2de
    add-int v14, v9, v6

    goto/16 :goto_1a2

    :cond_2e2
    sub-int v16, v11, v15

    goto/16 :goto_1aa

    :cond_2e6
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/RotarySelector;->mDimpleDim:Landroid/graphics/Bitmap;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move-object/from16 v2, p1

    move/from16 v3, v16

    invoke-direct {v0, v1, v2, v14, v3}, Lcom/android/internal/widget/RotarySelector;->drawCentered(Landroid/graphics/Bitmap;Landroid/graphics/Canvas;II)V

    goto/16 :goto_1da

    .restart local v7       #dimpleLeft:I
    .restart local v10       #halfdimple:I
    :cond_2f9
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/RotarySelector;->mDimpleDim:Landroid/graphics/Bitmap;

    move-object/from16 v17, v0

    add-int v18, v9, v6

    sub-int v19, v11, v7

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move-object/from16 v2, p1

    move/from16 v3, v18

    move/from16 v4, v19

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/android/internal/widget/RotarySelector;->drawCentered(Landroid/graphics/Bitmap;Landroid/graphics/Canvas;II)V

    goto/16 :goto_236

    :cond_312
    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mRotaryOffsetX:I

    move/from16 v17, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mRightHandleX:I

    move/from16 v18, v0

    add-int v17, v17, v18

    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mDimpleSpacing:I

    move/from16 v18, v0

    add-int v8, v17, v18

    .local v8, dimpleRight:I
    move-object/from16 v0, p0

    iget v0, v0, Landroid/view/View;->mRight:I

    move/from16 v17, v0

    add-int v12, v17, v10

    .local v12, rightThresh:I
    :goto_330
    if-ge v8, v12, :cond_38a

    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mBackgroundWidth:I

    move/from16 v17, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mInnerRadius:I

    move/from16 v18, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mOuterRadius:I

    move/from16 v19, v0

    move-object/from16 v0, p0

    move/from16 v1, v17

    move/from16 v2, v18

    move/from16 v3, v19

    invoke-direct {v0, v1, v2, v3, v8}, Lcom/android/internal/widget/RotarySelector;->getYOnArc(IIII)I

    move-result v9

    invoke-direct/range {p0 .. p0}, Lcom/android/internal/widget/RotarySelector;->isHoriz()Z

    move-result v17

    if-eqz v17, :cond_372

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/RotarySelector;->mDimpleDim:Landroid/graphics/Bitmap;

    move-object/from16 v17, v0

    add-int v18, v9, v6

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move-object/from16 v2, p1

    move/from16 v3, v18

    invoke-direct {v0, v1, v2, v8, v3}, Lcom/android/internal/widget/RotarySelector;->drawCentered(Landroid/graphics/Bitmap;Landroid/graphics/Canvas;II)V

    :goto_369
    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/RotarySelector;->mDimpleSpacing:I

    move/from16 v17, v0

    add-int v8, v8, v17

    goto :goto_330

    :cond_372
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/RotarySelector;->mDimpleDim:Landroid/graphics/Bitmap;

    move-object/from16 v17, v0

    add-int v18, v9, v6

    sub-int v19, v11, v8

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move-object/from16 v2, p1

    move/from16 v3, v18

    move/from16 v4, v19

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/android/internal/widget/RotarySelector;->drawCentered(Landroid/graphics/Bitmap;Landroid/graphics/Canvas;II)V

    goto :goto_369

    :cond_38a
    return-void

    nop

    :pswitch_data_38c
    .packed-switch 0x0
        :pswitch_b1
        :pswitch_64
        :pswitch_23f
    .end packed-switch
.end method

.method protected onMeasure(II)V
    .registers 9
    .parameter "widthMeasureSpec"
    .parameter "heightMeasureSpec"

    .prologue
    invoke-direct {p0}, Lcom/android/internal/widget/RotarySelector;->isHoriz()Z

    move-result v4

    if-eqz v4, :cond_25

    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v3

    .local v3, length:I
    :goto_a
    const/high16 v4, 0x40c0

    iget v5, p0, Lcom/android/internal/widget/RotarySelector;->mDensity:F

    mul-float/2addr v4, v5

    float-to-int v1, v4

    .local v1, arrowScrunch:I
    iget-object v4, p0, Lcom/android/internal/widget/RotarySelector;->mArrowShortLeftAndRight:Landroid/graphics/Bitmap;

    invoke-virtual {v4}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v0

    .local v0, arrowH:I
    iget v4, p0, Lcom/android/internal/widget/RotarySelector;->mBackgroundHeight:I

    add-int/2addr v4, v0

    sub-int v2, v4, v1

    .local v2, height:I
    invoke-direct {p0}, Lcom/android/internal/widget/RotarySelector;->isHoriz()Z

    move-result v4

    if-eqz v4, :cond_2a

    invoke-virtual {p0, v3, v2}, Lcom/android/internal/widget/RotarySelector;->setMeasuredDimension(II)V

    :goto_24
    return-void

    .end local v0           #arrowH:I
    .end local v1           #arrowScrunch:I
    .end local v2           #height:I
    .end local v3           #length:I
    :cond_25
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v3

    goto :goto_a

    .restart local v0       #arrowH:I
    .restart local v1       #arrowScrunch:I
    .restart local v2       #height:I
    .restart local v3       #length:I
    :cond_2a
    invoke-virtual {p0, v2, v3}, Lcom/android/internal/widget/RotarySelector;->setMeasuredDimension(II)V

    goto :goto_24
.end method

.method protected onSizeChanged(IIII)V
    .registers 11
    .parameter "w"
    .parameter "h"
    .parameter "oldw"
    .parameter "oldh"

    .prologue
    const/4 v5, 0x0

    invoke-super {p0, p1, p2, p3, p4}, Landroid/view/View;->onSizeChanged(IIII)V

    const/high16 v3, 0x4110

    iget v4, p0, Lcom/android/internal/widget/RotarySelector;->mDensity:F

    mul-float/2addr v3, v4

    float-to-int v0, v3

    .local v0, edgePadding:I
    iget v3, p0, Lcom/android/internal/widget/RotarySelector;->mDimpleWidth:I

    div-int/lit8 v3, v3, 0x2

    add-int/2addr v3, v0

    iput v3, p0, Lcom/android/internal/widget/RotarySelector;->mLeftHandleX:I

    invoke-direct {p0}, Lcom/android/internal/widget/RotarySelector;->isHoriz()Z

    move-result v3

    if-eqz v3, :cond_46

    move v2, p1

    .local v2, length:I
    :goto_18
    sub-int v3, v2, v0

    iget v4, p0, Lcom/android/internal/widget/RotarySelector;->mDimpleWidth:I

    div-int/lit8 v4, v4, 0x2

    sub-int/2addr v3, v4

    iput v3, p0, Lcom/android/internal/widget/RotarySelector;->mRightHandleX:I

    div-int/lit8 v3, v2, 0x2

    iget v4, p0, Lcom/android/internal/widget/RotarySelector;->mLeftHandleX:I

    sub-int/2addr v3, v4

    iput v3, p0, Lcom/android/internal/widget/RotarySelector;->mDimpleSpacing:I

    iget-object v3, p0, Lcom/android/internal/widget/RotarySelector;->mBgMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v3, v5, v5}, Landroid/graphics/Matrix;->setTranslate(FF)V

    invoke-direct {p0}, Lcom/android/internal/widget/RotarySelector;->isHoriz()Z

    move-result v3

    if-nez v3, :cond_48

    iget v3, p0, Lcom/android/internal/widget/RotarySelector;->mBackgroundHeight:I

    sub-int v1, p1, v3

    .local v1, left:I
    iget-object v3, p0, Lcom/android/internal/widget/RotarySelector;->mBgMatrix:Landroid/graphics/Matrix;

    const/high16 v4, -0x3d4c

    invoke-virtual {v3, v4, v5, v5}, Landroid/graphics/Matrix;->preRotate(FFF)Z

    iget-object v3, p0, Lcom/android/internal/widget/RotarySelector;->mBgMatrix:Landroid/graphics/Matrix;

    int-to-float v4, v1

    int-to-float v5, p2

    invoke-virtual {v3, v4, v5}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    .end local v1           #left:I
    :goto_45
    return-void

    .end local v2           #length:I
    :cond_46
    move v2, p2

    goto :goto_18

    .restart local v2       #length:I
    :cond_48
    iget-object v3, p0, Lcom/android/internal/widget/RotarySelector;->mBgMatrix:Landroid/graphics/Matrix;

    iget v4, p0, Lcom/android/internal/widget/RotarySelector;->mBackgroundHeight:I

    sub-int v4, p2, v4

    int-to-float v4, v4

    invoke-virtual {v3, v5, v4}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    goto :goto_45
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .registers 16
    .parameter "event"

    .prologue
    const/16 v13, 0x8

    const/4 v12, 0x5

    const/4 v9, 0x2

    const/4 v10, 0x0

    const/4 v11, 0x1

    iget-boolean v8, p0, Lcom/android/internal/widget/RotarySelector;->mAnimating:Z

    if-eqz v8, :cond_b

    :cond_a
    :goto_a
    return v11

    :cond_b
    iget-object v8, p0, Lcom/android/internal/widget/RotarySelector;->mVelocityTracker:Landroid/view/VelocityTracker;

    if-nez v8, :cond_15

    invoke-static {}, Landroid/view/VelocityTracker;->obtain()Landroid/view/VelocityTracker;

    move-result-object v8

    iput-object v8, p0, Lcom/android/internal/widget/RotarySelector;->mVelocityTracker:Landroid/view/VelocityTracker;

    :cond_15
    iget-object v8, p0, Lcom/android/internal/widget/RotarySelector;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v8, p1}, Landroid/view/VelocityTracker;->addMovement(Landroid/view/MotionEvent;)V

    invoke-virtual {p0}, Lcom/android/internal/widget/RotarySelector;->getHeight()I

    move-result v2

    .local v2, height:I
    invoke-direct {p0}, Lcom/android/internal/widget/RotarySelector;->isHoriz()Z

    move-result v8

    if-eqz v8, :cond_56

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v8

    float-to-int v1, v8

    .local v1, eventX:I
    :goto_29
    iget v3, p0, Lcom/android/internal/widget/RotarySelector;->mDimpleWidth:I

    .local v3, hitWindow:I
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    .local v0, action:I
    packed-switch v0, :pswitch_data_18e

    goto :goto_a

    :pswitch_33
    iput-boolean v10, p0, Lcom/android/internal/widget/RotarySelector;->mTriggered:Z

    iget v8, p0, Lcom/android/internal/widget/RotarySelector;->mGrabbedState:I

    if-eqz v8, :cond_3f

    invoke-direct {p0}, Lcom/android/internal/widget/RotarySelector;->reset()V

    invoke-virtual {p0}, Lcom/android/internal/widget/RotarySelector;->invalidate()V

    :cond_3f
    iget v8, p0, Lcom/android/internal/widget/RotarySelector;->mLeftHandleX:I

    add-int/2addr v8, v3

    if-ge v1, v8, :cond_5e

    iget v8, p0, Lcom/android/internal/widget/RotarySelector;->mLeftHandleX:I

    sub-int v8, v1, v8

    iput v8, p0, Lcom/android/internal/widget/RotarySelector;->mRotaryOffsetX:I

    invoke-direct {p0, v11}, Lcom/android/internal/widget/RotarySelector;->setGrabbedState(I)V

    invoke-virtual {p0}, Lcom/android/internal/widget/RotarySelector;->invalidate()V

    const-wide/16 v8, 0x14

    invoke-direct {p0, v8, v9}, Lcom/android/internal/widget/RotarySelector;->vibrate(J)V

    goto :goto_a

    .end local v0           #action:I
    .end local v1           #eventX:I
    .end local v3           #hitWindow:I
    :cond_56
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v8

    float-to-int v8, v8

    sub-int v1, v2, v8

    goto :goto_29

    .restart local v0       #action:I
    .restart local v1       #eventX:I
    .restart local v3       #hitWindow:I
    :cond_5e
    iget v8, p0, Lcom/android/internal/widget/RotarySelector;->mRightHandleX:I

    sub-int/2addr v8, v3

    if-le v1, v8, :cond_a

    iget v8, p0, Lcom/android/internal/widget/RotarySelector;->mRightHandleX:I

    sub-int v8, v1, v8

    iput v8, p0, Lcom/android/internal/widget/RotarySelector;->mRotaryOffsetX:I

    invoke-direct {p0, v9}, Lcom/android/internal/widget/RotarySelector;->setGrabbedState(I)V

    invoke-virtual {p0}, Lcom/android/internal/widget/RotarySelector;->invalidate()V

    const-wide/16 v8, 0x14

    invoke-direct {p0, v8, v9}, Lcom/android/internal/widget/RotarySelector;->vibrate(J)V

    goto :goto_a

    :pswitch_75
    iget v8, p0, Lcom/android/internal/widget/RotarySelector;->mGrabbedState:I

    if-ne v8, v11, :cond_db

    iget v8, p0, Lcom/android/internal/widget/RotarySelector;->mLeftHandleX:I

    sub-int v8, v1, v8

    iput v8, p0, Lcom/android/internal/widget/RotarySelector;->mRotaryOffsetX:I

    invoke-virtual {p0}, Lcom/android/internal/widget/RotarySelector;->invalidate()V

    invoke-direct {p0}, Lcom/android/internal/widget/RotarySelector;->isHoriz()Z

    move-result v8

    if-eqz v8, :cond_d2

    invoke-virtual {p0}, Lcom/android/internal/widget/RotarySelector;->getRight()I

    move-result v5

    .local v5, rightThresh:I
    :goto_8c
    iget v8, p0, Lcom/android/internal/widget/RotarySelector;->mEdgeTriggerThresh:I

    sub-int v8, v5, v8

    if-lt v1, v8, :cond_a

    iget-boolean v8, p0, Lcom/android/internal/widget/RotarySelector;->mTriggered:Z

    if-nez v8, :cond_a

    iput-boolean v11, p0, Lcom/android/internal/widget/RotarySelector;->mTriggered:Z

    invoke-direct {p0, v11}, Lcom/android/internal/widget/RotarySelector;->dispatchTriggerEvent(I)V

    iget-object v7, p0, Lcom/android/internal/widget/RotarySelector;->mVelocityTracker:Landroid/view/VelocityTracker;

    .local v7, velocityTracker:Landroid/view/VelocityTracker;
    const/16 v8, 0x3e8

    iget v9, p0, Lcom/android/internal/widget/RotarySelector;->mMaximumVelocity:I

    int-to-float v9, v9

    invoke-virtual {v7, v8, v9}, Landroid/view/VelocityTracker;->computeCurrentVelocity(IF)V

    invoke-direct {p0}, Lcom/android/internal/widget/RotarySelector;->isHoriz()Z

    move-result v8

    if-eqz v8, :cond_d4

    invoke-virtual {v7}, Landroid/view/VelocityTracker;->getXVelocity()F

    move-result v8

    float-to-int v4, v8

    .local v4, rawVelocity:I
    :goto_b0
    iget v8, p0, Lcom/android/internal/widget/RotarySelector;->mMinimumVelocity:I

    invoke-static {v8, v4}, Ljava/lang/Math;->max(II)I

    move-result v6

    .local v6, velocity:I
    iget v8, p0, Lcom/android/internal/widget/RotarySelector;->mDimpleSpacing:I

    div-int v8, v6, v8

    invoke-static {v8}, Ljava/lang/Math;->abs(I)I

    move-result v8

    invoke-static {v13, v8}, Ljava/lang/Math;->max(II)I

    move-result v8

    iput v8, p0, Lcom/android/internal/widget/RotarySelector;->mDimplesOfFling:I

    iget v8, p0, Lcom/android/internal/widget/RotarySelector;->mLeftHandleX:I

    sub-int v8, v1, v8

    iget v9, p0, Lcom/android/internal/widget/RotarySelector;->mDimplesOfFling:I

    iget v10, p0, Lcom/android/internal/widget/RotarySelector;->mDimpleSpacing:I

    mul-int/2addr v9, v10

    invoke-direct {p0, v8, v9, v6}, Lcom/android/internal/widget/RotarySelector;->startAnimationWithVelocity(III)V

    goto/16 :goto_a

    .end local v4           #rawVelocity:I
    .end local v5           #rightThresh:I
    .end local v6           #velocity:I
    .end local v7           #velocityTracker:Landroid/view/VelocityTracker;
    :cond_d2
    move v5, v2

    goto :goto_8c

    .restart local v5       #rightThresh:I
    .restart local v7       #velocityTracker:Landroid/view/VelocityTracker;
    :cond_d4
    invoke-virtual {v7}, Landroid/view/VelocityTracker;->getYVelocity()F

    move-result v8

    float-to-int v8, v8

    neg-int v4, v8

    goto :goto_b0

    .end local v5           #rightThresh:I
    .end local v7           #velocityTracker:Landroid/view/VelocityTracker;
    :cond_db
    iget v8, p0, Lcom/android/internal/widget/RotarySelector;->mGrabbedState:I

    if-ne v8, v9, :cond_a

    iget v8, p0, Lcom/android/internal/widget/RotarySelector;->mRightHandleX:I

    sub-int v8, v1, v8

    iput v8, p0, Lcom/android/internal/widget/RotarySelector;->mRotaryOffsetX:I

    invoke-virtual {p0}, Lcom/android/internal/widget/RotarySelector;->invalidate()V

    iget v8, p0, Lcom/android/internal/widget/RotarySelector;->mEdgeTriggerThresh:I

    if-gt v1, v8, :cond_a

    iget-boolean v8, p0, Lcom/android/internal/widget/RotarySelector;->mTriggered:Z

    if-nez v8, :cond_a

    iput-boolean v11, p0, Lcom/android/internal/widget/RotarySelector;->mTriggered:Z

    invoke-direct {p0, v9}, Lcom/android/internal/widget/RotarySelector;->dispatchTriggerEvent(I)V

    iget-object v7, p0, Lcom/android/internal/widget/RotarySelector;->mVelocityTracker:Landroid/view/VelocityTracker;

    .restart local v7       #velocityTracker:Landroid/view/VelocityTracker;
    const/16 v8, 0x3e8

    iget v9, p0, Lcom/android/internal/widget/RotarySelector;->mMaximumVelocity:I

    int-to-float v9, v9

    invoke-virtual {v7, v8, v9}, Landroid/view/VelocityTracker;->computeCurrentVelocity(IF)V

    invoke-direct {p0}, Lcom/android/internal/widget/RotarySelector;->isHoriz()Z

    move-result v8

    if-eqz v8, :cond_12e

    invoke-virtual {v7}, Landroid/view/VelocityTracker;->getXVelocity()F

    move-result v8

    float-to-int v4, v8

    .restart local v4       #rawVelocity:I
    :goto_10a
    iget v8, p0, Lcom/android/internal/widget/RotarySelector;->mMinimumVelocity:I

    neg-int v8, v8

    invoke-static {v8, v4}, Ljava/lang/Math;->min(II)I

    move-result v6

    .restart local v6       #velocity:I
    iget v8, p0, Lcom/android/internal/widget/RotarySelector;->mDimpleSpacing:I

    div-int v8, v6, v8

    invoke-static {v8}, Ljava/lang/Math;->abs(I)I

    move-result v8

    invoke-static {v13, v8}, Ljava/lang/Math;->max(II)I

    move-result v8

    iput v8, p0, Lcom/android/internal/widget/RotarySelector;->mDimplesOfFling:I

    iget v8, p0, Lcom/android/internal/widget/RotarySelector;->mRightHandleX:I

    sub-int v8, v1, v8

    iget v9, p0, Lcom/android/internal/widget/RotarySelector;->mDimplesOfFling:I

    iget v10, p0, Lcom/android/internal/widget/RotarySelector;->mDimpleSpacing:I

    mul-int/2addr v9, v10

    neg-int v9, v9

    invoke-direct {p0, v8, v9, v6}, Lcom/android/internal/widget/RotarySelector;->startAnimationWithVelocity(III)V

    goto/16 :goto_a

    .end local v4           #rawVelocity:I
    .end local v6           #velocity:I
    :cond_12e
    invoke-virtual {v7}, Landroid/view/VelocityTracker;->getYVelocity()F

    move-result v8

    float-to-int v8, v8

    neg-int v4, v8

    goto :goto_10a

    .end local v7           #velocityTracker:Landroid/view/VelocityTracker;
    :pswitch_135
    iget v8, p0, Lcom/android/internal/widget/RotarySelector;->mGrabbedState:I

    if-ne v8, v11, :cond_162

    iget v8, p0, Lcom/android/internal/widget/RotarySelector;->mLeftHandleX:I

    sub-int v8, v1, v8

    invoke-static {v8}, Ljava/lang/Math;->abs(I)I

    move-result v8

    if-le v8, v12, :cond_162

    iget v8, p0, Lcom/android/internal/widget/RotarySelector;->mLeftHandleX:I

    sub-int v8, v1, v8

    const/16 v9, 0x12c

    invoke-direct {p0, v8, v10, v9}, Lcom/android/internal/widget/RotarySelector;->startAnimation(III)V

    :cond_14c
    :goto_14c
    iput v10, p0, Lcom/android/internal/widget/RotarySelector;->mRotaryOffsetX:I

    invoke-direct {p0, v10}, Lcom/android/internal/widget/RotarySelector;->setGrabbedState(I)V

    invoke-virtual {p0}, Lcom/android/internal/widget/RotarySelector;->invalidate()V

    iget-object v8, p0, Lcom/android/internal/widget/RotarySelector;->mVelocityTracker:Landroid/view/VelocityTracker;

    if-eqz v8, :cond_a

    iget-object v8, p0, Lcom/android/internal/widget/RotarySelector;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v8}, Landroid/view/VelocityTracker;->recycle()V

    const/4 v8, 0x0

    iput-object v8, p0, Lcom/android/internal/widget/RotarySelector;->mVelocityTracker:Landroid/view/VelocityTracker;

    goto/16 :goto_a

    :cond_162
    iget v8, p0, Lcom/android/internal/widget/RotarySelector;->mGrabbedState:I

    if-ne v8, v9, :cond_14c

    iget v8, p0, Lcom/android/internal/widget/RotarySelector;->mRightHandleX:I

    sub-int v8, v1, v8

    invoke-static {v8}, Ljava/lang/Math;->abs(I)I

    move-result v8

    if-le v8, v12, :cond_14c

    iget v8, p0, Lcom/android/internal/widget/RotarySelector;->mRightHandleX:I

    sub-int v8, v1, v8

    const/16 v9, 0x12c

    invoke-direct {p0, v8, v10, v9}, Lcom/android/internal/widget/RotarySelector;->startAnimation(III)V

    goto :goto_14c

    :pswitch_17a
    invoke-direct {p0}, Lcom/android/internal/widget/RotarySelector;->reset()V

    invoke-virtual {p0}, Lcom/android/internal/widget/RotarySelector;->invalidate()V

    iget-object v8, p0, Lcom/android/internal/widget/RotarySelector;->mVelocityTracker:Landroid/view/VelocityTracker;

    if-eqz v8, :cond_a

    iget-object v8, p0, Lcom/android/internal/widget/RotarySelector;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v8}, Landroid/view/VelocityTracker;->recycle()V

    const/4 v8, 0x0

    iput-object v8, p0, Lcom/android/internal/widget/RotarySelector;->mVelocityTracker:Landroid/view/VelocityTracker;

    goto/16 :goto_a

    :pswitch_data_18e
    .packed-switch 0x0
        :pswitch_33
        :pswitch_135
        :pswitch_75
        :pswitch_17a
    .end packed-switch
.end method

.method public setLeftHandleResource(I)V
    .registers 3
    .parameter "resId"

    .prologue
    if-eqz p1, :cond_8

    invoke-direct {p0, p1}, Lcom/android/internal/widget/RotarySelector;->getBitmapFor(I)Landroid/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lcom/android/internal/widget/RotarySelector;->mLeftHandleIcon:Landroid/graphics/Bitmap;

    :cond_8
    invoke-virtual {p0}, Lcom/android/internal/widget/RotarySelector;->invalidate()V

    return-void
.end method

.method public setOnDialTriggerListener(Lcom/android/internal/widget/RotarySelector$OnDialTriggerListener;)V
    .registers 2
    .parameter "l"

    .prologue
    iput-object p1, p0, Lcom/android/internal/widget/RotarySelector;->mOnDialTriggerListener:Lcom/android/internal/widget/RotarySelector$OnDialTriggerListener;

    return-void
.end method

.method public setRightHandleResource(I)V
    .registers 3
    .parameter "resId"

    .prologue
    if-eqz p1, :cond_8

    invoke-direct {p0, p1}, Lcom/android/internal/widget/RotarySelector;->getBitmapFor(I)Landroid/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lcom/android/internal/widget/RotarySelector;->mRightHandleIcon:Landroid/graphics/Bitmap;

    :cond_8
    invoke-virtual {p0}, Lcom/android/internal/widget/RotarySelector;->invalidate()V

    return-void
.end method
