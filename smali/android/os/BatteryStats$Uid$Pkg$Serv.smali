.class public abstract Landroid/os/BatteryStats$Uid$Pkg$Serv;
.super Ljava/lang/Object;
.source "BatteryStats.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/os/BatteryStats$Uid$Pkg;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401
    name = "Serv"
.end annotation


# instance fields
.field final synthetic this$0:Landroid/os/BatteryStats$Uid$Pkg;


# direct methods
.method public constructor <init>(Landroid/os/BatteryStats$Uid$Pkg;)V
    .registers 2
    .parameter

    .prologue
    .line 383
    iput-object p1, p0, Landroid/os/BatteryStats$Uid$Pkg$Serv;->this$0:Landroid/os/BatteryStats$Uid$Pkg;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public abstract getLaunches(I)I
.end method

.method public abstract getStartTime(JI)J
.end method

.method public abstract getStarts(I)I
.end method
