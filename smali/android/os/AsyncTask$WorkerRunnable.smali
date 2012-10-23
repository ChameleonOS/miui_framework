.class abstract Landroid/os/AsyncTask$WorkerRunnable;
.super Ljava/lang/Object;
.source "AsyncTask.java"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/os/AsyncTask;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x40a
    name = "WorkerRunnable"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<Params:",
        "Ljava/lang/Object;",
        "Result:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/Callable",
        "<TResult;>;"
    }
.end annotation


# instance fields
.field mParams:[Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "[TParams;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    .line 653
    .local p0, this:Landroid/os/AsyncTask$WorkerRunnable;,"Landroid/os/AsyncTask$WorkerRunnable<TParams;TResult;>;"
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/os/AsyncTask$1;)V
    .registers 2
    .parameter "x0"

    .prologue
    .line 653
    .local p0, this:Landroid/os/AsyncTask$WorkerRunnable;,"Landroid/os/AsyncTask$WorkerRunnable<TParams;TResult;>;"
    invoke-direct {p0}, Landroid/os/AsyncTask$WorkerRunnable;-><init>()V

    return-void
.end method
