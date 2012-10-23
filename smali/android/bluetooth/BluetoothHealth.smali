.class public final Landroid/bluetooth/BluetoothHealth;
.super Ljava/lang/Object;
.source "BluetoothHealth.java"

# interfaces
.implements Landroid/bluetooth/BluetoothProfile;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/bluetooth/BluetoothHealth$BluetoothHealthCallbackWrapper;
    }
.end annotation


# static fields
.field public static final APP_CONFIG_REGISTRATION_FAILURE:I = 0x1

.field public static final APP_CONFIG_REGISTRATION_SUCCESS:I = 0x0

.field public static final APP_CONFIG_UNREGISTRATION_FAILURE:I = 0x3

.field public static final APP_CONFIG_UNREGISTRATION_SUCCESS:I = 0x2

.field public static final CHANNEL_TYPE_ANY:I = 0xc

.field public static final CHANNEL_TYPE_RELIABLE:I = 0xa

.field public static final CHANNEL_TYPE_STREAMING:I = 0xb

.field private static final DBG:Z = false

.field public static final HEALTH_OPERATION_ERROR:I = 0x1771

.field public static final HEALTH_OPERATION_GENERIC_FAILURE:I = 0x1773

.field public static final HEALTH_OPERATION_INVALID_ARGS:I = 0x1772

.field public static final HEALTH_OPERATION_NOT_ALLOWED:I = 0x1775

.field public static final HEALTH_OPERATION_NOT_FOUND:I = 0x1774

.field public static final HEALTH_OPERATION_SUCCESS:I = 0x1770

.field public static final SINK_ROLE:I = 0x2

.field public static final SOURCE_ROLE:I = 0x1

.field public static final STATE_CHANNEL_CONNECTED:I = 0x2

.field public static final STATE_CHANNEL_CONNECTING:I = 0x1

.field public static final STATE_CHANNEL_DISCONNECTED:I = 0x0

.field public static final STATE_CHANNEL_DISCONNECTING:I = 0x3

.field private static final TAG:Ljava/lang/String; = "BluetoothHealth"


# instance fields
.field mAdapter:Landroid/bluetooth/BluetoothAdapter;

.field private mService:Landroid/bluetooth/IBluetooth;

.field private mServiceListener:Landroid/bluetooth/BluetoothProfile$ServiceListener;


# direct methods
.method constructor <init>(Landroid/content/Context;Landroid/bluetooth/BluetoothProfile$ServiceListener;)V
    .registers 6
    .parameter "mContext"
    .parameter "l"

    .prologue
    .line 437
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 438
    const-string v1, "bluetooth"

    invoke-static {v1}, Landroid/os/ServiceManager;->getService(Ljava/lang/String;)Landroid/os/IBinder;

    move-result-object v0

    .line 439
    .local v0, b:Landroid/os/IBinder;
    iput-object p2, p0, Landroid/bluetooth/BluetoothHealth;->mServiceListener:Landroid/bluetooth/BluetoothProfile$ServiceListener;

    .line 440
    invoke-static {}, Landroid/bluetooth/BluetoothAdapter;->getDefaultAdapter()Landroid/bluetooth/BluetoothAdapter;

    move-result-object v1

    iput-object v1, p0, Landroid/bluetooth/BluetoothHealth;->mAdapter:Landroid/bluetooth/BluetoothAdapter;

    .line 441
    if-eqz v0, :cond_24

    .line 442
    invoke-static {v0}, Landroid/bluetooth/IBluetooth$Stub;->asInterface(Landroid/os/IBinder;)Landroid/bluetooth/IBluetooth;

    move-result-object v1

    iput-object v1, p0, Landroid/bluetooth/BluetoothHealth;->mService:Landroid/bluetooth/IBluetooth;

    .line 443
    iget-object v1, p0, Landroid/bluetooth/BluetoothHealth;->mServiceListener:Landroid/bluetooth/BluetoothProfile$ServiceListener;

    if-eqz v1, :cond_23

    .line 444
    iget-object v1, p0, Landroid/bluetooth/BluetoothHealth;->mServiceListener:Landroid/bluetooth/BluetoothProfile$ServiceListener;

    const/4 v2, 0x3

    invoke-interface {v1, v2, p0}, Landroid/bluetooth/BluetoothProfile$ServiceListener;->onServiceConnected(ILandroid/bluetooth/BluetoothProfile;)V

    .line 453
    :cond_23
    :goto_23
    return-void

    .line 447
    :cond_24
    const-string v1, "BluetoothHealth"

    const-string v2, "Bluetooth Service not available!"

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 451
    const/4 v1, 0x0

    iput-object v1, p0, Landroid/bluetooth/BluetoothHealth;->mService:Landroid/bluetooth/IBluetooth;

    goto :goto_23
