.class public Landroid/view/Surface;
.super Ljava/lang/Object;
.source "Surface.java"

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/view/Surface$CompatibleCanvas;,
        Landroid/view/Surface$OutOfResourcesException;
    }
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/view/Surface;",
            ">;"
        }
    .end annotation
.end field

.field private static final DEBUG_RELEASE:Z = false

.field public static final FX_SURFACE_BLUR:I = 0x10000
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final FX_SURFACE_DIM:I = 0x20000

.field public static final FX_SURFACE_MASK:I = 0xf0000

.field public static final FX_SURFACE_NORMAL:I = 0x0

.field public static final FX_SURFACE_SCREENSHOT:I = 0x30000

.field public static final HIDDEN:I = 0x4

.field private static final LOG_TAG:Ljava/lang/String; = "Surface"

.field public static final NON_PREMULTIPLIED:I = 0x100

.field public static final OPAQUE:I = 0x400

.field public static final PROTECTED_APP:I = 0x800

.field public static final ROTATION_0:I = 0x0

.field public static final ROTATION_180:I = 0x2

.field public static final ROTATION_270:I = 0x3

.field public static final ROTATION_90:I = 0x1

.field public static final SECURE:I = 0x80

.field public static final SURFACE_DITHER:I = 0x4

.field public static final SURFACE_FROZEN:I = 0x2

.field public static final SURFACE_HIDDEN:I = 0x1

.field private static final headless:Z


# instance fields
.field private mCanvas:Landroid/graphics/Canvas;

.field private mCompatibilityTranslator:Landroid/content/res/CompatibilityInfo$Translator;

.field private mCompatibleMatrix:Landroid/graphics/Matrix;

.field private mCreationStack:Ljava/lang/Exception;

.field private mName:Ljava/lang/String;

.field private mNativeSurface:I

.field private mSaveCount:I

.field private mSurfaceControl:I

.field private mSurfaceGenerationId:I


# direct methods
.method static constructor <clinit>()V
    .registers 3

    .prologue
    .line 39
    const-string v0, "1"

    const-string/jumbo v1, "ro.config.headless"

    const-string v2, "0"

    invoke-static {v1, v2}, Landroid/os/SystemProperties;->get(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    sput-boolean v0, Landroid/view/Surface;->headless:Z

    .line 253
    invoke-static {}, Landroid/view/Surface;->nativeClassInit()V

    .line 518
    new-instance v0, Landroid/view/Surface$1;

    invoke-direct {v0}, Landroid/view/Surface$1;-><init>()V

    sput-object v0, Landroid/view/Surface;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .registers 3

    .prologue
    .line 287
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 288
    invoke-static {}, Landroid/view/Surface;->checkHeadless()V

    .line 293
    new-instance v0, Landroid/view/Surface$CompatibleCanvas;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Landroid/view/Surface$CompatibleCanvas;-><init>(Landroid/view/Surface;Landroid/view/Surface$1;)V

    iput-object v0, p0, Landroid/view/Surface;->mCanvas:Landroid/graphics/Canvas;

    .line 294
    return-void
.end method

.method public constructor <init>(Landroid/graphics/SurfaceTexture;)V
    .registers 4
    .parameter "surfaceTexture"

    .prologue
    .line 58
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 59
    invoke-static {}, Landroid/view/Surface;->checkHeadless()V

    .line 64
    new-instance v0, Landroid/view/Surface$CompatibleCanvas;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Landroid/view/Surface$CompatibleCanvas;-><init>(Landroid/view/Surface;Landroid/view/Surface$1;)V

    iput-object v0, p0, Landroid/view/Surface;->mCanvas:Landroid/graphics/Canvas;

    .line 65
    invoke-direct {p0, p1}, Landroid/view/Surface;->initFromSurfaceTexture(Landroid/graphics/SurfaceTexture;)V

    .line 66
    return-void
.end method

.method private constructor <init>(Landroid/os/Parcel;)V
    .registers 2
    .parameter "source"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/view/Surface$OutOfResourcesException;
        }
    .end annotation

    .prologue
    .line 296
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 297
    invoke-direct {p0, p1}, Landroid/view/Surface;->init(Landroid/os/Parcel;)V

    .line 298
    return-void
.end method

.method synthetic constructor <init>(Landroid/os/Parcel;Landroid/view/Surface$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/view/Surface$OutOfResourcesException;
        }
    .end annotation

    .prologue
    .line 29
    invoke-direct {p0, p1}, Landroid/view/Surface;-><init>(Landroid/os/Parcel;)V

    return-void
.end method

