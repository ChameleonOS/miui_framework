.class Landroid/accounts/AccountManager$7;
.super Landroid/accounts/AccountManager$AmsTask;
.source "AccountManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/accounts/AccountManager;->addAccount(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/os/Bundle;Landroid/app/Activity;Landroid/accounts/AccountManagerCallback;Landroid/os/Handler;)Landroid/accounts/AccountManagerFuture;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/accounts/AccountManager;

.field final synthetic val$accountType:Ljava/lang/String;

.field final synthetic val$activity:Landroid/app/Activity;

.field final synthetic val$authTokenType:Ljava/lang/String;

.field final synthetic val$optionsIn:Landroid/os/Bundle;

.field final synthetic val$requiredFeatures:[Ljava/lang/String;


# direct methods
.method constructor <init>(Landroid/accounts/AccountManager;Landroid/app/Activity;Landroid/os/Handler;Landroid/accounts/AccountManagerCallback;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/app/Activity;Landroid/os/Bundle;)V
    .registers 10
    .parameter
    .parameter "x0"
    .parameter "x1"
    .parameter
    .parameter
    .parameter
    .parameter
    .parameter
    .parameter

    .prologue
    .line 1111
    .local p4, x2:Landroid/accounts/AccountManagerCallback;,"Landroid/accounts/AccountManagerCallback<Landroid/os/Bundle;>;"
    iput-object p1, p0, Landroid/accounts/AccountManager$7;->this$0:Landroid/accounts/AccountManager;

    iput-object p5, p0, Landroid/accounts/AccountManager$7;->val$accountType:Ljava/lang/String;

    iput-object p6, p0, Landroid/accounts/AccountManager$7;->val$authTokenType:Ljava/lang/String;

    iput-object p7, p0, Landroid/accounts/AccountManager$7;->val$requiredFeatures:[Ljava/lang/String;

    iput-object p8, p0, Landroid/accounts/AccountManager$7;->val$activity:Landroid/app/Activity;

    iput-object p9, p0, Landroid/accounts/AccountManager$7;->val$optionsIn:Landroid/os/Bundle;

    invoke-direct {p0, p1, p2, p3, p4}, Landroid/accounts/AccountManager$AmsTask;-><init>(Landroid/accounts/AccountManager;Landroid/app/Activity;Landroid/os/Handler;Landroid/accounts/AccountManagerCallback;)V

    return-void
.end method


# virtual methods
.method public doWork()V
    .registers 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 1113
    iget-object v0, p0, Landroid/accounts/AccountManager$7;->this$0:Landroid/accounts/AccountManager;

    #getter for: Landroid/accounts/AccountManager;->mService:Landroid/accounts/IAccountManager;
    invoke-static {v0}, Landroid/accounts/AccountManager;->access$000(Landroid/accounts/AccountManager;)Landroid/accounts/IAccountManager;

    move-result-object v0

    iget-object v1, p0, Landroid/accounts/AccountManager$AmsTask;->mResponse:Landroid/accounts/IAccountManagerResponse;

    iget-object v2, p0, Landroid/accounts/AccountManager$7;->val$accountType:Ljava/lang/String;

    iget-object v3, p0, Landroid/accounts/AccountManager$7;->val$authTokenType:Ljava/lang/String;

    iget-object v4, p0, Landroid/accounts/AccountManager$7;->val$requiredFeatures:[Ljava/lang/String;

    iget-object v5, p0, Landroid/accounts/AccountManager$7;->val$activity:Landroid/app/Activity;

    if-eqz v5, :cond_19

    const/4 v5, 0x1

    :goto_13
    iget-object v6, p0, Landroid/accounts/AccountManager$7;->val$optionsIn:Landroid/os/Bundle;

    invoke-interface/range {v0 .. v6}, Landroid/accounts/IAccountManager;->addAcount(Landroid/accounts/IAccountManagerResponse;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;ZLandroid/os/Bundle;)V

    .line 1115
    return-void

    .line 1113
    :cond_19
    const/4 v5, 0x0

    goto :goto_13
.end method
