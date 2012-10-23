.class public Landroid/graphics/Camera;
.super Ljava/lang/Object;
.source "Camera.java"


# instance fields
.field native_instance:I


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 28
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 29
    invoke-direct {p0}, Landroid/graphics/Camera;->nativeConstructor()V

    .line 30
    return-void
.end method

.method private native nativeApplyToCanvas(I)V
.end method

.method private native nativeConstructor()V
.end method

.method private native nativeDestructor()V
.end method

.method private native nativeGetMatrix(I)V
.end method


# virtual methods
.method public applyToCanvas(Landroid/graphics/Canvas;)V
    .registers 3
    .parameter "canvas"

    .prologue
    .line 150
    iget v0, p1, Landroid/graphics/Canvas;->mNativeCanvas:I

    invoke-direct {p0, v0}, Landroid/graphics/Camera;->nativeApplyToCanvas(I)V

    .line 151
    return-void
.end method

.method public native dotWithNormal(FFF)F
.end method

.method protected finalize()V
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 157
    :try_start_0
    invoke-direct {p0}, Landroid/graphics/Camera;->nativeDestructor()V
    :try_end_3
    .catchall {:try_start_0 .. :try_end_3} :catchall_7

    .line 159
    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    .line 161
    return-void

    .line 159
    :catchall_7
    move-exception v0

    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    throw v0
.end method

.method public native getLocationX()F
.end method

.method public native getLocationY()F
.end method

.method public native getLocationZ()F
.end method

.method public getMatrix(Landroid/graphics/Matrix;)V
    .registers 3
    .parameter "matrix"

    .prologue
    .line 140
    iget v0, p1, Landroid/graphics/Matrix;->native_instance:I

    invoke-direct {p0, v0}, Landroid/graphics/Camera;->nativeGetMatrix(I)V

    .line 141
    return-void
.end method

.method public native restore()V
.end method

.method public native rotate(FFF)V
.end method

.method public native rotateX(F)V
.end method

.method public native rotateY(F)V
.end method

.method public native rotateZ(F)V
.end method

.method public native save()V
.end method

.method public native setLocation(FFF)V
.end method

.method public native translate(FFF)V
.end method
