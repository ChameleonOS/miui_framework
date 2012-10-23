.class public Landroid/graphics/TableMaskFilter;
.super Landroid/graphics/MaskFilter;
.source "TableMaskFilter.java"


# direct methods
.method private constructor <init>(I)V
    .registers 2
    .parameter "ni"

    .prologue
    .line 31
    invoke-direct {p0}, Landroid/graphics/MaskFilter;-><init>()V

    .line 32
    iput p1, p0, Landroid/graphics/MaskFilter;->native_instance:I

    .line 33
    return-void
.end method

.method public constructor <init>([B)V
    .registers 4
    .parameter "table"

    .prologue
    .line 24
    invoke-direct {p0}, Landroid/graphics/MaskFilter;-><init>()V

    .line 25
    array-length v0, p1

    const/16 v1, 0x100

    if-ge v0, v1, :cond_11

    .line 26
    new-instance v0, Ljava/lang/RuntimeException;

    const-string/jumbo v1, "table.length must be >= 256"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 28
    :cond_11
    invoke-static {p1}, Landroid/graphics/TableMaskFilter;->nativeNewTable([B)I

    move-result v0

    iput v0, p0, Landroid/graphics/MaskFilter;->native_instance:I

    .line 29
    return-void
.end method

.method public static CreateClipTable(II)Landroid/graphics/TableMaskFilter;
    .registers 4
    .parameter "min"
    .parameter "max"

    .prologue
    .line 36
    new-instance v0, Landroid/graphics/TableMaskFilter;

    invoke-static {p0, p1}, Landroid/graphics/TableMaskFilter;->nativeNewClip(II)I

    move-result v1

    invoke-direct {v0, v1}, Landroid/graphics/TableMaskFilter;-><init>(I)V

    return-object v0
.end method

.method public static CreateGammaTable(F)Landroid/graphics/TableMaskFilter;
    .registers 3
    .parameter "gamma"

    .prologue
    .line 40
    new-instance v0, Landroid/graphics/TableMaskFilter;

    invoke-static {p0}, Landroid/graphics/TableMaskFilter;->nativeNewGamma(F)I

    move-result v1

    invoke-direct {v0, v1}, Landroid/graphics/TableMaskFilter;-><init>(I)V

    return-object v0
.end method

.method private static native nativeNewClip(II)I
.end method

.method private static native nativeNewGamma(F)I
.end method

.method private static native nativeNewTable([B)I
.end method
