.class public Landroid/net/sip/SipErrorCode;
.super Ljava/lang/Object;
.source "SipErrorCode.java"


# static fields
.field public static final CLIENT_ERROR:I = -0x4

.field public static final CROSS_DOMAIN_AUTHENTICATION:I = -0xb

.field public static final DATA_CONNECTION_LOST:I = -0xa

.field public static final INVALID_CREDENTIALS:I = -0x8

.field public static final INVALID_REMOTE_URI:I = -0x6

.field public static final IN_PROGRESS:I = -0x9

.field public static final NO_ERROR:I = 0x0

.field public static final PEER_NOT_REACHABLE:I = -0x7

.field public static final SERVER_ERROR:I = -0x2

.field public static final SERVER_UNREACHABLE:I = -0xc

.field public static final SOCKET_ERROR:I = -0x1

.field public static final TIME_OUT:I = -0x5

.field public static final TRANSACTION_TERMINTED:I = -0x3


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    .line 99
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 100
    return-void
.end method

.method public static toString(I)Ljava/lang/String;
    .registers 2
    .parameter "errorCode"

    .prologue
    .line 67
    packed-switch p0, :pswitch_data_2e

    .line 95
    const-string v0, "UNKNOWN"

    :goto_5
    return-object v0

    .line 69
    :pswitch_6
    const-string v0, "NO_ERROR"

    goto :goto_5

    .line 71
    :pswitch_9
    const-string v0, "SOCKET_ERROR"

    goto :goto_5

    .line 73
    :pswitch_c
    const-string v0, "SERVER_ERROR"

    goto :goto_5

    .line 75
    :pswitch_f
    const-string v0, "TRANSACTION_TERMINTED"

    goto :goto_5

    .line 77
    :pswitch_12
    const-string v0, "CLIENT_ERROR"

    goto :goto_5

    .line 79
    :pswitch_15
    const-string v0, "TIME_OUT"

    goto :goto_5

    .line 81
    :pswitch_18
    const-string v0, "INVALID_REMOTE_URI"

    goto :goto_5

    .line 83
    :pswitch_1b
    const-string v0, "PEER_NOT_REACHABLE"

    goto :goto_5

    .line 85
    :pswitch_1e
    const-string v0, "INVALID_CREDENTIALS"

    goto :goto_5

    .line 87
    :pswitch_21
    const-string v0, "IN_PROGRESS"

    goto :goto_5

    .line 89
    :pswitch_24
    const-string v0, "DATA_CONNECTION_LOST"

    goto :goto_5

    .line 91
    :pswitch_27
    const-string v0, "CROSS_DOMAIN_AUTHENTICATION"

    goto :goto_5

    .line 93
    :pswitch_2a
    const-string v0, "SERVER_UNREACHABLE"

    goto :goto_5

    .line 67
    nop

    :pswitch_data_2e
    .packed-switch -0xc
        :pswitch_2a
        :pswitch_27
        :pswitch_24
        :pswitch_21
        :pswitch_1e
        :pswitch_1b
        :pswitch_18
        :pswitch_15
        :pswitch_12
        :pswitch_f
        :pswitch_c
        :pswitch_9
        :pswitch_6
    .end packed-switch
.end method
