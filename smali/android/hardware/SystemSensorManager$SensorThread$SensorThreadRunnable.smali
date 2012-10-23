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
    .line 92
    iput-object p1, p0, Landroid/hardware/SystemSensorManager$SensorThread$SensorThreadRunnable;->this$0:Landroid/hardware/SystemSensorManager$SensorThread;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 93
    return-void
.end method

.method private open()Z
    .registers 2

    .prologue
    .line 99
    invoke-static {}, Landroid/hardware/SystemSensorManager;->sensors_create_queue()I

    move-result v0

    invoke-static {v0}, Landroid/hardware/SystemSensorManager;->access$002(I)I

    .line 100
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

    .line 105
    const/4 v9, 0x3

    new-array v8, v9, [F

    .line 106
    .local v8, values:[F
    new-array v6, v10, [I

    .line 107
    .local v6, status:[I
    new-array v7, v10, [J

    .line 108
    .local v7, timestamp:[J
    const/4 v9, -0x8

    invoke-static {v9}, Landroid/os/Process;->setThreadPriority(I)V

    .line 110
    invoke-direct {p0}, Landroid/hardware/SystemSensorManager$SensorThread$SensorThreadRunnable;->open()Z

    move-result v9

    if-nez v9, :cond_15

    .line 157
    :goto_14
    return-void

    .line 114
    :cond_15
    monitor-enter p0

    .line 116
    :try_start_16
    iget-object v9, p0, Landroid/hardware/SystemSensorManager$SensorThread$SensorThreadRunnable;->this$0:Landroid/hardware/SystemSensorManager$SensorThread;

    const/4 v10, 0x1

    iput-boolean v10, v9, Landroid/hardware/SystemSensorManager$SensorThread;->mSensorsReady:Z

    .line 117
    invoke-virtual {p0}, Ljava/lang/Object;->notify()V

    .line 118
    monitor-exit p0
    :try_end_1f
    .catchall {:try_start_16 .. :try_end_1f} :catchall_6d

    .line 122
    :goto_1f
    invoke-static {}, Landroid/hardware/SystemSensorManager;->access$000()I

    move-result v9

    invoke-static {v9, v8, v6, v7}, Landroid/hardware/SystemSensorManager;->sensors_data_poll(I[F[I[J)I

    move-result v3

    .line 124
    .local v3, sensor:I
    aget v0, v6, v12

    .line 125
    .local v0, accuracy:I
    sget-object v10, Landroid/hardware/SystemSensorManager;->sListeners:Ljava/util/ArrayList;

    monitor-enter v10

    .line 126
    if-eq v3, v11, :cond_36

    :try_start_2e
    sget-object v9, Landroid/hardware/SystemSensorManager;->sListeners:Ljava/util/ArrayList;

    invoke-virtual {v9}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v9

    if-eqz v9, :cond_70

    .line 129
    :cond_36
    if-ne v3, v11, :cond_58

    sget-object v9, Landroid/hardware/SystemSensorManager;->sListeners:Ljava/util/ArrayList;

    invoke-virtual {v9}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v9

    if-nez v9, :cond_58

    .line 131
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

    .line 134
    :cond_58
    invoke-static {}, Landroid/hardware/SystemSensorManager;->access$000()I

    move-result v9

    invoke-static {v9}, Landroid/hardware/SystemSensorManager;->sensors_destroy_queue(I)V

    .line 135
    const/4 v9, 0x0

    invoke-static {v9}, Landroid/hardware/SystemSensorManager;->access$002(I)I

    .line 136
    iget-object v9, p0, Landroid/hardware/SystemSensorManager$SensorThread$SensorThreadRunnable;->this$0:Landroid/hardware/SystemSensorManager$SensorThread;

    const/4 v11, 0x0

    iput-object v11, v9, Landroid/hardware/SystemSensorManager$SensorThread;->mThread:Ljava/lang/Thread;

    .line 137
    monitor-exit v10

    goto :goto_14

    .line 154
    :catchall_6a
    move-exception v9

    monitor-exit v10
    :try_end_6c
    .catchall {:try_start_2e .. :try_end_6c} :catchall_6a

    throw v9

    .line 118
    .end local v0           #accuracy:I
    .end local v3           #sensor:I
    :catchall_6d
    move-exception v9

    :try_start_6e
    monitor-exit p0
    :try_end_6f
    .catchall {:try_start_6e .. :try_end_6f} :catchall_6d

    throw v9

    .line 139
    .restart local v0       #accuracy:I
    .restart local v3       #sensor:I
    :cond_70
    :try_start_70
    sget-object v9, Landroid/hardware/SystemSensorManager;->sHandleToSensor:Landroid/util/SparseArray;

    invoke-virtual {v9, v3}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/hardware/Sensor;

    .line 140
    .local v4, sensorObject:Landroid/hardware/Sensor;
    if-eqz v4, :cond_97

    .line 143
    sget-object v9, Landroid/hardware/SystemSensorManager;->sListeners:Ljava/util/ArrayList;

    invoke-virtual {v9}, Ljava/util/ArrayList;->size()I

    move-result v5

    .line 144
    .local v5, size:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_81
    if-ge v1, v5, :cond_97

    .line 145
    sget-object v9, Landroid/hardware/SystemSensorManager;->sListeners:Ljava/util/ArrayList;

    invoke-virtual {v9, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/hardware/SystemSensorManager$ListenerDelegate;

    .line 146
    .local v2, listener:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    invoke-virtual {v2, v4}, Landroid/hardware/SystemSensorManager$ListenerDelegate;->hasSensor(Landroid/hardware/Sensor;)Z

    move-result v9

    if-eqz v9, :cond_94

    .line 149
    invoke-virtual {v2, v4, v8, v7, v0}, Landroid/hardware/SystemSensorManager$ListenerDelegate;->onSensorChangedLocked(Landroid/hardware/Sensor;[F[JI)V

    .line 144
    :cond_94
    add-int/lit8 v1, v1, 0x1

    goto :goto_81

    .line 154
    .end local v1           #i:I
    .end local v2           #listener:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    .end local v5           #size:I
    :cond_97
    monitor-exit v10
    :try_end_98
    .catchall {:try_start_70 .. :try_end_98} :catchall_6a

    goto :goto_1f
.end method
