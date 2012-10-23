.class public abstract Landroid/view/HardwareRenderer;
.super Ljava/lang/Object;
.source "HardwareRenderer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/view/HardwareRenderer$Gl20Renderer;,
        Landroid/view/HardwareRenderer$GlRenderer;,
        Landroid/view/HardwareRenderer$HardwareDrawCallbacks;
    }
.end annotation


# static fields
.field private static final CACHE_PATH_SHADERS:Ljava/lang/String; = "com.android.opengl.shaders_cache"

.field public static final DEBUG_DIRTY_REGIONS_PROPERTY:Ljava/lang/String; = "debug.hwui.show_dirty_regions"

.field static final DISABLE_VSYNC_PROPERTY:Ljava/lang/String; = "debug.hwui.disable_vsync"

.field static final LOG_TAG:Ljava/lang/String; = "HardwareRenderer"

.field static final PRINT_CONFIG_PROPERTY:Ljava/lang/String; = "debug.hwui.print_config"

.field private static final PROFILE_FRAME_DATA_COUNT:I = 0x3

.field static final PROFILE_MAXFRAMES_PROPERTY:Ljava/lang/String; = "debug.hwui.profile.maxframes"

.field private static final PROFILE_MAX_FRAMES:I = 0x80

.field public static final PROFILE_PROPERTY:Ljava/lang/String; = "debug.hwui.profile"

.field public static final RENDER_DIRTY_REGIONS:Z = true

.field static final RENDER_DIRTY_REGIONS_PROPERTY:Ljava/lang/String; = "debug.hwui.render_dirty_regions"

.field public static sRendererDisabled:Z

.field public static sSystemRendererDisabled:Z


# instance fields
.field private mEnabled:Z

.field private mRequested:Z


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    const/4 v0, 0x0

    .line 145
    sput-boolean v0, Landroid/view/HardwareRenderer;->sRendererDisabled:Z

    .line 152
    sput-boolean v0, Landroid/view/HardwareRenderer;->sSystemRendererDisabled:Z

    return-void
.end method

.method public constructor <init>()V
    .registers 2

    .prologue
    .line 53
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 165
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/view/HardwareRenderer;->mRequested:Z

    .line 1311
    return-void
.end method

