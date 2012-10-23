.class final Landroid/app/Instrumentation$InstrumentationThread;
.super Ljava/lang/Thread;
.source "Instrumentation.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/app/Instrumentation;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "InstrumentationThread"
.end annotation


# instance fields
.field final synthetic this$0:Landroid/app/Instrumentation;


# direct methods
.method public constructor <init>(Landroid/app/Instrumentation;Ljava/lang/String;)V
    .registers 3
    .parameter
    .parameter "name"

    .prologue
    .line 1570
    iput-object p1, p0, Landroid/app/Instrumentation$InstrumentationThread;->this$0:Landroid/app/Instrumentation;

    .line 1571
    invoke-direct {p0, p2}, Ljava/lang/Thread;-><init>(Ljava/lang/String;)V

    .line 1572
    return-void
.end method


# virtual methods
.method public run()V
    .registers 6

    .prologue
    .line 1574
    invoke-static {}, Landroid/app/ActivityManagerNative;->getDefault()Landroid/app/IActivityManager;

    move-result-object v0

    .line 1576
    .local v0, am:Landroid/app/IActivityManager;
    const/4 v2, -0x8

    :try_start_5
    invoke-static {v2}, Landroid/os/Process;->setThreadPriority(I)V
    :try_end_8
    .catch Ljava/lang/RuntimeException; {:try_start_5 .. :try_end_8} :catch_1b

    .line 1581
    :goto_8
    iget-object v2, p0, Landroid/app/Instrumentation$InstrumentationThread;->this$0:Landroid/app/Instrumentation;

    #getter for: Landroid/app/Instrumentation;->mAutomaticPerformanceSnapshots:Z
    invoke-static {v2}, Landroid/app/Instrumentation;->access$100(Landroid/app/Instrumentation;)Z

    move-result v2

    if-eqz v2, :cond_15

    .line 1582
    iget-object v2, p0, Landroid/app/Instrumentation$InstrumentationThread;->this$0:Landroid/app/Instrumentation;

    invoke-virtual {v2}, Landroid/app/Instrumentation;->startPerformanceSnapshot()V

    .line 1584
    :cond_15
    iget-object v2, p0, Landroid/app/Instrumentation$InstrumentationThread;->this$0:Landroid/app/Instrumentation;

    invoke-virtual {v2}, Landroid/app/Instrumentation;->onStart()V

    .line 1585
    return-void

    .line 1577
    :catch_1b
    move-exception v1

    .line 1578
    .local v1, e:Ljava/lang/RuntimeException;
    const-string v2, "Instrumentation"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Exception setting priority of instrumentation thread "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {}, Landroid/os/Process;->myTid()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_8
.end method
