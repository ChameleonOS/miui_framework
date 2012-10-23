.class public Lmiui/util/HapticFeedbackUtil;
.super Ljava/lang/Object;
.source "HapticFeedbackUtil.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lmiui/util/HapticFeedbackUtil$SettingsObserver;
    }
.end annotation


# static fields
.field private static final KEYBOARD_TAP_PATTERN_PROPERTY:[Ljava/lang/String; = null

.field private static final KEY_VIBRATE_EX_ENABLED:Ljava/lang/String; = "ro.haptic.vibrate_ex.enabled"

.field private static final LONG_PRESS_PATTERN_PROPERTY:[Ljava/lang/String; = null

.field private static final TAG:Ljava/lang/String; = "HapticFeedbackUtil"

.field private static final VIRTUAL_DOWN_PATTERN_PROPERTY:[Ljava/lang/String;

.field private static final VIRTUAL_UP_PATTERN_PROPERTY:[Ljava/lang/String;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private mKeyboardTapVibePattern:[J

.field private mLongPressVibePattern:[J

.field private final mVibrateEx:Z

.field private mVibrator:Landroid/os/Vibrator;

.field private mVirtualKeyUpVibePattern:[J

.field private mVirtualKeyVibePattern:[J


# direct methods
.method static constructor <clinit>()V
    .registers 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 26
    new-array v0, v5, [Ljava/lang/String;

    const-string/jumbo v1, "persist.sys.haptic.long.weak"

    aput-object v1, v0, v2

    const-string/jumbo v1, "persist.sys.haptic.long.normal"

    aput-object v1, v0, v3

    const-string/jumbo v1, "persist.sys.haptic.long.strong"

    aput-object v1, v0, v4

    sput-object v0, Lmiui/util/HapticFeedbackUtil;->LONG_PRESS_PATTERN_PROPERTY:[Ljava/lang/String;

    .line 32
    new-array v0, v5, [Ljava/lang/String;

    const-string/jumbo v1, "persist.sys.haptic.tap.weak"

    aput-object v1, v0, v2

    const-string/jumbo v1, "persist.sys.haptic.tap.normal"

    aput-object v1, v0, v3

    const-string/jumbo v1, "persist.sys.haptic.tap.strong"

    aput-object v1, v0, v4

    sput-object v0, Lmiui/util/HapticFeedbackUtil;->KEYBOARD_TAP_PATTERN_PROPERTY:[Ljava/lang/String;

    .line 38
    new-array v0, v5, [Ljava/lang/String;

    const-string/jumbo v1, "persist.sys.haptic.down.weak"

    aput-object v1, v0, v2

    const-string/jumbo v1, "persist.sys.haptic.down.normal"

    aput-object v1, v0, v3

    const-string/jumbo v1, "persist.sys.haptic.down.strong"

    aput-object v1, v0, v4

    sput-object v0, Lmiui/util/HapticFeedbackUtil;->VIRTUAL_DOWN_PATTERN_PROPERTY:[Ljava/lang/String;

    .line 44
    new-array v0, v5, [Ljava/lang/String;

    const-string/jumbo v1, "persist.sys.haptic.up.weak"

    aput-object v1, v0, v2

    const-string/jumbo v1, "persist.sys.haptic.up.normal"

    aput-object v1, v0, v3

    const-string/jumbo v1, "persist.sys.haptic.up.strong"

    aput-object v1, v0, v4

    sput-object v0, Lmiui/util/HapticFeedbackUtil;->VIRTUAL_UP_PATTERN_PROPERTY:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Z)V
    .registers 6
    .parameter "c"
    .parameter "onceOnly"

    .prologue
    .line 68
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 69
    iput-object p1, p0, Lmiui/util/HapticFeedbackUtil;->mContext:Landroid/content/Context;

    .line 70
    const-string/jumbo v1, "ro.haptic.vibrate_ex.enabled"

    const/4 v2, 0x0

    invoke-static {v1, v2}, Landroid/os/SystemProperties;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    iput-boolean v1, p0, Lmiui/util/HapticFeedbackUtil;->mVibrateEx:Z

    .line 71
    new-instance v1, Landroid/os/SystemVibrator;

    invoke-direct {v1}, Landroid/os/SystemVibrator;-><init>()V

    iput-object v1, p0, Lmiui/util/HapticFeedbackUtil;->mVibrator:Landroid/os/Vibrator;

    .line 72
    if-eqz p2, :cond_1c

    .line 73
    invoke-virtual {p0}, Lmiui/util/HapticFeedbackUtil;->updateSettings()V

    .line 78
    :goto_1b
    return-void

    .line 75
    :cond_1c
    new-instance v0, Lmiui/util/HapticFeedbackUtil$SettingsObserver;

    new-instance v1, Landroid/os/Handler;

    invoke-direct {v1}, Landroid/os/Handler;-><init>()V

    invoke-direct {v0, p0, v1}, Lmiui/util/HapticFeedbackUtil$SettingsObserver;-><init>(Lmiui/util/HapticFeedbackUtil;Landroid/os/Handler;)V

    .line 76
    .local v0, settingsObserver:Lmiui/util/HapticFeedbackUtil$SettingsObserver;
    invoke-virtual {v0}, Lmiui/util/HapticFeedbackUtil$SettingsObserver;->observe()V

    goto :goto_1b
.end method

.method static synthetic access$000(Lmiui/util/HapticFeedbackUtil;)Landroid/content/Context;
    .registers 2
    .parameter "x0"

    .prologue
    .line 21
    iget-object v0, p0, Lmiui/util/HapticFeedbackUtil;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method private static getLongIntArray(Landroid/content/res/Resources;I)[J
    .registers 7
    .parameter "r"
    .parameter "resid"

    .prologue
    .line 178
    invoke-virtual {p0, p1}, Landroid/content/res/Resources;->getIntArray(I)[I

    move-result-object v0

    .line 179
    .local v0, ar:[I
    if-nez v0, :cond_8

    .line 180
    const/4 v2, 0x0

    .line 186
    :cond_7
    return-object v2

    .line 182
    :cond_8
    array-length v3, v0

    new-array v2, v3, [J

    .line 183
    .local v2, out:[J
    const/4 v1, 0x0

    .local v1, i:I
    :goto_c
    array-length v3, v0

    if-ge v1, v3, :cond_7

    .line 184
    aget v3, v0, v1

    int-to-long v3, v3

    aput-wide v3, v2, v1

    .line 183
    add-int/lit8 v1, v1, 0x1

    goto :goto_c
.end method

.method private loadHaptic(Ljava/lang/String;I)[J
    .registers 5
    .parameter "key"
    .parameter "defaultRes"

    .prologue
    .line 168
    invoke-static {p1}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 170
    .local v0, hapString:Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_15

    .line 171
    iget-object v1, p0, Lmiui/util/HapticFeedbackUtil;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-static {v1, p2}, Lmiui/util/HapticFeedbackUtil;->getLongIntArray(Landroid/content/res/Resources;I)[J

    move-result-object v1

    .line 174
    :goto_14
    return-object v1

    :cond_15
    invoke-direct {p0, v0}, Lmiui/util/HapticFeedbackUtil;->stringToLongArray(Ljava/lang/String;)[J

    move-result-object v1

    goto :goto_14
.end method

.method private stringToLongArray(Ljava/lang/String;)[J
    .registers 9
    .parameter "inpString"

    .prologue
    .line 190
    if-nez p1, :cond_b

    .line 191
    const/4 v4, 0x1

    new-array v2, v4, [J

    .line 192
    .local v2, returnByte:[J
    const/4 v4, 0x0

    const-wide/16 v5, 0x0

    aput-wide v5, v2, v4

    .line 202
    :cond_a
    return-object v2

    .line 195
    .end local v2           #returnByte:[J
    :cond_b
    const-string v4, ","

    invoke-virtual {p1, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 196
    .local v3, splitStr:[Ljava/lang/String;
    array-length v1, v3

    .line 197
    .local v1, los:I
    new-array v2, v1, [J

    .line 199
    .restart local v2       #returnByte:[J
    const/4 v0, 0x0

    .local v0, i:I
    :goto_15
    if-ge v0, v1, :cond_a

    .line 200
    aget-object v4, v3, v0

    invoke-virtual {v4}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v4

    aput-wide v4, v2, v0

    .line 199
    add-int/lit8 v0, v0, 0x1

    goto :goto_15
.end method


# virtual methods
.method public isSupportedEffect(I)Z
    .registers 3
    .parameter "effectId"

    .prologue
    .line 81
    const/4 v0, 0x3

    if-gt p1, v0, :cond_5

    const/4 v0, 0x1

    :goto_4
    return v0

    :cond_5
    const/4 v0, 0x0

    goto :goto_4
.end method

.method public performHapticFeedback(IZ)Z
    .registers 12
    .parameter "effectId"
    .parameter "always"

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 121
    iget-object v6, p0, Lmiui/util/HapticFeedbackUtil;->mContext:Landroid/content/Context;

    invoke-virtual {v6}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v6

    const-string v7, "haptic_feedback_enabled"

    invoke-static {v6, v7, v4}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v6

    if-nez v6, :cond_16

    move v1, v5

    .line 123
    .local v1, hapticsDisabled:Z
    :goto_11
    if-nez p2, :cond_18

    if-eqz v1, :cond_18

    .line 164
    :goto_15
    return v4

    .end local v1           #hapticsDisabled:Z
    :cond_16
    move v1, v4

    .line 121
    goto :goto_11

    .line 127
    .restart local v1       #hapticsDisabled:Z
    :cond_18
    const/4 v3, 0x0

    .line 128
    .local v3, pattern:[J
    packed-switch p1, :pswitch_data_64

    goto :goto_15

    .line 130
    :pswitch_1d
    iget-object v3, p0, Lmiui/util/HapticFeedbackUtil;->mLongPressVibePattern:[J

    .line 145
    :goto_1f
    if-eqz v3, :cond_24

    array-length v6, v3

    if-nez v6, :cond_36

    .line 146
    :cond_24
    const-string v5, "HapticFeedbackUtil"

    const-string/jumbo v6, "vibrate: null or empty pattern"

    invoke-static {v5, v6}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_15

    .line 133
    :pswitch_2d
    iget-object v3, p0, Lmiui/util/HapticFeedbackUtil;->mVirtualKeyVibePattern:[J

    .line 134
    goto :goto_1f

    .line 136
    :pswitch_30
    iget-object v3, p0, Lmiui/util/HapticFeedbackUtil;->mKeyboardTapVibePattern:[J

    .line 137
    goto :goto_1f

    .line 139
    :pswitch_33
    iget-object v3, p0, Lmiui/util/HapticFeedbackUtil;->mVirtualKeyUpVibePattern:[J

    .line 140
    goto :goto_1f

    .line 150
    :cond_36
    iget-boolean v6, p0, Lmiui/util/HapticFeedbackUtil;->mVibrateEx:Z

    if-eqz v6, :cond_51

    .line 151
    array-length v4, v3

    new-array v0, v4, [B

    .line 152
    .local v0, bytes:[B
    const/4 v2, 0x0

    .local v2, i:I
    :goto_3e
    array-length v4, v3

    if-ge v2, v4, :cond_4a

    .line 153
    aget-wide v6, v3, v2

    long-to-int v4, v6

    int-to-byte v4, v4

    aput-byte v4, v0, v2

    .line 152
    add-int/lit8 v2, v2, 0x1

    goto :goto_3e

    .line 155
    :cond_4a
    iget-object v4, p0, Lmiui/util/HapticFeedbackUtil;->mVibrator:Landroid/os/Vibrator;

    invoke-virtual {v4, v0}, Landroid/os/Vibrator;->vibrateEx([B)V

    .end local v0           #bytes:[B
    .end local v2           #i:I
    :goto_4f
    move v4, v5

    .line 164
    goto :goto_15

    .line 156
    :cond_51
    array-length v6, v3

    if-ne v6, v5, :cond_5c

    .line 158
    iget-object v6, p0, Lmiui/util/HapticFeedbackUtil;->mVibrator:Landroid/os/Vibrator;

    aget-wide v7, v3, v4

    invoke-virtual {v6, v7, v8}, Landroid/os/Vibrator;->vibrate(J)V

    goto :goto_4f

    .line 161
    :cond_5c
    iget-object v4, p0, Lmiui/util/HapticFeedbackUtil;->mVibrator:Landroid/os/Vibrator;

    const/4 v6, -0x1

    invoke-virtual {v4, v3, v6}, Landroid/os/Vibrator;->vibrate([JI)V

    goto :goto_4f

    .line 128
    nop

    :pswitch_data_64
    .packed-switch 0x0
        :pswitch_1d
        :pswitch_2d
        :pswitch_33
        :pswitch_30
    .end packed-switch
.end method

.method public updateSettings()V
    .registers 5

    .prologue
    .line 103
    iget-object v1, p0, Lmiui/util/HapticFeedbackUtil;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const-string v2, "haptic_feedback_level"

    const/4 v3, 0x1

    invoke-static {v1, v2, v3}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v0

    .line 107
    .local v0, level:I
    const/4 v1, 0x2

    const/4 v2, 0x0

    invoke-static {v2, v0}, Ljava/lang/Math;->max(II)I

    move-result v2

    invoke-static {v1, v2}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 110
    sget-object v1, Lmiui/util/HapticFeedbackUtil;->LONG_PRESS_PATTERN_PROPERTY:[Ljava/lang/String;

    aget-object v1, v1, v0

    iget-object v2, p0, Lmiui/util/HapticFeedbackUtil;->mContext:Landroid/content/Context;

    const v3, 0x6060008

    invoke-static {v2, v3}, Lmiui/util/ResourceMapper;->resolveReference(Landroid/content/Context;I)I

    move-result v2

    invoke-direct {p0, v1, v2}, Lmiui/util/HapticFeedbackUtil;->loadHaptic(Ljava/lang/String;I)[J

    move-result-object v1

    iput-object v1, p0, Lmiui/util/HapticFeedbackUtil;->mLongPressVibePattern:[J

    .line 112
    sget-object v1, Lmiui/util/HapticFeedbackUtil;->VIRTUAL_DOWN_PATTERN_PROPERTY:[Ljava/lang/String;

    aget-object v1, v1, v0

    iget-object v2, p0, Lmiui/util/HapticFeedbackUtil;->mContext:Landroid/content/Context;

    const v3, 0x6060004

    invoke-static {v2, v3}, Lmiui/util/ResourceMapper;->resolveReference(Landroid/content/Context;I)I

    move-result v2

    invoke-direct {p0, v1, v2}, Lmiui/util/HapticFeedbackUtil;->loadHaptic(Ljava/lang/String;I)[J

    move-result-object v1

    iput-object v1, p0, Lmiui/util/HapticFeedbackUtil;->mVirtualKeyVibePattern:[J

    .line 114
    sget-object v1, Lmiui/util/HapticFeedbackUtil;->KEYBOARD_TAP_PATTERN_PROPERTY:[Ljava/lang/String;

    aget-object v1, v1, v0

    iget-object v2, p0, Lmiui/util/HapticFeedbackUtil;->mContext:Landroid/content/Context;

    const v3, 0x6060009

    invoke-static {v2, v3}, Lmiui/util/ResourceMapper;->resolveReference(Landroid/content/Context;I)I

    move-result v2

    invoke-direct {p0, v1, v2}, Lmiui/util/HapticFeedbackUtil;->loadHaptic(Ljava/lang/String;I)[J

    move-result-object v1

    iput-object v1, p0, Lmiui/util/HapticFeedbackUtil;->mKeyboardTapVibePattern:[J

    .line 116
    sget-object v1, Lmiui/util/HapticFeedbackUtil;->VIRTUAL_UP_PATTERN_PROPERTY:[Ljava/lang/String;

    aget-object v1, v1, v0

    const v2, 0x6060002

    invoke-direct {p0, v1, v2}, Lmiui/util/HapticFeedbackUtil;->loadHaptic(Ljava/lang/String;I)[J

    move-result-object v1

    iput-object v1, p0, Lmiui/util/HapticFeedbackUtil;->mVirtualKeyUpVibePattern:[J

    .line 118
    return-void
.end method
