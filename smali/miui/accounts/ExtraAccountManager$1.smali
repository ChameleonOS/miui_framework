.class Lmiui/accounts/ExtraAccountManager$1;
.super Ljava/lang/Object;
.source "ExtraAccountManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lmiui/accounts/ExtraAccountManager;->postToHandler(Landroid/os/Handler;Landroid/accounts/MiuiOnAccountsUpdateListener;[Landroid/accounts/Account;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lmiui/accounts/ExtraAccountManager;

.field final synthetic val$accountsCopy:[Landroid/accounts/Account;

.field final synthetic val$listener:Landroid/accounts/MiuiOnAccountsUpdateListener;


# direct methods
.method constructor <init>(Lmiui/accounts/ExtraAccountManager;Landroid/accounts/MiuiOnAccountsUpdateListener;[Landroid/accounts/Account;)V
    .registers 4
    .parameter
    .parameter
    .parameter

    .prologue
    .line 141
    iput-object p1, p0, Lmiui/accounts/ExtraAccountManager$1;->this$0:Lmiui/accounts/ExtraAccountManager;

    iput-object p2, p0, Lmiui/accounts/ExtraAccountManager$1;->val$listener:Landroid/accounts/MiuiOnAccountsUpdateListener;

    iput-object p3, p0, Lmiui/accounts/ExtraAccountManager$1;->val$accountsCopy:[Landroid/accounts/Account;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 4

    .prologue
    .line 144
    :try_start_0
    iget-object v1, p0, Lmiui/accounts/ExtraAccountManager$1;->val$listener:Landroid/accounts/MiuiOnAccountsUpdateListener;

    iget-object v2, p0, Lmiui/accounts/ExtraAccountManager$1;->val$accountsCopy:[Landroid/accounts/Account;

    invoke-interface {v1, v2}, Landroid/accounts/MiuiOnAccountsUpdateListener;->onAccountsUpdated([Landroid/accounts/Account;)V
    :try_end_7
    .catch Landroid/database/SQLException; {:try_start_0 .. :try_end_7} :catch_8

    .line 150
    :goto_7
    return-void

    .line 145
    :catch_8
    move-exception v0

    .line 148
    .local v0, e:Landroid/database/SQLException;
    const-string v1, "ExtraAccountManager"

    const-string v2, "Can\'t update accounts"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_7
.end method
