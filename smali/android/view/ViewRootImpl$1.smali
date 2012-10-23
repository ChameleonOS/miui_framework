.class Landroid/view/ViewRootImpl$1;
.super Ljava/lang/Object;
.source "ViewRootImpl.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/view/ViewRootImpl;->profileRendering(Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/view/ViewRootImpl;


# direct methods
.method constructor <init>(Landroid/view/ViewRootImpl;)V
    .registers 2
    .parameter

    .prologue
    .line 1960
    iput-object p1, p0, Landroid/view/ViewRootImpl$1;->this$0:Landroid/view/ViewRootImpl;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 4

    .prologue
    .line 1963
    const-string v1, "ViewRootImpl"

    const-string v2, "Starting profiling thread"

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 1964
    :goto_7
    iget-object v1, p0, Landroid/view/ViewRootImpl$1;->this$0:Landroid/view/ViewRootImpl;

    #getter for: Landroid/view/ViewRootImpl;->mRenderProfilingEnabled:Z
    invoke-static {v1}, Landroid/view/ViewRootImpl;->access$000(Landroid/view/ViewRootImpl;)Z

    move-result v1

    if-eqz v1, :cond_2c

    .line 1965
    iget-object v1, p0, Landroid/view/ViewRootImpl$1;->this$0:Landroid/view/ViewRootImpl;

    iget-object v1, v1, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    iget-object v1, v1, Landroid/view/View$AttachInfo;->mHandler:Landroid/os/Handler;

    new-instance v2, Landroid/view/ViewRootImpl$1$1;

    invoke-direct {v2, p0}, Landroid/view/ViewRootImpl$1$1;-><init>(Landroid/view/ViewRootImpl$1;)V

    invoke-virtual {v1, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 1974
    const-wide/16 v1, 0xf

    :try_start_1f
    invoke-static {v1, v2}, Ljava/lang/Thread;->sleep(J)V
    :try_end_22
    .catch Ljava/lang/InterruptedException; {:try_start_1f .. :try_end_22} :catch_23

    goto :goto_7

    .line 1975
    :catch_23
    move-exception v0

    .line 1976
    .local v0, e:Ljava/lang/InterruptedException;
    const-string v1, "ViewRootImpl"

    const-string v2, "Exiting profiling thread"

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_7

    .line 1979
    .end local v0           #e:Ljava/lang/InterruptedException;
    :cond_2c
    return-void
.end method
