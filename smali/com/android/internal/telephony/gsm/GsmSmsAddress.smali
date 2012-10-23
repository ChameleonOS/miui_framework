.class public Lcom/android/internal/telephony/gsm/GsmSmsAddress;
.super Lcom/android/internal/telephony/SmsAddress;
.source "GsmSmsAddress.java"


# static fields
.field static final OFFSET_ADDRESS_LENGTH:I = 0x0

.field static final OFFSET_ADDRESS_VALUE:I = 0x2

.field static final OFFSET_TOA:I = 0x1


# direct methods
.method public constructor <init>([BII)V
    .registers 12
    .parameter "data"
    .parameter "offset"
    .parameter "length"

    .prologue
    const/4 v5, 0x0

    const/4 v7, 0x1

    .line 40
    invoke-direct {p0}, Lcom/android/internal/telephony/SmsAddress;-><init>()V

    .line 41
    new-array v4, p3, [B

    iput-object v4, p0, Lcom/android/internal/telephony/SmsAddress;->origBytes:[B

    .line 42
    iget-object v4, p0, Lcom/android/internal/telephony/SmsAddress;->origBytes:[B

    invoke-static {p1, p2, v4, v5, p3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 45
    iget-object v4, p0, Lcom/android/internal/telephony/SmsAddress;->origBytes:[B

    aget-byte v4, v4, v5

    and-int/lit16 v0, v4, 0xff

    .line 47
    .local v0, addressLength:I
    iget-object v4, p0, Lcom/android/internal/telephony/SmsAddress;->origBytes:[B

    aget-byte v4, v4, v7

    and-int/lit16 v3, v4, 0xff

    .line 48
    .local v3, toa:I
    shr-int/lit8 v4, v3, 0x4

    and-int/lit8 v4, v4, 0x7

    iput v4, p0, Lcom/android/internal/telephony/SmsAddress;->ton:I

    .line 51
    and-int/lit16 v4, v3, 0x80

    const/16 v5, 0x80

    if-eq v4, v5, :cond_2e

    .line 52
    new-instance v4, Ljava/lang/RuntimeException;

    const-string v5, "Invalid TOA - high bit must be set"

    invoke-direct {v4, v5}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 55
    :cond_2e
    invoke-virtual {p0}, Lcom/android/internal/telephony/gsm/GsmSmsAddress;->isAlphanumeric()Z

    move-result v4

    if-eqz v4, :cond_42

    .line 57
    mul-int/lit8 v4, v0, 0x4

    div-int/lit8 v1, v4, 0x7

    .line 59
    .local v1, countSeptets:I
    iget-object v4, p0, Lcom/android/internal/telephony/SmsAddress;->origBytes:[B

    const/4 v5, 0x2

    invoke-static {v4, v5, v1}, Lcom/android/internal/telephony/GsmAlphabet;->gsm7BitPackedToString([BII)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/android/internal/telephony/SmsAddress;->address:Ljava/lang/String;

    .line 78
    .end local v1           #countSeptets:I
    :goto_41
    return-void

    .line 66
    :cond_42
    iget-object v4, p0, Lcom/android/internal/telephony/SmsAddress;->origBytes:[B

    add-int/lit8 v5, p3, -0x1

    aget-byte v2, v4, v5

    .line 68
    .local v2, lastByte:B
    and-int/lit8 v4, v0, 0x1

    if-ne v4, v7, :cond_57

    .line 70
    iget-object v4, p0, Lcom/android/internal/telephony/SmsAddress;->origBytes:[B

    add-int/lit8 v5, p3, -0x1

    aget-byte v6, v4, v5

    or-int/lit16 v6, v6, 0xf0

    int-to-byte v6, v6

    aput-byte v6, v4, v5

    .line 72
    :cond_57
    iget-object v4, p0, Lcom/android/internal/telephony/SmsAddress;->origBytes:[B

    add-int/lit8 v5, p3, -0x1

    invoke-static {v4, v7, v5}, Landroid/telephony/PhoneNumberUtils;->calledPartyBCDToString([BII)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/android/internal/telephony/SmsAddress;->address:Ljava/lang/String;

    .line 76
    iget-object v4, p0, Lcom/android/internal/telephony/SmsAddress;->origBytes:[B

    add-int/lit8 v5, p3, -0x1

    aput-byte v2, v4, v5

    goto :goto_41
.end method


# virtual methods
.method public getAddressString()Ljava/lang/String;
    .registers 2

    .prologue
    .line 81
    iget-object v0, p0, Lcom/android/internal/telephony/SmsAddress;->address:Ljava/lang/String;

    return-object v0
.end method

.method public isAlphanumeric()Z
    .registers 3

    .prologue
    .line 88
    iget v0, p0, Lcom/android/internal/telephony/SmsAddress;->ton:I

    const/4 v1, 0x5

    if-ne v0, v1, :cond_7

    const/4 v0, 0x1

    :goto_6
    return v0

    :cond_7
    const/4 v0, 0x0

    goto :goto_6
.end method

.method public isCphsVoiceMessageClear()Z
    .registers 3

    .prologue
    .line 144
    invoke-virtual {p0}, Lcom/android/internal/telephony/gsm/GsmSmsAddress;->isCphsVoiceMessageIndicatorAddress()Z

    move-result v0

    if-eqz v0, :cond_13

    iget-object v0, p0, Lcom/android/internal/telephony/SmsAddress;->origBytes:[B

    const/4 v1, 0x2

    aget-byte v0, v0, v1

    and-int/lit16 v0, v0, 0xff

    const/16 v1, 0x10

    if-ne v0, v1, :cond_13

    const/4 v0, 0x1

    :goto_12
    return v0

    :cond_13
    const/4 v0, 0x0

    goto :goto_12
.end method

.method public isCphsVoiceMessageIndicatorAddress()Z
    .registers 5

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 121
    iget-object v2, p0, Lcom/android/internal/telephony/SmsAddress;->origBytes:[B

    aget-byte v2, v2, v1

    and-int/lit16 v2, v2, 0xff

    const/4 v3, 0x4

    if-ne v2, v3, :cond_1a

    invoke-virtual {p0}, Lcom/android/internal/telephony/gsm/GsmSmsAddress;->isAlphanumeric()Z

    move-result v2

    if-eqz v2, :cond_1a

    iget-object v2, p0, Lcom/android/internal/telephony/SmsAddress;->origBytes:[B

    aget-byte v2, v2, v0

    and-int/lit8 v2, v2, 0xf

    if-nez v2, :cond_1a

    :goto_19
    return v0

    :cond_1a
    move v0, v1

    goto :goto_19
.end method

.method public isCphsVoiceMessageSet()Z
    .registers 3

    .prologue
    .line 132
    invoke-virtual {p0}, Lcom/android/internal/telephony/gsm/GsmSmsAddress;->isCphsVoiceMessageIndicatorAddress()Z

    move-result v0

    if-eqz v0, :cond_13

    iget-object v0, p0, Lcom/android/internal/telephony/SmsAddress;->origBytes:[B

    const/4 v1, 0x2

    aget-byte v0, v0, v1

    and-int/lit16 v0, v0, 0xff

    const/16 v1, 0x11

    if-ne v0, v1, :cond_13

    const/4 v0, 0x1

    :goto_12
    return v0

    :cond_13
    const/4 v0, 0x0

    goto :goto_12
.end method

.method public isNetworkSpecific()Z
    .registers 3

    .prologue
    .line 92
    iget v0, p0, Lcom/android/internal/telephony/SmsAddress;->ton:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_7

    const/4 v0, 0x1

    :goto_6
    return v0

    :cond_7
    const/4 v0, 0x0

    goto :goto_6
.end method
