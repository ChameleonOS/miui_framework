.class final Landroid/hardware/LegacySensorManager;
.super Ljava/lang/Object;
.source "LegacySensorManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/hardware/LegacySensorManager$LmsFilter;,
        Landroid/hardware/LegacySensorManager$LegacyListener;
    }
.end annotation


# static fields
.field private static sInitialized:Z

.field private static sRotation:I

.field private static sWindowManager:Landroid/view/IWindowManager;


# instance fields
.field private final mLegacyListenersMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Landroid/hardware/SensorListener;",
            "Landroid/hardware/LegacySensorManager$LegacyListener;",
            ">;"
        }
    .end annotation
.end field

.field private final mSensorManager:Landroid/hardware/SensorManager;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 36
    const/4 v0, 0x0

    sput v0, Landroid/hardware/LegacySensorManager;->sRotation:I

    return-void
.end method

.method public constructor <init>(Landroid/hardware/SensorManager;)V
    .registers 5
    .parameter "sensorManager"

    .prologue
    .line 44
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 41
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroid/hardware/LegacySensorManager;->mLegacyListenersMap:Ljava/util/HashMap;

    .line 45
    iput-object p1, p0, Landroid/hardware/LegacySensorManager;->mSensorManager:Landroid/hardware/SensorManager;

    .line 47
    const-class v1, Landroid/hardware/SensorManager;

    monitor-enter v1

    .line 48
    :try_start_f
    sget-boolean v0, Landroid/hardware/LegacySensorManager;->sInitialized:Z

    if-nez v0, :cond_31

    .line 49
    const-string/jumbo v0, "window"

    invoke-static {v0}, Landroid/os/ServiceManager;->getService(Ljava/lang/String;)Landroid/os/IBinder;

    move-result-object v0

    invoke-static {v0}, Landroid/view/IWindowManager$Stub;->asInterface(Landroid/os/IBinder;)Landroid/view/IWindowManager;

    move-result-object v0

    sput-object v0, Landroid/hardware/LegacySensorManager;->sWindowManager:Landroid/view/IWindowManager;

    .line 51
    sget-object v0, Landroid/hardware/LegacySensorManager;->sWindowManager:Landroid/view/IWindowManager;
    :try_end_22
    .catchall {:try_start_f .. :try_end_22} :catchall_33

    if-eqz v0, :cond_31

    .line 55
    :try_start_24
    sget-object v0, Landroid/hardware/LegacySensorManager;->sWindowManager:Landroid/view/IWindowManager;

    new-instance v2, Landroid/hardware/LegacySensorManager$1;

    invoke-direct {v2, p0}, Landroid/hardware/LegacySensorManager$1;-><init>(Landroid/hardware/LegacySensorManager;)V

    invoke-interface {v0, v2}, Landroid/view/IWindowManager;->watchRotation(Landroid/view/IRotationWatcher;)I

    move-result v0

    sput v0, Landroid/hardware/LegacySensorManager;->sRotation:I
    :try_end_31
    .catchall {:try_start_24 .. :try_end_31} :catchall_33
    .catch Landroid/os/RemoteException; {:try_start_24 .. :try_end_31} :catch_36

    .line 66
    :cond_31
    :goto_31
    :try_start_31
    monitor-exit v1

    .line 67
    return-void

    .line 66
    :catchall_33
    move-exception v0

    monitor-exit v1
    :try_end_35
    .catchall {:try_start_31 .. :try_end_35} :catchall_33

    throw v0

    .line 62
    :catch_36
    move-exception v0

    goto :goto_31
.end method

.method static getRotation()I
    .registers 2

    .prologue
    .line 200
    const-class v1, Landroid/hardware/SensorManager;

    monitor-enter v1

    .line 201
    :try_start_3
    sget v0, Landroid/hardware/LegacySensorManager;->sRotation:I

    monitor-exit v1

    return v0

    .line 202
    :catchall_7
    move-exception v0

    monitor-exit v1
    :try_end_9
    .catchall {:try_start_3 .. :try_end_9} :catchall_7

    throw v0
.end method

