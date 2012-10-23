.class public final Landroid/opengl/GLUtils;
.super Ljava/lang/Object;
.source "GLUtils.java"


# direct methods
.method static constructor <clinit>()V
    .registers 0

    .prologue
    .line 37
    invoke-static {}, Landroid/opengl/GLUtils;->nativeClassInit()V

    .line 38
    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .prologue
    .line 40
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 41
    return-void
.end method

.method public static enableTracing()V
    .registers 0

    .prologue
    .line 277
    invoke-static {}, Landroid/opengl/GLUtils;->native_enableTracing()V

    .line 278
    return-void
.end method

.method public static getEGLErrorString(I)Ljava/lang/String;
    .registers 3
    .parameter "error"

    .prologue
    .line 236
    packed-switch p0, :pswitch_data_48

    .line 268
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "0x"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {p0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_1a
    return-object v0

    .line 238
    :pswitch_1b
    const-string v0, "EGL_SUCCESS"

    goto :goto_1a

    .line 240
    :pswitch_1e
    const-string v0, "EGL_NOT_INITIALIZED"

    goto :goto_1a

    .line 242
    :pswitch_21
    const-string v0, "EGL_BAD_ACCESS"

    goto :goto_1a

    .line 244
    :pswitch_24
    const-string v0, "EGL_BAD_ALLOC"

    goto :goto_1a

    .line 246
    :pswitch_27
    const-string v0, "EGL_BAD_ATTRIBUTE"

    goto :goto_1a

    .line 248
    :pswitch_2a
    const-string v0, "EGL_BAD_CONFIG"

    goto :goto_1a

    .line 250
    :pswitch_2d
    const-string v0, "EGL_BAD_CONTEXT"

    goto :goto_1a

    .line 252
    :pswitch_30
    const-string v0, "EGL_BAD_CURRENT_SURFACE"

    goto :goto_1a

    .line 254
    :pswitch_33
    const-string v0, "EGL_BAD_DISPLAY"

    goto :goto_1a

    .line 256
    :pswitch_36
    const-string v0, "EGL_BAD_MATCH"

    goto :goto_1a

    .line 258
    :pswitch_39
    const-string v0, "EGL_BAD_NATIVE_PIXMAP"

    goto :goto_1a

    .line 260
    :pswitch_3c
    const-string v0, "EGL_BAD_NATIVE_WINDOW"

    goto :goto_1a

    .line 262
    :pswitch_3f
    const-string v0, "EGL_BAD_PARAMETER"

    goto :goto_1a

    .line 264
    :pswitch_42
    const-string v0, "EGL_BAD_SURFACE"

    goto :goto_1a

    .line 266
    :pswitch_45
    const-string v0, "EGL_CONTEXT_LOST"

    goto :goto_1a

    .line 236
    :pswitch_data_48
    .packed-switch 0x3000
        :pswitch_1b
        :pswitch_1e
        :pswitch_21
        :pswitch_24
        :pswitch_27
        :pswitch_2a
        :pswitch_2d
        :pswitch_30
        :pswitch_33
        :pswitch_36
        :pswitch_39
        :pswitch_3c
        :pswitch_3f
        :pswitch_42
        :pswitch_45
    .end packed-switch
.end method

.method public static getInternalFormat(Landroid/graphics/Bitmap;)I
    .registers 4
    .parameter "bitmap"

    .prologue
    .line 49
    if-nez p0, :cond_a

    .line 50
    new-instance v1, Ljava/lang/NullPointerException;

    const-string v2, "getInternalFormat can\'t be used with a null Bitmap"

    invoke-direct {v1, v2}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 52
    :cond_a
    invoke-virtual {p0}, Landroid/graphics/Bitmap;->isRecycled()Z

    move-result v1

    if-eqz v1, :cond_18

    .line 53
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "bitmap is recycled"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 55
    :cond_18
    invoke-static {p0}, Landroid/opengl/GLUtils;->native_getInternalFormat(Landroid/graphics/Bitmap;)I

    move-result v0

    .line 56
    .local v0, result:I
    if-gez v0, :cond_26

    .line 57
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Unknown internalformat"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 59
    :cond_26
    return v0
.end method

.method public static getType(Landroid/graphics/Bitmap;)I
    .registers 4
    .parameter "bitmap"

    .prologue
    .line 71
    if-nez p0, :cond_a

    .line 72
    new-instance v1, Ljava/lang/NullPointerException;

    const-string v2, "getType can\'t be used with a null Bitmap"

    invoke-direct {v1, v2}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 74
    :cond_a
    invoke-virtual {p0}, Landroid/graphics/Bitmap;->isRecycled()Z

    move-result v1

    if-eqz v1, :cond_18

    .line 75
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "bitmap is recycled"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 77
    :cond_18
    invoke-static {p0}, Landroid/opengl/GLUtils;->native_getType(Landroid/graphics/Bitmap;)I

    move-result v0

    .line 78
    .local v0, result:I
    if-gez v0, :cond_26

    .line 79
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Unknown type"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 81
    :cond_26
    return v0
.end method

.method private static native nativeClassInit()V
.end method

.method private static native native_enableTracing()V
.end method

.method private static native native_getInternalFormat(Landroid/graphics/Bitmap;)I
.end method

.method private static native native_getType(Landroid/graphics/Bitmap;)I
.end method

.method private static native native_texImage2D(IIILandroid/graphics/Bitmap;II)I
.end method

.method private static native native_texSubImage2D(IIIILandroid/graphics/Bitmap;II)I
.end method

.method public static texImage2D(IIILandroid/graphics/Bitmap;I)V
    .registers 11
    .parameter "target"
    .parameter "level"
    .parameter "internalformat"
    .parameter "bitmap"
    .parameter "border"

    .prologue
    .line 108
    if-nez p3, :cond_b

    .line 109
    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "texImage2D can\'t be used with a null Bitmap"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 111
    :cond_b
    invoke-virtual {p3}, Landroid/graphics/Bitmap;->isRecycled()Z

    move-result v0

    if-eqz v0, :cond_19

    .line 112
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "bitmap is recycled"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 114
    :cond_19
    const/4 v4, -0x1

    move v0, p0

    move v1, p1

    move v2, p2

    move-object v3, p3

    move v5, p4

    invoke-static/range {v0 .. v5}, Landroid/opengl/GLUtils;->native_texImage2D(IIILandroid/graphics/Bitmap;II)I

    move-result v0

    if-eqz v0, :cond_2d

    .line 115
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "invalid Bitmap format"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 117
    :cond_2d
    return-void
.end method

.method public static texImage2D(IIILandroid/graphics/Bitmap;II)V
    .registers 8
    .parameter "target"
    .parameter "level"
    .parameter "internalformat"
    .parameter "bitmap"
    .parameter "type"
    .parameter "border"

    .prologue
    .line 134
    if-nez p3, :cond_b

    .line 135
    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "texImage2D can\'t be used with a null Bitmap"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 137
    :cond_b
    invoke-virtual {p3}, Landroid/graphics/Bitmap;->isRecycled()Z

    move-result v0

    if-eqz v0, :cond_19

    .line 138
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "bitmap is recycled"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 140
    :cond_19
    invoke-static/range {p0 .. p5}, Landroid/opengl/GLUtils;->native_texImage2D(IIILandroid/graphics/Bitmap;II)I

    move-result v0

    if-eqz v0, :cond_27

    .line 141
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "invalid Bitmap format"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 143
    :cond_27
    return-void
.end method

.method public static texImage2D(IILandroid/graphics/Bitmap;I)V
    .registers 10
    .parameter "target"
    .parameter "level"
    .parameter "bitmap"
    .parameter "border"

    .prologue
    const/4 v2, -0x1

    .line 156
    if-nez p2, :cond_c

    .line 157
    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "texImage2D can\'t be used with a null Bitmap"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 159
    :cond_c
    invoke-virtual {p2}, Landroid/graphics/Bitmap;->isRecycled()Z

    move-result v0

    if-eqz v0, :cond_1a

    .line 160
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "bitmap is recycled"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1a
    move v0, p0

    move v1, p1

    move-object v3, p2

    move v4, v2

    move v5, p3

    .line 162
    invoke-static/range {v0 .. v5}, Landroid/opengl/GLUtils;->native_texImage2D(IIILandroid/graphics/Bitmap;II)I

    move-result v0

    if-eqz v0, :cond_2d

    .line 163
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "invalid Bitmap format"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 165
    :cond_2d
    return-void
.end method

.method public static texSubImage2D(IIIILandroid/graphics/Bitmap;)V
    .registers 12
    .parameter "target"
    .parameter "level"
    .parameter "xoffset"
    .parameter "yoffset"
    .parameter "bitmap"

    .prologue
    .line 191
    if-nez p4, :cond_b

    .line 192
    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "texSubImage2D can\'t be used with a null Bitmap"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 194
    :cond_b
    invoke-virtual {p4}, Landroid/graphics/Bitmap;->isRecycled()Z

    move-result v0

    if-eqz v0, :cond_19

    .line 195
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "bitmap is recycled"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 197
    :cond_19
    invoke-static {p4}, Landroid/opengl/GLUtils;->getType(Landroid/graphics/Bitmap;)I

    move-result v6

    .line 198
    .local v6, type:I
    const/4 v5, -0x1

    move v0, p0

    move v1, p1

    move v2, p2

    move v3, p3

    move-object v4, p4

    invoke-static/range {v0 .. v6}, Landroid/opengl/GLUtils;->native_texSubImage2D(IIIILandroid/graphics/Bitmap;II)I

    move-result v0

    if-eqz v0, :cond_31

    .line 199
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "invalid Bitmap format"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 201
    :cond_31
    return-void
.end method

.method public static texSubImage2D(IIIILandroid/graphics/Bitmap;II)V
    .registers 9
    .parameter "target"
    .parameter "level"
    .parameter "xoffset"
    .parameter "yoffset"
    .parameter "bitmap"
    .parameter "format"
    .parameter "type"

    .prologue
    .line 216
    if-nez p4, :cond_b

    .line 217
    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "texSubImage2D can\'t be used with a null Bitmap"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 219
    :cond_b
    invoke-virtual {p4}, Landroid/graphics/Bitmap;->isRecycled()Z

    move-result v0

    if-eqz v0, :cond_19

    .line 220
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "bitmap is recycled"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 222
    :cond_19
    invoke-static/range {p0 .. p6}, Landroid/opengl/GLUtils;->native_texSubImage2D(IIIILandroid/graphics/Bitmap;II)I

    move-result v0

    if-eqz v0, :cond_27

    .line 223
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "invalid Bitmap format"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 225
    :cond_27
    return-void
.end method
