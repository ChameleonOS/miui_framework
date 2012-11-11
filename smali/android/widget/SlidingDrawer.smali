.class public Landroid/widget/SlidingDrawer;
.super Landroid/view/ViewGroup;
.source "SlidingDrawer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/widget/SlidingDrawer$1;,
        Landroid/widget/SlidingDrawer$SlidingHandler;,
        Landroid/widget/SlidingDrawer$DrawerToggler;,
        Landroid/widget/SlidingDrawer$OnDrawerScrollListener;,
        Landroid/widget/SlidingDrawer$OnDrawerCloseListener;,
        Landroid/widget/SlidingDrawer$OnDrawerOpenListener;
    }
.end annotation


# static fields
.field private static final ANIMATION_FRAME_DURATION:I = 0x10

.field private static final COLLAPSED_FULL_CLOSED:I = -0x2712

.field private static final EXPANDED_FULL_OPEN:I = -0x2711

.field private static final MAXIMUM_ACCELERATION:F = 2000.0f

.field private static final MAXIMUM_MAJOR_VELOCITY:F = 200.0f

.field private static final MAXIMUM_MINOR_VELOCITY:F = 150.0f

.field private static final MAXIMUM_TAP_VELOCITY:F = 100.0f

.field private static final MSG_ANIMATE:I = 0x3e8

.field public static final ORIENTATION_HORIZONTAL:I = 0x0

.field public static final ORIENTATION_VERTICAL:I = 0x1

.field private static final TAP_THRESHOLD:I = 0x6

.field private static final VELOCITY_UNITS:I = 0x3e8


# instance fields
.field private mAllowSingleTap:Z

.field private mAnimateOnClick:Z

.field private mAnimatedAcceleration:F

.field private mAnimatedVelocity:F

.field private mAnimating:Z

.field private mAnimationLastTime:J

.field private mAnimationPosition:F

.field private mBottomOffset:I

.field private mContent:Landroid/view/View;

.field private final mContentId:I

.field private mCurrentAnimationTime:J

.field private mExpanded:Z

.field private final mFrame:Landroid/graphics/Rect;

.field private mHandle:Landroid/view/View;

.field private mHandleHeight:I

.field private final mHandleId:I

.field private mHandleWidth:I

.field private final mHandler:Landroid/os/Handler;

.field private final mInvalidate:Landroid/graphics/Rect;

.field private mLocked:Z

.field private final mMaximumAcceleration:I

.field private final mMaximumMajorVelocity:I

.field private final mMaximumMinorVelocity:I

.field private final mMaximumTapVelocity:I

.field private mOnDrawerCloseListener:Landroid/widget/SlidingDrawer$OnDrawerCloseListener;

.field private mOnDrawerOpenListener:Landroid/widget/SlidingDrawer$OnDrawerOpenListener;

.field private mOnDrawerScrollListener:Landroid/widget/SlidingDrawer$OnDrawerScrollListener;

.field private final mTapThreshold:I

.field private mTopOffset:I

.field private mTouchDelta:I

.field private mTracking:Z

.field private mVelocityTracker:Landroid/view/VelocityTracker;

.field private final mVelocityUnits:I