.method static onRotationChanged(I)V
    .registers 3
    .parameter "rotation"

    .prologue
    .line 194
    const-class v1, Landroid/hardware/SensorManager;

    monitor-enter v1

    .line 195
    :try_start_3
    sput p0, Landroid/hardware/LegacySensorManager;->sRotation:I

    .line 196
    monitor-exit v1

    .line 197
    return-void

    .line 196
    :catchall_7
    move-exception v0

    monitor-exit v1
    :try_end_9
    .catchall {:try_start_3 .. :try_end_9} :catchall_7

    throw v0
.end method

.method private registerLegacyListener(IILandroid/hardware/SensorListener;II)Z
    .registers 11
    .parameter "legacyType"
    .parameter "type"
    .parameter "listener"
    .parameter "sensors"
    .parameter "rate"

    .prologue
    .line 109
    const/4 v1, 0x0

    .line 111
    .local v1, result:Z
    and-int v3, p4, p1

    if-eqz v3, :cond_31

    .line 113
    iget-object v3, p0, Landroid/hardware/LegacySensorManager;->mSensorManager:Landroid/hardware/SensorManager;

    invoke-virtual {v3, p2}, Landroid/hardware/SensorManager;->getDefaultSensor(I)Landroid/hardware/Sensor;

    move-result-object v2

    .line 114
    .local v2, sensor:Landroid/hardware/Sensor;
    if-eqz v2, :cond_31

    .line 119
    iget-object v4, p0, Landroid/hardware/LegacySensorManager;->mLegacyListenersMap:Ljava/util/HashMap;

    monitor-enter v4

    .line 123
    :try_start_10
    iget-object v3, p0, Landroid/hardware/LegacySensorManager;->mLegacyListenersMap:Ljava/util/HashMap;

    invoke-virtual {v3, p3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/hardware/LegacySensorManager$LegacyListener;

    .line 124
    .local v0, legacyListener:Landroid/hardware/LegacySensorManager$LegacyListener;
    if-nez v0, :cond_24

    .line 127
    new-instance v0, Landroid/hardware/LegacySensorManager$LegacyListener;

    .end local v0           #legacyListener:Landroid/hardware/LegacySensorManager$LegacyListener;
    invoke-direct {v0, p3}, Landroid/hardware/LegacySensorManager$LegacyListener;-><init>(Landroid/hardware/SensorListener;)V

    .line 128
    .restart local v0       #legacyListener:Landroid/hardware/LegacySensorManager$LegacyListener;
    iget-object v3, p0, Landroid/hardware/LegacySensorManager;->mLegacyListenersMap:Ljava/util/HashMap;

    invoke-virtual {v3, p3, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 132
    :cond_24
    invoke-virtual {v0, p1}, Landroid/hardware/LegacySensorManager$LegacyListener;->registerSensor(I)Z

    move-result v3

    if-eqz v3, :cond_32

    .line 134
    iget-object v3, p0, Landroid/hardware/LegacySensorManager;->mSensorManager:Landroid/hardware/SensorManager;

    invoke-virtual {v3, v0, v2, p5}, Landroid/hardware/SensorManager;->registerListener(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;I)Z

    move-result v1

    .line 138
    :goto_30
    monitor-exit v4

    .line 141
    .end local v0           #legacyListener:Landroid/hardware/LegacySensorManager$LegacyListener;
    .end local v2           #sensor:Landroid/hardware/Sensor;
    :cond_31
    return v1

    .line 136
    .restart local v0       #legacyListener:Landroid/hardware/LegacySensorManager$LegacyListener;
    .restart local v2       #sensor:Landroid/hardware/Sensor;
    :cond_32
    const/4 v1, 0x1

    goto :goto_30

    .line 138
    .end local v0           #legacyListener:Landroid/hardware/LegacySensorManager$LegacyListener;
    :catchall_34
    move-exception v3

    monitor-exit v4
    :try_end_36
    .catchall {:try_start_10 .. :try_end_36} :catchall_34

    throw v3
.end method

.method private unregisterLegacyListener(IILandroid/hardware/SensorListener;I)V
    .registers 9
    .parameter "legacyType"
    .parameter "type"
    .parameter "listener"
    .parameter "sensors"

    .prologue
    .line 163
    and-int v2, p4, p1

    if-eqz v2, :cond_30

    .line 165
    iget-object v2, p0, Landroid/hardware/LegacySensorManager;->mSensorManager:Landroid/hardware/SensorManager;

    invoke-virtual {v2, p2}, Landroid/hardware/SensorManager;->getDefaultSensor(I)Landroid/hardware/Sensor;

    move-result-object v1

    .line 166
    .local v1, sensor:Landroid/hardware/Sensor;
    if-eqz v1, :cond_30

    .line 171
    iget-object v3, p0, Landroid/hardware/LegacySensorManager;->mLegacyListenersMap:Ljava/util/HashMap;

    monitor-enter v3

    .line 173
    :try_start_f
    iget-object v2, p0, Landroid/hardware/LegacySensorManager;->mLegacyListenersMap:Ljava/util/HashMap;

    invoke-virtual {v2, p3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/hardware/LegacySensorManager$LegacyListener;

    .line 174
    .local v0, legacyListener:Landroid/hardware/LegacySensorManager$LegacyListener;
    if-eqz v0, :cond_2f

    .line 177
    invoke-virtual {v0, p1}, Landroid/hardware/LegacySensorManager$LegacyListener;->unregisterSensor(I)Z

    move-result v2

    if-eqz v2, :cond_2f

    .line 179
    iget-object v2, p0, Landroid/hardware/LegacySensorManager;->mSensorManager:Landroid/hardware/SensorManager;

    invoke-virtual {v2, v0, v1}, Landroid/hardware/SensorManager;->unregisterListener(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;)V

    .line 183
    invoke-virtual {v0}, Landroid/hardware/LegacySensorManager$LegacyListener;->hasSensors()Z

    move-result v2

    if-nez v2, :cond_2f

    .line 184
    iget-object v2, p0, Landroid/hardware/LegacySensorManager;->mLegacyListenersMap:Ljava/util/HashMap;

    invoke-virtual {v2, p3}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 188
    :cond_2f
    monitor-exit v3

    .line 191
    .end local v0           #legacyListener:Landroid/hardware/LegacySensorManager$LegacyListener;
    .end local v1           #sensor:Landroid/hardware/Sensor;
    :cond_30
    return-void

    .line 188
    .restart local v1       #sensor:Landroid/hardware/Sensor;
    :catchall_31
    move-exception v2

    monitor-exit v3
    :try_end_33
    .catchall {:try_start_f .. :try_end_33} :catchall_31

    throw v2
.end method


# virtual methods
.method public getSensors()I
    .registers 6

    .prologue
    .line 70
    const/4 v3, 0x0

    .line 71
    .local v3, result:I
    iget-object v4, p0, Landroid/hardware/LegacySensorManager;->mSensorManager:Landroid/hardware/SensorManager;

    invoke-virtual {v4}, Landroid/hardware/SensorManager;->getFullSensorList()Ljava/util/List;

    move-result-object v0

    .line 72
    .local v0, fullList:Ljava/util/List;,"Ljava/util/List<Landroid/hardware/Sensor;>;"
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, i$:Ljava/util/Iterator;
    :goto_b
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_28

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/hardware/Sensor;

    .line 73
    .local v1, i:Landroid/hardware/Sensor;
    invoke-virtual {v1}, Landroid/hardware/Sensor;->getType()I

    move-result v4

    packed-switch v4, :pswitch_data_2a

    goto :goto_b

    .line 75
    :pswitch_1f
    or-int/lit8 v3, v3, 0x2

    .line 76
    goto :goto_b

    .line 78
    :pswitch_22
    or-int/lit8 v3, v3, 0x8

    .line 79
    goto :goto_b

    .line 81
    :pswitch_25
    or-int/lit16 v3, v3, 0x81

    goto :goto_b

    .line 86
    .end local v1           #i:Landroid/hardware/Sensor;
    :cond_28
    return v3

    .line 73
    nop

    :pswitch_data_2a
    .packed-switch 0x1
        :pswitch_1f
        :pswitch_22
        :pswitch_25
    .end packed-switch
.end method

.method public registerListener(Landroid/hardware/SensorListener;II)Z
    .registers 16
    .parameter "listener"
    .parameter "sensors"
    .parameter "rate"

    .prologue
    const/4 v11, 0x3

    const/4 v1, 0x2

    const/4 v10, 0x0

    const/4 v2, 0x1

    .line 90
    if-nez p1, :cond_7

    .line 104
    :goto_6
    return v10

    .line 93
    :cond_7
    const/4 v9, 0x0

    .local v9, result:Z
    move-object v0, p0

    move-object v3, p1

    move v4, p2

    move v5, p3

    .line 94
    invoke-direct/range {v0 .. v5}, Landroid/hardware/LegacySensorManager;->registerLegacyListener(IILandroid/hardware/SensorListener;II)Z

    move-result v0

    if-nez v0, :cond_14

    if-eqz v9, :cond_54

    :cond_14
    move v9, v2

    .line 96
    :goto_15
    const/16 v4, 0x8

    move-object v3, p0

    move v5, v1

    move-object v6, p1

    move v7, p2

    move v8, p3

    invoke-direct/range {v3 .. v8}, Landroid/hardware/LegacySensorManager;->registerLegacyListener(IILandroid/hardware/SensorListener;II)Z

    move-result v0

    if-nez v0, :cond_24

    if-eqz v9, :cond_56

    :cond_24
    move v9, v2

    .line 98
    :goto_25
    const/16 v4, 0x80

    move-object v3, p0

    move v5, v11

    move-object v6, p1

    move v7, p2

    move v8, p3

    invoke-direct/range {v3 .. v8}, Landroid/hardware/LegacySensorManager;->registerLegacyListener(IILandroid/hardware/SensorListener;II)Z

    move-result v0

    if-nez v0, :cond_34

    if-eqz v9, :cond_58

    :cond_34
    move v9, v2

    :goto_35
    move-object v1, p0

    move v3, v11

    move-object v4, p1

    move v5, p2

    move v6, p3

    .line 100
    invoke-direct/range {v1 .. v6}, Landroid/hardware/LegacySensorManager;->registerLegacyListener(IILandroid/hardware/SensorListener;II)Z

    move-result v0

    if-nez v0, :cond_42

    if-eqz v9, :cond_5a

    :cond_42
    move v9, v2

    .line 102
    :goto_43
    const/4 v4, 0x4

    const/4 v5, 0x7

    move-object v3, p0

    move-object v6, p1

    move v7, p2

    move v8, p3

    invoke-direct/range {v3 .. v8}, Landroid/hardware/LegacySensorManager;->registerLegacyListener(IILandroid/hardware/SensorListener;II)Z

    move-result v0

    if-nez v0, :cond_51

    if-eqz v9, :cond_5c

    :cond_51
    move v9, v2

    :goto_52
    move v10, v9

    .line 104
    goto :goto_6

    :cond_54
    move v9, v10

    .line 94
    goto :goto_15

    :cond_56
    move v9, v10

    .line 96
    goto :goto_25

    :cond_58
    move v9, v10

    .line 98
    goto :goto_35

    :cond_5a
    move v9, v10

    .line 100
    goto :goto_43

    :cond_5c
    move v9, v10

    .line 102
    goto :goto_52
.end method

.method public unregisterListener(Landroid/hardware/SensorListener;I)V
    .registers 7
    .parameter "listener"
    .parameter "sensors"

    .prologue
    const/4 v3, 0x3

    const/4 v2, 0x2

    const/4 v1, 0x1

    .line 145
    if-nez p1, :cond_6

    .line 158
    :goto_5
    return-void

    .line 148
    :cond_6
    invoke-direct {p0, v2, v1, p1, p2}, Landroid/hardware/LegacySensorManager;->unregisterLegacyListener(IILandroid/hardware/SensorListener;I)V

    .line 150
    const/16 v0, 0x8

    invoke-direct {p0, v0, v2, p1, p2}, Landroid/hardware/LegacySensorManager;->unregisterLegacyListener(IILandroid/hardware/SensorListener;I)V

    .line 152
    const/16 v0, 0x80

    invoke-direct {p0, v0, v3, p1, p2}, Landroid/hardware/LegacySensorManager;->unregisterLegacyListener(IILandroid/hardware/SensorListener;I)V

    .line 154
    invoke-direct {p0, v1, v3, p1, p2}, Landroid/hardware/LegacySensorManager;->unregisterLegacyListener(IILandroid/hardware/SensorListener;I)V

    .line 156
    const/4 v0, 0x4

    const/4 v1, 0x7

    invoke-direct {p0, v0, v1, p1, p2}, Landroid/hardware/LegacySensorManager;->unregisterLegacyListener(IILandroid/hardware/SensorListener;I)V

    goto :goto_5
.end method
