.class public Landroid/accounts/AccountAuthenticatorActivity;
.super Landroid/app/Activity;
.source "AccountAuthenticatorActivity.java"


# instance fields
.field private mAccountAuthenticatorResponse:Landroid/accounts/AccountAuthenticatorResponse;

.field private mResultBundle:Landroid/os/Bundle;


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    const/4 v0, 0x0

    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    iput-object v0, p0, Landroid/accounts/AccountAuthenticatorActivity;->mAccountAuthenticatorResponse:Landroid/accounts/AccountAuthenticatorResponse;

    iput-object v0, p0, Landroid/accounts/AccountAuthenticatorActivity;->mResultBundle:Landroid/os/Bundle;

    return-void
.end method


# virtual methods
.method public finish()V
    .registers 4

    .prologue
    iget-object v0, p0, Landroid/accounts/AccountAuthenticatorActivity;->mAccountAuthenticatorResponse:Landroid/accounts/AccountAuthenticatorResponse;

    if-eqz v0, :cond_12

    iget-object v0, p0, Landroid/accounts/AccountAuthenticatorActivity;->mResultBundle:Landroid/os/Bundle;

    if-eqz v0, :cond_16

    iget-object v0, p0, Landroid/accounts/AccountAuthenticatorActivity;->mAccountAuthenticatorResponse:Landroid/accounts/AccountAuthenticatorResponse;

    iget-object v1, p0, Landroid/accounts/AccountAuthenticatorActivity;->mResultBundle:Landroid/os/Bundle;

    invoke-virtual {v0, v1}, Landroid/accounts/AccountAuthenticatorResponse;->onResult(Landroid/os/Bundle;)V

    :goto_f
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/accounts/AccountAuthenticatorActivity;->mAccountAuthenticatorResponse:Landroid/accounts/AccountAuthenticatorResponse;

    :cond_12
    invoke-super {p0}, Landroid/app/Activity;->finish()V

    return-void

    :cond_16
    iget-object v0, p0, Landroid/accounts/AccountAuthenticatorActivity;->mAccountAuthenticatorResponse:Landroid/accounts/AccountAuthenticatorResponse;

    const/4 v1, 0x4

    const-string v2, "canceled"

    invoke-virtual {v0, v1, v2}, Landroid/accounts/AccountAuthenticatorResponse;->onError(ILjava/lang/String;)V

    goto :goto_f
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .registers 4
    .parameter "icicle"

    .prologue
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    invoke-virtual {p0}, Landroid/accounts/AccountAuthenticatorActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "accountAuthenticatorResponse"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/accounts/AccountAuthenticatorResponse;

    iput-object v0, p0, Landroid/accounts/AccountAuthenticatorActivity;->mAccountAuthenticatorResponse:Landroid/accounts/AccountAuthenticatorResponse;

    iget-object v0, p0, Landroid/accounts/AccountAuthenticatorActivity;->mAccountAuthenticatorResponse:Landroid/accounts/AccountAuthenticatorResponse;

    if-eqz v0, :cond_1a

    iget-object v0, p0, Landroid/accounts/AccountAuthenticatorActivity;->mAccountAuthenticatorResponse:Landroid/accounts/AccountAuthenticatorResponse;

    invoke-virtual {v0}, Landroid/accounts/AccountAuthenticatorResponse;->onRequestContinued()V

    :cond_1a
    return-void
.end method

.method public final setAccountAuthenticatorResult(Landroid/os/Bundle;)V
    .registers 2
    .parameter "result"

    .prologue
    iput-object p1, p0, Landroid/accounts/AccountAuthenticatorActivity;->mResultBundle:Landroid/os/Bundle;

    return-void
.end method
