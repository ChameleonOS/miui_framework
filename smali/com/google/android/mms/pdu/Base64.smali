.class public Lcom/google/android/mms/pdu/Base64;
.super Ljava/lang/Object;
.source "Base64.java"


# static fields
.field static final BASELENGTH:I = 0xff

.field static final FOURBYTE:I = 0x4

.field static final PAD:B = 0x3dt

.field private static base64Alphabet:[B


# direct methods
.method static constructor <clinit>()V
    .registers 4

    .prologue
    const/16 v3, 0xff

    new-array v1, v3, [B

    sput-object v1, Lcom/google/android/mms/pdu/Base64;->base64Alphabet:[B

    const/4 v0, 0x0

    .local v0, i:I
    :goto_7
    if-ge v0, v3, :cond_11

    sget-object v1, Lcom/google/android/mms/pdu/Base64;->base64Alphabet:[B

    const/4 v2, -0x1

    aput-byte v2, v1, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_7

    :cond_11
    const/16 v0, 0x5a

    :goto_13
    const/16 v1, 0x41

    if-lt v0, v1, :cond_21

    sget-object v1, Lcom/google/android/mms/pdu/Base64;->base64Alphabet:[B

    add-int/lit8 v2, v0, -0x41

    int-to-byte v2, v2

    aput-byte v2, v1, v0

    add-int/lit8 v0, v0, -0x1

    goto :goto_13

    :cond_21
    const/16 v0, 0x7a

    :goto_23
    const/16 v1, 0x61

    if-lt v0, v1, :cond_33

    sget-object v1, Lcom/google/android/mms/pdu/Base64;->base64Alphabet:[B

    add-int/lit8 v2, v0, -0x61

    add-int/lit8 v2, v2, 0x1a

    int-to-byte v2, v2

    aput-byte v2, v1, v0

    add-int/lit8 v0, v0, -0x1

    goto :goto_23

    :cond_33
    const/16 v0, 0x39

    :goto_35
    const/16 v1, 0x30

    if-lt v0, v1, :cond_45

    sget-object v1, Lcom/google/android/mms/pdu/Base64;->base64Alphabet:[B

    add-int/lit8 v2, v0, -0x30

    add-int/lit8 v2, v2, 0x34

    int-to-byte v2, v2

    aput-byte v2, v1, v0

    add-int/lit8 v0, v0, -0x1

    goto :goto_35

    :cond_45
    sget-object v1, Lcom/google/android/mms/pdu/Base64;->base64Alphabet:[B

    const/16 v2, 0x2b

    const/16 v3, 0x3e

    aput-byte v3, v1, v2

    sget-object v1, Lcom/google/android/mms/pdu/Base64;->base64Alphabet:[B

    const/16 v2, 0x2f

    const/16 v3, 0x3f

    aput-byte v3, v1, v2

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static decodeBase64([B)[B
    .registers 16
    .parameter "base64Data"

    .prologue
    invoke-static {p0}, Lcom/google/android/mms/pdu/Base64;->discardNonBase64([B)[B

    move-result-object p0

    array-length v12, p0

    if-nez v12, :cond_b

    const/4 v12, 0x0

    new-array v5, v12, [B

    :cond_a
    :goto_a
    return-object v5

    :cond_b
    array-length v12, p0

    div-int/lit8 v11, v12, 0x4

    .local v11, numberQuadruple:I
    const/4 v5, 0x0

    .local v5, decodedData:[B
    const/4 v0, 0x0

    .local v0, b1:B
    const/4 v1, 0x0

    .local v1, b2:B
    const/4 v2, 0x0

    .local v2, b3:B
    const/4 v3, 0x0

    .local v3, b4:B
    const/4 v9, 0x0

    .local v9, marker0:B
    const/4 v10, 0x0

    .local v10, marker1:B
    const/4 v6, 0x0

    .local v6, encodedIndex:I
    const/4 v4, 0x0

    .local v4, dataIndex:I
    array-length v8, p0

    .local v8, lastData:I
    :cond_18
    add-int/lit8 v12, v8, -0x1

    aget-byte v12, p0, v12

    const/16 v13, 0x3d

    if-ne v12, v13, :cond_28

    add-int/lit8 v8, v8, -0x1

    if-nez v8, :cond_18

    const/4 v12, 0x0

    new-array v5, v12, [B

    goto :goto_a

    :cond_28
    sub-int v12, v8, v11

    new-array v5, v12, [B

    const/4 v7, 0x0

    .local v7, i:I
    :goto_2d
    if-ge v7, v11, :cond_a

    mul-int/lit8 v4, v7, 0x4

    add-int/lit8 v12, v4, 0x2

    aget-byte v9, p0, v12

    add-int/lit8 v12, v4, 0x3

    aget-byte v10, p0, v12

    sget-object v12, Lcom/google/android/mms/pdu/Base64;->base64Alphabet:[B

    aget-byte v13, p0, v4

    aget-byte v0, v12, v13

    sget-object v12, Lcom/google/android/mms/pdu/Base64;->base64Alphabet:[B

    add-int/lit8 v13, v4, 0x1

    aget-byte v13, p0, v13

    aget-byte v1, v12, v13

    const/16 v12, 0x3d

    if-eq v9, v12, :cond_7a

    const/16 v12, 0x3d

    if-eq v10, v12, :cond_7a

    sget-object v12, Lcom/google/android/mms/pdu/Base64;->base64Alphabet:[B

    aget-byte v2, v12, v9

    sget-object v12, Lcom/google/android/mms/pdu/Base64;->base64Alphabet:[B

    aget-byte v3, v12, v10

    shl-int/lit8 v12, v0, 0x2

    shr-int/lit8 v13, v1, 0x4

    or-int/2addr v12, v13

    int-to-byte v12, v12

    aput-byte v12, v5, v6

    add-int/lit8 v12, v6, 0x1

    and-int/lit8 v13, v1, 0xf

    shl-int/lit8 v13, v13, 0x4

    shr-int/lit8 v14, v2, 0x2

    and-int/lit8 v14, v14, 0xf

    or-int/2addr v13, v14

    int-to-byte v13, v13

    aput-byte v13, v5, v12

    add-int/lit8 v12, v6, 0x2

    shl-int/lit8 v13, v2, 0x6

    or-int/2addr v13, v3

    int-to-byte v13, v13

    aput-byte v13, v5, v12

    :cond_75
    :goto_75
    add-int/lit8 v6, v6, 0x3

    add-int/lit8 v7, v7, 0x1

    goto :goto_2d

    :cond_7a
    const/16 v12, 0x3d

    if-ne v9, v12, :cond_87

    shl-int/lit8 v12, v0, 0x2

    shr-int/lit8 v13, v1, 0x4

    or-int/2addr v12, v13

    int-to-byte v12, v12

    aput-byte v12, v5, v6

    goto :goto_75

    :cond_87
    const/16 v12, 0x3d

    if-ne v10, v12, :cond_75

    sget-object v12, Lcom/google/android/mms/pdu/Base64;->base64Alphabet:[B

    aget-byte v2, v12, v9

    shl-int/lit8 v12, v0, 0x2

    shr-int/lit8 v13, v1, 0x4

    or-int/2addr v12, v13

    int-to-byte v12, v12

    aput-byte v12, v5, v6

    add-int/lit8 v12, v6, 0x1

    and-int/lit8 v13, v1, 0xf

    shl-int/lit8 v13, v13, 0x4

    shr-int/lit8 v14, v2, 0x2

    and-int/lit8 v14, v14, 0xf

    or-int/2addr v13, v14

    int-to-byte v13, v13

    aput-byte v13, v5, v12

    goto :goto_75
.end method

.method static discardNonBase64([B)[B
    .registers 8
    .parameter "data"

    .prologue
    const/4 v6, 0x0

    array-length v5, p0

    new-array v2, v5, [B

    .local v2, groomedData:[B
    const/4 v0, 0x0

    .local v0, bytesCopied:I
    const/4 v3, 0x0

    .local v3, i:I
    :goto_6
    array-length v5, p0

    if-ge v3, v5, :cond_1b

    aget-byte v5, p0, v3

    invoke-static {v5}, Lcom/google/android/mms/pdu/Base64;->isBase64(B)Z

    move-result v5

    if-eqz v5, :cond_18

    add-int/lit8 v1, v0, 0x1

    .end local v0           #bytesCopied:I
    .local v1, bytesCopied:I
    aget-byte v5, p0, v3

    aput-byte v5, v2, v0

    move v0, v1

    .end local v1           #bytesCopied:I
    .restart local v0       #bytesCopied:I
    :cond_18
    add-int/lit8 v3, v3, 0x1

    goto :goto_6

    :cond_1b
    new-array v4, v0, [B

    .local v4, packedData:[B
    invoke-static {v2, v6, v4, v6, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v4
.end method

.method private static isBase64(B)Z
    .registers 4
    .parameter "octect"

    .prologue
    const/4 v0, 0x1

    const/16 v1, 0x3d

    if-ne p0, v1, :cond_6

    :cond_5
    :goto_5
    return v0

    :cond_6
    sget-object v1, Lcom/google/android/mms/pdu/Base64;->base64Alphabet:[B

    aget-byte v1, v1, p0

    const/4 v2, -0x1

    if-ne v1, v2, :cond_5

    const/4 v0, 0x0

    goto :goto_5
.end method
