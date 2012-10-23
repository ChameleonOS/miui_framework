.class public final Landroid/location/GpsStatus;
.super Ljava/lang/Object;
.source "GpsStatus.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/location/GpsStatus$NmeaListener;,
        Landroid/location/GpsStatus$Listener;,
        Landroid/location/GpsStatus$SatelliteIterator;
    }
.end annotation


# static fields
.field public static final GPS_EVENT_FIRST_FIX:I = 0x3

.field public static final GPS_EVENT_SATELLITE_STATUS:I = 0x4

.field public static final GPS_EVENT_STARTED:I = 0x1

.field public static final GPS_EVENT_STOPPED:I = 0x2

.field private static final NUM_SATELLITES:I = 0xff


# instance fields
.field private mSatelliteList:Ljava/lang/Iterable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Iterable",
            "<",
            "Landroid/location/GpsSatellite;",
            ">;"
        }
    .end annotation
.end field

.field private mSatellites:[Landroid/location/GpsSatellite;

.field private mTimeToFirstFix:I


# direct methods
.method constructor <init>()V
    .registers 5

    .prologue
    .line 130
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 32
    const/16 v1, 0xff

    new-array v1, v1, [Landroid/location/GpsSatellite;

    iput-object v1, p0, Landroid/location/GpsStatus;->mSatellites:[Landroid/location/GpsSatellite;

    .line 67
    new-instance v1, Landroid/location/GpsStatus$1;

    invoke-direct {v1, p0}, Landroid/location/GpsStatus$1;-><init>(Landroid/location/GpsStatus;)V

    iput-object v1, p0, Landroid/location/GpsStatus;->mSatelliteList:Ljava/lang/Iterable;

    .line 131
    const/4 v0, 0x0

    .local v0, i:I
    :goto_11
    iget-object v1, p0, Landroid/location/GpsStatus;->mSatellites:[Landroid/location/GpsSatellite;

    array-length v1, v1

    if-ge v0, v1, :cond_24

    .line 132
    iget-object v1, p0, Landroid/location/GpsStatus;->mSatellites:[Landroid/location/GpsSatellite;

    new-instance v2, Landroid/location/GpsSatellite;

    add-int/lit8 v3, v0, 0x1

    invoke-direct {v2, v3}, Landroid/location/GpsSatellite;-><init>(I)V

    aput-object v2, v1, v0

    .line 131
    add-int/lit8 v0, v0, 0x1

    goto :goto_11

    .line 134
    :cond_24
    return-void
.end method

.method static synthetic access$000(Landroid/location/GpsStatus;)[Landroid/location/GpsSatellite;
    .registers 2
    .parameter "x0"

    .prologue
    .line 27
    iget-object v0, p0, Landroid/location/GpsStatus;->mSatellites:[Landroid/location/GpsSatellite;

    return-object v0
.end method


# virtual methods
.method public getMaxSatellites()I
    .registers 2

    .prologue
    .line 212
    const/16 v0, 0xff

    return v0
.end method

.method public getSatellites()Ljava/lang/Iterable;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Iterable",
            "<",
            "Landroid/location/GpsSatellite;",
            ">;"
        }
    .end annotation

    .prologue
    .line 202
    iget-object v0, p0, Landroid/location/GpsStatus;->mSatelliteList:Ljava/lang/Iterable;

    return-object v0
.end method

.method public getTimeToFirstFix()I
    .registers 2

    .prologue
    .line 192
    iget v0, p0, Landroid/location/GpsStatus;->mTimeToFirstFix:I

    return v0
.end method

.method declared-synchronized setStatus(I[I[F[F[FIII)V
    .registers 15
    .parameter "svCount"
    .parameter "prns"
    .parameter "snrs"
    .parameter "elevations"
    .parameter "azimuths"
    .parameter "ephemerisMask"
    .parameter "almanacMask"
    .parameter "usedInFixMask"

    .prologue
    .line 146
    monitor-enter p0

    const/4 v0, 0x0

    .local v0, i:I
    :goto_2
    :try_start_2
    iget-object v4, p0, Landroid/location/GpsStatus;->mSatellites:[Landroid/location/GpsSatellite;

    array-length v4, v4

    if-ge v0, v4, :cond_11

    .line 147
    iget-object v4, p0, Landroid/location/GpsStatus;->mSatellites:[Landroid/location/GpsSatellite;

    aget-object v4, v4, v0

    const/4 v5, 0x0

    iput-boolean v5, v4, Landroid/location/GpsSatellite;->mValid:Z

    .line 146
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 150
    :cond_11
    const/4 v0, 0x0

    :goto_12
    if-ge v0, p1, :cond_53

    .line 151
    aget v4, p2, v0

    add-int/lit8 v1, v4, -0x1

    .line 152
    .local v1, prn:I
    const/4 v4, 0x1

    shl-int v2, v4, v1

    .line 153
    .local v2, prnShift:I
    if-ltz v1, :cond_4a

    iget-object v4, p0, Landroid/location/GpsStatus;->mSatellites:[Landroid/location/GpsSatellite;

    array-length v4, v4

    if-ge v1, v4, :cond_4a

    .line 154
    iget-object v4, p0, Landroid/location/GpsStatus;->mSatellites:[Landroid/location/GpsSatellite;

    aget-object v3, v4, v1

    .line 156
    .local v3, satellite:Landroid/location/GpsSatellite;
    const/4 v4, 0x1

    iput-boolean v4, v3, Landroid/location/GpsSatellite;->mValid:Z

    .line 157
    aget v4, p3, v0

    iput v4, v3, Landroid/location/GpsSatellite;->mSnr:F

    .line 158
    aget v4, p4, v0

    iput v4, v3, Landroid/location/GpsSatellite;->mElevation:F

    .line 159
    aget v4, p5, v0

    iput v4, v3, Landroid/location/GpsSatellite;->mAzimuth:F

    .line 160
    and-int v4, p6, v2

    if-eqz v4, :cond_4d

    const/4 v4, 0x1

    :goto_3a
    iput-boolean v4, v3, Landroid/location/GpsSatellite;->mHasEphemeris:Z

    .line 161
    and-int v4, p7, v2

    if-eqz v4, :cond_4f

    const/4 v4, 0x1

    :goto_41
    iput-boolean v4, v3, Landroid/location/GpsSatellite;->mHasAlmanac:Z

    .line 162
    and-int v4, p8, v2

    if-eqz v4, :cond_51

    const/4 v4, 0x1

    :goto_48
    iput-boolean v4, v3, Landroid/location/GpsSatellite;->mUsedInFix:Z
    :try_end_4a
    .catchall {:try_start_2 .. :try_end_4a} :catchall_55

    .line 150
    .end local v3           #satellite:Landroid/location/GpsSatellite;
    :cond_4a
    add-int/lit8 v0, v0, 0x1

    goto :goto_12

    .line 160
    .restart local v3       #satellite:Landroid/location/GpsSatellite;
    :cond_4d
    const/4 v4, 0x0

    goto :goto_3a

    .line 161
    :cond_4f
    const/4 v4, 0x0

    goto :goto_41

    .line 162
    :cond_51
    const/4 v4, 0x0

    goto :goto_48

    .line 165
    .end local v1           #prn:I
    .end local v2           #prnShift:I
    .end local v3           #satellite:Landroid/location/GpsSatellite;
    :cond_53
    monitor-exit p0

    return-void

    .line 146
    :catchall_55
    move-exception v4

    monitor-exit p0

    throw v4
.end method

.method setStatus(Landroid/location/GpsStatus;)V
    .registers 5
    .parameter "status"

    .prologue
    .line 174
    invoke-virtual {p1}, Landroid/location/GpsStatus;->getTimeToFirstFix()I

    move-result v1

    iput v1, p0, Landroid/location/GpsStatus;->mTimeToFirstFix:I

    .line 176
    const/4 v0, 0x0

    .local v0, i:I
    :goto_7
    iget-object v1, p0, Landroid/location/GpsStatus;->mSatellites:[Landroid/location/GpsSatellite;

    array-length v1, v1

    if-ge v0, v1, :cond_1a

    .line 177
    iget-object v1, p0, Landroid/location/GpsStatus;->mSatellites:[Landroid/location/GpsSatellite;

    aget-object v1, v1, v0

    iget-object v2, p1, Landroid/location/GpsStatus;->mSatellites:[Landroid/location/GpsSatellite;

    aget-object v2, v2, v0

    invoke-virtual {v1, v2}, Landroid/location/GpsSatellite;->setStatus(Landroid/location/GpsSatellite;)V

    .line 176
    add-int/lit8 v0, v0, 0x1

    goto :goto_7

    .line 179
    :cond_1a
    return-void
.end method

.method setTimeToFirstFix(I)V
    .registers 2
    .parameter "ttff"

    .prologue
    .line 182
    iput p1, p0, Landroid/location/GpsStatus;->mTimeToFirstFix:I

    .line 183
    return-void
.end method
