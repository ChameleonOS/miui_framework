.class public final Lmiui/util/Jlog;
.super Ljava/lang/Object;
.source "Jlog.java"


# static fields
.field private static final LOG_ID_MIUI:I = 0x4

.field private static sUsageStatsService:Lcom/android/internal/app/IUsageStats;


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static d(Ljava/lang/String;Ljava/lang/String;)I
    .registers 3
    .parameter "tag"
    .parameter "msg"

    .prologue
    const/4 v0, 0x0

    return v0
.end method

.method public static d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    .registers 4
    .parameter "tag"
    .parameter "msg"
    .parameter "tr"

    .prologue
    const/4 v0, 0x0

    return v0
.end method

.method public static e(Ljava/lang/String;Ljava/lang/String;)I
    .registers 3
    .parameter "tag"
    .parameter "msg"

    .prologue
    const/4 v0, 0x0

    return v0
.end method

.method public static e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    .registers 4
    .parameter "tag"
    .parameter "msg"
    .parameter "tr"

    .prologue
    const/4 v0, 0x0

    return v0
.end method

.method public static i(Ljava/lang/String;Ljava/lang/String;)I
    .registers 3
    .parameter "tag"
    .parameter "msg"

    .prologue
    const/4 v0, 0x0

    return v0
.end method

.method public static i(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    .registers 4
    .parameter "tag"
    .parameter "msg"
    .parameter "tr"

    .prologue
    const/4 v0, 0x0

    return v0
.end method

.method public static println(ILjava/lang/String;Ljava/lang/String;)I
    .registers 4
    .parameter "priority"
    .parameter "tag"
    .parameter "msg"

    .prologue
    const/4 v0, 0x0

    return v0
.end method

.method public static usage(Landroid/content/Context;Ljava/lang/String;)V
    .registers 7
    .parameter "context"
    .parameter "msg"

    .prologue
    sget-object v1, Lmiui/util/Jlog;->sUsageStatsService:Lcom/android/internal/app/IUsageStats;

    if-nez v1, :cond_11

    const-string/jumbo v1, "usagestats"

    invoke-static {v1}, Landroid/os/ServiceManager;->getService(Ljava/lang/String;)Landroid/os/IBinder;

    move-result-object v1

    invoke-static {v1}, Lcom/android/internal/app/IUsageStats$Stub;->asInterface(Landroid/os/IBinder;)Lcom/android/internal/app/IUsageStats;

    move-result-object v1

    sput-object v1, Lmiui/util/Jlog;->sUsageStatsService:Lcom/android/internal/app/IUsageStats;

    :cond_11
    new-instance v0, Landroid/content/ComponentName;

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "#"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    invoke-virtual {v2, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .local v0, componentName:Landroid/content/ComponentName;
    :try_start_3b
    sget-object v1, Lmiui/util/Jlog;->sUsageStatsService:Lcom/android/internal/app/IUsageStats;

    const/4 v2, 0x0

    invoke-interface {v1, v0, v2}, Lcom/android/internal/app/IUsageStats;->noteLaunchTime(Landroid/content/ComponentName;I)V
    :try_end_41
    .catch Landroid/os/RemoteException; {:try_start_3b .. :try_end_41} :catch_42

    :goto_41
    return-void

    :catch_42
    move-exception v1

    goto :goto_41
.end method

.method public static w(Ljava/lang/String;Ljava/lang/String;)I
    .registers 3
    .parameter "tag"
    .parameter "msg"

    .prologue
    const/4 v0, 0x0

    return v0
.end method

.method public static w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    .registers 4
    .parameter "tag"
    .parameter "msg"
    .parameter "tr"

    .prologue
    const/4 v0, 0x0

    return v0
.end method

.method public static w(Ljava/lang/String;Ljava/lang/Throwable;)I
    .registers 3
    .parameter "tag"
    .parameter "tr"

    .prologue
    const/4 v0, 0x0

    return v0
.end method
