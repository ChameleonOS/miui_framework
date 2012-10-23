.class public abstract Lcom/android/internal/util/AsyncService;
.super Landroid/app/Service;
.source "AsyncService.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/internal/util/AsyncService$AsyncServiceInfo;
    }
.end annotation


# static fields
.field public static final CMD_ASYNC_SERVICE_DESTROY:I = 0x1000000

.field public static final CMD_ASYNC_SERVICE_ON_START_INTENT:I = 0xffffff

.field protected static final DBG:Z = true

.field private static final TAG:Ljava/lang/String; = "AsyncService"


# instance fields
.field mAsyncServiceInfo:Lcom/android/internal/util/AsyncService$AsyncServiceInfo;

.field mHandler:Landroid/os/Handler;

.field protected mMessenger:Landroid/os/Messenger;


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 35
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    .line 52
    return-void
.end method


# virtual methods
.method public abstract createHandler()Lcom/android/internal/util/AsyncService$AsyncServiceInfo;
.end method

.method public getHandler()Landroid/os/Handler;
    .registers 2

    .prologue
    .line 76
    iget-object v0, p0, Lcom/android/internal/util/AsyncService;->mHandler:Landroid/os/Handler;

    return-object v0
.end method

.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .registers 3
    .parameter "intent"

    .prologue
    .line 126
    iget-object v0, p0, Lcom/android/internal/util/AsyncService;->mMessenger:Landroid/os/Messenger;

    invoke-virtual {v0}, Landroid/os/Messenger;->getBinder()Landroid/os/IBinder;

    move-result-object v0

    return-object v0
.end method

.method public onCreate()V
    .registers 3

    .prologue
    .line 84
    invoke-super {p0}, Landroid/app/Service;->onCreate()V

    .line 85
    invoke-virtual {p0}, Lcom/android/internal/util/AsyncService;->createHandler()Lcom/android/internal/util/AsyncService$AsyncServiceInfo;

    move-result-object v0

    iput-object v0, p0, Lcom/android/internal/util/AsyncService;->mAsyncServiceInfo:Lcom/android/internal/util/AsyncService$AsyncServiceInfo;

    .line 86
    iget-object v0, p0, Lcom/android/internal/util/AsyncService;->mAsyncServiceInfo:Lcom/android/internal/util/AsyncService$AsyncServiceInfo;

    iget-object v0, v0, Lcom/android/internal/util/AsyncService$AsyncServiceInfo;->mHandler:Landroid/os/Handler;

    iput-object v0, p0, Lcom/android/internal/util/AsyncService;->mHandler:Landroid/os/Handler;

    .line 87
    new-instance v0, Landroid/os/Messenger;

    iget-object v1, p0, Lcom/android/internal/util/AsyncService;->mHandler:Landroid/os/Handler;

    invoke-direct {v0, v1}, Landroid/os/Messenger;-><init>(Landroid/os/Handler;)V

    iput-object v0, p0, Lcom/android/internal/util/AsyncService;->mMessenger:Landroid/os/Messenger;

    .line 88
    return-void
.end method

.method public onDestroy()V
    .registers 4

    .prologue
    .line 114
    const-string v1, "AsyncService"

    const-string/jumbo v2, "onDestroy"

    invoke-static {v1, v2}, Landroid/util/Slog;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 116
    iget-object v1, p0, Lcom/android/internal/util/AsyncService;->mHandler:Landroid/os/Handler;

    invoke-virtual {v1}, Landroid/os/Handler;->obtainMessage()Landroid/os/Message;

    move-result-object v0

    .line 117
    .local v0, msg:Landroid/os/Message;
    const/high16 v1, 0x100

    iput v1, v0, Landroid/os/Message;->what:I

    .line 118
    iget-object v1, p0, Lcom/android/internal/util/AsyncService;->mHandler:Landroid/os/Handler;

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 119
    return-void
.end method

.method public onStartCommand(Landroid/content/Intent;II)I
    .registers 7
    .parameter "intent"
    .parameter "flags"
    .parameter "startId"

    .prologue
    .line 95
    const-string v1, "AsyncService"

    const-string/jumbo v2, "onStartCommand"

    invoke-static {v1, v2}, Landroid/util/Slog;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 97
    iget-object v1, p0, Lcom/android/internal/util/AsyncService;->mHandler:Landroid/os/Handler;

    invoke-virtual {v1}, Landroid/os/Handler;->obtainMessage()Landroid/os/Message;

    move-result-object v0

    .line 98
    .local v0, msg:Landroid/os/Message;
    const v1, 0xffffff

    iput v1, v0, Landroid/os/Message;->what:I

    .line 99
    iput p2, v0, Landroid/os/Message;->arg1:I

    .line 100
    iput p3, v0, Landroid/os/Message;->arg2:I

    .line 101
    iput-object p1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 102
    iget-object v1, p0, Lcom/android/internal/util/AsyncService;->mHandler:Landroid/os/Handler;

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 104
    iget-object v1, p0, Lcom/android/internal/util/AsyncService;->mAsyncServiceInfo:Lcom/android/internal/util/AsyncService$AsyncServiceInfo;

    iget v1, v1, Lcom/android/internal/util/AsyncService$AsyncServiceInfo;->mRestartFlags:I

    return v1
.end method
