.class public Lcom/android/internal/os/BatteryStatsImpl$SamplingCounter;
.super Lcom/android/internal/os/BatteryStatsImpl$Counter;
.source "BatteryStatsImpl.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/os/BatteryStatsImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SamplingCounter"
.end annotation


# direct methods
.method constructor <init>(Ljava/util/ArrayList;)V
    .registers 2
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/internal/os/BatteryStatsImpl$Unpluggable;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 471
    .local p1, unpluggables:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Lcom/android/internal/os/BatteryStatsImpl$Unpluggable;>;"
    invoke-direct {p0, p1}, Lcom/android/internal/os/BatteryStatsImpl$Counter;-><init>(Ljava/util/ArrayList;)V

    .line 472
    return-void
.end method

.method constructor <init>(Ljava/util/ArrayList;Landroid/os/Parcel;)V
    .registers 3
    .parameter
    .parameter "in"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/internal/os/BatteryStatsImpl$Unpluggable;",
            ">;",
            "Landroid/os/Parcel;",
            ")V"
        }
    .end annotation

    .prologue
    .line 467
    .local p1, unpluggables:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Lcom/android/internal/os/BatteryStatsImpl$Unpluggable;>;"
    invoke-direct {p0, p1, p2}, Lcom/android/internal/os/BatteryStatsImpl$Counter;-><init>(Ljava/util/ArrayList;Landroid/os/Parcel;)V

    .line 468
    return-void
.end method


# virtual methods
.method public addCountAtomic(J)V
    .registers 5
    .parameter "count"

    .prologue
    .line 475
    iget-object v0, p0, Lcom/android/internal/os/BatteryStatsImpl$Counter;->mCount:Ljava/util/concurrent/atomic/AtomicInteger;

    long-to-int v1, p1

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;->addAndGet(I)I

    .line 476
    return-void
.end method
