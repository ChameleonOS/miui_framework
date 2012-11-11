.class public Landroid/graphics/Matrix;
.super Ljava/lang/Object;
.source "Matrix.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/graphics/Matrix$ScaleToFit;
    }
.end annotation


# static fields
.field public static IDENTITY_MATRIX:Landroid/graphics/Matrix; = null

.field public static final MPERSP_0:I = 0x6

.field public static final MPERSP_1:I = 0x7

.field public static final MPERSP_2:I = 0x8

.field public static final MSCALE_X:I = 0x0

.field public static final MSCALE_Y:I = 0x4

.field public static final MSKEW_X:I = 0x1

.field public static final MSKEW_Y:I = 0x3

.field public static final MTRANS_X:I = 0x2

.field public static final MTRANS_Y:I = 0x5


# instance fields
.field public native_instance:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    new-instance v0, Landroid/graphics/Matrix$1;

    invoke-direct {v0}, Landroid/graphics/Matrix$1;-><init>()V

    sput-object v0, Landroid/graphics/Matrix;->IDENTITY_MATRIX:Landroid/graphics/Matrix;

    return-void
.end method

.method public constructor <init>()V
    .registers 2

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    invoke-static {v0}, Landroid/graphics/Matrix;->native_create(I)I

    move-result v0

    iput v0, p0, Landroid/graphics/Matrix;->native_instance:I

    return-void
.end method

.method public constructor <init>(Landroid/graphics/Matrix;)V
    .registers 3
    .parameter "src"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    if-eqz p1, :cond_e

    iget v0, p1, Landroid/graphics/Matrix;->native_instance:I

    :goto_7
    invoke-static {v0}, Landroid/graphics/Matrix;->native_create(I)I

    move-result v0

    iput v0, p0, Landroid/graphics/Matrix;->native_instance:I

    return-void

    :cond_e
    const/4 v0, 0x0

    goto :goto_7
.end method

