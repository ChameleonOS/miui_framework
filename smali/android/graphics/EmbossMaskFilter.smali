.class public Landroid/graphics/EmbossMaskFilter;
.super Landroid/graphics/MaskFilter;
.source "EmbossMaskFilter.java"


# direct methods
.method public constructor <init>([FFFF)V
    .registers 7
    .parameter "direction"
    .parameter "ambient"
    .parameter "specular"
    .parameter "blurRadius"

    .prologue
    .line 29
    invoke-direct {p0}, Landroid/graphics/MaskFilter;-><init>()V

    .line 30
    array-length v0, p1

    const/4 v1, 0x3

    if-ge v0, v1, :cond_d

    .line 31
    new-instance v0, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v0

    .line 33
    :cond_d
    invoke-static {p1, p2, p3, p4}, Landroid/graphics/EmbossMaskFilter;->nativeConstructor([FFFF)I

    move-result v0

    iput v0, p0, Landroid/graphics/MaskFilter;->native_instance:I

    .line 34
    return-void
.end method

.method private static native nativeConstructor([FFFF)I
.end method
