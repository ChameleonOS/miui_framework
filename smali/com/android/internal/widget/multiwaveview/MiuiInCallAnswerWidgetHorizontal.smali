.class public Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;
.super Lcom/android/internal/widget/multiwaveview/GlowPadView;
.source "MiuiInCallAnswerWidgetHorizontal.java"


# static fields
.field private static final HIDE_ANIMATION_DELAY:I = 0xc8

.field private static final HIDE_ANIMATION_DURATION:I = 0xc8

.field private static final HIDE_TARGET_LIGHT_DELAY:I = 0x14

.field private static final RETURN_TO_HOME_DELAY:I = 0x4b0

.field private static final RETURN_TO_HOME_DURATION:I = 0x12c

.field private static final SHOW_ANIMATION_DELAY:I = 0xc8

.field private static final SHOW_ANIMATION_DURATION:I = 0xc8

.field private static final SHOW_HINT_ANIMATION_DELAY:I = 0xc8

.field private static final SHOW_HINT_ANIMATION_DURATION:I = 0x5dc

.field private static final SHOW_HINT_DELAY:I = 0x190

.field private static final SHOW_HINT_DURATION:I = 0x12c

.field private static final SHOW_OUTERRING_DELAY:I = 0xc8

.field private static final SHOW_OUTERRING_DURATION:I = 0x12c

.field private static final SHOW_TARGET_LIGHT_DELAY:I = 0x14

.field private static final STATE_ANSWER:I = 0x7

