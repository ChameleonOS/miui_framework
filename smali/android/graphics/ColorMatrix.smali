.class public Landroid/graphics/ColorMatrix;
.super Ljava/lang/Object;
.source "ColorMatrix.java"


# instance fields
.field private final mArray:[F


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 44
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 38
    const/16 v0, 0x14

    new-array v0, v0, [F

    iput-object v0, p0, Landroid/graphics/ColorMatrix;->mArray:[F

    .line 45
    invoke-virtual {p0}, Landroid/graphics/ColorMatrix;->reset()V

    .line 46
    return-void
.end method

.method public constructor <init>(Landroid/graphics/ColorMatrix;)V
    .registers 6
    .parameter "src"

    .prologue
    const/16 v3, 0x14

    const/4 v2, 0x0

    .line 58
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 38
    new-array v0, v3, [F

    iput-object v0, p0, Landroid/graphics/ColorMatrix;->mArray:[F

    .line 59
    iget-object v0, p1, Landroid/graphics/ColorMatrix;->mArray:[F

    iget-object v1, p0, Landroid/graphics/ColorMatrix;->mArray:[F

    invoke-static {v0, v2, v1, v2, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 60
    return-void
.end method

.method public constructor <init>([F)V
    .registers 5
    .parameter "src"

    .prologue
    const/16 v2, 0x14

    const/4 v1, 0x0

    .line 51
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 38
    new-array v0, v2, [F

    iput-object v0, p0, Landroid/graphics/ColorMatrix;->mArray:[F

    .line 52
    iget-object v0, p0, Landroid/graphics/ColorMatrix;->mArray:[F

    invoke-static {p1, v1, v0, v1, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 53
    return-void
.end method


# virtual methods
.method public final getArray()[F
    .registers 2

    .prologue
    .line 65
    iget-object v0, p0, Landroid/graphics/ColorMatrix;->mArray:[F

    return-object v0
.end method

.method public postConcat(Landroid/graphics/ColorMatrix;)V
    .registers 2
    .parameter "postmatrix"

    .prologue
    .line 195
    invoke-virtual {p0, p1, p0}, Landroid/graphics/ColorMatrix;->setConcat(Landroid/graphics/ColorMatrix;Landroid/graphics/ColorMatrix;)V

    .line 196
    return-void
.end method

.method public preConcat(Landroid/graphics/ColorMatrix;)V
    .registers 2
    .parameter "prematrix"

    .prologue
    .line 187
    invoke-virtual {p0, p0, p1}, Landroid/graphics/ColorMatrix;->setConcat(Landroid/graphics/ColorMatrix;Landroid/graphics/ColorMatrix;)V

    .line 188
    return-void
.end method

.method public reset()V
    .registers 8

    .prologue
    .line 75
    iget-object v0, p0, Landroid/graphics/ColorMatrix;->mArray:[F

    .line 77
    .local v0, a:[F
    const/16 v1, 0x13

    .local v1, i:I
    :goto_4
    if-lez v1, :cond_c

    .line 78
    const/4 v2, 0x0

    aput v2, v0, v1

    .line 77
    add-int/lit8 v1, v1, -0x1

    goto :goto_4

    .line 80
    :cond_c
    const/4 v2, 0x0

    const/4 v3, 0x6

    const/16 v4, 0xc

    const/16 v5, 0x12

    const/high16 v6, 0x3f80

    aput v6, v0, v5

    aput v6, v0, v4

    aput v6, v0, v3

    aput v6, v0, v2

    .line 81
    return-void
.end method

.method public set(Landroid/graphics/ColorMatrix;)V
    .registers 6
    .parameter "src"

    .prologue
    const/4 v3, 0x0

    .line 87
    iget-object v0, p1, Landroid/graphics/ColorMatrix;->mArray:[F

    iget-object v1, p0, Landroid/graphics/ColorMatrix;->mArray:[F

    const/16 v2, 0x14

    invoke-static {v0, v3, v1, v3, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 88
    return-void
.end method

.method public set([F)V
    .registers 5
    .parameter "src"

    .prologue
    const/4 v2, 0x0

    .line 94
    iget-object v0, p0, Landroid/graphics/ColorMatrix;->mArray:[F

    const/16 v1, 0x14

    invoke-static {p1, v2, v0, v2, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 95
    return-void
.end method

.method public setConcat(Landroid/graphics/ColorMatrix;Landroid/graphics/ColorMatrix;)V
    .registers 16
    .parameter "matA"
    .parameter "matB"

    .prologue
    const/4 v12, 0x4

    const/4 v11, 0x0

    const/16 v10, 0x14

    .line 155
    const/4 v6, 0x0

    .line 157
    .local v6, tmp:[F
    if-eq p1, p0, :cond_9

    if-ne p2, p0, :cond_46

    .line 158
    :cond_9
    new-array v6, v10, [F

    .line 164
    :goto_b
    iget-object v0, p1, Landroid/graphics/ColorMatrix;->mArray:[F

    .line 165
    .local v0, a:[F
    iget-object v1, p2, Landroid/graphics/ColorMatrix;->mArray:[F

    .line 166
    .local v1, b:[F
    const/4 v3, 0x0

    .line 167
    .local v3, index:I
    const/4 v5, 0x0

    .local v5, j:I
    :goto_11
    if-ge v5, v10, :cond_7a

    .line 168
    const/4 v2, 0x0

    .local v2, i:I
    move v4, v3

    .end local v3           #index:I
    .local v4, index:I
    :goto_15
    if-ge v2, v12, :cond_49

    .line 169
    add-int/lit8 v3, v4, 0x1

    .end local v4           #index:I
    .restart local v3       #index:I
    add-int/lit8 v7, v5, 0x0

    aget v7, v0, v7

    add-int/lit8 v8, v2, 0x0

    aget v8, v1, v8

    mul-float/2addr v7, v8

    add-int/lit8 v8, v5, 0x1

    aget v8, v0, v8

    add-int/lit8 v9, v2, 0x5

    aget v9, v1, v9

    mul-float/2addr v8, v9

    add-float/2addr v7, v8

    add-int/lit8 v8, v5, 0x2

    aget v8, v0, v8

    add-int/lit8 v9, v2, 0xa

    aget v9, v1, v9

    mul-float/2addr v8, v9

    add-float/2addr v7, v8

    add-int/lit8 v8, v5, 0x3

    aget v8, v0, v8

    add-int/lit8 v9, v2, 0xf

    aget v9, v1, v9

    mul-float/2addr v8, v9

    add-float/2addr v7, v8

    aput v7, v6, v4

    .line 168
    add-int/lit8 v2, v2, 0x1

    move v4, v3

    .end local v3           #index:I
    .restart local v4       #index:I
    goto :goto_15

    .line 161
    .end local v0           #a:[F
    .end local v1           #b:[F
    .end local v2           #i:I
    .end local v4           #index:I
    .end local v5           #j:I
    :cond_46
    iget-object v6, p0, Landroid/graphics/ColorMatrix;->mArray:[F

    goto :goto_b

    .line 172
    .restart local v0       #a:[F
    .restart local v1       #b:[F
    .restart local v2       #i:I
    .restart local v4       #index:I
    .restart local v5       #j:I
    :cond_49
    add-int/lit8 v3, v4, 0x1

    .end local v4           #index:I
    .restart local v3       #index:I
    add-int/lit8 v7, v5, 0x0

    aget v7, v0, v7

    aget v8, v1, v12

    mul-float/2addr v7, v8

    add-int/lit8 v8, v5, 0x1

    aget v8, v0, v8

    const/16 v9, 0x9

    aget v9, v1, v9

    mul-float/2addr v8, v9

    add-float/2addr v7, v8

    add-int/lit8 v8, v5, 0x2

    aget v8, v0, v8

    const/16 v9, 0xe

    aget v9, v1, v9

    mul-float/2addr v8, v9

    add-float/2addr v7, v8

    add-int/lit8 v8, v5, 0x3

    aget v8, v0, v8

    const/16 v9, 0x13

    aget v9, v1, v9

    mul-float/2addr v8, v9

    add-float/2addr v7, v8

    add-int/lit8 v8, v5, 0x4

    aget v8, v0, v8

    add-float/2addr v7, v8

    aput v7, v6, v4

    .line 167
    add-int/lit8 v5, v5, 0x5

    goto :goto_11

    .line 177
    .end local v2           #i:I
    :cond_7a
    iget-object v7, p0, Landroid/graphics/ColorMatrix;->mArray:[F

    if-eq v6, v7, :cond_83

    .line 178
    iget-object v7, p0, Landroid/graphics/ColorMatrix;->mArray:[F

    invoke-static {v6, v11, v7, v11, v10}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 180
    :cond_83
    return-void
.end method

.method public setRGB2YUV()V
    .registers 5

    .prologue
    const/high16 v3, 0x3f00

    .line 222
    invoke-virtual {p0}, Landroid/graphics/ColorMatrix;->reset()V

    .line 223
    iget-object v0, p0, Landroid/graphics/ColorMatrix;->mArray:[F

    .line 225
    .local v0, m:[F
    const/4 v1, 0x0

    const v2, 0x3e991687

    aput v2, v0, v1

    const/4 v1, 0x1

    const v2, 0x3f1645a2

    aput v2, v0, v1

    const/4 v1, 0x2

    const v2, 0x3de978d5

    aput v2, v0, v1

    .line 226
    const/4 v1, 0x5

    const v2, -0x41d335d2

    aput v2, v0, v1

    const/4 v1, 0x6

    const v2, -0x41566517

    aput v2, v0, v1

    const/4 v1, 0x7

    aput v3, v0, v1

    .line 227
    const/16 v1, 0xa

    aput v3, v0, v1

    const/16 v1, 0xb

    const v2, -0x4129a177

    aput v2, v0, v1

    const/16 v1, 0xc

    const v2, -0x42597a25

    aput v2, v0, v1

    .line 228
    return-void
.end method

.method public setRotate(IF)V
    .registers 11
    .parameter "axis"
    .parameter "degrees"

    .prologue
    const/16 v7, 0xc

    const/4 v6, 0x6

    const/4 v5, 0x0

    .line 120
    invoke-virtual {p0}, Landroid/graphics/ColorMatrix;->reset()V

    .line 121
    const v3, 0x40490fdb

    mul-float/2addr v3, p2

    const/high16 v4, 0x4334

    div-float v1, v3, v4

    .line 122
    .local v1, radians:F
    invoke-static {v1}, Landroid/util/FloatMath;->cos(F)F

    move-result v0

    .line 123
    .local v0, cosine:F
    invoke-static {v1}, Landroid/util/FloatMath;->sin(F)F

    move-result v2

    .line 124
    .local v2, sine:F
    packed-switch p1, :pswitch_data_5e

    .line 144
    new-instance v3, Ljava/lang/RuntimeException;

    invoke-direct {v3}, Ljava/lang/RuntimeException;-><init>()V

    throw v3

    .line 127
    :pswitch_20
    iget-object v3, p0, Landroid/graphics/ColorMatrix;->mArray:[F

    iget-object v4, p0, Landroid/graphics/ColorMatrix;->mArray:[F

    aput v0, v4, v7

    aput v0, v3, v6

    .line 128
    iget-object v3, p0, Landroid/graphics/ColorMatrix;->mArray:[F

    const/4 v4, 0x7

    aput v2, v3, v4

    .line 129
    iget-object v3, p0, Landroid/graphics/ColorMatrix;->mArray:[F

    const/16 v4, 0xb

    neg-float v5, v2

    aput v5, v3, v4

    .line 146
    :goto_34
    return-void

    .line 133
    :pswitch_35
    iget-object v3, p0, Landroid/graphics/ColorMatrix;->mArray:[F

    iget-object v4, p0, Landroid/graphics/ColorMatrix;->mArray:[F

    aput v0, v4, v7

    aput v0, v3, v5

    .line 134
    iget-object v3, p0, Landroid/graphics/ColorMatrix;->mArray:[F

    const/4 v4, 0x2

    neg-float v5, v2

    aput v5, v3, v4

    .line 135
    iget-object v3, p0, Landroid/graphics/ColorMatrix;->mArray:[F

    const/16 v4, 0xa

    aput v2, v3, v4

    goto :goto_34

    .line 139
    :pswitch_4a
    iget-object v3, p0, Landroid/graphics/ColorMatrix;->mArray:[F

    iget-object v4, p0, Landroid/graphics/ColorMatrix;->mArray:[F

    aput v0, v4, v6

    aput v0, v3, v5

    .line 140
    iget-object v3, p0, Landroid/graphics/ColorMatrix;->mArray:[F

    const/4 v4, 0x1

    aput v2, v3, v4

    .line 141
    iget-object v3, p0, Landroid/graphics/ColorMatrix;->mArray:[F

    const/4 v4, 0x5

    neg-float v5, v2

    aput v5, v3, v4

    goto :goto_34

    .line 124
    :pswitch_data_5e
    .packed-switch 0x0
        :pswitch_20
        :pswitch_35
        :pswitch_4a
    .end packed-switch
.end method

.method public setSaturation(F)V
    .registers 9
    .parameter "sat"

    .prologue
    .line 205
    invoke-virtual {p0}, Landroid/graphics/ColorMatrix;->reset()V

    .line 206
    iget-object v4, p0, Landroid/graphics/ColorMatrix;->mArray:[F

    .line 208
    .local v4, m:[F
    const/high16 v5, 0x3f80

    sub-float v3, v5, p1

    .line 209
    .local v3, invSat:F
    const v5, 0x3e5a1cac

    mul-float v2, v5, v3

    .line 210
    .local v2, R:F
    const v5, 0x3f370a3d

    mul-float v1, v5, v3

    .line 211
    .local v1, G:F
    const v5, 0x3d9374bc

    mul-float v0, v5, v3

    .line 213
    .local v0, B:F
    const/4 v5, 0x0

    add-float v6, v2, p1

    aput v6, v4, v5

    const/4 v5, 0x1

    aput v1, v4, v5

    const/4 v5, 0x2

    aput v0, v4, v5

    .line 214
    const/4 v5, 0x5

    aput v2, v4, v5

    const/4 v5, 0x6

    add-float v6, v1, p1

    aput v6, v4, v5

    const/4 v5, 0x7

    aput v0, v4, v5

    .line 215
    const/16 v5, 0xa

    aput v2, v4, v5

    const/16 v5, 0xb

    aput v1, v4, v5

    const/16 v5, 0xc

    add-float v6, v0, p1

    aput v6, v4, v5

    .line 216
    return-void
.end method

.method public setScale(FFFF)V
    .registers 8
    .parameter "rScale"
    .parameter "gScale"
    .parameter "bScale"
    .parameter "aScale"

    .prologue
    .line 102
    iget-object v0, p0, Landroid/graphics/ColorMatrix;->mArray:[F

    .line 104
    .local v0, a:[F
    const/16 v1, 0x13

    .local v1, i:I
    :goto_4
    if-lez v1, :cond_c

    .line 105
    const/4 v2, 0x0

    aput v2, v0, v1

    .line 104
    add-int/lit8 v1, v1, -0x1

    goto :goto_4

    .line 107
    :cond_c
    const/4 v2, 0x0

    aput p1, v0, v2

    .line 108
    const/4 v2, 0x6

    aput p2, v0, v2

    .line 109
    const/16 v2, 0xc

    aput p3, v0, v2

    .line 110
    const/16 v2, 0x12

    aput p4, v0, v2

    .line 111
    return-void
.end method

.method public setYUV2RGB()V
    .registers 5

    .prologue
    const/high16 v3, 0x3f80

    .line 234
    invoke-virtual {p0}, Landroid/graphics/ColorMatrix;->reset()V

    .line 235
    iget-object v0, p0, Landroid/graphics/ColorMatrix;->mArray:[F

    .line 237
    .local v0, m:[F
    const/4 v1, 0x2

    const v2, 0x3fb374bc

    aput v2, v0, v1

    .line 238
    const/4 v1, 0x5

    aput v3, v0, v1

    const/4 v1, 0x6

    const v2, -0x414fcce2

    aput v2, v0, v1

    const/4 v1, 0x7

    const v2, -0x40c92e1f

    aput v2, v0, v1

    .line 239
    const/16 v1, 0xa

    aput v3, v0, v1

    const/16 v1, 0xb

    const v2, 0x3fe2d0e5

    aput v2, v0, v1

    const/16 v1, 0xc

    const/4 v2, 0x0

    aput v2, v0, v1

    .line 240
    return-void
.end method
