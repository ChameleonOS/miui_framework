.class Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable;
.super Ljava/lang/Object;
.source "WebCoreThreadWatchdog.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/webkit/WebCoreThreadWatchdog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "PageNotRespondingRunnable"
.end annotation


# static fields
.field static final synthetic $assertionsDisabled:Z


# instance fields
.field mContext:Landroid/content/Context;

.field private mWatchdogHandler:Landroid/os/Handler;

.field final synthetic this$0:Landroid/webkit/WebCoreThreadWatchdog;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 227
    const-class v0, Landroid/webkit/WebCoreThreadWatchdog;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_c

    const/4 v0, 0x1

    :goto_9
    sput-boolean v0, Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable;->$assertionsDisabled:Z

    return-void

    :cond_c
    const/4 v0, 0x0

    goto :goto_9
.end method

.method public constructor <init>(Landroid/webkit/WebCoreThreadWatchdog;Landroid/content/Context;Landroid/os/Handler;)V
    .registers 4
    .parameter
    .parameter "context"
    .parameter "watchdogHandler"

    .prologue
    .line 231
    iput-object p1, p0, Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable;->this$0:Landroid/webkit/WebCoreThreadWatchdog;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 232
    iput-object p2, p0, Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable;->mContext:Landroid/content/Context;

    .line 233
    iput-object p3, p0, Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable;->mWatchdogHandler:Landroid/os/Handler;

    .line 234
    return-void
.end method

.method static synthetic access$400(Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable;)Landroid/os/Handler;
    .registers 2
    .parameter "x0"

    .prologue
    .line 227
    iget-object v0, p0, Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable;->mWatchdogHandler:Landroid/os/Handler;

    return-object v0
.end method


# virtual methods
.method public run()V
    .registers 4

    .prologue
    .line 239
    sget-boolean v0, Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable;->$assertionsDisabled:Z

    if-nez v0, :cond_18

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Looper;->getThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    if-eq v0, v1, :cond_18

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 240
    :cond_18
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    const v1, 0x10403da

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(I)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x10403d7

    new-instance v2, Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable$3;

    invoke-direct {v2, p0}, Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable$3;-><init>(Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x10403d9

    new-instance v2, Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable$2;

    invoke-direct {v2, p0}, Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable$2;-><init>(Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    new-instance v1, Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable$1;

    invoke-direct {v1, p0}, Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable$1;-><init>(Landroid/webkit/WebCoreThreadWatchdog$PageNotRespondingRunnable;)V

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x1080027

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setIcon(I)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 275
    return-void
.end method
