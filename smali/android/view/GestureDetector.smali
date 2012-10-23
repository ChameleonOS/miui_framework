.class public Landroid/view/GestureDetector;
.super Ljava/lang/Object;
.source "GestureDetector.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/view/GestureDetector$GestureHandler;,
        Landroid/view/GestureDetector$SimpleOnGestureListener;,
        Landroid/view/GestureDetector$OnDoubleTapListener;,
        Landroid/view/GestureDetector$OnGestureListener;
    }
.end annotation


# static fields
#the value of this static final field might be set in the static constructor
.field private static final DOUBLE_TAP_TIMEOUT:I = 0x0

#the value of this static final field might be set in the static constructor
.field private static final LONGPRESS_TIMEOUT:I = 0x0

.field private static final LONG_PRESS:I = 0x2

.field private static final SHOW_PRESS:I = 0x1

.field private static final TAP:I = 0x3

.field private static final TAP_TIMEOUT:I


# instance fields
.field private mAlwaysInBiggerTapRegion:Z

.field private mAlwaysInTapRegion:Z

.field private mCurrentDownEvent:Landroid/view/MotionEvent;

.field private mDoubleTapListener:Landroid/view/GestureDetector$OnDoubleTapListener;

.field private mDoubleTapSlopSquare:I

.field private mDoubleTapTouchSlopSquare:I

.field private mDownFocusX:F

.field private mDownFocusY:F

.field private final mHandler:Landroid/os/Handler;

.field private mInLongPress:Z

.field private final mInputEventConsistencyVerifier:Landroid/view/InputEventConsistencyVerifier;

.field private mIsDoubleTapping:Z

.field private mIsLongpressEnabled:Z

.field private mLastFocusX:F

.field private mLastFocusY:F

.field private final mListener:Landroid/view/GestureDetector$OnGestureListener;

.field private mMaximumFlingVelocity:I

.field private mMinimumFlingVelocity:I

.field private mPreviousUpEvent:Landroid/view/MotionEvent;

.field private mStillDown:Z

.field private mTouchSlopSquare:I

.field private mVelocityTracker:Landroid/view/VelocityTracker;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 202
    invoke-static {}, Landroid/view/ViewConfiguration;->getLongPressTimeout()I

    move-result v0

    sput v0, Landroid/view/GestureDetector;->LONGPRESS_TIMEOUT:I

    .line 203
    invoke-static {}, Landroid/view/ViewConfiguration;->getTapTimeout()I

    move-result v0

    sput v0, Landroid/view/GestureDetector;->TAP_TIMEOUT:I

    .line 204
    invoke-static {}, Landroid/view/ViewConfiguration;->getDoubleTapTimeout()I

    move-result v0

    sput v0, Landroid/view/GestureDetector;->DOUBLE_TAP_TIMEOUT:I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;)V
    .registers 4
    .parameter "context"
    .parameter "listener"

    .prologue
    .line 331
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Landroid/view/GestureDetector;-><init>(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;Landroid/os/Handler;)V

    .line 332
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;Landroid/os/Handler;)V
    .registers 6
    .parameter "context"
    .parameter "listener"
    .parameter "handler"

    .prologue
    .line 346
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 244
    invoke-static {}, Landroid/view/InputEventConsistencyVerifier;->isInstrumentationEnabled()Z

    move-result v0

    if-eqz v0, :cond_29

    new-instance v0, Landroid/view/InputEventConsistencyVerifier;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Landroid/view/InputEventConsistencyVerifier;-><init>(Ljava/lang/Object;I)V

    :goto_f
    iput-object v0, p0, Landroid/view/GestureDetector;->mInputEventConsistencyVerifier:Landroid/view/InputEventConsistencyVerifier;

    .line 347
    if-eqz p3, :cond_2b

    .line 348
    new-instance v0, Landroid/view/GestureDetector$GestureHandler;

    invoke-direct {v0, p0, p3}, Landroid/view/GestureDetector$GestureHandler;-><init>(Landroid/view/GestureDetector;Landroid/os/Handler;)V

    iput-object v0, p0, Landroid/view/GestureDetector;->mHandler:Landroid/os/Handler;

    .line 352
    :goto_1a
    iput-object p2, p0, Landroid/view/GestureDetector;->mListener:Landroid/view/GestureDetector$OnGestureListener;

    .line 353
    instance-of v0, p2, Landroid/view/GestureDetector$OnDoubleTapListener;

    if-eqz v0, :cond_25

    .line 354
    check-cast p2, Landroid/view/GestureDetector$OnDoubleTapListener;

    .end local p2
    invoke-virtual {p0, p2}, Landroid/view/GestureDetector;->setOnDoubleTapListener(Landroid/view/GestureDetector$OnDoubleTapListener;)V

    .line 356
    :cond_25
    invoke-direct {p0, p1}, Landroid/view/GestureDetector;->init(Landroid/content/Context;)V

    .line 357
    return-void

    .line 244
    .restart local p2
    :cond_29
    const/4 v0, 0x0

    goto :goto_f

    .line 350
    :cond_2b
    new-instance v0, Landroid/view/GestureDetector$GestureHandler;

    invoke-direct {v0, p0}, Landroid/view/GestureDetector$GestureHandler;-><init>(Landroid/view/GestureDetector;)V

    iput-object v0, p0, Landroid/view/GestureDetector;->mHandler:Landroid/os/Handler;

    goto :goto_1a
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;Landroid/os/Handler;Z)V
    .registers 5
    .parameter "context"
    .parameter "listener"
    .parameter "handler"
    .parameter "unused"

    .prologue
    .line 373
    invoke-direct {p0, p1, p2, p3}, Landroid/view/GestureDetector;-><init>(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;Landroid/os/Handler;)V

    .line 374
    return-void
.end method

