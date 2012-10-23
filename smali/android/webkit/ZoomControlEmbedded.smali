.class Landroid/webkit/ZoomControlEmbedded;
.super Ljava/lang/Object;
.source "ZoomControlEmbedded.java"

# interfaces
.implements Landroid/webkit/ZoomControlBase;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/webkit/ZoomControlEmbedded$1;,
        Landroid/webkit/ZoomControlEmbedded$ZoomListener;
    }
.end annotation


# instance fields
.field private final mWebView:Landroid/webkit/WebViewClassic;

.field private mZoomButtonsController:Landroid/widget/ZoomButtonsController;

.field private final mZoomManager:Landroid/webkit/ZoomManager;


# direct methods
.method public constructor <init>(Landroid/webkit/ZoomManager;Landroid/webkit/WebViewClassic;)V
    .registers 3
    .parameter "zoomManager"
    .parameter "webView"

    .prologue
    .line 33
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 34
    iput-object p1, p0, Landroid/webkit/ZoomControlEmbedded;->mZoomManager:Landroid/webkit/ZoomManager;

    .line 35
    iput-object p2, p0, Landroid/webkit/ZoomControlEmbedded;->mWebView:Landroid/webkit/WebViewClassic;

    .line 36
    return-void
.end method

.method static synthetic access$100(Landroid/webkit/ZoomControlEmbedded;)Landroid/webkit/WebViewClassic;
    .registers 2
    .parameter "x0"

    .prologue
    .line 25
    iget-object v0, p0, Landroid/webkit/ZoomControlEmbedded;->mWebView:Landroid/webkit/WebViewClassic;

    return-object v0
.end method

.method static synthetic access$200(Landroid/webkit/ZoomControlEmbedded;)Landroid/widget/ZoomButtonsController;
    .registers 2
    .parameter "x0"

    .prologue
    .line 25
    iget-object v0, p0, Landroid/webkit/ZoomControlEmbedded;->mZoomButtonsController:Landroid/widget/ZoomButtonsController;

    return-object v0
.end method

.method private getControls()Landroid/widget/ZoomButtonsController;
    .registers 6

    .prologue
    .line 84
    iget-object v2, p0, Landroid/webkit/ZoomControlEmbedded;->mZoomButtonsController:Landroid/widget/ZoomButtonsController;

    if-nez v2, :cond_2f

    .line 85
    new-instance v2, Landroid/widget/ZoomButtonsController;

    iget-object v3, p0, Landroid/webkit/ZoomControlEmbedded;->mWebView:Landroid/webkit/WebViewClassic;

    invoke-virtual {v3}, Landroid/webkit/WebViewClassic;->getWebView()Landroid/webkit/WebView;

    move-result-object v3

    invoke-direct {v2, v3}, Landroid/widget/ZoomButtonsController;-><init>(Landroid/view/View;)V

    iput-object v2, p0, Landroid/webkit/ZoomControlEmbedded;->mZoomButtonsController:Landroid/widget/ZoomButtonsController;

    .line 86
    iget-object v2, p0, Landroid/webkit/ZoomControlEmbedded;->mZoomButtonsController:Landroid/widget/ZoomButtonsController;

    new-instance v3, Landroid/webkit/ZoomControlEmbedded$ZoomListener;

    const/4 v4, 0x0

    invoke-direct {v3, p0, v4}, Landroid/webkit/ZoomControlEmbedded$ZoomListener;-><init>(Landroid/webkit/ZoomControlEmbedded;Landroid/webkit/ZoomControlEmbedded$1;)V

    invoke-virtual {v2, v3}, Landroid/widget/ZoomButtonsController;->setOnZoomListener(Landroid/widget/ZoomButtonsController$OnZoomListener;)V

    .line 90
    iget-object v2, p0, Landroid/webkit/ZoomControlEmbedded;->mZoomButtonsController:Landroid/widget/ZoomButtonsController;

    invoke-virtual {v2}, Landroid/widget/ZoomButtonsController;->getZoomControls()Landroid/view/View;

    move-result-object v0

    .line 91
    .local v0, controls:Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    .line 92
    .local v1, params:Landroid/view/ViewGroup$LayoutParams;
    instance-of v2, v1, Landroid/widget/FrameLayout$LayoutParams;

    if-eqz v2, :cond_2f

    .line 93
    check-cast v1, Landroid/widget/FrameLayout$LayoutParams;

    .end local v1           #params:Landroid/view/ViewGroup$LayoutParams;
    const/4 v2, 0x5

    iput v2, v1, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    .line 96
    .end local v0           #controls:Landroid/view/View;
    :cond_2f
    iget-object v2, p0, Landroid/webkit/ZoomControlEmbedded;->mZoomButtonsController:Landroid/widget/ZoomButtonsController;

    return-object v2
.end method


# virtual methods
.method public hide()V
    .registers 3

    .prologue
    .line 57
    iget-object v0, p0, Landroid/webkit/ZoomControlEmbedded;->mZoomButtonsController:Landroid/widget/ZoomButtonsController;

    if-eqz v0, :cond_a

    .line 58
    iget-object v0, p0, Landroid/webkit/ZoomControlEmbedded;->mZoomButtonsController:Landroid/widget/ZoomButtonsController;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ZoomButtonsController;->setVisible(Z)V

    .line 60
    :cond_a
    return-void
.end method

