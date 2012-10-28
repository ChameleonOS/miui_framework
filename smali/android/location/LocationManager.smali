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
.field private final mContext:Landroid/content/Context;

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
.method public constructor <init>(Landroid/content/Context;Landroid/location/ILocationManager;)V
    .registers 4
    .parameter "context"
    .parameter "service"

    .prologue
    .line 266
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 57
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroid/location/LocationManager;->mGpsStatusListeners:Ljava/util/HashMap;

    .line 59
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroid/location/LocationManager;->mNmeaListeners:Ljava/util/HashMap;

    .line 61
    new-instance v0, Landroid/location/GpsStatus;

    invoke-direct {v0}, Landroid/location/GpsStatus;-><init>()V

    iput-object v0, p0, Landroid/location/LocationManager;->mGpsStatus:Landroid/location/GpsStatus;

    .line 167
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroid/location/LocationManager;->mListeners:Ljava/util/HashMap;

    .line 267
    iput-object p2, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    .line 268
    iput-object p1, p0, Landroid/location/LocationManager;->mContext:Landroid/content/Context;

    .line 269
    return-void
.end method

.method private _requestLocationUpdates(Ljava/lang/String;Landroid/location/Criteria;JFZLandroid/app/PendingIntent;)V
    .registers 18
    .parameter "provider"
    .parameter "criteria"
    .parameter "minTime"
    .parameter "minDistance"
    .parameter "singleShot"
    .parameter "intent"

    .prologue
    .line 837
    const-wide/16 v0, 0x0

    cmp-long v0, p3, v0

    if-gez v0, :cond_8

    .line 838
    const-wide/16 p3, 0x0

    .line 840
    :cond_8
    const/4 v0, 0x0

    cmpg-float v0, p5, v0

    if-gez v0, :cond_e

    .line 841
    const/4 p5, 0x0

    .line 845
    :cond_e
    :try_start_e
    iget-object v0, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    iget-object v1, p0, Landroid/location/LocationManager;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v8

    move-object v1, p1

    move-object v2, p2

    move-wide v3, p3

    move v5, p5

    move/from16 v6, p6

    move-object/from16 v7, p7

    invoke-interface/range {v0 .. v8}, Landroid/location/ILocationManager;->requestLocationUpdatesPI(Ljava/lang/String;Landroid/location/Criteria;JFZLandroid/app/PendingIntent;Ljava/lang/String;)V
    :try_end_21
    .catch Landroid/os/RemoteException; {:try_start_e .. :try_end_21} :catch_22

    .line 850
    :goto_21
    return-void

    .line 847
    :catch_22
    move-exception v9

    .line 848
    .local v9, ex:Landroid/os/RemoteException;
    const-string v0, "LocationManager"

    const-string/jumbo v1, "requestLocationUpdates: RemoteException"

    invoke-static {v0, v1, v9}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_21
.end method

