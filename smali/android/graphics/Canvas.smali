.class public Landroid/graphics/Canvas;
.super Ljava/lang/Object;
.source "Canvas.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/graphics/Canvas$VertexMode;,
        Landroid/graphics/Canvas$EdgeType;,
        Landroid/graphics/Canvas$CanvasFinalizer;
    }
.end annotation


# static fields
.field public static final ALL_SAVE_FLAG:I = 0x1f

.field public static final CLIP_SAVE_FLAG:I = 0x2

.field public static final CLIP_TO_LAYER_SAVE_FLAG:I = 0x10

.field public static final DIRECTION_LTR:I = 0x0

.field public static final DIRECTION_RTL:I = 0x1

.field public static final FULL_COLOR_LAYER_SAVE_FLAG:I = 0x8

.field public static final HAS_ALPHA_LAYER_SAVE_FLAG:I = 0x4

.field public static final MATRIX_SAVE_FLAG:I = 0x1

.field private static final MAXMIMUM_BITMAP_SIZE:I = 0x7ffe


# instance fields
.field private mBitmap:Landroid/graphics/Bitmap;

.field protected mDensity:I

.field private mDrawFilter:Landroid/graphics/DrawFilter;

.field private final mFinalizer:Landroid/graphics/Canvas$CanvasFinalizer;

.field final mNativeCanvas:I

.field protected mScreenDensity:I

.field private mSurfaceFormat:I


# direct methods
.method public constructor <init>()V
    .registers 3

    .prologue
    const/4 v0, 0x0

    .line 110
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 52
    iput v0, p0, Landroid/graphics/Canvas;->mDensity:I

    .line 59
    iput v0, p0, Landroid/graphics/Canvas;->mScreenDensity:I

    .line 112
    invoke-static {v0}, Landroid/graphics/Canvas;->initRaster(I)I

    move-result v0

    iput v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    .line 113
    new-instance v0, Landroid/graphics/Canvas$CanvasFinalizer;

    iget v1, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    invoke-direct {v0, v1}, Landroid/graphics/Canvas$CanvasFinalizer;-><init>(I)V

    iput-object v0, p0, Landroid/graphics/Canvas;->mFinalizer:Landroid/graphics/Canvas$CanvasFinalizer;

    .line 114
    return-void
.end method

.method constructor <init>(I)V
    .registers 3
    .parameter "nativeCanvas"

    .prologue
    const/4 v0, 0x0

    .line 136
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 52
    iput v0, p0, Landroid/graphics/Canvas;->mDensity:I

    .line 59
    iput v0, p0, Landroid/graphics/Canvas;->mScreenDensity:I

    .line 137
    if-nez p1, :cond_10

    .line 138
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    .line 140
    :cond_10
    iput p1, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    .line 141
    new-instance v0, Landroid/graphics/Canvas$CanvasFinalizer;

    invoke-direct {v0, p1}, Landroid/graphics/Canvas$CanvasFinalizer;-><init>(I)V

    iput-object v0, p0, Landroid/graphics/Canvas;->mFinalizer:Landroid/graphics/Canvas$CanvasFinalizer;

    .line 142
    invoke-static {}, Landroid/graphics/Bitmap;->getDefaultDensity()I

    move-result v0

    iput v0, p0, Landroid/graphics/Canvas;->mDensity:I

    .line 143
    return-void
.end method

.method public constructor <init>(Landroid/graphics/Bitmap;)V
    .registers 4
    .parameter "bitmap"

    .prologue
    const/4 v0, 0x0

    .line 125
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 52
    iput v0, p0, Landroid/graphics/Canvas;->mDensity:I

    .line 59
    iput v0, p0, Landroid/graphics/Canvas;->mScreenDensity:I

    .line 126
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->isMutable()Z

    move-result v0

    if-nez v0, :cond_16

    .line 127
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Immutable bitmap passed to Canvas constructor"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 129
    :cond_16
    invoke-static {p1}, Landroid/graphics/Canvas;->throwIfRecycled(Landroid/graphics/Bitmap;)V

    .line 130
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->ni()I

    move-result v0

    invoke-static {v0}, Landroid/graphics/Canvas;->initRaster(I)I

    move-result v0

    iput v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    .line 131
    new-instance v0, Landroid/graphics/Canvas$CanvasFinalizer;

    iget v1, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    invoke-direct {v0, v1}, Landroid/graphics/Canvas$CanvasFinalizer;-><init>(I)V

    iput-object v0, p0, Landroid/graphics/Canvas;->mFinalizer:Landroid/graphics/Canvas$CanvasFinalizer;

    .line 132
    iput-object p1, p0, Landroid/graphics/Canvas;->mBitmap:Landroid/graphics/Bitmap;

    .line 133
    iget v0, p1, Landroid/graphics/Bitmap;->mDensity:I

    iput v0, p0, Landroid/graphics/Canvas;->mDensity:I

    .line 134
    return-void
.end method

.method static synthetic access$000(I)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 39
    invoke-static {p0}, Landroid/graphics/Canvas;->finalizer(I)V

    return-void
.end method

.method protected static checkRange(III)V
    .registers 4
    .parameter "length"
    .parameter "offset"
    .parameter "count"

    .prologue
    .line 1203
    or-int v0, p1, p2

    if-ltz v0, :cond_8

    add-int v0, p1, p2

    if-le v0, p0, :cond_e

    .line 1204
    :cond_8
    new-instance v0, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v0

    .line 1206
    :cond_e
    return-void
.end method

.method private static native finalizer(I)V
.end method

.method public static native freeCaches()V
.end method

.method public static native freeTextLayoutCaches()V
.end method

.method private static native initRaster(I)I
.end method

.method private static native nativeDrawBitmapMatrix(IIII)V
.end method

