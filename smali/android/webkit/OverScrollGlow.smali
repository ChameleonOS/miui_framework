.class public Landroid/webkit/OverScrollGlow;
.super Ljava/lang/Object;
.source "OverScrollGlow.java"


# instance fields
.field private mEdgeGlowBottom:Landroid/widget/EdgeEffect;

.field private mEdgeGlowLeft:Landroid/widget/EdgeEffect;

.field private mEdgeGlowRight:Landroid/widget/EdgeEffect;

.field private mEdgeGlowTop:Landroid/widget/EdgeEffect;

.field private mHostView:Landroid/webkit/WebViewClassic;

.field private mOverScrollDeltaX:I

.field private mOverScrollDeltaY:I


# direct methods
.method public constructor <init>(Landroid/webkit/WebViewClassic;)V
    .registers 4
    .parameter "host"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroid/webkit/OverScrollGlow;->mHostView:Landroid/webkit/WebViewClassic;

    invoke-virtual {p1}, Landroid/webkit/WebViewClassic;->getContext()Landroid/content/Context;

    move-result-object v0

    .local v0, context:Landroid/content/Context;
    new-instance v1, Landroid/widget/EdgeEffect;

    invoke-direct {v1, v0}, Landroid/widget/EdgeEffect;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowTop:Landroid/widget/EdgeEffect;

    new-instance v1, Landroid/widget/EdgeEffect;

    invoke-direct {v1, v0}, Landroid/widget/EdgeEffect;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowBottom:Landroid/widget/EdgeEffect;

    new-instance v1, Landroid/widget/EdgeEffect;

    invoke-direct {v1, v0}, Landroid/widget/EdgeEffect;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowLeft:Landroid/widget/EdgeEffect;

    new-instance v1, Landroid/widget/EdgeEffect;

    invoke-direct {v1, v0}, Landroid/widget/EdgeEffect;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowRight:Landroid/widget/EdgeEffect;

    return-void
.end method


