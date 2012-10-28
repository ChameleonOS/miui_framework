.class public abstract Landroid/view/animation/Animation;
.super Ljava/lang/Object;
.source "Animation.java"

# interfaces
.implements Ljava/lang/Cloneable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/view/animation/Animation$AnimationListener;,
        Landroid/view/animation/Animation$Description;
    }
.end annotation


# static fields
.field public static final ABSOLUTE:I = 0x0

.field public static final INFINITE:I = -0x1

.field public static final RELATIVE_TO_PARENT:I = 0x2

.field public static final RELATIVE_TO_SELF:I = 0x1

.field public static final RESTART:I = 0x1

.field public static final REVERSE:I = 0x2

.field public static final START_ON_FIRST_FRAME:I = -0x1

#the value of this static final field might be set in the static constructor
.field private static final USE_CLOSEGUARD:Z = false

.field public static final ZORDER_BOTTOM:I = -0x1

.field public static final ZORDER_NORMAL:I = 0x0

.field public static final ZORDER_TOP:I = 0x1


# instance fields
.field private final guard:Ldalvik/system/CloseGuard;

.field private mBackgroundColor:I

.field mCycleFlip:Z

.field private mDetachWallpaper:Z

.field mDuration:J

.field mEnded:Z

.field mFillAfter:Z

.field mFillBefore:Z

.field mFillEnabled:Z

.field mInitialized:Z

.field mInterpolator:Landroid/view/animation/Interpolator;

.field mListener:Landroid/view/animation/Animation$AnimationListener;

.field private mListenerHandler:Landroid/os/Handler;

.field private mMore:Z

.field private mOnEnd:Ljava/lang/Runnable;

.field private mOnRepeat:Ljava/lang/Runnable;

.field private mOnStart:Ljava/lang/Runnable;

.field private mOneMoreTime:Z

.field mPreviousRegion:Landroid/graphics/RectF;

.field mPreviousTransformation:Landroid/view/animation/Transformation;

.field mRegion:Landroid/graphics/RectF;

.field mRepeatCount:I

.field mRepeatMode:I

.field mRepeated:I

.field private mScaleFactor:F

.field mStartOffset:J

.field mStartTime:J

.field mStarted:Z

.field mTransformation:Landroid/view/animation/Transformation;

.field private mZAdjustment:I


# direct methods
.method static constructor <clinit>()V
    .registers 2

    .prologue
    .line 93
    const-string v0, "log.closeguard.Animation"

    const/4 v1, 0x0

    invoke-static {v0, v1}, Landroid/os/SystemProperties;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    sput-boolean v0, Landroid/view/animation/Animation;->USE_CLOSEGUARD:Z

    return-void
.end method

