.class final Landroid/os/RemoteCallbackList$Callback;
.super Ljava/lang/Object;
.source "RemoteCallbackList.java"

# interfaces
.implements Landroid/os/IBinder$DeathRecipient;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/os/RemoteCallbackList;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "Callback"
.end annotation


# instance fields
.field final mCallback:Landroid/os/IInterface;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TE;"
        }
    .end annotation
.end field

.field final mCookie:Ljava/lang/Object;

.field final synthetic this$0:Landroid/os/RemoteCallbackList;


# direct methods
.method constructor <init>(Landroid/os/RemoteCallbackList;Landroid/os/IInterface;Ljava/lang/Object;)V
    .registers 4
    .parameter
    .parameter
    .parameter "cookie"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TE;",
            "Ljava/lang/Object;",
            ")V"
        }
    .end annotation

    .prologue
    .line 60
    .local p0, this:Landroid/os/RemoteCallbackList$Callback;,"Landroid/os/RemoteCallbackList<TE;>.Callback;"
    .local p2, callback:Landroid/os/IInterface;,"TE;"
    iput-object p1, p0, Landroid/os/RemoteCallbackList$Callback;->this$0:Landroid/os/RemoteCallbackList;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 61
    iput-object p2, p0, Landroid/os/RemoteCallbackList$Callback;->mCallback:Landroid/os/IInterface;

    .line 62
    iput-object p3, p0, Landroid/os/RemoteCallbackList$Callback;->mCookie:Ljava/lang/Object;

    .line 63
    return-void
.end method


# virtual methods
.method public binderDied()V
    .registers 4

    .prologue
    .line 66
    .local p0, this:Landroid/os/RemoteCallbackList$Callback;,"Landroid/os/RemoteCallbackList<TE;>.Callback;"
    iget-object v0, p0, Landroid/os/RemoteCallbackList$Callback;->this$0:Landroid/os/RemoteCallbackList;

    iget-object v1, v0, Landroid/os/RemoteCallbackList;->mCallbacks:Ljava/util/HashMap;

    monitor-enter v1

    .line 67
    :try_start_5
    iget-object v0, p0, Landroid/os/RemoteCallbackList$Callback;->this$0:Landroid/os/RemoteCallbackList;

    iget-object v0, v0, Landroid/os/RemoteCallbackList;->mCallbacks:Ljava/util/HashMap;

    iget-object v2, p0, Landroid/os/RemoteCallbackList$Callback;->mCallback:Landroid/os/IInterface;

    invoke-interface {v2}, Landroid/os/IInterface;->asBinder()Landroid/os/IBinder;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 68
    monitor-exit v1
    :try_end_13
    .catchall {:try_start_5 .. :try_end_13} :catchall_1d

    .line 69
    iget-object v0, p0, Landroid/os/RemoteCallbackList$Callback;->this$0:Landroid/os/RemoteCallbackList;

    iget-object v1, p0, Landroid/os/RemoteCallbackList$Callback;->mCallback:Landroid/os/IInterface;

    iget-object v2, p0, Landroid/os/RemoteCallbackList$Callback;->mCookie:Ljava/lang/Object;

    invoke-virtual {v0, v1, v2}, Landroid/os/RemoteCallbackList;->onCallbackDied(Landroid/os/IInterface;Ljava/lang/Object;)V

    .line 70
    return-void

    .line 68
    :catchall_1d
    move-exception v0

    :try_start_1e
    monitor-exit v1
    :try_end_1f
    .catchall {:try_start_1e .. :try_end_1f} :catchall_1d

    throw v0
.end method
