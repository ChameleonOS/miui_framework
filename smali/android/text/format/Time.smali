.class public Landroid/text/format/Time;
.super Ljava/lang/Object;
.source "Time.java"


# static fields
.field private static final DAYS_PER_MONTH:[I = null

.field public static final EPOCH_JULIAN_DAY:I = 0x253d8c

.field public static final FRIDAY:I = 0x5

.field public static final HOUR:I = 0x3

.field public static final MINUTE:I = 0x2

.field public static final MONDAY:I = 0x1

.field public static final MONDAY_BEFORE_JULIAN_EPOCH:I = 0x253d89

.field public static final MONTH:I = 0x5

.field public static final MONTH_DAY:I = 0x4

.field public static final SATURDAY:I = 0x6

.field public static final SECOND:I = 0x1

.field public static final SUNDAY:I = 0x0

.field public static final THURSDAY:I = 0x4

.field public static final TIMEZONE_UTC:Ljava/lang/String; = "UTC"

.field public static final TUESDAY:I = 0x2

.field public static final WEDNESDAY:I = 0x3

.field public static final WEEK_DAY:I = 0x7

.field public static final WEEK_NUM:I = 0x9

.field public static final YEAR:I = 0x6

.field public static final YEAR_DAY:I = 0x8

.field private static final Y_M_D:Ljava/lang/String; = "%Y-%m-%d"

.field private static final Y_M_D_T_H_M_S_000:Ljava/lang/String; = "%Y-%m-%dT%H:%M:%S.000"

.field private static final Y_M_D_T_H_M_S_000_Z:Ljava/lang/String; = "%Y-%m-%dT%H:%M:%S.000Z"

.field private static sAm:Ljava/lang/String;

.field private static sDateCommand:Ljava/lang/String;

.field private static sDateOnlyFormat:Ljava/lang/String;

.field private static sDateTimeFormat:Ljava/lang/String;

.field private static sLocale:Ljava/util/Locale;

.field private static sLongMonths:[Ljava/lang/String;

.field private static sLongStandaloneMonths:[Ljava/lang/String;

.field private static sLongWeekdays:[Ljava/lang/String;

.field private static sPm:Ljava/lang/String;

.field private static sShortMonths:[Ljava/lang/String;

.field private static sShortWeekdays:[Ljava/lang/String;

.field private static final sThursdayOffset:[I

.field private static sTimeOnlyFormat:Ljava/lang/String;


# instance fields
.field public allDay:Z

.field public gmtoff:J

.field public hour:I

.field public isDst:I

.field public minute:I

.field public month:I

.field public monthDay:I

.field public second:I

.field public timezone:Ljava/lang/String;

.field public weekDay:I

.field public year:I

.field public yearDay:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 152
    const-string v0, "%a %b %e %H:%M:%S %Z %Y"

    sput-object v0, Landroid/text/format/Time;->sDateCommand:Ljava/lang/String;

    .line 215
    const/16 v0, 0xc

    new-array v0, v0, [I

    fill-array-data v0, :array_16

    sput-object v0, Landroid/text/format/Time;->DAYS_PER_MONTH:[I

    .line 662
    const/4 v0, 0x7

    new-array v0, v0, [I

    fill-array-data v0, :array_32

    sput-object v0, Landroid/text/format/Time;->sThursdayOffset:[I

    return-void

    .line 215
    :array_16
    .array-data 0x4
        0x1ft 0x0t 0x0t 0x0t
        0x1ct 0x0t 0x0t 0x0t
        0x1ft 0x0t 0x0t 0x0t
        0x1et 0x0t 0x0t 0x0t
        0x1ft 0x0t 0x0t 0x0t
        0x1et 0x0t 0x0t 0x0t
        0x1ft 0x0t 0x0t 0x0t
        0x1ft 0x0t 0x0t 0x0t
        0x1et 0x0t 0x0t 0x0t
        0x1ft 0x0t 0x0t 0x0t
        0x1et 0x0t 0x0t 0x0t
        0x1ft 0x0t 0x0t 0x0t
    .end array-data

    .line 662
    :array_32
    .array-data 0x4
        0xfdt 0xfft 0xfft 0xfft
        0x3t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0xfft 0xfft 0xfft 0xfft
        0xfet 0xfft 0xfft 0xfft
    .end array-data
.end method

.method public constructor <init>()V
    .registers 2

    .prologue
    .line 177
    invoke-static {}, Ljava/util/TimeZone;->getDefault()Ljava/util/TimeZone;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/TimeZone;->getID()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Landroid/text/format/Time;-><init>(Ljava/lang/String;)V

    .line 178
    return-void
.end method

.method public constructor <init>(Landroid/text/format/Time;)V
    .registers 2
    .parameter "other"

    .prologue
    .line 186
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 187
    invoke-virtual {p0, p1}, Landroid/text/format/Time;->set(Landroid/text/format/Time;)V

    .line 188
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .registers 4
    .parameter "timezone"

    .prologue
    .line 160
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 161
    if-nez p1, :cond_e

    .line 162
    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "timezone is null!"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 164
    :cond_e
    iput-object p1, p0, Landroid/text/format/Time;->timezone:Ljava/lang/String;

    .line 165
    const/16 v0, 0x7b2

    iput v0, p0, Landroid/text/format/Time;->year:I

    .line 166
    const/4 v0, 0x1

    iput v0, p0, Landroid/text/format/Time;->monthDay:I

    .line 169
    const/4 v0, -0x1

    iput v0, p0, Landroid/text/format/Time;->isDst:I

    .line 170
    return-void
.end method

.method public static compare(Landroid/text/format/Time;Landroid/text/format/Time;)I
    .registers 4
    .parameter "a"
    .parameter "b"

    .prologue
    .line 297
    if-nez p0, :cond_a

    .line 298
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "a == null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 299
    :cond_a
    if-nez p1, :cond_14

    .line 300
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "b == null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 303
    :cond_14
    invoke-static {p0, p1}, Landroid/text/format/Time;->nativeCompare(Landroid/text/format/Time;Landroid/text/format/Time;)I

    move-result v0

    return v0
.end method

.method private native format1(Ljava/lang/String;)Ljava/lang/String;
.end method

.method public static getCurrentTimezone()Ljava/lang/String;
    .registers 1

    .prologue
    .line 500
    invoke-static {}, Ljava/util/TimeZone;->getDefault()Ljava/util/TimeZone;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/TimeZone;->getID()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getJulianDay(JJ)I
    .registers 12
    .parameter "millis"
    .parameter "gmtoff"

    .prologue
    .line 756
    const-wide/16 v4, 0x3e8

    mul-long v2, p2, v4

    .line 757
    .local v2, offsetMillis:J
    add-long v4, p0, v2

    const-wide/32 v6, 0x5265c00

    div-long v0, v4, v6

    .line 758
    .local v0, julianDay:J
    long-to-int v4, v0

    const v5, 0x253d8c

    add-int/2addr v4, v5

    return v4
.end method

.method public static getJulianMondayFromWeeksSinceEpoch(I)I
    .registers 3
    .parameter "week"

    .prologue
    .line 834
    const v0, 0x253d89

    mul-int/lit8 v1, p0, 0x7

    add-int/2addr v0, v1

    return v0
.end method

.method public static getWeeksSinceEpochFromJulianDay(II)I
    .registers 5
    .parameter "julianDay"
    .parameter "firstDayOfWeek"

    .prologue
    .line 815
    rsub-int/lit8 v0, p1, 0x4

    .line 816
    .local v0, diff:I
    if-gez v0, :cond_6

    .line 817
    add-int/lit8 v0, v0, 0x7

    .line 819
    :cond_6
    const v2, 0x253d8c

    sub-int v1, v2, v0

    .line 820
    .local v1, refDay:I
    sub-int v2, p0, v1

    div-int/lit8 v2, v2, 0x7

    return v2
.end method

.method public static isEpoch(Landroid/text/format/Time;)Z
    .registers 6
    .parameter "time"

    .prologue
    const/4 v2, 0x1

    .line 735
    invoke-virtual {p0, v2}, Landroid/text/format/Time;->toMillis(Z)J

    move-result-wide v0

    .line 736
    .local v0, millis:J
    const-wide/16 v3, 0x0

    invoke-static {v0, v1, v3, v4}, Landroid/text/format/Time;->getJulianDay(JJ)I

    move-result v3

    const v4, 0x253d8c

    if-ne v3, v4, :cond_11

    :goto_10
    return v2

    :cond_11
    const/4 v2, 0x0

    goto :goto_10
.end method

.method private static native nativeCompare(Landroid/text/format/Time;Landroid/text/format/Time;)I
.end method

.method private native nativeParse(Ljava/lang/String;)Z
.end method

.method private native nativeParse3339(Ljava/lang/String;)Z
.end method


# virtual methods
.method public after(Landroid/text/format/Time;)Z
    .registers 3
    .parameter "that"

    .prologue
    .line 654
    invoke-static {p0, p1}, Landroid/text/format/Time;->compare(Landroid/text/format/Time;Landroid/text/format/Time;)I

    move-result v0

    if-lez v0, :cond_8

    const/4 v0, 0x1

    :goto_7
    return v0

    :cond_8
    const/4 v0, 0x0

    goto :goto_7
.end method

.method public before(Landroid/text/format/Time;)Z
    .registers 3
    .parameter "that"

    .prologue
    .line 642
    invoke-static {p0, p1}, Landroid/text/format/Time;->compare(Landroid/text/format/Time;Landroid/text/format/Time;)I

    move-result v0

    if-gez v0, :cond_8

    const/4 v0, 0x1

    :goto_7
    return v0

    :cond_8
    const/4 v0, 0x0

    goto :goto_7
.end method

.method public clear(Ljava/lang/String;)V
    .registers 4
    .parameter "timezone"

    .prologue
    const/4 v0, 0x0

    .line 266
    if-nez p1, :cond_c

    .line 267
    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "timezone is null!"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 269
    :cond_c
    iput-object p1, p0, Landroid/text/format/Time;->timezone:Ljava/lang/String;

    .line 270
    iput-boolean v0, p0, Landroid/text/format/Time;->allDay:Z

    .line 271
    iput v0, p0, Landroid/text/format/Time;->second:I

    .line 272
    iput v0, p0, Landroid/text/format/Time;->minute:I

    .line 273
    iput v0, p0, Landroid/text/format/Time;->hour:I

    .line 274
    iput v0, p0, Landroid/text/format/Time;->monthDay:I

    .line 275
    iput v0, p0, Landroid/text/format/Time;->month:I

    .line 276
    iput v0, p0, Landroid/text/format/Time;->year:I

    .line 277
    iput v0, p0, Landroid/text/format/Time;->weekDay:I

    .line 278
    iput v0, p0, Landroid/text/format/Time;->yearDay:I

    .line 279
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Landroid/text/format/Time;->gmtoff:J

    .line 280
    const/4 v0, -0x1

    iput v0, p0, Landroid/text/format/Time;->isDst:I

    .line 281
    return-void
.end method

.method public format(Ljava/lang/String;)Ljava/lang/String;
    .registers 8
    .parameter "format"

    .prologue
    .line 316
    const-class v3, Landroid/text/format/Time;

    monitor-enter v3

    .line 317
    :try_start_3
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    .line 319
    .local v0, locale:Ljava/util/Locale;
    sget-object v2, Landroid/text/format/Time;->sLocale:Ljava/util/Locale;

    if-eqz v2, :cond_15

    if-eqz v0, :cond_15

    sget-object v2, Landroid/text/format/Time;->sLocale:Ljava/util/Locale;

    invoke-virtual {v0, v2}, Ljava/util/Locale;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_264

    .line 320
    :cond_15
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v1

    .line 322
    .local v1, r:Landroid/content/res/Resources;
    const/16 v2, 0xc

    new-array v2, v2, [Ljava/lang/String;

    const/4 v4, 0x0

    const v5, 0x1040045

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x1

    const v5, 0x1040046

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x2

    const v5, 0x1040047

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x3

    const v5, 0x1040048

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x4

    const v5, 0x1040049

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x5

    const v5, 0x104004a

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x6

    const v5, 0x104004b

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x7

    const v5, 0x104004c

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/16 v4, 0x8

    const v5, 0x104004d

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/16 v4, 0x9

    const v5, 0x104004e

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/16 v4, 0xa

    const v5, 0x104004f

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/16 v4, 0xb

    const v5, 0x1040050

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    sput-object v2, Landroid/text/format/Time;->sShortMonths:[Ljava/lang/String;

    .line 336
    const/16 v2, 0xc

    new-array v2, v2, [Ljava/lang/String;

    const/4 v4, 0x0

    const v5, 0x1040039

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x1

    const v5, 0x104003a

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x2

    const v5, 0x104003b

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x3

    const v5, 0x104003c

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x4

    const v5, 0x104003d

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x5

    const v5, 0x104003e

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x6

    const v5, 0x104003f

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x7

    const v5, 0x1040040

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/16 v4, 0x8

    const v5, 0x1040041

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/16 v4, 0x9

    const v5, 0x1040042

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/16 v4, 0xa

    const v5, 0x1040043

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/16 v4, 0xb

    const v5, 0x1040044

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    sput-object v2, Landroid/text/format/Time;->sLongMonths:[Ljava/lang/String;

    .line 350
    const/16 v2, 0xc

    new-array v2, v2, [Ljava/lang/String;

    const/4 v4, 0x0

    const v5, 0x104002d

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x1

    const v5, 0x104002e

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x2

    const v5, 0x104002f

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x3

    const v5, 0x1040030

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x4

    const v5, 0x1040031

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x5

    const v5, 0x1040032

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x6

    const v5, 0x1040033

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x7

    const v5, 0x1040034

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/16 v4, 0x8

    const v5, 0x1040035

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/16 v4, 0x9

    const v5, 0x1040036

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/16 v4, 0xa

    const v5, 0x1040037

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/16 v4, 0xb

    const v5, 0x1040038

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    sput-object v2, Landroid/text/format/Time;->sLongStandaloneMonths:[Ljava/lang/String;

    .line 364
    const/4 v2, 0x7

    new-array v2, v2, [Ljava/lang/String;

    const/4 v4, 0x0

    const v5, 0x1040064

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x1

    const v5, 0x1040065

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x2

    const v5, 0x1040066

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x3

    const v5, 0x1040067

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x4

    const v5, 0x1040068

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x5

    const v5, 0x1040069

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x6

    const v5, 0x104006a

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    sput-object v2, Landroid/text/format/Time;->sShortWeekdays:[Ljava/lang/String;

    .line 373
    const/4 v2, 0x7

    new-array v2, v2, [Ljava/lang/String;

    const/4 v4, 0x0

    const v5, 0x104005d

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x1

    const v5, 0x104005e

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x2

    const v5, 0x104005f

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x3

    const v5, 0x1040060

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x4

    const v5, 0x1040061

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x5

    const v5, 0x1040062

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x6

    const v5, 0x1040063

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    sput-object v2, Landroid/text/format/Time;->sLongWeekdays:[Ljava/lang/String;

    .line 382
    const v2, 0x1040087

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Landroid/text/format/Time;->sTimeOnlyFormat:Ljava/lang/String;

    .line 383
    const v2, 0x1040086

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Landroid/text/format/Time;->sDateOnlyFormat:Ljava/lang/String;

    .line 384
    const v2, 0x1040088

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Landroid/text/format/Time;->sDateTimeFormat:Ljava/lang/String;

    .line 385
    const v2, 0x1040079

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Landroid/text/format/Time;->sAm:Ljava/lang/String;

    .line 386
    const v2, 0x104007a

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Landroid/text/format/Time;->sPm:Ljava/lang/String;

    .line 388
    sput-object v0, Landroid/text/format/Time;->sLocale:Ljava/util/Locale;

    .line 391
    .end local v1           #r:Landroid/content/res/Resources;
    :cond_264
    invoke-direct {p0, p1}, Landroid/text/format/Time;->format1(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    monitor-exit v3

    return-object v2

    .line 392
    .end local v0           #locale:Ljava/util/Locale;
    :catchall_26a
    move-exception v2

    monitor-exit v3
    :try_end_26c
    .catchall {:try_start_3 .. :try_end_26c} :catchall_26a

    throw v2
.end method

.method public native format2445()Ljava/lang/String;
.end method

.method public format3339(Z)Ljava/lang/String;
    .registers 11
    .parameter "allDay"

    .prologue
    .line 712
    if-eqz p1, :cond_9

    .line 713
    const-string v5, "%Y-%m-%d"

    invoke-virtual {p0, v5}, Landroid/text/format/Time;->format(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 723
    :goto_8
    return-object v5

    .line 714
    :cond_9
    const-string v5, "UTC"

    iget-object v6, p0, Landroid/text/format/Time;->timezone:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1a

    .line 715
    const-string v5, "%Y-%m-%dT%H:%M:%S.000Z"

    invoke-virtual {p0, v5}, Landroid/text/format/Time;->format(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    goto :goto_8

    .line 717
    :cond_1a
    const-string v5, "%Y-%m-%dT%H:%M:%S.000"

    invoke-virtual {p0, v5}, Landroid/text/format/Time;->format(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 718
    .local v0, base:Ljava/lang/String;
    iget-wide v5, p0, Landroid/text/format/Time;->gmtoff:J

    const-wide/16 v7, 0x0

    cmp-long v5, v5, v7

    if-gez v5, :cond_55

    const-string v4, "-"

    .line 719
    .local v4, sign:Ljava/lang/String;
    :goto_2a
    iget-wide v5, p0, Landroid/text/format/Time;->gmtoff:J

    invoke-static {v5, v6}, Ljava/lang/Math;->abs(J)J

    move-result-wide v5

    long-to-int v3, v5

    .line 720
    .local v3, offset:I
    rem-int/lit16 v5, v3, 0xe10

    div-int/lit8 v2, v5, 0x3c

    .line 721
    .local v2, minutes:I
    div-int/lit16 v1, v3, 0xe10

    .line 723
    .local v1, hours:I
    const-string v5, "%s%s%02d:%02d"

    const/4 v6, 0x4

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object v0, v6, v7

    const/4 v7, 0x1

    aput-object v4, v6, v7

    const/4 v7, 0x2

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x3

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    goto :goto_8

    .line 718
    .end local v1           #hours:I
    .end local v2           #minutes:I
    .end local v3           #offset:I
    .end local v4           #sign:Ljava/lang/String;
    :cond_55
    const-string v4, "+"

    goto :goto_2a
.end method

.method public getActualMaximum(I)I
    .registers 7
    .parameter "field"

    .prologue
    const/16 v0, 0x3b

    const/16 v2, 0x1c

    .line 226
    packed-switch p1, :pswitch_data_66

    .line 256
    new-instance v2, Ljava/lang/RuntimeException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "bad field="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v2

    :pswitch_20
    move v2, v0

    .line 251
    :cond_21
    :goto_21
    return v2

    :pswitch_22
    move v2, v0

    .line 230
    goto :goto_21

    .line 232
    :pswitch_24
    const/16 v2, 0x17

    goto :goto_21

    .line 234
    :pswitch_27
    sget-object v3, Landroid/text/format/Time;->DAYS_PER_MONTH:[I

    iget v4, p0, Landroid/text/format/Time;->month:I

    aget v0, v3, v4

    .line 235
    .local v0, n:I
    if-eq v0, v2, :cond_31

    move v2, v0

    .line 236
    goto :goto_21

    .line 238
    :cond_31
    iget v1, p0, Landroid/text/format/Time;->year:I

    .line 239
    .local v1, y:I
    rem-int/lit8 v3, v1, 0x4

    if-nez v3, :cond_21

    rem-int/lit8 v3, v1, 0x64

    if-nez v3, :cond_3f

    rem-int/lit16 v3, v1, 0x190

    if-nez v3, :cond_21

    :cond_3f
    const/16 v2, 0x1d

    goto :goto_21

    .line 243
    .end local v0           #n:I
    .end local v1           #y:I
    :pswitch_42
    const/16 v2, 0xb

    goto :goto_21

    .line 245
    :pswitch_45
    const/16 v2, 0x7f5

    goto :goto_21

    .line 247
    :pswitch_48
    const/4 v2, 0x6

    goto :goto_21

    .line 249
    :pswitch_4a
    iget v1, p0, Landroid/text/format/Time;->year:I

    .line 251
    .restart local v1       #y:I
    rem-int/lit8 v2, v1, 0x4

    if-nez v2, :cond_5b

    rem-int/lit8 v2, v1, 0x64

    if-nez v2, :cond_58

    rem-int/lit16 v2, v1, 0x190

    if-nez v2, :cond_5b

    :cond_58
    const/16 v2, 0x16d

    goto :goto_21

    :cond_5b
    const/16 v2, 0x16c

    goto :goto_21

    .line 254
    .end local v1           #y:I
    :pswitch_5e
    new-instance v2, Ljava/lang/RuntimeException;

    const-string v3, "WEEK_NUM not implemented"

    invoke-direct {v2, v3}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 226
    :pswitch_data_66
    .packed-switch 0x1
        :pswitch_20
        :pswitch_22
        :pswitch_24
        :pswitch_27
        :pswitch_42
        :pswitch_45
        :pswitch_48
        :pswitch_4a
        :pswitch_5e
    .end packed-switch
.end method

.method public getWeekNumber()I
    .registers 6

    .prologue
    .line 686
    iget v2, p0, Landroid/text/format/Time;->yearDay:I

    sget-object v3, Landroid/text/format/Time;->sThursdayOffset:[I

    iget v4, p0, Landroid/text/format/Time;->weekDay:I

    aget v3, v3, v4

    add-int v0, v2, v3

    .line 689
    .local v0, closestThursday:I
    if-ltz v0, :cond_15

    const/16 v2, 0x16c

    if-gt v0, v2, :cond_15

    .line 690
    div-int/lit8 v2, v0, 0x7

    add-int/lit8 v2, v2, 0x1

    .line 697
    :goto_14
    return v2

    .line 694
    :cond_15
    new-instance v1, Landroid/text/format/Time;

    invoke-direct {v1, p0}, Landroid/text/format/Time;-><init>(Landroid/text/format/Time;)V

    .line 695
    .local v1, temp:Landroid/text/format/Time;
    iget v2, v1, Landroid/text/format/Time;->monthDay:I

    sget-object v3, Landroid/text/format/Time;->sThursdayOffset:[I

    iget v4, p0, Landroid/text/format/Time;->weekDay:I

    aget v3, v3, v4

    add-int/2addr v2, v3

    iput v2, v1, Landroid/text/format/Time;->monthDay:I

    .line 696
    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/text/format/Time;->normalize(Z)J

    .line 697
    iget v2, v1, Landroid/text/format/Time;->yearDay:I

    div-int/lit8 v2, v2, 0x7

    add-int/lit8 v2, v2, 0x1

    goto :goto_14
.end method

.method public native normalize(Z)J
.end method

.method public parse(Ljava/lang/String;)Z
    .registers 3
    .parameter "s"

    .prologue
    .line 440
    invoke-direct {p0, p1}, Landroid/text/format/Time;->nativeParse(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_c

    .line 441
    const-string v0, "UTC"

    iput-object v0, p0, Landroid/text/format/Time;->timezone:Ljava/lang/String;

    .line 442
    const/4 v0, 0x1

    .line 444
    :goto_b
    return v0

    :cond_c
    const/4 v0, 0x0

    goto :goto_b
.end method

.method public parse3339(Ljava/lang/String;)Z
    .registers 4
    .parameter "s"

    .prologue
    .line 484
    if-nez p1, :cond_b

    .line 485
    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "time string is null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 487
    :cond_b
    invoke-direct {p0, p1}, Landroid/text/format/Time;->nativeParse3339(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_17

    .line 488
    const-string v0, "UTC"

    iput-object v0, p0, Landroid/text/format/Time;->timezone:Ljava/lang/String;

    .line 489
    const/4 v0, 0x1

    .line 491
    :goto_16
    return v0

    :cond_17
    const/4 v0, 0x0

    goto :goto_16
.end method

.method public set(III)V
    .registers 6
    .parameter "monthDay"
    .parameter "month"
    .parameter "year"

    .prologue
    const/4 v1, 0x0

    .line 621
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/text/format/Time;->allDay:Z

    .line 622
    iput v1, p0, Landroid/text/format/Time;->second:I

    .line 623
    iput v1, p0, Landroid/text/format/Time;->minute:I

    .line 624
    iput v1, p0, Landroid/text/format/Time;->hour:I

    .line 625
    iput p1, p0, Landroid/text/format/Time;->monthDay:I

    .line 626
    iput p2, p0, Landroid/text/format/Time;->month:I

    .line 627
    iput p3, p0, Landroid/text/format/Time;->year:I

    .line 628
    iput v1, p0, Landroid/text/format/Time;->weekDay:I

    .line 629
    iput v1, p0, Landroid/text/format/Time;->yearDay:I

    .line 630
    const/4 v0, -0x1

    iput v0, p0, Landroid/text/format/Time;->isDst:I

    .line 631
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Landroid/text/format/Time;->gmtoff:J

    .line 632
    return-void
.end method

.method public set(IIIIII)V
    .registers 9
    .parameter "second"
    .parameter "minute"
    .parameter "hour"
    .parameter "monthDay"
    .parameter "month"
    .parameter "year"

    .prologue
    const/4 v0, 0x0

    .line 598
    iput-boolean v0, p0, Landroid/text/format/Time;->allDay:Z

    .line 599
    iput p1, p0, Landroid/text/format/Time;->second:I

    .line 600
    iput p2, p0, Landroid/text/format/Time;->minute:I

    .line 601
    iput p3, p0, Landroid/text/format/Time;->hour:I

    .line 602
    iput p4, p0, Landroid/text/format/Time;->monthDay:I

    .line 603
    iput p5, p0, Landroid/text/format/Time;->month:I

    .line 604
    iput p6, p0, Landroid/text/format/Time;->year:I

    .line 605
    iput v0, p0, Landroid/text/format/Time;->weekDay:I

    .line 606
    iput v0, p0, Landroid/text/format/Time;->yearDay:I

    .line 607
    const/4 v0, -0x1

    iput v0, p0, Landroid/text/format/Time;->isDst:I

    .line 608
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Landroid/text/format/Time;->gmtoff:J

    .line 609
    return-void
.end method

.method public native set(J)V
.end method

.method public set(Landroid/text/format/Time;)V
    .registers 4
    .parameter "that"

    .prologue
    .line 579
    iget-object v0, p1, Landroid/text/format/Time;->timezone:Ljava/lang/String;

    iput-object v0, p0, Landroid/text/format/Time;->timezone:Ljava/lang/String;

    .line 580
    iget-boolean v0, p1, Landroid/text/format/Time;->allDay:Z

    iput-boolean v0, p0, Landroid/text/format/Time;->allDay:Z

    .line 581
    iget v0, p1, Landroid/text/format/Time;->second:I

    iput v0, p0, Landroid/text/format/Time;->second:I

    .line 582
    iget v0, p1, Landroid/text/format/Time;->minute:I

    iput v0, p0, Landroid/text/format/Time;->minute:I

    .line 583
    iget v0, p1, Landroid/text/format/Time;->hour:I

    iput v0, p0, Landroid/text/format/Time;->hour:I

    .line 584
    iget v0, p1, Landroid/text/format/Time;->monthDay:I

    iput v0, p0, Landroid/text/format/Time;->monthDay:I

    .line 585
    iget v0, p1, Landroid/text/format/Time;->month:I

    iput v0, p0, Landroid/text/format/Time;->month:I

    .line 586
    iget v0, p1, Landroid/text/format/Time;->year:I

    iput v0, p0, Landroid/text/format/Time;->year:I

    .line 587
    iget v0, p1, Landroid/text/format/Time;->weekDay:I

    iput v0, p0, Landroid/text/format/Time;->weekDay:I

    .line 588
    iget v0, p1, Landroid/text/format/Time;->yearDay:I

    iput v0, p0, Landroid/text/format/Time;->yearDay:I

    .line 589
    iget v0, p1, Landroid/text/format/Time;->isDst:I

    iput v0, p0, Landroid/text/format/Time;->isDst:I

    .line 590
    iget-wide v0, p1, Landroid/text/format/Time;->gmtoff:J

    iput-wide v0, p0, Landroid/text/format/Time;->gmtoff:J

    .line 591
    return-void
.end method

.method public setJulianDay(I)J
    .registers 11
    .parameter "julianDay"

    .prologue
    const/4 v8, 0x0

    .line 785
    const v4, 0x253d8c

    sub-int v4, p1, v4

    int-to-long v4, v4

    const-wide/32 v6, 0x5265c00

    mul-long v2, v4, v6

    .line 786
    .local v2, millis:J
    invoke-virtual {p0, v2, v3}, Landroid/text/format/Time;->set(J)V

    .line 790
    iget-wide v4, p0, Landroid/text/format/Time;->gmtoff:J

    invoke-static {v2, v3, v4, v5}, Landroid/text/format/Time;->getJulianDay(JJ)I

    move-result v0

    .line 791
    .local v0, approximateDay:I
    sub-int v1, p1, v0

    .line 792
    .local v1, diff:I
    iget v4, p0, Landroid/text/format/Time;->monthDay:I

    add-int/2addr v4, v1

    iput v4, p0, Landroid/text/format/Time;->monthDay:I

    .line 795
    iput v8, p0, Landroid/text/format/Time;->hour:I

    .line 796
    iput v8, p0, Landroid/text/format/Time;->minute:I

    .line 797
    iput v8, p0, Landroid/text/format/Time;->second:I

    .line 798
    const/4 v4, 0x1

    invoke-virtual {p0, v4}, Landroid/text/format/Time;->normalize(Z)J

    move-result-wide v2

    .line 799
    return-wide v2
.end method

.method public native setToNow()V
.end method

.method public native switchTimezone(Ljava/lang/String;)V
.end method

.method public native toMillis(Z)J
.end method

.method public native toString()Ljava/lang/String;
.end method
