.class public abstract Landroid/os/BatteryStats$Uid$Pkg;
.super Ljava/lang/Object;
.source "BatteryStats.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/os/BatteryStats$Uid;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Pkg"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/os/BatteryStats$Uid$Pkg$Serv;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 365
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 383
    return-void
.end method


# virtual methods
.method public abstract getServiceStats()Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "+",
            "Landroid/os/BatteryStats$Uid$Pkg$Serv;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getWakeups(I)I
.end method
