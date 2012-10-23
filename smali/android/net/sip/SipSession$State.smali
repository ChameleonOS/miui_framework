.class public Landroid/net/sip/SipSession$State;
.super Ljava/lang/Object;
.source "SipSession.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/sip/SipSession;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "State"
.end annotation


# static fields
.field public static final DEREGISTERING:I = 0x2

.field public static final ENDING_CALL:I = 0xa

.field public static final INCOMING_CALL:I = 0x3

.field public static final INCOMING_CALL_ANSWERING:I = 0x4

.field public static final IN_CALL:I = 0x8

.field public static final NOT_DEFINED:I = 0x65

.field public static final OUTGOING_CALL:I = 0x5

.field public static final OUTGOING_CALL_CANCELING:I = 0x7

.field public static final OUTGOING_CALL_RING_BACK:I = 0x6

.field public static final PINGING:I = 0x9

.field public static final READY_TO_CALL:I = 0x0

.field public static final REGISTERING:I = 0x1


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    .line 102
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 103
    return-void
.end method

.method public static toString(I)Ljava/lang/String;
    .registers 2
    .parameter "state"

    .prologue
    .line 76
    packed-switch p0, :pswitch_data_24

    .line 98
    const-string v0, "NOT_DEFINED"

    :goto_5
    return-object v0

    .line 78
    :pswitch_6
    const-string v0, "READY_TO_CALL"

    goto :goto_5

    .line 80
    :pswitch_9
    const-string v0, "REGISTERING"

    goto :goto_5

    .line 82
    :pswitch_c
    const-string v0, "DEREGISTERING"

    goto :goto_5

    .line 84
    :pswitch_f
    const-string v0, "INCOMING_CALL"

    goto :goto_5

    .line 86
    :pswitch_12
    const-string v0, "INCOMING_CALL_ANSWERING"

    goto :goto_5

    .line 88
    :pswitch_15
    const-string v0, "OUTGOING_CALL"

    goto :goto_5

    .line 90
    :pswitch_18
    const-string v0, "OUTGOING_CALL_RING_BACK"

    goto :goto_5

    .line 92
    :pswitch_1b
    const-string v0, "OUTGOING_CALL_CANCELING"

    goto :goto_5

    .line 94
    :pswitch_1e
    const-string v0, "IN_CALL"

    goto :goto_5

    .line 96
    :pswitch_21
    const-string v0, "PINGING"

    goto :goto_5

    .line 76
    :pswitch_data_24
    .packed-switch 0x0
        :pswitch_6
        :pswitch_9
        :pswitch_c
        :pswitch_f
        :pswitch_12
        :pswitch_15
        :pswitch_18
        :pswitch_1b
        :pswitch_1e
        :pswitch_21
    .end packed-switch
.end method
