.class public abstract Landroid/os/BatteryStats$Uid$Wakelock;
.super Ljava/lang/Object;
.source "BatteryStats.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/os/BatteryStats$Uid;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Wakelock"
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 214
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public abstract getWakeTime(I)Landroid/os/BatteryStats$Timer;
.end method
