.class Landroid/content/SyncManager$ActiveSyncContext;
.super Landroid/content/ISyncContext$Stub;
.source "SyncManager.java"

# interfaces
.implements Landroid/content/ServiceConnection;
.implements Landroid/os/IBinder$DeathRecipient;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/content/SyncManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ActiveSyncContext"
.end annotation


# instance fields
.field mBound:Z

.field final mHistoryRowId:J

.field mIsLinkedToDeath:Z

.field final mStartTime:J

.field mSyncAdapter:Landroid/content/ISyncAdapter;

.field final mSyncAdapterUid:I

.field mSyncInfo:Landroid/content/SyncInfo;

.field final mSyncOperation:Landroid/content/SyncOperation;

.field final mSyncWakeLock:Landroid/os/PowerManager$WakeLock;

.field mTimeoutStartTime:J

.field final synthetic this$0:Landroid/content/SyncManager;


# direct methods
.method public constructor <init>(Landroid/content/SyncManager;Landroid/content/SyncOperation;JI)V
    .registers 9
    .parameter
    .parameter "syncOperation"
    .parameter "historyRowId"
    .parameter "syncAdapterUid"

    .prologue
    iput-object p1, p0, Landroid/content/SyncManager$ActiveSyncContext;->this$0:Landroid/content/SyncManager;

    invoke-direct {p0}, Landroid/content/ISyncContext$Stub;-><init>()V

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/content/SyncManager$ActiveSyncContext;->mIsLinkedToDeath:Z

    iput p5, p0, Landroid/content/SyncManager$ActiveSyncContext;->mSyncAdapterUid:I

    iput-object p2, p0, Landroid/content/SyncManager$ActiveSyncContext;->mSyncOperation:Landroid/content/SyncOperation;

    iput-wide p3, p0, Landroid/content/SyncManager$ActiveSyncContext;->mHistoryRowId:J

    const/4 v0, 0x0

    iput-object v0, p0, Landroid/content/SyncManager$ActiveSyncContext;->mSyncAdapter:Landroid/content/ISyncAdapter;

    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v0

    iput-wide v0, p0, Landroid/content/SyncManager$ActiveSyncContext;->mStartTime:J

    iget-wide v0, p0, Landroid/content/SyncManager$ActiveSyncContext;->mStartTime:J

    iput-wide v0, p0, Landroid/content/SyncManager$ActiveSyncContext;->mTimeoutStartTime:J

    #getter for: Landroid/content/SyncManager;->mSyncHandler:Landroid/content/SyncManager$SyncHandler;
    invoke-static {p1}, Landroid/content/SyncManager;->access$200(Landroid/content/SyncManager;)Landroid/content/SyncManager$SyncHandler;

    move-result-object v0

    iget-object v1, p0, Landroid/content/SyncManager$ActiveSyncContext;->mSyncOperation:Landroid/content/SyncOperation;

    iget-object v1, v1, Landroid/content/SyncOperation;->account:Landroid/accounts/Account;

    iget-object v2, p0, Landroid/content/SyncManager$ActiveSyncContext;->mSyncOperation:Landroid/content/SyncOperation;

    iget-object v2, v2, Landroid/content/SyncOperation;->authority:Ljava/lang/String;

    #calls: Landroid/content/SyncManager$SyncHandler;->getSyncWakeLock(Landroid/accounts/Account;Ljava/lang/String;)Landroid/os/PowerManager$WakeLock;
    invoke-static {v0, v1, v2}, Landroid/content/SyncManager$SyncHandler;->access$1000(Landroid/content/SyncManager$SyncHandler;Landroid/accounts/Account;Ljava/lang/String;)Landroid/os/PowerManager$WakeLock;

    move-result-object v0

    iput-object v0, p0, Landroid/content/SyncManager$ActiveSyncContext;->mSyncWakeLock:Landroid/os/PowerManager$WakeLock;

    iget-object v0, p0, Landroid/content/SyncManager$ActiveSyncContext;->mSyncWakeLock:Landroid/os/PowerManager$WakeLock;

    new-instance v1, Landroid/os/WorkSource;

    invoke-direct {v1, p5}, Landroid/os/WorkSource;-><init>(I)V

    invoke-virtual {v0, v1}, Landroid/os/PowerManager$WakeLock;->setWorkSource(Landroid/os/WorkSource;)V

    iget-object v0, p0, Landroid/content/SyncManager$ActiveSyncContext;->mSyncWakeLock:Landroid/os/PowerManager$WakeLock;

    invoke-virtual {v0}, Landroid/os/PowerManager$WakeLock;->acquire()V

    return-void
.end method


