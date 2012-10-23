.class final Landroid/webkit/JWebCoreJavaBridge;
.super Landroid/os/Handler;
.source "JWebCoreJavaBridge.java"


# static fields
.field private static final FUNCPTR_MESSAGE:I = 0x2

.field private static final LOGTAG:Ljava/lang/String; = "webkit-timers"

.field static final REFRESH_PLUGINS:I = 0x64

.field private static final TIMER_MESSAGE:I = 0x1

.field private static sCurrentMainWebView:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Landroid/webkit/WebViewClassic;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private mContentUriToFilePathMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mHasDeferredTimers:Z

.field private mHasInstantTimer:Z

.field private mNativeBridge:I

.field private mTimerPaused:Z


# direct methods
.method static constructor <clinit>()V
    .registers 2

    .prologue
    .line 48
    new-instance v0, Ljava/lang/ref/WeakReference;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    sput-object v0, Landroid/webkit/JWebCoreJavaBridge;->sCurrentMainWebView:Ljava/lang/ref/WeakReference;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 60
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    .line 61
    invoke-direct {p0}, Landroid/webkit/JWebCoreJavaBridge;->nativeConstructor()V

    .line 63
    return-void
.end method

.method private cookies(Ljava/lang/String;)Ljava/lang/String;
    .registers 3
    .parameter "url"

    .prologue
    .line 195
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/webkit/CookieManager;->getCookie(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private cookiesEnabled()Z
    .registers 2

    .prologue
    .line 202
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/CookieManager;->acceptCookie()Z

    move-result v0

    return v0
.end method

.method private fireSharedTimer()V
    .registers 2

    .prologue
    .line 91
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/webkit/JWebCoreJavaBridge;->mHasInstantTimer:Z

    .line 92
    invoke-direct {p0}, Landroid/webkit/JWebCoreJavaBridge;->sharedTimerFired()V

    .line 93
    return-void
.end method

.method private getKeyStrengthList()[Ljava/lang/String;
    .registers 2

    .prologue
    .line 257
    invoke-static {}, Landroid/webkit/CertTool;->getKeyStrengthList()[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getPluginDirectories()[Ljava/lang/String;
    .registers 2

    .prologue
    .line 209
    const/4 v0, 0x0

    invoke-static {v0}, Landroid/webkit/PluginManager;->getInstance(Landroid/content/Context;)Landroid/webkit/PluginManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/PluginManager;->getPluginDirectories()[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getPluginSharedDataDirectory()Ljava/lang/String;
    .registers 2

    .prologue
    .line 216
    const/4 v0, 0x0

    invoke-static {v0}, Landroid/webkit/PluginManager;->getInstance(Landroid/content/Context;)Landroid/webkit/PluginManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/PluginManager;->getPluginSharedDataDirectory()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private declared-synchronized getSignedPublicKey(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .registers 7
    .parameter "index"
    .parameter "challenge"
    .parameter "url"

    .prologue
    .line 262
    monitor-enter p0

    :try_start_1
    sget-object v1, Landroid/webkit/JWebCoreJavaBridge;->sCurrentMainWebView:Ljava/lang/ref/WeakReference;

    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/webkit/WebViewClassic;

    .line 263
    .local v0, current:Landroid/webkit/WebViewClassic;
    if-eqz v0, :cond_15

    .line 266
    invoke-virtual {v0}, Landroid/webkit/WebViewClassic;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1, p1, p2}, Landroid/webkit/CertTool;->getSignedPublicKey(Landroid/content/Context;ILjava/lang/String;)Ljava/lang/String;
    :try_end_12
    .catchall {:try_start_1 .. :try_end_12} :catchall_20

    move-result-object v1

    .line 270
    :goto_13
    monitor-exit p0

    return-object v1

    .line 269
    :cond_15
    :try_start_15
    const-string/jumbo v1, "webkit-timers"

    const-string v2, "There is no active WebView for getSignedPublicKey"

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 270
    const-string v1, ""
    :try_end_1f
    .catchall {:try_start_15 .. :try_end_1f} :catchall_20

    goto :goto_13

    .line 262
    .end local v0           #current:Landroid/webkit/WebViewClassic;
    :catchall_20
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method private native nativeConstructor()V
.end method

.method private native nativeFinalize()V
.end method

.method private native nativeServiceFuncPtrQueue()V
.end method

.method private native nativeUpdatePluginDirectories([Ljava/lang/String;Z)V
.end method

.method static declared-synchronized removeActiveWebView(Landroid/webkit/WebViewClassic;)V
    .registers 3
    .parameter "webview"

    .prologue
    .line 79
    const-class v1, Landroid/webkit/JWebCoreJavaBridge;

    monitor-enter v1

    :try_start_3
    sget-object v0, Landroid/webkit/JWebCoreJavaBridge;->sCurrentMainWebView:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;
    :try_end_8
    .catchall {:try_start_3 .. :try_end_8} :catchall_13

    move-result-object v0

    if-eq v0, p0, :cond_d

    .line 84
    :goto_b
    monitor-exit v1

    return-void

    .line 83
    :cond_d
    :try_start_d
    sget-object v0, Landroid/webkit/JWebCoreJavaBridge;->sCurrentMainWebView:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->clear()V
    :try_end_12
    .catchall {:try_start_d .. :try_end_12} :catchall_13

    goto :goto_b

    .line 79
    :catchall_13
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private resolveFilePathForContentUri(Ljava/lang/String;)Ljava/lang/String;
    .registers 5
    .parameter "uri"

    .prologue
    .line 276
    iget-object v2, p0, Landroid/webkit/JWebCoreJavaBridge;->mContentUriToFilePathMap:Ljava/util/HashMap;

    if-eqz v2, :cond_f

    .line 277
    iget-object v2, p0, Landroid/webkit/JWebCoreJavaBridge;->mContentUriToFilePathMap:Ljava/util/HashMap;

    invoke-virtual {v2, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 278
    .local v0, fileName:Ljava/lang/String;
    if-eqz v0, :cond_f

    .line 286
    .end local v0           #fileName:Ljava/lang/String;
    :goto_e
    return-object v0

    .line 285
    :cond_f
    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 286
    .local v1, jUri:Landroid/net/Uri;
    invoke-virtual {v1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v0

    goto :goto_e
.end method

.method static declared-synchronized setActiveWebView(Landroid/webkit/WebViewClassic;)V
    .registers 3
    .parameter "webview"

    .prologue
    .line 71
    const-class v1, Landroid/webkit/JWebCoreJavaBridge;

    monitor-enter v1

    :try_start_3
    sget-object v0, Landroid/webkit/JWebCoreJavaBridge;->sCurrentMainWebView:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;
    :try_end_8
    .catchall {:try_start_3 .. :try_end_8} :catchall_15

    move-result-object v0

    if-eqz v0, :cond_d

    .line 76
    :goto_b
    monitor-exit v1

    return-void

    .line 75
    :cond_d
    :try_start_d
    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    sput-object v0, Landroid/webkit/JWebCoreJavaBridge;->sCurrentMainWebView:Ljava/lang/ref/WeakReference;
    :try_end_14
    .catchall {:try_start_d .. :try_end_14} :catchall_15

    goto :goto_b

    .line 71
    :catchall_15
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private setCookies(Ljava/lang/String;Ljava/lang/String;)V
    .registers 11
    .parameter "url"
    .parameter "value"

    .prologue
    const/4 v7, -0x1

    .line 166
    const-string v6, "\r"

    invoke-virtual {p2, v6}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_11

    const-string v6, "\n"

    invoke-virtual {p2, v6}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_51

    .line 168
    :cond_11
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v5

    .line 169
    .local v5, size:I
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0, v5}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 170
    .local v0, buffer:Ljava/lang/StringBuilder;
    const/4 v1, 0x0

    .line 171
    .local v1, i:I
    :goto_1b
    if-eq v1, v7, :cond_4d

    if-ge v1, v5, :cond_4d

    .line 172
    const/16 v6, 0xd

    invoke-virtual {p2, v6, v1}, Ljava/lang/String;->indexOf(II)I

    move-result v3

    .line 173
    .local v3, ir:I
    const/16 v6, 0xa

    invoke-virtual {p2, v6, v1}, Ljava/lang/String;->indexOf(II)I

    move-result v2

    .line 174
    .local v2, in:I
    if-ne v3, v7, :cond_3a

    move v4, v2

    .line 176
    .local v4, newi:I
    :goto_2e
    if-le v4, v1, :cond_44

    .line 177
    invoke-virtual {p2, v1, v4}, Ljava/lang/String;->subSequence(II)Ljava/lang/CharSequence;

    move-result-object v6

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;

    .line 182
    :cond_37
    add-int/lit8 v1, v4, 0x1

    .line 183
    goto :goto_1b

    .line 174
    .end local v4           #newi:I
    :cond_3a
    if-ne v2, v7, :cond_3e

    move v4, v3

    goto :goto_2e

    :cond_3e
    if-ge v3, v2, :cond_42

    move v4, v3

    goto :goto_2e

    :cond_42
    move v4, v2

    goto :goto_2e

    .line 178
    .restart local v4       #newi:I
    :cond_44
    if-ne v4, v7, :cond_37

    .line 179
    invoke-virtual {p2, v1, v5}, Ljava/lang/String;->subSequence(II)Ljava/lang/CharSequence;

    move-result-object v6

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;

    .line 184
    .end local v2           #in:I
    .end local v3           #ir:I
    .end local v4           #newi:I
    :cond_4d
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    .line 186
    .end local v0           #buffer:Ljava/lang/StringBuilder;
    .end local v1           #i:I
    .end local v5           #size:I
    :cond_51
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v6

    invoke-virtual {v6, p1, p2}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 187
    return-void
.end method

.method private setSharedTimer(J)V
    .registers 7
    .parameter "timemillis"

    .prologue
    const/4 v3, 0x1

    .line 226
    const-wide/16 v1, 0x0

    cmp-long v1, p1, v1

    if-gtz v1, :cond_16

    .line 231
    iget-boolean v1, p0, Landroid/webkit/JWebCoreJavaBridge;->mHasInstantTimer:Z

    if-eqz v1, :cond_c

    .line 242
    :goto_b
    return-void

    .line 234
    :cond_c
    iput-boolean v3, p0, Landroid/webkit/JWebCoreJavaBridge;->mHasInstantTimer:Z

    .line 235
    invoke-virtual {p0, v3}, Landroid/webkit/JWebCoreJavaBridge;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    .line 236
    .local v0, msg:Landroid/os/Message;
    invoke-virtual {p0, v0, p1, p2}, Landroid/webkit/JWebCoreJavaBridge;->sendMessageDelayed(Landroid/os/Message;J)Z

    goto :goto_b

    .line 239
    .end local v0           #msg:Landroid/os/Message;
    :cond_16
    invoke-virtual {p0, v3}, Landroid/webkit/JWebCoreJavaBridge;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    .line 240
    .restart local v0       #msg:Landroid/os/Message;
    invoke-virtual {p0, v0, p1, p2}, Landroid/webkit/JWebCoreJavaBridge;->sendMessageDelayed(Landroid/os/Message;J)Z

    goto :goto_b
.end method

.method private native sharedTimerFired()V
.end method

.method private signalServiceFuncPtrQueue()V
    .registers 3

    .prologue
    .line 125
    const/4 v1, 0x2

    invoke-virtual {p0, v1}, Landroid/webkit/JWebCoreJavaBridge;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    .line 126
    .local v0, msg:Landroid/os/Message;
    invoke-virtual {p0, v0}, Landroid/webkit/JWebCoreJavaBridge;->sendMessage(Landroid/os/Message;)Z

    .line 127
    return-void
.end method

.method private stopSharedTimer()V
    .registers 3

    .prologue
    const/4 v1, 0x0

    .line 251
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Landroid/webkit/JWebCoreJavaBridge;->removeMessages(I)V

    .line 252
    iput-boolean v1, p0, Landroid/webkit/JWebCoreJavaBridge;->mHasInstantTimer:Z

    .line 253
    iput-boolean v1, p0, Landroid/webkit/JWebCoreJavaBridge;->mHasDeferredTimers:Z

    .line 254
    return-void
.end method


# virtual methods
.method public native addPackageName(Ljava/lang/String;)V
.end method

.method public native addPackageNames(Ljava/util/Set;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation
.end method

.method protected finalize()V
    .registers 1

    .prologue
    .line 67
    invoke-direct {p0}, Landroid/webkit/JWebCoreJavaBridge;->nativeFinalize()V

    .line 68
    return-void
.end method

.method public handleMessage(Landroid/os/Message;)V
    .registers 4
    .parameter "msg"

    .prologue
    .line 103
    iget v0, p1, Landroid/os/Message;->what:I

    sparse-switch v0, :sswitch_data_2c

    .line 121
    :goto_5
    return-void

    .line 105
    :sswitch_6
    iget-boolean v0, p0, Landroid/webkit/JWebCoreJavaBridge;->mTimerPaused:Z

    if-eqz v0, :cond_e

    .line 106
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/webkit/JWebCoreJavaBridge;->mHasDeferredTimers:Z

    goto :goto_5

    .line 108
    :cond_e
    invoke-direct {p0}, Landroid/webkit/JWebCoreJavaBridge;->fireSharedTimer()V

    goto :goto_5

    .line 113
    :sswitch_12
    invoke-direct {p0}, Landroid/webkit/JWebCoreJavaBridge;->nativeServiceFuncPtrQueue()V

    goto :goto_5

    .line 116
    :sswitch_16
    const/4 v0, 0x0

    invoke-static {v0}, Landroid/webkit/PluginManager;->getInstance(Landroid/content/Context;)Landroid/webkit/PluginManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/PluginManager;->getPluginDirectories()[Ljava/lang/String;

    move-result-object v1

    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    invoke-direct {p0, v1, v0}, Landroid/webkit/JWebCoreJavaBridge;->nativeUpdatePluginDirectories([Ljava/lang/String;Z)V

    goto :goto_5

    .line 103
    nop

    :sswitch_data_2c
    .sparse-switch
        0x1 -> :sswitch_6
        0x2 -> :sswitch_12
        0x64 -> :sswitch_16
    .end sparse-switch
.end method

.method public native nativeUpdateProxy(Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public pause()V
    .registers 2

    .prologue
    .line 135
    iget-boolean v0, p0, Landroid/webkit/JWebCoreJavaBridge;->mTimerPaused:Z

    if-nez v0, :cond_a

    .line 136
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/webkit/JWebCoreJavaBridge;->mTimerPaused:Z

    .line 137
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/webkit/JWebCoreJavaBridge;->mHasDeferredTimers:Z

    .line 139
    :cond_a
    return-void
.end method

.method public native removePackageName(Ljava/lang/String;)V
.end method

.method public resume()V
    .registers 3

    .prologue
    const/4 v1, 0x0

    .line 145
    iget-boolean v0, p0, Landroid/webkit/JWebCoreJavaBridge;->mTimerPaused:Z

    if-eqz v0, :cond_10

    .line 146
    iput-boolean v1, p0, Landroid/webkit/JWebCoreJavaBridge;->mTimerPaused:Z

    .line 147
    iget-boolean v0, p0, Landroid/webkit/JWebCoreJavaBridge;->mHasDeferredTimers:Z

    if-eqz v0, :cond_10

    .line 148
    iput-boolean v1, p0, Landroid/webkit/JWebCoreJavaBridge;->mHasDeferredTimers:Z

    .line 149
    invoke-direct {p0}, Landroid/webkit/JWebCoreJavaBridge;->fireSharedTimer()V

    .line 152
    :cond_10
    return-void
.end method

.method public native setCacheSize(I)V
.end method

.method public native setNetworkOnLine(Z)V
.end method

.method public native setNetworkType(Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public storeFilePathForContentUri(Ljava/lang/String;Ljava/lang/String;)V
    .registers 4
    .parameter "path"
    .parameter "contentUri"

    .prologue
    .line 290
    iget-object v0, p0, Landroid/webkit/JWebCoreJavaBridge;->mContentUriToFilePathMap:Ljava/util/HashMap;

    if-nez v0, :cond_b

    .line 291
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroid/webkit/JWebCoreJavaBridge;->mContentUriToFilePathMap:Ljava/util/HashMap;

    .line 293
    :cond_b
    iget-object v0, p0, Landroid/webkit/JWebCoreJavaBridge;->mContentUriToFilePathMap:Ljava/util/HashMap;

    invoke-virtual {v0, p2, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 294
    return-void
.end method

.method public updateProxy(Landroid/net/ProxyProperties;)V
    .registers 6
    .parameter "proxyProperties"

    .prologue
    .line 297
    if-nez p1, :cond_a

    .line 298
    const-string v2, ""

    const-string v3, ""

    invoke-virtual {p0, v2, v3}, Landroid/webkit/JWebCoreJavaBridge;->nativeUpdateProxy(Ljava/lang/String;Ljava/lang/String;)V

    .line 308
    :goto_9
    return-void

    .line 302
    :cond_a
    invoke-virtual {p1}, Landroid/net/ProxyProperties;->getHost()Ljava/lang/String;

    move-result-object v0

    .line 303
    .local v0, host:Ljava/lang/String;
    invoke-virtual {p1}, Landroid/net/ProxyProperties;->getPort()I

    move-result v1

    .line 304
    .local v1, port:I
    if-eqz v1, :cond_2b

    .line 305
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 307
    :cond_2b
    invoke-virtual {p1}, Landroid/net/ProxyProperties;->getExclusionList()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v0, v2}, Landroid/webkit/JWebCoreJavaBridge;->nativeUpdateProxy(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_9
.end method
