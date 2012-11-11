.class public abstract Lmiui/os/AsyncTaskWithProgress;
.super Landroid/os/AsyncTask;
.source "AsyncTaskWithProgress.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<Params:",
        "Ljava/lang/Object;",
        "Progress:",
        "Ljava/lang/Object;",
        "Result:",
        "Ljava/lang/Object;",
        ">",
        "Landroid/os/AsyncTask",
        "<TParams;TProgress;TResult;>;"
    }
.end annotation


# instance fields
.field protected mDialog:Landroid/app/ProgressDialog;


# direct methods
.method public constructor <init>(Landroid/app/ProgressDialog;)V
    .registers 2
    .parameter "dialog"

    .prologue
    .local p0, this:Lmiui/os/AsyncTaskWithProgress;,"Lmiui/os/AsyncTaskWithProgress<TParams;TProgress;TResult;>;"
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    invoke-direct {p0, p1}, Lmiui/os/AsyncTaskWithProgress;->init(Landroid/app/ProgressDialog;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;IIIZ)V
    .registers 9
    .parameter "context"
    .parameter "titleId"
    .parameter "theme"
    .parameter "messageId"
    .parameter "cancelable"

    .prologue
    .local p0, this:Lmiui/os/AsyncTaskWithProgress;,"Lmiui/os/AsyncTaskWithProgress<TParams;TProgress;TResult;>;"
    const/4 v2, 0x0

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    new-instance v0, Landroid/app/ProgressDialog;

    invoke-direct {v0, p1, p3}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;I)V

    .local v0, dialog:Landroid/app/ProgressDialog;
    if-nez p2, :cond_23

    move-object v1, v2

    :goto_c
    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setTitle(Ljava/lang/CharSequence;)V

    if-nez p4, :cond_2c

    move-object v1, v2

    :goto_12
    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setIndeterminate(Z)V

    invoke-virtual {v0, p5}, Landroid/app/ProgressDialog;->setCancelable(Z)V

    invoke-virtual {v0, v2}, Landroid/app/ProgressDialog;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    invoke-direct {p0, v0}, Lmiui/os/AsyncTaskWithProgress;->init(Landroid/app/ProgressDialog;)V

    return-void

    :cond_23
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, p2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_c

    :cond_2c
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, p4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_12
.end method

.method public constructor <init>(Landroid/content/Context;IIZ)V
    .registers 11
    .parameter "context"
    .parameter "titleId"
    .parameter "messageId"
    .parameter "cancelable"

    .prologue
    .local p0, this:Lmiui/os/AsyncTaskWithProgress;,"Lmiui/os/AsyncTaskWithProgress<TParams;TProgress;TResult;>;"
    const/4 v3, 0x3

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move v4, p3

    move v5, p4

    invoke-direct/range {v0 .. v5}, Lmiui/os/AsyncTaskWithProgress;-><init>(Landroid/content/Context;IIIZ)V

    return-void
.end method

.method private dismissDialog()V
    .registers 2

    .prologue
    .local p0, this:Lmiui/os/AsyncTaskWithProgress;,"Lmiui/os/AsyncTaskWithProgress<TParams;TProgress;TResult;>;"
    :try_start_0
    iget-object v0, p0, Lmiui/os/AsyncTaskWithProgress;->mDialog:Landroid/app/ProgressDialog;

    if-eqz v0, :cond_11

    iget-object v0, p0, Lmiui/os/AsyncTaskWithProgress;->mDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_11

    iget-object v0, p0, Lmiui/os/AsyncTaskWithProgress;->mDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V
    :try_end_11
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_11} :catch_12

    :cond_11
    :goto_11
    return-void

    :catch_12
    move-exception v0

    goto :goto_11
.end method

.method private init(Landroid/app/ProgressDialog;)V
    .registers 4
    .parameter "dialog"

    .prologue
    .local p0, this:Lmiui/os/AsyncTaskWithProgress;,"Lmiui/os/AsyncTaskWithProgress<TParams;TProgress;TResult;>;"
    iput-object p1, p0, Lmiui/os/AsyncTaskWithProgress;->mDialog:Landroid/app/ProgressDialog;

    iget-object v0, p0, Lmiui/os/AsyncTaskWithProgress;->mDialog:Landroid/app/ProgressDialog;

    if-eqz v0, :cond_10

    iget-object v0, p0, Lmiui/os/AsyncTaskWithProgress;->mDialog:Landroid/app/ProgressDialog;

    new-instance v1, Lmiui/os/AsyncTaskWithProgress$1;

    invoke-direct {v1, p0}, Lmiui/os/AsyncTaskWithProgress$1;-><init>(Lmiui/os/AsyncTaskWithProgress;)V

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    :cond_10
    return-void
.end method


# virtual methods
.method public onCancelled()V
    .registers 1

    .prologue
    .local p0, this:Lmiui/os/AsyncTaskWithProgress;,"Lmiui/os/AsyncTaskWithProgress<TParams;TProgress;TResult;>;"
    invoke-direct {p0}, Lmiui/os/AsyncTaskWithProgress;->dismissDialog()V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Object;)V
    .registers 2
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TResult;)V"
        }
    .end annotation

    .prologue
    .local p0, this:Lmiui/os/AsyncTaskWithProgress;,"Lmiui/os/AsyncTaskWithProgress<TParams;TProgress;TResult;>;"
    .local p1, result:Ljava/lang/Object;,"TResult;"
    invoke-direct {p0}, Lmiui/os/AsyncTaskWithProgress;->dismissDialog()V

    return-void
.end method

.method protected onPreExecute()V
    .registers 2

    .prologue
    .local p0, this:Lmiui/os/AsyncTaskWithProgress;,"Lmiui/os/AsyncTaskWithProgress<TParams;TProgress;TResult;>;"
    iget-object v0, p0, Lmiui/os/AsyncTaskWithProgress;->mDialog:Landroid/app/ProgressDialog;

    if-eqz v0, :cond_9

    iget-object v0, p0, Lmiui/os/AsyncTaskWithProgress;->mDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->show()V

    :cond_9
    return-void
.end method

.method public setDialogType(I)V
    .registers 3
    .parameter "type"

    .prologue
    .local p0, this:Lmiui/os/AsyncTaskWithProgress;,"Lmiui/os/AsyncTaskWithProgress<TParams;TProgress;TResult;>;"
    iget-object v0, p0, Lmiui/os/AsyncTaskWithProgress;->mDialog:Landroid/app/ProgressDialog;

    if-eqz v0, :cond_d

    iget-object v0, p0, Lmiui/os/AsyncTaskWithProgress;->mDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/view/Window;->setType(I)V

    :cond_d
    return-void
.end method
