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
    .line 41
    invoke-direct {p0}, Landroid/graphics/Matrix;-><init>()V

    return-void
.end method


# virtual methods
.method oops()V
    .registers 3

    .prologue
    .line 43
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Matrix can not be modified"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public postConcat(Landroid/graphics/Matrix;)Z
    .registers 3
    .parameter "other"

    .prologue
    .line 199
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    .line 200
    const/4 v0, 0x0

    return v0
.end method

.method public postRotate(F)Z
    .registers 3
    .parameter "degrees"

    .prologue
    .line 181
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    .line 182
    const/4 v0, 0x0

    return v0
.end method

.method public postRotate(FFF)Z
    .registers 5
    .parameter "degrees"
    .parameter "px"
    .parameter "py"

    .prologue
    .line 175
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    .line 176
    const/4 v0, 0x0

    return v0
.end method

.method public postScale(FF)Z
    .registers 4
    .parameter "sx"
    .parameter "sy"

    .prologue
    .line 169
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    .line 170
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
    .line 163
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    .line 164
    const/4 v0, 0x0

    return v0
.end method

.method public postSkew(FF)Z
    .registers 4
    .parameter "kx"
    .parameter "ky"

    .prologue
    .line 193
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    .line 194
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
    .line 187
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    .line 188
    const/4 v0, 0x0

    return v0
.end method

.method public postTranslate(FF)Z
    .registers 4
    .parameter "dx"
    .parameter "dy"

    .prologue
    .line 157
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    .line 158
    const/4 v0, 0x0

    return v0
.end method

.method public preConcat(Landroid/graphics/Matrix;)Z
    .registers 3
    .parameter "other"

    .prologue
    .line 151
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    .line 152
    const/4 v0, 0x0

    return v0
.end method

.method public preRotate(F)Z
    .registers 3
    .parameter "degrees"

    .prologue
    .line 133
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    .line 134
    const/4 v0, 0x0

    return v0
.end method

.method public preRotate(FFF)Z
    .registers 5
    .parameter "degrees"
    .parameter "px"
    .parameter "py"

    .prologue
    .line 127
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    .line 128
    const/4 v0, 0x0

    return v0
.end method

.method public preScale(FF)Z
    .registers 4
    .parameter "sx"
    .parameter "sy"

    .prologue
    .line 121
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    .line 122
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
    .line 115
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    .line 116
    const/4 v0, 0x0

    return v0
.end method

.method public preSkew(FF)Z
    .registers 4
    .parameter "kx"
    .parameter "ky"

    .prologue
    .line 145
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    .line 146
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
    .line 139
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    .line 140
    const/4 v0, 0x0

    return v0
.end method

.method public preTranslate(FF)Z
    .registers 4
    .parameter "dx"
    .parameter "dy"

    .prologue
    .line 109
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    .line 110
    const/4 v0, 0x0

    return v0
.end method

.method public reset()V
    .registers 1

    .prologue
    .line 53
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    .line 54
    return-void
.end method

.method public set(Landroid/graphics/Matrix;)V
    .registers 2
    .parameter "src"

    .prologue
    .line 48
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    .line 49
    return-void
.end method

.method public setConcat(Landroid/graphics/Matrix;Landroid/graphics/Matrix;)Z
    .registers 4
    .parameter "a"
    .parameter "b"

    .prologue
    .line 103
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    .line 104
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
    .line 212
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    .line 213
    const/4 v0, 0x0

    return v0
.end method

.method public setRectToRect(Landroid/graphics/RectF;Landroid/graphics/RectF;Landroid/graphics/Matrix$ScaleToFit;)Z
    .registers 5
    .parameter "src"
    .parameter "dst"
    .parameter "stf"

    .prologue
    .line 205
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    .line 206
    const/4 v0, 0x0

    return v0
.end method

.method public setRotate(F)V
    .registers 2
    .parameter "degrees"

    .prologue
    .line 78
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    .line 79
    return-void
.end method

.method public setRotate(FFF)V
    .registers 4
    .parameter "degrees"
    .parameter "px"
    .parameter "py"

    .prologue
    .line 73
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    .line 74
    return-void
.end method

.method public setScale(FF)V
    .registers 3
    .parameter "sx"
    .parameter "sy"

    .prologue
    .line 68
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    .line 69
    return-void
.end method

.method public setScale(FFFF)V
    .registers 5
    .parameter "sx"
    .parameter "sy"
    .parameter "px"
    .parameter "py"

    .prologue
    .line 63
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    .line 64
    return-void
.end method

.method public setSinCos(FF)V
    .registers 3
    .parameter "sinValue"
    .parameter "cosValue"

    .prologue
    .line 88
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    .line 89
    return-void
.end method

.method public setSinCos(FFFF)V
    .registers 5
    .parameter "sinValue"
    .parameter "cosValue"
    .parameter "px"
    .parameter "py"

    .prologue
    .line 83
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    .line 84
    return-void
.end method

.method public setSkew(FF)V
    .registers 3
    .parameter "kx"
    .parameter "ky"

    .prologue
    .line 98
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    .line 99
    return-void
.end method

.method public setSkew(FFFF)V
    .registers 5
    .parameter "kx"
    .parameter "ky"
    .parameter "px"
    .parameter "py"

    .prologue
    .line 93
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    .line 94
    return-void
.end method

.method public setTranslate(FF)V
    .registers 3
    .parameter "dx"
    .parameter "dy"

    .prologue
    .line 58
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    .line 59
    return-void
.end method

.method public setValues([F)V
    .registers 2
    .parameter "values"

    .prologue
    .line 218
    invoke-virtual {p0}, Landroid/graphics/Matrix$1;->oops()V

    .line 219
    return-void
.end method
