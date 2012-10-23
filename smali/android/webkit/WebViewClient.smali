.class public Landroid/webkit/WebViewClient;
.super Ljava/lang/Object;
.source "WebViewClient.java"


# static fields
.field public static final ERROR_AUTHENTICATION:I = -0x4

.field public static final ERROR_BAD_URL:I = -0xc

.field public static final ERROR_CONNECT:I = -0x6

.field public static final ERROR_FAILED_SSL_HANDSHAKE:I = -0xb

.field public static final ERROR_FILE:I = -0xd

.field public static final ERROR_FILE_NOT_FOUND:I = -0xe

.field public static final ERROR_HOST_LOOKUP:I = -0x2

.field public static final ERROR_IO:I = -0x7

.field public static final ERROR_PROXY_AUTHENTICATION:I = -0x5

.field public static final ERROR_REDIRECT_LOOP:I = -0x9

.field public static final ERROR_TIMEOUT:I = -0x8

.field public static final ERROR_TOO_MANY_REQUESTS:I = -0xf

.field public static final ERROR_UNKNOWN:I = -0x1

.field public static final ERROR_UNSUPPORTED_AUTH_SCHEME:I = -0x3

.field public static final ERROR_UNSUPPORTED_SCHEME:I = -0xa


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 25
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public doUpdateVisitedHistory(Landroid/webkit/WebView;Ljava/lang/String;Z)V
    .registers 4
    .parameter "view"
    .parameter "url"
    .parameter "isReload"

    .prologue
    .line 187
    return-void
.end method

.method public onFormResubmission(Landroid/webkit/WebView;Landroid/os/Message;Landroid/os/Message;)V
    .registers 4
    .parameter "view"
    .parameter "dontResend"
    .parameter "resend"

    .prologue
    .line 175
    invoke-virtual {p2}, Landroid/os/Message;->sendToTarget()V

    .line 176
    return-void
.end method

.method public onLoadResource(Landroid/webkit/WebView;Ljava/lang/String;)V
    .registers 3
    .parameter "view"
    .parameter "url"

    .prologue
    .line 79
    return-void
.end method

.method public onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
    .registers 3
    .parameter "view"
    .parameter "url"

    .prologue
    .line 69
    return-void
.end method

.method public onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .registers 4
    .parameter "view"
    .parameter "url"
    .parameter "favicon"

    .prologue
    .line 57
    return-void
.end method

.method public onProceededAfterSslError(Landroid/webkit/WebView;Landroid/net/http/SslError;)V
    .registers 3
    .parameter "view"
    .parameter "error"

    .prologue
    .line 213
    return-void
.end method

.method public onReceivedClientCertRequest(Landroid/webkit/WebView;Landroid/webkit/ClientCertRequestHandler;Ljava/lang/String;)V
    .registers 4
    .parameter "view"
    .parameter "handler"
    .parameter "host_and_port"

    .prologue
    .line 232
    invoke-virtual {p2}, Landroid/webkit/ClientCertRequestHandler;->cancel()V

    .line 233
    return-void
.end method

.method public onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V
    .registers 5
    .parameter "view"
    .parameter "errorCode"
    .parameter "description"
    .parameter "failingUrl"

    .prologue
    .line 162
    return-void
.end method

.method public onReceivedHttpAuthRequest(Landroid/webkit/WebView;Landroid/webkit/HttpAuthHandler;Ljava/lang/String;Ljava/lang/String;)V
    .registers 5
    .parameter "view"
    .parameter "handler"
    .parameter "host"
    .parameter "realm"

    .prologue
    .line 247
    invoke-virtual {p2}, Landroid/webkit/HttpAuthHandler;->cancel()V

    .line 248
    return-void
.end method

.method public onReceivedLoginRequest(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .registers 5
    .parameter "view"
    .parameter "realm"
    .parameter "account"
    .parameter "args"

    .prologue
    .line 306
    return-void
.end method

.method public onReceivedSslError(Landroid/webkit/WebView;Landroid/webkit/SslErrorHandler;Landroid/net/http/SslError;)V
    .registers 4
    .parameter "view"
    .parameter "handler"
    .parameter "error"

    .prologue
    .line 203
    invoke-virtual {p2}, Landroid/webkit/SslErrorHandler;->cancel()V

    .line 204
    return-void
.end method

.method public onScaleChanged(Landroid/webkit/WebView;FF)V
    .registers 4
    .parameter "view"
    .parameter "oldScale"
    .parameter "newScale"

    .prologue
    .line 292
    return-void
.end method

.method public onTooManyRedirects(Landroid/webkit/WebView;Landroid/os/Message;Landroid/os/Message;)V
    .registers 4
    .parameter "view"
    .parameter "cancelMsg"
    .parameter "continueMsg"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 116
    invoke-virtual {p2}, Landroid/os/Message;->sendToTarget()V

    .line 117
    return-void
.end method

.method public onUnhandledKeyEvent(Landroid/webkit/WebView;Landroid/view/KeyEvent;)V
    .registers 4
    .parameter "view"
    .parameter "event"

    .prologue
    .line 277
    invoke-virtual {p1}, Landroid/webkit/WebView;->getViewRootImpl()Landroid/view/ViewRootImpl;

    move-result-object v0

    .line 278
    .local v0, root:Landroid/view/ViewRootImpl;
    if-eqz v0, :cond_9

    .line 279
    invoke-virtual {v0, p2}, Landroid/view/ViewRootImpl;->dispatchUnhandledKey(Landroid/view/KeyEvent;)V

    .line 281
    :cond_9
    return-void
.end method

.method public shouldInterceptRequest(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;
    .registers 4
    .parameter "view"
    .parameter "url"

    .prologue
    .line 98
    const/4 v0, 0x0

    return-object v0
.end method

.method public shouldOverrideKeyEvent(Landroid/webkit/WebView;Landroid/view/KeyEvent;)Z
    .registers 4
    .parameter "view"
    .parameter "event"

    .prologue
    .line 263
    const/4 v0, 0x0

    return v0
.end method

.method public shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .registers 4
    .parameter "view"
    .parameter "url"

    .prologue
    .line 41
    const/4 v0, 0x0

    return v0
.end method