.method private static checkPointArrays([FI[FII)V
    .registers 8
    .parameter "src"
    .parameter "srcIndex"
    .parameter "dst"
    .parameter "dstIndex"
    .parameter "pointCount"

    .prologue
    shl-int/lit8 v2, p4, 0x1

    add-int v1, p1, v2

    .local v1, srcStop:I
    shl-int/lit8 v2, p4, 0x1

    add-int v0, p3, v2

    .local v0, dstStop:I
    or-int v2, p4, p1

    or-int/2addr v2, p3

    or-int/2addr v2, v1

    or-int/2addr v2, v0

    if-ltz v2, :cond_15

    array-length v2, p0

    if-gt v1, v2, :cond_15

    array-length v2, p2

    if-le v0, v2, :cond_1b

    :cond_15
    new-instance v2, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v2}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v2

    :cond_1b
    return-void
.end method

.method private static native finalizer(I)V
.end method

.method private static native native_create(I)I
.end method

.method private static native native_equals(II)Z
.end method

.method private static native native_getValues(I[F)V
.end method

.method private static native native_invert(II)Z
.end method

.method private static native native_isIdentity(I)Z
.end method

.method private static native native_mapPoints(I[FI[FIIZ)V
.end method

.method private static native native_mapRadius(IF)F
.end method

.method private static native native_mapRect(ILandroid/graphics/RectF;Landroid/graphics/RectF;)Z
.end method

.method private static native native_postConcat(II)Z
.end method

.method private static native native_postRotate(IF)Z
.end method

.method private static native native_postRotate(IFFF)Z
.end method

.method private static native native_postScale(IFF)Z
.end method

.method private static native native_postScale(IFFFF)Z
.end method

.method private static native native_postSkew(IFF)Z
.end method

.method private static native native_postSkew(IFFFF)Z
.end method

.method private static native native_postTranslate(IFF)Z
.end method

.method private static native native_preConcat(II)Z
.end method

.method private static native native_preRotate(IF)Z
.end method

.method private static native native_preRotate(IFFF)Z
.end method

.method private static native native_preScale(IFF)Z
.end method

.method private static native native_preScale(IFFFF)Z
.end method

.method private static native native_preSkew(IFF)Z
.end method

.method private static native native_preSkew(IFFFF)Z
.end method

.method private static native native_preTranslate(IFF)Z
.end method

.method private static native native_rectStaysRect(I)Z
.end method

.method private static native native_reset(I)V
.end method

.method private static native native_set(II)V
.end method

.method private static native native_setConcat(III)Z
.end method

.method private static native native_setPolyToPoly(I[FI[FII)Z
.end method

.method private static native native_setRectToRect(ILandroid/graphics/RectF;Landroid/graphics/RectF;I)Z
.end method

.method private static native native_setRotate(IF)V
.end method

.method private static native native_setRotate(IFFF)V
.end method

.method private static native native_setScale(IFF)V
.end method

.method private static native native_setScale(IFFFF)V
.end method

.method private static native native_setSinCos(IFF)V
.end method

.method private static native native_setSinCos(IFFFF)V
.end method

.method private static native native_setSkew(IFF)V
.end method

.method private static native native_setSkew(IFFFF)V
.end method

.method private static native native_setTranslate(IFF)V
.end method

.method private static native native_setValues(I[F)V
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 4
    .parameter "obj"

    .prologue
    if-eqz p1, :cond_14

    instance-of v0, p1, Landroid/graphics/Matrix;

    if-eqz v0, :cond_14

    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    check-cast p1, Landroid/graphics/Matrix;

    .end local p1
    iget v1, p1, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, v1}, Landroid/graphics/Matrix;->native_equals(II)Z

    move-result v0

    if-eqz v0, :cond_14

    const/4 v0, 0x1

    :goto_13
    return v0

    :cond_14
    const/4 v0, 0x0

    goto :goto_13
.end method

.method protected finalize()V
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0}, Landroid/graphics/Matrix;->finalizer(I)V

    return-void
.end method

.method public getValues([F)V
    .registers 4
    .parameter "values"

    .prologue
    array-length v0, p1

    const/16 v1, 0x9

    if-ge v0, v1, :cond_b

    new-instance v0, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v0

    :cond_b
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, p1}, Landroid/graphics/Matrix;->native_getValues(I[F)V

    return-void
.end method

.method public invert(Landroid/graphics/Matrix;)Z
    .registers 4
    .parameter "inverse"

    .prologue
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    iget v1, p1, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, v1}, Landroid/graphics/Matrix;->native_invert(II)Z

    move-result v0

    return v0
.end method

.method public isIdentity()Z
    .registers 2

    .prologue
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0}, Landroid/graphics/Matrix;->native_isIdentity(I)Z

    move-result v0

    return v0
.end method

.method public mapPoints([F)V
    .registers 8
    .parameter "pts"

    .prologue
    const/4 v2, 0x0

    array-length v0, p1

    shr-int/lit8 v5, v0, 0x1

    move-object v0, p0

    move-object v1, p1

    move-object v3, p1

    move v4, v2

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Matrix;->mapPoints([FI[FII)V

    return-void
.end method

.method public mapPoints([FI[FII)V
    .registers 13
    .parameter "dst"
    .parameter "dstIndex"
    .parameter "src"
    .parameter "srcIndex"
    .parameter "pointCount"

    .prologue
    invoke-static {p3, p4, p1, p2, p5}, Landroid/graphics/Matrix;->checkPointArrays([FI[FII)V

    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    const/4 v6, 0x1

    move-object v1, p1

    move v2, p2

    move-object v3, p3

    move v4, p4

    move v5, p5

    invoke-static/range {v0 .. v6}, Landroid/graphics/Matrix;->native_mapPoints(I[FI[FIIZ)V

    return-void
.end method

.method public mapPoints([F[F)V
    .registers 9
    .parameter "dst"
    .parameter "src"

    .prologue
    const/4 v2, 0x0

    array-length v0, p1

    array-length v1, p2

    if-eq v0, v1, :cond_b

    new-instance v0, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v0

    :cond_b
    array-length v0, p1

    shr-int/lit8 v5, v0, 0x1

    move-object v0, p0

    move-object v1, p1

    move-object v3, p2

    move v4, v2

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Matrix;->mapPoints([FI[FII)V

    return-void
.end method

.method public mapRadius(F)F
    .registers 3
    .parameter "radius"

    .prologue
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, p1}, Landroid/graphics/Matrix;->native_mapRadius(IF)F

    move-result v0

    return v0
.end method

.method public mapRect(Landroid/graphics/RectF;)Z
    .registers 3
    .parameter "rect"

    .prologue
    invoke-virtual {p0, p1, p1}, Landroid/graphics/Matrix;->mapRect(Landroid/graphics/RectF;Landroid/graphics/RectF;)Z

    move-result v0

    return v0
.end method

.method public mapRect(Landroid/graphics/RectF;Landroid/graphics/RectF;)Z
    .registers 4
    .parameter "dst"
    .parameter "src"

    .prologue
    if-eqz p1, :cond_4

    if-nez p2, :cond_a

    :cond_4
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0

    :cond_a
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, p1, p2}, Landroid/graphics/Matrix;->native_mapRect(ILandroid/graphics/RectF;Landroid/graphics/RectF;)Z

    move-result v0

    return v0
.end method

.method public mapVectors([F)V
    .registers 8
    .parameter "vecs"

    .prologue
    const/4 v2, 0x0

    array-length v0, p1

    shr-int/lit8 v5, v0, 0x1

    move-object v0, p0

    move-object v1, p1

    move-object v3, p1

    move v4, v2

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Matrix;->mapVectors([FI[FII)V

    return-void
.end method

.method public mapVectors([FI[FII)V
    .registers 13
    .parameter "dst"
    .parameter "dstIndex"
    .parameter "src"
    .parameter "srcIndex"
    .parameter "vectorCount"

    .prologue
    invoke-static {p3, p4, p1, p2, p5}, Landroid/graphics/Matrix;->checkPointArrays([FI[FII)V

    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    const/4 v6, 0x0

    move-object v1, p1

    move v2, p2

    move-object v3, p3

    move v4, p4

    move v5, p5

    invoke-static/range {v0 .. v6}, Landroid/graphics/Matrix;->native_mapPoints(I[FI[FIIZ)V

    return-void
.end method

.method public mapVectors([F[F)V
    .registers 9
    .parameter "dst"
    .parameter "src"

    .prologue
    const/4 v2, 0x0

    array-length v0, p1

    array-length v1, p2

    if-eq v0, v1, :cond_b

    new-instance v0, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v0

    :cond_b
    array-length v0, p1

    shr-int/lit8 v5, v0, 0x1

    move-object v0, p0

    move-object v1, p1

    move-object v3, p2

    move v4, v2

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Matrix;->mapVectors([FI[FII)V

    return-void
.end method

.method final ni()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    return v0
.end method

.method public postConcat(Landroid/graphics/Matrix;)Z
    .registers 4
    .parameter "other"

    .prologue
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    iget v1, p1, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, v1}, Landroid/graphics/Matrix;->native_postConcat(II)Z

    move-result v0

    return v0
.end method

.method public postRotate(F)Z
    .registers 3
    .parameter "degrees"

    .prologue
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, p1}, Landroid/graphics/Matrix;->native_postRotate(IF)Z

    move-result v0

    return v0
.end method

.method public postRotate(FFF)Z
    .registers 5
    .parameter "degrees"
    .parameter "px"
    .parameter "py"

    .prologue
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, p1, p2, p3}, Landroid/graphics/Matrix;->native_postRotate(IFFF)Z

    move-result v0

    return v0
.end method

.method public postScale(FF)Z
    .registers 4
    .parameter "sx"
    .parameter "sy"

    .prologue
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, p1, p2}, Landroid/graphics/Matrix;->native_postScale(IFF)Z

    move-result v0

    return v0
.end method

.method public postScale(FFFF)Z
    .registers 6
    .parameter "sx"
    .parameter "sy"
    .parameter "px"
    .parameter "py"

    .prologue
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, p1, p2, p3, p4}, Landroid/graphics/Matrix;->native_postScale(IFFFF)Z

    move-result v0

    return v0
.end method

.method public postSkew(FF)Z
    .registers 4
    .parameter "kx"
    .parameter "ky"

    .prologue
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, p1, p2}, Landroid/graphics/Matrix;->native_postSkew(IFF)Z

    move-result v0

    return v0
.end method

.method public postSkew(FFFF)Z
    .registers 6
    .parameter "kx"
    .parameter "ky"
    .parameter "px"
    .parameter "py"

    .prologue
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, p1, p2, p3, p4}, Landroid/graphics/Matrix;->native_postSkew(IFFFF)Z

    move-result v0

    return v0
.end method

.method public postTranslate(FF)Z
    .registers 4
    .parameter "dx"
    .parameter "dy"

    .prologue
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, p1, p2}, Landroid/graphics/Matrix;->native_postTranslate(IFF)Z

    move-result v0

    return v0
.end method

.method public preConcat(Landroid/graphics/Matrix;)Z
    .registers 4
    .parameter "other"

    .prologue
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    iget v1, p1, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, v1}, Landroid/graphics/Matrix;->native_preConcat(II)Z

    move-result v0

    return v0
.end method

.method public preRotate(F)Z
    .registers 3
    .parameter "degrees"

    .prologue
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, p1}, Landroid/graphics/Matrix;->native_preRotate(IF)Z

    move-result v0

    return v0
.end method

.method public preRotate(FFF)Z
    .registers 5
    .parameter "degrees"
    .parameter "px"
    .parameter "py"

    .prologue
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, p1, p2, p3}, Landroid/graphics/Matrix;->native_preRotate(IFFF)Z

    move-result v0

    return v0
.end method

.method public preScale(FF)Z
    .registers 4
    .parameter "sx"
    .parameter "sy"

    .prologue
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, p1, p2}, Landroid/graphics/Matrix;->native_preScale(IFF)Z

    move-result v0

    return v0
.end method

.method public preScale(FFFF)Z
    .registers 6
    .parameter "sx"
    .parameter "sy"
    .parameter "px"
    .parameter "py"

    .prologue
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, p1, p2, p3, p4}, Landroid/graphics/Matrix;->native_preScale(IFFFF)Z

    move-result v0

    return v0
.end method

.method public preSkew(FF)Z
    .registers 4
    .parameter "kx"
    .parameter "ky"

    .prologue
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, p1, p2}, Landroid/graphics/Matrix;->native_preSkew(IFF)Z

    move-result v0

    return v0
.end method

.method public preSkew(FFFF)Z
    .registers 6
    .parameter "kx"
    .parameter "ky"
    .parameter "px"
    .parameter "py"

    .prologue
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, p1, p2, p3, p4}, Landroid/graphics/Matrix;->native_preSkew(IFFFF)Z

    move-result v0

    return v0
.end method

.method public preTranslate(FF)Z
    .registers 4
    .parameter "dx"
    .parameter "dy"

    .prologue
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, p1, p2}, Landroid/graphics/Matrix;->native_preTranslate(IFF)Z

    move-result v0

    return v0
.end method

.method public printShortString(Ljava/io/PrintWriter;)V
    .registers 4
    .parameter "pw"

    .prologue
    const/16 v1, 0x9

    new-array v0, v1, [F

    .local v0, values:[F
    invoke-virtual {p0, v0}, Landroid/graphics/Matrix;->getValues([F)V

    const/16 v1, 0x5b

    invoke-virtual {p1, v1}, Ljava/io/PrintWriter;->print(C)V

    const/4 v1, 0x0

    aget v1, v0, v1

    invoke-virtual {p1, v1}, Ljava/io/PrintWriter;->print(F)V

    const-string v1, ", "

    invoke-virtual {p1, v1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const/4 v1, 0x1

    aget v1, v0, v1

    invoke-virtual {p1, v1}, Ljava/io/PrintWriter;->print(F)V

    const-string v1, ", "

    invoke-virtual {p1, v1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const/4 v1, 0x2

    aget v1, v0, v1

    invoke-virtual {p1, v1}, Ljava/io/PrintWriter;->print(F)V

    const-string v1, "]["

    invoke-virtual {p1, v1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const/4 v1, 0x3

    aget v1, v0, v1

    invoke-virtual {p1, v1}, Ljava/io/PrintWriter;->print(F)V

    const-string v1, ", "

    invoke-virtual {p1, v1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const/4 v1, 0x4

    aget v1, v0, v1

    invoke-virtual {p1, v1}, Ljava/io/PrintWriter;->print(F)V

    const-string v1, ", "

    invoke-virtual {p1, v1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const/4 v1, 0x5

    aget v1, v0, v1

    invoke-virtual {p1, v1}, Ljava/io/PrintWriter;->print(F)V

    const-string v1, "]["

    invoke-virtual {p1, v1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const/4 v1, 0x6

    aget v1, v0, v1

    invoke-virtual {p1, v1}, Ljava/io/PrintWriter;->print(F)V

    const-string v1, ", "

    invoke-virtual {p1, v1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const/4 v1, 0x7

    aget v1, v0, v1

    invoke-virtual {p1, v1}, Ljava/io/PrintWriter;->print(F)V

    const-string v1, ", "

    invoke-virtual {p1, v1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const/16 v1, 0x8

    aget v1, v0, v1

    invoke-virtual {p1, v1}, Ljava/io/PrintWriter;->print(F)V

    const/16 v1, 0x5d

    invoke-virtual {p1, v1}, Ljava/io/PrintWriter;->print(C)V

    return-void
.end method

.method public rectStaysRect()Z
    .registers 2

    .prologue
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0}, Landroid/graphics/Matrix;->native_rectStaysRect(I)Z

    move-result v0

    return v0
.end method

.method public reset()V
    .registers 2

    .prologue
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0}, Landroid/graphics/Matrix;->native_reset(I)V

    return-void
.end method

.method public set(Landroid/graphics/Matrix;)V
    .registers 4
    .parameter "src"

    .prologue
    if-nez p1, :cond_6

    invoke-virtual {p0}, Landroid/graphics/Matrix;->reset()V

    :goto_5
    return-void

    :cond_6
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    iget v1, p1, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, v1}, Landroid/graphics/Matrix;->native_set(II)V

    goto :goto_5
.end method

.method public setConcat(Landroid/graphics/Matrix;Landroid/graphics/Matrix;)Z
    .registers 6
    .parameter "a"
    .parameter "b"

    .prologue
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    iget v1, p1, Landroid/graphics/Matrix;->native_instance:I

    iget v2, p2, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, v1, v2}, Landroid/graphics/Matrix;->native_setConcat(III)Z

    move-result v0

    return v0
.end method

.method public setPolyToPoly([FI[FII)Z
    .registers 12
    .parameter "src"
    .parameter "srcIndex"
    .parameter "dst"
    .parameter "dstIndex"
    .parameter "pointCount"

    .prologue
    const/4 v0, 0x4

    if-le p5, v0, :cond_9

    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0

    :cond_9
    invoke-static {p1, p2, p3, p4, p5}, Landroid/graphics/Matrix;->checkPointArrays([FI[FII)V

    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    move-object v1, p1

    move v2, p2

    move-object v3, p3

    move v4, p4

    move v5, p5

    invoke-static/range {v0 .. v5}, Landroid/graphics/Matrix;->native_setPolyToPoly(I[FI[FII)Z

    move-result v0

    return v0
.end method

.method public setRectToRect(Landroid/graphics/RectF;Landroid/graphics/RectF;Landroid/graphics/Matrix$ScaleToFit;)Z
    .registers 6
    .parameter "src"
    .parameter "dst"
    .parameter "stf"

    .prologue
    if-eqz p2, :cond_4

    if-nez p1, :cond_a

    :cond_4
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0

    :cond_a
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    iget v1, p3, Landroid/graphics/Matrix$ScaleToFit;->nativeInt:I

    invoke-static {v0, p1, p2, v1}, Landroid/graphics/Matrix;->native_setRectToRect(ILandroid/graphics/RectF;Landroid/graphics/RectF;I)Z

    move-result v0

    return v0
.end method

.method public setRotate(F)V
    .registers 3
    .parameter "degrees"

    .prologue
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, p1}, Landroid/graphics/Matrix;->native_setRotate(IF)V

    return-void
.end method

.method public setRotate(FFF)V
    .registers 5
    .parameter "degrees"
    .parameter "px"
    .parameter "py"

    .prologue
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, p1, p2, p3}, Landroid/graphics/Matrix;->native_setRotate(IFFF)V

    return-void
.end method

.method public setScale(FF)V
    .registers 4
    .parameter "sx"
    .parameter "sy"

    .prologue
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, p1, p2}, Landroid/graphics/Matrix;->native_setScale(IFF)V

    return-void
.end method

.method public setScale(FFFF)V
    .registers 6
    .parameter "sx"
    .parameter "sy"
    .parameter "px"
    .parameter "py"

    .prologue
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, p1, p2, p3, p4}, Landroid/graphics/Matrix;->native_setScale(IFFFF)V

    return-void
.end method

.method public setSinCos(FF)V
    .registers 4
    .parameter "sinValue"
    .parameter "cosValue"

    .prologue
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, p1, p2}, Landroid/graphics/Matrix;->native_setSinCos(IFF)V

    return-void
.end method

.method public setSinCos(FFFF)V
    .registers 6
    .parameter "sinValue"
    .parameter "cosValue"
    .parameter "px"
    .parameter "py"

    .prologue
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, p1, p2, p3, p4}, Landroid/graphics/Matrix;->native_setSinCos(IFFFF)V

    return-void
.end method

.method public setSkew(FF)V
    .registers 4
    .parameter "kx"
    .parameter "ky"

    .prologue
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, p1, p2}, Landroid/graphics/Matrix;->native_setSkew(IFF)V

    return-void
.end method

.method public setSkew(FFFF)V
    .registers 6
    .parameter "kx"
    .parameter "ky"
    .parameter "px"
    .parameter "py"

    .prologue
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, p1, p2, p3, p4}, Landroid/graphics/Matrix;->native_setSkew(IFFFF)V

    return-void
.end method

.method public setTranslate(FF)V
    .registers 4
    .parameter "dx"
    .parameter "dy"

    .prologue
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, p1, p2}, Landroid/graphics/Matrix;->native_setTranslate(IFF)V

    return-void
.end method

.method public setValues([F)V
    .registers 4
    .parameter "values"

    .prologue
    array-length v0, p1

    const/16 v1, 0x9

    if-ge v0, v1, :cond_b

    new-instance v0, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v0

    :cond_b
    iget v0, p0, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, p1}, Landroid/graphics/Matrix;->native_setValues(I[F)V

    return-void
.end method

.method public toShortString()Ljava/lang/String;
    .registers 3

    .prologue
    new-instance v0, Ljava/lang/StringBuilder;

    const/16 v1, 0x40

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    .local v0, sb:Ljava/lang/StringBuilder;
    invoke-virtual {p0, v0}, Landroid/graphics/Matrix;->toShortString(Ljava/lang/StringBuilder;)V

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public toShortString(Ljava/lang/StringBuilder;)V
    .registers 4
    .parameter "sb"

    .prologue
    const/16 v1, 0x9

    new-array v0, v1, [F

    .local v0, values:[F
    invoke-virtual {p0, v0}, Landroid/graphics/Matrix;->getValues([F)V

    const/16 v1, 0x5b

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    const/4 v1, 0x0

    aget v1, v0, v1

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    const-string v1, ", "

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/4 v1, 0x1

    aget v1, v0, v1

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    const-string v1, ", "

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/4 v1, 0x2

    aget v1, v0, v1

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    const-string v1, "]["

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/4 v1, 0x3

    aget v1, v0, v1

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    const-string v1, ", "

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/4 v1, 0x4

    aget v1, v0, v1

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    const-string v1, ", "

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/4 v1, 0x5

    aget v1, v0, v1

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    const-string v1, "]["

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/4 v1, 0x6

    aget v1, v0, v1

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    const-string v1, ", "

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/4 v1, 0x7

    aget v1, v0, v1

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    const-string v1, ", "

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/16 v1, 0x8

    aget v1, v0, v1

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    const/16 v1, 0x5d

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    .prologue
    new-instance v0, Ljava/lang/StringBuilder;

    const/16 v1, 0x40

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    .local v0, sb:Ljava/lang/StringBuilder;
    const-string v1, "Matrix{"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p0, v0}, Landroid/graphics/Matrix;->toShortString(Ljava/lang/StringBuilder;)V

    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
