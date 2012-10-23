.class Landroid/hardware/SystemSensorManager$SensorThread;
.super Ljava/lang/Object;
.source "SystemSensorManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/hardware/SystemSensorManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SensorThread"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/hardware/SystemSensorManager$SensorThread$SensorThreadRunnable;
    }
.end annotation


# instance fields
.field mSensorsReady:Z

.field mThread:Ljava/lang/Thread;


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 64
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 65
    return-void
.end method


# virtual methods
.method protected finalize()V
    .registers 1

    .prologue
    .line 69
    return-void
.end method

.method startLocked()Z
    .registers 5

    .prologue
    const/4 v2, 0x0

    .line 74
    :try_start_1
    iget-object v3, p0, Landroid/hardware/SystemSensorManager$SensorThread;->mThread:Ljava/lang/Thread;

    if-nez v3, :cond_28

    .line 75
    const/4 v3, 0x0

    iput-boolean v3, p0, Landroid/hardware/SystemSensorManager$SensorThread;->mSensorsReady:Z

    .line 76
    new-instance v0, Landroid/hardware/SystemSensorManager$SensorThread$SensorThreadRunnable;

    invoke-direct {v0, p0}, Landroid/hardware/SystemSensorManager$SensorThread$SensorThreadRunnable;-><init>(Landroid/hardware/SystemSensorManager$SensorThread;)V

    .line 77
    .local v0, runnable:Landroid/hardware/SystemSensorManager$SensorThread$SensorThreadRunnable;
    new-instance v1, Ljava/lang/Thread;

    const-class v3, Landroid/hardware/SystemSensorManager$SensorThread;

    invoke-virtual {v3}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v0, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;Ljava/lang/String;)V

    .line 78
    .local v1, thread:Ljava/lang/Thread;
    invoke-virtual {v1}, Ljava/lang/Thread;->start()V

    .line 79
    monitor-enter v0
    :try_end_1c
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1c} :catch_27

    .line 80
    :goto_1c
    :try_start_1c
    iget-boolean v3, p0, Landroid/hardware/SystemSensorManager$SensorThread;->mSensorsReady:Z

    if-nez v3, :cond_2d

    .line 81
    invoke-virtual {v0}, Ljava/lang/Object;->wait()V

    goto :goto_1c

    .line 83
    :catchall_24
    move-exception v3

    monitor-exit v0
    :try_end_26
    .catchall {:try_start_1c .. :try_end_26} :catchall_24

    :try_start_26
    throw v3
    :try_end_27
    .catch Ljava/lang/InterruptedException; {:try_start_26 .. :try_end_27} :catch_27

    .line 86
    .end local v0           #runnable:Landroid/hardware/SystemSensorManager$SensorThread$SensorThreadRunnable;
    .end local v1           #thread:Ljava/lang/Thread;
    :catch_27
    move-exception v3

    .line 88
    :cond_28
    :goto_28
    iget-object v3, p0, Landroid/hardware/SystemSensorManager$SensorThread;->mThread:Ljava/lang/Thread;

    if-nez v3, :cond_31

    :goto_2c
    return v2

    .line 83
    .restart local v0       #runnable:Landroid/hardware/SystemSensorManager$SensorThread$SensorThreadRunnable;
    .restart local v1       #thread:Ljava/lang/Thread;
    :cond_2d
    :try_start_2d
    monitor-exit v0
    :try_end_2e
    .catchall {:try_start_2d .. :try_end_2e} :catchall_24

    .line 84
    :try_start_2e
    iput-object v1, p0, Landroid/hardware/SystemSensorManager$SensorThread;->mThread:Ljava/lang/Thread;
    :try_end_30
    .catch Ljava/lang/InterruptedException; {:try_start_2e .. :try_end_30} :catch_27

    goto :goto_28

    .line 88
    .end local v0           #runnable:Landroid/hardware/SystemSensorManager$SensorThread$SensorThreadRunnable;
    .end local v1           #thread:Ljava/lang/Thread;
    :cond_31
    const/4 v2, 0x1

    goto :goto_2c
.end method
