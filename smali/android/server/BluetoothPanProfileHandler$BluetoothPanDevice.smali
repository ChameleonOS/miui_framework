.class Landroid/server/BluetoothPanProfileHandler$BluetoothPanDevice;
.super Ljava/lang/Object;
.source "BluetoothPanProfileHandler.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/server/BluetoothPanProfileHandler;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "BluetoothPanDevice"
.end annotation


# instance fields
.field private mIface:Ljava/lang/String;

.field private mIfaceAddr:Ljava/lang/String;

.field private mLocalRole:I

.field private mState:I

.field final synthetic this$0:Landroid/server/BluetoothPanProfileHandler;


# direct methods
.method constructor <init>(Landroid/server/BluetoothPanProfileHandler;ILjava/lang/String;Ljava/lang/String;I)V
    .registers 6
    .parameter
    .parameter "state"
    .parameter "ifaceAddr"
    .parameter "iface"
    .parameter "localRole"

    .prologue
    .line 317
    iput-object p1, p0, Landroid/server/BluetoothPanProfileHandler$BluetoothPanDevice;->this$0:Landroid/server/BluetoothPanProfileHandler;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 318
    iput p2, p0, Landroid/server/BluetoothPanProfileHandler$BluetoothPanDevice;->mState:I

    .line 319
    iput-object p3, p0, Landroid/server/BluetoothPanProfileHandler$BluetoothPanDevice;->mIfaceAddr:Ljava/lang/String;

    .line 320
    iput-object p4, p0, Landroid/server/BluetoothPanProfileHandler$BluetoothPanDevice;->mIface:Ljava/lang/String;

    .line 321
    iput p5, p0, Landroid/server/BluetoothPanProfileHandler$BluetoothPanDevice;->mLocalRole:I

    .line 322
    return-void
.end method

.method static synthetic access$300(Landroid/server/BluetoothPanProfileHandler$BluetoothPanDevice;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 311
    iget v0, p0, Landroid/server/BluetoothPanProfileHandler$BluetoothPanDevice;->mState:I

    return v0
.end method

.method static synthetic access$302(Landroid/server/BluetoothPanProfileHandler$BluetoothPanDevice;I)I
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 311
    iput p1, p0, Landroid/server/BluetoothPanProfileHandler$BluetoothPanDevice;->mState:I

    return p1
.end method

.method static synthetic access$400(Landroid/server/BluetoothPanProfileHandler$BluetoothPanDevice;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 311
    iget v0, p0, Landroid/server/BluetoothPanProfileHandler$BluetoothPanDevice;->mLocalRole:I

    return v0
.end method

.method static synthetic access$402(Landroid/server/BluetoothPanProfileHandler$BluetoothPanDevice;I)I
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 311
    iput p1, p0, Landroid/server/BluetoothPanProfileHandler$BluetoothPanDevice;->mLocalRole:I

    return p1
.end method

.method static synthetic access$500(Landroid/server/BluetoothPanProfileHandler$BluetoothPanDevice;)Ljava/lang/String;
    .registers 2
    .parameter "x0"

    .prologue
    .line 311
    iget-object v0, p0, Landroid/server/BluetoothPanProfileHandler$BluetoothPanDevice;->mIface:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$502(Landroid/server/BluetoothPanProfileHandler$BluetoothPanDevice;Ljava/lang/String;)Ljava/lang/String;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 311
    iput-object p1, p0, Landroid/server/BluetoothPanProfileHandler$BluetoothPanDevice;->mIface:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$600(Landroid/server/BluetoothPanProfileHandler$BluetoothPanDevice;)Ljava/lang/String;
    .registers 2
    .parameter "x0"

    .prologue
    .line 311
    iget-object v0, p0, Landroid/server/BluetoothPanProfileHandler$BluetoothPanDevice;->mIfaceAddr:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$602(Landroid/server/BluetoothPanProfileHandler$BluetoothPanDevice;Ljava/lang/String;)Ljava/lang/String;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 311
    iput-object p1, p0, Landroid/server/BluetoothPanProfileHandler$BluetoothPanDevice;->mIfaceAddr:Ljava/lang/String;

    return-object p1
.end method
