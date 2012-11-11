.class public abstract Landroid/opengl/ManagedEGLContext;
.super Ljava/lang/Object;
.source "ManagedEGLContext.java"


# static fields
.field static final TAG:Ljava/lang/String; = "ManagedEGLContext"

.field static final sActive:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/opengl/ManagedEGLContext;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field final mContext:Ljavax/microedition/khronos/egl/EGLContext;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Landroid/opengl/ManagedEGLContext;->sActive:Ljava/util/ArrayList;

    return-void
.end method

.method public constructor <init>(Ljavax/microedition/khronos/egl/EGLContext;)V
    .registers 4
    .parameter "context"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroid/opengl/ManagedEGLContext;->mContext:Ljavax/microedition/khronos/egl/EGLContext;

    sget-object v1, Landroid/opengl/ManagedEGLContext;->sActive:Ljava/util/ArrayList;

    monitor-enter v1

    :try_start_8
    sget-object v0, Landroid/opengl/ManagedEGLContext;->sActive:Ljava/util/ArrayList;

    invoke-virtual {v0, p0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    monitor-exit v1

    return-void

    :catchall_f
    move-exception v0

    monitor-exit v1
    :try_end_11
    .catchall {:try_start_8 .. :try_end_11} :catchall_f

    throw v0
.end method

.method public static doTerminate()Z
    .registers 9

    .prologue
    const/4 v4, 0x0

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v5

    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v6

    if-eq v5, v6, :cond_13

    new-instance v4, Ljava/lang/IllegalStateException;

    const-string v5, "Called on wrong thread"

    invoke-direct {v4, v5}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v4

    :cond_13
    sget-object v5, Landroid/opengl/ManagedEGLContext;->sActive:Ljava/util/ArrayList;

    monitor-enter v5

    :try_start_16
    sget-object v6, Landroid/opengl/ManagedEGLContext;->sActive:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v6

    if-gtz v6, :cond_20

    monitor-exit v5

    .local v1, display:Ljavax/microedition/khronos/egl/EGLDisplay;
    .local v2, egl:Ljavax/microedition/khronos/egl/EGL10;
    :goto_1f
    return v4

    .end local v1           #display:Ljavax/microedition/khronos/egl/EGLDisplay;
    .end local v2           #egl:Ljavax/microedition/khronos/egl/EGL10;
    :cond_20
    invoke-static {}, Ljavax/microedition/khronos/egl/EGLContext;->getEGL()Ljavax/microedition/khronos/egl/EGL;

    move-result-object v2

    check-cast v2, Ljavax/microedition/khronos/egl/EGL10;

    .restart local v2       #egl:Ljavax/microedition/khronos/egl/EGL10;
    sget-object v6, Ljavax/microedition/khronos/egl/EGL10;->EGL_DEFAULT_DISPLAY:Ljava/lang/Object;

    invoke-interface {v2, v6}, Ljavax/microedition/khronos/egl/EGL10;->eglGetDisplay(Ljava/lang/Object;)Ljavax/microedition/khronos/egl/EGLDisplay;

    move-result-object v1

    .restart local v1       #display:Ljavax/microedition/khronos/egl/EGLDisplay;
    sget-object v6, Ljavax/microedition/khronos/egl/EGL10;->EGL_NO_DISPLAY:Ljavax/microedition/khronos/egl/EGLDisplay;

    if-ne v1, v6, :cond_3c

    const-string v6, "ManagedEGLContext"

    const-string v7, "doTerminate failed: no display"

    invoke-static {v6, v7}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    monitor-exit v5

    goto :goto_1f

    .end local v1           #display:Ljavax/microedition/khronos/egl/EGLDisplay;
    :catchall_39
    move-exception v4

    monitor-exit v5
    :try_end_3b
    .catchall {:try_start_16 .. :try_end_3b} :catchall_39

    throw v4

    .restart local v1       #display:Ljavax/microedition/khronos/egl/EGLDisplay;
    :cond_3c
    :try_start_3c
    invoke-static {v1}, Lcom/google/android/gles_jni/EGLImpl;->getInitCount(Ljavax/microedition/khronos/egl/EGLDisplay;)I

    move-result v6

    sget-object v7, Landroid/opengl/ManagedEGLContext;->sActive:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v7

    if-eq v6, v7, :cond_76

    const-string v6, "ManagedEGLContext"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "doTerminate failed: EGL count is "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-static {v1}, Lcom/google/android/gles_jni/EGLImpl;->getInitCount(Ljavax/microedition/khronos/egl/EGLDisplay;)I

    move-result v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " but managed count is "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    sget-object v8, Landroid/opengl/ManagedEGLContext;->sActive:Ljava/util/ArrayList;

    invoke-virtual {v8}, Ljava/util/ArrayList;->size()I

    move-result v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    monitor-exit v5

    goto :goto_1f

    :cond_76
    new-instance v0, Ljava/util/ArrayList;

    sget-object v4, Landroid/opengl/ManagedEGLContext;->sActive:Ljava/util/ArrayList;

    invoke-direct {v0, v4}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .local v0, active:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/opengl/ManagedEGLContext;>;"
    sget-object v4, Landroid/opengl/ManagedEGLContext;->sActive:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->clear()V

    monitor-exit v5
    :try_end_83
    .catchall {:try_start_3c .. :try_end_83} :catchall_39

    const/4 v3, 0x0

    .local v3, i:I
    :goto_84
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-ge v3, v4, :cond_96

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/opengl/ManagedEGLContext;

    invoke-virtual {v4}, Landroid/opengl/ManagedEGLContext;->execTerminate()V

    add-int/lit8 v3, v3, 0x1

    goto :goto_84

    :cond_96
    const/4 v4, 0x1

    goto :goto_1f
.end method


# virtual methods
.method execTerminate()V
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/opengl/ManagedEGLContext;->mContext:Ljavax/microedition/khronos/egl/EGLContext;

    invoke-virtual {p0, v0}, Landroid/opengl/ManagedEGLContext;->onTerminate(Ljavax/microedition/khronos/egl/EGLContext;)V

    return-void
.end method

.method public getContext()Ljavax/microedition/khronos/egl/EGLContext;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/opengl/ManagedEGLContext;->mContext:Ljavax/microedition/khronos/egl/EGLContext;

    return-object v0
.end method

.method public abstract onTerminate(Ljavax/microedition/khronos/egl/EGLContext;)V
.end method

.method public terminate()V
    .registers 1

    .prologue
    invoke-virtual {p0}, Landroid/opengl/ManagedEGLContext;->execTerminate()V

    return-void
.end method