# virtual methods
.method bindToSyncAdapter(Landroid/content/pm/RegisteredServicesCache$ServiceInfo;)Z
    .registers 9
    .parameter "info"

    .prologue
    const/4 v6, 0x0

    const-string v2, "SyncManager"

    const/4 v3, 0x2

    invoke-static {v2, v3}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v2

    if-eqz v2, :cond_2e

    const-string v2, "SyncManager"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "bindToSyncAdapter: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Landroid/content/pm/RegisteredServicesCache$ServiceInfo;->componentName:Landroid/content/ComponentName;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", connection "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_2e
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .local v1, intent:Landroid/content/Intent;
    const-string v2, "android.content.SyncAdapter"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    iget-object v2, p1, Landroid/content/pm/RegisteredServicesCache$ServiceInfo;->componentName:Landroid/content/ComponentName;

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;

    const-string v2, "android.intent.extra.client_label"

    const v3, 0x1040476

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    const-string v2, "android.intent.extra.client_intent"

    iget-object v3, p0, Landroid/content/SyncManager$ActiveSyncContext;->this$0:Landroid/content/SyncManager;

    #getter for: Landroid/content/SyncManager;->mContext:Landroid/content/Context;
    invoke-static {v3}, Landroid/content/SyncManager;->access$1200(Landroid/content/SyncManager;)Landroid/content/Context;

    move-result-object v3

    new-instance v4, Landroid/content/Intent;

    const-string v5, "android.settings.SYNC_SETTINGS"

    invoke-direct {v4, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-static {v3, v6, v4, v6}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    const/4 v2, 0x1

    iput-boolean v2, p0, Landroid/content/SyncManager$ActiveSyncContext;->mBound:Z

    iget-object v2, p0, Landroid/content/SyncManager$ActiveSyncContext;->this$0:Landroid/content/SyncManager;

    #getter for: Landroid/content/SyncManager;->mContext:Landroid/content/Context;
    invoke-static {v2}, Landroid/content/SyncManager;->access$1200(Landroid/content/SyncManager;)Landroid/content/Context;

    move-result-object v2

    const/16 v3, 0x15

    iget-object v4, p0, Landroid/content/SyncManager$ActiveSyncContext;->mSyncOperation:Landroid/content/SyncOperation;

    iget v4, v4, Landroid/content/SyncOperation;->userId:I

    invoke-virtual {v2, v1, p0, v3, v4}, Landroid/content/Context;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;II)Z

    move-result v0

    .local v0, bindResult:Z
    if-nez v0, :cond_72

    iput-boolean v6, p0, Landroid/content/SyncManager$ActiveSyncContext;->mBound:Z

    :cond_72
    return v0
.end method

.method public binderDied()V
    .registers 3

    .prologue
    iget-object v0, p0, Landroid/content/SyncManager$ActiveSyncContext;->this$0:Landroid/content/SyncManager;

    const/4 v1, 0x0

    #calls: Landroid/content/SyncManager;->sendSyncFinishedOrCanceledMessage(Landroid/content/SyncManager$ActiveSyncContext;Landroid/content/SyncResult;)V
    invoke-static {v0, p0, v1}, Landroid/content/SyncManager;->access$1100(Landroid/content/SyncManager;Landroid/content/SyncManager$ActiveSyncContext;Landroid/content/SyncResult;)V

    return-void
.end method