.field private mVertical:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 4
    .parameter "context"
    .parameter "attrs"

    .prologue
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Landroid/widget/SlidingDrawer;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .registers 15
    .parameter "context"
    .parameter "attrs"
    .parameter "defStyle"

    .prologue
    const/4 v10, 0x0

    const/4 v6, 0x1

    const/4 v7, 0x0

    const/high16 v9, 0x3f00

    invoke-direct {p0, p1, p2, p3}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    new-instance v5, Landroid/graphics/Rect;

    invoke-direct {v5}, Landroid/graphics/Rect;-><init>()V

    iput-object v5, p0, Landroid/widget/SlidingDrawer;->mFrame:Landroid/graphics/Rect;

    new-instance v5, Landroid/graphics/Rect;

    invoke-direct {v5}, Landroid/graphics/Rect;-><init>()V

    iput-object v5, p0, Landroid/widget/SlidingDrawer;->mInvalidate:Landroid/graphics/Rect;

    new-instance v5, Landroid/widget/SlidingDrawer$SlidingHandler;

    const/4 v8, 0x0

    invoke-direct {v5, p0, v8}, Landroid/widget/SlidingDrawer$SlidingHandler;-><init>(Landroid/widget/SlidingDrawer;Landroid/widget/SlidingDrawer$1;)V

    iput-object v5, p0, Landroid/widget/SlidingDrawer;->mHandler:Landroid/os/Handler;

    sget-object v5, Landroid/R$styleable;->SlidingDrawer:[I

    invoke-virtual {p1, p2, v5, p3, v7}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .local v0, a:Landroid/content/res/TypedArray;
    invoke-virtual {v0, v7, v6}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v4

    .local v4, orientation:I
    if-ne v4, v6, :cond_59

    move v5, v6

    :goto_2b
    iput-boolean v5, p0, Landroid/widget/SlidingDrawer;->mVertical:Z

    invoke-virtual {v0, v6, v10}, Landroid/content/res/TypedArray;->getDimension(IF)F

    move-result v5

    float-to-int v5, v5

    iput v5, p0, Landroid/widget/SlidingDrawer;->mBottomOffset:I

    const/4 v5, 0x2

    invoke-virtual {v0, v5, v10}, Landroid/content/res/TypedArray;->getDimension(IF)F

    move-result v5

    float-to-int v5, v5

    iput v5, p0, Landroid/widget/SlidingDrawer;->mTopOffset:I

    const/4 v5, 0x3

    invoke-virtual {v0, v5, v6}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v5

    iput-boolean v5, p0, Landroid/widget/SlidingDrawer;->mAllowSingleTap:Z

    const/4 v5, 0x6

    invoke-virtual {v0, v5, v6}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v5

    iput-boolean v5, p0, Landroid/widget/SlidingDrawer;->mAnimateOnClick:Z

    const/4 v5, 0x4

    invoke-virtual {v0, v5, v7}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v3

    .local v3, handleId:I
    if-nez v3, :cond_5b

    new-instance v5, Ljava/lang/IllegalArgumentException;

    const-string v6, "The handle attribute is required and must refer to a valid child."

    invoke-direct {v5, v6}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    .end local v3           #handleId:I
    :cond_59
    move v5, v7

    goto :goto_2b

    .restart local v3       #handleId:I
    :cond_5b
    const/4 v5, 0x5

    invoke-virtual {v0, v5, v7}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v1

    .local v1, contentId:I
    if-nez v1, :cond_6a

    new-instance v5, Ljava/lang/IllegalArgumentException;

    const-string v6, "The content attribute is required and must refer to a valid child."

    invoke-direct {v5, v6}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    :cond_6a
    if-ne v3, v1, :cond_74

    new-instance v5, Ljava/lang/IllegalArgumentException;

    const-string v6, "The content and handle attributes must refer to different children."

    invoke-direct {v5, v6}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    :cond_74
    iput v3, p0, Landroid/widget/SlidingDrawer;->mHandleId:I

    iput v1, p0, Landroid/widget/SlidingDrawer;->mContentId:I

    invoke-virtual {p0}, Landroid/widget/SlidingDrawer;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v5

    iget v2, v5, Landroid/util/DisplayMetrics;->density:F

    .local v2, density:F
    const/high16 v5, 0x40c0

    mul-float/2addr v5, v2

    add-float/2addr v5, v9

    float-to-int v5, v5

    iput v5, p0, Landroid/widget/SlidingDrawer;->mTapThreshold:I

    const/high16 v5, 0x42c8

    mul-float/2addr v5, v2

    add-float/2addr v5, v9

    float-to-int v5, v5

    iput v5, p0, Landroid/widget/SlidingDrawer;->mMaximumTapVelocity:I

    const/high16 v5, 0x4316

    mul-float/2addr v5, v2

    add-float/2addr v5, v9

    float-to-int v5, v5

    iput v5, p0, Landroid/widget/SlidingDrawer;->mMaximumMinorVelocity:I

    const/high16 v5, 0x4348

    mul-float/2addr v5, v2

    add-float/2addr v5, v9

    float-to-int v5, v5

    iput v5, p0, Landroid/widget/SlidingDrawer;->mMaximumMajorVelocity:I

    const/high16 v5, 0x44fa

    mul-float/2addr v5, v2

    add-float/2addr v5, v9

    float-to-int v5, v5

    iput v5, p0, Landroid/widget/SlidingDrawer;->mMaximumAcceleration:I

    const/high16 v5, 0x447a

    mul-float/2addr v5, v2

    add-float/2addr v5, v9

    float-to-int v5, v5

    iput v5, p0, Landroid/widget/SlidingDrawer;->mVelocityUnits:I

    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    invoke-virtual {p0, v7}, Landroid/widget/SlidingDrawer;->setAlwaysDrawnWithCacheEnabled(Z)V

    return-void
.end method

.method static synthetic access$200(Landroid/widget/SlidingDrawer;)Z
    .registers 2
    .parameter "x0"

    .prologue
    iget-boolean v0, p0, Landroid/widget/SlidingDrawer;->mLocked:Z

    return v0
.end method

.method static synthetic access$300(Landroid/widget/SlidingDrawer;)Z
    .registers 2
    .parameter "x0"

    .prologue
    iget-boolean v0, p0, Landroid/widget/SlidingDrawer;->mAnimateOnClick:Z

    return v0
.end method

.method static synthetic access$400(Landroid/widget/SlidingDrawer;)V
    .registers 1
    .parameter "x0"

    .prologue
    invoke-direct {p0}, Landroid/widget/SlidingDrawer;->doAnimation()V

    return-void
.end method

.method private animateClose(I)V
    .registers 4
    .parameter "position"

    .prologue
    invoke-direct {p0, p1}, Landroid/widget/SlidingDrawer;->prepareTracking(I)V

    iget v0, p0, Landroid/widget/SlidingDrawer;->mMaximumAcceleration:I

    int-to-float v0, v0

    const/4 v1, 0x1

    invoke-direct {p0, p1, v0, v1}, Landroid/widget/SlidingDrawer;->performFling(IFZ)V

    return-void
.end method

.method private animateOpen(I)V
    .registers 4
    .parameter "position"

    .prologue
    invoke-direct {p0, p1}, Landroid/widget/SlidingDrawer;->prepareTracking(I)V

    iget v0, p0, Landroid/widget/SlidingDrawer;->mMaximumAcceleration:I

    neg-int v0, v0

    int-to-float v0, v0

    const/4 v1, 0x1

    invoke-direct {p0, p1, v0, v1}, Landroid/widget/SlidingDrawer;->performFling(IFZ)V

    return-void
.end method

.method private closeDrawer()V
    .registers 3

    .prologue
    const/16 v0, -0x2712

    invoke-direct {p0, v0}, Landroid/widget/SlidingDrawer;->moveHandle(I)V

    iget-object v0, p0, Landroid/widget/SlidingDrawer;->mContent:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    iget-object v0, p0, Landroid/widget/SlidingDrawer;->mContent:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->destroyDrawingCache()V

    iget-boolean v0, p0, Landroid/widget/SlidingDrawer;->mExpanded:Z

    if-nez v0, :cond_16

    :cond_15
    :goto_15
    return-void

    :cond_16
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/widget/SlidingDrawer;->mExpanded:Z

    iget-object v0, p0, Landroid/widget/SlidingDrawer;->mOnDrawerCloseListener:Landroid/widget/SlidingDrawer$OnDrawerCloseListener;

    if-eqz v0, :cond_15

    iget-object v0, p0, Landroid/widget/SlidingDrawer;->mOnDrawerCloseListener:Landroid/widget/SlidingDrawer$OnDrawerCloseListener;

    invoke-interface {v0}, Landroid/widget/SlidingDrawer$OnDrawerCloseListener;->onDrawerClosed()V

    goto :goto_15
.end method

.method private doAnimation()V
    .registers 5

    .prologue
    const/4 v3, 0x0

    iget-boolean v0, p0, Landroid/widget/SlidingDrawer;->mAnimating:Z

    if-eqz v0, :cond_21

    invoke-direct {p0}, Landroid/widget/SlidingDrawer;->incrementAnimation()V

    iget v1, p0, Landroid/widget/SlidingDrawer;->mAnimationPosition:F

    iget v2, p0, Landroid/widget/SlidingDrawer;->mBottomOffset:I

    iget-boolean v0, p0, Landroid/widget/SlidingDrawer;->mVertical:Z

    if-eqz v0, :cond_22

    invoke-virtual {p0}, Landroid/widget/SlidingDrawer;->getHeight()I

    move-result v0

    :goto_14
    add-int/2addr v0, v2

    add-int/lit8 v0, v0, -0x1

    int-to-float v0, v0

    cmpl-float v0, v1, v0

    if-ltz v0, :cond_27

    iput-boolean v3, p0, Landroid/widget/SlidingDrawer;->mAnimating:Z

    invoke-direct {p0}, Landroid/widget/SlidingDrawer;->closeDrawer()V

    :cond_21
    :goto_21
    return-void

    :cond_22
    invoke-virtual {p0}, Landroid/widget/SlidingDrawer;->getWidth()I

    move-result v0

    goto :goto_14

    :cond_27
    iget v0, p0, Landroid/widget/SlidingDrawer;->mAnimationPosition:F

    iget v1, p0, Landroid/widget/SlidingDrawer;->mTopOffset:I

    int-to-float v1, v1

    cmpg-float v0, v0, v1

    if-gez v0, :cond_36

    iput-boolean v3, p0, Landroid/widget/SlidingDrawer;->mAnimating:Z

    invoke-direct {p0}, Landroid/widget/SlidingDrawer;->openDrawer()V

    goto :goto_21

    :cond_36
    iget v0, p0, Landroid/widget/SlidingDrawer;->mAnimationPosition:F

    float-to-int v0, v0

    invoke-direct {p0, v0}, Landroid/widget/SlidingDrawer;->moveHandle(I)V

    iget-wide v0, p0, Landroid/widget/SlidingDrawer;->mCurrentAnimationTime:J

    const-wide/16 v2, 0x10

    add-long/2addr v0, v2

    iput-wide v0, p0, Landroid/widget/SlidingDrawer;->mCurrentAnimationTime:J

    iget-object v0, p0, Landroid/widget/SlidingDrawer;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Landroid/widget/SlidingDrawer;->mHandler:Landroid/os/Handler;

    const/16 v2, 0x3e8

    invoke-virtual {v1, v2}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v1

    iget-wide v2, p0, Landroid/widget/SlidingDrawer;->mCurrentAnimationTime:J

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->sendMessageAtTime(Landroid/os/Message;J)Z

    goto :goto_21
.end method

.method private incrementAnimation()V
    .registers 9

    .prologue
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v1

    .local v1, now:J
    iget-wide v6, p0, Landroid/widget/SlidingDrawer;->mAnimationLastTime:J

    sub-long v6, v1, v6

    long-to-float v6, v6

    const/high16 v7, 0x447a

    div-float v4, v6, v7

    .local v4, t:F
    iget v3, p0, Landroid/widget/SlidingDrawer;->mAnimationPosition:F

    .local v3, position:F
    iget v5, p0, Landroid/widget/SlidingDrawer;->mAnimatedVelocity:F

    .local v5, v:F
    iget v0, p0, Landroid/widget/SlidingDrawer;->mAnimatedAcceleration:F

    .local v0, a:F
    mul-float v6, v5, v4

    add-float/2addr v6, v3

    const/high16 v7, 0x3f00

    mul-float/2addr v7, v0

    mul-float/2addr v7, v4

    mul-float/2addr v7, v4

    add-float/2addr v6, v7

    iput v6, p0, Landroid/widget/SlidingDrawer;->mAnimationPosition:F

    mul-float v6, v0, v4

    add-float/2addr v6, v5

    iput v6, p0, Landroid/widget/SlidingDrawer;->mAnimatedVelocity:F

    iput-wide v1, p0, Landroid/widget/SlidingDrawer;->mAnimationLastTime:J

    return-void
.end method

.method private moveHandle(I)V
    .registers 14
    .parameter "position"

    .prologue
    const/4 v11, 0x0

    const/16 v9, -0x2711

    const/16 v8, -0x2712

    iget-object v3, p0, Landroid/widget/SlidingDrawer;->mHandle:Landroid/view/View;

    .local v3, handle:Landroid/view/View;
    iget-boolean v7, p0, Landroid/widget/SlidingDrawer;->mVertical:Z

    if-eqz v7, :cond_90

    if-ne p1, v9, :cond_1b

    iget v7, p0, Landroid/widget/SlidingDrawer;->mTopOffset:I

    invoke-virtual {v3}, Landroid/view/View;->getTop()I

    move-result v8

    sub-int/2addr v7, v8

    invoke-virtual {v3, v7}, Landroid/view/View;->offsetTopAndBottom(I)V

    invoke-virtual {p0}, Landroid/widget/SlidingDrawer;->invalidate()V

    :goto_1a
    return-void

    :cond_1b
    if-ne p1, v8, :cond_34

    iget v7, p0, Landroid/widget/SlidingDrawer;->mBottomOffset:I

    iget v8, p0, Landroid/view/View;->mBottom:I

    add-int/2addr v7, v8

    iget v8, p0, Landroid/view/View;->mTop:I

    sub-int/2addr v7, v8

    iget v8, p0, Landroid/widget/SlidingDrawer;->mHandleHeight:I

    sub-int/2addr v7, v8

    invoke-virtual {v3}, Landroid/view/View;->getTop()I

    move-result v8

    sub-int/2addr v7, v8

    invoke-virtual {v3, v7}, Landroid/view/View;->offsetTopAndBottom(I)V

    invoke-virtual {p0}, Landroid/widget/SlidingDrawer;->invalidate()V

    goto :goto_1a

    :cond_34
    invoke-virtual {v3}, Landroid/view/View;->getTop()I

    move-result v6

    .local v6, top:I
    sub-int v1, p1, v6

    .local v1, deltaY:I
    iget v7, p0, Landroid/widget/SlidingDrawer;->mTopOffset:I

    if-ge p1, v7, :cond_74

    iget v7, p0, Landroid/widget/SlidingDrawer;->mTopOffset:I

    sub-int v1, v7, v6

    :cond_42
    :goto_42
    invoke-virtual {v3, v1}, Landroid/view/View;->offsetTopAndBottom(I)V

    iget-object v2, p0, Landroid/widget/SlidingDrawer;->mFrame:Landroid/graphics/Rect;

    .local v2, frame:Landroid/graphics/Rect;
    iget-object v5, p0, Landroid/widget/SlidingDrawer;->mInvalidate:Landroid/graphics/Rect;

    .local v5, region:Landroid/graphics/Rect;
    invoke-virtual {v3, v2}, Landroid/view/View;->getHitRect(Landroid/graphics/Rect;)V

    invoke-virtual {v5, v2}, Landroid/graphics/Rect;->set(Landroid/graphics/Rect;)V

    iget v7, v2, Landroid/graphics/Rect;->left:I

    iget v8, v2, Landroid/graphics/Rect;->top:I

    sub-int/2addr v8, v1

    iget v9, v2, Landroid/graphics/Rect;->right:I

    iget v10, v2, Landroid/graphics/Rect;->bottom:I

    sub-int/2addr v10, v1

    invoke-virtual {v5, v7, v8, v9, v10}, Landroid/graphics/Rect;->union(IIII)V

    iget v7, v2, Landroid/graphics/Rect;->bottom:I

    sub-int/2addr v7, v1

    invoke-virtual {p0}, Landroid/widget/SlidingDrawer;->getWidth()I

    move-result v8

    iget v9, v2, Landroid/graphics/Rect;->bottom:I

    sub-int/2addr v9, v1

    iget-object v10, p0, Landroid/widget/SlidingDrawer;->mContent:Landroid/view/View;

    invoke-virtual {v10}, Landroid/view/View;->getHeight()I

    move-result v10

    add-int/2addr v9, v10

    invoke-virtual {v5, v11, v7, v8, v9}, Landroid/graphics/Rect;->union(IIII)V

    invoke-virtual {p0, v5}, Landroid/widget/SlidingDrawer;->invalidate(Landroid/graphics/Rect;)V

    goto :goto_1a

    .end local v2           #frame:Landroid/graphics/Rect;
    .end local v5           #region:Landroid/graphics/Rect;
    :cond_74
    iget v7, p0, Landroid/widget/SlidingDrawer;->mBottomOffset:I

    iget v8, p0, Landroid/view/View;->mBottom:I

    add-int/2addr v7, v8

    iget v8, p0, Landroid/view/View;->mTop:I

    sub-int/2addr v7, v8

    iget v8, p0, Landroid/widget/SlidingDrawer;->mHandleHeight:I

    sub-int/2addr v7, v8

    sub-int/2addr v7, v6

    if-le v1, v7, :cond_42

    iget v7, p0, Landroid/widget/SlidingDrawer;->mBottomOffset:I

    iget v8, p0, Landroid/view/View;->mBottom:I

    add-int/2addr v7, v8

    iget v8, p0, Landroid/view/View;->mTop:I

    sub-int/2addr v7, v8

    iget v8, p0, Landroid/widget/SlidingDrawer;->mHandleHeight:I

    sub-int/2addr v7, v8

    sub-int v1, v7, v6

    goto :goto_42

    .end local v1           #deltaY:I
    .end local v6           #top:I
    :cond_90
    if-ne p1, v9, :cond_a1

    iget v7, p0, Landroid/widget/SlidingDrawer;->mTopOffset:I

    invoke-virtual {v3}, Landroid/view/View;->getLeft()I

    move-result v8

    sub-int/2addr v7, v8

    invoke-virtual {v3, v7}, Landroid/view/View;->offsetLeftAndRight(I)V

    invoke-virtual {p0}, Landroid/widget/SlidingDrawer;->invalidate()V

    goto/16 :goto_1a

    :cond_a1
    if-ne p1, v8, :cond_bb

    iget v7, p0, Landroid/widget/SlidingDrawer;->mBottomOffset:I

    iget v8, p0, Landroid/view/View;->mRight:I

    add-int/2addr v7, v8

    iget v8, p0, Landroid/view/View;->mLeft:I

    sub-int/2addr v7, v8

    iget v8, p0, Landroid/widget/SlidingDrawer;->mHandleWidth:I

    sub-int/2addr v7, v8

    invoke-virtual {v3}, Landroid/view/View;->getLeft()I

    move-result v8

    sub-int/2addr v7, v8

    invoke-virtual {v3, v7}, Landroid/view/View;->offsetLeftAndRight(I)V

    invoke-virtual {p0}, Landroid/widget/SlidingDrawer;->invalidate()V

    goto/16 :goto_1a

    :cond_bb
    invoke-virtual {v3}, Landroid/view/View;->getLeft()I

    move-result v4

    .local v4, left:I
    sub-int v0, p1, v4

    .local v0, deltaX:I
    iget v7, p0, Landroid/widget/SlidingDrawer;->mTopOffset:I

    if-ge p1, v7, :cond_fc

    iget v7, p0, Landroid/widget/SlidingDrawer;->mTopOffset:I

    sub-int v0, v7, v4

    :cond_c9
    :goto_c9
    invoke-virtual {v3, v0}, Landroid/view/View;->offsetLeftAndRight(I)V

    iget-object v2, p0, Landroid/widget/SlidingDrawer;->mFrame:Landroid/graphics/Rect;

    .restart local v2       #frame:Landroid/graphics/Rect;
    iget-object v5, p0, Landroid/widget/SlidingDrawer;->mInvalidate:Landroid/graphics/Rect;

    .restart local v5       #region:Landroid/graphics/Rect;
    invoke-virtual {v3, v2}, Landroid/view/View;->getHitRect(Landroid/graphics/Rect;)V

    invoke-virtual {v5, v2}, Landroid/graphics/Rect;->set(Landroid/graphics/Rect;)V

    iget v7, v2, Landroid/graphics/Rect;->left:I

    sub-int/2addr v7, v0

    iget v8, v2, Landroid/graphics/Rect;->top:I

    iget v9, v2, Landroid/graphics/Rect;->right:I

    sub-int/2addr v9, v0

    iget v10, v2, Landroid/graphics/Rect;->bottom:I

    invoke-virtual {v5, v7, v8, v9, v10}, Landroid/graphics/Rect;->union(IIII)V

    iget v7, v2, Landroid/graphics/Rect;->right:I

    sub-int/2addr v7, v0

    iget v8, v2, Landroid/graphics/Rect;->right:I

    sub-int/2addr v8, v0

    iget-object v9, p0, Landroid/widget/SlidingDrawer;->mContent:Landroid/view/View;

    invoke-virtual {v9}, Landroid/view/View;->getWidth()I

    move-result v9

    add-int/2addr v8, v9

    invoke-virtual {p0}, Landroid/widget/SlidingDrawer;->getHeight()I

    move-result v9

    invoke-virtual {v5, v7, v11, v8, v9}, Landroid/graphics/Rect;->union(IIII)V

    invoke-virtual {p0, v5}, Landroid/widget/SlidingDrawer;->invalidate(Landroid/graphics/Rect;)V

    goto/16 :goto_1a

    .end local v2           #frame:Landroid/graphics/Rect;
    .end local v5           #region:Landroid/graphics/Rect;
    :cond_fc
    iget v7, p0, Landroid/widget/SlidingDrawer;->mBottomOffset:I

    iget v8, p0, Landroid/view/View;->mRight:I

    add-int/2addr v7, v8

    iget v8, p0, Landroid/view/View;->mLeft:I

    sub-int/2addr v7, v8

    iget v8, p0, Landroid/widget/SlidingDrawer;->mHandleWidth:I

    sub-int/2addr v7, v8

    sub-int/2addr v7, v4

    if-le v0, v7, :cond_c9

    iget v7, p0, Landroid/widget/SlidingDrawer;->mBottomOffset:I

    iget v8, p0, Landroid/view/View;->mRight:I

    add-int/2addr v7, v8

    iget v8, p0, Landroid/view/View;->mLeft:I

    sub-int/2addr v7, v8

    iget v8, p0, Landroid/widget/SlidingDrawer;->mHandleWidth:I

    sub-int/2addr v7, v8

    sub-int v0, v7, v4

    goto :goto_c9
.end method

.method private openDrawer()V
    .registers 3

    .prologue
    const/16 v0, -0x2711

    invoke-direct {p0, v0}, Landroid/widget/SlidingDrawer;->moveHandle(I)V

    iget-object v0, p0, Landroid/widget/SlidingDrawer;->mContent:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    iget-boolean v0, p0, Landroid/widget/SlidingDrawer;->mExpanded:Z

    if-eqz v0, :cond_10

    :cond_f
    :goto_f
    return-void

    :cond_10
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/widget/SlidingDrawer;->mExpanded:Z

    iget-object v0, p0, Landroid/widget/SlidingDrawer;->mOnDrawerOpenListener:Landroid/widget/SlidingDrawer$OnDrawerOpenListener;

    if-eqz v0, :cond_f

    iget-object v0, p0, Landroid/widget/SlidingDrawer;->mOnDrawerOpenListener:Landroid/widget/SlidingDrawer$OnDrawerOpenListener;

    invoke-interface {v0}, Landroid/widget/SlidingDrawer$OnDrawerOpenListener;->onDrawerOpened()V

    goto :goto_f
.end method

.method private performFling(IFZ)V
    .registers 10
    .parameter "position"
    .parameter "velocity"
    .parameter "always"

    .prologue
    const/16 v5, 0x3e8

    const/4 v4, 0x0

    int-to-float v2, p1

    iput v2, p0, Landroid/widget/SlidingDrawer;->mAnimationPosition:F

    iput p2, p0, Landroid/widget/SlidingDrawer;->mAnimatedVelocity:F

    iget-boolean v2, p0, Landroid/widget/SlidingDrawer;->mExpanded:Z

    if-eqz v2, :cond_67

    if-nez p3, :cond_28

    iget v2, p0, Landroid/widget/SlidingDrawer;->mMaximumMajorVelocity:I

    int-to-float v2, v2

    cmpl-float v2, p2, v2

    if-gtz v2, :cond_28

    iget v3, p0, Landroid/widget/SlidingDrawer;->mTopOffset:I

    iget-boolean v2, p0, Landroid/widget/SlidingDrawer;->mVertical:Z

    if-eqz v2, :cond_57

    iget v2, p0, Landroid/widget/SlidingDrawer;->mHandleHeight:I

    :goto_1d
    add-int/2addr v2, v3

    if-le p1, v2, :cond_5a

    iget v2, p0, Landroid/widget/SlidingDrawer;->mMaximumMajorVelocity:I

    neg-int v2, v2

    int-to-float v2, v2

    cmpl-float v2, p2, v2

    if-lez v2, :cond_5a

    :cond_28
    iget v2, p0, Landroid/widget/SlidingDrawer;->mMaximumAcceleration:I

    int-to-float v2, v2

    iput v2, p0, Landroid/widget/SlidingDrawer;->mAnimatedAcceleration:F

    cmpg-float v2, p2, v4

    if-gez v2, :cond_33

    iput v4, p0, Landroid/widget/SlidingDrawer;->mAnimatedVelocity:F

    :cond_33
    :goto_33
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    .local v0, now:J
    iput-wide v0, p0, Landroid/widget/SlidingDrawer;->mAnimationLastTime:J

    const-wide/16 v2, 0x10

    add-long/2addr v2, v0

    iput-wide v2, p0, Landroid/widget/SlidingDrawer;->mCurrentAnimationTime:J

    const/4 v2, 0x1

    iput-boolean v2, p0, Landroid/widget/SlidingDrawer;->mAnimating:Z

    iget-object v2, p0, Landroid/widget/SlidingDrawer;->mHandler:Landroid/os/Handler;

    invoke-virtual {v2, v5}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v2, p0, Landroid/widget/SlidingDrawer;->mHandler:Landroid/os/Handler;

    iget-object v3, p0, Landroid/widget/SlidingDrawer;->mHandler:Landroid/os/Handler;

    invoke-virtual {v3, v5}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v3

    iget-wide v4, p0, Landroid/widget/SlidingDrawer;->mCurrentAnimationTime:J

    invoke-virtual {v2, v3, v4, v5}, Landroid/os/Handler;->sendMessageAtTime(Landroid/os/Message;J)Z

    invoke-direct {p0}, Landroid/widget/SlidingDrawer;->stopTracking()V

    return-void

    .end local v0           #now:J
    :cond_57
    iget v2, p0, Landroid/widget/SlidingDrawer;->mHandleWidth:I

    goto :goto_1d

    :cond_5a
    iget v2, p0, Landroid/widget/SlidingDrawer;->mMaximumAcceleration:I

    neg-int v2, v2

    int-to-float v2, v2

    iput v2, p0, Landroid/widget/SlidingDrawer;->mAnimatedAcceleration:F

    cmpl-float v2, p2, v4

    if-lez v2, :cond_33

    iput v4, p0, Landroid/widget/SlidingDrawer;->mAnimatedVelocity:F

    goto :goto_33

    :cond_67
    if-nez p3, :cond_95

    iget v2, p0, Landroid/widget/SlidingDrawer;->mMaximumMajorVelocity:I

    int-to-float v2, v2

    cmpl-float v2, p2, v2

    if-gtz v2, :cond_84

    iget-boolean v2, p0, Landroid/widget/SlidingDrawer;->mVertical:Z

    if-eqz v2, :cond_90

    invoke-virtual {p0}, Landroid/widget/SlidingDrawer;->getHeight()I

    move-result v2

    :goto_78
    div-int/lit8 v2, v2, 0x2

    if-le p1, v2, :cond_95

    iget v2, p0, Landroid/widget/SlidingDrawer;->mMaximumMajorVelocity:I

    neg-int v2, v2

    int-to-float v2, v2

    cmpl-float v2, p2, v2

    if-lez v2, :cond_95

    :cond_84
    iget v2, p0, Landroid/widget/SlidingDrawer;->mMaximumAcceleration:I

    int-to-float v2, v2

    iput v2, p0, Landroid/widget/SlidingDrawer;->mAnimatedAcceleration:F

    cmpg-float v2, p2, v4

    if-gez v2, :cond_33

    iput v4, p0, Landroid/widget/SlidingDrawer;->mAnimatedVelocity:F

    goto :goto_33

    :cond_90
    invoke-virtual {p0}, Landroid/widget/SlidingDrawer;->getWidth()I

    move-result v2

    goto :goto_78

    :cond_95
    iget v2, p0, Landroid/widget/SlidingDrawer;->mMaximumAcceleration:I

    neg-int v2, v2

    int-to-float v2, v2

    iput v2, p0, Landroid/widget/SlidingDrawer;->mAnimatedAcceleration:F

    cmpl-float v2, p2, v4

    if-lez v2, :cond_33

    iput v4, p0, Landroid/widget/SlidingDrawer;->mAnimatedVelocity:F

    goto :goto_33
.end method

.method private prepareContent()V
    .registers 11

    .prologue
    const/4 v9, 0x0

    const/high16 v8, 0x4000

    iget-boolean v5, p0, Landroid/widget/SlidingDrawer;->mAnimating:Z

    if-eqz v5, :cond_8

    :goto_7
    return-void

    :cond_8
    iget-object v2, p0, Landroid/widget/SlidingDrawer;->mContent:Landroid/view/View;

    .local v2, content:Landroid/view/View;
    invoke-virtual {v2}, Landroid/view/View;->isLayoutRequested()Z

    move-result v5

    if-eqz v5, :cond_42

    iget-boolean v5, p0, Landroid/widget/SlidingDrawer;->mVertical:Z

    if-eqz v5, :cond_58

    iget v0, p0, Landroid/widget/SlidingDrawer;->mHandleHeight:I

    .local v0, childHeight:I
    iget v5, p0, Landroid/view/View;->mBottom:I

    iget v6, p0, Landroid/view/View;->mTop:I

    sub-int/2addr v5, v6

    sub-int/2addr v5, v0

    iget v6, p0, Landroid/widget/SlidingDrawer;->mTopOffset:I

    sub-int v3, v5, v6

    .local v3, height:I
    iget v5, p0, Landroid/view/View;->mRight:I

    iget v6, p0, Landroid/view/View;->mLeft:I

    sub-int/2addr v5, v6

    invoke-static {v5, v8}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v5

    invoke-static {v3, v8}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v6

    invoke-virtual {v2, v5, v6}, Landroid/view/View;->measure(II)V

    iget v5, p0, Landroid/widget/SlidingDrawer;->mTopOffset:I

    add-int/2addr v5, v0

    invoke-virtual {v2}, Landroid/view/View;->getMeasuredWidth()I

    move-result v6

    iget v7, p0, Landroid/widget/SlidingDrawer;->mTopOffset:I

    add-int/2addr v7, v0

    invoke-virtual {v2}, Landroid/view/View;->getMeasuredHeight()I

    move-result v8

    add-int/2addr v7, v8

    invoke-virtual {v2, v9, v5, v6, v7}, Landroid/view/View;->layout(IIII)V

    .end local v0           #childHeight:I
    .end local v3           #height:I
    :cond_42
    :goto_42
    invoke-virtual {v2}, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v5

    invoke-virtual {v5}, Landroid/view/ViewTreeObserver;->dispatchOnPreDraw()Z

    invoke-virtual {v2}, Landroid/view/View;->isHardwareAccelerated()Z

    move-result v5

    if-nez v5, :cond_52

    invoke-virtual {v2}, Landroid/view/View;->buildDrawingCache()V

    :cond_52
    const/16 v5, 0x8

    invoke-virtual {v2, v5}, Landroid/view/View;->setVisibility(I)V

    goto :goto_7

    :cond_58
    iget-object v5, p0, Landroid/widget/SlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v5}, Landroid/view/View;->getWidth()I

    move-result v1

    .local v1, childWidth:I
    iget v5, p0, Landroid/view/View;->mRight:I

    iget v6, p0, Landroid/view/View;->mLeft:I

    sub-int/2addr v5, v6

    sub-int/2addr v5, v1

    iget v6, p0, Landroid/widget/SlidingDrawer;->mTopOffset:I

    sub-int v4, v5, v6

    .local v4, width:I
    invoke-static {v4, v8}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v5

    iget v6, p0, Landroid/view/View;->mBottom:I

    iget v7, p0, Landroid/view/View;->mTop:I

    sub-int/2addr v6, v7

    invoke-static {v6, v8}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v6

    invoke-virtual {v2, v5, v6}, Landroid/view/View;->measure(II)V

    iget v5, p0, Landroid/widget/SlidingDrawer;->mTopOffset:I

    add-int/2addr v5, v1

    iget v6, p0, Landroid/widget/SlidingDrawer;->mTopOffset:I

    add-int/2addr v6, v1

    invoke-virtual {v2}, Landroid/view/View;->getMeasuredWidth()I

    move-result v7

    add-int/2addr v6, v7

    invoke-virtual {v2}, Landroid/view/View;->getMeasuredHeight()I

    move-result v7

    invoke-virtual {v2, v5, v9, v6, v7}, Landroid/view/View;->layout(IIII)V

    goto :goto_42
