.class Landroid/widget/RemoteViewsAdapter$RemoteViewsAdapterServiceConnection$2;
.super Ljava/lang/Object;
.source "RemoteViewsAdapter.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/widget/RemoteViewsAdapter$RemoteViewsAdapterServiceConnection;->onServiceDisconnected()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/widget/RemoteViewsAdapter$RemoteViewsAdapterServiceConnection;

.field final synthetic val$adapter:Landroid/widget/RemoteViewsAdapter;


# direct methods
.method constructor <init>(Landroid/widget/RemoteViewsAdapter$RemoteViewsAdapterServiceConnection;Landroid/widget/RemoteViewsAdapter;)V
    .registers 3
    .parameter
    .parameter

    .prologue
    .line 222
    iput-object p1, p0, Landroid/widget/RemoteViewsAdapter$RemoteViewsAdapterServiceConnection$2;->this$0:Landroid/widget/RemoteViewsAdapter$RemoteViewsAdapterServiceConnection;

    iput-object p2, p0, Landroid/widget/RemoteViewsAdapter$RemoteViewsAdapterServiceConnection$2;->val$adapter:Landroid/widget/RemoteViewsAdapter;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 4

    .prologue
    .line 226
    iget-object v1, p0, Landroid/widget/RemoteViewsAdapter$RemoteViewsAdapterServiceConnection$2;->val$adapter:Landroid/widget/RemoteViewsAdapter;

    #getter for: Landroid/widget/RemoteViewsAdapter;->mMainQueue:Landroid/os/Handler;
    invoke-static {v1}, Landroid/widget/RemoteViewsAdapter;->access$600(Landroid/widget/RemoteViewsAdapter;)Landroid/os/Handler;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/os/Handler;->removeMessages(I)V

    .line 228
    iget-object v1, p0, Landroid/widget/RemoteViewsAdapter$RemoteViewsAdapterServiceConnection$2;->val$adapter:Landroid/widget/RemoteViewsAdapter;

    #getter for: Landroid/widget/RemoteViewsAdapter;->mCallback:Ljava/lang/ref/WeakReference;
    invoke-static {v1}, Landroid/widget/RemoteViewsAdapter;->access$500(Landroid/widget/RemoteViewsAdapter;)Ljava/lang/ref/WeakReference;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/RemoteViewsAdapter$RemoteAdapterConnectionCallback;

    .line 229
    .local v0, callback:Landroid/widget/RemoteViewsAdapter$RemoteAdapterConnectionCallback;
    if-eqz v0, :cond_1b

    .line 230
    invoke-interface {v0}, Landroid/widget/RemoteViewsAdapter$RemoteAdapterConnectionCallback;->onRemoteAdapterDisconnected()V

    .line 232
    :cond_1b
    return-void
.end method
