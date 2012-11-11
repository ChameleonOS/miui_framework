.class Lmiui/accounts/ExtraAccountManager$2;
.super Ljava/lang/Object;
.source "ExtraAccountManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lmiui/accounts/ExtraAccountManager;->postToHandler(Landroid/os/Handler;Landroid/accounts/MiuiOnAccountsUpdateListener;Landroid/accounts/Account;ILandroid/os/Bundle;Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lmiui/accounts/ExtraAccountManager;

.field final synthetic val$account:Landroid/accounts/Account;

.field final synthetic val$extra:Landroid/os/Bundle;

.field final synthetic val$listener:Landroid/accounts/MiuiOnAccountsUpdateListener;

.field final synthetic val$preAdd:Z

.field final synthetic val$type:I


# direct methods
.method constructor <init>(Lmiui/accounts/ExtraAccountManager;ZLandroid/accounts/MiuiOnAccountsUpdateListener;Landroid/accounts/Account;ILandroid/os/Bundle;)V
    .registers 7
    .parameter
    .parameter
    .parameter
    .parameter
    .parameter
    .parameter

    .prologue
    iput-object p1, p0, Lmiui/accounts/ExtraAccountManager$2;->this$0:Lmiui/accounts/ExtraAccountManager;

    iput-boolean p2, p0, Lmiui/accounts/ExtraAccountManager$2;->val$preAdd:Z

    iput-object p3, p0, Lmiui/accounts/ExtraAccountManager$2;->val$listener:Landroid/accounts/MiuiOnAccountsUpdateListener;

    iput-object p4, p0, Lmiui/accounts/ExtraAccountManager$2;->val$account:Landroid/accounts/Account;

    iput p5, p0, Lmiui/accounts/ExtraAccountManager$2;->val$type:I

    iput-object p6, p0, Lmiui/accounts/ExtraAccountManager$2;->val$extra:Landroid/os/Bundle;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 6

    .prologue
    :try_start_0
    iget-boolean v1, p0, Lmiui/accounts/ExtraAccountManager$2;->val$preAdd:Z

    if-eqz v1, :cond_10

    iget-object v1, p0, Lmiui/accounts/ExtraAccountManager$2;->val$listener:Landroid/accounts/MiuiOnAccountsUpdateListener;

    iget-object v2, p0, Lmiui/accounts/ExtraAccountManager$2;->val$account:Landroid/accounts/Account;

    iget v3, p0, Lmiui/accounts/ExtraAccountManager$2;->val$type:I

    iget-object v4, p0, Lmiui/accounts/ExtraAccountManager$2;->val$extra:Landroid/os/Bundle;

    invoke-interface {v1, v2, v3, v4}, Landroid/accounts/MiuiOnAccountsUpdateListener;->onPreAccountUpdated(Landroid/accounts/Account;ILandroid/os/Bundle;)V

    :goto_f
    return-void

    :cond_10
    iget-object v1, p0, Lmiui/accounts/ExtraAccountManager$2;->val$listener:Landroid/accounts/MiuiOnAccountsUpdateListener;

    iget-object v2, p0, Lmiui/accounts/ExtraAccountManager$2;->val$account:Landroid/accounts/Account;

    iget v3, p0, Lmiui/accounts/ExtraAccountManager$2;->val$type:I

    iget-object v4, p0, Lmiui/accounts/ExtraAccountManager$2;->val$extra:Landroid/os/Bundle;

    invoke-interface {v1, v2, v3, v4}, Landroid/accounts/MiuiOnAccountsUpdateListener;->onPostAccountUpdated(Landroid/accounts/Account;ILandroid/os/Bundle;)V
    :try_end_1b
    .catch Landroid/database/SQLException; {:try_start_0 .. :try_end_1b} :catch_1c

    goto :goto_f

    :catch_1c
    move-exception v0

    .local v0, e:Landroid/database/SQLException;
    const-string v1, "ExtraAccountManager"

    const-string v2, "Can\'t update accounts"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_f
.end method
