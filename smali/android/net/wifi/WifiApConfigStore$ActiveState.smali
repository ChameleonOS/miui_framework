.class Landroid/net/wifi/WifiApConfigStore$ActiveState;
.super Lcom/android/internal/util/State;
.source "WifiApConfigStore.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/wifi/WifiApConfigStore;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ActiveState"
.end annotation


# instance fields
.field final synthetic this$0:Landroid/net/wifi/WifiApConfigStore;


# direct methods
.method constructor <init>(Landroid/net/wifi/WifiApConfigStore;)V
    .registers 2
    .parameter

    .prologue
    .line 113
    iput-object p1, p0, Landroid/net/wifi/WifiApConfigStore$ActiveState;->this$0:Landroid/net/wifi/WifiApConfigStore;

    invoke-direct {p0}, Lcom/android/internal/util/State;-><init>()V

    return-void
.end method


# virtual methods
.method public enter()V
    .registers 3

    .prologue
    .line 115
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Landroid/net/wifi/WifiApConfigStore$ActiveState$1;

    invoke-direct {v1, p0}, Landroid/net/wifi/WifiApConfigStore$ActiveState$1;-><init>(Landroid/net/wifi/WifiApConfigStore$ActiveState;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 121
    return-void
.end method

.method public processMessage(Landroid/os/Message;)Z
    .registers 4
    .parameter "message"

    .prologue
    .line 124
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_1a

    .line 134
    const/4 v0, 0x0

    .line 136
    :goto_6
    return v0

    .line 128
    :pswitch_7
    iget-object v0, p0, Landroid/net/wifi/WifiApConfigStore$ActiveState;->this$0:Landroid/net/wifi/WifiApConfigStore;

    #calls: Landroid/net/wifi/WifiApConfigStore;->deferMessage(Landroid/os/Message;)V
    invoke-static {v0, p1}, Landroid/net/wifi/WifiApConfigStore;->access$500(Landroid/net/wifi/WifiApConfigStore;Landroid/os/Message;)V

    .line 136
    :goto_c
    const/4 v0, 0x1

    goto :goto_6

    .line 131
    :pswitch_e
    iget-object v0, p0, Landroid/net/wifi/WifiApConfigStore$ActiveState;->this$0:Landroid/net/wifi/WifiApConfigStore;

    iget-object v1, p0, Landroid/net/wifi/WifiApConfigStore$ActiveState;->this$0:Landroid/net/wifi/WifiApConfigStore;

    #getter for: Landroid/net/wifi/WifiApConfigStore;->mInactiveState:Lcom/android/internal/util/State;
    invoke-static {v1}, Landroid/net/wifi/WifiApConfigStore;->access$600(Landroid/net/wifi/WifiApConfigStore;)Lcom/android/internal/util/State;

    move-result-object v1

    #calls: Landroid/net/wifi/WifiApConfigStore;->transitionTo(Lcom/android/internal/util/IState;)V
    invoke-static {v0, v1}, Landroid/net/wifi/WifiApConfigStore;->access$700(Landroid/net/wifi/WifiApConfigStore;Lcom/android/internal/util/IState;)V

    goto :goto_c

    .line 124
    :pswitch_data_1a
    .packed-switch 0x20019
        :pswitch_7
        :pswitch_e
    .end packed-switch
.end method
