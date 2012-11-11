.class public Landroid/graphics/SweepGradient;
.super Landroid/graphics/Shader;
.source "SweepGradient.java"


# direct methods
.method public constructor <init>(FFII)V
    .registers 6
    .parameter "cx"
    .parameter "cy"
    .parameter "color0"
    .parameter "color1"

    .prologue
    invoke-direct {p0}, Landroid/graphics/Shader;-><init>()V

    invoke-static {p1, p2, p3, p4}, Landroid/graphics/SweepGradient;->nativeCreate2(FFII)I

    move-result v0

    iput v0, p0, Landroid/graphics/Shader;->native_instance:I

    iget v0, p0, Landroid/graphics/Shader;->native_instance:I

    invoke-static {v0, p1, p2, p3, p4}, Landroid/graphics/SweepGradient;->nativePostCreate2(IFFII)I

    move-result v0

    iput v0, p0, Landroid/graphics/Shader;->native_shader:I

    return-void
.end method

.method public constructor <init>(FF[I[F)V
    .registers 7
    .parameter "cx"
    .parameter "cy"
    .parameter "colors"
    .parameter "positions"

    .prologue
    invoke-direct {p0}, Landroid/graphics/Shader;-><init>()V

    array-length v0, p3

    const/4 v1, 0x2

    if-ge v0, v1, :cond_10

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "needs >= 2 number of colors"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_10
    if-eqz p4, :cond_1e

    array-length v0, p3

    array-length v1, p4

    if-eq v0, v1, :cond_1e

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "color and position arrays must be of equal length"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1e
    invoke-static {p1, p2, p3, p4}, Landroid/graphics/SweepGradient;->nativeCreate1(FF[I[F)I

    move-result v0

    iput v0, p0, Landroid/graphics/Shader;->native_instance:I

    iget v0, p0, Landroid/graphics/Shader;->native_instance:I

    invoke-static {v0, p1, p2, p3, p4}, Landroid/graphics/SweepGradient;->nativePostCreate1(IFF[I[F)I

    move-result v0

    iput v0, p0, Landroid/graphics/Shader;->native_shader:I

    return-void
.end method

.method private static native nativeCreate1(FF[I[F)I
.end method

.method private static native nativeCreate2(FFII)I
.end method

.method private static native nativePostCreate1(IFF[I[F)I
.end method

.method private static native nativePostCreate2(IFFII)I
.end method
