.class public Lcom/android/internal/telephony/gsm/SimTlv;
.super Ljava/lang/Object;
.source "SimTlv.java"


# instance fields
.field curDataLength:I

.field curDataOffset:I

.field curOffset:I

.field hasValidTlvObject:Z

.field record:[B

.field tlvLength:I

.field tlvOffset:I


# direct methods
.method public constructor <init>([BII)V
    .registers 5
    .parameter "record"
    .parameter "offset"
    .parameter "length"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/android/internal/telephony/gsm/SimTlv;->record:[B

    iput p2, p0, Lcom/android/internal/telephony/gsm/SimTlv;->tlvOffset:I

    iput p3, p0, Lcom/android/internal/telephony/gsm/SimTlv;->tlvLength:I

    iput p2, p0, Lcom/android/internal/telephony/gsm/SimTlv;->curOffset:I

    invoke-direct {p0}, Lcom/android/internal/telephony/gsm/SimTlv;->parseCurrentTlvObject()Z

    move-result v0

    iput-boolean v0, p0, Lcom/android/internal/telephony/gsm/SimTlv;->hasValidTlvObject:Z

    return-void
.end method

.method private parseCurrentTlvObject()Z
    .registers 6

    .prologue
    const/4 v1, 0x0

    :try_start_1
    iget-object v2, p0, Lcom/android/internal/telephony/gsm/SimTlv;->record:[B

    iget v3, p0, Lcom/android/internal/telephony/gsm/SimTlv;->curOffset:I

    aget-byte v2, v2, v3

    if-eqz v2, :cond_15

    iget-object v2, p0, Lcom/android/internal/telephony/gsm/SimTlv;->record:[B

    iget v3, p0, Lcom/android/internal/telephony/gsm/SimTlv;->curOffset:I

    aget-byte v2, v2, v3

    and-int/lit16 v2, v2, 0xff

    const/16 v3, 0xff

    if-ne v2, v3, :cond_16

    :cond_15
    :goto_15
    return v1

    :cond_16
    iget-object v2, p0, Lcom/android/internal/telephony/gsm/SimTlv;->record:[B

    iget v3, p0, Lcom/android/internal/telephony/gsm/SimTlv;->curOffset:I

    add-int/lit8 v3, v3, 0x1

    aget-byte v2, v2, v3

    and-int/lit16 v2, v2, 0xff

    const/16 v3, 0x80

    if-ge v2, v3, :cond_44

    iget-object v2, p0, Lcom/android/internal/telephony/gsm/SimTlv;->record:[B

    iget v3, p0, Lcom/android/internal/telephony/gsm/SimTlv;->curOffset:I

    add-int/lit8 v3, v3, 0x1

    aget-byte v2, v2, v3

    and-int/lit16 v2, v2, 0xff

    iput v2, p0, Lcom/android/internal/telephony/gsm/SimTlv;->curDataLength:I

    iget v2, p0, Lcom/android/internal/telephony/gsm/SimTlv;->curOffset:I

    add-int/lit8 v2, v2, 0x2

    iput v2, p0, Lcom/android/internal/telephony/gsm/SimTlv;->curDataOffset:I
    :try_end_36
    .catch Ljava/lang/ArrayIndexOutOfBoundsException; {:try_start_1 .. :try_end_36} :catch_65

    :goto_36
    iget v2, p0, Lcom/android/internal/telephony/gsm/SimTlv;->curDataLength:I

    iget v3, p0, Lcom/android/internal/telephony/gsm/SimTlv;->curDataOffset:I

    add-int/2addr v2, v3

    iget v3, p0, Lcom/android/internal/telephony/gsm/SimTlv;->tlvOffset:I

    iget v4, p0, Lcom/android/internal/telephony/gsm/SimTlv;->tlvLength:I

    add-int/2addr v3, v4

    if-gt v2, v3, :cond_15

    const/4 v1, 0x1

    goto :goto_15

    :cond_44
    :try_start_44
    iget-object v2, p0, Lcom/android/internal/telephony/gsm/SimTlv;->record:[B

    iget v3, p0, Lcom/android/internal/telephony/gsm/SimTlv;->curOffset:I

    add-int/lit8 v3, v3, 0x1

    aget-byte v2, v2, v3

    and-int/lit16 v2, v2, 0xff

    const/16 v3, 0x81

    if-ne v2, v3, :cond_15

    iget-object v2, p0, Lcom/android/internal/telephony/gsm/SimTlv;->record:[B

    iget v3, p0, Lcom/android/internal/telephony/gsm/SimTlv;->curOffset:I

    add-int/lit8 v3, v3, 0x2

    aget-byte v2, v2, v3

    and-int/lit16 v2, v2, 0xff

    iput v2, p0, Lcom/android/internal/telephony/gsm/SimTlv;->curDataLength:I

    iget v2, p0, Lcom/android/internal/telephony/gsm/SimTlv;->curOffset:I

    add-int/lit8 v2, v2, 0x3

    iput v2, p0, Lcom/android/internal/telephony/gsm/SimTlv;->curDataOffset:I
    :try_end_64
    .catch Ljava/lang/ArrayIndexOutOfBoundsException; {:try_start_44 .. :try_end_64} :catch_65

    goto :goto_36

    :catch_65
    move-exception v0

    .local v0, ex:Ljava/lang/ArrayIndexOutOfBoundsException;
    goto :goto_15
.end method


# virtual methods
.method public getData()[B
    .registers 6

    .prologue
    iget-boolean v1, p0, Lcom/android/internal/telephony/gsm/SimTlv;->hasValidTlvObject:Z

    if-nez v1, :cond_6

    const/4 v0, 0x0

    :goto_5
    return-object v0

    :cond_6
    iget v1, p0, Lcom/android/internal/telephony/gsm/SimTlv;->curDataLength:I

    new-array v0, v1, [B

    .local v0, ret:[B
    iget-object v1, p0, Lcom/android/internal/telephony/gsm/SimTlv;->record:[B

    iget v2, p0, Lcom/android/internal/telephony/gsm/SimTlv;->curDataOffset:I

    const/4 v3, 0x0

    iget v4, p0, Lcom/android/internal/telephony/gsm/SimTlv;->curDataLength:I

    invoke-static {v1, v2, v0, v3, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    goto :goto_5
.end method

.method public getTag()I
    .registers 3

    .prologue
    iget-boolean v0, p0, Lcom/android/internal/telephony/gsm/SimTlv;->hasValidTlvObject:Z

    if-nez v0, :cond_6

    const/4 v0, 0x0

    :goto_5
    return v0

    :cond_6
    iget-object v0, p0, Lcom/android/internal/telephony/gsm/SimTlv;->record:[B

    iget v1, p0, Lcom/android/internal/telephony/gsm/SimTlv;->curOffset:I

    aget-byte v0, v0, v1

    and-int/lit16 v0, v0, 0xff

    goto :goto_5
.end method

.method public isValidObject()Z
    .registers 2

    .prologue
    iget-boolean v0, p0, Lcom/android/internal/telephony/gsm/SimTlv;->hasValidTlvObject:Z

    return v0
.end method

.method public nextObject()Z
    .registers 3

    .prologue
    iget-boolean v0, p0, Lcom/android/internal/telephony/gsm/SimTlv;->hasValidTlvObject:Z

    if-nez v0, :cond_6

    const/4 v0, 0x0

    :goto_5
    return v0

    :cond_6
    iget v0, p0, Lcom/android/internal/telephony/gsm/SimTlv;->curDataOffset:I

    iget v1, p0, Lcom/android/internal/telephony/gsm/SimTlv;->curDataLength:I

    add-int/2addr v0, v1

    iput v0, p0, Lcom/android/internal/telephony/gsm/SimTlv;->curOffset:I

    invoke-direct {p0}, Lcom/android/internal/telephony/gsm/SimTlv;->parseCurrentTlvObject()Z

    move-result v0

    iput-boolean v0, p0, Lcom/android/internal/telephony/gsm/SimTlv;->hasValidTlvObject:Z

    iget-boolean v0, p0, Lcom/android/internal/telephony/gsm/SimTlv;->hasValidTlvObject:Z

    goto :goto_5
.end method
