.class public Landroid/text/format/DateUtils;
.super Ljava/lang/Object;
.source "DateUtils.java"


# static fields
.field public static final ABBREV_MONTH_FORMAT:Ljava/lang/String; = "%b"

.field public static final ABBREV_WEEKDAY_FORMAT:Ljava/lang/String; = "%a"

.field public static final DAY_IN_MILLIS:J = 0x5265c00L

.field private static final FAST_FORMAT_HMMSS:Ljava/lang/String; = "%1$d:%2$02d:%3$02d"

.field private static final FAST_FORMAT_MMSS:Ljava/lang/String; = "%1$02d:%2$02d"

.field public static final FORMAT_12HOUR:I = 0x40

.field public static final FORMAT_24HOUR:I = 0x80

.field public static final FORMAT_ABBREV_ALL:I = 0x80000

.field public static final FORMAT_ABBREV_MONTH:I = 0x10000

.field public static final FORMAT_ABBREV_RELATIVE:I = 0x40000

.field public static final FORMAT_ABBREV_TIME:I = 0x4000

.field public static final FORMAT_ABBREV_WEEKDAY:I = 0x8000

.field public static final FORMAT_CAP_AMPM:I = 0x100

.field public static final FORMAT_CAP_MIDNIGHT:I = 0x1000

.field public static final FORMAT_CAP_NOON:I = 0x400

.field public static final FORMAT_CAP_NOON_MIDNIGHT:I = 0x1400

.field public static final FORMAT_NO_MIDNIGHT:I = 0x800

.field public static final FORMAT_NO_MONTH_DAY:I = 0x20

.field public static final FORMAT_NO_NOON:I = 0x200

.field public static final FORMAT_NO_NOON_MIDNIGHT:I = 0xa00

.field public static final FORMAT_NO_YEAR:I = 0x8

.field public static final FORMAT_NUMERIC_DATE:I = 0x20000

.field public static final FORMAT_SHOW_DATE:I = 0x10

.field public static final FORMAT_SHOW_TIME:I = 0x1

.field public static final FORMAT_SHOW_WEEKDAY:I = 0x2

.field public static final FORMAT_SHOW_YEAR:I = 0x4

.field public static final FORMAT_UTC:I = 0x2000
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final HOUR_IN_MILLIS:J = 0x36ee80L

.field public static final HOUR_MINUTE_24:Ljava/lang/String; = "%H:%M"

.field public static final LENGTH_LONG:I = 0xa

.field public static final LENGTH_MEDIUM:I = 0x14

.field public static final LENGTH_SHORT:I = 0x1e

.field public static final LENGTH_SHORTER:I = 0x28

.field public static final LENGTH_SHORTEST:I = 0x32

.field public static final MINUTE_IN_MILLIS:J = 0xea60L

.field public static final MONTH_DAY_FORMAT:Ljava/lang/String; = "%-d"

.field public static final MONTH_FORMAT:Ljava/lang/String; = "%B"

.field public static final NUMERIC_MONTH_FORMAT:Ljava/lang/String; = "%m"

.field public static final SECOND_IN_MILLIS:J = 0x3e8L

.field private static final TIME_PADDING:C = '0'

.field private static final TIME_SEPARATOR:C = ':'

.field public static final WEEKDAY_FORMAT:Ljava/lang/String; = "%A"

.field public static final WEEK_IN_MILLIS:J = 0x240c8400L

.field public static final YEAR_FORMAT:Ljava/lang/String; = "%Y"

.field public static final YEAR_FORMAT_TWO_DIGITS:Ljava/lang/String; = "%g"

.field public static final YEAR_IN_MILLIS:J = 0x7528ad000L

