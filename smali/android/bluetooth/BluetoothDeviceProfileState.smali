.class public final Landroid/bluetooth/BluetoothDeviceProfileState;
.super Lcom/android/internal/util/StateMachine;
.source "BluetoothDeviceProfileState.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/bluetooth/BluetoothDeviceProfileState$IncomingHid;,
        Landroid/bluetooth/BluetoothDeviceProfileState$OutgoingHid;,
        Landroid/bluetooth/BluetoothDeviceProfileState$IncomingA2dp;,
        Landroid/bluetooth/BluetoothDeviceProfileState$OutgoingA2dp;,
        Landroid/bluetooth/BluetoothDeviceProfileState$IncomingHandsfree;,
        Landroid/bluetooth/BluetoothDeviceProfileState$OutgoingHandsfree;,
        Landroid/bluetooth/BluetoothDeviceProfileState$BondedDevice;,
        Landroid/bluetooth/BluetoothDeviceProfileState$PbapServiceListener;
    }
.end annotation


# static fields
.field private static final ACCESS_AUTHORITY_CLASS:Ljava/lang/String; = "com.android.settings.bluetooth.BluetoothPermissionRequest"

.field private static final ACCESS_AUTHORITY_PACKAGE:Ljava/lang/String; = "com.android.settings"

.field public static final AUTO_CONNECT_PROFILES:I = 0x65

.field private static final BLUETOOTH_ADMIN_PERM:Ljava/lang/String; = "android.permission.BLUETOOTH_ADMIN"

.field private static final CONNECTION_ACCESS_REQUEST_EXPIRY:I = 0x69

.field private static final CONNECTION_ACCESS_REQUEST_EXPIRY_TIMEOUT:I = 0x1b58

.field private static final CONNECTION_ACCESS_REQUEST_REPLY:I = 0x68

.field private static final CONNECTION_ACCESS_UNDEFINED:I = -0x1

.field public static final CONNECT_A2DP_INCOMING:I = 0x4

.field public static final CONNECT_A2DP_OUTGOING:I = 0x3

.field public static final CONNECT_HFP_INCOMING:I = 0x2

.field public static final CONNECT_HFP_OUTGOING:I = 0x1

.field public static final CONNECT_HID_INCOMING:I = 0x6

.field public static final CONNECT_HID_OUTGOING:I = 0x5

.field public static final CONNECT_OTHER_PROFILES:I = 0x67

.field public static final CONNECT_OTHER_PROFILES_DELAY:I = 0xfa0

.field private static final DBG:Z = false

.field public static final DISCONNECT_A2DP_INCOMING:I = 0x35

.field public static final DISCONNECT_A2DP_OUTGOING:I = 0x34

.field private static final DISCONNECT_HFP_INCOMING:I = 0x33

.field public static final DISCONNECT_HFP_OUTGOING:I = 0x32

.field public static final DISCONNECT_HID_INCOMING:I = 0x37

.field public static final DISCONNECT_HID_OUTGOING:I = 0x36

.field public static final DISCONNECT_PBAP_OUTGOING:I = 0x38

.field private static final INIT_INCOMING_REJECT_TIMER:J = 0x3e8L

.field private static final MAX_INCOMING_REJECT_TIMER:J = 0xdbba00L

.field private static final TAG:Ljava/lang/String; = "BluetoothDeviceProfileState"

.field public static final TRANSITION_TO_STABLE:I = 0x66

.field public static final UNPAIR:I = 0x64


# instance fields
.field private mA2dpService:Landroid/server/BluetoothA2dpService;

.field private mA2dpState:I

.field private mAdapter:Landroid/bluetooth/BluetoothAdapter;

.field private mAutoConnectionPending:Z

.field private mBluetoothProfileServiceListener:Landroid/bluetooth/BluetoothProfile$ServiceListener;

.field private mBondedDevice:Landroid/bluetooth/BluetoothDeviceProfileState$BondedDevice;

.field private mBroadcastReceiver:Landroid/content/BroadcastReceiver;

.field private mConnectionAccessReplyReceived:Z

.field private mContext:Landroid/content/Context;

.field private mDevice:Landroid/bluetooth/BluetoothDevice;

.field private mHeadsetService:Landroid/bluetooth/BluetoothHeadset;

.field private mHeadsetState:I

.field private mIncomingA2dp:Landroid/bluetooth/BluetoothDeviceProfileState$IncomingA2dp;

.field private mIncomingConnections:Landroid/util/Pair;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mIncomingHandsfree:Landroid/bluetooth/BluetoothDeviceProfileState$IncomingHandsfree;

.field private mIncomingHid:Landroid/bluetooth/BluetoothDeviceProfileState$IncomingHid;

.field private mIncomingRejectTimer:J

.field private mOutgoingA2dp:Landroid/bluetooth/BluetoothDeviceProfileState$OutgoingA2dp;

.field private mOutgoingHandsfree:Landroid/bluetooth/BluetoothDeviceProfileState$OutgoingHandsfree;

.field private mOutgoingHid:Landroid/bluetooth/BluetoothDeviceProfileState$OutgoingHid;

.field private mPairingRequestRcvd:Z

.field private mPbap:Landroid/bluetooth/BluetoothDeviceProfileState$PbapServiceListener;

.field private mPbapService:Landroid/bluetooth/BluetoothPbap;

.field private mPbapServiceConnected:Z

.field private mPowerManager:Landroid/os/PowerManager;

.field private mService:Landroid/server/BluetoothService;

