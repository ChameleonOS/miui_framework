.class Landroid/view/GLES20DisplayList;
.super Landroid/view/DisplayList;
.source "GLES20DisplayList.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/view/GLES20DisplayList$DisplayListFinalizer;
    }
.end annotation


# instance fields
.field final mBitmaps:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation
.end field

.field private mCanvas:Landroid/view/GLES20RecordingCanvas;

.field private mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

.field private final mName:Ljava/lang/String;

.field private mValid:Z


# direct methods
.method constructor <init>(Ljava/lang/String;)V
    .registers 4
    .parameter "name"

    .prologue
    .line 42
    invoke-direct {p0}, Landroid/view/DisplayList;-><init>()V

    .line 30
    new-instance v0, Ljava/util/ArrayList;

    const/4 v1, 0x5

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Landroid/view/GLES20DisplayList;->mBitmaps:Ljava/util/ArrayList;

    .line 43
    iput-object p1, p0, Landroid/view/GLES20DisplayList;->mName:Ljava/lang/String;

    .line 44
    return-void
.end method

.method private static native nOffsetLeftRight(II)V
.end method

.method private static native nOffsetTopBottom(II)V
.end method

.method private static native nSetAlpha(IF)V
.end method

.method private static native nSetAnimationMatrix(II)V
.end method

.method private static native nSetBottom(II)V
.end method

.method private static native nSetCaching(IZ)V
.end method

.method private static native nSetCameraDistance(IF)V
.end method

.method private static native nSetClipChildren(IZ)V
.end method

.method private static native nSetHasOverlappingRendering(IZ)V
.end method

.method private static native nSetLeft(II)V
.end method

.method private static native nSetLeftTop(III)V
.end method

.method private static native nSetLeftTopRightBottom(IIIII)V
.end method

.method private static native nSetPivotX(IF)V
.end method

.method private static native nSetPivotY(IF)V
.end method

.method private static native nSetRight(II)V
.end method

.method private static native nSetRotation(IF)V
.end method

.method private static native nSetRotationX(IF)V
.end method

.method private static native nSetRotationY(IF)V
.end method

.method private static native nSetScaleX(IF)V
.end method

.method private static native nSetScaleY(IF)V
.end method

.method private static native nSetStaticMatrix(II)V
.end method

.method private static native nSetTop(II)V
.end method

.method private static native nSetTransformationInfo(IFFFFFFFF)V
.end method

.method private static native nSetTranslationX(IF)V
.end method

.method private static native nSetTranslationY(IF)V
.end method


# virtual methods
.method public clear()V
    .registers 2

    .prologue
    .line 80
    iget-boolean v0, p0, Landroid/view/GLES20DisplayList;->mValid:Z

    if-nez v0, :cond_9

    .line 81
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mBitmaps:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 83
    :cond_9
    return-void
.end method

.method public end()V
    .registers 4

    .prologue
    .line 92
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mCanvas:Landroid/view/GLES20RecordingCanvas;

    if-eqz v0, :cond_1c

    .line 93
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    if-eqz v0, :cond_1d

    .line 94
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mCanvas:Landroid/view/GLES20RecordingCanvas;

    iget-object v1, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    iget v1, v1, Landroid/view/GLES20DisplayList$DisplayListFinalizer;->mNativeDisplayList:I

    invoke-virtual {v0, v1}, Landroid/view/GLES20RecordingCanvas;->end(I)I

    .line 99
    :goto_11
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mCanvas:Landroid/view/GLES20RecordingCanvas;

    invoke-virtual {v0}, Landroid/view/GLES20RecordingCanvas;->recycle()V

    .line 100
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/view/GLES20DisplayList;->mCanvas:Landroid/view/GLES20RecordingCanvas;

    .line 101
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/view/GLES20DisplayList;->mValid:Z

    .line 103
    :cond_1c
    return-void

    .line 96
    :cond_1d
    new-instance v0, Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    iget-object v1, p0, Landroid/view/GLES20DisplayList;->mCanvas:Landroid/view/GLES20RecordingCanvas;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/view/GLES20RecordingCanvas;->end(I)I

    move-result v1

    invoke-direct {v0, v1}, Landroid/view/GLES20DisplayList$DisplayListFinalizer;-><init>(I)V

    iput-object v0, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    .line 97
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    iget v0, v0, Landroid/view/GLES20DisplayList$DisplayListFinalizer;->mNativeDisplayList:I

    iget-object v1, p0, Landroid/view/GLES20DisplayList;->mName:Ljava/lang/String;

    invoke-static {v0, v1}, Landroid/view/GLES20Canvas;->setDisplayListName(ILjava/lang/String;)V

    goto :goto_11
