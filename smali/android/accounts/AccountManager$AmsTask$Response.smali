.class Landroid/accounts/AccountManager$AmsTask$Response;
.super Landroid/accounts/IAccountManagerResponse$Stub;
.source "AccountManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/accounts/AccountManager$AmsTask;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "Response"
.end annotation


# instance fields
.field final synthetic this$1:Landroid/accounts/AccountManager$AmsTask;


# direct methods
.method private constructor <init>(Landroid/accounts/AccountManager$AmsTask;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Landroid/accounts/AccountManager$AmsTask$Response;->this$1:Landroid/accounts/AccountManager$AmsTask;

    invoke-direct {p0}, Landroid/accounts/IAccountManagerResponse$Stub;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/accounts/AccountManager$AmsTask;Landroid/accounts/AccountManager$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-direct {p0, p1}, Landroid/accounts/AccountManager$AmsTask$Response;-><init>(Landroid/accounts/AccountManager$AmsTask;)V

    return-void
.end method


# virtual methods
.method public onError(ILjava/lang/String;)V
    .registers 5
    .parameter "code"
    .parameter "message"

    .prologue
    const/4 v0, 0x4

    if-ne p1, v0, :cond_a

    iget-object v0, p0, Landroid/accounts/AccountManager$AmsTask$Response;->this$1:Landroid/accounts/AccountManager$AmsTask;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/accounts/AccountManager$AmsTask;->cancel(Z)Z

    :goto_9
    return-void

    :cond_a
    iget-object v0, p0, Landroid/accounts/AccountManager$AmsTask$Response;->this$1:Landroid/accounts/AccountManager$AmsTask;

    iget-object v1, p0, Landroid/accounts/AccountManager$AmsTask$Response;->this$1:Landroid/accounts/AccountManager$AmsTask;

    iget-object v1, v1, Landroid/accounts/AccountManager$AmsTask;->this$0:Landroid/accounts/AccountManager;

    #calls: Landroid/accounts/AccountManager;->convertErrorToException(ILjava/lang/String;)Ljava/lang/Exception;
    invoke-static {v1, p1, p2}, Landroid/accounts/AccountManager;->access$400(Landroid/accounts/AccountManager;ILjava/lang/String;)Ljava/lang/Exception;

    move-result-object v1

    #calls: Landroid/accounts/AccountManager$AmsTask;->setException(Ljava/lang/Throwable;)V
    invoke-static {v0, v1}, Landroid/accounts/AccountManager$AmsTask;->access$500(Landroid/accounts/AccountManager$AmsTask;Ljava/lang/Throwable;)V

    goto :goto_9
.end method

.method public onResult(Landroid/os/Bundle;)V
    .registers 4
    .parameter "bundle"

    .prologue
    const-string v1, "intent"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/content/Intent;

    .local v0, intent:Landroid/content/Intent;
    if-eqz v0, :cond_18

    iget-object v1, p0, Landroid/accounts/AccountManager$AmsTask$Response;->this$1:Landroid/accounts/AccountManager$AmsTask;

    iget-object v1, v1, Landroid/accounts/AccountManager$AmsTask;->mActivity:Landroid/app/Activity;

    if-eqz v1, :cond_18

    iget-object v1, p0, Landroid/accounts/AccountManager$AmsTask$Response;->this$1:Landroid/accounts/AccountManager$AmsTask;

    iget-object v1, v1, Landroid/accounts/AccountManager$AmsTask;->mActivity:Landroid/app/Activity;

    invoke-virtual {v1, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    :goto_17
    return-void

    :cond_18
    const-string/jumbo v1, "retry"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_29

    :try_start_21
    iget-object v1, p0, Landroid/accounts/AccountManager$AmsTask$Response;->this$1:Landroid/accounts/AccountManager$AmsTask;

    invoke-virtual {v1}, Landroid/accounts/AccountManager$AmsTask;->doWork()V
    :try_end_26
    .catch Landroid/os/RemoteException; {:try_start_21 .. :try_end_26} :catch_27

    goto :goto_17

    :catch_27
    move-exception v1

    goto :goto_17

    :cond_29
    iget-object v1, p0, Landroid/accounts/AccountManager$AmsTask$Response;->this$1:Landroid/accounts/AccountManager$AmsTask;

    invoke-virtual {v1, p1}, Landroid/accounts/AccountManager$AmsTask;->set(Landroid/os/Bundle;)V

    goto :goto_17
.end method
