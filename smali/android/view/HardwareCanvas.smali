.class public abstract Landroid/view/HardwareCanvas;
.super Landroid/graphics/Canvas;
.source "HardwareCanvas.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 29
    invoke-direct {p0}, Landroid/graphics/Canvas;-><init>()V

    return-void
.end method


# virtual methods
.method abstract attachFunctor(I)V
.end method

.method public callDrawGLFunction(I)I
    .registers 3
    .parameter "drawGLFunction"

    .prologue
    .line 99
    const/4 v0, 0x0

    return v0
.end method

.method abstract detachFunctor(I)V
.end method

.method public abstract drawDisplayList(Landroid/view/DisplayList;Landroid/graphics/Rect;I)I
.end method

.method abstract drawHardwareLayer(Landroid/view/HardwareLayer;FFLandroid/graphics/Paint;)V
.end method

.method public invokeFunctors(Landroid/graphics/Rect;)I
    .registers 3
    .parameter "dirty"

    .prologue
    .line 111
    const/4 v0, 0x0

    return v0
.end method

.method public isHardwareAccelerated()Z
    .registers 2

    .prologue
    .line 32
    const/4 v0, 0x1

    return v0
.end method

.method public abstract onPostDraw()V
.end method

.method public abstract onPreDraw(Landroid/graphics/Rect;)I
.end method

.method abstract outputDisplayList(Landroid/view/DisplayList;)V
.end method

.method public setBitmap(Landroid/graphics/Bitmap;)V
    .registers 3
    .parameter "bitmap"

    .prologue
    .line 37
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method
