.class public final Lcom/android/internal/telephony/test/SimulatedCommands;
.super Lcom/android/internal/telephony/BaseCommands;
.source "SimulatedCommands.java"

# interfaces
.implements Lcom/android/internal/telephony/CommandsInterface;
.implements Lcom/android/internal/telephony/test/SimulatedRadioControl;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/internal/telephony/test/SimulatedCommands$SimFdnState;,
        Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;
    }
.end annotation


# static fields
.field private static final DEFAULT_SIM_PIN2_CODE:Ljava/lang/String; = "5678"

.field private static final DEFAULT_SIM_PIN_CODE:Ljava/lang/String; = "1234"

.field private static final INITIAL_FDN_STATE:Lcom/android/internal/telephony/test/SimulatedCommands$SimFdnState; = null

.field private static final INITIAL_LOCK_STATE:Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState; = null

.field private static final LOG_TAG:Ljava/lang/String; = "SIM"

.field private static final SIM_PUK2_CODE:Ljava/lang/String; = "87654321"

.field private static final SIM_PUK_CODE:Ljava/lang/String; = "12345678"


# instance fields
.field mHandlerThread:Landroid/os/HandlerThread;

.field mNetworkType:I

.field mPin2Code:Ljava/lang/String;

.field mPin2UnlockAttempts:I

.field mPinCode:Ljava/lang/String;

.field mPinUnlockAttempts:I

.field mPuk2UnlockAttempts:I

.field mPukUnlockAttempts:I

.field mSimFdnEnabled:Z

.field mSimFdnEnabledState:Lcom/android/internal/telephony/test/SimulatedCommands$SimFdnState;

.field mSimLockEnabled:Z

.field mSimLockedState:Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;

.field mSsnNotifyOn:Z

.field nextCallFailCause:I

.field pausedResponseCount:I

.field pausedResponses:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/os/Message;",
            ">;"
        }
    .end annotation
.end field

.field simulatedCallState:Lcom/android/internal/telephony/test/SimulatedGsmCallState;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    sget-object v0, Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;->NONE:Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;

    sput-object v0, Lcom/android/internal/telephony/test/SimulatedCommands;->INITIAL_LOCK_STATE:Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;

    sget-object v0, Lcom/android/internal/telephony/test/SimulatedCommands$SimFdnState;->NONE:Lcom/android/internal/telephony/test/SimulatedCommands$SimFdnState;

    sput-object v0, Lcom/android/internal/telephony/test/SimulatedCommands;->INITIAL_FDN_STATE:Lcom/android/internal/telephony/test/SimulatedCommands$SimFdnState;

    return-void
.end method

.method public constructor <init>()V
    .registers 6

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    const/4 v1, 0x0

    invoke-direct {p0, v1}, Lcom/android/internal/telephony/BaseCommands;-><init>(Landroid/content/Context;)V

    iput-boolean v3, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mSsnNotifyOn:Z

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->pausedResponses:Ljava/util/ArrayList;

    const/16 v1, 0x10

    iput v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->nextCallFailCause:I

    new-instance v1, Landroid/os/HandlerThread;

    const-string v4, "SimulatedCommands"

    invoke-direct {v1, v4}, Landroid/os/HandlerThread;-><init>(Ljava/lang/String;)V

    iput-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mHandlerThread:Landroid/os/HandlerThread;

    iget-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mHandlerThread:Landroid/os/HandlerThread;

    invoke-virtual {v1}, Landroid/os/HandlerThread;->start()V

    iget-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mHandlerThread:Landroid/os/HandlerThread;

    invoke-virtual {v1}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;

    move-result-object v0

    .local v0, looper:Landroid/os/Looper;
    new-instance v1, Lcom/android/internal/telephony/test/SimulatedGsmCallState;

    invoke-direct {v1, v0}, Lcom/android/internal/telephony/test/SimulatedGsmCallState;-><init>(Landroid/os/Looper;)V

    iput-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->simulatedCallState:Lcom/android/internal/telephony/test/SimulatedGsmCallState;

    sget-object v1, Lcom/android/internal/telephony/CommandsInterface$RadioState;->RADIO_OFF:Lcom/android/internal/telephony/CommandsInterface$RadioState;

    invoke-virtual {p0, v1}, Lcom/android/internal/telephony/test/SimulatedCommands;->setRadioState(Lcom/android/internal/telephony/CommandsInterface$RadioState;)V

    sget-object v1, Lcom/android/internal/telephony/test/SimulatedCommands;->INITIAL_LOCK_STATE:Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;

    iput-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mSimLockedState:Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;

    iget-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mSimLockedState:Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;

    sget-object v4, Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;->NONE:Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;

    if-eq v1, v4, :cond_55

    move v1, v2

    :goto_3e
    iput-boolean v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mSimLockEnabled:Z

    const-string v1, "1234"

    iput-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mPinCode:Ljava/lang/String;

    sget-object v1, Lcom/android/internal/telephony/test/SimulatedCommands;->INITIAL_FDN_STATE:Lcom/android/internal/telephony/test/SimulatedCommands$SimFdnState;

    iput-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mSimFdnEnabledState:Lcom/android/internal/telephony/test/SimulatedCommands$SimFdnState;

    iget-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mSimFdnEnabledState:Lcom/android/internal/telephony/test/SimulatedCommands$SimFdnState;

    sget-object v4, Lcom/android/internal/telephony/test/SimulatedCommands$SimFdnState;->NONE:Lcom/android/internal/telephony/test/SimulatedCommands$SimFdnState;

    if-eq v1, v4, :cond_57

    :goto_4e
    iput-boolean v2, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mSimFdnEnabled:Z

    const-string v1, "5678"

    iput-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mPin2Code:Ljava/lang/String;

    return-void

    :cond_55
    move v1, v3

    goto :goto_3e

    :cond_57
    move v2, v3

    goto :goto_4e
.end method

.method private isSimLocked()Z
    .registers 3

    .prologue
    iget-object v0, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mSimLockedState:Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;

    sget-object v1, Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;->NONE:Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;

    if-eq v0, v1, :cond_8

    const/4 v0, 0x1

    :goto_7
    return v0

    :cond_8
    const/4 v0, 0x0

    goto :goto_7
.end method

.method private resultFail(Landroid/os/Message;Ljava/lang/Throwable;)V
    .registers 4
    .parameter "result"
    .parameter "tr"

    .prologue
    if-eqz p1, :cond_11

    invoke-static {p1}, Landroid/os/AsyncResult;->forMessage(Landroid/os/Message;)Landroid/os/AsyncResult;

    move-result-object v0

    iput-object p2, v0, Landroid/os/AsyncResult;->exception:Ljava/lang/Throwable;

    iget v0, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->pausedResponseCount:I

    if-lez v0, :cond_12

    iget-object v0, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->pausedResponses:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_11
    :goto_11
    return-void

    :cond_12
    invoke-virtual {p1}, Landroid/os/Message;->sendToTarget()V

    goto :goto_11
.end method

.method private resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V
    .registers 4
    .parameter "result"
    .parameter "ret"

    .prologue
    if-eqz p1, :cond_11

    invoke-static {p1}, Landroid/os/AsyncResult;->forMessage(Landroid/os/Message;)Landroid/os/AsyncResult;

    move-result-object v0

    iput-object p2, v0, Landroid/os/AsyncResult;->result:Ljava/lang/Object;

    iget v0, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->pausedResponseCount:I

    if-lez v0, :cond_12

    iget-object v0, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->pausedResponses:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_11
    :goto_11
    return-void

    :cond_12
    invoke-virtual {p1}, Landroid/os/Message;->sendToTarget()V

    goto :goto_11
.end method

.method private unimplemented(Landroid/os/Message;)V
    .registers 5
    .parameter "result"

    .prologue
    if-eqz p1, :cond_18

    invoke-static {p1}, Landroid/os/AsyncResult;->forMessage(Landroid/os/Message;)Landroid/os/AsyncResult;

    move-result-object v0

    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "Unimplemented"

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    iput-object v1, v0, Landroid/os/AsyncResult;->exception:Ljava/lang/Throwable;

    iget v0, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->pausedResponseCount:I

    if-lez v0, :cond_19

    iget-object v0, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->pausedResponses:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_18
    :goto_18
    return-void

    :cond_19
    invoke-virtual {p1}, Landroid/os/Message;->sendToTarget()V

    goto :goto_18
.end method


# virtual methods
.method public acceptCall(Landroid/os/Message;)V
    .registers 5
    .parameter "result"

    .prologue
    iget-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->simulatedCallState:Lcom/android/internal/telephony/test/SimulatedGsmCallState;

    invoke-virtual {v1}, Lcom/android/internal/telephony/test/SimulatedGsmCallState;->onAnswer()Z

    move-result v0

    .local v0, success:Z
    if-nez v0, :cond_13

    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "Hangup Error"

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    invoke-direct {p0, p1, v1}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultFail(Landroid/os/Message;Ljava/lang/Throwable;)V

    :goto_12
    return-void

    :cond_13
    const/4 v1, 0x0

    invoke-direct {p0, p1, v1}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    goto :goto_12
.end method

.method public acknowledgeIncomingGsmSmsWithPdu(ZLjava/lang/String;Landroid/os/Message;)V
    .registers 4
    .parameter "success"
    .parameter "ackPdu"
    .parameter "result"

    .prologue
    invoke-direct {p0, p3}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public acknowledgeLastIncomingCdmaSms(ZILandroid/os/Message;)V
    .registers 4
    .parameter "success"
    .parameter "cause"
    .parameter "result"

    .prologue
    invoke-direct {p0, p3}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public acknowledgeLastIncomingGsmSms(ZILandroid/os/Message;)V
    .registers 4
    .parameter "success"
    .parameter "cause"
    .parameter "result"

    .prologue
    invoke-direct {p0, p3}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public cancelPendingUssd(Landroid/os/Message;)V
    .registers 3
    .parameter "response"

    .prologue
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    return-void
.end method

