.class final Landroid/webkit/DeviceMotionAndOrientationManager;
.super Ljava/lang/Object;
.source "DeviceMotionAndOrientationManager.java"


# static fields
.field static final synthetic $assertionsDisabled:Z


# instance fields
.field private mWebViewCore:Landroid/webkit/WebViewCore;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 26
    const-class v0, Landroid/webkit/DeviceMotionAndOrientationManager;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_c

    const/4 v0, 0x1

    :goto_9
    sput-boolean v0, Landroid/webkit/DeviceMotionAndOrientationManager;->$assertionsDisabled:Z

    return-void

    :cond_c
    const/4 v0, 0x0

    goto :goto_9
.end method

.method public constructor <init>(Landroid/webkit/WebViewCore;)V
    .registers 2
    .parameter "webViewCore"

    .prologue
    .line 29
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 30
    iput-object p1, p0, Landroid/webkit/DeviceMotionAndOrientationManager;->mWebViewCore:Landroid/webkit/WebViewCore;

    .line 31
    return-void
.end method

.method private static native nativeOnMotionChange(Landroid/webkit/WebViewCore;ZDZDZDD)V
.end method

.method private static native nativeOnOrientationChange(Landroid/webkit/WebViewCore;ZDZDZD)V
.end method

.method private static native nativeSetMockOrientation(Landroid/webkit/WebViewCore;ZDZDZD)V
.end method

.method private static native nativeSetUseMock(Landroid/webkit/WebViewCore;)V
.end method


# virtual methods
.method public onMotionChange(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;D)V
    .registers 18
    .parameter "x"
    .parameter "y"
    .parameter "z"
    .parameter "interval"

    .prologue
    .line 54
    iget-object v0, p0, Landroid/webkit/DeviceMotionAndOrientationManager;->mWebViewCore:Landroid/webkit/WebViewCore;

    if-eqz p1, :cond_23

    const/4 v1, 0x1

    :goto_5
    if-eqz p1, :cond_25

    invoke-virtual {p1}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v2

    :goto_b
    if-eqz p2, :cond_28

    const/4 v4, 0x1

    :goto_e
    if-eqz p2, :cond_2a

    invoke-virtual {p2}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v5

    :goto_14
    if-eqz p3, :cond_2d

    const/4 v7, 0x1

    :goto_17
    if-eqz p3, :cond_2f

    invoke-virtual {p3}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v8

    :goto_1d
    move-wide/from16 v10, p4

    invoke-static/range {v0 .. v11}, Landroid/webkit/DeviceMotionAndOrientationManager;->nativeOnMotionChange(Landroid/webkit/WebViewCore;ZDZDZDD)V

    .line 59
    return-void

    .line 54
    :cond_23
    const/4 v1, 0x0

    goto :goto_5

    :cond_25
    const-wide/16 v2, 0x0

    goto :goto_b

    :cond_28
    const/4 v4, 0x0

    goto :goto_e

    :cond_2a
    const-wide/16 v5, 0x0

    goto :goto_14

    :cond_2d
    const/4 v7, 0x0

    goto :goto_17

    :cond_2f
    const-wide/16 v8, 0x0

    goto :goto_1d
.end method

.method public onOrientationChange(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V
    .registers 15
    .parameter "alpha"
    .parameter "beta"
    .parameter "gamma"

    .prologue
    const/4 v7, 0x1

    const/4 v10, 0x0

    const-wide/16 v8, 0x0

    .line 61
    iget-object v0, p0, Landroid/webkit/DeviceMotionAndOrientationManager;->mWebViewCore:Landroid/webkit/WebViewCore;

    if-eqz p1, :cond_24

    move v1, v7

    :goto_9
    if-eqz p1, :cond_26

    invoke-virtual {p1}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v2

    :goto_f
    if-eqz p2, :cond_28

    move v4, v7

    :goto_12
    if-eqz p2, :cond_2a

    invoke-virtual {p2}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v5

    :goto_18
    if-eqz p3, :cond_2c

    :goto_1a
    if-eqz p3, :cond_20

    invoke-virtual {p3}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v8

    :cond_20
    invoke-static/range {v0 .. v9}, Landroid/webkit/DeviceMotionAndOrientationManager;->nativeOnOrientationChange(Landroid/webkit/WebViewCore;ZDZDZD)V

    .line 65
    return-void

    :cond_24
    move v1, v10

    .line 61
    goto :goto_9

    :cond_26
    move-wide v2, v8

    goto :goto_f

    :cond_28
    move v4, v10

    goto :goto_12

    :cond_2a
    move-wide v5, v8

    goto :goto_18

    :cond_2c
    move v7, v10

    goto :goto_1a
.end method

.method public setMockOrientation(ZDZDZD)V
    .registers 20
    .parameter "canProvideAlpha"
    .parameter "alpha"
    .parameter "canProvideBeta"
    .parameter "beta"
    .parameter "canProvideGamma"
    .parameter "gamma"

    .prologue
    .line 47
    sget-boolean v0, Landroid/webkit/DeviceMotionAndOrientationManager;->$assertionsDisabled:Z

    if-nez v0, :cond_1a

    const-string v0, "WebViewCoreThread"

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Thread;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1a

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 48
    :cond_1a
    iget-object v0, p0, Landroid/webkit/DeviceMotionAndOrientationManager;->mWebViewCore:Landroid/webkit/WebViewCore;

    move v1, p1

    move-wide v2, p2

    move v4, p4

    move-wide v5, p5

    move/from16 v7, p7

    move-wide/from16 v8, p8

    invoke-static/range {v0 .. v9}, Landroid/webkit/DeviceMotionAndOrientationManager;->nativeSetMockOrientation(Landroid/webkit/WebViewCore;ZDZDZD)V

    .line 50
    return-void
.end method

.method public setUseMock()V
    .registers 3

    .prologue
    .line 38
    sget-boolean v0, Landroid/webkit/DeviceMotionAndOrientationManager;->$assertionsDisabled:Z

    if-nez v0, :cond_1a

    const-string v0, "WebViewCoreThread"

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Thread;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1a

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 39
    :cond_1a
    iget-object v0, p0, Landroid/webkit/DeviceMotionAndOrientationManager;->mWebViewCore:Landroid/webkit/WebViewCore;

    invoke-static {v0}, Landroid/webkit/DeviceMotionAndOrientationManager;->nativeSetUseMock(Landroid/webkit/WebViewCore;)V

    .line 40
    return-void
.end method