.method public constructor <init>(Landroid/view/GestureDetector$OnGestureListener;)V
    .registers 3
    .parameter "listener"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 316
    invoke-direct {p0, v0, p1, v0}, Landroid/view/GestureDetector;-><init>(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;Landroid/os/Handler;)V

    .line 317
    return-void
.end method

.method public constructor <init>(Landroid/view/GestureDetector$OnGestureListener;Landroid/os/Handler;)V
    .registers 4
    .parameter "listener"
    .parameter "handler"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 298
    const/4 v0, 0x0

    invoke-direct {p0, v0, p1, p2}, Landroid/view/GestureDetector;-><init>(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;Landroid/os/Handler;)V

    .line 299
    return-void
.end method

.method static synthetic access$000(Landroid/view/GestureDetector;)Landroid/view/MotionEvent;
    .registers 2
    .parameter "x0"

    .prologue
    .line 38
    iget-object v0, p0, Landroid/view/GestureDetector;->mCurrentDownEvent:Landroid/view/MotionEvent;

    return-object v0
.end method

.method static synthetic access$100(Landroid/view/GestureDetector;)Landroid/view/GestureDetector$OnGestureListener;
    .registers 2
    .parameter "x0"

    .prologue
    .line 38
    iget-object v0, p0, Landroid/view/GestureDetector;->mListener:Landroid/view/GestureDetector$OnGestureListener;

    return-object v0
.end method

.method static synthetic access$200(Landroid/view/GestureDetector;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 38
    invoke-direct {p0}, Landroid/view/GestureDetector;->dispatchLongPress()V

    return-void
.end method

.method static synthetic access$300(Landroid/view/GestureDetector;)Landroid/view/GestureDetector$OnDoubleTapListener;
    .registers 2
    .parameter "x0"

    .prologue
    .line 38
    iget-object v0, p0, Landroid/view/GestureDetector;->mDoubleTapListener:Landroid/view/GestureDetector$OnDoubleTapListener;

    return-object v0
.end method

.method static synthetic access$400(Landroid/view/GestureDetector;)Z
    .registers 2
    .parameter "x0"

    .prologue
    .line 38
    iget-boolean v0, p0, Landroid/view/GestureDetector;->mStillDown:Z

    return v0
.end method

.method private cancel()V
    .registers 4

    .prologue
    const/4 v2, 0x0

    .line 610
    iget-object v0, p0, Landroid/view/GestureDetector;->mHandler:Landroid/os/Handler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    .line 611
    iget-object v0, p0, Landroid/view/GestureDetector;->mHandler:Landroid/os/Handler;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    .line 612
    iget-object v0, p0, Landroid/view/GestureDetector;->mHandler:Landroid/os/Handler;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    .line 613
    iget-object v0, p0, Landroid/view/GestureDetector;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v0}, Landroid/view/VelocityTracker;->recycle()V

    .line 614
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/view/GestureDetector;->mVelocityTracker:Landroid/view/VelocityTracker;

    .line 615
    iput-boolean v2, p0, Landroid/view/GestureDetector;->mIsDoubleTapping:Z

    .line 616
    iput-boolean v2, p0, Landroid/view/GestureDetector;->mStillDown:Z

    .line 617
    iput-boolean v2, p0, Landroid/view/GestureDetector;->mAlwaysInTapRegion:Z

    .line 618
    iput-boolean v2, p0, Landroid/view/GestureDetector;->mAlwaysInBiggerTapRegion:Z

    .line 619
    iget-boolean v0, p0, Landroid/view/GestureDetector;->mInLongPress:Z

    if-eqz v0, :cond_29

    .line 620
    iput-boolean v2, p0, Landroid/view/GestureDetector;->mInLongPress:Z

    .line 622
    :cond_29
    return-void
.end method

.method private cancelTaps()V
    .registers 4

    .prologue
    const/4 v2, 0x0

    .line 625
    iget-object v0, p0, Landroid/view/GestureDetector;->mHandler:Landroid/os/Handler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    .line 626
    iget-object v0, p0, Landroid/view/GestureDetector;->mHandler:Landroid/os/Handler;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    .line 627
    iget-object v0, p0, Landroid/view/GestureDetector;->mHandler:Landroid/os/Handler;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    .line 628
    iput-boolean v2, p0, Landroid/view/GestureDetector;->mIsDoubleTapping:Z

    .line 629
    iput-boolean v2, p0, Landroid/view/GestureDetector;->mAlwaysInTapRegion:Z

    .line 630
    iput-boolean v2, p0, Landroid/view/GestureDetector;->mAlwaysInBiggerTapRegion:Z

    .line 631
    iget-boolean v0, p0, Landroid/view/GestureDetector;->mInLongPress:Z

    if-eqz v0, :cond_1f

    .line 632
    iput-boolean v2, p0, Landroid/view/GestureDetector;->mInLongPress:Z

    .line 634
    :cond_1f
    return-void
.end method

.method private dispatchLongPress()V
    .registers 3

    .prologue
    .line 652
    iget-object v0, p0, Landroid/view/GestureDetector;->mHandler:Landroid/os/Handler;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    .line 653
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/view/GestureDetector;->mInLongPress:Z

    .line 654
    iget-object v0, p0, Landroid/view/GestureDetector;->mListener:Landroid/view/GestureDetector$OnGestureListener;

    iget-object v1, p0, Landroid/view/GestureDetector;->mCurrentDownEvent:Landroid/view/MotionEvent;

    invoke-interface {v0, v1}, Landroid/view/GestureDetector$OnGestureListener;->onLongPress(Landroid/view/MotionEvent;)V

    .line 655
    return-void
.end method

