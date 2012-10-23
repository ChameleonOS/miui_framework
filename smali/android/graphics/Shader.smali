.class public Landroid/graphics/Shader;
.super Ljava/lang/Object;
.source "Shader.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/graphics/Shader$TileMode;
    }
.end annotation


# instance fields
.field private mLocalMatrix:Landroid/graphics/Matrix;

.field public native_instance:I

.field public native_shader:I


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 25
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 39
    return-void
.end method

.method private static native nativeDestructor(II)V
.end method

.method private static native nativeSetLocalMatrix(III)V
.end method


# virtual methods
.method protected finalize()V
    .registers 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 87
    :try_start_0
    invoke-super {p0}, Ljava/lang/Object;->finalize()V
    :try_end_3
    .catchall {:try_start_0 .. :try_end_3} :catchall_b

    .line 89
    iget v0, p0, Landroid/graphics/Shader;->native_instance:I

    iget v1, p0, Landroid/graphics/Shader;->native_shader:I

    invoke-static {v0, v1}, Landroid/graphics/Shader;->nativeDestructor(II)V

    .line 91
    return-void

    .line 89
    :catchall_b
    move-exception v0

    iget v1, p0, Landroid/graphics/Shader;->native_instance:I

    iget v2, p0, Landroid/graphics/Shader;->native_shader:I

    invoke-static {v1, v2}, Landroid/graphics/Shader;->nativeDestructor(II)V

    throw v0
.end method

.method public getLocalMatrix(Landroid/graphics/Matrix;)Z
    .registers 4
    .parameter "localM"

    .prologue
    const/4 v0, 0x0

    .line 67
    iget-object v1, p0, Landroid/graphics/Shader;->mLocalMatrix:Landroid/graphics/Matrix;

    if-eqz v1, :cond_13

    .line 68
    iget-object v1, p0, Landroid/graphics/Shader;->mLocalMatrix:Landroid/graphics/Matrix;

    invoke-virtual {p1, v1}, Landroid/graphics/Matrix;->set(Landroid/graphics/Matrix;)V

    .line 69
    iget-object v1, p0, Landroid/graphics/Shader;->mLocalMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v1}, Landroid/graphics/Matrix;->isIdentity()Z

    move-result v1

    if-nez v1, :cond_13

    const/4 v0, 0x1

    .line 71
    :cond_13
    return v0
.end method

.method public setLocalMatrix(Landroid/graphics/Matrix;)V
    .registers 5
    .parameter "localM"

    .prologue
    .line 80
    iput-object p1, p0, Landroid/graphics/Shader;->mLocalMatrix:Landroid/graphics/Matrix;

    .line 81
    iget v1, p0, Landroid/graphics/Shader;->native_instance:I

    iget v2, p0, Landroid/graphics/Shader;->native_shader:I

    if-nez p1, :cond_d

    const/4 v0, 0x0

    :goto_9
    invoke-static {v1, v2, v0}, Landroid/graphics/Shader;->nativeSetLocalMatrix(III)V

    .line 83
    return-void

    .line 81
    :cond_d
    iget v0, p1, Landroid/graphics/Matrix;->native_instance:I

    goto :goto_9
.end method
