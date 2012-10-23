.class Lcom/android/internal/telephony/gsm/GsmCall;
.super Lcom/android/internal/telephony/Call;
.source "GsmCall.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/internal/telephony/gsm/GsmCall$1;
    }
.end annotation


# instance fields
.field connections:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/internal/telephony/Connection;",
            ">;"
        }
    .end annotation
.end field

.field owner:Lcom/android/internal/telephony/gsm/GsmCallTracker;


# direct methods
.method constructor <init>(Lcom/android/internal/telephony/gsm/GsmCallTracker;)V
    .registers 3
    .parameter "owner"

    .prologue
    .line 56
    invoke-direct {p0}, Lcom/android/internal/telephony/Call;-><init>()V

    .line 34
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/android/internal/telephony/gsm/GsmCall;->connections:Ljava/util/ArrayList;

    .line 57
    iput-object p1, p0, Lcom/android/internal/telephony/gsm/GsmCall;->owner:Lcom/android/internal/telephony/gsm/GsmCallTracker;

    .line 58
    return-void
.end method

.method static stateFromDCState(Lcom/android/internal/telephony/DriverCall$State;)Lcom/android/internal/telephony/Call$State;
    .registers 4
    .parameter "dcState"

    .prologue
    .line 42
    sget-object v0, Lcom/android/internal/telephony/gsm/GsmCall$1;->$SwitchMap$com$android$internal$telephony$DriverCall$State:[I

    invoke-virtual {p0}, Lcom/android/internal/telephony/DriverCall$State;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_36

    .line 49
    new-instance v0, Ljava/lang/RuntimeException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "illegal call state:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 43
    :pswitch_24
    sget-object v0, Lcom/android/internal/telephony/Call$State;->ACTIVE:Lcom/android/internal/telephony/Call$State;

    .line 48
    :goto_26
    return-object v0

    .line 44
    :pswitch_27
    sget-object v0, Lcom/android/internal/telephony/Call$State;->HOLDING:Lcom/android/internal/telephony/Call$State;

    goto :goto_26

    .line 45
    :pswitch_2a
    sget-object v0, Lcom/android/internal/telephony/Call$State;->DIALING:Lcom/android/internal/telephony/Call$State;

    goto :goto_26

    .line 46
    :pswitch_2d
    sget-object v0, Lcom/android/internal/telephony/Call$State;->ALERTING:Lcom/android/internal/telephony/Call$State;

    goto :goto_26

    .line 47
    :pswitch_30
    sget-object v0, Lcom/android/internal/telephony/Call$State;->INCOMING:Lcom/android/internal/telephony/Call$State;

    goto :goto_26

    .line 48
    :pswitch_33
    sget-object v0, Lcom/android/internal/telephony/Call$State;->WAITING:Lcom/android/internal/telephony/Call$State;

    goto :goto_26

    .line 42
    :pswitch_data_36
    .packed-switch 0x1
        :pswitch_24
        :pswitch_27
        :pswitch_2a
        :pswitch_2d
        :pswitch_30
        :pswitch_33
    .end packed-switch
.end method


# virtual methods
.method attach(Lcom/android/internal/telephony/Connection;Lcom/android/internal/telephony/DriverCall;)V
    .registers 4
    .parameter "conn"
    .parameter "dc"

    .prologue
    .line 99
    iget-object v0, p0, Lcom/android/internal/telephony/gsm/GsmCall;->connections:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 101
    iget-object v0, p2, Lcom/android/internal/telephony/DriverCall;->state:Lcom/android/internal/telephony/DriverCall$State;

    invoke-static {v0}, Lcom/android/internal/telephony/gsm/GsmCall;->stateFromDCState(Lcom/android/internal/telephony/DriverCall$State;)Lcom/android/internal/telephony/Call$State;

    move-result-object v0

    iput-object v0, p0, Lcom/android/internal/telephony/Call;->state:Lcom/android/internal/telephony/Call$State;

    .line 102
    return-void
.end method

.method attachFake(Lcom/android/internal/telephony/Connection;Lcom/android/internal/telephony/Call$State;)V
    .registers 4
    .parameter "conn"
    .parameter "state"

    .prologue
    .line 106
    iget-object v0, p0, Lcom/android/internal/telephony/gsm/GsmCall;->connections:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 108
    iput-object p2, p0, Lcom/android/internal/telephony/Call;->state:Lcom/android/internal/telephony/Call$State;

    .line 109
    return-void
.end method

.method clearDisconnected()V
    .registers 5

    .prologue
    .line 195
    iget-object v2, p0, Lcom/android/internal/telephony/gsm/GsmCall;->connections:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    add-int/lit8 v1, v2, -0x1

    .local v1, i:I
    :goto_8
    if-ltz v1, :cond_22

    .line 196
    iget-object v2, p0, Lcom/android/internal/telephony/gsm/GsmCall;->connections:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/internal/telephony/gsm/GsmConnection;

    .line 198
    .local v0, cn:Lcom/android/internal/telephony/gsm/GsmConnection;
    invoke-virtual {v0}, Lcom/android/internal/telephony/gsm/GsmConnection;->getState()Lcom/android/internal/telephony/Call$State;

    move-result-object v2

    sget-object v3, Lcom/android/internal/telephony/Call$State;->DISCONNECTED:Lcom/android/internal/telephony/Call$State;

    if-ne v2, v3, :cond_1f

    .line 199
    iget-object v2, p0, Lcom/android/internal/telephony/gsm/GsmCall;->connections:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 195
    :cond_1f
    add-int/lit8 v1, v1, -0x1

    goto :goto_8

    .line 203
    .end local v0           #cn:Lcom/android/internal/telephony/gsm/GsmConnection;
    :cond_22
    iget-object v2, p0, Lcom/android/internal/telephony/gsm/GsmCall;->connections:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-nez v2, :cond_2e

    .line 204
    sget-object v2, Lcom/android/internal/telephony/Call$State;->IDLE:Lcom/android/internal/telephony/Call$State;

    iput-object v2, p0, Lcom/android/internal/telephony/Call;->state:Lcom/android/internal/telephony/Call$State;

    .line 206
    :cond_2e
    return-void
.end method

.method connectionDisconnected(Lcom/android/internal/telephony/gsm/GsmConnection;)V
    .registers 7
    .parameter "conn"

    .prologue
    .line 116
    iget-object v3, p0, Lcom/android/internal/telephony/Call;->state:Lcom/android/internal/telephony/Call$State;

    sget-object v4, Lcom/android/internal/telephony/Call$State;->DISCONNECTED:Lcom/android/internal/telephony/Call$State;

    if-eq v3, v4, :cond_27

    .line 119
    const/4 v0, 0x1

    .line 121
    .local v0, hasOnlyDisconnectedConnections:Z
    const/4 v1, 0x0

    .local v1, i:I
    iget-object v3, p0, Lcom/android/internal/telephony/gsm/GsmCall;->connections:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v2

    .local v2, s:I
    :goto_e
    if-ge v1, v2, :cond_21

    .line 122
    iget-object v3, p0, Lcom/android/internal/telephony/gsm/GsmCall;->connections:Ljava/util/ArrayList;

    invoke-virtual {v3, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/android/internal/telephony/Connection;

    invoke-virtual {v3}, Lcom/android/internal/telephony/Connection;->getState()Lcom/android/internal/telephony/Call$State;

    move-result-object v3

    sget-object v4, Lcom/android/internal/telephony/Call$State;->DISCONNECTED:Lcom/android/internal/telephony/Call$State;

    if-eq v3, v4, :cond_28

    .line 125
    const/4 v0, 0x0

    .line 130
    :cond_21
    if-eqz v0, :cond_27

    .line 131
    sget-object v3, Lcom/android/internal/telephony/Call$State;->DISCONNECTED:Lcom/android/internal/telephony/Call$State;

    iput-object v3, p0, Lcom/android/internal/telephony/Call;->state:Lcom/android/internal/telephony/Call$State;

    .line 134
    .end local v0           #hasOnlyDisconnectedConnections:Z
    .end local v1           #i:I
    .end local v2           #s:I
    :cond_27
    return-void

    .line 121
    .restart local v0       #hasOnlyDisconnectedConnections:Z
    .restart local v1       #i:I
    .restart local v2       #s:I
    :cond_28
    add-int/lit8 v1, v1, 0x1

    goto :goto_e
.end method

.method detach(Lcom/android/internal/telephony/gsm/GsmConnection;)V
    .registers 3
    .parameter "conn"

    .prologue
    .line 139
    iget-object v0, p0, Lcom/android/internal/telephony/gsm/GsmCall;->connections:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 141
    iget-object v0, p0, Lcom/android/internal/telephony/gsm/GsmCall;->connections:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-nez v0, :cond_11

    .line 142
    sget-object v0, Lcom/android/internal/telephony/Call$State;->IDLE:Lcom/android/internal/telephony/Call$State;

    iput-object v0, p0, Lcom/android/internal/telephony/Call;->state:Lcom/android/internal/telephony/Call$State;

    .line 144
    :cond_11
    return-void
.end method

.method public dispose()V
    .registers 1

    .prologue
    .line 61
    return-void
.end method

.method public getConnections()Ljava/util/List;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/android/internal/telephony/Connection;",
            ">;"
        }
    .end annotation

    .prologue
    .line 68
    iget-object v0, p0, Lcom/android/internal/telephony/gsm/GsmCall;->connections:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getPhone()Lcom/android/internal/telephony/Phone;
    .registers 2

    .prologue
    .line 73
    iget-object v0, p0, Lcom/android/internal/telephony/gsm/GsmCall;->owner:Lcom/android/internal/telephony/gsm/GsmCallTracker;

    iget-object v0, v0, Lcom/android/internal/telephony/gsm/GsmCallTracker;->phone:Lcom/android/internal/telephony/gsm/GSMPhone;

    return-object v0
.end method

.method public hangup()V
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/android/internal/telephony/CallStateException;
        }
    .end annotation

    .prologue
    .line 87
    iget-object v0, p0, Lcom/android/internal/telephony/gsm/GsmCall;->owner:Lcom/android/internal/telephony/gsm/GsmCallTracker;

    invoke-virtual {v0, p0}, Lcom/android/internal/telephony/gsm/GsmCallTracker;->hangup(Lcom/android/internal/telephony/gsm/GsmCall;)V

    .line 88
    return-void
