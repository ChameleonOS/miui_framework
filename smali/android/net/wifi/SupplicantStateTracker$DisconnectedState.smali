.class Landroid/net/wifi/SupplicantStateTracker$DisconnectedState;
.super Lcom/android/internal/util/State;
.source "SupplicantStateTracker.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/wifi/SupplicantStateTracker;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "DisconnectedState"
.end annotation


# instance fields
.field final synthetic this$0:Landroid/net/wifi/SupplicantStateTracker;


# direct methods
.method constructor <init>(Landroid/net/wifi/SupplicantStateTracker;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Landroid/net/wifi/SupplicantStateTracker$DisconnectedState;->this$0:Landroid/net/wifi/SupplicantStateTracker;

    invoke-direct {p0}, Lcom/android/internal/util/State;-><init>()V

    return-void
.end method


# virtual methods
.method public enter()V
    .registers 6

    .prologue
    iget-object v2, p0, Landroid/net/wifi/SupplicantStateTracker$DisconnectedState;->this$0:Landroid/net/wifi/SupplicantStateTracker;

    #calls: Landroid/net/wifi/SupplicantStateTracker;->getCurrentMessage()Landroid/os/Message;
    invoke-static {v2}, Landroid/net/wifi/SupplicantStateTracker;->access$700(Landroid/net/wifi/SupplicantStateTracker;)Landroid/os/Message;

    move-result-object v0

    .local v0, message:Landroid/os/Message;
    iget-object v1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v1, Landroid/net/wifi/StateChangeResult;

    .local v1, stateChangeResult:Landroid/net/wifi/StateChangeResult;
    iget-object v2, p0, Landroid/net/wifi/SupplicantStateTracker$DisconnectedState;->this$0:Landroid/net/wifi/SupplicantStateTracker;

    #getter for: Landroid/net/wifi/SupplicantStateTracker;->mAuthenticationFailuresCount:I
    invoke-static {v2}, Landroid/net/wifi/SupplicantStateTracker;->access$000(Landroid/net/wifi/SupplicantStateTracker;)I

    move-result v2

    const/4 v3, 0x2

    if-lt v2, v3, :cond_3a

    const-string v2, "SupplicantStateTracker"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Failed to authenticate, disabling network "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget v4, v1, Landroid/net/wifi/StateChangeResult;->networkId:I

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    iget-object v2, p0, Landroid/net/wifi/SupplicantStateTracker$DisconnectedState;->this$0:Landroid/net/wifi/SupplicantStateTracker;

    iget v3, v1, Landroid/net/wifi/StateChangeResult;->networkId:I

    #calls: Landroid/net/wifi/SupplicantStateTracker;->handleNetworkConnectionFailure(I)V
    invoke-static {v2, v3}, Landroid/net/wifi/SupplicantStateTracker;->access$800(Landroid/net/wifi/SupplicantStateTracker;I)V

    iget-object v2, p0, Landroid/net/wifi/SupplicantStateTracker$DisconnectedState;->this$0:Landroid/net/wifi/SupplicantStateTracker;

    const/4 v3, 0x0

    #setter for: Landroid/net/wifi/SupplicantStateTracker;->mAuthenticationFailuresCount:I
    invoke-static {v2, v3}, Landroid/net/wifi/SupplicantStateTracker;->access$002(Landroid/net/wifi/SupplicantStateTracker;I)I

    :cond_3a
    return-void
.end method