.method public constructor <init>(Landroid/view/SurfaceSession;IIIIII)V
    .registers 17
    .parameter "s"
    .parameter "pid"
    .parameter "display"
    .parameter "w"
    .parameter "h"
    .parameter "format"
    .parameter "flags"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/view/Surface$OutOfResourcesException;
        }
    .end annotation

    .prologue
    .line 258
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 259
    invoke-static {}, Landroid/view/Surface;->checkHeadless()V

    .line 264
    new-instance v0, Landroid/view/Surface$CompatibleCanvas;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Landroid/view/Surface$CompatibleCanvas;-><init>(Landroid/view/Surface;Landroid/view/Surface$1;)V

    iput-object v0, p0, Landroid/view/Surface;->mCanvas:Landroid/graphics/Canvas;

    .line 265
    const/4 v3, 0x0

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move v4, p3

    move v5, p4

    move v6, p5

    move v7, p6

    move/from16 v8, p7

    invoke-direct/range {v0 .. v8}, Landroid/view/Surface;->init(Landroid/view/SurfaceSession;ILjava/lang/String;IIIII)V

    .line 266
    return-void
.end method

.method public constructor <init>(Landroid/view/SurfaceSession;ILjava/lang/String;IIIII)V
    .registers 11
    .parameter "s"
    .parameter "pid"
    .parameter "name"
    .parameter "display"
    .parameter "w"
    .parameter "h"
    .parameter "format"
    .parameter "flags"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/view/Surface$OutOfResourcesException;
        }
    .end annotation

    .prologue
    .line 271
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 272
    invoke-static {}, Landroid/view/Surface;->checkHeadless()V

    .line 277
    new-instance v0, Landroid/view/Surface$CompatibleCanvas;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Landroid/view/Surface$CompatibleCanvas;-><init>(Landroid/view/Surface;Landroid/view/Surface$1;)V

    iput-object v0, p0, Landroid/view/Surface;->mCanvas:Landroid/graphics/Canvas;

    .line 278
    invoke-direct/range {p0 .. p8}, Landroid/view/Surface;->init(Landroid/view/SurfaceSession;ILjava/lang/String;IIIII)V

    .line 279
    iput-object p3, p0, Landroid/view/Surface;->mName:Ljava/lang/String;

    .line 280
    return-void
.end method

.method static synthetic access$100(Landroid/view/Surface;)Landroid/content/res/CompatibilityInfo$Translator;
    .registers 2
    .parameter "x0"

    .prologue
    .line 29
    iget-object v0, p0, Landroid/view/Surface;->mCompatibilityTranslator:Landroid/content/res/CompatibilityInfo$Translator;

    return-object v0
.end method

.method static synthetic access$200(Landroid/view/Surface;)Landroid/graphics/Matrix;
    .registers 2
    .parameter "x0"

    .prologue
    .line 29
    iget-object v0, p0, Landroid/view/Surface;->mCompatibleMatrix:Landroid/graphics/Matrix;

    return-object v0
.end method

.method private static checkHeadless()V
    .registers 2

    .prologue
    .line 43
    sget-boolean v0, Landroid/view/Surface;->headless:Z

    if-eqz v0, :cond_c

    .line 44
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "Device is headless"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 46
    :cond_c
    return-void
.end method

.method public static native closeTransaction()V
.end method

.method public static native freezeDisplay(I)V
.end method

.method private native getIdentity()I
.end method

.method private native init(Landroid/os/Parcel;)V
.end method

.method private native init(Landroid/view/SurfaceSession;ILjava/lang/String;IIIII)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/view/Surface$OutOfResourcesException;
        }
    .end annotation
.end method

.method private native initFromSurfaceTexture(Landroid/graphics/SurfaceTexture;)V
.end method

.method private native lockCanvasNative(Landroid/graphics/Rect;)Landroid/graphics/Canvas;
.end method

.method private static native nativeClassInit()V
.end method

.method public static native openTransaction()V
.end method

.method public static native screenshot(II)Landroid/graphics/Bitmap;
.end method

.method public static native screenshot(IIII)Landroid/graphics/Bitmap;
.end method

.method public static setOrientation(II)V
    .registers 3
    .parameter "display"
    .parameter "orientation"

    .prologue
    .line 449
    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Landroid/view/Surface;->setOrientation(III)V

    .line 450
    return-void
.end method

.method public static native setOrientation(III)V
.end method

.method public static native unfreezeDisplay(I)V
.end method


# virtual methods
.method public native copyFrom(Landroid/view/Surface;)V
.end method

.method public describeContents()I
    .registers 2

    .prologue
    .line 106
    const/4 v0, 0x0

    return v0
.end method

.method public native destroy()V
.end method

