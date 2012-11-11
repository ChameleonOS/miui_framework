.class Lcom/android/internal/telephony/WapPushOverSms$Injector;
.super Ljava/lang/Object;
.source "WapPushOverSms.java"


# annotations
.annotation build Landroid/annotation/MiuiHook;
    value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_CLASS:Landroid/annotation/MiuiHook$MiuiHookType;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/telephony/WapPushOverSms;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Injector"
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static checkFirewallForWapPush(Lcom/android/internal/telephony/WapPushOverSms;[B)Z
    .registers 6
    .parameter "wap"
    .parameter "intentData"

    .prologue
    const/4 v0, 0x1

    invoke-virtual {p0}, Lcom/android/internal/telephony/WapPushOverSms;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1, p1}, Lmiui/provider/ExtraTelephony;->checkFirewallForWapPush(Landroid/content/Context;[B)Z

    move-result v1

    if-eqz v1, :cond_15

    invoke-virtual {p0}, Lcom/android/internal/telephony/WapPushOverSms;->getSmsDispatcher()Lcom/android/internal/telephony/SMSDispatcher;

    move-result-object v1

    const/4 v2, -0x1

    const/4 v3, 0x0

    invoke-virtual {v1, v0, v2, v3}, Lcom/android/internal/telephony/SMSDispatcher;->acknowledgeLastIncomingSms(ZILandroid/os/Message;)V

    :goto_14
    return v0

    :cond_15
    const/4 v0, 0x0

    goto :goto_14
.end method
