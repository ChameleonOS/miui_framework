.class public Landroid/view/Display;
.super Ljava/lang/Object;
.source "Display.java"


# static fields
.field static final DEBUG_DISPLAY_SIZE:Z = false

.field public static final DEFAULT_DISPLAY:I = 0x0

.field static final TAG:Ljava/lang/String; = "Display"

.field private static sInitialized:Z

.field private static final sStaticInit:Ljava/lang/Object;

.field private static sWindowManager:Landroid/view/IWindowManager;


# instance fields
.field private final mCompatibilityInfo:Landroid/view/CompatibilityInfoHolder;

.field mDensity:F

.field private final mDisplay:I

.field mDpiX:F

.field mDpiY:F

.field private mLastGetTime:F

.field private mPixelFormat:I

.field private mRefreshRate:F

.field private final mTmpMetrics:Landroid/util/DisplayMetrics;

.field private final mTmpPoint:Landroid/graphics/Point;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Landroid/view/Display;->sStaticInit:Ljava/lang/Object;

    const/4 v0, 0x0

    sput-boolean v0, Landroid/view/Display;->sInitialized:Z

    return-void
.end method

.method constructor <init>(ILandroid/view/CompatibilityInfoHolder;)V
    .registers 5
    .parameter "display"
    .parameter "compatInfo"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Landroid/graphics/Point;

    invoke-direct {v0}, Landroid/graphics/Point;-><init>()V

    iput-object v0, p0, Landroid/view/Display;->mTmpPoint:Landroid/graphics/Point;

    new-instance v0, Landroid/util/DisplayMetrics;

    invoke-direct {v0}, Landroid/util/DisplayMetrics;-><init>()V

    iput-object v0, p0, Landroid/view/Display;->mTmpMetrics:Landroid/util/DisplayMetrics;

    sget-object v1, Landroid/view/Display;->sStaticInit:Ljava/lang/Object;

    monitor-enter v1

    :try_start_14
    sget-boolean v0, Landroid/view/Display;->sInitialized:Z

    if-nez v0, :cond_1e

    invoke-static {}, Landroid/view/Display;->nativeClassInit()V

    const/4 v0, 0x1

    sput-boolean v0, Landroid/view/Display;->sInitialized:Z

    :cond_1e
    monitor-exit v1
    :try_end_1f
    .catchall {:try_start_14 .. :try_end_1f} :catchall_29

    if-eqz p2, :cond_2c

    .end local p2
    :goto_21
    iput-object p2, p0, Landroid/view/Display;->mCompatibilityInfo:Landroid/view/CompatibilityInfoHolder;

    iput p1, p0, Landroid/view/Display;->mDisplay:I

    invoke-direct {p0, p1}, Landroid/view/Display;->init(I)V

    return-void

    .restart local p2
    :catchall_29
    move-exception v0

    :try_start_2a
    monitor-exit v1
    :try_end_2b
    .catchall {:try_start_2a .. :try_end_2b} :catchall_29

    throw v0

    :cond_2c
    new-instance p2, Landroid/view/CompatibilityInfoHolder;

    .end local p2
    invoke-direct {p2}, Landroid/view/CompatibilityInfoHolder;-><init>()V

    goto :goto_21
.end method

.method public static createCompatibleDisplay(ILandroid/view/CompatibilityInfoHolder;)Landroid/view/Display;
    .registers 3
    .parameter "displayId"
    .parameter "compat"

    .prologue
    new-instance v0, Landroid/view/Display;

    invoke-direct {v0, p0, p1}, Landroid/view/Display;-><init>(ILandroid/view/CompatibilityInfoHolder;)V

    return-object v0
.end method

.method static native getDisplayCount()I
.end method

.method private native getRawHeightNative()I
.end method

.method private native getRawWidthNative()I
.end method

