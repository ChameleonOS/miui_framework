.class public Landroid/graphics/PathMeasure;
.super Ljava/lang/Object;
.source "PathMeasure.java"


# static fields
.field public static final POSITION_MATRIX_FLAG:I = 0x1

.field public static final TANGENT_MATRIX_FLAG:I = 0x2


# instance fields
.field private mPath:Landroid/graphics/Path;

.field private final native_instance:I


# direct methods
.method public constructor <init>()V
    .registers 3

    .prologue
    const/4 v1, 0x0

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Landroid/graphics/PathMeasure;->mPath:Landroid/graphics/Path;

    invoke-static {v1, v1}, Landroid/graphics/PathMeasure;->native_create(IZ)I

    move-result v0

    iput v0, p0, Landroid/graphics/PathMeasure;->native_instance:I

    return-void
.end method

.method public constructor <init>(Landroid/graphics/Path;Z)V
    .registers 4
    .parameter "path"
    .parameter "forceClosed"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroid/graphics/PathMeasure;->mPath:Landroid/graphics/Path;

    if-eqz p1, :cond_12

    invoke-virtual {p1}, Landroid/graphics/Path;->ni()I

    move-result v0

    :goto_b
    invoke-static {v0, p2}, Landroid/graphics/PathMeasure;->native_create(IZ)I

    move-result v0

    iput v0, p0, Landroid/graphics/PathMeasure;->native_instance:I

    return-void

    :cond_12
    const/4 v0, 0x0

    goto :goto_b
.end method

.method private static native native_create(IZ)I
.end method

.method private static native native_destroy(I)V
.end method

.method private static native native_getLength(I)F
.end method

.method private static native native_getMatrix(IFII)Z
.end method

.method private static native native_getPosTan(IF[F[F)Z
.end method

.method private static native native_getSegment(IFFIZ)Z
.end method

.method private static native native_isClosed(I)Z
.end method

.method private static native native_nextContour(I)Z
.end method

.method private static native native_setPath(IIZ)V
.end method


# virtual methods
.method protected finalize()V
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    iget v0, p0, Landroid/graphics/PathMeasure;->native_instance:I

    invoke-static {v0}, Landroid/graphics/PathMeasure;->native_destroy(I)V

    return-void
.end method

.method public getLength()F
    .registers 2

    .prologue
    iget v0, p0, Landroid/graphics/PathMeasure;->native_instance:I

    invoke-static {v0}, Landroid/graphics/PathMeasure;->native_getLength(I)F

    move-result v0

    return v0
.end method

.method public getMatrix(FLandroid/graphics/Matrix;I)Z
    .registers 6
    .parameter "distance"
    .parameter "matrix"
    .parameter "flags"

    .prologue
    iget v0, p0, Landroid/graphics/PathMeasure;->native_instance:I

    iget v1, p2, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, p1, v1, p3}, Landroid/graphics/PathMeasure;->native_getMatrix(IFII)Z

    move-result v0

    return v0
.end method

.method public getPosTan(F[F[F)Z
    .registers 6
    .parameter "distance"
    .parameter "pos"
    .parameter "tan"

    .prologue
    const/4 v1, 0x2

    if-eqz p2, :cond_6

    array-length v0, p2

    if-lt v0, v1, :cond_b

    :cond_6
    if-eqz p3, :cond_11

    array-length v0, p3

    if-ge v0, v1, :cond_11

    :cond_b
    new-instance v0, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v0

    :cond_11
    iget v0, p0, Landroid/graphics/PathMeasure;->native_instance:I

    invoke-static {v0, p1, p2, p3}, Landroid/graphics/PathMeasure;->native_getPosTan(IF[F[F)Z

    move-result v0

    return v0
.end method

.method public getSegment(FFLandroid/graphics/Path;Z)Z
    .registers 7
    .parameter "startD"
    .parameter "stopD"
    .parameter "dst"
    .parameter "startWithMoveTo"

    .prologue
    iget v0, p0, Landroid/graphics/PathMeasure;->native_instance:I

    invoke-virtual {p3}, Landroid/graphics/Path;->ni()I

    move-result v1

    invoke-static {v0, p1, p2, v1, p4}, Landroid/graphics/PathMeasure;->native_getSegment(IFFIZ)Z

    move-result v0

    return v0
.end method

.method public isClosed()Z
    .registers 2

    .prologue
    iget v0, p0, Landroid/graphics/PathMeasure;->native_instance:I

    invoke-static {v0}, Landroid/graphics/PathMeasure;->native_isClosed(I)Z

    move-result v0

    return v0
.end method

.method public nextContour()Z
    .registers 2

    .prologue
    iget v0, p0, Landroid/graphics/PathMeasure;->native_instance:I

    invoke-static {v0}, Landroid/graphics/PathMeasure;->native_nextContour(I)Z

    move-result v0

    return v0
.end method

.method public setPath(Landroid/graphics/Path;Z)V
    .registers 5
    .parameter "path"
    .parameter "forceClosed"

    .prologue
    iput-object p1, p0, Landroid/graphics/PathMeasure;->mPath:Landroid/graphics/Path;

    iget v1, p0, Landroid/graphics/PathMeasure;->native_instance:I

    if-eqz p1, :cond_e

    invoke-virtual {p1}, Landroid/graphics/Path;->ni()I

    move-result v0

    :goto_a
    invoke-static {v1, v0, p2}, Landroid/graphics/PathMeasure;->native_setPath(IIZ)V

    return-void

    :cond_e
    const/4 v0, 0x0

    goto :goto_a
.end method
