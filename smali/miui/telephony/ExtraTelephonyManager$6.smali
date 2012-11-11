.class final Lmiui/telephony/ExtraTelephonyManager$6;
.super Landroid/content/BroadcastReceiver;
.source "ExtraTelephonyManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lmiui/telephony/ExtraTelephonyManager;->waitAndGetImsi(Landroid/content/Context;)Ljava/lang/String;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$future:Lmiui/telephony/ExtraTelephonyManager$AsyncFuture;


# direct methods
.method constructor <init>(Lmiui/telephony/ExtraTelephonyManager$AsyncFuture;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Lmiui/telephony/ExtraTelephonyManager$6;->val$future:Lmiui/telephony/ExtraTelephonyManager$AsyncFuture;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .registers 6
    .parameter "context"
    .parameter "intent"

    .prologue
    const-string v1, "IMSI"

    const-string/jumbo v2, "ss"

    invoke-virtual {p2, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_21

    const-string/jumbo v1, "phone"

    invoke-virtual {p1, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/telephony/TelephonyManager;

    .local v0, tm:Landroid/telephony/TelephonyManager;
    iget-object v1, p0, Lmiui/telephony/ExtraTelephonyManager$6;->val$future:Lmiui/telephony/ExtraTelephonyManager$AsyncFuture;

    invoke-virtual {v0}, Landroid/telephony/TelephonyManager;->getSubscriberId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lmiui/telephony/ExtraTelephonyManager$AsyncFuture;->setResult(Ljava/lang/Object;)V

    .end local v0           #tm:Landroid/telephony/TelephonyManager;
    :cond_21
    return-void
.end method