.end method

.method private prepareTracking(I)V
    .registers 10
    .parameter "position"

    .prologue
    const/16 v7, 0x3e8

    const/4 v3, 0x0

    const/4 v4, 0x1

    iput-boolean v4, p0, Landroid/widget/SlidingDrawer;->mTracking:Z

    invoke-static {}, Landroid/view/VelocityTracker;->obtain()Landroid/view/VelocityTracker;

    move-result-object v5

    iput-object v5, p0, Landroid/widget/SlidingDrawer;->mVelocityTracker:Landroid/view/VelocityTracker;

    iget-boolean v5, p0, Landroid/widget/SlidingDrawer;->mExpanded:Z

    if-nez v5, :cond_49

    move v2, v4

    .local v2, opening:Z
    :goto_11
    if-eqz v2, :cond_53

    iget v3, p0, Landroid/widget/SlidingDrawer;->mMaximumAcceleration:I

    int-to-float v3, v3

    iput v3, p0, Landroid/widget/SlidingDrawer;->mAnimatedAcceleration:F

    iget v3, p0, Landroid/widget/SlidingDrawer;->mMaximumMajorVelocity:I

    int-to-float v3, v3

    iput v3, p0, Landroid/widget/SlidingDrawer;->mAnimatedVelocity:F

    iget v5, p0, Landroid/widget/SlidingDrawer;->mBottomOffset:I

    iget-boolean v3, p0, Landroid/widget/SlidingDrawer;->mVertical:Z

    if-eqz v3, :cond_4b

    invoke-virtual {p0}, Landroid/widget/SlidingDrawer;->getHeight()I

    move-result v3

    iget v6, p0, Landroid/widget/SlidingDrawer;->mHandleHeight:I

    sub-int/2addr v3, v6

    :goto_2a
    add-int/2addr v3, v5

    int-to-float v3, v3

    iput v3, p0, Landroid/widget/SlidingDrawer;->mAnimationPosition:F

    iget v3, p0, Landroid/widget/SlidingDrawer;->mAnimationPosition:F

    float-to-int v3, v3

    invoke-direct {p0, v3}, Landroid/widget/SlidingDrawer;->moveHandle(I)V

    iput-boolean v4, p0, Landroid/widget/SlidingDrawer;->mAnimating:Z

    iget-object v3, p0, Landroid/widget/SlidingDrawer;->mHandler:Landroid/os/Handler;

    invoke-virtual {v3, v7}, Landroid/os/Handler;->removeMessages(I)V

    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    .local v0, now:J
    iput-wide v0, p0, Landroid/widget/SlidingDrawer;->mAnimationLastTime:J

    const-wide/16 v5, 0x10

    add-long/2addr v5, v0

    iput-wide v5, p0, Landroid/widget/SlidingDrawer;->mCurrentAnimationTime:J

    iput-boolean v4, p0, Landroid/widget/SlidingDrawer;->mAnimating:Z

    .end local v0           #now:J
    :goto_48
    return-void

    .end local v2           #opening:Z
    :cond_49
    move v2, v3

    goto :goto_11

    .restart local v2       #opening:Z
    :cond_4b
    invoke-virtual {p0}, Landroid/widget/SlidingDrawer;->getWidth()I

    move-result v3

    iget v6, p0, Landroid/widget/SlidingDrawer;->mHandleWidth:I

    sub-int/2addr v3, v6

    goto :goto_2a

    :cond_53
    iget-boolean v4, p0, Landroid/widget/SlidingDrawer;->mAnimating:Z

    if-eqz v4, :cond_5e

    iput-boolean v3, p0, Landroid/widget/SlidingDrawer;->mAnimating:Z

    iget-object v3, p0, Landroid/widget/SlidingDrawer;->mHandler:Landroid/os/Handler;

    invoke-virtual {v3, v7}, Landroid/os/Handler;->removeMessages(I)V

    :cond_5e
    invoke-direct {p0, p1}, Landroid/widget/SlidingDrawer;->moveHandle(I)V

    goto :goto_48
