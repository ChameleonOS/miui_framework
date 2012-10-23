.class Landroid/server/BluetoothEventLoop$1;
.super Landroid/os/Handler;
.source "BluetoothEventLoop.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/server/BluetoothEventLoop;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/server/BluetoothEventLoop;


# direct methods
.method constructor <init>(Landroid/server/BluetoothEventLoop;)V
    .registers 2
    .parameter

    .prologue
    .line 73
    iput-object p1, p0, Landroid/server/BluetoothEventLoop$1;->this$0:Landroid/server/BluetoothEventLoop;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .registers 7
    .parameter "msg"

    .prologue
    const/4 v4, 0x1

    .line 76
    const/4 v0, 0x0

    .line 77
    .local v0, address:Ljava/lang/String;
    iget v2, p1, Landroid/os/Message;->what:I

    packed-switch v2, :pswitch_data_44

    .line 100
    :cond_7
    :goto_7
    return-void

    .line 79
    :pswitch_8
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    .end local v0           #address:Ljava/lang/String;
    check-cast v0, Ljava/lang/String;

    .line 80
    .restart local v0       #address:Ljava/lang/String;
    if-eqz v0, :cond_7

    .line 81
    iget-object v2, p0, Landroid/server/BluetoothEventLoop$1;->this$0:Landroid/server/BluetoothEventLoop;

    #getter for: Landroid/server/BluetoothEventLoop;->mBluetoothService:Landroid/server/BluetoothService;
    invoke-static {v2}, Landroid/server/BluetoothEventLoop;->access$000(Landroid/server/BluetoothEventLoop;)Landroid/server/BluetoothService;

    move-result-object v2

    invoke-virtual {v2, v0, v4}, Landroid/server/BluetoothService;->setPairingConfirmation(Ljava/lang/String;Z)Z

    goto :goto_7

    .line 87
    :pswitch_18
    iget-object v2, p0, Landroid/server/BluetoothEventLoop$1;->this$0:Landroid/server/BluetoothEventLoop;

    #getter for: Landroid/server/BluetoothEventLoop;->mBluetoothService:Landroid/server/BluetoothService;
    invoke-static {v2}, Landroid/server/BluetoothEventLoop;->access$000(Landroid/server/BluetoothEventLoop;)Landroid/server/BluetoothService;

    move-result-object v2

    const/16 v3, 0xb

    invoke-virtual {v2, v3}, Landroid/server/BluetoothService;->listInState(I)[Ljava/lang/String;

    move-result-object v1

    .line 88
    .local v1, devices:[Ljava/lang/String;
    array-length v2, v1

    if-eqz v2, :cond_7

    .line 90
    array-length v2, v1

    if-le v2, v4, :cond_32

    .line 91
    const-string v2, "BluetoothEventLoop"

    const-string v3, " There is more than one device in the Bonding State"

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_7

    .line 94
    :cond_32
    const/4 v2, 0x0

    aget-object v0, v1, v2

    .line 95
    iget-object v2, p0, Landroid/server/BluetoothEventLoop$1;->this$0:Landroid/server/BluetoothEventLoop;

    #getter for: Landroid/server/BluetoothEventLoop;->mBluetoothService:Landroid/server/BluetoothService;
    invoke-static {v2}, Landroid/server/BluetoothEventLoop;->access$000(Landroid/server/BluetoothEventLoop;)Landroid/server/BluetoothService;

    move-result-object v2

    const/16 v3, 0xa

    const/16 v4, 0x8

    invoke-virtual {v2, v0, v3, v4}, Landroid/server/BluetoothService;->setBondState(Ljava/lang/String;II)Z

    goto :goto_7

    .line 77
    nop

    :pswitch_data_44
    .packed-switch 0x1
        :pswitch_8
        :pswitch_18
    .end packed-switch
.end method
