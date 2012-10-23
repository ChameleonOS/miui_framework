.class Landroid/media/AudioService$RcDisplayDeathHandler;
.super Ljava/lang/Object;
.source "AudioService.java"

# interfaces
.implements Landroid/os/IBinder$DeathRecipient;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/media/AudioService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "RcDisplayDeathHandler"
.end annotation


# instance fields
.field private mCb:Landroid/os/IBinder;

.field final synthetic this$0:Landroid/media/AudioService;


# direct methods
.method public constructor <init>(Landroid/media/AudioService;Landroid/os/IBinder;)V
    .registers 3
    .parameter
    .parameter "b"

    .prologue
    .line 4849
    iput-object p1, p0, Landroid/media/AudioService$RcDisplayDeathHandler;->this$0:Landroid/media/AudioService;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 4851
    iput-object p2, p0, Landroid/media/AudioService$RcDisplayDeathHandler;->mCb:Landroid/os/IBinder;

    .line 4852
    return-void
.end method


# virtual methods
.method public binderDied()V
    .registers 4

    .prologue
    .line 4855
    iget-object v0, p0, Landroid/media/AudioService$RcDisplayDeathHandler;->this$0:Landroid/media/AudioService;

    #getter for: Landroid/media/AudioService;->mRCStack:Ljava/util/Stack;
    invoke-static {v0}, Landroid/media/AudioService;->access$8300(Landroid/media/AudioService;)Ljava/util/Stack;

    move-result-object v1

    monitor-enter v1

    .line 4856
    :try_start_7
    const-string v0, "AudioService"

    const-string v2, "RemoteControl: display died"

    invoke-static {v0, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 4857
    iget-object v0, p0, Landroid/media/AudioService$RcDisplayDeathHandler;->this$0:Landroid/media/AudioService;

    const/4 v2, 0x0

    #setter for: Landroid/media/AudioService;->mRcDisplay:Landroid/media/IRemoteControlDisplay;
    invoke-static {v0, v2}, Landroid/media/AudioService;->access$8402(Landroid/media/AudioService;Landroid/media/IRemoteControlDisplay;)Landroid/media/IRemoteControlDisplay;

    .line 4858
    monitor-exit v1

    .line 4859
    return-void

    .line 4858
    :catchall_16
    move-exception v0

    monitor-exit v1
    :try_end_18
    .catchall {:try_start_7 .. :try_end_18} :catchall_16

    throw v0
.end method

.method public unlinkToRcDisplayDeath()V
    .registers 5

    .prologue
    .line 4864
    :try_start_0
    iget-object v1, p0, Landroid/media/AudioService$RcDisplayDeathHandler;->mCb:Landroid/os/IBinder;

    const/4 v2, 0x0

    invoke-interface {v1, p0, v2}, Landroid/os/IBinder;->unlinkToDeath(Landroid/os/IBinder$DeathRecipient;I)Z
    :try_end_6
    .catch Ljava/util/NoSuchElementException; {:try_start_0 .. :try_end_6} :catch_7

    .line 4870
    :goto_6
    return-void

    .line 4865
    :catch_7
    move-exception v0

    .line 4867
    .local v0, e:Ljava/util/NoSuchElementException;
    const-string v1, "AudioService"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Encountered "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " in unlinkToRcDisplayDeath()"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 4868
    invoke-virtual {v0}, Ljava/util/NoSuchElementException;->printStackTrace()V

    goto :goto_6
.end method