.method private getSizeInternal(Landroid/graphics/Point;Z)V
    .registers 9
    .parameter "outSize"
    .parameter "doCompat"

    .prologue
    :try_start_0
    invoke-static {}, Landroid/view/Display;->getWindowManager()Landroid/view/IWindowManager;

    move-result-object v2

    .local v2, wm:Landroid/view/IWindowManager;
    if-eqz v2, :cond_47

    invoke-interface {v2, p1}, Landroid/view/IWindowManager;->getDisplaySize(Landroid/graphics/Point;)V

    if-eqz p2, :cond_3a

    iget-object v3, p0, Landroid/view/Display;->mCompatibilityInfo:Landroid/view/CompatibilityInfoHolder;

    invoke-virtual {v3}, Landroid/view/CompatibilityInfoHolder;->getIfNeeded()Landroid/content/res/CompatibilityInfo;

    move-result-object v0

    .local v0, ci:Landroid/content/res/CompatibilityInfo;
    if-eqz v0, :cond_3a

    iget-object v4, p0, Landroid/view/Display;->mTmpMetrics:Landroid/util/DisplayMetrics;

    monitor-enter v4
    :try_end_16
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_16} :catch_3e

    :try_start_16
    iget-object v3, p0, Landroid/view/Display;->mTmpMetrics:Landroid/util/DisplayMetrics;

    iget v5, p1, Landroid/graphics/Point;->x:I

    iput v5, v3, Landroid/util/DisplayMetrics;->noncompatWidthPixels:I

    iget-object v3, p0, Landroid/view/Display;->mTmpMetrics:Landroid/util/DisplayMetrics;

    iget v5, p1, Landroid/graphics/Point;->y:I

    iput v5, v3, Landroid/util/DisplayMetrics;->noncompatHeightPixels:I

    iget-object v3, p0, Landroid/view/Display;->mTmpMetrics:Landroid/util/DisplayMetrics;

    iget v5, p0, Landroid/view/Display;->mDensity:F

    iput v5, v3, Landroid/util/DisplayMetrics;->density:F

    iget-object v3, p0, Landroid/view/Display;->mTmpMetrics:Landroid/util/DisplayMetrics;

    invoke-virtual {v0, v3}, Landroid/content/res/CompatibilityInfo;->applyToDisplayMetrics(Landroid/util/DisplayMetrics;)V

    iget-object v3, p0, Landroid/view/Display;->mTmpMetrics:Landroid/util/DisplayMetrics;

    iget v3, v3, Landroid/util/DisplayMetrics;->widthPixels:I

    iput v3, p1, Landroid/graphics/Point;->x:I

    iget-object v3, p0, Landroid/view/Display;->mTmpMetrics:Landroid/util/DisplayMetrics;

    iget v3, v3, Landroid/util/DisplayMetrics;->heightPixels:I

    iput v3, p1, Landroid/graphics/Point;->y:I

    monitor-exit v4

    .end local v0           #ci:Landroid/content/res/CompatibilityInfo;
    .end local v2           #wm:Landroid/view/IWindowManager;
    :cond_3a
    :goto_3a
    return-void

    .restart local v0       #ci:Landroid/content/res/CompatibilityInfo;
    .restart local v2       #wm:Landroid/view/IWindowManager;
    :catchall_3b
    move-exception v3

    monitor-exit v4
    :try_end_3d
    .catchall {:try_start_16 .. :try_end_3d} :catchall_3b

    :try_start_3d
    throw v3
    :try_end_3e
    .catch Landroid/os/RemoteException; {:try_start_3d .. :try_end_3e} :catch_3e

    .end local v0           #ci:Landroid/content/res/CompatibilityInfo;
    .end local v2           #wm:Landroid/view/IWindowManager;
    :catch_3e
    move-exception v1

    .local v1, e:Landroid/os/RemoteException;
    const-string v3, "Display"

    const-string v4, "Unable to get display size"

    invoke-static {v3, v4, v1}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_3a

    .end local v1           #e:Landroid/os/RemoteException;
    .restart local v2       #wm:Landroid/view/IWindowManager;
    :cond_47
    :try_start_47
    invoke-virtual {p0}, Landroid/view/Display;->getRawWidth()I

    move-result v3

    iput v3, p1, Landroid/graphics/Point;->x:I

    invoke-virtual {p0}, Landroid/view/Display;->getRawHeight()I

    move-result v3

    iput v3, p1, Landroid/graphics/Point;->y:I
    :try_end_53
    .catch Landroid/os/RemoteException; {:try_start_47 .. :try_end_53} :catch_3e

    goto :goto_3a
