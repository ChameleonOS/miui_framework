.class Lcom/android/internal/telephony/test/CallInfo;
.super Ljava/lang/Object;
.source "SimulatedGsmCallState.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/internal/telephony/test/CallInfo$State;
    }
.end annotation


# instance fields
.field TOA:I

.field isMT:Z

.field isMpty:Z

.field number:Ljava/lang/String;

.field state:Lcom/android/internal/telephony/test/CallInfo$State;


# direct methods
.method constructor <init>(ZLcom/android/internal/telephony/test/CallInfo$State;ZLjava/lang/String;)V
    .registers 7
    .parameter "isMT"
    .parameter "state"
    .parameter "isMpty"
    .parameter "number"

    .prologue
    .line 51
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 52
    iput-boolean p1, p0, Lcom/android/internal/telephony/test/CallInfo;->isMT:Z

    .line 53
    iput-object p2, p0, Lcom/android/internal/telephony/test/CallInfo;->state:Lcom/android/internal/telephony/test/CallInfo$State;

    .line 54
    iput-boolean p3, p0, Lcom/android/internal/telephony/test/CallInfo;->isMpty:Z

    .line 55
    iput-object p4, p0, Lcom/android/internal/telephony/test/CallInfo;->number:Ljava/lang/String;

    .line 57
    invoke-virtual {p4}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_1f

    const/4 v0, 0x0

    invoke-virtual {p4, v0}, Ljava/lang/String;->charAt(I)C

    move-result v0

    const/16 v1, 0x2b

    if-ne v0, v1, :cond_1f

    .line 58
    const/16 v0, 0x91

    iput v0, p0, Lcom/android/internal/telephony/test/CallInfo;->TOA:I

    .line 62
    :goto_1e
    return-void

    .line 60
    :cond_1f
    const/16 v0, 0x81

    iput v0, p0, Lcom/android/internal/telephony/test/CallInfo;->TOA:I

    goto :goto_1e
.end method

.method static createIncomingCall(Ljava/lang/String;)Lcom/android/internal/telephony/test/CallInfo;
    .registers 5
    .parameter "number"

    .prologue
    .line 71
    new-instance v0, Lcom/android/internal/telephony/test/CallInfo;

    const/4 v1, 0x1

    sget-object v2, Lcom/android/internal/telephony/test/CallInfo$State;->INCOMING:Lcom/android/internal/telephony/test/CallInfo$State;

    const/4 v3, 0x0

    invoke-direct {v0, v1, v2, v3, p0}, Lcom/android/internal/telephony/test/CallInfo;-><init>(ZLcom/android/internal/telephony/test/CallInfo$State;ZLjava/lang/String;)V

    return-object v0
.end method

.method static createOutgoingCall(Ljava/lang/String;)Lcom/android/internal/telephony/test/CallInfo;
    .registers 4
    .parameter "number"

    .prologue
    const/4 v2, 0x0

    .line 66
    new-instance v0, Lcom/android/internal/telephony/test/CallInfo;

    sget-object v1, Lcom/android/internal/telephony/test/CallInfo$State;->DIALING:Lcom/android/internal/telephony/test/CallInfo$State;

    invoke-direct {v0, v2, v1, v2, p0}, Lcom/android/internal/telephony/test/CallInfo;-><init>(ZLcom/android/internal/telephony/test/CallInfo$State;ZLjava/lang/String;)V

    return-object v0
.end method


# virtual methods
.method isActiveOrHeld()Z
    .registers 3

    .prologue
    .line 110
    iget-object v0, p0, Lcom/android/internal/telephony/test/CallInfo;->state:Lcom/android/internal/telephony/test/CallInfo$State;

    sget-object v1, Lcom/android/internal/telephony/test/CallInfo$State;->ACTIVE:Lcom/android/internal/telephony/test/CallInfo$State;

    if-eq v0, v1, :cond_c

    iget-object v0, p0, Lcom/android/internal/telephony/test/CallInfo;->state:Lcom/android/internal/telephony/test/CallInfo$State;

    sget-object v1, Lcom/android/internal/telephony/test/CallInfo$State;->HOLDING:Lcom/android/internal/telephony/test/CallInfo$State;

    if-ne v0, v1, :cond_e

    :cond_c
    const/4 v0, 0x1

    :goto_d
    return v0

    :cond_e
    const/4 v0, 0x0

    goto :goto_d
.end method

.method isConnecting()Z
    .registers 3

    .prologue
    .line 115
    iget-object v0, p0, Lcom/android/internal/telephony/test/CallInfo;->state:Lcom/android/internal/telephony/test/CallInfo$State;

    sget-object v1, Lcom/android/internal/telephony/test/CallInfo$State;->DIALING:Lcom/android/internal/telephony/test/CallInfo$State;

    if-eq v0, v1, :cond_c

    iget-object v0, p0, Lcom/android/internal/telephony/test/CallInfo;->state:Lcom/android/internal/telephony/test/CallInfo$State;

    sget-object v1, Lcom/android/internal/telephony/test/CallInfo$State;->ALERTING:Lcom/android/internal/telephony/test/CallInfo$State;

    if-ne v0, v1, :cond_e

    :cond_c
    const/4 v0, 0x1

    :goto_d
    return v0

    :cond_e
    const/4 v0, 0x0

    goto :goto_d
