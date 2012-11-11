.class Landroid/content/SyncManager$1;
.super Landroid/content/BroadcastReceiver;
.source "SyncManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/content/SyncManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/content/SyncManager;


# direct methods
.method constructor <init>(Landroid/content/SyncManager;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Landroid/content/SyncManager$1;->this$0:Landroid/content/SyncManager;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .registers 7
    .parameter "context"
    .parameter "intent"

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x2

    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .local v0, action:Ljava/lang/String;
    const-string v1, "android.intent.action.DEVICE_STORAGE_LOW"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2a

    const-string v1, "SyncManager"

    invoke-static {v1, v2}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v1

    if-eqz v1, :cond_1d

    const-string v1, "SyncManager"

    const-string v2, "Internal storage is low."

    invoke-static {v1, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    :cond_1d
    iget-object v1, p0, Landroid/content/SyncManager$1;->this$0:Landroid/content/SyncManager;

    const/4 v2, 0x1

    #setter for: Landroid/content/SyncManager;->mStorageIsLow:Z
    invoke-static {v1, v2}, Landroid/content/SyncManager;->access$002(Landroid/content/SyncManager;Z)Z

    iget-object v1, p0, Landroid/content/SyncManager$1;->this$0:Landroid/content/SyncManager;

    const/4 v2, -0x1

    invoke-virtual {v1, v3, v2, v3}, Landroid/content/SyncManager;->cancelActiveSync(Landroid/accounts/Account;ILjava/lang/String;)V

    :cond_29
    :goto_29
    return-void

    :cond_2a
    const-string v1, "android.intent.action.DEVICE_STORAGE_OK"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_29

    const-string v1, "SyncManager"

    invoke-static {v1, v2}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v1

    if-eqz v1, :cond_41

    const-string v1, "SyncManager"

    const-string v2, "Internal storage is ok."

    invoke-static {v1, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    :cond_41
    iget-object v1, p0, Landroid/content/SyncManager$1;->this$0:Landroid/content/SyncManager;

    const/4 v2, 0x0

    #setter for: Landroid/content/SyncManager;->mStorageIsLow:Z
    invoke-static {v1, v2}, Landroid/content/SyncManager;->access$002(Landroid/content/SyncManager;Z)Z

    iget-object v1, p0, Landroid/content/SyncManager$1;->this$0:Landroid/content/SyncManager;

    #calls: Landroid/content/SyncManager;->sendCheckAlarmsMessage()V
    invoke-static {v1}, Landroid/content/SyncManager;->access$100(Landroid/content/SyncManager;)V

    goto :goto_29
.end method