.end method

.method static getWindowManager()Landroid/view/IWindowManager;
    .registers 2

    .prologue
    sget-object v1, Landroid/view/Display;->sStaticInit:Ljava/lang/Object;

    monitor-enter v1

    :try_start_3
    sget-object v0, Landroid/view/Display;->sWindowManager:Landroid/view/IWindowManager;

    if-nez v0, :cond_14

    const-string/jumbo v0, "window"

    invoke-static {v0}, Landroid/os/ServiceManager;->getService(Ljava/lang/String;)Landroid/os/IBinder;

    move-result-object v0

    invoke-static {v0}, Landroid/view/IWindowManager$Stub;->asInterface(Landroid/os/IBinder;)Landroid/view/IWindowManager;

    move-result-object v0

    sput-object v0, Landroid/view/Display;->sWindowManager:Landroid/view/IWindowManager;

    :cond_14
    sget-object v0, Landroid/view/Display;->sWindowManager:Landroid/view/IWindowManager;

    monitor-exit v1

    return-object v0

    :catchall_18
    move-exception v0

    monitor-exit v1
    :try_end_1a
    .catchall {:try_start_3 .. :try_end_1a} :catchall_18

    throw v0
.end method

.method private native init(I)V
.end method

.method private static native nativeClassInit()V
.end method


# virtual methods
.method public getCurrentSizeRange(Landroid/graphics/Point;Landroid/graphics/Point;)V
    .registers 8
    .parameter "outSmallestSize"
    .parameter "outLargestSize"

    .prologue
    const/4 v4, 0x0

    :try_start_1
    invoke-static {}, Landroid/view/Display;->getWindowManager()Landroid/view/IWindowManager;

    move-result-object v1

    .local v1, wm:Landroid/view/IWindowManager;
    invoke-interface {v1, p1, p2}, Landroid/view/IWindowManager;->getCurrentSizeRange(Landroid/graphics/Point;Landroid/graphics/Point;)V
    :try_end_8
    .catch Landroid/os/RemoteException; {:try_start_1 .. :try_end_8} :catch_9

    .end local v1           #wm:Landroid/view/IWindowManager;
    :goto_8
    return-void

    :catch_9
    move-exception v0

    .local v0, e:Landroid/os/RemoteException;
    const-string v2, "Display"

    const-string v3, "Unable to get display size range"

    invoke-static {v2, v3, v0}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    iput v4, p1, Landroid/graphics/Point;->x:I

    iput v4, p1, Landroid/graphics/Point;->y:I

    iput v4, p2, Landroid/graphics/Point;->x:I

    iput v4, p2, Landroid/graphics/Point;->y:I

    goto :goto_8
.end method

.method public getDisplayId()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/view/Display;->mDisplay:I

    return v0
.end method

.method public getExternalRotation()I
    .registers 2

    .prologue
    const/4 v0, 0x0

    return v0
.end method

.method public getHeight()I
    .registers 7
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    iget-object v3, p0, Landroid/view/Display;->mTmpPoint:Landroid/graphics/Point;

    monitor-enter v3

    :try_start_3
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    .local v0, now:J
    long-to-float v2, v0

    iget v4, p0, Landroid/view/Display;->mLastGetTime:F

    const/high16 v5, 0x41a0

    add-float/2addr v4, v5

    cmpl-float v2, v2, v4

    if-lez v2, :cond_1a

    iget-object v2, p0, Landroid/view/Display;->mTmpPoint:Landroid/graphics/Point;

    const/4 v4, 0x1

    invoke-direct {p0, v2, v4}, Landroid/view/Display;->getSizeInternal(Landroid/graphics/Point;Z)V

    long-to-float v2, v0

    iput v2, p0, Landroid/view/Display;->mLastGetTime:F

    :cond_1a
    iget-object v2, p0, Landroid/view/Display;->mTmpPoint:Landroid/graphics/Point;

    iget v2, v2, Landroid/graphics/Point;->y:I

    monitor-exit v3

    return v2

    .end local v0           #now:J
    :catchall_20
    move-exception v2

    monitor-exit v3
    :try_end_22
    .catchall {:try_start_3 .. :try_end_22} :catchall_20

    throw v2