.end method

.method private stopTracking()V
    .registers 3

    .prologue
    const/4 v1, 0x0

    iget-object v0, p0, Landroid/widget/SlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setPressed(Z)V

    iput-boolean v1, p0, Landroid/widget/SlidingDrawer;->mTracking:Z

    iget-object v0, p0, Landroid/widget/SlidingDrawer;->mOnDrawerScrollListener:Landroid/widget/SlidingDrawer$OnDrawerScrollListener;

    if-eqz v0, :cond_11

    iget-object v0, p0, Landroid/widget/SlidingDrawer;->mOnDrawerScrollListener:Landroid/widget/SlidingDrawer$OnDrawerScrollListener;

    invoke-interface {v0}, Landroid/widget/SlidingDrawer$OnDrawerScrollListener;->onScrollEnded()V

    :cond_11
    iget-object v0, p0, Landroid/widget/SlidingDrawer;->mVelocityTracker:Landroid/view/VelocityTracker;

    if-eqz v0, :cond_1d

    iget-object v0, p0, Landroid/widget/SlidingDrawer;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v0}, Landroid/view/VelocityTracker;->recycle()V

    const/4 v0, 0x0

    iput-object v0, p0, Landroid/widget/SlidingDrawer;->mVelocityTracker:Landroid/view/VelocityTracker;

    :cond_1d
    return-void
