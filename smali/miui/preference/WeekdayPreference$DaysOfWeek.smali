.class public final Lmiui/preference/WeekdayPreference$DaysOfWeek;
.super Ljava/lang/Object;
.source "WeekdayPreference.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/preference/WeekdayPreference;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "DaysOfWeek"
.end annotation


# static fields
.field private static DAY_MAP:[I


# instance fields
.field private mDays:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    const/4 v0, 0x7

    new-array v0, v0, [I

    fill-array-data v0, :array_a

    sput-object v0, Lmiui/preference/WeekdayPreference$DaysOfWeek;->DAY_MAP:[I

    return-void

    nop

    :array_a
    .array-data 0x4
        0x2t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0x4t 0x0t 0x0t 0x0t
        0x5t 0x0t 0x0t 0x0t
        0x6t 0x0t 0x0t 0x0t
        0x7t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
    .end array-data
.end method

.method public constructor <init>(I)V
    .registers 2
    .parameter "days"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lmiui/preference/WeekdayPreference$DaysOfWeek;->mDays:I

    return-void
.end method

.method private isSet(I)Z
    .registers 5
    .parameter "day"

    .prologue
    const/4 v0, 0x1

    iget v1, p0, Lmiui/preference/WeekdayPreference$DaysOfWeek;->mDays:I

    shl-int v2, v0, p1

    and-int/2addr v1, v2

    if-lez v1, :cond_9

    :goto_8
    return v0

    :cond_9
    const/4 v0, 0x0

    goto :goto_8
.end method


# virtual methods
.method public getBooleanArray()[Z
    .registers 5

    .prologue
    const/4 v3, 0x7

    new-array v1, v3, [Z

    .local v1, ret:[Z
    const/4 v0, 0x0

    .local v0, i:I
    :goto_4
    if-ge v0, v3, :cond_f

    invoke-direct {p0, v0}, Lmiui/preference/WeekdayPreference$DaysOfWeek;->isSet(I)Z

    move-result v2

    aput-boolean v2, v1, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_4

    :cond_f
    return-object v1
.end method

.method public getCoded()I
    .registers 2

    .prologue
    iget v0, p0, Lmiui/preference/WeekdayPreference$DaysOfWeek;->mDays:I

    return v0
.end method

.method public getNextAlarm(Ljava/util/Calendar;)I
    .registers 7
    .parameter "c"

    .prologue
    const/4 v4, 0x7

    iget v3, p0, Lmiui/preference/WeekdayPreference$DaysOfWeek;->mDays:I

    if-nez v3, :cond_7

    const/4 v1, -0x1

    :cond_6
    return v1

    :cond_7
    invoke-virtual {p1, v4}, Ljava/util/Calendar;->get(I)I

    move-result v3

    add-int/lit8 v3, v3, 0x5

    rem-int/lit8 v2, v3, 0x7

    .local v2, today:I
    const/4 v0, 0x0

    .local v0, day:I
    const/4 v1, 0x0

    .local v1, dayCount:I
    :goto_11
    if-ge v1, v4, :cond_6

    add-int v3, v2, v1

    rem-int/lit8 v0, v3, 0x7

    invoke-direct {p0, v0}, Lmiui/preference/WeekdayPreference$DaysOfWeek;->isSet(I)Z

    move-result v3

    if-nez v3, :cond_6

    add-int/lit8 v1, v1, 0x1

    goto :goto_11
.end method

.method public isRepeatSet()Z
    .registers 2

    .prologue
    iget v0, p0, Lmiui/preference/WeekdayPreference$DaysOfWeek;->mDays:I

    if-eqz v0, :cond_6

    const/4 v0, 0x1

    :goto_5
    return v0

    :cond_6
    const/4 v0, 0x0

    goto :goto_5
.end method

.method public set(IZ)V
    .registers 5
    .parameter "day"
    .parameter "set"

    .prologue
    const/4 v1, 0x1

    if-eqz p2, :cond_a

    iget v0, p0, Lmiui/preference/WeekdayPreference$DaysOfWeek;->mDays:I

    shl-int/2addr v1, p1

    or-int/2addr v0, v1

    iput v0, p0, Lmiui/preference/WeekdayPreference$DaysOfWeek;->mDays:I

    :goto_9
    return-void

    :cond_a
    iget v0, p0, Lmiui/preference/WeekdayPreference$DaysOfWeek;->mDays:I

    shl-int/2addr v1, p1

    xor-int/lit8 v1, v1, -0x1

    and-int/2addr v0, v1

    iput v0, p0, Lmiui/preference/WeekdayPreference$DaysOfWeek;->mDays:I

    goto :goto_9
.end method

.method public set(Lmiui/preference/WeekdayPreference$DaysOfWeek;)V
    .registers 3
    .parameter "dow"

    .prologue
    iget v0, p1, Lmiui/preference/WeekdayPreference$DaysOfWeek;->mDays:I

    iput v0, p0, Lmiui/preference/WeekdayPreference$DaysOfWeek;->mDays:I

    return-void
.end method

.method public toString(Landroid/content/Context;Z)Ljava/lang/String;
    .registers 12
    .parameter "context"
    .parameter "showNever"

    .prologue
    const/4 v8, 0x1

    iget v6, p0, Lmiui/preference/WeekdayPreference$DaysOfWeek;->mDays:I

    if-nez v6, :cond_16

    if-eqz p2, :cond_13

    const v6, 0x60c01b0

    invoke-virtual {p1, v6}, Landroid/content/Context;->getText(I)Ljava/lang/CharSequence;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    :goto_12
    return-object v6

    :cond_13
    const-string v6, ""

    goto :goto_12

    :cond_16
    iget v6, p0, Lmiui/preference/WeekdayPreference$DaysOfWeek;->mDays:I

    const/16 v7, 0x7f

    if-ne v6, v7, :cond_28

    const v6, 0x60c01af

    invoke-virtual {p1, v6}, Landroid/content/Context;->getText(I)Ljava/lang/CharSequence;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    goto :goto_12

    :cond_28
    const/4 v0, 0x0

    .local v0, dayCount:I
    iget v2, p0, Lmiui/preference/WeekdayPreference$DaysOfWeek;->mDays:I

    .local v2, days:I
    :goto_2b
    if-lez v2, :cond_36

    and-int/lit8 v6, v2, 0x1

    if-ne v6, v8, :cond_33

    add-int/lit8 v0, v0, 0x1

    :cond_33
    shr-int/lit8 v2, v2, 0x1

    goto :goto_2b

    :cond_36
    new-instance v3, Ljava/text/DateFormatSymbols;

    invoke-direct {v3}, Ljava/text/DateFormatSymbols;-><init>()V

    .local v3, dfs:Ljava/text/DateFormatSymbols;
    if-le v0, v8, :cond_5f

    invoke-virtual {v3}, Ljava/text/DateFormatSymbols;->getShortWeekdays()[Ljava/lang/String;

    move-result-object v1

    .local v1, dayList:[Ljava/lang/String;
    :goto_41
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .local v5, weekdayList:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/lang/CharSequence;>;"
    const/4 v4, 0x0

    .local v4, i:I
    :goto_47
    const/4 v6, 0x7

    if-ge v4, v6, :cond_64

    iget v6, p0, Lmiui/preference/WeekdayPreference$DaysOfWeek;->mDays:I

    shl-int v7, v8, v4

    and-int/2addr v6, v7

    if-eqz v6, :cond_5c

    sget-object v6, Lmiui/preference/WeekdayPreference$DaysOfWeek;->DAY_MAP:[I

    aget v6, v6, v4

    aget-object v6, v1, v6

    invoke-virtual {v5, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    add-int/lit8 v0, v0, -0x1

    :cond_5c
    add-int/lit8 v4, v4, 0x1

    goto :goto_47

    .end local v1           #dayList:[Ljava/lang/String;
    .end local v4           #i:I
    .end local v5           #weekdayList:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/lang/CharSequence;>;"
    :cond_5f
    invoke-virtual {v3}, Ljava/text/DateFormatSymbols;->getWeekdays()[Ljava/lang/String;

    move-result-object v1

    goto :goto_41

    .restart local v1       #dayList:[Ljava/lang/String;
    .restart local v4       #i:I
    .restart local v5       #weekdayList:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/lang/CharSequence;>;"
    :cond_64
    invoke-static {v5}, Landroid/text/TextUtils;->join(Ljava/lang/Iterable;)Ljava/lang/CharSequence;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    goto :goto_12
.end method