.end method

.method public getMaximumSizeDimension()I
    .registers 5

    .prologue
    :try_start_0
    invoke-static {}, Landroid/view/Display;->getWindowManager()Landroid/view/IWindowManager;

    move-result-object v1

    .local v1, wm:Landroid/view/IWindowManager;
    invoke-interface {v1}, Landroid/view/IWindowManager;->getMaximumSizeDimension()I
    :try_end_7
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_7} :catch_9

    move-result v2

    .end local v1           #wm:Landroid/view/IWindowManager;
    :goto_8
    return v2

    :catch_9
    move-exception v0

    .local v0, e:Landroid/os/RemoteException;
    const-string v2, "Display"

    const-string v3, "Unable to get display maximum size dimension"

    invoke-static {v2, v3, v0}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    const/4 v2, 0x0

    goto :goto_8
.end method

.method public getMetrics(Landroid/util/DisplayMetrics;)V
    .registers 6
    .parameter "outMetrics"

    .prologue
    iget-object v2, p0, Landroid/view/Display;->mTmpPoint:Landroid/graphics/Point;

    monitor-enter v2

    :try_start_3
    iget-object v1, p0, Landroid/view/Display;->mTmpPoint:Landroid/graphics/Point;

    const/4 v3, 0x0

    invoke-direct {p0, v1, v3}, Landroid/view/Display;->getSizeInternal(Landroid/graphics/Point;Z)V

    iget-object v1, p0, Landroid/view/Display;->mTmpPoint:Landroid/graphics/Point;

    iget v1, v1, Landroid/graphics/Point;->x:I

    iget-object v3, p0, Landroid/view/Display;->mTmpPoint:Landroid/graphics/Point;

    iget v3, v3, Landroid/graphics/Point;->y:I

    invoke-virtual {p0, p1, v1, v3}, Landroid/view/Display;->getMetricsWithSize(Landroid/util/DisplayMetrics;II)V

    monitor-exit v2
    :try_end_15
    .catchall {:try_start_3 .. :try_end_15} :catchall_21

    iget-object v1, p0, Landroid/view/Display;->mCompatibilityInfo:Landroid/view/CompatibilityInfoHolder;

    invoke-virtual {v1}, Landroid/view/CompatibilityInfoHolder;->getIfNeeded()Landroid/content/res/CompatibilityInfo;

    move-result-object v0

    .local v0, ci:Landroid/content/res/CompatibilityInfo;
    if-eqz v0, :cond_20

    invoke-virtual {v0, p1}, Landroid/content/res/CompatibilityInfo;->applyToDisplayMetrics(Landroid/util/DisplayMetrics;)V

    :cond_20
    return-void

    .end local v0           #ci:Landroid/content/res/CompatibilityInfo;
    :catchall_21
    move-exception v1

    :try_start_22
    monitor-exit v2
    :try_end_23
    .catchall {:try_start_22 .. :try_end_23} :catchall_21

    throw v1
.end method

