.class Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;
.super Lcom/android/internal/util/State;
.source "WifiP2pService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "P2pEnabledState"
.end annotation


# instance fields
.field final synthetic this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;


# direct methods
.method constructor <init>(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    invoke-direct {p0}, Lcom/android/internal/util/State;-><init>()V

    return-void
.end method


# virtual methods
.method public enter()V
    .registers 3

    .prologue
    const/4 v1, 0x1

    iget-object v0, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->sendP2pStateChangedBroadcast(Z)V
    invoke-static {v0, v1}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$2200(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;Z)V

    iget-object v0, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    iget-object v0, v0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->this$0:Landroid/net/wifi/p2p/WifiP2pService;

    #getter for: Landroid/net/wifi/p2p/WifiP2pService;->mNetworkInfo:Landroid/net/NetworkInfo;
    invoke-static {v0}, Landroid/net/wifi/p2p/WifiP2pService;->access$2300(Landroid/net/wifi/p2p/WifiP2pService;)Landroid/net/NetworkInfo;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/net/NetworkInfo;->setIsAvailable(Z)V

    iget-object v0, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->sendP2pConnectionChangedBroadcast()V
    invoke-static {v0}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$2400(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;)V

    iget-object v0, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->initializeP2pSettings()V
    invoke-static {v0}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$2500(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;)V

    return-void
.end method

.method public exit()V
    .registers 3

    .prologue
    const/4 v1, 0x0

    iget-object v0, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->sendP2pStateChangedBroadcast(Z)V
    invoke-static {v0, v1}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$2200(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;Z)V

    iget-object v0, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    iget-object v0, v0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->this$0:Landroid/net/wifi/p2p/WifiP2pService;

    #getter for: Landroid/net/wifi/p2p/WifiP2pService;->mNetworkInfo:Landroid/net/NetworkInfo;
    invoke-static {v0}, Landroid/net/wifi/p2p/WifiP2pService;->access$2300(Landroid/net/wifi/p2p/WifiP2pService;)Landroid/net/NetworkInfo;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/net/NetworkInfo;->setIsAvailable(Z)V

    return-void
.end method

.method public processMessage(Landroid/os/Message;)Z
    .registers 14
    .parameter "message"

    .prologue
    const v11, 0x2202f

    const/16 v10, 0x78

    const/4 v8, 0x1

    const/4 v7, 0x0

    iget v9, p1, Landroid/os/Message;->what:I

    sparse-switch v9, :sswitch_data_1c8

    :goto_c
    return v7

    :sswitch_d
    iget-object v7, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    #getter for: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->mPeers:Landroid/net/wifi/p2p/WifiP2pDeviceList;
    invoke-static {v7}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$500(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;)Landroid/net/wifi/p2p/WifiP2pDeviceList;

    move-result-object v7

    invoke-virtual {v7}, Landroid/net/wifi/p2p/WifiP2pDeviceList;->clear()Z

    move-result v7

    if-eqz v7, :cond_1e

    iget-object v7, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->sendP2pPeersChangedBroadcast()V
    invoke-static {v7}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$2600(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;)V

    :cond_1e
    iget-object v7, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    #getter for: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->mWifiNative:Landroid/net/wifi/WifiNative;
    invoke-static {v7}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$1100(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;)Landroid/net/wifi/WifiNative;

    move-result-object v7

    invoke-virtual {v7}, Landroid/net/wifi/WifiNative;->closeSupplicantConnection()V

    iget-object v7, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    iget-object v9, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    #getter for: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->mP2pDisablingState:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pDisablingState;
    invoke-static {v9}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$2700(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;)Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pDisablingState;

    move-result-object v9

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->transitionTo(Lcom/android/internal/util/IState;)V
    invoke-static {v7, v9}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$2800(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;Lcom/android/internal/util/IState;)V

    :cond_32
    :goto_32
    :sswitch_32
    move v7, v8

    goto :goto_c

    :sswitch_34
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Landroid/net/wifi/p2p/WifiP2pDevice;

    .local v0, d:Landroid/net/wifi/p2p/WifiP2pDevice;
    if-eqz v0, :cond_4d

    iget-object v9, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    iget-object v10, v0, Landroid/net/wifi/p2p/WifiP2pDevice;->deviceName:Ljava/lang/String;

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->setAndPersistDeviceName(Ljava/lang/String;)Z
    invoke-static {v9, v10}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$2900(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_4d

    iget-object v7, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    const v9, 0x22035

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->replyToMessage(Landroid/os/Message;I)V
    invoke-static {v7, p1, v9}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$1000(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;Landroid/os/Message;I)V

    goto :goto_32

    :cond_4d
    iget-object v9, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    const v10, 0x22034

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->replyToMessage(Landroid/os/Message;II)V
    invoke-static {v9, p1, v10, v7}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$400(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;Landroid/os/Message;II)V

    goto :goto_32

    .end local v0           #d:Landroid/net/wifi/p2p/WifiP2pDevice;
    :sswitch_56
    iget-object v9, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->clearSupplicantServiceRequest()V
    invoke-static {v9}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$3000(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;)V

    iget-object v9, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    #getter for: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->mWifiNative:Landroid/net/wifi/WifiNative;
    invoke-static {v9}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$1100(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;)Landroid/net/wifi/WifiNative;

    move-result-object v9

    invoke-virtual {v9, v10}, Landroid/net/wifi/WifiNative;->p2pFind(I)Z

    move-result v9

    if-eqz v9, :cond_75

    iget-object v7, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    const v9, 0x22003

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->replyToMessage(Landroid/os/Message;I)V
    invoke-static {v7, p1, v9}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$1000(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;Landroid/os/Message;I)V

    iget-object v7, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->sendP2pDiscoveryChangedBroadcast(Z)V
    invoke-static {v7, v8}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$3100(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;Z)V

    goto :goto_32

    :cond_75
    iget-object v9, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    const v10, 0x22002

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->replyToMessage(Landroid/os/Message;II)V
    invoke-static {v9, p1, v10, v7}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$400(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;Landroid/os/Message;II)V

    goto :goto_32

    :sswitch_7e
    iget-object v9, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->sendP2pDiscoveryChangedBroadcast(Z)V
    invoke-static {v9, v7}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$3100(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;Z)V

    goto :goto_32

    :sswitch_84
    iget-object v9, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    #getter for: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->mWifiNative:Landroid/net/wifi/WifiNative;
    invoke-static {v9}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$1100(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;)Landroid/net/wifi/WifiNative;

    move-result-object v9

    invoke-virtual {v9}, Landroid/net/wifi/WifiNative;->p2pStopFind()Z

    move-result v9

    if-eqz v9, :cond_99

    iget-object v7, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    const v9, 0x22006

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->replyToMessage(Landroid/os/Message;I)V
    invoke-static {v7, p1, v9}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$1000(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;Landroid/os/Message;I)V

    goto :goto_32

    :cond_99
    iget-object v9, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    const v10, 0x22005

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->replyToMessage(Landroid/os/Message;II)V
    invoke-static {v9, p1, v10, v7}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$400(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;Landroid/os/Message;II)V

    goto :goto_32

    :sswitch_a2
    iget-object v9, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->updateSupplicantServiceRequest()Z
    invoke-static {v9}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$3200(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;)Z

    move-result v9

    if-nez v9, :cond_b1

    iget-object v7, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    const/4 v9, 0x3

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->replyToMessage(Landroid/os/Message;II)V
    invoke-static {v7, p1, v11, v9}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$400(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;Landroid/os/Message;II)V

    goto :goto_32

    :cond_b1
    iget-object v9, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    #getter for: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->mWifiNative:Landroid/net/wifi/WifiNative;
    invoke-static {v9}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$1100(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;)Landroid/net/wifi/WifiNative;

    move-result-object v9

    invoke-virtual {v9, v10}, Landroid/net/wifi/WifiNative;->p2pFind(I)Z

    move-result v9

    if-eqz v9, :cond_c7

    iget-object v7, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    const v9, 0x22030

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->replyToMessage(Landroid/os/Message;I)V
    invoke-static {v7, p1, v9}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$1000(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;Landroid/os/Message;I)V

    goto/16 :goto_32

    :cond_c7
    iget-object v9, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->replyToMessage(Landroid/os/Message;II)V
    invoke-static {v9, p1, v11, v7}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$400(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;Landroid/os/Message;II)V

    goto/16 :goto_32

    :sswitch_ce
    iget-object v2, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v2, Landroid/net/wifi/p2p/WifiP2pDevice;

    .local v2, device:Landroid/net/wifi/p2p/WifiP2pDevice;
    iget-object v7, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    iget-object v7, v7, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->this$0:Landroid/net/wifi/p2p/WifiP2pService;

    #getter for: Landroid/net/wifi/p2p/WifiP2pService;->mThisDevice:Landroid/net/wifi/p2p/WifiP2pDevice;
    invoke-static {v7}, Landroid/net/wifi/p2p/WifiP2pService;->access$3300(Landroid/net/wifi/p2p/WifiP2pService;)Landroid/net/wifi/p2p/WifiP2pDevice;

    move-result-object v7

    iget-object v7, v7, Landroid/net/wifi/p2p/WifiP2pDevice;->deviceAddress:Ljava/lang/String;

    iget-object v9, v2, Landroid/net/wifi/p2p/WifiP2pDevice;->deviceAddress:Ljava/lang/String;

    invoke-virtual {v7, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-nez v7, :cond_32

    iget-object v7, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    #getter for: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->mPeers:Landroid/net/wifi/p2p/WifiP2pDeviceList;
    invoke-static {v7}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$500(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;)Landroid/net/wifi/p2p/WifiP2pDeviceList;

    move-result-object v7

    invoke-virtual {v7, v2}, Landroid/net/wifi/p2p/WifiP2pDeviceList;->update(Landroid/net/wifi/p2p/WifiP2pDevice;)V

    iget-object v7, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->sendP2pPeersChangedBroadcast()V
    invoke-static {v7}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$2600(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;)V

    goto/16 :goto_32

    .end local v2           #device:Landroid/net/wifi/p2p/WifiP2pDevice;
    :sswitch_f4
    iget-object v2, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v2, Landroid/net/wifi/p2p/WifiP2pDevice;

    .restart local v2       #device:Landroid/net/wifi/p2p/WifiP2pDevice;
    iget-object v7, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    #getter for: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->mPeers:Landroid/net/wifi/p2p/WifiP2pDeviceList;
    invoke-static {v7}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$500(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;)Landroid/net/wifi/p2p/WifiP2pDeviceList;

    move-result-object v7

    invoke-virtual {v7, v2}, Landroid/net/wifi/p2p/WifiP2pDeviceList;->remove(Landroid/net/wifi/p2p/WifiP2pDevice;)Z

    move-result v7

    if-eqz v7, :cond_32

    iget-object v7, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->sendP2pPeersChangedBroadcast()V
    invoke-static {v7}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$2600(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;)V

    goto/16 :goto_32

    .end local v2           #device:Landroid/net/wifi/p2p/WifiP2pDevice;
    :sswitch_10b
    iget-object v6, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v6, Landroid/net/wifi/p2p/nsd/WifiP2pServiceInfo;

    .local v6, servInfo:Landroid/net/wifi/p2p/nsd/WifiP2pServiceInfo;
    iget-object v7, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    iget-object v9, p1, Landroid/os/Message;->replyTo:Landroid/os/Messenger;

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->addLocalService(Landroid/os/Messenger;Landroid/net/wifi/p2p/nsd/WifiP2pServiceInfo;)Z
    invoke-static {v7, v9, v6}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$3400(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;Landroid/os/Messenger;Landroid/net/wifi/p2p/nsd/WifiP2pServiceInfo;)Z

    move-result v7

    if-eqz v7, :cond_123

    iget-object v7, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    const v9, 0x2201e

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->replyToMessage(Landroid/os/Message;I)V
    invoke-static {v7, p1, v9}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$1000(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;Landroid/os/Message;I)V

    goto/16 :goto_32

    :cond_123
    iget-object v7, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    const v9, 0x2201d

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->replyToMessage(Landroid/os/Message;I)V
    invoke-static {v7, p1, v9}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$1000(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;Landroid/os/Message;I)V

    goto/16 :goto_32

    .end local v6           #servInfo:Landroid/net/wifi/p2p/nsd/WifiP2pServiceInfo;
    :sswitch_12d
    iget-object v6, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v6, Landroid/net/wifi/p2p/nsd/WifiP2pServiceInfo;

    .restart local v6       #servInfo:Landroid/net/wifi/p2p/nsd/WifiP2pServiceInfo;
    iget-object v7, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    iget-object v9, p1, Landroid/os/Message;->replyTo:Landroid/os/Messenger;

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->removeLocalService(Landroid/os/Messenger;Landroid/net/wifi/p2p/nsd/WifiP2pServiceInfo;)V
    invoke-static {v7, v9, v6}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$3500(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;Landroid/os/Messenger;Landroid/net/wifi/p2p/nsd/WifiP2pServiceInfo;)V

    iget-object v7, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    const v9, 0x22021

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->replyToMessage(Landroid/os/Message;I)V
    invoke-static {v7, p1, v9}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$1000(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;Landroid/os/Message;I)V

    goto/16 :goto_32

    .end local v6           #servInfo:Landroid/net/wifi/p2p/nsd/WifiP2pServiceInfo;
    :sswitch_142
    iget-object v7, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    iget-object v9, p1, Landroid/os/Message;->replyTo:Landroid/os/Messenger;

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->clearLocalServices(Landroid/os/Messenger;)V
    invoke-static {v7, v9}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$3600(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;Landroid/os/Messenger;)V

    iget-object v7, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    const v9, 0x22024

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->replyToMessage(Landroid/os/Message;I)V
    invoke-static {v7, p1, v9}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$1000(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;Landroid/os/Message;I)V

    goto/16 :goto_32

    :sswitch_153
    iget-object v9, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    iget-object v10, p1, Landroid/os/Message;->replyTo:Landroid/os/Messenger;

    iget-object v7, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v7, Landroid/net/wifi/p2p/nsd/WifiP2pServiceRequest;

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->addServiceRequest(Landroid/os/Messenger;Landroid/net/wifi/p2p/nsd/WifiP2pServiceRequest;)Z
    invoke-static {v9, v10, v7}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$3700(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;Landroid/os/Messenger;Landroid/net/wifi/p2p/nsd/WifiP2pServiceRequest;)Z

    move-result v7

    if-nez v7, :cond_16b

    iget-object v7, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    const v9, 0x22026

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->replyToMessage(Landroid/os/Message;I)V
    invoke-static {v7, p1, v9}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$1000(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;Landroid/os/Message;I)V

    goto/16 :goto_32

    :cond_16b
    iget-object v7, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    const v9, 0x22027

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->replyToMessage(Landroid/os/Message;I)V
    invoke-static {v7, p1, v9}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$1000(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;Landroid/os/Message;I)V

    goto/16 :goto_32

    :sswitch_175
    iget-object v9, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    iget-object v10, p1, Landroid/os/Message;->replyTo:Landroid/os/Messenger;

    iget-object v7, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v7, Landroid/net/wifi/p2p/nsd/WifiP2pServiceRequest;

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->removeServiceRequest(Landroid/os/Messenger;Landroid/net/wifi/p2p/nsd/WifiP2pServiceRequest;)V
    invoke-static {v9, v10, v7}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$3800(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;Landroid/os/Messenger;Landroid/net/wifi/p2p/nsd/WifiP2pServiceRequest;)V

    iget-object v7, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    const v9, 0x2202a

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->replyToMessage(Landroid/os/Message;I)V
    invoke-static {v7, p1, v9}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$1000(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;Landroid/os/Message;I)V

    goto/16 :goto_32

    :sswitch_18a
    iget-object v7, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    iget-object v9, p1, Landroid/os/Message;->replyTo:Landroid/os/Messenger;

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->clearServiceRequests(Landroid/os/Messenger;)V
    invoke-static {v7, v9}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$3900(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;Landroid/os/Messenger;)V

    iget-object v7, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    const v9, 0x2202d

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->replyToMessage(Landroid/os/Message;I)V
    invoke-static {v7, p1, v9}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$1000(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;Landroid/os/Message;I)V

    goto/16 :goto_32

    :sswitch_19b
    iget-object v5, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v5, Ljava/util/List;

    .local v5, sdRespList:Ljava/util/List;,"Ljava/util/List<Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;>;"
    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, i$:Ljava/util/Iterator;
    :goto_1a3
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_32

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;

    .local v4, resp:Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;
    iget-object v7, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    #getter for: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->mPeers:Landroid/net/wifi/p2p/WifiP2pDeviceList;
    invoke-static {v7}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$500(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;)Landroid/net/wifi/p2p/WifiP2pDeviceList;

    move-result-object v7

    invoke-virtual {v4}, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->getSrcDevice()Landroid/net/wifi/p2p/WifiP2pDevice;

    move-result-object v9

    iget-object v9, v9, Landroid/net/wifi/p2p/WifiP2pDevice;->deviceAddress:Ljava/lang/String;

    invoke-virtual {v7, v9}, Landroid/net/wifi/p2p/WifiP2pDeviceList;->get(Ljava/lang/String;)Landroid/net/wifi/p2p/WifiP2pDevice;

    move-result-object v1

    .local v1, dev:Landroid/net/wifi/p2p/WifiP2pDevice;
    invoke-virtual {v4, v1}, Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;->setSrcDevice(Landroid/net/wifi/p2p/WifiP2pDevice;)V

    iget-object v7, p0, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine$P2pEnabledState;->this$1:Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;

    #calls: Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->sendServiceResponse(Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;)V
    invoke-static {v7, v4}, Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;->access$4000(Landroid/net/wifi/p2p/WifiP2pService$P2pStateMachine;Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;)V

    goto :goto_1a3

    :sswitch_data_1c8
    .sparse-switch
        0x20083 -> :sswitch_32
        0x20084 -> :sswitch_d
        0x22001 -> :sswitch_56
        0x22004 -> :sswitch_84
        0x2201c -> :sswitch_10b
        0x2201f -> :sswitch_12d
        0x22022 -> :sswitch_142
        0x22025 -> :sswitch_153
        0x22028 -> :sswitch_175
        0x2202b -> :sswitch_18a
        0x2202e -> :sswitch_a2
        0x22033 -> :sswitch_34
        0x24015 -> :sswitch_ce
        0x24016 -> :sswitch_f4
        0x24025 -> :sswitch_7e
        0x24026 -> :sswitch_19b
    .end sparse-switch
.end method