.end method


# virtual methods
.method public animateClose()V
    .registers 3

    .prologue
    invoke-direct {p0}, Landroid/widget/SlidingDrawer;->prepareContent()V

    iget-object v0, p0, Landroid/widget/SlidingDrawer;->mOnDrawerScrollListener:Landroid/widget/SlidingDrawer$OnDrawerScrollListener;

    .local v0, scrollListener:Landroid/widget/SlidingDrawer$OnDrawerScrollListener;
    if-eqz v0, :cond_a

    invoke-interface {v0}, Landroid/widget/SlidingDrawer$OnDrawerScrollListener;->onScrollStarted()V

    :cond_a
    iget-boolean v1, p0, Landroid/widget/SlidingDrawer;->mVertical:Z

    if-eqz v1, :cond_1d

    iget-object v1, p0, Landroid/widget/SlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getTop()I

    move-result v1

    :goto_14
    invoke-direct {p0, v1}, Landroid/widget/SlidingDrawer;->animateClose(I)V

    if-eqz v0, :cond_1c

    invoke-interface {v0}, Landroid/widget/SlidingDrawer$OnDrawerScrollListener;->onScrollEnded()V

    :cond_1c
    return-void

    :cond_1d
    iget-object v1, p0, Landroid/widget/SlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getLeft()I

    move-result v1

    goto :goto_14
.end method

.method public animateOpen()V
    .registers 3

    .prologue
    invoke-direct {p0}, Landroid/widget/SlidingDrawer;->prepareContent()V

    iget-object v0, p0, Landroid/widget/SlidingDrawer;->mOnDrawerScrollListener:Landroid/widget/SlidingDrawer$OnDrawerScrollListener;

    .local v0, scrollListener:Landroid/widget/SlidingDrawer$OnDrawerScrollListener;
    if-eqz v0, :cond_a

    invoke-interface {v0}, Landroid/widget/SlidingDrawer$OnDrawerScrollListener;->onScrollStarted()V

    :cond_a
    iget-boolean v1, p0, Landroid/widget/SlidingDrawer;->mVertical:Z

    if-eqz v1, :cond_22

    iget-object v1, p0, Landroid/widget/SlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getTop()I

    move-result v1

    :goto_14
    invoke-direct {p0, v1}, Landroid/widget/SlidingDrawer;->animateOpen(I)V

    const/16 v1, 0x20

    invoke-virtual {p0, v1}, Landroid/widget/SlidingDrawer;->sendAccessibilityEvent(I)V

    if-eqz v0, :cond_21

    invoke-interface {v0}, Landroid/widget/SlidingDrawer$OnDrawerScrollListener;->onScrollEnded()V

    :cond_21
    return-void

    :cond_22
    iget-object v1, p0, Landroid/widget/SlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getLeft()I

    move-result v1

    goto :goto_14
.end method

.method public animateToggle()V
    .registers 2

    .prologue
    iget-boolean v0, p0, Landroid/widget/SlidingDrawer;->mExpanded:Z

    if-nez v0, :cond_8

    invoke-virtual {p0}, Landroid/widget/SlidingDrawer;->animateOpen()V

    :goto_7
    return-void

    :cond_8
    invoke-virtual {p0}, Landroid/widget/SlidingDrawer;->animateClose()V

    goto :goto_7
.end method

.method public close()V
    .registers 1

    .prologue
    invoke-direct {p0}, Landroid/widget/SlidingDrawer;->closeDrawer()V

    invoke-virtual {p0}, Landroid/widget/SlidingDrawer;->invalidate()V

    invoke-virtual {p0}, Landroid/widget/SlidingDrawer;->requestLayout()V

    return-void
.end method

