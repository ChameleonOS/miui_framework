.class Landroid/accounts/GrantCredentialsPermissionActivity$1;
.super Ljava/lang/Object;
.source "GrantCredentialsPermissionActivity.java"

# interfaces
.implements Landroid/accounts/AccountManagerCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/accounts/GrantCredentialsPermissionActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/accounts/AccountManagerCallback",
        "<",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Landroid/accounts/GrantCredentialsPermissionActivity;

.field final synthetic val$authTokenTypeView:Landroid/widget/TextView;


# direct methods
.method constructor <init>(Landroid/accounts/GrantCredentialsPermissionActivity;Landroid/widget/TextView;)V
    .registers 3
    .parameter
    .parameter

    .prologue
    .line 94
    iput-object p1, p0, Landroid/accounts/GrantCredentialsPermissionActivity$1;->this$0:Landroid/accounts/GrantCredentialsPermissionActivity;

    iput-object p2, p0, Landroid/accounts/GrantCredentialsPermissionActivity$1;->val$authTokenTypeView:Landroid/widget/TextView;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run(Landroid/accounts/AccountManagerFuture;)V
    .registers 5
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/accounts/AccountManagerFuture",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 97
    .local p1, future:Landroid/accounts/AccountManagerFuture;,"Landroid/accounts/AccountManagerFuture<Ljava/lang/String;>;"
    :try_start_0
    invoke-interface {p1}, Landroid/accounts/AccountManagerFuture;->getResult()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 98
    .local v0, authTokenLabel:Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_16

    .line 99
    iget-object v1, p0, Landroid/accounts/GrantCredentialsPermissionActivity$1;->this$0:Landroid/accounts/GrantCredentialsPermissionActivity;

    new-instance v2, Landroid/accounts/GrantCredentialsPermissionActivity$1$1;

    invoke-direct {v2, p0, v0}, Landroid/accounts/GrantCredentialsPermissionActivity$1$1;-><init>(Landroid/accounts/GrantCredentialsPermissionActivity$1;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Landroid/accounts/GrantCredentialsPermissionActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    :try_end_16
    .catch Landroid/accounts/OperationCanceledException; {:try_start_0 .. :try_end_16} :catch_1b
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_16} :catch_19
    .catch Landroid/accounts/AuthenticatorException; {:try_start_0 .. :try_end_16} :catch_17

    .line 112
    .end local v0           #authTokenLabel:Ljava/lang/String;
    :cond_16
    :goto_16
    return-void

    .line 110
    :catch_17
    move-exception v1

    goto :goto_16

    .line 109
    :catch_19
    move-exception v1

    goto :goto_16

    .line 108
    :catch_1b
    move-exception v1

    goto :goto_16
.end method
