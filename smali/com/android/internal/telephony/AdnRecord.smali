.class public Lcom/android/internal/telephony/AdnRecord;
.super Ljava/lang/Object;
.source "AdnRecord.java"

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/internal/telephony/AdnRecord$Injector;
    }
.end annotation


# static fields
.field static final ADN_BCD_NUMBER_LENGTH:I = 0x0

.field static final ADN_CAPABILITY_ID:I = 0xc

.field static final ADN_DIALING_NUMBER_END:I = 0xb

.field static final ADN_DIALING_NUMBER_START:I = 0x2

.field static final ADN_EXTENSION_ID:I = 0xd

.field static final ADN_TON_AND_NPI:I = 0x1

.field public static final CREATOR:Landroid/os/Parcelable$Creator; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/android/internal/telephony/AdnRecord;",
            ">;"
        }
    .end annotation
.end field

.field static final EXT_RECORD_LENGTH_BYTES:I = 0xd

.field static final EXT_RECORD_TYPE_ADDITIONAL_DATA:I = 0x2

.field static final EXT_RECORD_TYPE_MASK:I = 0x3

.field static final FOOTER_SIZE_BYTES:I = 0xe

.field static final LOG_TAG:Ljava/lang/String; = "GSM"

.field static final MAX_EXT_CALLED_PARTY_LENGTH:I = 0xa

.field static final MAX_NUMBER_SIZE_BYTES:I = 0xff


# instance fields
.field alphaTag:Ljava/lang/String;

.field efid:I

