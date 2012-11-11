.class final Landroid/graphics/Matrix$1;
.super Landroid/graphics/Matrix;
.source "Matrix.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/graphics/Matrix;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    invoke-direct {p0}, Landroid/graphics/Matrix;-><init>()V

    return-void
.end method


# virtual methods
.method oops()V
    .registers 3

    .prologue
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Matrix can not be modified"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public postConcat(Landroid/graphics/Matrix;)Z
    .registers 3
    .parameter "other"

    .prologue
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    const/4 v0, 0x0

    return v0
.end method

.method public postRotate(F)Z
    .registers 3
    .parameter "degrees"

    .prologue
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    const/4 v0, 0x0

    return v0
.end method

.method public postRotate(FFF)Z
    .registers 5
    .parameter "degrees"
    .parameter "px"
    .parameter "py"

    .prologue
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    const/4 v0, 0x0

    return v0
.end method

.method public postScale(FF)Z
    .registers 4
    .parameter "sx"
    .parameter "sy"

    .prologue
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    const/4 v0, 0x0

    return v0
.end method

.method public postScale(FFFF)Z
    .registers 6
    .parameter "sx"
    .parameter "sy"
    .parameter "px"
    .parameter "py"

    .prologue
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    const/4 v0, 0x0

    return v0
.end method

.method public postSkew(FF)Z
    .registers 4
    .parameter "kx"
    .parameter "ky"

    .prologue
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    const/4 v0, 0x0

    return v0
.end method

.method public postSkew(FFFF)Z
    .registers 6
    .parameter "kx"
    .parameter "ky"
    .parameter "px"
    .parameter "py"

    .prologue
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    const/4 v0, 0x0

    return v0
.end method

.method public postTranslate(FF)Z
    .registers 4
    .parameter "dx"
    .parameter "dy"

    .prologue
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    const/4 v0, 0x0

    return v0
.end method

.method public preConcat(Landroid/graphics/Matrix;)Z
    .registers 3
    .parameter "other"

    .prologue
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    const/4 v0, 0x0

    return v0
.end method

.method public preRotate(F)Z
    .registers 3
    .parameter "degrees"

    .prologue
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    const/4 v0, 0x0

    return v0
.end method

.method public preRotate(FFF)Z
    .registers 5
    .parameter "degrees"
    .parameter "px"
    .parameter "py"

    .prologue
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    const/4 v0, 0x0

    return v0
.end method

.method public preScale(FF)Z
    .registers 4
    .parameter "sx"
    .parameter "sy"

    .prologue
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    const/4 v0, 0x0

    return v0
.end method

.method public preScale(FFFF)Z
    .registers 6
    .parameter "sx"
    .parameter "sy"
    .parameter "px"
    .parameter "py"

    .prologue
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    const/4 v0, 0x0

    return v0
.end method

.method public preSkew(FF)Z
    .registers 4
    .parameter "kx"
    .parameter "ky"

    .prologue
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    const/4 v0, 0x0

    return v0
.end method

.method public preSkew(FFFF)Z
    .registers 6
    .parameter "kx"
    .parameter "ky"
    .parameter "px"
    .parameter "py"

    .prologue
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    const/4 v0, 0x0

    return v0
.end method

.method public preTranslate(FF)Z
    .registers 4
    .parameter "dx"
    .parameter "dy"

    .prologue
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    const/4 v0, 0x0

    return v0
.end method

.method public reset()V
    .registers 1

    .prologue
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    return-void
.end method

.method public set(Landroid/graphics/Matrix;)V
    .registers 2
    .parameter "src"

    .prologue
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    return-void
.end method

.method public setConcat(Landroid/graphics/Matrix;Landroid/graphics/Matrix;)Z
    .registers 4
    .parameter "a"
    .parameter "b"

    .prologue
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    const/4 v0, 0x0

    return v0
.end method

.method public setPolyToPoly([FI[FII)Z
    .registers 7
    .parameter "src"
    .parameter "srcIndex"
    .parameter "dst"
    .parameter "dstIndex"
    .parameter "pointCount"

    .prologue
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    const/4 v0, 0x0

    return v0
.end method

.method public setRectToRect(Landroid/graphics/RectF;Landroid/graphics/RectF;Landroid/graphics/Matrix$ScaleToFit;)Z
    .registers 5
    .parameter "src"
    .parameter "dst"
    .parameter "stf"

    .prologue
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    const/4 v0, 0x0

    return v0
.end method

.method public setRotate(F)V
    .registers 2
    .parameter "degrees"

    .prologue
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    return-void
.end method

.method public setRotate(FFF)V
    .registers 4
    .parameter "degrees"
    .parameter "px"
    .parameter "py"

    .prologue
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    return-void
.end method

.method public setScale(FF)V
    .registers 3
    .parameter "sx"
    .parameter "sy"

    .prologue
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    return-void
.end method

.method public setScale(FFFF)V
    .registers 5
    .parameter "sx"
    .parameter "sy"
    .parameter "px"
    .parameter "py"

    .prologue
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    return-void
.end method

.method public setSinCos(FF)V
    .registers 3
    .parameter "sinValue"
    .parameter "cosValue"

    .prologue
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    return-void
.end method

.method public setSinCos(FFFF)V
    .registers 5
    .parameter "sinValue"
    .parameter "cosValue"
    .parameter "px"
    .parameter "py"

    .prologue
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    return-void
.end method

.method public setSkew(FF)V
    .registers 3
    .parameter "kx"
    .parameter "ky"

    .prologue
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    return-void
.end method

.method public setSkew(FFFF)V
    .registers 5
    .parameter "kx"
    .parameter "ky"
    .parameter "px"
    .parameter "py"

    .prologue
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    return-void
.end method

.method public setTranslate(FF)V
    .registers 3
    .parameter "dx"
    .parameter "dy"

    .prologue
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    return-void
.end method

.method public setValues([F)V
    .registers 2
    .parameter "values"

    .prologue
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    return-void
.end method
