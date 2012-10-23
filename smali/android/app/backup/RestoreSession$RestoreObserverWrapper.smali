.class Landroid/app/backup/RestoreSession$RestoreObserverWrapper;
.super Landroid/app/backup/IRestoreObserver$Stub;
.source "RestoreSession.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/app/backup/RestoreSession;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "RestoreObserverWrapper"
.end annotation


# static fields
.field static final MSG_RESTORE_FINISHED:I = 0x3

.field static final MSG_RESTORE_SETS_AVAILABLE:I = 0x4

.field static final MSG_RESTORE_STARTING:I = 0x1

.field static final MSG_UPDATE:I = 0x2


# instance fields
.field final mAppObserver:Landroid/app/backup/RestoreObserver;

.field final mHandler:Landroid/os/Handler;

.field final synthetic this$0:Landroid/app/backup/RestoreSession;


# direct methods
.method constructor <init>(Landroid/app/backup/RestoreSession;Landroid/content/Context;Landroid/app/backup/RestoreObserver;)V
    .registers 6
    .parameter
    .parameter "context"
    .parameter "appObserver"

    .prologue
    .line 193
    iput-object p1, p0, Landroid/app/backup/RestoreSession$RestoreObserverWrapper;->this$0:Landroid/app/backup/RestoreSession;

    invoke-direct {p0}, Landroid/app/backup/IRestoreObserver$Stub;-><init>()V

    .line 194
    new-instance v0, Landroid/app/backup/RestoreSession$RestoreObserverWrapper$1;

    invoke-virtual {p2}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, p0, v1, p1}, Landroid/app/backup/RestoreSession$RestoreObserverWrapper$1;-><init>(Landroid/app/backup/RestoreSession$RestoreObserverWrapper;Landroid/os/Looper;Landroid/app/backup/RestoreSession;)V

    iput-object v0, p0, Landroid/app/backup/RestoreSession$RestoreObserverWrapper;->mHandler:Landroid/os/Handler;

    .line 213
    iput-object p3, p0, Landroid/app/backup/RestoreSession$RestoreObserverWrapper;->mAppObserver:Landroid/app/backup/RestoreObserver;

    .line 214
    return-void
.end method


# virtual methods
.method public onUpdate(ILjava/lang/String;)V
    .registers 7
    .parameter "nowBeingRestored"
    .parameter "currentPackage"

    .prologue
    .line 228
    iget-object v0, p0, Landroid/app/backup/RestoreSession$RestoreObserverWrapper;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Landroid/app/backup/RestoreSession$RestoreObserverWrapper;->mHandler:Landroid/os/Handler;

    const/4 v2, 0x2

    const/4 v3, 0x0

    invoke-virtual {v1, v2, p1, v3, p2}, Landroid/os/Handler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 230
    return-void
.end method

.method public restoreFinished(I)V
    .registers 6
    .parameter "error"

    .prologue
    .line 233
    iget-object v0, p0, Landroid/app/backup/RestoreSession$RestoreObserverWrapper;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Landroid/app/backup/RestoreSession$RestoreObserverWrapper;->mHandler:Landroid/os/Handler;

    const/4 v2, 0x3

    const/4 v3, 0x0

    invoke-virtual {v1, v2, p1, v3}, Landroid/os/Handler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 235
    return-void
.end method

.method public restoreSetsAvailable([Landroid/app/backup/RestoreSet;)V
    .registers 5
    .parameter "result"

    .prologue
    .line 218
    iget-object v0, p0, Landroid/app/backup/RestoreSession$RestoreObserverWrapper;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Landroid/app/backup/RestoreSession$RestoreObserverWrapper;->mHandler:Landroid/os/Handler;

    const/4 v2, 0x4

    invoke-virtual {v1, v2, p1}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 220
    return-void
.end method

.method public restoreStarting(I)V
    .registers 6
    .parameter "numPackages"

    .prologue
    .line 223
    iget-object v0, p0, Landroid/app/backup/RestoreSession$RestoreObserverWrapper;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Landroid/app/backup/RestoreSession$RestoreObserverWrapper;->mHandler:Landroid/os/Handler;

    const/4 v2, 0x1

    const/4 v3, 0x0

    invoke-virtual {v1, v2, p1, v3}, Landroid/os/Handler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 225
    return-void
.end method
