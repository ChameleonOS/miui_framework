.class public Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse$Status;
.super Ljava/lang/Object;
.source "WifiP2pServiceResponse.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/wifi/p2p/nsd/WifiP2pServiceResponse;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Status"
.end annotation


# static fields
.field public static final BAD_REQUEST:I = 0x3

.field public static final REQUESTED_INFORMATION_NOT_AVAILABLE:I = 0x2

.field public static final SERVICE_PROTOCOL_NOT_AVAILABLE:I = 0x1

.field public static final SUCCESS:I


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static toString(I)Ljava/lang/String;
    .registers 2
    .parameter "status"

    .prologue
    packed-switch p0, :pswitch_data_12

    const-string v0, "UNKNOWN"

    :goto_5
    return-object v0

    :pswitch_6
    const-string v0, "SUCCESS"

    goto :goto_5

    :pswitch_9
    const-string v0, "SERVICE_PROTOCOL_NOT_AVAILABLE"

    goto :goto_5

    :pswitch_c
    const-string v0, "REQUESTED_INFORMATION_NOT_AVAILABLE"

    goto :goto_5

    :pswitch_f
    const-string v0, "BAD_REQUEST"

    goto :goto_5

    :pswitch_data_12
    .packed-switch 0x0
        :pswitch_6
        :pswitch_9
        :pswitch_c
        :pswitch_f
    .end packed-switch
.end method
