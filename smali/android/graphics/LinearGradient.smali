.class public Landroid/graphics/LinearGradient;
.super Landroid/graphics/Shader;
.source "LinearGradient.java"


# direct methods
.method public constructor <init>(FFFFIILandroid/graphics/Shader$TileMode;)V
    .registers 18
    .parameter "x0"
    .parameter "y0"
    .parameter "x1"
    .parameter "y1"
    .parameter "color0"
    .parameter "color1"
    .parameter "tile"

    .prologue
    .line 54
    invoke-direct {p0}, Landroid/graphics/Shader;-><init>()V

    .line 55
    move-object/from16 v0, p7

    iget v8, v0, Landroid/graphics/Shader$TileMode;->nativeInt:I

    move-object v1, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move v6, p5

    move/from16 v7, p6

    invoke-direct/range {v1 .. v8}, Landroid/graphics/LinearGradient;->nativeCreate2(FFFFIII)I

    move-result v1

    iput v1, p0, Landroid/graphics/Shader;->native_instance:I

    .line 56
    iget v2, p0, Landroid/graphics/Shader;->native_instance:I

    move-object/from16 v0, p7

    iget v9, v0, Landroid/graphics/Shader$TileMode;->nativeInt:I

    move-object v1, p0

    move v3, p1

    move v4, p2

    move v5, p3

    move v6, p4

    move v7, p5

    move/from16 v8, p6

    invoke-direct/range {v1 .. v9}, Landroid/graphics/LinearGradient;->nativePostCreate2(IFFFFIII)I

    move-result v1

    iput v1, p0, Landroid/graphics/Shader;->native_shader:I

    .line 58
    return-void
.end method

.method public constructor <init>(FFFF[I[FLandroid/graphics/Shader$TileMode;)V
    .registers 18
    .parameter "x0"
    .parameter "y0"
    .parameter "x1"
    .parameter "y1"
    .parameter "colors"
    .parameter "positions"
    .parameter "tile"

    .prologue
    .line 32
    invoke-direct {p0}, Landroid/graphics/Shader;-><init>()V

    .line 33
    array-length v1, p5

    const/4 v2, 0x2

    if-ge v1, v2, :cond_10

    .line 34
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "needs >= 2 number of colors"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 36
    :cond_10
    if-eqz p6, :cond_20

    array-length v1, p5

    move-object/from16 v0, p6

    array-length v2, v0

    if-eq v1, v2, :cond_20

    .line 37
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "color and position arrays must be of equal length"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 39
    :cond_20
    move-object/from16 v0, p7

    iget v8, v0, Landroid/graphics/Shader$TileMode;->nativeInt:I

    move-object v1, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move-object v6, p5

    move-object/from16 v7, p6

    invoke-direct/range {v1 .. v8}, Landroid/graphics/LinearGradient;->nativeCreate1(FFFF[I[FI)I

    move-result v1

    iput v1, p0, Landroid/graphics/Shader;->native_instance:I

    .line 40
    iget v2, p0, Landroid/graphics/Shader;->native_instance:I

    move-object/from16 v0, p7

    iget v9, v0, Landroid/graphics/Shader$TileMode;->nativeInt:I

    move-object v1, p0

    move v3, p1

    move v4, p2

    move v5, p3

    move v6, p4

    move-object v7, p5

    move-object/from16 v8, p6

    invoke-direct/range {v1 .. v9}, Landroid/graphics/LinearGradient;->nativePostCreate1(IFFFF[I[FI)I

    move-result v1

    iput v1, p0, Landroid/graphics/Shader;->native_shader:I

    .line 42
    return-void
.end method

.method private native nativeCreate1(FFFF[I[FI)I
.end method

.method private native nativeCreate2(FFFFIII)I
.end method

.method private native nativePostCreate1(IFFFF[I[FI)I
.end method

.method private native nativePostCreate2(IFFFFIII)I
.end method
