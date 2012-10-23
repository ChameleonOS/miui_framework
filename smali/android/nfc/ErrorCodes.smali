.class public Landroid/nfc/ErrorCodes;
.super Ljava/lang/Object;
.source "ErrorCodes.java"


# static fields
.field public static final ERROR_BUFFER_TO_SMALL:I = -0xc

.field public static final ERROR_BUSY:I = -0x4

.field public static final ERROR_CANCELLED:I = -0x2

.field public static final ERROR_CONNECT:I = -0x5

.field public static final ERROR_DISCONNECT:I = -0x5

.field public static final ERROR_INSUFFICIENT_RESOURCES:I = -0x9

.field public static final ERROR_INVALID_PARAM:I = -0x8

.field public static final ERROR_IO:I = -0x1

.field public static final ERROR_NFC_ON:I = -0x10

.field public static final ERROR_NOT_INITIALIZED:I = -0x11

.field public static final ERROR_NOT_SUPPORTED:I = -0x15

.field public static final ERROR_NO_SE_CONNECTED:I = -0x14

.field public static final ERROR_READ:I = -0x6

.field public static final ERROR_SAP_USED:I = -0xd

.field public static final ERROR_SERVICE_NAME_USED:I = -0xe

.field public static final ERROR_SE_ALREADY_SELECTED:I = -0x12

.field public static final ERROR_SE_CONNECTED:I = -0x13

.field public static final ERROR_SOCKET_CREATION:I = -0xa

.field public static final ERROR_SOCKET_NOT_CONNECTED:I = -0xb

.field public static final ERROR_SOCKET_OPTIONS:I = -0xf

.field public static final ERROR_TIMEOUT:I = -0x3

.field public static final ERROR_WRITE:I = -0x7

.field public static final SUCCESS:I


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 26
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static asString(I)Ljava/lang/String;
    .registers 2
    .parameter "code"

    .prologue
    .line 37
    packed-switch p0, :pswitch_data_48

    .line 61
    const-string v0, "UNKNOWN ERROR"

    :goto_5
    return-object v0

    .line 38
    :pswitch_6
    const-string v0, "SUCCESS"

    goto :goto_5

    .line 39
    :pswitch_9
    const-string v0, "IO"

    goto :goto_5

    .line 40
    :pswitch_c
    const-string v0, "CANCELLED"

    goto :goto_5

    .line 41
    :pswitch_f
    const-string v0, "TIMEOUT"

    goto :goto_5

    .line 42
    :pswitch_12
    const-string v0, "BUSY"

    goto :goto_5

    .line 43
    :pswitch_15
    const-string v0, "CONNECT/DISCONNECT"

    goto :goto_5

    .line 45
    :pswitch_18
    const-string v0, "READ"

    goto :goto_5

    .line 46
    :pswitch_1b
    const-string v0, "WRITE"

    goto :goto_5

    .line 47
    :pswitch_1e
    const-string v0, "INVALID_PARAM"

    goto :goto_5

    .line 48
    :pswitch_21
    const-string v0, "INSUFFICIENT_RESOURCES"

    goto :goto_5

    .line 49
    :pswitch_24
    const-string v0, "SOCKET_CREATION"

    goto :goto_5

    .line 50
    :pswitch_27
    const-string v0, "SOCKET_NOT_CONNECTED"

    goto :goto_5

    .line 51
    :pswitch_2a
    const-string v0, "BUFFER_TO_SMALL"

    goto :goto_5

    .line 52
    :pswitch_2d
    const-string v0, "SAP_USED"

    goto :goto_5

    .line 53
    :pswitch_30
    const-string v0, "SERVICE_NAME_USED"

    goto :goto_5

    .line 54
    :pswitch_33
    const-string v0, "SOCKET_OPTIONS"

    goto :goto_5

    .line 55
    :pswitch_36
    const-string v0, "NFC_ON"

    goto :goto_5

    .line 56
    :pswitch_39
    const-string v0, "NOT_INITIALIZED"

    goto :goto_5

    .line 57
    :pswitch_3c
    const-string v0, "SE_ALREADY_SELECTED"

    goto :goto_5

    .line 58
    :pswitch_3f
    const-string v0, "SE_CONNECTED"

    goto :goto_5

    .line 59
    :pswitch_42
    const-string v0, "NO_SE_CONNECTED"

    goto :goto_5

    .line 60
    :pswitch_45
    const-string v0, "NOT_SUPPORTED"

    goto :goto_5

    .line 37
    :pswitch_data_48
    .packed-switch -0x15
        :pswitch_45
        :pswitch_42
        :pswitch_3f
        :pswitch_3c
        :pswitch_39
        :pswitch_36
        :pswitch_33
        :pswitch_30
        :pswitch_2d
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

.method public static isError(I)Z
    .registers 2
    .parameter "code"

    .prologue
    .line 29
    if-gez p0, :cond_4

    .line 30
    const/4 v0, 0x1

    .line 32
    :goto_3
    return v0

    :cond_4
    const/4 v0, 0x0

    goto :goto_3
.end method