.end method

.method isRinging()Z
    .registers 3

    .prologue
    .line 120
    iget-object v0, p0, Lcom/android/internal/telephony/test/CallInfo;->state:Lcom/android/internal/telephony/test/CallInfo$State;

    sget-object v1, Lcom/android/internal/telephony/test/CallInfo$State;->INCOMING:Lcom/android/internal/telephony/test/CallInfo$State;

    if-eq v0, v1, :cond_c

    iget-object v0, p0, Lcom/android/internal/telephony/test/CallInfo;->state:Lcom/android/internal/telephony/test/CallInfo$State;

    sget-object v1, Lcom/android/internal/telephony/test/CallInfo$State;->WAITING:Lcom/android/internal/telephony/test/CallInfo$State;

    if-ne v0, v1, :cond_e

    :cond_c
    const/4 v0, 0x1

    :goto_d
    return v0

    :cond_e
    const/4 v0, 0x0

    goto :goto_d
.end method

.method toCLCCLine(I)Ljava/lang/String;
    .registers 4
    .parameter "index"

    .prologue
    .line 76
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "+CLCC: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ","

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v0, p0, Lcom/android/internal/telephony/test/CallInfo;->isMT:Z

    if-eqz v0, :cond_5c

    const-string v0, "1"

    :goto_1b
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ","

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/android/internal/telephony/test/CallInfo;->state:Lcom/android/internal/telephony/test/CallInfo$State;

    invoke-virtual {v1}, Lcom/android/internal/telephony/test/CallInfo$State;->value()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",0,"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v0, p0, Lcom/android/internal/telephony/test/CallInfo;->isMpty:Z

    if-eqz v0, :cond_5f

    const-string v0, "1"

    :goto_3b
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/android/internal/telephony/test/CallInfo;->number:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\","

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/android/internal/telephony/test/CallInfo;->TOA:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_5c
    const-string v0, "0"

    goto :goto_1b

    :cond_5f
    const-string v0, "0"

    goto :goto_3b
.end method

.method toDriverCall(I)Lcom/android/internal/telephony/DriverCall;
    .registers 6
    .parameter "index"

    .prologue
    .line 87
    new-instance v1, Lcom/android/internal/telephony/DriverCall;

    invoke-direct {v1}, Lcom/android/internal/telephony/DriverCall;-><init>()V

    .line 89
    .local v1, ret:Lcom/android/internal/telephony/DriverCall;
    iput p1, v1, Lcom/android/internal/telephony/DriverCall;->index:I

    .line 90
    iget-boolean v2, p0, Lcom/android/internal/telephony/test/CallInfo;->isMT:Z

    iput-boolean v2, v1, Lcom/android/internal/telephony/DriverCall;->isMT:Z

    .line 93
    :try_start_b
    iget-object v2, p0, Lcom/android/internal/telephony/test/CallInfo;->state:Lcom/android/internal/telephony/test/CallInfo$State;

    invoke-virtual {v2}, Lcom/android/internal/telephony/test/CallInfo$State;->value()I

    move-result v2

    invoke-static {v2}, Lcom/android/internal/telephony/DriverCall;->stateFromCLCC(I)Lcom/android/internal/telephony/DriverCall$State;

    move-result-object v2

    iput-object v2, v1, Lcom/android/internal/telephony/DriverCall;->state:Lcom/android/internal/telephony/DriverCall$State;
    :try_end_17
    .catch Lcom/android/internal/telephony/ATParseEx; {:try_start_b .. :try_end_17} :catch_2a

    .line 98
    iget-boolean v2, p0, Lcom/android/internal/telephony/test/CallInfo;->isMpty:Z

    iput-boolean v2, v1, Lcom/android/internal/telephony/DriverCall;->isMpty:Z

    .line 99
    iget-object v2, p0, Lcom/android/internal/telephony/test/CallInfo;->number:Ljava/lang/String;

    iput-object v2, v1, Lcom/android/internal/telephony/DriverCall;->number:Ljava/lang/String;

    .line 100
    iget v2, p0, Lcom/android/internal/telephony/test/CallInfo;->TOA:I

    iput v2, v1, Lcom/android/internal/telephony/DriverCall;->TOA:I

    .line 101
    const/4 v2, 0x1

    iput-boolean v2, v1, Lcom/android/internal/telephony/DriverCall;->isVoice:Z

    .line 102
    const/4 v2, 0x0

    iput v2, v1, Lcom/android/internal/telephony/DriverCall;->als:I

    .line 104
    return-object v1

    .line 94
    :catch_2a
    move-exception v0

    .line 95
    .local v0, ex:Lcom/android/internal/telephony/ATParseEx;
    new-instance v2, Ljava/lang/RuntimeException;

    const-string/jumbo v3, "should never happen"

    invoke-direct {v2, v3, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2
.end method
