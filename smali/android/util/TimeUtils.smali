.class public Landroid/util/TimeUtils;
.super Ljava/lang/Object;
.source "TimeUtils.java"


# static fields
.field private static final DBG:Z = false

.field public static final HUNDRED_DAY_FIELD_LEN:I = 0x13

.field private static final SECONDS_PER_DAY:I = 0x15180

.field private static final SECONDS_PER_HOUR:I = 0xe10

.field private static final SECONDS_PER_MINUTE:I = 0x3c

.field private static final TAG:Ljava/lang/String; = "TimeUtils"

.field private static sFormatStr:[C

.field private static final sFormatSync:Ljava/lang/Object;

.field private static sLastCountry:Ljava/lang/String;

.field private static final sLastLockObj:Ljava/lang/Object;

.field private static sLastUniqueCountry:Ljava/lang/String;

.field private static final sLastUniqueLockObj:Ljava/lang/Object;

.field private static sLastUniqueZoneOffsets:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/TimeZone;",
            ">;"
        }
    .end annotation
.end field

.field private static sLastZones:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/TimeZone;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 2

    .prologue
    const/4 v1, 0x0

    .line 45
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Landroid/util/TimeUtils;->sLastLockObj:Ljava/lang/Object;

    .line 46
    sput-object v1, Landroid/util/TimeUtils;->sLastZones:Ljava/util/ArrayList;

    .line 47
    sput-object v1, Landroid/util/TimeUtils;->sLastCountry:Ljava/lang/String;

    .line 50
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Landroid/util/TimeUtils;->sLastUniqueLockObj:Ljava/lang/Object;

    .line 51
    sput-object v1, Landroid/util/TimeUtils;->sLastUniqueZoneOffsets:Ljava/util/ArrayList;

    .line 52
    sput-object v1, Landroid/util/TimeUtils;->sLastUniqueCountry:Ljava/lang/String;

    .line 245
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Landroid/util/TimeUtils;->sFormatSync:Ljava/lang/Object;

    .line 246
    const/16 v0, 0x18

    new-array v0, v0, [C

    sput-object v0, Landroid/util/TimeUtils;->sFormatStr:[C

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 40
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static accumField(IIZI)I
    .registers 5
    .parameter "amt"
    .parameter "suffix"
    .parameter "always"
    .parameter "zeropad"

    .prologue
    .line 249
    const/16 v0, 0x63

    if-gt p0, v0, :cond_9

    if-eqz p2, :cond_c

    const/4 v0, 0x3

    if-lt p3, v0, :cond_c

    .line 250
    :cond_9
    add-int/lit8 v0, p1, 0x3

    .line 258
    :goto_b
    return v0

    .line 252
    :cond_c
    const/16 v0, 0x9

    if-gt p0, v0, :cond_15

    if-eqz p2, :cond_18

    const/4 v0, 0x2

    if-lt p3, v0, :cond_18

    .line 253
    :cond_15
    add-int/lit8 v0, p1, 0x2

    goto :goto_b

    .line 255
    :cond_18
    if-nez p2, :cond_1c

    if-lez p0, :cond_1f

    .line 256
    :cond_1c
    add-int/lit8 v0, p1, 0x1

    goto :goto_b

    .line 258
    :cond_1f
    const/4 v0, 0x0

    goto :goto_b
.end method

.method public static formatDuration(JJLjava/io/PrintWriter;)V
    .registers 8
    .parameter "time"
    .parameter "now"
    .parameter "pw"

    .prologue
    .line 379
    const-wide/16 v0, 0x0

    cmp-long v0, p0, v0

    if-nez v0, :cond_c

    .line 380
    const-string v0, "--"

    invoke-virtual {p4, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 384
    :goto_b
    return-void

    .line 383
    :cond_c
    sub-long v0, p0, p2

    const/4 v2, 0x0

    invoke-static {v0, v1, p4, v2}, Landroid/util/TimeUtils;->formatDuration(JLjava/io/PrintWriter;I)V

    goto :goto_b
.end method

.method public static formatDuration(JLjava/io/PrintWriter;)V
    .registers 4
    .parameter "duration"
    .parameter "pw"

    .prologue
    .line 374
    const/4 v0, 0x0

    invoke-static {p0, p1, p2, v0}, Landroid/util/TimeUtils;->formatDuration(JLjava/io/PrintWriter;I)V

    .line 375
    return-void
.end method

.method public static formatDuration(JLjava/io/PrintWriter;I)V
    .registers 9
    .parameter "duration"
    .parameter "pw"
    .parameter "fieldLen"

    .prologue
    .line 366
    sget-object v2, Landroid/util/TimeUtils;->sFormatSync:Ljava/lang/Object;

    monitor-enter v2

    .line 367
    :try_start_3
    invoke-static {p0, p1, p3}, Landroid/util/TimeUtils;->formatDurationLocked(JI)I

    move-result v0

    .line 368
    .local v0, len:I
    new-instance v1, Ljava/lang/String;

    sget-object v3, Landroid/util/TimeUtils;->sFormatStr:[C

    const/4 v4, 0x0

    invoke-direct {v1, v3, v4, v0}, Ljava/lang/String;-><init>([CII)V

    invoke-virtual {p2, v1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 369
    monitor-exit v2

    .line 370
    return-void

    .line 369
    .end local v0           #len:I
    :catchall_14
    move-exception v1

    monitor-exit v2
    :try_end_16
    .catchall {:try_start_3 .. :try_end_16} :catchall_14

    throw v1
.end method

.method public static formatDuration(JLjava/lang/StringBuilder;)V
    .registers 7
    .parameter "duration"
    .parameter "builder"

    .prologue
    .line 358
    sget-object v2, Landroid/util/TimeUtils;->sFormatSync:Ljava/lang/Object;

    monitor-enter v2

    .line 359
    const/4 v1, 0x0

    :try_start_4
    invoke-static {p0, p1, v1}, Landroid/util/TimeUtils;->formatDurationLocked(JI)I

    move-result v0

    .line 360
    .local v0, len:I
    sget-object v1, Landroid/util/TimeUtils;->sFormatStr:[C

    const/4 v3, 0x0

    invoke-virtual {p2, v1, v3, v0}, Ljava/lang/StringBuilder;->append([CII)Ljava/lang/StringBuilder;

    .line 361
    monitor-exit v2

    .line 362
    return-void

    .line 361
    .end local v0           #len:I
    :catchall_10
    move-exception v1

    monitor-exit v2
    :try_end_12
    .catchall {:try_start_4 .. :try_end_12} :catchall_10

    throw v1
.end method

.method private static formatDurationLocked(JI)I
    .registers 24
    .parameter "duration"
    .parameter "fieldLen"

    .prologue
    .line 286
    sget-object v4, Landroid/util/TimeUtils;->sFormatStr:[C

    array-length v4, v4

    move/from16 v0, p2

    if-ge v4, v0, :cond_d

    .line 287
    move/from16 v0, p2

    new-array v4, v0, [C

    sput-object v4, Landroid/util/TimeUtils;->sFormatStr:[C

    .line 290
    :cond_d
    sget-object v2, Landroid/util/TimeUtils;->sFormatStr:[C

    .line 292
    .local v2, formatStr:[C
    const-wide/16 v6, 0x0

    cmp-long v4, p0, v6

    if-nez v4, :cond_30

    .line 293
    const/4 v5, 0x0

    .line 294
    .local v5, pos:I
    add-int/lit8 p2, p2, -0x1

    move/from16 v16, v5

    .line 295
    .end local v5           #pos:I
    .local v16, pos:I
    :goto_1a
    move/from16 v0, v16

    move/from16 v1, p2

    if-ge v0, v1, :cond_29

    .line 296
    add-int/lit8 v5, v16, 0x1

    .end local v16           #pos:I
    .restart local v5       #pos:I
    const/16 v4, 0x20

    aput-char v4, v2, v16

    move/from16 v16, v5

    .end local v5           #pos:I
    .restart local v16       #pos:I
    goto :goto_1a

    .line 298
    :cond_29
    const/16 v4, 0x30

    aput-char v4, v2, v16

    .line 299
    add-int/lit8 v4, v16, 0x1

    .line 353
    .end local v16           #pos:I
    :goto_2f
    return v4

    .line 303
    :cond_30
    const-wide/16 v6, 0x0

    cmp-long v4, p0, v6

    if-lez v4, :cond_bb

    .line 304
    const/16 v17, 0x2b

    .line 310
    .local v17, prefix:C
    :goto_38
    const-wide/16 v6, 0x3e8

    rem-long v6, p0, v6

    long-to-int v13, v6

    .line 311
    .local v13, millis:I
    const-wide/16 v6, 0x3e8

    div-long v6, p0, v6

    long-to-double v6, v6

    invoke-static {v6, v7}, Ljava/lang/Math;->floor(D)D

    move-result-wide v6

    double-to-int v0, v6

    move/from16 v18, v0

    .line 312
    .local v18, seconds:I
    const/4 v3, 0x0

    .local v3, days:I
    const/4 v12, 0x0

    .local v12, hours:I
    const/4 v14, 0x0

    .line 314
    .local v14, minutes:I
    const v4, 0x15180

    move/from16 v0, v18

    if-le v0, v4, :cond_5e

    .line 315
    const v4, 0x15180

    div-int v3, v18, v4

    .line 316
    const v4, 0x15180

    mul-int/2addr v4, v3

    sub-int v18, v18, v4

    .line 318
    :cond_5e
    const/16 v4, 0xe10

    move/from16 v0, v18

    if-le v0, v4, :cond_6c

    .line 319
    move/from16 v0, v18

    div-int/lit16 v12, v0, 0xe10

    .line 320
    mul-int/lit16 v4, v12, 0xe10

    sub-int v18, v18, v4

    .line 322
    :cond_6c
    const/16 v4, 0x3c

    move/from16 v0, v18

    if-le v0, v4, :cond_78

    .line 323
    div-int/lit8 v14, v18, 0x3c

    .line 324
    mul-int/lit8 v4, v14, 0x3c

    sub-int v18, v18, v4

    .line 327
    :cond_78
    const/4 v5, 0x0

    .line 329
    .restart local v5       #pos:I
    if-eqz p2, :cond_cc

    .line 330
    const/4 v4, 0x1

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-static {v3, v4, v6, v7}, Landroid/util/TimeUtils;->accumField(IIZI)I

    move-result v15

    .line 331
    .local v15, myLen:I
    const/4 v6, 0x1

    if-lez v15, :cond_c4

    const/4 v4, 0x1

    :goto_86
    const/4 v7, 0x2

    invoke-static {v12, v6, v4, v7}, Landroid/util/TimeUtils;->accumField(IIZI)I

    move-result v4

    add-int/2addr v15, v4

    .line 332
    const/4 v6, 0x1

    if-lez v15, :cond_c6

    const/4 v4, 0x1

    :goto_90
    const/4 v7, 0x2

    invoke-static {v14, v6, v4, v7}, Landroid/util/TimeUtils;->accumField(IIZI)I

    move-result v4

    add-int/2addr v15, v4

    .line 333
    const/4 v6, 0x1

    if-lez v15, :cond_c8

    const/4 v4, 0x1

    :goto_9a
    const/4 v7, 0x2

    move/from16 v0, v18

    invoke-static {v0, v6, v4, v7}, Landroid/util/TimeUtils;->accumField(IIZI)I

    move-result v4

    add-int/2addr v15, v4

    .line 334
    const/4 v6, 0x2

    const/4 v7, 0x1

    if-lez v15, :cond_ca

    const/4 v4, 0x3

    :goto_a7
    invoke-static {v13, v6, v7, v4}, Landroid/util/TimeUtils;->accumField(IIZI)I

    move-result v4

    add-int/lit8 v4, v4, 0x1

    add-int/2addr v15, v4

    .line 335
    :goto_ae
    move/from16 v0, p2

    if-ge v15, v0, :cond_cc

    .line 336
    const/16 v4, 0x20

    aput-char v4, v2, v5

    .line 337
    add-int/lit8 v5, v5, 0x1

    .line 338
    add-int/lit8 v15, v15, 0x1

    goto :goto_ae

    .line 306
    .end local v3           #days:I
    .end local v5           #pos:I
    .end local v12           #hours:I
    .end local v13           #millis:I
    .end local v14           #minutes:I
    .end local v15           #myLen:I
    .end local v17           #prefix:C
    .end local v18           #seconds:I
    :cond_bb
    const/16 v17, 0x2d

    .line 307
    .restart local v17       #prefix:C
    move-wide/from16 v0, p0

    neg-long v0, v0

    move-wide/from16 p0, v0

    goto/16 :goto_38

    .line 331
    .restart local v3       #days:I
    .restart local v5       #pos:I
    .restart local v12       #hours:I
    .restart local v13       #millis:I
    .restart local v14       #minutes:I
    .restart local v15       #myLen:I
    .restart local v18       #seconds:I
    :cond_c4
    const/4 v4, 0x0

    goto :goto_86

    .line 332
    :cond_c6
    const/4 v4, 0x0

    goto :goto_90

    .line 333
    :cond_c8
    const/4 v4, 0x0

    goto :goto_9a

    .line 334
    :cond_ca
    const/4 v4, 0x0

    goto :goto_a7

    .line 342
    .end local v15           #myLen:I
    :cond_cc
    aput-char v17, v2, v5

    .line 343
    add-int/lit8 v5, v5, 0x1

    .line 345
    move/from16 v19, v5

    .line 346
    .local v19, start:I
    if-eqz p2, :cond_12b

    const/16 v20, 0x1

    .line 347
    .local v20, zeropad:Z
    :goto_d6
    const/16 v4, 0x64

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-static/range {v2 .. v7}, Landroid/util/TimeUtils;->printField([CICIZI)I

    move-result v5

    .line 348
    const/16 v8, 0x68

    move/from16 v0, v19

    if-eq v5, v0, :cond_12e

    const/4 v10, 0x1

    :goto_e5
    if-eqz v20, :cond_130

    const/4 v11, 0x2

    :goto_e8
    move-object v6, v2

    move v7, v12

    move v9, v5

    invoke-static/range {v6 .. v11}, Landroid/util/TimeUtils;->printField([CICIZI)I

    move-result v5

    .line 349
    const/16 v8, 0x6d

    move/from16 v0, v19

    if-eq v5, v0, :cond_132

    const/4 v10, 0x1

    :goto_f6
    if-eqz v20, :cond_134

    const/4 v11, 0x2

    :goto_f9
    move-object v6, v2

    move v7, v14

    move v9, v5

    invoke-static/range {v6 .. v11}, Landroid/util/TimeUtils;->printField([CICIZI)I

    move-result v5

    .line 350
    const/16 v8, 0x73

    move/from16 v0, v19

    if-eq v5, v0, :cond_136

    const/4 v10, 0x1

    :goto_107
    if-eqz v20, :cond_138

    const/4 v11, 0x2

    :goto_10a
    move-object v6, v2

    move/from16 v7, v18

    move v9, v5

    invoke-static/range {v6 .. v11}, Landroid/util/TimeUtils;->printField([CICIZI)I

    move-result v5

    .line 351
    const/16 v8, 0x6d

    const/4 v10, 0x1

    if-eqz v20, :cond_13a

    move/from16 v0, v19

    if-eq v5, v0, :cond_13a

    const/4 v11, 0x3

    :goto_11c
    move-object v6, v2

    move v7, v13

    move v9, v5

    invoke-static/range {v6 .. v11}, Landroid/util/TimeUtils;->printField([CICIZI)I

    move-result v5

    .line 352
    const/16 v4, 0x73

    aput-char v4, v2, v5

    .line 353
    add-int/lit8 v4, v5, 0x1

    goto/16 :goto_2f

    .line 346
    .end local v20           #zeropad:Z
    :cond_12b
    const/16 v20, 0x0

    goto :goto_d6

    .line 348
    .restart local v20       #zeropad:Z
    :cond_12e
    const/4 v10, 0x0

    goto :goto_e5

    :cond_130
    const/4 v11, 0x0

    goto :goto_e8

    .line 349
    :cond_132
    const/4 v10, 0x0

    goto :goto_f6

    :cond_134
    const/4 v11, 0x0

    goto :goto_f9

    .line 350
    :cond_136
    const/4 v10, 0x0

    goto :goto_107

    :cond_138
    const/4 v11, 0x0

    goto :goto_10a

    .line 351
    :cond_13a
    const/4 v11, 0x0

    goto :goto_11c
.end method

.method public static getTimeZone(IZJLjava/lang/String;)Ljava/util/TimeZone;
    .registers 16
    .parameter "offset"
    .parameter "dst"
    .parameter "when"
    .parameter "country"

    .prologue
    .line 61
    const/4 v0, 0x0

    .line 63
    .local v0, best:Ljava/util/TimeZone;
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v8

    .line 64
    .local v8, r:Landroid/content/res/Resources;
    const v10, 0x10f000d

    invoke-virtual {v8, v10}, Landroid/content/res/Resources;->getXml(I)Landroid/content/res/XmlResourceParser;

    move-result-object v7

    .line 65
    .local v7, parser:Landroid/content/res/XmlResourceParser;
    new-instance v5, Ljava/util/Date;

    invoke-direct {v5, p2, p3}, Ljava/util/Date;-><init>(J)V

    .line 67
    .local v5, d:Ljava/util/Date;
    invoke-static {}, Ljava/util/TimeZone;->getDefault()Ljava/util/TimeZone;

    move-result-object v1

    .line 68
    .local v1, current:Ljava/util/TimeZone;
    invoke-virtual {v1}, Ljava/util/TimeZone;->getID()Ljava/lang/String;

    move-result-object v3

    .line 69
    .local v3, currentName:Ljava/lang/String;
    invoke-virtual {v1, p2, p3}, Ljava/util/TimeZone;->getOffset(J)I

    move-result v4

    .line 70
    .local v4, currentOffset:I
    invoke-virtual {v1, v5}, Ljava/util/TimeZone;->inDaylightTime(Ljava/util/Date;)Z

    move-result v2

    .line 72
    .local v2, currentDst:Z
    invoke-static {p4}, Landroid/util/TimeUtils;->getTimeZones(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v10

    invoke-virtual {v10}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .local v6, i$:Ljava/util/Iterator;
    :cond_29
    :goto_29
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_54

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/TimeZone;

    .line 77
    .local v9, tz:Ljava/util/TimeZone;
    invoke-virtual {v9}, Ljava/util/TimeZone;->getID()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v10, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_44

    .line 78
    if-ne v4, p0, :cond_44

    if-ne v2, p1, :cond_44

    .line 96
    .end local v1           #current:Ljava/util/TimeZone;
    .end local v9           #tz:Ljava/util/TimeZone;
    :goto_43
    return-object v1

    .line 88
    .restart local v1       #current:Ljava/util/TimeZone;
    .restart local v9       #tz:Ljava/util/TimeZone;
    :cond_44
    if-nez v0, :cond_29

    .line 89
    invoke-virtual {v9, p2, p3}, Ljava/util/TimeZone;->getOffset(J)I

    move-result v10

    if-ne v10, p0, :cond_29

    invoke-virtual {v9, v5}, Ljava/util/TimeZone;->inDaylightTime(Ljava/util/Date;)Z

    move-result v10

    if-ne v10, p1, :cond_29

    .line 91
    move-object v0, v9

    goto :goto_29

    .end local v9           #tz:Ljava/util/TimeZone;
    :cond_54
    move-object v1, v0

    .line 96
    goto :goto_43
.end method

.method public static getTimeZoneDatabaseVersion()Ljava/lang/String;
    .registers 1

    .prologue
    .line 235
    invoke-static {}, Llibcore/util/ZoneInfoDB;->getVersion()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getTimeZones(Ljava/lang/String;)Ljava/util/ArrayList;
    .registers 12
    .parameter "country"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/TimeZone;",
            ">;"
        }
    .end annotation

    .prologue
    .line 156
    sget-object v9, Landroid/util/TimeUtils;->sLastLockObj:Ljava/lang/Object;

    monitor-enter v9

    .line 157
    if-eqz p0, :cond_11

    :try_start_5
    sget-object v8, Landroid/util/TimeUtils;->sLastCountry:Ljava/lang/String;

    invoke-virtual {p0, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_11

    .line 159
    sget-object v6, Landroid/util/TimeUtils;->sLastZones:Ljava/util/ArrayList;

    monitor-exit v9

    .line 213
    :cond_10
    :goto_10
    return-object v6

    .line 161
    :cond_11
    monitor-exit v9
    :try_end_12
    .catchall {:try_start_5 .. :try_end_12} :catchall_4d

    .line 163
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 165
    .local v6, tzs:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/util/TimeZone;>;"
    if-eqz p0, :cond_10

    .line 170
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v4

    .line 171
    .local v4, r:Landroid/content/res/Resources;
    const v8, 0x10f000d

    invoke-virtual {v4, v8}, Landroid/content/res/Resources;->getXml(I)Landroid/content/res/XmlResourceParser;

    move-result-object v3

    .line 174
    .local v3, parser:Landroid/content/res/XmlResourceParser;
    :try_start_24
    const-string/jumbo v8, "timezones"

    invoke-static {v3, v8}, Lcom/android/internal/util/XmlUtils;->beginDocument(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)V

    .line 177
    :cond_2a
    :goto_2a
    invoke-static {v3}, Lcom/android/internal/util/XmlUtils;->nextElement(Lorg/xmlpull/v1/XmlPullParser;)V

    .line 179
    invoke-interface {v3}, Landroid/content/res/XmlResourceParser;->getName()Ljava/lang/String;

    move-result-object v2

    .line 180
    .local v2, element:Ljava/lang/String;
    if-eqz v2, :cond_3c

    const-string/jumbo v8, "timezone"

    invoke-virtual {v2, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_39
    .catchall {:try_start_24 .. :try_end_39} :catchall_c3
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_24 .. :try_end_39} :catch_7c
    .catch Ljava/io/IOException; {:try_start_24 .. :try_end_39} :catch_9f

    move-result v8

    if-nez v8, :cond_50

    .line 206
    :cond_3c
    invoke-interface {v3}, Landroid/content/res/XmlResourceParser;->close()V

    .line 209
    .end local v2           #element:Ljava/lang/String;
    :goto_3f
    sget-object v9, Landroid/util/TimeUtils;->sLastLockObj:Ljava/lang/Object;

    monitor-enter v9

    .line 211
    :try_start_42
    sput-object v6, Landroid/util/TimeUtils;->sLastZones:Ljava/util/ArrayList;

    .line 212
    sput-object p0, Landroid/util/TimeUtils;->sLastCountry:Ljava/lang/String;

    .line 213
    sget-object v6, Landroid/util/TimeUtils;->sLastZones:Ljava/util/ArrayList;

    .end local v6           #tzs:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/util/TimeZone;>;"
    monitor-exit v9

    goto :goto_10

    .line 214
    :catchall_4a
    move-exception v8

    monitor-exit v9
    :try_end_4c
    .catchall {:try_start_42 .. :try_end_4c} :catchall_4a

    throw v8

    .line 161
    .end local v3           #parser:Landroid/content/res/XmlResourceParser;
    .end local v4           #r:Landroid/content/res/Resources;
    :catchall_4d
    move-exception v8

    :try_start_4e
    monitor-exit v9
    :try_end_4f
    .catchall {:try_start_4e .. :try_end_4f} :catchall_4d

    throw v8

    .line 184
    .restart local v2       #element:Ljava/lang/String;
    .restart local v3       #parser:Landroid/content/res/XmlResourceParser;
    .restart local v4       #r:Landroid/content/res/Resources;
    .restart local v6       #tzs:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/util/TimeZone;>;"
    :cond_50
    const/4 v8, 0x0

    :try_start_51
    const-string v9, "code"

    invoke-interface {v3, v8, v9}, Landroid/content/res/XmlResourceParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 186
    .local v0, code:Ljava/lang/String;
    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_2a

    .line 187
    invoke-interface {v3}, Landroid/content/res/XmlResourceParser;->next()I

    move-result v8

    const/4 v9, 0x4

    if-ne v8, v9, :cond_2a

    .line 188
    invoke-interface {v3}, Landroid/content/res/XmlResourceParser;->getText()Ljava/lang/String;

    move-result-object v7

    .line 189
    .local v7, zoneIdString:Ljava/lang/String;
    invoke-static {v7}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v5

    .line 190
    .local v5, tz:Ljava/util/TimeZone;
    invoke-virtual {v5}, Ljava/util/TimeZone;->getID()Ljava/lang/String;

    move-result-object v8

    const-string v9, "GMT"

    invoke-virtual {v8, v9}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_2a

    .line 192
    invoke-virtual {v6, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_7b
    .catchall {:try_start_51 .. :try_end_7b} :catchall_c3
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_51 .. :try_end_7b} :catch_7c
    .catch Ljava/io/IOException; {:try_start_51 .. :try_end_7b} :catch_9f

    goto :goto_2a

    .line 201
    .end local v0           #code:Ljava/lang/String;
    .end local v2           #element:Ljava/lang/String;
    .end local v5           #tz:Ljava/util/TimeZone;
    .end local v7           #zoneIdString:Ljava/lang/String;
    :catch_7c
    move-exception v1

    .line 202
    .local v1, e:Lorg/xmlpull/v1/XmlPullParserException;
    :try_start_7d
    const-string v8, "TimeUtils"

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Got xml parser exception getTimeZone(\'"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "\'): e="

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_9b
    .catchall {:try_start_7d .. :try_end_9b} :catchall_c3

    .line 206
    invoke-interface {v3}, Landroid/content/res/XmlResourceParser;->close()V

    goto :goto_3f

    .line 203
    .end local v1           #e:Lorg/xmlpull/v1/XmlPullParserException;
    :catch_9f
    move-exception v1

    .line 204
    .local v1, e:Ljava/io/IOException;
    :try_start_a0
    const-string v8, "TimeUtils"

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Got IO exception getTimeZone(\'"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "\'): e="

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_be
    .catchall {:try_start_a0 .. :try_end_be} :catchall_c3

    .line 206
    invoke-interface {v3}, Landroid/content/res/XmlResourceParser;->close()V

    goto/16 :goto_3f

    .end local v1           #e:Ljava/io/IOException;
    :catchall_c3
    move-exception v8

    invoke-interface {v3}, Landroid/content/res/XmlResourceParser;->close()V

    throw v8
.end method

.method public static getTimeZonesWithUniqueOffsets(Ljava/lang/String;)Ljava/util/ArrayList;
    .registers 9
    .parameter "country"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/TimeZone;",
            ">;"
        }
    .end annotation

    .prologue
    .line 107
    sget-object v7, Landroid/util/TimeUtils;->sLastUniqueLockObj:Ljava/lang/Object;

    monitor-enter v7

    .line 108
    if-eqz p0, :cond_11

    :try_start_5
    sget-object v6, Landroid/util/TimeUtils;->sLastUniqueCountry:Ljava/lang/String;

    invoke-virtual {p0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_11

    .line 113
    sget-object v6, Landroid/util/TimeUtils;->sLastUniqueZoneOffsets:Ljava/util/ArrayList;

    monitor-exit v7

    .line 143
    :goto_10
    return-object v6

    .line 115
    :cond_11
    monitor-exit v7
    :try_end_12
    .catchall {:try_start_5 .. :try_end_12} :catchall_4a

    .line 117
    invoke-static {p0}, Landroid/util/TimeUtils;->getTimeZones(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v5

    .line 118
    .local v5, zones:Ljava/util/Collection;,"Ljava/util/Collection<Ljava/util/TimeZone;>;"
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 119
    .local v3, uniqueTimeZones:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/util/TimeZone;>;"
    invoke-interface {v5}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, i$:Ljava/util/Iterator;
    :cond_1f
    :goto_1f
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_50

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/TimeZone;

    .line 122
    .local v4, zone:Ljava/util/TimeZone;
    const/4 v0, 0x0

    .line 123
    .local v0, found:Z
    const/4 v1, 0x0

    .local v1, i:I
    :goto_2d
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v6

    if-ge v1, v6, :cond_44

    .line 124
    invoke-virtual {v3, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/TimeZone;

    invoke-virtual {v6}, Ljava/util/TimeZone;->getRawOffset()I

    move-result v6

    invoke-virtual {v4}, Ljava/util/TimeZone;->getRawOffset()I

    move-result v7

    if-ne v6, v7, :cond_4d

    .line 125
    const/4 v0, 0x1

    .line 129
    :cond_44
    if-nez v0, :cond_1f

    .line 134
    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1f

    .line 115
    .end local v0           #found:Z
    .end local v1           #i:I
    .end local v2           #i$:Ljava/util/Iterator;
    .end local v3           #uniqueTimeZones:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/util/TimeZone;>;"
    .end local v4           #zone:Ljava/util/TimeZone;
    .end local v5           #zones:Ljava/util/Collection;,"Ljava/util/Collection<Ljava/util/TimeZone;>;"
    :catchall_4a
    move-exception v6

    :try_start_4b
    monitor-exit v7
    :try_end_4c
    .catchall {:try_start_4b .. :try_end_4c} :catchall_4a

    throw v6

    .line 123
    .restart local v0       #found:Z
    .restart local v1       #i:I
    .restart local v2       #i$:Ljava/util/Iterator;
    .restart local v3       #uniqueTimeZones:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/util/TimeZone;>;"
    .restart local v4       #zone:Ljava/util/TimeZone;
    .restart local v5       #zones:Ljava/util/Collection;,"Ljava/util/Collection<Ljava/util/TimeZone;>;"
    :cond_4d
    add-int/lit8 v1, v1, 0x1

    goto :goto_2d

    .line 138
    .end local v0           #found:Z
    .end local v1           #i:I
    .end local v4           #zone:Ljava/util/TimeZone;
    :cond_50
    sget-object v7, Landroid/util/TimeUtils;->sLastUniqueLockObj:Ljava/lang/Object;

    monitor-enter v7

    .line 140
    :try_start_53
    sput-object v3, Landroid/util/TimeUtils;->sLastUniqueZoneOffsets:Ljava/util/ArrayList;

    .line 141
    sput-object p0, Landroid/util/TimeUtils;->sLastUniqueCountry:Ljava/lang/String;

    .line 143
    sget-object v6, Landroid/util/TimeUtils;->sLastUniqueZoneOffsets:Ljava/util/ArrayList;

    monitor-exit v7

    goto :goto_10

    .line 144
    :catchall_5b
    move-exception v6

    monitor-exit v7
    :try_end_5d
    .catchall {:try_start_53 .. :try_end_5d} :catchall_5b

    throw v6
.end method

.method public static logTimeOfDay(J)Ljava/lang/String;
    .registers 6
    .parameter "millis"

    .prologue
    .line 395
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 396
    .local v0, c:Ljava/util/Calendar;
    const-wide/16 v1, 0x0

    cmp-long v1, p0, v1

    if-ltz v1, :cond_29

    .line 397
    invoke-virtual {v0, p0, p1}, Ljava/util/Calendar;->setTimeInMillis(J)V

    .line 398
    const-string v1, "%tm-%td %tH:%tM:%tS.%tL"

    const/4 v2, 0x6

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object v0, v2, v3

    const/4 v3, 0x1

    aput-object v0, v2, v3

    const/4 v3, 0x2

    aput-object v0, v2, v3

    const/4 v3, 0x3

    aput-object v0, v2, v3

    const/4 v3, 0x4

    aput-object v0, v2, v3

    const/4 v3, 0x5

    aput-object v0, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 400
    :goto_28
    return-object v1

    :cond_29
    invoke-static {p0, p1}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v1

    goto :goto_28
.end method

.method private static printField([CICIZI)I
    .registers 9
    .parameter "formatStr"
    .parameter "amt"
    .parameter "suffix"
    .parameter "pos"
    .parameter "always"
    .parameter "zeropad"

    .prologue
    .line 263
    if-nez p4, :cond_4

    if-lez p1, :cond_3c

    .line 264
    :cond_4
    move v1, p3

    .line 265
    .local v1, startPos:I
    if-eqz p4, :cond_a

    const/4 v2, 0x3

    if-ge p5, v2, :cond_e

    :cond_a
    const/16 v2, 0x63

    if-le p1, v2, :cond_1a

    .line 266
    :cond_e
    div-int/lit8 v0, p1, 0x64

    .line 267
    .local v0, dig:I
    add-int/lit8 v2, v0, 0x30

    int-to-char v2, v2

    aput-char v2, p0, p3

    .line 268
    add-int/lit8 p3, p3, 0x1

    .line 269
    mul-int/lit8 v2, v0, 0x64

    sub-int/2addr p1, v2

    .line 271
    .end local v0           #dig:I
    :cond_1a
    if-eqz p4, :cond_1f

    const/4 v2, 0x2

    if-ge p5, v2, :cond_25

    :cond_1f
    const/16 v2, 0x9

    if-gt p1, v2, :cond_25

    if-eq v1, p3, :cond_31

    .line 272
    :cond_25
    div-int/lit8 v0, p1, 0xa

    .line 273
    .restart local v0       #dig:I
    add-int/lit8 v2, v0, 0x30

    int-to-char v2, v2

    aput-char v2, p0, p3

    .line 274
    add-int/lit8 p3, p3, 0x1

    .line 275
    mul-int/lit8 v2, v0, 0xa

    sub-int/2addr p1, v2

    .line 277
    .end local v0           #dig:I
    :cond_31
    add-int/lit8 v2, p1, 0x30

    int-to-char v2, v2

    aput-char v2, p0, p3

    .line 278
    add-int/lit8 p3, p3, 0x1

    .line 279
    aput-char p2, p0, p3

    .line 280
    add-int/lit8 p3, p3, 0x1

    .line 282
    .end local v1           #startPos:I
    :cond_3c
    return p3
.end method
