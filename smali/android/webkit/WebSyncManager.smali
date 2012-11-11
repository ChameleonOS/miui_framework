.class abstract Landroid/webkit/WebSyncManager;
.super Ljava/lang/Object;
.source "WebSyncManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/webkit/WebSyncManager$1;,
        Landroid/webkit/WebSyncManager$SyncHandler;
    }
.end annotation


# static fields
.field protected static final LOGTAG:Ljava/lang/String; = "websync"

.field private static SYNC_LATER_INTERVAL:I = 0x0

.field private static final SYNC_MESSAGE:I = 0x65

.field private static SYNC_NOW_INTERVAL:I


# instance fields
.field protected mDataBase:Landroid/webkit/WebViewDatabase;

.field protected mHandler:Landroid/os/Handler;

.field private mStartSyncRefCount:I

.field private mSyncThread:Ljava/lang/Thread;

.field private mThreadName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    const/16 v0, 0x64

    sput v0, Landroid/webkit/WebSyncManager;->SYNC_NOW_INTERVAL:I

    const v0, 0x493e0

    sput v0, Landroid/webkit/WebSyncManager;->SYNC_LATER_INTERVAL:I

    return-void
.end method

.method protected constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .registers 5
    .parameter "context"
    .parameter "name"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p2, p0, Landroid/webkit/WebSyncManager;->mThreadName:Ljava/lang/String;

    if-eqz p1, :cond_1b

    new-instance v0, Ljava/lang/Thread;

    invoke-direct {v0, p0}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    iput-object v0, p0, Landroid/webkit/WebSyncManager;->mSyncThread:Ljava/lang/Thread;

    iget-object v0, p0, Landroid/webkit/WebSyncManager;->mSyncThread:Ljava/lang/Thread;

    iget-object v1, p0, Landroid/webkit/WebSyncManager;->mThreadName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/Thread;->setName(Ljava/lang/String;)V

    iget-object v0, p0, Landroid/webkit/WebSyncManager;->mSyncThread:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    return-void

    :cond_1b
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "WebSyncManager can\'t be created without context"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method static synthetic access$000()I
    .registers 1

    .prologue
    sget v0, Landroid/webkit/WebSyncManager;->SYNC_LATER_INTERVAL:I

    return v0
.end method


# virtual methods
.method protected clone()Ljava/lang/Object;
    .registers 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    new-instance v0, Ljava/lang/CloneNotSupportedException;

    const-string v1, "doesn\'t implement Cloneable"

    invoke-direct {v0, v1}, Ljava/lang/CloneNotSupportedException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method protected onSyncInit()V
    .registers 1

    .prologue
    return-void
.end method

.method public resetSync()V
    .registers 5

    .prologue
    const/16 v2, 0x65

    iget-object v1, p0, Landroid/webkit/WebSyncManager;->mHandler:Landroid/os/Handler;

    if-nez v1, :cond_7

    :goto_6
    return-void

    :cond_7
    iget-object v1, p0, Landroid/webkit/WebSyncManager;->mHandler:Landroid/os/Handler;

    invoke-virtual {v1, v2}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v1, p0, Landroid/webkit/WebSyncManager;->mHandler:Landroid/os/Handler;

    invoke-virtual {v1, v2}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    .local v0, msg:Landroid/os/Message;
    iget-object v1, p0, Landroid/webkit/WebSyncManager;->mHandler:Landroid/os/Handler;

    sget v2, Landroid/webkit/WebSyncManager;->SYNC_LATER_INTERVAL:I

    int-to-long v2, v2

    invoke-virtual {v1, v0, v2, v3}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    goto :goto_6
.end method

