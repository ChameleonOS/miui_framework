.class public Landroid/graphics/ColorMatrixColorFilter;
.super Landroid/graphics/ColorFilter;
.source "ColorMatrixColorFilter.java"


# direct methods
.method public constructor <init>(Landroid/graphics/ColorMatrix;)V
    .registers 4
    .parameter "matrix"

    .prologue
    invoke-direct {p0}, Landroid/graphics/ColorFilter;-><init>()V

    invoke-virtual {p1}, Landroid/graphics/ColorMatrix;->getArray()[F

    move-result-object v0

    .local v0, colorMatrix:[F
    invoke-static {v0}, Landroid/graphics/ColorMatrixColorFilter;->nativeColorMatrixFilter([F)I

    move-result v1

    iput v1, p0, Landroid/graphics/ColorFilter;->native_instance:I

    iget v1, p0, Landroid/graphics/ColorFilter;->native_instance:I

    invoke-static {v1, v0}, Landroid/graphics/ColorMatrixColorFilter;->nColorMatrixFilter(I[F)I

    move-result v1

    iput v1, p0, Landroid/graphics/ColorFilter;->nativeColorFilter:I

    return-void
.end method

.method public constructor <init>([F)V
    .registers 4
    .parameter "array"

    .prologue
    invoke-direct {p0}, Landroid/graphics/ColorFilter;-><init>()V

    array-length v0, p1

    const/16 v1, 0x14

    if-ge v0, v1, :cond_e

    new-instance v0, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v0

    :cond_e
    invoke-static {p1}, Landroid/graphics/ColorMatrixColorFilter;->nativeColorMatrixFilter([F)I

    move-result v0

    iput v0, p0, Landroid/graphics/ColorFilter;->native_instance:I

    iget v0, p0, Landroid/graphics/ColorFilter;->native_instance:I

    invoke-static {v0, p1}, Landroid/graphics/ColorMatrixColorFilter;->nColorMatrixFilter(I[F)I

    move-result v0

    iput v0, p0, Landroid/graphics/ColorFilter;->nativeColorFilter:I

    return-void
.end method

.method private static native nColorMatrixFilter(I[F)I
.end method

.method private static native nativeColorMatrixFilter([F)I
.end method
