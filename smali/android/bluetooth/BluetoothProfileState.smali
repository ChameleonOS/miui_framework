.class public Landroid/bluetooth/BluetoothProfileState;
.super Lcom/android/internal/util/StateMachine;
.source "BluetoothProfileState.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/bluetooth/BluetoothProfileState$PendingCommandState;,
        Landroid/bluetooth/BluetoothProfileState$StableState;
    }
.end annotation


# static fields
.field public static final A2DP:I = 0x1

.field private static final DBG:Z = true

.field public static final HFP:I = 0x0

.field public static final HID:I = 0x2

.field private static final TAG:Ljava/lang/String; = "BluetoothProfileState"

.field static final TRANSITION_TO_STABLE:I = 0x64


# instance fields
.field private mBroadcastReceiver:Landroid/content/BroadcastReceiver;

.field private mPendingCommandState:Landroid/bluetooth/BluetoothProfileState$PendingCommandState;

.field private mPendingDevice:Landroid/bluetooth/BluetoothDevice;

.field private mProfile:I

.field private mStableState:Landroid/bluetooth/BluetoothProfileState$StableState;


# direct methods
.method public constructor <init>(Landroid/content/Context;I)V
    .registers 7
    .parameter "context"
    .parameter "profile"

    .prologue
    const/4 v3, 0x0

    .line 92
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "BluetoothProfileState:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/android/internal/util/StateMachine;-><init>(Ljava/lang/String;)V

    .line 54
    new-instance v1, Landroid/bluetooth/BluetoothProfileState$PendingCommandState;

    invoke-direct {v1, p0, v3}, Landroid/bluetooth/BluetoothProfileState$PendingCommandState;-><init>(Landroid/bluetooth/BluetoothProfileState;Landroid/bluetooth/BluetoothProfileState$1;)V

    iput-object v1, p0, Landroid/bluetooth/BluetoothProfileState;->mPendingCommandState:Landroid/bluetooth/BluetoothProfileState$PendingCommandState;

    .line 55
    new-instance v1, Landroid/bluetooth/BluetoothProfileState$StableState;

    invoke-direct {v1, p0, v3}, Landroid/bluetooth/BluetoothProfileState$StableState;-><init>(Landroid/bluetooth/BluetoothProfileState;Landroid/bluetooth/BluetoothProfileState$1;)V

    iput-object v1, p0, Landroid/bluetooth/BluetoothProfileState;->mStableState:Landroid/bluetooth/BluetoothProfileState$StableState;

    .line 57
    new-instance v1, Landroid/bluetooth/BluetoothProfileState$1;

    invoke-direct {v1, p0}, Landroid/bluetooth/BluetoothProfileState$1;-><init>(Landroid/bluetooth/BluetoothProfileState;)V

    iput-object v1, p0, Landroid/bluetooth/BluetoothProfileState;->mBroadcastReceiver:Landroid/content/BroadcastReceiver;

    .line 93
    iput p2, p0, Landroid/bluetooth/BluetoothProfileState;->mProfile:I

    .line 94
    iget-object v1, p0, Landroid/bluetooth/BluetoothProfileState;->mStableState:Landroid/bluetooth/BluetoothProfileState$StableState;

    invoke-virtual {p0, v1}, Landroid/bluetooth/BluetoothProfileState;->addState(Lcom/android/internal/util/State;)V

    .line 95
    iget-object v1, p0, Landroid/bluetooth/BluetoothProfileState;->mPendingCommandState:Landroid/bluetooth/BluetoothProfileState$PendingCommandState;

    invoke-virtual {p0, v1}, Landroid/bluetooth/BluetoothProfileState;->addState(Lcom/android/internal/util/State;)V

    .line 96
    iget-object v1, p0, Landroid/bluetooth/BluetoothProfileState;->mStableState:Landroid/bluetooth/BluetoothProfileState$StableState;

    invoke-virtual {p0, v1}, Landroid/bluetooth/BluetoothProfileState;->setInitialState(Lcom/android/internal/util/State;)V

    .line 98
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 99
    .local v0, filter:Landroid/content/IntentFilter;
    const-string v1, "android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 100
    const-string v1, "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 101
    const-string v1, "android.bluetooth.input.profile.action.CONNECTION_STATE_CHANGED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 102
    const-string v1, "android.bluetooth.device.action.ACL_DISCONNECTED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 103
    iget-object v1, p0, Landroid/bluetooth/BluetoothProfileState;->mBroadcastReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {p1, v1, v0}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 104
    return-void
.end method

.method static synthetic access$1000(Landroid/bluetooth/BluetoothProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 42
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$200(Landroid/bluetooth/BluetoothProfileState;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 42
    iget v0, p0, Landroid/bluetooth/BluetoothProfileState;->mProfile:I

    return v0
.end method

.method static synthetic access$300(Landroid/bluetooth/BluetoothProfileState;)Landroid/bluetooth/BluetoothDevice;
    .registers 2
    .parameter "x0"

    .prologue
    .line 42
    iget-object v0, p0, Landroid/bluetooth/BluetoothProfileState;->mPendingDevice:Landroid/bluetooth/BluetoothDevice;

    return-object v0
.end method

.method static synthetic access$302(Landroid/bluetooth/BluetoothProfileState;Landroid/bluetooth/BluetoothDevice;)Landroid/bluetooth/BluetoothDevice;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 42
    iput-object p1, p0, Landroid/bluetooth/BluetoothProfileState;->mPendingDevice:Landroid/bluetooth/BluetoothDevice;

    return-object p1
.end method

.method static synthetic access$400(Landroid/bluetooth/BluetoothProfileState;Ljava/lang/String;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 42
    invoke-direct {p0, p1}, Landroid/bluetooth/BluetoothProfileState;->log(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$500(Landroid/bluetooth/BluetoothProfileState;)Landroid/bluetooth/BluetoothProfileState$PendingCommandState;
    .registers 2
    .parameter "x0"

    .prologue
    .line 42
    iget-object v0, p0, Landroid/bluetooth/BluetoothProfileState;->mPendingCommandState:Landroid/bluetooth/BluetoothProfileState$PendingCommandState;

    return-object v0
.end method

.method static synthetic access$600(Landroid/bluetooth/BluetoothProfileState;Lcom/android/internal/util/IState;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 42
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothProfileState;->transitionTo(Lcom/android/internal/util/IState;)V

    return-void
.end method

.method static synthetic access$700(Landroid/bluetooth/BluetoothProfileState;)Landroid/os/Message;
    .registers 2
    .parameter "x0"

    .prologue
    .line 42
    invoke-virtual {p0}, Landroid/bluetooth/BluetoothProfileState;->getCurrentMessage()Landroid/os/Message;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$800(Landroid/bluetooth/BluetoothProfileState;)Landroid/bluetooth/BluetoothProfileState$StableState;
    .registers 2
    .parameter "x0"

    .prologue
    .line 42
    iget-object v0, p0, Landroid/bluetooth/BluetoothProfileState;->mStableState:Landroid/bluetooth/BluetoothProfileState$StableState;

    return-object v0
.end method

.method static synthetic access$900(Landroid/bluetooth/BluetoothProfileState;Lcom/android/internal/util/IState;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 42
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothProfileState;->transitionTo(Lcom/android/internal/util/IState;)V

    return-void
.end method

.method private log(Ljava/lang/String;)V
    .registers 5
    .parameter "message"

    .prologue
    .line 157
    const-string v0, "BluetoothProfileState"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Message:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 159
    return-void
.end method
