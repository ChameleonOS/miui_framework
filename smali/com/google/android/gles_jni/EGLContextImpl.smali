.class public Lcom/google/android/gles_jni/EGLContextImpl;
.super Ljavax/microedition/khronos/egl/EGLContext;
.source "EGLContextImpl.java"


# instance fields
.field mEGLContext:I

.field private mGLContext:Lcom/google/android/gles_jni/GLImpl;


# direct methods
.method public constructor <init>(I)V
    .registers 3
    .parameter "ctx"

    .prologue
    .line 26
    invoke-direct {p0}, Ljavax/microedition/khronos/egl/EGLContext;-><init>()V

    .line 27
    iput p1, p0, Lcom/google/android/gles_jni/EGLContextImpl;->mEGLContext:I

    .line 28
    new-instance v0, Lcom/google/android/gles_jni/GLImpl;

    invoke-direct {v0}, Lcom/google/android/gles_jni/GLImpl;-><init>()V

    iput-object v0, p0, Lcom/google/android/gles_jni/EGLContextImpl;->mGLContext:Lcom/google/android/gles_jni/GLImpl;

    .line 29
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 7
    .parameter "o"

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 38
    if-ne p0, p1, :cond_5

    .line 43
    :cond_4
    :goto_4
    return v1

    .line 39
    :cond_5
    if-eqz p1, :cond_11

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_13

    :cond_11
    move v1, v2

    goto :goto_4

    :cond_13
    move-object v0, p1

    .line 41
    check-cast v0, Lcom/google/android/gles_jni/EGLContextImpl;

    .line 43
    .local v0, that:Lcom/google/android/gles_jni/EGLContextImpl;
    iget v3, p0, Lcom/google/android/gles_jni/EGLContextImpl;->mEGLContext:I

    iget v4, v0, Lcom/google/android/gles_jni/EGLContextImpl;->mEGLContext:I

    if-eq v3, v4, :cond_4

    move v1, v2

    goto :goto_4
.end method

.method public getGL()Ljavax/microedition/khronos/opengles/GL;
    .registers 2

    .prologue
    .line 33
    iget-object v0, p0, Lcom/google/android/gles_jni/EGLContextImpl;->mGLContext:Lcom/google/android/gles_jni/GLImpl;

    return-object v0
.end method

.method public hashCode()I
    .registers 2

    .prologue
    .line 48
    iget v0, p0, Lcom/google/android/gles_jni/EGLContextImpl;->mEGLContext:I

    return v0
.end method