.method public getMetricsWithSize(Landroid/util/DisplayMetrics;II)V
    .registers 6
    .parameter "outMetrics"
    .parameter "width"
    .parameter "height"

    .prologue
    iget v0, p0, Landroid/view/Display;->mDensity:F

    const/high16 v1, 0x4320

    mul-float/2addr v0, v1

    const/high16 v1, 0x3f00

    add-float/2addr v0, v1

    float-to-int v0, v0

    iput v0, p1, Landroid/util/DisplayMetrics;->densityDpi:I

    iput p2, p1, Landroid/util/DisplayMetrics;->widthPixels:I

    iput p2, p1, Landroid/util/DisplayMetrics;->noncompatWidthPixels:I

    iput p3, p1, Landroid/util/DisplayMetrics;->heightPixels:I

    iput p3, p1, Landroid/util/DisplayMetrics;->noncompatHeightPixels:I

    iget v0, p0, Landroid/view/Display;->mDensity:F

    iput v0, p1, Landroid/util/DisplayMetrics;->noncompatDensity:F

    iput v0, p1, Landroid/util/DisplayMetrics;->density:F

    iget v0, p1, Landroid/util/DisplayMetrics;->density:F

    iput v0, p1, Landroid/util/DisplayMetrics;->noncompatScaledDensity:F

    iput v0, p1, Landroid/util/DisplayMetrics;->scaledDensity:F

    iget v0, p0, Landroid/view/Display;->mDpiX:F

    iput v0, p1, Landroid/util/DisplayMetrics;->noncompatXdpi:F

    iput v0, p1, Landroid/util/DisplayMetrics;->xdpi:F

    iget v0, p0, Landroid/view/Display;->mDpiY:F

    iput v0, p1, Landroid/util/DisplayMetrics;->noncompatYdpi:F

    iput v0, p1, Landroid/util/DisplayMetrics;->ydpi:F

    return-void
.end method

.method public native getOrientation()I
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public getPixelFormat()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/view/Display;->mPixelFormat:I

    return v0
.end method

.method public getRawExternalHeight()I
    .registers 2

    .prologue
    const/16 v0, 0x2d0

    return v0
.end method

.method public getRawExternalWidth()I
    .registers 2

    .prologue
    const/16 v0, 0x500

    return v0
.end method

.method public getRawHeight()I
    .registers 2

    .prologue
    invoke-direct {p0}, Landroid/view/Display;->getRawHeightNative()I

    move-result v0

    .local v0, h:I
    return v0
.end method

.method public getRawWidth()I
    .registers 2

    .prologue
    invoke-direct {p0}, Landroid/view/Display;->getRawWidthNative()I

    move-result v0

    .local v0, w:I
    return v0
.end method

.method public getRealMetrics(Landroid/util/DisplayMetrics;)V
    .registers 5
    .parameter "outMetrics"

    .prologue
    iget-object v1, p0, Landroid/view/Display;->mTmpPoint:Landroid/graphics/Point;

    monitor-enter v1

    :try_start_3
    iget-object v0, p0, Landroid/view/Display;->mTmpPoint:Landroid/graphics/Point;

    invoke-virtual {p0, v0}, Landroid/view/Display;->getRealSize(Landroid/graphics/Point;)V

    iget-object v0, p0, Landroid/view/Display;->mTmpPoint:Landroid/graphics/Point;

    iget v0, v0, Landroid/graphics/Point;->x:I

    iget-object v2, p0, Landroid/view/Display;->mTmpPoint:Landroid/graphics/Point;

    iget v2, v2, Landroid/graphics/Point;->y:I

    invoke-virtual {p0, p1, v0, v2}, Landroid/view/Display;->getMetricsWithSize(Landroid/util/DisplayMetrics;II)V

    monitor-exit v1

    return-void

    :catchall_15
    move-exception v0

    monitor-exit v1
    :try_end_17
    .catchall {:try_start_3 .. :try_end_17} :catchall_15

    throw v0
.end method