.end method

.method getNativeDisplayList()I
    .registers 3

    .prologue
    .line 51
    iget-boolean v0, p0, Landroid/view/GLES20DisplayList;->mValid:Z

    if-eqz v0, :cond_8

    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    if-nez v0, :cond_10

    .line 52
    :cond_8
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "The display list is not valid."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 54
    :cond_10
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    iget v0, v0, Landroid/view/GLES20DisplayList$DisplayListFinalizer;->mNativeDisplayList:I

    return v0
.end method

.method public getSize()I
    .registers 2

    .prologue
    .line 107
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    if-nez v0, :cond_6

    const/4 v0, 0x0

    .line 108
    :goto_5
    return v0

    :cond_6
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    iget v0, v0, Landroid/view/GLES20DisplayList$DisplayListFinalizer;->mNativeDisplayList:I

    invoke-static {v0}, Landroid/view/GLES20Canvas;->getDisplayListSize(I)I

    move-result v0

    goto :goto_5
.end method

.method hasNativeDisplayList()Z
    .registers 2

    .prologue
    .line 47
    iget-boolean v0, p0, Landroid/view/GLES20DisplayList;->mValid:Z

    if-eqz v0, :cond_a

    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    if-eqz v0, :cond_a

    const/4 v0, 0x1

    :goto_9
    return v0

    :cond_a
    const/4 v0, 0x0

    goto :goto_9
.end method

.method public invalidate()V
    .registers 2

    .prologue
    .line 71
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mCanvas:Landroid/view/GLES20RecordingCanvas;

    if-eqz v0, :cond_c

    .line 72
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mCanvas:Landroid/view/GLES20RecordingCanvas;

    invoke-virtual {v0}, Landroid/view/GLES20RecordingCanvas;->recycle()V

    .line 73
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/view/GLES20DisplayList;->mCanvas:Landroid/view/GLES20RecordingCanvas;

    .line 75
    :cond_c
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/view/GLES20DisplayList;->mValid:Z

    .line 76
    return-void
.end method

.method public isValid()Z
    .registers 2

    .prologue
    .line 87
    iget-boolean v0, p0, Landroid/view/GLES20DisplayList;->mValid:Z

    return v0
.end method

.method public offsetLeftRight(I)V
    .registers 3
    .parameter "offset"

    .prologue
    .line 281
    invoke-virtual {p0}, Landroid/view/GLES20DisplayList;->hasNativeDisplayList()Z

    move-result v0

    if-eqz v0, :cond_d

    .line 282
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    iget v0, v0, Landroid/view/GLES20DisplayList$DisplayListFinalizer;->mNativeDisplayList:I

    invoke-static {v0, p1}, Landroid/view/GLES20DisplayList;->nOffsetLeftRight(II)V

    .line 284
    :cond_d
    return-void
.end method

.method public offsetTopBottom(I)V
    .registers 3
    .parameter "offset"

    .prologue
    .line 288
    invoke-virtual {p0}, Landroid/view/GLES20DisplayList;->hasNativeDisplayList()Z

    move-result v0

    if-eqz v0, :cond_d

    .line 289
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    iget v0, v0, Landroid/view/GLES20DisplayList$DisplayListFinalizer;->mNativeDisplayList:I

    invoke-static {v0, p1}, Landroid/view/GLES20DisplayList;->nOffsetTopBottom(II)V

    .line 291
    :cond_d
    return-void
