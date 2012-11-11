.class Landroid/webkit/WebCoreThreadWatchdog;
.super Ljava/lang/Object;
.source "WebCoreThreadWatchdog.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable;
    }
.end annotation


# static fields
.field private static final HEARTBEAT_PERIOD:I = 0x2710

.field private static final IS_ALIVE:I = 0x64

.field private static final SUBSEQUENT_TIMEOUT_PERIOD:I = 0x3a98

.field private static final TIMED_OUT:I = 0x65

.field private static final TIMEOUT_PERIOD:I = 0x7530

.field private static sInstance:Landroid/webkit/WebCoreThreadWatchdog;


# instance fields
.field private mHandler:Landroid/os/Handler;

.field private mPaused:Z

.field private mWebCoreThreadHandler:Landroid/os/Handler;

.field private mWebViews:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Landroid/webkit/WebViewClassic;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>(Landroid/os/Handler;)V
    .registers 2
    .parameter "webCoreThreadHandler"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroid/webkit/WebCoreThreadWatchdog;->mWebCoreThreadHandler:Landroid/os/Handler;

    return-void
.end method

.method static synthetic access$000(Landroid/webkit/WebCoreThreadWatchdog;)Z
    .registers 2
    .parameter "x0"

    .prologue
    iget-boolean v0, p0, Landroid/webkit/WebCoreThreadWatchdog;->mPaused:Z

    return v0
.end method

.method static synthetic access$100(Landroid/webkit/WebCoreThreadWatchdog;)Landroid/os/Handler;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/webkit/WebCoreThreadWatchdog;->mHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$200(Landroid/webkit/WebCoreThreadWatchdog;)Landroid/os/Handler;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/webkit/WebCoreThreadWatchdog;->mWebCoreThreadHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$300(Landroid/webkit/WebCoreThreadWatchdog;)Ljava/util/Set;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/webkit/WebCoreThreadWatchdog;->mWebViews:Ljava/util/Set;

    return-object v0
.end method

.method private addWebView(Landroid/webkit/WebViewClassic;)V
    .registers 3
    .parameter "w"

    .prologue
    iget-object v0, p0, Landroid/webkit/WebCoreThreadWatchdog;->mWebViews:Ljava/util/Set;

    if-nez v0, :cond_b

    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Landroid/webkit/WebCoreThreadWatchdog;->mWebViews:Ljava/util/Set;

    :cond_b
    iget-object v0, p0, Landroid/webkit/WebCoreThreadWatchdog;->mWebViews:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method private createHandler()V
    .registers 3

    .prologue
    const-class v1, Landroid/webkit/WebCoreThreadWatchdog;

    monitor-enter v1

    :try_start_3
    new-instance v0, Landroid/webkit/WebCoreThreadWatchdog$1;

    invoke-direct {v0, p0}, Landroid/webkit/WebCoreThreadWatchdog$1;-><init>(Landroid/webkit/WebCoreThreadWatchdog;)V

    iput-object v0, p0, Landroid/webkit/WebCoreThreadWatchdog;->mHandler:Landroid/os/Handler;

    monitor-exit v1

    return-void

    :catchall_c
    move-exception v0

    monitor-exit v1
    :try_end_e
    .catchall {:try_start_3 .. :try_end_e} :catchall_c

    throw v0
.end method

.method public static declared-synchronized pause()V
    .registers 2

    .prologue
    const-class v1, Landroid/webkit/WebCoreThreadWatchdog;

    monitor-enter v1

    :try_start_3
    sget-object v0, Landroid/webkit/WebCoreThreadWatchdog;->sInstance:Landroid/webkit/WebCoreThreadWatchdog;

    if-eqz v0, :cond_c

    sget-object v0, Landroid/webkit/WebCoreThreadWatchdog;->sInstance:Landroid/webkit/WebCoreThreadWatchdog;

    invoke-direct {v0}, Landroid/webkit/WebCoreThreadWatchdog;->pauseWatchdog()V
    :try_end_c
    .catchall {:try_start_3 .. :try_end_c} :catchall_e

    :cond_c
    monitor-exit v1

    return-void

    :catchall_e
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private pauseWatchdog()V
    .registers 3

    .prologue
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/webkit/WebCoreThreadWatchdog;->mPaused:Z

    iget-object v0, p0, Landroid/webkit/WebCoreThreadWatchdog;->mHandler:Landroid/os/Handler;

    if-nez v0, :cond_8

    :goto_7
    return-void

    :cond_8
    iget-object v0, p0, Landroid/webkit/WebCoreThreadWatchdog;->mHandler:Landroid/os/Handler;

    const/16 v1, 0x65

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v0, p0, Landroid/webkit/WebCoreThreadWatchdog;->mHandler:Landroid/os/Handler;

    const/16 v1, 0x64

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v0, p0, Landroid/webkit/WebCoreThreadWatchdog;->mWebCoreThreadHandler:Landroid/os/Handler;

    const/16 v1, 0xc5

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    goto :goto_7
.end method