.method public getRealSize(Landroid/graphics/Point;)V
    .registers 6
    .parameter "outSize"

    .prologue
    :try_start_0
    invoke-static {}, Landroid/view/Display;->getWindowManager()Landroid/view/IWindowManager;

    move-result-object v1

    .local v1, wm:Landroid/view/IWindowManager;
    if-eqz v1, :cond_a

    invoke-interface {v1, p1}, Landroid/view/IWindowManager;->getRealDisplaySize(Landroid/graphics/Point;)V

    .end local v1           #wm:Landroid/view/IWindowManager;
    :goto_9
    return-void

    .restart local v1       #wm:Landroid/view/IWindowManager;
    :cond_a
    invoke-virtual {p0}, Landroid/view/Display;->getRawWidth()I

    move-result v2

    iput v2, p1, Landroid/graphics/Point;->x:I

    invoke-virtual {p0}, Landroid/view/Display;->getRawHeight()I

    move-result v2

    iput v2, p1, Landroid/graphics/Point;->y:I
    :try_end_16
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_16} :catch_17

    goto :goto_9

    .end local v1           #wm:Landroid/view/IWindowManager;
    :catch_17
    move-exception v0

    .local v0, e:Landroid/os/RemoteException;
    const-string v2, "Display"

    const-string v3, "Unable to get real display size"

    invoke-static {v2, v3, v0}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_9
.end method

.method public getRectSize(Landroid/graphics/Rect;)V
    .registers 7
    .parameter "outSize"

    .prologue
    iget-object v1, p0, Landroid/view/Display;->mTmpPoint:Landroid/graphics/Point;

    monitor-enter v1

    :try_start_3
    iget-object v0, p0, Landroid/view/Display;->mTmpPoint:Landroid/graphics/Point;

    const/4 v2, 0x1

    invoke-direct {p0, v0, v2}, Landroid/view/Display;->getSizeInternal(Landroid/graphics/Point;Z)V

    const/4 v0, 0x0

    const/4 v2, 0x0

    iget-object v3, p0, Landroid/view/Display;->mTmpPoint:Landroid/graphics/Point;

    iget v3, v3, Landroid/graphics/Point;->x:I

    iget-object v4, p0, Landroid/view/Display;->mTmpPoint:Landroid/graphics/Point;

    iget v4, v4, Landroid/graphics/Point;->y:I

    invoke-virtual {p1, v0, v2, v3, v4}, Landroid/graphics/Rect;->set(IIII)V

    monitor-exit v1

    return-void

    :catchall_18
    move-exception v0

    monitor-exit v1
    :try_end_1a
    .catchall {:try_start_3 .. :try_end_1a} :catchall_18

    throw v0
.end method

.method public getRefreshRate()F
    .registers 2

    .prologue
    iget v0, p0, Landroid/view/Display;->mRefreshRate:F

    return v0
.end method

.method public getRotation()I
    .registers 2

    .prologue
    invoke-virtual {p0}, Landroid/view/Display;->getOrientation()I

    move-result v0

    return v0
.end method

.method public getSize(Landroid/graphics/Point;)V
    .registers 3
    .parameter "outSize"

    .prologue
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0}, Landroid/view/Display;->getSizeInternal(Landroid/graphics/Point;Z)V

    return-void
.end method

.method public getWidth()I
    .registers 7
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    iget-object v3, p0, Landroid/view/Display;->mTmpPoint:Landroid/graphics/Point;

    monitor-enter v3

    :try_start_3
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    .local v0, now:J
    long-to-float v2, v0

    iget v4, p0, Landroid/view/Display;->mLastGetTime:F

    const/high16 v5, 0x41a0

    add-float/2addr v4, v5

    cmpl-float v2, v2, v4

    if-lez v2, :cond_1a

    iget-object v2, p0, Landroid/view/Display;->mTmpPoint:Landroid/graphics/Point;

    const/4 v4, 0x1

    invoke-direct {p0, v2, v4}, Landroid/view/Display;->getSizeInternal(Landroid/graphics/Point;Z)V

    long-to-float v2, v0

    iput v2, p0, Landroid/view/Display;->mLastGetTime:F

    :cond_1a
    iget-object v2, p0, Landroid/view/Display;->mTmpPoint:Landroid/graphics/Point;

    iget v2, v2, Landroid/graphics/Point;->x:I

    monitor-exit v3

    return v2

    .end local v0           #now:J
    :catchall_20
    move-exception v2

    monitor-exit v3
    :try_end_22
    .catchall {:try_start_3 .. :try_end_22} :catchall_20

    throw v2
.end method
