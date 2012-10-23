.class public Landroid/net/wifi/StateChangeResult;
.super Ljava/lang/Object;
.source "StateChangeResult.java"


# instance fields
.field BSSID:Ljava/lang/String;

.field SSID:Ljava/lang/String;

.field networkId:I

.field state:Landroid/net/wifi/SupplicantState;


# direct methods
.method constructor <init>(ILjava/lang/String;Ljava/lang/String;Landroid/net/wifi/SupplicantState;)V
    .registers 5
    .parameter "networkId"
    .parameter "SSID"
    .parameter "BSSID"
    .parameter "state"

    .prologue
    .line 26
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 27
    iput-object p4, p0, Landroid/net/wifi/StateChangeResult;->state:Landroid/net/wifi/SupplicantState;

    .line 28
    iput-object p2, p0, Landroid/net/wifi/StateChangeResult;->SSID:Ljava/lang/String;

    .line 29
    iput-object p3, p0, Landroid/net/wifi/StateChangeResult;->BSSID:Ljava/lang/String;

    .line 30
    iput p1, p0, Landroid/net/wifi/StateChangeResult;->networkId:I

    .line 31
    return-void
.end method
