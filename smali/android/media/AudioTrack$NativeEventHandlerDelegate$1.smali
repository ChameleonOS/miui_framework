.class Landroid/media/AudioTrack$NativeEventHandlerDelegate$1;
.super Landroid/os/Handler;
.source "AudioTrack.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/media/AudioTrack$NativeEventHandlerDelegate;-><init>(Landroid/media/AudioTrack;Landroid/media/AudioTrack;Landroid/os/Handler;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Landroid/media/AudioTrack$NativeEventHandlerDelegate;

.field final synthetic val$this$0:Landroid/media/AudioTrack;


# direct methods
.method constructor <init>(Landroid/media/AudioTrack$NativeEventHandlerDelegate;Landroid/os/Looper;Landroid/media/AudioTrack;)V
    .registers 4
    .parameter
    .parameter "x0"
    .parameter

    .prologue
    .line 1142
    iput-object p1, p0, Landroid/media/AudioTrack$NativeEventHandlerDelegate$1;->this$1:Landroid/media/AudioTrack$NativeEventHandlerDelegate;

    iput-object p3, p0, Landroid/media/AudioTrack$NativeEventHandlerDelegate$1;->val$this$0:Landroid/media/AudioTrack;

    invoke-direct {p0, p2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .registers 6
    .parameter "msg"

    .prologue
    .line 1145
    iget-object v1, p0, Landroid/media/AudioTrack$NativeEventHandlerDelegate$1;->this$1:Landroid/media/AudioTrack$NativeEventHandlerDelegate;

    #getter for: Landroid/media/AudioTrack$NativeEventHandlerDelegate;->mAudioTrack:Landroid/media/AudioTrack;
    invoke-static {v1}, Landroid/media/AudioTrack$NativeEventHandlerDelegate;->access$100(Landroid/media/AudioTrack$NativeEventHandlerDelegate;)Landroid/media/AudioTrack;

    move-result-object v1

    if-nez v1, :cond_9

    .line 1168
    :cond_8
    :goto_8
    return-void

    .line 1148
    :cond_9
    const/4 v0, 0x0

    .line 1149
    .local v0, listener:Landroid/media/AudioTrack$OnPlaybackPositionUpdateListener;
    iget-object v1, p0, Landroid/media/AudioTrack$NativeEventHandlerDelegate$1;->this$1:Landroid/media/AudioTrack$NativeEventHandlerDelegate;

    iget-object v1, v1, Landroid/media/AudioTrack$NativeEventHandlerDelegate;->this$0:Landroid/media/AudioTrack;

    #getter for: Landroid/media/AudioTrack;->mPositionListenerLock:Ljava/lang/Object;
    invoke-static {v1}, Landroid/media/AudioTrack;->access$200(Landroid/media/AudioTrack;)Ljava/lang/Object;

    move-result-object v2

    monitor-enter v2

    .line 1150
    :try_start_13
    iget-object v1, p0, Landroid/media/AudioTrack$NativeEventHandlerDelegate$1;->this$1:Landroid/media/AudioTrack$NativeEventHandlerDelegate;

    #getter for: Landroid/media/AudioTrack$NativeEventHandlerDelegate;->mAudioTrack:Landroid/media/AudioTrack;
    invoke-static {v1}, Landroid/media/AudioTrack$NativeEventHandlerDelegate;->access$100(Landroid/media/AudioTrack$NativeEventHandlerDelegate;)Landroid/media/AudioTrack;

    move-result-object v1

    #getter for: Landroid/media/AudioTrack;->mPositionListener:Landroid/media/AudioTrack$OnPlaybackPositionUpdateListener;
    invoke-static {v1}, Landroid/media/AudioTrack;->access$300(Landroid/media/AudioTrack;)Landroid/media/AudioTrack$OnPlaybackPositionUpdateListener;

    move-result-object v0

    .line 1151
    monitor-exit v2
    :try_end_1e
    .catchall {:try_start_13 .. :try_end_1e} :catchall_3e

    .line 1152
    iget v1, p1, Landroid/os/Message;->what:I

    packed-switch v1, :pswitch_data_5a

    .line 1164
    const-string v1, "AudioTrack-Java"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "[ android.media.AudioTrack.NativeEventHandler ] Unknown event type: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v3, p1, Landroid/os/Message;->what:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_8

    .line 1151
    :catchall_3e
    move-exception v1

    :try_start_3f
    monitor-exit v2
    :try_end_40
    .catchall {:try_start_3f .. :try_end_40} :catchall_3e

    throw v1

    .line 1154
    :pswitch_41
    if-eqz v0, :cond_8

    .line 1155
    iget-object v1, p0, Landroid/media/AudioTrack$NativeEventHandlerDelegate$1;->this$1:Landroid/media/AudioTrack$NativeEventHandlerDelegate;

    #getter for: Landroid/media/AudioTrack$NativeEventHandlerDelegate;->mAudioTrack:Landroid/media/AudioTrack;
    invoke-static {v1}, Landroid/media/AudioTrack$NativeEventHandlerDelegate;->access$100(Landroid/media/AudioTrack$NativeEventHandlerDelegate;)Landroid/media/AudioTrack;

    move-result-object v1

    invoke-interface {v0, v1}, Landroid/media/AudioTrack$OnPlaybackPositionUpdateListener;->onMarkerReached(Landroid/media/AudioTrack;)V

    goto :goto_8

    .line 1159
    :pswitch_4d
    if-eqz v0, :cond_8

    .line 1160
    iget-object v1, p0, Landroid/media/AudioTrack$NativeEventHandlerDelegate$1;->this$1:Landroid/media/AudioTrack$NativeEventHandlerDelegate;

    #getter for: Landroid/media/AudioTrack$NativeEventHandlerDelegate;->mAudioTrack:Landroid/media/AudioTrack;
    invoke-static {v1}, Landroid/media/AudioTrack$NativeEventHandlerDelegate;->access$100(Landroid/media/AudioTrack$NativeEventHandlerDelegate;)Landroid/media/AudioTrack;

    move-result-object v1

    invoke-interface {v0, v1}, Landroid/media/AudioTrack$OnPlaybackPositionUpdateListener;->onPeriodicNotification(Landroid/media/AudioTrack;)V

    goto :goto_8

    .line 1152
    nop

    :pswitch_data_5a
    .packed-switch 0x3
        :pswitch_41
        :pswitch_4d
    .end packed-switch
.end method
