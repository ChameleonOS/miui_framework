.class public Landroid/graphics/ComposeShader;
.super Landroid/graphics/Shader;
.source "ComposeShader.java"


# instance fields
.field private final mShaderA:Landroid/graphics/Shader;

.field private final mShaderB:Landroid/graphics/Shader;


# direct methods
.method public constructor <init>(Landroid/graphics/Shader;Landroid/graphics/Shader;Landroid/graphics/PorterDuff$Mode;)V
    .registers 8
    .parameter "shaderA"
    .parameter "shaderB"
    .parameter "mode"

    .prologue
    .line 61
    invoke-direct {p0}, Landroid/graphics/Shader;-><init>()V

    .line 62
    iput-object p1, p0, Landroid/graphics/ComposeShader;->mShaderA:Landroid/graphics/Shader;

    .line 63
    iput-object p2, p0, Landroid/graphics/ComposeShader;->mShaderB:Landroid/graphics/Shader;

    .line 64
    iget v0, p1, Landroid/graphics/Shader;->native_instance:I

    iget v1, p2, Landroid/graphics/Shader;->native_instance:I

    iget v2, p3, Landroid/graphics/PorterDuff$Mode;->nativeInt:I

    invoke-static {v0, v1, v2}, Landroid/graphics/ComposeShader;->nativeCreate2(III)I

    move-result v0

    iput v0, p0, Landroid/graphics/Shader;->native_instance:I

    .line 66
    iget v0, p0, Landroid/graphics/Shader;->native_instance:I

    iget v1, p1, Landroid/graphics/Shader;->native_shader:I

    iget v2, p2, Landroid/graphics/Shader;->native_shader:I

    iget v3, p3, Landroid/graphics/PorterDuff$Mode;->nativeInt:I

    invoke-static {v0, v1, v2, v3}, Landroid/graphics/ComposeShader;->nativePostCreate2(IIII)I

    move-result v0

    iput v0, p0, Landroid/graphics/Shader;->native_shader:I

    .line 68
    return-void
.end method

.method public constructor <init>(Landroid/graphics/Shader;Landroid/graphics/Shader;Landroid/graphics/Xfermode;)V
    .registers 9
    .parameter "shaderA"
    .parameter "shaderB"
    .parameter "mode"

    .prologue
    const/4 v2, 0x0

    .line 39
    invoke-direct {p0}, Landroid/graphics/Shader;-><init>()V

    .line 40
    iput-object p1, p0, Landroid/graphics/ComposeShader;->mShaderA:Landroid/graphics/Shader;

    .line 41
    iput-object p2, p0, Landroid/graphics/ComposeShader;->mShaderB:Landroid/graphics/Shader;

    .line 42
    iget v3, p1, Landroid/graphics/Shader;->native_instance:I

    iget v4, p2, Landroid/graphics/Shader;->native_instance:I

    if-eqz p3, :cond_2f

    iget v1, p3, Landroid/graphics/Xfermode;->native_instance:I

    :goto_10
    invoke-static {v3, v4, v1}, Landroid/graphics/ComposeShader;->nativeCreate1(III)I

    move-result v1

    iput v1, p0, Landroid/graphics/Shader;->native_instance:I

    .line 44
    instance-of v1, p3, Landroid/graphics/PorterDuffXfermode;

    if-eqz v1, :cond_31

    .line 45
    check-cast p3, Landroid/graphics/PorterDuffXfermode;

    .end local p3
    iget-object v0, p3, Landroid/graphics/PorterDuffXfermode;->mode:Landroid/graphics/PorterDuff$Mode;

    .line 46
    .local v0, pdMode:Landroid/graphics/PorterDuff$Mode;
    iget v1, p0, Landroid/graphics/Shader;->native_instance:I

    iget v3, p1, Landroid/graphics/Shader;->native_shader:I

    iget v4, p2, Landroid/graphics/Shader;->native_shader:I

    if-eqz v0, :cond_28

    iget v2, v0, Landroid/graphics/PorterDuff$Mode;->nativeInt:I

    :cond_28
    invoke-static {v1, v3, v4, v2}, Landroid/graphics/ComposeShader;->nativePostCreate2(IIII)I

    move-result v1

    iput v1, p0, Landroid/graphics/Shader;->native_shader:I

    .line 52
    .end local v0           #pdMode:Landroid/graphics/PorterDuff$Mode;
    :goto_2e
    return-void

    .restart local p3
    :cond_2f
    move v1, v2

    .line 42
    goto :goto_10

    .line 49
    :cond_31
    iget v1, p0, Landroid/graphics/Shader;->native_instance:I

    iget v3, p1, Landroid/graphics/Shader;->native_shader:I

    iget v4, p2, Landroid/graphics/Shader;->native_shader:I

    if-eqz p3, :cond_3b

    iget v2, p3, Landroid/graphics/Xfermode;->native_instance:I

    :cond_3b
    invoke-static {v1, v3, v4, v2}, Landroid/graphics/ComposeShader;->nativePostCreate1(IIII)I

    move-result v1

    iput v1, p0, Landroid/graphics/Shader;->native_shader:I

    goto :goto_2e
.end method

.method private static native nativeCreate1(III)I
.end method

.method private static native nativeCreate2(III)I
.end method

.method private static native nativePostCreate1(IIII)I
.end method

.method private static native nativePostCreate2(IIII)I
.end method
