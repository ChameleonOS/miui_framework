.class Lcom/android/server/ResettableTimeout$T;
.super Ljava/lang/Thread;
.source "ResettableTimeout.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/server/ResettableTimeout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "T"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/server/ResettableTimeout;


# direct methods
.method private constructor <init>(Lcom/android/server/ResettableTimeout;)V
    .registers 2
    .parameter

    .prologue
    .line 98
    iput-object p1, p0, Lcom/android/server/ResettableTimeout$T;->this$0:Lcom/android/server/ResettableTimeout;

    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/android/server/ResettableTimeout;Lcom/android/server/ResettableTimeout$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 98
    invoke-direct {p0, p1}, Lcom/android/server/ResettableTimeout$T;-><init>(Lcom/android/server/ResettableTimeout;)V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 7

    .prologue
    .line 102
    iget-object v2, p0, Lcom/android/server/ResettableTimeout$T;->this$0:Lcom/android/server/ResettableTimeout;

    #getter for: Lcom/android/server/ResettableTimeout;->mLock:Landroid/os/ConditionVariable;
    invoke-static {v2}, Lcom/android/server/ResettableTimeout;->access$100(Lcom/android/server/ResettableTimeout;)Landroid/os/ConditionVariable;

    move-result-object v2

    invoke-virtual {v2}, Landroid/os/ConditionVariable;->open()V

    .line 105
    :goto_9
    monitor-enter p0

    .line 106
    :try_start_a
    iget-object v2, p0, Lcom/android/server/ResettableTimeout$T;->this$0:Lcom/android/server/ResettableTimeout;

    #getter for: Lcom/android/server/ResettableTimeout;->mOffAt:J
    invoke-static {v2}, Lcom/android/server/ResettableTimeout;->access$200(Lcom/android/server/ResettableTimeout;)J

    move-result-wide v2

    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v4

    sub-long v0, v2, v4

    .line 107
    .local v0, diff:J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-gtz v2, :cond_2f

    .line 108
    iget-object v2, p0, Lcom/android/server/ResettableTimeout$T;->this$0:Lcom/android/server/ResettableTimeout;

    const/4 v3, 0x1

    #setter for: Lcom/android/server/ResettableTimeout;->mOffCalled:Z
    invoke-static {v2, v3}, Lcom/android/server/ResettableTimeout;->access$302(Lcom/android/server/ResettableTimeout;Z)Z

    .line 109
    iget-object v2, p0, Lcom/android/server/ResettableTimeout$T;->this$0:Lcom/android/server/ResettableTimeout;

    invoke-virtual {v2}, Lcom/android/server/ResettableTimeout;->off()V

    .line 110
    iget-object v2, p0, Lcom/android/server/ResettableTimeout$T;->this$0:Lcom/android/server/ResettableTimeout;

    const/4 v3, 0x0

    #setter for: Lcom/android/server/ResettableTimeout;->mThread:Ljava/lang/Thread;
    invoke-static {v2, v3}, Lcom/android/server/ResettableTimeout;->access$402(Lcom/android/server/ResettableTimeout;Ljava/lang/Thread;)Ljava/lang/Thread;

    .line 111
    monitor-exit p0

    .line 120
    return-void

    .line 113
    :cond_2f
    monitor-exit p0
    :try_end_30
    .catchall {:try_start_a .. :try_end_30} :catchall_36

    .line 115
    :try_start_30
    invoke-static {v0, v1}, Lcom/android/server/ResettableTimeout$T;->sleep(J)V
    :try_end_33
    .catch Ljava/lang/InterruptedException; {:try_start_30 .. :try_end_33} :catch_34

    goto :goto_9

    .line 117
    :catch_34
    move-exception v2

    goto :goto_9

    .line 113
    .end local v0           #diff:J
    :catchall_36
    move-exception v2

    :try_start_37
    monitor-exit p0
    :try_end_38
    .catchall {:try_start_37 .. :try_end_38} :catchall_36

    throw v2
.end method
