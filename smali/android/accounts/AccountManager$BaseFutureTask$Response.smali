.class public Landroid/accounts/AccountManager$BaseFutureTask$Response;
.super Landroid/accounts/IAccountManagerResponse$Stub;
.source "AccountManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/accounts/AccountManager$BaseFutureTask;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "Response"
.end annotation


# instance fields
.field final synthetic this$1:Landroid/accounts/AccountManager$BaseFutureTask;


# direct methods
.method protected constructor <init>(Landroid/accounts/AccountManager$BaseFutureTask;)V
    .registers 2
    .parameter

    .prologue
    .line 1495
    .local p0, this:Landroid/accounts/AccountManager$BaseFutureTask$Response;,"Landroid/accounts/AccountManager$BaseFutureTask<TT;>.Response;"
    iput-object p1, p0, Landroid/accounts/AccountManager$BaseFutureTask$Response;->this$1:Landroid/accounts/AccountManager$BaseFutureTask;

    invoke-direct {p0}, Landroid/accounts/IAccountManagerResponse$Stub;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(ILjava/lang/String;)V
    .registers 5
    .parameter "code"
    .parameter "message"

    .prologue
    .line 1513
    .local p0, this:Landroid/accounts/AccountManager$BaseFutureTask$Response;,"Landroid/accounts/AccountManager$BaseFutureTask<TT;>.Response;"
    const/4 v0, 0x4

    if-ne p1, v0, :cond_a

    .line 1514
    iget-object v0, p0, Landroid/accounts/AccountManager$BaseFutureTask$Response;->this$1:Landroid/accounts/AccountManager$BaseFutureTask;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/accounts/AccountManager$BaseFutureTask;->cancel(Z)Z

    .line 1518
    :goto_9
    return-void

    .line 1517
    :cond_a
    iget-object v0, p0, Landroid/accounts/AccountManager$BaseFutureTask$Response;->this$1:Landroid/accounts/AccountManager$BaseFutureTask;

    iget-object v1, p0, Landroid/accounts/AccountManager$BaseFutureTask$Response;->this$1:Landroid/accounts/AccountManager$BaseFutureTask;

    iget-object v1, v1, Landroid/accounts/AccountManager$BaseFutureTask;->this$0:Landroid/accounts/AccountManager;

    #calls: Landroid/accounts/AccountManager;->convertErrorToException(ILjava/lang/String;)Ljava/lang/Exception;
    invoke-static {v1, p1, p2}, Landroid/accounts/AccountManager;->access$400(Landroid/accounts/AccountManager;ILjava/lang/String;)Ljava/lang/Exception;

    move-result-object v1

    #calls: Landroid/accounts/AccountManager$BaseFutureTask;->setException(Ljava/lang/Throwable;)V
    invoke-static {v0, v1}, Landroid/accounts/AccountManager$BaseFutureTask;->access$800(Landroid/accounts/AccountManager$BaseFutureTask;Ljava/lang/Throwable;)V

    goto :goto_9
.end method

.method public onResult(Landroid/os/Bundle;)V
    .registers 5
    .parameter "bundle"

    .prologue
    .line 1498
    .local p0, this:Landroid/accounts/AccountManager$BaseFutureTask$Response;,"Landroid/accounts/AccountManager$BaseFutureTask<TT;>.Response;"
    :try_start_0
    iget-object v1, p0, Landroid/accounts/AccountManager$BaseFutureTask$Response;->this$1:Landroid/accounts/AccountManager$BaseFutureTask;

    invoke-virtual {v1, p1}, Landroid/accounts/AccountManager$BaseFutureTask;->bundleToResult(Landroid/os/Bundle;)Ljava/lang/Object;

    move-result-object v0

    .line 1499
    .local v0, result:Ljava/lang/Object;,"TT;"
    if-nez v0, :cond_9

    .line 1510
    .end local v0           #result:Ljava/lang/Object;,"TT;"
    :goto_8
    return-void

    .line 1502
    .restart local v0       #result:Ljava/lang/Object;,"TT;"
    :cond_9
    iget-object v1, p0, Landroid/accounts/AccountManager$BaseFutureTask$Response;->this$1:Landroid/accounts/AccountManager$BaseFutureTask;

    #calls: Landroid/accounts/AccountManager$BaseFutureTask;->set(Ljava/lang/Object;)V
    invoke-static {v1, v0}, Landroid/accounts/AccountManager$BaseFutureTask;->access$700(Landroid/accounts/AccountManager$BaseFutureTask;Ljava/lang/Object;)V
    :try_end_e
    .catch Ljava/lang/ClassCastException; {:try_start_0 .. :try_end_e} :catch_f
    .catch Landroid/accounts/AuthenticatorException; {:try_start_0 .. :try_end_e} :catch_18

    goto :goto_8

    .line 1504
    .end local v0           #result:Ljava/lang/Object;,"TT;"
    :catch_f
    move-exception v1

    .line 1509
    :goto_10
    const/4 v1, 0x5

    const-string/jumbo v2, "no result in response"

    invoke-virtual {p0, v1, v2}, Landroid/accounts/AccountManager$BaseFutureTask$Response;->onError(ILjava/lang/String;)V

    goto :goto_8

    .line 1506
    :catch_18
    move-exception v1

    goto :goto_10
.end method
