.class public abstract Landroid/view/WindowOrientationListener;
.super Ljava/lang/Object;
.source "WindowOrientationListener.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/view/WindowOrientationListener$SensorEventListenerImpl;
    }
.end annotation


# static fields
#the value of this static final field might be set in the static constructor
.field private static final LOG:Z = false

.field private static final TAG:Ljava/lang/String; = "WindowOrientationListener"

.field private static final USE_GRAVITY_SENSOR:Z


# instance fields
.field mCurrentRotation:I

.field private mEnabled:Z

.field private mRate:I

.field private mSensor:Landroid/hardware/Sensor;

.field private mSensorEventListener:Landroid/view/WindowOrientationListener$SensorEventListenerImpl;

.field private mSensorManager:Landroid/hardware/SensorManager;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    .prologue
    const-string v0, "debug.orientation.log"

    const/4 v1, 0x0

    invoke-static {v0, v1}, Landroid/os/SystemProperties;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    sput-boolean v0, Landroid/view/WindowOrientationListener;->LOG:Z

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .registers 3
    .parameter "context"
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->CHANGE_CODE:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation

    .prologue
    const/4 v0, 0x3

    invoke-direct {p0, p1, v0}, Landroid/view/WindowOrientationListener;-><init>(Landroid/content/Context;I)V

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;I)V
    .registers 5
    .parameter "context"
    .parameter "rate"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, -0x1

    iput v0, p0, Landroid/view/WindowOrientationListener;->mCurrentRotation:I

    const-string/jumbo v0, "sensor"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/hardware/SensorManager;

    iput-object v0, p0, Landroid/view/WindowOrientationListener;->mSensorManager:Landroid/hardware/SensorManager;

    iput p2, p0, Landroid/view/WindowOrientationListener;->mRate:I

    iget-object v0, p0, Landroid/view/WindowOrientationListener;->mSensorManager:Landroid/hardware/SensorManager;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/hardware/SensorManager;->getDefaultSensor(I)Landroid/hardware/Sensor;

    move-result-object v0

    iput-object v0, p0, Landroid/view/WindowOrientationListener;->mSensor:Landroid/hardware/Sensor;

    iget-object v0, p0, Landroid/view/WindowOrientationListener;->mSensor:Landroid/hardware/Sensor;

    if-eqz v0, :cond_27

    new-instance v0, Landroid/view/WindowOrientationListener$SensorEventListenerImpl;

    invoke-direct {v0, p0}, Landroid/view/WindowOrientationListener$SensorEventListenerImpl;-><init>(Landroid/view/WindowOrientationListener;)V

    iput-object v0, p0, Landroid/view/WindowOrientationListener;->mSensorEventListener:Landroid/view/WindowOrientationListener$SensorEventListenerImpl;

    :cond_27
    return-void
.end method

.method static synthetic access$000()Z
    .registers 1

    .prologue
    sget-boolean v0, Landroid/view/WindowOrientationListener;->LOG:Z

    return v0
.end method


# virtual methods
.method public canDetectOrientation()Z
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/view/WindowOrientationListener;->mSensor:Landroid/hardware/Sensor;

    if-eqz v0, :cond_6

    const/4 v0, 0x1

    :goto_5
    return v0

    :cond_6
    const/4 v0, 0x0

    goto :goto_5
.end method

.method public disable()V
    .registers 3

    .prologue
    iget-object v0, p0, Landroid/view/WindowOrientationListener;->mSensor:Landroid/hardware/Sensor;

    if-nez v0, :cond_c

    const-string v0, "WindowOrientationListener"

    const-string v1, "Cannot detect sensors. Invalid disable"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    :cond_b
    :goto_b
    return-void

    :cond_c
    iget-boolean v0, p0, Landroid/view/WindowOrientationListener;->mEnabled:Z

    const/4 v1, 0x1

    if-ne v0, v1, :cond_b

    sget-boolean v0, Landroid/view/WindowOrientationListener;->LOG:Z

    if-eqz v0, :cond_1c

    const-string v0, "WindowOrientationListener"

    const-string v1, "WindowOrientationListener disabled"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_1c
    iget-object v0, p0, Landroid/view/WindowOrientationListener;->mSensorManager:Landroid/hardware/SensorManager;

    iget-object v1, p0, Landroid/view/WindowOrientationListener;->mSensorEventListener:Landroid/view/WindowOrientationListener$SensorEventListenerImpl;

    invoke-virtual {v0, v1}, Landroid/hardware/SensorManager;->unregisterListener(Landroid/hardware/SensorEventListener;)V

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/view/WindowOrientationListener;->mEnabled:Z

    goto :goto_b
.end method

.method public enable()V
    .registers 5

    .prologue
    iget-object v0, p0, Landroid/view/WindowOrientationListener;->mSensor:Landroid/hardware/Sensor;

    if-nez v0, :cond_c

    const-string v0, "WindowOrientationListener"

    const-string v1, "Cannot detect sensors. Not enabled"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    :cond_b
    :goto_b
    return-void

    :cond_c
    iget-boolean v0, p0, Landroid/view/WindowOrientationListener;->mEnabled:Z

    if-nez v0, :cond_b

    sget-boolean v0, Landroid/view/WindowOrientationListener;->LOG:Z

    if-eqz v0, :cond_1b

    const-string v0, "WindowOrientationListener"

    const-string v1, "WindowOrientationListener enabled"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_1b
    iget-object v0, p0, Landroid/view/WindowOrientationListener;->mSensorManager:Landroid/hardware/SensorManager;

    iget-object v1, p0, Landroid/view/WindowOrientationListener;->mSensorEventListener:Landroid/view/WindowOrientationListener$SensorEventListenerImpl;

    iget-object v2, p0, Landroid/view/WindowOrientationListener;->mSensor:Landroid/hardware/Sensor;

    iget v3, p0, Landroid/view/WindowOrientationListener;->mRate:I

    invoke-virtual {v0, v1, v2, v3}, Landroid/hardware/SensorManager;->registerListener(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;I)Z

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/view/WindowOrientationListener;->mEnabled:Z

    goto :goto_b
.end method

.method public getProposedRotation()I
    .registers 2

    .prologue
    iget-boolean v0, p0, Landroid/view/WindowOrientationListener;->mEnabled:Z

    if-eqz v0, :cond_b

    iget-object v0, p0, Landroid/view/WindowOrientationListener;->mSensorEventListener:Landroid/view/WindowOrientationListener$SensorEventListenerImpl;

    invoke-virtual {v0}, Landroid/view/WindowOrientationListener$SensorEventListenerImpl;->getProposedRotation()I

    move-result v0

    :goto_a
    return v0

    :cond_b
    const/4 v0, -0x1

    goto :goto_a
.end method

.method public abstract onProposedRotationChanged(I)V
.end method

.method public setCurrentRotation(I)V
    .registers 2
    .parameter "rotation"

    .prologue
    iput p1, p0, Landroid/view/WindowOrientationListener;->mCurrentRotation:I

    return-void
.end method
