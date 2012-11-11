.class public Landroid/hardware/SystemSensorManager;
.super Landroid/hardware/SensorManager;
.source "SystemSensorManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/hardware/SystemSensorManager$ListenerDelegate;,
        Landroid/hardware/SystemSensorManager$SensorThread;
    }
.end annotation


# static fields
.field private static final SENSOR_DISABLE:I = -0x1

.field private static sFullSensorsList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/hardware/Sensor;",
            ">;"
        }
    .end annotation
.end field

.field static sHandleToSensor:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Landroid/hardware/Sensor;",
            ">;"
        }
    .end annotation
.end field

.field static final sListeners:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/hardware/SystemSensorManager$ListenerDelegate;",
            ">;"
        }
    .end annotation
.end field

.field static sPool:Landroid/hardware/SensorManager$SensorEventPool;

.field private static sQueue:I

.field private static sSensorModuleInitialized:Z

.field private static sSensorThread:Landroid/hardware/SystemSensorManager$SensorThread;


# instance fields
.field final mMainLooper:Landroid/os/Looper;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    const/4 v0, 0x0

    sput-boolean v0, Landroid/hardware/SystemSensorManager;->sSensorModuleInitialized:Z

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Landroid/hardware/SystemSensorManager;->sFullSensorsList:Ljava/util/ArrayList;

    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    sput-object v0, Landroid/hardware/SystemSensorManager;->sHandleToSensor:Landroid/util/SparseArray;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Landroid/hardware/SystemSensorManager;->sListeners:Ljava/util/ArrayList;

    return-void
.end method

.method public constructor <init>(Landroid/os/Looper;)V
    .registers 8
    .parameter "mainLooper"

    .prologue
    invoke-direct {p0}, Landroid/hardware/SensorManager;-><init>()V

    iput-object p1, p0, Landroid/hardware/SystemSensorManager;->mMainLooper:Landroid/os/Looper;

    sget-object v4, Landroid/hardware/SystemSensorManager;->sListeners:Ljava/util/ArrayList;

    monitor-enter v4

    :try_start_8
    sget-boolean v3, Landroid/hardware/SystemSensorManager;->sSensorModuleInitialized:Z

    if-nez v3, :cond_47

    const/4 v3, 0x1

    sput-boolean v3, Landroid/hardware/SystemSensorManager;->sSensorModuleInitialized:Z

    invoke-static {}, Landroid/hardware/SystemSensorManager;->nativeClassInit()V

    invoke-static {}, Landroid/hardware/SystemSensorManager;->sensors_module_init()I

    sget-object v0, Landroid/hardware/SystemSensorManager;->sFullSensorsList:Ljava/util/ArrayList;

    .local v0, fullList:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/hardware/Sensor;>;"
    const/4 v1, 0x0

    .local v1, i:I
    :cond_18
    new-instance v2, Landroid/hardware/Sensor;

    invoke-direct {v2}, Landroid/hardware/Sensor;-><init>()V

    .local v2, sensor:Landroid/hardware/Sensor;
    invoke-static {v2, v1}, Landroid/hardware/SystemSensorManager;->sensors_module_get_next_sensor(Landroid/hardware/Sensor;I)I

    move-result v1

    if-ltz v1, :cond_2f

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    sget-object v3, Landroid/hardware/SystemSensorManager;->sHandleToSensor:Landroid/util/SparseArray;

    invoke-virtual {v2}, Landroid/hardware/Sensor;->getHandle()I

    move-result v5

    invoke-virtual {v3, v5, v2}, Landroid/util/SparseArray;->append(ILjava/lang/Object;)V

    :cond_2f
    if-gtz v1, :cond_18

    new-instance v3, Landroid/hardware/SensorManager$SensorEventPool;

    sget-object v5, Landroid/hardware/SystemSensorManager;->sFullSensorsList:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v5

    mul-int/lit8 v5, v5, 0x2

    invoke-direct {v3, v5}, Landroid/hardware/SensorManager$SensorEventPool;-><init>(I)V

    sput-object v3, Landroid/hardware/SystemSensorManager;->sPool:Landroid/hardware/SensorManager$SensorEventPool;

    new-instance v3, Landroid/hardware/SystemSensorManager$SensorThread;

    invoke-direct {v3}, Landroid/hardware/SystemSensorManager$SensorThread;-><init>()V

    sput-object v3, Landroid/hardware/SystemSensorManager;->sSensorThread:Landroid/hardware/SystemSensorManager$SensorThread;

    .end local v0           #fullList:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/hardware/Sensor;>;"
    .end local v1           #i:I
    .end local v2           #sensor:Landroid/hardware/Sensor;
    :cond_47
    monitor-exit v4

    return-void

    :catchall_49
    move-exception v3

    monitor-exit v4
    :try_end_4b
    .catchall {:try_start_8 .. :try_end_4b} :catchall_49

    throw v3
