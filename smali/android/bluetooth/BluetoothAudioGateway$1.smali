.class Landroid/bluetooth/BluetoothAudioGateway$1;
.super Ljava/lang/Thread;
.source "BluetoothAudioGateway.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/bluetooth/BluetoothAudioGateway;->start(Landroid/os/Handler;)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/bluetooth/BluetoothAudioGateway;


# direct methods
.method constructor <init>(Landroid/bluetooth/BluetoothAudioGateway;Ljava/lang/String;)V
    .registers 3
    .parameter
    .parameter "x0"

    .prologue
    .line 96
    iput-object p1, p0, Landroid/bluetooth/BluetoothAudioGateway$1;->this$0:Landroid/bluetooth/BluetoothAudioGateway;

    invoke-direct {p0, p2}, Ljava/lang/Thread;-><init>(Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 10

    .prologue
    const/4 v8, -0x1

    .line 99
    :cond_1
    :goto_1
    iget-object v0, p0, Landroid/bluetooth/BluetoothAudioGateway$1;->this$0:Landroid/bluetooth/BluetoothAudioGateway;

    #getter for: Landroid/bluetooth/BluetoothAudioGateway;->mInterrupted:Z
    invoke-static {v0}, Landroid/bluetooth/BluetoothAudioGateway;->access$000(Landroid/bluetooth/BluetoothAudioGateway;)Z

    move-result v0

    if-nez v0, :cond_156

    .line 101
    iget-object v0, p0, Landroid/bluetooth/BluetoothAudioGateway$1;->this$0:Landroid/bluetooth/BluetoothAudioGateway;

    #setter for: Landroid/bluetooth/BluetoothAudioGateway;->mConnectingHeadsetRfcommChannel:I
    invoke-static {v0, v8}, Landroid/bluetooth/BluetoothAudioGateway;->access$102(Landroid/bluetooth/BluetoothAudioGateway;I)I

    .line 102
    iget-object v0, p0, Landroid/bluetooth/BluetoothAudioGateway$1;->this$0:Landroid/bluetooth/BluetoothAudioGateway;

    #setter for: Landroid/bluetooth/BluetoothAudioGateway;->mConnectingHandsfreeRfcommChannel:I
    invoke-static {v0, v8}, Landroid/bluetooth/BluetoothAudioGateway;->access$202(Landroid/bluetooth/BluetoothAudioGateway;I)I

    .line 103
    iget-object v0, p0, Landroid/bluetooth/BluetoothAudioGateway$1;->this$0:Landroid/bluetooth/BluetoothAudioGateway;

    const/16 v1, 0x3e8

    #calls: Landroid/bluetooth/BluetoothAudioGateway;->waitForHandsfreeConnectNative(I)Z
    invoke-static {v0, v1}, Landroid/bluetooth/BluetoothAudioGateway;->access$300(Landroid/bluetooth/BluetoothAudioGateway;I)Z

    move-result v0

    if-nez v0, :cond_66

    .line 104
    iget-object v0, p0, Landroid/bluetooth/BluetoothAudioGateway$1;->this$0:Landroid/bluetooth/BluetoothAudioGateway;

    #getter for: Landroid/bluetooth/BluetoothAudioGateway;->mTimeoutRemainingMs:I
    invoke-static {v0}, Landroid/bluetooth/BluetoothAudioGateway;->access$400(Landroid/bluetooth/BluetoothAudioGateway;)I

    move-result v0

    if-lez v0, :cond_1

    .line 106
    :try_start_25
    const-string v0, "BT Audio Gateway"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "select thread timed out, but "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/bluetooth/BluetoothAudioGateway$1;->this$0:Landroid/bluetooth/BluetoothAudioGateway;

    #getter for: Landroid/bluetooth/BluetoothAudioGateway;->mTimeoutRemainingMs:I
    invoke-static {v2}, Landroid/bluetooth/BluetoothAudioGateway;->access$400(Landroid/bluetooth/BluetoothAudioGateway;)I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "ms of waiting remain."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 108
    iget-object v0, p0, Landroid/bluetooth/BluetoothAudioGateway$1;->this$0:Landroid/bluetooth/BluetoothAudioGateway;

    #getter for: Landroid/bluetooth/BluetoothAudioGateway;->mTimeoutRemainingMs:I
    invoke-static {v0}, Landroid/bluetooth/BluetoothAudioGateway;->access$400(Landroid/bluetooth/BluetoothAudioGateway;)I

    move-result v0

    int-to-long v0, v0

    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_55
    .catch Ljava/lang/InterruptedException; {:try_start_25 .. :try_end_55} :catch_56

    goto :goto_1

    .line 109
    :catch_56
    move-exception v6

    .line 110
    .local v6, e:Ljava/lang/InterruptedException;
    const-string v0, "BT Audio Gateway"

    const-string/jumbo v1, "select thread was interrupted (2), exiting"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 111
    iget-object v0, p0, Landroid/bluetooth/BluetoothAudioGateway$1;->this$0:Landroid/bluetooth/BluetoothAudioGateway;

    const/4 v1, 0x1

    #setter for: Landroid/bluetooth/BluetoothAudioGateway;->mInterrupted:Z
    invoke-static {v0, v1}, Landroid/bluetooth/BluetoothAudioGateway;->access$002(Landroid/bluetooth/BluetoothAudioGateway;Z)Z

    goto :goto_1

    .line 116
    .end local v6           #e:Ljava/lang/InterruptedException;
    :cond_66
    const-string v0, "BT Audio Gateway"

    const-string v1, "connect notification!"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 122
    iget-object v0, p0, Landroid/bluetooth/BluetoothAudioGateway$1;->this$0:Landroid/bluetooth/BluetoothAudioGateway;

    #getter for: Landroid/bluetooth/BluetoothAudioGateway;->mConnectingHeadsetRfcommChannel:I
    invoke-static {v0}, Landroid/bluetooth/BluetoothAudioGateway;->access$100(Landroid/bluetooth/BluetoothAudioGateway;)I

    move-result v0

    if-ltz v0, :cond_df

    .line 123
    const-string v0, "BT Audio Gateway"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Incoming connection from headset "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/bluetooth/BluetoothAudioGateway$1;->this$0:Landroid/bluetooth/BluetoothAudioGateway;

    #getter for: Landroid/bluetooth/BluetoothAudioGateway;->mConnectingHeadsetAddress:Ljava/lang/String;
    invoke-static {v2}, Landroid/bluetooth/BluetoothAudioGateway;->access$500(Landroid/bluetooth/BluetoothAudioGateway;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " on channel "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/bluetooth/BluetoothAudioGateway$1;->this$0:Landroid/bluetooth/BluetoothAudioGateway;

    #getter for: Landroid/bluetooth/BluetoothAudioGateway;->mConnectingHeadsetRfcommChannel:I
    invoke-static {v2}, Landroid/bluetooth/BluetoothAudioGateway;->access$100(Landroid/bluetooth/BluetoothAudioGateway;)I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 126
    iget-object v0, p0, Landroid/bluetooth/BluetoothAudioGateway$1;->this$0:Landroid/bluetooth/BluetoothAudioGateway;

    #getter for: Landroid/bluetooth/BluetoothAudioGateway;->mCallback:Landroid/os/Handler;
    invoke-static {v0}, Landroid/bluetooth/BluetoothAudioGateway;->access$600(Landroid/bluetooth/BluetoothAudioGateway;)Landroid/os/Handler;

    move-result-object v0

    invoke-static {v0}, Landroid/os/Message;->obtain(Landroid/os/Handler;)Landroid/os/Message;

    move-result-object v7

    .line 127
    .local v7, msg:Landroid/os/Message;
    const/16 v0, 0x64

    iput v0, v7, Landroid/os/Message;->what:I

    .line 128
    new-instance v0, Landroid/bluetooth/BluetoothAudioGateway$IncomingConnectionInfo;

    iget-object v1, p0, Landroid/bluetooth/BluetoothAudioGateway$1;->this$0:Landroid/bluetooth/BluetoothAudioGateway;

    iget-object v2, p0, Landroid/bluetooth/BluetoothAudioGateway$1;->this$0:Landroid/bluetooth/BluetoothAudioGateway;

    #getter for: Landroid/bluetooth/BluetoothAudioGateway;->mAdapter:Landroid/bluetooth/BluetoothAdapter;
    invoke-static {v2}, Landroid/bluetooth/BluetoothAudioGateway;->access$700(Landroid/bluetooth/BluetoothAudioGateway;)Landroid/bluetooth/BluetoothAdapter;

    move-result-object v2

    iget-object v3, p0, Landroid/bluetooth/BluetoothAudioGateway$1;->this$0:Landroid/bluetooth/BluetoothAudioGateway;

    #getter for: Landroid/bluetooth/BluetoothAudioGateway;->mAdapter:Landroid/bluetooth/BluetoothAdapter;
    invoke-static {v3}, Landroid/bluetooth/BluetoothAudioGateway;->access$700(Landroid/bluetooth/BluetoothAudioGateway;)Landroid/bluetooth/BluetoothAdapter;

    move-result-object v3

    iget-object v4, p0, Landroid/bluetooth/BluetoothAudioGateway$1;->this$0:Landroid/bluetooth/BluetoothAudioGateway;

    #getter for: Landroid/bluetooth/BluetoothAudioGateway;->mConnectingHeadsetAddress:Ljava/lang/String;
    invoke-static {v4}, Landroid/bluetooth/BluetoothAudioGateway;->access$500(Landroid/bluetooth/BluetoothAudioGateway;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/bluetooth/BluetoothAdapter;->getRemoteDevice(Ljava/lang/String;)Landroid/bluetooth/BluetoothDevice;

    move-result-object v3

    iget-object v4, p0, Landroid/bluetooth/BluetoothAudioGateway$1;->this$0:Landroid/bluetooth/BluetoothAudioGateway;

    #getter for: Landroid/bluetooth/BluetoothAudioGateway;->mConnectingHeadsetSocketFd:I
    invoke-static {v4}, Landroid/bluetooth/BluetoothAudioGateway;->access$800(Landroid/bluetooth/BluetoothAudioGateway;)I

    move-result v4

    iget-object v5, p0, Landroid/bluetooth/BluetoothAudioGateway$1;->this$0:Landroid/bluetooth/BluetoothAudioGateway;

    #getter for: Landroid/bluetooth/BluetoothAudioGateway;->mConnectingHeadsetRfcommChannel:I
    invoke-static {v5}, Landroid/bluetooth/BluetoothAudioGateway;->access$100(Landroid/bluetooth/BluetoothAudioGateway;)I

    move-result v5

    invoke-direct/range {v0 .. v5}, Landroid/bluetooth/BluetoothAudioGateway$IncomingConnectionInfo;-><init>(Landroid/bluetooth/BluetoothAudioGateway;Landroid/bluetooth/BluetoothAdapter;Landroid/bluetooth/BluetoothDevice;II)V

    iput-object v0, v7, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 133
    invoke-virtual {v7}, Landroid/os/Message;->sendToTarget()V

    .line 135
    .end local v7           #msg:Landroid/os/Message;
    :cond_df
    iget-object v0, p0, Landroid/bluetooth/BluetoothAudioGateway$1;->this$0:Landroid/bluetooth/BluetoothAudioGateway;

    #getter for: Landroid/bluetooth/BluetoothAudioGateway;->mConnectingHandsfreeRfcommChannel:I
    invoke-static {v0}, Landroid/bluetooth/BluetoothAudioGateway;->access$200(Landroid/bluetooth/BluetoothAudioGateway;)I

    move-result v0

    if-ltz v0, :cond_1

    .line 136
    const-string v0, "BT Audio Gateway"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Incoming connection from handsfree "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/bluetooth/BluetoothAudioGateway$1;->this$0:Landroid/bluetooth/BluetoothAudioGateway;

    #getter for: Landroid/bluetooth/BluetoothAudioGateway;->mConnectingHandsfreeAddress:Ljava/lang/String;
    invoke-static {v2}, Landroid/bluetooth/BluetoothAudioGateway;->access$900(Landroid/bluetooth/BluetoothAudioGateway;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " on channel "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/bluetooth/BluetoothAudioGateway$1;->this$0:Landroid/bluetooth/BluetoothAudioGateway;

    #getter for: Landroid/bluetooth/BluetoothAudioGateway;->mConnectingHandsfreeRfcommChannel:I
    invoke-static {v2}, Landroid/bluetooth/BluetoothAudioGateway;->access$200(Landroid/bluetooth/BluetoothAudioGateway;)I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 139
    invoke-static {}, Landroid/os/Message;->obtain()Landroid/os/Message;

    move-result-object v7

    .line 140
    .restart local v7       #msg:Landroid/os/Message;
    iget-object v0, p0, Landroid/bluetooth/BluetoothAudioGateway$1;->this$0:Landroid/bluetooth/BluetoothAudioGateway;

    #getter for: Landroid/bluetooth/BluetoothAudioGateway;->mCallback:Landroid/os/Handler;
    invoke-static {v0}, Landroid/bluetooth/BluetoothAudioGateway;->access$600(Landroid/bluetooth/BluetoothAudioGateway;)Landroid/os/Handler;

    move-result-object v0

    invoke-virtual {v7, v0}, Landroid/os/Message;->setTarget(Landroid/os/Handler;)V

    .line 141
    const/16 v0, 0x65

    iput v0, v7, Landroid/os/Message;->what:I

    .line 142
    new-instance v0, Landroid/bluetooth/BluetoothAudioGateway$IncomingConnectionInfo;

    iget-object v1, p0, Landroid/bluetooth/BluetoothAudioGateway$1;->this$0:Landroid/bluetooth/BluetoothAudioGateway;

    iget-object v2, p0, Landroid/bluetooth/BluetoothAudioGateway$1;->this$0:Landroid/bluetooth/BluetoothAudioGateway;

    #getter for: Landroid/bluetooth/BluetoothAudioGateway;->mAdapter:Landroid/bluetooth/BluetoothAdapter;
    invoke-static {v2}, Landroid/bluetooth/BluetoothAudioGateway;->access$700(Landroid/bluetooth/BluetoothAudioGateway;)Landroid/bluetooth/BluetoothAdapter;

    move-result-object v2

    iget-object v3, p0, Landroid/bluetooth/BluetoothAudioGateway$1;->this$0:Landroid/bluetooth/BluetoothAudioGateway;

    #getter for: Landroid/bluetooth/BluetoothAudioGateway;->mAdapter:Landroid/bluetooth/BluetoothAdapter;
    invoke-static {v3}, Landroid/bluetooth/BluetoothAudioGateway;->access$700(Landroid/bluetooth/BluetoothAudioGateway;)Landroid/bluetooth/BluetoothAdapter;

    move-result-object v3

    iget-object v4, p0, Landroid/bluetooth/BluetoothAudioGateway$1;->this$0:Landroid/bluetooth/BluetoothAudioGateway;

    #getter for: Landroid/bluetooth/BluetoothAudioGateway;->mConnectingHandsfreeAddress:Ljava/lang/String;
    invoke-static {v4}, Landroid/bluetooth/BluetoothAudioGateway;->access$900(Landroid/bluetooth/BluetoothAudioGateway;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/bluetooth/BluetoothAdapter;->getRemoteDevice(Ljava/lang/String;)Landroid/bluetooth/BluetoothDevice;

    move-result-object v3

    iget-object v4, p0, Landroid/bluetooth/BluetoothAudioGateway$1;->this$0:Landroid/bluetooth/BluetoothAudioGateway;

    #getter for: Landroid/bluetooth/BluetoothAudioGateway;->mConnectingHandsfreeSocketFd:I
    invoke-static {v4}, Landroid/bluetooth/BluetoothAudioGateway;->access$1000(Landroid/bluetooth/BluetoothAudioGateway;)I

    move-result v4

    iget-object v5, p0, Landroid/bluetooth/BluetoothAudioGateway$1;->this$0:Landroid/bluetooth/BluetoothAudioGateway;

    #getter for: Landroid/bluetooth/BluetoothAudioGateway;->mConnectingHandsfreeRfcommChannel:I
    invoke-static {v5}, Landroid/bluetooth/BluetoothAudioGateway;->access$200(Landroid/bluetooth/BluetoothAudioGateway;)I

    move-result v5

    invoke-direct/range {v0 .. v5}, Landroid/bluetooth/BluetoothAudioGateway$IncomingConnectionInfo;-><init>(Landroid/bluetooth/BluetoothAudioGateway;Landroid/bluetooth/BluetoothAdapter;Landroid/bluetooth/BluetoothDevice;II)V

    iput-object v0, v7, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 147
    invoke-virtual {v7}, Landroid/os/Message;->sendToTarget()V

    goto/16 :goto_1

    .line 152
    .end local v7           #msg:Landroid/os/Message;
    :cond_156
    return-void
.end method
