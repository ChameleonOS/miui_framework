.class public Lcom/android/internal/telephony/gsm/GsmSmsCbMessage;
.super Ljava/lang/Object;
.source "GsmSmsCbMessage.java"


# static fields
.field private static final CARRIAGE_RETURN:C = '\r'

.field private static final LANGUAGE_CODES_GROUP_0:[Ljava/lang/String; = null

.field private static final LANGUAGE_CODES_GROUP_2:[Ljava/lang/String; = null

.field private static final PDU_BODY_PAGE_LENGTH:I = 0x52


# direct methods
.method static constructor <clinit>()V
    .registers 8

    .prologue
    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    const/4 v3, 0x0

    .line 36
    const/16 v0, 0x10

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "de"

    aput-object v1, v0, v4

    const-string v1, "en"

    aput-object v1, v0, v5

    const-string v1, "it"

    aput-object v1, v0, v6

    const-string v1, "fr"

    aput-object v1, v0, v7

    const/4 v1, 0x4

    const-string v2, "es"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string/jumbo v2, "nl"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string/jumbo v2, "sv"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "da"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string/jumbo v2, "pt"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "fi"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string/jumbo v2, "no"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string v2, "el"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string/jumbo v2, "tr"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string v2, "hu"

    aput-object v2, v0, v1

    const/16 v1, 0xe

    const-string/jumbo v2, "pl"

    aput-object v2, v0, v1

    const/16 v1, 0xf

    aput-object v3, v0, v1

    sput-object v0, Lcom/android/internal/telephony/gsm/GsmSmsCbMessage;->LANGUAGE_CODES_GROUP_0:[Ljava/lang/String;

    .line 44
    const/16 v0, 0x10

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "cs"

    aput-object v1, v0, v4

    const-string v1, "he"

    aput-object v1, v0, v5

    const-string v1, "ar"

    aput-object v1, v0, v6

    const-string/jumbo v1, "ru"

    aput-object v1, v0, v7

    const/4 v1, 0x4

    const-string v2, "is"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    aput-object v3, v0, v1

    const/4 v1, 0x6

    aput-object v3, v0, v1

    const/4 v1, 0x7

    aput-object v3, v0, v1

    const/16 v1, 0x8

    aput-object v3, v0, v1

    const/16 v1, 0x9

    aput-object v3, v0, v1

    const/16 v1, 0xa

    aput-object v3, v0, v1

    const/16 v1, 0xb

    aput-object v3, v0, v1

    const/16 v1, 0xc

    aput-object v3, v0, v1

    const/16 v1, 0xd

    aput-object v3, v0, v1

    const/16 v1, 0xe

    aput-object v3, v0, v1

    const/16 v1, 0xf

    aput-object v3, v0, v1

    sput-object v0, Lcom/android/internal/telephony/gsm/GsmSmsCbMessage;->LANGUAGE_CODES_GROUP_2:[Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .prologue
    .line 54
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static createSmsCbMessage(Landroid/telephony/SmsCbLocation;[[B)Landroid/telephony/SmsCbMessage;
    .registers 4
    .parameter "location"
    .parameter "pdus"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 96
    new-instance v0, Lcom/android/internal/telephony/gsm/SmsCbHeader;

    const/4 v1, 0x0

    aget-object v1, p1, v1

    invoke-direct {v0, v1}, Lcom/android/internal/telephony/gsm/SmsCbHeader;-><init>([B)V

    .line 97
    .local v0, header:Lcom/android/internal/telephony/gsm/SmsCbHeader;
    invoke-static {v0, p0, p1}, Lcom/android/internal/telephony/gsm/GsmSmsCbMessage;->createSmsCbMessage(Lcom/android/internal/telephony/gsm/SmsCbHeader;Landroid/telephony/SmsCbLocation;[[B)Landroid/telephony/SmsCbMessage;

    move-result-object v1

    return-object v1
.end method

.method static createSmsCbMessage(Lcom/android/internal/telephony/gsm/SmsCbHeader;Landroid/telephony/SmsCbLocation;[[B)Landroid/telephony/SmsCbMessage;
    .registers 22
    .parameter "header"
    .parameter "location"
    .parameter "pdus"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 63
    invoke-virtual/range {p0 .. p0}, Lcom/android/internal/telephony/gsm/SmsCbHeader;->isEtwsPrimaryNotification()Z

    move-result v2

    if-eqz v2, :cond_27

    .line 64
    new-instance v2, Landroid/telephony/SmsCbMessage;

    const/4 v3, 0x1

    invoke-virtual/range {p0 .. p0}, Lcom/android/internal/telephony/gsm/SmsCbHeader;->getGeographicalScope()I

    move-result v4

    invoke-virtual/range {p0 .. p0}, Lcom/android/internal/telephony/gsm/SmsCbHeader;->getSerialNumber()I

    move-result v5

    invoke-virtual/range {p0 .. p0}, Lcom/android/internal/telephony/gsm/SmsCbHeader;->getServiceCategory()I

    move-result v7

    const/4 v8, 0x0

    const-string v9, "ETWS"

    const/4 v10, 0x3

    invoke-virtual/range {p0 .. p0}, Lcom/android/internal/telephony/gsm/SmsCbHeader;->getEtwsInfo()Landroid/telephony/SmsCbEtwsInfo;

    move-result-object v11

    invoke-virtual/range {p0 .. p0}, Lcom/android/internal/telephony/gsm/SmsCbHeader;->getCmasInfo()Landroid/telephony/SmsCbCmasInfo;

    move-result-object v12

    move-object/from16 v6, p1

    invoke-direct/range {v2 .. v12}, Landroid/telephony/SmsCbMessage;-><init>(IIILandroid/telephony/SmsCbLocation;ILjava/lang/String;Ljava/lang/String;ILandroid/telephony/SmsCbEtwsInfo;Landroid/telephony/SmsCbCmasInfo;)V

    .line 80
    :goto_26
    return-object v2

    .line 70
    :cond_27
    const/4 v8, 0x0

    .line 71
    .local v8, language:Ljava/lang/String;
    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    .line 72
    .local v18, sb:Ljava/lang/StringBuilder;
    move-object/from16 v13, p2

    .local v13, arr$:[[B
    array-length v15, v13

    .local v15, len$:I
    const/4 v14, 0x0

    .local v14, i$:I
    :goto_31
    if-ge v14, v15, :cond_51

    aget-object v17, v13, v14

    .line 73
    .local v17, pdu:[B
    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-static {v0, v1}, Lcom/android/internal/telephony/gsm/GsmSmsCbMessage;->parseBody(Lcom/android/internal/telephony/gsm/SmsCbHeader;[B)Landroid/util/Pair;

    move-result-object v16

    .line 74
    .local v16, p:Landroid/util/Pair;,"Landroid/util/Pair<Ljava/lang/String;Ljava/lang/String;>;"
    move-object/from16 v0, v16

    iget-object v8, v0, Landroid/util/Pair;->first:Ljava/lang/Object;

    .end local v8           #language:Ljava/lang/String;
    check-cast v8, Ljava/lang/String;

    .line 75
    .restart local v8       #language:Ljava/lang/String;
    move-object/from16 v0, v16

    iget-object v2, v0, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v2, Ljava/lang/String;

    move-object/from16 v0, v18

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 72
    add-int/lit8 v14, v14, 0x1

    goto :goto_31

    .line 77
    .end local v16           #p:Landroid/util/Pair;,"Landroid/util/Pair<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v17           #pdu:[B
    :cond_51
    invoke-virtual/range {p0 .. p0}, Lcom/android/internal/telephony/gsm/SmsCbHeader;->isEmergencyMessage()Z

    move-result v2

    if-eqz v2, :cond_79

    const/4 v10, 0x3

    .line 80
    .local v10, priority:I
    :goto_58
    new-instance v2, Landroid/telephony/SmsCbMessage;

    const/4 v3, 0x1

    invoke-virtual/range {p0 .. p0}, Lcom/android/internal/telephony/gsm/SmsCbHeader;->getGeographicalScope()I

    move-result v4

    invoke-virtual/range {p0 .. p0}, Lcom/android/internal/telephony/gsm/SmsCbHeader;->getSerialNumber()I

    move-result v5

    invoke-virtual/range {p0 .. p0}, Lcom/android/internal/telephony/gsm/SmsCbHeader;->getServiceCategory()I

    move-result v7

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual/range {p0 .. p0}, Lcom/android/internal/telephony/gsm/SmsCbHeader;->getEtwsInfo()Landroid/telephony/SmsCbEtwsInfo;

    move-result-object v11

    invoke-virtual/range {p0 .. p0}, Lcom/android/internal/telephony/gsm/SmsCbHeader;->getCmasInfo()Landroid/telephony/SmsCbCmasInfo;

    move-result-object v12

    move-object/from16 v6, p1

    invoke-direct/range {v2 .. v12}, Landroid/telephony/SmsCbMessage;-><init>(IIILandroid/telephony/SmsCbLocation;ILjava/lang/String;Ljava/lang/String;ILandroid/telephony/SmsCbEtwsInfo;Landroid/telephony/SmsCbCmasInfo;)V

    goto :goto_26

    .line 77
    .end local v10           #priority:I
    :cond_79
    const/4 v10, 0x0

    goto :goto_58
.end method

.method private static parseBody(Lcom/android/internal/telephony/gsm/SmsCbHeader;[B)Landroid/util/Pair;
    .registers 16
    .parameter "header"
    .parameter "pdu"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/android/internal/telephony/gsm/SmsCbHeader;",
            "[B)",
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/16 v13, 0x52

    const/4 v11, 0x1

    .line 111
    const/4 v5, 0x0

    .line 112
    .local v5, language:Ljava/lang/String;
    const/4 v4, 0x0

    .line 113
    .local v4, hasLanguageIndicator:Z
    invoke-virtual {p0}, Lcom/android/internal/telephony/gsm/SmsCbHeader;->getDataCodingScheme()I

    move-result v6

    .line 117
    .local v6, dataCodingScheme:I
    and-int/lit16 v0, v6, 0xf0

    shr-int/lit8 v0, v0, 0x4

    packed-switch v0, :pswitch_data_f4

    .line 179
    :pswitch_10
    const/4 v1, 0x1

    .line 183
    .local v1, encoding:I
    :goto_11
    invoke-virtual {p0}, Lcom/android/internal/telephony/gsm/SmsCbHeader;->isUmtsFormat()Z

    move-result v0

    if-eqz v0, :cond_ea

    .line 185
    const/4 v0, 0x6

    aget-byte v8, p1, v0

    .line 187
    .local v8, nrPages:I
    array-length v0, p1

    mul-int/lit8 v11, v8, 0x53

    add-int/lit8 v11, v11, 0x7

    if-ge v0, v11, :cond_98

    .line 189
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "Pdu length "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    array-length v12, p1

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, " does not match "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, " pages"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-direct {v0, v11}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 119
    .end local v1           #encoding:I
    .end local v8           #nrPages:I
    :pswitch_4b
    const/4 v1, 0x1

    .line 120
    .restart local v1       #encoding:I
    sget-object v0, Lcom/android/internal/telephony/gsm/GsmSmsCbMessage;->LANGUAGE_CODES_GROUP_0:[Ljava/lang/String;

    and-int/lit8 v11, v6, 0xf

    aget-object v5, v0, v11

    .line 121
    goto :goto_11

    .line 124
    .end local v1           #encoding:I
    :pswitch_53
    const/4 v4, 0x1

    .line 125
    and-int/lit8 v0, v6, 0xf

    if-ne v0, v11, :cond_5a

    .line 126
    const/4 v1, 0x3

    .restart local v1       #encoding:I
    goto :goto_11

    .line 128
    .end local v1           #encoding:I
    :cond_5a
    const/4 v1, 0x1

    .line 130
    .restart local v1       #encoding:I
    goto :goto_11

    .line 133
    .end local v1           #encoding:I
    :pswitch_5c
    const/4 v1, 0x1

    .line 134
    .restart local v1       #encoding:I
    sget-object v0, Lcom/android/internal/telephony/gsm/GsmSmsCbMessage;->LANGUAGE_CODES_GROUP_2:[Ljava/lang/String;

    and-int/lit8 v11, v6, 0xf

    aget-object v5, v0, v11

    .line 135
    goto :goto_11

    .line 138
    .end local v1           #encoding:I
    :pswitch_64
    const/4 v1, 0x1

    .line 139
    .restart local v1       #encoding:I
    goto :goto_11

    .line 143
    .end local v1           #encoding:I
    :pswitch_66
    and-int/lit8 v0, v6, 0xc

    shr-int/lit8 v0, v0, 0x2

    packed-switch v0, :pswitch_data_118

    .line 154
    const/4 v1, 0x1

    .line 155
    .restart local v1       #encoding:I
    goto :goto_11

    .line 145
    .end local v1           #encoding:I
    :pswitch_6f
    const/4 v1, 0x2

    .line 146
    .restart local v1       #encoding:I
    goto :goto_11

    .line 149
    .end local v1           #encoding:I
    :pswitch_71
    const/4 v1, 0x3

    .line 150
    .restart local v1       #encoding:I
    goto :goto_11

    .line 166
    .end local v1           #encoding:I
    :pswitch_73
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "Unsupported GSM dataCodingScheme "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-direct {v0, v11}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 170
    :pswitch_8c
    and-int/lit8 v0, v6, 0x4

    shr-int/lit8 v0, v0, 0x2

    if-ne v0, v11, :cond_95

    .line 171
    const/4 v1, 0x2

    .restart local v1       #encoding:I
    goto/16 :goto_11

    .line 173
    .end local v1           #encoding:I
    :cond_95
    const/4 v1, 0x1

    .line 175
    .restart local v1       #encoding:I
    goto/16 :goto_11

    .line 193
    .restart local v8       #nrPages:I
    :cond_98
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    .line 195
    .local v10, sb:Ljava/lang/StringBuilder;
    const/4 v7, 0x0

    .local v7, i:I
    :goto_9e
    if-ge v7, v8, :cond_e0

    .line 198
    mul-int/lit8 v0, v7, 0x53

    add-int/lit8 v2, v0, 0x7

    .line 199
    .local v2, offset:I
    add-int/lit8 v0, v2, 0x52

    aget-byte v3, p1, v0

    .line 201
    .local v3, length:I
    if-le v3, v13, :cond_cd

    .line 202
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "Page length "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, " exceeds maximum value "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v13}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-direct {v0, v11}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_cd
    move-object v0, p1

    .line 206
    invoke-static/range {v0 .. v5}, Lcom/android/internal/telephony/gsm/GsmSmsCbMessage;->unpackBody([BIIIZLjava/lang/String;)Landroid/util/Pair;

    move-result-object v9

    .line 208
    .local v9, p:Landroid/util/Pair;,"Landroid/util/Pair<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v5, v9, Landroid/util/Pair;->first:Ljava/lang/Object;

    .end local v5           #language:Ljava/lang/String;
    check-cast v5, Ljava/lang/String;

    .line 209
    .restart local v5       #language:Ljava/lang/String;
    iget-object v0, v9, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v10, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 195
    add-int/lit8 v7, v7, 0x1

    goto :goto_9e

    .line 211
    .end local v2           #offset:I
    .end local v3           #length:I
    .end local v9           #p:Landroid/util/Pair;,"Landroid/util/Pair<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_e0
    new-instance v0, Landroid/util/Pair;

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-direct {v0, v5, v11}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 217
    .end local v7           #i:I
    .end local v8           #nrPages:I
    .end local v10           #sb:Ljava/lang/StringBuilder;
    :goto_e9
    return-object v0

    .line 214
    :cond_ea
    const/4 v2, 0x6

    .line 215
    .restart local v2       #offset:I
    array-length v0, p1

    sub-int v3, v0, v2

    .restart local v3       #length:I
    move-object v0, p1

    .line 217
    invoke-static/range {v0 .. v5}, Lcom/android/internal/telephony/gsm/GsmSmsCbMessage;->unpackBody([BIIIZLjava/lang/String;)Landroid/util/Pair;

    move-result-object v0

    goto :goto_e9

    .line 117
    :pswitch_data_f4
    .packed-switch 0x0
        :pswitch_4b
        :pswitch_53
        :pswitch_5c
        :pswitch_64
        :pswitch_66
        :pswitch_66
        :pswitch_73
        :pswitch_73
        :pswitch_10
        :pswitch_73
        :pswitch_10
        :pswitch_10
        :pswitch_10
        :pswitch_10
        :pswitch_73
        :pswitch_8c
    .end packed-switch

    .line 143
    :pswitch_data_118
    .packed-switch 0x1
        :pswitch_6f
        :pswitch_71
    .end packed-switch
.end method

.method private static unpackBody([BIIIZLjava/lang/String;)Landroid/util/Pair;
    .registers 13
    .parameter "pdu"
    .parameter "encoding"
    .parameter "offset"
    .parameter "length"
    .parameter "hasLanguageIndicator"
    .parameter "language"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([BIIIZ",
            "Ljava/lang/String;",
            ")",
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x2

    .line 237
    const/4 v0, 0x0

    .line 239
    .local v0, body:Ljava/lang/String;
    packed-switch p1, :pswitch_data_6c

    .line 272
    :cond_6
    :goto_6
    :pswitch_6
    if-eqz v0, :cond_68

    .line 274
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v3

    add-int/lit8 v2, v3, -0x1

    .local v2, i:I
    :goto_e
    if-ltz v2, :cond_1e

    .line 275
    invoke-virtual {v0, v2}, Ljava/lang/String;->charAt(I)C

    move-result v3

    const/16 v4, 0xd

    if-eq v3, v4, :cond_65

    .line 276
    add-int/lit8 v3, v2, 0x1

    invoke-virtual {v0, v6, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 284
    .end local v2           #i:I
    :cond_1e
    :goto_1e
    new-instance v3, Landroid/util/Pair;

    invoke-direct {v3, p5, v0}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    return-object v3

    .line 241
    :pswitch_24
    mul-int/lit8 v3, p3, 0x8

    div-int/lit8 v3, v3, 0x7

    invoke-static {p0, p2, v3}, Lcom/android/internal/telephony/GsmAlphabet;->gsm7BitPackedToString([BII)Ljava/lang/String;

    move-result-object v0

    .line 243
    if-eqz p4, :cond_6

    if-eqz v0, :cond_6

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v3

    if-le v3, v5, :cond_6

    .line 246
    invoke-virtual {v0, v6, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p5

    .line 247
    const/4 v3, 0x3

    invoke-virtual {v0, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_6

    .line 252
    :pswitch_40
    if-eqz p4, :cond_4f

    array-length v3, p0

    add-int/lit8 v4, p2, 0x2

    if-lt v3, v4, :cond_4f

    .line 255
    invoke-static {p0, p2, v5}, Lcom/android/internal/telephony/GsmAlphabet;->gsm7BitPackedToString([BII)Ljava/lang/String;

    move-result-object p5

    .line 256
    add-int/lit8 p2, p2, 0x2

    .line 257
    add-int/lit8 p3, p3, -0x2

    .line 261
    :cond_4f
    :try_start_4f
    new-instance v0, Ljava/lang/String;

    .end local v0           #body:Ljava/lang/String;
    const v3, 0xfffe

    and-int/2addr v3, p3

    const-string/jumbo v4, "utf-16"

    invoke-direct {v0, p0, p2, v3, v4}, Ljava/lang/String;-><init>([BIILjava/lang/String;)V
    :try_end_5b
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_4f .. :try_end_5b} :catch_5c

    .restart local v0       #body:Ljava/lang/String;
    goto :goto_6

    .line 262
    .end local v0           #body:Ljava/lang/String;
    :catch_5c
    move-exception v1

    .line 264
    .local v1, e:Ljava/io/UnsupportedEncodingException;
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string v4, "Error decoding UTF-16 message"

    invoke-direct {v3, v4, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3

    .line 274
    .end local v1           #e:Ljava/io/UnsupportedEncodingException;
    .restart local v0       #body:Ljava/lang/String;
    .restart local v2       #i:I
    :cond_65
    add-int/lit8 v2, v2, -0x1

    goto :goto_e

    .line 281
    .end local v2           #i:I
    :cond_68
    const-string v0, ""

    goto :goto_1e

    .line 239
    nop

    :pswitch_data_6c
    .packed-switch 0x1
        :pswitch_24
        :pswitch_6
        :pswitch_40
    .end packed-switch
.end method