.method protected finalize()V
    .registers 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 538
    :try_start_0
    invoke-super {p0}, Ljava/lang/Object;->finalize()V
    :try_end_3
    .catchall {:try_start_0 .. :try_end_3} :catchall_3b

    .line 540
    iget v0, p0, Landroid/view/Surface;->mNativeSurface:I

    if-nez v0, :cond_b

    iget v0, p0, Landroid/view/Surface;->mSurfaceControl:I

    if-eqz v0, :cond_37

    .line 545
    :cond_b
    const-string v0, "Surface"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Surface.finalize() has work. You should have called release() ("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Landroid/view/Surface;->mNativeSurface:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Landroid/view/Surface;->mSurfaceControl:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 549
    :cond_37
    invoke-virtual {p0}, Landroid/view/Surface;->release()V

    .line 551
    return-void

    .line 540
    :catchall_3b
    move-exception v0

    iget v1, p0, Landroid/view/Surface;->mNativeSurface:I

    if-nez v1, :cond_44

    iget v1, p0, Landroid/view/Surface;->mSurfaceControl:I

    if-eqz v1, :cond_70

    .line 545
    :cond_44
    const-string v1, "Surface"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Surface.finalize() has work. You should have called release() ("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v3, p0, Landroid/view/Surface;->mNativeSurface:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v3, p0, Landroid/view/Surface;->mSurfaceControl:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ")"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 549
    :cond_70
    invoke-virtual {p0}, Landroid/view/Surface;->release()V

    throw v0
.end method

.method public native freeze()V
.end method

.method public getGenerationId()I
    .registers 2

    .prologue
    .line 323
    iget v0, p0, Landroid/view/Surface;->mSurfaceGenerationId:I

    return v0
.end method

.method public native hide()V
.end method

.method public native isConsumerRunningBehind()Z
.end method

.method public native isValid()Z
.end method

.method public lockCanvas(Landroid/graphics/Rect;)Landroid/graphics/Canvas;
    .registers 3
    .parameter "dirty"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/view/Surface$OutOfResourcesException;,
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 88
    invoke-direct {p0, p1}, Landroid/view/Surface;->lockCanvasNative(Landroid/graphics/Rect;)Landroid/graphics/Canvas;

    move-result-object v0

    return-object v0
.end method

.method public native readFromParcel(Landroid/os/Parcel;)V
.end method

.method public native release()V
.end method

.method public native setAlpha(F)V
.end method

.method setCompatibilityTranslator(Landroid/content/res/CompatibilityInfo$Translator;)V
    .registers 4
    .parameter "translator"

    .prologue
    .line 400
    if-eqz p1, :cond_10

    .line 401
    iget v0, p1, Landroid/content/res/CompatibilityInfo$Translator;->applicationScale:F

    .line 402
    .local v0, appScale:F
    new-instance v1, Landroid/graphics/Matrix;

    invoke-direct {v1}, Landroid/graphics/Matrix;-><init>()V

    iput-object v1, p0, Landroid/view/Surface;->mCompatibleMatrix:Landroid/graphics/Matrix;

    .line 403
    iget-object v1, p0, Landroid/view/Surface;->mCompatibleMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v1, v0, v0}, Landroid/graphics/Matrix;->setScale(FF)V

    .line 405
    .end local v0           #appScale:F
    :cond_10
    return-void
.end method

.method public native setFlags(II)V
.end method

.method public native setFreezeTint(I)V
.end method

.method public native setLayer(I)V
.end method

.method public native setMatrix(FFFF)V
.end method

.method public native setPosition(FF)V
.end method

.method public setPosition(II)V
    .registers 5
    .parameter "x"
    .parameter "y"

    .prologue
    .line 490
    int-to-float v0, p1

    int-to-float v1, p2

    invoke-virtual {p0, v0, v1}, Landroid/view/Surface;->setPosition(FF)V

    return-void
.end method

.method public native setSize(II)V
.end method

.method public native setTransparentRegionHint(Landroid/graphics/Region;)V
.end method

.method public native setWindowCrop(Landroid/graphics/Rect;)V
.end method

.method public native show()V
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    .prologue
    .line 102
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Surface(name="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Landroid/view/Surface;->mName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", identity="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-direct {p0}, Landroid/view/Surface;->getIdentity()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public native transferFrom(Landroid/view/Surface;)V
.end method

.method public native unfreeze()V
.end method

.method public native unlockCanvas(Landroid/graphics/Canvas;)V
.end method

.method public native unlockCanvasAndPost(Landroid/graphics/Canvas;)V
.end method

.method public native writeToParcel(Landroid/os/Parcel;I)V
.end method