.method public changeBarringPassword(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Message;)V
    .registers 5
    .parameter "facility"
    .parameter "oldPwd"
    .parameter "newPwd"
    .parameter "result"

    .prologue
    invoke-direct {p0, p4}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public changeIccPin(Ljava/lang/String;Ljava/lang/String;Landroid/os/Message;)V
    .registers 8
    .parameter "oldPin"
    .parameter "newPin"
    .parameter "result"

    .prologue
    const/4 v3, 0x0

    if-eqz p1, :cond_16

    iget-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mPinCode:Ljava/lang/String;

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_16

    iput-object p2, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mPinCode:Ljava/lang/String;

    if-eqz p3, :cond_15

    invoke-static {p3, v3, v3}, Landroid/os/AsyncResult;->forMessage(Landroid/os/Message;Ljava/lang/Object;Ljava/lang/Throwable;)Landroid/os/AsyncResult;

    invoke-virtual {p3}, Landroid/os/Message;->sendToTarget()V

    :cond_15
    :goto_15
    return-void

    :cond_16
    if-eqz p3, :cond_15

    const-string v1, "SIM"

    const-string v2, "[SimCmd] changeIccPin: pin failed!"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    new-instance v0, Lcom/android/internal/telephony/CommandException;

    sget-object v1, Lcom/android/internal/telephony/CommandException$Error;->PASSWORD_INCORRECT:Lcom/android/internal/telephony/CommandException$Error;

    invoke-direct {v0, v1}, Lcom/android/internal/telephony/CommandException;-><init>(Lcom/android/internal/telephony/CommandException$Error;)V

    .local v0, ex:Lcom/android/internal/telephony/CommandException;
    invoke-static {p3, v3, v0}, Landroid/os/AsyncResult;->forMessage(Landroid/os/Message;Ljava/lang/Object;Ljava/lang/Throwable;)Landroid/os/AsyncResult;

    invoke-virtual {p3}, Landroid/os/Message;->sendToTarget()V

    goto :goto_15
.end method

.method public changeIccPin2(Ljava/lang/String;Ljava/lang/String;Landroid/os/Message;)V
    .registers 8
    .parameter "oldPin2"
    .parameter "newPin2"
    .parameter "result"

    .prologue
    const/4 v3, 0x0

    if-eqz p1, :cond_16

    iget-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mPin2Code:Ljava/lang/String;

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_16

    iput-object p2, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mPin2Code:Ljava/lang/String;

    if-eqz p3, :cond_15

    invoke-static {p3, v3, v3}, Landroid/os/AsyncResult;->forMessage(Landroid/os/Message;Ljava/lang/Object;Ljava/lang/Throwable;)Landroid/os/AsyncResult;

    invoke-virtual {p3}, Landroid/os/Message;->sendToTarget()V

    :cond_15
    :goto_15
    return-void

    :cond_16
    if-eqz p3, :cond_15

    const-string v1, "SIM"

    const-string v2, "[SimCmd] changeIccPin2: pin2 failed!"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    new-instance v0, Lcom/android/internal/telephony/CommandException;

    sget-object v1, Lcom/android/internal/telephony/CommandException$Error;->PASSWORD_INCORRECT:Lcom/android/internal/telephony/CommandException$Error;

    invoke-direct {v0, v1}, Lcom/android/internal/telephony/CommandException;-><init>(Lcom/android/internal/telephony/CommandException$Error;)V

    .local v0, ex:Lcom/android/internal/telephony/CommandException;
    invoke-static {p3, v3, v0}, Landroid/os/AsyncResult;->forMessage(Landroid/os/Message;Ljava/lang/Object;Ljava/lang/Throwable;)Landroid/os/AsyncResult;

    invoke-virtual {p3}, Landroid/os/Message;->sendToTarget()V

    goto :goto_15
.end method

.method public changeIccPin2ForApp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Message;)V
    .registers 5
    .parameter "oldPin2"
    .parameter "newPin2"
    .parameter "aidPtr"
    .parameter "response"

    .prologue
    invoke-direct {p0, p4}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public changeIccPinForApp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Message;)V
    .registers 5
    .parameter "oldPin"
    .parameter "newPin"
    .parameter "aidPtr"
    .parameter "response"

    .prologue
    invoke-direct {p0, p4}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public conference(Landroid/os/Message;)V
    .registers 6
    .parameter "result"

    .prologue
    iget-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->simulatedCallState:Lcom/android/internal/telephony/test/SimulatedGsmCallState;

    const/16 v2, 0x33

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Lcom/android/internal/telephony/test/SimulatedGsmCallState;->onChld(CC)Z

    move-result v0

    .local v0, success:Z
    if-nez v0, :cond_16

    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "Hangup Error"

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    invoke-direct {p0, p1, v1}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultFail(Landroid/os/Message;Ljava/lang/Throwable;)V

    :goto_15
    return-void

    :cond_16
    const/4 v1, 0x0

    invoke-direct {p0, p1, v1}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    goto :goto_15
.end method

.method public deactivateDataCall(IILandroid/os/Message;)V
    .registers 4
    .parameter "cid"
    .parameter "reason"
    .parameter "result"

    .prologue
    invoke-direct {p0, p3}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public deleteSmsOnRuim(ILandroid/os/Message;)V
    .registers 6
    .parameter "index"
    .parameter "response"

    .prologue
    const-string v0, "SIM"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Delete RUIM message at index "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    invoke-direct {p0, p2}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public deleteSmsOnSim(ILandroid/os/Message;)V
    .registers 6
    .parameter "index"
    .parameter "response"

    .prologue
    const-string v0, "SIM"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Delete message at index "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    invoke-direct {p0, p2}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public dial(Ljava/lang/String;ILandroid/os/Message;)V
    .registers 5
    .parameter "address"
    .parameter "clirMode"
    .parameter "result"

    .prologue
    iget-object v0, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->simulatedCallState:Lcom/android/internal/telephony/test/SimulatedGsmCallState;

    invoke-virtual {v0, p1}, Lcom/android/internal/telephony/test/SimulatedGsmCallState;->onDial(Ljava/lang/String;)Z

    const/4 v0, 0x0

    invoke-direct {p0, p3, v0}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    return-void
.end method

.method public dial(Ljava/lang/String;ILcom/android/internal/telephony/UUSInfo;Landroid/os/Message;)V
    .registers 6
    .parameter "address"
    .parameter "clirMode"
    .parameter "uusInfo"
    .parameter "result"

    .prologue
    iget-object v0, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->simulatedCallState:Lcom/android/internal/telephony/test/SimulatedGsmCallState;

    invoke-virtual {v0, p1}, Lcom/android/internal/telephony/test/SimulatedGsmCallState;->onDial(Ljava/lang/String;)Z

    const/4 v0, 0x0

    invoke-direct {p0, p4, v0}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    return-void
.end method

