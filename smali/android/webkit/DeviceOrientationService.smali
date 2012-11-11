.class final Landroid/webkit/DeviceOrientationService;
.super Ljava/lang/Object;
.source "DeviceOrientationService.java"

# interfaces
.implements Landroid/hardware/SensorEventListener;


# static fields
#the value of this static final field might be set in the static constructor
.field static final synthetic $assertionsDisabled:Z = false

.field private static final DELTA_DEGRESS:D = 1.0


# instance fields
.field private mAlpha:Ljava/lang/Double;

.field private mBeta:Ljava/lang/Double;

.field private mContext:Landroid/content/Context;

.field private mGamma:Ljava/lang/Double;

.field private mGravityVector:[F

.field private mHandler:Landroid/os/Handler;

.field private mHaveSentErrorEvent:Z

.field private mIsRunning:Z

.field private mMagneticFieldVector:[F

.field private mManager:Landroid/webkit/DeviceMotionAndOrientationManager;

.field private mSensorManager:Landroid/hardware/SensorManager;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    const-class v0, Landroid/webkit/DeviceOrientationService;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_c

    const/4 v0, 0x1

    :goto_9
    sput-boolean v0, Landroid/webkit/DeviceOrientationService;->$assertionsDisabled:Z

    return-void

    :cond_c
    const/4 v0, 0x0

    goto :goto_9
.end method

.method public constructor <init>(Landroid/webkit/DeviceMotionAndOrientationManager;Landroid/content/Context;)V
    .registers 4
    .parameter "manager"
    .parameter "context"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroid/webkit/DeviceOrientationService;->mManager:Landroid/webkit/DeviceMotionAndOrientationManager;

    sget-boolean v0, Landroid/webkit/DeviceOrientationService;->$assertionsDisabled:Z

    if-nez v0, :cond_13

    iget-object v0, p0, Landroid/webkit/DeviceOrientationService;->mManager:Landroid/webkit/DeviceMotionAndOrientationManager;

    if-nez v0, :cond_13

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    :cond_13
    iput-object p2, p0, Landroid/webkit/DeviceOrientationService;->mContext:Landroid/content/Context;

    sget-boolean v0, Landroid/webkit/DeviceOrientationService;->$assertionsDisabled:Z

    if-nez v0, :cond_23

    iget-object v0, p0, Landroid/webkit/DeviceOrientationService;->mContext:Landroid/content/Context;

    if-nez v0, :cond_23

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    :cond_23
    return-void
.end method

.method static synthetic access$000(Landroid/webkit/DeviceOrientationService;)Z
    .registers 2
    .parameter "x0"

    .prologue
    iget-boolean v0, p0, Landroid/webkit/DeviceOrientationService;->mIsRunning:Z

    return v0
.end method

.method static synthetic access$100(Landroid/webkit/DeviceOrientationService;)Landroid/webkit/DeviceMotionAndOrientationManager;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/webkit/DeviceOrientationService;->mManager:Landroid/webkit/DeviceMotionAndOrientationManager;

    return-object v0
.end method

.method private getOrientationUsingGetRotationMatrix()V
    .registers 16

    .prologue
    const-wide v13, 0x4076800000000000L

    iget-object v0, p0, Landroid/webkit/DeviceOrientationService;->mGravityVector:[F

    if-eqz v0, :cond_d

    iget-object v0, p0, Landroid/webkit/DeviceOrientationService;->mMagneticFieldVector:[F

    if-nez v0, :cond_e

    :cond_d
    :goto_d
    return-void

    :cond_e
    const/16 v0, 0x9

    new-array v7, v0, [F

    .local v7, deviceRotationMatrix:[F
    const/4 v0, 0x0

    iget-object v9, p0, Landroid/webkit/DeviceOrientationService;->mGravityVector:[F

    iget-object v10, p0, Landroid/webkit/DeviceOrientationService;->mMagneticFieldVector:[F

    invoke-static {v7, v0, v9, v10}, Landroid/hardware/SensorManager;->getRotationMatrix([F[F[F[F)Z

    move-result v0

    if-eqz v0, :cond_d

    const/4 v0, 0x3

    new-array v8, v0, [F

    .local v8, rotationAngles:[F
    invoke-static {v7, v8}, Landroid/hardware/SensorManager;->getOrientation([F[F)[F

    const/4 v0, 0x0

    aget v0, v8, v0

    neg-float v0, v0

    float-to-double v9, v0

    invoke-static {v9, v10}, Ljava/lang/Math;->toDegrees(D)D

    move-result-wide v9

    const-wide v11, 0x4056800000000000L

    sub-double v1, v9, v11

    .local v1, alpha:D
    :goto_33
    const-wide/16 v9, 0x0

    cmpg-double v0, v1, v9

    if-gez v0, :cond_3b

    add-double/2addr v1, v13

    goto :goto_33

    :cond_3b
    const/4 v0, 0x1

    aget v0, v8, v0

    neg-float v0, v0

    float-to-double v9, v0

    invoke-static {v9, v10}, Ljava/lang/Math;->toDegrees(D)D

    move-result-wide v3

    .local v3, beta:D
    :goto_44
    const-wide v9, -0x3f99800000000000L

    cmpg-double v0, v3, v9

    if-gez v0, :cond_4f

    add-double/2addr v3, v13

    goto :goto_44

    :cond_4f
    const/4 v0, 0x2

    aget v0, v8, v0

    float-to-double v9, v0

    invoke-static {v9, v10}, Ljava/lang/Math;->toDegrees(D)D

    move-result-wide v5

    .local v5, gamma:D
    :goto_57
    const-wide v9, -0x3fa9800000000000L

    cmpg-double v0, v5, v9

    if-gez v0, :cond_62

    add-double/2addr v5, v13

    goto :goto_57

    :cond_62
    move-object v0, p0

    invoke-direct/range {v0 .. v6}, Landroid/webkit/DeviceOrientationService;->maybeSendChange(DDD)V

    goto :goto_d
.end method

.method private getSensorManager()Landroid/hardware/SensorManager;
    .registers 3

    .prologue
    sget-boolean v0, Landroid/webkit/DeviceOrientationService;->$assertionsDisabled:Z

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

    :cond_1a
    iget-object v0, p0, Landroid/webkit/DeviceOrientationService;->mSensorManager:Landroid/hardware/SensorManager;

    if-nez v0, :cond_2b

    iget-object v0, p0, Landroid/webkit/DeviceOrientationService;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "sensor"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/hardware/SensorManager;

    iput-object v0, p0, Landroid/webkit/DeviceOrientationService;->mSensorManager:Landroid/hardware/SensorManager;

    :cond_2b
    iget-object v0, p0, Landroid/webkit/DeviceOrientationService;->mSensorManager:Landroid/hardware/SensorManager;

    return-object v0
.end method

.method private maybeSendChange(DDD)V
    .registers 11
    .parameter "alpha"
    .parameter "beta"
    .parameter "gamma"

    .prologue
    const-wide/high16 v2, 0x3ff0

    sget-boolean v0, Landroid/webkit/DeviceOrientationService;->$assertionsDisabled:Z

    if-nez v0, :cond_1c

    const-string v0, "WebViewCoreThread"

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Thread;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1c

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    :cond_1c
    iget-object v0, p0, Landroid/webkit/DeviceOrientationService;->mAlpha:Ljava/lang/Double;

    if-eqz v0, :cond_58

    iget-object v0, p0, Landroid/webkit/DeviceOrientationService;->mBeta:Ljava/lang/Double;

    if-eqz v0, :cond_58

    iget-object v0, p0, Landroid/webkit/DeviceOrientationService;->mGamma:Ljava/lang/Double;

    if-eqz v0, :cond_58

    iget-object v0, p0, Landroid/webkit/DeviceOrientationService;->mAlpha:Ljava/lang/Double;

    invoke-virtual {v0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v0

    sub-double v0, p1, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->abs(D)D

    move-result-wide v0

    cmpl-double v0, v0, v2

    if-gtz v0, :cond_58

    iget-object v0, p0, Landroid/webkit/DeviceOrientationService;->mBeta:Ljava/lang/Double;

    invoke-virtual {v0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v0

    sub-double v0, p3, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->abs(D)D

    move-result-wide v0

    cmpl-double v0, v0, v2

    if-gtz v0, :cond_58

    iget-object v0, p0, Landroid/webkit/DeviceOrientationService;->mGamma:Ljava/lang/Double;

    invoke-virtual {v0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v0

    sub-double v0, p5, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->abs(D)D

    move-result-wide v0

    cmpl-double v0, v0, v2

    if-lez v0, :cond_78

    :cond_58
    invoke-static {p1, p2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v0

    iput-object v0, p0, Landroid/webkit/DeviceOrientationService;->mAlpha:Ljava/lang/Double;

    invoke-static {p3, p4}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v0

    iput-object v0, p0, Landroid/webkit/DeviceOrientationService;->mBeta:Ljava/lang/Double;

    invoke-static {p5, p6}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v0

    iput-object v0, p0, Landroid/webkit/DeviceOrientationService;->mGamma:Ljava/lang/Double;

    iget-object v0, p0, Landroid/webkit/DeviceOrientationService;->mManager:Landroid/webkit/DeviceMotionAndOrientationManager;

    iget-object v1, p0, Landroid/webkit/DeviceOrientationService;->mAlpha:Ljava/lang/Double;

    iget-object v2, p0, Landroid/webkit/DeviceOrientationService;->mBeta:Ljava/lang/Double;

    iget-object v3, p0, Landroid/webkit/DeviceOrientationService;->mGamma:Ljava/lang/Double;

    invoke-virtual {v0, v1, v2, v3}, Landroid/webkit/DeviceMotionAndOrientationManager;->onOrientationChange(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/webkit/DeviceOrientationService;->mHaveSentErrorEvent:Z

    :cond_78
    return-void
.end method

.method private registerForAccelerometerSensor()Z
    .registers 6

    .prologue
    const/4 v2, 0x0

    invoke-direct {p0}, Landroid/webkit/DeviceOrientationService;->getSensorManager()Landroid/hardware/SensorManager;

    move-result-object v1

    const/4 v3, 0x1

    invoke-virtual {v1, v3}, Landroid/hardware/SensorManager;->getSensorList(I)Ljava/util/List;

    move-result-object v0

    .local v0, sensors:Ljava/util/List;,"Ljava/util/List<Landroid/hardware/Sensor;>;"
    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_12

    move v1, v2

    :goto_11
    return v1

    :cond_12
    invoke-direct {p0}, Landroid/webkit/DeviceOrientationService;->getSensorManager()Landroid/hardware/SensorManager;

    move-result-object v3

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/hardware/Sensor;

    iget-object v4, p0, Landroid/webkit/DeviceOrientationService;->mHandler:Landroid/os/Handler;

    invoke-virtual {v3, p0, v1, v2, v4}, Landroid/hardware/SensorManager;->registerListener(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;ILandroid/os/Handler;)Z

    move-result v1

    goto :goto_11
.end method

.method private registerForMagneticFieldSensor()Z
    .registers 6

    .prologue
    const/4 v2, 0x0

    invoke-direct {p0}, Landroid/webkit/DeviceOrientationService;->getSensorManager()Landroid/hardware/SensorManager;

    move-result-object v1

    const/4 v3, 0x2

    invoke-virtual {v1, v3}, Landroid/hardware/SensorManager;->getSensorList(I)Ljava/util/List;

    move-result-object v0

    .local v0, sensors:Ljava/util/List;,"Ljava/util/List<Landroid/hardware/Sensor;>;"
    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_12

    move v1, v2

    :goto_11
    return v1

    :cond_12
    invoke-direct {p0}, Landroid/webkit/DeviceOrientationService;->getSensorManager()Landroid/hardware/SensorManager;

    move-result-object v3

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/hardware/Sensor;

    iget-object v4, p0, Landroid/webkit/DeviceOrientationService;->mHandler:Landroid/os/Handler;

    invoke-virtual {v3, p0, v1, v2, v4}, Landroid/hardware/SensorManager;->registerListener(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;ILandroid/os/Handler;)Z

    move-result v1

    goto :goto_11
.end method

.method private registerForSensors()V
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/webkit/DeviceOrientationService;->mHandler:Landroid/os/Handler;

    if-nez v0, :cond_b

    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Landroid/webkit/DeviceOrientationService;->mHandler:Landroid/os/Handler;

    :cond_b
    invoke-direct {p0}, Landroid/webkit/DeviceOrientationService;->registerForAccelerometerSensor()Z

    move-result v0

    if-eqz v0, :cond_17

    invoke-direct {p0}, Landroid/webkit/DeviceOrientationService;->registerForMagneticFieldSensor()Z

    move-result v0

    if-nez v0, :cond_1d

    :cond_17
    invoke-direct {p0}, Landroid/webkit/DeviceOrientationService;->unregisterFromSensors()V

    invoke-direct {p0}, Landroid/webkit/DeviceOrientationService;->sendErrorEvent()V

    :cond_1d
    return-void
.end method

.method private sendErrorEvent()V
    .registers 3

    .prologue
    sget-boolean v0, Landroid/webkit/DeviceOrientationService;->$assertionsDisabled:Z

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

    :cond_1a
    iget-boolean v0, p0, Landroid/webkit/DeviceOrientationService;->mHaveSentErrorEvent:Z

    if-eqz v0, :cond_1f

    :goto_1e
    return-void

    :cond_1f
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/webkit/DeviceOrientationService;->mHaveSentErrorEvent:Z

    iget-object v0, p0, Landroid/webkit/DeviceOrientationService;->mHandler:Landroid/os/Handler;

    new-instance v1, Landroid/webkit/DeviceOrientationService$1;

    invoke-direct {v1, p0}, Landroid/webkit/DeviceOrientationService$1;-><init>(Landroid/webkit/DeviceOrientationService;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_1e
.end method

.method private unregisterFromSensors()V
    .registers 2

    .prologue
    invoke-direct {p0}, Landroid/webkit/DeviceOrientationService;->getSensorManager()Landroid/hardware/SensorManager;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/hardware/SensorManager;->unregisterListener(Landroid/hardware/SensorEventListener;)V

    return-void
.end method


# virtual methods
.method public onAccuracyChanged(Landroid/hardware/Sensor;I)V
    .registers 5
    .parameter "sensor"
    .parameter "accuracy"

    .prologue
    sget-boolean v0, Landroid/webkit/DeviceOrientationService;->$assertionsDisabled:Z

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

    :cond_1a
    return-void
.end method

.method public onSensorChanged(Landroid/hardware/SensorEvent;)V
    .registers 8
    .parameter "event"

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    sget-boolean v0, Landroid/webkit/DeviceOrientationService;->$assertionsDisabled:Z

    if-nez v0, :cond_13

    iget-object v0, p1, Landroid/hardware/SensorEvent;->values:[F

    array-length v0, v0

    if-eq v0, v5, :cond_13

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    :cond_13
    sget-boolean v0, Landroid/webkit/DeviceOrientationService;->$assertionsDisabled:Z

    if-nez v0, :cond_2d

    const-string v0, "WebViewCoreThread"

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Thread;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2d

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    :cond_2d
    iget-boolean v0, p0, Landroid/webkit/DeviceOrientationService;->mIsRunning:Z

    if-nez v0, :cond_32

    :cond_31
    :goto_31
    return-void

    :cond_32
    iget-object v0, p1, Landroid/hardware/SensorEvent;->sensor:Landroid/hardware/Sensor;

    invoke-virtual {v0}, Landroid/hardware/Sensor;->getType()I

    move-result v0

    packed-switch v0, :pswitch_data_8e

    sget-boolean v0, Landroid/webkit/DeviceOrientationService;->$assertionsDisabled:Z

    if-nez v0, :cond_31

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    :pswitch_45
    iget-object v0, p0, Landroid/webkit/DeviceOrientationService;->mGravityVector:[F

    if-nez v0, :cond_4d

    new-array v0, v5, [F

    iput-object v0, p0, Landroid/webkit/DeviceOrientationService;->mGravityVector:[F

    :cond_4d
    iget-object v0, p0, Landroid/webkit/DeviceOrientationService;->mGravityVector:[F

    iget-object v1, p1, Landroid/hardware/SensorEvent;->values:[F

    aget v1, v1, v2

    aput v1, v0, v2

    iget-object v0, p0, Landroid/webkit/DeviceOrientationService;->mGravityVector:[F

    iget-object v1, p1, Landroid/hardware/SensorEvent;->values:[F

    aget v1, v1, v3

    aput v1, v0, v3

    iget-object v0, p0, Landroid/webkit/DeviceOrientationService;->mGravityVector:[F

    iget-object v1, p1, Landroid/hardware/SensorEvent;->values:[F

    aget v1, v1, v4

    aput v1, v0, v4

    invoke-direct {p0}, Landroid/webkit/DeviceOrientationService;->getOrientationUsingGetRotationMatrix()V

    goto :goto_31

    :pswitch_69
    iget-object v0, p0, Landroid/webkit/DeviceOrientationService;->mMagneticFieldVector:[F

    if-nez v0, :cond_71

    new-array v0, v5, [F

    iput-object v0, p0, Landroid/webkit/DeviceOrientationService;->mMagneticFieldVector:[F

    :cond_71
    iget-object v0, p0, Landroid/webkit/DeviceOrientationService;->mMagneticFieldVector:[F

    iget-object v1, p1, Landroid/hardware/SensorEvent;->values:[F

    aget v1, v1, v2

    aput v1, v0, v2

    iget-object v0, p0, Landroid/webkit/DeviceOrientationService;->mMagneticFieldVector:[F

    iget-object v1, p1, Landroid/hardware/SensorEvent;->values:[F

    aget v1, v1, v3

    aput v1, v0, v3

    iget-object v0, p0, Landroid/webkit/DeviceOrientationService;->mMagneticFieldVector:[F

    iget-object v1, p1, Landroid/hardware/SensorEvent;->values:[F

    aget v1, v1, v4

    aput v1, v0, v4

    invoke-direct {p0}, Landroid/webkit/DeviceOrientationService;->getOrientationUsingGetRotationMatrix()V

    goto :goto_31

    nop

    :pswitch_data_8e
    .packed-switch 0x1
        :pswitch_45
        :pswitch_69
    .end packed-switch
.end method

.method public resume()V
    .registers 2

    .prologue
    iget-boolean v0, p0, Landroid/webkit/DeviceOrientationService;->mIsRunning:Z

    if-eqz v0, :cond_7

    invoke-direct {p0}, Landroid/webkit/DeviceOrientationService;->registerForSensors()V

    :cond_7
    return-void
.end method

.method public start()V
    .registers 2

    .prologue
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/webkit/DeviceOrientationService;->mIsRunning:Z

    invoke-direct {p0}, Landroid/webkit/DeviceOrientationService;->registerForSensors()V

    return-void
.end method

.method public stop()V
    .registers 2

    .prologue
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/webkit/DeviceOrientationService;->mIsRunning:Z

    invoke-direct {p0}, Landroid/webkit/DeviceOrientationService;->unregisterFromSensors()V

    return-void
.end method

.method public suspend()V
    .registers 2

    .prologue
    iget-boolean v0, p0, Landroid/webkit/DeviceOrientationService;->mIsRunning:Z

    if-eqz v0, :cond_7

    invoke-direct {p0}, Landroid/webkit/DeviceOrientationService;->unregisterFromSensors()V

    :cond_7
    return-void
.end method
