.class Landroid/net/nsd/NsdManager$ServiceHandler;
.super Landroid/os/Handler;
.source "NsdManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/nsd/NsdManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ServiceHandler"
.end annotation


# instance fields
.field final synthetic this$0:Landroid/net/nsd/NsdManager;


# direct methods
.method constructor <init>(Landroid/net/nsd/NsdManager;Landroid/os/Looper;)V
    .registers 3
    .parameter
    .parameter "looper"

    .prologue
    iput-object p1, p0, Landroid/net/nsd/NsdManager$ServiceHandler;->this$0:Landroid/net/nsd/NsdManager;

    invoke-direct {p0, p2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .registers 8
    .parameter "message"

    .prologue
    iget-object v3, p0, Landroid/net/nsd/NsdManager$ServiceHandler;->this$0:Landroid/net/nsd/NsdManager;

    iget v4, p1, Landroid/os/Message;->arg2:I

    #calls: Landroid/net/nsd/NsdManager;->getListener(I)Ljava/lang/Object;
    invoke-static {v3, v4}, Landroid/net/nsd/NsdManager;->access$000(Landroid/net/nsd/NsdManager;I)Ljava/lang/Object;

    move-result-object v0

    .local v0, listener:Ljava/lang/Object;
    const/4 v1, 0x1

    .local v1, listenerRemove:Z
    iget v3, p1, Landroid/os/Message;->what:I

    sparse-switch v3, :sswitch_data_108

    const-string v3, "NsdManager"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Ignored "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .end local v0           #listener:Ljava/lang/Object;
    :goto_26
    :sswitch_26
    if-eqz v1, :cond_2f

    iget-object v3, p0, Landroid/net/nsd/NsdManager$ServiceHandler;->this$0:Landroid/net/nsd/NsdManager;

    iget v4, p1, Landroid/os/Message;->arg2:I

    #calls: Landroid/net/nsd/NsdManager;->removeListener(I)V
    invoke-static {v3, v4}, Landroid/net/nsd/NsdManager;->access$400(Landroid/net/nsd/NsdManager;I)V

    :cond_2f
    return-void

    .restart local v0       #listener:Ljava/lang/Object;
    :sswitch_30
    iget-object v3, p0, Landroid/net/nsd/NsdManager$ServiceHandler;->this$0:Landroid/net/nsd/NsdManager;

    #getter for: Landroid/net/nsd/NsdManager;->mAsyncChannel:Lcom/android/internal/util/AsyncChannel;
    invoke-static {v3}, Landroid/net/nsd/NsdManager;->access$100(Landroid/net/nsd/NsdManager;)Lcom/android/internal/util/AsyncChannel;

    move-result-object v3

    const v4, 0x11001

    invoke-virtual {v3, v4}, Lcom/android/internal/util/AsyncChannel;->sendMessage(I)V

    iget-object v3, p0, Landroid/net/nsd/NsdManager$ServiceHandler;->this$0:Landroid/net/nsd/NsdManager;

    #getter for: Landroid/net/nsd/NsdManager;->mConnected:Ljava/util/concurrent/CountDownLatch;
    invoke-static {v3}, Landroid/net/nsd/NsdManager;->access$200(Landroid/net/nsd/NsdManager;)Ljava/util/concurrent/CountDownLatch;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    goto :goto_26

    :sswitch_46
    const-string v3, "NsdManager"

    const-string v4, "Channel lost"

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_26

    :sswitch_4e
    iget-object v3, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v3, Landroid/net/nsd/NsdServiceInfo;

    invoke-virtual {v3}, Landroid/net/nsd/NsdServiceInfo;->getServiceType()Ljava/lang/String;

    move-result-object v2

    .local v2, s:Ljava/lang/String;
    check-cast v0, Landroid/net/nsd/NsdManager$DiscoveryListener;

    .end local v0           #listener:Ljava/lang/Object;
    invoke-interface {v0, v2}, Landroid/net/nsd/NsdManager$DiscoveryListener;->onDiscoveryStarted(Ljava/lang/String;)V

    const/4 v1, 0x0

    goto :goto_26

    .end local v2           #s:Ljava/lang/String;
    .restart local v0       #listener:Ljava/lang/Object;
    :sswitch_5d
    check-cast v0, Landroid/net/nsd/NsdManager$DiscoveryListener;

    .end local v0           #listener:Ljava/lang/Object;
    iget-object v3, p0, Landroid/net/nsd/NsdManager$ServiceHandler;->this$0:Landroid/net/nsd/NsdManager;

    iget v4, p1, Landroid/os/Message;->arg2:I

    #calls: Landroid/net/nsd/NsdManager;->getNsdService(I)Landroid/net/nsd/NsdServiceInfo;
    invoke-static {v3, v4}, Landroid/net/nsd/NsdManager;->access$300(Landroid/net/nsd/NsdManager;I)Landroid/net/nsd/NsdServiceInfo;

    move-result-object v3

    invoke-virtual {v3}, Landroid/net/nsd/NsdServiceInfo;->getServiceType()Ljava/lang/String;

    move-result-object v3

    iget v4, p1, Landroid/os/Message;->arg1:I

    invoke-interface {v0, v3, v4}, Landroid/net/nsd/NsdManager$DiscoveryListener;->onStartDiscoveryFailed(Ljava/lang/String;I)V

    goto :goto_26

    .restart local v0       #listener:Ljava/lang/Object;
    :sswitch_71
    check-cast v0, Landroid/net/nsd/NsdManager$DiscoveryListener;

    .end local v0           #listener:Ljava/lang/Object;
    iget-object v3, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v3, Landroid/net/nsd/NsdServiceInfo;

    invoke-interface {v0, v3}, Landroid/net/nsd/NsdManager$DiscoveryListener;->onServiceFound(Landroid/net/nsd/NsdServiceInfo;)V

    const/4 v1, 0x0

    goto :goto_26

    .restart local v0       #listener:Ljava/lang/Object;
    :sswitch_7c
    check-cast v0, Landroid/net/nsd/NsdManager$DiscoveryListener;

    .end local v0           #listener:Ljava/lang/Object;
    iget-object v3, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v3, Landroid/net/nsd/NsdServiceInfo;

    invoke-interface {v0, v3}, Landroid/net/nsd/NsdManager$DiscoveryListener;->onServiceLost(Landroid/net/nsd/NsdServiceInfo;)V

    const/4 v1, 0x0

    goto :goto_26

    .restart local v0       #listener:Ljava/lang/Object;
    :sswitch_87
    check-cast v0, Landroid/net/nsd/NsdManager$DiscoveryListener;

    .end local v0           #listener:Ljava/lang/Object;
    iget-object v3, p0, Landroid/net/nsd/NsdManager$ServiceHandler;->this$0:Landroid/net/nsd/NsdManager;

    iget v4, p1, Landroid/os/Message;->arg2:I

    #calls: Landroid/net/nsd/NsdManager;->getNsdService(I)Landroid/net/nsd/NsdServiceInfo;
    invoke-static {v3, v4}, Landroid/net/nsd/NsdManager;->access$300(Landroid/net/nsd/NsdManager;I)Landroid/net/nsd/NsdServiceInfo;

    move-result-object v3

    invoke-virtual {v3}, Landroid/net/nsd/NsdServiceInfo;->getServiceType()Ljava/lang/String;

    move-result-object v3

    iget v4, p1, Landroid/os/Message;->arg1:I

    invoke-interface {v0, v3, v4}, Landroid/net/nsd/NsdManager$DiscoveryListener;->onStopDiscoveryFailed(Ljava/lang/String;I)V

    goto :goto_26

    .restart local v0       #listener:Ljava/lang/Object;
    :sswitch_9b
    check-cast v0, Landroid/net/nsd/NsdManager$DiscoveryListener;

    .end local v0           #listener:Ljava/lang/Object;
    iget-object v3, p0, Landroid/net/nsd/NsdManager$ServiceHandler;->this$0:Landroid/net/nsd/NsdManager;

    iget v4, p1, Landroid/os/Message;->arg2:I

    #calls: Landroid/net/nsd/NsdManager;->getNsdService(I)Landroid/net/nsd/NsdServiceInfo;
    invoke-static {v3, v4}, Landroid/net/nsd/NsdManager;->access$300(Landroid/net/nsd/NsdManager;I)Landroid/net/nsd/NsdServiceInfo;

    move-result-object v3

    invoke-virtual {v3}, Landroid/net/nsd/NsdServiceInfo;->getServiceType()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v3}, Landroid/net/nsd/NsdManager$DiscoveryListener;->onDiscoveryStopped(Ljava/lang/String;)V

    goto/16 :goto_26

    .restart local v0       #listener:Ljava/lang/Object;
    :sswitch_ae
    check-cast v0, Landroid/net/nsd/NsdManager$RegistrationListener;

    .end local v0           #listener:Ljava/lang/Object;
    iget-object v3, p0, Landroid/net/nsd/NsdManager$ServiceHandler;->this$0:Landroid/net/nsd/NsdManager;

    iget v4, p1, Landroid/os/Message;->arg2:I

    #calls: Landroid/net/nsd/NsdManager;->getNsdService(I)Landroid/net/nsd/NsdServiceInfo;
    invoke-static {v3, v4}, Landroid/net/nsd/NsdManager;->access$300(Landroid/net/nsd/NsdManager;I)Landroid/net/nsd/NsdServiceInfo;

    move-result-object v3

    iget v4, p1, Landroid/os/Message;->arg1:I

    invoke-interface {v0, v3, v4}, Landroid/net/nsd/NsdManager$RegistrationListener;->onRegistrationFailed(Landroid/net/nsd/NsdServiceInfo;I)V

    goto/16 :goto_26

    .restart local v0       #listener:Ljava/lang/Object;
    :sswitch_bf
    check-cast v0, Landroid/net/nsd/NsdManager$RegistrationListener;

    .end local v0           #listener:Ljava/lang/Object;
    iget-object v3, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v3, Landroid/net/nsd/NsdServiceInfo;

    invoke-interface {v0, v3}, Landroid/net/nsd/NsdManager$RegistrationListener;->onServiceRegistered(Landroid/net/nsd/NsdServiceInfo;)V

    const/4 v1, 0x0

    goto/16 :goto_26

    .restart local v0       #listener:Ljava/lang/Object;
    :sswitch_cb
    check-cast v0, Landroid/net/nsd/NsdManager$RegistrationListener;

    .end local v0           #listener:Ljava/lang/Object;
    iget-object v3, p0, Landroid/net/nsd/NsdManager$ServiceHandler;->this$0:Landroid/net/nsd/NsdManager;

    iget v4, p1, Landroid/os/Message;->arg2:I

    #calls: Landroid/net/nsd/NsdManager;->getNsdService(I)Landroid/net/nsd/NsdServiceInfo;
    invoke-static {v3, v4}, Landroid/net/nsd/NsdManager;->access$300(Landroid/net/nsd/NsdManager;I)Landroid/net/nsd/NsdServiceInfo;

    move-result-object v3

    iget v4, p1, Landroid/os/Message;->arg1:I

    invoke-interface {v0, v3, v4}, Landroid/net/nsd/NsdManager$RegistrationListener;->onUnregistrationFailed(Landroid/net/nsd/NsdServiceInfo;I)V

    goto/16 :goto_26

    .restart local v0       #listener:Ljava/lang/Object;
    :sswitch_dc
    check-cast v0, Landroid/net/nsd/NsdManager$RegistrationListener;

    .end local v0           #listener:Ljava/lang/Object;
    iget-object v3, p0, Landroid/net/nsd/NsdManager$ServiceHandler;->this$0:Landroid/net/nsd/NsdManager;

    iget v4, p1, Landroid/os/Message;->arg2:I

    #calls: Landroid/net/nsd/NsdManager;->getNsdService(I)Landroid/net/nsd/NsdServiceInfo;
    invoke-static {v3, v4}, Landroid/net/nsd/NsdManager;->access$300(Landroid/net/nsd/NsdManager;I)Landroid/net/nsd/NsdServiceInfo;

    move-result-object v3

    invoke-interface {v0, v3}, Landroid/net/nsd/NsdManager$RegistrationListener;->onServiceUnregistered(Landroid/net/nsd/NsdServiceInfo;)V

    goto/16 :goto_26

    .restart local v0       #listener:Ljava/lang/Object;
    :sswitch_eb
    check-cast v0, Landroid/net/nsd/NsdManager$ResolveListener;

    .end local v0           #listener:Ljava/lang/Object;
    iget-object v3, p0, Landroid/net/nsd/NsdManager$ServiceHandler;->this$0:Landroid/net/nsd/NsdManager;

    iget v4, p1, Landroid/os/Message;->arg2:I

    #calls: Landroid/net/nsd/NsdManager;->getNsdService(I)Landroid/net/nsd/NsdServiceInfo;
    invoke-static {v3, v4}, Landroid/net/nsd/NsdManager;->access$300(Landroid/net/nsd/NsdManager;I)Landroid/net/nsd/NsdServiceInfo;

    move-result-object v3

    iget v4, p1, Landroid/os/Message;->arg1:I

    invoke-interface {v0, v3, v4}, Landroid/net/nsd/NsdManager$ResolveListener;->onResolveFailed(Landroid/net/nsd/NsdServiceInfo;I)V

    goto/16 :goto_26

    .restart local v0       #listener:Ljava/lang/Object;
    :sswitch_fc
    check-cast v0, Landroid/net/nsd/NsdManager$ResolveListener;

    .end local v0           #listener:Ljava/lang/Object;
    iget-object v3, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v3, Landroid/net/nsd/NsdServiceInfo;

    invoke-interface {v0, v3}, Landroid/net/nsd/NsdManager$ResolveListener;->onServiceResolved(Landroid/net/nsd/NsdServiceInfo;)V

    goto/16 :goto_26

    nop

    :sswitch_data_108
    .sparse-switch
        0x11000 -> :sswitch_30
        0x11002 -> :sswitch_26
        0x11004 -> :sswitch_46
        0x60002 -> :sswitch_4e
        0x60003 -> :sswitch_5d
        0x60004 -> :sswitch_71
        0x60005 -> :sswitch_7c
        0x60007 -> :sswitch_87
        0x60008 -> :sswitch_9b
        0x6000a -> :sswitch_ae
        0x6000b -> :sswitch_bf
        0x6000d -> :sswitch_cb
        0x6000e -> :sswitch_dc
        0x60013 -> :sswitch_eb
        0x60014 -> :sswitch_fc
    .end sparse-switch
.end method