.method protected dispatchDraw(Landroid/graphics/Canvas;)V
    .registers 10
    .parameter "canvas"

    .prologue
    const/4 v7, 0x0

    const/4 v5, 0x0

    invoke-virtual {p0}, Landroid/widget/SlidingDrawer;->getDrawingTime()J

    move-result-wide v1

    .local v1, drawingTime:J
    iget-object v3, p0, Landroid/widget/SlidingDrawer;->mHandle:Landroid/view/View;

    .local v3, handle:Landroid/view/View;
    iget-boolean v4, p0, Landroid/widget/SlidingDrawer;->mVertical:Z

    .local v4, isVertical:Z
    invoke-virtual {p0, p1, v3, v1, v2}, Landroid/widget/SlidingDrawer;->drawChild(Landroid/graphics/Canvas;Landroid/view/View;J)Z

    iget-boolean v6, p0, Landroid/widget/SlidingDrawer;->mTracking:Z

    if-nez v6, :cond_15

    iget-boolean v6, p0, Landroid/widget/SlidingDrawer;->mAnimating:Z

    if-eqz v6, :cond_56

    :cond_15
    iget-object v6, p0, Landroid/widget/SlidingDrawer;->mContent:Landroid/view/View;

    invoke-virtual {v6}, Landroid/view/View;->getDrawingCache()Landroid/graphics/Bitmap;

    move-result-object v0

    .local v0, cache:Landroid/graphics/Bitmap;
    if-eqz v0, :cond_31

    if-eqz v4, :cond_28

    invoke-virtual {v3}, Landroid/view/View;->getBottom()I

    move-result v6

    int-to-float v6, v6

    invoke-virtual {p1, v0, v5, v6, v7}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .end local v0           #cache:Landroid/graphics/Bitmap;
    :cond_27
    :goto_27
    return-void

    .restart local v0       #cache:Landroid/graphics/Bitmap;
    :cond_28
    invoke-virtual {v3}, Landroid/view/View;->getRight()I

    move-result v6

    int-to-float v6, v6

    invoke-virtual {p1, v0, v6, v5, v7}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    goto :goto_27

    :cond_31
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    if-eqz v4, :cond_4d

    move v6, v5

    :goto_37
    if-eqz v4, :cond_41

    invoke-virtual {v3}, Landroid/view/View;->getTop()I

    move-result v5

    iget v7, p0, Landroid/widget/SlidingDrawer;->mTopOffset:I

    sub-int/2addr v5, v7

    int-to-float v5, v5

    :cond_41
    invoke-virtual {p1, v6, v5}, Landroid/graphics/Canvas;->translate(FF)V

    iget-object v5, p0, Landroid/widget/SlidingDrawer;->mContent:Landroid/view/View;

    invoke-virtual {p0, p1, v5, v1, v2}, Landroid/widget/SlidingDrawer;->drawChild(Landroid/graphics/Canvas;Landroid/view/View;J)Z

    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    goto :goto_27

    :cond_4d
    invoke-virtual {v3}, Landroid/view/View;->getLeft()I

    move-result v6

    iget v7, p0, Landroid/widget/SlidingDrawer;->mTopOffset:I

    sub-int/2addr v6, v7

    int-to-float v6, v6

    goto :goto_37

    .end local v0           #cache:Landroid/graphics/Bitmap;
    :cond_56
    iget-boolean v5, p0, Landroid/widget/SlidingDrawer;->mExpanded:Z

    if-eqz v5, :cond_27

    iget-object v5, p0, Landroid/widget/SlidingDrawer;->mContent:Landroid/view/View;

    invoke-virtual {p0, p1, v5, v1, v2}, Landroid/widget/SlidingDrawer;->drawChild(Landroid/graphics/Canvas;Landroid/view/View;J)Z

    goto :goto_27
.end method

.method public getContent()Landroid/view/View;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/widget/SlidingDrawer;->mContent:Landroid/view/View;

    return-object v0
.end method

.method public getHandle()Landroid/view/View;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/widget/SlidingDrawer;->mHandle:Landroid/view/View;

    return-object v0
.end method

.method public isMoving()Z
    .registers 2

    .prologue
    iget-boolean v0, p0, Landroid/widget/SlidingDrawer;->mTracking:Z

    if-nez v0, :cond_8

    iget-boolean v0, p0, Landroid/widget/SlidingDrawer;->mAnimating:Z

    if-eqz v0, :cond_a

    :cond_8
    const/4 v0, 0x1

    :goto_9
    return v0

    :cond_a
    const/4 v0, 0x0

    goto :goto_9
.end method

.method public isOpened()Z
    .registers 2

    .prologue
    iget-boolean v0, p0, Landroid/widget/SlidingDrawer;->mExpanded:Z

    return v0
.end method

.method public lock()V
    .registers 2

    .prologue
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/widget/SlidingDrawer;->mLocked:Z

    return-void
.end method

.method protected onFinishInflate()V
    .registers 4

    .prologue
    iget v0, p0, Landroid/widget/SlidingDrawer;->mHandleId:I

    invoke-virtual {p0, v0}, Landroid/widget/SlidingDrawer;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Landroid/widget/SlidingDrawer;->mHandle:Landroid/view/View;

    iget-object v0, p0, Landroid/widget/SlidingDrawer;->mHandle:Landroid/view/View;

    if-nez v0, :cond_14

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "The handle attribute is must refer to an existing child."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_14
    iget-object v0, p0, Landroid/widget/SlidingDrawer;->mHandle:Landroid/view/View;

    new-instance v1, Landroid/widget/SlidingDrawer$DrawerToggler;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Landroid/widget/SlidingDrawer$DrawerToggler;-><init>(Landroid/widget/SlidingDrawer;Landroid/widget/SlidingDrawer$1;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    iget v0, p0, Landroid/widget/SlidingDrawer;->mContentId:I

    invoke-virtual {p0, v0}, Landroid/widget/SlidingDrawer;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Landroid/widget/SlidingDrawer;->mContent:Landroid/view/View;

    iget-object v0, p0, Landroid/widget/SlidingDrawer;->mContent:Landroid/view/View;

    if-nez v0, :cond_33

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "The content attribute is must refer to an existing child."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_33
    iget-object v0, p0, Landroid/widget/SlidingDrawer;->mContent:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    return-void
.end method

.method public onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V
    .registers 3
    .parameter "event"

    .prologue
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V

    const-class v0, Landroid/widget/SlidingDrawer;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityEvent;->setClassName(Ljava/lang/CharSequence;)V

    return-void
.end method

.method public onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V
    .registers 3
    .parameter "info"

    .prologue
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V

    const-class v0, Landroid/widget/SlidingDrawer;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->setClassName(Ljava/lang/CharSequence;)V

    return-void
.end method

.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .registers 13
    .parameter "event"

    .prologue
    const/4 v7, 0x0

    const/4 v8, 0x1

    iget-boolean v9, p0, Landroid/widget/SlidingDrawer;->mLocked:Z

    if-eqz v9, :cond_7

    :cond_6
    :goto_6
    return v7

    :cond_7
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    .local v0, action:I
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v5

    .local v5, x:F
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v6

    .local v6, y:F
    iget-object v1, p0, Landroid/widget/SlidingDrawer;->mFrame:Landroid/graphics/Rect;

    .local v1, frame:Landroid/graphics/Rect;
    iget-object v2, p0, Landroid/widget/SlidingDrawer;->mHandle:Landroid/view/View;

    .local v2, handle:Landroid/view/View;
    invoke-virtual {v2, v1}, Landroid/view/View;->getHitRect(Landroid/graphics/Rect;)V

    iget-boolean v9, p0, Landroid/widget/SlidingDrawer;->mTracking:Z

    if-nez v9, :cond_26

    float-to-int v9, v5

    float-to-int v10, v6

    invoke-virtual {v1, v9, v10}, Landroid/graphics/Rect;->contains(II)Z

    move-result v9

    if-eqz v9, :cond_6

    :cond_26
    if-nez v0, :cond_4f

    iput-boolean v8, p0, Landroid/widget/SlidingDrawer;->mTracking:Z

    invoke-virtual {v2, v8}, Landroid/view/View;->setPressed(Z)V

    invoke-direct {p0}, Landroid/widget/SlidingDrawer;->prepareContent()V

    iget-object v7, p0, Landroid/widget/SlidingDrawer;->mOnDrawerScrollListener:Landroid/widget/SlidingDrawer$OnDrawerScrollListener;

    if-eqz v7, :cond_39

    iget-object v7, p0, Landroid/widget/SlidingDrawer;->mOnDrawerScrollListener:Landroid/widget/SlidingDrawer$OnDrawerScrollListener;

    invoke-interface {v7}, Landroid/widget/SlidingDrawer$OnDrawerScrollListener;->onScrollStarted()V

    :cond_39
    iget-boolean v7, p0, Landroid/widget/SlidingDrawer;->mVertical:Z

    if-eqz v7, :cond_51

    iget-object v7, p0, Landroid/widget/SlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v7}, Landroid/view/View;->getTop()I

    move-result v4

    .local v4, top:I
    float-to-int v7, v6

    sub-int/2addr v7, v4

    iput v7, p0, Landroid/widget/SlidingDrawer;->mTouchDelta:I

    invoke-direct {p0, v4}, Landroid/widget/SlidingDrawer;->prepareTracking(I)V

    .end local v4           #top:I
    :goto_4a
    iget-object v7, p0, Landroid/widget/SlidingDrawer;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v7, p1}, Landroid/view/VelocityTracker;->addMovement(Landroid/view/MotionEvent;)V

    :cond_4f
    move v7, v8

    goto :goto_6

    :cond_51
    iget-object v7, p0, Landroid/widget/SlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v7}, Landroid/view/View;->getLeft()I

    move-result v3

    .local v3, left:I
    float-to-int v7, v5

    sub-int/2addr v7, v3

    iput v7, p0, Landroid/widget/SlidingDrawer;->mTouchDelta:I

    invoke-direct {p0, v3}, Landroid/widget/SlidingDrawer;->prepareTracking(I)V

    goto :goto_4a
.end method

