.class public Landroid/graphics/CornerPathEffect;
.super Landroid/graphics/PathEffect;
.source "CornerPathEffect.java"


# direct methods
.method public constructor <init>(F)V
    .registers 3
    .parameter "radius"

    .prologue
    .line 27
    invoke-direct {p0}, Landroid/graphics/PathEffect;-><init>()V

    .line 28
    invoke-static {p1}, Landroid/graphics/CornerPathEffect;->nativeCreate(F)I

    move-result v0

    iput v0, p0, Landroid/graphics/PathEffect;->native_instance:I

    .line 29
    return-void
.end method

.method private static native nativeCreate(F)I
.end method
