.class public Lmiui/widget/SlidingButton;
.super Landroid/widget/CheckBox;
.source "SlidingButton.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lmiui/widget/SlidingButton$1;,
        Lmiui/widget/SlidingButton$SlidingHandler;,
        Lmiui/widget/SlidingButton$OnCheckedChangedListener;
    }
.end annotation


# static fields
.field private static final ANIMATION_FRAME_DURATION:I = 0x10

.field private static final MAXIMUM_MINOR_VELOCITY:F = 150.0f

.field private static final MSG_ANIMATE:I = 0x3e8

.field private static final TAP_THRESHOLD:I = 0x6


# instance fields
.field private mActiveSlider:Landroid/graphics/drawable/BitmapDrawable;

.field private mAlphaPixels:[I

.field private mAnimatedVelocity:F

.field private mAnimating:Z

.field private mAnimationLastTime:J

.field private mAnimationPosition:F

.field private mBarBitmap:Landroid/graphics/Bitmap;

.field private mBarSlice:[I

.field private mCurrentAnimationTime:J

.field private mFrame:Landroid/graphics/drawable/BitmapDrawable;

.field private final mHandler:Landroid/os/Handler;

.field private mHeight:I

.field private mLastX:I

.field private mOffDisable:Landroid/graphics/drawable/BitmapDrawable;

.field private mOnCheckedChangedListener:Lmiui/widget/SlidingButton$OnCheckedChangedListener;

.field private mOnDisable:Landroid/graphics/drawable/BitmapDrawable;

.field private mOriginalTouchPointX:I

.field private mPressedSlider:Landroid/graphics/drawable/BitmapDrawable;

.field private mSlider:Landroid/graphics/drawable/BitmapDrawable;

.field private mSliderMoved:Z

.field private mSliderOffset:I

.field private mSliderPosition:I

.field private mSliderWidth:I

.field private mTapThreshold:I

.field private mTracking:Z

.field private mWidth:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 3
    .parameter "context"

    .prologue
    .line 73
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lmiui/widget/SlidingButton;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 74
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 4
    .parameter "context"
    .parameter "attrs"

    .prologue
    .line 82
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lmiui/widget/SlidingButton;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 83
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .registers 6
    .parameter "context"
    .parameter "attrs"
    .parameter "defStyle"

    .prologue
    const/4 v1, 0x0

    .line 77
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/CheckBox;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 47
    const/4 v0, 0x0

    iput-boolean v0, p0, Lmiui/widget/SlidingButton;->mAnimating:Z

    .line 54
    new-instance v0, Lmiui/widget/SlidingButton$SlidingHandler;

    invoke-direct {v0, p0, v1}, Lmiui/widget/SlidingButton$SlidingHandler;-><init>(Lmiui/widget/SlidingButton;Lmiui/widget/SlidingButton$1;)V

    iput-object v0, p0, Lmiui/widget/SlidingButton;->mHandler:Landroid/os/Handler;

    .line 59
    const/high16 v0, 0x4316

    iput v0, p0, Lmiui/widget/SlidingButton;->mAnimatedVelocity:F

    .line 66
    iput-object v1, p0, Lmiui/widget/SlidingButton;->mOnCheckedChangedListener:Lmiui/widget/SlidingButton$OnCheckedChangedListener;

    .line 78
    invoke-direct {p0, p1, p2, p3}, Lmiui/widget/SlidingButton;->initialize(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 79
    return-void
.end method

.method static synthetic access$100(Lmiui/widget/SlidingButton;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 27
    invoke-direct {p0}, Lmiui/widget/SlidingButton;->doAnimation()V

    return-void
.end method

.method private animateOff()V
    .registers 2

    .prologue
    .line 244
    const/high16 v0, -0x3cea

    invoke-direct {p0, v0}, Lmiui/widget/SlidingButton;->performFling(F)V

    .line 245
    invoke-virtual {p0}, Lmiui/widget/SlidingButton;->invalidate()V

    .line 246
    return-void
.end method

.method private animateOn()V
    .registers 2

    .prologue
    .line 239
    const/high16 v0, 0x4316

    invoke-direct {p0, v0}, Lmiui/widget/SlidingButton;->performFling(F)V

    .line 240
    invoke-virtual {p0}, Lmiui/widget/SlidingButton;->invalidate()V

    .line 241
    return-void
.end method

.method private animateToggle()V
    .registers 2

    .prologue
    .line 231
    invoke-virtual {p0}, Lmiui/widget/SlidingButton;->isChecked()Z

    move-result v0

    if-eqz v0, :cond_a

    .line 232
    invoke-direct {p0}, Lmiui/widget/SlidingButton;->animateOff()V

    .line 236
    :goto_9
    return-void

    .line 234
    :cond_a
    invoke-direct {p0}, Lmiui/widget/SlidingButton;->animateOn()V

    goto :goto_9
.end method

.method private createBarBitmap(Landroid/graphics/drawable/BitmapDrawable;)V
    .registers 6
    .parameter "drawable"

    .prologue
    .line 91
    if-eqz p1, :cond_16

    .line 92
    invoke-virtual {p1}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    iget v1, p0, Lmiui/widget/SlidingButton;->mWidth:I

    mul-int/lit8 v1, v1, 0x2

    iget v2, p0, Lmiui/widget/SlidingButton;->mSliderWidth:I

    sub-int/2addr v1, v2

    iget v2, p0, Lmiui/widget/SlidingButton;->mHeight:I

    const/4 v3, 0x1

    invoke-static {v0, v1, v2, v3}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lmiui/widget/SlidingButton;->mBarBitmap:Landroid/graphics/Bitmap;

    .line 98
    :cond_16
    return-void
.end method

.method private cutEdge(II[I)V
    .registers 10
    .parameter "baseWidth"
    .parameter "baseHeight"
    .parameter "basePixels"

    .prologue
    .line 329
    const v2, 0xffffff

    .line 330
    .local v2, sRGBMask:I
    const/16 v1, 0x18

    .line 332
    .local v1, sAlphaShift:I
    mul-int v3, p1, p2

    add-int/lit8 v0, v3, -0x1

    .local v0, i:I
    :goto_9
    if-ltz v0, :cond_20

    .line 333
    aget v3, p3, v0

    aget v4, p3, v0

    ushr-int/2addr v4, v1

    iget-object v5, p0, Lmiui/widget/SlidingButton;->mAlphaPixels:[I

    aget v5, v5, v0

    ushr-int/2addr v5, v1

    mul-int/2addr v4, v5

    div-int/lit16 v4, v4, 0xff

    shl-int/2addr v4, v1

    add-int/2addr v4, v2

    and-int/2addr v3, v4

    aput v3, p3, v0

    .line 332
    add-int/lit8 v0, v0, -0x1

    goto :goto_9

    .line 337
    :cond_20
    return-void
.end method

.method private doAnimation()V
    .registers 6

    .prologue
    const/16 v4, 0x3e8

    const/4 v0, 0x0

    .line 271
    iget-boolean v1, p0, Lmiui/widget/SlidingButton;->mAnimating:Z

    if-nez v1, :cond_8

    .line 287
    :cond_7
    :goto_7
    return-void

    .line 274
    :cond_8
    invoke-direct {p0}, Lmiui/widget/SlidingButton;->incrementAnimation()V

    .line 275
    iget v1, p0, Lmiui/widget/SlidingButton;->mAnimationPosition:F

    float-to-int v1, v1

    invoke-direct {p0, v1}, Lmiui/widget/SlidingButton;->moveSlider(I)V

    .line 276
    iget v1, p0, Lmiui/widget/SlidingButton;->mSliderOffset:I

    if-lez v1, :cond_1b

    iget v1, p0, Lmiui/widget/SlidingButton;->mSliderOffset:I

    iget v2, p0, Lmiui/widget/SlidingButton;->mSliderPosition:I

    if-lt v1, v2, :cond_3a

    .line 277
    :cond_1b
    iget-object v1, p0, Lmiui/widget/SlidingButton;->mHandler:Landroid/os/Handler;

    invoke-virtual {v1, v4}, Landroid/os/Handler;->removeMessages(I)V

    .line 278
    iput-boolean v0, p0, Lmiui/widget/SlidingButton;->mAnimating:Z

    .line 279
    iget v1, p0, Lmiui/widget/SlidingButton;->mSliderOffset:I

    iget v2, p0, Lmiui/widget/SlidingButton;->mSliderPosition:I

    if-lt v1, v2, :cond_29

    const/4 v0, 0x1

    :cond_29
    invoke-virtual {p0, v0}, Lmiui/widget/SlidingButton;->setChecked(Z)V

    .line 280
    iget-object v0, p0, Lmiui/widget/SlidingButton;->mOnCheckedChangedListener:Lmiui/widget/SlidingButton$OnCheckedChangedListener;

    if-eqz v0, :cond_7

    .line 281
    iget-object v0, p0, Lmiui/widget/SlidingButton;->mOnCheckedChangedListener:Lmiui/widget/SlidingButton$OnCheckedChangedListener;

    invoke-virtual {p0}, Lmiui/widget/SlidingButton;->isChecked()Z

    move-result v1

    invoke-interface {v0, v1}, Lmiui/widget/SlidingButton$OnCheckedChangedListener;->onCheckedChanged(Z)V

    goto :goto_7

    .line 284
    :cond_3a
    iget-wide v0, p0, Lmiui/widget/SlidingButton;->mCurrentAnimationTime:J

    const-wide/16 v2, 0x10

    add-long/2addr v0, v2

    iput-wide v0, p0, Lmiui/widget/SlidingButton;->mCurrentAnimationTime:J

    .line 285
    iget-object v0, p0, Lmiui/widget/SlidingButton;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lmiui/widget/SlidingButton;->mHandler:Landroid/os/Handler;

    invoke-virtual {v1, v4}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v1

    iget-wide v2, p0, Lmiui/widget/SlidingButton;->mCurrentAnimationTime:J

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->sendMessageAtTime(Landroid/os/Message;J)Z

    goto :goto_7
.end method

.method private drawSlidingBar(Landroid/graphics/Canvas;)V
    .registers 17
    .parameter "canvas"

    .prologue
    .line 319
    iget v0, p0, Lmiui/widget/SlidingButton;->mSliderPosition:I

    iget v1, p0, Lmiui/widget/SlidingButton;->mSliderOffset:I

    sub-int v4, v0, v1

    .line 320
    .local v4, barOffset:I
    iget-object v0, p0, Lmiui/widget/SlidingButton;->mBarBitmap:Landroid/graphics/Bitmap;

    iget-object v1, p0, Lmiui/widget/SlidingButton;->mBarSlice:[I

    const/4 v2, 0x0

    iget v3, p0, Lmiui/widget/SlidingButton;->mWidth:I

    const/4 v5, 0x0

    iget v6, p0, Lmiui/widget/SlidingButton;->mWidth:I

    iget v7, p0, Lmiui/widget/SlidingButton;->mHeight:I

    invoke-virtual/range {v0 .. v7}, Landroid/graphics/Bitmap;->getPixels([IIIIIII)V

    .line 323
    iget v0, p0, Lmiui/widget/SlidingButton;->mWidth:I

    iget v1, p0, Lmiui/widget/SlidingButton;->mHeight:I

    iget-object v2, p0, Lmiui/widget/SlidingButton;->mBarSlice:[I

    invoke-direct {p0, v0, v1, v2}, Lmiui/widget/SlidingButton;->cutEdge(II[I)V

    .line 324
    iget-object v6, p0, Lmiui/widget/SlidingButton;->mBarSlice:[I

    const/4 v7, 0x0

    iget v8, p0, Lmiui/widget/SlidingButton;->mWidth:I

    const/4 v9, 0x0

    const/4 v10, 0x0

    iget v11, p0, Lmiui/widget/SlidingButton;->mWidth:I

    iget v12, p0, Lmiui/widget/SlidingButton;->mHeight:I

    const/4 v13, 0x1

    const/4 v14, 0x0

    move-object/from16 v5, p1

    invoke-virtual/range {v5 .. v14}, Landroid/graphics/Canvas;->drawBitmap([IIIIIIIZLandroid/graphics/Paint;)V

    .line 325
    return-void
.end method

.method private incrementAnimation()V
    .registers 7

    .prologue
    .line 290
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    .line 291
    .local v0, now:J
    iget-wide v4, p0, Lmiui/widget/SlidingButton;->mAnimationLastTime:J

    sub-long v4, v0, v4

    long-to-float v4, v4

    const/high16 v5, 0x447a

    div-float v3, v4, v5

    .line 292
    .local v3, t:F
    iget v2, p0, Lmiui/widget/SlidingButton;->mAnimationPosition:F

    .line 293
    .local v2, position:F
    iget v4, p0, Lmiui/widget/SlidingButton;->mAnimatedVelocity:F

    mul-float/2addr v4, v3

    add-float/2addr v4, v2

    iput v4, p0, Lmiui/widget/SlidingButton;->mAnimationPosition:F

    .line 294
    iput-wide v0, p0, Lmiui/widget/SlidingButton;->mAnimationLastTime:J

    .line 295
    return-void
.end method

.method private initialize(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .registers 15
    .parameter "context"
    .parameter "attrs"
    .parameter "defStyle"

    .prologue
    const/4 v2, 0x0

    .line 100
    sget-object v1, Lcom/miui/internal/R$styleable;->SlidingButton:[I

    const v3, 0x60d0027

    invoke-virtual {p1, p2, v1, p3, v3}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v8

    .line 104
    .local v8, a:Landroid/content/res/TypedArray;
    invoke-virtual {p0, v2}, Lmiui/widget/SlidingButton;->setDrawingCacheEnabled(Z)V

    .line 105
    invoke-virtual {p0}, Lmiui/widget/SlidingButton;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget v9, v1, Landroid/util/DisplayMetrics;->density:F

    .line 106
    .local v9, density:F
    const/high16 v1, 0x40c0

    mul-float/2addr v1, v9

    const/high16 v3, 0x3f00

    add-float/2addr v1, v3

    float-to-int v1, v1

    iput v1, p0, Lmiui/widget/SlidingButton;->mTapThreshold:I

    .line 108
    invoke-virtual {v8, v2}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    check-cast v1, Landroid/graphics/drawable/BitmapDrawable;

    iput-object v1, p0, Lmiui/widget/SlidingButton;->mFrame:Landroid/graphics/drawable/BitmapDrawable;

    .line 109
    const/4 v1, 0x1

    invoke-virtual {v8, v1}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    check-cast v1, Landroid/graphics/drawable/BitmapDrawable;

    iput-object v1, p0, Lmiui/widget/SlidingButton;->mSlider:Landroid/graphics/drawable/BitmapDrawable;

    .line 110
    const/4 v1, 0x2

    invoke-virtual {v8, v1}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    check-cast v1, Landroid/graphics/drawable/BitmapDrawable;

    iput-object v1, p0, Lmiui/widget/SlidingButton;->mPressedSlider:Landroid/graphics/drawable/BitmapDrawable;

    .line 111
    const/4 v1, 0x3

    invoke-virtual {v8, v1}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    check-cast v1, Landroid/graphics/drawable/BitmapDrawable;

    iput-object v1, p0, Lmiui/widget/SlidingButton;->mOnDisable:Landroid/graphics/drawable/BitmapDrawable;

    .line 112
    const/4 v1, 0x4

    invoke-virtual {v8, v1}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    check-cast v1, Landroid/graphics/drawable/BitmapDrawable;

    iput-object v1, p0, Lmiui/widget/SlidingButton;->mOffDisable:Landroid/graphics/drawable/BitmapDrawable;

    .line 114
    iget-object v1, p0, Lmiui/widget/SlidingButton;->mFrame:Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v1}, Landroid/graphics/drawable/BitmapDrawable;->getIntrinsicWidth()I

    move-result v1

    iput v1, p0, Lmiui/widget/SlidingButton;->mWidth:I

    .line 115
    iget-object v1, p0, Lmiui/widget/SlidingButton;->mFrame:Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v1}, Landroid/graphics/drawable/BitmapDrawable;->getIntrinsicHeight()I

    move-result v1

    iput v1, p0, Lmiui/widget/SlidingButton;->mHeight:I

    .line 117
    iget-object v1, p0, Lmiui/widget/SlidingButton;->mSlider:Landroid/graphics/drawable/BitmapDrawable;

    iput-object v1, p0, Lmiui/widget/SlidingButton;->mActiveSlider:Landroid/graphics/drawable/BitmapDrawable;

    .line 118
    iget v1, p0, Lmiui/widget/SlidingButton;->mWidth:I

    iget-object v3, p0, Lmiui/widget/SlidingButton;->mSlider:Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v3}, Landroid/graphics/drawable/BitmapDrawable;->getIntrinsicWidth()I

    move-result v3

    invoke-static {v1, v3}, Ljava/lang/Math;->min(II)I

    move-result v1

    iput v1, p0, Lmiui/widget/SlidingButton;->mSliderWidth:I

    .line 119
    iget v1, p0, Lmiui/widget/SlidingButton;->mWidth:I

    iget v3, p0, Lmiui/widget/SlidingButton;->mSliderWidth:I

    sub-int/2addr v1, v3

    iput v1, p0, Lmiui/widget/SlidingButton;->mSliderPosition:I

    .line 121
    iget-object v1, p0, Lmiui/widget/SlidingButton;->mFrame:Landroid/graphics/drawable/BitmapDrawable;

    iget v3, p0, Lmiui/widget/SlidingButton;->mWidth:I

    iget v4, p0, Lmiui/widget/SlidingButton;->mHeight:I

    invoke-virtual {v1, v2, v2, v3, v4}, Landroid/graphics/drawable/BitmapDrawable;->setBounds(IIII)V

    .line 122
    iget-object v1, p0, Lmiui/widget/SlidingButton;->mOnDisable:Landroid/graphics/drawable/BitmapDrawable;

    iget v3, p0, Lmiui/widget/SlidingButton;->mWidth:I

    iget v4, p0, Lmiui/widget/SlidingButton;->mHeight:I

    invoke-virtual {v1, v2, v2, v3, v4}, Landroid/graphics/drawable/BitmapDrawable;->setBounds(IIII)V

    .line 123
    iget-object v1, p0, Lmiui/widget/SlidingButton;->mOffDisable:Landroid/graphics/drawable/BitmapDrawable;

    iget v3, p0, Lmiui/widget/SlidingButton;->mWidth:I

    iget v4, p0, Lmiui/widget/SlidingButton;->mHeight:I

    invoke-virtual {v1, v2, v2, v3, v4}, Landroid/graphics/drawable/BitmapDrawable;->setBounds(IIII)V

    .line 126
    iget v1, p0, Lmiui/widget/SlidingButton;->mWidth:I

    iget v3, p0, Lmiui/widget/SlidingButton;->mHeight:I

    mul-int/2addr v1, v3

    new-array v1, v1, [I

    iput-object v1, p0, Lmiui/widget/SlidingButton;->mAlphaPixels:[I

    .line 127
    const/4 v1, 0x5

    invoke-virtual {v8, v1}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    check-cast v1, Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v1}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v10

    .line 128
    .local v10, source:Landroid/graphics/Bitmap;
    iget v1, p0, Lmiui/widget/SlidingButton;->mWidth:I

    iget v3, p0, Lmiui/widget/SlidingButton;->mHeight:I

    invoke-static {v10, v1, v3, v2}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 133
    .local v0, alphaCutter:Landroid/graphics/Bitmap;
    iget-object v1, p0, Lmiui/widget/SlidingButton;->mAlphaPixels:[I

    iget v3, p0, Lmiui/widget/SlidingButton;->mWidth:I

    iget v6, p0, Lmiui/widget/SlidingButton;->mWidth:I

    iget v7, p0, Lmiui/widget/SlidingButton;->mHeight:I

    move v4, v2

    move v5, v2

    invoke-virtual/range {v0 .. v7}, Landroid/graphics/Bitmap;->getPixels([IIIIIII)V

    .line 134
    if-eq v0, v10, :cond_be

    .line 135
    invoke-virtual {v0}, Landroid/graphics/Bitmap;->recycle()V

    .line 139
    :cond_be
    iget v1, p0, Lmiui/widget/SlidingButton;->mWidth:I

    iget v2, p0, Lmiui/widget/SlidingButton;->mHeight:I

    mul-int/2addr v1, v2

    new-array v1, v1, [I

    iput-object v1, p0, Lmiui/widget/SlidingButton;->mBarSlice:[I

    .line 140
    const/4 v1, 0x6

    invoke-virtual {v8, v1}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    check-cast v1, Landroid/graphics/drawable/BitmapDrawable;

    invoke-direct {p0, v1}, Lmiui/widget/SlidingButton;->createBarBitmap(Landroid/graphics/drawable/BitmapDrawable;)V

    .line 141
    invoke-virtual {v8}, Landroid/content/res/TypedArray;->recycle()V

    .line 142
    return-void
.end method

.method private moveSlider(I)V
    .registers 4
    .parameter "offsetX"

    .prologue
    .line 250
    iget v0, p0, Lmiui/widget/SlidingButton;->mSliderOffset:I

    add-int/2addr v0, p1

    iput v0, p0, Lmiui/widget/SlidingButton;->mSliderOffset:I

    .line 251
    iget v0, p0, Lmiui/widget/SlidingButton;->mSliderOffset:I

    if-gez v0, :cond_10

    .line 252
    const/4 v0, 0x0

    iput v0, p0, Lmiui/widget/SlidingButton;->mSliderOffset:I

    .line 256
    :cond_c
    :goto_c
    invoke-virtual {p0}, Lmiui/widget/SlidingButton;->invalidate()V

    .line 257
    return-void

    .line 253
    :cond_10
    iget v0, p0, Lmiui/widget/SlidingButton;->mSliderOffset:I

    iget v1, p0, Lmiui/widget/SlidingButton;->mSliderPosition:I

    if-le v0, v1, :cond_c

    .line 254
    iget v0, p0, Lmiui/widget/SlidingButton;->mSliderPosition:I

    iput v0, p0, Lmiui/widget/SlidingButton;->mSliderOffset:I

    goto :goto_c
.end method

.method private performFling(F)V
    .registers 8
    .parameter "velocity"

    .prologue
    const/16 v4, 0x3e8

    .line 260
    const/4 v2, 0x1

    iput-boolean v2, p0, Lmiui/widget/SlidingButton;->mAnimating:Z

    .line 261
    const/4 v2, 0x0

    iput v2, p0, Lmiui/widget/SlidingButton;->mAnimationPosition:F

    .line 262
    iput p1, p0, Lmiui/widget/SlidingButton;->mAnimatedVelocity:F

    .line 263
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    .line 264
    .local v0, now:J
    iput-wide v0, p0, Lmiui/widget/SlidingButton;->mAnimationLastTime:J

    .line 265
    const-wide/16 v2, 0x10

    add-long/2addr v2, v0

    iput-wide v2, p0, Lmiui/widget/SlidingButton;->mCurrentAnimationTime:J

    .line 266
    iget-object v2, p0, Lmiui/widget/SlidingButton;->mHandler:Landroid/os/Handler;

    invoke-virtual {v2, v4}, Landroid/os/Handler;->removeMessages(I)V

    .line 267
    iget-object v2, p0, Lmiui/widget/SlidingButton;->mHandler:Landroid/os/Handler;

    iget-object v3, p0, Lmiui/widget/SlidingButton;->mHandler:Landroid/os/Handler;

    invoke-virtual {v3, v4}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v3

    iget-wide v4, p0, Lmiui/widget/SlidingButton;->mCurrentAnimationTime:J

    invoke-virtual {v2, v3, v4, v5}, Landroid/os/Handler;->sendMessageAtTime(Landroid/os/Message;J)Z

    .line 268
    return-void
.end method


# virtual methods
.method protected onDraw(Landroid/graphics/Canvas;)V
    .registers 7
    .parameter "canvas"

    .prologue
    .line 299
    invoke-super {p0, p1}, Landroid/widget/CheckBox;->onDraw(Landroid/graphics/Canvas;)V

    .line 301
    invoke-virtual {p0}, Lmiui/widget/SlidingButton;->isEnabled()Z

    move-result v0

    if-nez v0, :cond_1b

    .line 302
    invoke-virtual {p0}, Lmiui/widget/SlidingButton;->isChecked()Z

    move-result v0

    if-eqz v0, :cond_15

    .line 303
    iget-object v0, p0, Lmiui/widget/SlidingButton;->mOnDisable:Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/BitmapDrawable;->draw(Landroid/graphics/Canvas;)V

    .line 315
    :goto_14
    return-void

    .line 305
    :cond_15
    iget-object v0, p0, Lmiui/widget/SlidingButton;->mOffDisable:Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/BitmapDrawable;->draw(Landroid/graphics/Canvas;)V

    goto :goto_14

    .line 308
    :cond_1b
    invoke-direct {p0, p1}, Lmiui/widget/SlidingButton;->drawSlidingBar(Landroid/graphics/Canvas;)V

    .line 310
    iget-object v0, p0, Lmiui/widget/SlidingButton;->mFrame:Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/BitmapDrawable;->draw(Landroid/graphics/Canvas;)V

    .line 312
    iget-object v0, p0, Lmiui/widget/SlidingButton;->mActiveSlider:Landroid/graphics/drawable/BitmapDrawable;

    iget v1, p0, Lmiui/widget/SlidingButton;->mSliderOffset:I

    const/4 v2, 0x0

    iget v3, p0, Lmiui/widget/SlidingButton;->mSliderWidth:I

    iget v4, p0, Lmiui/widget/SlidingButton;->mSliderOffset:I

    add-int/2addr v3, v4

    iget v4, p0, Lmiui/widget/SlidingButton;->mHeight:I

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/drawable/BitmapDrawable;->setBounds(IIII)V

    .line 313
    iget-object v0, p0, Lmiui/widget/SlidingButton;->mActiveSlider:Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/BitmapDrawable;->draw(Landroid/graphics/Canvas;)V

    goto :goto_14
.end method

.method protected onMeasure(II)V
    .registers 5
    .parameter "widthMeasureSpec"
    .parameter "heightMeasureSpec"

    .prologue
    .line 164
    iget v0, p0, Lmiui/widget/SlidingButton;->mWidth:I

    iget v1, p0, Lmiui/widget/SlidingButton;->mHeight:I

    invoke-virtual {p0, v0, v1}, Lmiui/widget/SlidingButton;->setMeasuredDimension(II)V

    .line 165
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .registers 11
    .parameter "event"

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 170
    invoke-virtual {p0}, Lmiui/widget/SlidingButton;->isEnabled()Z

    move-result v6

    if-nez v6, :cond_9

    .line 227
    :goto_8
    return v4

    .line 173
    :cond_9
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    .line 174
    .local v0, action:I
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v6

    float-to-int v2, v6

    .line 175
    .local v2, x:I
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v6

    float-to-int v3, v6

    .line 176
    .local v3, y:I
    new-instance v1, Landroid/graphics/Rect;

    iget v6, p0, Lmiui/widget/SlidingButton;->mSliderOffset:I

    iget v7, p0, Lmiui/widget/SlidingButton;->mSliderOffset:I

    iget v8, p0, Lmiui/widget/SlidingButton;->mSliderWidth:I

    add-int/2addr v7, v8

    iget v8, p0, Lmiui/widget/SlidingButton;->mHeight:I

    invoke-direct {v1, v6, v4, v7, v8}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 178
    .local v1, sliderFrame:Landroid/graphics/Rect;
    packed-switch v0, :pswitch_data_94

    :cond_28
    :goto_28
    move v4, v5

    .line 227
    goto :goto_8

    .line 180
    :pswitch_2a
    invoke-virtual {v1, v2, v3}, Landroid/graphics/Rect;->contains(II)Z

    move-result v6

    if-eqz v6, :cond_40

    .line 181
    iput-boolean v5, p0, Lmiui/widget/SlidingButton;->mTracking:Z

    .line 182
    iget-object v6, p0, Lmiui/widget/SlidingButton;->mPressedSlider:Landroid/graphics/drawable/BitmapDrawable;

    iput-object v6, p0, Lmiui/widget/SlidingButton;->mActiveSlider:Landroid/graphics/drawable/BitmapDrawable;

    .line 183
    invoke-virtual {p0}, Lmiui/widget/SlidingButton;->invalidate()V

    .line 187
    :goto_39
    iput v2, p0, Lmiui/widget/SlidingButton;->mLastX:I

    .line 188
    iput v2, p0, Lmiui/widget/SlidingButton;->mOriginalTouchPointX:I

    .line 189
    iput-boolean v4, p0, Lmiui/widget/SlidingButton;->mSliderMoved:Z

    goto :goto_28

    .line 185
    :cond_40
    iput-boolean v4, p0, Lmiui/widget/SlidingButton;->mTracking:Z

    goto :goto_39

    .line 193
    :pswitch_43
    iget-boolean v4, p0, Lmiui/widget/SlidingButton;->mTracking:Z

    if-eqz v4, :cond_28

    .line 194
    iget v4, p0, Lmiui/widget/SlidingButton;->mLastX:I

    sub-int v4, v2, v4

    invoke-direct {p0, v4}, Lmiui/widget/SlidingButton;->moveSlider(I)V

    .line 195
    iput v2, p0, Lmiui/widget/SlidingButton;->mLastX:I

    .line 196
    iget v4, p0, Lmiui/widget/SlidingButton;->mOriginalTouchPointX:I

    sub-int v4, v2, v4

    invoke-static {v4}, Ljava/lang/Math;->abs(I)I

    move-result v4

    iget v6, p0, Lmiui/widget/SlidingButton;->mTapThreshold:I

    if-lt v4, v6, :cond_28

    .line 197
    iput-boolean v5, p0, Lmiui/widget/SlidingButton;->mSliderMoved:Z

    .line 198
    invoke-virtual {p0}, Lmiui/widget/SlidingButton;->getParent()Landroid/view/ViewParent;

    move-result-object v4

    invoke-interface {v4, v5}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    goto :goto_28

    .line 204
    :pswitch_66
    iget-boolean v6, p0, Lmiui/widget/SlidingButton;->mTracking:Z

    if-eqz v6, :cond_8a

    .line 205
    iget-boolean v6, p0, Lmiui/widget/SlidingButton;->mSliderMoved:Z

    if-nez v6, :cond_76

    .line 206
    invoke-direct {p0}, Lmiui/widget/SlidingButton;->animateToggle()V

    .line 217
    :goto_71
    iput-boolean v4, p0, Lmiui/widget/SlidingButton;->mTracking:Z

    .line 218
    iput-boolean v4, p0, Lmiui/widget/SlidingButton;->mSliderMoved:Z

    goto :goto_28

    .line 208
    :cond_76
    iget v6, p0, Lmiui/widget/SlidingButton;->mSliderOffset:I

    if-ltz v6, :cond_86

    iget v6, p0, Lmiui/widget/SlidingButton;->mSliderOffset:I

    iget v7, p0, Lmiui/widget/SlidingButton;->mSliderPosition:I

    div-int/lit8 v7, v7, 0x2

    if-gt v6, v7, :cond_86

    .line 209
    invoke-direct {p0}, Lmiui/widget/SlidingButton;->animateOff()V

    goto :goto_71

    .line 211
    :cond_86
    invoke-direct {p0}, Lmiui/widget/SlidingButton;->animateOn()V

    goto :goto_71

    .line 215
    :cond_8a
    invoke-direct {p0}, Lmiui/widget/SlidingButton;->animateToggle()V

    goto :goto_71

    .line 222
    :pswitch_8e
    iput-boolean v4, p0, Lmiui/widget/SlidingButton;->mTracking:Z

    .line 223
    iput-boolean v4, p0, Lmiui/widget/SlidingButton;->mSliderMoved:Z

    goto :goto_28

    .line 178
    nop

    :pswitch_data_94
    .packed-switch 0x0
        :pswitch_2a
        :pswitch_66
        :pswitch_43
        :pswitch_8e
    .end packed-switch
.end method

.method public setBarImageResource(I)V
    .registers 4
    .parameter "resId"

    .prologue
    .line 86
    iget-object v1, p0, Landroid/view/View;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, p1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    check-cast v0, Landroid/graphics/drawable/BitmapDrawable;

    .line 87
    .local v0, drawable:Landroid/graphics/drawable/BitmapDrawable;
    invoke-direct {p0, v0}, Lmiui/widget/SlidingButton;->createBarBitmap(Landroid/graphics/drawable/BitmapDrawable;)V

    .line 88
    return-void
.end method

.method public setButtonDrawable(Landroid/graphics/drawable/Drawable;)V
    .registers 2
    .parameter "d"

    .prologue
    .line 159
    return-void
.end method

.method public setChecked(Z)V
    .registers 4
    .parameter "checked"

    .prologue
    .line 146
    invoke-super {p0, p1}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 147
    if-eqz p1, :cond_14

    .line 148
    iget v0, p0, Lmiui/widget/SlidingButton;->mWidth:I

    iget v1, p0, Lmiui/widget/SlidingButton;->mSliderWidth:I

    sub-int/2addr v0, v1

    iput v0, p0, Lmiui/widget/SlidingButton;->mSliderOffset:I

    .line 152
    :goto_c
    iget-object v0, p0, Lmiui/widget/SlidingButton;->mSlider:Landroid/graphics/drawable/BitmapDrawable;

    iput-object v0, p0, Lmiui/widget/SlidingButton;->mActiveSlider:Landroid/graphics/drawable/BitmapDrawable;

    .line 153
    invoke-virtual {p0}, Lmiui/widget/SlidingButton;->invalidate()V

    .line 154
    return-void

    .line 150
    :cond_14
    const/4 v0, 0x0

    iput v0, p0, Lmiui/widget/SlidingButton;->mSliderOffset:I

    goto :goto_c
.end method

.method public setOnCheckedChangedListener(Lmiui/widget/SlidingButton$OnCheckedChangedListener;)V
    .registers 2
    .parameter "listener"

    .prologue
    .line 69
    iput-object p1, p0, Lmiui/widget/SlidingButton;->mOnCheckedChangedListener:Lmiui/widget/SlidingButton$OnCheckedChangedListener;

    .line 70
    return-void
.end method