.method public run()V
    .registers 5

    .prologue
    invoke-static {}, Landroid/os/Looper;->prepare()V

    new-instance v1, Landroid/webkit/WebSyncManager$SyncHandler;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Landroid/webkit/WebSyncManager$SyncHandler;-><init>(Landroid/webkit/WebSyncManager;Landroid/webkit/WebSyncManager$1;)V

    iput-object v1, p0, Landroid/webkit/WebSyncManager;->mHandler:Landroid/os/Handler;

    invoke-virtual {p0}, Landroid/webkit/WebSyncManager;->onSyncInit()V

    const/16 v1, 0xa

    invoke-static {v1}, Landroid/os/Process;->setThreadPriority(I)V

    iget-object v1, p0, Landroid/webkit/WebSyncManager;->mHandler:Landroid/os/Handler;

    const/16 v2, 0x65

    invoke-virtual {v1, v2}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    .local v0, msg:Landroid/os/Message;
    iget-object v1, p0, Landroid/webkit/WebSyncManager;->mHandler:Landroid/os/Handler;

    sget v2, Landroid/webkit/WebSyncManager;->SYNC_LATER_INTERVAL:I

    int-to-long v2, v2

    invoke-virtual {v1, v0, v2, v3}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    invoke-static {}, Landroid/os/Looper;->loop()V

    return-void
.end method

.method public startSync()V
    .registers 5

    .prologue
    iget-object v1, p0, Landroid/webkit/WebSyncManager;->mHandler:Landroid/os/Handler;

    if-nez v1, :cond_5

    :cond_4
    :goto_4
    return-void

    :cond_5
    iget v1, p0, Landroid/webkit/WebSyncManager;->mStartSyncRefCount:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Landroid/webkit/WebSyncManager;->mStartSyncRefCount:I

    const/4 v2, 0x1

    if-ne v1, v2, :cond_4

    iget-object v1, p0, Landroid/webkit/WebSyncManager;->mHandler:Landroid/os/Handler;

    const/16 v2, 0x65

    invoke-virtual {v1, v2}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    .local v0, msg:Landroid/os/Message;
    iget-object v1, p0, Landroid/webkit/WebSyncManager;->mHandler:Landroid/os/Handler;

    sget v2, Landroid/webkit/WebSyncManager;->SYNC_LATER_INTERVAL:I

    int-to-long v2, v2

    invoke-virtual {v1, v0, v2, v3}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    goto :goto_4
.end method

.method public stopSync()V
    .registers 3

    .prologue
    iget-object v0, p0, Landroid/webkit/WebSyncManager;->mHandler:Landroid/os/Handler;

    if-nez v0, :cond_5

    :cond_4
    :goto_4
    return-void

    :cond_5
    iget v0, p0, Landroid/webkit/WebSyncManager;->mStartSyncRefCount:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Landroid/webkit/WebSyncManager;->mStartSyncRefCount:I

    if-nez v0, :cond_4

    iget-object v0, p0, Landroid/webkit/WebSyncManager;->mHandler:Landroid/os/Handler;

    const/16 v1, 0x65

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    goto :goto_4
.end method

.method public sync()V
    .registers 5

    .prologue
    const/16 v2, 0x65

    iget-object v1, p0, Landroid/webkit/WebSyncManager;->mHandler:Landroid/os/Handler;

    if-nez v1, :cond_7

    :goto_6
    return-void

    :cond_7
    iget-object v1, p0, Landroid/webkit/WebSyncManager;->mHandler:Landroid/os/Handler;

    invoke-virtual {v1, v2}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v1, p0, Landroid/webkit/WebSyncManager;->mHandler:Landroid/os/Handler;

    invoke-virtual {v1, v2}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    .local v0, msg:Landroid/os/Message;
    iget-object v1, p0, Landroid/webkit/WebSyncManager;->mHandler:Landroid/os/Handler;

    sget v2, Landroid/webkit/WebSyncManager;->SYNC_NOW_INTERVAL:I

    int-to-long v2, v2

    invoke-virtual {v1, v0, v2, v3}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    goto :goto_6
.end method

.method abstract syncFromRamToFlash()V
.end method
