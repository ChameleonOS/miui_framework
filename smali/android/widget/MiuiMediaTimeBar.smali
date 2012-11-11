.class public Landroid/widget/MiuiMediaTimeBar;
.super Landroid/view/View;
.source "MiuiMediaTimeBar.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/widget/MiuiMediaTimeBar$ScrubbingListener;
    }
.end annotation


# static fields
.field private static final SCRUBBER_PADDING_IN_DP:I = 0xa

.field private static final TEXT_SIZE_IN_DP:I = 0xe

.field private static final V_PADDING_IN_DP:I = 0x1e


# instance fields
.field private currentTime:I

.field private final listener:Landroid/widget/MiuiMediaTimeBar$ScrubbingListener;

.field private final playedBar:Landroid/graphics/Rect;

.field private final playedPaint:Landroid/graphics/Paint;

.field private final progressBar:Landroid/graphics/Rect;

.field private final progressPaint:Landroid/graphics/Paint;

.field private final scrubber:Landroid/graphics/Bitmap;

.field private scrubberCorrection:I

.field private scrubberLeft:I

.field private final scrubberPadding:I

.field private scrubberTop:I

.field private scrubbing:Z

.field private showScrubber:Z

.field private showTimes:Z

.field private final timeBounds:Landroid/graphics/Rect;

.field private final timeTextPaint:Landroid/graphics/Paint;

.field private totalTime:I

