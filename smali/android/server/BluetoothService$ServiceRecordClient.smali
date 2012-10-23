.class Landroid/server/BluetoothService$ServiceRecordClient;
.super Ljava/lang/Object;
.source "BluetoothService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/server/BluetoothService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "ServiceRecordClient"
.end annotation


# instance fields
.field binder:Landroid/os/IBinder;

.field death:Landroid/os/IBinder$DeathRecipient;

.field pid:I


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    .line 149
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/server/BluetoothService$1;)V
    .registers 2
    .parameter "x0"

    .prologue
    .line 149
    invoke-direct {p0}, Landroid/server/BluetoothService$ServiceRecordClient;-><init>()V

    return-void
.end method
