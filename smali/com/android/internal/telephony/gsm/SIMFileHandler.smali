.class public final Lcom/android/internal/telephony/gsm/SIMFileHandler;
.super Lcom/android/internal/telephony/IccFileHandler;
.source "SIMFileHandler.java"

# interfaces
.implements Lcom/android/internal/telephony/IccConstants;


# static fields
.field static final LOG_TAG:Ljava/lang/String; = "GSM"


# direct methods
.method public constructor <init>(Lcom/android/internal/telephony/IccCard;Ljava/lang/String;Lcom/android/internal/telephony/CommandsInterface;)V
    .registers 4
    .parameter "card"
    .parameter "aid"
    .parameter "ci"

    .prologue
    .line 40
    invoke-direct {p0, p1, p2, p3}, Lcom/android/internal/telephony/IccFileHandler;-><init>(Lcom/android/internal/telephony/IccCard;Ljava/lang/String;Lcom/android/internal/telephony/CommandsInterface;)V

    .line 41
    return-void
.end method


# virtual methods
.method protected finalize()V
    .registers 3

    .prologue
    .line 44
    const-string v0, "GSM"

    const-string v1, "SIMFileHandler finalized"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 45
    return-void
.end method

.method protected getEFPath(I)Ljava/lang/String;
    .registers 5
    .parameter "efid"

    .prologue
    .line 57
    sparse-switch p1, :sswitch_data_2e

    .line 86
    invoke-virtual {p0, p1}, Lcom/android/internal/telephony/gsm/SIMFileHandler;->getCommonIccEFPath(I)Ljava/lang/String;

    move-result-object v0

    .line 87
    .local v0, path:Ljava/lang/String;
    if-nez v0, :cond_19

    .line 91
    iget-object v1, p0, Lcom/android/internal/telephony/IccFileHandler;->mParentCard:Lcom/android/internal/telephony/IccCard;

    if-eqz v1, :cond_26

    iget-object v1, p0, Lcom/android/internal/telephony/IccFileHandler;->mParentCard:Lcom/android/internal/telephony/IccCard;

    sget-object v2, Lcom/android/internal/telephony/IccCardApplication$AppType;->APPTYPE_USIM:Lcom/android/internal/telephony/IccCardApplication$AppType;

    invoke-virtual {v1, v2}, Lcom/android/internal/telephony/IccCard;->isApplicationOnIcc(Lcom/android/internal/telephony/IccCardApplication$AppType;)Z

    move-result v1

    if-eqz v1, :cond_26

    .line 93
    const-string v0, "3F007F105F3A"

    .line 97
    .end local v0           #path:Ljava/lang/String;
    :cond_19
    :goto_19
    return-object v0

    .line 59
    :sswitch_1a
    const-string v0, "3F007F10"

    goto :goto_19

    .line 71
    :sswitch_1d
    const-string v0, "3F007F20"

    goto :goto_19

    .line 80
    :sswitch_20
    const-string v0, "3F007F20"

    goto :goto_19

    .line 84
    :sswitch_23
    const-string v0, "3F007F105F3A"

    goto :goto_19

    .line 95
    .restart local v0       #path:Ljava/lang/String;
    :cond_26
    const-string v1, "GSM"

    const-string v2, "Error: EF Path being returned in null"

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_19

    .line 57
    :sswitch_data_2e
    .sparse-switch
        0x4f30 -> :sswitch_23
        0x6f11 -> :sswitch_20
        0x6f13 -> :sswitch_20
        0x6f14 -> :sswitch_20
        0x6f15 -> :sswitch_20
        0x6f16 -> :sswitch_20
        0x6f17 -> :sswitch_20
        0x6f18 -> :sswitch_20
        0x6f38 -> :sswitch_1d
        0x6f3c -> :sswitch_1a
        0x6f46 -> :sswitch_1d
        0x6fad -> :sswitch_1d
        0x6fc5 -> :sswitch_1d
        0x6fc7 -> :sswitch_1d
        0x6fc8 -> :sswitch_1d
        0x6fc9 -> :sswitch_1d
        0x6fca -> :sswitch_1d
        0x6fcb -> :sswitch_1d
        0x6fcd -> :sswitch_1d
    .end sparse-switch
.end method

.method public handleMessage(Landroid/os/Message;)V
    .registers 2
    .parameter "msg"

    .prologue
    .line 51
    invoke-super {p0, p1}, Lcom/android/internal/telephony/IccFileHandler;->handleMessage(Landroid/os/Message;)V

    .line 52
    return-void
.end method

.method protected logd(Ljava/lang/String;)V
    .registers 5
    .parameter "msg"

    .prologue
    .line 101
    const-string v0, "GSM"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "[SIMFileHandler] "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 102
    return-void
.end method

.method protected loge(Ljava/lang/String;)V
    .registers 5
    .parameter "msg"

    .prologue
    .line 105
    const-string v0, "GSM"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "[SIMFileHandler] "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 106
    return-void
.end method
