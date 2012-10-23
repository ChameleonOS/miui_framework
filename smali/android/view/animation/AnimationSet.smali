.class public Landroid/view/animation/AnimationSet;
.super Landroid/view/animation/Animation;
.source "AnimationSet.java"


# static fields
.field private static final PROPERTY_CHANGE_BOUNDS_MASK:I = 0x80

.field private static final PROPERTY_DURATION_MASK:I = 0x20

.field private static final PROPERTY_FILL_AFTER_MASK:I = 0x1

.field private static final PROPERTY_FILL_BEFORE_MASK:I = 0x2

.field private static final PROPERTY_MORPH_MATRIX_MASK:I = 0x40

.field private static final PROPERTY_REPEAT_MODE_MASK:I = 0x4

.field private static final PROPERTY_SHARE_INTERPOLATOR_MASK:I = 0x10

.field private static final PROPERTY_START_OFFSET_MASK:I = 0x8


# instance fields
.field private mAnimations:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/view/animation/Animation;",
            ">;"
        }
    .end annotation
.end field

.field private mDirty:Z

.field private mFlags:I

.field private mHasAlpha:Z

.field private mLastEnd:J

.field private mStoredOffsets:[J

.field private mTempTransformation:Landroid/view/animation/Transformation;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 7
    .parameter "context"
    .parameter "attrs"

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 81
    invoke-direct {p0, p1, p2}, Landroid/view/animation/Animation;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 62
    iput v3, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    .line 66
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Landroid/view/animation/AnimationSet;->mAnimations:Ljava/util/ArrayList;

    .line 68
    new-instance v1, Landroid/view/animation/Transformation;

    invoke-direct {v1}, Landroid/view/animation/Transformation;-><init>()V

    iput-object v1, p0, Landroid/view/animation/AnimationSet;->mTempTransformation:Landroid/view/animation/Transformation;

    .line 83
    sget-object v1, Lcom/android/internal/R$styleable;->AnimationSet:[I

    invoke-virtual {p1, p2, v1}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 86
    .local v0, a:Landroid/content/res/TypedArray;
    const/16 v1, 0x10

    invoke-virtual {v0, v2, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    invoke-direct {p0, v1, v2}, Landroid/view/animation/AnimationSet;->setFlag(IZ)V

    .line 88
    invoke-direct {p0}, Landroid/view/animation/AnimationSet;->init()V

    .line 90
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v1

    iget v1, v1, Landroid/content/pm/ApplicationInfo;->targetSdkVersion:I

    const/16 v2, 0xe

    if-lt v1, v2, :cond_71

    .line 92
    invoke-virtual {v0, v3}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v1

    if-eqz v1, :cond_3d

    .line 93
    iget v1, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    or-int/lit8 v1, v1, 0x20

    iput v1, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    .line 95
    :cond_3d
    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v1

    if-eqz v1, :cond_4a

    .line 96
    iget v1, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    or-int/lit8 v1, v1, 0x2

    iput v1, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    .line 98
    :cond_4a
    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v1

    if-eqz v1, :cond_57

    .line 99
    iget v1, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    or-int/lit8 v1, v1, 0x1

    iput v1, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    .line 101
    :cond_57
    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v1

    if-eqz v1, :cond_64

    .line 102
    iget v1, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    or-int/lit8 v1, v1, 0x4

    iput v1, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    .line 104
    :cond_64
    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v1

    if-eqz v1, :cond_71

    .line 105
    iget v1, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    or-int/lit8 v1, v1, 0x8

    iput v1, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    .line 109
    :cond_71
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 110
    return-void
.end method

.method public constructor <init>(Z)V
    .registers 3
    .parameter "shareInterpolator"

    .prologue
    .line 120
    invoke-direct {p0}, Landroid/view/animation/Animation;-><init>()V

    .line 62
    const/4 v0, 0x0

    iput v0, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    .line 66
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/view/animation/AnimationSet;->mAnimations:Ljava/util/ArrayList;

    .line 68
    new-instance v0, Landroid/view/animation/Transformation;

    invoke-direct {v0}, Landroid/view/animation/Transformation;-><init>()V

    iput-object v0, p0, Landroid/view/animation/AnimationSet;->mTempTransformation:Landroid/view/animation/Transformation;

    .line 121
    const/16 v0, 0x10

    invoke-direct {p0, v0, p1}, Landroid/view/animation/AnimationSet;->setFlag(IZ)V

    .line 122
    invoke-direct {p0}, Landroid/view/animation/AnimationSet;->init()V

    .line 123
    return-void
.end method

.method private init()V
    .registers 3

    .prologue
    .line 150
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Landroid/view/animation/Animation;->mStartTime:J

    .line 151
    return-void
.end method

.method private setFlag(IZ)V
    .registers 5
    .parameter "mask"
    .parameter "value"

    .prologue
    .line 142
    if-eqz p2, :cond_8

    .line 143
    iget v0, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    or-int/2addr v0, p1

    iput v0, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    .line 147
    :goto_7
    return-void

    .line 145
    :cond_8
    iget v0, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    xor-int/lit8 v1, p1, -0x1

    and-int/2addr v0, v1

    iput v0, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    goto :goto_7
.end method


# virtual methods
.method public addAnimation(Landroid/view/animation/Animation;)V
    .registers 11
    .parameter "a"

    .prologue
    const/4 v0, 0x0

    const/4 v2, 0x1

    .line 219
    iget-object v3, p0, Landroid/view/animation/AnimationSet;->mAnimations:Ljava/util/ArrayList;

    invoke-virtual {v3, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 221
    iget v3, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    and-int/lit8 v3, v3, 0x40

    if-nez v3, :cond_43

    move v1, v2

    .line 222
    .local v1, noMatrix:Z
    :goto_e
    if-eqz v1, :cond_1c

    invoke-virtual {p1}, Landroid/view/animation/Animation;->willChangeTransformationMatrix()Z

    move-result v3

    if-eqz v3, :cond_1c

    .line 223
    iget v3, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    or-int/lit8 v3, v3, 0x40

    iput v3, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    .line 226
    :cond_1c
    iget v3, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    and-int/lit16 v3, v3, 0x80

    if-nez v3, :cond_23

    move v0, v2

    .line 229
    .local v0, changeBounds:Z
    :cond_23
    if-eqz v0, :cond_31

    invoke-virtual {p1}, Landroid/view/animation/Animation;->willChangeBounds()Z

    move-result v3

    if-eqz v3, :cond_31

    .line 230
    iget v3, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    or-int/lit16 v3, v3, 0x80

    iput v3, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    .line 233
    :cond_31
    iget v3, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    and-int/lit8 v3, v3, 0x20

    const/16 v4, 0x20

    if-ne v3, v4, :cond_45

    .line 234
    iget-wide v3, p0, Landroid/view/animation/Animation;->mStartOffset:J

    iget-wide v5, p0, Landroid/view/animation/Animation;->mDuration:J

    add-long/2addr v3, v5

    iput-wide v3, p0, Landroid/view/animation/AnimationSet;->mLastEnd:J

    .line 245
    :goto_40
    iput-boolean v2, p0, Landroid/view/animation/AnimationSet;->mDirty:Z

    .line 246
    return-void

    .end local v0           #changeBounds:Z
    .end local v1           #noMatrix:Z
    :cond_43
    move v1, v0

    .line 221
    goto :goto_e

    .line 236
    .restart local v0       #changeBounds:Z
    .restart local v1       #noMatrix:Z
    :cond_45
    iget-object v3, p0, Landroid/view/animation/AnimationSet;->mAnimations:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-ne v3, v2, :cond_60

    .line 237
    invoke-virtual {p1}, Landroid/view/animation/Animation;->getStartOffset()J

    move-result-wide v3

    invoke-virtual {p1}, Landroid/view/animation/Animation;->getDuration()J

    move-result-wide v5

    add-long/2addr v3, v5

    iput-wide v3, p0, Landroid/view/animation/Animation;->mDuration:J

    .line 238
    iget-wide v3, p0, Landroid/view/animation/Animation;->mStartOffset:J

    iget-wide v5, p0, Landroid/view/animation/Animation;->mDuration:J

    add-long/2addr v3, v5

    iput-wide v3, p0, Landroid/view/animation/AnimationSet;->mLastEnd:J

    goto :goto_40

    .line 240
    :cond_60
    iget-wide v3, p0, Landroid/view/animation/AnimationSet;->mLastEnd:J

    invoke-virtual {p1}, Landroid/view/animation/Animation;->getStartOffset()J

    move-result-wide v5

    invoke-virtual {p1}, Landroid/view/animation/Animation;->getDuration()J

    move-result-wide v7

    add-long/2addr v5, v7

    invoke-static {v3, v4, v5, v6}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v3

    iput-wide v3, p0, Landroid/view/animation/AnimationSet;->mLastEnd:J

    .line 241
    iget-wide v3, p0, Landroid/view/animation/AnimationSet;->mLastEnd:J

    iget-wide v5, p0, Landroid/view/animation/Animation;->mStartOffset:J

    sub-long/2addr v3, v5

    iput-wide v3, p0, Landroid/view/animation/Animation;->mDuration:J

    goto :goto_40
.end method

.method protected bridge synthetic clone()Landroid/view/animation/Animation;
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 52
    invoke-virtual {p0}, Landroid/view/animation/AnimationSet;->clone()Landroid/view/animation/AnimationSet;

    move-result-object v0

    return-object v0
.end method

.method protected clone()Landroid/view/animation/AnimationSet;
    .registers 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 127
    invoke-super {p0}, Landroid/view/animation/Animation;->clone()Landroid/view/animation/Animation;

    move-result-object v0

    check-cast v0, Landroid/view/animation/AnimationSet;

    .line 128
    .local v0, animation:Landroid/view/animation/AnimationSet;
    new-instance v4, Landroid/view/animation/Transformation;

    invoke-direct {v4}, Landroid/view/animation/Transformation;-><init>()V

    iput-object v4, v0, Landroid/view/animation/AnimationSet;->mTempTransformation:Landroid/view/animation/Transformation;

    .line 129
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    iput-object v4, v0, Landroid/view/animation/AnimationSet;->mAnimations:Ljava/util/ArrayList;

    .line 131
    iget-object v4, p0, Landroid/view/animation/AnimationSet;->mAnimations:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v2

    .line 132
    .local v2, count:I
    iget-object v1, p0, Landroid/view/animation/AnimationSet;->mAnimations:Ljava/util/ArrayList;

    .line 134
    .local v1, animations:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/animation/Animation;>;"
    const/4 v3, 0x0

    .local v3, i:I
    :goto_1d
    if-ge v3, v2, :cond_31

    .line 135
    iget-object v5, v0, Landroid/view/animation/AnimationSet;->mAnimations:Ljava/util/ArrayList;

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/view/animation/Animation;

    invoke-virtual {v4}, Landroid/view/animation/Animation;->clone()Landroid/view/animation/Animation;

    move-result-object v4

    invoke-virtual {v5, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 134
    add-int/lit8 v3, v3, 0x1

    goto :goto_1d

    .line 138
    :cond_31
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
    .line 52
    invoke-virtual {p0}, Landroid/view/animation/AnimationSet;->clone()Landroid/view/animation/AnimationSet;

    move-result-object v0

    return-object v0
.end method

.method public computeDurationHint()J
    .registers 9

    .prologue
    .line 324
    const-wide/16 v4, 0x0

    .line 325
    .local v4, duration:J
    iget-object v7, p0, Landroid/view/animation/AnimationSet;->mAnimations:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v1

    .line 326
    .local v1, count:I
    iget-object v0, p0, Landroid/view/animation/AnimationSet;->mAnimations:Ljava/util/ArrayList;

    .line 327
    .local v0, animations:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/animation/Animation;>;"
    add-int/lit8 v6, v1, -0x1

    .local v6, i:I
    :goto_c
    if-ltz v6, :cond_20

    .line 328
    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/view/animation/Animation;

    invoke-virtual {v7}, Landroid/view/animation/Animation;->computeDurationHint()J

    move-result-wide v2

    .line 329
    .local v2, d:J
    cmp-long v7, v2, v4

    if-lez v7, :cond_1d

    move-wide v4, v2

    .line 327
    :cond_1d
    add-int/lit8 v6, v6, -0x1

    goto :goto_c

    .line 331
    .end local v2           #d:J
    :cond_20
    return-wide v4
.end method

.method public getAnimations()Ljava/util/List;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Landroid/view/animation/Animation;",
            ">;"
        }
    .end annotation

    .prologue
    .line 512
    iget-object v0, p0, Landroid/view/animation/AnimationSet;->mAnimations:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getDuration()J
    .registers 9

    .prologue
    .line 301
    iget-object v0, p0, Landroid/view/animation/AnimationSet;->mAnimations:Ljava/util/ArrayList;

    .line 302
    .local v0, animations:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/animation/Animation;>;"
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v1

    .line 303
    .local v1, count:I
    const-wide/16 v2, 0x0

    .line 305
    .local v2, duration:J
    iget v6, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    and-int/lit8 v6, v6, 0x20

    const/16 v7, 0x20

    if-ne v6, v7, :cond_16

    const/4 v4, 0x1

    .line 306
    .local v4, durationSet:Z
    :goto_11
    if-eqz v4, :cond_18

    .line 307
    iget-wide v2, p0, Landroid/view/animation/Animation;->mDuration:J

    .line 314
    :cond_15
    return-wide v2

    .line 305
    .end local v4           #durationSet:Z
    :cond_16
    const/4 v4, 0x0

    goto :goto_11

    .line 309
    .restart local v4       #durationSet:Z
    :cond_18
    const/4 v5, 0x0

    .local v5, i:I
    :goto_19
    if-ge v5, v1, :cond_15

    .line 310
    invoke-virtual {v0, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/view/animation/Animation;

    invoke-virtual {v6}, Landroid/view/animation/Animation;->getDuration()J

    move-result-wide v6

    invoke-static {v2, v3, v6, v7}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v2

    .line 309
    add-int/lit8 v5, v5, 0x1

    goto :goto_19
.end method

.method public getStartTime()J
    .registers 9

    .prologue
    .line 268
    const-wide v4, 0x7fffffffffffffffL

    .line 270
    .local v4, startTime:J
    iget-object v6, p0, Landroid/view/animation/AnimationSet;->mAnimations:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v2

    .line 271
    .local v2, count:I
    iget-object v1, p0, Landroid/view/animation/AnimationSet;->mAnimations:Ljava/util/ArrayList;

    .line 273
    .local v1, animations:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/animation/Animation;>;"
    const/4 v3, 0x0

    .local v3, i:I
    :goto_e
    if-ge v3, v2, :cond_21

    .line 274
    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/animation/Animation;

    .line 275
    .local v0, a:Landroid/view/animation/Animation;
    invoke-virtual {v0}, Landroid/view/animation/Animation;->getStartTime()J

    move-result-wide v6

    invoke-static {v4, v5, v6, v7}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v4

    .line 273
    add-int/lit8 v3, v3, 0x1

    goto :goto_e

    .line 278
    .end local v0           #a:Landroid/view/animation/Animation;
    :cond_21
    return-wide v4
.end method

.method public getTransformation(JLandroid/view/animation/Transformation;)Z
    .registers 15
    .parameter "currentTime"
    .parameter "t"

    .prologue
    const/4 v8, 0x0

    const/4 v9, 0x1

    .line 370
    iget-object v10, p0, Landroid/view/animation/AnimationSet;->mAnimations:Ljava/util/ArrayList;

    invoke-virtual {v10}, Ljava/util/ArrayList;->size()I

    move-result v2

    .line 371
    .local v2, count:I
    iget-object v1, p0, Landroid/view/animation/AnimationSet;->mAnimations:Ljava/util/ArrayList;

    .line 372
    .local v1, animations:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/animation/Animation;>;"
    iget-object v7, p0, Landroid/view/animation/AnimationSet;->mTempTransformation:Landroid/view/animation/Transformation;

    .line 374
    .local v7, temp:Landroid/view/animation/Transformation;
    const/4 v5, 0x0

    .line 375
    .local v5, more:Z
    const/4 v6, 0x0

    .line 376
    .local v6, started:Z
    const/4 v3, 0x1

    .line 378
    .local v3, ended:Z
    invoke-virtual {p3}, Landroid/view/animation/Transformation;->clear()V

    .line 380
    add-int/lit8 v4, v2, -0x1

    .local v4, i:I
    :goto_14
    if-ltz v4, :cond_4a

    .line 381
    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/animation/Animation;

    .line 383
    .local v0, a:Landroid/view/animation/Animation;
    invoke-virtual {v7}, Landroid/view/animation/Transformation;->clear()V

    .line 384
    invoke-virtual {p0}, Landroid/view/animation/AnimationSet;->getScaleFactor()F

    move-result v10

    invoke-virtual {v0, p1, p2, v7, v10}, Landroid/view/animation/Animation;->getTransformation(JLandroid/view/animation/Transformation;F)Z

    move-result v10

    if-nez v10, :cond_2b

    if-eqz v5, :cond_44

    :cond_2b
    move v5, v9

    .line 385
    :goto_2c
    invoke-virtual {p3, v7}, Landroid/view/animation/Transformation;->compose(Landroid/view/animation/Transformation;)V

    .line 387
    if-nez v6, :cond_37

    invoke-virtual {v0}, Landroid/view/animation/Animation;->hasStarted()Z

    move-result v10

    if-eqz v10, :cond_46

    :cond_37
    move v6, v9

    .line 388
    :goto_38
    invoke-virtual {v0}, Landroid/view/animation/Animation;->hasEnded()Z

    move-result v10

    if-eqz v10, :cond_48

    if-eqz v3, :cond_48

    move v3, v9

    .line 380
    :goto_41
    add-int/lit8 v4, v4, -0x1

    goto :goto_14

    :cond_44
    move v5, v8

    .line 384
    goto :goto_2c

    :cond_46
    move v6, v8

    .line 387
    goto :goto_38

    :cond_48
    move v3, v8

    .line 388
    goto :goto_41

    .line 391
    .end local v0           #a:Landroid/view/animation/Animation;
    :cond_4a
    if-eqz v6, :cond_5b

    iget-boolean v8, p0, Landroid/view/animation/Animation;->mStarted:Z

    if-nez v8, :cond_5b

    .line 392
    iget-object v8, p0, Landroid/view/animation/Animation;->mListener:Landroid/view/animation/Animation$AnimationListener;

    if-eqz v8, :cond_59

    .line 393
    iget-object v8, p0, Landroid/view/animation/Animation;->mListener:Landroid/view/animation/Animation$AnimationListener;

    invoke-interface {v8, p0}, Landroid/view/animation/Animation$AnimationListener;->onAnimationStart(Landroid/view/animation/Animation;)V

    .line 395
    :cond_59
    iput-boolean v9, p0, Landroid/view/animation/Animation;->mStarted:Z

    .line 398
    :cond_5b
    iget-boolean v8, p0, Landroid/view/animation/Animation;->mEnded:Z

    if-eq v3, v8, :cond_6a

    .line 399
    iget-object v8, p0, Landroid/view/animation/Animation;->mListener:Landroid/view/animation/Animation$AnimationListener;

    if-eqz v8, :cond_68

    .line 400
    iget-object v8, p0, Landroid/view/animation/Animation;->mListener:Landroid/view/animation/Animation$AnimationListener;

    invoke-interface {v8, p0}, Landroid/view/animation/Animation$AnimationListener;->onAnimationEnd(Landroid/view/animation/Animation;)V

    .line 402
    :cond_68
    iput-boolean v3, p0, Landroid/view/animation/Animation;->mEnded:Z

    .line 405
    :cond_6a
    return v5
.end method

.method public hasAlpha()Z
    .registers 5

    .prologue
    .line 182
    iget-boolean v3, p0, Landroid/view/animation/AnimationSet;->mDirty:Z

    if-eqz v3, :cond_23

    .line 183
    const/4 v3, 0x0

    iput-boolean v3, p0, Landroid/view/animation/AnimationSet;->mHasAlpha:Z

    iput-boolean v3, p0, Landroid/view/animation/AnimationSet;->mDirty:Z

    .line 185
    iget-object v3, p0, Landroid/view/animation/AnimationSet;->mAnimations:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v1

    .line 186
    .local v1, count:I
    iget-object v0, p0, Landroid/view/animation/AnimationSet;->mAnimations:Ljava/util/ArrayList;

    .line 188
    .local v0, animations:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/animation/Animation;>;"
    const/4 v2, 0x0

    .local v2, i:I
    :goto_12
    if-ge v2, v1, :cond_23

    .line 189
    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/view/animation/Animation;

    invoke-virtual {v3}, Landroid/view/animation/Animation;->hasAlpha()Z

    move-result v3

    if-eqz v3, :cond_26

    .line 190
    const/4 v3, 0x1

    iput-boolean v3, p0, Landroid/view/animation/AnimationSet;->mHasAlpha:Z

    .line 196
    .end local v0           #animations:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/animation/Animation;>;"
    .end local v1           #count:I
    .end local v2           #i:I
    :cond_23
    iget-boolean v3, p0, Landroid/view/animation/AnimationSet;->mHasAlpha:Z

    return v3

    .line 188
    .restart local v0       #animations:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/animation/Animation;>;"
    .restart local v1       #count:I
    .restart local v2       #i:I
    :cond_26
    add-int/lit8 v2, v2, 0x1

    goto :goto_12
.end method

.method public initialize(IIII)V
    .registers 32
    .parameter "width"
    .parameter "height"
    .parameter "parentWidth"
    .parameter "parentHeight"

    .prologue
    .line 425
    invoke-super/range {p0 .. p4}, Landroid/view/animation/Animation;->initialize(IIII)V

    .line 427
    move-object/from16 v0, p0

    iget v0, v0, Landroid/view/animation/AnimationSet;->mFlags:I

    move/from16 v25, v0

    and-int/lit8 v25, v25, 0x20

    const/16 v26, 0x20

    move/from16 v0, v25

    move/from16 v1, v26

    if-ne v0, v1, :cond_f3

    const/4 v9, 0x1

    .line 428
    .local v9, durationSet:Z
    :goto_14
    move-object/from16 v0, p0

    iget v0, v0, Landroid/view/animation/AnimationSet;->mFlags:I

    move/from16 v25, v0

    and-int/lit8 v25, v25, 0x1

    const/16 v26, 0x1

    move/from16 v0, v25

    move/from16 v1, v26

    if-ne v0, v1, :cond_f6

    const/4 v11, 0x1

    .line 429
    .local v11, fillAfterSet:Z
    :goto_25
    move-object/from16 v0, p0

    iget v0, v0, Landroid/view/animation/AnimationSet;->mFlags:I

    move/from16 v25, v0

    and-int/lit8 v25, v25, 0x2

    const/16 v26, 0x2

    move/from16 v0, v25

    move/from16 v1, v26

    if-ne v0, v1, :cond_f9

    const/4 v13, 0x1

    .line 430
    .local v13, fillBeforeSet:Z
    :goto_36
    move-object/from16 v0, p0

    iget v0, v0, Landroid/view/animation/AnimationSet;->mFlags:I

    move/from16 v25, v0

    and-int/lit8 v25, v25, 0x4

    const/16 v26, 0x4

    move/from16 v0, v25

    move/from16 v1, v26

    if-ne v0, v1, :cond_fc

    const/16 v19, 0x1

    .line 431
    .local v19, repeatModeSet:Z
    :goto_48
    move-object/from16 v0, p0

    iget v0, v0, Landroid/view/animation/AnimationSet;->mFlags:I

    move/from16 v25, v0

    and-int/lit8 v25, v25, 0x10

    const/16 v26, 0x10

    move/from16 v0, v25

    move/from16 v1, v26

    if-ne v0, v1, :cond_100

    const/16 v20, 0x1

    .line 433
    .local v20, shareInterpolator:Z
    :goto_5a
    move-object/from16 v0, p0

    iget v0, v0, Landroid/view/animation/AnimationSet;->mFlags:I

    move/from16 v25, v0

    and-int/lit8 v25, v25, 0x8

    const/16 v26, 0x8

    move/from16 v0, v25

    move/from16 v1, v26

    if-ne v0, v1, :cond_104

    const/16 v23, 0x1

    .line 436
    .local v23, startOffsetSet:Z
    :goto_6c
    if-eqz v20, :cond_71

    .line 437
    invoke-virtual/range {p0 .. p0}, Landroid/view/animation/AnimationSet;->ensureInterpolator()V

    .line 440
    :cond_71
    move-object/from16 v0, p0

    iget-object v5, v0, Landroid/view/animation/AnimationSet;->mAnimations:Ljava/util/ArrayList;

    .line 441
    .local v5, children:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/animation/Animation;>;"
    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v6

    .line 443
    .local v6, count:I
    move-object/from16 v0, p0

    iget-wide v7, v0, Landroid/view/animation/Animation;->mDuration:J

    .line 444
    .local v7, duration:J
    move-object/from16 v0, p0

    iget-boolean v10, v0, Landroid/view/animation/Animation;->mFillAfter:Z

    .line 445
    .local v10, fillAfter:Z
    move-object/from16 v0, p0

    iget-boolean v12, v0, Landroid/view/animation/Animation;->mFillBefore:Z

    .line 446
    .local v12, fillBefore:Z
    move-object/from16 v0, p0

    iget v0, v0, Landroid/view/animation/Animation;->mRepeatMode:I

    move/from16 v18, v0

    .line 447
    .local v18, repeatMode:I
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/view/animation/Animation;->mInterpolator:Landroid/view/animation/Interpolator;

    .line 448
    .local v15, interpolator:Landroid/view/animation/Interpolator;
    move-object/from16 v0, p0

    iget-wide v0, v0, Landroid/view/animation/Animation;->mStartOffset:J

    move-wide/from16 v21, v0

    .line 451
    .local v21, startOffset:J
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/animation/AnimationSet;->mStoredOffsets:[J

    move-object/from16 v24, v0

    .line 452
    .local v24, storedOffsets:[J
    if-eqz v23, :cond_108

    .line 453
    if-eqz v24, :cond_a8

    move-object/from16 v0, v24

    array-length v0, v0

    move/from16 v25, v0

    move/from16 v0, v25

    if-eq v0, v6, :cond_b2

    .line 454
    :cond_a8
    new-array v0, v6, [J

    move-object/from16 v24, v0

    .end local v24           #storedOffsets:[J
    move-object/from16 v0, v24

    move-object/from16 v1, p0

    iput-object v0, v1, Landroid/view/animation/AnimationSet;->mStoredOffsets:[J

    .line 460
    .restart local v24       #storedOffsets:[J
    :cond_b2
    :goto_b2
    const/4 v14, 0x0

    .local v14, i:I
    :goto_b3
    if-ge v14, v6, :cond_113

    .line 461
    invoke-virtual {v5, v14}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/view/animation/Animation;

    .line 462
    .local v4, a:Landroid/view/animation/Animation;
    if-eqz v9, :cond_c0

    .line 463
    invoke-virtual {v4, v7, v8}, Landroid/view/animation/Animation;->setDuration(J)V

    .line 465
    :cond_c0
    if-eqz v11, :cond_c5

    .line 466
    invoke-virtual {v4, v10}, Landroid/view/animation/Animation;->setFillAfter(Z)V

    .line 468
    :cond_c5
    if-eqz v13, :cond_ca

    .line 469
    invoke-virtual {v4, v12}, Landroid/view/animation/Animation;->setFillBefore(Z)V

    .line 471
    :cond_ca
    if-eqz v19, :cond_d1

    .line 472
    move/from16 v0, v18

    invoke-virtual {v4, v0}, Landroid/view/animation/Animation;->setRepeatMode(I)V

    .line 474
    :cond_d1
    if-eqz v20, :cond_d6

    .line 475
    invoke-virtual {v4, v15}, Landroid/view/animation/Animation;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 477
    :cond_d6
    if-eqz v23, :cond_e5

    .line 478
    invoke-virtual {v4}, Landroid/view/animation/Animation;->getStartOffset()J

    move-result-wide v16

    .line 479
    .local v16, offset:J
    add-long v25, v16, v21

    move-wide/from16 v0, v25

    invoke-virtual {v4, v0, v1}, Landroid/view/animation/Animation;->setStartOffset(J)V

    .line 480
    aput-wide v16, v24, v14

    .line 482
    .end local v16           #offset:J
    :cond_e5
    move/from16 v0, p1

    move/from16 v1, p2

    move/from16 v2, p3

    move/from16 v3, p4

    invoke-virtual {v4, v0, v1, v2, v3}, Landroid/view/animation/Animation;->initialize(IIII)V

    .line 460
    add-int/lit8 v14, v14, 0x1

    goto :goto_b3

    .line 427
    .end local v4           #a:Landroid/view/animation/Animation;
    .end local v5           #children:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/animation/Animation;>;"
    .end local v6           #count:I
    .end local v7           #duration:J
    .end local v9           #durationSet:Z
    .end local v10           #fillAfter:Z
    .end local v11           #fillAfterSet:Z
    .end local v12           #fillBefore:Z
    .end local v13           #fillBeforeSet:Z
    .end local v14           #i:I
    .end local v15           #interpolator:Landroid/view/animation/Interpolator;
    .end local v18           #repeatMode:I
    .end local v19           #repeatModeSet:Z
    .end local v20           #shareInterpolator:Z
    .end local v21           #startOffset:J
    .end local v23           #startOffsetSet:Z
    .end local v24           #storedOffsets:[J
    :cond_f3
    const/4 v9, 0x0

    goto/16 :goto_14

    .line 428
    .restart local v9       #durationSet:Z
    :cond_f6
    const/4 v11, 0x0

    goto/16 :goto_25

    .line 429
    .restart local v11       #fillAfterSet:Z
    :cond_f9
    const/4 v13, 0x0

    goto/16 :goto_36

    .line 430
    .restart local v13       #fillBeforeSet:Z
    :cond_fc
    const/16 v19, 0x0

    goto/16 :goto_48

    .line 431
    .restart local v19       #repeatModeSet:Z
    :cond_100
    const/16 v20, 0x0

    goto/16 :goto_5a

    .line 433
    .restart local v20       #shareInterpolator:Z
    :cond_104
    const/16 v23, 0x0

    goto/16 :goto_6c

    .line 456
    .restart local v5       #children:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/animation/Animation;>;"
    .restart local v6       #count:I
    .restart local v7       #duration:J
    .restart local v10       #fillAfter:Z
    .restart local v12       #fillBefore:Z
    .restart local v15       #interpolator:Landroid/view/animation/Interpolator;
    .restart local v18       #repeatMode:I
    .restart local v21       #startOffset:J
    .restart local v23       #startOffsetSet:Z
    .restart local v24       #storedOffsets:[J
    :cond_108
    if-eqz v24, :cond_b2

    .line 457
    const/16 v24, 0x0

    move-object/from16 v0, v24

    move-object/from16 v1, p0

    iput-object v0, v1, Landroid/view/animation/AnimationSet;->mStoredOffsets:[J

    goto :goto_b2

    .line 484
    .restart local v14       #i:I
    :cond_113
    return-void
.end method

.method public initializeInvalidateRegion(IIII)V
    .registers 18
    .parameter "left"
    .parameter "top"
    .parameter "right"
    .parameter "bottom"

    .prologue
    .line 338
    iget-object v7, p0, Landroid/view/animation/Animation;->mPreviousRegion:Landroid/graphics/RectF;

    .line 339
    .local v7, region:Landroid/graphics/RectF;
    int-to-float v9, p1

    int-to-float v10, p2

    move/from16 v0, p3

    int-to-float v11, v0

    move/from16 v0, p4

    int-to-float v12, v0

    invoke-virtual {v7, v9, v10, v11, v12}, Landroid/graphics/RectF;->set(FFFF)V

    .line 340
    const/high16 v9, -0x4080

    const/high16 v10, -0x4080

    invoke-virtual {v7, v9, v10}, Landroid/graphics/RectF;->inset(FF)V

    .line 342
    iget-boolean v9, p0, Landroid/view/animation/Animation;->mFillBefore:Z

    if-eqz v9, :cond_5b

    .line 343
    iget-object v9, p0, Landroid/view/animation/AnimationSet;->mAnimations:Ljava/util/ArrayList;

    invoke-virtual {v9}, Ljava/util/ArrayList;->size()I

    move-result v3

    .line 344
    .local v3, count:I
    iget-object v2, p0, Landroid/view/animation/AnimationSet;->mAnimations:Ljava/util/ArrayList;

    .line 345
    .local v2, animations:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/animation/Animation;>;"
    iget-object v8, p0, Landroid/view/animation/AnimationSet;->mTempTransformation:Landroid/view/animation/Transformation;

    .line 347
    .local v8, temp:Landroid/view/animation/Transformation;
    iget-object v6, p0, Landroid/view/animation/Animation;->mPreviousTransformation:Landroid/view/animation/Transformation;

    .line 349
    .local v6, previousTransformation:Landroid/view/animation/Transformation;
    add-int/lit8 v4, v3, -0x1

    .local v4, i:I
    :goto_26
    if-ltz v4, :cond_5b

    .line 350
    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/animation/Animation;

    .line 351
    .local v1, a:Landroid/view/animation/Animation;
    invoke-virtual {v1}, Landroid/view/animation/Animation;->isFillEnabled()Z

    move-result v9

    if-eqz v9, :cond_44

    invoke-virtual {v1}, Landroid/view/animation/Animation;->getFillBefore()Z

    move-result v9

    if-nez v9, :cond_44

    invoke-virtual {v1}, Landroid/view/animation/Animation;->getStartOffset()J

    move-result-wide v9

    const-wide/16 v11, 0x0

    cmp-long v9, v9, v11

    if-nez v9, :cond_56

    .line 352
    :cond_44
    invoke-virtual {v8}, Landroid/view/animation/Transformation;->clear()V

    .line 353
    iget-object v5, v1, Landroid/view/animation/Animation;->mInterpolator:Landroid/view/animation/Interpolator;

    .line 354
    .local v5, interpolator:Landroid/view/animation/Interpolator;
    if-eqz v5, :cond_59

    const/4 v9, 0x0

    invoke-interface {v5, v9}, Landroid/view/animation/Interpolator;->getInterpolation(F)F

    move-result v9

    :goto_50
    invoke-virtual {v1, v9, v8}, Landroid/view/animation/Animation;->applyTransformation(FLandroid/view/animation/Transformation;)V

    .line 356
    invoke-virtual {v6, v8}, Landroid/view/animation/Transformation;->compose(Landroid/view/animation/Transformation;)V

    .line 349
    .end local v5           #interpolator:Landroid/view/animation/Interpolator;
    :cond_56
    add-int/lit8 v4, v4, -0x1

    goto :goto_26

    .line 354
    .restart local v5       #interpolator:Landroid/view/animation/Interpolator;
    :cond_59
    const/4 v9, 0x0

    goto :goto_50

    .line 360
    .end local v1           #a:Landroid/view/animation/Animation;
    .end local v2           #animations:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/animation/Animation;>;"
    .end local v3           #count:I
    .end local v4           #i:I
    .end local v5           #interpolator:Landroid/view/animation/Interpolator;
    .end local v6           #previousTransformation:Landroid/view/animation/Transformation;
    .end local v8           #temp:Landroid/view/animation/Transformation;
    :cond_5b
    return-void
.end method

.method public reset()V
    .registers 1

    .prologue
    .line 488
    invoke-super {p0}, Landroid/view/animation/Animation;->reset()V

    .line 489
    invoke-virtual {p0}, Landroid/view/animation/AnimationSet;->restoreChildrenStartOffset()V

    .line 490
    return-void
.end method

.method restoreChildrenStartOffset()V
    .registers 8

    .prologue
    .line 496
    iget-object v3, p0, Landroid/view/animation/AnimationSet;->mStoredOffsets:[J

    .line 497
    .local v3, offsets:[J
    if-nez v3, :cond_5

    .line 505
    :cond_4
    return-void

    .line 499
    :cond_5
    iget-object v0, p0, Landroid/view/animation/AnimationSet;->mAnimations:Ljava/util/ArrayList;

    .line 500
    .local v0, children:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/animation/Animation;>;"
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v1

    .line 502
    .local v1, count:I
    const/4 v2, 0x0

    .local v2, i:I
    :goto_c
    if-ge v2, v1, :cond_4

    .line 503
    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/view/animation/Animation;

    aget-wide v5, v3, v2

    invoke-virtual {v4, v5, v6}, Landroid/view/animation/Animation;->setStartOffset(J)V

    .line 502
    add-int/lit8 v2, v2, 0x1

    goto :goto_c
.end method

.method public restrictDuration(J)V
    .registers 7
    .parameter "durationMillis"

    .prologue
    .line 283
    invoke-super {p0, p1, p2}, Landroid/view/animation/Animation;->restrictDuration(J)V

    .line 285
    iget-object v0, p0, Landroid/view/animation/AnimationSet;->mAnimations:Ljava/util/ArrayList;

    .line 286
    .local v0, animations:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/animation/Animation;>;"
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v1

    .line 288
    .local v1, count:I
    const/4 v2, 0x0

    .local v2, i:I
    :goto_a
    if-ge v2, v1, :cond_18

    .line 289
    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/view/animation/Animation;

    invoke-virtual {v3, p1, p2}, Landroid/view/animation/Animation;->restrictDuration(J)V

    .line 288
    add-int/lit8 v2, v2, 0x1

    goto :goto_a

    .line 291
    :cond_18
    return-void
.end method

.method public scaleCurrentDuration(F)V
    .registers 6
    .parameter "scale"

    .prologue
    .line 413
    iget-object v0, p0, Landroid/view/animation/AnimationSet;->mAnimations:Ljava/util/ArrayList;

    .line 414
    .local v0, animations:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/animation/Animation;>;"
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v1

    .line 415
    .local v1, count:I
    const/4 v2, 0x0

    .local v2, i:I
    :goto_7
    if-ge v2, v1, :cond_15

    .line 416
    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/view/animation/Animation;

    invoke-virtual {v3, p1}, Landroid/view/animation/Animation;->scaleCurrentDuration(F)V

    .line 415
    add-int/lit8 v2, v2, 0x1

    goto :goto_7

    .line 418
    :cond_15
    return-void
.end method

.method public setDuration(J)V
    .registers 7
    .parameter "durationMillis"

    .prologue
    .line 207
    iget v0, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    or-int/lit8 v0, v0, 0x20

    iput v0, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    .line 208
    invoke-super {p0, p1, p2}, Landroid/view/animation/Animation;->setDuration(J)V

    .line 209
    iget-wide v0, p0, Landroid/view/animation/Animation;->mStartOffset:J

    iget-wide v2, p0, Landroid/view/animation/Animation;->mDuration:J

    add-long/2addr v0, v2

    iput-wide v0, p0, Landroid/view/animation/AnimationSet;->mLastEnd:J

    .line 210
    return-void
.end method

.method public setFillAfter(Z)V
    .registers 3
    .parameter "fillAfter"

    .prologue
    .line 155
    iget v0, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    or-int/lit8 v0, v0, 0x1

    iput v0, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    .line 156
    invoke-super {p0, p1}, Landroid/view/animation/Animation;->setFillAfter(Z)V

    .line 157
    return-void
.end method

.method public setFillBefore(Z)V
    .registers 3
    .parameter "fillBefore"

    .prologue
    .line 161
    iget v0, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    or-int/lit8 v0, v0, 0x2

    iput v0, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    .line 162
    invoke-super {p0, p1}, Landroid/view/animation/Animation;->setFillBefore(Z)V

    .line 163
    return-void
.end method

.method public setRepeatMode(I)V
    .registers 3
    .parameter "repeatMode"

    .prologue
    .line 167
    iget v0, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    or-int/lit8 v0, v0, 0x4

    iput v0, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    .line 168
    invoke-super {p0, p1}, Landroid/view/animation/Animation;->setRepeatMode(I)V

    .line 169
    return-void
.end method

.method public setStartOffset(J)V
    .registers 4
    .parameter "startOffset"

    .prologue
    .line 173
    iget v0, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    or-int/lit8 v0, v0, 0x8

    iput v0, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    .line 174
    invoke-super {p0, p1, p2}, Landroid/view/animation/Animation;->setStartOffset(J)V

    .line 175
    return-void
.end method

.method public setStartTime(J)V
    .registers 8
    .parameter "startTimeMillis"

    .prologue
    .line 255
    invoke-super {p0, p1, p2}, Landroid/view/animation/Animation;->setStartTime(J)V

    .line 257
    iget-object v4, p0, Landroid/view/animation/AnimationSet;->mAnimations:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v2

    .line 258
    .local v2, count:I
    iget-object v1, p0, Landroid/view/animation/AnimationSet;->mAnimations:Ljava/util/ArrayList;

    .line 260
    .local v1, animations:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/animation/Animation;>;"
    const/4 v3, 0x0

    .local v3, i:I
    :goto_c
    if-ge v3, v2, :cond_1a

    .line 261
    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/animation/Animation;

    .line 262
    .local v0, a:Landroid/view/animation/Animation;
    invoke-virtual {v0, p1, p2}, Landroid/view/animation/Animation;->setStartTime(J)V

    .line 260
    add-int/lit8 v3, v3, 0x1

    goto :goto_c

    .line 264
    .end local v0           #a:Landroid/view/animation/Animation;
    :cond_1a
    return-void
.end method

.method public willChangeBounds()Z
    .registers 3

    .prologue
    .line 522
    iget v0, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    and-int/lit16 v0, v0, 0x80

    const/16 v1, 0x80

    if-ne v0, v1, :cond_a

    const/4 v0, 0x1

    :goto_9
    return v0

    :cond_a
    const/4 v0, 0x0

    goto :goto_9
.end method

.method public willChangeTransformationMatrix()Z
    .registers 3

    .prologue
    .line 517
    iget v0, p0, Landroid/view/animation/AnimationSet;->mFlags:I

    and-int/lit8 v0, v0, 0x40

    const/16 v1, 0x40

    if-ne v0, v1, :cond_a

    const/4 v0, 0x1

    :goto_9
    return v0

    :cond_a
    const/4 v0, 0x0

    goto :goto_9
.end method