# virtual methods
.method public absorbGlow(IIIIII)V
    .registers 9
    .parameter "x"
    .parameter "y"
    .parameter "oldX"
    .parameter "oldY"
    .parameter "rangeX"
    .parameter "rangeY"

    .prologue
    if-gtz p6, :cond_e

    iget-object v0, p0, Landroid/webkit/OverScrollGlow;->mHostView:Landroid/webkit/WebViewClassic;

    invoke-virtual {v0}, Landroid/webkit/WebViewClassic;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/WebView;->getOverScrollMode()I

    move-result v0

    if-nez v0, :cond_2d

    :cond_e
    if-gez p2, :cond_4f

    if-ltz p4, :cond_4f

    iget-object v0, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowTop:Landroid/widget/EdgeEffect;

    iget-object v1, p0, Landroid/webkit/OverScrollGlow;->mHostView:Landroid/webkit/WebViewClassic;

    iget-object v1, v1, Landroid/webkit/WebViewClassic;->mScroller:Landroid/widget/OverScroller;

    invoke-virtual {v1}, Landroid/widget/OverScroller;->getCurrVelocity()F

    move-result v1

    float-to-int v1, v1

    invoke-virtual {v0, v1}, Landroid/widget/EdgeEffect;->onAbsorb(I)V

    iget-object v0, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowBottom:Landroid/widget/EdgeEffect;

    invoke-virtual {v0}, Landroid/widget/EdgeEffect;->isFinished()Z

    move-result v0

    if-nez v0, :cond_2d

    iget-object v0, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowBottom:Landroid/widget/EdgeEffect;

    invoke-virtual {v0}, Landroid/widget/EdgeEffect;->onRelease()V

    :cond_2d
    :goto_2d
    if-lez p5, :cond_4e

    if-gez p1, :cond_6f

    if-ltz p3, :cond_6f

    iget-object v0, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowLeft:Landroid/widget/EdgeEffect;

    iget-object v1, p0, Landroid/webkit/OverScrollGlow;->mHostView:Landroid/webkit/WebViewClassic;

    iget-object v1, v1, Landroid/webkit/WebViewClassic;->mScroller:Landroid/widget/OverScroller;

    invoke-virtual {v1}, Landroid/widget/OverScroller;->getCurrVelocity()F

    move-result v1

    float-to-int v1, v1

    invoke-virtual {v0, v1}, Landroid/widget/EdgeEffect;->onAbsorb(I)V

    iget-object v0, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowRight:Landroid/widget/EdgeEffect;

    invoke-virtual {v0}, Landroid/widget/EdgeEffect;->isFinished()Z

    move-result v0

    if-nez v0, :cond_4e

    iget-object v0, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowRight:Landroid/widget/EdgeEffect;

    invoke-virtual {v0}, Landroid/widget/EdgeEffect;->onRelease()V

    :cond_4e
    :goto_4e
    return-void

    :cond_4f
    if-le p2, p6, :cond_2d

    if-gt p4, p6, :cond_2d

    iget-object v0, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowBottom:Landroid/widget/EdgeEffect;

    iget-object v1, p0, Landroid/webkit/OverScrollGlow;->mHostView:Landroid/webkit/WebViewClassic;

    iget-object v1, v1, Landroid/webkit/WebViewClassic;->mScroller:Landroid/widget/OverScroller;

    invoke-virtual {v1}, Landroid/widget/OverScroller;->getCurrVelocity()F

    move-result v1

    float-to-int v1, v1

    invoke-virtual {v0, v1}, Landroid/widget/EdgeEffect;->onAbsorb(I)V

    iget-object v0, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowTop:Landroid/widget/EdgeEffect;

    invoke-virtual {v0}, Landroid/widget/EdgeEffect;->isFinished()Z

    move-result v0

    if-nez v0, :cond_2d

    iget-object v0, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowTop:Landroid/widget/EdgeEffect;

    invoke-virtual {v0}, Landroid/widget/EdgeEffect;->onRelease()V

    goto :goto_2d

    :cond_6f
    if-le p1, p5, :cond_4e

    if-gt p3, p5, :cond_4e

    iget-object v0, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowRight:Landroid/widget/EdgeEffect;

    iget-object v1, p0, Landroid/webkit/OverScrollGlow;->mHostView:Landroid/webkit/WebViewClassic;

    iget-object v1, v1, Landroid/webkit/WebViewClassic;->mScroller:Landroid/widget/OverScroller;

    invoke-virtual {v1}, Landroid/widget/OverScroller;->getCurrVelocity()F

    move-result v1

    float-to-int v1, v1

    invoke-virtual {v0, v1}, Landroid/widget/EdgeEffect;->onAbsorb(I)V

    iget-object v0, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowLeft:Landroid/widget/EdgeEffect;

    invoke-virtual {v0}, Landroid/widget/EdgeEffect;->isFinished()Z

    move-result v0

    if-nez v0, :cond_4e

    iget-object v0, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowLeft:Landroid/widget/EdgeEffect;

    invoke-virtual {v0}, Landroid/widget/EdgeEffect;->onRelease()V

    goto :goto_4e
.end method

