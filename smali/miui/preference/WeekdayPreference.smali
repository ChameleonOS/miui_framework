.class public Lmiui/preference/WeekdayPreference;
.super Landroid/preference/ListPreference;
.source "WeekdayPreference.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lmiui/preference/WeekdayPreference$DaysOfWeek;
    }
.end annotation


# instance fields
.field private mDaysOfWeek:Lmiui/preference/WeekdayPreference$DaysOfWeek;

.field private mIsSingleChoice:Z

.field private mNewDaysOfWeek:Lmiui/preference/WeekdayPreference$DaysOfWeek;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 11
    .parameter "context"
    .parameter "attrs"

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 32
    invoke-direct {p0, p1, p2}, Landroid/preference/ListPreference;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 24
    new-instance v2, Lmiui/preference/WeekdayPreference$DaysOfWeek;

    invoke-direct {v2, v3}, Lmiui/preference/WeekdayPreference$DaysOfWeek;-><init>(I)V

    iput-object v2, p0, Lmiui/preference/WeekdayPreference;->mDaysOfWeek:Lmiui/preference/WeekdayPreference$DaysOfWeek;

    .line 27
    new-instance v2, Lmiui/preference/WeekdayPreference$DaysOfWeek;

    invoke-direct {v2, v3}, Lmiui/preference/WeekdayPreference$DaysOfWeek;-><init>(I)V

    iput-object v2, p0, Lmiui/preference/WeekdayPreference;->mNewDaysOfWeek:Lmiui/preference/WeekdayPreference$DaysOfWeek;

    .line 34
    new-instance v2, Ljava/text/DateFormatSymbols;

    invoke-direct {v2}, Ljava/text/DateFormatSymbols;-><init>()V

    invoke-virtual {v2}, Ljava/text/DateFormatSymbols;->getWeekdays()[Ljava/lang/String;

    move-result-object v1

    .line 35
    .local v1, weekdays:[Ljava/lang/String;
    const/4 v2, 0x7

    new-array v0, v2, [Ljava/lang/String;

    aget-object v2, v1, v5

    aput-object v2, v0, v3

    aget-object v2, v1, v6

    aput-object v2, v0, v4

    aget-object v2, v1, v7

    aput-object v2, v0, v5

    const/4 v2, 0x5

    aget-object v2, v1, v2

    aput-object v2, v0, v6

    const/4 v2, 0x6

    aget-object v2, v1, v2

    aput-object v2, v0, v7

    const/4 v2, 0x5

    const/4 v3, 0x7

    aget-object v3, v1, v3

    aput-object v3, v0, v2

    const/4 v2, 0x6

    aget-object v3, v1, v4

    aput-object v3, v0, v2

    .line 44
    .local v0, values:[Ljava/lang/String;
    invoke-virtual {p0, v0}, Lmiui/preference/WeekdayPreference;->setEntries([Ljava/lang/CharSequence;)V

    .line 45
    invoke-virtual {p0, v0}, Lmiui/preference/WeekdayPreference;->setEntryValues([Ljava/lang/CharSequence;)V

    .line 46
    return-void
.end method

.method static synthetic access$000(Lmiui/preference/WeekdayPreference;)Lmiui/preference/WeekdayPreference$DaysOfWeek;
    .registers 2
    .parameter "x0"

    .prologue
    .line 21
    iget-object v0, p0, Lmiui/preference/WeekdayPreference;->mNewDaysOfWeek:Lmiui/preference/WeekdayPreference$DaysOfWeek;

    return-object v0
.end method


# virtual methods
.method public getDaysOfWeek()Lmiui/preference/WeekdayPreference$DaysOfWeek;
    .registers 2

    .prologue
    .line 88
    iget-object v0, p0, Lmiui/preference/WeekdayPreference;->mDaysOfWeek:Lmiui/preference/WeekdayPreference$DaysOfWeek;

    return-object v0
.end method

.method protected onDialogClosed(Z)V
    .registers 5
    .parameter "positiveResult"

    .prologue
    .line 50
    if-eqz p1, :cond_1d

    .line 51
    iget-object v0, p0, Lmiui/preference/WeekdayPreference;->mDaysOfWeek:Lmiui/preference/WeekdayPreference$DaysOfWeek;

    iget-object v1, p0, Lmiui/preference/WeekdayPreference;->mNewDaysOfWeek:Lmiui/preference/WeekdayPreference$DaysOfWeek;

    invoke-virtual {v0, v1}, Lmiui/preference/WeekdayPreference$DaysOfWeek;->set(Lmiui/preference/WeekdayPreference$DaysOfWeek;)V

    .line 52
    iget-object v0, p0, Lmiui/preference/WeekdayPreference;->mDaysOfWeek:Lmiui/preference/WeekdayPreference$DaysOfWeek;

    invoke-virtual {p0}, Lmiui/preference/WeekdayPreference;->getContext()Landroid/content/Context;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lmiui/preference/WeekdayPreference$DaysOfWeek;->toString(Landroid/content/Context;Z)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lmiui/preference/WeekdayPreference;->setSummary(Ljava/lang/CharSequence;)V

    .line 53
    iget-object v0, p0, Lmiui/preference/WeekdayPreference;->mDaysOfWeek:Lmiui/preference/WeekdayPreference$DaysOfWeek;

    invoke-virtual {p0, v0}, Lmiui/preference/WeekdayPreference;->callChangeListener(Ljava/lang/Object;)Z

    .line 57
    :goto_1c
    return-void

    .line 55
    :cond_1d
    iget-object v0, p0, Lmiui/preference/WeekdayPreference;->mNewDaysOfWeek:Lmiui/preference/WeekdayPreference$DaysOfWeek;

    iget-object v1, p0, Lmiui/preference/WeekdayPreference;->mDaysOfWeek:Lmiui/preference/WeekdayPreference$DaysOfWeek;

    invoke-virtual {v0, v1}, Lmiui/preference/WeekdayPreference$DaysOfWeek;->set(Lmiui/preference/WeekdayPreference$DaysOfWeek;)V

    goto :goto_1c
.end method

.method protected onPrepareDialogBuilder(Landroid/app/AlertDialog$Builder;)V
    .registers 5
    .parameter "builder"

    .prologue
    .line 65
    iget-boolean v1, p0, Lmiui/preference/WeekdayPreference;->mIsSingleChoice:Z

    if-eqz v1, :cond_8

    .line 66
    invoke-super {p0, p1}, Landroid/preference/ListPreference;->onPrepareDialogBuilder(Landroid/app/AlertDialog$Builder;)V

    .line 79
    :goto_7
    return-void

    .line 69
    :cond_8
    invoke-virtual {p0}, Lmiui/preference/WeekdayPreference;->getEntries()[Ljava/lang/CharSequence;

    move-result-object v0

    .line 71
    .local v0, entries:[Ljava/lang/CharSequence;
    iget-object v1, p0, Lmiui/preference/WeekdayPreference;->mDaysOfWeek:Lmiui/preference/WeekdayPreference$DaysOfWeek;

    invoke-virtual {v1}, Lmiui/preference/WeekdayPreference$DaysOfWeek;->getBooleanArray()[Z

    move-result-object v1

    new-instance v2, Lmiui/preference/WeekdayPreference$1;

    invoke-direct {v2, p0}, Lmiui/preference/WeekdayPreference$1;-><init>(Lmiui/preference/WeekdayPreference;)V

    invoke-virtual {p1, v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setMultiChoiceItems([Ljava/lang/CharSequence;[ZLandroid/content/DialogInterface$OnMultiChoiceClickListener;)Landroid/app/AlertDialog$Builder;

    goto :goto_7
.end method

.method public setDaysOfWeek(Lmiui/preference/WeekdayPreference$DaysOfWeek;)V
    .registers 4
    .parameter "dow"

    .prologue
    .line 82
    iget-object v0, p0, Lmiui/preference/WeekdayPreference;->mDaysOfWeek:Lmiui/preference/WeekdayPreference$DaysOfWeek;

    invoke-virtual {v0, p1}, Lmiui/preference/WeekdayPreference$DaysOfWeek;->set(Lmiui/preference/WeekdayPreference$DaysOfWeek;)V

    .line 83
    iget-object v0, p0, Lmiui/preference/WeekdayPreference;->mNewDaysOfWeek:Lmiui/preference/WeekdayPreference$DaysOfWeek;

    invoke-virtual {v0, p1}, Lmiui/preference/WeekdayPreference$DaysOfWeek;->set(Lmiui/preference/WeekdayPreference$DaysOfWeek;)V

    .line 84
    invoke-virtual {p0}, Lmiui/preference/WeekdayPreference;->getContext()Landroid/content/Context;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {p1, v0, v1}, Lmiui/preference/WeekdayPreference$DaysOfWeek;->toString(Landroid/content/Context;Z)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lmiui/preference/WeekdayPreference;->setSummary(Ljava/lang/CharSequence;)V

    .line 85
    return-void
.end method

.method public setSingleChoice(Z)V
    .registers 2
    .parameter "isSingleChoice"

    .prologue
    .line 60
    iput-boolean p1, p0, Lmiui/preference/WeekdayPreference;->mIsSingleChoice:Z

    .line 61
    return-void
.end method