.method public static declared-synchronized registerWebView(Landroid/webkit/WebViewClassic;)V
    .registers 3
    .parameter "w"

    .prologue
    const-class v1, Landroid/webkit/WebCoreThreadWatchdog;

    monitor-enter v1

    :try_start_3
    sget-object v0, Landroid/webkit/WebCoreThreadWatchdog;->sInstance:Landroid/webkit/WebCoreThreadWatchdog;

    if-eqz v0, :cond_c

    sget-object v0, Landroid/webkit/WebCoreThreadWatchdog;->sInstance:Landroid/webkit/WebCoreThreadWatchdog;

    invoke-direct {v0, p0}, Landroid/webkit/WebCoreThreadWatchdog;->addWebView(Landroid/webkit/WebViewClassic;)V
    :try_end_c
    .catchall {:try_start_3 .. :try_end_c} :catchall_e

    :cond_c
    monitor-exit v1

    return-void

    :catchall_e
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private removeWebView(Landroid/webkit/WebViewClassic;)V
    .registers 3
    .parameter "w"

    .prologue
    iget-object v0, p0, Landroid/webkit/WebCoreThreadWatchdog;->mWebViews:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    return-void
.end method

.method public static declared-synchronized resume()V
    .registers 2

    .prologue
    const-class v1, Landroid/webkit/WebCoreThreadWatchdog;

    monitor-enter v1

    :try_start_3
    sget-object v0, Landroid/webkit/WebCoreThreadWatchdog;->sInstance:Landroid/webkit/WebCoreThreadWatchdog;

    if-eqz v0, :cond_c

    sget-object v0, Landroid/webkit/WebCoreThreadWatchdog;->sInstance:Landroid/webkit/WebCoreThreadWatchdog;

    invoke-direct {v0}, Landroid/webkit/WebCoreThreadWatchdog;->resumeWatchdog()V
    :try_end_c
    .catchall {:try_start_3 .. :try_end_c} :catchall_e

    :cond_c
    monitor-exit v1

    return-void

    :catchall_e
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private resumeWatchdog()V
    .registers 5

    .prologue
    iget-boolean v0, p0, Landroid/webkit/WebCoreThreadWatchdog;->mPaused:Z

    if-nez v0, :cond_5

    :cond_4
    :goto_4
    return-void

    :cond_5
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/webkit/WebCoreThreadWatchdog;->mPaused:Z

    iget-object v0, p0, Landroid/webkit/WebCoreThreadWatchdog;->mHandler:Landroid/os/Handler;

    if-eqz v0, :cond_4

    iget-object v0, p0, Landroid/webkit/WebCoreThreadWatchdog;->mWebCoreThreadHandler:Landroid/os/Handler;

    const/16 v1, 0xc5

    iget-object v2, p0, Landroid/webkit/WebCoreThreadWatchdog;->mHandler:Landroid/os/Handler;

    const/16 v3, 0x64

    invoke-virtual {v2, v3}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    iget-object v0, p0, Landroid/webkit/WebCoreThreadWatchdog;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Landroid/webkit/WebCoreThreadWatchdog;->mHandler:Landroid/os/Handler;

    const/16 v2, 0x65

    invoke-virtual {v1, v2}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v1

    const-wide/16 v2, 0x7530

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    goto :goto_4
.end method

