.class Lmiui/accounts/ExtraAccountManager$3;
.super Landroid/content/BroadcastReceiver;
.source "ExtraAccountManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/accounts/ExtraAccountManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lmiui/accounts/ExtraAccountManager;


# direct methods
.method constructor <init>(Lmiui/accounts/ExtraAccountManager;)V
    .registers 2
    .parameter

    .prologue
    .line 155
    iput-object p1, p0, Lmiui/accounts/ExtraAccountManager$3;->this$0:Lmiui/accounts/ExtraAccountManager;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .registers 14
    .parameter "context"
    .parameter "intent"

    .prologue
    .line 157
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v7

    .line 158
    .local v7, action:Ljava/lang/String;
    const-string v0, "android.accounts.LOGIN_ACCOUNTS_PRE_CHANGED"

    invoke-virtual {v0, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_67

    .line 159
    const-string v0, "extra_account"

    invoke-virtual {p2, v0}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v3

    check-cast v3, Landroid/accounts/Account;

    .line 160
    .local v3, account:Landroid/accounts/Account;
    const-string v0, "extra_bundle"

    invoke-virtual {p2, v0}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v5

    check-cast v5, Landroid/os/Bundle;

    .line 161
    .local v5, extra:Landroid/os/Bundle;
    const-string v0, "extra_update_type"

    const/4 v1, -0x1

    invoke-virtual {p2, v0, v1}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v4

    .line 162
    .local v4, type:I
    if-eqz v3, :cond_5f

    if-lez v4, :cond_5f

    .line 163
    iget-object v0, p0, Lmiui/accounts/ExtraAccountManager$3;->this$0:Lmiui/accounts/ExtraAccountManager;

    #getter for: Lmiui/accounts/ExtraAccountManager;->mMiuiAccountsUpdatedListeners:Ljava/util/HashMap;
    invoke-static {v0}, Lmiui/accounts/ExtraAccountManager;->access$000(Lmiui/accounts/ExtraAccountManager;)Ljava/util/HashMap;

    move-result-object v10

    monitor-enter v10

    .line 165
    :try_start_2e
    iget-object v0, p0, Lmiui/accounts/ExtraAccountManager$3;->this$0:Lmiui/accounts/ExtraAccountManager;

    #getter for: Lmiui/accounts/ExtraAccountManager;->mMiuiAccountsUpdatedListeners:Ljava/util/HashMap;
    invoke-static {v0}, Lmiui/accounts/ExtraAccountManager;->access$000(Lmiui/accounts/ExtraAccountManager;)Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v9

    .local v9, i$:Ljava/util/Iterator;
    :goto_3c
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_5d

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/Map$Entry;

    .line 166
    .local v8, entry:Ljava/util/Map$Entry;,"Ljava/util/Map$Entry<Landroid/accounts/MiuiOnAccountsUpdateListener;Landroid/os/Handler;>;"
    iget-object v0, p0, Lmiui/accounts/ExtraAccountManager$3;->this$0:Lmiui/accounts/ExtraAccountManager;

    invoke-interface {v8}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/os/Handler;

    invoke-interface {v8}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/accounts/MiuiOnAccountsUpdateListener;

    #calls: Lmiui/accounts/ExtraAccountManager;->postToHandler(Landroid/os/Handler;Landroid/accounts/MiuiOnAccountsUpdateListener;Landroid/accounts/Account;ILandroid/os/Bundle;)V
    invoke-static/range {v0 .. v5}, Lmiui/accounts/ExtraAccountManager;->access$100(Lmiui/accounts/ExtraAccountManager;Landroid/os/Handler;Landroid/accounts/MiuiOnAccountsUpdateListener;Landroid/accounts/Account;ILandroid/os/Bundle;)V

    goto :goto_3c

    .line 169
    .end local v8           #entry:Ljava/util/Map$Entry;,"Ljava/util/Map$Entry<Landroid/accounts/MiuiOnAccountsUpdateListener;Landroid/os/Handler;>;"
    .end local v9           #i$:Ljava/util/Iterator;
    :catchall_5a
    move-exception v0

    monitor-exit v10
    :try_end_5c
    .catchall {:try_start_2e .. :try_end_5c} :catchall_5a

    throw v0

    .restart local v9       #i$:Ljava/util/Iterator;
    :cond_5d
    :try_start_5d
    monitor-exit v10
    :try_end_5e
    .catchall {:try_start_5d .. :try_end_5e} :catchall_5a

    .line 184
    .end local v3           #account:Landroid/accounts/Account;
    .end local v4           #type:I
    .end local v5           #extra:Landroid/os/Bundle;
    .end local v9           #i$:Ljava/util/Iterator;
    :goto_5e
    return-void

    .line 171
    .restart local v3       #account:Landroid/accounts/Account;
    .restart local v4       #type:I
    .restart local v5       #extra:Landroid/os/Bundle;
    :cond_5f
    const-string v0, "ExtraAccountManager"

    const-string v1, "account changed, but no account or type"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_5e

    .line 174
    .end local v3           #account:Landroid/accounts/Account;
    .end local v4           #type:I
    .end local v5           #extra:Landroid/os/Bundle;
    :cond_67
    iget-object v0, p0, Lmiui/accounts/ExtraAccountManager$3;->this$0:Lmiui/accounts/ExtraAccountManager;

    #getter for: Lmiui/accounts/ExtraAccountManager;->mAccountManager:Landroid/accounts/AccountManager;
    invoke-static {v0}, Lmiui/accounts/ExtraAccountManager;->access$200(Lmiui/accounts/ExtraAccountManager;)Landroid/accounts/AccountManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/accounts/AccountManager;->getAccounts()[Landroid/accounts/Account;

    move-result-object v6

    .line 176
    .local v6, accounts:[Landroid/accounts/Account;
    iget-object v0, p0, Lmiui/accounts/ExtraAccountManager$3;->this$0:Lmiui/accounts/ExtraAccountManager;

    #getter for: Lmiui/accounts/ExtraAccountManager;->mMiuiAccountsUpdatedListeners:Ljava/util/HashMap;
    invoke-static {v0}, Lmiui/accounts/ExtraAccountManager;->access$000(Lmiui/accounts/ExtraAccountManager;)Ljava/util/HashMap;

    move-result-object v2

    monitor-enter v2

    .line 178
    :try_start_78
    iget-object v0, p0, Lmiui/accounts/ExtraAccountManager$3;->this$0:Lmiui/accounts/ExtraAccountManager;

    #getter for: Lmiui/accounts/ExtraAccountManager;->mMiuiAccountsUpdatedListeners:Ljava/util/HashMap;
    invoke-static {v0}, Lmiui/accounts/ExtraAccountManager;->access$000(Lmiui/accounts/ExtraAccountManager;)Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v9

    .restart local v9       #i$:Ljava/util/Iterator;
    :goto_86
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_a7

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/Map$Entry;

    .line 179
    .restart local v8       #entry:Ljava/util/Map$Entry;,"Ljava/util/Map$Entry<Landroid/accounts/MiuiOnAccountsUpdateListener;Landroid/os/Handler;>;"
    iget-object v10, p0, Lmiui/accounts/ExtraAccountManager$3;->this$0:Lmiui/accounts/ExtraAccountManager;

    invoke-interface {v8}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/Handler;

    invoke-interface {v8}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/accounts/MiuiOnAccountsUpdateListener;

    #calls: Lmiui/accounts/ExtraAccountManager;->postToHandler(Landroid/os/Handler;Landroid/accounts/MiuiOnAccountsUpdateListener;[Landroid/accounts/Account;)V
    invoke-static {v10, v0, v1, v6}, Lmiui/accounts/ExtraAccountManager;->access$300(Lmiui/accounts/ExtraAccountManager;Landroid/os/Handler;Landroid/accounts/MiuiOnAccountsUpdateListener;[Landroid/accounts/Account;)V

    goto :goto_86

    .line 182
    .end local v8           #entry:Ljava/util/Map$Entry;,"Ljava/util/Map$Entry<Landroid/accounts/MiuiOnAccountsUpdateListener;Landroid/os/Handler;>;"
    .end local v9           #i$:Ljava/util/Iterator;
    :catchall_a4
    move-exception v0

    monitor-exit v2
    :try_end_a6
    .catchall {:try_start_78 .. :try_end_a6} :catchall_a4

    throw v0

    .restart local v9       #i$:Ljava/util/Iterator;
    :cond_a7
    :try_start_a7
    monitor-exit v2
    :try_end_a8
    .catchall {:try_start_a7 .. :try_end_a8} :catchall_a4

    goto :goto_5e
.end method
