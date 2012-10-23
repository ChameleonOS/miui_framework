.class Landroid/webkit/ZoomControlEmbedded$ZoomListener;
.super Ljava/lang/Object;
.source "ZoomControlEmbedded.java"

# interfaces
.implements Landroid/widget/ZoomButtonsController$OnZoomListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/webkit/ZoomControlEmbedded;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ZoomListener"
.end annotation


# instance fields
.field final synthetic this$0:Landroid/webkit/ZoomControlEmbedded;


# direct methods
.method private constructor <init>(Landroid/webkit/ZoomControlEmbedded;)V
    .registers 2
    .parameter

    .prologue
    .line 99
    iput-object p1, p0, Landroid/webkit/ZoomControlEmbedded$ZoomListener;->this$0:Landroid/webkit/ZoomControlEmbedded;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/webkit/ZoomControlEmbedded;Landroid/webkit/ZoomControlEmbedded$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 99
    invoke-direct {p0, p1}, Landroid/webkit/ZoomControlEmbedded$ZoomListener;-><init>(Landroid/webkit/ZoomControlEmbedded;)V

    return-void
.end method


# virtual methods
.method public onVisibilityChanged(Z)V
    .registers 4
    .parameter "visible"

    .prologue
    .line 102
    if-eqz p1, :cond_1e

    .line 103
    iget-object v0, p0, Landroid/webkit/ZoomControlEmbedded$ZoomListener;->this$0:Landroid/webkit/ZoomControlEmbedded;

    #getter for: Landroid/webkit/ZoomControlEmbedded;->mWebView:Landroid/webkit/WebViewClassic;
    invoke-static {v0}, Landroid/webkit/ZoomControlEmbedded;->access$100(Landroid/webkit/ZoomControlEmbedded;)Landroid/webkit/WebViewClassic;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/WebViewClassic;->switchOutDrawHistory()V

    .line 105
    iget-object v0, p0, Landroid/webkit/ZoomControlEmbedded$ZoomListener;->this$0:Landroid/webkit/ZoomControlEmbedded;

    #getter for: Landroid/webkit/ZoomControlEmbedded;->mZoomButtonsController:Landroid/widget/ZoomButtonsController;
    invoke-static {v0}, Landroid/webkit/ZoomControlEmbedded;->access$200(Landroid/webkit/ZoomControlEmbedded;)Landroid/widget/ZoomButtonsController;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/ZoomButtonsController;->getZoomControls()Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 106
    iget-object v0, p0, Landroid/webkit/ZoomControlEmbedded$ZoomListener;->this$0:Landroid/webkit/ZoomControlEmbedded;

    invoke-virtual {v0}, Landroid/webkit/ZoomControlEmbedded;->update()V

    .line 108
    :cond_1e
    return-void
.end method

.method public onZoom(Z)V
    .registers 3
    .parameter "zoomIn"

    .prologue
    .line 111
    if-eqz p1, :cond_11

    .line 112
    iget-object v0, p0, Landroid/webkit/ZoomControlEmbedded$ZoomListener;->this$0:Landroid/webkit/ZoomControlEmbedded;

    #getter for: Landroid/webkit/ZoomControlEmbedded;->mWebView:Landroid/webkit/WebViewClassic;
    invoke-static {v0}, Landroid/webkit/ZoomControlEmbedded;->access$100(Landroid/webkit/ZoomControlEmbedded;)Landroid/webkit/WebViewClassic;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/WebViewClassic;->zoomIn()Z

    .line 116
    :goto_b
    iget-object v0, p0, Landroid/webkit/ZoomControlEmbedded$ZoomListener;->this$0:Landroid/webkit/ZoomControlEmbedded;

    invoke-virtual {v0}, Landroid/webkit/ZoomControlEmbedded;->update()V

    .line 117
    return-void

    .line 114
    :cond_11
    iget-object v0, p0, Landroid/webkit/ZoomControlEmbedded$ZoomListener;->this$0:Landroid/webkit/ZoomControlEmbedded;

    #getter for: Landroid/webkit/ZoomControlEmbedded;->mWebView:Landroid/webkit/WebViewClassic;
    invoke-static {v0}, Landroid/webkit/ZoomControlEmbedded;->access$100(Landroid/webkit/ZoomControlEmbedded;)Landroid/webkit/WebViewClassic;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/WebViewClassic;->zoomOut()Z

    goto :goto_b
.end method