.method private static native nativeDrawBitmapMesh(IIII[FI[III)V
.end method

.method private static native nativeDrawVertices(III[FI[FI[II[SIII)V
.end method

.method private static native nativeSetDrawFilter(II)V
.end method

.method private static native native_clipPath(III)Z
.end method

.method private static native native_clipRect(IFFFFI)Z
.end method

.method private static native native_clipRegion(III)Z
.end method

.method private static native native_concat(II)V
.end method

.method private static native native_drawARGB(IIIII)V
.end method

.method private static native native_drawArc(ILandroid/graphics/RectF;FFZI)V
.end method

.method private native native_drawBitmap(IIFFIIII)V
.end method

.method private static native native_drawBitmap(IILandroid/graphics/Rect;Landroid/graphics/Rect;III)V
.end method

.method private native native_drawBitmap(IILandroid/graphics/Rect;Landroid/graphics/RectF;III)V
.end method

.method private static native native_drawBitmap(I[IIIFFIIZI)V
.end method

.method private static native native_drawCircle(IFFFI)V
.end method

.method private static native native_drawColor(II)V
.end method

.method private static native native_drawColor(III)V
.end method

.method private static native native_drawLine(IFFFFI)V
.end method

.method private static native native_drawOval(ILandroid/graphics/RectF;I)V
.end method

.method private static native native_drawPaint(II)V
.end method

.method private static native native_drawPath(III)V
.end method

.method private static native native_drawPicture(II)V
.end method

.method private static native native_drawPosText(ILjava/lang/String;[FI)V
.end method

.method private static native native_drawPosText(I[CII[FI)V
.end method

.method private static native native_drawRGB(IIII)V
.end method

.method private static native native_drawRect(IFFFFI)V
.end method

.method private static native native_drawRect(ILandroid/graphics/RectF;I)V
.end method

.method private static native native_drawRoundRect(ILandroid/graphics/RectF;FFI)V
.end method

.method private static native native_drawText(ILjava/lang/String;IIFFII)V
.end method

.method private static native native_drawText(I[CIIFFII)V
.end method

.method private static native native_drawTextOnPath(ILjava/lang/String;IFFII)V
.end method

.method private static native native_drawTextOnPath(I[CIIIFFII)V
.end method

.method private static native native_drawTextRun(ILjava/lang/String;IIIIFFII)V
.end method

.method private static native native_drawTextRun(I[CIIIIFFII)V
.end method

.method private static native native_getCTM(II)V
.end method

.method private static native native_getClipBounds(ILandroid/graphics/Rect;)Z
.end method

.method private static native native_quickReject(IFFFFI)Z
.end method

.method private static native native_quickReject(III)Z
.end method

.method private static native native_quickReject(ILandroid/graphics/RectF;I)Z
.end method

.method private static native native_saveLayer(IFFFFII)I
.end method

.method private static native native_saveLayer(ILandroid/graphics/RectF;II)I
.end method

.method private static native native_saveLayerAlpha(IFFFFII)I
.end method

.method private static native native_saveLayerAlpha(ILandroid/graphics/RectF;II)I
.end method

.method private static native native_setBitmap(II)V
.end method

.method private static native native_setMatrix(II)V
.end method

.method private static throwIfRecycled(Landroid/graphics/Bitmap;)V
    .registers 4
    .parameter "bitmap"

    .prologue
    .line 1025
    invoke-virtual {p0}, Landroid/graphics/Bitmap;->isRecycled()Z

    move-result v0

    if-eqz v0, :cond_1f

    .line 1026
    new-instance v0, Ljava/lang/RuntimeException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Canvas: trying to use a recycled bitmap "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1028
    :cond_1f
    return-void
.end method


# virtual methods
.method public clipPath(Landroid/graphics/Path;)Z
    .registers 3
    .parameter "path"

    .prologue
    .line 638
    sget-object v0, Landroid/graphics/Region$Op;->INTERSECT:Landroid/graphics/Region$Op;

    invoke-virtual {p0, p1, v0}, Landroid/graphics/Canvas;->clipPath(Landroid/graphics/Path;Landroid/graphics/Region$Op;)Z

    move-result v0

    return v0
.end method

.method public clipPath(Landroid/graphics/Path;Landroid/graphics/Region$Op;)Z
    .registers 6
    .parameter "path"
    .parameter "op"

    .prologue
    .line 628
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    invoke-virtual {p1}, Landroid/graphics/Path;->ni()I

    move-result v1

    iget v2, p2, Landroid/graphics/Region$Op;->nativeInt:I

    invoke-static {v0, v1, v2}, Landroid/graphics/Canvas;->native_clipPath(III)Z

    move-result v0

    return v0
.end method

.method public native clipRect(FFFF)Z
.end method

.method public clipRect(FFFFLandroid/graphics/Region$Op;)Z
    .registers 12
    .parameter "left"
    .parameter "top"
    .parameter "right"
    .parameter "bottom"
    .parameter "op"

    .prologue
    .line 587
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    iget v5, p5, Landroid/graphics/Region$Op;->nativeInt:I

    move v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    invoke-static/range {v0 .. v5}, Landroid/graphics/Canvas;->native_clipRect(IFFFFI)Z

    move-result v0

    return v0
.end method

.method public native clipRect(IIII)Z
.end method

.method public native clipRect(Landroid/graphics/Rect;)Z
.end method

.method public clipRect(Landroid/graphics/Rect;Landroid/graphics/Region$Op;)Z
    .registers 9
    .parameter "rect"
    .parameter "op"

    .prologue
    .line 549
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    iget v1, p1, Landroid/graphics/Rect;->left:I

    int-to-float v1, v1

    iget v2, p1, Landroid/graphics/Rect;->top:I

    int-to-float v2, v2

    iget v3, p1, Landroid/graphics/Rect;->right:I

    int-to-float v3, v3

    iget v4, p1, Landroid/graphics/Rect;->bottom:I

    int-to-float v4, v4

    iget v5, p2, Landroid/graphics/Region$Op;->nativeInt:I

    invoke-static/range {v0 .. v5}, Landroid/graphics/Canvas;->native_clipRect(IFFFFI)Z

    move-result v0

    return v0
.end method

.method public native clipRect(Landroid/graphics/RectF;)Z
.end method

.method public clipRect(Landroid/graphics/RectF;Landroid/graphics/Region$Op;)Z
    .registers 9
    .parameter "rect"
    .parameter "op"

    .prologue
    .line 536
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    iget v1, p1, Landroid/graphics/RectF;->left:F

    iget v2, p1, Landroid/graphics/RectF;->top:F

    iget v3, p1, Landroid/graphics/RectF;->right:F

    iget v4, p1, Landroid/graphics/RectF;->bottom:F

    iget v5, p2, Landroid/graphics/Region$Op;->nativeInt:I

    invoke-static/range {v0 .. v5}, Landroid/graphics/Canvas;->native_clipRect(IFFFFI)Z

    move-result v0

    return v0
.end method

.method public clipRegion(Landroid/graphics/Region;)Z
    .registers 3
    .parameter "region"

    .prologue
    .line 667
    sget-object v0, Landroid/graphics/Region$Op;->INTERSECT:Landroid/graphics/Region$Op;

    invoke-virtual {p0, p1, v0}, Landroid/graphics/Canvas;->clipRegion(Landroid/graphics/Region;Landroid/graphics/Region$Op;)Z

    move-result v0

    return v0
.end method

.method public clipRegion(Landroid/graphics/Region;Landroid/graphics/Region$Op;)Z
    .registers 6
    .parameter "region"
    .parameter "op"

    .prologue
    .line 653
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    invoke-virtual {p1}, Landroid/graphics/Region;->ni()I

    move-result v1

    iget v2, p2, Landroid/graphics/Region$Op;->nativeInt:I

    invoke-static {v0, v1, v2}, Landroid/graphics/Canvas;->native_clipRegion(III)Z

    move-result v0

    return v0
.end method

.method public concat(Landroid/graphics/Matrix;)V
    .registers 4
    .parameter "matrix"

    .prologue
    .line 486
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    iget v1, p1, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, v1}, Landroid/graphics/Canvas;->native_concat(II)V

    .line 487
    return-void
.end method

.method public drawARGB(IIII)V
    .registers 6
    .parameter "a"
    .parameter "r"
    .parameter "g"
    .parameter "b"

    .prologue
    .line 801
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    invoke-static {v0, p1, p2, p3, p4}, Landroid/graphics/Canvas;->native_drawARGB(IIIII)V

    .line 802
    return-void
.end method

.method public drawArc(Landroid/graphics/RectF;FFZLandroid/graphics/Paint;)V
    .registers 12
    .parameter "oval"
    .parameter "startAngle"
    .parameter "sweepAngle"
    .parameter "useCenter"
    .parameter "paint"

    .prologue
    .line 989
    if-nez p1, :cond_8

    .line 990
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0

    .line 992
    :cond_8
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    iget v5, p5, Landroid/graphics/Paint;->mNativePaint:I

    move-object v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    invoke-static/range {v0 .. v5}, Landroid/graphics/Canvas;->native_drawArc(ILandroid/graphics/RectF;FFZI)V

    .line 994
    return-void
.end method

.method public drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    .registers 14
    .parameter "bitmap"
    .parameter "left"
    .parameter "top"
    .parameter "paint"

    .prologue
    .line 1065
    invoke-static {p1}, Landroid/graphics/Canvas;->throwIfRecycled(Landroid/graphics/Bitmap;)V

    .line 1066
    iget v1, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->ni()I

    move-result v2

    if-eqz p4, :cond_1a

    iget v5, p4, Landroid/graphics/Paint;->mNativePaint:I

    :goto_d
    iget v6, p0, Landroid/graphics/Canvas;->mDensity:I

    iget v7, p0, Landroid/graphics/Canvas;->mScreenDensity:I

    iget v8, p1, Landroid/graphics/Bitmap;->mDensity:I

    move-object v0, p0

    move v3, p2

    move v4, p3

    invoke-direct/range {v0 .. v8}, Landroid/graphics/Canvas;->native_drawBitmap(IIFFIIII)V

    .line 1068
    return-void

    .line 1066
    :cond_1a
    const/4 v5, 0x0

    goto :goto_d
.end method

.method public drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
    .registers 8
    .parameter "bitmap"
    .parameter "matrix"
    .parameter "paint"

    .prologue
    .line 1195
    iget v1, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->ni()I

    move-result v2

    invoke-virtual {p2}, Landroid/graphics/Matrix;->ni()I

    move-result v3

    if-eqz p3, :cond_12

    iget v0, p3, Landroid/graphics/Paint;->mNativePaint:I

    :goto_e
    invoke-static {v1, v2, v3, v0}, Landroid/graphics/Canvas;->nativeDrawBitmapMatrix(IIII)V

    .line 1197
    return-void

    .line 1195
    :cond_12
    const/4 v0, 0x0

    goto :goto_e
.end method

.method public drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    .registers 12
    .parameter "bitmap"
    .parameter "src"
    .parameter "dst"
    .parameter "paint"

    .prologue
    .line 1124
    if-nez p3, :cond_8

    .line 1125
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0

    .line 1127
    :cond_8
    invoke-static {p1}, Landroid/graphics/Canvas;->throwIfRecycled(Landroid/graphics/Bitmap;)V

    .line 1128
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->ni()I

    move-result v1

    if-eqz p4, :cond_1f

    iget v4, p4, Landroid/graphics/Paint;->mNativePaint:I

    :goto_15
    iget v5, p0, Landroid/graphics/Canvas;->mScreenDensity:I

    iget v6, p1, Landroid/graphics/Bitmap;->mDensity:I

    move-object v2, p2

    move-object v3, p3

    invoke-static/range {v0 .. v6}, Landroid/graphics/Canvas;->native_drawBitmap(IILandroid/graphics/Rect;Landroid/graphics/Rect;III)V

    .line 1130
    return-void

    .line 1128
    :cond_1f
    const/4 v4, 0x0

    goto :goto_15
.end method

.method public drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    .registers 13
    .parameter "bitmap"
    .parameter "src"
    .parameter "dst"
    .parameter "paint"

    .prologue
    .line 1093
    if-nez p3, :cond_8

    .line 1094
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0

    .line 1096
    :cond_8
    invoke-static {p1}, Landroid/graphics/Canvas;->throwIfRecycled(Landroid/graphics/Bitmap;)V

    .line 1097
    iget v1, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->ni()I

    move-result v2

    if-eqz p4, :cond_20

    iget v5, p4, Landroid/graphics/Paint;->mNativePaint:I

    :goto_15
    iget v6, p0, Landroid/graphics/Canvas;->mScreenDensity:I

    iget v7, p1, Landroid/graphics/Bitmap;->mDensity:I

    move-object v0, p0

    move-object v3, p2

    move-object v4, p3

    invoke-direct/range {v0 .. v7}, Landroid/graphics/Canvas;->native_drawBitmap(IILandroid/graphics/Rect;Landroid/graphics/RectF;III)V

    .line 1099
    return-void

    .line 1097
    :cond_20
    const/4 v5, 0x0

    goto :goto_15
.end method

.method public drawBitmap([IIIFFIIZLandroid/graphics/Paint;)V
    .registers 23
    .parameter "colors"
    .parameter "offset"
    .parameter "stride"
    .parameter "x"
    .parameter "y"
    .parameter "width"
    .parameter "height"
    .parameter "hasAlpha"
    .parameter "paint"

    .prologue
    .line 1154
    if-gez p6, :cond_b

    .line 1155
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "width must be >= 0"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1157
    :cond_b
    if-gez p7, :cond_15

    .line 1158
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "height must be >= 0"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1160
    :cond_15
    invoke-static/range {p3 .. p3}, Ljava/lang/Math;->abs(I)I

    move-result v1

    move/from16 v0, p6

    if-ge v1, v0, :cond_25

    .line 1161
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "abs(stride) must be >= width"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1163
    :cond_25
    add-int/lit8 v1, p7, -0x1

    mul-int v1, v1, p3

    add-int v11, p2, v1

    .line 1164
    .local v11, lastScanline:I
    array-length v12, p1

    .line 1165
    .local v12, length:I
    if-ltz p2, :cond_38

    add-int v1, p2, p6

    if-gt v1, v12, :cond_38

    if-ltz v11, :cond_38

    add-int v1, v11, p6

    if-le v1, v12, :cond_3e

    .line 1167
    :cond_38
    new-instance v1, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v1}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v1

    .line 1170
    :cond_3e
    if-eqz p6, :cond_42

    if-nez p7, :cond_43

    .line 1176
    :cond_42
    :goto_42
    return-void

    .line 1174
    :cond_43
    iget v1, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    if-eqz p9, :cond_5d

    move-object/from16 v0, p9

    iget v10, v0, Landroid/graphics/Paint;->mNativePaint:I

    :goto_4b
    move-object v2, p1

    move v3, p2

    move/from16 v4, p3

    move/from16 v5, p4

    move/from16 v6, p5

    move/from16 v7, p6

    move/from16 v8, p7

    move/from16 v9, p8

    invoke-static/range {v1 .. v10}, Landroid/graphics/Canvas;->native_drawBitmap(I[IIIFFIIZI)V

    goto :goto_42

    :cond_5d
    const/4 v10, 0x0

    goto :goto_4b
.end method

.method public drawBitmap([IIIIIIIZLandroid/graphics/Paint;)V
    .registers 20
    .parameter "colors"
    .parameter "offset"
    .parameter "stride"
    .parameter "x"
    .parameter "y"
    .parameter "width"
    .parameter "height"
    .parameter "hasAlpha"
    .parameter "paint"

    .prologue
    .line 1183
    int-to-float v4, p4

    int-to-float v5, p5

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move v3, p3

    move/from16 v6, p6

    move/from16 v7, p7

    move/from16 v8, p8

    move-object/from16 v9, p9

    invoke-virtual/range {v0 .. v9}, Landroid/graphics/Canvas;->drawBitmap([IIIFFIIZLandroid/graphics/Paint;)V

    .line 1185
    return-void
.end method

.method public drawBitmapMesh(Landroid/graphics/Bitmap;II[FI[IILandroid/graphics/Paint;)V
    .registers 20
    .parameter "bitmap"
    .parameter "meshWidth"
    .parameter "meshHeight"
    .parameter "verts"
    .parameter "vertOffset"
    .parameter "colors"
    .parameter "colorOffset"
    .parameter "paint"

    .prologue
    .line 1236
    or-int v1, p2, p3

    or-int v1, v1, p5

    or-int v1, v1, p7

    if-gez v1, :cond_e

    .line 1237
    new-instance v1, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v1}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v1

    .line 1239
    :cond_e
    if-eqz p2, :cond_12

    if-nez p3, :cond_13

    .line 1252
    :cond_12
    :goto_12
    return-void

    .line 1242
    :cond_13
    add-int/lit8 v1, p2, 0x1

    add-int/lit8 v2, p3, 0x1

    mul-int v10, v1, v2

    .line 1244
    .local v10, count:I
    array-length v1, p4

    mul-int/lit8 v2, v10, 0x2

    move/from16 v0, p5

    invoke-static {v1, v0, v2}, Landroid/graphics/Canvas;->checkRange(III)V

    .line 1245
    if-eqz p6, :cond_2b

    .line 1247
    move-object/from16 v0, p6

    array-length v1, v0

    move/from16 v0, p7

    invoke-static {v1, v0, v10}, Landroid/graphics/Canvas;->checkRange(III)V

    .line 1249
    :cond_2b
    iget v1, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->ni()I

    move-result v2

    if-eqz p8, :cond_44

    move-object/from16 v0, p8

    iget v9, v0, Landroid/graphics/Paint;->mNativePaint:I

    :goto_37
    move v3, p2

    move v4, p3

    move-object v5, p4

    move/from16 v6, p5

    move-object/from16 v7, p6

    move/from16 v8, p7

    invoke-static/range {v1 .. v9}, Landroid/graphics/Canvas;->nativeDrawBitmapMesh(IIII[FI[III)V

    goto :goto_12

    :cond_44
    const/4 v9, 0x0

    goto :goto_37
.end method

.method public drawCircle(FFFLandroid/graphics/Paint;)V
    .registers 7
    .parameter "cx"
    .parameter "cy"
    .parameter "radius"
    .parameter "paint"

    .prologue
    .line 961
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    iget v1, p4, Landroid/graphics/Paint;->mNativePaint:I

    invoke-static {v0, p1, p2, p3, v1}, Landroid/graphics/Canvas;->native_drawCircle(IFFFI)V

    .line 962
    return-void
.end method

.method public drawColor(I)V
    .registers 3
    .parameter "color"

    .prologue
    .line 811
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    invoke-static {v0, p1}, Landroid/graphics/Canvas;->native_drawColor(II)V

    .line 812
    return-void
.end method

.method public drawColor(ILandroid/graphics/PorterDuff$Mode;)V
    .registers 5
    .parameter "color"
    .parameter "mode"

    .prologue
    .line 822
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    iget v1, p2, Landroid/graphics/PorterDuff$Mode;->nativeInt:I

    invoke-static {v0, p1, v1}, Landroid/graphics/Canvas;->native_drawColor(III)V

    .line 823
    return-void
.end method

.method public drawLine(FFFFLandroid/graphics/Paint;)V
    .registers 12
    .parameter "startX"
    .parameter "startY"
    .parameter "stopX"
    .parameter "stopY"
    .parameter "paint"

    .prologue
    .line 876
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    iget v5, p5, Landroid/graphics/Paint;->mNativePaint:I

    move v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    invoke-static/range {v0 .. v5}, Landroid/graphics/Canvas;->native_drawLine(IFFFFI)V

    .line 877
    return-void
.end method

.method public native drawLines([FIILandroid/graphics/Paint;)V
.end method

.method public drawLines([FLandroid/graphics/Paint;)V
    .registers 5
    .parameter "pts"
    .parameter "paint"

    .prologue
    .line 897
    const/4 v0, 0x0

    array-length v1, p1

    invoke-virtual {p0, p1, v0, v1, p2}, Landroid/graphics/Canvas;->drawLines([FIILandroid/graphics/Paint;)V

    .line 898
    return-void
.end method

.method public drawOval(Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    .registers 5
    .parameter "oval"
    .parameter "paint"

    .prologue
    .line 944
    if-nez p1, :cond_8

    .line 945
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0

    .line 947
    :cond_8
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    iget v1, p2, Landroid/graphics/Paint;->mNativePaint:I

    invoke-static {v0, p1, v1}, Landroid/graphics/Canvas;->native_drawOval(ILandroid/graphics/RectF;I)V

    .line 948
    return-void
.end method

.method public drawPaint(Landroid/graphics/Paint;)V
    .registers 4
    .parameter "paint"

    .prologue
    .line 833
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    iget v1, p1, Landroid/graphics/Paint;->mNativePaint:I

    invoke-static {v0, v1}, Landroid/graphics/Canvas;->native_drawPaint(II)V

    .line 834
    return-void
.end method

.method public drawPatch(Landroid/graphics/Bitmap;[BLandroid/graphics/RectF;Landroid/graphics/Paint;)V
    .registers 5
    .parameter "bitmap"
    .parameter "chunks"
    .parameter "dst"
    .parameter "paint"

    .prologue
    .line 1043
    return-void
.end method

.method public drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V
    .registers 6
    .parameter "path"
    .parameter "paint"

    .prologue
    .line 1021
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    invoke-virtual {p1}, Landroid/graphics/Path;->ni()I

    move-result v1

    iget v2, p2, Landroid/graphics/Paint;->mNativePaint:I

    invoke-static {v0, v1, v2}, Landroid/graphics/Canvas;->native_drawPath(III)V

    .line 1022
    return-void
.end method

.method public drawPicture(Landroid/graphics/Picture;)V
    .registers 4
    .parameter "picture"

    .prologue
    .line 1582
    invoke-virtual {p1}, Landroid/graphics/Picture;->endRecording()V

    .line 1583
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    invoke-virtual {p1}, Landroid/graphics/Picture;->ni()I

    move-result v1

    invoke-static {v0, v1}, Landroid/graphics/Canvas;->native_drawPicture(II)V

    .line 1584
    return-void
.end method

.method public drawPicture(Landroid/graphics/Picture;Landroid/graphics/Rect;)V
    .registers 6
    .parameter "picture"
    .parameter "dst"

    .prologue
    .line 1603
    invoke-virtual {p0}, Landroid/graphics/Canvas;->save()I

    .line 1604
    iget v0, p2, Landroid/graphics/Rect;->left:I

    int-to-float v0, v0

    iget v1, p2, Landroid/graphics/Rect;->top:I

    int-to-float v1, v1

    invoke-virtual {p0, v0, v1}, Landroid/graphics/Canvas;->translate(FF)V

    .line 1605
    invoke-virtual {p1}, Landroid/graphics/Picture;->getWidth()I

    move-result v0

    if-lez v0, :cond_31

    invoke-virtual {p1}, Landroid/graphics/Picture;->getHeight()I

    move-result v0

    if-lez v0, :cond_31

    .line 1606
    invoke-virtual {p2}, Landroid/graphics/Rect;->width()I

    move-result v0

    int-to-float v0, v0

    invoke-virtual {p1}, Landroid/graphics/Picture;->getWidth()I

    move-result v1

    int-to-float v1, v1

    div-float/2addr v0, v1

    invoke-virtual {p2}, Landroid/graphics/Rect;->height()I

    move-result v1

    int-to-float v1, v1

    invoke-virtual {p1}, Landroid/graphics/Picture;->getHeight()I

    move-result v2

    int-to-float v2, v2

    div-float/2addr v1, v2

    invoke-virtual {p0, v0, v1}, Landroid/graphics/Canvas;->scale(FF)V

    .line 1609
    :cond_31
    invoke-virtual {p0, p1}, Landroid/graphics/Canvas;->drawPicture(Landroid/graphics/Picture;)V

    .line 1610
    invoke-virtual {p0}, Landroid/graphics/Canvas;->restore()V

    .line 1611
    return-void
.end method

.method public drawPicture(Landroid/graphics/Picture;Landroid/graphics/RectF;)V
    .registers 6
    .parameter "picture"
    .parameter "dst"

    .prologue
    .line 1590
    invoke-virtual {p0}, Landroid/graphics/Canvas;->save()I

    .line 1591
    iget v0, p2, Landroid/graphics/RectF;->left:F

    iget v1, p2, Landroid/graphics/RectF;->top:F

    invoke-virtual {p0, v0, v1}, Landroid/graphics/Canvas;->translate(FF)V

    .line 1592
    invoke-virtual {p1}, Landroid/graphics/Picture;->getWidth()I

    move-result v0

    if-lez v0, :cond_2d

    invoke-virtual {p1}, Landroid/graphics/Picture;->getHeight()I

    move-result v0

    if-lez v0, :cond_2d

    .line 1593
    invoke-virtual {p2}, Landroid/graphics/RectF;->width()F

    move-result v0

    invoke-virtual {p1}, Landroid/graphics/Picture;->getWidth()I

    move-result v1

    int-to-float v1, v1

    div-float/2addr v0, v1

    invoke-virtual {p2}, Landroid/graphics/RectF;->height()F

    move-result v1

    invoke-virtual {p1}, Landroid/graphics/Picture;->getHeight()I

    move-result v2

    int-to-float v2, v2

    div-float/2addr v1, v2

    invoke-virtual {p0, v0, v1}, Landroid/graphics/Canvas;->scale(FF)V

    .line 1595
    :cond_2d
    invoke-virtual {p0, p1}, Landroid/graphics/Canvas;->drawPicture(Landroid/graphics/Picture;)V

    .line 1596
    invoke-virtual {p0}, Landroid/graphics/Canvas;->restore()V

    .line 1597
    return-void
.end method

.method public native drawPoint(FFLandroid/graphics/Paint;)V
.end method

.method public native drawPoints([FIILandroid/graphics/Paint;)V
.end method

.method public drawPoints([FLandroid/graphics/Paint;)V
    .registers 5
    .parameter "pts"
    .parameter "paint"

    .prologue
    .line 858
    const/4 v0, 0x0

    array-length v1, p1

    invoke-virtual {p0, p1, v0, v1, p2}, Landroid/graphics/Canvas;->drawPoints([FIILandroid/graphics/Paint;)V

    .line 859
    return-void
.end method

.method public drawPosText(Ljava/lang/String;[FLandroid/graphics/Paint;)V
    .registers 6
    .parameter "text"
    .parameter "pos"
    .parameter "paint"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 1525
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    mul-int/lit8 v0, v0, 0x2

    array-length v1, p2

    if-le v0, v1, :cond_f

    .line 1526
    new-instance v0, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v0

    .line 1528
    :cond_f
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    iget v1, p3, Landroid/graphics/Paint;->mNativePaint:I

    invoke-static {v0, p1, p2, v1}, Landroid/graphics/Canvas;->native_drawPosText(ILjava/lang/String;[FI)V

    .line 1529
    return-void
.end method

.method public drawPosText([CII[FLandroid/graphics/Paint;)V
    .registers 12
    .parameter "text"
    .parameter "index"
    .parameter "count"
    .parameter "pos"
    .parameter "paint"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 1505
    if-ltz p2, :cond_c

    add-int v0, p2, p3

    array-length v1, p1

    if-gt v0, v1, :cond_c

    mul-int/lit8 v0, p3, 0x2

    array-length v1, p4

    if-le v0, v1, :cond_12

    .line 1506
    :cond_c
    new-instance v0, Ljava/lang/IndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/IndexOutOfBoundsException;-><init>()V

    throw v0

    .line 1508
    :cond_12
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    iget v5, p5, Landroid/graphics/Paint;->mNativePaint:I

    move-object v1, p1

    move v2, p2

    move v3, p3

    move-object v4, p4

    invoke-static/range {v0 .. v5}, Landroid/graphics/Canvas;->native_drawPosText(I[CII[FI)V

    .line 1510
    return-void
.end method

.method public drawRGB(III)V
    .registers 5
    .parameter "r"
    .parameter "g"
    .parameter "b"

    .prologue
    .line 788
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    invoke-static {v0, p1, p2, p3}, Landroid/graphics/Canvas;->native_drawRGB(IIII)V

    .line 789
    return-void
.end method

.method public drawRect(FFFFLandroid/graphics/Paint;)V
    .registers 12
    .parameter "left"
    .parameter "top"
    .parameter "right"
    .parameter "bottom"
    .parameter "paint"

    .prologue
    .line 934
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    iget v5, p5, Landroid/graphics/Paint;->mNativePaint:I

    move v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    invoke-static/range {v0 .. v5}, Landroid/graphics/Canvas;->native_drawRect(IFFFFI)V

    .line 935
    return-void
.end method

.method public drawRect(Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    .registers 9
    .parameter "r"
    .parameter "paint"

    .prologue
    .line 919
    iget v0, p1, Landroid/graphics/Rect;->left:I

    int-to-float v1, v0

    iget v0, p1, Landroid/graphics/Rect;->top:I

    int-to-float v2, v0

    iget v0, p1, Landroid/graphics/Rect;->right:I

    int-to-float v3, v0

    iget v0, p1, Landroid/graphics/Rect;->bottom:I

    int-to-float v4, v0

    move-object v0, p0

    move-object v5, p2

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 920
    return-void
.end method

.method public drawRect(Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    .registers 5
    .parameter "rect"
    .parameter "paint"

    .prologue
    .line 908
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    iget v1, p2, Landroid/graphics/Paint;->mNativePaint:I

    invoke-static {v0, p1, v1}, Landroid/graphics/Canvas;->native_drawRect(ILandroid/graphics/RectF;I)V

    .line 909
    return-void
.end method

.method public drawRoundRect(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V
    .registers 7
    .parameter "rect"
    .parameter "rx"
    .parameter "ry"
    .parameter "paint"

    .prologue
    .line 1006
    if-nez p1, :cond_8

    .line 1007
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0

    .line 1009
    :cond_8
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    iget v1, p4, Landroid/graphics/Paint;->mNativePaint:I

    invoke-static {v0, p1, p2, p3, v1}, Landroid/graphics/Canvas;->native_drawRoundRect(ILandroid/graphics/RectF;FFI)V

    .line 1011
    return-void
.end method

.method public drawText(Ljava/lang/CharSequence;IIFFLandroid/graphics/Paint;)V
    .registers 15
    .parameter "text"
    .parameter "start"
    .parameter "end"
    .parameter "x"
    .parameter "y"
    .parameter "paint"

    .prologue
    const/4 v2, 0x0

    .line 1382
    instance-of v0, p1, Ljava/lang/String;

    if-nez v0, :cond_d

    instance-of v0, p1, Landroid/text/SpannedString;

    if-nez v0, :cond_d

    instance-of v0, p1, Landroid/text/SpannableString;

    if-eqz v0, :cond_1f

    .line 1384
    :cond_d
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    iget v6, p6, Landroid/graphics/Paint;->mBidiFlags:I

    iget v7, p6, Landroid/graphics/Paint;->mNativePaint:I

    move v2, p2

    move v3, p3

    move v4, p4

    move v5, p5

    invoke-static/range {v0 .. v7}, Landroid/graphics/Canvas;->native_drawText(ILjava/lang/String;IIFFII)V

    .line 1396
    :goto_1e
    return-void

    .line 1386
    :cond_1f
    instance-of v0, p1, Landroid/text/GraphicsOperations;

    if-eqz v0, :cond_30

    move-object v0, p1

    .line 1387
    check-cast v0, Landroid/text/GraphicsOperations;

    move-object v1, p0

    move v2, p2

    move v3, p3

    move v4, p4

    move v5, p5

    move-object v6, p6

    invoke-interface/range {v0 .. v6}, Landroid/text/GraphicsOperations;->drawText(Landroid/graphics/Canvas;IIFFLandroid/graphics/Paint;)V

    goto :goto_1e

    .line 1390
    :cond_30
    sub-int v0, p3, p2

    invoke-static {v0}, Landroid/graphics/TemporaryBuffer;->obtain(I)[C

    move-result-object v1

    .line 1391
    .local v1, buf:[C
    invoke-static {p1, p2, p3, v1, v2}, Landroid/text/TextUtils;->getChars(Ljava/lang/CharSequence;II[CI)V

    .line 1392
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    sub-int v3, p3, p2

    iget v6, p6, Landroid/graphics/Paint;->mBidiFlags:I

    iget v7, p6, Landroid/graphics/Paint;->mNativePaint:I

    move v4, p4

    move v5, p5

    invoke-static/range {v0 .. v7}, Landroid/graphics/Canvas;->native_drawText(I[CIIFFII)V

    .line 1394
    invoke-static {v1}, Landroid/graphics/TemporaryBuffer;->recycle([C)V

    goto :goto_1e
.end method

.method public drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    .registers 13
    .parameter "text"
    .parameter "x"
    .parameter "y"
    .parameter "paint"

    .prologue
    .line 1345
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    const/4 v2, 0x0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v3

    iget v6, p4, Landroid/graphics/Paint;->mBidiFlags:I

    iget v7, p4, Landroid/graphics/Paint;->mNativePaint:I

    move-object v1, p1

    move v4, p2

    move v5, p3

    invoke-static/range {v0 .. v7}, Landroid/graphics/Canvas;->native_drawText(ILjava/lang/String;IIFFII)V

    .line 1347
    return-void
.end method

.method public drawText(Ljava/lang/String;IIFFLandroid/graphics/Paint;)V
    .registers 15
    .parameter "text"
    .parameter "start"
    .parameter "end"
    .parameter "x"
    .parameter "y"
    .parameter "paint"

    .prologue
    .line 1361
    or-int v0, p2, p3

    sub-int v1, p3, p2

    or-int/2addr v0, v1

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    sub-int/2addr v1, p3

    or-int/2addr v0, v1

    if-gez v0, :cond_13

    .line 1362
    new-instance v0, Ljava/lang/IndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/IndexOutOfBoundsException;-><init>()V

    throw v0

    .line 1364
    :cond_13
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    iget v6, p6, Landroid/graphics/Paint;->mBidiFlags:I

    iget v7, p6, Landroid/graphics/Paint;->mNativePaint:I

    move-object v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    move v5, p5

    invoke-static/range {v0 .. v7}, Landroid/graphics/Canvas;->native_drawText(ILjava/lang/String;IIFFII)V

    .line 1366
    return-void
.end method

.method public drawText([CIIFFLandroid/graphics/Paint;)V
    .registers 15
    .parameter "text"
    .parameter "index"
    .parameter "count"
    .parameter "x"
    .parameter "y"
    .parameter "paint"

    .prologue
    .line 1327
    or-int v0, p2, p3

    add-int v1, p2, p3

    or-int/2addr v0, v1

    array-length v1, p1

    sub-int/2addr v1, p2

    sub-int/2addr v1, p3

    or-int/2addr v0, v1

    if-gez v0, :cond_11

    .line 1329
    new-instance v0, Ljava/lang/IndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/IndexOutOfBoundsException;-><init>()V

    throw v0

    .line 1331
    :cond_11
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    iget v6, p6, Landroid/graphics/Paint;->mBidiFlags:I

    iget v7, p6, Landroid/graphics/Paint;->mNativePaint:I

    move-object v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    move v5, p5

    invoke-static/range {v0 .. v7}, Landroid/graphics/Canvas;->native_drawText(I[CIIFFII)V

    .line 1333
    return-void
.end method

.method public drawTextOnPath(Ljava/lang/String;Landroid/graphics/Path;FFLandroid/graphics/Paint;)V
    .registers 13
    .parameter "text"
    .parameter "path"
    .parameter "hOffset"
    .parameter "vOffset"
    .parameter "paint"

    .prologue
    .line 1568
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_16

    .line 1569
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    invoke-virtual {p2}, Landroid/graphics/Path;->ni()I

    move-result v2

    iget v5, p5, Landroid/graphics/Paint;->mBidiFlags:I

    iget v6, p5, Landroid/graphics/Paint;->mNativePaint:I

    move-object v1, p1

    move v3, p3

    move v4, p4

    invoke-static/range {v0 .. v6}, Landroid/graphics/Canvas;->native_drawTextOnPath(ILjava/lang/String;IFFII)V

    .line 1572
    :cond_16
    return-void
.end method

.method public drawTextOnPath([CIILandroid/graphics/Path;FFLandroid/graphics/Paint;)V
    .registers 18
    .parameter "text"
    .parameter "index"
    .parameter "count"
    .parameter "path"
    .parameter "hOffset"
    .parameter "vOffset"
    .parameter "paint"

    .prologue
    .line 1546
    if-ltz p2, :cond_7

    add-int v1, p2, p3

    array-length v2, p1

    if-le v1, v2, :cond_d

    .line 1547
    :cond_7
    new-instance v1, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v1}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v1

    .line 1549
    :cond_d
    iget v1, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    invoke-virtual {p4}, Landroid/graphics/Path;->ni()I

    move-result v5

    move-object/from16 v0, p7

    iget v8, v0, Landroid/graphics/Paint;->mBidiFlags:I

    move-object/from16 v0, p7

    iget v9, v0, Landroid/graphics/Paint;->mNativePaint:I

    move-object v2, p1

    move v3, p2

    move v4, p3

    move v6, p5

    move/from16 v7, p6

    invoke-static/range {v1 .. v9}, Landroid/graphics/Canvas;->native_drawTextOnPath(I[CIIIFFII)V

    .line 1552
    return-void
.end method

.method public drawTextRun(Ljava/lang/CharSequence;IIIIFFILandroid/graphics/Paint;)V
    .registers 21
    .parameter "text"
    .parameter "start"
    .parameter "end"
    .parameter "contextStart"
    .parameter "contextEnd"
    .parameter "x"
    .parameter "y"
    .parameter "dir"
    .parameter "paint"

    .prologue
    .line 1459
    if-nez p1, :cond_b

    .line 1460
    new-instance v1, Ljava/lang/NullPointerException;

    const-string/jumbo v3, "text is null"

    invoke-direct {v1, v3}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1462
    :cond_b
    if-nez p9, :cond_16

    .line 1463
    new-instance v1, Ljava/lang/NullPointerException;

    const-string/jumbo v3, "paint is null"

    invoke-direct {v1, v3}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1465
    :cond_16
    or-int v1, p2, p3

    sub-int v3, p3, p2

    or-int/2addr v1, v3

    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v3

    sub-int/2addr v3, p3

    or-int/2addr v1, v3

    if-gez v1, :cond_29

    .line 1466
    new-instance v1, Ljava/lang/IndexOutOfBoundsException;

    invoke-direct {v1}, Ljava/lang/IndexOutOfBoundsException;-><init>()V

    throw v1

    .line 1469
    :cond_29
    if-nez p8, :cond_4f

    const/4 v9, 0x0

    .line 1471
    .local v9, flags:I
    :goto_2c
    instance-of v1, p1, Ljava/lang/String;

    if-nez v1, :cond_38

    instance-of v1, p1, Landroid/text/SpannedString;

    if-nez v1, :cond_38

    instance-of v1, p1, Landroid/text/SpannableString;

    if-eqz v1, :cond_51

    .line 1473
    :cond_38
    iget v1, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p9

    iget v10, v0, Landroid/graphics/Paint;->mNativePaint:I

    move v3, p2

    move v4, p3

    move v5, p4

    move/from16 v6, p5

    move/from16 v7, p6

    move/from16 v8, p7

    invoke-static/range {v1 .. v10}, Landroid/graphics/Canvas;->native_drawTextRun(ILjava/lang/String;IIIIFFII)V

    .line 1487
    :goto_4e
    return-void

    .line 1469
    .end local v9           #flags:I
    :cond_4f
    const/4 v9, 0x1

    goto :goto_2c

    .line 1475
    .restart local v9       #flags:I
    :cond_51
    instance-of v1, p1, Landroid/text/GraphicsOperations;

    if-eqz v1, :cond_68

    move-object v1, p1

    .line 1476
    check-cast v1, Landroid/text/GraphicsOperations;

    move-object v2, p0

    move v3, p2

    move v4, p3

    move v5, p4

    move/from16 v6, p5

    move/from16 v7, p6

    move/from16 v8, p7

    move-object/from16 v10, p9

    invoke-interface/range {v1 .. v10}, Landroid/text/GraphicsOperations;->drawTextRun(Landroid/graphics/Canvas;IIIIFFILandroid/graphics/Paint;)V

    goto :goto_4e

    .line 1479
    :cond_68
    sub-int v6, p5, p4

    .line 1480
    .local v6, contextLen:I
    sub-int v4, p3, p2

    .line 1481
    .local v4, len:I
    invoke-static {v6}, Landroid/graphics/TemporaryBuffer;->obtain(I)[C

    move-result-object v2

    .line 1482
    .local v2, buf:[C
    const/4 v1, 0x0

    move/from16 v0, p5

    invoke-static {p1, p4, v0, v2, v1}, Landroid/text/TextUtils;->getChars(Ljava/lang/CharSequence;II[CI)V

    .line 1483
    iget v1, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    sub-int v3, p2, p4

    const/4 v5, 0x0

    move-object/from16 v0, p9

    iget v10, v0, Landroid/graphics/Paint;->mNativePaint:I

    move/from16 v7, p6

    move/from16 v8, p7

    invoke-static/range {v1 .. v10}, Landroid/graphics/Canvas;->native_drawTextRun(I[CIIIIFFII)V

    .line 1485
    invoke-static {v2}, Landroid/graphics/TemporaryBuffer;->recycle([C)V

    goto :goto_4e
.end method

.method public drawTextRun([CIIIIFFILandroid/graphics/Paint;)V
    .registers 21
    .parameter "text"
    .parameter "index"
    .parameter "count"
    .parameter "contextIndex"
    .parameter "contextCount"
    .parameter "x"
    .parameter "y"
    .parameter "dir"
    .parameter "paint"

    .prologue
    .line 1422
    if-nez p1, :cond_b

    .line 1423
    new-instance v1, Ljava/lang/NullPointerException;

    const-string/jumbo v2, "text is null"

    invoke-direct {v1, v2}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1425
    :cond_b
    if-nez p9, :cond_16

    .line 1426
    new-instance v1, Ljava/lang/NullPointerException;

    const-string/jumbo v2, "paint is null"

    invoke-direct {v1, v2}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1428
    :cond_16
    or-int v1, p2, p3

    array-length v2, p1

    sub-int/2addr v2, p2

    sub-int/2addr v2, p3

    or-int/2addr v1, v2

    if-gez v1, :cond_24

    .line 1429
    new-instance v1, Ljava/lang/IndexOutOfBoundsException;

    invoke-direct {v1}, Ljava/lang/IndexOutOfBoundsException;-><init>()V

    throw v1

    .line 1431
    :cond_24
    if-eqz p8, :cond_47

    const/4 v1, 0x1

    move/from16 v0, p8

    if-eq v0, v1, :cond_47

    .line 1432
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "unknown dir: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move/from16 v0, p8

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1435
    :cond_47
    iget v1, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    move-object/from16 v0, p9

    iget v10, v0, Landroid/graphics/Paint;->mNativePaint:I

    move-object v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move/from16 v6, p5

    move/from16 v7, p6

    move/from16 v8, p7

    move/from16 v9, p8

    invoke-static/range {v1 .. v10}, Landroid/graphics/Canvas;->native_drawTextRun(I[CIIIIFFII)V

    .line 1437
    return-void
.end method

.method public drawVertices(Landroid/graphics/Canvas$VertexMode;I[FI[FI[II[SIILandroid/graphics/Paint;)V
    .registers 28
    .parameter "mode"
    .parameter "vertexCount"
    .parameter "verts"
    .parameter "vertOffset"
    .parameter "texs"
    .parameter "texOffset"
    .parameter "colors"
    .parameter "colorOffset"
    .parameter "indices"
    .parameter "indexOffset"
    .parameter "indexCount"
    .parameter "paint"

    .prologue
    .line 1302
    move-object/from16 v0, p3

    array-length v2, v0

    move/from16 v0, p4

    move/from16 v1, p2

    invoke-static {v2, v0, v1}, Landroid/graphics/Canvas;->checkRange(III)V

    .line 1303
    if-eqz p5, :cond_16

    .line 1304
    move-object/from16 v0, p5

    array-length v2, v0

    move/from16 v0, p6

    move/from16 v1, p2

    invoke-static {v2, v0, v1}, Landroid/graphics/Canvas;->checkRange(III)V

    .line 1306
    :cond_16
    if-eqz p7, :cond_22

    .line 1307
    move-object/from16 v0, p7

    array-length v2, v0

    div-int/lit8 v3, p2, 0x2

    move/from16 v0, p8

    invoke-static {v2, v0, v3}, Landroid/graphics/Canvas;->checkRange(III)V

    .line 1309
    :cond_22
    if-eqz p9, :cond_2e

    .line 1310
    move-object/from16 v0, p9

    array-length v2, v0

    move/from16 v0, p10

    move/from16 v1, p11

    invoke-static {v2, v0, v1}, Landroid/graphics/Canvas;->checkRange(III)V

    .line 1312
    :cond_2e
    iget v2, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    move-object/from16 v0, p1

    iget v3, v0, Landroid/graphics/Canvas$VertexMode;->nativeInt:I

    move-object/from16 v0, p12

    iget v14, v0, Landroid/graphics/Paint;->mNativePaint:I

    move/from16 v4, p2

    move-object/from16 v5, p3

    move/from16 v6, p4

    move-object/from16 v7, p5

    move/from16 v8, p6

    move-object/from16 v9, p7

    move/from16 v10, p8

    move-object/from16 v11, p9

    move/from16 v12, p10

    move/from16 v13, p11

    invoke-static/range {v2 .. v14}, Landroid/graphics/Canvas;->nativeDrawVertices(III[FI[FI[II[SIII)V

    .line 1315
    return-void
.end method

.method public final getClipBounds()Landroid/graphics/Rect;
    .registers 2

    .prologue
    .line 774
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    .line 775
    .local v0, r:Landroid/graphics/Rect;
    invoke-virtual {p0, v0}, Landroid/graphics/Canvas;->getClipBounds(Landroid/graphics/Rect;)Z

    .line 776
    return-object v0
.end method

.method public getClipBounds(Landroid/graphics/Rect;)Z
    .registers 3
    .parameter "bounds"

    .prologue
    .line 765
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    invoke-static {v0, p1}, Landroid/graphics/Canvas;->native_getClipBounds(ILandroid/graphics/Rect;)Z

    move-result v0

    return v0
.end method

.method public getDensity()I
    .registers 2

    .prologue
    .line 244
    iget v0, p0, Landroid/graphics/Canvas;->mDensity:I

    return v0
.end method

.method public getDrawFilter()Landroid/graphics/DrawFilter;
    .registers 2

    .prologue
    .line 671
    iget-object v0, p0, Landroid/graphics/Canvas;->mDrawFilter:Landroid/graphics/DrawFilter;

    return-object v0
.end method

.method protected getGL()Ljavax/microedition/khronos/opengles/GL;
    .registers 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 154
    const/4 v0, 0x0

    return-object v0
.end method

.method public native getHeight()I
.end method

.method public final getMatrix()Landroid/graphics/Matrix;
    .registers 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 522
    new-instance v0, Landroid/graphics/Matrix;

    invoke-direct {v0}, Landroid/graphics/Matrix;-><init>()V

    .line 524
    .local v0, m:Landroid/graphics/Matrix;
    invoke-virtual {p0, v0}, Landroid/graphics/Canvas;->getMatrix(Landroid/graphics/Matrix;)V

    .line 525
    return-object v0
.end method

.method public getMatrix(Landroid/graphics/Matrix;)V
    .registers 4
    .parameter "ctm"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 513
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    iget v1, p1, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, v1}, Landroid/graphics/Canvas;->native_getCTM(II)V

    .line 514
    return-void
.end method

.method public getMaximumBitmapHeight()I
    .registers 2

    .prologue
    .line 290
    const/16 v0, 0x7ffe

    return v0
.end method

.method public getMaximumBitmapWidth()I
    .registers 2

    .prologue
    .line 279
    const/16 v0, 0x7ffe

    return v0
.end method

.method public native getSaveCount()I
.end method

.method public native getWidth()I
.end method

.method public isHardwareAccelerated()Z
    .registers 2

    .prologue
    .line 167
    const/4 v0, 0x0

    return v0
.end method

.method public native isOpaque()Z
.end method

.method public quickReject(FFFFLandroid/graphics/Canvas$EdgeType;)Z
    .registers 12
    .parameter "left"
    .parameter "top"
    .parameter "right"
    .parameter "bottom"
    .parameter "type"

    .prologue
    .line 753
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    iget v5, p5, Landroid/graphics/Canvas$EdgeType;->nativeInt:I

    move v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    invoke-static/range {v0 .. v5}, Landroid/graphics/Canvas;->native_quickReject(IFFFFI)Z

    move-result v0

    return v0
.end method

.method public quickReject(Landroid/graphics/Path;Landroid/graphics/Canvas$EdgeType;)Z
    .registers 6
    .parameter "path"
    .parameter "type"

    .prologue
    .line 729
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    invoke-virtual {p1}, Landroid/graphics/Path;->ni()I

    move-result v1

    iget v2, p2, Landroid/graphics/Canvas$EdgeType;->nativeInt:I

    invoke-static {v0, v1, v2}, Landroid/graphics/Canvas;->native_quickReject(III)Z

    move-result v0

    return v0
.end method

.method public quickReject(Landroid/graphics/RectF;Landroid/graphics/Canvas$EdgeType;)Z
    .registers 5
    .parameter "rect"
    .parameter "type"

    .prologue
    .line 709
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    iget v1, p2, Landroid/graphics/Canvas$EdgeType;->nativeInt:I

    invoke-static {v0, p1, v1}, Landroid/graphics/Canvas;->native_quickReject(ILandroid/graphics/RectF;I)Z

    move-result v0

    return v0
.end method

.method public native restore()V
.end method

.method public native restoreToCount(I)V
.end method

.method public native rotate(F)V
.end method

.method public final rotate(FFF)V
    .registers 6
    .parameter "degrees"
    .parameter "px"
    .parameter "py"

    .prologue
    .line 467
    invoke-virtual {p0, p2, p3}, Landroid/graphics/Canvas;->translate(FF)V

    .line 468
    invoke-virtual {p0, p1}, Landroid/graphics/Canvas;->rotate(F)V

    .line 469
    neg-float v0, p2

    neg-float v1, p3

    invoke-virtual {p0, v0, v1}, Landroid/graphics/Canvas;->translate(FF)V

    .line 470
    return-void
.end method

.method public native save()I
.end method

.method public native save(I)I
.end method

.method public saveLayer(FFFFLandroid/graphics/Paint;I)I
    .registers 14
    .parameter "left"
    .parameter "top"
    .parameter "right"
    .parameter "bottom"
    .parameter "paint"
    .parameter "saveFlags"

    .prologue
    .line 359
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    if-eqz p5, :cond_10

    iget v5, p5, Landroid/graphics/Paint;->mNativePaint:I

    :goto_6
    move v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    move v6, p6

    invoke-static/range {v0 .. v6}, Landroid/graphics/Canvas;->native_saveLayer(IFFFFII)I

    move-result v0

    return v0

    :cond_10
    const/4 v5, 0x0

    goto :goto_6
.end method

.method public saveLayer(Landroid/graphics/RectF;Landroid/graphics/Paint;I)I
    .registers 6
    .parameter "bounds"
    .parameter "paint"
    .parameter "saveFlags"

    .prologue
    .line 349
    iget v1, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    if-eqz p2, :cond_b

    iget v0, p2, Landroid/graphics/Paint;->mNativePaint:I

    :goto_6
    invoke-static {v1, p1, v0, p3}, Landroid/graphics/Canvas;->native_saveLayer(ILandroid/graphics/RectF;II)I

    move-result v0

    return v0

    :cond_b
    const/4 v0, 0x0

    goto :goto_6
.end method

.method public saveLayerAlpha(FFFFII)I
    .registers 14
    .parameter "left"
    .parameter "top"
    .parameter "right"
    .parameter "bottom"
    .parameter "alpha"
    .parameter "saveFlags"

    .prologue
    .line 390
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    move v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    move v5, p5

    move v6, p6

    invoke-static/range {v0 .. v6}, Landroid/graphics/Canvas;->native_saveLayerAlpha(IFFFFII)I

    move-result v0

    return v0
.end method

.method public saveLayerAlpha(Landroid/graphics/RectF;II)I
    .registers 6
    .parameter "bounds"
    .parameter "alpha"
    .parameter "saveFlags"

    .prologue
    .line 381
    const/16 v0, 0xff

    const/4 v1, 0x0

    invoke-static {v1, p2}, Ljava/lang/Math;->max(II)I

    move-result v1

    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result p2

    .line 382
    iget v0, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    invoke-static {v0, p1, p2, p3}, Landroid/graphics/Canvas;->native_saveLayerAlpha(ILandroid/graphics/RectF;II)I

    move-result v0

    return v0
.end method

.method public native scale(FF)V
.end method

.method public final scale(FFFF)V
    .registers 7
    .parameter "sx"
    .parameter "sy"
    .parameter "px"
    .parameter "py"

    .prologue
    .line 447
    invoke-virtual {p0, p3, p4}, Landroid/graphics/Canvas;->translate(FF)V

    .line 448
    invoke-virtual {p0, p1, p2}, Landroid/graphics/Canvas;->scale(FF)V

    .line 449
    neg-float v0, p3

    neg-float v1, p4

    invoke-virtual {p0, v0, v1}, Landroid/graphics/Canvas;->translate(FF)V

    .line 450
    return-void
.end method

.method public setBitmap(Landroid/graphics/Bitmap;)V
    .registers 5
    .parameter "bitmap"

    .prologue
    .line 180
    invoke-virtual {p0}, Landroid/graphics/Canvas;->isHardwareAccelerated()Z

    move-result v1

    if-eqz v1, :cond_e

    .line 181
    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "Can\'t set a bitmap device on a GL canvas"

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 184
    :cond_e
    const/4 v0, 0x0

    .line 185
    .local v0, pointer:I
    if-eqz p1, :cond_28

    .line 186
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->isMutable()Z

    move-result v1

    if-nez v1, :cond_1d

    .line 187
    new-instance v1, Ljava/lang/IllegalStateException;

    invoke-direct {v1}, Ljava/lang/IllegalStateException;-><init>()V

    throw v1

    .line 189
    :cond_1d
    invoke-static {p1}, Landroid/graphics/Canvas;->throwIfRecycled(Landroid/graphics/Bitmap;)V

    .line 190
    iget v1, p1, Landroid/graphics/Bitmap;->mDensity:I

    iput v1, p0, Landroid/graphics/Canvas;->mDensity:I

    .line 191
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->ni()I

    move-result v0

    .line 194
    :cond_28
    iget v1, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    invoke-static {v1, v0}, Landroid/graphics/Canvas;->native_setBitmap(II)V

    .line 195
    iput-object p1, p0, Landroid/graphics/Canvas;->mBitmap:Landroid/graphics/Bitmap;

    .line 196
    return-void
.end method

.method public setDensity(I)V
    .registers 3
    .parameter "density"

    .prologue
    .line 260
    iget-object v0, p0, Landroid/graphics/Canvas;->mBitmap:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_9

    .line 261
    iget-object v0, p0, Landroid/graphics/Canvas;->mBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v0, p1}, Landroid/graphics/Bitmap;->setDensity(I)V

    .line 263
    :cond_9
    iput p1, p0, Landroid/graphics/Canvas;->mDensity:I

    .line 264
    return-void
.end method

.method public setDrawFilter(Landroid/graphics/DrawFilter;)V
    .registers 4
    .parameter "filter"

    .prologue
    .line 675
    const/4 v0, 0x0

    .line 676
    .local v0, nativeFilter:I
    if-eqz p1, :cond_5

    .line 677
    iget v0, p1, Landroid/graphics/DrawFilter;->mNativeInt:I

    .line 679
    :cond_5
    iput-object p1, p0, Landroid/graphics/Canvas;->mDrawFilter:Landroid/graphics/DrawFilter;

    .line 680
    iget v1, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    invoke-static {v1, v0}, Landroid/graphics/Canvas;->nativeSetDrawFilter(II)V

    .line 681
    return-void
.end method

.method public setMatrix(Landroid/graphics/Matrix;)V
    .registers 4
    .parameter "matrix"

    .prologue
    .line 503
    iget v1, p0, Landroid/graphics/Canvas;->mNativeCanvas:I

    if-nez p1, :cond_9

    const/4 v0, 0x0

    :goto_5
    invoke-static {v1, v0}, Landroid/graphics/Canvas;->native_setMatrix(II)V

    .line 505
    return-void

    .line 503
    :cond_9
    iget v0, p1, Landroid/graphics/Matrix;->native_instance:I

    goto :goto_5
.end method

.method public setScreenDensity(I)V
    .registers 2
    .parameter "density"

    .prologue
    .line 268
    iput p1, p0, Landroid/graphics/Canvas;->mScreenDensity:I

    .line 269
    return-void
.end method

.method public setViewport(II)V
    .registers 3
    .parameter "width"
    .parameter "height"

    .prologue
    .line 208
    return-void
.end method

.method public native skew(FF)V
.end method

.method public native translate(FF)V
.end method
