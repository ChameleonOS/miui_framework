.class public Lmiui/widget/DigitalClock;
.super Landroid/widget/RelativeLayout;
.source "DigitalClock.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lmiui/widget/DigitalClock$FormatChangeObserver;,
        Lmiui/widget/DigitalClock$AmPm;,
        Lmiui/widget/DigitalClock$TimeChangedReceiver;
    }
.end annotation


# static fields
.field private static final M12:Ljava/lang/String; = "h:mm"

.field private static final M24:Ljava/lang/String; = "kk:mm"

.field private static final SYSTEM:Ljava/lang/String; = "/system/fonts/"

.field private static final SYSTEM_FONT_TIME_BACKGROUND:Ljava/lang/String; = "/system/fonts/AndroidClock.ttf"

.field private static final SYSTEM_FONT_TIME_FOREGROUND:Ljava/lang/String; = "/system/fonts/AndroidClock_Highlight.ttf"

.field private static final sBackgroundFont:Landroid/graphics/Typeface;

.field private static final sForegroundFont:Landroid/graphics/Typeface;


# instance fields
.field private mAmPm:Lmiui/widget/DigitalClock$AmPm;

.field private mAttached:I

.field private mCalendar:Ljava/util/Calendar;

.field private mFormat:Ljava/lang/String;

.field private mFormatChangeObserver:Landroid/database/ContentObserver;

.field private final mHandler:Landroid/os/Handler;

.field private mIntentReceiver:Landroid/content/BroadcastReceiver;

.field private mTimeDisplayBackground:Landroid/widget/TextView;

