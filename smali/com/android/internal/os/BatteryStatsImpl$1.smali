.class Lcom/android/internal/os/BatteryStatsImpl$1;
.super Ljava/lang/Thread;
.source "BatteryStatsImpl.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/internal/os/BatteryStatsImpl;->writeLocked(Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/internal/os/BatteryStatsImpl;


# direct methods
.method constructor <init>(Lcom/android/internal/os/BatteryStatsImpl;Ljava/lang/String;)V
    .registers 3
    .parameter
    .parameter "x0"

    .prologue
    .line 4849
    iput-object p1, p0, Lcom/android/internal/os/BatteryStatsImpl$1;->this$0:Lcom/android/internal/os/BatteryStatsImpl;

    invoke-direct {p0, p2}, Ljava/lang/Thread;-><init>(Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 2

    .prologue
    .line 4852
    const/16 v0, 0xa

    invoke-static {v0}, Landroid/os/Process;->setThreadPriority(I)V

    .line 4853
    iget-object v0, p0, Lcom/android/internal/os/BatteryStatsImpl$1;->this$0:Lcom/android/internal/os/BatteryStatsImpl;

    invoke-virtual {v0}, Lcom/android/internal/os/BatteryStatsImpl;->commitPendingDataToDisk()V

    .line 4854
    return-void
.end method
