.class public Landroid/os/SystemService;
.super Ljava/lang/Object;
.source "SystemService.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 20
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static restart(Ljava/lang/String;)V
    .registers 2
    .parameter "name"

    .prologue
    .line 34
    const-string v0, "ctl.restart"

    invoke-static {v0, p0}, Landroid/os/SystemProperties;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 35
    return-void
.end method

.method public static start(Ljava/lang/String;)V
    .registers 2
    .parameter "name"

    .prologue
    .line 24
    const-string v0, "ctl.start"

    invoke-static {v0, p0}, Landroid/os/SystemProperties;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 25
    return-void
.end method

.method public static stop(Ljava/lang/String;)V
    .registers 2
    .parameter "name"

    .prologue
    .line 29
    const-string v0, "ctl.stop"

    invoke-static {v0, p0}, Landroid/os/SystemProperties;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 30
    return-void
.end method
