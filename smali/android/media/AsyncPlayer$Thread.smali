.class final Landroid/media/AsyncPlayer$Thread;
.super Ljava/lang/Thread;
.source "AsyncPlayer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/media/AsyncPlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "Thread"
.end annotation


# instance fields
.field final synthetic this$0:Landroid/media/AsyncPlayer;


# direct methods
.method constructor <init>(Landroid/media/AsyncPlayer;)V
    .registers 4
    .parameter

    .prologue
    .line 81
    iput-object p1, p0, Landroid/media/AsyncPlayer$Thread;->this$0:Landroid/media/AsyncPlayer;

    .line 82
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "AsyncPlayer-"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    #getter for: Landroid/media/AsyncPlayer;->mTag:Ljava/lang/String;
    invoke-static {p1}, Landroid/media/AsyncPlayer;->access$000(Landroid/media/AsyncPlayer;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Ljava/lang/Thread;-><init>(Ljava/lang/String;)V

    .line 83
    return-void
.end method


# virtual methods
.method public run()V
    .registers 10

    .prologue
    const/4 v8, 0x0

    .line 87
    :goto_1
    const/4 v1, 0x0

    .line 89
    .local v1, cmd:Landroid/media/AsyncPlayer$Command;
    iget-object v4, p0, Landroid/media/AsyncPlayer$Thread;->this$0:Landroid/media/AsyncPlayer;

    #getter for: Landroid/media/AsyncPlayer;->mCmdQueue:Ljava/util/LinkedList;
    invoke-static {v4}, Landroid/media/AsyncPlayer;->access$100(Landroid/media/AsyncPlayer;)Ljava/util/LinkedList;

    move-result-object v5

    monitor-enter v5

    .line 91
    :try_start_9
    iget-object v4, p0, Landroid/media/AsyncPlayer$Thread;->this$0:Landroid/media/AsyncPlayer;

    #getter for: Landroid/media/AsyncPlayer;->mCmdQueue:Ljava/util/LinkedList;
    invoke-static {v4}, Landroid/media/AsyncPlayer;->access$100(Landroid/media/AsyncPlayer;)Ljava/util/LinkedList;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/LinkedList;->removeFirst()Ljava/lang/Object;

    move-result-object v4

    move-object v0, v4

    check-cast v0, Landroid/media/AsyncPlayer$Command;

    move-object v1, v0

    .line 92
    monitor-exit v5
    :try_end_18
    .catchall {:try_start_9 .. :try_end_18} :catchall_3d

    .line 94
    iget v4, v1, Landroid/media/AsyncPlayer$Command;->code:I

    packed-switch v4, :pswitch_data_aa

    .line 115
    :goto_1d
    iget-object v4, p0, Landroid/media/AsyncPlayer$Thread;->this$0:Landroid/media/AsyncPlayer;

    #getter for: Landroid/media/AsyncPlayer;->mCmdQueue:Ljava/util/LinkedList;
    invoke-static {v4}, Landroid/media/AsyncPlayer;->access$100(Landroid/media/AsyncPlayer;)Ljava/util/LinkedList;

    move-result-object v5

    monitor-enter v5

    .line 116
    :try_start_24
    iget-object v4, p0, Landroid/media/AsyncPlayer$Thread;->this$0:Landroid/media/AsyncPlayer;

    #getter for: Landroid/media/AsyncPlayer;->mCmdQueue:Ljava/util/LinkedList;
    invoke-static {v4}, Landroid/media/AsyncPlayer;->access$100(Landroid/media/AsyncPlayer;)Ljava/util/LinkedList;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/LinkedList;->size()I

    move-result v4

    if-nez v4, :cond_a4

    .line 121
    iget-object v4, p0, Landroid/media/AsyncPlayer$Thread;->this$0:Landroid/media/AsyncPlayer;

    const/4 v6, 0x0

    #setter for: Landroid/media/AsyncPlayer;->mThread:Landroid/media/AsyncPlayer$Thread;
    invoke-static {v4, v6}, Landroid/media/AsyncPlayer;->access$402(Landroid/media/AsyncPlayer;Landroid/media/AsyncPlayer$Thread;)Landroid/media/AsyncPlayer$Thread;

    .line 122
    iget-object v4, p0, Landroid/media/AsyncPlayer$Thread;->this$0:Landroid/media/AsyncPlayer;

    #calls: Landroid/media/AsyncPlayer;->releaseWakeLock()V
    invoke-static {v4}, Landroid/media/AsyncPlayer;->access$500(Landroid/media/AsyncPlayer;)V

    .line 123
    monitor-exit v5
    :try_end_3c
    .catchall {:try_start_24 .. :try_end_3c} :catchall_a7

    return-void

    .line 92
    :catchall_3d
    move-exception v4

    :try_start_3e
    monitor-exit v5
    :try_end_3f
    .catchall {:try_start_3e .. :try_end_3f} :catchall_3d

    throw v4

    .line 97
    :pswitch_40
    iget-object v4, p0, Landroid/media/AsyncPlayer$Thread;->this$0:Landroid/media/AsyncPlayer;

    #calls: Landroid/media/AsyncPlayer;->startSound(Landroid/media/AsyncPlayer$Command;)V
    invoke-static {v4, v1}, Landroid/media/AsyncPlayer;->access$200(Landroid/media/AsyncPlayer;Landroid/media/AsyncPlayer$Command;)V

    goto :goto_1d

    .line 101
    :pswitch_46
    iget-object v4, p0, Landroid/media/AsyncPlayer$Thread;->this$0:Landroid/media/AsyncPlayer;

    #getter for: Landroid/media/AsyncPlayer;->mPlayer:Landroid/media/MediaPlayer;
    invoke-static {v4}, Landroid/media/AsyncPlayer;->access$300(Landroid/media/AsyncPlayer;)Landroid/media/MediaPlayer;

    move-result-object v4

    if-eqz v4, :cond_97

    .line 102
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v4

    iget-wide v6, v1, Landroid/media/AsyncPlayer$Command;->requestTime:J

    sub-long v2, v4, v6

    .line 103
    .local v2, delay:J
    const-wide/16 v4, 0x3e8

    cmp-long v4, v2, v4

    if-lez v4, :cond_7f

    .line 104
    iget-object v4, p0, Landroid/media/AsyncPlayer$Thread;->this$0:Landroid/media/AsyncPlayer;

    #getter for: Landroid/media/AsyncPlayer;->mTag:Ljava/lang/String;
    invoke-static {v4}, Landroid/media/AsyncPlayer;->access$000(Landroid/media/AsyncPlayer;)Ljava/lang/String;

    move-result-object v4

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Notification stop delayed by "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, "msecs"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 106
    :cond_7f
    iget-object v4, p0, Landroid/media/AsyncPlayer$Thread;->this$0:Landroid/media/AsyncPlayer;

    #getter for: Landroid/media/AsyncPlayer;->mPlayer:Landroid/media/MediaPlayer;
    invoke-static {v4}, Landroid/media/AsyncPlayer;->access$300(Landroid/media/AsyncPlayer;)Landroid/media/MediaPlayer;

    move-result-object v4

    invoke-virtual {v4}, Landroid/media/MediaPlayer;->stop()V

    .line 107
    iget-object v4, p0, Landroid/media/AsyncPlayer$Thread;->this$0:Landroid/media/AsyncPlayer;

    #getter for: Landroid/media/AsyncPlayer;->mPlayer:Landroid/media/MediaPlayer;
    invoke-static {v4}, Landroid/media/AsyncPlayer;->access$300(Landroid/media/AsyncPlayer;)Landroid/media/MediaPlayer;

    move-result-object v4

    invoke-virtual {v4}, Landroid/media/MediaPlayer;->release()V

    .line 108
    iget-object v4, p0, Landroid/media/AsyncPlayer$Thread;->this$0:Landroid/media/AsyncPlayer;

    #setter for: Landroid/media/AsyncPlayer;->mPlayer:Landroid/media/MediaPlayer;
    invoke-static {v4, v8}, Landroid/media/AsyncPlayer;->access$302(Landroid/media/AsyncPlayer;Landroid/media/MediaPlayer;)Landroid/media/MediaPlayer;

    goto :goto_1d

    .line 110
    .end local v2           #delay:J
    :cond_97
    iget-object v4, p0, Landroid/media/AsyncPlayer$Thread;->this$0:Landroid/media/AsyncPlayer;

    #getter for: Landroid/media/AsyncPlayer;->mTag:Ljava/lang/String;
    invoke-static {v4}, Landroid/media/AsyncPlayer;->access$000(Landroid/media/AsyncPlayer;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "STOP command without a player"

    invoke-static {v4, v5}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_1d

    .line 125
    :cond_a4
    :try_start_a4
    monitor-exit v5

    goto/16 :goto_1

    :catchall_a7
    move-exception v4

    monitor-exit v5
    :try_end_a9
    .catchall {:try_start_a4 .. :try_end_a9} :catchall_a7

    throw v4

    .line 94
    :pswitch_data_aa
    .packed-switch 0x1
        :pswitch_40
        :pswitch_46
    .end packed-switch
.end method