.end method

.method private checkAppParam(Ljava/lang/String;IILandroid/bluetooth/BluetoothHealthCallback;)Z
    .registers 9
    .parameter "name"
    .parameter "role"
    .parameter "channelType"
    .parameter "callback"

    .prologue
    const/16 v3, 0xc

    const/4 v0, 0x0

    const/4 v1, 0x1

    .line 476
    if-eqz p1, :cond_17

    if-eq p2, v1, :cond_b

    const/4 v2, 0x2

    if-ne p2, v2, :cond_17

    :cond_b
    const/16 v2, 0xa

    if-eq p3, v2, :cond_15

    const/16 v2, 0xb

    if-eq p3, v2, :cond_15

    if-ne p3, v3, :cond_17

    :cond_15
    if-nez p4, :cond_18

    .line 483
    :cond_17
    :goto_17
    return v0

    .line 482
    :cond_18
    if-ne p2, v1, :cond_1c

    if-eq p3, v3, :cond_17

    :cond_1c
    move v0, v1

    .line 483
    goto :goto_17
.end method

.method private isEnabled()Z
    .registers 4

    .prologue
    .line 460
    invoke-static {}, Landroid/bluetooth/BluetoothAdapter;->getDefaultAdapter()Landroid/bluetooth/BluetoothAdapter;

    move-result-object v0

    .line 462
    .local v0, adapter:Landroid/bluetooth/BluetoothAdapter;
    if-eqz v0, :cond_10

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothAdapter;->getState()I

    move-result v1

    const/16 v2, 0xc

    if-ne v1, v2, :cond_10

    const/4 v1, 0x1

    .line 464
    :goto_f
    return v1

    .line 463
    :cond_10
    const-string v1, "Bluetooth is Not enabled"

    invoke-static {v1}, Landroid/bluetooth/BluetoothHealth;->log(Ljava/lang/String;)V

    .line 464
    const/4 v1, 0x0

    goto :goto_f
.end method

