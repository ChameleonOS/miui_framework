.class Landroid/media/AudioService$FocusStackEntry;
.super Ljava/lang/Object;
.source "AudioService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/media/AudioService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "FocusStackEntry"
.end annotation


# instance fields
.field public mCallingUid:I

.field public mClientId:Ljava/lang/String;

.field public mFocusChangeType:I

.field public mFocusDispatcher:Landroid/media/IAudioFocusDispatcher;

.field public mHandler:Landroid/media/AudioService$AudioFocusDeathHandler;

.field public mPackageName:Ljava/lang/String;

.field public mSourceRef:Landroid/os/IBinder;

.field public mStreamType:I


# direct methods
.method public constructor <init>()V
    .registers 3

    .prologue
    const/4 v1, 0x0

    .line 3615
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 3606
    const/4 v0, -0x1

    iput v0, p0, Landroid/media/AudioService$FocusStackEntry;->mStreamType:I

    .line 3607
    iput-object v1, p0, Landroid/media/AudioService$FocusStackEntry;->mFocusDispatcher:Landroid/media/IAudioFocusDispatcher;

    .line 3608
    iput-object v1, p0, Landroid/media/AudioService$FocusStackEntry;->mSourceRef:Landroid/os/IBinder;

    .line 3616
    return-void
.end method

.method public constructor <init>(IILandroid/media/IAudioFocusDispatcher;Landroid/os/IBinder;Ljava/lang/String;Landroid/media/AudioService$AudioFocusDeathHandler;Ljava/lang/String;I)V
    .registers 11
    .parameter "streamType"
    .parameter "duration"
    .parameter "afl"
    .parameter "source"
    .parameter "id"
    .parameter "hdlr"
    .parameter "pn"
    .parameter "uid"

    .prologue
    const/4 v1, 0x0

    .line 3620
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 3606
    const/4 v0, -0x1

    iput v0, p0, Landroid/media/AudioService$FocusStackEntry;->mStreamType:I

    .line 3607
    iput-object v1, p0, Landroid/media/AudioService$FocusStackEntry;->mFocusDispatcher:Landroid/media/IAudioFocusDispatcher;

    .line 3608
    iput-object v1, p0, Landroid/media/AudioService$FocusStackEntry;->mSourceRef:Landroid/os/IBinder;

    .line 3621
    iput p1, p0, Landroid/media/AudioService$FocusStackEntry;->mStreamType:I

    .line 3622
    iput-object p3, p0, Landroid/media/AudioService$FocusStackEntry;->mFocusDispatcher:Landroid/media/IAudioFocusDispatcher;

    .line 3623
    iput-object p4, p0, Landroid/media/AudioService$FocusStackEntry;->mSourceRef:Landroid/os/IBinder;

    .line 3624
    iput-object p5, p0, Landroid/media/AudioService$FocusStackEntry;->mClientId:Ljava/lang/String;

    .line 3625
    iput p2, p0, Landroid/media/AudioService$FocusStackEntry;->mFocusChangeType:I

    .line 3626
    iput-object p6, p0, Landroid/media/AudioService$FocusStackEntry;->mHandler:Landroid/media/AudioService$AudioFocusDeathHandler;

    .line 3627
    iput-object p7, p0, Landroid/media/AudioService$FocusStackEntry;->mPackageName:Ljava/lang/String;

    .line 3628
    iput p8, p0, Landroid/media/AudioService$FocusStackEntry;->mCallingUid:I

    .line 3629
    return-void
.end method


# virtual methods
.method protected finalize()V
    .registers 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 3644
    invoke-virtual {p0}, Landroid/media/AudioService$FocusStackEntry;->unlinkToDeath()V

    .line 3645
    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    .line 3646
    return-void
.end method

.method public unlinkToDeath()V
    .registers 5

    .prologue
    .line 3633
    :try_start_0
    iget-object v1, p0, Landroid/media/AudioService$FocusStackEntry;->mSourceRef:Landroid/os/IBinder;

    if-eqz v1, :cond_13

    iget-object v1, p0, Landroid/media/AudioService$FocusStackEntry;->mHandler:Landroid/media/AudioService$AudioFocusDeathHandler;

    if-eqz v1, :cond_13

    .line 3634
    iget-object v1, p0, Landroid/media/AudioService$FocusStackEntry;->mSourceRef:Landroid/os/IBinder;

    iget-object v2, p0, Landroid/media/AudioService$FocusStackEntry;->mHandler:Landroid/media/AudioService$AudioFocusDeathHandler;

    const/4 v3, 0x0

    invoke-interface {v1, v2, v3}, Landroid/os/IBinder;->unlinkToDeath(Landroid/os/IBinder$DeathRecipient;I)Z

    .line 3635
    const/4 v1, 0x0

    iput-object v1, p0, Landroid/media/AudioService$FocusStackEntry;->mHandler:Landroid/media/AudioService$AudioFocusDeathHandler;
    :try_end_13
    .catch Ljava/util/NoSuchElementException; {:try_start_0 .. :try_end_13} :catch_14

    .line 3640
    :cond_13
    :goto_13
    return-void

    .line 3637
    :catch_14
    move-exception v0

    .line 3638
    .local v0, e:Ljava/util/NoSuchElementException;
    const-string v1, "AudioService"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Encountered "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " in FocusStackEntry.unlinkToDeath()"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_13
.end method
