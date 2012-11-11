.class Landroid/bluetooth/BluetoothAdapter$RfcommChannelPicker;
.super Ljava/lang/Object;
.source "BluetoothAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/bluetooth/BluetoothAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "RfcommChannelPicker"
.end annotation


# static fields
.field private static final RESERVED_RFCOMM_CHANNELS:[I

.field private static sChannels:Ljava/util/LinkedList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedList",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private static sRandom:Ljava/util/Random;


# instance fields
.field private final mChannels:Ljava/util/LinkedList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedList",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private final mUuid:Ljava/util/UUID;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    const/4 v0, 0x4

    new-array v0, v0, [I

    fill-array-data v0, :array_a

    sput-object v0, Landroid/bluetooth/BluetoothAdapter$RfcommChannelPicker;->RESERVED_RFCOMM_CHANNELS:[I

    return-void

    nop

    :array_a
    .array-data 0x4
        0xat 0x0t 0x0t 0x0t
        0xbt 0x0t 0x0t 0x0t
        0xct 0x0t 0x0t 0x0t
        0x13t 0x0t 0x0t 0x0t
    .end array-data
.end method

.method public constructor <init>(Ljava/util/UUID;)V
    .registers 10
    .parameter "uuid"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    const-class v6, Landroid/bluetooth/BluetoothAdapter$RfcommChannelPicker;

    monitor-enter v6

    :try_start_6
    sget-object v5, Landroid/bluetooth/BluetoothAdapter$RfcommChannelPicker;->sChannels:Ljava/util/LinkedList;

    if-nez v5, :cond_3f

    new-instance v5, Ljava/util/LinkedList;

    invoke-direct {v5}, Ljava/util/LinkedList;-><init>()V

    sput-object v5, Landroid/bluetooth/BluetoothAdapter$RfcommChannelPicker;->sChannels:Ljava/util/LinkedList;

    const/4 v1, 0x1

    .local v1, i:I
    :goto_12
    const/16 v5, 0x1e

    if-gt v1, v5, :cond_23

    sget-object v5, Landroid/bluetooth/BluetoothAdapter$RfcommChannelPicker;->sChannels:Ljava/util/LinkedList;

    new-instance v7, Ljava/lang/Integer;

    invoke-direct {v7, v1}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v5, v7}, Ljava/util/LinkedList;->addLast(Ljava/lang/Object;)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_12

    :cond_23
    sget-object v0, Landroid/bluetooth/BluetoothAdapter$RfcommChannelPicker;->RESERVED_RFCOMM_CHANNELS:[I

    .local v0, arr$:[I
    array-length v3, v0

    .local v3, len$:I
    const/4 v2, 0x0

    .local v2, i$:I
    :goto_27
    if-ge v2, v3, :cond_38

    aget v4, v0, v2

    .local v4, reserved:I
    sget-object v5, Landroid/bluetooth/BluetoothAdapter$RfcommChannelPicker;->sChannels:Ljava/util/LinkedList;

    new-instance v7, Ljava/lang/Integer;

    invoke-direct {v7, v4}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v5, v7}, Ljava/util/LinkedList;->remove(Ljava/lang/Object;)Z

    add-int/lit8 v2, v2, 0x1

    goto :goto_27

    .end local v4           #reserved:I
    :cond_38
    new-instance v5, Ljava/util/Random;

    invoke-direct {v5}, Ljava/util/Random;-><init>()V

    sput-object v5, Landroid/bluetooth/BluetoothAdapter$RfcommChannelPicker;->sRandom:Ljava/util/Random;

    .end local v0           #arr$:[I
    .end local v1           #i:I
    .end local v2           #i$:I
    .end local v3           #len$:I
    :cond_3f
    sget-object v5, Landroid/bluetooth/BluetoothAdapter$RfcommChannelPicker;->sChannels:Ljava/util/LinkedList;

    invoke-virtual {v5}, Ljava/util/LinkedList;->clone()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/LinkedList;

    iput-object v5, p0, Landroid/bluetooth/BluetoothAdapter$RfcommChannelPicker;->mChannels:Ljava/util/LinkedList;

    monitor-exit v6
    :try_end_4a
    .catchall {:try_start_6 .. :try_end_4a} :catchall_4d

    iput-object p1, p0, Landroid/bluetooth/BluetoothAdapter$RfcommChannelPicker;->mUuid:Ljava/util/UUID;

    return-void

    :catchall_4d
    move-exception v5

    :try_start_4e
    monitor-exit v6
    :try_end_4f
    .catchall {:try_start_4e .. :try_end_4f} :catchall_4d

    throw v5
.end method


# virtual methods
.method public nextChannel()I
    .registers 4

    .prologue
    iget-object v0, p0, Landroid/bluetooth/BluetoothAdapter$RfcommChannelPicker;->mChannels:Ljava/util/LinkedList;

    invoke-virtual {v0}, Ljava/util/LinkedList;->size()I

    move-result v0

    if-nez v0, :cond_a

    const/4 v0, -0x1

    :goto_9
    return v0

    :cond_a
    iget-object v0, p0, Landroid/bluetooth/BluetoothAdapter$RfcommChannelPicker;->mChannels:Ljava/util/LinkedList;

    sget-object v1, Landroid/bluetooth/BluetoothAdapter$RfcommChannelPicker;->sRandom:Ljava/util/Random;

    iget-object v2, p0, Landroid/bluetooth/BluetoothAdapter$RfcommChannelPicker;->mChannels:Ljava/util/LinkedList;

    invoke-virtual {v2}, Ljava/util/LinkedList;->size()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/util/Random;->nextInt(I)I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/util/LinkedList;->remove(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    goto :goto_9
.end method