.end method

.method static synthetic access$000()I
    .registers 1

    .prologue
    sget v0, Landroid/hardware/SystemSensorManager;->sQueue:I

    return v0
.end method

.method static synthetic access$002(I)I
    .registers 1
    .parameter "x0"

    .prologue
    sput p0, Landroid/hardware/SystemSensorManager;->sQueue:I

    return p0
.end method

.method private disableSensorLocked(Landroid/hardware/Sensor;)Z
    .registers 8
    .parameter "sensor"

    .prologue
    sget-object v4, Landroid/hardware/SystemSensorManager;->sListeners:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, i$:Ljava/util/Iterator;
    :cond_6
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1a

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/hardware/SystemSensorManager$ListenerDelegate;

    .local v1, i:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    invoke-virtual {v1, p1}, Landroid/hardware/SystemSensorManager$ListenerDelegate;->hasSensor(Landroid/hardware/Sensor;)Z

    move-result v4

    if-eqz v4, :cond_6

    const/4 v4, 0x1

    .end local v1           #i:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    :goto_19
    return v4

    :cond_1a
    invoke-virtual {p1}, Landroid/hardware/Sensor;->getName()Ljava/lang/String;

    move-result-object v3

    .local v3, name:Ljava/lang/String;
    invoke-virtual {p1}, Landroid/hardware/Sensor;->getHandle()I

    move-result v0

    .local v0, handle:I
    sget v4, Landroid/hardware/SystemSensorManager;->sQueue:I

    const/4 v5, -0x1

    invoke-static {v4, v3, v0, v5}, Landroid/hardware/SystemSensorManager;->sensors_enable_sensor(ILjava/lang/String;II)Z

    move-result v4

    goto :goto_19
.end method

.method private enableSensorLocked(Landroid/hardware/Sensor;I)Z
    .registers 9
    .parameter "sensor"
    .parameter "delay"

    .prologue
    const/4 v4, 0x0

    .local v4, result:Z
    sget-object v5, Landroid/hardware/SystemSensorManager;->sListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, i$:Ljava/util/Iterator;
    :cond_7
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_27

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/hardware/SystemSensorManager$ListenerDelegate;

    .local v1, i:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    invoke-virtual {v1, p1}, Landroid/hardware/SystemSensorManager$ListenerDelegate;->hasSensor(Landroid/hardware/Sensor;)Z

    move-result v5

    if-eqz v5, :cond_7

    invoke-virtual {p1}, Landroid/hardware/Sensor;->getName()Ljava/lang/String;

    move-result-object v3

    .local v3, name:Ljava/lang/String;
    invoke-virtual {p1}, Landroid/hardware/Sensor;->getHandle()I

    move-result v0

    .local v0, handle:I
    sget v5, Landroid/hardware/SystemSensorManager;->sQueue:I

    invoke-static {v5, v3, v0, p2}, Landroid/hardware/SystemSensorManager;->sensors_enable_sensor(ILjava/lang/String;II)Z

    move-result v4

    .end local v0           #handle:I
    .end local v1           #i:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    .end local v3           #name:Ljava/lang/String;
    :cond_27
    return v4
.end method

.method private static native nativeClassInit()V
.end method

.method static native sensors_create_queue()I
.end method

