.class Landroid/webkit/WebViewCore$WebCoreThread;
.super Ljava/lang/Object;
.source "WebViewCore.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/webkit/WebViewCore;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "WebCoreThread"
.end annotation


# static fields
.field private static final INITIALIZE:I = 0x0

.field private static final REDUCE_PRIORITY:I = 0x1

.field private static final RESUME_PRIORITY:I = 0x2


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    .line 777
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/webkit/WebViewCore$1;)V
    .registers 2
    .parameter "x0"

    .prologue
    .line 777
    invoke-direct {p0}, Landroid/webkit/WebViewCore$WebCoreThread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 3

    .prologue
    .line 785
    invoke-static {}, Landroid/os/Looper;->prepare()V

    .line 786
    invoke-static {}, Landroid/webkit/WebViewCore;->access$500()Landroid/os/Handler;

    move-result-object v0

    invoke-static {v0}, Ljunit/framework/Assert;->assertNull(Ljava/lang/Object;)V

    .line 787
    const-class v1, Landroid/webkit/WebViewCore;

    monitor-enter v1

    .line 788
    :try_start_d
    new-instance v0, Landroid/webkit/WebViewCore$WebCoreThread$1;

    invoke-direct {v0, p0}, Landroid/webkit/WebViewCore$WebCoreThread$1;-><init>(Landroid/webkit/WebViewCore$WebCoreThread;)V

    invoke-static {v0}, Landroid/webkit/WebViewCore;->access$502(Landroid/os/Handler;)Landroid/os/Handler;

    .line 847
    const-class v0, Landroid/webkit/WebViewCore;

    invoke-virtual {v0}, Ljava/lang/Object;->notify()V

    .line 848
    monitor-exit v1
    :try_end_1b
    .catchall {:try_start_d .. :try_end_1b} :catchall_1f

    .line 849
    invoke-static {}, Landroid/os/Looper;->loop()V

    .line 850
    return-void

    .line 848
    :catchall_1f
    move-exception v0

    :try_start_20
    monitor-exit v1
    :try_end_21
    .catchall {:try_start_20 .. :try_end_21} :catchall_1f

    throw v0
.end method
