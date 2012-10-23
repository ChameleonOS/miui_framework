.class public abstract Landroid/location/LocationProvider;
.super Ljava/lang/Object;
.source "LocationProvider.java"


# static fields
.field public static final AVAILABLE:I = 0x2

.field static final BAD_CHARS_REGEX:Ljava/lang/String; = "[^a-zA-Z0-9]"

.field public static final OUT_OF_SERVICE:I = 0x0

.field private static final TAG:Ljava/lang/String; = "LocationProvider"

.field public static final TEMPORARILY_UNAVAILABLE:I = 0x1


# instance fields
.field private final mName:Ljava/lang/String;

.field private final mService:Landroid/location/ILocationManager;


# direct methods
.method public constructor <init>(Ljava/lang/String;Landroid/location/ILocationManager;)V
    .registers 6
    .parameter "name"
    .parameter "service"

    .prologue
    .line 57
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 58
    const-string v0, "[^a-zA-Z0-9]"

    invoke-virtual {p1, v0}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2b

    .line 59
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "name "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " contains an illegal character"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 62
    :cond_2b
    iput-object p1, p0, Landroid/location/LocationProvider;->mName:Ljava/lang/String;

    .line 63
    iput-object p2, p0, Landroid/location/LocationProvider;->mService:Landroid/location/ILocationManager;

    .line 64
    return-void
.end method


# virtual methods
.method public abstract getAccuracy()I
.end method

.method public getName()Ljava/lang/String;
    .registers 2

    .prologue
    .line 70
    iget-object v0, p0, Landroid/location/LocationProvider;->mName:Ljava/lang/String;

    return-object v0
.end method

.method public abstract getPowerRequirement()I
.end method

.method public abstract hasMonetaryCost()Z
.end method

.method public meetsCriteria(Landroid/location/Criteria;)Z
    .registers 5
    .parameter "criteria"

    .prologue
    .line 79
    :try_start_0
    iget-object v1, p0, Landroid/location/LocationProvider;->mService:Landroid/location/ILocationManager;

    iget-object v2, p0, Landroid/location/LocationProvider;->mName:Ljava/lang/String;

    invoke-interface {v1, v2, p1}, Landroid/location/ILocationManager;->providerMeetsCriteria(Ljava/lang/String;Landroid/location/Criteria;)Z
    :try_end_7
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_7} :catch_9

    move-result v1

    .line 82
    :goto_8
    return v1

    .line 80
    :catch_9
    move-exception v0

    .line 81
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "LocationProvider"

    const-string/jumbo v2, "meetsCriteria: RemoteException"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 82
    const/4 v1, 0x0

    goto :goto_8
.end method

.method public abstract requiresCell()Z
.end method

.method public abstract requiresNetwork()Z
.end method

.method public abstract requiresSatellite()Z
.end method

.method public abstract supportsAltitude()Z
.end method

.method public abstract supportsBearing()Z
.end method

.method public abstract supportsSpeed()Z
.end method
