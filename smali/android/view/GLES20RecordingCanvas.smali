.class Landroid/view/GLES20RecordingCanvas;
.super Landroid/view/GLES20Canvas;
.source "GLES20RecordingCanvas.java"

# interfaces
.implements Landroid/util/Poolable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/view/GLES20Canvas;",
        "Landroid/util/Poolable",
        "<",
        "Landroid/view/GLES20RecordingCanvas;",
        ">;"
    }
.end annotation


# static fields
.field private static final POOL_LIMIT:I = 0x19

.field private static final sPool:Landroid/util/Pool;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/Pool",
            "<",
            "Landroid/view/GLES20RecordingCanvas;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private mDisplayList:Landroid/view/GLES20DisplayList;

.field private mIsPooled:Z

.field private mNextPoolable:Landroid/view/GLES20RecordingCanvas;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    .prologue
    new-instance v0, Landroid/view/GLES20RecordingCanvas$1;

    invoke-direct {v0}, Landroid/view/GLES20RecordingCanvas$1;-><init>()V

    const/16 v1, 0x19

    invoke-static {v0, v1}, Landroid/util/Pools;->finitePool(Landroid/util/PoolableManager;I)Landroid/util/Pool;

    move-result-object v0

    invoke-static {v0}, Landroid/util/Pools;->synchronizedPool(Landroid/util/Pool;)Landroid/util/Pool;

    move-result-object v0

    sput-object v0, Landroid/view/GLES20RecordingCanvas;->sPool:Landroid/util/Pool;

    return-void
.end method

.method private constructor <init>()V
    .registers 2

    .prologue
    const/4 v0, 0x1

    invoke-direct {p0, v0, v0}, Landroid/view/GLES20Canvas;-><init>(ZZ)V

    return-void
.end method

.method synthetic constructor <init>(Landroid/view/GLES20RecordingCanvas$1;)V
    .registers 2
    .parameter "x0"

    .prologue
    invoke-direct {p0}, Landroid/view/GLES20RecordingCanvas;-><init>()V

    return-void
.end method

.method static obtain(Landroid/view/GLES20DisplayList;)Landroid/view/GLES20RecordingCanvas;
    .registers 3
    .parameter "displayList"

    .prologue
    sget-object v1, Landroid/view/GLES20RecordingCanvas;->sPool:Landroid/util/Pool;

    invoke-interface {v1}, Landroid/util/Pool;->acquire()Landroid/util/Poolable;

    move-result-object v0

    check-cast v0, Landroid/view/GLES20RecordingCanvas;

    .local v0, canvas:Landroid/view/GLES20RecordingCanvas;
    iput-object p0, v0, Landroid/view/GLES20RecordingCanvas;->mDisplayList:Landroid/view/GLES20DisplayList;

    return-object v0
.end method

.method private recordShaderBitmap(Landroid/graphics/Paint;)V
    .registers 5
    .parameter "paint"

    .prologue
    if-eqz p1, :cond_15

    invoke-virtual {p1}, Landroid/graphics/Paint;->getShader()Landroid/graphics/Shader;

    move-result-object v0

    .local v0, shader:Landroid/graphics/Shader;
    instance-of v1, v0, Landroid/graphics/BitmapShader;

    if-eqz v1, :cond_15

    iget-object v1, p0, Landroid/view/GLES20RecordingCanvas;->mDisplayList:Landroid/view/GLES20DisplayList;

    iget-object v1, v1, Landroid/view/GLES20DisplayList;->mBitmaps:Ljava/util/ArrayList;

    check-cast v0, Landroid/graphics/BitmapShader;

    .end local v0           #shader:Landroid/graphics/Shader;
    iget-object v2, v0, Landroid/graphics/BitmapShader;->mBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_15
    return-void
.end method