.end method

.method public setAlpha(F)V
    .registers 3
    .parameter "alpha"

    .prologue
    .line 146
    invoke-virtual {p0}, Landroid/view/GLES20DisplayList;->hasNativeDisplayList()Z

    move-result v0

    if-eqz v0, :cond_d

    .line 147
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    iget v0, v0, Landroid/view/GLES20DisplayList$DisplayListFinalizer;->mNativeDisplayList:I

    invoke-static {v0, p1}, Landroid/view/GLES20DisplayList;->nSetAlpha(IF)V

    .line 149
    :cond_d
    return-void
.end method

.method public setAnimationMatrix(Landroid/graphics/Matrix;)V
    .registers 4
    .parameter "matrix"

    .prologue
    .line 138
    invoke-virtual {p0}, Landroid/view/GLES20DisplayList;->hasNativeDisplayList()Z

    move-result v0

    if-eqz v0, :cond_11

    .line 139
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    iget v1, v0, Landroid/view/GLES20DisplayList$DisplayListFinalizer;->mNativeDisplayList:I

    if-eqz p1, :cond_12

    iget v0, p1, Landroid/graphics/Matrix;->native_instance:I

    :goto_e
    invoke-static {v1, v0}, Landroid/view/GLES20DisplayList;->nSetAnimationMatrix(II)V

    .line 142
    :cond_11
    return-void

    .line 139
    :cond_12
    const/4 v0, 0x0

    goto :goto_e
.end method

.method public setBottom(I)V
    .registers 3
    .parameter "bottom"

    .prologue
    .line 260
    invoke-virtual {p0}, Landroid/view/GLES20DisplayList;->hasNativeDisplayList()Z

    move-result v0

    if-eqz v0, :cond_d

    .line 261
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    iget v0, v0, Landroid/view/GLES20DisplayList$DisplayListFinalizer;->mNativeDisplayList:I

    invoke-static {v0, p1}, Landroid/view/GLES20DisplayList;->nSetBottom(II)V

    .line 263
    :cond_d
    return-void
.end method

.method public setCaching(Z)V
    .registers 3
    .parameter "caching"

    .prologue
    .line 117
    invoke-virtual {p0}, Landroid/view/GLES20DisplayList;->hasNativeDisplayList()Z

    move-result v0

    if-eqz v0, :cond_d

    .line 118
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    iget v0, v0, Landroid/view/GLES20DisplayList$DisplayListFinalizer;->mNativeDisplayList:I

    invoke-static {v0, p1}, Landroid/view/GLES20DisplayList;->nSetCaching(IZ)V

    .line 120
    :cond_d
    return-void
.end method

.method public setCameraDistance(F)V
    .registers 3
    .parameter "distance"

    .prologue
    .line 232
    invoke-virtual {p0}, Landroid/view/GLES20DisplayList;->hasNativeDisplayList()Z

    move-result v0

    if-eqz v0, :cond_d

    .line 233
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    iget v0, v0, Landroid/view/GLES20DisplayList$DisplayListFinalizer;->mNativeDisplayList:I

    invoke-static {v0, p1}, Landroid/view/GLES20DisplayList;->nSetCameraDistance(IF)V

    .line 235
    :cond_d
    return-void
.end method

.method public setClipChildren(Z)V
    .registers 3
    .parameter "clipChildren"

    .prologue
    .line 124
    invoke-virtual {p0}, Landroid/view/GLES20DisplayList;->hasNativeDisplayList()Z

    move-result v0

    if-eqz v0, :cond_d

    .line 125
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    iget v0, v0, Landroid/view/GLES20DisplayList$DisplayListFinalizer;->mNativeDisplayList:I

    invoke-static {v0, p1}, Landroid/view/GLES20DisplayList;->nSetClipChildren(IZ)V

    .line 127
    :cond_d
    return-void
