.class public Lcom/google/android/gles_jni/EGLConfigImpl;
.super Ljavax/microedition/khronos/egl/EGLConfig;
.source "EGLConfigImpl.java"


# instance fields
.field private mEGLConfig:I


# direct methods
.method constructor <init>(I)V
    .registers 2
    .parameter "config"

    .prologue
    .line 24
    invoke-direct {p0}, Ljavax/microedition/khronos/egl/EGLConfig;-><init>()V

    .line 25
    iput p1, p0, Lcom/google/android/gles_jni/EGLConfigImpl;->mEGLConfig:I

    .line 26
    return-void
.end method


# virtual methods
.method get()I
    .registers 2

    .prologue
    .line 29
    iget v0, p0, Lcom/google/android/gles_jni/EGLConfigImpl;->mEGLConfig:I

    return v0
.end method
