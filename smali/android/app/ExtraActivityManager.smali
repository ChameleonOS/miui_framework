.class public Landroid/app/ExtraActivityManager;
.super Ljava/lang/Object;
.source "ExtraActivityManager.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 11
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static isHighEndGfx(Landroid/view/Display;)Z
    .registers 3
    .parameter "display"

    .prologue
    .line 14
    const-string v0, "crespo"

    sget-object v1, Landroid/os/Build;->DEVICE:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_c

    .line 15
    const/4 v0, 0x1

    .line 18
    :goto_b
    return v0

    :cond_c
    const/4 v0, 0x0

    goto :goto_b
.end method

.method public static useHardwareAccelerationOnKeyguard(Landroid/content/Context;)Z
    .registers 2
    .parameter "context"

    .prologue
    .line 24
    const/4 v0, 0x0

    return v0
.end method
