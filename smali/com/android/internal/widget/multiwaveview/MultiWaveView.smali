.class public Lcom/android/internal/widget/multiwaveview/MultiWaveView;
.super Landroid/view/View;
.source "MultiWaveView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;,
        Lcom/android/internal/widget/multiwaveview/MultiWaveView$OnTriggerListener;
    }
.end annotation


# static fields
.field private static final CHEVRON_ANIMATION_DURATION:I = 0x352

.field private static final CHEVRON_INCREMENTAL_DELAY:I = 0xa0

.field private static final DEBUG:Z = false

.field private static final HIDE_ANIMATION_DELAY:I = 0xc8

.field private static final HIDE_ANIMATION_DURATION:I = 0xc8

.field private static final INITIAL_SHOW_HANDLE_DURATION:I = 0xc8

.field private static final RETURN_TO_HOME_DELAY:I = 0x4b0

.field private static final RETURN_TO_HOME_DURATION:I = 0xc8

.field private static final RING_SCALE_COLLAPSED:F = 0.5f

.field private static final RING_SCALE_EXPANDED:F = 1.0f

.field private static final SHOW_ANIMATION_DELAY:I = 0x32

.field private static final SHOW_ANIMATION_DURATION:I = 0xc8

.field private static final SNAP_MARGIN_DEFAULT:F = 20.0f

.field private static final STATE_FINISH:I = 0x5

.field private static final STATE_FIRST_TOUCH:I = 0x2

.field private static final STATE_IDLE:I = 0x0

.field private static final STATE_SNAP:I = 0x4

.field private static final STATE_START:I = 0x1

.field private static final STATE_TRACKING:I = 0x3

.field private static final TAG:Ljava/lang/String; = "MultiWaveView"

.field private static final TAP_RADIUS_SCALE_ACCESSIBILITY_ENABLED:F = 1.3f

.field private static final TARGET_SCALE_COLLAPSED:F = 0.8f

.field private static final TARGET_SCALE_EXPANDED:F = 1.0f


# instance fields
.field private mActiveTarget:I

.field private mAlwaysTrackFinger:Z

.field private mAnimatingTargets:Z

.field private mBackgroundAnimator:Lcom/android/internal/widget/multiwaveview/Tweener;

.field private mChevronAnimationInterpolator:Landroid/animation/TimeInterpolator;

.field private mChevronAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

.field private mChevronDrawables:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/internal/widget/multiwaveview/TargetDrawable;",
            ">;"
        }
    .end annotation
.end field

.field private mDirectionDescriptions:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mDirectionDescriptionsResourceId:I

.field private mDragging:Z

.field private mFeedbackCount:I

.field private mGrabbedState:I

.field private mGravity:I

.field private mHandleAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

.field private mHandleDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

.field private mHorizontalInset:I

.field private mInitialLayout:Z

.field private mMaxTargetHeight:I

.field private mMaxTargetWidth:I

.field private mNewTargetResources:I

.field private mOnTriggerListener:Lcom/android/internal/widget/multiwaveview/MultiWaveView$OnTriggerListener;

.field private mOuterRadius:F

.field private mOuterRing:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

.field private mResetListener:Landroid/animation/Animator$AnimatorListener;

.field private mResetListenerWithPing:Landroid/animation/Animator$AnimatorListener;

.field private mSnapMargin:F

.field private mTapRadius:F

.field private mTargetAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

.field private mTargetDescriptions:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mTargetDescriptionsResourceId:I

.field private mTargetDrawables:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/internal/widget/multiwaveview/TargetDrawable;",
            ">;"
        }
    .end annotation
.end field

.field private mTargetResourceId:I

.field private mTargetUpdateListener:Landroid/animation/Animator$AnimatorListener;

.field private mUpdateListener:Landroid/animation/ValueAnimator$AnimatorUpdateListener;

.field private mVerticalInset:I

.field private mVibrationDuration:I

.field private mVibrator:Landroid/os/Vibrator;

.field private mWaveCenterX:F

