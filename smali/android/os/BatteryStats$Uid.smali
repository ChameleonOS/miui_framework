.class public abstract Landroid/os/BatteryStats$Uid;
.super Ljava/lang/Object;
.source "BatteryStats.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/os/BatteryStats;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Uid"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/os/BatteryStats$Uid$Pkg;,
        Landroid/os/BatteryStats$Uid$Proc;,
        Landroid/os/BatteryStats$Uid$Pid;,
        Landroid/os/BatteryStats$Uid$Sensor;,
        Landroid/os/BatteryStats$Uid$Wakelock;
    }
.end annotation


# static fields
.field public static final NUM_USER_ACTIVITY_TYPES:I = 0x7

.field static final USER_ACTIVITY_TYPES:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 3

    .prologue
    .line 282
    const/4 v0, 0x7

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string/jumbo v2, "other"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "cheek"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string/jumbo v2, "touch"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "long_touch"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string/jumbo v2, "touch_up"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string v2, "button"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string/jumbo v2, "unknown"

    aput-object v2, v0, v1

    sput-object v0, Landroid/os/BatteryStats$Uid;->USER_ACTIVITY_TYPES:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 202
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 365
    return-void
.end method


# virtual methods
.method public abstract getAudioTurnedOnTime(JI)J
.end method

.method public abstract getFullWifiLockTime(JI)J
.end method

.method public abstract getPackageStats()Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "+",
            "Landroid/os/BatteryStats$Uid$Pkg;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getPidStats()Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroid/util/SparseArray",
            "<+",
            "Landroid/os/BatteryStats$Uid$Pid;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getProcessStats()Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "+",
            "Landroid/os/BatteryStats$Uid$Proc;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getScanWifiLockTime(JI)J
.end method

.method public abstract getSensorStats()Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "+",
            "Landroid/os/BatteryStats$Uid$Sensor;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getTcpBytesReceived(I)J
.end method

.method public abstract getTcpBytesSent(I)J
.end method

.method public abstract getUid()I
.end method

.method public abstract getUserActivityCount(II)I
.end method

.method public abstract getVideoTurnedOnTime(JI)J
.end method

.method public abstract getWakelockStats()Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "+",
            "Landroid/os/BatteryStats$Uid$Wakelock;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getWifiMulticastTime(JI)J
.end method

.method public abstract getWifiRunningTime(JI)J
.end method

.method public abstract hasUserActivity()Z
.end method

.method public abstract noteAudioTurnedOffLocked()V
.end method

.method public abstract noteAudioTurnedOnLocked()V
.end method

.method public abstract noteFullWifiLockAcquiredLocked()V
.end method

.method public abstract noteFullWifiLockReleasedLocked()V
.end method

.method public abstract noteScanWifiLockAcquiredLocked()V
.end method

.method public abstract noteScanWifiLockReleasedLocked()V
.end method

.method public abstract noteUserActivityLocked(I)V
.end method

.method public abstract noteVideoTurnedOffLocked()V
.end method

.method public abstract noteVideoTurnedOnLocked()V
.end method

.method public abstract noteWifiMulticastDisabledLocked()V
.end method

.method public abstract noteWifiMulticastEnabledLocked()V
.end method

.method public abstract noteWifiRunningLocked()V
.end method

.method public abstract noteWifiStoppedLocked()V
.end method