.field emails:[Ljava/lang/String;

.field extRecord:I

.field number:Ljava/lang/String;

.field recordNumber:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    new-instance v0, Lcom/android/internal/telephony/AdnRecord$1;

    invoke-direct {v0}, Lcom/android/internal/telephony/AdnRecord$1;-><init>()V

    sput-object v0, Lcom/android/internal/telephony/AdnRecord;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(IILjava/lang/String;Ljava/lang/String;)V
    .registers 7
    .parameter "efid"
    .parameter "recordNumber"
    .parameter "alphaTag"
    .parameter "number"

    .prologue
    const/4 v1, 0x0

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object v1, p0, Lcom/android/internal/telephony/AdnRecord;->alphaTag:Ljava/lang/String;

    iput-object v1, p0, Lcom/android/internal/telephony/AdnRecord;->number:Ljava/lang/String;

    const/16 v0, 0xff

    iput v0, p0, Lcom/android/internal/telephony/AdnRecord;->extRecord:I

    iput p1, p0, Lcom/android/internal/telephony/AdnRecord;->efid:I

    iput p2, p0, Lcom/android/internal/telephony/AdnRecord;->recordNumber:I

    iput-object p3, p0, Lcom/android/internal/telephony/AdnRecord;->alphaTag:Ljava/lang/String;

    iput-object p4, p0, Lcom/android/internal/telephony/AdnRecord;->number:Ljava/lang/String;

    iput-object v1, p0, Lcom/android/internal/telephony/AdnRecord;->emails:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(IILjava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    .registers 7
    .parameter "efid"
    .parameter "recordNumber"
    .parameter "alphaTag"
    .parameter "number"
    .parameter "emails"

    .prologue
    const/4 v0, 0x0

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/android/internal/telephony/AdnRecord;->alphaTag:Ljava/lang/String;

    iput-object v0, p0, Lcom/android/internal/telephony/AdnRecord;->number:Ljava/lang/String;

    const/16 v0, 0xff

    iput v0, p0, Lcom/android/internal/telephony/AdnRecord;->extRecord:I

    iput p1, p0, Lcom/android/internal/telephony/AdnRecord;->efid:I

    iput p2, p0, Lcom/android/internal/telephony/AdnRecord;->recordNumber:I

    iput-object p3, p0, Lcom/android/internal/telephony/AdnRecord;->alphaTag:Ljava/lang/String;

    iput-object p4, p0, Lcom/android/internal/telephony/AdnRecord;->number:Ljava/lang/String;

    iput-object p5, p0, Lcom/android/internal/telephony/AdnRecord;->emails:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(II[B)V
    .registers 5
    .parameter "efid"
    .parameter "recordNumber"
    .parameter "record"

    .prologue
    const/4 v0, 0x0

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/android/internal/telephony/AdnRecord;->alphaTag:Ljava/lang/String;

    iput-object v0, p0, Lcom/android/internal/telephony/AdnRecord;->number:Ljava/lang/String;

    const/16 v0, 0xff

    iput v0, p0, Lcom/android/internal/telephony/AdnRecord;->extRecord:I

    iput p1, p0, Lcom/android/internal/telephony/AdnRecord;->efid:I

    iput p2, p0, Lcom/android/internal/telephony/AdnRecord;->recordNumber:I

    invoke-direct {p0, p3}, Lcom/android/internal/telephony/AdnRecord;->parseRecord([B)V

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .registers 4
    .parameter "alphaTag"
    .parameter "number"

    .prologue
    const/4 v0, 0x0

    invoke-direct {p0, v0, v0, p1, p2}, Lcom/android/internal/telephony/AdnRecord;-><init>(IILjava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    .registers 10
    .parameter "alphaTag"
    .parameter "number"
    .parameter "emails"

    .prologue
    const/4 v1, 0x0

    move-object v0, p0

    move v2, v1

    move-object v3, p1

    move-object v4, p2

    move-object v5, p3

    invoke-direct/range {v0 .. v5}, Lcom/android/internal/telephony/AdnRecord;-><init>(IILjava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V

    return-void
.end method

.method public constructor <init>([B)V
    .registers 3
    .parameter "record"

    .prologue
    const/4 v0, 0x0

    invoke-direct {p0, v0, v0, p1}, Lcom/android/internal/telephony/AdnRecord;-><init>(II[B)V

    return-void
.end method

.method private parseRecord([B)V
    .registers 8
    .parameter "record"
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->CHANGE_CODE:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation

    .prologue
    const/4 v5, 0x0

    const/4 v3, 0x0

    :try_start_2
    array-length v4, p1

    add-int/lit8 v4, v4, -0xe

    invoke-static {p1, v3, v4}, Lcom/android/internal/telephony/IccUtils;->adnStringFieldToString([BII)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/android/internal/telephony/AdnRecord;->alphaTag:Ljava/lang/String;

    array-length v3, p1

    add-int/lit8 v1, v3, -0xe

    .local v1, footerOffset:I
    aget-byte v3, p1, v1

    and-int/lit16 v2, v3, 0xff

    .local v2, numberLength:I
    const/16 v3, 0xff

    if-le v2, v3, :cond_1b

    const-string v3, ""

    iput-object v3, p0, Lcom/android/internal/telephony/AdnRecord;->number:Ljava/lang/String;

    .end local v1           #footerOffset:I
    .end local v2           #numberLength:I
    :goto_1a
    return-void

    .restart local v1       #footerOffset:I
    .restart local v2       #numberLength:I
    :cond_1b
    add-int/lit8 v3, v1, 0x1

    invoke-static {p1, v3, v2}, Landroid/telephony/PhoneNumberUtils;->calledPartyBCDToString([BII)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/android/internal/telephony/AdnRecord;->number:Ljava/lang/String;

    array-length v3, p1

    add-int/lit8 v3, v3, -0x1

    aget-byte v3, p1, v3

    and-int/lit16 v3, v3, 0xff

    iput v3, p0, Lcom/android/internal/telephony/AdnRecord;->extRecord:I

    const/4 v3, 0x0

    iput-object v3, p0, Lcom/android/internal/telephony/AdnRecord;->emails:[Ljava/lang/String;
    :try_end_2f
    .catch Ljava/lang/RuntimeException; {:try_start_2 .. :try_end_2f} :catch_30

    goto :goto_1a

    .end local v1           #footerOffset:I
    .end local v2           #numberLength:I
    :catch_30
    move-exception v0

    .local v0, ex:Ljava/lang/RuntimeException;
    const-string v3, "GSM"

    const-string v4, "Error parsing AdnRecord"

    invoke-static {p0, v4}, Lcom/android/internal/telephony/AdnRecord$Injector;->adnRecordError(Lcom/android/internal/telephony/AdnRecord;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    const-string v3, ""

    iput-object v3, p0, Lcom/android/internal/telephony/AdnRecord;->number:Ljava/lang/String;

    const-string v3, ""

    iput-object v3, p0, Lcom/android/internal/telephony/AdnRecord;->alphaTag:Ljava/lang/String;

    iput-object v5, p0, Lcom/android/internal/telephony/AdnRecord;->emails:[Ljava/lang/String;

    goto :goto_1a
.end method

.method private static stringCompareNullEqualsEmpty(Ljava/lang/String;Ljava/lang/String;)Z
    .registers 3
    .parameter "s1"
    .parameter "s2"

    .prologue
    if-ne p0, p1, :cond_4

    const/4 v0, 0x1

    :goto_3
    return v0

    :cond_4
    if-nez p0, :cond_8

    const-string p0, ""

    :cond_8
    if-nez p1, :cond_c

    const-string p1, ""

    :cond_c
    invoke-virtual {p0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_3
.end method


# virtual methods
.method public appendExtRecord([B)V
    .registers 6
    .parameter "extRecord"

    .prologue
    const/4 v3, 0x2

    :try_start_1
    array-length v1, p1

    const/16 v2, 0xd

    if-eq v1, v2, :cond_7

    :cond_6
    :goto_6
    return-void

    :cond_7
    const/4 v1, 0x0

    aget-byte v1, p1, v1

    and-int/lit8 v1, v1, 0x3

    if-ne v1, v3, :cond_6

    const/4 v1, 0x1

    aget-byte v1, p1, v1

    and-int/lit16 v1, v1, 0xff

    const/16 v2, 0xa

    if-gt v1, v2, :cond_6

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/android/internal/telephony/AdnRecord;->number:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/4 v2, 0x2

    const/4 v3, 0x1

    aget-byte v3, p1, v3

    and-int/lit16 v3, v3, 0xff

    invoke-static {p1, v2, v3}, Landroid/telephony/PhoneNumberUtils;->calledPartyBCDFragmentToString([BII)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/android/internal/telephony/AdnRecord;->number:Ljava/lang/String;
    :try_end_36
    .catch Ljava/lang/RuntimeException; {:try_start_1 .. :try_end_36} :catch_37

    goto :goto_6

    :catch_37
    move-exception v0

    .local v0, ex:Ljava/lang/RuntimeException;
    const-string v1, "GSM"

    const-string v2, "Error parsing AdnRecord ext record"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_6
.end method

.method public buildAdnString(I)[B
    .registers 12
    .parameter "recordSize"
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->CHANGE_CODE:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation

    .prologue
    const/4 v5, 0x0

    const/4 v9, 0x0

    const/4 v8, -0x1

    add-int/lit8 v3, p1, -0xe

    .local v3, footerOffset:I
    new-array v0, p1, [B

    .local v0, adnString:[B
    const/4 v4, 0x0

    .local v4, i:I
    :goto_8
    if-ge v4, p1, :cond_f

    aput-byte v8, v0, v4

    add-int/lit8 v4, v4, 0x1

    goto :goto_8

    :cond_f
    iget-object v6, p0, Lcom/android/internal/telephony/AdnRecord;->number:Ljava/lang/String;

    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_1f

    const-string v5, "GSM"

    const-string v6, "[buildAdnString] Empty dialing number"

    invoke-static {v5, v6}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .end local v0           #adnString:[B
    :cond_1e
    :goto_1e
    return-object v0

    .restart local v0       #adnString:[B
    :cond_1f
    iget-object v6, p0, Lcom/android/internal/telephony/AdnRecord;->number:Ljava/lang/String;

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v6

    const/16 v7, 0x14

    if-le v6, v7, :cond_32

    const-string v6, "GSM"

    const-string v7, "[buildAdnString] Max length of dialing number is 20"

    invoke-static {v6, v7}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    move-object v0, v5

    goto :goto_1e

    :cond_32
    iget-object v6, p0, Lcom/android/internal/telephony/AdnRecord;->alphaTag:Ljava/lang/String;

    if-eqz v6, :cond_58

    iget-object v6, p0, Lcom/android/internal/telephony/AdnRecord;->alphaTag:Ljava/lang/String;

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v6

    if-le v6, v3, :cond_58

    const-string v6, "GSM"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "[buildAdnString] Max length of tag is "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    move-object v0, v5

    goto :goto_1e

    :cond_58
    iget-object v5, p0, Lcom/android/internal/telephony/AdnRecord;->number:Ljava/lang/String;

    invoke-static {v5}, Landroid/telephony/PhoneNumberUtils;->numberToCalledPartyBCD(Ljava/lang/String;)[B

    move-result-object v1

    .local v1, bcdNumber:[B
    add-int/lit8 v5, v3, 0x1

    array-length v6, v1

    invoke-static {v1, v9, v0, v5, v6}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    add-int/lit8 v5, v3, 0x0

    array-length v6, v1

    int-to-byte v6, v6

    aput-byte v6, v0, v5

    add-int/lit8 v5, v3, 0xc

    aput-byte v8, v0, v5

    add-int/lit8 v5, v3, 0xd

    aput-byte v8, v0, v5

    iget-object v5, p0, Lcom/android/internal/telephony/AdnRecord;->alphaTag:Ljava/lang/String;

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_1e

    iget-object v5, p0, Lcom/android/internal/telephony/AdnRecord;->alphaTag:Ljava/lang/String;

    invoke-static {v5}, Lcom/android/internal/telephony/GsmAlphabet;->stringToGsm8BitPacked(Ljava/lang/String;)[B

    move-result-object v2

    .local v2, byteTag:[B
    array-length v5, v2

    invoke-static {v2, v9, v0, v9, v5}, Lcom/android/internal/telephony/AdnRecord$Injector;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    iget-object v5, p0, Lcom/android/internal/telephony/AdnRecord;->alphaTag:Ljava/lang/String;

    invoke-static {v0, v5, v3}, Lcom/android/internal/telephony/MiuiAdnUtils;->encodeAlphaTag([BLjava/lang/String;I)Z

    goto :goto_1e
.end method

.method public describeContents()I
    .registers 2

    .prologue
    const/4 v0, 0x0

    return v0
.end method

.method public getAlphaTag()Ljava/lang/String;
    .registers 2

    .prologue
    iget-object v0, p0, Lcom/android/internal/telephony/AdnRecord;->alphaTag:Ljava/lang/String;

    return-object v0
.end method

.method public getEmails()[Ljava/lang/String;
    .registers 2

    .prologue
    iget-object v0, p0, Lcom/android/internal/telephony/AdnRecord;->emails:[Ljava/lang/String;

    return-object v0
.end method

.method public getNumber()Ljava/lang/String;
    .registers 2

    .prologue
    iget-object v0, p0, Lcom/android/internal/telephony/AdnRecord;->number:Ljava/lang/String;

    return-object v0
.end method

.method public hasExtendedRecord()Z
    .registers 3

    .prologue
    iget v0, p0, Lcom/android/internal/telephony/AdnRecord;->extRecord:I

    if-eqz v0, :cond_c

    iget v0, p0, Lcom/android/internal/telephony/AdnRecord;->extRecord:I

    const/16 v1, 0xff

    if-eq v0, v1, :cond_c

    const/4 v0, 0x1

    :goto_b
    return v0

    :cond_c
    const/4 v0, 0x0

    goto :goto_b
.end method

.method public isEmpty()Z
    .registers 2

    .prologue
    iget-object v0, p0, Lcom/android/internal/telephony/AdnRecord;->alphaTag:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_16

    iget-object v0, p0, Lcom/android/internal/telephony/AdnRecord;->number:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_16

    iget-object v0, p0, Lcom/android/internal/telephony/AdnRecord;->emails:[Ljava/lang/String;

    if-nez v0, :cond_16

    const/4 v0, 0x1

    :goto_15
    return v0

    :cond_16
    const/4 v0, 0x0

    goto :goto_15
.end method

.method public isEqual(Lcom/android/internal/telephony/AdnRecord;)Z
    .registers 4
    .parameter "adn"

    .prologue
    iget-object v0, p0, Lcom/android/internal/telephony/AdnRecord;->alphaTag:Ljava/lang/String;

    iget-object v1, p1, Lcom/android/internal/telephony/AdnRecord;->alphaTag:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/android/internal/telephony/AdnRecord;->stringCompareNullEqualsEmpty(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_20

    iget-object v0, p0, Lcom/android/internal/telephony/AdnRecord;->number:Ljava/lang/String;

    iget-object v1, p1, Lcom/android/internal/telephony/AdnRecord;->number:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/android/internal/telephony/AdnRecord;->stringCompareNullEqualsEmpty(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_20

    iget-object v0, p0, Lcom/android/internal/telephony/AdnRecord;->emails:[Ljava/lang/String;

    iget-object v1, p1, Lcom/android/internal/telephony/AdnRecord;->emails:[Ljava/lang/String;

    invoke-static {v0, v1}, Ljava/util/Arrays;->equals([Ljava/lang/Object;[Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_20

    const/4 v0, 0x1

    :goto_1f
    return v0

    :cond_20
    const/4 v0, 0x0

    goto :goto_1f
.end method

.method public setEmails([Ljava/lang/String;)V
    .registers 2
    .parameter "emails"

    .prologue
    iput-object p1, p0, Lcom/android/internal/telephony/AdnRecord;->emails:[Ljava/lang/String;

    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    .prologue
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "ADN Record \'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/android/internal/telephony/AdnRecord;->alphaTag:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\' \'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/android/internal/telephony/AdnRecord;->number:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/android/internal/telephony/AdnRecord;->emails:[Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 4
    .parameter "dest"
    .parameter "flags"

    .prologue
    iget v0, p0, Lcom/android/internal/telephony/AdnRecord;->efid:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p0, Lcom/android/internal/telephony/AdnRecord;->recordNumber:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget-object v0, p0, Lcom/android/internal/telephony/AdnRecord;->alphaTag:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/android/internal/telephony/AdnRecord;->number:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/android/internal/telephony/AdnRecord;->emails:[Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeStringArray([Ljava/lang/String;)V

    return-void
.end method