.method public constructor <init>()V
    .registers 5

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 220
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 99
    iput-boolean v2, p0, Landroid/view/animation/Animation;->mEnded:Z

    .line 104
    iput-boolean v2, p0, Landroid/view/animation/Animation;->mStarted:Z

    .line 110
    iput-boolean v2, p0, Landroid/view/animation/Animation;->mCycleFlip:Z

    .line 116
    iput-boolean v2, p0, Landroid/view/animation/Animation;->mInitialized:Z

    .line 123
    iput-boolean v3, p0, Landroid/view/animation/Animation;->mFillBefore:Z

    .line 129
    iput-boolean v2, p0, Landroid/view/animation/Animation;->mFillAfter:Z

    .line 134
    iput-boolean v2, p0, Landroid/view/animation/Animation;->mFillEnabled:Z

    .line 139
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Landroid/view/animation/Animation;->mStartTime:J

    .line 156
    iput v2, p0, Landroid/view/animation/Animation;->mRepeatCount:I

    .line 161
    iput v2, p0, Landroid/view/animation/Animation;->mRepeated:I

    .line 168
    iput v3, p0, Landroid/view/animation/Animation;->mRepeatMode:I

    .line 194
    const/high16 v0, 0x3f80

    iput v0, p0, Landroid/view/animation/Animation;->mScaleFactor:F

    .line 199
    iput-boolean v2, p0, Landroid/view/animation/Animation;->mDetachWallpaper:Z

    .line 201
    iput-boolean v3, p0, Landroid/view/animation/Animation;->mMore:Z

    .line 202
    iput-boolean v3, p0, Landroid/view/animation/Animation;->mOneMoreTime:Z

    .line 204
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    iput-object v0, p0, Landroid/view/animation/Animation;->mPreviousRegion:Landroid/graphics/RectF;

    .line 205
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    iput-object v0, p0, Landroid/view/animation/Animation;->mRegion:Landroid/graphics/RectF;

    .line 206
    new-instance v0, Landroid/view/animation/Transformation;

    invoke-direct {v0}, Landroid/view/animation/Transformation;-><init>()V

    iput-object v0, p0, Landroid/view/animation/Animation;->mTransformation:Landroid/view/animation/Transformation;

    .line 207
    new-instance v0, Landroid/view/animation/Transformation;

    invoke-direct {v0}, Landroid/view/animation/Transformation;-><init>()V

    iput-object v0, p0, Landroid/view/animation/Animation;->mPreviousTransformation:Landroid/view/animation/Transformation;

    .line 209
    invoke-static {}, Ldalvik/system/CloseGuard;->get()Ldalvik/system/CloseGuard;

    move-result-object v0

    iput-object v0, p0, Landroid/view/animation/Animation;->guard:Ldalvik/system/CloseGuard;

    .line 221
    invoke-virtual {p0}, Landroid/view/animation/Animation;->ensureInterpolator()V

    .line 222
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 9
    .parameter "context"
    .parameter "attrs"

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 231
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 99
    iput-boolean v4, p0, Landroid/view/animation/Animation;->mEnded:Z

    .line 104
    iput-boolean v4, p0, Landroid/view/animation/Animation;->mStarted:Z

    .line 110
    iput-boolean v4, p0, Landroid/view/animation/Animation;->mCycleFlip:Z

    .line 116
    iput-boolean v4, p0, Landroid/view/animation/Animation;->mInitialized:Z

    .line 123
    iput-boolean v5, p0, Landroid/view/animation/Animation;->mFillBefore:Z

    .line 129
    iput-boolean v4, p0, Landroid/view/animation/Animation;->mFillAfter:Z

    .line 134
    iput-boolean v4, p0, Landroid/view/animation/Animation;->mFillEnabled:Z

    .line 139
    const-wide/16 v2, -0x1

    iput-wide v2, p0, Landroid/view/animation/Animation;->mStartTime:J

    .line 156
    iput v4, p0, Landroid/view/animation/Animation;->mRepeatCount:I

    .line 161
    iput v4, p0, Landroid/view/animation/Animation;->mRepeated:I

    .line 168
    iput v5, p0, Landroid/view/animation/Animation;->mRepeatMode:I

    .line 194
    const/high16 v2, 0x3f80

    iput v2, p0, Landroid/view/animation/Animation;->mScaleFactor:F

    .line 199
    iput-boolean v4, p0, Landroid/view/animation/Animation;->mDetachWallpaper:Z

    .line 201
    iput-boolean v5, p0, Landroid/view/animation/Animation;->mMore:Z

    .line 202
    iput-boolean v5, p0, Landroid/view/animation/Animation;->mOneMoreTime:Z

    .line 204
    new-instance v2, Landroid/graphics/RectF;

    invoke-direct {v2}, Landroid/graphics/RectF;-><init>()V

    iput-object v2, p0, Landroid/view/animation/Animation;->mPreviousRegion:Landroid/graphics/RectF;

    .line 205
    new-instance v2, Landroid/graphics/RectF;

    invoke-direct {v2}, Landroid/graphics/RectF;-><init>()V

    iput-object v2, p0, Landroid/view/animation/Animation;->mRegion:Landroid/graphics/RectF;

    .line 206
    new-instance v2, Landroid/view/animation/Transformation;

    invoke-direct {v2}, Landroid/view/animation/Transformation;-><init>()V

    iput-object v2, p0, Landroid/view/animation/Animation;->mTransformation:Landroid/view/animation/Transformation;

    .line 207
    new-instance v2, Landroid/view/animation/Transformation;

    invoke-direct {v2}, Landroid/view/animation/Transformation;-><init>()V

    iput-object v2, p0, Landroid/view/animation/Animation;->mPreviousTransformation:Landroid/view/animation/Transformation;

    .line 209
    invoke-static {}, Ldalvik/system/CloseGuard;->get()Ldalvik/system/CloseGuard;

    move-result-object v2

    iput-object v2, p0, Landroid/view/animation/Animation;->guard:Ldalvik/system/CloseGuard;

    .line 232
    sget-object v2, Lcom/android/internal/R$styleable;->Animation:[I

    invoke-virtual {p1, p2, v2}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 234
    .local v0, a:Landroid/content/res/TypedArray;
    const/4 v2, 0x2

    invoke-virtual {v0, v2, v4}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v2

    int-to-long v2, v2

    invoke-virtual {p0, v2, v3}, Landroid/view/animation/Animation;->setDuration(J)V

    .line 235
    const/4 v2, 0x5

    invoke-virtual {v0, v2, v4}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v2

    int-to-long v2, v2

    invoke-virtual {p0, v2, v3}, Landroid/view/animation/Animation;->setStartOffset(J)V

    .line 237
    const/16 v2, 0x9

    iget-boolean v3, p0, Landroid/view/animation/Animation;->mFillEnabled:Z

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    invoke-virtual {p0, v2}, Landroid/view/animation/Animation;->setFillEnabled(Z)V

    .line 238
    const/4 v2, 0x3

    iget-boolean v3, p0, Landroid/view/animation/Animation;->mFillBefore:Z

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    invoke-virtual {p0, v2}, Landroid/view/animation/Animation;->setFillBefore(Z)V

    .line 239
    const/4 v2, 0x4

    iget-boolean v3, p0, Landroid/view/animation/Animation;->mFillAfter:Z

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    invoke-virtual {p0, v2}, Landroid/view/animation/Animation;->setFillAfter(Z)V

    .line 241
    const/4 v2, 0x6

    iget v3, p0, Landroid/view/animation/Animation;->mRepeatCount:I

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v2

    invoke-virtual {p0, v2}, Landroid/view/animation/Animation;->setRepeatCount(I)V

    .line 242
    const/4 v2, 0x7

    invoke-virtual {v0, v2, v5}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v2

    invoke-virtual {p0, v2}, Landroid/view/animation/Animation;->setRepeatMode(I)V

    .line 244
    const/16 v2, 0x8

    invoke-virtual {v0, v2, v4}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v2

    invoke-virtual {p0, v2}, Landroid/view/animation/Animation;->setZAdjustment(I)V

    .line 246
    invoke-virtual {v0, v4, v4}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v2

    invoke-virtual {p0, v2}, Landroid/view/animation/Animation;->setBackgroundColor(I)V

    .line 248
    const/16 v2, 0xa

    invoke-virtual {v0, v2, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    invoke-virtual {p0, v2}, Landroid/view/animation/Animation;->setDetachWallpaper(Z)V

    .line 250
    invoke-virtual {v0, v5, v4}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v1

    .line 252
    .local v1, resID:I
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 254
    if-lez v1, :cond_b7

    .line 255
    invoke-virtual {p0, p1, v1}, Landroid/view/animation/Animation;->setInterpolator(Landroid/content/Context;I)V

    .line 258
    :cond_b7
    invoke-virtual {p0}, Landroid/view/animation/Animation;->ensureInterpolator()V

    .line 259
    return-void
.end method

.method private fireAnimationEnd()V
    .registers 3

    .prologue
    .line 919
    iget-object v0, p0, Landroid/view/animation/Animation;->mListener:Landroid/view/animation/Animation$AnimationListener;

    if-eqz v0, :cond_d

    .line 920
    iget-object v0, p0, Landroid/view/animation/Animation;->mListenerHandler:Landroid/os/Handler;

    if-nez v0, :cond_e

    iget-object v0, p0, Landroid/view/animation/Animation;->mListener:Landroid/view/animation/Animation$AnimationListener;

    invoke-interface {v0, p0}, Landroid/view/animation/Animation$AnimationListener;->onAnimationEnd(Landroid/view/animation/Animation;)V

    .line 923
    :cond_d
    :goto_d
    return-void

    .line 921
    :cond_e
    iget-object v0, p0, Landroid/view/animation/Animation;->mListenerHandler:Landroid/os/Handler;

    iget-object v1, p0, Landroid/view/animation/Animation;->mOnEnd:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->postAtFrontOfQueue(Ljava/lang/Runnable;)Z

    goto :goto_d
.end method

.method private fireAnimationRepeat()V
    .registers 3

    .prologue
    .line 912
    iget-object v0, p0, Landroid/view/animation/Animation;->mListener:Landroid/view/animation/Animation$AnimationListener;

    if-eqz v0, :cond_d

    .line 913
    iget-object v0, p0, Landroid/view/animation/Animation;->mListenerHandler:Landroid/os/Handler;

    if-nez v0, :cond_e

    iget-object v0, p0, Landroid/view/animation/Animation;->mListener:Landroid/view/animation/Animation$AnimationListener;

    invoke-interface {v0, p0}, Landroid/view/animation/Animation$AnimationListener;->onAnimationRepeat(Landroid/view/animation/Animation;)V

    .line 916
    :cond_d
    :goto_d
    return-void

    .line 914
    :cond_e
    iget-object v0, p0, Landroid/view/animation/Animation;->mListenerHandler:Landroid/os/Handler;

    iget-object v1, p0, Landroid/view/animation/Animation;->mOnRepeat:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->postAtFrontOfQueue(Ljava/lang/Runnable;)Z

    goto :goto_d
.end method

.method private fireAnimationStart()V
    .registers 3

    .prologue
    .line 905
    iget-object v0, p0, Landroid/view/animation/Animation;->mListener:Landroid/view/animation/Animation$AnimationListener;

    if-eqz v0, :cond_d

    .line 906
    iget-object v0, p0, Landroid/view/animation/Animation;->mListenerHandler:Landroid/os/Handler;

    if-nez v0, :cond_e

    iget-object v0, p0, Landroid/view/animation/Animation;->mListener:Landroid/view/animation/Animation$AnimationListener;

    invoke-interface {v0, p0}, Landroid/view/animation/Animation$AnimationListener;->onAnimationStart(Landroid/view/animation/Animation;)V

    .line 909
    :cond_d
    :goto_d
    return-void

    .line 907
    :cond_e
    iget-object v0, p0, Landroid/view/animation/Animation;->mListenerHandler:Landroid/os/Handler;

    iget-object v1, p0, Landroid/view/animation/Animation;->mOnStart:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->postAtFrontOfQueue(Ljava/lang/Runnable;)Z

    goto :goto_d
.end method


# virtual methods
.method protected applyTransformation(FLandroid/view/animation/Transformation;)V
    .registers 3
    .parameter "interpolatedTime"
    .parameter "t"

    .prologue
    .line 973
    return-void
.end method

.method public cancel()V
    .registers 3

    .prologue
    .line 299
    iget-boolean v0, p0, Landroid/view/animation/Animation;->mStarted:Z

    if-eqz v0, :cond_13

    iget-boolean v0, p0, Landroid/view/animation/Animation;->mEnded:Z

    if-nez v0, :cond_13

    .line 300
    invoke-direct {p0}, Landroid/view/animation/Animation;->fireAnimationEnd()V

    .line 301
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/view/animation/Animation;->mEnded:Z

    .line 302
    iget-object v0, p0, Landroid/view/animation/Animation;->guard:Ldalvik/system/CloseGuard;

    invoke-virtual {v0}, Ldalvik/system/CloseGuard;->close()V

    .line 305
    :cond_13
    const-wide/high16 v0, -0x8000

    iput-wide v0, p0, Landroid/view/animation/Animation;->mStartTime:J

    .line 306
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/view/animation/Animation;->mOneMoreTime:Z

    iput-boolean v0, p0, Landroid/view/animation/Animation;->mMore:Z

    .line 307
    return-void
.end method

.method protected clone()Landroid/view/animation/Animation;
    .registers 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 263
    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/animation/Animation;

    .line 264
    .local v0, animation:Landroid/view/animation/Animation;
    new-instance v1, Landroid/graphics/RectF;

    invoke-direct {v1}, Landroid/graphics/RectF;-><init>()V

    iput-object v1, v0, Landroid/view/animation/Animation;->mPreviousRegion:Landroid/graphics/RectF;

    .line 265
    new-instance v1, Landroid/graphics/RectF;

    invoke-direct {v1}, Landroid/graphics/RectF;-><init>()V

    iput-object v1, v0, Landroid/view/animation/Animation;->mRegion:Landroid/graphics/RectF;

    .line 266
    new-instance v1, Landroid/view/animation/Transformation;

    invoke-direct {v1}, Landroid/view/animation/Transformation;-><init>()V

    iput-object v1, v0, Landroid/view/animation/Animation;->mTransformation:Landroid/view/animation/Transformation;

    .line 267
    new-instance v1, Landroid/view/animation/Transformation;

    invoke-direct {v1}, Landroid/view/animation/Transformation;-><init>()V

    iput-object v1, v0, Landroid/view/animation/Animation;->mPreviousTransformation:Landroid/view/animation/Transformation;

    .line 268
    return-object v0
.end method

.method protected bridge synthetic clone()Ljava/lang/Object;
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 33
    invoke-virtual {p0}, Landroid/view/animation/Animation;->clone()Landroid/view/animation/Animation;

    move-result-object v0

    return-object v0
.end method

.method public computeDurationHint()J
    .registers 5

    .prologue
    .line 820
    invoke-virtual {p0}, Landroid/view/animation/Animation;->getStartOffset()J

    move-result-wide v0

    invoke-virtual {p0}, Landroid/view/animation/Animation;->getDuration()J

    move-result-wide v2

    add-long/2addr v0, v2

    invoke-virtual {p0}, Landroid/view/animation/Animation;->getRepeatCount()I

    move-result v2

    add-int/lit8 v2, v2, 0x1

    int-to-long v2, v2

    mul-long/2addr v0, v2

    return-wide v0
.end method

.method public detach()V
    .registers 2

    .prologue
    .line 313
    iget-boolean v0, p0, Landroid/view/animation/Animation;->mStarted:Z

    if-eqz v0, :cond_13

    iget-boolean v0, p0, Landroid/view/animation/Animation;->mEnded:Z

    if-nez v0, :cond_13

    .line 314
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/view/animation/Animation;->mEnded:Z

    .line 315
    iget-object v0, p0, Landroid/view/animation/Animation;->guard:Ldalvik/system/CloseGuard;

    invoke-virtual {v0}, Ldalvik/system/CloseGuard;->close()V

    .line 316
    invoke-direct {p0}, Landroid/view/animation/Animation;->fireAnimationEnd()V

    .line 318
    :cond_13
    return-void
.end method

.method protected ensureInterpolator()V
    .registers 2

    .prologue
    .line 808
    iget-object v0, p0, Landroid/view/animation/Animation;->mInterpolator:Landroid/view/animation/Interpolator;

    if-nez v0, :cond_b

    .line 809
    new-instance v0, Landroid/view/animation/AccelerateDecelerateInterpolator;

    invoke-direct {v0}, Landroid/view/animation/AccelerateDecelerateInterpolator;-><init>()V

    iput-object v0, p0, Landroid/view/animation/Animation;->mInterpolator:Landroid/view/animation/Interpolator;

    .line 811
    :cond_b
    return-void
.end method

.method protected finalize()V
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 1053
    :try_start_0
    iget-object v0, p0, Landroid/view/animation/Animation;->guard:Ldalvik/system/CloseGuard;

    if-eqz v0, :cond_9

    .line 1054
    iget-object v0, p0, Landroid/view/animation/Animation;->guard:Ldalvik/system/CloseGuard;

    invoke-virtual {v0}, Ldalvik/system/CloseGuard;->warnIfOpen()V
    :try_end_9
    .catchall {:try_start_0 .. :try_end_9} :catchall_d

    .line 1057
    :cond_9
    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    .line 1059
    return-void

    .line 1057
    :catchall_d
    move-exception v0

    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    throw v0
.end method

.method public getBackgroundColor()I
    .registers 2

    .prologue
    .line 757
    iget v0, p0, Landroid/view/animation/Animation;->mBackgroundColor:I

    return v0
.end method

.method public getDetachWallpaper()Z
    .registers 2

    .prologue
    .line 765
    iget-boolean v0, p0, Landroid/view/animation/Animation;->mDetachWallpaper:Z

    return v0
.end method

.method public getDuration()J
    .registers 3

    .prologue
    .line 683
    iget-wide v0, p0, Landroid/view/animation/Animation;->mDuration:J

    return-wide v0
.end method

.method public getFillAfter()Z
    .registers 2

    .prologue
    .line 738
    iget-boolean v0, p0, Landroid/view/animation/Animation;->mFillAfter:Z

    return v0
.end method

.method public getFillBefore()Z
    .registers 2

    .prologue
    .line 727
    iget-boolean v0, p0, Landroid/view/animation/Animation;->mFillBefore:Z

    return v0
.end method

.method public getInterpolator()Landroid/view/animation/Interpolator;
    .registers 2

    .prologue
    .line 662
    iget-object v0, p0, Landroid/view/animation/Animation;->mInterpolator:Landroid/view/animation/Interpolator;

    return-object v0
.end method

.method public getInvalidateRegion(IIIILandroid/graphics/RectF;Landroid/view/animation/Transformation;)V
    .registers 16
    .parameter "left"
    .parameter "top"
    .parameter "right"
    .parameter "bottom"
    .parameter "invalidate"
    .parameter "transformation"

    .prologue
    const/high16 v8, -0x4080

    .line 1012
    iget-object v2, p0, Landroid/view/animation/Animation;->mRegion:Landroid/graphics/RectF;

    .line 1013
    .local v2, tempRegion:Landroid/graphics/RectF;
    iget-object v0, p0, Landroid/view/animation/Animation;->mPreviousRegion:Landroid/graphics/RectF;

    .line 1015
    .local v0, previousRegion:Landroid/graphics/RectF;
    int-to-float v4, p1

    int-to-float v5, p2

    int-to-float v6, p3

    int-to-float v7, p4

    invoke-virtual {p5, v4, v5, v6, v7}, Landroid/graphics/RectF;->set(FFFF)V

    .line 1016
    invoke-virtual {p6}, Landroid/view/animation/Transformation;->getMatrix()Landroid/graphics/Matrix;

    move-result-object v4

    invoke-virtual {v4, p5}, Landroid/graphics/Matrix;->mapRect(Landroid/graphics/RectF;)Z

    .line 1018
    invoke-virtual {p5, v8, v8}, Landroid/graphics/RectF;->inset(FF)V

    .line 1019
    invoke-virtual {v2, p5}, Landroid/graphics/RectF;->set(Landroid/graphics/RectF;)V

    .line 1020
    invoke-virtual {p5, v0}, Landroid/graphics/RectF;->union(Landroid/graphics/RectF;)V

    .line 1022
    invoke-virtual {v0, v2}, Landroid/graphics/RectF;->set(Landroid/graphics/RectF;)V

    .line 1024
    iget-object v3, p0, Landroid/view/animation/Animation;->mTransformation:Landroid/view/animation/Transformation;

    .line 1025
    .local v3, tempTransformation:Landroid/view/animation/Transformation;
    iget-object v1, p0, Landroid/view/animation/Animation;->mPreviousTransformation:Landroid/view/animation/Transformation;

    .line 1027
    .local v1, previousTransformation:Landroid/view/animation/Transformation;
    invoke-virtual {v3, p6}, Landroid/view/animation/Transformation;->set(Landroid/view/animation/Transformation;)V

    .line 1028
    invoke-virtual {p6, v1}, Landroid/view/animation/Transformation;->set(Landroid/view/animation/Transformation;)V

    .line 1029
    invoke-virtual {v1, v3}, Landroid/view/animation/Transformation;->set(Landroid/view/animation/Transformation;)V

    .line 1030
    return-void
.end method

.method public getRepeatCount()I
    .registers 2

    .prologue
    .line 714
    iget v0, p0, Landroid/view/animation/Animation;->mRepeatCount:I

    return v0
.end method

.method public getRepeatMode()I
    .registers 2

    .prologue
    .line 703
    iget v0, p0, Landroid/view/animation/Animation;->mRepeatMode:I

    return v0
.end method

.method protected getScaleFactor()F
    .registers 2

    .prologue
    .line 639
    iget v0, p0, Landroid/view/animation/Animation;->mScaleFactor:F

    return v0
.end method

.method public getStartOffset()J
    .registers 3

    .prologue
    .line 693
    iget-wide v0, p0, Landroid/view/animation/Animation;->mStartOffset:J

    return-wide v0
.end method

.method public getStartTime()J
    .registers 3

    .prologue
    .line 673
    iget-wide v0, p0, Landroid/view/animation/Animation;->mStartTime:J

    return-wide v0
.end method

.method public getTransformation(JLandroid/view/animation/Transformation;)Z
    .registers 15
    .parameter "currentTime"
    .parameter "outTransformation"

    .prologue
    .line 834
    iget-wide v7, p0, Landroid/view/animation/Animation;->mStartTime:J

    const-wide/16 v9, -0x1

    cmp-long v7, v7, v9

    if-nez v7, :cond_a

    .line 835
    iput-wide p1, p0, Landroid/view/animation/Animation;->mStartTime:J

    .line 838
    :cond_a
    invoke-virtual {p0}, Landroid/view/animation/Animation;->getStartOffset()J

    move-result-wide v5

    .line 839
    .local v5, startOffset:J
    iget-wide v0, p0, Landroid/view/animation/Animation;->mDuration:J

    .line 841
    .local v0, duration:J
    const-wide/16 v7, 0x0

    cmp-long v7, v0, v7

    if-eqz v7, :cond_a6

    .line 842
    iget-wide v7, p0, Landroid/view/animation/Animation;->mStartTime:J

    add-long/2addr v7, v5

    sub-long v7, p1, v7

    long-to-float v7, v7

    long-to-float v8, v0

    div-float v4, v7, v8

    .line 849
    .local v4, normalizedTime:F
    :goto_1f
    const/high16 v7, 0x3f80

    cmpl-float v7, v4, v7

    if-ltz v7, :cond_b2

    const/4 v2, 0x1

    .line 850
    .local v2, expired:Z
    :goto_26
    if-nez v2, :cond_b5

    const/4 v7, 0x1

    :goto_29
    iput-boolean v7, p0, Landroid/view/animation/Animation;->mMore:Z

    .line 852
    iget-boolean v7, p0, Landroid/view/animation/Animation;->mFillEnabled:Z

    if-nez v7, :cond_3a

    const/high16 v7, 0x3f80

    invoke-static {v4, v7}, Ljava/lang/Math;->min(FF)F

    move-result v7

    const/4 v8, 0x0

    invoke-static {v7, v8}, Ljava/lang/Math;->max(FF)F

    move-result v4

    .line 854
    :cond_3a
    const/4 v7, 0x0

    cmpl-float v7, v4, v7

    if-gez v7, :cond_43

    iget-boolean v7, p0, Landroid/view/animation/Animation;->mFillBefore:Z

    if-eqz v7, :cond_82

    :cond_43
    const/high16 v7, 0x3f80

    cmpg-float v7, v4, v7

    if-lez v7, :cond_4d

    iget-boolean v7, p0, Landroid/view/animation/Animation;->mFillAfter:Z

    if-eqz v7, :cond_82

    .line 855
    :cond_4d
    iget-boolean v7, p0, Landroid/view/animation/Animation;->mStarted:Z

    if-nez v7, :cond_62

    .line 856
    invoke-direct {p0}, Landroid/view/animation/Animation;->fireAnimationStart()V

    .line 857
    const/4 v7, 0x1

    iput-boolean v7, p0, Landroid/view/animation/Animation;->mStarted:Z

    .line 858
    sget-boolean v7, Landroid/view/animation/Animation;->USE_CLOSEGUARD:Z

    if-eqz v7, :cond_62

    .line 859
    iget-object v7, p0, Landroid/view/animation/Animation;->guard:Ldalvik/system/CloseGuard;

    const-string v8, "cancel or detach or getTransformation"

    invoke-virtual {v7, v8}, Ldalvik/system/CloseGuard;->open(Ljava/lang/String;)V

    .line 863
    :cond_62
    iget-boolean v7, p0, Landroid/view/animation/Animation;->mFillEnabled:Z

    if-eqz v7, :cond_71

    const/high16 v7, 0x3f80

    invoke-static {v4, v7}, Ljava/lang/Math;->min(FF)F

    move-result v7

    const/4 v8, 0x0

    invoke-static {v7, v8}, Ljava/lang/Math;->max(FF)F

    move-result v4

    .line 865
    :cond_71
    iget-boolean v7, p0, Landroid/view/animation/Animation;->mCycleFlip:Z

    if-eqz v7, :cond_79

    .line 866
    const/high16 v7, 0x3f80

    sub-float v4, v7, v4

    .line 869
    :cond_79
    iget-object v7, p0, Landroid/view/animation/Animation;->mInterpolator:Landroid/view/animation/Interpolator;

    invoke-interface {v7, v4}, Landroid/view/animation/Interpolator;->getInterpolation(F)F

    move-result v3

    .line 870
    .local v3, interpolatedTime:F
    invoke-virtual {p0, v3, p3}, Landroid/view/animation/Animation;->applyTransformation(FLandroid/view/animation/Transformation;)V

    .line 873
    .end local v3           #interpolatedTime:F
    :cond_82
    if-eqz v2, :cond_99

    .line 874
    iget v7, p0, Landroid/view/animation/Animation;->mRepeatCount:I

    iget v8, p0, Landroid/view/animation/Animation;->mRepeated:I

    if-ne v7, v8, :cond_b8

    .line 875
    iget-boolean v7, p0, Landroid/view/animation/Animation;->mEnded:Z

    if-nez v7, :cond_99

    .line 876
    const/4 v7, 0x1

    iput-boolean v7, p0, Landroid/view/animation/Animation;->mEnded:Z

    .line 877
    iget-object v7, p0, Landroid/view/animation/Animation;->guard:Ldalvik/system/CloseGuard;

    invoke-virtual {v7}, Ldalvik/system/CloseGuard;->close()V

    .line 878
    invoke-direct {p0}, Landroid/view/animation/Animation;->fireAnimationEnd()V

    .line 896
    :cond_99
    :goto_99
    iget-boolean v7, p0, Landroid/view/animation/Animation;->mMore:Z

    if-nez v7, :cond_db

    iget-boolean v7, p0, Landroid/view/animation/Animation;->mOneMoreTime:Z

    if-eqz v7, :cond_db

    .line 897
    const/4 v7, 0x0

    iput-boolean v7, p0, Landroid/view/animation/Animation;->mOneMoreTime:Z

    .line 898
    const/4 v7, 0x1

    .line 901
    :goto_a5
    return v7

    .line 846
    .end local v2           #expired:Z
    .end local v4           #normalizedTime:F
    :cond_a6
    iget-wide v7, p0, Landroid/view/animation/Animation;->mStartTime:J

    cmp-long v7, p1, v7

    if-gez v7, :cond_af

    const/4 v4, 0x0

    .restart local v4       #normalizedTime:F
    :goto_ad
    goto/16 :goto_1f

    .end local v4           #normalizedTime:F
    :cond_af
    const/high16 v4, 0x3f80

    goto :goto_ad

    .line 849
    .restart local v4       #normalizedTime:F
    :cond_b2
    const/4 v2, 0x0

    goto/16 :goto_26

    .line 850
    .restart local v2       #expired:Z
    :cond_b5
    const/4 v7, 0x0

    goto/16 :goto_29

    .line 881
    :cond_b8
    iget v7, p0, Landroid/view/animation/Animation;->mRepeatCount:I

    if-lez v7, :cond_c2

    .line 882
    iget v7, p0, Landroid/view/animation/Animation;->mRepeated:I

    add-int/lit8 v7, v7, 0x1

    iput v7, p0, Landroid/view/animation/Animation;->mRepeated:I

    .line 885
    :cond_c2
    iget v7, p0, Landroid/view/animation/Animation;->mRepeatMode:I

    const/4 v8, 0x2

    if-ne v7, v8, :cond_ce

    .line 886
    iget-boolean v7, p0, Landroid/view/animation/Animation;->mCycleFlip:Z

    if-nez v7, :cond_d9

    const/4 v7, 0x1

    :goto_cc
    iput-boolean v7, p0, Landroid/view/animation/Animation;->mCycleFlip:Z

    .line 889
    :cond_ce
    const-wide/16 v7, -0x1

    iput-wide v7, p0, Landroid/view/animation/Animation;->mStartTime:J

    .line 890
    const/4 v7, 0x1

    iput-boolean v7, p0, Landroid/view/animation/Animation;->mMore:Z

    .line 892
    invoke-direct {p0}, Landroid/view/animation/Animation;->fireAnimationRepeat()V

    goto :goto_99

    .line 886
    :cond_d9
    const/4 v7, 0x0

    goto :goto_cc

    .line 901
    :cond_db
    iget-boolean v7, p0, Landroid/view/animation/Animation;->mMore:Z

    goto :goto_a5
.end method

.method public getTransformation(JLandroid/view/animation/Transformation;F)Z
    .registers 6
    .parameter "currentTime"
    .parameter "outTransformation"
    .parameter "scale"

    .prologue
    .line 939
    iput p4, p0, Landroid/view/animation/Animation;->mScaleFactor:F

    .line 940
    invoke-virtual {p0, p1, p2, p3}, Landroid/view/animation/Animation;->getTransformation(JLandroid/view/animation/Transformation;)Z

    move-result v0

    return v0
.end method

.method public getZAdjustment()I
    .registers 2

    .prologue
    .line 750
    iget v0, p0, Landroid/view/animation/Animation;->mZAdjustment:I

    return v0
.end method

.method public hasAlpha()Z
    .registers 2

    .prologue
    .line 1067
    const/4 v0, 0x0

    return v0
.end method

.method public hasEnded()Z
    .registers 2

    .prologue
    .line 958
    iget-boolean v0, p0, Landroid/view/animation/Animation;->mEnded:Z

    return v0
.end method

.method public hasStarted()Z
    .registers 2

    .prologue
    .line 949
    iget-boolean v0, p0, Landroid/view/animation/Animation;->mStarted:Z

    return v0
.end method

.method public initialize(IIII)V
    .registers 6
    .parameter "width"
    .parameter "height"
    .parameter "parentWidth"
    .parameter "parentHeight"

    .prologue
    .line 346
    invoke-virtual {p0}, Landroid/view/animation/Animation;->reset()V

    .line 347
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/view/animation/Animation;->mInitialized:Z

    .line 348
    return-void
.end method

.method public initializeInvalidateRegion(IIII)V
    .registers 12
    .parameter "left"
    .parameter "top"
    .parameter "right"
    .parameter "bottom"

    .prologue
    const/high16 v6, -0x4080

    .line 1041
    iget-object v1, p0, Landroid/view/animation/Animation;->mPreviousRegion:Landroid/graphics/RectF;

    .line 1042
    .local v1, region:Landroid/graphics/RectF;
    int-to-float v2, p1

    int-to-float v3, p2

    int-to-float v4, p3

    int-to-float v5, p4

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/graphics/RectF;->set(FFFF)V

    .line 1044
    invoke-virtual {v1, v6, v6}, Landroid/graphics/RectF;->inset(FF)V

    .line 1045
    iget-boolean v2, p0, Landroid/view/animation/Animation;->mFillBefore:Z

    if-eqz v2, :cond_1e

    .line 1046
    iget-object v0, p0, Landroid/view/animation/Animation;->mPreviousTransformation:Landroid/view/animation/Transformation;

    .line 1047
    .local v0, previousTransformation:Landroid/view/animation/Transformation;
    iget-object v2, p0, Landroid/view/animation/Animation;->mInterpolator:Landroid/view/animation/Interpolator;

    const/4 v3, 0x0

    invoke-interface {v2, v3}, Landroid/view/animation/Interpolator;->getInterpolation(F)F

    move-result v2

    invoke-virtual {p0, v2, v0}, Landroid/view/animation/Animation;->applyTransformation(FLandroid/view/animation/Transformation;)V

    .line 1049
    .end local v0           #previousTransformation:Landroid/view/animation/Transformation;
    :cond_1e
    return-void
.end method

.method public isFillEnabled()Z
    .registers 2

    .prologue
    .line 556
    iget-boolean v0, p0, Landroid/view/animation/Animation;->mFillEnabled:Z

    return v0
.end method

.method public isInitialized()Z
    .registers 2

    .prologue
    .line 327
    iget-boolean v0, p0, Landroid/view/animation/Animation;->mInitialized:Z

    return v0
.end method

.method public reset()V
    .registers 4

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 277
    iget-object v0, p0, Landroid/view/animation/Animation;->mPreviousRegion:Landroid/graphics/RectF;

    invoke-virtual {v0}, Landroid/graphics/RectF;->setEmpty()V

    .line 278
    iget-object v0, p0, Landroid/view/animation/Animation;->mPreviousTransformation:Landroid/view/animation/Transformation;

    invoke-virtual {v0}, Landroid/view/animation/Transformation;->clear()V

    .line 279
    iput-boolean v1, p0, Landroid/view/animation/Animation;->mInitialized:Z

    .line 280
    iput-boolean v1, p0, Landroid/view/animation/Animation;->mCycleFlip:Z

    .line 281
    iput v1, p0, Landroid/view/animation/Animation;->mRepeated:I

    .line 282
    iput-boolean v2, p0, Landroid/view/animation/Animation;->mMore:Z

    .line 283
    iput-boolean v2, p0, Landroid/view/animation/Animation;->mOneMoreTime:Z

    .line 284
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/view/animation/Animation;->mListenerHandler:Landroid/os/Handler;

    .line 285
    return-void
.end method

.method protected resolveSize(IFII)F
    .registers 6
    .parameter "type"
    .parameter "value"
    .parameter "size"
    .parameter "parentSize"

    .prologue
    .line 987
    packed-switch p1, :pswitch_data_a

    .line 995
    .end local p2
    :goto_3
    :pswitch_3
    return p2

    .line 991
    .restart local p2
    :pswitch_4
    int-to-float v0, p3

    mul-float/2addr p2, v0

    goto :goto_3

    .line 993
    :pswitch_7
    int-to-float v0, p4

    mul-float/2addr p2, v0

    goto :goto_3

    .line 987
    :pswitch_data_a
    .packed-switch 0x0
        :pswitch_3
        :pswitch_4
        :pswitch_7
    .end packed-switch
.end method

.method public restrictDuration(J)V
    .registers 12
    .parameter "durationMillis"

    .prologue
    const-wide/16 v7, 0x0

    const/4 v6, 0x0

    .line 445
    iget-wide v2, p0, Landroid/view/animation/Animation;->mStartOffset:J

    cmp-long v2, v2, p1

    if-lez v2, :cond_10

    .line 446
    iput-wide p1, p0, Landroid/view/animation/Animation;->mStartOffset:J

    .line 447
    iput-wide v7, p0, Landroid/view/animation/Animation;->mDuration:J

    .line 448
    iput v6, p0, Landroid/view/animation/Animation;->mRepeatCount:I

    .line 475
    :cond_f
    :goto_f
    return-void

    .line 452
    :cond_10
    iget-wide v2, p0, Landroid/view/animation/Animation;->mDuration:J

    iget-wide v4, p0, Landroid/view/animation/Animation;->mStartOffset:J

    add-long v0, v2, v4

    .line 453
    .local v0, dur:J
    cmp-long v2, v0, p1

    if-lez v2, :cond_21

    .line 454
    iget-wide v2, p0, Landroid/view/animation/Animation;->mStartOffset:J

    sub-long v2, p1, v2

    iput-wide v2, p0, Landroid/view/animation/Animation;->mDuration:J

    .line 455
    move-wide v0, p1

    .line 458
    :cond_21
    iget-wide v2, p0, Landroid/view/animation/Animation;->mDuration:J

    cmp-long v2, v2, v7

    if-gtz v2, :cond_2c

    .line 459
    iput-wide v7, p0, Landroid/view/animation/Animation;->mDuration:J

    .line 460
    iput v6, p0, Landroid/view/animation/Animation;->mRepeatCount:I

    goto :goto_f

    .line 466
    :cond_2c
    iget v2, p0, Landroid/view/animation/Animation;->mRepeatCount:I

    if-ltz v2, :cond_3f

    iget v2, p0, Landroid/view/animation/Animation;->mRepeatCount:I

    int-to-long v2, v2

    cmp-long v2, v2, p1

    if-gtz v2, :cond_3f

    iget v2, p0, Landroid/view/animation/Animation;->mRepeatCount:I

    int-to-long v2, v2

    mul-long/2addr v2, v0

    cmp-long v2, v2, p1

    if-lez v2, :cond_f

    .line 470
    :cond_3f
    div-long v2, p1, v0

    long-to-int v2, v2

    add-int/lit8 v2, v2, -0x1

    iput v2, p0, Landroid/view/animation/Animation;->mRepeatCount:I

    .line 471
    iget v2, p0, Landroid/view/animation/Animation;->mRepeatCount:I

    if-gez v2, :cond_f

    .line 472
    iput v6, p0, Landroid/view/animation/Animation;->mRepeatCount:I

    goto :goto_f
.end method

.method public scaleCurrentDuration(F)V
    .registers 4
    .parameter "scale"

    .prologue
    .line 483
    iget-wide v0, p0, Landroid/view/animation/Animation;->mDuration:J

    long-to-float v0, v0

    mul-float/2addr v0, p1

    float-to-long v0, v0

    iput-wide v0, p0, Landroid/view/animation/Animation;->mDuration:J

    .line 484
    iget-wide v0, p0, Landroid/view/animation/Animation;->mStartOffset:J

    long-to-float v0, v0

    mul-float/2addr v0, p1

    float-to-long v0, v0

    iput-wide v0, p0, Landroid/view/animation/Animation;->mStartOffset:J

    .line 485
    return-void
.end method

.method public setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V
    .registers 2
    .parameter "listener"

    .prologue
    .line 800
    iput-object p1, p0, Landroid/view/animation/Animation;->mListener:Landroid/view/animation/Animation$AnimationListener;

    .line 801
    return-void
.end method

.method public setBackgroundColor(I)V
    .registers 2
    .parameter "bg"

    .prologue
    .line 626
    iput p1, p0, Landroid/view/animation/Animation;->mBackgroundColor:I

    .line 627
    return-void
.end method

.method public setDetachWallpaper(Z)V
    .registers 2
    .parameter "detachWallpaper"

    .prologue
    .line 652
    iput-boolean p1, p0, Landroid/view/animation/Animation;->mDetachWallpaper:Z

    .line 653
    return-void
.end method

.method public setDuration(J)V
    .registers 5
    .parameter "durationMillis"

    .prologue
    .line 428
    const-wide/16 v0, 0x0

    cmp-long v0, p1, v0

    if-gez v0, :cond_e

    .line 429
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Animation duration cannot be negative"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 431
    :cond_e
    iput-wide p1, p0, Landroid/view/animation/Animation;->mDuration:J

    .line 432
    return-void
.end method

.method public setFillAfter(Z)V
    .registers 2
    .parameter "fillAfter"

    .prologue
    .line 605
    iput-boolean p1, p0, Landroid/view/animation/Animation;->mFillAfter:Z

    .line 606
    return-void
.end method

.method public setFillBefore(Z)V
    .registers 2
    .parameter "fillBefore"

    .prologue
    .line 589
    iput-boolean p1, p0, Landroid/view/animation/Animation;->mFillBefore:Z

    .line 590
    return-void
.end method

.method public setFillEnabled(Z)V
    .registers 2
    .parameter "fillEnabled"

    .prologue
    .line 571
    iput-boolean p1, p0, Landroid/view/animation/Animation;->mFillEnabled:Z

    .line 572
    return-void
.end method

.method public setInterpolator(Landroid/content/Context;I)V
    .registers 4
    .parameter "context"
    .parameter "resID"

    .prologue
    .line 391
    invoke-static {p1, p2}, Landroid/view/animation/AnimationUtils;->loadInterpolator(Landroid/content/Context;I)Landroid/view/animation/Interpolator;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/view/animation/Animation;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 392
    return-void
.end method

.method public setInterpolator(Landroid/view/animation/Interpolator;)V
    .registers 2
    .parameter "i"

    .prologue
    .line 402
    iput-object p1, p0, Landroid/view/animation/Animation;->mInterpolator:Landroid/view/animation/Interpolator;

    .line 403
    return-void
.end method

.method public setListenerHandler(Landroid/os/Handler;)V
    .registers 3
    .parameter "handler"

    .prologue
    .line 356
    iget-object v0, p0, Landroid/view/animation/Animation;->mListenerHandler:Landroid/os/Handler;

    if-nez v0, :cond_19

    .line 357
    new-instance v0, Landroid/view/animation/Animation$1;

    invoke-direct {v0, p0}, Landroid/view/animation/Animation$1;-><init>(Landroid/view/animation/Animation;)V

    iput-object v0, p0, Landroid/view/animation/Animation;->mOnStart:Ljava/lang/Runnable;

    .line 364
    new-instance v0, Landroid/view/animation/Animation$2;

    invoke-direct {v0, p0}, Landroid/view/animation/Animation$2;-><init>(Landroid/view/animation/Animation;)V

    iput-object v0, p0, Landroid/view/animation/Animation;->mOnRepeat:Ljava/lang/Runnable;

    .line 371
    new-instance v0, Landroid/view/animation/Animation$3;

    invoke-direct {v0, p0}, Landroid/view/animation/Animation$3;-><init>(Landroid/view/animation/Animation;)V

    iput-object v0, p0, Landroid/view/animation/Animation;->mOnEnd:Ljava/lang/Runnable;

    .line 379
    :cond_19
    iput-object p1, p0, Landroid/view/animation/Animation;->mListenerHandler:Landroid/os/Handler;

    .line 380
    return-void
.end method

.method public setRepeatCount(I)V
    .registers 2
    .parameter "repeatCount"

    .prologue
    .line 543
    if-gez p1, :cond_3

    .line 544
    const/4 p1, -0x1

    .line 546
    :cond_3
    iput p1, p0, Landroid/view/animation/Animation;->mRepeatCount:I

    .line 547
    return-void
.end method

.method public setRepeatMode(I)V
    .registers 2
    .parameter "repeatMode"

    .prologue
    .line 530
    iput p1, p0, Landroid/view/animation/Animation;->mRepeatMode:I

    .line 531
    return-void
.end method

.method public setStartOffset(J)V
    .registers 3
    .parameter "startOffset"

    .prologue
    .line 415
    iput-wide p1, p0, Landroid/view/animation/Animation;->mStartOffset:J

    .line 416
    return-void
.end method

.method public setStartTime(J)V
    .registers 4
    .parameter "startTimeMillis"

    .prologue
    const/4 v0, 0x0

    .line 498
    iput-wide p1, p0, Landroid/view/animation/Animation;->mStartTime:J

    .line 499
    iput-boolean v0, p0, Landroid/view/animation/Animation;->mEnded:Z

    iput-boolean v0, p0, Landroid/view/animation/Animation;->mStarted:Z

    .line 500
    iput-boolean v0, p0, Landroid/view/animation/Animation;->mCycleFlip:Z

    .line 501
    iput v0, p0, Landroid/view/animation/Animation;->mRepeated:I

    .line 502
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/view/animation/Animation;->mMore:Z

    .line 503
    return-void
.end method

.method public setZAdjustment(I)V
    .registers 2
    .parameter "zAdjustment"

    .prologue
    .line 616
    iput p1, p0, Landroid/view/animation/Animation;->mZAdjustment:I

    .line 617
    return-void
.end method

.method public start()V
    .registers 3

    .prologue
    .line 510
    const-wide/16 v0, -0x1

    invoke-virtual {p0, v0, v1}, Landroid/view/animation/Animation;->setStartTime(J)V

    .line 511
    return-void
.end method

.method public startNow()V
    .registers 3

    .prologue
    .line 518
    invoke-static {}, Landroid/view/animation/AnimationUtils;->currentAnimationTimeMillis()J

    move-result-wide v0

    invoke-virtual {p0, v0, v1}, Landroid/view/animation/Animation;->setStartTime(J)V

    .line 519
    return-void
.end method

.method public willChangeBounds()Z
    .registers 2

    .prologue
    .line 789
    const/4 v0, 0x1

    return v0
.end method

.method public willChangeTransformationMatrix()Z
    .registers 2

    .prologue
    .line 777
    const/4 v0, 0x1

    return v0
.end method
