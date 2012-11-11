.class public Lmiui/util/MiuiDateUtils;
.super Ljava/lang/Object;
.source "MiuiDateUtils.java"


# static fields
.field private static final CHAR_BUFFER_CAPACITY:I = 0x40

.field private static final mCharBufferPool:Lmiui/util/SimplePool$PoolInstance;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lmiui/util/SimplePool$PoolInstance",
            "<",
            "Ljava/nio/CharBuffer;",
            ">;"
        }
    .end annotation
.end field

.field private static final mTimePool:Lmiui/util/SimplePool$PoolInstance;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lmiui/util/SimplePool$PoolInstance",
            "<",
            "Landroid/text/format/Time;",
            ">;"
        }
    .end annotation
.end field

.field private static sAmPmIndex:[I

.field private static sMonth:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    .prologue
    new-instance v0, Lmiui/util/MiuiDateUtils$1;

    invoke-direct {v0}, Lmiui/util/MiuiDateUtils$1;-><init>()V

    const/4 v1, 0x2

    invoke-static {v0, v1}, Lmiui/util/SimplePool;->newInsance(Lmiui/util/SimplePool$Manager;I)Lmiui/util/SimplePool$PoolInstance;

    move-result-object v0

    sput-object v0, Lmiui/util/MiuiDateUtils;->mCharBufferPool:Lmiui/util/SimplePool$PoolInstance;

    new-instance v0, Lmiui/util/MiuiDateUtils$2;

    invoke-direct {v0}, Lmiui/util/MiuiDateUtils$2;-><init>()V

    const/4 v1, 0x4

    invoke-static {v0, v1}, Lmiui/util/SimplePool;->newInsance(Lmiui/util/SimplePool$Manager;I)Lmiui/util/SimplePool$PoolInstance;

    move-result-object v0

    sput-object v0, Lmiui/util/MiuiDateUtils;->mTimePool:Lmiui/util/SimplePool$PoolInstance;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static formatDateTime(Landroid/content/Context;JI)Ljava/lang/String;
    .registers 9
    .parameter "context"
    .parameter "time"
    .parameter "flags"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    sget-object v2, Lmiui/util/MiuiDateUtils;->mCharBufferPool:Lmiui/util/SimplePool$PoolInstance;

    invoke-virtual {v2}, Lmiui/util/SimplePool$PoolInstance;->acquire()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/nio/CharBuffer;

    .local v0, cb:Ljava/nio/CharBuffer;
    invoke-static {p0, p1, p2, p3, v0}, Lmiui/util/MiuiDateUtils;->formatDateTime(Landroid/content/Context;JILjava/nio/CharBuffer;)V

    new-instance v1, Ljava/lang/String;

    invoke-virtual {v0}, Ljava/nio/CharBuffer;->array()[C

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v0}, Ljava/nio/CharBuffer;->position()I

    move-result v4

    invoke-direct {v1, v2, v3, v4}, Ljava/lang/String;-><init>([CII)V

    .local v1, resultString:Ljava/lang/String;
    sget-object v2, Lmiui/util/MiuiDateUtils;->mCharBufferPool:Lmiui/util/SimplePool$PoolInstance;

    invoke-virtual {v2, v0}, Lmiui/util/SimplePool$PoolInstance;->release(Ljava/lang/Object;)V

    return-object v1
.end method

.method public static formatDateTime(Landroid/content/Context;JILjava/nio/CharBuffer;)V
    .registers 8
    .parameter "context"
    .parameter "time"
    .parameter "flags"
    .parameter "result"

    .prologue
    sget-object v2, Lmiui/util/MiuiDateUtils;->mTimePool:Lmiui/util/SimplePool$PoolInstance;

    invoke-virtual {v2}, Lmiui/util/SimplePool$PoolInstance;->acquire()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/text/format/Time;

    .local v0, tTime:Landroid/text/format/Time;
    invoke-virtual {v0, p1, p2}, Landroid/text/format/Time;->set(J)V

    invoke-static {p0}, Landroid/text/format/DateFormat;->is24HourFormat(Landroid/content/Context;)Z

    move-result v1

    .local v1, use24Hour:Z
    invoke-static {p0, v0, p3, v1, p4}, Lmiui/util/MiuiDateUtils;->getFormatTime(Landroid/content/Context;Landroid/text/format/Time;IZLjava/nio/CharBuffer;)V

    sget-object v2, Lmiui/util/MiuiDateUtils;->mTimePool:Lmiui/util/SimplePool$PoolInstance;

    invoke-virtual {v2, v0}, Lmiui/util/SimplePool$PoolInstance;->release(Ljava/lang/Object;)V

    return-void
.end method

.method private static getDetailedAmPm(I)Ljava/lang/String;
    .registers 7
    .parameter "hour"

    .prologue
    sget-object v4, Lmiui/util/MiuiDateUtils;->sAmPmIndex:[I

    if-nez v4, :cond_2b

    const/16 v4, 0x18

    new-array v4, v4, [I

    sput-object v4, Lmiui/util/MiuiDateUtils;->sAmPmIndex:[I

    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x606000a

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getIntArray(I)[I

    move-result-object v3

    .local v3, segments:[I
    const/16 v0, 0x17

    .local v0, i:I
    array-length v4, v3

    add-int/lit8 v1, v4, -0x1

    .local v1, j:I
    :goto_1a
    if-ltz v0, :cond_2b

    if-ltz v1, :cond_2b

    aget v4, v3, v1

    if-ge v0, v4, :cond_24

    add-int/lit8 v1, v1, -0x1

    :cond_24
    sget-object v4, Lmiui/util/MiuiDateUtils;->sAmPmIndex:[I

    aput v1, v4, v0

    add-int/lit8 v0, v0, -0x1

    goto :goto_1a

    .end local v0           #i:I
    .end local v1           #j:I
    .end local v3           #segments:[I
    :cond_2b
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x606000b

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v2

    .local v2, names:[Ljava/lang/String;
    sget-object v4, Lmiui/util/MiuiDateUtils;->sAmPmIndex:[I

    aget v4, v4, p0

    aget-object v4, v2, v4

    return-object v4
.end method

.method private static getFormatTime(Landroid/content/Context;Landroid/text/format/Time;IZLjava/nio/CharBuffer;)V
    .registers 16
    .parameter "context"
    .parameter "tTime"
    .parameter "flags"
    .parameter "use24Hour"
    .parameter "result"

    .prologue
    const/4 v10, 0x0

    const/4 v9, 0x1

    invoke-virtual {p1, v9}, Landroid/text/format/Time;->toMillis(Z)J

    move-result-wide v1

    .local v1, time:J
    and-int/lit8 v0, p2, 0x1

    if-eqz v0, :cond_18

    move v8, v9

    .local v8, showTime:Z
    :goto_b
    if-eqz p3, :cond_1a

    move-object v0, p0

    move-wide v3, v1

    move v5, p2

    invoke-static/range {v0 .. v5}, Landroid/text/format/DateUtils;->formatDateRange(Landroid/content/Context;JJI)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p4, v0}, Ljava/nio/CharBuffer;->append(Ljava/lang/CharSequence;)Ljava/nio/CharBuffer;

    :goto_17
    return-void

    .end local v8           #showTime:Z
    :cond_18
    move v8, v10

    goto :goto_b

    .restart local v8       #showTime:Z
    :cond_1a
    if-eqz v8, :cond_64

    xor-int/lit8 v0, p2, 0x1

    if-eqz v0, :cond_30

    xor-int/lit8 v5, p2, 0x1

    move-object v0, p0

    move-wide v3, v1

    invoke-static/range {v0 .. v5}, Landroid/text/format/DateUtils;->formatDateRange(Landroid/content/Context;JJI)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p4, v0}, Ljava/nio/CharBuffer;->append(Ljava/lang/CharSequence;)Ljava/nio/CharBuffer;

    const-string v0, " "

    invoke-virtual {p4, v0}, Ljava/nio/CharBuffer;->append(Ljava/lang/CharSequence;)Ljava/nio/CharBuffer;

    :cond_30
    iget v0, p1, Landroid/text/format/Time;->hour:I

    invoke-static {v0}, Lmiui/util/MiuiDateUtils;->getDetailedAmPm(I)Ljava/lang/String;

    move-result-object v6

    .local v6, amPm:Ljava/lang/String;
    iget v0, p1, Landroid/text/format/Time;->hour:I

    const/16 v3, 0xc

    if-le v0, v3, :cond_42

    iget v0, p1, Landroid/text/format/Time;->hour:I

    add-int/lit8 v0, v0, -0xc

    iput v0, p1, Landroid/text/format/Time;->hour:I

    :cond_42
    invoke-virtual {p1, v9}, Landroid/text/format/Time;->toMillis(Z)J

    move-result-wide v1

    const/16 v5, 0x81

    move-object v0, p0

    move-wide v3, v1

    invoke-static/range {v0 .. v5}, Landroid/text/format/DateUtils;->formatDateRange(Landroid/content/Context;JJI)Ljava/lang/String;

    move-result-object v7

    .local v7, formatTime:Ljava/lang/String;
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v0

    const v3, 0x60c01f7

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    aput-object v7, v4, v10

    aput-object v6, v4, v9

    invoke-virtual {v0, v3, v4}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p4, v0}, Ljava/nio/CharBuffer;->append(Ljava/lang/CharSequence;)Ljava/nio/CharBuffer;

    goto :goto_17

    .end local v6           #amPm:Ljava/lang/String;
    .end local v7           #formatTime:Ljava/lang/String;
    :cond_64
    move-object v0, p0

    move-wide v3, v1

    move v5, p2

    invoke-static/range {v0 .. v5}, Landroid/text/format/DateUtils;->formatDateRange(Landroid/content/Context;JJI)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p4, v0}, Ljava/nio/CharBuffer;->append(Ljava/lang/CharSequence;)Ljava/nio/CharBuffer;

    goto :goto_17
.end method

.method public static getRelativeTimeSpanString(Landroid/content/Context;JLjava/nio/CharBuffer;)V
    .registers 32
    .parameter "context"
    .parameter "time"
    .parameter "result"

    .prologue
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v20

    .local v20, now:J
    const-wide/32 v17, 0xea60

    .local v17, minResolution:J
    const/high16 v15, 0x8

    .local v15, flags:I
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v24

    .local v24, r:Landroid/content/res/Resources;
    const/16 v4, 0xc

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    const v6, 0x60c01be

    move-object/from16 v0, v24

    invoke-virtual {v0, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    const v6, 0x60c01bf

    move-object/from16 v0, v24

    invoke-virtual {v0, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x2

    const v6, 0x60c01c0

    move-object/from16 v0, v24

    invoke-virtual {v0, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x3

    const v6, 0x60c01c1

    move-object/from16 v0, v24

    invoke-virtual {v0, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x4

    const v6, 0x60c01c2

    move-object/from16 v0, v24

    invoke-virtual {v0, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x5

    const v6, 0x60c01c3

    move-object/from16 v0, v24

    invoke-virtual {v0, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x6

    const v6, 0x60c01c4

    move-object/from16 v0, v24

    invoke-virtual {v0, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x7

    const v6, 0x60c01c5

    move-object/from16 v0, v24

    invoke-virtual {v0, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/16 v5, 0x8

    const v6, 0x60c01c6

    move-object/from16 v0, v24

    invoke-virtual {v0, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/16 v5, 0x9

    const v6, 0x60c01c7

    move-object/from16 v0, v24

    invoke-virtual {v0, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/16 v5, 0xa

    const v6, 0x60c01c8

    move-object/from16 v0, v24

    invoke-virtual {v0, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/16 v5, 0xb

    const v6, 0x60c01c9

    move-object/from16 v0, v24

    invoke-virtual {v0, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    sput-object v4, Lmiui/util/MiuiDateUtils;->sMonth:[Ljava/lang/String;

    cmp-long v4, v20, p1

    if-ltz v4, :cond_11f

    const/16 v23, 0x1

    .local v23, past:Z
    :goto_ad
    sub-long v4, v20, p1

    invoke-static {v4, v5}, Ljava/lang/Math;->abs(J)J

    move-result-wide v13

    .local v13, duration:J
    sget-object v4, Lmiui/util/MiuiDateUtils;->mTimePool:Lmiui/util/SimplePool$PoolInstance;

    invoke-virtual {v4}, Lmiui/util/SimplePool$PoolInstance;->acquire()Ljava/lang/Object;

    move-result-object v22

    check-cast v22, Landroid/text/format/Time;

    .local v22, nowTime:Landroid/text/format/Time;
    sget-object v4, Lmiui/util/MiuiDateUtils;->mTimePool:Lmiui/util/SimplePool$PoolInstance;

    invoke-virtual {v4}, Lmiui/util/SimplePool$PoolInstance;->acquire()Ljava/lang/Object;

    move-result-object v26

    check-cast v26, Landroid/text/format/Time;

    .local v26, thenTime:Landroid/text/format/Time;
    move-object/from16 v0, v22

    move-wide/from16 v1, v20

    invoke-virtual {v0, v1, v2}, Landroid/text/format/Time;->set(J)V

    move-object/from16 v0, v26

    move-wide/from16 v1, p1

    invoke-virtual {v0, v1, v2}, Landroid/text/format/Time;->set(J)V

    invoke-static/range {p0 .. p0}, Landroid/text/format/DateFormat;->is24HourFormat(Landroid/content/Context;)Z

    move-result v27

    .local v27, use24Hour:Z
    const/16 v25, -0x1

    .local v25, resId:I
    const-wide/32 v4, 0xea60

    div-long v10, v13, v4

    .local v10, count:J
    const-wide/16 v4, 0x3c

    cmp-long v4, v10, v4

    if-gtz v4, :cond_15c

    if-eqz v23, :cond_13a

    const-wide/16 v4, 0x3c

    cmp-long v4, v10, v4

    if-nez v4, :cond_122

    const v25, 0x6100004

    :goto_ed
    const/4 v4, -0x1

    move/from16 v0, v25

    if-eq v0, v4, :cond_110

    long-to-int v4, v10

    move-object/from16 v0, v24

    move/from16 v1, v25

    invoke-virtual {v0, v1, v4}, Landroid/content/res/Resources;->getQuantityString(II)Ljava/lang/String;

    move-result-object v16

    .local v16, format:Ljava/lang/String;
    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v4, v5

    move-object/from16 v0, v16

    invoke-static {v0, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p3

    invoke-virtual {v0, v4}, Ljava/nio/CharBuffer;->append(Ljava/lang/CharSequence;)Ljava/nio/CharBuffer;

    .end local v16           #format:Ljava/lang/String;
    :cond_110
    sget-object v4, Lmiui/util/MiuiDateUtils;->mTimePool:Lmiui/util/SimplePool$PoolInstance;

    move-object/from16 v0, v22

    invoke-virtual {v4, v0}, Lmiui/util/SimplePool$PoolInstance;->release(Ljava/lang/Object;)V

    sget-object v4, Lmiui/util/MiuiDateUtils;->mTimePool:Lmiui/util/SimplePool$PoolInstance;

    move-object/from16 v0, v26

    invoke-virtual {v4, v0}, Lmiui/util/SimplePool$PoolInstance;->release(Ljava/lang/Object;)V

    return-void

    .end local v10           #count:J
    .end local v13           #duration:J
    .end local v22           #nowTime:Landroid/text/format/Time;
    .end local v23           #past:Z
    .end local v25           #resId:I
    .end local v26           #thenTime:Landroid/text/format/Time;
    .end local v27           #use24Hour:Z
    :cond_11f
    const/16 v23, 0x0

    goto :goto_ad

    .restart local v10       #count:J
    .restart local v13       #duration:J
    .restart local v22       #nowTime:Landroid/text/format/Time;
    .restart local v23       #past:Z
    .restart local v25       #resId:I
    .restart local v26       #thenTime:Landroid/text/format/Time;
    .restart local v27       #use24Hour:Z
    :cond_122
    const-wide/16 v4, 0x1e

    cmp-long v4, v10, v4

    if-nez v4, :cond_12c

    const v25, 0x610000a

    goto :goto_ed

    :cond_12c
    const-wide/16 v4, 0x0

    cmp-long v4, v10, v4

    if-nez v4, :cond_136

    const v25, 0x6100005

    goto :goto_ed

    :cond_136
    const v25, 0x610000c

    goto :goto_ed

    :cond_13a
    const-wide/16 v4, 0x3c

    cmp-long v4, v10, v4

    if-nez v4, :cond_144

    const v25, 0x6100007

    goto :goto_ed

    :cond_144
    const-wide/16 v4, 0x1e

    cmp-long v4, v10, v4

    if-nez v4, :cond_14e

    const v25, 0x6100002

    goto :goto_ed

    :cond_14e
    const-wide/16 v4, 0x0

    cmp-long v4, v10, v4

    if-nez v4, :cond_158

    const v25, 0x610000b

    goto :goto_ed

    :cond_158
    const v25, 0x610000e

    goto :goto_ed

    :cond_15c
    move-object/from16 v0, v22

    iget v4, v0, Landroid/text/format/Time;->year:I

    move-object/from16 v0, v26

    iget v5, v0, Landroid/text/format/Time;->year:I

    if-ne v4, v5, :cond_17e

    move-object/from16 v0, v22

    iget v4, v0, Landroid/text/format/Time;->yearDay:I

    move-object/from16 v0, v26

    iget v5, v0, Landroid/text/format/Time;->yearDay:I

    if-ne v4, v5, :cond_17e

    const/4 v4, 0x1

    move-object/from16 v0, p0

    move-object/from16 v1, v26

    move/from16 v2, v27

    move-object/from16 v3, p3

    invoke-static {v0, v1, v4, v2, v3}, Lmiui/util/MiuiDateUtils;->getFormatTime(Landroid/content/Context;Landroid/text/format/Time;IZLjava/nio/CharBuffer;)V

    goto/16 :goto_ed

    :cond_17e
    move-object/from16 v0, v22

    iget v4, v0, Landroid/text/format/Time;->year:I

    move-object/from16 v0, v26

    iget v5, v0, Landroid/text/format/Time;->year:I

    if-ne v4, v5, :cond_1e0

    move-object/from16 v0, v22

    iget v4, v0, Landroid/text/format/Time;->yearDay:I

    move-object/from16 v0, v26

    iget v5, v0, Landroid/text/format/Time;->yearDay:I

    sub-int/2addr v4, v5

    invoke-static {v4}, Ljava/lang/Math;->abs(I)I

    move-result v4

    const/4 v5, 0x2

    if-ge v4, v5, :cond_1e0

    if-eqz v23, :cond_1bd

    const v4, 0x60c01a8

    move-object/from16 v0, v24

    invoke-virtual {v0, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p3

    invoke-virtual {v0, v4}, Ljava/nio/CharBuffer;->append(Ljava/lang/CharSequence;)Ljava/nio/CharBuffer;

    const-string v4, " "

    move-object/from16 v0, p3

    invoke-virtual {v0, v4}, Ljava/nio/CharBuffer;->append(Ljava/lang/CharSequence;)Ljava/nio/CharBuffer;

    const/4 v4, 0x1

    move-object/from16 v0, p0

    move-object/from16 v1, v26

    move/from16 v2, v27

    move-object/from16 v3, p3

    invoke-static {v0, v1, v4, v2, v3}, Lmiui/util/MiuiDateUtils;->getFormatTime(Landroid/content/Context;Landroid/text/format/Time;IZLjava/nio/CharBuffer;)V

    goto/16 :goto_ed

    :cond_1bd
    const v4, 0x60c01a9

    move-object/from16 v0, v24

    invoke-virtual {v0, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p3

    invoke-virtual {v0, v4}, Ljava/nio/CharBuffer;->append(Ljava/lang/CharSequence;)Ljava/nio/CharBuffer;

    const-string v4, " "

    move-object/from16 v0, p3

    invoke-virtual {v0, v4}, Ljava/nio/CharBuffer;->append(Ljava/lang/CharSequence;)Ljava/nio/CharBuffer;

    const/4 v4, 0x1

    move-object/from16 v0, p0

    move-object/from16 v1, v26

    move/from16 v2, v27

    move-object/from16 v3, p3

    invoke-static {v0, v1, v4, v2, v3}, Lmiui/util/MiuiDateUtils;->getFormatTime(Landroid/content/Context;Landroid/text/format/Time;IZLjava/nio/CharBuffer;)V

    goto/16 :goto_ed

    :cond_1e0
    move-object/from16 v0, v22

    iget v4, v0, Landroid/text/format/Time;->year:I

    move-object/from16 v0, v26

    iget v5, v0, Landroid/text/format/Time;->year:I

    if-ne v4, v5, :cond_21b

    invoke-virtual/range {v22 .. v22}, Landroid/text/format/Time;->getWeekNumber()I

    move-result v4

    invoke-virtual/range {v26 .. v26}, Landroid/text/format/Time;->getWeekNumber()I

    move-result v5

    if-ne v4, v5, :cond_21b

    const v9, 0x80002

    move-object/from16 v4, p0

    move-wide/from16 v5, p1

    move-wide/from16 v7, p1

    invoke-static/range {v4 .. v9}, Landroid/text/format/DateUtils;->formatDateRange(Landroid/content/Context;JJI)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p3

    invoke-virtual {v0, v4}, Ljava/nio/CharBuffer;->append(Ljava/lang/CharSequence;)Ljava/nio/CharBuffer;

    const-string v4, " "

    move-object/from16 v0, p3

    invoke-virtual {v0, v4}, Ljava/nio/CharBuffer;->append(Ljava/lang/CharSequence;)Ljava/nio/CharBuffer;

    const/4 v4, 0x1

    move-object/from16 v0, p0

    move-object/from16 v1, v26

    move/from16 v2, v27

    move-object/from16 v3, p3

    invoke-static {v0, v1, v4, v2, v3}, Lmiui/util/MiuiDateUtils;->getFormatTime(Landroid/content/Context;Landroid/text/format/Time;IZLjava/nio/CharBuffer;)V

    goto/16 :goto_ed

    :cond_21b
    move-object/from16 v0, v22

    iget v4, v0, Landroid/text/format/Time;->year:I

    move-object/from16 v0, v26

    iget v5, v0, Landroid/text/format/Time;->year:I

    if-ne v4, v5, :cond_25e

    sget-object v4, Lmiui/util/MiuiDateUtils;->sMonth:[Ljava/lang/String;

    move-object/from16 v0, v26

    iget v5, v0, Landroid/text/format/Time;->month:I

    aget-object v19, v4, v5

    .local v19, month:Ljava/lang/String;
    const v4, 0x60c01ca

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    move-object/from16 v0, v26

    iget v7, v0, Landroid/text/format/Time;->monthDay:I

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v5, v6

    move-object/from16 v0, v24

    invoke-virtual {v0, v4, v5}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v12

    .local v12, day:Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v19

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p3

    invoke-virtual {v0, v4}, Ljava/nio/CharBuffer;->append(Ljava/lang/CharSequence;)Ljava/nio/CharBuffer;

    goto/16 :goto_ed

    .end local v12           #day:Ljava/lang/String;
    .end local v19           #month:Ljava/lang/String;
    :cond_25e
    const v9, 0x80014

    move-object/from16 v4, p0

    move-wide/from16 v5, p1

    move-wide/from16 v7, p1

    invoke-static/range {v4 .. v9}, Landroid/text/format/DateUtils;->formatDateRange(Landroid/content/Context;JJI)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p3

    invoke-virtual {v0, v4}, Ljava/nio/CharBuffer;->append(Ljava/lang/CharSequence;)Ljava/nio/CharBuffer;

    goto/16 :goto_ed
.end method
