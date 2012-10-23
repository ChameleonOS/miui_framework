.class Landroid/net/http/IdleCache$IdleReaper;
.super Ljava/lang/Thread;
.source "IdleCache.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/http/IdleCache;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "IdleReaper"
.end annotation


# instance fields
.field final synthetic this$0:Landroid/net/http/IdleCache;


# direct methods
.method private constructor <init>(Landroid/net/http/IdleCache;)V
    .registers 2
    .parameter

    .prologue
    .line 144
    iput-object p1, p0, Landroid/net/http/IdleCache$IdleReaper;->this$0:Landroid/net/http/IdleCache;

    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/net/http/IdleCache;Landroid/net/http/IdleCache$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 144
    invoke-direct {p0, p1}, Landroid/net/http/IdleCache$IdleReaper;-><init>(Landroid/net/http/IdleCache;)V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 6

    .prologue
    .line 147
    const/4 v0, 0x0

    .line 149
    .local v0, check:I
    const-string v1, "IdleReaper"

    invoke-virtual {p0, v1}, Landroid/net/http/IdleCache$IdleReaper;->setName(Ljava/lang/String;)V

    .line 150
    const/16 v1, 0xa

    invoke-static {v1}, Landroid/os/Process;->setThreadPriority(I)V

    .line 152
    iget-object v2, p0, Landroid/net/http/IdleCache$IdleReaper;->this$0:Landroid/net/http/IdleCache;

    monitor-enter v2

    .line 153
    :goto_e
    const/4 v1, 0x5

    if-ge v0, v1, :cond_2d

    .line 155
    :try_start_11
    iget-object v1, p0, Landroid/net/http/IdleCache$IdleReaper;->this$0:Landroid/net/http/IdleCache;

    const-wide/16 v3, 0x7d0

    invoke-virtual {v1, v3, v4}, Ljava/lang/Object;->wait(J)V
    :try_end_18
    .catchall {:try_start_11 .. :try_end_18} :catchall_2a
    .catch Ljava/lang/InterruptedException; {:try_start_11 .. :try_end_18} :catch_35

    .line 158
    :goto_18
    :try_start_18
    iget-object v1, p0, Landroid/net/http/IdleCache$IdleReaper;->this$0:Landroid/net/http/IdleCache;

    #getter for: Landroid/net/http/IdleCache;->mCount:I
    invoke-static {v1}, Landroid/net/http/IdleCache;->access$100(Landroid/net/http/IdleCache;)I

    move-result v1

    if-nez v1, :cond_23

    .line 159
    add-int/lit8 v0, v0, 0x1

    goto :goto_e

    .line 161
    :cond_23
    const/4 v0, 0x0

    .line 162
    iget-object v1, p0, Landroid/net/http/IdleCache$IdleReaper;->this$0:Landroid/net/http/IdleCache;

    #calls: Landroid/net/http/IdleCache;->clearIdle()V
    invoke-static {v1}, Landroid/net/http/IdleCache;->access$200(Landroid/net/http/IdleCache;)V

    goto :goto_e

    .line 166
    :catchall_2a
    move-exception v1

    monitor-exit v2
    :try_end_2c
    .catchall {:try_start_18 .. :try_end_2c} :catchall_2a

    throw v1

    .line 165
    :cond_2d
    :try_start_2d
    iget-object v1, p0, Landroid/net/http/IdleCache$IdleReaper;->this$0:Landroid/net/http/IdleCache;

    const/4 v3, 0x0

    #setter for: Landroid/net/http/IdleCache;->mThread:Landroid/net/http/IdleCache$IdleReaper;
    invoke-static {v1, v3}, Landroid/net/http/IdleCache;->access$302(Landroid/net/http/IdleCache;Landroid/net/http/IdleCache$IdleReaper;)Landroid/net/http/IdleCache$IdleReaper;

    .line 166
    monitor-exit v2
    :try_end_34
    .catchall {:try_start_2d .. :try_end_34} :catchall_2a

    .line 173
    return-void

    .line 156
    :catch_35
    move-exception v1

    goto :goto_18
.end method
