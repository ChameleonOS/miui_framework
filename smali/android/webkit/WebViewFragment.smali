.class public Landroid/webkit/WebViewFragment;
.super Landroid/app/Fragment;
.source "WebViewFragment.java"


# instance fields
.field private mIsWebViewAvailable:Z

.field private mWebView:Landroid/webkit/WebView;


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 35
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    .line 36
    return-void
.end method


# virtual methods
.method public getWebView()Landroid/webkit/WebView;
    .registers 2

    .prologue
    .line 96
    iget-boolean v0, p0, Landroid/webkit/WebViewFragment;->mIsWebViewAvailable:Z

    if-eqz v0, :cond_7

    iget-object v0, p0, Landroid/webkit/WebViewFragment;->mWebView:Landroid/webkit/WebView;

    :goto_6
    return-object v0

    :cond_7
    const/4 v0, 0x0

    goto :goto_6
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .registers 6
    .parameter "inflater"
    .parameter "container"
    .parameter "savedInstanceState"

    .prologue
    .line 44
    iget-object v0, p0, Landroid/webkit/WebViewFragment;->mWebView:Landroid/webkit/WebView;

    if-eqz v0, :cond_9

    .line 45
    iget-object v0, p0, Landroid/webkit/WebViewFragment;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->destroy()V

    .line 47
    :cond_9
    new-instance v0, Landroid/webkit/WebView;

    invoke-virtual {p0}, Landroid/webkit/WebViewFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/webkit/WebView;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Landroid/webkit/WebViewFragment;->mWebView:Landroid/webkit/WebView;

    .line 48
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/webkit/WebViewFragment;->mIsWebViewAvailable:Z

    .line 49
    iget-object v0, p0, Landroid/webkit/WebViewFragment;->mWebView:Landroid/webkit/WebView;

    return-object v0
.end method

.method public onDestroy()V
    .registers 2

    .prologue
    .line 85
    iget-object v0, p0, Landroid/webkit/WebViewFragment;->mWebView:Landroid/webkit/WebView;

    if-eqz v0, :cond_c

    .line 86
    iget-object v0, p0, Landroid/webkit/WebViewFragment;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->destroy()V

    .line 87
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/webkit/WebViewFragment;->mWebView:Landroid/webkit/WebView;

    .line 89
    :cond_c
    invoke-super {p0}, Landroid/app/Fragment;->onDestroy()V

    .line 90
    return-void
.end method

.method public onDestroyView()V
    .registers 2

    .prologue
    .line 76
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/webkit/WebViewFragment;->mIsWebViewAvailable:Z

    .line 77
    invoke-super {p0}, Landroid/app/Fragment;->onDestroyView()V

    .line 78
    return-void
.end method

.method public onPause()V
    .registers 2

    .prologue
    .line 57
    invoke-super {p0}, Landroid/app/Fragment;->onPause()V

    .line 58
    iget-object v0, p0, Landroid/webkit/WebViewFragment;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->onPause()V

    .line 59
    return-void
.end method

.method public onResume()V
    .registers 2

    .prologue
    .line 66
    iget-object v0, p0, Landroid/webkit/WebViewFragment;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->onResume()V

    .line 67
    invoke-super {p0}, Landroid/app/Fragment;->onResume()V

    .line 68
    return-void
.end method
