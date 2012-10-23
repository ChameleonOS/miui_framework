.class public Lcom/android/internal/telephony/DefaultPhoneNotifier;
.super Ljava/lang/Object;
.source "DefaultPhoneNotifier.java"

# interfaces
.implements Lcom/android/internal/telephony/PhoneNotifier;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/internal/telephony/DefaultPhoneNotifier$1;
    }
.end annotation


# static fields
.field private static final DBG:Z = true

.field static final LOG_TAG:Ljava/lang/String; = "GSM"


# instance fields
.field private mRegistry:Lcom/android/internal/telephony/ITelephonyRegistry;


# direct methods
.method constructor <init>()V
    .registers 2

    .prologue
    .line 41
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 42
    const-string/jumbo v0, "telephony.registry"

    invoke-static {v0}, Landroid/os/ServiceManager;->getService(Ljava/lang/String;)Landroid/os/IBinder;

    move-result-object v0

    invoke-static {v0}, Lcom/android/internal/telephony/ITelephonyRegistry$Stub;->asInterface(Landroid/os/IBinder;)Lcom/android/internal/telephony/ITelephonyRegistry;

    move-result-object v0

    iput-object v0, p0, Lcom/android/internal/telephony/DefaultPhoneNotifier;->mRegistry:Lcom/android/internal/telephony/ITelephonyRegistry;

    .line 44
    return-void
.end method