.method static native sensors_data_poll(I[F[I[J)I
.end method

.method static native sensors_destroy_queue(I)V
.end method

.method static native sensors_enable_sensor(ILjava/lang/String;II)Z
.end method

.method private static native sensors_module_get_next_sensor(Landroid/hardware/Sensor;I)I
.end method

.method private static native sensors_module_init()I
.end method


# virtual methods
.method protected getFullSensorList()Ljava/util/List;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Landroid/hardware/Sensor;",
            ">;"
        }
    .end annotation

    .prologue
    sget-object v0, Landroid/hardware/SystemSensorManager;->sFullSensorsList:Ljava/util/ArrayList;

    return-object v0
.end method

.method protected registerListenerImpl(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;ILandroid/os/Handler;)Z
    .registers 12
    .parameter "listener"
    .parameter "sensor"
    .parameter "delay"
    .parameter "handler"

    .prologue
    const/4 v4, 0x1

    .local v4, result:Z
    sget-object v6, Landroid/hardware/SystemSensorManager;->sListeners:Ljava/util/ArrayList;

    monitor-enter v6

    const/4 v2, 0x0

    .local v2, l:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    :try_start_5
    sget-object v5, Landroid/hardware/SystemSensorManager;->sListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, i$:Ljava/util/Iterator;
    :cond_b
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_6f

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/hardware/SystemSensorManager$ListenerDelegate;

    .local v0, i:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    invoke-virtual {v0}, Landroid/hardware/SystemSensorManager$ListenerDelegate;->getListener()Ljava/lang/Object;
    :try_end_1a
    .catchall {:try_start_5 .. :try_end_1a} :catchall_67

    move-result-object v5

    if-ne v5, p1, :cond_b

    move-object v2, v0

    move-object v3, v2

    .end local v0           #i:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    .end local v2           #l:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    .local v3, l:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    :goto_1f
    if-nez v3, :cond_52

    :try_start_21
    new-instance v2, Landroid/hardware/SystemSensorManager$ListenerDelegate;

    invoke-direct {v2, p0, p1, p2, p4}, Landroid/hardware/SystemSensorManager$ListenerDelegate;-><init>(Landroid/hardware/SystemSensorManager;Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;Landroid/os/Handler;)V
    :try_end_26
    .catchall {:try_start_21 .. :try_end_26} :catchall_6a

    .end local v3           #l:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    .restart local v2       #l:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    :try_start_26
    sget-object v5, Landroid/hardware/SystemSensorManager;->sListeners:Ljava/util/ArrayList;

    invoke-virtual {v5, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    sget-object v5, Landroid/hardware/SystemSensorManager;->sListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_50

    sget-object v5, Landroid/hardware/SystemSensorManager;->sSensorThread:Landroid/hardware/SystemSensorManager$SensorThread;

    invoke-virtual {v5}, Landroid/hardware/SystemSensorManager$SensorThread;->startLocked()Z

    move-result v5

    if-eqz v5, :cond_49

    invoke-direct {p0, p2, p3}, Landroid/hardware/SystemSensorManager;->enableSensorLocked(Landroid/hardware/Sensor;I)Z

    move-result v5

    if-nez v5, :cond_47

    sget-object v5, Landroid/hardware/SystemSensorManager;->sListeners:Ljava/util/ArrayList;

    invoke-virtual {v5, v2}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    const/4 v4, 0x0

    :cond_47
    :goto_47
    monitor-exit v6

    return v4

    :cond_49
    sget-object v5, Landroid/hardware/SystemSensorManager;->sListeners:Ljava/util/ArrayList;

    invoke-virtual {v5, v2}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z
    :try_end_4e
    .catchall {:try_start_26 .. :try_end_4e} :catchall_67

    const/4 v4, 0x0

    goto :goto_47

    :cond_50
    const/4 v4, 0x0

    goto :goto_47

    .end local v2           #l:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    .restart local v3       #l:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    :cond_52
    :try_start_52
    invoke-virtual {v3, p2}, Landroid/hardware/SystemSensorManager$ListenerDelegate;->hasSensor(Landroid/hardware/Sensor;)Z

    move-result v5

    if-nez v5, :cond_6d

    invoke-virtual {v3, p2}, Landroid/hardware/SystemSensorManager$ListenerDelegate;->addSensor(Landroid/hardware/Sensor;)V

    invoke-direct {p0, p2, p3}, Landroid/hardware/SystemSensorManager;->enableSensorLocked(Landroid/hardware/Sensor;I)Z

    move-result v5

    if-nez v5, :cond_6d

    invoke-virtual {v3, p2}, Landroid/hardware/SystemSensorManager$ListenerDelegate;->removeSensor(Landroid/hardware/Sensor;)I
    :try_end_64
    .catchall {:try_start_52 .. :try_end_64} :catchall_6a

    const/4 v4, 0x0

    move-object v2, v3

    .end local v3           #l:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    .restart local v2       #l:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    goto :goto_47

    .end local v1           #i$:Ljava/util/Iterator;
    :catchall_67
    move-exception v5

    :goto_68
    :try_start_68
    monitor-exit v6
    :try_end_69
    .catchall {:try_start_68 .. :try_end_69} :catchall_67

    throw v5

    .end local v2           #l:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    .restart local v1       #i$:Ljava/util/Iterator;
    .restart local v3       #l:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    :catchall_6a
    move-exception v5

    move-object v2, v3

    .end local v3           #l:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    .restart local v2       #l:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    goto :goto_68

    .end local v2           #l:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    .restart local v3       #l:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    :cond_6d
    move-object v2, v3

    .end local v3           #l:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    .restart local v2       #l:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    goto :goto_47

    :cond_6f
    move-object v3, v2

    .end local v2           #l:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    .restart local v3       #l:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    goto :goto_1f
.end method

.method protected unregisterListenerImpl(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;)V
    .registers 10
    .parameter "listener"
    .parameter "sensor"

    .prologue
    sget-object v6, Landroid/hardware/SystemSensorManager;->sListeners:Ljava/util/ArrayList;

    monitor-enter v6

    :try_start_3
    sget-object v5, Landroid/hardware/SystemSensorManager;->sListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v4

    .local v4, size:I
    const/4 v0, 0x0

    .local v0, i:I
    :goto_a
    if-ge v0, v4, :cond_4a

    sget-object v5, Landroid/hardware/SystemSensorManager;->sListeners:Ljava/util/ArrayList;

    invoke-virtual {v5, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/hardware/SystemSensorManager$ListenerDelegate;

    .local v2, l:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    invoke-virtual {v2}, Landroid/hardware/SystemSensorManager$ListenerDelegate;->getListener()Ljava/lang/Object;

    move-result-object v5

    if-ne v5, p1, :cond_4c

    if-nez p2, :cond_3c

    sget-object v5, Landroid/hardware/SystemSensorManager;->sListeners:Ljava/util/ArrayList;

    invoke-virtual {v5, v0}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    invoke-virtual {v2}, Landroid/hardware/SystemSensorManager$ListenerDelegate;->getSensors()Ljava/util/List;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, i$:Ljava/util/Iterator;
    :goto_29
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_4a

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/hardware/Sensor;

    .local v3, s:Landroid/hardware/Sensor;
    invoke-direct {p0, v3}, Landroid/hardware/SystemSensorManager;->disableSensorLocked(Landroid/hardware/Sensor;)Z

    goto :goto_29

    .end local v0           #i:I
    .end local v1           #i$:Ljava/util/Iterator;
    .end local v2           #l:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    .end local v3           #s:Landroid/hardware/Sensor;
    .end local v4           #size:I
    :catchall_39
    move-exception v5

    monitor-exit v6
    :try_end_3b
    .catchall {:try_start_3 .. :try_end_3b} :catchall_39

    throw v5

    .restart local v0       #i:I
    .restart local v2       #l:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    .restart local v4       #size:I
    :cond_3c
    :try_start_3c
    invoke-virtual {v2, p2}, Landroid/hardware/SystemSensorManager$ListenerDelegate;->removeSensor(Landroid/hardware/Sensor;)I

    move-result v5

    if-nez v5, :cond_4a

    sget-object v5, Landroid/hardware/SystemSensorManager;->sListeners:Ljava/util/ArrayList;

    invoke-virtual {v5, v0}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    invoke-direct {p0, p2}, Landroid/hardware/SystemSensorManager;->disableSensorLocked(Landroid/hardware/Sensor;)Z

    .end local v2           #l:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    :cond_4a
    monitor-exit v6
    :try_end_4b
    .catchall {:try_start_3c .. :try_end_4b} :catchall_39

    return-void

    .restart local v2       #l:Landroid/hardware/SystemSensorManager$ListenerDelegate;
    :cond_4c
    add-int/lit8 v0, v0, 0x1

    goto :goto_a
.end method
