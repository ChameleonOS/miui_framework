.class Lmiui/os/AsyncTaskWithProgress$1;
.super Ljava/lang/Object;
.source "AsyncTaskWithProgress.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lmiui/os/AsyncTaskWithProgress;->init(Landroid/app/ProgressDialog;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lmiui/os/AsyncTaskWithProgress;


# direct methods
.method constructor <init>(Lmiui/os/AsyncTaskWithProgress;)V
    .registers 2
    .parameter

    .prologue
    .local p0, this:Lmiui/os/AsyncTaskWithProgress$1;,"Lmiui/os/AsyncTaskWithProgress.1;"
    iput-object p1, p0, Lmiui/os/AsyncTaskWithProgress$1;->this$0:Lmiui/os/AsyncTaskWithProgress;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .registers 4
    .parameter "dialog"

    .prologue
    .local p0, this:Lmiui/os/AsyncTaskWithProgress$1;,"Lmiui/os/AsyncTaskWithProgress.1;"
    iget-object v0, p0, Lmiui/os/AsyncTaskWithProgress$1;->this$0:Lmiui/os/AsyncTaskWithProgress;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lmiui/os/AsyncTaskWithProgress;->cancel(Z)Z

    return-void
.end method
