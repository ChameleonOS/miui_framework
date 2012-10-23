.class abstract Lcom/android/internal/telephony/sip/SipConnectionBase;
.super Lcom/android/internal/telephony/Connection;
.source "SipConnectionBase.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/internal/telephony/sip/SipConnectionBase$1;
    }
.end annotation


# static fields
.field private static final LOG_TAG:Ljava/lang/String; = "SIP_CONN"


# instance fields
.field private connectTime:J

.field private connectTimeReal:J

.field private createTime:J

.field private dialString:Ljava/lang/String;

.field private disconnectTime:J

.field private duration:J

.field private holdingStartTime:J

.field private isIncoming:Z

.field private mCause:Lcom/android/internal/telephony/Connection$DisconnectCause;

.field private mSipAudioCall:Landroid/net/sip/SipAudioCall;

.field private nextPostDialChar:I

.field private postDialState:Lcom/android/internal/telephony/Connection$PostDialState;

.field private postDialString:Ljava/lang/String;


# direct methods
.method constructor <init>(Ljava/lang/String;)V
    .registers 4
    .parameter "dialString"

    .prologue
    .line 60
    invoke-direct {p0}, Lcom/android/internal/telephony/Connection;-><init>()V

    .line 53
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/android/internal/telephony/sip/SipConnectionBase;->duration:J

    .line 57
    sget-object v0, Lcom/android/internal/telephony/Connection$DisconnectCause;->NOT_DISCONNECTED:Lcom/android/internal/telephony/Connection$DisconnectCause;

    iput-object v0, p0, Lcom/android/internal/telephony/sip/SipConnectionBase;->mCause:Lcom/android/internal/telephony/Connection$DisconnectCause;

    .line 58
    sget-object v0, Lcom/android/internal/telephony/Connection$PostDialState;->NOT_STARTED:Lcom/android/internal/telephony/Connection$PostDialState;

    iput-object v0, p0, Lcom/android/internal/telephony/sip/SipConnectionBase;->postDialState:Lcom/android/internal/telephony/Connection$PostDialState;

    .line 61
    iput-object p1, p0, Lcom/android/internal/telephony/sip/SipConnectionBase;->dialString:Ljava/lang/String;

    .line 63
    invoke-static {p1}, Landroid/telephony/PhoneNumberUtils;->extractPostDialPortion(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/internal/telephony/sip/SipConnectionBase;->postDialString:Ljava/lang/String;

    .line 65
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/internal/telephony/sip/SipConnectionBase;->isIncoming:Z

    .line 66
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/android/internal/telephony/sip/SipConnectionBase;->createTime:J

    .line 67
    return-void
.end method

.method private log(Ljava/lang/String;)V
    .registers 5
    .parameter "msg"

    .prologue
    .line 167
    const-string v0, "SIP_CONN"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "[SipConn] "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 168
    return-void
.end method


# virtual methods
.method public cancelPostDial()V
    .registers 1

    .prologue
    .line 150
    return-void
.end method

.method public getConnectTime()J
    .registers 3

    .prologue
    .line 94
    iget-wide v0, p0, Lcom/android/internal/telephony/sip/SipConnectionBase;->connectTime:J

    return-wide v0
.end method

.method public getCreateTime()J
    .registers 3

    .prologue
    .line 89
    iget-wide v0, p0, Lcom/android/internal/telephony/sip/SipConnectionBase;->createTime:J

    return-wide v0
.end method

.method public getDisconnectCause()Lcom/android/internal/telephony/Connection$DisconnectCause;
    .registers 2

    .prologue
    .line 125
    iget-object v0, p0, Lcom/android/internal/telephony/sip/SipConnectionBase;->mCause:Lcom/android/internal/telephony/Connection$DisconnectCause;

    return-object v0
.end method

.method public getDisconnectTime()J
    .registers 3

    .prologue
    .line 99
    iget-wide v0, p0, Lcom/android/internal/telephony/sip/SipConnectionBase;->disconnectTime:J

    return-wide v0
.end method

.method public getDurationMillis()J
    .registers 5

    .prologue
    const-wide/16 v0, 0x0

    .line 104
    iget-wide v2, p0, Lcom/android/internal/telephony/sip/SipConnectionBase;->connectTimeReal:J

    cmp-long v2, v2, v0

    if-nez v2, :cond_9

    .line 109
    :goto_8
    return-wide v0

    .line 106
    :cond_9
    iget-wide v2, p0, Lcom/android/internal/telephony/sip/SipConnectionBase;->duration:J

    cmp-long v0, v2, v0

    if-gez v0, :cond_17

    .line 107
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v0

    iget-wide v2, p0, Lcom/android/internal/telephony/sip/SipConnectionBase;->connectTimeReal:J

    sub-long/2addr v0, v2

    goto :goto_8

    .line 109
    :cond_17
    iget-wide v0, p0, Lcom/android/internal/telephony/sip/SipConnectionBase;->duration:J

    goto :goto_8
.end method

.method public getHoldDurationMillis()J
    .registers 5

    .prologue
    .line 115
    invoke-virtual {p0}, Lcom/android/internal/telephony/sip/SipConnectionBase;->getState()Lcom/android/internal/telephony/Call$State;

    move-result-object v0

    sget-object v1, Lcom/android/internal/telephony/Call$State;->HOLDING:Lcom/android/internal/telephony/Call$State;

    if-eq v0, v1, :cond_b

    .line 117
    const-wide/16 v0, 0x0

    .line 119
    :goto_a
    return-wide v0

    :cond_b
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v0

    iget-wide v2, p0, Lcom/android/internal/telephony/sip/SipConnectionBase;->holdingStartTime:J

    sub-long/2addr v0, v2

    goto :goto_a
.end method

.method public getNumberPresentation()I
    .registers 2

    .prologue
    .line 173
    sget v0, Lcom/android/internal/telephony/Connection;->PRESENTATION_ALLOWED:I

    return v0
.end method

.method protected abstract getPhone()Lcom/android/internal/telephony/Phone;
.end method

.method public getPostDialState()Lcom/android/internal/telephony/Connection$PostDialState;
    .registers 2

    .prologue
    .line 134
    iget-object v0, p0, Lcom/android/internal/telephony/sip/SipConnectionBase;->postDialState:Lcom/android/internal/telephony/Connection$PostDialState;

    return-object v0
.end method

.method public getRemainingPostDialString()Ljava/lang/String;
    .registers 3

    .prologue
    .line 156
    iget-object v0, p0, Lcom/android/internal/telephony/sip/SipConnectionBase;->postDialState:Lcom/android/internal/telephony/Connection$PostDialState;

    sget-object v1, Lcom/android/internal/telephony/Connection$PostDialState;->CANCELLED:Lcom/android/internal/telephony/Connection$PostDialState;

    if-eq v0, v1, :cond_1a

    iget-object v0, p0, Lcom/android/internal/telephony/sip/SipConnectionBase;->postDialState:Lcom/android/internal/telephony/Connection$PostDialState;

    sget-object v1, Lcom/android/internal/telephony/Connection$PostDialState;->COMPLETE:Lcom/android/internal/telephony/Connection$PostDialState;

    if-eq v0, v1, :cond_1a

    iget-object v0, p0, Lcom/android/internal/telephony/sip/SipConnectionBase;->postDialString:Ljava/lang/String;

    if-eqz v0, :cond_1a

    iget-object v0, p0, Lcom/android/internal/telephony/sip/SipConnectionBase;->postDialString:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    iget v1, p0, Lcom/android/internal/telephony/sip/SipConnectionBase;->nextPostDialChar:I

    if-gt v0, v1, :cond_1d

    .line 160
    :cond_1a
    const-string v0, ""

    .line 163
    :goto_1c
    return-object v0

    :cond_1d
    iget-object v0, p0, Lcom/android/internal/telephony/sip/SipConnectionBase;->postDialString:Ljava/lang/String;

    iget v1, p0, Lcom/android/internal/telephony/sip/SipConnectionBase;->nextPostDialChar:I

    invoke-virtual {v0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_1c
.end method

.method public getUUSInfo()Lcom/android/internal/telephony/UUSInfo;
    .registers 2

    .prologue
    .line 179
    const/4 v0, 0x0

    return-object v0
.end method

.method public proceedAfterWaitChar()V
    .registers 1

    .prologue
    .line 140
    return-void
.end method

.method public proceedAfterWildChar(Ljava/lang/String;)V
    .registers 2
    .parameter "str"

    .prologue
    .line 145
    return-void
.end method

.method setDisconnectCause(Lcom/android/internal/telephony/Connection$DisconnectCause;)V
    .registers 2
    .parameter "cause"

    .prologue
    .line 129
    iput-object p1, p0, Lcom/android/internal/telephony/sip/SipConnectionBase;->mCause:Lcom/android/internal/telephony/Connection$DisconnectCause;

    .line 130
    return-void
.end method

.method protected setState(Lcom/android/internal/telephony/Call$State;)V
    .registers 6
    .parameter "state"

    .prologue
    .line 70
    sget-object v0, Lcom/android/internal/telephony/sip/SipConnectionBase$1;->$SwitchMap$com$android$internal$telephony$Call$State:[I

    invoke-virtual {p1}, Lcom/android/internal/telephony/Call$State;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_36

    .line 85
    :cond_b
    :goto_b
    return-void

    .line 72
    :pswitch_c
    iget-wide v0, p0, Lcom/android/internal/telephony/sip/SipConnectionBase;->connectTime:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_b

    .line 73
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/android/internal/telephony/sip/SipConnectionBase;->connectTimeReal:J

    .line 74
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/android/internal/telephony/sip/SipConnectionBase;->connectTime:J

    goto :goto_b

    .line 78
    :pswitch_21
    invoke-virtual {p0}, Lcom/android/internal/telephony/sip/SipConnectionBase;->getDurationMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/android/internal/telephony/sip/SipConnectionBase;->duration:J

    .line 79
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/android/internal/telephony/sip/SipConnectionBase;->disconnectTime:J

    goto :goto_b

    .line 82
    :pswitch_2e
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/android/internal/telephony/sip/SipConnectionBase;->holdingStartTime:J

    goto :goto_b

    .line 70
    nop

    :pswitch_data_36
    .packed-switch 0x1
        :pswitch_c
        :pswitch_21
        :pswitch_2e
    .end packed-switch
.end method