.end method

.method public setHasOverlappingRendering(Z)V
    .registers 3
    .parameter "hasOverlappingRendering"

    .prologue
    .line 153
    invoke-virtual {p0}, Landroid/view/GLES20DisplayList;->hasNativeDisplayList()Z

    move-result v0

    if-eqz v0, :cond_d

    .line 154
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    iget v0, v0, Landroid/view/GLES20DisplayList$DisplayListFinalizer;->mNativeDisplayList:I

    invoke-static {v0, p1}, Landroid/view/GLES20DisplayList;->nSetHasOverlappingRendering(IZ)V

    .line 156
    :cond_d
    return-void
.end method

.method public setLeft(I)V
    .registers 3
    .parameter "left"

    .prologue
    .line 239
    invoke-virtual {p0}, Landroid/view/GLES20DisplayList;->hasNativeDisplayList()Z

    move-result v0

    if-eqz v0, :cond_d

    .line 240
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    iget v0, v0, Landroid/view/GLES20DisplayList$DisplayListFinalizer;->mNativeDisplayList:I

    invoke-static {v0, p1}, Landroid/view/GLES20DisplayList;->nSetLeft(II)V

    .line 242
    :cond_d
    return-void
.end method

.method public setLeftTop(II)V
    .registers 4
    .parameter "left"
    .parameter "top"

    .prologue
    .line 267
    invoke-virtual {p0}, Landroid/view/GLES20DisplayList;->hasNativeDisplayList()Z

    move-result v0

    if-eqz v0, :cond_d

    .line 268
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    iget v0, v0, Landroid/view/GLES20DisplayList$DisplayListFinalizer;->mNativeDisplayList:I

    invoke-static {v0, p1, p2}, Landroid/view/GLES20DisplayList;->nSetLeftTop(III)V

    .line 270
    :cond_d
    return-void
.end method

.method public setLeftTopRightBottom(IIII)V
    .registers 6
    .parameter "left"
    .parameter "top"
    .parameter "right"
    .parameter "bottom"

    .prologue
    .line 274
    invoke-virtual {p0}, Landroid/view/GLES20DisplayList;->hasNativeDisplayList()Z

    move-result v0

    if-eqz v0, :cond_d

    .line 275
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    iget v0, v0, Landroid/view/GLES20DisplayList$DisplayListFinalizer;->mNativeDisplayList:I

    invoke-static {v0, p1, p2, p3, p4}, Landroid/view/GLES20DisplayList;->nSetLeftTopRightBottom(IIIII)V

    .line 277
    :cond_d
    return-void
.end method

.method public setPivotX(F)V
    .registers 3
    .parameter "pivotX"

    .prologue
    .line 218
    invoke-virtual {p0}, Landroid/view/GLES20DisplayList;->hasNativeDisplayList()Z

    move-result v0

    if-eqz v0, :cond_d

    .line 219
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    iget v0, v0, Landroid/view/GLES20DisplayList$DisplayListFinalizer;->mNativeDisplayList:I

    invoke-static {v0, p1}, Landroid/view/GLES20DisplayList;->nSetPivotX(IF)V

    .line 221
    :cond_d
    return-void
.end method

.method public setPivotY(F)V
    .registers 3
    .parameter "pivotY"

    .prologue
    .line 225
    invoke-virtual {p0}, Landroid/view/GLES20DisplayList;->hasNativeDisplayList()Z

    move-result v0

    if-eqz v0, :cond_d

    .line 226
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    iget v0, v0, Landroid/view/GLES20DisplayList$DisplayListFinalizer;->mNativeDisplayList:I

    invoke-static {v0, p1}, Landroid/view/GLES20DisplayList;->nSetPivotY(IF)V

    .line 228
    :cond_d
    return-void
.end method