.field private mWakeLock:Landroid/os/PowerManager$WakeLock;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;Landroid/server/BluetoothService;Landroid/server/BluetoothA2dpService;Z)V
    .registers 12
    .parameter "context"
    .parameter "address"
    .parameter "service"
    .parameter "a2dpService"
    .parameter "setTrust"

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    const/4 v2, 0x0

    .line 226
    invoke-direct {p0, p2}, Lcom/android/internal/util/StateMachine;-><init>(Ljava/lang/String;)V

    .line 99
    new-instance v1, Landroid/bluetooth/BluetoothDeviceProfileState$BondedDevice;

    invoke-direct {v1, p0, v2}, Landroid/bluetooth/BluetoothDeviceProfileState$BondedDevice;-><init>(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/bluetooth/BluetoothDeviceProfileState$1;)V

    iput-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mBondedDevice:Landroid/bluetooth/BluetoothDeviceProfileState$BondedDevice;

    .line 100
    new-instance v1, Landroid/bluetooth/BluetoothDeviceProfileState$OutgoingHandsfree;

    invoke-direct {v1, p0, v2}, Landroid/bluetooth/BluetoothDeviceProfileState$OutgoingHandsfree;-><init>(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/bluetooth/BluetoothDeviceProfileState$1;)V

    iput-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mOutgoingHandsfree:Landroid/bluetooth/BluetoothDeviceProfileState$OutgoingHandsfree;

    .line 101
    new-instance v1, Landroid/bluetooth/BluetoothDeviceProfileState$IncomingHandsfree;

    invoke-direct {v1, p0, v2}, Landroid/bluetooth/BluetoothDeviceProfileState$IncomingHandsfree;-><init>(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/bluetooth/BluetoothDeviceProfileState$1;)V

    iput-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingHandsfree:Landroid/bluetooth/BluetoothDeviceProfileState$IncomingHandsfree;

    .line 102
    new-instance v1, Landroid/bluetooth/BluetoothDeviceProfileState$IncomingA2dp;

    invoke-direct {v1, p0, v2}, Landroid/bluetooth/BluetoothDeviceProfileState$IncomingA2dp;-><init>(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/bluetooth/BluetoothDeviceProfileState$1;)V

    iput-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingA2dp:Landroid/bluetooth/BluetoothDeviceProfileState$IncomingA2dp;

    .line 103
    new-instance v1, Landroid/bluetooth/BluetoothDeviceProfileState$OutgoingA2dp;

    invoke-direct {v1, p0, v2}, Landroid/bluetooth/BluetoothDeviceProfileState$OutgoingA2dp;-><init>(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/bluetooth/BluetoothDeviceProfileState$1;)V

    iput-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mOutgoingA2dp:Landroid/bluetooth/BluetoothDeviceProfileState$OutgoingA2dp;

    .line 104
    new-instance v1, Landroid/bluetooth/BluetoothDeviceProfileState$OutgoingHid;

    invoke-direct {v1, p0, v2}, Landroid/bluetooth/BluetoothDeviceProfileState$OutgoingHid;-><init>(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/bluetooth/BluetoothDeviceProfileState$1;)V

    iput-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mOutgoingHid:Landroid/bluetooth/BluetoothDeviceProfileState$OutgoingHid;

    .line 105
    new-instance v1, Landroid/bluetooth/BluetoothDeviceProfileState$IncomingHid;

    invoke-direct {v1, p0, v2}, Landroid/bluetooth/BluetoothDeviceProfileState$IncomingHid;-><init>(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/bluetooth/BluetoothDeviceProfileState$1;)V

    iput-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingHid:Landroid/bluetooth/BluetoothDeviceProfileState$IncomingHid;

    .line 119
    iput v4, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mHeadsetState:I

    .line 120
    iput v4, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mA2dpState:I

    .line 122
    iput-boolean v4, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mConnectionAccessReplyReceived:Z

    .line 126
    iput-boolean v4, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mPairingRequestRcvd:Z

    .line 128
    new-instance v1, Landroid/bluetooth/BluetoothDeviceProfileState$1;

    invoke-direct {v1, p0}, Landroid/bluetooth/BluetoothDeviceProfileState$1;-><init>(Landroid/bluetooth/BluetoothDeviceProfileState;)V

    iput-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mBroadcastReceiver:Landroid/content/BroadcastReceiver;

    .line 273
    new-instance v1, Landroid/bluetooth/BluetoothDeviceProfileState$2;

    invoke-direct {v1, p0}, Landroid/bluetooth/BluetoothDeviceProfileState$2;-><init>(Landroid/bluetooth/BluetoothDeviceProfileState;)V

    iput-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mBluetoothProfileServiceListener:Landroid/bluetooth/BluetoothProfile$ServiceListener;

    .line 227
    iput-object p1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mContext:Landroid/content/Context;

    .line 228
    new-instance v1, Landroid/bluetooth/BluetoothDevice;

    invoke-direct {v1, p2}, Landroid/bluetooth/BluetoothDevice;-><init>(Ljava/lang/String;)V

    iput-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mDevice:Landroid/bluetooth/BluetoothDevice;

    .line 229
    iput-object p3, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mService:Landroid/server/BluetoothService;

    .line 230
    iput-object p4, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mA2dpService:Landroid/server/BluetoothA2dpService;

    .line 232
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mBondedDevice:Landroid/bluetooth/BluetoothDeviceProfileState$BondedDevice;

    invoke-virtual {p0, v1}, Landroid/bluetooth/BluetoothDeviceProfileState;->addState(Lcom/android/internal/util/State;)V

    .line 233
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mOutgoingHandsfree:Landroid/bluetooth/BluetoothDeviceProfileState$OutgoingHandsfree;

    invoke-virtual {p0, v1}, Landroid/bluetooth/BluetoothDeviceProfileState;->addState(Lcom/android/internal/util/State;)V

    .line 234
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingHandsfree:Landroid/bluetooth/BluetoothDeviceProfileState$IncomingHandsfree;

    invoke-virtual {p0, v1}, Landroid/bluetooth/BluetoothDeviceProfileState;->addState(Lcom/android/internal/util/State;)V

    .line 235
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingA2dp:Landroid/bluetooth/BluetoothDeviceProfileState$IncomingA2dp;

    invoke-virtual {p0, v1}, Landroid/bluetooth/BluetoothDeviceProfileState;->addState(Lcom/android/internal/util/State;)V

    .line 236
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mOutgoingA2dp:Landroid/bluetooth/BluetoothDeviceProfileState$OutgoingA2dp;

    invoke-virtual {p0, v1}, Landroid/bluetooth/BluetoothDeviceProfileState;->addState(Lcom/android/internal/util/State;)V

    .line 237
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mOutgoingHid:Landroid/bluetooth/BluetoothDeviceProfileState$OutgoingHid;

    invoke-virtual {p0, v1}, Landroid/bluetooth/BluetoothDeviceProfileState;->addState(Lcom/android/internal/util/State;)V

    .line 238
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingHid:Landroid/bluetooth/BluetoothDeviceProfileState$IncomingHid;

    invoke-virtual {p0, v1}, Landroid/bluetooth/BluetoothDeviceProfileState;->addState(Lcom/android/internal/util/State;)V

    .line 239
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mBondedDevice:Landroid/bluetooth/BluetoothDeviceProfileState$BondedDevice;

    invoke-virtual {p0, v1}, Landroid/bluetooth/BluetoothDeviceProfileState;->setInitialState(Lcom/android/internal/util/State;)V

    .line 241
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 243
    .local v0, filter:Landroid/content/IntentFilter;
    const-string v1, "android.bluetooth.device.action.ACL_CONNECTED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 244
    const-string v1, "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 245
    const-string v1, "android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 246
    const-string v1, "android.bluetooth.input.profile.action.CONNECTION_STATE_CHANGED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 247
    const-string v1, "android.bluetooth.device.action.ACL_DISCONNECTED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 248
    const-string v1, "android.bluetooth.device.action.CONNECTION_ACCESS_REPLY"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 249
    const-string v1, "android.bluetooth.device.action.PAIRING_REQUEST"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 250
    const-string v1, "android.bluetooth.device.action.BOND_STATE_CHANGED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 252
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mContext:Landroid/content/Context;

    iget-object v2, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mBroadcastReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {v1, v2, v0}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 254
    invoke-static {}, Landroid/bluetooth/BluetoothAdapter;->getDefaultAdapter()Landroid/bluetooth/BluetoothAdapter;

    move-result-object v1

    iput-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mAdapter:Landroid/bluetooth/BluetoothAdapter;

    .line 255
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mAdapter:Landroid/bluetooth/BluetoothAdapter;

    iget-object v2, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mContext:Landroid/content/Context;

    iget-object v3, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mBluetoothProfileServiceListener:Landroid/bluetooth/BluetoothProfile$ServiceListener;

    invoke-virtual {v1, v2, v3, v5}, Landroid/bluetooth/BluetoothAdapter;->getProfileProxy(Landroid/content/Context;Landroid/bluetooth/BluetoothProfile$ServiceListener;I)Z

    .line 258
    new-instance v1, Landroid/bluetooth/BluetoothDeviceProfileState$PbapServiceListener;

    invoke-direct {v1, p0}, Landroid/bluetooth/BluetoothDeviceProfileState$PbapServiceListener;-><init>(Landroid/bluetooth/BluetoothDeviceProfileState;)V

    iput-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mPbap:Landroid/bluetooth/BluetoothDeviceProfileState$PbapServiceListener;

    .line 260
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mService:Landroid/server/BluetoothService;

    invoke-virtual {v1, p2}, Landroid/server/BluetoothService;->getIncomingState(Ljava/lang/String;)Landroid/util/Pair;

    move-result-object v1

    iput-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingConnections:Landroid/util/Pair;

    .line 261
    invoke-direct {p0}, Landroid/bluetooth/BluetoothDeviceProfileState;->readTimerValue()J

    move-result-wide v1

    iput-wide v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingRejectTimer:J

    .line 262
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "power"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/os/PowerManager;

    iput-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mPowerManager:Landroid/os/PowerManager;

    .line 263
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mPowerManager:Landroid/os/PowerManager;

    const v2, 0x30000006

    const-string v3, "BluetoothDeviceProfileState"

    invoke-virtual {v1, v2, v3}, Landroid/os/PowerManager;->newWakeLock(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;

    move-result-object v1

    iput-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mWakeLock:Landroid/os/PowerManager$WakeLock;

    .line 266
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mWakeLock:Landroid/os/PowerManager$WakeLock;

    invoke-virtual {v1, v4}, Landroid/os/PowerManager$WakeLock;->setReferenceCounted(Z)V

    .line 268
    if-eqz p5, :cond_fe

    .line 269
    invoke-direct {p0, v5}, Landroid/bluetooth/BluetoothDeviceProfileState;->setTrust(I)V

    .line 271
    :cond_fe
    return-void
.end method

.method static synthetic access$1000(Landroid/bluetooth/BluetoothDeviceProfileState;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    iget v0, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mHeadsetState:I

    return v0
.end method

.method static synthetic access$10000(Landroid/bluetooth/BluetoothDeviceProfileState;)Landroid/os/Message;
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    invoke-virtual {p0}, Landroid/bluetooth/BluetoothDeviceProfileState;->getCurrentMessage()Landroid/os/Message;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$1002(Landroid/bluetooth/BluetoothDeviceProfileState;I)I
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    iput p1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mHeadsetState:I

    return p1
.end method

.method static synthetic access$10100(Landroid/bluetooth/BluetoothDeviceProfileState;)Landroid/os/Message;
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    invoke-virtual {p0}, Landroid/bluetooth/BluetoothDeviceProfileState;->getCurrentMessage()Landroid/os/Message;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$10200(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$10300(Landroid/bluetooth/BluetoothDeviceProfileState;Lcom/android/internal/util/IState;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->transitionTo(Lcom/android/internal/util/IState;)V

    return-void
.end method

.method static synthetic access$10400(Landroid/bluetooth/BluetoothDeviceProfileState;Lcom/android/internal/util/IState;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->transitionTo(Lcom/android/internal/util/IState;)V

    return-void
.end method

.method static synthetic access$10500(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$10600(Landroid/bluetooth/BluetoothDeviceProfileState;Lcom/android/internal/util/IState;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->transitionTo(Lcom/android/internal/util/IState;)V

    return-void
.end method

.method static synthetic access$10700(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$10800(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$10900(Landroid/bluetooth/BluetoothDeviceProfileState;Lcom/android/internal/util/IState;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->transitionTo(Lcom/android/internal/util/IState;)V

    return-void
.end method

.method static synthetic access$1100(Landroid/bluetooth/BluetoothDeviceProfileState;)Landroid/os/PowerManager$WakeLock;
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    iget-object v0, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mWakeLock:Landroid/os/PowerManager$WakeLock;

    return-object v0
.end method

.method static synthetic access$11000(Landroid/bluetooth/BluetoothDeviceProfileState;)Landroid/os/Message;
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    invoke-virtual {p0}, Landroid/bluetooth/BluetoothDeviceProfileState;->getCurrentMessage()Landroid/os/Message;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$11100(Landroid/bluetooth/BluetoothDeviceProfileState;)Landroid/os/Message;
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    invoke-virtual {p0}, Landroid/bluetooth/BluetoothDeviceProfileState;->getCurrentMessage()Landroid/os/Message;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$11200(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$11300(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$11400(Landroid/bluetooth/BluetoothDeviceProfileState;Lcom/android/internal/util/IState;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->transitionTo(Lcom/android/internal/util/IState;)V

    return-void
.end method

.method static synthetic access$1200(Landroid/bluetooth/BluetoothDeviceProfileState;)Z
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    iget-boolean v0, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mPairingRequestRcvd:Z

    return v0
.end method

.method static synthetic access$1202(Landroid/bluetooth/BluetoothDeviceProfileState;Z)Z
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    iput-boolean p1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mPairingRequestRcvd:Z

    return p1
.end method

.method static synthetic access$1300(Landroid/bluetooth/BluetoothDeviceProfileState;)Landroid/bluetooth/BluetoothHeadset;
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    iget-object v0, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mHeadsetService:Landroid/bluetooth/BluetoothHeadset;

    return-object v0
.end method

.method static synthetic access$1302(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/bluetooth/BluetoothHeadset;)Landroid/bluetooth/BluetoothHeadset;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    iput-object p1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mHeadsetService:Landroid/bluetooth/BluetoothHeadset;

    return-object p1
.end method

.method static synthetic access$1400(Landroid/bluetooth/BluetoothDeviceProfileState;)Z
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    iget-boolean v0, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mAutoConnectionPending:Z

    return v0
.end method

.method static synthetic access$1402(Landroid/bluetooth/BluetoothDeviceProfileState;Z)Z
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    iput-boolean p1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mAutoConnectionPending:Z

    return p1
.end method

.method static synthetic access$1500(Landroid/bluetooth/BluetoothDeviceProfileState;)Landroid/bluetooth/BluetoothPbap;
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    iget-object v0, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mPbapService:Landroid/bluetooth/BluetoothPbap;

    return-object v0
.end method

.method static synthetic access$1502(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/bluetooth/BluetoothPbap;)Landroid/bluetooth/BluetoothPbap;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    iput-object p1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mPbapService:Landroid/bluetooth/BluetoothPbap;

    return-object p1
.end method

.method static synthetic access$1600(Landroid/bluetooth/BluetoothDeviceProfileState;)Landroid/content/Context;
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    iget-object v0, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$1702(Landroid/bluetooth/BluetoothDeviceProfileState;Z)Z
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    iput-boolean p1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mPbapServiceConnected:Z

    return p1
.end method

.method static synthetic access$1800(Landroid/bluetooth/BluetoothDeviceProfileState;)Landroid/os/Message;
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    invoke-virtual {p0}, Landroid/bluetooth/BluetoothDeviceProfileState;->getCurrentMessage()Landroid/os/Message;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$1900(Landroid/bluetooth/BluetoothDeviceProfileState;)Landroid/os/Message;
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    invoke-virtual {p0}, Landroid/bluetooth/BluetoothDeviceProfileState;->getCurrentMessage()Landroid/os/Message;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$2000(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->sendMessageAtFrontOfQueue(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$2100(Landroid/bluetooth/BluetoothDeviceProfileState;Ljava/lang/String;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-direct {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->log(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$2200(Landroid/bluetooth/BluetoothDeviceProfileState;)Landroid/bluetooth/BluetoothDeviceProfileState$OutgoingHandsfree;
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    iget-object v0, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mOutgoingHandsfree:Landroid/bluetooth/BluetoothDeviceProfileState$OutgoingHandsfree;

    return-object v0
.end method

.method static synthetic access$2202(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/bluetooth/BluetoothDeviceProfileState$OutgoingHandsfree;)Landroid/bluetooth/BluetoothDeviceProfileState$OutgoingHandsfree;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    iput-object p1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mOutgoingHandsfree:Landroid/bluetooth/BluetoothDeviceProfileState$OutgoingHandsfree;

    return-object p1
.end method

.method static synthetic access$2300(Landroid/bluetooth/BluetoothDeviceProfileState;Lcom/android/internal/util/IState;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->transitionTo(Lcom/android/internal/util/IState;)V

    return-void
.end method

.method static synthetic access$2400(Landroid/bluetooth/BluetoothDeviceProfileState;)Landroid/bluetooth/BluetoothDeviceProfileState$IncomingHandsfree;
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    iget-object v0, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingHandsfree:Landroid/bluetooth/BluetoothDeviceProfileState$IncomingHandsfree;

    return-object v0
.end method

.method static synthetic access$2402(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/bluetooth/BluetoothDeviceProfileState$IncomingHandsfree;)Landroid/bluetooth/BluetoothDeviceProfileState$IncomingHandsfree;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    iput-object p1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingHandsfree:Landroid/bluetooth/BluetoothDeviceProfileState$IncomingHandsfree;

    return-object p1
.end method

.method static synthetic access$2500(Landroid/bluetooth/BluetoothDeviceProfileState;Lcom/android/internal/util/IState;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->transitionTo(Lcom/android/internal/util/IState;)V

    return-void
.end method

.method static synthetic access$2600(Landroid/bluetooth/BluetoothDeviceProfileState;Lcom/android/internal/util/IState;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->transitionTo(Lcom/android/internal/util/IState;)V

    return-void
.end method

.method static synthetic access$2700(Landroid/bluetooth/BluetoothDeviceProfileState;)Landroid/bluetooth/BluetoothDeviceProfileState$OutgoingA2dp;
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    iget-object v0, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mOutgoingA2dp:Landroid/bluetooth/BluetoothDeviceProfileState$OutgoingA2dp;

    return-object v0
.end method

.method static synthetic access$2702(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/bluetooth/BluetoothDeviceProfileState$OutgoingA2dp;)Landroid/bluetooth/BluetoothDeviceProfileState$OutgoingA2dp;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    iput-object p1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mOutgoingA2dp:Landroid/bluetooth/BluetoothDeviceProfileState$OutgoingA2dp;

    return-object p1
.end method

.method static synthetic access$2800(Landroid/bluetooth/BluetoothDeviceProfileState;Lcom/android/internal/util/IState;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->transitionTo(Lcom/android/internal/util/IState;)V

    return-void
.end method

.method static synthetic access$2900(Landroid/bluetooth/BluetoothDeviceProfileState;)Landroid/bluetooth/BluetoothDeviceProfileState$IncomingA2dp;
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    iget-object v0, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingA2dp:Landroid/bluetooth/BluetoothDeviceProfileState$IncomingA2dp;

    return-object v0
.end method

.method static synthetic access$2902(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/bluetooth/BluetoothDeviceProfileState$IncomingA2dp;)Landroid/bluetooth/BluetoothDeviceProfileState$IncomingA2dp;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    iput-object p1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingA2dp:Landroid/bluetooth/BluetoothDeviceProfileState$IncomingA2dp;

    return-object p1
.end method

.method static synthetic access$3000(Landroid/bluetooth/BluetoothDeviceProfileState;Lcom/android/internal/util/IState;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->transitionTo(Lcom/android/internal/util/IState;)V

    return-void
.end method

.method static synthetic access$3100(Landroid/bluetooth/BluetoothDeviceProfileState;)Landroid/bluetooth/BluetoothDeviceProfileState$OutgoingHid;
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    iget-object v0, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mOutgoingHid:Landroid/bluetooth/BluetoothDeviceProfileState$OutgoingHid;

    return-object v0
.end method

.method static synthetic access$3102(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/bluetooth/BluetoothDeviceProfileState$OutgoingHid;)Landroid/bluetooth/BluetoothDeviceProfileState$OutgoingHid;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    iput-object p1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mOutgoingHid:Landroid/bluetooth/BluetoothDeviceProfileState$OutgoingHid;

    return-object p1
.end method

.method static synthetic access$3200(Landroid/bluetooth/BluetoothDeviceProfileState;Lcom/android/internal/util/IState;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->transitionTo(Lcom/android/internal/util/IState;)V

    return-void
.end method

.method static synthetic access$3300(Landroid/bluetooth/BluetoothDeviceProfileState;)Landroid/bluetooth/BluetoothDeviceProfileState$IncomingHid;
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    iget-object v0, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingHid:Landroid/bluetooth/BluetoothDeviceProfileState$IncomingHid;

    return-object v0
.end method

.method static synthetic access$3302(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/bluetooth/BluetoothDeviceProfileState$IncomingHid;)Landroid/bluetooth/BluetoothDeviceProfileState$IncomingHid;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    iput-object p1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingHid:Landroid/bluetooth/BluetoothDeviceProfileState$IncomingHid;

    return-object p1
.end method

.method static synthetic access$3400(Landroid/bluetooth/BluetoothDeviceProfileState;Lcom/android/internal/util/IState;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->transitionTo(Lcom/android/internal/util/IState;)V

    return-void
.end method

.method static synthetic access$3500(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$3600(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$3700(Landroid/bluetooth/BluetoothDeviceProfileState;)Landroid/server/BluetoothService;
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    iget-object v0, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mService:Landroid/server/BluetoothService;

    return-object v0
.end method

.method static synthetic access$3800(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$3900(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/bluetooth/BluetoothDevice;)Z
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-direct {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->isPhoneDocked(Landroid/bluetooth/BluetoothDevice;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$4000(Landroid/bluetooth/BluetoothDeviceProfileState;)Landroid/server/BluetoothA2dpService;
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    iget-object v0, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mA2dpService:Landroid/server/BluetoothA2dpService;

    return-object v0
.end method

.method static synthetic access$4100(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$4200(Landroid/bluetooth/BluetoothDeviceProfileState;)Landroid/content/BroadcastReceiver;
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    iget-object v0, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mBroadcastReceiver:Landroid/content/BroadcastReceiver;

    return-object v0
.end method

.method static synthetic access$4202(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/content/BroadcastReceiver;)Landroid/content/BroadcastReceiver;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    iput-object p1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mBroadcastReceiver:Landroid/content/BroadcastReceiver;

    return-object p1
.end method

.method static synthetic access$4300(Landroid/bluetooth/BluetoothDeviceProfileState;)Landroid/bluetooth/BluetoothAdapter;
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    iget-object v0, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mAdapter:Landroid/bluetooth/BluetoothAdapter;

    return-object v0
.end method

.method static synthetic access$4402(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/bluetooth/BluetoothProfile$ServiceListener;)Landroid/bluetooth/BluetoothProfile$ServiceListener;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    iput-object p1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mBluetoothProfileServiceListener:Landroid/bluetooth/BluetoothProfile$ServiceListener;

    return-object p1
.end method

.method static synthetic access$4502(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/bluetooth/BluetoothDeviceProfileState$PbapServiceListener;)Landroid/bluetooth/BluetoothDeviceProfileState$PbapServiceListener;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    iput-object p1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mPbap:Landroid/bluetooth/BluetoothDeviceProfileState$PbapServiceListener;

    return-object p1
.end method

.method static synthetic access$4600(Landroid/bluetooth/BluetoothDeviceProfileState;)Landroid/bluetooth/BluetoothDeviceProfileState$BondedDevice;
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    iget-object v0, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mBondedDevice:Landroid/bluetooth/BluetoothDeviceProfileState$BondedDevice;

    return-object v0
.end method

.method static synthetic access$4602(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/bluetooth/BluetoothDeviceProfileState$BondedDevice;)Landroid/bluetooth/BluetoothDeviceProfileState$BondedDevice;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    iput-object p1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mBondedDevice:Landroid/bluetooth/BluetoothDeviceProfileState$BondedDevice;

    return-object p1
.end method

.method static synthetic access$4700(Landroid/bluetooth/BluetoothDeviceProfileState;)Landroid/os/Message;
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    invoke-virtual {p0}, Landroid/bluetooth/BluetoothDeviceProfileState;->getCurrentMessage()Landroid/os/Message;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$4800(Landroid/bluetooth/BluetoothDeviceProfileState;)Landroid/os/Message;
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    invoke-virtual {p0}, Landroid/bluetooth/BluetoothDeviceProfileState;->getCurrentMessage()Landroid/os/Message;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$4900(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$5000(Landroid/bluetooth/BluetoothDeviceProfileState;Lcom/android/internal/util/IState;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->transitionTo(Lcom/android/internal/util/IState;)V

    return-void
.end method

.method static synthetic access$5100(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$5200(Landroid/bluetooth/BluetoothDeviceProfileState;Lcom/android/internal/util/IState;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->transitionTo(Lcom/android/internal/util/IState;)V

    return-void
.end method

.method static synthetic access$5300(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$5400(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$5500(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$5600(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$5700(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$5800(Landroid/bluetooth/BluetoothDeviceProfileState;Lcom/android/internal/util/IState;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->transitionTo(Lcom/android/internal/util/IState;)V

    return-void
.end method

.method static synthetic access$5900(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$6000(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$6100(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$6200(Landroid/bluetooth/BluetoothDeviceProfileState;Lcom/android/internal/util/IState;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->transitionTo(Lcom/android/internal/util/IState;)V

    return-void
.end method

.method static synthetic access$6300(Landroid/bluetooth/BluetoothDeviceProfileState;)Landroid/os/Message;
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    invoke-virtual {p0}, Landroid/bluetooth/BluetoothDeviceProfileState;->getCurrentMessage()Landroid/os/Message;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$6400(Landroid/bluetooth/BluetoothDeviceProfileState;)Landroid/os/Message;
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    invoke-virtual {p0}, Landroid/bluetooth/BluetoothDeviceProfileState;->getCurrentMessage()Landroid/os/Message;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$6500(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$6600(Landroid/bluetooth/BluetoothDeviceProfileState;)Z
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    iget-boolean v0, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mConnectionAccessReplyReceived:Z

    return v0
.end method

.method static synthetic access$6602(Landroid/bluetooth/BluetoothDeviceProfileState;Z)Z
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    iput-boolean p1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mConnectionAccessReplyReceived:Z

    return p1
.end method

.method static synthetic access$6700(Landroid/bluetooth/BluetoothDeviceProfileState;IZ)Z
    .registers 4
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"

    .prologue
    .line 62
    invoke-direct {p0, p1, p2}, Landroid/bluetooth/BluetoothDeviceProfileState;->handleIncomingConnection(IZ)Z

    move-result v0

    return v0
.end method

.method static synthetic access$6800(Landroid/bluetooth/BluetoothDeviceProfileState;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 62
    invoke-direct {p0}, Landroid/bluetooth/BluetoothDeviceProfileState;->sendConnectionAccessRemovalIntent()V

    return-void
.end method

.method static synthetic access$6900(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$700(Landroid/bluetooth/BluetoothDeviceProfileState;)Landroid/bluetooth/BluetoothDevice;
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    iget-object v0, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mDevice:Landroid/bluetooth/BluetoothDevice;

    return-object v0
.end method

.method static synthetic access$7000(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$7100(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$7200(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$7300(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$7400(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$7500(Landroid/bluetooth/BluetoothDeviceProfileState;Lcom/android/internal/util/IState;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->transitionTo(Lcom/android/internal/util/IState;)V

    return-void
.end method

.method static synthetic access$7600(Landroid/bluetooth/BluetoothDeviceProfileState;)Landroid/os/Message;
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    invoke-virtual {p0}, Landroid/bluetooth/BluetoothDeviceProfileState;->getCurrentMessage()Landroid/os/Message;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$7700(Landroid/bluetooth/BluetoothDeviceProfileState;)Landroid/os/Message;
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    invoke-virtual {p0}, Landroid/bluetooth/BluetoothDeviceProfileState;->getCurrentMessage()Landroid/os/Message;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$7800(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$7900(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$800(Landroid/bluetooth/BluetoothDeviceProfileState;I)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-direct {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->setTrust(I)V

    return-void
.end method

.method static synthetic access$8000(Landroid/bluetooth/BluetoothDeviceProfileState;Lcom/android/internal/util/IState;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->transitionTo(Lcom/android/internal/util/IState;)V

    return-void
.end method

.method static synthetic access$8100(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$8200(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$8300(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$8400(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$8500(Landroid/bluetooth/BluetoothDeviceProfileState;Lcom/android/internal/util/IState;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->transitionTo(Lcom/android/internal/util/IState;)V

    return-void
.end method

.method static synthetic access$8600(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$8700(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$8800(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$8900(Landroid/bluetooth/BluetoothDeviceProfileState;Lcom/android/internal/util/IState;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->transitionTo(Lcom/android/internal/util/IState;)V

    return-void
.end method

.method static synthetic access$900(Landroid/bluetooth/BluetoothDeviceProfileState;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    iget v0, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mA2dpState:I

    return v0
.end method

.method static synthetic access$9000(Landroid/bluetooth/BluetoothDeviceProfileState;)Landroid/os/Message;
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    invoke-virtual {p0}, Landroid/bluetooth/BluetoothDeviceProfileState;->getCurrentMessage()Landroid/os/Message;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$902(Landroid/bluetooth/BluetoothDeviceProfileState;I)I
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    iput p1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mA2dpState:I

    return p1
.end method

.method static synthetic access$9100(Landroid/bluetooth/BluetoothDeviceProfileState;)Landroid/os/Message;
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    invoke-virtual {p0}, Landroid/bluetooth/BluetoothDeviceProfileState;->getCurrentMessage()Landroid/os/Message;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$9200(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$9300(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$9400(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$9500(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$9600(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$9700(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$9800(Landroid/bluetooth/BluetoothDeviceProfileState;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$9900(Landroid/bluetooth/BluetoothDeviceProfileState;Lcom/android/internal/util/IState;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->transitionTo(Lcom/android/internal/util/IState;)V

    return-void
.end method

.method private getStringValue(J)Ljava/lang/String;
    .registers 6
    .parameter "value"

    .prologue
    .line 1122
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 1123
    .local v0, sbr:Ljava/lang/StringBuilder;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    invoke-static {v1, v2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1124
    const-string v1, "-"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1125
    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1126
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method private getTrust()I
    .registers 3

    .prologue
    .line 1115
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mDevice:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v0

    .line 1116
    .local v0, address:Ljava/lang/String;
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingConnections:Landroid/util/Pair;

    if-eqz v1, :cond_15

    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingConnections:Landroid/util/Pair;

    iget-object v1, v1, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    .line 1117
    :goto_14
    return v1

    :cond_15
    const/4 v1, -0x1

    goto :goto_14
.end method

.method private handleConnectionOfOtherProfiles(I)V
    .registers 10
    .parameter "command"

    .prologue
    const-wide/16 v6, 0xfa0

    const/16 v5, 0x3e8

    const/16 v4, 0x67

    const/16 v3, 0x64

    .line 1307
    packed-switch p1, :pswitch_data_54

    .line 1338
    :cond_b
    :goto_b
    :pswitch_b
    return-void

    .line 1311
    :pswitch_c
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mA2dpService:Landroid/server/BluetoothA2dpService;

    iget-object v2, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mDevice:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v1, v2}, Landroid/server/BluetoothA2dpService;->getPriority(Landroid/bluetooth/BluetoothDevice;)I

    move-result v1

    if-eq v1, v3, :cond_20

    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mA2dpService:Landroid/server/BluetoothA2dpService;

    iget-object v2, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mDevice:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v1, v2}, Landroid/server/BluetoothA2dpService;->getPriority(Landroid/bluetooth/BluetoothDevice;)I

    move-result v1

    if-ne v1, v5, :cond_b

    .line 1314
    :cond_20
    new-instance v0, Landroid/os/Message;

    invoke-direct {v0}, Landroid/os/Message;-><init>()V

    .line 1315
    .local v0, msg:Landroid/os/Message;
    iput v4, v0, Landroid/os/Message;->what:I

    .line 1316
    const/4 v1, 0x3

    iput v1, v0, Landroid/os/Message;->arg1:I

    .line 1317
    invoke-virtual {p0, v0, v6, v7}, Landroid/bluetooth/BluetoothDeviceProfileState;->sendMessageDelayed(Landroid/os/Message;J)V

    goto :goto_b

    .line 1324
    .end local v0           #msg:Landroid/os/Message;
    :pswitch_2e
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mHeadsetService:Landroid/bluetooth/BluetoothHeadset;

    if-eqz v1, :cond_b

    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mHeadsetService:Landroid/bluetooth/BluetoothHeadset;

    iget-object v2, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mDevice:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v1, v2}, Landroid/bluetooth/BluetoothHeadset;->getPriority(Landroid/bluetooth/BluetoothDevice;)I

    move-result v1

    if-eq v1, v3, :cond_46

    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mHeadsetService:Landroid/bluetooth/BluetoothHeadset;

    iget-object v2, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mDevice:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v1, v2}, Landroid/bluetooth/BluetoothHeadset;->getPriority(Landroid/bluetooth/BluetoothDevice;)I

    move-result v1

    if-ne v1, v5, :cond_b

    .line 1328
    :cond_46
    new-instance v0, Landroid/os/Message;

    invoke-direct {v0}, Landroid/os/Message;-><init>()V

    .line 1329
    .restart local v0       #msg:Landroid/os/Message;
    iput v4, v0, Landroid/os/Message;->what:I

    .line 1330
    const/4 v1, 0x1

    iput v1, v0, Landroid/os/Message;->arg1:I

    .line 1331
    invoke-virtual {p0, v0, v6, v7}, Landroid/bluetooth/BluetoothDeviceProfileState;->sendMessageDelayed(Landroid/os/Message;J)V

    goto :goto_b

    .line 1307
    :pswitch_data_54
    .packed-switch 0x2
        :pswitch_c
        :pswitch_b
        :pswitch_2e
    .end packed-switch
.end method

.method private handleIncomingConnection(IZ)Z
    .registers 12
    .parameter "command"
    .parameter "accept"

    .prologue
    const/4 v8, 0x0

    const/16 v7, 0x66

    const/4 v6, 0x1

    const-wide/16 v4, 0x0

    .line 1049
    const/4 v0, 0x0

    .line 1050
    .local v0, ret:Z
    const-string v1, "BluetoothDeviceProfileState"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "handleIncomingConnection:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1051
    packed-switch p1, :pswitch_data_b6

    .line 1088
    :pswitch_2c
    const-string v1, "BluetoothDeviceProfileState"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Waiting for incoming connection but state changed to:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1091
    :cond_44
    :goto_44
    return v0

    .line 1053
    :pswitch_45
    if-nez p2, :cond_56

    .line 1054
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mHeadsetService:Landroid/bluetooth/BluetoothHeadset;

    iget-object v2, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mDevice:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v1, v2}, Landroid/bluetooth/BluetoothHeadset;->rejectIncomingConnect(Landroid/bluetooth/BluetoothDevice;)Z

    move-result v0

    .line 1055
    invoke-virtual {p0, v7}, Landroid/bluetooth/BluetoothDeviceProfileState;->sendMessage(I)V

    .line 1056
    invoke-direct {p0}, Landroid/bluetooth/BluetoothDeviceProfileState;->updateIncomingAllowedTimer()V

    goto :goto_44

    .line 1057
    :cond_56
    iget v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mHeadsetState:I

    if-ne v1, v6, :cond_66

    .line 1058
    invoke-direct {p0, v4, v5}, Landroid/bluetooth/BluetoothDeviceProfileState;->writeTimerValue(J)V

    .line 1059
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mHeadsetService:Landroid/bluetooth/BluetoothHeadset;

    iget-object v2, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mDevice:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v1, v2}, Landroid/bluetooth/BluetoothHeadset;->acceptIncomingConnect(Landroid/bluetooth/BluetoothDevice;)Z

    move-result v0

    goto :goto_44

    .line 1060
    :cond_66
    iget v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mHeadsetState:I

    if-nez v1, :cond_44

    .line 1061
    invoke-direct {p0, v4, v5}, Landroid/bluetooth/BluetoothDeviceProfileState;->writeTimerValue(J)V

    .line 1062
    invoke-direct {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->handleConnectionOfOtherProfiles(I)V

    .line 1063
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mHeadsetService:Landroid/bluetooth/BluetoothHeadset;

    iget-object v2, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mDevice:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v1, v2}, Landroid/bluetooth/BluetoothHeadset;->createIncomingConnect(Landroid/bluetooth/BluetoothDevice;)Z

    move-result v0

    goto :goto_44

    .line 1067
    :pswitch_79
    if-nez p2, :cond_8a

    .line 1068
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mA2dpService:Landroid/server/BluetoothA2dpService;

    iget-object v2, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mDevice:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v1, v2, v8}, Landroid/server/BluetoothA2dpService;->allowIncomingConnect(Landroid/bluetooth/BluetoothDevice;Z)Z

    move-result v0

    .line 1069
    invoke-virtual {p0, v7}, Landroid/bluetooth/BluetoothDeviceProfileState;->sendMessage(I)V

    .line 1070
    invoke-direct {p0}, Landroid/bluetooth/BluetoothDeviceProfileState;->updateIncomingAllowedTimer()V

    goto :goto_44

    .line 1072
    :cond_8a
    invoke-direct {p0, v4, v5}, Landroid/bluetooth/BluetoothDeviceProfileState;->writeTimerValue(J)V

    .line 1073
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mA2dpService:Landroid/server/BluetoothA2dpService;

    iget-object v2, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mDevice:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v1, v2, v6}, Landroid/server/BluetoothA2dpService;->allowIncomingConnect(Landroid/bluetooth/BluetoothDevice;Z)Z

    move-result v0

    .line 1074
    invoke-direct {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->handleConnectionOfOtherProfiles(I)V

    goto :goto_44

    .line 1078
    :pswitch_99
    if-nez p2, :cond_aa

    .line 1079
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mService:Landroid/server/BluetoothService;

    iget-object v2, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mDevice:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v1, v2, v8}, Landroid/server/BluetoothService;->allowIncomingProfileConnect(Landroid/bluetooth/BluetoothDevice;Z)Z

    move-result v0

    .line 1080
    invoke-virtual {p0, v7}, Landroid/bluetooth/BluetoothDeviceProfileState;->sendMessage(I)V

    .line 1081
    invoke-direct {p0}, Landroid/bluetooth/BluetoothDeviceProfileState;->updateIncomingAllowedTimer()V

    goto :goto_44

    .line 1083
    :cond_aa
    invoke-direct {p0, v4, v5}, Landroid/bluetooth/BluetoothDeviceProfileState;->writeTimerValue(J)V

    .line 1084
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mService:Landroid/server/BluetoothService;

    iget-object v2, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mDevice:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v1, v2, v6}, Landroid/server/BluetoothService;->allowIncomingProfileConnect(Landroid/bluetooth/BluetoothDevice;Z)Z

    move-result v0

    .line 1086
    goto :goto_44

    .line 1051
    :pswitch_data_b6
    .packed-switch 0x2
        :pswitch_45
        :pswitch_2c
        :pswitch_79
        :pswitch_2c
        :pswitch_99
    .end packed-switch
.end method

.method private isPhoneDocked(Landroid/bluetooth/BluetoothDevice;)Z
    .registers 10
    .parameter "autoConnectDevice"

    .prologue
    const/4 v3, 0x0

    .line 211
    iget-object v4, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mContext:Landroid/content/Context;

    const/4 v5, 0x0

    new-instance v6, Landroid/content/IntentFilter;

    const-string v7, "android.intent.action.DOCK_EVENT"

    invoke-direct {v6, v7}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v5, v6}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    move-result-object v1

    .line 212
    .local v1, i:Landroid/content/Intent;
    if-eqz v1, :cond_2a

    .line 213
    const-string v4, "android.intent.extra.DOCK_STATE"

    invoke-virtual {v1, v4, v3}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v2

    .line 214
    .local v2, state:I
    if-eqz v2, :cond_2a

    .line 215
    const-string v4, "android.bluetooth.device.extra.DEVICE"

    invoke-virtual {v1, v4}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/bluetooth/BluetoothDevice;

    .line 216
    .local v0, device:Landroid/bluetooth/BluetoothDevice;
    if-eqz v0, :cond_2a

    invoke-virtual {p1, v0}, Landroid/bluetooth/BluetoothDevice;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2a

    .line 217
    const/4 v3, 0x1

    .line 221
    .end local v0           #device:Landroid/bluetooth/BluetoothDevice;
    .end local v2           #state:I
    :cond_2a
    return v3
.end method

.method private log(Ljava/lang/String;)V
    .registers 2
    .parameter "message"

    .prologue
    .line 1348
    return-void
.end method

.method private processIncomingConnectCommand(I)V
    .registers 6
    .parameter "command"

    .prologue
    const/4 v2, 0x1

    .line 1267
    invoke-direct {p0}, Landroid/bluetooth/BluetoothDeviceProfileState;->getTrust()I

    move-result v0

    .line 1268
    .local v0, access:I
    if-ne v0, v2, :cond_b

    .line 1269
    invoke-direct {p0, p1, v2}, Landroid/bluetooth/BluetoothDeviceProfileState;->handleIncomingConnection(IZ)Z

    .line 1279
    :goto_a
    return-void

    .line 1270
    :cond_b
    const/4 v2, 0x2

    if-ne v0, v2, :cond_19

    invoke-direct {p0}, Landroid/bluetooth/BluetoothDeviceProfileState;->readIncomingAllowedValue()Z

    move-result v2

    if-nez v2, :cond_19

    .line 1272
    const/4 v2, 0x0

    invoke-direct {p0, p1, v2}, Landroid/bluetooth/BluetoothDeviceProfileState;->handleIncomingConnection(IZ)Z

    goto :goto_a

    .line 1274
    :cond_19
    invoke-direct {p0}, Landroid/bluetooth/BluetoothDeviceProfileState;->sendConnectionAccessIntent()V

    .line 1275
    const/16 v2, 0x69

    invoke-virtual {p0, v2}, Landroid/bluetooth/BluetoothDeviceProfileState;->obtainMessage(I)Landroid/os/Message;

    move-result-object v1

    .line 1276
    .local v1, msg:Landroid/os/Message;
    const-wide/16 v2, 0x1b58

    invoke-virtual {p0, v1, v2, v3}, Landroid/bluetooth/BluetoothDeviceProfileState;->sendMessageDelayed(Landroid/os/Message;J)V

    goto :goto_a
.end method

.method private readIncomingAllowedValue()Z
    .registers 13

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x1

    .line 1164
    invoke-direct {p0}, Landroid/bluetooth/BluetoothDeviceProfileState;->readTimerValue()J

    move-result-wide v8

    const-wide/16 v10, 0x0

    cmp-long v8, v8, v10

    if-nez v8, :cond_d

    .line 1174
    :cond_c
    :goto_c
    return v6

    .line 1165
    :cond_d
    iget-object v8, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingConnections:Landroid/util/Pair;

    iget-object v5, v8, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v5, Ljava/lang/String;

    .line 1166
    .local v5, value:Ljava/lang/String;
    const-string v8, "-"

    invoke-virtual {v5, v8}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 1167
    .local v0, splits:[Ljava/lang/String;
    if-eqz v0, :cond_35

    array-length v8, v0

    const/4 v9, 0x2

    if-ne v8, v9, :cond_35

    .line 1168
    aget-object v8, v0, v7

    invoke-static {v8}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v1

    .line 1169
    .local v1, val1:J
    aget-object v8, v0, v6

    invoke-static {v8}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v3

    .line 1170
    .local v3, val2:J
    add-long v8, v1, v3

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v10

    cmp-long v8, v8, v10

    if-lez v8, :cond_c

    .end local v1           #val1:J
    .end local v3           #val2:J
    :cond_35
    move v6, v7

    .line 1174
    goto :goto_c
.end method

.method private readTimerValue()J
    .registers 7

    .prologue
    const-wide/16 v2, 0x0

    .line 1153
    iget-object v4, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingConnections:Landroid/util/Pair;

    if-nez v4, :cond_7

    .line 1160
    :cond_6
    :goto_6
    return-wide v2

    .line 1155
    :cond_7
    iget-object v4, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingConnections:Landroid/util/Pair;

    iget-object v1, v4, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v1, Ljava/lang/String;

    .line 1156
    .local v1, value:Ljava/lang/String;
    const-string v4, "-"

    invoke-virtual {v1, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 1157
    .local v0, splits:[Ljava/lang/String;
    if-eqz v0, :cond_6

    array-length v4, v0

    const/4 v5, 0x2

    if-ne v4, v5, :cond_6

    .line 1158
    const/4 v2, 0x1

    aget-object v2, v0, v2

    invoke-static {v2}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v2

    goto :goto_6
.end method

.method private sendConnectionAccessIntent()V
    .registers 4

    .prologue
    .line 1095
    const/4 v1, 0x0

    iput-boolean v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mConnectionAccessReplyReceived:Z

    .line 1097
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mPowerManager:Landroid/os/PowerManager;

    invoke-virtual {v1}, Landroid/os/PowerManager;->isScreenOn()Z

    move-result v1

    if-nez v1, :cond_10

    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mWakeLock:Landroid/os/PowerManager$WakeLock;

    invoke-virtual {v1}, Landroid/os/PowerManager$WakeLock;->acquire()V

    .line 1099
    :cond_10
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.bluetooth.device.action.CONNECTION_ACCESS_REQUEST"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 1100
    .local v0, intent:Landroid/content/Intent;
    const-string v1, "com.android.settings"

    const-string v2, "com.android.settings.bluetooth.BluetoothPermissionRequest"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setClassName(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1101
    const-string v1, "android.bluetooth.device.extra.ACCESS_REQUEST_TYPE"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 1103
    const-string v1, "android.bluetooth.device.extra.DEVICE"

    iget-object v2, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mDevice:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 1104
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mContext:Landroid/content/Context;

    const-string v2, "android.permission.BLUETOOTH_ADMIN"

    invoke-virtual {v1, v0, v2}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    .line 1105
    return-void
.end method

.method private sendConnectionAccessRemovalIntent()V
    .registers 4

    .prologue
    .line 1108
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mWakeLock:Landroid/os/PowerManager$WakeLock;

    invoke-virtual {v1}, Landroid/os/PowerManager$WakeLock;->release()V

    .line 1109
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.bluetooth.device.action.CONNECTION_ACCESS_CANCEL"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 1110
    .local v0, intent:Landroid/content/Intent;
    const-string v1, "android.bluetooth.device.extra.DEVICE"

    iget-object v2, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mDevice:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 1111
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mContext:Landroid/content/Context;

    const-string v2, "android.permission.BLUETOOTH_ADMIN"

    invoke-virtual {v1, v0, v2}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    .line 1112
    return-void
.end method

.method private setTrust(I)V
    .registers 6
    .parameter "value"

    .prologue
    .line 1131
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingConnections:Landroid/util/Pair;

    if-nez v1, :cond_23

    .line 1132
    const-wide/16 v1, 0x3e8

    invoke-direct {p0, v1, v2}, Landroid/bluetooth/BluetoothDeviceProfileState;->getStringValue(J)Ljava/lang/String;

    move-result-object v0

    .line 1137
    .local v0, second:Ljava/lang/String;
    :goto_a
    new-instance v1, Landroid/util/Pair;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    iput-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingConnections:Landroid/util/Pair;

    .line 1138
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mService:Landroid/server/BluetoothService;

    iget-object v2, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mDevice:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v2}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingConnections:Landroid/util/Pair;

    invoke-virtual {v1, v2, v3}, Landroid/server/BluetoothService;->writeIncomingConnectionState(Ljava/lang/String;Landroid/util/Pair;)V

    .line 1139
    return-void

    .line 1134
    .end local v0           #second:Ljava/lang/String;
    :cond_23
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingConnections:Landroid/util/Pair;

    iget-object v0, v1, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v0, Ljava/lang/String;

    .restart local v0       #second:Ljava/lang/String;
    goto :goto_a
.end method

.method private updateIncomingAllowedTimer()V
    .registers 7

    .prologue
    const-wide/32 v4, 0xdbba00

    .line 1039
    iget-wide v0, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingRejectTimer:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_f

    const-wide/16 v0, 0x3e8

    iput-wide v0, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingRejectTimer:J

    .line 1041
    :cond_f
    iget-wide v0, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingRejectTimer:J

    const-wide/16 v2, 0x5

    mul-long/2addr v0, v2

    iput-wide v0, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingRejectTimer:J

    .line 1042
    iget-wide v0, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingRejectTimer:J

    cmp-long v0, v0, v4

    if-lez v0, :cond_1e

    .line 1043
    iput-wide v4, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingRejectTimer:J

    .line 1045
    :cond_1e
    iget-wide v0, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingRejectTimer:J

    invoke-direct {p0, v0, v1}, Landroid/bluetooth/BluetoothDeviceProfileState;->writeTimerValue(J)V

    .line 1046
    return-void
.end method

.method private writeTimerValue(J)V
    .registers 7
    .parameter "value"

    .prologue
    .line 1143
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingConnections:Landroid/util/Pair;

    if-nez v1, :cond_22

    .line 1144
    const/4 v1, -0x1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    .line 1148
    .local v0, first:Ljava/lang/Integer;
    :goto_9
    new-instance v1, Landroid/util/Pair;

    invoke-direct {p0, p1, p2}, Landroid/bluetooth/BluetoothDeviceProfileState;->getStringValue(J)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v0, v2}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    iput-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingConnections:Landroid/util/Pair;

    .line 1149
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mService:Landroid/server/BluetoothService;

    iget-object v2, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mDevice:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v2}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingConnections:Landroid/util/Pair;

    invoke-virtual {v1, v2, v3}, Landroid/server/BluetoothService;->writeIncomingConnectionState(Ljava/lang/String;Landroid/util/Pair;)V

    .line 1150
    return-void

    .line 1146
    .end local v0           #first:Ljava/lang/Integer;
    :cond_22
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mIncomingConnections:Landroid/util/Pair;

    iget-object v0, v1, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v0, Ljava/lang/Integer;

    .restart local v0       #first:Ljava/lang/Integer;
    goto :goto_9
.end method


# virtual methods
.method declared-synchronized cancelCommand(I)V
    .registers 3
    .parameter "command"

    .prologue
    .line 1019
    monitor-enter p0

    const/4 v0, 0x1

    if-ne p1, v0, :cond_d

    .line 1021
    :try_start_4
    iget-object v0, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mHeadsetService:Landroid/bluetooth/BluetoothHeadset;

    if-eqz v0, :cond_d

    .line 1022
    iget-object v0, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mHeadsetService:Landroid/bluetooth/BluetoothHeadset;

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothHeadset;->cancelConnectThread()Z
    :try_end_d
    .catchall {:try_start_4 .. :try_end_d} :catchall_f

    .line 1027
    :cond_d
    monitor-exit p0

    return-void

    .line 1019
    :catchall_f
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized deferProfileServiceMessage(I)V
    .registers 4
    .parameter "command"

    .prologue
    .line 1030
    monitor-enter p0

    :try_start_1
    new-instance v0, Landroid/os/Message;

    invoke-direct {v0}, Landroid/os/Message;-><init>()V

    .line 1031
    .local v0, msg:Landroid/os/Message;
    iput p1, v0, Landroid/os/Message;->what:I

    .line 1032
    invoke-virtual {p0, v0}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V
    :try_end_b
    .catchall {:try_start_1 .. :try_end_b} :catchall_d

    .line 1033
    monitor-exit p0

    return-void

    .line 1030
    .end local v0           #msg:Landroid/os/Message;
    :catchall_d
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method getDevice()Landroid/bluetooth/BluetoothDevice;
    .registers 2

    .prologue
    .line 1341
    iget-object v0, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mDevice:Landroid/bluetooth/BluetoothDevice;

    return-object v0
.end method

.method declared-synchronized processCommand(I)Z
    .registers 7
    .parameter "command"

    .prologue
    const/16 v4, 0x3e8

    const/4 v1, 0x1

    .line 1178
    monitor-enter p0

    :try_start_4
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Processing command:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v2}, Landroid/bluetooth/BluetoothDeviceProfileState;->log(Ljava/lang/String;)V

    .line 1179
    sparse-switch p1, :sswitch_data_fc

    .line 1260
    const-string v1, "BluetoothDeviceProfileState"

    const-string v2, "Error: Unknown Command"

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_24
    .catchall {:try_start_4 .. :try_end_24} :catchall_2f

    .line 1262
    :cond_24
    :goto_24
    const/4 v1, 0x0

    :goto_25
    :sswitch_25
    monitor-exit p0

    return v1

    .line 1181
    :sswitch_27
    :try_start_27
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mHeadsetService:Landroid/bluetooth/BluetoothHeadset;

    if-nez v1, :cond_32

    .line 1182
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferProfileServiceMessage(I)V
    :try_end_2e
    .catchall {:try_start_27 .. :try_end_2e} :catchall_2f

    goto :goto_24

    .line 1178
    :catchall_2f
    move-exception v1

    monitor-exit p0

    throw v1

    .line 1184
    :cond_32
    :try_start_32
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mHeadsetService:Landroid/bluetooth/BluetoothHeadset;

    iget-object v2, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mDevice:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v1, v2}, Landroid/bluetooth/BluetoothHeadset;->connectHeadsetInternal(Landroid/bluetooth/BluetoothDevice;)Z

    move-result v1

    goto :goto_25

    .line 1188
    :sswitch_3b
    iget-object v2, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mHeadsetService:Landroid/bluetooth/BluetoothHeadset;

    if-nez v2, :cond_43

    .line 1189
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferProfileServiceMessage(I)V

    goto :goto_24

    .line 1191
    :cond_43
    invoke-direct {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->processIncomingConnectCommand(I)V

    goto :goto_25

    .line 1196
    :sswitch_47
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mA2dpService:Landroid/server/BluetoothA2dpService;

    if-eqz v1, :cond_24

    .line 1197
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mA2dpService:Landroid/server/BluetoothA2dpService;

    iget-object v2, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mDevice:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v1, v2}, Landroid/server/BluetoothA2dpService;->connectSinkInternal(Landroid/bluetooth/BluetoothDevice;)Z

    move-result v1

    goto :goto_25

    .line 1201
    :sswitch_54
    invoke-direct {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->processIncomingConnectCommand(I)V

    goto :goto_25

    .line 1204
    :sswitch_58
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mService:Landroid/server/BluetoothService;

    iget-object v2, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mDevice:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v1, v2}, Landroid/server/BluetoothService;->connectInputDeviceInternal(Landroid/bluetooth/BluetoothDevice;)Z

    move-result v1

    goto :goto_25

    .line 1206
    :sswitch_61
    invoke-direct {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->processIncomingConnectCommand(I)V

    goto :goto_25

    .line 1209
    :sswitch_65
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mHeadsetService:Landroid/bluetooth/BluetoothHeadset;

    if-nez v1, :cond_6d

    .line 1210
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferProfileServiceMessage(I)V

    goto :goto_24

    .line 1214
    :cond_6d
    new-instance v0, Landroid/os/Message;

    invoke-direct {v0}, Landroid/os/Message;-><init>()V

    .line 1215
    .local v0, m:Landroid/os/Message;
    const/16 v1, 0x38

    iput v1, v0, Landroid/os/Message;->what:I

    .line 1216
    invoke-virtual {p0, v0}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferMessage(Landroid/os/Message;)V

    .line 1217
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mHeadsetService:Landroid/bluetooth/BluetoothHeadset;

    iget-object v2, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mDevice:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v1, v2}, Landroid/bluetooth/BluetoothHeadset;->getPriority(Landroid/bluetooth/BluetoothDevice;)I

    move-result v1

    if-ne v1, v4, :cond_8c

    .line 1219
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mHeadsetService:Landroid/bluetooth/BluetoothHeadset;

    iget-object v2, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mDevice:Landroid/bluetooth/BluetoothDevice;

    const/16 v3, 0x64

    invoke-virtual {v1, v2, v3}, Landroid/bluetooth/BluetoothHeadset;->setPriority(Landroid/bluetooth/BluetoothDevice;I)Z

    .line 1221
    :cond_8c
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mHeadsetService:Landroid/bluetooth/BluetoothHeadset;

    iget-object v2, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mDevice:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v1, v2}, Landroid/bluetooth/BluetoothHeadset;->disconnectHeadsetInternal(Landroid/bluetooth/BluetoothDevice;)Z

    move-result v1

    goto :goto_25

    .line 1231
    .end local v0           #m:Landroid/os/Message;
    :sswitch_95
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mA2dpService:Landroid/server/BluetoothA2dpService;

    if-eqz v1, :cond_24

    .line 1232
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mA2dpService:Landroid/server/BluetoothA2dpService;

    iget-object v2, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mDevice:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v1, v2}, Landroid/server/BluetoothA2dpService;->getPriority(Landroid/bluetooth/BluetoothDevice;)I

    move-result v1

    if-ne v1, v4, :cond_ac

    .line 1234
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mA2dpService:Landroid/server/BluetoothA2dpService;

    iget-object v2, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mDevice:Landroid/bluetooth/BluetoothDevice;

    const/16 v3, 0x64

    invoke-virtual {v1, v2, v3}, Landroid/server/BluetoothA2dpService;->setPriority(Landroid/bluetooth/BluetoothDevice;I)Z

    .line 1236
    :cond_ac
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mA2dpService:Landroid/server/BluetoothA2dpService;

    iget-object v2, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mDevice:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v1, v2}, Landroid/server/BluetoothA2dpService;->disconnectSinkInternal(Landroid/bluetooth/BluetoothDevice;)Z

    move-result v1

    goto/16 :goto_25

    .line 1243
    :sswitch_b6
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mService:Landroid/server/BluetoothService;

    iget-object v2, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mDevice:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v1, v2}, Landroid/server/BluetoothService;->getInputDevicePriority(Landroid/bluetooth/BluetoothDevice;)I

    move-result v1

    if-ne v1, v4, :cond_c9

    .line 1245
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mService:Landroid/server/BluetoothService;

    iget-object v2, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mDevice:Landroid/bluetooth/BluetoothDevice;

    const/16 v3, 0x64

    invoke-virtual {v1, v2, v3}, Landroid/server/BluetoothService;->setInputDevicePriority(Landroid/bluetooth/BluetoothDevice;I)Z

    .line 1247
    :cond_c9
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mService:Landroid/server/BluetoothService;

    iget-object v2, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mDevice:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v1, v2}, Landroid/server/BluetoothService;->disconnectInputDeviceInternal(Landroid/bluetooth/BluetoothDevice;)Z

    move-result v1

    goto/16 :goto_25

    .line 1249
    :sswitch_d3
    iget-boolean v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mPbapServiceConnected:Z

    if-nez v1, :cond_dc

    .line 1250
    invoke-virtual {p0, p1}, Landroid/bluetooth/BluetoothDeviceProfileState;->deferProfileServiceMessage(I)V

    goto/16 :goto_24

    .line 1252
    :cond_dc
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mPbapService:Landroid/bluetooth/BluetoothPbap;

    invoke-virtual {v1}, Landroid/bluetooth/BluetoothPbap;->disconnect()Z

    move-result v1

    goto/16 :goto_25

    .line 1256
    :sswitch_e4
    const-wide/16 v1, 0x3e8

    invoke-direct {p0, v1, v2}, Landroid/bluetooth/BluetoothDeviceProfileState;->writeTimerValue(J)V

    .line 1257
    const/4 v1, -0x1

    invoke-direct {p0, v1}, Landroid/bluetooth/BluetoothDeviceProfileState;->setTrust(I)V

    .line 1258
    iget-object v1, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mService:Landroid/server/BluetoothService;

    iget-object v2, p0, Landroid/bluetooth/BluetoothDeviceProfileState;->mDevice:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v2}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/server/BluetoothService;->removeBondInternal(Ljava/lang/String;)Z
    :try_end_f8
    .catchall {:try_start_32 .. :try_end_f8} :catchall_2f

    move-result v1

    goto/16 :goto_25

    .line 1179
    nop

    :sswitch_data_fc
    .sparse-switch
        0x1 -> :sswitch_27
        0x2 -> :sswitch_3b
        0x3 -> :sswitch_47
        0x4 -> :sswitch_54
        0x5 -> :sswitch_58
        0x6 -> :sswitch_61
        0x32 -> :sswitch_65
        0x33 -> :sswitch_25
        0x34 -> :sswitch_95
        0x35 -> :sswitch_25
        0x36 -> :sswitch_b6
        0x37 -> :sswitch_25
        0x38 -> :sswitch_d3
        0x64 -> :sswitch_e4
    .end sparse-switch
.end method
