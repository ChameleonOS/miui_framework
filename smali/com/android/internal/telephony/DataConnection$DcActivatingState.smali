.class Lcom/android/internal/telephony/DataConnection$DcActivatingState;
.super Lcom/android/internal/util/State;
.source "DataConnection.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/telephony/DataConnection;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "DcActivatingState"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/internal/telephony/DataConnection;


# direct methods
.method private constructor <init>(Lcom/android/internal/telephony/DataConnection;)V
    .registers 2
    .parameter

    .prologue
    .line 905
    iput-object p1, p0, Lcom/android/internal/telephony/DataConnection$DcActivatingState;->this$0:Lcom/android/internal/telephony/DataConnection;

    invoke-direct {p0}, Lcom/android/internal/util/State;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/android/internal/telephony/DataConnection;Lcom/android/internal/telephony/DataConnection$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 905
    invoke-direct {p0, p1}, Lcom/android/internal/telephony/DataConnection$DcActivatingState;-><init>(Lcom/android/internal/telephony/DataConnection;)V

    return-void
.end method


# virtual methods
.method public processMessage(Landroid/os/Message;)Z
    .registers 12
    .parameter "msg"

    .prologue
    const/4 v9, -0x1

    .line 912
    iget v6, p1, Landroid/os/Message;->what:I

    packed-switch v6, :pswitch_data_146

    .line 996
    const/4 v4, 0x0

    .line 999
    .local v4, retVal:Z
    :goto_7
    return v4

    .line 914
    .end local v4           #retVal:Z
    :pswitch_8
    iget-object v6, p0, Lcom/android/internal/telephony/DataConnection$DcActivatingState;->this$0:Lcom/android/internal/telephony/DataConnection;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "DcActivatingState deferring msg.what=EVENT_CONNECT refCount = "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-object v8, p0, Lcom/android/internal/telephony/DataConnection$DcActivatingState;->this$0:Lcom/android/internal/telephony/DataConnection;

    iget v8, v8, Lcom/android/internal/telephony/DataConnection;->mRefCount:I

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/android/internal/telephony/DataConnection;->log(Ljava/lang/String;)V

    .line 916
    iget-object v6, p0, Lcom/android/internal/telephony/DataConnection$DcActivatingState;->this$0:Lcom/android/internal/telephony/DataConnection;

    #calls: Lcom/android/internal/telephony/DataConnection;->deferMessage(Landroid/os/Message;)V
    invoke-static {v6, p1}, Lcom/android/internal/telephony/DataConnection;->access$1300(Lcom/android/internal/telephony/DataConnection;Landroid/os/Message;)V

    .line 917
    const/4 v4, 0x1

    .line 918
    .restart local v4       #retVal:Z
    goto :goto_7

    .line 921
    .end local v4           #retVal:Z
    :pswitch_2b
    iget-object v6, p0, Lcom/android/internal/telephony/DataConnection$DcActivatingState;->this$0:Lcom/android/internal/telephony/DataConnection;

    const-string v7, "DcActivatingState msg.what=EVENT_SETUP_DATA_CONNECTION_DONE"

    invoke-virtual {v6, v7}, Lcom/android/internal/telephony/DataConnection;->log(Ljava/lang/String;)V

    .line 923
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Landroid/os/AsyncResult;

    .line 924
    .local v0, ar:Landroid/os/AsyncResult;
    iget-object v2, v0, Landroid/os/AsyncResult;->userObj:Ljava/lang/Object;

    check-cast v2, Lcom/android/internal/telephony/DataConnection$ConnectionParams;

    .line 926
    .local v2, cp:Lcom/android/internal/telephony/DataConnection$ConnectionParams;
    iget-object v6, p0, Lcom/android/internal/telephony/DataConnection$DcActivatingState;->this$0:Lcom/android/internal/telephony/DataConnection;

    #calls: Lcom/android/internal/telephony/DataConnection;->onSetupConnectionCompleted(Landroid/os/AsyncResult;)Lcom/android/internal/telephony/DataCallState$SetupResult;
    invoke-static {v6, v0}, Lcom/android/internal/telephony/DataConnection;->access$1400(Lcom/android/internal/telephony/DataConnection;Landroid/os/AsyncResult;)Lcom/android/internal/telephony/DataCallState$SetupResult;

    move-result-object v3

    .line 927
    .local v3, result:Lcom/android/internal/telephony/DataCallState$SetupResult;
    iget-object v6, p0, Lcom/android/internal/telephony/DataConnection$DcActivatingState;->this$0:Lcom/android/internal/telephony/DataConnection;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "DcActivatingState onSetupConnectionCompleted result="

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/android/internal/telephony/DataConnection;->log(Ljava/lang/String;)V

    .line 928
    sget-object v6, Lcom/android/internal/telephony/DataConnection$1;->$SwitchMap$com$android$internal$telephony$DataCallState$SetupResult:[I

    invoke-virtual {v3}, Lcom/android/internal/telephony/DataCallState$SetupResult;->ordinal()I

    move-result v7

    aget v6, v6, v7

    packed-switch v6, :pswitch_data_150

    .line 961
    new-instance v6, Ljava/lang/RuntimeException;

    const-string v7, "Unknown SetupResult, should not happen"

    invoke-direct {v6, v7}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 931
    :pswitch_6b
    iget-object v6, p0, Lcom/android/internal/telephony/DataConnection$DcActivatingState;->this$0:Lcom/android/internal/telephony/DataConnection;

    #getter for: Lcom/android/internal/telephony/DataConnection;->mActiveState:Lcom/android/internal/telephony/DataConnection$DcActiveState;
    invoke-static {v6}, Lcom/android/internal/telephony/DataConnection;->access$1500(Lcom/android/internal/telephony/DataConnection;)Lcom/android/internal/telephony/DataConnection$DcActiveState;

    move-result-object v6

    sget-object v7, Lcom/android/internal/telephony/DataConnection$FailCause;->NONE:Lcom/android/internal/telephony/DataConnection$FailCause;

    invoke-virtual {v6, v2, v7}, Lcom/android/internal/telephony/DataConnection$DcActiveState;->setEnterNotificationParams(Lcom/android/internal/telephony/DataConnection$ConnectionParams;Lcom/android/internal/telephony/DataConnection$FailCause;)V

    .line 932
    iget-object v6, p0, Lcom/android/internal/telephony/DataConnection$DcActivatingState;->this$0:Lcom/android/internal/telephony/DataConnection;

    iget-object v7, p0, Lcom/android/internal/telephony/DataConnection$DcActivatingState;->this$0:Lcom/android/internal/telephony/DataConnection;

    #getter for: Lcom/android/internal/telephony/DataConnection;->mActiveState:Lcom/android/internal/telephony/DataConnection$DcActiveState;
    invoke-static {v7}, Lcom/android/internal/telephony/DataConnection;->access$1500(Lcom/android/internal/telephony/DataConnection;)Lcom/android/internal/telephony/DataConnection$DcActiveState;

    move-result-object v7

    #calls: Lcom/android/internal/telephony/DataConnection;->transitionTo(Lcom/android/internal/util/IState;)V
    invoke-static {v6, v7}, Lcom/android/internal/telephony/DataConnection;->access$1600(Lcom/android/internal/telephony/DataConnection;Lcom/android/internal/util/IState;)V

    .line 963
    :goto_81
    :pswitch_81
    const/4 v4, 0x1

    .line 964
    .restart local v4       #retVal:Z
    goto :goto_7

    .line 938
    .end local v4           #retVal:Z
    :pswitch_83
    iget-object v6, p0, Lcom/android/internal/telephony/DataConnection$DcActivatingState;->this$0:Lcom/android/internal/telephony/DataConnection;

    #getter for: Lcom/android/internal/telephony/DataConnection;->mInactiveState:Lcom/android/internal/telephony/DataConnection$DcInactiveState;
    invoke-static {v6}, Lcom/android/internal/telephony/DataConnection;->access$200(Lcom/android/internal/telephony/DataConnection;)Lcom/android/internal/telephony/DataConnection$DcInactiveState;

    move-result-object v6

    iget-object v7, v3, Lcom/android/internal/telephony/DataCallState$SetupResult;->mFailCause:Lcom/android/internal/telephony/DataConnection$FailCause;

    invoke-virtual {v6, v2, v7, v9}, Lcom/android/internal/telephony/DataConnection$DcInactiveState;->setEnterNotificationParams(Lcom/android/internal/telephony/DataConnection$ConnectionParams;Lcom/android/internal/telephony/DataConnection$FailCause;I)V

    .line 939
    iget-object v6, p0, Lcom/android/internal/telephony/DataConnection$DcActivatingState;->this$0:Lcom/android/internal/telephony/DataConnection;

    iget-object v7, p0, Lcom/android/internal/telephony/DataConnection$DcActivatingState;->this$0:Lcom/android/internal/telephony/DataConnection;

    #getter for: Lcom/android/internal/telephony/DataConnection;->mInactiveState:Lcom/android/internal/telephony/DataConnection$DcInactiveState;
    invoke-static {v7}, Lcom/android/internal/telephony/DataConnection;->access$200(Lcom/android/internal/telephony/DataConnection;)Lcom/android/internal/telephony/DataConnection$DcInactiveState;

    move-result-object v7

    #calls: Lcom/android/internal/telephony/DataConnection;->transitionTo(Lcom/android/internal/util/IState;)V
    invoke-static {v6, v7}, Lcom/android/internal/telephony/DataConnection;->access$1700(Lcom/android/internal/telephony/DataConnection;Lcom/android/internal/util/IState;)V

    goto :goto_81

    .line 943
    :pswitch_9a
    iget-object v6, p0, Lcom/android/internal/telephony/DataConnection$DcActivatingState;->this$0:Lcom/android/internal/telephony/DataConnection;

    #calls: Lcom/android/internal/telephony/DataConnection;->tearDownData(Ljava/lang/Object;)V
    invoke-static {v6, v2}, Lcom/android/internal/telephony/DataConnection;->access$1800(Lcom/android/internal/telephony/DataConnection;Ljava/lang/Object;)V

    .line 944
    iget-object v6, p0, Lcom/android/internal/telephony/DataConnection$DcActivatingState;->this$0:Lcom/android/internal/telephony/DataConnection;

    iget-object v7, p0, Lcom/android/internal/telephony/DataConnection$DcActivatingState;->this$0:Lcom/android/internal/telephony/DataConnection;

    #getter for: Lcom/android/internal/telephony/DataConnection;->mDisconnectingErrorCreatingConnection:Lcom/android/internal/telephony/DataConnection$DcDisconnectionErrorCreatingConnection;
    invoke-static {v7}, Lcom/android/internal/telephony/DataConnection;->access$1900(Lcom/android/internal/telephony/DataConnection;)Lcom/android/internal/telephony/DataConnection$DcDisconnectionErrorCreatingConnection;

    move-result-object v7

    #calls: Lcom/android/internal/telephony/DataConnection;->transitionTo(Lcom/android/internal/util/IState;)V
    invoke-static {v6, v7}, Lcom/android/internal/telephony/DataConnection;->access$2000(Lcom/android/internal/telephony/DataConnection;Lcom/android/internal/util/IState;)V

    goto :goto_81

    .line 948
    :pswitch_ab
    iget-object v6, p0, Lcom/android/internal/telephony/DataConnection$DcActivatingState;->this$0:Lcom/android/internal/telephony/DataConnection;

    iget-object v6, v6, Lcom/android/internal/telephony/DataConnection;->phone:Lcom/android/internal/telephony/PhoneBase;

    iget-object v6, v6, Lcom/android/internal/telephony/PhoneBase;->mCM:Lcom/android/internal/telephony/CommandsInterface;

    iget-object v7, p0, Lcom/android/internal/telephony/DataConnection$DcActivatingState;->this$0:Lcom/android/internal/telephony/DataConnection;

    const v8, 0x40002

    invoke-virtual {v7, v8, v2}, Lcom/android/internal/telephony/DataConnection;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v7

    invoke-interface {v6, v7}, Lcom/android/internal/telephony/CommandsInterface;->getLastDataCallFailCause(Landroid/os/Message;)V

    goto :goto_81

    .line 953
    :pswitch_be
    iget-object v6, p0, Lcom/android/internal/telephony/DataConnection$DcActivatingState;->this$0:Lcom/android/internal/telephony/DataConnection;

    #getter for: Lcom/android/internal/telephony/DataConnection;->mInactiveState:Lcom/android/internal/telephony/DataConnection$DcInactiveState;
    invoke-static {v6}, Lcom/android/internal/telephony/DataConnection;->access$200(Lcom/android/internal/telephony/DataConnection;)Lcom/android/internal/telephony/DataConnection$DcInactiveState;

    move-result-object v6

    iget-object v7, v3, Lcom/android/internal/telephony/DataCallState$SetupResult;->mFailCause:Lcom/android/internal/telephony/DataConnection$FailCause;

    iget-object v8, p0, Lcom/android/internal/telephony/DataConnection$DcActivatingState;->this$0:Lcom/android/internal/telephony/DataConnection;

    #calls: Lcom/android/internal/telephony/DataConnection;->getSuggestedRetryTime(Landroid/os/AsyncResult;)I
    invoke-static {v8, v0}, Lcom/android/internal/telephony/DataConnection;->access$2100(Lcom/android/internal/telephony/DataConnection;Landroid/os/AsyncResult;)I

    move-result v8

    invoke-virtual {v6, v2, v7, v8}, Lcom/android/internal/telephony/DataConnection$DcInactiveState;->setEnterNotificationParams(Lcom/android/internal/telephony/DataConnection$ConnectionParams;Lcom/android/internal/telephony/DataConnection$FailCause;I)V

    .line 955
    iget-object v6, p0, Lcom/android/internal/telephony/DataConnection$DcActivatingState;->this$0:Lcom/android/internal/telephony/DataConnection;

    iget-object v7, p0, Lcom/android/internal/telephony/DataConnection$DcActivatingState;->this$0:Lcom/android/internal/telephony/DataConnection;

    #getter for: Lcom/android/internal/telephony/DataConnection;->mInactiveState:Lcom/android/internal/telephony/DataConnection$DcInactiveState;
    invoke-static {v7}, Lcom/android/internal/telephony/DataConnection;->access$200(Lcom/android/internal/telephony/DataConnection;)Lcom/android/internal/telephony/DataConnection$DcInactiveState;

    move-result-object v7

    #calls: Lcom/android/internal/telephony/DataConnection;->transitionTo(Lcom/android/internal/util/IState;)V
    invoke-static {v6, v7}, Lcom/android/internal/telephony/DataConnection;->access$2200(Lcom/android/internal/telephony/DataConnection;Lcom/android/internal/util/IState;)V

    goto :goto_81

    .line 967
    .end local v0           #ar:Landroid/os/AsyncResult;
    .end local v2           #cp:Lcom/android/internal/telephony/DataConnection$ConnectionParams;
    .end local v3           #result:Lcom/android/internal/telephony/DataCallState$SetupResult;
    :pswitch_db
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Landroid/os/AsyncResult;

    .line 968
    .restart local v0       #ar:Landroid/os/AsyncResult;
    iget-object v2, v0, Landroid/os/AsyncResult;->userObj:Ljava/lang/Object;

    check-cast v2, Lcom/android/internal/telephony/DataConnection$ConnectionParams;

    .line 969
    .restart local v2       #cp:Lcom/android/internal/telephony/DataConnection$ConnectionParams;
    sget-object v1, Lcom/android/internal/telephony/DataConnection$FailCause;->UNKNOWN:Lcom/android/internal/telephony/DataConnection$FailCause;

    .line 971
    .local v1, cause:Lcom/android/internal/telephony/DataConnection$FailCause;
    iget v6, v2, Lcom/android/internal/telephony/DataConnection$ConnectionParams;->tag:I

    iget-object v7, p0, Lcom/android/internal/telephony/DataConnection$DcActivatingState;->this$0:Lcom/android/internal/telephony/DataConnection;

    iget v7, v7, Lcom/android/internal/telephony/DataConnection;->mTag:I

    if-ne v6, v7, :cond_11c

    .line 972
    iget-object v6, p0, Lcom/android/internal/telephony/DataConnection$DcActivatingState;->this$0:Lcom/android/internal/telephony/DataConnection;

    const-string v7, "DcActivatingState msg.what=EVENT_GET_LAST_FAIL_DONE"

    invoke-virtual {v6, v7}, Lcom/android/internal/telephony/DataConnection;->log(Ljava/lang/String;)V

    .line 973
    iget-object v6, v0, Landroid/os/AsyncResult;->exception:Ljava/lang/Throwable;

    if-nez v6, :cond_105

    .line 974
    iget-object v6, v0, Landroid/os/AsyncResult;->result:Ljava/lang/Object;

    check-cast v6, [I

    check-cast v6, [I

    const/4 v7, 0x0

    aget v5, v6, v7

    .line 975
    .local v5, rilFailCause:I
    invoke-static {v5}, Lcom/android/internal/telephony/DataConnection$FailCause;->fromInt(I)Lcom/android/internal/telephony/DataConnection$FailCause;

    move-result-object v1

    .line 979
    .end local v5           #rilFailCause:I
    :cond_105
    iget-object v6, p0, Lcom/android/internal/telephony/DataConnection$DcActivatingState;->this$0:Lcom/android/internal/telephony/DataConnection;

    #getter for: Lcom/android/internal/telephony/DataConnection;->mInactiveState:Lcom/android/internal/telephony/DataConnection$DcInactiveState;
    invoke-static {v6}, Lcom/android/internal/telephony/DataConnection;->access$200(Lcom/android/internal/telephony/DataConnection;)Lcom/android/internal/telephony/DataConnection$DcInactiveState;

    move-result-object v6

    invoke-virtual {v6, v2, v1, v9}, Lcom/android/internal/telephony/DataConnection$DcInactiveState;->setEnterNotificationParams(Lcom/android/internal/telephony/DataConnection$ConnectionParams;Lcom/android/internal/telephony/DataConnection$FailCause;I)V

    .line 980
    iget-object v6, p0, Lcom/android/internal/telephony/DataConnection$DcActivatingState;->this$0:Lcom/android/internal/telephony/DataConnection;

    iget-object v7, p0, Lcom/android/internal/telephony/DataConnection$DcActivatingState;->this$0:Lcom/android/internal/telephony/DataConnection;

    #getter for: Lcom/android/internal/telephony/DataConnection;->mInactiveState:Lcom/android/internal/telephony/DataConnection$DcInactiveState;
    invoke-static {v7}, Lcom/android/internal/telephony/DataConnection;->access$200(Lcom/android/internal/telephony/DataConnection;)Lcom/android/internal/telephony/DataConnection$DcInactiveState;

    move-result-object v7

    #calls: Lcom/android/internal/telephony/DataConnection;->transitionTo(Lcom/android/internal/util/IState;)V
    invoke-static {v6, v7}, Lcom/android/internal/telephony/DataConnection;->access$2300(Lcom/android/internal/telephony/DataConnection;Lcom/android/internal/util/IState;)V

    .line 988
    :goto_119
    const/4 v4, 0x1

    .line 989
    .restart local v4       #retVal:Z
    goto/16 :goto_7

    .line 983
    .end local v4           #retVal:Z
    :cond_11c
    iget-object v6, p0, Lcom/android/internal/telephony/DataConnection$DcActivatingState;->this$0:Lcom/android/internal/telephony/DataConnection;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "DcActivatingState EVENT_GET_LAST_FAIL_DONE is stale cp.tag="

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget v8, v2, Lcom/android/internal/telephony/DataConnection$ConnectionParams;->tag:I

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ", mTag="

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-object v8, p0, Lcom/android/internal/telephony/DataConnection$DcActivatingState;->this$0:Lcom/android/internal/telephony/DataConnection;

    iget v8, v8, Lcom/android/internal/telephony/DataConnection;->mTag:I

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/android/internal/telephony/DataConnection;->log(Ljava/lang/String;)V

    goto :goto_119

    .line 912
    nop

    :pswitch_data_146
    .packed-switch 0x40000
        :pswitch_8
        :pswitch_2b
        :pswitch_db
    .end packed-switch

    .line 928
    :pswitch_data_150
    .packed-switch 0x1
        :pswitch_6b
        :pswitch_83
        :pswitch_9a
        :pswitch_ab
        :pswitch_be
        :pswitch_81
    .end packed-switch
.end method
