.class public Lcom/android/internal/telephony/gsm/SmsMessage$SubmitPdu;
.super Lcom/android/internal/telephony/SmsMessageBase$SubmitPduBase;
.source "SmsMessage.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/telephony/gsm/SmsMessage;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SubmitPdu"
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 94
    invoke-direct {p0}, Lcom/android/internal/telephony/SmsMessageBase$SubmitPduBase;-><init>()V

    return-void
.end method
