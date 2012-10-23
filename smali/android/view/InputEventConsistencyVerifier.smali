.class public final Landroid/view/InputEventConsistencyVerifier;
.super Ljava/lang/Object;
.source "InputEventConsistencyVerifier.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/view/InputEventConsistencyVerifier$KeyState;
    }
.end annotation


# static fields
.field private static final EVENT_TYPE_GENERIC_MOTION:Ljava/lang/String; = "GenericMotionEvent"

.field private static final EVENT_TYPE_KEY:Ljava/lang/String; = "KeyEvent"

.field private static final EVENT_TYPE_TOUCH:Ljava/lang/String; = "TouchEvent"

.field private static final EVENT_TYPE_TRACKBALL:Ljava/lang/String; = "TrackballEvent"

.field public static final FLAG_RAW_DEVICE_INPUT:I = 0x1

#the value of this static final field might be set in the static constructor
.field private static final IS_ENG_BUILD:Z = false

.field private static final RECENT_EVENTS_TO_LOG:I = 0x5


# instance fields
.field private final mCaller:Ljava/lang/Object;

.field private mCurrentEvent:Landroid/view/InputEvent;

.field private mCurrentEventType:Ljava/lang/String;

.field private final mFlags:I

.field private mHoverEntered:Z

.field private mKeyStateList:Landroid/view/InputEventConsistencyVerifier$KeyState;

.field private mLastEventSeq:I

.field private mLastEventType:Ljava/lang/String;

.field private mLastNestingLevel:I

.field private final mLogTag:Ljava/lang/String;

.field private mMostRecentEventIndex:I

