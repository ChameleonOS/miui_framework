.class final Landroid/bluetooth/BluetoothInputStream;
.super Ljava/io/InputStream;
.source "BluetoothInputStream.java"


# instance fields
.field private mSocket:Landroid/bluetooth/BluetoothSocket;


# direct methods
.method constructor <init>(Landroid/bluetooth/BluetoothSocket;)V
    .registers 2
    .parameter "s"

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/io/InputStream;-><init>()V

    .line 33
    iput-object p1, p0, Landroid/bluetooth/BluetoothInputStream;->mSocket:Landroid/bluetooth/BluetoothSocket;

    .line 34
    return-void
.end method


# virtual methods
.method public available()I
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 40
    iget-object v0, p0, Landroid/bluetooth/BluetoothInputStream;->mSocket:Landroid/bluetooth/BluetoothSocket;

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothSocket;->available()I

    move-result v0

    return v0
.end method

.method public close()V
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 44
    iget-object v0, p0, Landroid/bluetooth/BluetoothInputStream;->mSocket:Landroid/bluetooth/BluetoothSocket;

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothSocket;->close()V

    .line 45
    return-void
.end method

.method public read()I
    .registers 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 59
    new-array v0, v3, [B

    .line 60
    .local v0, b:[B
    iget-object v2, p0, Landroid/bluetooth/BluetoothInputStream;->mSocket:Landroid/bluetooth/BluetoothSocket;

    invoke-virtual {v2, v0, v4, v3}, Landroid/bluetooth/BluetoothSocket;->read([BII)I

    move-result v1

    .line 61
    .local v1, ret:I
    if-ne v1, v3, :cond_11

    .line 62
    aget-byte v2, v0, v4

    and-int/lit16 v2, v2, 0xff

    .line 64
    :goto_10
    return v2

    :cond_11
    const/4 v2, -0x1

    goto :goto_10
.end method

.method public read([BII)I
    .registers 6
    .parameter "b"
    .parameter "offset"
    .parameter "length"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 90
    if-nez p1, :cond_a

    .line 91
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "byte array is null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 93
    :cond_a
    or-int v0, p2, p3

    if-ltz v0, :cond_12

    array-length v0, p1

    sub-int/2addr v0, p2

    if-le p3, v0, :cond_1a

    .line 94
    :cond_12
    new-instance v0, Ljava/lang/ArrayIndexOutOfBoundsException;

    const-string v1, "invalid offset or length"

    invoke-direct {v0, v1}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 96
    :cond_1a
    iget-object v0, p0, Landroid/bluetooth/BluetoothInputStream;->mSocket:Landroid/bluetooth/BluetoothSocket;

    invoke-virtual {v0, p1, p2, p3}, Landroid/bluetooth/BluetoothSocket;->read([BII)I

    move-result v0

    return v0
.end method
