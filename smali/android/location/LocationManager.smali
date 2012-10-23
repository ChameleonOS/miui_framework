.class public Landroid/location/LocationManager;
.super Ljava/lang/Object;
.source "LocationManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/location/LocationManager$GpsStatusListenerTransport;,
        Landroid/location/LocationManager$ListenerTransport;
    }
.end annotation


# static fields
.field public static final EXTRA_GPS_ENABLED:Ljava/lang/String; = "enabled"

.field public static final GPS_ENABLED_CHANGE_ACTION:Ljava/lang/String; = "android.location.GPS_ENABLED_CHANGE"

.field public static final GPS_FIX_CHANGE_ACTION:Ljava/lang/String; = "android.location.GPS_FIX_CHANGE"

.field public static final GPS_PROVIDER:Ljava/lang/String; = "gps"

.field public static final KEY_LOCATION_CHANGED:Ljava/lang/String; = "location"

.field public static final KEY_PROVIDER_ENABLED:Ljava/lang/String; = "providerEnabled"

.field public static final KEY_PROXIMITY_ENTERING:Ljava/lang/String; = "entering"

.field public static final KEY_STATUS_CHANGED:Ljava/lang/String; = "status"

.field public static final NETWORK_PROVIDER:Ljava/lang/String; = "network"

.field public static final PASSIVE_PROVIDER:Ljava/lang/String; = "passive"

.field public static final PROVIDERS_CHANGED_ACTION:Ljava/lang/String; = "android.location.PROVIDERS_CHANGED"

.field private static final TAG:Ljava/lang/String; = "LocationManager"


# instance fields
.field private final mGpsStatus:Landroid/location/GpsStatus;

.field private final mGpsStatusListeners:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Landroid/location/GpsStatus$Listener;",
            "Landroid/location/LocationManager$GpsStatusListenerTransport;",
            ">;"
        }
    .end annotation
.end field

.field private mListeners:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Landroid/location/LocationListener;",
            "Landroid/location/LocationManager$ListenerTransport;",
            ">;"
        }
    .end annotation
.end field

.field private final mNmeaListeners:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Landroid/location/GpsStatus$NmeaListener;",
            "Landroid/location/LocationManager$GpsStatusListenerTransport;",
            ">;"
        }
    .end annotation
.end field

.field private mService:Landroid/location/ILocationManager;


# direct methods
.method public constructor <init>(Landroid/location/ILocationManager;)V
    .registers 3
    .parameter "service"

    .prologue
    .line 263
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 56
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroid/location/LocationManager;->mGpsStatusListeners:Ljava/util/HashMap;

    .line 58
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroid/location/LocationManager;->mNmeaListeners:Ljava/util/HashMap;

    .line 60
    new-instance v0, Landroid/location/GpsStatus;

    invoke-direct {v0}, Landroid/location/GpsStatus;-><init>()V

    iput-object v0, p0, Landroid/location/LocationManager;->mGpsStatus:Landroid/location/GpsStatus;

    .line 164
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroid/location/LocationManager;->mListeners:Ljava/util/HashMap;

    .line 264
    iput-object p1, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    .line 265
    return-void
.end method

.method private _requestLocationUpdates(Ljava/lang/String;Landroid/location/Criteria;JFZLandroid/app/PendingIntent;)V
    .registers 17
    .parameter "provider"
    .parameter "criteria"
    .parameter "minTime"
    .parameter "minDistance"
    .parameter "singleShot"
    .parameter "intent"

    .prologue
    .line 832
    const-wide/16 v0, 0x0

    cmp-long v0, p3, v0

    if-gez v0, :cond_8

    .line 833
    const-wide/16 p3, 0x0

    .line 835
    :cond_8
    const/4 v0, 0x0

    cmpg-float v0, p5, v0

    if-gez v0, :cond_e

    .line 836
    const/4 p5, 0x0

    .line 840
    :cond_e
    :try_start_e
    iget-object v0, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    move-object v1, p1

    move-object v2, p2

    move-wide v3, p3

    move v5, p5

    move v6, p6

    move-object/from16 v7, p7

    invoke-interface/range {v0 .. v7}, Landroid/location/ILocationManager;->requestLocationUpdatesPI(Ljava/lang/String;Landroid/location/Criteria;JFZLandroid/app/PendingIntent;)V
    :try_end_1a
    .catch Landroid/os/RemoteException; {:try_start_e .. :try_end_1a} :catch_1b

    .line 844
    :goto_1a
    return-void

    .line 841
    :catch_1b
    move-exception v8

    .line 842
    .local v8, ex:Landroid/os/RemoteException;
    const-string v0, "LocationManager"

    const-string/jumbo v1, "requestLocationUpdates: RemoteException"

    invoke-static {v0, v1, v8}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1a
.end method

