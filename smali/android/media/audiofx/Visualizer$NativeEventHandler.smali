.class Landroid/media/audiofx/Visualizer$NativeEventHandler;
.super Landroid/os/Handler;
.source "Visualizer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/media/audiofx/Visualizer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "NativeEventHandler"
.end annotation


# instance fields
.field private mVisualizer:Landroid/media/audiofx/Visualizer;

.field final synthetic this$0:Landroid/media/audiofx/Visualizer;


# direct methods
.method public constructor <init>(Landroid/media/audiofx/Visualizer;Landroid/media/audiofx/Visualizer;Landroid/os/Looper;)V
    .registers 4
    .parameter
    .parameter "v"
    .parameter "looper"

    .prologue
    iput-object p1, p0, Landroid/media/audiofx/Visualizer$NativeEventHandler;->this$0:Landroid/media/audiofx/Visualizer;

    invoke-direct {p0, p3}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object p2, p0, Landroid/media/audiofx/Visualizer$NativeEventHandler;->mVisualizer:Landroid/media/audiofx/Visualizer;

    return-void
.end method

.method private handleCaptureMessage(Landroid/os/Message;)V
    .registers 8
    .parameter "msg"

    .prologue
    const/4 v1, 0x0

    .local v1, l:Landroid/media/audiofx/Visualizer$OnDataCaptureListener;
    iget-object v3, p0, Landroid/media/audiofx/Visualizer$NativeEventHandler;->this$0:Landroid/media/audiofx/Visualizer;

    #getter for: Landroid/media/audiofx/Visualizer;->mListenerLock:Ljava/lang/Object;
    invoke-static {v3}, Landroid/media/audiofx/Visualizer;->access$000(Landroid/media/audiofx/Visualizer;)Ljava/lang/Object;

    move-result-object v4

    monitor-enter v4

    :try_start_8
    iget-object v3, p0, Landroid/media/audiofx/Visualizer$NativeEventHandler;->mVisualizer:Landroid/media/audiofx/Visualizer;

    #getter for: Landroid/media/audiofx/Visualizer;->mCaptureListener:Landroid/media/audiofx/Visualizer$OnDataCaptureListener;
    invoke-static {v3}, Landroid/media/audiofx/Visualizer;->access$100(Landroid/media/audiofx/Visualizer;)Landroid/media/audiofx/Visualizer$OnDataCaptureListener;

    move-result-object v1

    monitor-exit v4
    :try_end_f
    .catchall {:try_start_8 .. :try_end_f} :catchall_3a

    if-eqz v1, :cond_39

    iget-object v3, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v3, [B

    move-object v0, v3

    check-cast v0, [B

    .local v0, data:[B
    iget v2, p1, Landroid/os/Message;->arg1:I

    .local v2, samplingRate:I
    iget v3, p1, Landroid/os/Message;->what:I

    packed-switch v3, :pswitch_data_4a

    const-string v3, "Visualizer-JAVA"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Unknown native event in handleCaptureMessge: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget v5, p1, Landroid/os/Message;->what:I

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .end local v0           #data:[B
    .end local v2           #samplingRate:I
    :cond_39
    :goto_39
    return-void

    :catchall_3a
    move-exception v3

    :try_start_3b
    monitor-exit v4
    :try_end_3c
    .catchall {:try_start_3b .. :try_end_3c} :catchall_3a

    throw v3

    .restart local v0       #data:[B
    .restart local v2       #samplingRate:I
    :pswitch_3d
    iget-object v3, p0, Landroid/media/audiofx/Visualizer$NativeEventHandler;->mVisualizer:Landroid/media/audiofx/Visualizer;

    invoke-interface {v1, v3, v0, v2}, Landroid/media/audiofx/Visualizer$OnDataCaptureListener;->onWaveFormDataCapture(Landroid/media/audiofx/Visualizer;[BI)V

    goto :goto_39

    :pswitch_43
    iget-object v3, p0, Landroid/media/audiofx/Visualizer$NativeEventHandler;->mVisualizer:Landroid/media/audiofx/Visualizer;

    invoke-interface {v1, v3, v0, v2}, Landroid/media/audiofx/Visualizer$OnDataCaptureListener;->onFftDataCapture(Landroid/media/audiofx/Visualizer;[BI)V

    goto :goto_39

    nop

    :pswitch_data_4a
    .packed-switch 0x0
        :pswitch_3d
        :pswitch_43
    .end packed-switch
.end method

.method private handleServerDiedMessage(Landroid/os/Message;)V
    .registers 5
    .parameter "msg"

    .prologue
    const/4 v0, 0x0

    .local v0, l:Landroid/media/audiofx/Visualizer$OnServerDiedListener;
    iget-object v1, p0, Landroid/media/audiofx/Visualizer$NativeEventHandler;->this$0:Landroid/media/audiofx/Visualizer;

    #getter for: Landroid/media/audiofx/Visualizer;->mListenerLock:Ljava/lang/Object;
    invoke-static {v1}, Landroid/media/audiofx/Visualizer;->access$000(Landroid/media/audiofx/Visualizer;)Ljava/lang/Object;

    move-result-object v2

    monitor-enter v2

    :try_start_8
    iget-object v1, p0, Landroid/media/audiofx/Visualizer$NativeEventHandler;->mVisualizer:Landroid/media/audiofx/Visualizer;

    #getter for: Landroid/media/audiofx/Visualizer;->mServerDiedListener:Landroid/media/audiofx/Visualizer$OnServerDiedListener;
    invoke-static {v1}, Landroid/media/audiofx/Visualizer;->access$200(Landroid/media/audiofx/Visualizer;)Landroid/media/audiofx/Visualizer$OnServerDiedListener;

    move-result-object v0

    monitor-exit v2
    :try_end_f
    .catchall {:try_start_8 .. :try_end_f} :catchall_15

    if-eqz v0, :cond_14

    invoke-interface {v0}, Landroid/media/audiofx/Visualizer$OnServerDiedListener;->onServerDied()V

    :cond_14
    return-void

    :catchall_15
    move-exception v1

    :try_start_16
    monitor-exit v2
    :try_end_17
    .catchall {:try_start_16 .. :try_end_17} :catchall_15

    throw v1
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .registers 5
    .parameter "msg"

    .prologue
    iget-object v0, p0, Landroid/media/audiofx/Visualizer$NativeEventHandler;->mVisualizer:Landroid/media/audiofx/Visualizer;

    if-nez v0, :cond_5

    :goto_4
    return-void

    :cond_5
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_2e

    const-string v0, "Visualizer-JAVA"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unknown native event: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p1, Landroid/os/Message;->what:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_4

    :pswitch_25
    invoke-direct {p0, p1}, Landroid/media/audiofx/Visualizer$NativeEventHandler;->handleCaptureMessage(Landroid/os/Message;)V

    goto :goto_4

    :pswitch_29
    invoke-direct {p0, p1}, Landroid/media/audiofx/Visualizer$NativeEventHandler;->handleServerDiedMessage(Landroid/os/Message;)V

    goto :goto_4

    nop

    :pswitch_data_2e
    .packed-switch 0x0
        :pswitch_25
        :pswitch_25
        :pswitch_29
    .end packed-switch
.end method
