.class Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable$1;
.super Ljava/lang/Object;
.source "WebCoreThreadWatchdog.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable;


# direct methods
.method constructor <init>(Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable;)V
    .registers 2
    .parameter

    .prologue
    .line 265
    iput-object p1, p0, Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable$1;->this$1:Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .registers 6
    .parameter "dialog"

    .prologue
    .line 268
    iget-object v0, p0, Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable$1;->this$1:Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable;

    #getter for: Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable;->mWatchdogHandler:Landroid/os/Handler;
    invoke-static {v0}, Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable;->access$400(Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable;)Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable$1;->this$1:Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable;

    #getter for: Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable;->mWatchdogHandler:Landroid/os/Handler;
    invoke-static {v1}, Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable;->access$400(Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable;)Landroid/os/Handler;

    move-result-object v1

    const/16 v2, 0x65

    invoke-virtual {v1, v2}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v1

    const-wide/16 v2, 0x3a98

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    .line 271
    return-void
.end method
