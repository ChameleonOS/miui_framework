.class public final Lcom/android/internal/telephony/cdma/CdmaLteUiccFileHandler;
.super Lcom/android/internal/telephony/IccFileHandler;
.source "CdmaLteUiccFileHandler.java"


# static fields
.field static final LOG_TAG:Ljava/lang/String; = "CDMA"


# direct methods
.method public constructor <init>(Lcom/android/internal/telephony/IccCard;Ljava/lang/String;Lcom/android/internal/telephony/CommandsInterface;)V
    .registers 4
    .parameter "card"
    .parameter "aid"
    .parameter "ci"

    .prologue
    .line 34
    invoke-direct {p0, p1, p2, p3}, Lcom/android/internal/telephony/IccFileHandler;-><init>(Lcom/android/internal/telephony/IccCard;Ljava/lang/String;Lcom/android/internal/telephony/CommandsInterface;)V

    .line 35
    return-void
.end method


# virtual methods
.method protected getEFPath(I)Ljava/lang/String;
    .registers 3
    .parameter "efid"

    .prologue
    .line 38
    sparse-switch p1, :sswitch_data_12

    .line 53
    invoke-virtual {p0, p1}, Lcom/android/internal/telephony/cdma/CdmaLteUiccFileHandler;->getCommonIccEFPath(I)Ljava/lang/String;

    move-result-object v0

    :goto_7
    return-object v0

    .line 45
    :sswitch_8
    const-string v0, "3F007F25"

    goto :goto_7

    .line 47
    :sswitch_b
    const-string v0, "3F007F20"

    goto :goto_7

    .line 51
    :sswitch_e
    const-string v0, "3F007FFF"

    goto :goto_7

    .line 38
    nop

    :sswitch_data_12
    .sparse-switch
        0x6f02 -> :sswitch_e
        0x6f03 -> :sswitch_e
        0x6f04 -> :sswitch_e
        0x6f22 -> :sswitch_8
        0x6f28 -> :sswitch_8
        0x6f3a -> :sswitch_8
        0x6f41 -> :sswitch_8
        0x6f44 -> :sswitch_8
        0x6f5a -> :sswitch_8
        0x6fad -> :sswitch_b
    .end sparse-switch
.end method

.method public loadEFTransparent(ILandroid/os/Message;)V
    .registers 14
    .parameter "fileid"
    .parameter "onLoaded"

    .prologue
    const/4 v7, 0x0

    const/4 v4, 0x0

    .line 58
    const/16 v0, 0x6f5a

    if-ne p1, v0, :cond_1d

    .line 61
    iget-object v0, p0, Lcom/android/internal/telephony/IccFileHandler;->mCi:Lcom/android/internal/telephony/CommandsInterface;

    const/16 v1, 0xb0

    invoke-virtual {p0, p1}, Lcom/android/internal/telephony/cdma/CdmaLteUiccFileHandler;->getEFPath(I)Ljava/lang/String;

    move-result-object v3

    const/4 v6, 0x4

    iget-object v9, p0, Lcom/android/internal/telephony/IccFileHandler;->mAid:Ljava/lang/String;

    const/4 v2, 0x5

    invoke-virtual {p0, v2, p1, v4, p2}, Lcom/android/internal/telephony/cdma/CdmaLteUiccFileHandler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v10

    move v2, p1

    move v5, v4

    move-object v8, v7

    invoke-interface/range {v0 .. v10}, Lcom/android/internal/telephony/CommandsInterface;->iccIOForApp(IILjava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Message;)V

    .line 68
    :goto_1c
    return-void

    .line 66
    :cond_1d
    invoke-super {p0, p1, p2}, Lcom/android/internal/telephony/IccFileHandler;->loadEFTransparent(ILandroid/os/Message;)V

    goto :goto_1c
.end method

.method protected logd(Ljava/lang/String;)V
    .registers 5
    .parameter "msg"

    .prologue
    .line 72
    const-string v0, "CDMA"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "[CdmaLteUiccFileHandler] "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 73
    return-void
.end method

.method protected loge(Ljava/lang/String;)V
    .registers 5
    .parameter "msg"

    .prologue
    .line 76
    const-string v0, "CDMA"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "[CdmaLteUiccFileHandler] "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 77
    return-void
.end method