# virtual methods
.method public drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    .registers 6
    .parameter "bitmap"
    .parameter "left"
    .parameter "top"
    .parameter "paint"

    .prologue
    invoke-super {p0, p1, p2, p3, p4}, Landroid/view/GLES20Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    iget-object v0, p0, Landroid/view/GLES20RecordingCanvas;->mDisplayList:Landroid/view/GLES20DisplayList;

    iget-object v0, v0, Landroid/view/GLES20DisplayList;->mBitmaps:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
    .registers 5
    .parameter "bitmap"
    .parameter "matrix"
    .parameter "paint"

    .prologue
    invoke-super {p0, p1, p2, p3}, Landroid/view/GLES20Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V

    iget-object v0, p0, Landroid/view/GLES20RecordingCanvas;->mDisplayList:Landroid/view/GLES20DisplayList;

    iget-object v0, v0, Landroid/view/GLES20DisplayList;->mBitmaps:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    .registers 6
    .parameter "bitmap"
    .parameter "src"
    .parameter "dst"
    .parameter "paint"

    .prologue
    invoke-super {p0, p1, p2, p3, p4}, Landroid/view/GLES20Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    iget-object v0, p0, Landroid/view/GLES20RecordingCanvas;->mDisplayList:Landroid/view/GLES20DisplayList;

    iget-object v0, v0, Landroid/view/GLES20DisplayList;->mBitmaps:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    .registers 6
    .parameter "bitmap"
    .parameter "src"
    .parameter "dst"
    .parameter "paint"

    .prologue
    invoke-super {p0, p1, p2, p3, p4}, Landroid/view/GLES20Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V

    iget-object v0, p0, Landroid/view/GLES20RecordingCanvas;->mDisplayList:Landroid/view/GLES20DisplayList;

    iget-object v0, v0, Landroid/view/GLES20DisplayList;->mBitmaps:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public drawBitmap([IIIFFIIZLandroid/graphics/Paint;)V
    .registers 10
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
    invoke-super/range {p0 .. p9}, Landroid/view/GLES20Canvas;->drawBitmap([IIIFFIIZLandroid/graphics/Paint;)V

    return-void
.end method

.method public drawBitmap([IIIIIIIZLandroid/graphics/Paint;)V
    .registers 10
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
    invoke-super/range {p0 .. p9}, Landroid/view/GLES20Canvas;->drawBitmap([IIIIIIIZLandroid/graphics/Paint;)V

    return-void
.end method

.method public drawBitmapMesh(Landroid/graphics/Bitmap;II[FI[IILandroid/graphics/Paint;)V
    .registers 10
    .parameter "bitmap"
    .parameter "meshWidth"
    .parameter "meshHeight"
    .parameter "verts"
    .parameter "vertOffset"
    .parameter "colors"
    .parameter "colorOffset"
    .parameter "paint"

    .prologue
    invoke-super/range {p0 .. p8}, Landroid/view/GLES20Canvas;->drawBitmapMesh(Landroid/graphics/Bitmap;II[FI[IILandroid/graphics/Paint;)V

    iget-object v0, p0, Landroid/view/GLES20RecordingCanvas;->mDisplayList:Landroid/view/GLES20DisplayList;

    iget-object v0, v0, Landroid/view/GLES20DisplayList;->mBitmaps:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public drawCircle(FFFLandroid/graphics/Paint;)V
    .registers 5
    .parameter "cx"
    .parameter "cy"
    .parameter "radius"
    .parameter "paint"

    .prologue
    invoke-super {p0, p1, p2, p3, p4}, Landroid/view/GLES20Canvas;->drawCircle(FFFLandroid/graphics/Paint;)V

    invoke-direct {p0, p4}, Landroid/view/GLES20RecordingCanvas;->recordShaderBitmap(Landroid/graphics/Paint;)V

    return-void
.end method

.method public drawLine(FFFFLandroid/graphics/Paint;)V
    .registers 6
    .parameter "startX"
    .parameter "startY"
    .parameter "stopX"
    .parameter "stopY"
    .parameter "paint"

    .prologue
    invoke-super/range {p0 .. p5}, Landroid/view/GLES20Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    invoke-direct {p0, p5}, Landroid/view/GLES20RecordingCanvas;->recordShaderBitmap(Landroid/graphics/Paint;)V

    return-void
.end method

.method public drawLines([FIILandroid/graphics/Paint;)V
    .registers 5
    .parameter "pts"
    .parameter "offset"
    .parameter "count"
    .parameter "paint"

    .prologue
    invoke-super {p0, p1, p2, p3, p4}, Landroid/view/GLES20Canvas;->drawLines([FIILandroid/graphics/Paint;)V

    invoke-direct {p0, p4}, Landroid/view/GLES20RecordingCanvas;->recordShaderBitmap(Landroid/graphics/Paint;)V

    return-void
.end method

.method public drawLines([FLandroid/graphics/Paint;)V
    .registers 3
    .parameter "pts"
    .parameter "paint"

    .prologue
    invoke-super {p0, p1, p2}, Landroid/view/GLES20Canvas;->drawLines([FLandroid/graphics/Paint;)V

    invoke-direct {p0, p2}, Landroid/view/GLES20RecordingCanvas;->recordShaderBitmap(Landroid/graphics/Paint;)V

    return-void
.end method

.method public drawOval(Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    .registers 3
    .parameter "oval"
    .parameter "paint"

    .prologue
    invoke-super {p0, p1, p2}, Landroid/view/GLES20Canvas;->drawOval(Landroid/graphics/RectF;Landroid/graphics/Paint;)V

    invoke-direct {p0, p2}, Landroid/view/GLES20RecordingCanvas;->recordShaderBitmap(Landroid/graphics/Paint;)V

    return-void
.end method

.method public drawPaint(Landroid/graphics/Paint;)V
    .registers 2
    .parameter "paint"

    .prologue
    invoke-super {p0, p1}, Landroid/view/GLES20Canvas;->drawPaint(Landroid/graphics/Paint;)V

    invoke-direct {p0, p1}, Landroid/view/GLES20RecordingCanvas;->recordShaderBitmap(Landroid/graphics/Paint;)V

    return-void
.end method

.method public drawPatch(Landroid/graphics/Bitmap;[BLandroid/graphics/RectF;Landroid/graphics/Paint;)V
    .registers 6
    .parameter "bitmap"
    .parameter "chunks"
    .parameter "dst"
    .parameter "paint"

    .prologue
    invoke-super {p0, p1, p2, p3, p4}, Landroid/view/GLES20Canvas;->drawPatch(Landroid/graphics/Bitmap;[BLandroid/graphics/RectF;Landroid/graphics/Paint;)V

    iget-object v0, p0, Landroid/view/GLES20RecordingCanvas;->mDisplayList:Landroid/view/GLES20DisplayList;

    iget-object v0, v0, Landroid/view/GLES20DisplayList;->mBitmaps:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V
    .registers 3
    .parameter "path"
    .parameter "paint"

    .prologue
    invoke-super {p0, p1, p2}, Landroid/view/GLES20Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    invoke-direct {p0, p2}, Landroid/view/GLES20RecordingCanvas;->recordShaderBitmap(Landroid/graphics/Paint;)V

    return-void
.end method

.method public drawPoint(FFLandroid/graphics/Paint;)V
    .registers 4
    .parameter "x"
    .parameter "y"
    .parameter "paint"

    .prologue
    invoke-super {p0, p1, p2, p3}, Landroid/view/GLES20Canvas;->drawPoint(FFLandroid/graphics/Paint;)V

    invoke-direct {p0, p3}, Landroid/view/GLES20RecordingCanvas;->recordShaderBitmap(Landroid/graphics/Paint;)V

    return-void
.end method

.method public drawPoints([FIILandroid/graphics/Paint;)V
    .registers 5
    .parameter "pts"
    .parameter "offset"
    .parameter "count"
    .parameter "paint"

    .prologue
    invoke-super {p0, p1, p2, p3, p4}, Landroid/view/GLES20Canvas;->drawPoints([FIILandroid/graphics/Paint;)V

    invoke-direct {p0, p4}, Landroid/view/GLES20RecordingCanvas;->recordShaderBitmap(Landroid/graphics/Paint;)V

    return-void
.end method

.method public drawPoints([FLandroid/graphics/Paint;)V
    .registers 3
    .parameter "pts"
    .parameter "paint"

    .prologue
    invoke-super {p0, p1, p2}, Landroid/view/GLES20Canvas;->drawPoints([FLandroid/graphics/Paint;)V

    invoke-direct {p0, p2}, Landroid/view/GLES20RecordingCanvas;->recordShaderBitmap(Landroid/graphics/Paint;)V

    return-void
.end method

.method public drawPosText(Ljava/lang/String;[FLandroid/graphics/Paint;)V
    .registers 4
    .parameter "text"
    .parameter "pos"
    .parameter "paint"

    .prologue
    invoke-super {p0, p1, p2, p3}, Landroid/view/GLES20Canvas;->drawPosText(Ljava/lang/String;[FLandroid/graphics/Paint;)V

    invoke-direct {p0, p3}, Landroid/view/GLES20RecordingCanvas;->recordShaderBitmap(Landroid/graphics/Paint;)V

    return-void
.end method

.method public drawPosText([CII[FLandroid/graphics/Paint;)V
    .registers 6
    .parameter "text"
    .parameter "index"
    .parameter "count"
    .parameter "pos"
    .parameter "paint"

    .prologue
    invoke-super/range {p0 .. p5}, Landroid/view/GLES20Canvas;->drawPosText([CII[FLandroid/graphics/Paint;)V

    invoke-direct {p0, p5}, Landroid/view/GLES20RecordingCanvas;->recordShaderBitmap(Landroid/graphics/Paint;)V

    return-void
.end method

.method public drawRect(FFFFLandroid/graphics/Paint;)V
    .registers 6
    .parameter "left"
    .parameter "top"
    .parameter "right"
    .parameter "bottom"
    .parameter "paint"

    .prologue
    invoke-super/range {p0 .. p5}, Landroid/view/GLES20Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    invoke-direct {p0, p5}, Landroid/view/GLES20RecordingCanvas;->recordShaderBitmap(Landroid/graphics/Paint;)V

    return-void
.end method

.method public drawRect(Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    .registers 3
    .parameter "r"
    .parameter "paint"

    .prologue
    invoke-super {p0, p1, p2}, Landroid/view/GLES20Canvas;->drawRect(Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    invoke-direct {p0, p2}, Landroid/view/GLES20RecordingCanvas;->recordShaderBitmap(Landroid/graphics/Paint;)V

    return-void
.end method

.method public drawRect(Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    .registers 3
    .parameter "r"
    .parameter "paint"

    .prologue
    invoke-super {p0, p1, p2}, Landroid/view/GLES20Canvas;->drawRect(Landroid/graphics/RectF;Landroid/graphics/Paint;)V

    invoke-direct {p0, p2}, Landroid/view/GLES20RecordingCanvas;->recordShaderBitmap(Landroid/graphics/Paint;)V

    return-void
.end method

.method public drawRoundRect(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V
    .registers 5
    .parameter "rect"
    .parameter "rx"
    .parameter "ry"
    .parameter "paint"

    .prologue
    invoke-super {p0, p1, p2, p3, p4}, Landroid/view/GLES20Canvas;->drawRoundRect(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V

    invoke-direct {p0, p4}, Landroid/view/GLES20RecordingCanvas;->recordShaderBitmap(Landroid/graphics/Paint;)V

    return-void
.end method

.method public drawText(Ljava/lang/CharSequence;IIFFLandroid/graphics/Paint;)V
    .registers 7
    .parameter "text"
    .parameter "start"
    .parameter "end"
    .parameter "x"
    .parameter "y"
    .parameter "paint"

    .prologue
    invoke-super/range {p0 .. p6}, Landroid/view/GLES20Canvas;->drawText(Ljava/lang/CharSequence;IIFFLandroid/graphics/Paint;)V

    invoke-direct {p0, p6}, Landroid/view/GLES20RecordingCanvas;->recordShaderBitmap(Landroid/graphics/Paint;)V

    return-void
.end method

.method public drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    .registers 5
    .parameter "text"
    .parameter "x"
    .parameter "y"
    .parameter "paint"

    .prologue
    invoke-super {p0, p1, p2, p3, p4}, Landroid/view/GLES20Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    invoke-direct {p0, p4}, Landroid/view/GLES20RecordingCanvas;->recordShaderBitmap(Landroid/graphics/Paint;)V

    return-void
.end method

.method public drawText(Ljava/lang/String;IIFFLandroid/graphics/Paint;)V
    .registers 7
    .parameter "text"
    .parameter "start"
    .parameter "end"
    .parameter "x"
    .parameter "y"
    .parameter "paint"

    .prologue
    invoke-super/range {p0 .. p6}, Landroid/view/GLES20Canvas;->drawText(Ljava/lang/String;IIFFLandroid/graphics/Paint;)V

    invoke-direct {p0, p6}, Landroid/view/GLES20RecordingCanvas;->recordShaderBitmap(Landroid/graphics/Paint;)V

    return-void
.end method

.method public drawText([CIIFFLandroid/graphics/Paint;)V
    .registers 7
    .parameter "text"
    .parameter "index"
    .parameter "count"
    .parameter "x"
    .parameter "y"
    .parameter "paint"

    .prologue
    invoke-super/range {p0 .. p6}, Landroid/view/GLES20Canvas;->drawText([CIIFFLandroid/graphics/Paint;)V

    invoke-direct {p0, p6}, Landroid/view/GLES20RecordingCanvas;->recordShaderBitmap(Landroid/graphics/Paint;)V

    return-void
.end method

.method public drawTextOnPath(Ljava/lang/String;Landroid/graphics/Path;FFLandroid/graphics/Paint;)V
    .registers 6
    .parameter "text"
    .parameter "path"
    .parameter "hOffset"
    .parameter "vOffset"
    .parameter "paint"

    .prologue
    invoke-super/range {p0 .. p5}, Landroid/view/GLES20Canvas;->drawTextOnPath(Ljava/lang/String;Landroid/graphics/Path;FFLandroid/graphics/Paint;)V

    invoke-direct {p0, p5}, Landroid/view/GLES20RecordingCanvas;->recordShaderBitmap(Landroid/graphics/Paint;)V

    return-void
.end method

.method public drawTextOnPath([CIILandroid/graphics/Path;FFLandroid/graphics/Paint;)V
    .registers 8
    .parameter "text"
    .parameter "index"
    .parameter "count"
    .parameter "path"
    .parameter "hOffset"
    .parameter "vOffset"
    .parameter "paint"

    .prologue
    invoke-super/range {p0 .. p7}, Landroid/view/GLES20Canvas;->drawTextOnPath([CIILandroid/graphics/Path;FFLandroid/graphics/Paint;)V

    invoke-direct {p0, p7}, Landroid/view/GLES20RecordingCanvas;->recordShaderBitmap(Landroid/graphics/Paint;)V

    return-void
.end method

.method public drawTextRun(Ljava/lang/CharSequence;IIIIFFILandroid/graphics/Paint;)V
    .registers 10
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
    invoke-super/range {p0 .. p9}, Landroid/view/GLES20Canvas;->drawTextRun(Ljava/lang/CharSequence;IIIIFFILandroid/graphics/Paint;)V

    invoke-direct {p0, p9}, Landroid/view/GLES20RecordingCanvas;->recordShaderBitmap(Landroid/graphics/Paint;)V

    return-void
.end method

.method public drawTextRun([CIIIIFFILandroid/graphics/Paint;)V
    .registers 10
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
    invoke-super/range {p0 .. p9}, Landroid/view/GLES20Canvas;->drawTextRun([CIIIIFFILandroid/graphics/Paint;)V

    invoke-direct {p0, p9}, Landroid/view/GLES20RecordingCanvas;->recordShaderBitmap(Landroid/graphics/Paint;)V

    return-void
.end method

.method public drawVertices(Landroid/graphics/Canvas$VertexMode;I[FI[FI[II[SIILandroid/graphics/Paint;)V
    .registers 13
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
    invoke-super/range {p0 .. p12}, Landroid/view/GLES20Canvas;->drawVertices(Landroid/graphics/Canvas$VertexMode;I[FI[FI[II[SIILandroid/graphics/Paint;)V

    invoke-direct {p0, p12}, Landroid/view/GLES20RecordingCanvas;->recordShaderBitmap(Landroid/graphics/Paint;)V

    return-void
.end method

.method end(I)I
    .registers 3
    .parameter "nativeDisplayList"

    .prologue
    invoke-virtual {p0, p1}, Landroid/view/GLES20RecordingCanvas;->getDisplayList(I)I

    move-result v0

    return v0
.end method

.method public getNextPoolable()Landroid/view/GLES20RecordingCanvas;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/view/GLES20RecordingCanvas;->mNextPoolable:Landroid/view/GLES20RecordingCanvas;

    return-object v0
.end method

.method public bridge synthetic getNextPoolable()Ljava/lang/Object;
    .registers 2

    .prologue
    invoke-virtual {p0}, Landroid/view/GLES20RecordingCanvas;->getNextPoolable()Landroid/view/GLES20RecordingCanvas;

    move-result-object v0

    return-object v0
.end method

.method public isPooled()Z
    .registers 2

    .prologue
    iget-boolean v0, p0, Landroid/view/GLES20RecordingCanvas;->mIsPooled:Z

    return v0
.end method

.method recycle()V
    .registers 2

    .prologue
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/view/GLES20RecordingCanvas;->mDisplayList:Landroid/view/GLES20DisplayList;

    invoke-virtual {p0}, Landroid/view/GLES20RecordingCanvas;->resetDisplayListRenderer()V

    sget-object v0, Landroid/view/GLES20RecordingCanvas;->sPool:Landroid/util/Pool;

    invoke-interface {v0, p0}, Landroid/util/Pool;->release(Landroid/util/Poolable;)V

    return-void
.end method

.method public setNextPoolable(Landroid/view/GLES20RecordingCanvas;)V
    .registers 2
    .parameter "element"

    .prologue
    iput-object p1, p0, Landroid/view/GLES20RecordingCanvas;->mNextPoolable:Landroid/view/GLES20RecordingCanvas;

    return-void
.end method

.method public bridge synthetic setNextPoolable(Ljava/lang/Object;)V
    .registers 2
    .parameter "x0"

    .prologue
    check-cast p1, Landroid/view/GLES20RecordingCanvas;

    .end local p1
    invoke-virtual {p0, p1}, Landroid/view/GLES20RecordingCanvas;->setNextPoolable(Landroid/view/GLES20RecordingCanvas;)V

    return-void
.end method

.method public setPooled(Z)V
    .registers 2
    .parameter "isPooled"

    .prologue
    iput-boolean p1, p0, Landroid/view/GLES20RecordingCanvas;->mIsPooled:Z

    return-void
.end method

.method start()V
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/view/GLES20RecordingCanvas;->mDisplayList:Landroid/view/GLES20DisplayList;

    iget-object v0, v0, Landroid/view/GLES20DisplayList;->mBitmaps:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    return-void
.end method