.method protected onLayout(ZIIII)V
    .registers 19
    .parameter "changed"
    .parameter "l"
    .parameter "t"
    .parameter "r"
    .parameter "b"

    .prologue
    iget-boolean v8, p0, Landroid/widget/SlidingDrawer;->mTracking:Z

    if-eqz v8, :cond_5

    :goto_4
    return-void

    :cond_5
    sub-int v7, p4, p2

    .local v7, width:I
    sub-int v6, p5, p3

    .local v6, height:I
    iget-object v5, p0, Landroid/widget/SlidingDrawer;->mHandle:Landroid/view/View;

    .local v5, handle:Landroid/view/View;
    invoke-virtual {v5}, Landroid/view/View;->getMeasuredWidth()I

    move-result v3

    .local v3, childWidth:I
    invoke-virtual {v5}, Landroid/view/View;->getMeasuredHeight()I

    move-result v0

    .local v0, childHeight:I
    iget-object v4, p0, Landroid/widget/SlidingDrawer;->mContent:Landroid/view/View;

    .local v4, content:Landroid/view/View;
    iget-boolean v8, p0, Landroid/widget/SlidingDrawer;->mVertical:Z

    if-eqz v8, :cond_51

    sub-int v8, v7, v3

    div-int/lit8 v1, v8, 0x2

    .local v1, childLeft:I
    iget-boolean v8, p0, Landroid/widget/SlidingDrawer;->mExpanded:Z

    if-eqz v8, :cond_4a

    iget v2, p0, Landroid/widget/SlidingDrawer;->mTopOffset:I

    .local v2, childTop:I
    :goto_23
    const/4 v8, 0x0

    iget v9, p0, Landroid/widget/SlidingDrawer;->mTopOffset:I

    add-int/2addr v9, v0

    invoke-virtual {v4}, Landroid/view/View;->getMeasuredWidth()I

    move-result v10

    iget v11, p0, Landroid/widget/SlidingDrawer;->mTopOffset:I

    add-int/2addr v11, v0

    invoke-virtual {v4}, Landroid/view/View;->getMeasuredHeight()I

    move-result v12

    add-int/2addr v11, v12

    invoke-virtual {v4, v8, v9, v10, v11}, Landroid/view/View;->layout(IIII)V

    :goto_36
    add-int v8, v1, v3

    add-int v9, v2, v0

    invoke-virtual {v5, v1, v2, v8, v9}, Landroid/view/View;->layout(IIII)V

    invoke-virtual {v5}, Landroid/view/View;->getHeight()I

    move-result v8

    iput v8, p0, Landroid/widget/SlidingDrawer;->mHandleHeight:I

    invoke-virtual {v5}, Landroid/view/View;->getWidth()I

    move-result v8

    iput v8, p0, Landroid/widget/SlidingDrawer;->mHandleWidth:I

    goto :goto_4

    .end local v2           #childTop:I
    :cond_4a
    sub-int v8, v6, v0

    iget v9, p0, Landroid/widget/SlidingDrawer;->mBottomOffset:I

    add-int v2, v8, v9

    goto :goto_23

    .end local v1           #childLeft:I
    :cond_51
    iget-boolean v8, p0, Landroid/widget/SlidingDrawer;->mExpanded:Z

    if-eqz v8, :cond_6f

    iget v1, p0, Landroid/widget/SlidingDrawer;->mTopOffset:I

    .restart local v1       #childLeft:I
    :goto_57
    sub-int v8, v6, v0

    div-int/lit8 v2, v8, 0x2

    .restart local v2       #childTop:I
    iget v8, p0, Landroid/widget/SlidingDrawer;->mTopOffset:I

    add-int/2addr v8, v3

    const/4 v9, 0x0

    iget v10, p0, Landroid/widget/SlidingDrawer;->mTopOffset:I

    add-int/2addr v10, v3

    invoke-virtual {v4}, Landroid/view/View;->getMeasuredWidth()I

    move-result v11

    add-int/2addr v10, v11

    invoke-virtual {v4}, Landroid/view/View;->getMeasuredHeight()I

    move-result v11

    invoke-virtual {v4, v8, v9, v10, v11}, Landroid/view/View;->layout(IIII)V

    goto :goto_36

    .end local v1           #childLeft:I
    .end local v2           #childTop:I
    :cond_6f
    sub-int v8, v7, v3

    iget v9, p0, Landroid/widget/SlidingDrawer;->mBottomOffset:I

    add-int v1, v8, v9

    goto :goto_57
.end method

