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
    .line 164
    iput-object p1, p0, Lmiui/accounts/ExtraAccountManager$3;->this$0:Lmiui/accounts/ExtraAccountManager;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .registers 15
    .parameter "context"
    .parameter "intent"

    .prologue
    .line 166
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v8

    .line 167
    .local v8, action:Ljava/lang/String;
    const-string v0, "android.accounts.LOGIN_ACCOUNTS_PRE_CHANGED"

    invoke-virtual {v0, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_14

    const-string v0, "android.accounts.LOGIN_ACCOUNTS_POST_CHANGED"

    invoke-virtual {v0, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_75

    .line 169
    :cond_14
    const-string v0, "extra_account"

    invoke-virtual {p2, v0}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v3

    check-cast v3, Landroid/accounts/Account;

    .line 170
    .local v3, account:Landroid/accounts/Account;
    const-string v0, "extra_bundle"

    invoke-virtual {p2, v0}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v5

    check-cast v5, Landroid/os/Bundle;

    .line 171
    .local v5, extra:Landroid/os/Bundle;
    const-string v0, "extra_update_type"

    const/4 v1, -0x1

    invoke-virtual {p2, v0, v1}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v4

    .line 172
    .local v4, type:I
    if-eqz v3, :cond_6d

    if-lez v4, :cond_6d

    .line 173
    iget-object v0, p0, Lmiui/accounts/ExtraAccountManager$3;->this$0:Lmiui/accounts/ExtraAccountManager;

    #getter for: Lmiui/accounts/ExtraAccountManager;->mMiuiAccountsUpdatedListeners:Ljava/util/HashMap;
    invoke-static {v0}, Lmiui/accounts/ExtraAccountManager;->access$000(Lmiui/accounts/ExtraAccountManager;)Ljava/util/HashMap;

    move-result-object v11

    monitor-enter v11

    .line 175
    :try_start_36
    iget-object v0, p0, Lmiui/accounts/ExtraAccountManager$3;->this$0:Lmiui/accounts/ExtraAccountManager;

    #getter for: Lmiui/accounts/ExtraAccountManager;->mMiuiAccountsUpdatedListeners:Ljava/util/HashMap;
    invoke-static {v0}, Lmiui/accounts/ExtraAccountManager;->access$000(Lmiui/accounts/ExtraAccountManager;)Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v10

    .local v10, i$:Ljava/util/Iterator;
    :goto_44
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_6b

    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/Map$Entry;

    .line 176
    .local v9, entry:Ljava/util/Map$Entry;,"Ljava/util/Map$Entry<Landroid/accounts/MiuiOnAccountsUpdateListener;Landroid/os/Handler;>;"
    iget-object v0, p0, Lmiui/accounts/ExtraAccountManager$3;->this$0:Lmiui/accounts/ExtraAccountManager;

    invoke-interface {v9}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/os/Handler;

    invoke-interface {v9}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/accounts/MiuiOnAccountsUpdateListener;

    const-string v6, "android.accounts.LOGIN_ACCOUNTS_PRE_CHANGED"

    invoke-virtual {v6, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    #calls: Lmiui/accounts/ExtraAccountManager;->postToHandler(Landroid/os/Handler;Landroid/accounts/MiuiOnAccountsUpdateListener;Landroid/accounts/Account;ILandroid/os/Bundle;Z)V
    invoke-static/range {v0 .. v6}, Lmiui/accounts/ExtraAccountManager;->access$100(Lmiui/accounts/ExtraAccountManager;Landroid/os/Handler;Landroid/accounts/MiuiOnAccountsUpdateListener;Landroid/accounts/Account;ILandroid/os/Bundle;Z)V

    goto :goto_44

    .line 181
    .end local v9           #entry:Ljava/util/Map$Entry;,"Ljava/util/Map$Entry<Landroid/accounts/MiuiOnAccountsUpdateListener;Landroid/os/Handler;>;"
    .end local v10           #i$:Ljava/util/Iterator;
    :catchall_68
    move-exception v0

    monitor-exit v11
    :try_end_6a
    .catchall {:try_start_36 .. :try_end_6a} :catchall_68

    throw v0

    .restart local v10       #i$:Ljava/util/Iterator;
    :cond_6b
    :try_start_6b
    monitor-exit v11
    :try_end_6c
    .catchall {:try_start_6b .. :try_end_6c} :catchall_68

    .line 196
    .end local v3           #account:Landroid/accounts/Account;
    .end local v4           #type:I
    .end local v5           #extra:Landroid/os/Bundle;
    .end local v10           #i$:Ljava/util/Iterator;
    :goto_6c
    return-void

    .line 183
    .restart local v3       #account:Landroid/accounts/Account;
    .restart local v4       #type:I
    .restart local v5       #extra:Landroid/os/Bundle;
    :cond_6d
    const-string v0, "ExtraAccountManager"

    const-string v1, "account changed, but no account or type"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_6c

    .line 186
    .end local v3           #account:Landroid/accounts/Account;
    .end local v4           #type:I
    .end local v5           #extra:Landroid/os/Bundle;
    :cond_75
    iget-object v0, p0, Lmiui/accounts/ExtraAccountManager$3;->this$0:Lmiui/accounts/ExtraAccountManager;

    #getter for: Lmiui/accounts/ExtraAccountManager;->mAccountManager:Landroid/accounts/AccountManager;
    invoke-static {v0}, Lmiui/accounts/ExtraAccountManager;->access$200(Lmiui/accounts/ExtraAccountManager;)Landroid/accounts/AccountManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/accounts/AccountManager;->getAccounts()[Landroid/accounts/Account;

    move-result-object v7

    .line 188
    .local v7, accounts:[Landroid/accounts/Account;
    iget-object v0, p0, Lmiui/accounts/ExtraAccountManager$3;->this$0:Lmiui/accounts/ExtraAccountManager;

    #getter for: Lmiui/accounts/ExtraAccountManager;->mMiuiAccountsUpdatedListeners:Ljava/util/HashMap;
    invoke-static {v0}, Lmiui/accounts/ExtraAccountManager;->access$000(Lmiui/accounts/ExtraAccountManager;)Ljava/util/HashMap;

    move-result-object v2

    monitor-enter v2

    .line 190
    :try_start_86
    iget-object v0, p0, Lmiui/accounts/ExtraAccountManager$3;->this$0:Lmiui/accounts/ExtraAccountManager;

    #getter for: Lmiui/accounts/ExtraAccountManager;->mMiuiAccountsUpdatedListeners:Ljava/util/HashMap;
    invoke-static {v0}, Lmiui/accounts/ExtraAccountManager;->access$000(Lmiui/accounts/ExtraAccountManager;)Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v10

    .restart local v10       #i$:Ljava/util/Iterator;
    :goto_94
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_b5

    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/Map$Entry;

    .line 191
    .restart local v9       #entry:Ljava/util/Map$Entry;,"Ljava/util/Map$Entry<Landroid/accounts/MiuiOnAccountsUpdateListener;Landroid/os/Handler;>;"
    iget-object v6, p0, Lmiui/accounts/ExtraAccountManager$3;->this$0:Lmiui/accounts/ExtraAccountManager;

    invoke-interface {v9}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/Handler;

    invoke-interface {v9}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/accounts/MiuiOnAccountsUpdateListener;

    #calls: Lmiui/accounts/ExtraAccountManager;->postToHandler(Landroid/os/Handler;Landroid/accounts/MiuiOnAccountsUpdateListener;[Landroid/accounts/Account;)V
    invoke-static {v6, v0, v1, v7}, Lmiui/accounts/ExtraAccountManager;->access$300(Lmiui/accounts/ExtraAccountManager;Landroid/os/Handler;Landroid/accounts/MiuiOnAccountsUpdateListener;[Landroid/accounts/Account;)V

    goto :goto_94

    .line 194
    .end local v9           #entry:Ljava/util/Map$Entry;,"Ljava/util/Map$Entry<Landroid/accounts/MiuiOnAccountsUpdateListener;Landroid/os/Handler;>;"
    .end local v10           #i$:Ljava/util/Iterator;
    :catchall_b2
    move-exception v0

    monitor-exit v2
    :try_end_b4
    .catchall {:try_start_86 .. :try_end_b4} :catchall_b2

    throw v0

    .restart local v10       #i$:Ljava/util/Iterator;
    :cond_b5
    :try_start_b5
    monitor-exit v2
    :try_end_b6
    .catchall {:try_start_b5 .. :try_end_b6} :catchall_b2

    goto :goto_6c
.end method