.method private _requestLocationUpdates(Ljava/lang/String;Landroid/location/Criteria;JFZLandroid/location/LocationListener;Landroid/os/Looper;)V
    .registers 22
    .parameter "provider"
    .parameter "criteria"
    .parameter "minTime"
    .parameter "minDistance"
    .parameter "singleShot"
    .parameter "listener"
    .parameter "looper"

    .prologue
    .line 650
    const-wide/16 v2, 0x0

    cmp-long v2, p3, v2

    if-gez v2, :cond_8

    .line 651
    const-wide/16 p3, 0x0

    .line 653
    :cond_8
    const/4 v2, 0x0

    cmpg-float v2, p5, v2

    if-gez v2, :cond_f

    .line 654
    const/16 p5, 0x0

    .line 658
    :cond_f
    :try_start_f
    iget-object v12, p0, Landroid/location/LocationManager;->mListeners:Ljava/util/HashMap;

    monitor-enter v12
    :try_end_12
    .catch Landroid/os/RemoteException; {:try_start_f .. :try_end_12} :catch_46

    .line 659
    :try_start_12
    iget-object v2, p0, Landroid/location/LocationManager;->mListeners:Ljava/util/HashMap;

    move-object/from16 v0, p7

    invoke-virtual {v2, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/location/LocationManager$ListenerTransport;

    .line 660
    .local v9, transport:Landroid/location/LocationManager$ListenerTransport;
    if-nez v9, :cond_27

    .line 661
    new-instance v9, Landroid/location/LocationManager$ListenerTransport;

    .end local v9           #transport:Landroid/location/LocationManager$ListenerTransport;
    move-object/from16 v0, p7

    move-object/from16 v1, p8

    invoke-direct {v9, p0, v0, v1}, Landroid/location/LocationManager$ListenerTransport;-><init>(Landroid/location/LocationManager;Landroid/location/LocationListener;Landroid/os/Looper;)V

    .line 663
    .restart local v9       #transport:Landroid/location/LocationManager$ListenerTransport;
    :cond_27
    iget-object v2, p0, Landroid/location/LocationManager;->mListeners:Ljava/util/HashMap;

    move-object/from16 v0, p7

    invoke-virtual {v2, v0, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 664
    iget-object v2, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    iget-object v3, p0, Landroid/location/LocationManager;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v10

    move-object v3, p1

    move-object v4, p2

    move-wide/from16 v5, p3

    move/from16 v7, p5

    move/from16 v8, p6

    invoke-interface/range {v2 .. v10}, Landroid/location/ILocationManager;->requestLocationUpdates(Ljava/lang/String;Landroid/location/Criteria;JFZLandroid/location/ILocationListener;Ljava/lang/String;)V

    .line 666
    monitor-exit v12

    .line 670
    .end local v9           #transport:Landroid/location/LocationManager$ListenerTransport;
    :goto_42
    return-void

    .line 666
    :catchall_43
    move-exception v2

    monitor-exit v12
    :try_end_45
    .catchall {:try_start_12 .. :try_end_45} :catchall_43

    :try_start_45
    throw v2
    :try_end_46
    .catch Landroid/os/RemoteException; {:try_start_45 .. :try_end_46} :catch_46

    .line 667
    :catch_46
    move-exception v11

    .line 668
    .local v11, ex:Landroid/os/RemoteException;
    const-string v2, "LocationManager"

    const-string/jumbo v3, "requestLocationUpdates: DeadObjectException"

    invoke-static {v2, v3, v11}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_42
.end method

.method static synthetic access$100(Landroid/location/LocationManager;)Landroid/location/ILocationManager;
    .registers 2
    .parameter "x0"

    .prologue
    .line 54
    iget-object v0, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    return-object v0
.end method

.method static synthetic access$200(Landroid/location/LocationManager;)Landroid/location/GpsStatus;
    .registers 2
    .parameter "x0"

    .prologue
    .line 54
    iget-object v0, p0, Landroid/location/LocationManager;->mGpsStatus:Landroid/location/GpsStatus;

    return-object v0
.end method

.method private createProvider(Ljava/lang/String;Landroid/os/Bundle;)Landroid/location/LocationProvider;
    .registers 5
    .parameter "name"
    .parameter "info"

    .prologue
    .line 272
    new-instance v0, Lcom/android/internal/location/DummyLocationProvider;

    iget-object v1, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-direct {v0, p1, v1}, Lcom/android/internal/location/DummyLocationProvider;-><init>(Ljava/lang/String;Landroid/location/ILocationManager;)V

    .line 274
    .local v0, provider:Lcom/android/internal/location/DummyLocationProvider;
    const-string/jumbo v1, "network"

    invoke-virtual {p2, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/android/internal/location/DummyLocationProvider;->setRequiresNetwork(Z)V

    .line 275
    const-string/jumbo v1, "satellite"

    invoke-virtual {p2, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/android/internal/location/DummyLocationProvider;->setRequiresSatellite(Z)V

    .line 276
    const-string v1, "cell"

    invoke-virtual {p2, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/android/internal/location/DummyLocationProvider;->setRequiresCell(Z)V

    .line 277
    const-string v1, "cost"

    invoke-virtual {p2, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/android/internal/location/DummyLocationProvider;->setHasMonetaryCost(Z)V

    .line 278
    const-string v1, "altitude"

    invoke-virtual {p2, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/android/internal/location/DummyLocationProvider;->setSupportsAltitude(Z)V

    .line 279
    const-string/jumbo v1, "speed"

    invoke-virtual {p2, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/android/internal/location/DummyLocationProvider;->setSupportsSpeed(Z)V

    .line 280
    const-string v1, "bearing"

    invoke-virtual {p2, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/android/internal/location/DummyLocationProvider;->setSupportsBearing(Z)V

    .line 281
    const-string/jumbo v1, "power"

    invoke-virtual {p2, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/android/internal/location/DummyLocationProvider;->setPowerRequirement(I)V

    .line 282
    const-string v1, "accuracy"

    invoke-virtual {p2, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/android/internal/location/DummyLocationProvider;->setAccuracy(I)V

    .line 283
    return-object v0
.end method


# virtual methods
.method public addGpsStatusListener(Landroid/location/GpsStatus$Listener;)Z
    .registers 7
    .parameter "listener"

    .prologue
    .line 1457
    iget-object v3, p0, Landroid/location/LocationManager;->mGpsStatusListeners:Ljava/util/HashMap;

    invoke-virtual {v3, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    if-eqz v3, :cond_a

    .line 1459
    const/4 v1, 0x1

    .line 1472
    :cond_9
    :goto_9
    return v1

    .line 1462
    :cond_a
    :try_start_a
    new-instance v2, Landroid/location/LocationManager$GpsStatusListenerTransport;

    invoke-direct {v2, p0, p1}, Landroid/location/LocationManager$GpsStatusListenerTransport;-><init>(Landroid/location/LocationManager;Landroid/location/GpsStatus$Listener;)V

    .line 1463
    .local v2, transport:Landroid/location/LocationManager$GpsStatusListenerTransport;
    iget-object v3, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v3, v2}, Landroid/location/ILocationManager;->addGpsStatusListener(Landroid/location/IGpsStatusListener;)Z

    move-result v1

    .line 1464
    .local v1, result:Z
    if-eqz v1, :cond_9

    .line 1465
    iget-object v3, p0, Landroid/location/LocationManager;->mGpsStatusListeners:Ljava/util/HashMap;

    invoke-virtual {v3, p1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1c
    .catch Landroid/os/RemoteException; {:try_start_a .. :try_end_1c} :catch_1d

    goto :goto_9

    .line 1467
    .end local v1           #result:Z
    .end local v2           #transport:Landroid/location/LocationManager$GpsStatusListenerTransport;
    :catch_1d
    move-exception v0

    .line 1468
    .local v0, e:Landroid/os/RemoteException;
    const-string v3, "LocationManager"

    const-string v4, "RemoteException in registerGpsStatusListener: "

    invoke-static {v3, v4, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 1469
    const/4 v1, 0x0

    .restart local v1       #result:Z
    goto :goto_9
.end method

.method public addNmeaListener(Landroid/location/GpsStatus$NmeaListener;)Z
    .registers 7
    .parameter "listener"

    .prologue
    .line 1503
    iget-object v3, p0, Landroid/location/LocationManager;->mNmeaListeners:Ljava/util/HashMap;

    invoke-virtual {v3, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    if-eqz v3, :cond_a

    .line 1505
    const/4 v1, 0x1

    .line 1518
    :cond_9
    :goto_9
    return v1

    .line 1508
    :cond_a
    :try_start_a
    new-instance v2, Landroid/location/LocationManager$GpsStatusListenerTransport;

    invoke-direct {v2, p0, p1}, Landroid/location/LocationManager$GpsStatusListenerTransport;-><init>(Landroid/location/LocationManager;Landroid/location/GpsStatus$NmeaListener;)V

    .line 1509
    .local v2, transport:Landroid/location/LocationManager$GpsStatusListenerTransport;
    iget-object v3, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v3, v2}, Landroid/location/ILocationManager;->addGpsStatusListener(Landroid/location/IGpsStatusListener;)Z

    move-result v1

    .line 1510
    .local v1, result:Z
    if-eqz v1, :cond_9

    .line 1511
    iget-object v3, p0, Landroid/location/LocationManager;->mNmeaListeners:Ljava/util/HashMap;

    invoke-virtual {v3, p1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1c
    .catch Landroid/os/RemoteException; {:try_start_a .. :try_end_1c} :catch_1d

    goto :goto_9

    .line 1513
    .end local v1           #result:Z
    .end local v2           #transport:Landroid/location/LocationManager$GpsStatusListenerTransport;
    :catch_1d
    move-exception v0

    .line 1514
    .local v0, e:Landroid/os/RemoteException;
    const-string v3, "LocationManager"

    const-string v4, "RemoteException in registerGpsStatusListener: "

    invoke-static {v3, v4, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 1515
    const/4 v1, 0x0

    .restart local v1       #result:Z
    goto :goto_9
.end method

.method public addProximityAlert(DDFJLandroid/app/PendingIntent;)V
    .registers 20
    .parameter "latitude"
    .parameter "longitude"
    .parameter "radius"
    .parameter "expiration"
    .parameter "intent"

    .prologue
    .line 1095
    :try_start_0
    iget-object v0, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    iget-object v1, p0, Landroid/location/LocationManager;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v9

    move-wide v1, p1

    move-wide v3, p3

    move/from16 v5, p5

    move-wide/from16 v6, p6

    move-object/from16 v8, p8

    invoke-interface/range {v0 .. v9}, Landroid/location/ILocationManager;->addProximityAlert(DDFJLandroid/app/PendingIntent;Ljava/lang/String;)V
    :try_end_13
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_13} :catch_14

    .line 1100
    :goto_13
    return-void

    .line 1097
    :catch_14
    move-exception v10

    .line 1098
    .local v10, ex:Landroid/os/RemoteException;
    const-string v0, "LocationManager"

    const-string v1, "addProximityAlert: RemoteException"

    invoke-static {v0, v1, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_13
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
    .line 1194
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

    .line 1200
    :goto_16
    return-void

    .line 1197
    :catch_17
    move-exception v11

    .line 1198
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
    .line 1290
    :try_start_0
    iget-object v1, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v1, p1}, Landroid/location/ILocationManager;->clearTestProviderEnabled(Ljava/lang/String;)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    .line 1295
    :goto_5
    return-void

    .line 1291
    :catch_6
    move-exception v0

    .line 1292
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
    .line 1252
    :try_start_0
    iget-object v1, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v1, p1}, Landroid/location/ILocationManager;->clearTestProviderLocation(Ljava/lang/String;)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    .line 1256
    :goto_5
    return-void

    .line 1253
    :catch_6
    move-exception v0

    .line 1254
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
    .line 1331
    :try_start_0
    iget-object v1, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v1, p1}, Landroid/location/ILocationManager;->clearTestProviderStatus(Ljava/lang/String;)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    .line 1335
    :goto_5
    return-void

    .line 1332
    :catch_6
    move-exception v0

    .line 1333
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
    .line 298
    :try_start_0
    iget-object v1, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v1}, Landroid/location/ILocationManager;->getAllProviders()Ljava/util/List;
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_7

    move-result-object v1

    .line 302
    :goto_6
    return-object v1

    .line 299
    :catch_7
    move-exception v0

    .line 300
    .local v0, ex:Landroid/os/RemoteException;
    const-string v1, "LocationManager"

    const-string v2, "getAllProviders: RemoteException"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 302
    const/4 v1, 0x0

    goto :goto_6
.end method

.method public getBestProvider(Landroid/location/Criteria;Z)Ljava/lang/String;
    .registers 6
    .parameter "criteria"
    .parameter "enabledOnly"

    .prologue
    .line 394
    if-nez p1, :cond_a

    .line 395
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "criteria==null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 398
    :cond_a
    :try_start_a
    iget-object v1, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v1, p1, p2}, Landroid/location/ILocationManager;->getBestProvider(Landroid/location/Criteria;Z)Ljava/lang/String;
    :try_end_f
    .catch Landroid/os/RemoteException; {:try_start_a .. :try_end_f} :catch_11

    move-result-object v1

    .line 402
    :goto_10
    return-object v1

    .line 399
    :catch_11
    move-exception v0

    .line 400
    .local v0, ex:Landroid/os/RemoteException;
    const-string v1, "LocationManager"

    const-string v2, "getBestProvider: RemoteException"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 402
    const/4 v1, 0x0

    goto :goto_10
.end method

.method public getGpsStatus(Landroid/location/GpsStatus;)Landroid/location/GpsStatus;
    .registers 3
    .parameter "status"

    .prologue
    .line 1549
    if-nez p1, :cond_7

    .line 1550
    new-instance p1, Landroid/location/GpsStatus;

    .end local p1
    invoke-direct {p1}, Landroid/location/GpsStatus;-><init>()V

    .line 1552
    .restart local p1
    :cond_7
    iget-object v0, p0, Landroid/location/LocationManager;->mGpsStatus:Landroid/location/GpsStatus;

    invoke-virtual {p1, v0}, Landroid/location/GpsStatus;->setStatus(Landroid/location/GpsStatus;)V

    .line 1553
    return-object p1
.end method

.method public getLastKnownLocation(Ljava/lang/String;)Landroid/location/Location;
    .registers 5
    .parameter "provider"

    .prologue
    .line 1158
    if-nez p1, :cond_b

    .line 1159
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "provider==null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1162
    :cond_b
    :try_start_b
    iget-object v1, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    iget-object v2, p0, Landroid/location/LocationManager;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, p1, v2}, Landroid/location/ILocationManager;->getLastKnownLocation(Ljava/lang/String;Ljava/lang/String;)Landroid/location/Location;
    :try_end_16
    .catch Landroid/os/RemoteException; {:try_start_b .. :try_end_16} :catch_18

    move-result-object v1

    .line 1165
    :goto_17
    return-object v1

    .line 1163
    :catch_18
    move-exception v0

    .line 1164
    .local v0, ex:Landroid/os/RemoteException;
    const-string v1, "LocationManager"

    const-string v2, "getLastKnowLocation: RemoteException"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 1165
    const/4 v1, 0x0

    goto :goto_17
.end method

.method public getProvider(Ljava/lang/String;)Landroid/location/LocationProvider;
    .registers 7
    .parameter "name"

    .prologue
    const/4 v2, 0x0

    .line 334
    if-nez p1, :cond_c

    .line 335
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v3, "name==null"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 338
    :cond_c
    :try_start_c
    iget-object v3, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v3, p1}, Landroid/location/ILocationManager;->getProviderInfo(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    .line 339
    .local v1, info:Landroid/os/Bundle;
    if-nez v1, :cond_15

    .line 346
    .end local v1           #info:Landroid/os/Bundle;
    :goto_14
    return-object v2

    .line 342
    .restart local v1       #info:Landroid/os/Bundle;
    :cond_15
    invoke-direct {p0, p1, v1}, Landroid/location/LocationManager;->createProvider(Ljava/lang/String;Landroid/os/Bundle;)Landroid/location/LocationProvider;
    :try_end_18
    .catch Landroid/os/RemoteException; {:try_start_c .. :try_end_18} :catch_1a

    move-result-object v2

    goto :goto_14

    .line 343
    .end local v1           #info:Landroid/os/Bundle;
    :catch_1a
    move-exception v0

    .line 344
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
    .line 360
    if-nez p1, :cond_a

    .line 361
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "criteria==null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 364
    :cond_a
    :try_start_a
    iget-object v1, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v1, p1, p2}, Landroid/location/ILocationManager;->getProviders(Landroid/location/Criteria;Z)Ljava/util/List;
    :try_end_f
    .catch Landroid/os/RemoteException; {:try_start_a .. :try_end_f} :catch_11

    move-result-object v1

    .line 368
    :goto_10
    return-object v1

    .line 365
    :catch_11
    move-exception v0

    .line 366
    .local v0, ex:Landroid/os/RemoteException;
    const-string v1, "LocationManager"

    const-string v2, "getProviders: RemoteException"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 368
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

    .line 315
    :try_start_1
    iget-object v2, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    const/4 v3, 0x0

    invoke-interface {v2, v3, p1}, Landroid/location/ILocationManager;->getProviders(Landroid/location/Criteria;Z)Ljava/util/List;
    :try_end_7
    .catch Landroid/os/RemoteException; {:try_start_1 .. :try_end_7} :catch_9

    move-result-object v1

    .line 319
    :goto_8
    return-object v1

    .line 316
    :catch_9
    move-exception v0

    .line 317
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
    .line 1131
    if-nez p1, :cond_b

    .line 1132
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "provider==null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1135
    :cond_b
    :try_start_b
    iget-object v1, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v1, p1}, Landroid/location/ILocationManager;->isProviderEnabled(Ljava/lang/String;)Z
    :try_end_10
    .catch Landroid/os/RemoteException; {:try_start_b .. :try_end_10} :catch_12

    move-result v1

    .line 1138
    :goto_11
    return v1

    .line 1136
    :catch_12
    move-exception v0

    .line 1137
    .local v0, ex:Landroid/os/RemoteException;
    const-string v1, "LocationManager"

    const-string v2, "isProviderEnabled: RemoteException"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 1138
    const/4 v1, 0x0

    goto :goto_11
.end method

.method public removeGpsStatusListener(Landroid/location/GpsStatus$Listener;)V
    .registers 6
    .parameter "listener"

    .prologue
    .line 1482
    :try_start_0
    iget-object v2, p0, Landroid/location/LocationManager;->mGpsStatusListeners:Ljava/util/HashMap;

    invoke-virtual {v2, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/location/LocationManager$GpsStatusListenerTransport;

    .line 1483
    .local v1, transport:Landroid/location/LocationManager$GpsStatusListenerTransport;
    if-eqz v1, :cond_f

    .line 1484
    iget-object v2, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v2, v1}, Landroid/location/ILocationManager;->removeGpsStatusListener(Landroid/location/IGpsStatusListener;)V
    :try_end_f
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_f} :catch_10

    .line 1489
    .end local v1           #transport:Landroid/location/LocationManager$GpsStatusListenerTransport;
    :cond_f
    :goto_f
    return-void

    .line 1486
    :catch_10
    move-exception v0

    .line 1487
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
    .line 1528
    :try_start_0
    iget-object v2, p0, Landroid/location/LocationManager;->mNmeaListeners:Ljava/util/HashMap;

    invoke-virtual {v2, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/location/LocationManager$GpsStatusListenerTransport;

    .line 1529
    .local v1, transport:Landroid/location/LocationManager$GpsStatusListenerTransport;
    if-eqz v1, :cond_f

    .line 1530
    iget-object v2, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v2, v1}, Landroid/location/ILocationManager;->removeGpsStatusListener(Landroid/location/IGpsStatusListener;)V
    :try_end_f
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_f} :catch_10

    .line 1535
    .end local v1           #transport:Landroid/location/LocationManager$GpsStatusListenerTransport;
    :cond_f
    :goto_f
    return-void

    .line 1532
    :catch_10
    move-exception v0

    .line 1533
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
    .line 1113
    :try_start_0
    iget-object v1, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v1, p1}, Landroid/location/ILocationManager;->removeProximityAlert(Landroid/app/PendingIntent;)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    .line 1117
    :goto_5
    return-void

    .line 1114
    :catch_6
    move-exception v0

    .line 1115
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
    .line 1214
    :try_start_0
    iget-object v1, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v1, p1}, Landroid/location/ILocationManager;->removeTestProvider(Ljava/lang/String;)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    .line 1218
    :goto_5
    return-void

    .line 1215
    :catch_6
    move-exception v0

    .line 1216
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
    .line 1030
    if-nez p1, :cond_a

    .line 1031
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "intent==null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1037
    :cond_a
    :try_start_a
    iget-object v1, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    iget-object v2, p0, Landroid/location/LocationManager;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, p1, v2}, Landroid/location/ILocationManager;->removeUpdatesPI(Landroid/app/PendingIntent;Ljava/lang/String;)V
    :try_end_15
    .catch Landroid/os/RemoteException; {:try_start_a .. :try_end_15} :catch_16

    .line 1041
    :goto_15
    return-void

    .line 1038
    :catch_16
    move-exception v0

    .line 1039
    .local v0, ex:Landroid/os/RemoteException;
    const-string v1, "LocationManager"

    const-string/jumbo v2, "removeUpdates: RemoteException"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_15
.end method

.method public removeUpdates(Landroid/location/LocationListener;)V
    .registers 6
    .parameter "listener"

    .prologue
    .line 1005
    if-nez p1, :cond_a

    .line 1006
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "listener==null"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 1012
    :cond_a
    :try_start_a
    iget-object v2, p0, Landroid/location/LocationManager;->mListeners:Ljava/util/HashMap;

    invoke-virtual {v2, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/location/LocationManager$ListenerTransport;

    .line 1013
    .local v1, transport:Landroid/location/LocationManager$ListenerTransport;
    if-eqz v1, :cond_1f

    .line 1014
    iget-object v2, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    iget-object v3, p0, Landroid/location/LocationManager;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v1, v3}, Landroid/location/ILocationManager;->removeUpdates(Landroid/location/ILocationListener;Ljava/lang/String;)V
    :try_end_1f
    .catch Landroid/os/RemoteException; {:try_start_a .. :try_end_1f} :catch_20

    .line 1019
    .end local v1           #transport:Landroid/location/LocationManager$ListenerTransport;
    :cond_1f
    :goto_1f
    return-void

    .line 1016
    :catch_20
    move-exception v0

    .line 1017
    .local v0, ex:Landroid/os/RemoteException;
    const-string v2, "LocationManager"

    const-string/jumbo v3, "removeUpdates: DeadObjectException"

    invoke-static {v2, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1f
.end method

.method public requestLocationUpdates(JFLandroid/location/Criteria;Landroid/app/PendingIntent;)V
    .registers 14
    .parameter "minTime"
    .parameter "minDistance"
    .parameter "criteria"
    .parameter "intent"

    .prologue
    .line 826
    if-nez p4, :cond_a

    .line 827
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "criteria==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 829
    :cond_a
    if-nez p5, :cond_14

    .line 830
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "intent==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 832
    :cond_14
    const/4 v1, 0x0

    const/4 v6, 0x0

    move-object v0, p0

    move-object v2, p4

    move-wide v3, p1

    move v5, p3

    move-object v7, p5

    invoke-direct/range {v0 .. v7}, Landroid/location/LocationManager;->_requestLocationUpdates(Ljava/lang/String;Landroid/location/Criteria;JFZLandroid/app/PendingIntent;)V

    .line 833
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
    .line 639
    if-nez p4, :cond_a

    .line 640
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "criteria==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 642
    :cond_a
    if-nez p5, :cond_14

    .line 643
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "listener==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 645
    :cond_14
    const/4 v1, 0x0

    const/4 v6, 0x0

    move-object v0, p0

    move-object v2, p4

    move-wide v3, p1

    move v5, p3

    move-object v7, p5

    move-object v8, p6

    invoke-direct/range {v0 .. v8}, Landroid/location/LocationManager;->_requestLocationUpdates(Ljava/lang/String;Landroid/location/Criteria;JFZLandroid/location/LocationListener;Landroid/os/Looper;)V

    .line 646
    return-void
.end method

.method public requestLocationUpdates(Ljava/lang/String;JFLandroid/app/PendingIntent;)V
    .registers 14
    .parameter "provider"
    .parameter "minTime"
    .parameter "minDistance"
    .parameter "intent"

    .prologue
    .line 750
    if-nez p1, :cond_b

    .line 751
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "provider==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 753
    :cond_b
    if-nez p5, :cond_15

    .line 754
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "intent==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 756
    :cond_15
    const/4 v2, 0x0

    const/4 v6, 0x0

    move-object v0, p0

    move-object v1, p1

    move-wide v3, p2

    move v5, p4

    move-object v7, p5

    invoke-direct/range {v0 .. v7}, Landroid/location/LocationManager;->_requestLocationUpdates(Ljava/lang/String;Landroid/location/Criteria;JFZLandroid/app/PendingIntent;)V

    .line 757
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

    .line 480
    if-nez p1, :cond_c

    .line 481
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "provider==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 483
    :cond_c
    if-nez p5, :cond_16

    .line 484
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "listener==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 486
    :cond_16
    const/4 v6, 0x0

    move-object v0, p0

    move-object v1, p1

    move-wide v3, p2

    move v5, p4

    move-object v7, p5

    move-object v8, v2

    invoke-direct/range {v0 .. v8}, Landroid/location/LocationManager;->_requestLocationUpdates(Ljava/lang/String;Landroid/location/Criteria;JFZLandroid/location/LocationListener;Landroid/os/Looper;)V

    .line 487
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
    .line 565
    if-nez p1, :cond_b

    .line 566
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "provider==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 568
    :cond_b
    if-nez p5, :cond_15

    .line 569
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "listener==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 571
    :cond_15
    const/4 v2, 0x0

    const/4 v6, 0x0

    move-object v0, p0

    move-object v1, p1

    move-wide v3, p2

    move v5, p4

    move-object v7, p5

    move-object v8, p6

    invoke-direct/range {v0 .. v8}, Landroid/location/LocationManager;->_requestLocationUpdates(Ljava/lang/String;Landroid/location/Criteria;JFZLandroid/location/LocationListener;Landroid/os/Looper;)V

    .line 572
    return-void
.end method

.method public requestSingleUpdate(Landroid/location/Criteria;Landroid/app/PendingIntent;)V
    .registers 11
    .parameter "criteria"
    .parameter "intent"

    .prologue
    .line 987
    if-nez p1, :cond_a

    .line 988
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "criteria==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 990
    :cond_a
    if-nez p2, :cond_14

    .line 991
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "intent==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 993
    :cond_14
    const/4 v1, 0x0

    const-wide/16 v3, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x1

    move-object v0, p0

    move-object v2, p1

    move-object v7, p2

    invoke-direct/range {v0 .. v7}, Landroid/location/LocationManager;->_requestLocationUpdates(Ljava/lang/String;Landroid/location/Criteria;JFZLandroid/app/PendingIntent;)V

    .line 994
    return-void
.end method

.method public requestSingleUpdate(Landroid/location/Criteria;Landroid/location/LocationListener;Landroid/os/Looper;)V
    .registers 13
    .parameter "criteria"
    .parameter "listener"
    .parameter "looper"

    .prologue
    .line 919
    if-nez p1, :cond_a

    .line 920
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "criteria==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 922
    :cond_a
    if-nez p2, :cond_14

    .line 923
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "listener==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 925
    :cond_14
    const/4 v1, 0x0

    const-wide/16 v3, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x1

    move-object v0, p0

    move-object v2, p1

    move-object v7, p2

    move-object v8, p3

    invoke-direct/range {v0 .. v8}, Landroid/location/LocationManager;->_requestLocationUpdates(Ljava/lang/String;Landroid/location/Criteria;JFZLandroid/location/LocationListener;Landroid/os/Looper;)V

    .line 926
    return-void
.end method

.method public requestSingleUpdate(Ljava/lang/String;Landroid/app/PendingIntent;)V
    .registers 11
    .parameter "provider"
    .parameter "intent"

    .prologue
    .line 952
    if-nez p1, :cond_b

    .line 953
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "provider==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 955
    :cond_b
    if-nez p2, :cond_15

    .line 956
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "intent==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 958
    :cond_15
    const/4 v2, 0x0

    const-wide/16 v3, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x1

    move-object v0, p0

    move-object v1, p1

    move-object v7, p2

    invoke-direct/range {v0 .. v7}, Landroid/location/LocationManager;->_requestLocationUpdates(Ljava/lang/String;Landroid/location/Criteria;JFZLandroid/app/PendingIntent;)V

    .line 959
    return-void
.end method

.method public requestSingleUpdate(Ljava/lang/String;Landroid/location/LocationListener;Landroid/os/Looper;)V
    .registers 13
    .parameter "provider"
    .parameter "listener"
    .parameter "looper"

    .prologue
    .line 880
    if-nez p1, :cond_b

    .line 881
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "provider==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 883
    :cond_b
    if-nez p2, :cond_15

    .line 884
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "listener==null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 886
    :cond_15
    const/4 v2, 0x0

    const-wide/16 v3, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x1

    move-object v0, p0

    move-object v1, p1

    move-object v7, p2

    move-object v8, p3

    invoke-direct/range {v0 .. v8}, Landroid/location/LocationManager;->_requestLocationUpdates(Ljava/lang/String;Landroid/location/Criteria;JFZLandroid/location/LocationListener;Landroid/os/Looper;)V

    .line 887
    return-void
.end method

.method public sendExtraCommand(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Z
    .registers 7
    .parameter "provider"
    .parameter "command"
    .parameter "extras"

    .prologue
    .line 1569
    :try_start_0
    iget-object v1, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v1, p1, p2, p3}, Landroid/location/ILocationManager;->sendExtraCommand(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Z
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_7

    move-result v1

    .line 1572
    :goto_6
    return v1

    .line 1570
    :catch_7
    move-exception v0

    .line 1571
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "LocationManager"

    const-string v2, "RemoteException in sendExtraCommand: "

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 1572
    const/4 v1, 0x0

    goto :goto_6
.end method

.method public sendNiResponse(II)Z
    .registers 6
    .parameter "notifId"
    .parameter "userResponse"

    .prologue
    .line 1584
    :try_start_0
    iget-object v1, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v1, p1, p2}, Landroid/location/ILocationManager;->sendNiResponse(II)Z
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_7

    move-result v1

    .line 1587
    :goto_6
    return v1

    .line 1585
    :catch_7
    move-exception v0

    .line 1586
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "LocationManager"

    const-string v2, "RemoteException in sendNiResponse: "

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 1587
    const/4 v1, 0x0

    goto :goto_6
.end method

.method public setTestProviderEnabled(Ljava/lang/String;Z)V
    .registers 6
    .parameter "provider"
    .parameter "enabled"

    .prologue
    .line 1272
    :try_start_0
    iget-object v1, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v1, p1, p2}, Landroid/location/ILocationManager;->setTestProviderEnabled(Ljava/lang/String;Z)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    .line 1276
    :goto_5
    return-void

    .line 1273
    :catch_6
    move-exception v0

    .line 1274
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
    .line 1234
    :try_start_0
    iget-object v1, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    invoke-interface {v1, p1, p2}, Landroid/location/ILocationManager;->setTestProviderLocation(Ljava/lang/String;Landroid/location/Location;)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    .line 1238
    :goto_5
    return-void

    .line 1235
    :catch_6
    move-exception v0

    .line 1236
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
    .line 1313
    :try_start_0
    iget-object v0, p0, Landroid/location/LocationManager;->mService:Landroid/location/ILocationManager;

    move-object v1, p1

    move v2, p2

    move-object v3, p3

    move-wide v4, p4

    invoke-interface/range {v0 .. v5}, Landroid/location/ILocationManager;->setTestProviderStatus(Ljava/lang/String;ILandroid/os/Bundle;J)V
    :try_end_9
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_9} :catch_a

    .line 1317
    :goto_9
    return-void

    .line 1314
    :catch_a
    move-exception v6

    .line 1315
    .local v6, ex:Landroid/os/RemoteException;
    const-string v0, "LocationManager"

    const-string/jumbo v1, "setTestProviderStatus: RemoteException"

    invoke-static {v0, v1, v6}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_9
.end method