.method protected onMeasure(II)V
    .registers 13
    .parameter "widthMeasureSpec"
    .parameter "heightMeasureSpec"

    .prologue
    const/high16 v9, 0x4000

    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v5

    .local v5, widthSpecMode:I
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v6

    .local v6, widthSpecSize:I
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v2

    .local v2, heightSpecMode:I
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v3

    .local v3, heightSpecSize:I
    if-eqz v5, :cond_16

    if-nez v2, :cond_1e

    :cond_16
    new-instance v7, Ljava/lang/RuntimeException;

    const-string v8, "SlidingDrawer cannot have UNSPECIFIED dimensions"

    invoke-direct {v7, v8}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v7

    :cond_1e
    iget-object v0, p0, Landroid/widget/SlidingDrawer;->mHandle:Landroid/view/View;

    .local v0, handle:Landroid/view/View;
    invoke-virtual {p0, v0, p1, p2}, Landroid/widget/SlidingDrawer;->measureChild(Landroid/view/View;II)V

    iget-boolean v7, p0, Landroid/widget/SlidingDrawer;->mVertical:Z

    if-eqz v7, :cond_42

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredHeight()I

    move-result v7

    sub-int v7, v3, v7

    iget v8, p0, Landroid/widget/SlidingDrawer;->mTopOffset:I

    sub-int v1, v7, v8

    .local v1, height:I
    iget-object v7, p0, Landroid/widget/SlidingDrawer;->mContent:Landroid/view/View;

    invoke-static {v6, v9}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v8

    invoke-static {v1, v9}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v9

    invoke-virtual {v7, v8, v9}, Landroid/view/View;->measure(II)V

    .end local v1           #height:I
    :goto_3e
    invoke-virtual {p0, v6, v3}, Landroid/widget/SlidingDrawer;->setMeasuredDimension(II)V

    return-void

    :cond_42
    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v7

    sub-int v7, v6, v7

    iget v8, p0, Landroid/widget/SlidingDrawer;->mTopOffset:I

    sub-int v4, v7, v8

    .local v4, width:I
    iget-object v7, p0, Landroid/widget/SlidingDrawer;->mContent:Landroid/view/View;

    invoke-static {v4, v9}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v8

    invoke-static {v3, v9}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v9

    invoke-virtual {v7, v8, v9}, Landroid/view/View;->measure(II)V

    goto :goto_3e
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .registers 15
    .parameter "event"

    .prologue
    iget-boolean v9, p0, Landroid/widget/SlidingDrawer;->mLocked:Z

    if-eqz v9, :cond_6

    const/4 v9, 0x1

    :goto_5
    return v9

    :cond_6
    iget-boolean v9, p0, Landroid/widget/SlidingDrawer;->mTracking:Z

    if-eqz v9, :cond_16

    iget-object v9, p0, Landroid/widget/SlidingDrawer;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v9, p1}, Landroid/view/VelocityTracker;->addMovement(Landroid/view/MotionEvent;)V

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    .local v0, action:I
    packed-switch v0, :pswitch_data_120

    .end local v0           #action:I
    :cond_16
    :goto_16
    iget-boolean v9, p0, Landroid/widget/SlidingDrawer;->mTracking:Z

    if-nez v9, :cond_24

    iget-boolean v9, p0, Landroid/widget/SlidingDrawer;->mAnimating:Z

    if-nez v9, :cond_24

    invoke-super {p0, p1}, Landroid/view/ViewGroup;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v9

    if-eqz v9, :cond_11c

    :cond_24
    const/4 v9, 0x1

    goto :goto_5

    .restart local v0       #action:I
    :pswitch_26
    iget-boolean v9, p0, Landroid/widget/SlidingDrawer;->mVertical:Z

    if-eqz v9, :cond_36

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    :goto_2e
    float-to-int v9, v9

    iget v10, p0, Landroid/widget/SlidingDrawer;->mTouchDelta:I

    sub-int/2addr v9, v10

    invoke-direct {p0, v9}, Landroid/widget/SlidingDrawer;->moveHandle(I)V

    goto :goto_16

    :cond_36
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    goto :goto_2e

    :pswitch_3b
    iget-object v5, p0, Landroid/widget/SlidingDrawer;->mVelocityTracker:Landroid/view/VelocityTracker;

    .local v5, velocityTracker:Landroid/view/VelocityTracker;
    iget v9, p0, Landroid/widget/SlidingDrawer;->mVelocityUnits:I

    invoke-virtual {v5, v9}, Landroid/view/VelocityTracker;->computeCurrentVelocity(I)V

    invoke-virtual {v5}, Landroid/view/VelocityTracker;->getYVelocity()F

    move-result v8

    .local v8, yVelocity:F
    invoke-virtual {v5}, Landroid/view/VelocityTracker;->getXVelocity()F

    move-result v7

    .local v7, xVelocity:F
    iget-boolean v6, p0, Landroid/widget/SlidingDrawer;->mVertical:Z

    .local v6, vertical:Z
    if-eqz v6, :cond_bb

    const/4 v9, 0x0

    cmpg-float v9, v8, v9

    if-gez v9, :cond_b9

    const/4 v2, 0x1

    .local v2, negative:Z
    :goto_54
    const/4 v9, 0x0

    cmpg-float v9, v7, v9

    if-gez v9, :cond_5a

    neg-float v7, v7

    :cond_5a
    iget v9, p0, Landroid/widget/SlidingDrawer;->mMaximumMinorVelocity:I

    int-to-float v9, v9

    cmpl-float v9, v7, v9

    if-lez v9, :cond_64

    iget v9, p0, Landroid/widget/SlidingDrawer;->mMaximumMinorVelocity:I

    int-to-float v7, v9

    :cond_64
    :goto_64
    float-to-double v9, v7

    float-to-double v11, v8

    invoke-static {v9, v10, v11, v12}, Ljava/lang/Math;->hypot(DD)D

    move-result-wide v9

    double-to-float v4, v9

    .local v4, velocity:F
    if-eqz v2, :cond_6e

    neg-float v4, v4

    :cond_6e
    iget-object v9, p0, Landroid/widget/SlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v9}, Landroid/view/View;->getTop()I

    move-result v3

    .local v3, top:I
    iget-object v9, p0, Landroid/widget/SlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v9}, Landroid/view/View;->getLeft()I

    move-result v1

    .local v1, left:I
    invoke-static {v4}, Ljava/lang/Math;->abs(F)F

    move-result v9

    iget v10, p0, Landroid/widget/SlidingDrawer;->mMaximumTapVelocity:I

    int-to-float v10, v10

    cmpg-float v9, v9, v10

    if-gez v9, :cond_112

    if-eqz v6, :cond_d4

    iget-boolean v9, p0, Landroid/widget/SlidingDrawer;->mExpanded:Z

    if-eqz v9, :cond_92

    iget v9, p0, Landroid/widget/SlidingDrawer;->mTapThreshold:I

    iget v10, p0, Landroid/widget/SlidingDrawer;->mTopOffset:I

    add-int/2addr v9, v10

    if-lt v3, v9, :cond_a6

    :cond_92
    iget-boolean v9, p0, Landroid/widget/SlidingDrawer;->mExpanded:Z

    if-nez v9, :cond_f3

    iget v9, p0, Landroid/widget/SlidingDrawer;->mBottomOffset:I

    iget v10, p0, Landroid/view/View;->mBottom:I

    add-int/2addr v9, v10

    iget v10, p0, Landroid/view/View;->mTop:I

    sub-int/2addr v9, v10

    iget v10, p0, Landroid/widget/SlidingDrawer;->mHandleHeight:I

    sub-int/2addr v9, v10

    iget v10, p0, Landroid/widget/SlidingDrawer;->mTapThreshold:I

    sub-int/2addr v9, v10

    if-le v3, v9, :cond_f3

    :cond_a6
    iget-boolean v9, p0, Landroid/widget/SlidingDrawer;->mAllowSingleTap:Z

    if-eqz v9, :cond_106

    const/4 v9, 0x0

    invoke-virtual {p0, v9}, Landroid/widget/SlidingDrawer;->playSoundEffect(I)V

    iget-boolean v9, p0, Landroid/widget/SlidingDrawer;->mExpanded:Z

    if-eqz v9, :cond_fd

    if-eqz v6, :cond_fb

    .end local v3           #top:I
    :goto_b4
    invoke-direct {p0, v3}, Landroid/widget/SlidingDrawer;->animateClose(I)V

    goto/16 :goto_16

    .end local v1           #left:I
    .end local v2           #negative:Z
    .end local v4           #velocity:F
    :cond_b9
    const/4 v2, 0x0

    goto :goto_54

    :cond_bb
    const/4 v9, 0x0

    cmpg-float v9, v7, v9

    if-gez v9, :cond_d2

    const/4 v2, 0x1

    .restart local v2       #negative:Z
    :goto_c1
    const/4 v9, 0x0

    cmpg-float v9, v8, v9

    if-gez v9, :cond_c7

    neg-float v8, v8

    :cond_c7
    iget v9, p0, Landroid/widget/SlidingDrawer;->mMaximumMinorVelocity:I

    int-to-float v9, v9

    cmpl-float v9, v8, v9

    if-lez v9, :cond_64

    iget v9, p0, Landroid/widget/SlidingDrawer;->mMaximumMinorVelocity:I

    int-to-float v8, v9

    goto :goto_64

    .end local v2           #negative:Z
    :cond_d2
    const/4 v2, 0x0

    goto :goto_c1

    .restart local v1       #left:I
    .restart local v2       #negative:Z
    .restart local v3       #top:I
    .restart local v4       #velocity:F
    :cond_d4
    iget-boolean v9, p0, Landroid/widget/SlidingDrawer;->mExpanded:Z

    if-eqz v9, :cond_df

    iget v9, p0, Landroid/widget/SlidingDrawer;->mTapThreshold:I

    iget v10, p0, Landroid/widget/SlidingDrawer;->mTopOffset:I

    add-int/2addr v9, v10

    if-lt v1, v9, :cond_a6

    :cond_df
    iget-boolean v9, p0, Landroid/widget/SlidingDrawer;->mExpanded:Z

    if-nez v9, :cond_f3

    iget v9, p0, Landroid/widget/SlidingDrawer;->mBottomOffset:I

    iget v10, p0, Landroid/view/View;->mRight:I

    add-int/2addr v9, v10

    iget v10, p0, Landroid/view/View;->mLeft:I

    sub-int/2addr v9, v10

    iget v10, p0, Landroid/widget/SlidingDrawer;->mHandleWidth:I

    sub-int/2addr v9, v10

    iget v10, p0, Landroid/widget/SlidingDrawer;->mTapThreshold:I

    sub-int/2addr v9, v10

    if-gt v1, v9, :cond_a6

    :cond_f3
    if-eqz v6, :cond_110

    .end local v3           #top:I
    :goto_f5
    const/4 v9, 0x0

    invoke-direct {p0, v3, v4, v9}, Landroid/widget/SlidingDrawer;->performFling(IFZ)V

    goto/16 :goto_16

    .restart local v3       #top:I
    :cond_fb
    move v3, v1

    goto :goto_b4

    :cond_fd
    if-eqz v6, :cond_104

    .end local v3           #top:I
    :goto_ff
    invoke-direct {p0, v3}, Landroid/widget/SlidingDrawer;->animateOpen(I)V

    goto/16 :goto_16

    .restart local v3       #top:I
    :cond_104
    move v3, v1

    goto :goto_ff

    :cond_106
    if-eqz v6, :cond_10e

    .end local v3           #top:I
    :goto_108
    const/4 v9, 0x0

    invoke-direct {p0, v3, v4, v9}, Landroid/widget/SlidingDrawer;->performFling(IFZ)V

    goto/16 :goto_16

    .restart local v3       #top:I
    :cond_10e
    move v3, v1

    goto :goto_108

    :cond_110
    move v3, v1

    goto :goto_f5

    :cond_112
    if-eqz v6, :cond_11a

    .end local v3           #top:I
    :goto_114
    const/4 v9, 0x0

    invoke-direct {p0, v3, v4, v9}, Landroid/widget/SlidingDrawer;->performFling(IFZ)V

    goto/16 :goto_16

    .restart local v3       #top:I
    :cond_11a
    move v3, v1

    goto :goto_114

    .end local v0           #action:I
    .end local v1           #left:I
    .end local v2           #negative:Z
    .end local v3           #top:I
    .end local v4           #velocity:F
    .end local v5           #velocityTracker:Landroid/view/VelocityTracker;
    .end local v6           #vertical:Z
    .end local v7           #xVelocity:F
    .end local v8           #yVelocity:F
    :cond_11c
    const/4 v9, 0x0

    goto/16 :goto_5

    nop

    :pswitch_data_120
    .packed-switch 0x1
        :pswitch_3b
        :pswitch_26
        :pswitch_3b
    .end packed-switch
.end method

.method public open()V
    .registers 2

    .prologue
    invoke-direct {p0}, Landroid/widget/SlidingDrawer;->openDrawer()V

    invoke-virtual {p0}, Landroid/widget/SlidingDrawer;->invalidate()V

    invoke-virtual {p0}, Landroid/widget/SlidingDrawer;->requestLayout()V

    const/16 v0, 0x20

    invoke-virtual {p0, v0}, Landroid/widget/SlidingDrawer;->sendAccessibilityEvent(I)V

    return-void
.end method

.method public setOnDrawerCloseListener(Landroid/widget/SlidingDrawer$OnDrawerCloseListener;)V
    .registers 2
    .parameter "onDrawerCloseListener"

    .prologue
    iput-object p1, p0, Landroid/widget/SlidingDrawer;->mOnDrawerCloseListener:Landroid/widget/SlidingDrawer$OnDrawerCloseListener;

    return-void
.end method

.method public setOnDrawerOpenListener(Landroid/widget/SlidingDrawer$OnDrawerOpenListener;)V
    .registers 2
    .parameter "onDrawerOpenListener"

    .prologue
    iput-object p1, p0, Landroid/widget/SlidingDrawer;->mOnDrawerOpenListener:Landroid/widget/SlidingDrawer$OnDrawerOpenListener;

    return-void
.end method

.method public setOnDrawerScrollListener(Landroid/widget/SlidingDrawer$OnDrawerScrollListener;)V
    .registers 2
    .parameter "onDrawerScrollListener"

    .prologue
    iput-object p1, p0, Landroid/widget/SlidingDrawer;->mOnDrawerScrollListener:Landroid/widget/SlidingDrawer$OnDrawerScrollListener;

    return-void
.end method

.method public toggle()V
    .registers 2

    .prologue
    iget-boolean v0, p0, Landroid/widget/SlidingDrawer;->mExpanded:Z

    if-nez v0, :cond_e

    invoke-direct {p0}, Landroid/widget/SlidingDrawer;->openDrawer()V

    :goto_7
    invoke-virtual {p0}, Landroid/widget/SlidingDrawer;->invalidate()V

    invoke-virtual {p0}, Landroid/widget/SlidingDrawer;->requestLayout()V

    return-void

    :cond_e
    invoke-direct {p0}, Landroid/widget/SlidingDrawer;->closeDrawer()V

    goto :goto_7
.end method

.method public unlock()V
    .registers 2

    .prologue
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/widget/SlidingDrawer;->mLocked:Z

    return-void
.end method
