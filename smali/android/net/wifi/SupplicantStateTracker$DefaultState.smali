.class Landroid/net/wifi/SupplicantStateTracker$DefaultState;
.super Lcom/android/internal/util/State;
.source "SupplicantStateTracker.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/wifi/SupplicantStateTracker;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "DefaultState"
.end annotation


# instance fields
.field final synthetic this$0:Landroid/net/wifi/SupplicantStateTracker;


# direct methods
.method constructor <init>(Landroid/net/wifi/SupplicantStateTracker;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Landroid/net/wifi/SupplicantStateTracker$DefaultState;->this$0:Landroid/net/wifi/SupplicantStateTracker;

    invoke-direct {p0}, Lcom/android/internal/util/State;-><init>()V

    return-void
.end method


# virtual methods
.method public enter()V
    .registers 1

    .prologue
    return-void
.end method

.method public processMessage(Landroid/os/Message;)Z
    .registers 8
    .parameter "message"

    .prologue
    const/4 v5, 0x1

    iget v2, p1, Landroid/os/Message;->what:I

    sparse-switch v2, :sswitch_data_5a

    const-string v2, "SupplicantStateTracker"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Ignoring "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    :goto_1e
    return v5

    :sswitch_1f
    iget-object v2, p0, Landroid/net/wifi/SupplicantStateTracker$DefaultState;->this$0:Landroid/net/wifi/SupplicantStateTracker;

    invoke-static {v2}, Landroid/net/wifi/SupplicantStateTracker;->access$008(Landroid/net/wifi/SupplicantStateTracker;)I

    iget-object v2, p0, Landroid/net/wifi/SupplicantStateTracker$DefaultState;->this$0:Landroid/net/wifi/SupplicantStateTracker;

    #setter for: Landroid/net/wifi/SupplicantStateTracker;->mAuthFailureInSupplicantBroadcast:Z
    invoke-static {v2, v5}, Landroid/net/wifi/SupplicantStateTracker;->access$102(Landroid/net/wifi/SupplicantStateTracker;Z)Z

    goto :goto_1e

    :sswitch_2a
    iget-object v1, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v1, Landroid/net/wifi/StateChangeResult;

    .local v1, stateChangeResult:Landroid/net/wifi/StateChangeResult;
    iget-object v0, v1, Landroid/net/wifi/StateChangeResult;->state:Landroid/net/wifi/SupplicantState;

    .local v0, state:Landroid/net/wifi/SupplicantState;
    iget-object v2, p0, Landroid/net/wifi/SupplicantStateTracker$DefaultState;->this$0:Landroid/net/wifi/SupplicantStateTracker;

    iget-object v3, p0, Landroid/net/wifi/SupplicantStateTracker$DefaultState;->this$0:Landroid/net/wifi/SupplicantStateTracker;

    #getter for: Landroid/net/wifi/SupplicantStateTracker;->mAuthFailureInSupplicantBroadcast:Z
    invoke-static {v3}, Landroid/net/wifi/SupplicantStateTracker;->access$100(Landroid/net/wifi/SupplicantStateTracker;)Z

    move-result v3

    #calls: Landroid/net/wifi/SupplicantStateTracker;->sendSupplicantStateChangedBroadcast(Landroid/net/wifi/SupplicantState;Z)V
    invoke-static {v2, v0, v3}, Landroid/net/wifi/SupplicantStateTracker;->access$200(Landroid/net/wifi/SupplicantStateTracker;Landroid/net/wifi/SupplicantState;Z)V

    iget-object v2, p0, Landroid/net/wifi/SupplicantStateTracker$DefaultState;->this$0:Landroid/net/wifi/SupplicantStateTracker;

    const/4 v3, 0x0

    #setter for: Landroid/net/wifi/SupplicantStateTracker;->mAuthFailureInSupplicantBroadcast:Z
    invoke-static {v2, v3}, Landroid/net/wifi/SupplicantStateTracker;->access$102(Landroid/net/wifi/SupplicantStateTracker;Z)Z

    iget-object v2, p0, Landroid/net/wifi/SupplicantStateTracker$DefaultState;->this$0:Landroid/net/wifi/SupplicantStateTracker;

    #calls: Landroid/net/wifi/SupplicantStateTracker;->transitionOnSupplicantStateChange(Landroid/net/wifi/StateChangeResult;)V
    invoke-static {v2, v1}, Landroid/net/wifi/SupplicantStateTracker;->access$300(Landroid/net/wifi/SupplicantStateTracker;Landroid/net/wifi/StateChangeResult;)V

    goto :goto_1e

    .end local v0           #state:Landroid/net/wifi/SupplicantState;
    .end local v1           #stateChangeResult:Landroid/net/wifi/StateChangeResult;
    :sswitch_47
    iget-object v2, p0, Landroid/net/wifi/SupplicantStateTracker$DefaultState;->this$0:Landroid/net/wifi/SupplicantStateTracker;

    iget-object v3, p0, Landroid/net/wifi/SupplicantStateTracker$DefaultState;->this$0:Landroid/net/wifi/SupplicantStateTracker;

    #getter for: Landroid/net/wifi/SupplicantStateTracker;->mUninitializedState:Lcom/android/internal/util/State;
    invoke-static {v3}, Landroid/net/wifi/SupplicantStateTracker;->access$400(Landroid/net/wifi/SupplicantStateTracker;)Lcom/android/internal/util/State;

    move-result-object v3

    #calls: Landroid/net/wifi/SupplicantStateTracker;->transitionTo(Lcom/android/internal/util/IState;)V
    invoke-static {v2, v3}, Landroid/net/wifi/SupplicantStateTracker;->access$500(Landroid/net/wifi/SupplicantStateTracker;Lcom/android/internal/util/IState;)V

    goto :goto_1e

    :sswitch_53
    iget-object v2, p0, Landroid/net/wifi/SupplicantStateTracker$DefaultState;->this$0:Landroid/net/wifi/SupplicantStateTracker;

    #setter for: Landroid/net/wifi/SupplicantStateTracker;->mNetworksDisabledDuringConnect:Z
    invoke-static {v2, v5}, Landroid/net/wifi/SupplicantStateTracker;->access$602(Landroid/net/wifi/SupplicantStateTracker;Z)Z

    goto :goto_1e

    nop

    :sswitch_data_5a
    .sparse-switch
        0x2006f -> :sswitch_47
        0x24006 -> :sswitch_2a
        0x24007 -> :sswitch_1f
        0x25001 -> :sswitch_53
    .end sparse-switch
.end method
