.class Landroid/bluetooth/BluetoothProfileState$PendingCommandState;
.super Lcom/android/internal/util/State;
.source "BluetoothProfileState.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/bluetooth/BluetoothProfileState;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "PendingCommandState"
.end annotation


# instance fields
.field final synthetic this$0:Landroid/bluetooth/BluetoothProfileState;


# direct methods
.method private constructor <init>(Landroid/bluetooth/BluetoothProfileState;)V
    .registers 2
    .parameter

    .prologue
    .line 122
    iput-object p1, p0, Landroid/bluetooth/BluetoothProfileState$PendingCommandState;->this$0:Landroid/bluetooth/BluetoothProfileState;

    invoke-direct {p0}, Lcom/android/internal/util/State;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/bluetooth/BluetoothProfileState;Landroid/bluetooth/BluetoothProfileState$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 122
    invoke-direct {p0, p1}, Landroid/bluetooth/BluetoothProfileState$PendingCommandState;-><init>(Landroid/bluetooth/BluetoothProfileState;)V

    return-void
.end method

.method private dispatchMessage(Landroid/os/Message;)V
    .registers 7
    .parameter "msg"

    .prologue
    .line 140
    iget-object v2, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v2, Landroid/bluetooth/BluetoothDeviceProfileState;

    .line 142
    .local v2, deviceProfileMgr:Landroid/bluetooth/BluetoothDeviceProfileState;
    iget v0, p1, Landroid/os/Message;->arg1:I

    .line 143
    .local v0, cmd:I
    iget-object v3, p0, Landroid/bluetooth/BluetoothProfileState$PendingCommandState;->this$0:Landroid/bluetooth/BluetoothProfileState;

    #getter for: Landroid/bluetooth/BluetoothProfileState;->mPendingDevice:Landroid/bluetooth/BluetoothDevice;
    invoke-static {v3}, Landroid/bluetooth/BluetoothProfileState;->access$300(Landroid/bluetooth/BluetoothProfileState;)Landroid/bluetooth/BluetoothDevice;

    move-result-object v3

    if-eqz v3, :cond_1e

    iget-object v3, p0, Landroid/bluetooth/BluetoothProfileState$PendingCommandState;->this$0:Landroid/bluetooth/BluetoothProfileState;

    #getter for: Landroid/bluetooth/BluetoothProfileState;->mPendingDevice:Landroid/bluetooth/BluetoothDevice;
    invoke-static {v3}, Landroid/bluetooth/BluetoothProfileState;->access$300(Landroid/bluetooth/BluetoothProfileState;)Landroid/bluetooth/BluetoothDevice;

    move-result-object v3

    invoke-virtual {v2}, Landroid/bluetooth/BluetoothDeviceProfileState;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/bluetooth/BluetoothDevice;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2b

    .line 144
    :cond_1e
    iget-object v3, p0, Landroid/bluetooth/BluetoothProfileState$PendingCommandState;->this$0:Landroid/bluetooth/BluetoothProfileState;

    invoke-virtual {v2}, Landroid/bluetooth/BluetoothDeviceProfileState;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v4

    #setter for: Landroid/bluetooth/BluetoothProfileState;->mPendingDevice:Landroid/bluetooth/BluetoothDevice;
    invoke-static {v3, v4}, Landroid/bluetooth/BluetoothProfileState;->access$302(Landroid/bluetooth/BluetoothProfileState;Landroid/bluetooth/BluetoothDevice;)Landroid/bluetooth/BluetoothDevice;

    .line 145
    invoke-virtual {v2, v0}, Landroid/bluetooth/BluetoothDeviceProfileState;->sendMessage(I)V

    .line 152
    :goto_2a
    return-void

    .line 147
    :cond_2b
    new-instance v1, Landroid/os/Message;

    invoke-direct {v1}, Landroid/os/Message;-><init>()V

    .line 148
    .local v1, deferMsg:Landroid/os/Message;
    iput v0, v1, Landroid/os/Message;->arg1:I

    .line 149
    iput-object v2, v1, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 150
    iget-object v3, p0, Landroid/bluetooth/BluetoothProfileState$PendingCommandState;->this$0:Landroid/bluetooth/BluetoothProfileState;

    #calls: Landroid/bluetooth/BluetoothProfileState;->deferMessage(Landroid/os/Message;)V
    invoke-static {v3, v1}, Landroid/bluetooth/BluetoothProfileState;->access$1000(Landroid/bluetooth/BluetoothProfileState;Landroid/os/Message;)V

    goto :goto_2a
.end method


# virtual methods
.method public enter()V
    .registers 3

    .prologue
    .line 125
    iget-object v0, p0, Landroid/bluetooth/BluetoothProfileState$PendingCommandState;->this$0:Landroid/bluetooth/BluetoothProfileState;

    const-string v1, "Entering PendingCommandState State"

    #calls: Landroid/bluetooth/BluetoothProfileState;->log(Ljava/lang/String;)V
    invoke-static {v0, v1}, Landroid/bluetooth/BluetoothProfileState;->access$400(Landroid/bluetooth/BluetoothProfileState;Ljava/lang/String;)V

    .line 126
    iget-object v0, p0, Landroid/bluetooth/BluetoothProfileState$PendingCommandState;->this$0:Landroid/bluetooth/BluetoothProfileState;

    #calls: Landroid/bluetooth/BluetoothProfileState;->getCurrentMessage()Landroid/os/Message;
    invoke-static {v0}, Landroid/bluetooth/BluetoothProfileState;->access$700(Landroid/bluetooth/BluetoothProfileState;)Landroid/os/Message;

    move-result-object v0

    invoke-direct {p0, v0}, Landroid/bluetooth/BluetoothProfileState$PendingCommandState;->dispatchMessage(Landroid/os/Message;)V

    .line 127
    return-void
.end method

.method public processMessage(Landroid/os/Message;)Z
    .registers 4
    .parameter "msg"

    .prologue
    .line 131
    iget v0, p1, Landroid/os/Message;->what:I

    const/16 v1, 0x64

    if-ne v0, v1, :cond_13

    .line 132
    iget-object v0, p0, Landroid/bluetooth/BluetoothProfileState$PendingCommandState;->this$0:Landroid/bluetooth/BluetoothProfileState;

    iget-object v1, p0, Landroid/bluetooth/BluetoothProfileState$PendingCommandState;->this$0:Landroid/bluetooth/BluetoothProfileState;

    #getter for: Landroid/bluetooth/BluetoothProfileState;->mStableState:Landroid/bluetooth/BluetoothProfileState$StableState;
    invoke-static {v1}, Landroid/bluetooth/BluetoothProfileState;->access$800(Landroid/bluetooth/BluetoothProfileState;)Landroid/bluetooth/BluetoothProfileState$StableState;

    move-result-object v1

    #calls: Landroid/bluetooth/BluetoothProfileState;->transitionTo(Lcom/android/internal/util/IState;)V
    invoke-static {v0, v1}, Landroid/bluetooth/BluetoothProfileState;->access$900(Landroid/bluetooth/BluetoothProfileState;Lcom/android/internal/util/IState;)V

    .line 136
    :goto_11
    const/4 v0, 0x1

    return v0

    .line 134
    :cond_13
    invoke-direct {p0, p1}, Landroid/bluetooth/BluetoothProfileState$PendingCommandState;->dispatchMessage(Landroid/os/Message;)V

    goto :goto_11
.end method
