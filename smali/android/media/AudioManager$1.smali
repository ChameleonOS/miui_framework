.class Landroid/media/AudioManager$1;
.super Landroid/media/IAudioFocusDispatcher$Stub;
.source "AudioManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/media/AudioManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/media/AudioManager;


# direct methods
.method constructor <init>(Landroid/media/AudioManager;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Landroid/media/AudioManager$1;->this$0:Landroid/media/AudioManager;

    invoke-direct {p0}, Landroid/media/IAudioFocusDispatcher$Stub;-><init>()V

    return-void
.end method


# virtual methods
.method public dispatchAudioFocusChange(ILjava/lang/String;)V
    .registers 5
    .parameter "focusChange"
    .parameter "id"

    .prologue
    iget-object v1, p0, Landroid/media/AudioManager$1;->this$0:Landroid/media/AudioManager;

    #getter for: Landroid/media/AudioManager;->mAudioFocusEventHandlerDelegate:Landroid/media/AudioManager$FocusEventHandlerDelegate;
    invoke-static {v1}, Landroid/media/AudioManager;->access$200(Landroid/media/AudioManager;)Landroid/media/AudioManager$FocusEventHandlerDelegate;

    move-result-object v1

    invoke-virtual {v1}, Landroid/media/AudioManager$FocusEventHandlerDelegate;->getHandler()Landroid/os/Handler;

    move-result-object v1

    invoke-virtual {v1, p1, p2}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    .local v0, m:Landroid/os/Message;
    iget-object v1, p0, Landroid/media/AudioManager$1;->this$0:Landroid/media/AudioManager;

    #getter for: Landroid/media/AudioManager;->mAudioFocusEventHandlerDelegate:Landroid/media/AudioManager$FocusEventHandlerDelegate;
    invoke-static {v1}, Landroid/media/AudioManager;->access$200(Landroid/media/AudioManager;)Landroid/media/AudioManager$FocusEventHandlerDelegate;

    move-result-object v1

    invoke-virtual {v1}, Landroid/media/AudioManager$FocusEventHandlerDelegate;->getHandler()Landroid/os/Handler;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    return-void
.end method