.field private static final sAmPm:[I

.field private static final sDaysLong:[I

.field private static final sDaysMedium:[I

.field private static final sDaysShort:[I

.field private static final sDaysShortest:[I

.field private static sElapsedFormatHMMSS:Ljava/lang/String;

.field private static sElapsedFormatMMSS:Ljava/lang/String;

.field private static sLastConfig:Landroid/content/res/Configuration;

.field private static final sLock:Ljava/lang/Object;

.field private static final sMonthsLong:[I

.field private static final sMonthsMedium:[I

.field private static final sMonthsShortest:[I

.field private static final sMonthsStandaloneLong:[I

.field private static sNowTime:Landroid/text/format/Time;

.field private static sStatusTimeFormat:Ljava/text/DateFormat;

.field private static sThenTime:Landroid/text/format/Time;

.field public static final sameMonthTable:[I

.field public static final sameYearTable:[I


# direct methods
.method static constructor <clinit>()V
    .registers 4

    .prologue
    const/16 v3, 0x10

    const/16 v2, 0xc

    const/4 v1, 0x7

    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Landroid/text/format/DateUtils;->sLock:Ljava/lang/Object;

    new-array v0, v1, [I

    fill-array-data v0, :array_5c

    sput-object v0, Landroid/text/format/DateUtils;->sDaysLong:[I

    new-array v0, v1, [I

    fill-array-data v0, :array_6e

    sput-object v0, Landroid/text/format/DateUtils;->sDaysMedium:[I

    new-array v0, v1, [I

    fill-array-data v0, :array_80

    sput-object v0, Landroid/text/format/DateUtils;->sDaysShort:[I

    new-array v0, v1, [I

    fill-array-data v0, :array_92

    sput-object v0, Landroid/text/format/DateUtils;->sDaysShortest:[I

    new-array v0, v2, [I

    fill-array-data v0, :array_a4

    sput-object v0, Landroid/text/format/DateUtils;->sMonthsStandaloneLong:[I

    new-array v0, v2, [I

    fill-array-data v0, :array_c0

    sput-object v0, Landroid/text/format/DateUtils;->sMonthsLong:[I

    new-array v0, v2, [I

    fill-array-data v0, :array_dc

    sput-object v0, Landroid/text/format/DateUtils;->sMonthsMedium:[I

    new-array v0, v2, [I

    fill-array-data v0, :array_f8

    sput-object v0, Landroid/text/format/DateUtils;->sMonthsShortest:[I

    const/4 v0, 0x2

    new-array v0, v0, [I

    fill-array-data v0, :array_114

    sput-object v0, Landroid/text/format/DateUtils;->sAmPm:[I

    new-array v0, v3, [I

    fill-array-data v0, :array_11c

    sput-object v0, Landroid/text/format/DateUtils;->sameYearTable:[I

    new-array v0, v3, [I

    fill-array-data v0, :array_140

    sput-object v0, Landroid/text/format/DateUtils;->sameMonthTable:[I

    return-void

    nop

    :array_5c
    .array-data 0x4
        0x5dt 0x0t 0x4t 0x1t
        0x5et 0x0t 0x4t 0x1t
        0x5ft 0x0t 0x4t 0x1t
        0x60t 0x0t 0x4t 0x1t
        0x61t 0x0t 0x4t 0x1t
        0x62t 0x0t 0x4t 0x1t
        0x63t 0x0t 0x4t 0x1t
    .end array-data

    :array_6e
    .array-data 0x4
        0x64t 0x0t 0x4t 0x1t
        0x65t 0x0t 0x4t 0x1t
        0x66t 0x0t 0x4t 0x1t
        0x67t 0x0t 0x4t 0x1t
        0x68t 0x0t 0x4t 0x1t
        0x69t 0x0t 0x4t 0x1t
        0x6at 0x0t 0x4t 0x1t
    .end array-data

    :array_80
    .array-data 0x4
        0x6bt 0x0t 0x4t 0x1t
        0x6ct 0x0t 0x4t 0x1t
        0x6dt 0x0t 0x4t 0x1t
        0x6et 0x0t 0x4t 0x1t
        0x6ft 0x0t 0x4t 0x1t
        0x70t 0x0t 0x4t 0x1t
        0x71t 0x0t 0x4t 0x1t
    .end array-data

    :array_92
    .array-data 0x4
        0x72t 0x0t 0x4t 0x1t
        0x73t 0x0t 0x4t 0x1t
        0x74t 0x0t 0x4t 0x1t
        0x75t 0x0t 0x4t 0x1t
        0x76t 0x0t 0x4t 0x1t
        0x77t 0x0t 0x4t 0x1t
        0x78t 0x0t 0x4t 0x1t
    .end array-data

    :array_a4
    .array-data 0x4
        0x2dt 0x0t 0x4t 0x1t
        0x2et 0x0t 0x4t 0x1t
        0x2ft 0x0t 0x4t 0x1t
        0x30t 0x0t 0x4t 0x1t
        0x31t 0x0t 0x4t 0x1t
        0x32t 0x0t 0x4t 0x1t
        0x33t 0x0t 0x4t 0x1t
        0x34t 0x0t 0x4t 0x1t
        0x35t 0x0t 0x4t 0x1t
        0x36t 0x0t 0x4t 0x1t
        0x37t 0x0t 0x4t 0x1t
        0x38t 0x0t 0x4t 0x1t
    .end array-data

    :array_c0
    .array-data 0x4
        0x39t 0x0t 0x4t 0x1t
        0x3at 0x0t 0x4t 0x1t
        0x3bt 0x0t 0x4t 0x1t
        0x3ct 0x0t 0x4t 0x1t
        0x3dt 0x0t 0x4t 0x1t
        0x3et 0x0t 0x4t 0x1t
        0x3ft 0x0t 0x4t 0x1t
        0x40t 0x0t 0x4t 0x1t
        0x41t 0x0t 0x4t 0x1t
        0x42t 0x0t 0x4t 0x1t
        0x43t 0x0t 0x4t 0x1t
        0x44t 0x0t 0x4t 0x1t
    .end array-data

    :array_dc
    .array-data 0x4
        0x45t 0x0t 0x4t 0x1t
        0x46t 0x0t 0x4t 0x1t
        0x47t 0x0t 0x4t 0x1t
        0x48t 0x0t 0x4t 0x1t
        0x49t 0x0t 0x4t 0x1t
        0x4at 0x0t 0x4t 0x1t
        0x4bt 0x0t 0x4t 0x1t
        0x4ct 0x0t 0x4t 0x1t
        0x4dt 0x0t 0x4t 0x1t
        0x4et 0x0t 0x4t 0x1t
        0x4ft 0x0t 0x4t 0x1t
        0x50t 0x0t 0x4t 0x1t
    .end array-data

    :array_f8
    .array-data 0x4
        0x51t 0x0t 0x4t 0x1t
        0x52t 0x0t 0x4t 0x1t
        0x53t 0x0t 0x4t 0x1t
        0x54t 0x0t 0x4t 0x1t
        0x55t 0x0t 0x4t 0x1t
        0x56t 0x0t 0x4t 0x1t
        0x57t 0x0t 0x4t 0x1t
        0x58t 0x0t 0x4t 0x1t
        0x59t 0x0t 0x4t 0x1t
        0x5at 0x0t 0x4t 0x1t
        0x5bt 0x0t 0x4t 0x1t
        0x5ct 0x0t 0x4t 0x1t
    .end array-data

    :array_114
    .array-data 0x4
        0x79t 0x0t 0x4t 0x1t
        0x7at 0x0t 0x4t 0x1t
    .end array-data

    :array_11c
    .array-data 0x4
        0xa2t 0x0t 0x4t 0x1t
        0xa3t 0x0t 0x4t 0x1t
        0xaft 0x0t 0x4t 0x1t
        0xb1t 0x0t 0x4t 0x1t
        0xa4t 0x0t 0x4t 0x1t
        0xa6t 0x0t 0x4t 0x1t
        0xa8t 0x0t 0x4t 0x1t
        0xaat 0x0t 0x4t 0x1t
        0x94t 0x0t 0x4t 0x1t
        0x95t 0x0t 0x4t 0x1t
        0x96t 0x0t 0x4t 0x1t
        0x97t 0x0t 0x4t 0x1t
        0x99t 0x0t 0x4t 0x1t
        0x9at 0x0t 0x4t 0x1t
        0x9bt 0x0t 0x4t 0x1t
        0x98t 0x0t 0x4t 0x1t
    .end array-data

    :array_140
    .array-data 0x4
        0xadt 0x0t 0x4t 0x1t
        0xaet 0x0t 0x4t 0x1t
        0xb0t 0x0t 0x4t 0x1t
        0xact 0x0t 0x4t 0x1t
        0xa5t 0x0t 0x4t 0x1t
        0xa7t 0x0t 0x4t 0x1t
        0xa9t 0x0t 0x4t 0x1t
        0xabt 0x0t 0x4t 0x1t
        0x94t 0x0t 0x4t 0x1t
        0x95t 0x0t 0x4t 0x1t
        0x96t 0x0t 0x4t 0x1t
        0x97t 0x0t 0x4t 0x1t
        0x99t 0x0t 0x4t 0x1t
        0x9at 0x0t 0x4t 0x1t
        0x9bt 0x0t 0x4t 0x1t
        0x98t 0x0t 0x4t 0x1t
    .end array-data
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static assign(Ljava/util/Calendar;Ljava/util/Calendar;)V
    .registers 4
    .parameter "lval"
    .parameter "rval"

    .prologue
    invoke-virtual {p0}, Ljava/util/Calendar;->clear()V

    invoke-virtual {p1}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v0

    invoke-virtual {p0, v0, v1}, Ljava/util/Calendar;->setTimeInMillis(J)V

    return-void
.end method

.method public static formatDateRange(Landroid/content/Context;JJI)Ljava/lang/String;
    .registers 13
    .parameter "context"
    .parameter "startMillis"
    .parameter "endMillis"
    .parameter "flags"

    .prologue
    new-instance v1, Ljava/util/Formatter;

    new-instance v0, Ljava/lang/StringBuilder;

    const/16 v2, 0x32

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(I)V

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v2

    invoke-direct {v1, v0, v2}, Ljava/util/Formatter;-><init>(Ljava/lang/Appendable;Ljava/util/Locale;)V

    .local v1, f:Ljava/util/Formatter;
    move-object v0, p0

    move-wide v2, p1

    move-wide v4, p3

    move v6, p5

    invoke-static/range {v0 .. v6}, Landroid/text/format/DateUtils;->formatDateRange(Landroid/content/Context;Ljava/util/Formatter;JJI)Ljava/util/Formatter;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/Formatter;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static formatDateRange(Landroid/content/Context;Ljava/util/Formatter;JJI)Ljava/util/Formatter;
    .registers 15
    .parameter "context"
    .parameter "formatter"
    .parameter "startMillis"
    .parameter "endMillis"
    .parameter "flags"

    .prologue
    const/4 v7, 0x0

    move-object v0, p0

    move-object v1, p1

    move-wide v2, p2

    move-wide v4, p4

    move v6, p6

    invoke-static/range {v0 .. v7}, Landroid/text/format/DateUtils;->formatDateRange(Landroid/content/Context;Ljava/util/Formatter;JJILjava/lang/String;)Ljava/util/Formatter;

    move-result-object v0

    return-object v0
.end method

.method public static formatDateRange(Landroid/content/Context;Ljava/util/Formatter;JJILjava/lang/String;)Ljava/util/Formatter;
    .registers 74
    .parameter "context"
    .parameter "formatter"
    .parameter "startMillis"
    .parameter "endMillis"
    .parameter "flags"
    .parameter "timeZone"

    .prologue
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v38

    .local v38, res:Landroid/content/res/Resources;
    and-int/lit8 v62, p6, 0x1

    if-eqz v62, :cond_147

    const/16 v41, 0x1

    .local v41, showTime:Z
    :goto_a
    and-int/lit8 v62, p6, 0x2

    if-eqz v62, :cond_14b

    const/16 v42, 0x1

    .local v42, showWeekDay:Z
    :goto_10
    and-int/lit8 v62, p6, 0x4

    if-eqz v62, :cond_14f

    const/16 v43, 0x1

    .local v43, showYear:Z
    :goto_16
    and-int/lit8 v62, p6, 0x8

    if-eqz v62, :cond_153

    const/16 v36, 0x1

    .local v36, noYear:Z
    :goto_1c
    move/from16 v0, p6

    and-int/lit16 v0, v0, 0x2000

    move/from16 v62, v0

    if-eqz v62, :cond_157

    const/16 v60, 0x1

    .local v60, useUTC:Z
    :goto_26
    const v62, 0x88000

    and-int v62, v62, p6

    if-eqz v62, :cond_15b

    const/4 v6, 0x1

    .local v6, abbrevWeekDay:Z
    :goto_2e
    const/high16 v62, 0x9

    and-int v62, v62, p6

    if-eqz v62, :cond_15e

    const/4 v4, 0x1

    .local v4, abbrevMonth:Z
    :goto_35
    and-int/lit8 v62, p6, 0x20

    if-eqz v62, :cond_161

    const/16 v34, 0x1

    .local v34, noMonthDay:Z
    :goto_3b
    const/high16 v62, 0x2

    and-int v62, v62, p6

    if-eqz v62, :cond_165

    const/16 v37, 0x1

    .local v37, numericDate:Z
    :goto_43
    cmp-long v62, p2, p4

    if-nez v62, :cond_169

    const/16 v31, 0x1

    .local v31, isInstant:Z
    :goto_49
    if-eqz p7, :cond_16d

    new-instance v44, Landroid/text/format/Time;

    move-object/from16 v0, v44

    move-object/from16 v1, p7

    invoke-direct {v0, v1}, Landroid/text/format/Time;-><init>(Ljava/lang/String;)V

    .local v44, startDate:Landroid/text/format/Time;
    :goto_54
    move-object/from16 v0, v44

    move-wide/from16 v1, p2

    invoke-virtual {v0, v1, v2}, Landroid/text/format/Time;->set(J)V

    if-eqz v31, :cond_183

    move-object/from16 v14, v44

    .local v14, endDate:Landroid/text/format/Time;
    const/4 v12, 0x0

    .local v12, dayDistance:I
    :goto_60
    if-nez v31, :cond_8d

    iget v0, v14, Landroid/text/format/Time;->hour:I

    move/from16 v62, v0

    iget v0, v14, Landroid/text/format/Time;->minute:I

    move/from16 v63, v0

    or-int v62, v62, v63

    iget v0, v14, Landroid/text/format/Time;->second:I

    move/from16 v63, v0

    or-int v62, v62, v63

    if-nez v62, :cond_8d

    if-eqz v41, :cond_7c

    const/16 v62, 0x1

    move/from16 v0, v62

    if-gt v12, v0, :cond_8d

    :cond_7c
    iget v0, v14, Landroid/text/format/Time;->monthDay:I

    move/from16 v62, v0

    add-int/lit8 v62, v62, -0x1

    move/from16 v0, v62

    iput v0, v14, Landroid/text/format/Time;->monthDay:I

    const/16 v62, 0x1

    move/from16 v0, v62

    invoke-virtual {v14, v0}, Landroid/text/format/Time;->normalize(Z)J

    :cond_8d
    move-object/from16 v0, v44

    iget v0, v0, Landroid/text/format/Time;->monthDay:I

    move/from16 v46, v0

    .local v46, startDay:I
    move-object/from16 v0, v44

    iget v0, v0, Landroid/text/format/Time;->month:I

    move/from16 v49, v0

    .local v49, startMonthNum:I
    move-object/from16 v0, v44

    iget v0, v0, Landroid/text/format/Time;->year:I

    move/from16 v55, v0

    .local v55, startYear:I
    iget v0, v14, Landroid/text/format/Time;->monthDay:I

    move/from16 v16, v0

    .local v16, endDay:I
    iget v0, v14, Landroid/text/format/Time;->month:I

    move/from16 v19, v0

    .local v19, endMonthNum:I
    iget v0, v14, Landroid/text/format/Time;->year:I

    move/from16 v25, v0

    .local v25, endYear:I
    const-string v54, ""

    .local v54, startWeekDayString:Ljava/lang/String;
    const-string v24, ""

    .local v24, endWeekDayString:Ljava/lang/String;
    if-eqz v42, :cond_c3

    const-string v61, ""

    .local v61, weekDayFormat:Ljava/lang/String;
    if-eqz v6, :cond_1c1

    const-string v61, "%a"

    :goto_b7
    move-object/from16 v0, v44

    move-object/from16 v1, v61

    invoke-virtual {v0, v1}, Landroid/text/format/Time;->format(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v54

    if-eqz v31, :cond_1c5

    move-object/from16 v24, v54

    .end local v61           #weekDayFormat:Ljava/lang/String;
    :cond_c3
    :goto_c3
    const-string v53, ""

    .local v53, startTimeString:Ljava/lang/String;
    const-string v23, ""

    .local v23, endTimeString:Ljava/lang/String;
    if-eqz v41, :cond_fc

    const-string v52, ""

    .local v52, startTimeFormat:Ljava/lang/String;
    const-string v22, ""

    .local v22, endTimeFormat:Ljava/lang/String;
    move/from16 v0, p6

    and-int/lit16 v0, v0, 0x80

    move/from16 v62, v0

    if-eqz v62, :cond_1cd

    const/16 v28, 0x1

    .local v28, force24Hour:Z
    :goto_d7
    and-int/lit8 v62, p6, 0x40

    if-eqz v62, :cond_1d1

    const/16 v27, 0x1

    .local v27, force12Hour:Z
    :goto_dd
    if-eqz v28, :cond_1d5

    const/16 v59, 0x1

    .local v59, use24Hour:Z
    :goto_e1
    if-eqz v59, :cond_1e1

    const v62, 0x104007e

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v52, v22

    :cond_f0
    :goto_f0
    move-object/from16 v0, v44

    move-object/from16 v1, v52

    invoke-virtual {v0, v1}, Landroid/text/format/Time;->format(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v53

    if-eqz v31, :cond_346

    move-object/from16 v23, v53

    .end local v22           #endTimeFormat:Ljava/lang/String;
    .end local v27           #force12Hour:Z
    .end local v28           #force24Hour:Z
    .end local v52           #startTimeFormat:Ljava/lang/String;
    .end local v59           #use24Hour:Z
    :cond_fc
    :goto_fc
    if-eqz v43, :cond_34e

    :goto_fe
    if-eqz v37, :cond_377

    const v62, 0x1040083

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v13

    .local v13, defaultDateFormat:Ljava/lang/String;
    :goto_10b
    if-eqz v42, :cond_3fa

    if-eqz v41, :cond_3ed

    const v62, 0x104009c

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v29

    .local v29, fullFormat:Ljava/lang/String;
    :goto_11a
    if-eqz v34, :cond_416

    move/from16 v0, v49

    move/from16 v1, v19

    if-ne v0, v1, :cond_416

    move/from16 v0, v55

    move/from16 v1, v25

    if-ne v0, v1, :cond_416

    const-string v62, "%s"

    const/16 v63, 0x1

    move/from16 v0, v63

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v63, v0

    const/16 v64, 0x0

    move-object/from16 v0, v44

    invoke-virtual {v0, v13}, Landroid/text/format/Time;->format(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v65

    aput-object v65, v63, v64

    move-object/from16 v0, p1

    move-object/from16 v1, v62

    move-object/from16 v2, v63

    invoke-virtual {v0, v1, v2}, Ljava/util/Formatter;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/util/Formatter;

    move-result-object v62

    :goto_146
    return-object v62

    .end local v4           #abbrevMonth:Z
    .end local v6           #abbrevWeekDay:Z
    .end local v12           #dayDistance:I
    .end local v13           #defaultDateFormat:Ljava/lang/String;
    .end local v14           #endDate:Landroid/text/format/Time;
    .end local v16           #endDay:I
    .end local v19           #endMonthNum:I
    .end local v23           #endTimeString:Ljava/lang/String;
    .end local v24           #endWeekDayString:Ljava/lang/String;
    .end local v25           #endYear:I
    .end local v29           #fullFormat:Ljava/lang/String;
    .end local v31           #isInstant:Z
    .end local v34           #noMonthDay:Z
    .end local v36           #noYear:Z
    .end local v37           #numericDate:Z
    .end local v41           #showTime:Z
    .end local v42           #showWeekDay:Z
    .end local v43           #showYear:Z
    .end local v44           #startDate:Landroid/text/format/Time;
    .end local v46           #startDay:I
    .end local v49           #startMonthNum:I
    .end local v53           #startTimeString:Ljava/lang/String;
    .end local v54           #startWeekDayString:Ljava/lang/String;
    .end local v55           #startYear:I
    .end local v60           #useUTC:Z
    :cond_147
    const/16 v41, 0x0

    goto/16 :goto_a

    .restart local v41       #showTime:Z
    :cond_14b
    const/16 v42, 0x0

    goto/16 :goto_10

    .restart local v42       #showWeekDay:Z
    :cond_14f
    const/16 v43, 0x0

    goto/16 :goto_16

    .restart local v43       #showYear:Z
    :cond_153
    const/16 v36, 0x0

    goto/16 :goto_1c

    .restart local v36       #noYear:Z
    :cond_157
    const/16 v60, 0x0

    goto/16 :goto_26

    .restart local v60       #useUTC:Z
    :cond_15b
    const/4 v6, 0x0

    goto/16 :goto_2e

    .restart local v6       #abbrevWeekDay:Z
    :cond_15e
    const/4 v4, 0x0

    goto/16 :goto_35

    .restart local v4       #abbrevMonth:Z
    :cond_161
    const/16 v34, 0x0

    goto/16 :goto_3b

    .restart local v34       #noMonthDay:Z
    :cond_165
    const/16 v37, 0x0

    goto/16 :goto_43

    .restart local v37       #numericDate:Z
    :cond_169
    const/16 v31, 0x0

    goto/16 :goto_49

    .restart local v31       #isInstant:Z
    :cond_16d
    if-eqz v60, :cond_17c

    new-instance v44, Landroid/text/format/Time;

    const-string v62, "UTC"

    move-object/from16 v0, v44

    move-object/from16 v1, v62

    invoke-direct {v0, v1}, Landroid/text/format/Time;-><init>(Ljava/lang/String;)V

    .restart local v44       #startDate:Landroid/text/format/Time;
    goto/16 :goto_54

    .end local v44           #startDate:Landroid/text/format/Time;
    :cond_17c
    new-instance v44, Landroid/text/format/Time;

    invoke-direct/range {v44 .. v44}, Landroid/text/format/Time;-><init>()V

    .restart local v44       #startDate:Landroid/text/format/Time;
    goto/16 :goto_54

    :cond_183
    if-eqz p7, :cond_1af

    new-instance v14, Landroid/text/format/Time;

    move-object/from16 v0, p7

    invoke-direct {v14, v0}, Landroid/text/format/Time;-><init>(Ljava/lang/String;)V

    .restart local v14       #endDate:Landroid/text/format/Time;
    :goto_18c
    move-wide/from16 v0, p4

    invoke-virtual {v14, v0, v1}, Landroid/text/format/Time;->set(J)V

    move-object/from16 v0, v44

    iget-wide v0, v0, Landroid/text/format/Time;->gmtoff:J

    move-wide/from16 v62, v0

    move-wide/from16 v0, p2

    move-wide/from16 v2, v62

    invoke-static {v0, v1, v2, v3}, Landroid/text/format/Time;->getJulianDay(JJ)I

    move-result v47

    .local v47, startJulianDay:I
    iget-wide v0, v14, Landroid/text/format/Time;->gmtoff:J

    move-wide/from16 v62, v0

    move-wide/from16 v0, p4

    move-wide/from16 v2, v62

    invoke-static {v0, v1, v2, v3}, Landroid/text/format/Time;->getJulianDay(JJ)I

    move-result v17

    .local v17, endJulianDay:I
    sub-int v12, v17, v47

    .restart local v12       #dayDistance:I
    goto/16 :goto_60

    .end local v12           #dayDistance:I
    .end local v14           #endDate:Landroid/text/format/Time;
    .end local v17           #endJulianDay:I
    .end local v47           #startJulianDay:I
    :cond_1af
    if-eqz v60, :cond_1bb

    new-instance v14, Landroid/text/format/Time;

    const-string v62, "UTC"

    move-object/from16 v0, v62

    invoke-direct {v14, v0}, Landroid/text/format/Time;-><init>(Ljava/lang/String;)V

    .restart local v14       #endDate:Landroid/text/format/Time;
    goto :goto_18c

    .end local v14           #endDate:Landroid/text/format/Time;
    :cond_1bb
    new-instance v14, Landroid/text/format/Time;

    invoke-direct {v14}, Landroid/text/format/Time;-><init>()V

    .restart local v14       #endDate:Landroid/text/format/Time;
    goto :goto_18c

    .restart local v12       #dayDistance:I
    .restart local v16       #endDay:I
    .restart local v19       #endMonthNum:I
    .restart local v24       #endWeekDayString:Ljava/lang/String;
    .restart local v25       #endYear:I
    .restart local v46       #startDay:I
    .restart local v49       #startMonthNum:I
    .restart local v54       #startWeekDayString:Ljava/lang/String;
    .restart local v55       #startYear:I
    .restart local v61       #weekDayFormat:Ljava/lang/String;
    :cond_1c1
    const-string v61, "%A"

    goto/16 :goto_b7

    :cond_1c5
    move-object/from16 v0, v61

    invoke-virtual {v14, v0}, Landroid/text/format/Time;->format(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v24

    goto/16 :goto_c3

    .end local v61           #weekDayFormat:Ljava/lang/String;
    .restart local v22       #endTimeFormat:Ljava/lang/String;
    .restart local v23       #endTimeString:Ljava/lang/String;
    .restart local v52       #startTimeFormat:Ljava/lang/String;
    .restart local v53       #startTimeString:Ljava/lang/String;
    :cond_1cd
    const/16 v28, 0x0

    goto/16 :goto_d7

    .restart local v28       #force24Hour:Z
    :cond_1d1
    const/16 v27, 0x0

    goto/16 :goto_dd

    .restart local v27       #force12Hour:Z
    :cond_1d5
    if-eqz v27, :cond_1db

    const/16 v59, 0x0

    .restart local v59       #use24Hour:Z
    goto/16 :goto_e1

    .end local v59           #use24Hour:Z
    :cond_1db
    invoke-static/range {p0 .. p0}, Landroid/text/format/DateFormat;->is24HourFormat(Landroid/content/Context;)Z

    move-result v59

    .restart local v59       #use24Hour:Z
    goto/16 :goto_e1

    :cond_1e1
    const v62, 0x84000

    and-int v62, v62, p6

    if-eqz v62, :cond_29a

    const/4 v5, 0x1

    .local v5, abbrevTime:Z
    :goto_1e9
    move/from16 v0, p6

    and-int/lit16 v0, v0, 0x100

    move/from16 v62, v0

    if-eqz v62, :cond_29d

    const/4 v7, 0x1

    .local v7, capAMPM:Z
    :goto_1f2
    move/from16 v0, p6

    and-int/lit16 v0, v0, 0x200

    move/from16 v62, v0

    if-eqz v62, :cond_2a0

    const/16 v35, 0x1

    .local v35, noNoon:Z
    :goto_1fc
    move/from16 v0, p6

    and-int/lit16 v0, v0, 0x400

    move/from16 v62, v0

    if-eqz v62, :cond_2a4

    const/4 v9, 0x1

    .local v9, capNoon:Z
    :goto_205
    move/from16 v0, p6

    and-int/lit16 v0, v0, 0x800

    move/from16 v62, v0

    if-eqz v62, :cond_2a7

    const/16 v33, 0x1

    .local v33, noMidnight:Z
    :goto_20f
    move/from16 v0, p6

    and-int/lit16 v0, v0, 0x1000

    move/from16 v62, v0

    if-eqz v62, :cond_2ab

    const/4 v8, 0x1

    .local v8, capMidnight:Z
    :goto_218
    move-object/from16 v0, v44

    iget v0, v0, Landroid/text/format/Time;->minute:I

    move/from16 v62, v0

    if-nez v62, :cond_2ae

    move-object/from16 v0, v44

    iget v0, v0, Landroid/text/format/Time;->second:I

    move/from16 v62, v0

    if-nez v62, :cond_2ae

    const/16 v51, 0x1

    .local v51, startOnTheHour:Z
    :goto_22a
    iget v0, v14, Landroid/text/format/Time;->minute:I

    move/from16 v62, v0

    if-nez v62, :cond_2b2

    iget v0, v14, Landroid/text/format/Time;->second:I

    move/from16 v62, v0

    if-nez v62, :cond_2b2

    const/16 v21, 0x1

    .local v21, endOnTheHour:Z
    :goto_238
    if-eqz v5, :cond_2c1

    if-eqz v51, :cond_2c1

    if-eqz v7, :cond_2b5

    const v62, 0x1040336

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v52

    :goto_249
    if-nez v31, :cond_279

    if-eqz v5, :cond_2ea

    if-eqz v21, :cond_2ea

    if-eqz v7, :cond_2dd

    const v62, 0x1040336

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v22

    :goto_25c
    iget v0, v14, Landroid/text/format/Time;->hour:I

    move/from16 v62, v0

    const/16 v63, 0xc

    move/from16 v0, v62

    move/from16 v1, v63

    if-ne v0, v1, :cond_313

    if-eqz v21, :cond_313

    if-nez v35, :cond_313

    if-eqz v9, :cond_306

    const v62, 0x10403b8

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v22

    :cond_279
    :goto_279
    move-object/from16 v0, v44

    iget v0, v0, Landroid/text/format/Time;->hour:I

    move/from16 v62, v0

    const/16 v63, 0xc

    move/from16 v0, v62

    move/from16 v1, v63

    if-ne v0, v1, :cond_f0

    if-eqz v51, :cond_f0

    if-nez v35, :cond_f0

    if-eqz v9, :cond_339

    const v62, 0x10403b8

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v52

    goto/16 :goto_f0

    .end local v5           #abbrevTime:Z
    .end local v7           #capAMPM:Z
    .end local v8           #capMidnight:Z
    .end local v9           #capNoon:Z
    .end local v21           #endOnTheHour:Z
    .end local v33           #noMidnight:Z
    .end local v35           #noNoon:Z
    .end local v51           #startOnTheHour:Z
    :cond_29a
    const/4 v5, 0x0

    goto/16 :goto_1e9

    .restart local v5       #abbrevTime:Z
    :cond_29d
    const/4 v7, 0x0

    goto/16 :goto_1f2

    .restart local v7       #capAMPM:Z
    :cond_2a0
    const/16 v35, 0x0

    goto/16 :goto_1fc

    .restart local v35       #noNoon:Z
    :cond_2a4
    const/4 v9, 0x0

    goto/16 :goto_205

    .restart local v9       #capNoon:Z
    :cond_2a7
    const/16 v33, 0x0

    goto/16 :goto_20f

    .restart local v33       #noMidnight:Z
    :cond_2ab
    const/4 v8, 0x0

    goto/16 :goto_218

    .restart local v8       #capMidnight:Z
    :cond_2ae
    const/16 v51, 0x0

    goto/16 :goto_22a

    .restart local v51       #startOnTheHour:Z
    :cond_2b2
    const/16 v21, 0x0

    goto :goto_238

    .restart local v21       #endOnTheHour:Z
    :cond_2b5
    const v62, 0x1040335

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v52

    goto :goto_249

    :cond_2c1
    if-eqz v7, :cond_2d0

    const v62, 0x1040080

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v52

    goto/16 :goto_249

    :cond_2d0
    const v62, 0x104007f

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v52

    goto/16 :goto_249

    :cond_2dd
    const v62, 0x1040335

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v22

    goto/16 :goto_25c

    :cond_2ea
    if-eqz v7, :cond_2f9

    const v62, 0x1040080

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v22

    goto/16 :goto_25c

    :cond_2f9
    const v62, 0x104007f

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v22

    goto/16 :goto_25c

    :cond_306
    const v62, 0x10403b7

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v22

    goto/16 :goto_279

    :cond_313
    iget v0, v14, Landroid/text/format/Time;->hour:I

    move/from16 v62, v0

    if-nez v62, :cond_279

    if-eqz v21, :cond_279

    if-nez v33, :cond_279

    if-eqz v8, :cond_32c

    const v62, 0x10403ba

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v22

    goto/16 :goto_279

    :cond_32c
    const v62, 0x10403b9

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v22

    goto/16 :goto_279

    :cond_339
    const v62, 0x10403b7

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v52

    goto/16 :goto_f0

    .end local v5           #abbrevTime:Z
    .end local v7           #capAMPM:Z
    .end local v8           #capMidnight:Z
    .end local v9           #capNoon:Z
    .end local v21           #endOnTheHour:Z
    .end local v33           #noMidnight:Z
    .end local v35           #noNoon:Z
    .end local v51           #startOnTheHour:Z
    :cond_346
    move-object/from16 v0, v22

    invoke-virtual {v14, v0}, Landroid/text/format/Time;->format(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v23

    goto/16 :goto_fc

    .end local v22           #endTimeFormat:Ljava/lang/String;
    .end local v27           #force12Hour:Z
    .end local v28           #force24Hour:Z
    .end local v52           #startTimeFormat:Ljava/lang/String;
    .end local v59           #use24Hour:Z
    :cond_34e
    if-eqz v36, :cond_354

    const/16 v43, 0x0

    goto/16 :goto_fe

    :cond_354
    move/from16 v0, v55

    move/from16 v1, v25

    if-eq v0, v1, :cond_35e

    const/16 v43, 0x1

    goto/16 :goto_fe

    :cond_35e
    new-instance v10, Landroid/text/format/Time;

    invoke-direct {v10}, Landroid/text/format/Time;-><init>()V

    .local v10, currentTime:Landroid/text/format/Time;
    invoke-virtual {v10}, Landroid/text/format/Time;->setToNow()V

    iget v0, v10, Landroid/text/format/Time;->year:I

    move/from16 v62, v0

    move/from16 v0, v55

    move/from16 v1, v62

    if-eq v0, v1, :cond_374

    const/16 v43, 0x1

    :goto_372
    goto/16 :goto_fe

    :cond_374
    const/16 v43, 0x0

    goto :goto_372

    .end local v10           #currentTime:Landroid/text/format/Time;
    :cond_377
    if-eqz v43, :cond_3b3

    if-eqz v4, :cond_397

    if-eqz v34, :cond_38a

    const v62, 0x1040091

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v13

    .restart local v13       #defaultDateFormat:Ljava/lang/String;
    goto/16 :goto_10b

    .end local v13           #defaultDateFormat:Ljava/lang/String;
    :cond_38a
    const v62, 0x104008b

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v13

    .restart local v13       #defaultDateFormat:Ljava/lang/String;
    goto/16 :goto_10b

    .end local v13           #defaultDateFormat:Ljava/lang/String;
    :cond_397
    if-eqz v34, :cond_3a6

    const v62, 0x104008e

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v13

    .restart local v13       #defaultDateFormat:Ljava/lang/String;
    goto/16 :goto_10b

    .end local v13           #defaultDateFormat:Ljava/lang/String;
    :cond_3a6
    const v62, 0x1040086

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v13

    .restart local v13       #defaultDateFormat:Ljava/lang/String;
    goto/16 :goto_10b

    .end local v13           #defaultDateFormat:Ljava/lang/String;
    :cond_3b3
    if-eqz v4, :cond_3d1

    if-eqz v34, :cond_3c4

    const v62, 0x1040090

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v13

    .restart local v13       #defaultDateFormat:Ljava/lang/String;
    goto/16 :goto_10b

    .end local v13           #defaultDateFormat:Ljava/lang/String;
    :cond_3c4
    const v62, 0x104008f

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v13

    .restart local v13       #defaultDateFormat:Ljava/lang/String;
    goto/16 :goto_10b

    .end local v13           #defaultDateFormat:Ljava/lang/String;
    :cond_3d1
    if-eqz v34, :cond_3e0

    const v62, 0x104008d

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v13

    .restart local v13       #defaultDateFormat:Ljava/lang/String;
    goto/16 :goto_10b

    .end local v13           #defaultDateFormat:Ljava/lang/String;
    :cond_3e0
    const v62, 0x104008c

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v13

    .restart local v13       #defaultDateFormat:Ljava/lang/String;
    goto/16 :goto_10b

    :cond_3ed
    const v62, 0x104009d

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v29

    .restart local v29       #fullFormat:Ljava/lang/String;
    goto/16 :goto_11a

    .end local v29           #fullFormat:Ljava/lang/String;
    :cond_3fa
    if-eqz v41, :cond_409

    const v62, 0x104009e

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v29

    .restart local v29       #fullFormat:Ljava/lang/String;
    goto/16 :goto_11a

    .end local v29           #fullFormat:Ljava/lang/String;
    :cond_409
    const v62, 0x1040093

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v29

    .restart local v29       #fullFormat:Ljava/lang/String;
    goto/16 :goto_11a

    :cond_416
    move/from16 v0, v55

    move/from16 v1, v25

    if-ne v0, v1, :cond_41e

    if-eqz v34, :cond_454

    :cond_41e
    move-object/from16 v0, v44

    invoke-virtual {v0, v13}, Landroid/text/format/Time;->format(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v45

    .local v45, startDateString:Ljava/lang/String;
    invoke-virtual {v14, v13}, Landroid/text/format/Time;->format(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    .local v15, endDateString:Ljava/lang/String;
    const/16 v62, 0x6

    move/from16 v0, v62

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v62, v0

    const/16 v63, 0x0

    aput-object v54, v62, v63

    const/16 v63, 0x1

    aput-object v45, v62, v63

    const/16 v63, 0x2

    aput-object v53, v62, v63

    const/16 v63, 0x3

    aput-object v24, v62, v63

    const/16 v63, 0x4

    aput-object v15, v62, v63

    const/16 v63, 0x5

    aput-object v23, v62, v63

    move-object/from16 v0, p1

    move-object/from16 v1, v29

    move-object/from16 v2, v62

    invoke-virtual {v0, v1, v2}, Ljava/util/Formatter;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/util/Formatter;

    move-result-object v62

    goto/16 :goto_146

    .end local v15           #endDateString:Ljava/lang/String;
    .end local v45           #startDateString:Ljava/lang/String;
    :cond_454
    if-eqz v37, :cond_4dc

    const-string v32, "%m"

    .local v32, monthFormat:Ljava/lang/String;
    :goto_458
    move-object/from16 v0, v44

    move-object/from16 v1, v32

    invoke-virtual {v0, v1}, Landroid/text/format/Time;->format(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v50

    .local v50, startMonthString:Ljava/lang/String;
    const-string v62, "%-d"

    move-object/from16 v0, v44

    move-object/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/text/format/Time;->format(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v48

    .local v48, startMonthDayString:Ljava/lang/String;
    const-string v62, "%Y"

    move-object/from16 v0, v44

    move-object/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/text/format/Time;->format(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v56

    .local v56, startYearString:Ljava/lang/String;
    if-eqz v31, :cond_4ef

    const/16 v20, 0x0

    .local v20, endMonthString:Ljava/lang/String;
    :goto_478
    if-eqz v31, :cond_4f6

    const/16 v18, 0x0

    .local v18, endMonthDayString:Ljava/lang/String;
    :goto_47c
    if-eqz v31, :cond_500

    const/16 v26, 0x0

    .local v26, endYearString:Ljava/lang/String;
    :goto_480
    move/from16 v0, v49

    move/from16 v1, v19

    if-eq v0, v1, :cond_50a

    const/16 v30, 0x0

    .local v30, index:I
    if-eqz v42, :cond_48c

    const/16 v30, 0x1

    :cond_48c
    if-eqz v43, :cond_490

    add-int/lit8 v30, v30, 0x2

    :cond_490
    if-eqz v41, :cond_494

    add-int/lit8 v30, v30, 0x4

    :cond_494
    if-eqz v37, :cond_498

    add-int/lit8 v30, v30, 0x8

    :cond_498
    sget-object v62, Landroid/text/format/DateUtils;->sameYearTable:[I

    aget v39, v62, v30

    .local v39, resId:I
    invoke-virtual/range {v38 .. v39}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v29

    const/16 v62, 0xa

    move/from16 v0, v62

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v62, v0

    const/16 v63, 0x0

    aput-object v54, v62, v63

    const/16 v63, 0x1

    aput-object v50, v62, v63

    const/16 v63, 0x2

    aput-object v48, v62, v63

    const/16 v63, 0x3

    aput-object v56, v62, v63

    const/16 v63, 0x4

    aput-object v53, v62, v63

    const/16 v63, 0x5

    aput-object v24, v62, v63

    const/16 v63, 0x6

    aput-object v20, v62, v63

    const/16 v63, 0x7

    aput-object v18, v62, v63

    const/16 v63, 0x8

    aput-object v26, v62, v63

    const/16 v63, 0x9

    aput-object v23, v62, v63

    move-object/from16 v0, p1

    move-object/from16 v1, v29

    move-object/from16 v2, v62

    invoke-virtual {v0, v1, v2}, Ljava/util/Formatter;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/util/Formatter;

    move-result-object v62

    goto/16 :goto_146

    .end local v18           #endMonthDayString:Ljava/lang/String;
    .end local v20           #endMonthString:Ljava/lang/String;
    .end local v26           #endYearString:Ljava/lang/String;
    .end local v30           #index:I
    .end local v32           #monthFormat:Ljava/lang/String;
    .end local v39           #resId:I
    .end local v48           #startMonthDayString:Ljava/lang/String;
    .end local v50           #startMonthString:Ljava/lang/String;
    .end local v56           #startYearString:Ljava/lang/String;
    :cond_4dc
    if-eqz v4, :cond_4eb

    const v62, 0x10400b2

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v32

    .restart local v32       #monthFormat:Ljava/lang/String;
    goto/16 :goto_458

    .end local v32           #monthFormat:Ljava/lang/String;
    :cond_4eb
    const-string v32, "%B"

    .restart local v32       #monthFormat:Ljava/lang/String;
    goto/16 :goto_458

    .restart local v48       #startMonthDayString:Ljava/lang/String;
    .restart local v50       #startMonthString:Ljava/lang/String;
    .restart local v56       #startYearString:Ljava/lang/String;
    :cond_4ef
    move-object/from16 v0, v32

    invoke-virtual {v14, v0}, Landroid/text/format/Time;->format(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    goto :goto_478

    .restart local v20       #endMonthString:Ljava/lang/String;
    :cond_4f6
    const-string v62, "%-d"

    move-object/from16 v0, v62

    invoke-virtual {v14, v0}, Landroid/text/format/Time;->format(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    goto/16 :goto_47c

    .restart local v18       #endMonthDayString:Ljava/lang/String;
    :cond_500
    const-string v62, "%Y"

    move-object/from16 v0, v62

    invoke-virtual {v14, v0}, Landroid/text/format/Time;->format(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    goto/16 :goto_480

    .restart local v26       #endYearString:Ljava/lang/String;
    :cond_50a
    move/from16 v0, v46

    move/from16 v1, v16

    if-eq v0, v1, :cond_566

    const/16 v30, 0x0

    .restart local v30       #index:I
    if-eqz v42, :cond_516

    const/16 v30, 0x1

    :cond_516
    if-eqz v43, :cond_51a

    add-int/lit8 v30, v30, 0x2

    :cond_51a
    if-eqz v41, :cond_51e

    add-int/lit8 v30, v30, 0x4

    :cond_51e
    if-eqz v37, :cond_522

    add-int/lit8 v30, v30, 0x8

    :cond_522
    sget-object v62, Landroid/text/format/DateUtils;->sameMonthTable:[I

    aget v39, v62, v30

    .restart local v39       #resId:I
    invoke-virtual/range {v38 .. v39}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v29

    const/16 v62, 0xa

    move/from16 v0, v62

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v62, v0

    const/16 v63, 0x0

    aput-object v54, v62, v63

    const/16 v63, 0x1

    aput-object v50, v62, v63

    const/16 v63, 0x2

    aput-object v48, v62, v63

    const/16 v63, 0x3

    aput-object v56, v62, v63

    const/16 v63, 0x4

    aput-object v53, v62, v63

    const/16 v63, 0x5

    aput-object v24, v62, v63

    const/16 v63, 0x6

    aput-object v20, v62, v63

    const/16 v63, 0x7

    aput-object v18, v62, v63

    const/16 v63, 0x8

    aput-object v26, v62, v63

    const/16 v63, 0x9

    aput-object v23, v62, v63

    move-object/from16 v0, p1

    move-object/from16 v1, v29

    move-object/from16 v2, v62

    invoke-virtual {v0, v1, v2}, Ljava/util/Formatter;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/util/Formatter;

    move-result-object v62

    goto/16 :goto_146

    .end local v30           #index:I
    .end local v39           #resId:I
    :cond_566
    and-int/lit8 v62, p6, 0x10

    if-eqz v62, :cond_5b7

    const/16 v40, 0x1

    .local v40, showDate:Z
    :goto_56c
    if-nez v41, :cond_574

    if-nez v40, :cond_574

    if-nez v42, :cond_574

    const/16 v40, 0x1

    :cond_574
    const-string v58, ""

    .local v58, timeString:Ljava/lang/String;
    if-eqz v41, :cond_57c

    if-eqz v31, :cond_5ba

    move-object/from16 v58, v53

    :cond_57c
    :goto_57c
    const-string v29, ""

    const-string v11, ""

    .local v11, dateString:Ljava/lang/String;
    if-eqz v40, :cond_612

    move-object/from16 v0, v44

    invoke-virtual {v0, v13}, Landroid/text/format/Time;->format(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    if-eqz v42, :cond_5ea

    if-eqz v41, :cond_5de

    const v62, 0x104009f

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v29

    :cond_597
    :goto_597
    const/16 v62, 0x3

    move/from16 v0, v62

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v62, v0

    const/16 v63, 0x0

    aput-object v58, v62, v63

    const/16 v63, 0x1

    aput-object v54, v62, v63

    const/16 v63, 0x2

    aput-object v11, v62, v63

    move-object/from16 v0, p1

    move-object/from16 v1, v29

    move-object/from16 v2, v62

    invoke-virtual {v0, v1, v2}, Ljava/util/Formatter;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/util/Formatter;

    move-result-object v62

    goto/16 :goto_146

    .end local v11           #dateString:Ljava/lang/String;
    .end local v40           #showDate:Z
    .end local v58           #timeString:Ljava/lang/String;
    :cond_5b7
    const/16 v40, 0x0

    goto :goto_56c

    .restart local v40       #showDate:Z
    .restart local v58       #timeString:Ljava/lang/String;
    :cond_5ba
    const v62, 0x1040092

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v57

    .local v57, timeFormat:Ljava/lang/String;
    const/16 v62, 0x2

    move/from16 v0, v62

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v62, v0

    const/16 v63, 0x0

    aput-object v53, v62, v63

    const/16 v63, 0x1

    aput-object v23, v62, v63

    move-object/from16 v0, v57

    move-object/from16 v1, v62

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v58

    goto :goto_57c

    .end local v57           #timeFormat:Ljava/lang/String;
    .restart local v11       #dateString:Ljava/lang/String;
    :cond_5de
    const v62, 0x10400a0

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v29

    goto :goto_597

    :cond_5ea
    if-eqz v41, :cond_5f8

    const v62, 0x104008a

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v29

    goto :goto_597

    :cond_5f8
    const-string v62, "%s"

    const/16 v63, 0x1

    move/from16 v0, v63

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v63, v0

    const/16 v64, 0x0

    aput-object v11, v63, v64

    move-object/from16 v0, p1

    move-object/from16 v1, v62

    move-object/from16 v2, v63

    invoke-virtual {v0, v1, v2}, Ljava/util/Formatter;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/util/Formatter;

    move-result-object v62

    goto/16 :goto_146

    :cond_612
    if-eqz v42, :cond_63d

    if-eqz v41, :cond_623

    const v62, 0x10400a1

    move-object/from16 v0, v38

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v29

    goto/16 :goto_597

    :cond_623
    const-string v62, "%s"

    const/16 v63, 0x1

    move/from16 v0, v63

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v63, v0

    const/16 v64, 0x0

    aput-object v54, v63, v64

    move-object/from16 v0, p1

    move-object/from16 v1, v62

    move-object/from16 v2, v63

    invoke-virtual {v0, v1, v2}, Ljava/util/Formatter;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/util/Formatter;

    move-result-object v62

    goto/16 :goto_146

    :cond_63d
    if-eqz v41, :cond_597

    const-string v62, "%s"

    const/16 v63, 0x1

    move/from16 v0, v63

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v63, v0

    const/16 v64, 0x0

    aput-object v58, v63, v64

    move-object/from16 v0, p1

    move-object/from16 v1, v62

    move-object/from16 v2, v63

    invoke-virtual {v0, v1, v2}, Ljava/util/Formatter;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/util/Formatter;

    move-result-object v62

    goto/16 :goto_146
.end method

.method public static formatDateTime(Landroid/content/Context;JI)Ljava/lang/String;
    .registers 10
    .parameter "context"
    .parameter "millis"
    .parameter "flags"

    .prologue
    move-object v0, p0

    move-wide v1, p1

    move-wide v3, p1

    move v5, p3

    invoke-static/range {v0 .. v5}, Landroid/text/format/DateUtils;->formatDateRange(Landroid/content/Context;JJI)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static formatElapsedTime(J)Ljava/lang/String;
    .registers 3
    .parameter "elapsedSeconds"

    .prologue
    const/4 v0, 0x0

    invoke-static {v0, p0, p1}, Landroid/text/format/DateUtils;->formatElapsedTime(Ljava/lang/StringBuilder;J)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static formatElapsedTime(Ljava/lang/StringBuilder;J)Ljava/lang/String;
    .registers 17
    .parameter "recycle"
    .parameter "elapsedSeconds"

    .prologue
    invoke-static {}, Landroid/text/format/DateUtils;->initFormatStrings()V

    const-wide/16 v2, 0x0

    .local v2, hours:J
    const-wide/16 v4, 0x0

    .local v4, minutes:J
    const-wide/16 v6, 0x0

    .local v6, seconds:J
    const-wide/16 v0, 0xe10

    cmp-long v0, p1, v0

    if-ltz v0, :cond_17

    const-wide/16 v0, 0xe10

    div-long v2, p1, v0

    const-wide/16 v0, 0xe10

    mul-long/2addr v0, v2

    sub-long/2addr p1, v0

    :cond_17
    const-wide/16 v0, 0x3c

    cmp-long v0, p1, v0

    if-ltz v0, :cond_25

    const-wide/16 v0, 0x3c

    div-long v4, p1, v0

    const-wide/16 v0, 0x3c

    mul-long/2addr v0, v4

    sub-long/2addr p1, v0

    :cond_25
    move-wide v6, p1

    const-wide/16 v0, 0x0

    cmp-long v0, v2, v0

    if-lez v0, :cond_34

    sget-object v1, Landroid/text/format/DateUtils;->sElapsedFormatHMMSS:Ljava/lang/String;

    move-object v0, p0

    invoke-static/range {v0 .. v7}, Landroid/text/format/DateUtils;->formatElapsedTime(Ljava/lang/StringBuilder;Ljava/lang/String;JJJ)Ljava/lang/String;

    move-result-object v0

    :goto_33
    return-object v0

    :cond_34
    sget-object v9, Landroid/text/format/DateUtils;->sElapsedFormatMMSS:Ljava/lang/String;

    move-object v8, p0

    move-wide v10, v4

    move-wide v12, v6

    invoke-static/range {v8 .. v13}, Landroid/text/format/DateUtils;->formatElapsedTime(Ljava/lang/StringBuilder;Ljava/lang/String;JJ)Ljava/lang/String;

    move-result-object v0

    goto :goto_33
.end method

.method private static formatElapsedTime(Ljava/lang/StringBuilder;Ljava/lang/String;JJ)Ljava/lang/String;
    .registers 13
    .parameter "recycle"
    .parameter "format"
    .parameter "minutes"
    .parameter "seconds"

    .prologue
    const/16 v6, 0x30

    const/4 v5, 0x0

    const-wide/16 v3, 0xa

    const-string v1, "%1$02d:%2$02d"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_59

    move-object v0, p0

    .local v0, sb:Ljava/lang/StringBuilder;
    if-nez v0, :cond_41

    new-instance v0, Ljava/lang/StringBuilder;

    .end local v0           #sb:Ljava/lang/StringBuilder;
    const/16 v1, 0x8

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    .restart local v0       #sb:Ljava/lang/StringBuilder;
    :goto_17
    cmp-long v1, p2, v3

    if-gez v1, :cond_45

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    :goto_1e
    rem-long v1, p2, v3

    invoke-static {v1, v2}, Landroid/text/format/DateUtils;->toDigitChar(J)C

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    const/16 v1, 0x3a

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    cmp-long v1, p4, v3

    if-gez v1, :cond_4f

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    :goto_33
    rem-long v1, p4, v3

    invoke-static {v1, v2}, Landroid/text/format/DateUtils;->toDigitChar(J)C

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .end local v0           #sb:Ljava/lang/StringBuilder;
    :goto_40
    return-object v1

    .restart local v0       #sb:Ljava/lang/StringBuilder;
    :cond_41
    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->setLength(I)V

    goto :goto_17

    :cond_45
    div-long v1, p2, v3

    invoke-static {v1, v2}, Landroid/text/format/DateUtils;->toDigitChar(J)C

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_1e

    :cond_4f
    div-long v1, p4, v3

    invoke-static {v1, v2}, Landroid/text/format/DateUtils;->toDigitChar(J)C

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_33

    .end local v0           #sb:Ljava/lang/StringBuilder;
    :cond_59
    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {p2, p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v1, v5

    const/4 v2, 0x1

    invoke-static {p4, p5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {p1, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto :goto_40
.end method

.method private static formatElapsedTime(Ljava/lang/StringBuilder;Ljava/lang/String;JJJ)Ljava/lang/String;
    .registers 16
    .parameter "recycle"
    .parameter "format"
    .parameter "hours"
    .parameter "minutes"
    .parameter "seconds"

    .prologue
    const/16 v7, 0x3a

    const/16 v6, 0x30

    const/4 v5, 0x0

    const-wide/16 v3, 0xa

    const-string v1, "%1$d:%2$02d:%3$02d"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5f

    move-object v0, p0

    .local v0, sb:Ljava/lang/StringBuilder;
    if-nez v0, :cond_47

    new-instance v0, Ljava/lang/StringBuilder;

    .end local v0           #sb:Ljava/lang/StringBuilder;
    const/16 v1, 0x8

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    .restart local v0       #sb:Ljava/lang/StringBuilder;
    :goto_19
    invoke-virtual {v0, p2, p3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    cmp-long v1, p4, v3

    if-gez v1, :cond_4b

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    :goto_26
    rem-long v1, p4, v3

    invoke-static {v1, v2}, Landroid/text/format/DateUtils;->toDigitChar(J)C

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    cmp-long v1, p6, v3

    if-gez v1, :cond_55

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    :goto_39
    rem-long v1, p6, v3

    invoke-static {v1, v2}, Landroid/text/format/DateUtils;->toDigitChar(J)C

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .end local v0           #sb:Ljava/lang/StringBuilder;
    :goto_46
    return-object v1

    .restart local v0       #sb:Ljava/lang/StringBuilder;
    :cond_47
    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->setLength(I)V

    goto :goto_19

    :cond_4b
    div-long v1, p4, v3

    invoke-static {v1, v2}, Landroid/text/format/DateUtils;->toDigitChar(J)C

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_26

    :cond_55
    div-long v1, p6, v3

    invoke-static {v1, v2}, Landroid/text/format/DateUtils;->toDigitChar(J)C

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_39

    .end local v0           #sb:Ljava/lang/StringBuilder;
    :cond_5f
    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {p2, p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v1, v5

    const/4 v2, 0x1

    invoke-static {p4, p5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x2

    invoke-static {p6, p7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {p1, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto :goto_46
.end method

.method public static final formatSameDayTime(JJII)Ljava/lang/CharSequence;
    .registers 14
    .parameter "then"
    .parameter "now"
    .parameter "dateStyle"
    .parameter "timeStyle"

    .prologue
    const/4 v7, 0x5

    const/4 v6, 0x2

    const/4 v5, 0x1

    new-instance v2, Ljava/util/GregorianCalendar;

    invoke-direct {v2}, Ljava/util/GregorianCalendar;-><init>()V

    .local v2, thenCal:Ljava/util/Calendar;
    invoke-virtual {v2, p0, p1}, Ljava/util/GregorianCalendar;->setTimeInMillis(J)V

    invoke-virtual {v2}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v3

    .local v3, thenDate:Ljava/util/Date;
    new-instance v1, Ljava/util/GregorianCalendar;

    invoke-direct {v1}, Ljava/util/GregorianCalendar;-><init>()V

    .local v1, nowCal:Ljava/util/Calendar;
    invoke-virtual {v1, p2, p3}, Ljava/util/GregorianCalendar;->setTimeInMillis(J)V

    invoke-virtual {v2, v5}, Ljava/util/Calendar;->get(I)I

    move-result v4

    invoke-virtual {v1, v5}, Ljava/util/Calendar;->get(I)I

    move-result v5

    if-ne v4, v5, :cond_3e

    invoke-virtual {v2, v6}, Ljava/util/Calendar;->get(I)I

    move-result v4

    invoke-virtual {v1, v6}, Ljava/util/Calendar;->get(I)I

    move-result v5

    if-ne v4, v5, :cond_3e

    invoke-virtual {v2, v7}, Ljava/util/Calendar;->get(I)I

    move-result v4

    invoke-virtual {v1, v7}, Ljava/util/Calendar;->get(I)I

    move-result v5

    if-ne v4, v5, :cond_3e

    invoke-static {p5}, Ljava/text/DateFormat;->getTimeInstance(I)Ljava/text/DateFormat;

    move-result-object v0

    .local v0, f:Ljava/text/DateFormat;
    :goto_39
    invoke-virtual {v0, v3}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v4

    return-object v4

    .end local v0           #f:Ljava/text/DateFormat;
    :cond_3e
    invoke-static {p4}, Ljava/text/DateFormat;->getDateInstance(I)Ljava/text/DateFormat;

    move-result-object v0

    .restart local v0       #f:Ljava/text/DateFormat;
    goto :goto_39
.end method

.method public static getAMPMString(I)Ljava/lang/String;
    .registers 4
    .parameter "ampm"

    .prologue
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v0

    .local v0, r:Landroid/content/res/Resources;
    sget-object v1, Landroid/text/format/DateUtils;->sAmPm:[I

    add-int/lit8 v2, p0, 0x0

    aget v1, v1, v2

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public static getDayOfWeekString(II)Ljava/lang/String;
    .registers 5
    .parameter "dayOfWeek"
    .parameter "abbrev"

    .prologue
    sparse-switch p1, :sswitch_data_22

    sget-object v0, Landroid/text/format/DateUtils;->sDaysMedium:[I

    .local v0, list:[I
    :goto_5
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v1

    .local v1, r:Landroid/content/res/Resources;
    add-int/lit8 v2, p0, -0x1

    aget v2, v0, v2

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    return-object v2

    .end local v0           #list:[I
    .end local v1           #r:Landroid/content/res/Resources;
    :sswitch_12
    sget-object v0, Landroid/text/format/DateUtils;->sDaysLong:[I

    .restart local v0       #list:[I
    goto :goto_5

    .end local v0           #list:[I
    :sswitch_15
    sget-object v0, Landroid/text/format/DateUtils;->sDaysMedium:[I

    .restart local v0       #list:[I
    goto :goto_5

    .end local v0           #list:[I
    :sswitch_18
    sget-object v0, Landroid/text/format/DateUtils;->sDaysShort:[I

    .restart local v0       #list:[I
    goto :goto_5

    .end local v0           #list:[I
    :sswitch_1b
    sget-object v0, Landroid/text/format/DateUtils;->sDaysShort:[I

    .restart local v0       #list:[I
    goto :goto_5

    .end local v0           #list:[I
    :sswitch_1e
    sget-object v0, Landroid/text/format/DateUtils;->sDaysShortest:[I

    .restart local v0       #list:[I
    goto :goto_5

    nop

    :sswitch_data_22
    .sparse-switch
        0xa -> :sswitch_12
        0x14 -> :sswitch_15
        0x1e -> :sswitch_18
        0x28 -> :sswitch_1b
        0x32 -> :sswitch_1e
    .end sparse-switch
.end method

.method public static getMonthString(II)Ljava/lang/String;
    .registers 5
    .parameter "month"
    .parameter "abbrev"

    .prologue
    sparse-switch p1, :sswitch_data_22

    sget-object v0, Landroid/text/format/DateUtils;->sMonthsMedium:[I

    .local v0, list:[I
    :goto_5
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v1

    .local v1, r:Landroid/content/res/Resources;
    add-int/lit8 v2, p0, 0x0

    aget v2, v0, v2

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    return-object v2

    .end local v0           #list:[I
    .end local v1           #r:Landroid/content/res/Resources;
    :sswitch_12
    sget-object v0, Landroid/text/format/DateUtils;->sMonthsLong:[I

    .restart local v0       #list:[I
    goto :goto_5

    .end local v0           #list:[I
    :sswitch_15
    sget-object v0, Landroid/text/format/DateUtils;->sMonthsMedium:[I

    .restart local v0       #list:[I
    goto :goto_5

    .end local v0           #list:[I
    :sswitch_18
    sget-object v0, Landroid/text/format/DateUtils;->sMonthsMedium:[I

    .restart local v0       #list:[I
    goto :goto_5

    .end local v0           #list:[I
    :sswitch_1b
    sget-object v0, Landroid/text/format/DateUtils;->sMonthsMedium:[I

    .restart local v0       #list:[I
    goto :goto_5

    .end local v0           #list:[I
    :sswitch_1e
    sget-object v0, Landroid/text/format/DateUtils;->sMonthsShortest:[I

    .restart local v0       #list:[I
    goto :goto_5

    nop

    :sswitch_data_22
    .sparse-switch
        0xa -> :sswitch_12
        0x14 -> :sswitch_15
        0x1e -> :sswitch_18
        0x28 -> :sswitch_1b
        0x32 -> :sswitch_1e
    .end sparse-switch
.end method

.method private static declared-synchronized getNumberOfDaysPassed(JJ)J
    .registers 10
    .parameter "date1"
    .parameter "date2"

    .prologue
    const-class v3, Landroid/text/format/DateUtils;

    monitor-enter v3

    :try_start_3
    sget-object v2, Landroid/text/format/DateUtils;->sThenTime:Landroid/text/format/Time;

    if-nez v2, :cond_e

    new-instance v2, Landroid/text/format/Time;

    invoke-direct {v2}, Landroid/text/format/Time;-><init>()V

    sput-object v2, Landroid/text/format/DateUtils;->sThenTime:Landroid/text/format/Time;

    :cond_e
    sget-object v2, Landroid/text/format/DateUtils;->sThenTime:Landroid/text/format/Time;

    invoke-virtual {v2, p0, p1}, Landroid/text/format/Time;->set(J)V

    sget-object v2, Landroid/text/format/DateUtils;->sThenTime:Landroid/text/format/Time;

    iget-wide v4, v2, Landroid/text/format/Time;->gmtoff:J

    invoke-static {p0, p1, v4, v5}, Landroid/text/format/Time;->getJulianDay(JJ)I

    move-result v0

    .local v0, day1:I
    sget-object v2, Landroid/text/format/DateUtils;->sThenTime:Landroid/text/format/Time;

    invoke-virtual {v2, p2, p3}, Landroid/text/format/Time;->set(J)V

    sget-object v2, Landroid/text/format/DateUtils;->sThenTime:Landroid/text/format/Time;

    iget-wide v4, v2, Landroid/text/format/Time;->gmtoff:J

    invoke-static {p2, p3, v4, v5}, Landroid/text/format/Time;->getJulianDay(JJ)I

    move-result v1

    .local v1, day2:I
    sub-int v2, v1, v0

    invoke-static {v2}, Ljava/lang/Math;->abs(I)I
    :try_end_2d
    .catchall {:try_start_3 .. :try_end_2d} :catchall_31

    move-result v2

    int-to-long v4, v2

    monitor-exit v3

    return-wide v4

    .end local v0           #day1:I
    .end local v1           #day2:I
    :catchall_31
    move-exception v2

    monitor-exit v3

    throw v2
.end method

.method public static getRelativeDateTimeString(Landroid/content/Context;JJJI)Ljava/lang/CharSequence;
    .registers 27
    .parameter "c"
    .parameter "time"
    .parameter "minResolution"
    .parameter "transitionResolution"
    .parameter "flags"

    .prologue
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v15

    .local v15, r:Landroid/content/res/Resources;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v13

    .local v13, now:J
    sub-long v3, v13, p1

    invoke-static {v3, v4}, Ljava/lang/Math;->abs(J)J

    move-result-wide v11

    .local v11, duration:J
    const-wide/32 v3, 0x240c8400

    cmp-long v3, p5, v3

    if-lez v3, :cond_43

    const-wide/32 p5, 0x240c8400

    :cond_18
    :goto_18
    const/4 v8, 0x1

    move-object/from16 v3, p0

    move-wide/from16 v4, p1

    move-wide/from16 v6, p1

    invoke-static/range {v3 .. v8}, Landroid/text/format/DateUtils;->formatDateRange(Landroid/content/Context;JJI)Ljava/lang/String;

    move-result-object v18

    .local v18, timeClause:Ljava/lang/CharSequence;
    cmp-long v3, v11, p5

    if-gez v3, :cond_4e

    move-wide/from16 v3, p1

    move-wide v5, v13

    move-wide/from16 v7, p3

    move/from16 v9, p7

    invoke-static/range {v3 .. v9}, Landroid/text/format/DateUtils;->getRelativeTimeSpanString(JJJI)Ljava/lang/CharSequence;

    move-result-object v16

    .local v16, relativeClause:Ljava/lang/CharSequence;
    const v3, 0x10403b6

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v16, v4, v5

    const/4 v5, 0x1

    aput-object v18, v4, v5

    invoke-virtual {v15, v3, v4}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v17

    .end local v16           #relativeClause:Ljava/lang/CharSequence;
    .local v17, result:Ljava/lang/String;
    :goto_42
    return-object v17

    .end local v17           #result:Ljava/lang/String;
    .end local v18           #timeClause:Ljava/lang/CharSequence;
    :cond_43
    const-wide/32 v3, 0x5265c00

    cmp-long v3, p5, v3

    if-gez v3, :cond_18

    const-wide/32 p5, 0x5265c00

    goto :goto_18

    .restart local v18       #timeClause:Ljava/lang/CharSequence;
    :cond_4e
    const/4 v3, 0x0

    move-object/from16 v0, p0

    move-wide/from16 v1, p1

    invoke-static {v0, v1, v2, v3}, Landroid/text/format/DateUtils;->getRelativeTimeSpanString(Landroid/content/Context;JZ)Ljava/lang/CharSequence;

    move-result-object v10

    .local v10, dateClause:Ljava/lang/CharSequence;
    const v3, 0x1040089

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v10, v4, v5

    const/4 v5, 0x1

    aput-object v18, v4, v5

    invoke-virtual {v15, v3, v4}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v17

    .restart local v17       #result:Ljava/lang/String;
    goto :goto_42
.end method

.method private static final getRelativeDayString(Landroid/content/res/Resources;JJ)Ljava/lang/String;
    .registers 16
    .parameter "r"
    .parameter "day"
    .parameter "today"

    .prologue
    new-instance v7, Landroid/text/format/Time;

    invoke-direct {v7}, Landroid/text/format/Time;-><init>()V

    .local v7, startTime:Landroid/text/format/Time;
    invoke-virtual {v7, p1, p2}, Landroid/text/format/Time;->set(J)V

    new-instance v1, Landroid/text/format/Time;

    invoke-direct {v1}, Landroid/text/format/Time;-><init>()V

    .local v1, currentTime:Landroid/text/format/Time;
    invoke-virtual {v1, p3, p4}, Landroid/text/format/Time;->set(J)V

    iget-wide v8, v7, Landroid/text/format/Time;->gmtoff:J

    invoke-static {p1, p2, v8, v9}, Landroid/text/format/Time;->getJulianDay(JJ)I

    move-result v6

    .local v6, startDay:I
    iget-wide v8, v1, Landroid/text/format/Time;->gmtoff:J

    invoke-static {p3, p4, v8, v9}, Landroid/text/format/Time;->getJulianDay(JJ)I

    move-result v0

    .local v0, currentDay:I
    sub-int v8, v0, v6

    invoke-static {v8}, Ljava/lang/Math;->abs(I)I

    move-result v2

    .local v2, days:I
    cmp-long v8, p3, p1

    if-lez v8, :cond_34

    const/4 v4, 0x1

    .local v4, past:Z
    :goto_27
    const/4 v8, 0x1

    if-ne v2, v8, :cond_3e

    if-eqz v4, :cond_36

    const v8, 0x104007b

    invoke-virtual {p0, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v8

    :goto_33
    return-object v8

    .end local v4           #past:Z
    :cond_34
    const/4 v4, 0x0

    goto :goto_27

    .restart local v4       #past:Z
    :cond_36
    const v8, 0x104007d

    invoke-virtual {p0, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v8

    goto :goto_33

    :cond_3e
    if-nez v2, :cond_48

    const v8, 0x104007c

    invoke-virtual {p0, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v8

    goto :goto_33

    :cond_48
    if-eqz v4, :cond_60

    const v5, 0x1130004

    .local v5, resId:I
    :goto_4d
    invoke-virtual {p0, v5, v2}, Landroid/content/res/Resources;->getQuantityString(II)Ljava/lang/String;

    move-result-object v3

    .local v3, format:Ljava/lang/String;
    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-static {v3, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    goto :goto_33

    .end local v3           #format:Ljava/lang/String;
    .end local v5           #resId:I
    :cond_60
    const v5, 0x1130008

    .restart local v5       #resId:I
    goto :goto_4d
.end method

.method public static getRelativeTimeSpanString(J)Ljava/lang/CharSequence;
    .registers 8
    .parameter "startTime"

    .prologue
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    const-wide/32 v4, 0xea60

    move-wide v0, p0

    invoke-static/range {v0 .. v5}, Landroid/text/format/DateUtils;->getRelativeTimeSpanString(JJJ)Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public static getRelativeTimeSpanString(JJJ)Ljava/lang/CharSequence;
    .registers 13
    .parameter "time"
    .parameter "now"
    .parameter "minResolution"

    .prologue
    const v6, 0x10014

    .local v6, flags:I
    move-wide v0, p0

    move-wide v2, p2

    move-wide v4, p4

    invoke-static/range {v0 .. v6}, Landroid/text/format/DateUtils;->getRelativeTimeSpanString(JJJI)Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public static getRelativeTimeSpanString(JJJI)Ljava/lang/CharSequence;
    .registers 22
    .parameter "time"
    .parameter "now"
    .parameter "minResolution"
    .parameter "flags"

    .prologue
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v13

    .local v13, r:Landroid/content/res/Resources;
    const/high16 v0, 0xc

    and-int v0, v0, p6

    if-eqz v0, :cond_43

    const/4 v6, 0x1

    .local v6, abbrevRelative:Z
    :goto_b
    cmp-long v0, p2, p0

    if-ltz v0, :cond_45

    const/4 v12, 0x1

    .local v12, past:Z
    :goto_10
    sub-long v0, p2, p0

    invoke-static {v0, v1}, Ljava/lang/Math;->abs(J)J

    move-result-wide v9

    .local v9, duration:J
    const-wide/32 v0, 0xea60

    cmp-long v0, v9, v0

    if-gez v0, :cond_54

    const-wide/32 v0, 0xea60

    cmp-long v0, p4, v0

    if-gez v0, :cond_54

    const-wide/16 v0, 0x3e8

    div-long v7, v9, v0

    .local v7, count:J
    if-eqz v12, :cond_4a

    if-eqz v6, :cond_47

    const v14, 0x1130009

    .local v14, resId:I
    :goto_2f
    long-to-int v0, v7

    invoke-virtual {v13, v14, v0}, Landroid/content/res/Resources;->getQuantityString(II)Ljava/lang/String;

    move-result-object v11

    .local v11, format:Ljava/lang/String;
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v0, v1

    invoke-static {v11, v0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .end local v7           #count:J
    .end local v11           #format:Ljava/lang/String;
    .end local v14           #resId:I
    :goto_42
    return-object v0

    .end local v6           #abbrevRelative:Z
    .end local v9           #duration:J
    .end local v12           #past:Z
    :cond_43
    const/4 v6, 0x0

    goto :goto_b

    .restart local v6       #abbrevRelative:Z
    :cond_45
    const/4 v12, 0x0

    goto :goto_10

    .restart local v7       #count:J
    .restart local v9       #duration:J
    .restart local v12       #past:Z
    :cond_47
    const/high16 v14, 0x113

    .restart local v14       #resId:I
    goto :goto_2f

    .end local v14           #resId:I
    :cond_4a
    if-eqz v6, :cond_50

    const v14, 0x113000d

    .restart local v14       #resId:I
    goto :goto_2f

    .end local v14           #resId:I
    :cond_50
    const v14, 0x1130005

    .restart local v14       #resId:I
    goto :goto_2f

    .end local v7           #count:J
    .end local v14           #resId:I
    :cond_54
    const-wide/32 v0, 0x36ee80

    cmp-long v0, v9, v0

    if-gez v0, :cond_7d

    const-wide/32 v0, 0x36ee80

    cmp-long v0, p4, v0

    if-gez v0, :cond_7d

    const-wide/32 v0, 0xea60

    div-long v7, v9, v0

    .restart local v7       #count:J
    if-eqz v12, :cond_73

    if-eqz v6, :cond_6f

    const v14, 0x113000a

    .restart local v14       #resId:I
    goto :goto_2f

    .end local v14           #resId:I
    :cond_6f
    const v14, 0x1130001

    .restart local v14       #resId:I
    goto :goto_2f

    .end local v14           #resId:I
    :cond_73
    if-eqz v6, :cond_79

    const v14, 0x113000e

    .restart local v14       #resId:I
    goto :goto_2f

    .end local v14           #resId:I
    :cond_79
    const v14, 0x1130006

    .restart local v14       #resId:I
    goto :goto_2f

    .end local v7           #count:J
    .end local v14           #resId:I
    :cond_7d
    const-wide/32 v0, 0x5265c00

    cmp-long v0, v9, v0

    if-gez v0, :cond_a6

    const-wide/32 v0, 0x5265c00

    cmp-long v0, p4, v0

    if-gez v0, :cond_a6

    const-wide/32 v0, 0x36ee80

    div-long v7, v9, v0

    .restart local v7       #count:J
    if-eqz v12, :cond_9c

    if-eqz v6, :cond_98

    const v14, 0x113000b

    .restart local v14       #resId:I
    goto :goto_2f

    .end local v14           #resId:I
    :cond_98
    const v14, 0x1130002

    .restart local v14       #resId:I
    goto :goto_2f

    .end local v14           #resId:I
    :cond_9c
    if-eqz v6, :cond_a2

    const v14, 0x113000f

    .restart local v14       #resId:I
    goto :goto_2f

    .end local v14           #resId:I
    :cond_a2
    const v14, 0x1130007

    .restart local v14       #resId:I
    goto :goto_2f

    .end local v7           #count:J
    .end local v14           #resId:I
    :cond_a6
    const-wide/32 v0, 0x240c8400

    cmp-long v0, v9, v0

    if-gez v0, :cond_d2

    const-wide/32 v0, 0x240c8400

    cmp-long v0, p4, v0

    if-gez v0, :cond_d2

    invoke-static/range {p0 .. p3}, Landroid/text/format/DateUtils;->getNumberOfDaysPassed(JJ)J

    move-result-wide v7

    .restart local v7       #count:J
    if-eqz v12, :cond_c6

    if-eqz v6, :cond_c1

    const v14, 0x113000c

    .restart local v14       #resId:I
    goto/16 :goto_2f

    .end local v14           #resId:I
    :cond_c1
    const v14, 0x1130004

    .restart local v14       #resId:I
    goto/16 :goto_2f

    .end local v14           #resId:I
    :cond_c6
    if-eqz v6, :cond_cd

    const v14, 0x1130010

    .restart local v14       #resId:I
    goto/16 :goto_2f

    .end local v14           #resId:I
    :cond_cd
    const v14, 0x1130008

    .restart local v14       #resId:I
    goto/16 :goto_2f

    .end local v7           #count:J
    .end local v14           #resId:I
    :cond_d2
    const/4 v0, 0x0

    move-wide v1, p0

    move-wide v3, p0

    move/from16 v5, p6

    invoke-static/range {v0 .. v5}, Landroid/text/format/DateUtils;->formatDateRange(Landroid/content/Context;JJI)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_42
.end method

.method public static getRelativeTimeSpanString(Landroid/content/Context;J)Ljava/lang/CharSequence;
    .registers 4
    .parameter "c"
    .parameter "millis"

    .prologue
    const/4 v0, 0x0

    invoke-static {p0, p1, p2, v0}, Landroid/text/format/DateUtils;->getRelativeTimeSpanString(Landroid/content/Context;JZ)Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public static getRelativeTimeSpanString(Landroid/content/Context;JZ)Ljava/lang/CharSequence;
    .registers 20
    .parameter "c"
    .parameter "millis"
    .parameter "withPreposition"

    .prologue
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v8

    .local v8, now:J
    sub-long v13, v8, p1

    .local v13, span:J
    const-class v15, Landroid/text/format/DateUtils;

    monitor-enter v15

    :try_start_9
    sget-object v2, Landroid/text/format/DateUtils;->sNowTime:Landroid/text/format/Time;

    if-nez v2, :cond_14

    new-instance v2, Landroid/text/format/Time;

    invoke-direct {v2}, Landroid/text/format/Time;-><init>()V

    sput-object v2, Landroid/text/format/DateUtils;->sNowTime:Landroid/text/format/Time;

    :cond_14
    sget-object v2, Landroid/text/format/DateUtils;->sThenTime:Landroid/text/format/Time;

    if-nez v2, :cond_1f

    new-instance v2, Landroid/text/format/Time;

    invoke-direct {v2}, Landroid/text/format/Time;-><init>()V

    sput-object v2, Landroid/text/format/DateUtils;->sThenTime:Landroid/text/format/Time;

    :cond_1f
    sget-object v2, Landroid/text/format/DateUtils;->sNowTime:Landroid/text/format/Time;

    invoke-virtual {v2, v8, v9}, Landroid/text/format/Time;->set(J)V

    sget-object v2, Landroid/text/format/DateUtils;->sThenTime:Landroid/text/format/Time;

    move-wide/from16 v0, p1

    invoke-virtual {v2, v0, v1}, Landroid/text/format/Time;->set(J)V

    const-wide/32 v2, 0x5265c00

    cmp-long v2, v13, v2

    if-gez v2, :cond_5c

    sget-object v2, Landroid/text/format/DateUtils;->sNowTime:Landroid/text/format/Time;

    iget v2, v2, Landroid/text/format/Time;->weekDay:I

    sget-object v3, Landroid/text/format/DateUtils;->sThenTime:Landroid/text/format/Time;

    iget v3, v3, Landroid/text/format/Time;->weekDay:I

    if-ne v2, v3, :cond_5c

    const/4 v7, 0x1

    .local v7, flags:I
    move-object/from16 v2, p0

    move-wide/from16 v3, p1

    move-wide/from16 v5, p1

    invoke-static/range {v2 .. v7}, Landroid/text/format/DateUtils;->formatDateRange(Landroid/content/Context;JJI)Ljava/lang/String;

    move-result-object v12

    .local v12, result:Ljava/lang/String;
    const v10, 0x10403a8

    .local v10, prepositionId:I
    :goto_4a
    if-eqz p3, :cond_5a

    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    .local v11, res:Landroid/content/res/Resources;
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object v12, v2, v3

    invoke-virtual {v11, v10, v2}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v12

    .end local v11           #res:Landroid/content/res/Resources;
    :cond_5a
    monitor-exit v15

    return-object v12

    .end local v7           #flags:I
    .end local v10           #prepositionId:I
    .end local v12           #result:Ljava/lang/String;
    :cond_5c
    sget-object v2, Landroid/text/format/DateUtils;->sNowTime:Landroid/text/format/Time;

    iget v2, v2, Landroid/text/format/Time;->year:I

    sget-object v3, Landroid/text/format/DateUtils;->sThenTime:Landroid/text/format/Time;

    iget v3, v3, Landroid/text/format/Time;->year:I

    if-eq v2, v3, :cond_77

    const v7, 0x20014

    .restart local v7       #flags:I
    move-object/from16 v2, p0

    move-wide/from16 v3, p1

    move-wide/from16 v5, p1

    invoke-static/range {v2 .. v7}, Landroid/text/format/DateUtils;->formatDateRange(Landroid/content/Context;JJI)Ljava/lang/String;

    move-result-object v12

    .restart local v12       #result:Ljava/lang/String;
    const v10, 0x10403a7

    .restart local v10       #prepositionId:I
    goto :goto_4a

    .end local v7           #flags:I
    .end local v10           #prepositionId:I
    .end local v12           #result:Ljava/lang/String;
    :cond_77
    const v7, 0x10010

    .restart local v7       #flags:I
    move-object/from16 v2, p0

    move-wide/from16 v3, p1

    move-wide/from16 v5, p1

    invoke-static/range {v2 .. v7}, Landroid/text/format/DateUtils;->formatDateRange(Landroid/content/Context;JJI)Ljava/lang/String;

    move-result-object v12

    .restart local v12       #result:Ljava/lang/String;
    const v10, 0x10403a7

    .restart local v10       #prepositionId:I
    goto :goto_4a

    .end local v7           #flags:I
    .end local v10           #prepositionId:I
    .end local v12           #result:Ljava/lang/String;
    :catchall_88
    move-exception v2

    monitor-exit v15
    :try_end_8a
    .catchall {:try_start_9 .. :try_end_8a} :catchall_88

    throw v2
.end method

.method public static getStandaloneMonthString(II)Ljava/lang/String;
    .registers 5
    .parameter "month"
    .parameter "abbrev"

    .prologue
    sparse-switch p1, :sswitch_data_22

    sget-object v0, Landroid/text/format/DateUtils;->sMonthsMedium:[I

    .local v0, list:[I
    :goto_5
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v1

    .local v1, r:Landroid/content/res/Resources;
    add-int/lit8 v2, p0, 0x0

    aget v2, v0, v2

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    return-object v2

    .end local v0           #list:[I
    .end local v1           #r:Landroid/content/res/Resources;
    :sswitch_12
    sget-object v0, Landroid/text/format/DateUtils;->sMonthsStandaloneLong:[I

    .restart local v0       #list:[I
    goto :goto_5

    .end local v0           #list:[I
    :sswitch_15
    sget-object v0, Landroid/text/format/DateUtils;->sMonthsMedium:[I

    .restart local v0       #list:[I
    goto :goto_5

    .end local v0           #list:[I
    :sswitch_18
    sget-object v0, Landroid/text/format/DateUtils;->sMonthsMedium:[I

    .restart local v0       #list:[I
    goto :goto_5

    .end local v0           #list:[I
    :sswitch_1b
    sget-object v0, Landroid/text/format/DateUtils;->sMonthsMedium:[I

    .restart local v0       #list:[I
    goto :goto_5

    .end local v0           #list:[I
    :sswitch_1e
    sget-object v0, Landroid/text/format/DateUtils;->sMonthsShortest:[I

    .restart local v0       #list:[I
    goto :goto_5

    nop

    :sswitch_data_22
    .sparse-switch
        0xa -> :sswitch_12
        0x14 -> :sswitch_15
        0x1e -> :sswitch_18
        0x28 -> :sswitch_1b
        0x32 -> :sswitch_1e
    .end sparse-switch
.end method

.method private static initFormatStrings()V
    .registers 2

    .prologue
    sget-object v1, Landroid/text/format/DateUtils;->sLock:Ljava/lang/Object;

    monitor-enter v1

    :try_start_3
    invoke-static {}, Landroid/text/format/DateUtils;->initFormatStringsLocked()V

    monitor-exit v1

    return-void

    :catchall_8
    move-exception v0

    monitor-exit v1
    :try_end_a
    .catchall {:try_start_3 .. :try_end_a} :catchall_8

    throw v0
.end method

.method private static initFormatStringsLocked()V
    .registers 3

    .prologue
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v1

    .local v1, r:Landroid/content/res/Resources;
    invoke-virtual {v1}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    .local v0, cfg:Landroid/content/res/Configuration;
    sget-object v2, Landroid/text/format/DateUtils;->sLastConfig:Landroid/content/res/Configuration;

    if-eqz v2, :cond_14

    sget-object v2, Landroid/text/format/DateUtils;->sLastConfig:Landroid/content/res/Configuration;

    invoke-virtual {v2, v0}, Landroid/content/res/Configuration;->equals(Landroid/content/res/Configuration;)Z

    move-result v2

    if-nez v2, :cond_2f

    :cond_14
    sput-object v0, Landroid/text/format/DateUtils;->sLastConfig:Landroid/content/res/Configuration;

    const/4 v2, 0x3

    invoke-static {v2}, Ljava/text/DateFormat;->getTimeInstance(I)Ljava/text/DateFormat;

    move-result-object v2

    sput-object v2, Landroid/text/format/DateUtils;->sStatusTimeFormat:Ljava/text/DateFormat;

    const v2, 0x10403bb

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Landroid/text/format/DateUtils;->sElapsedFormatMMSS:Ljava/lang/String;

    const v2, 0x10403bc

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Landroid/text/format/DateUtils;->sElapsedFormatHMMSS:Ljava/lang/String;

    :cond_2f
    return-void
.end method

.method public static isToday(J)Z
    .registers 8
    .parameter "when"

    .prologue
    new-instance v3, Landroid/text/format/Time;

    invoke-direct {v3}, Landroid/text/format/Time;-><init>()V

    .local v3, time:Landroid/text/format/Time;
    invoke-virtual {v3, p0, p1}, Landroid/text/format/Time;->set(J)V

    iget v2, v3, Landroid/text/format/Time;->year:I

    .local v2, thenYear:I
    iget v0, v3, Landroid/text/format/Time;->month:I

    .local v0, thenMonth:I
    iget v1, v3, Landroid/text/format/Time;->monthDay:I

    .local v1, thenMonthDay:I
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-virtual {v3, v4, v5}, Landroid/text/format/Time;->set(J)V

    iget v4, v3, Landroid/text/format/Time;->year:I

    if-ne v2, v4, :cond_23

    iget v4, v3, Landroid/text/format/Time;->month:I

    if-ne v0, v4, :cond_23

    iget v4, v3, Landroid/text/format/Time;->monthDay:I

    if-ne v1, v4, :cond_23

    const/4 v4, 0x1

    :goto_22
    return v4

    :cond_23
    const/4 v4, 0x0

    goto :goto_22
.end method

.method public static isUTC(Ljava/lang/String;)Z
    .registers 5
    .parameter "s"

    .prologue
    const/16 v3, 0x5a

    const/4 v0, 0x1

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    const/16 v2, 0x10

    if-ne v1, v2, :cond_14

    const/16 v1, 0xf

    invoke-virtual {p0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v1

    if-ne v1, v3, :cond_14

    :cond_13
    :goto_13
    return v0

    :cond_14
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    const/16 v2, 0x9

    if-ne v1, v2, :cond_24

    const/16 v1, 0x8

    invoke-virtual {p0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v1

    if-eq v1, v3, :cond_13

    :cond_24
    const/4 v0, 0x0

    goto :goto_13
.end method

.method public static newCalendar(Z)Ljava/util/Calendar;
    .registers 2
    .parameter "zulu"

    .prologue
    if-eqz p0, :cond_d

    const-string v0, "GMT"

    invoke-static {v0}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v0

    invoke-static {v0}, Ljava/util/Calendar;->getInstance(Ljava/util/TimeZone;)Ljava/util/Calendar;

    move-result-object v0

    :goto_c
    return-object v0

    :cond_d
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    goto :goto_c
.end method

.method public static final timeString(J)Ljava/lang/CharSequence;
    .registers 5
    .parameter "millis"

    .prologue
    sget-object v1, Landroid/text/format/DateUtils;->sLock:Ljava/lang/Object;

    monitor-enter v1

    :try_start_3
    invoke-static {}, Landroid/text/format/DateUtils;->initFormatStringsLocked()V

    sget-object v0, Landroid/text/format/DateUtils;->sStatusTimeFormat:Ljava/text/DateFormat;

    invoke-static {p0, p1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/text/DateFormat;->format(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    monitor-exit v1

    return-object v0

    :catchall_12
    move-exception v0

    monitor-exit v1
    :try_end_14
    .catchall {:try_start_3 .. :try_end_14} :catchall_12

    throw v0
.end method

.method private static toDigitChar(J)C
    .registers 4
    .parameter "digit"

    .prologue
    const-wide/16 v0, 0x30

    add-long/2addr v0, p0

    long-to-int v0, v0

    int-to-char v0, v0

    return v0
.end method

.method public static writeDateTime(Ljava/util/Calendar;)Ljava/lang/String;
    .registers 5
    .parameter "cal"

    .prologue
    const-string v2, "GMT"

    invoke-static {v2}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v1

    .local v1, tz:Ljava/util/TimeZone;
    new-instance v0, Ljava/util/GregorianCalendar;

    invoke-direct {v0, v1}, Ljava/util/GregorianCalendar;-><init>(Ljava/util/TimeZone;)V

    .local v0, c:Ljava/util/GregorianCalendar;
    invoke-virtual {p0}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Ljava/util/GregorianCalendar;->setTimeInMillis(J)V

    const/4 v2, 0x1

    invoke-static {v0, v2}, Landroid/text/format/DateUtils;->writeDateTime(Ljava/util/Calendar;Z)Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public static writeDateTime(Ljava/util/Calendar;Ljava/lang/StringBuilder;)Ljava/lang/String;
    .registers 10
    .parameter "cal"
    .parameter "sb"

    .prologue
    const/16 v7, 0xc

    const/16 v6, 0xb

    const/4 v5, 0x5

    const/4 v4, 0x2

    const/4 v3, 0x1

    invoke-virtual {p0, v3}, Ljava/util/Calendar;->get(I)I

    move-result v0

    .local v0, n:I
    const/4 v1, 0x3

    rem-int/lit8 v2, v0, 0xa

    add-int/lit8 v2, v2, 0x30

    int-to-char v2, v2

    invoke-virtual {p1, v1, v2}, Ljava/lang/StringBuilder;->setCharAt(IC)V

    div-int/lit8 v0, v0, 0xa

    rem-int/lit8 v1, v0, 0xa

    add-int/lit8 v1, v1, 0x30

    int-to-char v1, v1

    invoke-virtual {p1, v4, v1}, Ljava/lang/StringBuilder;->setCharAt(IC)V

    div-int/lit8 v0, v0, 0xa

    rem-int/lit8 v1, v0, 0xa

    add-int/lit8 v1, v1, 0x30

    int-to-char v1, v1

    invoke-virtual {p1, v3, v1}, Ljava/lang/StringBuilder;->setCharAt(IC)V

    div-int/lit8 v0, v0, 0xa

    const/4 v1, 0x0

    rem-int/lit8 v2, v0, 0xa

    add-int/lit8 v2, v2, 0x30

    int-to-char v2, v2

    invoke-virtual {p1, v1, v2}, Ljava/lang/StringBuilder;->setCharAt(IC)V

    invoke-virtual {p0, v4}, Ljava/util/Calendar;->get(I)I

    move-result v1

    add-int/lit8 v0, v1, 0x1

    rem-int/lit8 v1, v0, 0xa

    add-int/lit8 v1, v1, 0x30

    int-to-char v1, v1

    invoke-virtual {p1, v5, v1}, Ljava/lang/StringBuilder;->setCharAt(IC)V

    div-int/lit8 v0, v0, 0xa

    const/4 v1, 0x4

    rem-int/lit8 v2, v0, 0xa

    add-int/lit8 v2, v2, 0x30

    int-to-char v2, v2

    invoke-virtual {p1, v1, v2}, Ljava/lang/StringBuilder;->setCharAt(IC)V

    invoke-virtual {p0, v5}, Ljava/util/Calendar;->get(I)I

    move-result v0

    const/4 v1, 0x7

    rem-int/lit8 v2, v0, 0xa

    add-int/lit8 v2, v2, 0x30

    int-to-char v2, v2

    invoke-virtual {p1, v1, v2}, Ljava/lang/StringBuilder;->setCharAt(IC)V

    div-int/lit8 v0, v0, 0xa

    const/4 v1, 0x6

    rem-int/lit8 v2, v0, 0xa

    add-int/lit8 v2, v2, 0x30

    int-to-char v2, v2

    invoke-virtual {p1, v1, v2}, Ljava/lang/StringBuilder;->setCharAt(IC)V

    const/16 v1, 0x8

    const/16 v2, 0x54

    invoke-virtual {p1, v1, v2}, Ljava/lang/StringBuilder;->setCharAt(IC)V

    invoke-virtual {p0, v6}, Ljava/util/Calendar;->get(I)I

    move-result v0

    const/16 v1, 0xa

    rem-int/lit8 v2, v0, 0xa

    add-int/lit8 v2, v2, 0x30

    int-to-char v2, v2

    invoke-virtual {p1, v1, v2}, Ljava/lang/StringBuilder;->setCharAt(IC)V

    div-int/lit8 v0, v0, 0xa

    const/16 v1, 0x9

    rem-int/lit8 v2, v0, 0xa

    add-int/lit8 v2, v2, 0x30

    int-to-char v2, v2

    invoke-virtual {p1, v1, v2}, Ljava/lang/StringBuilder;->setCharAt(IC)V

    invoke-virtual {p0, v7}, Ljava/util/Calendar;->get(I)I

    move-result v0

    rem-int/lit8 v1, v0, 0xa

    add-int/lit8 v1, v1, 0x30

    int-to-char v1, v1

    invoke-virtual {p1, v7, v1}, Ljava/lang/StringBuilder;->setCharAt(IC)V

    div-int/lit8 v0, v0, 0xa

    rem-int/lit8 v1, v0, 0xa

    add-int/lit8 v1, v1, 0x30

    int-to-char v1, v1

    invoke-virtual {p1, v6, v1}, Ljava/lang/StringBuilder;->setCharAt(IC)V

    const/16 v1, 0xd

    invoke-virtual {p0, v1}, Ljava/util/Calendar;->get(I)I

    move-result v0

    const/16 v1, 0xe

    rem-int/lit8 v2, v0, 0xa

    add-int/lit8 v2, v2, 0x30

    int-to-char v2, v2

    invoke-virtual {p1, v1, v2}, Ljava/lang/StringBuilder;->setCharAt(IC)V

    div-int/lit8 v0, v0, 0xa

    const/16 v1, 0xd

    rem-int/lit8 v2, v0, 0xa

    add-int/lit8 v2, v2, 0x30

    int-to-char v2, v2

    invoke-virtual {p1, v1, v2}, Ljava/lang/StringBuilder;->setCharAt(IC)V

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public static writeDateTime(Ljava/util/Calendar;Z)Ljava/lang/String;
    .registers 5
    .parameter "cal"
    .parameter "zulu"

    .prologue
    const/16 v1, 0x10

    const/16 v2, 0xf

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .local v0, sb:Ljava/lang/StringBuilder;
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->ensureCapacity(I)V

    if-eqz p1, :cond_1b

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->setLength(I)V

    const/16 v1, 0x5a

    invoke-virtual {v0, v2, v1}, Ljava/lang/StringBuilder;->setCharAt(IC)V

    :goto_16
    invoke-static {p0, v0}, Landroid/text/format/DateUtils;->writeDateTime(Ljava/util/Calendar;Ljava/lang/StringBuilder;)Ljava/lang/String;

    move-result-object v1

    return-object v1

    :cond_1b
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->setLength(I)V

    goto :goto_16
.end method
