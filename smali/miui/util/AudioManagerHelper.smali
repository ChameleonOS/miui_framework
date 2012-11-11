.class public Lmiui/util/AudioManagerHelper;
.super Ljava/lang/Object;
.source "AudioManagerHelper.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static amendVibratePrefs(Landroid/content/Context;)V
    .registers 2
    .parameter "context"

    .prologue
    invoke-static {p0}, Lmiui/util/AudioManagerHelper;->amendVibratePrefsByRingerMode(Landroid/content/Context;)V

    const/4 v0, 0x1

    invoke-static {p0, v0}, Lmiui/util/AudioManagerHelper;->amendVibratePrefsByVibrate(Landroid/content/Context;I)V

    const/4 v0, 0x0

    invoke-static {p0, v0}, Lmiui/util/AudioManagerHelper;->amendVibratePrefsByVibrate(Landroid/content/Context;I)V

    return-void
.end method

.method public static amendVibratePrefsByRingerMode(Landroid/content/Context;)V
    .registers 6
    .parameter "context"

    .prologue
    const/4 v4, 0x1

    const-string v2, "audio"

    invoke-virtual {p0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/media/AudioManager;

    .local v0, am:Landroid/media/AudioManager;
    invoke-virtual {v0}, Landroid/media/AudioManager;->getRingerMode()I

    move-result v1

    .local v1, ringerMode:I
    if-nez v1, :cond_1b

    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    const-string/jumbo v3, "vibrate_in_silent"

    const/4 v4, 0x0

    invoke-static {v2, v3, v4}, Lmiui/util/AudioManagerHelper;->updatePrefIfChanged(Landroid/content/ContentResolver;Ljava/lang/String;I)V

    :cond_1a
    :goto_1a
    return-void

    :cond_1b
    if-ne v1, v4, :cond_1a

    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    const-string/jumbo v3, "vibrate_in_silent"

    invoke-static {v2, v3, v4}, Lmiui/util/AudioManagerHelper;->updatePrefIfChanged(Landroid/content/ContentResolver;Ljava/lang/String;I)V

    goto :goto_1a
.end method

.method public static amendVibratePrefsByVibrate(Landroid/content/Context;I)V
    .registers 8
    .parameter "context"
    .parameter "vibrateType"

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x1

    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    .local v1, cr:Landroid/content/ContentResolver;
    const-string v3, "audio"

    invoke-virtual {p0, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/media/AudioManager;

    .local v0, am:Landroid/media/AudioManager;
    if-nez p1, :cond_1b

    const-string/jumbo v2, "vibrate_ringer"

    .local v2, pref:Ljava/lang/String;
    :goto_13
    invoke-virtual {v0, p1}, Landroid/media/AudioManager;->getVibrateSetting(I)I

    move-result v3

    packed-switch v3, :pswitch_data_50

    :cond_1a
    :goto_1a
    return-void

    .end local v2           #pref:Ljava/lang/String;
    :cond_1b
    const-string/jumbo v2, "vibrate_notification"

    goto :goto_13

    .restart local v2       #pref:Ljava/lang/String;
    :pswitch_1f
    const-string/jumbo v3, "vibrate_in_silent"

    invoke-static {v1, v3, v4}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v3

    if-eq v3, v4, :cond_31

    const-string/jumbo v3, "vibrate_in_normal"

    invoke-static {v1, v3, v5}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v3

    if-ne v3, v4, :cond_1a

    :cond_31
    invoke-static {v1, v2, v5}, Lmiui/util/AudioManagerHelper;->updatePrefIfChanged(Landroid/content/ContentResolver;Ljava/lang/String;I)V

    goto :goto_1a

    :pswitch_35
    const-string/jumbo v3, "vibrate_in_normal"

    invoke-static {v1, v3, v4}, Lmiui/util/AudioManagerHelper;->updatePrefIfChanged(Landroid/content/ContentResolver;Ljava/lang/String;I)V

    invoke-static {v1, v2, v4}, Lmiui/util/AudioManagerHelper;->updatePrefIfChanged(Landroid/content/ContentResolver;Ljava/lang/String;I)V

    goto :goto_1a

    :pswitch_3f
    const-string/jumbo v3, "vibrate_in_silent"

    invoke-static {v1, v3, v4}, Lmiui/util/AudioManagerHelper;->updatePrefIfChanged(Landroid/content/ContentResolver;Ljava/lang/String;I)V

    const-string/jumbo v3, "vibrate_in_normal"

    invoke-static {v1, v3, v5}, Lmiui/util/AudioManagerHelper;->updatePrefIfChanged(Landroid/content/ContentResolver;Ljava/lang/String;I)V

    invoke-static {v1, v2, v4}, Lmiui/util/AudioManagerHelper;->updatePrefIfChanged(Landroid/content/ContentResolver;Ljava/lang/String;I)V

    goto :goto_1a

    nop

    :pswitch_data_50
    .packed-switch 0x0
        :pswitch_1f
        :pswitch_35
        :pswitch_3f
    .end packed-switch
.end method

.method public static isSilentEnabled(Landroid/content/Context;)Z
    .registers 4
    .parameter "context"

    .prologue
    const-string v1, "audio"

    invoke-virtual {p0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/media/AudioManager;

    .local v0, am:Landroid/media/AudioManager;
    invoke-virtual {v0}, Landroid/media/AudioManager;->getRingerMode()I

    move-result v1

    const/4 v2, 0x2

    if-eq v1, v2, :cond_11

    const/4 v1, 0x1

    :goto_10
    return v1

    :cond_11
    const/4 v1, 0x0

    goto :goto_10
.end method

.method public static isVibrateEnabled(Landroid/content/Context;)Z
    .registers 7
    .parameter "context"

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    const-string v4, "audio"

    invoke-virtual {p0, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/media/AudioManager;

    .local v1, am:Landroid/media/AudioManager;
    const/4 v0, 0x0

    .local v0, allowVibrate:Z
    invoke-virtual {v1}, Landroid/media/AudioManager;->getRingerMode()I

    move-result v4

    packed-switch v4, :pswitch_data_48

    :goto_12
    if-eqz v0, :cond_45

    const-string/jumbo v4, "vibrate_ringer"

    invoke-static {p0, v4}, Lmiui/provider/ExtraSettings$System;->isVibratePrefOn(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_2f

    const-string/jumbo v4, "vibrate_notification"

    invoke-static {p0, v4}, Lmiui/provider/ExtraSettings$System;->isVibratePrefOn(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_2f

    const-string/jumbo v4, "vibrate_mms"

    invoke-static {p0, v4}, Lmiui/provider/ExtraSettings$System;->isVibratePrefOn(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_45

    :cond_2f
    :goto_2f
    return v2

    :pswitch_30
    const/4 v0, 0x0

    goto :goto_12

    :pswitch_32
    const/4 v0, 0x1

    goto :goto_12

    :pswitch_34
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v4

    const-string/jumbo v5, "vibrate_in_normal"

    invoke-static {v4, v5, v3}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v4

    if-ne v4, v2, :cond_43

    move v0, v2

    :goto_42
    goto :goto_12

    :cond_43
    move v0, v3

    goto :goto_42

    :cond_45
    move v2, v3

    goto :goto_2f

    nop

    :pswitch_data_48
    .packed-switch 0x0
        :pswitch_30
        :pswitch_32
        :pswitch_34
    .end packed-switch
.end method

.method public static saveLastAudibleRingVolume(Landroid/content/Context;I)V
    .registers 4
    .parameter "context"
    .parameter "volume"

    .prologue
    if-lez p1, :cond_b

    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const-string v1, "last_audible_ring_volume"

    invoke-static {v0, v1, p1}, Landroid/provider/Settings$System;->putInt(Landroid/content/ContentResolver;Ljava/lang/String;I)Z

    :cond_b
    return-void
.end method

.method public static setRingerMode(Landroid/content/Context;I)V
    .registers 9
    .parameter "context"
    .parameter "ringerMode"

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x2

    const-string v3, "audio"

    invoke-virtual {p0, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/media/AudioManager;

    .local v0, am:Landroid/media/AudioManager;
    invoke-virtual {v0}, Landroid/media/AudioManager;->getRingerMode()I

    move-result v1

    .local v1, oldRingerMode:I
    invoke-virtual {v0, p1}, Landroid/media/AudioManager;->setRingerMode(I)V

    if-ne p1, v5, :cond_24

    if-eq v1, v5, :cond_24

    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    const-string v4, "last_audible_ring_volume"

    invoke-static {v3, v4, v6}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v2

    .local v2, volume:I
    if-lez v2, :cond_24

    invoke-virtual {v0, v5, v2, v6}, Landroid/media/AudioManager;->setStreamVolume(III)V

    .end local v2           #volume:I
    :cond_24
    return-void
.end method

.method private static setVibrateInternel(Landroid/content/Context;Ljava/lang/String;IZZ)V
    .registers 10
    .parameter "context"
    .parameter "pref"
    .parameter "vibrateType"
    .parameter "vibrateInNormal"
    .parameter "vibrateInSilent"

    .prologue
    const/4 v3, 0x0

    const-string v4, "audio"

    invoke-virtual {p0, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/media/AudioManager;

    .local v0, am:Landroid/media/AudioManager;
    invoke-static {p0, p1}, Lmiui/provider/ExtraSettings$System;->isVibratePrefOn(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v1

    .local v1, vibratePref:Z
    const/4 v2, 0x0

    .local v2, vibrateSetting:I
    if-eqz p3, :cond_19

    if-eqz v1, :cond_17

    const/4 v2, 0x1

    :cond_13
    :goto_13
    invoke-virtual {v0, p2, v2}, Landroid/media/AudioManager;->setVibrateSetting(II)V

    return-void

    :cond_17
    move v2, v3

    goto :goto_13

    :cond_19
    if-eqz p4, :cond_13

    if-eqz v1, :cond_1f

    const/4 v2, 0x2

    :goto_1e
    goto :goto_13

    :cond_1f
    move v2, v3

    goto :goto_1e
.end method

.method public static shouldVibrateForPref(Landroid/content/Context;Ljava/lang/String;)Z
    .registers 8
    .parameter "context"
    .parameter "pref"

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    const/4 v1, 0x0

    .local v1, ret:Z
    const-string v4, "audio"

    invoke-virtual {p0, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/media/AudioManager;

    .local v0, am:Landroid/media/AudioManager;
    invoke-virtual {v0}, Landroid/media/AudioManager;->getRingerMode()I

    move-result v4

    packed-switch v4, :pswitch_data_32

    :goto_12
    return v1

    :pswitch_13
    const/4 v1, 0x0

    goto :goto_12

    :pswitch_15
    invoke-static {p0, p1}, Lmiui/provider/ExtraSettings$System;->isVibratePrefOn(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v1

    goto :goto_12

    :pswitch_1a
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v4

    const-string/jumbo v5, "vibrate_in_normal"

    invoke-static {v4, v5, v3}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v4

    if-ne v4, v2, :cond_2e

    .local v2, vibrateInNormal:Z
    :goto_27
    if-eqz v2, :cond_30

    invoke-static {p0, p1}, Lmiui/provider/ExtraSettings$System;->isVibratePrefOn(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v1

    :goto_2d
    goto :goto_12

    .end local v2           #vibrateInNormal:Z
    :cond_2e
    move v2, v3

    goto :goto_27

    .restart local v2       #vibrateInNormal:Z
    :cond_30
    move v1, v3

    goto :goto_2d

    :pswitch_data_32
    .packed-switch 0x0
        :pswitch_13
        :pswitch_15
        :pswitch_1a
    .end packed-switch
.end method

.method public static toggleSilent(Landroid/content/Context;)V
    .registers 2
    .parameter "context"

    .prologue
    invoke-static {p0}, Lmiui/util/AudioManagerHelper;->isSilentEnabled(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_b

    const/4 v0, 0x1

    :goto_7
    invoke-static {p0, v0}, Lmiui/util/AudioManagerHelper;->updateVibrateState(Landroid/content/Context;Z)V

    return-void

    :cond_b
    const/4 v0, 0x0

    goto :goto_7
.end method

.method public static toggleVibrate(Landroid/content/Context;)V
    .registers 8
    .parameter "context"

    .prologue
    const/4 v4, 0x1

    const/4 v5, 0x0

    const-string v6, "audio"

    invoke-virtual {p0, v6}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/media/AudioManager;

    .local v0, am:Landroid/media/AudioManager;
    invoke-static {p0}, Lmiui/util/AudioManagerHelper;->isVibrateEnabled(Landroid/content/Context;)Z

    move-result v6

    if-nez v6, :cond_21

    move v3, v4

    .local v3, vibrate:Z
    :goto_11
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    .local v1, cr:Landroid/content/ContentResolver;
    const/4 v2, 0x0

    .local v2, silent:Z
    invoke-virtual {v0}, Landroid/media/AudioManager;->getRingerMode()I

    move-result v6

    packed-switch v6, :pswitch_data_3a

    :goto_1d
    invoke-static {p0, v2}, Lmiui/util/AudioManagerHelper;->updateVibrateState(Landroid/content/Context;Z)V

    return-void

    .end local v1           #cr:Landroid/content/ContentResolver;
    .end local v2           #silent:Z
    .end local v3           #vibrate:Z
    :cond_21
    move v3, v5

    goto :goto_11

    .restart local v1       #cr:Landroid/content/ContentResolver;
    .restart local v2       #silent:Z
    .restart local v3       #vibrate:Z
    :pswitch_23
    const-string/jumbo v6, "vibrate_in_silent"

    if-eqz v3, :cond_2d

    :goto_28
    invoke-static {v1, v6, v4}, Landroid/provider/Settings$System;->putInt(Landroid/content/ContentResolver;Ljava/lang/String;I)Z

    const/4 v2, 0x1

    goto :goto_1d

    :cond_2d
    move v4, v5

    goto :goto_28

    :pswitch_2f
    const-string/jumbo v6, "vibrate_in_normal"

    if-eqz v3, :cond_38

    :goto_34
    invoke-static {v1, v6, v4}, Landroid/provider/Settings$System;->putInt(Landroid/content/ContentResolver;Ljava/lang/String;I)Z

    goto :goto_1d

    :cond_38
    move v4, v5

    goto :goto_34

    :pswitch_data_3a
    .packed-switch 0x0
        :pswitch_23
        :pswitch_23
        :pswitch_2f
    .end packed-switch
.end method

.method private static updatePrefIfChanged(Landroid/content/ContentResolver;Ljava/lang/String;I)V
    .registers 4
    .parameter "cr"
    .parameter "name"
    .parameter "value"

    .prologue
    neg-int v0, p2

    invoke-static {p0, p1, v0}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v0

    if-eq v0, p2, :cond_a

    invoke-static {p0, p1, p2}, Landroid/provider/Settings$System;->putInt(Landroid/content/ContentResolver;Ljava/lang/String;I)Z

    :cond_a
    return-void
.end method

.method public static updateVibrateState(Landroid/content/Context;Z)V
    .registers 9
    .parameter "context"
    .parameter "silent"

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x1

    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .local v0, cr:Landroid/content/ContentResolver;
    const-string/jumbo v6, "vibrate_in_silent"

    invoke-static {v0, v6, v4}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v6

    if-ne v6, v4, :cond_30

    move v3, v4

    .local v3, vibrateInSilent:Z
    :goto_10
    const-string/jumbo v6, "vibrate_in_normal"

    invoke-static {v0, v6, v5}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v6

    if-ne v6, v4, :cond_32

    move v2, v4

    .local v2, vibrateInNormal:Z
    :goto_1a
    const/4 v1, 0x2

    .local v1, ringerMode:I
    if-eqz p1, :cond_20

    if-eqz v3, :cond_34

    const/4 v1, 0x1

    :cond_20
    :goto_20
    invoke-static {p0, v1}, Lmiui/util/AudioManagerHelper;->setRingerMode(Landroid/content/Context;I)V

    const-string/jumbo v6, "vibrate_ringer"

    invoke-static {p0, v6, v5, v2, v3}, Lmiui/util/AudioManagerHelper;->setVibrateInternel(Landroid/content/Context;Ljava/lang/String;IZZ)V

    const-string/jumbo v5, "vibrate_notification"

    invoke-static {p0, v5, v4, v2, v3}, Lmiui/util/AudioManagerHelper;->setVibrateInternel(Landroid/content/Context;Ljava/lang/String;IZZ)V

    return-void

    .end local v1           #ringerMode:I
    .end local v2           #vibrateInNormal:Z
    .end local v3           #vibrateInSilent:Z
    :cond_30
    move v3, v5

    goto :goto_10

    .restart local v3       #vibrateInSilent:Z
    :cond_32
    move v2, v5

    goto :goto_1a

    .restart local v1       #ringerMode:I
    .restart local v2       #vibrateInNormal:Z
    :cond_34
    const/4 v1, 0x0

    goto :goto_20
.end method
