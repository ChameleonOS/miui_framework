.class Landroid/hardware/SystemSensorManager$SensorThread$SensorThreadRunnable;
.super Ljava/lang/Object;
.source "SystemSensorManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/hardware/SystemSensorManager$SensorThread;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SensorThreadRunnable"
.end annotation


# instance fields
.field final synthetic this$0:Landroid/hardware/SystemSensorManager$SensorThread;


# direct methods
.method constructor <init>(Landroid/hardware/SystemSensorManager$SensorThread;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Landroid/hardware/SystemSensorManager$SensorThread$SensorThreadRunnable;->this$0:Landroid/hardware/SystemSensorManager$SensorThread;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private open()Z
    .registers 2

    .prologue
    invoke-static {}, Landroid/hardware/SystemSensorManager;->sensors_create_queue()I

    move-result v0

    invoke-static {v0}, Landroid/hardware/SystemSensorManager;->access$002(I)I

    const/4 v0, 0x1

    return v0
.end method


# virtual methods
.method public run()V
    .registers 14

    .prologue
    const/4 v12, 0x0

    const/4 v11, -0x1

    const/4 v10, 0x1

    const/4 v9, 0x3

    new-array v8, v9, [F

    .local v8, values:[F
    new-array v6, v10, [I

    .local v6, status:[I
    new-array v7, v10, [J

    .local v7, timestamp:[J
    const/4 v9, -0x8

    invoke-static {v9}, Landroid/os/Process;->setThreadPriority(I)V

    invoke-direct {p0}, Landroid/hardware/SystemSensorManager$SensorThread$SensorThreadRunnable;->open()Z

    move-result v9

    if-nez v9, :cond_15

    :goto_14
    return-void

    :cond_15
    monitor-enter p0

    :try_start_16
    iget-object v9, p0, Landroid/hardware/SystemSensorManager$SensorThread$SensorThreadRunnable;->this$0:Landroid/hardware/SystemSensorManager$SensorThread;

    const/4 v10, 0x1

    iput-boolean v10, v9, Landroid/hardware/SystemSensorManager$SensorThread;->mSensorsReady:Z

    invoke-virtual {p0}, Ljava/lang/Object;->notify()V

    monitor-exit p0
    :try_end_1f
    .catchall {:try_start_16 .. :try_end_1f} :catchall_6d

    :goto_1f
    invoke-static {}, Landroid/hardware/SystemSensorManager;->access$000()I

    move-result v9

    invoke-static {v9, v8, v6, v7}, Landroid/hardware/SystemSensorManager;->sensors_data_poll(I[F[I[J)I

    move-result v3

    .local v3, sensor:I
    aget v0, v6, v12

    .local v0, accuracy:I
    sget-object v10, Landroid/hardware/SystemSensorManager;->sListeners:Ljava/util/ArrayList;

    monitor-enter v10

    if-eq v3, v11, :cond_36

    :try_start_2e
    sget-object v9, Landroid/hardware/SystemSensorManager;->sListeners:Ljava/util/ArrayList;

    invoke-virtual {v9}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v9

    if-eqz v9, :cond_70

    :cond_36
    if-ne v3, v11, :cond_58

    sget-object v9, Landroid/hardware/SystemSensorManager;->sListeners:Ljava/util/ArrayList;

    invoke-virtual {v9}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v9

    if-nez v9, :cond_58

    const-string v9, "SensorManager"

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "_sensors_data_poll() failed, we bail out: sensors="

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v9, v11}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    :cond_58
    invoke-static {}, Landroid/hardware/SystemSensorManager;->access$000()I

    move-result v9

    invoke-static {v9}, Landroid/hardware/SystemSensorManager;->sensors_destroy_queue(I)V

    const/4 v9, 0x0

    invoke-static {v9}, Landroid/hardware/SystemSensorManager;->access$002(I)I

    iget-object v9, p0, Landroid/hardware/SystemSensorManager$SensorThread$SensorThreadRunnable;->this$0:Landroid/hardware/SystemSensorManager$SensorThread;

    const/4 v11, 0x0

    iput-object v11, v9, Landroid/hardware/SystemSensorManager$SensorThread;->mThread:Ljava/lang/Thread;

    monitor-exit v10

    goto :goto_14

    :catchall_6a
    move-exception v9

    monitor-exit v10
    :try_end_6c
    .catchall {:try_start_2e .. :try_end_6c} :catchall_6a

    throw v9

    .end local v0           #accuracy:I
    .end local v3           #sensor:I
    :catchall_6d
    move-exception v9

    :try_start_6e
    monitor-exit p0
    :try_end_6f
    .catchall {:try_start_6e .. :try_end_6f} :catchall_6d

    throw v9

    .restart local v0       #accuracy:I
    .restart local v3       #sensor:I
    :cond_70
    :try_start_70
    sget-object v9, Landroid/hardware/SystemSensorManager;->sHandleToSensor:Landroid/util/SparseArray;

    invoke-virtual {v9, v3}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/hardware/Sensor;

    .local v4, sensorObject:Landroid/hardware/Sensor;
    if-eqz v4, :cond_97

    sget-object v9, Landroid/hardware/SystemSensorManager;->sListeners:Ljava/util/ArrayList;

    invoke-virtual {v9}, Ljava/util/ArrayList;->size()I

    move-result v5

    .local v5, size:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_81
    if-ge v1, v5, :cond_97

    sget-object v9, Landroid/hardware/SystemSensorManager;->sListeners:Ljava/util/ArrayList;

    invoke-virtual {v9, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/hardware/SystemSensorManager$ListenerDelegate;

    .local v2, listener:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    invoke-virtual {v2, v4}, Landroid/hardware/SystemSensorManager$ListenerDelegate;->hasSensor(Landroid/hardware/Sensor;)Z

    move-result v9

    if-eqz v9, :cond_94

    invoke-virtual {v2, v4, v8, v7, v0}, Landroid/hardware/SystemSensorManager$ListenerDelegate;->onSensorChangedLocked(Landroid/hardware/Sensor;[F[JI)V

    :cond_94
    add-int/lit8 v1, v1, 0x1

    goto :goto_81

    .end local v1           #i:I
    .end local v2           #listener:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    .end local v5           #size:I
    :cond_97
    monitor-exit v10
    :try_end_98
    .catchall {:try_start_70 .. :try_end_98} :catchall_6a

    goto :goto_1f
.end method
