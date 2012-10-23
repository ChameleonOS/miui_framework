.class Landroid/webkit/HTML5Audio$IsPrivateBrowsingEnabledGetter$1;
.super Ljava/lang/Object;
.source "HTML5Audio.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/webkit/HTML5Audio$IsPrivateBrowsingEnabledGetter;-><init>(Landroid/webkit/HTML5Audio;Landroid/os/Looper;Landroid/webkit/WebViewClassic;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Landroid/webkit/HTML5Audio$IsPrivateBrowsingEnabledGetter;

.field final synthetic val$this$0:Landroid/webkit/HTML5Audio;

.field final synthetic val$webView:Landroid/webkit/WebViewClassic;


# direct methods
.method constructor <init>(Landroid/webkit/HTML5Audio$IsPrivateBrowsingEnabledGetter;Landroid/webkit/HTML5Audio;Landroid/webkit/WebViewClassic;)V
    .registers 4
    .parameter
    .parameter
    .parameter

    .prologue
    .line 98
    iput-object p1, p0, Landroid/webkit/HTML5Audio$IsPrivateBrowsingEnabledGetter$1;->this$1:Landroid/webkit/HTML5Audio$IsPrivateBrowsingEnabledGetter;

    iput-object p2, p0, Landroid/webkit/HTML5Audio$IsPrivateBrowsingEnabledGetter$1;->val$this$0:Landroid/webkit/HTML5Audio;

    iput-object p3, p0, Landroid/webkit/HTML5Audio$IsPrivateBrowsingEnabledGetter$1;->val$webView:Landroid/webkit/WebViewClassic;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 4

    .prologue
    .line 101
    iget-object v1, p0, Landroid/webkit/HTML5Audio$IsPrivateBrowsingEnabledGetter$1;->this$1:Landroid/webkit/HTML5Audio$IsPrivateBrowsingEnabledGetter;

    monitor-enter v1

    .line 102
    :try_start_3
    iget-object v0, p0, Landroid/webkit/HTML5Audio$IsPrivateBrowsingEnabledGetter$1;->this$1:Landroid/webkit/HTML5Audio$IsPrivateBrowsingEnabledGetter;

    iget-object v2, p0, Landroid/webkit/HTML5Audio$IsPrivateBrowsingEnabledGetter$1;->val$webView:Landroid/webkit/WebViewClassic;

    invoke-virtual {v2}, Landroid/webkit/WebViewClassic;->isPrivateBrowsingEnabled()Z

    move-result v2

    #setter for: Landroid/webkit/HTML5Audio$IsPrivateBrowsingEnabledGetter;->mIsPrivateBrowsingEnabled:Z
    invoke-static {v0, v2}, Landroid/webkit/HTML5Audio$IsPrivateBrowsingEnabledGetter;->access$002(Landroid/webkit/HTML5Audio$IsPrivateBrowsingEnabledGetter;Z)Z

    .line 103
    iget-object v0, p0, Landroid/webkit/HTML5Audio$IsPrivateBrowsingEnabledGetter$1;->this$1:Landroid/webkit/HTML5Audio$IsPrivateBrowsingEnabledGetter;

    const/4 v2, 0x1

    #setter for: Landroid/webkit/HTML5Audio$IsPrivateBrowsingEnabledGetter;->mIsReady:Z
    invoke-static {v0, v2}, Landroid/webkit/HTML5Audio$IsPrivateBrowsingEnabledGetter;->access$102(Landroid/webkit/HTML5Audio$IsPrivateBrowsingEnabledGetter;Z)Z

    .line 104
    iget-object v0, p0, Landroid/webkit/HTML5Audio$IsPrivateBrowsingEnabledGetter$1;->this$1:Landroid/webkit/HTML5Audio$IsPrivateBrowsingEnabledGetter;

    invoke-virtual {v0}, Ljava/lang/Object;->notify()V

    .line 105
    monitor-exit v1

    .line 106
    return-void

    .line 105
    :catchall_1b
    move-exception v0

    monitor-exit v1
    :try_end_1d
    .catchall {:try_start_3 .. :try_end_1d} :catchall_1b

    throw v0
.end method