.method public exitEmergencyCallbackMode(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    invoke-direct {p0, p1}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public explicitCallTransfer(Landroid/os/Message;)V
    .registers 6
    .parameter "result"

    .prologue
    iget-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->simulatedCallState:Lcom/android/internal/telephony/test/SimulatedGsmCallState;

    const/16 v2, 0x34

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Lcom/android/internal/telephony/test/SimulatedGsmCallState;->onChld(CC)Z

    move-result v0

    .local v0, success:Z
    if-nez v0, :cond_16

    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "Hangup Error"

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    invoke-direct {p0, p1, v1}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultFail(Landroid/os/Message;Ljava/lang/Throwable;)V

    :goto_15
    return-void

    :cond_16
    const/4 v1, 0x0

    invoke-direct {p0, p1, v1}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    goto :goto_15
.end method

.method public forceDataDormancy(Landroid/os/Message;)V
    .registers 2
    .parameter "response"

    .prologue
    invoke-direct {p0, p1}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public getAvailableNetworks(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    invoke-direct {p0, p1}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public getBasebandVersion(Landroid/os/Message;)V
    .registers 3
    .parameter "result"

    .prologue
    const-string v0, "SimulatedCommands"

    invoke-direct {p0, p1, v0}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    return-void
.end method

.method public getCDMASubscription(Landroid/os/Message;)V
    .registers 4
    .parameter "response"

    .prologue
    const-string v0, "SIM"

    const-string v1, "CDMA not implemented in SimulatedCommands"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    invoke-direct {p0, p1}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public getCLIR(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    invoke-direct {p0, p1}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public getCdmaBroadcastConfig(Landroid/os/Message;)V
    .registers 2
    .parameter "response"

    .prologue
    invoke-direct {p0, p1}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public getCdmaSubscriptionSource(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    invoke-direct {p0, p1}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public getCurrentCalls(Landroid/os/Message;)V
    .registers 4
    .parameter "result"

    .prologue
    iget-object v0, p0, Lcom/android/internal/telephony/BaseCommands;->mState:Lcom/android/internal/telephony/CommandsInterface$RadioState;

    sget-object v1, Lcom/android/internal/telephony/CommandsInterface$RadioState;->RADIO_ON:Lcom/android/internal/telephony/CommandsInterface$RadioState;

    if-ne v0, v1, :cond_16

    invoke-direct {p0}, Lcom/android/internal/telephony/test/SimulatedCommands;->isSimLocked()Z

    move-result v0

    if-nez v0, :cond_16

    iget-object v0, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->simulatedCallState:Lcom/android/internal/telephony/test/SimulatedGsmCallState;

    invoke-virtual {v0}, Lcom/android/internal/telephony/test/SimulatedGsmCallState;->getDriverCalls()Ljava/util/List;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    :goto_15
    return-void

    :cond_16
    new-instance v0, Lcom/android/internal/telephony/CommandException;

    sget-object v1, Lcom/android/internal/telephony/CommandException$Error;->RADIO_NOT_AVAILABLE:Lcom/android/internal/telephony/CommandException$Error;

    invoke-direct {v0, v1}, Lcom/android/internal/telephony/CommandException;-><init>(Lcom/android/internal/telephony/CommandException$Error;)V

    invoke-direct {p0, p1, v0}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultFail(Landroid/os/Message;Ljava/lang/Throwable;)V

    goto :goto_15
.end method

.method public getDataCallList(Landroid/os/Message;)V
    .registers 4
    .parameter "result"

    .prologue
    new-instance v0, Ljava/util/ArrayList;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    invoke-direct {p0, p1, v0}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    return-void
.end method

.method public getDataRegistrationState(Landroid/os/Message;)V
    .registers 6
    .parameter "result"

    .prologue
    const/4 v3, 0x0

    const/4 v1, 0x4

    new-array v0, v1, [Ljava/lang/String;

    .local v0, ret:[Ljava/lang/String;
    const/4 v1, 0x0

    const-string v2, "5"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    aput-object v3, v0, v1

    const/4 v1, 0x2

    aput-object v3, v0, v1

    const/4 v1, 0x3

    const-string v2, "2"

    aput-object v2, v0, v1

    invoke-direct {p0, p1, v0}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    return-void
.end method

.method public getDeviceIdentity(Landroid/os/Message;)V
    .registers 4
    .parameter "response"

    .prologue
    const-string v0, "SIM"

    const-string v1, "CDMA not implemented in SimulatedCommands"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    invoke-direct {p0, p1}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public getGsmBroadcastConfig(Landroid/os/Message;)V
    .registers 2
    .parameter "response"

    .prologue
    invoke-direct {p0, p1}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public getIMEI(Landroid/os/Message;)V
    .registers 3
    .parameter "result"

    .prologue
    const-string v0, "012345678901234"

    invoke-direct {p0, p1, v0}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    return-void
.end method

.method public getIMEISV(Landroid/os/Message;)V
    .registers 3
    .parameter "result"

    .prologue
    const-string v0, "99"

    invoke-direct {p0, p1, v0}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    return-void
.end method

.method public getIMSI(Landroid/os/Message;)V
    .registers 3
    .parameter "result"

    .prologue
    const/4 v0, 0x0

    invoke-virtual {p0, v0, p1}, Lcom/android/internal/telephony/test/SimulatedCommands;->getIMSIForApp(Ljava/lang/String;Landroid/os/Message;)V

    return-void
.end method

.method public getIMSIForApp(Ljava/lang/String;Landroid/os/Message;)V
    .registers 4
    .parameter "aid"
    .parameter "result"

    .prologue
    const-string v0, "012345678901234"

    invoke-direct {p0, p2, v0}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    return-void
.end method

.method public getIccCardStatus(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    invoke-direct {p0, p1}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public getLastCallFailCause(Landroid/os/Message;)V
    .registers 5
    .parameter "result"

    .prologue
    const/4 v1, 0x1

    new-array v0, v1, [I

    .local v0, ret:[I
    const/4 v1, 0x0

    iget v2, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->nextCallFailCause:I

    aput v2, v0, v1

    invoke-direct {p0, p1, v0}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    return-void
.end method

.method public getLastDataCallFailCause(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    invoke-direct {p0, p1}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public getLastPdpFailCause(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    invoke-direct {p0, p1}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public getMute(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    invoke-direct {p0, p1}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public getNeighboringCids(Landroid/os/Message;)V
    .registers 7
    .parameter "result"

    .prologue
    const/4 v4, 0x7

    new-array v1, v4, [I

    .local v1, ret:[I
    const/4 v2, 0x0

    const/4 v3, 0x6

    aput v3, v1, v2

    const/4 v0, 0x1

    .local v0, i:I
    :goto_8
    if-ge v0, v4, :cond_f

    aput v0, v1, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_8

    :cond_f
    invoke-direct {p0, p1, v1}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    return-void
.end method

.method public getNetworkSelectionMode(Landroid/os/Message;)V
    .registers 5
    .parameter "result"

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    new-array v0, v1, [I

    .local v0, ret:[I
    aput v2, v0, v2

    invoke-direct {p0, p1, v0}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    return-void
.end method

.method public getOperator(Landroid/os/Message;)V
    .registers 5
    .parameter "result"

    .prologue
    const/4 v1, 0x3

    new-array v0, v1, [Ljava/lang/String;

    .local v0, ret:[Ljava/lang/String;
    const/4 v1, 0x0

    const-string v2, "El Telco Loco"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "Telco Loco"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "001001"

    aput-object v2, v0, v1

    invoke-direct {p0, p1, v0}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    return-void
.end method

.method public getPDPContextList(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    invoke-virtual {p0, p1}, Lcom/android/internal/telephony/test/SimulatedCommands;->getDataCallList(Landroid/os/Message;)V

    return-void
.end method

.method public getPreferredNetworkType(Landroid/os/Message;)V
    .registers 5
    .parameter "result"

    .prologue
    const/4 v1, 0x1

    new-array v0, v1, [I

    .local v0, ret:[I
    const/4 v1, 0x0

    iget v2, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mNetworkType:I

    aput v2, v0, v1

    invoke-direct {p0, p1, v0}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    return-void
.end method

.method public getPreferredVoicePrivacy(Landroid/os/Message;)V
    .registers 4
    .parameter "result"

    .prologue
    const-string v0, "SIM"

    const-string v1, "CDMA not implemented in SimulatedCommands"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    invoke-direct {p0, p1}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public getSignalStrength(Landroid/os/Message;)V
    .registers 5
    .parameter "result"

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x2

    new-array v0, v1, [I

    .local v0, ret:[I
    const/16 v1, 0x17

    aput v1, v0, v2

    const/4 v1, 0x1

    aput v2, v0, v1

    invoke-direct {p0, p1, v0}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    return-void
.end method

.method public getSmscAddress(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    invoke-direct {p0, p1}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public getVoiceRadioTechnology(Landroid/os/Message;)V
    .registers 2
    .parameter "response"

    .prologue
    invoke-direct {p0, p1}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public getVoiceRegistrationState(Landroid/os/Message;)V
    .registers 6
    .parameter "result"

    .prologue
    const/4 v3, 0x0

    const/16 v1, 0xe

    new-array v0, v1, [Ljava/lang/String;

    .local v0, ret:[Ljava/lang/String;
    const/4 v1, 0x0

    const-string v2, "5"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    aput-object v3, v0, v1

    const/4 v1, 0x2

    aput-object v3, v0, v1

    const/4 v1, 0x3

    aput-object v3, v0, v1

    const/4 v1, 0x4

    aput-object v3, v0, v1

    const/4 v1, 0x5

    aput-object v3, v0, v1

    const/4 v1, 0x6

    aput-object v3, v0, v1

    const/4 v1, 0x7

    aput-object v3, v0, v1

    const/16 v1, 0x8

    aput-object v3, v0, v1

    const/16 v1, 0x9

    aput-object v3, v0, v1

    const/16 v1, 0xa

    aput-object v3, v0, v1

    const/16 v1, 0xb

    aput-object v3, v0, v1

    const/16 v1, 0xc

    aput-object v3, v0, v1

    const/16 v1, 0xd

    aput-object v3, v0, v1

    invoke-direct {p0, p1, v0}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    return-void
.end method

.method public handleCallSetupRequestFromSim(ZLandroid/os/Message;)V
    .registers 4
    .parameter "accept"
    .parameter "response"

    .prologue
    const/4 v0, 0x0

    invoke-direct {p0, p2, v0}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    return-void
.end method

.method public hangupConnection(ILandroid/os/Message;)V
    .registers 7
    .parameter "gsmIndex"
    .parameter "result"

    .prologue
    iget-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->simulatedCallState:Lcom/android/internal/telephony/test/SimulatedGsmCallState;

    const/16 v2, 0x31

    add-int/lit8 v3, p1, 0x30

    int-to-char v3, v3

    invoke-virtual {v1, v2, v3}, Lcom/android/internal/telephony/test/SimulatedGsmCallState;->onChld(CC)Z

    move-result v0

    .local v0, success:Z
    if-nez v0, :cond_1f

    const-string v1, "GSM"

    const-string v2, "[SimCmd] hangupConnection: resultFail"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "Hangup Error"

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    invoke-direct {p0, p2, v1}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultFail(Landroid/os/Message;Ljava/lang/Throwable;)V

    :goto_1e
    return-void

    :cond_1f
    const-string v1, "GSM"

    const-string v2, "[SimCmd] hangupConnection: resultSuccess"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    const/4 v1, 0x0

    invoke-direct {p0, p2, v1}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    goto :goto_1e
.end method

.method public hangupForegroundResumeBackground(Landroid/os/Message;)V
    .registers 6
    .parameter "result"

    .prologue
    iget-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->simulatedCallState:Lcom/android/internal/telephony/test/SimulatedGsmCallState;

    const/16 v2, 0x31

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Lcom/android/internal/telephony/test/SimulatedGsmCallState;->onChld(CC)Z

    move-result v0

    .local v0, success:Z
    if-nez v0, :cond_16

    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "Hangup Error"

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    invoke-direct {p0, p1, v1}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultFail(Landroid/os/Message;Ljava/lang/Throwable;)V

    :goto_15
    return-void

    :cond_16
    const/4 v1, 0x0

    invoke-direct {p0, p1, v1}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    goto :goto_15
.end method

.method public hangupWaitingOrBackground(Landroid/os/Message;)V
    .registers 6
    .parameter "result"

    .prologue
    iget-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->simulatedCallState:Lcom/android/internal/telephony/test/SimulatedGsmCallState;

    const/16 v2, 0x30

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Lcom/android/internal/telephony/test/SimulatedGsmCallState;->onChld(CC)Z

    move-result v0

    .local v0, success:Z
    if-nez v0, :cond_16

    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "Hangup Error"

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    invoke-direct {p0, p1, v1}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultFail(Landroid/os/Message;Ljava/lang/Throwable;)V

    :goto_15
    return-void

    :cond_16
    const/4 v1, 0x0

    invoke-direct {p0, p1, v1}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    goto :goto_15
.end method

.method public iccIO(IILjava/lang/String;IIILjava/lang/String;Ljava/lang/String;Landroid/os/Message;)V
    .registers 21
    .parameter "command"
    .parameter "fileid"
    .parameter "path"
    .parameter "p1"
    .parameter "p2"
    .parameter "p3"
    .parameter "data"
    .parameter "pin2"
    .parameter "response"

    .prologue
    const/4 v9, 0x0

    move-object v0, p0

    move v1, p1

    move v2, p2

    move-object v3, p3

    move v4, p4

    move/from16 v5, p5

    move/from16 v6, p6

    move-object/from16 v7, p7

    move-object/from16 v8, p8

    move-object/from16 v10, p9

    invoke-virtual/range {v0 .. v10}, Lcom/android/internal/telephony/test/SimulatedCommands;->iccIOForApp(IILjava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Message;)V

    return-void
.end method

.method public iccIOForApp(IILjava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Message;)V
    .registers 11
    .parameter "command"
    .parameter "fileid"
    .parameter "path"
    .parameter "p1"
    .parameter "p2"
    .parameter "p3"
    .parameter "data"
    .parameter "pin2"
    .parameter "aid"
    .parameter "result"

    .prologue
    invoke-direct {p0, p10}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public invokeOemRilRequestRaw([BLandroid/os/Message;)V
    .registers 4
    .parameter "data"
    .parameter "response"

    .prologue
    if-eqz p2, :cond_b

    invoke-static {p2}, Landroid/os/AsyncResult;->forMessage(Landroid/os/Message;)Landroid/os/AsyncResult;

    move-result-object v0

    iput-object p1, v0, Landroid/os/AsyncResult;->result:Ljava/lang/Object;

    invoke-virtual {p2}, Landroid/os/Message;->sendToTarget()V

    :cond_b
    return-void
.end method

.method public invokeOemRilRequestStrings([Ljava/lang/String;Landroid/os/Message;)V
    .registers 4
    .parameter "strings"
    .parameter "response"

    .prologue
    if-eqz p2, :cond_b

    invoke-static {p2}, Landroid/os/AsyncResult;->forMessage(Landroid/os/Message;)Landroid/os/AsyncResult;

    move-result-object v0

    iput-object p1, v0, Landroid/os/AsyncResult;->result:Ljava/lang/Object;

    invoke-virtual {p2}, Landroid/os/Message;->sendToTarget()V

    :cond_b
    return-void
.end method

.method public pauseResponses()V
    .registers 2

    .prologue
    iget v0, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->pausedResponseCount:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->pausedResponseCount:I

    return-void
.end method

.method public progressConnectingCallState()V
    .registers 2

    .prologue
    iget-object v0, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->simulatedCallState:Lcom/android/internal/telephony/test/SimulatedGsmCallState;

    invoke-virtual {v0}, Lcom/android/internal/telephony/test/SimulatedGsmCallState;->progressConnectingCallState()V

    iget-object v0, p0, Lcom/android/internal/telephony/BaseCommands;->mCallStateRegistrants:Landroid/os/RegistrantList;

    invoke-virtual {v0}, Landroid/os/RegistrantList;->notifyRegistrants()V

    return-void
.end method

.method public progressConnectingToActive()V
    .registers 2

    .prologue
    iget-object v0, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->simulatedCallState:Lcom/android/internal/telephony/test/SimulatedGsmCallState;

    invoke-virtual {v0}, Lcom/android/internal/telephony/test/SimulatedGsmCallState;->progressConnectingToActive()V

    iget-object v0, p0, Lcom/android/internal/telephony/BaseCommands;->mCallStateRegistrants:Landroid/os/RegistrantList;

    invoke-virtual {v0}, Landroid/os/RegistrantList;->notifyRegistrants()V

    return-void
.end method

.method public queryAvailableBandMode(Landroid/os/Message;)V
    .registers 7
    .parameter "result"

    .prologue
    const/4 v4, 0x3

    const/4 v3, 0x2

    const/4 v2, 0x4

    new-array v0, v2, [I

    .local v0, ret:[I
    const/4 v1, 0x0

    aput v2, v0, v1

    const/4 v1, 0x1

    aput v3, v0, v1

    aput v4, v0, v3

    aput v2, v0, v4

    invoke-direct {p0, p1, v0}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    return-void
.end method

.method public queryCLIP(Landroid/os/Message;)V
    .registers 2
    .parameter "response"

    .prologue
    invoke-direct {p0, p1}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public queryCallForwardStatus(IILjava/lang/String;Landroid/os/Message;)V
    .registers 5
    .parameter "cfReason"
    .parameter "serviceClass"
    .parameter "number"
    .parameter "result"

    .prologue
    invoke-direct {p0, p4}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public queryCallWaiting(ILandroid/os/Message;)V
    .registers 3
    .parameter "serviceClass"
    .parameter "response"

    .prologue
    invoke-direct {p0, p2}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public queryCdmaRoamingPreference(Landroid/os/Message;)V
    .registers 4
    .parameter "response"

    .prologue
    const-string v0, "SIM"

    const-string v1, "CDMA not implemented in SimulatedCommands"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    invoke-direct {p0, p1}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public queryFacilityLock(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Message;)V
    .registers 11
    .parameter "facility"
    .parameter "pin"
    .parameter "serviceClass"
    .parameter "result"

    .prologue
    const/4 v4, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move-object v5, p4

    invoke-virtual/range {v0 .. v5}, Lcom/android/internal/telephony/test/SimulatedCommands;->queryFacilityLockForApp(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Landroid/os/Message;)V

    return-void
.end method

.method public queryFacilityLockForApp(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Landroid/os/Message;)V
    .registers 12
    .parameter "facility"
    .parameter "pin"
    .parameter "serviceClass"
    .parameter "appId"
    .parameter "result"

    .prologue
    const/4 v5, 0x0

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-eqz p1, :cond_42

    const-string v3, "SC"

    invoke-virtual {p1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_42

    if-eqz p5, :cond_3c

    new-array v0, v1, [I

    .local v0, r:[I
    iget-boolean v3, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mSimLockEnabled:Z

    if-eqz v3, :cond_3d

    :goto_15
    aput v1, v0, v2

    const-string v3, "SIM"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "[SimCmd] queryFacilityLock: SIM is "

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    aget v1, v0, v2

    if-nez v1, :cond_3f

    const-string/jumbo v1, "unlocked"

    :goto_2b
    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v3, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    invoke-static {p5, v0, v5}, Landroid/os/AsyncResult;->forMessage(Landroid/os/Message;Ljava/lang/Object;Ljava/lang/Throwable;)Landroid/os/AsyncResult;

    invoke-virtual {p5}, Landroid/os/Message;->sendToTarget()V

    .end local v0           #r:[I
    :cond_3c
    :goto_3c
    return-void

    .restart local v0       #r:[I
    :cond_3d
    move v1, v2

    goto :goto_15

    :cond_3f
    const-string v1, "locked"

    goto :goto_2b

    .end local v0           #r:[I
    :cond_42
    if-eqz p1, :cond_80

    const-string v3, "FD"

    invoke-virtual {p1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_80

    if-eqz p5, :cond_3c

    new-array v0, v1, [I

    .restart local v0       #r:[I
    iget-boolean v3, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mSimFdnEnabled:Z

    if-eqz v3, :cond_7b

    :goto_54
    aput v1, v0, v2

    const-string v3, "SIM"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "[SimCmd] queryFacilityLock: FDN is "

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    aget v1, v0, v2

    if-nez v1, :cond_7d

    const-string v1, "disabled"

    :goto_69
    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v3, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    invoke-static {p5, v0, v5}, Landroid/os/AsyncResult;->forMessage(Landroid/os/Message;Ljava/lang/Object;Ljava/lang/Throwable;)Landroid/os/AsyncResult;

    invoke-virtual {p5}, Landroid/os/Message;->sendToTarget()V

    goto :goto_3c

    :cond_7b
    move v1, v2

    goto :goto_54

    :cond_7d
    const-string v1, "enabled"

    goto :goto_69

    .end local v0           #r:[I
    :cond_80
    invoke-direct {p0, p5}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    goto :goto_3c
.end method

.method public queryTTYMode(Landroid/os/Message;)V
    .registers 4
    .parameter "response"

    .prologue
    const-string v0, "SIM"

    const-string v1, "CDMA not implemented in SimulatedCommands"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    invoke-direct {p0, p1}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public rejectCall(Landroid/os/Message;)V
    .registers 6
    .parameter "result"

    .prologue
    iget-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->simulatedCallState:Lcom/android/internal/telephony/test/SimulatedGsmCallState;

    const/16 v2, 0x30

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Lcom/android/internal/telephony/test/SimulatedGsmCallState;->onChld(CC)Z

    move-result v0

    .local v0, success:Z
    if-nez v0, :cond_16

    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "Hangup Error"

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    invoke-direct {p0, p1, v1}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultFail(Landroid/os/Message;Ljava/lang/Throwable;)V

    :goto_15
    return-void

    :cond_16
    const/4 v1, 0x0

    invoke-direct {p0, p1, v1}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    goto :goto_15
.end method

.method public reportSmsMemoryStatus(ZLandroid/os/Message;)V
    .registers 3
    .parameter "available"
    .parameter "result"

    .prologue
    invoke-direct {p0, p2}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public reportStkServiceIsRunning(Landroid/os/Message;)V
    .registers 3
    .parameter "result"

    .prologue
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    return-void
.end method

.method public requestIsimAuthentication(Ljava/lang/String;Landroid/os/Message;)V
    .registers 3
    .parameter "nonce"
    .parameter "response"

    .prologue
    invoke-direct {p0, p2}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public resetRadio(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    invoke-direct {p0, p1}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public resumeResponses()V
    .registers 5

    .prologue
    iget v2, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->pausedResponseCount:I

    add-int/lit8 v2, v2, -0x1

    iput v2, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->pausedResponseCount:I

    iget v2, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->pausedResponseCount:I

    if-nez v2, :cond_27

    const/4 v0, 0x0

    .local v0, i:I
    iget-object v2, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->pausedResponses:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v1

    .local v1, s:I
    :goto_11
    if-ge v0, v1, :cond_21

    iget-object v2, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->pausedResponses:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/os/Message;

    invoke-virtual {v2}, Landroid/os/Message;->sendToTarget()V

    add-int/lit8 v0, v0, 0x1

    goto :goto_11

    :cond_21
    iget-object v2, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->pausedResponses:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V

    .end local v0           #i:I
    .end local v1           #s:I
    :goto_26
    return-void

    :cond_27
    const-string v2, "GSM"

    const-string v3, "SimulatedCommands.resumeResponses < 0"

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_26
.end method

.method public sendBurstDtmf(Ljava/lang/String;IILandroid/os/Message;)V
    .registers 6
    .parameter "dtmfString"
    .parameter "on"
    .parameter "off"
    .parameter "result"

    .prologue
    const/4 v0, 0x0

    invoke-direct {p0, p4, v0}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    return-void
.end method

.method public sendCDMAFeatureCode(Ljava/lang/String;Landroid/os/Message;)V
    .registers 5
    .parameter "FeatureCode"
    .parameter "response"

    .prologue
    const-string v0, "SIM"

    const-string v1, "CDMA not implemented in SimulatedCommands"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    invoke-direct {p0, p2}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public sendCdmaSms([BLandroid/os/Message;)V
    .registers 5
    .parameter "pdu"
    .parameter "response"

    .prologue
    const-string v0, "SIM"

    const-string v1, "CDMA not implemented in SimulatedCommands"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    return-void
.end method

.method public sendDtmf(CLandroid/os/Message;)V
    .registers 4
    .parameter "c"
    .parameter "result"

    .prologue
    const/4 v0, 0x0

    invoke-direct {p0, p2, v0}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    return-void
.end method

.method public sendEnvelope(Ljava/lang/String;Landroid/os/Message;)V
    .registers 4
    .parameter "contents"
    .parameter "response"

    .prologue
    const/4 v0, 0x0

    invoke-direct {p0, p2, v0}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    return-void
.end method

.method public sendEnvelopeWithStatus(Ljava/lang/String;Landroid/os/Message;)V
    .registers 4
    .parameter "contents"
    .parameter "response"

    .prologue
    const/4 v0, 0x0

    invoke-direct {p0, p2, v0}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    return-void
.end method

.method public sendSMS(Ljava/lang/String;Ljava/lang/String;Landroid/os/Message;)V
    .registers 4
    .parameter "smscPDU"
    .parameter "pdu"
    .parameter "result"

    .prologue
    invoke-direct {p0, p3}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public sendTerminalResponse(Ljava/lang/String;Landroid/os/Message;)V
    .registers 4
    .parameter "contents"
    .parameter "response"

    .prologue
    const/4 v0, 0x0

    invoke-direct {p0, p2, v0}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    return-void
.end method

.method public sendUSSD(Ljava/lang/String;Landroid/os/Message;)V
    .registers 5
    .parameter "ussdString"
    .parameter "result"

    .prologue
    const/4 v1, 0x0

    const-string v0, "#646#"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_14

    invoke-direct {p0, p2, v1}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    const-string v0, "0"

    const-string v1, "You have NNN minutes remaining."

    invoke-virtual {p0, v0, v1}, Lcom/android/internal/telephony/test/SimulatedCommands;->triggerIncomingUssd(Ljava/lang/String;Ljava/lang/String;)V

    :goto_13
    return-void

    :cond_14
    invoke-direct {p0, p2, v1}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    const-string v0, "0"

    const-string v1, "All Done"

    invoke-virtual {p0, v0, v1}, Lcom/android/internal/telephony/test/SimulatedCommands;->triggerIncomingUssd(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_13
.end method

.method public separateConnection(ILandroid/os/Message;)V
    .registers 7
    .parameter "gsmIndex"
    .parameter "result"

    .prologue
    add-int/lit8 v2, p1, 0x30

    int-to-char v0, v2

    .local v0, ch:C
    iget-object v2, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->simulatedCallState:Lcom/android/internal/telephony/test/SimulatedGsmCallState;

    const/16 v3, 0x32

    invoke-virtual {v2, v3, v0}, Lcom/android/internal/telephony/test/SimulatedGsmCallState;->onChld(CC)Z

    move-result v1

    .local v1, success:Z
    if-nez v1, :cond_18

    new-instance v2, Ljava/lang/RuntimeException;

    const-string v3, "Hangup Error"

    invoke-direct {v2, v3}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    invoke-direct {p0, p2, v2}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultFail(Landroid/os/Message;Ljava/lang/Throwable;)V

    :goto_17
    return-void

    :cond_18
    const/4 v2, 0x0

    invoke-direct {p0, p2, v2}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    goto :goto_17
.end method

.method public setAutoProgressConnectingCall(Z)V
    .registers 3
    .parameter "b"

    .prologue
    iget-object v0, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->simulatedCallState:Lcom/android/internal/telephony/test/SimulatedGsmCallState;

    invoke-virtual {v0, p1}, Lcom/android/internal/telephony/test/SimulatedGsmCallState;->setAutoProgressConnectingCall(Z)V

    return-void
.end method

.method public setBandMode(ILandroid/os/Message;)V
    .registers 4
    .parameter "bandMode"
    .parameter "result"

    .prologue
    const/4 v0, 0x0

    invoke-direct {p0, p2, v0}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    return-void
.end method

.method public setCLIR(ILandroid/os/Message;)V
    .registers 3
    .parameter "clirMode"
    .parameter "result"

    .prologue
    invoke-direct {p0, p2}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public setCallForward(IIILjava/lang/String;ILandroid/os/Message;)V
    .registers 7
    .parameter "action"
    .parameter "cfReason"
    .parameter "serviceClass"
    .parameter "number"
    .parameter "timeSeconds"
    .parameter "result"

    .prologue
    invoke-direct {p0, p6}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public setCallWaiting(ZILandroid/os/Message;)V
    .registers 4
    .parameter "enable"
    .parameter "serviceClass"
    .parameter "response"

    .prologue
    invoke-direct {p0, p3}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public setCdmaBroadcastActivation(ZLandroid/os/Message;)V
    .registers 3
    .parameter "activate"
    .parameter "response"

    .prologue
    invoke-direct {p0, p2}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public setCdmaBroadcastConfig([ILandroid/os/Message;)V
    .registers 3
    .parameter "configValuesArray"
    .parameter "response"

    .prologue
    invoke-direct {p0, p2}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public setCdmaRoamingPreference(ILandroid/os/Message;)V
    .registers 5
    .parameter "cdmaRoamingType"
    .parameter "response"

    .prologue
    const-string v0, "SIM"

    const-string v1, "CDMA not implemented in SimulatedCommands"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    invoke-direct {p0, p2}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public setCdmaSubscriptionSource(ILandroid/os/Message;)V
    .registers 5
    .parameter "cdmaSubscriptionType"
    .parameter "response"

    .prologue
    const-string v0, "SIM"

    const-string v1, "CDMA not implemented in SimulatedCommands"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    invoke-direct {p0, p2}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public setFacilityLock(Ljava/lang/String;ZLjava/lang/String;ILandroid/os/Message;)V
    .registers 13
    .parameter "facility"
    .parameter "lockEnabled"
    .parameter "pin"
    .parameter "serviceClass"
    .parameter "result"

    .prologue
    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move-object v3, p3

    move v4, p4

    move-object v6, p5

    invoke-virtual/range {v0 .. v6}, Lcom/android/internal/telephony/test/SimulatedCommands;->setFacilityLockForApp(Ljava/lang/String;ZLjava/lang/String;ILjava/lang/String;Landroid/os/Message;)V

    return-void
.end method

.method public setFacilityLockForApp(Ljava/lang/String;ZLjava/lang/String;ILjava/lang/String;Landroid/os/Message;)V
    .registers 11
    .parameter "facility"
    .parameter "lockEnabled"
    .parameter "pin"
    .parameter "serviceClass"
    .parameter "appId"
    .parameter "result"

    .prologue
    const/4 v3, 0x0

    if-eqz p1, :cond_3e

    const-string v1, "SC"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3e

    if-eqz p3, :cond_27

    iget-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mPinCode:Ljava/lang/String;

    invoke-virtual {p3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_27

    const-string v1, "SIM"

    const-string v2, "[SimCmd] setFacilityLock: pin is valid"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    iput-boolean p2, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mSimLockEnabled:Z

    if-eqz p6, :cond_26

    invoke-static {p6, v3, v3}, Landroid/os/AsyncResult;->forMessage(Landroid/os/Message;Ljava/lang/Object;Ljava/lang/Throwable;)Landroid/os/AsyncResult;

    invoke-virtual {p6}, Landroid/os/Message;->sendToTarget()V

    :cond_26
    :goto_26
    return-void

    :cond_27
    if-eqz p6, :cond_26

    const-string v1, "SIM"

    const-string v2, "[SimCmd] setFacilityLock: pin failed!"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    new-instance v0, Lcom/android/internal/telephony/CommandException;

    sget-object v1, Lcom/android/internal/telephony/CommandException$Error;->GENERIC_FAILURE:Lcom/android/internal/telephony/CommandException$Error;

    invoke-direct {v0, v1}, Lcom/android/internal/telephony/CommandException;-><init>(Lcom/android/internal/telephony/CommandException$Error;)V

    .local v0, ex:Lcom/android/internal/telephony/CommandException;
    invoke-static {p6, v3, v0}, Landroid/os/AsyncResult;->forMessage(Landroid/os/Message;Ljava/lang/Object;Ljava/lang/Throwable;)Landroid/os/AsyncResult;

    invoke-virtual {p6}, Landroid/os/Message;->sendToTarget()V

    goto :goto_26

    .end local v0           #ex:Lcom/android/internal/telephony/CommandException;
    :cond_3e
    if-eqz p1, :cond_7b

    const-string v1, "FD"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_7b

    if-eqz p3, :cond_64

    iget-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mPin2Code:Ljava/lang/String;

    invoke-virtual {p3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_64

    const-string v1, "SIM"

    const-string v2, "[SimCmd] setFacilityLock: pin2 is valid"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    iput-boolean p2, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mSimFdnEnabled:Z

    if-eqz p6, :cond_26

    invoke-static {p6, v3, v3}, Landroid/os/AsyncResult;->forMessage(Landroid/os/Message;Ljava/lang/Object;Ljava/lang/Throwable;)Landroid/os/AsyncResult;

    invoke-virtual {p6}, Landroid/os/Message;->sendToTarget()V

    goto :goto_26

    :cond_64
    if-eqz p6, :cond_26

    const-string v1, "SIM"

    const-string v2, "[SimCmd] setFacilityLock: pin2 failed!"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    new-instance v0, Lcom/android/internal/telephony/CommandException;

    sget-object v1, Lcom/android/internal/telephony/CommandException$Error;->GENERIC_FAILURE:Lcom/android/internal/telephony/CommandException$Error;

    invoke-direct {v0, v1}, Lcom/android/internal/telephony/CommandException;-><init>(Lcom/android/internal/telephony/CommandException$Error;)V

    .restart local v0       #ex:Lcom/android/internal/telephony/CommandException;
    invoke-static {p6, v3, v0}, Landroid/os/AsyncResult;->forMessage(Landroid/os/Message;Ljava/lang/Object;Ljava/lang/Throwable;)Landroid/os/AsyncResult;

    invoke-virtual {p6}, Landroid/os/Message;->sendToTarget()V

    goto :goto_26

    .end local v0           #ex:Lcom/android/internal/telephony/CommandException;
    :cond_7b
    invoke-direct {p0, p6}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    goto :goto_26
.end method

.method public setGsmBroadcastActivation(ZLandroid/os/Message;)V
    .registers 3
    .parameter "activate"
    .parameter "response"

    .prologue
    invoke-direct {p0, p2}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public setGsmBroadcastConfig([Lcom/android/internal/telephony/gsm/SmsBroadcastConfigInfo;Landroid/os/Message;)V
    .registers 3
    .parameter "config"
    .parameter "response"

    .prologue
    invoke-direct {p0, p2}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public setLocationUpdates(ZLandroid/os/Message;)V
    .registers 3
    .parameter "enable"
    .parameter "response"

    .prologue
    invoke-direct {p0, p2}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public setMute(ZLandroid/os/Message;)V
    .registers 3
    .parameter "enableMute"
    .parameter "result"

    .prologue
    invoke-direct {p0, p2}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public setNetworkSelectionModeAutomatic(Landroid/os/Message;)V
    .registers 2
    .parameter "result"

    .prologue
    invoke-direct {p0, p1}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public setNetworkSelectionModeManual(Ljava/lang/String;Landroid/os/Message;)V
    .registers 3
    .parameter "operatorNumeric"
    .parameter "result"

    .prologue
    invoke-direct {p0, p2}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public setNextCallFailCause(I)V
    .registers 2
    .parameter "gsmCause"

    .prologue
    iput p1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->nextCallFailCause:I

    return-void
.end method

.method public setNextDialFailImmediately(Z)V
    .registers 3
    .parameter "b"

    .prologue
    iget-object v0, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->simulatedCallState:Lcom/android/internal/telephony/test/SimulatedGsmCallState;

    invoke-virtual {v0, p1}, Lcom/android/internal/telephony/test/SimulatedGsmCallState;->setNextDialFailImmediately(Z)V

    return-void
.end method

.method public setPhoneType(I)V
    .registers 4
    .parameter "phoneType"

    .prologue
    const-string v0, "SIM"

    const-string v1, "CDMA not implemented in SimulatedCommands"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    return-void
.end method

.method public setPreferredNetworkType(ILandroid/os/Message;)V
    .registers 4
    .parameter "networkType"
    .parameter "result"

    .prologue
    iput p1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mNetworkType:I

    const/4 v0, 0x0

    invoke-direct {p0, p2, v0}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    return-void
.end method

.method public setPreferredVoicePrivacy(ZLandroid/os/Message;)V
    .registers 5
    .parameter "enable"
    .parameter "result"

    .prologue
    const-string v0, "SIM"

    const-string v1, "CDMA not implemented in SimulatedCommands"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    invoke-direct {p0, p2}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public setRadioPower(ZLandroid/os/Message;)V
    .registers 4
    .parameter "on"
    .parameter "result"

    .prologue
    if-eqz p1, :cond_8

    sget-object v0, Lcom/android/internal/telephony/CommandsInterface$RadioState;->RADIO_ON:Lcom/android/internal/telephony/CommandsInterface$RadioState;

    invoke-virtual {p0, v0}, Lcom/android/internal/telephony/test/SimulatedCommands;->setRadioState(Lcom/android/internal/telephony/CommandsInterface$RadioState;)V

    :goto_7
    return-void

    :cond_8
    sget-object v0, Lcom/android/internal/telephony/CommandsInterface$RadioState;->RADIO_OFF:Lcom/android/internal/telephony/CommandsInterface$RadioState;

    invoke-virtual {p0, v0}, Lcom/android/internal/telephony/test/SimulatedCommands;->setRadioState(Lcom/android/internal/telephony/CommandsInterface$RadioState;)V

    goto :goto_7
.end method

.method public setSmscAddress(Ljava/lang/String;Landroid/os/Message;)V
    .registers 3
    .parameter "address"
    .parameter "result"

    .prologue
    invoke-direct {p0, p2}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public setSuppServiceNotifications(ZLandroid/os/Message;)V
    .registers 5
    .parameter "enable"
    .parameter "result"

    .prologue
    const/4 v0, 0x0

    invoke-direct {p0, p2, v0}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    if-eqz p1, :cond_11

    iget-boolean v0, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mSsnNotifyOn:Z

    if-eqz v0, :cond_11

    const-string v0, "SIM"

    const-string v1, "Supp Service Notifications already enabled!"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    :cond_11
    iput-boolean p1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mSsnNotifyOn:Z

    return-void
.end method

.method public setTTYMode(ILandroid/os/Message;)V
    .registers 5
    .parameter "ttyMode"
    .parameter "response"

    .prologue
    const-string v0, "SIM"

    const-string v1, "Not implemented in SimulatedCommands"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    invoke-direct {p0, p2}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public setupDataCall(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Message;)V
    .registers 9
    .parameter "radioTechnology"
    .parameter "profile"
    .parameter "apn"
    .parameter "user"
    .parameter "password"
    .parameter "authType"
    .parameter "protocol"
    .parameter "result"

    .prologue
    invoke-direct {p0, p8}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public shutdown()V
    .registers 3

    .prologue
    sget-object v1, Lcom/android/internal/telephony/CommandsInterface$RadioState;->RADIO_UNAVAILABLE:Lcom/android/internal/telephony/CommandsInterface$RadioState;

    invoke-virtual {p0, v1}, Lcom/android/internal/telephony/test/SimulatedCommands;->setRadioState(Lcom/android/internal/telephony/CommandsInterface$RadioState;)V

    iget-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mHandlerThread:Landroid/os/HandlerThread;

    invoke-virtual {v1}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;

    move-result-object v0

    .local v0, looper:Landroid/os/Looper;
    if-eqz v0, :cond_10

    invoke-virtual {v0}, Landroid/os/Looper;->quit()V

    :cond_10
    return-void
.end method

.method public startDtmf(CLandroid/os/Message;)V
    .registers 4
    .parameter "c"
    .parameter "result"

    .prologue
    const/4 v0, 0x0

    invoke-direct {p0, p2, v0}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    return-void
.end method

.method public stopDtmf(Landroid/os/Message;)V
    .registers 3
    .parameter "result"

    .prologue
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    return-void
.end method

.method public supplyIccPin(Ljava/lang/String;Landroid/os/Message;)V
    .registers 8
    .parameter "pin"
    .parameter "result"

    .prologue
    const/4 v4, 0x0

    iget-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mSimLockedState:Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;

    sget-object v2, Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;->REQUIRE_PIN:Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;

    if-eq v1, v2, :cond_2f

    const-string v1, "SIM"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "[SimCmd] supplyIccPin: wrong state, state="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mSimLockedState:Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    new-instance v0, Lcom/android/internal/telephony/CommandException;

    sget-object v1, Lcom/android/internal/telephony/CommandException$Error;->PASSWORD_INCORRECT:Lcom/android/internal/telephony/CommandException$Error;

    invoke-direct {v0, v1}, Lcom/android/internal/telephony/CommandException;-><init>(Lcom/android/internal/telephony/CommandException$Error;)V

    .local v0, ex:Lcom/android/internal/telephony/CommandException;
    invoke-static {p2, v4, v0}, Landroid/os/AsyncResult;->forMessage(Landroid/os/Message;Ljava/lang/Object;Ljava/lang/Throwable;)Landroid/os/AsyncResult;

    invoke-virtual {p2}, Landroid/os/Message;->sendToTarget()V

    .end local v0           #ex:Lcom/android/internal/telephony/CommandException;
    :cond_2e
    :goto_2e
    return-void

    :cond_2f
    if-eqz p1, :cond_55

    iget-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mPinCode:Ljava/lang/String;

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_55

    const-string v1, "SIM"

    const-string v2, "[SimCmd] supplyIccPin: success!"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    const/4 v1, 0x0

    iput v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mPinUnlockAttempts:I

    sget-object v1, Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;->NONE:Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;

    iput-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mSimLockedState:Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;

    iget-object v1, p0, Lcom/android/internal/telephony/BaseCommands;->mIccStatusChangedRegistrants:Landroid/os/RegistrantList;

    invoke-virtual {v1}, Landroid/os/RegistrantList;->notifyRegistrants()V

    if-eqz p2, :cond_2e

    invoke-static {p2, v4, v4}, Landroid/os/AsyncResult;->forMessage(Landroid/os/Message;Ljava/lang/Object;Ljava/lang/Throwable;)Landroid/os/AsyncResult;

    invoke-virtual {p2}, Landroid/os/Message;->sendToTarget()V

    goto :goto_2e

    :cond_55
    if-eqz p2, :cond_2e

    iget v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mPinUnlockAttempts:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mPinUnlockAttempts:I

    const-string v1, "SIM"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "[SimCmd] supplyIccPin: failed! attempt="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v3, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mPinUnlockAttempts:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    iget v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mPinUnlockAttempts:I

    const/4 v2, 0x3

    if-lt v1, v2, :cond_87

    const-string v1, "SIM"

    const-string v2, "[SimCmd] supplyIccPin: set state to REQUIRE_PUK"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    sget-object v1, Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;->REQUIRE_PUK:Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;

    iput-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mSimLockedState:Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;

    :cond_87
    new-instance v0, Lcom/android/internal/telephony/CommandException;

    sget-object v1, Lcom/android/internal/telephony/CommandException$Error;->PASSWORD_INCORRECT:Lcom/android/internal/telephony/CommandException$Error;

    invoke-direct {v0, v1}, Lcom/android/internal/telephony/CommandException;-><init>(Lcom/android/internal/telephony/CommandException$Error;)V

    .restart local v0       #ex:Lcom/android/internal/telephony/CommandException;
    invoke-static {p2, v4, v0}, Landroid/os/AsyncResult;->forMessage(Landroid/os/Message;Ljava/lang/Object;Ljava/lang/Throwable;)Landroid/os/AsyncResult;

    invoke-virtual {p2}, Landroid/os/Message;->sendToTarget()V

    goto :goto_2e
.end method

.method public supplyIccPin2(Ljava/lang/String;Landroid/os/Message;)V
    .registers 8
    .parameter "pin2"
    .parameter "result"

    .prologue
    const/4 v4, 0x0

    iget-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mSimFdnEnabledState:Lcom/android/internal/telephony/test/SimulatedCommands$SimFdnState;

    sget-object v2, Lcom/android/internal/telephony/test/SimulatedCommands$SimFdnState;->REQUIRE_PIN2:Lcom/android/internal/telephony/test/SimulatedCommands$SimFdnState;

    if-eq v1, v2, :cond_2f

    const-string v1, "SIM"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "[SimCmd] supplyIccPin2: wrong state, state="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mSimFdnEnabledState:Lcom/android/internal/telephony/test/SimulatedCommands$SimFdnState;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    new-instance v0, Lcom/android/internal/telephony/CommandException;

    sget-object v1, Lcom/android/internal/telephony/CommandException$Error;->PASSWORD_INCORRECT:Lcom/android/internal/telephony/CommandException$Error;

    invoke-direct {v0, v1}, Lcom/android/internal/telephony/CommandException;-><init>(Lcom/android/internal/telephony/CommandException$Error;)V

    .local v0, ex:Lcom/android/internal/telephony/CommandException;
    invoke-static {p2, v4, v0}, Landroid/os/AsyncResult;->forMessage(Landroid/os/Message;Ljava/lang/Object;Ljava/lang/Throwable;)Landroid/os/AsyncResult;

    invoke-virtual {p2}, Landroid/os/Message;->sendToTarget()V

    .end local v0           #ex:Lcom/android/internal/telephony/CommandException;
    :cond_2e
    :goto_2e
    return-void

    :cond_2f
    if-eqz p1, :cond_50

    iget-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mPin2Code:Ljava/lang/String;

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_50

    const-string v1, "SIM"

    const-string v2, "[SimCmd] supplyIccPin2: success!"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    const/4 v1, 0x0

    iput v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mPin2UnlockAttempts:I

    sget-object v1, Lcom/android/internal/telephony/test/SimulatedCommands$SimFdnState;->NONE:Lcom/android/internal/telephony/test/SimulatedCommands$SimFdnState;

    iput-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mSimFdnEnabledState:Lcom/android/internal/telephony/test/SimulatedCommands$SimFdnState;

    if-eqz p2, :cond_2e

    invoke-static {p2, v4, v4}, Landroid/os/AsyncResult;->forMessage(Landroid/os/Message;Ljava/lang/Object;Ljava/lang/Throwable;)Landroid/os/AsyncResult;

    invoke-virtual {p2}, Landroid/os/Message;->sendToTarget()V

    goto :goto_2e

    :cond_50
    if-eqz p2, :cond_2e

    iget v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mPin2UnlockAttempts:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mPin2UnlockAttempts:I

    const-string v1, "SIM"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "[SimCmd] supplyIccPin2: failed! attempt="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v3, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mPin2UnlockAttempts:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    iget v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mPin2UnlockAttempts:I

    const/4 v2, 0x3

    if-lt v1, v2, :cond_82

    const-string v1, "SIM"

    const-string v2, "[SimCmd] supplyIccPin2: set state to REQUIRE_PUK2"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    sget-object v1, Lcom/android/internal/telephony/test/SimulatedCommands$SimFdnState;->REQUIRE_PUK2:Lcom/android/internal/telephony/test/SimulatedCommands$SimFdnState;

    iput-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mSimFdnEnabledState:Lcom/android/internal/telephony/test/SimulatedCommands$SimFdnState;

    :cond_82
    new-instance v0, Lcom/android/internal/telephony/CommandException;

    sget-object v1, Lcom/android/internal/telephony/CommandException$Error;->PASSWORD_INCORRECT:Lcom/android/internal/telephony/CommandException$Error;

    invoke-direct {v0, v1}, Lcom/android/internal/telephony/CommandException;-><init>(Lcom/android/internal/telephony/CommandException$Error;)V

    .restart local v0       #ex:Lcom/android/internal/telephony/CommandException;
    invoke-static {p2, v4, v0}, Landroid/os/AsyncResult;->forMessage(Landroid/os/Message;Ljava/lang/Object;Ljava/lang/Throwable;)Landroid/os/AsyncResult;

    invoke-virtual {p2}, Landroid/os/Message;->sendToTarget()V

    goto :goto_2e
.end method

.method public supplyIccPin2ForApp(Ljava/lang/String;Ljava/lang/String;Landroid/os/Message;)V
    .registers 4
    .parameter "pin2"
    .parameter "aid"
    .parameter "response"

    .prologue
    invoke-direct {p0, p3}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public supplyIccPinForApp(Ljava/lang/String;Ljava/lang/String;Landroid/os/Message;)V
    .registers 4
    .parameter "pin"
    .parameter "aid"
    .parameter "response"

    .prologue
    invoke-direct {p0, p3}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public supplyIccPuk(Ljava/lang/String;Ljava/lang/String;Landroid/os/Message;)V
    .registers 9
    .parameter "puk"
    .parameter "newPin"
    .parameter "result"

    .prologue
    const/4 v4, 0x0

    iget-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mSimLockedState:Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;

    sget-object v2, Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;->REQUIRE_PUK:Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;

    if-eq v1, v2, :cond_2f

    const-string v1, "SIM"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "[SimCmd] supplyIccPuk: wrong state, state="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mSimLockedState:Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    new-instance v0, Lcom/android/internal/telephony/CommandException;

    sget-object v1, Lcom/android/internal/telephony/CommandException$Error;->PASSWORD_INCORRECT:Lcom/android/internal/telephony/CommandException$Error;

    invoke-direct {v0, v1}, Lcom/android/internal/telephony/CommandException;-><init>(Lcom/android/internal/telephony/CommandException$Error;)V

    .local v0, ex:Lcom/android/internal/telephony/CommandException;
    invoke-static {p3, v4, v0}, Landroid/os/AsyncResult;->forMessage(Landroid/os/Message;Ljava/lang/Object;Ljava/lang/Throwable;)Landroid/os/AsyncResult;

    invoke-virtual {p3}, Landroid/os/Message;->sendToTarget()V

    .end local v0           #ex:Lcom/android/internal/telephony/CommandException;
    :cond_2e
    :goto_2e
    return-void

    :cond_2f
    if-eqz p1, :cond_55

    const-string v1, "12345678"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_55

    const-string v1, "SIM"

    const-string v2, "[SimCmd] supplyIccPuk: success!"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    sget-object v1, Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;->NONE:Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;

    iput-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mSimLockedState:Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;

    const/4 v1, 0x0

    iput v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mPukUnlockAttempts:I

    iget-object v1, p0, Lcom/android/internal/telephony/BaseCommands;->mIccStatusChangedRegistrants:Landroid/os/RegistrantList;

    invoke-virtual {v1}, Landroid/os/RegistrantList;->notifyRegistrants()V

    if-eqz p3, :cond_2e

    invoke-static {p3, v4, v4}, Landroid/os/AsyncResult;->forMessage(Landroid/os/Message;Ljava/lang/Object;Ljava/lang/Throwable;)Landroid/os/AsyncResult;

    invoke-virtual {p3}, Landroid/os/Message;->sendToTarget()V

    goto :goto_2e

    :cond_55
    if-eqz p3, :cond_2e

    iget v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mPukUnlockAttempts:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mPukUnlockAttempts:I

    const-string v1, "SIM"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "[SimCmd] supplyIccPuk: failed! attempt="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v3, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mPukUnlockAttempts:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    iget v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mPukUnlockAttempts:I

    const/16 v2, 0xa

    if-lt v1, v2, :cond_88

    const-string v1, "SIM"

    const-string v2, "[SimCmd] supplyIccPuk: set state to SIM_PERM_LOCKED"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    sget-object v1, Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;->SIM_PERM_LOCKED:Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;

    iput-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mSimLockedState:Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;

    :cond_88
    new-instance v0, Lcom/android/internal/telephony/CommandException;

    sget-object v1, Lcom/android/internal/telephony/CommandException$Error;->PASSWORD_INCORRECT:Lcom/android/internal/telephony/CommandException$Error;

    invoke-direct {v0, v1}, Lcom/android/internal/telephony/CommandException;-><init>(Lcom/android/internal/telephony/CommandException$Error;)V

    .restart local v0       #ex:Lcom/android/internal/telephony/CommandException;
    invoke-static {p3, v4, v0}, Landroid/os/AsyncResult;->forMessage(Landroid/os/Message;Ljava/lang/Object;Ljava/lang/Throwable;)Landroid/os/AsyncResult;

    invoke-virtual {p3}, Landroid/os/Message;->sendToTarget()V

    goto :goto_2e
.end method

.method public supplyIccPuk2(Ljava/lang/String;Ljava/lang/String;Landroid/os/Message;)V
    .registers 9
    .parameter "puk2"
    .parameter "newPin2"
    .parameter "result"

    .prologue
    const/4 v4, 0x0

    iget-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mSimFdnEnabledState:Lcom/android/internal/telephony/test/SimulatedCommands$SimFdnState;

    sget-object v2, Lcom/android/internal/telephony/test/SimulatedCommands$SimFdnState;->REQUIRE_PUK2:Lcom/android/internal/telephony/test/SimulatedCommands$SimFdnState;

    if-eq v1, v2, :cond_2f

    const-string v1, "SIM"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "[SimCmd] supplyIccPuk2: wrong state, state="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mSimLockedState:Lcom/android/internal/telephony/test/SimulatedCommands$SimLockState;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    new-instance v0, Lcom/android/internal/telephony/CommandException;

    sget-object v1, Lcom/android/internal/telephony/CommandException$Error;->PASSWORD_INCORRECT:Lcom/android/internal/telephony/CommandException$Error;

    invoke-direct {v0, v1}, Lcom/android/internal/telephony/CommandException;-><init>(Lcom/android/internal/telephony/CommandException$Error;)V

    .local v0, ex:Lcom/android/internal/telephony/CommandException;
    invoke-static {p3, v4, v0}, Landroid/os/AsyncResult;->forMessage(Landroid/os/Message;Ljava/lang/Object;Ljava/lang/Throwable;)Landroid/os/AsyncResult;

    invoke-virtual {p3}, Landroid/os/Message;->sendToTarget()V

    .end local v0           #ex:Lcom/android/internal/telephony/CommandException;
    :cond_2e
    :goto_2e
    return-void

    :cond_2f
    if-eqz p1, :cond_50

    const-string v1, "87654321"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_50

    const-string v1, "SIM"

    const-string v2, "[SimCmd] supplyIccPuk2: success!"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    sget-object v1, Lcom/android/internal/telephony/test/SimulatedCommands$SimFdnState;->NONE:Lcom/android/internal/telephony/test/SimulatedCommands$SimFdnState;

    iput-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mSimFdnEnabledState:Lcom/android/internal/telephony/test/SimulatedCommands$SimFdnState;

    const/4 v1, 0x0

    iput v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mPuk2UnlockAttempts:I

    if-eqz p3, :cond_2e

    invoke-static {p3, v4, v4}, Landroid/os/AsyncResult;->forMessage(Landroid/os/Message;Ljava/lang/Object;Ljava/lang/Throwable;)Landroid/os/AsyncResult;

    invoke-virtual {p3}, Landroid/os/Message;->sendToTarget()V

    goto :goto_2e

    :cond_50
    if-eqz p3, :cond_2e

    iget v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mPuk2UnlockAttempts:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mPuk2UnlockAttempts:I

    const-string v1, "SIM"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "[SimCmd] supplyIccPuk2: failed! attempt="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v3, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mPuk2UnlockAttempts:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    iget v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mPuk2UnlockAttempts:I

    const/16 v2, 0xa

    if-lt v1, v2, :cond_83

    const-string v1, "SIM"

    const-string v2, "[SimCmd] supplyIccPuk2: set state to SIM_PERM_LOCKED"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    sget-object v1, Lcom/android/internal/telephony/test/SimulatedCommands$SimFdnState;->SIM_PERM_LOCKED:Lcom/android/internal/telephony/test/SimulatedCommands$SimFdnState;

    iput-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->mSimFdnEnabledState:Lcom/android/internal/telephony/test/SimulatedCommands$SimFdnState;

    :cond_83
    new-instance v0, Lcom/android/internal/telephony/CommandException;

    sget-object v1, Lcom/android/internal/telephony/CommandException$Error;->PASSWORD_INCORRECT:Lcom/android/internal/telephony/CommandException$Error;

    invoke-direct {v0, v1}, Lcom/android/internal/telephony/CommandException;-><init>(Lcom/android/internal/telephony/CommandException$Error;)V

    .restart local v0       #ex:Lcom/android/internal/telephony/CommandException;
    invoke-static {p3, v4, v0}, Landroid/os/AsyncResult;->forMessage(Landroid/os/Message;Ljava/lang/Object;Ljava/lang/Throwable;)Landroid/os/AsyncResult;

    invoke-virtual {p3}, Landroid/os/Message;->sendToTarget()V

    goto :goto_2e
.end method

.method public supplyIccPuk2ForApp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Message;)V
    .registers 5
    .parameter "puk2"
    .parameter "newPin2"
    .parameter "aid"
    .parameter "response"

    .prologue
    invoke-direct {p0, p4}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public supplyIccPukForApp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Message;)V
    .registers 5
    .parameter "puk"
    .parameter "newPin"
    .parameter "aid"
    .parameter "response"

    .prologue
    invoke-direct {p0, p4}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public supplyNetworkDepersonalization(Ljava/lang/String;Landroid/os/Message;)V
    .registers 3
    .parameter "netpin"
    .parameter "result"

    .prologue
    invoke-direct {p0, p2}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public switchWaitingOrHoldingAndActive(Landroid/os/Message;)V
    .registers 6
    .parameter "result"

    .prologue
    iget-object v1, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->simulatedCallState:Lcom/android/internal/telephony/test/SimulatedGsmCallState;

    const/16 v2, 0x32

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Lcom/android/internal/telephony/test/SimulatedGsmCallState;->onChld(CC)Z

    move-result v0

    .local v0, success:Z
    if-nez v0, :cond_16

    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "Hangup Error"

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    invoke-direct {p0, p1, v1}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultFail(Landroid/os/Message;Ljava/lang/Throwable;)V

    :goto_15
    return-void

    :cond_16
    const/4 v1, 0x0

    invoke-direct {p0, p1, v1}, Lcom/android/internal/telephony/test/SimulatedCommands;->resultSuccess(Landroid/os/Message;Ljava/lang/Object;)V

    goto :goto_15
.end method

.method public triggerHangupAll()V
    .registers 2

    .prologue
    iget-object v0, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->simulatedCallState:Lcom/android/internal/telephony/test/SimulatedGsmCallState;

    invoke-virtual {v0}, Lcom/android/internal/telephony/test/SimulatedGsmCallState;->triggerHangupAll()Z

    iget-object v0, p0, Lcom/android/internal/telephony/BaseCommands;->mCallStateRegistrants:Landroid/os/RegistrantList;

    invoke-virtual {v0}, Landroid/os/RegistrantList;->notifyRegistrants()V

    return-void
.end method

.method public triggerHangupBackground()V
    .registers 2

    .prologue
    iget-object v0, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->simulatedCallState:Lcom/android/internal/telephony/test/SimulatedGsmCallState;

    invoke-virtual {v0}, Lcom/android/internal/telephony/test/SimulatedGsmCallState;->triggerHangupBackground()Z

    iget-object v0, p0, Lcom/android/internal/telephony/BaseCommands;->mCallStateRegistrants:Landroid/os/RegistrantList;

    invoke-virtual {v0}, Landroid/os/RegistrantList;->notifyRegistrants()V

    return-void
.end method

.method public triggerHangupForeground()V
    .registers 2

    .prologue
    iget-object v0, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->simulatedCallState:Lcom/android/internal/telephony/test/SimulatedGsmCallState;

    invoke-virtual {v0}, Lcom/android/internal/telephony/test/SimulatedGsmCallState;->triggerHangupForeground()Z

    iget-object v0, p0, Lcom/android/internal/telephony/BaseCommands;->mCallStateRegistrants:Landroid/os/RegistrantList;

    invoke-virtual {v0}, Landroid/os/RegistrantList;->notifyRegistrants()V

    return-void
.end method

.method public triggerIncomingSMS(Ljava/lang/String;)V
    .registers 2
    .parameter "message"

    .prologue
    return-void
.end method

.method public triggerIncomingUssd(Ljava/lang/String;Ljava/lang/String;)V
    .registers 5
    .parameter "statusCode"
    .parameter "message"

    .prologue
    iget-object v1, p0, Lcom/android/internal/telephony/BaseCommands;->mUSSDRegistrant:Landroid/os/Registrant;

    if-eqz v1, :cond_12

    const/4 v1, 0x2

    new-array v0, v1, [Ljava/lang/String;

    const/4 v1, 0x0

    aput-object p1, v0, v1

    const/4 v1, 0x1

    aput-object p2, v0, v1

    .local v0, result:[Ljava/lang/String;
    iget-object v1, p0, Lcom/android/internal/telephony/BaseCommands;->mUSSDRegistrant:Landroid/os/Registrant;

    invoke-virtual {v1, v0}, Landroid/os/Registrant;->notifyResult(Ljava/lang/Object;)V

    .end local v0           #result:[Ljava/lang/String;
    :cond_12
    return-void
.end method

.method public triggerRing(Ljava/lang/String;)V
    .registers 3
    .parameter "number"

    .prologue
    iget-object v0, p0, Lcom/android/internal/telephony/test/SimulatedCommands;->simulatedCallState:Lcom/android/internal/telephony/test/SimulatedGsmCallState;

    invoke-virtual {v0, p1}, Lcom/android/internal/telephony/test/SimulatedGsmCallState;->triggerRing(Ljava/lang/String;)Z

    iget-object v0, p0, Lcom/android/internal/telephony/BaseCommands;->mCallStateRegistrants:Landroid/os/RegistrantList;

    invoke-virtual {v0}, Landroid/os/RegistrantList;->notifyRegistrants()V

    return-void
.end method

.method public triggerSsn(II)V
    .registers 7
    .parameter "type"
    .parameter "code"

    .prologue
    const/4 v3, 0x0

    new-instance v0, Lcom/android/internal/telephony/gsm/SuppServiceNotification;

    invoke-direct {v0}, Lcom/android/internal/telephony/gsm/SuppServiceNotification;-><init>()V

    .local v0, not:Lcom/android/internal/telephony/gsm/SuppServiceNotification;
    iput p1, v0, Lcom/android/internal/telephony/gsm/SuppServiceNotification;->notificationType:I

    iput p2, v0, Lcom/android/internal/telephony/gsm/SuppServiceNotification;->code:I

    iget-object v1, p0, Lcom/android/internal/telephony/BaseCommands;->mSsnRegistrant:Landroid/os/Registrant;

    new-instance v2, Landroid/os/AsyncResult;

    invoke-direct {v2, v3, v0, v3}, Landroid/os/AsyncResult;-><init>(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Throwable;)V

    invoke-virtual {v1, v2}, Landroid/os/Registrant;->notifyRegistrant(Landroid/os/AsyncResult;)V

    return-void
.end method

.method public writeSmsToRuim(ILjava/lang/String;Landroid/os/Message;)V
    .registers 7
    .parameter "status"
    .parameter "pdu"
    .parameter "response"

    .prologue
    const-string v0, "SIM"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Write SMS to RUIM with status "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    invoke-direct {p0, p3}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method

.method public writeSmsToSim(ILjava/lang/String;Ljava/lang/String;Landroid/os/Message;)V
    .registers 8
    .parameter "status"
    .parameter "smsc"
    .parameter "pdu"
    .parameter "response"

    .prologue
    const-string v0, "SIM"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Write SMS to SIM with status "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    invoke-direct {p0, p4}, Lcom/android/internal/telephony/test/SimulatedCommands;->unimplemented(Landroid/os/Message;)V

    return-void
.end method
