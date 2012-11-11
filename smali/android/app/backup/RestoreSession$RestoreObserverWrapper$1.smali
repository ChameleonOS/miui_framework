.class Landroid/app/backup/RestoreSession$RestoreObserverWrapper$1;
.super Landroid/os/Handler;
.source "RestoreSession.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/app/backup/RestoreSession$RestoreObserverWrapper;-><init>(Landroid/app/backup/RestoreSession;Landroid/content/Context;Landroid/app/backup/RestoreObserver;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Landroid/app/backup/RestoreSession$RestoreObserverWrapper;

.field final synthetic val$this$0:Landroid/app/backup/RestoreSession;


# direct methods
.method constructor <init>(Landroid/app/backup/RestoreSession$RestoreObserverWrapper;Landroid/os/Looper;Landroid/app/backup/RestoreSession;)V
    .registers 4
    .parameter
    .parameter "x0"
    .parameter

    .prologue
    iput-object p1, p0, Landroid/app/backup/RestoreSession$RestoreObserverWrapper$1;->this$1:Landroid/app/backup/RestoreSession$RestoreObserverWrapper;

    iput-object p3, p0, Landroid/app/backup/RestoreSession$RestoreObserverWrapper$1;->val$this$0:Landroid/app/backup/RestoreSession;

    invoke-direct {p0, p2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .registers 5
    .parameter "msg"

    .prologue
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_36

    :goto_5
    return-void

    :pswitch_6
    iget-object v0, p0, Landroid/app/backup/RestoreSession$RestoreObserverWrapper$1;->this$1:Landroid/app/backup/RestoreSession$RestoreObserverWrapper;

    iget-object v0, v0, Landroid/app/backup/RestoreSession$RestoreObserverWrapper;->mAppObserver:Landroid/app/backup/RestoreObserver;

    iget v1, p1, Landroid/os/Message;->arg1:I

    invoke-virtual {v0, v1}, Landroid/app/backup/RestoreObserver;->restoreStarting(I)V

    goto :goto_5

    :pswitch_10
    iget-object v0, p0, Landroid/app/backup/RestoreSession$RestoreObserverWrapper$1;->this$1:Landroid/app/backup/RestoreSession$RestoreObserverWrapper;

    iget-object v1, v0, Landroid/app/backup/RestoreSession$RestoreObserverWrapper;->mAppObserver:Landroid/app/backup/RestoreObserver;

    iget v2, p1, Landroid/os/Message;->arg1:I

    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v1, v2, v0}, Landroid/app/backup/RestoreObserver;->onUpdate(ILjava/lang/String;)V

    goto :goto_5

    :pswitch_1e
    iget-object v0, p0, Landroid/app/backup/RestoreSession$RestoreObserverWrapper$1;->this$1:Landroid/app/backup/RestoreSession$RestoreObserverWrapper;

    iget-object v0, v0, Landroid/app/backup/RestoreSession$RestoreObserverWrapper;->mAppObserver:Landroid/app/backup/RestoreObserver;

    iget v1, p1, Landroid/os/Message;->arg1:I

    invoke-virtual {v0, v1}, Landroid/app/backup/RestoreObserver;->restoreFinished(I)V

    goto :goto_5

    :pswitch_28
    iget-object v0, p0, Landroid/app/backup/RestoreSession$RestoreObserverWrapper$1;->this$1:Landroid/app/backup/RestoreSession$RestoreObserverWrapper;

    iget-object v1, v0, Landroid/app/backup/RestoreSession$RestoreObserverWrapper;->mAppObserver:Landroid/app/backup/RestoreObserver;

    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, [Landroid/app/backup/RestoreSet;

    check-cast v0, [Landroid/app/backup/RestoreSet;

    invoke-virtual {v1, v0}, Landroid/app/backup/RestoreObserver;->restoreSetsAvailable([Landroid/app/backup/RestoreSet;)V

    goto :goto_5

    :pswitch_data_36
    .packed-switch 0x1
        :pswitch_6
        :pswitch_10
        :pswitch_1e
        :pswitch_28
    .end packed-switch
.end method
