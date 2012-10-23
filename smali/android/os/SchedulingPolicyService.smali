.class public Landroid/os/SchedulingPolicyService;
.super Landroid/os/ISchedulingPolicyService$Stub;
.source "SchedulingPolicyService.java"


# static fields
.field private static final PRIORITY_MAX:I = 0x2

.field private static final PRIORITY_MIN:I = 0x1

.field private static final TAG:Ljava/lang/String; = "SchedulingPolicyService"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 38
    invoke-direct {p0}, Landroid/os/ISchedulingPolicyService$Stub;-><init>()V

    .line 39
    return-void
.end method


# virtual methods
.method public requestPriority(III)I
    .registers 9
    .parameter "pid"
    .parameter "tid"
    .parameter "prio"

    .prologue
    const/4 v4, 0x1

    const/4 v1, -0x1

    .line 49
    invoke-static {}, Landroid/os/Binder;->getCallingUid()I

    move-result v2

    const/16 v3, 0x3f5

    if-ne v2, v3, :cond_15

    if-lt p3, v4, :cond_15

    const/4 v2, 0x2

    if-gt p3, v2, :cond_15

    invoke-static {p2}, Landroid/os/Process;->getThreadGroupLeader(I)I

    move-result v2

    if-eq v2, p1, :cond_16

    .line 62
    :cond_15
    :goto_15
    return v1

    .line 55
    :cond_16
    :try_start_16
    invoke-static {}, Landroid/os/Binder;->getCallingPid()I

    move-result v2

    if-ne v2, p1, :cond_26

    const/4 v2, 0x4

    :goto_1d
    invoke-static {p2, v2}, Landroid/os/Process;->setThreadGroup(II)V

    .line 58
    const/4 v2, 0x1

    invoke-static {p2, v2, p3}, Landroid/os/Process;->setThreadScheduler(III)V
    :try_end_24
    .catch Ljava/lang/RuntimeException; {:try_start_16 .. :try_end_24} :catch_28

    .line 62
    const/4 v1, 0x0

    goto :goto_15

    .line 55
    :cond_26
    const/4 v2, 0x3

    goto :goto_1d

    .line 59
    :catch_28
    move-exception v0

    .line 60
    .local v0, e:Ljava/lang/RuntimeException;
    goto :goto_15
.end method