.method public drawEdgeGlows(Landroid/graphics/Canvas;)Z
    .registers 12
    .parameter "canvas"

    .prologue
    const/4 v9, 0x0

    iget-object v6, p0, Landroid/webkit/OverScrollGlow;->mHostView:Landroid/webkit/WebViewClassic;

    invoke-virtual {v6}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v3

    .local v3, scrollX:I
    iget-object v6, p0, Landroid/webkit/OverScrollGlow;->mHostView:Landroid/webkit/WebViewClassic;

    invoke-virtual {v6}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v4

    .local v4, scrollY:I
    iget-object v6, p0, Landroid/webkit/OverScrollGlow;->mHostView:Landroid/webkit/WebViewClassic;

    invoke-virtual {v6}, Landroid/webkit/WebViewClassic;->getWidth()I

    move-result v5

    .local v5, width:I
    iget-object v6, p0, Landroid/webkit/OverScrollGlow;->mHostView:Landroid/webkit/WebViewClassic;

    invoke-virtual {v6}, Landroid/webkit/WebViewClassic;->getHeight()I

    move-result v0

    .local v0, height:I
    const/4 v1, 0x0

    .local v1, invalidateForGlow:Z
    iget-object v6, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowTop:Landroid/widget/EdgeEffect;

    invoke-virtual {v6}, Landroid/widget/EdgeEffect;->isFinished()Z

    move-result v6

    if-nez v6, :cond_45

    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    move-result v2

    .local v2, restoreCount:I
    int-to-float v6, v3

    iget-object v7, p0, Landroid/webkit/OverScrollGlow;->mHostView:Landroid/webkit/WebViewClassic;

    invoke-virtual {v7}, Landroid/webkit/WebViewClassic;->getVisibleTitleHeight()I

    move-result v7

    invoke-static {v9, v4}, Ljava/lang/Math;->min(II)I

    move-result v8

    add-int/2addr v7, v8

    int-to-float v7, v7

    invoke-virtual {p1, v6, v7}, Landroid/graphics/Canvas;->translate(FF)V

    iget-object v6, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowTop:Landroid/widget/EdgeEffect;

    invoke-virtual {v6, v5, v0}, Landroid/widget/EdgeEffect;->setSize(II)V

    iget-object v6, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowTop:Landroid/widget/EdgeEffect;

    invoke-virtual {v6, p1}, Landroid/widget/EdgeEffect;->draw(Landroid/graphics/Canvas;)Z

    move-result v6

    or-int/2addr v1, v6

    invoke-virtual {p1, v2}, Landroid/graphics/Canvas;->restoreToCount(I)V

    .end local v2           #restoreCount:I
    :cond_45
    iget-object v6, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowBottom:Landroid/widget/EdgeEffect;

    invoke-virtual {v6}, Landroid/widget/EdgeEffect;->isFinished()Z

    move-result v6

    if-nez v6, :cond_79

    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    move-result v2

    .restart local v2       #restoreCount:I
    neg-int v6, v5

    add-int/2addr v6, v3

    int-to-float v6, v6

    iget-object v7, p0, Landroid/webkit/OverScrollGlow;->mHostView:Landroid/webkit/WebViewClassic;

    invoke-virtual {v7}, Landroid/webkit/WebViewClassic;->computeMaxScrollY()I

    move-result v7

    invoke-static {v7, v4}, Ljava/lang/Math;->max(II)I

    move-result v7

    add-int/2addr v7, v0

    int-to-float v7, v7

    invoke-virtual {p1, v6, v7}, Landroid/graphics/Canvas;->translate(FF)V

    const/high16 v6, 0x4334

    int-to-float v7, v5

    const/4 v8, 0x0

    invoke-virtual {p1, v6, v7, v8}, Landroid/graphics/Canvas;->rotate(FFF)V

    iget-object v6, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowBottom:Landroid/widget/EdgeEffect;

    invoke-virtual {v6, v5, v0}, Landroid/widget/EdgeEffect;->setSize(II)V

    iget-object v6, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowBottom:Landroid/widget/EdgeEffect;

    invoke-virtual {v6, p1}, Landroid/widget/EdgeEffect;->draw(Landroid/graphics/Canvas;)Z

    move-result v6

    or-int/2addr v1, v6

    invoke-virtual {p1, v2}, Landroid/graphics/Canvas;->restoreToCount(I)V

    .end local v2           #restoreCount:I
    :cond_79
    iget-object v6, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowLeft:Landroid/widget/EdgeEffect;

    invoke-virtual {v6}, Landroid/widget/EdgeEffect;->isFinished()Z

    move-result v6

    if-nez v6, :cond_a4

    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    move-result v2

    .restart local v2       #restoreCount:I
    const/high16 v6, 0x4387

    invoke-virtual {p1, v6}, Landroid/graphics/Canvas;->rotate(F)V

    neg-int v6, v0

    sub-int/2addr v6, v4

    int-to-float v6, v6

    invoke-static {v9, v3}, Ljava/lang/Math;->min(II)I

    move-result v7

    int-to-float v7, v7

    invoke-virtual {p1, v6, v7}, Landroid/graphics/Canvas;->translate(FF)V

    iget-object v6, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowLeft:Landroid/widget/EdgeEffect;

    invoke-virtual {v6, v0, v5}, Landroid/widget/EdgeEffect;->setSize(II)V

    iget-object v6, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowLeft:Landroid/widget/EdgeEffect;

    invoke-virtual {v6, p1}, Landroid/widget/EdgeEffect;->draw(Landroid/graphics/Canvas;)Z

    move-result v6

    or-int/2addr v1, v6

    invoke-virtual {p1, v2}, Landroid/graphics/Canvas;->restoreToCount(I)V

    .end local v2           #restoreCount:I
    :cond_a4
    iget-object v6, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowRight:Landroid/widget/EdgeEffect;

    invoke-virtual {v6}, Landroid/widget/EdgeEffect;->isFinished()Z

    move-result v6

    if-nez v6, :cond_d5

    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    move-result v2

    .restart local v2       #restoreCount:I
    const/high16 v6, 0x42b4

    invoke-virtual {p1, v6}, Landroid/graphics/Canvas;->rotate(F)V

    int-to-float v6, v4

    iget-object v7, p0, Landroid/webkit/OverScrollGlow;->mHostView:Landroid/webkit/WebViewClassic;

    invoke-virtual {v7}, Landroid/webkit/WebViewClassic;->computeMaxScrollX()I

    move-result v7

    invoke-static {v7, v3}, Ljava/lang/Math;->max(II)I

    move-result v7

    add-int/2addr v7, v5

    neg-int v7, v7

    int-to-float v7, v7

    invoke-virtual {p1, v6, v7}, Landroid/graphics/Canvas;->translate(FF)V

    iget-object v6, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowRight:Landroid/widget/EdgeEffect;

    invoke-virtual {v6, v0, v5}, Landroid/widget/EdgeEffect;->setSize(II)V

    iget-object v6, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowRight:Landroid/widget/EdgeEffect;

    invoke-virtual {v6, p1}, Landroid/widget/EdgeEffect;->draw(Landroid/graphics/Canvas;)Z

    move-result v6

    or-int/2addr v1, v6

    invoke-virtual {p1, v2}, Landroid/graphics/Canvas;->restoreToCount(I)V

    .end local v2           #restoreCount:I
    :cond_d5
    return v1
