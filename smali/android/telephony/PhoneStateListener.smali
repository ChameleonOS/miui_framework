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
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Landroid/telephony/PhoneStateListener$1;

    invoke-direct {v0, p0}, Landroid/telephony/PhoneStateListener$1;-><init>(Landroid/telephony/PhoneStateListener;)V

    iput-object v0, p0, Landroid/telephony/PhoneStateListener;->callback:Lcom/android/internal/telephony/IPhoneStateListener;

    new-instance v0, Landroid/telephony/PhoneStateListener$2;

    invoke-direct {v0, p0}, Landroid/telephony/PhoneStateListener$2;-><init>(Landroid/telephony/PhoneStateListener;)V

    iput-object v0, p0, Landroid/telephony/PhoneStateListener;->mHandler:Landroid/os/Handler;

    return-void
.end method


# virtual methods
.method public onCallForwardingIndicatorChanged(Z)V
    .registers 2
    .parameter "cfi"

    .prologue
    return-void
.end method

.method public onCallStateChanged(ILjava/lang/String;)V
    .registers 3
    .parameter "state"
    .parameter "incomingNumber"

    .prologue
    return-void
.end method

.method public onCellInfoChanged(Landroid/telephony/CellInfo;)V
    .registers 2
    .parameter "cellInfo"

    .prologue
    return-void
.end method

.method public onCellLocationChanged(Landroid/telephony/CellLocation;)V
    .registers 2
    .parameter "location"

    .prologue
    return-void
.end method

.method public onDataActivity(I)V
    .registers 2
    .parameter "direction"

    .prologue
    return-void
.end method

.method public onDataConnectionStateChanged(I)V
    .registers 2
    .parameter "state"

    .prologue
    return-void
.end method

.method public onDataConnectionStateChanged(II)V
    .registers 3
    .parameter "state"
    .parameter "networkType"

    .prologue
    return-void
.end method

.method public onMessageWaitingIndicatorChanged(Z)V
    .registers 2
    .parameter "mwi"

    .prologue
    return-void
.end method

.method public onOtaspChanged(I)V
    .registers 2
    .parameter "otaspMode"

    .prologue
    return-void
.end method

.method public onServiceStateChanged(Landroid/telephony/ServiceState;)V
    .registers 2
    .parameter "serviceState"

    .prologue
    return-void
.end method

.method public onSignalStrengthChanged(I)V
    .registers 2
    .parameter "asu"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    return-void
.end method

.method public onSignalStrengthsChanged(Landroid/telephony/SignalStrength;)V
    .registers 2
    .parameter "signalStrength"

    .prologue
    return-void
.end method