.method public isVisible()Z
    .registers 2

    .prologue
    .line 63
    iget-object v0, p0, Landroid/webkit/ZoomControlEmbedded;->mZoomButtonsController:Landroid/widget/ZoomButtonsController;

    if-eqz v0, :cond_e

    iget-object v0, p0, Landroid/webkit/ZoomControlEmbedded;->mZoomButtonsController:Landroid/widget/ZoomButtonsController;

    invoke-virtual {v0}, Landroid/widget/ZoomButtonsController;->isVisible()Z

    move-result v0

    if-eqz v0, :cond_e

    const/4 v0, 0x1

    :goto_d
    return v0

    :cond_e
    const/4 v0, 0x0

    goto :goto_d
.end method

.method public show()V
    .registers 6

    .prologue
    const/4 v4, 0x1

    .line 39
    invoke-direct {p0}, Landroid/webkit/ZoomControlEmbedded;->getControls()Landroid/widget/ZoomButtonsController;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/ZoomButtonsController;->isVisible()Z

    move-result v2

    if-nez v2, :cond_49

    iget-object v2, p0, Landroid/webkit/ZoomControlEmbedded;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v2}, Landroid/webkit/ZoomManager;->isZoomScaleFixed()Z

    move-result v2

    if-nez v2, :cond_49

    .line 41
    iget-object v2, p0, Landroid/webkit/ZoomControlEmbedded;->mZoomButtonsController:Landroid/widget/ZoomButtonsController;

    invoke-virtual {v2, v4}, Landroid/widget/ZoomButtonsController;->setVisible(Z)V

    .line 43
    iget-object v2, p0, Landroid/webkit/ZoomControlEmbedded;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v2}, Landroid/webkit/ZoomManager;->isDoubleTapEnabled()Z

    move-result v2

    if-eqz v2, :cond_49

    .line 44
    iget-object v2, p0, Landroid/webkit/ZoomControlEmbedded;->mWebView:Landroid/webkit/WebViewClassic;

    invoke-virtual {v2}, Landroid/webkit/WebViewClassic;->getSettings()Landroid/webkit/WebSettingsClassic;

    move-result-object v1

    .line 45
    .local v1, settings:Landroid/webkit/WebSettingsClassic;
    invoke-virtual {v1}, Landroid/webkit/WebSettingsClassic;->getDoubleTapToastCount()I

    move-result v0

    .line 46
    .local v0, count:I
    iget-object v2, p0, Landroid/webkit/ZoomControlEmbedded;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v2}, Landroid/webkit/ZoomManager;->isInZoomOverview()Z

    move-result v2

    if-eqz v2, :cond_49

    if-lez v0, :cond_49

    .line 47
    add-int/lit8 v0, v0, -0x1

    invoke-virtual {v1, v0}, Landroid/webkit/WebSettingsClassic;->setDoubleTapToastCount(I)V

    .line 48
    iget-object v2, p0, Landroid/webkit/ZoomControlEmbedded;->mWebView:Landroid/webkit/WebViewClassic;

    invoke-virtual {v2}, Landroid/webkit/WebViewClassic;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x1040341

    invoke-static {v2, v3, v4}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/Toast;->show()V

    .line 54
    .end local v0           #count:I
    .end local v1           #settings:Landroid/webkit/WebSettingsClassic;
    :cond_49
    return-void
.end method

.method public update()V
    .registers 5

    .prologue
    .line 67
    iget-object v2, p0, Landroid/webkit/ZoomControlEmbedded;->mZoomButtonsController:Landroid/widget/ZoomButtonsController;

    if-nez v2, :cond_5

    .line 81
    :goto_4
    return-void

    .line 71
    :cond_5
    iget-object v2, p0, Landroid/webkit/ZoomControlEmbedded;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v2}, Landroid/webkit/ZoomManager;->canZoomIn()Z

    move-result v0

    .line 72
    .local v0, canZoomIn:Z
    iget-object v2, p0, Landroid/webkit/ZoomControlEmbedded;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v2}, Landroid/webkit/ZoomManager;->canZoomOut()Z

    move-result v2

    if-eqz v2, :cond_2c

    iget-object v2, p0, Landroid/webkit/ZoomControlEmbedded;->mZoomManager:Landroid/webkit/ZoomManager;

    invoke-virtual {v2}, Landroid/webkit/ZoomManager;->isInZoomOverview()Z

    move-result v2

    if-nez v2, :cond_2c

    const/4 v1, 0x1

    .line 73
    .local v1, canZoomOut:Z
    :goto_1c
    if-nez v0, :cond_2e

    if-nez v1, :cond_2e

    .line 75
    iget-object v2, p0, Landroid/webkit/ZoomControlEmbedded;->mZoomButtonsController:Landroid/widget/ZoomButtonsController;

    invoke-virtual {v2}, Landroid/widget/ZoomButtonsController;->getZoomControls()Landroid/view/View;

    move-result-object v2

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/view/View;->setVisibility(I)V

    goto :goto_4

    .line 72
    .end local v1           #canZoomOut:Z
    :cond_2c
    const/4 v1, 0x0

    goto :goto_1c

    .line 78
    .restart local v1       #canZoomOut:Z
    :cond_2e
    iget-object v2, p0, Landroid/webkit/ZoomControlEmbedded;->mZoomButtonsController:Landroid/widget/ZoomButtonsController;

    invoke-virtual {v2, v0}, Landroid/widget/ZoomButtonsController;->setZoomInEnabled(Z)V

    .line 79
    iget-object v2, p0, Landroid/webkit/ZoomControlEmbedded;->mZoomButtonsController:Landroid/widget/ZoomButtonsController;

    invoke-virtual {v2, v1}, Landroid/widget/ZoomButtonsController;->setZoomOutEnabled(Z)V

    goto :goto_4
.end method