.end method

.method isFull()Z
    .registers 3

    .prologue
    .line 167
    iget-object v0, p0, Lcom/android/internal/telephony/gsm/GsmCall;->connections:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    const/4 v1, 0x5

    if-ne v0, v1, :cond_b

    const/4 v0, 0x1

    :goto_a
    return v0

    :cond_b
    const/4 v0, 0x0

    goto :goto_a
.end method

.method public isMultiparty()Z
    .registers 3

    .prologue
    const/4 v0, 0x1

    .line 78
    iget-object v1, p0, Lcom/android/internal/telephony/gsm/GsmCall;->connections:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-le v1, v0, :cond_a

    :goto_9
    return v0

    :cond_a
    const/4 v0, 0x0

    goto :goto_9
.end method

.method onHangupLocal()V
    .registers 5

    .prologue
    .line 180
    const/4 v1, 0x0

    .local v1, i:I
    iget-object v3, p0, Lcom/android/internal/telephony/gsm/GsmCall;->connections:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v2

    .line 181
    .local v2, s:I
    :goto_7
    if-ge v1, v2, :cond_17

    .line 183
    iget-object v3, p0, Lcom/android/internal/telephony/gsm/GsmCall;->connections:Ljava/util/ArrayList;

    invoke-virtual {v3, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/internal/telephony/gsm/GsmConnection;

    .line 185
    .local v0, cn:Lcom/android/internal/telephony/gsm/GsmConnection;
    invoke-virtual {v0}, Lcom/android/internal/telephony/gsm/GsmConnection;->onHangupLocal()V

    .line 181
    add-int/lit8 v1, v1, 0x1

    goto :goto_7

    .line 187
    .end local v0           #cn:Lcom/android/internal/telephony/gsm/GsmConnection;
    :cond_17
    sget-object v3, Lcom/android/internal/telephony/Call$State;->DISCONNECTING:Lcom/android/internal/telephony/Call$State;

    iput-object v3, p0, Lcom/android/internal/telephony/Call;->state:Lcom/android/internal/telephony/Call$State;

    .line 188
    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 2

    .prologue
    .line 92
    iget-object v0, p0, Lcom/android/internal/telephony/Call;->state:Lcom/android/internal/telephony/Call$State;

    invoke-virtual {v0}, Lcom/android/internal/telephony/Call$State;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method update(Lcom/android/internal/telephony/gsm/GsmConnection;Lcom/android/internal/telephony/DriverCall;)Z
    .registers 6
    .parameter "conn"
    .parameter "dc"

    .prologue
    .line 149
    const/4 v0, 0x0

    .line 151
    .local v0, changed:Z
    iget-object v2, p2, Lcom/android/internal/telephony/DriverCall;->state:Lcom/android/internal/telephony/DriverCall$State;

    invoke-static {v2}, Lcom/android/internal/telephony/gsm/GsmCall;->stateFromDCState(Lcom/android/internal/telephony/DriverCall$State;)Lcom/android/internal/telephony/Call$State;

    move-result-object v1

    .line 153
    .local v1, newState:Lcom/android/internal/telephony/Call$State;
    iget-object v2, p0, Lcom/android/internal/telephony/Call;->state:Lcom/android/internal/telephony/Call$State;

    if-eq v1, v2, :cond_e

    .line 154
    iput-object v1, p0, Lcom/android/internal/telephony/Call;->state:Lcom/android/internal/telephony/Call$State;

    .line 155
    const/4 v0, 0x1

    .line 158
    :cond_e
    return v0
.end method
