.class Landroid/os/storage/StorageManager$ListenerDelegate$1;
.super Landroid/os/Handler;
.source "StorageManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/os/storage/StorageManager$ListenerDelegate;-><init>(Landroid/os/storage/StorageManager;Landroid/os/storage/StorageEventListener;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Landroid/os/storage/StorageManager$ListenerDelegate;

.field final synthetic val$this$0:Landroid/os/storage/StorageManager;


# direct methods
.method constructor <init>(Landroid/os/storage/StorageManager$ListenerDelegate;Landroid/os/Looper;Landroid/os/storage/StorageManager;)V
    .registers 4
    .parameter
    .parameter "x0"
    .parameter

    .prologue
    .line 255
    iput-object p1, p0, Landroid/os/storage/StorageManager$ListenerDelegate$1;->this$1:Landroid/os/storage/StorageManager$ListenerDelegate;

    iput-object p3, p0, Landroid/os/storage/StorageManager$ListenerDelegate$1;->val$this$0:Landroid/os/storage/StorageManager;

    invoke-direct {p0, p2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .registers 8
    .parameter "msg"

    .prologue
    .line 258
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Landroid/os/storage/StorageManager$StorageEvent;

    .line 260
    .local v0, e:Landroid/os/storage/StorageManager$StorageEvent;
    iget v2, p1, Landroid/os/Message;->what:I

    const/4 v3, 0x1

    if-ne v2, v3, :cond_16

    move-object v1, v0

    .line 261
    check-cast v1, Landroid/os/storage/StorageManager$UmsConnectionChangedStorageEvent;

    .line 262
    .local v1, ev:Landroid/os/storage/StorageManager$UmsConnectionChangedStorageEvent;
    iget-object v2, p0, Landroid/os/storage/StorageManager$ListenerDelegate$1;->this$1:Landroid/os/storage/StorageManager$ListenerDelegate;

    iget-object v2, v2, Landroid/os/storage/StorageManager$ListenerDelegate;->mStorageEventListener:Landroid/os/storage/StorageEventListener;

    iget-boolean v3, v1, Landroid/os/storage/StorageManager$UmsConnectionChangedStorageEvent;->available:Z

    invoke-virtual {v2, v3}, Landroid/os/storage/StorageEventListener;->onUsbMassStorageConnectionChanged(Z)V

    .line 269
    .end local v1           #ev:Landroid/os/storage/StorageManager$UmsConnectionChangedStorageEvent;
    :goto_15
    return-void

    .line 263
    :cond_16
    iget v2, p1, Landroid/os/Message;->what:I

    const/4 v3, 0x2

    if-ne v2, v3, :cond_2c

    move-object v1, v0

    .line 264
    check-cast v1, Landroid/os/storage/StorageManager$StorageStateChangedStorageEvent;

    .line 265
    .local v1, ev:Landroid/os/storage/StorageManager$StorageStateChangedStorageEvent;
    iget-object v2, p0, Landroid/os/storage/StorageManager$ListenerDelegate$1;->this$1:Landroid/os/storage/StorageManager$ListenerDelegate;

    iget-object v2, v2, Landroid/os/storage/StorageManager$ListenerDelegate;->mStorageEventListener:Landroid/os/storage/StorageEventListener;

    iget-object v3, v1, Landroid/os/storage/StorageManager$StorageStateChangedStorageEvent;->path:Ljava/lang/String;

    iget-object v4, v1, Landroid/os/storage/StorageManager$StorageStateChangedStorageEvent;->oldState:Ljava/lang/String;

    iget-object v5, v1, Landroid/os/storage/StorageManager$StorageStateChangedStorageEvent;->newState:Ljava/lang/String;

    invoke-virtual {v2, v3, v4, v5}, Landroid/os/storage/StorageEventListener;->onStorageStateChanged(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_15

    .line 267
    .end local v1           #ev:Landroid/os/storage/StorageManager$StorageStateChangedStorageEvent;
    :cond_2c
    const-string v2, "StorageManager"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unsupported event "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget v4, p1, Landroid/os/Message;->what:I

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_15
.end method
