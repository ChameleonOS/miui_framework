.class Landroid/accounts/AccountManager$BaseFutureTask$1;
.super Ljava/lang/Object;
.source "AccountManager.java"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/accounts/AccountManager$BaseFutureTask;-><init>(Landroid/accounts/AccountManager;Landroid/os/Handler;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/Callable",
        "<TT;>;"
    }
.end annotation


# instance fields
.field final synthetic val$this$0:Landroid/accounts/AccountManager;


# direct methods
.method constructor <init>(Landroid/accounts/AccountManager;)V
    .registers 2
    .parameter

    .prologue
    .line 1469
    .local p0, this:Landroid/accounts/AccountManager$BaseFutureTask$1;,"Landroid/accounts/AccountManager$BaseFutureTask.1;"
    iput-object p1, p0, Landroid/accounts/AccountManager$BaseFutureTask$1;->val$this$0:Landroid/accounts/AccountManager;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public call()Ljava/lang/Object;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 1471
    .local p0, this:Landroid/accounts/AccountManager$BaseFutureTask$1;,"Landroid/accounts/AccountManager$BaseFutureTask.1;"
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "this should never be called"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