.field private mWaveCenterY:F


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 3
    .parameter "context"

    .prologue
    .line 206
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 207
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 13
    .parameter "context"
    .parameter "attrs"

    .prologue
    .line 210
    invoke-direct {p0, p1, p2}, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 97
    sget-object v8, Lcom/android/internal/widget/multiwaveview/Ease$Quad;->easeOut:Landroid/animation/TimeInterpolator;

    iput-object v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mChevronAnimationInterpolator:Landroid/animation/TimeInterpolator;

    .line 99
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    iput-object v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDrawables:Ljava/util/ArrayList;

    .line 100
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    iput-object v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mChevronDrawables:Ljava/util/ArrayList;

    .line 101
    new-instance v8, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    const/4 v9, 0x0

    invoke-direct {v8, p0, v9}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;-><init>(Lcom/android/internal/widget/multiwaveview/MultiWaveView;Lcom/android/internal/widget/multiwaveview/MultiWaveView$1;)V

    iput-object v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mChevronAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    .line 102
    new-instance v8, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    const/4 v9, 0x0

    invoke-direct {v8, p0, v9}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;-><init>(Lcom/android/internal/widget/multiwaveview/MultiWaveView;Lcom/android/internal/widget/multiwaveview/MultiWaveView$1;)V

    iput-object v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    .line 103
    new-instance v8, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    const/4 v9, 0x0

    invoke-direct {v8, p0, v9}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;-><init>(Lcom/android/internal/widget/multiwaveview/MultiWaveView;Lcom/android/internal/widget/multiwaveview/MultiWaveView$1;)V

    iput-object v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mHandleAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    .line 111
    const/4 v8, 0x3

    iput v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mFeedbackCount:I

    .line 112
    const/4 v8, 0x0

    iput v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mVibrationDuration:I

    .line 114
    const/4 v8, -0x1

    iput v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mActiveTarget:I

    .line 121
    const/4 v8, 0x0

    iput v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOuterRadius:F

    .line 122
    const/4 v8, 0x0

    iput v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mSnapMargin:F

    .line 162
    new-instance v8, Lcom/android/internal/widget/multiwaveview/MultiWaveView$1;

    invoke-direct {v8, p0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$1;-><init>(Lcom/android/internal/widget/multiwaveview/MultiWaveView;)V

    iput-object v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mResetListener:Landroid/animation/Animator$AnimatorListener;

    .line 169
    new-instance v8, Lcom/android/internal/widget/multiwaveview/MultiWaveView$2;

    invoke-direct {v8, p0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$2;-><init>(Lcom/android/internal/widget/multiwaveview/MultiWaveView;)V

    iput-object v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mResetListenerWithPing:Landroid/animation/Animator$AnimatorListener;

    .line 177
    new-instance v8, Lcom/android/internal/widget/multiwaveview/MultiWaveView$3;

    invoke-direct {v8, p0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$3;-><init>(Lcom/android/internal/widget/multiwaveview/MultiWaveView;)V

    iput-object v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mUpdateListener:Landroid/animation/ValueAnimator$AnimatorUpdateListener;

    .line 185
    new-instance v8, Lcom/android/internal/widget/multiwaveview/MultiWaveView$4;

    invoke-direct {v8, p0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$4;-><init>(Lcom/android/internal/widget/multiwaveview/MultiWaveView;)V

    iput-object v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetUpdateListener:Landroid/animation/Animator$AnimatorListener;

    .line 201
    const/16 v8, 0x30

    iput v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mGravity:I

    .line 202
    const/4 v8, 0x1

    iput-boolean v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mInitialLayout:Z

    .line 211
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    .line 213
    .local v6, res:Landroid/content/res/Resources;
    sget-object v8, Lcom/android/internal/R$styleable;->MultiWaveView:[I

    invoke-virtual {p1, p2, v8}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 214
    .local v0, a:Landroid/content/res/TypedArray;
    const/4 v8, 0x6

    iget v9, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOuterRadius:F

    invoke-virtual {v0, v8, v9}, Landroid/content/res/TypedArray;->getDimension(IF)F

    move-result v8

    iput v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOuterRadius:F

    .line 215
    const/16 v8, 0x8

    iget v9, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mSnapMargin:F

    invoke-virtual {v0, v8, v9}, Landroid/content/res/TypedArray;->getDimension(IF)F

    move-result v8

    iput v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mSnapMargin:F

    .line 216
    const/4 v8, 0x7

    iget v9, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mVibrationDuration:I

    invoke-virtual {v0, v8, v9}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v8

    iput v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mVibrationDuration:I

    .line 218
    const/16 v8, 0x9

    iget v9, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mFeedbackCount:I

    invoke-virtual {v0, v8, v9}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v8

    iput v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mFeedbackCount:I

    .line 220
    new-instance v8, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    const/4 v9, 0x3

    invoke-virtual {v0, v9}, Landroid/content/res/TypedArray;->peekValue(I)Landroid/util/TypedValue;

    move-result-object v9

    iget v9, v9, Landroid/util/TypedValue;->resourceId:I

    invoke-direct {v8, v6, v9}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;-><init>(Landroid/content/res/Resources;I)V

    iput-object v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mHandleDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    .line 222
    iget-object v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mHandleDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    invoke-virtual {v8}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->getWidth()I

    move-result v8

    div-int/lit8 v8, v8, 0x2

    int-to-float v8, v8

    iput v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTapRadius:F

    .line 223
    new-instance v8, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    const/4 v9, 0x5

    invoke-virtual {v0, v9}, Landroid/content/res/TypedArray;->peekValue(I)Landroid/util/TypedValue;

    move-result-object v9

    iget v9, v9, Landroid/util/TypedValue;->resourceId:I

    invoke-direct {v8, v6, v9}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;-><init>(Landroid/content/res/Resources;I)V

    iput-object v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOuterRing:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    .line 225
    const/16 v8, 0xa

    const/4 v9, 0x0

    invoke-virtual {v0, v8, v9}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v8

    iput-boolean v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mAlwaysTrackFinger:Z

    .line 228
    new-instance v5, Landroid/util/TypedValue;

    invoke-direct {v5}, Landroid/util/TypedValue;-><init>()V

    .line 229
    .local v5, outValue:Landroid/util/TypedValue;
    const/4 v8, 0x4

    invoke-virtual {v0, v8, v5}, Landroid/content/res/TypedArray;->getValue(ILandroid/util/TypedValue;)Z

    move-result v8

    if-eqz v8, :cond_f7

    .line 230
    iget v8, v5, Landroid/util/TypedValue;->resourceId:I

    invoke-direct {p0, v8}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->loadDrawableArray(I)Ljava/util/ArrayList;

    move-result-object v2

    .line 231
    .local v2, chevrons:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Lcom/android/internal/widget/multiwaveview/TargetDrawable;>;"
    const/4 v3, 0x0

    .local v3, i:I
    :goto_d2
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v8

    if-ge v3, v8, :cond_f7

    .line 232
    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    .line 233
    .local v1, chevron:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    const/4 v4, 0x0

    .local v4, k:I
    :goto_df
    iget v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mFeedbackCount:I

    if-ge v4, v8, :cond_f4

    .line 234
    iget-object v9, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mChevronDrawables:Ljava/util/ArrayList;

    if-nez v1, :cond_ee

    const/4 v8, 0x0

    :goto_e8
    invoke-virtual {v9, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 233
    add-int/lit8 v4, v4, 0x1

    goto :goto_df

    .line 234
    :cond_ee
    new-instance v8, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    invoke-direct {v8, v1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;-><init>(Lcom/android/internal/widget/multiwaveview/TargetDrawable;)V

    goto :goto_e8

    .line 231
    :cond_f4
    add-int/lit8 v3, v3, 0x1

    goto :goto_d2

    .line 240
    .end local v1           #chevron:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    .end local v2           #chevrons:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Lcom/android/internal/widget/multiwaveview/TargetDrawable;>;"
    .end local v3           #i:I
    .end local v4           #k:I
    :cond_f7
    const/4 v8, 0x2

    invoke-virtual {v0, v8, v5}, Landroid/content/res/TypedArray;->getValue(ILandroid/util/TypedValue;)Z

    move-result v8

    if-eqz v8, :cond_103

    .line 241
    iget v8, v5, Landroid/util/TypedValue;->resourceId:I

    invoke-direct {p0, v8}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->internalSetTargetResources(I)V

    .line 243
    :cond_103
    iget-object v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDrawables:Ljava/util/ArrayList;

    if-eqz v8, :cond_10f

    iget-object v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDrawables:Ljava/util/ArrayList;

    invoke-virtual {v8}, Ljava/util/ArrayList;->size()I

    move-result v8

    if-nez v8, :cond_117

    .line 244
    :cond_10f
    new-instance v8, Ljava/lang/IllegalStateException;

    const-string v9, "Must specify at least one target drawable"

    invoke-direct {v8, v9}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 248
    :cond_117
    const/4 v8, 0x0

    invoke-virtual {v0, v8, v5}, Landroid/content/res/TypedArray;->getValue(ILandroid/util/TypedValue;)Z

    move-result v8

    if-eqz v8, :cond_12d

    .line 249
    iget v7, v5, Landroid/util/TypedValue;->resourceId:I

    .line 250
    .local v7, resourceId:I
    if-nez v7, :cond_12a

    .line 251
    new-instance v8, Ljava/lang/IllegalStateException;

    const-string v9, "Must specify target descriptions"

    invoke-direct {v8, v9}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 253
    :cond_12a
    invoke-virtual {p0, v7}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->setTargetDescriptionsResourceId(I)V

    .line 257
    .end local v7           #resourceId:I
    :cond_12d
    const/4 v8, 0x1

    invoke-virtual {v0, v8, v5}, Landroid/content/res/TypedArray;->getValue(ILandroid/util/TypedValue;)Z

    move-result v8

    if-eqz v8, :cond_143

    .line 258
    iget v7, v5, Landroid/util/TypedValue;->resourceId:I

    .line 259
    .restart local v7       #resourceId:I
    if-nez v7, :cond_140

    .line 260
    new-instance v8, Ljava/lang/IllegalStateException;

    const-string v9, "Must specify direction descriptions"

    invoke-direct {v8, v9}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 262
    :cond_140
    invoke-virtual {p0, v7}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->setDirectionDescriptionsResourceId(I)V

    .line 265
    .end local v7           #resourceId:I
    :cond_143
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 268
    sget-object v8, Landroid/R$styleable;->LinearLayout:[I

    invoke-virtual {p1, p2, v8}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 269
    const/4 v8, 0x0

    const/16 v9, 0x30

    invoke-virtual {v0, v8, v9}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v8

    iput v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mGravity:I

    .line 270
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 272
    iget v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mVibrationDuration:I

    if-lez v8, :cond_164

    const/4 v8, 0x1

    :goto_15d
    invoke-virtual {p0, v8}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->setVibrateEnabled(Z)V

    .line 273
    invoke-direct {p0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->assignDefaultsIfNeeded()V

    .line 274
    return-void

    .line 272
    :cond_164
    const/4 v8, 0x0

    goto :goto_15d
.end method

.method static synthetic access$100(Lcom/android/internal/widget/multiwaveview/MultiWaveView;)F
    .registers 2
    .parameter "x0"

    .prologue
    .line 55
    iget v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mWaveCenterX:F

    return v0
.end method

.method static synthetic access$200(Lcom/android/internal/widget/multiwaveview/MultiWaveView;)F
    .registers 2
    .parameter "x0"

    .prologue
    .line 55
    iget v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mWaveCenterY:F

    return v0
.end method

.method static synthetic access$300(Lcom/android/internal/widget/multiwaveview/MultiWaveView;IFF)V
    .registers 4
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"
    .parameter "x3"

    .prologue
    .line 55
    invoke-direct {p0, p1, p2, p3}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->switchToState(IFF)V

    return-void
.end method

.method static synthetic access$400(Lcom/android/internal/widget/multiwaveview/MultiWaveView;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 55
    invoke-direct {p0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->dispatchOnFinishFinalAnimation()V

    return-void
.end method

.method static synthetic access$500(Lcom/android/internal/widget/multiwaveview/MultiWaveView;)Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    .registers 2
    .parameter "x0"

    .prologue
    .line 55
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mHandleDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    return-object v0
.end method

.method static synthetic access$600(Lcom/android/internal/widget/multiwaveview/MultiWaveView;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 55
    iget v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mNewTargetResources:I

    return v0
.end method

.method static synthetic access$602(Lcom/android/internal/widget/multiwaveview/MultiWaveView;I)I
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 55
    iput p1, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mNewTargetResources:I

    return p1
.end method

.method static synthetic access$700(Lcom/android/internal/widget/multiwaveview/MultiWaveView;I)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 55
    invoke-direct {p0, p1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->internalSetTargetResources(I)V

    return-void
.end method

.method static synthetic access$800(Lcom/android/internal/widget/multiwaveview/MultiWaveView;ZZ)V
    .registers 3
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"

    .prologue
    .line 55
    invoke-direct {p0, p1, p2}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->hideTargets(ZZ)V

    return-void
.end method

.method static synthetic access$902(Lcom/android/internal/widget/multiwaveview/MultiWaveView;Z)Z
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 55
    iput-boolean p1, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mAnimatingTargets:Z

    return p1
.end method

.method private activateHandle(IIFLandroid/animation/Animator$AnimatorListener;)V
    .registers 12
    .parameter "duration"
    .parameter "delay"
    .parameter "finalAlpha"
    .parameter "finishListener"

    .prologue
    .line 382
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mHandleAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    invoke-virtual {v0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->cancel()V

    .line 383
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mHandleAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    iget-object v1, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mHandleDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    int-to-long v2, p1

    const/16 v4, 0xa

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    const-string v6, "ease"

    aput-object v6, v4, v5

    const/4 v5, 0x1

    sget-object v6, Lcom/android/internal/widget/multiwaveview/Ease$Cubic;->easeIn:Landroid/animation/TimeInterpolator;

    aput-object v6, v4, v5

    const/4 v5, 0x2

    const-string v6, "delay"

    aput-object v6, v4, v5

    const/4 v5, 0x3

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x4

    const-string v6, "alpha"

    aput-object v6, v4, v5

    const/4 v5, 0x5

    invoke-static {p3}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x6

    const-string/jumbo v6, "onUpdate"

    aput-object v6, v4, v5

    const/4 v5, 0x7

    iget-object v6, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mUpdateListener:Landroid/animation/ValueAnimator$AnimatorUpdateListener;

    aput-object v6, v4, v5

    const/16 v5, 0x8

    const-string/jumbo v6, "onComplete"

    aput-object v6, v4, v5

    const/16 v5, 0x9

    aput-object p4, v4, v5

    invoke-static {v1, v2, v3, v4}, Lcom/android/internal/widget/multiwaveview/Tweener;->to(Ljava/lang/Object;J[Ljava/lang/Object;)Lcom/android/internal/widget/multiwaveview/Tweener;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->add(Ljava/lang/Object;)Z

    .line 389
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mHandleAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    invoke-virtual {v0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->start()V

    .line 390
    return-void
.end method

.method private announceTargets()V
    .registers 9

    .prologue
    .line 1120
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    .line 1121
    .local v5, utterance:Ljava/lang/StringBuilder;
    iget-object v6, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDrawables:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v2

    .line 1122
    .local v2, targetCount:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_c
    if-ge v1, v2, :cond_3f

    .line 1123
    invoke-direct {p0, v1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->getTargetDescription(I)Ljava/lang/String;

    move-result-object v3

    .line 1124
    .local v3, targetDescription:Ljava/lang/String;
    invoke-direct {p0, v1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->getDirectionDescription(I)Ljava/lang/String;

    move-result-object v0

    .line 1125
    .local v0, directionDescription:Ljava/lang/String;
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_2f

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_2f

    .line 1127
    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object v3, v6, v7

    invoke-static {v0, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    .line 1128
    .local v4, text:Ljava/lang/String;
    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1130
    .end local v4           #text:Ljava/lang/String;
    :cond_2f
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->length()I

    move-result v6

    if-lez v6, :cond_3c

    .line 1131
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {p0, v6}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->announceText(Ljava/lang/String;)V

    .line 1122
    :cond_3c
    add-int/lit8 v1, v1, 0x1

    goto :goto_c

    .line 1134
    .end local v0           #directionDescription:Ljava/lang/String;
    .end local v3           #targetDescription:Ljava/lang/String;
    :cond_3f
    return-void
.end method

.method private announceText(Ljava/lang/String;)V
    .registers 3
    .parameter "text"

    .prologue
    .line 1137
    invoke-virtual {p0, p1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 1138
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->sendAccessibilityEvent(I)V

    .line 1139
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 1140
    return-void
.end method

.method private assignDefaultsIfNeeded()V
    .registers 4

    .prologue
    const/4 v2, 0x0

    .line 963
    iget v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOuterRadius:F

    cmpl-float v0, v0, v2

    if-nez v0, :cond_1d

    .line 964
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOuterRing:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    invoke-virtual {v0}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->getWidth()I

    move-result v0

    iget-object v1, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOuterRing:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    invoke-virtual {v1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->getHeight()I

    move-result v1

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    int-to-float v0, v0

    const/high16 v1, 0x4000

    div-float/2addr v0, v1

    iput v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOuterRadius:F

    .line 966
    :cond_1d
    iget v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mSnapMargin:F

    cmpl-float v0, v0, v2

    if-nez v0, :cond_38

    .line 967
    const/4 v0, 0x1

    const/high16 v1, 0x41a0

    invoke-virtual {p0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    invoke-static {v0, v1, v2}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v0

    iput v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mSnapMargin:F

    .line 970
    :cond_38
    return-void
.end method

.method private computeInsets(II)V
    .registers 7
    .parameter "dx"
    .parameter "dy"

    .prologue
    const/4 v3, 0x0

    .line 973
    invoke-virtual {p0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->getResolvedLayoutDirection()I

    move-result v1

    .line 974
    .local v1, layoutDirection:I
    iget v2, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mGravity:I

    invoke-static {v2, v1}, Landroid/view/Gravity;->getAbsoluteGravity(II)I

    move-result v0

    .line 976
    .local v0, absoluteGravity:I
    and-int/lit8 v2, v0, 0x7

    packed-switch v2, :pswitch_data_2a

    .line 985
    :pswitch_10
    div-int/lit8 v2, p1, 0x2

    iput v2, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mHorizontalInset:I

    .line 988
    :goto_14
    and-int/lit8 v2, v0, 0x70

    sparse-switch v2, :sswitch_data_34

    .line 997
    div-int/lit8 v2, p2, 0x2

    iput v2, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mVerticalInset:I

    .line 1000
    :goto_1d
    return-void

    .line 978
    :pswitch_1e
    iput v3, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mHorizontalInset:I

    goto :goto_14

    .line 981
    :pswitch_21
    iput p1, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mHorizontalInset:I

    goto :goto_14

    .line 990
    :sswitch_24
    iput v3, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mVerticalInset:I

    goto :goto_1d

    .line 993
    :sswitch_27
    iput p2, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mVerticalInset:I

    goto :goto_1d

    .line 976
    :pswitch_data_2a
    .packed-switch 0x3
        :pswitch_1e
        :pswitch_10
        :pswitch_21
    .end packed-switch

    .line 988
    :sswitch_data_34
    .sparse-switch
        0x30 -> :sswitch_24
        0x50 -> :sswitch_27
    .end sparse-switch
.end method

.method private deactivateHandle(IIFLandroid/animation/Animator$AnimatorListener;)V
    .registers 13
    .parameter "duration"
    .parameter "delay"
    .parameter "finalAlpha"
    .parameter "finishListener"

    .prologue
    const/4 v7, 0x0

    .line 394
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mHandleAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    invoke-virtual {v0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->cancel()V

    .line 395
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mHandleAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    iget-object v1, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mHandleDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    int-to-long v2, p1

    const/16 v4, 0xe

    new-array v4, v4, [Ljava/lang/Object;

    const-string v5, "ease"

    aput-object v5, v4, v7

    const/4 v5, 0x1

    sget-object v6, Lcom/android/internal/widget/multiwaveview/Ease$Quart;->easeOut:Landroid/animation/TimeInterpolator;

    aput-object v6, v4, v5

    const/4 v5, 0x2

    const-string v6, "delay"

    aput-object v6, v4, v5

    const/4 v5, 0x3

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x4

    const-string v6, "alpha"

    aput-object v6, v4, v5

    const/4 v5, 0x5

    invoke-static {p3}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x6

    const-string/jumbo v6, "x"

    aput-object v6, v4, v5

    const/4 v5, 0x7

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    const/16 v5, 0x8

    const-string/jumbo v6, "y"

    aput-object v6, v4, v5

    const/16 v5, 0x9

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    const/16 v5, 0xa

    const-string/jumbo v6, "onUpdate"

    aput-object v6, v4, v5

    const/16 v5, 0xb

    iget-object v6, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mUpdateListener:Landroid/animation/ValueAnimator$AnimatorUpdateListener;

    aput-object v6, v4, v5

    const/16 v5, 0xc

    const-string/jumbo v6, "onComplete"

    aput-object v6, v4, v5

    const/16 v5, 0xd

    aput-object p4, v4, v5

    invoke-static {v1, v2, v3, v4}, Lcom/android/internal/widget/multiwaveview/Tweener;->to(Ljava/lang/Object;J[Ljava/lang/Object;)Lcom/android/internal/widget/multiwaveview/Tweener;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->add(Ljava/lang/Object;)Z

    .line 403
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mHandleAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    invoke-virtual {v0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->start()V

    .line 404
    return-void
.end method

.method private deactivateTargets()V
    .registers 5

    .prologue
    .line 451
    iget-object v3, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDrawables:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 452
    .local v0, count:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_7
    if-ge v1, v0, :cond_19

    .line 453
    iget-object v3, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDrawables:Ljava/util/ArrayList;

    invoke-virtual {v3, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    .line 454
    .local v2, target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    sget-object v3, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->STATE_INACTIVE:[I

    invoke-virtual {v2, v3}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setState([I)V

    .line 452
    add-int/lit8 v1, v1, 0x1

    goto :goto_7

    .line 456
    .end local v2           #target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    :cond_19
    const/4 v3, -0x1

    iput v3, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mActiveTarget:I

    .line 457
    return-void
.end method

.method private dispatchOnFinishFinalAnimation()V
    .registers 2

    .prologue
    .line 487
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOnTriggerListener:Lcom/android/internal/widget/multiwaveview/MultiWaveView$OnTriggerListener;

    if-eqz v0, :cond_9

    .line 488
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOnTriggerListener:Lcom/android/internal/widget/multiwaveview/MultiWaveView$OnTriggerListener;

    invoke-interface {v0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$OnTriggerListener;->onFinishFinalAnimation()V

    .line 490
    :cond_9
    return-void
.end method

.method private dispatchTriggerEvent(I)V
    .registers 3
    .parameter "whichTarget"

    .prologue
    .line 480
    invoke-direct {p0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->vibrate()V

    .line 481
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOnTriggerListener:Lcom/android/internal/widget/multiwaveview/MultiWaveView$OnTriggerListener;

    if-eqz v0, :cond_c

    .line 482
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOnTriggerListener:Lcom/android/internal/widget/multiwaveview/MultiWaveView$OnTriggerListener;

    invoke-interface {v0, p0, p1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$OnTriggerListener;->onTrigger(Landroid/view/View;I)V

    .line 484
    :cond_c
    return-void
.end method

.method private dist2(FF)F
    .registers 5
    .parameter "dx"
    .parameter "dy"

    .prologue
    .line 1106
    mul-float v0, p1, p1

    mul-float v1, p2, p2

    add-float/2addr v0, v1

    return v0
.end method

.method private doFinish()V
    .registers 8

    .prologue
    const/4 v2, 0x1

    const/16 v6, 0xc8

    const/4 v3, 0x0

    .line 493
    iget v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mActiveTarget:I

    .line 494
    .local v0, activeTarget:I
    const/4 v4, -0x1

    if-eq v0, v4, :cond_27

    move v1, v2

    .line 496
    .local v1, targetHit:Z
    :goto_a
    if-eqz v1, :cond_29

    .line 499
    invoke-direct {p0, v0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->highlightSelected(I)V

    .line 502
    const/16 v2, 0x4b0

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mResetListener:Landroid/animation/Animator$AnimatorListener;

    invoke-direct {p0, v6, v2, v4, v5}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->deactivateHandle(IIFLandroid/animation/Animator$AnimatorListener;)V

    .line 503
    invoke-direct {p0, v0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->dispatchTriggerEvent(I)V

    .line 504
    iget-boolean v2, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mAlwaysTrackFinger:Z

    if-nez v2, :cond_23

    .line 506
    iget-object v2, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    invoke-virtual {v2}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->stop()V

    .line 515
    :cond_23
    :goto_23
    invoke-direct {p0, v3}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->setGrabbedState(I)V

    .line 516
    return-void

    .end local v1           #targetHit:Z
    :cond_27
    move v1, v3

    .line 494
    goto :goto_a

    .line 510
    .restart local v1       #targetHit:Z
    :cond_29
    const/high16 v4, 0x3f80

    iget-object v5, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mResetListenerWithPing:Landroid/animation/Animator$AnimatorListener;

    invoke-direct {p0, v6, v6, v4, v5}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->deactivateHandle(IIFLandroid/animation/Animator$AnimatorListener;)V

    .line 512
    invoke-direct {p0, v2, v3}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->hideTargets(ZZ)V

    goto :goto_23
.end method

.method private dump()V
    .registers 4

    .prologue
    .line 277
    const-string v0, "MultiWaveView"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Outer Radius = "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOuterRadius:F

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 278
    const-string v0, "MultiWaveView"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "SnapMargin = "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mSnapMargin:F

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 279
    const-string v0, "MultiWaveView"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "FeedbackCount = "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mFeedbackCount:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 280
    const-string v0, "MultiWaveView"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "VibrationDuration = "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mVibrationDuration:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 281
    const-string v0, "MultiWaveView"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "TapRadius = "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTapRadius:F

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 282
    const-string v0, "MultiWaveView"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "WaveCenterX = "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mWaveCenterX:F

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 283
    const-string v0, "MultiWaveView"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "WaveCenterY = "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mWaveCenterY:F

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 284
    return-void
.end method

.method private getDirectionDescription(I)Ljava/lang/String;
    .registers 4
    .parameter "index"

    .prologue
    .line 1155
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mDirectionDescriptions:Ljava/util/ArrayList;

    if-eqz v0, :cond_c

    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mDirectionDescriptions:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_2b

    .line 1156
    :cond_c
    iget v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mDirectionDescriptionsResourceId:I

    invoke-direct {p0, v0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->loadDescriptions(I)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mDirectionDescriptions:Ljava/util/ArrayList;

    .line 1157
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDrawables:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    iget-object v1, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mDirectionDescriptions:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-eq v0, v1, :cond_2b

    .line 1158
    const-string v0, "MultiWaveView"

    const-string v1, "The number of target drawables must be euqal to the number of direction descriptions."

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 1160
    const/4 v0, 0x0

    .line 1163
    :goto_2a
    return-object v0

    :cond_2b
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mDirectionDescriptions:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    goto :goto_2a
.end method

.method private getScaledTapRadiusSquared()F
    .registers 4

    .prologue
    .line 1111
    iget-object v1, p0, Landroid/view/View;->mContext:Landroid/content/Context;

    invoke-static {v1}, Landroid/view/accessibility/AccessibilityManager;->getInstance(Landroid/content/Context;)Landroid/view/accessibility/AccessibilityManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/accessibility/AccessibilityManager;->isEnabled()Z

    move-result v1

    if-eqz v1, :cond_18

    .line 1112
    const v1, 0x3fa66666

    iget v2, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTapRadius:F

    mul-float v0, v1, v2

    .line 1116
    .local v0, scaledTapRadius:F
    :goto_13
    invoke-direct {p0, v0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->square(F)F

    move-result v1

    return v1

    .line 1114
    .end local v0           #scaledTapRadius:F
    :cond_18
    iget v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTapRadius:F

    .restart local v0       #scaledTapRadius:F
    goto :goto_13
.end method

.method private getTargetDescription(I)Ljava/lang/String;
    .registers 4
    .parameter "index"

    .prologue
    .line 1143
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDescriptions:Ljava/util/ArrayList;

    if-eqz v0, :cond_c

    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDescriptions:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_2b

    .line 1144
    :cond_c
    iget v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDescriptionsResourceId:I

    invoke-direct {p0, v0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->loadDescriptions(I)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDescriptions:Ljava/util/ArrayList;

    .line 1145
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDrawables:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    iget-object v1, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDescriptions:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-eq v0, v1, :cond_2b

    .line 1146
    const-string v0, "MultiWaveView"

    const-string v1, "The number of target drawables must be euqal to the number of target descriptions."

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 1148
    const/4 v0, 0x0

    .line 1151
    :goto_2a
    return-object v0

    :cond_2b
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDescriptions:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    goto :goto_2a
.end method

.method private handleCancel(Landroid/view/MotionEvent;)V
    .registers 5
    .parameter "event"

    .prologue
    .line 815
    const/4 v0, 0x5

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v2

    invoke-direct {p0, v0, v1, v2}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->switchToState(IFF)V

    .line 816
    return-void
.end method

.method private handleDown(Landroid/view/MotionEvent;)V
    .registers 5
    .parameter "event"

    .prologue
    .line 791
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v0

    .line 792
    .local v0, eventX:F
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    .line 793
    .local v1, eventY:F
    const/4 v2, 0x1

    invoke-direct {p0, v2, v0, v1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->switchToState(IFF)V

    .line 794
    invoke-direct {p0, v0, v1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->trySwitchToFirstTouchState(FF)Z

    move-result v2

    if-nez v2, :cond_18

    .line 795
    const/4 v2, 0x0

    iput-boolean v2, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mDragging:Z

    .line 796
    invoke-virtual {p0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->ping()V

    .line 798
    :cond_18
    return-void
.end method

.method private handleMove(Landroid/view/MotionEvent;)V
    .registers 38
    .parameter "event"

    .prologue
    .line 819
    const/4 v5, -0x1

    .line 820
    .local v5, activeTarget:I
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getHistorySize()I

    move-result v11

    .line 821
    .local v11, historySize:I
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDrawables:Ljava/util/ArrayList;

    move-object/from16 v26, v0

    .line 822
    .local v26, targets:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Lcom/android/internal/widget/multiwaveview/TargetDrawable;>;"
    invoke-virtual/range {v26 .. v26}, Ljava/util/ArrayList;->size()I

    move-result v16

    .line 823
    .local v16, ntargets:I
    const/16 v30, 0x0

    .line 824
    .local v30, x:F
    const/16 v31, 0x0

    .line 825
    .local v31, y:F
    const/4 v13, 0x0

    .local v13, k:I
    :goto_14
    add-int/lit8 v32, v11, 0x1

    move/from16 v0, v32

    if-ge v13, v0, :cond_132

    .line 826
    if-ge v13, v11, :cond_118

    move-object/from16 v0, p1

    invoke-virtual {v0, v13}, Landroid/view/MotionEvent;->getHistoricalX(I)F

    move-result v9

    .line 827
    .local v9, eventX:F
    :goto_22
    if-ge v13, v11, :cond_11e

    move-object/from16 v0, p1

    invoke-virtual {v0, v13}, Landroid/view/MotionEvent;->getHistoricalY(I)F

    move-result v10

    .line 829
    .local v10, eventY:F
    :goto_2a
    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mWaveCenterX:F

    move/from16 v32, v0

    sub-float v28, v9, v32

    .line 830
    .local v28, tx:F
    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mWaveCenterY:F

    move/from16 v32, v0

    sub-float v29, v10, v32

    .line 831
    .local v29, ty:F
    move-object/from16 v0, p0

    move/from16 v1, v28

    move/from16 v2, v29

    invoke-direct {v0, v1, v2}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->dist2(FF)F

    move-result v32

    move/from16 v0, v32

    float-to-double v0, v0

    move-wide/from16 v32, v0

    invoke-static/range {v32 .. v33}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v32

    move-wide/from16 v0, v32

    double-to-float v0, v0

    move/from16 v27, v0

    .line 832
    .local v27, touchRadius:F
    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOuterRadius:F

    move/from16 v32, v0

    cmpl-float v32, v27, v32

    if-lez v32, :cond_124

    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOuterRadius:F

    move/from16 v32, v0

    div-float v17, v32, v27

    .line 833
    .local v17, scale:F
    :goto_64
    mul-float v14, v28, v17

    .line 834
    .local v14, limitX:F
    mul-float v15, v29, v17

    .line 835
    .local v15, limitY:F
    move/from16 v0, v29

    neg-float v0, v0

    move/from16 v32, v0

    move/from16 v0, v32

    float-to-double v0, v0

    move-wide/from16 v32, v0

    move/from16 v0, v28

    float-to-double v0, v0

    move-wide/from16 v34, v0

    invoke-static/range {v32 .. v35}, Ljava/lang/Math;->atan2(DD)D

    move-result-wide v7

    .line 837
    .local v7, angleRad:D
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mDragging:Z

    move/from16 v32, v0

    if-nez v32, :cond_88

    .line 838
    move-object/from16 v0, p0

    invoke-direct {v0, v9, v10}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->trySwitchToFirstTouchState(FF)Z

    .line 841
    :cond_88
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mDragging:Z

    move/from16 v32, v0

    if-eqz v32, :cond_12a

    .line 843
    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOuterRadius:F

    move/from16 v32, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mSnapMargin:F

    move/from16 v33, v0

    sub-float v19, v32, v33

    .line 844
    .local v19, snapRadius:F
    mul-float v18, v19, v19

    .line 846
    .local v18, snapDistance2:F
    const/4 v12, 0x0

    .local v12, i:I
    :goto_a1
    move/from16 v0, v16

    if-ge v12, v0, :cond_12a

    .line 847
    move-object/from16 v0, v26

    invoke-virtual {v0, v12}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    .line 849
    .local v20, target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    int-to-double v0, v12

    move-wide/from16 v32, v0

    const-wide/high16 v34, 0x3fe0

    sub-double v32, v32, v34

    const-wide/high16 v34, 0x4000

    mul-double v32, v32, v34

    const-wide v34, 0x400921fb54442d18L

    mul-double v32, v32, v34

    move/from16 v0, v16

    int-to-double v0, v0

    move-wide/from16 v34, v0

    div-double v24, v32, v34

    .line 850
    .local v24, targetMinRad:D
    int-to-double v0, v12

    move-wide/from16 v32, v0

    const-wide/high16 v34, 0x3fe0

    add-double v32, v32, v34

    const-wide/high16 v34, 0x4000

    mul-double v32, v32, v34

    const-wide v34, 0x400921fb54442d18L

    mul-double v32, v32, v34

    move/from16 v0, v16

    int-to-double v0, v0

    move-wide/from16 v34, v0

    div-double v22, v32, v34

    .line 851
    .local v22, targetMaxRad:D
    invoke-virtual/range {v20 .. v20}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->isEnabled()Z

    move-result v32

    if-eqz v32, :cond_115

    .line 852
    cmpl-double v32, v7, v24

    if-lez v32, :cond_ed

    cmpg-double v32, v7, v22

    if-lez v32, :cond_103

    :cond_ed
    const-wide v32, 0x401921fb54442d18L

    add-double v32, v32, v7

    cmpl-double v32, v32, v24

    if-lez v32, :cond_128

    const-wide v32, 0x401921fb54442d18L

    add-double v32, v32, v7

    cmpg-double v32, v32, v22

    if-gtz v32, :cond_128

    :cond_103
    const/4 v6, 0x1

    .line 856
    .local v6, angleMatches:Z
    :goto_104
    if-eqz v6, :cond_115

    move-object/from16 v0, p0

    move/from16 v1, v28

    move/from16 v2, v29

    invoke-direct {v0, v1, v2}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->dist2(FF)F

    move-result v32

    cmpl-float v32, v32, v18

    if-lez v32, :cond_115

    .line 857
    move v5, v12

    .line 846
    .end local v6           #angleMatches:Z
    :cond_115
    add-int/lit8 v12, v12, 0x1

    goto :goto_a1

    .line 826
    .end local v7           #angleRad:D
    .end local v9           #eventX:F
    .end local v10           #eventY:F
    .end local v12           #i:I
    .end local v14           #limitX:F
    .end local v15           #limitY:F
    .end local v17           #scale:F
    .end local v18           #snapDistance2:F
    .end local v19           #snapRadius:F
    .end local v20           #target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    .end local v22           #targetMaxRad:D
    .end local v24           #targetMinRad:D
    .end local v27           #touchRadius:F
    .end local v28           #tx:F
    .end local v29           #ty:F
    :cond_118
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    goto/16 :goto_22

    .line 827
    .restart local v9       #eventX:F
    :cond_11e
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v10

    goto/16 :goto_2a

    .line 832
    .restart local v10       #eventY:F
    .restart local v27       #touchRadius:F
    .restart local v28       #tx:F
    .restart local v29       #ty:F
    :cond_124
    const/high16 v17, 0x3f80

    goto/16 :goto_64

    .line 852
    .restart local v7       #angleRad:D
    .restart local v12       #i:I
    .restart local v14       #limitX:F
    .restart local v15       #limitY:F
    .restart local v17       #scale:F
    .restart local v18       #snapDistance2:F
    .restart local v19       #snapRadius:F
    .restart local v20       #target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    .restart local v22       #targetMaxRad:D
    .restart local v24       #targetMinRad:D
    :cond_128
    const/4 v6, 0x0

    goto :goto_104

    .line 862
    .end local v12           #i:I
    .end local v18           #snapDistance2:F
    .end local v19           #snapRadius:F
    .end local v20           #target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    .end local v22           #targetMaxRad:D
    .end local v24           #targetMinRad:D
    :cond_12a
    move/from16 v30, v14

    .line 863
    move/from16 v31, v15

    .line 825
    add-int/lit8 v13, v13, 0x1

    goto/16 :goto_14

    .line 866
    .end local v7           #angleRad:D
    .end local v9           #eventX:F
    .end local v10           #eventY:F
    .end local v14           #limitX:F
    .end local v15           #limitY:F
    .end local v17           #scale:F
    .end local v27           #touchRadius:F
    .end local v28           #tx:F
    .end local v29           #ty:F
    :cond_132
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mDragging:Z

    move/from16 v32, v0

    if-nez v32, :cond_13b

    .line 905
    :goto_13a
    return-void

    .line 870
    :cond_13b
    const/16 v32, -0x1

    move/from16 v0, v32

    if-eq v5, v0, :cond_200

    .line 871
    const/16 v32, 0x4

    move-object/from16 v0, p0

    move/from16 v1, v32

    move/from16 v2, v30

    move/from16 v3, v31

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->switchToState(IFF)V

    .line 872
    const/16 v32, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v30

    move/from16 v2, v31

    move/from16 v3, v32

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->moveHandleTo(FFZ)V

    .line 879
    :goto_15b
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mHandleDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    move-object/from16 v32, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v32

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->invalidateGlobalRegion(Lcom/android/internal/widget/multiwaveview/TargetDrawable;)V

    .line 881
    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mActiveTarget:I

    move/from16 v32, v0

    move/from16 v0, v32

    if-eq v0, v5, :cond_1fa

    .line 883
    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mActiveTarget:I

    move/from16 v32, v0

    const/16 v33, -0x1

    move/from16 v0, v32

    move/from16 v1, v33

    if-eq v0, v1, :cond_1a5

    .line 884
    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mActiveTarget:I

    move/from16 v32, v0

    move-object/from16 v0, v26

    move/from16 v1, v32

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    .line 885
    .restart local v20       #target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    sget-object v32, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->STATE_FOCUSED:[I

    move-object/from16 v0, v20

    move-object/from16 v1, v32

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->hasState([I)Z

    move-result v32

    if-eqz v32, :cond_1a5

    .line 886
    sget-object v32, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->STATE_INACTIVE:[I

    move-object/from16 v0, v20

    move-object/from16 v1, v32

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setState([I)V

    .line 890
    .end local v20           #target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    :cond_1a5
    const/16 v32, -0x1

    move/from16 v0, v32

    if-eq v5, v0, :cond_21c

    .line 891
    move-object/from16 v0, v26

    invoke-virtual {v0, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    .line 892
    .restart local v20       #target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    sget-object v32, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->STATE_FOCUSED:[I

    move-object/from16 v0, v20

    move-object/from16 v1, v32

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->hasState([I)Z

    move-result v32

    if-eqz v32, :cond_1c8

    .line 893
    sget-object v32, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->STATE_FOCUSED:[I

    move-object/from16 v0, v20

    move-object/from16 v1, v32

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setState([I)V

    .line 895
    :cond_1c8
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/View;->mContext:Landroid/content/Context;

    move-object/from16 v32, v0

    invoke-static/range {v32 .. v32}, Landroid/view/accessibility/AccessibilityManager;->getInstance(Landroid/content/Context;)Landroid/view/accessibility/AccessibilityManager;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Landroid/view/accessibility/AccessibilityManager;->isEnabled()Z

    move-result v32

    if-eqz v32, :cond_1e5

    .line 896
    move-object/from16 v0, p0

    invoke-direct {v0, v5}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->getTargetDescription(I)Ljava/lang/String;

    move-result-object v21

    .line 897
    .local v21, targetContentDescription:Ljava/lang/String;
    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-direct {v0, v1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->announceText(Ljava/lang/String;)V

    .line 899
    .end local v21           #targetContentDescription:Ljava/lang/String;
    :cond_1e5
    const/16 v32, 0x0

    const/16 v33, 0x0

    const/16 v34, 0x0

    const/16 v35, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v32

    move/from16 v2, v33

    move/from16 v3, v34

    move-object/from16 v4, v35

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->activateHandle(IIFLandroid/animation/Animator$AnimatorListener;)V

    .line 904
    .end local v20           #target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    :cond_1fa
    :goto_1fa
    move-object/from16 v0, p0

    iput v5, v0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mActiveTarget:I

    goto/16 :goto_13a

    .line 874
    :cond_200
    const/16 v32, 0x3

    move-object/from16 v0, p0

    move/from16 v1, v32

    move/from16 v2, v30

    move/from16 v3, v31

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->switchToState(IFF)V

    .line 875
    const/16 v32, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v30

    move/from16 v2, v31

    move/from16 v3, v32

    invoke-direct {v0, v1, v2, v3}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->moveHandleTo(FFZ)V

    goto/16 :goto_15b

    .line 901
    :cond_21c
    const/16 v32, 0x0

    const/16 v33, 0x0

    const/high16 v34, 0x3f80

    const/16 v35, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v32

    move/from16 v2, v33

    move/from16 v3, v34

    move-object/from16 v4, v35

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->activateHandle(IIFLandroid/animation/Animator$AnimatorListener;)V

    goto :goto_1fa
.end method

.method private handleUp(Landroid/view/MotionEvent;)V
    .registers 5
    .parameter "event"

    .prologue
    .line 802
    const/4 v0, 0x5

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v2

    invoke-direct {p0, v0, v1, v2}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->switchToState(IFF)V

    .line 803
    return-void
.end method

.method private hideChevrons()V
    .registers 6

    .prologue
    .line 1067
    iget-object v1, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mChevronDrawables:Ljava/util/ArrayList;

    .line 1068
    .local v1, chevrons:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Lcom/android/internal/widget/multiwaveview/TargetDrawable;>;"
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v3

    .line 1069
    .local v3, size:I
    const/4 v2, 0x0

    .local v2, i:I
    :goto_7
    if-ge v2, v3, :cond_18

    .line 1070
    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    .line 1071
    .local v0, chevron:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    if-eqz v0, :cond_15

    .line 1072
    const/4 v4, 0x0

    invoke-virtual {v0, v4}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setAlpha(F)V

    .line 1069
    :cond_15
    add-int/lit8 v2, v2, 0x1

    goto :goto_7

    .line 1075
    .end local v0           #chevron:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    :cond_18
    return-void
.end method

.method private hideTargets(ZZ)V
    .registers 17
    .parameter "animate"
    .parameter "expanded"

    .prologue
    .line 533
    iget-object v7, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    invoke-virtual {v7}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->cancel()V

    .line 536
    iput-boolean p1, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mAnimatingTargets:Z

    .line 537
    if-eqz p1, :cond_86

    const/16 v1, 0xc8

    .line 538
    .local v1, duration:I
    :goto_b
    if-eqz p1, :cond_88

    const/16 v0, 0xc8

    .line 540
    .local v0, delay:I
    :goto_f
    if-eqz p2, :cond_8a

    const/high16 v6, 0x3f80

    .line 541
    .local v6, targetScale:F
    :goto_13
    iget-object v7, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDrawables:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v3

    .line 542
    .local v3, length:I
    const/4 v2, 0x0

    .local v2, i:I
    :goto_1a
    if-ge v2, v3, :cond_8e

    .line 543
    iget-object v7, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDrawables:Ljava/util/ArrayList;

    invoke-virtual {v7, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    .line 544
    .local v5, target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    sget-object v7, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->STATE_INACTIVE:[I

    invoke-virtual {v5, v7}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setState([I)V

    .line 545
    iget-object v7, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    int-to-long v8, v1

    const/16 v10, 0xc

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    const-string v12, "ease"

    aput-object v12, v10, v11

    const/4 v11, 0x1

    sget-object v12, Lcom/android/internal/widget/multiwaveview/Ease$Cubic;->easeOut:Landroid/animation/TimeInterpolator;

    aput-object v12, v10, v11

    const/4 v11, 0x2

    const-string v12, "alpha"

    aput-object v12, v10, v11

    const/4 v11, 0x3

    const/4 v12, 0x0

    invoke-static {v12}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v12

    aput-object v12, v10, v11

    const/4 v11, 0x4

    const-string/jumbo v12, "scaleX"

    aput-object v12, v10, v11

    const/4 v11, 0x5

    invoke-static {v6}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v12

    aput-object v12, v10, v11

    const/4 v11, 0x6

    const-string/jumbo v12, "scaleY"

    aput-object v12, v10, v11

    const/4 v11, 0x7

    invoke-static {v6}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v12

    aput-object v12, v10, v11

    const/16 v11, 0x8

    const-string v12, "delay"

    aput-object v12, v10, v11

    const/16 v11, 0x9

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    aput-object v12, v10, v11

    const/16 v11, 0xa

    const-string/jumbo v12, "onUpdate"

    aput-object v12, v10, v11

    const/16 v11, 0xb

    iget-object v12, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mUpdateListener:Landroid/animation/ValueAnimator$AnimatorUpdateListener;

    aput-object v12, v10, v11

    invoke-static {v5, v8, v9, v10}, Lcom/android/internal/widget/multiwaveview/Tweener;->to(Ljava/lang/Object;J[Ljava/lang/Object;)Lcom/android/internal/widget/multiwaveview/Tweener;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->add(Ljava/lang/Object;)Z

    .line 542
    add-int/lit8 v2, v2, 0x1

    goto :goto_1a

    .line 537
    .end local v0           #delay:I
    .end local v1           #duration:I
    .end local v2           #i:I
    .end local v3           #length:I
    .end local v5           #target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    .end local v6           #targetScale:F
    :cond_86
    const/4 v1, 0x0

    goto :goto_b

    .line 538
    .restart local v1       #duration:I
    :cond_88
    const/4 v0, 0x0

    goto :goto_f

    .line 540
    .restart local v0       #delay:I
    :cond_8a
    const v6, 0x3f4ccccd

    goto :goto_13

    .line 554
    .restart local v2       #i:I
    .restart local v3       #length:I
    .restart local v6       #targetScale:F
    :cond_8e
    if-eqz p2, :cond_101

    const/high16 v4, 0x3f80

    .line 555
    .local v4, ringScaleTarget:F
    :goto_92
    iget-object v7, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    iget-object v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOuterRing:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    int-to-long v9, v1

    const/16 v11, 0xe

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    const-string v13, "ease"

    aput-object v13, v11, v12

    const/4 v12, 0x1

    sget-object v13, Lcom/android/internal/widget/multiwaveview/Ease$Cubic;->easeOut:Landroid/animation/TimeInterpolator;

    aput-object v13, v11, v12

    const/4 v12, 0x2

    const-string v13, "alpha"

    aput-object v13, v11, v12

    const/4 v12, 0x3

    const/4 v13, 0x0

    invoke-static {v13}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v13

    aput-object v13, v11, v12

    const/4 v12, 0x4

    const-string/jumbo v13, "scaleX"

    aput-object v13, v11, v12

    const/4 v12, 0x5

    invoke-static {v4}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v13

    aput-object v13, v11, v12

    const/4 v12, 0x6

    const-string/jumbo v13, "scaleY"

    aput-object v13, v11, v12

    const/4 v12, 0x7

    invoke-static {v4}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v13

    aput-object v13, v11, v12

    const/16 v12, 0x8

    const-string v13, "delay"

    aput-object v13, v11, v12

    const/16 v12, 0x9

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v13

    aput-object v13, v11, v12

    const/16 v12, 0xa

    const-string/jumbo v13, "onUpdate"

    aput-object v13, v11, v12

    const/16 v12, 0xb

    iget-object v13, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mUpdateListener:Landroid/animation/ValueAnimator$AnimatorUpdateListener;

    aput-object v13, v11, v12

    const/16 v12, 0xc

    const-string/jumbo v13, "onComplete"

    aput-object v13, v11, v12

    const/16 v12, 0xd

    iget-object v13, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetUpdateListener:Landroid/animation/Animator$AnimatorListener;

    aput-object v13, v11, v12

    invoke-static {v8, v9, v10, v11}, Lcom/android/internal/widget/multiwaveview/Tweener;->to(Ljava/lang/Object;J[Ljava/lang/Object;)Lcom/android/internal/widget/multiwaveview/Tweener;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->add(Ljava/lang/Object;)Z

    .line 564
    iget-object v7, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    invoke-virtual {v7}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->start()V

    .line 565
    return-void

    .line 554
    .end local v4           #ringScaleTarget:F
    :cond_101
    const/high16 v4, 0x3f00

    goto :goto_92
.end method

.method private hideUnselected(I)V
    .registers 5
    .parameter "active"

    .prologue
    .line 525
    const/4 v0, 0x0

    .local v0, i:I
    :goto_1
    iget-object v1, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDrawables:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ge v0, v1, :cond_1a

    .line 526
    if-eq v0, p1, :cond_17

    .line 527
    iget-object v1, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDrawables:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setAlpha(F)V

    .line 525
    :cond_17
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 530
    :cond_1a
    return-void
.end method

.method private highlightSelected(I)V
    .registers 4
    .parameter "activeTarget"

    .prologue
    .line 520
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDrawables:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    sget-object v1, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->STATE_ACTIVE:[I

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setState([I)V

    .line 521
    invoke-direct {p0, p1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->hideUnselected(I)V

    .line 522
    return-void
.end method

.method private internalSetTargetResources(I)V
    .registers 9
    .parameter "resourceId"

    .prologue
    .line 617
    invoke-direct {p0, p1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->loadDrawableArray(I)Ljava/util/ArrayList;

    move-result-object v5

    iput-object v5, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDrawables:Ljava/util/ArrayList;

    .line 618
    iput p1, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetResourceId:I

    .line 619
    iget-object v5, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDrawables:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 620
    .local v0, count:I
    iget-object v5, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mHandleDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    invoke-virtual {v5}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->getWidth()I

    move-result v3

    .line 621
    .local v3, maxWidth:I
    iget-object v5, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mHandleDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    invoke-virtual {v5}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->getHeight()I

    move-result v2

    .line 622
    .local v2, maxHeight:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_1b
    if-ge v1, v0, :cond_38

    .line 623
    iget-object v5, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDrawables:Ljava/util/ArrayList;

    invoke-virtual {v5, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    .line 624
    .local v4, target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    invoke-virtual {v4}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->getWidth()I

    move-result v5

    invoke-static {v3, v5}, Ljava/lang/Math;->max(II)I

    move-result v3

    .line 625
    invoke-virtual {v4}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->getHeight()I

    move-result v5

    invoke-static {v2, v5}, Ljava/lang/Math;->max(II)I

    move-result v2

    .line 622
    add-int/lit8 v1, v1, 0x1

    goto :goto_1b

    .line 627
    .end local v4           #target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    :cond_38
    iget v5, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mMaxTargetWidth:I

    if-ne v5, v3, :cond_40

    iget v5, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mMaxTargetHeight:I

    if-eq v5, v2, :cond_48

    .line 628
    :cond_40
    iput v3, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mMaxTargetWidth:I

    .line 629
    iput v2, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mMaxTargetHeight:I

    .line 630
    invoke-virtual {p0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->requestLayout()V

    .line 635
    :goto_47
    return-void

    .line 632
    :cond_48
    iget v5, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mWaveCenterX:F

    iget v6, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mWaveCenterY:F

    invoke-direct {p0, v5, v6}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->updateTargetPositions(FF)V

    .line 633
    iget v5, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mWaveCenterX:F

    iget v6, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mWaveCenterY:F

    invoke-direct {p0, v5, v6}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->updateChevronPositions(FF)V

    goto :goto_47
.end method

.method private loadDescriptions(I)Ljava/util/ArrayList;
    .registers 8
    .parameter "resourceId"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1167
    invoke-virtual {p0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5, p1}, Landroid/content/res/Resources;->obtainTypedArray(I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 1168
    .local v0, array:Landroid/content/res/TypedArray;
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->length()I

    move-result v2

    .line 1169
    .local v2, count:I
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4, v2}, Ljava/util/ArrayList;-><init>(I)V

    .line 1170
    .local v4, targetContentDescriptions:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/lang/String;>;"
    const/4 v3, 0x0

    .local v3, i:I
    :goto_16
    if-ge v3, v2, :cond_22

    .line 1171
    invoke-virtual {v0, v3}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 1172
    .local v1, contentDescription:Ljava/lang/String;
    invoke-virtual {v4, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1170
    add-int/lit8 v3, v3, 0x1

    goto :goto_16

    .line 1174
    .end local v1           #contentDescription:Ljava/lang/String;
    :cond_22
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 1175
    return-object v4
.end method

.method private loadDrawableArray(I)Ljava/util/ArrayList;
    .registers 10
    .parameter "resourceId"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/internal/widget/multiwaveview/TargetDrawable;",
            ">;"
        }
    .end annotation

    .prologue
    .line 603
    invoke-virtual {p0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->getContext()Landroid/content/Context;

    move-result-object v7

    invoke-virtual {v7}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    .line 604
    .local v4, res:Landroid/content/res/Resources;
    invoke-virtual {v4, p1}, Landroid/content/res/Resources;->obtainTypedArray(I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 605
    .local v0, array:Landroid/content/res/TypedArray;
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->length()I

    move-result v1

    .line 606
    .local v1, count:I
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2, v1}, Ljava/util/ArrayList;-><init>(I)V

    .line 607
    .local v2, drawables:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Lcom/android/internal/widget/multiwaveview/TargetDrawable;>;"
    const/4 v3, 0x0

    .local v3, i:I
    :goto_16
    if-ge v3, v1, :cond_2d

    .line 608
    invoke-virtual {v0, v3}, Landroid/content/res/TypedArray;->peekValue(I)Landroid/util/TypedValue;

    move-result-object v6

    .line 609
    .local v6, value:Landroid/util/TypedValue;
    new-instance v5, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    if-eqz v6, :cond_2b

    iget v7, v6, Landroid/util/TypedValue;->resourceId:I

    :goto_22
    invoke-direct {v5, v4, v7}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;-><init>(Landroid/content/res/Resources;I)V

    .line 610
    .local v5, target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    invoke-virtual {v2, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 607
    add-int/lit8 v3, v3, 0x1

    goto :goto_16

    .line 609
    .end local v5           #target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    :cond_2b
    const/4 v7, 0x0

    goto :goto_22

    .line 612
    .end local v6           #value:Landroid/util/TypedValue;
    :cond_2d
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 613
    return-object v2
.end method

.method private moveHandleTo(FFZ)V
    .registers 5
    .parameter "x"
    .parameter "y"
    .parameter "animate"

    .prologue
    .line 786
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mHandleDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    invoke-virtual {v0, p1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setX(F)V

    .line 787
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mHandleDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    invoke-virtual {v0, p2}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setY(F)V

    .line 788
    return-void
.end method

.method private replaceTargetDrawables(Landroid/content/res/Resources;II)Z
    .registers 10
    .parameter "res"
    .parameter "existingResourceId"
    .parameter "newResourceId"

    .prologue
    .line 1210
    if-eqz p2, :cond_4

    if-nez p3, :cond_6

    .line 1211
    :cond_4
    const/4 v2, 0x0

    .line 1229
    :cond_5
    :goto_5
    return v2

    .line 1214
    :cond_6
    const/4 v2, 0x0

    .line 1215
    .local v2, result:Z
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDrawables:Ljava/util/ArrayList;

    .line 1216
    .local v0, drawables:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Lcom/android/internal/widget/multiwaveview/TargetDrawable;>;"
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v3

    .line 1217
    .local v3, size:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_e
    if-ge v1, v3, :cond_25

    .line 1218
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    .line 1219
    .local v4, target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    if-eqz v4, :cond_22

    invoke-virtual {v4}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->getResourceId()I

    move-result v5

    if-ne v5, p2, :cond_22

    .line 1220
    invoke-virtual {v4, p1, p3}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setDrawable(Landroid/content/res/Resources;I)V

    .line 1221
    const/4 v2, 0x1

    .line 1217
    :cond_22
    add-int/lit8 v1, v1, 0x1

    goto :goto_e

    .line 1225
    .end local v4           #target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    :cond_25
    if-eqz v2, :cond_5

    .line 1226
    invoke-virtual {p0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->requestLayout()V

    goto :goto_5
.end method

.method private resolveMeasured(II)I
    .registers 6
    .parameter "measureSpec"
    .parameter "desired"

    .prologue
    .line 317
    const/4 v0, 0x0

    .line 318
    .local v0, result:I
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v1

    .line 319
    .local v1, specSize:I
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v2

    sparse-switch v2, :sswitch_data_16

    .line 328
    move v0, v1

    .line 330
    :goto_d
    return v0

    .line 321
    :sswitch_e
    move v0, p2

    .line 322
    goto :goto_d

    .line 324
    :sswitch_10
    invoke-static {v1, p2}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 325
    goto :goto_d

    .line 319
    nop

    :sswitch_data_16
    .sparse-switch
        -0x80000000 -> :sswitch_10
        0x0 -> :sswitch_e
    .end sparse-switch
.end method

.method private setGrabbedState(I)V
    .registers 4
    .parameter "newState"

    .prologue
    const/4 v1, 0x1

    .line 933
    iget v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mGrabbedState:I

    if-eq p1, v0, :cond_1c

    .line 934
    if-eqz p1, :cond_a

    .line 935
    invoke-direct {p0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->vibrate()V

    .line 937
    :cond_a
    iput p1, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mGrabbedState:I

    .line 938
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOnTriggerListener:Lcom/android/internal/widget/multiwaveview/MultiWaveView$OnTriggerListener;

    if-eqz v0, :cond_1c

    .line 939
    if-nez p1, :cond_1d

    .line 940
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOnTriggerListener:Lcom/android/internal/widget/multiwaveview/MultiWaveView$OnTriggerListener;

    invoke-interface {v0, p0, v1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$OnTriggerListener;->onReleased(Landroid/view/View;I)V

    .line 944
    :goto_17
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOnTriggerListener:Lcom/android/internal/widget/multiwaveview/MultiWaveView$OnTriggerListener;

    invoke-interface {v0, p0, p1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$OnTriggerListener;->onGrabbedStateChange(Landroid/view/View;I)V

    .line 947
    :cond_1c
    return-void

    .line 942
    :cond_1d
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOnTriggerListener:Lcom/android/internal/widget/multiwaveview/MultiWaveView$OnTriggerListener;

    invoke-interface {v0, p0, v1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$OnTriggerListener;->onGrabbed(Landroid/view/View;I)V

    goto :goto_17
.end method

.method private showTargets(Z)V
    .registers 14
    .parameter "animate"

    .prologue
    .line 568
    iget-object v5, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    invoke-virtual {v5}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->stop()V

    .line 569
    iput-boolean p1, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mAnimatingTargets:Z

    .line 570
    if-eqz p1, :cond_87

    const/16 v0, 0x32

    .line 571
    .local v0, delay:I
    :goto_b
    if-eqz p1, :cond_89

    const/16 v1, 0xc8

    .line 572
    .local v1, duration:I
    :goto_f
    iget-object v5, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDrawables:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v3

    .line 573
    .local v3, length:I
    const/4 v2, 0x0

    .local v2, i:I
    :goto_16
    if-ge v2, v3, :cond_8b

    .line 574
    iget-object v5, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDrawables:Ljava/util/ArrayList;

    invoke-virtual {v5, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    .line 575
    .local v4, target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    sget-object v5, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->STATE_INACTIVE:[I

    invoke-virtual {v4, v5}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setState([I)V

    .line 576
    iget-object v5, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    int-to-long v6, v1

    const/16 v8, 0xc

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    const-string v10, "ease"

    aput-object v10, v8, v9

    const/4 v9, 0x1

    sget-object v10, Lcom/android/internal/widget/multiwaveview/Ease$Cubic;->easeOut:Landroid/animation/TimeInterpolator;

    aput-object v10, v8, v9

    const/4 v9, 0x2

    const-string v10, "alpha"

    aput-object v10, v8, v9

    const/4 v9, 0x3

    const/high16 v10, 0x3f80

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x4

    const-string/jumbo v10, "scaleX"

    aput-object v10, v8, v9

    const/4 v9, 0x5

    const/high16 v10, 0x3f80

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x6

    const-string/jumbo v10, "scaleY"

    aput-object v10, v8, v9

    const/4 v9, 0x7

    const/high16 v10, 0x3f80

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v10

    aput-object v10, v8, v9

    const/16 v9, 0x8

    const-string v10, "delay"

    aput-object v10, v8, v9

    const/16 v9, 0x9

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v8, v9

    const/16 v9, 0xa

    const-string/jumbo v10, "onUpdate"

    aput-object v10, v8, v9

    const/16 v9, 0xb

    iget-object v10, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mUpdateListener:Landroid/animation/ValueAnimator$AnimatorUpdateListener;

    aput-object v10, v8, v9

    invoke-static {v4, v6, v7, v8}, Lcom/android/internal/widget/multiwaveview/Tweener;->to(Ljava/lang/Object;J[Ljava/lang/Object;)Lcom/android/internal/widget/multiwaveview/Tweener;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->add(Ljava/lang/Object;)Z

    .line 573
    add-int/lit8 v2, v2, 0x1

    goto :goto_16

    .line 570
    .end local v0           #delay:I
    .end local v1           #duration:I
    .end local v2           #i:I
    .end local v3           #length:I
    .end local v4           #target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    :cond_87
    const/4 v0, 0x0

    goto :goto_b

    .line 571
    .restart local v0       #delay:I
    :cond_89
    const/4 v1, 0x0

    goto :goto_f

    .line 584
    .restart local v1       #duration:I
    .restart local v2       #i:I
    .restart local v3       #length:I
    :cond_8b
    iget-object v5, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    iget-object v6, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOuterRing:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    int-to-long v7, v1

    const/16 v9, 0xe

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    const-string v11, "ease"

    aput-object v11, v9, v10

    const/4 v10, 0x1

    sget-object v11, Lcom/android/internal/widget/multiwaveview/Ease$Cubic;->easeOut:Landroid/animation/TimeInterpolator;

    aput-object v11, v9, v10

    const/4 v10, 0x2

    const-string v11, "alpha"

    aput-object v11, v9, v10

    const/4 v10, 0x3

    const/high16 v11, 0x3f80

    invoke-static {v11}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v11

    aput-object v11, v9, v10

    const/4 v10, 0x4

    const-string/jumbo v11, "scaleX"

    aput-object v11, v9, v10

    const/4 v10, 0x5

    const/high16 v11, 0x3f80

    invoke-static {v11}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v11

    aput-object v11, v9, v10

    const/4 v10, 0x6

    const-string/jumbo v11, "scaleY"

    aput-object v11, v9, v10

    const/4 v10, 0x7

    const/high16 v11, 0x3f80

    invoke-static {v11}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

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

    iget-object v11, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mUpdateListener:Landroid/animation/ValueAnimator$AnimatorUpdateListener;

    aput-object v11, v9, v10

    const/16 v10, 0xc

    const-string/jumbo v11, "onComplete"

    aput-object v11, v9, v10

    const/16 v10, 0xd

    iget-object v11, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetUpdateListener:Landroid/animation/Animator$AnimatorListener;

    aput-object v11, v9, v10

    invoke-static {v6, v7, v8, v9}, Lcom/android/internal/widget/multiwaveview/Tweener;->to(Ljava/lang/Object;J[Ljava/lang/Object;)Lcom/android/internal/widget/multiwaveview/Tweener;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->add(Ljava/lang/Object;)Z

    .line 593
    iget-object v5, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    invoke-virtual {v5}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->start()V

    .line 594
    return-void
.end method

.method private square(F)F
    .registers 3
    .parameter "d"

    .prologue
    .line 1102
    mul-float v0, p1, p1

    return v0
.end method

.method private startBackgroundAnimation(IF)V
    .registers 11
    .parameter "duration"
    .parameter "alpha"

    .prologue
    const/4 v5, 0x2

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 737
    invoke-virtual {p0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 738
    .local v0, background:Landroid/graphics/drawable/Drawable;
    iget-boolean v1, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mAlwaysTrackFinger:Z

    if-eqz v1, :cond_50

    if-eqz v0, :cond_50

    .line 739
    iget-object v1, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mBackgroundAnimator:Lcom/android/internal/widget/multiwaveview/Tweener;

    if-eqz v1, :cond_18

    .line 740
    iget-object v1, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mBackgroundAnimator:Lcom/android/internal/widget/multiwaveview/Tweener;

    iget-object v1, v1, Lcom/android/internal/widget/multiwaveview/Tweener;->animator:Landroid/animation/ObjectAnimator;

    invoke-virtual {v1}, Landroid/animation/ObjectAnimator;->end()V

    .line 742
    :cond_18
    int-to-long v1, p1

    const/4 v3, 0x6

    new-array v3, v3, [Ljava/lang/Object;

    const-string v4, "ease"

    aput-object v4, v3, v6

    sget-object v4, Lcom/android/internal/widget/multiwaveview/Ease$Cubic;->easeIn:Landroid/animation/TimeInterpolator;

    aput-object v4, v3, v7

    const-string v4, "alpha"

    aput-object v4, v3, v5

    const/4 v4, 0x3

    new-array v5, v5, [I

    aput v6, v5, v6

    const/high16 v6, 0x437f

    mul-float/2addr v6, p2

    float-to-int v6, v6

    aput v6, v5, v7

    aput-object v5, v3, v4

    const/4 v4, 0x4

    const-string v5, "delay"

    aput-object v5, v3, v4

    const/4 v4, 0x5

    const/16 v5, 0x32

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v0, v1, v2, v3}, Lcom/android/internal/widget/multiwaveview/Tweener;->to(Ljava/lang/Object;J[Ljava/lang/Object;)Lcom/android/internal/widget/multiwaveview/Tweener;

    move-result-object v1

    iput-object v1, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mBackgroundAnimator:Lcom/android/internal/widget/multiwaveview/Tweener;

    .line 746
    iget-object v1, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mBackgroundAnimator:Lcom/android/internal/widget/multiwaveview/Tweener;

    iget-object v1, v1, Lcom/android/internal/widget/multiwaveview/Tweener;->animator:Landroid/animation/ObjectAnimator;

    invoke-virtual {v1}, Landroid/animation/ObjectAnimator;->start()V

    .line 748
    :cond_50
    return-void
.end method

.method private startChevronAnimation()V
    .registers 25

    .prologue
    .line 412
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mHandleDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->getWidth()I

    move-result v18

    move/from16 v0, v18

    int-to-float v0, v0

    move/from16 v18, v0

    const v19, 0x3f4ccccd

    mul-float v5, v18, v19

    .line 413
    .local v5, chevronStartDistance:F
    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOuterRadius:F

    move/from16 v18, v0

    const v19, 0x3f666666

    mul-float v18, v18, v19

    const/high16 v19, 0x4000

    div-float v6, v18, v19

    .line 414
    .local v6, chevronStopDistance:F
    const/high16 v13, 0x3f00

    .line 415
    .local v13, startScale:F
    const/high16 v11, 0x4000

    .line 416
    .local v11, endScale:F
    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mFeedbackCount:I

    move/from16 v18, v0

    if-lez v18, :cond_c0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mChevronDrawables:Ljava/util/ArrayList;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Ljava/util/ArrayList;->size()I

    move-result v18

    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mFeedbackCount:I

    move/from16 v19, v0

    div-int v10, v18, v19

    .line 418
    .local v10, directionCount:I
    :goto_41
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mChevronAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->stop()V

    .line 422
    const/4 v9, 0x0

    .local v9, direction:I
    :goto_4b
    if-ge v9, v10, :cond_169

    .line 423
    const-wide v18, 0x401921fb54442d18L

    int-to-double v0, v9

    move-wide/from16 v20, v0

    mul-double v18, v18, v20

    int-to-double v0, v10

    move-wide/from16 v20, v0

    div-double v3, v18, v20

    .line 424
    .local v3, angle:D
    invoke-static {v3, v4}, Ljava/lang/Math;->cos(D)D

    move-result-wide v18

    move-wide/from16 v0, v18

    double-to-float v14, v0

    .line 425
    .local v14, sx:F
    const/16 v18, 0x0

    invoke-static {v3, v4}, Ljava/lang/Math;->sin(D)D

    move-result-wide v19

    move-wide/from16 v0, v19

    double-to-float v0, v0

    move/from16 v19, v0

    sub-float v15, v18, v19

    .line 426
    .local v15, sy:F
    const/16 v18, 0x2

    move/from16 v0, v18

    new-array v0, v0, [F

    move-object/from16 v16, v0

    const/16 v18, 0x0

    mul-float v19, v14, v5

    aput v19, v16, v18

    const/16 v18, 0x1

    mul-float v19, v14, v6

    aput v19, v16, v18

    .line 428
    .local v16, xrange:[F
    const/16 v18, 0x2

    move/from16 v0, v18

    new-array v0, v0, [F

    move-object/from16 v17, v0

    const/16 v18, 0x0

    mul-float v19, v15, v5

    aput v19, v17, v18

    const/16 v18, 0x1

    mul-float v19, v15, v6

    aput v19, v17, v18

    .line 430
    .local v17, yrange:[F
    const/4 v7, 0x0

    .local v7, count:I
    :goto_99
    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mFeedbackCount:I

    move/from16 v18, v0

    move/from16 v0, v18

    if-ge v7, v0, :cond_165

    .line 431
    mul-int/lit16 v8, v7, 0xa0

    .line 432
    .local v8, delay:I
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mChevronDrawables:Ljava/util/ArrayList;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mFeedbackCount:I

    move/from16 v19, v0

    mul-int v19, v19, v9

    add-int v19, v19, v7

    invoke-virtual/range {v18 .. v19}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    .line 433
    .local v12, icon:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    if-nez v12, :cond_c2

    .line 430
    :goto_bd
    add-int/lit8 v7, v7, 0x1

    goto :goto_99

    .line 416
    .end local v3           #angle:D
    .end local v7           #count:I
    .end local v8           #delay:I
    .end local v9           #direction:I
    .end local v10           #directionCount:I
    .end local v12           #icon:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    .end local v14           #sx:F
    .end local v15           #sy:F
    .end local v16           #xrange:[F
    .end local v17           #yrange:[F
    :cond_c0
    const/4 v10, 0x0

    goto :goto_41

    .line 436
    .restart local v3       #angle:D
    .restart local v7       #count:I
    .restart local v8       #delay:I
    .restart local v9       #direction:I
    .restart local v10       #directionCount:I
    .restart local v12       #icon:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    .restart local v14       #sx:F
    .restart local v15       #sy:F
    .restart local v16       #xrange:[F
    .restart local v17       #yrange:[F
    :cond_c2
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mChevronAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    move-object/from16 v18, v0

    const-wide/16 v19, 0x352

    const/16 v21, 0x10

    move/from16 v0, v21

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v21, v0

    const/16 v22, 0x0

    const-string v23, "ease"

    aput-object v23, v21, v22

    const/16 v22, 0x1

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mChevronAnimationInterpolator:Landroid/animation/TimeInterpolator;

    move-object/from16 v23, v0

    aput-object v23, v21, v22

    const/16 v22, 0x2

    const-string v23, "delay"

    aput-object v23, v21, v22

    const/16 v22, 0x3

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v23

    aput-object v23, v21, v22

    const/16 v22, 0x4

    const-string/jumbo v23, "x"

    aput-object v23, v21, v22

    const/16 v22, 0x5

    aput-object v16, v21, v22

    const/16 v22, 0x6

    const-string/jumbo v23, "y"

    aput-object v23, v21, v22

    const/16 v22, 0x7

    aput-object v17, v21, v22

    const/16 v22, 0x8

    const-string v23, "alpha"

    aput-object v23, v21, v22

    const/16 v22, 0x9

    const/16 v23, 0x2

    move/from16 v0, v23

    new-array v0, v0, [F

    move-object/from16 v23, v0

    fill-array-data v23, :array_174

    aput-object v23, v21, v22

    const/16 v22, 0xa

    const-string/jumbo v23, "scaleX"

    aput-object v23, v21, v22

    const/16 v22, 0xb

    const/16 v23, 0x2

    move/from16 v0, v23

    new-array v0, v0, [F

    move-object/from16 v23, v0

    fill-array-data v23, :array_17c

    aput-object v23, v21, v22

    const/16 v22, 0xc

    const-string/jumbo v23, "scaleY"

    aput-object v23, v21, v22

    const/16 v22, 0xd

    const/16 v23, 0x2

    move/from16 v0, v23

    new-array v0, v0, [F

    move-object/from16 v23, v0

    fill-array-data v23, :array_184

    aput-object v23, v21, v22

    const/16 v22, 0xe

    const-string/jumbo v23, "onUpdate"

    aput-object v23, v21, v22

    const/16 v22, 0xf

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mUpdateListener:Landroid/animation/ValueAnimator$AnimatorUpdateListener;

    move-object/from16 v23, v0

    aput-object v23, v21, v22

    move-wide/from16 v0, v19

    move-object/from16 v2, v21

    invoke-static {v12, v0, v1, v2}, Lcom/android/internal/widget/multiwaveview/Tweener;->to(Ljava/lang/Object;J[Ljava/lang/Object;)Lcom/android/internal/widget/multiwaveview/Tweener;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->add(Ljava/lang/Object;)Z

    goto/16 :goto_bd

    .line 422
    .end local v8           #delay:I
    .end local v12           #icon:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    :cond_165
    add-int/lit8 v9, v9, 0x1

    goto/16 :goto_4b

    .line 447
    .end local v3           #angle:D
    .end local v7           #count:I
    .end local v14           #sx:F
    .end local v15           #sy:F
    .end local v16           #xrange:[F
    .end local v17           #yrange:[F
    :cond_169
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mChevronAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->start()V

    .line 448
    return-void

    .line 436
    nop

    :array_174
    .array-data 0x4
        0x0t 0x0t 0x80t 0x3ft
        0x0t 0x0t 0x0t 0x0t
    .end array-data

    :array_17c
    .array-data 0x4
        0x0t 0x0t 0x0t 0x3ft
        0x0t 0x0t 0x0t 0x40t
    .end array-data

    :array_184
    .array-data 0x4
        0x0t 0x0t 0x0t 0x3ft
        0x0t 0x0t 0x0t 0x40t
    .end array-data
.end method

.method private switchToState(IFF)V
    .registers 9
    .parameter "state"
    .parameter "x"
    .parameter "y"

    .prologue
    const/high16 v4, 0x3f80

    const/4 v3, 0x0

    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 344
    packed-switch p1, :pswitch_data_4c

    .line 378
    :cond_8
    :goto_8
    :pswitch_8
    return-void

    .line 346
    :pswitch_9
    invoke-direct {p0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->deactivateTargets()V

    .line 347
    invoke-direct {p0, v2, v1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->hideTargets(ZZ)V

    .line 348
    invoke-direct {p0, v1, v3}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->startBackgroundAnimation(IF)V

    .line 349
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mHandleDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    sget-object v1, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->STATE_INACTIVE:[I

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setState([I)V

    goto :goto_8

    .line 353
    :pswitch_1a
    const/4 v0, 0x0

    invoke-direct {p0, v1, v1, v4, v0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->deactivateHandle(IIFLandroid/animation/Animator$AnimatorListener;)V

    .line 354
    invoke-direct {p0, v1, v3}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->startBackgroundAnimation(IF)V

    goto :goto_8

    .line 358
    :pswitch_22
    invoke-direct {p0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->deactivateTargets()V

    .line 359
    invoke-direct {p0, v2}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->showTargets(Z)V

    .line 360
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mHandleDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    sget-object v1, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->STATE_ACTIVE:[I

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setState([I)V

    .line 361
    const/16 v0, 0xc8

    invoke-direct {p0, v0, v4}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->startBackgroundAnimation(IF)V

    .line 362
    invoke-direct {p0, v2}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->setGrabbedState(I)V

    .line 363
    iget-object v0, p0, Landroid/view/View;->mContext:Landroid/content/Context;

    invoke-static {v0}, Landroid/view/accessibility/AccessibilityManager;->getInstance(Landroid/content/Context;)Landroid/view/accessibility/AccessibilityManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/accessibility/AccessibilityManager;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_8

    .line 364
    invoke-direct {p0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->announceTargets()V

    goto :goto_8

    .line 375
    :pswitch_47
    invoke-direct {p0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->doFinish()V

    goto :goto_8

    .line 344
    nop

    :pswitch_data_4c
    .packed-switch 0x0
        :pswitch_9
        :pswitch_1a
        :pswitch_22
        :pswitch_8
        :pswitch_8
        :pswitch_47
    .end packed-switch
.end method

.method private trySwitchToFirstTouchState(FF)Z
    .registers 9
    .parameter "x"
    .parameter "y"

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 950
    iget v4, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mWaveCenterX:F

    sub-float v0, p1, v4

    .line 951
    .local v0, tx:F
    iget v4, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mWaveCenterY:F

    sub-float v1, p2, v4

    .line 952
    .local v1, ty:F
    iget-boolean v4, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mAlwaysTrackFinger:Z

    if-nez v4, :cond_1a

    invoke-direct {p0, v0, v1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->dist2(FF)F

    move-result v4

    invoke-direct {p0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->getScaledTapRadiusSquared()F

    move-result v5

    cmpg-float v4, v4, v5

    if-gtz v4, :cond_24

    .line 954
    :cond_1a
    const/4 v4, 0x2

    invoke-direct {p0, v4, p1, p2}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->switchToState(IFF)V

    .line 955
    invoke-direct {p0, v0, v1, v2}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->moveHandleTo(FFZ)V

    .line 956
    iput-boolean v3, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mDragging:Z

    move v2, v3

    .line 959
    :cond_24
    return v2
.end method

.method private updateChevronPositions(FF)V
    .registers 7
    .parameter "centerX"
    .parameter "centerY"

    .prologue
    .line 1055
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mChevronDrawables:Ljava/util/ArrayList;

    .line 1056
    .local v0, chevrons:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Lcom/android/internal/widget/multiwaveview/TargetDrawable;>;"
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v2

    .line 1057
    .local v2, size:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_7
    if-ge v1, v2, :cond_1a

    .line 1058
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    .line 1059
    .local v3, target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    if-eqz v3, :cond_17

    .line 1060
    invoke-virtual {v3, p1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setPositionX(F)V

    .line 1061
    invoke-virtual {v3, p2}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setPositionY(F)V

    .line 1057
    :cond_17
    add-int/lit8 v1, v1, 0x1

    goto :goto_7

    .line 1064
    .end local v3           #target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    :cond_1a
    return-void
.end method

.method private updateTargetPositions(FF)V
    .registers 13
    .parameter "centerX"
    .parameter "centerY"

    .prologue
    .line 1041
    iget-object v5, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDrawables:Ljava/util/ArrayList;

    .line 1042
    .local v5, targets:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Lcom/android/internal/widget/multiwaveview/TargetDrawable;>;"
    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v3

    .line 1043
    .local v3, size:I
    const-wide v6, -0x3fe6de04abbbd2e8L

    int-to-double v8, v3

    div-double/2addr v6, v8

    double-to-float v0, v6

    .line 1044
    .local v0, alpha:F
    const/4 v2, 0x0

    .local v2, i:I
    :goto_f
    if-ge v2, v3, :cond_3b

    .line 1045
    invoke-virtual {v5, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    .line 1046
    .local v4, targetIcon:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    int-to-float v6, v2

    mul-float v1, v0, v6

    .line 1047
    .local v1, angle:F
    invoke-virtual {v4, p1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setPositionX(F)V

    .line 1048
    invoke-virtual {v4, p2}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setPositionY(F)V

    .line 1049
    iget v6, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOuterRadius:F

    float-to-double v7, v1

    invoke-static {v7, v8}, Ljava/lang/Math;->cos(D)D

    move-result-wide v7

    double-to-float v7, v7

    mul-float/2addr v6, v7

    invoke-virtual {v4, v6}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setX(F)V

    .line 1050
    iget v6, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOuterRadius:F

    float-to-double v7, v1

    invoke-static {v7, v8}, Ljava/lang/Math;->sin(D)D

    move-result-wide v7

    double-to-float v7, v7

    mul-float/2addr v6, v7

    invoke-virtual {v4, v6}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setY(F)V

    .line 1044
    add-int/lit8 v2, v2, 0x1

    goto :goto_f

    .line 1052
    .end local v1           #angle:F
    .end local v4           #targetIcon:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    :cond_3b
    return-void
.end method

.method private vibrate()V
    .registers 4

    .prologue
    .line 597
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mVibrator:Landroid/os/Vibrator;

    if-eqz v0, :cond_c

    .line 598
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mVibrator:Landroid/os/Vibrator;

    iget v1, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mVibrationDuration:I

    int-to-long v1, v1

    invoke-virtual {v0, v1, v2}, Landroid/os/Vibrator;->vibrate(J)V

    .line 600
    :cond_c
    return-void
.end method


# virtual methods
.method public getDirectionDescriptionsResourceId()I
    .registers 2

    .prologue
    .line 694
    iget v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mDirectionDescriptionsResourceId:I

    return v0
.end method

.method public getResourceIdForTarget(I)I
    .registers 4
    .parameter "index"

    .prologue
    .line 1179
    iget-object v1, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDrawables:Ljava/util/ArrayList;

    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    .line 1180
    .local v0, drawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    if-nez v0, :cond_c

    const/4 v1, 0x0

    :goto_b
    return v1

    :cond_c
    invoke-virtual {v0}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->getResourceId()I

    move-result v1

    goto :goto_b
.end method

.method protected getSuggestedMinimumHeight()I
    .registers 4

    .prologue
    .line 312
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOuterRing:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    invoke-virtual {v0}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->getHeight()I

    move-result v0

    int-to-float v0, v0

    const/high16 v1, 0x4000

    iget v2, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOuterRadius:F

    mul-float/2addr v1, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->max(FF)F

    move-result v0

    iget v1, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mMaxTargetHeight:I

    int-to-float v1, v1

    add-float/2addr v0, v1

    float-to-int v0, v0

    return v0
.end method

.method protected getSuggestedMinimumWidth()I
    .registers 4

    .prologue
    .line 305
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOuterRing:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    invoke-virtual {v0}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->getWidth()I

    move-result v0

    int-to-float v0, v0

    const/high16 v1, 0x4000

    iget v2, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOuterRadius:F

    mul-float/2addr v1, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->max(FF)F

    move-result v0

    iget v1, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mMaxTargetWidth:I

    int-to-float v1, v1

    add-float/2addr v0, v1

    float-to-int v0, v0

    return v0
.end method

.method public getTargetDescriptionsResourceId()I
    .registers 2

    .prologue
    .line 673
    iget v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDescriptionsResourceId:I

    return v0
.end method

.method public getTargetPosition(I)I
    .registers 5
    .parameter "resourceId"

    .prologue
    .line 1199
    const/4 v0, 0x0

    .local v0, i:I
    :goto_1
    iget-object v2, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDrawables:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-ge v0, v2, :cond_1b

    .line 1200
    iget-object v2, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDrawables:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    .line 1201
    .local v1, target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    invoke-virtual {v1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->getResourceId()I

    move-result v2

    if-ne v2, p1, :cond_18

    .line 1205
    .end local v0           #i:I
    .end local v1           #target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    :goto_17
    return v0

    .line 1199
    .restart local v0       #i:I
    .restart local v1       #target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    :cond_18
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 1205
    .end local v1           #target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    :cond_1b
    const/4 v0, -0x1

    goto :goto_17
.end method

.method public getTargetResourceId()I
    .registers 2

    .prologue
    .line 652
    iget v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetResourceId:I

    return v0
.end method

.method invalidateGlobalRegion(Lcom/android/internal/widget/multiwaveview/TargetDrawable;)V
    .registers 11
    .parameter "drawable"

    .prologue
    const/4 v6, 0x0

    .line 460
    invoke-virtual {p1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->getWidth()I

    move-result v3

    .line 461
    .local v3, width:I
    invoke-virtual {p1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->getHeight()I

    move-result v1

    .line 462
    .local v1, height:I
    new-instance v0, Landroid/graphics/RectF;

    int-to-float v4, v3

    int-to-float v5, v1

    invoke-direct {v0, v6, v6, v4, v5}, Landroid/graphics/RectF;-><init>(FFFF)V

    .line 463
    .local v0, childBounds:Landroid/graphics/RectF;
    invoke-virtual {p1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->getX()F

    move-result v4

    div-int/lit8 v5, v3, 0x2

    int-to-float v5, v5

    sub-float/2addr v4, v5

    invoke-virtual {p1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->getY()F

    move-result v5

    div-int/lit8 v6, v1, 0x2

    int-to-float v6, v6

    sub-float/2addr v5, v6

    invoke-virtual {v0, v4, v5}, Landroid/graphics/RectF;->offset(FF)V

    .line 464
    move-object v2, p0

    .line 465
    .local v2, view:Landroid/view/View;
    :goto_24
    invoke-virtual {v2}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v4

    if-eqz v4, :cond_63

    invoke-virtual {v2}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v4

    instance-of v4, v4, Landroid/view/View;

    if-eqz v4, :cond_63

    .line 466
    invoke-virtual {v2}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v2

    .end local v2           #view:Landroid/view/View;
    check-cast v2, Landroid/view/View;

    .line 467
    .restart local v2       #view:Landroid/view/View;
    invoke-virtual {v2}, Landroid/view/View;->getMatrix()Landroid/graphics/Matrix;

    move-result-object v4

    invoke-virtual {v4, v0}, Landroid/graphics/Matrix;->mapRect(Landroid/graphics/RectF;)Z

    .line 468
    iget v4, v0, Landroid/graphics/RectF;->left:F

    float-to-double v4, v4

    invoke-static {v4, v5}, Ljava/lang/Math;->floor(D)D

    move-result-wide v4

    double-to-int v4, v4

    iget v5, v0, Landroid/graphics/RectF;->top:F

    float-to-double v5, v5

    invoke-static {v5, v6}, Ljava/lang/Math;->floor(D)D

    move-result-wide v5

    double-to-int v5, v5

    iget v6, v0, Landroid/graphics/RectF;->right:F

    float-to-double v6, v6

    invoke-static {v6, v7}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v6

    double-to-int v6, v6

    iget v7, v0, Landroid/graphics/RectF;->bottom:F

    float-to-double v7, v7

    invoke-static {v7, v8}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v7

    double-to-int v7, v7

    invoke-virtual {v2, v4, v5, v6, v7}, Landroid/view/View;->invalidate(IIII)V

    goto :goto_24

    .line 473
    :cond_63
    return-void
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .registers 8
    .parameter "canvas"

    .prologue
    .line 1079
    iget-object v5, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOuterRing:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    invoke-virtual {v5, p1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->draw(Landroid/graphics/Canvas;)V

    .line 1080
    iget-object v5, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDrawables:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v3

    .line 1081
    .local v3, ntargets:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_c
    if-ge v1, v3, :cond_1e

    .line 1082
    iget-object v5, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDrawables:Ljava/util/ArrayList;

    invoke-virtual {v5, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    .line 1083
    .local v4, target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    if-eqz v4, :cond_1b

    .line 1084
    invoke-virtual {v4, p1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->draw(Landroid/graphics/Canvas;)V

    .line 1081
    :cond_1b
    add-int/lit8 v1, v1, 0x1

    goto :goto_c

    .line 1087
    .end local v4           #target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    :cond_1e
    iget-object v5, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mChevronDrawables:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v2

    .line 1088
    .local v2, nchevrons:I
    const/4 v1, 0x0

    :goto_25
    if-ge v1, v2, :cond_37

    .line 1089
    iget-object v5, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mChevronDrawables:Ljava/util/ArrayList;

    invoke-virtual {v5, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    .line 1090
    .local v0, chevron:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    if-eqz v0, :cond_34

    .line 1091
    invoke-virtual {v0, p1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->draw(Landroid/graphics/Canvas;)V

    .line 1088
    :cond_34
    add-int/lit8 v1, v1, 0x1

    goto :goto_25

    .line 1094
    .end local v0           #chevron:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    :cond_37
    iget-object v5, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mHandleDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    invoke-virtual {v5, p1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->draw(Landroid/graphics/Canvas;)V

    .line 1095
    return-void
.end method

.method public onHoverEvent(Landroid/view/MotionEvent;)Z
    .registers 4
    .parameter "event"

    .prologue
    .line 909
    iget-object v1, p0, Landroid/view/View;->mContext:Landroid/content/Context;

    invoke-static {v1}, Landroid/view/accessibility/AccessibilityManager;->getInstance(Landroid/content/Context;)Landroid/view/accessibility/AccessibilityManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/accessibility/AccessibilityManager;->isTouchExplorationEnabled()Z

    move-result v1

    if-eqz v1, :cond_19

    .line 910
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    .line 911
    .local v0, action:I
    packed-switch v0, :pswitch_data_2e

    .line 922
    :goto_13
    :pswitch_13
    invoke-virtual {p0, p1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 923
    invoke-virtual {p1, v0}, Landroid/view/MotionEvent;->setAction(I)V

    .line 925
    .end local v0           #action:I
    :cond_19
    invoke-super {p0, p1}, Landroid/view/View;->onHoverEvent(Landroid/view/MotionEvent;)Z

    move-result v1

    return v1

    .line 913
    .restart local v0       #action:I
    :pswitch_1e
    const/4 v1, 0x0

    invoke-virtual {p1, v1}, Landroid/view/MotionEvent;->setAction(I)V

    goto :goto_13

    .line 916
    :pswitch_23
    const/4 v1, 0x2

    invoke-virtual {p1, v1}, Landroid/view/MotionEvent;->setAction(I)V

    goto :goto_13

    .line 919
    :pswitch_28
    const/4 v1, 0x1

    invoke-virtual {p1, v1}, Landroid/view/MotionEvent;->setAction(I)V

    goto :goto_13

    .line 911
    nop

    :pswitch_data_2e
    .packed-switch 0x7
        :pswitch_23
        :pswitch_13
        :pswitch_1e
        :pswitch_28
    .end packed-switch
.end method

.method protected onLayout(ZIIII)V
    .registers 15
    .parameter "changed"
    .parameter "left"
    .parameter "top"
    .parameter "right"
    .parameter "bottom"

    .prologue
    .line 1004
    invoke-super/range {p0 .. p5}, Landroid/view/View;->onLayout(ZIIII)V

    .line 1005
    sub-int v5, p4, p2

    .line 1006
    .local v5, width:I
    sub-int v0, p5, p3

    .line 1010
    .local v0, height:I
    iget-object v6, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOuterRing:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    invoke-virtual {v6}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->getWidth()I

    move-result v6

    int-to-float v6, v6

    const/high16 v7, 0x4000

    iget v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOuterRadius:F

    mul-float/2addr v7, v8

    invoke-static {v6, v7}, Ljava/lang/Math;->max(FF)F

    move-result v4

    .line 1011
    .local v4, placementWidth:F
    iget-object v6, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOuterRing:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    invoke-virtual {v6}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->getHeight()I

    move-result v6

    int-to-float v6, v6

    const/high16 v7, 0x4000

    iget v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOuterRadius:F

    mul-float/2addr v7, v8

    invoke-static {v6, v7}, Ljava/lang/Math;->max(FF)F

    move-result v3

    .line 1012
    .local v3, placementHeight:F
    iget v6, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mHorizontalInset:I

    int-to-float v6, v6

    int-to-float v7, v5

    iget v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mMaxTargetWidth:I

    int-to-float v8, v8

    add-float/2addr v8, v4

    invoke-static {v7, v8}, Ljava/lang/Math;->max(FF)F

    move-result v7

    const/high16 v8, 0x4000

    div-float/2addr v7, v8

    add-float v1, v6, v7

    .line 1014
    .local v1, newWaveCenterX:F
    iget v6, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mVerticalInset:I

    int-to-float v6, v6

    int-to-float v7, v0

    iget v8, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mMaxTargetHeight:I

    int-to-float v8, v8

    add-float/2addr v8, v3

    invoke-static {v7, v8}, Ljava/lang/Math;->max(FF)F

    move-result v7

    const/high16 v8, 0x4000

    div-float/2addr v7, v8

    add-float v2, v6, v7

    .line 1017
    .local v2, newWaveCenterY:F
    iget-boolean v6, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mInitialLayout:Z

    if-eqz v6, :cond_5e

    .line 1018
    invoke-direct {p0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->hideChevrons()V

    .line 1019
    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-direct {p0, v6, v7}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->hideTargets(ZZ)V

    .line 1020
    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-direct {p0, v6, v7, v8}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->moveHandleTo(FFZ)V

    .line 1021
    const/4 v6, 0x0

    iput-boolean v6, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mInitialLayout:Z

    .line 1024
    :cond_5e
    iget-object v6, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOuterRing:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    invoke-virtual {v6, v1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setPositionX(F)V

    .line 1025
    iget-object v6, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOuterRing:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    invoke-virtual {v6, v2}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setPositionY(F)V

    .line 1027
    iget-object v6, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mHandleDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    invoke-virtual {v6, v1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setPositionX(F)V

    .line 1028
    iget-object v6, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mHandleDrawable:Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    invoke-virtual {v6, v2}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setPositionY(F)V

    .line 1030
    invoke-direct {p0, v1, v2}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->updateTargetPositions(FF)V

    .line 1031
    invoke-direct {p0, v1, v2}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->updateChevronPositions(FF)V

    .line 1033
    iput v1, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mWaveCenterX:F

    .line 1034
    iput v2, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mWaveCenterY:F

    .line 1037
    return-void
.end method

.method protected onMeasure(II)V
    .registers 9
    .parameter "widthMeasureSpec"
    .parameter "heightMeasureSpec"

    .prologue
    .line 335
    invoke-virtual {p0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->getSuggestedMinimumWidth()I

    move-result v3

    .line 336
    .local v3, minimumWidth:I
    invoke-virtual {p0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->getSuggestedMinimumHeight()I

    move-result v2

    .line 337
    .local v2, minimumHeight:I
    invoke-direct {p0, p1, v3}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->resolveMeasured(II)I

    move-result v1

    .line 338
    .local v1, computedWidth:I
    invoke-direct {p0, p2, v2}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->resolveMeasured(II)I

    move-result v0

    .line 339
    .local v0, computedHeight:I
    sub-int v4, v1, v3

    sub-int v5, v0, v2

    invoke-direct {p0, v4, v5}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->computeInsets(II)V

    .line 340
    invoke-virtual {p0, v1, v0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->setMeasuredDimension(II)V

    .line 341
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .registers 5
    .parameter "event"

    .prologue
    .line 752
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    .line 753
    .local v0, action:I
    const/4 v1, 0x0

    .line 754
    .local v1, handled:Z
    packed-switch v0, :pswitch_data_2e

    .line 781
    :goto_8
    invoke-virtual {p0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->invalidate()V

    .line 782
    if-eqz v1, :cond_29

    const/4 v2, 0x1

    :goto_e
    return v2

    .line 757
    :pswitch_f
    invoke-direct {p0, p1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->handleDown(Landroid/view/MotionEvent;)V

    .line 758
    const/4 v1, 0x1

    .line 759
    goto :goto_8

    .line 763
    :pswitch_14
    invoke-direct {p0, p1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->handleMove(Landroid/view/MotionEvent;)V

    .line 764
    const/4 v1, 0x1

    .line 765
    goto :goto_8

    .line 769
    :pswitch_19
    invoke-direct {p0, p1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->handleMove(Landroid/view/MotionEvent;)V

    .line 770
    invoke-direct {p0, p1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->handleUp(Landroid/view/MotionEvent;)V

    .line 771
    const/4 v1, 0x1

    .line 772
    goto :goto_8

    .line 776
    :pswitch_21
    invoke-direct {p0, p1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->handleMove(Landroid/view/MotionEvent;)V

    .line 777
    invoke-direct {p0, p1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->handleCancel(Landroid/view/MotionEvent;)V

    .line 778
    const/4 v1, 0x1

    goto :goto_8

    .line 782
    :cond_29
    invoke-super {p0, p1}, Landroid/view/View;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v2

    goto :goto_e

    .line 754
    :pswitch_data_2e
    .packed-switch 0x0
        :pswitch_f
        :pswitch_19
        :pswitch_14
        :pswitch_21
    .end packed-switch
.end method

.method public ping()V
    .registers 1

    .prologue
    .line 716
    invoke-direct {p0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->startChevronAnimation()V

    .line 717
    return-void
.end method

.method public replaceTargetDrawablesIfPresent(Landroid/content/ComponentName;Ljava/lang/String;I)Z
    .registers 14
    .parameter "component"
    .parameter "name"
    .parameter "existingResId"

    .prologue
    const/4 v6, 0x0

    .line 1242
    if-nez p3, :cond_4

    .line 1263
    :cond_3
    :goto_3
    return v6

    .line 1245
    :cond_4
    :try_start_4
    iget-object v7, p0, Landroid/view/View;->mContext:Landroid/content/Context;

    invoke-virtual {v7}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 1247
    .local v4, packageManager:Landroid/content/pm/PackageManager;
    const/16 v7, 0x80

    invoke-virtual {v4, p1, v7}, Landroid/content/pm/PackageManager;->getActivityInfo(Landroid/content/ComponentName;I)Landroid/content/pm/ActivityInfo;

    move-result-object v7

    iget-object v2, v7, Landroid/content/pm/PackageItemInfo;->metaData:Landroid/os/Bundle;

    .line 1249
    .local v2, metaData:Landroid/os/Bundle;
    if-eqz v2, :cond_3

    .line 1250
    invoke-virtual {v2, p2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    .line 1251
    .local v1, iconResId:I
    if-eqz v1, :cond_3

    .line 1252
    invoke-virtual {v4, p1}, Landroid/content/pm/PackageManager;->getResourcesForActivity(Landroid/content/ComponentName;)Landroid/content/res/Resources;

    move-result-object v5

    .line 1253
    .local v5, res:Landroid/content/res/Resources;
    invoke-direct {p0, v5, p3, v1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->replaceTargetDrawables(Landroid/content/res/Resources;II)Z
    :try_end_21
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_4 .. :try_end_21} :catch_23
    .catch Landroid/content/res/Resources$NotFoundException; {:try_start_4 .. :try_end_21} :catch_47

    move-result v6

    goto :goto_3

    .line 1256
    .end local v1           #iconResId:I
    .end local v2           #metaData:Landroid/os/Bundle;
    .end local v4           #packageManager:Landroid/content/pm/PackageManager;
    .end local v5           #res:Landroid/content/res/Resources;
    :catch_23
    move-exception v0

    .line 1257
    .local v0, e:Landroid/content/pm/PackageManager$NameNotFoundException;
    const-string v7, "MultiWaveView"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Failed to swap drawable; "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {p1}, Landroid/content/ComponentName;->flattenToShortString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " not found"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_3

    .line 1259
    .end local v0           #e:Landroid/content/pm/PackageManager$NameNotFoundException;
    :catch_47
    move-exception v3

    .line 1260
    .local v3, nfe:Landroid/content/res/Resources$NotFoundException;
    const-string v7, "MultiWaveView"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Failed to swap drawable from "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {p1}, Landroid/content/ComponentName;->flattenToShortString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_3
.end method

.method public reset(Z)V
    .registers 5
    .parameter "animate"

    .prologue
    const/4 v2, 0x0

    .line 726
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mChevronAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    invoke-virtual {v0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->stop()V

    .line 727
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mHandleAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    invoke-virtual {v0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->stop()V

    .line 728
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    invoke-virtual {v0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->stop()V

    .line 729
    const/4 v0, 0x0

    invoke-direct {p0, v2, v0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->startBackgroundAnimation(IF)V

    .line 730
    invoke-direct {p0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->hideChevrons()V

    .line 731
    invoke-direct {p0, p1, v2}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->hideTargets(ZZ)V

    .line 732
    const/high16 v0, 0x3f80

    const/4 v1, 0x0

    invoke-direct {p0, v2, v2, v0, v1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->deactivateHandle(IIFLandroid/animation/Animator$AnimatorListener;)V

    .line 733
    invoke-static {}, Lcom/android/internal/widget/multiwaveview/Tweener;->reset()V

    .line 734
    return-void
.end method

.method public resumeAnimations()V
    .registers 3

    .prologue
    const/4 v1, 0x0

    .line 293
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mChevronAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->setSuspended(Z)V

    .line 294
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->setSuspended(Z)V

    .line 295
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mHandleAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->setSuspended(Z)V

    .line 296
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mChevronAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    invoke-virtual {v0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->start()V

    .line 297
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    invoke-virtual {v0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->start()V

    .line 298
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mHandleAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    invoke-virtual {v0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->start()V

    .line 299
    return-void
.end method

.method public setDirectionDescriptionsResourceId(I)V
    .registers 3
    .parameter "resourceId"

    .prologue
    .line 682
    iput p1, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mDirectionDescriptionsResourceId:I

    .line 683
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mDirectionDescriptions:Ljava/util/ArrayList;

    if-eqz v0, :cond_b

    .line 684
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mDirectionDescriptions:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 686
    :cond_b
    return-void
.end method

.method public setEnableTarget(IZ)V
    .registers 6
    .parameter "resourceId"
    .parameter "enabled"

    .prologue
    .line 1184
    const/4 v0, 0x0

    .local v0, i:I
    :goto_1
    iget-object v2, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDrawables:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-ge v0, v2, :cond_1a

    .line 1185
    iget-object v2, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDrawables:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/internal/widget/multiwaveview/TargetDrawable;

    .line 1186
    .local v1, target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    invoke-virtual {v1}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->getResourceId()I

    move-result v2

    if-ne v2, p1, :cond_1b

    .line 1187
    invoke-virtual {v1, p2}, Lcom/android/internal/widget/multiwaveview/TargetDrawable;->setEnabled(Z)V

    .line 1191
    .end local v1           #target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    :cond_1a
    return-void

    .line 1184
    .restart local v1       #target:Lcom/android/internal/widget/multiwaveview/TargetDrawable;
    :cond_1b
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method public setOnTriggerListener(Lcom/android/internal/widget/multiwaveview/MultiWaveView$OnTriggerListener;)V
    .registers 2
    .parameter "listener"

    .prologue
    .line 1098
    iput-object p1, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mOnTriggerListener:Lcom/android/internal/widget/multiwaveview/MultiWaveView$OnTriggerListener;

    .line 1099
    return-void
.end method

.method public setTargetDescriptionsResourceId(I)V
    .registers 3
    .parameter "resourceId"

    .prologue
    .line 661
    iput p1, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDescriptionsResourceId:I

    .line 662
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDescriptions:Ljava/util/ArrayList;

    if-eqz v0, :cond_b

    .line 663
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetDescriptions:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 665
    :cond_b
    return-void
.end method

.method public setTargetResources(I)V
    .registers 3
    .parameter "resourceId"

    .prologue
    .line 643
    iget-boolean v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mAnimatingTargets:Z

    if-eqz v0, :cond_7

    .line 645
    iput p1, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mNewTargetResources:I

    .line 649
    :goto_6
    return-void

    .line 647
    :cond_7
    invoke-direct {p0, p1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->internalSetTargetResources(I)V

    goto :goto_6
.end method

.method public setVibrateEnabled(Z)V
    .registers 4
    .parameter "enabled"

    .prologue
    .line 703
    if-eqz p1, :cond_16

    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mVibrator:Landroid/os/Vibrator;

    if-nez v0, :cond_16

    .line 704
    invoke-virtual {p0}, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string/jumbo v1, "vibrator"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/Vibrator;

    iput-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mVibrator:Landroid/os/Vibrator;

    .line 708
    :goto_15
    return-void

    .line 706
    :cond_16
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mVibrator:Landroid/os/Vibrator;

    goto :goto_15
.end method

.method public suspendAnimations()V
    .registers 3

    .prologue
    const/4 v1, 0x1

    .line 287
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mChevronAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->setSuspended(Z)V

    .line 288
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mTargetAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->setSuspended(Z)V

    .line 289
    iget-object v0, p0, Lcom/android/internal/widget/multiwaveview/MultiWaveView;->mHandleAnimations:Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/multiwaveview/MultiWaveView$AnimationBundle;->setSuspended(Z)V

    .line 290
    return-void
.end method