.method private _requestLocationUpdates(Ljava/lang/String;Landroid/location/Criteria;JFZLandroid/location/LocationListener;Landroid/os/Looper;)V
    .registers 21
    .parameter "provider"
    .parameter "criteria"
    .parameter "minTime"
    .parameter "minDistance"
    .parameter "singleShot"
    .parameter "listener"
    .parameter "looper"

    .prologue
    .line 646
    const-wide/16 v2, 0x0

    cmp-long v2, p3, v2

    if-gez v2, :cond_8

    .line 647
    const-wide/16 p3, 0x0

    .line 649
    :cond_8
    const/4 v2, 0x0

    cmpg-float v2, p5, v2

    if-gez v2, :cond_f

    .line 650
    const/16 p5, 0x0

    .line 654
    :cond_f
    :try_start_f
    iget-object v11, p0, Landroid/location/LocationManager;->mListeners:Ljava/util/HashMap;

    monitor-enter v11
    :try_end_12
    .catch Landroid/os/RemoteException; {:try_start_f .. :try_end_12} :catch_3f

    .line 655
    :try_start_12
    iget-object v2, p0, Landroid/location/LocationManager;->mListeners:Ljava/util/HashMap;

    move-object/from16 v0, p7

    invoke-virtual {v2, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/location/LocationManager$ListenerTransport;

    .line 656
    .local v9, transport:Landroid/location/LocationManager$ListenerTransport;
    if-nez v9, :cond_27

    .line 657
    new-instance v9, Landroid/location/LocationManager$ListenerTransport;

    .end local v9           #transport:Landroid/location/LocationManager$ListenerTransport;
    move-object/from16 v0, p7

    move-object/from16 v1, p8

    invoke-direct {v9, p0, v0, v1}, Landroid/location/LocationManager$ListenerTransport;-><init>(Landroid/location/LocationManager;Landroid/location/LocationListener;Landroid/os/Looper;)V

    .line 659
    .restart local v9       #transport:Landroid/location/LocationManager$ListenerTransport;
    :cond_27
    iget-object v2, p0, Landroid/location/LocationManager;->mListeners:Ljava/util/HashMap;

    move-object/from16 v0, p7

    invoke-virtual {v2, v0, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 660
    iget-object v2, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    move-object v3, p1

    move-object v4, p2

    move-wide v5, p3

    move/from16 v7, p5

    move/from16 v8, p6

    invoke-interface/range {v2 .. v9}, Landroid/location/ILocationManager;->requestLocationUpdates(Ljava/lang/String;Landroid/location/Criteria;JFZLandroid/location/ILocationListener;)V

    .line 661
    monitor-exit v11

    .line 665
    .end local v9           #transport:Landroid/location/LocationManager$ListenerTransport;
    :goto_3b
    return-void

    .line 661
    :catchall_3c
    move-exception v2

    monitor-exit v11
    :try_end_3e
    .catchall {:try_start_12 .. :try_end_3e} :catchall_3c

    :try_start_3e
    throw v2
    :try_end_3f
    .catch Landroid/os/RemoteException; {:try_start_3e .. :try_end_3f} :catch_3f

    .line 662
    :catch_3f
    move-exception v10

    .line 663
    .local v10, ex:Landroid/os/RemoteException;
    const-string v2, "LocationManager"

    const-string/jumbo v3, "requestLocationUpdates: DeadObjectException"

    invoke-static {v2, v3, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_3b
.end method

.method static synthetic access$100(Landroid/location/LocationManager;)Landroid/location/ILocationManager;
    .registers 2
    .parameter "x0"

    .prologue
    .line 53
    iget-object v0, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    return-object v0
.end method

.method static synthetic access$200(Landroid/location/LocationManager;)Landroid/location/GpsStatus;
    .registers 2
    .parameter "x0"

    .prologue
    .line 53
    iget-object v0, p0, Landroid/location/LocationManager;->mGpsStatus:Landroid/location/GpsStatus;

    return-object v0
.end method

.method private createProvider(Ljava/lang/String;Landroid/os/Bundle;)Landroid/location/LocationProvider;
    .registers 5
    .parameter "name"
    .parameter "info"

    .prologue
    .line 268
    new-instance v0, Lcom/android/internal/location/DummyLocationProvider;

    iget-object v1, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-direct {v0, p1, v1}, Lcom/android/internal/location/DummyLocationProvider;-><init>(Ljava/lang/String;Landroid/location/ILocationManager;)V

    .line 270
    .local v0, provider:Lcom/android/internal/location/DummyLocationProvider;
    const-string/jumbo v1, "network"

    invoke-virtual {p2, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/android/internal/location/DummyLocationProvider;->setRequiresNetwork(Z)V

    .line 271
    const-string/jumbo v1, "satellite"

    invoke-virtual {p2, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/android/internal/location/DummyLocationProvider;->setRequiresSatellite(Z)V

    .line 272
    const-string v1, "cell"

    invoke-virtual {p2, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/android/internal/location/DummyLocationProvider;->setRequiresCell(Z)V

    .line 273
    const-string v1, "cost"

    invoke-virtual {p2, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/android/internal/location/DummyLocationProvider;->setHasMonetaryCost(Z)V

    .line 274
    const-string v1, "altitude"

    invoke-virtual {p2, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/android/internal/location/DummyLocationProvider;->setSupportsAltitude(Z)V

    .line 275
    const-string/jumbo v1, "speed"

    invoke-virtual {p2, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/android/internal/location/DummyLocationProvider;->setSupportsSpeed(Z)V

    .line 276
    const-string v1, "bearing"

    invoke-virtual {p2, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/android/internal/location/DummyLocationProvider;->setSupportsBearing(Z)V

    .line 277
    const-string/jumbo v1, "power"

    invoke-virtual {p2, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/android/internal/location/DummyLocationProvider;->setPowerRequirement(I)V

    .line 278
    const-string v1, "accuracy"

    invoke-virtual {p2, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/android/internal/location/DummyLocationProvider;->setAccuracy(I)V

    .line 279
    return-object v0
.end method


# virtual methods
.method public addGpsStatusListener(Landroid/location/GpsStatus$Listener;)Z
    .registers 7
    .parameter "listener"

    .prologue
    .line 1451
    iget-object v3, p0, Landroid/location/LocationManager;->mGpsStatusListeners:Ljava/util/HashMap;

    invoke-virtual {v3, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    if-eqz v3, :cond_a

    .line 1453
    const/4 v1, 0x1

    .line 1466
    :cond_9
    :goto_9
    return v1

    .line 1456
    :cond_a
    :try_start_a
    new-instance v2, Landroid/location/LocationManager$GpsStatusListenerTransport;

    invoke-direct {v2, p0, p1}, Landroid/location/LocationManager$GpsStatusListenerTransport;-><init>(Landroid/location/LocationManager;Landroid/location/GpsStatus$Listener;)V

    .line 1457
    .local v2, transport:Landroid/location/LocationManager$GpsStatusListenerTransport;
    iget-object v3, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v3, v2}, Landroid/location/ILocationManager;->addGpsStatusListener(Landroid/location/IGpsStatusListener;)Z

    move-result v1

    .line 1458
    .local v1, result:Z
    if-eqz v1, :cond_9

    .line 1459
    iget-object v3, p0, Landroid/location/LocationManager;->mGpsStatusListeners:Ljava/util/HashMap;

    invoke-virtual {v3, p1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1c
    .catch Landroid/os/RemoteException; {:try_start_a .. :try_end_1c} :catch_1d

    goto :goto_9

    .line 1461
    .end local v1           #result:Z
    .end local v2           #transport:Landroid/location/LocationManager$GpsStatusListenerTransport;
    :catch_1d
    move-exception v0

    .line 1462
    .local v0, e:Landroid/os/RemoteException;
    const-string v3, "LocationManager"

    const-string v4, "RemoteException in registerGpsStatusListener: "

    invoke-static {v3, v4, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 1463
    const/4 v1, 0x0

    .restart local v1       #result:Z
    goto :goto_9
.end method

.method public addNmeaListener(Landroid/location/GpsStatus$NmeaListener;)Z
    .registers 7
    .parameter "listener"

    .prologue
    .line 1497
    iget-object v3, p0, Landroid/location/LocationManager;->mNmeaListeners:Ljava/util/HashMap;

    invoke-virtual {v3, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    if-eqz v3, :cond_a

    .line 1499
    const/4 v1, 0x1

    .line 1512
    :cond_9
    :goto_9
    return v1

    .line 1502
    :cond_a
    :try_start_a
    new-instance v2, Landroid/location/LocationManager$GpsStatusListenerTransport;

    invoke-direct {v2, p0, p1}, Landroid/location/LocationManager$GpsStatusListenerTransport;-><init>(Landroid/location/LocationManager;Landroid/location/GpsStatus$NmeaListener;)V

    .line 1503
    .local v2, transport:Landroid/location/LocationManager$GpsStatusListenerTransport;
    iget-object v3, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v3, v2}, Landroid/location/ILocationManager;->addGpsStatusListener(Landroid/location/IGpsStatusListener;)Z

    move-result v1

    .line 1504
    .local v1, result:Z
    if-eqz v1, :cond_9

    .line 1505
    iget-object v3, p0, Landroid/location/LocationManager;->mNmeaListeners:Ljava/util/HashMap;

    invoke-virtual {v3, p1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1c
    .catch Landroid/os/RemoteException; {:try_start_a .. :try_end_1c} :catch_1d

    goto :goto_9

    .line 1507
    .end local v1           #result:Z
    .end local v2           #transport:Landroid/location/LocationManager$GpsStatusListenerTransport;
    :catch_1d
    move-exception v0

    .line 1508
    .local v0, e:Landroid/os/RemoteException;
    const-string v3, "LocationManager"

    const-string v4, "RemoteException in registerGpsStatusListener: "

    invoke-static {v3, v4, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 1509
    const/4 v1, 0x0

    .restart local v1       #result:Z
    goto :goto_9
.end method

.method public addProximityAlert(DDFJLandroid/app/PendingIntent;)V
    .registers 19
    .parameter "latitude"
    .parameter "longitude"
    .parameter "radius"
    .parameter "expiration"
    .parameter "intent"

    .prologue
    .line 1089
    :try_start_0
    iget-object v0, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    move-wide v1, p1

    move-wide v3, p3

    move v5, p5

    move-wide/from16 v6, p6

    move-object/from16 v8, p8

    invoke-interface/range {v0 .. v8}, Landroid/location/ILocationManager;->addProximityAlert(DDFJLandroid/app/PendingIntent;)V
    :try_end_c
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_c} :catch_d

    .line 1094
    :goto_c
    return-void

    .line 1091
    :catch_d
    move-exception v9

    .line 1092
    .local v9, ex:Landroid/os/RemoteException;
    const-string v0, "LocationManager"

    const-string v1, "addProximityAlert: RemoteException"

    invoke-static {v0, v1, v9}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_c
.end method

.method public addTestProvider(Ljava/lang/String;ZZZZZZZII)V
    .registers 23
    .parameter "name"
    .parameter "requiresNetwork"
    .parameter "requiresSatellite"
    .parameter "requiresCell"
    .parameter "hasMonetaryCost"
    .parameter "supportsAltitude"
    .parameter "supportsSpeed"
    .parameter "supportsBearing"
    .parameter "powerRequirement"
    .parameter "accuracy"

    .prologue
    .line 1188
    :try_start_0
    iget-object v0, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    move-object v1, p1

    move v2, p2

    move v3, p3

    move/from16 v4, p4

    move/from16 v5, p5

    move/from16 v6, p6

    move/from16 v7, p7

    move/from16 v8, p8

    move/from16 v9, p9

    move/from16 v10, p10

    invoke-interface/range {v0 .. v10}, Landroid/location/ILocationManager;->addTestProvider(Ljava/lang/String;ZZZZZZZII)V
    :try_end_16
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_16} :catch_17

    .line 1194
    :goto_16
    return-void

    .line 1191
    :catch_17
    move-exception v11

    .line 1192
    .local v11, ex:Landroid/os/RemoteException;
    const-string v0, "LocationManager"

    const-string v1, "addTestProvider: RemoteException"

    invoke-static {v0, v1, v11}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_16
.end method

.method public clearTestProviderEnabled(Ljava/lang/String;)V
    .registers 5
    .parameter "provider"

    .prologue
    .line 1284
    :try_start_0
    iget-object v1, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v1, p1}, Landroid/location/ILocationManager;->clearTestProviderEnabled(Ljava/lang/String;)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    .line 1289
    :goto_5
    return-void

    .line 1285
    :catch_6
    move-exception v0

    .line 1286
    .local v0, ex:Landroid/os/RemoteException;
    const-string v1, "LocationManager"

    const-string v2, "clearTestProviderEnabled: RemoteException"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_5
.end method

.method public clearTestProviderLocation(Ljava/lang/String;)V
    .registers 5
    .parameter "provider"

    .prologue
    .line 1246
    :try_start_0
    iget-object v1, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v1, p1}, Landroid/location/ILocationManager;->clearTestProviderLocation(Ljava/lang/String;)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    .line 1250
    :goto_5
    return-void

    .line 1247
    :catch_6
    move-exception v0

    .line 1248
    .local v0, ex:Landroid/os/RemoteException;
    const-string v1, "LocationManager"

    const-string v2, "clearTestProviderLocation: RemoteException"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_5
.end method

.method public clearTestProviderStatus(Ljava/lang/String;)V
    .registers 5
    .parameter "provider"

    .prologue
    .line 1325
    :try_start_0
    iget-object v1, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v1, p1}, Landroid/location/ILocationManager;->clearTestProviderStatus(Ljava/lang/String;)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    .line 1329
    :goto_5
    return-void

    .line 1326
    :catch_6
    move-exception v0

    .line 1327
    .local v0, ex:Landroid/os/RemoteException;
    const-string v1, "LocationManager"

    const-string v2, "clearTestProviderStatus: RemoteException"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_5
.end method

.method public getAllProviders()Ljava/util/List;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 294
    :try_start_0
    iget-object v1, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v1}, Landroid/location/ILocationManager;->getAllProviders()Ljava/util/List;
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_7

    move-result-object v1

    .line 298
    :goto_6
    return-object v1

    .line 295
    :catch_7
    move-exception v0

    .line 296
    .local v0, ex:Landroid/os/RemoteException;
    const-string v1, "LocationManager"

    const-string v2, "getAllProviders: RemoteException"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 298
    const/4 v1, 0x0

    goto :goto_6
.end method

.method public getBestProvider(Landroid/location/Criteria;Z)Ljava/lang/String;
    .registers 6
    .parameter "criteria"
    .parameter "enabledOnly"

    .prologue
    .line 390
    if-nez p1, :cond_a

    .line 391
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "criteria==null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 394
    :cond_a
    :try_start_a
    iget-object v1, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v1, p1, p2}, Landroid/location/ILocationManager;->getBestProvider(Landroid/location/Criteria;Z)Ljava/lang/String;
    :try_end_f
    .catch Landroid/os/RemoteException; {:try_start_a .. :try_end_f} :catch_11

    move-result-object v1

    .line 398
    :goto_10
    return-object v1

    .line 395
    :catch_11
    move-exception v0

    .line 396
    .local v0, ex:Landroid/os/RemoteException;
    const-string v1, "LocationManager"

    const-string v2, "getBestProvider: RemoteException"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 398
    const/4 v1, 0x0

    goto :goto_10
.end method

.method public getGpsStatus(Landroid/location/GpsStatus;)Landroid/location/GpsStatus;
    .registers 3
    .parameter "status"

    .prologue
    .line 1543
    if-nez p1, :cond_7

    .line 1544
    new-instance p1, Landroid/location/GpsStatus;

    .end local p1
    invoke-direct {p1}, Landroid/location/GpsStatus;-><init>()V

    .line 1546
    .restart local p1
    :cond_7
    iget-object v0, p0, Landroid/location/LocationManager;->mGpsStatus:Landroid/location/GpsStatus;

    invoke-virtual {p1, v0}, Landroid/location/GpsStatus;->setStatus(Landroid/location/GpsStatus;)V

    .line 1547
    return-object p1
.end method

.method public getLastKnownLocation(Ljava/lang/String;)Landroid/location/Location;
    .registers 5
    .parameter "provider"

    .prologue
    .line 1152
    if-nez p1, :cond_b

    .line 1153
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "provider==null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1156
    :cond_b
    :try_start_b
    iget-object v1, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v1, p1}, Landroid/location/ILocationManager;->getLastKnownLocation(Ljava/lang/String;)Landroid/location/Location;
    :try_end_10
    .catch Landroid/os/RemoteException; {:try_start_b .. :try_end_10} :catch_12

    move-result-object v1

    .line 1159
    :goto_11
    return-object v1

    .line 1157
    :catch_12
    move-exception v0

    .line 1158
    .local v0, ex:Landroid/os/RemoteException;
    const-string v1, "LocationManager"

    const-string v2, "getLastKnowLocation: RemoteException"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 1159
    const/4 v1, 0x0

    goto :goto_11
.end method

.method public getProvider(Ljava/lang/String;)Landroid/location/LocationProvider;
    .registers 7
    .parameter "name"

    .prologue
    const/4 v2, 0x0

    .line 330
    if-nez p1, :cond_c

    .line 331
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v3, "name==null"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 334
    :cond_c
    :try_start_c
    iget-object v3, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v3, p1}, Landroid/location/ILocationManager;->getProviderInfo(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    .line 335
    .local v1, info:Landroid/os/Bundle;
    if-nez v1, :cond_15

    .line 342
    .end local v1           #info:Landroid/os/Bundle;
    :goto_14
    return-object v2

    .line 338
    .restart local v1       #info:Landroid/os/Bundle;
    :cond_15
    invoke-direct {p0, p1, v1}, Landroid/location/LocationManager;->createProvider(Ljava/lang/String;Landroid/os/Bundle;)Landroid/location/LocationProvider;
    :try_end_18
    .catch Landroid/os/RemoteException; {:try_start_c .. :try_end_18} :catch_1a

    move-result-object v2

    goto :goto_14

    .line 339
    .end local v1           #info:Landroid/os/Bundle;
    :catch_1a
    move-exception v0

    .line 340
    .local v0, ex:Landroid/os/RemoteException;
    const-string v3, "LocationManager"

    const-string v4, "getProvider: RemoteException"

    invoke-static {v3, v4, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_14
.end method

.method public getProviders(Landroid/location/Criteria;Z)Ljava/util/List;
    .registers 6
    .parameter "criteria"
    .parameter "enabledOnly"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/location/Criteria;",
            "Z)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 356
    if-nez p1, :cond_a

    .line 357
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "criteria==null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 360
    :cond_a
    :try_start_a
    iget-object v1, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v1, p1, p2}, Landroid/location/ILocationManager;->getProviders(Landroid/location/Criteria;Z)Ljava/util/List;
    :try_end_f
    .catch Landroid/os/RemoteException; {:try_start_a .. :try_end_f} :catch_11

    move-result-object v1

    .line 364
    :goto_10
    return-object v1

    .line 361
    :catch_11
    move-exception v0

    .line 362
    .local v0, ex:Landroid/os/RemoteException;
    const-string v1, "LocationManager"

    const-string v2, "getProviders: RemoteException"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 364
    const/4 v1, 0x0

    goto :goto_10
.end method

.method public getProviders(Z)Ljava/util/List;
    .registers 6
    .parameter "enabledOnly"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 311
    :try_start_1
    iget-object v2, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    const/4 v3, 0x0

    invoke-interface {v2, v3, p1}, Landroid/location/ILocationManager;->getProviders(Landroid/location/Criteria;Z)Ljava/util/List;
    :try_end_7
    .catch Landroid/os/RemoteException; {:try_start_1 .. :try_end_7} :catch_9

    move-result-object v1

    .line 315
    :goto_8
    return-object v1

    .line 312
    :catch_9
    move-exception v0

    .line 313
    .local v0, ex:Landroid/os/RemoteException;
    const-string v2, "LocationManager"

    const-string v3, "getProviders: RemoteException"

    invoke-static {v2, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_8
.end method

.method public isProviderEnabled(Ljava/lang/String;)Z
    .registers 5
    .parameter "provider"

    .prologue
    .line 1125
    if-nez p1, :cond_b

    .line 1126
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "provider==null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1129
    :cond_b
    :try_start_b
    iget-object v1, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v1, p1}, Landroid/location/ILocationManager;->isProviderEnabled(Ljava/lang/String;)Z
    :try_end_10
    .catch Landroid/os/RemoteException; {:try_start_b .. :try_end_10} :catch_12

    move-result v1

    .line 1132
    :goto_11
    return v1

    .line 1130
    :catch_12
    move-exception v0

    .line 1131
    .local v0, ex:Landroid/os/RemoteException;
    const-string v1, "LocationManager"

    const-string v2, "isProviderEnabled: RemoteException"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 1132
    const/4 v1, 0x0

    goto :goto_11
.end method

.method public removeGpsStatusListener(Landroid/location/GpsStatus$Listener;)V
    .registers 6
    .parameter "listener"

    .prologue
    .line 1476
    :try_start_0
    iget-object v2, p0, Landroid/location/LocationManager;->mGpsStatusListeners:Ljava/util/HashMap;

    invoke-virtual {v2, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/location/LocationManager$GpsStatusListenerTransport;

    .line 1477
    .local v1, transport:Landroid/location/LocationManager$GpsStatusListenerTransport;
    if-eqz v1, :cond_f

    .line 1478
    iget-object v2, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v2, v1}, Landroid/location/ILocationManager;->removeGpsStatusListener(Landroid/location/IGpsStatusListener;)V
    :try_end_f
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_f} :catch_10

    .line 1483
    .end local v1           #transport:Landroid/location/LocationManager$GpsStatusListenerTransport;
    :cond_f
    :goto_f
    return-void

    .line 1480
    :catch_10
    move-exception v0

    .line 1481
    .local v0, e:Landroid/os/RemoteException;
    const-string v2, "LocationManager"

    const-string v3, "RemoteException in unregisterGpsStatusListener: "

    invoke-static {v2, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_f
.end method

.method public removeNmeaListener(Landroid/location/GpsStatus$NmeaListener;)V
    .registers 6
    .parameter "listener"

    .prologue
    .line 1522
    :try_start_0
    iget-object v2, p0, Landroid/location/LocationManager;->mNmeaListeners:Ljava/util/HashMap;

    invoke-virtual {v2, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/location/LocationManager$GpsStatusListenerTransport;

    .line 1523
    .local v1, transport:Landroid/location/LocationManager$GpsStatusListenerTransport;
    if-eqz v1, :cond_f

    .line 1524
    iget-object v2, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v2, v1}, Landroid/location/ILocationManager;->removeGpsStatusListener(Landroid/location/IGpsStatusListener;)V
    :try_end_f
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_f} :catch_10

    .line 1529
    .end local v1           #transport:Landroid/location/LocationManager$GpsStatusListenerTransport;
    :cond_f
    :goto_f
    return-void

    .line 1526
    :catch_10
    move-exception v0

    .line 1527
    .local v0, e:Landroid/os/RemoteException;
    const-string v2, "LocationManager"

    const-string v3, "RemoteException in unregisterGpsStatusListener: "

    invoke-static {v2, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_f
.end method

.method public removeProximityAlert(Landroid/app/PendingIntent;)V
    .registers 5
    .parameter "intent"

    .prologue
    .line 1107
    :try_start_0
    iget-object v1, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v1, p1}, Landroid/location/ILocationManager;->removeProximityAlert(Landroid/app/PendingIntent;)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    .line 1111
    :goto_5
    return-void

    .line 1108
    :catch_6
    move-exception v0

    .line 1109
    .local v0, ex:Landroid/os/RemoteException;
    const-string v1, "LocationManager"

    const-string/jumbo v2, "removeProximityAlert: RemoteException"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_5
.end method

.method public removeTestProvider(Ljava/lang/String;)V
    .registers 5
    .parameter "provider"

    .prologue
    .line 1208
    :try_start_0
    iget-object v1, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v1, p1}, Landroid/location/ILocationManager;->removeTestProvider(Ljava/lang/String;)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    .line 1212
    :goto_5
    return-void

    .line 1209
    :catch_6
    move-exception v0

    .line 1210
    .local v0, ex:Landroid/os/RemoteException;
    const-string v1, "LocationManager"

    const-string/jumbo v2, "removeTestProvider: RemoteException"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_5
.end method

.method public removeUpdates(Landroid/app/PendingIntent;)V
    .registers 5
    .parameter "intent"

    .prologue
    .line 1024
    if-nez p1, :cond_a

    .line 1025
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "intent==null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1031
    :cond_a
    :try_start_a
    iget-object v1, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v1, p1}, Landroid/location/ILocationManager;->removeUpdatesPI(Landroid/app/PendingIntent;)V
    :try_end_f
    .catch Landroid/os/RemoteException; {:try_start_a .. :try_end_f} :catch_10

    .line 1035
    :goto_f
    return-void

    .line 1032
    :catch_10
    move-exception v0

    .line 1033
    .local v0, ex:Landroid/os/RemoteException;
    const-string v1, "LocationManager"

    const-string/jumbo v2, "removeUpdates: RemoteException"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_f
.end method

.method public removeUpdates(Landroid/location/LocationListener;)V
    .registers 6
    .parameter "listener"

    .prologue
    .line 999
    if-nez p1, :cond_b

    .line 1000
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v3, "listener==null"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 1006
    :cond_b
    :try_start_b
    iget-object v2, p0, Landroid/location/LocationManager;->mListeners:Ljava/util/HashMap;

    invoke-virtual {v2, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/location/LocationManager$ListenerTransport;

    .line 1007
    .local v1, transport:Landroid/location/LocationManager$ListenerTransport;
    if-eqz v1, :cond_1a

    .line 1008
    iget-object v2, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v2, v1}, Landroid/location/ILocationManager;->removeUpdates(Landroid/location/ILocationListener;)V
    :try_end_1a
    .catch Landroid/os/RemoteException; {:try_start_b .. :try_end_1a} :catch_1b

    .line 1013
    .end local v1           #transport:Landroid/location/LocationManager$ListenerTransport;
    :cond_1a
    :goto_1a
    return-void

    .line 1010
    :catch_1b
    move-exception v0

    .line 1011
    .local v0, ex:Landroid/os/RemoteException;
    const-string v2, "LocationManager"

    const-string/jumbo v3, "removeUpdates: DeadObjectException"

    invoke-static {v2, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1a
.end method

.method public requestLocationUpdates(JFLandroid/location/Criteria;Landroid/app/PendingIntent;)V
    .registers 14
    .parameter "minTime"
    .parameter "minDistance"
    .parameter "criteria"
    .parameter "intent"

    .prologue
    .line 821
    if-nez p4, :cond_a

    .line 822
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "criteria==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 824
    :cond_a
    if-nez p5, :cond_14

    .line 825
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "intent==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 827
    :cond_14
    const/4 v1, 0x0

    const/4 v6, 0x0

    move-object v0, p0

    move-object v2, p4

    move-wide v3, p1

    move v5, p3

    move-object v7, p5

    invoke-direct/range {v0 .. v7}, Landroid/location/LocationManager;->_requestLocationUpdates(Ljava/lang/String;Landroid/location/Criteria;JFZLandroid/app/PendingIntent;)V

    .line 828
    return-void
.end method

.method public requestLocationUpdates(JFLandroid/location/Criteria;Landroid/location/LocationListener;Landroid/os/Looper;)V
    .registers 16
    .parameter "minTime"
    .parameter "minDistance"
    .parameter "criteria"
    .parameter "listener"
    .parameter "looper"

    .prologue
    .line 635
    if-nez p4, :cond_a

    .line 636
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "criteria==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 638
    :cond_a
    if-nez p5, :cond_15

    .line 639
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "listener==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 641
    :cond_15
    const/4 v1, 0x0

    const/4 v6, 0x0

    move-object v0, p0

    move-object v2, p4

    move-wide v3, p1

    move v5, p3

    move-object v7, p5

    move-object v8, p6

    invoke-direct/range {v0 .. v8}, Landroid/location/LocationManager;->_requestLocationUpdates(Ljava/lang/String;Landroid/location/Criteria;JFZLandroid/location/LocationListener;Landroid/os/Looper;)V

    .line 642
    return-void
.end method

.method public requestLocationUpdates(Ljava/lang/String;JFLandroid/app/PendingIntent;)V
    .registers 14
    .parameter "provider"
    .parameter "minTime"
    .parameter "minDistance"
    .parameter "intent"

    .prologue
    .line 745
    if-nez p1, :cond_b

    .line 746
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "provider==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 748
    :cond_b
    if-nez p5, :cond_15

    .line 749
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "intent==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 751
    :cond_15
    const/4 v2, 0x0

    const/4 v6, 0x0

    move-object v0, p0

    move-object v1, p1

    move-wide v3, p2

    move v5, p4

    move-object v7, p5

    invoke-direct/range {v0 .. v7}, Landroid/location/LocationManager;->_requestLocationUpdates(Ljava/lang/String;Landroid/location/Criteria;JFZLandroid/app/PendingIntent;)V

    .line 752
    return-void
.end method

.method public requestLocationUpdates(Ljava/lang/String;JFLandroid/location/LocationListener;)V
    .registers 15
    .parameter "provider"
    .parameter "minTime"
    .parameter "minDistance"
    .parameter "listener"

    .prologue
    const/4 v2, 0x0

    .line 476
    if-nez p1, :cond_c

    .line 477
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "provider==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 479
    :cond_c
    if-nez p5, :cond_17

    .line 480
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "listener==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 482
    :cond_17
    const/4 v6, 0x0

    move-object v0, p0

    move-object v1, p1

    move-wide v3, p2

    move v5, p4

    move-object v7, p5

    move-object v8, v2

    invoke-direct/range {v0 .. v8}, Landroid/location/LocationManager;->_requestLocationUpdates(Ljava/lang/String;Landroid/location/Criteria;JFZLandroid/location/LocationListener;Landroid/os/Looper;)V

    .line 483
    return-void
.end method

.method public requestLocationUpdates(Ljava/lang/String;JFLandroid/location/LocationListener;Landroid/os/Looper;)V
    .registers 16
    .parameter "provider"
    .parameter "minTime"
    .parameter "minDistance"
    .parameter "listener"
    .parameter "looper"

    .prologue
    .line 561
    if-nez p1, :cond_b

    .line 562
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "provider==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 564
    :cond_b
    if-nez p5, :cond_16

    .line 565
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "listener==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 567
    :cond_16
    const/4 v2, 0x0

    const/4 v6, 0x0

    move-object v0, p0

    move-object v1, p1

    move-wide v3, p2

    move v5, p4

    move-object v7, p5

    move-object v8, p6

    invoke-direct/range {v0 .. v8}, Landroid/location/LocationManager;->_requestLocationUpdates(Ljava/lang/String;Landroid/location/Criteria;JFZLandroid/location/LocationListener;Landroid/os/Looper;)V

    .line 568
    return-void
.end method

.method public requestSingleUpdate(Landroid/location/Criteria;Landroid/app/PendingIntent;)V
    .registers 11
    .parameter "criteria"
    .parameter "intent"

    .prologue
    .line 981
    if-nez p1, :cond_a

    .line 982
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "criteria==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 984
    :cond_a
    if-nez p2, :cond_14

    .line 985
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "intent==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 987
    :cond_14
    const/4 v1, 0x0

    const-wide/16 v3, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x1

    move-object v0, p0

    move-object v2, p1

    move-object v7, p2

    invoke-direct/range {v0 .. v7}, Landroid/location/LocationManager;->_requestLocationUpdates(Ljava/lang/String;Landroid/location/Criteria;JFZLandroid/app/PendingIntent;)V

    .line 988
    return-void
.end method

.method public requestSingleUpdate(Landroid/location/Criteria;Landroid/location/LocationListener;Landroid/os/Looper;)V
    .registers 13
    .parameter "criteria"
    .parameter "listener"
    .parameter "looper"

    .prologue
    .line 913
    if-nez p1, :cond_a

    .line 914
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "criteria==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 916
    :cond_a
    if-nez p2, :cond_15

    .line 917
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "listener==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 919
    :cond_15
    const/4 v1, 0x0

    const-wide/16 v3, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x1

    move-object v0, p0

    move-object v2, p1

    move-object v7, p2

    move-object v8, p3

    invoke-direct/range {v0 .. v8}, Landroid/location/LocationManager;->_requestLocationUpdates(Ljava/lang/String;Landroid/location/Criteria;JFZLandroid/location/LocationListener;Landroid/os/Looper;)V

    .line 920
    return-void
.end method

.method public requestSingleUpdate(Ljava/lang/String;Landroid/app/PendingIntent;)V
    .registers 11
    .parameter "provider"
    .parameter "intent"

    .prologue
    .line 946
    if-nez p1, :cond_b

    .line 947
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "provider==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 949
    :cond_b
    if-nez p2, :cond_15

    .line 950
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "intent==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 952
    :cond_15
    const/4 v2, 0x0

    const-wide/16 v3, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x1

    move-object v0, p0

    move-object v1, p1

    move-object v7, p2

    invoke-direct/range {v0 .. v7}, Landroid/location/LocationManager;->_requestLocationUpdates(Ljava/lang/String;Landroid/location/Criteria;JFZLandroid/app/PendingIntent;)V

    .line 953
    return-void
.end method

.method public requestSingleUpdate(Ljava/lang/String;Landroid/location/LocationListener;Landroid/os/Looper;)V
    .registers 13
    .parameter "provider"
    .parameter "listener"
    .parameter "looper"

    .prologue
    .line 874
    if-nez p1, :cond_b

    .line 875
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "provider==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 877
    :cond_b
    if-nez p2, :cond_16

    .line 878
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "listener==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 880
    :cond_16
    const/4 v2, 0x0

    const-wide/16 v3, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x1

    move-object v0, p0

    move-object v1, p1

    move-object v7, p2

    move-object v8, p3

    invoke-direct/range {v0 .. v8}, Landroid/location/LocationManager;->_requestLocationUpdates(Ljava/lang/String;Landroid/location/Criteria;JFZLandroid/location/LocationListener;Landroid/os/Looper;)V

    .line 881
    return-void
.end method

.method public sendExtraCommand(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Z
    .registers 7
    .parameter "provider"
    .parameter "command"
    .parameter "extras"

    .prologue
    .line 1563
    :try_start_0
    iget-object v1, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v1, p1, p2, p3}, Landroid/location/ILocationManager;->sendExtraCommand(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Z
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_7

    move-result v1

    .line 1566
    :goto_6
    return v1

    .line 1564
    :catch_7
    move-exception v0

    .line 1565
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "LocationManager"

    const-string v2, "RemoteException in sendExtraCommand: "

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 1566
    const/4 v1, 0x0

    goto :goto_6
.end method

.method public sendNiResponse(II)Z
    .registers 6
    .parameter "notifId"
    .parameter "userResponse"

    .prologue
    .line 1578
    :try_start_0
    iget-object v1, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v1, p1, p2}, Landroid/location/ILocationManager;->sendNiResponse(II)Z
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_7

    move-result v1

    .line 1581
    :goto_6
    return v1

    .line 1579
    :catch_7
    move-exception v0

    .line 1580
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "LocationManager"

    const-string v2, "RemoteException in sendNiResponse: "

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 1581
    const/4 v1, 0x0

    goto :goto_6
.end method

.method public setTestProviderEnabled(Ljava/lang/String;Z)V
    .registers 6
    .parameter "provider"
    .parameter "enabled"

    .prologue
    .line 1266
    :try_start_0
    iget-object v1, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v1, p1, p2}, Landroid/location/ILocationManager;->setTestProviderEnabled(Ljava/lang/String;Z)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    .line 1270
    :goto_5
    return-void

    .line 1267
    :catch_6
    move-exception v0

    .line 1268
    .local v0, ex:Landroid/os/RemoteException;
    const-string v1, "LocationManager"

    const-string/jumbo v2, "setTestProviderEnabled: RemoteException"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_5
.end method

.method public setTestProviderLocation(Ljava/lang/String;Landroid/location/Location;)V
    .registers 6
    .parameter "provider"
    .parameter "loc"

    .prologue
    .line 1228
    :try_start_0
    iget-object v1, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v1, p1, p2}, Landroid/location/ILocationManager;->setTestProviderLocation(Ljava/lang/String;Landroid/location/Location;)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    .line 1232
    :goto_5
    return-void

    .line 1229
    :catch_6
    move-exception v0

    .line 1230
    .local v0, ex:Landroid/os/RemoteException;
    const-string v1, "LocationManager"

    const-string/jumbo v2, "setTestProviderLocation: RemoteException"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_5
.end method

.method public setTestProviderStatus(Ljava/lang/String;ILandroid/os/Bundle;J)V
    .registers 13
    .parameter "provider"
    .parameter "status"
    .parameter "extras"
    .parameter "updateTime"

    .prologue
    .line 1307
    :try_start_0
    iget-object v0, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    move-object v1, p1

    move v2, p2

    move-object v3, p3

    move-wide v4, p4

    invoke-interface/range {v0 .. v5}, Landroid/location/ILocationManager;->setTestProviderStatus(Ljava/lang/String;ILandroid/os/Bundle;J)V
    :try_end_9
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_9} :catch_a

    .line 1311
    :goto_9
    return-void

    .line 1308
    :catch_a
    move-exception v6

    .line 1309
    .local v6, ex:Landroid/os/RemoteException;
    const-string v0, "LocationManager"

    const-string/jumbo v1, "setTestProviderStatus: RemoteException"

    invoke-static {v0, v1, v6}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_9
.end method