.method public static declared-synchronized start(Landroid/os/Handler;)Landroid/webkit/WebCoreThreadWatchdog;
    .registers 5
    .parameter "webCoreThreadHandler"

    .prologue
    const-class v1, Landroid/webkit/WebCoreThreadWatchdog;

    monitor-enter v1

    :try_start_3
    sget-object v0, Landroid/webkit/WebCoreThreadWatchdog;->sInstance:Landroid/webkit/WebCoreThreadWatchdog;

    if-nez v0, :cond_1a

    new-instance v0, Landroid/webkit/WebCoreThreadWatchdog;

    invoke-direct {v0, p0}, Landroid/webkit/WebCoreThreadWatchdog;-><init>(Landroid/os/Handler;)V

    sput-object v0, Landroid/webkit/WebCoreThreadWatchdog;->sInstance:Landroid/webkit/WebCoreThreadWatchdog;

    new-instance v0, Ljava/lang/Thread;

    sget-object v2, Landroid/webkit/WebCoreThreadWatchdog;->sInstance:Landroid/webkit/WebCoreThreadWatchdog;

    const-string v3, "WebCoreThreadWatchdog"

    invoke-direct {v0, v2, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    :cond_1a
    sget-object v0, Landroid/webkit/WebCoreThreadWatchdog;->sInstance:Landroid/webkit/WebCoreThreadWatchdog;
    :try_end_1c
    .catchall {:try_start_3 .. :try_end_1c} :catchall_1e

    monitor-exit v1

    return-object v0

    :catchall_1e
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static declared-synchronized unregisterWebView(Landroid/webkit/WebViewClassic;)V
    .registers 3
    .parameter "w"

    .prologue
    const-class v1, Landroid/webkit/WebCoreThreadWatchdog;

    monitor-enter v1

    :try_start_3
    sget-object v0, Landroid/webkit/WebCoreThreadWatchdog;->sInstance:Landroid/webkit/WebCoreThreadWatchdog;

    if-eqz v0, :cond_c

    sget-object v0, Landroid/webkit/WebCoreThreadWatchdog;->sInstance:Landroid/webkit/WebCoreThreadWatchdog;

    invoke-direct {v0, p0}, Landroid/webkit/WebCoreThreadWatchdog;->removeWebView(Landroid/webkit/WebViewClassic;)V
    :try_end_c
    .catchall {:try_start_3 .. :try_end_c} :catchall_e

    :cond_c
    monitor-exit v1

    return-void

    :catchall_e
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method public run()V
    .registers 6

    .prologue
    invoke-static {}, Landroid/os/Looper;->prepare()V

    invoke-direct {p0}, Landroid/webkit/WebCoreThreadWatchdog;->createHandler()V

    const-class v1, Landroid/webkit/WebCoreThreadWatchdog;

    monitor-enter v1

    :try_start_9
    iget-boolean v0, p0, Landroid/webkit/WebCoreThreadWatchdog;->mPaused:Z

    if-nez v0, :cond_2f

    iget-object v0, p0, Landroid/webkit/WebCoreThreadWatchdog;->mWebCoreThreadHandler:Landroid/os/Handler;

    const/16 v2, 0xc5

    iget-object v3, p0, Landroid/webkit/WebCoreThreadWatchdog;->mHandler:Landroid/os/Handler;

    const/16 v4, 0x64

    invoke-virtual {v3, v4}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    iget-object v0, p0, Landroid/webkit/WebCoreThreadWatchdog;->mHandler:Landroid/os/Handler;

    iget-object v2, p0, Landroid/webkit/WebCoreThreadWatchdog;->mHandler:Landroid/os/Handler;

    const/16 v3, 0x65

    invoke-virtual {v2, v3}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v2

    const-wide/16 v3, 0x7530

    invoke-virtual {v0, v2, v3, v4}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    :cond_2f
    monitor-exit v1
    :try_end_30
    .catchall {:try_start_9 .. :try_end_30} :catchall_34

    invoke-static {}, Landroid/os/Looper;->loop()V

    return-void

    :catchall_34
    move-exception v0

    :try_start_35
    monitor-exit v1
    :try_end_36
    .catchall {:try_start_35 .. :try_end_36} :catchall_34

    throw v0
.end method