.method private init(Landroid/content/Context;)V
    .registers 8
    .parameter "context"

    .prologue
    .line 377
    iget-object v4, p0, Landroid/view/GestureDetector;->mListener:Landroid/view/GestureDetector$OnGestureListener;

    if-nez v4, :cond_c

    .line 378
    new-instance v4, Ljava/lang/NullPointerException;

    const-string v5, "OnGestureListener must not be null"

    invoke-direct {v4, v5}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 380
    :cond_c
    const/4 v4, 0x1

    iput-boolean v4, p0, Landroid/view/GestureDetector;->mIsLongpressEnabled:Z

    .line 384
    if-nez p1, :cond_33

    .line 386
    invoke-static {}, Landroid/view/ViewConfiguration;->getTouchSlop()I

    move-result v3

    .line 387
    .local v3, touchSlop:I
    move v2, v3

    .line 388
    .local v2, doubleTapTouchSlop:I
    invoke-static {}, Landroid/view/ViewConfiguration;->getDoubleTapSlop()I

    move-result v1

    .line 390
    .local v1, doubleTapSlop:I
    invoke-static {}, Landroid/view/ViewConfiguration;->getMinimumFlingVelocity()I

    move-result v4

    iput v4, p0, Landroid/view/GestureDetector;->mMinimumFlingVelocity:I

    .line 391
    invoke-static {}, Landroid/view/ViewConfiguration;->getMaximumFlingVelocity()I

    move-result v4

    iput v4, p0, Landroid/view/GestureDetector;->mMaximumFlingVelocity:I

    .line 400
    :goto_26
    mul-int v4, v3, v3

    iput v4, p0, Landroid/view/GestureDetector;->mTouchSlopSquare:I

    .line 401
    mul-int v4, v2, v2

    iput v4, p0, Landroid/view/GestureDetector;->mDoubleTapTouchSlopSquare:I

    .line 402
    mul-int v4, v1, v1

    iput v4, p0, Landroid/view/GestureDetector;->mDoubleTapSlopSquare:I

    .line 403
    return-void

    .line 393
    .end local v1           #doubleTapSlop:I
    .end local v2           #doubleTapTouchSlop:I
    .end local v3           #touchSlop:I
    :cond_33
    invoke-static {p1}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v0

    .line 394
    .local v0, configuration:Landroid/view/ViewConfiguration;
    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledTouchSlop()I

    move-result v3

    .line 395
    .restart local v3       #touchSlop:I
    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledDoubleTapTouchSlop()I

    move-result v2

    .line 396
    .restart local v2       #doubleTapTouchSlop:I
    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledDoubleTapSlop()I

    move-result v1

    .line 397
    .restart local v1       #doubleTapSlop:I
    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledMinimumFlingVelocity()I

    move-result v4

    iput v4, p0, Landroid/view/GestureDetector;->mMinimumFlingVelocity:I

    .line 398
    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledMaximumFlingVelocity()I

    move-result v4

    iput v4, p0, Landroid/view/GestureDetector;->mMaximumFlingVelocity:I

    goto :goto_26
.end method

.method private isConsideredDoubleTap(Landroid/view/MotionEvent;Landroid/view/MotionEvent;Landroid/view/MotionEvent;)Z
    .registers 11
    .parameter "firstDown"
    .parameter "firstUp"
    .parameter "secondDown"

    .prologue
    const/4 v2, 0x0

    .line 638
    iget-boolean v3, p0, Landroid/view/GestureDetector;->mAlwaysInBiggerTapRegion:Z

    if-nez v3, :cond_6

    .line 648
    :cond_5
    :goto_5
    return v2

    .line 642
    :cond_6
    invoke-virtual {p3}, Landroid/view/MotionEvent;->getEventTime()J

    move-result-wide v3

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getEventTime()J

    move-result-wide v5

    sub-long/2addr v3, v5

    sget v5, Landroid/view/GestureDetector;->DOUBLE_TAP_TIMEOUT:I

    int-to-long v5, v5

    cmp-long v3, v3, v5

    if-gtz v3, :cond_5

    .line 646
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v3

    float-to-int v3, v3

    invoke-virtual {p3}, Landroid/view/MotionEvent;->getX()F

    move-result v4

    float-to-int v4, v4

    sub-int v0, v3, v4

    .line 647
    .local v0, deltaX:I
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v3

    float-to-int v3, v3

    invoke-virtual {p3}, Landroid/view/MotionEvent;->getY()F

    move-result v4

    float-to-int v4, v4

    sub-int v1, v3, v4

    .line 648
    .local v1, deltaY:I
    mul-int v3, v0, v0

    mul-int v4, v1, v1

    add-int/2addr v3, v4

    iget v4, p0, Landroid/view/GestureDetector;->mDoubleTapSlopSquare:I

    if-ge v3, v4, :cond_5

    const/4 v2, 0x1

    goto :goto_5
.end method


