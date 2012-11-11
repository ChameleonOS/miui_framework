.class abstract Landroid/view/GLES20Layer;
.super Landroid/view/HardwareLayer;
.source "GLES20Layer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/view/GLES20Layer$Finalizer;
    }
.end annotation


# instance fields
.field mFinalizer:Landroid/view/GLES20Layer$Finalizer;

.field mLayer:I


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    invoke-direct {p0}, Landroid/view/HardwareLayer;-><init>()V

    return-void
.end method

.method constructor <init>(IIZ)V
    .registers 4
    .parameter "width"
    .parameter "height"
    .parameter "opaque"

    .prologue
    invoke-direct {p0, p1, p2, p3}, Landroid/view/HardwareLayer;-><init>(IIZ)V

    return-void
.end method


# virtual methods
.method copyInto(Landroid/graphics/Bitmap;)Z
    .registers 4
    .parameter "bitmap"

    .prologue
    iget v0, p0, Landroid/view/GLES20Layer;->mLayer:I

    iget v1, p1, Landroid/graphics/Bitmap;->mNativeBitmap:I

    invoke-static {v0, v1}, Landroid/view/GLES20Canvas;->nCopyLayer(II)Z

    move-result v0

    return v0
.end method

.method destroy()V
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/view/GLES20Layer;->mFinalizer:Landroid/view/GLES20Layer$Finalizer;

    if-eqz v0, :cond_c

    iget-object v0, p0, Landroid/view/GLES20Layer;->mFinalizer:Landroid/view/GLES20Layer$Finalizer;

    invoke-virtual {v0}, Landroid/view/GLES20Layer$Finalizer;->destroy()V

    const/4 v0, 0x0

    iput-object v0, p0, Landroid/view/GLES20Layer;->mFinalizer:Landroid/view/GLES20Layer$Finalizer;

    :cond_c
    const/4 v0, 0x0

    iput v0, p0, Landroid/view/GLES20Layer;->mLayer:I

    return-void
.end method

.method flush()V
    .registers 2

    .prologue
    iget v0, p0, Landroid/view/GLES20Layer;->mLayer:I

    if-eqz v0, :cond_9

    iget v0, p0, Landroid/view/GLES20Layer;->mLayer:I

    invoke-static {v0}, Landroid/view/GLES20Canvas;->nFlushLayer(I)V

    :cond_9
    return-void
.end method

.method public getLayer()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/view/GLES20Layer;->mLayer:I

    return v0
.end method

.method update(IIZ)V
    .registers 4
    .parameter "width"
    .parameter "height"
    .parameter "isOpaque"

    .prologue
    invoke-super {p0, p1, p2, p3}, Landroid/view/HardwareLayer;->update(IIZ)V

    return-void
.end method
