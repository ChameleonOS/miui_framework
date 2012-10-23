.class Lcom/android/internal/telephony/SMSDispatcher$1;
.super Landroid/content/BroadcastReceiver;
.source "SMSDispatcher.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/telephony/SMSDispatcher;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/internal/telephony/SMSDispatcher;


# direct methods
.method constructor <init>(Lcom/android/internal/telephony/SMSDispatcher;)V
    .registers 2
    .parameter

    .prologue
    .line 1143
    iput-object p1, p0, Lcom/android/internal/telephony/SMSDispatcher$1;->this$0:Lcom/android/internal/telephony/SMSDispatcher;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .registers 7
    .parameter "context"
    .parameter "intent"

    .prologue
    const/4 v1, 0x1

    .line 1148
    invoke-virtual {p0}, Lcom/android/internal/telephony/SMSDispatcher$1;->getResultCode()I

    move-result v0

    .line 1149
    .local v0, rc:I
    const/4 v2, -0x1

    if-eq v0, v2, :cond_a

    if-ne v0, v1, :cond_11

    .line 1154
    .local v1, success:Z
    :cond_a
    :goto_a
    iget-object v2, p0, Lcom/android/internal/telephony/SMSDispatcher$1;->this$0:Lcom/android/internal/telephony/SMSDispatcher;

    const/4 v3, 0x0

    invoke-virtual {v2, v1, v0, v3}, Lcom/android/internal/telephony/SMSDispatcher;->acknowledgeLastIncomingSms(ZILandroid/os/Message;)V

    .line 1155
    return-void

    .line 1149
    .end local v1           #success:Z
    :cond_11
    const/4 v1, 0x0

    goto :goto_a
.end method