.method private isValidDevice(Landroid/bluetooth/BluetoothDevice;)Z
    .registers 4
    .parameter "device"

    .prologue
    const/4 v0, 0x0

    .line 468
    if-nez p1, :cond_4

    .line 471
    :cond_3
    :goto_3
    return v0

    .line 470
    :cond_4
    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/bluetooth/BluetoothAdapter;->checkBluetoothAddress(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    const/4 v0, 0x1

    goto :goto_3
.end method

.method private static log(Ljava/lang/String;)V
    .registers 2
    .parameter "msg"

    .prologue
    .line 487
    const-string v0, "BluetoothHealth"

    invoke-static {v0, p0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 488
    return-void
.end method


# virtual methods
.method close()V
    .registers 2

    .prologue
    .line 456
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/bluetooth/BluetoothHealth;->mServiceListener:Landroid/bluetooth/BluetoothProfile$ServiceListener;

    .line 457
    return-void
.end method

.method public connectChannelToSink(Landroid/bluetooth/BluetoothDevice;Landroid/bluetooth/BluetoothHealthAppConfiguration;I)Z
    .registers 7
    .parameter "device"
    .parameter "config"
    .parameter "channelType"

    .prologue
    .line 229
    iget-object v1, p0, Landroid/bluetooth/BluetoothHealth;->mService:Landroid/bluetooth/IBluetooth;

    if-eqz v1, :cond_25

    invoke-direct {p0}, Landroid/bluetooth/BluetoothHealth;->isEnabled()Z

    move-result v1

    if-eqz v1, :cond_25

    invoke-direct {p0, p1}, Landroid/bluetooth/BluetoothHealth;->isValidDevice(Landroid/bluetooth/BluetoothDevice;)Z

    move-result v1

    if-eqz v1, :cond_25

    if-eqz p2, :cond_25

    .line 232
    :try_start_12
    iget-object v1, p0, Landroid/bluetooth/BluetoothHealth;->mService:Landroid/bluetooth/IBluetooth;

    invoke-interface {v1, p1, p2, p3}, Landroid/bluetooth/IBluetooth;->connectChannelToSink(Landroid/bluetooth/BluetoothDevice;Landroid/bluetooth/BluetoothHealthAppConfiguration;I)Z
    :try_end_17
    .catch Landroid/os/RemoteException; {:try_start_12 .. :try_end_17} :catch_19

    move-result v1

    .line 240
    :goto_18
    return v1

    .line 233
    :catch_19
    move-exception v0

    .line 234
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "BluetoothHealth"

    invoke-virtual {v0}, Landroid/os/RemoteException;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 240
    .end local v0           #e:Landroid/os/RemoteException;
    :goto_23
    const/4 v1, 0x0

    goto :goto_18

    .line 237
    :cond_25
    const-string v1, "BluetoothHealth"

    const-string v2, "Proxy not attached to service"

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_23
.end method

.method public connectChannelToSource(Landroid/bluetooth/BluetoothDevice;Landroid/bluetooth/BluetoothHealthAppConfiguration;)Z
    .registers 6
    .parameter "device"
    .parameter "config"

    .prologue
    .line 200
    iget-object v1, p0, Landroid/bluetooth/BluetoothHealth;->mService:Landroid/bluetooth/IBluetooth;

    if-eqz v1, :cond_25

    invoke-direct {p0}, Landroid/bluetooth/BluetoothHealth;->isEnabled()Z

    move-result v1

    if-eqz v1, :cond_25

    invoke-direct {p0, p1}, Landroid/bluetooth/BluetoothHealth;->isValidDevice(Landroid/bluetooth/BluetoothDevice;)Z

    move-result v1

    if-eqz v1, :cond_25

    if-eqz p2, :cond_25

    .line 203
    :try_start_12
    iget-object v1, p0, Landroid/bluetooth/BluetoothHealth;->mService:Landroid/bluetooth/IBluetooth;

    invoke-interface {v1, p1, p2}, Landroid/bluetooth/IBluetooth;->connectChannelToSource(Landroid/bluetooth/BluetoothDevice;Landroid/bluetooth/BluetoothHealthAppConfiguration;)Z
    :try_end_17
    .catch Landroid/os/RemoteException; {:try_start_12 .. :try_end_17} :catch_19

    move-result v1

    .line 211
    :goto_18
    return v1

    .line 204
    :catch_19
    move-exception v0

    .line 205
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "BluetoothHealth"

    invoke-virtual {v0}, Landroid/os/RemoteException;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 211
    .end local v0           #e:Landroid/os/RemoteException;
    :goto_23
    const/4 v1, 0x0

    goto :goto_18

    .line 208
    :cond_25
    const-string v1, "BluetoothHealth"

    const-string v2, "Proxy not attached to service"

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_23
.end method

.method public disconnectChannel(Landroid/bluetooth/BluetoothDevice;Landroid/bluetooth/BluetoothHealthAppConfiguration;I)Z
    .registers 7
    .parameter "device"
    .parameter "config"
    .parameter "channelId"

    .prologue
    .line 258
    iget-object v1, p0, Landroid/bluetooth/BluetoothHealth;->mService:Landroid/bluetooth/IBluetooth;

    if-eqz v1, :cond_25

    invoke-direct {p0}, Landroid/bluetooth/BluetoothHealth;->isEnabled()Z

    move-result v1

    if-eqz v1, :cond_25

    invoke-direct {p0, p1}, Landroid/bluetooth/BluetoothHealth;->isValidDevice(Landroid/bluetooth/BluetoothDevice;)Z

    move-result v1

    if-eqz v1, :cond_25

    if-eqz p2, :cond_25

    .line 261
    :try_start_12
    iget-object v1, p0, Landroid/bluetooth/BluetoothHealth;->mService:Landroid/bluetooth/IBluetooth;

    invoke-interface {v1, p1, p2, p3}, Landroid/bluetooth/IBluetooth;->disconnectChannel(Landroid/bluetooth/BluetoothDevice;Landroid/bluetooth/BluetoothHealthAppConfiguration;I)Z
    :try_end_17
    .catch Landroid/os/RemoteException; {:try_start_12 .. :try_end_17} :catch_19

    move-result v1

    .line 269
    :goto_18
    return v1

    .line 262
    :catch_19
    move-exception v0

    .line 263
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "BluetoothHealth"

    invoke-virtual {v0}, Landroid/os/RemoteException;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 269
    .end local v0           #e:Landroid/os/RemoteException;
    :goto_23
    const/4 v1, 0x0

    goto :goto_18

    .line 266
    :cond_25
    const-string v1, "BluetoothHealth"

    const-string v2, "Proxy not attached to service"

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_23
.end method

.method public getConnectedDevices()Ljava/util/List;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Landroid/bluetooth/BluetoothDevice;",
            ">;"
        }
    .end annotation

    .prologue
    .line 346
    iget-object v1, p0, Landroid/bluetooth/BluetoothHealth;->mService:Landroid/bluetooth/IBluetooth;

    if-eqz v1, :cond_39

    invoke-direct {p0}, Landroid/bluetooth/BluetoothHealth;->isEnabled()Z

    move-result v1

    if-eqz v1, :cond_39

    .line 348
    :try_start_a
    iget-object v1, p0, Landroid/bluetooth/BluetoothHealth;->mService:Landroid/bluetooth/IBluetooth;

    invoke-interface {v1}, Landroid/bluetooth/IBluetooth;->getConnectedHealthDevices()Ljava/util/List;
    :try_end_f
    .catch Landroid/os/RemoteException; {:try_start_a .. :try_end_f} :catch_11

    move-result-object v1

    .line 355
    :goto_10
    return-object v1

    .line 349
    :catch_11
    move-exception v0

    .line 350
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "BluetoothHealth"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Stack:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    new-instance v3, Ljava/lang/Throwable;

    invoke-direct {v3}, Ljava/lang/Throwable;-><init>()V

    invoke-static {v3}, Landroid/util/Log;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 351
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    goto :goto_10

    .line 354
    .end local v0           #e:Landroid/os/RemoteException;
    :cond_39
    iget-object v1, p0, Landroid/bluetooth/BluetoothHealth;->mService:Landroid/bluetooth/IBluetooth;

    if-nez v1, :cond_44

    const-string v1, "BluetoothHealth"

    const-string v2, "Proxy not attached to service"

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 355
    :cond_44
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    goto :goto_10
.end method

.method public getConnectionState(Landroid/bluetooth/BluetoothDevice;)I
    .registers 5
    .parameter "device"

    .prologue
    .line 318
    iget-object v1, p0, Landroid/bluetooth/BluetoothHealth;->mService:Landroid/bluetooth/IBluetooth;

    if-eqz v1, :cond_23

    invoke-direct {p0}, Landroid/bluetooth/BluetoothHealth;->isEnabled()Z

    move-result v1

    if-eqz v1, :cond_23

    invoke-direct {p0, p1}, Landroid/bluetooth/BluetoothHealth;->isValidDevice(Landroid/bluetooth/BluetoothDevice;)Z

    move-result v1

    if-eqz v1, :cond_23

    .line 320
    :try_start_10
    iget-object v1, p0, Landroid/bluetooth/BluetoothHealth;->mService:Landroid/bluetooth/IBluetooth;

    invoke-interface {v1, p1}, Landroid/bluetooth/IBluetooth;->getHealthDeviceConnectionState(Landroid/bluetooth/BluetoothDevice;)I
    :try_end_15
    .catch Landroid/os/RemoteException; {:try_start_10 .. :try_end_15} :catch_17

    move-result v1

    .line 328
    :goto_16
    return v1

    .line 321
    :catch_17
    move-exception v0

    .line 322
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "BluetoothHealth"

    invoke-virtual {v0}, Landroid/os/RemoteException;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 328
    .end local v0           #e:Landroid/os/RemoteException;
    :goto_21
    const/4 v1, 0x0

    goto :goto_16

    .line 325
    :cond_23
    const-string v1, "BluetoothHealth"

    const-string v2, "Proxy not attached to service"

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_21
.end method

.method public getDevicesMatchingConnectionStates([I)Ljava/util/List;
    .registers 6
    .parameter "states"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([I)",
            "Ljava/util/List",
            "<",
            "Landroid/bluetooth/BluetoothDevice;",
            ">;"
        }
    .end annotation

    .prologue
    .line 378
    iget-object v1, p0, Landroid/bluetooth/BluetoothHealth;->mService:Landroid/bluetooth/IBluetooth;

    if-eqz v1, :cond_39

    invoke-direct {p0}, Landroid/bluetooth/BluetoothHealth;->isEnabled()Z

    move-result v1

    if-eqz v1, :cond_39

    .line 380
    :try_start_a
    iget-object v1, p0, Landroid/bluetooth/BluetoothHealth;->mService:Landroid/bluetooth/IBluetooth;

    invoke-interface {v1, p1}, Landroid/bluetooth/IBluetooth;->getHealthDevicesMatchingConnectionStates([I)Ljava/util/List;
    :try_end_f
    .catch Landroid/os/RemoteException; {:try_start_a .. :try_end_f} :catch_11

    move-result-object v1

    .line 387
    :goto_10
    return-object v1

    .line 381
    :catch_11
    move-exception v0

    .line 382
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "BluetoothHealth"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Stack:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    new-instance v3, Ljava/lang/Throwable;

    invoke-direct {v3}, Ljava/lang/Throwable;-><init>()V

    invoke-static {v3}, Landroid/util/Log;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 383
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    goto :goto_10

    .line 386
    .end local v0           #e:Landroid/os/RemoteException;
    :cond_39
    iget-object v1, p0, Landroid/bluetooth/BluetoothHealth;->mService:Landroid/bluetooth/IBluetooth;

    if-nez v1, :cond_44

    const-string v1, "BluetoothHealth"

    const-string v2, "Proxy not attached to service"

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 387
    :cond_44
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    goto :goto_10
.end method

.method public getMainChannelFd(Landroid/bluetooth/BluetoothDevice;Landroid/bluetooth/BluetoothHealthAppConfiguration;)Landroid/os/ParcelFileDescriptor;
    .registers 6
    .parameter "device"
    .parameter "config"

    .prologue
    .line 287
    iget-object v1, p0, Landroid/bluetooth/BluetoothHealth;->mService:Landroid/bluetooth/IBluetooth;

    if-eqz v1, :cond_25

    invoke-direct {p0}, Landroid/bluetooth/BluetoothHealth;->isEnabled()Z

    move-result v1

    if-eqz v1, :cond_25

    invoke-direct {p0, p1}, Landroid/bluetooth/BluetoothHealth;->isValidDevice(Landroid/bluetooth/BluetoothDevice;)Z

    move-result v1

    if-eqz v1, :cond_25

    if-eqz p2, :cond_25

    .line 290
    :try_start_12
    iget-object v1, p0, Landroid/bluetooth/BluetoothHealth;->mService:Landroid/bluetooth/IBluetooth;

    invoke-interface {v1, p1, p2}, Landroid/bluetooth/IBluetooth;->getMainChannelFd(Landroid/bluetooth/BluetoothDevice;Landroid/bluetooth/BluetoothHealthAppConfiguration;)Landroid/os/ParcelFileDescriptor;
    :try_end_17
    .catch Landroid/os/RemoteException; {:try_start_12 .. :try_end_17} :catch_19

    move-result-object v1

    .line 298
    :goto_18
    return-object v1

    .line 291
    :catch_19
    move-exception v0

    .line 292
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "BluetoothHealth"

    invoke-virtual {v0}, Landroid/os/RemoteException;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 298
    .end local v0           #e:Landroid/os/RemoteException;
    :goto_23
    const/4 v1, 0x0

    goto :goto_18

    .line 295
    :cond_25
    const-string v1, "BluetoothHealth"

    const-string v2, "Proxy not attached to service"

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_23
.end method

.method public registerAppConfiguration(Ljava/lang/String;IIILandroid/bluetooth/BluetoothHealthCallback;)Z
    .registers 13
    .parameter "name"
    .parameter "dataType"
    .parameter "role"
    .parameter "channelType"
    .parameter "callback"

    .prologue
    .line 140
    const/4 v2, 0x0

    .line 141
    .local v2, result:Z
    invoke-direct {p0}, Landroid/bluetooth/BluetoothHealth;->isEnabled()Z

    move-result v5

    if-eqz v5, :cond_d

    invoke-direct {p0, p1, p3, p4, p5}, Landroid/bluetooth/BluetoothHealth;->checkAppParam(Ljava/lang/String;IILandroid/bluetooth/BluetoothHealthCallback;)Z

    move-result v5

    if-nez v5, :cond_f

    :cond_d
    move v3, v2

    .line 158
    .end local v2           #result:Z
    .local v3, result:I
    :goto_e
    return v3

    .line 144
    .end local v3           #result:I
    .restart local v2       #result:Z
    :cond_f
    new-instance v4, Landroid/bluetooth/BluetoothHealth$BluetoothHealthCallbackWrapper;

    invoke-direct {v4, p5}, Landroid/bluetooth/BluetoothHealth$BluetoothHealthCallbackWrapper;-><init>(Landroid/bluetooth/BluetoothHealthCallback;)V

    .line 145
    .local v4, wrapper:Landroid/bluetooth/BluetoothHealth$BluetoothHealthCallbackWrapper;
    new-instance v0, Landroid/bluetooth/BluetoothHealthAppConfiguration;

    invoke-direct {v0, p1, p2, p3, p4}, Landroid/bluetooth/BluetoothHealthAppConfiguration;-><init>(Ljava/lang/String;III)V

    .line 148
    .local v0, config:Landroid/bluetooth/BluetoothHealthAppConfiguration;
    iget-object v5, p0, Landroid/bluetooth/BluetoothHealth;->mService:Landroid/bluetooth/IBluetooth;

    if-eqz v5, :cond_30

    .line 150
    :try_start_1d
    iget-object v5, p0, Landroid/bluetooth/BluetoothHealth;->mService:Landroid/bluetooth/IBluetooth;

    invoke-interface {v5, v0, v4}, Landroid/bluetooth/IBluetooth;->registerAppConfiguration(Landroid/bluetooth/BluetoothHealthAppConfiguration;Landroid/bluetooth/IBluetoothHealthCallback;)Z
    :try_end_22
    .catch Landroid/os/RemoteException; {:try_start_1d .. :try_end_22} :catch_25

    move-result v2

    :goto_23
    move v3, v2

    .line 158
    .restart local v3       #result:I
    goto :goto_e

    .line 151
    .end local v3           #result:I
    :catch_25
    move-exception v1

    .line 152
    .local v1, e:Landroid/os/RemoteException;
    const-string v5, "BluetoothHealth"

    invoke-virtual {v1}, Landroid/os/RemoteException;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_23

    .line 155
    .end local v1           #e:Landroid/os/RemoteException;
    :cond_30
    const-string v5, "BluetoothHealth"

    const-string v6, "Proxy not attached to service"

    invoke-static {v5, v6}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_23
.end method

.method public registerSinkAppConfiguration(Ljava/lang/String;ILandroid/bluetooth/BluetoothHealthCallback;)Z
    .registers 10
    .parameter "name"
    .parameter "dataType"
    .parameter "callback"

    .prologue
    .line 115
    invoke-direct {p0}, Landroid/bluetooth/BluetoothHealth;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_8

    if-nez p1, :cond_a

    :cond_8
    const/4 v0, 0x0

    .line 118
    :goto_9
    return v0

    :cond_a
    const/4 v3, 0x2

    const/16 v4, 0xc

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move-object v5, p3

    invoke-virtual/range {v0 .. v5}, Landroid/bluetooth/BluetoothHealth;->registerAppConfiguration(Ljava/lang/String;IIILandroid/bluetooth/BluetoothHealthCallback;)Z

    move-result v0

    goto :goto_9
.end method

.method public unregisterAppConfiguration(Landroid/bluetooth/BluetoothHealthAppConfiguration;)Z
    .registers 6
    .parameter "config"

    .prologue
    .line 171
    const/4 v1, 0x0

    .line 172
    .local v1, result:Z
    iget-object v2, p0, Landroid/bluetooth/BluetoothHealth;->mService:Landroid/bluetooth/IBluetooth;

    if-eqz v2, :cond_1f

    invoke-direct {p0}, Landroid/bluetooth/BluetoothHealth;->isEnabled()Z

    move-result v2

    if-eqz v2, :cond_1f

    if-eqz p1, :cond_1f

    .line 174
    :try_start_d
    iget-object v2, p0, Landroid/bluetooth/BluetoothHealth;->mService:Landroid/bluetooth/IBluetooth;

    invoke-interface {v2, p1}, Landroid/bluetooth/IBluetooth;->unregisterAppConfiguration(Landroid/bluetooth/BluetoothHealthAppConfiguration;)Z
    :try_end_12
    .catch Landroid/os/RemoteException; {:try_start_d .. :try_end_12} :catch_14

    move-result v1

    .line 183
    :goto_13
    return v1

    .line 175
    :catch_14
    move-exception v0

    .line 176
    .local v0, e:Landroid/os/RemoteException;
    const-string v2, "BluetoothHealth"

    invoke-virtual {v0}, Landroid/os/RemoteException;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_13

    .line 179
    .end local v0           #e:Landroid/os/RemoteException;
    :cond_1f
    const-string v2, "BluetoothHealth"

    const-string v3, "Proxy not attached to service"

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_13
.end method
