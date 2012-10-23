.class Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask$1$1;
.super Landroid/accounts/IAccountManagerResponse$Stub;
.source "AccountManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask$1;->run(Landroid/accounts/AccountManagerFuture;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask$1;


# direct methods
.method constructor <init>(Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask$1;)V
    .registers 2
    .parameter

    .prologue
    .line 1691
    iput-object p1, p0, Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask$1$1;->this$2:Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask$1;

    invoke-direct {p0}, Landroid/accounts/IAccountManagerResponse$Stub;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(ILjava/lang/String;)V
    .registers 4
    .parameter "errorCode"
    .parameter "errorMessage"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 1702
    iget-object v0, p0, Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask$1$1;->this$2:Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask$1;

    iget-object v0, v0, Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask$1;->this$1:Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask;

    iget-object v0, v0, Landroid/accounts/AccountManager$AmsTask;->mResponse:Landroid/accounts/IAccountManagerResponse;

    invoke-interface {v0, p1, p2}, Landroid/accounts/IAccountManagerResponse;->onError(ILjava/lang/String;)V

    .line 1703
    return-void
.end method

.method public onResult(Landroid/os/Bundle;)V
    .registers 10
    .parameter "value"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 1693
    new-instance v1, Landroid/accounts/Account;

    const-string v0, "authAccount"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v2, "accountType"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v0, v2}, Landroid/accounts/Account;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 1696
    .local v1, account:Landroid/accounts/Account;
    iget-object v0, p0, Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask$1$1;->this$2:Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask$1;

    iget-object v7, v0, Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask$1;->this$1:Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask;

    iget-object v0, p0, Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask$1$1;->this$2:Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask$1;

    iget-object v0, v0, Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask$1;->this$1:Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask;

    iget-object v0, v0, Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask;->this$0:Landroid/accounts/AccountManager;

    iget-object v2, p0, Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask$1$1;->this$2:Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask$1;

    iget-object v2, v2, Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask$1;->this$1:Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask;

    iget-object v2, v2, Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask;->mAuthTokenType:Ljava/lang/String;

    iget-object v3, p0, Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask$1$1;->this$2:Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask$1;

    iget-object v3, v3, Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask$1;->this$1:Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask;

    iget-object v3, v3, Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask;->mLoginOptions:Landroid/os/Bundle;

    iget-object v4, p0, Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask$1$1;->this$2:Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask$1;

    iget-object v4, v4, Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask$1;->this$1:Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask;

    iget-object v4, v4, Landroid/accounts/AccountManager$AmsTask;->mActivity:Landroid/app/Activity;

    iget-object v5, p0, Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask$1$1;->this$2:Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask$1;

    iget-object v5, v5, Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask$1;->this$1:Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask;

    iget-object v5, v5, Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask;->mMyCallback:Landroid/accounts/AccountManagerCallback;

    iget-object v6, p0, Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask$1$1;->this$2:Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask$1;

    iget-object v6, v6, Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask$1;->this$1:Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask;

    iget-object v6, v6, Landroid/accounts/AccountManager$AmsTask;->mHandler:Landroid/os/Handler;

    invoke-virtual/range {v0 .. v6}, Landroid/accounts/AccountManager;->getAuthToken(Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;Landroid/app/Activity;Landroid/accounts/AccountManagerCallback;Landroid/os/Handler;)Landroid/accounts/AccountManagerFuture;

    move-result-object v0

    iput-object v0, v7, Landroid/accounts/AccountManager$GetAuthTokenByTypeAndFeaturesTask;->mFuture:Landroid/accounts/AccountManagerFuture;

    .line 1698
    return-void
.end method