.end method

.method public isAnimating()Z
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowTop:Landroid/widget/EdgeEffect;

    invoke-virtual {v0}, Landroid/widget/EdgeEffect;->isFinished()Z

    move-result v0

    if-eqz v0, :cond_20

    iget-object v0, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowBottom:Landroid/widget/EdgeEffect;

    invoke-virtual {v0}, Landroid/widget/EdgeEffect;->isFinished()Z

    move-result v0

    if-eqz v0, :cond_20

    iget-object v0, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowLeft:Landroid/widget/EdgeEffect;

    invoke-virtual {v0}, Landroid/widget/EdgeEffect;->isFinished()Z

    move-result v0

    if-eqz v0, :cond_20

    iget-object v0, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowRight:Landroid/widget/EdgeEffect;

    invoke-virtual {v0}, Landroid/widget/EdgeEffect;->isFinished()Z

    move-result v0

    if-nez v0, :cond_22

    :cond_20
    const/4 v0, 0x1

    :goto_21
    return v0

    :cond_22
    const/4 v0, 0x0

    goto :goto_21
.end method

.method public pullGlow(IIIIII)V
    .registers 13
    .parameter "x"
    .parameter "y"
    .parameter "oldX"
    .parameter "oldY"
    .parameter "maxX"
    .parameter "maxY"

    .prologue
    const/4 v5, 0x0

    iget-object v2, p0, Landroid/webkit/OverScrollGlow;->mHostView:Landroid/webkit/WebViewClassic;

    invoke-virtual {v2}, Landroid/webkit/WebViewClassic;->getScrollX()I

    move-result v2

    if-ne p3, v2, :cond_6b

    iget-object v2, p0, Landroid/webkit/OverScrollGlow;->mHostView:Landroid/webkit/WebViewClassic;

    invoke-virtual {v2}, Landroid/webkit/WebViewClassic;->getScrollY()I

    move-result v2

    if-ne p4, v2, :cond_6b

    if-lez p5, :cond_38

    iget v2, p0, Landroid/webkit/OverScrollGlow;->mOverScrollDeltaX:I

    add-int v0, p3, v2

    .local v0, pulledToX:I
    if-gez v0, :cond_6c

    iget-object v2, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowLeft:Landroid/widget/EdgeEffect;

    iget v3, p0, Landroid/webkit/OverScrollGlow;->mOverScrollDeltaX:I

    int-to-float v3, v3

    iget-object v4, p0, Landroid/webkit/OverScrollGlow;->mHostView:Landroid/webkit/WebViewClassic;

    invoke-virtual {v4}, Landroid/webkit/WebViewClassic;->getWidth()I

    move-result v4

    int-to-float v4, v4

    div-float/2addr v3, v4

    invoke-virtual {v2, v3}, Landroid/widget/EdgeEffect;->onPull(F)V

    iget-object v2, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowRight:Landroid/widget/EdgeEffect;

    invoke-virtual {v2}, Landroid/widget/EdgeEffect;->isFinished()Z

    move-result v2

    if-nez v2, :cond_36

    iget-object v2, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowRight:Landroid/widget/EdgeEffect;

    invoke-virtual {v2}, Landroid/widget/EdgeEffect;->onRelease()V

    :cond_36
    :goto_36
    iput v5, p0, Landroid/webkit/OverScrollGlow;->mOverScrollDeltaX:I

    .end local v0           #pulledToX:I
    :cond_38
    if-gtz p6, :cond_46

    iget-object v2, p0, Landroid/webkit/OverScrollGlow;->mHostView:Landroid/webkit/WebViewClassic;

    invoke-virtual {v2}, Landroid/webkit/WebViewClassic;->getWebView()Landroid/webkit/WebView;

    move-result-object v2

    invoke-virtual {v2}, Landroid/webkit/WebView;->getOverScrollMode()I

    move-result v2

    if-nez v2, :cond_6b

    :cond_46
    iget v2, p0, Landroid/webkit/OverScrollGlow;->mOverScrollDeltaY:I

    add-int v1, p4, v2

    .local v1, pulledToY:I
    if-gez v1, :cond_8c

    iget-object v2, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowTop:Landroid/widget/EdgeEffect;

    iget v3, p0, Landroid/webkit/OverScrollGlow;->mOverScrollDeltaY:I

    int-to-float v3, v3

    iget-object v4, p0, Landroid/webkit/OverScrollGlow;->mHostView:Landroid/webkit/WebViewClassic;

    invoke-virtual {v4}, Landroid/webkit/WebViewClassic;->getHeight()I

    move-result v4

    int-to-float v4, v4

    div-float/2addr v3, v4

    invoke-virtual {v2, v3}, Landroid/widget/EdgeEffect;->onPull(F)V

    iget-object v2, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowBottom:Landroid/widget/EdgeEffect;

    invoke-virtual {v2}, Landroid/widget/EdgeEffect;->isFinished()Z

    move-result v2

    if-nez v2, :cond_69

    iget-object v2, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowBottom:Landroid/widget/EdgeEffect;

    invoke-virtual {v2}, Landroid/widget/EdgeEffect;->onRelease()V

    :cond_69
    :goto_69
    iput v5, p0, Landroid/webkit/OverScrollGlow;->mOverScrollDeltaY:I

    .end local v1           #pulledToY:I
    :cond_6b
    return-void

    .restart local v0       #pulledToX:I
    :cond_6c
    if-le v0, p5, :cond_36

    iget-object v2, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowRight:Landroid/widget/EdgeEffect;

    iget v3, p0, Landroid/webkit/OverScrollGlow;->mOverScrollDeltaX:I

    int-to-float v3, v3

    iget-object v4, p0, Landroid/webkit/OverScrollGlow;->mHostView:Landroid/webkit/WebViewClassic;

    invoke-virtual {v4}, Landroid/webkit/WebViewClassic;->getWidth()I

    move-result v4

    int-to-float v4, v4

    div-float/2addr v3, v4

    invoke-virtual {v2, v3}, Landroid/widget/EdgeEffect;->onPull(F)V

    iget-object v2, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowLeft:Landroid/widget/EdgeEffect;

    invoke-virtual {v2}, Landroid/widget/EdgeEffect;->isFinished()Z

    move-result v2

    if-nez v2, :cond_36

    iget-object v2, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowLeft:Landroid/widget/EdgeEffect;

    invoke-virtual {v2}, Landroid/widget/EdgeEffect;->onRelease()V

    goto :goto_36

    .end local v0           #pulledToX:I
    .restart local v1       #pulledToY:I
    :cond_8c
    if-le v1, p6, :cond_69

    iget-object v2, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowBottom:Landroid/widget/EdgeEffect;

    iget v3, p0, Landroid/webkit/OverScrollGlow;->mOverScrollDeltaY:I

    int-to-float v3, v3

    iget-object v4, p0, Landroid/webkit/OverScrollGlow;->mHostView:Landroid/webkit/WebViewClassic;

    invoke-virtual {v4}, Landroid/webkit/WebViewClassic;->getHeight()I

    move-result v4

    int-to-float v4, v4

    div-float/2addr v3, v4

    invoke-virtual {v2, v3}, Landroid/widget/EdgeEffect;->onPull(F)V

    iget-object v2, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowTop:Landroid/widget/EdgeEffect;

    invoke-virtual {v2}, Landroid/widget/EdgeEffect;->isFinished()Z

    move-result v2

    if-nez v2, :cond_69

    iget-object v2, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowTop:Landroid/widget/EdgeEffect;

    invoke-virtual {v2}, Landroid/widget/EdgeEffect;->onRelease()V

    goto :goto_69
.end method

.method public releaseAll()V
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowTop:Landroid/widget/EdgeEffect;

    invoke-virtual {v0}, Landroid/widget/EdgeEffect;->onRelease()V

    iget-object v0, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowBottom:Landroid/widget/EdgeEffect;

    invoke-virtual {v0}, Landroid/widget/EdgeEffect;->onRelease()V

    iget-object v0, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowLeft:Landroid/widget/EdgeEffect;

    invoke-virtual {v0}, Landroid/widget/EdgeEffect;->onRelease()V

    iget-object v0, p0, Landroid/webkit/OverScrollGlow;->mEdgeGlowRight:Landroid/widget/EdgeEffect;

    invoke-virtual {v0}, Landroid/widget/EdgeEffect;->onRelease()V

    return-void
.end method

.method public setOverScrollDeltas(II)V
    .registers 3
    .parameter "deltaX"
    .parameter "deltaY"

    .prologue
    iput p1, p0, Landroid/webkit/OverScrollGlow;->mOverScrollDeltaX:I

    iput p2, p0, Landroid/webkit/OverScrollGlow;->mOverScrollDeltaY:I

    return-void
.end method
