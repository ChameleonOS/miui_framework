.class Landroid/media/JetPlayer$NativeEventHandler;
.super Landroid/os/Handler;
.source "JetPlayer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/media/JetPlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "NativeEventHandler"
.end annotation


# instance fields
.field private mJet:Landroid/media/JetPlayer;

.field final synthetic this$0:Landroid/media/JetPlayer;


# direct methods
.method public constructor <init>(Landroid/media/JetPlayer;Landroid/media/JetPlayer;Landroid/os/Looper;)V
    .registers 4
    .parameter
    .parameter "jet"
    .parameter "looper"

    .prologue
    iput-object p1, p0, Landroid/media/JetPlayer$NativeEventHandler;->this$0:Landroid/media/JetPlayer;

    invoke-direct {p0, p3}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object p2, p0, Landroid/media/JetPlayer$NativeEventHandler;->mJet:Landroid/media/JetPlayer;

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .registers 10
    .parameter "msg"

    .prologue
    const/4 v7, 0x0

    .local v7, listener:Landroid/media/JetPlayer$OnJetEventListener;
    iget-object v0, p0, Landroid/media/JetPlayer$NativeEventHandler;->this$0:Landroid/media/JetPlayer;

    #getter for: Landroid/media/JetPlayer;->mEventListenerLock:Ljava/lang/Object;
    invoke-static {v0}, Landroid/media/JetPlayer;->access$000(Landroid/media/JetPlayer;)Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    :try_start_8
    iget-object v0, p0, Landroid/media/JetPlayer$NativeEventHandler;->mJet:Landroid/media/JetPlayer;

    #getter for: Landroid/media/JetPlayer;->mJetEventListener:Landroid/media/JetPlayer$OnJetEventListener;
    invoke-static {v0}, Landroid/media/JetPlayer;->access$100(Landroid/media/JetPlayer;)Landroid/media/JetPlayer$OnJetEventListener;

    move-result-object v7

    monitor-exit v1
    :try_end_f
    .catchall {:try_start_8 .. :try_end_f} :catchall_2d

    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_86

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Unknown message type "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p1, Landroid/os/Message;->what:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    #calls: Landroid/media/JetPlayer;->loge(Ljava/lang/String;)V
    invoke-static {v0}, Landroid/media/JetPlayer;->access$200(Ljava/lang/String;)V

    :cond_2c
    :goto_2c
    return-void

    :catchall_2d
    move-exception v0

    :try_start_2e
    monitor-exit v1
    :try_end_2f
    .catchall {:try_start_2e .. :try_end_2f} :catchall_2d

    throw v0

    :pswitch_30
    if-eqz v7, :cond_2c

    iget-object v0, p0, Landroid/media/JetPlayer$NativeEventHandler;->this$0:Landroid/media/JetPlayer;

    #getter for: Landroid/media/JetPlayer;->mJetEventListener:Landroid/media/JetPlayer$OnJetEventListener;
    invoke-static {v0}, Landroid/media/JetPlayer;->access$100(Landroid/media/JetPlayer;)Landroid/media/JetPlayer$OnJetEventListener;

    move-result-object v0

    iget-object v1, p0, Landroid/media/JetPlayer$NativeEventHandler;->mJet:Landroid/media/JetPlayer;

    iget v2, p1, Landroid/os/Message;->arg1:I

    const/high16 v3, -0x100

    and-int/2addr v2, v3

    shr-int/lit8 v2, v2, 0x18

    int-to-short v2, v2

    iget v3, p1, Landroid/os/Message;->arg1:I

    const/high16 v4, 0xfc

    and-int/2addr v3, v4

    shr-int/lit8 v3, v3, 0x12

    int-to-byte v3, v3

    iget v4, p1, Landroid/os/Message;->arg1:I

    const v5, 0x3c000

    and-int/2addr v4, v5

    shr-int/lit8 v4, v4, 0xe

    add-int/lit8 v4, v4, 0x1

    int-to-byte v4, v4

    iget v5, p1, Landroid/os/Message;->arg1:I

    and-int/lit16 v5, v5, 0x3f80

    shr-int/lit8 v5, v5, 0x7

    int-to-byte v5, v5

    iget v6, p1, Landroid/os/Message;->arg1:I

    and-int/lit8 v6, v6, 0x7f

    int-to-byte v6, v6

    invoke-interface/range {v0 .. v6}, Landroid/media/JetPlayer$OnJetEventListener;->onJetEvent(Landroid/media/JetPlayer;SBBBB)V

    goto :goto_2c

    :pswitch_65
    if-eqz v7, :cond_2c

    iget-object v0, p0, Landroid/media/JetPlayer$NativeEventHandler;->mJet:Landroid/media/JetPlayer;

    iget v1, p1, Landroid/os/Message;->arg1:I

    iget v2, p1, Landroid/os/Message;->arg2:I

    invoke-interface {v7, v0, v1, v2}, Landroid/media/JetPlayer$OnJetEventListener;->onJetUserIdUpdate(Landroid/media/JetPlayer;II)V

    goto :goto_2c

    :pswitch_71
    if-eqz v7, :cond_2c

    iget-object v0, p0, Landroid/media/JetPlayer$NativeEventHandler;->mJet:Landroid/media/JetPlayer;

    iget v1, p1, Landroid/os/Message;->arg1:I

    invoke-interface {v7, v0, v1}, Landroid/media/JetPlayer$OnJetEventListener;->onJetNumQueuedSegmentUpdate(Landroid/media/JetPlayer;I)V

    goto :goto_2c

    :pswitch_7b
    if-eqz v7, :cond_2c

    iget-object v0, p0, Landroid/media/JetPlayer$NativeEventHandler;->mJet:Landroid/media/JetPlayer;

    iget v1, p1, Landroid/os/Message;->arg1:I

    invoke-interface {v7, v0, v1}, Landroid/media/JetPlayer$OnJetEventListener;->onJetPauseUpdate(Landroid/media/JetPlayer;I)V

    goto :goto_2c

    nop

    :pswitch_data_86
    .packed-switch 0x1
        :pswitch_30
        :pswitch_65
        :pswitch_71
        :pswitch_7b
    .end packed-switch
.end method
