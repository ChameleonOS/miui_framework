.class public Landroid/graphics/LightingColorFilter;
.super Landroid/graphics/ColorFilter;
.source "LightingColorFilter.java"


# direct methods
.method public constructor <init>(II)V
    .registers 4
    .parameter "mul"
    .parameter "add"

    .prologue
    .line 31
    invoke-direct {p0}, Landroid/graphics/ColorFilter;-><init>()V

    .line 32
    invoke-static {p1, p2}, Landroid/graphics/LightingColorFilter;->native_CreateLightingFilter(II)I

    move-result v0

    iput v0, p0, Landroid/graphics/ColorFilter;->native_instance:I

    .line 33
    iget v0, p0, Landroid/graphics/ColorFilter;->native_instance:I

    invoke-static {v0, p1, p2}, Landroid/graphics/LightingColorFilter;->nCreateLightingFilter(III)I

    move-result v0

    iput v0, p0, Landroid/graphics/ColorFilter;->nativeColorFilter:I

    .line 34
    return-void
.end method

.method private static native nCreateLightingFilter(III)I
.end method

.method private static native native_CreateLightingFilter(II)I
.end method