.method public static convertCallState(Lcom/android/internal/telephony/Phone$State;)I
    .registers 3
    .parameter "state"

    .prologue
    .line 185
    sget-object v0, Lcom/android/internal/telephony/DefaultPhoneNotifier$1;->$SwitchMap$com$android$internal$telephony$Phone$State:[I

    invoke-virtual {p0}, Lcom/android/internal/telephony/Phone$State;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_12

    .line 191
    const/4 v0, 0x0

    :goto_c
    return v0

    .line 187
    :pswitch_d
    const/4 v0, 0x1

    goto :goto_c

    .line 189
    :pswitch_f
    const/4 v0, 0x2

    goto :goto_c

    .line 185
    nop

    :pswitch_data_12
    .packed-switch 0x1
        :pswitch_d
        :pswitch_f
    .end packed-switch
.end method

.method public static convertCallState(I)Lcom/android/internal/telephony/Phone$State;
    .registers 2
    .parameter "state"

    .prologue
    .line 200
    packed-switch p0, :pswitch_data_c

    .line 206
    sget-object v0, Lcom/android/internal/telephony/Phone$State;->IDLE:Lcom/android/internal/telephony/Phone$State;

    :goto_5
    return-object v0

    .line 202
    :pswitch_6
    sget-object v0, Lcom/android/internal/telephony/Phone$State;->RINGING:Lcom/android/internal/telephony/Phone$State;

    goto :goto_5

    .line 204
    :pswitch_9
    sget-object v0, Lcom/android/internal/telephony/Phone$State;->OFFHOOK:Lcom/android/internal/telephony/Phone$State;

    goto :goto_5

    .line 200
    :pswitch_data_c
    .packed-switch 0x1
        :pswitch_6
        :pswitch_9
    .end packed-switch
.end method

.method public static convertDataActivityState(Lcom/android/internal/telephony/Phone$DataActivityState;)I
    .registers 3
    .parameter "state"

    .prologue
    .line 249
    sget-object v0, Lcom/android/internal/telephony/DefaultPhoneNotifier$1;->$SwitchMap$com$android$internal$telephony$Phone$DataActivityState:[I

    invoke-virtual {p0}, Lcom/android/internal/telephony/Phone$DataActivityState;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_16

    .line 259
    const/4 v0, 0x0

    :goto_c
    return v0

    .line 251
    :pswitch_d
    const/4 v0, 0x1

    goto :goto_c

    .line 253
    :pswitch_f
    const/4 v0, 0x2

    goto :goto_c

    .line 255
    :pswitch_11
    const/4 v0, 0x3

    goto :goto_c

    .line 257
    :pswitch_13
    const/4 v0, 0x4

    goto :goto_c

    .line 249
    nop

    :pswitch_data_16
    .packed-switch 0x1
        :pswitch_d
        :pswitch_f
        :pswitch_11
        :pswitch_13
    .end packed-switch
.end method

.method public static convertDataActivityState(I)Lcom/android/internal/telephony/Phone$DataActivityState;
    .registers 2
    .parameter "state"

    .prologue
    .line 268
    packed-switch p0, :pswitch_data_12

    .line 278
    sget-object v0, Lcom/android/internal/telephony/Phone$DataActivityState;->NONE:Lcom/android/internal/telephony/Phone$DataActivityState;

    :goto_5
    return-object v0

    .line 270
    :pswitch_6
    sget-object v0, Lcom/android/internal/telephony/Phone$DataActivityState;->DATAIN:Lcom/android/internal/telephony/Phone$DataActivityState;

    goto :goto_5

    .line 272
    :pswitch_9
    sget-object v0, Lcom/android/internal/telephony/Phone$DataActivityState;->DATAOUT:Lcom/android/internal/telephony/Phone$DataActivityState;

    goto :goto_5

    .line 274
    :pswitch_c
    sget-object v0, Lcom/android/internal/telephony/Phone$DataActivityState;->DATAINANDOUT:Lcom/android/internal/telephony/Phone$DataActivityState;

    goto :goto_5

    .line 276
    :pswitch_f
    sget-object v0, Lcom/android/internal/telephony/Phone$DataActivityState;->DORMANT:Lcom/android/internal/telephony/Phone$DataActivityState;

    goto :goto_5

    .line 268
    :pswitch_data_12
    .packed-switch 0x1
        :pswitch_6
        :pswitch_9
        :pswitch_c
        :pswitch_f
    .end packed-switch
.end method

.method public static convertDataState(Lcom/android/internal/telephony/Phone$DataState;)I
    .registers 3
    .parameter "state"

    .prologue
    .line 215
    sget-object v0, Lcom/android/internal/telephony/DefaultPhoneNotifier$1;->$SwitchMap$com$android$internal$telephony$Phone$DataState:[I

    invoke-virtual {p0}, Lcom/android/internal/telephony/Phone$DataState;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_14

    .line 223
    const/4 v0, 0x0

    :goto_c
    return v0

    .line 217
    :pswitch_d
    const/4 v0, 0x1

    goto :goto_c

    .line 219
    :pswitch_f
    const/4 v0, 0x2

    goto :goto_c

    .line 221
    :pswitch_11
    const/4 v0, 0x3

    goto :goto_c

    .line 215
    nop

    :pswitch_data_14
    .packed-switch 0x1
        :pswitch_d
        :pswitch_f
        :pswitch_11
    .end packed-switch
.end method

.method public static convertDataState(I)Lcom/android/internal/telephony/Phone$DataState;
    .registers 2
    .parameter "state"

    .prologue
    .line 232
    packed-switch p0, :pswitch_data_10

    .line 240
    sget-object v0, Lcom/android/internal/telephony/Phone$DataState;->DISCONNECTED:Lcom/android/internal/telephony/Phone$DataState;

    :goto_5
    return-object v0

    .line 234
    :pswitch_6
    sget-object v0, Lcom/android/internal/telephony/Phone$DataState;->CONNECTING:Lcom/android/internal/telephony/Phone$DataState;

    goto :goto_5

    .line 236
    :pswitch_9
    sget-object v0, Lcom/android/internal/telephony/Phone$DataState;->CONNECTED:Lcom/android/internal/telephony/Phone$DataState;

    goto :goto_5

    .line 238
    :pswitch_c
    sget-object v0, Lcom/android/internal/telephony/Phone$DataState;->SUSPENDED:Lcom/android/internal/telephony/Phone$DataState;

    goto :goto_5

    .line 232
    nop

    :pswitch_data_10
    .packed-switch 0x1
        :pswitch_6
        :pswitch_9
        :pswitch_c
    .end packed-switch
.end method

.method private doNotifyDataConnection(Lcom/android/internal/telephony/Phone;Ljava/lang/String;Ljava/lang/String;Lcom/android/internal/telephony/Phone$DataState;)V
    .registers 18
    .parameter "sender"
    .parameter "reason"
    .parameter "apnType"
    .parameter "state"

    .prologue
    .line 114
    invoke-static {}, Landroid/telephony/TelephonyManager;->getDefault()Landroid/telephony/TelephonyManager;

    move-result-object v12

    .line 115
    .local v12, telephony:Landroid/telephony/TelephonyManager;
    const/4 v7, 0x0

    .line 116
    .local v7, linkProperties:Landroid/net/LinkProperties;
    const/4 v8, 0x0

    .line 117
    .local v8, linkCapabilities:Landroid/net/LinkCapabilities;
    const/4 v10, 0x0

    .line 119
    .local v10, roaming:Z
    sget-object v1, Lcom/android/internal/telephony/Phone$DataState;->CONNECTED:Lcom/android/internal/telephony/Phone$DataState;

    move-object/from16 v0, p4

    if-ne v0, v1, :cond_19

    .line 120
    move-object/from16 v0, p3

    invoke-interface {p1, v0}, Lcom/android/internal/telephony/Phone;->getLinkProperties(Ljava/lang/String;)Landroid/net/LinkProperties;

    move-result-object v7

    .line 121
    move-object/from16 v0, p3

    invoke-interface {p1, v0}, Lcom/android/internal/telephony/Phone;->getLinkCapabilities(Ljava/lang/String;)Landroid/net/LinkCapabilities;

    move-result-object v8

    .line 123
    :cond_19
    invoke-interface {p1}, Lcom/android/internal/telephony/Phone;->getServiceState()Landroid/telephony/ServiceState;

    move-result-object v11

    .line 124
    .local v11, ss:Landroid/telephony/ServiceState;
    if-eqz v11, :cond_23

    invoke-virtual {v11}, Landroid/telephony/ServiceState;->getRoaming()Z

    move-result v10

    .line 127
    :cond_23
    :try_start_23
    iget-object v1, p0, Lcom/android/internal/telephony/DefaultPhoneNotifier;->mRegistry:Lcom/android/internal/telephony/ITelephonyRegistry;

    invoke-static/range {p4 .. p4}, Lcom/android/internal/telephony/DefaultPhoneNotifier;->convertDataState(Lcom/android/internal/telephony/Phone$DataState;)I

    move-result v2

    move-object/from16 v0, p3

    invoke-interface {p1, v0}, Lcom/android/internal/telephony/Phone;->isDataConnectivityPossible(Ljava/lang/String;)Z

    move-result v3

    move-object/from16 v0, p3

    invoke-interface {p1, v0}, Lcom/android/internal/telephony/Phone;->getActiveApnHost(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    if-eqz v12, :cond_42

    invoke-virtual {v12}, Landroid/telephony/TelephonyManager;->getNetworkType()I

    move-result v9

    :goto_3b
    move-object v4, p2

    move-object/from16 v6, p3

    invoke-interface/range {v1 .. v10}, Lcom/android/internal/telephony/ITelephonyRegistry;->notifyDataConnection(IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/LinkProperties;Landroid/net/LinkCapabilities;IZ)V
    :try_end_41
    .catch Landroid/os/RemoteException; {:try_start_23 .. :try_end_41} :catch_44

    .line 140
    :goto_41
    return-void

    .line 127
    :cond_42
    const/4 v9, 0x0

    goto :goto_3b

    .line 137
    :catch_44
    move-exception v1

    goto :goto_41
.end method

.method private log(Ljava/lang/String;)V
    .registers 5
    .parameter "s"

    .prologue
    .line 177
    const-string v0, "GSM"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "[PhoneNotifier] "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 178
    return-void
.end method


# virtual methods
.method public notifyCallForwardingChanged(Lcom/android/internal/telephony/Phone;)V
    .registers 4
    .parameter "sender"

    .prologue
    .line 90
    :try_start_0
    iget-object v0, p0, Lcom/android/internal/telephony/DefaultPhoneNotifier;->mRegistry:Lcom/android/internal/telephony/ITelephonyRegistry;

    invoke-interface {p1}, Lcom/android/internal/telephony/Phone;->getCallForwardingIndicator()Z

    move-result v1

    invoke-interface {v0, v1}, Lcom/android/internal/telephony/ITelephonyRegistry;->notifyCallForwardingChanged(Z)V
    :try_end_9
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_9} :catch_a

    .line 94
    :goto_9
    return-void

    .line 91
    :catch_a
    move-exception v0

    goto :goto_9
.end method

.method public notifyCellInfo(Lcom/android/internal/telephony/Phone;Landroid/telephony/CellInfo;)V
    .registers 4
    .parameter "sender"
    .parameter "cellInfo"

    .prologue
    .line 162
    :try_start_0
    iget-object v0, p0, Lcom/android/internal/telephony/DefaultPhoneNotifier;->mRegistry:Lcom/android/internal/telephony/ITelephonyRegistry;

    invoke-interface {v0, p2}, Lcom/android/internal/telephony/ITelephonyRegistry;->notifyCellInfo(Landroid/telephony/CellInfo;)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    .line 166
    :goto_5
    return-void

    .line 163
    :catch_6
    move-exception v0

    goto :goto_5
.end method

.method public notifyCellLocation(Lcom/android/internal/telephony/Phone;)V
    .registers 4
    .parameter "sender"

    .prologue
    .line 151
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 152
    .local v0, data:Landroid/os/Bundle;
    invoke-interface {p1}, Lcom/android/internal/telephony/Phone;->getCellLocation()Landroid/telephony/CellLocation;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/telephony/CellLocation;->fillInNotifierBundle(Landroid/os/Bundle;)V

    .line 154
    :try_start_c
    iget-object v1, p0, Lcom/android/internal/telephony/DefaultPhoneNotifier;->mRegistry:Lcom/android/internal/telephony/ITelephonyRegistry;

    invoke-interface {v1, v0}, Lcom/android/internal/telephony/ITelephonyRegistry;->notifyCellLocation(Landroid/os/Bundle;)V
    :try_end_11
    .catch Landroid/os/RemoteException; {:try_start_c .. :try_end_11} :catch_12

    .line 158
    :goto_11
    return-void

    .line 155
    :catch_12
    move-exception v1

    goto :goto_11
.end method

.method public notifyDataActivity(Lcom/android/internal/telephony/Phone;)V
    .registers 4
    .parameter "sender"

    .prologue
    .line 98
    :try_start_0
    iget-object v0, p0, Lcom/android/internal/telephony/DefaultPhoneNotifier;->mRegistry:Lcom/android/internal/telephony/ITelephonyRegistry;

    invoke-interface {p1}, Lcom/android/internal/telephony/Phone;->getDataActivityState()Lcom/android/internal/telephony/Phone$DataActivityState;

    move-result-object v1

    invoke-static {v1}, Lcom/android/internal/telephony/DefaultPhoneNotifier;->convertDataActivityState(Lcom/android/internal/telephony/Phone$DataActivityState;)I

    move-result v1

    invoke-interface {v0, v1}, Lcom/android/internal/telephony/ITelephonyRegistry;->notifyDataActivity(I)V
    :try_end_d
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_d} :catch_e

    .line 102
    :goto_d
    return-void

    .line 99
    :catch_e
    move-exception v0

    goto :goto_d
.end method

.method public notifyDataConnection(Lcom/android/internal/telephony/Phone;Ljava/lang/String;Ljava/lang/String;Lcom/android/internal/telephony/Phone$DataState;)V
    .registers 5
    .parameter "sender"
    .parameter "reason"
    .parameter "apnType"
    .parameter "state"

    .prologue
    .line 106
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/android/internal/telephony/DefaultPhoneNotifier;->doNotifyDataConnection(Lcom/android/internal/telephony/Phone;Ljava/lang/String;Ljava/lang/String;Lcom/android/internal/telephony/Phone$DataState;)V

    .line 107
    return-void
.end method

.method public notifyDataConnectionFailed(Lcom/android/internal/telephony/Phone;Ljava/lang/String;Ljava/lang/String;)V
    .registers 5
    .parameter "sender"
    .parameter "reason"
    .parameter "apnType"

    .prologue
    .line 144
    :try_start_0
    iget-object v0, p0, Lcom/android/internal/telephony/DefaultPhoneNotifier;->mRegistry:Lcom/android/internal/telephony/ITelephonyRegistry;

    invoke-interface {v0, p2, p3}, Lcom/android/internal/telephony/ITelephonyRegistry;->notifyDataConnectionFailed(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    .line 148
    :goto_5
    return-void

    .line 145
    :catch_6
    move-exception v0

    goto :goto_5
.end method

.method public notifyMessageWaitingChanged(Lcom/android/internal/telephony/Phone;)V
    .registers 4
    .parameter "sender"

    .prologue
    .line 82
    :try_start_0
    iget-object v0, p0, Lcom/android/internal/telephony/DefaultPhoneNotifier;->mRegistry:Lcom/android/internal/telephony/ITelephonyRegistry;

    invoke-interface {p1}, Lcom/android/internal/telephony/Phone;->getMessageWaitingIndicator()Z

    move-result v1

    invoke-interface {v0, v1}, Lcom/android/internal/telephony/ITelephonyRegistry;->notifyMessageWaitingChanged(Z)V
    :try_end_9
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_9} :catch_a

    .line 86
    :goto_9
    return-void

    .line 83
    :catch_a
    move-exception v0

    goto :goto_9
.end method

.method public notifyOtaspChanged(Lcom/android/internal/telephony/Phone;I)V
    .registers 4
    .parameter "sender"
    .parameter "otaspMode"

    .prologue
    .line 170
    :try_start_0
    iget-object v0, p0, Lcom/android/internal/telephony/DefaultPhoneNotifier;->mRegistry:Lcom/android/internal/telephony/ITelephonyRegistry;

    invoke-interface {v0, p2}, Lcom/android/internal/telephony/ITelephonyRegistry;->notifyOtaspChanged(I)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    .line 174
    :goto_5
    return-void

    .line 171
    :catch_6
    move-exception v0

    goto :goto_5
.end method

.method public notifyPhoneState(Lcom/android/internal/telephony/Phone;)V
    .registers 6
    .parameter "sender"

    .prologue
    .line 47
    invoke-interface {p1}, Lcom/android/internal/telephony/Phone;->getRingingCall()Lcom/android/internal/telephony/Call;

    move-result-object v1

    .line 48
    .local v1, ringingCall:Lcom/android/internal/telephony/Call;
    const-string v0, ""

    .line 49
    .local v0, incomingNumber:Ljava/lang/String;
    if-eqz v1, :cond_16

    invoke-virtual {v1}, Lcom/android/internal/telephony/Call;->getEarliestConnection()Lcom/android/internal/telephony/Connection;

    move-result-object v2

    if-eqz v2, :cond_16

    .line 50
    invoke-virtual {v1}, Lcom/android/internal/telephony/Call;->getEarliestConnection()Lcom/android/internal/telephony/Connection;

    move-result-object v2

    invoke-virtual {v2}, Lcom/android/internal/telephony/Connection;->getAddress()Ljava/lang/String;

    move-result-object v0

    .line 53
    :cond_16
    :try_start_16
    iget-object v2, p0, Lcom/android/internal/telephony/DefaultPhoneNotifier;->mRegistry:Lcom/android/internal/telephony/ITelephonyRegistry;

    invoke-interface {p1}, Lcom/android/internal/telephony/Phone;->getState()Lcom/android/internal/telephony/Phone$State;

    move-result-object v3

    invoke-static {v3}, Lcom/android/internal/telephony/DefaultPhoneNotifier;->convertCallState(Lcom/android/internal/telephony/Phone$State;)I

    move-result v3

    invoke-interface {v2, v3, v0}, Lcom/android/internal/telephony/ITelephonyRegistry;->notifyCallState(ILjava/lang/String;)V
    :try_end_23
    .catch Landroid/os/RemoteException; {:try_start_16 .. :try_end_23} :catch_24

    .line 57
    :goto_23
    return-void

    .line 54
    :catch_24
    move-exception v2

    goto :goto_23
.end method

.method public notifyServiceState(Lcom/android/internal/telephony/Phone;)V
    .registers 4
    .parameter "sender"

    .prologue
    .line 60
    invoke-interface {p1}, Lcom/android/internal/telephony/Phone;->getServiceState()Landroid/telephony/ServiceState;

    move-result-object v0

    .line 61
    .local v0, ss:Landroid/telephony/ServiceState;
    if-nez v0, :cond_e

    .line 62
    new-instance v0, Landroid/telephony/ServiceState;

    .end local v0           #ss:Landroid/telephony/ServiceState;
    invoke-direct {v0}, Landroid/telephony/ServiceState;-><init>()V

    .line 63
    .restart local v0       #ss:Landroid/telephony/ServiceState;
    invoke-virtual {v0}, Landroid/telephony/ServiceState;->setStateOutOfService()V

    .line 66
    :cond_e
    :try_start_e
    iget-object v1, p0, Lcom/android/internal/telephony/DefaultPhoneNotifier;->mRegistry:Lcom/android/internal/telephony/ITelephonyRegistry;

    invoke-interface {v1, v0}, Lcom/android/internal/telephony/ITelephonyRegistry;->notifyServiceState(Landroid/telephony/ServiceState;)V
    :try_end_13
    .catch Landroid/os/RemoteException; {:try_start_e .. :try_end_13} :catch_14

    .line 70
    :goto_13
    return-void

    .line 67
    :catch_14
    move-exception v1

    goto :goto_13
.end method

.method public notifySignalStrength(Lcom/android/internal/telephony/Phone;)V
    .registers 4
    .parameter "sender"

    .prologue
    .line 74
    :try_start_0
    iget-object v0, p0, Lcom/android/internal/telephony/DefaultPhoneNotifier;->mRegistry:Lcom/android/internal/telephony/ITelephonyRegistry;

    invoke-interface {p1}, Lcom/android/internal/telephony/Phone;->getSignalStrength()Landroid/telephony/SignalStrength;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/android/internal/telephony/ITelephonyRegistry;->notifySignalStrength(Landroid/telephony/SignalStrength;)V
    :try_end_9
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_9} :catch_a

    .line 78
    :goto_9
    return-void

    .line 75
    :catch_a
    move-exception v0

    goto :goto_9
.end method
