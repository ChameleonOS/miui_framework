.class public Landroid/net/rtp/RtpStream;
.super Ljava/lang/Object;
.source "RtpStream.java"


# static fields
.field private static final MODE_LAST:I = 0x2

.field public static final MODE_NORMAL:I = 0x0

.field public static final MODE_RECEIVE_ONLY:I = 0x2

.field public static final MODE_SEND_ONLY:I = 0x1


# instance fields
.field private final mLocalAddress:Ljava/net/InetAddress;

.field private final mLocalPort:I

.field private mMode:I

.field private mRemoteAddress:Ljava/net/InetAddress;

.field private mRemotePort:I

.field private mSocket:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 59
    const-string/jumbo v0, "rtp_jni"

    invoke-static {v0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    .line 60
    return-void
.end method

.method constructor <init>(Ljava/net/InetAddress;)V
    .registers 4
    .parameter "address"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/SocketException;
        }
    .end annotation

    .prologue
    const/4 v1, -0x1

    .line 70
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 54
    iput v1, p0, Landroid/net/rtp/RtpStream;->mRemotePort:I

    .line 55
    const/4 v0, 0x0

    iput v0, p0, Landroid/net/rtp/RtpStream;->mMode:I

    .line 57
    iput v1, p0, Landroid/net/rtp/RtpStream;->mSocket:I

    .line 71
    invoke-virtual {p1}, Ljava/net/InetAddress;->getHostAddress()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Landroid/net/rtp/RtpStream;->create(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Landroid/net/rtp/RtpStream;->mLocalPort:I

    .line 72
    iput-object p1, p0, Landroid/net/rtp/RtpStream;->mLocalAddress:Ljava/net/InetAddress;

    .line 73
    return-void
.end method

.method private native close()V
.end method

.method private native create(Ljava/lang/String;)I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/SocketException;
        }
    .end annotation
.end method


# virtual methods
.method public associate(Ljava/net/InetAddress;I)V
    .registers 5
    .parameter "address"
    .parameter "port"

    .prologue
    .line 154
    invoke-virtual {p0}, Landroid/net/rtp/RtpStream;->isBusy()Z

    move-result v0

    if-eqz v0, :cond_e

    .line 155
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Busy"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 157
    :cond_e
    instance-of v0, p1, Ljava/net/Inet4Address;

    if-eqz v0, :cond_18

    iget-object v0, p0, Landroid/net/rtp/RtpStream;->mLocalAddress:Ljava/net/InetAddress;

    instance-of v0, v0, Ljava/net/Inet4Address;

    if-nez v0, :cond_2a

    :cond_18
    instance-of v0, p1, Ljava/net/Inet6Address;

    if-eqz v0, :cond_22

    iget-object v0, p0, Landroid/net/rtp/RtpStream;->mLocalAddress:Ljava/net/InetAddress;

    instance-of v0, v0, Ljava/net/Inet6Address;

    if-nez v0, :cond_2a

    .line 159
    :cond_22
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Unsupported address"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 161
    :cond_2a
    if-ltz p2, :cond_31

    const v0, 0xffff

    if-le p2, v0, :cond_39

    .line 162
    :cond_31
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Invalid port"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 164
    :cond_39
    iput-object p1, p0, Landroid/net/rtp/RtpStream;->mRemoteAddress:Ljava/net/InetAddress;

    .line 165
    iput p2, p0, Landroid/net/rtp/RtpStream;->mRemotePort:I

    .line 166
    return-void
.end method

.method protected finalize()V
    .registers 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 192
    invoke-direct {p0}, Landroid/net/rtp/RtpStream;->close()V

    .line 193
    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    .line 194
    return-void
.end method

.method public getLocalAddress()Ljava/net/InetAddress;
    .registers 2

    .prologue
    .line 81
    iget-object v0, p0, Landroid/net/rtp/RtpStream;->mLocalAddress:Ljava/net/InetAddress;

    return-object v0
.end method

.method public getLocalPort()I
    .registers 2

    .prologue
    .line 88
    iget v0, p0, Landroid/net/rtp/RtpStream;->mLocalPort:I

    return v0
.end method

.method public getMode()I
    .registers 2

    .prologue
    .line 120
    iget v0, p0, Landroid/net/rtp/RtpStream;->mMode:I

    return v0
.end method

.method public getRemoteAddress()Ljava/net/InetAddress;
    .registers 2

    .prologue
    .line 96
    iget-object v0, p0, Landroid/net/rtp/RtpStream;->mRemoteAddress:Ljava/net/InetAddress;

    return-object v0
.end method

.method public getRemotePort()I
    .registers 2

    .prologue
    .line 104
    iget v0, p0, Landroid/net/rtp/RtpStream;->mRemotePort:I

    return v0
.end method

.method getSocket()I
    .registers 2

    .prologue
    .line 169
    iget v0, p0, Landroid/net/rtp/RtpStream;->mSocket:I

    return v0
.end method

.method public isBusy()Z
    .registers 2

    .prologue
    .line 113
    const/4 v0, 0x0

    return v0
.end method

.method public release()V
    .registers 3

    .prologue
    .line 180
    monitor-enter p0

    .line 181
    :try_start_1
    invoke-virtual {p0}, Landroid/net/rtp/RtpStream;->isBusy()Z

    move-result v0

    if-eqz v0, :cond_12

    .line 182
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Busy"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 185
    :catchall_f
    move-exception v0

    monitor-exit p0
    :try_end_11
    .catchall {:try_start_1 .. :try_end_11} :catchall_f

    throw v0

    .line 184
    :cond_12
    :try_start_12
    invoke-direct {p0}, Landroid/net/rtp/RtpStream;->close()V

    .line 185
    monitor-exit p0
    :try_end_16
    .catchall {:try_start_12 .. :try_end_16} :catchall_f

    .line 186
    return-void
.end method

.method public setMode(I)V
    .registers 4
    .parameter "mode"

    .prologue
    .line 133
    invoke-virtual {p0}, Landroid/net/rtp/RtpStream;->isBusy()Z

    move-result v0

    if-eqz v0, :cond_e

    .line 134
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Busy"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 136
    :cond_e
    if-ltz p1, :cond_13

    const/4 v0, 0x2

    if-le p1, v0, :cond_1b

    .line 137
    :cond_13
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Invalid mode"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 139
    :cond_1b
    iput p1, p0, Landroid/net/rtp/RtpStream;->mMode:I

    .line 140
    return-void
.end method
