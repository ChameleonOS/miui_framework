.class public Landroid/graphics/RadialGradient;
.super Landroid/graphics/Shader;
.source "RadialGradient.java"


# direct methods
.method public constructor <init>(FFFIILandroid/graphics/Shader$TileMode;)V
    .registers 14
    .parameter "x"
    .parameter "y"
    .parameter "radius"
    .parameter "color0"
    .parameter "color1"
    .parameter "tile"

    .prologue
    .line 56
    invoke-direct {p0}, Landroid/graphics/Shader;-><init>()V

    .line 57
    const/4 v0, 0x0

    cmpg-float v0, p3, v0

    if-gtz v0, :cond_11

    .line 58
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "radius must be > 0"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 60
    :cond_11
    iget v5, p6, Landroid/graphics/Shader$TileMode;->nativeInt:I

    move v0, p1

    move v1, p2

    move v2, p3

    move v3, p4

    move v4, p5

    invoke-static/range {v0 .. v5}, Landroid/graphics/RadialGradient;->nativeCreate2(FFFIII)I

    move-result v0

    iput v0, p0, Landroid/graphics/Shader;->native_instance:I

    .line 61
    iget v0, p0, Landroid/graphics/Shader;->native_instance:I

    iget v6, p6, Landroid/graphics/Shader$TileMode;->nativeInt:I

    move v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    move v5, p5

    invoke-static/range {v0 .. v6}, Landroid/graphics/RadialGradient;->nativePostCreate2(IFFFIII)I

    move-result v0

    iput v0, p0, Landroid/graphics/Shader;->native_shader:I

    .line 63
    return-void
.end method

.method public constructor <init>(FFF[I[FLandroid/graphics/Shader$TileMode;)V
    .registers 14
    .parameter "x"
    .parameter "y"
    .parameter "radius"
    .parameter "colors"
    .parameter "positions"
    .parameter "tile"

    .prologue
    .line 32
    invoke-direct {p0}, Landroid/graphics/Shader;-><init>()V

    .line 33
    const/4 v0, 0x0

    cmpg-float v0, p3, v0

    if-gtz v0, :cond_11

    .line 34
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "radius must be > 0"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 36
    :cond_11
    array-length v0, p4

    const/4 v1, 0x2

    if-ge v0, v1, :cond_1e

    .line 37
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "needs >= 2 number of colors"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 39
    :cond_1e
    if-eqz p5, :cond_2c

    array-length v0, p4

    array-length v1, p5

    if-eq v0, v1, :cond_2c

    .line 40
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "color and position arrays must be of equal length"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 42
    :cond_2c
    iget v5, p6, Landroid/graphics/Shader$TileMode;->nativeInt:I

    move v0, p1

    move v1, p2

    move v2, p3

    move-object v3, p4

    move-object v4, p5

    invoke-static/range {v0 .. v5}, Landroid/graphics/RadialGradient;->nativeCreate1(FFF[I[FI)I

    move-result v0

    iput v0, p0, Landroid/graphics/Shader;->native_instance:I

    .line 43
    iget v0, p0, Landroid/graphics/Shader;->native_instance:I

    iget v6, p6, Landroid/graphics/Shader$TileMode;->nativeInt:I

    move v1, p1

    move v2, p2

    move v3, p3

    move-object v4, p4

    move-object v5, p5

    invoke-static/range {v0 .. v6}, Landroid/graphics/RadialGradient;->nativePostCreate1(IFFF[I[FI)I

    move-result v0

    iput v0, p0, Landroid/graphics/Shader;->native_shader:I

    .line 45
    return-void
.end method

.method private static native nativeCreate1(FFF[I[FI)I
.end method

.method private static native nativeCreate2(FFFIII)I
.end method

.method private static native nativePostCreate1(IFFF[I[FI)I
.end method

.method private static native nativePostCreate2(IFFFIII)I
.end method
