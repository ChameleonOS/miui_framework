.class Lcom/android/internal/os/BatteryStatsImpl$KernelWakelockStats;
.super Ljava/lang/Object;
.source "BatteryStatsImpl.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/os/BatteryStatsImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "KernelWakelockStats"
.end annotation


# instance fields
.field public mCount:I

.field public mTotalTime:J

.field public mVersion:I

.field final synthetic this$0:Lcom/android/internal/os/BatteryStatsImpl;


# direct methods
.method constructor <init>(Lcom/android/internal/os/BatteryStatsImpl;IJI)V
    .registers 6
    .parameter
    .parameter "count"
    .parameter "totalTime"
    .parameter "version"

    .prologue
    .line 1141
    iput-object p1, p0, Lcom/android/internal/os/BatteryStatsImpl$KernelWakelockStats;->this$0:Lcom/android/internal/os/BatteryStatsImpl;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 1142
    iput p2, p0, Lcom/android/internal/os/BatteryStatsImpl$KernelWakelockStats;->mCount:I

    .line 1143
    iput-wide p3, p0, Lcom/android/internal/os/BatteryStatsImpl$KernelWakelockStats;->mTotalTime:J

    .line 1144
    iput p5, p0, Lcom/android/internal/os/BatteryStatsImpl$KernelWakelockStats;->mVersion:I

    .line 1145
    return-void
.end method