.field private vPaddingInPx:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/widget/MiuiMediaTimeBar$ScrubbingListener;)V
    .registers 10
    .parameter "context"
    .parameter "listener"

    .prologue
    const/4 v4, 0x1

    invoke-direct {p0, p1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    if-nez p2, :cond_c

    new-instance v2, Ljava/lang/NullPointerException;

    invoke-direct {v2}, Ljava/lang/NullPointerException;-><init>()V

    throw v2

    :cond_c
    iput-object p2, p0, Landroid/widget/MiuiMediaTimeBar;->listener:Landroid/widget/MiuiMediaTimeBar$ScrubbingListener;

    iput-boolean v4, p0, Landroid/widget/MiuiMediaTimeBar;->showTimes:Z

    iput-boolean v4, p0, Landroid/widget/MiuiMediaTimeBar;->showScrubber:Z

    new-instance v2, Landroid/graphics/Rect;

    invoke-direct {v2}, Landroid/graphics/Rect;-><init>()V

    iput-object v2, p0, Landroid/widget/MiuiMediaTimeBar;->progressBar:Landroid/graphics/Rect;

    new-instance v2, Landroid/graphics/Rect;

    invoke-direct {v2}, Landroid/graphics/Rect;-><init>()V

    iput-object v2, p0, Landroid/widget/MiuiMediaTimeBar;->playedBar:Landroid/graphics/Rect;

    new-instance v2, Landroid/graphics/Paint;

    invoke-direct {v2}, Landroid/graphics/Paint;-><init>()V

    iput-object v2, p0, Landroid/widget/MiuiMediaTimeBar;->progressPaint:Landroid/graphics/Paint;

    iget-object v2, p0, Landroid/widget/MiuiMediaTimeBar;->progressPaint:Landroid/graphics/Paint;

    const v3, -0x7f7f80

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    new-instance v2, Landroid/graphics/Paint;

    invoke-direct {v2}, Landroid/graphics/Paint;-><init>()V

    iput-object v2, p0, Landroid/widget/MiuiMediaTimeBar;->playedPaint:Landroid/graphics/Paint;

    iget-object v2, p0, Landroid/widget/MiuiMediaTimeBar;->playedPaint:Landroid/graphics/Paint;

    const/4 v3, -0x1

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    .local v0, metrics:Landroid/util/DisplayMetrics;
    iget v2, v0, Landroid/util/DisplayMetrics;->density:F

    const/high16 v3, 0x4160

    mul-float v1, v2, v3

    .local v1, textSizeInPx:F
    new-instance v2, Landroid/graphics/Paint;

    invoke-direct {v2, v4}, Landroid/graphics/Paint;-><init>(I)V

    iput-object v2, p0, Landroid/widget/MiuiMediaTimeBar;->timeTextPaint:Landroid/graphics/Paint;

    iget-object v2, p0, Landroid/widget/MiuiMediaTimeBar;->timeTextPaint:Landroid/graphics/Paint;

    const v3, -0x313132

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    iget-object v2, p0, Landroid/widget/MiuiMediaTimeBar;->timeTextPaint:Landroid/graphics/Paint;

    invoke-virtual {v2, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    iget-object v2, p0, Landroid/widget/MiuiMediaTimeBar;->timeTextPaint:Landroid/graphics/Paint;

    sget-object v3, Landroid/graphics/Paint$Align;->CENTER:Landroid/graphics/Paint$Align;

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    new-instance v2, Landroid/graphics/Rect;

    invoke-direct {v2}, Landroid/graphics/Rect;-><init>()V

    iput-object v2, p0, Landroid/widget/MiuiMediaTimeBar;->timeBounds:Landroid/graphics/Rect;

    iget-object v2, p0, Landroid/widget/MiuiMediaTimeBar;->timeTextPaint:Landroid/graphics/Paint;

    const-string v3, "0:00:00"

    const/4 v4, 0x0

    const/4 v5, 0x7

    iget-object v6, p0, Landroid/widget/MiuiMediaTimeBar;->timeBounds:Landroid/graphics/Rect;

    invoke-virtual {v2, v3, v4, v5, v6}, Landroid/graphics/Paint;->getTextBounds(Ljava/lang/String;IILandroid/graphics/Rect;)V

    invoke-virtual {p0}, Landroid/widget/MiuiMediaTimeBar;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x602004e

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v2

    iput-object v2, p0, Landroid/widget/MiuiMediaTimeBar;->scrubber:Landroid/graphics/Bitmap;

    iget v2, v0, Landroid/util/DisplayMetrics;->density:F

    const/high16 v3, 0x4120

    mul-float/2addr v2, v3

    float-to-int v2, v2

    iput v2, p0, Landroid/widget/MiuiMediaTimeBar;->scrubberPadding:I

    iget v2, v0, Landroid/util/DisplayMetrics;->density:F

    const/high16 v3, 0x41f0

    mul-float/2addr v2, v3

    float-to-int v2, v2

    iput v2, p0, Landroid/widget/MiuiMediaTimeBar;->vPaddingInPx:I

    return-void
.end method

.method private clampScrubber()V
    .registers 5

    .prologue
    iget-object v3, p0, Landroid/widget/MiuiMediaTimeBar;->scrubber:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    div-int/lit8 v0, v3, 0x2

    .local v0, half:I
    iget-object v3, p0, Landroid/widget/MiuiMediaTimeBar;->progressBar:Landroid/graphics/Rect;

    iget v3, v3, Landroid/graphics/Rect;->right:I

    sub-int v1, v3, v0

    .local v1, max:I
    iget-object v3, p0, Landroid/widget/MiuiMediaTimeBar;->progressBar:Landroid/graphics/Rect;

    iget v3, v3, Landroid/graphics/Rect;->left:I

    sub-int v2, v3, v0

    .local v2, min:I
    iget v3, p0, Landroid/widget/MiuiMediaTimeBar;->scrubberLeft:I

    invoke-static {v2, v3}, Ljava/lang/Math;->max(II)I

    move-result v3

    invoke-static {v1, v3}, Ljava/lang/Math;->min(II)I

    move-result v3

    iput v3, p0, Landroid/widget/MiuiMediaTimeBar;->scrubberLeft:I

    return-void
.end method

.method private getScrubberTime()I
    .registers 5

    .prologue
    iget v0, p0, Landroid/widget/MiuiMediaTimeBar;->scrubberLeft:I

    iget-object v1, p0, Landroid/widget/MiuiMediaTimeBar;->scrubber:Landroid/graphics/Bitmap;

    invoke-virtual {v1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    add-int/2addr v0, v1

    iget-object v1, p0, Landroid/widget/MiuiMediaTimeBar;->progressBar:Landroid/graphics/Rect;

    iget v1, v1, Landroid/graphics/Rect;->left:I

    sub-int/2addr v0, v1

    int-to-long v0, v0

    iget v2, p0, Landroid/widget/MiuiMediaTimeBar;->totalTime:I

    int-to-long v2, v2

    mul-long/2addr v0, v2

    iget-object v2, p0, Landroid/widget/MiuiMediaTimeBar;->progressBar:Landroid/graphics/Rect;

    invoke-virtual {v2}, Landroid/graphics/Rect;->width()I

    move-result v2

    int-to-long v2, v2

    div-long/2addr v0, v2

    long-to-int v0, v0

    return v0
.end method

.method private inScrubber(FF)Z
    .registers 7
    .parameter "x"
    .parameter "y"

    .prologue
    iget v2, p0, Landroid/widget/MiuiMediaTimeBar;->scrubberLeft:I

    iget-object v3, p0, Landroid/widget/MiuiMediaTimeBar;->scrubber:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    add-int v1, v2, v3

    .local v1, scrubberRight:I
    iget v2, p0, Landroid/widget/MiuiMediaTimeBar;->scrubberTop:I

    iget-object v3, p0, Landroid/widget/MiuiMediaTimeBar;->scrubber:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v3

    add-int v0, v2, v3

    .local v0, scrubberBottom:I
    iget v2, p0, Landroid/widget/MiuiMediaTimeBar;->scrubberLeft:I

    iget v3, p0, Landroid/widget/MiuiMediaTimeBar;->scrubberPadding:I

    sub-int/2addr v2, v3

    int-to-float v2, v2

    cmpg-float v2, v2, p1

    if-gez v2, :cond_3a

    iget v2, p0, Landroid/widget/MiuiMediaTimeBar;->scrubberPadding:I

    add-int/2addr v2, v1

    int-to-float v2, v2

    cmpg-float v2, p1, v2

    if-gez v2, :cond_3a

    iget v2, p0, Landroid/widget/MiuiMediaTimeBar;->scrubberTop:I

    iget v3, p0, Landroid/widget/MiuiMediaTimeBar;->scrubberPadding:I

    sub-int/2addr v2, v3

    int-to-float v2, v2

    cmpg-float v2, v2, p2

    if-gez v2, :cond_3a

    iget v2, p0, Landroid/widget/MiuiMediaTimeBar;->scrubberPadding:I

    add-int/2addr v2, v0

    int-to-float v2, v2

    cmpg-float v2, p2, v2

    if-gez v2, :cond_3a

    const/4 v2, 0x1

    :goto_39
    return v2

    :cond_3a
    const/4 v2, 0x0

    goto :goto_39
.end method

.method private stringForTime(J)Ljava/lang/String;
    .registers 13
    .parameter "millis"

    .prologue
    const/4 v9, 0x2

    const/4 v8, 0x1

    const/4 v7, 0x0

    long-to-int v4, p1

    div-int/lit16 v3, v4, 0x3e8

    .local v3, totalSeconds:I
    rem-int/lit8 v2, v3, 0x3c

    .local v2, seconds:I
    div-int/lit8 v4, v3, 0x3c

    rem-int/lit8 v1, v4, 0x3c

    .local v1, minutes:I
    div-int/lit16 v0, v3, 0xe10

    .local v0, hours:I
    if-lez v0, :cond_30

    const-string v4, "%d:%02d:%02d"

    const/4 v5, 0x3

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v7

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v8

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v9

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v4

    :goto_2f
    return-object v4

    :cond_30
    const-string v4, "%02d:%02d"

    new-array v5, v9, [Ljava/lang/Object;

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v7

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v8

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v4

    goto :goto_2f
.end method

.method private update()V
    .registers 7

    .prologue
    iget-object v0, p0, Landroid/widget/MiuiMediaTimeBar;->playedBar:Landroid/graphics/Rect;

    iget-object v1, p0, Landroid/widget/MiuiMediaTimeBar;->progressBar:Landroid/graphics/Rect;

    invoke-virtual {v0, v1}, Landroid/graphics/Rect;->set(Landroid/graphics/Rect;)V

    iget v0, p0, Landroid/widget/MiuiMediaTimeBar;->totalTime:I

    if-lez v0, :cond_3b

    iget-object v0, p0, Landroid/widget/MiuiMediaTimeBar;->playedBar:Landroid/graphics/Rect;

    iget-object v1, p0, Landroid/widget/MiuiMediaTimeBar;->playedBar:Landroid/graphics/Rect;

    iget v1, v1, Landroid/graphics/Rect;->left:I

    iget-object v2, p0, Landroid/widget/MiuiMediaTimeBar;->progressBar:Landroid/graphics/Rect;

    invoke-virtual {v2}, Landroid/graphics/Rect;->width()I

    move-result v2

    int-to-long v2, v2

    iget v4, p0, Landroid/widget/MiuiMediaTimeBar;->currentTime:I

    int-to-long v4, v4

    mul-long/2addr v2, v4

    iget v4, p0, Landroid/widget/MiuiMediaTimeBar;->totalTime:I

    int-to-long v4, v4

    div-long/2addr v2, v4

    long-to-int v2, v2

    add-int/2addr v1, v2

    iput v1, v0, Landroid/graphics/Rect;->right:I

    :goto_24
    iget-boolean v0, p0, Landroid/widget/MiuiMediaTimeBar;->scrubbing:Z

    if-nez v0, :cond_37

    iget-object v0, p0, Landroid/widget/MiuiMediaTimeBar;->playedBar:Landroid/graphics/Rect;

    iget v0, v0, Landroid/graphics/Rect;->right:I

    iget-object v1, p0, Landroid/widget/MiuiMediaTimeBar;->scrubber:Landroid/graphics/Bitmap;

    invoke-virtual {v1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    sub-int/2addr v0, v1

    iput v0, p0, Landroid/widget/MiuiMediaTimeBar;->scrubberLeft:I

    :cond_37
    invoke-virtual {p0}, Landroid/widget/MiuiMediaTimeBar;->invalidate()V

    return-void

    :cond_3b
    iget-object v0, p0, Landroid/widget/MiuiMediaTimeBar;->playedBar:Landroid/graphics/Rect;

    iget-object v1, p0, Landroid/widget/MiuiMediaTimeBar;->progressBar:Landroid/graphics/Rect;

    iget v1, v1, Landroid/graphics/Rect;->left:I

    iput v1, v0, Landroid/graphics/Rect;->right:I

    goto :goto_24
.end method


# virtual methods
.method public draw(Landroid/graphics/Canvas;)V
    .registers 6
    .parameter "canvas"

    .prologue
    invoke-super {p0, p1}, Landroid/view/View;->draw(Landroid/graphics/Canvas;)V

    iget-object v0, p0, Landroid/widget/MiuiMediaTimeBar;->progressBar:Landroid/graphics/Rect;

    iget-object v1, p0, Landroid/widget/MiuiMediaTimeBar;->progressPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    iget-object v0, p0, Landroid/widget/MiuiMediaTimeBar;->playedBar:Landroid/graphics/Rect;

    iget-object v1, p0, Landroid/widget/MiuiMediaTimeBar;->playedPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    iget-boolean v0, p0, Landroid/widget/MiuiMediaTimeBar;->showScrubber:Z

    if-eqz v0, :cond_21

    iget-object v0, p0, Landroid/widget/MiuiMediaTimeBar;->scrubber:Landroid/graphics/Bitmap;

    iget v1, p0, Landroid/widget/MiuiMediaTimeBar;->scrubberLeft:I

    int-to-float v1, v1

    iget v2, p0, Landroid/widget/MiuiMediaTimeBar;->scrubberTop:I

    int-to-float v2, v2

    const/4 v3, 0x0

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    :cond_21
    iget-boolean v0, p0, Landroid/widget/MiuiMediaTimeBar;->showTimes:Z

    if-eqz v0, :cond_80

    iget v0, p0, Landroid/widget/MiuiMediaTimeBar;->currentTime:I

    int-to-long v0, v0

    invoke-direct {p0, v0, v1}, Landroid/widget/MiuiMediaTimeBar;->stringForTime(J)Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Landroid/widget/MiuiMediaTimeBar;->timeBounds:Landroid/graphics/Rect;

    invoke-virtual {v1}, Landroid/graphics/Rect;->width()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    invoke-virtual {p0}, Landroid/widget/MiuiMediaTimeBar;->getPaddingLeft()I

    move-result v2

    add-int/2addr v1, v2

    int-to-float v1, v1

    iget-object v2, p0, Landroid/widget/MiuiMediaTimeBar;->timeBounds:Landroid/graphics/Rect;

    invoke-virtual {v2}, Landroid/graphics/Rect;->height()I

    move-result v2

    iget v3, p0, Landroid/widget/MiuiMediaTimeBar;->vPaddingInPx:I

    div-int/lit8 v3, v3, 0x2

    add-int/2addr v2, v3

    iget v3, p0, Landroid/widget/MiuiMediaTimeBar;->scrubberPadding:I

    add-int/2addr v2, v3

    add-int/lit8 v2, v2, 0x1

    int-to-float v2, v2

    iget-object v3, p0, Landroid/widget/MiuiMediaTimeBar;->timeTextPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    iget v0, p0, Landroid/widget/MiuiMediaTimeBar;->totalTime:I

    int-to-long v0, v0

    invoke-direct {p0, v0, v1}, Landroid/widget/MiuiMediaTimeBar;->stringForTime(J)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Landroid/widget/MiuiMediaTimeBar;->getWidth()I

    move-result v1

    invoke-virtual {p0}, Landroid/widget/MiuiMediaTimeBar;->getPaddingRight()I

    move-result v2

    sub-int/2addr v1, v2

    iget-object v2, p0, Landroid/widget/MiuiMediaTimeBar;->timeBounds:Landroid/graphics/Rect;

    invoke-virtual {v2}, Landroid/graphics/Rect;->width()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    sub-int/2addr v1, v2

    int-to-float v1, v1

    iget-object v2, p0, Landroid/widget/MiuiMediaTimeBar;->timeBounds:Landroid/graphics/Rect;

    invoke-virtual {v2}, Landroid/graphics/Rect;->height()I

    move-result v2

    iget v3, p0, Landroid/widget/MiuiMediaTimeBar;->vPaddingInPx:I

    div-int/lit8 v3, v3, 0x2

    add-int/2addr v2, v3

    iget v3, p0, Landroid/widget/MiuiMediaTimeBar;->scrubberPadding:I

    add-int/2addr v2, v3

    add-int/lit8 v2, v2, 0x1

    int-to-float v2, v2

    iget-object v3, p0, Landroid/widget/MiuiMediaTimeBar;->timeTextPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    :cond_80
    return-void
.end method

.method public getBarHeight()I
    .registers 3

    .prologue
    iget-object v0, p0, Landroid/widget/MiuiMediaTimeBar;->timeBounds:Landroid/graphics/Rect;

    invoke-virtual {v0}, Landroid/graphics/Rect;->height()I

    move-result v0

    iget v1, p0, Landroid/widget/MiuiMediaTimeBar;->vPaddingInPx:I

    add-int/2addr v0, v1

    return v0
.end method

.method public getPreferredHeight()I
    .registers 3

    .prologue
    iget-object v0, p0, Landroid/widget/MiuiMediaTimeBar;->timeBounds:Landroid/graphics/Rect;

    invoke-virtual {v0}, Landroid/graphics/Rect;->height()I

    move-result v0

    iget v1, p0, Landroid/widget/MiuiMediaTimeBar;->vPaddingInPx:I

    add-int/2addr v0, v1

    iget v1, p0, Landroid/widget/MiuiMediaTimeBar;->scrubberPadding:I

    add-int/2addr v0, v1

    return v0
.end method

.method protected onLayout(ZIIII)V
    .registers 14
    .parameter "changed"
    .parameter "l"
    .parameter "t"
    .parameter "r"
    .parameter "b"

    .prologue
    const/4 v5, 0x0

    sub-int v3, p4, p2

    .local v3, w:I
    sub-int v0, p5, p3

    .local v0, h:I
    iget-boolean v4, p0, Landroid/widget/MiuiMediaTimeBar;->showTimes:Z

    if-nez v4, :cond_16

    iget-boolean v4, p0, Landroid/widget/MiuiMediaTimeBar;->showScrubber:Z

    if-nez v4, :cond_16

    iget-object v4, p0, Landroid/widget/MiuiMediaTimeBar;->progressBar:Landroid/graphics/Rect;

    invoke-virtual {v4, v5, v5, v3, v0}, Landroid/graphics/Rect;->set(IIII)V

    :goto_12
    invoke-direct {p0}, Landroid/widget/MiuiMediaTimeBar;->update()V

    return-void

    :cond_16
    iget-object v4, p0, Landroid/widget/MiuiMediaTimeBar;->scrubber:Landroid/graphics/Bitmap;

    invoke-virtual {v4}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v4

    div-int/lit8 v1, v4, 0x3

    .local v1, margin:I
    iget-boolean v4, p0, Landroid/widget/MiuiMediaTimeBar;->showTimes:Z

    if-eqz v4, :cond_29

    iget-object v4, p0, Landroid/widget/MiuiMediaTimeBar;->timeBounds:Landroid/graphics/Rect;

    invoke-virtual {v4}, Landroid/graphics/Rect;->width()I

    move-result v4

    add-int/2addr v1, v4

    :cond_29
    iget v4, p0, Landroid/widget/MiuiMediaTimeBar;->scrubberPadding:I

    add-int/2addr v4, v0

    div-int/lit8 v2, v4, 0x2

    .local v2, progressY:I
    iget-object v4, p0, Landroid/widget/MiuiMediaTimeBar;->scrubber:Landroid/graphics/Bitmap;

    invoke-virtual {v4}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v4

    div-int/lit8 v4, v4, 0x2

    sub-int v4, v2, v4

    add-int/lit8 v4, v4, 0x1

    iput v4, p0, Landroid/widget/MiuiMediaTimeBar;->scrubberTop:I

    iget-object v4, p0, Landroid/widget/MiuiMediaTimeBar;->progressBar:Landroid/graphics/Rect;

    invoke-virtual {p0}, Landroid/widget/MiuiMediaTimeBar;->getPaddingLeft()I

    move-result v5

    add-int/2addr v5, v1

    invoke-virtual {p0}, Landroid/widget/MiuiMediaTimeBar;->getPaddingRight()I

    move-result v6

    sub-int v6, v3, v6

    sub-int/2addr v6, v1

    add-int/lit8 v7, v2, 0x4

    invoke-virtual {v4, v5, v2, v6, v7}, Landroid/graphics/Rect;->set(IIII)V

    goto :goto_12
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .registers 8
    .parameter "event"

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    iget-boolean v4, p0, Landroid/widget/MiuiMediaTimeBar;->showScrubber:Z

    if-eqz v4, :cond_17

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v4

    float-to-int v0, v4

    .local v0, x:I
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v4

    float-to-int v1, v4

    .local v1, y:I
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v4

    packed-switch v4, :pswitch_data_5e

    .end local v0           #x:I
    .end local v1           #y:I
    :cond_17
    move v2, v3

    :goto_18
    return v2

    .restart local v0       #x:I
    .restart local v1       #y:I
    :pswitch_19
    int-to-float v4, v0

    int-to-float v5, v1

    invoke-direct {p0, v4, v5}, Landroid/widget/MiuiMediaTimeBar;->inScrubber(FF)Z

    move-result v4

    if-eqz v4, :cond_17

    iput-boolean v2, p0, Landroid/widget/MiuiMediaTimeBar;->scrubbing:Z

    iget v3, p0, Landroid/widget/MiuiMediaTimeBar;->scrubberLeft:I

    sub-int v3, v0, v3

    iput v3, p0, Landroid/widget/MiuiMediaTimeBar;->scrubberCorrection:I

    iget-object v3, p0, Landroid/widget/MiuiMediaTimeBar;->listener:Landroid/widget/MiuiMediaTimeBar$ScrubbingListener;

    invoke-interface {v3}, Landroid/widget/MiuiMediaTimeBar$ScrubbingListener;->onScrubbingStart()V

    goto :goto_18

    :pswitch_2f
    iget-boolean v4, p0, Landroid/widget/MiuiMediaTimeBar;->scrubbing:Z

    if-eqz v4, :cond_17

    iget v3, p0, Landroid/widget/MiuiMediaTimeBar;->scrubberCorrection:I

    sub-int v3, v0, v3

    iput v3, p0, Landroid/widget/MiuiMediaTimeBar;->scrubberLeft:I

    invoke-direct {p0}, Landroid/widget/MiuiMediaTimeBar;->clampScrubber()V

    invoke-direct {p0}, Landroid/widget/MiuiMediaTimeBar;->getScrubberTime()I

    move-result v3

    iput v3, p0, Landroid/widget/MiuiMediaTimeBar;->currentTime:I

    iget-object v3, p0, Landroid/widget/MiuiMediaTimeBar;->listener:Landroid/widget/MiuiMediaTimeBar$ScrubbingListener;

    iget v4, p0, Landroid/widget/MiuiMediaTimeBar;->currentTime:I

    invoke-interface {v3, v4}, Landroid/widget/MiuiMediaTimeBar$ScrubbingListener;->onScrubbingMove(I)V

    invoke-virtual {p0}, Landroid/widget/MiuiMediaTimeBar;->invalidate()V

    goto :goto_18

    :pswitch_4d
    iget-boolean v4, p0, Landroid/widget/MiuiMediaTimeBar;->scrubbing:Z

    if-eqz v4, :cond_17

    iget-object v4, p0, Landroid/widget/MiuiMediaTimeBar;->listener:Landroid/widget/MiuiMediaTimeBar$ScrubbingListener;

    invoke-direct {p0}, Landroid/widget/MiuiMediaTimeBar;->getScrubberTime()I

    move-result v5

    invoke-interface {v4, v5}, Landroid/widget/MiuiMediaTimeBar$ScrubbingListener;->onScrubbingEnd(I)V

    iput-boolean v3, p0, Landroid/widget/MiuiMediaTimeBar;->scrubbing:Z

    goto :goto_18

    nop

    :pswitch_data_5e
    .packed-switch 0x0
        :pswitch_19
        :pswitch_4d
        :pswitch_2f
    .end packed-switch
.end method

.method public resetTime()V
    .registers 2

    .prologue
    const/4 v0, 0x0

    invoke-virtual {p0, v0, v0}, Landroid/widget/MiuiMediaTimeBar;->setTime(II)V

    return-void
.end method

.method public setShowScrubber(Z)V
    .registers 4
    .parameter "showScrubber"

    .prologue
    iput-boolean p1, p0, Landroid/widget/MiuiMediaTimeBar;->showScrubber:Z

    if-nez p1, :cond_14

    iget-boolean v0, p0, Landroid/widget/MiuiMediaTimeBar;->scrubbing:Z

    if-eqz v0, :cond_14

    iget-object v0, p0, Landroid/widget/MiuiMediaTimeBar;->listener:Landroid/widget/MiuiMediaTimeBar$ScrubbingListener;

    invoke-direct {p0}, Landroid/widget/MiuiMediaTimeBar;->getScrubberTime()I

    move-result v1

    invoke-interface {v0, v1}, Landroid/widget/MiuiMediaTimeBar$ScrubbingListener;->onScrubbingEnd(I)V

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/widget/MiuiMediaTimeBar;->scrubbing:Z

    :cond_14
    invoke-virtual {p0}, Landroid/widget/MiuiMediaTimeBar;->requestLayout()V

    return-void
.end method

.method public setShowTimes(Z)V
    .registers 2
    .parameter "showTimes"

    .prologue
    iput-boolean p1, p0, Landroid/widget/MiuiMediaTimeBar;->showTimes:Z

    invoke-virtual {p0}, Landroid/widget/MiuiMediaTimeBar;->requestLayout()V

    return-void
.end method

.method public setTime(II)V
    .registers 4
    .parameter "currentTime"
    .parameter "totalTime"

    .prologue
    iget v0, p0, Landroid/widget/MiuiMediaTimeBar;->currentTime:I

    if-ne v0, p1, :cond_9

    iget v0, p0, Landroid/widget/MiuiMediaTimeBar;->totalTime:I

    if-ne v0, p2, :cond_9

    :goto_8
    return-void

    :cond_9
    iput p1, p0, Landroid/widget/MiuiMediaTimeBar;->currentTime:I

    iput p2, p0, Landroid/widget/MiuiMediaTimeBar;->totalTime:I

    invoke-direct {p0}, Landroid/widget/MiuiMediaTimeBar;->update()V

    goto :goto_8
.end method
