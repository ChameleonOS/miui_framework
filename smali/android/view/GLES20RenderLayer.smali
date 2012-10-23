.class Landroid/view/GLES20RenderLayer;
.super Landroid/view/GLES20Layer;
.source "GLES20RenderLayer.java"


# instance fields
.field private final mCanvas:Landroid/view/GLES20Canvas;

.field private mLayerHeight:I

.field private mLayerWidth:I


# direct methods
.method constructor <init>(IIZ)V
    .registers 9
    .parameter "width"
    .parameter "height"
    .parameter "isOpaque"

    .prologue
    const/4 v4, 0x0

    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 35
    invoke-direct {p0, p1, p2, p3}, Landroid/view/GLES20Layer;-><init>(IIZ)V

    .line 37
    const/4 v3, 0x2

    new-array v0, v3, [I

    .line 38
    .local v0, layerInfo:[I
    invoke-static {p1, p2, p3, v0}, Landroid/view/GLES20Canvas;->nCreateLayer(IIZ[I)I

    move-result v3

    iput v3, p0, Landroid/view/GLES20Layer;->mLayer:I

    .line 39
    iget v3, p0, Landroid/view/GLES20Layer;->mLayer:I

    if-eqz v3, :cond_32

    .line 40
    aget v3, v0, v2

    iput v3, p0, Landroid/view/GLES20RenderLayer;->mLayerWidth:I

    .line 41
    aget v3, v0, v1

    iput v3, p0, Landroid/view/GLES20RenderLayer;->mLayerHeight:I

    .line 43
    new-instance v3, Landroid/view/GLES20Canvas;

    iget v4, p0, Landroid/view/GLES20Layer;->mLayer:I

    if-nez p3, :cond_30

    :goto_21
    invoke-direct {v3, v4, v1}, Landroid/view/GLES20Canvas;-><init>(IZ)V

    iput-object v3, p0, Landroid/view/GLES20RenderLayer;->mCanvas:Landroid/view/GLES20Canvas;

    .line 44
    new-instance v1, Landroid/view/GLES20Layer$Finalizer;

    iget v2, p0, Landroid/view/GLES20Layer;->mLayer:I

    invoke-direct {v1, v2}, Landroid/view/GLES20Layer$Finalizer;-><init>(I)V

    iput-object v1, p0, Landroid/view/GLES20Layer;->mFinalizer:Landroid/view/GLES20Layer$Finalizer;

    .line 49
    :goto_2f
    return-void

    :cond_30
    move v1, v2

    .line 43
    goto :goto_21

    .line 46
    :cond_32
    iput-object v4, p0, Landroid/view/GLES20RenderLayer;->mCanvas:Landroid/view/GLES20Canvas;

    .line 47
    iput-object v4, p0, Landroid/view/GLES20Layer;->mFinalizer:Landroid/view/GLES20Layer$Finalizer;

    goto :goto_2f
.end method


# virtual methods
.method end(Landroid/graphics/Canvas;)V
    .registers 3
    .parameter "currentCanvas"

    .prologue
    .line 80
    instance-of v0, p1, Landroid/view/GLES20Canvas;

    if-eqz v0, :cond_9

    .line 81
    check-cast p1, Landroid/view/GLES20Canvas;

    .end local p1
    invoke-virtual {p1}, Landroid/view/GLES20Canvas;->resume()V

    .line 83
    :cond_9
    return-void
.end method

.method getCanvas()Landroid/view/HardwareCanvas;
    .registers 2

    .prologue
    .line 75
    iget-object v0, p0, Landroid/view/GLES20RenderLayer;->mCanvas:Landroid/view/GLES20Canvas;

    return-object v0
.end method

.method isValid()Z
    .registers 2

    .prologue
    .line 53
    iget v0, p0, Landroid/view/GLES20Layer;->mLayer:I

    if-eqz v0, :cond_e

    iget v0, p0, Landroid/view/GLES20RenderLayer;->mLayerWidth:I

    if-lez v0, :cond_e

    iget v0, p0, Landroid/view/GLES20RenderLayer;->mLayerHeight:I

    if-lez v0, :cond_e

    const/4 v0, 0x1

    :goto_d
    return v0

    :cond_e
    const/4 v0, 0x0

    goto :goto_d
.end method

.method redraw(Landroid/view/DisplayList;Landroid/graphics/Rect;)V
    .registers 10
    .parameter "displayList"
    .parameter "dirtyRect"

    .prologue
    .line 102
    iget v0, p0, Landroid/view/GLES20Layer;->mLayer:I

    iget-object v1, p0, Landroid/view/GLES20RenderLayer;->mCanvas:Landroid/view/GLES20Canvas;

    invoke-virtual {v1}, Landroid/view/GLES20Canvas;->getRenderer()I

    move-result v1

    check-cast p1, Landroid/view/GLES20DisplayList;

    .end local p1
    invoke-virtual {p1}, Landroid/view/GLES20DisplayList;->getNativeDisplayList()I

    move-result v2

    iget v3, p2, Landroid/graphics/Rect;->left:I

    iget v4, p2, Landroid/graphics/Rect;->top:I

    iget v5, p2, Landroid/graphics/Rect;->right:I

    iget v6, p2, Landroid/graphics/Rect;->bottom:I

    invoke-static/range {v0 .. v6}, Landroid/view/GLES20Canvas;->nUpdateRenderLayer(IIIIIII)V

    .line 105
    return-void
.end method

.method resize(II)V
    .registers 5
    .parameter "width"
    .parameter "height"

    .prologue
    .line 58
    invoke-virtual {p0}, Landroid/view/GLES20RenderLayer;->isValid()Z

    move-result v1

    if-eqz v1, :cond_a

    if-lez p1, :cond_a

    if-gtz p2, :cond_b

    .line 71
    :cond_a
    :goto_a
    return-void

    .line 60
    :cond_b
    iput p1, p0, Landroid/view/HardwareLayer;->mWidth:I

    .line 61
    iput p2, p0, Landroid/view/HardwareLayer;->mHeight:I

    .line 63
    iget v1, p0, Landroid/view/GLES20RenderLayer;->mLayerWidth:I

    if-ne p1, v1, :cond_17

    iget v1, p0, Landroid/view/GLES20RenderLayer;->mLayerHeight:I

    if-eq p2, v1, :cond_a

    .line 64
    :cond_17
    const/4 v1, 0x2

    new-array v0, v1, [I

    .line 66
    .local v0, layerInfo:[I
    iget v1, p0, Landroid/view/GLES20Layer;->mLayer:I

    invoke-static {v1, p1, p2, v0}, Landroid/view/GLES20Canvas;->nResizeLayer(III[I)V

    .line 68
    const/4 v1, 0x0

    aget v1, v0, v1

    iput v1, p0, Landroid/view/GLES20RenderLayer;->mLayerWidth:I

    .line 69
    const/4 v1, 0x1

    aget v1, v0, v1

    iput v1, p0, Landroid/view/GLES20RenderLayer;->mLayerHeight:I

    goto :goto_a
.end method

.method setTransform(Landroid/graphics/Matrix;)V
    .registers 2
    .parameter "matrix"

    .prologue
    .line 98
    return-void
.end method

.method start(Landroid/graphics/Canvas;)Landroid/view/HardwareCanvas;
    .registers 3
    .parameter "currentCanvas"

    .prologue
    .line 87
    instance-of v0, p1, Landroid/view/GLES20Canvas;

    if-eqz v0, :cond_9

    .line 88
    check-cast p1, Landroid/view/GLES20Canvas;

    .end local p1
    invoke-virtual {p1}, Landroid/view/GLES20Canvas;->interrupt()V

    .line 90
    :cond_9
    invoke-virtual {p0}, Landroid/view/GLES20RenderLayer;->getCanvas()Landroid/view/HardwareCanvas;

    move-result-object v0

    return-object v0
.end method
