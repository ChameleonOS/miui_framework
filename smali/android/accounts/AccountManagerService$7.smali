.class Landroid/accounts/AccountManagerService$7;
.super Landroid/accounts/AccountManagerService$Session;
.source "AccountManagerService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/accounts/AccountManagerService;->updateCredentials(Landroid/accounts/IAccountManagerResponse;Landroid/accounts/Account;Ljava/lang/String;ZLandroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/accounts/AccountManagerService;

.field final synthetic val$account:Landroid/accounts/Account;

.field final synthetic val$authTokenType:Ljava/lang/String;

.field final synthetic val$loginOptions:Landroid/os/Bundle;


# direct methods
.method constructor <init>(Landroid/accounts/AccountManagerService;Landroid/accounts/AccountManagerService$UserAccounts;Landroid/accounts/IAccountManagerResponse;Ljava/lang/String;ZZLandroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;)V
    .registers 10
    .parameter
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"
    .parameter "x3"
    .parameter "x4"
    .parameter
    .parameter
    .parameter

    .prologue
    .line 1342
    iput-object p1, p0, Landroid/accounts/AccountManagerService$7;->this$0:Landroid/accounts/AccountManagerService;

    iput-object p7, p0, Landroid/accounts/AccountManagerService$7;->val$account:Landroid/accounts/Account;

    iput-object p8, p0, Landroid/accounts/AccountManagerService$7;->val$authTokenType:Ljava/lang/String;

    iput-object p9, p0, Landroid/accounts/AccountManagerService$7;->val$loginOptions:Landroid/os/Bundle;

    invoke-direct/range {p0 .. p6}, Landroid/accounts/AccountManagerService$Session;-><init>(Landroid/accounts/AccountManagerService;Landroid/accounts/AccountManagerService$UserAccounts;Landroid/accounts/IAccountManagerResponse;Ljava/lang/String;ZZ)V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 1344
    iget-object v0, p0, Landroid/accounts/AccountManagerService$Session;->mAuthenticator:Landroid/accounts/IAccountAuthenticator;

    iget-object v1, p0, Landroid/accounts/AccountManagerService$7;->val$account:Landroid/accounts/Account;

    iget-object v2, p0, Landroid/accounts/AccountManagerService$7;->val$authTokenType:Ljava/lang/String;

    iget-object v3, p0, Landroid/accounts/AccountManagerService$7;->val$loginOptions:Landroid/os/Bundle;

    invoke-interface {v0, p0, v1, v2, v3}, Landroid/accounts/IAccountAuthenticator;->updateCredentials(Landroid/accounts/IAccountAuthenticatorResponse;Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;)V

    .line 1345
    return-void
.end method

.method protected toDebugString(J)Ljava/lang/String;
    .registers 5
    .parameter "now"

    .prologue
    .line 1347
    iget-object v0, p0, Landroid/accounts/AccountManagerService$7;->val$loginOptions:Landroid/os/Bundle;

    if-eqz v0, :cond_9

    iget-object v0, p0, Landroid/accounts/AccountManagerService$7;->val$loginOptions:Landroid/os/Bundle;

    invoke-virtual {v0}, Landroid/os/Bundle;->keySet()Ljava/util/Set;

    .line 1348
    :cond_9
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-super {p0, p1, p2}, Landroid/accounts/AccountManagerService$Session;->toDebugString(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", updateCredentials"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Landroid/accounts/AccountManagerService$7;->val$account:Landroid/accounts/Account;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", authTokenType "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Landroid/accounts/AccountManagerService$7;->val$authTokenType:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", loginOptions "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Landroid/accounts/AccountManagerService$7;->val$loginOptions:Landroid/os/Bundle;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