.field private mRecentEvents:[Landroid/view/InputEvent;

.field private mRecentEventsUnhandled:[Z

.field private mTouchEventStreamDeviceId:I

.field private mTouchEventStreamIsTainted:Z

.field private mTouchEventStreamPointers:I

.field private mTouchEventStreamSource:I

.field private mTouchEventStreamUnhandled:Z

.field private mTrackballDown:Z

.field private mTrackballUnhandled:Z

.field private mViolationMessage:Ljava/lang/StringBuilder;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    .prologue
    .line 33
    const-string v0, "eng"

    sget-object v1, Landroid/os/Build;->TYPE:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    sput-boolean v0, Landroid/view/InputEventConsistencyVerifier;->IS_ENG_BUILD:Z

    return-void
.end method

.method public constructor <init>(Ljava/lang/Object;I)V
    .registers 4
    .parameter "caller"
    .parameter "flags"

    .prologue
    .line 116
    const-class v0, Landroid/view/InputEventConsistencyVerifier;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, p1, p2, v0}, Landroid/view/InputEventConsistencyVerifier;-><init>(Ljava/lang/Object;ILjava/lang/String;)V

    .line 117
    return-void
.end method

.method public constructor <init>(Ljava/lang/Object;ILjava/lang/String;)V
    .registers 5
    .parameter "caller"
    .parameter "flags"
    .parameter "logTag"

    .prologue
    .line 125
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 87
    const/4 v0, -0x1

    iput v0, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamDeviceId:I

    .line 126
    iput-object p1, p0, Landroid/view/InputEventConsistencyVerifier;->mCaller:Ljava/lang/Object;

    .line 127
    iput p2, p0, Landroid/view/InputEventConsistencyVerifier;->mFlags:I

    .line 128
    if-eqz p3, :cond_f

    .end local p3
    :goto_c
    iput-object p3, p0, Landroid/view/InputEventConsistencyVerifier;->mLogTag:Ljava/lang/String;

    .line 129
    return-void

    .line 128
    .restart local p3
    :cond_f
    const-string p3, "InputEventConsistencyVerifier"

    goto :goto_c
.end method

.method private addKeyState(III)V
    .registers 6
    .parameter "deviceId"
    .parameter "source"
    .parameter "keyCode"

    .prologue
    .line 691
    invoke-static {p1, p2, p3}, Landroid/view/InputEventConsistencyVerifier$KeyState;->obtain(III)Landroid/view/InputEventConsistencyVerifier$KeyState;

    move-result-object v0

    .line 692
    .local v0, state:Landroid/view/InputEventConsistencyVerifier$KeyState;
    iget-object v1, p0, Landroid/view/InputEventConsistencyVerifier;->mKeyStateList:Landroid/view/InputEventConsistencyVerifier$KeyState;

    iput-object v1, v0, Landroid/view/InputEventConsistencyVerifier$KeyState;->next:Landroid/view/InputEventConsistencyVerifier$KeyState;

    .line 693
    iput-object v0, p0, Landroid/view/InputEventConsistencyVerifier;->mKeyStateList:Landroid/view/InputEventConsistencyVerifier$KeyState;

    .line 694
    return-void
.end method

.method private static appendEvent(Ljava/lang/StringBuilder;ILandroid/view/InputEvent;Z)V
    .registers 7
    .parameter "message"
    .parameter "index"
    .parameter "event"
    .parameter "unhandled"

    .prologue
    .line 648
    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ": sent at "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p2}, Landroid/view/InputEvent;->getEventTimeNano()J

    move-result-wide v1

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    .line 649
    const-string v0, ", "

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 650
    if-eqz p3, :cond_1d

    .line 651
    const-string v0, "(unhandled) "

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 653
    :cond_1d
    invoke-virtual {p0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 654
    return-void
.end method

.method private ensureHistorySizeIsZeroForThisAction(Landroid/view/MotionEvent;)V
    .registers 5
    .parameter "event"

    .prologue
    .line 567
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getHistorySize()I

    move-result v0

    .line 568
    .local v0, historySize:I
    if-eqz v0, :cond_2e

    .line 569
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "History size is "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " but it should always be 0 for "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v2

    invoke-static {v2}, Landroid/view/MotionEvent;->actionToString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Landroid/view/InputEventConsistencyVerifier;->problem(Ljava/lang/String;)V

    .line 572
    :cond_2e
    return-void
.end method

.method private ensureMetaStateIsNormalized(I)V
    .registers 7
    .parameter "metaState"

    .prologue
    .line 551
    invoke-static {p1}, Landroid/view/KeyEvent;->normalizeMetaState(I)I

    move-result v0

    .line 552
    .local v0, normalizedMetaState:I
    if-eq v0, p1, :cond_20

    .line 553
    const-string v1, "Metastate not normalized.  Was 0x%08x but expected 0x%08x."

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Landroid/view/InputEventConsistencyVerifier;->problem(Ljava/lang/String;)V

    .line 556
    :cond_20
    return-void
.end method

.method private ensurePointerCountIsOneForThisAction(Landroid/view/MotionEvent;)V
    .registers 5
    .parameter "event"

    .prologue
    .line 559
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result v0

    .line 560
    .local v0, pointerCount:I
    const/4 v1, 0x1

    if-eq v0, v1, :cond_2f

    .line 561
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Pointer count is "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " but it should always be 1 for "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v2

    invoke-static {v2}, Landroid/view/MotionEvent;->actionToString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Landroid/view/InputEventConsistencyVerifier;->problem(Ljava/lang/String;)V

    .line 564
    :cond_2f
    return-void
.end method

.method private findKeyState(IIIZ)Landroid/view/InputEventConsistencyVerifier$KeyState;
    .registers 9
    .parameter "deviceId"
    .parameter "source"
    .parameter "keyCode"
    .parameter "remove"

    .prologue
    const/4 v2, 0x0

    .line 669
    const/4 v0, 0x0

    .line 670
    .local v0, last:Landroid/view/InputEventConsistencyVerifier$KeyState;
    iget-object v1, p0, Landroid/view/InputEventConsistencyVerifier;->mKeyStateList:Landroid/view/InputEventConsistencyVerifier$KeyState;

    .line 671
    .local v1, state:Landroid/view/InputEventConsistencyVerifier$KeyState;
    :goto_4
    if-eqz v1, :cond_26

    .line 672
    iget v3, v1, Landroid/view/InputEventConsistencyVerifier$KeyState;->deviceId:I

    if-ne v3, p1, :cond_22

    iget v3, v1, Landroid/view/InputEventConsistencyVerifier$KeyState;->source:I

    if-ne v3, p2, :cond_22

    iget v3, v1, Landroid/view/InputEventConsistencyVerifier$KeyState;->keyCode:I

    if-ne v3, p3, :cond_22

    .line 674
    if-eqz p4, :cond_1c

    .line 675
    if-eqz v0, :cond_1d

    .line 676
    iget-object v3, v1, Landroid/view/InputEventConsistencyVerifier$KeyState;->next:Landroid/view/InputEventConsistencyVerifier$KeyState;

    iput-object v3, v0, Landroid/view/InputEventConsistencyVerifier$KeyState;->next:Landroid/view/InputEventConsistencyVerifier$KeyState;

    .line 680
    :goto_1a
    iput-object v2, v1, Landroid/view/InputEventConsistencyVerifier$KeyState;->next:Landroid/view/InputEventConsistencyVerifier$KeyState;

    .line 687
    .end local v1           #state:Landroid/view/InputEventConsistencyVerifier$KeyState;
    :cond_1c
    :goto_1c
    return-object v1

    .line 678
    .restart local v1       #state:Landroid/view/InputEventConsistencyVerifier$KeyState;
    :cond_1d
    iget-object v3, v1, Landroid/view/InputEventConsistencyVerifier$KeyState;->next:Landroid/view/InputEventConsistencyVerifier$KeyState;

    iput-object v3, p0, Landroid/view/InputEventConsistencyVerifier;->mKeyStateList:Landroid/view/InputEventConsistencyVerifier$KeyState;

    goto :goto_1a

    .line 684
    :cond_22
    move-object v0, v1

    .line 685
    iget-object v1, v1, Landroid/view/InputEventConsistencyVerifier$KeyState;->next:Landroid/view/InputEventConsistencyVerifier$KeyState;

    goto :goto_4

    :cond_26
    move-object v1, v2

    .line 687
    goto :goto_1c
.end method

.method private finishEvent()V
    .registers 10

    .prologue
    const/4 v8, 0x0

    const/4 v7, 0x5

    const/4 v6, 0x0

    .line 598
    iget-object v3, p0, Landroid/view/InputEventConsistencyVerifier;->mViolationMessage:Ljava/lang/StringBuilder;

    if-eqz v3, :cond_63

    iget-object v3, p0, Landroid/view/InputEventConsistencyVerifier;->mViolationMessage:Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->length()I

    move-result v3

    if-eqz v3, :cond_63

    .line 599
    iget-object v3, p0, Landroid/view/InputEventConsistencyVerifier;->mCurrentEvent:Landroid/view/InputEvent;

    invoke-virtual {v3}, Landroid/view/InputEvent;->isTainted()Z

    move-result v3

    if-nez v3, :cond_5e

    .line 601
    iget-object v3, p0, Landroid/view/InputEventConsistencyVerifier;->mViolationMessage:Ljava/lang/StringBuilder;

    const-string v4, "\n  in "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Landroid/view/InputEventConsistencyVerifier;->mCaller:Ljava/lang/Object;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 602
    iget-object v3, p0, Landroid/view/InputEventConsistencyVerifier;->mViolationMessage:Ljava/lang/StringBuilder;

    const-string v4, "\n  "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 603
    iget-object v3, p0, Landroid/view/InputEventConsistencyVerifier;->mViolationMessage:Ljava/lang/StringBuilder;

    iget-object v4, p0, Landroid/view/InputEventConsistencyVerifier;->mCurrentEvent:Landroid/view/InputEvent;

    invoke-static {v3, v6, v4, v6}, Landroid/view/InputEventConsistencyVerifier;->appendEvent(Ljava/lang/StringBuilder;ILandroid/view/InputEvent;Z)V

    .line 605
    iget-object v3, p0, Landroid/view/InputEventConsistencyVerifier;->mRecentEvents:[Landroid/view/InputEvent;

    if-eqz v3, :cond_4d

    .line 606
    iget-object v3, p0, Landroid/view/InputEventConsistencyVerifier;->mViolationMessage:Ljava/lang/StringBuilder;

    const-string v4, "\n  -- recent events --"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 607
    const/4 v1, 0x0

    .local v1, i:I
    :goto_3e
    if-ge v1, v7, :cond_4d

    .line 608
    iget v3, p0, Landroid/view/InputEventConsistencyVerifier;->mMostRecentEventIndex:I

    add-int/lit8 v3, v3, 0x5

    sub-int/2addr v3, v1

    rem-int/lit8 v2, v3, 0x5

    .line 610
    .local v2, index:I
    iget-object v3, p0, Landroid/view/InputEventConsistencyVerifier;->mRecentEvents:[Landroid/view/InputEvent;

    aget-object v0, v3, v2

    .line 611
    .local v0, event:Landroid/view/InputEvent;
    if-nez v0, :cond_97

    .line 619
    .end local v0           #event:Landroid/view/InputEvent;
    .end local v1           #i:I
    .end local v2           #index:I
    :cond_4d
    iget-object v3, p0, Landroid/view/InputEventConsistencyVerifier;->mLogTag:Ljava/lang/String;

    iget-object v4, p0, Landroid/view/InputEventConsistencyVerifier;->mViolationMessage:Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 623
    iget-object v3, p0, Landroid/view/InputEventConsistencyVerifier;->mCurrentEvent:Landroid/view/InputEvent;

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Landroid/view/InputEvent;->setTainted(Z)V

    .line 625
    :cond_5e
    iget-object v3, p0, Landroid/view/InputEventConsistencyVerifier;->mViolationMessage:Ljava/lang/StringBuilder;

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->setLength(I)V

    .line 629
    :cond_63
    iget-object v3, p0, Landroid/view/InputEventConsistencyVerifier;->mRecentEvents:[Landroid/view/InputEvent;

    if-nez v3, :cond_6f

    .line 630
    new-array v3, v7, [Landroid/view/InputEvent;

    iput-object v3, p0, Landroid/view/InputEventConsistencyVerifier;->mRecentEvents:[Landroid/view/InputEvent;

    .line 631
    new-array v3, v7, [Z

    iput-object v3, p0, Landroid/view/InputEventConsistencyVerifier;->mRecentEventsUnhandled:[Z

    .line 633
    :cond_6f
    iget v3, p0, Landroid/view/InputEventConsistencyVerifier;->mMostRecentEventIndex:I

    add-int/lit8 v3, v3, 0x1

    rem-int/lit8 v2, v3, 0x5

    .line 634
    .restart local v2       #index:I
    iput v2, p0, Landroid/view/InputEventConsistencyVerifier;->mMostRecentEventIndex:I

    .line 635
    iget-object v3, p0, Landroid/view/InputEventConsistencyVerifier;->mRecentEvents:[Landroid/view/InputEvent;

    aget-object v3, v3, v2

    if-eqz v3, :cond_84

    .line 636
    iget-object v3, p0, Landroid/view/InputEventConsistencyVerifier;->mRecentEvents:[Landroid/view/InputEvent;

    aget-object v3, v3, v2

    invoke-virtual {v3}, Landroid/view/InputEvent;->recycle()V

    .line 638
    :cond_84
    iget-object v3, p0, Landroid/view/InputEventConsistencyVerifier;->mRecentEvents:[Landroid/view/InputEvent;

    iget-object v4, p0, Landroid/view/InputEventConsistencyVerifier;->mCurrentEvent:Landroid/view/InputEvent;

    invoke-virtual {v4}, Landroid/view/InputEvent;->copy()Landroid/view/InputEvent;

    move-result-object v4

    aput-object v4, v3, v2

    .line 639
    iget-object v3, p0, Landroid/view/InputEventConsistencyVerifier;->mRecentEventsUnhandled:[Z

    aput-boolean v6, v3, v2

    .line 642
    iput-object v8, p0, Landroid/view/InputEventConsistencyVerifier;->mCurrentEvent:Landroid/view/InputEvent;

    .line 643
    iput-object v8, p0, Landroid/view/InputEventConsistencyVerifier;->mCurrentEventType:Ljava/lang/String;

    .line 644
    return-void

    .line 614
    .restart local v0       #event:Landroid/view/InputEvent;
    .restart local v1       #i:I
    :cond_97
    iget-object v3, p0, Landroid/view/InputEventConsistencyVerifier;->mViolationMessage:Ljava/lang/StringBuilder;

    const-string v4, "\n  "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 615
    iget-object v3, p0, Landroid/view/InputEventConsistencyVerifier;->mViolationMessage:Ljava/lang/StringBuilder;

    add-int/lit8 v4, v1, 0x1

    iget-object v5, p0, Landroid/view/InputEventConsistencyVerifier;->mRecentEventsUnhandled:[Z

    aget-boolean v5, v5, v2

    invoke-static {v3, v4, v0, v5}, Landroid/view/InputEventConsistencyVerifier;->appendEvent(Ljava/lang/StringBuilder;ILandroid/view/InputEvent;Z)V

    .line 607
    add-int/lit8 v1, v1, 0x1

    goto :goto_3e
.end method

.method public static isInstrumentationEnabled()Z
    .registers 1

    .prologue
    .line 136
    sget-boolean v0, Landroid/view/InputEventConsistencyVerifier;->IS_ENG_BUILD:Z

    return v0
.end method

.method private problem(Ljava/lang/String;)V
    .registers 4
    .parameter "message"

    .prologue
    .line 657
    iget-object v0, p0, Landroid/view/InputEventConsistencyVerifier;->mViolationMessage:Ljava/lang/StringBuilder;

    if-nez v0, :cond_b

    .line 658
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iput-object v0, p0, Landroid/view/InputEventConsistencyVerifier;->mViolationMessage:Ljava/lang/StringBuilder;

    .line 660
    :cond_b
    iget-object v0, p0, Landroid/view/InputEventConsistencyVerifier;->mViolationMessage:Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->length()I

    move-result v0

    if-nez v0, :cond_26

    .line 661
    iget-object v0, p0, Landroid/view/InputEventConsistencyVerifier;->mViolationMessage:Ljava/lang/StringBuilder;

    iget-object v1, p0, Landroid/view/InputEventConsistencyVerifier;->mCurrentEventType:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ": "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 665
    :goto_20
    iget-object v0, p0, Landroid/view/InputEventConsistencyVerifier;->mViolationMessage:Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 666
    return-void

    .line 663
    :cond_26
    iget-object v0, p0, Landroid/view/InputEventConsistencyVerifier;->mViolationMessage:Ljava/lang/StringBuilder;

    const-string v1, "\n  "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_20
.end method

.method private startEvent(Landroid/view/InputEvent;ILjava/lang/String;)Z
    .registers 7
    .parameter "event"
    .parameter "nestingLevel"
    .parameter "eventType"

    .prologue
    const/4 v1, 0x0

    .line 576
    invoke-virtual {p1}, Landroid/view/InputEvent;->getSequenceNumber()I

    move-result v0

    .line 577
    .local v0, seq:I
    iget v2, p0, Landroid/view/InputEventConsistencyVerifier;->mLastEventSeq:I

    if-ne v0, v2, :cond_12

    iget v2, p0, Landroid/view/InputEventConsistencyVerifier;->mLastNestingLevel:I

    if-ge p2, v2, :cond_12

    iget-object v2, p0, Landroid/view/InputEventConsistencyVerifier;->mLastEventType:Ljava/lang/String;

    if-ne p3, v2, :cond_12

    .line 594
    :goto_11
    return v1

    .line 582
    :cond_12
    if-lez p2, :cond_20

    .line 583
    iput v0, p0, Landroid/view/InputEventConsistencyVerifier;->mLastEventSeq:I

    .line 584
    iput-object p3, p0, Landroid/view/InputEventConsistencyVerifier;->mLastEventType:Ljava/lang/String;

    .line 585
    iput p2, p0, Landroid/view/InputEventConsistencyVerifier;->mLastNestingLevel:I

    .line 592
    :goto_1a
    iput-object p1, p0, Landroid/view/InputEventConsistencyVerifier;->mCurrentEvent:Landroid/view/InputEvent;

    .line 593
    iput-object p3, p0, Landroid/view/InputEventConsistencyVerifier;->mCurrentEventType:Ljava/lang/String;

    .line 594
    const/4 v1, 0x1

    goto :goto_11

    .line 587
    :cond_20
    const/4 v2, -0x1

    iput v2, p0, Landroid/view/InputEventConsistencyVerifier;->mLastEventSeq:I

    .line 588
    const/4 v2, 0x0

    iput-object v2, p0, Landroid/view/InputEventConsistencyVerifier;->mLastEventType:Ljava/lang/String;

    .line 589
    iput v1, p0, Landroid/view/InputEventConsistencyVerifier;->mLastNestingLevel:I

    goto :goto_1a
.end method


# virtual methods
.method public onGenericMotionEvent(Landroid/view/MotionEvent;I)V
    .registers 6
    .parameter "event"
    .parameter "nestingLevel"

    .prologue
    .line 460
    const-string v2, "GenericMotionEvent"

    invoke-direct {p0, p1, p2, v2}, Landroid/view/InputEventConsistencyVerifier;->startEvent(Landroid/view/InputEvent;ILjava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_9

    .line 506
    :goto_8
    return-void

    .line 465
    :cond_9
    :try_start_9
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getMetaState()I

    move-result v2

    invoke-direct {p0, v2}, Landroid/view/InputEventConsistencyVerifier;->ensureMetaStateIsNormalized(I)V

    .line 467
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    .line 468
    .local v0, action:I
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getSource()I

    move-result v1

    .line 469
    .local v1, source:I
    and-int/lit8 v2, v1, 0x2

    if-eqz v2, :cond_4f

    .line 470
    packed-switch v0, :pswitch_data_60

    .line 490
    const-string v2, "Invalid action for generic pointer event."

    invoke-direct {p0, v2}, Landroid/view/InputEventConsistencyVerifier;->problem(Ljava/lang/String;)V
    :try_end_24
    .catchall {:try_start_9 .. :try_end_24} :catchall_2f

    .line 504
    :cond_24
    :goto_24
    invoke-direct {p0}, Landroid/view/InputEventConsistencyVerifier;->finishEvent()V

    goto :goto_8

    .line 472
    :pswitch_28
    :try_start_28
    invoke-direct {p0, p1}, Landroid/view/InputEventConsistencyVerifier;->ensurePointerCountIsOneForThisAction(Landroid/view/MotionEvent;)V

    .line 473
    const/4 v2, 0x1

    iput-boolean v2, p0, Landroid/view/InputEventConsistencyVerifier;->mHoverEntered:Z
    :try_end_2e
    .catchall {:try_start_28 .. :try_end_2e} :catchall_2f

    goto :goto_24

    .line 504
    .end local v0           #action:I
    .end local v1           #source:I
    :catchall_2f
    move-exception v2

    invoke-direct {p0}, Landroid/view/InputEventConsistencyVerifier;->finishEvent()V

    throw v2

    .line 476
    .restart local v0       #action:I
    .restart local v1       #source:I
    :pswitch_34
    :try_start_34
    invoke-direct {p0, p1}, Landroid/view/InputEventConsistencyVerifier;->ensurePointerCountIsOneForThisAction(Landroid/view/MotionEvent;)V

    goto :goto_24

    .line 479
    :pswitch_38
    invoke-direct {p0, p1}, Landroid/view/InputEventConsistencyVerifier;->ensurePointerCountIsOneForThisAction(Landroid/view/MotionEvent;)V

    .line 480
    iget-boolean v2, p0, Landroid/view/InputEventConsistencyVerifier;->mHoverEntered:Z

    if-nez v2, :cond_44

    .line 481
    const-string v2, "ACTION_HOVER_EXIT without prior ACTION_HOVER_ENTER"

    invoke-direct {p0, v2}, Landroid/view/InputEventConsistencyVerifier;->problem(Ljava/lang/String;)V

    .line 483
    :cond_44
    const/4 v2, 0x0

    iput-boolean v2, p0, Landroid/view/InputEventConsistencyVerifier;->mHoverEntered:Z

    goto :goto_24

    .line 486
    :pswitch_48
    invoke-direct {p0, p1}, Landroid/view/InputEventConsistencyVerifier;->ensureHistorySizeIsZeroForThisAction(Landroid/view/MotionEvent;)V

    .line 487
    invoke-direct {p0, p1}, Landroid/view/InputEventConsistencyVerifier;->ensurePointerCountIsOneForThisAction(Landroid/view/MotionEvent;)V

    goto :goto_24

    .line 493
    :cond_4f
    and-int/lit8 v2, v1, 0x10

    if-eqz v2, :cond_24

    .line 494
    packed-switch v0, :pswitch_data_6c

    .line 499
    const-string v2, "Invalid action for generic joystick event."

    invoke-direct {p0, v2}, Landroid/view/InputEventConsistencyVerifier;->problem(Ljava/lang/String;)V

    goto :goto_24

    .line 496
    :pswitch_5c
    invoke-direct {p0, p1}, Landroid/view/InputEventConsistencyVerifier;->ensurePointerCountIsOneForThisAction(Landroid/view/MotionEvent;)V
    :try_end_5f
    .catchall {:try_start_34 .. :try_end_5f} :catchall_2f

    goto :goto_24

    .line 470
    :pswitch_data_60
    .packed-switch 0x7
        :pswitch_34
        :pswitch_48
        :pswitch_28
        :pswitch_38
    .end packed-switch

    .line 494
    :pswitch_data_6c
    .packed-switch 0x2
        :pswitch_5c
    .end packed-switch
.end method

.method public onInputEvent(Landroid/view/InputEvent;I)V
    .registers 6
    .parameter "event"
    .parameter "nestingLevel"

    .prologue
    .line 169
    instance-of v2, p1, Landroid/view/KeyEvent;

    if-eqz v2, :cond_b

    move-object v0, p1

    .line 170
    check-cast v0, Landroid/view/KeyEvent;

    .line 171
    .local v0, keyEvent:Landroid/view/KeyEvent;
    invoke-virtual {p0, v0, p2}, Landroid/view/InputEventConsistencyVerifier;->onKeyEvent(Landroid/view/KeyEvent;I)V

    .line 182
    .end local v0           #keyEvent:Landroid/view/KeyEvent;
    :goto_a
    return-void

    :cond_b
    move-object v1, p1

    .line 173
    check-cast v1, Landroid/view/MotionEvent;

    .line 174
    .local v1, motionEvent:Landroid/view/MotionEvent;
    invoke-virtual {v1}, Landroid/view/MotionEvent;->isTouchEvent()Z

    move-result v2

    if-eqz v2, :cond_18

    .line 175
    invoke-virtual {p0, v1, p2}, Landroid/view/InputEventConsistencyVerifier;->onTouchEvent(Landroid/view/MotionEvent;I)V

    goto :goto_a

    .line 176
    :cond_18
    invoke-virtual {v1}, Landroid/view/MotionEvent;->getSource()I

    move-result v2

    and-int/lit8 v2, v2, 0x4

    if-eqz v2, :cond_24

    .line 177
    invoke-virtual {p0, v1, p2}, Landroid/view/InputEventConsistencyVerifier;->onTrackballEvent(Landroid/view/MotionEvent;I)V

    goto :goto_a

    .line 179
    :cond_24
    invoke-virtual {p0, v1, p2}, Landroid/view/InputEventConsistencyVerifier;->onGenericMotionEvent(Landroid/view/MotionEvent;I)V

    goto :goto_a
.end method

.method public onKeyEvent(Landroid/view/KeyEvent;I)V
    .registers 10
    .parameter "event"
    .parameter "nestingLevel"

    .prologue
    .line 194
    const-string v5, "KeyEvent"

    invoke-direct {p0, p1, p2, v5}, Landroid/view/InputEventConsistencyVerifier;->startEvent(Landroid/view/InputEvent;ILjava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_9

    .line 244
    :goto_8
    return-void

    .line 199
    :cond_9
    :try_start_9
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getMetaState()I

    move-result v5

    invoke-direct {p0, v5}, Landroid/view/InputEventConsistencyVerifier;->ensureMetaStateIsNormalized(I)V

    .line 201
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v0

    .line 202
    .local v0, action:I
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getDeviceId()I

    move-result v1

    .line 203
    .local v1, deviceId:I
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getSource()I

    move-result v3

    .line 204
    .local v3, source:I
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v2

    .line 205
    .local v2, keyCode:I
    packed-switch v0, :pswitch_data_82

    .line 237
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Invalid action "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-static {v0}, Landroid/view/KeyEvent;->actionToString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " for key event."

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {p0, v5}, Landroid/view/InputEventConsistencyVerifier;->problem(Ljava/lang/String;)V
    :try_end_43
    .catchall {:try_start_9 .. :try_end_43} :catchall_56

    .line 242
    :cond_43
    :goto_43
    :pswitch_43
    invoke-direct {p0}, Landroid/view/InputEventConsistencyVerifier;->finishEvent()V

    goto :goto_8

    .line 207
    :pswitch_47
    const/4 v5, 0x0

    :try_start_48
    invoke-direct {p0, v1, v3, v2, v5}, Landroid/view/InputEventConsistencyVerifier;->findKeyState(IIIZ)Landroid/view/InputEventConsistencyVerifier$KeyState;

    move-result-object v4

    .line 208
    .local v4, state:Landroid/view/InputEventConsistencyVerifier$KeyState;
    if-eqz v4, :cond_6d

    .line 213
    iget-boolean v5, v4, Landroid/view/InputEventConsistencyVerifier$KeyState;->unhandled:Z

    if-eqz v5, :cond_5b

    .line 214
    const/4 v5, 0x0

    iput-boolean v5, v4, Landroid/view/InputEventConsistencyVerifier$KeyState;->unhandled:Z
    :try_end_55
    .catchall {:try_start_48 .. :try_end_55} :catchall_56

    goto :goto_43

    .line 242
    .end local v0           #action:I
    .end local v1           #deviceId:I
    .end local v2           #keyCode:I
    .end local v3           #source:I
    .end local v4           #state:Landroid/view/InputEventConsistencyVerifier$KeyState;
    :catchall_56
    move-exception v5

    invoke-direct {p0}, Landroid/view/InputEventConsistencyVerifier;->finishEvent()V

    throw v5

    .line 215
    .restart local v0       #action:I
    .restart local v1       #deviceId:I
    .restart local v2       #keyCode:I
    .restart local v3       #source:I
    .restart local v4       #state:Landroid/view/InputEventConsistencyVerifier$KeyState;
    :cond_5b
    :try_start_5b
    iget v5, p0, Landroid/view/InputEventConsistencyVerifier;->mFlags:I

    and-int/lit8 v5, v5, 0x1

    if-nez v5, :cond_43

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getRepeatCount()I

    move-result v5

    if-nez v5, :cond_43

    .line 217
    const-string v5, "ACTION_DOWN but key is already down and this event is not a key repeat."

    invoke-direct {p0, v5}, Landroid/view/InputEventConsistencyVerifier;->problem(Ljava/lang/String;)V

    goto :goto_43

    .line 221
    :cond_6d
    invoke-direct {p0, v1, v3, v2}, Landroid/view/InputEventConsistencyVerifier;->addKeyState(III)V

    goto :goto_43

    .line 226
    .end local v4           #state:Landroid/view/InputEventConsistencyVerifier$KeyState;
    :pswitch_71
    const/4 v5, 0x1

    invoke-direct {p0, v1, v3, v2, v5}, Landroid/view/InputEventConsistencyVerifier;->findKeyState(IIIZ)Landroid/view/InputEventConsistencyVerifier$KeyState;

    move-result-object v4

    .line 227
    .restart local v4       #state:Landroid/view/InputEventConsistencyVerifier$KeyState;
    if-nez v4, :cond_7e

    .line 228
    const-string v5, "ACTION_UP but key was not down."

    invoke-direct {p0, v5}, Landroid/view/InputEventConsistencyVerifier;->problem(Ljava/lang/String;)V

    goto :goto_43

    .line 230
    :cond_7e
    invoke-virtual {v4}, Landroid/view/InputEventConsistencyVerifier$KeyState;->recycle()V
    :try_end_81
    .catchall {:try_start_5b .. :try_end_81} :catchall_56

    goto :goto_43

    .line 205
    :pswitch_data_82
    .packed-switch 0x0
        :pswitch_47
        :pswitch_71
        :pswitch_43
    .end packed-switch
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;I)V
    .registers 16
    .parameter "event"
    .parameter "nestingLevel"

    .prologue
    const/4 v10, 0x0

    const/4 v11, 0x1

    .line 319
    const-string v12, "TouchEvent"

    invoke-direct {p0, p1, p2, v12}, Landroid/view/InputEventConsistencyVerifier;->startEvent(Landroid/view/InputEvent;ILjava/lang/String;)Z

    move-result v12

    if-nez v12, :cond_b

    .line 448
    :goto_a
    return-void

    .line 323
    :cond_b
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    .line 324
    .local v0, action:I
    if-eqz v0, :cond_14

    const/4 v12, 0x3

    if-ne v0, v12, :cond_e5

    :cond_14
    move v7, v11

    .line 326
    .local v7, newStream:Z
    :goto_15
    if-eqz v7, :cond_25

    iget-boolean v12, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamIsTainted:Z

    if-nez v12, :cond_1f

    iget-boolean v12, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamUnhandled:Z

    if-eqz v12, :cond_25

    .line 327
    :cond_1f
    iput-boolean v10, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamIsTainted:Z

    .line 328
    iput-boolean v10, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamUnhandled:Z

    .line 329
    iput v10, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamPointers:I

    .line 331
    :cond_25
    iget-boolean v10, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamIsTainted:Z

    if-eqz v10, :cond_2c

    .line 332
    invoke-virtual {p1, v11}, Landroid/view/MotionEvent;->setTainted(Z)V

    .line 336
    :cond_2c
    :try_start_2c
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getMetaState()I

    move-result v10

    invoke-direct {p0, v10}, Landroid/view/InputEventConsistencyVerifier;->ensureMetaStateIsNormalized(I)V

    .line 338
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getDeviceId()I

    move-result v3

    .line 339
    .local v3, deviceId:I
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getSource()I

    move-result v9

    .line 341
    .local v9, source:I
    if-nez v7, :cond_8a

    iget v10, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamDeviceId:I

    const/4 v12, -0x1

    if-eq v10, v12, :cond_8a

    iget v10, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamDeviceId:I

    if-ne v10, v3, :cond_4a

    iget v10, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamSource:I

    if-eq v10, v9, :cond_8a

    .line 344
    :cond_4a
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "Touch event stream contains events from multiple sources: previous device id "

    invoke-virtual {v10, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    iget v12, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamDeviceId:I

    invoke-virtual {v10, v12}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v12, ", previous source "

    invoke-virtual {v10, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    iget v12, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamSource:I

    invoke-static {v12}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v10, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v12, ", new device id "

    invoke-virtual {v10, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v12, ", new source "

    invoke-virtual {v10, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-static {v9}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v10, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {p0, v10}, Landroid/view/InputEventConsistencyVerifier;->problem(Ljava/lang/String;)V

    .line 350
    :cond_8a
    iput v3, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamDeviceId:I

    .line 351
    iput v9, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamSource:I

    .line 353
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result v8

    .line 354
    .local v8, pointerCount:I
    and-int/lit8 v10, v9, 0x2

    if-eqz v10, :cond_21c

    .line 355
    packed-switch v0, :pswitch_data_224

    .line 395
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v2

    .line 396
    .local v2, actionMasked:I
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionIndex()I

    move-result v1

    .line 397
    .local v1, actionIndex:I
    const/4 v10, 0x5

    if-ne v2, v10, :cond_192

    .line 398
    iget v10, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamPointers:I

    if-nez v10, :cond_b0

    .line 399
    const-string v10, "ACTION_POINTER_DOWN but no other pointers were down."

    invoke-direct {p0, v10}, Landroid/view/InputEventConsistencyVerifier;->problem(Ljava/lang/String;)V

    .line 400
    const/4 v10, 0x1

    iput-boolean v10, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamIsTainted:Z

    .line 402
    :cond_b0
    if-ltz v1, :cond_b4

    if-lt v1, v8, :cond_15f

    .line 403
    :cond_b4
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "ACTION_POINTER_DOWN index is "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, " but the pointer count is "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "."

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {p0, v10}, Landroid/view/InputEventConsistencyVerifier;->problem(Ljava/lang/String;)V

    .line 405
    const/4 v10, 0x1

    iput-boolean v10, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamIsTainted:Z

    .line 417
    :goto_dd
    invoke-direct {p0, p1}, Landroid/view/InputEventConsistencyVerifier;->ensureHistorySizeIsZeroForThisAction(Landroid/view/MotionEvent;)V
    :try_end_e0
    .catchall {:try_start_2c .. :try_end_e0} :catchall_101

    .line 446
    .end local v1           #actionIndex:I
    .end local v2           #actionMasked:I
    :cond_e0
    :goto_e0
    invoke-direct {p0}, Landroid/view/InputEventConsistencyVerifier;->finishEvent()V

    goto/16 :goto_a

    .end local v3           #deviceId:I
    .end local v7           #newStream:Z
    .end local v8           #pointerCount:I
    .end local v9           #source:I
    :cond_e5
    move v7, v10

    .line 324
    goto/16 :goto_15

    .line 357
    .restart local v3       #deviceId:I
    .restart local v7       #newStream:Z
    .restart local v8       #pointerCount:I
    .restart local v9       #source:I
    :pswitch_e8
    :try_start_e8
    iget v10, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamPointers:I

    if-eqz v10, :cond_f1

    .line 358
    const-string v10, "ACTION_DOWN but pointers are already down.  Probably missing ACTION_UP from previous gesture."

    invoke-direct {p0, v10}, Landroid/view/InputEventConsistencyVerifier;->problem(Ljava/lang/String;)V

    .line 361
    :cond_f1
    invoke-direct {p0, p1}, Landroid/view/InputEventConsistencyVerifier;->ensureHistorySizeIsZeroForThisAction(Landroid/view/MotionEvent;)V

    .line 362
    invoke-direct {p0, p1}, Landroid/view/InputEventConsistencyVerifier;->ensurePointerCountIsOneForThisAction(Landroid/view/MotionEvent;)V

    .line 363
    const/4 v10, 0x0

    invoke-virtual {p1, v10}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v10

    shl-int v10, v11, v10

    iput v10, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamPointers:I
    :try_end_100
    .catchall {:try_start_e8 .. :try_end_100} :catchall_101

    goto :goto_e0

    .line 446
    .end local v3           #deviceId:I
    .end local v8           #pointerCount:I
    .end local v9           #source:I
    :catchall_101
    move-exception v10

    invoke-direct {p0}, Landroid/view/InputEventConsistencyVerifier;->finishEvent()V

    throw v10

    .line 366
    .restart local v3       #deviceId:I
    .restart local v8       #pointerCount:I
    .restart local v9       #source:I
    :pswitch_106
    :try_start_106
    invoke-direct {p0, p1}, Landroid/view/InputEventConsistencyVerifier;->ensureHistorySizeIsZeroForThisAction(Landroid/view/MotionEvent;)V

    .line 367
    invoke-direct {p0, p1}, Landroid/view/InputEventConsistencyVerifier;->ensurePointerCountIsOneForThisAction(Landroid/view/MotionEvent;)V

    .line 368
    const/4 v10, 0x0

    iput v10, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamPointers:I

    .line 369
    const/4 v10, 0x0

    iput-boolean v10, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamIsTainted:Z

    goto :goto_e0

    .line 372
    :pswitch_113
    iget v10, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamPointers:I

    invoke-static {v10}, Ljava/lang/Integer;->bitCount(I)I

    move-result v4

    .line 374
    .local v4, expectedPointerCount:I
    if-eq v8, v4, :cond_e0

    .line 375
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "ACTION_MOVE contained "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, " pointers but there are currently "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, " pointers down."

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {p0, v10}, Landroid/view/InputEventConsistencyVerifier;->problem(Ljava/lang/String;)V

    .line 378
    const/4 v10, 0x1

    iput-boolean v10, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamIsTainted:Z

    goto :goto_e0

    .line 383
    .end local v4           #expectedPointerCount:I
    :pswitch_145
    const/4 v10, 0x0

    iput v10, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamPointers:I

    .line 384
    const/4 v10, 0x0

    iput-boolean v10, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamIsTainted:Z

    goto :goto_e0

    .line 387
    :pswitch_14c
    iget v10, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamPointers:I

    if-eqz v10, :cond_155

    .line 388
    const-string v10, "ACTION_OUTSIDE but pointers are still down."

    invoke-direct {p0, v10}, Landroid/view/InputEventConsistencyVerifier;->problem(Ljava/lang/String;)V

    .line 390
    :cond_155
    invoke-direct {p0, p1}, Landroid/view/InputEventConsistencyVerifier;->ensureHistorySizeIsZeroForThisAction(Landroid/view/MotionEvent;)V

    .line 391
    invoke-direct {p0, p1}, Landroid/view/InputEventConsistencyVerifier;->ensurePointerCountIsOneForThisAction(Landroid/view/MotionEvent;)V

    .line 392
    const/4 v10, 0x0

    iput-boolean v10, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamIsTainted:Z

    goto :goto_e0

    .line 407
    .restart local v1       #actionIndex:I
    .restart local v2       #actionMasked:I
    :cond_15f
    invoke-virtual {p1, v1}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v5

    .line 408
    .local v5, id:I
    shl-int v6, v11, v5

    .line 409
    .local v6, idBit:I
    iget v10, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamPointers:I

    and-int/2addr v10, v6

    if-eqz v10, :cond_18b

    .line 410
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "ACTION_POINTER_DOWN specified pointer id "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, " which is already down."

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {p0, v10}, Landroid/view/InputEventConsistencyVerifier;->problem(Ljava/lang/String;)V

    .line 412
    const/4 v10, 0x1

    iput-boolean v10, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamIsTainted:Z

    goto/16 :goto_dd

    .line 414
    :cond_18b
    iget v10, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamPointers:I

    or-int/2addr v10, v6

    iput v10, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamPointers:I

    goto/16 :goto_dd

    .line 418
    .end local v5           #id:I
    .end local v6           #idBit:I
    :cond_192
    const/4 v10, 0x6

    if-ne v2, v10, :cond_1fa

    .line 419
    if-ltz v1, :cond_199

    if-lt v1, v8, :cond_1c7

    .line 420
    :cond_199
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "ACTION_POINTER_UP index is "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, " but the pointer count is "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "."

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {p0, v10}, Landroid/view/InputEventConsistencyVerifier;->problem(Ljava/lang/String;)V

    .line 422
    const/4 v10, 0x1

    iput-boolean v10, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamIsTainted:Z

    .line 434
    :goto_1c2
    invoke-direct {p0, p1}, Landroid/view/InputEventConsistencyVerifier;->ensureHistorySizeIsZeroForThisAction(Landroid/view/MotionEvent;)V

    goto/16 :goto_e0

    .line 424
    :cond_1c7
    invoke-virtual {p1, v1}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v5

    .line 425
    .restart local v5       #id:I
    shl-int v6, v11, v5

    .line 426
    .restart local v6       #idBit:I
    iget v10, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamPointers:I

    and-int/2addr v10, v6

    if-nez v10, :cond_1f2

    .line 427
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "ACTION_POINTER_UP specified pointer id "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, " which is not currently down."

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {p0, v10}, Landroid/view/InputEventConsistencyVerifier;->problem(Ljava/lang/String;)V

    .line 429
    const/4 v10, 0x1

    iput-boolean v10, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamIsTainted:Z

    goto :goto_1c2

    .line 431
    :cond_1f2
    iget v10, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamPointers:I

    xor-int/lit8 v11, v6, -0x1

    and-int/2addr v10, v11

    iput v10, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamPointers:I

    goto :goto_1c2

    .line 436
    .end local v5           #id:I
    .end local v6           #idBit:I
    :cond_1fa
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "Invalid action "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-static {v0}, Landroid/view/MotionEvent;->actionToString(I)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, " for touch event."

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {p0, v10}, Landroid/view/InputEventConsistencyVerifier;->problem(Ljava/lang/String;)V

    goto/16 :goto_e0

    .line 443
    .end local v1           #actionIndex:I
    .end local v2           #actionMasked:I
    :cond_21c
    const-string v10, "Source was not SOURCE_CLASS_POINTER."

    invoke-direct {p0, v10}, Landroid/view/InputEventConsistencyVerifier;->problem(Ljava/lang/String;)V
    :try_end_221
    .catchall {:try_start_106 .. :try_end_221} :catchall_101

    goto/16 :goto_e0

    .line 355
    nop

    :pswitch_data_224
    .packed-switch 0x0
        :pswitch_e8
        :pswitch_106
        :pswitch_113
        :pswitch_145
        :pswitch_14c
    .end packed-switch
.end method

.method public onTrackballEvent(Landroid/view/MotionEvent;I)V
    .registers 8
    .parameter "event"
    .parameter "nestingLevel"

    .prologue
    const/4 v4, 0x0

    .line 256
    const-string v2, "TrackballEvent"

    invoke-direct {p0, p1, p2, v2}, Landroid/view/InputEventConsistencyVerifier;->startEvent(Landroid/view/InputEvent;ILjava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_a

    .line 307
    :goto_9
    return-void

    .line 261
    :cond_a
    :try_start_a
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getMetaState()I

    move-result v2

    invoke-direct {p0, v2}, Landroid/view/InputEventConsistencyVerifier;->ensureMetaStateIsNormalized(I)V

    .line 263
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    .line 264
    .local v0, action:I
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getSource()I

    move-result v1

    .line 265
    .local v1, source:I
    and-int/lit8 v2, v1, 0x4

    if-eqz v2, :cond_a2

    .line 266
    packed-switch v0, :pswitch_data_a8

    .line 291
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Invalid action "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {v0}, Landroid/view/MotionEvent;->actionToString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " for trackball event."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v2}, Landroid/view/InputEventConsistencyVerifier;->problem(Ljava/lang/String;)V

    .line 296
    :goto_40
    iget-boolean v2, p0, Landroid/view/InputEventConsistencyVerifier;->mTrackballDown:Z

    if-eqz v2, :cond_90

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getPressure()F

    move-result v2

    cmpg-float v2, v2, v4

    if-gtz v2, :cond_90

    .line 297
    const-string v2, "Trackball is down but pressure is not greater than 0."

    invoke-direct {p0, v2}, Landroid/view/InputEventConsistencyVerifier;->problem(Ljava/lang/String;)V
    :try_end_51
    .catchall {:try_start_a .. :try_end_51} :catchall_69

    .line 305
    :cond_51
    :goto_51
    invoke-direct {p0}, Landroid/view/InputEventConsistencyVerifier;->finishEvent()V

    goto :goto_9

    .line 268
    :pswitch_55
    :try_start_55
    iget-boolean v2, p0, Landroid/view/InputEventConsistencyVerifier;->mTrackballDown:Z

    if-eqz v2, :cond_6e

    iget-boolean v2, p0, Landroid/view/InputEventConsistencyVerifier;->mTrackballUnhandled:Z

    if-nez v2, :cond_6e

    .line 269
    const-string v2, "ACTION_DOWN but trackball is already down."

    invoke-direct {p0, v2}, Landroid/view/InputEventConsistencyVerifier;->problem(Ljava/lang/String;)V

    .line 274
    :goto_62
    invoke-direct {p0, p1}, Landroid/view/InputEventConsistencyVerifier;->ensureHistorySizeIsZeroForThisAction(Landroid/view/MotionEvent;)V

    .line 275
    invoke-direct {p0, p1}, Landroid/view/InputEventConsistencyVerifier;->ensurePointerCountIsOneForThisAction(Landroid/view/MotionEvent;)V
    :try_end_68
    .catchall {:try_start_55 .. :try_end_68} :catchall_69

    goto :goto_40

    .line 305
    .end local v0           #action:I
    .end local v1           #source:I
    :catchall_69
    move-exception v2

    invoke-direct {p0}, Landroid/view/InputEventConsistencyVerifier;->finishEvent()V

    throw v2

    .line 271
    .restart local v0       #action:I
    .restart local v1       #source:I
    :cond_6e
    const/4 v2, 0x1

    :try_start_6f
    iput-boolean v2, p0, Landroid/view/InputEventConsistencyVerifier;->mTrackballDown:Z

    .line 272
    const/4 v2, 0x0

    iput-boolean v2, p0, Landroid/view/InputEventConsistencyVerifier;->mTrackballUnhandled:Z

    goto :goto_62

    .line 278
    :pswitch_75
    iget-boolean v2, p0, Landroid/view/InputEventConsistencyVerifier;->mTrackballDown:Z

    if-nez v2, :cond_85

    .line 279
    const-string v2, "ACTION_UP but trackball is not down."

    invoke-direct {p0, v2}, Landroid/view/InputEventConsistencyVerifier;->problem(Ljava/lang/String;)V

    .line 284
    :goto_7e
    invoke-direct {p0, p1}, Landroid/view/InputEventConsistencyVerifier;->ensureHistorySizeIsZeroForThisAction(Landroid/view/MotionEvent;)V

    .line 285
    invoke-direct {p0, p1}, Landroid/view/InputEventConsistencyVerifier;->ensurePointerCountIsOneForThisAction(Landroid/view/MotionEvent;)V

    goto :goto_40

    .line 281
    :cond_85
    const/4 v2, 0x0

    iput-boolean v2, p0, Landroid/view/InputEventConsistencyVerifier;->mTrackballDown:Z

    .line 282
    const/4 v2, 0x0

    iput-boolean v2, p0, Landroid/view/InputEventConsistencyVerifier;->mTrackballUnhandled:Z

    goto :goto_7e

    .line 288
    :pswitch_8c
    invoke-direct {p0, p1}, Landroid/view/InputEventConsistencyVerifier;->ensurePointerCountIsOneForThisAction(Landroid/view/MotionEvent;)V

    goto :goto_40

    .line 298
    :cond_90
    iget-boolean v2, p0, Landroid/view/InputEventConsistencyVerifier;->mTrackballDown:Z

    if-nez v2, :cond_51

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getPressure()F

    move-result v2

    cmpl-float v2, v2, v4

    if-eqz v2, :cond_51

    .line 299
    const-string v2, "Trackball is up but pressure is not equal to 0."

    invoke-direct {p0, v2}, Landroid/view/InputEventConsistencyVerifier;->problem(Ljava/lang/String;)V

    goto :goto_51

    .line 302
    :cond_a2
    const-string v2, "Source was not SOURCE_CLASS_TRACKBALL."

    invoke-direct {p0, v2}, Landroid/view/InputEventConsistencyVerifier;->problem(Ljava/lang/String;)V
    :try_end_a7
    .catchall {:try_start_6f .. :try_end_a7} :catchall_69

    goto :goto_51

    .line 266
    :pswitch_data_a8
    .packed-switch 0x0
        :pswitch_55
        :pswitch_75
        :pswitch_8c
    .end packed-switch
.end method

.method public onUnhandledEvent(Landroid/view/InputEvent;I)V
    .registers 12
    .parameter "event"
    .parameter "nestingLevel"

    .prologue
    const/4 v8, 0x1

    .line 521
    iget v6, p0, Landroid/view/InputEventConsistencyVerifier;->mLastNestingLevel:I

    if-eq p2, v6, :cond_6

    .line 548
    :cond_5
    :goto_5
    return-void

    .line 525
    :cond_6
    iget-object v6, p0, Landroid/view/InputEventConsistencyVerifier;->mRecentEventsUnhandled:[Z

    if-eqz v6, :cond_10

    .line 526
    iget-object v6, p0, Landroid/view/InputEventConsistencyVerifier;->mRecentEventsUnhandled:[Z

    iget v7, p0, Landroid/view/InputEventConsistencyVerifier;->mMostRecentEventIndex:I

    aput-boolean v8, v6, v7

    .line 529
    :cond_10
    instance-of v6, p1, Landroid/view/KeyEvent;

    if-eqz v6, :cond_2d

    move-object v2, p1

    .line 530
    check-cast v2, Landroid/view/KeyEvent;

    .line 531
    .local v2, keyEvent:Landroid/view/KeyEvent;
    invoke-virtual {v2}, Landroid/view/KeyEvent;->getDeviceId()I

    move-result v0

    .line 532
    .local v0, deviceId:I
    invoke-virtual {v2}, Landroid/view/KeyEvent;->getSource()I

    move-result v4

    .line 533
    .local v4, source:I
    invoke-virtual {v2}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v1

    .line 534
    .local v1, keyCode:I
    const/4 v6, 0x0

    invoke-direct {p0, v0, v4, v1, v6}, Landroid/view/InputEventConsistencyVerifier;->findKeyState(IIIZ)Landroid/view/InputEventConsistencyVerifier$KeyState;

    move-result-object v5

    .line 535
    .local v5, state:Landroid/view/InputEventConsistencyVerifier$KeyState;
    if-eqz v5, :cond_5

    .line 536
    iput-boolean v8, v5, Landroid/view/InputEventConsistencyVerifier$KeyState;->unhandled:Z

    goto :goto_5

    .end local v0           #deviceId:I
    .end local v1           #keyCode:I
    .end local v2           #keyEvent:Landroid/view/KeyEvent;
    .end local v4           #source:I
    .end local v5           #state:Landroid/view/InputEventConsistencyVerifier$KeyState;
    :cond_2d
    move-object v3, p1

    .line 539
    check-cast v3, Landroid/view/MotionEvent;

    .line 540
    .local v3, motionEvent:Landroid/view/MotionEvent;
    invoke-virtual {v3}, Landroid/view/MotionEvent;->isTouchEvent()Z

    move-result v6

    if-eqz v6, :cond_39

    .line 541
    iput-boolean v8, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamUnhandled:Z

    goto :goto_5

    .line 542
    :cond_39
    invoke-virtual {v3}, Landroid/view/MotionEvent;->getSource()I

    move-result v6

    and-int/lit8 v6, v6, 0x4

    if-eqz v6, :cond_5

    .line 543
    iget-boolean v6, p0, Landroid/view/InputEventConsistencyVerifier;->mTrackballDown:Z

    if-eqz v6, :cond_5

    .line 544
    iput-boolean v8, p0, Landroid/view/InputEventConsistencyVerifier;->mTrackballUnhandled:Z

    goto :goto_5
.end method

.method public reset()V
    .registers 4

    .prologue
    const/4 v2, 0x0

    .line 143
    const/4 v1, -0x1

    iput v1, p0, Landroid/view/InputEventConsistencyVerifier;->mLastEventSeq:I

    .line 144
    iput v2, p0, Landroid/view/InputEventConsistencyVerifier;->mLastNestingLevel:I

    .line 145
    iput-boolean v2, p0, Landroid/view/InputEventConsistencyVerifier;->mTrackballDown:Z

    .line 146
    iput-boolean v2, p0, Landroid/view/InputEventConsistencyVerifier;->mTrackballUnhandled:Z

    .line 147
    iput v2, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamPointers:I

    .line 148
    iput-boolean v2, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamIsTainted:Z

    .line 149
    iput-boolean v2, p0, Landroid/view/InputEventConsistencyVerifier;->mTouchEventStreamUnhandled:Z

    .line 150
    iput-boolean v2, p0, Landroid/view/InputEventConsistencyVerifier;->mHoverEntered:Z

    .line 152
    :goto_12
    iget-object v1, p0, Landroid/view/InputEventConsistencyVerifier;->mKeyStateList:Landroid/view/InputEventConsistencyVerifier$KeyState;

    if-eqz v1, :cond_20

    .line 153
    iget-object v0, p0, Landroid/view/InputEventConsistencyVerifier;->mKeyStateList:Landroid/view/InputEventConsistencyVerifier$KeyState;

    .line 154
    .local v0, state:Landroid/view/InputEventConsistencyVerifier$KeyState;
    iget-object v1, v0, Landroid/view/InputEventConsistencyVerifier$KeyState;->next:Landroid/view/InputEventConsistencyVerifier$KeyState;

    iput-object v1, p0, Landroid/view/InputEventConsistencyVerifier;->mKeyStateList:Landroid/view/InputEventConsistencyVerifier$KeyState;

    .line 155
    invoke-virtual {v0}, Landroid/view/InputEventConsistencyVerifier$KeyState;->recycle()V

    goto :goto_12

    .line 157
    .end local v0           #state:Landroid/view/InputEventConsistencyVerifier$KeyState;
    :cond_20
    return-void
.end method