.method public setRight(I)V
    .registers 3
    .parameter "right"

    .prologue
    .line 253
    invoke-virtual {p0}, Landroid/view/GLES20DisplayList;->hasNativeDisplayList()Z

    move-result v0

    if-eqz v0, :cond_d

    .line 254
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    iget v0, v0, Landroid/view/GLES20DisplayList$DisplayListFinalizer;->mNativeDisplayList:I

    invoke-static {v0, p1}, Landroid/view/GLES20DisplayList;->nSetRight(II)V

    .line 256
    :cond_d
    return-void
.end method

.method public setRotation(F)V
    .registers 3
    .parameter "rotation"

    .prologue
    .line 174
    invoke-virtual {p0}, Landroid/view/GLES20DisplayList;->hasNativeDisplayList()Z

    move-result v0

    if-eqz v0, :cond_d

    .line 175
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    iget v0, v0, Landroid/view/GLES20DisplayList$DisplayListFinalizer;->mNativeDisplayList:I

    invoke-static {v0, p1}, Landroid/view/GLES20DisplayList;->nSetRotation(IF)V

    .line 177
    :cond_d
    return-void
.end method

.method public setRotationX(F)V
    .registers 3
    .parameter "rotationX"

    .prologue
    .line 181
    invoke-virtual {p0}, Landroid/view/GLES20DisplayList;->hasNativeDisplayList()Z

    move-result v0

    if-eqz v0, :cond_d

    .line 182
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    iget v0, v0, Landroid/view/GLES20DisplayList$DisplayListFinalizer;->mNativeDisplayList:I

    invoke-static {v0, p1}, Landroid/view/GLES20DisplayList;->nSetRotationX(IF)V

    .line 184
    :cond_d
    return-void
.end method

.method public setRotationY(F)V
    .registers 3
    .parameter "rotationY"

    .prologue
    .line 188
    invoke-virtual {p0}, Landroid/view/GLES20DisplayList;->hasNativeDisplayList()Z

    move-result v0

    if-eqz v0, :cond_d

    .line 189
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    iget v0, v0, Landroid/view/GLES20DisplayList$DisplayListFinalizer;->mNativeDisplayList:I

    invoke-static {v0, p1}, Landroid/view/GLES20DisplayList;->nSetRotationY(IF)V

    .line 191
    :cond_d
    return-void
.end method

.method public setScaleX(F)V
    .registers 3
    .parameter "scaleX"

    .prologue
    .line 195
    invoke-virtual {p0}, Landroid/view/GLES20DisplayList;->hasNativeDisplayList()Z

    move-result v0

    if-eqz v0, :cond_d

    .line 196
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    iget v0, v0, Landroid/view/GLES20DisplayList$DisplayListFinalizer;->mNativeDisplayList:I

    invoke-static {v0, p1}, Landroid/view/GLES20DisplayList;->nSetScaleX(IF)V

    .line 198
    :cond_d
    return-void
.end method

.method public setScaleY(F)V
    .registers 3
    .parameter "scaleY"

    .prologue
    .line 202
    invoke-virtual {p0}, Landroid/view/GLES20DisplayList;->hasNativeDisplayList()Z

    move-result v0

    if-eqz v0, :cond_d

    .line 203
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    iget v0, v0, Landroid/view/GLES20DisplayList$DisplayListFinalizer;->mNativeDisplayList:I

    invoke-static {v0, p1}, Landroid/view/GLES20DisplayList;->nSetScaleY(IF)V

    .line 205
    :cond_d
    return-void
.end method

.method public setStaticMatrix(Landroid/graphics/Matrix;)V
    .registers 4
    .parameter "matrix"

    .prologue
    .line 131
    invoke-virtual {p0}, Landroid/view/GLES20DisplayList;->hasNativeDisplayList()Z

    move-result v0

    if-eqz v0, :cond_f

    .line 132
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    iget v0, v0, Landroid/view/GLES20DisplayList$DisplayListFinalizer;->mNativeDisplayList:I

    iget v1, p1, Landroid/graphics/Matrix;->native_instance:I

    invoke-static {v0, v1}, Landroid/view/GLES20DisplayList;->nSetStaticMatrix(II)V

    .line 134
    :cond_f
    return-void
