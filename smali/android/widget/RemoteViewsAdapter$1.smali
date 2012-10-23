.class Landroid/widget/RemoteViewsAdapter$1;
.super Ljava/lang/Object;
.source "RemoteViewsAdapter.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/widget/RemoteViewsAdapter;->loadNextIndexInBackground()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/widget/RemoteViewsAdapter;


# direct methods
.method constructor <init>(Landroid/widget/RemoteViewsAdapter;)V
    .registers 2
    .parameter

    .prologue
    .line 759
    iput-object p1, p0, Landroid/widget/RemoteViewsAdapter$1;->this$0:Landroid/widget/RemoteViewsAdapter;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 8

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 762
    iget-object v5, p0, Landroid/widget/RemoteViewsAdapter$1;->this$0:Landroid/widget/RemoteViewsAdapter;

    #getter for: Landroid/widget/RemoteViewsAdapter;->mServiceConnection:Landroid/widget/RemoteViewsAdapter$RemoteViewsAdapterServiceConnection;
    invoke-static {v5}, Landroid/widget/RemoteViewsAdapter;->access$200(Landroid/widget/RemoteViewsAdapter;)Landroid/widget/RemoteViewsAdapter$RemoteViewsAdapterServiceConnection;

    move-result-object v5

    invoke-virtual {v5}, Landroid/widget/RemoteViewsAdapter$RemoteViewsAdapterServiceConnection;->isConnected()Z

    move-result v5

    if-eqz v5, :cond_38

    .line 764
    const/4 v1, -0x1

    .line 765
    .local v1, position:I
    const/4 v0, 0x0

    .line 766
    .local v0, isRequested:Z
    iget-object v5, p0, Landroid/widget/RemoteViewsAdapter$1;->this$0:Landroid/widget/RemoteViewsAdapter;

    #getter for: Landroid/widget/RemoteViewsAdapter;->mCache:Landroid/widget/RemoteViewsAdapter$FixedSizeRemoteViewsCache;
    invoke-static {v5}, Landroid/widget/RemoteViewsAdapter;->access$400(Landroid/widget/RemoteViewsAdapter;)Landroid/widget/RemoteViewsAdapter$FixedSizeRemoteViewsCache;

    move-result-object v5

    monitor-enter v5

    .line 767
    :try_start_17
    iget-object v6, p0, Landroid/widget/RemoteViewsAdapter$1;->this$0:Landroid/widget/RemoteViewsAdapter;

    #getter for: Landroid/widget/RemoteViewsAdapter;->mCache:Landroid/widget/RemoteViewsAdapter$FixedSizeRemoteViewsCache;
    invoke-static {v6}, Landroid/widget/RemoteViewsAdapter;->access$400(Landroid/widget/RemoteViewsAdapter;)Landroid/widget/RemoteViewsAdapter$FixedSizeRemoteViewsCache;

    move-result-object v6

    invoke-virtual {v6}, Landroid/widget/RemoteViewsAdapter$FixedSizeRemoteViewsCache;->getNextIndexToLoad()[I

    move-result-object v2

    .line 768
    .local v2, res:[I
    const/4 v6, 0x0

    aget v1, v2, v6

    .line 769
    const/4 v6, 0x1

    aget v6, v2, v6

    if-lez v6, :cond_39

    move v0, v3

    .line 770
    :goto_2a
    monitor-exit v5
    :try_end_2b
    .catchall {:try_start_17 .. :try_end_2b} :catchall_3b

    .line 771
    const/4 v4, -0x1

    if-le v1, v4, :cond_3e

    .line 773
    iget-object v4, p0, Landroid/widget/RemoteViewsAdapter$1;->this$0:Landroid/widget/RemoteViewsAdapter;

    #calls: Landroid/widget/RemoteViewsAdapter;->updateRemoteViews(IZZ)V
    invoke-static {v4, v1, v0, v3}, Landroid/widget/RemoteViewsAdapter;->access$1300(Landroid/widget/RemoteViewsAdapter;IZZ)V

    .line 776
    iget-object v3, p0, Landroid/widget/RemoteViewsAdapter$1;->this$0:Landroid/widget/RemoteViewsAdapter;

    #calls: Landroid/widget/RemoteViewsAdapter;->loadNextIndexInBackground()V
    invoke-static {v3}, Landroid/widget/RemoteViewsAdapter;->access$1400(Landroid/widget/RemoteViewsAdapter;)V

    .line 782
    .end local v0           #isRequested:Z
    .end local v1           #position:I
    .end local v2           #res:[I
    :cond_38
    :goto_38
    return-void

    .restart local v0       #isRequested:Z
    .restart local v1       #position:I
    .restart local v2       #res:[I
    :cond_39
    move v0, v4

    .line 769
    goto :goto_2a

    .line 770
    .end local v2           #res:[I
    :catchall_3b
    move-exception v3

    :try_start_3c
    monitor-exit v5
    :try_end_3d
    .catchall {:try_start_3c .. :try_end_3d} :catchall_3b

    throw v3

    .line 779
    .restart local v2       #res:[I
    :cond_3e
    iget-object v3, p0, Landroid/widget/RemoteViewsAdapter$1;->this$0:Landroid/widget/RemoteViewsAdapter;

    #calls: Landroid/widget/RemoteViewsAdapter;->enqueueDeferredUnbindServiceMessage()V
    invoke-static {v3}, Landroid/widget/RemoteViewsAdapter;->access$700(Landroid/widget/RemoteViewsAdapter;)V

    goto :goto_38
.end method
