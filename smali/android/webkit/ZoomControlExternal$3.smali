.class Landroid/webkit/ZoomControlExternal$3;
.super Ljava/lang/Object;
.source "ZoomControlExternal.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/webkit/ZoomControlExternal;->createZoomControls()Landroid/webkit/ZoomControlExternal$ExtendedZoomControls;
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
    .line 105
    iput-object p1, p0, Landroid/webkit/ZoomControlExternal$3;->this$0:Landroid/webkit/ZoomControlExternal;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .registers 6
    .parameter "v"

    .prologue
    .line 108
    iget-object v0, p0, Landroid/webkit/ZoomControlExternal$3;->this$0:Landroid/webkit/ZoomControlExternal;

    #getter for: Landroid/webkit/ZoomControlExternal;->mPrivateHandler:Landroid/os/Handler;
    invoke-static {v0}, Landroid/webkit/ZoomControlExternal;->access$200(Landroid/webkit/ZoomControlExternal;)Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Landroid/webkit/ZoomControlExternal$3;->this$0:Landroid/webkit/ZoomControlExternal;

    #getter for: Landroid/webkit/ZoomControlExternal;->mZoomControlRunnable:Ljava/lang/Runnable;
    invoke-static {v1}, Landroid/webkit/ZoomControlExternal;->access$100(Landroid/webkit/ZoomControlExternal;)Ljava/lang/Runnable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 109
    iget-object v0, p0, Landroid/webkit/ZoomControlExternal$3;->this$0:Landroid/webkit/ZoomControlExternal;

    #getter for: Landroid/webkit/ZoomControlExternal;->mPrivateHandler:Landroid/os/Handler;
    invoke-static {v0}, Landroid/webkit/ZoomControlExternal;->access$200(Landroid/webkit/ZoomControlExternal;)Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Landroid/webkit/ZoomControlExternal$3;->this$0:Landroid/webkit/ZoomControlExternal;

    #getter for: Landroid/webkit/ZoomControlExternal;->mZoomControlRunnable:Ljava/lang/Runnable;
    invoke-static {v1}, Landroid/webkit/ZoomControlExternal;->access$100(Landroid/webkit/ZoomControlExternal;)Ljava/lang/Runnable;

    move-result-object v1

    invoke-static {}, Landroid/webkit/ZoomControlExternal;->access$300()J

    move-result-wide v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 110
    iget-object v0, p0, Landroid/webkit/ZoomControlExternal$3;->this$0:Landroid/webkit/ZoomControlExternal;

    #getter for: Landroid/webkit/ZoomControlExternal;->mWebView:Landroid/webkit/WebViewClassic;
    invoke-static {v0}, Landroid/webkit/ZoomControlExternal;->access$400(Landroid/webkit/ZoomControlExternal;)Landroid/webkit/WebViewClassic;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/WebViewClassic;->zoomOut()Z

    .line 111
    return-void
.end method
