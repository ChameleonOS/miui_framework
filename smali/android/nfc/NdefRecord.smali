.class public final Landroid/nfc/NdefRecord;
.super Ljava/lang/Object;
.source "NdefRecord.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/nfc/NdefRecord;",
            ">;"
        }
    .end annotation
.end field

.field private static final EMPTY_BYTE_ARRAY:[B = null

.field private static final FLAG_CF:B = 0x20t

.field private static final FLAG_IL:B = 0x8t

.field private static final FLAG_MB:B = -0x80t

.field private static final FLAG_ME:B = 0x40t

.field private static final FLAG_SR:B = 0x10t

.field private static final MAX_PAYLOAD_SIZE:I = 0xa00000

.field public static final RTD_ALTERNATIVE_CARRIER:[B = null

.field public static final RTD_ANDROID_APP:[B = null

.field public static final RTD_HANDOVER_CARRIER:[B = null

.field public static final RTD_HANDOVER_REQUEST:[B = null

.field public static final RTD_HANDOVER_SELECT:[B = null

.field public static final RTD_SMART_POSTER:[B = null

.field public static final RTD_TEXT:[B = null

.field public static final RTD_URI:[B = null

.field public static final TNF_ABSOLUTE_URI:S = 0x3s

.field public static final TNF_EMPTY:S = 0x0s

.field public static final TNF_EXTERNAL_TYPE:S = 0x4s

.field public static final TNF_MIME_MEDIA:S = 0x2s

.field public static final TNF_RESERVED:S = 0x7s

.field public static final TNF_UNCHANGED:S = 0x6s

.field public static final TNF_UNKNOWN:S = 0x5s

.field public static final TNF_WELL_KNOWN:S = 0x1s

.field private static final URI_PREFIX_MAP:[Ljava/lang/String;


# instance fields
.field private final mId:[B

.field private final mPayload:[B

.field private final mTnf:S

.field private final mType:[B


# direct methods
.method static constructor <clinit>()V
    .registers 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    const/4 v2, 0x2

    .line 173
    new-array v0, v4, [B

    const/16 v1, 0x54

    aput-byte v1, v0, v3

    sput-object v0, Landroid/nfc/NdefRecord;->RTD_TEXT:[B

    .line 179
    new-array v0, v4, [B

    const/16 v1, 0x55

    aput-byte v1, v0, v3

    sput-object v0, Landroid/nfc/NdefRecord;->RTD_URI:[B

    .line 185
    new-array v0, v2, [B

    fill-array-data v0, :array_12a

    sput-object v0, Landroid/nfc/NdefRecord;->RTD_SMART_POSTER:[B

    .line 191
    new-array v0, v2, [B

    fill-array-data v0, :array_130

    sput-object v0, Landroid/nfc/NdefRecord;->RTD_ALTERNATIVE_CARRIER:[B

    .line 197
    new-array v0, v2, [B

    fill-array-data v0, :array_136

    sput-object v0, Landroid/nfc/NdefRecord;->RTD_HANDOVER_CARRIER:[B

    .line 203
    new-array v0, v2, [B

    fill-array-data v0, :array_13c

    sput-object v0, Landroid/nfc/NdefRecord;->RTD_HANDOVER_REQUEST:[B

    .line 209
    new-array v0, v2, [B

    fill-array-data v0, :array_142

    sput-object v0, Landroid/nfc/NdefRecord;->RTD_HANDOVER_SELECT:[B

    .line 223
    const-string v0, "android.com:pkg"

    invoke-virtual {v0}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    sput-object v0, Landroid/nfc/NdefRecord;->RTD_ANDROID_APP:[B

    .line 236
    const/16 v0, 0x23

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, ""

    aput-object v1, v0, v3

    const-string v1, "http://www."

    aput-object v1, v0, v4

    const-string v1, "https://www."

    aput-object v1, v0, v2

    const/4 v1, 0x3

    const-string v2, "http://"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "https://"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string/jumbo v2, "tel:"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string/jumbo v2, "mailto:"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "ftp://anonymous:anonymous@"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "ftp://ftp."

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "ftps://"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string/jumbo v2, "sftp://"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string/jumbo v2, "smb://"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string/jumbo v2, "nfs://"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string v2, "ftp://"

    aput-object v2, v0, v1

    const/16 v1, 0xe

    const-string v2, "dav://"

    aput-object v2, v0, v1

    const/16 v1, 0xf

    const-string/jumbo v2, "news:"

    aput-object v2, v0, v1

    const/16 v1, 0x10

    const-string/jumbo v2, "telnet://"

    aput-object v2, v0, v1

    const/16 v1, 0x11

    const-string v2, "imap:"

    aput-object v2, v0, v1

    const/16 v1, 0x12

    const-string/jumbo v2, "rtsp://"

    aput-object v2, v0, v1

    const/16 v1, 0x13

    const-string/jumbo v2, "urn:"

    aput-object v2, v0, v1

    const/16 v1, 0x14

    const-string/jumbo v2, "pop:"

    aput-object v2, v0, v1

    const/16 v1, 0x15

    const-string/jumbo v2, "sip:"

    aput-object v2, v0, v1

    const/16 v1, 0x16

    const-string/jumbo v2, "sips:"

    aput-object v2, v0, v1

    const/16 v1, 0x17

    const-string/jumbo v2, "tftp:"

    aput-object v2, v0, v1

    const/16 v1, 0x18

    const-string v2, "btspp://"

    aput-object v2, v0, v1

    const/16 v1, 0x19

    const-string v2, "btl2cap://"

    aput-object v2, v0, v1

    const/16 v1, 0x1a

    const-string v2, "btgoep://"

    aput-object v2, v0, v1

    const/16 v1, 0x1b

    const-string/jumbo v2, "tcpobex://"

    aput-object v2, v0, v1

    const/16 v1, 0x1c

    const-string v2, "irdaobex://"

    aput-object v2, v0, v1

    const/16 v1, 0x1d

    const-string v2, "file://"

    aput-object v2, v0, v1

    const/16 v1, 0x1e

    const-string/jumbo v2, "urn:epc:id:"

    aput-object v2, v0, v1

    const/16 v1, 0x1f

    const-string/jumbo v2, "urn:epc:tag:"

    aput-object v2, v0, v1

    const/16 v1, 0x20

    const-string/jumbo v2, "urn:epc:pat:"

    aput-object v2, v0, v1

    const/16 v1, 0x21

    const-string/jumbo v2, "urn:epc:raw:"

    aput-object v2, v0, v1

    const/16 v1, 0x22

    const-string/jumbo v2, "urn:epc:"

    aput-object v2, v0, v1

    sput-object v0, Landroid/nfc/NdefRecord;->URI_PREFIX_MAP:[Ljava/lang/String;

    .line 276
    new-array v0, v3, [B

    sput-object v0, Landroid/nfc/NdefRecord;->EMPTY_BYTE_ARRAY:[B

    .line 948
    new-instance v0, Landroid/nfc/NdefRecord$1;

    invoke-direct {v0}, Landroid/nfc/NdefRecord$1;-><init>()V

    sput-object v0, Landroid/nfc/NdefRecord;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void

    .line 185
    :array_12a
    .array-data 0x1
        0x53t
        0x70t
    .end array-data

    .line 191
    nop

    :array_130
    .array-data 0x1
        0x61t
        0x63t
    .end array-data

    .line 197
    nop

    :array_136
    .array-data 0x1
        0x48t
        0x63t
    .end array-data

    .line 203
    nop

    :array_13c
    .array-data 0x1
        0x48t
        0x72t
    .end array-data

    .line 209
    nop

    :array_142
    .array-data 0x1
        0x48t
        0x73t
    .end array-data
.end method

.method public constructor <init>(S[B[B[B)V
    .registers 7
    .parameter "tnf"
    .parameter "type"
    .parameter "id"
    .parameter "payload"

    .prologue
    .line 515
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 517
    if-nez p2, :cond_7

    sget-object p2, Landroid/nfc/NdefRecord;->EMPTY_BYTE_ARRAY:[B

    .line 518
    :cond_7
    if-nez p3, :cond_b

    sget-object p3, Landroid/nfc/NdefRecord;->EMPTY_BYTE_ARRAY:[B

    .line 519
    :cond_b
    if-nez p4, :cond_f

    sget-object p4, Landroid/nfc/NdefRecord;->EMPTY_BYTE_ARRAY:[B

    .line 521
    :cond_f
    invoke-static {p1, p2, p3, p4}, Landroid/nfc/NdefRecord;->validateTnf(S[B[B[B)Ljava/lang/String;

    move-result-object v0

    .line 522
    .local v0, message:Ljava/lang/String;
    if-eqz v0, :cond_1b

    .line 523
    new-instance v1, Ljava/lang/IllegalArgumentException;

    invoke-direct {v1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 526
    :cond_1b
    iput-short p1, p0, Landroid/nfc/NdefRecord;->mTnf:S

    .line 527
    iput-object p2, p0, Landroid/nfc/NdefRecord;->mType:[B

    .line 528
    iput-object p3, p0, Landroid/nfc/NdefRecord;->mId:[B

    .line 529
    iput-object p4, p0, Landroid/nfc/NdefRecord;->mPayload:[B

    .line 530
    return-void
.end method

.method public constructor <init>([B)V
    .registers 6
    .parameter "data"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/nfc/FormatException;
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 548
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 549
    invoke-static {p1}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object v0

    .line 550
    .local v0, buffer:Ljava/nio/ByteBuffer;
    const/4 v2, 0x1

    invoke-static {v0, v2}, Landroid/nfc/NdefRecord;->parse(Ljava/nio/ByteBuffer;Z)[Landroid/nfc/NdefRecord;

    move-result-object v1

    .line 552
    .local v1, rs:[Landroid/nfc/NdefRecord;
    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->remaining()I

    move-result v2

    if-lez v2, :cond_1b

    .line 553
    new-instance v2, Landroid/nfc/FormatException;

    const-string v3, "data too long"

    invoke-direct {v2, v3}, Landroid/nfc/FormatException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 556
    :cond_1b
    aget-object v2, v1, v3

    iget-short v2, v2, Landroid/nfc/NdefRecord;->mTnf:S

    iput-short v2, p0, Landroid/nfc/NdefRecord;->mTnf:S

    .line 557
    aget-object v2, v1, v3

    iget-object v2, v2, Landroid/nfc/NdefRecord;->mType:[B

    iput-object v2, p0, Landroid/nfc/NdefRecord;->mType:[B

    .line 558
    aget-object v2, v1, v3

    iget-object v2, v2, Landroid/nfc/NdefRecord;->mId:[B

    iput-object v2, p0, Landroid/nfc/NdefRecord;->mId:[B

    .line 559
    aget-object v2, v1, v3

    iget-object v2, v2, Landroid/nfc/NdefRecord;->mPayload:[B

    iput-object v2, p0, Landroid/nfc/NdefRecord;->mPayload:[B

    .line 560
    return-void
.end method

.method private static bytesToString([B)Ljava/lang/StringBuilder;
    .registers 10
    .parameter "bs"

    .prologue
    .line 1008
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    .line 1009
    .local v4, s:Ljava/lang/StringBuilder;
    move-object v0, p0

    .local v0, arr$:[B
    array-length v3, v0

    .local v3, len$:I
    const/4 v2, 0x0

    .local v2, i$:I
    :goto_8
    if-ge v2, v3, :cond_22

    aget-byte v1, v0, v2

    .line 1010
    .local v1, b:B
    const-string v5, "%02X"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    invoke-static {v1}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1009
    add-int/lit8 v2, v2, 0x1

    goto :goto_8

    .line 1012
    .end local v1           #b:B
    :cond_22
    return-object v4
.end method

.method public static createApplicationRecord(Ljava/lang/String;)Landroid/nfc/NdefRecord;
    .registers 6
    .parameter "packageName"

    .prologue
    .line 310
    if-nez p0, :cond_b

    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "packageName is null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 311
    :cond_b
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_1a

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "packageName is empty"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 313
    :cond_1a
    new-instance v0, Landroid/nfc/NdefRecord;

    const/4 v1, 0x4

    sget-object v2, Landroid/nfc/NdefRecord;->RTD_ANDROID_APP:[B

    const/4 v3, 0x0

    sget-object v4, Ljava/nio/charset/Charsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-virtual {p0, v4}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Landroid/nfc/NdefRecord;-><init>(S[B[B[B)V

    return-object v0
.end method

.method public static createExternal(Ljava/lang/String;Ljava/lang/String;[B)Landroid/nfc/NdefRecord;
    .registers 9
    .parameter "domain"
    .parameter "type"
    .parameter "data"

    .prologue
    const/4 v5, 0x0

    .line 456
    if-nez p0, :cond_b

    new-instance v3, Ljava/lang/NullPointerException;

    const-string v4, "domain is null"

    invoke-direct {v3, v4}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 457
    :cond_b
    if-nez p1, :cond_16

    new-instance v3, Ljava/lang/NullPointerException;

    const-string/jumbo v4, "type is null"

    invoke-direct {v3, v4}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 459
    :cond_16
    invoke-virtual {p0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    sget-object v4, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v3, v4}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object p0

    .line 460
    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    sget-object v4, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v3, v4}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object p1

    .line 462
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v3

    if-nez v3, :cond_38

    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string v4, "domain is empty"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 463
    :cond_38
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v3

    if-nez v3, :cond_47

    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v4, "type is empty"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 465
    :cond_47
    sget-object v3, Ljava/nio/charset/Charsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-virtual {p0, v3}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v1

    .line 466
    .local v1, byteDomain:[B
    sget-object v3, Ljava/nio/charset/Charsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-virtual {p1, v3}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v2

    .line 467
    .local v2, byteType:[B
    array-length v3, v1

    add-int/lit8 v3, v3, 0x1

    array-length v4, v2

    add-int/2addr v3, v4

    new-array v0, v3, [B

    .line 468
    .local v0, b:[B
    array-length v3, v1

    invoke-static {v1, v5, v0, v5, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 469
    array-length v3, v1

    const/16 v4, 0x3a

    aput-byte v4, v0, v3

    .line 470
    array-length v3, v1

    add-int/lit8 v3, v3, 0x1

    array-length v4, v2

    invoke-static {v2, v5, v0, v3, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 472
    new-instance v3, Landroid/nfc/NdefRecord;

    const/4 v4, 0x4

    const/4 v5, 0x0

    invoke-direct {v3, v4, v0, v5, p2}, Landroid/nfc/NdefRecord;-><init>(S[B[B[B)V

    return-object v3
.end method

.method public static createMime(Ljava/lang/String;[B)Landroid/nfc/NdefRecord;
    .registers 7
    .parameter "mimeType"
    .parameter "mimeData"

    .prologue
    .line 410
    if-nez p0, :cond_b

    new-instance v2, Ljava/lang/NullPointerException;

    const-string/jumbo v3, "mimeType is null"

    invoke-direct {v2, v3}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 415
    :cond_b
    invoke-static {p0}, Landroid/content/Intent;->normalizeMimeType(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    .line 416
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    if-nez v2, :cond_1e

    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v3, "mimeType is empty"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 417
    :cond_1e
    const/16 v2, 0x2f

    invoke-virtual {p0, v2}, Ljava/lang/String;->indexOf(I)I

    move-result v0

    .line 418
    .local v0, slashIndex:I
    if-nez v0, :cond_2f

    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v3, "mimeType must have major type"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 419
    :cond_2f
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    if-ne v0, v2, :cond_40

    .line 420
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v3, "mimeType must have minor type"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 425
    :cond_40
    sget-object v2, Ljava/nio/charset/Charsets;->US_ASCII:Ljava/nio/charset/Charset;

    invoke-virtual {p0, v2}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v1

    .line 426
    .local v1, typeBytes:[B
    new-instance v2, Landroid/nfc/NdefRecord;

    const/4 v3, 0x2

    const/4 v4, 0x0

    invoke-direct {v2, v3, v1, v4, p1}, Landroid/nfc/NdefRecord;-><init>(S[B[B[B)V

    return-object v2
.end method

.method public static createUri(Landroid/net/Uri;)Landroid/nfc/NdefRecord;
    .registers 10
    .parameter "uri"

    .prologue
    const/4 v8, 0x1

    const/4 v6, 0x0

    .line 339
    if-nez p0, :cond_d

    new-instance v5, Ljava/lang/NullPointerException;

    const-string/jumbo v6, "uri is null"

    invoke-direct {v5, v6}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 341
    :cond_d
    invoke-virtual {p0}, Landroid/net/Uri;->normalizeScheme()Landroid/net/Uri;

    move-result-object p0

    .line 342
    invoke-virtual {p0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v4

    .line 343
    .local v4, uriString:Ljava/lang/String;
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v5

    if-nez v5, :cond_24

    new-instance v5, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v6, "uri is empty"

    invoke-direct {v5, v6}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 345
    :cond_24
    const/4 v1, 0x0

    .line 346
    .local v1, prefix:B
    const/4 v0, 0x1

    .local v0, i:I
    :goto_26
    sget-object v5, Landroid/nfc/NdefRecord;->URI_PREFIX_MAP:[Ljava/lang/String;

    array-length v5, v5

    if-ge v0, v5, :cond_42

    .line 347
    sget-object v5, Landroid/nfc/NdefRecord;->URI_PREFIX_MAP:[Ljava/lang/String;

    aget-object v5, v5, v0

    invoke-virtual {v4, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_5c

    .line 348
    int-to-byte v1, v0

    .line 349
    sget-object v5, Landroid/nfc/NdefRecord;->URI_PREFIX_MAP:[Ljava/lang/String;

    aget-object v5, v5, v0

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v4

    .line 353
    :cond_42
    sget-object v5, Ljava/nio/charset/Charsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-virtual {v4, v5}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v3

    .line 354
    .local v3, uriBytes:[B
    array-length v5, v3

    add-int/lit8 v5, v5, 0x1

    new-array v2, v5, [B

    .line 355
    .local v2, recordBytes:[B
    aput-byte v1, v2, v6

    .line 356
    array-length v5, v3

    invoke-static {v3, v6, v2, v8, v5}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 357
    new-instance v5, Landroid/nfc/NdefRecord;

    sget-object v6, Landroid/nfc/NdefRecord;->RTD_URI:[B

    const/4 v7, 0x0

    invoke-direct {v5, v8, v6, v7, v2}, Landroid/nfc/NdefRecord;-><init>(S[B[B[B)V

    return-object v5

    .line 346
    .end local v2           #recordBytes:[B
    .end local v3           #uriBytes:[B
    :cond_5c
    add-int/lit8 v0, v0, 0x1

    goto :goto_26
.end method

.method public static createUri(Ljava/lang/String;)Landroid/nfc/NdefRecord;
    .registers 2
    .parameter "uriString"

    .prologue
    .line 382
    invoke-static {p0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-static {v0}, Landroid/nfc/NdefRecord;->createUri(Landroid/net/Uri;)Landroid/nfc/NdefRecord;

    move-result-object v0

    return-object v0
.end method

.method private static ensureSanePayloadSize(J)V
    .registers 5
    .parameter "size"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/nfc/FormatException;
        }
    .end annotation

    .prologue
    .line 846
    const-wide/32 v0, 0xa00000

    cmp-long v0, p0, v0

    if-lez v0, :cond_2d

    .line 847
    new-instance v0, Landroid/nfc/FormatException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "payload above max limit: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0, p1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " > "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/high16 v2, 0xa0

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/nfc/FormatException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 850
    :cond_2d
    return-void
.end method

.method static parse(Ljava/nio/ByteBuffer;Z)[Landroid/nfc/NdefRecord;
    .registers 33
    .parameter "buffer"
    .parameter "ignoreMbMe"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/nfc/FormatException;
        }
    .end annotation

    .prologue
    .line 743
    new-instance v22, Ljava/util/ArrayList;

    invoke-direct/range {v22 .. v22}, Ljava/util/ArrayList;-><init>()V

    .line 746
    .local v22, records:Ljava/util/List;,"Ljava/util/List<Landroid/nfc/NdefRecord;>;"
    const/16 v25, 0x0

    .line 747
    .local v25, type:[B
    const/4 v12, 0x0

    .line 748
    .local v12, id:[B
    const/16 v19, 0x0

    .line 749
    .local v19, payload:[B
    :try_start_a
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 750
    .local v6, chunks:Ljava/util/ArrayList;,"Ljava/util/ArrayList<[B>;"
    const/4 v15, 0x0

    .line 751
    .local v15, inChunk:Z
    const/4 v5, -0x1

    .line 752
    .local v5, chunkTnf:S
    const/16 v17, 0x0

    .line 754
    .local v17, me:Z
    :cond_13
    :goto_13
    if-nez v17, :cond_1de

    .line 755
    invoke-virtual/range {p0 .. p0}, Ljava/nio/ByteBuffer;->get()B

    move-result v9

    .line 757
    .local v9, flag:B
    and-int/lit8 v27, v9, -0x80

    if-eqz v27, :cond_5d

    const/16 v16, 0x1

    .line 758
    .local v16, mb:Z
    :goto_1f
    and-int/lit8 v27, v9, 0x40

    if-eqz v27, :cond_60

    const/16 v17, 0x1

    .line 759
    :goto_25
    and-int/lit8 v27, v9, 0x20

    if-eqz v27, :cond_63

    const/4 v4, 0x1

    .line 760
    .local v4, cf:Z
    :goto_2a
    and-int/lit8 v27, v9, 0x10

    if-eqz v27, :cond_65

    const/16 v23, 0x1

    .line 761
    .local v23, sr:Z
    :goto_30
    and-int/lit8 v27, v9, 0x8

    if-eqz v27, :cond_68

    const/4 v14, 0x1

    .line 762
    .local v14, il:Z
    :goto_35
    and-int/lit8 v27, v9, 0x7

    move/from16 v0, v27

    int-to-short v0, v0

    move/from16 v24, v0

    .line 764
    .local v24, tnf:S
    if-nez v16, :cond_6a

    invoke-interface/range {v22 .. v22}, Ljava/util/List;->size()I

    move-result v27

    if-nez v27, :cond_6a

    if-nez v15, :cond_6a

    if-nez p1, :cond_6a

    .line 765
    new-instance v27, Landroid/nfc/FormatException;

    const-string v28, "expected MB flag"

    invoke-direct/range {v27 .. v28}, Landroid/nfc/FormatException;-><init>(Ljava/lang/String;)V

    throw v27
    :try_end_50
    .catch Ljava/nio/BufferUnderflowException; {:try_start_a .. :try_end_50} :catch_50

    .line 839
    .end local v4           #cf:Z
    .end local v5           #chunkTnf:S
    .end local v6           #chunks:Ljava/util/ArrayList;,"Ljava/util/ArrayList<[B>;"
    .end local v9           #flag:B
    .end local v14           #il:Z
    .end local v15           #inChunk:Z
    .end local v16           #mb:Z
    .end local v17           #me:Z
    .end local v23           #sr:Z
    .end local v24           #tnf:S
    :catch_50
    move-exception v7

    .line 840
    .local v7, e:Ljava/nio/BufferUnderflowException;
    new-instance v27, Landroid/nfc/FormatException;

    const-string v28, "expected more data"

    move-object/from16 v0, v27

    move-object/from16 v1, v28

    invoke-direct {v0, v1, v7}, Landroid/nfc/FormatException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v27

    .line 757
    .end local v7           #e:Ljava/nio/BufferUnderflowException;
    .restart local v5       #chunkTnf:S
    .restart local v6       #chunks:Ljava/util/ArrayList;,"Ljava/util/ArrayList<[B>;"
    .restart local v9       #flag:B
    .restart local v15       #inChunk:Z
    .restart local v17       #me:Z
    :cond_5d
    const/16 v16, 0x0

    goto :goto_1f

    .line 758
    .restart local v16       #mb:Z
    :cond_60
    const/16 v17, 0x0

    goto :goto_25

    .line 759
    :cond_63
    const/4 v4, 0x0

    goto :goto_2a

    .line 760
    .restart local v4       #cf:Z
    :cond_65
    const/16 v23, 0x0

    goto :goto_30

    .line 761
    .restart local v23       #sr:Z
    :cond_68
    const/4 v14, 0x0

    goto :goto_35

    .line 766
    .restart local v14       #il:Z
    .restart local v24       #tnf:S
    :cond_6a
    if-eqz v16, :cond_7d

    :try_start_6c
    invoke-interface/range {v22 .. v22}, Ljava/util/List;->size()I

    move-result v27

    if-eqz v27, :cond_7d

    if-nez p1, :cond_7d

    .line 767
    new-instance v27, Landroid/nfc/FormatException;

    const-string/jumbo v28, "unexpected MB flag"

    invoke-direct/range {v27 .. v28}, Landroid/nfc/FormatException;-><init>(Ljava/lang/String;)V

    throw v27

    .line 768
    :cond_7d
    if-eqz v15, :cond_8a

    if-eqz v14, :cond_8a

    .line 769
    new-instance v27, Landroid/nfc/FormatException;

    const-string/jumbo v28, "unexpected IL flag in non-leading chunk"

    invoke-direct/range {v27 .. v28}, Landroid/nfc/FormatException;-><init>(Ljava/lang/String;)V

    throw v27

    .line 770
    :cond_8a
    if-eqz v4, :cond_97

    if-eqz v17, :cond_97

    .line 771
    new-instance v27, Landroid/nfc/FormatException;

    const-string/jumbo v28, "unexpected ME flag in non-trailing chunk"

    invoke-direct/range {v27 .. v28}, Landroid/nfc/FormatException;-><init>(Ljava/lang/String;)V

    throw v27

    .line 772
    :cond_97
    if-eqz v15, :cond_a9

    const/16 v27, 0x6

    move/from16 v0, v24

    move/from16 v1, v27

    if-eq v0, v1, :cond_a9

    .line 773
    new-instance v27, Landroid/nfc/FormatException;

    const-string v28, "expected TNF_UNCHANGED in non-leading chunk"

    invoke-direct/range {v27 .. v28}, Landroid/nfc/FormatException;-><init>(Ljava/lang/String;)V

    throw v27

    .line 774
    :cond_a9
    if-nez v15, :cond_bc

    const/16 v27, 0x6

    move/from16 v0, v24

    move/from16 v1, v27

    if-ne v0, v1, :cond_bc

    .line 775
    new-instance v27, Landroid/nfc/FormatException;

    const-string/jumbo v28, "unexpected TNF_UNCHANGED in first chunk or unchunked record"

    invoke-direct/range {v27 .. v28}, Landroid/nfc/FormatException;-><init>(Ljava/lang/String;)V

    throw v27

    .line 779
    :cond_bc
    invoke-virtual/range {p0 .. p0}, Ljava/nio/ByteBuffer;->get()B

    move-result v27

    move/from16 v0, v27

    and-int/lit16 v0, v0, 0xff

    move/from16 v26, v0

    .line 780
    .local v26, typeLength:I
    if-eqz v23, :cond_ed

    invoke-virtual/range {p0 .. p0}, Ljava/nio/ByteBuffer;->get()B

    move-result v27

    move/from16 v0, v27

    and-int/lit16 v0, v0, 0xff

    move/from16 v27, v0

    move/from16 v0, v27

    int-to-long v0, v0

    move-wide/from16 v20, v0

    .line 781
    .local v20, payloadLength:J
    :goto_d7
    if-eqz v14, :cond_fe

    invoke-virtual/range {p0 .. p0}, Ljava/nio/ByteBuffer;->get()B

    move-result v27

    move/from16 v0, v27

    and-int/lit16 v13, v0, 0xff

    .line 783
    .local v13, idLength:I
    :goto_e1
    if-eqz v15, :cond_100

    if-eqz v26, :cond_100

    .line 784
    new-instance v27, Landroid/nfc/FormatException;

    const-string v28, "expected zero-length type in non-leading chunk"

    invoke-direct/range {v27 .. v28}, Landroid/nfc/FormatException;-><init>(Ljava/lang/String;)V

    throw v27

    .line 780
    .end local v13           #idLength:I
    .end local v20           #payloadLength:J
    :cond_ed
    invoke-virtual/range {p0 .. p0}, Ljava/nio/ByteBuffer;->getInt()I

    move-result v27

    move/from16 v0, v27

    int-to-long v0, v0

    move-wide/from16 v27, v0

    const-wide v29, 0xffffffffL

    and-long v20, v27, v29

    goto :goto_d7

    .line 781
    .restart local v20       #payloadLength:J
    :cond_fe
    const/4 v13, 0x0

    goto :goto_e1

    .line 787
    .restart local v13       #idLength:I
    :cond_100
    if-nez v15, :cond_11a

    .line 788
    if-lez v26, :cond_16a

    move/from16 v0, v26

    new-array v0, v0, [B

    move-object/from16 v25, v0

    .line 789
    :goto_10a
    if-lez v13, :cond_16d

    new-array v12, v13, [B

    .line 790
    :goto_10e
    move-object/from16 v0, p0

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/nio/ByteBuffer;->get([B)Ljava/nio/ByteBuffer;

    .line 791
    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Ljava/nio/ByteBuffer;->get([B)Ljava/nio/ByteBuffer;

    .line 794
    :cond_11a
    invoke-static/range {v20 .. v21}, Landroid/nfc/NdefRecord;->ensureSanePayloadSize(J)V

    .line 795
    const-wide/16 v27, 0x0

    cmp-long v27, v20, v27

    if-lez v27, :cond_170

    move-wide/from16 v0, v20

    long-to-int v0, v0

    move/from16 v27, v0

    move/from16 v0, v27

    new-array v0, v0, [B

    move-object/from16 v19, v0

    .line 796
    :goto_12e
    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/nio/ByteBuffer;->get([B)Ljava/nio/ByteBuffer;

    .line 798
    if-eqz v4, :cond_13e

    if-nez v15, :cond_13e

    .line 800
    invoke-virtual {v6}, Ljava/util/ArrayList;->clear()V

    .line 801
    move/from16 v5, v24

    .line 803
    :cond_13e
    if-nez v4, :cond_142

    if-eqz v15, :cond_147

    .line 805
    :cond_142
    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 807
    :cond_147
    if-nez v4, :cond_1ae

    if-eqz v15, :cond_1ae

    .line 809
    const-wide/16 v20, 0x0

    .line 810
    invoke-virtual {v6}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v11

    .local v11, i$:Ljava/util/Iterator;
    :goto_151
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v27

    if-eqz v27, :cond_173

    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v18

    check-cast v18, [B

    .line 811
    .local v18, p:[B
    move-object/from16 v0, v18

    array-length v0, v0

    move/from16 v27, v0

    move/from16 v0, v27

    int-to-long v0, v0

    move-wide/from16 v27, v0

    add-long v20, v20, v27

    goto :goto_151

    .line 788
    .end local v11           #i$:Ljava/util/Iterator;
    .end local v18           #p:[B
    :cond_16a
    sget-object v25, Landroid/nfc/NdefRecord;->EMPTY_BYTE_ARRAY:[B

    goto :goto_10a

    .line 789
    :cond_16d
    sget-object v12, Landroid/nfc/NdefRecord;->EMPTY_BYTE_ARRAY:[B

    goto :goto_10e

    .line 795
    :cond_170
    sget-object v19, Landroid/nfc/NdefRecord;->EMPTY_BYTE_ARRAY:[B

    goto :goto_12e

    .line 813
    .restart local v11       #i$:Ljava/util/Iterator;
    :cond_173
    invoke-static/range {v20 .. v21}, Landroid/nfc/NdefRecord;->ensureSanePayloadSize(J)V

    .line 814
    move-wide/from16 v0, v20

    long-to-int v0, v0

    move/from16 v27, v0

    move/from16 v0, v27

    new-array v0, v0, [B

    move-object/from16 v19, v0

    .line 815
    const/4 v10, 0x0

    .line 816
    .local v10, i:I
    invoke-virtual {v6}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v11

    :goto_186
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v27

    if-eqz v27, :cond_1ac

    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v18

    check-cast v18, [B

    .line 817
    .restart local v18       #p:[B
    const/16 v27, 0x0

    move-object/from16 v0, v18

    array-length v0, v0

    move/from16 v28, v0

    move-object/from16 v0, v18

    move/from16 v1, v27

    move-object/from16 v2, v19

    move/from16 v3, v28

    invoke-static {v0, v1, v2, v10, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 818
    move-object/from16 v0, v18

    array-length v0, v0

    move/from16 v27, v0

    add-int v10, v10, v27

    goto :goto_186

    .line 820
    .end local v18           #p:[B
    :cond_1ac
    move/from16 v24, v5

    .line 822
    .end local v10           #i:I
    .end local v11           #i$:Ljava/util/Iterator;
    :cond_1ae
    if-eqz v4, :cond_1b3

    .line 824
    const/4 v15, 0x1

    .line 825
    goto/16 :goto_13

    .line 827
    :cond_1b3
    const/4 v15, 0x0

    .line 830
    move/from16 v0, v24

    move-object/from16 v1, v25

    move-object/from16 v2, v19

    invoke-static {v0, v1, v12, v2}, Landroid/nfc/NdefRecord;->validateTnf(S[B[B[B)Ljava/lang/String;

    move-result-object v8

    .line 831
    .local v8, error:Ljava/lang/String;
    if-eqz v8, :cond_1c8

    .line 832
    new-instance v27, Landroid/nfc/FormatException;

    move-object/from16 v0, v27

    invoke-direct {v0, v8}, Landroid/nfc/FormatException;-><init>(Ljava/lang/String;)V

    throw v27

    .line 834
    :cond_1c8
    new-instance v27, Landroid/nfc/NdefRecord;

    move-object/from16 v0, v27

    move/from16 v1, v24

    move-object/from16 v2, v25

    move-object/from16 v3, v19

    invoke-direct {v0, v1, v2, v12, v3}, Landroid/nfc/NdefRecord;-><init>(S[B[B[B)V

    move-object/from16 v0, v22

    move-object/from16 v1, v27

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_1dc
    .catch Ljava/nio/BufferUnderflowException; {:try_start_6c .. :try_end_1dc} :catch_50

    .line 835
    if-eqz p1, :cond_13

    .line 842
    .end local v4           #cf:Z
    .end local v8           #error:Ljava/lang/String;
    .end local v9           #flag:B
    .end local v13           #idLength:I
    .end local v14           #il:Z
    .end local v16           #mb:Z
    .end local v20           #payloadLength:J
    .end local v23           #sr:Z
    .end local v24           #tnf:S
    .end local v26           #typeLength:I
    :cond_1de
    invoke-interface/range {v22 .. v22}, Ljava/util/List;->size()I

    move-result v27

    move/from16 v0, v27

    new-array v0, v0, [Landroid/nfc/NdefRecord;

    move-object/from16 v27, v0

    move-object/from16 v0, v22

    move-object/from16 v1, v27

    invoke-interface {v0, v1}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v27

    check-cast v27, [Landroid/nfc/NdefRecord;

    return-object v27
.end method

.method private parseWktUri()Landroid/net/Uri;
    .registers 7

    .prologue
    const/4 v3, 0x0

    .line 713
    iget-object v4, p0, Landroid/nfc/NdefRecord;->mPayload:[B

    array-length v4, v4

    const/4 v5, 0x2

    if-ge v4, v5, :cond_8

    .line 726
    :cond_7
    :goto_7
    return-object v3

    .line 719
    :cond_8
    iget-object v4, p0, Landroid/nfc/NdefRecord;->mPayload:[B

    const/4 v5, 0x0

    aget-byte v4, v4, v5

    and-int/lit8 v1, v4, -0x1

    .line 720
    .local v1, prefixIndex:I
    if-ltz v1, :cond_7

    sget-object v4, Landroid/nfc/NdefRecord;->URI_PREFIX_MAP:[Ljava/lang/String;

    array-length v4, v4

    if-ge v1, v4, :cond_7

    .line 723
    sget-object v3, Landroid/nfc/NdefRecord;->URI_PREFIX_MAP:[Ljava/lang/String;

    aget-object v0, v3, v1

    .line 724
    .local v0, prefix:Ljava/lang/String;
    new-instance v2, Ljava/lang/String;

    iget-object v3, p0, Landroid/nfc/NdefRecord;->mPayload:[B

    const/4 v4, 0x1

    iget-object v5, p0, Landroid/nfc/NdefRecord;->mPayload:[B

    array-length v5, v5

    invoke-static {v3, v4, v5}, Ljava/util/Arrays;->copyOfRange([BII)[B

    move-result-object v3

    sget-object v4, Ljava/nio/charset/Charsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-direct {v2, v3, v4}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    .line 726
    .local v2, suffix:Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    goto :goto_7
.end method

.method private toUri(Z)Landroid/net/Uri;
    .registers 12
    .parameter "inSmartPoster"

    .prologue
    .line 677
    iget-short v6, p0, Landroid/nfc/NdefRecord;->mTnf:S

    packed-switch v6, :pswitch_data_7a

    .line 705
    :cond_5
    :goto_5
    :pswitch_5
    const/4 v5, 0x0

    :cond_6
    :goto_6
    return-object v5

    .line 679
    :pswitch_7
    iget-object v6, p0, Landroid/nfc/NdefRecord;->mType:[B

    sget-object v7, Landroid/nfc/NdefRecord;->RTD_SMART_POSTER:[B

    invoke-static {v6, v7}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v6

    if-eqz v6, :cond_2e

    if-nez p1, :cond_2e

    .line 682
    :try_start_13
    new-instance v3, Landroid/nfc/NdefMessage;

    iget-object v6, p0, Landroid/nfc/NdefRecord;->mPayload:[B

    invoke-direct {v3, v6}, Landroid/nfc/NdefMessage;-><init>([B)V

    .line 683
    .local v3, nestedMessage:Landroid/nfc/NdefMessage;
    invoke-virtual {v3}, Landroid/nfc/NdefMessage;->getRecords()[Landroid/nfc/NdefRecord;

    move-result-object v0

    .local v0, arr$:[Landroid/nfc/NdefRecord;
    array-length v2, v0

    .local v2, len$:I
    const/4 v1, 0x0

    .local v1, i$:I
    :goto_20
    if-ge v1, v2, :cond_5

    aget-object v4, v0, v1

    .line 684
    .local v4, nestedRecord:Landroid/nfc/NdefRecord;
    const/4 v6, 0x1

    invoke-direct {v4, v6}, Landroid/nfc/NdefRecord;->toUri(Z)Landroid/net/Uri;
    :try_end_28
    .catch Landroid/nfc/FormatException; {:try_start_13 .. :try_end_28} :catch_77

    move-result-object v5

    .line 685
    .local v5, uri:Landroid/net/Uri;
    if-nez v5, :cond_6

    .line 683
    add-int/lit8 v1, v1, 0x1

    goto :goto_20

    .line 690
    .end local v0           #arr$:[Landroid/nfc/NdefRecord;
    .end local v1           #i$:I
    .end local v2           #len$:I
    .end local v3           #nestedMessage:Landroid/nfc/NdefMessage;
    .end local v4           #nestedRecord:Landroid/nfc/NdefRecord;
    .end local v5           #uri:Landroid/net/Uri;
    :cond_2e
    iget-object v6, p0, Landroid/nfc/NdefRecord;->mType:[B

    sget-object v7, Landroid/nfc/NdefRecord;->RTD_URI:[B

    invoke-static {v6, v7}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v6

    if-eqz v6, :cond_5

    .line 691
    invoke-direct {p0}, Landroid/nfc/NdefRecord;->parseWktUri()Landroid/net/Uri;

    move-result-object v6

    invoke-virtual {v6}, Landroid/net/Uri;->normalizeScheme()Landroid/net/Uri;

    move-result-object v5

    goto :goto_6

    .line 696
    :pswitch_41
    new-instance v6, Ljava/lang/String;

    iget-object v7, p0, Landroid/nfc/NdefRecord;->mType:[B

    sget-object v8, Ljava/nio/charset/Charsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-direct {v6, v7, v8}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    invoke-static {v6}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    .line 697
    .restart local v5       #uri:Landroid/net/Uri;
    invoke-virtual {v5}, Landroid/net/Uri;->normalizeScheme()Landroid/net/Uri;

    move-result-object v5

    goto :goto_6

    .line 700
    .end local v5           #uri:Landroid/net/Uri;
    :pswitch_53
    if-nez p1, :cond_5

    .line 703
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "vnd.android.nfc://ext/"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    new-instance v7, Ljava/lang/String;

    iget-object v8, p0, Landroid/nfc/NdefRecord;->mType:[B

    sget-object v9, Ljava/nio/charset/Charsets;->US_ASCII:Ljava/nio/charset/Charset;

    invoke-direct {v7, v8, v9}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    goto :goto_6

    .line 689
    :catch_77
    move-exception v6

    goto :goto_5

    .line 677
    nop

    :pswitch_data_7a
    .packed-switch 0x1
        :pswitch_7
        :pswitch_5
        :pswitch_41
        :pswitch_53
    .end packed-switch
.end method

.method static validateTnf(S[B[B[B)Ljava/lang/String;
    .registers 8
    .parameter "tnf"
    .parameter "type"
    .parameter "id"
    .parameter "payload"

    .prologue
    const/4 v0, 0x0

    .line 865
    packed-switch p0, :pswitch_data_2e

    .line 885
    const-string/jumbo v0, "unexpected tnf value: 0x%02x"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-static {p0}, Ljava/lang/Short;->valueOf(S)Ljava/lang/Short;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    :cond_15
    :goto_15
    :pswitch_15
    return-object v0

    .line 867
    :pswitch_16
    array-length v1, p1

    if-nez v1, :cond_1f

    array-length v1, p2

    if-nez v1, :cond_1f

    array-length v1, p3

    if-eqz v1, :cond_15

    .line 868
    :cond_1f
    const-string/jumbo v0, "unexpected data in TNF_EMPTY record"

    goto :goto_15

    .line 878
    :pswitch_23
    array-length v1, p1

    if-eqz v1, :cond_15

    .line 879
    const-string/jumbo v0, "unexpected type field in TNF_UNKNOWN or TNF_RESERVEd record"

    goto :goto_15

    .line 883
    :pswitch_2a
    const-string/jumbo v0, "unexpected TNF_UNCHANGED in first chunk or logical record"

    goto :goto_15

    .line 865
    :pswitch_data_2e
    .packed-switch 0x0
        :pswitch_16
        :pswitch_15
        :pswitch_15
        :pswitch_15
        :pswitch_15
        :pswitch_23
        :pswitch_2a
        :pswitch_23
    .end packed-switch
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    .prologue
    .line 934
    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 6
    .parameter "obj"

    .prologue
    const/4 v1, 0x0

    .line 988
    if-ne p0, p1, :cond_5

    const/4 v1, 0x1

    .line 995
    :cond_4
    :goto_4
    return v1

    .line 989
    :cond_5
    if-eqz p1, :cond_4

    .line 990
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    if-ne v2, v3, :cond_4

    move-object v0, p1

    .line 991
    check-cast v0, Landroid/nfc/NdefRecord;

    .line 992
    .local v0, other:Landroid/nfc/NdefRecord;
    iget-object v2, p0, Landroid/nfc/NdefRecord;->mId:[B

    iget-object v3, v0, Landroid/nfc/NdefRecord;->mId:[B

    invoke-static {v2, v3}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 993
    iget-object v2, p0, Landroid/nfc/NdefRecord;->mPayload:[B

    iget-object v3, v0, Landroid/nfc/NdefRecord;->mPayload:[B

    invoke-static {v2, v3}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 994
    iget-short v2, p0, Landroid/nfc/NdefRecord;->mTnf:S

    iget-short v3, v0, Landroid/nfc/NdefRecord;->mTnf:S

    if-ne v2, v3, :cond_4

    .line 995
    iget-object v1, p0, Landroid/nfc/NdefRecord;->mType:[B

    iget-object v2, v0, Landroid/nfc/NdefRecord;->mType:[B

    invoke-static {v1, v2}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v1

    goto :goto_4
.end method

.method getByteLength()I
    .registers 8

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 921
    iget-object v5, p0, Landroid/nfc/NdefRecord;->mType:[B

    array-length v5, v5

    add-int/lit8 v5, v5, 0x3

    iget-object v6, p0, Landroid/nfc/NdefRecord;->mId:[B

    array-length v6, v6

    add-int/2addr v5, v6

    iget-object v6, p0, Landroid/nfc/NdefRecord;->mPayload:[B

    array-length v6, v6

    add-int v1, v5, v6

    .line 923
    .local v1, length:I
    iget-object v5, p0, Landroid/nfc/NdefRecord;->mPayload:[B

    array-length v5, v5

    const/16 v6, 0x100

    if-ge v5, v6, :cond_27

    move v2, v3

    .line 924
    .local v2, sr:Z
    :goto_18
    iget-object v5, p0, Landroid/nfc/NdefRecord;->mId:[B

    array-length v5, v5

    if-lez v5, :cond_29

    move v0, v3

    .line 926
    .local v0, il:Z
    :goto_1e
    if-nez v2, :cond_22

    add-int/lit8 v1, v1, 0x3

    .line 927
    :cond_22
    if-eqz v0, :cond_26

    add-int/lit8 v1, v1, 0x1

    .line 929
    :cond_26
    return v1

    .end local v0           #il:Z
    .end local v2           #sr:Z
    :cond_27
    move v2, v4

    .line 923
    goto :goto_18

    .restart local v2       #sr:Z
    :cond_29
    move v0, v4

    .line 924
    goto :goto_1e
.end method

.method public getId()[B
    .registers 2

    .prologue
    .line 591
    iget-object v0, p0, Landroid/nfc/NdefRecord;->mId:[B

    invoke-virtual {v0}, [B->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [B

    return-object v0
.end method

.method public getPayload()[B
    .registers 2

    .prologue
    .line 601
    iget-object v0, p0, Landroid/nfc/NdefRecord;->mPayload:[B

    invoke-virtual {v0}, [B->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [B

    return-object v0
.end method

.method public getTnf()S
    .registers 2

    .prologue
    .line 568
    iget-short v0, p0, Landroid/nfc/NdefRecord;->mTnf:S

    return v0
.end method

.method public getType()[B
    .registers 2

    .prologue
    .line 581
    iget-object v0, p0, Landroid/nfc/NdefRecord;->mType:[B

    invoke-virtual {v0}, [B->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [B

    return-object v0
.end method

.method public hashCode()I
    .registers 5

    .prologue
    .line 973
    const/16 v0, 0x1f

    .line 974
    .local v0, prime:I
    const/4 v1, 0x1

    .line 975
    .local v1, result:I
    iget-object v2, p0, Landroid/nfc/NdefRecord;->mId:[B

    invoke-static {v2}, Ljava/util/Arrays;->hashCode([B)I

    move-result v2

    add-int/lit8 v1, v2, 0x1f

    .line 976
    mul-int/lit8 v2, v1, 0x1f

    iget-object v3, p0, Landroid/nfc/NdefRecord;->mPayload:[B

    invoke-static {v3}, Ljava/util/Arrays;->hashCode([B)I

    move-result v3

    add-int v1, v2, v3

    .line 977
    mul-int/lit8 v2, v1, 0x1f

    iget-short v3, p0, Landroid/nfc/NdefRecord;->mTnf:S

    add-int v1, v2, v3

    .line 978
    mul-int/lit8 v2, v1, 0x1f

    iget-object v3, p0, Landroid/nfc/NdefRecord;->mType:[B

    invoke-static {v3}, Ljava/util/Arrays;->hashCode([B)I

    move-result v3

    add-int v1, v2, v3

    .line 979
    return v1
.end method

.method public toByteArray()[B
    .registers 4
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    const/4 v2, 0x1

    .line 618
    invoke-virtual {p0}, Landroid/nfc/NdefRecord;->getByteLength()I

    move-result v1

    invoke-static {v1}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v0

    .line 619
    .local v0, buffer:Ljava/nio/ByteBuffer;
    invoke-virtual {p0, v0, v2, v2}, Landroid/nfc/NdefRecord;->writeToByteBuffer(Ljava/nio/ByteBuffer;ZZ)V

    .line 620
    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v1

    return-object v1
.end method

.method public toMimeType()Ljava/lang/String;
    .registers 4

    .prologue
    .line 639
    iget-short v1, p0, Landroid/nfc/NdefRecord;->mTnf:S

    packed-switch v1, :pswitch_data_24

    .line 649
    :cond_5
    const/4 v1, 0x0

    :goto_6
    return-object v1

    .line 641
    :pswitch_7
    iget-object v1, p0, Landroid/nfc/NdefRecord;->mType:[B

    sget-object v2, Landroid/nfc/NdefRecord;->RTD_TEXT:[B

    invoke-static {v1, v2}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 642
    const-string/jumbo v1, "text/plain"

    goto :goto_6

    .line 646
    :pswitch_15
    new-instance v0, Ljava/lang/String;

    iget-object v1, p0, Landroid/nfc/NdefRecord;->mType:[B

    sget-object v2, Ljava/nio/charset/Charsets;->US_ASCII:Ljava/nio/charset/Charset;

    invoke-direct {v0, v1, v2}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    .line 647
    .local v0, mimeType:Ljava/lang/String;
    invoke-static {v0}, Landroid/content/Intent;->normalizeMimeType(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    goto :goto_6

    .line 639
    nop

    :pswitch_data_24
    .packed-switch 0x1
        :pswitch_7
        :pswitch_15
    .end packed-switch
.end method

.method public toString()Ljava/lang/String;
    .registers 6

    .prologue
    .line 1000
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "NdefRecord tnf=%X"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-short v4, p0, Landroid/nfc/NdefRecord;->mTnf:S

    invoke-static {v4}, Ljava/lang/Short;->valueOf(S)Ljava/lang/Short;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 1001
    .local v0, b:Ljava/lang/StringBuilder;
    iget-object v1, p0, Landroid/nfc/NdefRecord;->mType:[B

    array-length v1, v1

    if-lez v1, :cond_2b

    const-string v1, " type="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/nfc/NdefRecord;->mType:[B

    invoke-static {v2}, Landroid/nfc/NdefRecord;->bytesToString([B)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;

    .line 1002
    :cond_2b
    iget-object v1, p0, Landroid/nfc/NdefRecord;->mId:[B

    array-length v1, v1

    if-lez v1, :cond_3f

    const-string v1, " id="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/nfc/NdefRecord;->mId:[B

    invoke-static {v2}, Landroid/nfc/NdefRecord;->bytesToString([B)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;

    .line 1003
    :cond_3f
    iget-object v1, p0, Landroid/nfc/NdefRecord;->mPayload:[B

    array-length v1, v1

    if-lez v1, :cond_53

    const-string v1, " payload="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/nfc/NdefRecord;->mPayload:[B

    invoke-static {v2}, Landroid/nfc/NdefRecord;->bytesToString([B)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;

    .line 1004
    :cond_53
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public toUri()Landroid/net/Uri;
    .registers 2

    .prologue
    .line 673
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroid/nfc/NdefRecord;->toUri(Z)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method writeToByteBuffer(Ljava/nio/ByteBuffer;ZZ)V
    .registers 11
    .parameter "buffer"
    .parameter "mb"
    .parameter "me"

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 895
    iget-object v5, p0, Landroid/nfc/NdefRecord;->mPayload:[B

    array-length v5, v5

    const/16 v6, 0x100

    if-ge v5, v6, :cond_54

    move v2, v3

    .line 896
    .local v2, sr:Z
    :goto_a
    iget-object v5, p0, Landroid/nfc/NdefRecord;->mId:[B

    array-length v5, v5

    if-lez v5, :cond_56

    move v1, v3

    .line 898
    .local v1, il:Z
    :goto_10
    if-eqz p2, :cond_58

    const/16 v3, -0x80

    move v5, v3

    :goto_15
    if-eqz p3, :cond_5a

    const/16 v3, 0x40

    :goto_19
    or-int/2addr v5, v3

    if-eqz v2, :cond_5c

    const/16 v3, 0x10

    :goto_1e
    or-int/2addr v3, v5

    if-eqz v1, :cond_23

    const/16 v4, 0x8

    :cond_23
    or-int/2addr v3, v4

    iget-short v4, p0, Landroid/nfc/NdefRecord;->mTnf:S

    or-int/2addr v3, v4

    int-to-byte v0, v3

    .line 900
    .local v0, flags:B
    invoke-virtual {p1, v0}, Ljava/nio/ByteBuffer;->put(B)Ljava/nio/ByteBuffer;

    .line 902
    iget-object v3, p0, Landroid/nfc/NdefRecord;->mType:[B

    array-length v3, v3

    int-to-byte v3, v3

    invoke-virtual {p1, v3}, Ljava/nio/ByteBuffer;->put(B)Ljava/nio/ByteBuffer;

    .line 903
    if-eqz v2, :cond_5e

    .line 904
    iget-object v3, p0, Landroid/nfc/NdefRecord;->mPayload:[B

    array-length v3, v3

    int-to-byte v3, v3

    invoke-virtual {p1, v3}, Ljava/nio/ByteBuffer;->put(B)Ljava/nio/ByteBuffer;

    .line 908
    :goto_3b
    if-eqz v1, :cond_44

    .line 909
    iget-object v3, p0, Landroid/nfc/NdefRecord;->mId:[B

    array-length v3, v3

    int-to-byte v3, v3

    invoke-virtual {p1, v3}, Ljava/nio/ByteBuffer;->put(B)Ljava/nio/ByteBuffer;

    .line 912
    :cond_44
    iget-object v3, p0, Landroid/nfc/NdefRecord;->mType:[B

    invoke-virtual {p1, v3}, Ljava/nio/ByteBuffer;->put([B)Ljava/nio/ByteBuffer;

    .line 913
    iget-object v3, p0, Landroid/nfc/NdefRecord;->mId:[B

    invoke-virtual {p1, v3}, Ljava/nio/ByteBuffer;->put([B)Ljava/nio/ByteBuffer;

    .line 914
    iget-object v3, p0, Landroid/nfc/NdefRecord;->mPayload:[B

    invoke-virtual {p1, v3}, Ljava/nio/ByteBuffer;->put([B)Ljava/nio/ByteBuffer;

    .line 915
    return-void

    .end local v0           #flags:B
    .end local v1           #il:Z
    .end local v2           #sr:Z
    :cond_54
    move v2, v4

    .line 895
    goto :goto_a

    .restart local v2       #sr:Z
    :cond_56
    move v1, v4

    .line 896
    goto :goto_10

    .restart local v1       #il:Z
    :cond_58
    move v5, v4

    .line 898
    goto :goto_15

    :cond_5a
    move v3, v4

    goto :goto_19

    :cond_5c
    move v3, v4

    goto :goto_1e

    .line 906
    .restart local v0       #flags:B
    :cond_5e
    iget-object v3, p0, Landroid/nfc/NdefRecord;->mPayload:[B

    array-length v3, v3

    invoke-virtual {p1, v3}, Ljava/nio/ByteBuffer;->putInt(I)Ljava/nio/ByteBuffer;

    goto :goto_3b
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 4
    .parameter "dest"
    .parameter "flags"

    .prologue
    .line 939
    iget-short v0, p0, Landroid/nfc/NdefRecord;->mTnf:S

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 940
    iget-object v0, p0, Landroid/nfc/NdefRecord;->mType:[B

    array-length v0, v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 941
    iget-object v0, p0, Landroid/nfc/NdefRecord;->mType:[B

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeByteArray([B)V

    .line 942
    iget-object v0, p0, Landroid/nfc/NdefRecord;->mId:[B

    array-length v0, v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 943
    iget-object v0, p0, Landroid/nfc/NdefRecord;->mId:[B

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeByteArray([B)V

    .line 944
    iget-object v0, p0, Landroid/nfc/NdefRecord;->mPayload:[B

    array-length v0, v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 945
    iget-object v0, p0, Landroid/nfc/NdefRecord;->mPayload:[B

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeByteArray([B)V

    .line 946
    return-void
.end method
