.class public Landroid/graphics/YuvImage;
.super Ljava/lang/Object;
.source "YuvImage.java"


# static fields
.field private static final WORKING_COMPRESS_STORAGE:I = 0x1000


# instance fields
.field private mData:[B

.field private mFormat:I

.field private mHeight:I

.field private mStrides:[I

.field private mWidth:I


# direct methods
.method public constructor <init>([BIII[I)V
    .registers 8
    .parameter "yuv"
    .parameter "format"
    .parameter "width"
    .parameter "height"
    .parameter "strides"

    .prologue
    .line 79
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 80
    const/16 v0, 0x11

    if-eq p2, v0, :cond_14

    const/16 v0, 0x14

    if-eq p2, v0, :cond_14

    .line 82
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "only support ImageFormat.NV21 and ImageFormat.YUY2 for now"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 87
    :cond_14
    if-lez p3, :cond_18

    if-gtz p4, :cond_21

    .line 88
    :cond_18
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "width and height must large than 0"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 92
    :cond_21
    if-nez p1, :cond_2c

    .line 93
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "yuv cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 96
    :cond_2c
    if-nez p5, :cond_3d

    .line 97
    invoke-direct {p0, p3, p2}, Landroid/graphics/YuvImage;->calculateStrides(II)[I

    move-result-object v0

    iput-object v0, p0, Landroid/graphics/YuvImage;->mStrides:[I

    .line 102
    :goto_34
    iput-object p1, p0, Landroid/graphics/YuvImage;->mData:[B

    .line 103
    iput p2, p0, Landroid/graphics/YuvImage;->mFormat:I

    .line 104
    iput p3, p0, Landroid/graphics/YuvImage;->mWidth:I

    .line 105
    iput p4, p0, Landroid/graphics/YuvImage;->mHeight:I

    .line 106
    return-void

    .line 99
    :cond_3d
    iput-object p5, p0, Landroid/graphics/YuvImage;->mStrides:[I

    goto :goto_34
.end method

.method private adjustRectangle(Landroid/graphics/Rect;)V
    .registers 6
    .parameter "rect"

    .prologue
    .line 215
    invoke-virtual {p1}, Landroid/graphics/Rect;->width()I

    move-result v1

    .line 216
    .local v1, width:I
    invoke-virtual {p1}, Landroid/graphics/Rect;->height()I

    move-result v0

    .line 217
    .local v0, height:I
    iget v2, p0, Landroid/graphics/YuvImage;->mFormat:I

    const/16 v3, 0x11

    if-ne v2, v3, :cond_28

    .line 219
    and-int/lit8 v1, v1, -0x2

    .line 220
    and-int/lit8 v0, v0, -0x2

    .line 221
    iget v2, p1, Landroid/graphics/Rect;->left:I

    and-int/lit8 v2, v2, -0x2

    iput v2, p1, Landroid/graphics/Rect;->left:I

    .line 222
    iget v2, p1, Landroid/graphics/Rect;->top:I

    and-int/lit8 v2, v2, -0x2

    iput v2, p1, Landroid/graphics/Rect;->top:I

    .line 223
    iget v2, p1, Landroid/graphics/Rect;->left:I

    add-int/2addr v2, v1

    iput v2, p1, Landroid/graphics/Rect;->right:I

    .line 224
    iget v2, p1, Landroid/graphics/Rect;->top:I

    add-int/2addr v2, v0

    iput v2, p1, Landroid/graphics/Rect;->bottom:I

    .line 227
    :cond_28
    iget v2, p0, Landroid/graphics/YuvImage;->mFormat:I

    const/16 v3, 0x14

    if-ne v2, v3, :cond_3b

    .line 229
    and-int/lit8 v1, v1, -0x2

    .line 230
    iget v2, p1, Landroid/graphics/Rect;->left:I

    and-int/lit8 v2, v2, -0x2

    iput v2, p1, Landroid/graphics/Rect;->left:I

    .line 231
    iget v2, p1, Landroid/graphics/Rect;->left:I

    add-int/2addr v2, v1

    iput v2, p1, Landroid/graphics/Rect;->right:I

    .line 233
    :cond_3b
    return-void
.end method

.method private calculateStrides(II)[I
    .registers 8
    .parameter "width"
    .parameter "format"

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 200
    const/4 v0, 0x0

    .line 201
    .local v0, strides:[I
    const/16 v2, 0x11

    if-ne p2, v2, :cond_10

    .line 202
    const/4 v2, 0x2

    new-array v0, v2, [I

    .end local v0           #strides:[I
    aput p1, v0, v3

    aput p1, v0, v4

    .restart local v0       #strides:[I
    move-object v1, v0

    .line 211
    .end local v0           #strides:[I
    .local v1, strides:[I
    :goto_f
    return-object v1

    .line 206
    .end local v1           #strides:[I
    .restart local v0       #strides:[I
    :cond_10
    const/16 v2, 0x14

    if-ne p2, v2, :cond_1c

    .line 207
    new-array v0, v4, [I

    .end local v0           #strides:[I
    mul-int/lit8 v2, p1, 0x2

    aput v2, v0, v3

    .restart local v0       #strides:[I
    move-object v1, v0

    .line 208
    .end local v0           #strides:[I
    .restart local v1       #strides:[I
    goto :goto_f

    .end local v1           #strides:[I
    .restart local v0       #strides:[I
    :cond_1c
    move-object v1, v0

    .line 211
    .end local v0           #strides:[I
    .restart local v1       #strides:[I
    goto :goto_f
.end method

.method private static native nativeCompressToJpeg([BIII[I[IILjava/io/OutputStream;[B)Z
.end method


# virtual methods
.method calculateOffsets(II)[I
    .registers 9
    .parameter "left"
    .parameter "top"

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 183
    const/4 v0, 0x0

    .line 184
    .local v0, offsets:[I
    iget v2, p0, Landroid/graphics/YuvImage;->mFormat:I

    const/16 v3, 0x11

    if-ne v2, v3, :cond_2c

    .line 185
    const/4 v2, 0x2

    new-array v0, v2, [I

    .end local v0           #offsets:[I
    iget-object v2, p0, Landroid/graphics/YuvImage;->mStrides:[I

    aget v2, v2, v4

    mul-int/2addr v2, p2

    add-int/2addr v2, p1

    aput v2, v0, v4

    iget v2, p0, Landroid/graphics/YuvImage;->mHeight:I

    iget-object v3, p0, Landroid/graphics/YuvImage;->mStrides:[I

    aget v3, v3, v4

    mul-int/2addr v2, v3

    div-int/lit8 v3, p2, 0x2

    iget-object v4, p0, Landroid/graphics/YuvImage;->mStrides:[I

    aget v4, v4, v5

    mul-int/2addr v3, v4

    add-int/2addr v2, v3

    div-int/lit8 v3, p1, 0x2

    mul-int/lit8 v3, v3, 0x2

    add-int/2addr v2, v3

    aput v2, v0, v5

    .restart local v0       #offsets:[I
    move-object v1, v0

    .line 196
    .end local v0           #offsets:[I
    .local v1, offsets:[I
    :goto_2b
    return-object v1

    .line 191
    .end local v1           #offsets:[I
    .restart local v0       #offsets:[I
    :cond_2c
    iget v2, p0, Landroid/graphics/YuvImage;->mFormat:I

    const/16 v3, 0x14

    if-ne v2, v3, :cond_42

    .line 192
    new-array v0, v5, [I

    .end local v0           #offsets:[I
    iget-object v2, p0, Landroid/graphics/YuvImage;->mStrides:[I

    aget v2, v2, v4

    mul-int/2addr v2, p2

    div-int/lit8 v3, p1, 0x2

    mul-int/lit8 v3, v3, 0x4

    add-int/2addr v2, v3

    aput v2, v0, v4

    .restart local v0       #offsets:[I
    move-object v1, v0

    .line 193
    .end local v0           #offsets:[I
    .restart local v1       #offsets:[I
    goto :goto_2b

    .end local v1           #offsets:[I
    .restart local v0       #offsets:[I
    :cond_42
    move-object v1, v0

    .line 196
    .end local v0           #offsets:[I
    .restart local v1       #offsets:[I
    goto :goto_2b
.end method

.method public compressToJpeg(Landroid/graphics/Rect;ILjava/io/OutputStream;)Z
    .registers 14
    .parameter "rectangle"
    .parameter "quality"
    .parameter "stream"

    .prologue
    const/4 v2, 0x0

    .line 124
    new-instance v9, Landroid/graphics/Rect;

    iget v0, p0, Landroid/graphics/YuvImage;->mWidth:I

    iget v1, p0, Landroid/graphics/YuvImage;->mHeight:I

    invoke-direct {v9, v2, v2, v0, v1}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 125
    .local v9, wholeImage:Landroid/graphics/Rect;
    invoke-virtual {v9, p1}, Landroid/graphics/Rect;->contains(Landroid/graphics/Rect;)Z

    move-result v0

    if-nez v0, :cond_19

    .line 126
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "rectangle is not inside the image"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 130
    :cond_19
    if-ltz p2, :cond_1f

    const/16 v0, 0x64

    if-le p2, v0, :cond_28

    .line 131
    :cond_1f
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "quality must be 0..100"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 134
    :cond_28
    if-nez p3, :cond_33

    .line 135
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "stream cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 138
    :cond_33
    invoke-direct {p0, p1}, Landroid/graphics/YuvImage;->adjustRectangle(Landroid/graphics/Rect;)V

    .line 139
    iget v0, p1, Landroid/graphics/Rect;->left:I

    iget v1, p1, Landroid/graphics/Rect;->top:I

    invoke-virtual {p0, v0, v1}, Landroid/graphics/YuvImage;->calculateOffsets(II)[I

    move-result-object v4

    .line 141
    .local v4, offsets:[I
    iget-object v0, p0, Landroid/graphics/YuvImage;->mData:[B

    iget v1, p0, Landroid/graphics/YuvImage;->mFormat:I

    invoke-virtual {p1}, Landroid/graphics/Rect;->width()I

    move-result v2

    invoke-virtual {p1}, Landroid/graphics/Rect;->height()I

    move-result v3

    iget-object v5, p0, Landroid/graphics/YuvImage;->mStrides:[I

    const/16 v6, 0x1000

    new-array v8, v6, [B

    move v6, p2

    move-object v7, p3

    invoke-static/range {v0 .. v8}, Landroid/graphics/YuvImage;->nativeCompressToJpeg([BIII[I[IILjava/io/OutputStream;[B)Z

    move-result v0

    return v0
.end method

.method public getHeight()I
    .registers 2

    .prologue
    .line 179
    iget v0, p0, Landroid/graphics/YuvImage;->mHeight:I

    return v0
.end method

.method public getStrides()[I
    .registers 2

    .prologue
    .line 165
    iget-object v0, p0, Landroid/graphics/YuvImage;->mStrides:[I

    return-object v0
.end method

.method public getWidth()I
    .registers 2

    .prologue
    .line 172
    iget v0, p0, Landroid/graphics/YuvImage;->mWidth:I

    return v0
.end method

.method public getYuvData()[B
    .registers 2

    .prologue
    .line 151
    iget-object v0, p0, Landroid/graphics/YuvImage;->mData:[B

    return-object v0
.end method

.method public getYuvFormat()I
    .registers 2

    .prologue
    .line 158
    iget v0, p0, Landroid/graphics/YuvImage;->mFormat:I

    return v0
.end method
