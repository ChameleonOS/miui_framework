.class public Landroid/net/ThrottleManager;
.super Ljava/lang/Object;
.source "ThrottleManager.java"


# static fields
.field public static final DIRECTION_RX:I = 0x1

.field public static final DIRECTION_TX:I = 0x0

.field public static final EXTRA_CYCLE_END:Ljava/lang/String; = "cycleEnd"

.field public static final EXTRA_CYCLE_READ:Ljava/lang/String; = "cycleRead"

.field public static final EXTRA_CYCLE_START:Ljava/lang/String; = "cycleStart"

.field public static final EXTRA_CYCLE_WRITE:Ljava/lang/String; = "cycleWrite"

.field public static final EXTRA_THROTTLE_LEVEL:Ljava/lang/String; = "level"

.field public static final PERIOD_24HOUR:I = 0x6

.field public static final PERIOD_60MIN:I = 0x8

.field public static final PERIOD_60SEC:I = 0xa

.field public static final PERIOD_7DAY:I = 0x4

.field public static final PERIOD_CYCLE:I = 0x0

.field public static final PERIOD_DAY:I = 0x5

.field public static final PERIOD_HOUR:I = 0x7

.field public static final PERIOD_MINUTE:I = 0x9

.field public static final PERIOD_MONTH:I = 0x2

.field public static final PERIOD_SECOND:I = 0xb

.field public static final PERIOD_WEEK:I = 0x3

.field public static final PERIOD_YEAR:I = 0x1

.field public static final POLICY_CHANGED_ACTION:Ljava/lang/String; = "android.net.thrott.POLICY_CHANGED_ACTION"

.field public static final THROTTLE_ACTION:Ljava/lang/String; = "android.net.thrott.THROTTLE_ACTION"

.field public static final THROTTLE_POLL_ACTION:Ljava/lang/String; = "android.net.thrott.POLL_ACTION"


# instance fields
.field private mService:Landroid/net/IThrottleManager;


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public constructor <init>(Landroid/net/IThrottleManager;)V
    .registers 4
    .parameter "service"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    if-nez p1, :cond_d

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "ThrottleManager() cannot be constructed with null service"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_d
    iput-object p1, p0, Landroid/net/ThrottleManager;->mService:Landroid/net/IThrottleManager;

    return-void
.end method


# virtual methods
.method public getByteCount(Ljava/lang/String;III)J
    .registers 8
    .parameter "iface"
    .parameter "direction"
    .parameter "period"
    .parameter "ago"

    .prologue
    :try_start_0
    iget-object v1, p0, Landroid/net/ThrottleManager;->mService:Landroid/net/IThrottleManager;

    invoke-interface {v1, p1, p2, p3, p4}, Landroid/net/IThrottleManager;->getByteCount(Ljava/lang/String;III)J
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_7

    move-result-wide v1

    :goto_6
    return-wide v1

    :catch_7
    move-exception v0

    .local v0, e:Landroid/os/RemoteException;
    const-wide/16 v1, -0x1

    goto :goto_6
.end method

.method public getCliffLevel(Ljava/lang/String;I)I
    .registers 5
    .parameter "iface"
    .parameter "cliff"

    .prologue
    :try_start_0
    iget-object v1, p0, Landroid/net/ThrottleManager;->mService:Landroid/net/IThrottleManager;

    invoke-interface {v1, p1, p2}, Landroid/net/IThrottleManager;->getCliffLevel(Ljava/lang/String;I)I
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_7

    move-result v1

    :goto_6
    return v1

    :catch_7
    move-exception v0

    .local v0, e:Landroid/os/RemoteException;
    const/4 v1, -0x1

    goto :goto_6
.end method

.method public getCliffThreshold(Ljava/lang/String;I)J
    .registers 6
    .parameter "iface"
    .parameter "cliff"

    .prologue
    :try_start_0
    iget-object v1, p0, Landroid/net/ThrottleManager;->mService:Landroid/net/IThrottleManager;

    invoke-interface {v1, p1, p2}, Landroid/net/IThrottleManager;->getCliffThreshold(Ljava/lang/String;I)J
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_7

    move-result-wide v1

    :goto_6
    return-wide v1

    :catch_7
    move-exception v0

    .local v0, e:Landroid/os/RemoteException;
    const-wide/16 v1, -0x1

    goto :goto_6
.end method

.method public getHelpUri()Ljava/lang/String;
    .registers 3

    .prologue
    :try_start_0
    iget-object v1, p0, Landroid/net/ThrottleManager;->mService:Landroid/net/IThrottleManager;

    invoke-interface {v1}, Landroid/net/IThrottleManager;->getHelpUri()Ljava/lang/String;
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_7

    move-result-object v1

    :goto_6
    return-object v1

    :catch_7
    move-exception v0

    .local v0, e:Landroid/os/RemoteException;
    const/4 v1, 0x0

    goto :goto_6
.end method

.method public getPeriodStartTime(Ljava/lang/String;)J
    .registers 5
    .parameter "iface"

    .prologue
    :try_start_0
    iget-object v1, p0, Landroid/net/ThrottleManager;->mService:Landroid/net/IThrottleManager;

    invoke-interface {v1, p1}, Landroid/net/IThrottleManager;->getPeriodStartTime(Ljava/lang/String;)J
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_7

    move-result-wide v1

    :goto_6
    return-wide v1

    :catch_7
    move-exception v0

    .local v0, e:Landroid/os/RemoteException;
    const-wide/16 v1, -0x1

    goto :goto_6
.end method

.method public getResetTime(Ljava/lang/String;)J
    .registers 5
    .parameter "iface"

    .prologue
    :try_start_0
    iget-object v1, p0, Landroid/net/ThrottleManager;->mService:Landroid/net/IThrottleManager;

    invoke-interface {v1, p1}, Landroid/net/IThrottleManager;->getResetTime(Ljava/lang/String;)J
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_7

    move-result-wide v1

    :goto_6
    return-wide v1

    :catch_7
    move-exception v0

    .local v0, e:Landroid/os/RemoteException;
    const-wide/16 v1, -0x1

    goto :goto_6
.end method
