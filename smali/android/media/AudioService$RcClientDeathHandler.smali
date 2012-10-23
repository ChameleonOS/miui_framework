.class Landroid/media/AudioService$RcClientDeathHandler;
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
    name = "RcClientDeathHandler"
.end annotation


# instance fields
.field private mCb:Landroid/os/IBinder;

.field private mMediaIntent:Landroid/app/PendingIntent;

.field final synthetic this$0:Landroid/media/AudioService;


# direct methods
.method constructor <init>(Landroid/media/AudioService;Landroid/os/IBinder;Landroid/app/PendingIntent;)V
    .registers 4
    .parameter
    .parameter "cb"
    .parameter "pi"

    .prologue
    .line 4177
    iput-object p1, p0, Landroid/media/AudioService$RcClientDeathHandler;->this$0:Landroid/media/AudioService;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 4178
    iput-object p2, p0, Landroid/media/AudioService$RcClientDeathHandler;->mCb:Landroid/os/IBinder;

    .line 4179
    iput-object p3, p0, Landroid/media/AudioService$RcClientDeathHandler;->mMediaIntent:Landroid/app/PendingIntent;

    .line 4180
    return-void
.end method

.method static synthetic access$8200(Landroid/media/AudioService$RcClientDeathHandler;)Landroid/os/IBinder;
    .registers 2
    .parameter "x0"

    .prologue
    .line 4173
    iget-object v0, p0, Landroid/media/AudioService$RcClientDeathHandler;->mCb:Landroid/os/IBinder;

    return-object v0
.end method


# virtual methods
.method public binderDied()V
    .registers 4

    .prologue
    const/4 v2, 0x0

    .line 4183
    const-string v0, "AudioService"

    const-string v1, "  RemoteControlClient died"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 4186
    iget-object v0, p0, Landroid/media/AudioService$RcClientDeathHandler;->this$0:Landroid/media/AudioService;

    iget-object v1, p0, Landroid/media/AudioService$RcClientDeathHandler;->mMediaIntent:Landroid/app/PendingIntent;

    invoke-virtual {v0, v1, v2, v2}, Landroid/media/AudioService;->registerRemoteControlClient(Landroid/app/PendingIntent;Landroid/media/IRemoteControlClient;Ljava/lang/String;)I

    .line 4188
    iget-object v0, p0, Landroid/media/AudioService$RcClientDeathHandler;->this$0:Landroid/media/AudioService;

    #calls: Landroid/media/AudioService;->postReevaluateRemote()V
    invoke-static {v0}, Landroid/media/AudioService;->access$8000(Landroid/media/AudioService;)V

    .line 4189
    return-void
.end method

.method public getBinder()Landroid/os/IBinder;
    .registers 2

    .prologue
    .line 4192
    iget-object v0, p0, Landroid/media/AudioService$RcClientDeathHandler;->mCb:Landroid/os/IBinder;

    return-object v0
.end method