.field public static final STATE_ANSWER_HANDLE:[I = null

.field private static final STATE_DECLINE:I = 0x6

.field public static final STATE_DECLINE_HANDLE:[I = null

.field private static final STATE_FINISH:I = 0x5

.field private static final STATE_FIRST_TOUCH:I = 0x2

.field public static final STATE_HINT_ANIM:[[I = null

.field private static final STATE_IDLE:I = 0x0

.field private static final STATE_SNAP:I = 0x4

.field private static final STATE_TRACKING:I = 0x3


# instance fields
.field private mCurrentTargetLight:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

.field private mHandleAnimation:Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;

.field private mHintAnimation:Landroid/animation/ValueAnimator;

.field private mOuterRingAnimation:Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;

.field private mOuterRingListener:Landroid/animation/Animator$AnimatorListener;

.field private mRightHintAnimTargetDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

.field private mShowingOuterRing:Z

.field private mTargetLightAnimations:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/internal/widget/multiwaveview/Tweener;",
            ">;"
        }
    .end annotation
.end field

.field private mTargetLightDrawables:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/internal/widget/multiwaveview/TargetDrawable;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 4

    .prologue
    const/4 v3, 0x3

    .line 51
    new-array v0, v3, [I

    fill-array-data v0, :array_4c

    sput-object v0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->STATE_DECLINE_HANDLE:[I

    .line 53
    new-array v0, v3, [I

    fill-array-data v0, :array_56

    sput-object v0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->STATE_ANSWER_HANDLE:[I

    .line 56
    const/4 v0, 0x7

    new-array v0, v0, [[I

    const/4 v1, 0x0

    new-array v2, v3, [I

    fill-array-data v2, :array_60

    aput-object v2, v0, v1

    const/4 v1, 0x1

    new-array v2, v3, [I

    fill-array-data v2, :array_6a

    aput-object v2, v0, v1

    const/4 v1, 0x2

    new-array v2, v3, [I

    fill-array-data v2, :array_74

    aput-object v2, v0, v1

    new-array v1, v3, [I

    fill-array-data v1, :array_7e

    aput-object v1, v0, v3

    const/4 v1, 0x4

    new-array v2, v3, [I

    fill-array-data v2, :array_88

    aput-object v2, v0, v1

    const/4 v1, 0x5

    new-array v2, v3, [I

    fill-array-data v2, :array_92

    aput-object v2, v0, v1

    const/4 v1, 0x6

    new-array v2, v3, [I

    fill-array-data v2, :array_9c

    aput-object v2, v0, v1

    sput-object v0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->STATE_HINT_ANIM:[[I

    return-void

    .line 51
    :array_4c
    .array-data 0x4
        0x9et 0x0t 0x1t 0x1t
        0x5et 0xfft 0xfet 0xfet
        0x9ct 0x0t 0x1t 0x1t
    .end array-data

    .line 53
    :array_56
    .array-data 0x4
        0x9et 0x0t 0x1t 0x1t
        0xa2t 0x0t 0x1t 0x1t
        0x9ct 0x0t 0x1t 0x1t
    .end array-data

    .line 56
    :array_60
    .array-data 0x4
        0x9et 0x0t 0x1t 0x1t
        0x5et 0xfft 0xfet 0xfet
        0x64t 0xfft 0xfet 0xfet
    .end array-data

    :array_6a
    .array-data 0x4
        0x62t 0xfft 0xfet 0xfet
        0xa2t 0x0t 0x1t 0x1t
        0x64t 0xfft 0xfet 0xfet
    .end array-data

    :array_74
    .array-data 0x4
        0x62t 0xfft 0xfet 0xfet
        0x5et 0xfft 0xfet 0xfet
        0x9ct 0x0t 0x1t 0x1t
    .end array-data

    :array_7e
    .array-data 0x4
        0x9et 0x0t 0x1t 0x1t
        0xa2t 0x0t 0x1t 0x1t
        0x64t 0xfft 0xfet 0xfet
    .end array-data

    :array_88
    .array-data 0x4
        0x62t 0xfft 0xfet 0xfet
        0xa2t 0x0t 0x1t 0x1t
        0x9ct 0x0t 0x1t 0x1t
    .end array-data

    :array_92
    .array-data 0x4
        0x9et 0x0t 0x1t 0x1t
        0xa2t 0x0t 0x1t 0x1t
        0x9ct 0x0t 0x1t 0x1t
    .end array-data

    :array_9c
    .array-data 0x4
        0x62t 0xfft 0xfet 0xfet
        0x5et 0xfft 0xfet 0xfet
        0x64t 0xfft 0xfet 0xfet
    .end array-data
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .registers 3
    .parameter "context"

    .prologue
    .line 99
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 100
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 8
    .parameter "context"
    .parameter "attrs"

    .prologue
    const/4 v4, 0x0

    .line 103
    invoke-direct {p0, p1, p2}, Lcom/android/internal/widget/multiwaveview/GlowPadView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 81
    iput-boolean v4, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mShowingOuterRing:Z

    .line 83
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    iput-object v3, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mTargetLightDrawables:Ljava/util/ArrayList;

    .line 84
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    iput-object v3, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mTargetLightAnimations:Ljava/util/ArrayList;

    .line 88
    new-instance v3, Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;

    invoke-direct {v3, p0}, Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;-><init>(Lcom/android/internal/widget/multiwaveview/GlowPadView;)V

    iput-object v3, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mHandleAnimation:Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;

    .line 89
    new-instance v3, Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;

    invoke-direct {v3, p0}, Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;-><init>(Lcom/android/internal/widget/multiwaveview/GlowPadView;)V

    iput-object v3, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mOuterRingAnimation:Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;

    .line 91
    new-instance v3, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal$1;

    invoke-direct {v3, p0}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal$1;-><init>(Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;)V

    iput-object v3, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mOuterRingListener:Landroid/animation/Animator$AnimatorListener;

    .line 105
    sget-object v3, Lmiui/R$styleable;->MiuiInCallAnswerWidgetHorizontal:[I

    invoke-virtual {p1, p2, v3}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 106
    .local v0, a:Landroid/content/res/TypedArray;
    new-instance v1, Landroid/util/TypedValue;

    invoke-direct {v1}, Landroid/util/TypedValue;-><init>()V

    .line 108
    .local v1, outValue:Landroid/util/TypedValue;
    invoke-virtual {v0, v4, v1}, Landroid/content/res/TypedArray;->getValue(ILandroid/util/TypedValue;)Z

    move-result v3

    if-eqz v3, :cond_3f

    .line 109
    iget v3, v1, Landroid/util/TypedValue;->resourceId:I

    invoke-direct {p0, v3}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->internalSetTargetLightResources(I)V

    .line 112
    :cond_3f
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 113
    .local v2, res:Landroid/content/res/Resources;
    new-instance v3, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    const/4 v4, 0x1

    invoke-virtual {v0, v4}, Landroid/content/res/TypedArray;->peekValue(I)Landroid/util/TypedValue;

    move-result-object v4

    iget v4, v4, Landroid/util/TypedValue;->resourceId:I

    invoke-direct {v3, v2, v4}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;-><init>(Landroid/content/res/Resources;I)V

    iput-object v3, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mRightHintAnimTargetDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    .line 117
    iget-object v3, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mHandleDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    invoke-virtual {v3}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->getWidth()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    int-to-float v3, v3

    iput v3, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mGlowRadius:F

    .line 118
    return-void
.end method

.method static synthetic access$002(Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;Z)Z
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 41
    iput-boolean p1, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mShowingOuterRing:Z

    return p1
.end method

.method static synthetic access$100(Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;)Landroid/animation/ValueAnimator;
    .registers 2
    .parameter "x0"

    .prologue
    .line 41
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mHintAnimation:Landroid/animation/ValueAnimator;

    return-object v0
.end method

.method static synthetic access$200(Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;I)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 41
    invoke-direct {p0, p1}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->showRightHintAnim(I)V

    return-void
.end method

.method private hideRightHintAnim()V
    .registers 3

    .prologue
    .line 487
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mRightHintAnimTargetDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setAlpha(F)V

    .line 488
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mHintAnimation:Landroid/animation/ValueAnimator;

    if-eqz v0, :cond_f

    .line 489
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mHintAnimation:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->end()V

    .line 491
    :cond_f
    return-void
.end method

.method private hideTargetLight()V
    .registers 4

    .prologue
    .line 225
    iget-object v2, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mTargetLightDrawables:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :goto_6
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_17

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    .line 226
    .local v1, target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setAlpha(F)V

    goto :goto_6

    .line 228
    .end local v1           #target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    :cond_17
    return-void
.end method

.method private internalSetTargetLightResources(I)V
    .registers 10
    .parameter "resourceId"

    .prologue
    .line 231
    invoke-virtual {p0}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->getContext()Landroid/content/Context;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    .line 232
    .local v3, res:Landroid/content/res/Resources;
    invoke-virtual {v3, p1}, Landroid/content/res/Resources;->obtainTypedArray(I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 233
    .local v0, array:Landroid/content/res/TypedArray;
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->length()I

    move-result v1

    .line 234
    .local v1, count:I
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4, v1}, Ljava/util/ArrayList;-><init>(I)V

    .line 235
    .local v4, targetDrawables:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Lcom/android/internal/widget/multiwaveview/TargetDrawable;>;"
    const/4 v2, 0x0

    .local v2, i:I
    :goto_16
    if-ge v2, v1, :cond_2d

    .line 236
    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->peekValue(I)Landroid/util/TypedValue;

    move-result-object v5

    .line 237
    .local v5, value:Landroid/util/TypedValue;
    new-instance v7, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    if-eqz v5, :cond_2b

    iget v6, v5, Landroid/util/TypedValue;->resourceId:I

    :goto_22
    invoke-direct {v7, v3, v6}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;-><init>(Landroid/content/res/Resources;I)V

    invoke-virtual {v4, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 235
    add-int/lit8 v2, v2, 0x1

    goto :goto_16

    .line 237
    :cond_2b
    const/4 v6, 0x0

    goto :goto_22

    .line 239
    .end local v5           #value:Landroid/util/TypedValue;
    :cond_2d
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 240
    iput-object v4, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mTargetLightDrawables:Ljava/util/ArrayList;

    .line 241
    invoke-direct {p0}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->updateTargetLightPositions()V

    .line 242
    return-void
.end method

.method private moveHandleTo(FFZ)V
    .registers 5
    .parameter "x"
    .parameter "y"
    .parameter "animate"

    .prologue
    .line 519
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mHandleDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    invoke-virtual {v0, p1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setX(F)V

    .line 520
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mHandleDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    invoke-virtual {v0, p2}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setY(F)V

    .line 521
    return-void
.end method

.method private showOuterRing()V
    .registers 10

    .prologue
    const/4 v8, 0x1

    const/4 v1, 0x0

    const/high16 v7, 0x3f80

    .line 399
    iput-boolean v8, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mShowingOuterRing:Z

    .line 400
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mOuterRingAnimation:Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;

    invoke-virtual {v0}, Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;->cancel()V

    .line 401
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mOuterRing:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setScaleX(F)V

    .line 402
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mOuterRing:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setScaleY(F)V

    .line 403
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mOuterRingAnimation:Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;

    iget-object v1, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mOuterRing:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    const-wide/16 v2, 0x12c

    const/16 v4, 0xc

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    const-string v6, "alpha"

    aput-object v6, v4, v5

    invoke-static {v7}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    aput-object v5, v4, v8

    const/4 v5, 0x2

    const-string/jumbo v6, "scaleX"

    aput-object v6, v4, v5

    const/4 v5, 0x3

    invoke-static {v7}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x4

    const-string/jumbo v6, "scaleY"

    aput-object v6, v4, v5

    const/4 v5, 0x5

    invoke-static {v7}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x6

    const-string v6, "delay"

    aput-object v6, v4, v5

    const/4 v5, 0x7

    const/16 v6, 0xc8

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    const/16 v5, 0x8

    const-string/jumbo v6, "onUpdate"

    aput-object v6, v4, v5

    const/16 v5, 0x9

    new-instance v6, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal$2;

    invoke-direct {v6, p0}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal$2;-><init>(Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;)V

    aput-object v6, v4, v5

    const/16 v5, 0xa

    const-string/jumbo v6, "onComplete"

    aput-object v6, v4, v5

    const/16 v5, 0xb

    iget-object v6, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mOuterRingListener:Landroid/animation/Animator$AnimatorListener;

    aput-object v6, v4, v5

    invoke-static {v1, v2, v3, v4}, Lcom/android/internal/widget/multiwaveview/Tweener;->to(Ljava/lang/Object;J[Ljava/lang/Object;)Lcom/android/internal/widget/multiwaveview/Tweener;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;->add(Ljava/lang/Object;)Z

    .line 419
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mOuterRingAnimation:Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;

    invoke-virtual {v0}, Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;->start()V

    .line 420
    return-void
.end method

.method private showRightHintAnim(I)V
    .registers 4
    .parameter "i"

    .prologue
    .line 480
    sget-object v0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->STATE_HINT_ANIM:[[I

    array-length v0, v0

    if-ge p1, v0, :cond_11

    .line 481
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mRightHintAnimTargetDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    sget-object v1, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->STATE_HINT_ANIM:[[I

    aget-object v1, v1, p1

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setState([I)V

    .line 482
    invoke-virtual {p0}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->invalidate()V

    .line 484
    :cond_11
    return-void
.end method

.method private startRightHintAnim()V
    .registers 7

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x2

    .line 494
    iget-object v1, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mRightHintAnimTargetDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    const-string v2, "alpha"

    new-array v3, v4, [F

    fill-array-data v3, :array_5a

    invoke-static {v1, v2, v3}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v0

    .line 495
    .local v0, showHintAnimationAlpha:Landroid/animation/ObjectAnimator;
    const-wide/16 v1, 0x12c

    invoke-virtual {v0, v1, v2}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    .line 496
    const-wide/16 v1, 0x190

    invoke-virtual {v0, v1, v2}, Landroid/animation/ObjectAnimator;->setStartDelay(J)V

    .line 497
    invoke-virtual {v0, v5}, Landroid/animation/ObjectAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .line 498
    invoke-virtual {v0}, Landroid/animation/ObjectAnimator;->start()V

    .line 500
    new-array v1, v4, [F

    fill-array-data v1, :array_62

    invoke-static {v1}, Landroid/animation/ValueAnimator;->ofFloat([F)Landroid/animation/ValueAnimator;

    move-result-object v1

    iput-object v1, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mHintAnimation:Landroid/animation/ValueAnimator;

    .line 501
    iget-object v1, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mHintAnimation:Landroid/animation/ValueAnimator;

    const-wide/16 v2, 0x5dc

    invoke-virtual {v1, v2, v3}, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;

    .line 502
    iget-object v1, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mHintAnimation:Landroid/animation/ValueAnimator;

    invoke-virtual {v1, v5}, Landroid/animation/ValueAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .line 503
    iget-object v1, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mHintAnimation:Landroid/animation/ValueAnimator;

    const-wide/16 v2, 0xc8

    invoke-virtual {v1, v2, v3}, Landroid/animation/ValueAnimator;->setStartDelay(J)V

    .line 504
    iget-object v1, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mHintAnimation:Landroid/animation/ValueAnimator;

    new-instance v2, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal$3;

    invoke-direct {v2, p0}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal$3;-><init>(Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;)V

    invoke-virtual {v1, v2}, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V

    .line 512
    iget-object v1, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mHintAnimation:Landroid/animation/ValueAnimator;

    const/4 v2, -0x1

    invoke-virtual {v1, v2}, Landroid/animation/ValueAnimator;->setRepeatCount(I)V

    .line 513
    iget-object v1, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mHintAnimation:Landroid/animation/ValueAnimator;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/animation/ValueAnimator;->setRepeatMode(I)V

    .line 514
    iget-object v1, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mHintAnimation:Landroid/animation/ValueAnimator;

    invoke-virtual {v1}, Landroid/animation/ValueAnimator;->start()V

    .line 515
    return-void

    .line 494
    nop

    :array_5a
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x80t 0x3ft
    .end array-data

    .line 500
    :array_62
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x80t 0x3ft
    .end array-data
.end method

.method private stopTargetLightAnimation()V
    .registers 4

    .prologue
    .line 187
    iget-object v2, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mTargetLightAnimations:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, i$:Ljava/util/Iterator;
    :goto_6
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_18

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/internal/widget/multiwaveview/Tweener;

    .line 188
    .local v0, anim:Lcom/android/internal/widget/multiwaveview/Tweener;
    iget-object v2, v0, Lcom/android/internal/widget/multiwaveview/Tweener;->animator:Landroid/animation/ObjectAnimator;

    invoke-virtual {v2}, Landroid/animation/ObjectAnimator;->end()V

    goto :goto_6

    .line 190
    .end local v0           #anim:Lcom/android/internal/widget/multiwaveview/Tweener;
    :cond_18
    iget-object v2, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mTargetLightAnimations:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V

    .line 191
    return-void
.end method

.method private updateRightHintAnimPositions()V
    .registers 5

    .prologue
    .line 383
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mRightHintAnimTargetDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    iget v1, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mWaveCenterX:F

    iget v2, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mOuterRadius:F

    const v3, 0x3f266666

    mul-float/2addr v2, v3

    add-float/2addr v1, v2

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setX(F)V

    .line 384
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mRightHintAnimTargetDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    iget v1, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mWaveCenterY:F

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setY(F)V

    .line 385
    return-void
.end method

.method private updateTargetLightPositions()V
    .registers 5

    .prologue
    .line 376
    iget-object v2, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mTargetLightDrawables:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :goto_6
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_23

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    .line 377
    .local v1, targetLight:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    iget v2, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mWaveCenterX:F

    invoke-virtual {v1, v2}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setX(F)V

    .line 378
    iget v2, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mWaveCenterX:F

    iget v3, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mWaveCenterY:F

    invoke-static {v2, v3}, Ljava/lang/Math;->max(FF)F

    move-result v2

    invoke-virtual {v1, v2}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setY(F)V

    goto :goto_6

    .line 380
    .end local v1           #targetLight:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    :cond_23
    return-void
.end method


# virtual methods
.method protected doFinish()V
    .registers 14

    .prologue
    const/4 v12, 0x3

    const/4 v11, 0x2

    const/high16 v10, 0x3f80

    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 424
    iget v0, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mActiveTarget:I

    .line 425
    .local v0, activeTarget:I
    const/4 v2, -0x1

    if-eq v0, v2, :cond_9d

    move v1, v3

    .line 427
    .local v1, targetHit:Z
    :goto_c
    iget-object v2, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mHandleAnimation:Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;

    invoke-virtual {v2}, Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;->cancel()V

    .line 428
    if-eqz v1, :cond_a0

    .line 429
    iget-object v2, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mTargetDrawables:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    sget-object v5, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->STATE_ACTIVE:[I

    invoke-virtual {v2, v5}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setState([I)V

    .line 431
    invoke-virtual {p0, v4, v4}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->hideTargets(ZZ)V

    .line 432
    invoke-direct {p0}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->hideRightHintAnim()V

    .line 435
    iget v2, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mActiveTarget:I

    invoke-virtual {p0, v2}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->dispatchTriggerEvent(I)V

    .line 436
    iget-object v2, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mHandleAnimation:Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;

    iget-object v5, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mHandleDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    const-wide/16 v6, 0x0

    const/16 v8, 0xe

    new-array v8, v8, [Ljava/lang/Object;

    const-string v9, "ease"

    aput-object v9, v8, v4

    sget-object v9, Lcom/android/internal/widget/multiwaveview/Ease$Quart;->easeOut:Landroid/animation/TimeInterpolator;

    aput-object v9, v8, v3

    const-string v3, "delay"

    aput-object v3, v8, v11

    const/16 v3, 0x4b0

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v8, v12

    const/4 v3, 0x4

    const-string v9, "alpha"

    aput-object v9, v8, v3

    const/4 v3, 0x5

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v9

    aput-object v9, v8, v3

    const/4 v3, 0x6

    const-string/jumbo v9, "x"

    aput-object v9, v8, v3

    const/4 v3, 0x7

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v3

    const/16 v3, 0x8

    const-string/jumbo v9, "y"

    aput-object v9, v8, v3

    const/16 v3, 0x9

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v3

    const/16 v3, 0xa

    const-string/jumbo v9, "onUpdate"

    aput-object v9, v8, v3

    const/16 v3, 0xb

    iget-object v9, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mUpdateListener:Landroid/animation/ValueAnimator$AnimatorUpdateListener;

    aput-object v9, v8, v3

    const/16 v3, 0xc

    const-string/jumbo v9, "onComplete"

    aput-object v9, v8, v3

    const/16 v3, 0xd

    iget-object v9, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mResetListener:Landroid/animation/Animator$AnimatorListener;

    aput-object v9, v8, v3

    invoke-static {v5, v6, v7, v8}, Lcom/android/internal/widget/multiwaveview/Tweener;->to(Ljava/lang/Object;J[Ljava/lang/Object;)Lcom/android/internal/widget/multiwaveview/Tweener;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;->add(Ljava/lang/Object;)Z

    .line 455
    :goto_92
    iget-object v2, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mHandleAnimation:Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;

    invoke-virtual {v2}, Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;->start()V

    .line 457
    iput-boolean v4, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mDragging:Z

    .line 458
    invoke-virtual {p0, v4}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->setGrabbedState(I)V

    .line 459
    return-void

    .end local v1           #targetHit:Z
    :cond_9d
    move v1, v4

    .line 425
    goto/16 :goto_c

    .line 446
    .restart local v1       #targetHit:Z
    :cond_a0
    iget-object v5, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mHandleAnimation:Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;

    iget-object v6, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mHandleDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    const-wide/16 v7, 0x12c

    const/16 v2, 0xe

    new-array v9, v2, [Ljava/lang/Object;

    const-string v2, "ease"

    aput-object v2, v9, v4

    sget-object v2, Lcom/android/internal/widget/multiwaveview/Ease$Quart;->easeOut:Landroid/animation/TimeInterpolator;

    aput-object v2, v9, v3

    const-string v2, "delay"

    aput-object v2, v9, v11

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v9, v12

    const/4 v2, 0x4

    const-string v3, "alpha"

    aput-object v3, v9, v2

    const/4 v2, 0x5

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    aput-object v3, v9, v2

    const/4 v2, 0x6

    const-string/jumbo v3, "x"

    aput-object v3, v9, v2

    const/4 v2, 0x7

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v9, v2

    const/16 v2, 0x8

    const-string/jumbo v3, "y"

    aput-object v3, v9, v2

    const/16 v2, 0x9

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v9, v2

    const/16 v2, 0xa

    const-string/jumbo v3, "onUpdate"

    aput-object v3, v9, v2

    const/16 v2, 0xb

    iget-object v3, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mUpdateListener:Landroid/animation/ValueAnimator$AnimatorUpdateListener;

    aput-object v3, v9, v2

    const/16 v2, 0xc

    const-string/jumbo v3, "onComplete"

    aput-object v3, v9, v2

    const/16 v3, 0xd

    iget-boolean v2, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mDragging:Z

    if-eqz v2, :cond_10a

    iget-object v2, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mResetListenerWithPing:Landroid/animation/Animator$AnimatorListener;

    :goto_100
    aput-object v2, v9, v3

    invoke-static {v6, v7, v8, v9}, Lcom/android/internal/widget/multiwaveview/Tweener;->to(Ljava/lang/Object;J[Ljava/lang/Object;)Lcom/android/internal/widget/multiwaveview/Tweener;

    move-result-object v2

    invoke-virtual {v5, v2}, Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;->add(Ljava/lang/Object;)Z

    goto :goto_92

    :cond_10a
    iget-object v2, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mResetListener:Landroid/animation/Animator$AnimatorListener;

    goto :goto_100
.end method

.method protected handleMove(Landroid/view/MotionEvent;)V
    .registers 42
    .parameter "event"

    .prologue
    .line 246
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mDragging:Z

    move/from16 v33, v0

    if-nez v33, :cond_9

    .line 349
    :goto_8
    return-void

    .line 251
    :cond_9
    const/4 v4, -0x1

    .line 252
    .local v4, activeTarget:I
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getHistorySize()I

    move-result v11

    .line 253
    .local v11, historySize:I
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mTargetDrawables:Ljava/util/ArrayList;

    move-object/from16 v27, v0

    .line 254
    .local v27, targets:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Lcom/android/internal/widget/multiwaveview/TargetDrawable;>;"
    invoke-virtual/range {v27 .. v27}, Ljava/util/ArrayList;->size()I

    move-result v16

    .line 255
    .local v16, ntargets:I
    const/16 v31, 0x0

    .line 256
    .local v31, x:F
    const/16 v32, 0x0

    .line 257
    .local v32, y:F
    const/4 v13, 0x0

    .local v13, k:I
    :goto_1d
    add-int/lit8 v33, v11, 0x1

    move/from16 v0, v33

    if-ge v13, v0, :cond_2c0

    .line 258
    if-ge v13, v11, :cond_141

    move-object/from16 v0, p1

    invoke-virtual {v0, v13}, Landroid/view/MotionEvent;->getHistoricalX(I)F

    move-result v9

    .line 259
    .local v9, eventX:F
    :goto_2b
    if-ge v13, v11, :cond_147

    move-object/from16 v0, p1

    invoke-virtual {v0, v13}, Landroid/view/MotionEvent;->getHistoricalY(I)F

    move-result v10

    .line 261
    .local v10, eventY:F
    :goto_33
    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mWaveCenterX:F

    move/from16 v33, v0

    sub-float v29, v9, v33

    .line 262
    .local v29, tx:F
    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mWaveCenterY:F

    move/from16 v33, v0

    sub-float v30, v10, v33

    .line 263
    .local v30, ty:F
    move-object/from16 v0, p0

    move/from16 v1, v29

    move/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->dist2(FF)F

    move-result v33

    move/from16 v0, v33

    float-to-double v0, v0

    move-wide/from16 v33, v0

    invoke-static/range {v33 .. v34}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v33

    move-wide/from16 v0, v33

    double-to-float v0, v0

    move/from16 v28, v0

    .line 264
    .local v28, touchRadius:F
    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mOuterRadius:F

    move/from16 v33, v0

    cmpl-float v33, v28, v33

    if-lez v33, :cond_14d

    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mOuterRadius:F

    move/from16 v33, v0

    div-float v17, v33, v28

    .line 265
    .local v17, scale:F
    :goto_6d
    mul-float v14, v29, v17

    .line 266
    .local v14, limitX:F
    mul-float v15, v30, v17

    .line 267
    .local v15, limitY:F
    move/from16 v0, v30

    neg-float v0, v0

    move/from16 v33, v0

    move/from16 v0, v33

    float-to-double v0, v0

    move-wide/from16 v33, v0

    move/from16 v0, v29

    float-to-double v0, v0

    move-wide/from16 v35, v0

    invoke-static/range {v33 .. v36}, Ljava/lang/Math;->atan2(DD)D

    move-result-wide v6

    .line 269
    .local v6, angleRad:D
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mTargetDrawables:Ljava/util/ArrayList;

    move-object/from16 v33, v0

    invoke-virtual/range {v33 .. v33}, Ljava/util/ArrayList;->size()I

    move-result v33

    const/16 v34, 0x1

    move/from16 v0, v33

    move/from16 v1, v34

    if-ne v0, v1, :cond_151

    const/16 v18, 0x1

    .line 270
    .local v18, singleTarget:Z
    :goto_98
    if-eqz v18, :cond_155

    .line 272
    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mOuterRadius:F

    move/from16 v33, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mSnapMargin:F

    move/from16 v34, v0

    sub-float v20, v33, v34

    .line 273
    .local v20, snapRadius:F
    cmpl-float v33, v28, v20

    if-lez v33, :cond_b1

    .line 274
    const/4 v4, 0x0

    .line 275
    move/from16 v31, v14

    .line 276
    move/from16 v32, v15

    .line 301
    :cond_b1
    :goto_b1
    const/16 v33, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v31

    move/from16 v2, v32

    move/from16 v3, v33

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->moveHandleTo(FFZ)V

    .line 303
    const/16 v33, -0x1

    move/from16 v0, v33

    if-eq v4, v0, :cond_252

    .line 304
    const/16 v33, 0x2

    move/from16 v0, v33

    if-ne v4, v0, :cond_1e5

    .line 305
    const/16 v33, 0x6

    move-object/from16 v0, p0

    move/from16 v1, v33

    move/from16 v2, v31

    move/from16 v3, v32

    invoke-virtual {v0, v1, v2, v3}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->switchToState(IFF)V

    .line 312
    :goto_d7
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mTargetLightDrawables:Ljava/util/ArrayList;

    move-object/from16 v33, v0

    move-object/from16 v0, v33

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    .line 313
    .local v8, currentTargetLight:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mCurrentTargetLight:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    move-object/from16 v33, v0

    if-nez v33, :cond_205

    .line 314
    move-object/from16 v0, p0

    iput-object v8, v0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mCurrentTargetLight:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    .line 321
    :cond_f1
    :goto_f1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mTargetLightAnimations:Ljava/util/ArrayList;

    move-object/from16 v33, v0

    invoke-virtual/range {v33 .. v33}, Ljava/util/ArrayList;->size()I

    move-result v33

    if-lez v33, :cond_100

    .line 322
    invoke-direct/range {p0 .. p0}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->stopTargetLightAnimation()V

    .line 324
    :cond_100
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mTargetLightAnimations:Ljava/util/ArrayList;

    move-object/from16 v33, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mCurrentTargetLight:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    move-object/from16 v34, v0

    const-wide/16 v35, 0x14

    const/16 v37, 0x4

    move/from16 v0, v37

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v37, v0

    const/16 v38, 0x0

    const-string v39, "delay"

    aput-object v39, v37, v38

    const/16 v38, 0x1

    const/16 v39, 0x0

    invoke-static/range {v39 .. v39}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v39

    aput-object v39, v37, v38

    const/16 v38, 0x2

    const-string v39, "alpha"

    aput-object v39, v37, v38

    const/16 v38, 0x3

    const/high16 v39, 0x3f80

    invoke-static/range {v39 .. v39}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v39

    aput-object v39, v37, v38

    invoke-static/range {v34 .. v37}, Lcom/android/internal/widget/multiwaveview/Tweener;->to(Ljava/lang/Object;J[Ljava/lang/Object;)Lcom/android/internal/widget/multiwaveview/Tweener;

    move-result-object v34

    invoke-virtual/range {v33 .. v34}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 257
    .end local v8           #currentTargetLight:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    :goto_13d
    add-int/lit8 v13, v13, 0x1

    goto/16 :goto_1d

    .line 258
    .end local v6           #angleRad:D
    .end local v9           #eventX:F
    .end local v10           #eventY:F
    .end local v14           #limitX:F
    .end local v15           #limitY:F
    .end local v17           #scale:F
    .end local v18           #singleTarget:Z
    .end local v20           #snapRadius:F
    .end local v28           #touchRadius:F
    .end local v29           #tx:F
    .end local v30           #ty:F
    :cond_141
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    goto/16 :goto_2b

    .line 259
    .restart local v9       #eventX:F
    :cond_147
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v10

    goto/16 :goto_33

    .line 264
    .restart local v10       #eventY:F
    .restart local v28       #touchRadius:F
    .restart local v29       #tx:F
    .restart local v30       #ty:F
    :cond_14d
    const/high16 v17, 0x3f80

    goto/16 :goto_6d

    .line 269
    .restart local v6       #angleRad:D
    .restart local v14       #limitX:F
    .restart local v15       #limitY:F
    .restart local v17       #scale:F
    :cond_151
    const/16 v18, 0x0

    goto/16 :goto_98

    .line 280
    .restart local v18       #singleTarget:Z
    :cond_155
    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mOuterRadius:F

    move/from16 v33, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mSnapMargin:F

    move/from16 v34, v0

    sub-float v20, v33, v34

    .line 281
    .restart local v20       #snapRadius:F
    mul-float v19, v20, v20

    .line 283
    .local v19, snapDistance2:F
    const/4 v12, 0x0

    .local v12, i:I
    :goto_166
    move/from16 v0, v16

    if-ge v12, v0, :cond_1df

    .line 284
    move-object/from16 v0, v27

    invoke-virtual {v0, v12}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v21

    check-cast v21, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    .line 286
    .local v21, target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    int-to-double v0, v12

    move-wide/from16 v33, v0

    const-wide/high16 v35, 0x3fe0

    sub-double v33, v33, v35

    const-wide/high16 v35, 0x4000

    mul-double v33, v33, v35

    const-wide v35, 0x400921fb54442d18L

    mul-double v33, v33, v35

    move/from16 v0, v16

    int-to-double v0, v0

    move-wide/from16 v35, v0

    div-double v25, v33, v35

    .line 287
    .local v25, targetMinRad:D
    int-to-double v0, v12

    move-wide/from16 v33, v0

    const-wide/high16 v35, 0x3fe0

    add-double v33, v33, v35

    const-wide/high16 v35, 0x4000

    mul-double v33, v33, v35

    const-wide v35, 0x400921fb54442d18L

    mul-double v33, v33, v35

    move/from16 v0, v16

    int-to-double v0, v0

    move-wide/from16 v35, v0

    div-double v23, v33, v35

    .line 288
    .local v23, targetMaxRad:D
    invoke-virtual/range {v21 .. v21}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->isEnabled()Z

    move-result v33

    if-eqz v33, :cond_1da

    .line 289
    cmpl-double v33, v6, v25

    if-lez v33, :cond_1b2

    cmpg-double v33, v6, v23

    if-lez v33, :cond_1c8

    :cond_1b2
    const-wide v33, 0x401921fb54442d18L

    add-double v33, v33, v6

    cmpl-double v33, v33, v25

    if-lez v33, :cond_1dd

    const-wide v33, 0x401921fb54442d18L

    add-double v33, v33, v6

    cmpg-double v33, v33, v23

    if-gtz v33, :cond_1dd

    :cond_1c8
    const/4 v5, 0x1

    .line 293
    .local v5, angleMatches:Z
    :goto_1c9
    if-eqz v5, :cond_1da

    move-object/from16 v0, p0

    move/from16 v1, v29

    move/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->dist2(FF)F

    move-result v33

    cmpl-float v33, v33, v19

    if-lez v33, :cond_1da

    .line 294
    move v4, v12

    .line 283
    .end local v5           #angleMatches:Z
    :cond_1da
    add-int/lit8 v12, v12, 0x1

    goto :goto_166

    .line 289
    :cond_1dd
    const/4 v5, 0x0

    goto :goto_1c9

    .line 298
    .end local v21           #target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    .end local v23           #targetMaxRad:D
    .end local v25           #targetMinRad:D
    :cond_1df
    move/from16 v31, v14

    .line 299
    move/from16 v32, v15

    goto/16 :goto_b1

    .line 306
    .end local v12           #i:I
    .end local v19           #snapDistance2:F
    :cond_1e5
    if-nez v4, :cond_1f6

    .line 307
    const/16 v33, 0x7

    move-object/from16 v0, p0

    move/from16 v1, v33

    move/from16 v2, v31

    move/from16 v3, v32

    invoke-virtual {v0, v1, v2, v3}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->switchToState(IFF)V

    goto/16 :goto_d7

    .line 309
    :cond_1f6
    const/16 v33, 0x4

    move-object/from16 v0, p0

    move/from16 v1, v33

    move/from16 v2, v31

    move/from16 v3, v32

    invoke-virtual {v0, v1, v2, v3}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->switchToState(IFF)V

    goto/16 :goto_d7

    .line 315
    .restart local v8       #currentTargetLight:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    :cond_205
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mCurrentTargetLight:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    move-object/from16 v33, v0

    move-object/from16 v0, v33

    if-eq v0, v8, :cond_f1

    .line 316
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mTargetLightAnimations:Ljava/util/ArrayList;

    move-object/from16 v33, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mCurrentTargetLight:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    move-object/from16 v34, v0

    const-wide/16 v35, 0x14

    const/16 v37, 0x4

    move/from16 v0, v37

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v37, v0

    const/16 v38, 0x0

    const-string v39, "delay"

    aput-object v39, v37, v38

    const/16 v38, 0x1

    const/16 v39, 0x0

    invoke-static/range {v39 .. v39}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v39

    aput-object v39, v37, v38

    const/16 v38, 0x2

    const-string v39, "alpha"

    aput-object v39, v37, v38

    const/16 v38, 0x3

    const/16 v39, 0x0

    invoke-static/range {v39 .. v39}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v39

    aput-object v39, v37, v38

    invoke-static/range {v34 .. v37}, Lcom/android/internal/widget/multiwaveview/Tweener;->to(Ljava/lang/Object;J[Ljava/lang/Object;)Lcom/android/internal/widget/multiwaveview/Tweener;

    move-result-object v34

    invoke-virtual/range {v33 .. v34}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 319
    move-object/from16 v0, p0

    iput-object v8, v0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mCurrentTargetLight:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    goto/16 :goto_f1

    .line 328
    .end local v8           #currentTargetLight:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    :cond_252
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mTargetLightAnimations:Ljava/util/ArrayList;

    move-object/from16 v33, v0

    invoke-virtual/range {v33 .. v33}, Ljava/util/ArrayList;->size()I

    move-result v33

    if-lez v33, :cond_261

    .line 329
    invoke-direct/range {p0 .. p0}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->stopTargetLightAnimation()V

    .line 331
    :cond_261
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mCurrentTargetLight:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    move-object/from16 v33, v0

    if-eqz v33, :cond_2a6

    .line 332
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mTargetLightAnimations:Ljava/util/ArrayList;

    move-object/from16 v33, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mCurrentTargetLight:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    move-object/from16 v34, v0

    const-wide/16 v35, 0x14

    const/16 v37, 0x4

    move/from16 v0, v37

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v37, v0

    const/16 v38, 0x0

    const-string v39, "delay"

    aput-object v39, v37, v38

    const/16 v38, 0x1

    const/16 v39, 0x0

    invoke-static/range {v39 .. v39}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v39

    aput-object v39, v37, v38

    const/16 v38, 0x2

    const-string v39, "alpha"

    aput-object v39, v37, v38

    const/16 v38, 0x3

    const/16 v39, 0x0

    invoke-static/range {v39 .. v39}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v39

    aput-object v39, v37, v38

    invoke-static/range {v34 .. v37}, Lcom/android/internal/widget/multiwaveview/Tweener;->to(Ljava/lang/Object;J[Ljava/lang/Object;)Lcom/android/internal/widget/multiwaveview/Tweener;

    move-result-object v34

    invoke-virtual/range {v33 .. v34}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 336
    :cond_2a6
    const/16 v33, 0x3

    move-object/from16 v0, p0

    move/from16 v1, v33

    move/from16 v2, v31

    move/from16 v3, v32

    invoke-virtual {v0, v1, v2, v3}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->switchToState(IFF)V

    .line 337
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mHandleDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    move-object/from16 v33, v0

    const/high16 v34, 0x3f80

    invoke-virtual/range {v33 .. v34}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setAlpha(F)V

    goto/16 :goto_13d

    .line 341
    .end local v6           #angleRad:D
    .end local v9           #eventX:F
    .end local v10           #eventY:F
    .end local v14           #limitX:F
    .end local v15           #limitY:F
    .end local v17           #scale:F
    .end local v18           #singleTarget:Z
    .end local v20           #snapRadius:F
    .end local v28           #touchRadius:F
    .end local v29           #tx:F
    .end local v30           #ty:F
    :cond_2c0
    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mActiveTarget:I

    move/from16 v33, v0

    move/from16 v0, v33

    if-eq v0, v4, :cond_2f0

    const/16 v33, -0x1

    move/from16 v0, v33

    if-eq v4, v0, :cond_2f0

    .line 342
    invoke-virtual/range {p0 .. p0}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->vibrate()V

    .line 343
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/View;->mContext:Landroid/content/Context;

    move-object/from16 v33, v0

    invoke-static/range {v33 .. v33}, Landroid/view/accessibility/AccessibilityManager;->getInstance(Landroid/content/Context;)Landroid/view/accessibility/AccessibilityManager;

    move-result-object v33

    invoke-virtual/range {v33 .. v33}, Landroid/view/accessibility/AccessibilityManager;->isEnabled()Z

    move-result v33

    if-eqz v33, :cond_2f0

    .line 344
    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->getTargetDescription(I)Ljava/lang/String;

    move-result-object v22

    .line 345
    .local v22, targetContentDescription:Ljava/lang/String;
    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->announceForAccessibility(Ljava/lang/CharSequence;)V

    .line 348
    .end local v22           #targetContentDescription:Ljava/lang/String;
    :cond_2f0
    move-object/from16 v0, p0

    iput v4, v0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mActiveTarget:I

    goto/16 :goto_8
.end method

.method protected hideTargets(ZZ)V
    .registers 15
    .parameter "animate"
    .parameter "expanded"

    .prologue
    .line 195
    iget-object v6, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mTargetAnimations:Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;

    invoke-virtual {v6}, Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;->cancel()V

    .line 198
    iput-boolean p1, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mAnimatingTargets:Z

    .line 199
    if-eqz p1, :cond_64

    const/16 v1, 0xc8

    .line 200
    .local v1, duration:I
    :goto_b
    if-eqz p1, :cond_66

    const/16 v0, 0xc8

    .line 202
    .local v0, delay:I
    :goto_f
    iget-object v6, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mTargetDrawables:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v4

    .line 203
    .local v4, length:I
    sget-object v3, Lcom/android/internal/widget/multiwaveview/Ease$Cubic;->easeOut:Landroid/animation/TimeInterpolator;

    .line 204
    .local v3, interpolator:Landroid/animation/TimeInterpolator;
    const/4 v2, 0x0

    .local v2, i:I
    :goto_18
    if-ge v2, v4, :cond_68

    .line 205
    iget-object v6, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mTargetDrawables:Ljava/util/ArrayList;

    invoke-virtual {v6, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    .line 206
    .local v5, target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    sget-object v6, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->STATE_INACTIVE:[I

    invoke-virtual {v5, v6}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setState([I)V

    .line 207
    iget-object v6, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mTargetAnimations:Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;

    int-to-long v7, v1

    const/16 v9, 0x8

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    const-string v11, "ease"

    aput-object v11, v9, v10

    const/4 v10, 0x1

    aput-object v3, v9, v10

    const/4 v10, 0x2

    const-string v11, "alpha"

    aput-object v11, v9, v10

    const/4 v10, 0x3

    const/4 v11, 0x0

    invoke-static {v11}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v11

    aput-object v11, v9, v10

    const/4 v10, 0x4

    const-string v11, "delay"

    aput-object v11, v9, v10

    const/4 v10, 0x5

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    aput-object v11, v9, v10

    const/4 v10, 0x6

    const-string/jumbo v11, "onUpdate"

    aput-object v11, v9, v10

    const/4 v10, 0x7

    iget-object v11, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mUpdateListener:Landroid/animation/ValueAnimator$AnimatorUpdateListener;

    aput-object v11, v9, v10

    invoke-static {v5, v7, v8, v9}, Lcom/android/internal/widget/multiwaveview/Tweener;->to(Ljava/lang/Object;J[Ljava/lang/Object;)Lcom/android/internal/widget/multiwaveview/Tweener;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;->add(Ljava/lang/Object;)Z

    .line 204
    add-int/lit8 v2, v2, 0x1

    goto :goto_18

    .line 199
    .end local v0           #delay:I
    .end local v1           #duration:I
    .end local v2           #i:I
    .end local v3           #interpolator:Landroid/animation/TimeInterpolator;
    .end local v4           #length:I
    .end local v5           #target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    :cond_64
    const/4 v1, 0x0

    goto :goto_b

    .line 200
    .restart local v1       #duration:I
    :cond_66
    const/4 v0, 0x0

    goto :goto_f

    .line 213
    .restart local v0       #delay:I
    .restart local v2       #i:I
    .restart local v3       #interpolator:Landroid/animation/TimeInterpolator;
    .restart local v4       #length:I
    :cond_68
    iget-object v6, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mTargetAnimations:Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;

    invoke-virtual {v6}, Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;->start()V

    .line 216
    iget-object v6, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mOuterRing:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    const/4 v7, 0x0

    invoke-virtual {v6, v7}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setAlpha(F)V

    .line 218
    iget-object v6, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mTargetLightAnimations:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v6

    if-lez v6, :cond_7e

    .line 219
    invoke-direct {p0}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->stopTargetLightAnimation()V

    .line 221
    :cond_7e
    invoke-direct {p0}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->hideTargetLight()V

    .line 222
    return-void
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .registers 5
    .parameter "canvas"

    .prologue
    .line 360
    iget-object v2, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mOuterRing:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    invoke-virtual {v2, p1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->draw(Landroid/graphics/Canvas;)V

    .line 361
    iget-object v2, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mTargetLightDrawables:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :cond_b
    :goto_b
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1d

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    .line 362
    .local v1, target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    if-eqz v1, :cond_b

    .line 363
    invoke-virtual {v1, p1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->draw(Landroid/graphics/Canvas;)V

    goto :goto_b

    .line 366
    .end local v1           #target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    :cond_1d
    iget-object v2, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mTargetDrawables:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_23
    :goto_23
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_35

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    .line 367
    .restart local v1       #target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    if-eqz v1, :cond_23

    .line 368
    invoke-virtual {v1, p1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->draw(Landroid/graphics/Canvas;)V

    goto :goto_23

    .line 371
    .end local v1           #target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    :cond_35
    iget-object v2, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mRightHintAnimTargetDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    invoke-virtual {v2, p1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->draw(Landroid/graphics/Canvas;)V

    .line 372
    iget-object v2, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mHandleDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    invoke-virtual {v2, p1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->draw(Landroid/graphics/Canvas;)V

    .line 373
    return-void
.end method

.method protected onLayout(ZIIII)V
    .registers 6
    .parameter "changed"
    .parameter "left"
    .parameter "top"
    .parameter "right"
    .parameter "bottom"

    .prologue
    .line 353
    invoke-super/range {p0 .. p5}, Lcom/android/internal/widget/multiwaveview/GlowPadView;->onLayout(ZIIII)V

    .line 354
    invoke-direct {p0}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->updateTargetLightPositions()V

    .line 355
    invoke-direct {p0}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->updateRightHintAnimPositions()V

    .line 356
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .registers 6
    .parameter "event"

    .prologue
    const/4 v0, 0x1

    .line 464
    iget-boolean v1, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mShowingOuterRing:Z

    if-eqz v1, :cond_6

    .line 476
    :cond_5
    :goto_5
    return v0

    .line 468
    :cond_6
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result v1

    if-le v1, v0, :cond_20

    .line 469
    iget-boolean v1, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mDragging:Z

    if-eqz v1, :cond_5

    .line 470
    const/4 v1, -0x1

    iput v1, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mActiveTarget:I

    .line 471
    const/4 v1, 0x5

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v2

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v3

    invoke-virtual {p0, v1, v2, v3}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->switchToState(IFF)V

    goto :goto_5

    .line 476
    :cond_20
    invoke-super {p0, p1}, Lcom/android/internal/widget/multiwaveview/GlowPadView;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_5
.end method

.method public reset(Z)V
    .registers 3
    .parameter "animate"

    .prologue
    .line 389
    invoke-super {p0, p1}, Lcom/android/internal/widget/multiwaveview/GlowPadView;->reset(Z)V

    .line 390
    invoke-direct {p0}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->hideRightHintAnim()V

    .line 391
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mHandleAnimation:Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;

    invoke-virtual {v0}, Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;->stop()V

    .line 393
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mTargetAnimations:Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;

    invoke-virtual {v0}, Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;->stop()V

    .line 394
    invoke-direct {p0}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->showOuterRing()V

    .line 395
    invoke-direct {p0}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->startRightHintAnim()V

    .line 396
    return-void
.end method

.method protected showTargets(Z)V
    .registers 15
    .parameter "animate"

    .prologue
    const/16 v1, 0xc8

    const/4 v5, 0x0

    const/high16 v12, 0x3f80

    .line 163
    iget-object v6, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mTargetAnimations:Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;

    invoke-virtual {v6}, Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;->stop()V

    .line 164
    iget-object v6, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mTargetLightAnimations:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v6

    if-lez v6, :cond_15

    .line 165
    invoke-direct {p0}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->stopTargetLightAnimation()V

    .line 167
    :cond_15
    iput-boolean p1, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mAnimatingTargets:Z

    .line 168
    if-eqz p1, :cond_8d

    move v0, v1

    .line 169
    .local v0, delay:I
    :goto_1a
    if-eqz p1, :cond_8f

    .line 170
    .local v1, duration:I
    :goto_1c
    iget-object v6, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mTargetDrawables:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v3

    .line 171
    .local v3, length:I
    const/4 v2, 0x0

    .local v2, i:I
    :goto_23
    if-ge v2, v3, :cond_91

    .line 172
    iget-object v6, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mTargetDrawables:Ljava/util/ArrayList;

    invoke-virtual {v6, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    .line 173
    .local v4, target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    sget-object v6, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->STATE_INACTIVE:[I

    invoke-virtual {v4, v6}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setState([I)V

    .line 174
    iget-object v6, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mTargetAnimations:Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;

    int-to-long v7, v1

    const/16 v9, 0xc

    new-array v9, v9, [Ljava/lang/Object;

    const-string v10, "ease"

    aput-object v10, v9, v5

    const/4 v10, 0x1

    sget-object v11, Lcom/android/internal/widget/multiwaveview/Ease$Cubic;->easeOut:Landroid/animation/TimeInterpolator;

    aput-object v11, v9, v10

    const/4 v10, 0x2

    const-string v11, "alpha"

    aput-object v11, v9, v10

    const/4 v10, 0x3

    invoke-static {v12}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v11

    aput-object v11, v9, v10

    const/4 v10, 0x4

    const-string/jumbo v11, "scaleX"

    aput-object v11, v9, v10

    const/4 v10, 0x5

    invoke-static {v12}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v11

    aput-object v11, v9, v10

    const/4 v10, 0x6

    const-string/jumbo v11, "scaleY"

    aput-object v11, v9, v10

    const/4 v10, 0x7

    invoke-static {v12}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v11

    aput-object v11, v9, v10

    const/16 v10, 0x8

    const-string v11, "delay"

    aput-object v11, v9, v10

    const/16 v10, 0x9

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    aput-object v11, v9, v10

    const/16 v10, 0xa

    const-string/jumbo v11, "onUpdate"

    aput-object v11, v9, v10

    const/16 v10, 0xb

    iget-object v11, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mUpdateListener:Landroid/animation/ValueAnimator$AnimatorUpdateListener;

    aput-object v11, v9, v10

    invoke-static {v4, v7, v8, v9}, Lcom/android/internal/widget/multiwaveview/Tweener;->to(Ljava/lang/Object;J[Ljava/lang/Object;)Lcom/android/internal/widget/multiwaveview/Tweener;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;->add(Ljava/lang/Object;)Z

    .line 171
    add-int/lit8 v2, v2, 0x1

    goto :goto_23

    .end local v0           #delay:I
    .end local v1           #duration:I
    .end local v2           #i:I
    .end local v3           #length:I
    .end local v4           #target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    :cond_8d
    move v0, v5

    .line 168
    goto :goto_1a

    .restart local v0       #delay:I
    :cond_8f
    move v1, v5

    .line 169
    goto :goto_1c

    .line 182
    .restart local v1       #duration:I
    .restart local v2       #i:I
    .restart local v3       #length:I
    :cond_91
    iget-object v5, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mTargetAnimations:Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;

    invoke-virtual {v5}, Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;->start()V

    .line 183
    invoke-direct {p0}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->hideTargetLight()V

    .line 184
    return-void
.end method

.method protected switchToState(IFF)V
    .registers 6
    .parameter "state"
    .parameter "x"
    .parameter "y"

    .prologue
    .line 122
    packed-switch p1, :pswitch_data_5e

    .line 159
    :cond_3
    :goto_3
    :pswitch_3
    return-void

    .line 124
    :pswitch_4
    invoke-virtual {p0}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->deactivateTargets()V

    .line 125
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mHandleDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    sget-object v1, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->STATE_INACTIVE:[I

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setState([I)V

    .line 126
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mHandleDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    const/high16 v1, 0x3f80

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setAlpha(F)V

    goto :goto_3

    .line 130
    :pswitch_16
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->mHandleAnimation:Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;

    invoke-virtual {v0}, Lcom/android/internal/widget/multiwaveview/GlowPadView$AnimationBundle;->stop()V

    .line 131
    invoke-virtual {p0}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->deactivateTargets()V

    .line 132
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mHandleDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    sget-object v1, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->STATE_ACTIVE:[I

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setState([I)V

    .line 133
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->setGrabbedState(I)V

    .line 134
    iget-object v0, p0, Landroid/view/View;->mContext:Landroid/content/Context;

    invoke-static {v0}, Landroid/view/accessibility/AccessibilityManager;->getInstance(Landroid/content/Context;)Landroid/view/accessibility/AccessibilityManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/accessibility/AccessibilityManager;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 135
    invoke-virtual {p0}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->announceTargets()V

    goto :goto_3

    .line 140
    :pswitch_39
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mHandleDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    sget-object v1, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->STATE_ACTIVE:[I

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setState([I)V

    goto :goto_3

    .line 144
    :pswitch_41
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mHandleDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    sget-object v1, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->STATE_DECLINE_HANDLE:[I

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setState([I)V

    goto :goto_3

    .line 148
    :pswitch_49
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mHandleDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    sget-object v1, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->STATE_ANSWER_HANDLE:[I

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setState([I)V

    goto :goto_3

    .line 152
    :pswitch_51
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/GlowPadView;->mHandleDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    sget-object v1, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->STATE_ACTIVE:[I

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setState([I)V

    goto :goto_3

    .line 156
    :pswitch_59
    invoke-virtual {p0}, Lcom/android/internal/widget/multiwaveview/MiuiInCallAnswerWidgetHorizontal;->doFinish()V

    goto :goto_3

    .line 122
    nop

    :pswitch_data_5e
    .packed-switch 0x0
        :pswitch_4
        :pswitch_3
        :pswitch_16
        :pswitch_39
        :pswitch_51
        :pswitch_59
        :pswitch_41
        :pswitch_49
    .end packed-switch
.end method