.field private mTimeDisplayForeground:Landroid/widget/TextView;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 66
    const-string v0, "/system/fonts/AndroidClock.ttf"

    invoke-static {v0}, Landroid/graphics/Typeface;->createFromFile(Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    sput-object v0, Lmiui/widget/DigitalClock;->sBackgroundFont:Landroid/graphics/Typeface;

    .line 67
    const-string v0, "/system/fonts/AndroidClock_Highlight.ttf"

    invoke-static {v0}, Landroid/graphics/Typeface;->createFromFile(Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    sput-object v0, Lmiui/widget/DigitalClock;->sForegroundFont:Landroid/graphics/Typeface;

    .line 68
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .registers 3
    .parameter "context"

    .prologue
    .line 158
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lmiui/widget/DigitalClock;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 159
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 4
    .parameter "context"
    .parameter "attrs"

    .prologue
    .line 162
    invoke-direct {p0, p1, p2}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 56
    const/4 v0, 0x0

    iput v0, p0, Lmiui/widget/DigitalClock;->mAttached:I

    .line 59
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lmiui/widget/DigitalClock;->mHandler:Landroid/os/Handler;

    .line 163
    return-void
.end method

.method static synthetic access$002(Lmiui/widget/DigitalClock;Ljava/util/Calendar;)Ljava/util/Calendar;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 42
    iput-object p1, p0, Lmiui/widget/DigitalClock;->mCalendar:Ljava/util/Calendar;

    return-object p1
.end method

.method static synthetic access$100(Lmiui/widget/DigitalClock;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 42
    invoke-direct {p0}, Lmiui/widget/DigitalClock;->updateTime()V

    return-void
.end method

.method static synthetic access$200(Lmiui/widget/DigitalClock;)Landroid/os/Handler;
    .registers 2
    .parameter "x0"

    .prologue
    .line 42
    iget-object v0, p0, Lmiui/widget/DigitalClock;->mHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$300(Lmiui/widget/DigitalClock;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 42
    invoke-direct {p0}, Lmiui/widget/DigitalClock;->setDateFormat()V

    return-void
.end method

.method private setDateFormat()V
    .registers 4

    .prologue
    .line 241
    invoke-virtual {p0}, Lmiui/widget/DigitalClock;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/text/format/DateFormat;->is24HourFormat(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_1c

    const-string v0, "kk:mm"

    :goto_c
    iput-object v0, p0, Lmiui/widget/DigitalClock;->mFormat:Ljava/lang/String;

    .line 243
    iget-object v0, p0, Lmiui/widget/DigitalClock;->mAmPm:Lmiui/widget/DigitalClock$AmPm;

    iget-object v1, p0, Lmiui/widget/DigitalClock;->mFormat:Ljava/lang/String;

    const-string v2, "h:mm"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    invoke-virtual {v0, v1}, Lmiui/widget/DigitalClock$AmPm;->setShowAmPm(Z)V

    .line 244
    return-void

    .line 241
    :cond_1c
    const-string v0, "h:mm"

    goto :goto_c
.end method

.method private updateTime()V
    .registers 5

    .prologue
    .line 232
    iget-object v1, p0, Lmiui/widget/DigitalClock;->mCalendar:Ljava/util/Calendar;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/util/Calendar;->setTimeInMillis(J)V

    .line 234
    iget-object v1, p0, Lmiui/widget/DigitalClock;->mFormat:Ljava/lang/String;

    iget-object v2, p0, Lmiui/widget/DigitalClock;->mCalendar:Ljava/util/Calendar;

    invoke-static {v1, v2}, Landroid/text/format/DateFormat;->format(Ljava/lang/CharSequence;Ljava/util/Calendar;)Ljava/lang/CharSequence;

    move-result-object v0

    .line 235
    .local v0, newTime:Ljava/lang/CharSequence;
    iget-object v1, p0, Lmiui/widget/DigitalClock;->mTimeDisplayBackground:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 236
    iget-object v1, p0, Lmiui/widget/DigitalClock;->mTimeDisplayForeground:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 237
    iget-object v2, p0, Lmiui/widget/DigitalClock;->mAmPm:Lmiui/widget/DigitalClock$AmPm;

    iget-object v1, p0, Lmiui/widget/DigitalClock;->mCalendar:Ljava/util/Calendar;

    const/16 v3, 0x9

    invoke-virtual {v1, v3}, Ljava/util/Calendar;->get(I)I

    move-result v1

    if-nez v1, :cond_2c

    const/4 v1, 0x1

    :goto_28
    invoke-virtual {v2, v1}, Lmiui/widget/DigitalClock$AmPm;->setIsMorning(Z)V

    .line 238
    return-void

    .line 237
    :cond_2c
    const/4 v1, 0x0

    goto :goto_28
.end method


# virtual methods
.method protected onAttachedToWindow()V
    .registers 6

    .prologue
    .line 184
    invoke-super {p0}, Landroid/widget/RelativeLayout;->onAttachedToWindow()V

    .line 186
    iget v1, p0, Lmiui/widget/DigitalClock;->mAttached:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lmiui/widget/DigitalClock;->mAttached:I

    .line 189
    iget-object v1, p0, Lmiui/widget/DigitalClock;->mIntentReceiver:Landroid/content/BroadcastReceiver;

    if-nez v1, :cond_2f

    .line 190
    new-instance v1, Lmiui/widget/DigitalClock$TimeChangedReceiver;

    invoke-direct {v1, p0}, Lmiui/widget/DigitalClock$TimeChangedReceiver;-><init>(Lmiui/widget/DigitalClock;)V

    iput-object v1, p0, Lmiui/widget/DigitalClock;->mIntentReceiver:Landroid/content/BroadcastReceiver;

    .line 191
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 192
    .local v0, filter:Landroid/content/IntentFilter;
    const-string v1, "android.intent.action.TIME_TICK"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 193
    const-string v1, "android.intent.action.TIME_SET"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 194
    const-string v1, "android.intent.action.TIMEZONE_CHANGED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 195
    iget-object v1, p0, Landroid/view/View;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lmiui/widget/DigitalClock;->mIntentReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {v1, v2, v0}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 199
    .end local v0           #filter:Landroid/content/IntentFilter;
    :cond_2f
    iget-object v1, p0, Lmiui/widget/DigitalClock;->mFormatChangeObserver:Landroid/database/ContentObserver;

    if-nez v1, :cond_48

    .line 200
    new-instance v1, Lmiui/widget/DigitalClock$FormatChangeObserver;

    invoke-direct {v1, p0}, Lmiui/widget/DigitalClock$FormatChangeObserver;-><init>(Lmiui/widget/DigitalClock;)V

    iput-object v1, p0, Lmiui/widget/DigitalClock;->mFormatChangeObserver:Landroid/database/ContentObserver;

    .line 201
    iget-object v1, p0, Landroid/view/View;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    sget-object v2, Landroid/provider/Settings$System;->CONTENT_URI:Landroid/net/Uri;

    const/4 v3, 0x1

    iget-object v4, p0, Lmiui/widget/DigitalClock;->mFormatChangeObserver:Landroid/database/ContentObserver;

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/ContentResolver;->registerContentObserver(Landroid/net/Uri;ZLandroid/database/ContentObserver;)V

    .line 205
    :cond_48
    invoke-direct {p0}, Lmiui/widget/DigitalClock;->updateTime()V

    .line 206
    return-void
.end method

.method protected onDetachedFromWindow()V
    .registers 4

    .prologue
    const/4 v2, 0x0

    .line 210
    invoke-super {p0}, Landroid/widget/RelativeLayout;->onDetachedFromWindow()V

    .line 212
    iget v0, p0, Lmiui/widget/DigitalClock;->mAttached:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lmiui/widget/DigitalClock;->mAttached:I

    .line 214
    iget-object v0, p0, Lmiui/widget/DigitalClock;->mIntentReceiver:Landroid/content/BroadcastReceiver;

    if-eqz v0, :cond_15

    .line 215
    iget-object v0, p0, Landroid/view/View;->mContext:Landroid/content/Context;

    iget-object v1, p0, Lmiui/widget/DigitalClock;->mIntentReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {v0, v1}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 217
    :cond_15
    iget-object v0, p0, Lmiui/widget/DigitalClock;->mFormatChangeObserver:Landroid/database/ContentObserver;

    if-eqz v0, :cond_24

    .line 218
    iget-object v0, p0, Landroid/view/View;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    iget-object v1, p0, Lmiui/widget/DigitalClock;->mFormatChangeObserver:Landroid/database/ContentObserver;

    invoke-virtual {v0, v1}, Landroid/content/ContentResolver;->unregisterContentObserver(Landroid/database/ContentObserver;)V

    .line 222
    :cond_24
    iput-object v2, p0, Lmiui/widget/DigitalClock;->mFormatChangeObserver:Landroid/database/ContentObserver;

    .line 223
    iput-object v2, p0, Lmiui/widget/DigitalClock;->mIntentReceiver:Landroid/content/BroadcastReceiver;

    .line 224
    return-void
.end method

.method protected onFinishInflate()V
    .registers 3

    .prologue
    .line 167
    invoke-super {p0}, Landroid/widget/RelativeLayout;->onFinishInflate()V

    .line 170
    const v0, 0x60b0013

    invoke-virtual {p0, v0}, Lmiui/widget/DigitalClock;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lmiui/widget/DigitalClock;->mTimeDisplayBackground:Landroid/widget/TextView;

    .line 171
    iget-object v0, p0, Lmiui/widget/DigitalClock;->mTimeDisplayBackground:Landroid/widget/TextView;

    sget-object v1, Lmiui/widget/DigitalClock;->sBackgroundFont:Landroid/graphics/Typeface;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 172
    iget-object v0, p0, Lmiui/widget/DigitalClock;->mTimeDisplayBackground:Landroid/widget/TextView;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 174
    const v0, 0x60b0014

    invoke-virtual {p0, v0}, Lmiui/widget/DigitalClock;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lmiui/widget/DigitalClock;->mTimeDisplayForeground:Landroid/widget/TextView;

    .line 175
    iget-object v0, p0, Lmiui/widget/DigitalClock;->mTimeDisplayForeground:Landroid/widget/TextView;

    sget-object v1, Lmiui/widget/DigitalClock;->sForegroundFont:Landroid/graphics/Typeface;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 176
    new-instance v0, Lmiui/widget/DigitalClock$AmPm;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lmiui/widget/DigitalClock$AmPm;-><init>(Landroid/view/View;Landroid/graphics/Typeface;)V

    iput-object v0, p0, Lmiui/widget/DigitalClock;->mAmPm:Lmiui/widget/DigitalClock$AmPm;

    .line 177
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    iput-object v0, p0, Lmiui/widget/DigitalClock;->mCalendar:Ljava/util/Calendar;

    .line 179
    invoke-direct {p0}, Lmiui/widget/DigitalClock;->setDateFormat()V

    .line 180
    return-void
.end method

.method updateTime(Ljava/util/Calendar;)V
    .registers 2
    .parameter "c"

    .prologue
    .line 227
    iput-object p1, p0, Lmiui/widget/DigitalClock;->mCalendar:Ljava/util/Calendar;

    .line 228
    invoke-direct {p0}, Lmiui/widget/DigitalClock;->updateTime()V

    .line 229
    return-void
.end method
