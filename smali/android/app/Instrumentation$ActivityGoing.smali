.class final Landroid/app/Instrumentation$ActivityGoing;
.super Ljava/lang/Object;
.source "Instrumentation.java"

# interfaces
.implements Landroid/os/MessageQueue$IdleHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/app/Instrumentation;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "ActivityGoing"
.end annotation


# instance fields
.field private final mWaiter:Landroid/app/Instrumentation$ActivityWaiter;

.field final synthetic this$0:Landroid/app/Instrumentation;


# direct methods
.method public constructor <init>(Landroid/app/Instrumentation;Landroid/app/Instrumentation$ActivityWaiter;)V
    .registers 3
    .parameter
    .parameter "waiter"

    .prologue
    .line 1633
    iput-object p1, p0, Landroid/app/Instrumentation$ActivityGoing;->this$0:Landroid/app/Instrumentation;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 1634
    iput-object p2, p0, Landroid/app/Instrumentation$ActivityGoing;->mWaiter:Landroid/app/Instrumentation$ActivityWaiter;

    .line 1635
    return-void
.end method


# virtual methods
.method public final queueIdle()Z
    .registers 4

    .prologue
    .line 1638
    iget-object v0, p0, Landroid/app/Instrumentation$ActivityGoing;->this$0:Landroid/app/Instrumentation;

    #getter for: Landroid/app/Instrumentation;->mSync:Ljava/lang/Object;
    invoke-static {v0}, Landroid/app/Instrumentation;->access$200(Landroid/app/Instrumentation;)Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    .line 1639
    :try_start_7
    iget-object v0, p0, Landroid/app/Instrumentation$ActivityGoing;->this$0:Landroid/app/Instrumentation;

    #getter for: Landroid/app/Instrumentation;->mWaitingActivities:Ljava/util/List;
    invoke-static {v0}, Landroid/app/Instrumentation;->access$300(Landroid/app/Instrumentation;)Ljava/util/List;

    move-result-object v0

    iget-object v2, p0, Landroid/app/Instrumentation$ActivityGoing;->mWaiter:Landroid/app/Instrumentation$ActivityWaiter;

    invoke-interface {v0, v2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 1640
    iget-object v0, p0, Landroid/app/Instrumentation$ActivityGoing;->this$0:Landroid/app/Instrumentation;

    #getter for: Landroid/app/Instrumentation;->mSync:Ljava/lang/Object;
    invoke-static {v0}, Landroid/app/Instrumentation;->access$200(Landroid/app/Instrumentation;)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->notifyAll()V

    .line 1641
    monitor-exit v1

    .line 1642
    const/4 v0, 0x0

    return v0

    .line 1641
    :catchall_1e
    move-exception v0

    monitor-exit v1
    :try_end_20
    .catchall {:try_start_7 .. :try_end_20} :catchall_1e

    throw v0
.end method
