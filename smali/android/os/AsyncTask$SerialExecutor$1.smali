.class Landroid/os/AsyncTask$SerialExecutor$1;
.super Ljava/lang/Object;
.source "AsyncTask.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/os/AsyncTask$SerialExecutor;->execute(Ljava/lang/Runnable;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/os/AsyncTask$SerialExecutor;

.field final synthetic val$r:Ljava/lang/Runnable;


# direct methods
.method constructor <init>(Landroid/os/AsyncTask$SerialExecutor;Ljava/lang/Runnable;)V
    .registers 3
    .parameter
    .parameter

    .prologue
    iput-object p1, p0, Landroid/os/AsyncTask$SerialExecutor$1;->this$0:Landroid/os/AsyncTask$SerialExecutor;

    iput-object p2, p0, Landroid/os/AsyncTask$SerialExecutor$1;->val$r:Ljava/lang/Runnable;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 3

    .prologue
    :try_start_0
    iget-object v0, p0, Landroid/os/AsyncTask$SerialExecutor$1;->val$r:Ljava/lang/Runnable;

    invoke-interface {v0}, Ljava/lang/Runnable;->run()V
    :try_end_5
    .catchall {:try_start_0 .. :try_end_5} :catchall_b

    iget-object v0, p0, Landroid/os/AsyncTask$SerialExecutor$1;->this$0:Landroid/os/AsyncTask$SerialExecutor;

    invoke-virtual {v0}, Landroid/os/AsyncTask$SerialExecutor;->scheduleNext()V

    return-void

    :catchall_b
    move-exception v0

    iget-object v1, p0, Landroid/os/AsyncTask$SerialExecutor$1;->this$0:Landroid/os/AsyncTask$SerialExecutor;

    invoke-virtual {v1}, Landroid/os/AsyncTask$SerialExecutor;->scheduleNext()V

    throw v0
.end method