.end method

.method public setTop(I)V
    .registers 3
    .parameter "top"

    .prologue
    .line 246
    invoke-virtual {p0}, Landroid/view/GLES20DisplayList;->hasNativeDisplayList()Z

    move-result v0

    if-eqz v0, :cond_d

    .line 247
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    iget v0, v0, Landroid/view/GLES20DisplayList$DisplayListFinalizer;->mNativeDisplayList:I

    invoke-static {v0, p1}, Landroid/view/GLES20DisplayList;->nSetTop(II)V

    .line 249
    :cond_d
    return-void
.end method

.method public setTransformationInfo(FFFFFFFF)V
    .registers 18
    .parameter "alpha"
    .parameter "translationX"
    .parameter "translationY"
    .parameter "rotation"
    .parameter "rotationX"
    .parameter "rotationY"
    .parameter "scaleX"
    .parameter "scaleY"

    .prologue
    .line 210
    invoke-virtual {p0}, Landroid/view/GLES20DisplayList;->hasNativeDisplayList()Z

    move-result v0

    if-eqz v0, :cond_17

    .line 211
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    iget v0, v0, Landroid/view/GLES20DisplayList$DisplayListFinalizer;->mNativeDisplayList:I

    move v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    move v5, p5

    move v6, p6

    move/from16 v7, p7

    move/from16 v8, p8

    invoke-static/range {v0 .. v8}, Landroid/view/GLES20DisplayList;->nSetTransformationInfo(IFFFFFFFF)V

    .line 214
    :cond_17
    return-void
.end method

.method public setTranslationX(F)V
    .registers 3
    .parameter "translationX"

    .prologue
    .line 160
    invoke-virtual {p0}, Landroid/view/GLES20DisplayList;->hasNativeDisplayList()Z

    move-result v0

    if-eqz v0, :cond_d

    .line 161
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    iget v0, v0, Landroid/view/GLES20DisplayList$DisplayListFinalizer;->mNativeDisplayList:I

    invoke-static {v0, p1}, Landroid/view/GLES20DisplayList;->nSetTranslationX(IF)V

    .line 163
    :cond_d
    return-void
.end method

.method public setTranslationY(F)V
    .registers 3
    .parameter "translationY"

    .prologue
    .line 167
    invoke-virtual {p0}, Landroid/view/GLES20DisplayList;->hasNativeDisplayList()Z

    move-result v0

    if-eqz v0, :cond_d

    .line 168
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mFinalizer:Landroid/view/GLES20DisplayList$DisplayListFinalizer;

    iget v0, v0, Landroid/view/GLES20DisplayList$DisplayListFinalizer;->mNativeDisplayList:I

    invoke-static {v0, p1}, Landroid/view/GLES20DisplayList;->nSetTranslationY(IF)V

    .line 170
    :cond_d
    return-void
.end method

.method public start()Landroid/view/HardwareCanvas;
    .registers 3

    .prologue
    .line 59
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mCanvas:Landroid/view/GLES20RecordingCanvas;

    if-eqz v0, :cond_c

    .line 60
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Recording has already started"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 63
    :cond_c
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/view/GLES20DisplayList;->mValid:Z

    .line 64
    invoke-static {p0}, Landroid/view/GLES20RecordingCanvas;->obtain(Landroid/view/GLES20DisplayList;)Landroid/view/GLES20RecordingCanvas;

    move-result-object v0

    iput-object v0, p0, Landroid/view/GLES20DisplayList;->mCanvas:Landroid/view/GLES20RecordingCanvas;

    .line 65
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mCanvas:Landroid/view/GLES20RecordingCanvas;

    invoke-virtual {v0}, Landroid/view/GLES20RecordingCanvas;->start()V

    .line 66
    iget-object v0, p0, Landroid/view/GLES20DisplayList;->mCanvas:Landroid/view/GLES20RecordingCanvas;

    return-object v0
.end method