.method protected close()V
    .registers 4

    .prologue
    const-string v0, "SyncManager"

    const/4 v1, 0x2

    invoke-static {v0, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_22

    const-string v0, "SyncManager"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "unBindFromSyncAdapter: connection "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_22
    iget-boolean v0, p0, Landroid/content/SyncManager$ActiveSyncContext;->mBound:Z

    if-eqz v0, :cond_32

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/content/SyncManager$ActiveSyncContext;->mBound:Z

    iget-object v0, p0, Landroid/content/SyncManager$ActiveSyncContext;->this$0:Landroid/content/SyncManager;

    #getter for: Landroid/content/SyncManager;->mContext:Landroid/content/Context;
    invoke-static {v0}, Landroid/content/SyncManager;->access$1200(Landroid/content/SyncManager;)Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/content/Context;->unbindService(Landroid/content/ServiceConnection;)V

    :cond_32
    iget-object v0, p0, Landroid/content/SyncManager$ActiveSyncContext;->mSyncWakeLock:Landroid/os/PowerManager$WakeLock;

    invoke-virtual {v0}, Landroid/os/PowerManager$WakeLock;->release()V

    iget-object v0, p0, Landroid/content/SyncManager$ActiveSyncContext;->mSyncWakeLock:Landroid/os/PowerManager$WakeLock;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/PowerManager$WakeLock;->setWorkSource(Landroid/os/WorkSource;)V

    return-void
.end method

.method public onFinished(Landroid/content/SyncResult;)V
    .registers 5
    .parameter "result"

    .prologue
    const-string v0, "SyncManager"

    const/4 v1, 0x2

    invoke-static {v0, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_22

    const-string v0, "SyncManager"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "onFinished: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    :cond_22
    iget-object v0, p0, Landroid/content/SyncManager$ActiveSyncContext;->this$0:Landroid/content/SyncManager;

    #calls: Landroid/content/SyncManager;->sendSyncFinishedOrCanceledMessage(Landroid/content/SyncManager$ActiveSyncContext;Landroid/content/SyncResult;)V
    invoke-static {v0, p0, p1}, Landroid/content/SyncManager;->access$1100(Landroid/content/SyncManager;Landroid/content/SyncManager$ActiveSyncContext;Landroid/content/SyncResult;)V

    return-void
.end method

.method public onServiceConnected(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .registers 7
    .parameter "name"
    .parameter "service"

    .prologue
    iget-object v1, p0, Landroid/content/SyncManager$ActiveSyncContext;->this$0:Landroid/content/SyncManager;

    #getter for: Landroid/content/SyncManager;->mSyncHandler:Landroid/content/SyncManager$SyncHandler;
    invoke-static {v1}, Landroid/content/SyncManager;->access$200(Landroid/content/SyncManager;)Landroid/content/SyncManager$SyncHandler;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/SyncManager$SyncHandler;->obtainMessage()Landroid/os/Message;

    move-result-object v0

    .local v0, msg:Landroid/os/Message;
    const/4 v1, 0x4

    iput v1, v0, Landroid/os/Message;->what:I

    new-instance v1, Landroid/content/SyncManager$ServiceConnectionData;

    iget-object v2, p0, Landroid/content/SyncManager$ActiveSyncContext;->this$0:Landroid/content/SyncManager;

    invoke-static {p2}, Landroid/content/ISyncAdapter$Stub;->asInterface(Landroid/os/IBinder;)Landroid/content/ISyncAdapter;

    move-result-object v3

    invoke-direct {v1, v2, p0, v3}, Landroid/content/SyncManager$ServiceConnectionData;-><init>(Landroid/content/SyncManager;Landroid/content/SyncManager$ActiveSyncContext;Landroid/content/ISyncAdapter;)V

    iput-object v1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    iget-object v1, p0, Landroid/content/SyncManager$ActiveSyncContext;->this$0:Landroid/content/SyncManager;

    #getter for: Landroid/content/SyncManager;->mSyncHandler:Landroid/content/SyncManager$SyncHandler;
    invoke-static {v1}, Landroid/content/SyncManager;->access$200(Landroid/content/SyncManager;)Landroid/content/SyncManager$SyncHandler;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/SyncManager$SyncHandler;->sendMessage(Landroid/os/Message;)Z

    return-void
.end method

.method public onServiceDisconnected(Landroid/content/ComponentName;)V
    .registers 6
    .parameter "name"

    .prologue
    iget-object v1, p0, Landroid/content/SyncManager$ActiveSyncContext;->this$0:Landroid/content/SyncManager;

    #getter for: Landroid/content/SyncManager;->mSyncHandler:Landroid/content/SyncManager$SyncHandler;
    invoke-static {v1}, Landroid/content/SyncManager;->access$200(Landroid/content/SyncManager;)Landroid/content/SyncManager$SyncHandler;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/SyncManager$SyncHandler;->obtainMessage()Landroid/os/Message;

    move-result-object v0

    .local v0, msg:Landroid/os/Message;
    const/4 v1, 0x5

    iput v1, v0, Landroid/os/Message;->what:I

    new-instance v1, Landroid/content/SyncManager$ServiceConnectionData;

    iget-object v2, p0, Landroid/content/SyncManager$ActiveSyncContext;->this$0:Landroid/content/SyncManager;

    const/4 v3, 0x0

    invoke-direct {v1, v2, p0, v3}, Landroid/content/SyncManager$ServiceConnectionData;-><init>(Landroid/content/SyncManager;Landroid/content/SyncManager$ActiveSyncContext;Landroid/content/ISyncAdapter;)V

    iput-object v1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    iget-object v1, p0, Landroid/content/SyncManager$ActiveSyncContext;->this$0:Landroid/content/SyncManager;

    #getter for: Landroid/content/SyncManager;->mSyncHandler:Landroid/content/SyncManager$SyncHandler;
    invoke-static {v1}, Landroid/content/SyncManager;->access$200(Landroid/content/SyncManager;)Landroid/content/SyncManager$SyncHandler;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/SyncManager$SyncHandler;->sendMessage(Landroid/os/Message;)Z

    return-void
.end method

.method public sendHeartbeat()V
    .registers 1

    .prologue
    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    .prologue
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .local v0, sb:Ljava/lang/StringBuilder;
    invoke-virtual {p0, v0}, Landroid/content/SyncManager$ActiveSyncContext;->toString(Ljava/lang/StringBuilder;)V

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public toString(Ljava/lang/StringBuilder;)V
    .registers 5
    .parameter "sb"

    .prologue
    const-string/jumbo v0, "startTime "

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v1, p0, Landroid/content/SyncManager$ActiveSyncContext;->mStartTime:J

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mTimeoutStartTime "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v1, p0, Landroid/content/SyncManager$ActiveSyncContext;->mTimeoutStartTime:J

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mHistoryRowId "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v1, p0, Landroid/content/SyncManager$ActiveSyncContext;->mHistoryRowId:J

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", syncOperation "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Landroid/content/SyncManager$ActiveSyncContext;->mSyncOperation:Landroid/content/SyncOperation;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    return-void
.end method