.method static synthetic access$200([I)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 53
    invoke-static {p0}, Landroid/view/HardwareRenderer;->beginFrame([I)V

    return-void
.end method

.method private static beginFrame([I)V
    .registers 1
    .parameter "size"

    .prologue
    .line 318
    invoke-static {p0}, Landroid/view/HardwareRenderer;->nBeginFrame([I)V

    .line 319
    return-void
.end method

.method static createGlRenderer(IZ)Landroid/view/HardwareRenderer;
    .registers 5
    .parameter "glVersion"
    .parameter "translucent"

    .prologue
    .line 500
    packed-switch p0, :pswitch_data_22

    .line 504
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unknown GL version: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 502
    :pswitch_1c
    invoke-static {p1}, Landroid/view/HardwareRenderer$Gl20Renderer;->create(Z)Landroid/view/HardwareRenderer;

    move-result-object v0

    return-object v0

    .line 500
    nop

    :pswitch_data_22
    .packed-switch 0x2
        :pswitch_1c
    .end packed-switch
.end method

.method public static disable(Z)V
    .registers 2
    .parameter "system"

    .prologue
    const/4 v0, 0x1

    .line 173
    sput-boolean v0, Landroid/view/HardwareRenderer;->sRendererDisabled:Z

    .line 174
    if-eqz p0, :cond_7

    .line 175
    sput-boolean v0, Landroid/view/HardwareRenderer;->sSystemRendererDisabled:Z

    .line 177
    :cond_7
    return-void
.end method

.method static disableVsync()V
    .registers 0

    .prologue
    .line 355
    invoke-static {}, Landroid/view/HardwareRenderer;->nDisableVsync()V

    .line 356
    return-void
.end method

.method static endTrimMemory()V
    .registers 0

    .prologue
    .line 537
    invoke-static {}, Landroid/view/HardwareRenderer$Gl20Renderer;->endTrimMemory()V

    .line 538
    return-void
.end method

.method public static isAvailable()Z
    .registers 1

    .prologue
    .line 187
    invoke-static {}, Landroid/view/GLES20Canvas;->isAvailable()Z

    move-result v0

    return v0
.end method

.method static isBackBufferPreserved()Z
    .registers 1

    .prologue
    .line 346
    invoke-static {}, Landroid/view/HardwareRenderer;->nIsBackBufferPreserved()Z

    move-result v0

    return v0
.end method

.method private static native nBeginFrame([I)V
.end method

.method private static native nDisableVsync()V
.end method

.method private static native nIsBackBufferPreserved()Z
.end method

.method private static native nPreserveBackBuffer()Z
.end method

.method private static native nSetupShadersDiskCache(Ljava/lang/String;)V
.end method

.method static preserveBackBuffer()Z
    .registers 1

    .prologue
    .line 333
    invoke-static {}, Landroid/view/HardwareRenderer;->nPreserveBackBuffer()Z

    move-result v0

    return v0
.end method

.method public static setupDiskCache(Ljava/io/File;)V
    .registers 3
    .parameter "cacheDir"

    .prologue
    .line 308
    new-instance v0, Ljava/io/File;

    const-string v1, "com.android.opengl.shaders_cache"

    invoke-direct {v0, p0, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/view/HardwareRenderer;->nSetupShadersDiskCache(Ljava/lang/String;)V

    .line 309
    return-void
.end method

.method static startTrimMemory(I)V
    .registers 1
    .parameter "level"

    .prologue
    .line 529
    invoke-static {p0}, Landroid/view/HardwareRenderer$Gl20Renderer;->startTrimMemory(I)V

    .line 530
    return-void
.end method

.method static trimMemory(I)V
    .registers 1
    .parameter "level"

    .prologue
    .line 516
    invoke-static {p0}, Landroid/view/HardwareRenderer;->startTrimMemory(I)V

    .line 517
    invoke-static {}, Landroid/view/HardwareRenderer;->endTrimMemory()V

    .line 518
    return-void
.end method


# virtual methods
.method abstract attachFunctor(Landroid/view/View$AttachInfo;I)Z
.end method

.method public abstract createDisplayList(Ljava/lang/String;)Landroid/view/DisplayList;
.end method

.method abstract createHardwareLayer(IIZ)Landroid/view/HardwareLayer;
.end method

.method abstract createHardwareLayer(Z)Landroid/view/HardwareLayer;
.end method

.method abstract createSurfaceTexture(Landroid/view/HardwareLayer;)Landroid/graphics/SurfaceTexture;
.end method

.method abstract destroy(Z)V
.end method

.method abstract destroyHardwareResources(Landroid/view/View;)V
.end method

.method abstract destroyLayers(Landroid/view/View;)V
.end method

.method abstract detachFunctor(I)V
.end method

.method abstract draw(Landroid/view/View;Landroid/view/View$AttachInfo;Landroid/view/HardwareRenderer$HardwareDrawCallbacks;Landroid/graphics/Rect;)Z
.end method

.method abstract dumpGfxInfo(Ljava/io/PrintWriter;)V
.end method

.method abstract getCanvas()Landroid/view/HardwareCanvas;
.end method

.method abstract getFrameCount()J
.end method

.method abstract getHeight()I
.end method

.method abstract getWidth()I
.end method

.method abstract initialize(Landroid/view/SurfaceHolder;)Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/view/Surface$OutOfResourcesException;
        }
    .end annotation
.end method

.method initializeIfNeeded(IILandroid/view/SurfaceHolder;)V
    .registers 5
    .parameter "width"
    .parameter "height"
    .parameter "holder"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/view/Surface$OutOfResourcesException;
        }
    .end annotation

    .prologue
    .line 481
    invoke-virtual {p0}, Landroid/view/HardwareRenderer;->isRequested()Z

    move-result v0

    if-eqz v0, :cond_15

    .line 483
    invoke-virtual {p0}, Landroid/view/HardwareRenderer;->isEnabled()Z

    move-result v0

    if-nez v0, :cond_15

    .line 484
    invoke-virtual {p0, p3}, Landroid/view/HardwareRenderer;->initialize(Landroid/view/SurfaceHolder;)Z

    move-result v0

    if-eqz v0, :cond_15

    .line 485
    invoke-virtual {p0, p1, p2}, Landroid/view/HardwareRenderer;->setup(II)V

    .line 489
    :cond_15
    return-void
.end method

.method abstract invalidate(Landroid/view/SurfaceHolder;)V
.end method

.method isEnabled()Z
    .registers 2

    .prologue
    .line 546
    iget-boolean v0, p0, Landroid/view/HardwareRenderer;->mEnabled:Z

    return v0
.end method

.method isRequested()Z
    .registers 2

    .prologue
    .line 565
    iget-boolean v0, p0, Landroid/view/HardwareRenderer;->mRequested:Z

    return v0
.end method

.method abstract safelyRun(Ljava/lang/Runnable;)Z
.end method

.method setEnabled(Z)V
    .registers 2
    .parameter "enabled"

    .prologue
    .line 555
    iput-boolean p1, p0, Landroid/view/HardwareRenderer;->mEnabled:Z

    .line 556
    return-void
.end method

.method setRequested(Z)V
    .registers 2
    .parameter "requested"

    .prologue
    .line 575
    iput-boolean p1, p0, Landroid/view/HardwareRenderer;->mRequested:Z

    .line 576
    return-void
.end method

.method abstract setSurfaceTexture(Landroid/view/HardwareLayer;Landroid/graphics/SurfaceTexture;)V
.end method

.method abstract setup(II)V
.end method

.method abstract updateSurface(Landroid/view/SurfaceHolder;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/view/Surface$OutOfResourcesException;
        }
    .end annotation
.end method

.method abstract validate()Z
.end method
