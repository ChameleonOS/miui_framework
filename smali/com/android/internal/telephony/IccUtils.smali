.class public Lcom/android/internal/telephony/IccUtils;
.super Ljava/lang/Object;
.source "IccUtils.java"


# static fields
.field static final LOG_TAG:Ljava/lang/String; = "IccUtils"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 33
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static adnStringFieldToString([BII)Ljava/lang/String;
    .registers 16
    .parameter "data"
    .parameter "offset"
    .parameter "length"

    .prologue
    .line 179
    if-nez p2, :cond_5

    .line 180
    const-string v10, ""

    .line 265
    :goto_4
    return-object v10

    .line 182
    :cond_5
    const/4 v10, 0x1

    if-lt p2, v10, :cond_45

    .line 183
    aget-byte v10, p0, p1

    const/16 v11, -0x80

    if-ne v10, v11, :cond_45

    .line 184
    add-int/lit8 v10, p2, -0x1

    div-int/lit8 v9, v10, 0x2

    .line 185
    .local v9, ucslen:I
    const/4 v7, 0x0

    .line 188
    .local v7, ret:Ljava/lang/String;
    :try_start_13
    new-instance v8, Ljava/lang/String;

    add-int/lit8 v10, p1, 0x1

    mul-int/lit8 v11, v9, 0x2

    const-string/jumbo v12, "utf-16be"

    invoke-direct {v8, p0, v10, v11, v12}, Ljava/lang/String;-><init>([BIILjava/lang/String;)V
    :try_end_1f
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_13 .. :try_end_1f} :catch_36

    .end local v7           #ret:Ljava/lang/String;
    .local v8, ret:Ljava/lang/String;
    move-object v7, v8

    .line 194
    .end local v8           #ret:Ljava/lang/String;
    .restart local v7       #ret:Ljava/lang/String;
    :goto_20
    if-eqz v7, :cond_45

    .line 197
    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v9

    .line 198
    :goto_26
    if-lez v9, :cond_3f

    add-int/lit8 v10, v9, -0x1

    invoke-virtual {v7, v10}, Ljava/lang/String;->charAt(I)C

    move-result v10

    const v11, 0xffff

    if-ne v10, v11, :cond_3f

    .line 199
    add-int/lit8 v9, v9, -0x1

    goto :goto_26

    .line 189
    :catch_36
    move-exception v3

    .line 190
    .local v3, ex:Ljava/io/UnsupportedEncodingException;
    const-string v10, "IccUtils"

    const-string v11, "implausible UnsupportedEncodingException"

    invoke-static {v10, v11, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_20

    .line 201
    .end local v3           #ex:Ljava/io/UnsupportedEncodingException;
    :cond_3f
    const/4 v10, 0x0

    invoke-virtual {v7, v10, v9}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v10

    goto :goto_4

    .line 206
    .end local v7           #ret:Ljava/lang/String;
    .end local v9           #ucslen:I
    :cond_45
    const/4 v4, 0x0

    .line 207
    .local v4, isucs2:Z
    const/4 v0, 0x0

    .line 208
    .local v0, base:C
    const/4 v5, 0x0

    .line 210
    .local v5, len:I
    const/4 v10, 0x3

    if-lt p2, v10, :cond_8f

    aget-byte v10, p0, p1

    const/16 v11, -0x7f

    if-ne v10, v11, :cond_8f

    .line 211
    add-int/lit8 v10, p1, 0x1

    aget-byte v10, p0, v10

    and-int/lit16 v5, v10, 0xff

    .line 212
    add-int/lit8 v10, p2, -0x3

    if-le v5, v10, :cond_5d

    .line 213
    add-int/lit8 v5, p2, -0x3

    .line 215
    :cond_5d
    add-int/lit8 v10, p1, 0x2

    aget-byte v10, p0, v10

    and-int/lit16 v10, v10, 0xff

    shl-int/lit8 v10, v10, 0x7

    int-to-char v0, v10

    .line 216
    add-int/lit8 p1, p1, 0x3

    .line 217
    const/4 v4, 0x1

    .line 229
    :cond_69
    :goto_69
    if-eqz v4, :cond_c8

    .line 230
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    .line 232
    .local v7, ret:Ljava/lang/StringBuilder;
    :goto_70
    if-lez v5, :cond_c2

    .line 235
    aget-byte v10, p0, p1

    if-gez v10, :cond_83

    .line 236
    aget-byte v10, p0, p1

    and-int/lit8 v10, v10, 0x7f

    add-int/2addr v10, v0

    int-to-char v10, v10

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 237
    add-int/lit8 p1, p1, 0x1

    .line 238
    add-int/lit8 v5, v5, -0x1

    .line 243
    :cond_83
    const/4 v1, 0x0

    .line 244
    .local v1, count:I
    :goto_84
    if-ge v1, v5, :cond_b8

    add-int v10, p1, v1

    aget-byte v10, p0, v10

    if-ltz v10, :cond_b8

    .line 245
    add-int/lit8 v1, v1, 0x1

    goto :goto_84

    .line 218
    .end local v1           #count:I
    .end local v7           #ret:Ljava/lang/StringBuilder;
    :cond_8f
    const/4 v10, 0x4

    if-lt p2, v10, :cond_69

    aget-byte v10, p0, p1

    const/16 v11, -0x7e

    if-ne v10, v11, :cond_69

    .line 219
    add-int/lit8 v10, p1, 0x1

    aget-byte v10, p0, v10

    and-int/lit16 v5, v10, 0xff

    .line 220
    add-int/lit8 v10, p2, -0x4

    if-le v5, v10, :cond_a4

    .line 221
    add-int/lit8 v5, p2, -0x4

    .line 223
    :cond_a4
    add-int/lit8 v10, p1, 0x2

    aget-byte v10, p0, v10

    and-int/lit16 v10, v10, 0xff

    shl-int/lit8 v10, v10, 0x8

    add-int/lit8 v11, p1, 0x3

    aget-byte v11, p0, v11

    and-int/lit16 v11, v11, 0xff

    or-int/2addr v10, v11

    int-to-char v0, v10

    .line 225
    add-int/lit8 p1, p1, 0x4

    .line 226
    const/4 v4, 0x1

    goto :goto_69

    .line 247
    .restart local v1       #count:I
    .restart local v7       #ret:Ljava/lang/StringBuilder;
    :cond_b8
    invoke-static {p0, p1, v1}, Lcom/android/internal/telephony/GsmAlphabet;->gsm8BitUnpackedToString([BII)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 250
    add-int/2addr p1, v1

    .line 251
    sub-int/2addr v5, v1

    .line 252
    goto :goto_70

    .line 254
    .end local v1           #count:I
    :cond_c2
    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    goto/16 :goto_4

    .line 257
    .end local v7           #ret:Ljava/lang/StringBuilder;
    :cond_c8
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v6

    .line 258
    .local v6, resource:Landroid/content/res/Resources;
    const-string v2, ""

    .line 260
    .local v2, defaultCharset:Ljava/lang/String;
    const v10, 0x1040020

    :try_start_d1
    invoke-virtual {v6, v10}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    :try_end_d4
    .catch Landroid/content/res/Resources$NotFoundException; {:try_start_d1 .. :try_end_d4} :catch_df

    move-result-object v2

    .line 265
    :goto_d5
    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v10

    invoke-static {p0, p1, p2, v10}, Lcom/android/internal/telephony/GsmAlphabet;->gsm8BitUnpackedToString([BIILjava/lang/String;)Ljava/lang/String;

    move-result-object v10

    goto/16 :goto_4

    .line 262
    :catch_df
    move-exception v10

    goto :goto_d5
.end method

.method public static bcdToString([BII)Ljava/lang/String;
    .registers 8
    .parameter "data"
    .parameter "offset"
    .parameter "length"

    .prologue
    const/16 v4, 0x9

    .line 46
    new-instance v1, Ljava/lang/StringBuilder;

    mul-int/lit8 v3, p2, 0x2

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 48
    .local v1, ret:Ljava/lang/StringBuilder;
    move v0, p1

    .local v0, i:I
    :goto_a
    add-int v3, p1, p2

    if-ge v0, v3, :cond_14

    .line 52
    aget-byte v3, p0, v0

    and-int/lit8 v2, v3, 0xf

    .line 53
    .local v2, v:I
    if-le v2, v4, :cond_19

    .line 63
    .end local v2           #v:I
    :cond_14
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 54
    .restart local v2       #v:I
    :cond_19
    add-int/lit8 v3, v2, 0x30

    int-to-char v3, v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 56
    aget-byte v3, p0, v0

    shr-int/lit8 v3, v3, 0x4

    and-int/lit8 v2, v3, 0xf

    .line 58
    const/16 v3, 0xf

    if-ne v2, v3, :cond_2c

    .line 48
    :goto_29
    add-int/lit8 v0, v0, 0x1

    goto :goto_a

    .line 59
    :cond_2c
    if-gt v2, v4, :cond_14

    .line 60
    add-int/lit8 v3, v2, 0x30

    int-to-char v3, v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_29
.end method

.method private static bitToRGB(I)I
    .registers 2
    .parameter "bit"

    .prologue
    .line 418
    const/4 v0, 0x1

    if-ne p0, v0, :cond_5

    .line 419
    const/4 v0, -0x1

    .line 421
    :goto_4
    return v0

    :cond_5
    const/high16 v0, -0x100

    goto :goto_4
.end method

.method public static bytesToHexString([B)Ljava/lang/String;
    .registers 5
    .parameter "bytes"

    .prologue
    .line 315
    if-nez p0, :cond_4

    const/4 v3, 0x0

    .line 331
    :goto_3
    return-object v3

    .line 317
    :cond_4
    new-instance v2, Ljava/lang/StringBuilder;

    array-length v3, p0

    mul-int/lit8 v3, v3, 0x2

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 319
    .local v2, ret:Ljava/lang/StringBuilder;
    const/4 v1, 0x0

    .local v1, i:I
    :goto_d
    array-length v3, p0

    if-ge v1, v3, :cond_2f

    .line 322
    aget-byte v3, p0, v1

    shr-int/lit8 v3, v3, 0x4

    and-int/lit8 v0, v3, 0xf

    .line 324
    .local v0, b:I
    const-string v3, "0123456789abcdef"

    invoke-virtual {v3, v0}, Ljava/lang/String;->charAt(I)C

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 326
    aget-byte v3, p0, v1

    and-int/lit8 v0, v3, 0xf

    .line 328
    const-string v3, "0123456789abcdef"

    invoke-virtual {v3, v0}, Ljava/lang/String;->charAt(I)C

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 319
    add-int/lit8 v1, v1, 0x1

    goto :goto_d

    .line 331
    .end local v0           #b:I
    :cond_2f
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto :goto_3
.end method

.method public static cdmaBcdByteToInt(B)I
    .registers 4
    .parameter "b"

    .prologue
    .line 128
    const/4 v0, 0x0

    .line 131
    .local v0, ret:I
    and-int/lit16 v1, p0, 0xf0

    const/16 v2, 0x90

    if-gt v1, v2, :cond_d

    .line 132
    shr-int/lit8 v1, p0, 0x4

    and-int/lit8 v1, v1, 0xf

    mul-int/lit8 v0, v1, 0xa

    .line 135
    :cond_d
    and-int/lit8 v1, p0, 0xf

    const/16 v2, 0x9

    if-gt v1, v2, :cond_16

    .line 136
    and-int/lit8 v1, p0, 0xf

    add-int/2addr v0, v1

    .line 139
    :cond_16
    return v0
.end method

.method public static cdmaBcdToString([BII)Ljava/lang/String;
    .registers 9
    .parameter "data"
    .parameter "offset"
    .parameter "length"

    .prologue
    const/16 v5, 0x9

    .line 71
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2, p2}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 73
    .local v2, ret:Ljava/lang/StringBuilder;
    const/4 v0, 0x0

    .line 74
    .local v0, count:I
    move v1, p1

    .local v1, i:I
    :goto_9
    if-ge v0, p2, :cond_1c

    .line 76
    aget-byte v4, p0, v1

    and-int/lit8 v3, v4, 0xf

    .line 77
    .local v3, v:I
    if-le v3, v5, :cond_12

    const/4 v3, 0x0

    .line 78
    :cond_12
    add-int/lit8 v4, v3, 0x30

    int-to-char v4, v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 80
    add-int/lit8 v0, v0, 0x1

    if-ne v0, p2, :cond_21

    .line 87
    .end local v3           #v:I
    :cond_1c
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    return-object v4

    .line 82
    .restart local v3       #v:I
    :cond_21
    aget-byte v4, p0, v1

    shr-int/lit8 v4, v4, 0x4

    and-int/lit8 v3, v4, 0xf

    .line 83
    if-le v3, v5, :cond_2a

    const/4 v3, 0x0

    .line 84
    :cond_2a
    add-int/lit8 v4, v3, 0x30

    int-to-char v4, v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 85
    add-int/lit8 v0, v0, 0x1

    .line 74
    add-int/lit8 v1, v1, 0x1

    goto :goto_9
.end method

.method private static getCLUT([BII)[I
    .registers 12
    .parameter "rawData"
    .parameter "offset"
    .parameter "number"

    .prologue
    .line 513
    if-nez p0, :cond_4

    .line 514
    const/4 v4, 0x0

    .line 528
    :cond_3
    return-object v4

    .line 517
    :cond_4
    new-array v4, p2, [I

    .line 518
    .local v4, result:[I
    mul-int/lit8 v7, p2, 0x3

    add-int v3, p1, v7

    .line 519
    .local v3, endIndex:I
    move v5, p1

    .line 520
    .local v5, valueIndex:I
    const/4 v1, 0x0

    .line 521
    .local v1, colorIndex:I
    const/high16 v0, -0x100

    .line 523
    .local v0, alpha:I
    :goto_e
    add-int/lit8 v2, v1, 0x1

    .end local v1           #colorIndex:I
    .local v2, colorIndex:I
    add-int/lit8 v6, v5, 0x1

    .end local v5           #valueIndex:I
    .local v6, valueIndex:I
    aget-byte v7, p0, v5

    and-int/lit16 v7, v7, 0xff

    shl-int/lit8 v7, v7, 0x10

    or-int/2addr v7, v0

    add-int/lit8 v5, v6, 0x1

    .end local v6           #valueIndex:I
    .restart local v5       #valueIndex:I
    aget-byte v8, p0, v6

    and-int/lit16 v8, v8, 0xff

    shl-int/lit8 v8, v8, 0x8

    or-int/2addr v7, v8

    add-int/lit8 v6, v5, 0x1

    .end local v5           #valueIndex:I
    .restart local v6       #valueIndex:I
    aget-byte v8, p0, v5

    and-int/lit16 v8, v8, 0xff

    or-int/2addr v7, v8

    aput v7, v4, v1

    .line 527
    if-ge v6, v3, :cond_3

    move v1, v2

    .end local v2           #colorIndex:I
    .restart local v1       #colorIndex:I
    move v5, v6

    .end local v6           #valueIndex:I
    .restart local v5       #valueIndex:I
    goto :goto_e
.end method

.method public static gsmBcdByteToInt(B)I
    .registers 4
    .parameter "b"

    .prologue
    .line 106
    const/4 v0, 0x0

    .line 109
    .local v0, ret:I
    and-int/lit16 v1, p0, 0xf0

    const/16 v2, 0x90

    if-gt v1, v2, :cond_b

    .line 110
    shr-int/lit8 v1, p0, 0x4

    and-int/lit8 v0, v1, 0xf

    .line 113
    :cond_b
    and-int/lit8 v1, p0, 0xf

    const/16 v2, 0x9

    if-gt v1, v2, :cond_16

    .line 114
    and-int/lit8 v1, p0, 0xf

    mul-int/lit8 v1, v1, 0xa

    add-int/2addr v0, v1

    .line 117
    :cond_16
    return v0
.end method

.method static hexCharToInt(C)I
    .registers 4
    .parameter "c"

    .prologue
    .line 270
    const/16 v0, 0x30

    if-lt p0, v0, :cond_b

    const/16 v0, 0x39

    if-gt p0, v0, :cond_b

    add-int/lit8 v0, p0, -0x30

    .line 272
    :goto_a
    return v0

    .line 271
    :cond_b
    const/16 v0, 0x41

    if-lt p0, v0, :cond_18

    const/16 v0, 0x46

    if-gt p0, v0, :cond_18

    add-int/lit8 v0, p0, -0x41

    add-int/lit8 v0, v0, 0xa

    goto :goto_a

    .line 272
    :cond_18
    const/16 v0, 0x61

    if-lt p0, v0, :cond_25

    const/16 v0, 0x66

    if-gt p0, v0, :cond_25

    add-int/lit8 v0, p0, -0x61

    add-int/lit8 v0, v0, 0xa

    goto :goto_a

    .line 274
    :cond_25
    new-instance v0, Ljava/lang/RuntimeException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "invalid hex char \'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static hexStringToBytes(Ljava/lang/String;)[B
    .registers 7
    .parameter "s"

    .prologue
    .line 291
    if-nez p0, :cond_4

    const/4 v1, 0x0

    .line 302
    :cond_3
    return-object v1

    .line 293
    :cond_4
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    .line 295
    .local v2, sz:I
    div-int/lit8 v3, v2, 0x2

    new-array v1, v3, [B

    .line 297
    .local v1, ret:[B
    const/4 v0, 0x0

    .local v0, i:I
    :goto_d
    if-ge v0, v2, :cond_3

    .line 298
    div-int/lit8 v3, v0, 0x2

    invoke-virtual {p0, v0}, Ljava/lang/String;->charAt(I)C

    move-result v4

    invoke-static {v4}, Lcom/android/internal/telephony/IccUtils;->hexCharToInt(C)I

    move-result v4

    shl-int/lit8 v4, v4, 0x4

    add-int/lit8 v5, v0, 0x1

    invoke-virtual {p0, v5}, Ljava/lang/String;->charAt(I)C

    move-result v5

    invoke-static {v5}, Lcom/android/internal/telephony/IccUtils;->hexCharToInt(C)I

    move-result v5

    or-int/2addr v4, v5

    int-to-byte v4, v4

    aput-byte v4, v1, v3

    .line 297
    add-int/lit8 v0, v0, 0x2

    goto :goto_d
.end method

.method private static mapTo2OrderBitColor([BII[II)[I
    .registers 16
    .parameter "data"
    .parameter "valueIndex"
    .parameter "length"
    .parameter "colorArray"
    .parameter "bits"

    .prologue
    const/16 v10, 0x8

    .line 463
    rem-int v9, v10, p4

    if-eqz v9, :cond_13

    .line 464
    const-string v9, "IccUtils"

    const-string/jumbo v10, "not event number of color"

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 465
    invoke-static {p0, p1, p2, p3, p4}, Lcom/android/internal/telephony/IccUtils;->mapToNon2OrderBitColor([BII[II)[I

    move-result-object v2

    .line 496
    :goto_12
    return-object v2

    .line 469
    :cond_13
    const/4 v0, 0x1

    .line 470
    .local v0, mask:I
    packed-switch p4, :pswitch_data_4a

    .line 485
    :goto_17
    :pswitch_17
    new-array v2, p2, [I

    .line 486
    .local v2, resultArray:[I
    const/4 v3, 0x0

    .line 487
    .local v3, resultIndex:I
    div-int v5, v10, p4

    .local v5, run:I
    move v8, p1

    .line 488
    .end local p1
    .local v8, valueIndex:I
    :goto_1d
    if-ge v3, p2, :cond_47

    .line 489
    add-int/lit8 p1, v8, 0x1

    .end local v8           #valueIndex:I
    .restart local p1
    aget-byte v7, p0, v8

    .line 490
    .local v7, tempByte:B
    const/4 v6, 0x0

    .local v6, runIndex:I
    move v4, v3

    .end local v3           #resultIndex:I
    .local v4, resultIndex:I
    :goto_25
    if-ge v6, v5, :cond_44

    .line 491
    sub-int v9, v5, v6

    add-int/lit8 v1, v9, -0x1

    .line 492
    .local v1, offset:I
    add-int/lit8 v3, v4, 0x1

    .end local v4           #resultIndex:I
    .restart local v3       #resultIndex:I
    mul-int v9, v1, p4

    shr-int v9, v7, v9

    and-int/2addr v9, v0

    aget v9, p3, v9

    aput v9, v2, v4

    .line 490
    add-int/lit8 v6, v6, 0x1

    move v4, v3

    .end local v3           #resultIndex:I
    .restart local v4       #resultIndex:I
    goto :goto_25

    .line 472
    .end local v1           #offset:I
    .end local v2           #resultArray:[I
    .end local v4           #resultIndex:I
    .end local v5           #run:I
    .end local v6           #runIndex:I
    .end local v7           #tempByte:B
    :pswitch_3a
    const/4 v0, 0x1

    .line 473
    goto :goto_17

    .line 475
    :pswitch_3c
    const/4 v0, 0x3

    .line 476
    goto :goto_17

    .line 478
    :pswitch_3e
    const/16 v0, 0xf

    .line 479
    goto :goto_17

    .line 481
    :pswitch_41
    const/16 v0, 0xff

    goto :goto_17

    .restart local v2       #resultArray:[I
    .restart local v4       #resultIndex:I
    .restart local v5       #run:I
    .restart local v6       #runIndex:I
    .restart local v7       #tempByte:B
    :cond_44
    move v3, v4

    .end local v4           #resultIndex:I
    .restart local v3       #resultIndex:I
    move v8, p1

    .line 495
    .end local p1
    .restart local v8       #valueIndex:I
    goto :goto_1d

    .end local v6           #runIndex:I
    .end local v7           #tempByte:B
    :cond_47
    move p1, v8

    .line 496
    .end local v8           #valueIndex:I
    .restart local p1
    goto :goto_12

    .line 470
    nop

    :pswitch_data_4a
    .packed-switch 0x1
        :pswitch_3a
        :pswitch_3c
        :pswitch_17
        :pswitch_3e
        :pswitch_17
        :pswitch_17
        :pswitch_17
        :pswitch_41
    .end packed-switch
.end method

.method private static mapToNon2OrderBitColor([BII[II)[I
    .registers 8
    .parameter "data"
    .parameter "valueIndex"
    .parameter "length"
    .parameter "colorArray"
    .parameter "bits"

    .prologue
    .line 501
    const/16 v1, 0x8

    rem-int/2addr v1, p4

    if-nez v1, :cond_12

    .line 502
    const-string v1, "IccUtils"

    const-string/jumbo v2, "not odd number of color"

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 503
    invoke-static {p0, p1, p2, p3, p4}, Lcom/android/internal/telephony/IccUtils;->mapTo2OrderBitColor([BII[II)[I

    move-result-object v0

    .line 509
    :goto_11
    return-object v0

    .line 507
    :cond_12
    new-array v0, p2, [I

    .line 509
    .local v0, resultArray:[I
    goto :goto_11
.end method

.method public static networkNameToString([BII)Ljava/lang/String;
    .registers 10
    .parameter "data"
    .parameter "offset"
    .parameter "length"

    .prologue
    .line 344
    aget-byte v4, p0, p1

    and-int/lit16 v4, v4, 0x80

    const/16 v5, 0x80

    if-ne v4, v5, :cond_b

    const/4 v4, 0x1

    if-ge p2, v4, :cond_e

    .line 345
    :cond_b
    const-string v2, ""

    .line 382
    :cond_d
    :goto_d
    return-object v2

    .line 348
    :cond_e
    aget-byte v4, p0, p1

    ushr-int/lit8 v4, v4, 0x4

    and-int/lit8 v4, v4, 0x7

    packed-switch v4, :pswitch_data_4a

    .line 369
    const-string v2, ""

    .line 377
    .local v2, ret:Ljava/lang/String;
    :goto_19
    aget-byte v4, p0, p1

    and-int/lit8 v4, v4, 0x40

    if-eqz v4, :cond_d

    goto :goto_d

    .line 352
    .end local v2           #ret:Ljava/lang/String;
    :pswitch_20
    aget-byte v4, p0, p1

    and-int/lit8 v3, v4, 0x7

    .line 353
    .local v3, unusedBits:I
    add-int/lit8 v4, p2, -0x1

    mul-int/lit8 v4, v4, 0x8

    sub-int/2addr v4, v3

    div-int/lit8 v0, v4, 0x7

    .line 354
    .local v0, countSeptets:I
    add-int/lit8 v4, p1, 0x1

    invoke-static {p0, v4, v0}, Lcom/android/internal/telephony/GsmAlphabet;->gsm7BitPackedToString([BII)Ljava/lang/String;

    move-result-object v2

    .line 355
    .restart local v2       #ret:Ljava/lang/String;
    goto :goto_19

    .line 359
    .end local v0           #countSeptets:I
    .end local v2           #ret:Ljava/lang/String;
    .end local v3           #unusedBits:I
    :pswitch_32
    :try_start_32
    new-instance v2, Ljava/lang/String;

    add-int/lit8 v4, p1, 0x1

    add-int/lit8 v5, p2, -0x1

    const-string/jumbo v6, "utf-16"

    invoke-direct {v2, p0, v4, v5, v6}, Ljava/lang/String;-><init>([BIILjava/lang/String;)V
    :try_end_3e
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_32 .. :try_end_3e} :catch_3f

    .restart local v2       #ret:Ljava/lang/String;
    goto :goto_19

    .line 361
    .end local v2           #ret:Ljava/lang/String;
    :catch_3f
    move-exception v1

    .line 362
    .local v1, ex:Ljava/io/UnsupportedEncodingException;
    const-string v2, ""

    .line 363
    .restart local v2       #ret:Ljava/lang/String;
    const-string v4, "IccUtils"

    const-string v5, "implausible UnsupportedEncodingException"

    invoke-static {v4, v5, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_19

    .line 348
    :pswitch_data_4a
    .packed-switch 0x0
        :pswitch_20
        :pswitch_32
    .end packed-switch
.end method

.method public static parseToBnW([BI)Landroid/graphics/Bitmap;
    .registers 15
    .parameter "data"
    .parameter "length"

    .prologue
    .line 392
    const/4 v8, 0x0

    .line 393
    .local v8, valueIndex:I
    add-int/lit8 v9, v8, 0x1

    .end local v8           #valueIndex:I
    .local v9, valueIndex:I
    aget-byte v11, p0, v8

    and-int/lit16 v10, v11, 0xff

    .line 394
    .local v10, width:I
    add-int/lit8 v8, v9, 0x1

    .end local v9           #valueIndex:I
    .restart local v8       #valueIndex:I
    aget-byte v11, p0, v9

    and-int/lit16 v3, v11, 0xff

    .line 395
    .local v3, height:I
    mul-int v4, v10, v3

    .line 397
    .local v4, numOfPixels:I
    new-array v7, v4, [I

    .line 399
    .local v7, pixels:[I
    const/4 v5, 0x0

    .line 400
    .local v5, pixelIndex:I
    const/4 v0, 0x7

    .line 401
    .local v0, bitIndex:I
    const/4 v2, 0x0

    .local v2, currentByte:B
    move v6, v5

    .end local v5           #pixelIndex:I
    .local v6, pixelIndex:I
    move v9, v8

    .line 402
    .end local v8           #valueIndex:I
    .restart local v9       #valueIndex:I
    :goto_16
    if-ge v6, v4, :cond_33

    .line 404
    rem-int/lit8 v11, v6, 0x8

    if-nez v11, :cond_44

    .line 405
    add-int/lit8 v8, v9, 0x1

    .end local v9           #valueIndex:I
    .restart local v8       #valueIndex:I
    aget-byte v2, p0, v9

    .line 406
    const/4 v0, 0x7

    .line 408
    :goto_21
    add-int/lit8 v5, v6, 0x1

    .end local v6           #pixelIndex:I
    .restart local v5       #pixelIndex:I
    add-int/lit8 v1, v0, -0x1

    .end local v0           #bitIndex:I
    .local v1, bitIndex:I
    shr-int v11, v2, v0

    and-int/lit8 v11, v11, 0x1

    invoke-static {v11}, Lcom/android/internal/telephony/IccUtils;->bitToRGB(I)I

    move-result v11

    aput v11, v7, v6

    move v0, v1

    .end local v1           #bitIndex:I
    .restart local v0       #bitIndex:I
    move v6, v5

    .end local v5           #pixelIndex:I
    .restart local v6       #pixelIndex:I
    move v9, v8

    .end local v8           #valueIndex:I
    .restart local v9       #valueIndex:I
    goto :goto_16

    .line 411
    :cond_33
    if-eq v6, v4, :cond_3d

    .line 412
    const-string v11, "IccUtils"

    const-string/jumbo v12, "parse end and size error"

    invoke-static {v11, v12}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 414
    :cond_3d
    sget-object v11, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v7, v10, v3, v11}, Landroid/graphics/Bitmap;->createBitmap([IIILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v11

    return-object v11

    :cond_44
    move v8, v9

    .end local v9           #valueIndex:I
    .restart local v8       #valueIndex:I
    goto :goto_21
.end method

.method public static parseToRGB([BIZ)Landroid/graphics/Bitmap;
    .registers 14
    .parameter "data"
    .parameter "length"
    .parameter "transparency"

    .prologue
    .line 435
    const/4 v6, 0x0

    .line 436
    .local v6, valueIndex:I
    add-int/lit8 v7, v6, 0x1

    .end local v6           #valueIndex:I
    .local v7, valueIndex:I
    aget-byte v9, p0, v6

    and-int/lit16 v8, v9, 0xff

    .line 437
    .local v8, width:I
    add-int/lit8 v6, v7, 0x1

    .end local v7           #valueIndex:I
    .restart local v6       #valueIndex:I
    aget-byte v9, p0, v7

    and-int/lit16 v4, v9, 0xff

    .line 438
    .local v4, height:I
    add-int/lit8 v7, v6, 0x1

    .end local v6           #valueIndex:I
    .restart local v7       #valueIndex:I
    aget-byte v9, p0, v6

    and-int/lit16 v0, v9, 0xff

    .line 439
    .local v0, bits:I
    add-int/lit8 v6, v7, 0x1

    .end local v7           #valueIndex:I
    .restart local v6       #valueIndex:I
    aget-byte v9, p0, v7

    and-int/lit16 v3, v9, 0xff

    .line 440
    .local v3, colorNumber:I
    add-int/lit8 v7, v6, 0x1

    .end local v6           #valueIndex:I
    .restart local v7       #valueIndex:I
    aget-byte v9, p0, v6

    and-int/lit16 v9, v9, 0xff

    shl-int/lit8 v9, v9, 0x8

    add-int/lit8 v6, v7, 0x1

    .end local v7           #valueIndex:I
    .restart local v6       #valueIndex:I
    aget-byte v10, p0, v7

    and-int/lit16 v10, v10, 0xff

    or-int v1, v9, v10

    .line 443
    .local v1, clutOffset:I
    invoke-static {p0, v1, v3}, Lcom/android/internal/telephony/IccUtils;->getCLUT([BII)[I

    move-result-object v2

    .line 444
    .local v2, colorIndexArray:[I
    const/4 v9, 0x1

    if-ne v9, p2, :cond_35

    .line 445
    add-int/lit8 v9, v3, -0x1

    const/4 v10, 0x0

    aput v10, v2, v9

    .line 448
    :cond_35
    const/4 v5, 0x0

    .line 449
    .local v5, resultArray:[I
    const/16 v9, 0x8

    rem-int/2addr v9, v0

    if-nez v9, :cond_48

    .line 450
    mul-int v9, v8, v4

    invoke-static {p0, v6, v9, v2, v0}, Lcom/android/internal/telephony/IccUtils;->mapTo2OrderBitColor([BII[II)[I

    move-result-object v5

    .line 457
    :goto_41
    sget-object v9, Landroid/graphics/Bitmap$Config;->RGB_565:Landroid/graphics/Bitmap$Config;

    invoke-static {v5, v8, v4, v9}, Landroid/graphics/Bitmap;->createBitmap([IIILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v9

    return-object v9

    .line 453
    :cond_48
    mul-int v9, v8, v4

    invoke-static {p0, v6, v9, v2, v0}, Lcom/android/internal/telephony/IccUtils;->mapToNon2OrderBitColor([BII[II)[I

    move-result-object v5

    goto :goto_41
.end method
