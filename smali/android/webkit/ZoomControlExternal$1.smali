.class Landroid/webkit/ZoomControlExternal$1;
.super Ljava/lang/Object;
.source "ZoomControlExternal.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/webkit/ZoomControlExternal;->getControls()Landroid/webkit/ZoomControlExternal$ExtendedZoomControls;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/webkit/ZoomControlExternal;


# direct methods
.method constructor <init>(Landroid/webkit/ZoomControlExternal;)V
    .registers 2
    .parameter

    .prologue
    .line 77
    iput-object p1, p0, Landroid/webkit/ZoomControlExternal$1;->this$0:Landroid/webkit/ZoomControlExternal;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 5

    .prologue
    .line 82
    iget-object v0, p0, Landroid/webkit/ZoomControlExternal$1;->this$0:Landroid/webkit/ZoomControlExternal;

    #getter for: Landroid/webkit/ZoomControlExternal;->mZoomControls:Landroid/webkit/ZoomControlExternal$ExtendedZoomControls;
    invoke-static {v0}, Landroid/webkit/ZoomControlExternal;->access$000(Landroid/webkit/ZoomControlExternal;)Landroid/webkit/ZoomControlExternal$ExtendedZoomControls;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/ZoomControlExternal$ExtendedZoomControls;->hasFocus()Z

    move-result v0

    if-nez v0, :cond_16

    .line 83
    iget-object v0, p0, Landroid/webkit/ZoomControlExternal$1;->this$0:Landroid/webkit/ZoomControlExternal;

    #getter for: Landroid/webkit/ZoomControlExternal;->mZoomControls:Landroid/webkit/ZoomControlExternal$ExtendedZoomControls;
    invoke-static {v0}, Landroid/webkit/ZoomControlExternal;->access$000(Landroid/webkit/ZoomControlExternal;)Landroid/webkit/ZoomControlExternal$ExtendedZoomControls;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/ZoomControlExternal$ExtendedZoomControls;->hide()V

    .line 89
    :goto_15
    return-void

    .line 85
    :cond_16
    iget-object v0, p0, Landroid/webkit/ZoomControlExternal$1;->this$0:Landroid/webkit/ZoomControlExternal;

    #getter for: Landroid/webkit/ZoomControlExternal;->mPrivateHandler:Landroid/os/Handler;
    invoke-static {v0}, Landroid/webkit/ZoomControlExternal;->access$200(Landroid/webkit/ZoomControlExternal;)Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Landroid/webkit/ZoomControlExternal$1;->this$0:Landroid/webkit/ZoomControlExternal;

    #getter for: Landroid/webkit/ZoomControlExternal;->mZoomControlRunnable:Ljava/lang/Runnable;
    invoke-static {v1}, Landroid/webkit/ZoomControlExternal;->access$100(Landroid/webkit/ZoomControlExternal;)Ljava/lang/Runnable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 86
    iget-object v0, p0, Landroid/webkit/ZoomControlExternal$1;->this$0:Landroid/webkit/ZoomControlExternal;

    #getter for: Landroid/webkit/ZoomControlExternal;->mPrivateHandler:Landroid/os/Handler;
    invoke-static {v0}, Landroid/webkit/ZoomControlExternal;->access$200(Landroid/webkit/ZoomControlExternal;)Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Landroid/webkit/ZoomControlExternal$1;->this$0:Landroid/webkit/ZoomControlExternal;

    #getter for: Landroid/webkit/ZoomControlExternal;->mZoomControlRunnable:Ljava/lang/Runnable;
    invoke-static {v1}, Landroid/webkit/ZoomControlExternal;->access$100(Landroid/webkit/ZoomControlExternal;)Ljava/lang/Runnable;

    move-result-object v1

    invoke-static {}, Landroid/webkit/ZoomControlExternal;->access$300()J

    move-result-wide v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_15
.end method