# virtual methods
.method public isLongpressEnabled()Z
    .registers 2

    .prologue
    .line 433
    iget-boolean v0, p0, Landroid/view/GestureDetector;->mIsLongpressEnabled:Z

    return v0
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .registers 35
    .parameter "ev"

    .prologue
    .line 445
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mInputEventConsistencyVerifier:Landroid/view/InputEventConsistencyVerifier;

    move-object/from16 v27, v0

    if-eqz v27, :cond_19

    .line 446
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mInputEventConsistencyVerifier:Landroid/view/InputEventConsistencyVerifier;

    move-object/from16 v27, v0

    const/16 v28, 0x0

    move-object/from16 v0, v27

    move-object/from16 v1, p1

    move/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Landroid/view/InputEventConsistencyVerifier;->onTouchEvent(Landroid/view/MotionEvent;I)V

    .line 449
    :cond_19
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v5

    .line 451
    .local v5, action:I
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mVelocityTracker:Landroid/view/VelocityTracker;

    move-object/from16 v27, v0

    if-nez v27, :cond_2f

    .line 452
    invoke-static {}, Landroid/view/VelocityTracker;->obtain()Landroid/view/VelocityTracker;

    move-result-object v27

    move-object/from16 v0, v27

    move-object/from16 v1, p0

    iput-object v0, v1, Landroid/view/GestureDetector;->mVelocityTracker:Landroid/view/VelocityTracker;

    .line 454
    :cond_2f
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mVelocityTracker:Landroid/view/VelocityTracker;

    move-object/from16 v27, v0

    move-object/from16 v0, v27

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Landroid/view/VelocityTracker;->addMovement(Landroid/view/MotionEvent;)V

    .line 456
    and-int/lit16 v0, v5, 0xff

    move/from16 v27, v0

    const/16 v28, 0x6

    move/from16 v0, v27

    move/from16 v1, v28

    if-ne v0, v1, :cond_67

    const/16 v18, 0x1

    .line 458
    .local v18, pointerUp:Z
    :goto_4a
    if-eqz v18, :cond_6a

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getActionIndex()I

    move-result v21

    .line 461
    .local v21, skipIndex:I
    :goto_50
    const/16 v22, 0x0

    .local v22, sumX:F
    const/16 v23, 0x0

    .line 462
    .local v23, sumY:F
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result v6

    .line 463
    .local v6, count:I
    const/16 v16, 0x0

    .local v16, i:I
    :goto_5a
    move/from16 v0, v16

    if-ge v0, v6, :cond_82

    .line 464
    move/from16 v0, v21

    move/from16 v1, v16

    if-ne v0, v1, :cond_6d

    .line 463
    :goto_64
    add-int/lit8 v16, v16, 0x1

    goto :goto_5a

    .line 456
    .end local v6           #count:I
    .end local v16           #i:I
    .end local v18           #pointerUp:Z
    .end local v21           #skipIndex:I
    .end local v22           #sumX:F
    .end local v23           #sumY:F
    :cond_67
    const/16 v18, 0x0

    goto :goto_4a

    .line 458
    .restart local v18       #pointerUp:Z
    :cond_6a
    const/16 v21, -0x1

    goto :goto_50

    .line 465
    .restart local v6       #count:I
    .restart local v16       #i:I
    .restart local v21       #skipIndex:I
    .restart local v22       #sumX:F
    .restart local v23       #sumY:F
    :cond_6d
    move-object/from16 v0, p1

    move/from16 v1, v16

    invoke-virtual {v0, v1}, Landroid/view/MotionEvent;->getX(I)F

    move-result v27

    add-float v22, v22, v27

    .line 466
    move-object/from16 v0, p1

    move/from16 v1, v16

    invoke-virtual {v0, v1}, Landroid/view/MotionEvent;->getY(I)F

    move-result v27

    add-float v23, v23, v27

    goto :goto_64

    .line 468
    :cond_82
    if-eqz v18, :cond_b4

    add-int/lit8 v11, v6, -0x1

    .line 469
    .local v11, div:I
    :goto_86
    int-to-float v0, v11

    move/from16 v27, v0

    div-float v12, v22, v27

    .line 470
    .local v12, focusX:F
    int-to-float v0, v11

    move/from16 v27, v0

    div-float v13, v23, v27

    .line 472
    .local v13, focusY:F
    const/4 v15, 0x0

    .line 474
    .local v15, handled:Z
    and-int/lit16 v0, v5, 0xff

    move/from16 v27, v0

    packed-switch v27, :pswitch_data_434

    .line 603
    :cond_98
    :goto_98
    :pswitch_98
    if-nez v15, :cond_b3

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mInputEventConsistencyVerifier:Landroid/view/InputEventConsistencyVerifier;

    move-object/from16 v27, v0

    if-eqz v27, :cond_b3

    .line 604
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mInputEventConsistencyVerifier:Landroid/view/InputEventConsistencyVerifier;

    move-object/from16 v27, v0

    const/16 v28, 0x0

    move-object/from16 v0, v27

    move-object/from16 v1, p1

    move/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Landroid/view/InputEventConsistencyVerifier;->onUnhandledEvent(Landroid/view/InputEvent;I)V

    .line 606
    :cond_b3
    return v15

    .end local v11           #div:I
    .end local v12           #focusX:F
    .end local v13           #focusY:F
    .end local v15           #handled:Z
    :cond_b4
    move v11, v6

    .line 468
    goto :goto_86

    .line 476
    .restart local v11       #div:I
    .restart local v12       #focusX:F
    .restart local v13       #focusY:F
    .restart local v15       #handled:Z
    :pswitch_b6
    move-object/from16 v0, p0

    iput v12, v0, Landroid/view/GestureDetector;->mLastFocusX:F

    move-object/from16 v0, p0

    iput v12, v0, Landroid/view/GestureDetector;->mDownFocusX:F

    .line 477
    move-object/from16 v0, p0

    iput v13, v0, Landroid/view/GestureDetector;->mLastFocusY:F

    move-object/from16 v0, p0

    iput v13, v0, Landroid/view/GestureDetector;->mDownFocusY:F

    .line 479
    invoke-direct/range {p0 .. p0}, Landroid/view/GestureDetector;->cancelTaps()V

    goto :goto_98

    .line 483
    :pswitch_ca
    move-object/from16 v0, p0

    iput v12, v0, Landroid/view/GestureDetector;->mLastFocusX:F

    move-object/from16 v0, p0

    iput v12, v0, Landroid/view/GestureDetector;->mDownFocusX:F

    .line 484
    move-object/from16 v0, p0

    iput v13, v0, Landroid/view/GestureDetector;->mLastFocusY:F

    move-object/from16 v0, p0

    iput v13, v0, Landroid/view/GestureDetector;->mDownFocusY:F

    goto :goto_98

    .line 488
    :pswitch_db
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mDoubleTapListener:Landroid/view/GestureDetector$OnDoubleTapListener;

    move-object/from16 v27, v0

    if-eqz v27, :cond_152

    .line 489
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mHandler:Landroid/os/Handler;

    move-object/from16 v27, v0

    const/16 v28, 0x3

    invoke-virtual/range {v27 .. v28}, Landroid/os/Handler;->hasMessages(I)Z

    move-result v14

    .line 490
    .local v14, hadTapMessage:Z
    if-eqz v14, :cond_fc

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mHandler:Landroid/os/Handler;

    move-object/from16 v27, v0

    const/16 v28, 0x3

    invoke-virtual/range {v27 .. v28}, Landroid/os/Handler;->removeMessages(I)V

    .line 491
    :cond_fc
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mCurrentDownEvent:Landroid/view/MotionEvent;

    move-object/from16 v27, v0

    if-eqz v27, :cond_207

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mPreviousUpEvent:Landroid/view/MotionEvent;

    move-object/from16 v27, v0

    if-eqz v27, :cond_207

    if-eqz v14, :cond_207

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mCurrentDownEvent:Landroid/view/MotionEvent;

    move-object/from16 v27, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mPreviousUpEvent:Landroid/view/MotionEvent;

    move-object/from16 v28, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v27

    move-object/from16 v2, v28

    move-object/from16 v3, p1

    invoke-direct {v0, v1, v2, v3}, Landroid/view/GestureDetector;->isConsideredDoubleTap(Landroid/view/MotionEvent;Landroid/view/MotionEvent;Landroid/view/MotionEvent;)Z

    move-result v27

    if-eqz v27, :cond_207

    .line 494
    const/16 v27, 0x1

    move/from16 v0, v27

    move-object/from16 v1, p0

    iput-boolean v0, v1, Landroid/view/GestureDetector;->mIsDoubleTapping:Z

    .line 496
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mDoubleTapListener:Landroid/view/GestureDetector$OnDoubleTapListener;

    move-object/from16 v27, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mCurrentDownEvent:Landroid/view/MotionEvent;

    move-object/from16 v28, v0

    invoke-interface/range {v27 .. v28}, Landroid/view/GestureDetector$OnDoubleTapListener;->onDoubleTap(Landroid/view/MotionEvent;)Z

    move-result v27

    or-int v15, v15, v27

    .line 498
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mDoubleTapListener:Landroid/view/GestureDetector$OnDoubleTapListener;

    move-object/from16 v27, v0

    move-object/from16 v0, v27

    move-object/from16 v1, p1

    invoke-interface {v0, v1}, Landroid/view/GestureDetector$OnDoubleTapListener;->onDoubleTapEvent(Landroid/view/MotionEvent;)Z

    move-result v27

    or-int v15, v15, v27

    .line 505
    .end local v14           #hadTapMessage:Z
    :cond_152
    :goto_152
    move-object/from16 v0, p0

    iput v12, v0, Landroid/view/GestureDetector;->mLastFocusX:F

    move-object/from16 v0, p0

    iput v12, v0, Landroid/view/GestureDetector;->mDownFocusX:F

    .line 506
    move-object/from16 v0, p0

    iput v13, v0, Landroid/view/GestureDetector;->mLastFocusY:F

    move-object/from16 v0, p0

    iput v13, v0, Landroid/view/GestureDetector;->mDownFocusY:F

    .line 507
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mCurrentDownEvent:Landroid/view/MotionEvent;

    move-object/from16 v27, v0

    if-eqz v27, :cond_173

    .line 508
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mCurrentDownEvent:Landroid/view/MotionEvent;

    move-object/from16 v27, v0

    invoke-virtual/range {v27 .. v27}, Landroid/view/MotionEvent;->recycle()V

    .line 510
    :cond_173
    invoke-static/range {p1 .. p1}, Landroid/view/MotionEvent;->obtain(Landroid/view/MotionEvent;)Landroid/view/MotionEvent;

    move-result-object v27

    move-object/from16 v0, v27

    move-object/from16 v1, p0

    iput-object v0, v1, Landroid/view/GestureDetector;->mCurrentDownEvent:Landroid/view/MotionEvent;

    .line 511
    const/16 v27, 0x1

    move/from16 v0, v27

    move-object/from16 v1, p0

    iput-boolean v0, v1, Landroid/view/GestureDetector;->mAlwaysInTapRegion:Z

    .line 512
    const/16 v27, 0x1

    move/from16 v0, v27

    move-object/from16 v1, p0

    iput-boolean v0, v1, Landroid/view/GestureDetector;->mAlwaysInBiggerTapRegion:Z

    .line 513
    const/16 v27, 0x1

    move/from16 v0, v27

    move-object/from16 v1, p0

    iput-boolean v0, v1, Landroid/view/GestureDetector;->mStillDown:Z

    .line 514
    const/16 v27, 0x0

    move/from16 v0, v27

    move-object/from16 v1, p0

    iput-boolean v0, v1, Landroid/view/GestureDetector;->mInLongPress:Z

    .line 516
    move-object/from16 v0, p0

    iget-boolean v0, v0, Landroid/view/GestureDetector;->mIsLongpressEnabled:Z

    move/from16 v27, v0

    if-eqz v27, :cond_1d7

    .line 517
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mHandler:Landroid/os/Handler;

    move-object/from16 v27, v0

    const/16 v28, 0x2

    invoke-virtual/range {v27 .. v28}, Landroid/os/Handler;->removeMessages(I)V

    .line 518
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mHandler:Landroid/os/Handler;

    move-object/from16 v27, v0

    const/16 v28, 0x2

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mCurrentDownEvent:Landroid/view/MotionEvent;

    move-object/from16 v29, v0

    invoke-virtual/range {v29 .. v29}, Landroid/view/MotionEvent;->getDownTime()J

    move-result-wide v29

    sget v31, Landroid/view/GestureDetector;->TAP_TIMEOUT:I

    move/from16 v0, v31

    int-to-long v0, v0

    move-wide/from16 v31, v0

    add-long v29, v29, v31

    sget v31, Landroid/view/GestureDetector;->LONGPRESS_TIMEOUT:I

    move/from16 v0, v31

    int-to-long v0, v0

    move-wide/from16 v31, v0

    add-long v29, v29, v31

    invoke-virtual/range {v27 .. v30}, Landroid/os/Handler;->sendEmptyMessageAtTime(IJ)Z

    .line 521
    :cond_1d7
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mHandler:Landroid/os/Handler;

    move-object/from16 v27, v0

    const/16 v28, 0x1

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mCurrentDownEvent:Landroid/view/MotionEvent;

    move-object/from16 v29, v0

    invoke-virtual/range {v29 .. v29}, Landroid/view/MotionEvent;->getDownTime()J

    move-result-wide v29

    sget v31, Landroid/view/GestureDetector;->TAP_TIMEOUT:I

    move/from16 v0, v31

    int-to-long v0, v0

    move-wide/from16 v31, v0

    add-long v29, v29, v31

    invoke-virtual/range {v27 .. v30}, Landroid/os/Handler;->sendEmptyMessageAtTime(IJ)Z

    .line 522
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mListener:Landroid/view/GestureDetector$OnGestureListener;

    move-object/from16 v27, v0

    move-object/from16 v0, v27

    move-object/from16 v1, p1

    invoke-interface {v0, v1}, Landroid/view/GestureDetector$OnGestureListener;->onDown(Landroid/view/MotionEvent;)Z

    move-result v27

    or-int v15, v15, v27

    .line 523
    goto/16 :goto_98

    .line 501
    .restart local v14       #hadTapMessage:Z
    :cond_207
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mHandler:Landroid/os/Handler;

    move-object/from16 v27, v0

    const/16 v28, 0x3

    sget v29, Landroid/view/GestureDetector;->DOUBLE_TAP_TIMEOUT:I

    move/from16 v0, v29

    int-to-long v0, v0

    move-wide/from16 v29, v0

    invoke-virtual/range {v27 .. v30}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    goto/16 :goto_152

    .line 526
    .end local v14           #hadTapMessage:Z
    :pswitch_21b
    move-object/from16 v0, p0

    iget-boolean v0, v0, Landroid/view/GestureDetector;->mInLongPress:Z

    move/from16 v27, v0

    if-nez v27, :cond_98

    .line 529
    move-object/from16 v0, p0

    iget v0, v0, Landroid/view/GestureDetector;->mLastFocusX:F

    move/from16 v27, v0

    sub-float v19, v27, v12

    .line 530
    .local v19, scrollX:F
    move-object/from16 v0, p0

    iget v0, v0, Landroid/view/GestureDetector;->mLastFocusY:F

    move/from16 v27, v0

    sub-float v20, v27, v13

    .line 531
    .local v20, scrollY:F
    move-object/from16 v0, p0

    iget-boolean v0, v0, Landroid/view/GestureDetector;->mIsDoubleTapping:Z

    move/from16 v27, v0

    if-eqz v27, :cond_24d

    .line 533
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mDoubleTapListener:Landroid/view/GestureDetector$OnDoubleTapListener;

    move-object/from16 v27, v0

    move-object/from16 v0, v27

    move-object/from16 v1, p1

    invoke-interface {v0, v1}, Landroid/view/GestureDetector$OnDoubleTapListener;->onDoubleTapEvent(Landroid/view/MotionEvent;)Z

    move-result v27

    or-int v15, v15, v27

    goto/16 :goto_98

    .line 534
    :cond_24d
    move-object/from16 v0, p0

    iget-boolean v0, v0, Landroid/view/GestureDetector;->mAlwaysInTapRegion:Z

    move/from16 v27, v0

    if-eqz v27, :cond_2da

    .line 535
    move-object/from16 v0, p0

    iget v0, v0, Landroid/view/GestureDetector;->mDownFocusX:F

    move/from16 v27, v0

    sub-float v27, v12, v27

    move/from16 v0, v27

    float-to-int v8, v0

    .line 536
    .local v8, deltaX:I
    move-object/from16 v0, p0

    iget v0, v0, Landroid/view/GestureDetector;->mDownFocusY:F

    move/from16 v27, v0

    sub-float v27, v13, v27

    move/from16 v0, v27

    float-to-int v9, v0

    .line 537
    .local v9, deltaY:I
    mul-int v27, v8, v8

    mul-int v28, v9, v9

    add-int v10, v27, v28

    .line 538
    .local v10, distance:I
    move-object/from16 v0, p0

    iget v0, v0, Landroid/view/GestureDetector;->mTouchSlopSquare:I

    move/from16 v27, v0

    move/from16 v0, v27

    if-le v10, v0, :cond_2c6

    .line 539
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mListener:Landroid/view/GestureDetector$OnGestureListener;

    move-object/from16 v27, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mCurrentDownEvent:Landroid/view/MotionEvent;

    move-object/from16 v28, v0

    move-object/from16 v0, v27

    move-object/from16 v1, v28

    move-object/from16 v2, p1

    move/from16 v3, v19

    move/from16 v4, v20

    invoke-interface {v0, v1, v2, v3, v4}, Landroid/view/GestureDetector$OnGestureListener;->onScroll(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z

    move-result v15

    .line 540
    move-object/from16 v0, p0

    iput v12, v0, Landroid/view/GestureDetector;->mLastFocusX:F

    .line 541
    move-object/from16 v0, p0

    iput v13, v0, Landroid/view/GestureDetector;->mLastFocusY:F

    .line 542
    const/16 v27, 0x0

    move/from16 v0, v27

    move-object/from16 v1, p0

    iput-boolean v0, v1, Landroid/view/GestureDetector;->mAlwaysInTapRegion:Z

    .line 543
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mHandler:Landroid/os/Handler;

    move-object/from16 v27, v0

    const/16 v28, 0x3

    invoke-virtual/range {v27 .. v28}, Landroid/os/Handler;->removeMessages(I)V

    .line 544
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mHandler:Landroid/os/Handler;

    move-object/from16 v27, v0

    const/16 v28, 0x1

    invoke-virtual/range {v27 .. v28}, Landroid/os/Handler;->removeMessages(I)V

    .line 545
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mHandler:Landroid/os/Handler;

    move-object/from16 v27, v0

    const/16 v28, 0x2

    invoke-virtual/range {v27 .. v28}, Landroid/os/Handler;->removeMessages(I)V

    .line 547
    :cond_2c6
    move-object/from16 v0, p0

    iget v0, v0, Landroid/view/GestureDetector;->mDoubleTapTouchSlopSquare:I

    move/from16 v27, v0

    move/from16 v0, v27

    if-le v10, v0, :cond_98

    .line 548
    const/16 v27, 0x0

    move/from16 v0, v27

    move-object/from16 v1, p0

    iput-boolean v0, v1, Landroid/view/GestureDetector;->mAlwaysInBiggerTapRegion:Z

    goto/16 :goto_98

    .line 550
    .end local v8           #deltaX:I
    .end local v9           #deltaY:I
    .end local v10           #distance:I
    :cond_2da
    invoke-static/range {v19 .. v19}, Ljava/lang/Math;->abs(F)F

    move-result v27

    const/high16 v28, 0x3f80

    cmpl-float v27, v27, v28

    if-gez v27, :cond_2ee

    invoke-static/range {v20 .. v20}, Ljava/lang/Math;->abs(F)F

    move-result v27

    const/high16 v28, 0x3f80

    cmpl-float v27, v27, v28

    if-ltz v27, :cond_98

    .line 551
    :cond_2ee
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mListener:Landroid/view/GestureDetector$OnGestureListener;

    move-object/from16 v27, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mCurrentDownEvent:Landroid/view/MotionEvent;

    move-object/from16 v28, v0

    move-object/from16 v0, v27

    move-object/from16 v1, v28

    move-object/from16 v2, p1

    move/from16 v3, v19

    move/from16 v4, v20

    invoke-interface {v0, v1, v2, v3, v4}, Landroid/view/GestureDetector$OnGestureListener;->onScroll(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z

    move-result v15

    .line 552
    move-object/from16 v0, p0

    iput v12, v0, Landroid/view/GestureDetector;->mLastFocusX:F

    .line 553
    move-object/from16 v0, p0

    iput v13, v0, Landroid/view/GestureDetector;->mLastFocusY:F

    goto/16 :goto_98

    .line 558
    .end local v19           #scrollX:F
    .end local v20           #scrollY:F
    :pswitch_312
    const/16 v27, 0x0

    move/from16 v0, v27

    move-object/from16 v1, p0

    iput-boolean v0, v1, Landroid/view/GestureDetector;->mStillDown:Z

    .line 559
    invoke-static/range {p1 .. p1}, Landroid/view/MotionEvent;->obtain(Landroid/view/MotionEvent;)Landroid/view/MotionEvent;

    move-result-object v7

    .line 560
    .local v7, currentUpEvent:Landroid/view/MotionEvent;
    move-object/from16 v0, p0

    iget-boolean v0, v0, Landroid/view/GestureDetector;->mIsDoubleTapping:Z

    move/from16 v27, v0

    if-eqz v27, :cond_384

    .line 562
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mDoubleTapListener:Landroid/view/GestureDetector$OnDoubleTapListener;

    move-object/from16 v27, v0

    move-object/from16 v0, v27

    move-object/from16 v1, p1

    invoke-interface {v0, v1}, Landroid/view/GestureDetector$OnDoubleTapListener;->onDoubleTapEvent(Landroid/view/MotionEvent;)Z

    move-result v27

    or-int v15, v15, v27

    .line 582
    :cond_336
    :goto_336
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mPreviousUpEvent:Landroid/view/MotionEvent;

    move-object/from16 v27, v0

    if-eqz v27, :cond_347

    .line 583
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mPreviousUpEvent:Landroid/view/MotionEvent;

    move-object/from16 v27, v0

    invoke-virtual/range {v27 .. v27}, Landroid/view/MotionEvent;->recycle()V

    .line 586
    :cond_347
    move-object/from16 v0, p0

    iput-object v7, v0, Landroid/view/GestureDetector;->mPreviousUpEvent:Landroid/view/MotionEvent;

    .line 587
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mVelocityTracker:Landroid/view/VelocityTracker;

    move-object/from16 v27, v0

    if-eqz v27, :cond_364

    .line 590
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mVelocityTracker:Landroid/view/VelocityTracker;

    move-object/from16 v27, v0

    invoke-virtual/range {v27 .. v27}, Landroid/view/VelocityTracker;->recycle()V

    .line 591
    const/16 v27, 0x0

    move-object/from16 v0, v27

    move-object/from16 v1, p0

    iput-object v0, v1, Landroid/view/GestureDetector;->mVelocityTracker:Landroid/view/VelocityTracker;

    .line 593
    :cond_364
    const/16 v27, 0x0

    move/from16 v0, v27

    move-object/from16 v1, p0

    iput-boolean v0, v1, Landroid/view/GestureDetector;->mIsDoubleTapping:Z

    .line 594
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mHandler:Landroid/os/Handler;

    move-object/from16 v27, v0

    const/16 v28, 0x1

    invoke-virtual/range {v27 .. v28}, Landroid/os/Handler;->removeMessages(I)V

    .line 595
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mHandler:Landroid/os/Handler;

    move-object/from16 v27, v0

    const/16 v28, 0x2

    invoke-virtual/range {v27 .. v28}, Landroid/os/Handler;->removeMessages(I)V

    goto/16 :goto_98

    .line 563
    :cond_384
    move-object/from16 v0, p0

    iget-boolean v0, v0, Landroid/view/GestureDetector;->mInLongPress:Z

    move/from16 v27, v0

    if-eqz v27, :cond_3a0

    .line 564
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mHandler:Landroid/os/Handler;

    move-object/from16 v27, v0

    const/16 v28, 0x3

    invoke-virtual/range {v27 .. v28}, Landroid/os/Handler;->removeMessages(I)V

    .line 565
    const/16 v27, 0x0

    move/from16 v0, v27

    move-object/from16 v1, p0

    iput-boolean v0, v1, Landroid/view/GestureDetector;->mInLongPress:Z

    goto :goto_336

    .line 566
    :cond_3a0
    move-object/from16 v0, p0

    iget-boolean v0, v0, Landroid/view/GestureDetector;->mAlwaysInTapRegion:Z

    move/from16 v27, v0

    if-eqz v27, :cond_3b7

    .line 567
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mListener:Landroid/view/GestureDetector$OnGestureListener;

    move-object/from16 v27, v0

    move-object/from16 v0, v27

    move-object/from16 v1, p1

    invoke-interface {v0, v1}, Landroid/view/GestureDetector$OnGestureListener;->onSingleTapUp(Landroid/view/MotionEvent;)Z

    move-result v15

    goto :goto_336

    .line 571
    :cond_3b7
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mVelocityTracker:Landroid/view/VelocityTracker;

    move-object/from16 v24, v0

    .line 572
    .local v24, velocityTracker:Landroid/view/VelocityTracker;
    const/16 v27, 0x0

    move-object/from16 v0, p1

    move/from16 v1, v27

    invoke-virtual {v0, v1}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v17

    .line 573
    .local v17, pointerId:I
    const/16 v27, 0x3e8

    move-object/from16 v0, p0

    iget v0, v0, Landroid/view/GestureDetector;->mMaximumFlingVelocity:I

    move/from16 v28, v0

    move/from16 v0, v28

    int-to-float v0, v0

    move/from16 v28, v0

    move-object/from16 v0, v24

    move/from16 v1, v27

    move/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Landroid/view/VelocityTracker;->computeCurrentVelocity(IF)V

    .line 574
    move-object/from16 v0, v24

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/view/VelocityTracker;->getYVelocity(I)F

    move-result v26

    .line 575
    .local v26, velocityY:F
    move-object/from16 v0, v24

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/view/VelocityTracker;->getXVelocity(I)F

    move-result v25

    .line 577
    .local v25, velocityX:F
    invoke-static/range {v26 .. v26}, Ljava/lang/Math;->abs(F)F

    move-result v27

    move-object/from16 v0, p0

    iget v0, v0, Landroid/view/GestureDetector;->mMinimumFlingVelocity:I

    move/from16 v28, v0

    move/from16 v0, v28

    int-to-float v0, v0

    move/from16 v28, v0

    cmpl-float v27, v27, v28

    if-gtz v27, :cond_413

    invoke-static/range {v25 .. v25}, Ljava/lang/Math;->abs(F)F

    move-result v27

    move-object/from16 v0, p0

    iget v0, v0, Landroid/view/GestureDetector;->mMinimumFlingVelocity:I

    move/from16 v28, v0

    move/from16 v0, v28

    int-to-float v0, v0

    move/from16 v28, v0

    cmpl-float v27, v27, v28

    if-lez v27, :cond_336

    .line 579
    :cond_413
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mListener:Landroid/view/GestureDetector$OnGestureListener;

    move-object/from16 v27, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/GestureDetector;->mCurrentDownEvent:Landroid/view/MotionEvent;

    move-object/from16 v28, v0

    move-object/from16 v0, v27

    move-object/from16 v1, v28

    move-object/from16 v2, p1

    move/from16 v3, v25

    move/from16 v4, v26

    invoke-interface {v0, v1, v2, v3, v4}, Landroid/view/GestureDetector$OnGestureListener;->onFling(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z

    move-result v15

    goto/16 :goto_336

    .line 599
    .end local v7           #currentUpEvent:Landroid/view/MotionEvent;
    .end local v17           #pointerId:I
    .end local v24           #velocityTracker:Landroid/view/VelocityTracker;
    .end local v25           #velocityX:F
    .end local v26           #velocityY:F
    :pswitch_42f
    invoke-direct/range {p0 .. p0}, Landroid/view/GestureDetector;->cancel()V

    goto/16 :goto_98

    .line 474
    :pswitch_data_434
    .packed-switch 0x0
        :pswitch_db
        :pswitch_312
        :pswitch_21b
        :pswitch_42f
        :pswitch_98
        :pswitch_b6
        :pswitch_ca
    .end packed-switch
.end method

.method public setIsLongpressEnabled(Z)V
    .registers 2
    .parameter "isLongpressEnabled"

    .prologue
    .line 426
    iput-boolean p1, p0, Landroid/view/GestureDetector;->mIsLongpressEnabled:Z

    .line 427
    return-void
.end method

.method public setOnDoubleTapListener(Landroid/view/GestureDetector$OnDoubleTapListener;)V
    .registers 2
    .parameter "onDoubleTapListener"

    .prologue
    .line 413
    iput-object p1, p0, Landroid/view/GestureDetector;->mDoubleTapListener:Landroid/view/GestureDetector$OnDoubleTapListener;

    .line 414
    return-void
.end method
