.class public Landroid/telephony/PhoneStateListener;
.super Ljava/lang/Object;
.source "PhoneStateListener.java"


# static fields
.field public static final LISTEN_CALL_FORWARDING_INDICATOR:I = 0x8

.field public static final LISTEN_CALL_STATE:I = 0x20

.field public static final LISTEN_CELL_INFO:I = 0x400

.field public static final LISTEN_CELL_LOCATION:I = 0x10

.field public static final LISTEN_DATA_ACTIVITY:I = 0x80

.field public static final LISTEN_DATA_CONNECTION_STATE:I = 0x40

.field public static final LISTEN_MESSAGE_WAITING_INDICATOR:I = 0x4

.field public static final LISTEN_NONE:I = 0x0

.field public static final LISTEN_OTASP_CHANGED:I = 0x200

.field public static final LISTEN_SERVICE_STATE:I = 0x1

.field public static final LISTEN_SIGNAL_STRENGTH:I = 0x2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final LISTEN_SIGNAL_STRENGTHS:I = 0x100


# instance fields
.field callback:Lcom/android/internal/telephony/IPhoneStateListener;

.field mHandler:Landroid/os/Handler;


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 168
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 305
    new-instance v0, Landroid/telephony/PhoneStateListener$1;

    invoke-direct {v0, p0}, Landroid/telephony/PhoneStateListener$1;-><init>(Landroid/telephony/PhoneStateListener;)V

    iput-object v0, p0, Landroid/telephony/PhoneStateListener;->callback:Lcom/android/internal/telephony/IPhoneStateListener;

    .line 355
    new-instance v0, Landroid/telephony/PhoneStateListener$2;

    invoke-direct {v0, p0}, Landroid/telephony/PhoneStateListener$2;-><init>(Landroid/telephony/PhoneStateListener;)V

    iput-object v0, p0, Landroid/telephony/PhoneStateListener;->mHandler:Landroid/os/Handler;

    .line 169
    return-void
.end method


# virtual methods
.method public onCallForwardingIndicatorChanged(Z)V
    .registers 2
    .parameter "cfi"

    .prologue
    .line 209
    return-void
.end method

.method public onCallStateChanged(ILjava/lang/String;)V
    .registers 3
    .parameter "state"
    .parameter "incomingNumber"

    .prologue
    .line 227
    return-void
.end method

.method public onCellInfoChanged(Landroid/telephony/CellInfo;)V
    .registers 2
    .parameter "cellInfo"

    .prologue
    .line 299
    return-void
.end method

.method public onCellLocationChanged(Landroid/telephony/CellLocation;)V
    .registers 2
    .parameter "location"

    .prologue
    .line 216
    return-void
.end method

.method public onDataActivity(I)V
    .registers 2
    .parameter "direction"

    .prologue
    .line 258
    return-void
.end method

.method public onDataConnectionStateChanged(I)V
    .registers 2
    .parameter "state"

    .prologue
    .line 239
    return-void
.end method

.method public onDataConnectionStateChanged(II)V
    .registers 3
    .parameter "state"
    .parameter "networkType"

    .prologue
    .line 245
    return-void
.end method

.method public onMessageWaitingIndicatorChanged(Z)V
    .registers 2
    .parameter "mwi"

    .prologue
    .line 202
    return-void
.end method

.method public onOtaspChanged(I)V
    .registers 2
    .parameter "otaspMode"

    .prologue
    .line 285
    return-void
.end method

.method public onServiceStateChanged(Landroid/telephony/ServiceState;)V
    .registers 2
    .parameter "serviceState"

    .prologue
    .line 181
    return-void
.end method

.method public onSignalStrengthChanged(I)V
    .registers 2
    .parameter "asu"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 195
    return-void
.end method

.method public onSignalStrengthsChanged(Landroid/telephony/SignalStrength;)V
    .registers 2
    .parameter "signalStrength"

    .prologue
    .line 270
    return-void
.end method
