.class Landroid/webkit/CallbackProxy$JsResultReceiver;
.super Ljava/lang/Object;
.source "CallbackProxy.java"

# interfaces
.implements Landroid/webkit/JsResult$ResultReceiver;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/webkit/CallbackProxy;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "JsResultReceiver"
.end annotation


# instance fields
.field public mJsResult:Landroid/webkit/JsPromptResult;

.field private mReady:Z

.field private mTriedToNotifyBeforeReady:Z

.field final synthetic this$0:Landroid/webkit/CallbackProxy;


# direct methods
.method private constructor <init>(Landroid/webkit/CallbackProxy;)V
    .registers 3
    .parameter

    .prologue
    iput-object p1, p0, Landroid/webkit/CallbackProxy$JsResultReceiver;->this$0:Landroid/webkit/CallbackProxy;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Landroid/webkit/JsPromptResult;

    invoke-direct {v0, p0}, Landroid/webkit/JsPromptResult;-><init>(Landroid/webkit/JsResult$ResultReceiver;)V

    iput-object v0, p0, Landroid/webkit/CallbackProxy$JsResultReceiver;->mJsResult:Landroid/webkit/JsPromptResult;

    return-void
.end method

.method synthetic constructor <init>(Landroid/webkit/CallbackProxy;Landroid/webkit/CallbackProxy$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-direct {p0, p1}, Landroid/webkit/CallbackProxy$JsResultReceiver;-><init>(Landroid/webkit/CallbackProxy;)V

    return-void
.end method

.method private notifyCallbackProxy()V
    .registers 3

    .prologue
    iget-object v1, p0, Landroid/webkit/CallbackProxy$JsResultReceiver;->this$0:Landroid/webkit/CallbackProxy;

    monitor-enter v1

    :try_start_3
    iget-object v0, p0, Landroid/webkit/CallbackProxy$JsResultReceiver;->this$0:Landroid/webkit/CallbackProxy;

    invoke-virtual {v0}, Ljava/lang/Object;->notify()V

    monitor-exit v1

    return-void

    :catchall_a
    move-exception v0

    monitor-exit v1
    :try_end_c
    .catchall {:try_start_3 .. :try_end_c} :catchall_a

    throw v0
.end method


# virtual methods
.method public onJsResultComplete(Landroid/webkit/JsResult;)V
    .registers 3
    .parameter "result"

    .prologue
    iget-boolean v0, p0, Landroid/webkit/CallbackProxy$JsResultReceiver;->mReady:Z

    if-eqz v0, :cond_8

    invoke-direct {p0}, Landroid/webkit/CallbackProxy$JsResultReceiver;->notifyCallbackProxy()V

    :goto_7
    return-void

    :cond_8
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/webkit/CallbackProxy$JsResultReceiver;->mTriedToNotifyBeforeReady:Z

    goto :goto_7
.end method

.method final setReady()V
    .registers 2

    .prologue
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/webkit/CallbackProxy$JsResultReceiver;->mReady:Z

    iget-boolean v0, p0, Landroid/webkit/CallbackProxy$JsResultReceiver;->mTriedToNotifyBeforeReady:Z

    if-eqz v0, :cond_a

    invoke-direct {p0}, Landroid/webkit/CallbackProxy$JsResultReceiver;->notifyCallbackProxy()V

    :cond_a
    return-void
.end method
