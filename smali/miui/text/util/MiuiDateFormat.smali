.class public Lmiui/text/util/MiuiDateFormat;
.super Ljava/text/SimpleDateFormat;
.source "MiuiDateFormat.java"


# static fields
.field private static final serialVersionUID:J = 0x1L


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/text/SimpleDateFormat;-><init>()V

    .line 16
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .registers 2
    .parameter "format"

    .prologue
    .line 19
    invoke-direct {p0, p1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 20
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/text/DateFormatSymbols;)V
    .registers 3
    .parameter "template"
    .parameter "value"

    .prologue
    .line 23
    invoke-direct {p0, p1, p2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/text/DateFormatSymbols;)V

    .line 24
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/util/Locale;)V
    .registers 3
    .parameter "template"
    .parameter "locale"

    .prologue
    .line 27
    invoke-direct {p0, p1, p2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 28
    return-void
.end method

.method private getDetailedAmPm(I)Ljava/lang/String;
    .registers 7
    .parameter "hour"

    .prologue
    .line 43
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x606000a

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getIntArray(I)[I

    move-result-object v2

    .line 44
    .local v2, segments:[I
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x606000b

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v1

    .line 45
    .local v1, names:[Ljava/lang/String;
    array-length v3, v2

    add-int/lit8 v0, v3, -0x1

    .local v0, i:I
    :goto_19
    if-ltz v0, :cond_25

    .line 46
    aget v3, v2, v0

    if-lt p1, v3, :cond_22

    .line 47
    aget-object v3, v1, v0

    .line 52
    :goto_21
    return-object v3

    .line 45
    :cond_22
    add-int/lit8 v0, v0, -0x1

    goto :goto_19

    .line 52
    :cond_25
    const/4 v3, 0x0

    goto :goto_21
.end method


# virtual methods
.method public format(Ljava/util/Date;Ljava/lang/StringBuffer;Ljava/text/FieldPosition;)Ljava/lang/StringBuffer;
    .registers 9
    .parameter "date"
    .parameter "buffer"
    .parameter "fieldPos"

    .prologue
    .line 32
    invoke-virtual {p0}, Lmiui/text/util/MiuiDateFormat;->getDateFormatSymbols()Ljava/text/DateFormatSymbols;

    move-result-object v1

    .line 34
    .local v1, symbols:Ljava/text/DateFormatSymbols;
    iget-object v2, p0, Lmiui/text/util/MiuiDateFormat;->calendar:Ljava/util/Calendar;

    invoke-virtual {v2, p1}, Ljava/util/Calendar;->setTime(Ljava/util/Date;)V

    .line 35
    invoke-virtual {v1}, Ljava/text/DateFormatSymbols;->getAmPmStrings()[Ljava/lang/String;

    move-result-object v0

    .line 36
    .local v0, ampmString:[Ljava/lang/String;
    iget-object v2, p0, Lmiui/text/util/MiuiDateFormat;->calendar:Ljava/util/Calendar;

    const/16 v3, 0x9

    invoke-virtual {v2, v3}, Ljava/util/Calendar;->get(I)I

    move-result v2

    iget-object v3, p0, Lmiui/text/util/MiuiDateFormat;->calendar:Ljava/util/Calendar;

    const/16 v4, 0xb

    invoke-virtual {v3, v4}, Ljava/util/Calendar;->get(I)I

    move-result v3

    invoke-direct {p0, v3}, Lmiui/text/util/MiuiDateFormat;->getDetailedAmPm(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v0, v2

    .line 37
    invoke-virtual {v1, v0}, Ljava/text/DateFormatSymbols;->setAmPmStrings([Ljava/lang/String;)V

    .line 38
    invoke-virtual {p0, v1}, Lmiui/text/util/MiuiDateFormat;->setDateFormatSymbols(Ljava/text/DateFormatSymbols;)V

    .line 39
    invoke-super {p0, p1, p2, p3}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;Ljava/lang/StringBuffer;Ljava/text/FieldPosition;)Ljava/lang/StringBuffer;

    move-result-object v2

    return-object v2
.end method
